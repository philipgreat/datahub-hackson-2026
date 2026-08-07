
package com.example.enterpriseerpsystem.expense;

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

public class ExpenseRequest<T extends Expense> extends BaseRequest<T> {

    /**
     * @deprecated AI agents and business code must use the generated Q facade
     *             instead of constructing request builders directly.
     */
    @Deprecated
    public ExpenseRequest(Class<T> returnType){
        super(returnType);
        selectId();
        selectVersion();
    }

    public ExpenseRequest<T> comment(String comment){
         super.internalComment(comment);
         return this;
    }

    // purpose() 继承自 BaseRequest，返回 ExecutableRequest（终结方法）

    public ExpenseRequest<T> returnType(Class<? extends T> returnType){
        super.setReturnType(returnType);
        return this;
    }

    public ExpenseRequest<T> enableAggregationCache(long cacheExpiredMillis){
        super.enableAggregationCache();
        super.aggregateCacheTime(cacheExpiredMillis);
        return this;
    }

    public ExpenseRequest<T> enableAggregationCache(){
        return enableAggregationCache(0l);
    }


    public ExpenseRequest<T> propagateAggregationCache(long cacheExpiredMillis){
        super.propagateAggregationCache(cacheExpiredMillis);
        return this;
    }

    public ExpenseRequest<T> appendSearchCriteria(SearchCriteria searchCriteria){
        return (ExpenseRequest<T>)super.appendSearchCriteria(searchCriteria);
    }

    public ExpenseRequest<T> filter(String property1, Operator operator, String property2){
        return appendSearchCriteria(new TwoOperatorCriteria(operator, new PropertyReference(property1), new PropertyReference(property2)));
    }


    public ExpenseRequest<T> matchingAnyOf(ExpenseRequest expense){
        super.internalMatchAny(expense);
        return this;
    }

    public ExpenseRequest<T> enhanceChildrenIfNeeded(){
        return this;
    }

    public ExpenseRequest<T> withDeletedRows(){
        super.withDeletedRows();
        return this;
    }

    public ExpenseRequest<T> deletedRowsOnly(){
        super.deletedRowsOnly();
        return this;
    }

    public ExpenseRequest<T> selectSelf(){
        super.selectSelf();
        return selectId().selectAmount().selectCategory().selectDateIncurred().selectEmployeeIdOnly().selectStatus().selectCreateTime().selectUpdateTime().selectVersion();
    }

    public ExpenseRequest<T> selectSelfFields(){
        return selectSelf();
    }

    public ExpenseRequest<T> selectAll(){
        super.selectAll();
        return selectId().selectAmount().selectCategory().selectDateIncurred().selectEmployee().selectStatus().selectCreateTime().selectUpdateTime().selectVersion();
    }

    public ExpenseRequest<T> selectChildren(){
        super.selectAny();
        return selectId().selectAmount().selectCategory().selectDateIncurred().selectEmployee().selectStatus().selectCreateTime().selectUpdateTime().selectVersion();
    }


    public ExpenseRequest<T> selectId(){
       selectProperty(Expense.ID_PROPERTY);
       return this;
    }

    /**
     * fill the id with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  id) to fetch id property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public ExpenseRequest<T> unselectId(){
       unselectProperty(Expense.ID_PROPERTY);
       return this;
    }
    public ExpenseRequest<T> selectAmount(){
       selectProperty(Expense.AMOUNT_PROPERTY);
       return this;
    }

    /**
     * fill the amount with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  amount) to fetch amount property.
     * @param rawSqlSegment  customized rawSqlSegment
     */


    /**
     * fill the amount with customized aggrFunction, TEAQL uses ({aggrFunction}(amount) AS amount to fetch amount property.
     * @param aggrFunction  aggrFunction
     */
    public ExpenseRequest<T> selectAmount(AggrFunction aggrFunction){
       selectProperty(Expense.AMOUNT_PROPERTY, aggrFunction);
       return this;
    }


    public ExpenseRequest<T> unselectAmount(){
       unselectProperty(Expense.AMOUNT_PROPERTY);
       return this;
    }
    public ExpenseRequest<T> selectCategory(){
       selectProperty(Expense.CATEGORY_PROPERTY);
       return this;
    }

