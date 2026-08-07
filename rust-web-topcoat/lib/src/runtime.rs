
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

pub const DATABASE_URL_ENV: &str = "ENTERPRISE_ERP_SYSTEM_CORE_DATABASE_URL";
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
            "Employee" => Some(std::sync::Arc::new(crate::Employee::entity_descriptor())),
            "Department" => Some(std::sync::Arc::new(crate::Department::entity_descriptor())),
            "Position" => Some(std::sync::Arc::new(crate::Position::entity_descriptor())),
            "LeaveRequest" => Some(std::sync::Arc::new(crate::LeaveRequest::entity_descriptor())),
            "Attendance" => Some(std::sync::Arc::new(crate::Attendance::entity_descriptor())),
            "Benefit" => Some(std::sync::Arc::new(crate::Benefit::entity_descriptor())),
            "EmployeeReview" => Some(std::sync::Arc::new(crate::EmployeeReview::entity_descriptor())),
            "Payroll" => Some(std::sync::Arc::new(crate::Payroll::entity_descriptor())),
            "Customer" => Some(std::sync::Arc::new(crate::Customer::entity_descriptor())),
            "Lead" => Some(std::sync::Arc::new(crate::Lead::entity_descriptor())),
            "Opportunity" => Some(std::sync::Arc::new(crate::Opportunity::entity_descriptor())),
            "Contact" => Some(std::sync::Arc::new(crate::Contact::entity_descriptor())),
            "Campaign" => Some(std::sync::Arc::new(crate::Campaign::entity_descriptor())),
            "Contract" => Some(std::sync::Arc::new(crate::Contract::entity_descriptor())),
            "Quote" => Some(std::sync::Arc::new(crate::Quote::entity_descriptor())),
            "SalesTerritory" => Some(std::sync::Arc::new(crate::SalesTerritory::entity_descriptor())),
            "Product" => Some(std::sync::Arc::new(crate::Product::entity_descriptor())),
            "Category" => Some(std::sync::Arc::new(crate::Category::entity_descriptor())),
            "Catalog" => Some(std::sync::Arc::new(crate::Catalog::entity_descriptor())),
            "ProductReview" => Some(std::sync::Arc::new(crate::ProductReview::entity_descriptor())),
            "ShoppingCart" => Some(std::sync::Arc::new(crate::ShoppingCart::entity_descriptor())),
            "CartItem" => Some(std::sync::Arc::new(crate::CartItem::entity_descriptor())),
            "GlobalOrder" => Some(std::sync::Arc::new(crate::GlobalOrder::entity_descriptor())),
            "OrderItem" => Some(std::sync::Arc::new(crate::OrderItem::entity_descriptor())),
            "Wishlist" => Some(std::sync::Arc::new(crate::Wishlist::entity_descriptor())),
            "Promotion" => Some(std::sync::Arc::new(crate::Promotion::entity_descriptor())),
            "Coupon" => Some(std::sync::Arc::new(crate::Coupon::entity_descriptor())),
            "Invoice" => Some(std::sync::Arc::new(crate::Invoice::entity_descriptor())),
            "Payment" => Some(std::sync::Arc::new(crate::Payment::entity_descriptor())),
            "Refund" => Some(std::sync::Arc::new(crate::Refund::entity_descriptor())),
            "Account" => Some(std::sync::Arc::new(crate::Account::entity_descriptor())),
            "Transaction" => Some(std::sync::Arc::new(crate::Transaction::entity_descriptor())),
            "TaxRate" => Some(std::sync::Arc::new(crate::TaxRate::entity_descriptor())),
            "Expense" => Some(std::sync::Arc::new(crate::Expense::entity_descriptor())),
            "Ledger" => Some(std::sync::Arc::new(crate::Ledger::entity_descriptor())),
            "Supplier" => Some(std::sync::Arc::new(crate::Supplier::entity_descriptor())),
            "Warehouse" => Some(std::sync::Arc::new(crate::Warehouse::entity_descriptor())),
            "InventoryItem" => Some(std::sync::Arc::new(crate::InventoryItem::entity_descriptor())),
            "PurchaseOrder" => Some(std::sync::Arc::new(crate::PurchaseOrder::entity_descriptor())),
            "PurchaseOrderItem" => Some(std::sync::Arc::new(crate::PurchaseOrderItem::entity_descriptor())),
            "Shipment" => Some(std::sync::Arc::new(crate::Shipment::entity_descriptor())),
            "Delivery" => Some(std::sync::Arc::new(crate::Delivery::entity_descriptor())),
            "ReturnRequest" => Some(std::sync::Arc::new(crate::ReturnRequest::entity_descriptor())),
            "Ticket" => Some(std::sync::Arc::new(crate::Ticket::entity_descriptor())),
            "TicketComment" => Some(std::sync::Arc::new(crate::TicketComment::entity_descriptor())),
            "Sla" => Some(std::sync::Arc::new(crate::Sla::entity_descriptor())),
            "KnowledgeBase" => Some(std::sync::Arc::new(crate::KnowledgeBase::entity_descriptor())),
            "SupportAgent" => Some(std::sync::Arc::new(crate::SupportAgent::entity_descriptor())),
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
        "employee_data", "department_data", "position_data", "leave_request_data", "attendance_data", "benefit_data", "employee_review_data", "payroll_data", "customer_data", "lead_data", "opportunity_data", "contact_data", "campaign_data", "contract_data", "quote_data", "sales_territory_data", "product_data", "category_data", "catalog_data", "product_review_data", "shopping_cart_data", "cart_item_data", "global_order_data", "order_item_data", "wishlist_data", "promotion_data", "coupon_data", "invoice_data", "payment_data", "refund_data", "account_data", "transaction_data", "tax_rate_data", "expense_data", "ledger_data", "supplier_data", "warehouse_data", "inventory_item_data", "purchase_order_data", "purchase_order_item_data", "shipment_data", "delivery_data", "return_request_data", "ticket_data", "ticket_comment_data", "sla_data", "knowledge_base_data", "support_agent_data"
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
        .with_entity("Employee")
        .with_entity("Department")
        .with_entity("Position")
        .with_entity("LeaveRequest")
        .with_entity("Attendance")
        .with_entity("Benefit")
        .with_entity("EmployeeReview")
        .with_entity("Payroll")
        .with_entity("Customer")
        .with_entity("Lead")
        .with_entity("Opportunity")
        .with_entity("Contact")
        .with_entity("Campaign")
        .with_entity("Contract")
        .with_entity("Quote")
        .with_entity("SalesTerritory")
        .with_entity("Product")
        .with_entity("Category")
        .with_entity("Catalog")
        .with_entity("ProductReview")
        .with_entity("ShoppingCart")
        .with_entity("CartItem")
        .with_entity("GlobalOrder")
        .with_entity("OrderItem")
        .with_entity("Wishlist")
        .with_entity("Promotion")
        .with_entity("Coupon")
        .with_entity("Invoice")
        .with_entity("Payment")
        .with_entity("Refund")
        .with_entity("Account")
        .with_entity("Transaction")
        .with_entity("TaxRate")
        .with_entity("Expense")
        .with_entity("Ledger")
        .with_entity("Supplier")
        .with_entity("Warehouse")
        .with_entity("InventoryItem")
        .with_entity("PurchaseOrder")
        .with_entity("PurchaseOrderItem")
        .with_entity("Shipment")
        .with_entity("Delivery")
        .with_entity("ReturnRequest")
        .with_entity("Ticket")
        .with_entity("TicketComment")
        .with_entity("Sla")
        .with_entity("KnowledgeBase")
        .with_entity("SupportAgent")
}

