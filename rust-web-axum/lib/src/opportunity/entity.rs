
// ⛔ AI agents: DO NOT read this file for API discovery. Instead run: cargo teaql --input modeling/MODEL.xml rust-assist-query/opportunity
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
#[teaql(entity = "Opportunity", table = "opportunity_data", data_service = "sqlite")]
pub struct Opportunity {
#[teaql(id)]
    id: u64,

// @source massive_erp_model.xml:127
    close_date: teaql_core::time::Timestamp,

// @source massive_erp_model.xml:127
    expected_revenue: rust_decimal::Decimal,

// @source massive_erp_model.xml:127
    probability: rust_decimal::Decimal,

// @source massive_erp_model.xml:127
    status: String,

// @source massive_erp_model.xml:127
    create_time: teaql_core::time::Timestamp,

// @source massive_erp_model.xml:127
    update_time: teaql_core::time::Timestamp,
#[teaql(version)]
    version: i64,
// @source massive_erp_model.xml:127
#[teaql(column = "lead")]
    lead_id: u64,
// @source massive_erp_model.xml:127
#[teaql(relation(target = "Lead", local_key = "lead_id", foreign_key = "id"))]
    lead: Option<crate::Lead>,
#[teaql(relation(target = "Quote", local_key = "id", foreign_key = "opportunity_id", many))]
    quote_list: SmartList<crate::Quote>,
    #[teaql(dynamic)]
    dynamic: BTreeMap<String, teaql_core::Value>,
    #[teaql(skip)]
    root: teaql_runtime::EntityRoot,
    #[teaql(skip)]
    pub __load_state: teaql_core::eval::LoadState,
}

impl Opportunity {
    pub fn with_id(id: u64) -> teaql_core::Value {
        teaql_core::Value::U64(id)
    }

    pub(crate) fn runtime_new(root: teaql_runtime::EntityRoot) -> Self {
        Self {
            id: 0_u64,
            close_date: teaql_core::time::Timestamp::now(),
            expected_revenue: rust_decimal::Decimal::ZERO,
            probability: rust_decimal::Decimal::ZERO,
            status: String::new(),
            create_time: teaql_core::time::Timestamp::now(),
            update_time: teaql_core::time::Timestamp::now(),
            version: 0_i64,
            lead_id: 0_u64,
            lead: None,
            quote_list: Default::default(),
            dynamic: BTreeMap::new(),
            root,
            __load_state: teaql_core::eval::LoadState::FullyLoaded,
        }
    }

    pub fn entity_key(&self) -> teaql_runtime::EntityKey {
        teaql_runtime::EntityKey::new("Opportunity", self.id)
    }

