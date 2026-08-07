# Context to Code Mapping

This document illustrates the causal chain from DataHub metadata to generated TeaQL models, and finally to verified behavior in Rust and Java code.

## 1. Shift-Left Security: PII Masking

### A. DataHub Source (via MCP)
The `payment_transactions` dataset properties contained this critical description constraint:
> "包含高度敏感的用户支付账号信息，必须接入审计与脱敏模块。"
> (Contains highly sensitive user payment accounts, must integrate with audit and data masking modules.)

### B. TeaQL Model Injection
The AI Agent intelligently interpreted this privacy constraint and injected the exact shift-left security attribute into the generated `05-generated-model.xml`:
```xml
<attribute name="_audit_mask_fields" value="payment_account"/>
```

### C. Generated Domain Libraries
The proprietary TeaQL engine generated the domain representations in `java-lib-core` and `rust-lib-core`, propagating this masking rule into the statically-typed domain.

### D. Verified Runtime Behavior
1. **Rust (`rust-app-console`)**:
   The stream processor strictly adheres to the masking requirements. When processing transactions, it successfully sanitizes the PII:
   ```rust
   // From tests::test_process_stream_data_quality
   ✅ Processed valid transaction, masking account info: *****
   ```

2. **Java (`java-web-spring-boot`)**:
   The `KycAuthInterceptorTest` integration test enforces strict access control policies on any endpoint handling these payment entities, successfully verifying `403 Forbidden` for unverified requests and `200 OK` for compliant, masked requests.
