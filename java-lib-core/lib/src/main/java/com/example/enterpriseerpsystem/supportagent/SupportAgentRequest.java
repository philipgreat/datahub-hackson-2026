
package com.example.enterpriseerpsystem.supportagent;

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

public class SupportAgentRequest<T extends SupportAgent> extends BaseRequest<T> {

    /**
     * @deprecated AI agents and business code must use the generated Q facade
     *             instead of constructing request builders directly.
     */
    @Deprecated
    public SupportAgentRequest(Class<T> returnType){
        super(returnType);
        selectId();
        selectVersion();
    }

    public SupportAgentRequest<T> comment(String comment){
         super.internalComment(comment);
         return this;
    }

    // purpose() 继承自 BaseRequest，返回 ExecutableRequest（终结方法）

    public SupportAgentRequest<T> returnType(Class<? extends T> returnType){
        super.setReturnType(returnType);
        return this;
    }

    public SupportAgentRequest<T> enableAggregationCache(long cacheExpiredMillis){
        super.enableAggregationCache();
        super.aggregateCacheTime(cacheExpiredMillis);
        return this;
    }

    public SupportAgentRequest<T> enableAggregationCache(){
        return enableAggregationCache(0l);
    }


    public SupportAgentRequest<T> propagateAggregationCache(long cacheExpiredMillis){
        super.propagateAggregationCache(cacheExpiredMillis);
        return this;
    }

    public SupportAgentRequest<T> appendSearchCriteria(SearchCriteria searchCriteria){
        return (SupportAgentRequest<T>)super.appendSearchCriteria(searchCriteria);
    }

    public SupportAgentRequest<T> filter(String property1, Operator operator, String property2){
        return appendSearchCriteria(new TwoOperatorCriteria(operator, new PropertyReference(property1), new PropertyReference(property2)));
    }


    public SupportAgentRequest<T> matchingAnyOf(SupportAgentRequest supportAgent){
        super.internalMatchAny(supportAgent);
        return this;
    }

    public SupportAgentRequest<T> enhanceChildrenIfNeeded(){
        return this;
    }

    public SupportAgentRequest<T> withDeletedRows(){
        super.withDeletedRows();
        return this;
    }

    public SupportAgentRequest<T> deletedRowsOnly(){
        super.deletedRowsOnly();
        return this;
    }

    public SupportAgentRequest<T> selectSelf(){
        super.selectSelf();
        return selectId().selectActiveTickets().selectEmployeeIdOnly().selectSpecialty().selectCreateTime().selectUpdateTime().selectVersion();
    }

    public SupportAgentRequest<T> selectSelfFields(){
        return selectSelf();
    }

    public SupportAgentRequest<T> selectAll(){
        super.selectAll();
        return selectId().selectActiveTickets().selectEmployee().selectSpecialty().selectCreateTime().selectUpdateTime().selectVersion();
    }

    public SupportAgentRequest<T> selectChildren(){
        super.selectAny();
        return selectId().selectActiveTickets().selectEmployee().selectSpecialty().selectCreateTime().selectUpdateTime().selectVersion();
    }


    public SupportAgentRequest<T> selectId(){
       selectProperty(SupportAgent.ID_PROPERTY);
       return this;
    }

    /**
     * fill the id with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  id) to fetch id property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public SupportAgentRequest<T> unselectId(){
       unselectProperty(SupportAgent.ID_PROPERTY);
       return this;
    }
    public SupportAgentRequest<T> selectActiveTickets(){
       selectProperty(SupportAgent.ACTIVE_TICKETS_PROPERTY);
       return this;
    }

    /**
     * fill the activeTickets with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  activeTickets) to fetch activeTickets property.
     * @param rawSqlSegment  customized rawSqlSegment
     */