pub fn behavior_registry() -> teaql_runtime::InMemoryEntityDataServiceBehaviorRegistry {
    teaql_runtime::InMemoryEntityDataServiceBehaviorRegistry::new()
        .with_behavior("Employee", EmployeeBehavior::default())
        .with_behavior("Department", DepartmentBehavior::default())
        .with_behavior("Position", PositionBehavior::default())
        .with_behavior("LeaveRequest", LeaveRequestBehavior::default())
        .with_behavior("Attendance", AttendanceBehavior::default())
        .with_behavior("Benefit", BenefitBehavior::default())
        .with_behavior("EmployeeReview", EmployeeReviewBehavior::default())
        .with_behavior("Payroll", PayrollBehavior::default())
        .with_behavior("Customer", CustomerBehavior::default())
        .with_behavior("Lead", LeadBehavior::default())
        .with_behavior("Opportunity", OpportunityBehavior::default())
        .with_behavior("Contact", ContactBehavior::default())
        .with_behavior("Campaign", CampaignBehavior::default())
        .with_behavior("Contract", ContractBehavior::default())
        .with_behavior("Quote", QuoteBehavior::default())
        .with_behavior("SalesTerritory", SalesTerritoryBehavior::default())
        .with_behavior("Product", ProductBehavior::default())
        .with_behavior("Category", CategoryBehavior::default())
        .with_behavior("Catalog", CatalogBehavior::default())
        .with_behavior("ProductReview", ProductReviewBehavior::default())
        .with_behavior("ShoppingCart", ShoppingCartBehavior::default())
        .with_behavior("CartItem", CartItemBehavior::default())
        .with_behavior("GlobalOrder", GlobalOrderBehavior::default())
        .with_behavior("OrderItem", OrderItemBehavior::default())
        .with_behavior("Wishlist", WishlistBehavior::default())
        .with_behavior("Promotion", PromotionBehavior::default())
        .with_behavior("Coupon", CouponBehavior::default())
        .with_behavior("Invoice", InvoiceBehavior::default())
        .with_behavior("Payment", PaymentBehavior::default())
        .with_behavior("Refund", RefundBehavior::default())
        .with_behavior("Account", AccountBehavior::default())
        .with_behavior("Transaction", TransactionBehavior::default())
        .with_behavior("TaxRate", TaxRateBehavior::default())
        .with_behavior("Expense", ExpenseBehavior::default())
        .with_behavior("Ledger", LedgerBehavior::default())
        .with_behavior("Supplier", SupplierBehavior::default())
        .with_behavior("Warehouse", WarehouseBehavior::default())
        .with_behavior("InventoryItem", InventoryItemBehavior::default())
        .with_behavior("PurchaseOrder", PurchaseOrderBehavior::default())
        .with_behavior("PurchaseOrderItem", PurchaseOrderItemBehavior::default())
        .with_behavior("Shipment", ShipmentBehavior::default())
        .with_behavior("Delivery", DeliveryBehavior::default())
        .with_behavior("ReturnRequest", ReturnRequestBehavior::default())
        .with_behavior("Ticket", TicketBehavior::default())
        .with_behavior("TicketComment", TicketCommentBehavior::default())
        .with_behavior("Sla", SlaBehavior::default())
        .with_behavior("KnowledgeBase", KnowledgeBaseBehavior::default())
        .with_behavior("SupportAgent", SupportAgentBehavior::default())
}

pub fn checker_registry() -> teaql_runtime::InMemoryCheckerRegistry {
    teaql_runtime::InMemoryCheckerRegistry::new()
        .with_checker(teaql_runtime::TypedEntityChecker::<Employee, _>::new(EmployeeChecker::default()))
        .with_checker(teaql_runtime::TypedEntityChecker::<Department, _>::new(DepartmentChecker::default()))
        .with_checker(teaql_runtime::TypedEntityChecker::<Position, _>::new(PositionChecker::default()))
        .with_checker(teaql_runtime::TypedEntityChecker::<LeaveRequest, _>::new(LeaveRequestChecker::default()))
        .with_checker(teaql_runtime::TypedEntityChecker::<Attendance, _>::new(AttendanceChecker::default()))
        .with_checker(teaql_runtime::TypedEntityChecker::<Benefit, _>::new(BenefitChecker::default()))
        .with_checker(teaql_runtime::TypedEntityChecker::<EmployeeReview, _>::new(EmployeeReviewChecker::default()))
        .with_checker(teaql_runtime::TypedEntityChecker::<Payroll, _>::new(PayrollChecker::default()))
        .with_checker(teaql_runtime::TypedEntityChecker::<Customer, _>::new(CustomerChecker::default()))
        .with_checker(teaql_runtime::TypedEntityChecker::<Lead, _>::new(LeadChecker::default()))
        .with_checker(teaql_runtime::TypedEntityChecker::<Opportunity, _>::new(OpportunityChecker::default()))
        .with_checker(teaql_runtime::TypedEntityChecker::<Contact, _>::new(ContactChecker::default()))
        .with_checker(teaql_runtime::TypedEntityChecker::<Campaign, _>::new(CampaignChecker::default()))
        .with_checker(teaql_runtime::TypedEntityChecker::<Contract, _>::new(ContractChecker::default()))
        .with_checker(teaql_runtime::TypedEntityChecker::<Quote, _>::new(QuoteChecker::default()))
        .with_checker(teaql_runtime::TypedEntityChecker::<SalesTerritory, _>::new(SalesTerritoryChecker::default()))
        .with_checker(teaql_runtime::TypedEntityChecker::<Product, _>::new(ProductChecker::default()))
        .with_checker(teaql_runtime::TypedEntityChecker::<Category, _>::new(CategoryChecker::default()))
        .with_checker(teaql_runtime::TypedEntityChecker::<Catalog, _>::new(CatalogChecker::default()))
        .with_checker(teaql_runtime::TypedEntityChecker::<ProductReview, _>::new(ProductReviewChecker::default()))
        .with_checker(teaql_runtime::TypedEntityChecker::<ShoppingCart, _>::new(ShoppingCartChecker::default()))
        .with_checker(teaql_runtime::TypedEntityChecker::<CartItem, _>::new(CartItemChecker::default()))
        .with_checker(teaql_runtime::TypedEntityChecker::<GlobalOrder, _>::new(GlobalOrderChecker::default()))
        .with_checker(teaql_runtime::TypedEntityChecker::<OrderItem, _>::new(OrderItemChecker::default()))
        .with_checker(teaql_runtime::TypedEntityChecker::<Wishlist, _>::new(WishlistChecker::default()))
        .with_checker(teaql_runtime::TypedEntityChecker::<Promotion, _>::new(PromotionChecker::default()))
        .with_checker(teaql_runtime::TypedEntityChecker::<Coupon, _>::new(CouponChecker::default()))
        .with_checker(teaql_runtime::TypedEntityChecker::<Invoice, _>::new(InvoiceChecker::default()))
        .with_checker(teaql_runtime::TypedEntityChecker::<Payment, _>::new(PaymentChecker::default()))
        .with_checker(teaql_runtime::TypedEntityChecker::<Refund, _>::new(RefundChecker::default()))
        .with_checker(teaql_runtime::TypedEntityChecker::<Account, _>::new(AccountChecker::default()))
        .with_checker(teaql_runtime::TypedEntityChecker::<Transaction, _>::new(TransactionChecker::default()))
        .with_checker(teaql_runtime::TypedEntityChecker::<TaxRate, _>::new(TaxRateChecker::default()))
        .with_checker(teaql_runtime::TypedEntityChecker::<Expense, _>::new(ExpenseChecker::default()))
        .with_checker(teaql_runtime::TypedEntityChecker::<Ledger, _>::new(LedgerChecker::default()))
        .with_checker(teaql_runtime::TypedEntityChecker::<Supplier, _>::new(SupplierChecker::default()))
        .with_checker(teaql_runtime::TypedEntityChecker::<Warehouse, _>::new(WarehouseChecker::default()))
        .with_checker(teaql_runtime::TypedEntityChecker::<InventoryItem, _>::new(InventoryItemChecker::default()))
        .with_checker(teaql_runtime::TypedEntityChecker::<PurchaseOrder, _>::new(PurchaseOrderChecker::default()))
        .with_checker(teaql_runtime::TypedEntityChecker::<PurchaseOrderItem, _>::new(PurchaseOrderItemChecker::default()))
        .with_checker(teaql_runtime::TypedEntityChecker::<Shipment, _>::new(ShipmentChecker::default()))
        .with_checker(teaql_runtime::TypedEntityChecker::<Delivery, _>::new(DeliveryChecker::default()))
        .with_checker(teaql_runtime::TypedEntityChecker::<ReturnRequest, _>::new(ReturnRequestChecker::default()))
        .with_checker(teaql_runtime::TypedEntityChecker::<Ticket, _>::new(TicketChecker::default()))
        .with_checker(teaql_runtime::TypedEntityChecker::<TicketComment, _>::new(TicketCommentChecker::default()))
        .with_checker(teaql_runtime::TypedEntityChecker::<Sla, _>::new(SlaChecker::default()))
        .with_checker(teaql_runtime::TypedEntityChecker::<KnowledgeBase, _>::new(KnowledgeBaseChecker::default()))
        .with_checker(teaql_runtime::TypedEntityChecker::<SupportAgent, _>::new(SupportAgentChecker::default()))
}

