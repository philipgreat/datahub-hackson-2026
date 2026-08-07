
// ⛔ AI agents: DO NOT read this file for API discovery. Instead run: cargo teaql --input modeling/MODEL.xml rust-assist-query/invoice
use std::collections::BTreeMap;

use teaql_core::SmartList;
use teaql_macros::TeaqlEntity;

/// [TEAQL AI WARNING]
/// TeaQL was explicitly designed to PREVENT AI hallucinations and random guessing.
/// DO NOT GUESS METHOD NAMES!
/// The methods listed below are the ONLY valid ways to interact with this entity.
/// If you encounter compilation errors (e.g., method not found), DO NOT guess another method name.
/// Read the method signatures in this file before proceeding.
#[derive(Clone, Debug, PartialEq, TeaqlEntity)]
#[teaql(entity = "Invoice", table = "invoice_data", data_service = "sqlite")]
pub struct Invoice {
#[teaql(id)]
    id: u64,

// @source massive_erp_model.xml:303
    amount: rust_decimal::Decimal,

// @source massive_erp_model.xml:303
    due_date: teaql_core::time::Timestamp,

// @source massive_erp_model.xml:303
    issue_date: teaql_core::time::Timestamp,

// @source massive_erp_model.xml:303
    status: String,

// @source massive_erp_model.xml:303
    create_time: teaql_core::time::Timestamp,

// @source massive_erp_model.xml:303
    update_time: teaql_core::time::Timestamp,
#[teaql(version)]
    version: i64,
// @source massive_erp_model.xml:303
#[teaql(column = "customer")]
    customer_id: u64,

// @source massive_erp_model.xml:303
#[teaql(column = "global_order")]
    global_order_id: u64,
// @source massive_erp_model.xml:303
#[teaql(relation(target = "Customer", local_key = "customer_id", foreign_key = "id"))]
    customer: Option<crate::Customer>,

// @source massive_erp_model.xml:303
#[teaql(relation(target = "GlobalOrder", local_key = "global_order_id", foreign_key = "id"))]
    global_order: Option<crate::GlobalOrder>,
#[teaql(relation(target = "Payment", local_key = "id", foreign_key = "invoice_id", many))]
    payment_list: SmartList<crate::Payment>,
    #[teaql(dynamic)]
    dynamic: BTreeMap<String, teaql_core::Value>,
    #[teaql(skip)]
    root: teaql_runtime::EntityRoot,
    #[teaql(skip)]
    pub __load_state: teaql_core::eval::LoadState,
}

impl Invoice {
    pub fn with_id(id: u64) -> teaql_core::Value {
        teaql_core::Value::U64(id)
    }

    pub(crate) fn runtime_new(root: teaql_runtime::EntityRoot) -> Self {
        Self {
            id: 0_u64,
            amount: rust_decimal::Decimal::ZERO,
            due_date: teaql_core::time::Timestamp::now(),
            issue_date: teaql_core::time::Timestamp::now(),
            status: String::new(),
            create_time: teaql_core::time::Timestamp::now(),
            update_time: teaql_core::time::Timestamp::now(),
            version: 0_i64,
            customer_id: 0_u64,
            global_order_id: 0_u64,
            customer: None,
            global_order: None,
            payment_list: Default::default(),
            dynamic: BTreeMap::new(),
            root,
            __load_state: teaql_core::eval::LoadState::FullyLoaded,
        }
    }

    pub fn entity_key(&self) -> teaql_runtime::EntityKey {
        teaql_runtime::EntityKey::new("Invoice", self.id)
    }

