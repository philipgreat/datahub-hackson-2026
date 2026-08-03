
// ⛔ AI agents: DO NOT read this file for API discovery. Instead run: cargo teaql --input modeling/MODEL.xml rust-assist-query/move_order
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
#[teaql(entity = "MoveOrder", table = "move_order_data", data_service = "sqlite")]
pub struct MoveOrder {
#[teaql(id)]
    id: u64,

// @source moving-company.xml:95
    origin_address: String,

// @source moving-company.xml:95
    destination_address: String,

// @source moving-company.xml:95
    scheduled_date: chrono::NaiveDate,

// @source moving-company.xml:95
    estimated_hours: i64,

// @source moving-company.xml:95
    special_instructions: String,

// @source moving-company.xml:95
    create_time: chrono::DateTime<chrono::Utc>,

// @source moving-company.xml:95
    update_time: chrono::DateTime<chrono::Utc>,
#[teaql(version)]
    version: i64,
// @source moving-company.xml:95
#[teaql(column = "company")]
    company_id: u64,

// @source moving-company.xml:95
#[teaql(column = "customer")]
    customer_id: u64,

// @source moving-company.xml:95
#[teaql(column = "driver")]
    driver_id: u64,

// @source moving-company.xml:95
#[teaql(column = "vehicle")]
    vehicle_id: u64,

// @source moving-company.xml:95
#[teaql(column = "status")]
    status_id: u64,
// @source moving-company.xml:95
#[teaql(relation(target = "Company", local_key = "company_id", foreign_key = "id"))]
    company: Option<crate::Company>,

// @source moving-company.xml:95
#[teaql(relation(target = "Customer", local_key = "customer_id", foreign_key = "id"))]
    customer: Option<crate::Customer>,

// @source moving-company.xml:95
#[teaql(relation(target = "Driver", local_key = "driver_id", foreign_key = "id"))]
    driver: Option<crate::Driver>,

// @source moving-company.xml:95
#[teaql(relation(target = "Vehicle", local_key = "vehicle_id", foreign_key = "id"))]
    vehicle: Option<crate::Vehicle>,

// @source moving-company.xml:95
#[teaql(relation(target = "MoveOrderStatus", local_key = "status_id", foreign_key = "id"))]
    status: Option<crate::MoveOrderStatus>,
#[teaql(relation(target = "Invoice", local_key = "id", foreign_key = "move_order_id", many))]
    invoice_list: SmartList<crate::Invoice>,
#[teaql(relation(target = "Review", local_key = "id", foreign_key = "move_order_id", many))]
    review_list: SmartList<crate::Review>,
    #[teaql(dynamic)]
    dynamic: BTreeMap<String, teaql_core::Value>,
    #[teaql(skip)]
    root: teaql_runtime::EntityRoot,
    #[teaql(skip)]
    pub __load_state: teaql_core::eval::LoadState,
}

impl MoveOrder {
    pub fn with_id(id: u64) -> teaql_core::Value {
        teaql_core::Value::U64(id)
    }

    pub(crate) fn runtime_new(root: teaql_runtime::EntityRoot) -> Self {
        Self {
            id: 0_u64,
            origin_address: String::new(),
            destination_address: String::new(),
            scheduled_date: chrono::NaiveDate::from_ymd_opt(1970, 1, 1).unwrap(),
            estimated_hours: 0_i64,
            special_instructions: String::new(),
            create_time: chrono::Utc::now(),
            update_time: chrono::Utc::now(),
            version: 0_i64,
            company_id: 0_u64,
            customer_id: 0_u64,
            driver_id: 0_u64,
            vehicle_id: 0_u64,
            status_id: 0_u64,
            company: None,
            customer: None,
            driver: None,
            vehicle: None,
            status: None,
            invoice_list: Default::default(),
            review_list: Default::default(),
            dynamic: BTreeMap::new(),
            root,
            __load_state: teaql_core::eval::LoadState::FullyLoaded,
        }
    }

    pub fn entity_key(&self) -> teaql_runtime::EntityKey {
        teaql_runtime::EntityKey::new("MoveOrder", self.id)
    }

