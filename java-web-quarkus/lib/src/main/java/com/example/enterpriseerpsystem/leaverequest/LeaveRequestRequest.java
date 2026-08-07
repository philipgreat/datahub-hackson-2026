
package com.example.enterpriseerpsystem.leaverequest;

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
import java.time.LocalDateTime;
import java.util.Date;

public class LeaveRequestRequest<T extends LeaveRequest> extends BaseRequest<T> {

    /**
     * @deprecated AI agents and business code must use the generated Q facade
     *             instead of constructing request builders directly.
     */
    @Deprecated
    public LeaveRequestRequest(Class<T> returnType){
        super(returnType);
        selectId();
        selectVersion();
    }

    public LeaveRequestRequest<T> comment(String comment){
         super.internalComment(comment);
         return this;
    }

    // purpose() 继承自 BaseRequest，返回 ExecutableRequest（终结方法）

    public LeaveRequestRequest<T> returnType(Class<? extends T> returnType){
        super.setReturnType(returnType);
        return this;
    }

    public LeaveRequestRequest<T> enableAggregationCache(long cacheExpiredMillis){
        super.enableAggregationCache();
        super.aggregateCacheTime(cacheExpiredMillis);
        return this;
    }

    public LeaveRequestRequest<T> enableAggregationCache(){
        return enableAggregationCache(0l);
    }


    public LeaveRequestRequest<T> propagateAggregationCache(long cacheExpiredMillis){
        super.propagateAggregationCache(cacheExpiredMillis);
        return this;
    }

    public LeaveRequestRequest<T> appendSearchCriteria(SearchCriteria searchCriteria){
        return (LeaveRequestRequest<T>)super.appendSearchCriteria(searchCriteria);
    }

    public LeaveRequestRequest<T> filter(String property1, Operator operator, String property2){
        return appendSearchCriteria(new TwoOperatorCriteria(operator, new PropertyReference(property1), new PropertyReference(property2)));
    }


    public LeaveRequestRequest<T> matchingAnyOf(LeaveRequestRequest leaveRequest){
        super.internalMatchAny(leaveRequest);
        return this;
    }

    public LeaveRequestRequest<T> enhanceChildrenIfNeeded(){
        return this;
    }

    public LeaveRequestRequest<T> withDeletedRows(){
        super.withDeletedRows();
        return this;
    }

    public LeaveRequestRequest<T> deletedRowsOnly(){
        super.deletedRowsOnly();
        return this;
    }

    public LeaveRequestRequest<T> selectSelf(){
        super.selectSelf();
        return selectId().selectEmployeeIdOnly().selectEndDate().selectReason().selectStartDate().selectStatus().selectCreateTime().selectUpdateTime().selectVersion();
    }

    public LeaveRequestRequest<T> selectSelfFields(){
        return selectSelf();
    }

    public LeaveRequestRequest<T> selectAll(){
        super.selectAll();
        return selectId().selectEmployee().selectEndDate().selectReason().selectStartDate().selectStatus().selectCreateTime().selectUpdateTime().selectVersion();
    }

    public LeaveRequestRequest<T> selectChildren(){
        super.selectAny();
        return selectId().selectEmployee().selectEndDate().selectReason().selectStartDate().selectStatus().selectCreateTime().selectUpdateTime().selectVersion();
    }


    public LeaveRequestRequest<T> selectId(){
       selectProperty(LeaveRequest.ID_PROPERTY);
       return this;
    }

