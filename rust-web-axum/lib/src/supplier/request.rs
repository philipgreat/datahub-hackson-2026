use std::marker::PhantomData;

use serde_json::Value as JsonValue;
use teaql_core::{Aggregate, AggregateFunction, EntityDescriptor, Expr, Record, SelectQuery, SmartList};
use teaql_runtime::{DataServiceError, RuntimeError};

use crate::request_support::*;

impl EntityReference for crate::Supplier {
    fn entity_id_value(self) -> teaql_core::Value {
        teaql_core::IdentifiableEntity::id_value(&self)
    }
}

impl EntityReference for &crate::Supplier {
    fn entity_id_value(self) -> teaql_core::Value {
        teaql_core::IdentifiableEntity::id_value(self)
    }
}

// ⛔ AI agents: DO NOT read this file for API discovery. Instead run: cargo teaql --input modeling/MODEL.xml rust-assist-query/supplier
#[derive(Debug)]
pub struct SupplierRequest<R = crate::Supplier> {
    query: SelectQuery,
    relation_selections: Vec<RelationSelection>,
    relation_filters: Vec<RelationFilter>,
    child_enhancements: Vec<QuerySelection>,
    query_options: QueryOptions,
    marker: PhantomData<R>,
}

impl<R> Clone for SupplierRequest<R> {
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

impl<R> SupplierRequest<R> {
    pub(crate) fn new() -> Self {
        Self {
            query: SelectQuery::new("Supplier")
                .project("id")
                .project("version"),
            relation_selections: Vec::new(),
            relation_filters: Vec::new(),
            child_enhancements: Vec::new(),
            query_options: QueryOptions::default(),
            marker: PhantomData,
        }
    }

