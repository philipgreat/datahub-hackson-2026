# Context-to-Code Mapping

## Verified Policy-Metadata Path

### 1. Captured DataHub Context

The `payment_transactions` dataset description states that its highly sensitive payment-account information must use audit and masking modules. The captured MCP field tags are empty, so this decision is grounded in the dataset description rather than a captured PII tag or glossary term.

### 2. TeaQL Model Decision

```xml
<payment_transaction
    payment_account="user_account()"
    _audit_mask_fields="payment_account"
    .../>
```

### 3. Generated Metadata

- Java `EntityMetaRegistry.java` contains `.with("audit_mask_fields", "payment_account")`.
- Rust `payment_transaction/entity.rs` contains `audit_mask_fields = "payment_account"`.

This verifies policy **metadata propagation** from the captured description through the TeaQL model into both generated libraries.

### 4. Runtime Boundary

No payment-service test currently invokes TeaQL masking behavior or asserts that the sensitive account value is hidden. Runtime masking therefore remains `PENDING`. ERP KYC and numeric data-quality tests do not verify this policy.

## Relationship Boundary

`payment_account="user_account()"` produces typed relation code, but the captured DataHub context does not contain relationship metadata connecting the two datasets. This mapping remains an agent/TeaQL modeling inference until supported by lineage, glossary, foreign-key, or documented-join evidence.
