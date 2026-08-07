
// ⛔ AI agents: DO NOT read this file for API discovery. Instead run: cargo teaql --input modeling/MODEL.xml rust-assist-query/product
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
#[teaql(entity = "Product", table = "product_data", data_service = "sqlite")]
pub struct Product {
#[teaql(id)]
    id: u64,

// @source massive_erp_model.xml:192
    name: String,

// @source massive_erp_model.xml:192
    price: rust_decimal::Decimal,

// @source massive_erp_model.xml:192
    cost: rust_decimal::Decimal,

// @source massive_erp_model.xml:192
    is_active: bool,

// @source massive_erp_model.xml:192
    sku: String,

// @source massive_erp_model.xml:192
    stock: rust_decimal::Decimal,

// @source massive_erp_model.xml:192
    create_time: teaql_core::time::Timestamp,

// @source massive_erp_model.xml:192
    update_time: teaql_core::time::Timestamp,
#[teaql(version)]
    version: i64,
// @source massive_erp_model.xml:192
#[teaql(column = "category")]
    category_id: u64,
// @source massive_erp_model.xml:192
#[teaql(relation(target = "Category", local_key = "category_id", foreign_key = "id"))]
    category: Option<crate::Category>,
#[teaql(relation(target = "ProductReview", local_key = "id", foreign_key = "product_id", many))]
    product_review_list: SmartList<crate::ProductReview>,
#[teaql(relation(target = "CartItem", local_key = "id", foreign_key = "product_id", many))]
    cart_item_list: SmartList<crate::CartItem>,
#[teaql(relation(target = "OrderItem", local_key = "id", foreign_key = "product_id", many))]
    order_item_list: SmartList<crate::OrderItem>,
#[teaql(relation(target = "InventoryItem", local_key = "id", foreign_key = "product_id", many))]
    inventory_item_list: SmartList<crate::InventoryItem>,
#[teaql(relation(target = "PurchaseOrderItem", local_key = "id", foreign_key = "product_id", many))]
    purchase_order_item_list: SmartList<crate::PurchaseOrderItem>,
    #[teaql(dynamic)]
    dynamic: BTreeMap<String, teaql_core::Value>,
    #[teaql(skip)]
    root: teaql_runtime::EntityRoot,
    #[teaql(skip)]
    pub __load_state: teaql_core::eval::LoadState,
}

impl Product {
    pub fn with_id(id: u64) -> teaql_core::Value {
        teaql_core::Value::U64(id)
    }

    pub(crate) fn runtime_new(root: teaql_runtime::EntityRoot) -> Self {
        Self {
            id: 0_u64,
            name: String::new(),
            price: rust_decimal::Decimal::ZERO,
            cost: rust_decimal::Decimal::ZERO,
            is_active: false,
            sku: String::new(),
            stock: rust_decimal::Decimal::ZERO,
            create_time: teaql_core::time::Timestamp::now(),
            update_time: teaql_core::time::Timestamp::now(),
            version: 0_i64,
            category_id: 0_u64,
            category: None,
            product_review_list: Default::default(),
            cart_item_list: Default::default(),
            order_item_list: Default::default(),
            inventory_item_list: Default::default(),
            purchase_order_item_list: Default::default(),
            dynamic: BTreeMap::new(),
            root,
            __load_state: teaql_core::eval::LoadState::FullyLoaded,
        }
    }

    pub fn entity_key(&self) -> teaql_runtime::EntityKey {
        teaql_runtime::EntityKey::new("Product", self.id)
    }

