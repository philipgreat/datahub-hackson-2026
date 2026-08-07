#[derive(Clone)]
pub struct CouponExpression<'a> {
    result: teaql_core::eval::EvalResult<&'a crate::Coupon>,
    root_desc: std::sync::Arc<String>,
}

impl<'a> CouponExpression<'a> {
    pub fn new(result: teaql_core::eval::EvalResult<&'a crate::Coupon>, root_desc: std::sync::Arc<String>) -> Self {
        Self { result, root_desc }
    }

    fn resolve(&self) -> Option<&'a crate::Coupon> {
        match &self.result {
            teaql_core::eval::EvalResult::Value(v) => Some(*v),
            teaql_core::eval::EvalResult::Null => None,
            teaql_core::eval::EvalResult::NotLoaded { failed_node, attempted_path } => {
                crate::trigger_logic_bug_panic(&self.root_desc, &failed_node, &attempted_path)
            }
        }
    }

    pub fn eval(&self) -> Option<&'a crate::Coupon> {
        self.resolve()
    }

    pub fn unwrap(&self) -> &'a crate::Coupon {
        self.resolve().expect("Relation was legitimately null in database!")
    }

    pub fn get_id(self) -> crate::ValueExpression<'a, u64> {
        let next = self.result.and_then("id", |entity| entity.eval_id());
        crate::ValueExpression::new(next, self.root_desc.clone())
    }

    pub fn get_code(self) -> crate::ValueExpression<'a, String> {
        let next = self.result.and_then("code", |entity| entity.eval_code());
        crate::ValueExpression::new(next, self.root_desc.clone())
    }

    pub fn get_times_used(self) -> crate::ValueExpression<'a, rust_decimal::Decimal> {
        let next = self.result.and_then("times_used", |entity| entity.eval_times_used());
        crate::ValueExpression::new(next, self.root_desc.clone())
    }

    pub fn get_usage_limit(self) -> crate::ValueExpression<'a, rust_decimal::Decimal> {
        let next = self.result.and_then("usage_limit", |entity| entity.eval_usage_limit());
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
    pub fn get_promotion_id(self) -> crate::ValueExpression<'a, u64> {
        let next = self.result.and_then("promotion_id", |entity| entity.eval_promotion_id());
        crate::ValueExpression::new(next, self.root_desc.clone())
    }
    pub fn get_promotion(self) -> crate::PromotionExpression<'a> {
        let next = self.result.and_then("promotion", |entity| entity.eval_promotion());
        crate::PromotionExpression::new(next, self.root_desc.clone())
    }
}

#[derive(Clone)]
pub struct CouponListExpression<'a> {
    result: teaql_core::eval::EvalResult<&'a teaql_core::SmartList<crate::Coupon>>,
    root_desc: std::sync::Arc<String>,
}

impl<'a> CouponListExpression<'a> {
    pub fn new(result: teaql_core::eval::EvalResult<&'a teaql_core::SmartList<crate::Coupon>>, root_desc: std::sync::Arc<String>) -> Self {
        Self { result, root_desc }
    }

    fn resolve(&self) -> Option<&'a teaql_core::SmartList<crate::Coupon>> {
        match &self.result {
            teaql_core::eval::EvalResult::Value(v) => Some(*v),
            teaql_core::eval::EvalResult::Null => None,
            teaql_core::eval::EvalResult::NotLoaded { failed_node, attempted_path } => {
                crate::trigger_logic_bug_panic(&self.root_desc, &failed_node, &attempted_path)
            }
        }
    }

    pub fn eval(&self) -> Option<&'a teaql_core::SmartList<crate::Coupon>> {
        self.resolve()
    }

    pub fn unwrap(&self) -> &'a teaql_core::SmartList<crate::Coupon> {
        self.resolve().expect("List relation was legitimately null in database!")
    }

    pub fn size(&self) -> crate::ValueExpression<'a, usize> {
        let next = self.result.clone().and_then("size", |list| teaql_core::eval::EvalResult::Value(list.len()));
        crate::ValueExpression::new(next, self.root_desc.clone())
    }

    pub fn first(&self) -> crate::CouponExpression<'a> {
        let next = self.result.clone().and_then("first", |list| {
            if let Some(item) = list.first() {
                teaql_core::eval::EvalResult::Value(item)
            } else {
                teaql_core::eval::EvalResult::Null
            }
        });
        crate::CouponExpression::new(next, self.root_desc.clone())
    }

    pub fn get(&self, index: usize) -> crate::CouponExpression<'a> {
        let next = self.result.clone().and_then("get", |list| {
            if let Some(item) = list.get(index) {
                teaql_core::eval::EvalResult::Value(item)
            } else {
                teaql_core::eval::EvalResult::Null
            }
        });
        crate::CouponExpression::new(next, self.root_desc.clone())
    }
}