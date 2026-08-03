
// ⛔ AI agents: DO NOT read this file for API discovery. Instead run: cargo teaql --input modeling/MODEL.xml rust-assist-query/company
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
#[teaql(entity = "Company", table = "company_data", data_service = "sqlite")]
pub struct Company {
#[teaql(id)]
    id: u64,

// @source moving-company.xml:16
    name: String,

// @source moving-company.xml:16
    address: String,

// @source moving-company.xml:16
    phone: String,

// @source moving-company.xml:16
    email: String,

// @source moving-company.xml:16
    create_time: chrono::DateTime<chrono::Utc>,

// @source moving-company.xml:16
    update_time: chrono::DateTime<chrono::Utc>,
#[teaql(version)]
    version: i64,
    #[teaql(boxed_relations)]
    pub _relations: Box<CompanyReverseRelations>,
    #[teaql(dynamic)]
    dynamic: BTreeMap<String, teaql_core::Value>,
    #[teaql(skip)]
    root: teaql_runtime::EntityRoot,
    #[teaql(skip)]
    pub __load_state: teaql_core::eval::LoadState,
}

impl Company {
    pub fn with_id(id: u64) -> teaql_core::Value {
        teaql_core::Value::U64(id)
    }

    pub(crate) fn runtime_new(root: teaql_runtime::EntityRoot) -> Self {
        Self {
            id: 0_u64,
            name: String::new(),
            address: String::new(),
            phone: String::new(),
            email: String::new(),
            create_time: chrono::Utc::now(),
            update_time: chrono::Utc::now(),
            version: 0_i64,
            _relations: Box::new(CompanyReverseRelations::new()),
            dynamic: BTreeMap::new(),
            root,
            __load_state: teaql_core::eval::LoadState::FullyLoaded,
        }
    }

    pub fn entity_key(&self) -> teaql_runtime::EntityKey {
        teaql_runtime::EntityKey::new("Company", self.id)
    }

