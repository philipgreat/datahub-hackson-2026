
// ⛔ AI agents: DO NOT read this file for API discovery. Instead run: cargo teaql --input modeling/MODEL.xml rust-assist-query/customer
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
#[teaql(entity = "Customer", table = "customer_data", data_service = "sqlite")]
pub struct Customer {
#[teaql(id)]
    id: u64,

// @source massive_erp_model.xml:104
    address: String,

// @source massive_erp_model.xml:104
    email: String,

// @source massive_erp_model.xml:104
    name: String,

// @source massive_erp_model.xml:104
    phone: String,

// @source massive_erp_model.xml:104
    created_at: teaql_core::time::Timestamp,

// @source massive_erp_model.xml:104
    loyalty_points: rust_decimal::Decimal,

// @source massive_erp_model.xml:104
    create_time: teaql_core::time::Timestamp,

// @source massive_erp_model.xml:104
    update_time: teaql_core::time::Timestamp,
#[teaql(version)]
    version: i64,
    #[teaql(boxed_relations)]
    pub _relations: Box<CustomerReverseRelations>,
    #[teaql(dynamic)]
    dynamic: BTreeMap<String, teaql_core::Value>,
    #[teaql(skip)]
    root: teaql_runtime::EntityRoot,
    #[teaql(skip)]
    pub __load_state: teaql_core::eval::LoadState,
}

impl Customer {
    pub fn with_id(id: u64) -> teaql_core::Value {
        teaql_core::Value::U64(id)
    }

    pub(crate) fn runtime_new(root: teaql_runtime::EntityRoot) -> Self {
        Self {
            id: 0_u64,
            address: String::new(),
            email: String::new(),
            name: String::new(),
            phone: String::new(),
            created_at: teaql_core::time::Timestamp::now(),
            loyalty_points: rust_decimal::Decimal::ZERO,
            create_time: teaql_core::time::Timestamp::now(),
            update_time: teaql_core::time::Timestamp::now(),
            version: 0_i64,
            _relations: Box::new(CustomerReverseRelations::new()),
            dynamic: BTreeMap::new(),
            root,
            __load_state: teaql_core::eval::LoadState::FullyLoaded,
        }
    }

    pub fn entity_key(&self) -> teaql_runtime::EntityKey {
        teaql_runtime::EntityKey::new("Customer", self.id)
    }

