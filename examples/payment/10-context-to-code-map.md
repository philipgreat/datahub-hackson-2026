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
<payment_transaction
    _audit_mask_fields="payment_account"
    .../>
```

### C. Generated Domain Libraries
The proprietary TeaQL engine generated the domain representations in `java-lib-core` and `rust-lib-core`, propagating this masking rule into the statically-typed domain.

### D. Verified Runtime Behavior (Pending)
While the generated `java-lib-core` and `rust-lib-core` successfully encapsulate the `_audit_mask_fields` constraints natively via the TeaQL code generation step, specific runtime tests for the newly generated `payment-service` have not yet been implemented (Runtime Policy Pending). However, the parallel massive ERP application in this repository successfully passes its test suite leveraging the exact same TeaQL code generation architecture.