    /**
     * fill the activeTickets with customized aggrFunction, TEAQL uses ({aggrFunction}(activeTickets) AS activeTickets to fetch activeTickets property.
     * @param aggrFunction  aggrFunction
     */
    public SupportAgentRequest<T> selectActiveTickets(AggrFunction aggrFunction){
       selectProperty(SupportAgent.ACTIVE_TICKETS_PROPERTY, aggrFunction);
       return this;
    }


    public SupportAgentRequest<T> unselectActiveTickets(){
       unselectProperty(SupportAgent.ACTIVE_TICKETS_PROPERTY);
       return this;
    }
    public SupportAgentRequest<T> selectEmployeeIdOnly(){
       selectProperty(SupportAgent.EMPLOYEE_PROPERTY);
       return this;
    }

    public SupportAgentRequest<T> selectEmployee(){
        return selectEmployeeWith(Q.employees().unlimited().selectSelf());
    }

    public SupportAgentRequest<T> selectEmployeeWith(EmployeeRequest employee){
       selectProperty(SupportAgent.EMPLOYEE_PROPERTY);
       enhanceRelation(SupportAgent.EMPLOYEE_PROPERTY, employee);
       return this;
    }

    public SupportAgentRequest<T> unselectEmployee(){
       unselectProperty(SupportAgent.EMPLOYEE_PROPERTY);
       return this;
    }
    public SupportAgentRequest<T> selectSpecialty(){
       selectProperty(SupportAgent.SPECIALTY_PROPERTY);
       return this;
    }

