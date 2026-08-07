
// ⛔ AI agents: DO NOT read this file for API discovery. Instead run: cargo teaql --input modeling/MODEL.xml rust-assist-query/global_order
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
#[teaql(entity = "GlobalOrder", table = "global_order_data", data_service = "sqlite")]
pub struct GlobalOrder {
#[teaql(id)]
    id: u64,

// @source massive_erp_model.xml:252
    shipping_address: String,

// @source massive_erp_model.xml:252
    total_amount: rust_decimal::Decimal,

// @source massive_erp_model.xml:252
    order_date: teaql_core::time::Timestamp,

// @source massive_erp_model.xml:252
    status: String,

// @source massive_erp_model.xml:252
    create_time: teaql_core::time::Timestamp,

// @source massive_erp_model.xml:252
    update_time: teaql_core::time::Timestamp,
#[teaql(version)]
    version: i64,
// @source massive_erp_model.xml:252
#[teaql(column = "customer")]
    customer_id: u64,
// @source massive_erp_model.xml:252
#[teaql(relation(target = "Customer", local_key = "customer_id", foreign_key = "id"))]
    customer: Option<crate::Customer>,
#[teaql(relation(target = "OrderItem", local_key = "id", foreign_key = "global_order_id", many))]
    order_item_list: SmartList<crate::OrderItem>,
#[teaql(relation(target = "Invoice", local_key = "id", foreign_key = "global_order_id", many))]
    invoice_list: SmartList<crate::Invoice>,
#[teaql(relation(target = "Shipment", local_key = "id", foreign_key = "global_order_id", many))]
    shipment_list: SmartList<crate::Shipment>,
#[teaql(relation(target = "ReturnRequest", local_key = "id", foreign_key = "global_order_id", many))]
    return_request_list: SmartList<crate::ReturnRequest>,
    #[teaql(dynamic)]
    dynamic: BTreeMap<String, teaql_core::Value>,
    #[teaql(skip)]
    root: teaql_runtime::EntityRoot,
    #[teaql(skip)]
    pub __load_state: teaql_core::eval::LoadState,
}

impl GlobalOrder {
    pub fn with_id(id: u64) -> teaql_core::Value {
        teaql_core::Value::U64(id)
    }

    pub(crate) fn runtime_new(root: teaql_runtime::EntityRoot) -> Self {
        Self {
            id: 0_u64,
            shipping_address: String::new(),
            total_amount: rust_decimal::Decimal::ZERO,
            order_date: teaql_core::time::Timestamp::now(),
            status: String::new(),
            create_time: teaql_core::time::Timestamp::now(),
            update_time: teaql_core::time::Timestamp::now(),
            version: 0_i64,
            customer_id: 0_u64,
            customer: None,
            order_item_list: Default::default(),
            invoice_list: Default::default(),
            shipment_list: Default::default(),
            return_request_list: Default::default(),
            dynamic: BTreeMap::new(),
            root,
            __load_state: teaql_core::eval::LoadState::FullyLoaded,
        }
    }

    pub fn entity_key(&self) -> teaql_runtime::EntityKey {
        teaql_runtime::EntityKey::new("GlobalOrder", self.id)
    }