pub fn module() -> teaql_runtime::RuntimeModule {
    teaql_runtime::RuntimeModule::new()
        .entity::<Employee>()
        .entity::<Department>()
        .entity::<Position>()
        .entity::<LeaveRequest>()
        .entity::<Attendance>()
        .entity::<Benefit>()
        .entity::<EmployeeReview>()
        .entity::<Payroll>()
        .entity::<Customer>()
        .entity::<Lead>()
        .entity::<Opportunity>()
        .entity::<Contact>()
        .entity::<Campaign>()
        .entity::<Contract>()
        .entity::<Quote>()
        .entity::<SalesTerritory>()
        .entity::<Product>()
        .entity::<Category>()
        .entity::<Catalog>()
        .entity::<ProductReview>()
        .entity::<ShoppingCart>()
        .entity::<CartItem>()
        .entity::<GlobalOrder>()
        .entity::<OrderItem>()
        .entity::<Wishlist>()
        .entity::<Promotion>()
        .entity::<Coupon>()
        .entity::<Invoice>()
        .entity::<Payment>()
        .entity::<Refund>()
        .entity::<Account>()
        .entity::<Transaction>()
        .entity::<TaxRate>()
        .entity::<Expense>()
        .entity::<Ledger>()
        .entity::<Supplier>()
        .entity::<Warehouse>()
        .entity::<InventoryItem>()
        .entity::<PurchaseOrder>()
        .entity::<PurchaseOrderItem>()
        .entity::<Shipment>()
        .entity::<Delivery>()
        .entity::<ReturnRequest>()
        .entity::<Ticket>()
        .entity::<TicketComment>()
        .entity::<Sla>()
        .entity::<KnowledgeBase>()
        .entity::<SupportAgent>()
        .initial_graph(teaql_runtime::GraphNode::new("Department")
            .value("id", 1_u64)
            .value("name", "name_value")
            .value("budget", "100.00")
            .value("location", "location_value")
            .value("manager_id", "manager_id_value")
            .value("create_time", teaql_core::time::Timestamp::now())
            .value("update_time", teaql_core::time::Timestamp::now())
            .value("version", 1_i64))
        .initial_graph(teaql_runtime::GraphNode::new("Position")
            .value("id", 1_u64)
            .value("max_salary", "100.00")
            .value("min_salary", "100.00")
            .value("title", "title_value")
            .value("create_time", teaql_core::time::Timestamp::now())
            .value("update_time", teaql_core::time::Timestamp::now())
            .value("version", 1_i64))
        .initial_graph(teaql_runtime::GraphNode::new("Customer")
            .value("id", 1_u64)
            .value("address", "address_value")
            .value("email", "email_value")
            .value("name", "name_value")
            .value("phone", "phone_value")
            .value("created_at", teaql_core::time::Timestamp::now())
            .value("loyalty_points", "100.00")
            .value("create_time", teaql_core::time::Timestamp::now())
            .value("update_time", teaql_core::time::Timestamp::now())
            .value("version", 1_i64))
        .initial_graph(teaql_runtime::GraphNode::new("Lead")
            .value("id", 1_u64)
            .value("email", "email_value")
            .value("name", "name_value")
            .value("phone", "phone_value")
            .value("converted_customer_id", "converted_customer_id_value")
            .value("source", "source_value")
            .value("status", "status_value")
            .value("create_time", teaql_core::time::Timestamp::now())
            .value("update_time", teaql_core::time::Timestamp::now())
            .value("version", 1_i64))
        .initial_graph(teaql_runtime::GraphNode::new("Campaign")
            .value("id", 1_u64)
            .value("name", "name_value")
            .value("budget", "100.00")
            .value("end_date", teaql_core::time::Timestamp::now())
            .value("start_date", teaql_core::time::Timestamp::now())
            .value("status", "status_value")
            .value("create_time", teaql_core::time::Timestamp::now())
            .value("update_time", teaql_core::time::Timestamp::now())
            .value("version", 1_i64))
        .initial_graph(teaql_runtime::GraphNode::new("SalesTerritory")
            .value("id", 1_u64)
            .value("name", "name_value")
            .value("manager_id", "manager_id_value")
            .value("region", "region_value")
            .value("create_time", teaql_core::time::Timestamp::now())
            .value("update_time", teaql_core::time::Timestamp::now())
            .value("version", 1_i64))
        .initial_graph(teaql_runtime::GraphNode::new("Category")
            .value("id", 1_u64)
            .value("description", "description_value")
            .value("name", "name_value")
            .value("parent_id", "parent_id_value")
            .value("create_time", teaql_core::time::Timestamp::now())
            .value("update_time", teaql_core::time::Timestamp::now())
            .value("version", 1_i64))
        .initial_graph(teaql_runtime::GraphNode::new("Catalog")
            .value("id", 1_u64)
            .value("name", "name_value")
            .value("season", "season_value")
            .value("valid_from", teaql_core::time::Timestamp::now())
            .value("valid_to", teaql_core::time::Timestamp::now())
            .value("create_time", teaql_core::time::Timestamp::now())
            .value("update_time", teaql_core::time::Timestamp::now())
            .value("version", 1_i64))
        .initial_graph(teaql_runtime::GraphNode::new("Promotion")
            .value("id", 1_u64)
            .value("name", "name_value")
            .value("discount_percentage", "100.00")
            .value("end_date", teaql_core::time::Timestamp::now())
            .value("start_date", teaql_core::time::Timestamp::now())
            .value("create_time", teaql_core::time::Timestamp::now())
            .value("update_time", teaql_core::time::Timestamp::now())
            .value("version", 1_i64))
        .initial_graph(teaql_runtime::GraphNode::new("Account")
            .value("id", 1_u64)
            .value("name", "name_value")
            .value("account_type", "account_type_value")
            .value("balance", "100.00")
            .value("currency", "currency_value")
            .value("create_time", teaql_core::time::Timestamp::now())
            .value("update_time", teaql_core::time::Timestamp::now())
            .value("version", 1_i64))
        .initial_graph(teaql_runtime::GraphNode::new("TaxRate")
            .value("id", 1_u64)
            .value("is_active", true)
            .value("rate", "100.00")
            .value("region", "region_value")
            .value("create_time", teaql_core::time::Timestamp::now())
            .value("update_time", teaql_core::time::Timestamp::now())
            .value("version", 1_i64))
        .initial_graph(teaql_runtime::GraphNode::new("Supplier")
            .value("id", 1_u64)
            .value("address", "address_value")
            .value("contact_email", "contact_email_value")
            .value("name", "name_value")
            .value("phone", "phone_value")
            .value("rating", "100.00")
            .value("create_time", teaql_core::time::Timestamp::now())
            .value("update_time", teaql_core::time::Timestamp::now())
            .value("version", 1_i64))
        .initial_graph(teaql_runtime::GraphNode::new("Warehouse")
            .value("id", 1_u64)
            .value("name", "name_value")
            .value("capacity", "100.00")
            .value("location", "location_value")
            .value("manager_id", "manager_id_value")
            .value("create_time", teaql_core::time::Timestamp::now())
            .value("update_time", teaql_core::time::Timestamp::now())
            .value("version", 1_i64))
        .initial_graph(teaql_runtime::GraphNode::new("Sla")
            .value("id", 1_u64)
            .value("is_active", true)
            .value("priority_level", "priority_level_value")
            .value("resolution_hours", "100.00")
            .value("create_time", teaql_core::time::Timestamp::now())
            .value("update_time", teaql_core::time::Timestamp::now())
            .value("version", 1_i64))
        .initial_graph(teaql_runtime::GraphNode::new("KnowledgeBase")
            .value("id", 1_u64)
            .value("category", "category_value")
            .value("content", "content_value")
            .value("title", "title_value")
            .value("views", "100.00")
            .value("create_time", teaql_core::time::Timestamp::now())
            .value("update_time", teaql_core::time::Timestamp::now())
            .value("version", 1_i64))
}

