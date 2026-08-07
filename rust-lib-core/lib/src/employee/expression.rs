#[derive(Clone)]
pub struct EmployeeExpression<'a> {
    result: teaql_core::eval::EvalResult<&'a crate::Employee>,
    root_desc: std::sync::Arc<String>,
}

impl<'a> EmployeeExpression<'a> {
    pub fn new(result: teaql_core::eval::EvalResult<&'a crate::Employee>, root_desc: std::sync::Arc<String>) -> Self {
        Self { result, root_desc }
    }

    fn resolve(&self) -> Option<&'a crate::Employee> {
        match &self.result {
            teaql_core::eval::EvalResult::Value(v) => Some(*v),
            teaql_core::eval::EvalResult::Null => None,
            teaql_core::eval::EvalResult::NotLoaded { failed_node, attempted_path } => {
                crate::trigger_logic_bug_panic(&self.root_desc, &failed_node, &attempted_path)
            }
        }
    }

    pub fn eval(&self) -> Option<&'a crate::Employee> {
        self.resolve()
    }

    pub fn unwrap(&self) -> &'a crate::Employee {
        self.resolve().expect("Relation was legitimately null in database!")
    }

    pub fn get_id(self) -> crate::ValueExpression<'a, u64> {
        let next = self.result.and_then("id", |entity| entity.eval_id());
        crate::ValueExpression::new(next, self.root_desc.clone())
    }

    pub fn get_email(self) -> crate::ValueExpression<'a, String> {
        let next = self.result.and_then("email", |entity| entity.eval_email());
        crate::ValueExpression::new(next, self.root_desc.clone())
    }

    pub fn get_name(self) -> crate::ValueExpression<'a, String> {
        let next = self.result.and_then("name", |entity| entity.eval_name());
        crate::ValueExpression::new(next, self.root_desc.clone())
    }

    pub fn get_phone(self) -> crate::ValueExpression<'a, String> {
        let next = self.result.and_then("phone", |entity| entity.eval_phone());
        crate::ValueExpression::new(next, self.root_desc.clone())
    }

    pub fn get_salary(self) -> crate::ValueExpression<'a, rust_decimal::Decimal> {
        let next = self.result.and_then("salary", |entity| entity.eval_salary());
        crate::ValueExpression::new(next, self.root_desc.clone())
    }

    pub fn get_ssn(self) -> crate::ValueExpression<'a, String> {
        let next = self.result.and_then("ssn", |entity| entity.eval_ssn());
        crate::ValueExpression::new(next, self.root_desc.clone())
    }

    pub fn get_hire_date(self) -> crate::ValueExpression<'a, teaql_core::time::Timestamp> {
        let next = self.result.and_then("hire_date", |entity| entity.eval_hire_date());
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
    pub fn get_department_id(self) -> crate::ValueExpression<'a, u64> {
        let next = self.result.and_then("department_id", |entity| entity.eval_department_id());
        crate::ValueExpression::new(next, self.root_desc.clone())
    }
    pub fn get_department(self) -> crate::DepartmentExpression<'a> {
        let next = self.result.and_then("department", |entity| entity.eval_department());
        crate::DepartmentExpression::new(next, self.root_desc.clone())
    }
    pub fn get_leave_request_list(self) -> crate::LeaveRequestListExpression<'a> {
        let next = self.result.and_then("leave_request_list", |entity| entity.eval_leave_request_list());
        crate::LeaveRequestListExpression::new(next, self.root_desc.clone())
    }

    pub fn get_attendance_list(self) -> crate::AttendanceListExpression<'a> {
        let next = self.result.and_then("attendance_list", |entity| entity.eval_attendance_list());
        crate::AttendanceListExpression::new(next, self.root_desc.clone())
    }

    pub fn get_benefit_list(self) -> crate::BenefitListExpression<'a> {
        let next = self.result.and_then("benefit_list", |entity| entity.eval_benefit_list());
        crate::BenefitListExpression::new(next, self.root_desc.clone())
    }

    pub fn get_employee_review_list(self) -> crate::EmployeeReviewListExpression<'a> {
        let next = self.result.and_then("employee_review_list", |entity| entity.eval_employee_review_list());
        crate::EmployeeReviewListExpression::new(next, self.root_desc.clone())
    }

    pub fn get_payroll_list(self) -> crate::PayrollListExpression<'a> {
        let next = self.result.and_then("payroll_list", |entity| entity.eval_payroll_list());
        crate::PayrollListExpression::new(next, self.root_desc.clone())
    }

    pub fn get_expense_list(self) -> crate::ExpenseListExpression<'a> {
        let next = self.result.and_then("expense_list", |entity| entity.eval_expense_list());
        crate::ExpenseListExpression::new(next, self.root_desc.clone())
    }

    pub fn get_support_agent_list(self) -> crate::SupportAgentListExpression<'a> {
        let next = self.result.and_then("support_agent_list", |entity| entity.eval_support_agent_list());
        crate::SupportAgentListExpression::new(next, self.root_desc.clone())
    }
}

#[derive(Clone)]
pub struct EmployeeListExpression<'a> {
    result: teaql_core::eval::EvalResult<&'a teaql_core::SmartList<crate::Employee>>,
    root_desc: std::sync::Arc<String>,
}

impl<'a> EmployeeListExpression<'a> {
    pub fn new(result: teaql_core::eval::EvalResult<&'a teaql_core::SmartList<crate::Employee>>, root_desc: std::sync::Arc<String>) -> Self {
        Self { result, root_desc }
    }

    fn resolve(&self) -> Option<&'a teaql_core::SmartList<crate::Employee>> {
        match &self.result {
            teaql_core::eval::EvalResult::Value(v) => Some(*v),
            teaql_core::eval::EvalResult::Null => None,
            teaql_core::eval::EvalResult::NotLoaded { failed_node, attempted_path } => {
                crate::trigger_logic_bug_panic(&self.root_desc, &failed_node, &attempted_path)
            }
        }
    }

    pub fn eval(&self) -> Option<&'a teaql_core::SmartList<crate::Employee>> {
        self.resolve()
    }

    pub fn unwrap(&self) -> &'a teaql_core::SmartList<crate::Employee> {
        self.resolve().expect("List relation was legitimately null in database!")
    }

    pub fn size(&self) -> crate::ValueExpression<'a, usize> {
        let next = self.result.clone().and_then("size", |list| teaql_core::eval::EvalResult::Value(list.len()));
        crate::ValueExpression::new(next, self.root_desc.clone())
    }

    pub fn first(&self) -> crate::EmployeeExpression<'a> {
        let next = self.result.clone().and_then("first", |list| {
            if let Some(item) = list.first() {
                teaql_core::eval::EvalResult::Value(item)
            } else {
                teaql_core::eval::EvalResult::Null
            }
        });
        crate::EmployeeExpression::new(next, self.root_desc.clone())
    }

    pub fn get(&self, index: usize) -> crate::EmployeeExpression<'a> {
        let next = self.result.clone().and_then("get", |list| {
            if let Some(item) = list.get(index) {
                teaql_core::eval::EvalResult::Value(item)
            } else {
                teaql_core::eval::EvalResult::Null
            }
        });
        crate::EmployeeExpression::new(next, self.root_desc.clone())
    }
}