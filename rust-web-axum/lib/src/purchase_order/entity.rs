
// ⛔ AI agents: DO NOT read this file for API discovery. Instead run: cargo teaql --input modeling/MODEL.xml rust-assist-query/purchase_order
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
#[teaql(entity = "PurchaseOrder", table = "purchase_order_data", data_service = "sqlite")]
pub struct PurchaseOrder {
#[teaql(id)]
    id: u64,

// @source massive_erp_model.xml:416
    order_date: teaql_core::time::Timestamp,

// @source massive_erp_model.xml:416
    status: String,

// @source massive_erp_model.xml:416
    total_cost: rust_decimal::Decimal,

// @source massive_erp_model.xml:416
    create_time: teaql_core::time::Timestamp,

// @source massive_erp_model.xml:416
    update_time: teaql_core::time::Timestamp,
#[teaql(version)]
    version: i64,
// @source massive_erp_model.xml:416
#[teaql(column = "supplier")]
    supplier_id: u64,
// @source massive_erp_model.xml:416
#[teaql(relation(target = "Supplier", local_key = "supplier_id", foreign_key = "id"))]
    supplier: Option<crate::Supplier>,
#[teaql(relation(target = "PurchaseOrderItem", local_key = "id", foreign_key = "purchase_order_id", many))]
    purchase_order_item_list: SmartList<crate::PurchaseOrderItem>,
    #[teaql(dynamic)]
    dynamic: BTreeMap<String, teaql_core::Value>,
    #[teaql(skip)]
    root: teaql_runtime::EntityRoot,
    #[teaql(skip)]
    pub __load_state: teaql_core::eval::LoadState,
}

impl PurchaseOrder {
    pub fn with_id(id: u64) -> teaql_core::Value {
        teaql_core::Value::U64(id)
    }

    pub(crate) fn runtime_new(root: teaql_runtime::EntityRoot) -> Self {
        Self {
            id: 0_u64,
            order_date: teaql_core::time::Timestamp::now(),
            status: String::new(),
            total_cost: rust_decimal::Decimal::ZERO,
            create_time: teaql_core::time::Timestamp::now(),
            update_time: teaql_core::time::Timestamp::now(),
            version: 0_i64,
            supplier_id: 0_u64,
            supplier: None,
            purchase_order_item_list: Default::default(),
            dynamic: BTreeMap::new(),
            root,
            __load_state: teaql_core::eval::LoadState::FullyLoaded,
        }
    }

    pub fn entity_key(&self) -> teaql_runtime::EntityKey {
        teaql_runtime::EntityKey::new("PurchaseOrder", self.id)
    }

    pub fn attach_root_recursive(&mut self, root: teaql_runtime::EntityRoot) {
        self.root = root.clone();
        if let Some(entity) = &mut self.supplier {
            entity.attach_root_recursive(root.clone());
        }
        for entity in &mut self.purchase_order_item_list {
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

    pub fn total_cost(&self) -> rust_decimal::Decimal {
        self.changed_total_cost().and_then(|value| value.try_decimal()).unwrap_or(self.total_cost)
    }

    pub fn update_total_cost(&mut self, value: impl Into<teaql_core::Value>) -> &mut Self {
        let value = value.into();
        self.total_cost = value.try_decimal().unwrap_or(self.total_cost.clone());
        self.root.set(self.entity_key(), "total_cost", value);
        self
    }

    pub fn changed_total_cost(&self) -> Option<teaql_core::Value> {
        self.root.get(&self.entity_key(), "total_cost")
    }

    pub fn eval_total_cost(&self) -> teaql_core::eval::EvalResult<rust_decimal::Decimal> {
        if !self.is_loaded("total_cost") {
                    teaql_core::eval::EvalResult::NotLoaded { failed_node: "total_cost".to_string(), attempted_path: "total_cost".to_string() }
                } else {
                    teaql_core::eval::EvalResult::Value(self.total_cost())
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
    pub fn supplier_id(&self) -> u64 {
        self.changed_supplier_id().and_then(|value| value.try_u64()).unwrap_or(self.supplier_id)
    }

    pub fn update_supplier_id(&mut self, value: impl Into<teaql_core::Value>) -> &mut Self {
        let value = value.into();
        self.supplier_id = value.try_u64().unwrap_or(self.supplier_id.clone());
        self.root.set(self.entity_key(), "supplier_id", value);
        self
    }

    pub fn changed_supplier_id(&self) -> Option<teaql_core::Value> {
        self.root.get(&self.entity_key(), "supplier_id")
    }

    pub fn eval_supplier_id(&self) -> teaql_core::eval::EvalResult<u64> {
        if !self.is_loaded("supplier_id") {
                    teaql_core::eval::EvalResult::NotLoaded { failed_node: "supplier_id".to_string(), attempted_path: "supplier_id".to_string() }
                } else {
                    teaql_core::eval::EvalResult::Value(self.supplier_id())
                }}
    pub fn supplier(&self) -> Option<&crate::Supplier> {
        self.supplier.as_ref()
    }

    pub fn eval_supplier(&self) -> teaql_core::eval::EvalResult<&crate::Supplier> {
        if !self.is_loaded("supplier") {
            teaql_core::eval::EvalResult::NotLoaded { failed_node: "supplier".to_string(), attempted_path: "supplier".to_string() }
        } else {
            match &self.supplier {
                Some(v) => teaql_core::eval::EvalResult::Value(v),
                None => teaql_core::eval::EvalResult::Null,
            }
        }
    }
    pub fn purchase_order_item_list(&self) -> &SmartList<crate::PurchaseOrderItem> {
        &self.purchase_order_item_list
    }

    pub fn purchase_order_item_list_mut(&mut self) -> &mut SmartList<crate::PurchaseOrderItem> {
        &mut self.purchase_order_item_list
    }

    pub fn eval_purchase_order_item_list(&self) -> teaql_core::eval::EvalResult<&SmartList<crate::PurchaseOrderItem>> {
        if !self.is_loaded("purchase_order_item_list") {
            teaql_core::eval::EvalResult::NotLoaded { failed_node: "purchase_order_item_list".to_string(), attempted_path: "purchase_order_item_list".to_string() }
        } else {
            teaql_core::eval::EvalResult::Value(&self.purchase_order_item_list)
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

