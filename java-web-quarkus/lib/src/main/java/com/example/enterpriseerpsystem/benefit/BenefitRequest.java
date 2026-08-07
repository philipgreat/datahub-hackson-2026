
package com.example.enterpriseerpsystem.benefit;

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

public class BenefitRequest<T extends Benefit> extends BaseRequest<T> {

    /**
     * @deprecated AI agents and business code must use the generated Q facade
     *             instead of constructing request builders directly.
     */
    @Deprecated
    public BenefitRequest(Class<T> returnType){
        super(returnType);
        selectId();
        selectVersion();
    }

    public BenefitRequest<T> comment(String comment){
         super.internalComment(comment);
         return this;
    }

    // purpose() 继承自 BaseRequest，返回 ExecutableRequest（终结方法）

    public BenefitRequest<T> returnType(Class<? extends T> returnType){
        super.setReturnType(returnType);
        return this;
    }

    public BenefitRequest<T> enableAggregationCache(long cacheExpiredMillis){
        super.enableAggregationCache();
        super.aggregateCacheTime(cacheExpiredMillis);
        return this;
    }

    public BenefitRequest<T> enableAggregationCache(){
        return enableAggregationCache(0l);
    }


    public BenefitRequest<T> propagateAggregationCache(long cacheExpiredMillis){
        super.propagateAggregationCache(cacheExpiredMillis);
        return this;
    }

    public BenefitRequest<T> appendSearchCriteria(SearchCriteria searchCriteria){
        return (BenefitRequest<T>)super.appendSearchCriteria(searchCriteria);
    }

    public BenefitRequest<T> filter(String property1, Operator operator, String property2){
        return appendSearchCriteria(new TwoOperatorCriteria(operator, new PropertyReference(property1), new PropertyReference(property2)));
    }


    public BenefitRequest<T> matchingAnyOf(BenefitRequest benefit){
        super.internalMatchAny(benefit);
        return this;
    }

    public BenefitRequest<T> enhanceChildrenIfNeeded(){
        return this;
    }

    public BenefitRequest<T> withDeletedRows(){
        super.withDeletedRows();
        return this;
    }

    public BenefitRequest<T> deletedRowsOnly(){
        super.deletedRowsOnly();
        return this;
    }

    public BenefitRequest<T> selectSelf(){
        super.selectSelf();
        return selectId().selectCost().selectEmployeeIdOnly().selectPlanType().selectProvider().selectCreateTime().selectUpdateTime().selectVersion();
    }

    public BenefitRequest<T> selectSelfFields(){
        return selectSelf();
    }

    public BenefitRequest<T> selectAll(){
        super.selectAll();
        return selectId().selectCost().selectEmployee().selectPlanType().selectProvider().selectCreateTime().selectUpdateTime().selectVersion();
    }

    public BenefitRequest<T> selectChildren(){
        super.selectAny();
        return selectId().selectCost().selectEmployee().selectPlanType().selectProvider().selectCreateTime().selectUpdateTime().selectVersion();
    }


    public BenefitRequest<T> selectId(){
       selectProperty(Benefit.ID_PROPERTY);
       return this;
    }

    /**
     * fill the id with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  id) to fetch id property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public BenefitRequest<T> unselectId(){
       unselectProperty(Benefit.ID_PROPERTY);
       return this;
    }
    public BenefitRequest<T> selectCost(){
       selectProperty(Benefit.COST_PROPERTY);
       return this;
    }

    /**
     * fill the cost with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  cost) to fetch cost property.
     * @param rawSqlSegment  customized rawSqlSegment
     */


    /**
     * fill the cost with customized aggrFunction, TEAQL uses ({aggrFunction}(cost) AS cost to fetch cost property.
     * @param aggrFunction  aggrFunction
     */
    public BenefitRequest<T> selectCost(AggrFunction aggrFunction){
       selectProperty(Benefit.COST_PROPERTY, aggrFunction);
       return this;
    }


