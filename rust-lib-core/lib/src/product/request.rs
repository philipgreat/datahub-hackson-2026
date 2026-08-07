use std::marker::PhantomData;

use serde_json::Value as JsonValue;
use teaql_core::{Aggregate, AggregateFunction, EntityDescriptor, Expr, Record, SelectQuery, SmartList};
use teaql_runtime::{DataServiceError, RuntimeError};

use crate::request_support::*;

impl EntityReference for crate::Product {
    fn entity_id_value(self) -> teaql_core::Value {
        teaql_core::IdentifiableEntity::id_value(&self)
    }
}

impl EntityReference for &crate::Product {
    fn entity_id_value(self) -> teaql_core::Value {
        teaql_core::IdentifiableEntity::id_value(self)
    }
}

// ⛔ AI agents: DO NOT read this file for API discovery. Instead run: cargo teaql --input modeling/MODEL.xml rust-assist-query/product
#[derive(Debug)]
pub struct ProductRequest<R = crate::Product> {
    query: SelectQuery,
    relation_selections: Vec<RelationSelection>,
    relation_filters: Vec<RelationFilter>,
    child_enhancements: Vec<QuerySelection>,
    query_options: QueryOptions,
    marker: PhantomData<R>,
}

impl<R> Clone for ProductRequest<R> {
    fn clone(&self) -> Self {
        Self {
            query: self.query.clone(),
            relation_selections: self.relation_selections.clone(),
            relation_filters: self.relation_filters.clone(),
            child_enhancements: self.child_enhancements.clone(),
            query_options: self.query_options.clone(),
            marker: PhantomData,
        }
    }
}

impl<R> ProductRequest<R> {
    pub(crate) fn new() -> Self {
        Self {
            query: SelectQuery::new("Product")
                .project("id")
                .project("version"),
            relation_selections: Vec::new(),
            relation_filters: Vec::new(),
            child_enhancements: Vec::new(),
            query_options: QueryOptions::default(),
            marker: PhantomData,
        }
    }

    pub fn return_type<T>(self) -> ProductRequest<T> {
        ProductRequest {
            query: self.query,
            relation_selections: self.relation_selections,
            relation_filters: self.relation_filters,
            child_enhancements: self.child_enhancements,
            query_options: self.query_options,
            marker: PhantomData,
        }
    }

    pub fn query(&self) -> &SelectQuery {
        &self.query
    }

    pub fn relation_selections(&self) -> &[RelationSelection] {
        &self.relation_selections
    }

    pub fn relation_filters(&self) -> &[RelationFilter] {
        &self.relation_filters
    }

    pub fn child_enhancements(&self) -> &[QuerySelection] {
        &self.child_enhancements
    }

    pub fn query_options(&self) -> &QueryOptions {
        &self.query_options
    }

    pub fn into_query(self) -> SelectQuery {
        self.query
    }


    pub fn purpose(self, purpose: impl Into<String>) -> crate::PurposedQuery<Self> {
        crate::PurposedQuery::new(self, purpose)
    }

