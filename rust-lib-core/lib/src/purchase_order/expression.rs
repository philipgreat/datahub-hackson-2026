#[derive(Clone)]
pub struct PurchaseOrderExpression<'a> {
    result: teaql_core::eval::EvalResult<&'a crate::PurchaseOrder>,
    root_desc: std::sync::Arc<String>,
}

impl<'a> PurchaseOrderExpression<'a> {
    pub fn new(result: teaql_core::eval::EvalResult<&'a crate::PurchaseOrder>, root_desc: std::sync::Arc<String>) -> Self {
        Self { result, root_desc }
    }

    fn resolve(&self) -> Option<&'a crate::PurchaseOrder> {
        match &self.result {
            teaql_core::eval::EvalResult::Value(v) => Some(*v),
            teaql_core::eval::EvalResult::Null => None,
            teaql_core::eval::EvalResult::NotLoaded { failed_node, attempted_path } => {
                crate::trigger_logic_bug_panic(&self.root_desc, &failed_node, &attempted_path)
            }
        }
    }

    pub fn eval(&self) -> Option<&'a crate::PurchaseOrder> {
        self.resolve()
    }

    pub fn unwrap(&self) -> &'a crate::PurchaseOrder {
        self.resolve().expect("Relation was legitimately null in database!")
    }

    pub fn get_id(self) -> crate::ValueExpression<'a, u64> {
        let next = self.result.and_then("id", |entity| entity.eval_id());
        crate::ValueExpression::new(next, self.root_desc.clone())
    }

    pub fn get_order_date(self) -> crate::ValueExpression<'a, teaql_core::time::Timestamp> {
        let next = self.result.and_then("order_date", |entity| entity.eval_order_date());
        crate::ValueExpression::new(next, self.root_desc.clone())
    }

    pub fn get_status(self) -> crate::ValueExpression<'a, String> {
        let next = self.result.and_then("status", |entity| entity.eval_status());
        crate::ValueExpression::new(next, self.root_desc.clone())
    }

    pub fn get_total_cost(self) -> crate::ValueExpression<'a, rust_decimal::Decimal> {
        let next = self.result.and_then("total_cost", |entity| entity.eval_total_cost());
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
    pub fn get_supplier_id(self) -> crate::ValueExpression<'a, u64> {
        let next = self.result.and_then("supplier_id", |entity| entity.eval_supplier_id());
        crate::ValueExpression::new(next, self.root_desc.clone())
    }
    pub fn get_supplier(self) -> crate::SupplierExpression<'a> {
        let next = self.result.and_then("supplier", |entity| entity.eval_supplier());
        crate::SupplierExpression::new(next, self.root_desc.clone())
    }
    pub fn get_purchase_order_item_list(self) -> crate::PurchaseOrderItemListExpression<'a> {
        let next = self.result.and_then("purchase_order_item_list", |entity| entity.eval_purchase_order_item_list());
        crate::PurchaseOrderItemListExpression::new(next, self.root_desc.clone())
    }
}

#[derive(Clone)]
pub struct PurchaseOrderListExpression<'a> {
    result: teaql_core::eval::EvalResult<&'a teaql_core::SmartList<crate::PurchaseOrder>>,
    root_desc: std::sync::Arc<String>,
}

impl<'a> PurchaseOrderListExpression<'a> {
    pub fn new(result: teaql_core::eval::EvalResult<&'a teaql_core::SmartList<crate::PurchaseOrder>>, root_desc: std::sync::Arc<String>) -> Self {
        Self { result, root_desc }
    }

    fn resolve(&self) -> Option<&'a teaql_core::SmartList<crate::PurchaseOrder>> {
        match &self.result {
            teaql_core::eval::EvalResult::Value(v) => Some(*v),
            teaql_core::eval::EvalResult::Null => None,
            teaql_core::eval::EvalResult::NotLoaded { failed_node, attempted_path } => {
                crate::trigger_logic_bug_panic(&self.root_desc, &failed_node, &attempted_path)
            }
        }
    }

    pub fn eval(&self) -> Option<&'a teaql_core::SmartList<crate::PurchaseOrder>> {
        self.resolve()
    }

    pub fn unwrap(&self) -> &'a teaql_core::SmartList<crate::PurchaseOrder> {
        self.resolve().expect("List relation was legitimately null in database!")
    }

    pub fn size(&self) -> crate::ValueExpression<'a, usize> {
        let next = self.result.clone().and_then("size", |list| teaql_core::eval::EvalResult::Value(list.len()));
        crate::ValueExpression::new(next, self.root_desc.clone())
    }

    pub fn first(&self) -> crate::PurchaseOrderExpression<'a> {
        let next = self.result.clone().and_then("first", |list| {
            if let Some(item) = list.first() {
                teaql_core::eval::EvalResult::Value(item)
            } else {
                teaql_core::eval::EvalResult::Null
            }
        });
        crate::PurchaseOrderExpression::new(next, self.root_desc.clone())
    }

    pub fn get(&self, index: usize) -> crate::PurchaseOrderExpression<'a> {
        let next = self.result.clone().and_then("get", |list| {
            if let Some(item) = list.get(index) {
                teaql_core::eval::EvalResult::Value(item)
            } else {
                teaql_core::eval::EvalResult::Null
            }
        });
        crate::PurchaseOrderExpression::new(next, self.root_desc.clone())
    }
}