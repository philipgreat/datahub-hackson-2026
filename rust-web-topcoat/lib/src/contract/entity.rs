
// ⛔ AI agents: DO NOT read this file for API discovery. Instead run: cargo teaql --input modeling/MODEL.xml rust-assist-query/contract
use std::collections::BTreeMap;

use teaql_macros::TeaqlEntity;

/// [TEAQL AI WARNING]
/// TeaQL was explicitly designed to PREVENT AI hallucinations and random guessing.
/// DO NOT GUESS METHOD NAMES!
/// The methods listed below are the ONLY valid ways to interact with this entity.
/// If you encounter compilation errors (e.g., method not found), DO NOT guess another method name.
/// Read the method signatures in this file before proceeding.
#[derive(Clone, Debug, PartialEq, TeaqlEntity)]
#[teaql(entity = "Contract", table = "contract_data", data_service = "sqlite")]
pub struct Contract {
#[teaql(id)]
    id: u64,

// @source massive_erp_model.xml:160
    end_date: teaql_core::time::Timestamp,

// @source massive_erp_model.xml:160
    start_date: teaql_core::time::Timestamp,

// @source massive_erp_model.xml:160
    terms: String,

// @source massive_erp_model.xml:160
    value: rust_decimal::Decimal,

// @source massive_erp_model.xml:160
    create_time: teaql_core::time::Timestamp,

// @source massive_erp_model.xml:160
    update_time: teaql_core::time::Timestamp,
#[teaql(version)]
    version: i64,
// @source massive_erp_model.xml:160
#[teaql(column = "customer")]
    customer_id: u64,
// @source massive_erp_model.xml:160
#[teaql(relation(target = "Customer", local_key = "customer_id", foreign_key = "id"))]
    customer: Option<crate::Customer>,
    #[teaql(dynamic)]
    dynamic: BTreeMap<String, teaql_core::Value>,
    #[teaql(skip)]
    root: teaql_runtime::EntityRoot,
    #[teaql(skip)]
    pub __load_state: teaql_core::eval::LoadState,
}

impl Contract {
    pub fn with_id(id: u64) -> teaql_core::Value {
        teaql_core::Value::U64(id)
    }

    pub(crate) fn runtime_new(root: teaql_runtime::EntityRoot) -> Self {
        Self {
            id: 0_u64,
            end_date: teaql_core::time::Timestamp::now(),
            start_date: teaql_core::time::Timestamp::now(),
            terms: String::new(),
            value: rust_decimal::Decimal::ZERO,
            create_time: teaql_core::time::Timestamp::now(),
            update_time: teaql_core::time::Timestamp::now(),
            version: 0_i64,
            customer_id: 0_u64,
            customer: None,
            dynamic: BTreeMap::new(),
            root,
            __load_state: teaql_core::eval::LoadState::FullyLoaded,
        }
    }

    pub fn entity_key(&self) -> teaql_runtime::EntityKey {
        teaql_runtime::EntityKey::new("Contract", self.id)
    }

    pub fn attach_root_recursive(&mut self, root: teaql_runtime::EntityRoot) {
        self.root = root.clone();
        if let Some(entity) = &mut self.customer {
            entity.attach_root_recursive(root.clone());
        }
    }

    pub fn is_loaded(&self, field_or_relation: &str) -> bool {
        self.__load_state.is_loaded(field_or_relation)
    }

    pub fn set_load_state(&mut self, state: teaql_core::eval::LoadState) {
        self.__load_state = state;
    }

    pub fn id(&self) -> u64 {
        self.changed_id().and_then(|value| value.try_u64()).unwrap_or(self.id)
    }

    pub fn update_id(&mut self, value: impl Into<teaql_core::Value>) -> &mut Self {
        let value = value.into();
        self.id = value.try_u64().unwrap_or(self.id.clone());
        self.root.set(self.entity_key(), "id", value);
        self
    }

    pub fn changed_id(&self) -> Option<teaql_core::Value> {
        self.root.get(&self.entity_key(), "id")
    }

    pub fn eval_id(&self) -> teaql_core::eval::EvalResult<u64> {
        if !self.is_loaded("id") {
                    teaql_core::eval::EvalResult::NotLoaded { failed_node: "id".to_string(), attempted_path: "id".to_string() }
                } else {
                    teaql_core::eval::EvalResult::Value(self.id())
                }}

