
package com.example.enterpriseerpsystem.department;

import com.example.enterpriseerpsystem.Q;
import com.example.enterpriseerpsystem.employee.Employee;
import com.example.enterpriseerpsystem.employee.EmployeeRequest;
import io.teaql.core.AggrFunction;
import io.teaql.core.BaseRequest;
import io.teaql.core.PropertyReference;
import io.teaql.core.SearchCriteria;
import io.teaql.core.SubQuerySearchCriteria;
import io.teaql.core.criteria.Operator;
import io.teaql.core.criteria.TwoOperatorCriteria;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

public class DepartmentRequest<T extends Department> extends BaseRequest<T> {

    /**
     * @deprecated AI agents and business code must use the generated Q facade
     *             instead of constructing request builders directly.
     */
    @Deprecated
    public DepartmentRequest(Class<T> returnType){
        super(returnType);
        selectId();
        selectVersion();
    }

    public DepartmentRequest<T> comment(String comment){
         super.internalComment(comment);
         return this;
    }

    // purpose() 继承自 BaseRequest，返回 ExecutableRequest（终结方法）

    public DepartmentRequest<T> returnType(Class<? extends T> returnType){
        super.setReturnType(returnType);
        return this;
    }

    public DepartmentRequest<T> enableAggregationCache(long cacheExpiredMillis){
        super.enableAggregationCache();
        super.aggregateCacheTime(cacheExpiredMillis);
        return this;
    }

    public DepartmentRequest<T> enableAggregationCache(){
        return enableAggregationCache(0l);
    }


    public DepartmentRequest<T> propagateAggregationCache(long cacheExpiredMillis){
        super.propagateAggregationCache(cacheExpiredMillis);
        return this;
    }

    public DepartmentRequest<T> appendSearchCriteria(SearchCriteria searchCriteria){
        return (DepartmentRequest<T>)super.appendSearchCriteria(searchCriteria);
    }

    public DepartmentRequest<T> filter(String property1, Operator operator, String property2){
        return appendSearchCriteria(new TwoOperatorCriteria(operator, new PropertyReference(property1), new PropertyReference(property2)));
    }


    public DepartmentRequest<T> matchingAnyOf(DepartmentRequest department){
        super.internalMatchAny(department);
        return this;
    }

    public DepartmentRequest<T> enhanceChildrenIfNeeded(){
        return this;
    }

    public DepartmentRequest<T> withDeletedRows(){
        super.withDeletedRows();
        return this;
    }

    public DepartmentRequest<T> deletedRowsOnly(){
        super.deletedRowsOnly();
        return this;
    }

    public DepartmentRequest<T> selectSelf(){
        super.selectSelf();
        return selectId().selectName().selectBudget().selectLocation().selectManagerId().selectCreateTime().selectUpdateTime().selectVersion();
    }

    public DepartmentRequest<T> selectSelfFields(){
        return selectSelf();
    }

    public DepartmentRequest<T> selectAll(){
        super.selectAll();
        return selectId().selectName().selectBudget().selectLocation().selectManagerId().selectCreateTime().selectUpdateTime().selectVersion();
    }

    public DepartmentRequest<T> selectChildren(){
        super.selectAny();
        selectEmployeeList();
        return selectId().selectName().selectBudget().selectLocation().selectManagerId().selectCreateTime().selectUpdateTime().selectVersion();
    }


    public DepartmentRequest<T> selectId(){
       selectProperty(Department.ID_PROPERTY);
       return this;
    }

    /**
     * fill the id with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  id) to fetch id property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public DepartmentRequest<T> unselectId(){
       unselectProperty(Department.ID_PROPERTY);
       return this;
    }
    public DepartmentRequest<T> selectName(){
       selectProperty(Department.NAME_PROPERTY);
       return this;
    }

    /**
     * fill the name with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  name) to fetch name property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public DepartmentRequest<T> unselectName(){
       unselectProperty(Department.NAME_PROPERTY);
       return this;
    }
    public DepartmentRequest<T> selectBudget(){
       selectProperty(Department.BUDGET_PROPERTY);
       return this;
    }

    /**
     * fill the budget with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  budget) to fetch budget property.
     * @param rawSqlSegment  customized rawSqlSegment
     */


    /**
     * fill the budget with customized aggrFunction, TEAQL uses ({aggrFunction}(budget) AS budget to fetch budget property.
     * @param aggrFunction  aggrFunction
     */
    public DepartmentRequest<T> selectBudget(AggrFunction aggrFunction){
       selectProperty(Department.BUDGET_PROPERTY, aggrFunction);
       return this;
    }


    public DepartmentRequest<T> unselectBudget(){
       unselectProperty(Department.BUDGET_PROPERTY);
       return this;
    }
    public DepartmentRequest<T> selectLocation(){
       selectProperty(Department.LOCATION_PROPERTY);
       return this;
    }

