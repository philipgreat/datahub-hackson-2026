
# TeaQL Java CRUD Guide

Generated for `com.example.enterpriseerpsystem`. Use this guide when adding controllers, services, jobs, or integration code in this workspace.

## Setup

```java
import com.example.enterpriseerpsystem.Q;
import com.example.enterpriseerpsystem.EnterpriseErpSystemUserContext;
import io.teaql.core.web.WebResponse;
```

Most workspace code receives a TeaQL context from Spring:

```java
public WebResponse handle(@TQLContext UserContext userContext) {
    // use Q, WebResponse, and entity.auditAs("comment").save(userContext)
}
```

## Non-Negotiable Database Rule

Never use SQL to operate on the database from workspace business code. This includes select, insert, update, delete, schema changes, JDBC templates, native queries, direct repositories, and ad hoc SQL helpers.

If the generated TeaQL API does not provide a path for the requested change, stop and report the missing API. Do not implement a SQL workaround.

## Mandatory Update Method Rule

Use generated `updateXxx(...)` methods for all entity field changes. Do not use `setXxx(...)` in new code. Setters are deprecated even when the IDE or generated class makes them visible.

```java
entity.updateName("new value");
```

Do not write:

```java
entity.setName("new value");
```

## Read One Entity

Prefer typed generated query entry points. Controller methods that return one object should wrap the result in `WebResponse.of(...)`:

```java
public WebResponse getOne(@TQLContext UserContext userContext, Long id) {
    try {
        var entity = Q.customers()
            .filterById(id)
            .selectSelf()
            .comment("load detail by id")
            .purpose("get task detail")
            .executeForOne(userContext);
        return WebResponse.of(entity);
    } catch (Exception e) {
        return WebResponse.fail(e.getMessage());
    }
}
```

## Read A Page

Controller methods that return multiple objects should wrap the list in `WebResponse.of(...)`:

```java
public WebResponse list(@TQLContext UserContext userContext) {
    try {
        var list = Q.customers()
            .selectSelf()
            .page(1, 20)
            .comment("list tasks")
            .purpose("render dashboard list")
            .executeForList(userContext);
        return WebResponse.of(list);
    } catch (Exception e) {
        return WebResponse.fail(e.getMessage());
    }
}
```

## Create

```java
var entity = new Customer();
// Fill fields with generated updateXxx(...) methods, not setXxx(...).
entity.auditAs("Create new item").save(userContext);
```

## Update

```java
var entity = Q.customers()
    .filterById(id)
    .selectSelf()
    .comment("load for update")
    .purpose("edit entity")
    .executeForOne(userContext);

// Use updateXxx(...) methods for state changes.
// entity.updateName("new value");
entity.auditAs("Update entity properties").save(userContext);
```

## Load Relations

Use generated selectors. Do not write a loop that queries children one row at a time. The examples below focus on the entities with the highest reverse relation counts because they are stronger aggregate-root candidates.

```java
var list = Q.customers()
    .selectContactListWith(Q.contacts().selectSelf())
    .comment("load with contactList")
    .purpose("fetch child contactList")
    .executeForList(userContext);
```

```java
var list = Q.customers()
    .selectContractListWith(Q.contracts().selectSelf())
    .comment("load with contractList")
    .purpose("fetch child contractList")
    .executeForList(userContext);
```

```java
var list = Q.customers()
    .selectProductReviewListWith(Q.productReviews().selectSelf())
    .comment("load with productReviewList")
    .purpose("fetch child productReviewList")
    .executeForList(userContext);
```

```java
var list = Q.customers()
    .selectShoppingCartListWith(Q.shoppingCarts().selectSelf())
    .comment("load with shoppingCartList")
    .purpose("fetch child shoppingCartList")
    .executeForList(userContext);
```

```java
var list = Q.customers()
    .selectGlobalOrderListWith(Q.globalOrders().selectSelf())
    .comment("load with globalOrderList")
    .purpose("fetch child globalOrderList")
    .executeForList(userContext);
```

```java
var list = Q.customers()
    .selectWishlistListWith(Q.wishlists().selectSelf())
    .comment("load with wishlistList")
    .purpose("fetch child wishlistList")
    .executeForList(userContext);
```

```java
var list = Q.customers()
    .selectInvoiceListWith(Q.invoices().selectSelf())
    .comment("load with invoiceList")
    .purpose("fetch child invoiceList")
    .executeForList(userContext);
```

```java
var list = Q.customers()
    .selectReturnRequestListWith(Q.returnRequests().selectSelf())
    .comment("load with returnRequestList")
    .purpose("fetch child returnRequestList")
    .executeForList(userContext);
```

```java
var list = Q.customers()
    .selectTicketListWith(Q.tickets().selectSelf())
    .comment("load with ticketList")
    .purpose("fetch child ticketList")
    .executeForList(userContext);
```

