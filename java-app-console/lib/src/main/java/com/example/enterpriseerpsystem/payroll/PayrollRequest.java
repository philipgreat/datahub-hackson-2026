
package com.example.enterpriseerpsystem.payroll;

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

public class PayrollRequest<T extends Payroll> extends BaseRequest<T> {

    /**
     * @deprecated AI agents and business code must use the generated Q facade
     *             instead of constructing request builders directly.
     */
    @Deprecated
    public PayrollRequest(Class<T> returnType){
        super(returnType);
        selectId();
        selectVersion();
    }

    public PayrollRequest<T> comment(String comment){
         super.internalComment(comment);
         return this;
    }

    // purpose() 继承自 BaseRequest，返回 ExecutableRequest（终结方法）

    public PayrollRequest<T> returnType(Class<? extends T> returnType){
        super.setReturnType(returnType);
        return this;
    }

    public PayrollRequest<T> enableAggregationCache(long cacheExpiredMillis){
        super.enableAggregationCache();
        super.aggregateCacheTime(cacheExpiredMillis);
        return this;
    }

    public PayrollRequest<T> enableAggregationCache(){
        return enableAggregationCache(0l);
    }


    public PayrollRequest<T> propagateAggregationCache(long cacheExpiredMillis){
        super.propagateAggregationCache(cacheExpiredMillis);
        return this;
    }

    public PayrollRequest<T> appendSearchCriteria(SearchCriteria searchCriteria){
        return (PayrollRequest<T>)super.appendSearchCriteria(searchCriteria);
    }

    public PayrollRequest<T> filter(String property1, Operator operator, String property2){
        return appendSearchCriteria(new TwoOperatorCriteria(operator, new PropertyReference(property1), new PropertyReference(property2)));
    }


    public PayrollRequest<T> matchingAnyOf(PayrollRequest payroll){
        super.internalMatchAny(payroll);
        return this;
    }

    public PayrollRequest<T> enhanceChildrenIfNeeded(){
        return this;
    }

    public PayrollRequest<T> withDeletedRows(){
        super.withDeletedRows();
        return this;
    }

    public PayrollRequest<T> deletedRowsOnly(){
        super.deletedRowsOnly();
        return this;
    }

    public PayrollRequest<T> selectSelf(){
        super.selectSelf();
        return selectId().selectTax().selectEmployeeIdOnly().selectGrossPay().selectNetPay().selectPeriodEnd().selectPeriodStart().selectCreateTime().selectUpdateTime().selectVersion();
    }

    public PayrollRequest<T> selectSelfFields(){
        return selectSelf();
    }

    public PayrollRequest<T> selectAll(){
        super.selectAll();
        return selectId().selectTax().selectEmployee().selectGrossPay().selectNetPay().selectPeriodEnd().selectPeriodStart().selectCreateTime().selectUpdateTime().selectVersion();
    }

    public PayrollRequest<T> selectChildren(){
        super.selectAny();
        return selectId().selectTax().selectEmployee().selectGrossPay().selectNetPay().selectPeriodEnd().selectPeriodStart().selectCreateTime().selectUpdateTime().selectVersion();
    }


    public PayrollRequest<T> selectId(){
       selectProperty(Payroll.ID_PROPERTY);
       return this;
    }

    /**
     * fill the id with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  id) to fetch id property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public PayrollRequest<T> unselectId(){
       unselectProperty(Payroll.ID_PROPERTY);
       return this;
    }
    public PayrollRequest<T> selectTax(){
       selectProperty(Payroll.TAX_PROPERTY);
       return this;
    }

    /**
     * fill the tax with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  tax) to fetch tax property.
     * @param rawSqlSegment  customized rawSqlSegment
     */


    /**
     * fill the tax with customized aggrFunction, TEAQL uses ({aggrFunction}(tax) AS tax to fetch tax property.
     * @param aggrFunction  aggrFunction
     */
    public PayrollRequest<T> selectTax(AggrFunction aggrFunction){
       selectProperty(Payroll.TAX_PROPERTY, aggrFunction);
       return this;
    }


    public PayrollRequest<T> unselectTax(){
       unselectProperty(Payroll.TAX_PROPERTY);
       return this;
    }
    public PayrollRequest<T> selectEmployeeIdOnly(){
       selectProperty(Payroll.EMPLOYEE_PROPERTY);
       return this;
    }

    public PayrollRequest<T> selectEmployee(){
        return selectEmployeeWith(Q.employees().unlimited().selectSelf());
    }

    public PayrollRequest<T> selectEmployeeWith(EmployeeRequest employee){
       selectProperty(Payroll.EMPLOYEE_PROPERTY);
       enhanceRelation(Payroll.EMPLOYEE_PROPERTY, employee);
       return this;
    }

    public PayrollRequest<T> unselectEmployee(){
       unselectProperty(Payroll.EMPLOYEE_PROPERTY);
       return this;
    }
    public PayrollRequest<T> selectGrossPay(){
       selectProperty(Payroll.GROSS_PAY_PROPERTY);
       return this;
    }

    /**
     * fill the grossPay with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  grossPay) to fetch grossPay property.
     * @param rawSqlSegment  customized rawSqlSegment
     */


    /**
     * fill the grossPay with customized aggrFunction, TEAQL uses ({aggrFunction}(grossPay) AS grossPay to fetch grossPay property.
     * @param aggrFunction  aggrFunction
     */
    public PayrollRequest<T> selectGrossPay(AggrFunction aggrFunction){
       selectProperty(Payroll.GROSS_PAY_PROPERTY, aggrFunction);
       return this;
    }