    /**
     * fill the location with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  location) to fetch location property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public DepartmentRequest<T> unselectLocation(){
       unselectProperty(Department.LOCATION_PROPERTY);
       return this;
    }
    public DepartmentRequest<T> selectManagerId(){
       selectProperty(Department.MANAGER_ID_PROPERTY);
       return this;
    }

    /**
     * fill the managerId with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  managerId) to fetch managerId property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public DepartmentRequest<T> unselectManagerId(){
       unselectProperty(Department.MANAGER_ID_PROPERTY);
       return this;
    }
    public DepartmentRequest<T> selectCreateTime(){
       selectProperty(Department.CREATE_TIME_PROPERTY);
       return this;
    }

    /**
     * fill the createTime with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  createTime) to fetch createTime property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public DepartmentRequest<T> unselectCreateTime(){
       unselectProperty(Department.CREATE_TIME_PROPERTY);
       return this;
    }
    public DepartmentRequest<T> selectUpdateTime(){
       selectProperty(Department.UPDATE_TIME_PROPERTY);
       return this;
    }

    /**
     * fill the updateTime with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  updateTime) to fetch updateTime property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public DepartmentRequest<T> unselectUpdateTime(){
       unselectProperty(Department.UPDATE_TIME_PROPERTY);
       return this;
    }
    public DepartmentRequest<T> selectVersion(){
       selectProperty(Department.VERSION_PROPERTY);
       return this;
    }

    /**
     * fill the version with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  version) to fetch version property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public DepartmentRequest<T> unselectVersion(){
       unselectProperty(Department.VERSION_PROPERTY);
       return this;
    }
    public DepartmentRequest<T> selectEmployeeList(){
       return selectEmployeeListWith(Q.employees().selectSelf());
    }

    public DepartmentRequest<T> selectEmployeeListWith(EmployeeRequest employeeList){
       enhanceRelation(Department.EMPLOYEE_LIST_PROPERTY, employeeList);
       return this;
    }

    public DepartmentRequest<T> withId(Operator operator, Object... values){
       return appendSearchCriteria(createIdCriteria(operator, values));
    }

    public SearchCriteria createIdCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Department.ID_PROPERTY, operator, values);
    }

    public DepartmentRequest<T> withIdIs(Long id){
       return withId(Operator.EQUAL, id);
    }
    public DepartmentRequest<T> withIdIn(Long... id){
       return withId(Operator.EQUAL, (Object[])id);
    }



    public DepartmentRequest<T> filterByName(String... name){
      if (name == null || name.length == 0) {
        throw new IllegalArgumentException("filterByName parameter name cannot be empty");
      }
      return appendSearchCriteria(createNameCriteria(Operator.EQUAL, (Object[])name));
    }

    public DepartmentRequest<T> withName(Operator operator, Object... values){
       return appendSearchCriteria(createNameCriteria(operator, values));
    }

    public DepartmentRequest<T> withNameIsUnknown(){
       return withName(Operator.IS_NULL);
    }

    public DepartmentRequest<T> withNameIsKnown(){
       return withName(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createNameCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Department.NAME_PROPERTY, operator, values);
    }

    public DepartmentRequest<T> withNameGreaterThan(String name){
       return withName(Operator.GREATER_THAN, name);
    }

    public DepartmentRequest<T> withNameGreaterThanOrEqualTo(String name){
       return withName(Operator.GREATER_THAN_OR_EQUAL, name);
    }

    public DepartmentRequest<T> withNameLessThan(String name){
       return withName(Operator.LESS_THAN, name);
    }

    public DepartmentRequest<T> withNameLessThanOrEqualTo(String name){
       return withName(Operator.LESS_THAN_OR_EQUAL, name);
    }

    public DepartmentRequest<T> withNameBetween(String startOfName, String endOfName){
       return withName(Operator.BETWEEN, startOfName, endOfName);
    }
    public DepartmentRequest<T> withNameStartingWith(String name){
       return withName(Operator.BEGIN_WITH, name);
    }
    public DepartmentRequest<T> withNameContaining(String name){
       return withName(Operator.CONTAIN, name);
    }

    public DepartmentRequest<T> withNameEndingWith(String name){
       return withName(Operator.END_WITH, name);
    }

    public DepartmentRequest<T> withNameIs(String name){
       return withName(Operator.EQUAL, name);
    }

    public DepartmentRequest<T> withNameSoundingLike(String name){
       return withName(Operator.SOUNDS_LIKE, name);
    }



    public DepartmentRequest<T> filterByBudget(BigDecimal... budget){
      if (budget == null || budget.length == 0) {
        throw new IllegalArgumentException("filterByBudget parameter budget cannot be empty");
      }
      return appendSearchCriteria(createBudgetCriteria(Operator.EQUAL, (Object[])budget));
    }

    public DepartmentRequest<T> withBudget(Operator operator, Object... values){
       return appendSearchCriteria(createBudgetCriteria(operator, values));
    }

    public DepartmentRequest<T> withBudgetIsUnknown(){
       return withBudget(Operator.IS_NULL);
    }

    public DepartmentRequest<T> withBudgetIsKnown(){
       return withBudget(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createBudgetCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Department.BUDGET_PROPERTY, operator, values);
    }

    public DepartmentRequest<T> withBudgetGreaterThan(BigDecimal budget){
       return withBudget(Operator.GREATER_THAN, budget);
    }

    public DepartmentRequest<T> withBudgetGreaterThanOrEqualTo(BigDecimal budget){
       return withBudget(Operator.GREATER_THAN_OR_EQUAL, budget);
    }

    public DepartmentRequest<T> withBudgetLessThan(BigDecimal budget){
       return withBudget(Operator.LESS_THAN, budget);
    }

    public DepartmentRequest<T> withBudgetLessThanOrEqualTo(BigDecimal budget){
       return withBudget(Operator.LESS_THAN_OR_EQUAL, budget);
    }

    public DepartmentRequest<T> withBudgetBetween(BigDecimal startOfBudget, BigDecimal endOfBudget){
       return withBudget(Operator.BETWEEN, startOfBudget, endOfBudget);
    }



    public DepartmentRequest<T> filterByLocation(String... location){
      if (location == null || location.length == 0) {
        throw new IllegalArgumentException("filterByLocation parameter location cannot be empty");
      }
      return appendSearchCriteria(createLocationCriteria(Operator.EQUAL, (Object[])location));
    }

    public DepartmentRequest<T> withLocation(Operator operator, Object... values){
       return appendSearchCriteria(createLocationCriteria(operator, values));
    }

    public DepartmentRequest<T> withLocationIsUnknown(){
       return withLocation(Operator.IS_NULL);
    }

    public DepartmentRequest<T> withLocationIsKnown(){
       return withLocation(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createLocationCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Department.LOCATION_PROPERTY, operator, values);
    }

    public DepartmentRequest<T> withLocationGreaterThan(String location){
       return withLocation(Operator.GREATER_THAN, location);
    }

    public DepartmentRequest<T> withLocationGreaterThanOrEqualTo(String location){
       return withLocation(Operator.GREATER_THAN_OR_EQUAL, location);
    }

    public DepartmentRequest<T> withLocationLessThan(String location){
       return withLocation(Operator.LESS_THAN, location);
    }

    public DepartmentRequest<T> withLocationLessThanOrEqualTo(String location){
       return withLocation(Operator.LESS_THAN_OR_EQUAL, location);
    }

    public DepartmentRequest<T> withLocationBetween(String startOfLocation, String endOfLocation){
       return withLocation(Operator.BETWEEN, startOfLocation, endOfLocation);
    }
    public DepartmentRequest<T> withLocationStartingWith(String location){
       return withLocation(Operator.BEGIN_WITH, location);
    }
    public DepartmentRequest<T> withLocationContaining(String location){
       return withLocation(Operator.CONTAIN, location);
    }

    public DepartmentRequest<T> withLocationEndingWith(String location){
       return withLocation(Operator.END_WITH, location);
    }

    public DepartmentRequest<T> withLocationIs(String location){
       return withLocation(Operator.EQUAL, location);
    }

    public DepartmentRequest<T> withLocationSoundingLike(String location){
       return withLocation(Operator.SOUNDS_LIKE, location);
    }



    public DepartmentRequest<T> filterByManagerId(String... managerId){
      if (managerId == null || managerId.length == 0) {
        throw new IllegalArgumentException("filterByManagerId parameter managerId cannot be empty");
      }
      return appendSearchCriteria(createManagerIdCriteria(Operator.EQUAL, (Object[])managerId));
    }

    public DepartmentRequest<T> withManagerId(Operator operator, Object... values){
       return appendSearchCriteria(createManagerIdCriteria(operator, values));
    }

    public DepartmentRequest<T> withManagerIdIsUnknown(){
       return withManagerId(Operator.IS_NULL);
    }

    public DepartmentRequest<T> withManagerIdIsKnown(){
       return withManagerId(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createManagerIdCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Department.MANAGER_ID_PROPERTY, operator, values);
    }

    public DepartmentRequest<T> withManagerIdGreaterThan(String managerId){
       return withManagerId(Operator.GREATER_THAN, managerId);
    }

    public DepartmentRequest<T> withManagerIdGreaterThanOrEqualTo(String managerId){
       return withManagerId(Operator.GREATER_THAN_OR_EQUAL, managerId);
    }

    public DepartmentRequest<T> withManagerIdLessThan(String managerId){
       return withManagerId(Operator.LESS_THAN, managerId);
    }

    public DepartmentRequest<T> withManagerIdLessThanOrEqualTo(String managerId){
       return withManagerId(Operator.LESS_THAN_OR_EQUAL, managerId);
    }

    public DepartmentRequest<T> withManagerIdBetween(String startOfManagerId, String endOfManagerId){
       return withManagerId(Operator.BETWEEN, startOfManagerId, endOfManagerId);
    }
    public DepartmentRequest<T> withManagerIdStartingWith(String managerId){
       return withManagerId(Operator.BEGIN_WITH, managerId);
    }
    public DepartmentRequest<T> withManagerIdContaining(String managerId){
       return withManagerId(Operator.CONTAIN, managerId);
    }

    public DepartmentRequest<T> withManagerIdEndingWith(String managerId){
       return withManagerId(Operator.END_WITH, managerId);
    }

    public DepartmentRequest<T> withManagerIdIs(String managerId){
       return withManagerId(Operator.EQUAL, managerId);
    }

    public DepartmentRequest<T> withManagerIdSoundingLike(String managerId){
       return withManagerId(Operator.SOUNDS_LIKE, managerId);
    }



    public DepartmentRequest<T> filterByCreateTime(LocalDateTime... createTime){
      if (createTime == null || createTime.length == 0) {
        throw new IllegalArgumentException("filterByCreateTime parameter createTime cannot be empty");
      }
      return appendSearchCriteria(createCreateTimeCriteria(Operator.EQUAL, (Object[])createTime));
    }

    public DepartmentRequest<T> withCreateTime(Operator operator, Object... values){
       return appendSearchCriteria(createCreateTimeCriteria(operator, values));
    }

    public DepartmentRequest<T> withCreateTimeIsUnknown(){
       return withCreateTime(Operator.IS_NULL);
    }

    public DepartmentRequest<T> withCreateTimeIsKnown(){
       return withCreateTime(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createCreateTimeCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Department.CREATE_TIME_PROPERTY, operator, values);
    }

    public DepartmentRequest<T> withCreateTimeGreaterThan(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public DepartmentRequest<T> withCreateTimeGreaterThanOrEqualTo(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN_OR_EQUAL, createTime);
    }

    public DepartmentRequest<T> withCreateTimeLessThan(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public DepartmentRequest<T> withCreateTimeLessThanOrEqualTo(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN_OR_EQUAL, createTime);
    }

    public DepartmentRequest<T> withCreateTimeBetween(LocalDateTime startOfCreateTime, LocalDateTime endOfCreateTime){
       return withCreateTime(Operator.BETWEEN, startOfCreateTime, endOfCreateTime);
    }
    public DepartmentRequest<T> withCreateTimeBefore(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public DepartmentRequest<T> withCreateTimeBefore(Date createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public DepartmentRequest<T> withCreateTimeAfter(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public DepartmentRequest<T> withCreateTimeAfter(Date createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public DepartmentRequest<T> withCreateTimeBetween(Date startOfCreateTime, Date endOfCreateTime){
       return withCreateTime(Operator.BETWEEN, startOfCreateTime, endOfCreateTime);
    }




    public DepartmentRequest<T> filterByUpdateTime(LocalDateTime... updateTime){
      if (updateTime == null || updateTime.length == 0) {
        throw new IllegalArgumentException("filterByUpdateTime parameter updateTime cannot be empty");
      }
      return appendSearchCriteria(createUpdateTimeCriteria(Operator.EQUAL, (Object[])updateTime));
    }

    public DepartmentRequest<T> withUpdateTime(Operator operator, Object... values){
       return appendSearchCriteria(createUpdateTimeCriteria(operator, values));
    }

    public DepartmentRequest<T> withUpdateTimeIsUnknown(){
       return withUpdateTime(Operator.IS_NULL);
    }

    public DepartmentRequest<T> withUpdateTimeIsKnown(){
       return withUpdateTime(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createUpdateTimeCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Department.UPDATE_TIME_PROPERTY, operator, values);
    }

    public DepartmentRequest<T> withUpdateTimeGreaterThan(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public DepartmentRequest<T> withUpdateTimeGreaterThanOrEqualTo(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN_OR_EQUAL, updateTime);
    }

    public DepartmentRequest<T> withUpdateTimeLessThan(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public DepartmentRequest<T> withUpdateTimeLessThanOrEqualTo(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN_OR_EQUAL, updateTime);
    }

    public DepartmentRequest<T> withUpdateTimeBetween(LocalDateTime startOfUpdateTime, LocalDateTime endOfUpdateTime){
       return withUpdateTime(Operator.BETWEEN, startOfUpdateTime, endOfUpdateTime);
    }
    public DepartmentRequest<T> withUpdateTimeBefore(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public DepartmentRequest<T> withUpdateTimeBefore(Date updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public DepartmentRequest<T> withUpdateTimeAfter(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public DepartmentRequest<T> withUpdateTimeAfter(Date updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public DepartmentRequest<T> withUpdateTimeBetween(Date startOfUpdateTime, Date endOfUpdateTime){
       return withUpdateTime(Operator.BETWEEN, startOfUpdateTime, endOfUpdateTime);
    }




    public DepartmentRequest<T> filterByVersion(Long... version){
      if (version == null || version.length == 0) {
        throw new IllegalArgumentException("filterByVersion parameter version cannot be empty");
      }
      return appendSearchCriteria(createVersionCriteria(Operator.EQUAL, (Object[])version));
    }

    public DepartmentRequest<T> withVersion(Operator operator, Object... values){
       return appendSearchCriteria(createVersionCriteria(operator, values));
    }

    public DepartmentRequest<T> withVersionIsUnknown(){
       return withVersion(Operator.IS_NULL);
    }

    public DepartmentRequest<T> withVersionIsKnown(){
       return withVersion(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createVersionCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Department.VERSION_PROPERTY, operator, values);
    }

    public DepartmentRequest<T> withVersionGreaterThan(Long version){
       return withVersion(Operator.GREATER_THAN, version);
    }

    public DepartmentRequest<T> withVersionGreaterThanOrEqualTo(Long version){
       return withVersion(Operator.GREATER_THAN_OR_EQUAL, version);
    }

    public DepartmentRequest<T> withVersionLessThan(Long version){
       return withVersion(Operator.LESS_THAN, version);
    }

    public DepartmentRequest<T> withVersionLessThanOrEqualTo(Long version){
       return withVersion(Operator.LESS_THAN_OR_EQUAL, version);
    }

    public DepartmentRequest<T> withVersionBetween(Long startOfVersion, Long endOfVersion){
       return withVersion(Operator.BETWEEN, startOfVersion, endOfVersion);
    }

    public DepartmentRequest<T> withEmployeeListMatching(EmployeeRequest employeeRequest){
        return appendSearchCriteria(new SubQuerySearchCriteria(Department.ID_PROPERTY, employeeRequest, Employee.DEPARTMENT_PROPERTY));
    }

    public DepartmentRequest<T> withoutEmployeeListMatching(EmployeeRequest employeeRequest){
        return appendSearchCriteria(SearchCriteria.not(new SubQuerySearchCriteria(Department.ID_PROPERTY, employeeRequest, Employee.DEPARTMENT_PROPERTY)));
    }

    public DepartmentRequest<T> haveEmployees(){
        return withEmployeeListMatching(Q.employees().unlimited());
    }

    public DepartmentRequest<T> haveNoEmployees(){
        return withoutEmployeeListMatching(Q.employees().unlimited());
    }

    public DepartmentRequest<T> count(){
        super.count();
        return this;
    }
    public DepartmentRequest<T> countAs(String retName){
        super.count(retName);
        return this;
    }
    public DepartmentRequest minBudget(){
        return minBudgetAs(prefix("minOf",Department.BUDGET_PROPERTY));
    }

    public DepartmentRequest minBudgetAs(String retName){
        super.min(retName, Department.BUDGET_PROPERTY);
        return this;
    }
    public DepartmentRequest maxBudget(){
        return maxBudgetAs(prefix("maxOf",Department.BUDGET_PROPERTY));
    }

    public DepartmentRequest maxBudgetAs(String retName){
        super.max(retName, Department.BUDGET_PROPERTY);
        return this;
    }
    public DepartmentRequest sumBudget(){
        return sumBudgetAs(prefix("sumOf",Department.BUDGET_PROPERTY));
    }

    public DepartmentRequest sumBudgetAs(String retName){
        super.sum(retName, Department.BUDGET_PROPERTY);
        return this;
    }
    public DepartmentRequest avgBudget(){
        return avgBudgetAs(prefix("avgOf",Department.BUDGET_PROPERTY));
    }

    public DepartmentRequest avgBudgetAs(String retName){
        super.avg(retName, Department.BUDGET_PROPERTY);
        return this;
    }
    public DepartmentRequest standardDeviationBudget(){
        return standardDeviationBudgetAs(prefix("standardDeviationOf",Department.BUDGET_PROPERTY));
    }

    public DepartmentRequest standardDeviationBudgetAs(String retName){
        super.standardDeviation(retName, Department.BUDGET_PROPERTY);
        return this;
    }
    public DepartmentRequest squareRootOfPopulationStandardDeviationBudget(){
        return squareRootOfPopulationStandardDeviationBudgetAs(prefix("squareRootOfPopulationStandardDeviationOf",Department.BUDGET_PROPERTY));
    }

    public DepartmentRequest squareRootOfPopulationStandardDeviationBudgetAs(String retName){
        super.squareRootOfPopulationStandardDeviation(retName, Department.BUDGET_PROPERTY);
        return this;
    }
    public DepartmentRequest sampleVarianceBudget(){
        return sampleVarianceBudgetAs(prefix("sampleVarianceOf",Department.BUDGET_PROPERTY));
    }

    public DepartmentRequest sampleVarianceBudgetAs(String retName){
        super.sampleVariance(retName, Department.BUDGET_PROPERTY);
        return this;
    }
    public DepartmentRequest samplePopulationVarianceBudget(){
        return samplePopulationVarianceBudgetAs(prefix("samplePopulationVarianceOf",Department.BUDGET_PROPERTY));
    }

    public DepartmentRequest samplePopulationVarianceBudgetAs(String retName){
        super.samplePopulationVariance(retName, Department.BUDGET_PROPERTY);
        return this;
    }
    public DepartmentRequest<T> groupByEmployeesWithDetails(EmployeeRequest subRequest){
       aggregate(Department.EMPLOYEE_LIST_PROPERTY, subRequest);
       return this;
    }

    public DepartmentRequest<T> groupById(){
       groupBy(Department.ID_PROPERTY);
       return this;
    }

    public DepartmentRequest<T> groupByIdAs(String retName){
       groupBy(retName, Department.ID_PROPERTY);
       return this;
    }

    public DepartmentRequest<T> groupByIdWithFunction(String retName, AggrFunction function){
       groupBy(retName, Department.ID_PROPERTY, function);
       return this;
    }

    public DepartmentRequest<T> groupByName(){
       groupBy(Department.NAME_PROPERTY);
       return this;
    }

    public DepartmentRequest<T> groupByNameAs(String retName){
       groupBy(retName, Department.NAME_PROPERTY);
       return this;
    }

    public DepartmentRequest<T> groupByNameWithFunction(String retName, AggrFunction function){
       groupBy(retName, Department.NAME_PROPERTY, function);
       return this;
    }

    public DepartmentRequest<T> groupByBudget(){
       groupBy(Department.BUDGET_PROPERTY);
       return this;
    }

    public DepartmentRequest<T> groupByBudgetAs(String retName){
       groupBy(retName, Department.BUDGET_PROPERTY);
       return this;
    }

    public DepartmentRequest<T> groupByBudgetWithFunction(String retName, AggrFunction function){
       groupBy(retName, Department.BUDGET_PROPERTY, function);
       return this;
    }

    public DepartmentRequest<T> groupByLocation(){
       groupBy(Department.LOCATION_PROPERTY);
       return this;
    }

    public DepartmentRequest<T> groupByLocationAs(String retName){
       groupBy(retName, Department.LOCATION_PROPERTY);
       return this;
    }

    public DepartmentRequest<T> groupByLocationWithFunction(String retName, AggrFunction function){
       groupBy(retName, Department.LOCATION_PROPERTY, function);
       return this;
    }

    public DepartmentRequest<T> groupByManagerId(){
       groupBy(Department.MANAGER_ID_PROPERTY);
       return this;
    }

    public DepartmentRequest<T> groupByManagerIdAs(String retName){
       groupBy(retName, Department.MANAGER_ID_PROPERTY);
       return this;
    }

    public DepartmentRequest<T> groupByManagerIdWithFunction(String retName, AggrFunction function){
       groupBy(retName, Department.MANAGER_ID_PROPERTY, function);
       return this;
    }

    public DepartmentRequest<T> groupByCreateTime(){
       groupBy(Department.CREATE_TIME_PROPERTY);
       return this;
    }

    public DepartmentRequest<T> groupByCreateTimeAs(String retName){
       groupBy(retName, Department.CREATE_TIME_PROPERTY);
       return this;
    }

    public DepartmentRequest<T> groupByCreateTimeWithFunction(String retName, AggrFunction function){
       groupBy(retName, Department.CREATE_TIME_PROPERTY, function);
       return this;
    }

    public DepartmentRequest<T> groupByUpdateTime(){
       groupBy(Department.UPDATE_TIME_PROPERTY);
       return this;
    }

    public DepartmentRequest<T> groupByUpdateTimeAs(String retName){
       groupBy(retName, Department.UPDATE_TIME_PROPERTY);
       return this;
    }

    public DepartmentRequest<T> groupByUpdateTimeWithFunction(String retName, AggrFunction function){
       groupBy(retName, Department.UPDATE_TIME_PROPERTY, function);
       return this;
    }

    public DepartmentRequest<T> groupByVersion(){
       groupBy(Department.VERSION_PROPERTY);
       return this;
    }

    public DepartmentRequest<T> groupByVersionAs(String retName){
       groupBy(retName, Department.VERSION_PROPERTY);
       return this;
    }

    public DepartmentRequest<T> groupByVersionWithFunction(String retName, AggrFunction function){
       groupBy(retName, Department.VERSION_PROPERTY, function);
       return this;
    }



    public DepartmentRequest<T> orderByIdAscending(){
       addOrderByAscending(Department.ID_PROPERTY);
       return this;
    }

    public DepartmentRequest<T> orderByIdDescending(){
       addOrderByDescending(Department.ID_PROPERTY);
       return this;
    }

    public DepartmentRequest<T> orderByNameAscending(){
       addOrderByAscending(Department.NAME_PROPERTY);
       return this;
    }

    public DepartmentRequest<T> orderByNameDescending(){
       addOrderByDescending(Department.NAME_PROPERTY);
       return this;
    }
    public DepartmentRequest<T> orderByNameAscendingUsingGBK(){
       addOrderByAscendingUsingGBK(Department.NAME_PROPERTY);
       return this;
    }

    public DepartmentRequest<T> orderByNameDescendingUsingGBK(){
       addOrderByDescendingUsingGBK(Department.NAME_PROPERTY);
       return this;
    }
    public DepartmentRequest<T> orderByBudgetAscending(){
       addOrderByAscending(Department.BUDGET_PROPERTY);
       return this;
    }

    public DepartmentRequest<T> orderByBudgetDescending(){
       addOrderByDescending(Department.BUDGET_PROPERTY);
       return this;
    }

    public DepartmentRequest<T> orderByLocationAscending(){
       addOrderByAscending(Department.LOCATION_PROPERTY);
       return this;
    }

    public DepartmentRequest<T> orderByLocationDescending(){
       addOrderByDescending(Department.LOCATION_PROPERTY);
       return this;
    }
    public DepartmentRequest<T> orderByLocationAscendingUsingGBK(){
       addOrderByAscendingUsingGBK(Department.LOCATION_PROPERTY);
       return this;
    }

    public DepartmentRequest<T> orderByLocationDescendingUsingGBK(){
       addOrderByDescendingUsingGBK(Department.LOCATION_PROPERTY);
       return this;
    }
    public DepartmentRequest<T> orderByManagerIdAscending(){
       addOrderByAscending(Department.MANAGER_ID_PROPERTY);
       return this;
    }

    public DepartmentRequest<T> orderByManagerIdDescending(){
       addOrderByDescending(Department.MANAGER_ID_PROPERTY);
       return this;
    }
    public DepartmentRequest<T> orderByManagerIdAscendingUsingGBK(){
       addOrderByAscendingUsingGBK(Department.MANAGER_ID_PROPERTY);
       return this;
    }

    public DepartmentRequest<T> orderByManagerIdDescendingUsingGBK(){
       addOrderByDescendingUsingGBK(Department.MANAGER_ID_PROPERTY);
       return this;
    }
    public DepartmentRequest<T> orderByCreateTimeAscending(){
       addOrderByAscending(Department.CREATE_TIME_PROPERTY);
       return this;
    }

    public DepartmentRequest<T> orderByCreateTimeDescending(){
       addOrderByDescending(Department.CREATE_TIME_PROPERTY);
       return this;
    }

    public DepartmentRequest<T> orderByUpdateTimeAscending(){
       addOrderByAscending(Department.UPDATE_TIME_PROPERTY);
       return this;
    }

    public DepartmentRequest<T> orderByUpdateTimeDescending(){
       addOrderByDescending(Department.UPDATE_TIME_PROPERTY);
       return this;
    }

    public DepartmentRequest<T> orderByVersionAscending(){
       addOrderByAscending(Department.VERSION_PROPERTY);
       return this;
    }

    public DepartmentRequest<T> orderByVersionDescending(){
       addOrderByDescending(Department.VERSION_PROPERTY);
       return this;
    }


    public DepartmentRequest<T> statsFromEmployeesAs(String name, EmployeeRequest subRequest){
       return statsFromEmployeesAs(name, subRequest, false);
    }

    public DepartmentRequest<T> statsFromEmployeesAs(String name, EmployeeRequest subRequest, boolean singleResult){
       subRequest.setPartitionProperty(Employee.DEPARTMENT_PROPERTY);
       addAggregateDynamicProperty(name, subRequest, singleResult);
       return this;
    }

    public DepartmentRequest<T> statsFromEmployees(EmployeeRequest subRequest){
       return statsFromEmployeesAs(REFINEMENTS, subRequest);
    }
    public DepartmentRequest<T> countEmployees(){
        return countEmployeesAs("Count");
    }

    public DepartmentRequest<T> countEmployeesAs(String name){
        return countEmployeesWith(name, Q.employees().unlimited());
    }

    public DepartmentRequest<T> countEmployeesWith(String name, EmployeeRequest subRequest){
        return statsFromEmployeesAs(name, subRequest.count(), true);
    }
    public DepartmentRequest<T> minSalaryOfEmployees(){
        return minSalaryOfEmployeesAs("minSalaryOfEmployees");
    }

    public DepartmentRequest<T> minSalaryOfEmployeesAs(String name){
        return minSalaryOfEmployeesAs(name, Q.employees().unlimited());
    }

    public DepartmentRequest<T> minSalaryOfEmployeesAs(String name, EmployeeRequest subRequest){
        return statsFromEmployeesAs(name, subRequest.minSalary(), true);
    }
    public DepartmentRequest<T> maxSalaryOfEmployees(){
        return maxSalaryOfEmployeesAs("maxSalaryOfEmployees");
    }

    public DepartmentRequest<T> maxSalaryOfEmployeesAs(String name){
        return maxSalaryOfEmployeesAs(name, Q.employees().unlimited());
    }

    public DepartmentRequest<T> maxSalaryOfEmployeesAs(String name, EmployeeRequest subRequest){
        return statsFromEmployeesAs(name, subRequest.maxSalary(), true);
    }
    public DepartmentRequest<T> sumSalaryOfEmployees(){
        return sumSalaryOfEmployeesAs("sumSalaryOfEmployees");
    }

    public DepartmentRequest<T> sumSalaryOfEmployeesAs(String name){
        return sumSalaryOfEmployeesAs(name, Q.employees().unlimited());
    }

    public DepartmentRequest<T> sumSalaryOfEmployeesAs(String name, EmployeeRequest subRequest){
        return statsFromEmployeesAs(name, subRequest.sumSalary(), true);
    }
    public DepartmentRequest<T> avgSalaryOfEmployees(){
        return avgSalaryOfEmployeesAs("avgSalaryOfEmployees");
    }

    public DepartmentRequest<T> avgSalaryOfEmployeesAs(String name){
        return avgSalaryOfEmployeesAs(name, Q.employees().unlimited());
    }

    public DepartmentRequest<T> avgSalaryOfEmployeesAs(String name, EmployeeRequest subRequest){
        return statsFromEmployeesAs(name, subRequest.avgSalary(), true);
    }
    public DepartmentRequest<T> standardDeviationSalaryOfEmployees(){
        return standardDeviationSalaryOfEmployeesAs("stdDevSalaryOfEmployees");
    }

    public DepartmentRequest<T> standardDeviationSalaryOfEmployeesAs(String name){
        return standardDeviationSalaryOfEmployeesAs(name, Q.employees().unlimited());
    }

    public DepartmentRequest<T> standardDeviationSalaryOfEmployeesAs(String name, EmployeeRequest subRequest){
        return statsFromEmployeesAs(name, subRequest.standardDeviationSalary(), true);
    }
    public DepartmentRequest<T> squareRootOfPopulationStandardDeviationSalaryOfEmployees(){
        return squareRootOfPopulationStandardDeviationSalaryOfEmployeesAs("stdDevPopSalaryOfEmployees");
    }

    public DepartmentRequest<T> squareRootOfPopulationStandardDeviationSalaryOfEmployeesAs(String name){
        return squareRootOfPopulationStandardDeviationSalaryOfEmployeesAs(name, Q.employees().unlimited());
    }

    public DepartmentRequest<T> squareRootOfPopulationStandardDeviationSalaryOfEmployeesAs(String name, EmployeeRequest subRequest){
        return statsFromEmployeesAs(name, subRequest.squareRootOfPopulationStandardDeviationSalary(), true);
    }
    public DepartmentRequest<T> sampleVarianceSalaryOfEmployees(){
        return sampleVarianceSalaryOfEmployeesAs("varSampSalaryOfEmployees");
    }

    public DepartmentRequest<T> sampleVarianceSalaryOfEmployeesAs(String name){
        return sampleVarianceSalaryOfEmployeesAs(name, Q.employees().unlimited());
    }

    public DepartmentRequest<T> sampleVarianceSalaryOfEmployeesAs(String name, EmployeeRequest subRequest){
        return statsFromEmployeesAs(name, subRequest.sampleVarianceSalary(), true);
    }
    public DepartmentRequest<T> samplePopulationVarianceSalaryOfEmployees(){
        return samplePopulationVarianceSalaryOfEmployeesAs("varPopSalaryOfEmployees");
    }

    public DepartmentRequest<T> samplePopulationVarianceSalaryOfEmployeesAs(String name){
        return samplePopulationVarianceSalaryOfEmployeesAs(name, Q.employees().unlimited());
    }

    public DepartmentRequest<T> samplePopulationVarianceSalaryOfEmployeesAs(String name, EmployeeRequest subRequest){
        return statsFromEmployeesAs(name, subRequest.samplePopulationVarianceSalary(), true);
    }



    /**
     * get topN records
     * @param topN  records number
     */
    public DepartmentRequest<T> top(int topN) {
        super.top(topN);
        return this;
    }

    /**
     * get records from offset(inclusive) to offset+size(exclusive)
     * @param offset record offset
     * @param size records number
     */
    public DepartmentRequest<T> offset(int offset, int size) {
        super.offset(offset, size);
        return this;
    }

    /**
     * retrieve all records
     */
    public DepartmentRequest<T> unlimited() {
        super.unlimited();
        return this;
    }

    /**
     * get records of one page
     * @param pageNumber page number(1-based)
     * @param pageSize page size
     */
    public DepartmentRequest<T> page(int pageNumber, int pageSize) {
        int offset = (pageNumber - 1) * pageSize;
        return offset(offset, pageSize);
   }

    /**
     * get records of one page, default page size is 10
     * @param pageNumber page number(1-based)
     */
    public DepartmentRequest<T> page(int pageNumber) {
        return page(pageNumber, 10);
   }
}