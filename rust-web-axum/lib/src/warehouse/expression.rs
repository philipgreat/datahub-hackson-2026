#[derive(Clone)]
pub struct WarehouseExpression<'a> {
    result: teaql_core::eval::EvalResult<&'a crate::Warehouse>,
    root_desc: std::sync::Arc<String>,
}

impl<'a> WarehouseExpression<'a> {
    pub fn new(result: teaql_core::eval::EvalResult<&'a crate::Warehouse>, root_desc: std::sync::Arc<String>) -> Self {
        Self { result, root_desc }
    }

    fn resolve(&self) -> Option<&'a crate::Warehouse> {
        match &self.result {
            teaql_core::eval::EvalResult::Value(v) => Some(*v),
            teaql_core::eval::EvalResult::Null => None,
            teaql_core::eval::EvalResult::NotLoaded { failed_node, attempted_path } => {
                crate::trigger_logic_bug_panic(&self.root_desc, &failed_node, &attempted_path)
            }
        }
    }

    pub fn eval(&self) -> Option<&'a crate::Warehouse> {
        self.resolve()
    }

    pub fn unwrap(&self) -> &'a crate::Warehouse {
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

    pub fn get_capacity(self) -> crate::ValueExpression<'a, rust_decimal::Decimal> {
        let next = self.result.and_then("capacity", |entity| entity.eval_capacity());
        crate::ValueExpression::new(next, self.root_desc.clone())
    }

    pub fn get_location(self) -> crate::ValueExpression<'a, String> {
        let next = self.result.and_then("location", |entity| entity.eval_location());
        crate::ValueExpression::new(next, self.root_desc.clone())
    }

    pub fn get_manager_id(self) -> crate::ValueExpression<'a, String> {
        let next = self.result.and_then("manager_id", |entity| entity.eval_manager_id());
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
    pub fn get_inventory_item_list(self) -> crate::InventoryItemListExpression<'a> {
        let next = self.result.and_then("inventory_item_list", |entity| entity.eval_inventory_item_list());
        crate::InventoryItemListExpression::new(next, self.root_desc.clone())
    }

    pub fn get_shipment_list(self) -> crate::ShipmentListExpression<'a> {
        let next = self.result.and_then("shipment_list", |entity| entity.eval_shipment_list());
        crate::ShipmentListExpression::new(next, self.root_desc.clone())
    }
}

#[derive(Clone)]
pub struct WarehouseListExpression<'a> {
    result: teaql_core::eval::EvalResult<&'a teaql_core::SmartList<crate::Warehouse>>,
    root_desc: std::sync::Arc<String>,
}

impl<'a> WarehouseListExpression<'a> {
    pub fn new(result: teaql_core::eval::EvalResult<&'a teaql_core::SmartList<crate::Warehouse>>, root_desc: std::sync::Arc<String>) -> Self {
        Self { result, root_desc }
    }

    fn resolve(&self) -> Option<&'a teaql_core::SmartList<crate::Warehouse>> {
        match &self.result {
            teaql_core::eval::EvalResult::Value(v) => Some(*v),
            teaql_core::eval::EvalResult::Null => None,
            teaql_core::eval::EvalResult::NotLoaded { failed_node, attempted_path } => {
                crate::trigger_logic_bug_panic(&self.root_desc, &failed_node, &attempted_path)
            }
        }
    }

    pub fn eval(&self) -> Option<&'a teaql_core::SmartList<crate::Warehouse>> {
        self.resolve()
    }

    pub fn unwrap(&self) -> &'a teaql_core::SmartList<crate::Warehouse> {
        self.resolve().expect("List relation was legitimately null in database!")
    }

    pub fn size(&self) -> crate::ValueExpression<'a, usize> {
        let next = self.result.clone().and_then("size", |list| teaql_core::eval::EvalResult::Value(list.len()));
        crate::ValueExpression::new(next, self.root_desc.clone())
    }

    pub fn first(&self) -> crate::WarehouseExpression<'a> {
        let next = self.result.clone().and_then("first", |list| {
            if let Some(item) = list.first() {
                teaql_core::eval::EvalResult::Value(item)
            } else {
                teaql_core::eval::EvalResult::Null
            }
        });
        crate::WarehouseExpression::new(next, self.root_desc.clone())
    }

    pub fn get(&self, index: usize) -> crate::WarehouseExpression<'a> {
        let next = self.result.clone().and_then("get", |list| {
            if let Some(item) = list.get(index) {
                teaql_core::eval::EvalResult::Value(item)
            } else {
                teaql_core::eval::EvalResult::Null
            }
        });
        crate::WarehouseExpression::new(next, self.root_desc.clone())
    }
}