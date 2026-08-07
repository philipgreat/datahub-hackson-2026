
package com.example.enterpriseerpsystem;

import io.teaql.core.criteria.Operator;

public class Q  {
  public static com.example.enterpriseerpsystem.employee.EmployeeRequest<com.example.enterpriseerpsystem.employee.Employee> employees(){
      return new com.example.enterpriseerpsystem.employee.EmployeeRequest(com.example.enterpriseerpsystem.employee.Employee.class).selectSelf().withVersion(Operator.GREATER_THAN, 0l);
  }
  public static com.example.enterpriseerpsystem.employee.EmployeeRequest<com.example.enterpriseerpsystem.employee.Employee> employeesWithMinimalFields(){
      return new com.example.enterpriseerpsystem.employee.EmployeeRequest(com.example.enterpriseerpsystem.employee.Employee.class).withVersion(Operator.GREATER_THAN, 0l);
  }


  public static com.example.enterpriseerpsystem.department.DepartmentRequest<com.example.enterpriseerpsystem.department.Department> departments(){
      return new com.example.enterpriseerpsystem.department.DepartmentRequest(com.example.enterpriseerpsystem.department.Department.class).selectSelf().withVersion(Operator.GREATER_THAN, 0l);
  }
  public static com.example.enterpriseerpsystem.department.DepartmentRequest<com.example.enterpriseerpsystem.department.Department> departmentsWithMinimalFields(){
      return new com.example.enterpriseerpsystem.department.DepartmentRequest(com.example.enterpriseerpsystem.department.Department.class).withVersion(Operator.GREATER_THAN, 0l);
  }


  public static com.example.enterpriseerpsystem.position.PositionRequest<com.example.enterpriseerpsystem.position.Position> positions(){
      return new com.example.enterpriseerpsystem.position.PositionRequest(com.example.enterpriseerpsystem.position.Position.class).selectSelf().withVersion(Operator.GREATER_THAN, 0l);
  }
  public static com.example.enterpriseerpsystem.position.PositionRequest<com.example.enterpriseerpsystem.position.Position> positionsWithMinimalFields(){
      return new com.example.enterpriseerpsystem.position.PositionRequest(com.example.enterpriseerpsystem.position.Position.class).withVersion(Operator.GREATER_THAN, 0l);
  }


  public static com.example.enterpriseerpsystem.leaverequest.LeaveRequestRequest<com.example.enterpriseerpsystem.leaverequest.LeaveRequest> leaveRequests(){
      return new com.example.enterpriseerpsystem.leaverequest.LeaveRequestRequest(com.example.enterpriseerpsystem.leaverequest.LeaveRequest.class).selectSelf().withVersion(Operator.GREATER_THAN, 0l);
  }
  public static com.example.enterpriseerpsystem.leaverequest.LeaveRequestRequest<com.example.enterpriseerpsystem.leaverequest.LeaveRequest> leaveRequestsWithMinimalFields(){
      return new com.example.enterpriseerpsystem.leaverequest.LeaveRequestRequest(com.example.enterpriseerpsystem.leaverequest.LeaveRequest.class).withVersion(Operator.GREATER_THAN, 0l);
  }


  public static com.example.enterpriseerpsystem.attendance.AttendanceRequest<com.example.enterpriseerpsystem.attendance.Attendance> attendances(){
      return new com.example.enterpriseerpsystem.attendance.AttendanceRequest(com.example.enterpriseerpsystem.attendance.Attendance.class).selectSelf().withVersion(Operator.GREATER_THAN, 0l);
  }
  public static com.example.enterpriseerpsystem.attendance.AttendanceRequest<com.example.enterpriseerpsystem.attendance.Attendance> attendancesWithMinimalFields(){
      return new com.example.enterpriseerpsystem.attendance.AttendanceRequest(com.example.enterpriseerpsystem.attendance.Attendance.class).withVersion(Operator.GREATER_THAN, 0l);
  }


  public static com.example.enterpriseerpsystem.benefit.BenefitRequest<com.example.enterpriseerpsystem.benefit.Benefit> benefits(){
      return new com.example.enterpriseerpsystem.benefit.BenefitRequest(com.example.enterpriseerpsystem.benefit.Benefit.class).selectSelf().withVersion(Operator.GREATER_THAN, 0l);
  }
  public static com.example.enterpriseerpsystem.benefit.BenefitRequest<com.example.enterpriseerpsystem.benefit.Benefit> benefitsWithMinimalFields(){
      return new com.example.enterpriseerpsystem.benefit.BenefitRequest(com.example.enterpriseerpsystem.benefit.Benefit.class).withVersion(Operator.GREATER_THAN, 0l);
  }