    public BenefitRequest<T> unselectCost(){
       unselectProperty(Benefit.COST_PROPERTY);
       return this;
    }
    public BenefitRequest<T> selectEmployeeIdOnly(){
       selectProperty(Benefit.EMPLOYEE_PROPERTY);
       return this;
    }

    public BenefitRequest<T> selectEmployee(){
        return selectEmployeeWith(Q.employees().unlimited().selectSelf());
    }

    public BenefitRequest<T> selectEmployeeWith(EmployeeRequest employee){
       selectProperty(Benefit.EMPLOYEE_PROPERTY);
       enhanceRelation(Benefit.EMPLOYEE_PROPERTY, employee);
       return this;
    }

    public BenefitRequest<T> unselectEmployee(){
       unselectProperty(Benefit.EMPLOYEE_PROPERTY);
       return this;
    }
    public BenefitRequest<T> selectPlanType(){
       selectProperty(Benefit.PLAN_TYPE_PROPERTY);
       return this;
    }

    /**
     * fill the planType with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  planType) to fetch planType property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public BenefitRequest<T> unselectPlanType(){
       unselectProperty(Benefit.PLAN_TYPE_PROPERTY);
       return this;
    }
    public BenefitRequest<T> selectProvider(){
       selectProperty(Benefit.PROVIDER_PROPERTY);
       return this;
    }

    /**
     * fill the provider with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  provider) to fetch provider property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public BenefitRequest<T> unselectProvider(){
       unselectProperty(Benefit.PROVIDER_PROPERTY);
       return this;
    }
    public BenefitRequest<T> selectCreateTime(){
       selectProperty(Benefit.CREATE_TIME_PROPERTY);
       return this;
    }

    /**
     * fill the createTime with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  createTime) to fetch createTime property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public BenefitRequest<T> unselectCreateTime(){
       unselectProperty(Benefit.CREATE_TIME_PROPERTY);
       return this;
    }
    public BenefitRequest<T> selectUpdateTime(){
       selectProperty(Benefit.UPDATE_TIME_PROPERTY);
       return this;
    }

    /**
     * fill the updateTime with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  updateTime) to fetch updateTime property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public BenefitRequest<T> unselectUpdateTime(){
       unselectProperty(Benefit.UPDATE_TIME_PROPERTY);
       return this;
    }
    public BenefitRequest<T> selectVersion(){
       selectProperty(Benefit.VERSION_PROPERTY);
       return this;
    }

    /**
     * fill the version with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  version) to fetch version property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public BenefitRequest<T> unselectVersion(){
       unselectProperty(Benefit.VERSION_PROPERTY);
       return this;
    }

    public BenefitRequest<T> withId(Operator operator, Object... values){
       return appendSearchCriteria(createIdCriteria(operator, values));
    }

    public SearchCriteria createIdCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Benefit.ID_PROPERTY, operator, values);
    }

    public BenefitRequest<T> withIdIs(Long id){
       return withId(Operator.EQUAL, id);
    }
    public BenefitRequest<T> withIdIn(Long... id){
       return withId(Operator.EQUAL, (Object[])id);
    }



    public BenefitRequest<T> filterByCost(BigDecimal... cost){
      if (cost == null || cost.length == 0) {
        throw new IllegalArgumentException("filterByCost parameter cost cannot be empty");
      }
      return appendSearchCriteria(createCostCriteria(Operator.EQUAL, (Object[])cost));
    }

    public BenefitRequest<T> withCost(Operator operator, Object... values){
       return appendSearchCriteria(createCostCriteria(operator, values));
    }

    public BenefitRequest<T> withCostIsUnknown(){
       return withCost(Operator.IS_NULL);
    }

    public BenefitRequest<T> withCostIsKnown(){
       return withCost(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createCostCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Benefit.COST_PROPERTY, operator, values);
    }

    public BenefitRequest<T> withCostGreaterThan(BigDecimal cost){
       return withCost(Operator.GREATER_THAN, cost);
    }

    public BenefitRequest<T> withCostGreaterThanOrEqualTo(BigDecimal cost){
       return withCost(Operator.GREATER_THAN_OR_EQUAL, cost);
    }

    public BenefitRequest<T> withCostLessThan(BigDecimal cost){
       return withCost(Operator.LESS_THAN, cost);
    }

    public BenefitRequest<T> withCostLessThanOrEqualTo(BigDecimal cost){
       return withCost(Operator.LESS_THAN_OR_EQUAL, cost);
    }

    public BenefitRequest<T> withCostBetween(BigDecimal startOfCost, BigDecimal endOfCost){
       return withCost(Operator.BETWEEN, startOfCost, endOfCost);
    }



    public BenefitRequest<T> filterByEmployee(Employee... employee){
      if (employee == null || employee.length == 0) {
        throw new IllegalArgumentException("filterByEmployee parameter employee cannot be empty");
      }
      return appendSearchCriteria(createEmployeeCriteria(Operator.EQUAL, (Object[])employee));
    }

    public BenefitRequest<T> withEmployee(Operator operator, Object... values){
       return appendSearchCriteria(createEmployeeCriteria(operator, values));
    }

    public BenefitRequest<T> withEmployeeIsUnknown(){
       return withEmployee(Operator.IS_NULL);
    }

    public BenefitRequest<T> withEmployeeIsKnown(){
       return withEmployee(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createEmployeeCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Benefit.EMPLOYEE_PROPERTY, operator, values);
    }

    public BenefitRequest<T> filterByEmployee(Long employee){
      if(employee == null){
         return this;
      }
      return withEmployee(Operator.EQUAL, employee);
    }
    public BenefitRequest<T> withEmployeeMatching(EmployeeRequest employee){
       return appendSearchCriteria(new SubQuerySearchCriteria(Benefit.EMPLOYEE_PROPERTY, employee, Employee.ID_PROPERTY));
    }

    public BenefitRequest<T> filterByPlanType(String... planType){
      if (planType == null || planType.length == 0) {
        throw new IllegalArgumentException("filterByPlanType parameter planType cannot be empty");
      }
      return appendSearchCriteria(createPlanTypeCriteria(Operator.EQUAL, (Object[])planType));
    }

    public BenefitRequest<T> withPlanType(Operator operator, Object... values){
       return appendSearchCriteria(createPlanTypeCriteria(operator, values));
    }

    public BenefitRequest<T> withPlanTypeIsUnknown(){
       return withPlanType(Operator.IS_NULL);
    }

    public BenefitRequest<T> withPlanTypeIsKnown(){
       return withPlanType(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createPlanTypeCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Benefit.PLAN_TYPE_PROPERTY, operator, values);
    }

    public BenefitRequest<T> withPlanTypeGreaterThan(String planType){
       return withPlanType(Operator.GREATER_THAN, planType);
    }

    public BenefitRequest<T> withPlanTypeGreaterThanOrEqualTo(String planType){
       return withPlanType(Operator.GREATER_THAN_OR_EQUAL, planType);
    }

    public BenefitRequest<T> withPlanTypeLessThan(String planType){
       return withPlanType(Operator.LESS_THAN, planType);
    }

    public BenefitRequest<T> withPlanTypeLessThanOrEqualTo(String planType){
       return withPlanType(Operator.LESS_THAN_OR_EQUAL, planType);
    }

    public BenefitRequest<T> withPlanTypeBetween(String startOfPlanType, String endOfPlanType){
       return withPlanType(Operator.BETWEEN, startOfPlanType, endOfPlanType);
    }
    public BenefitRequest<T> withPlanTypeStartingWith(String planType){
       return withPlanType(Operator.BEGIN_WITH, planType);
    }
    public BenefitRequest<T> withPlanTypeContaining(String planType){
       return withPlanType(Operator.CONTAIN, planType);
    }

    public BenefitRequest<T> withPlanTypeEndingWith(String planType){
       return withPlanType(Operator.END_WITH, planType);
    }

    public BenefitRequest<T> withPlanTypeIs(String planType){
       return withPlanType(Operator.EQUAL, planType);
    }

    public BenefitRequest<T> withPlanTypeSoundingLike(String planType){
       return withPlanType(Operator.SOUNDS_LIKE, planType);
    }



    public BenefitRequest<T> filterByProvider(String... provider){
      if (provider == null || provider.length == 0) {
        throw new IllegalArgumentException("filterByProvider parameter provider cannot be empty");
      }
      return appendSearchCriteria(createProviderCriteria(Operator.EQUAL, (Object[])provider));
    }

    public BenefitRequest<T> withProvider(Operator operator, Object... values){
       return appendSearchCriteria(createProviderCriteria(operator, values));
    }

    public BenefitRequest<T> withProviderIsUnknown(){
       return withProvider(Operator.IS_NULL);
    }

    public BenefitRequest<T> withProviderIsKnown(){
       return withProvider(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createProviderCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Benefit.PROVIDER_PROPERTY, operator, values);
    }

    public BenefitRequest<T> withProviderGreaterThan(String provider){
       return withProvider(Operator.GREATER_THAN, provider);
    }

    public BenefitRequest<T> withProviderGreaterThanOrEqualTo(String provider){
       return withProvider(Operator.GREATER_THAN_OR_EQUAL, provider);
    }

    public BenefitRequest<T> withProviderLessThan(String provider){
       return withProvider(Operator.LESS_THAN, provider);
    }

    public BenefitRequest<T> withProviderLessThanOrEqualTo(String provider){
       return withProvider(Operator.LESS_THAN_OR_EQUAL, provider);
    }

    public BenefitRequest<T> withProviderBetween(String startOfProvider, String endOfProvider){
       return withProvider(Operator.BETWEEN, startOfProvider, endOfProvider);
    }
    public BenefitRequest<T> withProviderStartingWith(String provider){
       return withProvider(Operator.BEGIN_WITH, provider);
    }
    public BenefitRequest<T> withProviderContaining(String provider){
       return withProvider(Operator.CONTAIN, provider);
    }

    public BenefitRequest<T> withProviderEndingWith(String provider){
       return withProvider(Operator.END_WITH, provider);
    }

    public BenefitRequest<T> withProviderIs(String provider){
       return withProvider(Operator.EQUAL, provider);
    }

    public BenefitRequest<T> withProviderSoundingLike(String provider){
       return withProvider(Operator.SOUNDS_LIKE, provider);
    }



    public BenefitRequest<T> filterByCreateTime(LocalDateTime... createTime){
      if (createTime == null || createTime.length == 0) {
        throw new IllegalArgumentException("filterByCreateTime parameter createTime cannot be empty");
      }
      return appendSearchCriteria(createCreateTimeCriteria(Operator.EQUAL, (Object[])createTime));
    }

    public BenefitRequest<T> withCreateTime(Operator operator, Object... values){
       return appendSearchCriteria(createCreateTimeCriteria(operator, values));
    }

    public BenefitRequest<T> withCreateTimeIsUnknown(){
       return withCreateTime(Operator.IS_NULL);
    }

    public BenefitRequest<T> withCreateTimeIsKnown(){
       return withCreateTime(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createCreateTimeCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Benefit.CREATE_TIME_PROPERTY, operator, values);
    }

    public BenefitRequest<T> withCreateTimeGreaterThan(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public BenefitRequest<T> withCreateTimeGreaterThanOrEqualTo(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN_OR_EQUAL, createTime);
    }

    public BenefitRequest<T> withCreateTimeLessThan(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public BenefitRequest<T> withCreateTimeLessThanOrEqualTo(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN_OR_EQUAL, createTime);
    }

    public BenefitRequest<T> withCreateTimeBetween(LocalDateTime startOfCreateTime, LocalDateTime endOfCreateTime){
       return withCreateTime(Operator.BETWEEN, startOfCreateTime, endOfCreateTime);
    }
    public BenefitRequest<T> withCreateTimeBefore(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public BenefitRequest<T> withCreateTimeBefore(Date createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public BenefitRequest<T> withCreateTimeAfter(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public BenefitRequest<T> withCreateTimeAfter(Date createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public BenefitRequest<T> withCreateTimeBetween(Date startOfCreateTime, Date endOfCreateTime){
       return withCreateTime(Operator.BETWEEN, startOfCreateTime, endOfCreateTime);
    }




    public BenefitRequest<T> filterByUpdateTime(LocalDateTime... updateTime){
      if (updateTime == null || updateTime.length == 0) {
        throw new IllegalArgumentException("filterByUpdateTime parameter updateTime cannot be empty");
      }
      return appendSearchCriteria(createUpdateTimeCriteria(Operator.EQUAL, (Object[])updateTime));
    }

    public BenefitRequest<T> withUpdateTime(Operator operator, Object... values){
       return appendSearchCriteria(createUpdateTimeCriteria(operator, values));
    }

    public BenefitRequest<T> withUpdateTimeIsUnknown(){
       return withUpdateTime(Operator.IS_NULL);
    }

    public BenefitRequest<T> withUpdateTimeIsKnown(){
       return withUpdateTime(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createUpdateTimeCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Benefit.UPDATE_TIME_PROPERTY, operator, values);
    }

    public BenefitRequest<T> withUpdateTimeGreaterThan(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public BenefitRequest<T> withUpdateTimeGreaterThanOrEqualTo(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN_OR_EQUAL, updateTime);
    }

    public BenefitRequest<T> withUpdateTimeLessThan(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public BenefitRequest<T> withUpdateTimeLessThanOrEqualTo(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN_OR_EQUAL, updateTime);
    }

    public BenefitRequest<T> withUpdateTimeBetween(LocalDateTime startOfUpdateTime, LocalDateTime endOfUpdateTime){
       return withUpdateTime(Operator.BETWEEN, startOfUpdateTime, endOfUpdateTime);
    }
    public BenefitRequest<T> withUpdateTimeBefore(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public BenefitRequest<T> withUpdateTimeBefore(Date updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public BenefitRequest<T> withUpdateTimeAfter(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public BenefitRequest<T> withUpdateTimeAfter(Date updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public BenefitRequest<T> withUpdateTimeBetween(Date startOfUpdateTime, Date endOfUpdateTime){
       return withUpdateTime(Operator.BETWEEN, startOfUpdateTime, endOfUpdateTime);
    }




    public BenefitRequest<T> filterByVersion(Long... version){
      if (version == null || version.length == 0) {
        throw new IllegalArgumentException("filterByVersion parameter version cannot be empty");
      }
      return appendSearchCriteria(createVersionCriteria(Operator.EQUAL, (Object[])version));
    }

    public BenefitRequest<T> withVersion(Operator operator, Object... values){
       return appendSearchCriteria(createVersionCriteria(operator, values));
    }

    public BenefitRequest<T> withVersionIsUnknown(){
       return withVersion(Operator.IS_NULL);
    }

    public BenefitRequest<T> withVersionIsKnown(){
       return withVersion(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createVersionCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Benefit.VERSION_PROPERTY, operator, values);
    }

    public BenefitRequest<T> withVersionGreaterThan(Long version){
       return withVersion(Operator.GREATER_THAN, version);
    }

    public BenefitRequest<T> withVersionGreaterThanOrEqualTo(Long version){
       return withVersion(Operator.GREATER_THAN_OR_EQUAL, version);
    }

    public BenefitRequest<T> withVersionLessThan(Long version){
       return withVersion(Operator.LESS_THAN, version);
    }

    public BenefitRequest<T> withVersionLessThanOrEqualTo(Long version){
       return withVersion(Operator.LESS_THAN_OR_EQUAL, version);
    }

    public BenefitRequest<T> withVersionBetween(Long startOfVersion, Long endOfVersion){
       return withVersion(Operator.BETWEEN, startOfVersion, endOfVersion);
    }


    public BenefitRequest<T> count(){
        super.count();
        return this;
    }
    public BenefitRequest<T> countAs(String retName){
        super.count(retName);
        return this;
    }
    public BenefitRequest minCost(){
        return minCostAs(prefix("minOf",Benefit.COST_PROPERTY));
    }

    public BenefitRequest minCostAs(String retName){
        super.min(retName, Benefit.COST_PROPERTY);
        return this;
    }
    public BenefitRequest maxCost(){
        return maxCostAs(prefix("maxOf",Benefit.COST_PROPERTY));
    }

    public BenefitRequest maxCostAs(String retName){
        super.max(retName, Benefit.COST_PROPERTY);
        return this;
    }
    public BenefitRequest sumCost(){
        return sumCostAs(prefix("sumOf",Benefit.COST_PROPERTY));
    }

    public BenefitRequest sumCostAs(String retName){
        super.sum(retName, Benefit.COST_PROPERTY);
        return this;
    }
    public BenefitRequest avgCost(){
        return avgCostAs(prefix("avgOf",Benefit.COST_PROPERTY));
    }

    public BenefitRequest avgCostAs(String retName){
        super.avg(retName, Benefit.COST_PROPERTY);
        return this;
    }
    public BenefitRequest standardDeviationCost(){
        return standardDeviationCostAs(prefix("standardDeviationOf",Benefit.COST_PROPERTY));
    }

    public BenefitRequest standardDeviationCostAs(String retName){
        super.standardDeviation(retName, Benefit.COST_PROPERTY);
        return this;
    }
    public BenefitRequest squareRootOfPopulationStandardDeviationCost(){
        return squareRootOfPopulationStandardDeviationCostAs(prefix("squareRootOfPopulationStandardDeviationOf",Benefit.COST_PROPERTY));
    }

    public BenefitRequest squareRootOfPopulationStandardDeviationCostAs(String retName){
        super.squareRootOfPopulationStandardDeviation(retName, Benefit.COST_PROPERTY);
        return this;
    }
    public BenefitRequest sampleVarianceCost(){
        return sampleVarianceCostAs(prefix("sampleVarianceOf",Benefit.COST_PROPERTY));
    }

    public BenefitRequest sampleVarianceCostAs(String retName){
        super.sampleVariance(retName, Benefit.COST_PROPERTY);
        return this;
    }
    public BenefitRequest samplePopulationVarianceCost(){
        return samplePopulationVarianceCostAs(prefix("samplePopulationVarianceOf",Benefit.COST_PROPERTY));
    }

    public BenefitRequest samplePopulationVarianceCostAs(String retName){
        super.samplePopulationVariance(retName, Benefit.COST_PROPERTY);
        return this;
    }
    public BenefitRequest<T> groupByEmployeeWithDetails(){
       return groupByEmployeeWithDetails(Q.employees().unlimited());
    }

    public BenefitRequest<T> groupByEmployeeWithDetails(EmployeeRequest subRequest){
       aggregate(Benefit.EMPLOYEE_PROPERTY, subRequest);
       return this;
    }







    public BenefitRequest<T> groupById(){
       groupBy(Benefit.ID_PROPERTY);
       return this;
    }

    public BenefitRequest<T> groupByIdAs(String retName){
       groupBy(retName, Benefit.ID_PROPERTY);
       return this;
    }

    public BenefitRequest<T> groupByIdWithFunction(String retName, AggrFunction function){
       groupBy(retName, Benefit.ID_PROPERTY, function);
       return this;
    }

    public BenefitRequest<T> groupByCost(){
       groupBy(Benefit.COST_PROPERTY);
       return this;
    }

    public BenefitRequest<T> groupByCostAs(String retName){
       groupBy(retName, Benefit.COST_PROPERTY);
       return this;
    }

    public BenefitRequest<T> groupByCostWithFunction(String retName, AggrFunction function){
       groupBy(retName, Benefit.COST_PROPERTY, function);
       return this;
    }
    public BenefitRequest<T> groupByEmployeeWith(EmployeeRequest subRequest){
       groupBy(Benefit.EMPLOYEE_PROPERTY, subRequest);
       return this;
    }
    public BenefitRequest<T> groupByEmployee(){
       groupBy(Benefit.EMPLOYEE_PROPERTY);
       return this;
    }

    public BenefitRequest<T> groupByEmployeeAs(String retName){
       groupBy(retName, Benefit.EMPLOYEE_PROPERTY);
       return this;
    }

    public BenefitRequest<T> groupByEmployeeWithFunction(String retName, AggrFunction function){
       groupBy(retName, Benefit.EMPLOYEE_PROPERTY, function);
       return this;
    }

    public BenefitRequest<T> groupByPlanType(){
       groupBy(Benefit.PLAN_TYPE_PROPERTY);
       return this;
    }

    public BenefitRequest<T> groupByPlanTypeAs(String retName){
       groupBy(retName, Benefit.PLAN_TYPE_PROPERTY);
       return this;
    }

    public BenefitRequest<T> groupByPlanTypeWithFunction(String retName, AggrFunction function){
       groupBy(retName, Benefit.PLAN_TYPE_PROPERTY, function);
       return this;
    }

    public BenefitRequest<T> groupByProvider(){
       groupBy(Benefit.PROVIDER_PROPERTY);
       return this;
    }

    public BenefitRequest<T> groupByProviderAs(String retName){
       groupBy(retName, Benefit.PROVIDER_PROPERTY);
       return this;
    }

    public BenefitRequest<T> groupByProviderWithFunction(String retName, AggrFunction function){
       groupBy(retName, Benefit.PROVIDER_PROPERTY, function);
       return this;
    }

    public BenefitRequest<T> groupByCreateTime(){
       groupBy(Benefit.CREATE_TIME_PROPERTY);
       return this;
    }

    public BenefitRequest<T> groupByCreateTimeAs(String retName){
       groupBy(retName, Benefit.CREATE_TIME_PROPERTY);
       return this;
    }

    public BenefitRequest<T> groupByCreateTimeWithFunction(String retName, AggrFunction function){
       groupBy(retName, Benefit.CREATE_TIME_PROPERTY, function);
       return this;
    }

    public BenefitRequest<T> groupByUpdateTime(){
       groupBy(Benefit.UPDATE_TIME_PROPERTY);
       return this;
    }

    public BenefitRequest<T> groupByUpdateTimeAs(String retName){
       groupBy(retName, Benefit.UPDATE_TIME_PROPERTY);
       return this;
    }

    public BenefitRequest<T> groupByUpdateTimeWithFunction(String retName, AggrFunction function){
       groupBy(retName, Benefit.UPDATE_TIME_PROPERTY, function);
       return this;
    }

    public BenefitRequest<T> groupByVersion(){
       groupBy(Benefit.VERSION_PROPERTY);
       return this;
    }

    public BenefitRequest<T> groupByVersionAs(String retName){
       groupBy(retName, Benefit.VERSION_PROPERTY);
       return this;
    }

    public BenefitRequest<T> groupByVersionWithFunction(String retName, AggrFunction function){
       groupBy(retName, Benefit.VERSION_PROPERTY, function);
       return this;
    }



    public BenefitRequest<T> orderByIdAscending(){
       addOrderByAscending(Benefit.ID_PROPERTY);
       return this;
    }

    public BenefitRequest<T> orderByIdDescending(){
       addOrderByDescending(Benefit.ID_PROPERTY);
       return this;
    }

    public BenefitRequest<T> orderByCostAscending(){
       addOrderByAscending(Benefit.COST_PROPERTY);
       return this;
    }

    public BenefitRequest<T> orderByCostDescending(){
       addOrderByDescending(Benefit.COST_PROPERTY);
       return this;
    }

    public BenefitRequest<T> orderByEmployeeAscending(){
       addOrderByAscending(Benefit.EMPLOYEE_PROPERTY);
       return this;
    }

    public BenefitRequest<T> orderByEmployeeDescending(){
       addOrderByDescending(Benefit.EMPLOYEE_PROPERTY);
       return this;
    }

    public BenefitRequest<T> orderByPlanTypeAscending(){
       addOrderByAscending(Benefit.PLAN_TYPE_PROPERTY);
       return this;
    }

    public BenefitRequest<T> orderByPlanTypeDescending(){
       addOrderByDescending(Benefit.PLAN_TYPE_PROPERTY);
       return this;
    }
    public BenefitRequest<T> orderByPlanTypeAscendingUsingGBK(){
       addOrderByAscendingUsingGBK(Benefit.PLAN_TYPE_PROPERTY);
       return this;
    }

    public BenefitRequest<T> orderByPlanTypeDescendingUsingGBK(){
       addOrderByDescendingUsingGBK(Benefit.PLAN_TYPE_PROPERTY);
       return this;
    }
    public BenefitRequest<T> orderByProviderAscending(){
       addOrderByAscending(Benefit.PROVIDER_PROPERTY);
       return this;
    }

    public BenefitRequest<T> orderByProviderDescending(){
       addOrderByDescending(Benefit.PROVIDER_PROPERTY);
       return this;
    }
    public BenefitRequest<T> orderByProviderAscendingUsingGBK(){
       addOrderByAscendingUsingGBK(Benefit.PROVIDER_PROPERTY);
       return this;
    }

    public BenefitRequest<T> orderByProviderDescendingUsingGBK(){
       addOrderByDescendingUsingGBK(Benefit.PROVIDER_PROPERTY);
       return this;
    }
    public BenefitRequest<T> orderByCreateTimeAscending(){
       addOrderByAscending(Benefit.CREATE_TIME_PROPERTY);
       return this;
    }

    public BenefitRequest<T> orderByCreateTimeDescending(){
       addOrderByDescending(Benefit.CREATE_TIME_PROPERTY);
       return this;
    }

    public BenefitRequest<T> orderByUpdateTimeAscending(){
       addOrderByAscending(Benefit.UPDATE_TIME_PROPERTY);
       return this;
    }

    public BenefitRequest<T> orderByUpdateTimeDescending(){
       addOrderByDescending(Benefit.UPDATE_TIME_PROPERTY);
       return this;
    }

    public BenefitRequest<T> orderByVersionAscending(){
       addOrderByAscending(Benefit.VERSION_PROPERTY);
       return this;
    }

    public BenefitRequest<T> orderByVersionDescending(){
       addOrderByDescending(Benefit.VERSION_PROPERTY);
       return this;
    }


    public EmployeeRequest rollUpToEmployee(){
       EmployeeRequest employee = Q.employees().unlimited();
       this.withEmployeeMatching(employee)
           .groupByEmployeeWith(employee);
       return employee;
    }







   public BenefitRequest<T> facetByEmployeeAs(String facetName, EmployeeRequest employee){
       return facetByEmployeeAs(facetName, employee, true);
   }

   public BenefitRequest<T> facetByEmployeeAs(String facetName, EmployeeRequest employee, boolean includeAllFacets){
       addFacet(facetName, Benefit.EMPLOYEE_PROPERTY, employee, includeAllFacets);
       return this;
   }


    /**
     * get topN records
     * @param topN  records number
     */
    public BenefitRequest<T> top(int topN) {
        super.top(topN);
        return this;
    }

    /**
     * get records from offset(inclusive) to offset+size(exclusive)
     * @param offset record offset
     * @param size records number
     */
    public BenefitRequest<T> offset(int offset, int size) {
        super.offset(offset, size);
        return this;
    }

    /**
     * retrieve all records
     */
    public BenefitRequest<T> unlimited() {
        super.unlimited();
        return this;
    }

    /**
     * get records of one page
     * @param pageNumber page number(1-based)
     * @param pageSize page size
     */
    public BenefitRequest<T> page(int pageNumber, int pageSize) {
        int offset = (pageNumber - 1) * pageSize;
        return offset(offset, pageSize);
   }

    /**
     * get records of one page, default page size is 10
     * @param pageNumber page number(1-based)
     */
    public BenefitRequest<T> page(int pageNumber) {
        return page(pageNumber, 10);
   }
}