    /**
     * fill the category with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  category) to fetch category property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public ExpenseRequest<T> unselectCategory(){
       unselectProperty(Expense.CATEGORY_PROPERTY);
       return this;
    }
    public ExpenseRequest<T> selectDateIncurred(){
       selectProperty(Expense.DATE_INCURRED_PROPERTY);
       return this;
    }

    /**
     * fill the dateIncurred with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  dateIncurred) to fetch dateIncurred property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public ExpenseRequest<T> unselectDateIncurred(){
       unselectProperty(Expense.DATE_INCURRED_PROPERTY);
       return this;
    }
    public ExpenseRequest<T> selectEmployeeIdOnly(){
       selectProperty(Expense.EMPLOYEE_PROPERTY);
       return this;
    }

    public ExpenseRequest<T> selectEmployee(){
        return selectEmployeeWith(Q.employees().unlimited().selectSelf());
    }

    public ExpenseRequest<T> selectEmployeeWith(EmployeeRequest employee){
       selectProperty(Expense.EMPLOYEE_PROPERTY);
       enhanceRelation(Expense.EMPLOYEE_PROPERTY, employee);
       return this;
    }

    public ExpenseRequest<T> unselectEmployee(){
       unselectProperty(Expense.EMPLOYEE_PROPERTY);
       return this;
    }
    public ExpenseRequest<T> selectStatus(){
       selectProperty(Expense.STATUS_PROPERTY);
       return this;
    }

    /**
     * fill the status with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  status) to fetch status property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public ExpenseRequest<T> unselectStatus(){
       unselectProperty(Expense.STATUS_PROPERTY);
       return this;
    }
    public ExpenseRequest<T> selectCreateTime(){
       selectProperty(Expense.CREATE_TIME_PROPERTY);
       return this;
    }

    /**
     * fill the createTime with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  createTime) to fetch createTime property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public ExpenseRequest<T> unselectCreateTime(){
       unselectProperty(Expense.CREATE_TIME_PROPERTY);
       return this;
    }
    public ExpenseRequest<T> selectUpdateTime(){
       selectProperty(Expense.UPDATE_TIME_PROPERTY);
       return this;
    }

    /**
     * fill the updateTime with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  updateTime) to fetch updateTime property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public ExpenseRequest<T> unselectUpdateTime(){
       unselectProperty(Expense.UPDATE_TIME_PROPERTY);
       return this;
    }
    public ExpenseRequest<T> selectVersion(){
       selectProperty(Expense.VERSION_PROPERTY);
       return this;
    }

    /**
     * fill the version with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  version) to fetch version property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public ExpenseRequest<T> unselectVersion(){
       unselectProperty(Expense.VERSION_PROPERTY);
       return this;
    }

    public ExpenseRequest<T> withId(Operator operator, Object... values){
       return appendSearchCriteria(createIdCriteria(operator, values));
    }

    public SearchCriteria createIdCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Expense.ID_PROPERTY, operator, values);
    }

    public ExpenseRequest<T> withIdIs(Long id){
       return withId(Operator.EQUAL, id);
    }
    public ExpenseRequest<T> withIdIn(Long... id){
       return withId(Operator.EQUAL, (Object[])id);
    }



    public ExpenseRequest<T> filterByAmount(BigDecimal... amount){
      if (amount == null || amount.length == 0) {
        throw new IllegalArgumentException("filterByAmount parameter amount cannot be empty");
      }
      return appendSearchCriteria(createAmountCriteria(Operator.EQUAL, (Object[])amount));
    }

    public ExpenseRequest<T> withAmount(Operator operator, Object... values){
       return appendSearchCriteria(createAmountCriteria(operator, values));
    }

    public ExpenseRequest<T> withAmountIsUnknown(){
       return withAmount(Operator.IS_NULL);
    }

    public ExpenseRequest<T> withAmountIsKnown(){
       return withAmount(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createAmountCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Expense.AMOUNT_PROPERTY, operator, values);
    }

    public ExpenseRequest<T> withAmountGreaterThan(BigDecimal amount){
       return withAmount(Operator.GREATER_THAN, amount);
    }

    public ExpenseRequest<T> withAmountGreaterThanOrEqualTo(BigDecimal amount){
       return withAmount(Operator.GREATER_THAN_OR_EQUAL, amount);
    }

    public ExpenseRequest<T> withAmountLessThan(BigDecimal amount){
       return withAmount(Operator.LESS_THAN, amount);
    }

    public ExpenseRequest<T> withAmountLessThanOrEqualTo(BigDecimal amount){
       return withAmount(Operator.LESS_THAN_OR_EQUAL, amount);
    }

    public ExpenseRequest<T> withAmountBetween(BigDecimal startOfAmount, BigDecimal endOfAmount){
       return withAmount(Operator.BETWEEN, startOfAmount, endOfAmount);
    }



    public ExpenseRequest<T> filterByCategory(String... category){
      if (category == null || category.length == 0) {
        throw new IllegalArgumentException("filterByCategory parameter category cannot be empty");
      }
      return appendSearchCriteria(createCategoryCriteria(Operator.EQUAL, (Object[])category));
    }

    public ExpenseRequest<T> withCategory(Operator operator, Object... values){
       return appendSearchCriteria(createCategoryCriteria(operator, values));
    }

    public ExpenseRequest<T> withCategoryIsUnknown(){
       return withCategory(Operator.IS_NULL);
    }

    public ExpenseRequest<T> withCategoryIsKnown(){
       return withCategory(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createCategoryCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Expense.CATEGORY_PROPERTY, operator, values);
    }

    public ExpenseRequest<T> withCategoryGreaterThan(String category){
       return withCategory(Operator.GREATER_THAN, category);
    }

    public ExpenseRequest<T> withCategoryGreaterThanOrEqualTo(String category){
       return withCategory(Operator.GREATER_THAN_OR_EQUAL, category);
    }

    public ExpenseRequest<T> withCategoryLessThan(String category){
       return withCategory(Operator.LESS_THAN, category);
    }

    public ExpenseRequest<T> withCategoryLessThanOrEqualTo(String category){
       return withCategory(Operator.LESS_THAN_OR_EQUAL, category);
    }

    public ExpenseRequest<T> withCategoryBetween(String startOfCategory, String endOfCategory){
       return withCategory(Operator.BETWEEN, startOfCategory, endOfCategory);
    }
    public ExpenseRequest<T> withCategoryStartingWith(String category){
       return withCategory(Operator.BEGIN_WITH, category);
    }
    public ExpenseRequest<T> withCategoryContaining(String category){
       return withCategory(Operator.CONTAIN, category);
    }

    public ExpenseRequest<T> withCategoryEndingWith(String category){
       return withCategory(Operator.END_WITH, category);
    }

    public ExpenseRequest<T> withCategoryIs(String category){
       return withCategory(Operator.EQUAL, category);
    }

    public ExpenseRequest<T> withCategorySoundingLike(String category){
       return withCategory(Operator.SOUNDS_LIKE, category);
    }



    public ExpenseRequest<T> filterByDateIncurred(LocalDateTime... dateIncurred){
      if (dateIncurred == null || dateIncurred.length == 0) {
        throw new IllegalArgumentException("filterByDateIncurred parameter dateIncurred cannot be empty");
      }
      return appendSearchCriteria(createDateIncurredCriteria(Operator.EQUAL, (Object[])dateIncurred));
    }

    public ExpenseRequest<T> withDateIncurred(Operator operator, Object... values){
       return appendSearchCriteria(createDateIncurredCriteria(operator, values));
    }

    public ExpenseRequest<T> withDateIncurredIsUnknown(){
       return withDateIncurred(Operator.IS_NULL);
    }

    public ExpenseRequest<T> withDateIncurredIsKnown(){
       return withDateIncurred(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createDateIncurredCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Expense.DATE_INCURRED_PROPERTY, operator, values);
    }

    public ExpenseRequest<T> withDateIncurredGreaterThan(LocalDateTime dateIncurred){
       return withDateIncurred(Operator.GREATER_THAN, dateIncurred);
    }

    public ExpenseRequest<T> withDateIncurredGreaterThanOrEqualTo(LocalDateTime dateIncurred){
       return withDateIncurred(Operator.GREATER_THAN_OR_EQUAL, dateIncurred);
    }

    public ExpenseRequest<T> withDateIncurredLessThan(LocalDateTime dateIncurred){
       return withDateIncurred(Operator.LESS_THAN, dateIncurred);
    }

    public ExpenseRequest<T> withDateIncurredLessThanOrEqualTo(LocalDateTime dateIncurred){
       return withDateIncurred(Operator.LESS_THAN_OR_EQUAL, dateIncurred);
    }

    public ExpenseRequest<T> withDateIncurredBetween(LocalDateTime startOfDateIncurred, LocalDateTime endOfDateIncurred){
       return withDateIncurred(Operator.BETWEEN, startOfDateIncurred, endOfDateIncurred);
    }
    public ExpenseRequest<T> withDateIncurredBefore(LocalDateTime dateIncurred){
       return withDateIncurred(Operator.LESS_THAN, dateIncurred);
    }

    public ExpenseRequest<T> withDateIncurredBefore(Date dateIncurred){
       return withDateIncurred(Operator.LESS_THAN, dateIncurred);
    }

    public ExpenseRequest<T> withDateIncurredAfter(LocalDateTime dateIncurred){
       return withDateIncurred(Operator.GREATER_THAN, dateIncurred);
    }

    public ExpenseRequest<T> withDateIncurredAfter(Date dateIncurred){
       return withDateIncurred(Operator.GREATER_THAN, dateIncurred);
    }

    public ExpenseRequest<T> withDateIncurredBetween(Date startOfDateIncurred, Date endOfDateIncurred){
       return withDateIncurred(Operator.BETWEEN, startOfDateIncurred, endOfDateIncurred);
    }




    public ExpenseRequest<T> filterByEmployee(Employee... employee){
      if (employee == null || employee.length == 0) {
        throw new IllegalArgumentException("filterByEmployee parameter employee cannot be empty");
      }
      return appendSearchCriteria(createEmployeeCriteria(Operator.EQUAL, (Object[])employee));
    }

    public ExpenseRequest<T> withEmployee(Operator operator, Object... values){
       return appendSearchCriteria(createEmployeeCriteria(operator, values));
    }

    public ExpenseRequest<T> withEmployeeIsUnknown(){
       return withEmployee(Operator.IS_NULL);
    }

    public ExpenseRequest<T> withEmployeeIsKnown(){
       return withEmployee(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createEmployeeCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Expense.EMPLOYEE_PROPERTY, operator, values);
    }

    public ExpenseRequest<T> filterByEmployee(Long employee){
      if(employee == null){
         return this;
      }
      return withEmployee(Operator.EQUAL, employee);
    }
    public ExpenseRequest<T> withEmployeeMatching(EmployeeRequest employee){
       return appendSearchCriteria(new SubQuerySearchCriteria(Expense.EMPLOYEE_PROPERTY, employee, Employee.ID_PROPERTY));
    }

    public ExpenseRequest<T> filterByStatus(String... status){
      if (status == null || status.length == 0) {
        throw new IllegalArgumentException("filterByStatus parameter status cannot be empty");
      }
      return appendSearchCriteria(createStatusCriteria(Operator.EQUAL, (Object[])status));
    }

    public ExpenseRequest<T> withStatus(Operator operator, Object... values){
       return appendSearchCriteria(createStatusCriteria(operator, values));
    }

    public ExpenseRequest<T> withStatusIsUnknown(){
       return withStatus(Operator.IS_NULL);
    }

    public ExpenseRequest<T> withStatusIsKnown(){
       return withStatus(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createStatusCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Expense.STATUS_PROPERTY, operator, values);
    }

    public ExpenseRequest<T> withStatusGreaterThan(String status){
       return withStatus(Operator.GREATER_THAN, status);
    }

    public ExpenseRequest<T> withStatusGreaterThanOrEqualTo(String status){
       return withStatus(Operator.GREATER_THAN_OR_EQUAL, status);
    }

    public ExpenseRequest<T> withStatusLessThan(String status){
       return withStatus(Operator.LESS_THAN, status);
    }

    public ExpenseRequest<T> withStatusLessThanOrEqualTo(String status){
       return withStatus(Operator.LESS_THAN_OR_EQUAL, status);
    }

    public ExpenseRequest<T> withStatusBetween(String startOfStatus, String endOfStatus){
       return withStatus(Operator.BETWEEN, startOfStatus, endOfStatus);
    }
    public ExpenseRequest<T> withStatusStartingWith(String status){
       return withStatus(Operator.BEGIN_WITH, status);
    }
    public ExpenseRequest<T> withStatusContaining(String status){
       return withStatus(Operator.CONTAIN, status);
    }

    public ExpenseRequest<T> withStatusEndingWith(String status){
       return withStatus(Operator.END_WITH, status);
    }

    public ExpenseRequest<T> withStatusIs(String status){
       return withStatus(Operator.EQUAL, status);
    }

    public ExpenseRequest<T> withStatusSoundingLike(String status){
       return withStatus(Operator.SOUNDS_LIKE, status);
    }



    public ExpenseRequest<T> filterByCreateTime(LocalDateTime... createTime){
      if (createTime == null || createTime.length == 0) {
        throw new IllegalArgumentException("filterByCreateTime parameter createTime cannot be empty");
      }
      return appendSearchCriteria(createCreateTimeCriteria(Operator.EQUAL, (Object[])createTime));
    }

    public ExpenseRequest<T> withCreateTime(Operator operator, Object... values){
       return appendSearchCriteria(createCreateTimeCriteria(operator, values));
    }

    public ExpenseRequest<T> withCreateTimeIsUnknown(){
       return withCreateTime(Operator.IS_NULL);
    }

    public ExpenseRequest<T> withCreateTimeIsKnown(){
       return withCreateTime(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createCreateTimeCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Expense.CREATE_TIME_PROPERTY, operator, values);
    }

    public ExpenseRequest<T> withCreateTimeGreaterThan(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public ExpenseRequest<T> withCreateTimeGreaterThanOrEqualTo(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN_OR_EQUAL, createTime);
    }

    public ExpenseRequest<T> withCreateTimeLessThan(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public ExpenseRequest<T> withCreateTimeLessThanOrEqualTo(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN_OR_EQUAL, createTime);
    }

    public ExpenseRequest<T> withCreateTimeBetween(LocalDateTime startOfCreateTime, LocalDateTime endOfCreateTime){
       return withCreateTime(Operator.BETWEEN, startOfCreateTime, endOfCreateTime);
    }
    public ExpenseRequest<T> withCreateTimeBefore(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public ExpenseRequest<T> withCreateTimeBefore(Date createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public ExpenseRequest<T> withCreateTimeAfter(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public ExpenseRequest<T> withCreateTimeAfter(Date createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public ExpenseRequest<T> withCreateTimeBetween(Date startOfCreateTime, Date endOfCreateTime){
       return withCreateTime(Operator.BETWEEN, startOfCreateTime, endOfCreateTime);
    }




    public ExpenseRequest<T> filterByUpdateTime(LocalDateTime... updateTime){
      if (updateTime == null || updateTime.length == 0) {
        throw new IllegalArgumentException("filterByUpdateTime parameter updateTime cannot be empty");
      }
      return appendSearchCriteria(createUpdateTimeCriteria(Operator.EQUAL, (Object[])updateTime));
    }

    public ExpenseRequest<T> withUpdateTime(Operator operator, Object... values){
       return appendSearchCriteria(createUpdateTimeCriteria(operator, values));
    }

    public ExpenseRequest<T> withUpdateTimeIsUnknown(){
       return withUpdateTime(Operator.IS_NULL);
    }

    public ExpenseRequest<T> withUpdateTimeIsKnown(){
       return withUpdateTime(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createUpdateTimeCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Expense.UPDATE_TIME_PROPERTY, operator, values);
    }

    public ExpenseRequest<T> withUpdateTimeGreaterThan(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public ExpenseRequest<T> withUpdateTimeGreaterThanOrEqualTo(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN_OR_EQUAL, updateTime);
    }

    public ExpenseRequest<T> withUpdateTimeLessThan(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public ExpenseRequest<T> withUpdateTimeLessThanOrEqualTo(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN_OR_EQUAL, updateTime);
    }

    public ExpenseRequest<T> withUpdateTimeBetween(LocalDateTime startOfUpdateTime, LocalDateTime endOfUpdateTime){
       return withUpdateTime(Operator.BETWEEN, startOfUpdateTime, endOfUpdateTime);
    }
    public ExpenseRequest<T> withUpdateTimeBefore(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public ExpenseRequest<T> withUpdateTimeBefore(Date updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public ExpenseRequest<T> withUpdateTimeAfter(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public ExpenseRequest<T> withUpdateTimeAfter(Date updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public ExpenseRequest<T> withUpdateTimeBetween(Date startOfUpdateTime, Date endOfUpdateTime){
       return withUpdateTime(Operator.BETWEEN, startOfUpdateTime, endOfUpdateTime);
    }




    public ExpenseRequest<T> filterByVersion(Long... version){
      if (version == null || version.length == 0) {
        throw new IllegalArgumentException("filterByVersion parameter version cannot be empty");
      }
      return appendSearchCriteria(createVersionCriteria(Operator.EQUAL, (Object[])version));
    }

    public ExpenseRequest<T> withVersion(Operator operator, Object... values){
       return appendSearchCriteria(createVersionCriteria(operator, values));
    }

    public ExpenseRequest<T> withVersionIsUnknown(){
       return withVersion(Operator.IS_NULL);
    }

    public ExpenseRequest<T> withVersionIsKnown(){
       return withVersion(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createVersionCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Expense.VERSION_PROPERTY, operator, values);
    }

    public ExpenseRequest<T> withVersionGreaterThan(Long version){
       return withVersion(Operator.GREATER_THAN, version);
    }

    public ExpenseRequest<T> withVersionGreaterThanOrEqualTo(Long version){
       return withVersion(Operator.GREATER_THAN_OR_EQUAL, version);
    }

    public ExpenseRequest<T> withVersionLessThan(Long version){
       return withVersion(Operator.LESS_THAN, version);
    }

    public ExpenseRequest<T> withVersionLessThanOrEqualTo(Long version){
       return withVersion(Operator.LESS_THAN_OR_EQUAL, version);
    }

    public ExpenseRequest<T> withVersionBetween(Long startOfVersion, Long endOfVersion){
       return withVersion(Operator.BETWEEN, startOfVersion, endOfVersion);
    }


    public ExpenseRequest<T> count(){
        super.count();
        return this;
    }
    public ExpenseRequest<T> countAs(String retName){
        super.count(retName);
        return this;
    }
    public ExpenseRequest minAmount(){
        return minAmountAs(prefix("minOf",Expense.AMOUNT_PROPERTY));
    }

    public ExpenseRequest minAmountAs(String retName){
        super.min(retName, Expense.AMOUNT_PROPERTY);
        return this;
    }
    public ExpenseRequest maxAmount(){
        return maxAmountAs(prefix("maxOf",Expense.AMOUNT_PROPERTY));
    }

    public ExpenseRequest maxAmountAs(String retName){
        super.max(retName, Expense.AMOUNT_PROPERTY);
        return this;
    }
    public ExpenseRequest sumAmount(){
        return sumAmountAs(prefix("sumOf",Expense.AMOUNT_PROPERTY));
    }

    public ExpenseRequest sumAmountAs(String retName){
        super.sum(retName, Expense.AMOUNT_PROPERTY);
        return this;
    }
    public ExpenseRequest avgAmount(){
        return avgAmountAs(prefix("avgOf",Expense.AMOUNT_PROPERTY));
    }

    public ExpenseRequest avgAmountAs(String retName){
        super.avg(retName, Expense.AMOUNT_PROPERTY);
        return this;
    }
    public ExpenseRequest standardDeviationAmount(){
        return standardDeviationAmountAs(prefix("standardDeviationOf",Expense.AMOUNT_PROPERTY));
    }

    public ExpenseRequest standardDeviationAmountAs(String retName){
        super.standardDeviation(retName, Expense.AMOUNT_PROPERTY);
        return this;
    }
    public ExpenseRequest squareRootOfPopulationStandardDeviationAmount(){
        return squareRootOfPopulationStandardDeviationAmountAs(prefix("squareRootOfPopulationStandardDeviationOf",Expense.AMOUNT_PROPERTY));
    }

    public ExpenseRequest squareRootOfPopulationStandardDeviationAmountAs(String retName){
        super.squareRootOfPopulationStandardDeviation(retName, Expense.AMOUNT_PROPERTY);
        return this;
    }
    public ExpenseRequest sampleVarianceAmount(){
        return sampleVarianceAmountAs(prefix("sampleVarianceOf",Expense.AMOUNT_PROPERTY));
    }

    public ExpenseRequest sampleVarianceAmountAs(String retName){
        super.sampleVariance(retName, Expense.AMOUNT_PROPERTY);
        return this;
    }
    public ExpenseRequest samplePopulationVarianceAmount(){
        return samplePopulationVarianceAmountAs(prefix("samplePopulationVarianceOf",Expense.AMOUNT_PROPERTY));
    }

    public ExpenseRequest samplePopulationVarianceAmountAs(String retName){
        super.samplePopulationVariance(retName, Expense.AMOUNT_PROPERTY);
        return this;
    }
    public ExpenseRequest<T> groupByEmployeeWithDetails(){
       return groupByEmployeeWithDetails(Q.employees().unlimited());
    }

    public ExpenseRequest<T> groupByEmployeeWithDetails(EmployeeRequest subRequest){
       aggregate(Expense.EMPLOYEE_PROPERTY, subRequest);
       return this;
    }






    public ExpenseRequest<T> groupById(){
       groupBy(Expense.ID_PROPERTY);
       return this;
    }

    public ExpenseRequest<T> groupByIdAs(String retName){
       groupBy(retName, Expense.ID_PROPERTY);
       return this;
    }

    public ExpenseRequest<T> groupByIdWithFunction(String retName, AggrFunction function){
       groupBy(retName, Expense.ID_PROPERTY, function);
       return this;
    }

    public ExpenseRequest<T> groupByAmount(){
       groupBy(Expense.AMOUNT_PROPERTY);
       return this;
    }

    public ExpenseRequest<T> groupByAmountAs(String retName){
       groupBy(retName, Expense.AMOUNT_PROPERTY);
       return this;
    }

    public ExpenseRequest<T> groupByAmountWithFunction(String retName, AggrFunction function){
       groupBy(retName, Expense.AMOUNT_PROPERTY, function);
       return this;
    }

    public ExpenseRequest<T> groupByCategory(){
       groupBy(Expense.CATEGORY_PROPERTY);
       return this;
    }

    public ExpenseRequest<T> groupByCategoryAs(String retName){
       groupBy(retName, Expense.CATEGORY_PROPERTY);
       return this;
    }

    public ExpenseRequest<T> groupByCategoryWithFunction(String retName, AggrFunction function){
       groupBy(retName, Expense.CATEGORY_PROPERTY, function);
       return this;
    }

    public ExpenseRequest<T> groupByDateIncurred(){
       groupBy(Expense.DATE_INCURRED_PROPERTY);
       return this;
    }

    public ExpenseRequest<T> groupByDateIncurredAs(String retName){
       groupBy(retName, Expense.DATE_INCURRED_PROPERTY);
       return this;
    }

    public ExpenseRequest<T> groupByDateIncurredWithFunction(String retName, AggrFunction function){
       groupBy(retName, Expense.DATE_INCURRED_PROPERTY, function);
       return this;
    }
    public ExpenseRequest<T> groupByEmployeeWith(EmployeeRequest subRequest){
       groupBy(Expense.EMPLOYEE_PROPERTY, subRequest);
       return this;
    }
    public ExpenseRequest<T> groupByEmployee(){
       groupBy(Expense.EMPLOYEE_PROPERTY);
       return this;
    }

    public ExpenseRequest<T> groupByEmployeeAs(String retName){
       groupBy(retName, Expense.EMPLOYEE_PROPERTY);
       return this;
    }

    public ExpenseRequest<T> groupByEmployeeWithFunction(String retName, AggrFunction function){
       groupBy(retName, Expense.EMPLOYEE_PROPERTY, function);
       return this;
    }

    public ExpenseRequest<T> groupByStatus(){
       groupBy(Expense.STATUS_PROPERTY);
       return this;
    }

    public ExpenseRequest<T> groupByStatusAs(String retName){
       groupBy(retName, Expense.STATUS_PROPERTY);
       return this;
    }

    public ExpenseRequest<T> groupByStatusWithFunction(String retName, AggrFunction function){
       groupBy(retName, Expense.STATUS_PROPERTY, function);
       return this;
    }

    public ExpenseRequest<T> groupByCreateTime(){
       groupBy(Expense.CREATE_TIME_PROPERTY);
       return this;
    }

    public ExpenseRequest<T> groupByCreateTimeAs(String retName){
       groupBy(retName, Expense.CREATE_TIME_PROPERTY);
       return this;
    }

    public ExpenseRequest<T> groupByCreateTimeWithFunction(String retName, AggrFunction function){
       groupBy(retName, Expense.CREATE_TIME_PROPERTY, function);
       return this;
    }

    public ExpenseRequest<T> groupByUpdateTime(){
       groupBy(Expense.UPDATE_TIME_PROPERTY);
       return this;
    }

    public ExpenseRequest<T> groupByUpdateTimeAs(String retName){
       groupBy(retName, Expense.UPDATE_TIME_PROPERTY);
       return this;
    }

    public ExpenseRequest<T> groupByUpdateTimeWithFunction(String retName, AggrFunction function){
       groupBy(retName, Expense.UPDATE_TIME_PROPERTY, function);
       return this;
    }

    public ExpenseRequest<T> groupByVersion(){
       groupBy(Expense.VERSION_PROPERTY);
       return this;
    }

    public ExpenseRequest<T> groupByVersionAs(String retName){
       groupBy(retName, Expense.VERSION_PROPERTY);
       return this;
    }

    public ExpenseRequest<T> groupByVersionWithFunction(String retName, AggrFunction function){
       groupBy(retName, Expense.VERSION_PROPERTY, function);
       return this;
    }



    public ExpenseRequest<T> orderByIdAscending(){
       addOrderByAscending(Expense.ID_PROPERTY);
       return this;
    }

    public ExpenseRequest<T> orderByIdDescending(){
       addOrderByDescending(Expense.ID_PROPERTY);
       return this;
    }

    public ExpenseRequest<T> orderByAmountAscending(){
       addOrderByAscending(Expense.AMOUNT_PROPERTY);
       return this;
    }

    public ExpenseRequest<T> orderByAmountDescending(){
       addOrderByDescending(Expense.AMOUNT_PROPERTY);
       return this;
    }

    public ExpenseRequest<T> orderByCategoryAscending(){
       addOrderByAscending(Expense.CATEGORY_PROPERTY);
       return this;
    }

    public ExpenseRequest<T> orderByCategoryDescending(){
       addOrderByDescending(Expense.CATEGORY_PROPERTY);
       return this;
    }
    public ExpenseRequest<T> orderByCategoryAscendingUsingGBK(){
       addOrderByAscendingUsingGBK(Expense.CATEGORY_PROPERTY);
       return this;
    }

    public ExpenseRequest<T> orderByCategoryDescendingUsingGBK(){
       addOrderByDescendingUsingGBK(Expense.CATEGORY_PROPERTY);
       return this;
    }
    public ExpenseRequest<T> orderByDateIncurredAscending(){
       addOrderByAscending(Expense.DATE_INCURRED_PROPERTY);
       return this;
    }

    public ExpenseRequest<T> orderByDateIncurredDescending(){
       addOrderByDescending(Expense.DATE_INCURRED_PROPERTY);
       return this;
    }

    public ExpenseRequest<T> orderByEmployeeAscending(){
       addOrderByAscending(Expense.EMPLOYEE_PROPERTY);
       return this;
    }

    public ExpenseRequest<T> orderByEmployeeDescending(){
       addOrderByDescending(Expense.EMPLOYEE_PROPERTY);
       return this;
    }

    public ExpenseRequest<T> orderByStatusAscending(){
       addOrderByAscending(Expense.STATUS_PROPERTY);
       return this;
    }

    public ExpenseRequest<T> orderByStatusDescending(){
       addOrderByDescending(Expense.STATUS_PROPERTY);
       return this;
    }
    public ExpenseRequest<T> orderByStatusAscendingUsingGBK(){
       addOrderByAscendingUsingGBK(Expense.STATUS_PROPERTY);
       return this;
    }

    public ExpenseRequest<T> orderByStatusDescendingUsingGBK(){
       addOrderByDescendingUsingGBK(Expense.STATUS_PROPERTY);
       return this;
    }
    public ExpenseRequest<T> orderByCreateTimeAscending(){
       addOrderByAscending(Expense.CREATE_TIME_PROPERTY);
       return this;
    }

    public ExpenseRequest<T> orderByCreateTimeDescending(){
       addOrderByDescending(Expense.CREATE_TIME_PROPERTY);
       return this;
    }

    public ExpenseRequest<T> orderByUpdateTimeAscending(){
       addOrderByAscending(Expense.UPDATE_TIME_PROPERTY);
       return this;
    }

    public ExpenseRequest<T> orderByUpdateTimeDescending(){
       addOrderByDescending(Expense.UPDATE_TIME_PROPERTY);
       return this;
    }

    public ExpenseRequest<T> orderByVersionAscending(){
       addOrderByAscending(Expense.VERSION_PROPERTY);
       return this;
    }

    public ExpenseRequest<T> orderByVersionDescending(){
       addOrderByDescending(Expense.VERSION_PROPERTY);
       return this;
    }


    public EmployeeRequest rollUpToEmployee(){
       EmployeeRequest employee = Q.employees().unlimited();
       this.withEmployeeMatching(employee)
           .groupByEmployeeWith(employee);
       return employee;
    }






   public ExpenseRequest<T> facetByEmployeeAs(String facetName, EmployeeRequest employee){
       return facetByEmployeeAs(facetName, employee, true);
   }

   public ExpenseRequest<T> facetByEmployeeAs(String facetName, EmployeeRequest employee, boolean includeAllFacets){
       addFacet(facetName, Expense.EMPLOYEE_PROPERTY, employee, includeAllFacets);
       return this;
   }


    /**
     * get topN records
     * @param topN  records number
     */
    public ExpenseRequest<T> top(int topN) {
        super.top(topN);
        return this;
    }

    /**
     * get records from offset(inclusive) to offset+size(exclusive)
     * @param offset record offset
     * @param size records number
     */
    public ExpenseRequest<T> offset(int offset, int size) {
        super.offset(offset, size);
        return this;
    }

    /**
     * retrieve all records
     */
    public ExpenseRequest<T> unlimited() {
        super.unlimited();
        return this;
    }

    /**
     * get records of one page
     * @param pageNumber page number(1-based)
     * @param pageSize page size
     */
    public ExpenseRequest<T> page(int pageNumber, int pageSize) {
        int offset = (pageNumber - 1) * pageSize;
        return offset(offset, pageSize);
   }

    /**
     * get records of one page, default page size is 10
     * @param pageNumber page number(1-based)
     */
    public ExpenseRequest<T> page(int pageNumber) {
        return page(pageNumber, 10);
   }
}