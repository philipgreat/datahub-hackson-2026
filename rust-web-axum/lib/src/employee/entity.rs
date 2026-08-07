
// ⛔ AI agents: DO NOT read this file for API discovery. Instead run: cargo teaql --input modeling/MODEL.xml rust-assist-query/employee
use std::collections::BTreeMap;

use teaql_core::SmartList;
use teaql_macros::TeaqlEntity;

/// [TEAQL AI WARNING]
/// TeaQL was explicitly designed to PREVENT AI hallucinations and random guessing.
/// DO NOT GUESS METHOD NAMES!
/// The methods listed below are the ONLY valid ways to interact with this entity.
/// If you encounter compilation errors (e.g., method not found), DO NOT guess another method name.
/// Read the method signatures in this file before proceeding.
#[derive(Clone, Debug, PartialEq, TeaqlEntity)]
#[teaql(entity = "Employee", table = "employee_data", data_service = "sqlite")]
pub struct Employee {
#[teaql(id)]
    id: u64,

// @source massive_erp_model.xml:19
    email: String,

// @source massive_erp_model.xml:19
    name: String,

// @source massive_erp_model.xml:19
    phone: String,

// @source massive_erp_model.xml:19
    salary: rust_decimal::Decimal,

// @source massive_erp_model.xml:19
    ssn: String,

// @source massive_erp_model.xml:19
    hire_date: teaql_core::time::Timestamp,

// @source massive_erp_model.xml:19
    status: String,

// @source massive_erp_model.xml:19
    create_time: teaql_core::time::Timestamp,

// @source massive_erp_model.xml:19
    update_time: teaql_core::time::Timestamp,
#[teaql(version)]
    version: i64,
// @source massive_erp_model.xml:19
#[teaql(column = "department")]
    department_id: u64,
// @source massive_erp_model.xml:19
#[teaql(relation(target = "Department", local_key = "department_id", foreign_key = "id"))]
    department: Option<crate::Department>,
    #[teaql(boxed_relations)]
    pub _relations: Box<EmployeeReverseRelations>,
    #[teaql(dynamic)]
    dynamic: BTreeMap<String, teaql_core::Value>,
    #[teaql(skip)]
    root: teaql_runtime::EntityRoot,
    #[teaql(skip)]
    pub __load_state: teaql_core::eval::LoadState,
}

impl Employee {
    pub fn with_id(id: u64) -> teaql_core::Value {
        teaql_core::Value::U64(id)
    }

    pub(crate) fn runtime_new(root: teaql_runtime::EntityRoot) -> Self {
        Self {
            id: 0_u64,
            email: String::new(),
            name: String::new(),
            phone: String::new(),
            salary: rust_decimal::Decimal::ZERO,
            ssn: String::new(),
            hire_date: teaql_core::time::Timestamp::now(),
            status: String::new(),
            create_time: teaql_core::time::Timestamp::now(),
            update_time: teaql_core::time::Timestamp::now(),
            version: 0_i64,
            department_id: 0_u64,
            department: None,
            _relations: Box::new(EmployeeReverseRelations::new()),
            dynamic: BTreeMap::new(),
            root,
            __load_state: teaql_core::eval::LoadState::FullyLoaded,
        }
    }

    pub fn entity_key(&self) -> teaql_runtime::EntityKey {
        teaql_runtime::EntityKey::new("Employee", self.id)
    }

    pub fn attach_root_recursive(&mut self, root: teaql_runtime::EntityRoot) {
        self.root = root.clone();
        if let Some(entity) = &mut self.department {
            entity.attach_root_recursive(root.clone());
        }
        self._relations.attach_root_recursive(root.clone());
    }

    pub fn is_loaded(&self, field_or_relation: &str) -> bool {
        self.__load_state.is_loaded(field_or_relation)
    }

    pub fn set_load_state(&mut self, state: teaql_core::eval::LoadState) {
        self.__load_state = state;
    }

