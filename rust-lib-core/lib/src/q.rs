use teaql_core::Expr;

use crate::*;

pub struct PurposedQuery<T> {
    pub inner: T,
    pub purpose: String,
}

impl<T> PurposedQuery<T> {
    pub fn new(inner: T, purpose: impl Into<String>) -> Self {
        Self { inner, purpose: purpose.into() }
    }
}

pub struct Q;

impl Q {
    pub fn employees() -> EmployeeRequest {
        EmployeeRequest::new()
            .select_self()
            .and_filter(Expr::gt("version", 0_i64))
    }

    pub fn employees_minimal() -> EmployeeRequest {
        EmployeeRequest::new()
            .and_filter(Expr::gt("version", 0_i64))
    }

    pub fn employees_with_children() -> EmployeeRequest {
        EmployeeRequest::new()
            .unlimited()
            .select_self_fields()
            .enhance_children_if_needed()
    }

    pub fn departments() -> DepartmentRequest {
        DepartmentRequest::new()
            .select_self()
            .and_filter(Expr::gt("version", 0_i64))
    }

    pub fn departments_minimal() -> DepartmentRequest {
        DepartmentRequest::new()
            .and_filter(Expr::gt("version", 0_i64))
    }

    pub fn departments_with_children() -> DepartmentRequest {
        DepartmentRequest::new()
            .unlimited()
            .select_self_fields()
            .enhance_children_if_needed()
    }

    pub fn positions() -> PositionRequest {
        PositionRequest::new()
            .select_self()
            .and_filter(Expr::gt("version", 0_i64))
    }

    pub fn positions_minimal() -> PositionRequest {
        PositionRequest::new()
            .and_filter(Expr::gt("version", 0_i64))
    }

    pub fn positions_with_children() -> PositionRequest {
        PositionRequest::new()
            .unlimited()
            .select_self_fields()
            .enhance_children_if_needed()
    }

    pub fn leave_requests() -> LeaveRequestRequest {
        LeaveRequestRequest::new()
            .select_self()
            .and_filter(Expr::gt("version", 0_i64))
    }

    pub fn leave_requests_minimal() -> LeaveRequestRequest {
        LeaveRequestRequest::new()
            .and_filter(Expr::gt("version", 0_i64))
    }

    pub fn leave_requests_with_children() -> LeaveRequestRequest {
        LeaveRequestRequest::new()
            .unlimited()
            .select_self_fields()
            .enhance_children_if_needed()
    }

    pub fn attendances() -> AttendanceRequest {
        AttendanceRequest::new()
            .select_self()
            .and_filter(Expr::gt("version", 0_i64))
    }

    pub fn attendances_minimal() -> AttendanceRequest {
        AttendanceRequest::new()
            .and_filter(Expr::gt("version", 0_i64))
    }

    pub fn attendances_with_children() -> AttendanceRequest {
        AttendanceRequest::new()
            .unlimited()
            .select_self_fields()
            .enhance_children_if_needed()
    }

    pub fn benefits() -> BenefitRequest {
        BenefitRequest::new()
            .select_self()
            .and_filter(Expr::gt("version", 0_i64))
    }

    pub fn benefits_minimal() -> BenefitRequest {
        BenefitRequest::new()
            .and_filter(Expr::gt("version", 0_i64))
    }

    pub fn benefits_with_children() -> BenefitRequest {
        BenefitRequest::new()
            .unlimited()
            .select_self_fields()
            .enhance_children_if_needed()
    }

    pub fn employee_reviews() -> EmployeeReviewRequest {
        EmployeeReviewRequest::new()
            .select_self()
            .and_filter(Expr::gt("version", 0_i64))
    }

    pub fn employee_reviews_minimal() -> EmployeeReviewRequest {
        EmployeeReviewRequest::new()
            .and_filter(Expr::gt("version", 0_i64))
    }

    pub fn employee_reviews_with_children() -> EmployeeReviewRequest {
        EmployeeReviewRequest::new()
            .unlimited()
            .select_self_fields()
            .enhance_children_if_needed()
    }

    pub fn payrolls() -> PayrollRequest {
        PayrollRequest::new()
            .select_self()
            .and_filter(Expr::gt("version", 0_i64))
    }