    /**
     * fill the id with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  id) to fetch id property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public LeaveRequestRequest<T> unselectId(){
       unselectProperty(LeaveRequest.ID_PROPERTY);
       return this;
    }
    public LeaveRequestRequest<T> selectEmployeeIdOnly(){
       selectProperty(LeaveRequest.EMPLOYEE_PROPERTY);
       return this;
    }

    public LeaveRequestRequest<T> selectEmployee(){
        return selectEmployeeWith(Q.employees().unlimited().selectSelf());
    }

    public LeaveRequestRequest<T> selectEmployeeWith(EmployeeRequest employee){
       selectProperty(LeaveRequest.EMPLOYEE_PROPERTY);
       enhanceRelation(LeaveRequest.EMPLOYEE_PROPERTY, employee);
       return this;
    }

    public LeaveRequestRequest<T> unselectEmployee(){
       unselectProperty(LeaveRequest.EMPLOYEE_PROPERTY);
       return this;
    }
    public LeaveRequestRequest<T> selectEndDate(){
       selectProperty(LeaveRequest.END_DATE_PROPERTY);
       return this;
    }

    /**
     * fill the endDate with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  endDate) to fetch endDate property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public LeaveRequestRequest<T> unselectEndDate(){
       unselectProperty(LeaveRequest.END_DATE_PROPERTY);
       return this;
    }
    public LeaveRequestRequest<T> selectReason(){
       selectProperty(LeaveRequest.REASON_PROPERTY);
       return this;
    }

    /**
     * fill the reason with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  reason) to fetch reason property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public LeaveRequestRequest<T> unselectReason(){
       unselectProperty(LeaveRequest.REASON_PROPERTY);
       return this;
    }
    public LeaveRequestRequest<T> selectStartDate(){
       selectProperty(LeaveRequest.START_DATE_PROPERTY);
       return this;
    }

    /**
     * fill the startDate with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  startDate) to fetch startDate property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public LeaveRequestRequest<T> unselectStartDate(){
       unselectProperty(LeaveRequest.START_DATE_PROPERTY);
       return this;
    }
    public LeaveRequestRequest<T> selectStatus(){
       selectProperty(LeaveRequest.STATUS_PROPERTY);
       return this;
    }

    /**
     * fill the status with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  status) to fetch status property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public LeaveRequestRequest<T> unselectStatus(){
       unselectProperty(LeaveRequest.STATUS_PROPERTY);
       return this;
    }
    public LeaveRequestRequest<T> selectCreateTime(){
       selectProperty(LeaveRequest.CREATE_TIME_PROPERTY);
       return this;
    }

    /**
     * fill the createTime with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  createTime) to fetch createTime property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public LeaveRequestRequest<T> unselectCreateTime(){
       unselectProperty(LeaveRequest.CREATE_TIME_PROPERTY);
       return this;
    }
    public LeaveRequestRequest<T> selectUpdateTime(){
       selectProperty(LeaveRequest.UPDATE_TIME_PROPERTY);
       return this;
    }

    /**
     * fill the updateTime with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  updateTime) to fetch updateTime property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public LeaveRequestRequest<T> unselectUpdateTime(){
       unselectProperty(LeaveRequest.UPDATE_TIME_PROPERTY);
       return this;
    }
    public LeaveRequestRequest<T> selectVersion(){
       selectProperty(LeaveRequest.VERSION_PROPERTY);
       return this;
    }

    /**
     * fill the version with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  version) to fetch version property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public LeaveRequestRequest<T> unselectVersion(){
       unselectProperty(LeaveRequest.VERSION_PROPERTY);
       return this;
    }

    public LeaveRequestRequest<T> withId(Operator operator, Object... values){
       return appendSearchCriteria(createIdCriteria(operator, values));
    }

    public SearchCriteria createIdCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(LeaveRequest.ID_PROPERTY, operator, values);
    }

    public LeaveRequestRequest<T> withIdIs(Long id){
       return withId(Operator.EQUAL, id);
    }
    public LeaveRequestRequest<T> withIdIn(Long... id){
       return withId(Operator.EQUAL, (Object[])id);
    }



    public LeaveRequestRequest<T> filterByEmployee(Employee... employee){
      if (employee == null || employee.length == 0) {
        throw new IllegalArgumentException("filterByEmployee parameter employee cannot be empty");
      }
      return appendSearchCriteria(createEmployeeCriteria(Operator.EQUAL, (Object[])employee));
    }

    public LeaveRequestRequest<T> withEmployee(Operator operator, Object... values){
       return appendSearchCriteria(createEmployeeCriteria(operator, values));
    }

    public LeaveRequestRequest<T> withEmployeeIsUnknown(){
       return withEmployee(Operator.IS_NULL);
    }

    public LeaveRequestRequest<T> withEmployeeIsKnown(){
       return withEmployee(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createEmployeeCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(LeaveRequest.EMPLOYEE_PROPERTY, operator, values);
    }

    public LeaveRequestRequest<T> filterByEmployee(Long employee){
      if(employee == null){
         return this;
      }
      return withEmployee(Operator.EQUAL, employee);
    }
    public LeaveRequestRequest<T> withEmployeeMatching(EmployeeRequest employee){
       return appendSearchCriteria(new SubQuerySearchCriteria(LeaveRequest.EMPLOYEE_PROPERTY, employee, Employee.ID_PROPERTY));
    }

    public LeaveRequestRequest<T> filterByEndDate(LocalDateTime... endDate){
      if (endDate == null || endDate.length == 0) {
        throw new IllegalArgumentException("filterByEndDate parameter endDate cannot be empty");
      }
      return appendSearchCriteria(createEndDateCriteria(Operator.EQUAL, (Object[])endDate));
    }

    public LeaveRequestRequest<T> withEndDate(Operator operator, Object... values){
       return appendSearchCriteria(createEndDateCriteria(operator, values));
    }

    public LeaveRequestRequest<T> withEndDateIsUnknown(){
       return withEndDate(Operator.IS_NULL);
    }

    public LeaveRequestRequest<T> withEndDateIsKnown(){
       return withEndDate(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createEndDateCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(LeaveRequest.END_DATE_PROPERTY, operator, values);
    }

    public LeaveRequestRequest<T> withEndDateGreaterThan(LocalDateTime endDate){
       return withEndDate(Operator.GREATER_THAN, endDate);
    }

    public LeaveRequestRequest<T> withEndDateGreaterThanOrEqualTo(LocalDateTime endDate){
       return withEndDate(Operator.GREATER_THAN_OR_EQUAL, endDate);
    }

    public LeaveRequestRequest<T> withEndDateLessThan(LocalDateTime endDate){
       return withEndDate(Operator.LESS_THAN, endDate);
    }

    public LeaveRequestRequest<T> withEndDateLessThanOrEqualTo(LocalDateTime endDate){
       return withEndDate(Operator.LESS_THAN_OR_EQUAL, endDate);
    }

    public LeaveRequestRequest<T> withEndDateBetween(LocalDateTime startOfEndDate, LocalDateTime endOfEndDate){
       return withEndDate(Operator.BETWEEN, startOfEndDate, endOfEndDate);
    }
    public LeaveRequestRequest<T> withEndDateBefore(LocalDateTime endDate){
       return withEndDate(Operator.LESS_THAN, endDate);
    }

    public LeaveRequestRequest<T> withEndDateBefore(Date endDate){
       return withEndDate(Operator.LESS_THAN, endDate);
    }

    public LeaveRequestRequest<T> withEndDateAfter(LocalDateTime endDate){
       return withEndDate(Operator.GREATER_THAN, endDate);
    }

    public LeaveRequestRequest<T> withEndDateAfter(Date endDate){
       return withEndDate(Operator.GREATER_THAN, endDate);
    }

    public LeaveRequestRequest<T> withEndDateBetween(Date startOfEndDate, Date endOfEndDate){
       return withEndDate(Operator.BETWEEN, startOfEndDate, endOfEndDate);
    }




    public LeaveRequestRequest<T> filterByReason(String... reason){
      if (reason == null || reason.length == 0) {
        throw new IllegalArgumentException("filterByReason parameter reason cannot be empty");
      }
      return appendSearchCriteria(createReasonCriteria(Operator.EQUAL, (Object[])reason));
    }

    public LeaveRequestRequest<T> withReason(Operator operator, Object... values){
       return appendSearchCriteria(createReasonCriteria(operator, values));
    }

    public LeaveRequestRequest<T> withReasonIsUnknown(){
       return withReason(Operator.IS_NULL);
    }

    public LeaveRequestRequest<T> withReasonIsKnown(){
       return withReason(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createReasonCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(LeaveRequest.REASON_PROPERTY, operator, values);
    }

    public LeaveRequestRequest<T> withReasonGreaterThan(String reason){
       return withReason(Operator.GREATER_THAN, reason);
    }

    public LeaveRequestRequest<T> withReasonGreaterThanOrEqualTo(String reason){
       return withReason(Operator.GREATER_THAN_OR_EQUAL, reason);
    }

    public LeaveRequestRequest<T> withReasonLessThan(String reason){
       return withReason(Operator.LESS_THAN, reason);
    }

    public LeaveRequestRequest<T> withReasonLessThanOrEqualTo(String reason){
       return withReason(Operator.LESS_THAN_OR_EQUAL, reason);
    }

    public LeaveRequestRequest<T> withReasonBetween(String startOfReason, String endOfReason){
       return withReason(Operator.BETWEEN, startOfReason, endOfReason);
    }
    public LeaveRequestRequest<T> withReasonStartingWith(String reason){
       return withReason(Operator.BEGIN_WITH, reason);
    }
    public LeaveRequestRequest<T> withReasonContaining(String reason){
       return withReason(Operator.CONTAIN, reason);
    }

    public LeaveRequestRequest<T> withReasonEndingWith(String reason){
       return withReason(Operator.END_WITH, reason);
    }

    public LeaveRequestRequest<T> withReasonIs(String reason){
       return withReason(Operator.EQUAL, reason);
    }

    public LeaveRequestRequest<T> withReasonSoundingLike(String reason){
       return withReason(Operator.SOUNDS_LIKE, reason);
    }



    public LeaveRequestRequest<T> filterByStartDate(LocalDateTime... startDate){
      if (startDate == null || startDate.length == 0) {
        throw new IllegalArgumentException("filterByStartDate parameter startDate cannot be empty");
      }
      return appendSearchCriteria(createStartDateCriteria(Operator.EQUAL, (Object[])startDate));
    }

    public LeaveRequestRequest<T> withStartDate(Operator operator, Object... values){
       return appendSearchCriteria(createStartDateCriteria(operator, values));
    }

    public LeaveRequestRequest<T> withStartDateIsUnknown(){
       return withStartDate(Operator.IS_NULL);
    }

    public LeaveRequestRequest<T> withStartDateIsKnown(){
       return withStartDate(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createStartDateCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(LeaveRequest.START_DATE_PROPERTY, operator, values);
    }

    public LeaveRequestRequest<T> withStartDateGreaterThan(LocalDateTime startDate){
       return withStartDate(Operator.GREATER_THAN, startDate);
    }

    public LeaveRequestRequest<T> withStartDateGreaterThanOrEqualTo(LocalDateTime startDate){
       return withStartDate(Operator.GREATER_THAN_OR_EQUAL, startDate);
    }

    public LeaveRequestRequest<T> withStartDateLessThan(LocalDateTime startDate){
       return withStartDate(Operator.LESS_THAN, startDate);
    }

    public LeaveRequestRequest<T> withStartDateLessThanOrEqualTo(LocalDateTime startDate){
       return withStartDate(Operator.LESS_THAN_OR_EQUAL, startDate);
    }

    public LeaveRequestRequest<T> withStartDateBetween(LocalDateTime startOfStartDate, LocalDateTime endOfStartDate){
       return withStartDate(Operator.BETWEEN, startOfStartDate, endOfStartDate);
    }
    public LeaveRequestRequest<T> withStartDateBefore(LocalDateTime startDate){
       return withStartDate(Operator.LESS_THAN, startDate);
    }

    public LeaveRequestRequest<T> withStartDateBefore(Date startDate){
       return withStartDate(Operator.LESS_THAN, startDate);
    }

    public LeaveRequestRequest<T> withStartDateAfter(LocalDateTime startDate){
       return withStartDate(Operator.GREATER_THAN, startDate);
    }

    public LeaveRequestRequest<T> withStartDateAfter(Date startDate){
       return withStartDate(Operator.GREATER_THAN, startDate);
    }

    public LeaveRequestRequest<T> withStartDateBetween(Date startOfStartDate, Date endOfStartDate){
       return withStartDate(Operator.BETWEEN, startOfStartDate, endOfStartDate);
    }




    public LeaveRequestRequest<T> filterByStatus(String... status){
      if (status == null || status.length == 0) {
        throw new IllegalArgumentException("filterByStatus parameter status cannot be empty");
      }
      return appendSearchCriteria(createStatusCriteria(Operator.EQUAL, (Object[])status));
    }

    public LeaveRequestRequest<T> withStatus(Operator operator, Object... values){
       return appendSearchCriteria(createStatusCriteria(operator, values));
    }

    public LeaveRequestRequest<T> withStatusIsUnknown(){
       return withStatus(Operator.IS_NULL);
    }

    public LeaveRequestRequest<T> withStatusIsKnown(){
       return withStatus(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createStatusCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(LeaveRequest.STATUS_PROPERTY, operator, values);
    }

    public LeaveRequestRequest<T> withStatusGreaterThan(String status){
       return withStatus(Operator.GREATER_THAN, status);
    }

    public LeaveRequestRequest<T> withStatusGreaterThanOrEqualTo(String status){
       return withStatus(Operator.GREATER_THAN_OR_EQUAL, status);
    }

    public LeaveRequestRequest<T> withStatusLessThan(String status){
       return withStatus(Operator.LESS_THAN, status);
    }

    public LeaveRequestRequest<T> withStatusLessThanOrEqualTo(String status){
       return withStatus(Operator.LESS_THAN_OR_EQUAL, status);
    }

    public LeaveRequestRequest<T> withStatusBetween(String startOfStatus, String endOfStatus){
       return withStatus(Operator.BETWEEN, startOfStatus, endOfStatus);
    }
    public LeaveRequestRequest<T> withStatusStartingWith(String status){
       return withStatus(Operator.BEGIN_WITH, status);
    }
    public LeaveRequestRequest<T> withStatusContaining(String status){
       return withStatus(Operator.CONTAIN, status);
    }

    public LeaveRequestRequest<T> withStatusEndingWith(String status){
       return withStatus(Operator.END_WITH, status);
    }

    public LeaveRequestRequest<T> withStatusIs(String status){
       return withStatus(Operator.EQUAL, status);
    }

    public LeaveRequestRequest<T> withStatusSoundingLike(String status){
       return withStatus(Operator.SOUNDS_LIKE, status);
    }



    public LeaveRequestRequest<T> filterByCreateTime(LocalDateTime... createTime){
      if (createTime == null || createTime.length == 0) {
        throw new IllegalArgumentException("filterByCreateTime parameter createTime cannot be empty");
      }
      return appendSearchCriteria(createCreateTimeCriteria(Operator.EQUAL, (Object[])createTime));
    }

    public LeaveRequestRequest<T> withCreateTime(Operator operator, Object... values){
       return appendSearchCriteria(createCreateTimeCriteria(operator, values));
    }

    public LeaveRequestRequest<T> withCreateTimeIsUnknown(){
       return withCreateTime(Operator.IS_NULL);
    }

    public LeaveRequestRequest<T> withCreateTimeIsKnown(){
       return withCreateTime(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createCreateTimeCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(LeaveRequest.CREATE_TIME_PROPERTY, operator, values);
    }

    public LeaveRequestRequest<T> withCreateTimeGreaterThan(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public LeaveRequestRequest<T> withCreateTimeGreaterThanOrEqualTo(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN_OR_EQUAL, createTime);
    }

    public LeaveRequestRequest<T> withCreateTimeLessThan(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public LeaveRequestRequest<T> withCreateTimeLessThanOrEqualTo(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN_OR_EQUAL, createTime);
    }

    public LeaveRequestRequest<T> withCreateTimeBetween(LocalDateTime startOfCreateTime, LocalDateTime endOfCreateTime){
       return withCreateTime(Operator.BETWEEN, startOfCreateTime, endOfCreateTime);
    }
    public LeaveRequestRequest<T> withCreateTimeBefore(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public LeaveRequestRequest<T> withCreateTimeBefore(Date createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public LeaveRequestRequest<T> withCreateTimeAfter(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public LeaveRequestRequest<T> withCreateTimeAfter(Date createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public LeaveRequestRequest<T> withCreateTimeBetween(Date startOfCreateTime, Date endOfCreateTime){
       return withCreateTime(Operator.BETWEEN, startOfCreateTime, endOfCreateTime);
    }




    public LeaveRequestRequest<T> filterByUpdateTime(LocalDateTime... updateTime){
      if (updateTime == null || updateTime.length == 0) {
        throw new IllegalArgumentException("filterByUpdateTime parameter updateTime cannot be empty");
      }
      return appendSearchCriteria(createUpdateTimeCriteria(Operator.EQUAL, (Object[])updateTime));
    }

    public LeaveRequestRequest<T> withUpdateTime(Operator operator, Object... values){
       return appendSearchCriteria(createUpdateTimeCriteria(operator, values));
    }

    public LeaveRequestRequest<T> withUpdateTimeIsUnknown(){
       return withUpdateTime(Operator.IS_NULL);
    }

    public LeaveRequestRequest<T> withUpdateTimeIsKnown(){
       return withUpdateTime(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createUpdateTimeCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(LeaveRequest.UPDATE_TIME_PROPERTY, operator, values);
    }

    public LeaveRequestRequest<T> withUpdateTimeGreaterThan(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public LeaveRequestRequest<T> withUpdateTimeGreaterThanOrEqualTo(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN_OR_EQUAL, updateTime);
    }

    public LeaveRequestRequest<T> withUpdateTimeLessThan(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public LeaveRequestRequest<T> withUpdateTimeLessThanOrEqualTo(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN_OR_EQUAL, updateTime);
    }

    public LeaveRequestRequest<T> withUpdateTimeBetween(LocalDateTime startOfUpdateTime, LocalDateTime endOfUpdateTime){
       return withUpdateTime(Operator.BETWEEN, startOfUpdateTime, endOfUpdateTime);
    }
    public LeaveRequestRequest<T> withUpdateTimeBefore(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public LeaveRequestRequest<T> withUpdateTimeBefore(Date updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public LeaveRequestRequest<T> withUpdateTimeAfter(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public LeaveRequestRequest<T> withUpdateTimeAfter(Date updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public LeaveRequestRequest<T> withUpdateTimeBetween(Date startOfUpdateTime, Date endOfUpdateTime){
       return withUpdateTime(Operator.BETWEEN, startOfUpdateTime, endOfUpdateTime);
    }




    public LeaveRequestRequest<T> filterByVersion(Long... version){
      if (version == null || version.length == 0) {
        throw new IllegalArgumentException("filterByVersion parameter version cannot be empty");
      }
      return appendSearchCriteria(createVersionCriteria(Operator.EQUAL, (Object[])version));
    }

    public LeaveRequestRequest<T> withVersion(Operator operator, Object... values){
       return appendSearchCriteria(createVersionCriteria(operator, values));
    }

    public LeaveRequestRequest<T> withVersionIsUnknown(){
       return withVersion(Operator.IS_NULL);
    }

    public LeaveRequestRequest<T> withVersionIsKnown(){
       return withVersion(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createVersionCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(LeaveRequest.VERSION_PROPERTY, operator, values);
    }

    public LeaveRequestRequest<T> withVersionGreaterThan(Long version){
       return withVersion(Operator.GREATER_THAN, version);
    }

    public LeaveRequestRequest<T> withVersionGreaterThanOrEqualTo(Long version){
       return withVersion(Operator.GREATER_THAN_OR_EQUAL, version);
    }

    public LeaveRequestRequest<T> withVersionLessThan(Long version){
       return withVersion(Operator.LESS_THAN, version);
    }

    public LeaveRequestRequest<T> withVersionLessThanOrEqualTo(Long version){
       return withVersion(Operator.LESS_THAN_OR_EQUAL, version);
    }

    public LeaveRequestRequest<T> withVersionBetween(Long startOfVersion, Long endOfVersion){
       return withVersion(Operator.BETWEEN, startOfVersion, endOfVersion);
    }


    public LeaveRequestRequest<T> count(){
        super.count();
        return this;
    }
    public LeaveRequestRequest<T> countAs(String retName){
        super.count(retName);
        return this;
    }
    public LeaveRequestRequest<T> groupByEmployeeWithDetails(){
       return groupByEmployeeWithDetails(Q.employees().unlimited());
    }

    public LeaveRequestRequest<T> groupByEmployeeWithDetails(EmployeeRequest subRequest){
       aggregate(LeaveRequest.EMPLOYEE_PROPERTY, subRequest);
       return this;
    }









    public LeaveRequestRequest<T> groupById(){
       groupBy(LeaveRequest.ID_PROPERTY);
       return this;
    }

    public LeaveRequestRequest<T> groupByIdAs(String retName){
       groupBy(retName, LeaveRequest.ID_PROPERTY);
       return this;
    }

    public LeaveRequestRequest<T> groupByIdWithFunction(String retName, AggrFunction function){
       groupBy(retName, LeaveRequest.ID_PROPERTY, function);
       return this;
    }
    public LeaveRequestRequest<T> groupByEmployeeWith(EmployeeRequest subRequest){
       groupBy(LeaveRequest.EMPLOYEE_PROPERTY, subRequest);
       return this;
    }
    public LeaveRequestRequest<T> groupByEmployee(){
       groupBy(LeaveRequest.EMPLOYEE_PROPERTY);
       return this;
    }

    public LeaveRequestRequest<T> groupByEmployeeAs(String retName){
       groupBy(retName, LeaveRequest.EMPLOYEE_PROPERTY);
       return this;
    }

    public LeaveRequestRequest<T> groupByEmployeeWithFunction(String retName, AggrFunction function){
       groupBy(retName, LeaveRequest.EMPLOYEE_PROPERTY, function);
       return this;
    }

    public LeaveRequestRequest<T> groupByEndDate(){
       groupBy(LeaveRequest.END_DATE_PROPERTY);
       return this;
    }

    public LeaveRequestRequest<T> groupByEndDateAs(String retName){
       groupBy(retName, LeaveRequest.END_DATE_PROPERTY);
       return this;
    }

    public LeaveRequestRequest<T> groupByEndDateWithFunction(String retName, AggrFunction function){
       groupBy(retName, LeaveRequest.END_DATE_PROPERTY, function);
       return this;
    }

    public LeaveRequestRequest<T> groupByReason(){
       groupBy(LeaveRequest.REASON_PROPERTY);
       return this;
    }

    public LeaveRequestRequest<T> groupByReasonAs(String retName){
       groupBy(retName, LeaveRequest.REASON_PROPERTY);
       return this;
    }

    public LeaveRequestRequest<T> groupByReasonWithFunction(String retName, AggrFunction function){
       groupBy(retName, LeaveRequest.REASON_PROPERTY, function);
       return this;
    }

    public LeaveRequestRequest<T> groupByStartDate(){
       groupBy(LeaveRequest.START_DATE_PROPERTY);
       return this;
    }

    public LeaveRequestRequest<T> groupByStartDateAs(String retName){
       groupBy(retName, LeaveRequest.START_DATE_PROPERTY);
       return this;
    }

    public LeaveRequestRequest<T> groupByStartDateWithFunction(String retName, AggrFunction function){
       groupBy(retName, LeaveRequest.START_DATE_PROPERTY, function);
       return this;
    }

    public LeaveRequestRequest<T> groupByStatus(){
       groupBy(LeaveRequest.STATUS_PROPERTY);
       return this;
    }

    public LeaveRequestRequest<T> groupByStatusAs(String retName){
       groupBy(retName, LeaveRequest.STATUS_PROPERTY);
       return this;
    }

    public LeaveRequestRequest<T> groupByStatusWithFunction(String retName, AggrFunction function){
       groupBy(retName, LeaveRequest.STATUS_PROPERTY, function);
       return this;
    }

    public LeaveRequestRequest<T> groupByCreateTime(){
       groupBy(LeaveRequest.CREATE_TIME_PROPERTY);
       return this;
    }

    public LeaveRequestRequest<T> groupByCreateTimeAs(String retName){
       groupBy(retName, LeaveRequest.CREATE_TIME_PROPERTY);
       return this;
    }

    public LeaveRequestRequest<T> groupByCreateTimeWithFunction(String retName, AggrFunction function){
       groupBy(retName, LeaveRequest.CREATE_TIME_PROPERTY, function);
       return this;
    }

    public LeaveRequestRequest<T> groupByUpdateTime(){
       groupBy(LeaveRequest.UPDATE_TIME_PROPERTY);
       return this;
    }

    public LeaveRequestRequest<T> groupByUpdateTimeAs(String retName){
       groupBy(retName, LeaveRequest.UPDATE_TIME_PROPERTY);
       return this;
    }

    public LeaveRequestRequest<T> groupByUpdateTimeWithFunction(String retName, AggrFunction function){
       groupBy(retName, LeaveRequest.UPDATE_TIME_PROPERTY, function);
       return this;
    }

    public LeaveRequestRequest<T> groupByVersion(){
       groupBy(LeaveRequest.VERSION_PROPERTY);
       return this;
    }

    public LeaveRequestRequest<T> groupByVersionAs(String retName){
       groupBy(retName, LeaveRequest.VERSION_PROPERTY);
       return this;
    }

    public LeaveRequestRequest<T> groupByVersionWithFunction(String retName, AggrFunction function){
       groupBy(retName, LeaveRequest.VERSION_PROPERTY, function);
       return this;
    }



    public LeaveRequestRequest<T> orderByIdAscending(){
       addOrderByAscending(LeaveRequest.ID_PROPERTY);
       return this;
    }

    public LeaveRequestRequest<T> orderByIdDescending(){
       addOrderByDescending(LeaveRequest.ID_PROPERTY);
       return this;
    }

    public LeaveRequestRequest<T> orderByEmployeeAscending(){
       addOrderByAscending(LeaveRequest.EMPLOYEE_PROPERTY);
       return this;
    }

    public LeaveRequestRequest<T> orderByEmployeeDescending(){
       addOrderByDescending(LeaveRequest.EMPLOYEE_PROPERTY);
       return this;
    }

    public LeaveRequestRequest<T> orderByEndDateAscending(){
       addOrderByAscending(LeaveRequest.END_DATE_PROPERTY);
       return this;
    }

    public LeaveRequestRequest<T> orderByEndDateDescending(){
       addOrderByDescending(LeaveRequest.END_DATE_PROPERTY);
       return this;
    }

    public LeaveRequestRequest<T> orderByReasonAscending(){
       addOrderByAscending(LeaveRequest.REASON_PROPERTY);
       return this;
    }

    public LeaveRequestRequest<T> orderByReasonDescending(){
       addOrderByDescending(LeaveRequest.REASON_PROPERTY);
       return this;
    }
    public LeaveRequestRequest<T> orderByReasonAscendingUsingGBK(){
       addOrderByAscendingUsingGBK(LeaveRequest.REASON_PROPERTY);
       return this;
    }

    public LeaveRequestRequest<T> orderByReasonDescendingUsingGBK(){
       addOrderByDescendingUsingGBK(LeaveRequest.REASON_PROPERTY);
       return this;
    }
    public LeaveRequestRequest<T> orderByStartDateAscending(){
       addOrderByAscending(LeaveRequest.START_DATE_PROPERTY);
       return this;
    }

    public LeaveRequestRequest<T> orderByStartDateDescending(){
       addOrderByDescending(LeaveRequest.START_DATE_PROPERTY);
       return this;
    }

    public LeaveRequestRequest<T> orderByStatusAscending(){
       addOrderByAscending(LeaveRequest.STATUS_PROPERTY);
       return this;
    }

    public LeaveRequestRequest<T> orderByStatusDescending(){
       addOrderByDescending(LeaveRequest.STATUS_PROPERTY);
       return this;
    }
    public LeaveRequestRequest<T> orderByStatusAscendingUsingGBK(){
       addOrderByAscendingUsingGBK(LeaveRequest.STATUS_PROPERTY);
       return this;
    }

    public LeaveRequestRequest<T> orderByStatusDescendingUsingGBK(){
       addOrderByDescendingUsingGBK(LeaveRequest.STATUS_PROPERTY);
       return this;
    }
    public LeaveRequestRequest<T> orderByCreateTimeAscending(){
       addOrderByAscending(LeaveRequest.CREATE_TIME_PROPERTY);
       return this;
    }

    public LeaveRequestRequest<T> orderByCreateTimeDescending(){
       addOrderByDescending(LeaveRequest.CREATE_TIME_PROPERTY);
       return this;
    }

    public LeaveRequestRequest<T> orderByUpdateTimeAscending(){
       addOrderByAscending(LeaveRequest.UPDATE_TIME_PROPERTY);
       return this;
    }

    public LeaveRequestRequest<T> orderByUpdateTimeDescending(){
       addOrderByDescending(LeaveRequest.UPDATE_TIME_PROPERTY);
       return this;
    }

    public LeaveRequestRequest<T> orderByVersionAscending(){
       addOrderByAscending(LeaveRequest.VERSION_PROPERTY);
       return this;
    }

    public LeaveRequestRequest<T> orderByVersionDescending(){
       addOrderByDescending(LeaveRequest.VERSION_PROPERTY);
       return this;
    }


    public EmployeeRequest rollUpToEmployee(){
       EmployeeRequest employee = Q.employees().unlimited();
       this.withEmployeeMatching(employee)
           .groupByEmployeeWith(employee);
       return employee;
    }









   public LeaveRequestRequest<T> facetByEmployeeAs(String facetName, EmployeeRequest employee){
       return facetByEmployeeAs(facetName, employee, true);
   }

   public LeaveRequestRequest<T> facetByEmployeeAs(String facetName, EmployeeRequest employee, boolean includeAllFacets){
       addFacet(facetName, LeaveRequest.EMPLOYEE_PROPERTY, employee, includeAllFacets);
       return this;
   }


    /**
     * get topN records
     * @param topN  records number
     */
    public LeaveRequestRequest<T> top(int topN) {
        super.top(topN);
        return this;
    }

    /**
     * get records from offset(inclusive) to offset+size(exclusive)
     * @param offset record offset
     * @param size records number
     */
    public LeaveRequestRequest<T> offset(int offset, int size) {
        super.offset(offset, size);
        return this;
    }

    /**
     * retrieve all records
     */
    public LeaveRequestRequest<T> unlimited() {
        super.unlimited();
        return this;
    }

    /**
     * get records of one page
     * @param pageNumber page number(1-based)
     * @param pageSize page size
     */
    public LeaveRequestRequest<T> page(int pageNumber, int pageSize) {
        int offset = (pageNumber - 1) * pageSize;
        return offset(offset, pageSize);
   }

    /**
     * get records of one page, default page size is 10
     * @param pageNumber page number(1-based)
     */
    public LeaveRequestRequest<T> page(int pageNumber) {
        return page(pageNumber, 10);
   }
}