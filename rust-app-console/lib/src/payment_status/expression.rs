#[derive(Clone)]
pub struct PaymentStatusExpression<'a> {
    result: teaql_core::eval::EvalResult<&'a crate::PaymentStatus>,
    root_desc: std::sync::Arc<String>,
}

impl<'a> PaymentStatusExpression<'a> {
    pub fn new(result: teaql_core::eval::EvalResult<&'a crate::PaymentStatus>, root_desc: std::sync::Arc<String>) -> Self {
        Self { result, root_desc }
    }

    fn resolve(&self) -> Option<&'a crate::PaymentStatus> {
        match &self.result {
            teaql_core::eval::EvalResult::Value(v) => Some(*v),
            teaql_core::eval::EvalResult::Null => None,
            teaql_core::eval::EvalResult::NotLoaded { failed_node, attempted_path } => {
                crate::trigger_logic_bug_panic(&self.root_desc, &failed_node, &attempted_path)
            }
        }
    }

    pub fn eval(&self) -> Option<&'a crate::PaymentStatus> {
        self.resolve()
    }

    pub fn unwrap(&self) -> &'a crate::PaymentStatus {
        self.resolve().expect("Relation was legitimately null in database!")
    }

    pub fn get_id(self) -> crate::ValueExpression<'a, u64> {
        let next = self.result.and_then("id", |entity| entity.eval_id());
        crate::ValueExpression::new(next, self.root_desc.clone())
    }

    pub fn get_name(self) -> crate::ValueExpression<'a, String> {
        let next = self.result.and_then("name", |entity| entity.eval_name());
        crate::ValueExpression::new(next, self.root_desc.clone())
    }

    pub fn get_code(self) -> crate::ValueExpression<'a, String> {
        let next = self.result.and_then("code", |entity| entity.eval_code());
        crate::ValueExpression::new(next, self.root_desc.clone())
    }

    pub fn get_color(self) -> crate::ValueExpression<'a, String> {
        let next = self.result.and_then("color", |entity| entity.eval_color());
        crate::ValueExpression::new(next, self.root_desc.clone())
    }

    pub fn get_display_order(self) -> crate::ValueExpression<'a, rust_decimal::Decimal> {
        let next = self.result.and_then("display_order", |entity| entity.eval_display_order());
        crate::ValueExpression::new(next, self.root_desc.clone())
    }

    pub fn get_progress(self) -> crate::ValueExpression<'a, rust_decimal::Decimal> {
        let next = self.result.and_then("progress", |entity| entity.eval_progress());
        crate::ValueExpression::new(next, self.root_desc.clone())
    }

    pub fn get_version(self) -> crate::ValueExpression<'a, i64> {
        let next = self.result.and_then("version", |entity| entity.eval_version());
        crate::ValueExpression::new(next, self.root_desc.clone())
    }
    pub fn get_payment_account_id(self) -> crate::ValueExpression<'a, u64> {
        let next = self.result.and_then("payment_account_id", |entity| entity.eval_payment_account_id());
        crate::ValueExpression::new(next, self.root_desc.clone())
    }
    pub fn get_payment_account(self) -> crate::PaymentAccountExpression<'a> {
        let next = self.result.and_then("payment_account", |entity| entity.eval_payment_account());
        crate::PaymentAccountExpression::new(next, self.root_desc.clone())
    }
    pub fn get_payment_transaction_list(self) -> crate::PaymentTransactionListExpression<'a> {
        let next = self.result.and_then("payment_transaction_list", |entity| entity.eval_payment_transaction_list());
        crate::PaymentTransactionListExpression::new(next, self.root_desc.clone())
    }
}

#[derive(Clone)]
pub struct PaymentStatusListExpression<'a> {
    result: teaql_core::eval::EvalResult<&'a teaql_core::SmartList<crate::PaymentStatus>>,
    root_desc: std::sync::Arc<String>,
}

impl<'a> PaymentStatusListExpression<'a> {
    pub fn new(result: teaql_core::eval::EvalResult<&'a teaql_core::SmartList<crate::PaymentStatus>>, root_desc: std::sync::Arc<String>) -> Self {
        Self { result, root_desc }
    }

    fn resolve(&self) -> Option<&'a teaql_core::SmartList<crate::PaymentStatus>> {
        match &self.result {
            teaql_core::eval::EvalResult::Value(v) => Some(*v),
            teaql_core::eval::EvalResult::Null => None,
            teaql_core::eval::EvalResult::NotLoaded { failed_node, attempted_path } => {
                crate::trigger_logic_bug_panic(&self.root_desc, &failed_node, &attempted_path)
            }
        }
    }

    pub fn eval(&self) -> Option<&'a teaql_core::SmartList<crate::PaymentStatus>> {
        self.resolve()
    }

    pub fn unwrap(&self) -> &'a teaql_core::SmartList<crate::PaymentStatus> {
        self.resolve().expect("List relation was legitimately null in database!")
    }

    pub fn size(&self) -> crate::ValueExpression<'a, usize> {
        let next = self.result.clone().and_then("size", |list| teaql_core::eval::EvalResult::Value(list.len()));
        crate::ValueExpression::new(next, self.root_desc.clone())
    }

    pub fn first(&self) -> crate::PaymentStatusExpression<'a> {
        let next = self.result.clone().and_then("first", |list| {
            if let Some(item) = list.first() {
                teaql_core::eval::EvalResult::Value(item)
            } else {
                teaql_core::eval::EvalResult::Null
            }
        });
        crate::PaymentStatusExpression::new(next, self.root_desc.clone())
    }

    pub fn get(&self, index: usize) -> crate::PaymentStatusExpression<'a> {
        let next = self.result.clone().and_then("get", |list| {
            if let Some(item) = list.get(index) {
                teaql_core::eval::EvalResult::Value(item)
            } else {
                teaql_core::eval::EvalResult::Null
            }
        });
        crate::PaymentStatusExpression::new(next, self.root_desc.clone())
    }
}