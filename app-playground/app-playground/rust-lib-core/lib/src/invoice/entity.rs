
// ⛔ AI agents: DO NOT read this file for API discovery. Instead run: cargo teaql --input modeling/MODEL.xml rust-assist-query/invoice
use std::collections::BTreeMap;

use teaql_macros::TeaqlEntity;

/// [TEAQL AI WARNING]
/// TeaQL was explicitly designed to PREVENT AI hallucinations and random guessing.
/// DO NOT GUESS METHOD NAMES!
/// The methods listed below are the ONLY valid ways to interact with this entity.
/// If you encounter compilation errors (e.g., method not found), DO NOT guess another method name.
/// Read the method signatures in this file before proceeding.
#[derive(Clone, Debug, PartialEq, TeaqlEntity)]
#[teaql(entity = "Invoice", table = "invoice_data", data_service = "sqlite")]
pub struct Invoice {
#[teaql(id)]
    id: u64,

// @source moving-company.xml:109
    invoice_number: String,

// @source moving-company.xml:109
    total_amount: rust_decimal::Decimal,

// @source moving-company.xml:109
    paid_amount: rust_decimal::Decimal,

// @source moving-company.xml:109
    is_paid: bool,

// @source moving-company.xml:109
    due_date: chrono::NaiveDate,

// @source moving-company.xml:109
    create_time: chrono::DateTime<chrono::Utc>,

// @source moving-company.xml:109
    update_time: chrono::DateTime<chrono::Utc>,
#[teaql(version)]
    version: i64,
// @source moving-company.xml:109
#[teaql(column = "company")]
    company_id: u64,

// @source moving-company.xml:109
#[teaql(column = "move_order")]
    move_order_id: u64,

// @source moving-company.xml:109
#[teaql(column = "customer")]
    customer_id: u64,
// @source moving-company.xml:109
#[teaql(relation(target = "Company", local_key = "company_id", foreign_key = "id"))]
    company: Option<crate::Company>,

// @source moving-company.xml:109
#[teaql(relation(target = "MoveOrder", local_key = "move_order_id", foreign_key = "id"))]
    move_order: Option<crate::MoveOrder>,

// @source moving-company.xml:109
#[teaql(relation(target = "Customer", local_key = "customer_id", foreign_key = "id"))]
    customer: Option<crate::Customer>,
    #[teaql(dynamic)]
    dynamic: BTreeMap<String, teaql_core::Value>,
    #[teaql(skip)]
    root: teaql_runtime::EntityRoot,
    #[teaql(skip)]
    pub __load_state: teaql_core::eval::LoadState,
}

impl Invoice {
    pub fn with_id(id: u64) -> teaql_core::Value {
        teaql_core::Value::U64(id)
    }

    pub(crate) fn runtime_new(root: teaql_runtime::EntityRoot) -> Self {
        Self {
            id: 0_u64,
            invoice_number: String::new(),
            total_amount: rust_decimal::Decimal::ZERO,
            paid_amount: rust_decimal::Decimal::ZERO,
            is_paid: false,
            due_date: chrono::NaiveDate::from_ymd_opt(1970, 1, 1).unwrap(),
            create_time: chrono::Utc::now(),
            update_time: chrono::Utc::now(),
            version: 0_i64,
            company_id: 0_u64,
            move_order_id: 0_u64,
            customer_id: 0_u64,
            company: None,
            move_order: None,
            customer: None,
            dynamic: BTreeMap::new(),
            root,
            __load_state: teaql_core::eval::LoadState::FullyLoaded,
        }
    }

    pub fn entity_key(&self) -> teaql_runtime::EntityKey {
        teaql_runtime::EntityKey::new("Invoice", self.id)
    }

