# Evidence Mapping: DataHub MCP to TeaQL Code Generation

> **Current scope**
>
> - MCP `get_entities`: VERIFIED
> - TeaQL model: PARTIALLY VERIFIED
> - Online generation: VERIFIED WITH LIMITATIONS
> - Generated Java/Rust library compilation: VERIFIED
> - Payment runtime masking: PENDING
> - Cross-dataset relationship grounding: PENDING / AGENT INFERENCE
> - Clean Docker/DataHub health: PENDING

The DataHub MCP Server is used by an external coding agent during development. Generated Rust and Java code does not call MCP at runtime.

## 1. Captured MCP Request

The following request metadata is synchronized with `examples/payment/03-mcp-tool-calls.jsonl`:

```json
{
  "timestamp": "2026-08-07T19:01:27.658225Z",
  "tool": "get_entities",
  "arguments": {
    "urns": [
      "urn:li:dataset:(urn:li:dataPlatform:snowflake,prod.finance.payment_transactions,PROD)",
      "urn:li:dataset:(urn:li:dataPlatform:hive,fct_users_created,PROD)"
    ]
  }
}
```

The JSONL record contains the sanitized response. Its consolidated form is stored in `examples/payment/04-datahub-context.json`.

## 2. What the MCP Response Establishes

The response establishes:

- dataset `payment_transactions` and fields `payment_account`, `currency_code`, `payment_method`, and `transaction_amount`;
- dataset `fct_users_created` and field `user_name`;
- native field types and nullability;
- a payment dataset description stating that sensitive payment-account data requires audit and masking treatment.

It does **not** contain a glossary term, lineage edge, foreign key, or documented join connecting `payment_account` to `user_account`. The captured field tag arrays are empty. Accordingly, the TeaQL relation `payment_account="user_account()"` is an agent/TeaQL modeling inference, not a verified DataHub relationship.

## 3. Recorded TeaQL Model

The canonical model is `examples/payment/05-generated-model.xml`. Its relevant entity is:

```xml
<payment_transaction _name="Payment Transaction"
                     _module="Core"
                     _module_key="core"
                     payment_account="user_account()"
                     currency_code="string()"
                     payment_method="string()"
                     transaction_amount="150.00"
                     _audit_mask_fields="payment_account"
                     create_time="createTime()"
                     update_time="updateTime()"/>
```

`create_time`, `update_time`, IDs, versions, and other base properties in generated code are TeaQL framework fields rather than DataHub business fields. `transaction_amount="150.00"` is the TeaQL decimal-model syntax selected from the captured `DECIMAL` type; it is not a captured transaction value.

## 4. Context-to-Code Mapping

| Captured source | Model output | Generated output | Verification boundary |
| --- | --- | --- | --- |
| `payment_transactions` dataset | `<payment_transaction ...>` | `PaymentTransaction` types | Entity naming recorded |
| `transaction_amount` / `DECIMAL` | `transaction_amount="150.00"` | Numeric property APIs | Compilation verified |
| Sensitive payment description | `_audit_mask_fields="payment_account"` | Java `audit_mask_fields` and Rust `audit_mask_fields` metadata | Metadata propagation verified; runtime masking pending |
| Two separately fetched datasets | `payment_account="user_account()"` | Typed relation APIs | Agent inference; DataHub relationship not verified |

Generated metadata can be inspected in:

- `examples/payment/07-generated-code/java-lib-core/lib/src/main/java/com/example/paymentservice/EntityMetaRegistry.java`
- `examples/payment/07-generated-code/rust-lib-core/lib/src/payment_transaction/entity.rs`

## 5. Generation and Compilation Evidence

`examples/payment/run/generator.log` records successful Java and Rust online generation commands and exit codes for `payment-service`. The Java section contains Maven plugin output; the Rust section is a shorter summary. The current artifacts do not prove that both output directories were empty before generation, include a model SHA-256, or demonstrate deterministic repeat generation.

The checked-in payment libraries have successful compilation records:

- Java: `examples/payment/run/build-and-test/payment-service-java.log`
- Rust: `examples/payment/run/build-and-test/payment-service-rust.log`

The Java log identifies the payment project and 19 compiled sources. The Rust log records only a successful dev-profile completion and exit code, so its command, manifest, crate, and timestamp remain TODO items.

## 6. Runtime and ERP Evidence Boundaries

No test currently proves payment-service runtime masking. The pre-existing ERP sample tests are separate evidence:

- Java directly instantiates a KYC interceptor; it is not a Spring MVC integration or masking test.
- Rust tests a numeric data-quality filter; it is not a masking or lineage test.
- `rust-web-topcoat/lib` compilation proves only that generated library, not a Topcoat web application.

These ERP results cannot substitute for payment runtime policy verification.

## 7. Unverified Items

The following remain in `EVIDENCE_TODO.md`:

- real Docker container status and DataHub health checks;
- complete tool and image versions;
- relationship/glossary/lineage grounding or explicit confirmation that none exists;
- model evaluation output and model SHA-256;
- empty-output and repeat-generation evidence;
- complete Rust generation and compilation logs;
- payment runtime masking/KYC tests;
- failure-behavior tests, screenshots, and demo video.
