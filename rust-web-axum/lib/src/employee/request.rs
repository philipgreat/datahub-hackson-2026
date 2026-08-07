use std::marker::PhantomData;

use serde_json::Value as JsonValue;
use teaql_core::{Aggregate, AggregateFunction, EntityDescriptor, Expr, Record, SelectQuery, SmartList};
use teaql_runtime::{DataServiceError, RuntimeError};

use crate::request_support::*;

impl EntityReference for crate::Employee {
    fn entity_id_value(self) -> teaql_core::Value {
        teaql_core::IdentifiableEntity::id_value(&self)
    }
}

impl EntityReference for &crate::Employee {
    fn entity_id_value(self) -> teaql_core::Value {
        teaql_core::IdentifiableEntity::id_value(self)
    }
}

// ⛔ AI agents: DO NOT read this file for API discovery. Instead run: cargo teaql --input modeling/MODEL.xml rust-assist-query/employee
#[derive(Debug)]
pub struct EmployeeRequest<R = crate::Employee> {
    query: SelectQuery,
    relation_selections: Vec<RelationSelection>,
    relation_filters: Vec<RelationFilter>,
    child_enhancements: Vec<QuerySelection>,
    query_options: QueryOptions,
    marker: PhantomData<R>,
}

impl<R> Clone for EmployeeRequest<R> {
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

impl<R> EmployeeRequest<R> {
    pub(crate) fn new() -> Self {
        Self {
            query: SelectQuery::new("Employee")
                .project("id")
                .project("version"),
            relation_selections: Vec::new(),
            relation_filters: Vec::new(),
            child_enhancements: Vec::new(),
            query_options: QueryOptions::default(),
            marker: PhantomData,
        }
    }