    pub fn id(&self) -> u64 {
        self.changed_id().and_then(|value| value.try_u64()).unwrap_or(self.id)
    }

    pub fn update_id(&mut self, value: impl Into<teaql_core::Value>) -> &mut Self {
        let value = value.into();
        self.id = value.try_u64().unwrap_or(self.id.clone());
        self.root.set(self.entity_key(), "id", value);
        self
    }

    pub fn changed_id(&self) -> Option<teaql_core::Value> {
        self.root.get(&self.entity_key(), "id")
    }

    pub fn eval_id(&self) -> teaql_core::eval::EvalResult<u64> {
        if !self.is_loaded("id") {
                    teaql_core::eval::EvalResult::NotLoaded { failed_node: "id".to_string(), attempted_path: "id".to_string() }
                } else {
                    teaql_core::eval::EvalResult::Value(self.id())
                }}

    pub fn email(&self) -> String {
        self.changed_email().and_then(|value| value.try_text().map(|value| value.to_owned())).unwrap_or_else(|| self.email.clone())
    }

    pub fn update_email(&mut self, value: impl Into<teaql_core::Value>) -> &mut Self {
        let value = value.into();
        self.email = value.try_text().map(|value| value.trim().to_owned()).unwrap_or_else(|| self.email.clone());
        self.root.set(self.entity_key(), "email", value);
        self
    }

    pub fn changed_email(&self) -> Option<teaql_core::Value> {
        self.root.get(&self.entity_key(), "email")
    }

    pub fn eval_email(&self) -> teaql_core::eval::EvalResult<String> {
        if !self.is_loaded("email") {
                    teaql_core::eval::EvalResult::NotLoaded { failed_node: "email".to_string(), attempted_path: "email".to_string() }
                } else {
                    teaql_core::eval::EvalResult::Value(self.email())
                }}

    pub fn name(&self) -> String {
        self.changed_name().and_then(|value| value.try_text().map(|value| value.to_owned())).unwrap_or_else(|| self.name.clone())
    }

    pub fn update_name(&mut self, value: impl Into<teaql_core::Value>) -> &mut Self {
        let value = value.into();
        self.name = value.try_text().map(|value| value.trim().to_owned()).unwrap_or_else(|| self.name.clone());
        self.root.set(self.entity_key(), "name", value);
        self
    }

    pub fn changed_name(&self) -> Option<teaql_core::Value> {
        self.root.get(&self.entity_key(), "name")
    }

    pub fn eval_name(&self) -> teaql_core::eval::EvalResult<String> {
        if !self.is_loaded("name") {
                    teaql_core::eval::EvalResult::NotLoaded { failed_node: "name".to_string(), attempted_path: "name".to_string() }
                } else {
                    teaql_core::eval::EvalResult::Value(self.name())
                }}

    pub fn phone(&self) -> String {
        self.changed_phone().and_then(|value| value.try_text().map(|value| value.to_owned())).unwrap_or_else(|| self.phone.clone())
    }

    pub fn update_phone(&mut self, value: impl Into<teaql_core::Value>) -> &mut Self {
        let value = value.into();
        self.phone = value.try_text().map(|value| value.trim().to_owned()).unwrap_or_else(|| self.phone.clone());
        self.root.set(self.entity_key(), "phone", value);
        self
    }

    pub fn changed_phone(&self) -> Option<teaql_core::Value> {
        self.root.get(&self.entity_key(), "phone")
    }

    pub fn eval_phone(&self) -> teaql_core::eval::EvalResult<String> {
        if !self.is_loaded("phone") {
                    teaql_core::eval::EvalResult::NotLoaded { failed_node: "phone".to_string(), attempted_path: "phone".to_string() }
                } else {
                    teaql_core::eval::EvalResult::Value(self.phone())
                }}

    pub fn salary(&self) -> rust_decimal::Decimal {
        self.changed_salary().and_then(|value| value.try_decimal()).unwrap_or(self.salary)
    }

