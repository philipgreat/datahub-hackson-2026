
package com.example.enterpriseerpsystem;

import com.example.enterpriseerpsystem.account.Account;
import com.example.enterpriseerpsystem.account.AccountExpression;
import com.example.enterpriseerpsystem.attendance.Attendance;
import com.example.enterpriseerpsystem.attendance.AttendanceExpression;
import com.example.enterpriseerpsystem.benefit.Benefit;
import com.example.enterpriseerpsystem.benefit.BenefitExpression;
import com.example.enterpriseerpsystem.campaign.Campaign;
import com.example.enterpriseerpsystem.campaign.CampaignExpression;
import com.example.enterpriseerpsystem.cartitem.CartItem;
import com.example.enterpriseerpsystem.cartitem.CartItemExpression;
import com.example.enterpriseerpsystem.catalog.Catalog;
import com.example.enterpriseerpsystem.catalog.CatalogExpression;
import com.example.enterpriseerpsystem.category.Category;
import com.example.enterpriseerpsystem.category.CategoryExpression;
import com.example.enterpriseerpsystem.contact.Contact;
import com.example.enterpriseerpsystem.contact.ContactExpression;
import com.example.enterpriseerpsystem.contract.Contract;
import com.example.enterpriseerpsystem.contract.ContractExpression;
import com.example.enterpriseerpsystem.coupon.Coupon;
import com.example.enterpriseerpsystem.coupon.CouponExpression;
import com.example.enterpriseerpsystem.customer.Customer;
import com.example.enterpriseerpsystem.customer.CustomerExpression;
import com.example.enterpriseerpsystem.delivery.Delivery;
import com.example.enterpriseerpsystem.delivery.DeliveryExpression;
import com.example.enterpriseerpsystem.department.Department;
import com.example.enterpriseerpsystem.department.DepartmentExpression;
import com.example.enterpriseerpsystem.employee.Employee;
import com.example.enterpriseerpsystem.employee.EmployeeExpression;
import com.example.enterpriseerpsystem.employeereview.EmployeeReview;
import com.example.enterpriseerpsystem.employeereview.EmployeeReviewExpression;
import com.example.enterpriseerpsystem.expense.Expense;
import com.example.enterpriseerpsystem.expense.ExpenseExpression;
import com.example.enterpriseerpsystem.globalorder.GlobalOrder;
import com.example.enterpriseerpsystem.globalorder.GlobalOrderExpression;
import com.example.enterpriseerpsystem.inventoryitem.InventoryItem;
import com.example.enterpriseerpsystem.inventoryitem.InventoryItemExpression;
import com.example.enterpriseerpsystem.invoice.Invoice;
import com.example.enterpriseerpsystem.invoice.InvoiceExpression;
import com.example.enterpriseerpsystem.knowledgebase.KnowledgeBase;
import com.example.enterpriseerpsystem.knowledgebase.KnowledgeBaseExpression;
import com.example.enterpriseerpsystem.lead.Lead;
import com.example.enterpriseerpsystem.lead.LeadExpression;
import com.example.enterpriseerpsystem.leaverequest.LeaveRequest;
import com.example.enterpriseerpsystem.leaverequest.LeaveRequestExpression;
import com.example.enterpriseerpsystem.ledger.Ledger;
import com.example.enterpriseerpsystem.ledger.LedgerExpression;
import com.example.enterpriseerpsystem.opportunity.Opportunity;
import com.example.enterpriseerpsystem.opportunity.OpportunityExpression;
import com.example.enterpriseerpsystem.orderitem.OrderItem;
import com.example.enterpriseerpsystem.orderitem.OrderItemExpression;
import com.example.enterpriseerpsystem.payment.Payment;
import com.example.enterpriseerpsystem.payment.PaymentExpression;
import com.example.enterpriseerpsystem.payroll.Payroll;
import com.example.enterpriseerpsystem.payroll.PayrollExpression;
import com.example.enterpriseerpsystem.position.Position;
import com.example.enterpriseerpsystem.position.PositionExpression;
import com.example.enterpriseerpsystem.product.Product;
import com.example.enterpriseerpsystem.product.ProductExpression;
import com.example.enterpriseerpsystem.productreview.ProductReview;
import com.example.enterpriseerpsystem.productreview.ProductReviewExpression;
import com.example.enterpriseerpsystem.promotion.Promotion;
import com.example.enterpriseerpsystem.promotion.PromotionExpression;
import com.example.enterpriseerpsystem.purchaseorder.PurchaseOrder;
import com.example.enterpriseerpsystem.purchaseorder.PurchaseOrderExpression;
import com.example.enterpriseerpsystem.purchaseorderitem.PurchaseOrderItem;
import com.example.enterpriseerpsystem.purchaseorderitem.PurchaseOrderItemExpression;
import com.example.enterpriseerpsystem.quote.Quote;
import com.example.enterpriseerpsystem.quote.QuoteExpression;
import com.example.enterpriseerpsystem.refund.Refund;
import com.example.enterpriseerpsystem.refund.RefundExpression;
import com.example.enterpriseerpsystem.returnrequest.ReturnRequest;
import com.example.enterpriseerpsystem.returnrequest.ReturnRequestExpression;
import com.example.enterpriseerpsystem.salesterritory.SalesTerritory;
import com.example.enterpriseerpsystem.salesterritory.SalesTerritoryExpression;
import com.example.enterpriseerpsystem.shipment.Shipment;
import com.example.enterpriseerpsystem.shipment.ShipmentExpression;
import com.example.enterpriseerpsystem.shoppingcart.ShoppingCart;
import com.example.enterpriseerpsystem.shoppingcart.ShoppingCartExpression;
import com.example.enterpriseerpsystem.sla.Sla;
import com.example.enterpriseerpsystem.sla.SlaExpression;
import com.example.enterpriseerpsystem.supplier.Supplier;
import com.example.enterpriseerpsystem.supplier.SupplierExpression;
import com.example.enterpriseerpsystem.supportagent.SupportAgent;
import com.example.enterpriseerpsystem.supportagent.SupportAgentExpression;
import com.example.enterpriseerpsystem.taxrate.TaxRate;
import com.example.enterpriseerpsystem.taxrate.TaxRateExpression;
import com.example.enterpriseerpsystem.ticket.Ticket;
import com.example.enterpriseerpsystem.ticket.TicketExpression;
import com.example.enterpriseerpsystem.ticketcomment.TicketComment;
import com.example.enterpriseerpsystem.ticketcomment.TicketCommentExpression;
import com.example.enterpriseerpsystem.transaction.Transaction;
import com.example.enterpriseerpsystem.transaction.TransactionExpression;
import com.example.enterpriseerpsystem.warehouse.Warehouse;
import com.example.enterpriseerpsystem.warehouse.WarehouseExpression;
import com.example.enterpriseerpsystem.wishlist.Wishlist;
import com.example.enterpriseerpsystem.wishlist.WishlistExpression;
import io.teaql.core.value.ValueExpression;

