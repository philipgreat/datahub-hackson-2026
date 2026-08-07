#[derive(Clone)]
pub struct LedgerExpression<'a> {
    result: teaql_core::eval::EvalResult<&'a crate::Ledger>,
    root_desc: std::sync::Arc<String>,
}

impl<'a> LedgerExpression<'a> {
    pub fn new(result: teaql_core::eval::EvalResult<&'a crate::Ledger>, root_desc: std::sync::Arc<String>) -> Self {
        Self { result, root_desc }
    }

    fn resolve(&self) -> Option<&'a crate::Ledger> {
        match &self.result {
            teaql_core::eval::EvalResult::Value(v) => Some(*v),
            teaql_core::eval::EvalResult::Null => None,
            teaql_core::eval::EvalResult::NotLoaded { failed_node, attempted_path } => {
                crate::trigger_logic_bug_panic(&self.root_desc, &failed_node, &attempted_path)
            }
        }
    }

    pub fn eval(&self) -> Option<&'a crate::Ledger> {
        self.resolve()
    }

    pub fn unwrap(&self) -> &'a crate::Ledger {
        self.resolve().expect("Relation was legitimately null in database!")
    }

    pub fn get_id(self) -> crate::ValueExpression<'a, u64> {
        let next = self.result.and_then("id", |entity| entity.eval_id());
        crate::ValueExpression::new(next, self.root_desc.clone())
    }

    pub fn get_credit(self) -> crate::ValueExpression<'a, rust_decimal::Decimal> {
        let next = self.result.and_then("credit", |entity| entity.eval_credit());
        crate::ValueExpression::new(next, self.root_desc.clone())
    }

    pub fn get_debit(self) -> crate::ValueExpression<'a, rust_decimal::Decimal> {
        let next = self.result.and_then("debit", |entity| entity.eval_debit());
        crate::ValueExpression::new(next, self.root_desc.clone())
    }

    pub fn get_entry_date(self) -> crate::ValueExpression<'a, teaql_core::time::Timestamp> {
        let next = self.result.and_then("entry_date", |entity| entity.eval_entry_date());
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
    pub fn get_transaction_id(self) -> crate::ValueExpression<'a, u64> {
        let next = self.result.and_then("transaction_id", |entity| entity.eval_transaction_id());
        crate::ValueExpression::new(next, self.root_desc.clone())
    }
    pub fn get_transaction(self) -> crate::TransactionExpression<'a> {
        let next = self.result.and_then("transaction", |entity| entity.eval_transaction());
        crate::TransactionExpression::new(next, self.root_desc.clone())
    }
}

#[derive(Clone)]
pub struct LedgerListExpression<'a> {
    result: teaql_core::eval::EvalResult<&'a teaql_core::SmartList<crate::Ledger>>,
    root_desc: std::sync::Arc<String>,
}

impl<'a> LedgerListExpression<'a> {
    pub fn new(result: teaql_core::eval::EvalResult<&'a teaql_core::SmartList<crate::Ledger>>, root_desc: std::sync::Arc<String>) -> Self {
        Self { result, root_desc }
    }

    fn resolve(&self) -> Option<&'a teaql_core::SmartList<crate::Ledger>> {
        match &self.result {
            teaql_core::eval::EvalResult::Value(v) => Some(*v),
            teaql_core::eval::EvalResult::Null => None,
            teaql_core::eval::EvalResult::NotLoaded { failed_node, attempted_path } => {
                crate::trigger_logic_bug_panic(&self.root_desc, &failed_node, &attempted_path)
            }
        }
    }

    pub fn eval(&self) -> Option<&'a teaql_core::SmartList<crate::Ledger>> {
        self.resolve()
    }

    pub fn unwrap(&self) -> &'a teaql_core::SmartList<crate::Ledger> {
        self.resolve().expect("List relation was legitimately null in database!")
    }

    pub fn size(&self) -> crate::ValueExpression<'a, usize> {
        let next = self.result.clone().and_then("size", |list| teaql_core::eval::EvalResult::Value(list.len()));
        crate::ValueExpression::new(next, self.root_desc.clone())
    }

    pub fn first(&self) -> crate::LedgerExpression<'a> {
        let next = self.result.clone().and_then("first", |list| {
            if let Some(item) = list.first() {
                teaql_core::eval::EvalResult::Value(item)
            } else {
                teaql_core::eval::EvalResult::Null
            }
        });
        crate::LedgerExpression::new(next, self.root_desc.clone())
    }

    pub fn get(&self, index: usize) -> crate::LedgerExpression<'a> {
        let next = self.result.clone().and_then("get", |list| {
            if let Some(item) = list.get(index) {
                teaql_core::eval::EvalResult::Value(item)
            } else {
                teaql_core::eval::EvalResult::Null
            }
        });
        crate::LedgerExpression::new(next, self.root_desc.clone())
    }
}