  public static com.example.enterpriseerpsystem.employeereview.EmployeeReviewRequest<com.example.enterpriseerpsystem.employeereview.EmployeeReview> employeeReviews(){
      return new com.example.enterpriseerpsystem.employeereview.EmployeeReviewRequest(com.example.enterpriseerpsystem.employeereview.EmployeeReview.class).selectSelf().withVersion(Operator.GREATER_THAN, 0l);
  }
  public static com.example.enterpriseerpsystem.employeereview.EmployeeReviewRequest<com.example.enterpriseerpsystem.employeereview.EmployeeReview> employeeReviewsWithMinimalFields(){
      return new com.example.enterpriseerpsystem.employeereview.EmployeeReviewRequest(com.example.enterpriseerpsystem.employeereview.EmployeeReview.class).withVersion(Operator.GREATER_THAN, 0l);
  }


  public static com.example.enterpriseerpsystem.payroll.PayrollRequest<com.example.enterpriseerpsystem.payroll.Payroll> payrolls(){
      return new com.example.enterpriseerpsystem.payroll.PayrollRequest(com.example.enterpriseerpsystem.payroll.Payroll.class).selectSelf().withVersion(Operator.GREATER_THAN, 0l);
  }
  public static com.example.enterpriseerpsystem.payroll.PayrollRequest<com.example.enterpriseerpsystem.payroll.Payroll> payrollsWithMinimalFields(){
      return new com.example.enterpriseerpsystem.payroll.PayrollRequest(com.example.enterpriseerpsystem.payroll.Payroll.class).withVersion(Operator.GREATER_THAN, 0l);
  }


  public static com.example.enterpriseerpsystem.customer.CustomerRequest<com.example.enterpriseerpsystem.customer.Customer> customers(){
      return new com.example.enterpriseerpsystem.customer.CustomerRequest(com.example.enterpriseerpsystem.customer.Customer.class).selectSelf().withVersion(Operator.GREATER_THAN, 0l);
  }
  public static com.example.enterpriseerpsystem.customer.CustomerRequest<com.example.enterpriseerpsystem.customer.Customer> customersWithMinimalFields(){
      return new com.example.enterpriseerpsystem.customer.CustomerRequest(com.example.enterpriseerpsystem.customer.Customer.class).withVersion(Operator.GREATER_THAN, 0l);
  }


  public static com.example.enterpriseerpsystem.lead.LeadRequest<com.example.enterpriseerpsystem.lead.Lead> leads(){
      return new com.example.enterpriseerpsystem.lead.LeadRequest(com.example.enterpriseerpsystem.lead.Lead.class).selectSelf().withVersion(Operator.GREATER_THAN, 0l);
  }
  public static com.example.enterpriseerpsystem.lead.LeadRequest<com.example.enterpriseerpsystem.lead.Lead> leadsWithMinimalFields(){
      return new com.example.enterpriseerpsystem.lead.LeadRequest(com.example.enterpriseerpsystem.lead.Lead.class).withVersion(Operator.GREATER_THAN, 0l);
  }


  public static com.example.enterpriseerpsystem.opportunity.OpportunityRequest<com.example.enterpriseerpsystem.opportunity.Opportunity> opportunities(){
      return new com.example.enterpriseerpsystem.opportunity.OpportunityRequest(com.example.enterpriseerpsystem.opportunity.Opportunity.class).selectSelf().withVersion(Operator.GREATER_THAN, 0l);
  }
  public static com.example.enterpriseerpsystem.opportunity.OpportunityRequest<com.example.enterpriseerpsystem.opportunity.Opportunity> opportunitiesWithMinimalFields(){
      return new com.example.enterpriseerpsystem.opportunity.OpportunityRequest(com.example.enterpriseerpsystem.opportunity.Opportunity.class).withVersion(Operator.GREATER_THAN, 0l);
  }


  public static com.example.enterpriseerpsystem.contact.ContactRequest<com.example.enterpriseerpsystem.contact.Contact> contacts(){
      return new com.example.enterpriseerpsystem.contact.ContactRequest(com.example.enterpriseerpsystem.contact.Contact.class).selectSelf().withVersion(Operator.GREATER_THAN, 0l);
  }
  public static com.example.enterpriseerpsystem.contact.ContactRequest<com.example.enterpriseerpsystem.contact.Contact> contactsWithMinimalFields(){
      return new com.example.enterpriseerpsystem.contact.ContactRequest(com.example.enterpriseerpsystem.contact.Contact.class).withVersion(Operator.GREATER_THAN, 0l);
  }