    pub fn payrolls_minimal() -> PayrollRequest {
        PayrollRequest::new()
            .and_filter(Expr::gt("version", 0_i64))
    }

    pub fn payrolls_with_children() -> PayrollRequest {
        PayrollRequest::new()
            .unlimited()
            .select_self_fields()
            .enhance_children_if_needed()
    }

    pub fn customers() -> CustomerRequest {
        CustomerRequest::new()
            .select_self()
            .and_filter(Expr::gt("version", 0_i64))
    }

    pub fn customers_minimal() -> CustomerRequest {
        CustomerRequest::new()
            .and_filter(Expr::gt("version", 0_i64))
    }

    pub fn customers_with_children() -> CustomerRequest {
        CustomerRequest::new()
            .unlimited()
            .select_self_fields()
            .enhance_children_if_needed()
    }

    pub fn leads() -> LeadRequest {
        LeadRequest::new()
            .select_self()
            .and_filter(Expr::gt("version", 0_i64))
    }

    pub fn leads_minimal() -> LeadRequest {
        LeadRequest::new()
            .and_filter(Expr::gt("version", 0_i64))
    }

    pub fn leads_with_children() -> LeadRequest {
        LeadRequest::new()
            .unlimited()
            .select_self_fields()
            .enhance_children_if_needed()
    }

    pub fn opportunities() -> OpportunityRequest {
        OpportunityRequest::new()
            .select_self()
            .and_filter(Expr::gt("version", 0_i64))
    }

    pub fn opportunities_minimal() -> OpportunityRequest {
        OpportunityRequest::new()
            .and_filter(Expr::gt("version", 0_i64))
    }

    pub fn opportunities_with_children() -> OpportunityRequest {
        OpportunityRequest::new()
            .unlimited()
            .select_self_fields()
            .enhance_children_if_needed()
    }

    pub fn contacts() -> ContactRequest {
        ContactRequest::new()
            .select_self()
            .and_filter(Expr::gt("version", 0_i64))
    }

    pub fn contacts_minimal() -> ContactRequest {
        ContactRequest::new()
            .and_filter(Expr::gt("version", 0_i64))
    }

    pub fn contacts_with_children() -> ContactRequest {
        ContactRequest::new()
            .unlimited()
            .select_self_fields()
            .enhance_children_if_needed()
    }

    pub fn campaigns() -> CampaignRequest {
        CampaignRequest::new()
            .select_self()
            .and_filter(Expr::gt("version", 0_i64))
    }

    pub fn campaigns_minimal() -> CampaignRequest {
        CampaignRequest::new()
            .and_filter(Expr::gt("version", 0_i64))
    }

    pub fn campaigns_with_children() -> CampaignRequest {
        CampaignRequest::new()
            .unlimited()
            .select_self_fields()
            .enhance_children_if_needed()
    }

    pub fn contracts() -> ContractRequest {
        ContractRequest::new()
            .select_self()
            .and_filter(Expr::gt("version", 0_i64))
    }

    pub fn contracts_minimal() -> ContractRequest {
        ContractRequest::new()
            .and_filter(Expr::gt("version", 0_i64))
    }

    pub fn contracts_with_children() -> ContractRequest {
        ContractRequest::new()
            .unlimited()
            .select_self_fields()
            .enhance_children_if_needed()
    }

    pub fn quotes() -> QuoteRequest {
        QuoteRequest::new()
            .select_self()
            .and_filter(Expr::gt("version", 0_i64))
    }

    pub fn quotes_minimal() -> QuoteRequest {
        QuoteRequest::new()
            .and_filter(Expr::gt("version", 0_i64))
    }

    pub fn quotes_with_children() -> QuoteRequest {
        QuoteRequest::new()
            .unlimited()
            .select_self_fields()
            .enhance_children_if_needed()
    }

    pub fn sales_territories() -> SalesTerritoryRequest {
        SalesTerritoryRequest::new()
            .select_self()
            .and_filter(Expr::gt("version", 0_i64))
    }

    pub fn sales_territories_minimal() -> SalesTerritoryRequest {
        SalesTerritoryRequest::new()
            .and_filter(Expr::gt("version", 0_i64))
    }

