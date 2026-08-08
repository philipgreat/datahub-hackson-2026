# Context-to-Code Mapping

| Stage | Evidence | Result |
| --- | --- | --- |
| DataHub | Payment description requires audit and masking | Captured through MCP |
| DataHub | `payment_account` is `VARCHAR`; lineage upstream total is `0` | Scalar field; no invented relation |
| TeaQL model | `payment_account="string()"` | Schema-aligned field |
| TeaQL policy | `_audit_mask_fields="payment_account"` | Generated policy metadata |
| Java generation | `audit_mask_fields=payment_account`; `String paymentAccount` | Metadata and scalar code compiled |
| Java runtime | `MaskingAuditLogger` reads generated metadata before TeaQL formatter | Safe event and formatted log contain `[MASKED]`; raw value absent |
| Rust generation | `audit_mask_fields = "payment_account"`; `payment_account: String` | Runtime descriptor and event field align |
| Rust runtime | `UserContext.send_event` to `SafeAuditEventSink` | `masked=true`, raw value absent, test passed |

## Runtime Evidence

```text
JAVA_MASKING_EVIDENCE entity=PaymentTransaction
policy_field=payment_account
runtime_field=paymentAccount
masked=true
reason=_audit_mask_fields
raw_present=false
formatted_log_raw_present=false

MASKING_EVIDENCE entity=PaymentTransaction
field=payment_account
masked=true
reason=_audit_mask_fields
raw_present=false
```

Both tests use generated metadata rather than a hard-coded mask list. Control assertions confirm that `currency_code` is not masked.

## Boundary

The Java claim applies to the handwritten `MaskingAuditLogger` entry point and its safe event/formatter output; direct TeaQL `LogManager` calls are outside it. Rust's separate raw trace logger is disabled for the evidence run with `TEAQL_AUDIT_LOG=_silent`; no claim is made that Rust raw trace output is masked.