  public static com.example.enterpriseerpsystem.campaign.CampaignRequest<com.example.enterpriseerpsystem.campaign.Campaign> campaigns(){
      return new com.example.enterpriseerpsystem.campaign.CampaignRequest(com.example.enterpriseerpsystem.campaign.Campaign.class).selectSelf().withVersion(Operator.GREATER_THAN, 0l);
  }
  public static com.example.enterpriseerpsystem.campaign.CampaignRequest<com.example.enterpriseerpsystem.campaign.Campaign> campaignsWithMinimalFields(){
      return new com.example.enterpriseerpsystem.campaign.CampaignRequest(com.example.enterpriseerpsystem.campaign.Campaign.class).withVersion(Operator.GREATER_THAN, 0l);
  }


  public static com.example.enterpriseerpsystem.contract.ContractRequest<com.example.enterpriseerpsystem.contract.Contract> contracts(){
      return new com.example.enterpriseerpsystem.contract.ContractRequest(com.example.enterpriseerpsystem.contract.Contract.class).selectSelf().withVersion(Operator.GREATER_THAN, 0l);
  }
  public static com.example.enterpriseerpsystem.contract.ContractRequest<com.example.enterpriseerpsystem.contract.Contract> contractsWithMinimalFields(){
      return new com.example.enterpriseerpsystem.contract.ContractRequest(com.example.enterpriseerpsystem.contract.Contract.class).withVersion(Operator.GREATER_THAN, 0l);
  }


  public static com.example.enterpriseerpsystem.quote.QuoteRequest<com.example.enterpriseerpsystem.quote.Quote> quotes(){
      return new com.example.enterpriseerpsystem.quote.QuoteRequest(com.example.enterpriseerpsystem.quote.Quote.class).selectSelf().withVersion(Operator.GREATER_THAN, 0l);
  }
  public static com.example.enterpriseerpsystem.quote.QuoteRequest<com.example.enterpriseerpsystem.quote.Quote> quotesWithMinimalFields(){
      return new com.example.enterpriseerpsystem.quote.QuoteRequest(com.example.enterpriseerpsystem.quote.Quote.class).withVersion(Operator.GREATER_THAN, 0l);
  }


  public static com.example.enterpriseerpsystem.salesterritory.SalesTerritoryRequest<com.example.enterpriseerpsystem.salesterritory.SalesTerritory> salesTerritories(){
      return new com.example.enterpriseerpsystem.salesterritory.SalesTerritoryRequest(com.example.enterpriseerpsystem.salesterritory.SalesTerritory.class).selectSelf().withVersion(Operator.GREATER_THAN, 0l);
  }
  public static com.example.enterpriseerpsystem.salesterritory.SalesTerritoryRequest<com.example.enterpriseerpsystem.salesterritory.SalesTerritory> salesTerritoriesWithMinimalFields(){
      return new com.example.enterpriseerpsystem.salesterritory.SalesTerritoryRequest(com.example.enterpriseerpsystem.salesterritory.SalesTerritory.class).withVersion(Operator.GREATER_THAN, 0l);
  }


  public static com.example.enterpriseerpsystem.product.ProductRequest<com.example.enterpriseerpsystem.product.Product> products(){
      return new com.example.enterpriseerpsystem.product.ProductRequest(com.example.enterpriseerpsystem.product.Product.class).selectSelf().withVersion(Operator.GREATER_THAN, 0l);
  }
  public static com.example.enterpriseerpsystem.product.ProductRequest<com.example.enterpriseerpsystem.product.Product> productsWithMinimalFields(){
      return new com.example.enterpriseerpsystem.product.ProductRequest(com.example.enterpriseerpsystem.product.Product.class).withVersion(Operator.GREATER_THAN, 0l);
  }


  public static com.example.enterpriseerpsystem.category.CategoryRequest<com.example.enterpriseerpsystem.category.Category> categories(){
      return new com.example.enterpriseerpsystem.category.CategoryRequest(com.example.enterpriseerpsystem.category.Category.class).selectSelf().withVersion(Operator.GREATER_THAN, 0l);
  }
  public static com.example.enterpriseerpsystem.category.CategoryRequest<com.example.enterpriseerpsystem.category.Category> categoriesWithMinimalFields(){
      return new com.example.enterpriseerpsystem.category.CategoryRequest(com.example.enterpriseerpsystem.category.Category.class).withVersion(Operator.GREATER_THAN, 0l);
  }


  public static com.example.enterpriseerpsystem.catalog.CatalogRequest<com.example.enterpriseerpsystem.catalog.Catalog> catalogs(){
      return new com.example.enterpriseerpsystem.catalog.CatalogRequest(com.example.enterpriseerpsystem.catalog.Catalog.class).selectSelf().withVersion(Operator.GREATER_THAN, 0l);
  }
  public static com.example.enterpriseerpsystem.catalog.CatalogRequest<com.example.enterpriseerpsystem.catalog.Catalog> catalogsWithMinimalFields(){
      return new com.example.enterpriseerpsystem.catalog.CatalogRequest(com.example.enterpriseerpsystem.catalog.Catalog.class).withVersion(Operator.GREATER_THAN, 0l);
  }