    pub fn update_salary(&mut self, value: impl Into<teaql_core::Value>) -> &mut Self {
        let value = value.into();
        self.salary = value.try_decimal().unwrap_or(self.salary.clone());
        self.root.set(self.entity_key(), "salary", value);
        self
    }

    pub fn changed_salary(&self) -> Option<teaql_core::Value> {
        self.root.get(&self.entity_key(), "salary")
    }

    pub fn eval_salary(&self) -> teaql_core::eval::EvalResult<rust_decimal::Decimal> {
        if !self.is_loaded("salary") {
                    teaql_core::eval::EvalResult::NotLoaded { failed_node: "salary".to_string(), attempted_path: "salary".to_string() }
                } else {
                    teaql_core::eval::EvalResult::Value(self.salary())
                }}

    pub fn ssn(&self) -> String {
        self.changed_ssn().and_then(|value| value.try_text().map(|value| value.to_owned())).unwrap_or_else(|| self.ssn.clone())
    }

    pub fn update_ssn(&mut self, value: impl Into<teaql_core::Value>) -> &mut Self {
        let value = value.into();
        self.ssn = value.try_text().map(|value| value.trim().to_owned()).unwrap_or_else(|| self.ssn.clone());
        self.root.set(self.entity_key(), "ssn", value);
        self
    }

    pub fn changed_ssn(&self) -> Option<teaql_core::Value> {
        self.root.get(&self.entity_key(), "ssn")
    }

    pub fn eval_ssn(&self) -> teaql_core::eval::EvalResult<String> {
        if !self.is_loaded("ssn") {
                    teaql_core::eval::EvalResult::NotLoaded { failed_node: "ssn".to_string(), attempted_path: "ssn".to_string() }
                } else {
                    teaql_core::eval::EvalResult::Value(self.ssn())
                }}

    pub fn hire_date(&self) -> teaql_core::time::Timestamp {
        self.changed_hire_date().and_then(|value| value.try_timestamp()).unwrap_or(self.hire_date)
    }

    pub fn update_hire_date(&mut self, value: impl Into<teaql_core::Value>) -> &mut Self {
        let value = value.into();
        self.hire_date = value.try_timestamp().unwrap_or(self.hire_date.clone());
        self.root.set(self.entity_key(), "hire_date", value);
        self
    }

    pub fn changed_hire_date(&self) -> Option<teaql_core::Value> {
        self.root.get(&self.entity_key(), "hire_date")
    }

    pub fn eval_hire_date(&self) -> teaql_core::eval::EvalResult<teaql_core::time::Timestamp> {
        if !self.is_loaded("hire_date") {
                    teaql_core::eval::EvalResult::NotLoaded { failed_node: "hire_date".to_string(), attempted_path: "hire_date".to_string() }
                } else {
                    teaql_core::eval::EvalResult::Value(self.hire_date())
                }}

    pub fn status(&self) -> String {
        self.changed_status().and_then(|value| value.try_text().map(|value| value.to_owned())).unwrap_or_else(|| self.status.clone())
    }

    pub fn update_status(&mut self, value: impl Into<teaql_core::Value>) -> &mut Self {
        let value = value.into();
        self.status = value.try_text().map(|value| value.trim().to_owned()).unwrap_or_else(|| self.status.clone());
        self.root.set(self.entity_key(), "status", value);
        self
    }

    pub fn changed_status(&self) -> Option<teaql_core::Value> {
        self.root.get(&self.entity_key(), "status")
    }

    pub fn eval_status(&self) -> teaql_core::eval::EvalResult<String> {
        if !self.is_loaded("status") {
                    teaql_core::eval::EvalResult::NotLoaded { failed_node: "status".to_string(), attempted_path: "status".to_string() }
                } else {
                    teaql_core::eval::EvalResult::Value(self.status())
                }}

    pub fn create_time(&self) -> teaql_core::time::Timestamp {
        self.changed_create_time().and_then(|value| value.try_timestamp()).unwrap_or(self.create_time)
    }

