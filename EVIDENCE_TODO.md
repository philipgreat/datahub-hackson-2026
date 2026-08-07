# Docker Evidence Collection Checklist

Use this checklist during the final run in the clean Docker environment. Evidence should let a reviewer trace one uninterrupted path from DataHub metadata to generated, tested code.

## 1. Record the Environment

- [ ] Record the repository commit SHA with `git rev-parse HEAD`.
- [ ] Record the Docker image name or Dockerfile digest.
- [ ] Record the OS, Java, Maven, Rust, Cargo, Python, Node.js, DataHub, MCP Server, and TeaQL generator versions.
- [ ] Record the exact commands used to start DataHub and supporting services.
- [ ] Confirm the repository is clean before generation with `git status --short`.
- [ ] Save this information to `examples/payment/run/environment.txt`.

## 2. Start and Verify DataHub

- [ ] Start the DataHub Docker environment.
- [ ] Capture container status and health-check output.
- [ ] Run `ingest_payment.py` to load the payment dataset, schema, and sensitivity tags.
- [ ] Confirm the target dataset URN exists in DataHub.
- [ ] Capture the dataset schema, descriptions, field tags, and glossary terms shown in DataHub.
- [ ] If lineage is part of the demo, load and verify the upstream/downstream entities before invoking the coding agent.
- [ ] Save sanitized terminal output to `examples/payment/run/datahub-setup.log`.
- [ ] Save screenshots to `examples/payment/screenshots/`.

## 3. Record the External Coding-Agent Setup

- [ ] Record the coding-agent product and version.
- [ ] Add a sanitized example of its DataHub MCP configuration.
- [ ] Record the MCP Server command, version, and transport.
- [ ] Confirm the coding agent can list the expected DataHub MCP tools.
- [ ] Capture the exact user prompt and agent instructions used for model generation.
- [ ] Remove tokens, credentials, private URLs, usernames, and unrelated enterprise metadata.
- [ ] Save the prompt to `examples/payment/01-user-request.md`.
- [ ] Save the sanitized configuration to `examples/payment/02-mcp-config.example.json`.

## 4. Capture MCP Grounding Evidence

- [ ] Capture the coding agent calling `get_entities` for the payment dataset.
- [ ] Capture `list_schema_fields` if the full schema is not present in the entity response.
- [ ] Capture the tags or glossary terms used to derive masking or access-control behavior.
- [ ] Capture `get_lineage` if relationships or impact information affect the generated model.
- [ ] Preserve timestamps, tool names, arguments, and sanitized responses.
- [ ] Save tool calls to `examples/payment/03-mcp-tool-calls.jsonl`.
- [ ] Save the consolidated DataHub context to `examples/payment/04-datahub-context.json`.
- [ ] Verify that every generated business field can be traced to the captured context.
- [ ] Record any agent decision that intentionally ignores or transforms a DataHub field.

## 5. Capture Model Generation

- [ ] Remove or move the previous generated model so the new file is demonstrably produced during this run.
- [ ] Capture the coding agent writing the TeaQL model from the MCP context.
- [ ] Save the generated model to `examples/payment/05-generated-model.xml`.
- [ ] Save the agent's concise decision log to `examples/payment/06-model-decisions.md`.
- [ ] Verify schema names, types, nullability, relationships, and governance policies against the MCP response.
- [ ] Confirm that no unexplained dataset fields were invented.
- [ ] Include at least one negative check showing that an absent field was not generated.

## 6. Capture TeaQL Code Generation

- [ ] Record the TeaQL generator version and exact invocation.
- [ ] Capture generator stdout, stderr, and exit code.
- [ ] Generate into an empty output directory.
- [ ] Save the generator log to `examples/payment/run/generator.log`.
- [ ] Copy a focused, reviewable subset of generated Rust and Java files to `examples/payment/07-generated-code/`.
- [ ] Record generated file counts and line counts without presenting line count as a quality metric.
- [ ] Capture `git diff --no-index` or an equivalent before/after patch in `examples/payment/08-generated.diff`.

## 7. Build and Test in the Clean Container

- [ ] Build the generated Rust domain library.
- [ ] Run the Rust application tests.
- [ ] Build the generated Java domain library.
- [ ] Run the Java application tests without `-DskipTests`.
- [ ] Record every command, exit code, test count, pass count, failure count, and duration.
- [ ] Save complete logs under `examples/payment/run/build-and-test/`.
- [ ] Save a concise summary to `examples/payment/09-test-summary.md`.
- [ ] Do not describe untested modules as verified.

## 8. Demonstrate the Metadata-to-Code Effect

- [ ] Show the DataHub PII tag that caused `_audit_mask_fields` to appear in the model.
- [ ] Show the corresponding generated Rust or Java metadata.
- [ ] Run a test that verifies the intended masking behavior, if the runtime supports it.
- [ ] If demonstrating KYC, verify the generated/interpreted policy is actually registered in the web runtime and test an allowed and rejected request.
- [ ] If demonstrating lineage write-back, capture the actual DataHub API/MCP mutation and verify the resulting lineage in DataHub.
- [ ] Otherwise, remove lineage write-back claims from submission materials.
- [ ] Save the causal mapping to `examples/payment/10-context-to-code-map.md`.

## 9. Capture Reproducibility and Failure Behavior

- [ ] Repeat the generation from a clean checkout or clean output directory.
- [ ] Confirm whether identical inputs produce identical output; document expected nondeterminism.
- [ ] Test an invalid or incomplete DataHub schema and capture the agent's failure behavior.
- [ ] Confirm the agent stops or asks for clarification rather than inventing missing context.
- [ ] Record any manual intervention required during the workflow.

## 10. Prepare Submission Evidence

- [ ] Replace illustrative payloads in `EVIDENCE.md` with captured, sanitized outputs.
- [ ] Add links from the root README to all evidence artifacts.
- [ ] Add one architecture diagram and one context-to-code mapping table.
- [ ] Record a public demonstration video under three minutes.
- [ ] Show the live MCP call, generated model, generated code, and passing test in the video.
- [ ] Add the video link to the README and Devpost submission.
- [ ] Disclose which TeaQL components existed before the hackathon and which workflow/code was created during the submission period.
- [ ] Confirm the repository is public and the Apache 2.0 license is visible.
- [ ] Perform a final secret scan before committing evidence.

## Expected Evidence Layout

```text
examples/payment/
├── 01-user-request.md
├── 02-mcp-config.example.json
├── 03-mcp-tool-calls.jsonl
├── 04-datahub-context.json
├── 05-generated-model.xml
├── 06-model-decisions.md
├── 07-generated-code/
├── 08-generated.diff
├── 09-test-summary.md
├── 10-context-to-code-map.md
├── run/
│   ├── environment.txt
│   ├── datahub-setup.log
│   ├── generator.log
│   └── build-and-test/
└── screenshots/
```

## Completion Rule

Only change wording such as "illustrative," "expected," or "pending verification" to "verified" after the corresponding raw artifact, command, and successful exit status have been committed.