  public static com.example.enterpriseerpsystem.productreview.ProductReviewRequest<com.example.enterpriseerpsystem.productreview.ProductReview> productReviews(){
      return new com.example.enterpriseerpsystem.productreview.ProductReviewRequest(com.example.enterpriseerpsystem.productreview.ProductReview.class).selectSelf().withVersion(Operator.GREATER_THAN, 0l);
  }
  public static com.example.enterpriseerpsystem.productreview.ProductReviewRequest<com.example.enterpriseerpsystem.productreview.ProductReview> productReviewsWithMinimalFields(){
      return new com.example.enterpriseerpsystem.productreview.ProductReviewRequest(com.example.enterpriseerpsystem.productreview.ProductReview.class).withVersion(Operator.GREATER_THAN, 0l);
  }


  public static com.example.enterpriseerpsystem.shoppingcart.ShoppingCartRequest<com.example.enterpriseerpsystem.shoppingcart.ShoppingCart> shoppingCarts(){
      return new com.example.enterpriseerpsystem.shoppingcart.ShoppingCartRequest(com.example.enterpriseerpsystem.shoppingcart.ShoppingCart.class).selectSelf().withVersion(Operator.GREATER_THAN, 0l);
  }
  public static com.example.enterpriseerpsystem.shoppingcart.ShoppingCartRequest<com.example.enterpriseerpsystem.shoppingcart.ShoppingCart> shoppingCartsWithMinimalFields(){
      return new com.example.enterpriseerpsystem.shoppingcart.ShoppingCartRequest(com.example.enterpriseerpsystem.shoppingcart.ShoppingCart.class).withVersion(Operator.GREATER_THAN, 0l);
  }


  public static com.example.enterpriseerpsystem.cartitem.CartItemRequest<com.example.enterpriseerpsystem.cartitem.CartItem> cartItems(){
      return new com.example.enterpriseerpsystem.cartitem.CartItemRequest(com.example.enterpriseerpsystem.cartitem.CartItem.class).selectSelf().withVersion(Operator.GREATER_THAN, 0l);
  }
  public static com.example.enterpriseerpsystem.cartitem.CartItemRequest<com.example.enterpriseerpsystem.cartitem.CartItem> cartItemsWithMinimalFields(){
      return new com.example.enterpriseerpsystem.cartitem.CartItemRequest(com.example.enterpriseerpsystem.cartitem.CartItem.class).withVersion(Operator.GREATER_THAN, 0l);
  }


  public static com.example.enterpriseerpsystem.globalorder.GlobalOrderRequest<com.example.enterpriseerpsystem.globalorder.GlobalOrder> globalOrders(){
      return new com.example.enterpriseerpsystem.globalorder.GlobalOrderRequest(com.example.enterpriseerpsystem.globalorder.GlobalOrder.class).selectSelf().withVersion(Operator.GREATER_THAN, 0l);
  }
  public static com.example.enterpriseerpsystem.globalorder.GlobalOrderRequest<com.example.enterpriseerpsystem.globalorder.GlobalOrder> globalOrdersWithMinimalFields(){
      return new com.example.enterpriseerpsystem.globalorder.GlobalOrderRequest(com.example.enterpriseerpsystem.globalorder.GlobalOrder.class).withVersion(Operator.GREATER_THAN, 0l);
  }


  public static com.example.enterpriseerpsystem.orderitem.OrderItemRequest<com.example.enterpriseerpsystem.orderitem.OrderItem> orderItems(){
      return new com.example.enterpriseerpsystem.orderitem.OrderItemRequest(com.example.enterpriseerpsystem.orderitem.OrderItem.class).selectSelf().withVersion(Operator.GREATER_THAN, 0l);
  }
  public static com.example.enterpriseerpsystem.orderitem.OrderItemRequest<com.example.enterpriseerpsystem.orderitem.OrderItem> orderItemsWithMinimalFields(){
      return new com.example.enterpriseerpsystem.orderitem.OrderItemRequest(com.example.enterpriseerpsystem.orderitem.OrderItem.class).withVersion(Operator.GREATER_THAN, 0l);
  }


