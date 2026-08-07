---
name: datahub-to-teaql
description: "Model and generate a TeaQL Java or Rust application driven entirely by DataHub enterprise metadata. Mandatory order: Query DataHub MCP for schemas and privacy tags, draft the KSML model ensuring strict schema alignment and PII compliance, evaluate via the online TeaQL API, repair until zero errors, and finally generate the output libraries."
---

# DataHub to TeaQL Agent Skill

Turn enterprise metadata sourced from DataHub into a verified TeaQL application. This workflow bridges enterprise data governance (DataHub) and runtime application logic (TeaQL).

## Mandatory Workflow Order

Do not reorder these stages:

1. **Query DataHub MCP**: Use the DataHub MCP client to retrieve dataset schemas, glossaries, and lineage.
2. **Draft the KSML Model**: Translate the DataHub metadata into a TeaQL XML model. You must strictly align with the schema.
3. **Evaluate the Model**: Verify the model using the TeaQL Maven Plugin (`teaql-maven-plugin:1.1.0:eval`).
4. **Repair Model**: Fix reported errors and evaluate again until zero errors are reached.
5. **Generate Code**: Use the TeaQL API (`teaql-maven-plugin` and `cargo-teaql`) to generate the Rust and Java libraries.
6. **Compile and Verify**: Run application tests against the generated libraries to prove runtime compliance.

## 1. Query DataHub Context

Before drafting any model, query the external DataHub MCP server for the target dataset's metadata.

- Use the MCP `get_entities` tool (e.g., via `python3 mcp_client.py` or equivalent direct call).
- Inspect the returned schema, descriptions, and privacy context (PII tags).
- **Rule**: Do NOT invent fields. The model MUST mirror the returned DataHub fields.

## 2. Draft the KSML Model

Construct the TeaQL model based on the captured MCP response.

- Apply the standard KSML structure: root `name` (e.g., `payment-service`), `data_service="sqlite"`, `org="example"`.
- Map each DataHub dataset to a TeaQL `<entity>` (or lowercase business object node).
- **Shift-left governance**: If the DataHub description or tags indicate sensitive/PII data, you MUST add `_audit_mask_fields="field_name"` to the corresponding entity.
- If the schema has relations or glossary mapping, create linked objects in the model (e.g., `<user_account>`).
- Save the drafted model to `examples/payment/05-generated-model.xml` or similar workspace.

## 3. Evaluate and Repair the Model

Do not attempt to generate code from an unchecked model. Use the TeaQL online API to evaluate it.

```bash
mvn io.teaql:teaql-maven-plugin:1.1.0:eval -Dinput=/path/to/your/model.xml
```

- Parse the evaluation report. Fix any `❌ Errors (Must Fix)`.
- Re-run the evaluation until `Errors: 0` is reached.
- Ensure references are intact and avoid language keyword collisions (use two-word entity/field names like `payment_transaction`).

## 4. Generate Domain Libraries

Once the model is error-free, generate the target libraries using the TeaQL online service.

### Java Generation
```bash
mvn io.teaql:teaql-maven-plugin:1.1.0:generate -Dservice=java-lib-core \
  -Dinput=/path/to/your/model.xml \
  -Dteaql.output=/path/to/output/java-lib-core
```

### Rust Generation
```bash
cargo teaql --input /path/to/your/model.xml rust-lib-core \
  --output /path/to/output/rust-lib-core \
  --cwd /path/to/output/
```

## 5. Verify the Implementation

- The generated library should compile natively.
- Run your application workspace test script (e.g. `./run_all.sh`).
- Confirm that the tests pass and that the DataHub-originated policies (such as Data Masking / PII) are demonstrably enforced at runtime.
