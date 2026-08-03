#[derive(Clone)]
pub struct MoveOrderExpression<'a> {
    result: teaql_core::eval::EvalResult<&'a crate::MoveOrder>,
    root_desc: std::sync::Arc<String>,
}

impl<'a> MoveOrderExpression<'a> {
    pub fn new(result: teaql_core::eval::EvalResult<&'a crate::MoveOrder>, root_desc: std::sync::Arc<String>) -> Self {
        Self { result, root_desc }
    }

    fn resolve(&self) -> Option<&'a crate::MoveOrder> {
        match &self.result {
            teaql_core::eval::EvalResult::Value(v) => Some(*v),
            teaql_core::eval::EvalResult::Null => None,
            teaql_core::eval::EvalResult::NotLoaded { failed_node, attempted_path } => {
                crate::trigger_logic_bug_panic(&self.root_desc, &failed_node, &attempted_path)
            }
        }
    }

    pub fn eval(&self) -> Option<&'a crate::MoveOrder> {
        self.resolve()
    }

    pub fn unwrap(&self) -> &'a crate::MoveOrder {
        self.resolve().expect("Relation was legitimately null in database!")
    }

    pub fn get_id(self) -> crate::ValueExpression<'a, u64> {
        let next = self.result.and_then("id", |entity| entity.eval_id());
        crate::ValueExpression::new(next, self.root_desc.clone())
    }

    pub fn get_origin_address(self) -> crate::ValueExpression<'a, String> {
        let next = self.result.and_then("origin_address", |entity| entity.eval_origin_address());
        crate::ValueExpression::new(next, self.root_desc.clone())
    }

    pub fn get_destination_address(self) -> crate::ValueExpression<'a, String> {
        let next = self.result.and_then("destination_address", |entity| entity.eval_destination_address());
        crate::ValueExpression::new(next, self.root_desc.clone())
    }

    pub fn get_scheduled_date(self) -> crate::ValueExpression<'a, chrono::NaiveDate> {
        let next = self.result.and_then("scheduled_date", |entity| entity.eval_scheduled_date());
        crate::ValueExpression::new(next, self.root_desc.clone())
    }

    pub fn get_estimated_hours(self) -> crate::ValueExpression<'a, i64> {
        let next = self.result.and_then("estimated_hours", |entity| entity.eval_estimated_hours());
        crate::ValueExpression::new(next, self.root_desc.clone())
    }

    pub fn get_special_instructions(self) -> crate::ValueExpression<'a, String> {
        let next = self.result.and_then("special_instructions", |entity| entity.eval_special_instructions());
        crate::ValueExpression::new(next, self.root_desc.clone())
    }

    pub fn get_create_time(self) -> crate::ValueExpression<'a, chrono::DateTime<chrono::Utc>> {
        let next = self.result.and_then("create_time", |entity| entity.eval_create_time());
        crate::ValueExpression::new(next, self.root_desc.clone())
    }

    pub fn get_update_time(self) -> crate::ValueExpression<'a, chrono::DateTime<chrono::Utc>> {
        let next = self.result.and_then("update_time", |entity| entity.eval_update_time());
        crate::ValueExpression::new(next, self.root_desc.clone())
    }

    pub fn get_version(self) -> crate::ValueExpression<'a, i64> {
        let next = self.result.and_then("version", |entity| entity.eval_version());
        crate::ValueExpression::new(next, self.root_desc.clone())
    }
    pub fn get_company_id(self) -> crate::ValueExpression<'a, u64> {
        let next = self.result.and_then("company_id", |entity| entity.eval_company_id());
        crate::ValueExpression::new(next, self.root_desc.clone())
    }

    pub fn get_customer_id(self) -> crate::ValueExpression<'a, u64> {
        let next = self.result.and_then("customer_id", |entity| entity.eval_customer_id());
        crate::ValueExpression::new(next, self.root_desc.clone())
    }

    pub fn get_driver_id(self) -> crate::ValueExpression<'a, u64> {
        let next = self.result.and_then("driver_id", |entity| entity.eval_driver_id());
        crate::ValueExpression::new(next, self.root_desc.clone())
    }

    pub fn get_vehicle_id(self) -> crate::ValueExpression<'a, u64> {
        let next = self.result.and_then("vehicle_id", |entity| entity.eval_vehicle_id());
        crate::ValueExpression::new(next, self.root_desc.clone())
    }

    pub fn get_status_id(self) -> crate::ValueExpression<'a, u64> {
        let next = self.result.and_then("status_id", |entity| entity.eval_status_id());
        crate::ValueExpression::new(next, self.root_desc.clone())
    }
    pub fn get_company(self) -> crate::CompanyExpression<'a> {
        let next = self.result.and_then("company", |entity| entity.eval_company());
        crate::CompanyExpression::new(next, self.root_desc.clone())
    }

    pub fn get_customer(self) -> crate::CustomerExpression<'a> {
        let next = self.result.and_then("customer", |entity| entity.eval_customer());
        crate::CustomerExpression::new(next, self.root_desc.clone())
    }

    pub fn get_driver(self) -> crate::DriverExpression<'a> {
        let next = self.result.and_then("driver", |entity| entity.eval_driver());
        crate::DriverExpression::new(next, self.root_desc.clone())
    }

    pub fn get_vehicle(self) -> crate::VehicleExpression<'a> {
        let next = self.result.and_then("vehicle", |entity| entity.eval_vehicle());
        crate::VehicleExpression::new(next, self.root_desc.clone())
    }

    pub fn get_status(self) -> crate::MoveOrderStatusExpression<'a> {
        let next = self.result.and_then("status", |entity| entity.eval_status());
        crate::MoveOrderStatusExpression::new(next, self.root_desc.clone())
    }
    pub fn status_is_pending(self) -> crate::ValueExpression<'a, bool> {
        let next = self.result.and_then("status_id", |entity| {
            if !entity.is_loaded("status_id") {
                teaql_core::eval::EvalResult::NotLoaded { failed_node: "status_id".to_string(), attempted_path: "status_id".to_string() }
            } else {
                teaql_core::eval::EvalResult::Value(entity.status_is_pending())
            }
        });
        crate::ValueExpression::new(next, self.root_desc.clone())
    }

    pub fn status_is_confirmed(self) -> crate::ValueExpression<'a, bool> {
        let next = self.result.and_then("status_id", |entity| {
            if !entity.is_loaded("status_id") {
                teaql_core::eval::EvalResult::NotLoaded { failed_node: "status_id".to_string(), attempted_path: "status_id".to_string() }
            } else {
                teaql_core::eval::EvalResult::Value(entity.status_is_confirmed())
            }
        });
        crate::ValueExpression::new(next, self.root_desc.clone())
    }

    pub fn status_is_assigned(self) -> crate::ValueExpression<'a, bool> {
        let next = self.result.and_then("status_id", |entity| {
            if !entity.is_loaded("status_id") {
                teaql_core::eval::EvalResult::NotLoaded { failed_node: "status_id".to_string(), attempted_path: "status_id".to_string() }
            } else {
                teaql_core::eval::EvalResult::Value(entity.status_is_assigned())
            }
        });
        crate::ValueExpression::new(next, self.root_desc.clone())
    }

    pub fn status_is_in_transit(self) -> crate::ValueExpression<'a, bool> {
        let next = self.result.and_then("status_id", |entity| {
            if !entity.is_loaded("status_id") {
                teaql_core::eval::EvalResult::NotLoaded { failed_node: "status_id".to_string(), attempted_path: "status_id".to_string() }
            } else {
                teaql_core::eval::EvalResult::Value(entity.status_is_in_transit())
            }
        });
        crate::ValueExpression::new(next, self.root_desc.clone())
    }

    pub fn status_is_delivered(self) -> crate::ValueExpression<'a, bool> {
        let next = self.result.and_then("status_id", |entity| {
            if !entity.is_loaded("status_id") {
                teaql_core::eval::EvalResult::NotLoaded { failed_node: "status_id".to_string(), attempted_path: "status_id".to_string() }
            } else {
                teaql_core::eval::EvalResult::Value(entity.status_is_delivered())
            }
        });
        crate::ValueExpression::new(next, self.root_desc.clone())
    }

    pub fn status_is_cancelled(self) -> crate::ValueExpression<'a, bool> {
        let next = self.result.and_then("status_id", |entity| {
            if !entity.is_loaded("status_id") {
                teaql_core::eval::EvalResult::NotLoaded { failed_node: "status_id".to_string(), attempted_path: "status_id".to_string() }
            } else {
                teaql_core::eval::EvalResult::Value(entity.status_is_cancelled())
            }
        });
        crate::ValueExpression::new(next, self.root_desc.clone())
    }
    pub fn get_invoice_list(self) -> crate::InvoiceListExpression<'a> {
        let next = self.result.and_then("invoice_list", |entity| entity.eval_invoice_list());
        crate::InvoiceListExpression::new(next, self.root_desc.clone())
    }

    pub fn get_review_list(self) -> crate::ReviewListExpression<'a> {
        let next = self.result.and_then("review_list", |entity| entity.eval_review_list());
        crate::ReviewListExpression::new(next, self.root_desc.clone())
    }
}

