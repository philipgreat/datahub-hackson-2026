# Model Generation Decisions

1. **Entity Name (payment_transaction)**: Mapped DataHub dataset `payment_transactions` to TeaQL entity `payment_transaction`.
2. **Entity Name (user_account)**: Mapped DataHub dataset `fct_users_created` to TeaQL entity `user_account` to satisfy TeaQL domain structure requirements and provide a target for relations.
3. **Schema Mapping**:
   - `payment_account` -> `string()` (from DataHub `VARCHAR`)
   - `currency_code` -> `string()` (from `VARCHAR`)
   - `payment_method` -> `string()` (from `VARCHAR`)
   - `transaction_amount` -> `150.00` (Decimal sample from `DECIMAL`)
   - `user_name` -> `string()` (from `VARCHAR` in `fct_users_created`)
4. **Data Governance & Masking**: The `payment_transactions` dataset description explicitly stated: "包含高度敏感的用户支付账号信息，必须接入审计与脱敏模块。" (Contains highly sensitive user payment accounts, must integrate with audit and data masking modules). Consequently, `_audit_mask_fields="payment_account"` was generated.
5. **No Cross-Dataset Relation**: The captured MCP context contains no foreign key, glossary term, or documented join. A recorded `get_lineage` call reports upstream total `0`. The earlier inferred `payment_account="user_account()"` mapping was therefore removed; the payment field remains a scalar and `user_account` remains an independent entity.
6. **Framework Fields**: `create_time`, `update_time`, IDs, versions, and other generated base properties are TeaQL infrastructure fields, not business fields returned by DataHub.
7. **Negative Check Scope**: No additional application-specific business fields or relationships were added beyond the captured dataset fields. TeaQL infrastructure fields remain explicitly distinguished.
