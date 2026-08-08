# Build and Test Summary

## Generated Payment Java Library

- **Manifest:** `examples/payment/07-generated-code/java-lib-core/lib/pom.xml`
- **Command:** TeaQL file trace disabled; Maven `clean test` with Java 25
- **Result:** 23 sources compiled; `BUILD SUCCESS`
- **Tests:** 1 passed, 0 failed
- **Test:** `src/test/java/com/example/paymentservice/audit/MaskingAuditLoggerTest.java`
- **Claim:** generated Java masking metadata is enforced by the handwritten safe audit adapter
- **Raw log:** `examples/payment/run/build-and-test/payment-service-java.log`

The Java test sends a TeaQL `AuditEvent` through `MaskingAuditLogger.publish`, using the generated runtime property constant `paymentAccount`. It verifies normalization against the model policy name `payment_account`, and that the generated `EntityMetaRegistry` drives masking before delivery to both `SafeAuditEventSink` and TeaQL's final formatter. The synthetic raw account is absent from both outputs; `currency_code` remains visible.

## Generated Payment Rust Library

- **Manifest:** `examples/payment/07-generated-code/rust-lib-core/lib/Cargo.toml`
- **Command:** `TEAQL_AUDIT_LOG=_silent cargo test --locked --offline -- --nocapture`
- **Unit tests:** 0
- **Integration tests:** 1 passed, 0 failed
- **Test:** `tests/runtime_masking.rs`
- **Raw log:** `examples/payment/run/build-and-test/payment-service-rust.log`

The integration test registers a `SafeAuditEventSink`, sends a `RawAuditEvent` through the generated module's `UserContext`, and verifies that generated `audit_mask_fields` metadata causes `payment_account` to be masked. It asserts:

- `masked == true`;
- `mask_reason == "_audit_mask_fields"`;
- the synthetic raw account is absent;
- the non-sensitive `currency_code` remains unmasked.

## Security Boundary

The Java claim requires callers to use the handwritten `MaskingAuditLogger`; direct `LogManager.writeAuditLog` calls bypass it. The Java file trace is disabled during the test, while a custom sink verifies the sanitized formatter output. The separate Rust default raw trace logger is silenced with `TEAQL_AUDIT_LOG=_silent` and is not claimed to be masked.

## Unrelated ERP Tests

Pre-existing ERP KYC and numeric data-quality tests are not used as evidence for payment masking, Spring MVC integration, or DataHub lineage.