    pub fn attach_root_recursive(&mut self, root: teaql_runtime::EntityRoot) {
        self.root = root.clone();
        if let Some(entity) = &mut self.company {
            entity.attach_root_recursive(root.clone());
        }
        if let Some(entity) = &mut self.move_order {
            entity.attach_root_recursive(root.clone());
        }
        if let Some(entity) = &mut self.customer {
            entity.attach_root_recursive(root.clone());
        }
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

    pub fn invoice_number(&self) -> String {
        self.changed_invoice_number().and_then(|value| value.try_text().map(|value| value.to_owned())).unwrap_or_else(|| self.invoice_number.clone())
    }

    pub fn update_invoice_number(&mut self, value: impl Into<teaql_core::Value>) -> &mut Self {
        let value = value.into();
        self.invoice_number = value.try_text().map(|value| value.trim().to_owned()).unwrap_or_else(|| self.invoice_number.clone());
        self.root.set(self.entity_key(), "invoice_number", value);
        self
    }

    pub fn changed_invoice_number(&self) -> Option<teaql_core::Value> {
        self.root.get(&self.entity_key(), "invoice_number")
    }

    pub fn eval_invoice_number(&self) -> teaql_core::eval::EvalResult<String> {
        if !self.is_loaded("invoice_number") {
                    teaql_core::eval::EvalResult::NotLoaded { failed_node: "invoice_number".to_string(), attempted_path: "invoice_number".to_string() }
                } else {
                    teaql_core::eval::EvalResult::Value(self.invoice_number())
                }}

    pub fn total_amount(&self) -> rust_decimal::Decimal {
        self.changed_total_amount().and_then(|value| value.try_decimal()).unwrap_or(self.total_amount)
    }

    pub fn update_total_amount(&mut self, value: impl Into<teaql_core::Value>) -> &mut Self {
        let value = value.into();
        self.total_amount = value.try_decimal().unwrap_or(self.total_amount.clone());
        self.root.set(self.entity_key(), "total_amount", value);
        self
    }

    pub fn changed_total_amount(&self) -> Option<teaql_core::Value> {
        self.root.get(&self.entity_key(), "total_amount")
    }

    pub fn eval_total_amount(&self) -> teaql_core::eval::EvalResult<rust_decimal::Decimal> {
        if !self.is_loaded("total_amount") {
                    teaql_core::eval::EvalResult::NotLoaded { failed_node: "total_amount".to_string(), attempted_path: "total_amount".to_string() }
                } else {
                    teaql_core::eval::EvalResult::Value(self.total_amount())
                }}

    pub fn paid_amount(&self) -> rust_decimal::Decimal {
        self.changed_paid_amount().and_then(|value| value.try_decimal()).unwrap_or(self.paid_amount)
    }

    pub fn update_paid_amount(&mut self, value: impl Into<teaql_core::Value>) -> &mut Self {
        let value = value.into();
        self.paid_amount = value.try_decimal().unwrap_or(self.paid_amount.clone());
        self.root.set(self.entity_key(), "paid_amount", value);
        self
    }

    pub fn changed_paid_amount(&self) -> Option<teaql_core::Value> {
        self.root.get(&self.entity_key(), "paid_amount")
    }

    pub fn eval_paid_amount(&self) -> teaql_core::eval::EvalResult<rust_decimal::Decimal> {
        if !self.is_loaded("paid_amount") {
                    teaql_core::eval::EvalResult::NotLoaded { failed_node: "paid_amount".to_string(), attempted_path: "paid_amount".to_string() }
                } else {
                    teaql_core::eval::EvalResult::Value(self.paid_amount())
                }}

    pub fn is_paid(&self) -> bool {
        self.changed_is_paid().and_then(|value| value.try_bool()).unwrap_or(self.is_paid)
    }

    pub fn update_is_paid(&mut self, value: impl Into<teaql_core::Value>) -> &mut Self {
        let value = value.into();
        self.is_paid = value.try_bool().unwrap_or(self.is_paid.clone());
        self.root.set(self.entity_key(), "is_paid", value);
        self
    }

    pub fn changed_is_paid(&self) -> Option<teaql_core::Value> {
        self.root.get(&self.entity_key(), "is_paid")
    }

    pub fn eval_is_paid(&self) -> teaql_core::eval::EvalResult<bool> {
        if !self.is_loaded("is_paid") {
                    teaql_core::eval::EvalResult::NotLoaded { failed_node: "is_paid".to_string(), attempted_path: "is_paid".to_string() }
                } else {
                    teaql_core::eval::EvalResult::Value(self.is_paid())
                }}

    pub fn due_date(&self) -> chrono::NaiveDate {
        self.changed_due_date().and_then(|value| value.try_date()).unwrap_or(self.due_date)
    }

    pub fn update_due_date(&mut self, value: impl Into<teaql_core::Value>) -> &mut Self {
        let value = value.into();
        self.due_date = value.try_date().unwrap_or(self.due_date.clone());
        self.root.set(self.entity_key(), "due_date", value);
        self
    }

    pub fn changed_due_date(&self) -> Option<teaql_core::Value> {
        self.root.get(&self.entity_key(), "due_date")
    }

    pub fn eval_due_date(&self) -> teaql_core::eval::EvalResult<chrono::NaiveDate> {
        if !self.is_loaded("due_date") {
                    teaql_core::eval::EvalResult::NotLoaded { failed_node: "due_date".to_string(), attempted_path: "due_date".to_string() }
                } else {
                    teaql_core::eval::EvalResult::Value(self.due_date())
                }}

    pub fn create_time(&self) -> chrono::DateTime<chrono::Utc> {
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

    pub fn eval_create_time(&self) -> teaql_core::eval::EvalResult<chrono::DateTime<chrono::Utc>> {
        if !self.is_loaded("create_time") {
                    teaql_core::eval::EvalResult::NotLoaded { failed_node: "create_time".to_string(), attempted_path: "create_time".to_string() }
                } else {
                    teaql_core::eval::EvalResult::Value(self.create_time())
                }}

    pub fn update_time(&self) -> chrono::DateTime<chrono::Utc> {
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

    pub fn eval_update_time(&self) -> teaql_core::eval::EvalResult<chrono::DateTime<chrono::Utc>> {
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
    pub fn company_id(&self) -> u64 {
        self.changed_company_id().and_then(|value| value.try_u64()).unwrap_or(self.company_id)
    }

    pub fn update_company_id(&mut self, value: impl Into<teaql_core::Value>) -> &mut Self {
        let value = value.into();
        self.company_id = value.try_u64().unwrap_or(self.company_id.clone());
        self.root.set(self.entity_key(), "company_id", value);
        self
    }

    pub fn changed_company_id(&self) -> Option<teaql_core::Value> {
        self.root.get(&self.entity_key(), "company_id")
    }

    pub fn eval_company_id(&self) -> teaql_core::eval::EvalResult<u64> {
        if !self.is_loaded("company_id") {
                    teaql_core::eval::EvalResult::NotLoaded { failed_node: "company_id".to_string(), attempted_path: "company_id".to_string() }
                } else {
                    teaql_core::eval::EvalResult::Value(self.company_id())
                }}

    pub fn move_order_id(&self) -> u64 {
        self.changed_move_order_id().and_then(|value| value.try_u64()).unwrap_or(self.move_order_id)
    }

    pub fn update_move_order_id(&mut self, value: impl Into<teaql_core::Value>) -> &mut Self {
        let value = value.into();
        self.move_order_id = value.try_u64().unwrap_or(self.move_order_id.clone());
        self.root.set(self.entity_key(), "move_order_id", value);
        self
    }

    pub fn changed_move_order_id(&self) -> Option<teaql_core::Value> {
        self.root.get(&self.entity_key(), "move_order_id")
    }

    pub fn eval_move_order_id(&self) -> teaql_core::eval::EvalResult<u64> {
        if !self.is_loaded("move_order_id") {
                    teaql_core::eval::EvalResult::NotLoaded { failed_node: "move_order_id".to_string(), attempted_path: "move_order_id".to_string() }
                } else {
                    teaql_core::eval::EvalResult::Value(self.move_order_id())
                }}

    pub fn customer_id(&self) -> u64 {
        self.changed_customer_id().and_then(|value| value.try_u64()).unwrap_or(self.customer_id)
    }

    pub fn update_customer_id(&mut self, value: impl Into<teaql_core::Value>) -> &mut Self {
        let value = value.into();
        self.customer_id = value.try_u64().unwrap_or(self.customer_id.clone());
        self.root.set(self.entity_key(), "customer_id", value);
        self
    }

    pub fn changed_customer_id(&self) -> Option<teaql_core::Value> {
        self.root.get(&self.entity_key(), "customer_id")
    }

    pub fn eval_customer_id(&self) -> teaql_core::eval::EvalResult<u64> {
        if !self.is_loaded("customer_id") {
                    teaql_core::eval::EvalResult::NotLoaded { failed_node: "customer_id".to_string(), attempted_path: "customer_id".to_string() }
                } else {
                    teaql_core::eval::EvalResult::Value(self.customer_id())
                }}
    pub fn company(&self) -> Option<&crate::Company> {
        self.company.as_ref()
    }

    pub fn eval_company(&self) -> teaql_core::eval::EvalResult<&crate::Company> {
        if !self.is_loaded("company") {
            teaql_core::eval::EvalResult::NotLoaded { failed_node: "company".to_string(), attempted_path: "company".to_string() }
        } else {
            match &self.company {
                Some(v) => teaql_core::eval::EvalResult::Value(v),
                None => teaql_core::eval::EvalResult::Null,
            }
        }
    }

    pub fn move_order(&self) -> Option<&crate::MoveOrder> {
        self.move_order.as_ref()
    }

    pub fn eval_move_order(&self) -> teaql_core::eval::EvalResult<&crate::MoveOrder> {
        if !self.is_loaded("move_order") {
            teaql_core::eval::EvalResult::NotLoaded { failed_node: "move_order".to_string(), attempted_path: "move_order".to_string() }
        } else {
            match &self.move_order {
                Some(v) => teaql_core::eval::EvalResult::Value(v),
                None => teaql_core::eval::EvalResult::Null,
            }
        }
    }

    pub fn customer(&self) -> Option<&crate::Customer> {
        self.customer.as_ref()
    }

    pub fn eval_customer(&self) -> teaql_core::eval::EvalResult<&crate::Customer> {
        if !self.is_loaded("customer") {
            teaql_core::eval::EvalResult::NotLoaded { failed_node: "customer".to_string(), attempted_path: "customer".to_string() }
        } else {
            match &self.customer {
                Some(v) => teaql_core::eval::EvalResult::Value(v),
                None => teaql_core::eval::EvalResult::Null,
            }
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