    public PayrollRequest<T> unselectGrossPay(){
       unselectProperty(Payroll.GROSS_PAY_PROPERTY);
       return this;
    }
    public PayrollRequest<T> selectNetPay(){
       selectProperty(Payroll.NET_PAY_PROPERTY);
       return this;
    }

    /**
     * fill the netPay with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  netPay) to fetch netPay property.
     * @param rawSqlSegment  customized rawSqlSegment
     */


    /**
     * fill the netPay with customized aggrFunction, TEAQL uses ({aggrFunction}(netPay) AS netPay to fetch netPay property.
     * @param aggrFunction  aggrFunction
     */
    public PayrollRequest<T> selectNetPay(AggrFunction aggrFunction){
       selectProperty(Payroll.NET_PAY_PROPERTY, aggrFunction);
       return this;
    }


    public PayrollRequest<T> unselectNetPay(){
       unselectProperty(Payroll.NET_PAY_PROPERTY);
       return this;
    }
    public PayrollRequest<T> selectPeriodEnd(){
       selectProperty(Payroll.PERIOD_END_PROPERTY);
       return this;
    }

    /**
     * fill the periodEnd with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  periodEnd) to fetch periodEnd property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public PayrollRequest<T> unselectPeriodEnd(){
       unselectProperty(Payroll.PERIOD_END_PROPERTY);
       return this;
    }
    public PayrollRequest<T> selectPeriodStart(){
       selectProperty(Payroll.PERIOD_START_PROPERTY);
       return this;
    }

    /**
     * fill the periodStart with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  periodStart) to fetch periodStart property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public PayrollRequest<T> unselectPeriodStart(){
       unselectProperty(Payroll.PERIOD_START_PROPERTY);
       return this;
    }
    public PayrollRequest<T> selectCreateTime(){
       selectProperty(Payroll.CREATE_TIME_PROPERTY);
       return this;
    }

    /**
     * fill the createTime with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  createTime) to fetch createTime property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public PayrollRequest<T> unselectCreateTime(){
       unselectProperty(Payroll.CREATE_TIME_PROPERTY);
       return this;
    }
    public PayrollRequest<T> selectUpdateTime(){
       selectProperty(Payroll.UPDATE_TIME_PROPERTY);
       return this;
    }

    /**
     * fill the updateTime with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  updateTime) to fetch updateTime property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public PayrollRequest<T> unselectUpdateTime(){
       unselectProperty(Payroll.UPDATE_TIME_PROPERTY);
       return this;
    }
    public PayrollRequest<T> selectVersion(){
       selectProperty(Payroll.VERSION_PROPERTY);
       return this;
    }

    /**
     * fill the version with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  version) to fetch version property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public PayrollRequest<T> unselectVersion(){
       unselectProperty(Payroll.VERSION_PROPERTY);
       return this;
    }

    public PayrollRequest<T> withId(Operator operator, Object... values){
       return appendSearchCriteria(createIdCriteria(operator, values));
    }

    public SearchCriteria createIdCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Payroll.ID_PROPERTY, operator, values);
    }

    public PayrollRequest<T> withIdIs(Long id){
       return withId(Operator.EQUAL, id);
    }
    public PayrollRequest<T> withIdIn(Long... id){
       return withId(Operator.EQUAL, (Object[])id);
    }



    public PayrollRequest<T> filterByTax(BigDecimal... tax){
      if (tax == null || tax.length == 0) {
        throw new IllegalArgumentException("filterByTax parameter tax cannot be empty");
      }
      return appendSearchCriteria(createTaxCriteria(Operator.EQUAL, (Object[])tax));
    }

    public PayrollRequest<T> withTax(Operator operator, Object... values){
       return appendSearchCriteria(createTaxCriteria(operator, values));
    }

    public PayrollRequest<T> withTaxIsUnknown(){
       return withTax(Operator.IS_NULL);
    }

    public PayrollRequest<T> withTaxIsKnown(){
       return withTax(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createTaxCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Payroll.TAX_PROPERTY, operator, values);
    }

    public PayrollRequest<T> withTaxGreaterThan(BigDecimal tax){
       return withTax(Operator.GREATER_THAN, tax);
    }

    public PayrollRequest<T> withTaxGreaterThanOrEqualTo(BigDecimal tax){
       return withTax(Operator.GREATER_THAN_OR_EQUAL, tax);
    }

    public PayrollRequest<T> withTaxLessThan(BigDecimal tax){
       return withTax(Operator.LESS_THAN, tax);
    }

    public PayrollRequest<T> withTaxLessThanOrEqualTo(BigDecimal tax){
       return withTax(Operator.LESS_THAN_OR_EQUAL, tax);
    }

    public PayrollRequest<T> withTaxBetween(BigDecimal startOfTax, BigDecimal endOfTax){
       return withTax(Operator.BETWEEN, startOfTax, endOfTax);
    }



    public PayrollRequest<T> filterByEmployee(Employee... employee){
      if (employee == null || employee.length == 0) {
        throw new IllegalArgumentException("filterByEmployee parameter employee cannot be empty");
      }
      return appendSearchCriteria(createEmployeeCriteria(Operator.EQUAL, (Object[])employee));
    }

    public PayrollRequest<T> withEmployee(Operator operator, Object... values){
       return appendSearchCriteria(createEmployeeCriteria(operator, values));
    }

    public PayrollRequest<T> withEmployeeIsUnknown(){
       return withEmployee(Operator.IS_NULL);
    }

    public PayrollRequest<T> withEmployeeIsKnown(){
       return withEmployee(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createEmployeeCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Payroll.EMPLOYEE_PROPERTY, operator, values);
    }

    public PayrollRequest<T> filterByEmployee(Long employee){
      if(employee == null){
         return this;
      }
      return withEmployee(Operator.EQUAL, employee);
    }
    public PayrollRequest<T> withEmployeeMatching(EmployeeRequest employee){
       return appendSearchCriteria(new SubQuerySearchCriteria(Payroll.EMPLOYEE_PROPERTY, employee, Employee.ID_PROPERTY));
    }

    public PayrollRequest<T> filterByGrossPay(BigDecimal... grossPay){
      if (grossPay == null || grossPay.length == 0) {
        throw new IllegalArgumentException("filterByGrossPay parameter grossPay cannot be empty");
      }
      return appendSearchCriteria(createGrossPayCriteria(Operator.EQUAL, (Object[])grossPay));
    }

    public PayrollRequest<T> withGrossPay(Operator operator, Object... values){
       return appendSearchCriteria(createGrossPayCriteria(operator, values));
    }

    public PayrollRequest<T> withGrossPayIsUnknown(){
       return withGrossPay(Operator.IS_NULL);
    }

    public PayrollRequest<T> withGrossPayIsKnown(){
       return withGrossPay(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createGrossPayCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Payroll.GROSS_PAY_PROPERTY, operator, values);
    }

    public PayrollRequest<T> withGrossPayGreaterThan(BigDecimal grossPay){
       return withGrossPay(Operator.GREATER_THAN, grossPay);
    }

    public PayrollRequest<T> withGrossPayGreaterThanOrEqualTo(BigDecimal grossPay){
       return withGrossPay(Operator.GREATER_THAN_OR_EQUAL, grossPay);
    }

    public PayrollRequest<T> withGrossPayLessThan(BigDecimal grossPay){
       return withGrossPay(Operator.LESS_THAN, grossPay);
    }

    public PayrollRequest<T> withGrossPayLessThanOrEqualTo(BigDecimal grossPay){
       return withGrossPay(Operator.LESS_THAN_OR_EQUAL, grossPay);
    }

    public PayrollRequest<T> withGrossPayBetween(BigDecimal startOfGrossPay, BigDecimal endOfGrossPay){
       return withGrossPay(Operator.BETWEEN, startOfGrossPay, endOfGrossPay);
    }



    public PayrollRequest<T> filterByNetPay(BigDecimal... netPay){
      if (netPay == null || netPay.length == 0) {
        throw new IllegalArgumentException("filterByNetPay parameter netPay cannot be empty");
      }
      return appendSearchCriteria(createNetPayCriteria(Operator.EQUAL, (Object[])netPay));
    }

    public PayrollRequest<T> withNetPay(Operator operator, Object... values){
       return appendSearchCriteria(createNetPayCriteria(operator, values));
    }

    public PayrollRequest<T> withNetPayIsUnknown(){
       return withNetPay(Operator.IS_NULL);
    }

    public PayrollRequest<T> withNetPayIsKnown(){
       return withNetPay(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createNetPayCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Payroll.NET_PAY_PROPERTY, operator, values);
    }

    public PayrollRequest<T> withNetPayGreaterThan(BigDecimal netPay){
       return withNetPay(Operator.GREATER_THAN, netPay);
    }

    public PayrollRequest<T> withNetPayGreaterThanOrEqualTo(BigDecimal netPay){
       return withNetPay(Operator.GREATER_THAN_OR_EQUAL, netPay);
    }

    public PayrollRequest<T> withNetPayLessThan(BigDecimal netPay){
       return withNetPay(Operator.LESS_THAN, netPay);
    }

    public PayrollRequest<T> withNetPayLessThanOrEqualTo(BigDecimal netPay){
       return withNetPay(Operator.LESS_THAN_OR_EQUAL, netPay);
    }

    public PayrollRequest<T> withNetPayBetween(BigDecimal startOfNetPay, BigDecimal endOfNetPay){
       return withNetPay(Operator.BETWEEN, startOfNetPay, endOfNetPay);
    }



    public PayrollRequest<T> filterByPeriodEnd(LocalDateTime... periodEnd){
      if (periodEnd == null || periodEnd.length == 0) {
        throw new IllegalArgumentException("filterByPeriodEnd parameter periodEnd cannot be empty");
      }
      return appendSearchCriteria(createPeriodEndCriteria(Operator.EQUAL, (Object[])periodEnd));
    }

    public PayrollRequest<T> withPeriodEnd(Operator operator, Object... values){
       return appendSearchCriteria(createPeriodEndCriteria(operator, values));
    }

    public PayrollRequest<T> withPeriodEndIsUnknown(){
       return withPeriodEnd(Operator.IS_NULL);
    }

    public PayrollRequest<T> withPeriodEndIsKnown(){
       return withPeriodEnd(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createPeriodEndCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Payroll.PERIOD_END_PROPERTY, operator, values);
    }

    public PayrollRequest<T> withPeriodEndGreaterThan(LocalDateTime periodEnd){
       return withPeriodEnd(Operator.GREATER_THAN, periodEnd);
    }

    public PayrollRequest<T> withPeriodEndGreaterThanOrEqualTo(LocalDateTime periodEnd){
       return withPeriodEnd(Operator.GREATER_THAN_OR_EQUAL, periodEnd);
    }

    public PayrollRequest<T> withPeriodEndLessThan(LocalDateTime periodEnd){
       return withPeriodEnd(Operator.LESS_THAN, periodEnd);
    }

    public PayrollRequest<T> withPeriodEndLessThanOrEqualTo(LocalDateTime periodEnd){
       return withPeriodEnd(Operator.LESS_THAN_OR_EQUAL, periodEnd);
    }

    public PayrollRequest<T> withPeriodEndBetween(LocalDateTime startOfPeriodEnd, LocalDateTime endOfPeriodEnd){
       return withPeriodEnd(Operator.BETWEEN, startOfPeriodEnd, endOfPeriodEnd);
    }
    public PayrollRequest<T> withPeriodEndBefore(LocalDateTime periodEnd){
       return withPeriodEnd(Operator.LESS_THAN, periodEnd);
    }

    public PayrollRequest<T> withPeriodEndBefore(Date periodEnd){
       return withPeriodEnd(Operator.LESS_THAN, periodEnd);
    }

    public PayrollRequest<T> withPeriodEndAfter(LocalDateTime periodEnd){
       return withPeriodEnd(Operator.GREATER_THAN, periodEnd);
    }

    public PayrollRequest<T> withPeriodEndAfter(Date periodEnd){
       return withPeriodEnd(Operator.GREATER_THAN, periodEnd);
    }

    public PayrollRequest<T> withPeriodEndBetween(Date startOfPeriodEnd, Date endOfPeriodEnd){
       return withPeriodEnd(Operator.BETWEEN, startOfPeriodEnd, endOfPeriodEnd);
    }




    public PayrollRequest<T> filterByPeriodStart(LocalDateTime... periodStart){
      if (periodStart == null || periodStart.length == 0) {
        throw new IllegalArgumentException("filterByPeriodStart parameter periodStart cannot be empty");
      }
      return appendSearchCriteria(createPeriodStartCriteria(Operator.EQUAL, (Object[])periodStart));
    }

    public PayrollRequest<T> withPeriodStart(Operator operator, Object... values){
       return appendSearchCriteria(createPeriodStartCriteria(operator, values));
    }

    public PayrollRequest<T> withPeriodStartIsUnknown(){
       return withPeriodStart(Operator.IS_NULL);
    }

    public PayrollRequest<T> withPeriodStartIsKnown(){
       return withPeriodStart(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createPeriodStartCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Payroll.PERIOD_START_PROPERTY, operator, values);
    }

    public PayrollRequest<T> withPeriodStartGreaterThan(LocalDateTime periodStart){
       return withPeriodStart(Operator.GREATER_THAN, periodStart);
    }

    public PayrollRequest<T> withPeriodStartGreaterThanOrEqualTo(LocalDateTime periodStart){
       return withPeriodStart(Operator.GREATER_THAN_OR_EQUAL, periodStart);
    }

    public PayrollRequest<T> withPeriodStartLessThan(LocalDateTime periodStart){
       return withPeriodStart(Operator.LESS_THAN, periodStart);
    }

    public PayrollRequest<T> withPeriodStartLessThanOrEqualTo(LocalDateTime periodStart){
       return withPeriodStart(Operator.LESS_THAN_OR_EQUAL, periodStart);
    }

    public PayrollRequest<T> withPeriodStartBetween(LocalDateTime startOfPeriodStart, LocalDateTime endOfPeriodStart){
       return withPeriodStart(Operator.BETWEEN, startOfPeriodStart, endOfPeriodStart);
    }
    public PayrollRequest<T> withPeriodStartBefore(LocalDateTime periodStart){
       return withPeriodStart(Operator.LESS_THAN, periodStart);
    }

    public PayrollRequest<T> withPeriodStartBefore(Date periodStart){
       return withPeriodStart(Operator.LESS_THAN, periodStart);
    }

    public PayrollRequest<T> withPeriodStartAfter(LocalDateTime periodStart){
       return withPeriodStart(Operator.GREATER_THAN, periodStart);
    }

    public PayrollRequest<T> withPeriodStartAfter(Date periodStart){
       return withPeriodStart(Operator.GREATER_THAN, periodStart);
    }

    public PayrollRequest<T> withPeriodStartBetween(Date startOfPeriodStart, Date endOfPeriodStart){
       return withPeriodStart(Operator.BETWEEN, startOfPeriodStart, endOfPeriodStart);
    }




    public PayrollRequest<T> filterByCreateTime(LocalDateTime... createTime){
      if (createTime == null || createTime.length == 0) {
        throw new IllegalArgumentException("filterByCreateTime parameter createTime cannot be empty");
      }
      return appendSearchCriteria(createCreateTimeCriteria(Operator.EQUAL, (Object[])createTime));
    }

    public PayrollRequest<T> withCreateTime(Operator operator, Object... values){
       return appendSearchCriteria(createCreateTimeCriteria(operator, values));
    }

    public PayrollRequest<T> withCreateTimeIsUnknown(){
       return withCreateTime(Operator.IS_NULL);
    }

    public PayrollRequest<T> withCreateTimeIsKnown(){
       return withCreateTime(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createCreateTimeCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Payroll.CREATE_TIME_PROPERTY, operator, values);
    }

    public PayrollRequest<T> withCreateTimeGreaterThan(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public PayrollRequest<T> withCreateTimeGreaterThanOrEqualTo(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN_OR_EQUAL, createTime);
    }

    public PayrollRequest<T> withCreateTimeLessThan(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public PayrollRequest<T> withCreateTimeLessThanOrEqualTo(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN_OR_EQUAL, createTime);
    }

    public PayrollRequest<T> withCreateTimeBetween(LocalDateTime startOfCreateTime, LocalDateTime endOfCreateTime){
       return withCreateTime(Operator.BETWEEN, startOfCreateTime, endOfCreateTime);
    }
    public PayrollRequest<T> withCreateTimeBefore(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public PayrollRequest<T> withCreateTimeBefore(Date createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public PayrollRequest<T> withCreateTimeAfter(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public PayrollRequest<T> withCreateTimeAfter(Date createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public PayrollRequest<T> withCreateTimeBetween(Date startOfCreateTime, Date endOfCreateTime){
       return withCreateTime(Operator.BETWEEN, startOfCreateTime, endOfCreateTime);
    }




    public PayrollRequest<T> filterByUpdateTime(LocalDateTime... updateTime){
      if (updateTime == null || updateTime.length == 0) {
        throw new IllegalArgumentException("filterByUpdateTime parameter updateTime cannot be empty");
      }
      return appendSearchCriteria(createUpdateTimeCriteria(Operator.EQUAL, (Object[])updateTime));
    }

    public PayrollRequest<T> withUpdateTime(Operator operator, Object... values){
       return appendSearchCriteria(createUpdateTimeCriteria(operator, values));
    }

    public PayrollRequest<T> withUpdateTimeIsUnknown(){
       return withUpdateTime(Operator.IS_NULL);
    }

    public PayrollRequest<T> withUpdateTimeIsKnown(){
       return withUpdateTime(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createUpdateTimeCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Payroll.UPDATE_TIME_PROPERTY, operator, values);
    }

    public PayrollRequest<T> withUpdateTimeGreaterThan(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public PayrollRequest<T> withUpdateTimeGreaterThanOrEqualTo(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN_OR_EQUAL, updateTime);
    }

    public PayrollRequest<T> withUpdateTimeLessThan(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public PayrollRequest<T> withUpdateTimeLessThanOrEqualTo(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN_OR_EQUAL, updateTime);
    }

    public PayrollRequest<T> withUpdateTimeBetween(LocalDateTime startOfUpdateTime, LocalDateTime endOfUpdateTime){
       return withUpdateTime(Operator.BETWEEN, startOfUpdateTime, endOfUpdateTime);
    }
    public PayrollRequest<T> withUpdateTimeBefore(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public PayrollRequest<T> withUpdateTimeBefore(Date updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public PayrollRequest<T> withUpdateTimeAfter(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public PayrollRequest<T> withUpdateTimeAfter(Date updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public PayrollRequest<T> withUpdateTimeBetween(Date startOfUpdateTime, Date endOfUpdateTime){
       return withUpdateTime(Operator.BETWEEN, startOfUpdateTime, endOfUpdateTime);
    }




    public PayrollRequest<T> filterByVersion(Long... version){
      if (version == null || version.length == 0) {
        throw new IllegalArgumentException("filterByVersion parameter version cannot be empty");
      }
      return appendSearchCriteria(createVersionCriteria(Operator.EQUAL, (Object[])version));
    }

    public PayrollRequest<T> withVersion(Operator operator, Object... values){
       return appendSearchCriteria(createVersionCriteria(operator, values));
    }

    public PayrollRequest<T> withVersionIsUnknown(){
       return withVersion(Operator.IS_NULL);
    }

    public PayrollRequest<T> withVersionIsKnown(){
       return withVersion(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createVersionCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Payroll.VERSION_PROPERTY, operator, values);
    }

    public PayrollRequest<T> withVersionGreaterThan(Long version){
       return withVersion(Operator.GREATER_THAN, version);
    }

    public PayrollRequest<T> withVersionGreaterThanOrEqualTo(Long version){
       return withVersion(Operator.GREATER_THAN_OR_EQUAL, version);
    }

    public PayrollRequest<T> withVersionLessThan(Long version){
       return withVersion(Operator.LESS_THAN, version);
    }

    public PayrollRequest<T> withVersionLessThanOrEqualTo(Long version){
       return withVersion(Operator.LESS_THAN_OR_EQUAL, version);
    }

    public PayrollRequest<T> withVersionBetween(Long startOfVersion, Long endOfVersion){
       return withVersion(Operator.BETWEEN, startOfVersion, endOfVersion);
    }


    public PayrollRequest<T> count(){
        super.count();
        return this;
    }
    public PayrollRequest<T> countAs(String retName){
        super.count(retName);
        return this;
    }
    public PayrollRequest minTax(){
        return minTaxAs(prefix("minOf",Payroll.TAX_PROPERTY));
    }

    public PayrollRequest minTaxAs(String retName){
        super.min(retName, Payroll.TAX_PROPERTY);
        return this;
    }
    public PayrollRequest maxTax(){
        return maxTaxAs(prefix("maxOf",Payroll.TAX_PROPERTY));
    }

    public PayrollRequest maxTaxAs(String retName){
        super.max(retName, Payroll.TAX_PROPERTY);
        return this;
    }
    public PayrollRequest sumTax(){
        return sumTaxAs(prefix("sumOf",Payroll.TAX_PROPERTY));
    }

    public PayrollRequest sumTaxAs(String retName){
        super.sum(retName, Payroll.TAX_PROPERTY);
        return this;
    }
    public PayrollRequest avgTax(){
        return avgTaxAs(prefix("avgOf",Payroll.TAX_PROPERTY));
    }

    public PayrollRequest avgTaxAs(String retName){
        super.avg(retName, Payroll.TAX_PROPERTY);
        return this;
    }
    public PayrollRequest standardDeviationTax(){
        return standardDeviationTaxAs(prefix("standardDeviationOf",Payroll.TAX_PROPERTY));
    }

    public PayrollRequest standardDeviationTaxAs(String retName){
        super.standardDeviation(retName, Payroll.TAX_PROPERTY);
        return this;
    }
    public PayrollRequest squareRootOfPopulationStandardDeviationTax(){
        return squareRootOfPopulationStandardDeviationTaxAs(prefix("squareRootOfPopulationStandardDeviationOf",Payroll.TAX_PROPERTY));
    }

    public PayrollRequest squareRootOfPopulationStandardDeviationTaxAs(String retName){
        super.squareRootOfPopulationStandardDeviation(retName, Payroll.TAX_PROPERTY);
        return this;
    }
    public PayrollRequest sampleVarianceTax(){
        return sampleVarianceTaxAs(prefix("sampleVarianceOf",Payroll.TAX_PROPERTY));
    }

    public PayrollRequest sampleVarianceTaxAs(String retName){
        super.sampleVariance(retName, Payroll.TAX_PROPERTY);
        return this;
    }
    public PayrollRequest samplePopulationVarianceTax(){
        return samplePopulationVarianceTaxAs(prefix("samplePopulationVarianceOf",Payroll.TAX_PROPERTY));
    }

    public PayrollRequest samplePopulationVarianceTaxAs(String retName){
        super.samplePopulationVariance(retName, Payroll.TAX_PROPERTY);
        return this;
    }
    public PayrollRequest minGrossPay(){
        return minGrossPayAs(prefix("minOf",Payroll.GROSS_PAY_PROPERTY));
    }

    public PayrollRequest minGrossPayAs(String retName){
        super.min(retName, Payroll.GROSS_PAY_PROPERTY);
        return this;
    }
    public PayrollRequest maxGrossPay(){
        return maxGrossPayAs(prefix("maxOf",Payroll.GROSS_PAY_PROPERTY));
    }

    public PayrollRequest maxGrossPayAs(String retName){
        super.max(retName, Payroll.GROSS_PAY_PROPERTY);
        return this;
    }
    public PayrollRequest sumGrossPay(){
        return sumGrossPayAs(prefix("sumOf",Payroll.GROSS_PAY_PROPERTY));
    }

    public PayrollRequest sumGrossPayAs(String retName){
        super.sum(retName, Payroll.GROSS_PAY_PROPERTY);
        return this;
    }
    public PayrollRequest avgGrossPay(){
        return avgGrossPayAs(prefix("avgOf",Payroll.GROSS_PAY_PROPERTY));
    }

    public PayrollRequest avgGrossPayAs(String retName){
        super.avg(retName, Payroll.GROSS_PAY_PROPERTY);
        return this;
    }
    public PayrollRequest standardDeviationGrossPay(){
        return standardDeviationGrossPayAs(prefix("standardDeviationOf",Payroll.GROSS_PAY_PROPERTY));
    }

    public PayrollRequest standardDeviationGrossPayAs(String retName){
        super.standardDeviation(retName, Payroll.GROSS_PAY_PROPERTY);
        return this;
    }
    public PayrollRequest squareRootOfPopulationStandardDeviationGrossPay(){
        return squareRootOfPopulationStandardDeviationGrossPayAs(prefix("squareRootOfPopulationStandardDeviationOf",Payroll.GROSS_PAY_PROPERTY));
    }

    public PayrollRequest squareRootOfPopulationStandardDeviationGrossPayAs(String retName){
        super.squareRootOfPopulationStandardDeviation(retName, Payroll.GROSS_PAY_PROPERTY);
        return this;
    }
    public PayrollRequest sampleVarianceGrossPay(){
        return sampleVarianceGrossPayAs(prefix("sampleVarianceOf",Payroll.GROSS_PAY_PROPERTY));
    }

    public PayrollRequest sampleVarianceGrossPayAs(String retName){
        super.sampleVariance(retName, Payroll.GROSS_PAY_PROPERTY);
        return this;
    }
    public PayrollRequest samplePopulationVarianceGrossPay(){
        return samplePopulationVarianceGrossPayAs(prefix("samplePopulationVarianceOf",Payroll.GROSS_PAY_PROPERTY));
    }

    public PayrollRequest samplePopulationVarianceGrossPayAs(String retName){
        super.samplePopulationVariance(retName, Payroll.GROSS_PAY_PROPERTY);
        return this;
    }
    public PayrollRequest minNetPay(){
        return minNetPayAs(prefix("minOf",Payroll.NET_PAY_PROPERTY));
    }

    public PayrollRequest minNetPayAs(String retName){
        super.min(retName, Payroll.NET_PAY_PROPERTY);
        return this;
    }
    public PayrollRequest maxNetPay(){
        return maxNetPayAs(prefix("maxOf",Payroll.NET_PAY_PROPERTY));
    }

    public PayrollRequest maxNetPayAs(String retName){
        super.max(retName, Payroll.NET_PAY_PROPERTY);
        return this;
    }
    public PayrollRequest sumNetPay(){
        return sumNetPayAs(prefix("sumOf",Payroll.NET_PAY_PROPERTY));
    }

    public PayrollRequest sumNetPayAs(String retName){
        super.sum(retName, Payroll.NET_PAY_PROPERTY);
        return this;
    }
    public PayrollRequest avgNetPay(){
        return avgNetPayAs(prefix("avgOf",Payroll.NET_PAY_PROPERTY));
    }

    public PayrollRequest avgNetPayAs(String retName){
        super.avg(retName, Payroll.NET_PAY_PROPERTY);
        return this;
    }
    public PayrollRequest standardDeviationNetPay(){
        return standardDeviationNetPayAs(prefix("standardDeviationOf",Payroll.NET_PAY_PROPERTY));
    }

    public PayrollRequest standardDeviationNetPayAs(String retName){
        super.standardDeviation(retName, Payroll.NET_PAY_PROPERTY);
        return this;
    }
    public PayrollRequest squareRootOfPopulationStandardDeviationNetPay(){
        return squareRootOfPopulationStandardDeviationNetPayAs(prefix("squareRootOfPopulationStandardDeviationOf",Payroll.NET_PAY_PROPERTY));
    }

    public PayrollRequest squareRootOfPopulationStandardDeviationNetPayAs(String retName){
        super.squareRootOfPopulationStandardDeviation(retName, Payroll.NET_PAY_PROPERTY);
        return this;
    }
    public PayrollRequest sampleVarianceNetPay(){
        return sampleVarianceNetPayAs(prefix("sampleVarianceOf",Payroll.NET_PAY_PROPERTY));
    }

    public PayrollRequest sampleVarianceNetPayAs(String retName){
        super.sampleVariance(retName, Payroll.NET_PAY_PROPERTY);
        return this;
    }
    public PayrollRequest samplePopulationVarianceNetPay(){
        return samplePopulationVarianceNetPayAs(prefix("samplePopulationVarianceOf",Payroll.NET_PAY_PROPERTY));
    }

    public PayrollRequest samplePopulationVarianceNetPayAs(String retName){
        super.samplePopulationVariance(retName, Payroll.NET_PAY_PROPERTY);
        return this;
    }
    public PayrollRequest<T> groupByEmployeeWithDetails(){
       return groupByEmployeeWithDetails(Q.employees().unlimited());
    }

    public PayrollRequest<T> groupByEmployeeWithDetails(EmployeeRequest subRequest){
       aggregate(Payroll.EMPLOYEE_PROPERTY, subRequest);
       return this;
    }









    public PayrollRequest<T> groupById(){
       groupBy(Payroll.ID_PROPERTY);
       return this;
    }

    public PayrollRequest<T> groupByIdAs(String retName){
       groupBy(retName, Payroll.ID_PROPERTY);
       return this;
    }

    public PayrollRequest<T> groupByIdWithFunction(String retName, AggrFunction function){
       groupBy(retName, Payroll.ID_PROPERTY, function);
       return this;
    }

    public PayrollRequest<T> groupByTax(){
       groupBy(Payroll.TAX_PROPERTY);
       return this;
    }

    public PayrollRequest<T> groupByTaxAs(String retName){
       groupBy(retName, Payroll.TAX_PROPERTY);
       return this;
    }

    public PayrollRequest<T> groupByTaxWithFunction(String retName, AggrFunction function){
       groupBy(retName, Payroll.TAX_PROPERTY, function);
       return this;
    }
    public PayrollRequest<T> groupByEmployeeWith(EmployeeRequest subRequest){
       groupBy(Payroll.EMPLOYEE_PROPERTY, subRequest);
       return this;
    }
    public PayrollRequest<T> groupByEmployee(){
       groupBy(Payroll.EMPLOYEE_PROPERTY);
       return this;
    }

    public PayrollRequest<T> groupByEmployeeAs(String retName){
       groupBy(retName, Payroll.EMPLOYEE_PROPERTY);
       return this;
    }

    public PayrollRequest<T> groupByEmployeeWithFunction(String retName, AggrFunction function){
       groupBy(retName, Payroll.EMPLOYEE_PROPERTY, function);
       return this;
    }

    public PayrollRequest<T> groupByGrossPay(){
       groupBy(Payroll.GROSS_PAY_PROPERTY);
       return this;
    }

    public PayrollRequest<T> groupByGrossPayAs(String retName){
       groupBy(retName, Payroll.GROSS_PAY_PROPERTY);
       return this;
    }

    public PayrollRequest<T> groupByGrossPayWithFunction(String retName, AggrFunction function){
       groupBy(retName, Payroll.GROSS_PAY_PROPERTY, function);
       return this;
    }

    public PayrollRequest<T> groupByNetPay(){
       groupBy(Payroll.NET_PAY_PROPERTY);
       return this;
    }

    public PayrollRequest<T> groupByNetPayAs(String retName){
       groupBy(retName, Payroll.NET_PAY_PROPERTY);
       return this;
    }

    public PayrollRequest<T> groupByNetPayWithFunction(String retName, AggrFunction function){
       groupBy(retName, Payroll.NET_PAY_PROPERTY, function);
       return this;
    }

    public PayrollRequest<T> groupByPeriodEnd(){
       groupBy(Payroll.PERIOD_END_PROPERTY);
       return this;
    }

    public PayrollRequest<T> groupByPeriodEndAs(String retName){
       groupBy(retName, Payroll.PERIOD_END_PROPERTY);
       return this;
    }

    public PayrollRequest<T> groupByPeriodEndWithFunction(String retName, AggrFunction function){
       groupBy(retName, Payroll.PERIOD_END_PROPERTY, function);
       return this;
    }

    public PayrollRequest<T> groupByPeriodStart(){
       groupBy(Payroll.PERIOD_START_PROPERTY);
       return this;
    }

    public PayrollRequest<T> groupByPeriodStartAs(String retName){
       groupBy(retName, Payroll.PERIOD_START_PROPERTY);
       return this;
    }

    public PayrollRequest<T> groupByPeriodStartWithFunction(String retName, AggrFunction function){
       groupBy(retName, Payroll.PERIOD_START_PROPERTY, function);
       return this;
    }

    public PayrollRequest<T> groupByCreateTime(){
       groupBy(Payroll.CREATE_TIME_PROPERTY);
       return this;
    }

    public PayrollRequest<T> groupByCreateTimeAs(String retName){
       groupBy(retName, Payroll.CREATE_TIME_PROPERTY);
       return this;
    }

    public PayrollRequest<T> groupByCreateTimeWithFunction(String retName, AggrFunction function){
       groupBy(retName, Payroll.CREATE_TIME_PROPERTY, function);
       return this;
    }

    public PayrollRequest<T> groupByUpdateTime(){
       groupBy(Payroll.UPDATE_TIME_PROPERTY);
       return this;
    }

    public PayrollRequest<T> groupByUpdateTimeAs(String retName){
       groupBy(retName, Payroll.UPDATE_TIME_PROPERTY);
       return this;
    }

    public PayrollRequest<T> groupByUpdateTimeWithFunction(String retName, AggrFunction function){
       groupBy(retName, Payroll.UPDATE_TIME_PROPERTY, function);
       return this;
    }

    public PayrollRequest<T> groupByVersion(){
       groupBy(Payroll.VERSION_PROPERTY);
       return this;
    }

    public PayrollRequest<T> groupByVersionAs(String retName){
       groupBy(retName, Payroll.VERSION_PROPERTY);
       return this;
    }

    public PayrollRequest<T> groupByVersionWithFunction(String retName, AggrFunction function){
       groupBy(retName, Payroll.VERSION_PROPERTY, function);
       return this;
    }



    public PayrollRequest<T> orderByIdAscending(){
       addOrderByAscending(Payroll.ID_PROPERTY);
       return this;
    }

    public PayrollRequest<T> orderByIdDescending(){
       addOrderByDescending(Payroll.ID_PROPERTY);
       return this;
    }

    public PayrollRequest<T> orderByTaxAscending(){
       addOrderByAscending(Payroll.TAX_PROPERTY);
       return this;
    }

    public PayrollRequest<T> orderByTaxDescending(){
       addOrderByDescending(Payroll.TAX_PROPERTY);
       return this;
    }

    public PayrollRequest<T> orderByEmployeeAscending(){
       addOrderByAscending(Payroll.EMPLOYEE_PROPERTY);
       return this;
    }

    public PayrollRequest<T> orderByEmployeeDescending(){
       addOrderByDescending(Payroll.EMPLOYEE_PROPERTY);
       return this;
    }

    public PayrollRequest<T> orderByGrossPayAscending(){
       addOrderByAscending(Payroll.GROSS_PAY_PROPERTY);
       return this;
    }

    public PayrollRequest<T> orderByGrossPayDescending(){
       addOrderByDescending(Payroll.GROSS_PAY_PROPERTY);
       return this;
    }

    public PayrollRequest<T> orderByNetPayAscending(){
       addOrderByAscending(Payroll.NET_PAY_PROPERTY);
       return this;
    }

    public PayrollRequest<T> orderByNetPayDescending(){
       addOrderByDescending(Payroll.NET_PAY_PROPERTY);
       return this;
    }

    public PayrollRequest<T> orderByPeriodEndAscending(){
       addOrderByAscending(Payroll.PERIOD_END_PROPERTY);
       return this;
    }

    public PayrollRequest<T> orderByPeriodEndDescending(){
       addOrderByDescending(Payroll.PERIOD_END_PROPERTY);
       return this;
    }

    public PayrollRequest<T> orderByPeriodStartAscending(){
       addOrderByAscending(Payroll.PERIOD_START_PROPERTY);
       return this;
    }

    public PayrollRequest<T> orderByPeriodStartDescending(){
       addOrderByDescending(Payroll.PERIOD_START_PROPERTY);
       return this;
    }

    public PayrollRequest<T> orderByCreateTimeAscending(){
       addOrderByAscending(Payroll.CREATE_TIME_PROPERTY);
       return this;
    }

    public PayrollRequest<T> orderByCreateTimeDescending(){
       addOrderByDescending(Payroll.CREATE_TIME_PROPERTY);
       return this;
    }

    public PayrollRequest<T> orderByUpdateTimeAscending(){
       addOrderByAscending(Payroll.UPDATE_TIME_PROPERTY);
       return this;
    }

    public PayrollRequest<T> orderByUpdateTimeDescending(){
       addOrderByDescending(Payroll.UPDATE_TIME_PROPERTY);
       return this;
    }

    public PayrollRequest<T> orderByVersionAscending(){
       addOrderByAscending(Payroll.VERSION_PROPERTY);
       return this;
    }

    public PayrollRequest<T> orderByVersionDescending(){
       addOrderByDescending(Payroll.VERSION_PROPERTY);
       return this;
    }


    public EmployeeRequest rollUpToEmployee(){
       EmployeeRequest employee = Q.employees().unlimited();
       this.withEmployeeMatching(employee)
           .groupByEmployeeWith(employee);
       return employee;
    }









   public PayrollRequest<T> facetByEmployeeAs(String facetName, EmployeeRequest employee){
       return facetByEmployeeAs(facetName, employee, true);
   }

   public PayrollRequest<T> facetByEmployeeAs(String facetName, EmployeeRequest employee, boolean includeAllFacets){
       addFacet(facetName, Payroll.EMPLOYEE_PROPERTY, employee, includeAllFacets);
       return this;
   }


    /**
     * get topN records
     * @param topN  records number
     */
    public PayrollRequest<T> top(int topN) {
        super.top(topN);
        return this;
    }

    /**
     * get records from offset(inclusive) to offset+size(exclusive)
     * @param offset record offset
     * @param size records number
     */
    public PayrollRequest<T> offset(int offset, int size) {
        super.offset(offset, size);
        return this;
    }

    /**
     * retrieve all records
     */
    public PayrollRequest<T> unlimited() {
        super.unlimited();
        return this;
    }

    /**
     * get records of one page
     * @param pageNumber page number(1-based)
     * @param pageSize page size
     */
    public PayrollRequest<T> page(int pageNumber, int pageSize) {
        int offset = (pageNumber - 1) * pageSize;
        return offset(offset, pageSize);
   }

    /**
     * get records of one page, default page size is 10
     * @param pageNumber page number(1-based)
     */
    public PayrollRequest<T> page(int pageNumber) {
        return page(pageNumber, 10);
   }
}