    pub fn end_date(&self) -> teaql_core::time::Timestamp {
        self.changed_end_date().and_then(|value| value.try_timestamp()).unwrap_or(self.end_date)
    }

    pub fn update_end_date(&mut self, value: impl Into<teaql_core::Value>) -> &mut Self {
        let value = value.into();
        self.end_date = value.try_timestamp().unwrap_or(self.end_date.clone());
        self.root.set(self.entity_key(), "end_date", value);
        self
    }

    pub fn changed_end_date(&self) -> Option<teaql_core::Value> {
        self.root.get(&self.entity_key(), "end_date")
    }

    pub fn eval_end_date(&self) -> teaql_core::eval::EvalResult<teaql_core::time::Timestamp> {
        if !self.is_loaded("end_date") {
                    teaql_core::eval::EvalResult::NotLoaded { failed_node: "end_date".to_string(), attempted_path: "end_date".to_string() }
                } else {
                    teaql_core::eval::EvalResult::Value(self.end_date())
                }}

    pub fn start_date(&self) -> teaql_core::time::Timestamp {
        self.changed_start_date().and_then(|value| value.try_timestamp()).unwrap_or(self.start_date)
    }

    pub fn update_start_date(&mut self, value: impl Into<teaql_core::Value>) -> &mut Self {
        let value = value.into();
        self.start_date = value.try_timestamp().unwrap_or(self.start_date.clone());
        self.root.set(self.entity_key(), "start_date", value);
        self
    }

    pub fn changed_start_date(&self) -> Option<teaql_core::Value> {
        self.root.get(&self.entity_key(), "start_date")
    }

    pub fn eval_start_date(&self) -> teaql_core::eval::EvalResult<teaql_core::time::Timestamp> {
        if !self.is_loaded("start_date") {
                    teaql_core::eval::EvalResult::NotLoaded { failed_node: "start_date".to_string(), attempted_path: "start_date".to_string() }
                } else {
                    teaql_core::eval::EvalResult::Value(self.start_date())
                }}

    pub fn terms(&self) -> String {
        self.changed_terms().and_then(|value| value.try_text().map(|value| value.to_owned())).unwrap_or_else(|| self.terms.clone())
    }

    pub fn update_terms(&mut self, value: impl Into<teaql_core::Value>) -> &mut Self {
        let value = value.into();
        self.terms = value.try_text().map(|value| value.trim().to_owned()).unwrap_or_else(|| self.terms.clone());
        self.root.set(self.entity_key(), "terms", value);
        self
    }

    pub fn changed_terms(&self) -> Option<teaql_core::Value> {
        self.root.get(&self.entity_key(), "terms")
    }

    pub fn eval_terms(&self) -> teaql_core::eval::EvalResult<String> {
        if !self.is_loaded("terms") {
                    teaql_core::eval::EvalResult::NotLoaded { failed_node: "terms".to_string(), attempted_path: "terms".to_string() }
                } else {
                    teaql_core::eval::EvalResult::Value(self.terms())
                }}

    pub fn value(&self) -> rust_decimal::Decimal {
        self.changed_value().and_then(|value| value.try_decimal()).unwrap_or(self.value)
    }

    pub fn update_value(&mut self, value: impl Into<teaql_core::Value>) -> &mut Self {
        let value = value.into();
        self.value = value.try_decimal().unwrap_or(self.value.clone());
        self.root.set(self.entity_key(), "value", value);
        self
    }

    pub fn changed_value(&self) -> Option<teaql_core::Value> {
        self.root.get(&self.entity_key(), "value")
    }

    pub fn eval_value(&self) -> teaql_core::eval::EvalResult<rust_decimal::Decimal> {
        if !self.is_loaded("value") {
                    teaql_core::eval::EvalResult::NotLoaded { failed_node: "value".to_string(), attempted_path: "value".to_string() }
                } else {
                    teaql_core::eval::EvalResult::Value(self.value())
                }}

    pub fn create_time(&self) -> teaql_core::time::Timestamp {
        self.changed_create_time().and_then(|value| value.try_timestamp()).unwrap_or(self.create_time)
    }

    pub fn update_create_time(&mut self, value: impl Into<teaql_core::Value>) -> &mut Self {
        let value = value.into();
        self.create_time = value.try_timestamp().unwrap_or(self.create_time.clone());
        self.root.set(self.entity_key(), "create_time", value);
        self
    }