#[derive(Clone)]
pub struct MoveOrderListExpression<'a> {
    result: teaql_core::eval::EvalResult<&'a teaql_core::SmartList<crate::MoveOrder>>,
    root_desc: std::sync::Arc<String>,
}

impl<'a> MoveOrderListExpression<'a> {
    pub fn new(result: teaql_core::eval::EvalResult<&'a teaql_core::SmartList<crate::MoveOrder>>, root_desc: std::sync::Arc<String>) -> Self {
        Self { result, root_desc }
    }

    fn resolve(&self) -> Option<&'a teaql_core::SmartList<crate::MoveOrder>> {
        match &self.result {
            teaql_core::eval::EvalResult::Value(v) => Some(*v),
            teaql_core::eval::EvalResult::Null => None,
            teaql_core::eval::EvalResult::NotLoaded { failed_node, attempted_path } => {
                crate::trigger_logic_bug_panic(&self.root_desc, &failed_node, &attempted_path)
            }
        }
    }

    pub fn eval(&self) -> Option<&'a teaql_core::SmartList<crate::MoveOrder>> {
        self.resolve()
    }

    pub fn unwrap(&self) -> &'a teaql_core::SmartList<crate::MoveOrder> {
        self.resolve().expect("List relation was legitimately null in database!")
    }

    pub fn size(&self) -> crate::ValueExpression<'a, usize> {
        let next = self.result.clone().and_then("size", |list| teaql_core::eval::EvalResult::Value(list.len()));
        crate::ValueExpression::new(next, self.root_desc.clone())
    }

    pub fn first(&self) -> crate::MoveOrderExpression<'a> {
        let next = self.result.clone().and_then("first", |list| {
            if let Some(item) = list.first() {
                teaql_core::eval::EvalResult::Value(item)
            } else {
                teaql_core::eval::EvalResult::Null
            }
        });
        crate::MoveOrderExpression::new(next, self.root_desc.clone())
    }

    pub fn get(&self, index: usize) -> crate::MoveOrderExpression<'a> {
        let next = self.result.clone().and_then("get", |list| {
            if let Some(item) = list.get(index) {
                teaql_core::eval::EvalResult::Value(item)
            } else {
                teaql_core::eval::EvalResult::Null
            }
        });
        crate::MoveOrderExpression::new(next, self.root_desc.clone())
    }
}