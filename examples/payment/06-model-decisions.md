# Model Generation Decisions

1. **Entity Name**: Mapped DataHub dataset `payment_transactions` to TeaQL entity `PaymentTransaction`.
2. **Schema Mapping**:
   - `payment_account` -> `String` (from `VARCHAR`)
   - `currency_code` -> `String` (from `VARCHAR`)
   - `payment_method` -> `String` (from `VARCHAR`)
   - `transaction_amount` -> `Decimal` (from `DECIMAL`)
3. **Nullability**: All fields were marked `nullable: false` in DataHub, so they are mapped with `required="true"`.
4. **Data Governance & Masking**: Although the GraphQL `tags` array returned empty, the dataset `description` explicitly stated: "包含高度敏感的用户支付账号信息，必须接入审计与脱敏模块。" (Contains highly sensitive user payment accounts, must integrate with audit and data masking modules). Consequently, `_audit_mask_fields="payment_account"` was generated.
5. **Negative Check**: No unexplained fields (e.g., `user_id`, `created_at`) were invented, adhering strictly to the `zero-hallucination` schema-grounded requirement.
