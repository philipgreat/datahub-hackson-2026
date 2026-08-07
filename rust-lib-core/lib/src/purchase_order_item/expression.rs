#[derive(Clone)]
pub struct PurchaseOrderItemExpression<'a> {
    result: teaql_core::eval::EvalResult<&'a crate::PurchaseOrderItem>,
    root_desc: std::sync::Arc<String>,
}

impl<'a> PurchaseOrderItemExpression<'a> {
    pub fn new(result: teaql_core::eval::EvalResult<&'a crate::PurchaseOrderItem>, root_desc: std::sync::Arc<String>) -> Self {
        Self { result, root_desc }
    }

    fn resolve(&self) -> Option<&'a crate::PurchaseOrderItem> {
        match &self.result {
            teaql_core::eval::EvalResult::Value(v) => Some(*v),
            teaql_core::eval::EvalResult::Null => None,
            teaql_core::eval::EvalResult::NotLoaded { failed_node, attempted_path } => {
                crate::trigger_logic_bug_panic(&self.root_desc, &failed_node, &attempted_path)
            }
        }
    }

    pub fn eval(&self) -> Option<&'a crate::PurchaseOrderItem> {
        self.resolve()
    }

    pub fn unwrap(&self) -> &'a crate::PurchaseOrderItem {
        self.resolve().expect("Relation was legitimately null in database!")
    }

    pub fn get_id(self) -> crate::ValueExpression<'a, u64> {
        let next = self.result.and_then("id", |entity| entity.eval_id());
        crate::ValueExpression::new(next, self.root_desc.clone())
    }

    pub fn get_quantity(self) -> crate::ValueExpression<'a, rust_decimal::Decimal> {
        let next = self.result.and_then("quantity", |entity| entity.eval_quantity());
        crate::ValueExpression::new(next, self.root_desc.clone())
    }

    pub fn get_unit_cost(self) -> crate::ValueExpression<'a, rust_decimal::Decimal> {
        let next = self.result.and_then("unit_cost", |entity| entity.eval_unit_cost());
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
    pub fn get_product_id(self) -> crate::ValueExpression<'a, u64> {
        let next = self.result.and_then("product_id", |entity| entity.eval_product_id());
        crate::ValueExpression::new(next, self.root_desc.clone())
    }

    pub fn get_purchase_order_id(self) -> crate::ValueExpression<'a, u64> {
        let next = self.result.and_then("purchase_order_id", |entity| entity.eval_purchase_order_id());
        crate::ValueExpression::new(next, self.root_desc.clone())
    }
    pub fn get_product(self) -> crate::ProductExpression<'a> {
        let next = self.result.and_then("product", |entity| entity.eval_product());
        crate::ProductExpression::new(next, self.root_desc.clone())
    }

    pub fn get_purchase_order(self) -> crate::PurchaseOrderExpression<'a> {
        let next = self.result.and_then("purchase_order", |entity| entity.eval_purchase_order());
        crate::PurchaseOrderExpression::new(next, self.root_desc.clone())
    }
}

#[derive(Clone)]
pub struct PurchaseOrderItemListExpression<'a> {
    result: teaql_core::eval::EvalResult<&'a teaql_core::SmartList<crate::PurchaseOrderItem>>,
    root_desc: std::sync::Arc<String>,
}

impl<'a> PurchaseOrderItemListExpression<'a> {
    pub fn new(result: teaql_core::eval::EvalResult<&'a teaql_core::SmartList<crate::PurchaseOrderItem>>, root_desc: std::sync::Arc<String>) -> Self {
        Self { result, root_desc }
    }

    fn resolve(&self) -> Option<&'a teaql_core::SmartList<crate::PurchaseOrderItem>> {
        match &self.result {
            teaql_core::eval::EvalResult::Value(v) => Some(*v),
            teaql_core::eval::EvalResult::Null => None,
            teaql_core::eval::EvalResult::NotLoaded { failed_node, attempted_path } => {
                crate::trigger_logic_bug_panic(&self.root_desc, &failed_node, &attempted_path)
            }
        }
    }

    pub fn eval(&self) -> Option<&'a teaql_core::SmartList<crate::PurchaseOrderItem>> {
        self.resolve()
    }

    pub fn unwrap(&self) -> &'a teaql_core::SmartList<crate::PurchaseOrderItem> {
        self.resolve().expect("List relation was legitimately null in database!")
    }

    pub fn size(&self) -> crate::ValueExpression<'a, usize> {
        let next = self.result.clone().and_then("size", |list| teaql_core::eval::EvalResult::Value(list.len()));
        crate::ValueExpression::new(next, self.root_desc.clone())
    }

    pub fn first(&self) -> crate::PurchaseOrderItemExpression<'a> {
        let next = self.result.clone().and_then("first", |list| {
            if let Some(item) = list.first() {
                teaql_core::eval::EvalResult::Value(item)
            } else {
                teaql_core::eval::EvalResult::Null
            }
        });
        crate::PurchaseOrderItemExpression::new(next, self.root_desc.clone())
    }

    pub fn get(&self, index: usize) -> crate::PurchaseOrderItemExpression<'a> {
        let next = self.result.clone().and_then("get", |list| {
            if let Some(item) = list.get(index) {
                teaql_core::eval::EvalResult::Value(item)
            } else {
                teaql_core::eval::EvalResult::Null
            }
        });
        crate::PurchaseOrderItemExpression::new(next, self.root_desc.clone())
    }
}