public class E  {
  public static EmployeeExpression<Employee, Employee, Employee> employee(Employee employee){
      return new EmployeeExpression(new ValueExpression(employee));
  }
  public static DepartmentExpression<Department, Department, Department> department(Department department){
      return new DepartmentExpression(new ValueExpression(department));
  }
  public static PositionExpression<Position, Position, Position> position(Position position){
      return new PositionExpression(new ValueExpression(position));
  }
  public static LeaveRequestExpression<LeaveRequest, LeaveRequest, LeaveRequest> leaveRequest(LeaveRequest leaveRequest){
      return new LeaveRequestExpression(new ValueExpression(leaveRequest));
  }
  public static AttendanceExpression<Attendance, Attendance, Attendance> attendance(Attendance attendance){
      return new AttendanceExpression(new ValueExpression(attendance));
  }
  public static BenefitExpression<Benefit, Benefit, Benefit> benefit(Benefit benefit){
      return new BenefitExpression(new ValueExpression(benefit));
  }
  public static EmployeeReviewExpression<EmployeeReview, EmployeeReview, EmployeeReview> employeeReview(EmployeeReview employeeReview){
      return new EmployeeReviewExpression(new ValueExpression(employeeReview));
  }
  public static PayrollExpression<Payroll, Payroll, Payroll> payroll(Payroll payroll){
      return new PayrollExpression(new ValueExpression(payroll));
  }
  public static CustomerExpression<Customer, Customer, Customer> customer(Customer customer){
      return new CustomerExpression(new ValueExpression(customer));
  }
  public static LeadExpression<Lead, Lead, Lead> lead(Lead lead){
      return new LeadExpression(new ValueExpression(lead));
  }
  public static OpportunityExpression<Opportunity, Opportunity, Opportunity> opportunity(Opportunity opportunity){
      return new OpportunityExpression(new ValueExpression(opportunity));
  }
  public static ContactExpression<Contact, Contact, Contact> contact(Contact contact){
      return new ContactExpression(new ValueExpression(contact));
  }
  public static CampaignExpression<Campaign, Campaign, Campaign> campaign(Campaign campaign){
      return new CampaignExpression(new ValueExpression(campaign));
  }
  public static ContractExpression<Contract, Contract, Contract> contract(Contract contract){
      return new ContractExpression(new ValueExpression(contract));
  }
  public static QuoteExpression<Quote, Quote, Quote> quote(Quote quote){
      return new QuoteExpression(new ValueExpression(quote));
  }
  public static SalesTerritoryExpression<SalesTerritory, SalesTerritory, SalesTerritory> salesTerritory(SalesTerritory salesTerritory){
      return new SalesTerritoryExpression(new ValueExpression(salesTerritory));
  }
  public static ProductExpression<Product, Product, Product> product(Product product){
      return new ProductExpression(new ValueExpression(product));
  }
  public static CategoryExpression<Category, Category, Category> category(Category category){
      return new CategoryExpression(new ValueExpression(category));
  }
  public static CatalogExpression<Catalog, Catalog, Catalog> catalog(Catalog catalog){
      return new CatalogExpression(new ValueExpression(catalog));
  }
  public static ProductReviewExpression<ProductReview, ProductReview, ProductReview> productReview(ProductReview productReview){
      return new ProductReviewExpression(new ValueExpression(productReview));
  }
  public static ShoppingCartExpression<ShoppingCart, ShoppingCart, ShoppingCart> shoppingCart(ShoppingCart shoppingCart){
      return new ShoppingCartExpression(new ValueExpression(shoppingCart));
  }
  public static CartItemExpression<CartItem, CartItem, CartItem> cartItem(CartItem cartItem){
      return new CartItemExpression(new ValueExpression(cartItem));
  }
  public static GlobalOrderExpression<GlobalOrder, GlobalOrder, GlobalOrder> globalOrder(GlobalOrder globalOrder){
      return new GlobalOrderExpression(new ValueExpression(globalOrder));
  }
  public static OrderItemExpression<OrderItem, OrderItem, OrderItem> orderItem(OrderItem orderItem){
      return new OrderItemExpression(new ValueExpression(orderItem));
  }
  public static WishlistExpression<Wishlist, Wishlist, Wishlist> wishlist(Wishlist wishlist){
      return new WishlistExpression(new ValueExpression(wishlist));
  }
  public static PromotionExpression<Promotion, Promotion, Promotion> promotion(Promotion promotion){
      return new PromotionExpression(new ValueExpression(promotion));
  }
  public static CouponExpression<Coupon, Coupon, Coupon> coupon(Coupon coupon){
      return new CouponExpression(new ValueExpression(coupon));
  }
  public static InvoiceExpression<Invoice, Invoice, Invoice> invoice(Invoice invoice){
      return new InvoiceExpression(new ValueExpression(invoice));
  }
  public static PaymentExpression<Payment, Payment, Payment> payment(Payment payment){
      return new PaymentExpression(new ValueExpression(payment));
  }
  public static RefundExpression<Refund, Refund, Refund> refund(Refund refund){
      return new RefundExpression(new ValueExpression(refund));
  }
  public static AccountExpression<Account, Account, Account> account(Account account){
      return new AccountExpression(new ValueExpression(account));
  }
  public static TransactionExpression<Transaction, Transaction, Transaction> transaction(Transaction transaction){
      return new TransactionExpression(new ValueExpression(transaction));
  }
  public static TaxRateExpression<TaxRate, TaxRate, TaxRate> taxRate(TaxRate taxRate){
      return new TaxRateExpression(new ValueExpression(taxRate));
  }
  public static ExpenseExpression<Expense, Expense, Expense> expense(Expense expense){
      return new ExpenseExpression(new ValueExpression(expense));
  }
  public static LedgerExpression<Ledger, Ledger, Ledger> ledger(Ledger ledger){
      return new LedgerExpression(new ValueExpression(ledger));
  }
  public static SupplierExpression<Supplier, Supplier, Supplier> supplier(Supplier supplier){
      return new SupplierExpression(new ValueExpression(supplier));
  }
  public static WarehouseExpression<Warehouse, Warehouse, Warehouse> warehouse(Warehouse warehouse){
      return new WarehouseExpression(new ValueExpression(warehouse));
  }
  public static InventoryItemExpression<InventoryItem, InventoryItem, InventoryItem> inventoryItem(InventoryItem inventoryItem){
      return new InventoryItemExpression(new ValueExpression(inventoryItem));
  }
  public static PurchaseOrderExpression<PurchaseOrder, PurchaseOrder, PurchaseOrder> purchaseOrder(PurchaseOrder purchaseOrder){
      return new PurchaseOrderExpression(new ValueExpression(purchaseOrder));
  }
  public static PurchaseOrderItemExpression<PurchaseOrderItem, PurchaseOrderItem, PurchaseOrderItem> purchaseOrderItem(PurchaseOrderItem purchaseOrderItem){
      return new PurchaseOrderItemExpression(new ValueExpression(purchaseOrderItem));
  }
  public static ShipmentExpression<Shipment, Shipment, Shipment> shipment(Shipment shipment){
      return new ShipmentExpression(new ValueExpression(shipment));
  }
  public static DeliveryExpression<Delivery, Delivery, Delivery> delivery(Delivery delivery){
      return new DeliveryExpression(new ValueExpression(delivery));
  }
  public static ReturnRequestExpression<ReturnRequest, ReturnRequest, ReturnRequest> returnRequest(ReturnRequest returnRequest){
      return new ReturnRequestExpression(new ValueExpression(returnRequest));
  }
  public static TicketExpression<Ticket, Ticket, Ticket> ticket(Ticket ticket){
      return new TicketExpression(new ValueExpression(ticket));
  }
  public static TicketCommentExpression<TicketComment, TicketComment, TicketComment> ticketComment(TicketComment ticketComment){
      return new TicketCommentExpression(new ValueExpression(ticketComment));
  }
  public static SlaExpression<Sla, Sla, Sla> sla(Sla sla){
      return new SlaExpression(new ValueExpression(sla));
  }
  public static KnowledgeBaseExpression<KnowledgeBase, KnowledgeBase, KnowledgeBase> knowledgeBase(KnowledgeBase knowledgeBase){
      return new KnowledgeBaseExpression(new ValueExpression(knowledgeBase));
  }
  public static SupportAgentExpression<SupportAgent, SupportAgent, SupportAgent> supportAgent(SupportAgent supportAgent){
      return new SupportAgentExpression(new ValueExpression(supportAgent));
  }
}