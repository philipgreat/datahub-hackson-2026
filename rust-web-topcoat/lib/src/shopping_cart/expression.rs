#[derive(Clone)]
pub struct ShoppingCartExpression<'a> {
    result: teaql_core::eval::EvalResult<&'a crate::ShoppingCart>,
    root_desc: std::sync::Arc<String>,
}

impl<'a> ShoppingCartExpression<'a> {
    pub fn new(result: teaql_core::eval::EvalResult<&'a crate::ShoppingCart>, root_desc: std::sync::Arc<String>) -> Self {
        Self { result, root_desc }
    }

    fn resolve(&self) -> Option<&'a crate::ShoppingCart> {
        match &self.result {
            teaql_core::eval::EvalResult::Value(v) => Some(*v),
            teaql_core::eval::EvalResult::Null => None,
            teaql_core::eval::EvalResult::NotLoaded { failed_node, attempted_path } => {
                crate::trigger_logic_bug_panic(&self.root_desc, &failed_node, &attempted_path)
            }
        }
    }

    pub fn eval(&self) -> Option<&'a crate::ShoppingCart> {
        self.resolve()
    }

    pub fn unwrap(&self) -> &'a crate::ShoppingCart {
        self.resolve().expect("Relation was legitimately null in database!")
    }

    pub fn get_id(self) -> crate::ValueExpression<'a, u64> {
        let next = self.result.and_then("id", |entity| entity.eval_id());
        crate::ValueExpression::new(next, self.root_desc.clone())
    }

    pub fn get_created_at(self) -> crate::ValueExpression<'a, teaql_core::time::Timestamp> {
        let next = self.result.and_then("created_at", |entity| entity.eval_created_at());
        crate::ValueExpression::new(next, self.root_desc.clone())
    }

    pub fn get_is_abandoned(self) -> crate::ValueExpression<'a, bool> {
        let next = self.result.and_then("is_abandoned", |entity| entity.eval_is_abandoned());
        crate::ValueExpression::new(next, self.root_desc.clone())
    }

    pub fn get_session_id(self) -> crate::ValueExpression<'a, String> {
        let next = self.result.and_then("session_id", |entity| entity.eval_session_id());
        crate::ValueExpression::new(next, self.root_desc.clone())
    }

    pub fn get_create_time(self) -> crate::ValueExpression<'a, teaql_core::time::Timestamp> {
        let next = self.result.and_then("create_time", |entity| entity.eval_create_time());
        crate::ValueExpression::new(next, self.root_desc.clone())
    }

    pub fn get_update_time(self) -> crate::ValueExpression<'a, teaql_core::time::Timestamp> {
        let next = self.result.and_then("update_time", |entity| entity.eval_update_time());
        crate::ValueExpression::new(next, self.root_desc.clone())
    }

    pub fn get_version(self) -> crate::ValueExpression<'a, i64> {
        let next = self.result.and_then("version", |entity| entity.eval_version());
        crate::ValueExpression::new(next, self.root_desc.clone())
    }
    pub fn get_customer_id(self) -> crate::ValueExpression<'a, u64> {
        let next = self.result.and_then("customer_id", |entity| entity.eval_customer_id());
        crate::ValueExpression::new(next, self.root_desc.clone())
    }
    pub fn get_customer(self) -> crate::CustomerExpression<'a> {
        let next = self.result.and_then("customer", |entity| entity.eval_customer());
        crate::CustomerExpression::new(next, self.root_desc.clone())
    }
    pub fn get_cart_item_list(self) -> crate::CartItemListExpression<'a> {
        let next = self.result.and_then("cart_item_list", |entity| entity.eval_cart_item_list());
        crate::CartItemListExpression::new(next, self.root_desc.clone())
    }
}

#[derive(Clone)]
pub struct ShoppingCartListExpression<'a> {
    result: teaql_core::eval::EvalResult<&'a teaql_core::SmartList<crate::ShoppingCart>>,
    root_desc: std::sync::Arc<String>,
}

impl<'a> ShoppingCartListExpression<'a> {
    pub fn new(result: teaql_core::eval::EvalResult<&'a teaql_core::SmartList<crate::ShoppingCart>>, root_desc: std::sync::Arc<String>) -> Self {
        Self { result, root_desc }
    }

    fn resolve(&self) -> Option<&'a teaql_core::SmartList<crate::ShoppingCart>> {
        match &self.result {
            teaql_core::eval::EvalResult::Value(v) => Some(*v),
            teaql_core::eval::EvalResult::Null => None,
            teaql_core::eval::EvalResult::NotLoaded { failed_node, attempted_path } => {
                crate::trigger_logic_bug_panic(&self.root_desc, &failed_node, &attempted_path)
            }
        }
    }

    pub fn eval(&self) -> Option<&'a teaql_core::SmartList<crate::ShoppingCart>> {
        self.resolve()
    }

    pub fn unwrap(&self) -> &'a teaql_core::SmartList<crate::ShoppingCart> {
        self.resolve().expect("List relation was legitimately null in database!")
    }

    pub fn size(&self) -> crate::ValueExpression<'a, usize> {
        let next = self.result.clone().and_then("size", |list| teaql_core::eval::EvalResult::Value(list.len()));
        crate::ValueExpression::new(next, self.root_desc.clone())
    }

    pub fn first(&self) -> crate::ShoppingCartExpression<'a> {
        let next = self.result.clone().and_then("first", |list| {
            if let Some(item) = list.first() {
                teaql_core::eval::EvalResult::Value(item)
            } else {
                teaql_core::eval::EvalResult::Null
            }
        });
        crate::ShoppingCartExpression::new(next, self.root_desc.clone())
    }

    pub fn get(&self, index: usize) -> crate::ShoppingCartExpression<'a> {
        let next = self.result.clone().and_then("get", |list| {
            if let Some(item) = list.get(index) {
                teaql_core::eval::EvalResult::Value(item)
            } else {
                teaql_core::eval::EvalResult::Null
            }
        });
        crate::ShoppingCartExpression::new(next, self.root_desc.clone())
    }
}