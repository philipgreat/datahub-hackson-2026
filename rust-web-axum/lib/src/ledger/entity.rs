
// ⛔ AI agents: DO NOT read this file for API discovery. Instead run: cargo teaql --input modeling/MODEL.xml rust-assist-query/ledger
use std::collections::BTreeMap;

use teaql_macros::TeaqlEntity;

/// [TEAQL AI WARNING]
/// TeaQL was explicitly designed to PREVENT AI hallucinations and random guessing.
/// DO NOT GUESS METHOD NAMES!
/// The methods listed below are the ONLY valid ways to interact with this entity.
/// If you encounter compilation errors (e.g., method not found), DO NOT guess another method name.
/// Read the method signatures in this file before proceeding.
#[derive(Clone, Debug, PartialEq, TeaqlEntity)]
#[teaql(entity = "Ledger", table = "ledger_data", data_service = "sqlite")]
pub struct Ledger {
#[teaql(id)]
    id: u64,

// @source massive_erp_model.xml:375
    credit: rust_decimal::Decimal,

// @source massive_erp_model.xml:375
    debit: rust_decimal::Decimal,

// @source massive_erp_model.xml:375
    entry_date: teaql_core::time::Timestamp,

// @source massive_erp_model.xml:375
    create_time: teaql_core::time::Timestamp,

// @source massive_erp_model.xml:375
    update_time: teaql_core::time::Timestamp,
#[teaql(version)]
    version: i64,
// @source massive_erp_model.xml:375
#[teaql(column = "\"transaction\"")]
    transaction_id: u64,
// @source massive_erp_model.xml:375
#[teaql(relation(target = "Transaction", local_key = "transaction_id", foreign_key = "id"))]
    transaction: Option<crate::Transaction>,
    #[teaql(dynamic)]
    dynamic: BTreeMap<String, teaql_core::Value>,
    #[teaql(skip)]
    root: teaql_runtime::EntityRoot,
    #[teaql(skip)]
    pub __load_state: teaql_core::eval::LoadState,
}

impl Ledger {
    pub fn with_id(id: u64) -> teaql_core::Value {
        teaql_core::Value::U64(id)
    }

    pub(crate) fn runtime_new(root: teaql_runtime::EntityRoot) -> Self {
        Self {
            id: 0_u64,
            credit: rust_decimal::Decimal::ZERO,
            debit: rust_decimal::Decimal::ZERO,
            entry_date: teaql_core::time::Timestamp::now(),
            create_time: teaql_core::time::Timestamp::now(),
            update_time: teaql_core::time::Timestamp::now(),
            version: 0_i64,
            transaction_id: 0_u64,
            transaction: None,
            dynamic: BTreeMap::new(),
            root,
            __load_state: teaql_core::eval::LoadState::FullyLoaded,
        }
    }

    pub fn entity_key(&self) -> teaql_runtime::EntityKey {
        teaql_runtime::EntityKey::new("Ledger", self.id)
    }

    pub fn attach_root_recursive(&mut self, root: teaql_runtime::EntityRoot) {
        self.root = root.clone();
        if let Some(entity) = &mut self.transaction {
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

    pub fn credit(&self) -> rust_decimal::Decimal {
        self.changed_credit().and_then(|value| value.try_decimal()).unwrap_or(self.credit)
    }

    pub fn update_credit(&mut self, value: impl Into<teaql_core::Value>) -> &mut Self {
        let value = value.into();
        self.credit = value.try_decimal().unwrap_or(self.credit.clone());
        self.root.set(self.entity_key(), "credit", value);
        self
    }

    pub fn changed_credit(&self) -> Option<teaql_core::Value> {
        self.root.get(&self.entity_key(), "credit")
    }

    pub fn eval_credit(&self) -> teaql_core::eval::EvalResult<rust_decimal::Decimal> {
        if !self.is_loaded("credit") {
                    teaql_core::eval::EvalResult::NotLoaded { failed_node: "credit".to_string(), attempted_path: "credit".to_string() }
                } else {
                    teaql_core::eval::EvalResult::Value(self.credit())
                }}

    pub fn debit(&self) -> rust_decimal::Decimal {
        self.changed_debit().and_then(|value| value.try_decimal()).unwrap_or(self.debit)
    }

    pub fn update_debit(&mut self, value: impl Into<teaql_core::Value>) -> &mut Self {
        let value = value.into();
        self.debit = value.try_decimal().unwrap_or(self.debit.clone());
        self.root.set(self.entity_key(), "debit", value);
        self
    }

    pub fn changed_debit(&self) -> Option<teaql_core::Value> {
        self.root.get(&self.entity_key(), "debit")
    }

    pub fn eval_debit(&self) -> teaql_core::eval::EvalResult<rust_decimal::Decimal> {
        if !self.is_loaded("debit") {
                    teaql_core::eval::EvalResult::NotLoaded { failed_node: "debit".to_string(), attempted_path: "debit".to_string() }
                } else {
                    teaql_core::eval::EvalResult::Value(self.debit())
                }}

    pub fn entry_date(&self) -> teaql_core::time::Timestamp {
        self.changed_entry_date().and_then(|value| value.try_timestamp()).unwrap_or(self.entry_date)
    }

    pub fn update_entry_date(&mut self, value: impl Into<teaql_core::Value>) -> &mut Self {
        let value = value.into();
        self.entry_date = value.try_timestamp().unwrap_or(self.entry_date.clone());
        self.root.set(self.entity_key(), "entry_date", value);
        self
    }

    pub fn changed_entry_date(&self) -> Option<teaql_core::Value> {
        self.root.get(&self.entity_key(), "entry_date")
    }

    pub fn eval_entry_date(&self) -> teaql_core::eval::EvalResult<teaql_core::time::Timestamp> {
        if !self.is_loaded("entry_date") {
                    teaql_core::eval::EvalResult::NotLoaded { failed_node: "entry_date".to_string(), attempted_path: "entry_date".to_string() }
                } else {
                    teaql_core::eval::EvalResult::Value(self.entry_date())
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
    pub fn transaction_id(&self) -> u64 {
        self.changed_transaction_id().and_then(|value| value.try_u64()).unwrap_or(self.transaction_id)
    }

    pub fn update_transaction_id(&mut self, value: impl Into<teaql_core::Value>) -> &mut Self {
        let value = value.into();
        self.transaction_id = value.try_u64().unwrap_or(self.transaction_id.clone());
        self.root.set(self.entity_key(), "transaction_id", value);
        self
    }

    pub fn changed_transaction_id(&self) -> Option<teaql_core::Value> {
        self.root.get(&self.entity_key(), "transaction_id")
    }

    pub fn eval_transaction_id(&self) -> teaql_core::eval::EvalResult<u64> {
        if !self.is_loaded("transaction_id") {
                    teaql_core::eval::EvalResult::NotLoaded { failed_node: "transaction_id".to_string(), attempted_path: "transaction_id".to_string() }
                } else {
                    teaql_core::eval::EvalResult::Value(self.transaction_id())
                }}
    pub fn transaction(&self) -> Option<&crate::Transaction> {
        self.transaction.as_ref()
    }

    pub fn eval_transaction(&self) -> teaql_core::eval::EvalResult<&crate::Transaction> {
        if !self.is_loaded("transaction") {
            teaql_core::eval::EvalResult::NotLoaded { failed_node: "transaction".to_string(), attempted_path: "transaction".to_string() }
        } else {
            match &self.transaction {
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

