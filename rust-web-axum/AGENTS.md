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
cargo teaql --input models/enterprise-erp-system.xml rust-assist-[action]/[entity-name]
```

Replace `[action]` with `query`, `create`, `update`, `delete`, `expression`, `list-page`, or `debug`.

Replace `[entity-name]` with the exact entity-name from the table below:

| entity-name | display-name |
|-------------|--------------|
| employee | Employee |
| department | Department |
| position | Position |
| leave_request | Leave Request |
| attendance | Attendance |
| benefit | Benefit |
| employee_review | Employee Review |
| payroll | Payroll |
| customer | Customer |
| lead | Lead |
| opportunity | Opportunity |
| contact | Contact |
| campaign | Campaign |
| contract | Contract |
| quote | Quote |
| sales_territory | Sales Territory |
| product | Product |
| category | Category |
| catalog | Catalog |
| product_review | Product Review |
| shopping_cart | Shopping Cart |
| cart_item | Cart Item |
| global_order | Global Order |
| order_item | Order Item |
| wishlist | Wishlist |
| promotion | Promotion |
| coupon | Coupon |
| invoice | Invoice |
| payment | Payment |
| refund | Refund |
| account | Account |
| transaction | Transaction |
| tax_rate | Tax Rate |
| expense | Expense |
| ledger | Ledger |
| supplier | Supplier |
| warehouse | Warehouse |
| inventory_item | Inventory Item |
| purchase_order | Purchase Order |
| purchase_order_item | Purchase Order Item |
| shipment | Shipment |
| delivery | Delivery |
| return_request | Return Request |
| ticket | Ticket |
| ticket_comment | Ticket Comment |
| sla | Sla |
| knowledge_base | Knowledge Base |
| support_agent | Support Agent |


Read the generated output before editing handlers.

## Axum Runtime

Use `teaql_web_integration_axum::{TeaContext, WebResponse, AxumTeaError}` for handlers. Read `RUNTIME_CUSTOM_GUIDE.md` before wiring request context, response shape, or runtime customization.