# Build and Test Summary

This summary distinguishes the generated payment libraries from the pre-existing ERP application workspaces. It does not treat compilation, KYC, data quality, masking, and lineage as interchangeable evidence.

## Generated Payment Libraries

| Target | Recorded result | Tests | Limitation |
| --- | --- | --- | --- |
| `examples/payment/07-generated-code/java-lib-core/lib` | Maven compiled 19 sources; exit code 0 | No payment tests recorded | Compilation only |
| `examples/payment/07-generated-code/rust-lib-core/lib` | Cargo dev profile finished; exit code 0 | No payment tests recorded | Raw log omits command, manifest, crate, and timestamp |

Raw logs:

- `examples/payment/run/build-and-test/payment-service-java.log`
- `examples/payment/run/build-and-test/payment-service-rust.log`

Payment runtime policy verification remains pending.

## Pre-existing ERP Java Application

- **Workspace:** `java-web-spring-boot`
- **Test:** `com.example.enterpriseerpsystem.KycAuthInterceptorTest`
- **Recorded result:** 4 tests, 0 failures, 0 errors, 0 skipped
- **Scope:** direct class-instantiation checks of basic KYC header logic
- **Not proven:** Spring MVC registration/integration, payment masking, or DataHub lineage

## Pre-existing ERP Rust Console

- **Workspace:** `rust-app-console`
- **Recorded result:** 1 passed, 0 failed
- **Scope:** numeric data-quality filtering of non-positive transaction amounts
- **Not proven:** masking, KYC, or DataHub lineage

## Other ERP Workspaces

The recorded `run_all.log` shows compilation with zero tests for several Java/Rust workspaces. For `rust-web-topcoat`, only `rust-web-topcoat/lib` was compiled; no Topcoat web application manifest was present or verified.
