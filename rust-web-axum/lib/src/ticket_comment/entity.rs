
// ⛔ AI agents: DO NOT read this file for API discovery. Instead run: cargo teaql --input modeling/MODEL.xml rust-assist-query/ticket_comment
use std::collections::BTreeMap;

use teaql_macros::TeaqlEntity;

/// [TEAQL AI WARNING]
/// TeaQL was explicitly designed to PREVENT AI hallucinations and random guessing.
/// DO NOT GUESS METHOD NAMES!
/// The methods listed below are the ONLY valid ways to interact with this entity.
/// If you encounter compilation errors (e.g., method not found), DO NOT guess another method name.
/// Read the method signatures in this file before proceeding.
#[derive(Clone, Debug, PartialEq, TeaqlEntity)]
#[teaql(entity = "TicketComment", table = "ticket_comment_data", data_service = "sqlite")]
pub struct TicketComment {
#[teaql(id)]
    id: u64,

// @source massive_erp_model.xml:481
    author_id: String,

// @source massive_erp_model.xml:481
    comment_text: String,

// @source massive_erp_model.xml:481
    created_at: teaql_core::time::Timestamp,

// @source massive_erp_model.xml:481
    create_time: teaql_core::time::Timestamp,

// @source massive_erp_model.xml:481
    update_time: teaql_core::time::Timestamp,
#[teaql(version)]
    version: i64,
// @source massive_erp_model.xml:481
#[teaql(column = "ticket")]
    ticket_id: u64,
// @source massive_erp_model.xml:481
#[teaql(relation(target = "Ticket", local_key = "ticket_id", foreign_key = "id"))]
    ticket: Option<crate::Ticket>,
    #[teaql(dynamic)]
    dynamic: BTreeMap<String, teaql_core::Value>,
    #[teaql(skip)]
    root: teaql_runtime::EntityRoot,
    #[teaql(skip)]
    pub __load_state: teaql_core::eval::LoadState,
}

impl TicketComment {
    pub fn with_id(id: u64) -> teaql_core::Value {
        teaql_core::Value::U64(id)
    }

    pub(crate) fn runtime_new(root: teaql_runtime::EntityRoot) -> Self {
        Self {
            id: 0_u64,
            author_id: String::new(),
            comment_text: String::new(),
            created_at: teaql_core::time::Timestamp::now(),
            create_time: teaql_core::time::Timestamp::now(),
            update_time: teaql_core::time::Timestamp::now(),
            version: 0_i64,
            ticket_id: 0_u64,
            ticket: None,
            dynamic: BTreeMap::new(),
            root,
            __load_state: teaql_core::eval::LoadState::FullyLoaded,
        }
    }

    pub fn entity_key(&self) -> teaql_runtime::EntityKey {
        teaql_runtime::EntityKey::new("TicketComment", self.id)
    }

    pub fn attach_root_recursive(&mut self, root: teaql_runtime::EntityRoot) {
        self.root = root.clone();
        if let Some(entity) = &mut self.ticket {
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

    pub fn author_id(&self) -> String {
        self.changed_author_id().and_then(|value| value.try_text().map(|value| value.to_owned())).unwrap_or_else(|| self.author_id.clone())
    }

    pub fn update_author_id(&mut self, value: impl Into<teaql_core::Value>) -> &mut Self {
        let value = value.into();
        self.author_id = value.try_text().map(|value| value.trim().to_owned()).unwrap_or_else(|| self.author_id.clone());
        self.root.set(self.entity_key(), "author_id", value);
        self
    }

    pub fn changed_author_id(&self) -> Option<teaql_core::Value> {
        self.root.get(&self.entity_key(), "author_id")
    }

    pub fn eval_author_id(&self) -> teaql_core::eval::EvalResult<String> {
        if !self.is_loaded("author_id") {
                    teaql_core::eval::EvalResult::NotLoaded { failed_node: "author_id".to_string(), attempted_path: "author_id".to_string() }
                } else {
                    teaql_core::eval::EvalResult::Value(self.author_id())
                }}

    pub fn comment_text(&self) -> String {
        self.changed_comment_text().and_then(|value| value.try_text().map(|value| value.to_owned())).unwrap_or_else(|| self.comment_text.clone())
    }

    pub fn update_comment_text(&mut self, value: impl Into<teaql_core::Value>) -> &mut Self {
        let value = value.into();
        self.comment_text = value.try_text().map(|value| value.trim().to_owned()).unwrap_or_else(|| self.comment_text.clone());
        self.root.set(self.entity_key(), "comment_text", value);
        self
    }

    pub fn changed_comment_text(&self) -> Option<teaql_core::Value> {
        self.root.get(&self.entity_key(), "comment_text")
    }

    pub fn eval_comment_text(&self) -> teaql_core::eval::EvalResult<String> {
        if !self.is_loaded("comment_text") {
                    teaql_core::eval::EvalResult::NotLoaded { failed_node: "comment_text".to_string(), attempted_path: "comment_text".to_string() }
                } else {
                    teaql_core::eval::EvalResult::Value(self.comment_text())
                }}

    pub fn created_at(&self) -> teaql_core::time::Timestamp {
        self.changed_created_at().and_then(|value| value.try_timestamp()).unwrap_or(self.created_at)
    }

    pub fn update_created_at(&mut self, value: impl Into<teaql_core::Value>) -> &mut Self {
        let value = value.into();
        self.created_at = value.try_timestamp().unwrap_or(self.created_at.clone());
        self.root.set(self.entity_key(), "created_at", value);
        self
    }

    pub fn changed_created_at(&self) -> Option<teaql_core::Value> {
        self.root.get(&self.entity_key(), "created_at")
    }

    pub fn eval_created_at(&self) -> teaql_core::eval::EvalResult<teaql_core::time::Timestamp> {
        if !self.is_loaded("created_at") {
                    teaql_core::eval::EvalResult::NotLoaded { failed_node: "created_at".to_string(), attempted_path: "created_at".to_string() }
                } else {
                    teaql_core::eval::EvalResult::Value(self.created_at())
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
    pub fn ticket_id(&self) -> u64 {
        self.changed_ticket_id().and_then(|value| value.try_u64()).unwrap_or(self.ticket_id)
    }

    pub fn update_ticket_id(&mut self, value: impl Into<teaql_core::Value>) -> &mut Self {
        let value = value.into();
        self.ticket_id = value.try_u64().unwrap_or(self.ticket_id.clone());
        self.root.set(self.entity_key(), "ticket_id", value);
        self
    }

    pub fn changed_ticket_id(&self) -> Option<teaql_core::Value> {
        self.root.get(&self.entity_key(), "ticket_id")
    }

    pub fn eval_ticket_id(&self) -> teaql_core::eval::EvalResult<u64> {
        if !self.is_loaded("ticket_id") {
                    teaql_core::eval::EvalResult::NotLoaded { failed_node: "ticket_id".to_string(), attempted_path: "ticket_id".to_string() }
                } else {
                    teaql_core::eval::EvalResult::Value(self.ticket_id())
                }}
    pub fn ticket(&self) -> Option<&crate::Ticket> {
        self.ticket.as_ref()
    }

    pub fn eval_ticket(&self) -> teaql_core::eval::EvalResult<&crate::Ticket> {
        if !self.is_loaded("ticket") {
            teaql_core::eval::EvalResult::NotLoaded { failed_node: "ticket".to_string(), attempted_path: "ticket".to_string() }
        } else {
            match &self.ticket {
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

