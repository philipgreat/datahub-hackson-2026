#[derive(Clone)]
pub struct PaymentAccountExpression<'a> {
    result: teaql_core::eval::EvalResult<&'a crate::PaymentAccount>,
    root_desc: std::sync::Arc<String>,
}

impl<'a> PaymentAccountExpression<'a> {
    pub fn new(result: teaql_core::eval::EvalResult<&'a crate::PaymentAccount>, root_desc: std::sync::Arc<String>) -> Self {
        Self { result, root_desc }
    }

    fn resolve(&self) -> Option<&'a crate::PaymentAccount> {
        match &self.result {
            teaql_core::eval::EvalResult::Value(v) => Some(*v),
            teaql_core::eval::EvalResult::Null => None,
            teaql_core::eval::EvalResult::NotLoaded { failed_node, attempted_path } => {
                crate::trigger_logic_bug_panic(&self.root_desc, &failed_node, &attempted_path)
            }
        }
    }

    pub fn eval(&self) -> Option<&'a crate::PaymentAccount> {
        self.resolve()
    }

    pub fn unwrap(&self) -> &'a crate::PaymentAccount {
        self.resolve().expect("Relation was legitimately null in database!")
    }

    pub fn get_id(self) -> crate::ValueExpression<'a, u64> {
        let next = self.result.and_then("id", |entity| entity.eval_id());
        crate::ValueExpression::new(next, self.root_desc.clone())
    }

    pub fn get_account_name(self) -> crate::ValueExpression<'a, String> {
        let next = self.result.and_then("account_name", |entity| entity.eval_account_name());
        crate::ValueExpression::new(next, self.root_desc.clone())
    }

    pub fn get_account_number(self) -> crate::ValueExpression<'a, i64> {
        let next = self.result.and_then("account_number", |entity| entity.eval_account_number());
        crate::ValueExpression::new(next, self.root_desc.clone())
    }

    pub fn get_currency_code(self) -> crate::ValueExpression<'a, String> {
        let next = self.result.and_then("currency_code", |entity| entity.eval_currency_code());
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
    pub fn get_user_account_id(self) -> crate::ValueExpression<'a, u64> {
        let next = self.result.and_then("user_account_id", |entity| entity.eval_user_account_id());
        crate::ValueExpression::new(next, self.root_desc.clone())
    }
    pub fn get_user_account(self) -> crate::UserAccountExpression<'a> {
        let next = self.result.and_then("user_account", |entity| entity.eval_user_account());
        crate::UserAccountExpression::new(next, self.root_desc.clone())
    }
    pub fn get_payment_method_list(self) -> crate::PaymentMethodListExpression<'a> {
        let next = self.result.and_then("payment_method_list", |entity| entity.eval_payment_method_list());
        crate::PaymentMethodListExpression::new(next, self.root_desc.clone())
    }

    pub fn get_payment_transaction_list(self) -> crate::PaymentTransactionListExpression<'a> {
        let next = self.result.and_then("payment_transaction_list", |entity| entity.eval_payment_transaction_list());
        crate::PaymentTransactionListExpression::new(next, self.root_desc.clone())
    }
}

#[derive(Clone)]
pub struct PaymentAccountListExpression<'a> {
    result: teaql_core::eval::EvalResult<&'a teaql_core::SmartList<crate::PaymentAccount>>,
    root_desc: std::sync::Arc<String>,
}

impl<'a> PaymentAccountListExpression<'a> {
    pub fn new(result: teaql_core::eval::EvalResult<&'a teaql_core::SmartList<crate::PaymentAccount>>, root_desc: std::sync::Arc<String>) -> Self {
        Self { result, root_desc }
    }

    fn resolve(&self) -> Option<&'a teaql_core::SmartList<crate::PaymentAccount>> {
        match &self.result {
            teaql_core::eval::EvalResult::Value(v) => Some(*v),
            teaql_core::eval::EvalResult::Null => None,
            teaql_core::eval::EvalResult::NotLoaded { failed_node, attempted_path } => {
                crate::trigger_logic_bug_panic(&self.root_desc, &failed_node, &attempted_path)
            }
        }
    }

    pub fn eval(&self) -> Option<&'a teaql_core::SmartList<crate::PaymentAccount>> {
        self.resolve()
    }

    pub fn unwrap(&self) -> &'a teaql_core::SmartList<crate::PaymentAccount> {
        self.resolve().expect("List relation was legitimately null in database!")
    }

    pub fn size(&self) -> crate::ValueExpression<'a, usize> {
        let next = self.result.clone().and_then("size", |list| teaql_core::eval::EvalResult::Value(list.len()));
        crate::ValueExpression::new(next, self.root_desc.clone())
    }

    pub fn first(&self) -> crate::PaymentAccountExpression<'a> {
        let next = self.result.clone().and_then("first", |list| {
            if let Some(item) = list.first() {
                teaql_core::eval::EvalResult::Value(item)
            } else {
                teaql_core::eval::EvalResult::Null
            }
        });
        crate::PaymentAccountExpression::new(next, self.root_desc.clone())
    }

    pub fn get(&self, index: usize) -> crate::PaymentAccountExpression<'a> {
        let next = self.result.clone().and_then("get", |list| {
            if let Some(item) = list.get(index) {
                teaql_core::eval::EvalResult::Value(item)
            } else {
                teaql_core::eval::EvalResult::Null
            }
        });
        crate::PaymentAccountExpression::new(next, self.root_desc.clone())
    }
}