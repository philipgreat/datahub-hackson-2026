use std::marker::PhantomData;

use serde_json::Value as JsonValue;
use teaql_core::{Aggregate, AggregateFunction, EntityDescriptor, Expr, Record, SelectQuery, SmartList};
use teaql_runtime::{DataServiceError, RuntimeError};

use crate::request_support::*;

impl EntityReference for crate::Shipment {
    fn entity_id_value(self) -> teaql_core::Value {
        teaql_core::IdentifiableEntity::id_value(&self)
    }
}

impl EntityReference for &crate::Shipment {
    fn entity_id_value(self) -> teaql_core::Value {
        teaql_core::IdentifiableEntity::id_value(self)
    }
}

// ⛔ AI agents: DO NOT read this file for API discovery. Instead run: cargo teaql --input modeling/MODEL.xml rust-assist-query/shipment
#[derive(Debug)]
pub struct ShipmentRequest<R = crate::Shipment> {
    query: SelectQuery,
    relation_selections: Vec<RelationSelection>,
    relation_filters: Vec<RelationFilter>,
    child_enhancements: Vec<QuerySelection>,
    query_options: QueryOptions,
    marker: PhantomData<R>,
}

impl<R> Clone for ShipmentRequest<R> {
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

impl<R> ShipmentRequest<R> {
    pub(crate) fn new() -> Self {
        Self {
            query: SelectQuery::new("Shipment")
                .project("id")
                .project("version"),
            relation_selections: Vec::new(),
            relation_filters: Vec::new(),
            child_enhancements: Vec::new(),
            query_options: QueryOptions::default(),
            marker: PhantomData,
        }
    }

