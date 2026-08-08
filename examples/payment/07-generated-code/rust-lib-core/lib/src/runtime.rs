
use crate::*;
use teaql_core::TeaqlEntity;

use teaql_provider_sqlite::SqliteProviderExt as _;

pub type DataServiceDialect = teaql_provider_sqlite::SqliteDialect;
pub type DataServiceMutationExecutor = teaql_provider_sqlite::SqliteMutationExecutor;
pub type DataServiceMutationError = teaql_provider_sqlite::MutationExecutorError;
pub type DataServiceIdGenerator = teaql_provider_sqlite::SqliteIdSpaceGenerator;
pub type DataServicePool = std::sync::Arc<std::sync::Mutex<rusqlite::Connection>>;
pub type DataServiceExecutor = ServiceRuntimeExecutor;
pub type ServiceRuntime = teaql_runtime::UserContext;

pub const DATABASE_URL_ENV: &str = "PAYMENT_SERVICE_CORE_DATABASE_URL";
#[derive(Clone, Debug, PartialEq, Eq)]
pub struct ServiceRuntimeConfig {
    pub database_url: String,
}

impl ServiceRuntimeConfig {
    pub fn from_env() -> Result<Self, ServiceRuntimeError> {
        Ok(Self {
            database_url: env_value(DATABASE_URL_ENV)?,
        })
    }
}

#[derive(Debug)]
pub enum ServiceRuntimeError {
    MissingEnv {
        name: &'static str,
        source: std::env::VarError,
    },
    ConnectionError(String),
    Rusqlite(rusqlite::Error),
    Runtime(teaql_runtime::RuntimeError),
}

impl std::fmt::Display for ServiceRuntimeError {
    fn fmt(&self, f: &mut std::fmt::Formatter<'_>) -> std::fmt::Result {
        match self {
            ServiceRuntimeError::MissingEnv { name, source } => {
                write!(f, "missing environment variable {name}: {source}")
            }
            ServiceRuntimeError::ConnectionError(err) => write!(f, "connection error: {err}"),
            ServiceRuntimeError::Rusqlite(err) => write!(f, "rusqlite error: {err}"),
            ServiceRuntimeError::Runtime(err) => write!(f, "runtime error: {err}"),
        }
    }
}

impl std::error::Error for ServiceRuntimeError {
    fn source(&self) -> Option<&(dyn std::error::Error + 'static)> {
        match self {
            ServiceRuntimeError::MissingEnv { source, .. } => Some(source),
            ServiceRuntimeError::ConnectionError(_) => None,
            ServiceRuntimeError::Rusqlite(err) => Some(err),
            ServiceRuntimeError::Runtime(err) => Some(err),
        }
    }
}

impl From<rusqlite::Error> for ServiceRuntimeError {
    fn from(err: rusqlite::Error) -> Self {
        ServiceRuntimeError::Rusqlite(err)
    }
}
impl From<teaql_runtime::RuntimeError> for ServiceRuntimeError {
    fn from(err: teaql_runtime::RuntimeError) -> Self {
        ServiceRuntimeError::Runtime(err)
    }
}

#[derive(Clone)]
pub struct LocalSchemaProvider;

impl teaql_data_service::SchemaProvider for LocalSchemaProvider {
    fn get_entity(&self, name: &str) -> Option<std::sync::Arc<teaql_core::EntityDescriptor>> {
        match name {
            "UserAccount" => Some(std::sync::Arc::new(crate::UserAccount::entity_descriptor())),
            "PaymentTransaction" => Some(std::sync::Arc::new(crate::PaymentTransaction::entity_descriptor())),
            _ => None,
        }
    }
}

#[derive(Clone)]
pub struct ServiceRuntimeExecutor {
    inner: teaql_sql::SqlDataServiceExecutor<
        DataServiceDialect,
        DataServiceMutationExecutor,
        LocalSchemaProvider
    >,
}

impl ServiceRuntimeExecutor {
    pub fn new(inner: DataServiceMutationExecutor) -> Self {
        Self {
            inner: teaql_sql::SqlDataServiceExecutor::new(
                DataServiceDialect::default(),
                inner,
                LocalSchemaProvider
            ),
        }
    }

}

impl teaql_data_service::DataServiceExecutor for ServiceRuntimeExecutor {
    type Error = teaql_sql::SqlExecutorError<DataServiceMutationError>;
    fn capabilities(&self) -> teaql_data_service::DataServiceCapabilities {
        teaql_data_service::DataServiceExecutor::capabilities(&self.inner)
    }
}

impl teaql_data_service::QueryExecutor for ServiceRuntimeExecutor {
    async fn query(&self, request: teaql_data_service::QueryRequest) -> Result<teaql_data_service::QueryResult, Self::Error> {
        teaql_data_service::QueryExecutor::query(&self.inner, request).await
    }
}

