# Build and Test Summary

## Generated Payment Java Library

- **Manifest:** `examples/payment/07-generated-code/java-lib-core/lib/pom.xml`
- **Command:** TeaQL file trace disabled; Maven `clean test` with Java 25
- **Result:** 23 sources compiled; `BUILD SUCCESS`
- **Tests:** 2 passed, 0 failed
- **Test:** `src/test/java/com/example/paymentservice/audit/MaskingAuditLoggerTest.java`
- **Claim:** generated Java masking metadata is enforced by the handwritten safe audit adapter
- **Raw log:** `examples/payment/run/build-and-test/payment-service-java.log`

The Java tests cover both an in-memory TeaQL `AuditEvent` and the default JSON replay/import boundary. `MaskingAuditLogger.deserialize` returns only `SafeAuditEvent`: the generated `EntityMetaRegistry` is consulted during deserialization, policy fields are replaced with `[MASKED]`, malformed or unknown entity payloads fail closed, and the caller never receives the intermediate raw event. `deserializeAndPublish` applies the same rule before either `SafeAuditEventSink` or TeaQL's formatter. The synthetic raw account is absent from every safe output; `currency_code` remains visible.

## Generated Payment Rust Library

- **Manifest:** `examples/payment/07-generated-code/rust-lib-core/lib/Cargo.toml`
- **Command:** `TEAQL_AUDIT_LOG=_silent cargo test --locked --offline -- --nocapture`
- **Unit tests:** 0
- **Integration tests:** 1 passed, 0 failed
- **Test:** `tests/runtime_masking.rs`
- **Raw log:** `examples/payment/run/build-and-test/payment-service-rust.log`

The integration test starts with deserialized JSON business input, registers a `SafeAuditEventSink`, and sends the resulting `RawAuditEvent` through the generated module's `UserContext`. It verifies that generated `audit_mask_fields` metadata causes `payment_account` to be masked before application delivery. It asserts:

- `masked == true`;
- `mask_reason == "_audit_mask_fields"`;
- the synthetic raw account is absent;
- the non-sensitive `currency_code` remains unmasked.

## Security Boundary

The safe deserialization claim concerns the object returned to replay/import consumers and application audit sinks. Raw input necessarily exists transiently inside the trusted parser/runtime. Java callers must use `MaskingAuditLogger.deserialize`, `deserializeAndPublish`, or `publish`; direct `LogManager.writeAuditLog` remains an explicitly unsafe low-level bypass. Rust `RawAuditEvent` does not implement `serde::Deserialize`; business input is deserialized first and the runtime exposes a masked `SafeAuditEvent` to the custom sink. The separate Rust raw trace logger is disabled with `TEAQL_AUDIT_LOG=_silent` because it is a privileged diagnostic path, not a safe audit output.

## Unrelated ERP Tests

Pre-existing ERP KYC and numeric data-quality tests are not used as evidence for payment masking, Spring MVC integration, or DataHub lineage.