    pub fn return_type<T>(self) -> ShipmentRequest<T> {
        ShipmentRequest {
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
    ) -> Result<SmartList<R>, TeaqlDataServiceError<C::ShipmentRepository<'a>>>
    where
        C: TeaqlRepositoryProvider + ?Sized,
        R: teaql_core::Entity,
    {
        let repository = ctx
            .shipment_repository()
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
    ) -> Result<Vec<teaql_data_service::StreamChunk>, TeaqlDataServiceError<C::ShipmentRepository<'a>>>
    where
        C: TeaqlRepositoryProvider + ?Sized,
    {
        let repository = ctx
            .shipment_repository()
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
    ) -> Result<Option<R>, TeaqlDataServiceError<C::ShipmentRepository<'a>>>
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
    ) -> Result<Option<R>, TeaqlDataServiceError<C::ShipmentRepository<'a>>>
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
    ) -> Result<SmartList<R>, TeaqlDataServiceError<C::ShipmentRepository<'a>>>
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
    ) -> Result<u64, TeaqlDataServiceError<C::ShipmentRepository<'a>>>
    where
        C: TeaqlRepositoryProvider + ?Sized,
    {
        let repository = ctx
            .shipment_repository()
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
            .ok_or_else(|| DataServiceError::Runtime(RuntimeError::Graph(format!("count result for Shipment is missing or not numeric"))))
    }

    pub(crate) async fn _execute_for_exists<'a, C>(
        self,
        ctx: &'a C,
    ) -> Result<bool, TeaqlDataServiceError<C::ShipmentRepository<'a>>>
    where
        C: TeaqlRepositoryProvider + ?Sized,
    {
        let repository = ctx
            .shipment_repository()
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
    ) -> Result<SmartList<Record>, TeaqlDataServiceError<C::ShipmentRepository<'a>>>
    where
        C: TeaqlRepositoryProvider + ?Sized,
    {
        let repository = ctx
            .shipment_repository()
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
    ) -> Result<Option<Record>, TeaqlDataServiceError<C::ShipmentRepository<'a>>>
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
            "shipped_date" => Some("shipped_date"),
            "carrier" => Some("carrier"),
            "status" => Some("status"),
            "tracking_number" => Some("tracking_number"),
            "create_time" => Some("create_time"),
            "update_time" => Some("update_time"),
            "version" => Some("version"),
            "global_order" | "global_order_id" => Some("global_order_id"),
            "warehouse" | "warehouse_id" => Some("warehouse_id"),
            _ => None,
        }
    }

    fn apply_dynamic_json_chain_filter(self, head: &str, tail: &str, value: &JsonValue) -> Self {
        let _ = (tail, value);
        match head {
            "global_order" => {
                self.with_global_order_matching(
                    crate::Q::global_orders_minimal()
                        .apply_dynamic_json_filter(tail, value),
                )
            }
            "warehouse" => {
                self.with_warehouse_matching(
                    crate::Q::warehouses_minimal()
                        .apply_dynamic_json_filter(tail, value),
                )
            }
            "delivery_list" => {
                self.with_delivery_list_matching(
                    crate::Q::deliveries_minimal()
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
        self.query = self.query.project("shipped_date");
        self.query = self.query.project("carrier");
        self.query = self.query.project("status");
        self.query = self.query.project("tracking_number");
        self.query = self.query.project("create_time");
        self.query = self.query.project("update_time");
        self.query = self.query.project("version");
        self.query = self.query.project("global_order_id");
        self.query = self.query.project("warehouse_id");
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
        request = request.select_global_order();
        request = request.select_warehouse();
        request
    }

    pub fn select_children(self) -> Self {
        let mut request = self.select_all();
        request = request.select_delivery_list();
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


    pub fn select_shipped_date(mut self) -> Self {
        self.query = self.query.project("shipped_date");
        self
    }

    pub fn project_shipped_date(self) -> Self {
        self.select_shipped_date()
    }

    pub fn select_shipped_date_raw(self, raw_sql_segment: impl Into<String>) -> Self {
        self.select_shipped_date_unsafe_raw(UnsafeRawSqlSegment::trusted(raw_sql_segment))
    }

    pub fn select_shipped_date_unsafe_raw(mut self, raw_sql_segment: UnsafeRawSqlSegment) -> Self {
        self.query_options
            .raw_projections
            .push(RawProjection::new("shipped_date", raw_sql_segment));
        self
    }

    pub fn group_by_shipped_date(self) -> Self {
        self.group_by("shipped_date")
    }

    pub fn group_by_shipped_date_as(self, alias: impl Into<String>) -> Self {
        let alias = alias.into();
        let mut request = self.group_by("shipped_date");
        request.query = request
            .query
            .project_expr(alias, Expr::column("shipped_date"));
        request
    }

    pub fn group_by_shipped_date_with_function(
        self,
        alias: impl Into<String>,
        function: AggregateFunction,
    ) -> Self {
        self.group_by("shipped_date")
            .aggregate_with_function("shipped_date", alias, function)
    }

    pub fn count_shipped_date(self) -> Self {
        self.count_shipped_date_as("shipped_date_count")
    }

    pub fn count_shipped_date_as(self, alias: impl Into<String>) -> Self {
        self.aggregate_count_field("shipped_date", alias)
    }

    pub fn sum_shipped_date(self) -> Self {
        self.sum_shipped_date_as("sum_shipped_date")
    }

    pub fn sum_shipped_date_as(self, alias: impl Into<String>) -> Self {
        self.aggregate_sum("shipped_date", alias)
    }

    pub fn avg_shipped_date(self) -> Self {
        self.avg_shipped_date_as("avg_shipped_date")
    }

    pub fn avg_shipped_date_as(self, alias: impl Into<String>) -> Self {
        self.aggregate_avg("shipped_date", alias)
    }

    pub fn min_shipped_date(self) -> Self {
        self.min_shipped_date_as("min_shipped_date")
    }

    pub fn min_shipped_date_as(self, alias: impl Into<String>) -> Self {
        self.aggregate_min("shipped_date", alias)
    }

    pub fn max_shipped_date(self) -> Self {
        self.max_shipped_date_as("max_shipped_date")
    }

    pub fn max_shipped_date_as(self, alias: impl Into<String>) -> Self {
        self.aggregate_max("shipped_date", alias)
    }

    pub fn unselect_shipped_date(mut self) -> Self {
        self.query.projection.retain(|field| field != "shipped_date");
        self.query_options.raw_projections.retain(|projection| projection.property_name != "shipped_date");
        self
    }


    pub fn with_shipped_date(
        mut self,
        operator: FieldOperator,
        values: impl IntoIterator<Item = impl Into<teaql_core::Value>>,
    ) -> Self {
        self.query = self.query.and_filter(field_operator_expr(
            "shipped_date",
            operator,
            values.into_iter().map(Into::into).collect(),
        ));
        self
    }

    pub fn create_shipped_date_criteria(
        operator: FieldOperator,
        values: impl IntoIterator<Item = impl Into<teaql_core::Value>>,
    ) -> Expr {
        field_operator_expr(
            "shipped_date",
            operator,
            values.into_iter().map(Into::into).collect(),
        )
    }

    pub fn with_shipped_date_is(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::eq("shipped_date", value));
        self
    }



    pub fn with_shipped_date_is_not(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::ne("shipped_date", value));
        self
    }

    pub fn with_shipped_date_greater_than(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::gt("shipped_date", value));
        self
    }

    pub fn with_shipped_date_greater_than_or_equal_to(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::gte("shipped_date", value));
        self
    }

    pub fn with_shipped_date_less_than(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::lt("shipped_date", value));
        self
    }

    pub fn with_shipped_date_less_than_or_equal_to(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::lte("shipped_date", value));
        self
    }

    pub fn with_shipped_date_between(
        mut self,
        lower: impl Into<teaql_core::Value>,
        upper: impl Into<teaql_core::Value>,
    ) -> Self {
        self.query = self.query.and_filter(Expr::between("shipped_date", lower, upper));
        self
    }

    pub fn with_shipped_date_between_range<T>(mut self, range: DateRange<T>) -> Self
    where
        T: Into<teaql_core::Value>,
    {
        self.query = self.query.and_filter(Expr::between(
            "shipped_date",
            range.start,
            range.end,
        ));
        self
    }

    pub fn with_shipped_date_in(
        mut self,
        values: impl IntoIterator<Item = impl Into<teaql_core::Value>>,
    ) -> Self {
        self.query = self.query.and_filter(Expr::in_list(
            "shipped_date",
            values.into_iter().map(Into::into),
        ));
        self
    }

    pub fn with_shipped_date_not_in(
        mut self,
        values: impl IntoIterator<Item = impl Into<teaql_core::Value>>,
    ) -> Self {
        self.query = self.query.and_filter(Expr::not_in_list(
            "shipped_date",
            values.into_iter().map(Into::into),
        ));
        self
    }

    pub fn with_shipped_date_before(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::lt("shipped_date", value));
        self
    }

    pub fn with_shipped_date_after(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::gt("shipped_date", value));
        self
    }

    pub fn with_shipped_date_is_unknown(mut self) -> Self {
        self.query = self.query.and_filter(Expr::is_null("shipped_date"));
        self
    }



    pub fn with_shipped_date_is_known(mut self) -> Self {
        self.query = self.query.and_filter(Expr::is_not_null("shipped_date"));
        self
    }


    pub fn order_by_shipped_date_asc(mut self) -> Self {
        self.query = self.query.order_asc("shipped_date");
        self
    }

    pub fn order_by_shipped_date_desc(mut self) -> Self {
        self.query = self.query.order_desc("shipped_date");
        self
    }

    pub fn order_by_shipped_date_asc_using_gbk(mut self) -> Self {
        self.query = self.query.order_gbk_asc("shipped_date");
        self
    }

    pub fn order_by_shipped_date_desc_using_gbk(mut self) -> Self {
        self.query = self.query.order_gbk_desc("shipped_date");
        self
    }


    pub fn select_carrier(mut self) -> Self {
        self.query = self.query.project("carrier");
        self
    }

    pub fn project_carrier(self) -> Self {
        self.select_carrier()
    }

    pub fn select_carrier_raw(self, raw_sql_segment: impl Into<String>) -> Self {
        self.select_carrier_unsafe_raw(UnsafeRawSqlSegment::trusted(raw_sql_segment))
    }

    pub fn select_carrier_unsafe_raw(mut self, raw_sql_segment: UnsafeRawSqlSegment) -> Self {
        self.query_options
            .raw_projections
            .push(RawProjection::new("carrier", raw_sql_segment));
        self
    }

    pub fn group_by_carrier(self) -> Self {
        self.group_by("carrier")
    }

    pub fn group_by_carrier_as(self, alias: impl Into<String>) -> Self {
        let alias = alias.into();
        let mut request = self.group_by("carrier");
        request.query = request
            .query
            .project_expr(alias, Expr::column("carrier"));
        request
    }

    pub fn group_by_carrier_with_function(
        self,
        alias: impl Into<String>,
        function: AggregateFunction,
    ) -> Self {
        self.group_by("carrier")
            .aggregate_with_function("carrier", alias, function)
    }

    pub fn count_carrier(self) -> Self {
        self.count_carrier_as("carrier_count")
    }

    pub fn count_carrier_as(self, alias: impl Into<String>) -> Self {
        self.aggregate_count_field("carrier", alias)
    }

    pub fn sum_carrier(self) -> Self {
        self.sum_carrier_as("sum_carrier")
    }

    pub fn sum_carrier_as(self, alias: impl Into<String>) -> Self {
        self.aggregate_sum("carrier", alias)
    }

    pub fn avg_carrier(self) -> Self {
        self.avg_carrier_as("avg_carrier")
    }

    pub fn avg_carrier_as(self, alias: impl Into<String>) -> Self {
        self.aggregate_avg("carrier", alias)
    }

    pub fn min_carrier(self) -> Self {
        self.min_carrier_as("min_carrier")
    }

    pub fn min_carrier_as(self, alias: impl Into<String>) -> Self {
        self.aggregate_min("carrier", alias)
    }

    pub fn max_carrier(self) -> Self {
        self.max_carrier_as("max_carrier")
    }

    pub fn max_carrier_as(self, alias: impl Into<String>) -> Self {
        self.aggregate_max("carrier", alias)
    }

    pub fn unselect_carrier(mut self) -> Self {
        self.query.projection.retain(|field| field != "carrier");
        self.query_options.raw_projections.retain(|projection| projection.property_name != "carrier");
        self
    }


    pub fn with_carrier(
        mut self,
        operator: FieldOperator,
        values: impl IntoIterator<Item = impl Into<teaql_core::Value>>,
    ) -> Self {
        self.query = self.query.and_filter(field_operator_expr(
            "carrier",
            operator,
            values.into_iter().map(Into::into).collect(),
        ));
        self
    }

    pub fn create_carrier_criteria(
        operator: FieldOperator,
        values: impl IntoIterator<Item = impl Into<teaql_core::Value>>,
    ) -> Expr {
        field_operator_expr(
            "carrier",
            operator,
            values.into_iter().map(Into::into).collect(),
        )
    }

    pub fn with_carrier_is(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::eq("carrier", value));
        self
    }



    pub fn with_carrier_is_not(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::ne("carrier", value));
        self
    }

    pub fn with_carrier_greater_than(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::gt("carrier", value));
        self
    }

    pub fn with_carrier_greater_than_or_equal_to(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::gte("carrier", value));
        self
    }

    pub fn with_carrier_less_than(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::lt("carrier", value));
        self
    }

    pub fn with_carrier_less_than_or_equal_to(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::lte("carrier", value));
        self
    }

    pub fn with_carrier_between(
        mut self,
        lower: impl Into<teaql_core::Value>,
        upper: impl Into<teaql_core::Value>,
    ) -> Self {
        self.query = self.query.and_filter(Expr::between("carrier", lower, upper));
        self
    }

    pub fn with_carrier_between_range<T>(mut self, range: DateRange<T>) -> Self
    where
        T: Into<teaql_core::Value>,
    {
        self.query = self.query.and_filter(Expr::between(
            "carrier",
            range.start,
            range.end,
        ));
        self
    }

    pub fn with_carrier_in(
        mut self,
        values: impl IntoIterator<Item = impl Into<teaql_core::Value>>,
    ) -> Self {
        self.query = self.query.and_filter(Expr::in_list(
            "carrier",
            values.into_iter().map(Into::into),
        ));
        self
    }

    pub fn with_carrier_not_in(
        mut self,
        values: impl IntoIterator<Item = impl Into<teaql_core::Value>>,
    ) -> Self {
        self.query = self.query.and_filter(Expr::not_in_list(
            "carrier",
            values.into_iter().map(Into::into),
        ));
        self
    }

    pub fn with_carrier_containing(mut self, value: impl Into<String>) -> Self {
        self.query = self.query.and_filter(Expr::contain("carrier", value));
        self
    }

    pub fn with_carrier_not_containing(mut self, value: impl Into<String>) -> Self {
        self.query = self.query.and_filter(Expr::not_contain("carrier", value));
        self
    }

    pub fn with_carrier_starting_with(mut self, value: impl Into<String>) -> Self {
        self.query = self.query.and_filter(Expr::begin_with("carrier", value));
        self
    }

    pub fn with_carrier_not_starting_with(mut self, value: impl Into<String>) -> Self {
        self.query = self.query.and_filter(Expr::not_begin_with("carrier", value));
        self
    }

    pub fn with_carrier_ending_with(mut self, value: impl Into<String>) -> Self {
        self.query = self.query.and_filter(Expr::end_with("carrier", value));
        self
    }

    pub fn with_carrier_not_ending_with(mut self, value: impl Into<String>) -> Self {
        self.query = self.query.and_filter(Expr::not_end_with("carrier", value));
        self
    }

    pub fn with_carrier_sounding_like(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::sound_like("carrier", value));
        self
    }
    pub fn with_carrier_before(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::lt("carrier", value));
        self
    }

    pub fn with_carrier_after(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::gt("carrier", value));
        self
    }

    pub fn with_carrier_is_unknown(mut self) -> Self {
        self.query = self.query.and_filter(Expr::is_null("carrier"));
        self
    }



    pub fn with_carrier_is_known(mut self) -> Self {
        self.query = self.query.and_filter(Expr::is_not_null("carrier"));
        self
    }


    pub fn order_by_carrier_asc(mut self) -> Self {
        self.query = self.query.order_asc("carrier");
        self
    }

    pub fn order_by_carrier_desc(mut self) -> Self {
        self.query = self.query.order_desc("carrier");
        self
    }

    pub fn order_by_carrier_asc_using_gbk(mut self) -> Self {
        self.query = self.query.order_gbk_asc("carrier");
        self
    }

    pub fn order_by_carrier_desc_using_gbk(mut self) -> Self {
        self.query = self.query.order_gbk_desc("carrier");
        self
    }


    pub fn select_status(mut self) -> Self {
        self.query = self.query.project("status");
        self
    }

    pub fn project_status(self) -> Self {
        self.select_status()
    }

    pub fn select_status_raw(self, raw_sql_segment: impl Into<String>) -> Self {
        self.select_status_unsafe_raw(UnsafeRawSqlSegment::trusted(raw_sql_segment))
    }

    pub fn select_status_unsafe_raw(mut self, raw_sql_segment: UnsafeRawSqlSegment) -> Self {
        self.query_options
            .raw_projections
            .push(RawProjection::new("status", raw_sql_segment));
        self
    }

    pub fn group_by_status(self) -> Self {
        self.group_by("status")
    }

    pub fn group_by_status_as(self, alias: impl Into<String>) -> Self {
        let alias = alias.into();
        let mut request = self.group_by("status");
        request.query = request
            .query
            .project_expr(alias, Expr::column("status"));
        request
    }

    pub fn group_by_status_with_function(
        self,
        alias: impl Into<String>,
        function: AggregateFunction,
    ) -> Self {
        self.group_by("status")
            .aggregate_with_function("status", alias, function)
    }

    pub fn count_status(self) -> Self {
        self.count_status_as("status_count")
    }

    pub fn count_status_as(self, alias: impl Into<String>) -> Self {
        self.aggregate_count_field("status", alias)
    }

    pub fn sum_status(self) -> Self {
        self.sum_status_as("sum_status")
    }

    pub fn sum_status_as(self, alias: impl Into<String>) -> Self {
        self.aggregate_sum("status", alias)
    }

    pub fn avg_status(self) -> Self {
        self.avg_status_as("avg_status")
    }

    pub fn avg_status_as(self, alias: impl Into<String>) -> Self {
        self.aggregate_avg("status", alias)
    }

    pub fn min_status(self) -> Self {
        self.min_status_as("min_status")
    }

    pub fn min_status_as(self, alias: impl Into<String>) -> Self {
        self.aggregate_min("status", alias)
    }

    pub fn max_status(self) -> Self {
        self.max_status_as("max_status")
    }

    pub fn max_status_as(self, alias: impl Into<String>) -> Self {
        self.aggregate_max("status", alias)
    }

    pub fn unselect_status(mut self) -> Self {
        self.query.projection.retain(|field| field != "status");
        self.query_options.raw_projections.retain(|projection| projection.property_name != "status");
        self
    }


    pub fn with_status(
        mut self,
        operator: FieldOperator,
        values: impl IntoIterator<Item = impl Into<teaql_core::Value>>,
    ) -> Self {
        self.query = self.query.and_filter(field_operator_expr(
            "status",
            operator,
            values.into_iter().map(Into::into).collect(),
        ));
        self
    }

    pub fn create_status_criteria(
        operator: FieldOperator,
        values: impl IntoIterator<Item = impl Into<teaql_core::Value>>,
    ) -> Expr {
        field_operator_expr(
            "status",
            operator,
            values.into_iter().map(Into::into).collect(),
        )
    }

    pub fn with_status_is(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::eq("status", value));
        self
    }



    pub fn with_status_is_not(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::ne("status", value));
        self
    }

    pub fn with_status_greater_than(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::gt("status", value));
        self
    }

    pub fn with_status_greater_than_or_equal_to(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::gte("status", value));
        self
    }

    pub fn with_status_less_than(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::lt("status", value));
        self
    }

    pub fn with_status_less_than_or_equal_to(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::lte("status", value));
        self
    }

    pub fn with_status_between(
        mut self,
        lower: impl Into<teaql_core::Value>,
        upper: impl Into<teaql_core::Value>,
    ) -> Self {
        self.query = self.query.and_filter(Expr::between("status", lower, upper));
        self
    }

    pub fn with_status_between_range<T>(mut self, range: DateRange<T>) -> Self
    where
        T: Into<teaql_core::Value>,
    {
        self.query = self.query.and_filter(Expr::between(
            "status",
            range.start,
            range.end,
        ));
        self
    }

    pub fn with_status_in(
        mut self,
        values: impl IntoIterator<Item = impl Into<teaql_core::Value>>,
    ) -> Self {
        self.query = self.query.and_filter(Expr::in_list(
            "status",
            values.into_iter().map(Into::into),
        ));
        self
    }

    pub fn with_status_not_in(
        mut self,
        values: impl IntoIterator<Item = impl Into<teaql_core::Value>>,
    ) -> Self {
        self.query = self.query.and_filter(Expr::not_in_list(
            "status",
            values.into_iter().map(Into::into),
        ));
        self
    }

    pub fn with_status_containing(mut self, value: impl Into<String>) -> Self {
        self.query = self.query.and_filter(Expr::contain("status", value));
        self
    }

    pub fn with_status_not_containing(mut self, value: impl Into<String>) -> Self {
        self.query = self.query.and_filter(Expr::not_contain("status", value));
        self
    }

    pub fn with_status_starting_with(mut self, value: impl Into<String>) -> Self {
        self.query = self.query.and_filter(Expr::begin_with("status", value));
        self
    }

    pub fn with_status_not_starting_with(mut self, value: impl Into<String>) -> Self {
        self.query = self.query.and_filter(Expr::not_begin_with("status", value));
        self
    }

    pub fn with_status_ending_with(mut self, value: impl Into<String>) -> Self {
        self.query = self.query.and_filter(Expr::end_with("status", value));
        self
    }

    pub fn with_status_not_ending_with(mut self, value: impl Into<String>) -> Self {
        self.query = self.query.and_filter(Expr::not_end_with("status", value));
        self
    }

    pub fn with_status_sounding_like(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::sound_like("status", value));
        self
    }
    pub fn with_status_before(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::lt("status", value));
        self
    }

    pub fn with_status_after(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::gt("status", value));
        self
    }

    pub fn with_status_is_unknown(mut self) -> Self {
        self.query = self.query.and_filter(Expr::is_null("status"));
        self
    }



    pub fn with_status_is_known(mut self) -> Self {
        self.query = self.query.and_filter(Expr::is_not_null("status"));
        self
    }


    pub fn order_by_status_asc(mut self) -> Self {
        self.query = self.query.order_asc("status");
        self
    }

    pub fn order_by_status_desc(mut self) -> Self {
        self.query = self.query.order_desc("status");
        self
    }

    pub fn order_by_status_asc_using_gbk(mut self) -> Self {
        self.query = self.query.order_gbk_asc("status");
        self
    }

    pub fn order_by_status_desc_using_gbk(mut self) -> Self {
        self.query = self.query.order_gbk_desc("status");
        self
    }


    pub fn select_tracking_number(mut self) -> Self {
        self.query = self.query.project("tracking_number");
        self
    }

    pub fn project_tracking_number(self) -> Self {
        self.select_tracking_number()
    }

    pub fn select_tracking_number_raw(self, raw_sql_segment: impl Into<String>) -> Self {
        self.select_tracking_number_unsafe_raw(UnsafeRawSqlSegment::trusted(raw_sql_segment))
    }

    pub fn select_tracking_number_unsafe_raw(mut self, raw_sql_segment: UnsafeRawSqlSegment) -> Self {
        self.query_options
            .raw_projections
            .push(RawProjection::new("tracking_number", raw_sql_segment));
        self
    }

    pub fn group_by_tracking_number(self) -> Self {
        self.group_by("tracking_number")
    }

    pub fn group_by_tracking_number_as(self, alias: impl Into<String>) -> Self {
        let alias = alias.into();
        let mut request = self.group_by("tracking_number");
        request.query = request
            .query
            .project_expr(alias, Expr::column("tracking_number"));
        request
    }

    pub fn group_by_tracking_number_with_function(
        self,
        alias: impl Into<String>,
        function: AggregateFunction,
    ) -> Self {
        self.group_by("tracking_number")
            .aggregate_with_function("tracking_number", alias, function)
    }

    pub fn count_tracking_number(self) -> Self {
        self.count_tracking_number_as("tracking_number_count")
    }

    pub fn count_tracking_number_as(self, alias: impl Into<String>) -> Self {
        self.aggregate_count_field("tracking_number", alias)
    }

    pub fn sum_tracking_number(self) -> Self {
        self.sum_tracking_number_as("sum_tracking_number")
    }

    pub fn sum_tracking_number_as(self, alias: impl Into<String>) -> Self {
        self.aggregate_sum("tracking_number", alias)
    }

    pub fn avg_tracking_number(self) -> Self {
        self.avg_tracking_number_as("avg_tracking_number")
    }

    pub fn avg_tracking_number_as(self, alias: impl Into<String>) -> Self {
        self.aggregate_avg("tracking_number", alias)
    }

    pub fn min_tracking_number(self) -> Self {
        self.min_tracking_number_as("min_tracking_number")
    }

    pub fn min_tracking_number_as(self, alias: impl Into<String>) -> Self {
        self.aggregate_min("tracking_number", alias)
    }

    pub fn max_tracking_number(self) -> Self {
        self.max_tracking_number_as("max_tracking_number")
    }

    pub fn max_tracking_number_as(self, alias: impl Into<String>) -> Self {
        self.aggregate_max("tracking_number", alias)
    }

    pub fn unselect_tracking_number(mut self) -> Self {
        self.query.projection.retain(|field| field != "tracking_number");
        self.query_options.raw_projections.retain(|projection| projection.property_name != "tracking_number");
        self
    }


    pub fn with_tracking_number(
        mut self,
        operator: FieldOperator,
        values: impl IntoIterator<Item = impl Into<teaql_core::Value>>,
    ) -> Self {
        self.query = self.query.and_filter(field_operator_expr(
            "tracking_number",
            operator,
            values.into_iter().map(Into::into).collect(),
        ));
        self
    }

    pub fn create_tracking_number_criteria(
        operator: FieldOperator,
        values: impl IntoIterator<Item = impl Into<teaql_core::Value>>,
    ) -> Expr {
        field_operator_expr(
            "tracking_number",
            operator,
            values.into_iter().map(Into::into).collect(),
        )
    }

    pub fn with_tracking_number_is(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::eq("tracking_number", value));
        self
    }



    pub fn with_tracking_number_is_not(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::ne("tracking_number", value));
        self
    }

    pub fn with_tracking_number_greater_than(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::gt("tracking_number", value));
        self
    }

    pub fn with_tracking_number_greater_than_or_equal_to(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::gte("tracking_number", value));
        self
    }

    pub fn with_tracking_number_less_than(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::lt("tracking_number", value));
        self
    }

    pub fn with_tracking_number_less_than_or_equal_to(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::lte("tracking_number", value));
        self
    }

    pub fn with_tracking_number_between(
        mut self,
        lower: impl Into<teaql_core::Value>,
        upper: impl Into<teaql_core::Value>,
    ) -> Self {
        self.query = self.query.and_filter(Expr::between("tracking_number", lower, upper));
        self
    }

    pub fn with_tracking_number_between_range<T>(mut self, range: DateRange<T>) -> Self
    where
        T: Into<teaql_core::Value>,
    {
        self.query = self.query.and_filter(Expr::between(
            "tracking_number",
            range.start,
            range.end,
        ));
        self
    }

    pub fn with_tracking_number_in(
        mut self,
        values: impl IntoIterator<Item = impl Into<teaql_core::Value>>,
    ) -> Self {
        self.query = self.query.and_filter(Expr::in_list(
            "tracking_number",
            values.into_iter().map(Into::into),
        ));
        self
    }

    pub fn with_tracking_number_not_in(
        mut self,
        values: impl IntoIterator<Item = impl Into<teaql_core::Value>>,
    ) -> Self {
        self.query = self.query.and_filter(Expr::not_in_list(
            "tracking_number",
            values.into_iter().map(Into::into),
        ));
        self
    }

    pub fn with_tracking_number_containing(mut self, value: impl Into<String>) -> Self {
        self.query = self.query.and_filter(Expr::contain("tracking_number", value));
        self
    }

    pub fn with_tracking_number_not_containing(mut self, value: impl Into<String>) -> Self {
        self.query = self.query.and_filter(Expr::not_contain("tracking_number", value));
        self
    }

    pub fn with_tracking_number_starting_with(mut self, value: impl Into<String>) -> Self {
        self.query = self.query.and_filter(Expr::begin_with("tracking_number", value));
        self
    }

    pub fn with_tracking_number_not_starting_with(mut self, value: impl Into<String>) -> Self {
        self.query = self.query.and_filter(Expr::not_begin_with("tracking_number", value));
        self
    }

    pub fn with_tracking_number_ending_with(mut self, value: impl Into<String>) -> Self {
        self.query = self.query.and_filter(Expr::end_with("tracking_number", value));
        self
    }

    pub fn with_tracking_number_not_ending_with(mut self, value: impl Into<String>) -> Self {
        self.query = self.query.and_filter(Expr::not_end_with("tracking_number", value));
        self
    }

    pub fn with_tracking_number_sounding_like(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::sound_like("tracking_number", value));
        self
    }
    pub fn with_tracking_number_before(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::lt("tracking_number", value));
        self
    }

    pub fn with_tracking_number_after(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::gt("tracking_number", value));
        self
    }

    pub fn with_tracking_number_is_unknown(mut self) -> Self {
        self.query = self.query.and_filter(Expr::is_null("tracking_number"));
        self
    }



    pub fn with_tracking_number_is_known(mut self) -> Self {
        self.query = self.query.and_filter(Expr::is_not_null("tracking_number"));
        self
    }


    pub fn order_by_tracking_number_asc(mut self) -> Self {
        self.query = self.query.order_asc("tracking_number");
        self
    }

    pub fn order_by_tracking_number_desc(mut self) -> Self {
        self.query = self.query.order_desc("tracking_number");
        self
    }

    pub fn order_by_tracking_number_asc_using_gbk(mut self) -> Self {
        self.query = self.query.order_gbk_asc("tracking_number");
        self
    }

    pub fn order_by_tracking_number_desc_using_gbk(mut self) -> Self {
        self.query = self.query.order_gbk_desc("tracking_number");
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
    pub fn filter_by_global_order(mut self, value: impl EntityReference) -> Self {
        self.query = self.query.and_filter(Expr::eq("global_order_id", value.entity_id_value()));
        self
    }

    pub fn with_global_order_matching(mut self, request: impl Into<QuerySelection>) -> Self {
        let selection = request.into();
        self.query = self.query.and_filter(Expr::in_subquery(
            "global_order_id",
            <crate::GlobalOrder as teaql_core::TeaqlEntity>::entity_descriptor(),
            selection.query.clone(),
            "id",
        ));
        self.relation_filters.push(RelationFilter::new("global_order", selection));
        self
    }


    pub fn without_global_order_matching(mut self, request: impl Into<QuerySelection>) -> Self {
        let selection = request.into();
        self.query = self.query.and_filter(Expr::not_in_subquery(
            "global_order_id",
            <crate::GlobalOrder as teaql_core::TeaqlEntity>::entity_descriptor(),
            selection.query.clone(),
            "id",
        ));
        self.relation_filters.push(RelationFilter::new("global_order", selection));
        self
    }


    pub fn have_global_order(mut self) -> Self {
        self.query = self.query.and_filter(Expr::is_not_null("global_order_id"));
        self
    }

    pub fn have_no_global_order(mut self) -> Self {
        self.query = self.query.and_filter(Expr::is_null("global_order_id"));
        self
    }


    pub fn group_by_global_order(self) -> Self {
        self.group_by("global_order_id")
    }

    pub fn group_by_global_order_as(self, alias: impl Into<String>) -> Self {
        let alias = alias.into();
        let mut request = self.group_by("global_order_id");
        request.query = request
            .query
            .project_expr(alias, Expr::column("global_order_id"));
        request
    }

    pub fn group_by_global_order_with_function(
        self,
        alias: impl Into<String>,
        function: AggregateFunction,
    ) -> Self {
        self.group_by("global_order_id")
            .aggregate_with_function("global_order_id", alias, function)
    }

    pub fn group_by_global_order_with(mut self, request: impl Into<QuerySelection>) -> Self {
        self.query = self.query.group_by("global_order_id");
        self.query_options.object_group_bys.push(ObjectGroupBy::new(
            "global_order",
            "global_order_id",
            request,
        ));
        self
    }

    pub fn group_by_global_order_with_details(self) -> Self {
        self.group_by_global_order_with_details_from(crate::Q::global_orders().unlimited())
    }

    pub fn group_by_global_order_with_details_from(self, request: impl Into<QuerySelection>) -> Self {
        self.group_by_global_order_with(request)
    }


    pub fn roll_up_to_global_order(self) -> Self {
        self.roll_up_to_global_order_with(crate::Q::global_orders().unlimited())
    }

    pub fn roll_up_to_global_order_with(self, request: impl Into<QuerySelection>) -> Self {
        let selection = request.into();
        self.with_global_order_matching(selection.clone())
            .group_by_global_order_with(selection)
    }

    pub fn count_global_order(self) -> Self {
        self.count_global_order_as("global_order_count")
    }

    pub fn count_global_order_as(self, alias: impl Into<String>) -> Self {
        self.aggregate_count_field("global_order_id", alias)
    }

    pub fn unselect_global_order(mut self) -> Self {
        self.query.projection.retain(|field| field != "global_order_id");
        self.query.relations.retain(|relation| relation.name != "global_order");
        self
    }


    pub fn filter_by_warehouse(mut self, value: impl EntityReference) -> Self {
        self.query = self.query.and_filter(Expr::eq("warehouse_id", value.entity_id_value()));
        self
    }

    pub fn with_warehouse_matching(mut self, request: impl Into<QuerySelection>) -> Self {
        let selection = request.into();
        self.query = self.query.and_filter(Expr::in_subquery(
            "warehouse_id",
            <crate::Warehouse as teaql_core::TeaqlEntity>::entity_descriptor(),
            selection.query.clone(),
            "id",
        ));
        self.relation_filters.push(RelationFilter::new("warehouse", selection));
        self
    }


    pub fn without_warehouse_matching(mut self, request: impl Into<QuerySelection>) -> Self {
        let selection = request.into();
        self.query = self.query.and_filter(Expr::not_in_subquery(
            "warehouse_id",
            <crate::Warehouse as teaql_core::TeaqlEntity>::entity_descriptor(),
            selection.query.clone(),
            "id",
        ));
        self.relation_filters.push(RelationFilter::new("warehouse", selection));
        self
    }


    pub fn have_warehouse(mut self) -> Self {
        self.query = self.query.and_filter(Expr::is_not_null("warehouse_id"));
        self
    }

    pub fn have_no_warehouse(mut self) -> Self {
        self.query = self.query.and_filter(Expr::is_null("warehouse_id"));
        self
    }


    pub fn group_by_warehouse(self) -> Self {
        self.group_by("warehouse_id")
    }

    pub fn group_by_warehouse_as(self, alias: impl Into<String>) -> Self {
        let alias = alias.into();
        let mut request = self.group_by("warehouse_id");
        request.query = request
            .query
            .project_expr(alias, Expr::column("warehouse_id"));
        request
    }

    pub fn group_by_warehouse_with_function(
        self,
        alias: impl Into<String>,
        function: AggregateFunction,
    ) -> Self {
        self.group_by("warehouse_id")
            .aggregate_with_function("warehouse_id", alias, function)
    }

    pub fn group_by_warehouse_with(mut self, request: impl Into<QuerySelection>) -> Self {
        self.query = self.query.group_by("warehouse_id");
        self.query_options.object_group_bys.push(ObjectGroupBy::new(
            "warehouse",
            "warehouse_id",
            request,
        ));
        self
    }

    pub fn group_by_warehouse_with_details(self) -> Self {
        self.group_by_warehouse_with_details_from(crate::Q::warehouses().unlimited())
    }

    pub fn group_by_warehouse_with_details_from(self, request: impl Into<QuerySelection>) -> Self {
        self.group_by_warehouse_with(request)
    }


    pub fn roll_up_to_warehouse(self) -> Self {
        self.roll_up_to_warehouse_with(crate::Q::warehouses().unlimited())
    }

    pub fn roll_up_to_warehouse_with(self, request: impl Into<QuerySelection>) -> Self {
        let selection = request.into();
        self.with_warehouse_matching(selection.clone())
            .group_by_warehouse_with(selection)
    }

    pub fn count_warehouse(self) -> Self {
        self.count_warehouse_as("warehouse_count")
    }

    pub fn count_warehouse_as(self, alias: impl Into<String>) -> Self {
        self.aggregate_count_field("warehouse_id", alias)
    }

    pub fn unselect_warehouse(mut self) -> Self {
        self.query.projection.retain(|field| field != "warehouse_id");
        self.query.relations.retain(|relation| relation.name != "warehouse");
        self
    }
    pub fn select_global_order(mut self) -> Self {
        self.query = self.query.relation("global_order");
        self
    }

    pub fn select_global_order_with(mut self, request: impl Into<QuerySelection>) -> Self {
        let selection = request.into();
        self.query = self.query.relation_query("global_order", selection.clone().into_query());
        self.relation_selections.push(RelationSelection::new("global_order", selection));
        self
}

    pub fn facet_by_global_order_as(self, facet_name: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.facet_by_global_order_as_with_options(facet_name, request, true)
    }

    pub fn facet_by_global_order_as_with_options(
        mut self,
        facet_name: impl Into<String>,
        request: impl Into<QuerySelection>,
        include_all_facets: bool,
    ) -> Self {
        self.query_options.facets.push(FacetRequest::new(
            facet_name,
            "global_order",
            request,
            include_all_facets,
        ));
        self
    }

    pub fn select_warehouse(mut self) -> Self {
        self.query = self.query.relation("warehouse");
        self
    }

    pub fn select_warehouse_with(mut self, request: impl Into<QuerySelection>) -> Self {
        let selection = request.into();
        self.query = self.query.relation_query("warehouse", selection.clone().into_query());
        self.relation_selections.push(RelationSelection::new("warehouse", selection));
        self
}

    pub fn facet_by_warehouse_as(self, facet_name: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.facet_by_warehouse_as_with_options(facet_name, request, true)
    }

    pub fn facet_by_warehouse_as_with_options(
        mut self,
        facet_name: impl Into<String>,
        request: impl Into<QuerySelection>,
        include_all_facets: bool,
    ) -> Self {
        self.query_options.facets.push(FacetRequest::new(
            facet_name,
            "warehouse",
            request,
            include_all_facets,
        ));
        self
    }
    pub fn have_deliveries(self) -> Self {
        self.with_delivery_list_matching(SelectQuery::new("Delivery"))
    }

    pub fn have_no_deliveries(self) -> Self {
        self.without_delivery_list_matching(SelectQuery::new("Delivery"))
    }

    pub fn with_delivery_list_matching(mut self, request: impl Into<QuerySelection>) -> Self {
        let selection = request.into();
        self.query = self.query.and_filter(Expr::in_subquery(
            "id",
            <crate::Delivery as teaql_core::TeaqlEntity>::entity_descriptor(),
            selection.query.clone(),
            "shipment_id",
        ));
        self.relation_filters.push(RelationFilter::new("delivery_list", selection));
        self
    }

    pub fn without_delivery_list_matching(mut self, request: impl Into<QuerySelection>) -> Self {
        let selection = request.into();
        self.query = self.query.and_filter(Expr::not_in_subquery(
            "id",
            <crate::Delivery as teaql_core::TeaqlEntity>::entity_descriptor(),
            selection.query.clone(),
            "shipment_id",
        ));
        self.relation_filters.push(RelationFilter::new("delivery_list", selection));
        self
    }

    pub fn select_delivery_list(mut self) -> Self {
        self.query = self.query.relation("delivery_list");
        self
    }

    pub fn select_delivery_list_with(mut self, request: impl Into<QuerySelection>) -> Self {
        let selection = request.into();
        self.query = self.query.relation_query("delivery_list", selection.clone().into_query());
        self.relation_selections.push(RelationSelection::new("delivery_list", selection));
        self
}
    pub fn count_deliveries(self) -> Self {
        self.count_deliveries_as("count_deliveries")
    }

    pub fn count_deliveries_as(self, alias: impl Into<String>) -> Self {
        self.count_deliveries_with(alias, crate::Q::deliveries().unlimited())
    }

    pub fn count_deliveries_with(mut self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        let selection = request.into();
        self.query_options.relation_aggregates.push(RelationAggregate::new(
            "delivery_list",
            alias,
            selection,
            true,
        ));
        self
    }

    pub fn stats_from_deliveries(self, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_deliveries_as("refinements", request)
    }

    pub fn stats_from_deliveries_as(mut self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        let selection = request.into();
        self.query_options.relation_aggregates.push(RelationAggregate::new(
            "delivery_list",
            alias,
            selection,
            false,
        ));
        self
    }

    pub fn group_by_deliveries_with_details(self, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_deliveries(request)
    }


    pub fn min_delivery_date_of_deliveries(self) -> Self {
        self.min_delivery_date_of_deliveries_as("min_delivery_date_of_deliveries", crate::Q::deliveries().unlimited())
    }

    pub fn min_delivery_date_of_deliveries_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_deliveries_as(alias, request.into().into_query().min("delivery_date", "min_delivery_date"))
    }
    pub fn max_delivery_date_of_deliveries(self) -> Self {
        self.max_delivery_date_of_deliveries_as("max_delivery_date_of_deliveries", crate::Q::deliveries().unlimited())
    }

    pub fn max_delivery_date_of_deliveries_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_deliveries_as(alias, request.into().into_query().max("delivery_date", "max_delivery_date"))
    }
    pub fn min_create_time_of_deliveries(self) -> Self {
        self.min_create_time_of_deliveries_as("min_create_time_of_deliveries", crate::Q::deliveries().unlimited())
    }

    pub fn min_create_time_of_deliveries_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_deliveries_as(alias, request.into().into_query().min("create_time", "min_create_time"))
    }
    pub fn max_create_time_of_deliveries(self) -> Self {
        self.max_create_time_of_deliveries_as("max_create_time_of_deliveries", crate::Q::deliveries().unlimited())
    }

    pub fn max_create_time_of_deliveries_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_deliveries_as(alias, request.into().into_query().max("create_time", "max_create_time"))
    }
    pub fn min_update_time_of_deliveries(self) -> Self {
        self.min_update_time_of_deliveries_as("min_update_time_of_deliveries", crate::Q::deliveries().unlimited())
    }

    pub fn min_update_time_of_deliveries_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_deliveries_as(alias, request.into().into_query().min("update_time", "min_update_time"))
    }
    pub fn max_update_time_of_deliveries(self) -> Self {
        self.max_update_time_of_deliveries_as("max_update_time_of_deliveries", crate::Q::deliveries().unlimited())
    }

    pub fn max_update_time_of_deliveries_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_deliveries_as(alias, request.into().into_query().max("update_time", "max_update_time"))
    }
}