    pub fn attach_root_recursive(&mut self, root: teaql_runtime::EntityRoot) {
        self.root = root.clone();
        if let Some(entity) = &mut self.company {
            entity.attach_root_recursive(root.clone());
        }
        if let Some(entity) = &mut self.customer {
            entity.attach_root_recursive(root.clone());
        }
        if let Some(entity) = &mut self.driver {
            entity.attach_root_recursive(root.clone());
        }
        if let Some(entity) = &mut self.vehicle {
            entity.attach_root_recursive(root.clone());
        }
        if let Some(entity) = &mut self.status {
            entity.attach_root_recursive(root.clone());
        }
        for entity in &mut self.invoice_list {
            entity.attach_root_recursive(root.clone());
        }
        for entity in &mut self.review_list {
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

    pub fn origin_address(&self) -> String {
        self.changed_origin_address().and_then(|value| value.try_text().map(|value| value.to_owned())).unwrap_or_else(|| self.origin_address.clone())
    }

    pub fn update_origin_address(&mut self, value: impl Into<teaql_core::Value>) -> &mut Self {
        let value = value.into();
        self.origin_address = value.try_text().map(|value| value.trim().to_owned()).unwrap_or_else(|| self.origin_address.clone());
        self.root.set(self.entity_key(), "origin_address", value);
        self
    }

    pub fn changed_origin_address(&self) -> Option<teaql_core::Value> {
        self.root.get(&self.entity_key(), "origin_address")
    }

    pub fn eval_origin_address(&self) -> teaql_core::eval::EvalResult<String> {
        if !self.is_loaded("origin_address") {
                    teaql_core::eval::EvalResult::NotLoaded { failed_node: "origin_address".to_string(), attempted_path: "origin_address".to_string() }
                } else {
                    teaql_core::eval::EvalResult::Value(self.origin_address())
                }}

    pub fn destination_address(&self) -> String {
        self.changed_destination_address().and_then(|value| value.try_text().map(|value| value.to_owned())).unwrap_or_else(|| self.destination_address.clone())
    }

    pub fn update_destination_address(&mut self, value: impl Into<teaql_core::Value>) -> &mut Self {
        let value = value.into();
        self.destination_address = value.try_text().map(|value| value.trim().to_owned()).unwrap_or_else(|| self.destination_address.clone());
        self.root.set(self.entity_key(), "destination_address", value);
        self
    }

    pub fn changed_destination_address(&self) -> Option<teaql_core::Value> {
        self.root.get(&self.entity_key(), "destination_address")
    }

    pub fn eval_destination_address(&self) -> teaql_core::eval::EvalResult<String> {
        if !self.is_loaded("destination_address") {
                    teaql_core::eval::EvalResult::NotLoaded { failed_node: "destination_address".to_string(), attempted_path: "destination_address".to_string() }
                } else {
                    teaql_core::eval::EvalResult::Value(self.destination_address())
                }}

    pub fn scheduled_date(&self) -> chrono::NaiveDate {
        self.changed_scheduled_date().and_then(|value| value.try_date()).unwrap_or(self.scheduled_date)
    }

    pub fn update_scheduled_date(&mut self, value: impl Into<teaql_core::Value>) -> &mut Self {
        let value = value.into();
        self.scheduled_date = value.try_date().unwrap_or(self.scheduled_date.clone());
        self.root.set(self.entity_key(), "scheduled_date", value);
        self
    }

    pub fn changed_scheduled_date(&self) -> Option<teaql_core::Value> {
        self.root.get(&self.entity_key(), "scheduled_date")
    }

    pub fn eval_scheduled_date(&self) -> teaql_core::eval::EvalResult<chrono::NaiveDate> {
        if !self.is_loaded("scheduled_date") {
                    teaql_core::eval::EvalResult::NotLoaded { failed_node: "scheduled_date".to_string(), attempted_path: "scheduled_date".to_string() }
                } else {
                    teaql_core::eval::EvalResult::Value(self.scheduled_date())
                }}

    pub fn estimated_hours(&self) -> i64 {
        self.changed_estimated_hours().and_then(|value| value.try_i64()).map(|value| value as i64).unwrap_or(self.estimated_hours)
    }

    pub fn update_estimated_hours(&mut self, value: impl Into<teaql_core::Value>) -> &mut Self {
        let value = value.into();
        self.estimated_hours = value.try_i64().map(|value| value as i64).unwrap_or(self.estimated_hours.clone());
        self.root.set(self.entity_key(), "estimated_hours", value);
        self
    }

    pub fn changed_estimated_hours(&self) -> Option<teaql_core::Value> {
        self.root.get(&self.entity_key(), "estimated_hours")
    }

    pub fn eval_estimated_hours(&self) -> teaql_core::eval::EvalResult<i64> {
        if !self.is_loaded("estimated_hours") {
                    teaql_core::eval::EvalResult::NotLoaded { failed_node: "estimated_hours".to_string(), attempted_path: "estimated_hours".to_string() }
                } else {
                    teaql_core::eval::EvalResult::Value(self.estimated_hours())
                }}

    pub fn special_instructions(&self) -> String {
        self.changed_special_instructions().and_then(|value| value.try_text().map(|value| value.to_owned())).unwrap_or_else(|| self.special_instructions.clone())
    }

    pub fn update_special_instructions(&mut self, value: impl Into<teaql_core::Value>) -> &mut Self {
        let value = value.into();
        self.special_instructions = value.try_text().map(|value| value.trim().to_owned()).unwrap_or_else(|| self.special_instructions.clone());
        self.root.set(self.entity_key(), "special_instructions", value);
        self
    }

    pub fn changed_special_instructions(&self) -> Option<teaql_core::Value> {
        self.root.get(&self.entity_key(), "special_instructions")
    }

    pub fn eval_special_instructions(&self) -> teaql_core::eval::EvalResult<String> {
        if !self.is_loaded("special_instructions") {
                    teaql_core::eval::EvalResult::NotLoaded { failed_node: "special_instructions".to_string(), attempted_path: "special_instructions".to_string() }
                } else {
                    teaql_core::eval::EvalResult::Value(self.special_instructions())
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
    pub fn company_id(&self) -> u64 {
        self.changed_company_id().and_then(|value| value.try_u64()).unwrap_or(self.company_id)
    }

    pub fn update_company_id(&mut self, value: impl Into<teaql_core::Value>) -> &mut Self {
        let value = value.into();
        self.company_id = value.try_u64().unwrap_or(self.company_id.clone());
        self.root.set(self.entity_key(), "company_id", value);
        self
    }

    pub fn changed_company_id(&self) -> Option<teaql_core::Value> {
        self.root.get(&self.entity_key(), "company_id")
    }

    pub fn eval_company_id(&self) -> teaql_core::eval::EvalResult<u64> {
        if !self.is_loaded("company_id") {
                    teaql_core::eval::EvalResult::NotLoaded { failed_node: "company_id".to_string(), attempted_path: "company_id".to_string() }
                } else {
                    teaql_core::eval::EvalResult::Value(self.company_id())
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

    pub fn driver_id(&self) -> u64 {
        self.changed_driver_id().and_then(|value| value.try_u64()).unwrap_or(self.driver_id)
    }

    pub fn update_driver_id(&mut self, value: impl Into<teaql_core::Value>) -> &mut Self {
        let value = value.into();
        self.driver_id = value.try_u64().unwrap_or(self.driver_id.clone());
        self.root.set(self.entity_key(), "driver_id", value);
        self
    }

    pub fn changed_driver_id(&self) -> Option<teaql_core::Value> {
        self.root.get(&self.entity_key(), "driver_id")
    }

    pub fn eval_driver_id(&self) -> teaql_core::eval::EvalResult<u64> {
        if !self.is_loaded("driver_id") {
                    teaql_core::eval::EvalResult::NotLoaded { failed_node: "driver_id".to_string(), attempted_path: "driver_id".to_string() }
                } else {
                    teaql_core::eval::EvalResult::Value(self.driver_id())
                }}

    pub fn vehicle_id(&self) -> u64 {
        self.changed_vehicle_id().and_then(|value| value.try_u64()).unwrap_or(self.vehicle_id)
    }

    pub fn update_vehicle_id(&mut self, value: impl Into<teaql_core::Value>) -> &mut Self {
        let value = value.into();
        self.vehicle_id = value.try_u64().unwrap_or(self.vehicle_id.clone());
        self.root.set(self.entity_key(), "vehicle_id", value);
        self
    }

    pub fn changed_vehicle_id(&self) -> Option<teaql_core::Value> {
        self.root.get(&self.entity_key(), "vehicle_id")
    }

    pub fn eval_vehicle_id(&self) -> teaql_core::eval::EvalResult<u64> {
        if !self.is_loaded("vehicle_id") {
                    teaql_core::eval::EvalResult::NotLoaded { failed_node: "vehicle_id".to_string(), attempted_path: "vehicle_id".to_string() }
                } else {
                    teaql_core::eval::EvalResult::Value(self.vehicle_id())
                }}

    pub fn status_id(&self) -> u64 {
        self.changed_status_id().and_then(|value| value.try_u64()).unwrap_or(self.status_id)
    }

    pub(crate) fn update_status_id(&mut self, value: impl Into<teaql_core::Value>) -> &mut Self {
        let value = value.into();
        self.status_id = value.try_u64().unwrap_or(self.status_id.clone());
        self.root.set(self.entity_key(), "status_id", value);
        self
    }

    pub fn changed_status_id(&self) -> Option<teaql_core::Value> {
        self.root.get(&self.entity_key(), "status_id")
    }

    pub fn eval_status_id(&self) -> teaql_core::eval::EvalResult<u64> {
        if !self.is_loaded("status_id") {
                    teaql_core::eval::EvalResult::NotLoaded { failed_node: "status_id".to_string(), attempted_path: "status_id".to_string() }
                } else {
                    teaql_core::eval::EvalResult::Value(self.status_id())
                }}
    pub fn update_status_to_pending(&mut self) -> &mut Self {
        self.update_status_id(1001_u64)
    }

    pub fn status_is_pending(&self) -> bool {
        self.status_id() == 1001_u64
    }
    pub fn update_status_to_confirmed(&mut self) -> &mut Self {
        self.update_status_id(1002_u64)
    }

    pub fn status_is_confirmed(&self) -> bool {
        self.status_id() == 1002_u64
    }
    pub fn update_status_to_assigned(&mut self) -> &mut Self {
        self.update_status_id(1003_u64)
    }

    pub fn status_is_assigned(&self) -> bool {
        self.status_id() == 1003_u64
    }
    pub fn update_status_to_in_transit(&mut self) -> &mut Self {
        self.update_status_id(1004_u64)
    }

    pub fn status_is_in_transit(&self) -> bool {
        self.status_id() == 1004_u64
    }
    pub fn update_status_to_delivered(&mut self) -> &mut Self {
        self.update_status_id(1005_u64)
    }

    pub fn status_is_delivered(&self) -> bool {
        self.status_id() == 1005_u64
    }
    pub fn update_status_to_cancelled(&mut self) -> &mut Self {
        self.update_status_id(1006_u64)
    }

    pub fn status_is_cancelled(&self) -> bool {
        self.status_id() == 1006_u64
    }
    pub fn company(&self) -> Option<&crate::Company> {
        self.company.as_ref()
    }

    pub fn eval_company(&self) -> teaql_core::eval::EvalResult<&crate::Company> {
        if !self.is_loaded("company") {
            teaql_core::eval::EvalResult::NotLoaded { failed_node: "company".to_string(), attempted_path: "company".to_string() }
        } else {
            match &self.company {
                Some(v) => teaql_core::eval::EvalResult::Value(v),
                None => teaql_core::eval::EvalResult::Null,
            }
        }
    }

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

    pub fn driver(&self) -> Option<&crate::Driver> {
        self.driver.as_ref()
    }

    pub fn eval_driver(&self) -> teaql_core::eval::EvalResult<&crate::Driver> {
        if !self.is_loaded("driver") {
            teaql_core::eval::EvalResult::NotLoaded { failed_node: "driver".to_string(), attempted_path: "driver".to_string() }
        } else {
            match &self.driver {
                Some(v) => teaql_core::eval::EvalResult::Value(v),
                None => teaql_core::eval::EvalResult::Null,
            }
        }
    }

    pub fn vehicle(&self) -> Option<&crate::Vehicle> {
        self.vehicle.as_ref()
    }

    pub fn eval_vehicle(&self) -> teaql_core::eval::EvalResult<&crate::Vehicle> {
        if !self.is_loaded("vehicle") {
            teaql_core::eval::EvalResult::NotLoaded { failed_node: "vehicle".to_string(), attempted_path: "vehicle".to_string() }
        } else {
            match &self.vehicle {
                Some(v) => teaql_core::eval::EvalResult::Value(v),
                None => teaql_core::eval::EvalResult::Null,
            }
        }
    }

    pub fn status(&self) -> Option<&crate::MoveOrderStatus> {
        self.status.as_ref()
    }

    pub fn eval_status(&self) -> teaql_core::eval::EvalResult<&crate::MoveOrderStatus> {
        if !self.is_loaded("status") {
            teaql_core::eval::EvalResult::NotLoaded { failed_node: "status".to_string(), attempted_path: "status".to_string() }
        } else {
            match &self.status {
                Some(v) => teaql_core::eval::EvalResult::Value(v),
                None => teaql_core::eval::EvalResult::Null,
            }
        }
    }
    pub fn invoice_list(&self) -> &SmartList<crate::Invoice> {
        &self.invoice_list
    }

    pub fn invoice_list_mut(&mut self) -> &mut SmartList<crate::Invoice> {
        &mut self.invoice_list
    }

    pub fn eval_invoice_list(&self) -> teaql_core::eval::EvalResult<&SmartList<crate::Invoice>> {
        if !self.is_loaded("invoice_list") {
            teaql_core::eval::EvalResult::NotLoaded { failed_node: "invoice_list".to_string(), attempted_path: "invoice_list".to_string() }
        } else {
            teaql_core::eval::EvalResult::Value(&self.invoice_list)
        }
    }

    pub fn review_list(&self) -> &SmartList<crate::Review> {
        &self.review_list
    }

    pub fn review_list_mut(&mut self) -> &mut SmartList<crate::Review> {
        &mut self.review_list
    }

    pub fn eval_review_list(&self) -> teaql_core::eval::EvalResult<&SmartList<crate::Review>> {
        if !self.is_loaded("review_list") {
            teaql_core::eval::EvalResult::NotLoaded { failed_node: "review_list".to_string(), attempted_path: "review_list".to_string() }
        } else {
            teaql_core::eval::EvalResult::Value(&self.review_list)
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

