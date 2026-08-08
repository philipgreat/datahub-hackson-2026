# DataHub-Grounded Multi-Language Code Generation

**Hackathon Track: Metadata-Aware Code Generation & Development**

## Project Positioning

An external coding agent queries DataHub through MCP, writes a TeaQL model from the returned metadata, and invokes a TeaQL generator running on the same remote host. The generated applications do not connect to MCP at runtime.

This was a two-agent workflow. Antigravity performed the initial MCP-assisted implementation; Codex Desktop performed the later review, MCP re-execution, internal regeneration, Java/Rust masking remediation, and evidence collection. The evidence host currently has Antigravity CLI `agy 1.1.11` at `/home/philip/.local/bin/agy`. The reviewing workstation has local `@openai/codex` CLI package `0.114.0`; this package version is not presented as the Codex Desktop build, which was not exposed to the session.

```text
Developer request
      |
      v
External coding agent ---- DataHub MCP Server ---- DataHub
      |                         schema and descriptions
      v
TeaQL model
      |
      v
TeaQL generator (127.0.0.1:18080)
      |
      +---- Java domain library + masking adapter/test
      +---- Rust domain library + masking integration test
```

The payment dataset description requires audit and masking treatment. The agent therefore added `_audit_mask_fields="payment_account"`. MCP returned no lineage, glossary term, foreign key, or documented join connecting the payment and user datasets, so `payment_account` is modeled honestly as the captured `VARCHAR` scalar rather than an invented relation.

## Verified Context-to-Code Effects

| Captured DataHub context | TeaQL decision | Generated/runtime effect |
| --- | --- | --- |
| Dataset and field names | Independent business entities and properties | Typed Java/Rust domain APIs |
| `payment_account` / `VARCHAR` | `payment_account="string()"` | Java `String` and Rust `String` field |
| Sensitive payment description | `_audit_mask_fields="payment_account"` | Java/Rust policy metadata; both safe audit paths mask the value |
| `get_lineage` upstream total `0` | No payment-to-user relation | No unsupported relation in generated code |

## Evidence Status

| Phase | Status | Direct evidence |
| --- | --- | --- |
| DataHub container and health | VERIFIED | `examples/payment/run/datahub-setup.log` |
| DataHub startup command and dependencies | VERIFIED | `examples/payment/run/datahub-startup-command.log` |
| Agent attribution and installed versions | VERIFIED WITH SCOPE | `examples/payment/run/agent-versions.txt` |
| MCP tools, entities, and lineage | VERIFIED | `examples/payment/03-mcp-tool-calls.jsonl` |
| TeaQL model evaluation | VERIFIED | Errors `0` in `examples/payment/run/model-eval.log` |
| Local Java/Rust generation | VERIFIED | `examples/payment/run/maven_generate.log`, `cargo_generate.log` |
| Java safe-event masking | VERIFIED | 23 sources compiled; one runtime masking test passed |
| Generated Rust masking | VERIFIED | One safe-event masking test passed |
| Default Rust raw trace masking | NOT VERIFIED | Raw logger is separate; evidence test uses `TEAQL_AUDIT_LOG=_silent` |
| KYC and lineage write-back | N/A | Not part of the payment masking demonstration |
| Generated-source repeatability | VERIFIED | Second empty-directory run matched; archives/test additions excluded |
| Invalid-schema/agent failure behavior | VERIFIED | Antigravity refused generation after MCP `not found` |
| Screenshots and public video | PENDING | Deferred to the human operator |

## Reproduction Phases

### 1. DataHub and MCP

```bash
examples/payment/collect_evidence.sh datahub
python3 mcp_client.py list_tools --jsonl
python3 mcp_client.py get_entities <payment-urn> <user-urn> --jsonl
python3 mcp_client.py get_lineage <payment-urn> --jsonl
```

The evidence host was started with the command recorded twice in shell history:

```bash
datahub docker quickstart
```

`examples/payment/run/datahub-startup-command.log` also records the current DataHub CLI, Compose file/hash, active dependency services, Compose labels, and HTTP `200` health result.

### 2. Verify Missing-context Behavior

```bash
script -q -e -c \
  "examples/payment/negative-agent-test/run_negative_agent_test.sh" \
  examples/payment/run/agent-negative-schema.log

examples/payment/negative-agent-test/verify_negative_agent_result.sh \
  examples/payment/run/agent-negative-schema.log
```

Antigravity executed the repository MCP client against an intentionally nonexistent dataset URN. DataHub returned `Entity ... not found`; the agent returned `can_generate=false`, empty business fields and relations, and requested a valid URN with retrievable schema metadata. This verifies refusal rather than schema or relationship invention. The call used Antigravity's terminal tool to execute the MCP client; it is not described as a native `call_mcp_tool` invocation.

