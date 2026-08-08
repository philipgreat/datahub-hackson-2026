package com.example.paymentservice.audit;

/** A field change that is safe to deliver to audit sinks. */
public record SafeFieldChange(
    String field,
    Object oldValue,
    Object newValue,
    boolean masked,
    String maskReason) {}
