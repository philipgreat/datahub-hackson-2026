use std::marker::PhantomData;

use serde_json::Value as JsonValue;
use teaql_core::{Aggregate, AggregateFunction, EntityDescriptor, Expr, Record, SelectQuery, SmartList};
use teaql_runtime::{DataServiceError, RuntimeError};

use crate::request_support::*;

impl EntityReference for crate::Warehouse {
    fn entity_id_value(self) -> teaql_core::Value {
        teaql_core::IdentifiableEntity::id_value(&self)
    }
}

impl EntityReference for &crate::Warehouse {
    fn entity_id_value(self) -> teaql_core::Value {
        teaql_core::IdentifiableEntity::id_value(self)
    }
}

// ⛔ AI agents: DO NOT read this file for API discovery. Instead run: cargo teaql --input modeling/MODEL.xml rust-assist-query/warehouse
#[derive(Debug)]
pub struct WarehouseRequest<R = crate::Warehouse> {
    query: SelectQuery,
    relation_selections: Vec<RelationSelection>,
    relation_filters: Vec<RelationFilter>,
    child_enhancements: Vec<QuerySelection>,
    query_options: QueryOptions,
    marker: PhantomData<R>,
}

impl<R> Clone for WarehouseRequest<R> {
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

impl<R> WarehouseRequest<R> {
    pub(crate) fn new() -> Self {
        Self {
            query: SelectQuery::new("Warehouse")
                .project("id")
                .project("version"),
            relation_selections: Vec::new(),
            relation_filters: Vec::new(),
            child_enhancements: Vec::new(),
            query_options: QueryOptions::default(),
            marker: PhantomData,
        }
    }

