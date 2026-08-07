
package com.example.enterpriseerpsystem.invoice;

import com.example.enterpriseerpsystem.Q;
import com.example.enterpriseerpsystem.customer.Customer;
import com.example.enterpriseerpsystem.customer.CustomerRequest;
import com.example.enterpriseerpsystem.globalorder.GlobalOrder;
import com.example.enterpriseerpsystem.globalorder.GlobalOrderRequest;
import com.example.enterpriseerpsystem.payment.Payment;
import com.example.enterpriseerpsystem.payment.PaymentRequest;
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

public class InvoiceRequest<T extends Invoice> extends BaseRequest<T> {

    /**
     * @deprecated AI agents and business code must use the generated Q facade
     *             instead of constructing request builders directly.
     */
    @Deprecated
    public InvoiceRequest(Class<T> returnType){
        super(returnType);
        selectId();
        selectVersion();
    }

    public InvoiceRequest<T> comment(String comment){
         super.internalComment(comment);
         return this;
    }

    // purpose() 继承自 BaseRequest，返回 ExecutableRequest（终结方法）

    public InvoiceRequest<T> returnType(Class<? extends T> returnType){
        super.setReturnType(returnType);
        return this;
    }

    public InvoiceRequest<T> enableAggregationCache(long cacheExpiredMillis){
        super.enableAggregationCache();
        super.aggregateCacheTime(cacheExpiredMillis);
        return this;
    }

    public InvoiceRequest<T> enableAggregationCache(){
        return enableAggregationCache(0l);
    }


    public InvoiceRequest<T> propagateAggregationCache(long cacheExpiredMillis){
        super.propagateAggregationCache(cacheExpiredMillis);
        return this;
    }

    public InvoiceRequest<T> appendSearchCriteria(SearchCriteria searchCriteria){
        return (InvoiceRequest<T>)super.appendSearchCriteria(searchCriteria);
    }

    public InvoiceRequest<T> filter(String property1, Operator operator, String property2){
        return appendSearchCriteria(new TwoOperatorCriteria(operator, new PropertyReference(property1), new PropertyReference(property2)));
    }


    public InvoiceRequest<T> matchingAnyOf(InvoiceRequest invoice){
        super.internalMatchAny(invoice);
        return this;
    }

    public InvoiceRequest<T> enhanceChildrenIfNeeded(){
        return this;
    }

    public InvoiceRequest<T> withDeletedRows(){
        super.withDeletedRows();
        return this;
    }

    public InvoiceRequest<T> deletedRowsOnly(){
        super.deletedRowsOnly();
        return this;
    }

    public InvoiceRequest<T> selectSelf(){
        super.selectSelf();
        return selectId().selectAmount().selectCustomerIdOnly().selectDueDate().selectGlobalOrderIdOnly().selectIssueDate().selectStatus().selectCreateTime().selectUpdateTime().selectVersion();
    }

    public InvoiceRequest<T> selectSelfFields(){
        return selectSelf();
    }

    public InvoiceRequest<T> selectAll(){
        super.selectAll();
        return selectId().selectAmount().selectCustomer().selectDueDate().selectGlobalOrder().selectIssueDate().selectStatus().selectCreateTime().selectUpdateTime().selectVersion();
    }

    public InvoiceRequest<T> selectChildren(){
        super.selectAny();
        selectPaymentList();
        return selectId().selectAmount().selectCustomer().selectDueDate().selectGlobalOrder().selectIssueDate().selectStatus().selectCreateTime().selectUpdateTime().selectVersion();
    }


    public InvoiceRequest<T> selectId(){
       selectProperty(Invoice.ID_PROPERTY);
       return this;
    }