    pub fn return_type<T>(self) -> EmployeeRequest<T> {
        EmployeeRequest {
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
    ) -> Result<SmartList<R>, TeaqlDataServiceError<C::EmployeeRepository<'a>>>
    where
        C: TeaqlRepositoryProvider + ?Sized,
        R: teaql_core::Entity,
    {
        let repository = ctx
            .employee_repository()
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
    ) -> Result<Vec<teaql_data_service::StreamChunk>, TeaqlDataServiceError<C::EmployeeRepository<'a>>>
    where
        C: TeaqlRepositoryProvider + ?Sized,
    {
        let repository = ctx
            .employee_repository()
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
    ) -> Result<Option<R>, TeaqlDataServiceError<C::EmployeeRepository<'a>>>
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
    ) -> Result<Option<R>, TeaqlDataServiceError<C::EmployeeRepository<'a>>>
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
    ) -> Result<SmartList<R>, TeaqlDataServiceError<C::EmployeeRepository<'a>>>
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
    ) -> Result<u64, TeaqlDataServiceError<C::EmployeeRepository<'a>>>
    where
        C: TeaqlRepositoryProvider + ?Sized,
    {
        let repository = ctx
            .employee_repository()
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
            .ok_or_else(|| DataServiceError::Runtime(RuntimeError::Graph(format!("count result for Employee is missing or not numeric"))))
    }

    pub(crate) async fn _execute_for_exists<'a, C>(
        self,
        ctx: &'a C,
    ) -> Result<bool, TeaqlDataServiceError<C::EmployeeRepository<'a>>>
    where
        C: TeaqlRepositoryProvider + ?Sized,
    {
        let repository = ctx
            .employee_repository()
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
    ) -> Result<SmartList<Record>, TeaqlDataServiceError<C::EmployeeRepository<'a>>>
    where
        C: TeaqlRepositoryProvider + ?Sized,
    {
        let repository = ctx
            .employee_repository()
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
    ) -> Result<Option<Record>, TeaqlDataServiceError<C::EmployeeRepository<'a>>>
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
            "email" => Some("email"),
            "name" => Some("name"),
            "phone" => Some("phone"),
            "salary" => Some("salary"),
            "ssn" => Some("ssn"),
            "hire_date" => Some("hire_date"),
            "status" => Some("status"),
            "create_time" => Some("create_time"),
            "update_time" => Some("update_time"),
            "version" => Some("version"),
            "department" | "department_id" => Some("department_id"),
            _ => None,
        }
    }

    fn apply_dynamic_json_chain_filter(self, head: &str, tail: &str, value: &JsonValue) -> Self {
        let _ = (tail, value);
        match head {
            "department" => {
                self.with_department_matching(
                    crate::Q::departments_minimal()
                        .apply_dynamic_json_filter(tail, value),
                )
            }
            "leave_request_list" => {
                self.with_leave_request_list_matching(
                    crate::Q::leave_requests_minimal()
                        .apply_dynamic_json_filter(tail, value),
                )
            }
            "attendance_list" => {
                self.with_attendance_list_matching(
                    crate::Q::attendances_minimal()
                        .apply_dynamic_json_filter(tail, value),
                )
            }
            "benefit_list" => {
                self.with_benefit_list_matching(
                    crate::Q::benefits_minimal()
                        .apply_dynamic_json_filter(tail, value),
                )
            }
            "employee_review_list" => {
                self.with_employee_review_list_matching(
                    crate::Q::employee_reviews_minimal()
                        .apply_dynamic_json_filter(tail, value),
                )
            }
            "payroll_list" => {
                self.with_payroll_list_matching(
                    crate::Q::payrolls_minimal()
                        .apply_dynamic_json_filter(tail, value),
                )
            }
            "expense_list" => {
                self.with_expense_list_matching(
                    crate::Q::expenses_minimal()
                        .apply_dynamic_json_filter(tail, value),
                )
            }
            "support_agent_list" => {
                self.with_support_agent_list_matching(
                    crate::Q::support_agents_minimal()
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
        self.query = self.query.project("email");
        self.query = self.query.project("name");
        self.query = self.query.project("phone");
        self.query = self.query.project("salary");
        self.query = self.query.project("ssn");
        self.query = self.query.project("hire_date");
        self.query = self.query.project("status");
        self.query = self.query.project("create_time");
        self.query = self.query.project("update_time");
        self.query = self.query.project("version");
        self.query = self.query.project("department_id");
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
        request = request.select_department();
        request
    }

    pub fn select_children(self) -> Self {
        let mut request = self.select_all();
        request = request.select_leave_request_list();
        request = request.select_attendance_list();
        request = request.select_benefit_list();
        request = request.select_employee_review_list();
        request = request.select_payroll_list();
        request = request.select_expense_list();
        request = request.select_support_agent_list();
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


    pub fn select_email(mut self) -> Self {
        self.query = self.query.project("email");
        self
    }

    pub fn project_email(self) -> Self {
        self.select_email()
    }

    pub fn select_email_raw(self, raw_sql_segment: impl Into<String>) -> Self {
        self.select_email_unsafe_raw(UnsafeRawSqlSegment::trusted(raw_sql_segment))
    }

    pub fn select_email_unsafe_raw(mut self, raw_sql_segment: UnsafeRawSqlSegment) -> Self {
        self.query_options
            .raw_projections
            .push(RawProjection::new("email", raw_sql_segment));
        self
    }

    pub fn group_by_email(self) -> Self {
        self.group_by("email")
    }

    pub fn group_by_email_as(self, alias: impl Into<String>) -> Self {
        let alias = alias.into();
        let mut request = self.group_by("email");
        request.query = request
            .query
            .project_expr(alias, Expr::column("email"));
        request
    }

    pub fn group_by_email_with_function(
        self,
        alias: impl Into<String>,
        function: AggregateFunction,
    ) -> Self {
        self.group_by("email")
            .aggregate_with_function("email", alias, function)
    }

    pub fn count_email(self) -> Self {
        self.count_email_as("email_count")
    }

    pub fn count_email_as(self, alias: impl Into<String>) -> Self {
        self.aggregate_count_field("email", alias)
    }

    pub fn sum_email(self) -> Self {
        self.sum_email_as("sum_email")
    }

    pub fn sum_email_as(self, alias: impl Into<String>) -> Self {
        self.aggregate_sum("email", alias)
    }

    pub fn avg_email(self) -> Self {
        self.avg_email_as("avg_email")
    }

    pub fn avg_email_as(self, alias: impl Into<String>) -> Self {
        self.aggregate_avg("email", alias)
    }

    pub fn min_email(self) -> Self {
        self.min_email_as("min_email")
    }

    pub fn min_email_as(self, alias: impl Into<String>) -> Self {
        self.aggregate_min("email", alias)
    }

    pub fn max_email(self) -> Self {
        self.max_email_as("max_email")
    }

    pub fn max_email_as(self, alias: impl Into<String>) -> Self {
        self.aggregate_max("email", alias)
    }

    pub fn unselect_email(mut self) -> Self {
        self.query.projection.retain(|field| field != "email");
        self.query_options.raw_projections.retain(|projection| projection.property_name != "email");
        self
    }


    pub fn with_email(
        mut self,
        operator: FieldOperator,
        values: impl IntoIterator<Item = impl Into<teaql_core::Value>>,
    ) -> Self {
        self.query = self.query.and_filter(field_operator_expr(
            "email",
            operator,
            values.into_iter().map(Into::into).collect(),
        ));
        self
    }

    pub fn create_email_criteria(
        operator: FieldOperator,
        values: impl IntoIterator<Item = impl Into<teaql_core::Value>>,
    ) -> Expr {
        field_operator_expr(
            "email",
            operator,
            values.into_iter().map(Into::into).collect(),
        )
    }

    pub fn with_email_is(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::eq("email", value));
        self
    }



    pub fn with_email_is_not(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::ne("email", value));
        self
    }

    pub fn with_email_greater_than(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::gt("email", value));
        self
    }

    pub fn with_email_greater_than_or_equal_to(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::gte("email", value));
        self
    }

    pub fn with_email_less_than(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::lt("email", value));
        self
    }

    pub fn with_email_less_than_or_equal_to(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::lte("email", value));
        self
    }

    pub fn with_email_between(
        mut self,
        lower: impl Into<teaql_core::Value>,
        upper: impl Into<teaql_core::Value>,
    ) -> Self {
        self.query = self.query.and_filter(Expr::between("email", lower, upper));
        self
    }

    pub fn with_email_between_range<T>(mut self, range: DateRange<T>) -> Self
    where
        T: Into<teaql_core::Value>,
    {
        self.query = self.query.and_filter(Expr::between(
            "email",
            range.start,
            range.end,
        ));
        self
    }

    pub fn with_email_in(
        mut self,
        values: impl IntoIterator<Item = impl Into<teaql_core::Value>>,
    ) -> Self {
        self.query = self.query.and_filter(Expr::in_list(
            "email",
            values.into_iter().map(Into::into),
        ));
        self
    }

    pub fn with_email_not_in(
        mut self,
        values: impl IntoIterator<Item = impl Into<teaql_core::Value>>,
    ) -> Self {
        self.query = self.query.and_filter(Expr::not_in_list(
            "email",
            values.into_iter().map(Into::into),
        ));
        self
    }

    pub fn with_email_containing(mut self, value: impl Into<String>) -> Self {
        self.query = self.query.and_filter(Expr::contain("email", value));
        self
    }

    pub fn with_email_not_containing(mut self, value: impl Into<String>) -> Self {
        self.query = self.query.and_filter(Expr::not_contain("email", value));
        self
    }

    pub fn with_email_starting_with(mut self, value: impl Into<String>) -> Self {
        self.query = self.query.and_filter(Expr::begin_with("email", value));
        self
    }

    pub fn with_email_not_starting_with(mut self, value: impl Into<String>) -> Self {
        self.query = self.query.and_filter(Expr::not_begin_with("email", value));
        self
    }

    pub fn with_email_ending_with(mut self, value: impl Into<String>) -> Self {
        self.query = self.query.and_filter(Expr::end_with("email", value));
        self
    }

    pub fn with_email_not_ending_with(mut self, value: impl Into<String>) -> Self {
        self.query = self.query.and_filter(Expr::not_end_with("email", value));
        self
    }

    pub fn with_email_sounding_like(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::sound_like("email", value));
        self
    }
    pub fn with_email_before(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::lt("email", value));
        self
    }

    pub fn with_email_after(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::gt("email", value));
        self
    }

    pub fn with_email_is_unknown(mut self) -> Self {
        self.query = self.query.and_filter(Expr::is_null("email"));
        self
    }



    pub fn with_email_is_known(mut self) -> Self {
        self.query = self.query.and_filter(Expr::is_not_null("email"));
        self
    }


    pub fn order_by_email_asc(mut self) -> Self {
        self.query = self.query.order_asc("email");
        self
    }

    pub fn order_by_email_desc(mut self) -> Self {
        self.query = self.query.order_desc("email");
        self
    }

    pub fn order_by_email_asc_using_gbk(mut self) -> Self {
        self.query = self.query.order_gbk_asc("email");
        self
    }

    pub fn order_by_email_desc_using_gbk(mut self) -> Self {
        self.query = self.query.order_gbk_desc("email");
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


    pub fn select_salary(mut self) -> Self {
        self.query = self.query.project("salary");
        self
    }

    pub fn project_salary(self) -> Self {
        self.select_salary()
    }

    pub fn select_salary_raw(self, raw_sql_segment: impl Into<String>) -> Self {
        self.select_salary_unsafe_raw(UnsafeRawSqlSegment::trusted(raw_sql_segment))
    }

    pub fn select_salary_unsafe_raw(mut self, raw_sql_segment: UnsafeRawSqlSegment) -> Self {
        self.query_options
            .raw_projections
            .push(RawProjection::new("salary", raw_sql_segment));
        self
    }

    pub fn select_salary_with_function(self, function: AggregateFunction) -> Self {
        self.select_salary_as_with_function("salary", function)
    }

    pub fn select_salary_as_with_function(
        self,
        alias: impl Into<String>,
        function: AggregateFunction,
    ) -> Self {
        self.aggregate_with_function("salary", alias, function)
    }

    pub fn group_by_salary(self) -> Self {
        self.group_by("salary")
    }

    pub fn group_by_salary_as(self, alias: impl Into<String>) -> Self {
        let alias = alias.into();
        let mut request = self.group_by("salary");
        request.query = request
            .query
            .project_expr(alias, Expr::column("salary"));
        request
    }

    pub fn group_by_salary_with_function(
        self,
        alias: impl Into<String>,
        function: AggregateFunction,
    ) -> Self {
        self.group_by("salary")
            .aggregate_with_function("salary", alias, function)
    }

    pub fn count_salary(self) -> Self {
        self.count_salary_as("salary_count")
    }

    pub fn count_salary_as(self, alias: impl Into<String>) -> Self {
        self.aggregate_count_field("salary", alias)
    }

    pub fn sum_salary(self) -> Self {
        self.sum_salary_as("sum_salary")
    }

    pub fn sum_salary_as(self, alias: impl Into<String>) -> Self {
        self.aggregate_sum("salary", alias)
    }

    pub fn avg_salary(self) -> Self {
        self.avg_salary_as("avg_salary")
    }

    pub fn avg_salary_as(self, alias: impl Into<String>) -> Self {
        self.aggregate_avg("salary", alias)
    }

    pub fn min_salary(self) -> Self {
        self.min_salary_as("min_salary")
    }

    pub fn min_salary_as(self, alias: impl Into<String>) -> Self {
        self.aggregate_min("salary", alias)
    }

    pub fn max_salary(self) -> Self {
        self.max_salary_as("max_salary")
    }

    pub fn max_salary_as(self, alias: impl Into<String>) -> Self {
        self.aggregate_max("salary", alias)
    }

    pub fn standard_deviation_salary(self) -> Self {
        self.standard_deviation_salary_as("stdDev_salary")
    }

    pub fn standard_deviation_salary_as(self, alias: impl Into<String>) -> Self {
        self.aggregate_stddev("salary", alias)
    }

    pub fn square_root_of_population_standard_deviation_salary(self) -> Self {
        self.square_root_of_population_standard_deviation_salary_as("stdDevPop_salary")
    }

    pub fn square_root_of_population_standard_deviation_salary_as(self, alias: impl Into<String>) -> Self {
        self.aggregate_stddev_pop("salary", alias)
    }

    pub fn sample_variance_salary(self) -> Self {
        self.sample_variance_salary_as("varSamp_salary")
    }

    pub fn sample_variance_salary_as(self, alias: impl Into<String>) -> Self {
        self.aggregate_var_samp("salary", alias)
    }

    pub fn sample_population_variance_salary(self) -> Self {
        self.sample_population_variance_salary_as("varPop_salary")
    }

    pub fn sample_population_variance_salary_as(self, alias: impl Into<String>) -> Self {
        self.aggregate_var_pop("salary", alias)
    }

    pub fn unselect_salary(mut self) -> Self {
        self.query.projection.retain(|field| field != "salary");
        self.query_options.raw_projections.retain(|projection| projection.property_name != "salary");
        self
    }


    pub fn with_salary(
        mut self,
        operator: FieldOperator,
        values: impl IntoIterator<Item = impl Into<teaql_core::Value>>,
    ) -> Self {
        self.query = self.query.and_filter(field_operator_expr(
            "salary",
            operator,
            values.into_iter().map(Into::into).collect(),
        ));
        self
    }

    pub fn create_salary_criteria(
        operator: FieldOperator,
        values: impl IntoIterator<Item = impl Into<teaql_core::Value>>,
    ) -> Expr {
        field_operator_expr(
            "salary",
            operator,
            values.into_iter().map(Into::into).collect(),
        )
    }

    pub fn with_salary_is(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::eq("salary", value));
        self
    }



    pub fn with_salary_is_not(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::ne("salary", value));
        self
    }

    pub fn with_salary_greater_than(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::gt("salary", value));
        self
    }

    pub fn with_salary_greater_than_or_equal_to(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::gte("salary", value));
        self
    }

    pub fn with_salary_less_than(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::lt("salary", value));
        self
    }

    pub fn with_salary_less_than_or_equal_to(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::lte("salary", value));
        self
    }

    pub fn with_salary_between(
        mut self,
        lower: impl Into<teaql_core::Value>,
        upper: impl Into<teaql_core::Value>,
    ) -> Self {
        self.query = self.query.and_filter(Expr::between("salary", lower, upper));
        self
    }

    pub fn with_salary_between_range<T>(mut self, range: DateRange<T>) -> Self
    where
        T: Into<teaql_core::Value>,
    {
        self.query = self.query.and_filter(Expr::between(
            "salary",
            range.start,
            range.end,
        ));
        self
    }

    pub fn with_salary_in(
        mut self,
        values: impl IntoIterator<Item = impl Into<teaql_core::Value>>,
    ) -> Self {
        self.query = self.query.and_filter(Expr::in_list(
            "salary",
            values.into_iter().map(Into::into),
        ));
        self
    }

    pub fn with_salary_not_in(
        mut self,
        values: impl IntoIterator<Item = impl Into<teaql_core::Value>>,
    ) -> Self {
        self.query = self.query.and_filter(Expr::not_in_list(
            "salary",
            values.into_iter().map(Into::into),
        ));
        self
    }

    pub fn with_salary_before(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::lt("salary", value));
        self
    }

    pub fn with_salary_after(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::gt("salary", value));
        self
    }

    pub fn with_salary_is_unknown(mut self) -> Self {
        self.query = self.query.and_filter(Expr::is_null("salary"));
        self
    }



    pub fn with_salary_is_known(mut self) -> Self {
        self.query = self.query.and_filter(Expr::is_not_null("salary"));
        self
    }


    pub fn order_by_salary_asc(mut self) -> Self {
        self.query = self.query.order_asc("salary");
        self
    }

    pub fn order_by_salary_desc(mut self) -> Self {
        self.query = self.query.order_desc("salary");
        self
    }

    pub fn order_by_salary_asc_using_gbk(mut self) -> Self {
        self.query = self.query.order_gbk_asc("salary");
        self
    }

    pub fn order_by_salary_desc_using_gbk(mut self) -> Self {
        self.query = self.query.order_gbk_desc("salary");
        self
    }


    pub fn select_ssn(mut self) -> Self {
        self.query = self.query.project("ssn");
        self
    }

    pub fn project_ssn(self) -> Self {
        self.select_ssn()
    }

    pub fn select_ssn_raw(self, raw_sql_segment: impl Into<String>) -> Self {
        self.select_ssn_unsafe_raw(UnsafeRawSqlSegment::trusted(raw_sql_segment))
    }

    pub fn select_ssn_unsafe_raw(mut self, raw_sql_segment: UnsafeRawSqlSegment) -> Self {
        self.query_options
            .raw_projections
            .push(RawProjection::new("ssn", raw_sql_segment));
        self
    }

    pub fn group_by_ssn(self) -> Self {
        self.group_by("ssn")
    }

    pub fn group_by_ssn_as(self, alias: impl Into<String>) -> Self {
        let alias = alias.into();
        let mut request = self.group_by("ssn");
        request.query = request
            .query
            .project_expr(alias, Expr::column("ssn"));
        request
    }

    pub fn group_by_ssn_with_function(
        self,
        alias: impl Into<String>,
        function: AggregateFunction,
    ) -> Self {
        self.group_by("ssn")
            .aggregate_with_function("ssn", alias, function)
    }

    pub fn count_ssn(self) -> Self {
        self.count_ssn_as("ssn_count")
    }

    pub fn count_ssn_as(self, alias: impl Into<String>) -> Self {
        self.aggregate_count_field("ssn", alias)
    }

    pub fn sum_ssn(self) -> Self {
        self.sum_ssn_as("sum_ssn")
    }

    pub fn sum_ssn_as(self, alias: impl Into<String>) -> Self {
        self.aggregate_sum("ssn", alias)
    }

    pub fn avg_ssn(self) -> Self {
        self.avg_ssn_as("avg_ssn")
    }

    pub fn avg_ssn_as(self, alias: impl Into<String>) -> Self {
        self.aggregate_avg("ssn", alias)
    }

    pub fn min_ssn(self) -> Self {
        self.min_ssn_as("min_ssn")
    }

    pub fn min_ssn_as(self, alias: impl Into<String>) -> Self {
        self.aggregate_min("ssn", alias)
    }

    pub fn max_ssn(self) -> Self {
        self.max_ssn_as("max_ssn")
    }

    pub fn max_ssn_as(self, alias: impl Into<String>) -> Self {
        self.aggregate_max("ssn", alias)
    }

    pub fn unselect_ssn(mut self) -> Self {
        self.query.projection.retain(|field| field != "ssn");
        self.query_options.raw_projections.retain(|projection| projection.property_name != "ssn");
        self
    }


    pub fn with_ssn(
        mut self,
        operator: FieldOperator,
        values: impl IntoIterator<Item = impl Into<teaql_core::Value>>,
    ) -> Self {
        self.query = self.query.and_filter(field_operator_expr(
            "ssn",
            operator,
            values.into_iter().map(Into::into).collect(),
        ));
        self
    }

    pub fn create_ssn_criteria(
        operator: FieldOperator,
        values: impl IntoIterator<Item = impl Into<teaql_core::Value>>,
    ) -> Expr {
        field_operator_expr(
            "ssn",
            operator,
            values.into_iter().map(Into::into).collect(),
        )
    }

    pub fn with_ssn_is(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::eq("ssn", value));
        self
    }



    pub fn with_ssn_is_not(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::ne("ssn", value));
        self
    }

    pub fn with_ssn_greater_than(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::gt("ssn", value));
        self
    }

    pub fn with_ssn_greater_than_or_equal_to(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::gte("ssn", value));
        self
    }

    pub fn with_ssn_less_than(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::lt("ssn", value));
        self
    }

    pub fn with_ssn_less_than_or_equal_to(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::lte("ssn", value));
        self
    }

    pub fn with_ssn_between(
        mut self,
        lower: impl Into<teaql_core::Value>,
        upper: impl Into<teaql_core::Value>,
    ) -> Self {
        self.query = self.query.and_filter(Expr::between("ssn", lower, upper));
        self
    }

    pub fn with_ssn_between_range<T>(mut self, range: DateRange<T>) -> Self
    where
        T: Into<teaql_core::Value>,
    {
        self.query = self.query.and_filter(Expr::between(
            "ssn",
            range.start,
            range.end,
        ));
        self
    }

    pub fn with_ssn_in(
        mut self,
        values: impl IntoIterator<Item = impl Into<teaql_core::Value>>,
    ) -> Self {
        self.query = self.query.and_filter(Expr::in_list(
            "ssn",
            values.into_iter().map(Into::into),
        ));
        self
    }

    pub fn with_ssn_not_in(
        mut self,
        values: impl IntoIterator<Item = impl Into<teaql_core::Value>>,
    ) -> Self {
        self.query = self.query.and_filter(Expr::not_in_list(
            "ssn",
            values.into_iter().map(Into::into),
        ));
        self
    }

    pub fn with_ssn_containing(mut self, value: impl Into<String>) -> Self {
        self.query = self.query.and_filter(Expr::contain("ssn", value));
        self
    }

    pub fn with_ssn_not_containing(mut self, value: impl Into<String>) -> Self {
        self.query = self.query.and_filter(Expr::not_contain("ssn", value));
        self
    }

    pub fn with_ssn_starting_with(mut self, value: impl Into<String>) -> Self {
        self.query = self.query.and_filter(Expr::begin_with("ssn", value));
        self
    }

    pub fn with_ssn_not_starting_with(mut self, value: impl Into<String>) -> Self {
        self.query = self.query.and_filter(Expr::not_begin_with("ssn", value));
        self
    }

    pub fn with_ssn_ending_with(mut self, value: impl Into<String>) -> Self {
        self.query = self.query.and_filter(Expr::end_with("ssn", value));
        self
    }

    pub fn with_ssn_not_ending_with(mut self, value: impl Into<String>) -> Self {
        self.query = self.query.and_filter(Expr::not_end_with("ssn", value));
        self
    }

    pub fn with_ssn_sounding_like(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::sound_like("ssn", value));
        self
    }
    pub fn with_ssn_before(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::lt("ssn", value));
        self
    }

    pub fn with_ssn_after(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::gt("ssn", value));
        self
    }

    pub fn with_ssn_is_unknown(mut self) -> Self {
        self.query = self.query.and_filter(Expr::is_null("ssn"));
        self
    }



    pub fn with_ssn_is_known(mut self) -> Self {
        self.query = self.query.and_filter(Expr::is_not_null("ssn"));
        self
    }


    pub fn order_by_ssn_asc(mut self) -> Self {
        self.query = self.query.order_asc("ssn");
        self
    }

    pub fn order_by_ssn_desc(mut self) -> Self {
        self.query = self.query.order_desc("ssn");
        self
    }

    pub fn order_by_ssn_asc_using_gbk(mut self) -> Self {
        self.query = self.query.order_gbk_asc("ssn");
        self
    }

    pub fn order_by_ssn_desc_using_gbk(mut self) -> Self {
        self.query = self.query.order_gbk_desc("ssn");
        self
    }


    pub fn select_hire_date(mut self) -> Self {
        self.query = self.query.project("hire_date");
        self
    }

    pub fn project_hire_date(self) -> Self {
        self.select_hire_date()
    }

    pub fn select_hire_date_raw(self, raw_sql_segment: impl Into<String>) -> Self {
        self.select_hire_date_unsafe_raw(UnsafeRawSqlSegment::trusted(raw_sql_segment))
    }

    pub fn select_hire_date_unsafe_raw(mut self, raw_sql_segment: UnsafeRawSqlSegment) -> Self {
        self.query_options
            .raw_projections
            .push(RawProjection::new("hire_date", raw_sql_segment));
        self
    }

    pub fn group_by_hire_date(self) -> Self {
        self.group_by("hire_date")
    }

    pub fn group_by_hire_date_as(self, alias: impl Into<String>) -> Self {
        let alias = alias.into();
        let mut request = self.group_by("hire_date");
        request.query = request
            .query
            .project_expr(alias, Expr::column("hire_date"));
        request
    }

    pub fn group_by_hire_date_with_function(
        self,
        alias: impl Into<String>,
        function: AggregateFunction,
    ) -> Self {
        self.group_by("hire_date")
            .aggregate_with_function("hire_date", alias, function)
    }

    pub fn count_hire_date(self) -> Self {
        self.count_hire_date_as("hire_date_count")
    }

    pub fn count_hire_date_as(self, alias: impl Into<String>) -> Self {
        self.aggregate_count_field("hire_date", alias)
    }

    pub fn sum_hire_date(self) -> Self {
        self.sum_hire_date_as("sum_hire_date")
    }

    pub fn sum_hire_date_as(self, alias: impl Into<String>) -> Self {
        self.aggregate_sum("hire_date", alias)
    }

    pub fn avg_hire_date(self) -> Self {
        self.avg_hire_date_as("avg_hire_date")
    }

    pub fn avg_hire_date_as(self, alias: impl Into<String>) -> Self {
        self.aggregate_avg("hire_date", alias)
    }

    pub fn min_hire_date(self) -> Self {
        self.min_hire_date_as("min_hire_date")
    }

    pub fn min_hire_date_as(self, alias: impl Into<String>) -> Self {
        self.aggregate_min("hire_date", alias)
    }

    pub fn max_hire_date(self) -> Self {
        self.max_hire_date_as("max_hire_date")
    }

    pub fn max_hire_date_as(self, alias: impl Into<String>) -> Self {
        self.aggregate_max("hire_date", alias)
    }

    pub fn unselect_hire_date(mut self) -> Self {
        self.query.projection.retain(|field| field != "hire_date");
        self.query_options.raw_projections.retain(|projection| projection.property_name != "hire_date");
        self
    }


    pub fn with_hire_date(
        mut self,
        operator: FieldOperator,
        values: impl IntoIterator<Item = impl Into<teaql_core::Value>>,
    ) -> Self {
        self.query = self.query.and_filter(field_operator_expr(
            "hire_date",
            operator,
            values.into_iter().map(Into::into).collect(),
        ));
        self
    }

    pub fn create_hire_date_criteria(
        operator: FieldOperator,
        values: impl IntoIterator<Item = impl Into<teaql_core::Value>>,
    ) -> Expr {
        field_operator_expr(
            "hire_date",
            operator,
            values.into_iter().map(Into::into).collect(),
        )
    }

    pub fn with_hire_date_is(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::eq("hire_date", value));
        self
    }



    pub fn with_hire_date_is_not(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::ne("hire_date", value));
        self
    }

    pub fn with_hire_date_greater_than(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::gt("hire_date", value));
        self
    }

    pub fn with_hire_date_greater_than_or_equal_to(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::gte("hire_date", value));
        self
    }

    pub fn with_hire_date_less_than(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::lt("hire_date", value));
        self
    }

    pub fn with_hire_date_less_than_or_equal_to(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::lte("hire_date", value));
        self
    }

    pub fn with_hire_date_between(
        mut self,
        lower: impl Into<teaql_core::Value>,
        upper: impl Into<teaql_core::Value>,
    ) -> Self {
        self.query = self.query.and_filter(Expr::between("hire_date", lower, upper));
        self
    }

    pub fn with_hire_date_between_range<T>(mut self, range: DateRange<T>) -> Self
    where
        T: Into<teaql_core::Value>,
    {
        self.query = self.query.and_filter(Expr::between(
            "hire_date",
            range.start,
            range.end,
        ));
        self
    }

    pub fn with_hire_date_in(
        mut self,
        values: impl IntoIterator<Item = impl Into<teaql_core::Value>>,
    ) -> Self {
        self.query = self.query.and_filter(Expr::in_list(
            "hire_date",
            values.into_iter().map(Into::into),
        ));
        self
    }

    pub fn with_hire_date_not_in(
        mut self,
        values: impl IntoIterator<Item = impl Into<teaql_core::Value>>,
    ) -> Self {
        self.query = self.query.and_filter(Expr::not_in_list(
            "hire_date",
            values.into_iter().map(Into::into),
        ));
        self
    }

    pub fn with_hire_date_before(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::lt("hire_date", value));
        self
    }

    pub fn with_hire_date_after(mut self, value: impl Into<teaql_core::Value>) -> Self {
        self.query = self.query.and_filter(Expr::gt("hire_date", value));
        self
    }

    pub fn with_hire_date_is_unknown(mut self) -> Self {
        self.query = self.query.and_filter(Expr::is_null("hire_date"));
        self
    }



    pub fn with_hire_date_is_known(mut self) -> Self {
        self.query = self.query.and_filter(Expr::is_not_null("hire_date"));
        self
    }


    pub fn order_by_hire_date_asc(mut self) -> Self {
        self.query = self.query.order_asc("hire_date");
        self
    }

    pub fn order_by_hire_date_desc(mut self) -> Self {
        self.query = self.query.order_desc("hire_date");
        self
    }

    pub fn order_by_hire_date_asc_using_gbk(mut self) -> Self {
        self.query = self.query.order_gbk_asc("hire_date");
        self
    }

    pub fn order_by_hire_date_desc_using_gbk(mut self) -> Self {
        self.query = self.query.order_gbk_desc("hire_date");
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
    pub fn filter_by_department(mut self, value: impl EntityReference) -> Self {
        self.query = self.query.and_filter(Expr::eq("department_id", value.entity_id_value()));
        self
    }

    pub fn with_department_matching(mut self, request: impl Into<QuerySelection>) -> Self {
        let selection = request.into();
        self.query = self.query.and_filter(Expr::in_subquery(
            "department_id",
            <crate::Department as teaql_core::TeaqlEntity>::entity_descriptor(),
            selection.query.clone(),
            "id",
        ));
        self.relation_filters.push(RelationFilter::new("department", selection));
        self
    }


    pub fn without_department_matching(mut self, request: impl Into<QuerySelection>) -> Self {
        let selection = request.into();
        self.query = self.query.and_filter(Expr::not_in_subquery(
            "department_id",
            <crate::Department as teaql_core::TeaqlEntity>::entity_descriptor(),
            selection.query.clone(),
            "id",
        ));
        self.relation_filters.push(RelationFilter::new("department", selection));
        self
    }


    pub fn have_department(mut self) -> Self {
        self.query = self.query.and_filter(Expr::is_not_null("department_id"));
        self
    }

    pub fn have_no_department(mut self) -> Self {
        self.query = self.query.and_filter(Expr::is_null("department_id"));
        self
    }


    pub fn group_by_department(self) -> Self {
        self.group_by("department_id")
    }

    pub fn group_by_department_as(self, alias: impl Into<String>) -> Self {
        let alias = alias.into();
        let mut request = self.group_by("department_id");
        request.query = request
            .query
            .project_expr(alias, Expr::column("department_id"));
        request
    }

    pub fn group_by_department_with_function(
        self,
        alias: impl Into<String>,
        function: AggregateFunction,
    ) -> Self {
        self.group_by("department_id")
            .aggregate_with_function("department_id", alias, function)
    }

    pub fn group_by_department_with(mut self, request: impl Into<QuerySelection>) -> Self {
        self.query = self.query.group_by("department_id");
        self.query_options.object_group_bys.push(ObjectGroupBy::new(
            "department",
            "department_id",
            request,
        ));
        self
    }

    pub fn group_by_department_with_details(self) -> Self {
        self.group_by_department_with_details_from(crate::Q::departments().unlimited())
    }

    pub fn group_by_department_with_details_from(self, request: impl Into<QuerySelection>) -> Self {
        self.group_by_department_with(request)
    }


    pub fn roll_up_to_department(self) -> Self {
        self.roll_up_to_department_with(crate::Q::departments().unlimited())
    }

    pub fn roll_up_to_department_with(self, request: impl Into<QuerySelection>) -> Self {
        let selection = request.into();
        self.with_department_matching(selection.clone())
            .group_by_department_with(selection)
    }

    pub fn count_department(self) -> Self {
        self.count_department_as("department_count")
    }

    pub fn count_department_as(self, alias: impl Into<String>) -> Self {
        self.aggregate_count_field("department_id", alias)
    }

    pub fn unselect_department(mut self) -> Self {
        self.query.projection.retain(|field| field != "department_id");
        self.query.relations.retain(|relation| relation.name != "department");
        self
    }
    pub fn select_department(mut self) -> Self {
        self.query = self.query.relation("department");
        self
    }

    pub fn select_department_with(mut self, request: impl Into<QuerySelection>) -> Self {
        let selection = request.into();
        self.query = self.query.relation_query("department", selection.clone().into_query());
        self.relation_selections.push(RelationSelection::new("department", selection));
        self
}

    pub fn facet_by_department_as(self, facet_name: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.facet_by_department_as_with_options(facet_name, request, true)
    }

    pub fn facet_by_department_as_with_options(
        mut self,
        facet_name: impl Into<String>,
        request: impl Into<QuerySelection>,
        include_all_facets: bool,
    ) -> Self {
        self.query_options.facets.push(FacetRequest::new(
            facet_name,
            "department",
            request,
            include_all_facets,
        ));
        self
    }
    pub fn have_leave_requests(self) -> Self {
        self.with_leave_request_list_matching(SelectQuery::new("LeaveRequest"))
    }

    pub fn have_no_leave_requests(self) -> Self {
        self.without_leave_request_list_matching(SelectQuery::new("LeaveRequest"))
    }

    pub fn with_leave_request_list_matching(mut self, request: impl Into<QuerySelection>) -> Self {
        let selection = request.into();
        self.query = self.query.and_filter(Expr::in_subquery(
            "id",
            <crate::LeaveRequest as teaql_core::TeaqlEntity>::entity_descriptor(),
            selection.query.clone(),
            "employee_id",
        ));
        self.relation_filters.push(RelationFilter::new("leave_request_list", selection));
        self
    }

    pub fn without_leave_request_list_matching(mut self, request: impl Into<QuerySelection>) -> Self {
        let selection = request.into();
        self.query = self.query.and_filter(Expr::not_in_subquery(
            "id",
            <crate::LeaveRequest as teaql_core::TeaqlEntity>::entity_descriptor(),
            selection.query.clone(),
            "employee_id",
        ));
        self.relation_filters.push(RelationFilter::new("leave_request_list", selection));
        self
    }

    pub fn select_leave_request_list(mut self) -> Self {
        self.query = self.query.relation("leave_request_list");
        self
    }

    pub fn select_leave_request_list_with(mut self, request: impl Into<QuerySelection>) -> Self {
        let selection = request.into();
        self.query = self.query.relation_query("leave_request_list", selection.clone().into_query());
        self.relation_selections.push(RelationSelection::new("leave_request_list", selection));
        self
}

    pub fn have_attendances(self) -> Self {
        self.with_attendance_list_matching(SelectQuery::new("Attendance"))
    }

    pub fn have_no_attendances(self) -> Self {
        self.without_attendance_list_matching(SelectQuery::new("Attendance"))
    }

    pub fn with_attendance_list_matching(mut self, request: impl Into<QuerySelection>) -> Self {
        let selection = request.into();
        self.query = self.query.and_filter(Expr::in_subquery(
            "id",
            <crate::Attendance as teaql_core::TeaqlEntity>::entity_descriptor(),
            selection.query.clone(),
            "employee_id",
        ));
        self.relation_filters.push(RelationFilter::new("attendance_list", selection));
        self
    }

    pub fn without_attendance_list_matching(mut self, request: impl Into<QuerySelection>) -> Self {
        let selection = request.into();
        self.query = self.query.and_filter(Expr::not_in_subquery(
            "id",
            <crate::Attendance as teaql_core::TeaqlEntity>::entity_descriptor(),
            selection.query.clone(),
            "employee_id",
        ));
        self.relation_filters.push(RelationFilter::new("attendance_list", selection));
        self
    }

    pub fn select_attendance_list(mut self) -> Self {
        self.query = self.query.relation("attendance_list");
        self
    }

    pub fn select_attendance_list_with(mut self, request: impl Into<QuerySelection>) -> Self {
        let selection = request.into();
        self.query = self.query.relation_query("attendance_list", selection.clone().into_query());
        self.relation_selections.push(RelationSelection::new("attendance_list", selection));
        self
}

    pub fn have_benefits(self) -> Self {
        self.with_benefit_list_matching(SelectQuery::new("Benefit"))
    }

    pub fn have_no_benefits(self) -> Self {
        self.without_benefit_list_matching(SelectQuery::new("Benefit"))
    }

    pub fn with_benefit_list_matching(mut self, request: impl Into<QuerySelection>) -> Self {
        let selection = request.into();
        self.query = self.query.and_filter(Expr::in_subquery(
            "id",
            <crate::Benefit as teaql_core::TeaqlEntity>::entity_descriptor(),
            selection.query.clone(),
            "employee_id",
        ));
        self.relation_filters.push(RelationFilter::new("benefit_list", selection));
        self
    }

    pub fn without_benefit_list_matching(mut self, request: impl Into<QuerySelection>) -> Self {
        let selection = request.into();
        self.query = self.query.and_filter(Expr::not_in_subquery(
            "id",
            <crate::Benefit as teaql_core::TeaqlEntity>::entity_descriptor(),
            selection.query.clone(),
            "employee_id",
        ));
        self.relation_filters.push(RelationFilter::new("benefit_list", selection));
        self
    }

    pub fn select_benefit_list(mut self) -> Self {
        self.query = self.query.relation("benefit_list");
        self
    }

    pub fn select_benefit_list_with(mut self, request: impl Into<QuerySelection>) -> Self {
        let selection = request.into();
        self.query = self.query.relation_query("benefit_list", selection.clone().into_query());
        self.relation_selections.push(RelationSelection::new("benefit_list", selection));
        self
}

    pub fn have_employee_reviews(self) -> Self {
        self.with_employee_review_list_matching(SelectQuery::new("EmployeeReview"))
    }

    pub fn have_no_employee_reviews(self) -> Self {
        self.without_employee_review_list_matching(SelectQuery::new("EmployeeReview"))
    }

    pub fn with_employee_review_list_matching(mut self, request: impl Into<QuerySelection>) -> Self {
        let selection = request.into();
        self.query = self.query.and_filter(Expr::in_subquery(
            "id",
            <crate::EmployeeReview as teaql_core::TeaqlEntity>::entity_descriptor(),
            selection.query.clone(),
            "employee_id",
        ));
        self.relation_filters.push(RelationFilter::new("employee_review_list", selection));
        self
    }

    pub fn without_employee_review_list_matching(mut self, request: impl Into<QuerySelection>) -> Self {
        let selection = request.into();
        self.query = self.query.and_filter(Expr::not_in_subquery(
            "id",
            <crate::EmployeeReview as teaql_core::TeaqlEntity>::entity_descriptor(),
            selection.query.clone(),
            "employee_id",
        ));
        self.relation_filters.push(RelationFilter::new("employee_review_list", selection));
        self
    }

    pub fn select_employee_review_list(mut self) -> Self {
        self.query = self.query.relation("employee_review_list");
        self
    }

    pub fn select_employee_review_list_with(mut self, request: impl Into<QuerySelection>) -> Self {
        let selection = request.into();
        self.query = self.query.relation_query("employee_review_list", selection.clone().into_query());
        self.relation_selections.push(RelationSelection::new("employee_review_list", selection));
        self
}

    pub fn have_payrolls(self) -> Self {
        self.with_payroll_list_matching(SelectQuery::new("Payroll"))
    }

    pub fn have_no_payrolls(self) -> Self {
        self.without_payroll_list_matching(SelectQuery::new("Payroll"))
    }

    pub fn with_payroll_list_matching(mut self, request: impl Into<QuerySelection>) -> Self {
        let selection = request.into();
        self.query = self.query.and_filter(Expr::in_subquery(
            "id",
            <crate::Payroll as teaql_core::TeaqlEntity>::entity_descriptor(),
            selection.query.clone(),
            "employee_id",
        ));
        self.relation_filters.push(RelationFilter::new("payroll_list", selection));
        self
    }

    pub fn without_payroll_list_matching(mut self, request: impl Into<QuerySelection>) -> Self {
        let selection = request.into();
        self.query = self.query.and_filter(Expr::not_in_subquery(
            "id",
            <crate::Payroll as teaql_core::TeaqlEntity>::entity_descriptor(),
            selection.query.clone(),
            "employee_id",
        ));
        self.relation_filters.push(RelationFilter::new("payroll_list", selection));
        self
    }

    pub fn select_payroll_list(mut self) -> Self {
        self.query = self.query.relation("payroll_list");
        self
    }

    pub fn select_payroll_list_with(mut self, request: impl Into<QuerySelection>) -> Self {
        let selection = request.into();
        self.query = self.query.relation_query("payroll_list", selection.clone().into_query());
        self.relation_selections.push(RelationSelection::new("payroll_list", selection));
        self
}

    pub fn have_expenses(self) -> Self {
        self.with_expense_list_matching(SelectQuery::new("Expense"))
    }

    pub fn have_no_expenses(self) -> Self {
        self.without_expense_list_matching(SelectQuery::new("Expense"))
    }

    pub fn with_expense_list_matching(mut self, request: impl Into<QuerySelection>) -> Self {
        let selection = request.into();
        self.query = self.query.and_filter(Expr::in_subquery(
            "id",
            <crate::Expense as teaql_core::TeaqlEntity>::entity_descriptor(),
            selection.query.clone(),
            "employee_id",
        ));
        self.relation_filters.push(RelationFilter::new("expense_list", selection));
        self
    }

    pub fn without_expense_list_matching(mut self, request: impl Into<QuerySelection>) -> Self {
        let selection = request.into();
        self.query = self.query.and_filter(Expr::not_in_subquery(
            "id",
            <crate::Expense as teaql_core::TeaqlEntity>::entity_descriptor(),
            selection.query.clone(),
            "employee_id",
        ));
        self.relation_filters.push(RelationFilter::new("expense_list", selection));
        self
    }

    pub fn select_expense_list(mut self) -> Self {
        self.query = self.query.relation("expense_list");
        self
    }

    pub fn select_expense_list_with(mut self, request: impl Into<QuerySelection>) -> Self {
        let selection = request.into();
        self.query = self.query.relation_query("expense_list", selection.clone().into_query());
        self.relation_selections.push(RelationSelection::new("expense_list", selection));
        self
}

    pub fn have_support_agents(self) -> Self {
        self.with_support_agent_list_matching(SelectQuery::new("SupportAgent"))
    }

    pub fn have_no_support_agents(self) -> Self {
        self.without_support_agent_list_matching(SelectQuery::new("SupportAgent"))
    }

    pub fn with_support_agent_list_matching(mut self, request: impl Into<QuerySelection>) -> Self {
        let selection = request.into();
        self.query = self.query.and_filter(Expr::in_subquery(
            "id",
            <crate::SupportAgent as teaql_core::TeaqlEntity>::entity_descriptor(),
            selection.query.clone(),
            "employee_id",
        ));
        self.relation_filters.push(RelationFilter::new("support_agent_list", selection));
        self
    }

    pub fn without_support_agent_list_matching(mut self, request: impl Into<QuerySelection>) -> Self {
        let selection = request.into();
        self.query = self.query.and_filter(Expr::not_in_subquery(
            "id",
            <crate::SupportAgent as teaql_core::TeaqlEntity>::entity_descriptor(),
            selection.query.clone(),
            "employee_id",
        ));
        self.relation_filters.push(RelationFilter::new("support_agent_list", selection));
        self
    }

    pub fn select_support_agent_list(mut self) -> Self {
        self.query = self.query.relation("support_agent_list");
        self
    }

    pub fn select_support_agent_list_with(mut self, request: impl Into<QuerySelection>) -> Self {
        let selection = request.into();
        self.query = self.query.relation_query("support_agent_list", selection.clone().into_query());
        self.relation_selections.push(RelationSelection::new("support_agent_list", selection));
        self
}
    pub fn count_leave_requests(self) -> Self {
        self.count_leave_requests_as("count_leave_requests")
    }

    pub fn count_leave_requests_as(self, alias: impl Into<String>) -> Self {
        self.count_leave_requests_with(alias, crate::Q::leave_requests().unlimited())
    }

    pub fn count_leave_requests_with(mut self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        let selection = request.into();
        self.query_options.relation_aggregates.push(RelationAggregate::new(
            "leave_request_list",
            alias,
            selection,
            true,
        ));
        self
    }

    pub fn stats_from_leave_requests(self, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_leave_requests_as("refinements", request)
    }

    pub fn stats_from_leave_requests_as(mut self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        let selection = request.into();
        self.query_options.relation_aggregates.push(RelationAggregate::new(
            "leave_request_list",
            alias,
            selection,
            false,
        ));
        self
    }

    pub fn group_by_leave_requests_with_details(self, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_leave_requests(request)
    }


    pub fn min_end_date_of_leave_requests(self) -> Self {
        self.min_end_date_of_leave_requests_as("min_end_date_of_leave_requests", crate::Q::leave_requests().unlimited())
    }

    pub fn min_end_date_of_leave_requests_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_leave_requests_as(alias, request.into().into_query().min("end_date", "min_end_date"))
    }
    pub fn max_end_date_of_leave_requests(self) -> Self {
        self.max_end_date_of_leave_requests_as("max_end_date_of_leave_requests", crate::Q::leave_requests().unlimited())
    }

    pub fn max_end_date_of_leave_requests_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_leave_requests_as(alias, request.into().into_query().max("end_date", "max_end_date"))
    }
    pub fn min_start_date_of_leave_requests(self) -> Self {
        self.min_start_date_of_leave_requests_as("min_start_date_of_leave_requests", crate::Q::leave_requests().unlimited())
    }

    pub fn min_start_date_of_leave_requests_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_leave_requests_as(alias, request.into().into_query().min("start_date", "min_start_date"))
    }
    pub fn max_start_date_of_leave_requests(self) -> Self {
        self.max_start_date_of_leave_requests_as("max_start_date_of_leave_requests", crate::Q::leave_requests().unlimited())
    }

    pub fn max_start_date_of_leave_requests_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_leave_requests_as(alias, request.into().into_query().max("start_date", "max_start_date"))
    }
    pub fn min_create_time_of_leave_requests(self) -> Self {
        self.min_create_time_of_leave_requests_as("min_create_time_of_leave_requests", crate::Q::leave_requests().unlimited())
    }

    pub fn min_create_time_of_leave_requests_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_leave_requests_as(alias, request.into().into_query().min("create_time", "min_create_time"))
    }
    pub fn max_create_time_of_leave_requests(self) -> Self {
        self.max_create_time_of_leave_requests_as("max_create_time_of_leave_requests", crate::Q::leave_requests().unlimited())
    }

    pub fn max_create_time_of_leave_requests_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_leave_requests_as(alias, request.into().into_query().max("create_time", "max_create_time"))
    }
    pub fn min_update_time_of_leave_requests(self) -> Self {
        self.min_update_time_of_leave_requests_as("min_update_time_of_leave_requests", crate::Q::leave_requests().unlimited())
    }

    pub fn min_update_time_of_leave_requests_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_leave_requests_as(alias, request.into().into_query().min("update_time", "min_update_time"))
    }
    pub fn max_update_time_of_leave_requests(self) -> Self {
        self.max_update_time_of_leave_requests_as("max_update_time_of_leave_requests", crate::Q::leave_requests().unlimited())
    }

    pub fn max_update_time_of_leave_requests_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_leave_requests_as(alias, request.into().into_query().max("update_time", "max_update_time"))
    }

    pub fn count_attendances(self) -> Self {
        self.count_attendances_as("count_attendances")
    }

    pub fn count_attendances_as(self, alias: impl Into<String>) -> Self {
        self.count_attendances_with(alias, crate::Q::attendances().unlimited())
    }

    pub fn count_attendances_with(mut self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        let selection = request.into();
        self.query_options.relation_aggregates.push(RelationAggregate::new(
            "attendance_list",
            alias,
            selection,
            true,
        ));
        self
    }

    pub fn stats_from_attendances(self, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_attendances_as("refinements", request)
    }

    pub fn stats_from_attendances_as(mut self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        let selection = request.into();
        self.query_options.relation_aggregates.push(RelationAggregate::new(
            "attendance_list",
            alias,
            selection,
            false,
        ));
        self
    }

    pub fn group_by_attendances_with_details(self, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_attendances(request)
    }


    pub fn min_check_in_of_attendances(self) -> Self {
        self.min_check_in_of_attendances_as("min_check_in_of_attendances", crate::Q::attendances().unlimited())
    }

    pub fn min_check_in_of_attendances_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_attendances_as(alias, request.into().into_query().min("check_in", "min_check_in"))
    }
    pub fn max_check_in_of_attendances(self) -> Self {
        self.max_check_in_of_attendances_as("max_check_in_of_attendances", crate::Q::attendances().unlimited())
    }

    pub fn max_check_in_of_attendances_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_attendances_as(alias, request.into().into_query().max("check_in", "max_check_in"))
    }
    pub fn min_check_out_of_attendances(self) -> Self {
        self.min_check_out_of_attendances_as("min_check_out_of_attendances", crate::Q::attendances().unlimited())
    }

    pub fn min_check_out_of_attendances_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_attendances_as(alias, request.into().into_query().min("check_out", "min_check_out"))
    }
    pub fn max_check_out_of_attendances(self) -> Self {
        self.max_check_out_of_attendances_as("max_check_out_of_attendances", crate::Q::attendances().unlimited())
    }

    pub fn max_check_out_of_attendances_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_attendances_as(alias, request.into().into_query().max("check_out", "max_check_out"))
    }
    pub fn sum_hours_worked_of_attendances(self) -> Self {
        self.sum_hours_worked_of_attendances_as("sum_hours_worked_of_attendances", crate::Q::attendances().unlimited())
    }

    pub fn sum_hours_worked_of_attendances_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_attendances_as(alias, request.into().into_query().sum("hours_worked", "sum_hours_worked"))
    }
    pub fn min_hours_worked_of_attendances(self) -> Self {
        self.min_hours_worked_of_attendances_as("min_hours_worked_of_attendances", crate::Q::attendances().unlimited())
    }

    pub fn min_hours_worked_of_attendances_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_attendances_as(alias, request.into().into_query().min("hours_worked", "min_hours_worked"))
    }
    pub fn max_hours_worked_of_attendances(self) -> Self {
        self.max_hours_worked_of_attendances_as("max_hours_worked_of_attendances", crate::Q::attendances().unlimited())
    }

    pub fn max_hours_worked_of_attendances_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_attendances_as(alias, request.into().into_query().max("hours_worked", "max_hours_worked"))
    }
    pub fn avg_hours_worked_of_attendances(self) -> Self {
        self.avg_hours_worked_of_attendances_as("avg_hours_worked_of_attendances", crate::Q::attendances().unlimited())
    }

    pub fn avg_hours_worked_of_attendances_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_attendances_as(alias, request.into().into_query().avg("hours_worked", "avg_hours_worked"))
    }
    pub fn standard_deviation_hours_worked_of_attendances(self) -> Self {
        self.standard_deviation_hours_worked_of_attendances_as("standard_deviation_hours_worked_of_attendances", crate::Q::attendances().unlimited())
    }

    pub fn standard_deviation_hours_worked_of_attendances_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_attendances_as(alias, request.into().into_query().stddev("hours_worked", "stdDev_hours_worked"))
    }
    pub fn square_root_of_population_standard_deviation_hours_worked_of_attendances(self) -> Self {
        self.square_root_of_population_standard_deviation_hours_worked_of_attendances_as("square_root_of_population_standard_deviation_hours_worked_of_attendances", crate::Q::attendances().unlimited())
    }

    pub fn square_root_of_population_standard_deviation_hours_worked_of_attendances_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_attendances_as(alias, request.into().into_query().stddev_pop("hours_worked", "stdDevPop_hours_worked"))
    }
    pub fn sample_variance_hours_worked_of_attendances(self) -> Self {
        self.sample_variance_hours_worked_of_attendances_as("sample_variance_hours_worked_of_attendances", crate::Q::attendances().unlimited())
    }

    pub fn sample_variance_hours_worked_of_attendances_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_attendances_as(alias, request.into().into_query().var_samp("hours_worked", "varSamp_hours_worked"))
    }
    pub fn sample_population_variance_hours_worked_of_attendances(self) -> Self {
        self.sample_population_variance_hours_worked_of_attendances_as("sample_population_variance_hours_worked_of_attendances", crate::Q::attendances().unlimited())
    }

    pub fn sample_population_variance_hours_worked_of_attendances_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_attendances_as(alias, request.into().into_query().var_pop("hours_worked", "varPop_hours_worked"))
    }
    pub fn min_create_time_of_attendances(self) -> Self {
        self.min_create_time_of_attendances_as("min_create_time_of_attendances", crate::Q::attendances().unlimited())
    }

    pub fn min_create_time_of_attendances_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_attendances_as(alias, request.into().into_query().min("create_time", "min_create_time"))
    }
    pub fn max_create_time_of_attendances(self) -> Self {
        self.max_create_time_of_attendances_as("max_create_time_of_attendances", crate::Q::attendances().unlimited())
    }

    pub fn max_create_time_of_attendances_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_attendances_as(alias, request.into().into_query().max("create_time", "max_create_time"))
    }
    pub fn min_update_time_of_attendances(self) -> Self {
        self.min_update_time_of_attendances_as("min_update_time_of_attendances", crate::Q::attendances().unlimited())
    }

    pub fn min_update_time_of_attendances_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_attendances_as(alias, request.into().into_query().min("update_time", "min_update_time"))
    }
    pub fn max_update_time_of_attendances(self) -> Self {
        self.max_update_time_of_attendances_as("max_update_time_of_attendances", crate::Q::attendances().unlimited())
    }

    pub fn max_update_time_of_attendances_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_attendances_as(alias, request.into().into_query().max("update_time", "max_update_time"))
    }

    pub fn count_benefits(self) -> Self {
        self.count_benefits_as("count_benefits")
    }

    pub fn count_benefits_as(self, alias: impl Into<String>) -> Self {
        self.count_benefits_with(alias, crate::Q::benefits().unlimited())
    }

    pub fn count_benefits_with(mut self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        let selection = request.into();
        self.query_options.relation_aggregates.push(RelationAggregate::new(
            "benefit_list",
            alias,
            selection,
            true,
        ));
        self
    }

    pub fn stats_from_benefits(self, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_benefits_as("refinements", request)
    }

    pub fn stats_from_benefits_as(mut self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        let selection = request.into();
        self.query_options.relation_aggregates.push(RelationAggregate::new(
            "benefit_list",
            alias,
            selection,
            false,
        ));
        self
    }

    pub fn group_by_benefits_with_details(self, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_benefits(request)
    }


    pub fn sum_cost_of_benefits(self) -> Self {
        self.sum_cost_of_benefits_as("sum_cost_of_benefits", crate::Q::benefits().unlimited())
    }

    pub fn sum_cost_of_benefits_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_benefits_as(alias, request.into().into_query().sum("cost", "sum_cost"))
    }
    pub fn min_cost_of_benefits(self) -> Self {
        self.min_cost_of_benefits_as("min_cost_of_benefits", crate::Q::benefits().unlimited())
    }

    pub fn min_cost_of_benefits_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_benefits_as(alias, request.into().into_query().min("cost", "min_cost"))
    }
    pub fn max_cost_of_benefits(self) -> Self {
        self.max_cost_of_benefits_as("max_cost_of_benefits", crate::Q::benefits().unlimited())
    }

    pub fn max_cost_of_benefits_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_benefits_as(alias, request.into().into_query().max("cost", "max_cost"))
    }
    pub fn avg_cost_of_benefits(self) -> Self {
        self.avg_cost_of_benefits_as("avg_cost_of_benefits", crate::Q::benefits().unlimited())
    }

    pub fn avg_cost_of_benefits_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_benefits_as(alias, request.into().into_query().avg("cost", "avg_cost"))
    }
    pub fn standard_deviation_cost_of_benefits(self) -> Self {
        self.standard_deviation_cost_of_benefits_as("standard_deviation_cost_of_benefits", crate::Q::benefits().unlimited())
    }

    pub fn standard_deviation_cost_of_benefits_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_benefits_as(alias, request.into().into_query().stddev("cost", "stdDev_cost"))
    }
    pub fn square_root_of_population_standard_deviation_cost_of_benefits(self) -> Self {
        self.square_root_of_population_standard_deviation_cost_of_benefits_as("square_root_of_population_standard_deviation_cost_of_benefits", crate::Q::benefits().unlimited())
    }

    pub fn square_root_of_population_standard_deviation_cost_of_benefits_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_benefits_as(alias, request.into().into_query().stddev_pop("cost", "stdDevPop_cost"))
    }
    pub fn sample_variance_cost_of_benefits(self) -> Self {
        self.sample_variance_cost_of_benefits_as("sample_variance_cost_of_benefits", crate::Q::benefits().unlimited())
    }

    pub fn sample_variance_cost_of_benefits_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_benefits_as(alias, request.into().into_query().var_samp("cost", "varSamp_cost"))
    }
    pub fn sample_population_variance_cost_of_benefits(self) -> Self {
        self.sample_population_variance_cost_of_benefits_as("sample_population_variance_cost_of_benefits", crate::Q::benefits().unlimited())
    }

    pub fn sample_population_variance_cost_of_benefits_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_benefits_as(alias, request.into().into_query().var_pop("cost", "varPop_cost"))
    }
    pub fn min_create_time_of_benefits(self) -> Self {
        self.min_create_time_of_benefits_as("min_create_time_of_benefits", crate::Q::benefits().unlimited())
    }

    pub fn min_create_time_of_benefits_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_benefits_as(alias, request.into().into_query().min("create_time", "min_create_time"))
    }
    pub fn max_create_time_of_benefits(self) -> Self {
        self.max_create_time_of_benefits_as("max_create_time_of_benefits", crate::Q::benefits().unlimited())
    }

    pub fn max_create_time_of_benefits_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_benefits_as(alias, request.into().into_query().max("create_time", "max_create_time"))
    }
    pub fn min_update_time_of_benefits(self) -> Self {
        self.min_update_time_of_benefits_as("min_update_time_of_benefits", crate::Q::benefits().unlimited())
    }

    pub fn min_update_time_of_benefits_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_benefits_as(alias, request.into().into_query().min("update_time", "min_update_time"))
    }
    pub fn max_update_time_of_benefits(self) -> Self {
        self.max_update_time_of_benefits_as("max_update_time_of_benefits", crate::Q::benefits().unlimited())
    }

    pub fn max_update_time_of_benefits_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_benefits_as(alias, request.into().into_query().max("update_time", "max_update_time"))
    }

    pub fn count_employee_reviews(self) -> Self {
        self.count_employee_reviews_as("count_employee_reviews")
    }

    pub fn count_employee_reviews_as(self, alias: impl Into<String>) -> Self {
        self.count_employee_reviews_with(alias, crate::Q::employee_reviews().unlimited())
    }

    pub fn count_employee_reviews_with(mut self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        let selection = request.into();
        self.query_options.relation_aggregates.push(RelationAggregate::new(
            "employee_review_list",
            alias,
            selection,
            true,
        ));
        self
    }

    pub fn stats_from_employee_reviews(self, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_employee_reviews_as("refinements", request)
    }

    pub fn stats_from_employee_reviews_as(mut self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        let selection = request.into();
        self.query_options.relation_aggregates.push(RelationAggregate::new(
            "employee_review_list",
            alias,
            selection,
            false,
        ));
        self
    }

    pub fn group_by_employee_reviews_with_details(self, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_employee_reviews(request)
    }


    pub fn min_review_date_of_employee_reviews(self) -> Self {
        self.min_review_date_of_employee_reviews_as("min_review_date_of_employee_reviews", crate::Q::employee_reviews().unlimited())
    }

    pub fn min_review_date_of_employee_reviews_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_employee_reviews_as(alias, request.into().into_query().min("review_date", "min_review_date"))
    }
    pub fn max_review_date_of_employee_reviews(self) -> Self {
        self.max_review_date_of_employee_reviews_as("max_review_date_of_employee_reviews", crate::Q::employee_reviews().unlimited())
    }

    pub fn max_review_date_of_employee_reviews_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_employee_reviews_as(alias, request.into().into_query().max("review_date", "max_review_date"))
    }
    pub fn sum_score_of_employee_reviews(self) -> Self {
        self.sum_score_of_employee_reviews_as("sum_score_of_employee_reviews", crate::Q::employee_reviews().unlimited())
    }

    pub fn sum_score_of_employee_reviews_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_employee_reviews_as(alias, request.into().into_query().sum("score", "sum_score"))
    }
    pub fn min_score_of_employee_reviews(self) -> Self {
        self.min_score_of_employee_reviews_as("min_score_of_employee_reviews", crate::Q::employee_reviews().unlimited())
    }

    pub fn min_score_of_employee_reviews_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_employee_reviews_as(alias, request.into().into_query().min("score", "min_score"))
    }
    pub fn max_score_of_employee_reviews(self) -> Self {
        self.max_score_of_employee_reviews_as("max_score_of_employee_reviews", crate::Q::employee_reviews().unlimited())
    }

    pub fn max_score_of_employee_reviews_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_employee_reviews_as(alias, request.into().into_query().max("score", "max_score"))
    }
    pub fn avg_score_of_employee_reviews(self) -> Self {
        self.avg_score_of_employee_reviews_as("avg_score_of_employee_reviews", crate::Q::employee_reviews().unlimited())
    }

    pub fn avg_score_of_employee_reviews_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_employee_reviews_as(alias, request.into().into_query().avg("score", "avg_score"))
    }
    pub fn standard_deviation_score_of_employee_reviews(self) -> Self {
        self.standard_deviation_score_of_employee_reviews_as("standard_deviation_score_of_employee_reviews", crate::Q::employee_reviews().unlimited())
    }

    pub fn standard_deviation_score_of_employee_reviews_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_employee_reviews_as(alias, request.into().into_query().stddev("score", "stdDev_score"))
    }
    pub fn square_root_of_population_standard_deviation_score_of_employee_reviews(self) -> Self {
        self.square_root_of_population_standard_deviation_score_of_employee_reviews_as("square_root_of_population_standard_deviation_score_of_employee_reviews", crate::Q::employee_reviews().unlimited())
    }

    pub fn square_root_of_population_standard_deviation_score_of_employee_reviews_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_employee_reviews_as(alias, request.into().into_query().stddev_pop("score", "stdDevPop_score"))
    }
    pub fn sample_variance_score_of_employee_reviews(self) -> Self {
        self.sample_variance_score_of_employee_reviews_as("sample_variance_score_of_employee_reviews", crate::Q::employee_reviews().unlimited())
    }

    pub fn sample_variance_score_of_employee_reviews_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_employee_reviews_as(alias, request.into().into_query().var_samp("score", "varSamp_score"))
    }
    pub fn sample_population_variance_score_of_employee_reviews(self) -> Self {
        self.sample_population_variance_score_of_employee_reviews_as("sample_population_variance_score_of_employee_reviews", crate::Q::employee_reviews().unlimited())
    }

    pub fn sample_population_variance_score_of_employee_reviews_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_employee_reviews_as(alias, request.into().into_query().var_pop("score", "varPop_score"))
    }
    pub fn min_create_time_of_employee_reviews(self) -> Self {
        self.min_create_time_of_employee_reviews_as("min_create_time_of_employee_reviews", crate::Q::employee_reviews().unlimited())
    }

    pub fn min_create_time_of_employee_reviews_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_employee_reviews_as(alias, request.into().into_query().min("create_time", "min_create_time"))
    }
    pub fn max_create_time_of_employee_reviews(self) -> Self {
        self.max_create_time_of_employee_reviews_as("max_create_time_of_employee_reviews", crate::Q::employee_reviews().unlimited())
    }

    pub fn max_create_time_of_employee_reviews_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_employee_reviews_as(alias, request.into().into_query().max("create_time", "max_create_time"))
    }
    pub fn min_update_time_of_employee_reviews(self) -> Self {
        self.min_update_time_of_employee_reviews_as("min_update_time_of_employee_reviews", crate::Q::employee_reviews().unlimited())
    }

    pub fn min_update_time_of_employee_reviews_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_employee_reviews_as(alias, request.into().into_query().min("update_time", "min_update_time"))
    }
    pub fn max_update_time_of_employee_reviews(self) -> Self {
        self.max_update_time_of_employee_reviews_as("max_update_time_of_employee_reviews", crate::Q::employee_reviews().unlimited())
    }

    pub fn max_update_time_of_employee_reviews_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_employee_reviews_as(alias, request.into().into_query().max("update_time", "max_update_time"))
    }

    pub fn count_payrolls(self) -> Self {
        self.count_payrolls_as("count_payrolls")
    }

    pub fn count_payrolls_as(self, alias: impl Into<String>) -> Self {
        self.count_payrolls_with(alias, crate::Q::payrolls().unlimited())
    }

    pub fn count_payrolls_with(mut self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        let selection = request.into();
        self.query_options.relation_aggregates.push(RelationAggregate::new(
            "payroll_list",
            alias,
            selection,
            true,
        ));
        self
    }

    pub fn stats_from_payrolls(self, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_payrolls_as("refinements", request)
    }

    pub fn stats_from_payrolls_as(mut self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        let selection = request.into();
        self.query_options.relation_aggregates.push(RelationAggregate::new(
            "payroll_list",
            alias,
            selection,
            false,
        ));
        self
    }

    pub fn group_by_payrolls_with_details(self, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_payrolls(request)
    }


    pub fn sum_tax_of_payrolls(self) -> Self {
        self.sum_tax_of_payrolls_as("sum_tax_of_payrolls", crate::Q::payrolls().unlimited())
    }

    pub fn sum_tax_of_payrolls_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_payrolls_as(alias, request.into().into_query().sum("tax", "sum_tax"))
    }
    pub fn min_tax_of_payrolls(self) -> Self {
        self.min_tax_of_payrolls_as("min_tax_of_payrolls", crate::Q::payrolls().unlimited())
    }

    pub fn min_tax_of_payrolls_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_payrolls_as(alias, request.into().into_query().min("tax", "min_tax"))
    }
    pub fn max_tax_of_payrolls(self) -> Self {
        self.max_tax_of_payrolls_as("max_tax_of_payrolls", crate::Q::payrolls().unlimited())
    }

    pub fn max_tax_of_payrolls_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_payrolls_as(alias, request.into().into_query().max("tax", "max_tax"))
    }
    pub fn avg_tax_of_payrolls(self) -> Self {
        self.avg_tax_of_payrolls_as("avg_tax_of_payrolls", crate::Q::payrolls().unlimited())
    }

    pub fn avg_tax_of_payrolls_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_payrolls_as(alias, request.into().into_query().avg("tax", "avg_tax"))
    }
    pub fn standard_deviation_tax_of_payrolls(self) -> Self {
        self.standard_deviation_tax_of_payrolls_as("standard_deviation_tax_of_payrolls", crate::Q::payrolls().unlimited())
    }

    pub fn standard_deviation_tax_of_payrolls_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_payrolls_as(alias, request.into().into_query().stddev("tax", "stdDev_tax"))
    }
    pub fn square_root_of_population_standard_deviation_tax_of_payrolls(self) -> Self {
        self.square_root_of_population_standard_deviation_tax_of_payrolls_as("square_root_of_population_standard_deviation_tax_of_payrolls", crate::Q::payrolls().unlimited())
    }

    pub fn square_root_of_population_standard_deviation_tax_of_payrolls_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_payrolls_as(alias, request.into().into_query().stddev_pop("tax", "stdDevPop_tax"))
    }
    pub fn sample_variance_tax_of_payrolls(self) -> Self {
        self.sample_variance_tax_of_payrolls_as("sample_variance_tax_of_payrolls", crate::Q::payrolls().unlimited())
    }

    pub fn sample_variance_tax_of_payrolls_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_payrolls_as(alias, request.into().into_query().var_samp("tax", "varSamp_tax"))
    }
    pub fn sample_population_variance_tax_of_payrolls(self) -> Self {
        self.sample_population_variance_tax_of_payrolls_as("sample_population_variance_tax_of_payrolls", crate::Q::payrolls().unlimited())
    }

    pub fn sample_population_variance_tax_of_payrolls_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_payrolls_as(alias, request.into().into_query().var_pop("tax", "varPop_tax"))
    }
    pub fn sum_gross_pay_of_payrolls(self) -> Self {
        self.sum_gross_pay_of_payrolls_as("sum_gross_pay_of_payrolls", crate::Q::payrolls().unlimited())
    }

    pub fn sum_gross_pay_of_payrolls_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_payrolls_as(alias, request.into().into_query().sum("gross_pay", "sum_gross_pay"))
    }
    pub fn min_gross_pay_of_payrolls(self) -> Self {
        self.min_gross_pay_of_payrolls_as("min_gross_pay_of_payrolls", crate::Q::payrolls().unlimited())
    }

    pub fn min_gross_pay_of_payrolls_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_payrolls_as(alias, request.into().into_query().min("gross_pay", "min_gross_pay"))
    }
    pub fn max_gross_pay_of_payrolls(self) -> Self {
        self.max_gross_pay_of_payrolls_as("max_gross_pay_of_payrolls", crate::Q::payrolls().unlimited())
    }

    pub fn max_gross_pay_of_payrolls_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_payrolls_as(alias, request.into().into_query().max("gross_pay", "max_gross_pay"))
    }
    pub fn avg_gross_pay_of_payrolls(self) -> Self {
        self.avg_gross_pay_of_payrolls_as("avg_gross_pay_of_payrolls", crate::Q::payrolls().unlimited())
    }

    pub fn avg_gross_pay_of_payrolls_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_payrolls_as(alias, request.into().into_query().avg("gross_pay", "avg_gross_pay"))
    }
    pub fn standard_deviation_gross_pay_of_payrolls(self) -> Self {
        self.standard_deviation_gross_pay_of_payrolls_as("standard_deviation_gross_pay_of_payrolls", crate::Q::payrolls().unlimited())
    }

    pub fn standard_deviation_gross_pay_of_payrolls_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_payrolls_as(alias, request.into().into_query().stddev("gross_pay", "stdDev_gross_pay"))
    }
    pub fn square_root_of_population_standard_deviation_gross_pay_of_payrolls(self) -> Self {
        self.square_root_of_population_standard_deviation_gross_pay_of_payrolls_as("square_root_of_population_standard_deviation_gross_pay_of_payrolls", crate::Q::payrolls().unlimited())
    }

    pub fn square_root_of_population_standard_deviation_gross_pay_of_payrolls_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_payrolls_as(alias, request.into().into_query().stddev_pop("gross_pay", "stdDevPop_gross_pay"))
    }
    pub fn sample_variance_gross_pay_of_payrolls(self) -> Self {
        self.sample_variance_gross_pay_of_payrolls_as("sample_variance_gross_pay_of_payrolls", crate::Q::payrolls().unlimited())
    }

    pub fn sample_variance_gross_pay_of_payrolls_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_payrolls_as(alias, request.into().into_query().var_samp("gross_pay", "varSamp_gross_pay"))
    }
    pub fn sample_population_variance_gross_pay_of_payrolls(self) -> Self {
        self.sample_population_variance_gross_pay_of_payrolls_as("sample_population_variance_gross_pay_of_payrolls", crate::Q::payrolls().unlimited())
    }

    pub fn sample_population_variance_gross_pay_of_payrolls_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_payrolls_as(alias, request.into().into_query().var_pop("gross_pay", "varPop_gross_pay"))
    }
    pub fn sum_net_pay_of_payrolls(self) -> Self {
        self.sum_net_pay_of_payrolls_as("sum_net_pay_of_payrolls", crate::Q::payrolls().unlimited())
    }

    pub fn sum_net_pay_of_payrolls_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_payrolls_as(alias, request.into().into_query().sum("net_pay", "sum_net_pay"))
    }
    pub fn min_net_pay_of_payrolls(self) -> Self {
        self.min_net_pay_of_payrolls_as("min_net_pay_of_payrolls", crate::Q::payrolls().unlimited())
    }

    pub fn min_net_pay_of_payrolls_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_payrolls_as(alias, request.into().into_query().min("net_pay", "min_net_pay"))
    }
    pub fn max_net_pay_of_payrolls(self) -> Self {
        self.max_net_pay_of_payrolls_as("max_net_pay_of_payrolls", crate::Q::payrolls().unlimited())
    }

    pub fn max_net_pay_of_payrolls_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_payrolls_as(alias, request.into().into_query().max("net_pay", "max_net_pay"))
    }
    pub fn avg_net_pay_of_payrolls(self) -> Self {
        self.avg_net_pay_of_payrolls_as("avg_net_pay_of_payrolls", crate::Q::payrolls().unlimited())
    }

    pub fn avg_net_pay_of_payrolls_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_payrolls_as(alias, request.into().into_query().avg("net_pay", "avg_net_pay"))
    }
    pub fn standard_deviation_net_pay_of_payrolls(self) -> Self {
        self.standard_deviation_net_pay_of_payrolls_as("standard_deviation_net_pay_of_payrolls", crate::Q::payrolls().unlimited())
    }

    pub fn standard_deviation_net_pay_of_payrolls_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_payrolls_as(alias, request.into().into_query().stddev("net_pay", "stdDev_net_pay"))
    }
    pub fn square_root_of_population_standard_deviation_net_pay_of_payrolls(self) -> Self {
        self.square_root_of_population_standard_deviation_net_pay_of_payrolls_as("square_root_of_population_standard_deviation_net_pay_of_payrolls", crate::Q::payrolls().unlimited())
    }

    pub fn square_root_of_population_standard_deviation_net_pay_of_payrolls_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_payrolls_as(alias, request.into().into_query().stddev_pop("net_pay", "stdDevPop_net_pay"))
    }
    pub fn sample_variance_net_pay_of_payrolls(self) -> Self {
        self.sample_variance_net_pay_of_payrolls_as("sample_variance_net_pay_of_payrolls", crate::Q::payrolls().unlimited())
    }

    pub fn sample_variance_net_pay_of_payrolls_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_payrolls_as(alias, request.into().into_query().var_samp("net_pay", "varSamp_net_pay"))
    }
    pub fn sample_population_variance_net_pay_of_payrolls(self) -> Self {
        self.sample_population_variance_net_pay_of_payrolls_as("sample_population_variance_net_pay_of_payrolls", crate::Q::payrolls().unlimited())
    }

    pub fn sample_population_variance_net_pay_of_payrolls_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_payrolls_as(alias, request.into().into_query().var_pop("net_pay", "varPop_net_pay"))
    }
    pub fn min_period_end_of_payrolls(self) -> Self {
        self.min_period_end_of_payrolls_as("min_period_end_of_payrolls", crate::Q::payrolls().unlimited())
    }

    pub fn min_period_end_of_payrolls_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_payrolls_as(alias, request.into().into_query().min("period_end", "min_period_end"))
    }
    pub fn max_period_end_of_payrolls(self) -> Self {
        self.max_period_end_of_payrolls_as("max_period_end_of_payrolls", crate::Q::payrolls().unlimited())
    }

    pub fn max_period_end_of_payrolls_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_payrolls_as(alias, request.into().into_query().max("period_end", "max_period_end"))
    }
    pub fn min_period_start_of_payrolls(self) -> Self {
        self.min_period_start_of_payrolls_as("min_period_start_of_payrolls", crate::Q::payrolls().unlimited())
    }

    pub fn min_period_start_of_payrolls_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_payrolls_as(alias, request.into().into_query().min("period_start", "min_period_start"))
    }
    pub fn max_period_start_of_payrolls(self) -> Self {
        self.max_period_start_of_payrolls_as("max_period_start_of_payrolls", crate::Q::payrolls().unlimited())
    }

    pub fn max_period_start_of_payrolls_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_payrolls_as(alias, request.into().into_query().max("period_start", "max_period_start"))
    }
    pub fn min_create_time_of_payrolls(self) -> Self {
        self.min_create_time_of_payrolls_as("min_create_time_of_payrolls", crate::Q::payrolls().unlimited())
    }

    pub fn min_create_time_of_payrolls_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_payrolls_as(alias, request.into().into_query().min("create_time", "min_create_time"))
    }
    pub fn max_create_time_of_payrolls(self) -> Self {
        self.max_create_time_of_payrolls_as("max_create_time_of_payrolls", crate::Q::payrolls().unlimited())
    }

    pub fn max_create_time_of_payrolls_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_payrolls_as(alias, request.into().into_query().max("create_time", "max_create_time"))
    }
    pub fn min_update_time_of_payrolls(self) -> Self {
        self.min_update_time_of_payrolls_as("min_update_time_of_payrolls", crate::Q::payrolls().unlimited())
    }

    pub fn min_update_time_of_payrolls_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_payrolls_as(alias, request.into().into_query().min("update_time", "min_update_time"))
    }
    pub fn max_update_time_of_payrolls(self) -> Self {
        self.max_update_time_of_payrolls_as("max_update_time_of_payrolls", crate::Q::payrolls().unlimited())
    }

    pub fn max_update_time_of_payrolls_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_payrolls_as(alias, request.into().into_query().max("update_time", "max_update_time"))
    }

    pub fn count_expenses(self) -> Self {
        self.count_expenses_as("count_expenses")
    }

    pub fn count_expenses_as(self, alias: impl Into<String>) -> Self {
        self.count_expenses_with(alias, crate::Q::expenses().unlimited())
    }

    pub fn count_expenses_with(mut self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        let selection = request.into();
        self.query_options.relation_aggregates.push(RelationAggregate::new(
            "expense_list",
            alias,
            selection,
            true,
        ));
        self
    }

    pub fn stats_from_expenses(self, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_expenses_as("refinements", request)
    }

    pub fn stats_from_expenses_as(mut self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        let selection = request.into();
        self.query_options.relation_aggregates.push(RelationAggregate::new(
            "expense_list",
            alias,
            selection,
            false,
        ));
        self
    }

    pub fn group_by_expenses_with_details(self, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_expenses(request)
    }


    pub fn sum_amount_of_expenses(self) -> Self {
        self.sum_amount_of_expenses_as("sum_amount_of_expenses", crate::Q::expenses().unlimited())
    }

    pub fn sum_amount_of_expenses_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_expenses_as(alias, request.into().into_query().sum("amount", "sum_amount"))
    }
    pub fn min_amount_of_expenses(self) -> Self {
        self.min_amount_of_expenses_as("min_amount_of_expenses", crate::Q::expenses().unlimited())
    }

    pub fn min_amount_of_expenses_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_expenses_as(alias, request.into().into_query().min("amount", "min_amount"))
    }
    pub fn max_amount_of_expenses(self) -> Self {
        self.max_amount_of_expenses_as("max_amount_of_expenses", crate::Q::expenses().unlimited())
    }

    pub fn max_amount_of_expenses_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_expenses_as(alias, request.into().into_query().max("amount", "max_amount"))
    }
    pub fn avg_amount_of_expenses(self) -> Self {
        self.avg_amount_of_expenses_as("avg_amount_of_expenses", crate::Q::expenses().unlimited())
    }

    pub fn avg_amount_of_expenses_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_expenses_as(alias, request.into().into_query().avg("amount", "avg_amount"))
    }
    pub fn standard_deviation_amount_of_expenses(self) -> Self {
        self.standard_deviation_amount_of_expenses_as("standard_deviation_amount_of_expenses", crate::Q::expenses().unlimited())
    }

    pub fn standard_deviation_amount_of_expenses_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_expenses_as(alias, request.into().into_query().stddev("amount", "stdDev_amount"))
    }
    pub fn square_root_of_population_standard_deviation_amount_of_expenses(self) -> Self {
        self.square_root_of_population_standard_deviation_amount_of_expenses_as("square_root_of_population_standard_deviation_amount_of_expenses", crate::Q::expenses().unlimited())
    }

    pub fn square_root_of_population_standard_deviation_amount_of_expenses_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_expenses_as(alias, request.into().into_query().stddev_pop("amount", "stdDevPop_amount"))
    }
    pub fn sample_variance_amount_of_expenses(self) -> Self {
        self.sample_variance_amount_of_expenses_as("sample_variance_amount_of_expenses", crate::Q::expenses().unlimited())
    }

    pub fn sample_variance_amount_of_expenses_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_expenses_as(alias, request.into().into_query().var_samp("amount", "varSamp_amount"))
    }
    pub fn sample_population_variance_amount_of_expenses(self) -> Self {
        self.sample_population_variance_amount_of_expenses_as("sample_population_variance_amount_of_expenses", crate::Q::expenses().unlimited())
    }

    pub fn sample_population_variance_amount_of_expenses_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_expenses_as(alias, request.into().into_query().var_pop("amount", "varPop_amount"))
    }
    pub fn min_date_incurred_of_expenses(self) -> Self {
        self.min_date_incurred_of_expenses_as("min_date_incurred_of_expenses", crate::Q::expenses().unlimited())
    }

    pub fn min_date_incurred_of_expenses_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_expenses_as(alias, request.into().into_query().min("date_incurred", "min_date_incurred"))
    }
    pub fn max_date_incurred_of_expenses(self) -> Self {
        self.max_date_incurred_of_expenses_as("max_date_incurred_of_expenses", crate::Q::expenses().unlimited())
    }

    pub fn max_date_incurred_of_expenses_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_expenses_as(alias, request.into().into_query().max("date_incurred", "max_date_incurred"))
    }
    pub fn min_create_time_of_expenses(self) -> Self {
        self.min_create_time_of_expenses_as("min_create_time_of_expenses", crate::Q::expenses().unlimited())
    }

    pub fn min_create_time_of_expenses_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_expenses_as(alias, request.into().into_query().min("create_time", "min_create_time"))
    }
    pub fn max_create_time_of_expenses(self) -> Self {
        self.max_create_time_of_expenses_as("max_create_time_of_expenses", crate::Q::expenses().unlimited())
    }

    pub fn max_create_time_of_expenses_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_expenses_as(alias, request.into().into_query().max("create_time", "max_create_time"))
    }
    pub fn min_update_time_of_expenses(self) -> Self {
        self.min_update_time_of_expenses_as("min_update_time_of_expenses", crate::Q::expenses().unlimited())
    }

    pub fn min_update_time_of_expenses_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_expenses_as(alias, request.into().into_query().min("update_time", "min_update_time"))
    }
    pub fn max_update_time_of_expenses(self) -> Self {
        self.max_update_time_of_expenses_as("max_update_time_of_expenses", crate::Q::expenses().unlimited())
    }

    pub fn max_update_time_of_expenses_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_expenses_as(alias, request.into().into_query().max("update_time", "max_update_time"))
    }

    pub fn count_support_agents(self) -> Self {
        self.count_support_agents_as("count_support_agents")
    }

    pub fn count_support_agents_as(self, alias: impl Into<String>) -> Self {
        self.count_support_agents_with(alias, crate::Q::support_agents().unlimited())
    }

    pub fn count_support_agents_with(mut self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        let selection = request.into();
        self.query_options.relation_aggregates.push(RelationAggregate::new(
            "support_agent_list",
            alias,
            selection,
            true,
        ));
        self
    }

    pub fn stats_from_support_agents(self, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_support_agents_as("refinements", request)
    }

    pub fn stats_from_support_agents_as(mut self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        let selection = request.into();
        self.query_options.relation_aggregates.push(RelationAggregate::new(
            "support_agent_list",
            alias,
            selection,
            false,
        ));
        self
    }

    pub fn group_by_support_agents_with_details(self, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_support_agents(request)
    }


    pub fn sum_active_tickets_of_support_agents(self) -> Self {
        self.sum_active_tickets_of_support_agents_as("sum_active_tickets_of_support_agents", crate::Q::support_agents().unlimited())
    }

    pub fn sum_active_tickets_of_support_agents_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_support_agents_as(alias, request.into().into_query().sum("active_tickets", "sum_active_tickets"))
    }
    pub fn min_active_tickets_of_support_agents(self) -> Self {
        self.min_active_tickets_of_support_agents_as("min_active_tickets_of_support_agents", crate::Q::support_agents().unlimited())
    }

    pub fn min_active_tickets_of_support_agents_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_support_agents_as(alias, request.into().into_query().min("active_tickets", "min_active_tickets"))
    }
    pub fn max_active_tickets_of_support_agents(self) -> Self {
        self.max_active_tickets_of_support_agents_as("max_active_tickets_of_support_agents", crate::Q::support_agents().unlimited())
    }

    pub fn max_active_tickets_of_support_agents_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_support_agents_as(alias, request.into().into_query().max("active_tickets", "max_active_tickets"))
    }
    pub fn avg_active_tickets_of_support_agents(self) -> Self {
        self.avg_active_tickets_of_support_agents_as("avg_active_tickets_of_support_agents", crate::Q::support_agents().unlimited())
    }

    pub fn avg_active_tickets_of_support_agents_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_support_agents_as(alias, request.into().into_query().avg("active_tickets", "avg_active_tickets"))
    }
    pub fn standard_deviation_active_tickets_of_support_agents(self) -> Self {
        self.standard_deviation_active_tickets_of_support_agents_as("standard_deviation_active_tickets_of_support_agents", crate::Q::support_agents().unlimited())
    }

    pub fn standard_deviation_active_tickets_of_support_agents_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_support_agents_as(alias, request.into().into_query().stddev("active_tickets", "stdDev_active_tickets"))
    }
    pub fn square_root_of_population_standard_deviation_active_tickets_of_support_agents(self) -> Self {
        self.square_root_of_population_standard_deviation_active_tickets_of_support_agents_as("square_root_of_population_standard_deviation_active_tickets_of_support_agents", crate::Q::support_agents().unlimited())
    }

    pub fn square_root_of_population_standard_deviation_active_tickets_of_support_agents_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_support_agents_as(alias, request.into().into_query().stddev_pop("active_tickets", "stdDevPop_active_tickets"))
    }
    pub fn sample_variance_active_tickets_of_support_agents(self) -> Self {
        self.sample_variance_active_tickets_of_support_agents_as("sample_variance_active_tickets_of_support_agents", crate::Q::support_agents().unlimited())
    }

    pub fn sample_variance_active_tickets_of_support_agents_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_support_agents_as(alias, request.into().into_query().var_samp("active_tickets", "varSamp_active_tickets"))
    }
    pub fn sample_population_variance_active_tickets_of_support_agents(self) -> Self {
        self.sample_population_variance_active_tickets_of_support_agents_as("sample_population_variance_active_tickets_of_support_agents", crate::Q::support_agents().unlimited())
    }

    pub fn sample_population_variance_active_tickets_of_support_agents_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_support_agents_as(alias, request.into().into_query().var_pop("active_tickets", "varPop_active_tickets"))
    }
    pub fn min_create_time_of_support_agents(self) -> Self {
        self.min_create_time_of_support_agents_as("min_create_time_of_support_agents", crate::Q::support_agents().unlimited())
    }

    pub fn min_create_time_of_support_agents_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_support_agents_as(alias, request.into().into_query().min("create_time", "min_create_time"))
    }
    pub fn max_create_time_of_support_agents(self) -> Self {
        self.max_create_time_of_support_agents_as("max_create_time_of_support_agents", crate::Q::support_agents().unlimited())
    }

    pub fn max_create_time_of_support_agents_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_support_agents_as(alias, request.into().into_query().max("create_time", "max_create_time"))
    }
    pub fn min_update_time_of_support_agents(self) -> Self {
        self.min_update_time_of_support_agents_as("min_update_time_of_support_agents", crate::Q::support_agents().unlimited())
    }

    pub fn min_update_time_of_support_agents_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_support_agents_as(alias, request.into().into_query().min("update_time", "min_update_time"))
    }
    pub fn max_update_time_of_support_agents(self) -> Self {
        self.max_update_time_of_support_agents_as("max_update_time_of_support_agents", crate::Q::support_agents().unlimited())
    }

    pub fn max_update_time_of_support_agents_as(self, alias: impl Into<String>, request: impl Into<QuerySelection>) -> Self {
        self.stats_from_support_agents_as(alias, request.into().into_query().max("update_time", "max_update_time"))
    }
}

