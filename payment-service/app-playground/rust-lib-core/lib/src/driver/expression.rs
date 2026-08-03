#[derive(Clone)]
pub struct DriverExpression<'a> {
    result: teaql_core::eval::EvalResult<&'a crate::Driver>,
    root_desc: std::sync::Arc<String>,
}

impl<'a> DriverExpression<'a> {
    pub fn new(result: teaql_core::eval::EvalResult<&'a crate::Driver>, root_desc: std::sync::Arc<String>) -> Self {
        Self { result, root_desc }
    }

    fn resolve(&self) -> Option<&'a crate::Driver> {
        match &self.result {
            teaql_core::eval::EvalResult::Value(v) => Some(*v),
            teaql_core::eval::EvalResult::Null => None,
            teaql_core::eval::EvalResult::NotLoaded { failed_node, attempted_path } => {
                crate::trigger_logic_bug_panic(&self.root_desc, &failed_node, &attempted_path)
            }
        }
    }

    pub fn eval(&self) -> Option<&'a crate::Driver> {
        self.resolve()
    }

    pub fn unwrap(&self) -> &'a crate::Driver {
        self.resolve().expect("Relation was legitimately null in database!")
    }

    pub fn get_id(self) -> crate::ValueExpression<'a, u64> {
        let next = self.result.and_then("id", |entity| entity.eval_id());
        crate::ValueExpression::new(next, self.root_desc.clone())
    }

    pub fn get_full_name(self) -> crate::ValueExpression<'a, String> {
        let next = self.result.and_then("full_name", |entity| entity.eval_full_name());
        crate::ValueExpression::new(next, self.root_desc.clone())
    }

    pub fn get_email(self) -> crate::ValueExpression<'a, String> {
        let next = self.result.and_then("email", |entity| entity.eval_email());
        crate::ValueExpression::new(next, self.root_desc.clone())
    }

    pub fn get_phone(self) -> crate::ValueExpression<'a, String> {
        let next = self.result.and_then("phone", |entity| entity.eval_phone());
        crate::ValueExpression::new(next, self.root_desc.clone())
    }

    pub fn get_license_number(self) -> crate::ValueExpression<'a, String> {
        let next = self.result.and_then("license_number", |entity| entity.eval_license_number());
        crate::ValueExpression::new(next, self.root_desc.clone())
    }

    pub fn get_password_hash(self) -> crate::ValueExpression<'a, String> {
        let next = self.result.and_then("password_hash", |entity| entity.eval_password_hash());
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
    pub fn get_company(self) -> crate::CompanyExpression<'a> {
        let next = self.result.and_then("company", |entity| entity.eval_company());
        crate::CompanyExpression::new(next, self.root_desc.clone())
    }
    pub fn get_move_order_list(self) -> crate::MoveOrderListExpression<'a> {
        let next = self.result.and_then("move_order_list", |entity| entity.eval_move_order_list());
        crate::MoveOrderListExpression::new(next, self.root_desc.clone())
    }
}

#[derive(Clone)]
pub struct DriverListExpression<'a> {
    result: teaql_core::eval::EvalResult<&'a teaql_core::SmartList<crate::Driver>>,
    root_desc: std::sync::Arc<String>,
}

impl<'a> DriverListExpression<'a> {
    pub fn new(result: teaql_core::eval::EvalResult<&'a teaql_core::SmartList<crate::Driver>>, root_desc: std::sync::Arc<String>) -> Self {
        Self { result, root_desc }
    }

    fn resolve(&self) -> Option<&'a teaql_core::SmartList<crate::Driver>> {
        match &self.result {
            teaql_core::eval::EvalResult::Value(v) => Some(*v),
            teaql_core::eval::EvalResult::Null => None,
            teaql_core::eval::EvalResult::NotLoaded { failed_node, attempted_path } => {
                crate::trigger_logic_bug_panic(&self.root_desc, &failed_node, &attempted_path)
            }
        }
    }

    pub fn eval(&self) -> Option<&'a teaql_core::SmartList<crate::Driver>> {
        self.resolve()
    }

    pub fn unwrap(&self) -> &'a teaql_core::SmartList<crate::Driver> {
        self.resolve().expect("List relation was legitimately null in database!")
    }

    pub fn size(&self) -> crate::ValueExpression<'a, usize> {
        let next = self.result.clone().and_then("size", |list| teaql_core::eval::EvalResult::Value(list.len()));
        crate::ValueExpression::new(next, self.root_desc.clone())
    }

    pub fn first(&self) -> crate::DriverExpression<'a> {
        let next = self.result.clone().and_then("first", |list| {
            if let Some(item) = list.first() {
                teaql_core::eval::EvalResult::Value(item)
            } else {
                teaql_core::eval::EvalResult::Null
            }
        });
        crate::DriverExpression::new(next, self.root_desc.clone())
    }

    pub fn get(&self, index: usize) -> crate::DriverExpression<'a> {
        let next = self.result.clone().and_then("get", |list| {
            if let Some(item) = list.get(index) {
                teaql_core::eval::EvalResult::Value(item)
            } else {
                teaql_core::eval::EvalResult::Null
            }
        });
        crate::DriverExpression::new(next, self.root_desc.clone())
    }
}