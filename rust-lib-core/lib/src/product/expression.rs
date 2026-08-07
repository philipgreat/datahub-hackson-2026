#[derive(Clone)]
pub struct ProductExpression<'a> {
    result: teaql_core::eval::EvalResult<&'a crate::Product>,
    root_desc: std::sync::Arc<String>,
}

impl<'a> ProductExpression<'a> {
    pub fn new(result: teaql_core::eval::EvalResult<&'a crate::Product>, root_desc: std::sync::Arc<String>) -> Self {
        Self { result, root_desc }
    }

    fn resolve(&self) -> Option<&'a crate::Product> {
        match &self.result {
            teaql_core::eval::EvalResult::Value(v) => Some(*v),
            teaql_core::eval::EvalResult::Null => None,
            teaql_core::eval::EvalResult::NotLoaded { failed_node, attempted_path } => {
                crate::trigger_logic_bug_panic(&self.root_desc, &failed_node, &attempted_path)
            }
        }
    }

    pub fn eval(&self) -> Option<&'a crate::Product> {
        self.resolve()
    }

    pub fn unwrap(&self) -> &'a crate::Product {
        self.resolve().expect("Relation was legitimately null in database!")
    }

    pub fn get_id(self) -> crate::ValueExpression<'a, u64> {
        let next = self.result.and_then("id", |entity| entity.eval_id());
        crate::ValueExpression::new(next, self.root_desc.clone())
    }

    pub fn get_name(self) -> crate::ValueExpression<'a, String> {
        let next = self.result.and_then("name", |entity| entity.eval_name());
        crate::ValueExpression::new(next, self.root_desc.clone())
    }

    pub fn get_price(self) -> crate::ValueExpression<'a, rust_decimal::Decimal> {
        let next = self.result.and_then("price", |entity| entity.eval_price());
        crate::ValueExpression::new(next, self.root_desc.clone())
    }

    pub fn get_cost(self) -> crate::ValueExpression<'a, rust_decimal::Decimal> {
        let next = self.result.and_then("cost", |entity| entity.eval_cost());
        crate::ValueExpression::new(next, self.root_desc.clone())
    }

    pub fn get_is_active(self) -> crate::ValueExpression<'a, bool> {
        let next = self.result.and_then("is_active", |entity| entity.eval_is_active());
        crate::ValueExpression::new(next, self.root_desc.clone())
    }

    pub fn get_sku(self) -> crate::ValueExpression<'a, String> {
        let next = self.result.and_then("sku", |entity| entity.eval_sku());
        crate::ValueExpression::new(next, self.root_desc.clone())
    }

    pub fn get_stock(self) -> crate::ValueExpression<'a, rust_decimal::Decimal> {
        let next = self.result.and_then("stock", |entity| entity.eval_stock());
        crate::ValueExpression::new(next, self.root_desc.clone())
    }

    pub fn get_create_time(self) -> crate::ValueExpression<'a, teaql_core::time::Timestamp> {
        let next = self.result.and_then("create_time", |entity| entity.eval_create_time());
        crate::ValueExpression::new(next, self.root_desc.clone())
    }

    pub fn get_update_time(self) -> crate::ValueExpression<'a, teaql_core::time::Timestamp> {
        let next = self.result.and_then("update_time", |entity| entity.eval_update_time());
        crate::ValueExpression::new(next, self.root_desc.clone())
    }

    pub fn get_version(self) -> crate::ValueExpression<'a, i64> {
        let next = self.result.and_then("version", |entity| entity.eval_version());
        crate::ValueExpression::new(next, self.root_desc.clone())
    }
    pub fn get_category_id(self) -> crate::ValueExpression<'a, u64> {
        let next = self.result.and_then("category_id", |entity| entity.eval_category_id());
        crate::ValueExpression::new(next, self.root_desc.clone())
    }
    pub fn get_category(self) -> crate::CategoryExpression<'a> {
        let next = self.result.and_then("category", |entity| entity.eval_category());
        crate::CategoryExpression::new(next, self.root_desc.clone())
    }
    pub fn get_product_review_list(self) -> crate::ProductReviewListExpression<'a> {
        let next = self.result.and_then("product_review_list", |entity| entity.eval_product_review_list());
        crate::ProductReviewListExpression::new(next, self.root_desc.clone())
    }

    pub fn get_cart_item_list(self) -> crate::CartItemListExpression<'a> {
        let next = self.result.and_then("cart_item_list", |entity| entity.eval_cart_item_list());
        crate::CartItemListExpression::new(next, self.root_desc.clone())
    }

    pub fn get_order_item_list(self) -> crate::OrderItemListExpression<'a> {
        let next = self.result.and_then("order_item_list", |entity| entity.eval_order_item_list());
        crate::OrderItemListExpression::new(next, self.root_desc.clone())
    }

    pub fn get_inventory_item_list(self) -> crate::InventoryItemListExpression<'a> {
        let next = self.result.and_then("inventory_item_list", |entity| entity.eval_inventory_item_list());
        crate::InventoryItemListExpression::new(next, self.root_desc.clone())
    }

    pub fn get_purchase_order_item_list(self) -> crate::PurchaseOrderItemListExpression<'a> {
        let next = self.result.and_then("purchase_order_item_list", |entity| entity.eval_purchase_order_item_list());
        crate::PurchaseOrderItemListExpression::new(next, self.root_desc.clone())
    }
}

#[derive(Clone)]
pub struct ProductListExpression<'a> {
    result: teaql_core::eval::EvalResult<&'a teaql_core::SmartList<crate::Product>>,
    root_desc: std::sync::Arc<String>,
}

impl<'a> ProductListExpression<'a> {
    pub fn new(result: teaql_core::eval::EvalResult<&'a teaql_core::SmartList<crate::Product>>, root_desc: std::sync::Arc<String>) -> Self {
        Self { result, root_desc }
    }

    fn resolve(&self) -> Option<&'a teaql_core::SmartList<crate::Product>> {
        match &self.result {
            teaql_core::eval::EvalResult::Value(v) => Some(*v),
            teaql_core::eval::EvalResult::Null => None,
            teaql_core::eval::EvalResult::NotLoaded { failed_node, attempted_path } => {
                crate::trigger_logic_bug_panic(&self.root_desc, &failed_node, &attempted_path)
            }
        }
    }

    pub fn eval(&self) -> Option<&'a teaql_core::SmartList<crate::Product>> {
        self.resolve()
    }

    pub fn unwrap(&self) -> &'a teaql_core::SmartList<crate::Product> {
        self.resolve().expect("List relation was legitimately null in database!")
    }

    pub fn size(&self) -> crate::ValueExpression<'a, usize> {
        let next = self.result.clone().and_then("size", |list| teaql_core::eval::EvalResult::Value(list.len()));
        crate::ValueExpression::new(next, self.root_desc.clone())
    }

    pub fn first(&self) -> crate::ProductExpression<'a> {
        let next = self.result.clone().and_then("first", |list| {
            if let Some(item) = list.first() {
                teaql_core::eval::EvalResult::Value(item)
            } else {
                teaql_core::eval::EvalResult::Null
            }
        });
        crate::ProductExpression::new(next, self.root_desc.clone())
    }

    pub fn get(&self, index: usize) -> crate::ProductExpression<'a> {
        let next = self.result.clone().and_then("get", |list| {
            if let Some(item) = list.get(index) {
                teaql_core::eval::EvalResult::Value(item)
            } else {
                teaql_core::eval::EvalResult::Null
            }
        });
        crate::ProductExpression::new(next, self.root_desc.clone())
    }
}