    pub fn sales_territories_with_children() -> SalesTerritoryRequest {
        SalesTerritoryRequest::new()
            .unlimited()
            .select_self_fields()
            .enhance_children_if_needed()
    }

    pub fn products() -> ProductRequest {
        ProductRequest::new()
            .select_self()
            .and_filter(Expr::gt("version", 0_i64))
    }

    pub fn products_minimal() -> ProductRequest {
        ProductRequest::new()
            .and_filter(Expr::gt("version", 0_i64))
    }

    pub fn products_with_children() -> ProductRequest {
        ProductRequest::new()
            .unlimited()
            .select_self_fields()
            .enhance_children_if_needed()
    }

    pub fn categories() -> CategoryRequest {
        CategoryRequest::new()
            .select_self()
            .and_filter(Expr::gt("version", 0_i64))
    }

    pub fn categories_minimal() -> CategoryRequest {
        CategoryRequest::new()
            .and_filter(Expr::gt("version", 0_i64))
    }

    pub fn categories_with_children() -> CategoryRequest {
        CategoryRequest::new()
            .unlimited()
            .select_self_fields()
            .enhance_children_if_needed()
    }

    pub fn catalogs() -> CatalogRequest {
        CatalogRequest::new()
            .select_self()
            .and_filter(Expr::gt("version", 0_i64))
    }

    pub fn catalogs_minimal() -> CatalogRequest {
        CatalogRequest::new()
            .and_filter(Expr::gt("version", 0_i64))
    }

    pub fn catalogs_with_children() -> CatalogRequest {
        CatalogRequest::new()
            .unlimited()
            .select_self_fields()
            .enhance_children_if_needed()
    }

    pub fn product_reviews() -> ProductReviewRequest {
        ProductReviewRequest::new()
            .select_self()
            .and_filter(Expr::gt("version", 0_i64))
    }

    pub fn product_reviews_minimal() -> ProductReviewRequest {
        ProductReviewRequest::new()
            .and_filter(Expr::gt("version", 0_i64))
    }

    pub fn product_reviews_with_children() -> ProductReviewRequest {
        ProductReviewRequest::new()
            .unlimited()
            .select_self_fields()
            .enhance_children_if_needed()
    }

    pub fn shopping_carts() -> ShoppingCartRequest {
        ShoppingCartRequest::new()
            .select_self()
            .and_filter(Expr::gt("version", 0_i64))
    }

    pub fn shopping_carts_minimal() -> ShoppingCartRequest {
        ShoppingCartRequest::new()
            .and_filter(Expr::gt("version", 0_i64))
    }

    pub fn shopping_carts_with_children() -> ShoppingCartRequest {
        ShoppingCartRequest::new()
            .unlimited()
            .select_self_fields()
            .enhance_children_if_needed()
    }

    pub fn cart_items() -> CartItemRequest {
        CartItemRequest::new()
            .select_self()
            .and_filter(Expr::gt("version", 0_i64))
    }

    pub fn cart_items_minimal() -> CartItemRequest {
        CartItemRequest::new()
            .and_filter(Expr::gt("version", 0_i64))
    }

    pub fn cart_items_with_children() -> CartItemRequest {
        CartItemRequest::new()
            .unlimited()
            .select_self_fields()
            .enhance_children_if_needed()
    }

    pub fn global_orders() -> GlobalOrderRequest {
        GlobalOrderRequest::new()
            .select_self()
            .and_filter(Expr::gt("version", 0_i64))
    }

    pub fn global_orders_minimal() -> GlobalOrderRequest {
        GlobalOrderRequest::new()
            .and_filter(Expr::gt("version", 0_i64))
    }

    pub fn global_orders_with_children() -> GlobalOrderRequest {
        GlobalOrderRequest::new()
            .unlimited()
            .select_self_fields()
            .enhance_children_if_needed()
    }

    pub fn order_items() -> OrderItemRequest {
        OrderItemRequest::new()
            .select_self()
            .and_filter(Expr::gt("version", 0_i64))
    }

    pub fn order_items_minimal() -> OrderItemRequest {
        OrderItemRequest::new()
            .and_filter(Expr::gt("version", 0_i64))
    }

