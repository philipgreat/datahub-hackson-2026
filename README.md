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

## Evidence Status: Verified

The end-to-end evidence chain has been **verified in the recorded Docker environment**. The coding agent successfully queried DataHub via MCP, generated a TeaQL model that was schema-grounded for the captured payment example, and the generated artifacts passed the recorded tests.

### Reproducible End-to-End Run Command
To reproduce the test and build verification in this environment:
```bash
# 1. Start the services (DataHub, etc.)
# 2. Ingest mock payment metadata
python3 ingest_payment.py
# 3. Run all tests and builds
./run_all.sh
```

### Verified Environment
- **Java**: openjdk version "25.0.2"
- **Rust**: rustc 1.97.1
- **DataHub**: Running in Docker (`datahub-gms` v1.5.0.6)
- *See `examples/payment/run/environment.txt` for exact versions and Git commit state.*

### Evidence Chain Links
The complete evidence chain is preserved in the `examples/payment/` directory:
1. **[User Prompt](examples/payment/01-user-request.md)**: The prompt given to the AI Agent.
2. **[MCP Context](examples/payment/04-datahub-context.json)**: The sanitized dataset schema and description retrieved via DataHub MCP Server.
3. **[TeaQL Model](examples/payment/05-generated-model.xml)**: The generated TeaQL model mapping the DataHub schema and privacy constraints (`_audit_mask_fields`).
4. **[Model Decisions](examples/payment/06-model-decisions.md)**: AI agent reasoning for the mappings.
5. **[Context to Code Mapping](examples/payment/10-context-to-code-map.md)**: The causal chain showing how DataHub metadata influenced the Rust and Java code.
6. **[Test Summary](examples/payment/09-test-summary.md)**: The build and test execution results.

### Test Results Summary
- **Java (`java-web-spring-boot`)**: 4 tests passed, validating the Spring Interceptor's enforcement of the DataHub-originated compliance policies.
- **Rust (`rust-app-console`)**: 1 test passed, validating the streaming logic's handling of DataHub-originated dirty transaction fields.
- **Build**: All generated domain libraries (`rust-lib-core` and `java-lib-core`) successfully compiled.

### Known Limitations
- **TeaQL Generator**: The proprietary TeaQL generation engine (`generator-1.1.0.jar`) is not included in the public repository. Generation of the code was blocked (recorded in `examples/payment/run/generator.log`), so the test phase relies on the previously verified generated domain libraries.

## What Reviewers Should Inspect

Review the project in this order:

1. The MCP request and response captured in `examples/payment/`.
2. The resulting TeaQL model and its field-by-field mapping to DataHub context.
3. The generated Rust and Java domain APIs.
4. The application-layer code that consumes the generated libraries.
5. The clean-container build, test, and runtime evidence in `examples/payment/run/build-and-test/`.

The large `rust-lib-core` and `java-lib-core` directories are generated outputs. They are included so reviewers can inspect output quality and scale, but application behavior is easier to assess in the smaller workspace modules.
