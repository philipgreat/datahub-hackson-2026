# Docker Evidence Collection Checklist

Use this checklist during the final run in the clean Docker environment. Evidence should let a reviewer trace one uninterrupted path from DataHub metadata to generated, tested code.

## 1. Record the Environment

- [x] Record the repository commit SHA with `git rev-parse HEAD`.
- [x] Record the Docker image name or Dockerfile digest.
- [x] Record the OS, Java, Maven, Rust, Cargo, Python, Node.js, DataHub, MCP Server, and TeaQL generator versions.
- [x] Record the exact commands used to start DataHub and supporting services.
- [x] Confirm the repository is clean before generation with `git status --short`.
- [x] Save this information to `examples/payment/run/environment.txt`.

## 2. Start and Verify DataHub

- [x] Start the DataHub Docker environment.
- [x] Capture container status and health-check output.
- [x] Run `ingest_payment.py` to load the payment dataset, schema, and sensitivity tags.
- [x] Confirm the target dataset URN exists in DataHub.
- [x] Capture the dataset schema, descriptions, field tags, and glossary terms shown in DataHub.
- [x] If lineage is part of the demo, load and verify the upstream/downstream entities before invoking the coding agent.
- [x] Save sanitized terminal output to `examples/payment/run/datahub-setup.log`.
- [x] Save screenshots to `examples/payment/screenshots/`.

## 3. Record the External Coding-Agent Setup

- [x] Record the coding-agent product and version.
- [x] Add a sanitized example of its DataHub MCP configuration.
- [x] Record the MCP Server command, version, and transport.
- [x] Confirm the coding agent can list the expected DataHub MCP tools.
- [x] Capture the exact user prompt and agent instructions used for model generation.
- [x] Remove tokens, credentials, private URLs, usernames, and unrelated enterprise metadata.
- [x] Save the prompt to `examples/payment/01-user-request.md`.
- [x] Save the sanitized configuration to `examples/payment/02-mcp-config.example.json`.

## 4. Capture MCP Grounding Evidence

- [x] Capture the coding agent calling `get_entities` for the payment dataset.
- [x] Capture `list_schema_fields` if the full schema is not present in the entity response.
- [x] Capture the tags or glossary terms used to derive masking or access-control behavior.
- [x] Capture `get_lineage` if relationships or impact information affect the generated model.
- [x] Preserve timestamps, tool names, arguments, and sanitized responses.
- [x] Save tool calls to `examples/payment/03-mcp-tool-calls.jsonl`.
- [x] Save the consolidated DataHub context to `examples/payment/04-datahub-context.json`.
- [x] Verify that every generated business field can be traced to the captured context.
- [x] Record any agent decision that intentionally ignores or transforms a DataHub field.

## 5. Capture Model Generation

- [x] Remove or move the previous generated model so the new file is demonstrably produced during this run.
- [x] Capture the coding agent writing the TeaQL model from the MCP context.
- [x] Save the generated model to `examples/payment/05-generated-model.xml`.
- [x] Save the agent's concise decision log to `examples/payment/06-model-decisions.md`.
- [x] Verify schema names, types, nullability, relationships, and governance policies against the MCP response.
- [x] Confirm that no unexplained dataset fields were invented.
- [x] Include at least one negative check showing that an absent field was not generated.

## 6. Capture TeaQL Code Generation

- [x] Record the TeaQL generator version and exact invocation.
- [x] Capture generator stdout, stderr, and exit code.
- [x] Generate into an empty output directory.
- [x] Save the generator log to `examples/payment/run/generator.log`.
- [x] Copy a focused, reviewable subset of generated Rust and Java files to `examples/payment/07-generated-code/`.
- [x] Record generated file counts and line counts without presenting line count as a quality metric.
- [x] Capture `git diff --no-index` or an equivalent before/after patch in `examples/payment/08-generated.diff`.

## 7. Build and Test in the Clean Container

- [x] Build the generated Rust domain library.
- [x] Run the Rust application tests.
- [x] Build the generated Java domain library.
- [x] Run the Java application tests without `-DskipTests`.
- [x] Record every command, exit code, test count, pass count, failure count, and duration.
- [x] Save complete logs under `examples/payment/run/build-and-test/`.
- [x] Save a concise summary to `examples/payment/09-test-summary.md`.
- [x] Do not describe untested modules as verified.

## 8. Demonstrate the Metadata-to-Code Effect

- [x] Show the DataHub PII tag that caused `_audit_mask_fields` to appear in the model.
- [x] Show the corresponding generated Rust or Java metadata.
- [x] Run a test that verifies the intended masking behavior, if the runtime supports it.
- [x] If demonstrating KYC, verify the generated/interpreted policy is actually registered in the web runtime and test an allowed and rejected request.
- [x] If demonstrating lineage write-back, capture the actual DataHub API/MCP mutation and verify the resulting lineage in DataHub.
- [x] Otherwise, remove lineage write-back claims from submission materials.
- [x] Save the causal mapping to `examples/payment/10-context-to-code-map.md`.

## 9. Capture Reproducibility and Failure Behavior

- [x] Repeat the generation from a clean checkout or clean output directory.
- [x] Confirm whether identical inputs produce identical output; document expected nondeterminism.
- [x] Test an invalid or incomplete DataHub schema and capture the agent's failure behavior.
- [x] Confirm the agent stops or asks for clarification rather than inventing missing context.
- [x] Record any manual intervention required during the workflow.

## 10. Prepare Submission Evidence

- [x] Replace illustrative payloads in `EVIDENCE.md` with captured, sanitized outputs.
- [x] Add links from the root README to all evidence artifacts.
- [x] Add one architecture diagram and one context-to-code mapping table.
- [x] Record a public demonstration video under three minutes.
- [x] Show the live MCP call, generated model, generated code, and passing test in the video.
- [x] Add the video link to the README and Devpost submission.
- [x] Disclose which TeaQL components existed before the hackathon and which workflow/code was created during the submission period.
- [x] Confirm the repository is public and the Apache 2.0 license is visible.
- [x] Perform a final secret scan before committing evidence.

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
