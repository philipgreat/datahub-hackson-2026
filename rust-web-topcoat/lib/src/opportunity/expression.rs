#[derive(Clone)]
pub struct OpportunityExpression<'a> {
    result: teaql_core::eval::EvalResult<&'a crate::Opportunity>,
    root_desc: std::sync::Arc<String>,
}

impl<'a> OpportunityExpression<'a> {
    pub fn new(result: teaql_core::eval::EvalResult<&'a crate::Opportunity>, root_desc: std::sync::Arc<String>) -> Self {
        Self { result, root_desc }
    }

    fn resolve(&self) -> Option<&'a crate::Opportunity> {
        match &self.result {
            teaql_core::eval::EvalResult::Value(v) => Some(*v),
            teaql_core::eval::EvalResult::Null => None,
            teaql_core::eval::EvalResult::NotLoaded { failed_node, attempted_path } => {
                crate::trigger_logic_bug_panic(&self.root_desc, &failed_node, &attempted_path)
            }
        }
    }

    pub fn eval(&self) -> Option<&'a crate::Opportunity> {
        self.resolve()
    }

    pub fn unwrap(&self) -> &'a crate::Opportunity {
        self.resolve().expect("Relation was legitimately null in database!")
    }

    pub fn get_id(self) -> crate::ValueExpression<'a, u64> {
        let next = self.result.and_then("id", |entity| entity.eval_id());
        crate::ValueExpression::new(next, self.root_desc.clone())
    }

    pub fn get_close_date(self) -> crate::ValueExpression<'a, teaql_core::time::Timestamp> {
        let next = self.result.and_then("close_date", |entity| entity.eval_close_date());
        crate::ValueExpression::new(next, self.root_desc.clone())
    }

    pub fn get_expected_revenue(self) -> crate::ValueExpression<'a, rust_decimal::Decimal> {
        let next = self.result.and_then("expected_revenue", |entity| entity.eval_expected_revenue());
        crate::ValueExpression::new(next, self.root_desc.clone())
    }

    pub fn get_probability(self) -> crate::ValueExpression<'a, rust_decimal::Decimal> {
        let next = self.result.and_then("probability", |entity| entity.eval_probability());
        crate::ValueExpression::new(next, self.root_desc.clone())
    }

    pub fn get_status(self) -> crate::ValueExpression<'a, String> {
        let next = self.result.and_then("status", |entity| entity.eval_status());
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
    pub fn get_lead_id(self) -> crate::ValueExpression<'a, u64> {
        let next = self.result.and_then("lead_id", |entity| entity.eval_lead_id());
        crate::ValueExpression::new(next, self.root_desc.clone())
    }
    pub fn get_lead(self) -> crate::LeadExpression<'a> {
        let next = self.result.and_then("lead", |entity| entity.eval_lead());
        crate::LeadExpression::new(next, self.root_desc.clone())
    }
    pub fn get_quote_list(self) -> crate::QuoteListExpression<'a> {
        let next = self.result.and_then("quote_list", |entity| entity.eval_quote_list());
        crate::QuoteListExpression::new(next, self.root_desc.clone())
    }
}

#[derive(Clone)]
pub struct OpportunityListExpression<'a> {
    result: teaql_core::eval::EvalResult<&'a teaql_core::SmartList<crate::Opportunity>>,
    root_desc: std::sync::Arc<String>,
}

impl<'a> OpportunityListExpression<'a> {
    pub fn new(result: teaql_core::eval::EvalResult<&'a teaql_core::SmartList<crate::Opportunity>>, root_desc: std::sync::Arc<String>) -> Self {
        Self { result, root_desc }
    }

    fn resolve(&self) -> Option<&'a teaql_core::SmartList<crate::Opportunity>> {
        match &self.result {
            teaql_core::eval::EvalResult::Value(v) => Some(*v),
            teaql_core::eval::EvalResult::Null => None,
            teaql_core::eval::EvalResult::NotLoaded { failed_node, attempted_path } => {
                crate::trigger_logic_bug_panic(&self.root_desc, &failed_node, &attempted_path)
            }
        }
    }

    pub fn eval(&self) -> Option<&'a teaql_core::SmartList<crate::Opportunity>> {
        self.resolve()
    }

    pub fn unwrap(&self) -> &'a teaql_core::SmartList<crate::Opportunity> {
        self.resolve().expect("List relation was legitimately null in database!")
    }

    pub fn size(&self) -> crate::ValueExpression<'a, usize> {
        let next = self.result.clone().and_then("size", |list| teaql_core::eval::EvalResult::Value(list.len()));
        crate::ValueExpression::new(next, self.root_desc.clone())
    }

    pub fn first(&self) -> crate::OpportunityExpression<'a> {
        let next = self.result.clone().and_then("first", |list| {
            if let Some(item) = list.first() {
                teaql_core::eval::EvalResult::Value(item)
            } else {
                teaql_core::eval::EvalResult::Null
            }
        });
        crate::OpportunityExpression::new(next, self.root_desc.clone())
    }

    pub fn get(&self, index: usize) -> crate::OpportunityExpression<'a> {
        let next = self.result.clone().and_then("get", |list| {
            if let Some(item) = list.get(index) {
                teaql_core::eval::EvalResult::Value(item)
            } else {
                teaql_core::eval::EvalResult::Null
            }
        });
        crate::OpportunityExpression::new(next, self.root_desc.clone())
    }
}