    pub fn update_create_time(&mut self, value: impl Into<teaql_core::Value>) -> &mut Self {
        let value = value.into();
        self.create_time = value.try_timestamp().unwrap_or(self.create_time.clone());
        self.root.set(self.entity_key(), "create_time", value);
        self
    }

    pub fn changed_create_time(&self) -> Option<teaql_core::Value> {
        self.root.get(&self.entity_key(), "create_time")
    }

    pub fn eval_create_time(&self) -> teaql_core::eval::EvalResult<teaql_core::time::Timestamp> {
        if !self.is_loaded("create_time") {
                    teaql_core::eval::EvalResult::NotLoaded { failed_node: "create_time".to_string(), attempted_path: "create_time".to_string() }
                } else {
                    teaql_core::eval::EvalResult::Value(self.create_time())
                }}

    pub fn update_time(&self) -> teaql_core::time::Timestamp {
        self.changed_update_time().and_then(|value| value.try_timestamp()).unwrap_or(self.update_time)
    }

    pub fn update_update_time(&mut self, value: impl Into<teaql_core::Value>) -> &mut Self {
        let value = value.into();
        self.update_time = value.try_timestamp().unwrap_or(self.update_time.clone());
        self.root.set(self.entity_key(), "update_time", value);
        self
    }

    pub fn changed_update_time(&self) -> Option<teaql_core::Value> {
        self.root.get(&self.entity_key(), "update_time")
    }

    pub fn eval_update_time(&self) -> teaql_core::eval::EvalResult<teaql_core::time::Timestamp> {
        if !self.is_loaded("update_time") {
                    teaql_core::eval::EvalResult::NotLoaded { failed_node: "update_time".to_string(), attempted_path: "update_time".to_string() }
                } else {
                    teaql_core::eval::EvalResult::Value(self.update_time())
                }}

    pub fn version(&self) -> i64 {
        self.changed_version().and_then(|value| value.try_i64()).unwrap_or(self.version)
    }

    pub fn update_version(&mut self, value: impl Into<teaql_core::Value>) -> &mut Self {
        let value = value.into();
        self.version = value.try_i64().unwrap_or(self.version.clone());
        self.root.set(self.entity_key(), "version", value);
        self
    }

    pub fn changed_version(&self) -> Option<teaql_core::Value> {
        self.root.get(&self.entity_key(), "version")
    }

    pub fn eval_version(&self) -> teaql_core::eval::EvalResult<i64> {
        if !self.is_loaded("version") {
                    teaql_core::eval::EvalResult::NotLoaded { failed_node: "version".to_string(), attempted_path: "version".to_string() }
                } else {
                    teaql_core::eval::EvalResult::Value(self.version())
                }}
    pub fn department_id(&self) -> u64 {
        self.changed_department_id().and_then(|value| value.try_u64()).unwrap_or(self.department_id)
    }

    pub fn update_department_id(&mut self, value: impl Into<teaql_core::Value>) -> &mut Self {
        let value = value.into();
        self.department_id = value.try_u64().unwrap_or(self.department_id.clone());
        self.root.set(self.entity_key(), "department_id", value);
        self
    }

    pub fn changed_department_id(&self) -> Option<teaql_core::Value> {
        self.root.get(&self.entity_key(), "department_id")
    }

    pub fn eval_department_id(&self) -> teaql_core::eval::EvalResult<u64> {
        if !self.is_loaded("department_id") {
                    teaql_core::eval::EvalResult::NotLoaded { failed_node: "department_id".to_string(), attempted_path: "department_id".to_string() }
                } else {
                    teaql_core::eval::EvalResult::Value(self.department_id())
                }}
    pub fn department(&self) -> Option<&crate::Department> {
        self.department.as_ref()
    }