  public static com.example.enterpriseerpsystem.wishlist.WishlistRequest<com.example.enterpriseerpsystem.wishlist.Wishlist> wishlists(){
      return new com.example.enterpriseerpsystem.wishlist.WishlistRequest(com.example.enterpriseerpsystem.wishlist.Wishlist.class).selectSelf().withVersion(Operator.GREATER_THAN, 0l);
  }
  public static com.example.enterpriseerpsystem.wishlist.WishlistRequest<com.example.enterpriseerpsystem.wishlist.Wishlist> wishlistsWithMinimalFields(){
      return new com.example.enterpriseerpsystem.wishlist.WishlistRequest(com.example.enterpriseerpsystem.wishlist.Wishlist.class).withVersion(Operator.GREATER_THAN, 0l);
  }


  public static com.example.enterpriseerpsystem.promotion.PromotionRequest<com.example.enterpriseerpsystem.promotion.Promotion> promotions(){
      return new com.example.enterpriseerpsystem.promotion.PromotionRequest(com.example.enterpriseerpsystem.promotion.Promotion.class).selectSelf().withVersion(Operator.GREATER_THAN, 0l);
  }
  public static com.example.enterpriseerpsystem.promotion.PromotionRequest<com.example.enterpriseerpsystem.promotion.Promotion> promotionsWithMinimalFields(){
      return new com.example.enterpriseerpsystem.promotion.PromotionRequest(com.example.enterpriseerpsystem.promotion.Promotion.class).withVersion(Operator.GREATER_THAN, 0l);
  }


  public static com.example.enterpriseerpsystem.coupon.CouponRequest<com.example.enterpriseerpsystem.coupon.Coupon> coupons(){
      return new com.example.enterpriseerpsystem.coupon.CouponRequest(com.example.enterpriseerpsystem.coupon.Coupon.class).selectSelf().withVersion(Operator.GREATER_THAN, 0l);
  }
  public static com.example.enterpriseerpsystem.coupon.CouponRequest<com.example.enterpriseerpsystem.coupon.Coupon> couponsWithMinimalFields(){
      return new com.example.enterpriseerpsystem.coupon.CouponRequest(com.example.enterpriseerpsystem.coupon.Coupon.class).withVersion(Operator.GREATER_THAN, 0l);
  }


  public static com.example.enterpriseerpsystem.invoice.InvoiceRequest<com.example.enterpriseerpsystem.invoice.Invoice> invoices(){
      return new com.example.enterpriseerpsystem.invoice.InvoiceRequest(com.example.enterpriseerpsystem.invoice.Invoice.class).selectSelf().withVersion(Operator.GREATER_THAN, 0l);
  }
  public static com.example.enterpriseerpsystem.invoice.InvoiceRequest<com.example.enterpriseerpsystem.invoice.Invoice> invoicesWithMinimalFields(){
      return new com.example.enterpriseerpsystem.invoice.InvoiceRequest(com.example.enterpriseerpsystem.invoice.Invoice.class).withVersion(Operator.GREATER_THAN, 0l);
  }


  public static com.example.enterpriseerpsystem.payment.PaymentRequest<com.example.enterpriseerpsystem.payment.Payment> payments(){
      return new com.example.enterpriseerpsystem.payment.PaymentRequest(com.example.enterpriseerpsystem.payment.Payment.class).selectSelf().withVersion(Operator.GREATER_THAN, 0l);
  }
  public static com.example.enterpriseerpsystem.payment.PaymentRequest<com.example.enterpriseerpsystem.payment.Payment> paymentsWithMinimalFields(){
      return new com.example.enterpriseerpsystem.payment.PaymentRequest(com.example.enterpriseerpsystem.payment.Payment.class).withVersion(Operator.GREATER_THAN, 0l);
  }


  public static com.example.enterpriseerpsystem.refund.RefundRequest<com.example.enterpriseerpsystem.refund.Refund> refunds(){
      return new com.example.enterpriseerpsystem.refund.RefundRequest(com.example.enterpriseerpsystem.refund.Refund.class).selectSelf().withVersion(Operator.GREATER_THAN, 0l);
  }
  public static com.example.enterpriseerpsystem.refund.RefundRequest<com.example.enterpriseerpsystem.refund.Refund> refundsWithMinimalFields(){
      return new com.example.enterpriseerpsystem.refund.RefundRequest(com.example.enterpriseerpsystem.refund.Refund.class).withVersion(Operator.GREATER_THAN, 0l);
  }


  public static com.example.enterpriseerpsystem.account.AccountRequest<com.example.enterpriseerpsystem.account.Account> accounts(){
      return new com.example.enterpriseerpsystem.account.AccountRequest(com.example.enterpriseerpsystem.account.Account.class).selectSelf().withVersion(Operator.GREATER_THAN, 0l);
  }
  public static com.example.enterpriseerpsystem.account.AccountRequest<com.example.enterpriseerpsystem.account.Account> accountsWithMinimalFields(){
      return new com.example.enterpriseerpsystem.account.AccountRequest(com.example.enterpriseerpsystem.account.Account.class).withVersion(Operator.GREATER_THAN, 0l);
  }


