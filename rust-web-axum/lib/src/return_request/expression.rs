#[derive(Clone)]
pub struct ReturnRequestExpression<'a> {
    result: teaql_core::eval::EvalResult<&'a crate::ReturnRequest>,
    root_desc: std::sync::Arc<String>,
}

impl<'a> ReturnRequestExpression<'a> {
    pub fn new(result: teaql_core::eval::EvalResult<&'a crate::ReturnRequest>, root_desc: std::sync::Arc<String>) -> Self {
        Self { result, root_desc }
    }

    fn resolve(&self) -> Option<&'a crate::ReturnRequest> {
        match &self.result {
            teaql_core::eval::EvalResult::Value(v) => Some(*v),
            teaql_core::eval::EvalResult::Null => None,
            teaql_core::eval::EvalResult::NotLoaded { failed_node, attempted_path } => {
                crate::trigger_logic_bug_panic(&self.root_desc, &failed_node, &attempted_path)
            }
        }
    }

    pub fn eval(&self) -> Option<&'a crate::ReturnRequest> {
        self.resolve()
    }

    pub fn unwrap(&self) -> &'a crate::ReturnRequest {
        self.resolve().expect("Relation was legitimately null in database!")
    }

    pub fn get_id(self) -> crate::ValueExpression<'a, u64> {
        let next = self.result.and_then("id", |entity| entity.eval_id());
        crate::ValueExpression::new(next, self.root_desc.clone())
    }

    pub fn get_refund_amount(self) -> crate::ValueExpression<'a, rust_decimal::Decimal> {
        let next = self.result.and_then("refund_amount", |entity| entity.eval_refund_amount());
        crate::ValueExpression::new(next, self.root_desc.clone())
    }

    pub fn get_reason(self) -> crate::ValueExpression<'a, String> {
        let next = self.result.and_then("reason", |entity| entity.eval_reason());
        crate::ValueExpression::new(next, self.root_desc.clone())
    }

    pub fn get_status(self) -> crate::ValueExpression<'a, String> {
        let next = self.result.and_then("status", |entity| entity.eval_status());
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
    pub fn get_customer_id(self) -> crate::ValueExpression<'a, u64> {
        let next = self.result.and_then("customer_id", |entity| entity.eval_customer_id());
        crate::ValueExpression::new(next, self.root_desc.clone())
    }

    pub fn get_global_order_id(self) -> crate::ValueExpression<'a, u64> {
        let next = self.result.and_then("global_order_id", |entity| entity.eval_global_order_id());
        crate::ValueExpression::new(next, self.root_desc.clone())
    }
    pub fn get_customer(self) -> crate::CustomerExpression<'a> {
        let next = self.result.and_then("customer", |entity| entity.eval_customer());
        crate::CustomerExpression::new(next, self.root_desc.clone())
    }

    pub fn get_global_order(self) -> crate::GlobalOrderExpression<'a> {
        let next = self.result.and_then("global_order", |entity| entity.eval_global_order());
        crate::GlobalOrderExpression::new(next, self.root_desc.clone())
    }
}

#[derive(Clone)]
pub struct ReturnRequestListExpression<'a> {
    result: teaql_core::eval::EvalResult<&'a teaql_core::SmartList<crate::ReturnRequest>>,
    root_desc: std::sync::Arc<String>,
}

impl<'a> ReturnRequestListExpression<'a> {
    pub fn new(result: teaql_core::eval::EvalResult<&'a teaql_core::SmartList<crate::ReturnRequest>>, root_desc: std::sync::Arc<String>) -> Self {
        Self { result, root_desc }
    }

    fn resolve(&self) -> Option<&'a teaql_core::SmartList<crate::ReturnRequest>> {
        match &self.result {
            teaql_core::eval::EvalResult::Value(v) => Some(*v),
            teaql_core::eval::EvalResult::Null => None,
            teaql_core::eval::EvalResult::NotLoaded { failed_node, attempted_path } => {
                crate::trigger_logic_bug_panic(&self.root_desc, &failed_node, &attempted_path)
            }
        }
    }

    pub fn eval(&self) -> Option<&'a teaql_core::SmartList<crate::ReturnRequest>> {
        self.resolve()
    }

    pub fn unwrap(&self) -> &'a teaql_core::SmartList<crate::ReturnRequest> {
        self.resolve().expect("List relation was legitimately null in database!")
    }

    pub fn size(&self) -> crate::ValueExpression<'a, usize> {
        let next = self.result.clone().and_then("size", |list| teaql_core::eval::EvalResult::Value(list.len()));
        crate::ValueExpression::new(next, self.root_desc.clone())
    }

    pub fn first(&self) -> crate::ReturnRequestExpression<'a> {
        let next = self.result.clone().and_then("first", |list| {
            if let Some(item) = list.first() {
                teaql_core::eval::EvalResult::Value(item)
            } else {
                teaql_core::eval::EvalResult::Null
            }
        });
        crate::ReturnRequestExpression::new(next, self.root_desc.clone())
    }

    pub fn get(&self, index: usize) -> crate::ReturnRequestExpression<'a> {
        let next = self.result.clone().and_then("get", |list| {
            if let Some(item) = list.get(index) {
                teaql_core::eval::EvalResult::Value(item)
            } else {
                teaql_core::eval::EvalResult::Null
            }
        });
        crate::ReturnRequestExpression::new(next, self.root_desc.clone())
    }
}