    pub(crate) async fn _execute_for_list<'a, C>(
        self,
        ctx: &'a C,
    ) -> Result<SmartList<R>, TeaqlDataServiceError<C::ProductRepository<'a>>>
    where
        C: TeaqlRepositoryProvider + ?Sized,
        R: teaql_core::Entity,
    {
        let repository = ctx
            .product_repository()
            .map_err(|err| DataServiceError::Runtime(RuntimeError::Graph(err.to_string())))?;
        let query_options = self.query_options.clone();
        let relation_aggregates = runtime_relation_aggregates(&query_options);
        let query = authorize_query(apply_runtime_metadata(
            self.query,
            &query_options,
            &self.child_enhancements,
        )).map_err(DataServiceError::Runtime)?;
        let mut rows = repository.fetch_enhanced_entities_with_relation_aggregates::<R>(
            &query,
            &relation_aggregates,
        ).await?;
        let facets = execute_facets(ctx, query.as_query(), &query_options)
            .await
            .map_err(DataServiceError::Runtime)?;
        attach_facets(&mut rows, facets);
        Ok(rows)
    }

    pub(crate) async fn _execute_for_stream<'a, C>(
        self,
        ctx: &'a C,
    ) -> Result<Vec<teaql_data_service::StreamChunk>, TeaqlDataServiceError<C::ProductRepository<'a>>>
    where
        C: TeaqlRepositoryProvider + ?Sized,
    {
        let repository = ctx
            .product_repository()
            .map_err(|err| DataServiceError::Runtime(RuntimeError::Graph(err.to_string())))?;
        let query_options = self.query_options.clone();
        let query = authorize_query(apply_runtime_metadata(
            self.query,
            &query_options,
            &self.child_enhancements,
        )).map_err(DataServiceError::Runtime)?;
        let chunks = repository.fetch_stream(&query)
            .await?;
        Ok(chunks)
    }

    pub(crate) async fn _execute_for_first<'a, C>(
        self,
        ctx: &'a C,
    ) -> Result<Option<R>, TeaqlDataServiceError<C::ProductRepository<'a>>>
    where
        C: TeaqlRepositoryProvider + ?Sized,
        R: teaql_core::Entity,
    {
        let rows = self.limit(1)._execute_for_list(ctx).await?;
        Ok(rows.into_iter().next())
    }

    pub(crate) async fn _execute_for_one<'a, C>(
        self,
        ctx: &'a C,
    ) -> Result<Option<R>, TeaqlDataServiceError<C::ProductRepository<'a>>>
    where
        C: TeaqlRepositoryProvider + ?Sized,
        R: teaql_core::Entity,
    {
        self._execute_for_first(ctx).await
    }


    pub(crate) async fn _execute_for_page<'a, C>(
        self,
        ctx: &'a C,
        offset: u64,
        limit: u64,
    ) -> Result<SmartList<R>, TeaqlDataServiceError<C::ProductRepository<'a>>>
    where
        C: TeaqlRepositoryProvider + ?Sized,
        R: teaql_core::Entity,
    {
        let total_count = self.clone()._execute_for_count(ctx).await?;
        let mut rows = self.page_offset(offset, limit)._execute_for_list(ctx).await?;
        rows.total_count = Some(total_count);
        Ok(rows)
    }

    pub(crate) async fn _execute_for_count<'a, C>(
        self,
        ctx: &'a C,
    ) -> Result<u64, TeaqlDataServiceError<C::ProductRepository<'a>>>
    where
        C: TeaqlRepositoryProvider + ?Sized,
    {
        let repository = ctx
            .product_repository()
            .map_err(|err| DataServiceError::Runtime(RuntimeError::Graph(err.to_string())))?;
        let mut query = self.query;
        query.projection.clear();
        query.expr_projection.clear();
        query.order_by.clear();
        query.slice = None;
        query.relations.clear();
        query = query.count(COUNT_ALIAS);
        let query = authorize_query(query).map_err(DataServiceError::Runtime)?;
        let rows = repository.fetch_all(&query).await?;
        rows.first()
            .and_then(|row| row.get(COUNT_ALIAS))
            .and_then(teaql_core::Value::try_u64)
            .ok_or_else(|| DataServiceError::Runtime(RuntimeError::Graph(format!("count result for Product is missing or not numeric"))))
    }

    pub(crate) async fn _execute_for_exists<'a, C>(
        self,
        ctx: &'a C,
    ) -> Result<bool, TeaqlDataServiceError<C::ProductRepository<'a>>>
    where
        C: TeaqlRepositoryProvider + ?Sized,
    {
        let repository = ctx
            .product_repository()
            .map_err(|err| DataServiceError::Runtime(RuntimeError::Graph(err.to_string())))?;
        let mut query = self.query.limit(1);
        query.relations.clear();
        let query = authorize_query(query).map_err(DataServiceError::Runtime)?;
        let rows = repository.fetch_all(&query).await?;
        Ok(!rows.is_empty())
    }

    pub(crate) async fn _execute_for_records<'a, C>(
        self,
        ctx: &'a C,
    ) -> Result<SmartList<Record>, TeaqlDataServiceError<C::ProductRepository<'a>>>
    where
        C: TeaqlRepositoryProvider + ?Sized,
    {
        let repository = ctx
            .product_repository()
            .map_err(|err| DataServiceError::Runtime(RuntimeError::Graph(err.to_string())))?;
        let query_options = self.query_options.clone();
        let outer_query = self.query.clone();
        let relation_aggregates = runtime_relation_aggregates(&query_options);
        let query = authorize_query(apply_runtime_metadata(
            self.query,
            &query_options,
            &self.child_enhancements,
        )).map_err(DataServiceError::Runtime)?;
        let mut rows = repository.fetch_smart_list_with_relation_aggregates(&query, &relation_aggregates).await?;
        let facets = execute_facets(ctx, &outer_query, &query_options)
            .await
            .map_err(DataServiceError::Runtime)?;
        attach_facets(&mut rows, facets);
        Ok(rows)
    }

    pub(crate) async fn _execute_for_record<'a, C>(
        self,
        ctx: &'a C,
    ) -> Result<Option<Record>, TeaqlDataServiceError<C::ProductRepository<'a>>>
    where
        C: TeaqlRepositoryProvider + ?Sized,
    {
        let records = self.limit(1)._execute_for_records(ctx).await?;
        Ok(records.into_iter().next())
    }

    pub fn search_with_text(mut self, text: impl Into<String>) -> Self {
        self.query = self.query.search_with_text(text);
        self
    }

    pub fn filter(mut self, filter: Expr) -> Self {
        self.query = self.query.filter(filter);
        self
    }

    pub fn and_filter(mut self, filter: Expr) -> Self {
        self.query = self.query.and_filter(filter);
        self
    }

    pub fn or_filter(mut self, filter: Expr) -> Self {
        self.query = self.query.or_filter(filter);
        self
    }

    pub fn append_search_criteria(self, criteria: Expr) -> Self {
        self.and_filter(criteria)
    }

    pub fn filter_property(
        mut self,
        property1: impl AsRef<str>,
        operator: FieldOperator,
        property2: impl AsRef<str>,
    ) -> Self {
        self.query = self.query.and_filter(field_operator_column_expr(
            property1.as_ref(),
            operator,
            property2.as_ref(),
        ));
        self
    }

    pub fn with_deleted_rows(mut self) -> Self {
        self.query.filter = remove_default_live_filter(self.query.filter);
        self
    }

    pub fn deleted_rows_only(mut self) -> Self {
        self.query.filter = remove_default_live_filter(self.query.filter);
        self.query = self.query.and_filter(Expr::lte("version", 0_i64));
        self
    }

    pub fn match_types(
        mut self,
        types: impl IntoIterator<Item = impl Into<teaql_core::Value>>,
    ) -> Self {
        self.query = self.query.and_filter(Expr::in_list(TYPE_FIELD, types.into_iter().map(Into::into)));
        self
    }


    pub fn with_type_group(mut self) -> Self {
        self.query = self.query.project(TYPE_GROUP_FIELD);
        self
    }

    pub fn matching_any_of(mut self, request: impl Into<QuerySelection>) -> Self {
        let selection = request.into();
        let entity = EntityDescriptor::new(selection.query.entity.clone());
        self.query = self.query.and_filter(Expr::in_subquery("id", entity, selection.query.clone(), "id"));
        self
    }

    pub fn match_any_of(self, request: impl Into<QuerySelection>) -> Self {
        self.matching_any_of(request)
    }

    pub fn enhance_child(mut self, request: impl Into<QuerySelection>) -> Self {
        self.child_enhancements.push(request.into());
        self
    }

    pub fn enhance_children_if_needed(self) -> Self {
        let request = self;
        request
    }


    pub fn comment(mut self, comment: impl Into<String>) -> Self {
        self.query_options.comment = Some(comment.into());
        self
    }

    pub fn raw_sql(self, raw_sql: impl Into<String>) -> Self {
        self.unsafe_raw_sql(UnsafeRawSqlSegment::trusted(raw_sql))
    }

    pub fn unsafe_raw_sql(mut self, raw_sql: UnsafeRawSqlSegment) -> Self {
        self.query_options.raw_sql = Some(raw_sql.into_sql());
        self
    }

    pub fn raw_sql_filter(self, raw_sql: impl Into<String>) -> Self {
        self.unsafe_raw_sql_filter(UnsafeRawSqlSegment::trusted(raw_sql))
    }

    pub fn unsafe_raw_sql_filter(mut self, raw_sql: UnsafeRawSqlSegment) -> Self {
        self.query_options.raw_sql_search_criteria.push(raw_sql.into_sql());
        self
    }
    pub fn filter_with_json(self, json_expr: impl Into<String>) -> Self {
        self.merge_dynamic_json_expr(json_expr.into())
    }

    fn merge_dynamic_json_expr(self, json_expr: String) -> Self {
        let json = serde_json::from_str::<JsonValue>(&json_expr)
            .unwrap_or_else(|_| panic!("Input JSON format error: {json_expr}"));
        self.merge_dynamic_json(&json)
    }

    fn merge_dynamic_json(mut self, json: &JsonValue) -> Self {
        let Some(object) = json.as_object() else {
            return self;
        };

        for (field, value) in object {
            if field.starts_with('_') {
                continue;
            }
            self = self.apply_dynamic_json_filter(field, value);
        }

        self = self.apply_dynamic_json_order_by(object.get("_orderBy"));

        if let Some(offset) = dynamic_json_u64_field(object, "_start") {
            self = self.skip(offset);
        }
        if let Some(size) = dynamic_json_u64_field(object, "_size") {
            self = self.limit(size);
        }

        if let Some(page_size) = dynamic_json_u64_field(object, "_pageSize") {
            self = self.limit(page_size);
        }
        if let Some(page_number) = dynamic_json_u64_field(object, "_page") {
            if page_number > 0 {
                let size = dynamic_json_u64_field(object, "_pageSize")
                    .or_else(|| self.query.slice.as_ref().and_then(|slice| slice.limit))
                    .unwrap_or(10);
                let offset = page_number.saturating_sub(1).saturating_mul(size);
                self = self.page_offset(offset, size);
            }
        }

        self
    }

    pub(crate) fn apply_dynamic_json_filter(self, field: &str, value: &JsonValue) -> Self {
        if let Some((head, tail)) = field.split_once('.') {
            self.apply_dynamic_json_chain_filter(head, tail, value)
        } else if let Some(storage_field) = Self::dynamic_json_self_field(field) {
            self.and_filter(dynamic_json_filter_expr(storage_field, value))
        } else {
            self
        }
    }

    fn apply_dynamic_json_order_by(mut self, order_by: Option<&JsonValue>) -> Self {
        match order_by {
            Some(JsonValue::String(field)) => {
                if let Some(storage_field) = Self::dynamic_json_self_field(field) {
                    self.query = self.query.order_desc(storage_field);
                }
            }
            Some(JsonValue::Object(order_by)) => {
                self = self.apply_dynamic_json_single_order_by(order_by);
            }
            Some(JsonValue::Array(order_bys)) => {
                for order_by in order_bys {
                    if let Some(order_by) = order_by.as_object() {
                        self = self.apply_dynamic_json_single_order_by(order_by);
                    }
                }
            }
            _ => {}
        }
        self
    }

    fn apply_dynamic_json_single_order_by(
        mut self,
        order_by: &serde_json::Map<String, JsonValue>,
    ) -> Self {
        let Some(field) = order_by.get("field").and_then(JsonValue::as_str) else {
            return self;
        };
        let Some(storage_field) = Self::dynamic_json_self_field(field) else {
            return self;
        };
        if order_by
            .get("useAsc")
            .and_then(JsonValue::as_bool)
            .unwrap_or(false)
        {
            self.query = self.query.order_asc(storage_field);
        } else {
            self.query = self.query.order_desc(storage_field);
        }
        self
    }

    fn dynamic_json_self_field(field: &str) -> Option<&'static str> {
        match field {
            "id" => Some("id"),
            "name" => Some("name"),
            "price" => Some("price"),
            "cost" => Some("cost"),
            "is_active" => Some("is_active"),
            "sku" => Some("sku"),
            "stock" => Some("stock"),
            "create_time" => Some("create_time"),
            "update_time" => Some("update_time"),
            "version" => Some("version"),
            "category" | "category_id" => Some("category_id"),
            _ => None,
        }
    }

    fn apply_dynamic_json_chain_filter(self, head: &str, tail: &str, value: &JsonValue) -> Self {
        let _ = (tail, value);
        match head {
            "category" => {
                self.with_category_matching(
                    crate::Q::categories_minimal()
                        .apply_dynamic_json_filter(tail, value),
                )
            }
            "product_review_list" => {
                self.with_product_review_list_matching(
                    crate::Q::product_reviews_minimal()
                        .apply_dynamic_json_filter(tail, value),
                )
            }
            "cart_item_list" => {
                self.with_cart_item_list_matching(
                    crate::Q::cart_items_minimal()
                        .apply_dynamic_json_filter(tail, value),
                )
            }
            "order_item_list" => {
                self.with_order_item_list_matching(
                    crate::Q::order_items_minimal()
                        .apply_dynamic_json_filter(tail, value),
                )
            }
            "inventory_item_list" => {
                self.with_inventory_item_list_matching(
                    crate::Q::inventory_items_minimal()
                        .apply_dynamic_json_filter(tail, value),
                )
            }
            "purchase_order_item_list" => {
                self.with_purchase_order_item_list_matching(
                    crate::Q::purchase_order_items_minimal()
                        .apply_dynamic_json_filter(tail, value),
                )
            }
            _ => self,
        }
    }

    pub fn create_property_as(
        self,
        property_name: impl Into<String>,
        raw_sql_segment: impl Into<String>,
    ) -> Self {
        self.unsafe_create_property_as(property_name, UnsafeRawSqlSegment::trusted(raw_sql_segment))
    }

    pub fn unsafe_create_property_as(
        mut self,
        property_name: impl Into<String>,
        raw_sql_segment: UnsafeRawSqlSegment,
    ) -> Self {
        self.query_options
            .dynamic_properties
            .push(RawDynamicProperty::new(property_name, raw_sql_segment));
        self
    }

    pub fn limit(mut self, limit: u64) -> Self {
        self.query = self.query.limit(limit);
        self
    }

    pub fn skip(mut self, offset: u64) -> Self {
        self.query = self.query.offset(offset);
        self
    }

    pub fn offset_only(self, offset: u64) -> Self {
        self.skip(offset)
    }

    pub fn offset(self, offset: u64, size: u64) -> Self {
        self.page_offset(offset, size)
    }

    pub fn page_offset(mut self, offset: u64, limit: u64) -> Self {
        self.query = self.query.page(offset, limit);
        self
    }

    pub fn top(self, top_n: u64) -> Self {
        self.limit(top_n)
    }

    pub fn offset_size(self, offset: u64, size: u64) -> Self {
        self.offset(offset, size)
    }

    pub fn unlimited(mut self) -> Self {
        self.query.slice = None;
        self
    }

    pub fn page_number(self, page_number: u64, page_size: u64) -> Self {
        let offset = page_number.saturating_sub(1).saturating_mul(page_size);
        self.page_offset(offset, page_size)
    }

    pub fn page_number_default(self, page_number: u64) -> Self {
        self.page_number(page_number, 10)
    }

    pub fn page(self, page_number: u64, page_size: u64) -> Self {
        self.page_number(page_number, page_size)
    }

    pub fn page_default(self, page_number: u64) -> Self {
        self.page_number_default(page_number)
    }

    pub fn select_self(mut self) -> Self {
        self.query = self.query.project("id");
        self.query = self.query.project("name");
        self.query = self.query.project("price");
        self.query = self.query.project("cost");
        self.query = self.query.project("is_active");
        self.query = self.query.project("sku");
        self.query = self.query.project("stock");
        self.query = self.query.project("create_time");
        self.query = self.query.project("update_time");
        self.query = self.query.project("version");
        self.query = self.query.project("category_id");
        self
    }

    pub fn select_self_fields(self) -> Self {
        self.select_self()
    }

    pub fn select_self_without_parent(self) -> Self {
        self.select_self_fields()
    }

    pub fn select_all(self) -> Self {
        let mut request = self.select_self();
        request = request.select_category();
        request
    }

    pub fn select_children(self) -> Self {
        let mut request = self.select_all();
        request = request.select_product_review_list();
        request = request.select_cart_item_list();
        request = request.select_order_item_list();
        request = request.select_inventory_item_list();
        request = request.select_purchase_order_item_list();
        request
    }

    pub fn select_any(self) -> Self {
        self.select_children()
    }

    pub fn group_by(mut self, field: impl Into<String>) -> Self {
        self.query = self.query.group_by(field);
        self
    }

    pub fn aggregate_count(mut self, alias: impl Into<String>) -> Self {
        self.query = self.query.count(alias);
        self
    }

    pub fn aggregate_count_field(mut self, field: impl Into<String>, alias: impl Into<String>) -> Self {
        self.query = self.query.count_field(field, alias);
        self
    }

    pub fn aggregate_with_function(
        mut self,
        field: impl Into<String>,
        alias: impl Into<String>,
        function: AggregateFunction,
    ) -> Self {
        self.query = self.query.aggregate(Aggregate::new(function, field, alias));
        self
    }

    pub fn aggregate_sum(mut self, field: impl Into<String>, alias: impl Into<String>) -> Self {
        self.query = self.query.sum(field, alias);
        self
    }

    pub fn aggregate_avg(mut self, field: impl Into<String>, alias: impl Into<String>) -> Self {
        self.query = self.query.avg(field, alias);
        self
    }

    pub fn aggregate_min(mut self, field: impl Into<String>, alias: impl Into<String>) -> Self {
        self.query = self.query.min(field, alias);
        self
    }

    pub fn aggregate_max(mut self, field: impl Into<String>, alias: impl Into<String>) -> Self {
        self.query = self.query.max(field, alias);
        self
    }

    pub fn aggregate_stddev(mut self, field: impl Into<String>, alias: impl Into<String>) -> Self {
        self.query = self.query.stddev(field, alias);
        self
    }

    pub fn aggregate_stddev_pop(mut self, field: impl Into<String>, alias: impl Into<String>) -> Self {
        self.query = self.query.stddev_pop(field, alias);
        self
    }

    pub fn aggregate_var_samp(mut self, field: impl Into<String>, alias: impl Into<String>) -> Self {
        self.query = self.query.var_samp(field, alias);
        self
    }

    pub fn aggregate_var_pop(mut self, field: impl Into<String>, alias: impl Into<String>) -> Self {
        self.query = self.query.var_pop(field, alias);
        self
    }

    pub fn aggregate_bit_and(mut self, field: impl Into<String>, alias: impl Into<String>) -> Self {
        self.query = self.query.bit_and(field, alias);
        self
    }

    pub fn aggregate_bit_or(mut self, field: impl Into<String>, alias: impl Into<String>) -> Self {
        self.query = self.query.bit_or(field, alias);
        self
    }

    pub fn aggregate_bit_xor(mut self, field: impl Into<String>, alias: impl Into<String>) -> Self {
        self.query = self.query.bit_xor(field, alias);
        self
    }

    pub fn enable_aggregation_cache(mut self) -> Self {
        self.query = self.query.enable_aggregation_cache();
        self
    }

    pub fn enable_aggregation_cache_for(mut self, cache_expired_millis: u64) -> Self {
        self.query = self.query.enable_aggregation_cache_for(cache_expired_millis);
        self
    }

    pub fn propagate_aggregation_cache(mut self, cache_expired_millis: u64) -> Self {
        self.query = self.query.propagate_aggregation_cache(cache_expired_millis);
        self
    }

    pub fn group_by_id(self) -> Self {
        self.group_by("id")
    }

    pub fn group_by_id_as(self, alias: impl Into<String>) -> Self {
        let alias = alias.into();
        let mut request = self.group_by("id");
        request.query = request
            .query
            .project_expr(alias, Expr::column("id"));
        request
    }

    pub fn group_by_id_with_function(
        self,
        alias: impl Into<String>,
        function: AggregateFunction,
    ) -> Self {
        self.group_by("id")
            .aggregate_with_function("id", alias, function)
    }

    pub fn count_id(self) -> Self {
        self.count_id_as("id_count")
    }

    pub fn count_id_as(self, alias: impl Into<String>) -> Self {
        self.aggregate_count_field("id", alias)
    }

    pub fn sum_id(self) -> Self {
        self.sum_id_as("sum_id")
    }

    pub fn sum_id_as(self, alias: impl Into<String>) -> Self {
        self.aggregate_sum("id", alias)
    }

    pub fn avg_id(self) -> Self {
        self.avg_id_as("avg_id")
    }

    pub fn avg_id_as(self, alias: impl Into<String>) -> Self {
        self.aggregate_avg("id", alias)
    }

    pub fn min_id(self) -> Self {
        self.min_id_as("min_id")
    }

    pub fn min_id_as(self, alias: impl Into<String>) -> Self {
        self.aggregate_min("id", alias)
    }

    pub fn max_id(self) -> Self {
        self.max_id_as("max_id")
    }

    pub fn max_id_as(self, alias: impl Into<String>) -> Self {
        self.aggregate_max("id", alias)
    }


    pub fn with_id(
        mut self,
        operator: FieldOperator,
        values: impl IntoIterator<Item = impl Into<teaql_core::Value>>,
    ) -> Self {
        self.query = self.query.and_filter(field_operator_expr(
            "id",
            operator,
            values.into_iter().map(Into::into).collect(),
        ));
        self
    }

    pub fn create_id_criteria(
        operator: FieldOperator,
        values: impl IntoIterator<Item = impl Into<teaql_core::Value>>,
    ) -> Expr {
        field_operator_expr(
            "id",
            operator,
            values.into_iter().map(Into::into).collect(),
        )
    }

    pub fn with_id_is(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::eq("id", value));
        self
    }



    pub fn with_id_is_not(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::ne("id", value));
        self
    }

    pub fn with_id_in(
        mut self,
        values: impl IntoIterator<Item = impl Into<teaql_core::Value>>,
    ) -> Self {
        self.query = self.query.and_filter(Expr::in_list(
            "id",
            values.into_iter().map(Into::into),
        ));
        self
    }

    pub fn with_id_not_in(
        mut self,
        values: impl IntoIterator<Item = impl Into<teaql_core::Value>>,
    ) -> Self {
        self.query = self.query.and_filter(Expr::not_in_list(
            "id",
            values.into_iter().map(Into::into),
        ));
        self
    }

    pub fn order_by_id_asc(mut self) -> Self {
        self.query = self.query.order_asc("id");
        self
    }

    pub fn order_by_id_desc(mut self) -> Self {
        self.query = self.query.order_desc("id");
        self
    }

    pub fn order_by_id_asc_using_gbk(mut self) -> Self {
        self.query = self.query.order_gbk_asc("id");
        self
    }

    pub fn order_by_id_desc_using_gbk(mut self) -> Self {
        self.query = self.query.order_gbk_desc("id");
        self
    }


    pub fn select_name(mut self) -> Self {
        self.query = self.query.project("name");
        self
    }

    pub fn project_name(self) -> Self {
        self.select_name()
    }

    pub fn select_name_raw(self, raw_sql_segment: impl Into<String>) -> Self {
        self.select_name_unsafe_raw(UnsafeRawSqlSegment::trusted(raw_sql_segment))
    }

    pub fn select_name_unsafe_raw(mut self, raw_sql_segment: UnsafeRawSqlSegment) -> Self {
        self.query_options
            .raw_projections
            .push(RawProjection::new("name", raw_sql_segment));
        self
    }

    pub fn group_by_name(self) -> Self {
        self.group_by("name")
    }

    pub fn group_by_name_as(self, alias: impl Into<String>) -> Self {
        let alias = alias.into();
        let mut request = self.group_by("name");
        request.query = request
            .query
            .project_expr(alias, Expr::column("name"));
        request
    }

    pub fn group_by_name_with_function(
        self,
        alias: impl Into<String>,
        function: AggregateFunction,
    ) -> Self {
        self.group_by("name")
            .aggregate_with_function("name", alias, function)
    }

    pub fn count_name(self) -> Self {
        self.count_name_as("name_count")
    }

    pub fn count_name_as(self, alias: impl Into<String>) -> Self {
        self.aggregate_count_field("name", alias)
    }

    pub fn sum_name(self) -> Self {
        self.sum_name_as("sum_name")
    }

    pub fn sum_name_as(self, alias: impl Into<String>) -> Self {
        self.aggregate_sum("name", alias)
    }

    pub fn avg_name(self) -> Self {
        self.avg_name_as("avg_name")
    }

    pub fn avg_name_as(self, alias: impl Into<String>) -> Self {
        self.aggregate_avg("name", alias)
    }

    pub fn min_name(self) -> Self {
        self.min_name_as("min_name")
    }

    pub fn min_name_as(self, alias: impl Into<String>) -> Self {
        self.aggregate_min("name", alias)
    }

    pub fn max_name(self) -> Self {
        self.max_name_as("max_name")
    }

    pub fn max_name_as(self, alias: impl Into<String>) -> Self {
        self.aggregate_max("name", alias)
    }

    pub fn unselect_name(mut self) -> Self {
        self.query.projection.retain(|field| field != "name");
        self.query_options.raw_projections.retain(|projection| projection.property_name != "name");
        self
    }


    pub fn with_name(
        mut self,
        operator: FieldOperator,
        values: impl IntoIterator<Item = impl Into<teaql_core::Value>>,
    ) -> Self {
        self.query = self.query.and_filter(field_operator_expr(
            "name",
            operator,
            values.into_iter().map(Into::into).collect(),
        ));
        self
    }

    pub fn create_name_criteria(
        operator: FieldOperator,
        values: impl IntoIterator<Item = impl Into<teaql_core::Value>>,
    ) -> Expr {
        field_operator_expr(
            "name",
            operator,
            values.into_iter().map(Into::into).collect(),
        )
    }

    pub fn with_name_is(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::eq("name", value));
        self
    }



    pub fn with_name_is_not(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::ne("name", value));
        self
    }

    pub fn with_name_greater_than(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::gt("name", value));
        self
    }

    pub fn with_name_greater_than_or_equal_to(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::gte("name", value));
        self
    }

    pub fn with_name_less_than(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::lt("name", value));
        self
    }

    pub fn with_name_less_than_or_equal_to(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::lte("name", value));
        self
    }

    pub fn with_name_between(
        mut self,
        lower: impl Into<teaql_core::Value>,
        upper: impl Into<teaql_core::Value>,
    ) -> Self {
        self.query = self.query.and_filter(Expr::between("name", lower, upper));
        self
    }

    pub fn with_name_between_range<T>(mut self, range: DateRange<T>) -> Self
    where
        T: Into<teaql_core::Value>,
    {
        self.query = self.query.and_filter(Expr::between(
            "name",
            range.start,
            range.end,
        ));
        self
    }

    pub fn with_name_in(
        mut self,
        values: impl IntoIterator<Item = impl Into<teaql_core::Value>>,
    ) -> Self {
        self.query = self.query.and_filter(Expr::in_list(
            "name",
            values.into_iter().map(Into::into),
        ));
        self
    }

    pub fn with_name_not_in(
        mut self,
        values: impl IntoIterator<Item = impl Into<teaql_core::Value>>,
    ) -> Self {
        self.query = self.query.and_filter(Expr::not_in_list(
            "name",
            values.into_iter().map(Into::into),
        ));
        self
    }

    pub fn with_name_containing(mut self, value: impl Into<String>) -> Self {
        self.query = self.query.and_filter(Expr::contain("name", value));
        self
    }

    pub fn with_name_not_containing(mut self, value: impl Into<String>) -> Self {
        self.query = self.query.and_filter(Expr::not_contain("name", value));
        self
    }

    pub fn with_name_starting_with(mut self, value: impl Into<String>) -> Self {
        self.query = self.query.and_filter(Expr::begin_with("name", value));
        self
    }

    pub fn with_name_not_starting_with(mut self, value: impl Into<String>) -> Self {
        self.query = self.query.and_filter(Expr::not_begin_with("name", value));
        self
    }

    pub fn with_name_ending_with(mut self, value: impl Into<String>) -> Self {
        self.query = self.query.and_filter(Expr::end_with("name", value));
        self
    }

    pub fn with_name_not_ending_with(mut self, value: impl Into<String>) -> Self {
        self.query = self.query.and_filter(Expr::not_end_with("name", value));
        self
    }

    pub fn with_name_sounding_like(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::sound_like("name", value));
        self
    }
    pub fn with_name_before(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::lt("name", value));
        self
    }

    pub fn with_name_after(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::gt("name", value));
        self
    }

    pub fn with_name_is_unknown(mut self) -> Self {
        self.query = self.query.and_filter(Expr::is_null("name"));
        self
    }



    pub fn with_name_is_known(mut self) -> Self {
        self.query = self.query.and_filter(Expr::is_not_null("name"));
        self
    }


    pub fn order_by_name_asc(mut self) -> Self {
        self.query = self.query.order_asc("name");
        self
    }

    pub fn order_by_name_desc(mut self) -> Self {
        self.query = self.query.order_desc("name");
        self
    }

    pub fn order_by_name_asc_using_gbk(mut self) -> Self {
        self.query = self.query.order_gbk_asc("name");
        self
    }

    pub fn order_by_name_desc_using_gbk(mut self) -> Self {
        self.query = self.query.order_gbk_desc("name");
        self
    }


    pub fn select_price(mut self) -> Self {
        self.query = self.query.project("price");
        self
    }

    pub fn project_price(self) -> Self {
        self.select_price()
    }

    pub fn select_price_raw(self, raw_sql_segment: impl Into<String>) -> Self {
        self.select_price_unsafe_raw(UnsafeRawSqlSegment::trusted(raw_sql_segment))
    }

    pub fn select_price_unsafe_raw(mut self, raw_sql_segment: UnsafeRawSqlSegment) -> Self {
        self.query_options
            .raw_projections
            .push(RawProjection::new("price", raw_sql_segment));
        self
    }

    pub fn select_price_with_function(self, function: AggregateFunction) -> Self {
        self.select_price_as_with_function("price", function)
    }

    pub fn select_price_as_with_function(
        self,
        alias: impl Into<String>,
        function: AggregateFunction,
    ) -> Self {
        self.aggregate_with_function("price", alias, function)
    }

    pub fn group_by_price(self) -> Self {
        self.group_by("price")
    }

    pub fn group_by_price_as(self, alias: impl Into<String>) -> Self {
        let alias = alias.into();
        let mut request = self.group_by("price");
        request.query = request
            .query
            .project_expr(alias, Expr::column("price"));
        request
    }

    pub fn group_by_price_with_function(
        self,
        alias: impl Into<String>,
        function: AggregateFunction,
    ) -> Self {
        self.group_by("price")
            .aggregate_with_function("price", alias, function)
    }

    pub fn count_price(self) -> Self {
        self.count_price_as("price_count")
    }

    pub fn count_price_as(self, alias: impl Into<String>) -> Self {
        self.aggregate_count_field("price", alias)
    }

    pub fn sum_price(self) -> Self {
        self.sum_price_as("sum_price")
    }

    pub fn sum_price_as(self, alias: impl Into<String>) -> Self {
        self.aggregate_sum("price", alias)
    }

    pub fn avg_price(self) -> Self {
        self.avg_price_as("avg_price")
    }

    pub fn avg_price_as(self, alias: impl Into<String>) -> Self {
        self.aggregate_avg("price", alias)
    }

    pub fn min_price(self) -> Self {
        self.min_price_as("min_price")
    }

    pub fn min_price_as(self, alias: impl Into<String>) -> Self {
        self.aggregate_min("price", alias)
    }

    pub fn max_price(self) -> Self {
        self.max_price_as("max_price")
    }

    pub fn max_price_as(self, alias: impl Into<String>) -> Self {
        self.aggregate_max("price", alias)
    }

    pub fn standard_deviation_price(self) -> Self {
        self.standard_deviation_price_as("stdDev_price")
    }

    pub fn standard_deviation_price_as(self, alias: impl Into<String>) -> Self {
        self.aggregate_stddev("price", alias)
    }

    pub fn square_root_of_population_standard_deviation_price(self) -> Self {
        self.square_root_of_population_standard_deviation_price_as("stdDevPop_price")
    }

    pub fn square_root_of_population_standard_deviation_price_as(self, alias: impl Into<String>) -> Self {
        self.aggregate_stddev_pop("price", alias)
    }

    pub fn sample_variance_price(self) -> Self {
        self.sample_variance_price_as("varSamp_price")
    }

    pub fn sample_variance_price_as(self, alias: impl Into<String>) -> Self {
        self.aggregate_var_samp("price", alias)
    }

    pub fn sample_population_variance_price(self) -> Self {
        self.sample_population_variance_price_as("varPop_price")
    }

    pub fn sample_population_variance_price_as(self, alias: impl Into<String>) -> Self {
        self.aggregate_var_pop("price", alias)
    }

    pub fn unselect_price(mut self) -> Self {
        self.query.projection.retain(|field| field != "price");
        self.query_options.raw_projections.retain(|projection| projection.property_name != "price");
        self
    }


    pub fn with_price(
        mut self,
        operator: FieldOperator,
        values: impl IntoIterator<Item = impl Into<teaql_core::Value>>,
    ) -> Self {
        self.query = self.query.and_filter(field_operator_expr(
            "price",
            operator,
            values.into_iter().map(Into::into).collect(),
        ));
        self
    }

    pub fn create_price_criteria(
        operator: FieldOperator,
        values: impl IntoIterator<Item = impl Into<teaql_core::Value>>,
    ) -> Expr {
        field_operator_expr(
            "price",
            operator,
            values.into_iter().map(Into::into).collect(),
        )
    }

    pub fn with_price_is(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::eq("price", value));
        self
    }



    pub fn with_price_is_not(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::ne("price", value));
        self
    }

    pub fn with_price_greater_than(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::gt("price", value));
        self
    }

    pub fn with_price_greater_than_or_equal_to(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::gte("price", value));
        self
    }

    pub fn with_price_less_than(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::lt("price", value));
        self
    }

    pub fn with_price_less_than_or_equal_to(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::lte("price", value));
        self
    }

    pub fn with_price_between(
        mut self,
        lower: impl Into<teaql_core::Value>,
        upper: impl Into<teaql_core::Value>,
    ) -> Self {
        self.query = self.query.and_filter(Expr::between("price", lower, upper));
        self
    }

    pub fn with_price_between_range<T>(mut self, range: DateRange<T>) -> Self
    where
        T: Into<teaql_core::Value>,
    {
        self.query = self.query.and_filter(Expr::between(
            "price",
            range.start,
            range.end,
        ));
        self
    }

    pub fn with_price_in(
        mut self,
        values: impl IntoIterator<Item = impl Into<teaql_core::Value>>,
    ) -> Self {
        self.query = self.query.and_filter(Expr::in_list(
            "price",
            values.into_iter().map(Into::into),
        ));
        self
    }

    pub fn with_price_not_in(
        mut self,
        values: impl IntoIterator<Item = impl Into<teaql_core::Value>>,
    ) -> Self {
        self.query = self.query.and_filter(Expr::not_in_list(
            "price",
            values.into_iter().map(Into::into),
        ));
        self
    }

    pub fn with_price_before(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::lt("price", value));
        self
    }

    pub fn with_price_after(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::gt("price", value));
        self
    }

    pub fn with_price_is_unknown(mut self) -> Self {
        self.query = self.query.and_filter(Expr::is_null("price"));
        self
    }



    pub fn with_price_is_known(mut self) -> Self {
        self.query = self.query.and_filter(Expr::is_not_null("price"));
        self
    }


    pub fn order_by_price_asc(mut self) -> Self {
        self.query = self.query.order_asc("price");
        self
    }

    pub fn order_by_price_desc(mut self) -> Self {
        self.query = self.query.order_desc("price");
        self
    }

    pub fn order_by_price_asc_using_gbk(mut self) -> Self {
        self.query = self.query.order_gbk_asc("price");
        self
    }

    pub fn order_by_price_desc_using_gbk(mut self) -> Self {
        self.query = self.query.order_gbk_desc("price");
        self
    }


    pub fn select_cost(mut self) -> Self {
        self.query = self.query.project("cost");
        self
    }

    pub fn project_cost(self) -> Self {
        self.select_cost()
    }

    pub fn select_cost_raw(self, raw_sql_segment: impl Into<String>) -> Self {
        self.select_cost_unsafe_raw(UnsafeRawSqlSegment::trusted(raw_sql_segment))
    }

    pub fn select_cost_unsafe_raw(mut self, raw_sql_segment: UnsafeRawSqlSegment) -> Self {
        self.query_options
            .raw_projections
            .push(RawProjection::new("cost", raw_sql_segment));
        self
    }

    pub fn select_cost_with_function(self, function: AggregateFunction) -> Self {
        self.select_cost_as_with_function("cost", function)
    }

    pub fn select_cost_as_with_function(
        self,
        alias: impl Into<String>,
        function: AggregateFunction,
    ) -> Self {
        self.aggregate_with_function("cost", alias, function)
    }

    pub fn group_by_cost(self) -> Self {
        self.group_by("cost")
    }

    pub fn group_by_cost_as(self, alias: impl Into<String>) -> Self {
        let alias = alias.into();
        let mut request = self.group_by("cost");
        request.query = request
            .query
            .project_expr(alias, Expr::column("cost"));
        request
    }

    pub fn group_by_cost_with_function(
        self,
        alias: impl Into<String>,
        function: AggregateFunction,
    ) -> Self {
        self.group_by("cost")
            .aggregate_with_function("cost", alias, function)
    }

    pub fn count_cost(self) -> Self {
        self.count_cost_as("cost_count")
    }

    pub fn count_cost_as(self, alias: impl Into<String>) -> Self {
        self.aggregate_count_field("cost", alias)
    }

    pub fn sum_cost(self) -> Self {
        self.sum_cost_as("sum_cost")
    }

    pub fn sum_cost_as(self, alias: impl Into<String>) -> Self {
        self.aggregate_sum("cost", alias)
    }

    pub fn avg_cost(self) -> Self {
        self.avg_cost_as("avg_cost")
    }

    pub fn avg_cost_as(self, alias: impl Into<String>) -> Self {
        self.aggregate_avg("cost", alias)
    }

    pub fn min_cost(self) -> Self {
        self.min_cost_as("min_cost")
    }

    pub fn min_cost_as(self, alias: impl Into<String>) -> Self {
        self.aggregate_min("cost", alias)
    }

    pub fn max_cost(self) -> Self {
        self.max_cost_as("max_cost")
    }

    pub fn max_cost_as(self, alias: impl Into<String>) -> Self {
        self.aggregate_max("cost", alias)
    }

    pub fn standard_deviation_cost(self) -> Self {
        self.standard_deviation_cost_as("stdDev_cost")
    }

    pub fn standard_deviation_cost_as(self, alias: impl Into<String>) -> Self {
        self.aggregate_stddev("cost", alias)
    }

    pub fn square_root_of_population_standard_deviation_cost(self) -> Self {
        self.square_root_of_population_standard_deviation_cost_as("stdDevPop_cost")
    }

    pub fn square_root_of_population_standard_deviation_cost_as(self, alias: impl Into<String>) -> Self {
        self.aggregate_stddev_pop("cost", alias)
    }

    pub fn sample_variance_cost(self) -> Self {
        self.sample_variance_cost_as("varSamp_cost")
    }

    pub fn sample_variance_cost_as(self, alias: impl Into<String>) -> Self {
        self.aggregate_var_samp("cost", alias)
    }

    pub fn sample_population_variance_cost(self) -> Self {
        self.sample_population_variance_cost_as("varPop_cost")
    }

    pub fn sample_population_variance_cost_as(self, alias: impl Into<String>) -> Self {
        self.aggregate_var_pop("cost", alias)
    }

    pub fn unselect_cost(mut self) -> Self {
        self.query.projection.retain(|field| field != "cost");
        self.query_options.raw_projections.retain(|projection| projection.property_name != "cost");
        self
    }


    pub fn with_cost(
        mut self,
        operator: FieldOperator,
        values: impl IntoIterator<Item = impl Into<teaql_core::Value>>,
    ) -> Self {
        self.query = self.query.and_filter(field_operator_expr(
            "cost",
            operator,
            values.into_iter().map(Into::into).collect(),
        ));
        self
    }

    pub fn create_cost_criteria(
        operator: FieldOperator,
        values: impl IntoIterator<Item = impl Into<teaql_core::Value>>,
    ) -> Expr {
        field_operator_expr(
            "cost",
            operator,
            values.into_iter().map(Into::into).collect(),
        )
    }

    pub fn with_cost_is(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::eq("cost", value));
        self
    }



    pub fn with_cost_is_not(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::ne("cost", value));
        self
    }

    pub fn with_cost_greater_than(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::gt("cost", value));
        self
    }

    pub fn with_cost_greater_than_or_equal_to(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::gte("cost", value));
        self
    }

    pub fn with_cost_less_than(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::lt("cost", value));
        self
    }

    pub fn with_cost_less_than_or_equal_to(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::lte("cost", value));
        self
    }

    pub fn with_cost_between(
        mut self,
        lower: impl Into<teaql_core::Value>,
        upper: impl Into<teaql_core::Value>,
    ) -> Self {
        self.query = self.query.and_filter(Expr::between("cost", lower, upper));
        self
    }

    pub fn with_cost_between_range<T>(mut self, range: DateRange<T>) -> Self
    where
        T: Into<teaql_core::Value>,
    {
        self.query = self.query.and_filter(Expr::between(
            "cost",
            range.start,
            range.end,
        ));
        self
    }

    pub fn with_cost_in(
        mut self,
        values: impl IntoIterator<Item = impl Into<teaql_core::Value>>,
    ) -> Self {
        self.query = self.query.and_filter(Expr::in_list(
            "cost",
            values.into_iter().map(Into::into),
        ));
        self
    }

    pub fn with_cost_not_in(
        mut self,
        values: impl IntoIterator<Item = impl Into<teaql_core::Value>>,
    ) -> Self {
        self.query = self.query.and_filter(Expr::not_in_list(
            "cost",
            values.into_iter().map(Into::into),
        ));
        self
    }

    pub fn with_cost_before(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::lt("cost", value));
        self
    }

    pub fn with_cost_after(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::gt("cost", value));
        self
    }

    pub fn with_cost_is_unknown(mut self) -> Self {
        self.query = self.query.and_filter(Expr::is_null("cost"));
        self
    }



    pub fn with_cost_is_known(mut self) -> Self {
        self.query = self.query.and_filter(Expr::is_not_null("cost"));
        self
    }


    pub fn order_by_cost_asc(mut self) -> Self {
        self.query = self.query.order_asc("cost");
        self
    }

    pub fn order_by_cost_desc(mut self) -> Self {
        self.query = self.query.order_desc("cost");
        self
    }

    pub fn order_by_cost_asc_using_gbk(mut self) -> Self {
        self.query = self.query.order_gbk_asc("cost");
        self
    }

    pub fn order_by_cost_desc_using_gbk(mut self) -> Self {
        self.query = self.query.order_gbk_desc("cost");
        self
    }


    pub fn select_is_active(mut self) -> Self {
        self.query = self.query.project("is_active");
        self
    }

    pub fn project_is_active(self) -> Self {
        self.select_is_active()
    }

    pub fn select_is_active_raw(self, raw_sql_segment: impl Into<String>) -> Self {
        self.select_is_active_unsafe_raw(UnsafeRawSqlSegment::trusted(raw_sql_segment))
    }

    pub fn select_is_active_unsafe_raw(mut self, raw_sql_segment: UnsafeRawSqlSegment) -> Self {
        self.query_options
            .raw_projections
            .push(RawProjection::new("is_active", raw_sql_segment));
        self
    }

    pub fn group_by_is_active(self) -> Self {
        self.group_by("is_active")
    }

    pub fn group_by_is_active_as(self, alias: impl Into<String>) -> Self {
        let alias = alias.into();
        let mut request = self.group_by("is_active");
        request.query = request
            .query
            .project_expr(alias, Expr::column("is_active"));
        request
    }

    pub fn group_by_is_active_with_function(
        self,
        alias: impl Into<String>,
        function: AggregateFunction,
    ) -> Self {
        self.group_by("is_active")
            .aggregate_with_function("is_active", alias, function)
    }

    pub fn count_is_active(self) -> Self {
        self.count_is_active_as("is_active_count")
    }

    pub fn count_is_active_as(self, alias: impl Into<String>) -> Self {
        self.aggregate_count_field("is_active", alias)
    }

    pub fn sum_is_active(self) -> Self {
        self.sum_is_active_as("sum_is_active")
    }

    pub fn sum_is_active_as(self, alias: impl Into<String>) -> Self {
        self.aggregate_sum("is_active", alias)
    }

    pub fn avg_is_active(self) -> Self {
        self.avg_is_active_as("avg_is_active")
    }

    pub fn avg_is_active_as(self, alias: impl Into<String>) -> Self {
        self.aggregate_avg("is_active", alias)
    }

    pub fn min_is_active(self) -> Self {
        self.min_is_active_as("min_is_active")
    }

    pub fn min_is_active_as(self, alias: impl Into<String>) -> Self {
        self.aggregate_min("is_active", alias)
    }

    pub fn max_is_active(self) -> Self {
        self.max_is_active_as("max_is_active")
    }

    pub fn max_is_active_as(self, alias: impl Into<String>) -> Self {
        self.aggregate_max("is_active", alias)
    }

    pub fn unselect_is_active(mut self) -> Self {
        self.query.projection.retain(|field| field != "is_active");
        self.query_options.raw_projections.retain(|projection| projection.property_name != "is_active");
        self
    }


    pub fn with_is_active(
        mut self,
        operator: FieldOperator,
        values: impl IntoIterator<Item = impl Into<teaql_core::Value>>,
    ) -> Self {
        self.query = self.query.and_filter(field_operator_expr(
            "is_active",
            operator,
            values.into_iter().map(Into::into).collect(),
        ));
        self
    }

    pub fn create_is_active_criteria(
        operator: FieldOperator,
        values: impl IntoIterator<Item = impl Into<teaql_core::Value>>,
    ) -> Expr {
        field_operator_expr(
            "is_active",
            operator,
            values.into_iter().map(Into::into).collect(),
        )
    }

    pub fn with_is_active_is(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::eq("is_active", value));
        self
    }



    pub fn with_is_active_is_not(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::ne("is_active", value));
        self
    }

    pub fn with_is_active_greater_than(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::gt("is_active", value));
        self
    }

    pub fn with_is_active_greater_than_or_equal_to(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::gte("is_active", value));
        self
    }

    pub fn with_is_active_less_than(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::lt("is_active", value));
        self
    }

    pub fn with_is_active_less_than_or_equal_to(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::lte("is_active", value));
        self
    }

    pub fn with_is_active_between(
        mut self,
        lower: impl Into<teaql_core::Value>,
        upper: impl Into<teaql_core::Value>,
    ) -> Self {
        self.query = self.query.and_filter(Expr::between("is_active", lower, upper));
        self
    }

    pub fn with_is_active_between_range<T>(mut self, range: DateRange<T>) -> Self
    where
        T: Into<teaql_core::Value>,
    {
        self.query = self.query.and_filter(Expr::between(
            "is_active",
            range.start,
            range.end,
        ));
        self
    }

    pub fn with_is_active_in(
        mut self,
        values: impl IntoIterator<Item = impl Into<teaql_core::Value>>,
    ) -> Self {
        self.query = self.query.and_filter(Expr::in_list(
            "is_active",
            values.into_iter().map(Into::into),
        ));
        self
    }

    pub fn with_is_active_not_in(
        mut self,
        values: impl IntoIterator<Item = impl Into<teaql_core::Value>>,
    ) -> Self {
        self.query = self.query.and_filter(Expr::not_in_list(
            "is_active",
            values.into_iter().map(Into::into),
        ));
        self
    }

    pub fn with_is_active_before(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::lt("is_active", value));
        self
    }

    pub fn with_is_active_after(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::gt("is_active", value));
        self
    }

    pub fn with_is_active_is_unknown(mut self) -> Self {
        self.query = self.query.and_filter(Expr::is_null("is_active"));
        self
    }



    pub fn with_is_active_is_known(mut self) -> Self {
        self.query = self.query.and_filter(Expr::is_not_null("is_active"));
        self
    }


    pub fn order_by_is_active_asc(mut self) -> Self {
        self.query = self.query.order_asc("is_active");
        self
    }

    pub fn order_by_is_active_desc(mut self) -> Self {
        self.query = self.query.order_desc("is_active");
        self
    }

    pub fn order_by_is_active_asc_using_gbk(mut self) -> Self {
        self.query = self.query.order_gbk_asc("is_active");
        self
    }

    pub fn order_by_is_active_desc_using_gbk(mut self) -> Self {
        self.query = self.query.order_gbk_desc("is_active");
        self
    }


    pub fn select_sku(mut self) -> Self {
        self.query = self.query.project("sku");
        self
    }

    pub fn project_sku(self) -> Self {
        self.select_sku()
    }

    pub fn select_sku_raw(self, raw_sql_segment: impl Into<String>) -> Self {
        self.select_sku_unsafe_raw(UnsafeRawSqlSegment::trusted(raw_sql_segment))
    }

    pub fn select_sku_unsafe_raw(mut self, raw_sql_segment: UnsafeRawSqlSegment) -> Self {
        self.query_options
            .raw_projections
            .push(RawProjection::new("sku", raw_sql_segment));
        self
    }

    pub fn group_by_sku(self) -> Self {
        self.group_by("sku")
    }

    pub fn group_by_sku_as(self, alias: impl Into<String>) -> Self {
        let alias = alias.into();
        let mut request = self.group_by("sku");
        request.query = request
            .query
            .project_expr(alias, Expr::column("sku"));
        request
    }

    pub fn group_by_sku_with_function(
        self,
        alias: impl Into<String>,
        function: AggregateFunction,
    ) -> Self {
        self.group_by("sku")
            .aggregate_with_function("sku", alias, function)
    }

    pub fn count_sku(self) -> Self {
        self.count_sku_as("sku_count")
    }

    pub fn count_sku_as(self, alias: impl Into<String>) -> Self {
        self.aggregate_count_field("sku", alias)
    }

    pub fn sum_sku(self) -> Self {
        self.sum_sku_as("sum_sku")
    }

    pub fn sum_sku_as(self, alias: impl Into<String>) -> Self {
        self.aggregate_sum("sku", alias)
    }

    pub fn avg_sku(self) -> Self {
        self.avg_sku_as("avg_sku")
    }

    pub fn avg_sku_as(self, alias: impl Into<String>) -> Self {
        self.aggregate_avg("sku", alias)
    }

    pub fn min_sku(self) -> Self {
        self.min_sku_as("min_sku")
    }

    pub fn min_sku_as(self, alias: impl Into<String>) -> Self {
        self.aggregate_min("sku", alias)
    }

    pub fn max_sku(self) -> Self {
        self.max_sku_as("max_sku")
    }

    pub fn max_sku_as(self, alias: impl Into<String>) -> Self {
        self.aggregate_max("sku", alias)
    }

    pub fn unselect_sku(mut self) -> Self {
        self.query.projection.retain(|field| field != "sku");
        self.query_options.raw_projections.retain(|projection| projection.property_name != "sku");
        self
    }


    pub fn with_sku(
        mut self,
        operator: FieldOperator,
        values: impl IntoIterator<Item = impl Into<teaql_core::Value>>,
    ) -> Self {
        self.query = self.query.and_filter(field_operator_expr(
            "sku",
            operator,
            values.into_iter().map(Into::into).collect(),
        ));
        self
    }

    pub fn create_sku_criteria(
        operator: FieldOperator,
        values: impl IntoIterator<Item = impl Into<teaql_core::Value>>,
    ) -> Expr {
        field_operator_expr(
            "sku",
            operator,
            values.into_iter().map(Into::into).collect(),
        )
    }

    pub fn with_sku_is(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::eq("sku", value));
        self
    }



    pub fn with_sku_is_not(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::ne("sku", value));
        self
    }

    pub fn with_sku_greater_than(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::gt("sku", value));
        self
    }

    pub fn with_sku_greater_than_or_equal_to(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::gte("sku", value));
        self
    }

    pub fn with_sku_less_than(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::lt("sku", value));
        self
    }

    pub fn with_sku_less_than_or_equal_to(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::lte("sku", value));
        self
    }

    pub fn with_sku_between(
        mut self,
        lower: impl Into<teaql_core::Value>,
        upper: impl Into<teaql_core::Value>,
    ) -> Self {
        self.query = self.query.and_filter(Expr::between("sku", lower, upper));
        self
    }

    pub fn with_sku_between_range<T>(mut self, range: DateRange<T>) -> Self
    where
        T: Into<teaql_core::Value>,
    {
        self.query = self.query.and_filter(Expr::between(
            "sku",
            range.start,
            range.end,
        ));
        self
    }

    pub fn with_sku_in(
        mut self,
        values: impl IntoIterator<Item = impl Into<teaql_core::Value>>,
    ) -> Self {
        self.query = self.query.and_filter(Expr::in_list(
            "sku",
            values.into_iter().map(Into::into),
        ));
        self
    }

    pub fn with_sku_not_in(
        mut self,
        values: impl IntoIterator<Item = impl Into<teaql_core::Value>>,
    ) -> Self {
        self.query = self.query.and_filter(Expr::not_in_list(
            "sku",
            values.into_iter().map(Into::into),
        ));
        self
    }

    pub fn with_sku_containing(mut self, value: impl Into<String>) -> Self {
        self.query = self.query.and_filter(Expr::contain("sku", value));
        self
    }

    pub fn with_sku_not_containing(mut self, value: impl Into<String>) -> Self {
        self.query = self.query.and_filter(Expr::not_contain("sku", value));
        self
    }

    pub fn with_sku_starting_with(mut self, value: impl Into<String>) -> Self {
        self.query = self.query.and_filter(Expr::begin_with("sku", value));
        self
    }

    pub fn with_sku_not_starting_with(mut self, value: impl Into<String>) -> Self {
        self.query = self.query.and_filter(Expr::not_begin_with("sku", value));
        self
    }

    pub fn with_sku_ending_with(mut self, value: impl Into<String>) -> Self {
        self.query = self.query.and_filter(Expr::end_with("sku", value));
        self
    }

    pub fn with_sku_not_ending_with(mut self, value: impl Into<String>) -> Self {
        self.query = self.query.and_filter(Expr::not_end_with("sku", value));
        self
    }

    pub fn with_sku_sounding_like(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::sound_like("sku", value));
        self
    }
    pub fn with_sku_before(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::lt("sku", value));
        self
    }

    pub fn with_sku_after(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::gt("sku", value));
        self
    }

    pub fn with_sku_is_unknown(mut self) -> Self {
        self.query = self.query.and_filter(Expr::is_null("sku"));
        self
    }



    pub fn with_sku_is_known(mut self) -> Self {
        self.query = self.query.and_filter(Expr::is_not_null("sku"));
        self
    }


    pub fn order_by_sku_asc(mut self) -> Self {
        self.query = self.query.order_asc("sku");
        self
    }

    pub fn order_by_sku_desc(mut self) -> Self {
        self.query = self.query.order_desc("sku");
        self
    }

    pub fn order_by_sku_asc_using_gbk(mut self) -> Self {
        self.query = self.query.order_gbk_asc("sku");
        self
    }

    pub fn order_by_sku_desc_using_gbk(mut self) -> Self {
        self.query = self.query.order_gbk_desc("sku");
        self
    }


    pub fn select_stock(mut self) -> Self {
        self.query = self.query.project("stock");
        self
    }

    pub fn project_stock(self) -> Self {
        self.select_stock()
    }

    pub fn select_stock_raw(self, raw_sql_segment: impl Into<String>) -> Self {
        self.select_stock_unsafe_raw(UnsafeRawSqlSegment::trusted(raw_sql_segment))
    }

    pub fn select_stock_unsafe_raw(mut self, raw_sql_segment: UnsafeRawSqlSegment) -> Self {
        self.query_options
            .raw_projections
            .push(RawProjection::new("stock", raw_sql_segment));
        self
    }

    pub fn select_stock_with_function(self, function: AggregateFunction) -> Self {
        self.select_stock_as_with_function("stock", function)
    }

    pub fn select_stock_as_with_function(
        self,
        alias: impl Into<String>,
        function: AggregateFunction,
    ) -> Self {
        self.aggregate_with_function("stock", alias, function)
    }

    pub fn group_by_stock(self) -> Self {
        self.group_by("stock")
    }

    pub fn group_by_stock_as(self, alias: impl Into<String>) -> Self {
        let alias = alias.into();
        let mut request = self.group_by("stock");
        request.query = request
            .query
            .project_expr(alias, Expr::column("stock"));
        request
    }

    pub fn group_by_stock_with_function(
        self,
        alias: impl Into<String>,
        function: AggregateFunction,
    ) -> Self {
        self.group_by("stock")
            .aggregate_with_function("stock", alias, function)
    }

    pub fn count_stock(self) -> Self {
        self.count_stock_as("stock_count")
    }

    pub fn count_stock_as(self, alias: impl Into<String>) -> Self {
        self.aggregate_count_field("stock", alias)
    }

    pub fn sum_stock(self) -> Self {
        self.sum_stock_as("sum_stock")
    }

    pub fn sum_stock_as(self, alias: impl Into<String>) -> Self {
        self.aggregate_sum("stock", alias)
    }

    pub fn avg_stock(self) -> Self {
        self.avg_stock_as("avg_stock")
    }

    pub fn avg_stock_as(self, alias: impl Into<String>) -> Self {
        self.aggregate_avg("stock", alias)
    }

    pub fn min_stock(self) -> Self {
        self.min_stock_as("min_stock")
    }

    pub fn min_stock_as(self, alias: impl Into<String>) -> Self {
        self.aggregate_min("stock", alias)
    }

    pub fn max_stock(self) -> Self {
        self.max_stock_as("max_stock")
    }

    pub fn max_stock_as(self, alias: impl Into<String>) -> Self {
        self.aggregate_max("stock", alias)
    }

    pub fn standard_deviation_stock(self) -> Self {
        self.standard_deviation_stock_as("stdDev_stock")
    }

    pub fn standard_deviation_stock_as(self, alias: impl Into<String>) -> Self {
        self.aggregate_stddev("stock", alias)
    }

    pub fn square_root_of_population_standard_deviation_stock(self) -> Self {
        self.square_root_of_population_standard_deviation_stock_as("stdDevPop_stock")
    }

    pub fn square_root_of_population_standard_deviation_stock_as(self, alias: impl Into<String>) -> Self {
        self.aggregate_stddev_pop("stock", alias)
    }

    pub fn sample_variance_stock(self) -> Self {
        self.sample_variance_stock_as("varSamp_stock")
    }

    pub fn sample_variance_stock_as(self, alias: impl Into<String>) -> Self {
        self.aggregate_var_samp("stock", alias)
    }

    pub fn sample_population_variance_stock(self) -> Self {
        self.sample_population_variance_stock_as("varPop_stock")
    }

    pub fn sample_population_variance_stock_as(self, alias: impl Into<String>) -> Self {
        self.aggregate_var_pop("stock", alias)
    }

    pub fn unselect_stock(mut self) -> Self {
        self.query.projection.retain(|field| field != "stock");
        self.query_options.raw_projections.retain(|projection| projection.property_name != "stock");
        self
    }


    pub fn with_stock(
        mut self,
        operator: FieldOperator,
        values: impl IntoIterator<Item = impl Into<teaql_core::Value>>,
    ) -> Self {
        self.query = self.query.and_filter(field_operator_expr(
            "stock",
            operator,
            values.into_iter().map(Into::into).collect(),
        ));
        self
    }

    pub fn create_stock_criteria(
        operator: FieldOperator,
        values: impl IntoIterator<Item = impl Into<teaql_core::Value>>,
    ) -> Expr {
        field_operator_expr(
            "stock",
            operator,
            values.into_iter().map(Into::into).collect(),
        )
    }

    pub fn with_stock_is(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::eq("stock", value));
        self
    }



    pub fn with_stock_is_not(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::ne("stock", value));
        self
    }

    pub fn with_stock_greater_than(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::gt("stock", value));
        self
    }

    pub fn with_stock_greater_than_or_equal_to(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::gte("stock", value));
        self
    }

    pub fn with_stock_less_than(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::lt("stock", value));
        self
    }

    pub fn with_stock_less_than_or_equal_to(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::lte("stock", value));
        self
    }

    pub fn with_stock_between(
        mut self,
        lower: impl Into<teaql_core::Value>,
        upper: impl Into<teaql_core::Value>,
    ) -> Self {
        self.query = self.query.and_filter(Expr::between("stock", lower, upper));
        self
    }

    pub fn with_stock_between_range<T>(mut self, range: DateRange<T>) -> Self
    where
        T: Into<teaql_core::Value>,
    {
        self.query = self.query.and_filter(Expr::between(
            "stock",
            range.start,
            range.end,
        ));
        self
    }

    pub fn with_stock_in(
        mut self,
        values: impl IntoIterator<Item = impl Into<teaql_core::Value>>,
    ) -> Self {
        self.query = self.query.and_filter(Expr::in_list(
            "stock",
            values.into_iter().map(Into::into),
        ));
        self
    }

    pub fn with_stock_not_in(
        mut self,
        values: impl IntoIterator<Item = impl Into<teaql_core::Value>>,
    ) -> Self {
        self.query = self.query.and_filter(Expr::not_in_list(
            "stock",
            values.into_iter().map(Into::into),
        ));
        self
    }

    pub fn with_stock_before(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::lt("stock", value));
        self
    }

    pub fn with_stock_after(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::gt("stock", value));
        self
    }

    pub fn with_stock_is_unknown(mut self) -> Self {
        self.query = self.query.and_filter(Expr::is_null("stock"));
        self
    }



    pub fn with_stock_is_known(mut self) -> Self {
        self.query = self.query.and_filter(Expr::is_not_null("stock"));
        self
    }


    pub fn order_by_stock_asc(mut self) -> Self {
        self.query = self.query.order_asc("stock");
        self
    }

    pub fn order_by_stock_desc(mut self) -> Self {
        self.query = self.query.order_desc("stock");
        self
    }

    pub fn order_by_stock_asc_using_gbk(mut self) -> Self {
        self.query = self.query.order_gbk_asc("stock");
        self
    }

    pub fn order_by_stock_desc_using_gbk(mut self) -> Self {
        self.query = self.query.order_gbk_desc("stock");
        self
    }


    pub fn select_create_time(mut self) -> Self {
        self.query = self.query.project("create_time");
        self
    }

    pub fn project_create_time(self) -> Self {
        self.select_create_time()
    }

    pub fn select_create_time_raw(self, raw_sql_segment: impl Into<String>) -> Self {
        self.select_create_time_unsafe_raw(UnsafeRawSqlSegment::trusted(raw_sql_segment))
    }

    pub fn select_create_time_unsafe_raw(mut self, raw_sql_segment: UnsafeRawSqlSegment) -> Self {
        self.query_options
            .raw_projections
            .push(RawProjection::new("create_time", raw_sql_segment));
        self
    }

    pub fn group_by_create_time(self) -> Self {
        self.group_by("create_time")
    }

    pub fn group_by_create_time_as(self, alias: impl Into<String>) -> Self {
        let alias = alias.into();
        let mut request = self.group_by("create_time");
        request.query = request
            .query
            .project_expr(alias, Expr::column("create_time"));
        request
    }

    pub fn group_by_create_time_with_function(
        self,
        alias: impl Into<String>,
        function: AggregateFunction,
    ) -> Self {
        self.group_by("create_time")
            .aggregate_with_function("create_time", alias, function)
    }

    pub fn count_create_time(self) -> Self {
        self.count_create_time_as("create_time_count")
    }

    pub fn count_create_time_as(self, alias: impl Into<String>) -> Self {
        self.aggregate_count_field("create_time", alias)
    }

    pub fn sum_create_time(self) -> Self {
        self.sum_create_time_as("sum_create_time")
    }

    pub fn sum_create_time_as(self, alias: impl Into<String>) -> Self {
        self.aggregate_sum("create_time", alias)
    }

    pub fn avg_create_time(self) -> Self {
        self.avg_create_time_as("avg_create_time")
    }

    pub fn avg_create_time_as(self, alias: impl Into<String>) -> Self {
        self.aggregate_avg("create_time", alias)
    }

    pub fn min_create_time(self) -> Self {
        self.min_create_time_as("min_create_time")
    }

    pub fn min_create_time_as(self, alias: impl Into<String>) -> Self {
        self.aggregate_min("create_time", alias)
    }

    pub fn max_create_time(self) -> Self {
        self.max_create_time_as("max_create_time")
    }

    pub fn max_create_time_as(self, alias: impl Into<String>) -> Self {
        self.aggregate_max("create_time", alias)
    }

    pub fn unselect_create_time(mut self) -> Self {
        self.query.projection.retain(|field| field != "create_time");
        self.query_options.raw_projections.retain(|projection| projection.property_name != "create_time");
        self
    }


    pub fn with_create_time(
        mut self,
        operator: FieldOperator,
        values: impl IntoIterator<Item = impl Into<teaql_core::Value>>,
    ) -> Self {
        self.query = self.query.and_filter(field_operator_expr(
            "create_time",
            operator,
            values.into_iter().map(Into::into).collect(),
        ));
        self
    }

    pub fn create_create_time_criteria(
        operator: FieldOperator,
        values: impl IntoIterator<Item = impl Into<teaql_core::Value>>,
    ) -> Expr {
        field_operator_expr(
            "create_time",
            operator,
            values.into_iter().map(Into::into).collect(),
        )
    }

    pub fn with_create_time_is(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::eq("create_time", value));
        self
    }



    pub fn with_create_time_is_not(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::ne("create_time", value));
        self
    }

    pub fn with_create_time_greater_than(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::gt("create_time", value));
        self
    }

    pub fn with_create_time_greater_than_or_equal_to(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::gte("create_time", value));
        self
    }

    pub fn with_create_time_less_than(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::lt("create_time", value));
        self
    }

    pub fn with_create_time_less_than_or_equal_to(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::lte("create_time", value));
        self
    }

    pub fn with_create_time_between(
        mut self,
        lower: impl Into<teaql_core::Value>,
        upper: impl Into<teaql_core::Value>,
    ) -> Self {
        self.query = self.query.and_filter(Expr::between("create_time", lower, upper));
        self
    }

    pub fn with_create_time_between_range<T>(mut self, range: DateRange<T>) -> Self
    where
        T: Into<teaql_core::Value>,
    {
        self.query = self.query.and_filter(Expr::between(
            "create_time",
            range.start,
            range.end,
        ));
        self
    }

    pub fn with_create_time_in(
        mut self,
        values: impl IntoIterator<Item = impl Into<teaql_core::Value>>,
    ) -> Self {
        self.query = self.query.and_filter(Expr::in_list(
            "create_time",
            values.into_iter().map(Into::into),
        ));
        self
    }

    pub fn with_create_time_not_in(
        mut self,
        values: impl IntoIterator<Item = impl Into<teaql_core::Value>>,
    ) -> Self {
        self.query = self.query.and_filter(Expr::not_in_list(
            "create_time",
            values.into_iter().map(Into::into),
        ));
        self
    }

    pub fn with_create_time_before(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::lt("create_time", value));
        self
    }

    pub fn with_create_time_after(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::gt("create_time", value));
        self
    }

    pub fn with_create_time_is_unknown(mut self) -> Self {
        self.query = self.query.and_filter(Expr::is_null("create_time"));
        self
    }



    pub fn with_create_time_is_known(mut self) -> Self {
        self.query = self.query.and_filter(Expr::is_not_null("create_time"));
        self
    }


    pub fn order_by_create_time_asc(mut self) -> Self {
        self.query = self.query.order_asc("create_time");
        self
    }

    pub fn order_by_create_time_desc(mut self) -> Self {
        self.query = self.query.order_desc("create_time");
        self
    }

    pub fn order_by_create_time_asc_using_gbk(mut self) -> Self {
        self.query = self.query.order_gbk_asc("create_time");
        self
    }

    pub fn order_by_create_time_desc_using_gbk(mut self) -> Self {
        self.query = self.query.order_gbk_desc("create_time");
        self
    }


    pub fn select_update_time(mut self) -> Self {
        self.query = self.query.project("update_time");
        self
    }

    pub fn project_update_time(self) -> Self {
        self.select_update_time()
    }

    pub fn select_update_time_raw(self, raw_sql_segment: impl Into<String>) -> Self {
        self.select_update_time_unsafe_raw(UnsafeRawSqlSegment::trusted(raw_sql_segment))
    }

    pub fn select_update_time_unsafe_raw(mut self, raw_sql_segment: UnsafeRawSqlSegment) -> Self {
        self.query_options
            .raw_projections
            .push(RawProjection::new("update_time", raw_sql_segment));
        self
    }

    pub fn group_by_update_time(self) -> Self {
        self.group_by("update_time")
    }

    pub fn group_by_update_time_as(self, alias: impl Into<String>) -> Self {
        let alias = alias.into();
        let mut request = self.group_by("update_time");
        request.query = request
            .query
            .project_expr(alias, Expr::column("update_time"));
        request
    }

    pub fn group_by_update_time_with_function(
        self,
        alias: impl Into<String>,
        function: AggregateFunction,
    ) -> Self {
        self.group_by("update_time")
            .aggregate_with_function("update_time", alias, function)
    }

    pub fn count_update_time(self) -> Self {
        self.count_update_time_as("update_time_count")
    }

    pub fn count_update_time_as(self, alias: impl Into<String>) -> Self {
        self.aggregate_count_field("update_time", alias)
    }

    pub fn sum_update_time(self) -> Self {
        self.sum_update_time_as("sum_update_time")
    }

    pub fn sum_update_time_as(self, alias: impl Into<String>) -> Self {
        self.aggregate_sum("update_time", alias)
    }

    pub fn avg_update_time(self) -> Self {
        self.avg_update_time_as("avg_update_time")
    }

    pub fn avg_update_time_as(self, alias: impl Into<String>) -> Self {
        self.aggregate_avg("update_time", alias)
    }

    pub fn min_update_time(self) -> Self {
        self.min_update_time_as("min_update_time")
    }

    pub fn min_update_time_as(self, alias: impl Into<String>) -> Self {
        self.aggregate_min("update_time", alias)
    }

    pub fn max_update_time(self) -> Self {
        self.max_update_time_as("max_update_time")
    }

    pub fn max_update_time_as(self, alias: impl Into<String>) -> Self {
        self.aggregate_max("update_time", alias)
    }

    pub fn unselect_update_time(mut self) -> Self {
        self.query.projection.retain(|field| field != "update_time");
        self.query_options.raw_projections.retain(|projection| projection.property_name != "update_time");
        self
    }


    pub fn with_update_time(
        mut self,
        operator: FieldOperator,
        values: impl IntoIterator<Item = impl Into<teaql_core::Value>>,
    ) -> Self {
        self.query = self.query.and_filter(field_operator_expr(
            "update_time",
            operator,
            values.into_iter().map(Into::into).collect(),
        ));
        self
    }

    pub fn create_update_time_criteria(
        operator: FieldOperator,
        values: impl IntoIterator<Item = impl Into<teaql_core::Value>>,
    ) -> Expr {
        field_operator_expr(
            "update_time",
            operator,
            values.into_iter().map(Into::into).collect(),
        )
    }

    pub fn with_update_time_is(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::eq("update_time", value));
        self
    }



    pub fn with_update_time_is_not(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::ne("update_time", value));
        self
    }

    pub fn with_update_time_greater_than(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::gt("update_time", value));
        self
    }

    pub fn with_update_time_greater_than_or_equal_to(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::gte("update_time", value));
        self
    }

    pub fn with_update_time_less_than(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::lt("update_time", value));
        self
    }

    pub fn with_update_time_less_than_or_equal_to(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::lte("update_time", value));
        self
    }

    pub fn with_update_time_between(
        mut self,
        lower: impl Into<teaql_core::Value>,
        upper: impl Into<teaql_core::Value>,
    ) -> Self {
        self.query = self.query.and_filter(Expr::between("update_time", lower, upper));
        self
    }

    pub fn with_update_time_between_range<T>(mut self, range: DateRange<T>) -> Self
    where
        T: Into<teaql_core::Value>,
    {
        self.query = self.query.and_filter(Expr::between(
            "update_time",
            range.start,
            range.end,
        ));
        self
    }

    pub fn with_update_time_in(
        mut self,
        values: impl IntoIterator<Item = impl Into<teaql_core::Value>>,
    ) -> Self {
        self.query = self.query.and_filter(Expr::in_list(
            "update_time",
            values.into_iter().map(Into::into),
        ));
        self
    }

    pub fn with_update_time_not_in(
        mut self,
        values: impl IntoIterator<Item = impl Into<teaql_core::Value>>,
    ) -> Self {
        self.query = self.query.and_filter(Expr::not_in_list(
            "update_time",
            values.into_iter().map(Into::into),
        ));
        self
    }

    pub fn with_update_time_before(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::lt("update_time", value));
        self
    }

    pub fn with_update_time_after(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::gt("update_time", value));
        self
    }

    pub fn with_update_time_is_unknown(mut self) -> Self {
        self.query = self.query.and_filter(Expr::is_null("update_time"));
        self
    }



    pub fn with_update_time_is_known(mut self) -> Self {
        self.query = self.query.and_filter(Expr::is_not_null("update_time"));
        self
    }


    pub fn order_by_update_time_asc(mut self) -> Self {
        self.query = self.query.order_asc("update_time");
        self
    }

    pub fn order_by_update_time_desc(mut self) -> Self {
        self.query = self.query.order_desc("update_time");
        self
    }

    pub fn order_by_update_time_asc_using_gbk(mut self) -> Self {
        self.query = self.query.order_gbk_asc("update_time");
        self
    }

    pub fn order_by_update_time_desc_using_gbk(mut self) -> Self {
        self.query = self.query.order_gbk_desc("update_time");
        self
    }

    pub fn group_by_version(self) -> Self {
        self.group_by("version")
    }

    pub fn group_by_version_as(self, alias: impl Into<String>) -> Self {
        let alias = alias.into();
        let mut request = self.group_by("version");
        request.query = request
            .query
            .project_expr(alias, Expr::column("version"));
        request
    }

    pub fn group_by_version_with_function(
        self,
        alias: impl Into<String>,
        function: AggregateFunction,
    ) -> Self {
        self.group_by("version")
            .aggregate_with_function("version", alias, function)
    }

    pub fn count_version(self) -> Self {
        self.count_version_as("version_count")
    }

    pub fn count_version_as(self, alias: impl Into<String>) -> Self {
        self.aggregate_count_field("version", alias)
    }

    pub fn sum_version(self) -> Self {
        self.sum_version_as("sum_version")
    }

    pub fn sum_version_as(self, alias: impl Into<String>) -> Self {
        self.aggregate_sum("version", alias)
    }

    pub fn avg_version(self) -> Self {
        self.avg_version_as("avg_version")
    }

    pub fn avg_version_as(self, alias: impl Into<String>) -> Self {
        self.aggregate_avg("version", alias)
    }

    pub fn min_version(self) -> Self {
        self.min_version_as("min_version")
    }

    pub fn min_version_as(self, alias: impl Into<String>) -> Self {
        self.aggregate_min("version", alias)
    }

    pub fn max_version(self) -> Self {
        self.max_version_as("max_version")
    }

    pub fn max_version_as(self, alias: impl Into<String>) -> Self {
        self.aggregate_max("version", alias)
    }

    pub fn order_by_version_asc(mut self) -> Self {
        self.query = self.query.order_asc("version");
        self
    }

    pub fn order_by_version_desc(mut self) -> Self {
        self.query = self.query.order_desc("version");
        self
    }

    pub fn order_by_version_asc_using_gbk(mut self) -> Self {
        self.query = self.query.order_gbk_asc("version");
        self
    }

    pub fn order_by_version_desc_using_gbk(mut self) -> Self {
        self.query = self.query.order_gbk_desc("version");
        self
    }
    pub fn filter_by_category(mut self, value: impl EntityReference) -> Self {
        self.query = self.query.and_filter(Expr::eq("category_id", value.entity_id_value()));
        self
    }

    pub fn with_category_matching(mut self, request: impl Into<QuerySelection>) -> Self {
        let selection = request.into();
        self.query = self.query.and_filter(Expr::in_subquery(
            "category_id",
            <crate::Category as teaql_core::TeaqlEntity>::entity_descriptor(),
            selection.query.clone(),
            "id",
        ));
        self.relation_filters.push(RelationFilter::new("category", selection));
        self
    }


    pub fn without_category_matching(mut self, request: impl Into<QuerySelection>) -> Self {
        let selection = request.into();
        self.query = self.query.and_filter(Expr::not_in_subquery(
            "category_id",
            <crate::Category as teaql_core::TeaqlEntity>::entity_descriptor(),
            selection.query.clone(),
            "id",
        ));
        self.relation_filters.push(RelationFilter::new("category", selection));
        self
    }


    pub fn have_category(mut self) -> Self {
        self.query = self.query.and_filter(Expr::is_not_null("category_id"));
        self
    }

    pub fn have_no_category(mut self) -> Self {
        self.query = self.query.and_filter(Expr::is_null("category_id"));
        self
    }


    pub fn group_by_category(self) -> Self {
        self.group_by("category_id")
    }

    pub fn group_by_category_as(self, alias: impl Into<String>) -> Self {
        let alias = alias.into();
        let mut request = self.group_by("category_id");
        request.query = request
            .query
            .project_expr(alias, Expr::column("category_id"));
        request
    }

    pub fn group_by_category_with_function(
        self,
        alias: impl Into<String>,
        function: AggregateFunction,
    ) -> Self {
        self.group_by("category_id")
            .aggregate_with_function("category_id", alias, function)
    }

    pub fn group_by_category_with(mut self, request: impl Into<QuerySelection>) -> Self {
        self.query = self.query.group_by("category_id");
        self.query_options.object_group_bys.push(ObjectGroupBy::new(
            "category",
            "category_id",
            request,
        ));
        self
    }

    pub fn group_by_category_with_details(self) -> Self {
        self.group_by_category_with_details_from(crate::Q::categories().unlimited())
    }

    pub fn group_by_category_with_details_from(self, request: impl Into<QuerySelection>) -> Self {
        self.group_by_category_with(request)
    }


    pub fn roll_up_to_category(self) -> Self {
        self.roll_up_to_category_with(crate::Q::categories().unlimited())
    }

    pub fn roll_up_to_category_with(self, request: impl Into<QuerySelection>) -> Self {
        let selection = request.into();
        self.with_category_matching(selection.clone())
            .group_by_category_with(selection)
    }

    pub fn count_category(self) -> Self {
        self.count_category_as("category_count")
    }

    pub fn count_category_as(self, alias: impl Into<String>) -> Self {
        self.aggregate_count_field("category_id", alias)
    }

    pub fn unselect_category(mut self) -> Self {
        self.query.projection.retain(|field| field != "category_id");
        self.query.relations.retain(|relation| relation.name != "category");
        self
    }
    pub fn select_category(mut self) -> Self {
        self.query = self.query.relation("category");
        self
    }

    pub fn select_category_with(mut self, request: impl Into<QuerySelection>) -> Self {
        let selection = request.into();
        self.query = self.query.relation_query("category", selection.clone().into_query());
        self.relation_selections.push(RelationSelection::new("category", selection));
        self
}

    pub fn facet_by_category_as(self, facet_name: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.facet_by_category_as_with_options(facet_name, request, true)
    }

    pub fn facet_by_category_as_with_options(
        mut self,
        facet_name: impl Into<String>,
        request: impl Into<QuerySelection>,
        include_all_facets: bool,
    ) -> Self {
        self.query_options.facets.push(FacetRequest::new(
            facet_name,
            "category",
            request,
            include_all_facets,
        ));
        self
    }
    pub fn have_product_reviews(self) -> Self {
        self.with_product_review_list_matching(SelectQuery::new("ProductReview"))
    }

    pub fn have_no_product_reviews(self) -> Self {
        self.without_product_review_list_matching(SelectQuery::new("ProductReview"))
    }

    pub fn with_product_review_list_matching(mut self, request: impl Into<QuerySelection>) -> Self {
        let selection = request.into();
        self.query = self.query.and_filter(Expr::in_subquery(
            "id",
            <crate::ProductReview as teaql_core::TeaqlEntity>::entity_descriptor(),
            selection.query.clone(),
            "product_id",
        ));
        self.relation_filters.push(RelationFilter::new("product_review_list", selection));
        self
    }

    pub fn without_product_review_list_matching(mut self, request: impl Into<QuerySelection>) -> Self {
        let selection = request.into();
        self.query = self.query.and_filter(Expr::not_in_subquery(
            "id",
            <crate::ProductReview as teaql_core::TeaqlEntity>::entity_descriptor(),
            selection.query.clone(),
            "product_id",
        ));
        self.relation_filters.push(RelationFilter::new("product_review_list", selection));
        self
    }

    pub fn select_product_review_list(mut self) -> Self {
        self.query = self.query.relation("product_review_list");
        self
    }

    pub fn select_product_review_list_with(mut self, request: impl Into<QuerySelection>) -> Self {
        let selection = request.into();
        self.query = self.query.relation_query("product_review_list", selection.clone().into_query());
        self.relation_selections.push(RelationSelection::new("product_review_list", selection));
        self
}

    pub fn have_cart_items(self) -> Self {
        self.with_cart_item_list_matching(SelectQuery::new("CartItem"))
    }

    pub fn have_no_cart_items(self) -> Self {
        self.without_cart_item_list_matching(SelectQuery::new("CartItem"))
    }

    pub fn with_cart_item_list_matching(mut self, request: impl Into<QuerySelection>) -> Self {
        let selection = request.into();
        self.query = self.query.and_filter(Expr::in_subquery(
            "id",
            <crate::CartItem as teaql_core::TeaqlEntity>::entity_descriptor(),
            selection.query.clone(),
            "product_id",
        ));
        self.relation_filters.push(RelationFilter::new("cart_item_list", selection));
        self
    }

    pub fn without_cart_item_list_matching(mut self, request: impl Into<QuerySelection>) -> Self {
        let selection = request.into();
        self.query = self.query.and_filter(Expr::not_in_subquery(
            "id",
            <crate::CartItem as teaql_core::TeaqlEntity>::entity_descriptor(),
            selection.query.clone(),
            "product_id",
        ));
        self.relation_filters.push(RelationFilter::new("cart_item_list", selection));
        self
    }

    pub fn select_cart_item_list(mut self) -> Self {
        self.query = self.query.relation("cart_item_list");
        self
    }

    pub fn select_cart_item_list_with(mut self, request: impl Into<QuerySelection>) -> Self {
        let selection = request.into();
        self.query = self.query.relation_query("cart_item_list", selection.clone().into_query());
        self.relation_selections.push(RelationSelection::new("cart_item_list", selection));
        self
}

    pub fn have_order_items(self) -> Self {
        self.with_order_item_list_matching(SelectQuery::new("OrderItem"))
    }

    pub fn have_no_order_items(self) -> Self {
        self.without_order_item_list_matching(SelectQuery::new("OrderItem"))
    }

    pub fn with_order_item_list_matching(mut self, request: impl Into<QuerySelection>) -> Self {
        let selection = request.into();
        self.query = self.query.and_filter(Expr::in_subquery(
            "id",
            <crate::OrderItem as teaql_core::TeaqlEntity>::entity_descriptor(),
            selection.query.clone(),
            "product_id",
        ));
        self.relation_filters.push(RelationFilter::new("order_item_list", selection));
        self
    }

    pub fn without_order_item_list_matching(mut self, request: impl Into<QuerySelection>) -> Self {
        let selection = request.into();
        self.query = self.query.and_filter(Expr::not_in_subquery(
            "id",
            <crate::OrderItem as teaql_core::TeaqlEntity>::entity_descriptor(),
            selection.query.clone(),
            "product_id",
        ));
        self.relation_filters.push(RelationFilter::new("order_item_list", selection));
        self
    }

    pub fn select_order_item_list(mut self) -> Self {
        self.query = self.query.relation("order_item_list");
        self
    }

    pub fn select_order_item_list_with(mut self, request: impl Into<QuerySelection>) -> Self {
        let selection = request.into();
        self.query = self.query.relation_query("order_item_list", selection.clone().into_query());
        self.relation_selections.push(RelationSelection::new("order_item_list", selection));
        self
}

    pub fn have_inventory_items(self) -> Self {
        self.with_inventory_item_list_matching(SelectQuery::new("InventoryItem"))
    }

    pub fn have_no_inventory_items(self) -> Self {
        self.without_inventory_item_list_matching(SelectQuery::new("InventoryItem"))
    }

    pub fn with_inventory_item_list_matching(mut self, request: impl Into<QuerySelection>) -> Self {
        let selection = request.into();
        self.query = self.query.and_filter(Expr::in_subquery(
            "id",
            <crate::InventoryItem as teaql_core::TeaqlEntity>::entity_descriptor(),
            selection.query.clone(),
            "product_id",
        ));
        self.relation_filters.push(RelationFilter::new("inventory_item_list", selection));
        self
    }

    pub fn without_inventory_item_list_matching(mut self, request: impl Into<QuerySelection>) -> Self {
        let selection = request.into();
        self.query = self.query.and_filter(Expr::not_in_subquery(
            "id",
            <crate::InventoryItem as teaql_core::TeaqlEntity>::entity_descriptor(),
            selection.query.clone(),
            "product_id",
        ));
        self.relation_filters.push(RelationFilter::new("inventory_item_list", selection));
        self
    }

    pub fn select_inventory_item_list(mut self) -> Self {
        self.query = self.query.relation("inventory_item_list");
        self
    }

    pub fn select_inventory_item_list_with(mut self, request: impl Into<QuerySelection>) -> Self {
        let selection = request.into();
        self.query = self.query.relation_query("inventory_item_list", selection.clone().into_query());
        self.relation_selections.push(RelationSelection::new("inventory_item_list", selection));
        self
}

    pub fn have_purchase_order_items(self) -> Self {
        self.with_purchase_order_item_list_matching(SelectQuery::new("PurchaseOrderItem"))
    }

    pub fn have_no_purchase_order_items(self) -> Self {
        self.without_purchase_order_item_list_matching(SelectQuery::new("PurchaseOrderItem"))
    }

    pub fn with_purchase_order_item_list_matching(mut self, request: impl Into<QuerySelection>) -> Self {
        let selection = request.into();
        self.query = self.query.and_filter(Expr::in_subquery(
            "id",
            <crate::PurchaseOrderItem as teaql_core::TeaqlEntity>::entity_descriptor(),
            selection.query.clone(),
            "product_id",
        ));
        self.relation_filters.push(RelationFilter::new("purchase_order_item_list", selection));
        self
    }

    pub fn without_purchase_order_item_list_matching(mut self, request: impl Into<QuerySelection>) -> Self {
        let selection = request.into();
        self.query = self.query.and_filter(Expr::not_in_subquery(
            "id",
            <crate::PurchaseOrderItem as teaql_core::TeaqlEntity>::entity_descriptor(),
            selection.query.clone(),
            "product_id",
        ));
        self.relation_filters.push(RelationFilter::new("purchase_order_item_list", selection));
        self
    }

    pub fn select_purchase_order_item_list(mut self) -> Self {
        self.query = self.query.relation("purchase_order_item_list");
        self
    }

    pub fn select_purchase_order_item_list_with(mut self, request: impl Into<QuerySelection>) -> Self {
        let selection = request.into();
        self.query = self.query.relation_query("purchase_order_item_list", selection.clone().into_query());
        self.relation_selections.push(RelationSelection::new("purchase_order_item_list", selection));
        self
}
    pub fn count_product_reviews(self) -> Self {
        self.count_product_reviews_as("count_product_reviews")
    }

    pub fn count_product_reviews_as(self, alias: impl Into<String>) -> Self {
        self.count_product_reviews_with(alias, crate::Q::product_reviews().unlimited())
    }

    pub fn count_product_reviews_with(mut self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        let selection = request.into();
        self.query_options.relation_aggregates.push(RelationAggregate::new(
            "product_review_list",
            alias,
            selection,
            true,
        ));
        self
    }

    pub fn stats_from_product_reviews(self, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_product_reviews_as("refinements", request)
    }

    pub fn stats_from_product_reviews_as(mut self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        let selection = request.into();
        self.query_options.relation_aggregates.push(RelationAggregate::new(
            "product_review_list",
            alias,
            selection,
            false,
        ));
        self
    }

    pub fn group_by_product_reviews_with_details(self, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_product_reviews(request)
    }


    pub fn min_created_at_of_product_reviews(self) -> Self {
        self.min_created_at_of_product_reviews_as("min_created_at_of_product_reviews", crate::Q::product_reviews().unlimited())
    }

    pub fn min_created_at_of_product_reviews_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_product_reviews_as(alias, request.into().into_query().min("created_at", "min_created_at"))
    }
    pub fn max_created_at_of_product_reviews(self) -> Self {
        self.max_created_at_of_product_reviews_as("max_created_at_of_product_reviews", crate::Q::product_reviews().unlimited())
    }

    pub fn max_created_at_of_product_reviews_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_product_reviews_as(alias, request.into().into_query().max("created_at", "max_created_at"))
    }
    pub fn sum_rating_of_product_reviews(self) -> Self {
        self.sum_rating_of_product_reviews_as("sum_rating_of_product_reviews", crate::Q::product_reviews().unlimited())
    }

    pub fn sum_rating_of_product_reviews_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_product_reviews_as(alias, request.into().into_query().sum("rating", "sum_rating"))
    }
    pub fn min_rating_of_product_reviews(self) -> Self {
        self.min_rating_of_product_reviews_as("min_rating_of_product_reviews", crate::Q::product_reviews().unlimited())
    }

    pub fn min_rating_of_product_reviews_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_product_reviews_as(alias, request.into().into_query().min("rating", "min_rating"))
    }
    pub fn max_rating_of_product_reviews(self) -> Self {
        self.max_rating_of_product_reviews_as("max_rating_of_product_reviews", crate::Q::product_reviews().unlimited())
    }

    pub fn max_rating_of_product_reviews_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_product_reviews_as(alias, request.into().into_query().max("rating", "max_rating"))
    }
    pub fn avg_rating_of_product_reviews(self) -> Self {
        self.avg_rating_of_product_reviews_as("avg_rating_of_product_reviews", crate::Q::product_reviews().unlimited())
    }

    pub fn avg_rating_of_product_reviews_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_product_reviews_as(alias, request.into().into_query().avg("rating", "avg_rating"))
    }
    pub fn standard_deviation_rating_of_product_reviews(self) -> Self {
        self.standard_deviation_rating_of_product_reviews_as("standard_deviation_rating_of_product_reviews", crate::Q::product_reviews().unlimited())
    }

    pub fn standard_deviation_rating_of_product_reviews_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_product_reviews_as(alias, request.into().into_query().stddev("rating", "stdDev_rating"))
    }
    pub fn square_root_of_population_standard_deviation_rating_of_product_reviews(self) -> Self {
        self.square_root_of_population_standard_deviation_rating_of_product_reviews_as("square_root_of_population_standard_deviation_rating_of_product_reviews", crate::Q::product_reviews().unlimited())
    }

    pub fn square_root_of_population_standard_deviation_rating_of_product_reviews_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_product_reviews_as(alias, request.into().into_query().stddev_pop("rating", "stdDevPop_rating"))
    }
    pub fn sample_variance_rating_of_product_reviews(self) -> Self {
        self.sample_variance_rating_of_product_reviews_as("sample_variance_rating_of_product_reviews", crate::Q::product_reviews().unlimited())
    }

    pub fn sample_variance_rating_of_product_reviews_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_product_reviews_as(alias, request.into().into_query().var_samp("rating", "varSamp_rating"))
    }
    pub fn sample_population_variance_rating_of_product_reviews(self) -> Self {
        self.sample_population_variance_rating_of_product_reviews_as("sample_population_variance_rating_of_product_reviews", crate::Q::product_reviews().unlimited())
    }

    pub fn sample_population_variance_rating_of_product_reviews_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_product_reviews_as(alias, request.into().into_query().var_pop("rating", "varPop_rating"))
    }
    pub fn min_create_time_of_product_reviews(self) -> Self {
        self.min_create_time_of_product_reviews_as("min_create_time_of_product_reviews", crate::Q::product_reviews().unlimited())
    }

    pub fn min_create_time_of_product_reviews_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_product_reviews_as(alias, request.into().into_query().min("create_time", "min_create_time"))
    }
    pub fn max_create_time_of_product_reviews(self) -> Self {
        self.max_create_time_of_product_reviews_as("max_create_time_of_product_reviews", crate::Q::product_reviews().unlimited())
    }

    pub fn max_create_time_of_product_reviews_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_product_reviews_as(alias, request.into().into_query().max("create_time", "max_create_time"))
    }
    pub fn min_update_time_of_product_reviews(self) -> Self {
        self.min_update_time_of_product_reviews_as("min_update_time_of_product_reviews", crate::Q::product_reviews().unlimited())
    }

    pub fn min_update_time_of_product_reviews_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_product_reviews_as(alias, request.into().into_query().min("update_time", "min_update_time"))
    }
    pub fn max_update_time_of_product_reviews(self) -> Self {
        self.max_update_time_of_product_reviews_as("max_update_time_of_product_reviews", crate::Q::product_reviews().unlimited())
    }

    pub fn max_update_time_of_product_reviews_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_product_reviews_as(alias, request.into().into_query().max("update_time", "max_update_time"))
    }

    pub fn count_cart_items(self) -> Self {
        self.count_cart_items_as("count_cart_items")
    }

    pub fn count_cart_items_as(self, alias: impl Into<String>) -> Self {
        self.count_cart_items_with(alias, crate::Q::cart_items().unlimited())
    }

    pub fn count_cart_items_with(mut self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        let selection = request.into();
        self.query_options.relation_aggregates.push(RelationAggregate::new(
            "cart_item_list",
            alias,
            selection,
            true,
        ));
        self
    }

    pub fn stats_from_cart_items(self, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_cart_items_as("refinements", request)
    }

    pub fn stats_from_cart_items_as(mut self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        let selection = request.into();
        self.query_options.relation_aggregates.push(RelationAggregate::new(
            "cart_item_list",
            alias,
            selection,
            false,
        ));
        self
    }

    pub fn group_by_cart_items_with_details(self, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_cart_items(request)
    }


    pub fn sum_quantity_of_cart_items(self) -> Self {
        self.sum_quantity_of_cart_items_as("sum_quantity_of_cart_items", crate::Q::cart_items().unlimited())
    }

    pub fn sum_quantity_of_cart_items_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_cart_items_as(alias, request.into().into_query().sum("quantity", "sum_quantity"))
    }
    pub fn min_quantity_of_cart_items(self) -> Self {
        self.min_quantity_of_cart_items_as("min_quantity_of_cart_items", crate::Q::cart_items().unlimited())
    }

    pub fn min_quantity_of_cart_items_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_cart_items_as(alias, request.into().into_query().min("quantity", "min_quantity"))
    }
    pub fn max_quantity_of_cart_items(self) -> Self {
        self.max_quantity_of_cart_items_as("max_quantity_of_cart_items", crate::Q::cart_items().unlimited())
    }

    pub fn max_quantity_of_cart_items_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_cart_items_as(alias, request.into().into_query().max("quantity", "max_quantity"))
    }
    pub fn avg_quantity_of_cart_items(self) -> Self {
        self.avg_quantity_of_cart_items_as("avg_quantity_of_cart_items", crate::Q::cart_items().unlimited())
    }

    pub fn avg_quantity_of_cart_items_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_cart_items_as(alias, request.into().into_query().avg("quantity", "avg_quantity"))
    }
    pub fn standard_deviation_quantity_of_cart_items(self) -> Self {
        self.standard_deviation_quantity_of_cart_items_as("standard_deviation_quantity_of_cart_items", crate::Q::cart_items().unlimited())
    }

    pub fn standard_deviation_quantity_of_cart_items_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_cart_items_as(alias, request.into().into_query().stddev("quantity", "stdDev_quantity"))
    }
    pub fn square_root_of_population_standard_deviation_quantity_of_cart_items(self) -> Self {
        self.square_root_of_population_standard_deviation_quantity_of_cart_items_as("square_root_of_population_standard_deviation_quantity_of_cart_items", crate::Q::cart_items().unlimited())
    }

    pub fn square_root_of_population_standard_deviation_quantity_of_cart_items_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_cart_items_as(alias, request.into().into_query().stddev_pop("quantity", "stdDevPop_quantity"))
    }
    pub fn sample_variance_quantity_of_cart_items(self) -> Self {
        self.sample_variance_quantity_of_cart_items_as("sample_variance_quantity_of_cart_items", crate::Q::cart_items().unlimited())
    }

    pub fn sample_variance_quantity_of_cart_items_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_cart_items_as(alias, request.into().into_query().var_samp("quantity", "varSamp_quantity"))
    }
    pub fn sample_population_variance_quantity_of_cart_items(self) -> Self {
        self.sample_population_variance_quantity_of_cart_items_as("sample_population_variance_quantity_of_cart_items", crate::Q::cart_items().unlimited())
    }

    pub fn sample_population_variance_quantity_of_cart_items_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_cart_items_as(alias, request.into().into_query().var_pop("quantity", "varPop_quantity"))
    }
    pub fn min_create_time_of_cart_items(self) -> Self {
        self.min_create_time_of_cart_items_as("min_create_time_of_cart_items", crate::Q::cart_items().unlimited())
    }

    pub fn min_create_time_of_cart_items_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_cart_items_as(alias, request.into().into_query().min("create_time", "min_create_time"))
    }
    pub fn max_create_time_of_cart_items(self) -> Self {
        self.max_create_time_of_cart_items_as("max_create_time_of_cart_items", crate::Q::cart_items().unlimited())
    }

    pub fn max_create_time_of_cart_items_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_cart_items_as(alias, request.into().into_query().max("create_time", "max_create_time"))
    }
    pub fn min_update_time_of_cart_items(self) -> Self {
        self.min_update_time_of_cart_items_as("min_update_time_of_cart_items", crate::Q::cart_items().unlimited())
    }

    pub fn min_update_time_of_cart_items_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_cart_items_as(alias, request.into().into_query().min("update_time", "min_update_time"))
    }
    pub fn max_update_time_of_cart_items(self) -> Self {
        self.max_update_time_of_cart_items_as("max_update_time_of_cart_items", crate::Q::cart_items().unlimited())
    }

    pub fn max_update_time_of_cart_items_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_cart_items_as(alias, request.into().into_query().max("update_time", "max_update_time"))
    }

    pub fn count_order_items(self) -> Self {
        self.count_order_items_as("count_order_items")
    }

    pub fn count_order_items_as(self, alias: impl Into<String>) -> Self {
        self.count_order_items_with(alias, crate::Q::order_items().unlimited())
    }

    pub fn count_order_items_with(mut self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        let selection = request.into();
        self.query_options.relation_aggregates.push(RelationAggregate::new(
            "order_item_list",
            alias,
            selection,
            true,
        ));
        self
    }

    pub fn stats_from_order_items(self, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_order_items_as("refinements", request)
    }

    pub fn stats_from_order_items_as(mut self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        let selection = request.into();
        self.query_options.relation_aggregates.push(RelationAggregate::new(
            "order_item_list",
            alias,
            selection,
            false,
        ));
        self
    }

    pub fn group_by_order_items_with_details(self, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_order_items(request)
    }


    pub fn sum_unit_price_of_order_items(self) -> Self {
        self.sum_unit_price_of_order_items_as("sum_unit_price_of_order_items", crate::Q::order_items().unlimited())
    }

    pub fn sum_unit_price_of_order_items_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_order_items_as(alias, request.into().into_query().sum("unit_price", "sum_unit_price"))
    }
    pub fn min_unit_price_of_order_items(self) -> Self {
        self.min_unit_price_of_order_items_as("min_unit_price_of_order_items", crate::Q::order_items().unlimited())
    }

    pub fn min_unit_price_of_order_items_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_order_items_as(alias, request.into().into_query().min("unit_price", "min_unit_price"))
    }
    pub fn max_unit_price_of_order_items(self) -> Self {
        self.max_unit_price_of_order_items_as("max_unit_price_of_order_items", crate::Q::order_items().unlimited())
    }

    pub fn max_unit_price_of_order_items_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_order_items_as(alias, request.into().into_query().max("unit_price", "max_unit_price"))
    }
    pub fn avg_unit_price_of_order_items(self) -> Self {
        self.avg_unit_price_of_order_items_as("avg_unit_price_of_order_items", crate::Q::order_items().unlimited())
    }

    pub fn avg_unit_price_of_order_items_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_order_items_as(alias, request.into().into_query().avg("unit_price", "avg_unit_price"))
    }
    pub fn standard_deviation_unit_price_of_order_items(self) -> Self {
        self.standard_deviation_unit_price_of_order_items_as("standard_deviation_unit_price_of_order_items", crate::Q::order_items().unlimited())
    }

    pub fn standard_deviation_unit_price_of_order_items_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_order_items_as(alias, request.into().into_query().stddev("unit_price", "stdDev_unit_price"))
    }
    pub fn square_root_of_population_standard_deviation_unit_price_of_order_items(self) -> Self {
        self.square_root_of_population_standard_deviation_unit_price_of_order_items_as("square_root_of_population_standard_deviation_unit_price_of_order_items", crate::Q::order_items().unlimited())
    }

    pub fn square_root_of_population_standard_deviation_unit_price_of_order_items_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_order_items_as(alias, request.into().into_query().stddev_pop("unit_price", "stdDevPop_unit_price"))
    }
    pub fn sample_variance_unit_price_of_order_items(self) -> Self {
        self.sample_variance_unit_price_of_order_items_as("sample_variance_unit_price_of_order_items", crate::Q::order_items().unlimited())
    }

    pub fn sample_variance_unit_price_of_order_items_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_order_items_as(alias, request.into().into_query().var_samp("unit_price", "varSamp_unit_price"))
    }
    pub fn sample_population_variance_unit_price_of_order_items(self) -> Self {
        self.sample_population_variance_unit_price_of_order_items_as("sample_population_variance_unit_price_of_order_items", crate::Q::order_items().unlimited())
    }

    pub fn sample_population_variance_unit_price_of_order_items_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_order_items_as(alias, request.into().into_query().var_pop("unit_price", "varPop_unit_price"))
    }
    pub fn sum_quantity_of_order_items(self) -> Self {
        self.sum_quantity_of_order_items_as("sum_quantity_of_order_items", crate::Q::order_items().unlimited())
    }

    pub fn sum_quantity_of_order_items_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_order_items_as(alias, request.into().into_query().sum("quantity", "sum_quantity"))
    }
    pub fn min_quantity_of_order_items(self) -> Self {
        self.min_quantity_of_order_items_as("min_quantity_of_order_items", crate::Q::order_items().unlimited())
    }

    pub fn min_quantity_of_order_items_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_order_items_as(alias, request.into().into_query().min("quantity", "min_quantity"))
    }
    pub fn max_quantity_of_order_items(self) -> Self {
        self.max_quantity_of_order_items_as("max_quantity_of_order_items", crate::Q::order_items().unlimited())
    }

    pub fn max_quantity_of_order_items_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_order_items_as(alias, request.into().into_query().max("quantity", "max_quantity"))
    }
    pub fn avg_quantity_of_order_items(self) -> Self {
        self.avg_quantity_of_order_items_as("avg_quantity_of_order_items", crate::Q::order_items().unlimited())
    }

    pub fn avg_quantity_of_order_items_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_order_items_as(alias, request.into().into_query().avg("quantity", "avg_quantity"))
    }
    pub fn standard_deviation_quantity_of_order_items(self) -> Self {
        self.standard_deviation_quantity_of_order_items_as("standard_deviation_quantity_of_order_items", crate::Q::order_items().unlimited())
    }

    pub fn standard_deviation_quantity_of_order_items_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_order_items_as(alias, request.into().into_query().stddev("quantity", "stdDev_quantity"))
    }
    pub fn square_root_of_population_standard_deviation_quantity_of_order_items(self) -> Self {
        self.square_root_of_population_standard_deviation_quantity_of_order_items_as("square_root_of_population_standard_deviation_quantity_of_order_items", crate::Q::order_items().unlimited())
    }

    pub fn square_root_of_population_standard_deviation_quantity_of_order_items_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_order_items_as(alias, request.into().into_query().stddev_pop("quantity", "stdDevPop_quantity"))
    }
    pub fn sample_variance_quantity_of_order_items(self) -> Self {
        self.sample_variance_quantity_of_order_items_as("sample_variance_quantity_of_order_items", crate::Q::order_items().unlimited())
    }

    pub fn sample_variance_quantity_of_order_items_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_order_items_as(alias, request.into().into_query().var_samp("quantity", "varSamp_quantity"))
    }
    pub fn sample_population_variance_quantity_of_order_items(self) -> Self {
        self.sample_population_variance_quantity_of_order_items_as("sample_population_variance_quantity_of_order_items", crate::Q::order_items().unlimited())
    }

    pub fn sample_population_variance_quantity_of_order_items_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_order_items_as(alias, request.into().into_query().var_pop("quantity", "varPop_quantity"))
    }
    pub fn min_create_time_of_order_items(self) -> Self {
        self.min_create_time_of_order_items_as("min_create_time_of_order_items", crate::Q::order_items().unlimited())
    }

    pub fn min_create_time_of_order_items_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_order_items_as(alias, request.into().into_query().min("create_time", "min_create_time"))
    }
    pub fn max_create_time_of_order_items(self) -> Self {
        self.max_create_time_of_order_items_as("max_create_time_of_order_items", crate::Q::order_items().unlimited())
    }

    pub fn max_create_time_of_order_items_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_order_items_as(alias, request.into().into_query().max("create_time", "max_create_time"))
    }
    pub fn min_update_time_of_order_items(self) -> Self {
        self.min_update_time_of_order_items_as("min_update_time_of_order_items", crate::Q::order_items().unlimited())
    }

    pub fn min_update_time_of_order_items_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_order_items_as(alias, request.into().into_query().min("update_time", "min_update_time"))
    }
    pub fn max_update_time_of_order_items(self) -> Self {
        self.max_update_time_of_order_items_as("max_update_time_of_order_items", crate::Q::order_items().unlimited())
    }

    pub fn max_update_time_of_order_items_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_order_items_as(alias, request.into().into_query().max("update_time", "max_update_time"))
    }

    pub fn count_inventory_items(self) -> Self {
        self.count_inventory_items_as("count_inventory_items")
    }

    pub fn count_inventory_items_as(self, alias: impl Into<String>) -> Self {
        self.count_inventory_items_with(alias, crate::Q::inventory_items().unlimited())
    }

    pub fn count_inventory_items_with(mut self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        let selection = request.into();
        self.query_options.relation_aggregates.push(RelationAggregate::new(
            "inventory_item_list",
            alias,
            selection,
            true,
        ));
        self
    }

    pub fn stats_from_inventory_items(self, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_inventory_items_as("refinements", request)
    }

    pub fn stats_from_inventory_items_as(mut self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        let selection = request.into();
        self.query_options.relation_aggregates.push(RelationAggregate::new(
            "inventory_item_list",
            alias,
            selection,
            false,
        ));
        self
    }

    pub fn group_by_inventory_items_with_details(self, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_inventory_items(request)
    }


    pub fn sum_quantity_on_hand_of_inventory_items(self) -> Self {
        self.sum_quantity_on_hand_of_inventory_items_as("sum_quantity_on_hand_of_inventory_items", crate::Q::inventory_items().unlimited())
    }

    pub fn sum_quantity_on_hand_of_inventory_items_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_inventory_items_as(alias, request.into().into_query().sum("quantity_on_hand", "sum_quantity_on_hand"))
    }
    pub fn min_quantity_on_hand_of_inventory_items(self) -> Self {
        self.min_quantity_on_hand_of_inventory_items_as("min_quantity_on_hand_of_inventory_items", crate::Q::inventory_items().unlimited())
    }

    pub fn min_quantity_on_hand_of_inventory_items_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_inventory_items_as(alias, request.into().into_query().min("quantity_on_hand", "min_quantity_on_hand"))
    }
    pub fn max_quantity_on_hand_of_inventory_items(self) -> Self {
        self.max_quantity_on_hand_of_inventory_items_as("max_quantity_on_hand_of_inventory_items", crate::Q::inventory_items().unlimited())
    }

    pub fn max_quantity_on_hand_of_inventory_items_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_inventory_items_as(alias, request.into().into_query().max("quantity_on_hand", "max_quantity_on_hand"))
    }
    pub fn avg_quantity_on_hand_of_inventory_items(self) -> Self {
        self.avg_quantity_on_hand_of_inventory_items_as("avg_quantity_on_hand_of_inventory_items", crate::Q::inventory_items().unlimited())
    }

    pub fn avg_quantity_on_hand_of_inventory_items_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_inventory_items_as(alias, request.into().into_query().avg("quantity_on_hand", "avg_quantity_on_hand"))
    }
    pub fn standard_deviation_quantity_on_hand_of_inventory_items(self) -> Self {
        self.standard_deviation_quantity_on_hand_of_inventory_items_as("standard_deviation_quantity_on_hand_of_inventory_items", crate::Q::inventory_items().unlimited())
    }

    pub fn standard_deviation_quantity_on_hand_of_inventory_items_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_inventory_items_as(alias, request.into().into_query().stddev("quantity_on_hand", "stdDev_quantity_on_hand"))
    }
    pub fn square_root_of_population_standard_deviation_quantity_on_hand_of_inventory_items(self) -> Self {
        self.square_root_of_population_standard_deviation_quantity_on_hand_of_inventory_items_as("square_root_of_population_standard_deviation_quantity_on_hand_of_inventory_items", crate::Q::inventory_items().unlimited())
    }

    pub fn square_root_of_population_standard_deviation_quantity_on_hand_of_inventory_items_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_inventory_items_as(alias, request.into().into_query().stddev_pop("quantity_on_hand", "stdDevPop_quantity_on_hand"))
    }
    pub fn sample_variance_quantity_on_hand_of_inventory_items(self) -> Self {
        self.sample_variance_quantity_on_hand_of_inventory_items_as("sample_variance_quantity_on_hand_of_inventory_items", crate::Q::inventory_items().unlimited())
    }

    pub fn sample_variance_quantity_on_hand_of_inventory_items_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_inventory_items_as(alias, request.into().into_query().var_samp("quantity_on_hand", "varSamp_quantity_on_hand"))
    }
    pub fn sample_population_variance_quantity_on_hand_of_inventory_items(self) -> Self {
        self.sample_population_variance_quantity_on_hand_of_inventory_items_as("sample_population_variance_quantity_on_hand_of_inventory_items", crate::Q::inventory_items().unlimited())
    }

    pub fn sample_population_variance_quantity_on_hand_of_inventory_items_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_inventory_items_as(alias, request.into().into_query().var_pop("quantity_on_hand", "varPop_quantity_on_hand"))
    }
    pub fn sum_reorder_level_of_inventory_items(self) -> Self {
        self.sum_reorder_level_of_inventory_items_as("sum_reorder_level_of_inventory_items", crate::Q::inventory_items().unlimited())
    }

    pub fn sum_reorder_level_of_inventory_items_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_inventory_items_as(alias, request.into().into_query().sum("reorder_level", "sum_reorder_level"))
    }
    pub fn min_reorder_level_of_inventory_items(self) -> Self {
        self.min_reorder_level_of_inventory_items_as("min_reorder_level_of_inventory_items", crate::Q::inventory_items().unlimited())
    }

    pub fn min_reorder_level_of_inventory_items_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_inventory_items_as(alias, request.into().into_query().min("reorder_level", "min_reorder_level"))
    }
    pub fn max_reorder_level_of_inventory_items(self) -> Self {
        self.max_reorder_level_of_inventory_items_as("max_reorder_level_of_inventory_items", crate::Q::inventory_items().unlimited())
    }

    pub fn max_reorder_level_of_inventory_items_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_inventory_items_as(alias, request.into().into_query().max("reorder_level", "max_reorder_level"))
    }
    pub fn avg_reorder_level_of_inventory_items(self) -> Self {
        self.avg_reorder_level_of_inventory_items_as("avg_reorder_level_of_inventory_items", crate::Q::inventory_items().unlimited())
    }

    pub fn avg_reorder_level_of_inventory_items_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_inventory_items_as(alias, request.into().into_query().avg("reorder_level", "avg_reorder_level"))
    }
    pub fn standard_deviation_reorder_level_of_inventory_items(self) -> Self {
        self.standard_deviation_reorder_level_of_inventory_items_as("standard_deviation_reorder_level_of_inventory_items", crate::Q::inventory_items().unlimited())
    }

    pub fn standard_deviation_reorder_level_of_inventory_items_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_inventory_items_as(alias, request.into().into_query().stddev("reorder_level", "stdDev_reorder_level"))
    }
    pub fn square_root_of_population_standard_deviation_reorder_level_of_inventory_items(self) -> Self {
        self.square_root_of_population_standard_deviation_reorder_level_of_inventory_items_as("square_root_of_population_standard_deviation_reorder_level_of_inventory_items", crate::Q::inventory_items().unlimited())
    }

    pub fn square_root_of_population_standard_deviation_reorder_level_of_inventory_items_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_inventory_items_as(alias, request.into().into_query().stddev_pop("reorder_level", "stdDevPop_reorder_level"))
    }
    pub fn sample_variance_reorder_level_of_inventory_items(self) -> Self {
        self.sample_variance_reorder_level_of_inventory_items_as("sample_variance_reorder_level_of_inventory_items", crate::Q::inventory_items().unlimited())
    }

    pub fn sample_variance_reorder_level_of_inventory_items_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_inventory_items_as(alias, request.into().into_query().var_samp("reorder_level", "varSamp_reorder_level"))
    }
    pub fn sample_population_variance_reorder_level_of_inventory_items(self) -> Self {
        self.sample_population_variance_reorder_level_of_inventory_items_as("sample_population_variance_reorder_level_of_inventory_items", crate::Q::inventory_items().unlimited())
    }

    pub fn sample_population_variance_reorder_level_of_inventory_items_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_inventory_items_as(alias, request.into().into_query().var_pop("reorder_level", "varPop_reorder_level"))
    }
    pub fn min_create_time_of_inventory_items(self) -> Self {
        self.min_create_time_of_inventory_items_as("min_create_time_of_inventory_items", crate::Q::inventory_items().unlimited())
    }

    pub fn min_create_time_of_inventory_items_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_inventory_items_as(alias, request.into().into_query().min("create_time", "min_create_time"))
    }
    pub fn max_create_time_of_inventory_items(self) -> Self {
        self.max_create_time_of_inventory_items_as("max_create_time_of_inventory_items", crate::Q::inventory_items().unlimited())
    }

    pub fn max_create_time_of_inventory_items_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_inventory_items_as(alias, request.into().into_query().max("create_time", "max_create_time"))
    }
    pub fn min_update_time_of_inventory_items(self) -> Self {
        self.min_update_time_of_inventory_items_as("min_update_time_of_inventory_items", crate::Q::inventory_items().unlimited())
    }

    pub fn min_update_time_of_inventory_items_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_inventory_items_as(alias, request.into().into_query().min("update_time", "min_update_time"))
    }
    pub fn max_update_time_of_inventory_items(self) -> Self {
        self.max_update_time_of_inventory_items_as("max_update_time_of_inventory_items", crate::Q::inventory_items().unlimited())
    }

    pub fn max_update_time_of_inventory_items_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_inventory_items_as(alias, request.into().into_query().max("update_time", "max_update_time"))
    }

    pub fn count_purchase_order_items(self) -> Self {
        self.count_purchase_order_items_as("count_purchase_order_items")
    }

    pub fn count_purchase_order_items_as(self, alias: impl Into<String>) -> Self {
        self.count_purchase_order_items_with(alias, crate::Q::purchase_order_items().unlimited())
    }

    pub fn count_purchase_order_items_with(mut self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        let selection = request.into();
        self.query_options.relation_aggregates.push(RelationAggregate::new(
            "purchase_order_item_list",
            alias,
            selection,
            true,
        ));
        self
    }

    pub fn stats_from_purchase_order_items(self, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_purchase_order_items_as("refinements", request)
    }

    pub fn stats_from_purchase_order_items_as(mut self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        let selection = request.into();
        self.query_options.relation_aggregates.push(RelationAggregate::new(
            "purchase_order_item_list",
            alias,
            selection,
            false,
        ));
        self
    }

    pub fn group_by_purchase_order_items_with_details(self, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_purchase_order_items(request)
    }


    pub fn sum_quantity_of_purchase_order_items(self) -> Self {
        self.sum_quantity_of_purchase_order_items_as("sum_quantity_of_purchase_order_items", crate::Q::purchase_order_items().unlimited())
    }

    pub fn sum_quantity_of_purchase_order_items_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_purchase_order_items_as(alias, request.into().into_query().sum("quantity", "sum_quantity"))
    }
    pub fn min_quantity_of_purchase_order_items(self) -> Self {
        self.min_quantity_of_purchase_order_items_as("min_quantity_of_purchase_order_items", crate::Q::purchase_order_items().unlimited())
    }

    pub fn min_quantity_of_purchase_order_items_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_purchase_order_items_as(alias, request.into().into_query().min("quantity", "min_quantity"))
    }
    pub fn max_quantity_of_purchase_order_items(self) -> Self {
        self.max_quantity_of_purchase_order_items_as("max_quantity_of_purchase_order_items", crate::Q::purchase_order_items().unlimited())
    }

    pub fn max_quantity_of_purchase_order_items_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_purchase_order_items_as(alias, request.into().into_query().max("quantity", "max_quantity"))
    }
    pub fn avg_quantity_of_purchase_order_items(self) -> Self {
        self.avg_quantity_of_purchase_order_items_as("avg_quantity_of_purchase_order_items", crate::Q::purchase_order_items().unlimited())
    }

    pub fn avg_quantity_of_purchase_order_items_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_purchase_order_items_as(alias, request.into().into_query().avg("quantity", "avg_quantity"))
    }
    pub fn standard_deviation_quantity_of_purchase_order_items(self) -> Self {
        self.standard_deviation_quantity_of_purchase_order_items_as("standard_deviation_quantity_of_purchase_order_items", crate::Q::purchase_order_items().unlimited())
    }

    pub fn standard_deviation_quantity_of_purchase_order_items_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_purchase_order_items_as(alias, request.into().into_query().stddev("quantity", "stdDev_quantity"))
    }
    pub fn square_root_of_population_standard_deviation_quantity_of_purchase_order_items(self) -> Self {
        self.square_root_of_population_standard_deviation_quantity_of_purchase_order_items_as("square_root_of_population_standard_deviation_quantity_of_purchase_order_items", crate::Q::purchase_order_items().unlimited())
    }

    pub fn square_root_of_population_standard_deviation_quantity_of_purchase_order_items_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_purchase_order_items_as(alias, request.into().into_query().stddev_pop("quantity", "stdDevPop_quantity"))
    }
    pub fn sample_variance_quantity_of_purchase_order_items(self) -> Self {
        self.sample_variance_quantity_of_purchase_order_items_as("sample_variance_quantity_of_purchase_order_items", crate::Q::purchase_order_items().unlimited())
    }

    pub fn sample_variance_quantity_of_purchase_order_items_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_purchase_order_items_as(alias, request.into().into_query().var_samp("quantity", "varSamp_quantity"))
    }
    pub fn sample_population_variance_quantity_of_purchase_order_items(self) -> Self {
        self.sample_population_variance_quantity_of_purchase_order_items_as("sample_population_variance_quantity_of_purchase_order_items", crate::Q::purchase_order_items().unlimited())
    }

    pub fn sample_population_variance_quantity_of_purchase_order_items_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_purchase_order_items_as(alias, request.into().into_query().var_pop("quantity", "varPop_quantity"))
    }
    pub fn sum_unit_cost_of_purchase_order_items(self) -> Self {
        self.sum_unit_cost_of_purchase_order_items_as("sum_unit_cost_of_purchase_order_items", crate::Q::purchase_order_items().unlimited())
    }

    pub fn sum_unit_cost_of_purchase_order_items_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_purchase_order_items_as(alias, request.into().into_query().sum("unit_cost", "sum_unit_cost"))
    }
    pub fn min_unit_cost_of_purchase_order_items(self) -> Self {
        self.min_unit_cost_of_purchase_order_items_as("min_unit_cost_of_purchase_order_items", crate::Q::purchase_order_items().unlimited())
    }

    pub fn min_unit_cost_of_purchase_order_items_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_purchase_order_items_as(alias, request.into().into_query().min("unit_cost", "min_unit_cost"))
    }
    pub fn max_unit_cost_of_purchase_order_items(self) -> Self {
        self.max_unit_cost_of_purchase_order_items_as("max_unit_cost_of_purchase_order_items", crate::Q::purchase_order_items().unlimited())
    }

    pub fn max_unit_cost_of_purchase_order_items_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_purchase_order_items_as(alias, request.into().into_query().max("unit_cost", "max_unit_cost"))
    }
    pub fn avg_unit_cost_of_purchase_order_items(self) -> Self {
        self.avg_unit_cost_of_purchase_order_items_as("avg_unit_cost_of_purchase_order_items", crate::Q::purchase_order_items().unlimited())
    }

    pub fn avg_unit_cost_of_purchase_order_items_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_purchase_order_items_as(alias, request.into().into_query().avg("unit_cost", "avg_unit_cost"))
    }
    pub fn standard_deviation_unit_cost_of_purchase_order_items(self) -> Self {
        self.standard_deviation_unit_cost_of_purchase_order_items_as("standard_deviation_unit_cost_of_purchase_order_items", crate::Q::purchase_order_items().unlimited())
    }

    pub fn standard_deviation_unit_cost_of_purchase_order_items_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_purchase_order_items_as(alias, request.into().into_query().stddev("unit_cost", "stdDev_unit_cost"))
    }
    pub fn square_root_of_population_standard_deviation_unit_cost_of_purchase_order_items(self) -> Self {
        self.square_root_of_population_standard_deviation_unit_cost_of_purchase_order_items_as("square_root_of_population_standard_deviation_unit_cost_of_purchase_order_items", crate::Q::purchase_order_items().unlimited())
    }

    pub fn square_root_of_population_standard_deviation_unit_cost_of_purchase_order_items_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_purchase_order_items_as(alias, request.into().into_query().stddev_pop("unit_cost", "stdDevPop_unit_cost"))
    }
    pub fn sample_variance_unit_cost_of_purchase_order_items(self) -> Self {
        self.sample_variance_unit_cost_of_purchase_order_items_as("sample_variance_unit_cost_of_purchase_order_items", crate::Q::purchase_order_items().unlimited())
    }

    pub fn sample_variance_unit_cost_of_purchase_order_items_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_purchase_order_items_as(alias, request.into().into_query().var_samp("unit_cost", "varSamp_unit_cost"))
    }
    pub fn sample_population_variance_unit_cost_of_purchase_order_items(self) -> Self {
        self.sample_population_variance_unit_cost_of_purchase_order_items_as("sample_population_variance_unit_cost_of_purchase_order_items", crate::Q::purchase_order_items().unlimited())
    }

    pub fn sample_population_variance_unit_cost_of_purchase_order_items_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_purchase_order_items_as(alias, request.into().into_query().var_pop("unit_cost", "varPop_unit_cost"))
    }
    pub fn min_create_time_of_purchase_order_items(self) -> Self {
        self.min_create_time_of_purchase_order_items_as("min_create_time_of_purchase_order_items", crate::Q::purchase_order_items().unlimited())
    }

    pub fn min_create_time_of_purchase_order_items_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_purchase_order_items_as(alias, request.into().into_query().min("create_time", "min_create_time"))
    }
    pub fn max_create_time_of_purchase_order_items(self) -> Self {
        self.max_create_time_of_purchase_order_items_as("max_create_time_of_purchase_order_items", crate::Q::purchase_order_items().unlimited())
    }

    pub fn max_create_time_of_purchase_order_items_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_purchase_order_items_as(alias, request.into().into_query().max("create_time", "max_create_time"))
    }
    pub fn min_update_time_of_purchase_order_items(self) -> Self {
        self.min_update_time_of_purchase_order_items_as("min_update_time_of_purchase_order_items", crate::Q::purchase_order_items().unlimited())
    }

    pub fn min_update_time_of_purchase_order_items_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_purchase_order_items_as(alias, request.into().into_query().min("update_time", "min_update_time"))
    }
    pub fn max_update_time_of_purchase_order_items(self) -> Self {
        self.max_update_time_of_purchase_order_items_as("max_update_time_of_purchase_order_items", crate::Q::purchase_order_items().unlimited())
    }

    pub fn max_update_time_of_purchase_order_items_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_purchase_order_items_as(alias, request.into().into_query().max("update_time", "max_update_time"))
    }
}

