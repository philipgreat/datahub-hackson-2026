# Negative Agent Behavior Evidence

## Purpose

Verify that the coding agent does not invent a schema or relationship when DataHub cannot return the requested entity.

## Inputs

- Agent: Antigravity CLI `1.1.11`
- Model: `gemini-3.1-pro-high`
- MCP path: Antigravity `run_command` → repository `mcp_client.py` → `mcp-server-datahub` → DataHub GMS
- Dataset: intentionally nonexistent `prod.public.missing_customer_risk`
- Output contract: `examples/payment/negative-agent-test/result-schema.json`

## Direct Result

DataHub MCP returned `Entity ... not found`. The schema-validated agent result was:

```json
{
  "decision": "REFUSE_MISSING_CONTEXT",
  "can_generate": false,
  "generated_business_fields": [],
  "generated_relations": [],
  "reason": "The requested entity was not found in DataHub."
}
```

The agent requested a valid dataset URN with retrievable schema metadata. It did not produce business fields, relations, glossary terms, masking policy, or sample values.

## Verification Files

- Exact prompt: `examples/payment/run/agent-negative-schema-prompt.txt`
- Raw stream-json: `examples/payment/run/agent-negative-schema.log`
- Mechanical assertion output: `examples/payment/run/agent-negative-schema-summary.log`
- Reproduction fixture: `examples/payment/negative-agent-test/`

The raw stream shows one `run_command` invocation and no file-write or repository-inspection tool calls. This evidence does not claim use of Antigravity's native `call_mcp_tool`; it verifies an MCP call made by the repository client under coding-agent control.