  public static com.example.enterpriseerpsystem.transaction.TransactionRequest<com.example.enterpriseerpsystem.transaction.Transaction> transactions(){
      return new com.example.enterpriseerpsystem.transaction.TransactionRequest(com.example.enterpriseerpsystem.transaction.Transaction.class).selectSelf().withVersion(Operator.GREATER_THAN, 0l);
  }
  public static com.example.enterpriseerpsystem.transaction.TransactionRequest<com.example.enterpriseerpsystem.transaction.Transaction> transactionsWithMinimalFields(){
      return new com.example.enterpriseerpsystem.transaction.TransactionRequest(com.example.enterpriseerpsystem.transaction.Transaction.class).withVersion(Operator.GREATER_THAN, 0l);
  }


  public static com.example.enterpriseerpsystem.taxrate.TaxRateRequest<com.example.enterpriseerpsystem.taxrate.TaxRate> taxRates(){
      return new com.example.enterpriseerpsystem.taxrate.TaxRateRequest(com.example.enterpriseerpsystem.taxrate.TaxRate.class).selectSelf().withVersion(Operator.GREATER_THAN, 0l);
  }
  public static com.example.enterpriseerpsystem.taxrate.TaxRateRequest<com.example.enterpriseerpsystem.taxrate.TaxRate> taxRatesWithMinimalFields(){
      return new com.example.enterpriseerpsystem.taxrate.TaxRateRequest(com.example.enterpriseerpsystem.taxrate.TaxRate.class).withVersion(Operator.GREATER_THAN, 0l);
  }


  public static com.example.enterpriseerpsystem.expense.ExpenseRequest<com.example.enterpriseerpsystem.expense.Expense> expenses(){
      return new com.example.enterpriseerpsystem.expense.ExpenseRequest(com.example.enterpriseerpsystem.expense.Expense.class).selectSelf().withVersion(Operator.GREATER_THAN, 0l);
  }
  public static com.example.enterpriseerpsystem.expense.ExpenseRequest<com.example.enterpriseerpsystem.expense.Expense> expensesWithMinimalFields(){
      return new com.example.enterpriseerpsystem.expense.ExpenseRequest(com.example.enterpriseerpsystem.expense.Expense.class).withVersion(Operator.GREATER_THAN, 0l);
  }


  public static com.example.enterpriseerpsystem.ledger.LedgerRequest<com.example.enterpriseerpsystem.ledger.Ledger> ledgers(){
      return new com.example.enterpriseerpsystem.ledger.LedgerRequest(com.example.enterpriseerpsystem.ledger.Ledger.class).selectSelf().withVersion(Operator.GREATER_THAN, 0l);
  }
  public static com.example.enterpriseerpsystem.ledger.LedgerRequest<com.example.enterpriseerpsystem.ledger.Ledger> ledgersWithMinimalFields(){
      return new com.example.enterpriseerpsystem.ledger.LedgerRequest(com.example.enterpriseerpsystem.ledger.Ledger.class).withVersion(Operator.GREATER_THAN, 0l);
  }


  public static com.example.enterpriseerpsystem.supplier.SupplierRequest<com.example.enterpriseerpsystem.supplier.Supplier> suppliers(){
      return new com.example.enterpriseerpsystem.supplier.SupplierRequest(com.example.enterpriseerpsystem.supplier.Supplier.class).selectSelf().withVersion(Operator.GREATER_THAN, 0l);
  }
  public static com.example.enterpriseerpsystem.supplier.SupplierRequest<com.example.enterpriseerpsystem.supplier.Supplier> suppliersWithMinimalFields(){
      return new com.example.enterpriseerpsystem.supplier.SupplierRequest(com.example.enterpriseerpsystem.supplier.Supplier.class).withVersion(Operator.GREATER_THAN, 0l);
  }


  public static com.example.enterpriseerpsystem.warehouse.WarehouseRequest<com.example.enterpriseerpsystem.warehouse.Warehouse> warehouses(){
      return new com.example.enterpriseerpsystem.warehouse.WarehouseRequest(com.example.enterpriseerpsystem.warehouse.Warehouse.class).selectSelf().withVersion(Operator.GREATER_THAN, 0l);
  }
  public static com.example.enterpriseerpsystem.warehouse.WarehouseRequest<com.example.enterpriseerpsystem.warehouse.Warehouse> warehousesWithMinimalFields(){
      return new com.example.enterpriseerpsystem.warehouse.WarehouseRequest(com.example.enterpriseerpsystem.warehouse.Warehouse.class).withVersion(Operator.GREATER_THAN, 0l);
  }