impl<R> Default for ProductRequest<R> {
    fn default() -> Self {
        Self::new()
    }
}

impl<R> From< ProductRequest<R> > for SelectQuery {
    fn from(request: ProductRequest<R>) -> Self {
        QuerySelection::from(request).into_query()
    }
}

impl<R> From< ProductRequest<R> > for QuerySelection {
    fn from(request: ProductRequest<R>) -> Self {
        Self {
            query: request.query,
            relation_selections: request.relation_selections,
            relation_filters: request.relation_filters,
            child_enhancements: request.child_enhancements,
            query_options: request.query_options,
        }
    }
}


impl<'a, C> crate::request_support::AuditedSave<'a, C> for teaql_core::Audited<crate::Product> 
where C: crate::request_support::TeaqlRepositoryProvider + ?Sized + 'a
{
    type Error = crate::TeaqlDataServiceError<C::ProductRepository<'a>>;
    fn save(self, ctx: &'a C) -> std::pin::Pin<Box<dyn std::future::Future<Output = Result<teaql_runtime::GraphNode, Self::Error>> + '_>> {
        Box::pin(async move {
            teaql_runtime::save_audited_ledger_entity(self, ctx.user_context())
                .await
                .map_err(DataServiceError::Runtime)
        })
    }
}

impl<R: teaql_core::Entity> crate::PurposedQuery<ProductRequest<R>> {
    pub fn new_entity<C>(&self, ctx: &C) -> crate::Product
    where
        C: crate::TeaqlRuntime + ?Sized,
    {
        crate::Product::runtime_new(ctx.user_context().entity_root())
    }

    fn into_inner_with_trace(mut self) -> ProductRequest<R> {
        self.inner.query.trace_chain.push(teaql_core::TraceNode::new(
            self.inner.query.entity.clone(),
            None,
            self.purpose,
        ));
        self.inner
    }

    pub async fn execute_for_page<'a, C>(
        self,
        ctx: &'a C,
        offset: u64,
        limit: u64,
    ) -> Result<teaql_core::SmartList<R>, crate::request_support::TeaqlDataServiceError<C::ProductRepository<'a>>>
    where
        C: crate::request_support::TeaqlRepositoryProvider + ?Sized,
    {
        self.into_inner_with_trace()._execute_for_page(ctx, offset, limit).await
    }

    pub async fn execute_for_exists<'a, C>(
        self,
        ctx: &'a C,
    ) -> Result<bool, crate::request_support::TeaqlDataServiceError<C::ProductRepository<'a>>>
    where
        C: crate::request_support::TeaqlRepositoryProvider + ?Sized,
    {
        self.into_inner_with_trace()._execute_for_exists(ctx).await
    }

    pub async fn execute_for_list<'a, C>(self, ctx: &'a C) -> Result<teaql_core::SmartList<R>, crate::request_support::TeaqlDataServiceError<C::ProductRepository<'a>>>
    where
        C: crate::request_support::TeaqlRepositoryProvider + ?Sized,
    {
        self.into_inner_with_trace()._execute_for_list(ctx).await
    }

    /// Execute query in streaming mode (chunked).
    /// Returns a Vec of StreamChunk, each containing up to chunk_size rows.
    /// Set chunk size via .stream(chunk_size) or .stream_default() on the query.
    pub async fn execute_for_stream<'a, C>(self, ctx: &'a C) -> Result<Vec<teaql_data_service::StreamChunk>, crate::request_support::TeaqlDataServiceError<C::ProductRepository<'a>>>
    where
        C: crate::request_support::TeaqlRepositoryProvider + ?Sized,
    {
        self.into_inner_with_trace()._execute_for_stream(ctx).await
    }

    pub async fn execute_for_first<'a, C>(self, ctx: &'a C) -> Result<Option<R>, crate::request_support::TeaqlDataServiceError<C::ProductRepository<'a>>>
    where
        C: crate::request_support::TeaqlRepositoryProvider + ?Sized,
    {
        self.into_inner_with_trace()._execute_for_first(ctx).await
    }

    pub async fn execute_for_one<'a, C>(self, ctx: &'a C) -> Result<Option<R>, crate::request_support::TeaqlDataServiceError<C::ProductRepository<'a>>>
    where
        C: crate::request_support::TeaqlRepositoryProvider + ?Sized,
    {
        self.into_inner_with_trace()._execute_for_one(ctx).await
    }


    pub async fn execute_for_records<'a, C>(self, ctx: &'a C) -> Result<teaql_core::SmartList<teaql_core::Record>, crate::request_support::TeaqlDataServiceError<C::ProductRepository<'a>>>
    where
        C: crate::request_support::TeaqlRepositoryProvider + ?Sized,
    {
        self.into_inner_with_trace()._execute_for_records(ctx).await
    }

    pub async fn execute_for_record<'a, C>(self, ctx: &'a C) -> Result<Option<teaql_core::Record>, crate::request_support::TeaqlDataServiceError<C::ProductRepository<'a>>>
    where
        C: crate::request_support::TeaqlRepositoryProvider + ?Sized,
    {
        self.into_inner_with_trace()._execute_for_record(ctx).await
    }

    pub async fn execute_for_count<'a, C>(self, ctx: &'a C) -> Result<u64, crate::request_support::TeaqlDataServiceError<C::ProductRepository<'a>>>
    where
        C: crate::request_support::TeaqlRepositoryProvider + ?Sized,
    {
        self.into_inner_with_trace()._execute_for_count(ctx).await
    }
}