    /**
     * fill the id with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  id) to fetch id property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public InvoiceRequest<T> unselectId(){
       unselectProperty(Invoice.ID_PROPERTY);
       return this;
    }
    public InvoiceRequest<T> selectAmount(){
       selectProperty(Invoice.AMOUNT_PROPERTY);
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
    public InvoiceRequest<T> selectAmount(AggrFunction aggrFunction){
       selectProperty(Invoice.AMOUNT_PROPERTY, aggrFunction);
       return this;
    }


    public InvoiceRequest<T> unselectAmount(){
       unselectProperty(Invoice.AMOUNT_PROPERTY);
       return this;
    }
    public InvoiceRequest<T> selectCustomerIdOnly(){
       selectProperty(Invoice.CUSTOMER_PROPERTY);
       return this;
    }

    public InvoiceRequest<T> selectCustomer(){
        return selectCustomerWith(Q.customers().unlimited().selectSelf());
    }

    public InvoiceRequest<T> selectCustomerWith(CustomerRequest customer){
       selectProperty(Invoice.CUSTOMER_PROPERTY);
       enhanceRelation(Invoice.CUSTOMER_PROPERTY, customer);
       return this;
    }

    public InvoiceRequest<T> unselectCustomer(){
       unselectProperty(Invoice.CUSTOMER_PROPERTY);
       return this;
    }
    public InvoiceRequest<T> selectDueDate(){
       selectProperty(Invoice.DUE_DATE_PROPERTY);
       return this;
    }

    /**
     * fill the dueDate with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  dueDate) to fetch dueDate property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public InvoiceRequest<T> unselectDueDate(){
       unselectProperty(Invoice.DUE_DATE_PROPERTY);
       return this;
    }
    public InvoiceRequest<T> selectGlobalOrderIdOnly(){
       selectProperty(Invoice.GLOBAL_ORDER_PROPERTY);
       return this;
    }

    public InvoiceRequest<T> selectGlobalOrder(){
        return selectGlobalOrderWith(Q.globalOrders().unlimited().selectSelf());
    }

    public InvoiceRequest<T> selectGlobalOrderWith(GlobalOrderRequest globalOrder){
       selectProperty(Invoice.GLOBAL_ORDER_PROPERTY);
       enhanceRelation(Invoice.GLOBAL_ORDER_PROPERTY, globalOrder);
       return this;
    }

    public InvoiceRequest<T> unselectGlobalOrder(){
       unselectProperty(Invoice.GLOBAL_ORDER_PROPERTY);
       return this;
    }
    public InvoiceRequest<T> selectIssueDate(){
       selectProperty(Invoice.ISSUE_DATE_PROPERTY);
       return this;
    }

    /**
     * fill the issueDate with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  issueDate) to fetch issueDate property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public InvoiceRequest<T> unselectIssueDate(){
       unselectProperty(Invoice.ISSUE_DATE_PROPERTY);
       return this;
    }
    public InvoiceRequest<T> selectStatus(){
       selectProperty(Invoice.STATUS_PROPERTY);
       return this;
    }

    /**
     * fill the status with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  status) to fetch status property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public InvoiceRequest<T> unselectStatus(){
       unselectProperty(Invoice.STATUS_PROPERTY);
       return this;
    }
    public InvoiceRequest<T> selectCreateTime(){
       selectProperty(Invoice.CREATE_TIME_PROPERTY);
       return this;
    }

    /**
     * fill the createTime with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  createTime) to fetch createTime property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public InvoiceRequest<T> unselectCreateTime(){
       unselectProperty(Invoice.CREATE_TIME_PROPERTY);
       return this;
    }
    public InvoiceRequest<T> selectUpdateTime(){
       selectProperty(Invoice.UPDATE_TIME_PROPERTY);
       return this;
    }

    /**
     * fill the updateTime with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  updateTime) to fetch updateTime property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public InvoiceRequest<T> unselectUpdateTime(){
       unselectProperty(Invoice.UPDATE_TIME_PROPERTY);
       return this;
    }
    public InvoiceRequest<T> selectVersion(){
       selectProperty(Invoice.VERSION_PROPERTY);
       return this;
    }

    /**
     * fill the version with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  version) to fetch version property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public InvoiceRequest<T> unselectVersion(){
       unselectProperty(Invoice.VERSION_PROPERTY);
       return this;
    }
    public InvoiceRequest<T> selectPaymentList(){
       return selectPaymentListWith(Q.payments().selectSelf());
    }

    public InvoiceRequest<T> selectPaymentListWith(PaymentRequest paymentList){
       enhanceRelation(Invoice.PAYMENT_LIST_PROPERTY, paymentList);
       return this;
    }

    public InvoiceRequest<T> withId(Operator operator, Object... values){
       return appendSearchCriteria(createIdCriteria(operator, values));
    }

    public SearchCriteria createIdCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Invoice.ID_PROPERTY, operator, values);
    }

    public InvoiceRequest<T> withIdIs(Long id){
       return withId(Operator.EQUAL, id);
    }
    public InvoiceRequest<T> withIdIn(Long... id){
       return withId(Operator.EQUAL, (Object[])id);
    }



    public InvoiceRequest<T> filterByAmount(BigDecimal... amount){
      if (amount == null || amount.length == 0) {
        throw new IllegalArgumentException("filterByAmount parameter amount cannot be empty");
      }
      return appendSearchCriteria(createAmountCriteria(Operator.EQUAL, (Object[])amount));
    }

    public InvoiceRequest<T> withAmount(Operator operator, Object... values){
       return appendSearchCriteria(createAmountCriteria(operator, values));
    }

    public InvoiceRequest<T> withAmountIsUnknown(){
       return withAmount(Operator.IS_NULL);
    }

    public InvoiceRequest<T> withAmountIsKnown(){
       return withAmount(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createAmountCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Invoice.AMOUNT_PROPERTY, operator, values);
    }

    public InvoiceRequest<T> withAmountGreaterThan(BigDecimal amount){
       return withAmount(Operator.GREATER_THAN, amount);
    }

    public InvoiceRequest<T> withAmountGreaterThanOrEqualTo(BigDecimal amount){
       return withAmount(Operator.GREATER_THAN_OR_EQUAL, amount);
    }

    public InvoiceRequest<T> withAmountLessThan(BigDecimal amount){
       return withAmount(Operator.LESS_THAN, amount);
    }

    public InvoiceRequest<T> withAmountLessThanOrEqualTo(BigDecimal amount){
       return withAmount(Operator.LESS_THAN_OR_EQUAL, amount);
    }

    public InvoiceRequest<T> withAmountBetween(BigDecimal startOfAmount, BigDecimal endOfAmount){
       return withAmount(Operator.BETWEEN, startOfAmount, endOfAmount);
    }



    public InvoiceRequest<T> filterByCustomer(Customer... customer){
      if (customer == null || customer.length == 0) {
        throw new IllegalArgumentException("filterByCustomer parameter customer cannot be empty");
      }
      return appendSearchCriteria(createCustomerCriteria(Operator.EQUAL, (Object[])customer));
    }

    public InvoiceRequest<T> withCustomer(Operator operator, Object... values){
       return appendSearchCriteria(createCustomerCriteria(operator, values));
    }

    public InvoiceRequest<T> withCustomerIsUnknown(){
       return withCustomer(Operator.IS_NULL);
    }

    public InvoiceRequest<T> withCustomerIsKnown(){
       return withCustomer(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createCustomerCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Invoice.CUSTOMER_PROPERTY, operator, values);
    }

    public InvoiceRequest<T> filterByCustomer(Long customer){
      if(customer == null){
         return this;
      }
      return withCustomer(Operator.EQUAL, customer);
    }
    public InvoiceRequest<T> withCustomerMatching(CustomerRequest customer){
       return appendSearchCriteria(new SubQuerySearchCriteria(Invoice.CUSTOMER_PROPERTY, customer, Customer.ID_PROPERTY));
    }

    public InvoiceRequest<T> filterByDueDate(LocalDateTime... dueDate){
      if (dueDate == null || dueDate.length == 0) {
        throw new IllegalArgumentException("filterByDueDate parameter dueDate cannot be empty");
      }
      return appendSearchCriteria(createDueDateCriteria(Operator.EQUAL, (Object[])dueDate));
    }

    public InvoiceRequest<T> withDueDate(Operator operator, Object... values){
       return appendSearchCriteria(createDueDateCriteria(operator, values));
    }

    public InvoiceRequest<T> withDueDateIsUnknown(){
       return withDueDate(Operator.IS_NULL);
    }

    public InvoiceRequest<T> withDueDateIsKnown(){
       return withDueDate(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createDueDateCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Invoice.DUE_DATE_PROPERTY, operator, values);
    }

    public InvoiceRequest<T> withDueDateGreaterThan(LocalDateTime dueDate){
       return withDueDate(Operator.GREATER_THAN, dueDate);
    }

    public InvoiceRequest<T> withDueDateGreaterThanOrEqualTo(LocalDateTime dueDate){
       return withDueDate(Operator.GREATER_THAN_OR_EQUAL, dueDate);
    }

    public InvoiceRequest<T> withDueDateLessThan(LocalDateTime dueDate){
       return withDueDate(Operator.LESS_THAN, dueDate);
    }

    public InvoiceRequest<T> withDueDateLessThanOrEqualTo(LocalDateTime dueDate){
       return withDueDate(Operator.LESS_THAN_OR_EQUAL, dueDate);
    }

    public InvoiceRequest<T> withDueDateBetween(LocalDateTime startOfDueDate, LocalDateTime endOfDueDate){
       return withDueDate(Operator.BETWEEN, startOfDueDate, endOfDueDate);
    }
    public InvoiceRequest<T> withDueDateBefore(LocalDateTime dueDate){
       return withDueDate(Operator.LESS_THAN, dueDate);
    }

    public InvoiceRequest<T> withDueDateBefore(Date dueDate){
       return withDueDate(Operator.LESS_THAN, dueDate);
    }

    public InvoiceRequest<T> withDueDateAfter(LocalDateTime dueDate){
       return withDueDate(Operator.GREATER_THAN, dueDate);
    }

    public InvoiceRequest<T> withDueDateAfter(Date dueDate){
       return withDueDate(Operator.GREATER_THAN, dueDate);
    }

    public InvoiceRequest<T> withDueDateBetween(Date startOfDueDate, Date endOfDueDate){
       return withDueDate(Operator.BETWEEN, startOfDueDate, endOfDueDate);
    }




    public InvoiceRequest<T> filterByGlobalOrder(GlobalOrder... globalOrder){
      if (globalOrder == null || globalOrder.length == 0) {
        throw new IllegalArgumentException("filterByGlobalOrder parameter globalOrder cannot be empty");
      }
      return appendSearchCriteria(createGlobalOrderCriteria(Operator.EQUAL, (Object[])globalOrder));
    }

    public InvoiceRequest<T> withGlobalOrder(Operator operator, Object... values){
       return appendSearchCriteria(createGlobalOrderCriteria(operator, values));
    }

    public InvoiceRequest<T> withGlobalOrderIsUnknown(){
       return withGlobalOrder(Operator.IS_NULL);
    }

    public InvoiceRequest<T> withGlobalOrderIsKnown(){
       return withGlobalOrder(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createGlobalOrderCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Invoice.GLOBAL_ORDER_PROPERTY, operator, values);
    }

    public InvoiceRequest<T> filterByGlobalOrder(Long globalOrder){
      if(globalOrder == null){
         return this;
      }
      return withGlobalOrder(Operator.EQUAL, globalOrder);
    }
    public InvoiceRequest<T> withGlobalOrderMatching(GlobalOrderRequest globalOrder){
       return appendSearchCriteria(new SubQuerySearchCriteria(Invoice.GLOBAL_ORDER_PROPERTY, globalOrder, GlobalOrder.ID_PROPERTY));
    }

    public InvoiceRequest<T> filterByIssueDate(LocalDateTime... issueDate){
      if (issueDate == null || issueDate.length == 0) {
        throw new IllegalArgumentException("filterByIssueDate parameter issueDate cannot be empty");
      }
      return appendSearchCriteria(createIssueDateCriteria(Operator.EQUAL, (Object[])issueDate));
    }

    public InvoiceRequest<T> withIssueDate(Operator operator, Object... values){
       return appendSearchCriteria(createIssueDateCriteria(operator, values));
    }

    public InvoiceRequest<T> withIssueDateIsUnknown(){
       return withIssueDate(Operator.IS_NULL);
    }

    public InvoiceRequest<T> withIssueDateIsKnown(){
       return withIssueDate(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createIssueDateCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Invoice.ISSUE_DATE_PROPERTY, operator, values);
    }

    public InvoiceRequest<T> withIssueDateGreaterThan(LocalDateTime issueDate){
       return withIssueDate(Operator.GREATER_THAN, issueDate);
    }

    public InvoiceRequest<T> withIssueDateGreaterThanOrEqualTo(LocalDateTime issueDate){
       return withIssueDate(Operator.GREATER_THAN_OR_EQUAL, issueDate);
    }

    public InvoiceRequest<T> withIssueDateLessThan(LocalDateTime issueDate){
       return withIssueDate(Operator.LESS_THAN, issueDate);
    }

    public InvoiceRequest<T> withIssueDateLessThanOrEqualTo(LocalDateTime issueDate){
       return withIssueDate(Operator.LESS_THAN_OR_EQUAL, issueDate);
    }

    public InvoiceRequest<T> withIssueDateBetween(LocalDateTime startOfIssueDate, LocalDateTime endOfIssueDate){
       return withIssueDate(Operator.BETWEEN, startOfIssueDate, endOfIssueDate);
    }
    public InvoiceRequest<T> withIssueDateBefore(LocalDateTime issueDate){
       return withIssueDate(Operator.LESS_THAN, issueDate);
    }

    public InvoiceRequest<T> withIssueDateBefore(Date issueDate){
       return withIssueDate(Operator.LESS_THAN, issueDate);
    }

    public InvoiceRequest<T> withIssueDateAfter(LocalDateTime issueDate){
       return withIssueDate(Operator.GREATER_THAN, issueDate);
    }

    public InvoiceRequest<T> withIssueDateAfter(Date issueDate){
       return withIssueDate(Operator.GREATER_THAN, issueDate);
    }

    public InvoiceRequest<T> withIssueDateBetween(Date startOfIssueDate, Date endOfIssueDate){
       return withIssueDate(Operator.BETWEEN, startOfIssueDate, endOfIssueDate);
    }




    public InvoiceRequest<T> filterByStatus(String... status){
      if (status == null || status.length == 0) {
        throw new IllegalArgumentException("filterByStatus parameter status cannot be empty");
      }
      return appendSearchCriteria(createStatusCriteria(Operator.EQUAL, (Object[])status));
    }

    public InvoiceRequest<T> withStatus(Operator operator, Object... values){
       return appendSearchCriteria(createStatusCriteria(operator, values));
    }

    public InvoiceRequest<T> withStatusIsUnknown(){
       return withStatus(Operator.IS_NULL);
    }

    public InvoiceRequest<T> withStatusIsKnown(){
       return withStatus(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createStatusCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Invoice.STATUS_PROPERTY, operator, values);
    }

    public InvoiceRequest<T> withStatusGreaterThan(String status){
       return withStatus(Operator.GREATER_THAN, status);
    }

    public InvoiceRequest<T> withStatusGreaterThanOrEqualTo(String status){
       return withStatus(Operator.GREATER_THAN_OR_EQUAL, status);
    }

    public InvoiceRequest<T> withStatusLessThan(String status){
       return withStatus(Operator.LESS_THAN, status);
    }

    public InvoiceRequest<T> withStatusLessThanOrEqualTo(String status){
       return withStatus(Operator.LESS_THAN_OR_EQUAL, status);
    }

    public InvoiceRequest<T> withStatusBetween(String startOfStatus, String endOfStatus){
       return withStatus(Operator.BETWEEN, startOfStatus, endOfStatus);
    }
    public InvoiceRequest<T> withStatusStartingWith(String status){
       return withStatus(Operator.BEGIN_WITH, status);
    }
    public InvoiceRequest<T> withStatusContaining(String status){
       return withStatus(Operator.CONTAIN, status);
    }

    public InvoiceRequest<T> withStatusEndingWith(String status){
       return withStatus(Operator.END_WITH, status);
    }

    public InvoiceRequest<T> withStatusIs(String status){
       return withStatus(Operator.EQUAL, status);
    }

    public InvoiceRequest<T> withStatusSoundingLike(String status){
       return withStatus(Operator.SOUNDS_LIKE, status);
    }



    public InvoiceRequest<T> filterByCreateTime(LocalDateTime... createTime){
      if (createTime == null || createTime.length == 0) {
        throw new IllegalArgumentException("filterByCreateTime parameter createTime cannot be empty");
      }
      return appendSearchCriteria(createCreateTimeCriteria(Operator.EQUAL, (Object[])createTime));
    }

    public InvoiceRequest<T> withCreateTime(Operator operator, Object... values){
       return appendSearchCriteria(createCreateTimeCriteria(operator, values));
    }

    public InvoiceRequest<T> withCreateTimeIsUnknown(){
       return withCreateTime(Operator.IS_NULL);
    }

    public InvoiceRequest<T> withCreateTimeIsKnown(){
       return withCreateTime(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createCreateTimeCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Invoice.CREATE_TIME_PROPERTY, operator, values);
    }

    public InvoiceRequest<T> withCreateTimeGreaterThan(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public InvoiceRequest<T> withCreateTimeGreaterThanOrEqualTo(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN_OR_EQUAL, createTime);
    }

    public InvoiceRequest<T> withCreateTimeLessThan(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public InvoiceRequest<T> withCreateTimeLessThanOrEqualTo(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN_OR_EQUAL, createTime);
    }

    public InvoiceRequest<T> withCreateTimeBetween(LocalDateTime startOfCreateTime, LocalDateTime endOfCreateTime){
       return withCreateTime(Operator.BETWEEN, startOfCreateTime, endOfCreateTime);
    }
    public InvoiceRequest<T> withCreateTimeBefore(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public InvoiceRequest<T> withCreateTimeBefore(Date createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public InvoiceRequest<T> withCreateTimeAfter(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public InvoiceRequest<T> withCreateTimeAfter(Date createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public InvoiceRequest<T> withCreateTimeBetween(Date startOfCreateTime, Date endOfCreateTime){
       return withCreateTime(Operator.BETWEEN, startOfCreateTime, endOfCreateTime);
    }




    public InvoiceRequest<T> filterByUpdateTime(LocalDateTime... updateTime){
      if (updateTime == null || updateTime.length == 0) {
        throw new IllegalArgumentException("filterByUpdateTime parameter updateTime cannot be empty");
      }
      return appendSearchCriteria(createUpdateTimeCriteria(Operator.EQUAL, (Object[])updateTime));
    }

    public InvoiceRequest<T> withUpdateTime(Operator operator, Object... values){
       return appendSearchCriteria(createUpdateTimeCriteria(operator, values));
    }

    public InvoiceRequest<T> withUpdateTimeIsUnknown(){
       return withUpdateTime(Operator.IS_NULL);
    }

    public InvoiceRequest<T> withUpdateTimeIsKnown(){
       return withUpdateTime(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createUpdateTimeCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Invoice.UPDATE_TIME_PROPERTY, operator, values);
    }

    public InvoiceRequest<T> withUpdateTimeGreaterThan(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public InvoiceRequest<T> withUpdateTimeGreaterThanOrEqualTo(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN_OR_EQUAL, updateTime);
    }

    public InvoiceRequest<T> withUpdateTimeLessThan(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public InvoiceRequest<T> withUpdateTimeLessThanOrEqualTo(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN_OR_EQUAL, updateTime);
    }

    public InvoiceRequest<T> withUpdateTimeBetween(LocalDateTime startOfUpdateTime, LocalDateTime endOfUpdateTime){
       return withUpdateTime(Operator.BETWEEN, startOfUpdateTime, endOfUpdateTime);
    }
    public InvoiceRequest<T> withUpdateTimeBefore(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public InvoiceRequest<T> withUpdateTimeBefore(Date updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public InvoiceRequest<T> withUpdateTimeAfter(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public InvoiceRequest<T> withUpdateTimeAfter(Date updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public InvoiceRequest<T> withUpdateTimeBetween(Date startOfUpdateTime, Date endOfUpdateTime){
       return withUpdateTime(Operator.BETWEEN, startOfUpdateTime, endOfUpdateTime);
    }




    public InvoiceRequest<T> filterByVersion(Long... version){
      if (version == null || version.length == 0) {
        throw new IllegalArgumentException("filterByVersion parameter version cannot be empty");
      }
      return appendSearchCriteria(createVersionCriteria(Operator.EQUAL, (Object[])version));
    }

    public InvoiceRequest<T> withVersion(Operator operator, Object... values){
       return appendSearchCriteria(createVersionCriteria(operator, values));
    }

    public InvoiceRequest<T> withVersionIsUnknown(){
       return withVersion(Operator.IS_NULL);
    }

    public InvoiceRequest<T> withVersionIsKnown(){
       return withVersion(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createVersionCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Invoice.VERSION_PROPERTY, operator, values);
    }

    public InvoiceRequest<T> withVersionGreaterThan(Long version){
       return withVersion(Operator.GREATER_THAN, version);
    }

    public InvoiceRequest<T> withVersionGreaterThanOrEqualTo(Long version){
       return withVersion(Operator.GREATER_THAN_OR_EQUAL, version);
    }

    public InvoiceRequest<T> withVersionLessThan(Long version){
       return withVersion(Operator.LESS_THAN, version);
    }

    public InvoiceRequest<T> withVersionLessThanOrEqualTo(Long version){
       return withVersion(Operator.LESS_THAN_OR_EQUAL, version);
    }

    public InvoiceRequest<T> withVersionBetween(Long startOfVersion, Long endOfVersion){
       return withVersion(Operator.BETWEEN, startOfVersion, endOfVersion);
    }

    public InvoiceRequest<T> withPaymentListMatching(PaymentRequest paymentRequest){
        return appendSearchCriteria(new SubQuerySearchCriteria(Invoice.ID_PROPERTY, paymentRequest, Payment.INVOICE_PROPERTY));
    }

    public InvoiceRequest<T> withoutPaymentListMatching(PaymentRequest paymentRequest){
        return appendSearchCriteria(SearchCriteria.not(new SubQuerySearchCriteria(Invoice.ID_PROPERTY, paymentRequest, Payment.INVOICE_PROPERTY)));
    }

    public InvoiceRequest<T> havePayments(){
        return withPaymentListMatching(Q.payments().unlimited());
    }

    public InvoiceRequest<T> haveNoPayments(){
        return withoutPaymentListMatching(Q.payments().unlimited());
    }

    public InvoiceRequest<T> count(){
        super.count();
        return this;
    }
    public InvoiceRequest<T> countAs(String retName){
        super.count(retName);
        return this;
    }
    public InvoiceRequest minAmount(){
        return minAmountAs(prefix("minOf",Invoice.AMOUNT_PROPERTY));
    }

    public InvoiceRequest minAmountAs(String retName){
        super.min(retName, Invoice.AMOUNT_PROPERTY);
        return this;
    }
    public InvoiceRequest maxAmount(){
        return maxAmountAs(prefix("maxOf",Invoice.AMOUNT_PROPERTY));
    }

    public InvoiceRequest maxAmountAs(String retName){
        super.max(retName, Invoice.AMOUNT_PROPERTY);
        return this;
    }
    public InvoiceRequest sumAmount(){
        return sumAmountAs(prefix("sumOf",Invoice.AMOUNT_PROPERTY));
    }

    public InvoiceRequest sumAmountAs(String retName){
        super.sum(retName, Invoice.AMOUNT_PROPERTY);
        return this;
    }
    public InvoiceRequest avgAmount(){
        return avgAmountAs(prefix("avgOf",Invoice.AMOUNT_PROPERTY));
    }

    public InvoiceRequest avgAmountAs(String retName){
        super.avg(retName, Invoice.AMOUNT_PROPERTY);
        return this;
    }
    public InvoiceRequest standardDeviationAmount(){
        return standardDeviationAmountAs(prefix("standardDeviationOf",Invoice.AMOUNT_PROPERTY));
    }

    public InvoiceRequest standardDeviationAmountAs(String retName){
        super.standardDeviation(retName, Invoice.AMOUNT_PROPERTY);
        return this;
    }
    public InvoiceRequest squareRootOfPopulationStandardDeviationAmount(){
        return squareRootOfPopulationStandardDeviationAmountAs(prefix("squareRootOfPopulationStandardDeviationOf",Invoice.AMOUNT_PROPERTY));
    }

    public InvoiceRequest squareRootOfPopulationStandardDeviationAmountAs(String retName){
        super.squareRootOfPopulationStandardDeviation(retName, Invoice.AMOUNT_PROPERTY);
        return this;
    }
    public InvoiceRequest sampleVarianceAmount(){
        return sampleVarianceAmountAs(prefix("sampleVarianceOf",Invoice.AMOUNT_PROPERTY));
    }

    public InvoiceRequest sampleVarianceAmountAs(String retName){
        super.sampleVariance(retName, Invoice.AMOUNT_PROPERTY);
        return this;
    }
    public InvoiceRequest samplePopulationVarianceAmount(){
        return samplePopulationVarianceAmountAs(prefix("samplePopulationVarianceOf",Invoice.AMOUNT_PROPERTY));
    }

    public InvoiceRequest samplePopulationVarianceAmountAs(String retName){
        super.samplePopulationVariance(retName, Invoice.AMOUNT_PROPERTY);
        return this;
    }
    public InvoiceRequest<T> groupByCustomerWithDetails(){
       return groupByCustomerWithDetails(Q.customers().unlimited());
    }

    public InvoiceRequest<T> groupByCustomerWithDetails(CustomerRequest subRequest){
       aggregate(Invoice.CUSTOMER_PROPERTY, subRequest);
       return this;
    }


    public InvoiceRequest<T> groupByGlobalOrderWithDetails(){
       return groupByGlobalOrderWithDetails(Q.globalOrders().unlimited());
    }

    public InvoiceRequest<T> groupByGlobalOrderWithDetails(GlobalOrderRequest subRequest){
       aggregate(Invoice.GLOBAL_ORDER_PROPERTY, subRequest);
       return this;
    }






    public InvoiceRequest<T> groupByPaymentsWithDetails(PaymentRequest subRequest){
       aggregate(Invoice.PAYMENT_LIST_PROPERTY, subRequest);
       return this;
    }

    public InvoiceRequest<T> groupById(){
       groupBy(Invoice.ID_PROPERTY);
       return this;
    }

    public InvoiceRequest<T> groupByIdAs(String retName){
       groupBy(retName, Invoice.ID_PROPERTY);
       return this;
    }

    public InvoiceRequest<T> groupByIdWithFunction(String retName, AggrFunction function){
       groupBy(retName, Invoice.ID_PROPERTY, function);
       return this;
    }

    public InvoiceRequest<T> groupByAmount(){
       groupBy(Invoice.AMOUNT_PROPERTY);
       return this;
    }

    public InvoiceRequest<T> groupByAmountAs(String retName){
       groupBy(retName, Invoice.AMOUNT_PROPERTY);
       return this;
    }

    public InvoiceRequest<T> groupByAmountWithFunction(String retName, AggrFunction function){
       groupBy(retName, Invoice.AMOUNT_PROPERTY, function);
       return this;
    }
    public InvoiceRequest<T> groupByCustomerWith(CustomerRequest subRequest){
       groupBy(Invoice.CUSTOMER_PROPERTY, subRequest);
       return this;
    }
    public InvoiceRequest<T> groupByCustomer(){
       groupBy(Invoice.CUSTOMER_PROPERTY);
       return this;
    }

    public InvoiceRequest<T> groupByCustomerAs(String retName){
       groupBy(retName, Invoice.CUSTOMER_PROPERTY);
       return this;
    }

    public InvoiceRequest<T> groupByCustomerWithFunction(String retName, AggrFunction function){
       groupBy(retName, Invoice.CUSTOMER_PROPERTY, function);
       return this;
    }

    public InvoiceRequest<T> groupByDueDate(){
       groupBy(Invoice.DUE_DATE_PROPERTY);
       return this;
    }

    public InvoiceRequest<T> groupByDueDateAs(String retName){
       groupBy(retName, Invoice.DUE_DATE_PROPERTY);
       return this;
    }

    public InvoiceRequest<T> groupByDueDateWithFunction(String retName, AggrFunction function){
       groupBy(retName, Invoice.DUE_DATE_PROPERTY, function);
       return this;
    }
    public InvoiceRequest<T> groupByGlobalOrderWith(GlobalOrderRequest subRequest){
       groupBy(Invoice.GLOBAL_ORDER_PROPERTY, subRequest);
       return this;
    }
    public InvoiceRequest<T> groupByGlobalOrder(){
       groupBy(Invoice.GLOBAL_ORDER_PROPERTY);
       return this;
    }

    public InvoiceRequest<T> groupByGlobalOrderAs(String retName){
       groupBy(retName, Invoice.GLOBAL_ORDER_PROPERTY);
       return this;
    }

    public InvoiceRequest<T> groupByGlobalOrderWithFunction(String retName, AggrFunction function){
       groupBy(retName, Invoice.GLOBAL_ORDER_PROPERTY, function);
       return this;
    }

    public InvoiceRequest<T> groupByIssueDate(){
       groupBy(Invoice.ISSUE_DATE_PROPERTY);
       return this;
    }

    public InvoiceRequest<T> groupByIssueDateAs(String retName){
       groupBy(retName, Invoice.ISSUE_DATE_PROPERTY);
       return this;
    }

    public InvoiceRequest<T> groupByIssueDateWithFunction(String retName, AggrFunction function){
       groupBy(retName, Invoice.ISSUE_DATE_PROPERTY, function);
       return this;
    }

    public InvoiceRequest<T> groupByStatus(){
       groupBy(Invoice.STATUS_PROPERTY);
       return this;
    }

    public InvoiceRequest<T> groupByStatusAs(String retName){
       groupBy(retName, Invoice.STATUS_PROPERTY);
       return this;
    }

    public InvoiceRequest<T> groupByStatusWithFunction(String retName, AggrFunction function){
       groupBy(retName, Invoice.STATUS_PROPERTY, function);
       return this;
    }

    public InvoiceRequest<T> groupByCreateTime(){
       groupBy(Invoice.CREATE_TIME_PROPERTY);
       return this;
    }

    public InvoiceRequest<T> groupByCreateTimeAs(String retName){
       groupBy(retName, Invoice.CREATE_TIME_PROPERTY);
       return this;
    }

    public InvoiceRequest<T> groupByCreateTimeWithFunction(String retName, AggrFunction function){
       groupBy(retName, Invoice.CREATE_TIME_PROPERTY, function);
       return this;
    }

    public InvoiceRequest<T> groupByUpdateTime(){
       groupBy(Invoice.UPDATE_TIME_PROPERTY);
       return this;
    }

    public InvoiceRequest<T> groupByUpdateTimeAs(String retName){
       groupBy(retName, Invoice.UPDATE_TIME_PROPERTY);
       return this;
    }

    public InvoiceRequest<T> groupByUpdateTimeWithFunction(String retName, AggrFunction function){
       groupBy(retName, Invoice.UPDATE_TIME_PROPERTY, function);
       return this;
    }

    public InvoiceRequest<T> groupByVersion(){
       groupBy(Invoice.VERSION_PROPERTY);
       return this;
    }

    public InvoiceRequest<T> groupByVersionAs(String retName){
       groupBy(retName, Invoice.VERSION_PROPERTY);
       return this;
    }

    public InvoiceRequest<T> groupByVersionWithFunction(String retName, AggrFunction function){
       groupBy(retName, Invoice.VERSION_PROPERTY, function);
       return this;
    }



    public InvoiceRequest<T> orderByIdAscending(){
       addOrderByAscending(Invoice.ID_PROPERTY);
       return this;
    }

    public InvoiceRequest<T> orderByIdDescending(){
       addOrderByDescending(Invoice.ID_PROPERTY);
       return this;
    }

    public InvoiceRequest<T> orderByAmountAscending(){
       addOrderByAscending(Invoice.AMOUNT_PROPERTY);
       return this;
    }

    public InvoiceRequest<T> orderByAmountDescending(){
       addOrderByDescending(Invoice.AMOUNT_PROPERTY);
       return this;
    }

    public InvoiceRequest<T> orderByCustomerAscending(){
       addOrderByAscending(Invoice.CUSTOMER_PROPERTY);
       return this;
    }

    public InvoiceRequest<T> orderByCustomerDescending(){
       addOrderByDescending(Invoice.CUSTOMER_PROPERTY);
       return this;
    }

    public InvoiceRequest<T> orderByDueDateAscending(){
       addOrderByAscending(Invoice.DUE_DATE_PROPERTY);
       return this;
    }

    public InvoiceRequest<T> orderByDueDateDescending(){
       addOrderByDescending(Invoice.DUE_DATE_PROPERTY);
       return this;
    }

    public InvoiceRequest<T> orderByGlobalOrderAscending(){
       addOrderByAscending(Invoice.GLOBAL_ORDER_PROPERTY);
       return this;
    }

    public InvoiceRequest<T> orderByGlobalOrderDescending(){
       addOrderByDescending(Invoice.GLOBAL_ORDER_PROPERTY);
       return this;
    }

    public InvoiceRequest<T> orderByIssueDateAscending(){
       addOrderByAscending(Invoice.ISSUE_DATE_PROPERTY);
       return this;
    }

    public InvoiceRequest<T> orderByIssueDateDescending(){
       addOrderByDescending(Invoice.ISSUE_DATE_PROPERTY);
       return this;
    }

    public InvoiceRequest<T> orderByStatusAscending(){
       addOrderByAscending(Invoice.STATUS_PROPERTY);
       return this;
    }

    public InvoiceRequest<T> orderByStatusDescending(){
       addOrderByDescending(Invoice.STATUS_PROPERTY);
       return this;
    }
    public InvoiceRequest<T> orderByStatusAscendingUsingGBK(){
       addOrderByAscendingUsingGBK(Invoice.STATUS_PROPERTY);
       return this;
    }

    public InvoiceRequest<T> orderByStatusDescendingUsingGBK(){
       addOrderByDescendingUsingGBK(Invoice.STATUS_PROPERTY);
       return this;
    }
    public InvoiceRequest<T> orderByCreateTimeAscending(){
       addOrderByAscending(Invoice.CREATE_TIME_PROPERTY);
       return this;
    }

    public InvoiceRequest<T> orderByCreateTimeDescending(){
       addOrderByDescending(Invoice.CREATE_TIME_PROPERTY);
       return this;
    }

    public InvoiceRequest<T> orderByUpdateTimeAscending(){
       addOrderByAscending(Invoice.UPDATE_TIME_PROPERTY);
       return this;
    }

    public InvoiceRequest<T> orderByUpdateTimeDescending(){
       addOrderByDescending(Invoice.UPDATE_TIME_PROPERTY);
       return this;
    }

    public InvoiceRequest<T> orderByVersionAscending(){
       addOrderByAscending(Invoice.VERSION_PROPERTY);
       return this;
    }

    public InvoiceRequest<T> orderByVersionDescending(){
       addOrderByDescending(Invoice.VERSION_PROPERTY);
       return this;
    }


    public InvoiceRequest<T> statsFromPaymentsAs(String name, PaymentRequest subRequest){
       return statsFromPaymentsAs(name, subRequest, false);
    }

    public InvoiceRequest<T> statsFromPaymentsAs(String name, PaymentRequest subRequest, boolean singleResult){
       subRequest.setPartitionProperty(Payment.INVOICE_PROPERTY);
       addAggregateDynamicProperty(name, subRequest, singleResult);
       return this;
    }

    public InvoiceRequest<T> statsFromPayments(PaymentRequest subRequest){
       return statsFromPaymentsAs(REFINEMENTS, subRequest);
    }
    public CustomerRequest rollUpToCustomer(){
       CustomerRequest customer = Q.customers().unlimited();
       this.withCustomerMatching(customer)
           .groupByCustomerWith(customer);
       return customer;
    }


    public GlobalOrderRequest rollUpToGlobalOrder(){
       GlobalOrderRequest globalOrder = Q.globalOrders().unlimited();
       this.withGlobalOrderMatching(globalOrder)
           .groupByGlobalOrderWith(globalOrder);
       return globalOrder;
    }






    public InvoiceRequest<T> countPayments(){
        return countPaymentsAs("Count");
    }

    public InvoiceRequest<T> countPaymentsAs(String name){
        return countPaymentsWith(name, Q.payments().unlimited());
    }

    public InvoiceRequest<T> countPaymentsWith(String name, PaymentRequest subRequest){
        return statsFromPaymentsAs(name, subRequest.count(), true);
    }
    public InvoiceRequest<T> minAmountOfPayments(){
        return minAmountOfPaymentsAs("minAmountOfPayments");
    }

    public InvoiceRequest<T> minAmountOfPaymentsAs(String name){
        return minAmountOfPaymentsAs(name, Q.payments().unlimited());
    }

    public InvoiceRequest<T> minAmountOfPaymentsAs(String name, PaymentRequest subRequest){
        return statsFromPaymentsAs(name, subRequest.minAmount(), true);
    }
    public InvoiceRequest<T> maxAmountOfPayments(){
        return maxAmountOfPaymentsAs("maxAmountOfPayments");
    }

    public InvoiceRequest<T> maxAmountOfPaymentsAs(String name){
        return maxAmountOfPaymentsAs(name, Q.payments().unlimited());
    }

    public InvoiceRequest<T> maxAmountOfPaymentsAs(String name, PaymentRequest subRequest){
        return statsFromPaymentsAs(name, subRequest.maxAmount(), true);
    }
    public InvoiceRequest<T> sumAmountOfPayments(){
        return sumAmountOfPaymentsAs("sumAmountOfPayments");
    }

    public InvoiceRequest<T> sumAmountOfPaymentsAs(String name){
        return sumAmountOfPaymentsAs(name, Q.payments().unlimited());
    }

    public InvoiceRequest<T> sumAmountOfPaymentsAs(String name, PaymentRequest subRequest){
        return statsFromPaymentsAs(name, subRequest.sumAmount(), true);
    }
    public InvoiceRequest<T> avgAmountOfPayments(){
        return avgAmountOfPaymentsAs("avgAmountOfPayments");
    }

    public InvoiceRequest<T> avgAmountOfPaymentsAs(String name){
        return avgAmountOfPaymentsAs(name, Q.payments().unlimited());
    }

    public InvoiceRequest<T> avgAmountOfPaymentsAs(String name, PaymentRequest subRequest){
        return statsFromPaymentsAs(name, subRequest.avgAmount(), true);
    }
    public InvoiceRequest<T> standardDeviationAmountOfPayments(){
        return standardDeviationAmountOfPaymentsAs("stdDevAmountOfPayments");
    }

    public InvoiceRequest<T> standardDeviationAmountOfPaymentsAs(String name){
        return standardDeviationAmountOfPaymentsAs(name, Q.payments().unlimited());
    }

    public InvoiceRequest<T> standardDeviationAmountOfPaymentsAs(String name, PaymentRequest subRequest){
        return statsFromPaymentsAs(name, subRequest.standardDeviationAmount(), true);
    }
    public InvoiceRequest<T> squareRootOfPopulationStandardDeviationAmountOfPayments(){
        return squareRootOfPopulationStandardDeviationAmountOfPaymentsAs("stdDevPopAmountOfPayments");
    }

    public InvoiceRequest<T> squareRootOfPopulationStandardDeviationAmountOfPaymentsAs(String name){
        return squareRootOfPopulationStandardDeviationAmountOfPaymentsAs(name, Q.payments().unlimited());
    }

    public InvoiceRequest<T> squareRootOfPopulationStandardDeviationAmountOfPaymentsAs(String name, PaymentRequest subRequest){
        return statsFromPaymentsAs(name, subRequest.squareRootOfPopulationStandardDeviationAmount(), true);
    }
    public InvoiceRequest<T> sampleVarianceAmountOfPayments(){
        return sampleVarianceAmountOfPaymentsAs("varSampAmountOfPayments");
    }

    public InvoiceRequest<T> sampleVarianceAmountOfPaymentsAs(String name){
        return sampleVarianceAmountOfPaymentsAs(name, Q.payments().unlimited());
    }

    public InvoiceRequest<T> sampleVarianceAmountOfPaymentsAs(String name, PaymentRequest subRequest){
        return statsFromPaymentsAs(name, subRequest.sampleVarianceAmount(), true);
    }
    public InvoiceRequest<T> samplePopulationVarianceAmountOfPayments(){
        return samplePopulationVarianceAmountOfPaymentsAs("varPopAmountOfPayments");
    }

    public InvoiceRequest<T> samplePopulationVarianceAmountOfPaymentsAs(String name){
        return samplePopulationVarianceAmountOfPaymentsAs(name, Q.payments().unlimited());
    }

    public InvoiceRequest<T> samplePopulationVarianceAmountOfPaymentsAs(String name, PaymentRequest subRequest){
        return statsFromPaymentsAs(name, subRequest.samplePopulationVarianceAmount(), true);
    }

   public InvoiceRequest<T> facetByCustomerAs(String facetName, CustomerRequest customer){
       return facetByCustomerAs(facetName, customer, true);
   }

   public InvoiceRequest<T> facetByCustomerAs(String facetName, CustomerRequest customer, boolean includeAllFacets){
       addFacet(facetName, Invoice.CUSTOMER_PROPERTY, customer, includeAllFacets);
       return this;
   }
   public InvoiceRequest<T> facetByGlobalOrderAs(String facetName, GlobalOrderRequest globalOrder){
       return facetByGlobalOrderAs(facetName, globalOrder, true);
   }

   public InvoiceRequest<T> facetByGlobalOrderAs(String facetName, GlobalOrderRequest globalOrder, boolean includeAllFacets){
       addFacet(facetName, Invoice.GLOBAL_ORDER_PROPERTY, globalOrder, includeAllFacets);
       return this;
   }


    /**
     * get topN records
     * @param topN  records number
     */
    public InvoiceRequest<T> top(int topN) {
        super.top(topN);
        return this;
    }

    /**
     * get records from offset(inclusive) to offset+size(exclusive)
     * @param offset record offset
     * @param size records number
     */
    public InvoiceRequest<T> offset(int offset, int size) {
        super.offset(offset, size);
        return this;
    }

    /**
     * retrieve all records
     */
    public InvoiceRequest<T> unlimited() {
        super.unlimited();
        return this;
    }

    /**
     * get records of one page
     * @param pageNumber page number(1-based)
     * @param pageSize page size
     */
    public InvoiceRequest<T> page(int pageNumber, int pageSize) {
        int offset = (pageNumber - 1) * pageSize;
        return offset(offset, pageSize);
   }

    /**
     * get records of one page, default page size is 10
     * @param pageNumber page number(1-based)
     */
    public InvoiceRequest<T> page(int pageNumber) {
        return page(pageNumber, 10);
   }
}