    pub fn order_items_with_children() -> OrderItemRequest {
        OrderItemRequest::new()
            .unlimited()
            .select_self_fields()
            .enhance_children_if_needed()
    }

    pub fn wishlists() -> WishlistRequest {
        WishlistRequest::new()
            .select_self()
            .and_filter(Expr::gt("version", 0_i64))
    }

    pub fn wishlists_minimal() -> WishlistRequest {
        WishlistRequest::new()
            .and_filter(Expr::gt("version", 0_i64))
    }

    pub fn wishlists_with_children() -> WishlistRequest {
        WishlistRequest::new()
            .unlimited()
            .select_self_fields()
            .enhance_children_if_needed()
    }

    pub fn promotions() -> PromotionRequest {
        PromotionRequest::new()
            .select_self()
            .and_filter(Expr::gt("version", 0_i64))
    }

    pub fn promotions_minimal() -> PromotionRequest {
        PromotionRequest::new()
            .and_filter(Expr::gt("version", 0_i64))
    }

    pub fn promotions_with_children() -> PromotionRequest {
        PromotionRequest::new()
            .unlimited()
            .select_self_fields()
            .enhance_children_if_needed()
    }

    pub fn coupons() -> CouponRequest {
        CouponRequest::new()
            .select_self()
            .and_filter(Expr::gt("version", 0_i64))
    }

    pub fn coupons_minimal() -> CouponRequest {
        CouponRequest::new()
            .and_filter(Expr::gt("version", 0_i64))
    }

    pub fn coupons_with_children() -> CouponRequest {
        CouponRequest::new()
            .unlimited()
            .select_self_fields()
            .enhance_children_if_needed()
    }

    pub fn invoices() -> InvoiceRequest {
        InvoiceRequest::new()
            .select_self()
            .and_filter(Expr::gt("version", 0_i64))
    }

    pub fn invoices_minimal() -> InvoiceRequest {
        InvoiceRequest::new()
            .and_filter(Expr::gt("version", 0_i64))
    }

    pub fn invoices_with_children() -> InvoiceRequest {
        InvoiceRequest::new()
            .unlimited()
            .select_self_fields()
            .enhance_children_if_needed()
    }

    pub fn payments() -> PaymentRequest {
        PaymentRequest::new()
            .select_self()
            .and_filter(Expr::gt("version", 0_i64))
    }

    pub fn payments_minimal() -> PaymentRequest {
        PaymentRequest::new()
            .and_filter(Expr::gt("version", 0_i64))
    }

    pub fn payments_with_children() -> PaymentRequest {
        PaymentRequest::new()
            .unlimited()
            .select_self_fields()
            .enhance_children_if_needed()
    }

    pub fn refunds() -> RefundRequest {
        RefundRequest::new()
            .select_self()
            .and_filter(Expr::gt("version", 0_i64))
    }

    pub fn refunds_minimal() -> RefundRequest {
        RefundRequest::new()
            .and_filter(Expr::gt("version", 0_i64))
    }

    pub fn refunds_with_children() -> RefundRequest {
        RefundRequest::new()
            .unlimited()
            .select_self_fields()
            .enhance_children_if_needed()
    }

    pub fn accounts() -> AccountRequest {
        AccountRequest::new()
            .select_self()
            .and_filter(Expr::gt("version", 0_i64))
    }

    pub fn accounts_minimal() -> AccountRequest {
        AccountRequest::new()
            .and_filter(Expr::gt("version", 0_i64))
    }

    pub fn accounts_with_children() -> AccountRequest {
        AccountRequest::new()
            .unlimited()
            .select_self_fields()
            .enhance_children_if_needed()
    }

    pub fn transactions() -> TransactionRequest {
        TransactionRequest::new()
            .select_self()
            .and_filter(Expr::gt("version", 0_i64))
    }

    pub fn transactions_minimal() -> TransactionRequest {
        TransactionRequest::new()
            .and_filter(Expr::gt("version", 0_i64))
    }

    pub fn transactions_with_children() -> TransactionRequest {
        TransactionRequest::new()
            .unlimited()
            .select_self_fields()
            .enhance_children_if_needed()
    }

    pub fn tax_rates() -> TaxRateRequest {
        TaxRateRequest::new()
            .select_self()
            .and_filter(Expr::gt("version", 0_i64))
    }

