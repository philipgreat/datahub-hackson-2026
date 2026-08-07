
// ⛔ AI agents: DO NOT read this file for API discovery. Instead run: cargo teaql --input modeling/MODEL.xml rust-assist-query/delivery
use std::collections::BTreeMap;

use teaql_macros::TeaqlEntity;

/// [TEAQL AI WARNING]
/// TeaQL was explicitly designed to PREVENT AI hallucinations and random guessing.
/// DO NOT GUESS METHOD NAMES!
/// The methods listed below are the ONLY valid ways to interact with this entity.
/// If you encounter compilation errors (e.g., method not found), DO NOT guess another method name.
/// Read the method signatures in this file before proceeding.
#[derive(Clone, Debug, PartialEq, TeaqlEntity)]
#[teaql(entity = "Delivery", table = "delivery_data", data_service = "sqlite")]
pub struct Delivery {
#[teaql(id)]
    id: u64,

// @source massive_erp_model.xml:448
    recipient_signature: String,

// @source massive_erp_model.xml:448
    delivery_date: teaql_core::time::Timestamp,

// @source massive_erp_model.xml:448
    status: String,

// @source massive_erp_model.xml:448
    create_time: teaql_core::time::Timestamp,

// @source massive_erp_model.xml:448
    update_time: teaql_core::time::Timestamp,
#[teaql(version)]
    version: i64,
// @source massive_erp_model.xml:448
#[teaql(column = "shipment")]
    shipment_id: u64,
// @source massive_erp_model.xml:448
#[teaql(relation(target = "Shipment", local_key = "shipment_id", foreign_key = "id"))]
    shipment: Option<crate::Shipment>,
    #[teaql(dynamic)]
    dynamic: BTreeMap<String, teaql_core::Value>,
    #[teaql(skip)]
    root: teaql_runtime::EntityRoot,
    #[teaql(skip)]
    pub __load_state: teaql_core::eval::LoadState,
}

impl Delivery {
    pub fn with_id(id: u64) -> teaql_core::Value {
        teaql_core::Value::U64(id)
    }

    pub(crate) fn runtime_new(root: teaql_runtime::EntityRoot) -> Self {
        Self {
            id: 0_u64,
            recipient_signature: String::new(),
            delivery_date: teaql_core::time::Timestamp::now(),
            status: String::new(),
            create_time: teaql_core::time::Timestamp::now(),
            update_time: teaql_core::time::Timestamp::now(),
            version: 0_i64,
            shipment_id: 0_u64,
            shipment: None,
            dynamic: BTreeMap::new(),
            root,
            __load_state: teaql_core::eval::LoadState::FullyLoaded,
        }
    }

    pub fn entity_key(&self) -> teaql_runtime::EntityKey {
        teaql_runtime::EntityKey::new("Delivery", self.id)
    }

    pub fn attach_root_recursive(&mut self, root: teaql_runtime::EntityRoot) {
        self.root = root.clone();
        if let Some(entity) = &mut self.shipment {
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

    pub fn recipient_signature(&self) -> String {
        self.changed_recipient_signature().and_then(|value| value.try_text().map(|value| value.to_owned())).unwrap_or_else(|| self.recipient_signature.clone())
    }

    pub fn update_recipient_signature(&mut self, value: impl Into<teaql_core::Value>) -> &mut Self {
        let value = value.into();
        self.recipient_signature = value.try_text().map(|value| value.trim().to_owned()).unwrap_or_else(|| self.recipient_signature.clone());
        self.root.set(self.entity_key(), "recipient_signature", value);
        self
    }

    pub fn changed_recipient_signature(&self) -> Option<teaql_core::Value> {
        self.root.get(&self.entity_key(), "recipient_signature")
    }

    pub fn eval_recipient_signature(&self) -> teaql_core::eval::EvalResult<String> {
        if !self.is_loaded("recipient_signature") {
                    teaql_core::eval::EvalResult::NotLoaded { failed_node: "recipient_signature".to_string(), attempted_path: "recipient_signature".to_string() }
                } else {
                    teaql_core::eval::EvalResult::Value(self.recipient_signature())
                }}

    pub fn delivery_date(&self) -> teaql_core::time::Timestamp {
        self.changed_delivery_date().and_then(|value| value.try_timestamp()).unwrap_or(self.delivery_date)
    }

    pub fn update_delivery_date(&mut self, value: impl Into<teaql_core::Value>) -> &mut Self {
        let value = value.into();
        self.delivery_date = value.try_timestamp().unwrap_or(self.delivery_date.clone());
        self.root.set(self.entity_key(), "delivery_date", value);
        self
    }

    pub fn changed_delivery_date(&self) -> Option<teaql_core::Value> {
        self.root.get(&self.entity_key(), "delivery_date")
    }

    pub fn eval_delivery_date(&self) -> teaql_core::eval::EvalResult<teaql_core::time::Timestamp> {
        if !self.is_loaded("delivery_date") {
                    teaql_core::eval::EvalResult::NotLoaded { failed_node: "delivery_date".to_string(), attempted_path: "delivery_date".to_string() }
                } else {
                    teaql_core::eval::EvalResult::Value(self.delivery_date())
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
    pub fn shipment_id(&self) -> u64 {
        self.changed_shipment_id().and_then(|value| value.try_u64()).unwrap_or(self.shipment_id)
    }

    pub fn update_shipment_id(&mut self, value: impl Into<teaql_core::Value>) -> &mut Self {
        let value = value.into();
        self.shipment_id = value.try_u64().unwrap_or(self.shipment_id.clone());
        self.root.set(self.entity_key(), "shipment_id", value);
        self
    }

    pub fn changed_shipment_id(&self) -> Option<teaql_core::Value> {
        self.root.get(&self.entity_key(), "shipment_id")
    }

    pub fn eval_shipment_id(&self) -> teaql_core::eval::EvalResult<u64> {
        if !self.is_loaded("shipment_id") {
                    teaql_core::eval::EvalResult::NotLoaded { failed_node: "shipment_id".to_string(), attempted_path: "shipment_id".to_string() }
                } else {
                    teaql_core::eval::EvalResult::Value(self.shipment_id())
                }}
    pub fn shipment(&self) -> Option<&crate::Shipment> {
        self.shipment.as_ref()
    }

    pub fn eval_shipment(&self) -> teaql_core::eval::EvalResult<&crate::Shipment> {
        if !self.is_loaded("shipment") {
            teaql_core::eval::EvalResult::NotLoaded { failed_node: "shipment".to_string(), attempted_path: "shipment".to_string() }
        } else {
            match &self.shipment {
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