    pub fn attach_root_recursive(&mut self, root: teaql_runtime::EntityRoot) {
        self.root = root.clone();
        if let Some(entity) = &mut self.category {
            entity.attach_root_recursive(root.clone());
        }
        for entity in &mut self.product_review_list {
            entity.attach_root_recursive(root.clone());
        }
        for entity in &mut self.cart_item_list {
            entity.attach_root_recursive(root.clone());
        }
        for entity in &mut self.order_item_list {
            entity.attach_root_recursive(root.clone());
        }
        for entity in &mut self.inventory_item_list {
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

    pub fn price(&self) -> rust_decimal::Decimal {
        self.changed_price().and_then(|value| value.try_decimal()).unwrap_or(self.price)
    }

    pub fn update_price(&mut self, value: impl Into<teaql_core::Value>) -> &mut Self {
        let value = value.into();
        self.price = value.try_decimal().unwrap_or(self.price.clone());
        self.root.set(self.entity_key(), "price", value);
        self
    }

    pub fn changed_price(&self) -> Option<teaql_core::Value> {
        self.root.get(&self.entity_key(), "price")
    }

    pub fn eval_price(&self) -> teaql_core::eval::EvalResult<rust_decimal::Decimal> {
        if !self.is_loaded("price") {
                    teaql_core::eval::EvalResult::NotLoaded { failed_node: "price".to_string(), attempted_path: "price".to_string() }
                } else {
                    teaql_core::eval::EvalResult::Value(self.price())
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

    pub fn is_active(&self) -> bool {
        self.changed_is_active().and_then(|value| value.try_bool()).unwrap_or(self.is_active)
    }

    pub fn update_is_active(&mut self, value: impl Into<teaql_core::Value>) -> &mut Self {
        let value = value.into();
        self.is_active = value.try_bool().unwrap_or(self.is_active.clone());
        self.root.set(self.entity_key(), "is_active", value);
        self
    }

    pub fn changed_is_active(&self) -> Option<teaql_core::Value> {
        self.root.get(&self.entity_key(), "is_active")
    }

    pub fn eval_is_active(&self) -> teaql_core::eval::EvalResult<bool> {
        if !self.is_loaded("is_active") {
                    teaql_core::eval::EvalResult::NotLoaded { failed_node: "is_active".to_string(), attempted_path: "is_active".to_string() }
                } else {
                    teaql_core::eval::EvalResult::Value(self.is_active())
                }}

    pub fn sku(&self) -> String {
        self.changed_sku().and_then(|value| value.try_text().map(|value| value.to_owned())).unwrap_or_else(|| self.sku.clone())
    }

    pub fn update_sku(&mut self, value: impl Into<teaql_core::Value>) -> &mut Self {
        let value = value.into();
        self.sku = value.try_text().map(|value| value.trim().to_owned()).unwrap_or_else(|| self.sku.clone());
        self.root.set(self.entity_key(), "sku", value);
        self
    }

    pub fn changed_sku(&self) -> Option<teaql_core::Value> {
        self.root.get(&self.entity_key(), "sku")
    }

    pub fn eval_sku(&self) -> teaql_core::eval::EvalResult<String> {
        if !self.is_loaded("sku") {
                    teaql_core::eval::EvalResult::NotLoaded { failed_node: "sku".to_string(), attempted_path: "sku".to_string() }
                } else {
                    teaql_core::eval::EvalResult::Value(self.sku())
                }}

    pub fn stock(&self) -> rust_decimal::Decimal {
        self.changed_stock().and_then(|value| value.try_decimal()).unwrap_or(self.stock)
    }

    pub fn update_stock(&mut self, value: impl Into<teaql_core::Value>) -> &mut Self {
        let value = value.into();
        self.stock = value.try_decimal().unwrap_or(self.stock.clone());
        self.root.set(self.entity_key(), "stock", value);
        self
    }

    pub fn changed_stock(&self) -> Option<teaql_core::Value> {
        self.root.get(&self.entity_key(), "stock")
    }

    pub fn eval_stock(&self) -> teaql_core::eval::EvalResult<rust_decimal::Decimal> {
        if !self.is_loaded("stock") {
                    teaql_core::eval::EvalResult::NotLoaded { failed_node: "stock".to_string(), attempted_path: "stock".to_string() }
                } else {
                    teaql_core::eval::EvalResult::Value(self.stock())
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
    pub fn category_id(&self) -> u64 {
        self.changed_category_id().and_then(|value| value.try_u64()).unwrap_or(self.category_id)
    }

    pub fn update_category_id(&mut self, value: impl Into<teaql_core::Value>) -> &mut Self {
        let value = value.into();
        self.category_id = value.try_u64().unwrap_or(self.category_id.clone());
        self.root.set(self.entity_key(), "category_id", value);
        self
    }

    pub fn changed_category_id(&self) -> Option<teaql_core::Value> {
        self.root.get(&self.entity_key(), "category_id")
    }

    pub fn eval_category_id(&self) -> teaql_core::eval::EvalResult<u64> {
        if !self.is_loaded("category_id") {
                    teaql_core::eval::EvalResult::NotLoaded { failed_node: "category_id".to_string(), attempted_path: "category_id".to_string() }
                } else {
                    teaql_core::eval::EvalResult::Value(self.category_id())
                }}
    pub fn category(&self) -> Option<&crate::Category> {
        self.category.as_ref()
    }

    pub fn eval_category(&self) -> teaql_core::eval::EvalResult<&crate::Category> {
        if !self.is_loaded("category") {
            teaql_core::eval::EvalResult::NotLoaded { failed_node: "category".to_string(), attempted_path: "category".to_string() }
        } else {
            match &self.category {
                Some(v) => teaql_core::eval::EvalResult::Value(v),
                None => teaql_core::eval::EvalResult::Null,
            }
        }
    }
    pub fn product_review_list(&self) -> &SmartList<crate::ProductReview> {
        &self.product_review_list
    }

    pub fn product_review_list_mut(&mut self) -> &mut SmartList<crate::ProductReview> {
        &mut self.product_review_list
    }

    pub fn eval_product_review_list(&self) -> teaql_core::eval::EvalResult<&SmartList<crate::ProductReview>> {
        if !self.is_loaded("product_review_list") {
            teaql_core::eval::EvalResult::NotLoaded { failed_node: "product_review_list".to_string(), attempted_path: "product_review_list".to_string() }
        } else {
            teaql_core::eval::EvalResult::Value(&self.product_review_list)
        }
    }

    pub fn cart_item_list(&self) -> &SmartList<crate::CartItem> {
        &self.cart_item_list
    }

    pub fn cart_item_list_mut(&mut self) -> &mut SmartList<crate::CartItem> {
        &mut self.cart_item_list
    }

    pub fn eval_cart_item_list(&self) -> teaql_core::eval::EvalResult<&SmartList<crate::CartItem>> {
        if !self.is_loaded("cart_item_list") {
            teaql_core::eval::EvalResult::NotLoaded { failed_node: "cart_item_list".to_string(), attempted_path: "cart_item_list".to_string() }
        } else {
            teaql_core::eval::EvalResult::Value(&self.cart_item_list)
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

    pub fn inventory_item_list(&self) -> &SmartList<crate::InventoryItem> {
        &self.inventory_item_list
    }

    pub fn inventory_item_list_mut(&mut self) -> &mut SmartList<crate::InventoryItem> {
        &mut self.inventory_item_list
    }

    pub fn eval_inventory_item_list(&self) -> teaql_core::eval::EvalResult<&SmartList<crate::InventoryItem>> {
        if !self.is_loaded("inventory_item_list") {
            teaql_core::eval::EvalResult::NotLoaded { failed_node: "inventory_item_list".to_string(), attempted_path: "inventory_item_list".to_string() }
        } else {
            teaql_core::eval::EvalResult::Value(&self.inventory_item_list)
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

