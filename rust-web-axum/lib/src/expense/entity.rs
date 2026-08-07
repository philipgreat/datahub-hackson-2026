
// ⛔ AI agents: DO NOT read this file for API discovery. Instead run: cargo teaql --input modeling/MODEL.xml rust-assist-query/expense
use std::collections::BTreeMap;

use teaql_macros::TeaqlEntity;

/// [TEAQL AI WARNING]
/// TeaQL was explicitly designed to PREVENT AI hallucinations and random guessing.
/// DO NOT GUESS METHOD NAMES!
/// The methods listed below are the ONLY valid ways to interact with this entity.
/// If you encounter compilation errors (e.g., method not found), DO NOT guess another method name.
/// Read the method signatures in this file before proceeding.
#[derive(Clone, Debug, PartialEq, TeaqlEntity)]
#[teaql(entity = "Expense", table = "expense_data", data_service = "sqlite")]
pub struct Expense {
#[teaql(id)]
    id: u64,

// @source massive_erp_model.xml:365
    amount: rust_decimal::Decimal,

// @source massive_erp_model.xml:365
    category: String,

// @source massive_erp_model.xml:365
    date_incurred: teaql_core::time::Timestamp,

// @source massive_erp_model.xml:365
    status: String,

// @source massive_erp_model.xml:365
    create_time: teaql_core::time::Timestamp,

// @source massive_erp_model.xml:365
    update_time: teaql_core::time::Timestamp,
#[teaql(version)]
    version: i64,
// @source massive_erp_model.xml:365
#[teaql(column = "employee")]
    employee_id: u64,
// @source massive_erp_model.xml:365
#[teaql(relation(target = "Employee", local_key = "employee_id", foreign_key = "id"))]
    employee: Option<crate::Employee>,
    #[teaql(dynamic)]
    dynamic: BTreeMap<String, teaql_core::Value>,
    #[teaql(skip)]
    root: teaql_runtime::EntityRoot,
    #[teaql(skip)]
    pub __load_state: teaql_core::eval::LoadState,
}

impl Expense {
    pub fn with_id(id: u64) -> teaql_core::Value {
        teaql_core::Value::U64(id)
    }

    pub(crate) fn runtime_new(root: teaql_runtime::EntityRoot) -> Self {
        Self {
            id: 0_u64,
            amount: rust_decimal::Decimal::ZERO,
            category: String::new(),
            date_incurred: teaql_core::time::Timestamp::now(),
            status: String::new(),
            create_time: teaql_core::time::Timestamp::now(),
            update_time: teaql_core::time::Timestamp::now(),
            version: 0_i64,
            employee_id: 0_u64,
            employee: None,
            dynamic: BTreeMap::new(),
            root,
            __load_state: teaql_core::eval::LoadState::FullyLoaded,
        }
    }

    pub fn entity_key(&self) -> teaql_runtime::EntityKey {
        teaql_runtime::EntityKey::new("Expense", self.id)
    }

    pub fn attach_root_recursive(&mut self, root: teaql_runtime::EntityRoot) {
        self.root = root.clone();
        if let Some(entity) = &mut self.employee {
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

    pub fn category(&self) -> String {
        self.changed_category().and_then(|value| value.try_text().map(|value| value.to_owned())).unwrap_or_else(|| self.category.clone())
    }

    pub fn update_category(&mut self, value: impl Into<teaql_core::Value>) -> &mut Self {
        let value = value.into();
        self.category = value.try_text().map(|value| value.trim().to_owned()).unwrap_or_else(|| self.category.clone());
        self.root.set(self.entity_key(), "category", value);
        self
    }

    pub fn changed_category(&self) -> Option<teaql_core::Value> {
        self.root.get(&self.entity_key(), "category")
    }

    pub fn eval_category(&self) -> teaql_core::eval::EvalResult<String> {
        if !self.is_loaded("category") {
                    teaql_core::eval::EvalResult::NotLoaded { failed_node: "category".to_string(), attempted_path: "category".to_string() }
                } else {
                    teaql_core::eval::EvalResult::Value(self.category())
                }}

    pub fn date_incurred(&self) -> teaql_core::time::Timestamp {
        self.changed_date_incurred().and_then(|value| value.try_timestamp()).unwrap_or(self.date_incurred)
    }

    pub fn update_date_incurred(&mut self, value: impl Into<teaql_core::Value>) -> &mut Self {
        let value = value.into();
        self.date_incurred = value.try_timestamp().unwrap_or(self.date_incurred.clone());
        self.root.set(self.entity_key(), "date_incurred", value);
        self
    }

    pub fn changed_date_incurred(&self) -> Option<teaql_core::Value> {
        self.root.get(&self.entity_key(), "date_incurred")
    }

    pub fn eval_date_incurred(&self) -> teaql_core::eval::EvalResult<teaql_core::time::Timestamp> {
        if !self.is_loaded("date_incurred") {
                    teaql_core::eval::EvalResult::NotLoaded { failed_node: "date_incurred".to_string(), attempted_path: "date_incurred".to_string() }
                } else {
                    teaql_core::eval::EvalResult::Value(self.date_incurred())
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
    pub fn employee_id(&self) -> u64 {
        self.changed_employee_id().and_then(|value| value.try_u64()).unwrap_or(self.employee_id)
    }

    pub fn update_employee_id(&mut self, value: impl Into<teaql_core::Value>) -> &mut Self {
        let value = value.into();
        self.employee_id = value.try_u64().unwrap_or(self.employee_id.clone());
        self.root.set(self.entity_key(), "employee_id", value);
        self
    }

    pub fn changed_employee_id(&self) -> Option<teaql_core::Value> {
        self.root.get(&self.entity_key(), "employee_id")
    }

    pub fn eval_employee_id(&self) -> teaql_core::eval::EvalResult<u64> {
        if !self.is_loaded("employee_id") {
                    teaql_core::eval::EvalResult::NotLoaded { failed_node: "employee_id".to_string(), attempted_path: "employee_id".to_string() }
                } else {
                    teaql_core::eval::EvalResult::Value(self.employee_id())
                }}
    pub fn employee(&self) -> Option<&crate::Employee> {
        self.employee.as_ref()
    }

    pub fn eval_employee(&self) -> teaql_core::eval::EvalResult<&crate::Employee> {
        if !self.is_loaded("employee") {
            teaql_core::eval::EvalResult::NotLoaded { failed_node: "employee".to_string(), attempted_path: "employee".to_string() }
        } else {
            match &self.employee {
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

