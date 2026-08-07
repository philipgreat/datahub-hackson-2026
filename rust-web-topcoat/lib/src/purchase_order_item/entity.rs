
// ⛔ AI agents: DO NOT read this file for API discovery. Instead run: cargo teaql --input modeling/MODEL.xml rust-assist-query/purchase_order_item
use std::collections::BTreeMap;

use teaql_macros::TeaqlEntity;

/// [TEAQL AI WARNING]
/// TeaQL was explicitly designed to PREVENT AI hallucinations and random guessing.
/// DO NOT GUESS METHOD NAMES!
/// The methods listed below are the ONLY valid ways to interact with this entity.
/// If you encounter compilation errors (e.g., method not found), DO NOT guess another method name.
/// Read the method signatures in this file before proceeding.
#[derive(Clone, Debug, PartialEq, TeaqlEntity)]
#[teaql(entity = "PurchaseOrderItem", table = "purchase_order_item_data", data_service = "sqlite")]
pub struct PurchaseOrderItem {
#[teaql(id)]
    id: u64,

// @source massive_erp_model.xml:426
    quantity: rust_decimal::Decimal,

// @source massive_erp_model.xml:426
    unit_cost: rust_decimal::Decimal,

// @source massive_erp_model.xml:426
    create_time: teaql_core::time::Timestamp,

// @source massive_erp_model.xml:426
    update_time: teaql_core::time::Timestamp,
#[teaql(version)]
    version: i64,
// @source massive_erp_model.xml:426
#[teaql(column = "product")]
    product_id: u64,

// @source massive_erp_model.xml:426
#[teaql(column = "purchase_order")]
    purchase_order_id: u64,
// @source massive_erp_model.xml:426
#[teaql(relation(target = "Product", local_key = "product_id", foreign_key = "id"))]
    product: Option<crate::Product>,

// @source massive_erp_model.xml:426
#[teaql(relation(target = "PurchaseOrder", local_key = "purchase_order_id", foreign_key = "id"))]
    purchase_order: Option<crate::PurchaseOrder>,
    #[teaql(dynamic)]
    dynamic: BTreeMap<String, teaql_core::Value>,
    #[teaql(skip)]
    root: teaql_runtime::EntityRoot,
    #[teaql(skip)]
    pub __load_state: teaql_core::eval::LoadState,
}

impl PurchaseOrderItem {
    pub fn with_id(id: u64) -> teaql_core::Value {
        teaql_core::Value::U64(id)
    }

    pub(crate) fn runtime_new(root: teaql_runtime::EntityRoot) -> Self {
        Self {
            id: 0_u64,
            quantity: rust_decimal::Decimal::ZERO,
            unit_cost: rust_decimal::Decimal::ZERO,
            create_time: teaql_core::time::Timestamp::now(),
            update_time: teaql_core::time::Timestamp::now(),
            version: 0_i64,
            product_id: 0_u64,
            purchase_order_id: 0_u64,
            product: None,
            purchase_order: None,
            dynamic: BTreeMap::new(),
            root,
            __load_state: teaql_core::eval::LoadState::FullyLoaded,
        }
    }

    pub fn entity_key(&self) -> teaql_runtime::EntityKey {
        teaql_runtime::EntityKey::new("PurchaseOrderItem", self.id)
    }