  public static com.example.enterpriseerpsystem.inventoryitem.InventoryItemRequest<com.example.enterpriseerpsystem.inventoryitem.InventoryItem> inventoryItems(){
      return new com.example.enterpriseerpsystem.inventoryitem.InventoryItemRequest(com.example.enterpriseerpsystem.inventoryitem.InventoryItem.class).selectSelf().withVersion(Operator.GREATER_THAN, 0l);
  }
  public static com.example.enterpriseerpsystem.inventoryitem.InventoryItemRequest<com.example.enterpriseerpsystem.inventoryitem.InventoryItem> inventoryItemsWithMinimalFields(){
      return new com.example.enterpriseerpsystem.inventoryitem.InventoryItemRequest(com.example.enterpriseerpsystem.inventoryitem.InventoryItem.class).withVersion(Operator.GREATER_THAN, 0l);
  }


  public static com.example.enterpriseerpsystem.purchaseorder.PurchaseOrderRequest<com.example.enterpriseerpsystem.purchaseorder.PurchaseOrder> purchaseOrders(){
      return new com.example.enterpriseerpsystem.purchaseorder.PurchaseOrderRequest(com.example.enterpriseerpsystem.purchaseorder.PurchaseOrder.class).selectSelf().withVersion(Operator.GREATER_THAN, 0l);
  }
  public static com.example.enterpriseerpsystem.purchaseorder.PurchaseOrderRequest<com.example.enterpriseerpsystem.purchaseorder.PurchaseOrder> purchaseOrdersWithMinimalFields(){
      return new com.example.enterpriseerpsystem.purchaseorder.PurchaseOrderRequest(com.example.enterpriseerpsystem.purchaseorder.PurchaseOrder.class).withVersion(Operator.GREATER_THAN, 0l);
  }


  public static com.example.enterpriseerpsystem.purchaseorderitem.PurchaseOrderItemRequest<com.example.enterpriseerpsystem.purchaseorderitem.PurchaseOrderItem> purchaseOrderItems(){
      return new com.example.enterpriseerpsystem.purchaseorderitem.PurchaseOrderItemRequest(com.example.enterpriseerpsystem.purchaseorderitem.PurchaseOrderItem.class).selectSelf().withVersion(Operator.GREATER_THAN, 0l);
  }
  public static com.example.enterpriseerpsystem.purchaseorderitem.PurchaseOrderItemRequest<com.example.enterpriseerpsystem.purchaseorderitem.PurchaseOrderItem> purchaseOrderItemsWithMinimalFields(){
      return new com.example.enterpriseerpsystem.purchaseorderitem.PurchaseOrderItemRequest(com.example.enterpriseerpsystem.purchaseorderitem.PurchaseOrderItem.class).withVersion(Operator.GREATER_THAN, 0l);
  }


  public static com.example.enterpriseerpsystem.shipment.ShipmentRequest<com.example.enterpriseerpsystem.shipment.Shipment> shipments(){
      return new com.example.enterpriseerpsystem.shipment.ShipmentRequest(com.example.enterpriseerpsystem.shipment.Shipment.class).selectSelf().withVersion(Operator.GREATER_THAN, 0l);
  }
  public static com.example.enterpriseerpsystem.shipment.ShipmentRequest<com.example.enterpriseerpsystem.shipment.Shipment> shipmentsWithMinimalFields(){
      return new com.example.enterpriseerpsystem.shipment.ShipmentRequest(com.example.enterpriseerpsystem.shipment.Shipment.class).withVersion(Operator.GREATER_THAN, 0l);
  }


  public static com.example.enterpriseerpsystem.delivery.DeliveryRequest<com.example.enterpriseerpsystem.delivery.Delivery> deliveries(){
      return new com.example.enterpriseerpsystem.delivery.DeliveryRequest(com.example.enterpriseerpsystem.delivery.Delivery.class).selectSelf().withVersion(Operator.GREATER_THAN, 0l);
  }
  public static com.example.enterpriseerpsystem.delivery.DeliveryRequest<com.example.enterpriseerpsystem.delivery.Delivery> deliveriesWithMinimalFields(){
      return new com.example.enterpriseerpsystem.delivery.DeliveryRequest(com.example.enterpriseerpsystem.delivery.Delivery.class).withVersion(Operator.GREATER_THAN, 0l);
  }


