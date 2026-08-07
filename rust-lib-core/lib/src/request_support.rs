
#![allow(unused_imports)]
#![allow(async_fn_in_trait)]
use std::{collections::BTreeMap, future::Future, marker::PhantomData};

use serde_json::Value as JsonValue;
use teaql_core::{
    BinaryOp, Expr, Record,
    RelationAggregate as RuntimeRelationAggregate, SelectQuery, SmartList,
};
use teaql_runtime::{ContextError, GraphNode, EntityDataServiceBehavior, DataServiceError, PurposedSelectQuery, RuntimeError, UserContext};

// Re-export query builder types from teaql_core::request
pub use teaql_core::request::{
    COUNT_ALIAS, TYPE_FIELD, TYPE_GROUP_FIELD,
    FieldOperator, DateRange, EntityReference,
    QuerySelection, RelationSelection, RelationFilter, QueryOptions,
    UnsafeRawSqlSegment, RawDynamicProperty, RawProjection,
    RelationAggregate, FacetRequest, ObjectGroupBy,
    apply_relation_selections, apply_runtime_metadata,
    field_operator_expr, field_operator_column_expr,
    required_value, required_text,
    remove_default_live_filter, remove_filter_expr,
    dynamic_json_value_to_teaql_value, dynamic_json_values,
    dynamic_json_operator, dynamic_json_filter_expr,
    dynamic_json_u64_field,
    runtime_relation_aggregates,
    merge_outer_filter_into_facet_aggregates, attach_facets,
};


pub trait TeaqlRecordRepository {
    type Error: std::error::Error + Send + Sync + 'static;

    async fn fetch_all(&self, query: &PurposedSelectQuery) -> Result<Vec<Record>, DataServiceError<Self::Error>>;

    async fn fetch_smart_list(&self, query: &PurposedSelectQuery) -> Result<SmartList<Record>, DataServiceError<Self::Error>>;

    async fn fetch_smart_list_with_relation_aggregates(
        &self,
        query: &PurposedSelectQuery,
        relation_aggregates: &[RuntimeRelationAggregate],
    ) -> Result<SmartList<Record>, DataServiceError<Self::Error>>;

    async fn fetch_stream(&self, query: &PurposedSelectQuery) -> Result<Vec<teaql_data_service::StreamChunk>, DataServiceError<Self::Error>>;
}

pub trait TeaqlEntityRepository: TeaqlRecordRepository {
    async fn fetch_enhanced_entities<T>(&self, query: &PurposedSelectQuery) -> Result<SmartList<T>, DataServiceError<Self::Error>>
    where
        T: teaql_core::Entity;

    async fn fetch_enhanced_entities_with_relation_aggregates<T>(
        &self,
        query: &PurposedSelectQuery,
        relation_aggregates: &[RuntimeRelationAggregate],
    ) -> Result<SmartList<T>, DataServiceError<Self::Error>>
    where
        T: teaql_core::Entity;

}

impl<'a, E> TeaqlRecordRepository for teaql_runtime::EntityDataService<'a, E>
where
    E: teaql_data_service::QueryExecutor + teaql_data_service::MutationExecutor + teaql_data_service::StreamQueryExecutor + Send + Sync + 'static,
{
    type Error = E::Error;

    async fn fetch_all(&self, query: &PurposedSelectQuery) -> Result<Vec<Record>, DataServiceError<Self::Error>> {
        teaql_runtime::EntityDataService::fetch_all(self, query).await
    }

    async fn fetch_smart_list(&self, query: &PurposedSelectQuery) -> Result<SmartList<Record>, DataServiceError<Self::Error>> {
        teaql_runtime::EntityDataService::fetch_smart_list(self, query).await
    }

    async fn fetch_smart_list_with_relation_aggregates(
        &self,
        query: &PurposedSelectQuery,
        relation_aggregates: &[RuntimeRelationAggregate],
    ) -> Result<SmartList<Record>, DataServiceError<Self::Error>> {
        teaql_runtime::EntityDataService::fetch_smart_list_with_relation_aggregates(
            self,
            query,
            relation_aggregates,
        ).await
    }

    async fn fetch_stream(&self, query: &PurposedSelectQuery) -> Result<Vec<teaql_data_service::StreamChunk>, DataServiceError<Self::Error>> {
        teaql_runtime::EntityDataService::fetch_stream(self, query).await
    }
}

impl<'a, E> TeaqlEntityRepository for teaql_runtime::EntityDataService<'a, E>
where
    E: teaql_data_service::QueryExecutor + teaql_data_service::MutationExecutor + teaql_data_service::StreamQueryExecutor + Send + Sync + 'static,
{
    async fn fetch_enhanced_entities<T>(&self, query: &PurposedSelectQuery) -> Result<SmartList<T>, DataServiceError<Self::Error>>
    where
        T: teaql_core::Entity,
    {
        teaql_runtime::EntityDataService::fetch_enhanced_entities(self, query).await
    }

    async fn fetch_enhanced_entities_with_relation_aggregates<T>(
        &self,
        query: &PurposedSelectQuery,
        relation_aggregates: &[RuntimeRelationAggregate],
    ) -> Result<SmartList<T>, DataServiceError<Self::Error>>
    where
        T: teaql_core::Entity,
    {
        teaql_runtime::EntityDataService::fetch_enhanced_entities_with_relation_aggregates(
            self,
            query,
            relation_aggregates,
        ).await
    }

}

