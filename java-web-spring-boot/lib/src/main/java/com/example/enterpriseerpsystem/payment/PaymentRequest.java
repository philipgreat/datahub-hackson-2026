
package com.example.enterpriseerpsystem.payment;

import com.example.enterpriseerpsystem.Q;
import com.example.enterpriseerpsystem.invoice.Invoice;
import com.example.enterpriseerpsystem.invoice.InvoiceRequest;
import com.example.enterpriseerpsystem.refund.Refund;
import com.example.enterpriseerpsystem.refund.RefundRequest;
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

public class PaymentRequest<T extends Payment> extends BaseRequest<T> {

    /**
     * @deprecated AI agents and business code must use the generated Q facade
     *             instead of constructing request builders directly.
     */
    @Deprecated
    public PaymentRequest(Class<T> returnType){
        super(returnType);
        selectId();
        selectVersion();
    }

    public PaymentRequest<T> comment(String comment){
         super.internalComment(comment);
         return this;
    }

    // purpose() 继承自 BaseRequest，返回 ExecutableRequest（终结方法）

    public PaymentRequest<T> returnType(Class<? extends T> returnType){
        super.setReturnType(returnType);
        return this;
    }

    public PaymentRequest<T> enableAggregationCache(long cacheExpiredMillis){
        super.enableAggregationCache();
        super.aggregateCacheTime(cacheExpiredMillis);
        return this;
    }

    public PaymentRequest<T> enableAggregationCache(){
        return enableAggregationCache(0l);
    }


    public PaymentRequest<T> propagateAggregationCache(long cacheExpiredMillis){
        super.propagateAggregationCache(cacheExpiredMillis);
        return this;
    }

    public PaymentRequest<T> appendSearchCriteria(SearchCriteria searchCriteria){
        return (PaymentRequest<T>)super.appendSearchCriteria(searchCriteria);
    }

    public PaymentRequest<T> filter(String property1, Operator operator, String property2){
        return appendSearchCriteria(new TwoOperatorCriteria(operator, new PropertyReference(property1), new PropertyReference(property2)));
    }


    public PaymentRequest<T> matchingAnyOf(PaymentRequest payment){
        super.internalMatchAny(payment);
        return this;
    }

    public PaymentRequest<T> enhanceChildrenIfNeeded(){
        return this;
    }

    public PaymentRequest<T> withDeletedRows(){
        super.withDeletedRows();
        return this;
    }

    public PaymentRequest<T> deletedRowsOnly(){
        super.deletedRowsOnly();
        return this;
    }

    public PaymentRequest<T> selectSelf(){
        super.selectSelf();
        return selectId().selectAmount().selectCardLast4().selectPaymentDate().selectInvoiceIdOnly().selectMethod().selectStatus().selectCreateTime().selectUpdateTime().selectVersion();
    }

    public PaymentRequest<T> selectSelfFields(){
        return selectSelf();
    }

    public PaymentRequest<T> selectAll(){
        super.selectAll();
        return selectId().selectAmount().selectCardLast4().selectPaymentDate().selectInvoice().selectMethod().selectStatus().selectCreateTime().selectUpdateTime().selectVersion();
    }

    public PaymentRequest<T> selectChildren(){
        super.selectAny();
        selectRefundList();
        return selectId().selectAmount().selectCardLast4().selectPaymentDate().selectInvoice().selectMethod().selectStatus().selectCreateTime().selectUpdateTime().selectVersion();
    }


    public PaymentRequest<T> selectId(){
       selectProperty(Payment.ID_PROPERTY);
       return this;
    }

