# DataHub-Grounded Multi-Language Code Generation

**Hackathon Track: Metadata-Aware Code Generation & Development**

## Project Positioning

An external coding agent queries DataHub through MCP, writes a TeaQL model from the returned metadata, and invokes a TeaQL generator running on the same remote host. The generated applications do not connect to MCP at runtime.

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
      +---- Java domain library
      +---- Rust domain library + masking integration test
```

The payment dataset description requires audit and masking treatment. The agent therefore added `_audit_mask_fields="payment_account"`. MCP returned no lineage, glossary term, foreign key, or documented join connecting the payment and user datasets, so `payment_account` is modeled honestly as the captured `VARCHAR` scalar rather than an invented relation.

## Verified Context-to-Code Effects

| Captured DataHub context | TeaQL decision | Generated/runtime effect |
| --- | --- | --- |
| Dataset and field names | Independent business entities and properties | Typed Java/Rust domain APIs |
| `payment_account` / `VARCHAR` | `payment_account="string()"` | Java `String` and Rust `String` field |
| Sensitive payment description | `_audit_mask_fields="payment_account"` | Java/Rust policy metadata; Rust safe audit event masks the value |
| `get_lineage` upstream total `0` | No payment-to-user relation | No unsupported relation in generated code |

## Evidence Status

| Phase | Status | Direct evidence |
| --- | --- | --- |
| DataHub container and health | VERIFIED | `examples/payment/run/datahub-setup.log` |
| MCP tools, entities, and lineage | VERIFIED | `examples/payment/03-mcp-tool-calls.jsonl` |
| TeaQL model evaluation | VERIFIED | Errors `0` in `examples/payment/run/model-eval.log` |
| Local Java/Rust generation | VERIFIED | `examples/payment/run/maven_generate.log`, `cargo_generate.log` |
| Generated Java compilation | VERIFIED | 19 sources, build success, zero tests |
| Generated Rust masking | VERIFIED | One safe-event masking test passed |
| Default Rust raw trace masking | NOT VERIFIED | Raw logger is separate; evidence test uses `TEAQL_AUDIT_LOG=_silent` |
| KYC and lineage write-back | N/A | Not part of the payment masking demonstration |
| Generated-source repeatability | VERIFIED | Second empty-directory run matched; archives/test additions excluded |
| Invalid-schema/agent failure behavior | PENDING | Tracked in `EVIDENCE_TODO.md` |
| Screenshots and public video | PENDING | Deferred to the human operator |

## Reproduction Phases

### 1. DataHub and MCP

```bash
examples/payment/collect_evidence.sh datahub
python3 mcp_client.py list_tools --jsonl
python3 mcp_client.py get_entities <payment-urn> <user-urn> --jsonl
python3 mcp_client.py get_lineage <payment-urn> --jsonl
```

### 2. Start the Internal TeaQL Generator

From the sibling `teaql-code-gen` checkout on the evidence host:

```bash
java -jar generator/target/generator-1.1.1.jar \
  --server.address=127.0.0.1 \
  --server.port=18080
```

The loopback binding keeps model generation on the remote machine.

### 3. Evaluate and Generate

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

### 4. Build and Test Exact Outputs

```bash
mvn -f examples/payment/07-generated-code/java-lib-core/lib/pom.xml clean test

TEAQL_AUDIT_LOG=_silent cargo test \
  --manifest-path examples/payment/07-generated-code/rust-lib-core/lib/Cargo.toml \
  --locked --offline -- --nocapture
```

The Rust integration test sends a `RawAuditEvent` through `UserContext.send_event`. The context reads the generated `PaymentTransaction` descriptor, builds a `SafeAuditEvent`, and sends it to a registered `SafeAuditEventSink`. The test asserts `masked=true`, `_audit_mask_fields` as the reason, and absence of the synthetic raw account value. It also confirms that `currency_code` remains unmasked.

## Evidence Chain

1. [User prompt](examples/payment/01-user-request.md)
2. [MCP configuration](examples/payment/02-mcp-config.example.json)
3. [MCP JSONL](examples/payment/03-mcp-tool-calls.jsonl)
4. [Consolidated context](examples/payment/04-datahub-context.json)
5. [Canonical model](examples/payment/05-generated-model.xml)
6. [Model decisions](examples/payment/06-model-decisions.md)
7. [Generated code and Rust masking test](examples/payment/07-generated-code/)
8. [Generated source diff](examples/payment/08-generated.diff)
9. [Build/test summary](examples/payment/09-test-summary.md)
10. [Context-to-code map](examples/payment/10-context-to-code-map.md)
11. [Raw execution logs and checksums](examples/payment/run/)

## Security Boundary

The verified claim is specifically about TeaQL's `SafeAuditEvent` path. TeaQL also has a separate default raw trace logger that can contain raw mutation values. The evidence command sets `TEAQL_AUDIT_LOG=_silent` so that raw trace is not written while the safe-event sink is tested. Production deployments must disable or appropriately secure the raw logger; this repository does not claim that the raw trace path is masked.

## Hackathon Scope Disclosure

The TeaQL generator, Java/Rust runtimes, generated-library templates, and large ERP sample existed before this submission. This submission adds the DataHub MCP-to-TeaQL workflow, the payment metadata ingestion and evidence capture, the payment model and regenerated Java/Rust outputs, the Rust safe-event masking integration test, and the reproducibility/evidence scripts under `examples/payment/`.

Use [EVIDENCE.md](EVIDENCE.md) for detailed verification and [EVIDENCE_TODO.md](EVIDENCE_TODO.md) for remaining work. Screenshots and video are intentionally left for the human operator.