pub type TeaqlDataServiceError<R> = DataServiceError<<R as TeaqlRecordRepository>::Error>;

pub(crate) fn authorize_query(mut query: SelectQuery) -> Result<PurposedSelectQuery, RuntimeError> {
    let purpose = query
        .trace_chain
        .pop()
        .map(|node| node.comment)
        .filter(|purpose| !purpose.trim().is_empty())
        .ok_or_else(|| RuntimeError::Graph(
            "generated query reached the repository without .purpose(...)".to_owned()
        ))?;
    Ok(PurposedSelectQuery::new(query, purpose))
}

pub trait TeaqlRuntime {
    fn user_context(&self) -> &UserContext;

    fn fetch_facet_smart_list(
        &self,
        entity: &str,
        query: &PurposedSelectQuery,
        relation_aggregates: &[RuntimeRelationAggregate],
        trace_context: Vec<teaql_core::TraceNode>,
    ) -> impl std::future::Future<Output = Result<SmartList<Record>, RuntimeError>> + Send;
}

/// Internal trait for repository access. Application code should not use this trait directly.
#[doc(hidden)]
pub trait AuditedSave<'a, C>
where
    C: TeaqlRepositoryProvider + ?Sized + 'a,
{
    type Error;
    fn save(self, ctx: &'a C) -> std::pin::Pin<Box<dyn std::future::Future<Output = Result<teaql_runtime::GraphNode, Self::Error>> + '_>>;
}



pub trait TeaqlRepositoryProvider: TeaqlRuntime {
    type EmployeeRepository<'a>: TeaqlEntityRepository + 'a
    where
        Self: 'a;

    fn employee_repository(&self) -> Result<Self::EmployeeRepository<'_>, ContextError>;
    type DepartmentRepository<'a>: TeaqlEntityRepository + 'a
    where
        Self: 'a;

    fn department_repository(&self) -> Result<Self::DepartmentRepository<'_>, ContextError>;
    type PositionRepository<'a>: TeaqlEntityRepository + 'a
    where
        Self: 'a;

    fn position_repository(&self) -> Result<Self::PositionRepository<'_>, ContextError>;
    type LeaveRequestRepository<'a>: TeaqlEntityRepository + 'a
    where
        Self: 'a;

    fn leave_request_repository(&self) -> Result<Self::LeaveRequestRepository<'_>, ContextError>;
    type AttendanceRepository<'a>: TeaqlEntityRepository + 'a
    where
        Self: 'a;

    fn attendance_repository(&self) -> Result<Self::AttendanceRepository<'_>, ContextError>;
    type BenefitRepository<'a>: TeaqlEntityRepository + 'a
    where
        Self: 'a;

    fn benefit_repository(&self) -> Result<Self::BenefitRepository<'_>, ContextError>;
    type EmployeeReviewRepository<'a>: TeaqlEntityRepository + 'a
    where
        Self: 'a;

    fn employee_review_repository(&self) -> Result<Self::EmployeeReviewRepository<'_>, ContextError>;
    type PayrollRepository<'a>: TeaqlEntityRepository + 'a
    where
        Self: 'a;

    fn payroll_repository(&self) -> Result<Self::PayrollRepository<'_>, ContextError>;
    type CustomerRepository<'a>: TeaqlEntityRepository + 'a
    where
        Self: 'a;

    fn customer_repository(&self) -> Result<Self::CustomerRepository<'_>, ContextError>;
    type LeadRepository<'a>: TeaqlEntityRepository + 'a
    where
        Self: 'a;

    fn lead_repository(&self) -> Result<Self::LeadRepository<'_>, ContextError>;
    type OpportunityRepository<'a>: TeaqlEntityRepository + 'a
    where
        Self: 'a;

    fn opportunity_repository(&self) -> Result<Self::OpportunityRepository<'_>, ContextError>;
    type ContactRepository<'a>: TeaqlEntityRepository + 'a
    where
        Self: 'a;

    fn contact_repository(&self) -> Result<Self::ContactRepository<'_>, ContextError>;
    type CampaignRepository<'a>: TeaqlEntityRepository + 'a
    where
        Self: 'a;

    fn campaign_repository(&self) -> Result<Self::CampaignRepository<'_>, ContextError>;
    type ContractRepository<'a>: TeaqlEntityRepository + 'a
    where
        Self: 'a;

    fn contract_repository(&self) -> Result<Self::ContractRepository<'_>, ContextError>;
    type QuoteRepository<'a>: TeaqlEntityRepository + 'a
    where
        Self: 'a;

    fn quote_repository(&self) -> Result<Self::QuoteRepository<'_>, ContextError>;
    type SalesTerritoryRepository<'a>: TeaqlEntityRepository + 'a
    where
        Self: 'a;

    fn sales_territory_repository(&self) -> Result<Self::SalesTerritoryRepository<'_>, ContextError>;
    type ProductRepository<'a>: TeaqlEntityRepository + 'a
    where
        Self: 'a;

    fn product_repository(&self) -> Result<Self::ProductRepository<'_>, ContextError>;
    type CategoryRepository<'a>: TeaqlEntityRepository + 'a
    where
        Self: 'a;

    fn category_repository(&self) -> Result<Self::CategoryRepository<'_>, ContextError>;
    type CatalogRepository<'a>: TeaqlEntityRepository + 'a
    where
        Self: 'a;

    fn catalog_repository(&self) -> Result<Self::CatalogRepository<'_>, ContextError>;
    type ProductReviewRepository<'a>: TeaqlEntityRepository + 'a
    where
        Self: 'a;

    fn product_review_repository(&self) -> Result<Self::ProductReviewRepository<'_>, ContextError>;
    type ShoppingCartRepository<'a>: TeaqlEntityRepository + 'a
    where
        Self: 'a;

    fn shopping_cart_repository(&self) -> Result<Self::ShoppingCartRepository<'_>, ContextError>;
    type CartItemRepository<'a>: TeaqlEntityRepository + 'a
    where
        Self: 'a;

    fn cart_item_repository(&self) -> Result<Self::CartItemRepository<'_>, ContextError>;
    type GlobalOrderRepository<'a>: TeaqlEntityRepository + 'a
    where
        Self: 'a;

    fn global_order_repository(&self) -> Result<Self::GlobalOrderRepository<'_>, ContextError>;
    type OrderItemRepository<'a>: TeaqlEntityRepository + 'a
    where
        Self: 'a;

    fn order_item_repository(&self) -> Result<Self::OrderItemRepository<'_>, ContextError>;
    type WishlistRepository<'a>: TeaqlEntityRepository + 'a
    where
        Self: 'a;

    fn wishlist_repository(&self) -> Result<Self::WishlistRepository<'_>, ContextError>;
    type PromotionRepository<'a>: TeaqlEntityRepository + 'a
    where
        Self: 'a;

    fn promotion_repository(&self) -> Result<Self::PromotionRepository<'_>, ContextError>;
    type CouponRepository<'a>: TeaqlEntityRepository + 'a
    where
        Self: 'a;

    fn coupon_repository(&self) -> Result<Self::CouponRepository<'_>, ContextError>;
    type InvoiceRepository<'a>: TeaqlEntityRepository + 'a
    where
        Self: 'a;

    fn invoice_repository(&self) -> Result<Self::InvoiceRepository<'_>, ContextError>;
    type PaymentRepository<'a>: TeaqlEntityRepository + 'a
    where
        Self: 'a;

    fn payment_repository(&self) -> Result<Self::PaymentRepository<'_>, ContextError>;
    type RefundRepository<'a>: TeaqlEntityRepository + 'a
    where
        Self: 'a;

    fn refund_repository(&self) -> Result<Self::RefundRepository<'_>, ContextError>;
    type AccountRepository<'a>: TeaqlEntityRepository + 'a
    where
        Self: 'a;

    fn account_repository(&self) -> Result<Self::AccountRepository<'_>, ContextError>;
    type TransactionRepository<'a>: TeaqlEntityRepository + 'a
    where
        Self: 'a;

    fn transaction_repository(&self) -> Result<Self::TransactionRepository<'_>, ContextError>;
    type TaxRateRepository<'a>: TeaqlEntityRepository + 'a
    where
        Self: 'a;

    fn tax_rate_repository(&self) -> Result<Self::TaxRateRepository<'_>, ContextError>;
    type ExpenseRepository<'a>: TeaqlEntityRepository + 'a
    where
        Self: 'a;

    fn expense_repository(&self) -> Result<Self::ExpenseRepository<'_>, ContextError>;
    type LedgerRepository<'a>: TeaqlEntityRepository + 'a
    where
        Self: 'a;

    fn ledger_repository(&self) -> Result<Self::LedgerRepository<'_>, ContextError>;
    type SupplierRepository<'a>: TeaqlEntityRepository + 'a
    where
        Self: 'a;

    fn supplier_repository(&self) -> Result<Self::SupplierRepository<'_>, ContextError>;
    type WarehouseRepository<'a>: TeaqlEntityRepository + 'a
    where
        Self: 'a;

    fn warehouse_repository(&self) -> Result<Self::WarehouseRepository<'_>, ContextError>;
    type InventoryItemRepository<'a>: TeaqlEntityRepository + 'a
    where
        Self: 'a;

    fn inventory_item_repository(&self) -> Result<Self::InventoryItemRepository<'_>, ContextError>;
    type PurchaseOrderRepository<'a>: TeaqlEntityRepository + 'a
    where
        Self: 'a;

    fn purchase_order_repository(&self) -> Result<Self::PurchaseOrderRepository<'_>, ContextError>;
    type PurchaseOrderItemRepository<'a>: TeaqlEntityRepository + 'a
    where
        Self: 'a;

    fn purchase_order_item_repository(&self) -> Result<Self::PurchaseOrderItemRepository<'_>, ContextError>;
    type ShipmentRepository<'a>: TeaqlEntityRepository + 'a
    where
        Self: 'a;

    fn shipment_repository(&self) -> Result<Self::ShipmentRepository<'_>, ContextError>;
    type DeliveryRepository<'a>: TeaqlEntityRepository + 'a
    where
        Self: 'a;

    fn delivery_repository(&self) -> Result<Self::DeliveryRepository<'_>, ContextError>;
    type ReturnRequestRepository<'a>: TeaqlEntityRepository + 'a
    where
        Self: 'a;

    fn return_request_repository(&self) -> Result<Self::ReturnRequestRepository<'_>, ContextError>;
    type TicketRepository<'a>: TeaqlEntityRepository + 'a
    where
        Self: 'a;

    fn ticket_repository(&self) -> Result<Self::TicketRepository<'_>, ContextError>;
    type TicketCommentRepository<'a>: TeaqlEntityRepository + 'a
    where
        Self: 'a;

    fn ticket_comment_repository(&self) -> Result<Self::TicketCommentRepository<'_>, ContextError>;
    type SlaRepository<'a>: TeaqlEntityRepository + 'a
    where
        Self: 'a;

    fn sla_repository(&self) -> Result<Self::SlaRepository<'_>, ContextError>;
    type KnowledgeBaseRepository<'a>: TeaqlEntityRepository + 'a
    where
        Self: 'a;

    fn knowledge_base_repository(&self) -> Result<Self::KnowledgeBaseRepository<'_>, ContextError>;
    type SupportAgentRepository<'a>: TeaqlEntityRepository + 'a
    where
        Self: 'a;

    fn support_agent_repository(&self) -> Result<Self::SupportAgentRepository<'_>, ContextError>;
}

#[allow(async_fn_in_trait)]
pub trait TeaqlUserContextExt {
    async fn transaction_data<F, Fut>(&self, f: F) -> Result<(), DataServiceError<<crate::runtime::DataServiceExecutor as teaql_data_service::DataServiceExecutor>::Error>>
    where
        F: FnOnce() -> Fut,
        Fut: Future<Output = Result<(), DataServiceError<<crate::runtime::DataServiceExecutor as teaql_data_service::DataServiceExecutor>::Error>>>;
}

impl TeaqlUserContextExt for teaql_runtime::UserContext {
    async fn transaction_data<F, Fut>(&self, f: F) -> Result<(), DataServiceError<<crate::runtime::DataServiceExecutor as teaql_data_service::DataServiceExecutor>::Error>>
    where
        F: FnOnce() -> Fut,
        Fut: Future<Output = Result<(), DataServiceError<<crate::runtime::DataServiceExecutor as teaql_data_service::DataServiceExecutor>::Error>>>,
    {
        let executor = self.require_resource::<crate::runtime::DataServiceExecutor>().map_err(|err| {
            DataServiceError::Runtime(RuntimeError::Graph(format!(
                "cannot start transaction without executor: {err}"
            )))
        })?;
        let root = self.entity_root();

        let tx = teaql_data_service::TransactionExecutor::begin(&*executor).await.map_err(DataServiceError::Executor)?;
        root.push_change_set();

        let result = f().await;
        match result {
            Ok(()) => {
                root.pop_change_set();
                teaql_data_service::Transaction::commit(tx).await.map_err(DataServiceError::Executor)?;
                Ok(())
            }
            Err(err) => {
                root.pop_change_set();
                teaql_data_service::Transaction::rollback(tx).await.map_err(DataServiceError::Executor)?;
                Err(err)
            }
        }
    }
}

impl TeaqlRuntime for teaql_runtime::UserContext {
    fn user_context(&self) -> &UserContext {
        self
    }

    async fn fetch_facet_smart_list(
        &self,
        entity: &str,
        query: &PurposedSelectQuery,
        relation_aggregates: &[RuntimeRelationAggregate],
        trace_context: Vec<teaql_core::TraceNode>,
    ) -> Result<SmartList<Record>, RuntimeError> {
        self.entity_data_service::<crate::runtime::DataServiceExecutor>(entity)
            .map_err(|err| RuntimeError::Graph(err.to_string()))?
            .with_trace_context(trace_context)
            .fetch_smart_list_with_relation_aggregates(query, relation_aggregates)
            .await
            .map_err(|err| RuntimeError::Graph(err.to_string()))
    }
}

impl TeaqlRepositoryProvider for teaql_runtime::UserContext {
    type EmployeeRepository<'a> = teaql_runtime::EntityDataService<'a, crate::runtime::DataServiceExecutor>
    where
        Self: 'a;

    fn employee_repository(&self) -> Result<Self::EmployeeRepository<'_>, ContextError> {
        self.entity_data_service::<crate::runtime::DataServiceExecutor>("Employee")
    }

    type DepartmentRepository<'a> = teaql_runtime::EntityDataService<'a, crate::runtime::DataServiceExecutor>
    where
        Self: 'a;

    fn department_repository(&self) -> Result<Self::DepartmentRepository<'_>, ContextError> {
        self.entity_data_service::<crate::runtime::DataServiceExecutor>("Department")
    }

    type PositionRepository<'a> = teaql_runtime::EntityDataService<'a, crate::runtime::DataServiceExecutor>
    where
        Self: 'a;

    fn position_repository(&self) -> Result<Self::PositionRepository<'_>, ContextError> {
        self.entity_data_service::<crate::runtime::DataServiceExecutor>("Position")
    }

    type LeaveRequestRepository<'a> = teaql_runtime::EntityDataService<'a, crate::runtime::DataServiceExecutor>
    where
        Self: 'a;

    fn leave_request_repository(&self) -> Result<Self::LeaveRequestRepository<'_>, ContextError> {
        self.entity_data_service::<crate::runtime::DataServiceExecutor>("LeaveRequest")
    }

    type AttendanceRepository<'a> = teaql_runtime::EntityDataService<'a, crate::runtime::DataServiceExecutor>
    where
        Self: 'a;

    fn attendance_repository(&self) -> Result<Self::AttendanceRepository<'_>, ContextError> {
        self.entity_data_service::<crate::runtime::DataServiceExecutor>("Attendance")
    }

    type BenefitRepository<'a> = teaql_runtime::EntityDataService<'a, crate::runtime::DataServiceExecutor>
    where
        Self: 'a;

    fn benefit_repository(&self) -> Result<Self::BenefitRepository<'_>, ContextError> {
        self.entity_data_service::<crate::runtime::DataServiceExecutor>("Benefit")
    }

    type EmployeeReviewRepository<'a> = teaql_runtime::EntityDataService<'a, crate::runtime::DataServiceExecutor>
    where
        Self: 'a;

    fn employee_review_repository(&self) -> Result<Self::EmployeeReviewRepository<'_>, ContextError> {
        self.entity_data_service::<crate::runtime::DataServiceExecutor>("EmployeeReview")
    }

    type PayrollRepository<'a> = teaql_runtime::EntityDataService<'a, crate::runtime::DataServiceExecutor>
    where
        Self: 'a;

    fn payroll_repository(&self) -> Result<Self::PayrollRepository<'_>, ContextError> {
        self.entity_data_service::<crate::runtime::DataServiceExecutor>("Payroll")
    }

    type CustomerRepository<'a> = teaql_runtime::EntityDataService<'a, crate::runtime::DataServiceExecutor>
    where
        Self: 'a;

    fn customer_repository(&self) -> Result<Self::CustomerRepository<'_>, ContextError> {
        self.entity_data_service::<crate::runtime::DataServiceExecutor>("Customer")
    }

    type LeadRepository<'a> = teaql_runtime::EntityDataService<'a, crate::runtime::DataServiceExecutor>
    where
        Self: 'a;

    fn lead_repository(&self) -> Result<Self::LeadRepository<'_>, ContextError> {
        self.entity_data_service::<crate::runtime::DataServiceExecutor>("Lead")
    }

    type OpportunityRepository<'a> = teaql_runtime::EntityDataService<'a, crate::runtime::DataServiceExecutor>
    where
        Self: 'a;

    fn opportunity_repository(&self) -> Result<Self::OpportunityRepository<'_>, ContextError> {
        self.entity_data_service::<crate::runtime::DataServiceExecutor>("Opportunity")
    }

    type ContactRepository<'a> = teaql_runtime::EntityDataService<'a, crate::runtime::DataServiceExecutor>
    where
        Self: 'a;

    fn contact_repository(&self) -> Result<Self::ContactRepository<'_>, ContextError> {
        self.entity_data_service::<crate::runtime::DataServiceExecutor>("Contact")
    }

    type CampaignRepository<'a> = teaql_runtime::EntityDataService<'a, crate::runtime::DataServiceExecutor>
    where
        Self: 'a;

    fn campaign_repository(&self) -> Result<Self::CampaignRepository<'_>, ContextError> {
        self.entity_data_service::<crate::runtime::DataServiceExecutor>("Campaign")
    }

    type ContractRepository<'a> = teaql_runtime::EntityDataService<'a, crate::runtime::DataServiceExecutor>
    where
        Self: 'a;

    fn contract_repository(&self) -> Result<Self::ContractRepository<'_>, ContextError> {
        self.entity_data_service::<crate::runtime::DataServiceExecutor>("Contract")
    }

    type QuoteRepository<'a> = teaql_runtime::EntityDataService<'a, crate::runtime::DataServiceExecutor>
    where
        Self: 'a;

    fn quote_repository(&self) -> Result<Self::QuoteRepository<'_>, ContextError> {
        self.entity_data_service::<crate::runtime::DataServiceExecutor>("Quote")
    }

    type SalesTerritoryRepository<'a> = teaql_runtime::EntityDataService<'a, crate::runtime::DataServiceExecutor>
    where
        Self: 'a;

    fn sales_territory_repository(&self) -> Result<Self::SalesTerritoryRepository<'_>, ContextError> {
        self.entity_data_service::<crate::runtime::DataServiceExecutor>("SalesTerritory")
    }

    type ProductRepository<'a> = teaql_runtime::EntityDataService<'a, crate::runtime::DataServiceExecutor>
    where
        Self: 'a;

    fn product_repository(&self) -> Result<Self::ProductRepository<'_>, ContextError> {
        self.entity_data_service::<crate::runtime::DataServiceExecutor>("Product")
    }

    type CategoryRepository<'a> = teaql_runtime::EntityDataService<'a, crate::runtime::DataServiceExecutor>
    where
        Self: 'a;

    fn category_repository(&self) -> Result<Self::CategoryRepository<'_>, ContextError> {
        self.entity_data_service::<crate::runtime::DataServiceExecutor>("Category")
    }

    type CatalogRepository<'a> = teaql_runtime::EntityDataService<'a, crate::runtime::DataServiceExecutor>
    where
        Self: 'a;

    fn catalog_repository(&self) -> Result<Self::CatalogRepository<'_>, ContextError> {
        self.entity_data_service::<crate::runtime::DataServiceExecutor>("Catalog")
    }

    type ProductReviewRepository<'a> = teaql_runtime::EntityDataService<'a, crate::runtime::DataServiceExecutor>
    where
        Self: 'a;

    fn product_review_repository(&self) -> Result<Self::ProductReviewRepository<'_>, ContextError> {
        self.entity_data_service::<crate::runtime::DataServiceExecutor>("ProductReview")
    }

    type ShoppingCartRepository<'a> = teaql_runtime::EntityDataService<'a, crate::runtime::DataServiceExecutor>
    where
        Self: 'a;

    fn shopping_cart_repository(&self) -> Result<Self::ShoppingCartRepository<'_>, ContextError> {
        self.entity_data_service::<crate::runtime::DataServiceExecutor>("ShoppingCart")
    }

    type CartItemRepository<'a> = teaql_runtime::EntityDataService<'a, crate::runtime::DataServiceExecutor>
    where
        Self: 'a;

    fn cart_item_repository(&self) -> Result<Self::CartItemRepository<'_>, ContextError> {
        self.entity_data_service::<crate::runtime::DataServiceExecutor>("CartItem")
    }

    type GlobalOrderRepository<'a> = teaql_runtime::EntityDataService<'a, crate::runtime::DataServiceExecutor>
    where
        Self: 'a;

    fn global_order_repository(&self) -> Result<Self::GlobalOrderRepository<'_>, ContextError> {
        self.entity_data_service::<crate::runtime::DataServiceExecutor>("GlobalOrder")
    }

    type OrderItemRepository<'a> = teaql_runtime::EntityDataService<'a, crate::runtime::DataServiceExecutor>
    where
        Self: 'a;

    fn order_item_repository(&self) -> Result<Self::OrderItemRepository<'_>, ContextError> {
        self.entity_data_service::<crate::runtime::DataServiceExecutor>("OrderItem")
    }

    type WishlistRepository<'a> = teaql_runtime::EntityDataService<'a, crate::runtime::DataServiceExecutor>
    where
        Self: 'a;

    fn wishlist_repository(&self) -> Result<Self::WishlistRepository<'_>, ContextError> {
        self.entity_data_service::<crate::runtime::DataServiceExecutor>("Wishlist")
    }

    type PromotionRepository<'a> = teaql_runtime::EntityDataService<'a, crate::runtime::DataServiceExecutor>
    where
        Self: 'a;

    fn promotion_repository(&self) -> Result<Self::PromotionRepository<'_>, ContextError> {
        self.entity_data_service::<crate::runtime::DataServiceExecutor>("Promotion")
    }

    type CouponRepository<'a> = teaql_runtime::EntityDataService<'a, crate::runtime::DataServiceExecutor>
    where
        Self: 'a;

    fn coupon_repository(&self) -> Result<Self::CouponRepository<'_>, ContextError> {
        self.entity_data_service::<crate::runtime::DataServiceExecutor>("Coupon")
    }

    type InvoiceRepository<'a> = teaql_runtime::EntityDataService<'a, crate::runtime::DataServiceExecutor>
    where
        Self: 'a;

    fn invoice_repository(&self) -> Result<Self::InvoiceRepository<'_>, ContextError> {
        self.entity_data_service::<crate::runtime::DataServiceExecutor>("Invoice")
    }

    type PaymentRepository<'a> = teaql_runtime::EntityDataService<'a, crate::runtime::DataServiceExecutor>
    where
        Self: 'a;

    fn payment_repository(&self) -> Result<Self::PaymentRepository<'_>, ContextError> {
        self.entity_data_service::<crate::runtime::DataServiceExecutor>("Payment")
    }

    type RefundRepository<'a> = teaql_runtime::EntityDataService<'a, crate::runtime::DataServiceExecutor>
    where
        Self: 'a;

    fn refund_repository(&self) -> Result<Self::RefundRepository<'_>, ContextError> {
        self.entity_data_service::<crate::runtime::DataServiceExecutor>("Refund")
    }

    type AccountRepository<'a> = teaql_runtime::EntityDataService<'a, crate::runtime::DataServiceExecutor>
    where
        Self: 'a;

    fn account_repository(&self) -> Result<Self::AccountRepository<'_>, ContextError> {
        self.entity_data_service::<crate::runtime::DataServiceExecutor>("Account")
    }

    type TransactionRepository<'a> = teaql_runtime::EntityDataService<'a, crate::runtime::DataServiceExecutor>
    where
        Self: 'a;

    fn transaction_repository(&self) -> Result<Self::TransactionRepository<'_>, ContextError> {
        self.entity_data_service::<crate::runtime::DataServiceExecutor>("Transaction")
    }

    type TaxRateRepository<'a> = teaql_runtime::EntityDataService<'a, crate::runtime::DataServiceExecutor>
    where
        Self: 'a;

    fn tax_rate_repository(&self) -> Result<Self::TaxRateRepository<'_>, ContextError> {
        self.entity_data_service::<crate::runtime::DataServiceExecutor>("TaxRate")
    }

    type ExpenseRepository<'a> = teaql_runtime::EntityDataService<'a, crate::runtime::DataServiceExecutor>
    where
        Self: 'a;

    fn expense_repository(&self) -> Result<Self::ExpenseRepository<'_>, ContextError> {
        self.entity_data_service::<crate::runtime::DataServiceExecutor>("Expense")
    }

    type LedgerRepository<'a> = teaql_runtime::EntityDataService<'a, crate::runtime::DataServiceExecutor>
    where
        Self: 'a;

    fn ledger_repository(&self) -> Result<Self::LedgerRepository<'_>, ContextError> {
        self.entity_data_service::<crate::runtime::DataServiceExecutor>("Ledger")
    }

    type SupplierRepository<'a> = teaql_runtime::EntityDataService<'a, crate::runtime::DataServiceExecutor>
    where
        Self: 'a;

    fn supplier_repository(&self) -> Result<Self::SupplierRepository<'_>, ContextError> {
        self.entity_data_service::<crate::runtime::DataServiceExecutor>("Supplier")
    }

    type WarehouseRepository<'a> = teaql_runtime::EntityDataService<'a, crate::runtime::DataServiceExecutor>
    where
        Self: 'a;

    fn warehouse_repository(&self) -> Result<Self::WarehouseRepository<'_>, ContextError> {
        self.entity_data_service::<crate::runtime::DataServiceExecutor>("Warehouse")
    }

    type InventoryItemRepository<'a> = teaql_runtime::EntityDataService<'a, crate::runtime::DataServiceExecutor>
    where
        Self: 'a;

    fn inventory_item_repository(&self) -> Result<Self::InventoryItemRepository<'_>, ContextError> {
        self.entity_data_service::<crate::runtime::DataServiceExecutor>("InventoryItem")
    }

    type PurchaseOrderRepository<'a> = teaql_runtime::EntityDataService<'a, crate::runtime::DataServiceExecutor>
    where
        Self: 'a;

    fn purchase_order_repository(&self) -> Result<Self::PurchaseOrderRepository<'_>, ContextError> {
        self.entity_data_service::<crate::runtime::DataServiceExecutor>("PurchaseOrder")
    }

    type PurchaseOrderItemRepository<'a> = teaql_runtime::EntityDataService<'a, crate::runtime::DataServiceExecutor>
    where
        Self: 'a;

    fn purchase_order_item_repository(&self) -> Result<Self::PurchaseOrderItemRepository<'_>, ContextError> {
        self.entity_data_service::<crate::runtime::DataServiceExecutor>("PurchaseOrderItem")
    }

    type ShipmentRepository<'a> = teaql_runtime::EntityDataService<'a, crate::runtime::DataServiceExecutor>
    where
        Self: 'a;

    fn shipment_repository(&self) -> Result<Self::ShipmentRepository<'_>, ContextError> {
        self.entity_data_service::<crate::runtime::DataServiceExecutor>("Shipment")
    }

    type DeliveryRepository<'a> = teaql_runtime::EntityDataService<'a, crate::runtime::DataServiceExecutor>
    where
        Self: 'a;

    fn delivery_repository(&self) -> Result<Self::DeliveryRepository<'_>, ContextError> {
        self.entity_data_service::<crate::runtime::DataServiceExecutor>("Delivery")
    }

    type ReturnRequestRepository<'a> = teaql_runtime::EntityDataService<'a, crate::runtime::DataServiceExecutor>
    where
        Self: 'a;

    fn return_request_repository(&self) -> Result<Self::ReturnRequestRepository<'_>, ContextError> {
        self.entity_data_service::<crate::runtime::DataServiceExecutor>("ReturnRequest")
    }

    type TicketRepository<'a> = teaql_runtime::EntityDataService<'a, crate::runtime::DataServiceExecutor>
    where
        Self: 'a;

    fn ticket_repository(&self) -> Result<Self::TicketRepository<'_>, ContextError> {
        self.entity_data_service::<crate::runtime::DataServiceExecutor>("Ticket")
    }

    type TicketCommentRepository<'a> = teaql_runtime::EntityDataService<'a, crate::runtime::DataServiceExecutor>
    where
        Self: 'a;

    fn ticket_comment_repository(&self) -> Result<Self::TicketCommentRepository<'_>, ContextError> {
        self.entity_data_service::<crate::runtime::DataServiceExecutor>("TicketComment")
    }

    type SlaRepository<'a> = teaql_runtime::EntityDataService<'a, crate::runtime::DataServiceExecutor>
    where
        Self: 'a;

    fn sla_repository(&self) -> Result<Self::SlaRepository<'_>, ContextError> {
        self.entity_data_service::<crate::runtime::DataServiceExecutor>("Sla")
    }

    type KnowledgeBaseRepository<'a> = teaql_runtime::EntityDataService<'a, crate::runtime::DataServiceExecutor>
    where
        Self: 'a;

    fn knowledge_base_repository(&self) -> Result<Self::KnowledgeBaseRepository<'_>, ContextError> {
        self.entity_data_service::<crate::runtime::DataServiceExecutor>("KnowledgeBase")
    }

    type SupportAgentRepository<'a> = teaql_runtime::EntityDataService<'a, crate::runtime::DataServiceExecutor>
    where
        Self: 'a;

    fn support_agent_repository(&self) -> Result<Self::SupportAgentRepository<'_>, ContextError> {
        self.entity_data_service::<crate::runtime::DataServiceExecutor>("SupportAgent")
    }
}