impl teaql_data_service::StreamQueryExecutor for ServiceRuntimeExecutor {
    async fn query_stream(&self, request: teaql_data_service::QueryRequest, chunk_size: usize) -> Result<Vec<teaql_data_service::StreamChunk>, Self::Error> {
        teaql_data_service::StreamQueryExecutor::query_stream(&self.inner, request, chunk_size).await
    }
}

impl teaql_data_service::MutationExecutor for ServiceRuntimeExecutor {
    async fn mutate(&self, request: teaql_data_service::MutationRequest) -> Result<teaql_data_service::MutationResult, Self::Error> {
        teaql_data_service::MutationExecutor::mutate(&self.inner, request).await
    }
}

impl teaql_data_service::TransactionExecutor for ServiceRuntimeExecutor {
    type Tx<'a> = teaql_sql::SqlDataServiceTransaction<'a, DataServiceDialect, <DataServiceMutationExecutor as teaql_sql::SqlTransactionTransport>::Tx<'a>, LocalSchemaProvider> where Self: 'a;

    async fn begin(&self) -> Result<Self::Tx<'_ >, Self::Error> {
        teaql_data_service::TransactionExecutor::begin(&self.inner).await
    }
}

pub async fn service_runtime_from_env() -> Result<ServiceRuntime, ServiceRuntimeError> {
    service_runtime(ServiceRuntimeConfig::from_env()?).await
}

pub async fn service_runtime(config: ServiceRuntimeConfig) -> Result<ServiceRuntime, ServiceRuntimeError> {
    let pool = connect_data_service_pool(&config).await?;
    service_runtime_from_pool(pool).await
}

pub async fn service_runtime_from_pool(pool: DataServicePool) -> Result<ServiceRuntime, ServiceRuntimeError> {
    let mutation_executor = DataServiceMutationExecutor::new(pool);
    let id_generator = DataServiceIdGenerator::from_executor(mutation_executor.clone());let mut context = module_with_behaviors_and_checkers().into_context();
    context.set_internal_id_generator(id_generator);
    context.use_sqlite_provider(mutation_executor.clone());
    let executor = ServiceRuntimeExecutor::new(mutation_executor);
    context.register_executor(executor.clone());
    context.insert_resource(executor);

    // 自动加载 Zero-Code 审计配置与 Schema 模式
    let env_config = teaql_tool_core::audit_config_from_env(&[
        "user_account_data", "payment_transaction_data"
    ]);
    let schema_mode = env_config.schema_mode;
    context.insert_resource(env_config.config.clone());
    context.insert_resource(env_config);

    match schema_mode {
        teaql_tool_core::SchemaMode::Execute => {
            context.ensure_schema().await?;
        }
        teaql_tool_core::SchemaMode::DryRun => {
            // DryRun: 目前等效于验证
            context.ensure_schema().await?;
        }
        teaql_tool_core::SchemaMode::Verify => {
            context.ensure_schema().await?;
        }
    }

    Ok(context)
}



fn env_value(name: &'static str) -> Result<String, ServiceRuntimeError> {
    std::env::var(name).map_err(|source| ServiceRuntimeError::MissingEnv { name, source })
}

async fn connect_data_service_pool(config: &ServiceRuntimeConfig) -> Result<DataServicePool, ServiceRuntimeError> {
    let url = &config.database_url;
    let sanitized_url = if url.starts_with("sqlite:") { url.strip_prefix("sqlite:").unwrap().trim_start_matches("//") } else { url };
    let pure_file_path = sanitized_url.split('?').next().unwrap_or(sanitized_url);
    let path = std::path::Path::new(pure_file_path);
    if let Some(parent) = path.parent() { if !parent.as_os_str().is_empty() { std::fs::create_dir_all(parent).map_err(|e| ServiceRuntimeError::ConnectionError(e.to_string()))?; } }
    Ok(std::sync::Arc::new(std::sync::Mutex::new(rusqlite::Connection::open(pure_file_path).map_err(|e| ServiceRuntimeError::ConnectionError(e.to_string()))?)))
}

pub fn repository_registry() -> teaql_runtime::InMemoryEntityRegistry {
    teaql_runtime::InMemoryEntityRegistry::new()
        .with_entity("UserAccount")
        .with_entity("PaymentTransaction")
}

pub fn behavior_registry() -> teaql_runtime::InMemoryEntityDataServiceBehaviorRegistry {
    teaql_runtime::InMemoryEntityDataServiceBehaviorRegistry::new()
        .with_behavior("UserAccount", UserAccountBehavior::default())
        .with_behavior("PaymentTransaction", PaymentTransactionBehavior::default())
}

