# Illustrative Evidence Mapping: DataHub MCP to TeaQL Code Generation

> **Evidence status:** The payloads below illustrate the intended metadata-to-code mapping. They are not yet the raw output of the final Docker run. Replace or supplement them with the sanitized artifacts listed in [`EVIDENCE_TODO.md`](EVIDENCE_TODO.md) before describing the workflow as verified.

This project uses the DataHub MCP Server from an external coding agent. The coding agent queries DataHub before writing a TeaQL model; the generated Rust and Java applications are outputs of that development workflow and do not call MCP at runtime.

## 1. Expected MCP Request (Agent Asking for Schema)
During the recorded run, the coding agent should call the `get_entities` tool from the DataHub MCP Server to fetch the schema and privacy tags for `prod.finance.payment_transactions`.

**Agent JSON-RPC Call:**
```json
{
  "jsonrpc": "2.0",
  "id": 1,
  "method": "tools/call",
  "params": {
    "name": "get_entities",
    "arguments": {
      "urns": ["urn:li:dataset:(urn:li:dataPlatform:snowflake,prod.finance.payment_transactions,PROD)"]
    }
  }
}
```

## 2. Illustrative MCP Response
The following fixture represents the DataHub context expected by this example. The final evidence must contain the sanitized response captured from DataHub in Docker.

**DataHub MCP Response:**
```json
{
  "result": [
    {
      "urn": "urn:li:dataset:(urn:li:dataPlatform:snowflake,prod.finance.payment_transactions,PROD)",
      "name": "payment_transactions",
      "properties": {
        "description": "[Hackathon Specific] Enterprise core payment transactions table. Contains highly sensitive user payment accounts, must integrate with audit and data masking modules."
      },
      "schemaMetadata": {
        "platformUrn": "urn:li:dataPlatform:snowflake",
        "fields": [
          {
            "fieldPath": "payment_account",
            "nativeDataType": "VARCHAR",
            "description": "Linked user account ID (PII)",
            "nullable": false
          },
          {
            "fieldPath": "currency_code",
            "nativeDataType": "VARCHAR",
            "description": "Currency (e.g. USD, CNY)",
            "nullable": false
          },
          {
            "fieldPath": "payment_method",
            "nativeDataType": "VARCHAR",
            "description": "Method used (e.g. CREDIT_CARD)",
            "nullable": false
          },
          {
            "fieldPath": "transaction_amount",
            "nativeDataType": "DECIMAL",
            "description": "Total transaction amount",
            "nullable": false
          }
        ]
      }
    }
  ]
}
```

## 3. Expected TeaQL Model
Given the captured context, the coding agent is expected to write the following TeaQL KSML model.

- **Schema grounding**: Business fields should correspond to fields returned by DataHub. The final run must record and explain any transformation or additional framework field.
- **Shift-left governance**: The PII context should cause the agent to add `_audit_mask_fields="payment_account"`. Runtime masking behavior must be demonstrated by a test before it is claimed as verified.

**Generated `models/payment.xml`:**
```xml
  <payment_transaction _name="Payment Transaction"
                       _module="Core"
                       _module_key="core"
                       payment_account="payment_account()"
                       currency_code="USD"
                       payment_method="payment_method()"
                       transaction_amount="150.00"
                       _audit_mask_fields="payment_account"
                       create_time="createTime()"
                       update_time="updateTime()"/>
```

## 4. Multi-Entity Graph and Glossary Mapping to Verify
The final coding-agent run should scan for related datasets and glossary terms and preserve the MCP calls that support the following mapping.

**Expected DataHub MCP discovery:**
- The agent finds the `fct_users_created` dataset in DataHub.
- The agent finds the related glossary term `CustomerAccount`.
- The agent uses captured schema and glossary context to justify the relationship in the TeaQL model.

**Evidence of One-to-One Mapping:**

| DataHub Enterprise Context (Source of Truth) | Generated TeaQL KSML Model (AI Output) | Proof of Alignment |
| :--- | :--- | :--- |
| **Dataset**: `prod.finance.payment_transactions` | `<payment_transaction>` | Entity mapped 1:1. |
| **Field**: `transaction_amount` (DECIMAL) | `transaction_amount="150.00"` | Numeric validation enforced by TeaQL. |
| **Field**: `payment_account` (PII Tagged) | `_audit_mask_fields="payment_account"` | Expected policy mapping; runtime behavior still requires a test. |
| **Dataset**: `fct_users_created` (Hive) | `<user_account>` | Physical table identified and modeled as core entity. |
| **Field**: `user_name` (boolean) | `user_name="boolean()"` | Expected adherence to the captured schema, including its unusual type. |
| **Glossary Term**: `CustomerAccount` | `user_account="user_account()"` in `payment_account` | AI logically linked the `payment_account` to the newly created `user_account` to satisfy the Business Glossary requirement. |

## Verification Goal

The Docker run should establish that the coding-agent workflow:

1. Reads schema fields from DataHub rather than inventing them.
2. Translates captured PII metadata into an explicit TeaQL policy.
3. Uses captured glossary or relationship context to connect physical datasets.
4. Generates code that builds and passes the recorded tests.

Until those artifacts are captured, this document is a review guide rather than proof of a successful run.

## 5. Checked-In ERP Generation Sample (48 Interrelated Entities)
The repository includes a 48-entity ERP model and large generated Rust and Java samples. File and line counts demonstrate output scale only; the clean-container build and test status must be captured separately.

| Microservice Framework / Layer | File Count | Lines of Code | Description |
| :--- | :--- | :--- | :--- |
| `java-lib-core` (Domain) | 250 | 85,363 | Java Core entities, descriptors, metadata, constraints |
| `rust-lib-core` (Domain) | 325 | 184,729 | Rust Core abstractions and safe memory models |
| `java-web-spring-boot` (App) | 4 | 193 | Spring Boot REST API & Application Context |
| `java-web-quarkus` (App) | 4 | 193 | Quarkus Cloud Native Server |
| `java-web-micronaut` (App) | 4 | 189 | Micronaut Ultra-Low Memory Server |
| `java-app-console` (App) | 3 | 174 | Java Command Line Application |
| `rust-web-axum` (App) | 3 | 65 | Rust Axum High Performance Web Service |
| **Total Unique Artifacts** | **593** | **270,906** | Checked-in generation sample; Docker verification pending |
