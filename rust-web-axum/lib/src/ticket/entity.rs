
// ⛔ AI agents: DO NOT read this file for API discovery. Instead run: cargo teaql --input modeling/MODEL.xml rust-assist-query/ticket
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
#[teaql(entity = "Ticket", table = "ticket_data", data_service = "sqlite")]
pub struct Ticket {
#[teaql(id)]
    id: u64,

// @source massive_erp_model.xml:471
    description: String,

// @source massive_erp_model.xml:471
    created_at: teaql_core::time::Timestamp,

// @source massive_erp_model.xml:471
    priority: String,

// @source massive_erp_model.xml:471
    status: String,

// @source massive_erp_model.xml:471
    subject: String,

// @source massive_erp_model.xml:471
    create_time: teaql_core::time::Timestamp,

// @source massive_erp_model.xml:471
    update_time: teaql_core::time::Timestamp,
#[teaql(version)]
    version: i64,
// @source massive_erp_model.xml:471
#[teaql(column = "customer")]
    customer_id: u64,
// @source massive_erp_model.xml:471
#[teaql(relation(target = "Customer", local_key = "customer_id", foreign_key = "id"))]
    customer: Option<crate::Customer>,
#[teaql(relation(target = "TicketComment", local_key = "id", foreign_key = "ticket_id", many))]
    ticket_comment_list: SmartList<crate::TicketComment>,
    #[teaql(dynamic)]
    dynamic: BTreeMap<String, teaql_core::Value>,
    #[teaql(skip)]
    root: teaql_runtime::EntityRoot,
    #[teaql(skip)]
    pub __load_state: teaql_core::eval::LoadState,
}

impl Ticket {
    pub fn with_id(id: u64) -> teaql_core::Value {
        teaql_core::Value::U64(id)
    }

    pub(crate) fn runtime_new(root: teaql_runtime::EntityRoot) -> Self {
        Self {
            id: 0_u64,
            description: String::new(),
            created_at: teaql_core::time::Timestamp::now(),
            priority: String::new(),
            status: String::new(),
            subject: String::new(),
            create_time: teaql_core::time::Timestamp::now(),
            update_time: teaql_core::time::Timestamp::now(),
            version: 0_i64,
            customer_id: 0_u64,
            customer: None,
            ticket_comment_list: Default::default(),
            dynamic: BTreeMap::new(),
            root,
            __load_state: teaql_core::eval::LoadState::FullyLoaded,
        }
    }

    pub fn entity_key(&self) -> teaql_runtime::EntityKey {
        teaql_runtime::EntityKey::new("Ticket", self.id)
    }

    pub fn attach_root_recursive(&mut self, root: teaql_runtime::EntityRoot) {
        self.root = root.clone();
        if let Some(entity) = &mut self.customer {
            entity.attach_root_recursive(root.clone());
        }
        for entity in &mut self.ticket_comment_list {
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

    pub fn description(&self) -> String {
        self.changed_description().and_then(|value| value.try_text().map(|value| value.to_owned())).unwrap_or_else(|| self.description.clone())
    }

    pub fn update_description(&mut self, value: impl Into<teaql_core::Value>) -> &mut Self {
        let value = value.into();
        self.description = value.try_text().map(|value| value.trim().to_owned()).unwrap_or_else(|| self.description.clone());
        self.root.set(self.entity_key(), "description", value);
        self
    }

    pub fn changed_description(&self) -> Option<teaql_core::Value> {
        self.root.get(&self.entity_key(), "description")
    }

    pub fn eval_description(&self) -> teaql_core::eval::EvalResult<String> {
        if !self.is_loaded("description") {
                    teaql_core::eval::EvalResult::NotLoaded { failed_node: "description".to_string(), attempted_path: "description".to_string() }
                } else {
                    teaql_core::eval::EvalResult::Value(self.description())
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

    pub fn priority(&self) -> String {
        self.changed_priority().and_then(|value| value.try_text().map(|value| value.to_owned())).unwrap_or_else(|| self.priority.clone())
    }

    pub fn update_priority(&mut self, value: impl Into<teaql_core::Value>) -> &mut Self {
        let value = value.into();
        self.priority = value.try_text().map(|value| value.trim().to_owned()).unwrap_or_else(|| self.priority.clone());
        self.root.set(self.entity_key(), "priority", value);
        self
    }

    pub fn changed_priority(&self) -> Option<teaql_core::Value> {
        self.root.get(&self.entity_key(), "priority")
    }

    pub fn eval_priority(&self) -> teaql_core::eval::EvalResult<String> {
        if !self.is_loaded("priority") {
                    teaql_core::eval::EvalResult::NotLoaded { failed_node: "priority".to_string(), attempted_path: "priority".to_string() }
                } else {
                    teaql_core::eval::EvalResult::Value(self.priority())
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

    pub fn subject(&self) -> String {
        self.changed_subject().and_then(|value| value.try_text().map(|value| value.to_owned())).unwrap_or_else(|| self.subject.clone())
    }

    pub fn update_subject(&mut self, value: impl Into<teaql_core::Value>) -> &mut Self {
        let value = value.into();
        self.subject = value.try_text().map(|value| value.trim().to_owned()).unwrap_or_else(|| self.subject.clone());
        self.root.set(self.entity_key(), "subject", value);
        self
    }

    pub fn changed_subject(&self) -> Option<teaql_core::Value> {
        self.root.get(&self.entity_key(), "subject")
    }

    pub fn eval_subject(&self) -> teaql_core::eval::EvalResult<String> {
        if !self.is_loaded("subject") {
                    teaql_core::eval::EvalResult::NotLoaded { failed_node: "subject".to_string(), attempted_path: "subject".to_string() }
                } else {
                    teaql_core::eval::EvalResult::Value(self.subject())
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
    pub fn ticket_comment_list(&self) -> &SmartList<crate::TicketComment> {
        &self.ticket_comment_list
    }

    pub fn ticket_comment_list_mut(&mut self) -> &mut SmartList<crate::TicketComment> {
        &mut self.ticket_comment_list
    }

    pub fn eval_ticket_comment_list(&self) -> teaql_core::eval::EvalResult<&SmartList<crate::TicketComment>> {
        if !self.is_loaded("ticket_comment_list") {
            teaql_core::eval::EvalResult::NotLoaded { failed_node: "ticket_comment_list".to_string(), attempted_path: "ticket_comment_list".to_string() }
        } else {
            teaql_core::eval::EvalResult::Value(&self.ticket_comment_list)
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