pub(crate) async fn execute_facets<C>(
    ctx: &C,
    outer_query: &SelectQuery,
    options: &QueryOptions,
) -> Result<BTreeMap<String, SmartList<Record>>, RuntimeError>
where
    C: TeaqlRuntime + ?Sized,
{
    let mut facets = BTreeMap::new();
    for facet in &options.facets {
        let mut selection = facet.query.clone();
        merge_outer_filter_into_facet_aggregates(&mut selection, outer_query);
        if !facet.include_all_facets {
            selection = restrict_facet_to_outer_query(ctx, selection, outer_query, &facet.relation_name)?;
        }
        let relation_aggregates = runtime_relation_aggregates(&selection.query_options);
        let query = apply_runtime_metadata(
            selection.query,
            &selection.query_options,
            &selection.child_enhancements,
        );
        let entity = query.entity.clone();
        let mut chain = outer_query.trace_chain.clone();
        chain.push(teaql_core::TraceNode::new(
            query.entity.clone(),
            None,
            facet.facet_name.clone(),
        ));

        let query = PurposedSelectQuery::new(
            query,
            format!("Calculate facet {}", facet.facet_name),
        );
        let facet_rows = ctx.fetch_facet_smart_list(&entity, &query, &relation_aggregates, chain).await?;
        facets.insert(facet.facet_name.clone(), facet_rows);
    }
    Ok(facets)
}

pub(crate) fn restrict_facet_to_outer_query<C>(
    ctx: &C,
    mut selection: QuerySelection,
    outer_query: &SelectQuery,
    relation_name: &str,
) -> Result<QuerySelection, RuntimeError>
where
    C: TeaqlRuntime + ?Sized,
{
    let descriptor = ctx
        .user_context()
        .entity(&outer_query.entity)
        .cloned()
        .ok_or_else(|| RuntimeError::Graph(format!("missing entity: {}", outer_query.entity)))?;
    let relation = descriptor
        .relation_by_name(relation_name)
        .cloned()
        .ok_or_else(|| RuntimeError::MissingRelation {
            entity: outer_query.entity.clone(),
            relation: relation_name.to_owned(),
        })?;
    let mut subquery = outer_query.clone();
    subquery.projection.clear();
    subquery.expr_projection.clear();
    subquery.order_by.clear();
    subquery.slice = None;
    subquery.aggregates.clear();
    subquery.group_by.clear();
    subquery.relations.clear();
    selection.query = selection.query.and_filter(Expr::in_subquery(
        relation.foreign_key,
        descriptor,
        subquery,
        relation.local_key,
    ));
    Ok(selection)
}
