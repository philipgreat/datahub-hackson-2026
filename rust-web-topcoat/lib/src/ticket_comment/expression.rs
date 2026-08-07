#[derive(Clone)]
pub struct TicketCommentExpression<'a> {
    result: teaql_core::eval::EvalResult<&'a crate::TicketComment>,
    root_desc: std::sync::Arc<String>,
}

impl<'a> TicketCommentExpression<'a> {
    pub fn new(result: teaql_core::eval::EvalResult<&'a crate::TicketComment>, root_desc: std::sync::Arc<String>) -> Self {
        Self { result, root_desc }
    }

    fn resolve(&self) -> Option<&'a crate::TicketComment> {
        match &self.result {
            teaql_core::eval::EvalResult::Value(v) => Some(*v),
            teaql_core::eval::EvalResult::Null => None,
            teaql_core::eval::EvalResult::NotLoaded { failed_node, attempted_path } => {
                crate::trigger_logic_bug_panic(&self.root_desc, &failed_node, &attempted_path)
            }
        }
    }

    pub fn eval(&self) -> Option<&'a crate::TicketComment> {
        self.resolve()
    }

    pub fn unwrap(&self) -> &'a crate::TicketComment {
        self.resolve().expect("Relation was legitimately null in database!")
    }

    pub fn get_id(self) -> crate::ValueExpression<'a, u64> {
        let next = self.result.and_then("id", |entity| entity.eval_id());
        crate::ValueExpression::new(next, self.root_desc.clone())
    }

    pub fn get_author_id(self) -> crate::ValueExpression<'a, String> {
        let next = self.result.and_then("author_id", |entity| entity.eval_author_id());
        crate::ValueExpression::new(next, self.root_desc.clone())
    }

    pub fn get_comment_text(self) -> crate::ValueExpression<'a, String> {
        let next = self.result.and_then("comment_text", |entity| entity.eval_comment_text());
        crate::ValueExpression::new(next, self.root_desc.clone())
    }

    pub fn get_created_at(self) -> crate::ValueExpression<'a, teaql_core::time::Timestamp> {
        let next = self.result.and_then("created_at", |entity| entity.eval_created_at());
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
    pub fn get_ticket_id(self) -> crate::ValueExpression<'a, u64> {
        let next = self.result.and_then("ticket_id", |entity| entity.eval_ticket_id());
        crate::ValueExpression::new(next, self.root_desc.clone())
    }
    pub fn get_ticket(self) -> crate::TicketExpression<'a> {
        let next = self.result.and_then("ticket", |entity| entity.eval_ticket());
        crate::TicketExpression::new(next, self.root_desc.clone())
    }
}

#[derive(Clone)]
pub struct TicketCommentListExpression<'a> {
    result: teaql_core::eval::EvalResult<&'a teaql_core::SmartList<crate::TicketComment>>,
    root_desc: std::sync::Arc<String>,
}

impl<'a> TicketCommentListExpression<'a> {
    pub fn new(result: teaql_core::eval::EvalResult<&'a teaql_core::SmartList<crate::TicketComment>>, root_desc: std::sync::Arc<String>) -> Self {
        Self { result, root_desc }
    }

    fn resolve(&self) -> Option<&'a teaql_core::SmartList<crate::TicketComment>> {
        match &self.result {
            teaql_core::eval::EvalResult::Value(v) => Some(*v),
            teaql_core::eval::EvalResult::Null => None,
            teaql_core::eval::EvalResult::NotLoaded { failed_node, attempted_path } => {
                crate::trigger_logic_bug_panic(&self.root_desc, &failed_node, &attempted_path)
            }
        }
    }

    pub fn eval(&self) -> Option<&'a teaql_core::SmartList<crate::TicketComment>> {
        self.resolve()
    }

    pub fn unwrap(&self) -> &'a teaql_core::SmartList<crate::TicketComment> {
        self.resolve().expect("List relation was legitimately null in database!")
    }

    pub fn size(&self) -> crate::ValueExpression<'a, usize> {
        let next = self.result.clone().and_then("size", |list| teaql_core::eval::EvalResult::Value(list.len()));
        crate::ValueExpression::new(next, self.root_desc.clone())
    }

    pub fn first(&self) -> crate::TicketCommentExpression<'a> {
        let next = self.result.clone().and_then("first", |list| {
            if let Some(item) = list.first() {
                teaql_core::eval::EvalResult::Value(item)
            } else {
                teaql_core::eval::EvalResult::Null
            }
        });
        crate::TicketCommentExpression::new(next, self.root_desc.clone())
    }

    pub fn get(&self, index: usize) -> crate::TicketCommentExpression<'a> {
        let next = self.result.clone().and_then("get", |list| {
            if let Some(item) = list.get(index) {
                teaql_core::eval::EvalResult::Value(item)
            } else {
                teaql_core::eval::EvalResult::Null
            }
        });
        crate::TicketCommentExpression::new(next, self.root_desc.clone())
    }
}