    pub fn return_type<T>(self) -> WarehouseRequest<T> {
        WarehouseRequest {
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
    ) -> Result<SmartList<R>, TeaqlDataServiceError<C::WarehouseRepository<'a>>>
    where
        C: TeaqlRepositoryProvider + ?Sized,
        R: teaql_core::Entity,
    {
        let repository = ctx
            .warehouse_repository()
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
    ) -> Result<Vec<teaql_data_service::StreamChunk>, TeaqlDataServiceError<C::WarehouseRepository<'a>>>
    where
        C: TeaqlRepositoryProvider + ?Sized,
    {
        let repository = ctx
            .warehouse_repository()
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
    ) -> Result<Option<R>, TeaqlDataServiceError<C::WarehouseRepository<'a>>>
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
    ) -> Result<Option<R>, TeaqlDataServiceError<C::WarehouseRepository<'a>>>
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
    ) -> Result<SmartList<R>, TeaqlDataServiceError<C::WarehouseRepository<'a>>>
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
    ) -> Result<u64, TeaqlDataServiceError<C::WarehouseRepository<'a>>>
    where
        C: TeaqlRepositoryProvider + ?Sized,
    {
        let repository = ctx
            .warehouse_repository()
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
            .ok_or_else(|| DataServiceError::Runtime(RuntimeError::Graph(format!("count result for Warehouse is missing or not numeric"))))
    }

    pub(crate) async fn _execute_for_exists<'a, C>(
        self,
        ctx: &'a C,
    ) -> Result<bool, TeaqlDataServiceError<C::WarehouseRepository<'a>>>
    where
        C: TeaqlRepositoryProvider + ?Sized,
    {
        let repository = ctx
            .warehouse_repository()
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
    ) -> Result<SmartList<Record>, TeaqlDataServiceError<C::WarehouseRepository<'a>>>
    where
        C: TeaqlRepositoryProvider + ?Sized,
    {
        let repository = ctx
            .warehouse_repository()
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
    ) -> Result<Option<Record>, TeaqlDataServiceError<C::WarehouseRepository<'a>>>
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
            "capacity" => Some("capacity"),
            "location" => Some("location"),
            "manager_id" => Some("manager_id"),
            "create_time" => Some("create_time"),
            "update_time" => Some("update_time"),
            "version" => Some("version"),
            _ => None,
        }
    }

    fn apply_dynamic_json_chain_filter(self, head: &str, tail: &str, value: &JsonValue) -> Self {
        let _ = (tail, value);
        match head {
            "inventory_item_list" => {
                self.with_inventory_item_list_matching(
                    crate::Q::inventory_items_minimal()
                        .apply_dynamic_json_filter(tail, value),
                )
            }
            "shipment_list" => {
                self.with_shipment_list_matching(
                    crate::Q::shipments_minimal()
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
        self.query = self.query.project("capacity");
        self.query = self.query.project("location");
        self.query = self.query.project("manager_id");
        self.query = self.query.project("create_time");
        self.query = self.query.project("update_time");
        self.query = self.query.project("version");
        self
    }

    pub fn select_self_fields(self) -> Self {
        self.select_self()
    }

    pub fn select_self_without_parent(self) -> Self {
        self.select_self_fields()
    }

    pub fn select_all(self) -> Self {
        self.select_self()
    }

    pub fn select_children(self) -> Self {
        let mut request = self.select_all();
        request = request.select_inventory_item_list();
        request = request.select_shipment_list();
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


    pub fn select_capacity(mut self) -> Self {
        self.query = self.query.project("capacity");
        self
    }

    pub fn project_capacity(self) -> Self {
        self.select_capacity()
    }

    pub fn select_capacity_raw(self, raw_sql_segment: impl Into<String>) -> Self {
        self.select_capacity_unsafe_raw(UnsafeRawSqlSegment::trusted(raw_sql_segment))
    }

    pub fn select_capacity_unsafe_raw(mut self, raw_sql_segment: UnsafeRawSqlSegment) -> Self {
        self.query_options
            .raw_projections
            .push(RawProjection::new("capacity", raw_sql_segment));
        self
    }

    pub fn select_capacity_with_function(self, function: AggregateFunction) -> Self {
        self.select_capacity_as_with_function("capacity", function)
    }

    pub fn select_capacity_as_with_function(
        self,
        alias: impl Into<String>,
        function: AggregateFunction,
    ) -> Self {
        self.aggregate_with_function("capacity", alias, function)
    }

    pub fn group_by_capacity(self) -> Self {
        self.group_by("capacity")
    }

    pub fn group_by_capacity_as(self, alias: impl Into<String>) -> Self {
        let alias = alias.into();
        let mut request = self.group_by("capacity");
        request.query = request
            .query
            .project_expr(alias, Expr::column("capacity"));
        request
    }

    pub fn group_by_capacity_with_function(
        self,
        alias: impl Into<String>,
        function: AggregateFunction,
    ) -> Self {
        self.group_by("capacity")
            .aggregate_with_function("capacity", alias, function)
    }

    pub fn count_capacity(self) -> Self {
        self.count_capacity_as("capacity_count")
    }

    pub fn count_capacity_as(self, alias: impl Into<String>) -> Self {
        self.aggregate_count_field("capacity", alias)
    }

    pub fn sum_capacity(self) -> Self {
        self.sum_capacity_as("sum_capacity")
    }

    pub fn sum_capacity_as(self, alias: impl Into<String>) -> Self {
        self.aggregate_sum("capacity", alias)
    }

    pub fn avg_capacity(self) -> Self {
        self.avg_capacity_as("avg_capacity")
    }

    pub fn avg_capacity_as(self, alias: impl Into<String>) -> Self {
        self.aggregate_avg("capacity", alias)
    }

    pub fn min_capacity(self) -> Self {
        self.min_capacity_as("min_capacity")
    }

    pub fn min_capacity_as(self, alias: impl Into<String>) -> Self {
        self.aggregate_min("capacity", alias)
    }

    pub fn max_capacity(self) -> Self {
        self.max_capacity_as("max_capacity")
    }

    pub fn max_capacity_as(self, alias: impl Into<String>) -> Self {
        self.aggregate_max("capacity", alias)
    }

    pub fn standard_deviation_capacity(self) -> Self {
        self.standard_deviation_capacity_as("stdDev_capacity")
    }

    pub fn standard_deviation_capacity_as(self, alias: impl Into<String>) -> Self {
        self.aggregate_stddev("capacity", alias)
    }

    pub fn square_root_of_population_standard_deviation_capacity(self) -> Self {
        self.square_root_of_population_standard_deviation_capacity_as("stdDevPop_capacity")
    }

    pub fn square_root_of_population_standard_deviation_capacity_as(self, alias: impl Into<String>) -> Self {
        self.aggregate_stddev_pop("capacity", alias)
    }

    pub fn sample_variance_capacity(self) -> Self {
        self.sample_variance_capacity_as("varSamp_capacity")
    }

    pub fn sample_variance_capacity_as(self, alias: impl Into<String>) -> Self {
        self.aggregate_var_samp("capacity", alias)
    }

    pub fn sample_population_variance_capacity(self) -> Self {
        self.sample_population_variance_capacity_as("varPop_capacity")
    }

    pub fn sample_population_variance_capacity_as(self, alias: impl Into<String>) -> Self {
        self.aggregate_var_pop("capacity", alias)
    }

    pub fn unselect_capacity(mut self) -> Self {
        self.query.projection.retain(|field| field != "capacity");
        self.query_options.raw_projections.retain(|projection| projection.property_name != "capacity");
        self
    }


    pub fn with_capacity(
        mut self,
        operator: FieldOperator,
        values: impl IntoIterator<Item = impl Into<teaql_core::Value>>,
    ) -> Self {
        self.query = self.query.and_filter(field_operator_expr(
            "capacity",
            operator,
            values.into_iter().map(Into::into).collect(),
        ));
        self
    }

    pub fn create_capacity_criteria(
        operator: FieldOperator,
        values: impl IntoIterator<Item = impl Into<teaql_core::Value>>,
    ) -> Expr {
        field_operator_expr(
            "capacity",
            operator,
            values.into_iter().map(Into::into).collect(),
        )
    }

    pub fn with_capacity_is(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::eq("capacity", value));
        self
    }



    pub fn with_capacity_is_not(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::ne("capacity", value));
        self
    }

    pub fn with_capacity_greater_than(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::gt("capacity", value));
        self
    }

    pub fn with_capacity_greater_than_or_equal_to(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::gte("capacity", value));
        self
    }

    pub fn with_capacity_less_than(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::lt("capacity", value));
        self
    }

    pub fn with_capacity_less_than_or_equal_to(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::lte("capacity", value));
        self
    }

    pub fn with_capacity_between(
        mut self,
        lower: impl Into<teaql_core::Value>,
        upper: impl Into<teaql_core::Value>,
    ) -> Self {
        self.query = self.query.and_filter(Expr::between("capacity", lower, upper));
        self
    }

    pub fn with_capacity_between_range<T>(mut self, range: DateRange<T>) -> Self
    where
        T: Into<teaql_core::Value>,
    {
        self.query = self.query.and_filter(Expr::between(
            "capacity",
            range.start,
            range.end,
        ));
        self
    }

    pub fn with_capacity_in(
        mut self,
        values: impl IntoIterator<Item = impl Into<teaql_core::Value>>,
    ) -> Self {
        self.query = self.query.and_filter(Expr::in_list(
            "capacity",
            values.into_iter().map(Into::into),
        ));
        self
    }

    pub fn with_capacity_not_in(
        mut self,
        values: impl IntoIterator<Item = impl Into<teaql_core::Value>>,
    ) -> Self {
        self.query = self.query.and_filter(Expr::not_in_list(
            "capacity",
            values.into_iter().map(Into::into),
        ));
        self
    }

    pub fn with_capacity_before(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::lt("capacity", value));
        self
    }

    pub fn with_capacity_after(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::gt("capacity", value));
        self
    }

    pub fn with_capacity_is_unknown(mut self) -> Self {
        self.query = self.query.and_filter(Expr::is_null("capacity"));
        self
    }



    pub fn with_capacity_is_known(mut self) -> Self {
        self.query = self.query.and_filter(Expr::is_not_null("capacity"));
        self
    }


    pub fn order_by_capacity_asc(mut self) -> Self {
        self.query = self.query.order_asc("capacity");
        self
    }

    pub fn order_by_capacity_desc(mut self) -> Self {
        self.query = self.query.order_desc("capacity");
        self
    }

    pub fn order_by_capacity_asc_using_gbk(mut self) -> Self {
        self.query = self.query.order_gbk_asc("capacity");
        self
    }

    pub fn order_by_capacity_desc_using_gbk(mut self) -> Self {
        self.query = self.query.order_gbk_desc("capacity");
        self
    }


    pub fn select_location(mut self) -> Self {
        self.query = self.query.project("location");
        self
    }

    pub fn project_location(self) -> Self {
        self.select_location()
    }

    pub fn select_location_raw(self, raw_sql_segment: impl Into<String>) -> Self {
        self.select_location_unsafe_raw(UnsafeRawSqlSegment::trusted(raw_sql_segment))
    }

    pub fn select_location_unsafe_raw(mut self, raw_sql_segment: UnsafeRawSqlSegment) -> Self {
        self.query_options
            .raw_projections
            .push(RawProjection::new("location", raw_sql_segment));
        self
    }

    pub fn group_by_location(self) -> Self {
        self.group_by("location")
    }

    pub fn group_by_location_as(self, alias: impl Into<String>) -> Self {
        let alias = alias.into();
        let mut request = self.group_by("location");
        request.query = request
            .query
            .project_expr(alias, Expr::column("location"));
        request
    }

    pub fn group_by_location_with_function(
        self,
        alias: impl Into<String>,
        function: AggregateFunction,
    ) -> Self {
        self.group_by("location")
            .aggregate_with_function("location", alias, function)
    }

    pub fn count_location(self) -> Self {
        self.count_location_as("location_count")
    }

    pub fn count_location_as(self, alias: impl Into<String>) -> Self {
        self.aggregate_count_field("location", alias)
    }

    pub fn sum_location(self) -> Self {
        self.sum_location_as("sum_location")
    }

    pub fn sum_location_as(self, alias: impl Into<String>) -> Self {
        self.aggregate_sum("location", alias)
    }

    pub fn avg_location(self) -> Self {
        self.avg_location_as("avg_location")
    }

    pub fn avg_location_as(self, alias: impl Into<String>) -> Self {
        self.aggregate_avg("location", alias)
    }

    pub fn min_location(self) -> Self {
        self.min_location_as("min_location")
    }

    pub fn min_location_as(self, alias: impl Into<String>) -> Self {
        self.aggregate_min("location", alias)
    }

    pub fn max_location(self) -> Self {
        self.max_location_as("max_location")
    }

    pub fn max_location_as(self, alias: impl Into<String>) -> Self {
        self.aggregate_max("location", alias)
    }

    pub fn unselect_location(mut self) -> Self {
        self.query.projection.retain(|field| field != "location");
        self.query_options.raw_projections.retain(|projection| projection.property_name != "location");
        self
    }


    pub fn with_location(
        mut self,
        operator: FieldOperator,
        values: impl IntoIterator<Item = impl Into<teaql_core::Value>>,
    ) -> Self {
        self.query = self.query.and_filter(field_operator_expr(
            "location",
            operator,
            values.into_iter().map(Into::into).collect(),
        ));
        self
    }

    pub fn create_location_criteria(
        operator: FieldOperator,
        values: impl IntoIterator<Item = impl Into<teaql_core::Value>>,
    ) -> Expr {
        field_operator_expr(
            "location",
            operator,
            values.into_iter().map(Into::into).collect(),
        )
    }

    pub fn with_location_is(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::eq("location", value));
        self
    }



    pub fn with_location_is_not(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::ne("location", value));
        self
    }

    pub fn with_location_greater_than(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::gt("location", value));
        self
    }

    pub fn with_location_greater_than_or_equal_to(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::gte("location", value));
        self
    }

    pub fn with_location_less_than(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::lt("location", value));
        self
    }

    pub fn with_location_less_than_or_equal_to(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::lte("location", value));
        self
    }

    pub fn with_location_between(
        mut self,
        lower: impl Into<teaql_core::Value>,
        upper: impl Into<teaql_core::Value>,
    ) -> Self {
        self.query = self.query.and_filter(Expr::between("location", lower, upper));
        self
    }

    pub fn with_location_between_range<T>(mut self, range: DateRange<T>) -> Self
    where
        T: Into<teaql_core::Value>,
    {
        self.query = self.query.and_filter(Expr::between(
            "location",
            range.start,
            range.end,
        ));
        self
    }

    pub fn with_location_in(
        mut self,
        values: impl IntoIterator<Item = impl Into<teaql_core::Value>>,
    ) -> Self {
        self.query = self.query.and_filter(Expr::in_list(
            "location",
            values.into_iter().map(Into::into),
        ));
        self
    }

    pub fn with_location_not_in(
        mut self,
        values: impl IntoIterator<Item = impl Into<teaql_core::Value>>,
    ) -> Self {
        self.query = self.query.and_filter(Expr::not_in_list(
            "location",
            values.into_iter().map(Into::into),
        ));
        self
    }

    pub fn with_location_containing(mut self, value: impl Into<String>) -> Self {
        self.query = self.query.and_filter(Expr::contain("location", value));
        self
    }

    pub fn with_location_not_containing(mut self, value: impl Into<String>) -> Self {
        self.query = self.query.and_filter(Expr::not_contain("location", value));
        self
    }

    pub fn with_location_starting_with(mut self, value: impl Into<String>) -> Self {
        self.query = self.query.and_filter(Expr::begin_with("location", value));
        self
    }

    pub fn with_location_not_starting_with(mut self, value: impl Into<String>) -> Self {
        self.query = self.query.and_filter(Expr::not_begin_with("location", value));
        self
    }

    pub fn with_location_ending_with(mut self, value: impl Into<String>) -> Self {
        self.query = self.query.and_filter(Expr::end_with("location", value));
        self
    }

    pub fn with_location_not_ending_with(mut self, value: impl Into<String>) -> Self {
        self.query = self.query.and_filter(Expr::not_end_with("location", value));
        self
    }

    pub fn with_location_sounding_like(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::sound_like("location", value));
        self
    }
    pub fn with_location_before(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::lt("location", value));
        self
    }

    pub fn with_location_after(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::gt("location", value));
        self
    }

    pub fn with_location_is_unknown(mut self) -> Self {
        self.query = self.query.and_filter(Expr::is_null("location"));
        self
    }



    pub fn with_location_is_known(mut self) -> Self {
        self.query = self.query.and_filter(Expr::is_not_null("location"));
        self
    }


    pub fn order_by_location_asc(mut self) -> Self {
        self.query = self.query.order_asc("location");
        self
    }

    pub fn order_by_location_desc(mut self) -> Self {
        self.query = self.query.order_desc("location");
        self
    }

    pub fn order_by_location_asc_using_gbk(mut self) -> Self {
        self.query = self.query.order_gbk_asc("location");
        self
    }

    pub fn order_by_location_desc_using_gbk(mut self) -> Self {
        self.query = self.query.order_gbk_desc("location");
        self
    }


    pub fn select_manager_id(mut self) -> Self {
        self.query = self.query.project("manager_id");
        self
    }

    pub fn project_manager_id(self) -> Self {
        self.select_manager_id()
    }

    pub fn select_manager_id_raw(self, raw_sql_segment: impl Into<String>) -> Self {
        self.select_manager_id_unsafe_raw(UnsafeRawSqlSegment::trusted(raw_sql_segment))
    }

    pub fn select_manager_id_unsafe_raw(mut self, raw_sql_segment: UnsafeRawSqlSegment) -> Self {
        self.query_options
            .raw_projections
            .push(RawProjection::new("manager_id", raw_sql_segment));
        self
    }

    pub fn group_by_manager_id(self) -> Self {
        self.group_by("manager_id")
    }

    pub fn group_by_manager_id_as(self, alias: impl Into<String>) -> Self {
        let alias = alias.into();
        let mut request = self.group_by("manager_id");
        request.query = request
            .query
            .project_expr(alias, Expr::column("manager_id"));
        request
    }

    pub fn group_by_manager_id_with_function(
        self,
        alias: impl Into<String>,
        function: AggregateFunction,
    ) -> Self {
        self.group_by("manager_id")
            .aggregate_with_function("manager_id", alias, function)
    }

    pub fn count_manager_id(self) -> Self {
        self.count_manager_id_as("manager_id_count")
    }

    pub fn count_manager_id_as(self, alias: impl Into<String>) -> Self {
        self.aggregate_count_field("manager_id", alias)
    }

    pub fn sum_manager_id(self) -> Self {
        self.sum_manager_id_as("sum_manager_id")
    }

    pub fn sum_manager_id_as(self, alias: impl Into<String>) -> Self {
        self.aggregate_sum("manager_id", alias)
    }

    pub fn avg_manager_id(self) -> Self {
        self.avg_manager_id_as("avg_manager_id")
    }

    pub fn avg_manager_id_as(self, alias: impl Into<String>) -> Self {
        self.aggregate_avg("manager_id", alias)
    }

    pub fn min_manager_id(self) -> Self {
        self.min_manager_id_as("min_manager_id")
    }

    pub fn min_manager_id_as(self, alias: impl Into<String>) -> Self {
        self.aggregate_min("manager_id", alias)
    }

    pub fn max_manager_id(self) -> Self {
        self.max_manager_id_as("max_manager_id")
    }

    pub fn max_manager_id_as(self, alias: impl Into<String>) -> Self {
        self.aggregate_max("manager_id", alias)
    }

    pub fn unselect_manager_id(mut self) -> Self {
        self.query.projection.retain(|field| field != "manager_id");
        self.query_options.raw_projections.retain(|projection| projection.property_name != "manager_id");
        self
    }


    pub fn with_manager_id(
        mut self,
        operator: FieldOperator,
        values: impl IntoIterator<Item = impl Into<teaql_core::Value>>,
    ) -> Self {
        self.query = self.query.and_filter(field_operator_expr(
            "manager_id",
            operator,
            values.into_iter().map(Into::into).collect(),
        ));
        self
    }

    pub fn create_manager_id_criteria(
        operator: FieldOperator,
        values: impl IntoIterator<Item = impl Into<teaql_core::Value>>,
    ) -> Expr {
        field_operator_expr(
            "manager_id",
            operator,
            values.into_iter().map(Into::into).collect(),
        )
    }

    pub fn with_manager_id_is(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::eq("manager_id", value));
        self
    }



    pub fn with_manager_id_is_not(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::ne("manager_id", value));
        self
    }

    pub fn with_manager_id_greater_than(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::gt("manager_id", value));
        self
    }

    pub fn with_manager_id_greater_than_or_equal_to(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::gte("manager_id", value));
        self
    }

    pub fn with_manager_id_less_than(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::lt("manager_id", value));
        self
    }

    pub fn with_manager_id_less_than_or_equal_to(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::lte("manager_id", value));
        self
    }

    pub fn with_manager_id_between(
        mut self,
        lower: impl Into<teaql_core::Value>,
        upper: impl Into<teaql_core::Value>,
    ) -> Self {
        self.query = self.query.and_filter(Expr::between("manager_id", lower, upper));
        self
    }

    pub fn with_manager_id_between_range<T>(mut self, range: DateRange<T>) -> Self
    where
        T: Into<teaql_core::Value>,
    {
        self.query = self.query.and_filter(Expr::between(
            "manager_id",
            range.start,
            range.end,
        ));
        self
    }

    pub fn with_manager_id_in(
        mut self,
        values: impl IntoIterator<Item = impl Into<teaql_core::Value>>,
    ) -> Self {
        self.query = self.query.and_filter(Expr::in_list(
            "manager_id",
            values.into_iter().map(Into::into),
        ));
        self
    }

    pub fn with_manager_id_not_in(
        mut self,
        values: impl IntoIterator<Item = impl Into<teaql_core::Value>>,
    ) -> Self {
        self.query = self.query.and_filter(Expr::not_in_list(
            "manager_id",
            values.into_iter().map(Into::into),
        ));
        self
    }

    pub fn with_manager_id_containing(mut self, value: impl Into<String>) -> Self {
        self.query = self.query.and_filter(Expr::contain("manager_id", value));
        self
    }

    pub fn with_manager_id_not_containing(mut self, value: impl Into<String>) -> Self {
        self.query = self.query.and_filter(Expr::not_contain("manager_id", value));
        self
    }

    pub fn with_manager_id_starting_with(mut self, value: impl Into<String>) -> Self {
        self.query = self.query.and_filter(Expr::begin_with("manager_id", value));
        self
    }

    pub fn with_manager_id_not_starting_with(mut self, value: impl Into<String>) -> Self {
        self.query = self.query.and_filter(Expr::not_begin_with("manager_id", value));
        self
    }

    pub fn with_manager_id_ending_with(mut self, value: impl Into<String>) -> Self {
        self.query = self.query.and_filter(Expr::end_with("manager_id", value));
        self
    }

    pub fn with_manager_id_not_ending_with(mut self, value: impl Into<String>) -> Self {
        self.query = self.query.and_filter(Expr::not_end_with("manager_id", value));
        self
    }

    pub fn with_manager_id_sounding_like(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::sound_like("manager_id", value));
        self
    }
    pub fn with_manager_id_before(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::lt("manager_id", value));
        self
    }

    pub fn with_manager_id_after(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::gt("manager_id", value));
        self
    }

    pub fn with_manager_id_is_unknown(mut self) -> Self {
        self.query = self.query.and_filter(Expr::is_null("manager_id"));
        self
    }



    pub fn with_manager_id_is_known(mut self) -> Self {
        self.query = self.query.and_filter(Expr::is_not_null("manager_id"));
        self
    }


    pub fn order_by_manager_id_asc(mut self) -> Self {
        self.query = self.query.order_asc("manager_id");
        self
    }

    pub fn order_by_manager_id_desc(mut self) -> Self {
        self.query = self.query.order_desc("manager_id");
        self
    }

    pub fn order_by_manager_id_asc_using_gbk(mut self) -> Self {
        self.query = self.query.order_gbk_asc("manager_id");
        self
    }

    pub fn order_by_manager_id_desc_using_gbk(mut self) -> Self {
        self.query = self.query.order_gbk_desc("manager_id");
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
    pub fn name_is_name_value(self) -> Self {
        self.with_name_is("name_value")
    }

    pub fn with_name_is_name_value(self) -> Self {
        self.with_name_is("name_value")
    }



    pub fn with_name_is_not_name_value(self) -> Self {
        self.with_name_is_not("name_value")
    }



    pub fn capacity_is_value_100_00(self) -> Self {
        self.with_capacity_is("100.00")
    }

    pub fn with_capacity_is_value_100_00(self) -> Self {
        self.with_capacity_is("100.00")
    }



    pub fn with_capacity_is_not_value_100_00(self) -> Self {
        self.with_capacity_is_not("100.00")
    }



    pub fn location_is_location_value(self) -> Self {
        self.with_location_is("location_value")
    }

    pub fn with_location_is_location_value(self) -> Self {
        self.with_location_is("location_value")
    }



    pub fn with_location_is_not_location_value(self) -> Self {
        self.with_location_is_not("location_value")
    }



    pub fn manager_id_is_manager_id_value(self) -> Self {
        self.with_manager_id_is("manager_id_value")
    }

    pub fn with_manager_id_is_manager_id_value(self) -> Self {
        self.with_manager_id_is("manager_id_value")
    }



    pub fn with_manager_id_is_not_manager_id_value(self) -> Self {
        self.with_manager_id_is_not("manager_id_value")
    }



    pub fn create_time_is_create_time(self) -> Self {
        self.with_create_time_is("createTime()")
    }

    pub fn with_create_time_is_create_time(self) -> Self {
        self.with_create_time_is("createTime()")
    }



    pub fn with_create_time_is_not_create_time(self) -> Self {
        self.with_create_time_is_not("createTime()")
    }



    pub fn update_time_is_update_time(self) -> Self {
        self.with_update_time_is("updateTime()")
    }

    pub fn with_update_time_is_update_time(self) -> Self {
        self.with_update_time_is("updateTime()")
    }



    pub fn with_update_time_is_not_update_time(self) -> Self {
        self.with_update_time_is_not("updateTime()")
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
            "warehouse_id",
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
            "warehouse_id",
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

    pub fn have_shipments(self) -> Self {
        self.with_shipment_list_matching(SelectQuery::new("Shipment"))
    }

    pub fn have_no_shipments(self) -> Self {
        self.without_shipment_list_matching(SelectQuery::new("Shipment"))
    }

    pub fn with_shipment_list_matching(mut self, request: impl Into<QuerySelection>) -> Self {
        let selection = request.into();
        self.query = self.query.and_filter(Expr::in_subquery(
            "id",
            <crate::Shipment as teaql_core::TeaqlEntity>::entity_descriptor(),
            selection.query.clone(),
            "warehouse_id",
        ));
        self.relation_filters.push(RelationFilter::new("shipment_list", selection));
        self
    }

    pub fn without_shipment_list_matching(mut self, request: impl Into<QuerySelection>) -> Self {
        let selection = request.into();
        self.query = self.query.and_filter(Expr::not_in_subquery(
            "id",
            <crate::Shipment as teaql_core::TeaqlEntity>::entity_descriptor(),
            selection.query.clone(),
            "warehouse_id",
        ));
        self.relation_filters.push(RelationFilter::new("shipment_list", selection));
        self
    }

    pub fn select_shipment_list(mut self) -> Self {
        self.query = self.query.relation("shipment_list");
        self
    }

    pub fn select_shipment_list_with(mut self, request: impl Into<QuerySelection>) -> Self {
        let selection = request.into();
        self.query = self.query.relation_query("shipment_list", selection.clone().into_query());
        self.relation_selections.push(RelationSelection::new("shipment_list", selection));
        self
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

    pub fn count_shipments(self) -> Self {
        self.count_shipments_as("count_shipments")
    }

    pub fn count_shipments_as(self, alias: impl Into<String>) -> Self {
        self.count_shipments_with(alias, crate::Q::shipments().unlimited())
    }

    pub fn count_shipments_with(mut self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        let selection = request.into();
        self.query_options.relation_aggregates.push(RelationAggregate::new(
            "shipment_list",
            alias,
            selection,
            true,
        ));
        self
    }

    pub fn stats_from_shipments(self, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_shipments_as("refinements", request)
    }

    pub fn stats_from_shipments_as(mut self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        let selection = request.into();
        self.query_options.relation_aggregates.push(RelationAggregate::new(
            "shipment_list",
            alias,
            selection,
            false,
        ));
        self
    }

    pub fn group_by_shipments_with_details(self, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_shipments(request)
    }


    pub fn min_shipped_date_of_shipments(self) -> Self {
        self.min_shipped_date_of_shipments_as("min_shipped_date_of_shipments", crate::Q::shipments().unlimited())
    }

    pub fn min_shipped_date_of_shipments_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_shipments_as(alias, request.into().into_query().min("shipped_date", "min_shipped_date"))
    }
    pub fn max_shipped_date_of_shipments(self) -> Self {
        self.max_shipped_date_of_shipments_as("max_shipped_date_of_shipments", crate::Q::shipments().unlimited())
    }

    pub fn max_shipped_date_of_shipments_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_shipments_as(alias, request.into().into_query().max("shipped_date", "max_shipped_date"))
    }
    pub fn min_create_time_of_shipments(self) -> Self {
        self.min_create_time_of_shipments_as("min_create_time_of_shipments", crate::Q::shipments().unlimited())
    }

    pub fn min_create_time_of_shipments_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_shipments_as(alias, request.into().into_query().min("create_time", "min_create_time"))
    }
    pub fn max_create_time_of_shipments(self) -> Self {
        self.max_create_time_of_shipments_as("max_create_time_of_shipments", crate::Q::shipments().unlimited())
    }

    pub fn max_create_time_of_shipments_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_shipments_as(alias, request.into().into_query().max("create_time", "max_create_time"))
    }
    pub fn min_update_time_of_shipments(self) -> Self {
        self.min_update_time_of_shipments_as("min_update_time_of_shipments", crate::Q::shipments().unlimited())
    }

    pub fn min_update_time_of_shipments_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_shipments_as(alias, request.into().into_query().min("update_time", "min_update_time"))
    }
    pub fn max_update_time_of_shipments(self) -> Self {
        self.max_update_time_of_shipments_as("max_update_time_of_shipments", crate::Q::shipments().unlimited())
    }

    pub fn max_update_time_of_shipments_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_shipments_as(alias, request.into().into_query().max("update_time", "max_update_time"))
    }
}