impl<R> Default for EmployeeRequest<R> {
    fn default() -> Self {
        Self::new()
    }
}

impl<R> From< EmployeeRequest<R> > for SelectQuery {
    fn from(request: EmployeeRequest<R>) -> Self {
        QuerySelection::from(request).into_query()
    }
}

impl<R> From< EmployeeRequest<R> > for QuerySelection {
    fn from(request: EmployeeRequest<R>) -> Self {
        Self {
            query: request.query,
            relation_selections: request.relation_selections,
            relation_filters: request.relation_filters,
            child_enhancements: request.child_enhancements,
            query_options: request.query_options,
        }
    }
}


impl<'a, C> crate::request_support::AuditedSave<'a, C> for teaql_core::Audited<crate::Employee> 
where C: crate::request_support::TeaqlRepositoryProvider + ?Sized + 'a
{
    type Error = crate::TeaqlDataServiceError<C::EmployeeRepository<'a>>;
    fn save(self, ctx: &'a C) -> std::pin::Pin<Box<dyn std::future::Future<Output = Result<teaql_runtime::GraphNode, Self::Error>> + '_>> {
        Box::pin(async move {
            teaql_runtime::save_audited_ledger_entity(self, ctx.user_context())
                .await
                .map_err(DataServiceError::Runtime)
        })
    }
}

impl<R: teaql_core::Entity> crate::PurposedQuery<EmployeeRequest<R>> {
    pub fn new_entity<C>(&self, ctx: &C) -> crate::Employee
    where
        C: crate::TeaqlRuntime + ?Sized,
    {
        crate::Employee::runtime_new(ctx.user_context().entity_root())
    }

    fn into_inner_with_trace(mut self) -> EmployeeRequest<R> {
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
    ) -> Result<teaql_core::SmartList<R>, crate::request_support::TeaqlDataServiceError<C::EmployeeRepository<'a>>>
    where
        C: crate::request_support::TeaqlRepositoryProvider + ?Sized,
    {
        self.into_inner_with_trace()._execute_for_page(ctx, offset, limit).await
    }

    pub async fn execute_for_exists<'a, C>(
        self,
        ctx: &'a C,
    ) -> Result<bool, crate::request_support::TeaqlDataServiceError<C::EmployeeRepository<'a>>>
    where
        C: crate::request_support::TeaqlRepositoryProvider + ?Sized,
    {
        self.into_inner_with_trace()._execute_for_exists(ctx).await
    }

    pub async fn execute_for_list<'a, C>(self, ctx: &'a C) -> Result<teaql_core::SmartList<R>, crate::request_support::TeaqlDataServiceError<C::EmployeeRepository<'a>>>
    where
        C: crate::request_support::TeaqlRepositoryProvider + ?Sized,
    {
        self.into_inner_with_trace()._execute_for_list(ctx).await
    }

    /// Execute query in streaming mode (chunked).
    /// Returns a Vec of StreamChunk, each containing up to chunk_size rows.
    /// Set chunk size via .stream(chunk_size) or .stream_default() on the query.
    pub async fn execute_for_stream<'a, C>(self, ctx: &'a C) -> Result<Vec<teaql_data_service::StreamChunk>, crate::request_support::TeaqlDataServiceError<C::EmployeeRepository<'a>>>
    where
        C: crate::request_support::TeaqlRepositoryProvider + ?Sized,
    {
        self.into_inner_with_trace()._execute_for_stream(ctx).await
    }

    pub async fn execute_for_first<'a, C>(self, ctx: &'a C) -> Result<Option<R>, crate::request_support::TeaqlDataServiceError<C::EmployeeRepository<'a>>>
    where
        C: crate::request_support::TeaqlRepositoryProvider + ?Sized,
    {
        self.into_inner_with_trace()._execute_for_first(ctx).await
    }

    pub async fn execute_for_one<'a, C>(self, ctx: &'a C) -> Result<Option<R>, crate::request_support::TeaqlDataServiceError<C::EmployeeRepository<'a>>>
    where
        C: crate::request_support::TeaqlRepositoryProvider + ?Sized,
    {
        self.into_inner_with_trace()._execute_for_one(ctx).await
    }


    pub async fn execute_for_records<'a, C>(self, ctx: &'a C) -> Result<teaql_core::SmartList<teaql_core::Record>, crate::request_support::TeaqlDataServiceError<C::EmployeeRepository<'a>>>
    where
        C: crate::request_support::TeaqlRepositoryProvider + ?Sized,
    {
        self.into_inner_with_trace()._execute_for_records(ctx).await
    }

    pub async fn execute_for_record<'a, C>(self, ctx: &'a C) -> Result<Option<teaql_core::Record>, crate::request_support::TeaqlDataServiceError<C::EmployeeRepository<'a>>>
    where
        C: crate::request_support::TeaqlRepositoryProvider + ?Sized,
    {
        self.into_inner_with_trace()._execute_for_record(ctx).await
    }

    pub async fn execute_for_count<'a, C>(self, ctx: &'a C) -> Result<u64, crate::request_support::TeaqlDataServiceError<C::EmployeeRepository<'a>>>
    where
        C: crate::request_support::TeaqlRepositoryProvider + ?Sized,
    {
        self.into_inner_with_trace()._execute_for_count(ctx).await
    }
}
