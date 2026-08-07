
// ⛔ AI agents: DO NOT read this file for API discovery. Instead run: cargo teaql --input modeling/MODEL.xml rust-assist-query/benefit
use std::collections::BTreeMap;

use teaql_macros::TeaqlEntity;

/// [TEAQL AI WARNING]
/// TeaQL was explicitly designed to PREVENT AI hallucinations and random guessing.
/// DO NOT GUESS METHOD NAMES!
/// The methods listed below are the ONLY valid ways to interact with this entity.
/// If you encounter compilation errors (e.g., method not found), DO NOT guess another method name.
/// Read the method signatures in this file before proceeding.
#[derive(Clone, Debug, PartialEq, TeaqlEntity)]
#[teaql(entity = "Benefit", table = "benefit_data", data_service = "sqlite")]
pub struct Benefit {
#[teaql(id)]
    id: u64,

// @source massive_erp_model.xml:69
    cost: rust_decimal::Decimal,

// @source massive_erp_model.xml:69
    plan_type: String,

// @source massive_erp_model.xml:69
    provider: String,

// @source massive_erp_model.xml:69
    create_time: teaql_core::time::Timestamp,

// @source massive_erp_model.xml:69
    update_time: teaql_core::time::Timestamp,
#[teaql(version)]
    version: i64,
// @source massive_erp_model.xml:69
#[teaql(column = "employee")]
    employee_id: u64,
// @source massive_erp_model.xml:69
#[teaql(relation(target = "Employee", local_key = "employee_id", foreign_key = "id"))]
    employee: Option<crate::Employee>,
    #[teaql(dynamic)]
    dynamic: BTreeMap<String, teaql_core::Value>,
    #[teaql(skip)]
    root: teaql_runtime::EntityRoot,
    #[teaql(skip)]
    pub __load_state: teaql_core::eval::LoadState,
}

impl Benefit {
    pub fn with_id(id: u64) -> teaql_core::Value {
        teaql_core::Value::U64(id)
    }

    pub(crate) fn runtime_new(root: teaql_runtime::EntityRoot) -> Self {
        Self {
            id: 0_u64,
            cost: rust_decimal::Decimal::ZERO,
            plan_type: String::new(),
            provider: String::new(),
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
        teaql_runtime::EntityKey::new("Benefit", self.id)
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

    pub fn cost(&self) -> rust_decimal::Decimal {
        self.changed_cost().and_then(|value| value.try_decimal()).unwrap_or(self.cost)
    }

    pub fn update_cost(&mut self, value: impl Into<teaql_core::Value>) -> &mut Self {
        let value = value.into();
        self.cost = value.try_decimal().unwrap_or(self.cost.clone());
        self.root.set(self.entity_key(), "cost", value);
        self
    }

    pub fn changed_cost(&self) -> Option<teaql_core::Value> {
        self.root.get(&self.entity_key(), "cost")
    }

    pub fn eval_cost(&self) -> teaql_core::eval::EvalResult<rust_decimal::Decimal> {
        if !self.is_loaded("cost") {
                    teaql_core::eval::EvalResult::NotLoaded { failed_node: "cost".to_string(), attempted_path: "cost".to_string() }
                } else {
                    teaql_core::eval::EvalResult::Value(self.cost())
                }}

    pub fn plan_type(&self) -> String {
        self.changed_plan_type().and_then(|value| value.try_text().map(|value| value.to_owned())).unwrap_or_else(|| self.plan_type.clone())
    }

    pub fn update_plan_type(&mut self, value: impl Into<teaql_core::Value>) -> &mut Self {
        let value = value.into();
        self.plan_type = value.try_text().map(|value| value.trim().to_owned()).unwrap_or_else(|| self.plan_type.clone());
        self.root.set(self.entity_key(), "plan_type", value);
        self
    }

    pub fn changed_plan_type(&self) -> Option<teaql_core::Value> {
        self.root.get(&self.entity_key(), "plan_type")
    }

    pub fn eval_plan_type(&self) -> teaql_core::eval::EvalResult<String> {
        if !self.is_loaded("plan_type") {
                    teaql_core::eval::EvalResult::NotLoaded { failed_node: "plan_type".to_string(), attempted_path: "plan_type".to_string() }
                } else {
                    teaql_core::eval::EvalResult::Value(self.plan_type())
                }}

    pub fn provider(&self) -> String {
        self.changed_provider().and_then(|value| value.try_text().map(|value| value.to_owned())).unwrap_or_else(|| self.provider.clone())
    }

    pub fn update_provider(&mut self, value: impl Into<teaql_core::Value>) -> &mut Self {
        let value = value.into();
        self.provider = value.try_text().map(|value| value.trim().to_owned()).unwrap_or_else(|| self.provider.clone());
        self.root.set(self.entity_key(), "provider", value);
        self
    }

    pub fn changed_provider(&self) -> Option<teaql_core::Value> {
        self.root.get(&self.entity_key(), "provider")
    }

    pub fn eval_provider(&self) -> teaql_core::eval::EvalResult<String> {
        if !self.is_loaded("provider") {
                    teaql_core::eval::EvalResult::NotLoaded { failed_node: "provider".to_string(), attempted_path: "provider".to_string() }
                } else {
                    teaql_core::eval::EvalResult::Value(self.provider())
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