impl<R> Default for WarehouseRequest<R> {
    fn default() -> Self {
        Self::new()
    }
}

impl<R> From< WarehouseRequest<R> > for SelectQuery {
    fn from(request: WarehouseRequest<R>) -> Self {
        QuerySelection::from(request).into_query()
    }
}

impl<R> From< WarehouseRequest<R> > for QuerySelection {
    fn from(request: WarehouseRequest<R>) -> Self {
        Self {
            query: request.query,
            relation_selections: request.relation_selections,
            relation_filters: request.relation_filters,
            child_enhancements: request.child_enhancements,
            query_options: request.query_options,
        }
    }
}


impl<'a, C> crate::request_support::AuditedSave<'a, C> for teaql_core::Audited<crate::Warehouse> 
where C: crate::request_support::TeaqlRepositoryProvider + ?Sized + 'a
{
    type Error = crate::TeaqlDataServiceError<C::WarehouseRepository<'a>>;
    fn save(self, ctx: &'a C) -> std::pin::Pin<Box<dyn std::future::Future<Output = Result<teaql_runtime::GraphNode, Self::Error>> + '_>> {
        Box::pin(async move {
            teaql_runtime::save_audited_ledger_entity(self, ctx.user_context())
                .await
                .map_err(DataServiceError::Runtime)
        })
    }
}

impl<R: teaql_core::Entity> crate::PurposedQuery<WarehouseRequest<R>> {
    pub fn new_entity<C>(&self, ctx: &C) -> crate::Warehouse
    where
        C: crate::TeaqlRuntime + ?Sized,
    {
        crate::Warehouse::runtime_new(ctx.user_context().entity_root())
    }

    fn into_inner_with_trace(mut self) -> WarehouseRequest<R> {
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
    ) -> Result<teaql_core::SmartList<R>, crate::request_support::TeaqlDataServiceError<C::WarehouseRepository<'a>>>
    where
        C: crate::request_support::TeaqlRepositoryProvider + ?Sized,
    {
        self.into_inner_with_trace()._execute_for_page(ctx, offset, limit).await
    }

    pub async fn execute_for_exists<'a, C>(
        self,
        ctx: &'a C,
    ) -> Result<bool, crate::request_support::TeaqlDataServiceError<C::WarehouseRepository<'a>>>
    where
        C: crate::request_support::TeaqlRepositoryProvider + ?Sized,
    {
        self.into_inner_with_trace()._execute_for_exists(ctx).await
    }

    pub async fn execute_for_list<'a, C>(self, ctx: &'a C) -> Result<teaql_core::SmartList<R>, crate::request_support::TeaqlDataServiceError<C::WarehouseRepository<'a>>>
    where
        C: crate::request_support::TeaqlRepositoryProvider + ?Sized,
    {
        self.into_inner_with_trace()._execute_for_list(ctx).await
    }

    /// Execute query in streaming mode (chunked).
    /// Returns a Vec of StreamChunk, each containing up to chunk_size rows.
    /// Set chunk size via .stream(chunk_size) or .stream_default() on the query.
    pub async fn execute_for_stream<'a, C>(self, ctx: &'a C) -> Result<Vec<teaql_data_service::StreamChunk>, crate::request_support::TeaqlDataServiceError<C::WarehouseRepository<'a>>>
    where
        C: crate::request_support::TeaqlRepositoryProvider + ?Sized,
    {
        self.into_inner_with_trace()._execute_for_stream(ctx).await
    }

    pub async fn execute_for_first<'a, C>(self, ctx: &'a C) -> Result<Option<R>, crate::request_support::TeaqlDataServiceError<C::WarehouseRepository<'a>>>
    where
        C: crate::request_support::TeaqlRepositoryProvider + ?Sized,
    {
        self.into_inner_with_trace()._execute_for_first(ctx).await
    }

    pub async fn execute_for_one<'a, C>(self, ctx: &'a C) -> Result<Option<R>, crate::request_support::TeaqlDataServiceError<C::WarehouseRepository<'a>>>
    where
        C: crate::request_support::TeaqlRepositoryProvider + ?Sized,
    {
        self.into_inner_with_trace()._execute_for_one(ctx).await
    }


    pub async fn execute_for_records<'a, C>(self, ctx: &'a C) -> Result<teaql_core::SmartList<teaql_core::Record>, crate::request_support::TeaqlDataServiceError<C::WarehouseRepository<'a>>>
    where
        C: crate::request_support::TeaqlRepositoryProvider + ?Sized,
    {
        self.into_inner_with_trace()._execute_for_records(ctx).await
    }

    pub async fn execute_for_record<'a, C>(self, ctx: &'a C) -> Result<Option<teaql_core::Record>, crate::request_support::TeaqlDataServiceError<C::WarehouseRepository<'a>>>
    where
        C: crate::request_support::TeaqlRepositoryProvider + ?Sized,
    {
        self.into_inner_with_trace()._execute_for_record(ctx).await
    }

    pub async fn execute_for_count<'a, C>(self, ctx: &'a C) -> Result<u64, crate::request_support::TeaqlDataServiceError<C::WarehouseRepository<'a>>>
    where
        C: crate::request_support::TeaqlRepositoryProvider + ?Sized,
    {
        self.into_inner_with_trace()._execute_for_count(ctx).await
    }
}
