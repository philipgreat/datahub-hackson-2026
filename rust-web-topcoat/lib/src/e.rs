
// The `E` expression wrapper provides zero-cost AST traversal
// and will automatically panic if it encounters a NotLoaded error.
pub struct E;

impl E {
    pub fn employee<'a>(value: &'a crate::Employee) -> crate::EmployeeExpression<'a> {
        let root_desc = std::sync::Arc::new(format!("Employee(id={})", value.id()));
        crate::EmployeeExpression::new(teaql_core::eval::EvalResult::Value(value), root_desc)
    }

    pub fn department<'a>(value: &'a crate::Department) -> crate::DepartmentExpression<'a> {
        let root_desc = std::sync::Arc::new(format!("Department(id={})", value.id()));
        crate::DepartmentExpression::new(teaql_core::eval::EvalResult::Value(value), root_desc)
    }

    pub fn position<'a>(value: &'a crate::Position) -> crate::PositionExpression<'a> {
        let root_desc = std::sync::Arc::new(format!("Position(id={})", value.id()));
        crate::PositionExpression::new(teaql_core::eval::EvalResult::Value(value), root_desc)
    }

    pub fn leave_request<'a>(value: &'a crate::LeaveRequest) -> crate::LeaveRequestExpression<'a> {
        let root_desc = std::sync::Arc::new(format!("LeaveRequest(id={})", value.id()));
        crate::LeaveRequestExpression::new(teaql_core::eval::EvalResult::Value(value), root_desc)
    }

    pub fn attendance<'a>(value: &'a crate::Attendance) -> crate::AttendanceExpression<'a> {
        let root_desc = std::sync::Arc::new(format!("Attendance(id={})", value.id()));
        crate::AttendanceExpression::new(teaql_core::eval::EvalResult::Value(value), root_desc)
    }

    pub fn benefit<'a>(value: &'a crate::Benefit) -> crate::BenefitExpression<'a> {
        let root_desc = std::sync::Arc::new(format!("Benefit(id={})", value.id()));
        crate::BenefitExpression::new(teaql_core::eval::EvalResult::Value(value), root_desc)
    }

    pub fn employee_review<'a>(value: &'a crate::EmployeeReview) -> crate::EmployeeReviewExpression<'a> {
        let root_desc = std::sync::Arc::new(format!("EmployeeReview(id={})", value.id()));
        crate::EmployeeReviewExpression::new(teaql_core::eval::EvalResult::Value(value), root_desc)
    }

    pub fn payroll<'a>(value: &'a crate::Payroll) -> crate::PayrollExpression<'a> {
        let root_desc = std::sync::Arc::new(format!("Payroll(id={})", value.id()));
        crate::PayrollExpression::new(teaql_core::eval::EvalResult::Value(value), root_desc)
    }

    pub fn customer<'a>(value: &'a crate::Customer) -> crate::CustomerExpression<'a> {
        let root_desc = std::sync::Arc::new(format!("Customer(id={})", value.id()));
        crate::CustomerExpression::new(teaql_core::eval::EvalResult::Value(value), root_desc)
    }

    pub fn lead<'a>(value: &'a crate::Lead) -> crate::LeadExpression<'a> {
        let root_desc = std::sync::Arc::new(format!("Lead(id={})", value.id()));
        crate::LeadExpression::new(teaql_core::eval::EvalResult::Value(value), root_desc)
    }

    pub fn opportunity<'a>(value: &'a crate::Opportunity) -> crate::OpportunityExpression<'a> {
        let root_desc = std::sync::Arc::new(format!("Opportunity(id={})", value.id()));
        crate::OpportunityExpression::new(teaql_core::eval::EvalResult::Value(value), root_desc)
    }

    pub fn contact<'a>(value: &'a crate::Contact) -> crate::ContactExpression<'a> {
        let root_desc = std::sync::Arc::new(format!("Contact(id={})", value.id()));
        crate::ContactExpression::new(teaql_core::eval::EvalResult::Value(value), root_desc)
    }

    pub fn campaign<'a>(value: &'a crate::Campaign) -> crate::CampaignExpression<'a> {
        let root_desc = std::sync::Arc::new(format!("Campaign(id={})", value.id()));
        crate::CampaignExpression::new(teaql_core::eval::EvalResult::Value(value), root_desc)
    }

    pub fn contract<'a>(value: &'a crate::Contract) -> crate::ContractExpression<'a> {
        let root_desc = std::sync::Arc::new(format!("Contract(id={})", value.id()));
        crate::ContractExpression::new(teaql_core::eval::EvalResult::Value(value), root_desc)
    }

    pub fn quote<'a>(value: &'a crate::Quote) -> crate::QuoteExpression<'a> {
        let root_desc = std::sync::Arc::new(format!("Quote(id={})", value.id()));
        crate::QuoteExpression::new(teaql_core::eval::EvalResult::Value(value), root_desc)
    }

    pub fn sales_territory<'a>(value: &'a crate::SalesTerritory) -> crate::SalesTerritoryExpression<'a> {
        let root_desc = std::sync::Arc::new(format!("SalesTerritory(id={})", value.id()));
        crate::SalesTerritoryExpression::new(teaql_core::eval::EvalResult::Value(value), root_desc)
    }

    pub fn product<'a>(value: &'a crate::Product) -> crate::ProductExpression<'a> {
        let root_desc = std::sync::Arc::new(format!("Product(id={})", value.id()));
        crate::ProductExpression::new(teaql_core::eval::EvalResult::Value(value), root_desc)
    }

    pub fn category<'a>(value: &'a crate::Category) -> crate::CategoryExpression<'a> {
        let root_desc = std::sync::Arc::new(format!("Category(id={})", value.id()));
        crate::CategoryExpression::new(teaql_core::eval::EvalResult::Value(value), root_desc)
    }

    pub fn catalog<'a>(value: &'a crate::Catalog) -> crate::CatalogExpression<'a> {
        let root_desc = std::sync::Arc::new(format!("Catalog(id={})", value.id()));
        crate::CatalogExpression::new(teaql_core::eval::EvalResult::Value(value), root_desc)
    }

    pub fn product_review<'a>(value: &'a crate::ProductReview) -> crate::ProductReviewExpression<'a> {
        let root_desc = std::sync::Arc::new(format!("ProductReview(id={})", value.id()));
        crate::ProductReviewExpression::new(teaql_core::eval::EvalResult::Value(value), root_desc)
    }

    pub fn shopping_cart<'a>(value: &'a crate::ShoppingCart) -> crate::ShoppingCartExpression<'a> {
        let root_desc = std::sync::Arc::new(format!("ShoppingCart(id={})", value.id()));
        crate::ShoppingCartExpression::new(teaql_core::eval::EvalResult::Value(value), root_desc)
    }

    pub fn cart_item<'a>(value: &'a crate::CartItem) -> crate::CartItemExpression<'a> {
        let root_desc = std::sync::Arc::new(format!("CartItem(id={})", value.id()));
        crate::CartItemExpression::new(teaql_core::eval::EvalResult::Value(value), root_desc)
    }

    pub fn global_order<'a>(value: &'a crate::GlobalOrder) -> crate::GlobalOrderExpression<'a> {
        let root_desc = std::sync::Arc::new(format!("GlobalOrder(id={})", value.id()));
        crate::GlobalOrderExpression::new(teaql_core::eval::EvalResult::Value(value), root_desc)
    }

    pub fn order_item<'a>(value: &'a crate::OrderItem) -> crate::OrderItemExpression<'a> {
        let root_desc = std::sync::Arc::new(format!("OrderItem(id={})", value.id()));
        crate::OrderItemExpression::new(teaql_core::eval::EvalResult::Value(value), root_desc)
    }

    pub fn wishlist<'a>(value: &'a crate::Wishlist) -> crate::WishlistExpression<'a> {
        let root_desc = std::sync::Arc::new(format!("Wishlist(id={})", value.id()));
        crate::WishlistExpression::new(teaql_core::eval::EvalResult::Value(value), root_desc)
    }

    pub fn promotion<'a>(value: &'a crate::Promotion) -> crate::PromotionExpression<'a> {
        let root_desc = std::sync::Arc::new(format!("Promotion(id={})", value.id()));
        crate::PromotionExpression::new(teaql_core::eval::EvalResult::Value(value), root_desc)
    }

    pub fn coupon<'a>(value: &'a crate::Coupon) -> crate::CouponExpression<'a> {
        let root_desc = std::sync::Arc::new(format!("Coupon(id={})", value.id()));
        crate::CouponExpression::new(teaql_core::eval::EvalResult::Value(value), root_desc)
    }

    pub fn invoice<'a>(value: &'a crate::Invoice) -> crate::InvoiceExpression<'a> {
        let root_desc = std::sync::Arc::new(format!("Invoice(id={})", value.id()));
        crate::InvoiceExpression::new(teaql_core::eval::EvalResult::Value(value), root_desc)
    }

    pub fn payment<'a>(value: &'a crate::Payment) -> crate::PaymentExpression<'a> {
        let root_desc = std::sync::Arc::new(format!("Payment(id={})", value.id()));
        crate::PaymentExpression::new(teaql_core::eval::EvalResult::Value(value), root_desc)
    }

    pub fn refund<'a>(value: &'a crate::Refund) -> crate::RefundExpression<'a> {
        let root_desc = std::sync::Arc::new(format!("Refund(id={})", value.id()));
        crate::RefundExpression::new(teaql_core::eval::EvalResult::Value(value), root_desc)
    }

    pub fn account<'a>(value: &'a crate::Account) -> crate::AccountExpression<'a> {
        let root_desc = std::sync::Arc::new(format!("Account(id={})", value.id()));
        crate::AccountExpression::new(teaql_core::eval::EvalResult::Value(value), root_desc)
    }

    pub fn transaction<'a>(value: &'a crate::Transaction) -> crate::TransactionExpression<'a> {
        let root_desc = std::sync::Arc::new(format!("Transaction(id={})", value.id()));
        crate::TransactionExpression::new(teaql_core::eval::EvalResult::Value(value), root_desc)
    }

    pub fn tax_rate<'a>(value: &'a crate::TaxRate) -> crate::TaxRateExpression<'a> {
        let root_desc = std::sync::Arc::new(format!("TaxRate(id={})", value.id()));
        crate::TaxRateExpression::new(teaql_core::eval::EvalResult::Value(value), root_desc)
    }

    pub fn expense<'a>(value: &'a crate::Expense) -> crate::ExpenseExpression<'a> {
        let root_desc = std::sync::Arc::new(format!("Expense(id={})", value.id()));
        crate::ExpenseExpression::new(teaql_core::eval::EvalResult::Value(value), root_desc)
    }

    pub fn ledger<'a>(value: &'a crate::Ledger) -> crate::LedgerExpression<'a> {
        let root_desc = std::sync::Arc::new(format!("Ledger(id={})", value.id()));
        crate::LedgerExpression::new(teaql_core::eval::EvalResult::Value(value), root_desc)
    }

    pub fn supplier<'a>(value: &'a crate::Supplier) -> crate::SupplierExpression<'a> {
        let root_desc = std::sync::Arc::new(format!("Supplier(id={})", value.id()));
        crate::SupplierExpression::new(teaql_core::eval::EvalResult::Value(value), root_desc)
    }

    pub fn warehouse<'a>(value: &'a crate::Warehouse) -> crate::WarehouseExpression<'a> {
        let root_desc = std::sync::Arc::new(format!("Warehouse(id={})", value.id()));
        crate::WarehouseExpression::new(teaql_core::eval::EvalResult::Value(value), root_desc)
    }

    pub fn inventory_item<'a>(value: &'a crate::InventoryItem) -> crate::InventoryItemExpression<'a> {
        let root_desc = std::sync::Arc::new(format!("InventoryItem(id={})", value.id()));
        crate::InventoryItemExpression::new(teaql_core::eval::EvalResult::Value(value), root_desc)
    }

    pub fn purchase_order<'a>(value: &'a crate::PurchaseOrder) -> crate::PurchaseOrderExpression<'a> {
        let root_desc = std::sync::Arc::new(format!("PurchaseOrder(id={})", value.id()));
        crate::PurchaseOrderExpression::new(teaql_core::eval::EvalResult::Value(value), root_desc)
    }

    pub fn purchase_order_item<'a>(value: &'a crate::PurchaseOrderItem) -> crate::PurchaseOrderItemExpression<'a> {
        let root_desc = std::sync::Arc::new(format!("PurchaseOrderItem(id={})", value.id()));
        crate::PurchaseOrderItemExpression::new(teaql_core::eval::EvalResult::Value(value), root_desc)
    }

    pub fn shipment<'a>(value: &'a crate::Shipment) -> crate::ShipmentExpression<'a> {
        let root_desc = std::sync::Arc::new(format!("Shipment(id={})", value.id()));
        crate::ShipmentExpression::new(teaql_core::eval::EvalResult::Value(value), root_desc)
    }

    pub fn delivery<'a>(value: &'a crate::Delivery) -> crate::DeliveryExpression<'a> {
        let root_desc = std::sync::Arc::new(format!("Delivery(id={})", value.id()));
        crate::DeliveryExpression::new(teaql_core::eval::EvalResult::Value(value), root_desc)
    }

    pub fn return_request<'a>(value: &'a crate::ReturnRequest) -> crate::ReturnRequestExpression<'a> {
        let root_desc = std::sync::Arc::new(format!("ReturnRequest(id={})", value.id()));
        crate::ReturnRequestExpression::new(teaql_core::eval::EvalResult::Value(value), root_desc)
    }

    pub fn ticket<'a>(value: &'a crate::Ticket) -> crate::TicketExpression<'a> {
        let root_desc = std::sync::Arc::new(format!("Ticket(id={})", value.id()));
        crate::TicketExpression::new(teaql_core::eval::EvalResult::Value(value), root_desc)
    }

    pub fn ticket_comment<'a>(value: &'a crate::TicketComment) -> crate::TicketCommentExpression<'a> {
        let root_desc = std::sync::Arc::new(format!("TicketComment(id={})", value.id()));
        crate::TicketCommentExpression::new(teaql_core::eval::EvalResult::Value(value), root_desc)
    }

    pub fn sla<'a>(value: &'a crate::Sla) -> crate::SlaExpression<'a> {
        let root_desc = std::sync::Arc::new(format!("Sla(id={})", value.id()));
        crate::SlaExpression::new(teaql_core::eval::EvalResult::Value(value), root_desc)
    }

    pub fn knowledge_base<'a>(value: &'a crate::KnowledgeBase) -> crate::KnowledgeBaseExpression<'a> {
        let root_desc = std::sync::Arc::new(format!("KnowledgeBase(id={})", value.id()));
        crate::KnowledgeBaseExpression::new(teaql_core::eval::EvalResult::Value(value), root_desc)
    }

    pub fn support_agent<'a>(value: &'a crate::SupportAgent) -> crate::SupportAgentExpression<'a> {
        let root_desc = std::sync::Arc::new(format!("SupportAgent(id={})", value.id()));
        crate::SupportAgentExpression::new(teaql_core::eval::EvalResult::Value(value), root_desc)
    }
}