    pub fn attach_root_recursive(&mut self, root: teaql_runtime::EntityRoot) {
        self.root = root.clone();
        self._relations.attach_root_recursive(root.clone());
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

    pub fn address(&self) -> String {
        self.changed_address().and_then(|value| value.try_text().map(|value| value.to_owned())).unwrap_or_else(|| self.address.clone())
    }

    pub fn update_address(&mut self, value: impl Into<teaql_core::Value>) -> &mut Self {
        let value = value.into();
        self.address = value.try_text().map(|value| value.trim().to_owned()).unwrap_or_else(|| self.address.clone());
        self.root.set(self.entity_key(), "address", value);
        self
    }

    pub fn changed_address(&self) -> Option<teaql_core::Value> {
        self.root.get(&self.entity_key(), "address")
    }

    pub fn eval_address(&self) -> teaql_core::eval::EvalResult<String> {
        if !self.is_loaded("address") {
                    teaql_core::eval::EvalResult::NotLoaded { failed_node: "address".to_string(), attempted_path: "address".to_string() }
                } else {
                    teaql_core::eval::EvalResult::Value(self.address())
                }}

    pub fn phone(&self) -> String {
        self.changed_phone().and_then(|value| value.try_text().map(|value| value.to_owned())).unwrap_or_else(|| self.phone.clone())
    }

    pub fn update_phone(&mut self, value: impl Into<teaql_core::Value>) -> &mut Self {
        let value = value.into();
        self.phone = value.try_text().map(|value| value.trim().to_owned()).unwrap_or_else(|| self.phone.clone());
        self.root.set(self.entity_key(), "phone", value);
        self
    }

    pub fn changed_phone(&self) -> Option<teaql_core::Value> {
        self.root.get(&self.entity_key(), "phone")
    }

    pub fn eval_phone(&self) -> teaql_core::eval::EvalResult<String> {
        if !self.is_loaded("phone") {
                    teaql_core::eval::EvalResult::NotLoaded { failed_node: "phone".to_string(), attempted_path: "phone".to_string() }
                } else {
                    teaql_core::eval::EvalResult::Value(self.phone())
                }}

    pub fn email(&self) -> String {
        self.changed_email().and_then(|value| value.try_text().map(|value| value.to_owned())).unwrap_or_else(|| self.email.clone())
    }

    pub fn update_email(&mut self, value: impl Into<teaql_core::Value>) -> &mut Self {
        let value = value.into();
        self.email = value.try_text().map(|value| value.trim().to_owned()).unwrap_or_else(|| self.email.clone());
        self.root.set(self.entity_key(), "email", value);
        self
    }

    pub fn changed_email(&self) -> Option<teaql_core::Value> {
        self.root.get(&self.entity_key(), "email")
    }

    pub fn eval_email(&self) -> teaql_core::eval::EvalResult<String> {
        if !self.is_loaded("email") {
                    teaql_core::eval::EvalResult::NotLoaded { failed_node: "email".to_string(), attempted_path: "email".to_string() }
                } else {
                    teaql_core::eval::EvalResult::Value(self.email())
                }}

    pub fn create_time(&self) -> chrono::DateTime<chrono::Utc> {
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

    pub fn eval_create_time(&self) -> teaql_core::eval::EvalResult<chrono::DateTime<chrono::Utc>> {
        if !self.is_loaded("create_time") {
                    teaql_core::eval::EvalResult::NotLoaded { failed_node: "create_time".to_string(), attempted_path: "create_time".to_string() }
                } else {
                    teaql_core::eval::EvalResult::Value(self.create_time())
                }}

    pub fn update_time(&self) -> chrono::DateTime<chrono::Utc> {
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

    pub fn eval_update_time(&self) -> teaql_core::eval::EvalResult<chrono::DateTime<chrono::Utc>> {
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
    pub fn customer_list(&self) -> &SmartList<crate::Customer> {
        &self._relations.customer_list
    }

    pub fn customer_list_mut(&mut self) -> &mut SmartList<crate::Customer> {
        &mut self._relations.customer_list
    }

    pub fn eval_customer_list(&self) -> teaql_core::eval::EvalResult<&SmartList<crate::Customer>> {
        if !self.is_loaded("customer_list") {
            teaql_core::eval::EvalResult::NotLoaded { failed_node: "customer_list".to_string(), attempted_path: "customer_list".to_string() }
        } else {
            teaql_core::eval::EvalResult::Value(&self._relations.customer_list)
        }
    }

    pub fn driver_list(&self) -> &SmartList<crate::Driver> {
        &self._relations.driver_list
    }

    pub fn driver_list_mut(&mut self) -> &mut SmartList<crate::Driver> {
        &mut self._relations.driver_list
    }

    pub fn eval_driver_list(&self) -> teaql_core::eval::EvalResult<&SmartList<crate::Driver>> {
        if !self.is_loaded("driver_list") {
            teaql_core::eval::EvalResult::NotLoaded { failed_node: "driver_list".to_string(), attempted_path: "driver_list".to_string() }
        } else {
            teaql_core::eval::EvalResult::Value(&self._relations.driver_list)
        }
    }

    pub fn vehicle_list(&self) -> &SmartList<crate::Vehicle> {
        &self._relations.vehicle_list
    }

    pub fn vehicle_list_mut(&mut self) -> &mut SmartList<crate::Vehicle> {
        &mut self._relations.vehicle_list
    }

    pub fn eval_vehicle_list(&self) -> teaql_core::eval::EvalResult<&SmartList<crate::Vehicle>> {
        if !self.is_loaded("vehicle_list") {
            teaql_core::eval::EvalResult::NotLoaded { failed_node: "vehicle_list".to_string(), attempted_path: "vehicle_list".to_string() }
        } else {
            teaql_core::eval::EvalResult::Value(&self._relations.vehicle_list)
        }
    }

    pub fn move_order_status_list(&self) -> &SmartList<crate::MoveOrderStatus> {
        &self._relations.move_order_status_list
    }

    pub fn move_order_status_list_mut(&mut self) -> &mut SmartList<crate::MoveOrderStatus> {
        &mut self._relations.move_order_status_list
    }

    pub fn eval_move_order_status_list(&self) -> teaql_core::eval::EvalResult<&SmartList<crate::MoveOrderStatus>> {
        if !self.is_loaded("move_order_status_list") {
            teaql_core::eval::EvalResult::NotLoaded { failed_node: "move_order_status_list".to_string(), attempted_path: "move_order_status_list".to_string() }
        } else {
            teaql_core::eval::EvalResult::Value(&self._relations.move_order_status_list)
        }
    }

    pub fn move_order_list(&self) -> &SmartList<crate::MoveOrder> {
        &self._relations.move_order_list
    }

    pub fn move_order_list_mut(&mut self) -> &mut SmartList<crate::MoveOrder> {
        &mut self._relations.move_order_list
    }

    pub fn eval_move_order_list(&self) -> teaql_core::eval::EvalResult<&SmartList<crate::MoveOrder>> {
        if !self.is_loaded("move_order_list") {
            teaql_core::eval::EvalResult::NotLoaded { failed_node: "move_order_list".to_string(), attempted_path: "move_order_list".to_string() }
        } else {
            teaql_core::eval::EvalResult::Value(&self._relations.move_order_list)
        }
    }

    pub fn invoice_list(&self) -> &SmartList<crate::Invoice> {
        &self._relations.invoice_list
    }

    pub fn invoice_list_mut(&mut self) -> &mut SmartList<crate::Invoice> {
        &mut self._relations.invoice_list
    }

    pub fn eval_invoice_list(&self) -> teaql_core::eval::EvalResult<&SmartList<crate::Invoice>> {
        if !self.is_loaded("invoice_list") {
            teaql_core::eval::EvalResult::NotLoaded { failed_node: "invoice_list".to_string(), attempted_path: "invoice_list".to_string() }
        } else {
            teaql_core::eval::EvalResult::Value(&self._relations.invoice_list)
        }
    }

    pub fn review_list(&self) -> &SmartList<crate::Review> {
        &self._relations.review_list
    }

    pub fn review_list_mut(&mut self) -> &mut SmartList<crate::Review> {
        &mut self._relations.review_list
    }

    pub fn eval_review_list(&self) -> teaql_core::eval::EvalResult<&SmartList<crate::Review>> {
        if !self.is_loaded("review_list") {
            teaql_core::eval::EvalResult::NotLoaded { failed_node: "review_list".to_string(), attempted_path: "review_list".to_string() }
        } else {
            teaql_core::eval::EvalResult::Value(&self._relations.review_list)
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

#[derive(Clone, Debug, PartialEq, teaql_macros::TeaqlReverseRelations)]
pub struct CompanyReverseRelations {
#[teaql(relation(target = "Customer", local_key = "id", foreign_key = "company_id", many))]
    customer_list: SmartList<crate::Customer>,
#[teaql(relation(target = "Driver", local_key = "id", foreign_key = "company_id", many))]
    driver_list: SmartList<crate::Driver>,
#[teaql(relation(target = "Vehicle", local_key = "id", foreign_key = "company_id", many))]
    vehicle_list: SmartList<crate::Vehicle>,
#[teaql(relation(target = "MoveOrderStatus", local_key = "id", foreign_key = "company_id", many))]
    move_order_status_list: SmartList<crate::MoveOrderStatus>,
#[teaql(relation(target = "MoveOrder", local_key = "id", foreign_key = "company_id", many))]
    move_order_list: SmartList<crate::MoveOrder>,
#[teaql(relation(target = "Invoice", local_key = "id", foreign_key = "company_id", many))]
    invoice_list: SmartList<crate::Invoice>,
#[teaql(relation(target = "Review", local_key = "id", foreign_key = "company_id", many))]
    review_list: SmartList<crate::Review>,
}

impl CompanyReverseRelations {
    pub fn new() -> Self {
        Self {
            customer_list: Default::default(),
            driver_list: Default::default(),
            vehicle_list: Default::default(),
            move_order_status_list: Default::default(),
            move_order_list: Default::default(),
            invoice_list: Default::default(),
            review_list: Default::default(),
        }
    }

    pub fn attach_root_recursive(&mut self, root: teaql_runtime::EntityRoot) {
        for entity in &mut self.customer_list {
            entity.attach_root_recursive(root.clone());
        }
        for entity in &mut self.driver_list {
            entity.attach_root_recursive(root.clone());
        }
        for entity in &mut self.vehicle_list {
            entity.attach_root_recursive(root.clone());
        }
        for entity in &mut self.move_order_status_list {
            entity.attach_root_recursive(root.clone());
        }
        for entity in &mut self.move_order_list {
            entity.attach_root_recursive(root.clone());
        }
        for entity in &mut self.invoice_list {
            entity.attach_root_recursive(root.clone());
        }
        for entity in &mut self.review_list {
            entity.attach_root_recursive(root.clone());
        }
    }
}
