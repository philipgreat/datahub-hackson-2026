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
    pub fn payment_accounts() -> PaymentAccountRequest {
        PaymentAccountRequest::new()
            .select_self()
            .and_filter(Expr::gt("version", 0_i64))
    }

    pub fn payment_accounts_minimal() -> PaymentAccountRequest {
        PaymentAccountRequest::new()
            .and_filter(Expr::gt("version", 0_i64))
    }

    pub fn payment_accounts_with_children() -> PaymentAccountRequest {
        PaymentAccountRequest::new()
            .unlimited()
            .select_self_fields()
            .enhance_children_if_needed()
    }

    pub fn payment_methods() -> PaymentMethodRequest {
        PaymentMethodRequest::new()
            .select_self()
            .and_filter(Expr::gt("version", 0_i64))
    }

    pub fn payment_methods_minimal() -> PaymentMethodRequest {
        PaymentMethodRequest::new()
            .and_filter(Expr::gt("version", 0_i64))
    }

    pub fn payment_methods_with_children() -> PaymentMethodRequest {
        PaymentMethodRequest::new()
            .unlimited()
            .select_self_fields()
            .enhance_children_if_needed()
    }

    pub fn payment_statuses() -> PaymentStatusRequest {
        PaymentStatusRequest::new()
            .select_self()
            .and_filter(Expr::gt("version", 0_i64))
    }

    pub fn payment_statuses_minimal() -> PaymentStatusRequest {
        PaymentStatusRequest::new()
            .and_filter(Expr::gt("version", 0_i64))
    }

    pub fn payment_statuses_with_children() -> PaymentStatusRequest {
        PaymentStatusRequest::new()
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