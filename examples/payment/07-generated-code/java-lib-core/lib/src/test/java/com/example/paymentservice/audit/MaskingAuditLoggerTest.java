package com.example.paymentservice.audit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.example.paymentservice.EntityMetaRegistry;
import com.example.paymentservice.paymenttransaction.PaymentTransaction;
import io.teaql.core.meta.EntityMetaFactory;
import io.teaql.core.meta.SimpleEntityMetaFactory;
import io.teaql.runtime.DefaultUserContext;
import io.teaql.runtime.log.AuditEvent;
import io.teaql.runtime.log.CustomLogSink;
import io.teaql.runtime.log.FieldChange;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class MaskingAuditLoggerTest {
  private static final String RAW_ACCOUNT = "payment-account-runtime-secret-8472";

  @BeforeAll
  static void registerGeneratedMetadata() {
    SimpleEntityMetaFactory factory = new SimpleEntityMetaFactory();
    new EntityMetaRegistry().assemble(factory);
    EntityMetaFactory.registerGlobal(factory);
  }

  @Test
  void masksGeneratedPolicyBeforeSafeSinkAndTeaqlFormatter() throws Exception {
    DefaultUserContext context = new DefaultUserContext(null);
    AtomicReference<SafeAuditEvent> deliveredEvent = new AtomicReference<>();
    AtomicReference<String> formattedLog = new AtomicReference<>();
    CountDownLatch logWritten = new CountDownLatch(1);
    context.put(SafeAuditEventSink.class.getName(),
        (SafeAuditEventSink) deliveredEvent::set);
    context.put(CustomLogSink.class.getName(), (CustomLogSink) content -> {
      formattedLog.set(content);
      logWritten.countDown();
    });

    AuditEvent rawEvent = new AuditEvent(
        PaymentTransaction.INTERNAL_TYPE,
        42L,
        "UPDATE",
        List.of(
            new FieldChange(
                PaymentTransaction.PAYMENT_ACCOUNT_PROPERTY,
                "previous-secret",
                RAW_ACCOUNT),
            new FieldChange("currency_code", "EUR", "USD")));

    SafeAuditEvent returnedEvent = MaskingAuditLogger.publish(context, rawEvent);
    SafeAuditEvent safeEvent = deliveredEvent.get();
    assertNotNull(safeEvent);
    assertEquals(returnedEvent, safeEvent);

    SafeFieldChange account = safeEvent.changes().get(0);
    assertEquals("paymentAccount", account.field());
    assertTrue(account.masked());
    assertEquals(MaskingAuditLogger.MASK_REASON, account.maskReason());
    assertEquals(MaskingAuditLogger.MASKED_VALUE, account.oldValue());
    assertEquals(MaskingAuditLogger.MASKED_VALUE, account.newValue());

    SafeFieldChange currency = safeEvent.changes().get(1);
    assertFalse(currency.masked());
    assertNull(currency.maskReason());
    assertEquals("USD", currency.newValue());

    assertTrue(logWritten.await(5, TimeUnit.SECONDS), "TeaQL log sink was not called");
    String log = formattedLog.get();
    assertFalse(log.contains(RAW_ACCOUNT));
    assertFalse(log.contains("previous-secret"));
    assertTrue(log.contains("paymentAccount: [MASKED]"));
    assertTrue(log.contains("currency_code: USD"));

    System.out.println(
        "JAVA_MASKING_EVIDENCE entity=PaymentTransaction policy_field=payment_account "
            + "runtime_field=paymentAccount masked=true reason=_audit_mask_fields "
            + "raw_present=false formatted_log_raw_present=false");
  }
}
