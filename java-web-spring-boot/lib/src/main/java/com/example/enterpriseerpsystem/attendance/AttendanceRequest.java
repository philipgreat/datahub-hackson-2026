
package com.example.enterpriseerpsystem.attendance;

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

public class AttendanceRequest<T extends Attendance> extends BaseRequest<T> {

    /**
     * @deprecated AI agents and business code must use the generated Q facade
     *             instead of constructing request builders directly.
     */
    @Deprecated
    public AttendanceRequest(Class<T> returnType){
        super(returnType);
        selectId();
        selectVersion();
    }

    public AttendanceRequest<T> comment(String comment){
         super.internalComment(comment);
         return this;
    }

    // purpose() 继承自 BaseRequest，返回 ExecutableRequest（终结方法）

    public AttendanceRequest<T> returnType(Class<? extends T> returnType){
        super.setReturnType(returnType);
        return this;
    }

    public AttendanceRequest<T> enableAggregationCache(long cacheExpiredMillis){
        super.enableAggregationCache();
        super.aggregateCacheTime(cacheExpiredMillis);
        return this;
    }

    public AttendanceRequest<T> enableAggregationCache(){
        return enableAggregationCache(0l);
    }


    public AttendanceRequest<T> propagateAggregationCache(long cacheExpiredMillis){
        super.propagateAggregationCache(cacheExpiredMillis);
        return this;
    }

    public AttendanceRequest<T> appendSearchCriteria(SearchCriteria searchCriteria){
        return (AttendanceRequest<T>)super.appendSearchCriteria(searchCriteria);
    }

    public AttendanceRequest<T> filter(String property1, Operator operator, String property2){
        return appendSearchCriteria(new TwoOperatorCriteria(operator, new PropertyReference(property1), new PropertyReference(property2)));
    }


    public AttendanceRequest<T> matchingAnyOf(AttendanceRequest attendance){
        super.internalMatchAny(attendance);
        return this;
    }

    public AttendanceRequest<T> enhanceChildrenIfNeeded(){
        return this;
    }

    public AttendanceRequest<T> withDeletedRows(){
        super.withDeletedRows();
        return this;
    }

    public AttendanceRequest<T> deletedRowsOnly(){
        super.deletedRowsOnly();
        return this;
    }

    public AttendanceRequest<T> selectSelf(){
        super.selectSelf();
        return selectId().selectCheckIn().selectCheckOut().selectEmployeeIdOnly().selectHoursWorked().selectCreateTime().selectUpdateTime().selectVersion();
    }

    public AttendanceRequest<T> selectSelfFields(){
        return selectSelf();
    }

    public AttendanceRequest<T> selectAll(){
        super.selectAll();
        return selectId().selectCheckIn().selectCheckOut().selectEmployee().selectHoursWorked().selectCreateTime().selectUpdateTime().selectVersion();
    }

    public AttendanceRequest<T> selectChildren(){
        super.selectAny();
        return selectId().selectCheckIn().selectCheckOut().selectEmployee().selectHoursWorked().selectCreateTime().selectUpdateTime().selectVersion();
    }


    public AttendanceRequest<T> selectId(){
       selectProperty(Attendance.ID_PROPERTY);
       return this;
    }

    /**
     * fill the id with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  id) to fetch id property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public AttendanceRequest<T> unselectId(){
       unselectProperty(Attendance.ID_PROPERTY);
       return this;
    }
    public AttendanceRequest<T> selectCheckIn(){
       selectProperty(Attendance.CHECK_IN_PROPERTY);
       return this;
    }

    /**
     * fill the checkIn with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  checkIn) to fetch checkIn property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public AttendanceRequest<T> unselectCheckIn(){
       unselectProperty(Attendance.CHECK_IN_PROPERTY);
       return this;
    }
    public AttendanceRequest<T> selectCheckOut(){
       selectProperty(Attendance.CHECK_OUT_PROPERTY);
       return this;
    }

    /**
     * fill the checkOut with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  checkOut) to fetch checkOut property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public AttendanceRequest<T> unselectCheckOut(){
       unselectProperty(Attendance.CHECK_OUT_PROPERTY);
       return this;
    }
    public AttendanceRequest<T> selectEmployeeIdOnly(){
       selectProperty(Attendance.EMPLOYEE_PROPERTY);
       return this;
    }

    public AttendanceRequest<T> selectEmployee(){
        return selectEmployeeWith(Q.employees().unlimited().selectSelf());
    }

    public AttendanceRequest<T> selectEmployeeWith(EmployeeRequest employee){
       selectProperty(Attendance.EMPLOYEE_PROPERTY);
       enhanceRelation(Attendance.EMPLOYEE_PROPERTY, employee);
       return this;
    }

    public AttendanceRequest<T> unselectEmployee(){
       unselectProperty(Attendance.EMPLOYEE_PROPERTY);
       return this;
    }
    public AttendanceRequest<T> selectHoursWorked(){
       selectProperty(Attendance.HOURS_WORKED_PROPERTY);
       return this;
    }

    /**
     * fill the hoursWorked with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  hoursWorked) to fetch hoursWorked property.
     * @param rawSqlSegment  customized rawSqlSegment
     */