    pub fn tax_rates_minimal() -> TaxRateRequest {
        TaxRateRequest::new()
            .and_filter(Expr::gt("version", 0_i64))
    }

    pub fn tax_rates_with_children() -> TaxRateRequest {
        TaxRateRequest::new()
            .unlimited()
            .select_self_fields()
            .enhance_children_if_needed()
    }

    pub fn expenses() -> ExpenseRequest {
        ExpenseRequest::new()
            .select_self()
            .and_filter(Expr::gt("version", 0_i64))
    }

    pub fn expenses_minimal() -> ExpenseRequest {
        ExpenseRequest::new()
            .and_filter(Expr::gt("version", 0_i64))
    }

    pub fn expenses_with_children() -> ExpenseRequest {
        ExpenseRequest::new()
            .unlimited()
            .select_self_fields()
            .enhance_children_if_needed()
    }

    pub fn ledgers() -> LedgerRequest {
        LedgerRequest::new()
            .select_self()
            .and_filter(Expr::gt("version", 0_i64))
    }

    pub fn ledgers_minimal() -> LedgerRequest {
        LedgerRequest::new()
            .and_filter(Expr::gt("version", 0_i64))
    }

    pub fn ledgers_with_children() -> LedgerRequest {
        LedgerRequest::new()
            .unlimited()
            .select_self_fields()
            .enhance_children_if_needed()
    }

    pub fn suppliers() -> SupplierRequest {
        SupplierRequest::new()
            .select_self()
            .and_filter(Expr::gt("version", 0_i64))
    }

    pub fn suppliers_minimal() -> SupplierRequest {
        SupplierRequest::new()
            .and_filter(Expr::gt("version", 0_i64))
    }

    pub fn suppliers_with_children() -> SupplierRequest {
        SupplierRequest::new()
            .unlimited()
            .select_self_fields()
            .enhance_children_if_needed()
    }

    pub fn warehouses() -> WarehouseRequest {
        WarehouseRequest::new()
            .select_self()
            .and_filter(Expr::gt("version", 0_i64))
    }

    pub fn warehouses_minimal() -> WarehouseRequest {
        WarehouseRequest::new()
            .and_filter(Expr::gt("version", 0_i64))
    }

    pub fn warehouses_with_children() -> WarehouseRequest {
        WarehouseRequest::new()
            .unlimited()
            .select_self_fields()
            .enhance_children_if_needed()
    }

    pub fn inventory_items() -> InventoryItemRequest {
        InventoryItemRequest::new()
            .select_self()
            .and_filter(Expr::gt("version", 0_i64))
    }

    pub fn inventory_items_minimal() -> InventoryItemRequest {
        InventoryItemRequest::new()
            .and_filter(Expr::gt("version", 0_i64))
    }

    pub fn inventory_items_with_children() -> InventoryItemRequest {
        InventoryItemRequest::new()
            .unlimited()
            .select_self_fields()
            .enhance_children_if_needed()
    }

    pub fn purchase_orders() -> PurchaseOrderRequest {
        PurchaseOrderRequest::new()
            .select_self()
            .and_filter(Expr::gt("version", 0_i64))
    }

    pub fn purchase_orders_minimal() -> PurchaseOrderRequest {
        PurchaseOrderRequest::new()
            .and_filter(Expr::gt("version", 0_i64))
    }

    pub fn purchase_orders_with_children() -> PurchaseOrderRequest {
        PurchaseOrderRequest::new()
            .unlimited()
            .select_self_fields()
            .enhance_children_if_needed()
    }

    pub fn purchase_order_items() -> PurchaseOrderItemRequest {
        PurchaseOrderItemRequest::new()
            .select_self()
            .and_filter(Expr::gt("version", 0_i64))
    }

    pub fn purchase_order_items_minimal() -> PurchaseOrderItemRequest {
        PurchaseOrderItemRequest::new()
            .and_filter(Expr::gt("version", 0_i64))
    }

    pub fn purchase_order_items_with_children() -> PurchaseOrderItemRequest {
        PurchaseOrderItemRequest::new()
            .unlimited()
            .select_self_fields()
            .enhance_children_if_needed()
    }