pub fn module_with_checkers() -> teaql_runtime::RuntimeModule {
    teaql_runtime::RuntimeModule::new()
        .entity::<Employee>()
        .checker(teaql_runtime::TypedEntityChecker::<Employee, _>::new(EmployeeChecker::default()))
        .entity::<Department>()
        .checker(teaql_runtime::TypedEntityChecker::<Department, _>::new(DepartmentChecker::default()))
        .entity::<Position>()
        .checker(teaql_runtime::TypedEntityChecker::<Position, _>::new(PositionChecker::default()))
        .entity::<LeaveRequest>()
        .checker(teaql_runtime::TypedEntityChecker::<LeaveRequest, _>::new(LeaveRequestChecker::default()))
        .entity::<Attendance>()
        .checker(teaql_runtime::TypedEntityChecker::<Attendance, _>::new(AttendanceChecker::default()))
        .entity::<Benefit>()
        .checker(teaql_runtime::TypedEntityChecker::<Benefit, _>::new(BenefitChecker::default()))
        .entity::<EmployeeReview>()
        .checker(teaql_runtime::TypedEntityChecker::<EmployeeReview, _>::new(EmployeeReviewChecker::default()))
        .entity::<Payroll>()
        .checker(teaql_runtime::TypedEntityChecker::<Payroll, _>::new(PayrollChecker::default()))
        .entity::<Customer>()
        .checker(teaql_runtime::TypedEntityChecker::<Customer, _>::new(CustomerChecker::default()))
        .entity::<Lead>()
        .checker(teaql_runtime::TypedEntityChecker::<Lead, _>::new(LeadChecker::default()))
        .entity::<Opportunity>()
        .checker(teaql_runtime::TypedEntityChecker::<Opportunity, _>::new(OpportunityChecker::default()))
        .entity::<Contact>()
        .checker(teaql_runtime::TypedEntityChecker::<Contact, _>::new(ContactChecker::default()))
        .entity::<Campaign>()
        .checker(teaql_runtime::TypedEntityChecker::<Campaign, _>::new(CampaignChecker::default()))
        .entity::<Contract>()
        .checker(teaql_runtime::TypedEntityChecker::<Contract, _>::new(ContractChecker::default()))
        .entity::<Quote>()
        .checker(teaql_runtime::TypedEntityChecker::<Quote, _>::new(QuoteChecker::default()))
        .entity::<SalesTerritory>()
        .checker(teaql_runtime::TypedEntityChecker::<SalesTerritory, _>::new(SalesTerritoryChecker::default()))
        .entity::<Product>()
        .checker(teaql_runtime::TypedEntityChecker::<Product, _>::new(ProductChecker::default()))
        .entity::<Category>()
        .checker(teaql_runtime::TypedEntityChecker::<Category, _>::new(CategoryChecker::default()))
        .entity::<Catalog>()
        .checker(teaql_runtime::TypedEntityChecker::<Catalog, _>::new(CatalogChecker::default()))
        .entity::<ProductReview>()
        .checker(teaql_runtime::TypedEntityChecker::<ProductReview, _>::new(ProductReviewChecker::default()))
        .entity::<ShoppingCart>()
        .checker(teaql_runtime::TypedEntityChecker::<ShoppingCart, _>::new(ShoppingCartChecker::default()))
        .entity::<CartItem>()
        .checker(teaql_runtime::TypedEntityChecker::<CartItem, _>::new(CartItemChecker::default()))
        .entity::<GlobalOrder>()
        .checker(teaql_runtime::TypedEntityChecker::<GlobalOrder, _>::new(GlobalOrderChecker::default()))
        .entity::<OrderItem>()
        .checker(teaql_runtime::TypedEntityChecker::<OrderItem, _>::new(OrderItemChecker::default()))
        .entity::<Wishlist>()
        .checker(teaql_runtime::TypedEntityChecker::<Wishlist, _>::new(WishlistChecker::default()))
        .entity::<Promotion>()
        .checker(teaql_runtime::TypedEntityChecker::<Promotion, _>::new(PromotionChecker::default()))
        .entity::<Coupon>()
        .checker(teaql_runtime::TypedEntityChecker::<Coupon, _>::new(CouponChecker::default()))
        .entity::<Invoice>()
        .checker(teaql_runtime::TypedEntityChecker::<Invoice, _>::new(InvoiceChecker::default()))
        .entity::<Payment>()
        .checker(teaql_runtime::TypedEntityChecker::<Payment, _>::new(PaymentChecker::default()))
        .entity::<Refund>()
        .checker(teaql_runtime::TypedEntityChecker::<Refund, _>::new(RefundChecker::default()))
        .entity::<Account>()
        .checker(teaql_runtime::TypedEntityChecker::<Account, _>::new(AccountChecker::default()))
        .entity::<Transaction>()
        .checker(teaql_runtime::TypedEntityChecker::<Transaction, _>::new(TransactionChecker::default()))
        .entity::<TaxRate>()
        .checker(teaql_runtime::TypedEntityChecker::<TaxRate, _>::new(TaxRateChecker::default()))
        .entity::<Expense>()
        .checker(teaql_runtime::TypedEntityChecker::<Expense, _>::new(ExpenseChecker::default()))
        .entity::<Ledger>()
        .checker(teaql_runtime::TypedEntityChecker::<Ledger, _>::new(LedgerChecker::default()))
        .entity::<Supplier>()
        .checker(teaql_runtime::TypedEntityChecker::<Supplier, _>::new(SupplierChecker::default()))
        .entity::<Warehouse>()
        .checker(teaql_runtime::TypedEntityChecker::<Warehouse, _>::new(WarehouseChecker::default()))
        .entity::<InventoryItem>()
        .checker(teaql_runtime::TypedEntityChecker::<InventoryItem, _>::new(InventoryItemChecker::default()))
        .entity::<PurchaseOrder>()
        .checker(teaql_runtime::TypedEntityChecker::<PurchaseOrder, _>::new(PurchaseOrderChecker::default()))
        .entity::<PurchaseOrderItem>()
        .checker(teaql_runtime::TypedEntityChecker::<PurchaseOrderItem, _>::new(PurchaseOrderItemChecker::default()))
        .entity::<Shipment>()
        .checker(teaql_runtime::TypedEntityChecker::<Shipment, _>::new(ShipmentChecker::default()))
        .entity::<Delivery>()
        .checker(teaql_runtime::TypedEntityChecker::<Delivery, _>::new(DeliveryChecker::default()))
        .entity::<ReturnRequest>()
        .checker(teaql_runtime::TypedEntityChecker::<ReturnRequest, _>::new(ReturnRequestChecker::default()))
        .entity::<Ticket>()
        .checker(teaql_runtime::TypedEntityChecker::<Ticket, _>::new(TicketChecker::default()))
        .entity::<TicketComment>()
        .checker(teaql_runtime::TypedEntityChecker::<TicketComment, _>::new(TicketCommentChecker::default()))
        .entity::<Sla>()
        .checker(teaql_runtime::TypedEntityChecker::<Sla, _>::new(SlaChecker::default()))
        .entity::<KnowledgeBase>()
        .checker(teaql_runtime::TypedEntityChecker::<KnowledgeBase, _>::new(KnowledgeBaseChecker::default()))
        .entity::<SupportAgent>()
        .checker(teaql_runtime::TypedEntityChecker::<SupportAgent, _>::new(SupportAgentChecker::default()))
        .initial_graph(teaql_runtime::GraphNode::new("Department")
            .value("id", 1_u64)
            .value("name", "name_value")
            .value("budget", "100.00")
            .value("location", "location_value")
            .value("manager_id", "manager_id_value")
            .value("create_time", teaql_core::time::Timestamp::now())
            .value("update_time", teaql_core::time::Timestamp::now())
            .value("version", 1_i64))
        .initial_graph(teaql_runtime::GraphNode::new("Position")
            .value("id", 1_u64)
            .value("max_salary", "100.00")
            .value("min_salary", "100.00")
            .value("title", "title_value")
            .value("create_time", teaql_core::time::Timestamp::now())
            .value("update_time", teaql_core::time::Timestamp::now())
            .value("version", 1_i64))
        .initial_graph(teaql_runtime::GraphNode::new("Customer")
            .value("id", 1_u64)
            .value("address", "address_value")
            .value("email", "email_value")
            .value("name", "name_value")
            .value("phone", "phone_value")
            .value("created_at", teaql_core::time::Timestamp::now())
            .value("loyalty_points", "100.00")
            .value("create_time", teaql_core::time::Timestamp::now())
            .value("update_time", teaql_core::time::Timestamp::now())
            .value("version", 1_i64))
        .initial_graph(teaql_runtime::GraphNode::new("Lead")
            .value("id", 1_u64)
            .value("email", "email_value")
            .value("name", "name_value")
            .value("phone", "phone_value")
            .value("converted_customer_id", "converted_customer_id_value")
            .value("source", "source_value")
            .value("status", "status_value")
            .value("create_time", teaql_core::time::Timestamp::now())
            .value("update_time", teaql_core::time::Timestamp::now())
            .value("version", 1_i64))
        .initial_graph(teaql_runtime::GraphNode::new("Campaign")
            .value("id", 1_u64)
            .value("name", "name_value")
            .value("budget", "100.00")
            .value("end_date", teaql_core::time::Timestamp::now())
            .value("start_date", teaql_core::time::Timestamp::now())
            .value("status", "status_value")
            .value("create_time", teaql_core::time::Timestamp::now())
            .value("update_time", teaql_core::time::Timestamp::now())
            .value("version", 1_i64))
        .initial_graph(teaql_runtime::GraphNode::new("SalesTerritory")
            .value("id", 1_u64)
            .value("name", "name_value")
            .value("manager_id", "manager_id_value")
            .value("region", "region_value")
            .value("create_time", teaql_core::time::Timestamp::now())
            .value("update_time", teaql_core::time::Timestamp::now())
            .value("version", 1_i64))
        .initial_graph(teaql_runtime::GraphNode::new("Category")
            .value("id", 1_u64)
            .value("description", "description_value")
            .value("name", "name_value")
            .value("parent_id", "parent_id_value")
            .value("create_time", teaql_core::time::Timestamp::now())
            .value("update_time", teaql_core::time::Timestamp::now())
            .value("version", 1_i64))
        .initial_graph(teaql_runtime::GraphNode::new("Catalog")
            .value("id", 1_u64)
            .value("name", "name_value")
            .value("season", "season_value")
            .value("valid_from", teaql_core::time::Timestamp::now())
            .value("valid_to", teaql_core::time::Timestamp::now())
            .value("create_time", teaql_core::time::Timestamp::now())
            .value("update_time", teaql_core::time::Timestamp::now())
            .value("version", 1_i64))
        .initial_graph(teaql_runtime::GraphNode::new("Promotion")
            .value("id", 1_u64)
            .value("name", "name_value")
            .value("discount_percentage", "100.00")
            .value("end_date", teaql_core::time::Timestamp::now())
            .value("start_date", teaql_core::time::Timestamp::now())
            .value("create_time", teaql_core::time::Timestamp::now())
            .value("update_time", teaql_core::time::Timestamp::now())
            .value("version", 1_i64))
        .initial_graph(teaql_runtime::GraphNode::new("Account")
            .value("id", 1_u64)
            .value("name", "name_value")
            .value("account_type", "account_type_value")
            .value("balance", "100.00")
            .value("currency", "currency_value")
            .value("create_time", teaql_core::time::Timestamp::now())
            .value("update_time", teaql_core::time::Timestamp::now())
            .value("version", 1_i64))
        .initial_graph(teaql_runtime::GraphNode::new("TaxRate")
            .value("id", 1_u64)
            .value("is_active", true)
            .value("rate", "100.00")
            .value("region", "region_value")
            .value("create_time", teaql_core::time::Timestamp::now())
            .value("update_time", teaql_core::time::Timestamp::now())
            .value("version", 1_i64))
        .initial_graph(teaql_runtime::GraphNode::new("Supplier")
            .value("id", 1_u64)
            .value("address", "address_value")
            .value("contact_email", "contact_email_value")
            .value("name", "name_value")
            .value("phone", "phone_value")
            .value("rating", "100.00")
            .value("create_time", teaql_core::time::Timestamp::now())
            .value("update_time", teaql_core::time::Timestamp::now())
            .value("version", 1_i64))
        .initial_graph(teaql_runtime::GraphNode::new("Warehouse")
            .value("id", 1_u64)
            .value("name", "name_value")
            .value("capacity", "100.00")
            .value("location", "location_value")
            .value("manager_id", "manager_id_value")
            .value("create_time", teaql_core::time::Timestamp::now())
            .value("update_time", teaql_core::time::Timestamp::now())
            .value("version", 1_i64))
        .initial_graph(teaql_runtime::GraphNode::new("Sla")
            .value("id", 1_u64)
            .value("is_active", true)
            .value("priority_level", "priority_level_value")
            .value("resolution_hours", "100.00")
            .value("create_time", teaql_core::time::Timestamp::now())
            .value("update_time", teaql_core::time::Timestamp::now())
            .value("version", 1_i64))
        .initial_graph(teaql_runtime::GraphNode::new("KnowledgeBase")
            .value("id", 1_u64)
            .value("category", "category_value")
            .value("content", "content_value")
            .value("title", "title_value")
            .value("views", "100.00")
            .value("create_time", teaql_core::time::Timestamp::now())
            .value("update_time", teaql_core::time::Timestamp::now())
            .value("version", 1_i64))
}