  public static com.example.enterpriseerpsystem.returnrequest.ReturnRequestRequest<com.example.enterpriseerpsystem.returnrequest.ReturnRequest> returnRequests(){
      return new com.example.enterpriseerpsystem.returnrequest.ReturnRequestRequest(com.example.enterpriseerpsystem.returnrequest.ReturnRequest.class).selectSelf().withVersion(Operator.GREATER_THAN, 0l);
  }
  public static com.example.enterpriseerpsystem.returnrequest.ReturnRequestRequest<com.example.enterpriseerpsystem.returnrequest.ReturnRequest> returnRequestsWithMinimalFields(){
      return new com.example.enterpriseerpsystem.returnrequest.ReturnRequestRequest(com.example.enterpriseerpsystem.returnrequest.ReturnRequest.class).withVersion(Operator.GREATER_THAN, 0l);
  }


  public static com.example.enterpriseerpsystem.ticket.TicketRequest<com.example.enterpriseerpsystem.ticket.Ticket> tickets(){
      return new com.example.enterpriseerpsystem.ticket.TicketRequest(com.example.enterpriseerpsystem.ticket.Ticket.class).selectSelf().withVersion(Operator.GREATER_THAN, 0l);
  }
  public static com.example.enterpriseerpsystem.ticket.TicketRequest<com.example.enterpriseerpsystem.ticket.Ticket> ticketsWithMinimalFields(){
      return new com.example.enterpriseerpsystem.ticket.TicketRequest(com.example.enterpriseerpsystem.ticket.Ticket.class).withVersion(Operator.GREATER_THAN, 0l);
  }


  public static com.example.enterpriseerpsystem.ticketcomment.TicketCommentRequest<com.example.enterpriseerpsystem.ticketcomment.TicketComment> ticketComments(){
      return new com.example.enterpriseerpsystem.ticketcomment.TicketCommentRequest(com.example.enterpriseerpsystem.ticketcomment.TicketComment.class).selectSelf().withVersion(Operator.GREATER_THAN, 0l);
  }
  public static com.example.enterpriseerpsystem.ticketcomment.TicketCommentRequest<com.example.enterpriseerpsystem.ticketcomment.TicketComment> ticketCommentsWithMinimalFields(){
      return new com.example.enterpriseerpsystem.ticketcomment.TicketCommentRequest(com.example.enterpriseerpsystem.ticketcomment.TicketComment.class).withVersion(Operator.GREATER_THAN, 0l);
  }


  public static com.example.enterpriseerpsystem.sla.SlaRequest<com.example.enterpriseerpsystem.sla.Sla> slas(){
      return new com.example.enterpriseerpsystem.sla.SlaRequest(com.example.enterpriseerpsystem.sla.Sla.class).selectSelf().withVersion(Operator.GREATER_THAN, 0l);
  }
  public static com.example.enterpriseerpsystem.sla.SlaRequest<com.example.enterpriseerpsystem.sla.Sla> slasWithMinimalFields(){
      return new com.example.enterpriseerpsystem.sla.SlaRequest(com.example.enterpriseerpsystem.sla.Sla.class).withVersion(Operator.GREATER_THAN, 0l);
  }


  public static com.example.enterpriseerpsystem.knowledgebase.KnowledgeBaseRequest<com.example.enterpriseerpsystem.knowledgebase.KnowledgeBase> knowledgeBases(){
      return new com.example.enterpriseerpsystem.knowledgebase.KnowledgeBaseRequest(com.example.enterpriseerpsystem.knowledgebase.KnowledgeBase.class).selectSelf().withVersion(Operator.GREATER_THAN, 0l);
  }
  public static com.example.enterpriseerpsystem.knowledgebase.KnowledgeBaseRequest<com.example.enterpriseerpsystem.knowledgebase.KnowledgeBase> knowledgeBasesWithMinimalFields(){
      return new com.example.enterpriseerpsystem.knowledgebase.KnowledgeBaseRequest(com.example.enterpriseerpsystem.knowledgebase.KnowledgeBase.class).withVersion(Operator.GREATER_THAN, 0l);
  }


  public static com.example.enterpriseerpsystem.supportagent.SupportAgentRequest<com.example.enterpriseerpsystem.supportagent.SupportAgent> supportAgents(){
      return new com.example.enterpriseerpsystem.supportagent.SupportAgentRequest(com.example.enterpriseerpsystem.supportagent.SupportAgent.class).selectSelf().withVersion(Operator.GREATER_THAN, 0l);
  }
  public static com.example.enterpriseerpsystem.supportagent.SupportAgentRequest<com.example.enterpriseerpsystem.supportagent.SupportAgent> supportAgentsWithMinimalFields(){
      return new com.example.enterpriseerpsystem.supportagent.SupportAgentRequest(com.example.enterpriseerpsystem.supportagent.SupportAgent.class).withVersion(Operator.GREATER_THAN, 0l);
  }


}