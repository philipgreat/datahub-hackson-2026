# User Request

**Prompt given to the AI Agent:**

"Generate a complete TeaQL domain model for the enterprise payment subsystem. Query the DataHub MCP Server for the dataset URNs: `urn:li:dataset:(urn:li:dataPlatform:snowflake,prod.finance.payment_transactions,PROD)` and `urn:li:dataset:(urn:li:dataPlatform:hive,fct_users_created,PROD)`.
Ensure that all fields, types, and descriptions are mapped accurately. If DataHub identifies any highly sensitive PII fields (via tags or description), ensure that the `_audit_mask_fields` TeaQL attribute is generated to enforce Shift-Left Security masking rules. Do not hallucinate fields that do not exist in DataHub."
