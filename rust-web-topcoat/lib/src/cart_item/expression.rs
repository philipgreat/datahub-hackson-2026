#[derive(Clone)]
pub struct CartItemExpression<'a> {
    result: teaql_core::eval::EvalResult<&'a crate::CartItem>,
    root_desc: std::sync::Arc<String>,
}

impl<'a> CartItemExpression<'a> {
    pub fn new(result: teaql_core::eval::EvalResult<&'a crate::CartItem>, root_desc: std::sync::Arc<String>) -> Self {
        Self { result, root_desc }
    }

    fn resolve(&self) -> Option<&'a crate::CartItem> {
        match &self.result {
            teaql_core::eval::EvalResult::Value(v) => Some(*v),
            teaql_core::eval::EvalResult::Null => None,
            teaql_core::eval::EvalResult::NotLoaded { failed_node, attempted_path } => {
                crate::trigger_logic_bug_panic(&self.root_desc, &failed_node, &attempted_path)
            }
        }
    }

    pub fn eval(&self) -> Option<&'a crate::CartItem> {
        self.resolve()
    }

    pub fn unwrap(&self) -> &'a crate::CartItem {
        self.resolve().expect("Relation was legitimately null in database!")
    }

    pub fn get_id(self) -> crate::ValueExpression<'a, u64> {
        let next = self.result.and_then("id", |entity| entity.eval_id());
        crate::ValueExpression::new(next, self.root_desc.clone())
    }

    pub fn get_quantity(self) -> crate::ValueExpression<'a, rust_decimal::Decimal> {
        let next = self.result.and_then("quantity", |entity| entity.eval_quantity());
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
    pub fn get_product_id(self) -> crate::ValueExpression<'a, u64> {
        let next = self.result.and_then("product_id", |entity| entity.eval_product_id());
        crate::ValueExpression::new(next, self.root_desc.clone())
    }

    pub fn get_shopping_cart_id(self) -> crate::ValueExpression<'a, u64> {
        let next = self.result.and_then("shopping_cart_id", |entity| entity.eval_shopping_cart_id());
        crate::ValueExpression::new(next, self.root_desc.clone())
    }
    pub fn get_product(self) -> crate::ProductExpression<'a> {
        let next = self.result.and_then("product", |entity| entity.eval_product());
        crate::ProductExpression::new(next, self.root_desc.clone())
    }

    pub fn get_shopping_cart(self) -> crate::ShoppingCartExpression<'a> {
        let next = self.result.and_then("shopping_cart", |entity| entity.eval_shopping_cart());
        crate::ShoppingCartExpression::new(next, self.root_desc.clone())
    }
}

#[derive(Clone)]
pub struct CartItemListExpression<'a> {
    result: teaql_core::eval::EvalResult<&'a teaql_core::SmartList<crate::CartItem>>,
    root_desc: std::sync::Arc<String>,
}

impl<'a> CartItemListExpression<'a> {
    pub fn new(result: teaql_core::eval::EvalResult<&'a teaql_core::SmartList<crate::CartItem>>, root_desc: std::sync::Arc<String>) -> Self {
        Self { result, root_desc }
    }

    fn resolve(&self) -> Option<&'a teaql_core::SmartList<crate::CartItem>> {
        match &self.result {
            teaql_core::eval::EvalResult::Value(v) => Some(*v),
            teaql_core::eval::EvalResult::Null => None,
            teaql_core::eval::EvalResult::NotLoaded { failed_node, attempted_path } => {
                crate::trigger_logic_bug_panic(&self.root_desc, &failed_node, &attempted_path)
            }
        }
    }

    pub fn eval(&self) -> Option<&'a teaql_core::SmartList<crate::CartItem>> {
        self.resolve()
    }

    pub fn unwrap(&self) -> &'a teaql_core::SmartList<crate::CartItem> {
        self.resolve().expect("List relation was legitimately null in database!")
    }

    pub fn size(&self) -> crate::ValueExpression<'a, usize> {
        let next = self.result.clone().and_then("size", |list| teaql_core::eval::EvalResult::Value(list.len()));
        crate::ValueExpression::new(next, self.root_desc.clone())
    }

    pub fn first(&self) -> crate::CartItemExpression<'a> {
        let next = self.result.clone().and_then("first", |list| {
            if let Some(item) = list.first() {
                teaql_core::eval::EvalResult::Value(item)
            } else {
                teaql_core::eval::EvalResult::Null
            }
        });
        crate::CartItemExpression::new(next, self.root_desc.clone())
    }

    pub fn get(&self, index: usize) -> crate::CartItemExpression<'a> {
        let next = self.result.clone().and_then("get", |list| {
            if let Some(item) = list.get(index) {
                teaql_core::eval::EvalResult::Value(item)
            } else {
                teaql_core::eval::EvalResult::Null
            }
        });
        crate::CartItemExpression::new(next, self.root_desc.clone())
    }
}