    pub fn eval_department(&self) -> teaql_core::eval::EvalResult<&crate::Department> {
        if !self.is_loaded("department") {
            teaql_core::eval::EvalResult::NotLoaded { failed_node: "department".to_string(), attempted_path: "department".to_string() }
        } else {
            match &self.department {
                Some(v) => teaql_core::eval::EvalResult::Value(v),
                None => teaql_core::eval::EvalResult::Null,
            }
        }
    }
    pub fn leave_request_list(&self) -> &SmartList<crate::LeaveRequest> {
        &self._relations.leave_request_list
    }

    pub fn leave_request_list_mut(&mut self) -> &mut SmartList<crate::LeaveRequest> {
        &mut self._relations.leave_request_list
    }

    pub fn eval_leave_request_list(&self) -> teaql_core::eval::EvalResult<&SmartList<crate::LeaveRequest>> {
        if !self.is_loaded("leave_request_list") {
            teaql_core::eval::EvalResult::NotLoaded { failed_node: "leave_request_list".to_string(), attempted_path: "leave_request_list".to_string() }
        } else {
            teaql_core::eval::EvalResult::Value(&self._relations.leave_request_list)
        }
    }

    pub fn attendance_list(&self) -> &SmartList<crate::Attendance> {
        &self._relations.attendance_list
    }

    pub fn attendance_list_mut(&mut self) -> &mut SmartList<crate::Attendance> {
        &mut self._relations.attendance_list
    }

    pub fn eval_attendance_list(&self) -> teaql_core::eval::EvalResult<&SmartList<crate::Attendance>> {
        if !self.is_loaded("attendance_list") {
            teaql_core::eval::EvalResult::NotLoaded { failed_node: "attendance_list".to_string(), attempted_path: "attendance_list".to_string() }
        } else {
            teaql_core::eval::EvalResult::Value(&self._relations.attendance_list)
        }
    }

    pub fn benefit_list(&self) -> &SmartList<crate::Benefit> {
        &self._relations.benefit_list
    }

    pub fn benefit_list_mut(&mut self) -> &mut SmartList<crate::Benefit> {
        &mut self._relations.benefit_list
    }

    pub fn eval_benefit_list(&self) -> teaql_core::eval::EvalResult<&SmartList<crate::Benefit>> {
        if !self.is_loaded("benefit_list") {
            teaql_core::eval::EvalResult::NotLoaded { failed_node: "benefit_list".to_string(), attempted_path: "benefit_list".to_string() }
        } else {
            teaql_core::eval::EvalResult::Value(&self._relations.benefit_list)
        }
    }

    pub fn employee_review_list(&self) -> &SmartList<crate::EmployeeReview> {
        &self._relations.employee_review_list
    }

    pub fn employee_review_list_mut(&mut self) -> &mut SmartList<crate::EmployeeReview> {
        &mut self._relations.employee_review_list
    }

    pub fn eval_employee_review_list(&self) -> teaql_core::eval::EvalResult<&SmartList<crate::EmployeeReview>> {
        if !self.is_loaded("employee_review_list") {
            teaql_core::eval::EvalResult::NotLoaded { failed_node: "employee_review_list".to_string(), attempted_path: "employee_review_list".to_string() }
        } else {
            teaql_core::eval::EvalResult::Value(&self._relations.employee_review_list)
        }
    }

    pub fn payroll_list(&self) -> &SmartList<crate::Payroll> {
        &self._relations.payroll_list
    }

    pub fn payroll_list_mut(&mut self) -> &mut SmartList<crate::Payroll> {
        &mut self._relations.payroll_list
    }

    pub fn eval_payroll_list(&self) -> teaql_core::eval::EvalResult<&SmartList<crate::Payroll>> {
        if !self.is_loaded("payroll_list") {
            teaql_core::eval::EvalResult::NotLoaded { failed_node: "payroll_list".to_string(), attempted_path: "payroll_list".to_string() }
        } else {
            teaql_core::eval::EvalResult::Value(&self._relations.payroll_list)
        }
    }

    pub fn expense_list(&self) -> &SmartList<crate::Expense> {
        &self._relations.expense_list
    }