    pub fn return_type<T>(self) -> SupplierRequest<T> {
        SupplierRequest {
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
    ) -> Result<SmartList<R>, TeaqlDataServiceError<C::SupplierRepository<'a>>>
    where
        C: TeaqlRepositoryProvider + ?Sized,
        R: teaql_core::Entity,
    {
        let repository = ctx
            .supplier_repository()
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
    ) -> Result<Vec<teaql_data_service::StreamChunk>, TeaqlDataServiceError<C::SupplierRepository<'a>>>
    where
        C: TeaqlRepositoryProvider + ?Sized,
    {
        let repository = ctx
            .supplier_repository()
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
    ) -> Result<Option<R>, TeaqlDataServiceError<C::SupplierRepository<'a>>>
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
    ) -> Result<Option<R>, TeaqlDataServiceError<C::SupplierRepository<'a>>>
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
    ) -> Result<SmartList<R>, TeaqlDataServiceError<C::SupplierRepository<'a>>>
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
    ) -> Result<u64, TeaqlDataServiceError<C::SupplierRepository<'a>>>
    where
        C: TeaqlRepositoryProvider + ?Sized,
    {
        let repository = ctx
            .supplier_repository()
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
            .ok_or_else(|| DataServiceError::Runtime(RuntimeError::Graph(format!("count result for Supplier is missing or not numeric"))))
    }

    pub(crate) async fn _execute_for_exists<'a, C>(
        self,
        ctx: &'a C,
    ) -> Result<bool, TeaqlDataServiceError<C::SupplierRepository<'a>>>
    where
        C: TeaqlRepositoryProvider + ?Sized,
    {
        let repository = ctx
            .supplier_repository()
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
    ) -> Result<SmartList<Record>, TeaqlDataServiceError<C::SupplierRepository<'a>>>
    where
        C: TeaqlRepositoryProvider + ?Sized,
    {
        let repository = ctx
            .supplier_repository()
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
    ) -> Result<Option<Record>, TeaqlDataServiceError<C::SupplierRepository<'a>>>
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
            "address" => Some("address"),
            "contact_email" => Some("contact_email"),
            "name" => Some("name"),
            "phone" => Some("phone"),
            "rating" => Some("rating"),
            "create_time" => Some("create_time"),
            "update_time" => Some("update_time"),
            "version" => Some("version"),
            _ => None,
        }
    }

    fn apply_dynamic_json_chain_filter(self, head: &str, tail: &str, value: &JsonValue) -> Self {
        let _ = (tail, value);
        match head {
            "purchase_order_list" => {
                self.with_purchase_order_list_matching(
                    crate::Q::purchase_orders_minimal()
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
        self.query = self.query.project("address");
        self.query = self.query.project("contact_email");
        self.query = self.query.project("name");
        self.query = self.query.project("phone");
        self.query = self.query.project("rating");
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
        request = request.select_purchase_order_list();
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


    pub fn select_address(mut self) -> Self {
        self.query = self.query.project("address");
        self
    }

    pub fn project_address(self) -> Self {
        self.select_address()
    }

    pub fn select_address_raw(self, raw_sql_segment: impl Into<String>) -> Self {
        self.select_address_unsafe_raw(UnsafeRawSqlSegment::trusted(raw_sql_segment))
    }

    pub fn select_address_unsafe_raw(mut self, raw_sql_segment: UnsafeRawSqlSegment) -> Self {
        self.query_options
            .raw_projections
            .push(RawProjection::new("address", raw_sql_segment));
        self
    }

    pub fn group_by_address(self) -> Self {
        self.group_by("address")
    }

    pub fn group_by_address_as(self, alias: impl Into<String>) -> Self {
        let alias = alias.into();
        let mut request = self.group_by("address");
        request.query = request
            .query
            .project_expr(alias, Expr::column("address"));
        request
    }

    pub fn group_by_address_with_function(
        self,
        alias: impl Into<String>,
        function: AggregateFunction,
    ) -> Self {
        self.group_by("address")
            .aggregate_with_function("address", alias, function)
    }

    pub fn count_address(self) -> Self {
        self.count_address_as("address_count")
    }

    pub fn count_address_as(self, alias: impl Into<String>) -> Self {
        self.aggregate_count_field("address", alias)
    }

    pub fn sum_address(self) -> Self {
        self.sum_address_as("sum_address")
    }

    pub fn sum_address_as(self, alias: impl Into<String>) -> Self {
        self.aggregate_sum("address", alias)
    }

    pub fn avg_address(self) -> Self {
        self.avg_address_as("avg_address")
    }

    pub fn avg_address_as(self, alias: impl Into<String>) -> Self {
        self.aggregate_avg("address", alias)
    }

    pub fn min_address(self) -> Self {
        self.min_address_as("min_address")
    }

    pub fn min_address_as(self, alias: impl Into<String>) -> Self {
        self.aggregate_min("address", alias)
    }

    pub fn max_address(self) -> Self {
        self.max_address_as("max_address")
    }

    pub fn max_address_as(self, alias: impl Into<String>) -> Self {
        self.aggregate_max("address", alias)
    }

    pub fn unselect_address(mut self) -> Self {
        self.query.projection.retain(|field| field != "address");
        self.query_options.raw_projections.retain(|projection| projection.property_name != "address");
        self
    }


    pub fn with_address(
        mut self,
        operator: FieldOperator,
        values: impl IntoIterator<Item = impl Into<teaql_core::Value>>,
    ) -> Self {
        self.query = self.query.and_filter(field_operator_expr(
            "address",
            operator,
            values.into_iter().map(Into::into).collect(),
        ));
        self
    }

    pub fn create_address_criteria(
        operator: FieldOperator,
        values: impl IntoIterator<Item = impl Into<teaql_core::Value>>,
    ) -> Expr {
        field_operator_expr(
            "address",
            operator,
            values.into_iter().map(Into::into).collect(),
        )
    }

    pub fn with_address_is(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::eq("address", value));
        self
    }



    pub fn with_address_is_not(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::ne("address", value));
        self
    }

    pub fn with_address_greater_than(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::gt("address", value));
        self
    }

    pub fn with_address_greater_than_or_equal_to(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::gte("address", value));
        self
    }

    pub fn with_address_less_than(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::lt("address", value));
        self
    }

    pub fn with_address_less_than_or_equal_to(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::lte("address", value));
        self
    }

    pub fn with_address_between(
        mut self,
        lower: impl Into<teaql_core::Value>,
        upper: impl Into<teaql_core::Value>,
    ) -> Self {
        self.query = self.query.and_filter(Expr::between("address", lower, upper));
        self
    }

    pub fn with_address_between_range<T>(mut self, range: DateRange<T>) -> Self
    where
        T: Into<teaql_core::Value>,
    {
        self.query = self.query.and_filter(Expr::between(
            "address",
            range.start,
            range.end,
        ));
        self
    }

    pub fn with_address_in(
        mut self,
        values: impl IntoIterator<Item = impl Into<teaql_core::Value>>,
    ) -> Self {
        self.query = self.query.and_filter(Expr::in_list(
            "address",
            values.into_iter().map(Into::into),
        ));
        self
    }

    pub fn with_address_not_in(
        mut self,
        values: impl IntoIterator<Item = impl Into<teaql_core::Value>>,
    ) -> Self {
        self.query = self.query.and_filter(Expr::not_in_list(
            "address",
            values.into_iter().map(Into::into),
        ));
        self
    }

    pub fn with_address_containing(mut self, value: impl Into<String>) -> Self {
        self.query = self.query.and_filter(Expr::contain("address", value));
        self
    }

    pub fn with_address_not_containing(mut self, value: impl Into<String>) -> Self {
        self.query = self.query.and_filter(Expr::not_contain("address", value));
        self
    }

    pub fn with_address_starting_with(mut self, value: impl Into<String>) -> Self {
        self.query = self.query.and_filter(Expr::begin_with("address", value));
        self
    }

    pub fn with_address_not_starting_with(mut self, value: impl Into<String>) -> Self {
        self.query = self.query.and_filter(Expr::not_begin_with("address", value));
        self
    }

    pub fn with_address_ending_with(mut self, value: impl Into<String>) -> Self {
        self.query = self.query.and_filter(Expr::end_with("address", value));
        self
    }

    pub fn with_address_not_ending_with(mut self, value: impl Into<String>) -> Self {
        self.query = self.query.and_filter(Expr::not_end_with("address", value));
        self
    }

    pub fn with_address_sounding_like(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::sound_like("address", value));
        self
    }
    pub fn with_address_before(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::lt("address", value));
        self
    }

    pub fn with_address_after(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::gt("address", value));
        self
    }

    pub fn with_address_is_unknown(mut self) -> Self {
        self.query = self.query.and_filter(Expr::is_null("address"));
        self
    }



    pub fn with_address_is_known(mut self) -> Self {
        self.query = self.query.and_filter(Expr::is_not_null("address"));
        self
    }


    pub fn order_by_address_asc(mut self) -> Self {
        self.query = self.query.order_asc("address");
        self
    }

    pub fn order_by_address_desc(mut self) -> Self {
        self.query = self.query.order_desc("address");
        self
    }

    pub fn order_by_address_asc_using_gbk(mut self) -> Self {
        self.query = self.query.order_gbk_asc("address");
        self
    }

    pub fn order_by_address_desc_using_gbk(mut self) -> Self {
        self.query = self.query.order_gbk_desc("address");
        self
    }


    pub fn select_contact_email(mut self) -> Self {
        self.query = self.query.project("contact_email");
        self
    }

    pub fn project_contact_email(self) -> Self {
        self.select_contact_email()
    }

    pub fn select_contact_email_raw(self, raw_sql_segment: impl Into<String>) -> Self {
        self.select_contact_email_unsafe_raw(UnsafeRawSqlSegment::trusted(raw_sql_segment))
    }

    pub fn select_contact_email_unsafe_raw(mut self, raw_sql_segment: UnsafeRawSqlSegment) -> Self {
        self.query_options
            .raw_projections
            .push(RawProjection::new("contact_email", raw_sql_segment));
        self
    }

    pub fn group_by_contact_email(self) -> Self {
        self.group_by("contact_email")
    }

    pub fn group_by_contact_email_as(self, alias: impl Into<String>) -> Self {
        let alias = alias.into();
        let mut request = self.group_by("contact_email");
        request.query = request
            .query
            .project_expr(alias, Expr::column("contact_email"));
        request
    }

    pub fn group_by_contact_email_with_function(
        self,
        alias: impl Into<String>,
        function: AggregateFunction,
    ) -> Self {
        self.group_by("contact_email")
            .aggregate_with_function("contact_email", alias, function)
    }

    pub fn count_contact_email(self) -> Self {
        self.count_contact_email_as("contact_email_count")
    }

    pub fn count_contact_email_as(self, alias: impl Into<String>) -> Self {
        self.aggregate_count_field("contact_email", alias)
    }

    pub fn sum_contact_email(self) -> Self {
        self.sum_contact_email_as("sum_contact_email")
    }

    pub fn sum_contact_email_as(self, alias: impl Into<String>) -> Self {
        self.aggregate_sum("contact_email", alias)
    }

    pub fn avg_contact_email(self) -> Self {
        self.avg_contact_email_as("avg_contact_email")
    }

    pub fn avg_contact_email_as(self, alias: impl Into<String>) -> Self {
        self.aggregate_avg("contact_email", alias)
    }

    pub fn min_contact_email(self) -> Self {
        self.min_contact_email_as("min_contact_email")
    }

    pub fn min_contact_email_as(self, alias: impl Into<String>) -> Self {
        self.aggregate_min("contact_email", alias)
    }

    pub fn max_contact_email(self) -> Self {
        self.max_contact_email_as("max_contact_email")
    }

    pub fn max_contact_email_as(self, alias: impl Into<String>) -> Self {
        self.aggregate_max("contact_email", alias)
    }

    pub fn unselect_contact_email(mut self) -> Self {
        self.query.projection.retain(|field| field != "contact_email");
        self.query_options.raw_projections.retain(|projection| projection.property_name != "contact_email");
        self
    }


    pub fn with_contact_email(
        mut self,
        operator: FieldOperator,
        values: impl IntoIterator<Item = impl Into<teaql_core::Value>>,
    ) -> Self {
        self.query = self.query.and_filter(field_operator_expr(
            "contact_email",
            operator,
            values.into_iter().map(Into::into).collect(),
        ));
        self
    }

    pub fn create_contact_email_criteria(
        operator: FieldOperator,
        values: impl IntoIterator<Item = impl Into<teaql_core::Value>>,
    ) -> Expr {
        field_operator_expr(
            "contact_email",
            operator,
            values.into_iter().map(Into::into).collect(),
        )
    }

    pub fn with_contact_email_is(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::eq("contact_email", value));
        self
    }



    pub fn with_contact_email_is_not(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::ne("contact_email", value));
        self
    }

    pub fn with_contact_email_greater_than(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::gt("contact_email", value));
        self
    }

    pub fn with_contact_email_greater_than_or_equal_to(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::gte("contact_email", value));
        self
    }

    pub fn with_contact_email_less_than(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::lt("contact_email", value));
        self
    }

    pub fn with_contact_email_less_than_or_equal_to(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::lte("contact_email", value));
        self
    }

    pub fn with_contact_email_between(
        mut self,
        lower: impl Into<teaql_core::Value>,
        upper: impl Into<teaql_core::Value>,
    ) -> Self {
        self.query = self.query.and_filter(Expr::between("contact_email", lower, upper));
        self
    }

    pub fn with_contact_email_between_range<T>(mut self, range: DateRange<T>) -> Self
    where
        T: Into<teaql_core::Value>,
    {
        self.query = self.query.and_filter(Expr::between(
            "contact_email",
            range.start,
            range.end,
        ));
        self
    }

    pub fn with_contact_email_in(
        mut self,
        values: impl IntoIterator<Item = impl Into<teaql_core::Value>>,
    ) -> Self {
        self.query = self.query.and_filter(Expr::in_list(
            "contact_email",
            values.into_iter().map(Into::into),
        ));
        self
    }

    pub fn with_contact_email_not_in(
        mut self,
        values: impl IntoIterator<Item = impl Into<teaql_core::Value>>,
    ) -> Self {
        self.query = self.query.and_filter(Expr::not_in_list(
            "contact_email",
            values.into_iter().map(Into::into),
        ));
        self
    }

    pub fn with_contact_email_containing(mut self, value: impl Into<String>) -> Self {
        self.query = self.query.and_filter(Expr::contain("contact_email", value));
        self
    }

    pub fn with_contact_email_not_containing(mut self, value: impl Into<String>) -> Self {
        self.query = self.query.and_filter(Expr::not_contain("contact_email", value));
        self
    }

    pub fn with_contact_email_starting_with(mut self, value: impl Into<String>) -> Self {
        self.query = self.query.and_filter(Expr::begin_with("contact_email", value));
        self
    }

    pub fn with_contact_email_not_starting_with(mut self, value: impl Into<String>) -> Self {
        self.query = self.query.and_filter(Expr::not_begin_with("contact_email", value));
        self
    }

    pub fn with_contact_email_ending_with(mut self, value: impl Into<String>) -> Self {
        self.query = self.query.and_filter(Expr::end_with("contact_email", value));
        self
    }

    pub fn with_contact_email_not_ending_with(mut self, value: impl Into<String>) -> Self {
        self.query = self.query.and_filter(Expr::not_end_with("contact_email", value));
        self
    }

    pub fn with_contact_email_sounding_like(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::sound_like("contact_email", value));
        self
    }
    pub fn with_contact_email_before(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::lt("contact_email", value));
        self
    }

    pub fn with_contact_email_after(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::gt("contact_email", value));
        self
    }

    pub fn with_contact_email_is_unknown(mut self) -> Self {
        self.query = self.query.and_filter(Expr::is_null("contact_email"));
        self
    }



    pub fn with_contact_email_is_known(mut self) -> Self {
        self.query = self.query.and_filter(Expr::is_not_null("contact_email"));
        self
    }


    pub fn order_by_contact_email_asc(mut self) -> Self {
        self.query = self.query.order_asc("contact_email");
        self
    }

    pub fn order_by_contact_email_desc(mut self) -> Self {
        self.query = self.query.order_desc("contact_email");
        self
    }

    pub fn order_by_contact_email_asc_using_gbk(mut self) -> Self {
        self.query = self.query.order_gbk_asc("contact_email");
        self
    }

    pub fn order_by_contact_email_desc_using_gbk(mut self) -> Self {
        self.query = self.query.order_gbk_desc("contact_email");
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


    pub fn select_phone(mut self) -> Self {
        self.query = self.query.project("phone");
        self
    }

    pub fn project_phone(self) -> Self {
        self.select_phone()
    }

    pub fn select_phone_raw(self, raw_sql_segment: impl Into<String>) -> Self {
        self.select_phone_unsafe_raw(UnsafeRawSqlSegment::trusted(raw_sql_segment))
    }

    pub fn select_phone_unsafe_raw(mut self, raw_sql_segment: UnsafeRawSqlSegment) -> Self {
        self.query_options
            .raw_projections
            .push(RawProjection::new("phone", raw_sql_segment));
        self
    }

    pub fn group_by_phone(self) -> Self {
        self.group_by("phone")
    }

    pub fn group_by_phone_as(self, alias: impl Into<String>) -> Self {
        let alias = alias.into();
        let mut request = self.group_by("phone");
        request.query = request
            .query
            .project_expr(alias, Expr::column("phone"));
        request
    }

    pub fn group_by_phone_with_function(
        self,
        alias: impl Into<String>,
        function: AggregateFunction,
    ) -> Self {
        self.group_by("phone")
            .aggregate_with_function("phone", alias, function)
    }

    pub fn count_phone(self) -> Self {
        self.count_phone_as("phone_count")
    }

    pub fn count_phone_as(self, alias: impl Into<String>) -> Self {
        self.aggregate_count_field("phone", alias)
    }

    pub fn sum_phone(self) -> Self {
        self.sum_phone_as("sum_phone")
    }

    pub fn sum_phone_as(self, alias: impl Into<String>) -> Self {
        self.aggregate_sum("phone", alias)
    }

    pub fn avg_phone(self) -> Self {
        self.avg_phone_as("avg_phone")
    }

    pub fn avg_phone_as(self, alias: impl Into<String>) -> Self {
        self.aggregate_avg("phone", alias)
    }

    pub fn min_phone(self) -> Self {
        self.min_phone_as("min_phone")
    }

    pub fn min_phone_as(self, alias: impl Into<String>) -> Self {
        self.aggregate_min("phone", alias)
    }

    pub fn max_phone(self) -> Self {
        self.max_phone_as("max_phone")
    }

    pub fn max_phone_as(self, alias: impl Into<String>) -> Self {
        self.aggregate_max("phone", alias)
    }

    pub fn unselect_phone(mut self) -> Self {
        self.query.projection.retain(|field| field != "phone");
        self.query_options.raw_projections.retain(|projection| projection.property_name != "phone");
        self
    }


    pub fn with_phone(
        mut self,
        operator: FieldOperator,
        values: impl IntoIterator<Item = impl Into<teaql_core::Value>>,
    ) -> Self {
        self.query = self.query.and_filter(field_operator_expr(
            "phone",
            operator,
            values.into_iter().map(Into::into).collect(),
        ));
        self
    }

    pub fn create_phone_criteria(
        operator: FieldOperator,
        values: impl IntoIterator<Item = impl Into<teaql_core::Value>>,
    ) -> Expr {
        field_operator_expr(
            "phone",
            operator,
            values.into_iter().map(Into::into).collect(),
        )
    }

    pub fn with_phone_is(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::eq("phone", value));
        self
    }



    pub fn with_phone_is_not(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::ne("phone", value));
        self
    }

    pub fn with_phone_greater_than(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::gt("phone", value));
        self
    }

    pub fn with_phone_greater_than_or_equal_to(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::gte("phone", value));
        self
    }

    pub fn with_phone_less_than(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::lt("phone", value));
        self
    }

    pub fn with_phone_less_than_or_equal_to(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::lte("phone", value));
        self
    }

    pub fn with_phone_between(
        mut self,
        lower: impl Into<teaql_core::Value>,
        upper: impl Into<teaql_core::Value>,
    ) -> Self {
        self.query = self.query.and_filter(Expr::between("phone", lower, upper));
        self
    }

    pub fn with_phone_between_range<T>(mut self, range: DateRange<T>) -> Self
    where
        T: Into<teaql_core::Value>,
    {
        self.query = self.query.and_filter(Expr::between(
            "phone",
            range.start,
            range.end,
        ));
        self
    }

    pub fn with_phone_in(
        mut self,
        values: impl IntoIterator<Item = impl Into<teaql_core::Value>>,
    ) -> Self {
        self.query = self.query.and_filter(Expr::in_list(
            "phone",
            values.into_iter().map(Into::into),
        ));
        self
    }

    pub fn with_phone_not_in(
        mut self,
        values: impl IntoIterator<Item = impl Into<teaql_core::Value>>,
    ) -> Self {
        self.query = self.query.and_filter(Expr::not_in_list(
            "phone",
            values.into_iter().map(Into::into),
        ));
        self
    }

    pub fn with_phone_containing(mut self, value: impl Into<String>) -> Self {
        self.query = self.query.and_filter(Expr::contain("phone", value));
        self
    }

    pub fn with_phone_not_containing(mut self, value: impl Into<String>) -> Self {
        self.query = self.query.and_filter(Expr::not_contain("phone", value));
        self
    }

    pub fn with_phone_starting_with(mut self, value: impl Into<String>) -> Self {
        self.query = self.query.and_filter(Expr::begin_with("phone", value));
        self
    }

    pub fn with_phone_not_starting_with(mut self, value: impl Into<String>) -> Self {
        self.query = self.query.and_filter(Expr::not_begin_with("phone", value));
        self
    }

    pub fn with_phone_ending_with(mut self, value: impl Into<String>) -> Self {
        self.query = self.query.and_filter(Expr::end_with("phone", value));
        self
    }

    pub fn with_phone_not_ending_with(mut self, value: impl Into<String>) -> Self {
        self.query = self.query.and_filter(Expr::not_end_with("phone", value));
        self
    }

    pub fn with_phone_sounding_like(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::sound_like("phone", value));
        self
    }
    pub fn with_phone_before(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::lt("phone", value));
        self
    }

    pub fn with_phone_after(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::gt("phone", value));
        self
    }

    pub fn with_phone_is_unknown(mut self) -> Self {
        self.query = self.query.and_filter(Expr::is_null("phone"));
        self
    }



    pub fn with_phone_is_known(mut self) -> Self {
        self.query = self.query.and_filter(Expr::is_not_null("phone"));
        self
    }


    pub fn order_by_phone_asc(mut self) -> Self {
        self.query = self.query.order_asc("phone");
        self
    }

    pub fn order_by_phone_desc(mut self) -> Self {
        self.query = self.query.order_desc("phone");
        self
    }

    pub fn order_by_phone_asc_using_gbk(mut self) -> Self {
        self.query = self.query.order_gbk_asc("phone");
        self
    }

    pub fn order_by_phone_desc_using_gbk(mut self) -> Self {
        self.query = self.query.order_gbk_desc("phone");
        self
    }


    pub fn select_rating(mut self) -> Self {
        self.query = self.query.project("rating");
        self
    }

    pub fn project_rating(self) -> Self {
        self.select_rating()
    }

    pub fn select_rating_raw(self, raw_sql_segment: impl Into<String>) -> Self {
        self.select_rating_unsafe_raw(UnsafeRawSqlSegment::trusted(raw_sql_segment))
    }

    pub fn select_rating_unsafe_raw(mut self, raw_sql_segment: UnsafeRawSqlSegment) -> Self {
        self.query_options
            .raw_projections
            .push(RawProjection::new("rating", raw_sql_segment));
        self
    }

    pub fn select_rating_with_function(self, function: AggregateFunction) -> Self {
        self.select_rating_as_with_function("rating", function)
    }

    pub fn select_rating_as_with_function(
        self,
        alias: impl Into<String>,
        function: AggregateFunction,
    ) -> Self {
        self.aggregate_with_function("rating", alias, function)
    }

    pub fn group_by_rating(self) -> Self {
        self.group_by("rating")
    }

    pub fn group_by_rating_as(self, alias: impl Into<String>) -> Self {
        let alias = alias.into();
        let mut request = self.group_by("rating");
        request.query = request
            .query
            .project_expr(alias, Expr::column("rating"));
        request
    }

    pub fn group_by_rating_with_function(
        self,
        alias: impl Into<String>,
        function: AggregateFunction,
    ) -> Self {
        self.group_by("rating")
            .aggregate_with_function("rating", alias, function)
    }

    pub fn count_rating(self) -> Self {
        self.count_rating_as("rating_count")
    }

    pub fn count_rating_as(self, alias: impl Into<String>) -> Self {
        self.aggregate_count_field("rating", alias)
    }

    pub fn sum_rating(self) -> Self {
        self.sum_rating_as("sum_rating")
    }

    pub fn sum_rating_as(self, alias: impl Into<String>) -> Self {
        self.aggregate_sum("rating", alias)
    }

    pub fn avg_rating(self) -> Self {
        self.avg_rating_as("avg_rating")
    }

    pub fn avg_rating_as(self, alias: impl Into<String>) -> Self {
        self.aggregate_avg("rating", alias)
    }

    pub fn min_rating(self) -> Self {
        self.min_rating_as("min_rating")
    }

    pub fn min_rating_as(self, alias: impl Into<String>) -> Self {
        self.aggregate_min("rating", alias)
    }

    pub fn max_rating(self) -> Self {
        self.max_rating_as("max_rating")
    }

    pub fn max_rating_as(self, alias: impl Into<String>) -> Self {
        self.aggregate_max("rating", alias)
    }

    pub fn standard_deviation_rating(self) -> Self {
        self.standard_deviation_rating_as("stdDev_rating")
    }

    pub fn standard_deviation_rating_as(self, alias: impl Into<String>) -> Self {
        self.aggregate_stddev("rating", alias)
    }

    pub fn square_root_of_population_standard_deviation_rating(self) -> Self {
        self.square_root_of_population_standard_deviation_rating_as("stdDevPop_rating")
    }

    pub fn square_root_of_population_standard_deviation_rating_as(self, alias: impl Into<String>) -> Self {
        self.aggregate_stddev_pop("rating", alias)
    }

    pub fn sample_variance_rating(self) -> Self {
        self.sample_variance_rating_as("varSamp_rating")
    }

    pub fn sample_variance_rating_as(self, alias: impl Into<String>) -> Self {
        self.aggregate_var_samp("rating", alias)
    }

    pub fn sample_population_variance_rating(self) -> Self {
        self.sample_population_variance_rating_as("varPop_rating")
    }

    pub fn sample_population_variance_rating_as(self, alias: impl Into<String>) -> Self {
        self.aggregate_var_pop("rating", alias)
    }

    pub fn unselect_rating(mut self) -> Self {
        self.query.projection.retain(|field| field != "rating");
        self.query_options.raw_projections.retain(|projection| projection.property_name != "rating");
        self
    }


    pub fn with_rating(
        mut self,
        operator: FieldOperator,
        values: impl IntoIterator<Item = impl Into<teaql_core::Value>>,
    ) -> Self {
        self.query = self.query.and_filter(field_operator_expr(
            "rating",
            operator,
            values.into_iter().map(Into::into).collect(),
        ));
        self
    }

    pub fn create_rating_criteria(
        operator: FieldOperator,
        values: impl IntoIterator<Item = impl Into<teaql_core::Value>>,
    ) -> Expr {
        field_operator_expr(
            "rating",
            operator,
            values.into_iter().map(Into::into).collect(),
        )
    }

    pub fn with_rating_is(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::eq("rating", value));
        self
    }



    pub fn with_rating_is_not(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::ne("rating", value));
        self
    }

    pub fn with_rating_greater_than(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::gt("rating", value));
        self
    }

    pub fn with_rating_greater_than_or_equal_to(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::gte("rating", value));
        self
    }

    pub fn with_rating_less_than(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::lt("rating", value));
        self
    }

    pub fn with_rating_less_than_or_equal_to(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::lte("rating", value));
        self
    }

    pub fn with_rating_between(
        mut self,
        lower: impl Into<teaql_core::Value>,
        upper: impl Into<teaql_core::Value>,
    ) -> Self {
        self.query = self.query.and_filter(Expr::between("rating", lower, upper));
        self
    }

    pub fn with_rating_between_range<T>(mut self, range: DateRange<T>) -> Self
    where
        T: Into<teaql_core::Value>,
    {
        self.query = self.query.and_filter(Expr::between(
            "rating",
            range.start,
            range.end,
        ));
        self
    }

    pub fn with_rating_in(
        mut self,
        values: impl IntoIterator<Item = impl Into<teaql_core::Value>>,
    ) -> Self {
        self.query = self.query.and_filter(Expr::in_list(
            "rating",
            values.into_iter().map(Into::into),
        ));
        self
    }

    pub fn with_rating_not_in(
        mut self,
        values: impl IntoIterator<Item = impl Into<teaql_core::Value>>,
    ) -> Self {
        self.query = self.query.and_filter(Expr::not_in_list(
            "rating",
            values.into_iter().map(Into::into),
        ));
        self
    }

    pub fn with_rating_before(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::lt("rating", value));
        self
    }

    pub fn with_rating_after(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::gt("rating", value));
        self
    }

    pub fn with_rating_is_unknown(mut self) -> Self {
        self.query = self.query.and_filter(Expr::is_null("rating"));
        self
    }



    pub fn with_rating_is_known(mut self) -> Self {
        self.query = self.query.and_filter(Expr::is_not_null("rating"));
        self
    }


    pub fn order_by_rating_asc(mut self) -> Self {
        self.query = self.query.order_asc("rating");
        self
    }

    pub fn order_by_rating_desc(mut self) -> Self {
        self.query = self.query.order_desc("rating");
        self
    }

    pub fn order_by_rating_asc_using_gbk(mut self) -> Self {
        self.query = self.query.order_gbk_asc("rating");
        self
    }

    pub fn order_by_rating_desc_using_gbk(mut self) -> Self {
        self.query = self.query.order_gbk_desc("rating");
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
    pub fn address_is_address_value(self) -> Self {
        self.with_address_is("address_value")
    }

    pub fn with_address_is_address_value(self) -> Self {
        self.with_address_is("address_value")
    }



    pub fn with_address_is_not_address_value(self) -> Self {
        self.with_address_is_not("address_value")
    }



    pub fn contact_email_is_contact_email_value(self) -> Self {
        self.with_contact_email_is("contact_email_value")
    }

    pub fn with_contact_email_is_contact_email_value(self) -> Self {
        self.with_contact_email_is("contact_email_value")
    }



    pub fn with_contact_email_is_not_contact_email_value(self) -> Self {
        self.with_contact_email_is_not("contact_email_value")
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



    pub fn phone_is_phone_value(self) -> Self {
        self.with_phone_is("phone_value")
    }

    pub fn with_phone_is_phone_value(self) -> Self {
        self.with_phone_is("phone_value")
    }



    pub fn with_phone_is_not_phone_value(self) -> Self {
        self.with_phone_is_not("phone_value")
    }



    pub fn rating_is_value_100_00(self) -> Self {
        self.with_rating_is("100.00")
    }

    pub fn with_rating_is_value_100_00(self) -> Self {
        self.with_rating_is("100.00")
    }



    pub fn with_rating_is_not_value_100_00(self) -> Self {
        self.with_rating_is_not("100.00")
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




    pub fn have_purchase_orders(self) -> Self {
        self.with_purchase_order_list_matching(SelectQuery::new("PurchaseOrder"))
    }

    pub fn have_no_purchase_orders(self) -> Self {
        self.without_purchase_order_list_matching(SelectQuery::new("PurchaseOrder"))
    }

    pub fn with_purchase_order_list_matching(mut self, request: impl Into<QuerySelection>) -> Self {
        let selection = request.into();
        self.query = self.query.and_filter(Expr::in_subquery(
            "id",
            <crate::PurchaseOrder as teaql_core::TeaqlEntity>::entity_descriptor(),
            selection.query.clone(),
            "supplier_id",
        ));
        self.relation_filters.push(RelationFilter::new("purchase_order_list", selection));
        self
    }

    pub fn without_purchase_order_list_matching(mut self, request: impl Into<QuerySelection>) -> Self {
        let selection = request.into();
        self.query = self.query.and_filter(Expr::not_in_subquery(
            "id",
            <crate::PurchaseOrder as teaql_core::TeaqlEntity>::entity_descriptor(),
            selection.query.clone(),
            "supplier_id",
        ));
        self.relation_filters.push(RelationFilter::new("purchase_order_list", selection));
        self
    }

    pub fn select_purchase_order_list(mut self) -> Self {
        self.query = self.query.relation("purchase_order_list");
        self
    }

    pub fn select_purchase_order_list_with(mut self, request: impl Into<QuerySelection>) -> Self {
        let selection = request.into();
        self.query = self.query.relation_query("purchase_order_list", selection.clone().into_query());
        self.relation_selections.push(RelationSelection::new("purchase_order_list", selection));
        self
}
    pub fn count_purchase_orders(self) -> Self {
        self.count_purchase_orders_as("count_purchase_orders")
    }

    pub fn count_purchase_orders_as(self, alias: impl Into<String>) -> Self {
        self.count_purchase_orders_with(alias, crate::Q::purchase_orders().unlimited())
    }

    pub fn count_purchase_orders_with(mut self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        let selection = request.into();
        self.query_options.relation_aggregates.push(RelationAggregate::new(
            "purchase_order_list",
            alias,
            selection,
            true,
        ));
        self
    }

    pub fn stats_from_purchase_orders(self, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_purchase_orders_as("refinements", request)
    }

    pub fn stats_from_purchase_orders_as(mut self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        let selection = request.into();
        self.query_options.relation_aggregates.push(RelationAggregate::new(
            "purchase_order_list",
            alias,
            selection,
            false,
        ));
        self
    }

    pub fn group_by_purchase_orders_with_details(self, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_purchase_orders(request)
    }


    pub fn min_order_date_of_purchase_orders(self) -> Self {
        self.min_order_date_of_purchase_orders_as("min_order_date_of_purchase_orders", crate::Q::purchase_orders().unlimited())
    }

    pub fn min_order_date_of_purchase_orders_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_purchase_orders_as(alias, request.into().into_query().min("order_date", "min_order_date"))
    }
    pub fn max_order_date_of_purchase_orders(self) -> Self {
        self.max_order_date_of_purchase_orders_as("max_order_date_of_purchase_orders", crate::Q::purchase_orders().unlimited())
    }

    pub fn max_order_date_of_purchase_orders_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_purchase_orders_as(alias, request.into().into_query().max("order_date", "max_order_date"))
    }
    pub fn sum_total_cost_of_purchase_orders(self) -> Self {
        self.sum_total_cost_of_purchase_orders_as("sum_total_cost_of_purchase_orders", crate::Q::purchase_orders().unlimited())
    }

    pub fn sum_total_cost_of_purchase_orders_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_purchase_orders_as(alias, request.into().into_query().sum("total_cost", "sum_total_cost"))
    }
    pub fn min_total_cost_of_purchase_orders(self) -> Self {
        self.min_total_cost_of_purchase_orders_as("min_total_cost_of_purchase_orders", crate::Q::purchase_orders().unlimited())
    }

    pub fn min_total_cost_of_purchase_orders_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_purchase_orders_as(alias, request.into().into_query().min("total_cost", "min_total_cost"))
    }
    pub fn max_total_cost_of_purchase_orders(self) -> Self {
        self.max_total_cost_of_purchase_orders_as("max_total_cost_of_purchase_orders", crate::Q::purchase_orders().unlimited())
    }

    pub fn max_total_cost_of_purchase_orders_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_purchase_orders_as(alias, request.into().into_query().max("total_cost", "max_total_cost"))
    }
    pub fn avg_total_cost_of_purchase_orders(self) -> Self {
        self.avg_total_cost_of_purchase_orders_as("avg_total_cost_of_purchase_orders", crate::Q::purchase_orders().unlimited())
    }

    pub fn avg_total_cost_of_purchase_orders_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_purchase_orders_as(alias, request.into().into_query().avg("total_cost", "avg_total_cost"))
    }
    pub fn standard_deviation_total_cost_of_purchase_orders(self) -> Self {
        self.standard_deviation_total_cost_of_purchase_orders_as("standard_deviation_total_cost_of_purchase_orders", crate::Q::purchase_orders().unlimited())
    }

    pub fn standard_deviation_total_cost_of_purchase_orders_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_purchase_orders_as(alias, request.into().into_query().stddev("total_cost", "stdDev_total_cost"))
    }
    pub fn square_root_of_population_standard_deviation_total_cost_of_purchase_orders(self) -> Self {
        self.square_root_of_population_standard_deviation_total_cost_of_purchase_orders_as("square_root_of_population_standard_deviation_total_cost_of_purchase_orders", crate::Q::purchase_orders().unlimited())
    }

    pub fn square_root_of_population_standard_deviation_total_cost_of_purchase_orders_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_purchase_orders_as(alias, request.into().into_query().stddev_pop("total_cost", "stdDevPop_total_cost"))
    }
    pub fn sample_variance_total_cost_of_purchase_orders(self) -> Self {
        self.sample_variance_total_cost_of_purchase_orders_as("sample_variance_total_cost_of_purchase_orders", crate::Q::purchase_orders().unlimited())
    }

    pub fn sample_variance_total_cost_of_purchase_orders_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_purchase_orders_as(alias, request.into().into_query().var_samp("total_cost", "varSamp_total_cost"))
    }
    pub fn sample_population_variance_total_cost_of_purchase_orders(self) -> Self {
        self.sample_population_variance_total_cost_of_purchase_orders_as("sample_population_variance_total_cost_of_purchase_orders", crate::Q::purchase_orders().unlimited())
    }

    pub fn sample_population_variance_total_cost_of_purchase_orders_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_purchase_orders_as(alias, request.into().into_query().var_pop("total_cost", "varPop_total_cost"))
    }
    pub fn min_create_time_of_purchase_orders(self) -> Self {
        self.min_create_time_of_purchase_orders_as("min_create_time_of_purchase_orders", crate::Q::purchase_orders().unlimited())
    }

    pub fn min_create_time_of_purchase_orders_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_purchase_orders_as(alias, request.into().into_query().min("create_time", "min_create_time"))
    }
    pub fn max_create_time_of_purchase_orders(self) -> Self {
        self.max_create_time_of_purchase_orders_as("max_create_time_of_purchase_orders", crate::Q::purchase_orders().unlimited())
    }

    pub fn max_create_time_of_purchase_orders_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_purchase_orders_as(alias, request.into().into_query().max("create_time", "max_create_time"))
    }
    pub fn min_update_time_of_purchase_orders(self) -> Self {
        self.min_update_time_of_purchase_orders_as("min_update_time_of_purchase_orders", crate::Q::purchase_orders().unlimited())
    }

    pub fn min_update_time_of_purchase_orders_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_purchase_orders_as(alias, request.into().into_query().min("update_time", "min_update_time"))
    }
    pub fn max_update_time_of_purchase_orders(self) -> Self {
        self.max_update_time_of_purchase_orders_as("max_update_time_of_purchase_orders", crate::Q::purchase_orders().unlimited())
    }

    pub fn max_update_time_of_purchase_orders_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_purchase_orders_as(alias, request.into().into_query().max("update_time", "max_update_time"))
    }
}

