
// ⛔ AI agents: DO NOT read this file for API discovery. Instead run: cargo teaql --input modeling/MODEL.xml rust-assist-query/payment_transaction
use std::collections::BTreeMap;

use teaql_macros::TeaqlEntity;

/// [TEAQL AI WARNING]
/// TeaQL was explicitly designed to PREVENT AI hallucinations and random guessing.
/// DO NOT GUESS METHOD NAMES!
/// The methods listed below are the ONLY valid ways to interact with this entity.
/// If you encounter compilation errors (e.g., method not found), DO NOT guess another method name.
/// Read the method signatures in this file before proceeding.
#[derive(Clone, Debug, PartialEq, TeaqlEntity)]
#[teaql(entity = "PaymentTransaction", table = "payment_transaction_data", data_service = "sqlite", audit_mask_fields = "payment_account")]
pub struct PaymentTransaction {
#[teaql(id)]
    id: u64,

// @source payment.xml:56
    transaction_amount: rust_decimal::Decimal,

// @source payment.xml:56
    currency_code: String,

// @source payment.xml:56
    reference_number: String,

// @source payment.xml:56
    create_time: teaql_core::time::Timestamp,

// @source payment.xml:56
    update_time: teaql_core::time::Timestamp,
#[teaql(version)]
    version: i64,
// @source payment.xml:56
#[teaql(column = "payment_account")]
    payment_account_id: u64,

// @source payment.xml:56
#[teaql(column = "payment_method")]
    payment_method_id: u64,

// @source payment.xml:56
#[teaql(column = "payment_status")]
    payment_status_id: u64,
// @source payment.xml:56
#[teaql(relation(target = "PaymentAccount", local_key = "payment_account_id", foreign_key = "id"))]
    payment_account: Option<crate::PaymentAccount>,

// @source payment.xml:56
#[teaql(relation(target = "PaymentMethod", local_key = "payment_method_id", foreign_key = "id"))]
    payment_method: Option<crate::PaymentMethod>,

// @source payment.xml:56
#[teaql(relation(target = "PaymentStatus", local_key = "payment_status_id", foreign_key = "id"))]
    payment_status: Option<crate::PaymentStatus>,
    #[teaql(dynamic)]
    dynamic: BTreeMap<String, teaql_core::Value>,
    #[teaql(skip)]
    root: teaql_runtime::EntityRoot,
    #[teaql(skip)]
    pub __load_state: teaql_core::eval::LoadState,
}

impl PaymentTransaction {
    pub fn with_id(id: u64) -> teaql_core::Value {
        teaql_core::Value::U64(id)
    }

    pub(crate) fn runtime_new(root: teaql_runtime::EntityRoot) -> Self {
        Self {
            id: 0_u64,
            transaction_amount: rust_decimal::Decimal::ZERO,
            currency_code: String::new(),
            reference_number: String::new(),
            create_time: teaql_core::time::Timestamp::now(),
            update_time: teaql_core::time::Timestamp::now(),
            version: 0_i64,
            payment_account_id: 0_u64,
            payment_method_id: 0_u64,
            payment_status_id: 0_u64,
            payment_account: None,
            payment_method: None,
            payment_status: None,
            dynamic: BTreeMap::new(),
            root,
            __load_state: teaql_core::eval::LoadState::FullyLoaded,
        }
    }

    pub fn entity_key(&self) -> teaql_runtime::EntityKey {
        teaql_runtime::EntityKey::new("PaymentTransaction", self.id)
    }

