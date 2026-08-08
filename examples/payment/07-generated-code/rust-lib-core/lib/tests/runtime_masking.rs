use std::sync::{Arc, Mutex};

use payment_service_core::teaql_core::{Record, TeaqlEntity, Value};
use payment_service_core::{PaymentTransaction, module};
use teaql_runtime::{
    RawAuditEvent, RuntimeError, SafeAuditEvent, SafeAuditEventSink, UserContext,
};

#[derive(Clone, Default)]
struct CapturingSafeAuditSink {
    events: Arc<Mutex<Vec<SafeAuditEvent>>>,
}

impl SafeAuditEventSink for CapturingSafeAuditSink {
    fn on_safe_event(
        &self,
        _ctx: &UserContext,
        event: &SafeAuditEvent,
    ) -> Result<(), RuntimeError> {
        self.events.lock().unwrap().push(event.clone());
        Ok(())
    }
}

#[test]
fn generated_payment_policy_masks_the_runtime_audit_event() {
    const SYNTHETIC_ACCOUNT: &str = "TEST-ACCOUNT-0001";

    // Model the real boundary: untrusted JSON is deserialized into business input before the
    // runtime constructs an audit event. Only SafeAuditEvent is exposed to the application sink.
    let input: serde_json::Value = serde_json::from_str(&format!(
        r#"{{"transaction_amount":150.00,"payment_account":"{}","currency_code":"CNY"}}"#,
        SYNTHETIC_ACCOUNT
    ))
    .expect("business input must deserialize");
    let input_account = input["payment_account"]
        .as_str()
        .expect("payment_account must be text");
    let input_currency = input["currency_code"]
        .as_str()
        .expect("currency_code must be text");

    let descriptor = PaymentTransaction::entity_descriptor();
    assert_eq!(descriptor.audit_mask_fields, vec!["payment_account"]);

    let sink = CapturingSafeAuditSink::default();
    let captured = Arc::clone(&sink.events);
    let mut context = module().into_context();
    context.set_custom_event_sink(sink);

    let raw_event = RawAuditEvent::created(
        "PaymentTransaction",
        Record::from([
            (
                "payment_account".to_owned(),
                Value::Text(input_account.to_owned()),
            ),
            (
                "currency_code".to_owned(),
                Value::Text(input_currency.to_owned()),
            ),
        ]),
    );
    context.send_event(raw_event).unwrap();

    let events = captured.lock().unwrap();
    assert_eq!(events.len(), 1);
    let event = &events[0];

    let account = event
        .fields
        .iter()
        .find(|field| field.name == "payment_account")
        .expect("payment_account must be present in the safe audit event");
    let masked_value = account.value.as_deref().expect("masked value must exist");

    assert!(account.masked);
    assert_eq!(account.mask_reason.as_deref(), Some("_audit_mask_fields"));
    assert!(!masked_value.contains(SYNTHETIC_ACCOUNT));

    let currency = event
        .fields
        .iter()
        .find(|field| field.name == "currency_code")
        .expect("currency_code must be present in the safe audit event");
    assert!(!currency.masked);
    assert!(currency.value.as_deref().unwrap().contains("CNY"));

    println!(
        "MASKING_EVIDENCE entity={} field={} input_deserialized=true masked={} reason={} raw_present={} output={}",
        event.entity,
        account.name,
        account.masked,
        account.mask_reason.as_deref().unwrap(),
        masked_value.contains(SYNTHETIC_ACCOUNT),
        masked_value,
    );
}