    pub fn attach_root_recursive(&mut self, root: teaql_runtime::EntityRoot) {
        self.root = root.clone();
        if let Some(entity) = &mut self.product {
            entity.attach_root_recursive(root.clone());
        }
        if let Some(entity) = &mut self.purchase_order {
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

    pub fn quantity(&self) -> rust_decimal::Decimal {
        self.changed_quantity().and_then(|value| value.try_decimal()).unwrap_or(self.quantity)
    }

    pub fn update_quantity(&mut self, value: impl Into<teaql_core::Value>) -> &mut Self {
        let value = value.into();
        self.quantity = value.try_decimal().unwrap_or(self.quantity.clone());
        self.root.set(self.entity_key(), "quantity", value);
        self
    }

    pub fn changed_quantity(&self) -> Option<teaql_core::Value> {
        self.root.get(&self.entity_key(), "quantity")
    }

    pub fn eval_quantity(&self) -> teaql_core::eval::EvalResult<rust_decimal::Decimal> {
        if !self.is_loaded("quantity") {
                    teaql_core::eval::EvalResult::NotLoaded { failed_node: "quantity".to_string(), attempted_path: "quantity".to_string() }
                } else {
                    teaql_core::eval::EvalResult::Value(self.quantity())
                }}

    pub fn unit_cost(&self) -> rust_decimal::Decimal {
        self.changed_unit_cost().and_then(|value| value.try_decimal()).unwrap_or(self.unit_cost)
    }

    pub fn update_unit_cost(&mut self, value: impl Into<teaql_core::Value>) -> &mut Self {
        let value = value.into();
        self.unit_cost = value.try_decimal().unwrap_or(self.unit_cost.clone());
        self.root.set(self.entity_key(), "unit_cost", value);
        self
    }

    pub fn changed_unit_cost(&self) -> Option<teaql_core::Value> {
        self.root.get(&self.entity_key(), "unit_cost")
    }

    pub fn eval_unit_cost(&self) -> teaql_core::eval::EvalResult<rust_decimal::Decimal> {
        if !self.is_loaded("unit_cost") {
                    teaql_core::eval::EvalResult::NotLoaded { failed_node: "unit_cost".to_string(), attempted_path: "unit_cost".to_string() }
                } else {
                    teaql_core::eval::EvalResult::Value(self.unit_cost())
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
    pub fn product_id(&self) -> u64 {
        self.changed_product_id().and_then(|value| value.try_u64()).unwrap_or(self.product_id)
    }

    pub fn update_product_id(&mut self, value: impl Into<teaql_core::Value>) -> &mut Self {
        let value = value.into();
        self.product_id = value.try_u64().unwrap_or(self.product_id.clone());
        self.root.set(self.entity_key(), "product_id", value);
        self
    }

    pub fn changed_product_id(&self) -> Option<teaql_core::Value> {
        self.root.get(&self.entity_key(), "product_id")
    }

    pub fn eval_product_id(&self) -> teaql_core::eval::EvalResult<u64> {
        if !self.is_loaded("product_id") {
                    teaql_core::eval::EvalResult::NotLoaded { failed_node: "product_id".to_string(), attempted_path: "product_id".to_string() }
                } else {
                    teaql_core::eval::EvalResult::Value(self.product_id())
                }}

    pub fn purchase_order_id(&self) -> u64 {
        self.changed_purchase_order_id().and_then(|value| value.try_u64()).unwrap_or(self.purchase_order_id)
    }

    pub fn update_purchase_order_id(&mut self, value: impl Into<teaql_core::Value>) -> &mut Self {
        let value = value.into();
        self.purchase_order_id = value.try_u64().unwrap_or(self.purchase_order_id.clone());
        self.root.set(self.entity_key(), "purchase_order_id", value);
        self
    }

    pub fn changed_purchase_order_id(&self) -> Option<teaql_core::Value> {
        self.root.get(&self.entity_key(), "purchase_order_id")
    }

    pub fn eval_purchase_order_id(&self) -> teaql_core::eval::EvalResult<u64> {
        if !self.is_loaded("purchase_order_id") {
                    teaql_core::eval::EvalResult::NotLoaded { failed_node: "purchase_order_id".to_string(), attempted_path: "purchase_order_id".to_string() }
                } else {
                    teaql_core::eval::EvalResult::Value(self.purchase_order_id())
                }}
    pub fn product(&self) -> Option<&crate::Product> {
        self.product.as_ref()
    }

    pub fn eval_product(&self) -> teaql_core::eval::EvalResult<&crate::Product> {
        if !self.is_loaded("product") {
            teaql_core::eval::EvalResult::NotLoaded { failed_node: "product".to_string(), attempted_path: "product".to_string() }
        } else {
            match &self.product {
                Some(v) => teaql_core::eval::EvalResult::Value(v),
                None => teaql_core::eval::EvalResult::Null,
            }
        }
    }

    pub fn purchase_order(&self) -> Option<&crate::PurchaseOrder> {
        self.purchase_order.as_ref()
    }

    pub fn eval_purchase_order(&self) -> teaql_core::eval::EvalResult<&crate::PurchaseOrder> {
        if !self.is_loaded("purchase_order") {
            teaql_core::eval::EvalResult::NotLoaded { failed_node: "purchase_order".to_string(), attempted_path: "purchase_order".to_string() }
        } else {
            match &self.purchase_order {
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