    pub fn changed_create_time(&self) -> Option<teaql_core::Value> {
        self.root.get(&self.entity_key(), "create_time")
    }

    pub fn eval_create_time(&self) -> teaql_core::eval::EvalResult<teaql_core::time::Timestamp> {
        if !self.is_loaded("create_time") {
                    teaql_core::eval::EvalResult::NotLoaded { failed_node: "create_time".to_string(), attempted_path: "create_time".to_string() }
                } else {
                    teaql_core::eval::EvalResult::Value(self.create_time())
                }}

    pub fn update_time(&self) -> teaql_core::time::Timestamp {
        self.changed_update_time().and_then(|value| value.try_timestamp()).unwrap_or(self.update_time)
    }

    pub fn update_update_time(&mut self, value: impl Into<teaql_core::Value>) -> &mut Self {
        let value = value.into();
        self.update_time = value.try_timestamp().unwrap_or(self.update_time.clone());
        self.root.set(self.entity_key(), "update_time", value);
        self
    }

    pub fn changed_update_time(&self) -> Option<teaql_core::Value> {
        self.root.get(&self.entity_key(), "update_time")
    }

    pub fn eval_update_time(&self) -> teaql_core::eval::EvalResult<teaql_core::time::Timestamp> {
        if !self.is_loaded("update_time") {
                    teaql_core::eval::EvalResult::NotLoaded { failed_node: "update_time".to_string(), attempted_path: "update_time".to_string() }
                } else {
                    teaql_core::eval::EvalResult::Value(self.update_time())
                }}

    pub fn version(&self) -> i64 {
        self.changed_version().and_then(|value| value.try_i64()).unwrap_or(self.version)
    }

    pub fn update_version(&mut self, value: impl Into<teaql_core::Value>) -> &mut Self {
        let value = value.into();
        self.version = value.try_i64().unwrap_or(self.version.clone());
        self.root.set(self.entity_key(), "version", value);
        self
    }

    pub fn changed_version(&self) -> Option<teaql_core::Value> {
        self.root.get(&self.entity_key(), "version")
    }

    pub fn eval_version(&self) -> teaql_core::eval::EvalResult<i64> {
        if !self.is_loaded("version") {
                    teaql_core::eval::EvalResult::NotLoaded { failed_node: "version".to_string(), attempted_path: "version".to_string() }
                } else {
                    teaql_core::eval::EvalResult::Value(self.version())
                }}
    pub fn customer_id(&self) -> u64 {
        self.changed_customer_id().and_then(|value| value.try_u64()).unwrap_or(self.customer_id)
    }

    pub fn update_customer_id(&mut self, value: impl Into<teaql_core::Value>) -> &mut Self {
        let value = value.into();
        self.customer_id = value.try_u64().unwrap_or(self.customer_id.clone());
        self.root.set(self.entity_key(), "customer_id", value);
        self
    }

    pub fn changed_customer_id(&self) -> Option<teaql_core::Value> {
        self.root.get(&self.entity_key(), "customer_id")
    }

    pub fn eval_customer_id(&self) -> teaql_core::eval::EvalResult<u64> {
        if !self.is_loaded("customer_id") {
                    teaql_core::eval::EvalResult::NotLoaded { failed_node: "customer_id".to_string(), attempted_path: "customer_id".to_string() }
                } else {
                    teaql_core::eval::EvalResult::Value(self.customer_id())
                }}
    pub fn customer(&self) -> Option<&crate::Customer> {
        self.customer.as_ref()
    }

    pub fn eval_customer(&self) -> teaql_core::eval::EvalResult<&crate::Customer> {
        if !self.is_loaded("customer") {
            teaql_core::eval::EvalResult::NotLoaded { failed_node: "customer".to_string(), attempted_path: "customer".to_string() }
        } else {
            match &self.customer {
                Some(v) => teaql_core::eval::EvalResult::Value(v),
                None => teaql_core::eval::EvalResult::Null,
            }
        }
    }

    pub fn mark_as_delete(&mut self) -> &mut Self {
        self.root.mark_as_delete(self.entity_key());
        self
    }

    pub fn set_comment(&mut self, comment: impl Into<String>) -> &mut Self {
        self.root.set_comment(comment);
        self
    }
}