pub fn module_with_behaviors() -> teaql_runtime::RuntimeModule {
    teaql_runtime::RuntimeModule::new()
        .entity_with_behavior::<Employee, _>(EmployeeBehavior::default())
        .entity_with_behavior::<Department, _>(DepartmentBehavior::default())
        .entity_with_behavior::<Position, _>(PositionBehavior::default())
        .entity_with_behavior::<LeaveRequest, _>(LeaveRequestBehavior::default())
        .entity_with_behavior::<Attendance, _>(AttendanceBehavior::default())
        .entity_with_behavior::<Benefit, _>(BenefitBehavior::default())
        .entity_with_behavior::<EmployeeReview, _>(EmployeeReviewBehavior::default())
        .entity_with_behavior::<Payroll, _>(PayrollBehavior::default())
        .entity_with_behavior::<Customer, _>(CustomerBehavior::default())
        .entity_with_behavior::<Lead, _>(LeadBehavior::default())
        .entity_with_behavior::<Opportunity, _>(OpportunityBehavior::default())
        .entity_with_behavior::<Contact, _>(ContactBehavior::default())
        .entity_with_behavior::<Campaign, _>(CampaignBehavior::default())
        .entity_with_behavior::<Contract, _>(ContractBehavior::default())
        .entity_with_behavior::<Quote, _>(QuoteBehavior::default())
        .entity_with_behavior::<SalesTerritory, _>(SalesTerritoryBehavior::default())
        .entity_with_behavior::<Product, _>(ProductBehavior::default())
        .entity_with_behavior::<Category, _>(CategoryBehavior::default())
        .entity_with_behavior::<Catalog, _>(CatalogBehavior::default())
        .entity_with_behavior::<ProductReview, _>(ProductReviewBehavior::default())
        .entity_with_behavior::<ShoppingCart, _>(ShoppingCartBehavior::default())
        .entity_with_behavior::<CartItem, _>(CartItemBehavior::default())
        .entity_with_behavior::<GlobalOrder, _>(GlobalOrderBehavior::default())
        .entity_with_behavior::<OrderItem, _>(OrderItemBehavior::default())
        .entity_with_behavior::<Wishlist, _>(WishlistBehavior::default())
        .entity_with_behavior::<Promotion, _>(PromotionBehavior::default())
        .entity_with_behavior::<Coupon, _>(CouponBehavior::default())
        .entity_with_behavior::<Invoice, _>(InvoiceBehavior::default())
        .entity_with_behavior::<Payment, _>(PaymentBehavior::default())
        .entity_with_behavior::<Refund, _>(RefundBehavior::default())
        .entity_with_behavior::<Account, _>(AccountBehavior::default())
        .entity_with_behavior::<Transaction, _>(TransactionBehavior::default())
        .entity_with_behavior::<TaxRate, _>(TaxRateBehavior::default())
        .entity_with_behavior::<Expense, _>(ExpenseBehavior::default())
        .entity_with_behavior::<Ledger, _>(LedgerBehavior::default())
        .entity_with_behavior::<Supplier, _>(SupplierBehavior::default())
        .entity_with_behavior::<Warehouse, _>(WarehouseBehavior::default())
        .entity_with_behavior::<InventoryItem, _>(InventoryItemBehavior::default())
        .entity_with_behavior::<PurchaseOrder, _>(PurchaseOrderBehavior::default())
        .entity_with_behavior::<PurchaseOrderItem, _>(PurchaseOrderItemBehavior::default())
        .entity_with_behavior::<Shipment, _>(ShipmentBehavior::default())
        .entity_with_behavior::<Delivery, _>(DeliveryBehavior::default())
        .entity_with_behavior::<ReturnRequest, _>(ReturnRequestBehavior::default())
        .entity_with_behavior::<Ticket, _>(TicketBehavior::default())
        .entity_with_behavior::<TicketComment, _>(TicketCommentBehavior::default())
        .entity_with_behavior::<Sla, _>(SlaBehavior::default())
        .entity_with_behavior::<KnowledgeBase, _>(KnowledgeBaseBehavior::default())
        .entity_with_behavior::<SupportAgent, _>(SupportAgentBehavior::default())
        .initial_graph(teaql_runtime::GraphNode::new("Department")
            .value("id", 1_u64)
            .value("name", "name_value")
            .value("budget", "100.00")
            .value("location", "location_value")
            .value("manager_id", "manager_id_value")
            .value("create_time", teaql_core::time::Timestamp::now())
            .value("update_time", teaql_core::time::Timestamp::now())
            .value("version", 1_i64))
        .initial_graph(teaql_runtime::GraphNode::new("Position")
            .value("id", 1_u64)
            .value("max_salary", "100.00")
            .value("min_salary", "100.00")
            .value("title", "title_value")
            .value("create_time", teaql_core::time::Timestamp::now())
            .value("update_time", teaql_core::time::Timestamp::now())
            .value("version", 1_i64))
        .initial_graph(teaql_runtime::GraphNode::new("Customer")
            .value("id", 1_u64)
            .value("address", "address_value")
            .value("email", "email_value")
            .value("name", "name_value")
            .value("phone", "phone_value")
            .value("created_at", teaql_core::time::Timestamp::now())
            .value("loyalty_points", "100.00")
            .value("create_time", teaql_core::time::Timestamp::now())
            .value("update_time", teaql_core::time::Timestamp::now())
            .value("version", 1_i64))
        .initial_graph(teaql_runtime::GraphNode::new("Lead")
            .value("id", 1_u64)
            .value("email", "email_value")
            .value("name", "name_value")
            .value("phone", "phone_value")
            .value("converted_customer_id", "converted_customer_id_value")
            .value("source", "source_value")
            .value("status", "status_value")
            .value("create_time", teaql_core::time::Timestamp::now())
            .value("update_time", teaql_core::time::Timestamp::now())
            .value("version", 1_i64))
        .initial_graph(teaql_runtime::GraphNode::new("Campaign")
            .value("id", 1_u64)
            .value("name", "name_value")
            .value("budget", "100.00")
            .value("end_date", teaql_core::time::Timestamp::now())
            .value("start_date", teaql_core::time::Timestamp::now())
            .value("status", "status_value")
            .value("create_time", teaql_core::time::Timestamp::now())
            .value("update_time", teaql_core::time::Timestamp::now())
            .value("version", 1_i64))
        .initial_graph(teaql_runtime::GraphNode::new("SalesTerritory")
            .value("id", 1_u64)
            .value("name", "name_value")
            .value("manager_id", "manager_id_value")
            .value("region", "region_value")
            .value("create_time", teaql_core::time::Timestamp::now())
            .value("update_time", teaql_core::time::Timestamp::now())
            .value("version", 1_i64))
        .initial_graph(teaql_runtime::GraphNode::new("Category")
            .value("id", 1_u64)
            .value("description", "description_value")
            .value("name", "name_value")
            .value("parent_id", "parent_id_value")
            .value("create_time", teaql_core::time::Timestamp::now())
            .value("update_time", teaql_core::time::Timestamp::now())
            .value("version", 1_i64))
        .initial_graph(teaql_runtime::GraphNode::new("Catalog")
            .value("id", 1_u64)
            .value("name", "name_value")
            .value("season", "season_value")
            .value("valid_from", teaql_core::time::Timestamp::now())
            .value("valid_to", teaql_core::time::Timestamp::now())
            .value("create_time", teaql_core::time::Timestamp::now())
            .value("update_time", teaql_core::time::Timestamp::now())
            .value("version", 1_i64))
        .initial_graph(teaql_runtime::GraphNode::new("Promotion")
            .value("id", 1_u64)
            .value("name", "name_value")
            .value("discount_percentage", "100.00")
            .value("end_date", teaql_core::time::Timestamp::now())
            .value("start_date", teaql_core::time::Timestamp::now())
            .value("create_time", teaql_core::time::Timestamp::now())
            .value("update_time", teaql_core::time::Timestamp::now())
            .value("version", 1_i64))
        .initial_graph(teaql_runtime::GraphNode::new("Account")
            .value("id", 1_u64)
            .value("name", "name_value")
            .value("account_type", "account_type_value")
            .value("balance", "100.00")
            .value("currency", "currency_value")
            .value("create_time", teaql_core::time::Timestamp::now())
            .value("update_time", teaql_core::time::Timestamp::now())
            .value("version", 1_i64))
        .initial_graph(teaql_runtime::GraphNode::new("TaxRate")
            .value("id", 1_u64)
            .value("is_active", true)
            .value("rate", "100.00")
            .value("region", "region_value")
            .value("create_time", teaql_core::time::Timestamp::now())
            .value("update_time", teaql_core::time::Timestamp::now())
            .value("version", 1_i64))
        .initial_graph(teaql_runtime::GraphNode::new("Supplier")
            .value("id", 1_u64)
            .value("address", "address_value")
            .value("contact_email", "contact_email_value")
            .value("name", "name_value")
            .value("phone", "phone_value")
            .value("rating", "100.00")
            .value("create_time", teaql_core::time::Timestamp::now())
            .value("update_time", teaql_core::time::Timestamp::now())
            .value("version", 1_i64))
        .initial_graph(teaql_runtime::GraphNode::new("Warehouse")
            .value("id", 1_u64)
            .value("name", "name_value")
            .value("capacity", "100.00")
            .value("location", "location_value")
            .value("manager_id", "manager_id_value")
            .value("create_time", teaql_core::time::Timestamp::now())
            .value("update_time", teaql_core::time::Timestamp::now())
            .value("version", 1_i64))
        .initial_graph(teaql_runtime::GraphNode::new("Sla")
            .value("id", 1_u64)
            .value("is_active", true)
            .value("priority_level", "priority_level_value")
            .value("resolution_hours", "100.00")
            .value("create_time", teaql_core::time::Timestamp::now())
            .value("update_time", teaql_core::time::Timestamp::now())
            .value("version", 1_i64))
        .initial_graph(teaql_runtime::GraphNode::new("KnowledgeBase")
            .value("id", 1_u64)
            .value("category", "category_value")
            .value("content", "content_value")
            .value("title", "title_value")
            .value("views", "100.00")
            .value("create_time", teaql_core::time::Timestamp::now())
            .value("update_time", teaql_core::time::Timestamp::now())
            .value("version", 1_i64))
}

