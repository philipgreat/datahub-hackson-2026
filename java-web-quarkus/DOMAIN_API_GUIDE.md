
**ATTENTION AI AGENTS:** Do not guess TeaQL API methods! To get the exact API usage and query examples for the entity you are working on, you must fetch the dynamically generated prompt directly from the code generation server. Use your tools to execute the following command to download the exact contextual prompt for the entity:

```bash
cargo teaql --input models/enterprise-erp-system.xml java-assist-[action]/[entity-name]
```

Replace `[entity-name]` with the exact entity-name of the entity.

**Available candidate entities in this model:**

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


Replace `[action]` with one of the following depending on what you are trying to write:

| action | when-to-use |
|--------|-------------|
| query | You need to read/find records from the database using Q:: |
| create | You need to insert a new record into the database |
| update | You need to modify and save an existing record |
| delete | You need to remove or soft-delete a record |
| expression | You need to safely extract nested relation values (avoiding null panics) using the E:: facade |
| list-page | You need to implement a paginated query returning a SmartList |

Once the command succeeds, read its output. Use the printed code as a template to write your logic.