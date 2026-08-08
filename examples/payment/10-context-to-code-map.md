# Context-to-Code Mapping

| Stage | Evidence | Result |
| --- | --- | --- |
| DataHub | Payment description requires audit and masking | Captured through MCP |
| DataHub | `payment_account` is `VARCHAR`; lineage upstream total is `0` | Scalar field; no invented relation |
| TeaQL model | `payment_account="string()"` | Schema-aligned field |
| TeaQL policy | `_audit_mask_fields="payment_account"` | Generated policy metadata |
| Java generation | `audit_mask_fields=payment_account`; `String paymentAccount` | Metadata and scalar code compiled |
| Rust generation | `audit_mask_fields = "payment_account"`; `payment_account: String` | Runtime descriptor and event field align |
| Rust runtime | `UserContext.send_event` to `SafeAuditEventSink` | `masked=true`, raw value absent, test passed |

## Runtime Evidence

```text
MASKING_EVIDENCE entity=PaymentTransaction
field=payment_account
masked=true
reason=_audit_mask_fields
raw_present=false
```

The test uses generated metadata rather than a hard-coded list in the test. A control assertion confirms that `currency_code` is not masked.

## Boundary

The verified output is `SafeAuditEvent`. TeaQL's separate raw trace logger is disabled for the evidence run with `TEAQL_AUDIT_LOG=_silent`; no claim is made that raw trace output is masked.
