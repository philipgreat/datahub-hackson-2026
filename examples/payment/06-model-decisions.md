# Model Generation Decisions

1. **Entity Name (payment_transaction)**: Mapped DataHub dataset `payment_transactions` to TeaQL entity `payment_transaction`.
2. **Entity Name (user_account)**: Mapped DataHub dataset `fct_users_created` to TeaQL entity `user_account` to satisfy TeaQL domain structure requirements and provide a target for relations.
3. **Schema Mapping**:
   - `payment_account` -> `user_account()` (Relational reference to the user)
   - `currency_code` -> `string()` (from `VARCHAR`)
   - `payment_method` -> `string()` (from `VARCHAR`)
   - `transaction_amount` -> `150.00` (Decimal sample from `DECIMAL`)
   - `user_name` -> `string()` (from `VARCHAR` in `fct_users_created`)
4. **Data Governance & Masking**: The `payment_transactions` dataset description explicitly stated: "包含高度敏感的用户支付账号信息，必须接入审计与脱敏模块。" (Contains highly sensitive user payment accounts, must integrate with audit and data masking modules). Consequently, `_audit_mask_fields="payment_account"` was generated.
5. **Cross-Dataset Relation (Agent Inference)**: The captured MCP context does not contain a foreign key, lineage edge, glossary term, or documented join connecting `payment_account` to `user_account`. The relation `payment_account="user_account()"` was added by the agent to provide a TeaQL relation target after separately fetching `fct_users_created`; it is not a DataHub-verified relationship. Until relationship metadata is captured, reviewers should treat this mapping as an inference.
6. **Framework Fields**: `create_time`, `update_time`, IDs, versions, and other generated base properties are TeaQL infrastructure fields, not business fields returned by DataHub.
7. **Negative Check Scope**: No additional application-specific business fields were added beyond the captured dataset fields. This does not remove the disclosed relationship inference or TeaQL infrastructure fields.