pub fn module_with_behaviors_and_checkers() -> teaql_runtime::RuntimeModule {
    teaql_runtime::RuntimeModule::new()
        .entity_with_behavior::<Employee, _>(EmployeeBehavior::default())
        .checker(teaql_runtime::TypedEntityChecker::<Employee, _>::new(EmployeeChecker::default()))
        .entity_with_behavior::<Department, _>(DepartmentBehavior::default())
        .checker(teaql_runtime::TypedEntityChecker::<Department, _>::new(DepartmentChecker::default()))
        .entity_with_behavior::<Position, _>(PositionBehavior::default())
        .checker(teaql_runtime::TypedEntityChecker::<Position, _>::new(PositionChecker::default()))
        .entity_with_behavior::<LeaveRequest, _>(LeaveRequestBehavior::default())
        .checker(teaql_runtime::TypedEntityChecker::<LeaveRequest, _>::new(LeaveRequestChecker::default()))
        .entity_with_behavior::<Attendance, _>(AttendanceBehavior::default())
        .checker(teaql_runtime::TypedEntityChecker::<Attendance, _>::new(AttendanceChecker::default()))
        .entity_with_behavior::<Benefit, _>(BenefitBehavior::default())
        .checker(teaql_runtime::TypedEntityChecker::<Benefit, _>::new(BenefitChecker::default()))
        .entity_with_behavior::<EmployeeReview, _>(EmployeeReviewBehavior::default())
        .checker(teaql_runtime::TypedEntityChecker::<EmployeeReview, _>::new(EmployeeReviewChecker::default()))
        .entity_with_behavior::<Payroll, _>(PayrollBehavior::default())
        .checker(teaql_runtime::TypedEntityChecker::<Payroll, _>::new(PayrollChecker::default()))
        .entity_with_behavior::<Customer, _>(CustomerBehavior::default())
        .checker(teaql_runtime::TypedEntityChecker::<Customer, _>::new(CustomerChecker::default()))
        .entity_with_behavior::<Lead, _>(LeadBehavior::default())
        .checker(teaql_runtime::TypedEntityChecker::<Lead, _>::new(LeadChecker::default()))
        .entity_with_behavior::<Opportunity, _>(OpportunityBehavior::default())
        .checker(teaql_runtime::TypedEntityChecker::<Opportunity, _>::new(OpportunityChecker::default()))
        .entity_with_behavior::<Contact, _>(ContactBehavior::default())
        .checker(teaql_runtime::TypedEntityChecker::<Contact, _>::new(ContactChecker::default()))
        .entity_with_behavior::<Campaign, _>(CampaignBehavior::default())
        .checker(teaql_runtime::TypedEntityChecker::<Campaign, _>::new(CampaignChecker::default()))
        .entity_with_behavior::<Contract, _>(ContractBehavior::default())
        .checker(teaql_runtime::TypedEntityChecker::<Contract, _>::new(ContractChecker::default()))
        .entity_with_behavior::<Quote, _>(QuoteBehavior::default())
        .checker(teaql_runtime::TypedEntityChecker::<Quote, _>::new(QuoteChecker::default()))
        .entity_with_behavior::<SalesTerritory, _>(SalesTerritoryBehavior::default())
        .checker(teaql_runtime::TypedEntityChecker::<SalesTerritory, _>::new(SalesTerritoryChecker::default()))
        .entity_with_behavior::<Product, _>(ProductBehavior::default())
        .checker(teaql_runtime::TypedEntityChecker::<Product, _>::new(ProductChecker::default()))
        .entity_with_behavior::<Category, _>(CategoryBehavior::default())
        .checker(teaql_runtime::TypedEntityChecker::<Category, _>::new(CategoryChecker::default()))
        .entity_with_behavior::<Catalog, _>(CatalogBehavior::default())
        .checker(teaql_runtime::TypedEntityChecker::<Catalog, _>::new(CatalogChecker::default()))
        .entity_with_behavior::<ProductReview, _>(ProductReviewBehavior::default())
        .checker(teaql_runtime::TypedEntityChecker::<ProductReview, _>::new(ProductReviewChecker::default()))
        .entity_with_behavior::<ShoppingCart, _>(ShoppingCartBehavior::default())
        .checker(teaql_runtime::TypedEntityChecker::<ShoppingCart, _>::new(ShoppingCartChecker::default()))
        .entity_with_behavior::<CartItem, _>(CartItemBehavior::default())
        .checker(teaql_runtime::TypedEntityChecker::<CartItem, _>::new(CartItemChecker::default()))
        .entity_with_behavior::<GlobalOrder, _>(GlobalOrderBehavior::default())
        .checker(teaql_runtime::TypedEntityChecker::<GlobalOrder, _>::new(GlobalOrderChecker::default()))
        .entity_with_behavior::<OrderItem, _>(OrderItemBehavior::default())
        .checker(teaql_runtime::TypedEntityChecker::<OrderItem, _>::new(OrderItemChecker::default()))
        .entity_with_behavior::<Wishlist, _>(WishlistBehavior::default())
        .checker(teaql_runtime::TypedEntityChecker::<Wishlist, _>::new(WishlistChecker::default()))
        .entity_with_behavior::<Promotion, _>(PromotionBehavior::default())
        .checker(teaql_runtime::TypedEntityChecker::<Promotion, _>::new(PromotionChecker::default()))
        .entity_with_behavior::<Coupon, _>(CouponBehavior::default())
        .checker(teaql_runtime::TypedEntityChecker::<Coupon, _>::new(CouponChecker::default()))
        .entity_with_behavior::<Invoice, _>(InvoiceBehavior::default())
        .checker(teaql_runtime::TypedEntityChecker::<Invoice, _>::new(InvoiceChecker::default()))
        .entity_with_behavior::<Payment, _>(PaymentBehavior::default())
        .checker(teaql_runtime::TypedEntityChecker::<Payment, _>::new(PaymentChecker::default()))
        .entity_with_behavior::<Refund, _>(RefundBehavior::default())
        .checker(teaql_runtime::TypedEntityChecker::<Refund, _>::new(RefundChecker::default()))
        .entity_with_behavior::<Account, _>(AccountBehavior::default())
        .checker(teaql_runtime::TypedEntityChecker::<Account, _>::new(AccountChecker::default()))
        .entity_with_behavior::<Transaction, _>(TransactionBehavior::default())
        .checker(teaql_runtime::TypedEntityChecker::<Transaction, _>::new(TransactionChecker::default()))
        .entity_with_behavior::<TaxRate, _>(TaxRateBehavior::default())
        .checker(teaql_runtime::TypedEntityChecker::<TaxRate, _>::new(TaxRateChecker::default()))
        .entity_with_behavior::<Expense, _>(ExpenseBehavior::default())
        .checker(teaql_runtime::TypedEntityChecker::<Expense, _>::new(ExpenseChecker::default()))
        .entity_with_behavior::<Ledger, _>(LedgerBehavior::default())
        .checker(teaql_runtime::TypedEntityChecker::<Ledger, _>::new(LedgerChecker::default()))
        .entity_with_behavior::<Supplier, _>(SupplierBehavior::default())
        .checker(teaql_runtime::TypedEntityChecker::<Supplier, _>::new(SupplierChecker::default()))
        .entity_with_behavior::<Warehouse, _>(WarehouseBehavior::default())
        .checker(teaql_runtime::TypedEntityChecker::<Warehouse, _>::new(WarehouseChecker::default()))
        .entity_with_behavior::<InventoryItem, _>(InventoryItemBehavior::default())
        .checker(teaql_runtime::TypedEntityChecker::<InventoryItem, _>::new(InventoryItemChecker::default()))
        .entity_with_behavior::<PurchaseOrder, _>(PurchaseOrderBehavior::default())
        .checker(teaql_runtime::TypedEntityChecker::<PurchaseOrder, _>::new(PurchaseOrderChecker::default()))
        .entity_with_behavior::<PurchaseOrderItem, _>(PurchaseOrderItemBehavior::default())
        .checker(teaql_runtime::TypedEntityChecker::<PurchaseOrderItem, _>::new(PurchaseOrderItemChecker::default()))
        .entity_with_behavior::<Shipment, _>(ShipmentBehavior::default())
        .checker(teaql_runtime::TypedEntityChecker::<Shipment, _>::new(ShipmentChecker::default()))
        .entity_with_behavior::<Delivery, _>(DeliveryBehavior::default())
        .checker(teaql_runtime::TypedEntityChecker::<Delivery, _>::new(DeliveryChecker::default()))
        .entity_with_behavior::<ReturnRequest, _>(ReturnRequestBehavior::default())
        .checker(teaql_runtime::TypedEntityChecker::<ReturnRequest, _>::new(ReturnRequestChecker::default()))
        .entity_with_behavior::<Ticket, _>(TicketBehavior::default())
        .checker(teaql_runtime::TypedEntityChecker::<Ticket, _>::new(TicketChecker::default()))
        .entity_with_behavior::<TicketComment, _>(TicketCommentBehavior::default())
        .checker(teaql_runtime::TypedEntityChecker::<TicketComment, _>::new(TicketCommentChecker::default()))
        .entity_with_behavior::<Sla, _>(SlaBehavior::default())
        .checker(teaql_runtime::TypedEntityChecker::<Sla, _>::new(SlaChecker::default()))
        .entity_with_behavior::<KnowledgeBase, _>(KnowledgeBaseBehavior::default())
        .checker(teaql_runtime::TypedEntityChecker::<KnowledgeBase, _>::new(KnowledgeBaseChecker::default()))
        .entity_with_behavior::<SupportAgent, _>(SupportAgentBehavior::default())
        .checker(teaql_runtime::TypedEntityChecker::<SupportAgent, _>::new(SupportAgentChecker::default()))
        .initial_graph(teaql_runtime::GraphNode::new("Department")
            .value("id", 1_u64)
            .value("name", "name_value")
            .value("budget", "100.00")
            .value("location", "location_value")
            .value("manager_id", "manager_id_value")
            .value("create_time", teaql_core::time::Timestamp::now())
            .value("update_time", teaql_core::time::Timestamp::now())
            .value("version", 1_i64))
        .initial_graph(teaql_runtime::GraphNode::new("Position")
            .value("id", 1_u64)
            .value("max_salary", "100.00")
            .value("min_salary", "100.00")
            .value("title", "title_value")
            .value("create_time", teaql_core::time::Timestamp::now())
            .value("update_time", teaql_core::time::Timestamp::now())
            .value("version", 1_i64))
        .initial_graph(teaql_runtime::GraphNode::new("Customer")
            .value("id", 1_u64)
            .value("address", "address_value")
            .value("email", "email_value")
            .value("name", "name_value")
            .value("phone", "phone_value")
            .value("created_at", teaql_core::time::Timestamp::now())
            .value("loyalty_points", "100.00")
            .value("create_time", teaql_core::time::Timestamp::now())
            .value("update_time", teaql_core::time::Timestamp::now())
            .value("version", 1_i64))
        .initial_graph(teaql_runtime::GraphNode::new("Lead")
            .value("id", 1_u64)
            .value("email", "email_value")
            .value("name", "name_value")
            .value("phone", "phone_value")
            .value("converted_customer_id", "converted_customer_id_value")
            .value("source", "source_value")
            .value("status", "status_value")
            .value("create_time", teaql_core::time::Timestamp::now())
            .value("update_time", teaql_core::time::Timestamp::now())
            .value("version", 1_i64))
        .initial_graph(teaql_runtime::GraphNode::new("Campaign")
            .value("id", 1_u64)
            .value("name", "name_value")
            .value("budget", "100.00")
            .value("end_date", teaql_core::time::Timestamp::now())
            .value("start_date", teaql_core::time::Timestamp::now())
            .value("status", "status_value")
            .value("create_time", teaql_core::time::Timestamp::now())
            .value("update_time", teaql_core::time::Timestamp::now())
            .value("version", 1_i64))
        .initial_graph(teaql_runtime::GraphNode::new("SalesTerritory")
            .value("id", 1_u64)
            .value("name", "name_value")
            .value("manager_id", "manager_id_value")
            .value("region", "region_value")
            .value("create_time", teaql_core::time::Timestamp::now())
            .value("update_time", teaql_core::time::Timestamp::now())
            .value("version", 1_i64))
        .initial_graph(teaql_runtime::GraphNode::new("Category")
            .value("id", 1_u64)
            .value("description", "description_value")
            .value("name", "name_value")
            .value("parent_id", "parent_id_value")
            .value("create_time", teaql_core::time::Timestamp::now())
            .value("update_time", teaql_core::time::Timestamp::now())
            .value("version", 1_i64))
        .initial_graph(teaql_runtime::GraphNode::new("Catalog")
            .value("id", 1_u64)
            .value("name", "name_value")
            .value("season", "season_value")
            .value("valid_from", teaql_core::time::Timestamp::now())
            .value("valid_to", teaql_core::time::Timestamp::now())
            .value("create_time", teaql_core::time::Timestamp::now())
            .value("update_time", teaql_core::time::Timestamp::now())
            .value("version", 1_i64))
        .initial_graph(teaql_runtime::GraphNode::new("Promotion")
            .value("id", 1_u64)
            .value("name", "name_value")
            .value("discount_percentage", "100.00")
            .value("end_date", teaql_core::time::Timestamp::now())
            .value("start_date", teaql_core::time::Timestamp::now())
            .value("create_time", teaql_core::time::Timestamp::now())
            .value("update_time", teaql_core::time::Timestamp::now())
            .value("version", 1_i64))
        .initial_graph(teaql_runtime::GraphNode::new("Account")
            .value("id", 1_u64)
            .value("name", "name_value")
            .value("account_type", "account_type_value")
            .value("balance", "100.00")
            .value("currency", "currency_value")
            .value("create_time", teaql_core::time::Timestamp::now())
            .value("update_time", teaql_core::time::Timestamp::now())
            .value("version", 1_i64))
        .initial_graph(teaql_runtime::GraphNode::new("TaxRate")
            .value("id", 1_u64)
            .value("is_active", true)
            .value("rate", "100.00")
            .value("region", "region_value")
            .value("create_time", teaql_core::time::Timestamp::now())
            .value("update_time", teaql_core::time::Timestamp::now())
            .value("version", 1_i64))
        .initial_graph(teaql_runtime::GraphNode::new("Supplier")
            .value("id", 1_u64)
            .value("address", "address_value")
            .value("contact_email", "contact_email_value")
            .value("name", "name_value")
            .value("phone", "phone_value")
            .value("rating", "100.00")
            .value("create_time", teaql_core::time::Timestamp::now())
            .value("update_time", teaql_core::time::Timestamp::now())
            .value("version", 1_i64))
        .initial_graph(teaql_runtime::GraphNode::new("Warehouse")
            .value("id", 1_u64)
            .value("name", "name_value")
            .value("capacity", "100.00")
            .value("location", "location_value")
            .value("manager_id", "manager_id_value")
            .value("create_time", teaql_core::time::Timestamp::now())
            .value("update_time", teaql_core::time::Timestamp::now())
            .value("version", 1_i64))
        .initial_graph(teaql_runtime::GraphNode::new("Sla")
            .value("id", 1_u64)
            .value("is_active", true)
            .value("priority_level", "priority_level_value")
            .value("resolution_hours", "100.00")
            .value("create_time", teaql_core::time::Timestamp::now())
            .value("update_time", teaql_core::time::Timestamp::now())
            .value("version", 1_i64))
        .initial_graph(teaql_runtime::GraphNode::new("KnowledgeBase")
            .value("id", 1_u64)
            .value("category", "category_value")
            .value("content", "content_value")
            .value("title", "title_value")
            .value("views", "100.00")
            .value("create_time", teaql_core::time::Timestamp::now())
            .value("update_time", teaql_core::time::Timestamp::now())
            .value("version", 1_i64))
}