### 3. Start the Internal TeaQL Generator

From the sibling `teaql-code-gen` checkout on the evidence host:

```bash
java -jar generator/target/generator-1.1.1.jar \
  --server.address=127.0.0.1 \
  --server.port=18080
```

The loopback binding keeps model generation on the remote machine.

### 4. Evaluate and Generate

```bash
export TEAQL_ENDPOINT_PREFIX=http://127.0.0.1:18080/

mvn io.teaql:teaql-maven-plugin:1.1.0:eval \
  -Dinput=examples/payment/05-generated-model.xml

mvn io.teaql:teaql-maven-plugin:1.1.0:generate \
  -Dservice=java-lib-core \
  -Dinput=examples/payment/05-generated-model.xml \
  -Dteaql.output=<empty-java-output>

cargo teaql \
  --endpoint-prefix "$TEAQL_ENDPOINT_PREFIX" \
  --input examples/payment/05-generated-model.xml \
  --output <empty-rust-output> \
  rust-lib-core
```

### 5. Build and Test Exact Outputs

```bash
TEAQL_TRACE_MODE=off \
TEAQL_TRACE_OFF_ACK=__i_agree_to_disable_runtime_trace_only_for_extreme_performance_testing \
mvn -f examples/payment/07-generated-code/java-lib-core/lib/pom.xml clean test

TEAQL_AUDIT_LOG=_silent cargo test \
  --manifest-path examples/payment/07-generated-code/rust-lib-core/lib/Cargo.toml \
  --locked --offline -- --nocapture
```

The Java test sends a TeaQL `AuditEvent` through the handwritten `MaskingAuditLogger`, using the generated runtime property name `paymentAccount`. The adapter reads `payment_account` from the generated `EntityMetaRegistry`, normalizes the snake_case/camelCase names, creates a `SafeAuditEvent`, and only then delegates sanitized values to TeaQL's formatter. It verifies that neither the safe event nor final formatted log contains the synthetic account value.

The Rust integration test sends a `RawAuditEvent` through `UserContext.send_event`. The context reads the generated `PaymentTransaction` descriptor, builds a `SafeAuditEvent`, and sends it to a registered `SafeAuditEventSink`. Both tests assert `masked=true`, `_audit_mask_fields` as the reason, absence of the synthetic raw account value, and that `currency_code` remains unmasked.

## Evidence Chain

1. [User prompt](examples/payment/01-user-request.md)
2. [MCP configuration](examples/payment/02-mcp-config.example.json)
3. [MCP JSONL](examples/payment/03-mcp-tool-calls.jsonl)
4. [Consolidated context](examples/payment/04-datahub-context.json)
5. [Canonical model](examples/payment/05-generated-model.xml)
6. [Model decisions](examples/payment/06-model-decisions.md)
7. [Generated code and Java/Rust masking tests](examples/payment/07-generated-code/)
8. [Generated source diff](examples/payment/08-generated.diff)
9. [Build/test summary](examples/payment/09-test-summary.md)
10. [Context-to-code map](examples/payment/10-context-to-code-map.md)
11. [Negative-agent test fixture](examples/payment/negative-agent-test/)
12. [Raw execution logs and checksums](examples/payment/run/)

## Security Boundary

The Java guarantee applies when audit events enter through the handwritten `MaskingAuditLogger.publish` adapter; direct calls to TeaQL `LogManager.writeAuditLog` bypass that adapter and are not claimed safe. The Java evidence command disables the file trace while still exercising the registered custom sink, which receives sanitized formatter output.

Rust's verified claim is specifically about TeaQL's `SafeAuditEvent` path. Its separate default raw trace logger can contain raw mutation values, so the evidence command sets `TEAQL_AUDIT_LOG=_silent`. Production deployments must route Java events through the masking adapter and disable or appropriately secure raw trace paths.

## Hackathon Scope Disclosure

The TeaQL generator, Java/Rust runtimes, generated-library templates, and large ERP sample existed before this submission. Antigravity produced the initial MCP-assisted implementation. Codex Desktop subsequently reviewed and corrected it, re-executed the repository MCP client, regenerated the payment outputs through the internal endpoint, added a handwritten Java masking adapter, verified Java/Rust safe-event masking, and updated the reproducibility evidence under `examples/payment/`.

Use [EVIDENCE.md](EVIDENCE.md) for detailed verification and [EVIDENCE_TODO.md](EVIDENCE_TODO.md) for remaining work. Screenshots and video are intentionally left for the human operator.