    pub fn shipments() -> ShipmentRequest {
        ShipmentRequest::new()
            .select_self()
            .and_filter(Expr::gt("version", 0_i64))
    }

    pub fn shipments_minimal() -> ShipmentRequest {
        ShipmentRequest::new()
            .and_filter(Expr::gt("version", 0_i64))
    }

    pub fn shipments_with_children() -> ShipmentRequest {
        ShipmentRequest::new()
            .unlimited()
            .select_self_fields()
            .enhance_children_if_needed()
    }

    pub fn deliveries() -> DeliveryRequest {
        DeliveryRequest::new()
            .select_self()
            .and_filter(Expr::gt("version", 0_i64))
    }

    pub fn deliveries_minimal() -> DeliveryRequest {
        DeliveryRequest::new()
            .and_filter(Expr::gt("version", 0_i64))
    }

    pub fn deliveries_with_children() -> DeliveryRequest {
        DeliveryRequest::new()
            .unlimited()
            .select_self_fields()
            .enhance_children_if_needed()
    }

    pub fn return_requests() -> ReturnRequestRequest {
        ReturnRequestRequest::new()
            .select_self()
            .and_filter(Expr::gt("version", 0_i64))
    }

    pub fn return_requests_minimal() -> ReturnRequestRequest {
        ReturnRequestRequest::new()
            .and_filter(Expr::gt("version", 0_i64))
    }

    pub fn return_requests_with_children() -> ReturnRequestRequest {
        ReturnRequestRequest::new()
            .unlimited()
            .select_self_fields()
            .enhance_children_if_needed()
    }

    pub fn tickets() -> TicketRequest {
        TicketRequest::new()
            .select_self()
            .and_filter(Expr::gt("version", 0_i64))
    }

    pub fn tickets_minimal() -> TicketRequest {
        TicketRequest::new()
            .and_filter(Expr::gt("version", 0_i64))
    }

    pub fn tickets_with_children() -> TicketRequest {
        TicketRequest::new()
            .unlimited()
            .select_self_fields()
            .enhance_children_if_needed()
    }

    pub fn ticket_comments() -> TicketCommentRequest {
        TicketCommentRequest::new()
            .select_self()
            .and_filter(Expr::gt("version", 0_i64))
    }

    pub fn ticket_comments_minimal() -> TicketCommentRequest {
        TicketCommentRequest::new()
            .and_filter(Expr::gt("version", 0_i64))
    }

    pub fn ticket_comments_with_children() -> TicketCommentRequest {
        TicketCommentRequest::new()
            .unlimited()
            .select_self_fields()
            .enhance_children_if_needed()
    }

    pub fn slas() -> SlaRequest {
        SlaRequest::new()
            .select_self()
            .and_filter(Expr::gt("version", 0_i64))
    }

    pub fn slas_minimal() -> SlaRequest {
        SlaRequest::new()
            .and_filter(Expr::gt("version", 0_i64))
    }

    pub fn slas_with_children() -> SlaRequest {
        SlaRequest::new()
            .unlimited()
            .select_self_fields()
            .enhance_children_if_needed()
    }

    pub fn knowledge_bases() -> KnowledgeBaseRequest {
        KnowledgeBaseRequest::new()
            .select_self()
            .and_filter(Expr::gt("version", 0_i64))
    }

    pub fn knowledge_bases_minimal() -> KnowledgeBaseRequest {
        KnowledgeBaseRequest::new()
            .and_filter(Expr::gt("version", 0_i64))
    }

    pub fn knowledge_bases_with_children() -> KnowledgeBaseRequest {
        KnowledgeBaseRequest::new()
            .unlimited()
            .select_self_fields()
            .enhance_children_if_needed()
    }

    pub fn support_agents() -> SupportAgentRequest {
        SupportAgentRequest::new()
            .select_self()
            .and_filter(Expr::gt("version", 0_i64))
    }

    pub fn support_agents_minimal() -> SupportAgentRequest {
        SupportAgentRequest::new()
            .and_filter(Expr::gt("version", 0_i64))
    }

    pub fn support_agents_with_children() -> SupportAgentRequest {
        SupportAgentRequest::new()
            .unlimited()
            .select_self_fields()
            .enhance_children_if_needed()
    }
}