impl<R> Default for SupplierRequest<R> {
    fn default() -> Self {
        Self::new()
    }
}

impl<R> From< SupplierRequest<R> > for SelectQuery {
    fn from(request: SupplierRequest<R>) -> Self {
        QuerySelection::from(request).into_query()
    }
}

impl<R> From< SupplierRequest<R> > for QuerySelection {
    fn from(request: SupplierRequest<R>) -> Self {
        Self {
            query: request.query,
            relation_selections: request.relation_selections,
            relation_filters: request.relation_filters,
            child_enhancements: request.child_enhancements,
            query_options: request.query_options,
        }
    }
}


impl<'a, C> crate::request_support::AuditedSave<'a, C> for teaql_core::Audited<crate::Supplier> 
where C: crate::request_support::TeaqlRepositoryProvider + ?Sized + 'a
{
    type Error = crate::TeaqlDataServiceError<C::SupplierRepository<'a>>;
    fn save(self, ctx: &'a C) -> std::pin::Pin<Box<dyn std::future::Future<Output = Result<teaql_runtime::GraphNode, Self::Error>> + '_>> {
        Box::pin(async move {
            teaql_runtime::save_audited_ledger_entity(self, ctx.user_context())
                .await
                .map_err(DataServiceError::Runtime)
        })
    }
}

impl<R: teaql_core::Entity> crate::PurposedQuery<SupplierRequest<R>> {
    pub fn new_entity<C>(&self, ctx: &C) -> crate::Supplier
    where
        C: crate::TeaqlRuntime + ?Sized,
    {
        crate::Supplier::runtime_new(ctx.user_context().entity_root())
    }

    fn into_inner_with_trace(mut self) -> SupplierRequest<R> {
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
    ) -> Result<teaql_core::SmartList<R>, crate::request_support::TeaqlDataServiceError<C::SupplierRepository<'a>>>
    where
        C: crate::request_support::TeaqlRepositoryProvider + ?Sized,
    {
        self.into_inner_with_trace()._execute_for_page(ctx, offset, limit).await
    }

    pub async fn execute_for_exists<'a, C>(
        self,
        ctx: &'a C,
    ) -> Result<bool, crate::request_support::TeaqlDataServiceError<C::SupplierRepository<'a>>>
    where
        C: crate::request_support::TeaqlRepositoryProvider + ?Sized,
    {
        self.into_inner_with_trace()._execute_for_exists(ctx).await
    }

    pub async fn execute_for_list<'a, C>(self, ctx: &'a C) -> Result<teaql_core::SmartList<R>, crate::request_support::TeaqlDataServiceError<C::SupplierRepository<'a>>>
    where
        C: crate::request_support::TeaqlRepositoryProvider + ?Sized,
    {
        self.into_inner_with_trace()._execute_for_list(ctx).await
    }

    /// Execute query in streaming mode (chunked).
    /// Returns a Vec of StreamChunk, each containing up to chunk_size rows.
    /// Set chunk size via .stream(chunk_size) or .stream_default() on the query.
    pub async fn execute_for_stream<'a, C>(self, ctx: &'a C) -> Result<Vec<teaql_data_service::StreamChunk>, crate::request_support::TeaqlDataServiceError<C::SupplierRepository<'a>>>
    where
        C: crate::request_support::TeaqlRepositoryProvider + ?Sized,
    {
        self.into_inner_with_trace()._execute_for_stream(ctx).await
    }

    pub async fn execute_for_first<'a, C>(self, ctx: &'a C) -> Result<Option<R>, crate::request_support::TeaqlDataServiceError<C::SupplierRepository<'a>>>
    where
        C: crate::request_support::TeaqlRepositoryProvider + ?Sized,
    {
        self.into_inner_with_trace()._execute_for_first(ctx).await
    }

    pub async fn execute_for_one<'a, C>(self, ctx: &'a C) -> Result<Option<R>, crate::request_support::TeaqlDataServiceError<C::SupplierRepository<'a>>>
    where
        C: crate::request_support::TeaqlRepositoryProvider + ?Sized,
    {
        self.into_inner_with_trace()._execute_for_one(ctx).await
    }


    pub async fn execute_for_records<'a, C>(self, ctx: &'a C) -> Result<teaql_core::SmartList<teaql_core::Record>, crate::request_support::TeaqlDataServiceError<C::SupplierRepository<'a>>>
    where
        C: crate::request_support::TeaqlRepositoryProvider + ?Sized,
    {
        self.into_inner_with_trace()._execute_for_records(ctx).await
    }

    pub async fn execute_for_record<'a, C>(self, ctx: &'a C) -> Result<Option<teaql_core::Record>, crate::request_support::TeaqlDataServiceError<C::SupplierRepository<'a>>>
    where
        C: crate::request_support::TeaqlRepositoryProvider + ?Sized,
    {
        self.into_inner_with_trace()._execute_for_record(ctx).await
    }

    pub async fn execute_for_count<'a, C>(self, ctx: &'a C) -> Result<u64, crate::request_support::TeaqlDataServiceError<C::SupplierRepository<'a>>>
    where
        C: crate::request_support::TeaqlRepositoryProvider + ?Sized,
    {
        self.into_inner_with_trace()._execute_for_count(ctx).await
    }
}
