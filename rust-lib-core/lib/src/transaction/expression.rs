#[derive(Clone)]
pub struct TransactionExpression<'a> {
    result: teaql_core::eval::EvalResult<&'a crate::Transaction>,
    root_desc: std::sync::Arc<String>,
}

impl<'a> TransactionExpression<'a> {
    pub fn new(result: teaql_core::eval::EvalResult<&'a crate::Transaction>, root_desc: std::sync::Arc<String>) -> Self {
        Self { result, root_desc }
    }

    fn resolve(&self) -> Option<&'a crate::Transaction> {
        match &self.result {
            teaql_core::eval::EvalResult::Value(v) => Some(*v),
            teaql_core::eval::EvalResult::Null => None,
            teaql_core::eval::EvalResult::NotLoaded { failed_node, attempted_path } => {
                crate::trigger_logic_bug_panic(&self.root_desc, &failed_node, &attempted_path)
            }
        }
    }

    pub fn eval(&self) -> Option<&'a crate::Transaction> {
        self.resolve()
    }

    pub fn unwrap(&self) -> &'a crate::Transaction {
        self.resolve().expect("Relation was legitimately null in database!")
    }

    pub fn get_id(self) -> crate::ValueExpression<'a, u64> {
        let next = self.result.and_then("id", |entity| entity.eval_id());
        crate::ValueExpression::new(next, self.root_desc.clone())
    }

    pub fn get_amount(self) -> crate::ValueExpression<'a, rust_decimal::Decimal> {
        let next = self.result.and_then("amount", |entity| entity.eval_amount());
        crate::ValueExpression::new(next, self.root_desc.clone())
    }

    pub fn get_timestamp(self) -> crate::ValueExpression<'a, teaql_core::time::Timestamp> {
        let next = self.result.and_then("timestamp", |entity| entity.eval_timestamp());
        crate::ValueExpression::new(next, self.root_desc.clone())
    }

    pub fn get_type_field(self) -> crate::ValueExpression<'a, String> {
        let next = self.result.and_then("type", |entity| entity.eval_type_field());
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
    pub fn get_account_id(self) -> crate::ValueExpression<'a, u64> {
        let next = self.result.and_then("account_id", |entity| entity.eval_account_id());
        crate::ValueExpression::new(next, self.root_desc.clone())
    }
    pub fn get_account(self) -> crate::AccountExpression<'a> {
        let next = self.result.and_then("account", |entity| entity.eval_account());
        crate::AccountExpression::new(next, self.root_desc.clone())
    }
    pub fn get_ledger_list(self) -> crate::LedgerListExpression<'a> {
        let next = self.result.and_then("ledger_list", |entity| entity.eval_ledger_list());
        crate::LedgerListExpression::new(next, self.root_desc.clone())
    }
}

#[derive(Clone)]
pub struct TransactionListExpression<'a> {
    result: teaql_core::eval::EvalResult<&'a teaql_core::SmartList<crate::Transaction>>,
    root_desc: std::sync::Arc<String>,
}

impl<'a> TransactionListExpression<'a> {
    pub fn new(result: teaql_core::eval::EvalResult<&'a teaql_core::SmartList<crate::Transaction>>, root_desc: std::sync::Arc<String>) -> Self {
        Self { result, root_desc }
    }

    fn resolve(&self) -> Option<&'a teaql_core::SmartList<crate::Transaction>> {
        match &self.result {
            teaql_core::eval::EvalResult::Value(v) => Some(*v),
            teaql_core::eval::EvalResult::Null => None,
            teaql_core::eval::EvalResult::NotLoaded { failed_node, attempted_path } => {
                crate::trigger_logic_bug_panic(&self.root_desc, &failed_node, &attempted_path)
            }
        }
    }

    pub fn eval(&self) -> Option<&'a teaql_core::SmartList<crate::Transaction>> {
        self.resolve()
    }

    pub fn unwrap(&self) -> &'a teaql_core::SmartList<crate::Transaction> {
        self.resolve().expect("List relation was legitimately null in database!")
    }

    pub fn size(&self) -> crate::ValueExpression<'a, usize> {
        let next = self.result.clone().and_then("size", |list| teaql_core::eval::EvalResult::Value(list.len()));
        crate::ValueExpression::new(next, self.root_desc.clone())
    }

    pub fn first(&self) -> crate::TransactionExpression<'a> {
        let next = self.result.clone().and_then("first", |list| {
            if let Some(item) = list.first() {
                teaql_core::eval::EvalResult::Value(item)
            } else {
                teaql_core::eval::EvalResult::Null
            }
        });
        crate::TransactionExpression::new(next, self.root_desc.clone())
    }

    pub fn get(&self, index: usize) -> crate::TransactionExpression<'a> {
        let next = self.result.clone().and_then("get", |list| {
            if let Some(item) = list.get(index) {
                teaql_core::eval::EvalResult::Value(item)
            } else {
                teaql_core::eval::EvalResult::Null
            }
        });
        crate::TransactionExpression::new(next, self.root_desc.clone())
    }
}