    pub fn attach_root_recursive(&mut self, root: teaql_runtime::EntityRoot) {
        self.root = root.clone();
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

    pub fn address(&self) -> String {
        self.changed_address().and_then(|value| value.try_text().map(|value| value.to_owned())).unwrap_or_else(|| self.address.clone())
    }

    pub fn update_address(&mut self, value: impl Into<teaql_core::Value>) -> &mut Self {
        let value = value.into();
        self.address = value.try_text().map(|value| value.trim().to_owned()).unwrap_or_else(|| self.address.clone());
        self.root.set(self.entity_key(), "address", value);
        self
    }

    pub fn changed_address(&self) -> Option<teaql_core::Value> {
        self.root.get(&self.entity_key(), "address")
    }

    pub fn eval_address(&self) -> teaql_core::eval::EvalResult<String> {
        if !self.is_loaded("address") {
                    teaql_core::eval::EvalResult::NotLoaded { failed_node: "address".to_string(), attempted_path: "address".to_string() }
                } else {
                    teaql_core::eval::EvalResult::Value(self.address())
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

    pub fn loyalty_points(&self) -> rust_decimal::Decimal {
        self.changed_loyalty_points().and_then(|value| value.try_decimal()).unwrap_or(self.loyalty_points)
    }

    pub fn update_loyalty_points(&mut self, value: impl Into<teaql_core::Value>) -> &mut Self {
        let value = value.into();
        self.loyalty_points = value.try_decimal().unwrap_or(self.loyalty_points.clone());
        self.root.set(self.entity_key(), "loyalty_points", value);
        self
    }

    pub fn changed_loyalty_points(&self) -> Option<teaql_core::Value> {
        self.root.get(&self.entity_key(), "loyalty_points")
    }

    pub fn eval_loyalty_points(&self) -> teaql_core::eval::EvalResult<rust_decimal::Decimal> {
        if !self.is_loaded("loyalty_points") {
                    teaql_core::eval::EvalResult::NotLoaded { failed_node: "loyalty_points".to_string(), attempted_path: "loyalty_points".to_string() }
                } else {
                    teaql_core::eval::EvalResult::Value(self.loyalty_points())
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
    pub fn contact_list(&self) -> &SmartList<crate::Contact> {
        &self._relations.contact_list
    }

    pub fn contact_list_mut(&mut self) -> &mut SmartList<crate::Contact> {
        &mut self._relations.contact_list
    }

    pub fn eval_contact_list(&self) -> teaql_core::eval::EvalResult<&SmartList<crate::Contact>> {
        if !self.is_loaded("contact_list") {
            teaql_core::eval::EvalResult::NotLoaded { failed_node: "contact_list".to_string(), attempted_path: "contact_list".to_string() }
        } else {
            teaql_core::eval::EvalResult::Value(&self._relations.contact_list)
        }
    }

    pub fn contract_list(&self) -> &SmartList<crate::Contract> {
        &self._relations.contract_list
    }

    pub fn contract_list_mut(&mut self) -> &mut SmartList<crate::Contract> {
        &mut self._relations.contract_list
    }

    pub fn eval_contract_list(&self) -> teaql_core::eval::EvalResult<&SmartList<crate::Contract>> {
        if !self.is_loaded("contract_list") {
            teaql_core::eval::EvalResult::NotLoaded { failed_node: "contract_list".to_string(), attempted_path: "contract_list".to_string() }
        } else {
            teaql_core::eval::EvalResult::Value(&self._relations.contract_list)
        }
    }

    pub fn product_review_list(&self) -> &SmartList<crate::ProductReview> {
        &self._relations.product_review_list
    }

    pub fn product_review_list_mut(&mut self) -> &mut SmartList<crate::ProductReview> {
        &mut self._relations.product_review_list
    }

    pub fn eval_product_review_list(&self) -> teaql_core::eval::EvalResult<&SmartList<crate::ProductReview>> {
        if !self.is_loaded("product_review_list") {
            teaql_core::eval::EvalResult::NotLoaded { failed_node: "product_review_list".to_string(), attempted_path: "product_review_list".to_string() }
        } else {
            teaql_core::eval::EvalResult::Value(&self._relations.product_review_list)
        }
    }

    pub fn shopping_cart_list(&self) -> &SmartList<crate::ShoppingCart> {
        &self._relations.shopping_cart_list
    }

    pub fn shopping_cart_list_mut(&mut self) -> &mut SmartList<crate::ShoppingCart> {
        &mut self._relations.shopping_cart_list
    }

    pub fn eval_shopping_cart_list(&self) -> teaql_core::eval::EvalResult<&SmartList<crate::ShoppingCart>> {
        if !self.is_loaded("shopping_cart_list") {
            teaql_core::eval::EvalResult::NotLoaded { failed_node: "shopping_cart_list".to_string(), attempted_path: "shopping_cart_list".to_string() }
        } else {
            teaql_core::eval::EvalResult::Value(&self._relations.shopping_cart_list)
        }
    }

    pub fn global_order_list(&self) -> &SmartList<crate::GlobalOrder> {
        &self._relations.global_order_list
    }

    pub fn global_order_list_mut(&mut self) -> &mut SmartList<crate::GlobalOrder> {
        &mut self._relations.global_order_list
    }

    pub fn eval_global_order_list(&self) -> teaql_core::eval::EvalResult<&SmartList<crate::GlobalOrder>> {
        if !self.is_loaded("global_order_list") {
            teaql_core::eval::EvalResult::NotLoaded { failed_node: "global_order_list".to_string(), attempted_path: "global_order_list".to_string() }
        } else {
            teaql_core::eval::EvalResult::Value(&self._relations.global_order_list)
        }
    }

    pub fn wishlist_list(&self) -> &SmartList<crate::Wishlist> {
        &self._relations.wishlist_list
    }

    pub fn wishlist_list_mut(&mut self) -> &mut SmartList<crate::Wishlist> {
        &mut self._relations.wishlist_list
    }

    pub fn eval_wishlist_list(&self) -> teaql_core::eval::EvalResult<&SmartList<crate::Wishlist>> {
        if !self.is_loaded("wishlist_list") {
            teaql_core::eval::EvalResult::NotLoaded { failed_node: "wishlist_list".to_string(), attempted_path: "wishlist_list".to_string() }
        } else {
            teaql_core::eval::EvalResult::Value(&self._relations.wishlist_list)
        }
    }

    pub fn invoice_list(&self) -> &SmartList<crate::Invoice> {
        &self._relations.invoice_list
    }

    pub fn invoice_list_mut(&mut self) -> &mut SmartList<crate::Invoice> {
        &mut self._relations.invoice_list
    }

    pub fn eval_invoice_list(&self) -> teaql_core::eval::EvalResult<&SmartList<crate::Invoice>> {
        if !self.is_loaded("invoice_list") {
            teaql_core::eval::EvalResult::NotLoaded { failed_node: "invoice_list".to_string(), attempted_path: "invoice_list".to_string() }
        } else {
            teaql_core::eval::EvalResult::Value(&self._relations.invoice_list)
        }
    }

    pub fn return_request_list(&self) -> &SmartList<crate::ReturnRequest> {
        &self._relations.return_request_list
    }

    pub fn return_request_list_mut(&mut self) -> &mut SmartList<crate::ReturnRequest> {
        &mut self._relations.return_request_list
    }

    pub fn eval_return_request_list(&self) -> teaql_core::eval::EvalResult<&SmartList<crate::ReturnRequest>> {
        if !self.is_loaded("return_request_list") {
            teaql_core::eval::EvalResult::NotLoaded { failed_node: "return_request_list".to_string(), attempted_path: "return_request_list".to_string() }
        } else {
            teaql_core::eval::EvalResult::Value(&self._relations.return_request_list)
        }
    }

    pub fn ticket_list(&self) -> &SmartList<crate::Ticket> {
        &self._relations.ticket_list
    }

    pub fn ticket_list_mut(&mut self) -> &mut SmartList<crate::Ticket> {
        &mut self._relations.ticket_list
    }

    pub fn eval_ticket_list(&self) -> teaql_core::eval::EvalResult<&SmartList<crate::Ticket>> {
        if !self.is_loaded("ticket_list") {
            teaql_core::eval::EvalResult::NotLoaded { failed_node: "ticket_list".to_string(), attempted_path: "ticket_list".to_string() }
        } else {
            teaql_core::eval::EvalResult::Value(&self._relations.ticket_list)
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
pub struct CustomerReverseRelations {
#[teaql(relation(target = "Contact", local_key = "id", foreign_key = "customer_id", many))]
    contact_list: SmartList<crate::Contact>,
#[teaql(relation(target = "Contract", local_key = "id", foreign_key = "customer_id", many))]
    contract_list: SmartList<crate::Contract>,
#[teaql(relation(target = "ProductReview", local_key = "id", foreign_key = "customer_id", many))]
    product_review_list: SmartList<crate::ProductReview>,
#[teaql(relation(target = "ShoppingCart", local_key = "id", foreign_key = "customer_id", many))]
    shopping_cart_list: SmartList<crate::ShoppingCart>,
#[teaql(relation(target = "GlobalOrder", local_key = "id", foreign_key = "customer_id", many))]
    global_order_list: SmartList<crate::GlobalOrder>,
#[teaql(relation(target = "Wishlist", local_key = "id", foreign_key = "customer_id", many))]
    wishlist_list: SmartList<crate::Wishlist>,
#[teaql(relation(target = "Invoice", local_key = "id", foreign_key = "customer_id", many))]
    invoice_list: SmartList<crate::Invoice>,
#[teaql(relation(target = "ReturnRequest", local_key = "id", foreign_key = "customer_id", many))]
    return_request_list: SmartList<crate::ReturnRequest>,
#[teaql(relation(target = "Ticket", local_key = "id", foreign_key = "customer_id", many))]
    ticket_list: SmartList<crate::Ticket>,
}

impl CustomerReverseRelations {
    pub fn new() -> Self {
        Self {
            contact_list: Default::default(),
            contract_list: Default::default(),
            product_review_list: Default::default(),
            shopping_cart_list: Default::default(),
            global_order_list: Default::default(),
            wishlist_list: Default::default(),
            invoice_list: Default::default(),
            return_request_list: Default::default(),
            ticket_list: Default::default(),
        }
    }

    pub fn attach_root_recursive(&mut self, root: teaql_runtime::EntityRoot) {
        for entity in &mut self.contact_list {
            entity.attach_root_recursive(root.clone());
        }
        for entity in &mut self.contract_list {
            entity.attach_root_recursive(root.clone());
        }
        for entity in &mut self.product_review_list {
            entity.attach_root_recursive(root.clone());
        }
        for entity in &mut self.shopping_cart_list {
            entity.attach_root_recursive(root.clone());
        }
        for entity in &mut self.global_order_list {
            entity.attach_root_recursive(root.clone());
        }
        for entity in &mut self.wishlist_list {
            entity.attach_root_recursive(root.clone());
        }
        for entity in &mut self.invoice_list {
            entity.attach_root_recursive(root.clone());
        }
        for entity in &mut self.return_request_list {
            entity.attach_root_recursive(root.clone());
        }
        for entity in &mut self.ticket_list {
            entity.attach_root_recursive(root.clone());
        }
    }
}
