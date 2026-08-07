
// ⛔ AI agents: DO NOT read this file for API discovery. Instead run: cargo teaql --input modeling/MODEL.xml rust-assist-query/coupon
use std::collections::BTreeMap;

use teaql_macros::TeaqlEntity;

/// [TEAQL AI WARNING]
/// TeaQL was explicitly designed to PREVENT AI hallucinations and random guessing.
/// DO NOT GUESS METHOD NAMES!
/// The methods listed below are the ONLY valid ways to interact with this entity.
/// If you encounter compilation errors (e.g., method not found), DO NOT guess another method name.
/// Read the method signatures in this file before proceeding.
#[derive(Clone, Debug, PartialEq, TeaqlEntity)]
#[teaql(entity = "Coupon", table = "coupon_data", data_service = "sqlite")]
pub struct Coupon {
#[teaql(id)]
    id: u64,

// @source massive_erp_model.xml:291
    code: String,

// @source massive_erp_model.xml:291
    times_used: rust_decimal::Decimal,

// @source massive_erp_model.xml:291
    usage_limit: rust_decimal::Decimal,

// @source massive_erp_model.xml:291
    create_time: teaql_core::time::Timestamp,

// @source massive_erp_model.xml:291
    update_time: teaql_core::time::Timestamp,
#[teaql(version)]
    version: i64,
// @source massive_erp_model.xml:291
#[teaql(column = "promotion")]
    promotion_id: u64,
// @source massive_erp_model.xml:291
#[teaql(relation(target = "Promotion", local_key = "promotion_id", foreign_key = "id"))]
    promotion: Option<crate::Promotion>,
    #[teaql(dynamic)]
    dynamic: BTreeMap<String, teaql_core::Value>,
    #[teaql(skip)]
    root: teaql_runtime::EntityRoot,
    #[teaql(skip)]
    pub __load_state: teaql_core::eval::LoadState,
}

impl Coupon {
    pub fn with_id(id: u64) -> teaql_core::Value {
        teaql_core::Value::U64(id)
    }

    pub(crate) fn runtime_new(root: teaql_runtime::EntityRoot) -> Self {
        Self {
            id: 0_u64,
            code: String::new(),
            times_used: rust_decimal::Decimal::ZERO,
            usage_limit: rust_decimal::Decimal::ZERO,
            create_time: teaql_core::time::Timestamp::now(),
            update_time: teaql_core::time::Timestamp::now(),
            version: 0_i64,
            promotion_id: 0_u64,
            promotion: None,
            dynamic: BTreeMap::new(),
            root,
            __load_state: teaql_core::eval::LoadState::FullyLoaded,
        }
    }

    pub fn entity_key(&self) -> teaql_runtime::EntityKey {
        teaql_runtime::EntityKey::new("Coupon", self.id)
    }

    pub fn attach_root_recursive(&mut self, root: teaql_runtime::EntityRoot) {
        self.root = root.clone();
        if let Some(entity) = &mut self.promotion {
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

    pub fn times_used(&self) -> rust_decimal::Decimal {
        self.changed_times_used().and_then(|value| value.try_decimal()).unwrap_or(self.times_used)
    }

    pub fn update_times_used(&mut self, value: impl Into<teaql_core::Value>) -> &mut Self {
        let value = value.into();
        self.times_used = value.try_decimal().unwrap_or(self.times_used.clone());
        self.root.set(self.entity_key(), "times_used", value);
        self
    }

    pub fn changed_times_used(&self) -> Option<teaql_core::Value> {
        self.root.get(&self.entity_key(), "times_used")
    }

    pub fn eval_times_used(&self) -> teaql_core::eval::EvalResult<rust_decimal::Decimal> {
        if !self.is_loaded("times_used") {
                    teaql_core::eval::EvalResult::NotLoaded { failed_node: "times_used".to_string(), attempted_path: "times_used".to_string() }
                } else {
                    teaql_core::eval::EvalResult::Value(self.times_used())
                }}

    pub fn usage_limit(&self) -> rust_decimal::Decimal {
        self.changed_usage_limit().and_then(|value| value.try_decimal()).unwrap_or(self.usage_limit)
    }

    pub fn update_usage_limit(&mut self, value: impl Into<teaql_core::Value>) -> &mut Self {
        let value = value.into();
        self.usage_limit = value.try_decimal().unwrap_or(self.usage_limit.clone());
        self.root.set(self.entity_key(), "usage_limit", value);
        self
    }

    pub fn changed_usage_limit(&self) -> Option<teaql_core::Value> {
        self.root.get(&self.entity_key(), "usage_limit")
    }

    pub fn eval_usage_limit(&self) -> teaql_core::eval::EvalResult<rust_decimal::Decimal> {
        if !self.is_loaded("usage_limit") {
                    teaql_core::eval::EvalResult::NotLoaded { failed_node: "usage_limit".to_string(), attempted_path: "usage_limit".to_string() }
                } else {
                    teaql_core::eval::EvalResult::Value(self.usage_limit())
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
    pub fn promotion_id(&self) -> u64 {
        self.changed_promotion_id().and_then(|value| value.try_u64()).unwrap_or(self.promotion_id)
    }

    pub fn update_promotion_id(&mut self, value: impl Into<teaql_core::Value>) -> &mut Self {
        let value = value.into();
        self.promotion_id = value.try_u64().unwrap_or(self.promotion_id.clone());
        self.root.set(self.entity_key(), "promotion_id", value);
        self
    }

    pub fn changed_promotion_id(&self) -> Option<teaql_core::Value> {
        self.root.get(&self.entity_key(), "promotion_id")
    }

    pub fn eval_promotion_id(&self) -> teaql_core::eval::EvalResult<u64> {
        if !self.is_loaded("promotion_id") {
                    teaql_core::eval::EvalResult::NotLoaded { failed_node: "promotion_id".to_string(), attempted_path: "promotion_id".to_string() }
                } else {
                    teaql_core::eval::EvalResult::Value(self.promotion_id())
                }}
    pub fn promotion(&self) -> Option<&crate::Promotion> {
        self.promotion.as_ref()
    }

    pub fn eval_promotion(&self) -> teaql_core::eval::EvalResult<&crate::Promotion> {
        if !self.is_loaded("promotion") {
            teaql_core::eval::EvalResult::NotLoaded { failed_node: "promotion".to_string(), attempted_path: "promotion".to_string() }
        } else {
            match &self.promotion {
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