pub fn trigger_logic_bug_panic(root_desc: &str, failed_node: &str, attempted_path: &str) -> ! {
    let parts: Vec<&str> = attempted_path.split('.').collect();
    let break_idx = parts.iter().position(|&p| p == failed_node).unwrap_or(0);

    let mut nested_fix = String::new();
    if break_idx < parts.len() - 1 {
        nested_fix.push_str(&format!("\"select_{}(", failed_node));
        let mut close_parens = 1;
        for i in (break_idx + 1)..parts.len() {
            let sub_field = parts[i];
            let prev_field = parts[i-1];
            let is_last = i == parts.len() - 1;
            if is_last {
                nested_fix.push_str(&format!("Q::{}s().select_{}()", prev_field, sub_field));
            } else {
                nested_fix.push_str(&format!("Q::{}s().select_{}(", prev_field, sub_field));
                close_parens += 1;
            }
        }
        for _ in 0..close_parens {
            nested_fix.push(')');
        }
        nested_fix.push('"');
    } else {
        nested_fix = "null".to_string();
    }

    let suggested_fix = format!("\"select_{}()\"", failed_node);

    let access_path_json = format!("[{}]", parts.iter().map(|s| format!("\"{}\"", s)).collect::<Vec<_>>().join(", "));
    let missing_preload_json = format!("[\"{}\"]", failed_node);

    let human_nested = if nested_fix != "null" { format!(" 或完整嵌套加载 {}", nested_fix) } else { String::new() };
    let root_name = root_desc.split('(').next().unwrap_or("Unknown");

    let mut root_snake = String::new();
    for (i, c) in root_name.chars().enumerate() {
        if c.is_uppercase() {
            if i > 0 {
                root_snake.push('_');
            }
            root_snake.push(c.to_ascii_lowercase());
        } else {
            root_snake.push(c);
        }
    }
    let id_part = root_desc.split('(').nth(1).unwrap_or(")");
    let mut original_expr = format!("E::{}({}", root_snake, id_part);
    for p in &parts {
        original_expr.push_str(&format!(".get_{}()", p));
        if *p == failed_node {
            original_expr.push_str("<broken>");
        }
    }

    let human_message = format!("\"访问 {}.{} 时缺少预加载。请在查询中加入 {}{}\"", root_name, attempted_path, suggested_fix, human_nested);

    panic!("\n\n💥 [Coding Logic Bug]\n\noriginal_expr_with_broken_point: \"{}\"\nroot: {}\naccess_path: {}\nbreak_point: \"{}\"\nmissing_preload: {}\nsuggested_fix: {}\nnested_fix: {}\nseverity: \"error\"\nhuman_message: {}\n", 
        original_expr, root_desc, access_path_json, failed_node, missing_preload_json, suggested_fix, nested_fix, human_message);
}