    pub fn attach_root_recursive(&mut self, root: teaql_runtime::EntityRoot) {
        self.root = root.clone();
        if let Some(entity) = &mut self.customer {
            entity.attach_root_recursive(root.clone());
        }
        for entity in &mut self.order_item_list {
            entity.attach_root_recursive(root.clone());
        }
        for entity in &mut self.invoice_list {
            entity.attach_root_recursive(root.clone());
        }
        for entity in &mut self.shipment_list {
            entity.attach_root_recursive(root.clone());
        }
        for entity in &mut self.return_request_list {
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

    pub fn shipping_address(&self) -> String {
        self.changed_shipping_address().and_then(|value| value.try_text().map(|value| value.to_owned())).unwrap_or_else(|| self.shipping_address.clone())
    }

    pub fn update_shipping_address(&mut self, value: impl Into<teaql_core::Value>) -> &mut Self {
        let value = value.into();
        self.shipping_address = value.try_text().map(|value| value.trim().to_owned()).unwrap_or_else(|| self.shipping_address.clone());
        self.root.set(self.entity_key(), "shipping_address", value);
        self
    }

    pub fn changed_shipping_address(&self) -> Option<teaql_core::Value> {
        self.root.get(&self.entity_key(), "shipping_address")
    }

    pub fn eval_shipping_address(&self) -> teaql_core::eval::EvalResult<String> {
        if !self.is_loaded("shipping_address") {
                    teaql_core::eval::EvalResult::NotLoaded { failed_node: "shipping_address".to_string(), attempted_path: "shipping_address".to_string() }
                } else {
                    teaql_core::eval::EvalResult::Value(self.shipping_address())
                }}

    pub fn total_amount(&self) -> rust_decimal::Decimal {
        self.changed_total_amount().and_then(|value| value.try_decimal()).unwrap_or(self.total_amount)
    }

    pub fn update_total_amount(&mut self, value: impl Into<teaql_core::Value>) -> &mut Self {
        let value = value.into();
        self.total_amount = value.try_decimal().unwrap_or(self.total_amount.clone());
        self.root.set(self.entity_key(), "total_amount", value);
        self
    }

    pub fn changed_total_amount(&self) -> Option<teaql_core::Value> {
        self.root.get(&self.entity_key(), "total_amount")
    }

    pub fn eval_total_amount(&self) -> teaql_core::eval::EvalResult<rust_decimal::Decimal> {
        if !self.is_loaded("total_amount") {
                    teaql_core::eval::EvalResult::NotLoaded { failed_node: "total_amount".to_string(), attempted_path: "total_amount".to_string() }
                } else {
                    teaql_core::eval::EvalResult::Value(self.total_amount())
                }}

    pub fn order_date(&self) -> teaql_core::time::Timestamp {
        self.changed_order_date().and_then(|value| value.try_timestamp()).unwrap_or(self.order_date)
    }

    pub fn update_order_date(&mut self, value: impl Into<teaql_core::Value>) -> &mut Self {
        let value = value.into();
        self.order_date = value.try_timestamp().unwrap_or(self.order_date.clone());
        self.root.set(self.entity_key(), "order_date", value);
        self
    }

    pub fn changed_order_date(&self) -> Option<teaql_core::Value> {
        self.root.get(&self.entity_key(), "order_date")
    }

    pub fn eval_order_date(&self) -> teaql_core::eval::EvalResult<teaql_core::time::Timestamp> {
        if !self.is_loaded("order_date") {
                    teaql_core::eval::EvalResult::NotLoaded { failed_node: "order_date".to_string(), attempted_path: "order_date".to_string() }
                } else {
                    teaql_core::eval::EvalResult::Value(self.order_date())
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
    pub fn order_item_list(&self) -> &SmartList<crate::OrderItem> {
        &self.order_item_list
    }

    pub fn order_item_list_mut(&mut self) -> &mut SmartList<crate::OrderItem> {
        &mut self.order_item_list
    }

    pub fn eval_order_item_list(&self) -> teaql_core::eval::EvalResult<&SmartList<crate::OrderItem>> {
        if !self.is_loaded("order_item_list") {
            teaql_core::eval::EvalResult::NotLoaded { failed_node: "order_item_list".to_string(), attempted_path: "order_item_list".to_string() }
        } else {
            teaql_core::eval::EvalResult::Value(&self.order_item_list)
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

    pub fn shipment_list(&self) -> &SmartList<crate::Shipment> {
        &self.shipment_list
    }

    pub fn shipment_list_mut(&mut self) -> &mut SmartList<crate::Shipment> {
        &mut self.shipment_list
    }

    pub fn eval_shipment_list(&self) -> teaql_core::eval::EvalResult<&SmartList<crate::Shipment>> {
        if !self.is_loaded("shipment_list") {
            teaql_core::eval::EvalResult::NotLoaded { failed_node: "shipment_list".to_string(), attempted_path: "shipment_list".to_string() }
        } else {
            teaql_core::eval::EvalResult::Value(&self.shipment_list)
        }
    }

    pub fn return_request_list(&self) -> &SmartList<crate::ReturnRequest> {
        &self.return_request_list
    }

    pub fn return_request_list_mut(&mut self) -> &mut SmartList<crate::ReturnRequest> {
        &mut self.return_request_list
    }

    pub fn eval_return_request_list(&self) -> teaql_core::eval::EvalResult<&SmartList<crate::ReturnRequest>> {
        if !self.is_loaded("return_request_list") {
            teaql_core::eval::EvalResult::NotLoaded { failed_node: "return_request_list".to_string(), attempted_path: "return_request_list".to_string() }
        } else {
            teaql_core::eval::EvalResult::Value(&self.return_request_list)
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

