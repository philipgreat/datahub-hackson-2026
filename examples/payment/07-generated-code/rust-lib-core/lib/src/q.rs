use teaql_core::Expr;

use crate::*;

pub struct PurposedQuery<T> {
    pub inner: T,
    pub purpose: String,
}

impl<T> PurposedQuery<T> {
    pub fn new(inner: T, purpose: impl Into<String>) -> Self {
        Self { inner, purpose: purpose.into() }
    }
}

pub struct Q;

impl Q {
    pub fn user_accounts() -> UserAccountRequest {
        UserAccountRequest::new()
            .select_self()
            .and_filter(Expr::gt("version", 0_i64))
    }

    pub fn user_accounts_minimal() -> UserAccountRequest {
        UserAccountRequest::new()
            .and_filter(Expr::gt("version", 0_i64))
    }

    pub fn user_accounts_with_children() -> UserAccountRequest {
        UserAccountRequest::new()
            .unlimited()
            .select_self_fields()
            .enhance_children_if_needed()
    }

    pub fn payment_transactions() -> PaymentTransactionRequest {
        PaymentTransactionRequest::new()
            .select_self()
            .and_filter(Expr::gt("version", 0_i64))
    }

    pub fn payment_transactions_minimal() -> PaymentTransactionRequest {
        PaymentTransactionRequest::new()
            .and_filter(Expr::gt("version", 0_i64))
    }

    pub fn payment_transactions_with_children() -> PaymentTransactionRequest {
        PaymentTransactionRequest::new()
            .unlimited()
            .select_self_fields()
            .enhance_children_if_needed()
    }
}