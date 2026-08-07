<!-- DISCARD_BLOCK: phase_modeling -->

# TeaQL Java Agent Instructions

> [!WARNING]
> **IGNORE GENERIC ORM EXPERIENCE**
>
> Do **not** use pre-trained habits from data-access frameworks, ORMs, or database integration libraries.
>
> Do **not** use MyBatis, JPA, Hibernate, Spring Data, MyBatis-Plus, or similar frameworks.
>
> Do **not** write raw SQL, DAOs, Repository implementations, or custom persistence layers.
>
> Do **not** guess TeaQL method names.

## How to Write Domain Code

To get the exact API usage and query examples for the entity you are working on, execute the following command:

```bash
cargo teaql --input models/enterprise-erp-system.xml java-assist-[action]/[entity-name]
```

> `models/enterprise-erp-system.xml` is the default model path. If the model file is located elsewhere, adjust the `--input` path to match the actual file location in this project.

Replace `[action]` with one of the following:

| action | when-to-use |
|--------|-------------|
| query | Read/find records from the database using Q. |
| create | Insert a new record into the database |
| update | Modify and save an existing record |
| delete | Remove or soft-delete a record |
| expression | Safely extract nested relation values using E. |
| list-page | Implement a paginated query returning SmartList |
| debug | View instructions for enabling SQL logging and debugging |

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


Once the command succeeds, read its output. Use the printed code as a template to write your logic.

If the command cannot be executed, stop and report the missing context. Do not invent APIs.

## Additional References

Read these only when the task requires them:

* **`TOOL_API_GUIDE.md`**
  Framework runtime references and context handling.

* **`RUNTIME_CUSTOM_GUIDE.md`**
  Runtime setup, debugging, and project-specific restrictions.