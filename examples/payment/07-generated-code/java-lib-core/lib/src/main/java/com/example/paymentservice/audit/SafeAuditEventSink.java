package com.example.paymentservice.audit;

/** Capability registered on a UserContext to receive policy-safe audit events. */
@FunctionalInterface
public interface SafeAuditEventSink {
  void onAuditEvent(SafeAuditEvent event);
}
