
// ⛔ AI agents: DO NOT read this file for API discovery. Instead run: cargo teaql --input modeling/MODEL.xml rust-assist-query/payment_status
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
#[teaql(entity = "PaymentStatus", table = "payment_status_data", data_service = "sqlite")]
pub struct PaymentStatus {
// @source payment.xml:39
#[teaql(id)]
    id: u64,

// @source payment.xml:39
    name: String,

// @source payment.xml:39
    code: String,

// @source payment.xml:39
    color: String,

// @source payment.xml:39
    display_order: rust_decimal::Decimal,

// @source payment.xml:39
    progress: rust_decimal::Decimal,
#[teaql(version)]
    version: i64,
// @source payment.xml:39
#[teaql(column = "payment_account")]
    payment_account_id: u64,
// @source payment.xml:39
#[teaql(relation(target = "PaymentAccount", local_key = "payment_account_id", foreign_key = "id"))]
    payment_account: Option<crate::PaymentAccount>,
#[teaql(relation(target = "PaymentTransaction", local_key = "id", foreign_key = "payment_status_id", many))]
    payment_transaction_list: SmartList<crate::PaymentTransaction>,
    #[teaql(dynamic)]
    dynamic: BTreeMap<String, teaql_core::Value>,
    #[teaql(skip)]
    root: teaql_runtime::EntityRoot,
    #[teaql(skip)]
    pub __load_state: teaql_core::eval::LoadState,
}

impl PaymentStatus {
    pub fn with_id(id: u64) -> teaql_core::Value {
        teaql_core::Value::U64(id)
    }

    pub(crate) fn runtime_new(root: teaql_runtime::EntityRoot) -> Self {
        Self {
            id: 0_u64,
            name: String::new(),
            code: String::new(),
            color: String::new(),
            display_order: rust_decimal::Decimal::ZERO,
            progress: rust_decimal::Decimal::ZERO,
            version: 0_i64,
            payment_account_id: 0_u64,
            payment_account: None,
            payment_transaction_list: Default::default(),
            dynamic: BTreeMap::new(),
            root,
            __load_state: teaql_core::eval::LoadState::FullyLoaded,
        }
    }

    pub fn entity_key(&self) -> teaql_runtime::EntityKey {
        teaql_runtime::EntityKey::new("PaymentStatus", self.id)
    }

    pub fn attach_root_recursive(&mut self, root: teaql_runtime::EntityRoot) {
        self.root = root.clone();
        if let Some(entity) = &mut self.payment_account {
            entity.attach_root_recursive(root.clone());
        }
        for entity in &mut self.payment_transaction_list {
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

    pub fn code(&self) -> String {
        self.changed_code().and_then(|value| value.try_text().map(|value| value.to_owned())).unwrap_or_else(|| self.code.clone())
    }

    pub fn update_code(&mut self, value: impl Into<teaql_core::Value>) -> &mut Self {
        let value = value.into();
        self.code = value.try_text().map(|value| value.trim().to_owned()).unwrap_or_else(|| self.code.clone());
        self.root.set(self.entity_key(), "code", value);
        self
    }

    pub fn changed_code(&self) -> Option<teaql_core::Value> {
        self.root.get(&self.entity_key(), "code")
    }

    pub fn eval_code(&self) -> teaql_core::eval::EvalResult<String> {
        if !self.is_loaded("code") {
                    teaql_core::eval::EvalResult::NotLoaded { failed_node: "code".to_string(), attempted_path: "code".to_string() }
                } else {
                    teaql_core::eval::EvalResult::Value(self.code())
                }}

    pub fn color(&self) -> String {
        self.changed_color().and_then(|value| value.try_text().map(|value| value.to_owned())).unwrap_or_else(|| self.color.clone())
    }

    pub fn update_color(&mut self, value: impl Into<teaql_core::Value>) -> &mut Self {
        let value = value.into();
        self.color = value.try_text().map(|value| value.trim().to_owned()).unwrap_or_else(|| self.color.clone());
        self.root.set(self.entity_key(), "color", value);
        self
    }

    pub fn changed_color(&self) -> Option<teaql_core::Value> {
        self.root.get(&self.entity_key(), "color")
    }

    pub fn eval_color(&self) -> teaql_core::eval::EvalResult<String> {
        if !self.is_loaded("color") {
                    teaql_core::eval::EvalResult::NotLoaded { failed_node: "color".to_string(), attempted_path: "color".to_string() }
                } else {
                    teaql_core::eval::EvalResult::Value(self.color())
                }}

    pub fn display_order(&self) -> rust_decimal::Decimal {
        self.changed_display_order().and_then(|value| value.try_decimal()).unwrap_or(self.display_order)
    }

    pub fn update_display_order(&mut self, value: impl Into<teaql_core::Value>) -> &mut Self {
        let value = value.into();
        self.display_order = value.try_decimal().unwrap_or(self.display_order.clone());
        self.root.set(self.entity_key(), "display_order", value);
        self
    }

    pub fn changed_display_order(&self) -> Option<teaql_core::Value> {
        self.root.get(&self.entity_key(), "display_order")
    }

    pub fn eval_display_order(&self) -> teaql_core::eval::EvalResult<rust_decimal::Decimal> {
        if !self.is_loaded("display_order") {
                    teaql_core::eval::EvalResult::NotLoaded { failed_node: "display_order".to_string(), attempted_path: "display_order".to_string() }
                } else {
                    teaql_core::eval::EvalResult::Value(self.display_order())
                }}

    pub fn progress(&self) -> rust_decimal::Decimal {
        self.changed_progress().and_then(|value| value.try_decimal()).unwrap_or(self.progress)
    }

    pub fn update_progress(&mut self, value: impl Into<teaql_core::Value>) -> &mut Self {
        let value = value.into();
        self.progress = value.try_decimal().unwrap_or(self.progress.clone());
        self.root.set(self.entity_key(), "progress", value);
        self
    }

    pub fn changed_progress(&self) -> Option<teaql_core::Value> {
        self.root.get(&self.entity_key(), "progress")
    }

    pub fn eval_progress(&self) -> teaql_core::eval::EvalResult<rust_decimal::Decimal> {
        if !self.is_loaded("progress") {
                    teaql_core::eval::EvalResult::NotLoaded { failed_node: "progress".to_string(), attempted_path: "progress".to_string() }
                } else {
                    teaql_core::eval::EvalResult::Value(self.progress())
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
    pub fn payment_transaction_list(&self) -> &SmartList<crate::PaymentTransaction> {
        &self.payment_transaction_list
    }

    pub fn payment_transaction_list_mut(&mut self) -> &mut SmartList<crate::PaymentTransaction> {
        &mut self.payment_transaction_list
    }

    pub fn eval_payment_transaction_list(&self) -> teaql_core::eval::EvalResult<&SmartList<crate::PaymentTransaction>> {
        if !self.is_loaded("payment_transaction_list") {
            teaql_core::eval::EvalResult::NotLoaded { failed_node: "payment_transaction_list".to_string(), attempted_path: "payment_transaction_list".to_string() }
        } else {
            teaql_core::eval::EvalResult::Value(&self.payment_transaction_list)
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