    /**
     * fill the specialty with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  specialty) to fetch specialty property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public SupportAgentRequest<T> unselectSpecialty(){
       unselectProperty(SupportAgent.SPECIALTY_PROPERTY);
       return this;
    }
    public SupportAgentRequest<T> selectCreateTime(){
       selectProperty(SupportAgent.CREATE_TIME_PROPERTY);
       return this;
    }

    /**
     * fill the createTime with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  createTime) to fetch createTime property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public SupportAgentRequest<T> unselectCreateTime(){
       unselectProperty(SupportAgent.CREATE_TIME_PROPERTY);
       return this;
    }
    public SupportAgentRequest<T> selectUpdateTime(){
       selectProperty(SupportAgent.UPDATE_TIME_PROPERTY);
       return this;
    }

    /**
     * fill the updateTime with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  updateTime) to fetch updateTime property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public SupportAgentRequest<T> unselectUpdateTime(){
       unselectProperty(SupportAgent.UPDATE_TIME_PROPERTY);
       return this;
    }
    public SupportAgentRequest<T> selectVersion(){
       selectProperty(SupportAgent.VERSION_PROPERTY);
       return this;
    }

    /**
     * fill the version with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  version) to fetch version property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public SupportAgentRequest<T> unselectVersion(){
       unselectProperty(SupportAgent.VERSION_PROPERTY);
       return this;
    }

    public SupportAgentRequest<T> withId(Operator operator, Object... values){
       return appendSearchCriteria(createIdCriteria(operator, values));
    }

    public SearchCriteria createIdCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(SupportAgent.ID_PROPERTY, operator, values);
    }

    public SupportAgentRequest<T> withIdIs(Long id){
       return withId(Operator.EQUAL, id);
    }
    public SupportAgentRequest<T> withIdIn(Long... id){
       return withId(Operator.EQUAL, (Object[])id);
    }



    public SupportAgentRequest<T> filterByActiveTickets(BigDecimal... activeTickets){
      if (activeTickets == null || activeTickets.length == 0) {
        throw new IllegalArgumentException("filterByActiveTickets parameter activeTickets cannot be empty");
      }
      return appendSearchCriteria(createActiveTicketsCriteria(Operator.EQUAL, (Object[])activeTickets));
    }

    public SupportAgentRequest<T> withActiveTickets(Operator operator, Object... values){
       return appendSearchCriteria(createActiveTicketsCriteria(operator, values));
    }

    public SupportAgentRequest<T> withActiveTicketsIsUnknown(){
       return withActiveTickets(Operator.IS_NULL);
    }

    public SupportAgentRequest<T> withActiveTicketsIsKnown(){
       return withActiveTickets(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createActiveTicketsCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(SupportAgent.ACTIVE_TICKETS_PROPERTY, operator, values);
    }

    public SupportAgentRequest<T> withActiveTicketsGreaterThan(BigDecimal activeTickets){
       return withActiveTickets(Operator.GREATER_THAN, activeTickets);
    }

    public SupportAgentRequest<T> withActiveTicketsGreaterThanOrEqualTo(BigDecimal activeTickets){
       return withActiveTickets(Operator.GREATER_THAN_OR_EQUAL, activeTickets);
    }

    public SupportAgentRequest<T> withActiveTicketsLessThan(BigDecimal activeTickets){
       return withActiveTickets(Operator.LESS_THAN, activeTickets);
    }

    public SupportAgentRequest<T> withActiveTicketsLessThanOrEqualTo(BigDecimal activeTickets){
       return withActiveTickets(Operator.LESS_THAN_OR_EQUAL, activeTickets);
    }

    public SupportAgentRequest<T> withActiveTicketsBetween(BigDecimal startOfActiveTickets, BigDecimal endOfActiveTickets){
       return withActiveTickets(Operator.BETWEEN, startOfActiveTickets, endOfActiveTickets);
    }



    public SupportAgentRequest<T> filterByEmployee(Employee... employee){
      if (employee == null || employee.length == 0) {
        throw new IllegalArgumentException("filterByEmployee parameter employee cannot be empty");
      }
      return appendSearchCriteria(createEmployeeCriteria(Operator.EQUAL, (Object[])employee));
    }

    public SupportAgentRequest<T> withEmployee(Operator operator, Object... values){
       return appendSearchCriteria(createEmployeeCriteria(operator, values));
    }

    public SupportAgentRequest<T> withEmployeeIsUnknown(){
       return withEmployee(Operator.IS_NULL);
    }

    public SupportAgentRequest<T> withEmployeeIsKnown(){
       return withEmployee(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createEmployeeCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(SupportAgent.EMPLOYEE_PROPERTY, operator, values);
    }

    public SupportAgentRequest<T> filterByEmployee(Long employee){
      if(employee == null){
         return this;
      }
      return withEmployee(Operator.EQUAL, employee);
    }
    public SupportAgentRequest<T> withEmployeeMatching(EmployeeRequest employee){
       return appendSearchCriteria(new SubQuerySearchCriteria(SupportAgent.EMPLOYEE_PROPERTY, employee, Employee.ID_PROPERTY));
    }

    public SupportAgentRequest<T> filterBySpecialty(String... specialty){
      if (specialty == null || specialty.length == 0) {
        throw new IllegalArgumentException("filterBySpecialty parameter specialty cannot be empty");
      }
      return appendSearchCriteria(createSpecialtyCriteria(Operator.EQUAL, (Object[])specialty));
    }

    public SupportAgentRequest<T> withSpecialty(Operator operator, Object... values){
       return appendSearchCriteria(createSpecialtyCriteria(operator, values));
    }

    public SupportAgentRequest<T> withSpecialtyIsUnknown(){
       return withSpecialty(Operator.IS_NULL);
    }

    public SupportAgentRequest<T> withSpecialtyIsKnown(){
       return withSpecialty(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createSpecialtyCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(SupportAgent.SPECIALTY_PROPERTY, operator, values);
    }

    public SupportAgentRequest<T> withSpecialtyGreaterThan(String specialty){
       return withSpecialty(Operator.GREATER_THAN, specialty);
    }

    public SupportAgentRequest<T> withSpecialtyGreaterThanOrEqualTo(String specialty){
       return withSpecialty(Operator.GREATER_THAN_OR_EQUAL, specialty);
    }

    public SupportAgentRequest<T> withSpecialtyLessThan(String specialty){
       return withSpecialty(Operator.LESS_THAN, specialty);
    }

    public SupportAgentRequest<T> withSpecialtyLessThanOrEqualTo(String specialty){
       return withSpecialty(Operator.LESS_THAN_OR_EQUAL, specialty);
    }

    public SupportAgentRequest<T> withSpecialtyBetween(String startOfSpecialty, String endOfSpecialty){
       return withSpecialty(Operator.BETWEEN, startOfSpecialty, endOfSpecialty);
    }
    public SupportAgentRequest<T> withSpecialtyStartingWith(String specialty){
       return withSpecialty(Operator.BEGIN_WITH, specialty);
    }
    public SupportAgentRequest<T> withSpecialtyContaining(String specialty){
       return withSpecialty(Operator.CONTAIN, specialty);
    }

    public SupportAgentRequest<T> withSpecialtyEndingWith(String specialty){
       return withSpecialty(Operator.END_WITH, specialty);
    }

    public SupportAgentRequest<T> withSpecialtyIs(String specialty){
       return withSpecialty(Operator.EQUAL, specialty);
    }

    public SupportAgentRequest<T> withSpecialtySoundingLike(String specialty){
       return withSpecialty(Operator.SOUNDS_LIKE, specialty);
    }



    public SupportAgentRequest<T> filterByCreateTime(LocalDateTime... createTime){
      if (createTime == null || createTime.length == 0) {
        throw new IllegalArgumentException("filterByCreateTime parameter createTime cannot be empty");
      }
      return appendSearchCriteria(createCreateTimeCriteria(Operator.EQUAL, (Object[])createTime));
    }

    public SupportAgentRequest<T> withCreateTime(Operator operator, Object... values){
       return appendSearchCriteria(createCreateTimeCriteria(operator, values));
    }

    public SupportAgentRequest<T> withCreateTimeIsUnknown(){
       return withCreateTime(Operator.IS_NULL);
    }

    public SupportAgentRequest<T> withCreateTimeIsKnown(){
       return withCreateTime(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createCreateTimeCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(SupportAgent.CREATE_TIME_PROPERTY, operator, values);
    }

    public SupportAgentRequest<T> withCreateTimeGreaterThan(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public SupportAgentRequest<T> withCreateTimeGreaterThanOrEqualTo(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN_OR_EQUAL, createTime);
    }

    public SupportAgentRequest<T> withCreateTimeLessThan(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public SupportAgentRequest<T> withCreateTimeLessThanOrEqualTo(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN_OR_EQUAL, createTime);
    }

    public SupportAgentRequest<T> withCreateTimeBetween(LocalDateTime startOfCreateTime, LocalDateTime endOfCreateTime){
       return withCreateTime(Operator.BETWEEN, startOfCreateTime, endOfCreateTime);
    }
    public SupportAgentRequest<T> withCreateTimeBefore(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public SupportAgentRequest<T> withCreateTimeBefore(Date createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public SupportAgentRequest<T> withCreateTimeAfter(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public SupportAgentRequest<T> withCreateTimeAfter(Date createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public SupportAgentRequest<T> withCreateTimeBetween(Date startOfCreateTime, Date endOfCreateTime){
       return withCreateTime(Operator.BETWEEN, startOfCreateTime, endOfCreateTime);
    }




    public SupportAgentRequest<T> filterByUpdateTime(LocalDateTime... updateTime){
      if (updateTime == null || updateTime.length == 0) {
        throw new IllegalArgumentException("filterByUpdateTime parameter updateTime cannot be empty");
      }
      return appendSearchCriteria(createUpdateTimeCriteria(Operator.EQUAL, (Object[])updateTime));
    }

    public SupportAgentRequest<T> withUpdateTime(Operator operator, Object... values){
       return appendSearchCriteria(createUpdateTimeCriteria(operator, values));
    }

    public SupportAgentRequest<T> withUpdateTimeIsUnknown(){
       return withUpdateTime(Operator.IS_NULL);
    }

    public SupportAgentRequest<T> withUpdateTimeIsKnown(){
       return withUpdateTime(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createUpdateTimeCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(SupportAgent.UPDATE_TIME_PROPERTY, operator, values);
    }

    public SupportAgentRequest<T> withUpdateTimeGreaterThan(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public SupportAgentRequest<T> withUpdateTimeGreaterThanOrEqualTo(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN_OR_EQUAL, updateTime);
    }

    public SupportAgentRequest<T> withUpdateTimeLessThan(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public SupportAgentRequest<T> withUpdateTimeLessThanOrEqualTo(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN_OR_EQUAL, updateTime);
    }

    public SupportAgentRequest<T> withUpdateTimeBetween(LocalDateTime startOfUpdateTime, LocalDateTime endOfUpdateTime){
       return withUpdateTime(Operator.BETWEEN, startOfUpdateTime, endOfUpdateTime);
    }
    public SupportAgentRequest<T> withUpdateTimeBefore(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public SupportAgentRequest<T> withUpdateTimeBefore(Date updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public SupportAgentRequest<T> withUpdateTimeAfter(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public SupportAgentRequest<T> withUpdateTimeAfter(Date updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public SupportAgentRequest<T> withUpdateTimeBetween(Date startOfUpdateTime, Date endOfUpdateTime){
       return withUpdateTime(Operator.BETWEEN, startOfUpdateTime, endOfUpdateTime);
    }




    public SupportAgentRequest<T> filterByVersion(Long... version){
      if (version == null || version.length == 0) {
        throw new IllegalArgumentException("filterByVersion parameter version cannot be empty");
      }
      return appendSearchCriteria(createVersionCriteria(Operator.EQUAL, (Object[])version));
    }

    public SupportAgentRequest<T> withVersion(Operator operator, Object... values){
       return appendSearchCriteria(createVersionCriteria(operator, values));
    }

    public SupportAgentRequest<T> withVersionIsUnknown(){
       return withVersion(Operator.IS_NULL);
    }

    public SupportAgentRequest<T> withVersionIsKnown(){
       return withVersion(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createVersionCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(SupportAgent.VERSION_PROPERTY, operator, values);
    }

    public SupportAgentRequest<T> withVersionGreaterThan(Long version){
       return withVersion(Operator.GREATER_THAN, version);
    }

    public SupportAgentRequest<T> withVersionGreaterThanOrEqualTo(Long version){
       return withVersion(Operator.GREATER_THAN_OR_EQUAL, version);
    }

    public SupportAgentRequest<T> withVersionLessThan(Long version){
       return withVersion(Operator.LESS_THAN, version);
    }

    public SupportAgentRequest<T> withVersionLessThanOrEqualTo(Long version){
       return withVersion(Operator.LESS_THAN_OR_EQUAL, version);
    }

    public SupportAgentRequest<T> withVersionBetween(Long startOfVersion, Long endOfVersion){
       return withVersion(Operator.BETWEEN, startOfVersion, endOfVersion);
    }


    public SupportAgentRequest<T> count(){
        super.count();
        return this;
    }
    public SupportAgentRequest<T> countAs(String retName){
        super.count(retName);
        return this;
    }
    public SupportAgentRequest minActiveTickets(){
        return minActiveTicketsAs(prefix("minOf",SupportAgent.ACTIVE_TICKETS_PROPERTY));
    }

    public SupportAgentRequest minActiveTicketsAs(String retName){
        super.min(retName, SupportAgent.ACTIVE_TICKETS_PROPERTY);
        return this;
    }
    public SupportAgentRequest maxActiveTickets(){
        return maxActiveTicketsAs(prefix("maxOf",SupportAgent.ACTIVE_TICKETS_PROPERTY));
    }

    public SupportAgentRequest maxActiveTicketsAs(String retName){
        super.max(retName, SupportAgent.ACTIVE_TICKETS_PROPERTY);
        return this;
    }
    public SupportAgentRequest sumActiveTickets(){
        return sumActiveTicketsAs(prefix("sumOf",SupportAgent.ACTIVE_TICKETS_PROPERTY));
    }

    public SupportAgentRequest sumActiveTicketsAs(String retName){
        super.sum(retName, SupportAgent.ACTIVE_TICKETS_PROPERTY);
        return this;
    }
    public SupportAgentRequest avgActiveTickets(){
        return avgActiveTicketsAs(prefix("avgOf",SupportAgent.ACTIVE_TICKETS_PROPERTY));
    }

    public SupportAgentRequest avgActiveTicketsAs(String retName){
        super.avg(retName, SupportAgent.ACTIVE_TICKETS_PROPERTY);
        return this;
    }
    public SupportAgentRequest standardDeviationActiveTickets(){
        return standardDeviationActiveTicketsAs(prefix("standardDeviationOf",SupportAgent.ACTIVE_TICKETS_PROPERTY));
    }

    public SupportAgentRequest standardDeviationActiveTicketsAs(String retName){
        super.standardDeviation(retName, SupportAgent.ACTIVE_TICKETS_PROPERTY);
        return this;
    }
    public SupportAgentRequest squareRootOfPopulationStandardDeviationActiveTickets(){
        return squareRootOfPopulationStandardDeviationActiveTicketsAs(prefix("squareRootOfPopulationStandardDeviationOf",SupportAgent.ACTIVE_TICKETS_PROPERTY));
    }

    public SupportAgentRequest squareRootOfPopulationStandardDeviationActiveTicketsAs(String retName){
        super.squareRootOfPopulationStandardDeviation(retName, SupportAgent.ACTIVE_TICKETS_PROPERTY);
        return this;
    }
    public SupportAgentRequest sampleVarianceActiveTickets(){
        return sampleVarianceActiveTicketsAs(prefix("sampleVarianceOf",SupportAgent.ACTIVE_TICKETS_PROPERTY));
    }

    public SupportAgentRequest sampleVarianceActiveTicketsAs(String retName){
        super.sampleVariance(retName, SupportAgent.ACTIVE_TICKETS_PROPERTY);
        return this;
    }
    public SupportAgentRequest samplePopulationVarianceActiveTickets(){
        return samplePopulationVarianceActiveTicketsAs(prefix("samplePopulationVarianceOf",SupportAgent.ACTIVE_TICKETS_PROPERTY));
    }

    public SupportAgentRequest samplePopulationVarianceActiveTicketsAs(String retName){
        super.samplePopulationVariance(retName, SupportAgent.ACTIVE_TICKETS_PROPERTY);
        return this;
    }
    public SupportAgentRequest<T> groupByEmployeeWithDetails(){
       return groupByEmployeeWithDetails(Q.employees().unlimited());
    }

    public SupportAgentRequest<T> groupByEmployeeWithDetails(EmployeeRequest subRequest){
       aggregate(SupportAgent.EMPLOYEE_PROPERTY, subRequest);
       return this;
    }






    public SupportAgentRequest<T> groupById(){
       groupBy(SupportAgent.ID_PROPERTY);
       return this;
    }

    public SupportAgentRequest<T> groupByIdAs(String retName){
       groupBy(retName, SupportAgent.ID_PROPERTY);
       return this;
    }

    public SupportAgentRequest<T> groupByIdWithFunction(String retName, AggrFunction function){
       groupBy(retName, SupportAgent.ID_PROPERTY, function);
       return this;
    }

    public SupportAgentRequest<T> groupByActiveTickets(){
       groupBy(SupportAgent.ACTIVE_TICKETS_PROPERTY);
       return this;
    }

    public SupportAgentRequest<T> groupByActiveTicketsAs(String retName){
       groupBy(retName, SupportAgent.ACTIVE_TICKETS_PROPERTY);
       return this;
    }

    public SupportAgentRequest<T> groupByActiveTicketsWithFunction(String retName, AggrFunction function){
       groupBy(retName, SupportAgent.ACTIVE_TICKETS_PROPERTY, function);
       return this;
    }
    public SupportAgentRequest<T> groupByEmployeeWith(EmployeeRequest subRequest){
       groupBy(SupportAgent.EMPLOYEE_PROPERTY, subRequest);
       return this;
    }
    public SupportAgentRequest<T> groupByEmployee(){
       groupBy(SupportAgent.EMPLOYEE_PROPERTY);
       return this;
    }

    public SupportAgentRequest<T> groupByEmployeeAs(String retName){
       groupBy(retName, SupportAgent.EMPLOYEE_PROPERTY);
       return this;
    }

    public SupportAgentRequest<T> groupByEmployeeWithFunction(String retName, AggrFunction function){
       groupBy(retName, SupportAgent.EMPLOYEE_PROPERTY, function);
       return this;
    }

    public SupportAgentRequest<T> groupBySpecialty(){
       groupBy(SupportAgent.SPECIALTY_PROPERTY);
       return this;
    }

    public SupportAgentRequest<T> groupBySpecialtyAs(String retName){
       groupBy(retName, SupportAgent.SPECIALTY_PROPERTY);
       return this;
    }

    public SupportAgentRequest<T> groupBySpecialtyWithFunction(String retName, AggrFunction function){
       groupBy(retName, SupportAgent.SPECIALTY_PROPERTY, function);
       return this;
    }

    public SupportAgentRequest<T> groupByCreateTime(){
       groupBy(SupportAgent.CREATE_TIME_PROPERTY);
       return this;
    }

    public SupportAgentRequest<T> groupByCreateTimeAs(String retName){
       groupBy(retName, SupportAgent.CREATE_TIME_PROPERTY);
       return this;
    }

    public SupportAgentRequest<T> groupByCreateTimeWithFunction(String retName, AggrFunction function){
       groupBy(retName, SupportAgent.CREATE_TIME_PROPERTY, function);
       return this;
    }

    public SupportAgentRequest<T> groupByUpdateTime(){
       groupBy(SupportAgent.UPDATE_TIME_PROPERTY);
       return this;
    }

    public SupportAgentRequest<T> groupByUpdateTimeAs(String retName){
       groupBy(retName, SupportAgent.UPDATE_TIME_PROPERTY);
       return this;
    }

    public SupportAgentRequest<T> groupByUpdateTimeWithFunction(String retName, AggrFunction function){
       groupBy(retName, SupportAgent.UPDATE_TIME_PROPERTY, function);
       return this;
    }

    public SupportAgentRequest<T> groupByVersion(){
       groupBy(SupportAgent.VERSION_PROPERTY);
       return this;
    }

    public SupportAgentRequest<T> groupByVersionAs(String retName){
       groupBy(retName, SupportAgent.VERSION_PROPERTY);
       return this;
    }

    public SupportAgentRequest<T> groupByVersionWithFunction(String retName, AggrFunction function){
       groupBy(retName, SupportAgent.VERSION_PROPERTY, function);
       return this;
    }



    public SupportAgentRequest<T> orderByIdAscending(){
       addOrderByAscending(SupportAgent.ID_PROPERTY);
       return this;
    }

    public SupportAgentRequest<T> orderByIdDescending(){
       addOrderByDescending(SupportAgent.ID_PROPERTY);
       return this;
    }

    public SupportAgentRequest<T> orderByActiveTicketsAscending(){
       addOrderByAscending(SupportAgent.ACTIVE_TICKETS_PROPERTY);
       return this;
    }

    public SupportAgentRequest<T> orderByActiveTicketsDescending(){
       addOrderByDescending(SupportAgent.ACTIVE_TICKETS_PROPERTY);
       return this;
    }

    public SupportAgentRequest<T> orderByEmployeeAscending(){
       addOrderByAscending(SupportAgent.EMPLOYEE_PROPERTY);
       return this;
    }

    public SupportAgentRequest<T> orderByEmployeeDescending(){
       addOrderByDescending(SupportAgent.EMPLOYEE_PROPERTY);
       return this;
    }

    public SupportAgentRequest<T> orderBySpecialtyAscending(){
       addOrderByAscending(SupportAgent.SPECIALTY_PROPERTY);
       return this;
    }

    public SupportAgentRequest<T> orderBySpecialtyDescending(){
       addOrderByDescending(SupportAgent.SPECIALTY_PROPERTY);
       return this;
    }
    public SupportAgentRequest<T> orderBySpecialtyAscendingUsingGBK(){
       addOrderByAscendingUsingGBK(SupportAgent.SPECIALTY_PROPERTY);
       return this;
    }

    public SupportAgentRequest<T> orderBySpecialtyDescendingUsingGBK(){
       addOrderByDescendingUsingGBK(SupportAgent.SPECIALTY_PROPERTY);
       return this;
    }
    public SupportAgentRequest<T> orderByCreateTimeAscending(){
       addOrderByAscending(SupportAgent.CREATE_TIME_PROPERTY);
       return this;
    }

    public SupportAgentRequest<T> orderByCreateTimeDescending(){
       addOrderByDescending(SupportAgent.CREATE_TIME_PROPERTY);
       return this;
    }

    public SupportAgentRequest<T> orderByUpdateTimeAscending(){
       addOrderByAscending(SupportAgent.UPDATE_TIME_PROPERTY);
       return this;
    }

    public SupportAgentRequest<T> orderByUpdateTimeDescending(){
       addOrderByDescending(SupportAgent.UPDATE_TIME_PROPERTY);
       return this;
    }

    public SupportAgentRequest<T> orderByVersionAscending(){
       addOrderByAscending(SupportAgent.VERSION_PROPERTY);
       return this;
    }

    public SupportAgentRequest<T> orderByVersionDescending(){
       addOrderByDescending(SupportAgent.VERSION_PROPERTY);
       return this;
    }


    public EmployeeRequest rollUpToEmployee(){
       EmployeeRequest employee = Q.employees().unlimited();
       this.withEmployeeMatching(employee)
           .groupByEmployeeWith(employee);
       return employee;
    }






   public SupportAgentRequest<T> facetByEmployeeAs(String facetName, EmployeeRequest employee){
       return facetByEmployeeAs(facetName, employee, true);
   }

   public SupportAgentRequest<T> facetByEmployeeAs(String facetName, EmployeeRequest employee, boolean includeAllFacets){
       addFacet(facetName, SupportAgent.EMPLOYEE_PROPERTY, employee, includeAllFacets);
       return this;
   }


    /**
     * get topN records
     * @param topN  records number
     */
    public SupportAgentRequest<T> top(int topN) {
        super.top(topN);
        return this;
    }

    /**
     * get records from offset(inclusive) to offset+size(exclusive)
     * @param offset record offset
     * @param size records number
     */
    public SupportAgentRequest<T> offset(int offset, int size) {
        super.offset(offset, size);
        return this;
    }

    /**
     * retrieve all records
     */
    public SupportAgentRequest<T> unlimited() {
        super.unlimited();
        return this;
    }

    /**
     * get records of one page
     * @param pageNumber page number(1-based)
     * @param pageSize page size
     */
    public SupportAgentRequest<T> page(int pageNumber, int pageSize) {
        int offset = (pageNumber - 1) * pageSize;
        return offset(offset, pageSize);
   }

    /**
     * get records of one page, default page size is 10
     * @param pageNumber page number(1-based)
     */
    public SupportAgentRequest<T> page(int pageNumber) {
        return page(pageNumber, 10);
   }
}