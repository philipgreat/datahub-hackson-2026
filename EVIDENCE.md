# Verified Evidence: DataHub MCP to TeaQL Runtime Masking

## Status

- DataHub container health and ingestion: **VERIFIED**
- DataHub startup command and active dependencies: **VERIFIED**
- Coding-agent attribution and currently installed versions: **VERIFIED WITH SCOPE**
- MCP `tools/list`, `get_entities`, and `get_lineage`: **VERIFIED**
- Model evaluation (`Errors: 0`): **VERIFIED**
- Java/Rust generation through loopback TeaQL service: **VERIFIED**
- Java generated library plus masking adapter: **VERIFIED; 1 TEST PASSED**
- Rust generated library compilation and safe-event masking: **VERIFIED; 1 TEST PASSED**
- Default Rust raw trace masking: **NOT VERIFIED / OUTSIDE SAFE-EVENT CLAIM**
- Generated-source repeatability: **VERIFIED**
- Invalid-schema/agent refusal behavior: **VERIFIED**
- Screenshots and public video: **PENDING**

## 1. Runtime Environment

`examples/payment/run/environment.txt` records the evidence host, Git base commit, Java, Maven, Rust, Cargo, Python, MCP Server, local generator, and DataHub image versions. Node.js is explicitly recorded as not installed. The worktree was intentionally dirty during capture, so this run is not described as a clean-checkout run.

`examples/payment/run/datahub-setup.log` contains real `docker ps`, Docker health JSON, HTTP status `200`, and ingestion output. It replaces the earlier mocked status as the verification source.

`examples/payment/run/datahub-startup-command.log` records the exact Quickstart command from two shell-history entries:

```text
datahub docker quickstart
```

The same log records the currently installed DataHub CLI `1.2.0.2`, Docker Compose `v2.34.0`, Compose file path and SHA-256, active MySQL/Kafka/OpenSearch/GMS/frontend/actions services, their Compose labels, and a fresh GMS health result of HTTP `200`. The CLI and Compose versions are current capture-time state; shell history is the direct evidence for the launch command.

### Coding-agent attribution

`examples/payment/run/agent-versions.txt` records the two-agent workflow:

- Antigravity performed the initial MCP-assisted implementation. A login-shell check on the evidence host currently resolves `/home/philip/.local/bin/agy` and reports version `1.1.11`.
- Codex Desktop performed review, MCP re-execution, regeneration, masking fixes, and final evidence collection. The review workstation's local `@openai/codex` CLI package metadata reports `0.114.0`; this is recorded separately from the Codex Desktop build, which was not exposed.

The Antigravity version check establishes the version currently installed on the evidence host, not an immutable historical attestation that the initial session used the same binary. Agent phase attribution is supplied by the project operator.

## 2. MCP Evidence

`examples/payment/03-mcp-tool-calls.jsonl` contains three timestamped, sanitized records:

1. `list_tools`;
2. `get_entities` for both dataset URNs;
3. `get_lineage` for the payment dataset.

The entity call returns the payment fields and the sensitive dataset description. The captured field tag arrays are empty. The lineage result reports upstream total `0`. No captured glossary, lineage, foreign-key, or join metadata supports a relationship between `payment_account` and the separately fetched user dataset.

`examples/payment/04-datahub-context.json` is mechanically derived from the sanitized `get_entities` JSONL record.

## 3. Negative Agent Behavior

The reproducible fixture is under `examples/payment/negative-agent-test/`; the exact prompt used and raw Antigravity stream are stored at:

```text
examples/payment/run/agent-negative-schema-prompt.txt
examples/payment/run/agent-negative-schema.log
examples/payment/run/agent-negative-schema-summary.log
```

Antigravity CLI `1.1.11`, using `gemini-3.1-pro-high`, executed exactly one terminal command: the repository MCP client calling `get_entities` for an intentionally nonexistent dataset URN. The real MCP response reported `Entity ... not found`. The agent's schema-validated final result contained:

```json
{
  "decision": "REFUSE_MISSING_CONTEXT",
  "can_generate": false,
  "generated_business_fields": [],
  "generated_relations": []
}
```

It requested a valid dataset URN with retrievable schema metadata. `verify_negative_agent_result.sh` mechanically checks the decision, MCP error, empty field/relation arrays, and clarification request; the saved result is `NEGATIVE_AGENT_ASSERTIONS=PASS`. Antigravity invoked the MCP client through its `run_command` terminal tool, not its native `call_mcp_tool` tool.

## 4. Canonical Model

Model SHA-256:

```text
48e44bb6dac1437cb806b1a00653b693c8c6cb4c12e87edf67afe4721a5bff64
```

Relevant model fragment:

```xml
<payment_transaction _name="Payment Transaction"
                     _module="Core"
                     _module_key="core"
                     payment_account="string()"
                     currency_code="string()"
                     payment_method="string()"
                     transaction_amount="150.00"
                     _audit_mask_fields="payment_account"
                     create_time="createTime()"
                     update_time="updateTime()"/>
```

The scalar `payment_account` matches the captured `VARCHAR`. The prior unsupported `user_account()` relation was removed after `get_lineage` returned no relationship. `create_time`, `update_time`, IDs, and versions are TeaQL framework fields.

The local evaluation report in `examples/payment/run/model-eval.log` records `Errors: 0`. Its warnings concern generic sample values, independent entities, and a suggestion for `user_name`; none contradict the payment masking rule.

## 5. Internal Generation

The generator ran on the evidence host at `http://127.0.0.1:18080/`, version `20260804.173835`. Both clients explicitly show this endpoint in their raw logs, so the model was not sent to `api.teaql.io` during final generation.

- Java: Maven plugin `1.1.0`, `service=java-lib-core`.
- Rust: cargo-teaql `2.0.8`, target `rust-lib-core`.
- Output began under a new `/tmp/payment-gen.*` directory.
- `examples/payment/run/generated-files.sha256` records the final output manifest.
- `examples/payment/08-generated.diff` compares the previous checked-in sources with the final locally generated sources; ZIP files are covered by checksums.
- `examples/payment/run/repeat-generation.log` records a second empty-directory generation. Java and Rust generator-owned sources matched after excluding archives, the handwritten Java audit adapter/test and customized test POM, the handwritten Rust test, Cargo.lock, and build directories.

## 6. Compilation and Runtime Masking

### Java

The generated Java library contains a handwritten policy adapter and test:

```text
examples/payment/07-generated-code/java-lib-core/lib/src/main/java/com/example/paymentservice/audit/MaskingAuditLogger.java
examples/payment/07-generated-code/java-lib-core/lib/src/test/java/com/example/paymentservice/audit/MaskingAuditLoggerTest.java
```

`MaskingAuditLogger` resolves `audit_mask_fields` from the generated `EntityMetaRegistry`, normalizes the model's `payment_account` policy name against the generated Java runtime property `paymentAccount`, creates a `SafeAuditEvent`, sends it to an optional `SafeAuditEventSink`, and delegates only sanitized `FieldChange` values to TeaQL's formatter. It fails closed when entity metadata is unavailable.

`examples/payment/run/build-and-test/payment-service-java.log` records compilation of 23 Java sources and one passing test. The assertions cover `masked=true`, reason `_audit_mask_fields`, preservation of non-sensitive `currency_code`, and absence of the synthetic raw account in both the safe event and formatted log. Its marker is:

```text
JAVA_MASKING_EVIDENCE entity=PaymentTransaction policy_field=payment_account runtime_field=paymentAccount masked=true reason=_audit_mask_fields raw_present=false formatted_log_raw_present=false
Tests run: 1, Failures: 0, Errors: 0, Skipped: 0
```

### Rust

The handwritten integration test is:

```text
examples/payment/07-generated-code/rust-lib-core/lib/tests/runtime_masking.rs
```

It exercises this chain:

```text
generated PaymentTransaction descriptor
  -> RuntimeModule metadata
  -> UserContext.send_event(RawAuditEvent)
  -> SafeAuditEvent construction
  -> SafeAuditEventSink
```

The raw test log contains:

```text
MASKING_EVIDENCE entity=PaymentTransaction field=payment_account masked=true reason=_audit_mask_fields raw_present=false
test result: ok. 1 passed; 0 failed
```

The test also asserts that non-sensitive `currency_code` is not masked. It uses a synthetic account value and verifies that value is absent from the safe event.

## 7. Raw Logger Boundary

Java masking is enforced by the handwritten `MaskingAuditLogger.publish` entry point. A caller that directly invokes TeaQL `LogManager.writeAuditLog` bypasses that policy adapter. The Java evidence run disables file trace using TeaQL's acknowledged trace-off variables while the custom sink verifies sanitized formatter output.

Rust's default raw trace logger is separate from `SafeAuditEventSink` and can contain raw mutation values. The final Rust evidence command uses `TEAQL_AUDIT_LOG=_silent` to prevent raw trace output while testing the safe-event path. The verified claim is therefore:

> Generated masking metadata is consumed by the Java policy adapter and Rust TeaQL runtime to mask `payment_account` before safe audit output.

It is **not** a claim that every internal or raw log sink is automatically masked.

## 8. Remaining Work

`EVIDENCE_TODO.md` now retains presentation work (screenshots and public video) plus the final post-commit consistency audit. KYC and lineage write-back are not used as substitutes for masking evidence.
