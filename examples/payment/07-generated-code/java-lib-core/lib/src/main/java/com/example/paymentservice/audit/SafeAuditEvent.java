package com.example.paymentservice.audit;

import java.util.List;

/** An audit event whose field values have already passed policy masking. */
public record SafeAuditEvent(
    String entityType,
    Object entityId,
    String mutationKind,
    List<SafeFieldChange> changes) {

  public SafeAuditEvent {
    changes = List.copyOf(changes);
  }
}
