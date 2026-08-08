# DataHub-Grounded Multi-Language Code Generation

**Hackathon Track: Metadata-Aware Code Generation & Development**

## Project Positioning

This project demonstrates a development-time workflow in which an external coding agent queries DataHub through MCP, writes a TeaQL model from the returned context, and invokes the TeaQL online generator to produce Rust and Java domain libraries. The generated applications do not connect to MCP at runtime.

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
TeaQL online generator
      |
      +---- Java domain library
      +---- Rust domain library
```

For the checked-in payment example, MCP returned two datasets and their fields. The payment dataset description requested audit and masking treatment, so the agent added `_audit_mask_fields="payment_account"`. The captured metadata did not contain a foreign key, lineage edge, or glossary term proving that `payment_account` references `user_account`; that relation is disclosed as an agent/TeaQL modeling inference.

## Why DataHub Matters

The verified mappings in this example are deliberately narrow:

| Captured DataHub context | TeaQL decision | Checked-in generated effect |
| --- | --- | --- |
| Dataset and field names | Business entities and properties | Typed Java/Rust domain APIs |
| Native field types | TeaQL scalar types | Generated scalar properties |
| Sensitive payment description | `_audit_mask_fields="payment_account"` | Java and Rust policy metadata |

Glossary-driven relationships and lineage-driven generation are possible extensions, but they were not captured in this evidence run.

## Evidence Status

| Phase | Status | Scope |
| --- | --- | --- |
| MCP `get_entities` capture | VERIFIED | One recorded call for two dataset URNs |
| TeaQL model | PARTIALLY VERIFIED | Fields and masking metadata are grounded; the cross-dataset relation is an inference |
| Online code generation | VERIFIED WITH LIMITATIONS | Logs report successful Java and Rust output; clean-output and repeatability evidence is pending |
| Generated library compilation | VERIFIED | Payment Java and Rust libraries compiled; the Rust log has limited command metadata |
| Payment runtime policy | PENDING | No masking runtime test |
| DataHub lineage/write-back | N/A | Not part of the demonstrated workflow |
| Clean Docker/DataHub health | PENDING | The checked-in setup log is explicitly mocked |

## Repository Build and Evidence Summary Command

The following commands cover ingestion and repository builds only. They do **not** invoke the external coding agent, capture MCP calls, create the TeaQL model, or call the TeaQL online generator.

```bash
python3 ingest_payment.py
./run_all.sh
```

The complete workflow has four separate phases:

1. Start DataHub and ingest metadata.
2. Use an external coding agent to query DataHub MCP and capture the response.
3. Evaluate the TeaQL model and invoke Java/Rust online generation.
4. Compile the exact generated outputs and run any available application tests.

Commands and missing evidence for these phases are tracked in [EVIDENCE_TODO.md](EVIDENCE_TODO.md).

## Captured Environment

The existing [environment record](examples/payment/run/environment.txt) includes the Git SHA, OS, Java, Maven, Cargo, and Python output. It does not establish a clean worktree, Docker image digest, DataHub version, MCP Server version, Node.js version, or TeaQL generator version. Those items remain pending.

## Evidence Chain

1. [User prompt](examples/payment/01-user-request.md)
2. [MCP configuration example](examples/payment/02-mcp-config.example.json)
3. [Raw MCP tool call](examples/payment/03-mcp-tool-calls.jsonl)
4. [Consolidated DataHub context](examples/payment/04-datahub-context.json)
5. [TeaQL model](examples/payment/05-generated-model.xml)
6. [Model decisions](examples/payment/06-model-decisions.md)
7. [Generated Java and Rust code](examples/payment/07-generated-code/)
8. [Recorded generation/change diff](examples/payment/08-generated.diff)
9. [Test and compilation summary](examples/payment/09-test-summary.md)
10. [Context-to-code mapping](examples/payment/10-context-to-code-map.md)
11. [Raw run logs](examples/payment/run/)

## Test Results

- **Payment service Java library:** compilation succeeded; no payment application runtime test is recorded.
- **Payment service Rust library:** compilation succeeded; the current raw log is only a short success summary.
- **Pre-existing ERP Java application:** four direct-instantiation KYC interceptor tests passed. These are not Spring MVC integration or masking tests.
- **Pre-existing ERP Rust console:** one numeric data-quality filter test passed. It does not test masking or lineage.
- **Topcoat:** only `rust-web-topcoat/lib` was compiled. No Topcoat web application workspace was verified.

## Known Limitations

- Online generation depends on `api.teaql.io`; a local generator JAR is not included.
- No captured metadata proves the payment-to-user relationship.
- No payment runtime masking, KYC integration, lineage mutation, deterministic regeneration, invalid-schema behavior, screenshot, or public video evidence is currently checked in.
- The existing `datahub-setup.log` is a mocked status summary, not a Docker health check.

Use [EVIDENCE.md](EVIDENCE.md) for the evidence mapping, [EVIDENCE_FIX.md](EVIDENCE_FIX.md) for static remediation instructions, and [EVIDENCE_TODO.md](EVIDENCE_TODO.md) for work that requires the real Docker/MCP/generator environment.
