# Build and Test Summary

## Generated Payment Java Library

- **Manifest:** `examples/payment/07-generated-code/java-lib-core/lib/pom.xml`
- **Command:** Maven `clean test` with Java 25
- **Result:** 19 sources compiled; `BUILD SUCCESS`
- **Tests:** `No tests to run`
- **Claim:** compilation only; no Java runtime masking claim
- **Raw log:** `examples/payment/run/build-and-test/payment-service-java.log`

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

The test verifies TeaQL's safe audit event path. The separate default raw trace logger is silenced with its documented `TEAQL_AUDIT_LOG=_silent` setting and is not claimed to be masked.

## Unrelated ERP Tests

Pre-existing ERP KYC and numeric data-quality tests are not used as evidence for payment masking, Spring MVC integration, or DataHub lineage.