    pub fn attach_root_recursive(&mut self, root: teaql_runtime::EntityRoot) {
        self.root = root.clone();
        if let Some(entity) = &mut self.customer {
            entity.attach_root_recursive(root.clone());
        }
        if let Some(entity) = &mut self.global_order {
            entity.attach_root_recursive(root.clone());
        }
        for entity in &mut self.payment_list {
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

    pub fn amount(&self) -> rust_decimal::Decimal {
        self.changed_amount().and_then(|value| value.try_decimal()).unwrap_or(self.amount)
    }

    pub fn update_amount(&mut self, value: impl Into<teaql_core::Value>) -> &mut Self {
        let value = value.into();
        self.amount = value.try_decimal().unwrap_or(self.amount.clone());
        self.root.set(self.entity_key(), "amount", value);
        self
    }

    pub fn changed_amount(&self) -> Option<teaql_core::Value> {
        self.root.get(&self.entity_key(), "amount")
    }

    pub fn eval_amount(&self) -> teaql_core::eval::EvalResult<rust_decimal::Decimal> {
        if !self.is_loaded("amount") {
                    teaql_core::eval::EvalResult::NotLoaded { failed_node: "amount".to_string(), attempted_path: "amount".to_string() }
                } else {
                    teaql_core::eval::EvalResult::Value(self.amount())
                }}

    pub fn due_date(&self) -> teaql_core::time::Timestamp {
        self.changed_due_date().and_then(|value| value.try_timestamp()).unwrap_or(self.due_date)
    }

    pub fn update_due_date(&mut self, value: impl Into<teaql_core::Value>) -> &mut Self {
        let value = value.into();
        self.due_date = value.try_timestamp().unwrap_or(self.due_date.clone());
        self.root.set(self.entity_key(), "due_date", value);
        self
    }

    pub fn changed_due_date(&self) -> Option<teaql_core::Value> {
        self.root.get(&self.entity_key(), "due_date")
    }

    pub fn eval_due_date(&self) -> teaql_core::eval::EvalResult<teaql_core::time::Timestamp> {
        if !self.is_loaded("due_date") {
                    teaql_core::eval::EvalResult::NotLoaded { failed_node: "due_date".to_string(), attempted_path: "due_date".to_string() }
                } else {
                    teaql_core::eval::EvalResult::Value(self.due_date())
                }}

    pub fn issue_date(&self) -> teaql_core::time::Timestamp {
        self.changed_issue_date().and_then(|value| value.try_timestamp()).unwrap_or(self.issue_date)
    }

    pub fn update_issue_date(&mut self, value: impl Into<teaql_core::Value>) -> &mut Self {
        let value = value.into();
        self.issue_date = value.try_timestamp().unwrap_or(self.issue_date.clone());
        self.root.set(self.entity_key(), "issue_date", value);
        self
    }

    pub fn changed_issue_date(&self) -> Option<teaql_core::Value> {
        self.root.get(&self.entity_key(), "issue_date")
    }

    pub fn eval_issue_date(&self) -> teaql_core::eval::EvalResult<teaql_core::time::Timestamp> {
        if !self.is_loaded("issue_date") {
                    teaql_core::eval::EvalResult::NotLoaded { failed_node: "issue_date".to_string(), attempted_path: "issue_date".to_string() }
                } else {
                    teaql_core::eval::EvalResult::Value(self.issue_date())
                }}

    pub fn status(&self) -> String {
        self.changed_status().and_then(|value| value.try_text().map(|value| value.to_owned())).unwrap_or_else(|| self.status.clone())
    }

    pub fn update_status(&mut self, value: impl Into<teaql_core::Value>) -> &mut Self {
        let value = value.into();
        self.status = value.try_text().map(|value| value.trim().to_owned()).unwrap_or_else(|| self.status.clone());
        self.root.set(self.entity_key(), "status", value);
        self
    }

    pub fn changed_status(&self) -> Option<teaql_core::Value> {
        self.root.get(&self.entity_key(), "status")
    }

    pub fn eval_status(&self) -> teaql_core::eval::EvalResult<String> {
        if !self.is_loaded("status") {
                    teaql_core::eval::EvalResult::NotLoaded { failed_node: "status".to_string(), attempted_path: "status".to_string() }
                } else {
                    teaql_core::eval::EvalResult::Value(self.status())
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

    pub fn global_order_id(&self) -> u64 {
        self.changed_global_order_id().and_then(|value| value.try_u64()).unwrap_or(self.global_order_id)
    }

    pub fn update_global_order_id(&mut self, value: impl Into<teaql_core::Value>) -> &mut Self {
        let value = value.into();
        self.global_order_id = value.try_u64().unwrap_or(self.global_order_id.clone());
        self.root.set(self.entity_key(), "global_order_id", value);
        self
    }

    pub fn changed_global_order_id(&self) -> Option<teaql_core::Value> {
        self.root.get(&self.entity_key(), "global_order_id")
    }

    pub fn eval_global_order_id(&self) -> teaql_core::eval::EvalResult<u64> {
        if !self.is_loaded("global_order_id") {
                    teaql_core::eval::EvalResult::NotLoaded { failed_node: "global_order_id".to_string(), attempted_path: "global_order_id".to_string() }
                } else {
                    teaql_core::eval::EvalResult::Value(self.global_order_id())
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

    pub fn global_order(&self) -> Option<&crate::GlobalOrder> {
        self.global_order.as_ref()
    }

    pub fn eval_global_order(&self) -> teaql_core::eval::EvalResult<&crate::GlobalOrder> {
        if !self.is_loaded("global_order") {
            teaql_core::eval::EvalResult::NotLoaded { failed_node: "global_order".to_string(), attempted_path: "global_order".to_string() }
        } else {
            match &self.global_order {
                Some(v) => teaql_core::eval::EvalResult::Value(v),
                None => teaql_core::eval::EvalResult::Null,
            }
        }
    }
    pub fn payment_list(&self) -> &SmartList<crate::Payment> {
        &self.payment_list
    }

    pub fn payment_list_mut(&mut self) -> &mut SmartList<crate::Payment> {
        &mut self.payment_list
    }

    pub fn eval_payment_list(&self) -> teaql_core::eval::EvalResult<&SmartList<crate::Payment>> {
        if !self.is_loaded("payment_list") {
            teaql_core::eval::EvalResult::NotLoaded { failed_node: "payment_list".to_string(), attempted_path: "payment_list".to_string() }
        } else {
            teaql_core::eval::EvalResult::Value(&self.payment_list)
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