pub fn checker_registry() -> teaql_runtime::InMemoryCheckerRegistry {
    teaql_runtime::InMemoryCheckerRegistry::new()
        .with_checker(teaql_runtime::TypedEntityChecker::<UserAccount, _>::new(UserAccountChecker::default()))
        .with_checker(teaql_runtime::TypedEntityChecker::<PaymentTransaction, _>::new(PaymentTransactionChecker::default()))
}

pub fn module() -> teaql_runtime::RuntimeModule {
    teaql_runtime::RuntimeModule::new()
        .entity::<UserAccount>()
        .entity::<PaymentTransaction>()
        .initial_graph(teaql_runtime::GraphNode::new("UserAccount")
            .value("id", 1_u64)
            .value("user_name", "string()")
            .value("create_time", teaql_core::time::Timestamp::now())
            .value("update_time", teaql_core::time::Timestamp::now())
            .value("version", 1_i64))
        .initial_graph(teaql_runtime::GraphNode::new("PaymentTransaction")
            .value("id", 1_u64)
            .value("payment_account", "string()")
            .value("currency_code", "string()")
            .value("payment_method", "string()")
            .value("transaction_amount", "150.00")
            .value("create_time", teaql_core::time::Timestamp::now())
            .value("update_time", teaql_core::time::Timestamp::now())
            .value("version", 1_i64))
}

pub fn module_with_checkers() -> teaql_runtime::RuntimeModule {
    teaql_runtime::RuntimeModule::new()
        .entity::<UserAccount>()
        .checker(teaql_runtime::TypedEntityChecker::<UserAccount, _>::new(UserAccountChecker::default()))
        .entity::<PaymentTransaction>()
        .checker(teaql_runtime::TypedEntityChecker::<PaymentTransaction, _>::new(PaymentTransactionChecker::default()))
        .initial_graph(teaql_runtime::GraphNode::new("UserAccount")
            .value("id", 1_u64)
            .value("user_name", "string()")
            .value("create_time", teaql_core::time::Timestamp::now())
            .value("update_time", teaql_core::time::Timestamp::now())
            .value("version", 1_i64))
        .initial_graph(teaql_runtime::GraphNode::new("PaymentTransaction")
            .value("id", 1_u64)
            .value("payment_account", "string()")
            .value("currency_code", "string()")
            .value("payment_method", "string()")
            .value("transaction_amount", "150.00")
            .value("create_time", teaql_core::time::Timestamp::now())
            .value("update_time", teaql_core::time::Timestamp::now())
            .value("version", 1_i64))
}

pub fn module_with_behaviors() -> teaql_runtime::RuntimeModule {
    teaql_runtime::RuntimeModule::new()
        .entity_with_behavior::<UserAccount, _>(UserAccountBehavior::default())
        .entity_with_behavior::<PaymentTransaction, _>(PaymentTransactionBehavior::default())
        .initial_graph(teaql_runtime::GraphNode::new("UserAccount")
            .value("id", 1_u64)
            .value("user_name", "string()")
            .value("create_time", teaql_core::time::Timestamp::now())
            .value("update_time", teaql_core::time::Timestamp::now())
            .value("version", 1_i64))
        .initial_graph(teaql_runtime::GraphNode::new("PaymentTransaction")
            .value("id", 1_u64)
            .value("payment_account", "string()")
            .value("currency_code", "string()")
            .value("payment_method", "string()")
            .value("transaction_amount", "150.00")
            .value("create_time", teaql_core::time::Timestamp::now())
            .value("update_time", teaql_core::time::Timestamp::now())
            .value("version", 1_i64))
}

pub fn module_with_behaviors_and_checkers() -> teaql_runtime::RuntimeModule {
    teaql_runtime::RuntimeModule::new()
        .entity_with_behavior::<UserAccount, _>(UserAccountBehavior::default())
        .checker(teaql_runtime::TypedEntityChecker::<UserAccount, _>::new(UserAccountChecker::default()))
        .entity_with_behavior::<PaymentTransaction, _>(PaymentTransactionBehavior::default())
        .checker(teaql_runtime::TypedEntityChecker::<PaymentTransaction, _>::new(PaymentTransactionChecker::default()))
        .initial_graph(teaql_runtime::GraphNode::new("UserAccount")
            .value("id", 1_u64)
            .value("user_name", "string()")
            .value("create_time", teaql_core::time::Timestamp::now())
            .value("update_time", teaql_core::time::Timestamp::now())
            .value("version", 1_i64))
        .initial_graph(teaql_runtime::GraphNode::new("PaymentTransaction")
            .value("id", 1_u64)
            .value("payment_account", "string()")
            .value("currency_code", "string()")
            .value("payment_method", "string()")
            .value("transaction_amount", "150.00")
            .value("create_time", teaql_core::time::Timestamp::now())
            .value("update_time", teaql_core::time::Timestamp::now())
            .value("version", 1_i64))
}