    /**
     * fill the hoursWorked with customized aggrFunction, TEAQL uses ({aggrFunction}(hoursWorked) AS hoursWorked to fetch hoursWorked property.
     * @param aggrFunction  aggrFunction
     */
    public AttendanceRequest<T> selectHoursWorked(AggrFunction aggrFunction){
       selectProperty(Attendance.HOURS_WORKED_PROPERTY, aggrFunction);
       return this;
    }


    public AttendanceRequest<T> unselectHoursWorked(){
       unselectProperty(Attendance.HOURS_WORKED_PROPERTY);
       return this;
    }
    public AttendanceRequest<T> selectCreateTime(){
       selectProperty(Attendance.CREATE_TIME_PROPERTY);
       return this;
    }

    /**
     * fill the createTime with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  createTime) to fetch createTime property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public AttendanceRequest<T> unselectCreateTime(){
       unselectProperty(Attendance.CREATE_TIME_PROPERTY);
       return this;
    }
    public AttendanceRequest<T> selectUpdateTime(){
       selectProperty(Attendance.UPDATE_TIME_PROPERTY);
       return this;
    }

    /**
     * fill the updateTime with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  updateTime) to fetch updateTime property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public AttendanceRequest<T> unselectUpdateTime(){
       unselectProperty(Attendance.UPDATE_TIME_PROPERTY);
       return this;
    }
    public AttendanceRequest<T> selectVersion(){
       selectProperty(Attendance.VERSION_PROPERTY);
       return this;
    }

    /**
     * fill the version with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  version) to fetch version property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public AttendanceRequest<T> unselectVersion(){
       unselectProperty(Attendance.VERSION_PROPERTY);
       return this;
    }

    public AttendanceRequest<T> withId(Operator operator, Object... values){
       return appendSearchCriteria(createIdCriteria(operator, values));
    }

    public SearchCriteria createIdCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Attendance.ID_PROPERTY, operator, values);
    }

    public AttendanceRequest<T> withIdIs(Long id){
       return withId(Operator.EQUAL, id);
    }
    public AttendanceRequest<T> withIdIn(Long... id){
       return withId(Operator.EQUAL, (Object[])id);
    }



    public AttendanceRequest<T> filterByCheckIn(LocalDateTime... checkIn){
      if (checkIn == null || checkIn.length == 0) {
        throw new IllegalArgumentException("filterByCheckIn parameter checkIn cannot be empty");
      }
      return appendSearchCriteria(createCheckInCriteria(Operator.EQUAL, (Object[])checkIn));
    }

    public AttendanceRequest<T> withCheckIn(Operator operator, Object... values){
       return appendSearchCriteria(createCheckInCriteria(operator, values));
    }

    public AttendanceRequest<T> withCheckInIsUnknown(){
       return withCheckIn(Operator.IS_NULL);
    }

    public AttendanceRequest<T> withCheckInIsKnown(){
       return withCheckIn(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createCheckInCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Attendance.CHECK_IN_PROPERTY, operator, values);
    }

    public AttendanceRequest<T> withCheckInGreaterThan(LocalDateTime checkIn){
       return withCheckIn(Operator.GREATER_THAN, checkIn);
    }

    public AttendanceRequest<T> withCheckInGreaterThanOrEqualTo(LocalDateTime checkIn){
       return withCheckIn(Operator.GREATER_THAN_OR_EQUAL, checkIn);
    }

    public AttendanceRequest<T> withCheckInLessThan(LocalDateTime checkIn){
       return withCheckIn(Operator.LESS_THAN, checkIn);
    }

    public AttendanceRequest<T> withCheckInLessThanOrEqualTo(LocalDateTime checkIn){
       return withCheckIn(Operator.LESS_THAN_OR_EQUAL, checkIn);
    }

    public AttendanceRequest<T> withCheckInBetween(LocalDateTime startOfCheckIn, LocalDateTime endOfCheckIn){
       return withCheckIn(Operator.BETWEEN, startOfCheckIn, endOfCheckIn);
    }
    public AttendanceRequest<T> withCheckInBefore(LocalDateTime checkIn){
       return withCheckIn(Operator.LESS_THAN, checkIn);
    }

    public AttendanceRequest<T> withCheckInBefore(Date checkIn){
       return withCheckIn(Operator.LESS_THAN, checkIn);
    }

    public AttendanceRequest<T> withCheckInAfter(LocalDateTime checkIn){
       return withCheckIn(Operator.GREATER_THAN, checkIn);
    }

    public AttendanceRequest<T> withCheckInAfter(Date checkIn){
       return withCheckIn(Operator.GREATER_THAN, checkIn);
    }

    public AttendanceRequest<T> withCheckInBetween(Date startOfCheckIn, Date endOfCheckIn){
       return withCheckIn(Operator.BETWEEN, startOfCheckIn, endOfCheckIn);
    }




    public AttendanceRequest<T> filterByCheckOut(LocalDateTime... checkOut){
      if (checkOut == null || checkOut.length == 0) {
        throw new IllegalArgumentException("filterByCheckOut parameter checkOut cannot be empty");
      }
      return appendSearchCriteria(createCheckOutCriteria(Operator.EQUAL, (Object[])checkOut));
    }

    public AttendanceRequest<T> withCheckOut(Operator operator, Object... values){
       return appendSearchCriteria(createCheckOutCriteria(operator, values));
    }

    public AttendanceRequest<T> withCheckOutIsUnknown(){
       return withCheckOut(Operator.IS_NULL);
    }

    public AttendanceRequest<T> withCheckOutIsKnown(){
       return withCheckOut(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createCheckOutCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Attendance.CHECK_OUT_PROPERTY, operator, values);
    }

    public AttendanceRequest<T> withCheckOutGreaterThan(LocalDateTime checkOut){
       return withCheckOut(Operator.GREATER_THAN, checkOut);
    }

    public AttendanceRequest<T> withCheckOutGreaterThanOrEqualTo(LocalDateTime checkOut){
       return withCheckOut(Operator.GREATER_THAN_OR_EQUAL, checkOut);
    }

    public AttendanceRequest<T> withCheckOutLessThan(LocalDateTime checkOut){
       return withCheckOut(Operator.LESS_THAN, checkOut);
    }

    public AttendanceRequest<T> withCheckOutLessThanOrEqualTo(LocalDateTime checkOut){
       return withCheckOut(Operator.LESS_THAN_OR_EQUAL, checkOut);
    }

    public AttendanceRequest<T> withCheckOutBetween(LocalDateTime startOfCheckOut, LocalDateTime endOfCheckOut){
       return withCheckOut(Operator.BETWEEN, startOfCheckOut, endOfCheckOut);
    }
    public AttendanceRequest<T> withCheckOutBefore(LocalDateTime checkOut){
       return withCheckOut(Operator.LESS_THAN, checkOut);
    }

    public AttendanceRequest<T> withCheckOutBefore(Date checkOut){
       return withCheckOut(Operator.LESS_THAN, checkOut);
    }

    public AttendanceRequest<T> withCheckOutAfter(LocalDateTime checkOut){
       return withCheckOut(Operator.GREATER_THAN, checkOut);
    }

    public AttendanceRequest<T> withCheckOutAfter(Date checkOut){
       return withCheckOut(Operator.GREATER_THAN, checkOut);
    }

    public AttendanceRequest<T> withCheckOutBetween(Date startOfCheckOut, Date endOfCheckOut){
       return withCheckOut(Operator.BETWEEN, startOfCheckOut, endOfCheckOut);
    }




    public AttendanceRequest<T> filterByEmployee(Employee... employee){
      if (employee == null || employee.length == 0) {
        throw new IllegalArgumentException("filterByEmployee parameter employee cannot be empty");
      }
      return appendSearchCriteria(createEmployeeCriteria(Operator.EQUAL, (Object[])employee));
    }

    public AttendanceRequest<T> withEmployee(Operator operator, Object... values){
       return appendSearchCriteria(createEmployeeCriteria(operator, values));
    }

    public AttendanceRequest<T> withEmployeeIsUnknown(){
       return withEmployee(Operator.IS_NULL);
    }

    public AttendanceRequest<T> withEmployeeIsKnown(){
       return withEmployee(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createEmployeeCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Attendance.EMPLOYEE_PROPERTY, operator, values);
    }

    public AttendanceRequest<T> filterByEmployee(Long employee){
      if(employee == null){
         return this;
      }
      return withEmployee(Operator.EQUAL, employee);
    }
    public AttendanceRequest<T> withEmployeeMatching(EmployeeRequest employee){
       return appendSearchCriteria(new SubQuerySearchCriteria(Attendance.EMPLOYEE_PROPERTY, employee, Employee.ID_PROPERTY));
    }

    public AttendanceRequest<T> filterByHoursWorked(BigDecimal... hoursWorked){
      if (hoursWorked == null || hoursWorked.length == 0) {
        throw new IllegalArgumentException("filterByHoursWorked parameter hoursWorked cannot be empty");
      }
      return appendSearchCriteria(createHoursWorkedCriteria(Operator.EQUAL, (Object[])hoursWorked));
    }

    public AttendanceRequest<T> withHoursWorked(Operator operator, Object... values){
       return appendSearchCriteria(createHoursWorkedCriteria(operator, values));
    }

    public AttendanceRequest<T> withHoursWorkedIsUnknown(){
       return withHoursWorked(Operator.IS_NULL);
    }

    public AttendanceRequest<T> withHoursWorkedIsKnown(){
       return withHoursWorked(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createHoursWorkedCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Attendance.HOURS_WORKED_PROPERTY, operator, values);
    }

    public AttendanceRequest<T> withHoursWorkedGreaterThan(BigDecimal hoursWorked){
       return withHoursWorked(Operator.GREATER_THAN, hoursWorked);
    }

    public AttendanceRequest<T> withHoursWorkedGreaterThanOrEqualTo(BigDecimal hoursWorked){
       return withHoursWorked(Operator.GREATER_THAN_OR_EQUAL, hoursWorked);
    }

    public AttendanceRequest<T> withHoursWorkedLessThan(BigDecimal hoursWorked){
       return withHoursWorked(Operator.LESS_THAN, hoursWorked);
    }

    public AttendanceRequest<T> withHoursWorkedLessThanOrEqualTo(BigDecimal hoursWorked){
       return withHoursWorked(Operator.LESS_THAN_OR_EQUAL, hoursWorked);
    }

    public AttendanceRequest<T> withHoursWorkedBetween(BigDecimal startOfHoursWorked, BigDecimal endOfHoursWorked){
       return withHoursWorked(Operator.BETWEEN, startOfHoursWorked, endOfHoursWorked);
    }



    public AttendanceRequest<T> filterByCreateTime(LocalDateTime... createTime){
      if (createTime == null || createTime.length == 0) {
        throw new IllegalArgumentException("filterByCreateTime parameter createTime cannot be empty");
      }
      return appendSearchCriteria(createCreateTimeCriteria(Operator.EQUAL, (Object[])createTime));
    }

    public AttendanceRequest<T> withCreateTime(Operator operator, Object... values){
       return appendSearchCriteria(createCreateTimeCriteria(operator, values));
    }

    public AttendanceRequest<T> withCreateTimeIsUnknown(){
       return withCreateTime(Operator.IS_NULL);
    }

    public AttendanceRequest<T> withCreateTimeIsKnown(){
       return withCreateTime(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createCreateTimeCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Attendance.CREATE_TIME_PROPERTY, operator, values);
    }

    public AttendanceRequest<T> withCreateTimeGreaterThan(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public AttendanceRequest<T> withCreateTimeGreaterThanOrEqualTo(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN_OR_EQUAL, createTime);
    }

    public AttendanceRequest<T> withCreateTimeLessThan(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public AttendanceRequest<T> withCreateTimeLessThanOrEqualTo(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN_OR_EQUAL, createTime);
    }

    public AttendanceRequest<T> withCreateTimeBetween(LocalDateTime startOfCreateTime, LocalDateTime endOfCreateTime){
       return withCreateTime(Operator.BETWEEN, startOfCreateTime, endOfCreateTime);
    }
    public AttendanceRequest<T> withCreateTimeBefore(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public AttendanceRequest<T> withCreateTimeBefore(Date createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public AttendanceRequest<T> withCreateTimeAfter(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public AttendanceRequest<T> withCreateTimeAfter(Date createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public AttendanceRequest<T> withCreateTimeBetween(Date startOfCreateTime, Date endOfCreateTime){
       return withCreateTime(Operator.BETWEEN, startOfCreateTime, endOfCreateTime);
    }




    public AttendanceRequest<T> filterByUpdateTime(LocalDateTime... updateTime){
      if (updateTime == null || updateTime.length == 0) {
        throw new IllegalArgumentException("filterByUpdateTime parameter updateTime cannot be empty");
      }
      return appendSearchCriteria(createUpdateTimeCriteria(Operator.EQUAL, (Object[])updateTime));
    }

    public AttendanceRequest<T> withUpdateTime(Operator operator, Object... values){
       return appendSearchCriteria(createUpdateTimeCriteria(operator, values));
    }

    public AttendanceRequest<T> withUpdateTimeIsUnknown(){
       return withUpdateTime(Operator.IS_NULL);
    }

    public AttendanceRequest<T> withUpdateTimeIsKnown(){
       return withUpdateTime(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createUpdateTimeCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Attendance.UPDATE_TIME_PROPERTY, operator, values);
    }

    public AttendanceRequest<T> withUpdateTimeGreaterThan(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public AttendanceRequest<T> withUpdateTimeGreaterThanOrEqualTo(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN_OR_EQUAL, updateTime);
    }

    public AttendanceRequest<T> withUpdateTimeLessThan(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public AttendanceRequest<T> withUpdateTimeLessThanOrEqualTo(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN_OR_EQUAL, updateTime);
    }

    public AttendanceRequest<T> withUpdateTimeBetween(LocalDateTime startOfUpdateTime, LocalDateTime endOfUpdateTime){
       return withUpdateTime(Operator.BETWEEN, startOfUpdateTime, endOfUpdateTime);
    }
    public AttendanceRequest<T> withUpdateTimeBefore(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public AttendanceRequest<T> withUpdateTimeBefore(Date updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public AttendanceRequest<T> withUpdateTimeAfter(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public AttendanceRequest<T> withUpdateTimeAfter(Date updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public AttendanceRequest<T> withUpdateTimeBetween(Date startOfUpdateTime, Date endOfUpdateTime){
       return withUpdateTime(Operator.BETWEEN, startOfUpdateTime, endOfUpdateTime);
    }




    public AttendanceRequest<T> filterByVersion(Long... version){
      if (version == null || version.length == 0) {
        throw new IllegalArgumentException("filterByVersion parameter version cannot be empty");
      }
      return appendSearchCriteria(createVersionCriteria(Operator.EQUAL, (Object[])version));
    }

    public AttendanceRequest<T> withVersion(Operator operator, Object... values){
       return appendSearchCriteria(createVersionCriteria(operator, values));
    }

    public AttendanceRequest<T> withVersionIsUnknown(){
       return withVersion(Operator.IS_NULL);
    }

    public AttendanceRequest<T> withVersionIsKnown(){
       return withVersion(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createVersionCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Attendance.VERSION_PROPERTY, operator, values);
    }

    public AttendanceRequest<T> withVersionGreaterThan(Long version){
       return withVersion(Operator.GREATER_THAN, version);
    }

    public AttendanceRequest<T> withVersionGreaterThanOrEqualTo(Long version){
       return withVersion(Operator.GREATER_THAN_OR_EQUAL, version);
    }

    public AttendanceRequest<T> withVersionLessThan(Long version){
       return withVersion(Operator.LESS_THAN, version);
    }

    public AttendanceRequest<T> withVersionLessThanOrEqualTo(Long version){
       return withVersion(Operator.LESS_THAN_OR_EQUAL, version);
    }

    public AttendanceRequest<T> withVersionBetween(Long startOfVersion, Long endOfVersion){
       return withVersion(Operator.BETWEEN, startOfVersion, endOfVersion);
    }


    public AttendanceRequest<T> count(){
        super.count();
        return this;
    }
    public AttendanceRequest<T> countAs(String retName){
        super.count(retName);
        return this;
    }
    public AttendanceRequest minHoursWorked(){
        return minHoursWorkedAs(prefix("minOf",Attendance.HOURS_WORKED_PROPERTY));
    }

    public AttendanceRequest minHoursWorkedAs(String retName){
        super.min(retName, Attendance.HOURS_WORKED_PROPERTY);
        return this;
    }
    public AttendanceRequest maxHoursWorked(){
        return maxHoursWorkedAs(prefix("maxOf",Attendance.HOURS_WORKED_PROPERTY));
    }

    public AttendanceRequest maxHoursWorkedAs(String retName){
        super.max(retName, Attendance.HOURS_WORKED_PROPERTY);
        return this;
    }
    public AttendanceRequest sumHoursWorked(){
        return sumHoursWorkedAs(prefix("sumOf",Attendance.HOURS_WORKED_PROPERTY));
    }

    public AttendanceRequest sumHoursWorkedAs(String retName){
        super.sum(retName, Attendance.HOURS_WORKED_PROPERTY);
        return this;
    }
    public AttendanceRequest avgHoursWorked(){
        return avgHoursWorkedAs(prefix("avgOf",Attendance.HOURS_WORKED_PROPERTY));
    }

    public AttendanceRequest avgHoursWorkedAs(String retName){
        super.avg(retName, Attendance.HOURS_WORKED_PROPERTY);
        return this;
    }
    public AttendanceRequest standardDeviationHoursWorked(){
        return standardDeviationHoursWorkedAs(prefix("standardDeviationOf",Attendance.HOURS_WORKED_PROPERTY));
    }

    public AttendanceRequest standardDeviationHoursWorkedAs(String retName){
        super.standardDeviation(retName, Attendance.HOURS_WORKED_PROPERTY);
        return this;
    }
    public AttendanceRequest squareRootOfPopulationStandardDeviationHoursWorked(){
        return squareRootOfPopulationStandardDeviationHoursWorkedAs(prefix("squareRootOfPopulationStandardDeviationOf",Attendance.HOURS_WORKED_PROPERTY));
    }

    public AttendanceRequest squareRootOfPopulationStandardDeviationHoursWorkedAs(String retName){
        super.squareRootOfPopulationStandardDeviation(retName, Attendance.HOURS_WORKED_PROPERTY);
        return this;
    }
    public AttendanceRequest sampleVarianceHoursWorked(){
        return sampleVarianceHoursWorkedAs(prefix("sampleVarianceOf",Attendance.HOURS_WORKED_PROPERTY));
    }

    public AttendanceRequest sampleVarianceHoursWorkedAs(String retName){
        super.sampleVariance(retName, Attendance.HOURS_WORKED_PROPERTY);
        return this;
    }
    public AttendanceRequest samplePopulationVarianceHoursWorked(){
        return samplePopulationVarianceHoursWorkedAs(prefix("samplePopulationVarianceOf",Attendance.HOURS_WORKED_PROPERTY));
    }

    public AttendanceRequest samplePopulationVarianceHoursWorkedAs(String retName){
        super.samplePopulationVariance(retName, Attendance.HOURS_WORKED_PROPERTY);
        return this;
    }
    public AttendanceRequest<T> groupByEmployeeWithDetails(){
       return groupByEmployeeWithDetails(Q.employees().unlimited());
    }

    public AttendanceRequest<T> groupByEmployeeWithDetails(EmployeeRequest subRequest){
       aggregate(Attendance.EMPLOYEE_PROPERTY, subRequest);
       return this;
    }






    public AttendanceRequest<T> groupById(){
       groupBy(Attendance.ID_PROPERTY);
       return this;
    }

    public AttendanceRequest<T> groupByIdAs(String retName){
       groupBy(retName, Attendance.ID_PROPERTY);
       return this;
    }

    public AttendanceRequest<T> groupByIdWithFunction(String retName, AggrFunction function){
       groupBy(retName, Attendance.ID_PROPERTY, function);
       return this;
    }

    public AttendanceRequest<T> groupByCheckIn(){
       groupBy(Attendance.CHECK_IN_PROPERTY);
       return this;
    }

    public AttendanceRequest<T> groupByCheckInAs(String retName){
       groupBy(retName, Attendance.CHECK_IN_PROPERTY);
       return this;
    }

    public AttendanceRequest<T> groupByCheckInWithFunction(String retName, AggrFunction function){
       groupBy(retName, Attendance.CHECK_IN_PROPERTY, function);
       return this;
    }

    public AttendanceRequest<T> groupByCheckOut(){
       groupBy(Attendance.CHECK_OUT_PROPERTY);
       return this;
    }

    public AttendanceRequest<T> groupByCheckOutAs(String retName){
       groupBy(retName, Attendance.CHECK_OUT_PROPERTY);
       return this;
    }

    public AttendanceRequest<T> groupByCheckOutWithFunction(String retName, AggrFunction function){
       groupBy(retName, Attendance.CHECK_OUT_PROPERTY, function);
       return this;
    }
    public AttendanceRequest<T> groupByEmployeeWith(EmployeeRequest subRequest){
       groupBy(Attendance.EMPLOYEE_PROPERTY, subRequest);
       return this;
    }
    public AttendanceRequest<T> groupByEmployee(){
       groupBy(Attendance.EMPLOYEE_PROPERTY);
       return this;
    }

    public AttendanceRequest<T> groupByEmployeeAs(String retName){
       groupBy(retName, Attendance.EMPLOYEE_PROPERTY);
       return this;
    }

    public AttendanceRequest<T> groupByEmployeeWithFunction(String retName, AggrFunction function){
       groupBy(retName, Attendance.EMPLOYEE_PROPERTY, function);
       return this;
    }

    public AttendanceRequest<T> groupByHoursWorked(){
       groupBy(Attendance.HOURS_WORKED_PROPERTY);
       return this;
    }

    public AttendanceRequest<T> groupByHoursWorkedAs(String retName){
       groupBy(retName, Attendance.HOURS_WORKED_PROPERTY);
       return this;
    }

    public AttendanceRequest<T> groupByHoursWorkedWithFunction(String retName, AggrFunction function){
       groupBy(retName, Attendance.HOURS_WORKED_PROPERTY, function);
       return this;
    }

    public AttendanceRequest<T> groupByCreateTime(){
       groupBy(Attendance.CREATE_TIME_PROPERTY);
       return this;
    }

    public AttendanceRequest<T> groupByCreateTimeAs(String retName){
       groupBy(retName, Attendance.CREATE_TIME_PROPERTY);
       return this;
    }

    public AttendanceRequest<T> groupByCreateTimeWithFunction(String retName, AggrFunction function){
       groupBy(retName, Attendance.CREATE_TIME_PROPERTY, function);
       return this;
    }

    public AttendanceRequest<T> groupByUpdateTime(){
       groupBy(Attendance.UPDATE_TIME_PROPERTY);
       return this;
    }

    public AttendanceRequest<T> groupByUpdateTimeAs(String retName){
       groupBy(retName, Attendance.UPDATE_TIME_PROPERTY);
       return this;
    }

    public AttendanceRequest<T> groupByUpdateTimeWithFunction(String retName, AggrFunction function){
       groupBy(retName, Attendance.UPDATE_TIME_PROPERTY, function);
       return this;
    }

    public AttendanceRequest<T> groupByVersion(){
       groupBy(Attendance.VERSION_PROPERTY);
       return this;
    }

    public AttendanceRequest<T> groupByVersionAs(String retName){
       groupBy(retName, Attendance.VERSION_PROPERTY);
       return this;
    }

    public AttendanceRequest<T> groupByVersionWithFunction(String retName, AggrFunction function){
       groupBy(retName, Attendance.VERSION_PROPERTY, function);
       return this;
    }



    public AttendanceRequest<T> orderByIdAscending(){
       addOrderByAscending(Attendance.ID_PROPERTY);
       return this;
    }

    public AttendanceRequest<T> orderByIdDescending(){
       addOrderByDescending(Attendance.ID_PROPERTY);
       return this;
    }

    public AttendanceRequest<T> orderByCheckInAscending(){
       addOrderByAscending(Attendance.CHECK_IN_PROPERTY);
       return this;
    }

    public AttendanceRequest<T> orderByCheckInDescending(){
       addOrderByDescending(Attendance.CHECK_IN_PROPERTY);
       return this;
    }

    public AttendanceRequest<T> orderByCheckOutAscending(){
       addOrderByAscending(Attendance.CHECK_OUT_PROPERTY);
       return this;
    }

    public AttendanceRequest<T> orderByCheckOutDescending(){
       addOrderByDescending(Attendance.CHECK_OUT_PROPERTY);
       return this;
    }

    public AttendanceRequest<T> orderByEmployeeAscending(){
       addOrderByAscending(Attendance.EMPLOYEE_PROPERTY);
       return this;
    }

    public AttendanceRequest<T> orderByEmployeeDescending(){
       addOrderByDescending(Attendance.EMPLOYEE_PROPERTY);
       return this;
    }

    public AttendanceRequest<T> orderByHoursWorkedAscending(){
       addOrderByAscending(Attendance.HOURS_WORKED_PROPERTY);
       return this;
    }

    public AttendanceRequest<T> orderByHoursWorkedDescending(){
       addOrderByDescending(Attendance.HOURS_WORKED_PROPERTY);
       return this;
    }

    public AttendanceRequest<T> orderByCreateTimeAscending(){
       addOrderByAscending(Attendance.CREATE_TIME_PROPERTY);
       return this;
    }

    public AttendanceRequest<T> orderByCreateTimeDescending(){
       addOrderByDescending(Attendance.CREATE_TIME_PROPERTY);
       return this;
    }

    public AttendanceRequest<T> orderByUpdateTimeAscending(){
       addOrderByAscending(Attendance.UPDATE_TIME_PROPERTY);
       return this;
    }

    public AttendanceRequest<T> orderByUpdateTimeDescending(){
       addOrderByDescending(Attendance.UPDATE_TIME_PROPERTY);
       return this;
    }

    public AttendanceRequest<T> orderByVersionAscending(){
       addOrderByAscending(Attendance.VERSION_PROPERTY);
       return this;
    }

    public AttendanceRequest<T> orderByVersionDescending(){
       addOrderByDescending(Attendance.VERSION_PROPERTY);
       return this;
    }


    public EmployeeRequest rollUpToEmployee(){
       EmployeeRequest employee = Q.employees().unlimited();
       this.withEmployeeMatching(employee)
           .groupByEmployeeWith(employee);
       return employee;
    }






   public AttendanceRequest<T> facetByEmployeeAs(String facetName, EmployeeRequest employee){
       return facetByEmployeeAs(facetName, employee, true);
   }

   public AttendanceRequest<T> facetByEmployeeAs(String facetName, EmployeeRequest employee, boolean includeAllFacets){
       addFacet(facetName, Attendance.EMPLOYEE_PROPERTY, employee, includeAllFacets);
       return this;
   }


    /**
     * get topN records
     * @param topN  records number
     */
    public AttendanceRequest<T> top(int topN) {
        super.top(topN);
        return this;
    }

    /**
     * get records from offset(inclusive) to offset+size(exclusive)
     * @param offset record offset
     * @param size records number
     */
    public AttendanceRequest<T> offset(int offset, int size) {
        super.offset(offset, size);
        return this;
    }

    /**
     * retrieve all records
     */
    public AttendanceRequest<T> unlimited() {
        super.unlimited();
        return this;
    }

    /**
     * get records of one page
     * @param pageNumber page number(1-based)
     * @param pageSize page size
     */
    public AttendanceRequest<T> page(int pageNumber, int pageSize) {
        int offset = (pageNumber - 1) * pageSize;
        return offset(offset, pageSize);
   }

    /**
     * get records of one page, default page size is 10
     * @param pageNumber page number(1-based)
     */
    public AttendanceRequest<T> page(int pageNumber) {
        return page(pageNumber, 10);
   }
}