    pub fn expense_list_mut(&mut self) -> &mut SmartList<crate::Expense> {
        &mut self._relations.expense_list
    }

    pub fn eval_expense_list(&self) -> teaql_core::eval::EvalResult<&SmartList<crate::Expense>> {
        if !self.is_loaded("expense_list") {
            teaql_core::eval::EvalResult::NotLoaded { failed_node: "expense_list".to_string(), attempted_path: "expense_list".to_string() }
        } else {
            teaql_core::eval::EvalResult::Value(&self._relations.expense_list)
        }
    }

    pub fn support_agent_list(&self) -> &SmartList<crate::SupportAgent> {
        &self._relations.support_agent_list
    }

    pub fn support_agent_list_mut(&mut self) -> &mut SmartList<crate::SupportAgent> {
        &mut self._relations.support_agent_list
    }

    pub fn eval_support_agent_list(&self) -> teaql_core::eval::EvalResult<&SmartList<crate::SupportAgent>> {
        if !self.is_loaded("support_agent_list") {
            teaql_core::eval::EvalResult::NotLoaded { failed_node: "support_agent_list".to_string(), attempted_path: "support_agent_list".to_string() }
        } else {
            teaql_core::eval::EvalResult::Value(&self._relations.support_agent_list)
        }
    }

    pub fn mark_as_delete(&mut self) -> &mut Self {
        self.root.mark_as_delete(self.entity_key());
        self
    }

    pub fn set_comment(&mut self, comment: impl Into<String>) -> &mut Self {
        self.root.set_comment(comment);
        self
    }
}

#[derive(Clone, Debug, PartialEq, teaql_macros::TeaqlReverseRelations)]
pub struct EmployeeReverseRelations {
#[teaql(relation(target = "LeaveRequest", local_key = "id", foreign_key = "employee_id", many))]
    leave_request_list: SmartList<crate::LeaveRequest>,
#[teaql(relation(target = "Attendance", local_key = "id", foreign_key = "employee_id", many))]
    attendance_list: SmartList<crate::Attendance>,
#[teaql(relation(target = "Benefit", local_key = "id", foreign_key = "employee_id", many))]
    benefit_list: SmartList<crate::Benefit>,
#[teaql(relation(target = "EmployeeReview", local_key = "id", foreign_key = "employee_id", many))]
    employee_review_list: SmartList<crate::EmployeeReview>,
#[teaql(relation(target = "Payroll", local_key = "id", foreign_key = "employee_id", many))]
    payroll_list: SmartList<crate::Payroll>,
#[teaql(relation(target = "Expense", local_key = "id", foreign_key = "employee_id", many))]
    expense_list: SmartList<crate::Expense>,
#[teaql(relation(target = "SupportAgent", local_key = "id", foreign_key = "employee_id", many))]
    support_agent_list: SmartList<crate::SupportAgent>,
}

impl EmployeeReverseRelations {
    pub fn new() -> Self {
        Self {
            leave_request_list: Default::default(),
            attendance_list: Default::default(),
            benefit_list: Default::default(),
            employee_review_list: Default::default(),
            payroll_list: Default::default(),
            expense_list: Default::default(),
            support_agent_list: Default::default(),
        }
    }

    pub fn attach_root_recursive(&mut self, root: teaql_runtime::EntityRoot) {
        for entity in &mut self.leave_request_list {
            entity.attach_root_recursive(root.clone());
        }
        for entity in &mut self.attendance_list {
            entity.attach_root_recursive(root.clone());
        }
        for entity in &mut self.benefit_list {
            entity.attach_root_recursive(root.clone());
        }
        for entity in &mut self.employee_review_list {
            entity.attach_root_recursive(root.clone());
        }
        for entity in &mut self.payroll_list {
            entity.attach_root_recursive(root.clone());
        }
        for entity in &mut self.expense_list {
            entity.attach_root_recursive(root.clone());
        }
        for entity in &mut self.support_agent_list {
            entity.attach_root_recursive(root.clone());
        }
    }
}