    /**
     * fill the id with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  id) to fetch id property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public PaymentRequest<T> unselectId(){
       unselectProperty(Payment.ID_PROPERTY);
       return this;
    }
    public PaymentRequest<T> selectAmount(){
       selectProperty(Payment.AMOUNT_PROPERTY);
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
    public PaymentRequest<T> selectAmount(AggrFunction aggrFunction){
       selectProperty(Payment.AMOUNT_PROPERTY, aggrFunction);
       return this;
    }


    public PaymentRequest<T> unselectAmount(){
       unselectProperty(Payment.AMOUNT_PROPERTY);
       return this;
    }
    public PaymentRequest<T> selectCardLast4(){
       selectProperty(Payment.CARD_LAST4_PROPERTY);
       return this;
    }

    /**
     * fill the cardLast4 with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  cardLast4) to fetch cardLast4 property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public PaymentRequest<T> unselectCardLast4(){
       unselectProperty(Payment.CARD_LAST4_PROPERTY);
       return this;
    }
    public PaymentRequest<T> selectPaymentDate(){
       selectProperty(Payment.PAYMENT_DATE_PROPERTY);
       return this;
    }

    /**
     * fill the paymentDate with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  paymentDate) to fetch paymentDate property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public PaymentRequest<T> unselectPaymentDate(){
       unselectProperty(Payment.PAYMENT_DATE_PROPERTY);
       return this;
    }
    public PaymentRequest<T> selectInvoiceIdOnly(){
       selectProperty(Payment.INVOICE_PROPERTY);
       return this;
    }

    public PaymentRequest<T> selectInvoice(){
        return selectInvoiceWith(Q.invoices().unlimited().selectSelf());
    }

    public PaymentRequest<T> selectInvoiceWith(InvoiceRequest invoice){
       selectProperty(Payment.INVOICE_PROPERTY);
       enhanceRelation(Payment.INVOICE_PROPERTY, invoice);
       return this;
    }

    public PaymentRequest<T> unselectInvoice(){
       unselectProperty(Payment.INVOICE_PROPERTY);
       return this;
    }
    public PaymentRequest<T> selectMethod(){
       selectProperty(Payment.METHOD_PROPERTY);
       return this;
    }

    /**
     * fill the method with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  method) to fetch method property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public PaymentRequest<T> unselectMethod(){
       unselectProperty(Payment.METHOD_PROPERTY);
       return this;
    }
    public PaymentRequest<T> selectStatus(){
       selectProperty(Payment.STATUS_PROPERTY);
       return this;
    }

    /**
     * fill the status with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  status) to fetch status property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public PaymentRequest<T> unselectStatus(){
       unselectProperty(Payment.STATUS_PROPERTY);
       return this;
    }
    public PaymentRequest<T> selectCreateTime(){
       selectProperty(Payment.CREATE_TIME_PROPERTY);
       return this;
    }

    /**
     * fill the createTime with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  createTime) to fetch createTime property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public PaymentRequest<T> unselectCreateTime(){
       unselectProperty(Payment.CREATE_TIME_PROPERTY);
       return this;
    }
    public PaymentRequest<T> selectUpdateTime(){
       selectProperty(Payment.UPDATE_TIME_PROPERTY);
       return this;
    }

    /**
     * fill the updateTime with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  updateTime) to fetch updateTime property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public PaymentRequest<T> unselectUpdateTime(){
       unselectProperty(Payment.UPDATE_TIME_PROPERTY);
       return this;
    }
    public PaymentRequest<T> selectVersion(){
       selectProperty(Payment.VERSION_PROPERTY);
       return this;
    }

    /**
     * fill the version with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  version) to fetch version property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public PaymentRequest<T> unselectVersion(){
       unselectProperty(Payment.VERSION_PROPERTY);
       return this;
    }
    public PaymentRequest<T> selectRefundList(){
       return selectRefundListWith(Q.refunds().selectSelf());
    }

    public PaymentRequest<T> selectRefundListWith(RefundRequest refundList){
       enhanceRelation(Payment.REFUND_LIST_PROPERTY, refundList);
       return this;
    }

    public PaymentRequest<T> withId(Operator operator, Object... values){
       return appendSearchCriteria(createIdCriteria(operator, values));
    }

    public SearchCriteria createIdCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Payment.ID_PROPERTY, operator, values);
    }

    public PaymentRequest<T> withIdIs(Long id){
       return withId(Operator.EQUAL, id);
    }
    public PaymentRequest<T> withIdIn(Long... id){
       return withId(Operator.EQUAL, (Object[])id);
    }



    public PaymentRequest<T> filterByAmount(BigDecimal... amount){
      if (amount == null || amount.length == 0) {
        throw new IllegalArgumentException("filterByAmount parameter amount cannot be empty");
      }
      return appendSearchCriteria(createAmountCriteria(Operator.EQUAL, (Object[])amount));
    }

    public PaymentRequest<T> withAmount(Operator operator, Object... values){
       return appendSearchCriteria(createAmountCriteria(operator, values));
    }

    public PaymentRequest<T> withAmountIsUnknown(){
       return withAmount(Operator.IS_NULL);
    }

    public PaymentRequest<T> withAmountIsKnown(){
       return withAmount(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createAmountCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Payment.AMOUNT_PROPERTY, operator, values);
    }

    public PaymentRequest<T> withAmountGreaterThan(BigDecimal amount){
       return withAmount(Operator.GREATER_THAN, amount);
    }

    public PaymentRequest<T> withAmountGreaterThanOrEqualTo(BigDecimal amount){
       return withAmount(Operator.GREATER_THAN_OR_EQUAL, amount);
    }

    public PaymentRequest<T> withAmountLessThan(BigDecimal amount){
       return withAmount(Operator.LESS_THAN, amount);
    }

    public PaymentRequest<T> withAmountLessThanOrEqualTo(BigDecimal amount){
       return withAmount(Operator.LESS_THAN_OR_EQUAL, amount);
    }

    public PaymentRequest<T> withAmountBetween(BigDecimal startOfAmount, BigDecimal endOfAmount){
       return withAmount(Operator.BETWEEN, startOfAmount, endOfAmount);
    }



    public PaymentRequest<T> filterByCardLast4(String... cardLast4){
      if (cardLast4 == null || cardLast4.length == 0) {
        throw new IllegalArgumentException("filterByCardLast4 parameter cardLast4 cannot be empty");
      }
      return appendSearchCriteria(createCardLast4Criteria(Operator.EQUAL, (Object[])cardLast4));
    }

    public PaymentRequest<T> withCardLast4(Operator operator, Object... values){
       return appendSearchCriteria(createCardLast4Criteria(operator, values));
    }

    public PaymentRequest<T> withCardLast4IsUnknown(){
       return withCardLast4(Operator.IS_NULL);
    }

    public PaymentRequest<T> withCardLast4IsKnown(){
       return withCardLast4(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createCardLast4Criteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Payment.CARD_LAST4_PROPERTY, operator, values);
    }

    public PaymentRequest<T> withCardLast4GreaterThan(String cardLast4){
       return withCardLast4(Operator.GREATER_THAN, cardLast4);
    }

    public PaymentRequest<T> withCardLast4GreaterThanOrEqualTo(String cardLast4){
       return withCardLast4(Operator.GREATER_THAN_OR_EQUAL, cardLast4);
    }

    public PaymentRequest<T> withCardLast4LessThan(String cardLast4){
       return withCardLast4(Operator.LESS_THAN, cardLast4);
    }

    public PaymentRequest<T> withCardLast4LessThanOrEqualTo(String cardLast4){
       return withCardLast4(Operator.LESS_THAN_OR_EQUAL, cardLast4);
    }

    public PaymentRequest<T> withCardLast4Between(String startOfCardLast4, String endOfCardLast4){
       return withCardLast4(Operator.BETWEEN, startOfCardLast4, endOfCardLast4);
    }
    public PaymentRequest<T> withCardLast4StartingWith(String cardLast4){
       return withCardLast4(Operator.BEGIN_WITH, cardLast4);
    }
    public PaymentRequest<T> withCardLast4Containing(String cardLast4){
       return withCardLast4(Operator.CONTAIN, cardLast4);
    }

    public PaymentRequest<T> withCardLast4EndingWith(String cardLast4){
       return withCardLast4(Operator.END_WITH, cardLast4);
    }

    public PaymentRequest<T> withCardLast4Is(String cardLast4){
       return withCardLast4(Operator.EQUAL, cardLast4);
    }

    public PaymentRequest<T> withCardLast4SoundingLike(String cardLast4){
       return withCardLast4(Operator.SOUNDS_LIKE, cardLast4);
    }



    public PaymentRequest<T> filterByPaymentDate(LocalDateTime... paymentDate){
      if (paymentDate == null || paymentDate.length == 0) {
        throw new IllegalArgumentException("filterByPaymentDate parameter paymentDate cannot be empty");
      }
      return appendSearchCriteria(createPaymentDateCriteria(Operator.EQUAL, (Object[])paymentDate));
    }

    public PaymentRequest<T> withPaymentDate(Operator operator, Object... values){
       return appendSearchCriteria(createPaymentDateCriteria(operator, values));
    }

    public PaymentRequest<T> withPaymentDateIsUnknown(){
       return withPaymentDate(Operator.IS_NULL);
    }

    public PaymentRequest<T> withPaymentDateIsKnown(){
       return withPaymentDate(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createPaymentDateCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Payment.PAYMENT_DATE_PROPERTY, operator, values);
    }

    public PaymentRequest<T> withPaymentDateGreaterThan(LocalDateTime paymentDate){
       return withPaymentDate(Operator.GREATER_THAN, paymentDate);
    }

    public PaymentRequest<T> withPaymentDateGreaterThanOrEqualTo(LocalDateTime paymentDate){
       return withPaymentDate(Operator.GREATER_THAN_OR_EQUAL, paymentDate);
    }

    public PaymentRequest<T> withPaymentDateLessThan(LocalDateTime paymentDate){
       return withPaymentDate(Operator.LESS_THAN, paymentDate);
    }

    public PaymentRequest<T> withPaymentDateLessThanOrEqualTo(LocalDateTime paymentDate){
       return withPaymentDate(Operator.LESS_THAN_OR_EQUAL, paymentDate);
    }

    public PaymentRequest<T> withPaymentDateBetween(LocalDateTime startOfPaymentDate, LocalDateTime endOfPaymentDate){
       return withPaymentDate(Operator.BETWEEN, startOfPaymentDate, endOfPaymentDate);
    }
    public PaymentRequest<T> withPaymentDateBefore(LocalDateTime paymentDate){
       return withPaymentDate(Operator.LESS_THAN, paymentDate);
    }

    public PaymentRequest<T> withPaymentDateBefore(Date paymentDate){
       return withPaymentDate(Operator.LESS_THAN, paymentDate);
    }

    public PaymentRequest<T> withPaymentDateAfter(LocalDateTime paymentDate){
       return withPaymentDate(Operator.GREATER_THAN, paymentDate);
    }

    public PaymentRequest<T> withPaymentDateAfter(Date paymentDate){
       return withPaymentDate(Operator.GREATER_THAN, paymentDate);
    }

    public PaymentRequest<T> withPaymentDateBetween(Date startOfPaymentDate, Date endOfPaymentDate){
       return withPaymentDate(Operator.BETWEEN, startOfPaymentDate, endOfPaymentDate);
    }




    public PaymentRequest<T> filterByInvoice(Invoice... invoice){
      if (invoice == null || invoice.length == 0) {
        throw new IllegalArgumentException("filterByInvoice parameter invoice cannot be empty");
      }
      return appendSearchCriteria(createInvoiceCriteria(Operator.EQUAL, (Object[])invoice));
    }

    public PaymentRequest<T> withInvoice(Operator operator, Object... values){
       return appendSearchCriteria(createInvoiceCriteria(operator, values));
    }

    public PaymentRequest<T> withInvoiceIsUnknown(){
       return withInvoice(Operator.IS_NULL);
    }

    public PaymentRequest<T> withInvoiceIsKnown(){
       return withInvoice(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createInvoiceCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Payment.INVOICE_PROPERTY, operator, values);
    }

    public PaymentRequest<T> filterByInvoice(Long invoice){
      if(invoice == null){
         return this;
      }
      return withInvoice(Operator.EQUAL, invoice);
    }
    public PaymentRequest<T> withInvoiceMatching(InvoiceRequest invoice){
       return appendSearchCriteria(new SubQuerySearchCriteria(Payment.INVOICE_PROPERTY, invoice, Invoice.ID_PROPERTY));
    }

    public PaymentRequest<T> filterByMethod(String... method){
      if (method == null || method.length == 0) {
        throw new IllegalArgumentException("filterByMethod parameter method cannot be empty");
      }
      return appendSearchCriteria(createMethodCriteria(Operator.EQUAL, (Object[])method));
    }

    public PaymentRequest<T> withMethod(Operator operator, Object... values){
       return appendSearchCriteria(createMethodCriteria(operator, values));
    }

    public PaymentRequest<T> withMethodIsUnknown(){
       return withMethod(Operator.IS_NULL);
    }

    public PaymentRequest<T> withMethodIsKnown(){
       return withMethod(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createMethodCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Payment.METHOD_PROPERTY, operator, values);
    }

    public PaymentRequest<T> withMethodGreaterThan(String method){
       return withMethod(Operator.GREATER_THAN, method);
    }

    public PaymentRequest<T> withMethodGreaterThanOrEqualTo(String method){
       return withMethod(Operator.GREATER_THAN_OR_EQUAL, method);
    }

    public PaymentRequest<T> withMethodLessThan(String method){
       return withMethod(Operator.LESS_THAN, method);
    }

    public PaymentRequest<T> withMethodLessThanOrEqualTo(String method){
       return withMethod(Operator.LESS_THAN_OR_EQUAL, method);
    }

    public PaymentRequest<T> withMethodBetween(String startOfMethod, String endOfMethod){
       return withMethod(Operator.BETWEEN, startOfMethod, endOfMethod);
    }
    public PaymentRequest<T> withMethodStartingWith(String method){
       return withMethod(Operator.BEGIN_WITH, method);
    }
    public PaymentRequest<T> withMethodContaining(String method){
       return withMethod(Operator.CONTAIN, method);
    }

    public PaymentRequest<T> withMethodEndingWith(String method){
       return withMethod(Operator.END_WITH, method);
    }

    public PaymentRequest<T> withMethodIs(String method){
       return withMethod(Operator.EQUAL, method);
    }

    public PaymentRequest<T> withMethodSoundingLike(String method){
       return withMethod(Operator.SOUNDS_LIKE, method);
    }



    public PaymentRequest<T> filterByStatus(String... status){
      if (status == null || status.length == 0) {
        throw new IllegalArgumentException("filterByStatus parameter status cannot be empty");
      }
      return appendSearchCriteria(createStatusCriteria(Operator.EQUAL, (Object[])status));
    }

    public PaymentRequest<T> withStatus(Operator operator, Object... values){
       return appendSearchCriteria(createStatusCriteria(operator, values));
    }

    public PaymentRequest<T> withStatusIsUnknown(){
       return withStatus(Operator.IS_NULL);
    }

    public PaymentRequest<T> withStatusIsKnown(){
       return withStatus(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createStatusCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Payment.STATUS_PROPERTY, operator, values);
    }

    public PaymentRequest<T> withStatusGreaterThan(String status){
       return withStatus(Operator.GREATER_THAN, status);
    }

    public PaymentRequest<T> withStatusGreaterThanOrEqualTo(String status){
       return withStatus(Operator.GREATER_THAN_OR_EQUAL, status);
    }

    public PaymentRequest<T> withStatusLessThan(String status){
       return withStatus(Operator.LESS_THAN, status);
    }

    public PaymentRequest<T> withStatusLessThanOrEqualTo(String status){
       return withStatus(Operator.LESS_THAN_OR_EQUAL, status);
    }

    public PaymentRequest<T> withStatusBetween(String startOfStatus, String endOfStatus){
       return withStatus(Operator.BETWEEN, startOfStatus, endOfStatus);
    }
    public PaymentRequest<T> withStatusStartingWith(String status){
       return withStatus(Operator.BEGIN_WITH, status);
    }
    public PaymentRequest<T> withStatusContaining(String status){
       return withStatus(Operator.CONTAIN, status);
    }

    public PaymentRequest<T> withStatusEndingWith(String status){
       return withStatus(Operator.END_WITH, status);
    }

    public PaymentRequest<T> withStatusIs(String status){
       return withStatus(Operator.EQUAL, status);
    }

    public PaymentRequest<T> withStatusSoundingLike(String status){
       return withStatus(Operator.SOUNDS_LIKE, status);
    }



    public PaymentRequest<T> filterByCreateTime(LocalDateTime... createTime){
      if (createTime == null || createTime.length == 0) {
        throw new IllegalArgumentException("filterByCreateTime parameter createTime cannot be empty");
      }
      return appendSearchCriteria(createCreateTimeCriteria(Operator.EQUAL, (Object[])createTime));
    }

    public PaymentRequest<T> withCreateTime(Operator operator, Object... values){
       return appendSearchCriteria(createCreateTimeCriteria(operator, values));
    }

    public PaymentRequest<T> withCreateTimeIsUnknown(){
       return withCreateTime(Operator.IS_NULL);
    }

    public PaymentRequest<T> withCreateTimeIsKnown(){
       return withCreateTime(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createCreateTimeCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Payment.CREATE_TIME_PROPERTY, operator, values);
    }

    public PaymentRequest<T> withCreateTimeGreaterThan(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public PaymentRequest<T> withCreateTimeGreaterThanOrEqualTo(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN_OR_EQUAL, createTime);
    }

    public PaymentRequest<T> withCreateTimeLessThan(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public PaymentRequest<T> withCreateTimeLessThanOrEqualTo(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN_OR_EQUAL, createTime);
    }

    public PaymentRequest<T> withCreateTimeBetween(LocalDateTime startOfCreateTime, LocalDateTime endOfCreateTime){
       return withCreateTime(Operator.BETWEEN, startOfCreateTime, endOfCreateTime);
    }
    public PaymentRequest<T> withCreateTimeBefore(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public PaymentRequest<T> withCreateTimeBefore(Date createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public PaymentRequest<T> withCreateTimeAfter(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public PaymentRequest<T> withCreateTimeAfter(Date createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public PaymentRequest<T> withCreateTimeBetween(Date startOfCreateTime, Date endOfCreateTime){
       return withCreateTime(Operator.BETWEEN, startOfCreateTime, endOfCreateTime);
    }




    public PaymentRequest<T> filterByUpdateTime(LocalDateTime... updateTime){
      if (updateTime == null || updateTime.length == 0) {
        throw new IllegalArgumentException("filterByUpdateTime parameter updateTime cannot be empty");
      }
      return appendSearchCriteria(createUpdateTimeCriteria(Operator.EQUAL, (Object[])updateTime));
    }

    public PaymentRequest<T> withUpdateTime(Operator operator, Object... values){
       return appendSearchCriteria(createUpdateTimeCriteria(operator, values));
    }

    public PaymentRequest<T> withUpdateTimeIsUnknown(){
       return withUpdateTime(Operator.IS_NULL);
    }

    public PaymentRequest<T> withUpdateTimeIsKnown(){
       return withUpdateTime(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createUpdateTimeCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Payment.UPDATE_TIME_PROPERTY, operator, values);
    }

    public PaymentRequest<T> withUpdateTimeGreaterThan(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public PaymentRequest<T> withUpdateTimeGreaterThanOrEqualTo(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN_OR_EQUAL, updateTime);
    }

    public PaymentRequest<T> withUpdateTimeLessThan(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public PaymentRequest<T> withUpdateTimeLessThanOrEqualTo(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN_OR_EQUAL, updateTime);
    }

    public PaymentRequest<T> withUpdateTimeBetween(LocalDateTime startOfUpdateTime, LocalDateTime endOfUpdateTime){
       return withUpdateTime(Operator.BETWEEN, startOfUpdateTime, endOfUpdateTime);
    }
    public PaymentRequest<T> withUpdateTimeBefore(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public PaymentRequest<T> withUpdateTimeBefore(Date updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public PaymentRequest<T> withUpdateTimeAfter(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public PaymentRequest<T> withUpdateTimeAfter(Date updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public PaymentRequest<T> withUpdateTimeBetween(Date startOfUpdateTime, Date endOfUpdateTime){
       return withUpdateTime(Operator.BETWEEN, startOfUpdateTime, endOfUpdateTime);
    }




    public PaymentRequest<T> filterByVersion(Long... version){
      if (version == null || version.length == 0) {
        throw new IllegalArgumentException("filterByVersion parameter version cannot be empty");
      }
      return appendSearchCriteria(createVersionCriteria(Operator.EQUAL, (Object[])version));
    }

    public PaymentRequest<T> withVersion(Operator operator, Object... values){
       return appendSearchCriteria(createVersionCriteria(operator, values));
    }

    public PaymentRequest<T> withVersionIsUnknown(){
       return withVersion(Operator.IS_NULL);
    }

    public PaymentRequest<T> withVersionIsKnown(){
       return withVersion(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createVersionCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Payment.VERSION_PROPERTY, operator, values);
    }

    public PaymentRequest<T> withVersionGreaterThan(Long version){
       return withVersion(Operator.GREATER_THAN, version);
    }

    public PaymentRequest<T> withVersionGreaterThanOrEqualTo(Long version){
       return withVersion(Operator.GREATER_THAN_OR_EQUAL, version);
    }

    public PaymentRequest<T> withVersionLessThan(Long version){
       return withVersion(Operator.LESS_THAN, version);
    }

    public PaymentRequest<T> withVersionLessThanOrEqualTo(Long version){
       return withVersion(Operator.LESS_THAN_OR_EQUAL, version);
    }

    public PaymentRequest<T> withVersionBetween(Long startOfVersion, Long endOfVersion){
       return withVersion(Operator.BETWEEN, startOfVersion, endOfVersion);
    }

    public PaymentRequest<T> withRefundListMatching(RefundRequest refundRequest){
        return appendSearchCriteria(new SubQuerySearchCriteria(Payment.ID_PROPERTY, refundRequest, Refund.PAYMENT_PROPERTY));
    }

    public PaymentRequest<T> withoutRefundListMatching(RefundRequest refundRequest){
        return appendSearchCriteria(SearchCriteria.not(new SubQuerySearchCriteria(Payment.ID_PROPERTY, refundRequest, Refund.PAYMENT_PROPERTY)));
    }

    public PaymentRequest<T> haveRefunds(){
        return withRefundListMatching(Q.refunds().unlimited());
    }

    public PaymentRequest<T> haveNoRefunds(){
        return withoutRefundListMatching(Q.refunds().unlimited());
    }

    public PaymentRequest<T> count(){
        super.count();
        return this;
    }
    public PaymentRequest<T> countAs(String retName){
        super.count(retName);
        return this;
    }
    public PaymentRequest minAmount(){
        return minAmountAs(prefix("minOf",Payment.AMOUNT_PROPERTY));
    }

    public PaymentRequest minAmountAs(String retName){
        super.min(retName, Payment.AMOUNT_PROPERTY);
        return this;
    }
    public PaymentRequest maxAmount(){
        return maxAmountAs(prefix("maxOf",Payment.AMOUNT_PROPERTY));
    }

    public PaymentRequest maxAmountAs(String retName){
        super.max(retName, Payment.AMOUNT_PROPERTY);
        return this;
    }
    public PaymentRequest sumAmount(){
        return sumAmountAs(prefix("sumOf",Payment.AMOUNT_PROPERTY));
    }

    public PaymentRequest sumAmountAs(String retName){
        super.sum(retName, Payment.AMOUNT_PROPERTY);
        return this;
    }
    public PaymentRequest avgAmount(){
        return avgAmountAs(prefix("avgOf",Payment.AMOUNT_PROPERTY));
    }

    public PaymentRequest avgAmountAs(String retName){
        super.avg(retName, Payment.AMOUNT_PROPERTY);
        return this;
    }
    public PaymentRequest standardDeviationAmount(){
        return standardDeviationAmountAs(prefix("standardDeviationOf",Payment.AMOUNT_PROPERTY));
    }

    public PaymentRequest standardDeviationAmountAs(String retName){
        super.standardDeviation(retName, Payment.AMOUNT_PROPERTY);
        return this;
    }
    public PaymentRequest squareRootOfPopulationStandardDeviationAmount(){
        return squareRootOfPopulationStandardDeviationAmountAs(prefix("squareRootOfPopulationStandardDeviationOf",Payment.AMOUNT_PROPERTY));
    }

    public PaymentRequest squareRootOfPopulationStandardDeviationAmountAs(String retName){
        super.squareRootOfPopulationStandardDeviation(retName, Payment.AMOUNT_PROPERTY);
        return this;
    }
    public PaymentRequest sampleVarianceAmount(){
        return sampleVarianceAmountAs(prefix("sampleVarianceOf",Payment.AMOUNT_PROPERTY));
    }

    public PaymentRequest sampleVarianceAmountAs(String retName){
        super.sampleVariance(retName, Payment.AMOUNT_PROPERTY);
        return this;
    }
    public PaymentRequest samplePopulationVarianceAmount(){
        return samplePopulationVarianceAmountAs(prefix("samplePopulationVarianceOf",Payment.AMOUNT_PROPERTY));
    }

    public PaymentRequest samplePopulationVarianceAmountAs(String retName){
        super.samplePopulationVariance(retName, Payment.AMOUNT_PROPERTY);
        return this;
    }
    public PaymentRequest<T> groupByInvoiceWithDetails(){
       return groupByInvoiceWithDetails(Q.invoices().unlimited());
    }

    public PaymentRequest<T> groupByInvoiceWithDetails(InvoiceRequest subRequest){
       aggregate(Payment.INVOICE_PROPERTY, subRequest);
       return this;
    }






    public PaymentRequest<T> groupByRefundsWithDetails(RefundRequest subRequest){
       aggregate(Payment.REFUND_LIST_PROPERTY, subRequest);
       return this;
    }

    public PaymentRequest<T> groupById(){
       groupBy(Payment.ID_PROPERTY);
       return this;
    }

    public PaymentRequest<T> groupByIdAs(String retName){
       groupBy(retName, Payment.ID_PROPERTY);
       return this;
    }

    public PaymentRequest<T> groupByIdWithFunction(String retName, AggrFunction function){
       groupBy(retName, Payment.ID_PROPERTY, function);
       return this;
    }

    public PaymentRequest<T> groupByAmount(){
       groupBy(Payment.AMOUNT_PROPERTY);
       return this;
    }

    public PaymentRequest<T> groupByAmountAs(String retName){
       groupBy(retName, Payment.AMOUNT_PROPERTY);
       return this;
    }

    public PaymentRequest<T> groupByAmountWithFunction(String retName, AggrFunction function){
       groupBy(retName, Payment.AMOUNT_PROPERTY, function);
       return this;
    }

    public PaymentRequest<T> groupByCardLast4(){
       groupBy(Payment.CARD_LAST4_PROPERTY);
       return this;
    }

    public PaymentRequest<T> groupByCardLast4As(String retName){
       groupBy(retName, Payment.CARD_LAST4_PROPERTY);
       return this;
    }

    public PaymentRequest<T> groupByCardLast4WithFunction(String retName, AggrFunction function){
       groupBy(retName, Payment.CARD_LAST4_PROPERTY, function);
       return this;
    }

    public PaymentRequest<T> groupByPaymentDate(){
       groupBy(Payment.PAYMENT_DATE_PROPERTY);
       return this;
    }

    public PaymentRequest<T> groupByPaymentDateAs(String retName){
       groupBy(retName, Payment.PAYMENT_DATE_PROPERTY);
       return this;
    }

    public PaymentRequest<T> groupByPaymentDateWithFunction(String retName, AggrFunction function){
       groupBy(retName, Payment.PAYMENT_DATE_PROPERTY, function);
       return this;
    }
    public PaymentRequest<T> groupByInvoiceWith(InvoiceRequest subRequest){
       groupBy(Payment.INVOICE_PROPERTY, subRequest);
       return this;
    }
    public PaymentRequest<T> groupByInvoice(){
       groupBy(Payment.INVOICE_PROPERTY);
       return this;
    }

    public PaymentRequest<T> groupByInvoiceAs(String retName){
       groupBy(retName, Payment.INVOICE_PROPERTY);
       return this;
    }

    public PaymentRequest<T> groupByInvoiceWithFunction(String retName, AggrFunction function){
       groupBy(retName, Payment.INVOICE_PROPERTY, function);
       return this;
    }

    public PaymentRequest<T> groupByMethod(){
       groupBy(Payment.METHOD_PROPERTY);
       return this;
    }

    public PaymentRequest<T> groupByMethodAs(String retName){
       groupBy(retName, Payment.METHOD_PROPERTY);
       return this;
    }

    public PaymentRequest<T> groupByMethodWithFunction(String retName, AggrFunction function){
       groupBy(retName, Payment.METHOD_PROPERTY, function);
       return this;
    }

    public PaymentRequest<T> groupByStatus(){
       groupBy(Payment.STATUS_PROPERTY);
       return this;
    }

    public PaymentRequest<T> groupByStatusAs(String retName){
       groupBy(retName, Payment.STATUS_PROPERTY);
       return this;
    }

    public PaymentRequest<T> groupByStatusWithFunction(String retName, AggrFunction function){
       groupBy(retName, Payment.STATUS_PROPERTY, function);
       return this;
    }

    public PaymentRequest<T> groupByCreateTime(){
       groupBy(Payment.CREATE_TIME_PROPERTY);
       return this;
    }

    public PaymentRequest<T> groupByCreateTimeAs(String retName){
       groupBy(retName, Payment.CREATE_TIME_PROPERTY);
       return this;
    }

    public PaymentRequest<T> groupByCreateTimeWithFunction(String retName, AggrFunction function){
       groupBy(retName, Payment.CREATE_TIME_PROPERTY, function);
       return this;
    }

    public PaymentRequest<T> groupByUpdateTime(){
       groupBy(Payment.UPDATE_TIME_PROPERTY);
       return this;
    }

    public PaymentRequest<T> groupByUpdateTimeAs(String retName){
       groupBy(retName, Payment.UPDATE_TIME_PROPERTY);
       return this;
    }

    public PaymentRequest<T> groupByUpdateTimeWithFunction(String retName, AggrFunction function){
       groupBy(retName, Payment.UPDATE_TIME_PROPERTY, function);
       return this;
    }

    public PaymentRequest<T> groupByVersion(){
       groupBy(Payment.VERSION_PROPERTY);
       return this;
    }

    public PaymentRequest<T> groupByVersionAs(String retName){
       groupBy(retName, Payment.VERSION_PROPERTY);
       return this;
    }

    public PaymentRequest<T> groupByVersionWithFunction(String retName, AggrFunction function){
       groupBy(retName, Payment.VERSION_PROPERTY, function);
       return this;
    }



    public PaymentRequest<T> orderByIdAscending(){
       addOrderByAscending(Payment.ID_PROPERTY);
       return this;
    }

    public PaymentRequest<T> orderByIdDescending(){
       addOrderByDescending(Payment.ID_PROPERTY);
       return this;
    }

    public PaymentRequest<T> orderByAmountAscending(){
       addOrderByAscending(Payment.AMOUNT_PROPERTY);
       return this;
    }

    public PaymentRequest<T> orderByAmountDescending(){
       addOrderByDescending(Payment.AMOUNT_PROPERTY);
       return this;
    }

    public PaymentRequest<T> orderByCardLast4Ascending(){
       addOrderByAscending(Payment.CARD_LAST4_PROPERTY);
       return this;
    }

    public PaymentRequest<T> orderByCardLast4Descending(){
       addOrderByDescending(Payment.CARD_LAST4_PROPERTY);
       return this;
    }
    public PaymentRequest<T> orderByCardLast4AscendingUsingGBK(){
       addOrderByAscendingUsingGBK(Payment.CARD_LAST4_PROPERTY);
       return this;
    }

    public PaymentRequest<T> orderByCardLast4DescendingUsingGBK(){
       addOrderByDescendingUsingGBK(Payment.CARD_LAST4_PROPERTY);
       return this;
    }
    public PaymentRequest<T> orderByPaymentDateAscending(){
       addOrderByAscending(Payment.PAYMENT_DATE_PROPERTY);
       return this;
    }

    public PaymentRequest<T> orderByPaymentDateDescending(){
       addOrderByDescending(Payment.PAYMENT_DATE_PROPERTY);
       return this;
    }

    public PaymentRequest<T> orderByInvoiceAscending(){
       addOrderByAscending(Payment.INVOICE_PROPERTY);
       return this;
    }

    public PaymentRequest<T> orderByInvoiceDescending(){
       addOrderByDescending(Payment.INVOICE_PROPERTY);
       return this;
    }

    public PaymentRequest<T> orderByMethodAscending(){
       addOrderByAscending(Payment.METHOD_PROPERTY);
       return this;
    }

    public PaymentRequest<T> orderByMethodDescending(){
       addOrderByDescending(Payment.METHOD_PROPERTY);
       return this;
    }
    public PaymentRequest<T> orderByMethodAscendingUsingGBK(){
       addOrderByAscendingUsingGBK(Payment.METHOD_PROPERTY);
       return this;
    }

    public PaymentRequest<T> orderByMethodDescendingUsingGBK(){
       addOrderByDescendingUsingGBK(Payment.METHOD_PROPERTY);
       return this;
    }
    public PaymentRequest<T> orderByStatusAscending(){
       addOrderByAscending(Payment.STATUS_PROPERTY);
       return this;
    }

    public PaymentRequest<T> orderByStatusDescending(){
       addOrderByDescending(Payment.STATUS_PROPERTY);
       return this;
    }
    public PaymentRequest<T> orderByStatusAscendingUsingGBK(){
       addOrderByAscendingUsingGBK(Payment.STATUS_PROPERTY);
       return this;
    }

    public PaymentRequest<T> orderByStatusDescendingUsingGBK(){
       addOrderByDescendingUsingGBK(Payment.STATUS_PROPERTY);
       return this;
    }
    public PaymentRequest<T> orderByCreateTimeAscending(){
       addOrderByAscending(Payment.CREATE_TIME_PROPERTY);
       return this;
    }

    public PaymentRequest<T> orderByCreateTimeDescending(){
       addOrderByDescending(Payment.CREATE_TIME_PROPERTY);
       return this;
    }

    public PaymentRequest<T> orderByUpdateTimeAscending(){
       addOrderByAscending(Payment.UPDATE_TIME_PROPERTY);
       return this;
    }

    public PaymentRequest<T> orderByUpdateTimeDescending(){
       addOrderByDescending(Payment.UPDATE_TIME_PROPERTY);
       return this;
    }

    public PaymentRequest<T> orderByVersionAscending(){
       addOrderByAscending(Payment.VERSION_PROPERTY);
       return this;
    }

    public PaymentRequest<T> orderByVersionDescending(){
       addOrderByDescending(Payment.VERSION_PROPERTY);
       return this;
    }


    public PaymentRequest<T> statsFromRefundsAs(String name, RefundRequest subRequest){
       return statsFromRefundsAs(name, subRequest, false);
    }

    public PaymentRequest<T> statsFromRefundsAs(String name, RefundRequest subRequest, boolean singleResult){
       subRequest.setPartitionProperty(Refund.PAYMENT_PROPERTY);
       addAggregateDynamicProperty(name, subRequest, singleResult);
       return this;
    }

    public PaymentRequest<T> statsFromRefunds(RefundRequest subRequest){
       return statsFromRefundsAs(REFINEMENTS, subRequest);
    }
    public InvoiceRequest rollUpToInvoice(){
       InvoiceRequest invoice = Q.invoices().unlimited();
       this.withInvoiceMatching(invoice)
           .groupByInvoiceWith(invoice);
       return invoice;
    }






    public PaymentRequest<T> countRefunds(){
        return countRefundsAs("Count");
    }

    public PaymentRequest<T> countRefundsAs(String name){
        return countRefundsWith(name, Q.refunds().unlimited());
    }

    public PaymentRequest<T> countRefundsWith(String name, RefundRequest subRequest){
        return statsFromRefundsAs(name, subRequest.count(), true);
    }
    public PaymentRequest<T> minAmountOfRefunds(){
        return minAmountOfRefundsAs("minAmountOfRefunds");
    }

    public PaymentRequest<T> minAmountOfRefundsAs(String name){
        return minAmountOfRefundsAs(name, Q.refunds().unlimited());
    }

    public PaymentRequest<T> minAmountOfRefundsAs(String name, RefundRequest subRequest){
        return statsFromRefundsAs(name, subRequest.minAmount(), true);
    }
    public PaymentRequest<T> maxAmountOfRefunds(){
        return maxAmountOfRefundsAs("maxAmountOfRefunds");
    }

    public PaymentRequest<T> maxAmountOfRefundsAs(String name){
        return maxAmountOfRefundsAs(name, Q.refunds().unlimited());
    }

    public PaymentRequest<T> maxAmountOfRefundsAs(String name, RefundRequest subRequest){
        return statsFromRefundsAs(name, subRequest.maxAmount(), true);
    }
    public PaymentRequest<T> sumAmountOfRefunds(){
        return sumAmountOfRefundsAs("sumAmountOfRefunds");
    }

    public PaymentRequest<T> sumAmountOfRefundsAs(String name){
        return sumAmountOfRefundsAs(name, Q.refunds().unlimited());
    }

    public PaymentRequest<T> sumAmountOfRefundsAs(String name, RefundRequest subRequest){
        return statsFromRefundsAs(name, subRequest.sumAmount(), true);
    }
    public PaymentRequest<T> avgAmountOfRefunds(){
        return avgAmountOfRefundsAs("avgAmountOfRefunds");
    }

    public PaymentRequest<T> avgAmountOfRefundsAs(String name){
        return avgAmountOfRefundsAs(name, Q.refunds().unlimited());
    }

    public PaymentRequest<T> avgAmountOfRefundsAs(String name, RefundRequest subRequest){
        return statsFromRefundsAs(name, subRequest.avgAmount(), true);
    }
    public PaymentRequest<T> standardDeviationAmountOfRefunds(){
        return standardDeviationAmountOfRefundsAs("stdDevAmountOfRefunds");
    }

    public PaymentRequest<T> standardDeviationAmountOfRefundsAs(String name){
        return standardDeviationAmountOfRefundsAs(name, Q.refunds().unlimited());
    }

    public PaymentRequest<T> standardDeviationAmountOfRefundsAs(String name, RefundRequest subRequest){
        return statsFromRefundsAs(name, subRequest.standardDeviationAmount(), true);
    }
    public PaymentRequest<T> squareRootOfPopulationStandardDeviationAmountOfRefunds(){
        return squareRootOfPopulationStandardDeviationAmountOfRefundsAs("stdDevPopAmountOfRefunds");
    }

    public PaymentRequest<T> squareRootOfPopulationStandardDeviationAmountOfRefundsAs(String name){
        return squareRootOfPopulationStandardDeviationAmountOfRefundsAs(name, Q.refunds().unlimited());
    }

    public PaymentRequest<T> squareRootOfPopulationStandardDeviationAmountOfRefundsAs(String name, RefundRequest subRequest){
        return statsFromRefundsAs(name, subRequest.squareRootOfPopulationStandardDeviationAmount(), true);
    }
    public PaymentRequest<T> sampleVarianceAmountOfRefunds(){
        return sampleVarianceAmountOfRefundsAs("varSampAmountOfRefunds");
    }

    public PaymentRequest<T> sampleVarianceAmountOfRefundsAs(String name){
        return sampleVarianceAmountOfRefundsAs(name, Q.refunds().unlimited());
    }

    public PaymentRequest<T> sampleVarianceAmountOfRefundsAs(String name, RefundRequest subRequest){
        return statsFromRefundsAs(name, subRequest.sampleVarianceAmount(), true);
    }
    public PaymentRequest<T> samplePopulationVarianceAmountOfRefunds(){
        return samplePopulationVarianceAmountOfRefundsAs("varPopAmountOfRefunds");
    }

    public PaymentRequest<T> samplePopulationVarianceAmountOfRefundsAs(String name){
        return samplePopulationVarianceAmountOfRefundsAs(name, Q.refunds().unlimited());
    }

    public PaymentRequest<T> samplePopulationVarianceAmountOfRefundsAs(String name, RefundRequest subRequest){
        return statsFromRefundsAs(name, subRequest.samplePopulationVarianceAmount(), true);
    }

   public PaymentRequest<T> facetByInvoiceAs(String facetName, InvoiceRequest invoice){
       return facetByInvoiceAs(facetName, invoice, true);
   }

   public PaymentRequest<T> facetByInvoiceAs(String facetName, InvoiceRequest invoice, boolean includeAllFacets){
       addFacet(facetName, Payment.INVOICE_PROPERTY, invoice, includeAllFacets);
       return this;
   }


    /**
     * get topN records
     * @param topN  records number
     */
    public PaymentRequest<T> top(int topN) {
        super.top(topN);
        return this;
    }

    /**
     * get records from offset(inclusive) to offset+size(exclusive)
     * @param offset record offset
     * @param size records number
     */
    public PaymentRequest<T> offset(int offset, int size) {
        super.offset(offset, size);
        return this;
    }

    /**
     * retrieve all records
     */
    public PaymentRequest<T> unlimited() {
        super.unlimited();
        return this;
    }

    /**
     * get records of one page
     * @param pageNumber page number(1-based)
     * @param pageSize page size
     */
    public PaymentRequest<T> page(int pageNumber, int pageSize) {
        int offset = (pageNumber - 1) * pageSize;
        return offset(offset, pageSize);
   }

    /**
     * get records of one page, default page size is 10
     * @param pageNumber page number(1-based)
     */
    public PaymentRequest<T> page(int pageNumber) {
        return page(pageNumber, 10);
   }
}