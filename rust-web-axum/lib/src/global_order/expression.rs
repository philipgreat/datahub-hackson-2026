#[derive(Clone)]
pub struct GlobalOrderExpression<'a> {
    result: teaql_core::eval::EvalResult<&'a crate::GlobalOrder>,
    root_desc: std::sync::Arc<String>,
}

impl<'a> GlobalOrderExpression<'a> {
    pub fn new(result: teaql_core::eval::EvalResult<&'a crate::GlobalOrder>, root_desc: std::sync::Arc<String>) -> Self {
        Self { result, root_desc }
    }

    fn resolve(&self) -> Option<&'a crate::GlobalOrder> {
        match &self.result {
            teaql_core::eval::EvalResult::Value(v) => Some(*v),
            teaql_core::eval::EvalResult::Null => None,
            teaql_core::eval::EvalResult::NotLoaded { failed_node, attempted_path } => {
                crate::trigger_logic_bug_panic(&self.root_desc, &failed_node, &attempted_path)
            }
        }
    }

    pub fn eval(&self) -> Option<&'a crate::GlobalOrder> {
        self.resolve()
    }

    pub fn unwrap(&self) -> &'a crate::GlobalOrder {
        self.resolve().expect("Relation was legitimately null in database!")
    }

    pub fn get_id(self) -> crate::ValueExpression<'a, u64> {
        let next = self.result.and_then("id", |entity| entity.eval_id());
        crate::ValueExpression::new(next, self.root_desc.clone())
    }

    pub fn get_shipping_address(self) -> crate::ValueExpression<'a, String> {
        let next = self.result.and_then("shipping_address", |entity| entity.eval_shipping_address());
        crate::ValueExpression::new(next, self.root_desc.clone())
    }

    pub fn get_total_amount(self) -> crate::ValueExpression<'a, rust_decimal::Decimal> {
        let next = self.result.and_then("total_amount", |entity| entity.eval_total_amount());
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
    pub fn get_customer(self) -> crate::CustomerExpression<'a> {
        let next = self.result.and_then("customer", |entity| entity.eval_customer());
        crate::CustomerExpression::new(next, self.root_desc.clone())
    }
    pub fn get_order_item_list(self) -> crate::OrderItemListExpression<'a> {
        let next = self.result.and_then("order_item_list", |entity| entity.eval_order_item_list());
        crate::OrderItemListExpression::new(next, self.root_desc.clone())
    }

    pub fn get_invoice_list(self) -> crate::InvoiceListExpression<'a> {
        let next = self.result.and_then("invoice_list", |entity| entity.eval_invoice_list());
        crate::InvoiceListExpression::new(next, self.root_desc.clone())
    }

    pub fn get_shipment_list(self) -> crate::ShipmentListExpression<'a> {
        let next = self.result.and_then("shipment_list", |entity| entity.eval_shipment_list());
        crate::ShipmentListExpression::new(next, self.root_desc.clone())
    }

    pub fn get_return_request_list(self) -> crate::ReturnRequestListExpression<'a> {
        let next = self.result.and_then("return_request_list", |entity| entity.eval_return_request_list());
        crate::ReturnRequestListExpression::new(next, self.root_desc.clone())
    }
}

#[derive(Clone)]
pub struct GlobalOrderListExpression<'a> {
    result: teaql_core::eval::EvalResult<&'a teaql_core::SmartList<crate::GlobalOrder>>,
    root_desc: std::sync::Arc<String>,
}

impl<'a> GlobalOrderListExpression<'a> {
    pub fn new(result: teaql_core::eval::EvalResult<&'a teaql_core::SmartList<crate::GlobalOrder>>, root_desc: std::sync::Arc<String>) -> Self {
        Self { result, root_desc }
    }

    fn resolve(&self) -> Option<&'a teaql_core::SmartList<crate::GlobalOrder>> {
        match &self.result {
            teaql_core::eval::EvalResult::Value(v) => Some(*v),
            teaql_core::eval::EvalResult::Null => None,
            teaql_core::eval::EvalResult::NotLoaded { failed_node, attempted_path } => {
                crate::trigger_logic_bug_panic(&self.root_desc, &failed_node, &attempted_path)
            }
        }
    }

    pub fn eval(&self) -> Option<&'a teaql_core::SmartList<crate::GlobalOrder>> {
        self.resolve()
    }

    pub fn unwrap(&self) -> &'a teaql_core::SmartList<crate::GlobalOrder> {
        self.resolve().expect("List relation was legitimately null in database!")
    }

    pub fn size(&self) -> crate::ValueExpression<'a, usize> {
        let next = self.result.clone().and_then("size", |list| teaql_core::eval::EvalResult::Value(list.len()));
        crate::ValueExpression::new(next, self.root_desc.clone())
    }

    pub fn first(&self) -> crate::GlobalOrderExpression<'a> {
        let next = self.result.clone().and_then("first", |list| {
            if let Some(item) = list.first() {
                teaql_core::eval::EvalResult::Value(item)
            } else {
                teaql_core::eval::EvalResult::Null
            }
        });
        crate::GlobalOrderExpression::new(next, self.root_desc.clone())
    }

    pub fn get(&self, index: usize) -> crate::GlobalOrderExpression<'a> {
        let next = self.result.clone().and_then("get", |list| {
            if let Some(item) = list.get(index) {
                teaql_core::eval::EvalResult::Value(item)
            } else {
                teaql_core::eval::EvalResult::Null
            }
        });
        crate::GlobalOrderExpression::new(next, self.root_desc.clone())
    }
}