package com.example.paymentservice.audit;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.teaql.core.UserContext;
import io.teaql.core.meta.EntityDescriptor;
import io.teaql.core.meta.EntityMetaFactory;
import io.teaql.runtime.log.AuditEvent;
import io.teaql.runtime.log.FieldChange;
import io.teaql.runtime.log.LogManager;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Policy-enforcing entry point for Java audit events.
 *
 * <p>The raw event is converted before either the application sink or TeaQL's formatter sees it.
 * Mask policy is read from the generated entity descriptor's {@code audit_mask_fields} metadata.
 */
public final class MaskingAuditLogger {
  public static final String MASKED_VALUE = "[MASKED]";
  public static final String MASK_REASON = "_audit_mask_fields";
  private static final ObjectMapper JSON = new ObjectMapper();

  private MaskingAuditLogger() {}

  /**
   * Deserializes an external audit-event payload into the safe representation.
   *
   * <p>This is the default boundary for replay/import consumers: callers never receive an
   * {@link AuditEvent} containing policy-protected values. Unknown entities and malformed payloads
   * fail closed.
   */
  public static SafeAuditEvent deserialize(String json) {
    return mask(deserializeRaw(json));
  }

  /** Deserializes, masks, and publishes without exposing the intermediate raw event to callers. */
  public static SafeAuditEvent deserializeAndPublish(UserContext context, String json) {
    Objects.requireNonNull(context, "context");
    return publish(context, deserializeRaw(json));
  }

  public static SafeAuditEvent publish(UserContext context, AuditEvent rawEvent) {
    Objects.requireNonNull(context, "context");
    SafeAuditEvent safeEvent = mask(rawEvent);

    SafeAuditEventSink safeSink = context.capability(SafeAuditEventSink.class);
    if (safeSink != null) {
      safeSink.onAuditEvent(safeEvent);
    }

    List<FieldChange> safeChanges = safeEvent.changes().stream()
        .map(change -> new FieldChange(change.field(), change.oldValue(), change.newValue()))
        .toList();
    LogManager.getInstance().writeAuditLog(
        context,
        context.getTraceChain(),
        new AuditEvent(
            safeEvent.entityType(),
            safeEvent.entityId(),
            safeEvent.mutationKind(),
            safeChanges));
    return safeEvent;
  }

  public static SafeAuditEvent mask(AuditEvent rawEvent) {
    Objects.requireNonNull(rawEvent, "rawEvent");
    EntityMetaFactory factory = EntityMetaFactory.get();
    if (factory == null) {
      throw new IllegalStateException("EntityMetaFactory is not registered; refusing unsafe audit output");
    }
    EntityDescriptor descriptor;
    try {
      descriptor = factory.resolveEntityDescriptor(rawEvent.getEntityType());
    } catch (RuntimeException e) {
      throw new IllegalArgumentException(
          "No entity descriptor for " + rawEvent.getEntityType()
              + "; refusing unsafe audit output",
          e);
    }
    if (descriptor == null) {
      throw new IllegalArgumentException(
          "No entity descriptor for " + rawEvent.getEntityType() + "; refusing unsafe audit output");
    }

    Set<String> maskFields = parseMaskFields(
        descriptor.getAdditionalInfo().get("audit_mask_fields"));
    List<FieldChange> rawChanges = rawEvent.getChanges() == null
        ? Collections.emptyList()
        : rawEvent.getChanges();
    List<SafeFieldChange> safeChanges = rawChanges.stream()
        .map(change -> maskChange(change, maskFields))
        .toList();
    return new SafeAuditEvent(
        rawEvent.getEntityType(),
        rawEvent.getEntityId(),
        rawEvent.getMutationKind(),
        safeChanges);
  }

  private static AuditEvent deserializeRaw(String json) {
    Objects.requireNonNull(json, "json");
    try {
      JsonNode root = JSON.readTree(json);
      if (root == null || !root.isObject()) {
        throw new IllegalArgumentException("Audit event payload must be a JSON object");
      }
      String entityType = requiredText(root, "entityType");
      String mutationKind = requiredText(root, "mutationKind");
      JsonNode changesNode = root.get("changes");
      if (changesNode == null || !changesNode.isArray()) {
        throw new IllegalArgumentException("Audit event changes must be a JSON array");
      }

      List<FieldChange> changes = new java.util.ArrayList<>();
      for (JsonNode change : changesNode) {
        if (!change.isObject()) {
          throw new IllegalArgumentException("Each audit field change must be a JSON object");
        }
        changes.add(new FieldChange(
            requiredText(change, "field"),
            jsonValue(change.get("oldValue")),
            jsonValue(change.get("newValue"))));
      }
      return new AuditEvent(
          entityType,
          jsonValue(root.get("entityId")),
          mutationKind,
          List.copyOf(changes));
    } catch (JsonProcessingException e) {
      throw new IllegalArgumentException("Invalid audit event JSON", e);
    }
  }

  private static String requiredText(JsonNode parent, String field) {
    JsonNode value = parent.get(field);
    if (value == null || !value.isTextual() || value.textValue().isBlank()) {
      throw new IllegalArgumentException("Audit event " + field + " must be non-blank text");
    }
    return value.textValue();
  }

  private static Object jsonValue(JsonNode value) {
    if (value == null || value.isNull()) {
      return null;
    }
    return JSON.convertValue(value, Object.class);
  }

  private static SafeFieldChange maskChange(FieldChange change, Set<String> maskFields) {
    boolean masked = maskFields.contains(canonicalFieldName(change.getField()));
    return new SafeFieldChange(
        change.getField(),
        masked && change.getOldValue() != null ? MASKED_VALUE : change.getOldValue(),
        masked && change.getNewValue() != null ? MASKED_VALUE : change.getNewValue(),
        masked,
        masked ? MASK_REASON : null);
  }

  private static Set<String> parseMaskFields(String configuredFields) {
    if (configuredFields == null || configuredFields.isBlank()) {
      return Collections.emptySet();
    }
    return Arrays.stream(configuredFields.split(","))
        .map(String::trim)
        .filter(value -> !value.isEmpty())
        .map(MaskingAuditLogger::canonicalFieldName)
        .collect(Collectors.toUnmodifiableSet());
  }

  private static String canonicalFieldName(String fieldName) {
    if (fieldName == null) {
      return "";
    }
    return fieldName.replaceAll("[^A-Za-z0-9]", "").toLowerCase(Locale.ROOT);
  }
}