    pub fn attach_root_recursive(&mut self, root: teaql_runtime::EntityRoot) {
        self.root = root.clone();
        if let Some(entity) = &mut self.payment_account {
            entity.attach_root_recursive(root.clone());
        }
        if let Some(entity) = &mut self.payment_method {
            entity.attach_root_recursive(root.clone());
        }
        if let Some(entity) = &mut self.payment_status {
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

    pub fn transaction_amount(&self) -> rust_decimal::Decimal {
        self.changed_transaction_amount().and_then(|value| value.try_decimal()).unwrap_or(self.transaction_amount)
    }

    pub fn update_transaction_amount(&mut self, value: impl Into<teaql_core::Value>) -> &mut Self {
        let value = value.into();
        self.transaction_amount = value.try_decimal().unwrap_or(self.transaction_amount.clone());
        self.root.set(self.entity_key(), "transaction_amount", value);
        self
    }

    pub fn changed_transaction_amount(&self) -> Option<teaql_core::Value> {
        self.root.get(&self.entity_key(), "transaction_amount")
    }

    pub fn eval_transaction_amount(&self) -> teaql_core::eval::EvalResult<rust_decimal::Decimal> {
        if !self.is_loaded("transaction_amount") {
                    teaql_core::eval::EvalResult::NotLoaded { failed_node: "transaction_amount".to_string(), attempted_path: "transaction_amount".to_string() }
                } else {
                    teaql_core::eval::EvalResult::Value(self.transaction_amount())
                }}

    pub fn currency_code(&self) -> String {
        self.changed_currency_code().and_then(|value| value.try_text().map(|value| value.to_owned())).unwrap_or_else(|| self.currency_code.clone())
    }

    pub fn update_currency_code(&mut self, value: impl Into<teaql_core::Value>) -> &mut Self {
        let value = value.into();
        self.currency_code = value.try_text().map(|value| value.trim().to_owned()).unwrap_or_else(|| self.currency_code.clone());
        self.root.set(self.entity_key(), "currency_code", value);
        self
    }

    pub fn changed_currency_code(&self) -> Option<teaql_core::Value> {
        self.root.get(&self.entity_key(), "currency_code")
    }

    pub fn eval_currency_code(&self) -> teaql_core::eval::EvalResult<String> {
        if !self.is_loaded("currency_code") {
                    teaql_core::eval::EvalResult::NotLoaded { failed_node: "currency_code".to_string(), attempted_path: "currency_code".to_string() }
                } else {
                    teaql_core::eval::EvalResult::Value(self.currency_code())
                }}

    pub fn reference_number(&self) -> String {
        self.changed_reference_number().and_then(|value| value.try_text().map(|value| value.to_owned())).unwrap_or_else(|| self.reference_number.clone())
    }

    pub fn update_reference_number(&mut self, value: impl Into<teaql_core::Value>) -> &mut Self {
        let value = value.into();
        self.reference_number = value.try_text().map(|value| value.trim().to_owned()).unwrap_or_else(|| self.reference_number.clone());
        self.root.set(self.entity_key(), "reference_number", value);
        self
    }

    pub fn changed_reference_number(&self) -> Option<teaql_core::Value> {
        self.root.get(&self.entity_key(), "reference_number")
    }

    pub fn eval_reference_number(&self) -> teaql_core::eval::EvalResult<String> {
        if !self.is_loaded("reference_number") {
                    teaql_core::eval::EvalResult::NotLoaded { failed_node: "reference_number".to_string(), attempted_path: "reference_number".to_string() }
                } else {
                    teaql_core::eval::EvalResult::Value(self.reference_number())
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
    pub fn payment_account_id(&self) -> u64 {
        self.changed_payment_account_id().and_then(|value| value.try_u64()).unwrap_or(self.payment_account_id)
    }

    pub fn update_payment_account_id(&mut self, value: impl Into<teaql_core::Value>) -> &mut Self {
        let value = value.into();
        self.payment_account_id = value.try_u64().unwrap_or(self.payment_account_id.clone());
        self.root.set(self.entity_key(), "payment_account_id", value);
        self
    }

    pub fn changed_payment_account_id(&self) -> Option<teaql_core::Value> {
        self.root.get(&self.entity_key(), "payment_account_id")
    }

    pub fn eval_payment_account_id(&self) -> teaql_core::eval::EvalResult<u64> {
        if !self.is_loaded("payment_account_id") {
                    teaql_core::eval::EvalResult::NotLoaded { failed_node: "payment_account_id".to_string(), attempted_path: "payment_account_id".to_string() }
                } else {
                    teaql_core::eval::EvalResult::Value(self.payment_account_id())
                }}

    pub fn payment_method_id(&self) -> u64 {
        self.changed_payment_method_id().and_then(|value| value.try_u64()).unwrap_or(self.payment_method_id)
    }

    pub fn update_payment_method_id(&mut self, value: impl Into<teaql_core::Value>) -> &mut Self {
        let value = value.into();
        self.payment_method_id = value.try_u64().unwrap_or(self.payment_method_id.clone());
        self.root.set(self.entity_key(), "payment_method_id", value);
        self
    }

    pub fn changed_payment_method_id(&self) -> Option<teaql_core::Value> {
        self.root.get(&self.entity_key(), "payment_method_id")
    }

    pub fn eval_payment_method_id(&self) -> teaql_core::eval::EvalResult<u64> {
        if !self.is_loaded("payment_method_id") {
                    teaql_core::eval::EvalResult::NotLoaded { failed_node: "payment_method_id".to_string(), attempted_path: "payment_method_id".to_string() }
                } else {
                    teaql_core::eval::EvalResult::Value(self.payment_method_id())
                }}

    pub fn payment_status_id(&self) -> u64 {
        self.changed_payment_status_id().and_then(|value| value.try_u64()).unwrap_or(self.payment_status_id)
    }

    pub(crate) fn update_payment_status_id(&mut self, value: impl Into<teaql_core::Value>) -> &mut Self {
        let value = value.into();
        self.payment_status_id = value.try_u64().unwrap_or(self.payment_status_id.clone());
        self.root.set(self.entity_key(), "payment_status_id", value);
        self
    }

    pub fn changed_payment_status_id(&self) -> Option<teaql_core::Value> {
        self.root.get(&self.entity_key(), "payment_status_id")
    }

    pub fn eval_payment_status_id(&self) -> teaql_core::eval::EvalResult<u64> {
        if !self.is_loaded("payment_status_id") {
                    teaql_core::eval::EvalResult::NotLoaded { failed_node: "payment_status_id".to_string(), attempted_path: "payment_status_id".to_string() }
                } else {
                    teaql_core::eval::EvalResult::Value(self.payment_status_id())
                }}
    pub fn update_payment_status_to_pending(&mut self) -> &mut Self {
        self.update_payment_status_id(1001_u64)
    }

    pub fn payment_status_is_pending(&self) -> bool {
        self.payment_status_id() == 1001_u64
    }
    pub fn update_payment_status_to_success(&mut self) -> &mut Self {
        self.update_payment_status_id(1002_u64)
    }

    pub fn payment_status_is_success(&self) -> bool {
        self.payment_status_id() == 1002_u64
    }
    pub fn update_payment_status_to_failed(&mut self) -> &mut Self {
        self.update_payment_status_id(1003_u64)
    }

    pub fn payment_status_is_failed(&self) -> bool {
        self.payment_status_id() == 1003_u64
    }
    pub fn payment_account(&self) -> Option<&crate::PaymentAccount> {
        self.payment_account.as_ref()
    }

    pub fn eval_payment_account(&self) -> teaql_core::eval::EvalResult<&crate::PaymentAccount> {
        if !self.is_loaded("payment_account") {
            teaql_core::eval::EvalResult::NotLoaded { failed_node: "payment_account".to_string(), attempted_path: "payment_account".to_string() }
        } else {
            match &self.payment_account {
                Some(v) => teaql_core::eval::EvalResult::Value(v),
                None => teaql_core::eval::EvalResult::Null,
            }
        }
    }

    pub fn payment_method(&self) -> Option<&crate::PaymentMethod> {
        self.payment_method.as_ref()
    }

    pub fn eval_payment_method(&self) -> teaql_core::eval::EvalResult<&crate::PaymentMethod> {
        if !self.is_loaded("payment_method") {
            teaql_core::eval::EvalResult::NotLoaded { failed_node: "payment_method".to_string(), attempted_path: "payment_method".to_string() }
        } else {
            match &self.payment_method {
                Some(v) => teaql_core::eval::EvalResult::Value(v),
                None => teaql_core::eval::EvalResult::Null,
            }
        }
    }

    pub fn payment_status(&self) -> Option<&crate::PaymentStatus> {
        self.payment_status.as_ref()
    }

    pub fn eval_payment_status(&self) -> teaql_core::eval::EvalResult<&crate::PaymentStatus> {
        if !self.is_loaded("payment_status") {
            teaql_core::eval::EvalResult::NotLoaded { failed_node: "payment_status".to_string(), attempted_path: "payment_status".to_string() }
        } else {
            match &self.payment_status {
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

