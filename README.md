# DataHub-Grounded Multi-Language Code Generation

**Hackathon Track: Metadata-Aware Code Generation & Development**

## Project Positioning

This project demonstrates a coding-agent workflow that uses DataHub as the source of enterprise data context before generating application code.

The DataHub MCP Server is connected to an external coding agent. During modeling, the agent queries DataHub for schemas, field types, tags, glossary terms, and relationships. It then uses that context to write a TeaQL model. The TeaQL generator turns the model into strongly typed Rust and Java domain libraries that can be consumed by application workspaces.

The repository contains the models, generated libraries, and sample application workspaces produced by that workflow. The coding agent itself is the MCP client; the generated Rust and Java applications do not need to connect to MCP at runtime.

```text
Developer request
      |
      v
External coding agent ---- DataHub MCP Server ---- DataHub context graph
      |                         schema, tags, glossary, relationships
      v
TeaQL model
      |
      v
TeaQL generator
      |
      +---- Generated Rust/Java domain libraries
      |
      +---- Application workspaces and tests
```

## Why DataHub Matters

Without enterprise context, a coding agent can guess field names, types, relationships, or governance requirements. DataHub gives the agent a queryable source for those decisions.

The intended context-to-code mappings include:

| DataHub context | TeaQL model decision | Generated-code effect |
| --- | --- | --- |
| Dataset schema and field types | Entities, properties, and types | Strongly typed Rust and Java APIs |
| PII or sensitivity tags | `_audit_mask_fields` policy | Masking metadata and policy-aware domain code |
| Business glossary terms | Domain names and relationships | Consistent concepts across languages |
| Dataset relationships and lineage | Entity references | Typed links between generated entities |

The generated-library/workspace split keeps generated domain infrastructure separate from manually maintained application behavior. This is intended to make regeneration predictable and application-layer pull requests easier to review.

## Evidence Status

The checked-in files show the expected model and generated output, but the final Docker-based end-to-end evidence has not yet been collected. Statements about successful MCP calls, generation, compilation, tests, and runtime behavior should be evaluated against the captured run artifacts once they are added.

See [`EVIDENCE.md`](EVIDENCE.md) for the current illustrative mapping and [`EVIDENCE_TODO.md`](EVIDENCE_TODO.md) for the evidence collection checklist.

## Repository Structure

| Directory / File | Type | Description |
| --- | --- | --- |
| `models/` | Model examples | TeaQL models illustrating metadata-grounded payment concepts |
| `massive_erp_model.xml` | Scale example | A 48-entity ERP model used to demonstrate multi-entity generation |
| `java-lib-core` | Generated library | Java domain entities, metadata, expressions, and validation APIs |
| `rust-lib-core` | Generated library | Rust domain entities, metadata, expressions, and validation APIs |
| `java-web-spring-boot` | Application workspace | Spring Boot integration and sample KYC access-control behavior |
| `java-web-quarkus` | Application workspace | Quarkus integration example |
| `java-web-micronaut` | Application workspace | Micronaut integration example |
| `java-app-console` | Application workspace | Java console integration example |
| `rust-web-axum` | Application workspace | Axum integration example |
| `rust-web-topcoat` | Generated example | Alternative Rust web-generation output |
| `rust-app-console` | Application workspace | Rust stream-processing and data-quality example |
| `ingest_payment.py` | DataHub setup script | Loads the sample payment schema and sensitivity tags into DataHub |
| `mcp_client.py` | Diagnostic client | Makes a direct DataHub MCP tool call for troubleshooting |
| `test_mcp.js` | Diagnostic client | Lists MCP tools and requests dataset schema fields |
| `mock_datahub_agent.py` | Offline illustration | Demonstrates the transformation logic with a local metadata fixture; it is not the primary external-agent workflow |
| `run_all.sh` | Draft validation script | Builds project modules; Docker evidence collection must record the final results |
| `docker-compose.yml` | Local services | Provides PostgreSQL and Redis services used by application experiments |

## What Reviewers Should Inspect

Review the project in this order:

1. The MCP request and response captured from the external coding-agent session.
2. The resulting TeaQL model and its field-by-field mapping to DataHub context.
3. The generated Rust and Java domain APIs.
4. The application-layer code that consumes the generated libraries.
5. The clean-container build, test, and runtime evidence.

The large `rust-lib-core` and `java-lib-core` directories are generated outputs. They are included so reviewers can inspect output quality and scale, but application behavior is easier to assess in the smaller workspace modules.

## Validation

Final reproducible commands and verified results will be documented after the Docker run. Until then, use `EVIDENCE_TODO.md` as the authoritative list of evidence that still needs to be captured. No secrets, access tokens, or private DataHub metadata should be committed with the evidence.