    pub fn attach_root_recursive(&mut self, root: teaql_runtime::EntityRoot) {
        self.root = root.clone();
        if let Some(entity) = &mut self.lead {
            entity.attach_root_recursive(root.clone());
        }
        for entity in &mut self.quote_list {
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

    pub fn close_date(&self) -> teaql_core::time::Timestamp {
        self.changed_close_date().and_then(|value| value.try_timestamp()).unwrap_or(self.close_date)
    }

    pub fn update_close_date(&mut self, value: impl Into<teaql_core::Value>) -> &mut Self {
        let value = value.into();
        self.close_date = value.try_timestamp().unwrap_or(self.close_date.clone());
        self.root.set(self.entity_key(), "close_date", value);
        self
    }

    pub fn changed_close_date(&self) -> Option<teaql_core::Value> {
        self.root.get(&self.entity_key(), "close_date")
    }

    pub fn eval_close_date(&self) -> teaql_core::eval::EvalResult<teaql_core::time::Timestamp> {
        if !self.is_loaded("close_date") {
                    teaql_core::eval::EvalResult::NotLoaded { failed_node: "close_date".to_string(), attempted_path: "close_date".to_string() }
                } else {
                    teaql_core::eval::EvalResult::Value(self.close_date())
                }}

    pub fn expected_revenue(&self) -> rust_decimal::Decimal {
        self.changed_expected_revenue().and_then(|value| value.try_decimal()).unwrap_or(self.expected_revenue)
    }

    pub fn update_expected_revenue(&mut self, value: impl Into<teaql_core::Value>) -> &mut Self {
        let value = value.into();
        self.expected_revenue = value.try_decimal().unwrap_or(self.expected_revenue.clone());
        self.root.set(self.entity_key(), "expected_revenue", value);
        self
    }

    pub fn changed_expected_revenue(&self) -> Option<teaql_core::Value> {
        self.root.get(&self.entity_key(), "expected_revenue")
    }

    pub fn eval_expected_revenue(&self) -> teaql_core::eval::EvalResult<rust_decimal::Decimal> {
        if !self.is_loaded("expected_revenue") {
                    teaql_core::eval::EvalResult::NotLoaded { failed_node: "expected_revenue".to_string(), attempted_path: "expected_revenue".to_string() }
                } else {
                    teaql_core::eval::EvalResult::Value(self.expected_revenue())
                }}

    pub fn probability(&self) -> rust_decimal::Decimal {
        self.changed_probability().and_then(|value| value.try_decimal()).unwrap_or(self.probability)
    }

    pub fn update_probability(&mut self, value: impl Into<teaql_core::Value>) -> &mut Self {
        let value = value.into();
        self.probability = value.try_decimal().unwrap_or(self.probability.clone());
        self.root.set(self.entity_key(), "probability", value);
        self
    }

    pub fn changed_probability(&self) -> Option<teaql_core::Value> {
        self.root.get(&self.entity_key(), "probability")
    }

    pub fn eval_probability(&self) -> teaql_core::eval::EvalResult<rust_decimal::Decimal> {
        if !self.is_loaded("probability") {
                    teaql_core::eval::EvalResult::NotLoaded { failed_node: "probability".to_string(), attempted_path: "probability".to_string() }
                } else {
                    teaql_core::eval::EvalResult::Value(self.probability())
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
    pub fn lead_id(&self) -> u64 {
        self.changed_lead_id().and_then(|value| value.try_u64()).unwrap_or(self.lead_id)
    }

    pub fn update_lead_id(&mut self, value: impl Into<teaql_core::Value>) -> &mut Self {
        let value = value.into();
        self.lead_id = value.try_u64().unwrap_or(self.lead_id.clone());
        self.root.set(self.entity_key(), "lead_id", value);
        self
    }

    pub fn changed_lead_id(&self) -> Option<teaql_core::Value> {
        self.root.get(&self.entity_key(), "lead_id")
    }

    pub fn eval_lead_id(&self) -> teaql_core::eval::EvalResult<u64> {
        if !self.is_loaded("lead_id") {
                    teaql_core::eval::EvalResult::NotLoaded { failed_node: "lead_id".to_string(), attempted_path: "lead_id".to_string() }
                } else {
                    teaql_core::eval::EvalResult::Value(self.lead_id())
                }}
    pub fn lead(&self) -> Option<&crate::Lead> {
        self.lead.as_ref()
    }

    pub fn eval_lead(&self) -> teaql_core::eval::EvalResult<&crate::Lead> {
        if !self.is_loaded("lead") {
            teaql_core::eval::EvalResult::NotLoaded { failed_node: "lead".to_string(), attempted_path: "lead".to_string() }
        } else {
            match &self.lead {
                Some(v) => teaql_core::eval::EvalResult::Value(v),
                None => teaql_core::eval::EvalResult::Null,
            }
        }
    }
    pub fn quote_list(&self) -> &SmartList<crate::Quote> {
        &self.quote_list
    }

    pub fn quote_list_mut(&mut self) -> &mut SmartList<crate::Quote> {
        &mut self.quote_list
    }

    pub fn eval_quote_list(&self) -> teaql_core::eval::EvalResult<&SmartList<crate::Quote>> {
        if !self.is_loaded("quote_list") {
            teaql_core::eval::EvalResult::NotLoaded { failed_node: "quote_list".to_string(), attempted_path: "quote_list".to_string() }
        } else {
            teaql_core::eval::EvalResult::Value(&self.quote_list)
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

