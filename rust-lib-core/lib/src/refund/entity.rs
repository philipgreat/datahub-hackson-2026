
// ⛔ AI agents: DO NOT read this file for API discovery. Instead run: cargo teaql --input modeling/MODEL.xml rust-assist-query/refund
use std::collections::BTreeMap;

use teaql_macros::TeaqlEntity;

/// [TEAQL AI WARNING]
/// TeaQL was explicitly designed to PREVENT AI hallucinations and random guessing.
/// DO NOT GUESS METHOD NAMES!
/// The methods listed below are the ONLY valid ways to interact with this entity.
/// If you encounter compilation errors (e.g., method not found), DO NOT guess another method name.
/// Read the method signatures in this file before proceeding.
#[derive(Clone, Debug, PartialEq, TeaqlEntity)]
#[teaql(entity = "Refund", table = "refund_data", data_service = "sqlite")]
pub struct Refund {
#[teaql(id)]
    id: u64,

// @source massive_erp_model.xml:325
    amount: rust_decimal::Decimal,

// @source massive_erp_model.xml:325
    processed_date: teaql_core::time::Timestamp,

// @source massive_erp_model.xml:325
    reason: String,

// @source massive_erp_model.xml:325
    create_time: teaql_core::time::Timestamp,

// @source massive_erp_model.xml:325
    update_time: teaql_core::time::Timestamp,
#[teaql(version)]
    version: i64,
// @source massive_erp_model.xml:325
#[teaql(column = "payment")]
    payment_id: u64,
// @source massive_erp_model.xml:325
#[teaql(relation(target = "Payment", local_key = "payment_id", foreign_key = "id"))]
    payment: Option<crate::Payment>,
    #[teaql(dynamic)]
    dynamic: BTreeMap<String, teaql_core::Value>,
    #[teaql(skip)]
    root: teaql_runtime::EntityRoot,
    #[teaql(skip)]
    pub __load_state: teaql_core::eval::LoadState,
}

impl Refund {
    pub fn with_id(id: u64) -> teaql_core::Value {
        teaql_core::Value::U64(id)
    }

    pub(crate) fn runtime_new(root: teaql_runtime::EntityRoot) -> Self {
        Self {
            id: 0_u64,
            amount: rust_decimal::Decimal::ZERO,
            processed_date: teaql_core::time::Timestamp::now(),
            reason: String::new(),
            create_time: teaql_core::time::Timestamp::now(),
            update_time: teaql_core::time::Timestamp::now(),
            version: 0_i64,
            payment_id: 0_u64,
            payment: None,
            dynamic: BTreeMap::new(),
            root,
            __load_state: teaql_core::eval::LoadState::FullyLoaded,
        }
    }

    pub fn entity_key(&self) -> teaql_runtime::EntityKey {
        teaql_runtime::EntityKey::new("Refund", self.id)
    }

    pub fn attach_root_recursive(&mut self, root: teaql_runtime::EntityRoot) {
        self.root = root.clone();
        if let Some(entity) = &mut self.payment {
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

    pub fn amount(&self) -> rust_decimal::Decimal {
        self.changed_amount().and_then(|value| value.try_decimal()).unwrap_or(self.amount)
    }

    pub fn update_amount(&mut self, value: impl Into<teaql_core::Value>) -> &mut Self {
        let value = value.into();
        self.amount = value.try_decimal().unwrap_or(self.amount.clone());
        self.root.set(self.entity_key(), "amount", value);
        self
    }

    pub fn changed_amount(&self) -> Option<teaql_core::Value> {
        self.root.get(&self.entity_key(), "amount")
    }

    pub fn eval_amount(&self) -> teaql_core::eval::EvalResult<rust_decimal::Decimal> {
        if !self.is_loaded("amount") {
                    teaql_core::eval::EvalResult::NotLoaded { failed_node: "amount".to_string(), attempted_path: "amount".to_string() }
                } else {
                    teaql_core::eval::EvalResult::Value(self.amount())
                }}

    pub fn processed_date(&self) -> teaql_core::time::Timestamp {
        self.changed_processed_date().and_then(|value| value.try_timestamp()).unwrap_or(self.processed_date)
    }

    pub fn update_processed_date(&mut self, value: impl Into<teaql_core::Value>) -> &mut Self {
        let value = value.into();
        self.processed_date = value.try_timestamp().unwrap_or(self.processed_date.clone());
        self.root.set(self.entity_key(), "processed_date", value);
        self
    }

    pub fn changed_processed_date(&self) -> Option<teaql_core::Value> {
        self.root.get(&self.entity_key(), "processed_date")
    }

    pub fn eval_processed_date(&self) -> teaql_core::eval::EvalResult<teaql_core::time::Timestamp> {
        if !self.is_loaded("processed_date") {
                    teaql_core::eval::EvalResult::NotLoaded { failed_node: "processed_date".to_string(), attempted_path: "processed_date".to_string() }
                } else {
                    teaql_core::eval::EvalResult::Value(self.processed_date())
                }}

    pub fn reason(&self) -> String {
        self.changed_reason().and_then(|value| value.try_text().map(|value| value.to_owned())).unwrap_or_else(|| self.reason.clone())
    }

    pub fn update_reason(&mut self, value: impl Into<teaql_core::Value>) -> &mut Self {
        let value = value.into();
        self.reason = value.try_text().map(|value| value.trim().to_owned()).unwrap_or_else(|| self.reason.clone());
        self.root.set(self.entity_key(), "reason", value);
        self
    }

    pub fn changed_reason(&self) -> Option<teaql_core::Value> {
        self.root.get(&self.entity_key(), "reason")
    }

    pub fn eval_reason(&self) -> teaql_core::eval::EvalResult<String> {
        if !self.is_loaded("reason") {
                    teaql_core::eval::EvalResult::NotLoaded { failed_node: "reason".to_string(), attempted_path: "reason".to_string() }
                } else {
                    teaql_core::eval::EvalResult::Value(self.reason())
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
    pub fn payment_id(&self) -> u64 {
        self.changed_payment_id().and_then(|value| value.try_u64()).unwrap_or(self.payment_id)
    }

    pub fn update_payment_id(&mut self, value: impl Into<teaql_core::Value>) -> &mut Self {
        let value = value.into();
        self.payment_id = value.try_u64().unwrap_or(self.payment_id.clone());
        self.root.set(self.entity_key(), "payment_id", value);
        self
    }

    pub fn changed_payment_id(&self) -> Option<teaql_core::Value> {
        self.root.get(&self.entity_key(), "payment_id")
    }

    pub fn eval_payment_id(&self) -> teaql_core::eval::EvalResult<u64> {
        if !self.is_loaded("payment_id") {
                    teaql_core::eval::EvalResult::NotLoaded { failed_node: "payment_id".to_string(), attempted_path: "payment_id".to_string() }
                } else {
                    teaql_core::eval::EvalResult::Value(self.payment_id())
                }}
    pub fn payment(&self) -> Option<&crate::Payment> {
        self.payment.as_ref()
    }

    pub fn eval_payment(&self) -> teaql_core::eval::EvalResult<&crate::Payment> {
        if !self.is_loaded("payment") {
            teaql_core::eval::EvalResult::NotLoaded { failed_node: "payment".to_string(), attempted_path: "payment".to_string() }
        } else {
            match &self.payment {
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