```java
var list = Q.employees()
    .selectDepartmentWith(Q.departments().selectSelf())
    .comment("load with department")
    .purpose("fetch associated department")
    .executeForList(userContext);
```





```java
var list = Q.employees()
    .selectLeaveRequestListWith(Q.leaveRequests().selectSelf())
    .comment("load with leaveRequestList")
    .purpose("fetch child leaveRequestList")
    .executeForList(userContext);
```

```java
var list = Q.employees()
    .selectAttendanceListWith(Q.attendances().selectSelf())
    .comment("load with attendanceList")
    .purpose("fetch child attendanceList")
    .executeForList(userContext);
```

```java
var list = Q.employees()
    .selectBenefitListWith(Q.benefits().selectSelf())
    .comment("load with benefitList")
    .purpose("fetch child benefitList")
    .executeForList(userContext);
```

```java
var list = Q.employees()
    .selectEmployeeReviewListWith(Q.employeeReviews().selectSelf())
    .comment("load with employeeReviewList")
    .purpose("fetch child employeeReviewList")
    .executeForList(userContext);
```

```java
var list = Q.employees()
    .selectPayrollListWith(Q.payrolls().selectSelf())
    .comment("load with payrollList")
    .purpose("fetch child payrollList")
    .executeForList(userContext);
```

```java
var list = Q.employees()
    .selectExpenseListWith(Q.expenses().selectSelf())
    .comment("load with expenseList")
    .purpose("fetch child expenseList")
    .executeForList(userContext);
```

```java
var list = Q.employees()
    .selectSupportAgentListWith(Q.supportAgents().selectSelf())
    .comment("load with supportAgentList")
    .purpose("fetch child supportAgentList")
    .executeForList(userContext);
```

```java
var list = Q.products()
    .selectCategoryWith(Q.categories().selectSelf())
    .comment("load with category")
    .purpose("fetch associated category")
    .executeForList(userContext);
```







```java
var list = Q.products()
    .selectProductReviewListWith(Q.productReviews().selectSelf())
    .comment("load with productReviewList")
    .purpose("fetch child productReviewList")
    .executeForList(userContext);
```

```java
var list = Q.products()
    .selectCartItemListWith(Q.cartItems().selectSelf())
    .comment("load with cartItemList")
    .purpose("fetch child cartItemList")
    .executeForList(userContext);
```

```java
var list = Q.products()
    .selectOrderItemListWith(Q.orderItems().selectSelf())
    .comment("load with orderItemList")
    .purpose("fetch child orderItemList")
    .executeForList(userContext);
```

```java
var list = Q.products()
    .selectInventoryItemListWith(Q.inventoryItems().selectSelf())
    .comment("load with inventoryItemList")
    .purpose("fetch child inventoryItemList")
    .executeForList(userContext);
```

```java
var list = Q.products()
    .selectPurchaseOrderItemListWith(Q.purchaseOrderItems().selectSelf())
    .comment("load with purchaseOrderItemList")
    .purpose("fetch child purchaseOrderItemList")
    .executeForList(userContext);
```


## Delete

Use the generated TeaQL soft-delete API available on the entity/request class in this domain. If unsure, inspect the generated request class for the target entity and use the soft-delete operation it exposes.

Do not hard-delete rows. Do not write SQL `DELETE` or `UPDATE` statements. If the soft-delete API is not visible, stop and report that blocker instead of changing data through SQL.

## Common Mistakes

- Do not instantiate repositories directly in workspace business code.
- Do not use SQL for any database operation.
- Do not use deprecated `setXxx(...)` methods for updates. Use `updateXxx(...)`.
- Do not return raw entities or lists from controller query methods. Return `WebResponse.of(entity)` or `WebResponse.of(list)`.
- Do not forget `.executeForOne(userContext)` or `.executeForList(userContext)`.
- Do not forget `.comment("...")` and `.purpose("...")` on queries.
- Do not forget `.auditAs("...")` before calling `.save(ctx)` on entities.
- Do not assume relations are loaded unless the query selected them.
- Do not bypass `UserContext`; context carries logging, tenant, security, and repository resolution behavior.

## Entity Cheat Sheet

These entities are selected by reverse relation count, not by model declaration order.

- `Customer`: reverse relations `9`, query `Q.customers()`, save `new Customer().auditAs("comment").save(userContext)`, request `com.example.enterpriseerpsystem.customer.CustomerRequest`
- `Employee`: reverse relations `7`, query `Q.employees()`, save `new Employee().auditAs("comment").save(userContext)`, request `com.example.enterpriseerpsystem.employee.EmployeeRequest`
- `Product`: reverse relations `5`, query `Q.products()`, save `new Product().auditAs("comment").save(userContext)`, request `com.example.enterpriseerpsystem.product.ProductRequest`