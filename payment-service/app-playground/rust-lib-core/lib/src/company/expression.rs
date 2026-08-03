#[derive(Clone)]
pub struct CompanyExpression<'a> {
    result: teaql_core::eval::EvalResult<&'a crate::Company>,
    root_desc: std::sync::Arc<String>,
}

impl<'a> CompanyExpression<'a> {
    pub fn new(result: teaql_core::eval::EvalResult<&'a crate::Company>, root_desc: std::sync::Arc<String>) -> Self {
        Self { result, root_desc }
    }

    fn resolve(&self) -> Option<&'a crate::Company> {
        match &self.result {
            teaql_core::eval::EvalResult::Value(v) => Some(*v),
            teaql_core::eval::EvalResult::Null => None,
            teaql_core::eval::EvalResult::NotLoaded { failed_node, attempted_path } => {
                crate::trigger_logic_bug_panic(&self.root_desc, &failed_node, &attempted_path)
            }
        }
    }

    pub fn eval(&self) -> Option<&'a crate::Company> {
        self.resolve()
    }

    pub fn unwrap(&self) -> &'a crate::Company {
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

    pub fn get_address(self) -> crate::ValueExpression<'a, String> {
        let next = self.result.and_then("address", |entity| entity.eval_address());
        crate::ValueExpression::new(next, self.root_desc.clone())
    }

    pub fn get_phone(self) -> crate::ValueExpression<'a, String> {
        let next = self.result.and_then("phone", |entity| entity.eval_phone());
        crate::ValueExpression::new(next, self.root_desc.clone())
    }

    pub fn get_email(self) -> crate::ValueExpression<'a, String> {
        let next = self.result.and_then("email", |entity| entity.eval_email());
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
    pub fn get_customer_list(self) -> crate::CustomerListExpression<'a> {
        let next = self.result.and_then("customer_list", |entity| entity.eval_customer_list());
        crate::CustomerListExpression::new(next, self.root_desc.clone())
    }

    pub fn get_driver_list(self) -> crate::DriverListExpression<'a> {
        let next = self.result.and_then("driver_list", |entity| entity.eval_driver_list());
        crate::DriverListExpression::new(next, self.root_desc.clone())
    }

    pub fn get_vehicle_list(self) -> crate::VehicleListExpression<'a> {
        let next = self.result.and_then("vehicle_list", |entity| entity.eval_vehicle_list());
        crate::VehicleListExpression::new(next, self.root_desc.clone())
    }

    pub fn get_move_order_status_list(self) -> crate::MoveOrderStatusListExpression<'a> {
        let next = self.result.and_then("move_order_status_list", |entity| entity.eval_move_order_status_list());
        crate::MoveOrderStatusListExpression::new(next, self.root_desc.clone())
    }

    pub fn get_move_order_list(self) -> crate::MoveOrderListExpression<'a> {
        let next = self.result.and_then("move_order_list", |entity| entity.eval_move_order_list());
        crate::MoveOrderListExpression::new(next, self.root_desc.clone())
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
pub struct CompanyListExpression<'a> {
    result: teaql_core::eval::EvalResult<&'a teaql_core::SmartList<crate::Company>>,
    root_desc: std::sync::Arc<String>,
}

impl<'a> CompanyListExpression<'a> {
    pub fn new(result: teaql_core::eval::EvalResult<&'a teaql_core::SmartList<crate::Company>>, root_desc: std::sync::Arc<String>) -> Self {
        Self { result, root_desc }
    }

    fn resolve(&self) -> Option<&'a teaql_core::SmartList<crate::Company>> {
        match &self.result {
            teaql_core::eval::EvalResult::Value(v) => Some(*v),
            teaql_core::eval::EvalResult::Null => None,
            teaql_core::eval::EvalResult::NotLoaded { failed_node, attempted_path } => {
                crate::trigger_logic_bug_panic(&self.root_desc, &failed_node, &attempted_path)
            }
        }
    }

    pub fn eval(&self) -> Option<&'a teaql_core::SmartList<crate::Company>> {
        self.resolve()
    }

    pub fn unwrap(&self) -> &'a teaql_core::SmartList<crate::Company> {
        self.resolve().expect("List relation was legitimately null in database!")
    }

    pub fn size(&self) -> crate::ValueExpression<'a, usize> {
        let next = self.result.clone().and_then("size", |list| teaql_core::eval::EvalResult::Value(list.len()));
        crate::ValueExpression::new(next, self.root_desc.clone())
    }

    pub fn first(&self) -> crate::CompanyExpression<'a> {
        let next = self.result.clone().and_then("first", |list| {
            if let Some(item) = list.first() {
                teaql_core::eval::EvalResult::Value(item)
            } else {
                teaql_core::eval::EvalResult::Null
            }
        });
        crate::CompanyExpression::new(next, self.root_desc.clone())
    }

    pub fn get(&self, index: usize) -> crate::CompanyExpression<'a> {
        let next = self.result.clone().and_then("get", |list| {
            if let Some(item) = list.get(index) {
                teaql_core::eval::EvalResult::Value(item)
            } else {
                teaql_core::eval::EvalResult::Null
            }
        });
        crate::CompanyExpression::new(next, self.root_desc.clone())
    }
}