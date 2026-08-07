#[derive(Clone)]
pub struct KnowledgeBaseExpression<'a> {
    result: teaql_core::eval::EvalResult<&'a crate::KnowledgeBase>,
    root_desc: std::sync::Arc<String>,
}

impl<'a> KnowledgeBaseExpression<'a> {
    pub fn new(result: teaql_core::eval::EvalResult<&'a crate::KnowledgeBase>, root_desc: std::sync::Arc<String>) -> Self {
        Self { result, root_desc }
    }

    fn resolve(&self) -> Option<&'a crate::KnowledgeBase> {
        match &self.result {
            teaql_core::eval::EvalResult::Value(v) => Some(*v),
            teaql_core::eval::EvalResult::Null => None,
            teaql_core::eval::EvalResult::NotLoaded { failed_node, attempted_path } => {
                crate::trigger_logic_bug_panic(&self.root_desc, &failed_node, &attempted_path)
            }
        }
    }

    pub fn eval(&self) -> Option<&'a crate::KnowledgeBase> {
        self.resolve()
    }

    pub fn unwrap(&self) -> &'a crate::KnowledgeBase {
        self.resolve().expect("Relation was legitimately null in database!")
    }

    pub fn get_id(self) -> crate::ValueExpression<'a, u64> {
        let next = self.result.and_then("id", |entity| entity.eval_id());
        crate::ValueExpression::new(next, self.root_desc.clone())
    }

    pub fn get_category(self) -> crate::ValueExpression<'a, String> {
        let next = self.result.and_then("category", |entity| entity.eval_category());
        crate::ValueExpression::new(next, self.root_desc.clone())
    }

    pub fn get_content(self) -> crate::ValueExpression<'a, String> {
        let next = self.result.and_then("content", |entity| entity.eval_content());
        crate::ValueExpression::new(next, self.root_desc.clone())
    }

    pub fn get_title(self) -> crate::ValueExpression<'a, String> {
        let next = self.result.and_then("title", |entity| entity.eval_title());
        crate::ValueExpression::new(next, self.root_desc.clone())
    }

    pub fn get_views(self) -> crate::ValueExpression<'a, rust_decimal::Decimal> {
        let next = self.result.and_then("views", |entity| entity.eval_views());
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
}

#[derive(Clone)]
pub struct KnowledgeBaseListExpression<'a> {
    result: teaql_core::eval::EvalResult<&'a teaql_core::SmartList<crate::KnowledgeBase>>,
    root_desc: std::sync::Arc<String>,
}

impl<'a> KnowledgeBaseListExpression<'a> {
    pub fn new(result: teaql_core::eval::EvalResult<&'a teaql_core::SmartList<crate::KnowledgeBase>>, root_desc: std::sync::Arc<String>) -> Self {
        Self { result, root_desc }
    }

    fn resolve(&self) -> Option<&'a teaql_core::SmartList<crate::KnowledgeBase>> {
        match &self.result {
            teaql_core::eval::EvalResult::Value(v) => Some(*v),
            teaql_core::eval::EvalResult::Null => None,
            teaql_core::eval::EvalResult::NotLoaded { failed_node, attempted_path } => {
                crate::trigger_logic_bug_panic(&self.root_desc, &failed_node, &attempted_path)
            }
        }
    }

    pub fn eval(&self) -> Option<&'a teaql_core::SmartList<crate::KnowledgeBase>> {
        self.resolve()
    }

    pub fn unwrap(&self) -> &'a teaql_core::SmartList<crate::KnowledgeBase> {
        self.resolve().expect("List relation was legitimately null in database!")
    }

    pub fn size(&self) -> crate::ValueExpression<'a, usize> {
        let next = self.result.clone().and_then("size", |list| teaql_core::eval::EvalResult::Value(list.len()));
        crate::ValueExpression::new(next, self.root_desc.clone())
    }

    pub fn first(&self) -> crate::KnowledgeBaseExpression<'a> {
        let next = self.result.clone().and_then("first", |list| {
            if let Some(item) = list.first() {
                teaql_core::eval::EvalResult::Value(item)
            } else {
                teaql_core::eval::EvalResult::Null
            }
        });
        crate::KnowledgeBaseExpression::new(next, self.root_desc.clone())
    }

    pub fn get(&self, index: usize) -> crate::KnowledgeBaseExpression<'a> {
        let next = self.result.clone().and_then("get", |list| {
            if let Some(item) = list.get(index) {
                teaql_core::eval::EvalResult::Value(item)
            } else {
                teaql_core::eval::EvalResult::Null
            }
        });
        crate::KnowledgeBaseExpression::new(next, self.root_desc.clone())
    }
}