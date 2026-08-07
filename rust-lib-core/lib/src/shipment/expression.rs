#[derive(Clone)]
pub struct ShipmentExpression<'a> {
    result: teaql_core::eval::EvalResult<&'a crate::Shipment>,
    root_desc: std::sync::Arc<String>,
}

impl<'a> ShipmentExpression<'a> {
    pub fn new(result: teaql_core::eval::EvalResult<&'a crate::Shipment>, root_desc: std::sync::Arc<String>) -> Self {
        Self { result, root_desc }
    }

    fn resolve(&self) -> Option<&'a crate::Shipment> {
        match &self.result {
            teaql_core::eval::EvalResult::Value(v) => Some(*v),
            teaql_core::eval::EvalResult::Null => None,
            teaql_core::eval::EvalResult::NotLoaded { failed_node, attempted_path } => {
                crate::trigger_logic_bug_panic(&self.root_desc, &failed_node, &attempted_path)
            }
        }
    }

    pub fn eval(&self) -> Option<&'a crate::Shipment> {
        self.resolve()
    }

    pub fn unwrap(&self) -> &'a crate::Shipment {
        self.resolve().expect("Relation was legitimately null in database!")
    }

    pub fn get_id(self) -> crate::ValueExpression<'a, u64> {
        let next = self.result.and_then("id", |entity| entity.eval_id());
        crate::ValueExpression::new(next, self.root_desc.clone())
    }

    pub fn get_shipped_date(self) -> crate::ValueExpression<'a, teaql_core::time::Timestamp> {
        let next = self.result.and_then("shipped_date", |entity| entity.eval_shipped_date());
        crate::ValueExpression::new(next, self.root_desc.clone())
    }

    pub fn get_carrier(self) -> crate::ValueExpression<'a, String> {
        let next = self.result.and_then("carrier", |entity| entity.eval_carrier());
        crate::ValueExpression::new(next, self.root_desc.clone())
    }

    pub fn get_status(self) -> crate::ValueExpression<'a, String> {
        let next = self.result.and_then("status", |entity| entity.eval_status());
        crate::ValueExpression::new(next, self.root_desc.clone())
    }

    pub fn get_tracking_number(self) -> crate::ValueExpression<'a, String> {
        let next = self.result.and_then("tracking_number", |entity| entity.eval_tracking_number());
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
    pub fn get_global_order_id(self) -> crate::ValueExpression<'a, u64> {
        let next = self.result.and_then("global_order_id", |entity| entity.eval_global_order_id());
        crate::ValueExpression::new(next, self.root_desc.clone())
    }

    pub fn get_warehouse_id(self) -> crate::ValueExpression<'a, u64> {
        let next = self.result.and_then("warehouse_id", |entity| entity.eval_warehouse_id());
        crate::ValueExpression::new(next, self.root_desc.clone())
    }
    pub fn get_global_order(self) -> crate::GlobalOrderExpression<'a> {
        let next = self.result.and_then("global_order", |entity| entity.eval_global_order());
        crate::GlobalOrderExpression::new(next, self.root_desc.clone())
    }

    pub fn get_warehouse(self) -> crate::WarehouseExpression<'a> {
        let next = self.result.and_then("warehouse", |entity| entity.eval_warehouse());
        crate::WarehouseExpression::new(next, self.root_desc.clone())
    }
    pub fn get_delivery_list(self) -> crate::DeliveryListExpression<'a> {
        let next = self.result.and_then("delivery_list", |entity| entity.eval_delivery_list());
        crate::DeliveryListExpression::new(next, self.root_desc.clone())
    }
}

#[derive(Clone)]
pub struct ShipmentListExpression<'a> {
    result: teaql_core::eval::EvalResult<&'a teaql_core::SmartList<crate::Shipment>>,
    root_desc: std::sync::Arc<String>,
}

impl<'a> ShipmentListExpression<'a> {
    pub fn new(result: teaql_core::eval::EvalResult<&'a teaql_core::SmartList<crate::Shipment>>, root_desc: std::sync::Arc<String>) -> Self {
        Self { result, root_desc }
    }

    fn resolve(&self) -> Option<&'a teaql_core::SmartList<crate::Shipment>> {
        match &self.result {
            teaql_core::eval::EvalResult::Value(v) => Some(*v),
            teaql_core::eval::EvalResult::Null => None,
            teaql_core::eval::EvalResult::NotLoaded { failed_node, attempted_path } => {
                crate::trigger_logic_bug_panic(&self.root_desc, &failed_node, &attempted_path)
            }
        }
    }

    pub fn eval(&self) -> Option<&'a teaql_core::SmartList<crate::Shipment>> {
        self.resolve()
    }

    pub fn unwrap(&self) -> &'a teaql_core::SmartList<crate::Shipment> {
        self.resolve().expect("List relation was legitimately null in database!")
    }

    pub fn size(&self) -> crate::ValueExpression<'a, usize> {
        let next = self.result.clone().and_then("size", |list| teaql_core::eval::EvalResult::Value(list.len()));
        crate::ValueExpression::new(next, self.root_desc.clone())
    }

    pub fn first(&self) -> crate::ShipmentExpression<'a> {
        let next = self.result.clone().and_then("first", |list| {
            if let Some(item) = list.first() {
                teaql_core::eval::EvalResult::Value(item)
            } else {
                teaql_core::eval::EvalResult::Null
            }
        });
        crate::ShipmentExpression::new(next, self.root_desc.clone())
    }

    pub fn get(&self, index: usize) -> crate::ShipmentExpression<'a> {
        let next = self.result.clone().and_then("get", |list| {
            if let Some(item) = list.get(index) {
                teaql_core::eval::EvalResult::Value(item)
            } else {
                teaql_core::eval::EvalResult::Null
            }
        });
        crate::ShipmentExpression::new(next, self.root_desc.clone())
    }
}