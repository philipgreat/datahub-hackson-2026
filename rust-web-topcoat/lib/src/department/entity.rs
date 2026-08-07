
// ⛔ AI agents: DO NOT read this file for API discovery. Instead run: cargo teaql --input modeling/MODEL.xml rust-assist-query/department
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
#[teaql(entity = "Department", table = "department_data", data_service = "sqlite")]
pub struct Department {
#[teaql(id)]
    id: u64,

// @source massive_erp_model.xml:29
    name: String,

// @source massive_erp_model.xml:29
    budget: rust_decimal::Decimal,

// @source massive_erp_model.xml:29
    location: String,

// @source massive_erp_model.xml:29
    manager_id: String,

// @source massive_erp_model.xml:29
    create_time: teaql_core::time::Timestamp,

// @source massive_erp_model.xml:29
    update_time: teaql_core::time::Timestamp,
#[teaql(version)]
    version: i64,
#[teaql(relation(target = "Employee", local_key = "id", foreign_key = "department_id", many))]
    employee_list: SmartList<crate::Employee>,
    #[teaql(dynamic)]
    dynamic: BTreeMap<String, teaql_core::Value>,
    #[teaql(skip)]
    root: teaql_runtime::EntityRoot,
    #[teaql(skip)]
    pub __load_state: teaql_core::eval::LoadState,
}

impl Department {
    pub fn with_id(id: u64) -> teaql_core::Value {
        teaql_core::Value::U64(id)
    }

    pub(crate) fn runtime_new(root: teaql_runtime::EntityRoot) -> Self {
        Self {
            id: 0_u64,
            name: String::new(),
            budget: rust_decimal::Decimal::ZERO,
            location: String::new(),
            manager_id: String::new(),
            create_time: teaql_core::time::Timestamp::now(),
            update_time: teaql_core::time::Timestamp::now(),
            version: 0_i64,
            employee_list: Default::default(),
            dynamic: BTreeMap::new(),
            root,
            __load_state: teaql_core::eval::LoadState::FullyLoaded,
        }
    }

    pub fn entity_key(&self) -> teaql_runtime::EntityKey {
        teaql_runtime::EntityKey::new("Department", self.id)
    }

    pub fn attach_root_recursive(&mut self, root: teaql_runtime::EntityRoot) {
        self.root = root.clone();
        for entity in &mut self.employee_list {
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

    pub fn name(&self) -> String {
        self.changed_name().and_then(|value| value.try_text().map(|value| value.to_owned())).unwrap_or_else(|| self.name.clone())
    }

    pub fn update_name(&mut self, value: impl Into<teaql_core::Value>) -> &mut Self {
        let value = value.into();
        self.name = value.try_text().map(|value| value.trim().to_owned()).unwrap_or_else(|| self.name.clone());
        self.root.set(self.entity_key(), "name", value);
        self
    }

    pub fn changed_name(&self) -> Option<teaql_core::Value> {
        self.root.get(&self.entity_key(), "name")
    }

    pub fn eval_name(&self) -> teaql_core::eval::EvalResult<String> {
        if !self.is_loaded("name") {
                    teaql_core::eval::EvalResult::NotLoaded { failed_node: "name".to_string(), attempted_path: "name".to_string() }
                } else {
                    teaql_core::eval::EvalResult::Value(self.name())
                }}

    pub fn budget(&self) -> rust_decimal::Decimal {
        self.changed_budget().and_then(|value| value.try_decimal()).unwrap_or(self.budget)
    }

    pub fn update_budget(&mut self, value: impl Into<teaql_core::Value>) -> &mut Self {
        let value = value.into();
        self.budget = value.try_decimal().unwrap_or(self.budget.clone());
        self.root.set(self.entity_key(), "budget", value);
        self
    }

    pub fn changed_budget(&self) -> Option<teaql_core::Value> {
        self.root.get(&self.entity_key(), "budget")
    }

    pub fn eval_budget(&self) -> teaql_core::eval::EvalResult<rust_decimal::Decimal> {
        if !self.is_loaded("budget") {
                    teaql_core::eval::EvalResult::NotLoaded { failed_node: "budget".to_string(), attempted_path: "budget".to_string() }
                } else {
                    teaql_core::eval::EvalResult::Value(self.budget())
                }}

    pub fn location(&self) -> String {
        self.changed_location().and_then(|value| value.try_text().map(|value| value.to_owned())).unwrap_or_else(|| self.location.clone())
    }

    pub fn update_location(&mut self, value: impl Into<teaql_core::Value>) -> &mut Self {
        let value = value.into();
        self.location = value.try_text().map(|value| value.trim().to_owned()).unwrap_or_else(|| self.location.clone());
        self.root.set(self.entity_key(), "location", value);
        self
    }

    pub fn changed_location(&self) -> Option<teaql_core::Value> {
        self.root.get(&self.entity_key(), "location")
    }

    pub fn eval_location(&self) -> teaql_core::eval::EvalResult<String> {
        if !self.is_loaded("location") {
                    teaql_core::eval::EvalResult::NotLoaded { failed_node: "location".to_string(), attempted_path: "location".to_string() }
                } else {
                    teaql_core::eval::EvalResult::Value(self.location())
                }}

    pub fn manager_id(&self) -> String {
        self.changed_manager_id().and_then(|value| value.try_text().map(|value| value.to_owned())).unwrap_or_else(|| self.manager_id.clone())
    }

    pub fn update_manager_id(&mut self, value: impl Into<teaql_core::Value>) -> &mut Self {
        let value = value.into();
        self.manager_id = value.try_text().map(|value| value.trim().to_owned()).unwrap_or_else(|| self.manager_id.clone());
        self.root.set(self.entity_key(), "manager_id", value);
        self
    }

    pub fn changed_manager_id(&self) -> Option<teaql_core::Value> {
        self.root.get(&self.entity_key(), "manager_id")
    }

    pub fn eval_manager_id(&self) -> teaql_core::eval::EvalResult<String> {
        if !self.is_loaded("manager_id") {
                    teaql_core::eval::EvalResult::NotLoaded { failed_node: "manager_id".to_string(), attempted_path: "manager_id".to_string() }
                } else {
                    teaql_core::eval::EvalResult::Value(self.manager_id())
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
    pub fn employee_list(&self) -> &SmartList<crate::Employee> {
        &self.employee_list
    }

    pub fn employee_list_mut(&mut self) -> &mut SmartList<crate::Employee> {
        &mut self.employee_list
    }

    pub fn eval_employee_list(&self) -> teaql_core::eval::EvalResult<&SmartList<crate::Employee>> {
        if !self.is_loaded("employee_list") {
            teaql_core::eval::EvalResult::NotLoaded { failed_node: "employee_list".to_string(), attempted_path: "employee_list".to_string() }
        } else {
            teaql_core::eval::EvalResult::Value(&self.employee_list)
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