impl<R> Default for ShipmentRequest<R> {
    fn default() -> Self {
        Self::new()
    }
}

impl<R> From< ShipmentRequest<R> > for SelectQuery {
    fn from(request: ShipmentRequest<R>) -> Self {
        QuerySelection::from(request).into_query()
    }
}

impl<R> From< ShipmentRequest<R> > for QuerySelection {
    fn from(request: ShipmentRequest<R>) -> Self {
        Self {
            query: request.query,
            relation_selections: request.relation_selections,
            relation_filters: request.relation_filters,
            child_enhancements: request.child_enhancements,
            query_options: request.query_options,
        }
    }
}


impl<'a, C> crate::request_support::AuditedSave<'a, C> for teaql_core::Audited<crate::Shipment> 
where C: crate::request_support::TeaqlRepositoryProvider + ?Sized + 'a
{
    type Error = crate::TeaqlDataServiceError<C::ShipmentRepository<'a>>;
    fn save(self, ctx: &'a C) -> std::pin::Pin<Box<dyn std::future::Future<Output = Result<teaql_runtime::GraphNode, Self::Error>> + '_>> {
        Box::pin(async move {
            teaql_runtime::save_audited_ledger_entity(self, ctx.user_context())
                .await
                .map_err(DataServiceError::Runtime)
        })
    }
}

impl<R: teaql_core::Entity> crate::PurposedQuery<ShipmentRequest<R>> {
    pub fn new_entity<C>(&self, ctx: &C) -> crate::Shipment
    where
        C: crate::TeaqlRuntime + ?Sized,
    {
        crate::Shipment::runtime_new(ctx.user_context().entity_root())
    }

    fn into_inner_with_trace(mut self) -> ShipmentRequest<R> {
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
    ) -> Result<teaql_core::SmartList<R>, crate::request_support::TeaqlDataServiceError<C::ShipmentRepository<'a>>>
    where
        C: crate::request_support::TeaqlRepositoryProvider + ?Sized,
    {
        self.into_inner_with_trace()._execute_for_page(ctx, offset, limit).await
    }

    pub async fn execute_for_exists<'a, C>(
        self,
        ctx: &'a C,
    ) -> Result<bool, crate::request_support::TeaqlDataServiceError<C::ShipmentRepository<'a>>>
    where
        C: crate::request_support::TeaqlRepositoryProvider + ?Sized,
    {
        self.into_inner_with_trace()._execute_for_exists(ctx).await
    }

    pub async fn execute_for_list<'a, C>(self, ctx: &'a C) -> Result<teaql_core::SmartList<R>, crate::request_support::TeaqlDataServiceError<C::ShipmentRepository<'a>>>
    where
        C: crate::request_support::TeaqlRepositoryProvider + ?Sized,
    {
        self.into_inner_with_trace()._execute_for_list(ctx).await
    }

    /// Execute query in streaming mode (chunked).
    /// Returns a Vec of StreamChunk, each containing up to chunk_size rows.
    /// Set chunk size via .stream(chunk_size) or .stream_default() on the query.
    pub async fn execute_for_stream<'a, C>(self, ctx: &'a C) -> Result<Vec<teaql_data_service::StreamChunk>, crate::request_support::TeaqlDataServiceError<C::ShipmentRepository<'a>>>
    where
        C: crate::request_support::TeaqlRepositoryProvider + ?Sized,
    {
        self.into_inner_with_trace()._execute_for_stream(ctx).await
    }

    pub async fn execute_for_first<'a, C>(self, ctx: &'a C) -> Result<Option<R>, crate::request_support::TeaqlDataServiceError<C::ShipmentRepository<'a>>>
    where
        C: crate::request_support::TeaqlRepositoryProvider + ?Sized,
    {
        self.into_inner_with_trace()._execute_for_first(ctx).await
    }

    pub async fn execute_for_one<'a, C>(self, ctx: &'a C) -> Result<Option<R>, crate::request_support::TeaqlDataServiceError<C::ShipmentRepository<'a>>>
    where
        C: crate::request_support::TeaqlRepositoryProvider + ?Sized,
    {
        self.into_inner_with_trace()._execute_for_one(ctx).await
    }


    pub async fn execute_for_records<'a, C>(self, ctx: &'a C) -> Result<teaql_core::SmartList<teaql_core::Record>, crate::request_support::TeaqlDataServiceError<C::ShipmentRepository<'a>>>
    where
        C: crate::request_support::TeaqlRepositoryProvider + ?Sized,
    {
        self.into_inner_with_trace()._execute_for_records(ctx).await
    }

    pub async fn execute_for_record<'a, C>(self, ctx: &'a C) -> Result<Option<teaql_core::Record>, crate::request_support::TeaqlDataServiceError<C::ShipmentRepository<'a>>>
    where
        C: crate::request_support::TeaqlRepositoryProvider + ?Sized,
    {
        self.into_inner_with_trace()._execute_for_record(ctx).await
    }

    pub async fn execute_for_count<'a, C>(self, ctx: &'a C) -> Result<u64, crate::request_support::TeaqlDataServiceError<C::ShipmentRepository<'a>>>
    where
        C: crate::request_support::TeaqlRepositoryProvider + ?Sized,
    {
        self.into_inner_with_trace()._execute_for_count(ctx).await
    }
}