#[derive(Clone)]
pub struct ValueExpression<'a, T> {
    result: teaql_core::eval::EvalResult<T>,
    root_desc: std::sync::Arc<String>,
    _phantom: std::marker::PhantomData<&'a ()>,
}

impl<'a, T: Clone> ValueExpression<'a, T> {
    pub fn new(result: teaql_core::eval::EvalResult<T>, root_desc: std::sync::Arc<String>) -> Self {
        Self { result, root_desc, _phantom: std::marker::PhantomData }
    }

    fn resolve(self) -> Option<T> {
        match self.result {
            teaql_core::eval::EvalResult::Value(v) => Some(v),
            teaql_core::eval::EvalResult::Null => None,
            teaql_core::eval::EvalResult::NotLoaded { failed_node, attempted_path } => {
                crate::trigger_logic_bug_panic(&self.root_desc, &failed_node, &attempted_path)
            }
        }
    }

    pub fn eval(self) -> Option<T> {
        self.resolve()
    }

    pub fn unwrap(self) -> T {
        self.resolve().expect("Value was legitimately null in database!")
    }

    pub fn or_else(self, default_value: T) -> T {
        self.eval().unwrap_or(default_value)
    }

    pub fn or_else_with(self, default_fn: impl FnOnce() -> T) -> T {
        self.eval().unwrap_or_else(default_fn)
    }

    pub fn or_default(self) -> T where T: Default {
        self.eval().unwrap_or_default()
    }
}

