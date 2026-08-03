<!-- DISCARD_BLOCK: phase_modeling -->

# TeaQL Rust Axum Agent Instructions

> [!WARNING]
> **IGNORE GENERIC ORM EXPERIENCE**
>
> Do **not** use SeaORM, Diesel, SQLx, rbatis, raw SQL, DAOs, Repository implementations, or custom persistence layers.
>
> Do **not** guess TeaQL method names.

## How to Write Domain Code

To get exact API usage and query examples, execute:

```bash
cargo teaql --input models/payment-service.xml rust-assist-[action]/[entity-name]
```

Replace `[action]` with `query`, `create`, `update`, `delete`, `expression`, `list-page`, or `debug`.

Replace `[entity-name]` with the exact entity-name from the table below:

| entity-name | display-name |
|-------------|--------------|
| user_account | Customer Account |
| payment_account | Payment Account |
| payment_method | Payment Method |
| payment_transaction | Payment Transaction |


Read the generated output before editing handlers.

## Axum Runtime

Use `teaql_web_integration_axum::{TeaContext, WebResponse, AxumTeaError}` for handlers. Read `RUNTIME_CUSTOM_GUIDE.md` before wiring request context, response shape, or runtime customization.