
package com.example.enterpriseerpsystem.refund;

import com.example.enterpriseerpsystem.Q;
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

public class RefundRequest<T extends Refund> extends BaseRequest<T> {

    /**
     * @deprecated AI agents and business code must use the generated Q facade
     *             instead of constructing request builders directly.
     */
    @Deprecated
    public RefundRequest(Class<T> returnType){
        super(returnType);
        selectId();
        selectVersion();
    }

    public RefundRequest<T> comment(String comment){
         super.internalComment(comment);
         return this;
    }

    // purpose() 继承自 BaseRequest，返回 ExecutableRequest（终结方法）

    public RefundRequest<T> returnType(Class<? extends T> returnType){
        super.setReturnType(returnType);
        return this;
    }

    public RefundRequest<T> enableAggregationCache(long cacheExpiredMillis){
        super.enableAggregationCache();
        super.aggregateCacheTime(cacheExpiredMillis);
        return this;
    }

    public RefundRequest<T> enableAggregationCache(){
        return enableAggregationCache(0l);
    }


    public RefundRequest<T> propagateAggregationCache(long cacheExpiredMillis){
        super.propagateAggregationCache(cacheExpiredMillis);
        return this;
    }

    public RefundRequest<T> appendSearchCriteria(SearchCriteria searchCriteria){
        return (RefundRequest<T>)super.appendSearchCriteria(searchCriteria);
    }

    public RefundRequest<T> filter(String property1, Operator operator, String property2){
        return appendSearchCriteria(new TwoOperatorCriteria(operator, new PropertyReference(property1), new PropertyReference(property2)));
    }


    public RefundRequest<T> matchingAnyOf(RefundRequest refund){
        super.internalMatchAny(refund);
        return this;
    }

    public RefundRequest<T> enhanceChildrenIfNeeded(){
        return this;
    }

    public RefundRequest<T> withDeletedRows(){
        super.withDeletedRows();
        return this;
    }

    public RefundRequest<T> deletedRowsOnly(){
        super.deletedRowsOnly();
        return this;
    }

    public RefundRequest<T> selectSelf(){
        super.selectSelf();
        return selectId().selectAmount().selectPaymentIdOnly().selectProcessedDate().selectReason().selectCreateTime().selectUpdateTime().selectVersion();
    }

    public RefundRequest<T> selectSelfFields(){
        return selectSelf();
    }

    public RefundRequest<T> selectAll(){
        super.selectAll();
        return selectId().selectAmount().selectPayment().selectProcessedDate().selectReason().selectCreateTime().selectUpdateTime().selectVersion();
    }

    public RefundRequest<T> selectChildren(){
        super.selectAny();
        return selectId().selectAmount().selectPayment().selectProcessedDate().selectReason().selectCreateTime().selectUpdateTime().selectVersion();
    }


    public RefundRequest<T> selectId(){
       selectProperty(Refund.ID_PROPERTY);
       return this;
    }

    /**
     * fill the id with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  id) to fetch id property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public RefundRequest<T> unselectId(){
       unselectProperty(Refund.ID_PROPERTY);
       return this;
    }
    public RefundRequest<T> selectAmount(){
       selectProperty(Refund.AMOUNT_PROPERTY);
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
    public RefundRequest<T> selectAmount(AggrFunction aggrFunction){
       selectProperty(Refund.AMOUNT_PROPERTY, aggrFunction);
       return this;
    }


    public RefundRequest<T> unselectAmount(){
       unselectProperty(Refund.AMOUNT_PROPERTY);
       return this;
    }
    public RefundRequest<T> selectPaymentIdOnly(){
       selectProperty(Refund.PAYMENT_PROPERTY);
       return this;
    }

    public RefundRequest<T> selectPayment(){
        return selectPaymentWith(Q.payments().unlimited().selectSelf());
    }

    public RefundRequest<T> selectPaymentWith(PaymentRequest payment){
       selectProperty(Refund.PAYMENT_PROPERTY);
       enhanceRelation(Refund.PAYMENT_PROPERTY, payment);
       return this;
    }

    public RefundRequest<T> unselectPayment(){
       unselectProperty(Refund.PAYMENT_PROPERTY);
       return this;
    }
    public RefundRequest<T> selectProcessedDate(){
       selectProperty(Refund.PROCESSED_DATE_PROPERTY);
       return this;
    }

    /**
     * fill the processedDate with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  processedDate) to fetch processedDate property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public RefundRequest<T> unselectProcessedDate(){
       unselectProperty(Refund.PROCESSED_DATE_PROPERTY);
       return this;
    }
    public RefundRequest<T> selectReason(){
       selectProperty(Refund.REASON_PROPERTY);
       return this;
    }

    /**
     * fill the reason with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  reason) to fetch reason property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public RefundRequest<T> unselectReason(){
       unselectProperty(Refund.REASON_PROPERTY);
       return this;
    }
    public RefundRequest<T> selectCreateTime(){
       selectProperty(Refund.CREATE_TIME_PROPERTY);
       return this;
    }

    /**
     * fill the createTime with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  createTime) to fetch createTime property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public RefundRequest<T> unselectCreateTime(){
       unselectProperty(Refund.CREATE_TIME_PROPERTY);
       return this;
    }
    public RefundRequest<T> selectUpdateTime(){
       selectProperty(Refund.UPDATE_TIME_PROPERTY);
       return this;
    }

    /**
     * fill the updateTime with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  updateTime) to fetch updateTime property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public RefundRequest<T> unselectUpdateTime(){
       unselectProperty(Refund.UPDATE_TIME_PROPERTY);
       return this;
    }
    public RefundRequest<T> selectVersion(){
       selectProperty(Refund.VERSION_PROPERTY);
       return this;
    }

    /**
     * fill the version with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  version) to fetch version property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public RefundRequest<T> unselectVersion(){
       unselectProperty(Refund.VERSION_PROPERTY);
       return this;
    }

    public RefundRequest<T> withId(Operator operator, Object... values){
       return appendSearchCriteria(createIdCriteria(operator, values));
    }

    public SearchCriteria createIdCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Refund.ID_PROPERTY, operator, values);
    }

    public RefundRequest<T> withIdIs(Long id){
       return withId(Operator.EQUAL, id);
    }
    public RefundRequest<T> withIdIn(Long... id){
       return withId(Operator.EQUAL, (Object[])id);
    }



    public RefundRequest<T> filterByAmount(BigDecimal... amount){
      if (amount == null || amount.length == 0) {
        throw new IllegalArgumentException("filterByAmount parameter amount cannot be empty");
      }
      return appendSearchCriteria(createAmountCriteria(Operator.EQUAL, (Object[])amount));
    }

    public RefundRequest<T> withAmount(Operator operator, Object... values){
       return appendSearchCriteria(createAmountCriteria(operator, values));
    }

    public RefundRequest<T> withAmountIsUnknown(){
       return withAmount(Operator.IS_NULL);
    }

    public RefundRequest<T> withAmountIsKnown(){
       return withAmount(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createAmountCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Refund.AMOUNT_PROPERTY, operator, values);
    }

    public RefundRequest<T> withAmountGreaterThan(BigDecimal amount){
       return withAmount(Operator.GREATER_THAN, amount);
    }

    public RefundRequest<T> withAmountGreaterThanOrEqualTo(BigDecimal amount){
       return withAmount(Operator.GREATER_THAN_OR_EQUAL, amount);
    }

    public RefundRequest<T> withAmountLessThan(BigDecimal amount){
       return withAmount(Operator.LESS_THAN, amount);
    }

    public RefundRequest<T> withAmountLessThanOrEqualTo(BigDecimal amount){
       return withAmount(Operator.LESS_THAN_OR_EQUAL, amount);
    }

    public RefundRequest<T> withAmountBetween(BigDecimal startOfAmount, BigDecimal endOfAmount){
       return withAmount(Operator.BETWEEN, startOfAmount, endOfAmount);
    }



    public RefundRequest<T> filterByPayment(Payment... payment){
      if (payment == null || payment.length == 0) {
        throw new IllegalArgumentException("filterByPayment parameter payment cannot be empty");
      }
      return appendSearchCriteria(createPaymentCriteria(Operator.EQUAL, (Object[])payment));
    }

    public RefundRequest<T> withPayment(Operator operator, Object... values){
       return appendSearchCriteria(createPaymentCriteria(operator, values));
    }

    public RefundRequest<T> withPaymentIsUnknown(){
       return withPayment(Operator.IS_NULL);
    }

    public RefundRequest<T> withPaymentIsKnown(){
       return withPayment(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createPaymentCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Refund.PAYMENT_PROPERTY, operator, values);
    }

    public RefundRequest<T> filterByPayment(Long payment){
      if(payment == null){
         return this;
      }
      return withPayment(Operator.EQUAL, payment);
    }
    public RefundRequest<T> withPaymentMatching(PaymentRequest payment){
       return appendSearchCriteria(new SubQuerySearchCriteria(Refund.PAYMENT_PROPERTY, payment, Payment.ID_PROPERTY));
    }

    public RefundRequest<T> filterByProcessedDate(LocalDateTime... processedDate){
      if (processedDate == null || processedDate.length == 0) {
        throw new IllegalArgumentException("filterByProcessedDate parameter processedDate cannot be empty");
      }
      return appendSearchCriteria(createProcessedDateCriteria(Operator.EQUAL, (Object[])processedDate));
    }

    public RefundRequest<T> withProcessedDate(Operator operator, Object... values){
       return appendSearchCriteria(createProcessedDateCriteria(operator, values));
    }

    public RefundRequest<T> withProcessedDateIsUnknown(){
       return withProcessedDate(Operator.IS_NULL);
    }

    public RefundRequest<T> withProcessedDateIsKnown(){
       return withProcessedDate(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createProcessedDateCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Refund.PROCESSED_DATE_PROPERTY, operator, values);
    }

    public RefundRequest<T> withProcessedDateGreaterThan(LocalDateTime processedDate){
       return withProcessedDate(Operator.GREATER_THAN, processedDate);
    }

    public RefundRequest<T> withProcessedDateGreaterThanOrEqualTo(LocalDateTime processedDate){
       return withProcessedDate(Operator.GREATER_THAN_OR_EQUAL, processedDate);
    }

    public RefundRequest<T> withProcessedDateLessThan(LocalDateTime processedDate){
       return withProcessedDate(Operator.LESS_THAN, processedDate);
    }

    public RefundRequest<T> withProcessedDateLessThanOrEqualTo(LocalDateTime processedDate){
       return withProcessedDate(Operator.LESS_THAN_OR_EQUAL, processedDate);
    }

    public RefundRequest<T> withProcessedDateBetween(LocalDateTime startOfProcessedDate, LocalDateTime endOfProcessedDate){
       return withProcessedDate(Operator.BETWEEN, startOfProcessedDate, endOfProcessedDate);
    }
    public RefundRequest<T> withProcessedDateBefore(LocalDateTime processedDate){
       return withProcessedDate(Operator.LESS_THAN, processedDate);
    }

    public RefundRequest<T> withProcessedDateBefore(Date processedDate){
       return withProcessedDate(Operator.LESS_THAN, processedDate);
    }

    public RefundRequest<T> withProcessedDateAfter(LocalDateTime processedDate){
       return withProcessedDate(Operator.GREATER_THAN, processedDate);
    }

    public RefundRequest<T> withProcessedDateAfter(Date processedDate){
       return withProcessedDate(Operator.GREATER_THAN, processedDate);
    }

    public RefundRequest<T> withProcessedDateBetween(Date startOfProcessedDate, Date endOfProcessedDate){
       return withProcessedDate(Operator.BETWEEN, startOfProcessedDate, endOfProcessedDate);
    }




    public RefundRequest<T> filterByReason(String... reason){
      if (reason == null || reason.length == 0) {
        throw new IllegalArgumentException("filterByReason parameter reason cannot be empty");
      }
      return appendSearchCriteria(createReasonCriteria(Operator.EQUAL, (Object[])reason));
    }

    public RefundRequest<T> withReason(Operator operator, Object... values){
       return appendSearchCriteria(createReasonCriteria(operator, values));
    }

    public RefundRequest<T> withReasonIsUnknown(){
       return withReason(Operator.IS_NULL);
    }

    public RefundRequest<T> withReasonIsKnown(){
       return withReason(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createReasonCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Refund.REASON_PROPERTY, operator, values);
    }

    public RefundRequest<T> withReasonGreaterThan(String reason){
       return withReason(Operator.GREATER_THAN, reason);
    }

    public RefundRequest<T> withReasonGreaterThanOrEqualTo(String reason){
       return withReason(Operator.GREATER_THAN_OR_EQUAL, reason);
    }

    public RefundRequest<T> withReasonLessThan(String reason){
       return withReason(Operator.LESS_THAN, reason);
    }

    public RefundRequest<T> withReasonLessThanOrEqualTo(String reason){
       return withReason(Operator.LESS_THAN_OR_EQUAL, reason);
    }

    public RefundRequest<T> withReasonBetween(String startOfReason, String endOfReason){
       return withReason(Operator.BETWEEN, startOfReason, endOfReason);
    }
    public RefundRequest<T> withReasonStartingWith(String reason){
       return withReason(Operator.BEGIN_WITH, reason);
    }
    public RefundRequest<T> withReasonContaining(String reason){
       return withReason(Operator.CONTAIN, reason);
    }

    public RefundRequest<T> withReasonEndingWith(String reason){
       return withReason(Operator.END_WITH, reason);
    }

    public RefundRequest<T> withReasonIs(String reason){
       return withReason(Operator.EQUAL, reason);
    }

    public RefundRequest<T> withReasonSoundingLike(String reason){
       return withReason(Operator.SOUNDS_LIKE, reason);
    }



    public RefundRequest<T> filterByCreateTime(LocalDateTime... createTime){
      if (createTime == null || createTime.length == 0) {
        throw new IllegalArgumentException("filterByCreateTime parameter createTime cannot be empty");
      }
      return appendSearchCriteria(createCreateTimeCriteria(Operator.EQUAL, (Object[])createTime));
    }

    public RefundRequest<T> withCreateTime(Operator operator, Object... values){
       return appendSearchCriteria(createCreateTimeCriteria(operator, values));
    }

    public RefundRequest<T> withCreateTimeIsUnknown(){
       return withCreateTime(Operator.IS_NULL);
    }

    public RefundRequest<T> withCreateTimeIsKnown(){
       return withCreateTime(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createCreateTimeCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Refund.CREATE_TIME_PROPERTY, operator, values);
    }

    public RefundRequest<T> withCreateTimeGreaterThan(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public RefundRequest<T> withCreateTimeGreaterThanOrEqualTo(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN_OR_EQUAL, createTime);
    }

    public RefundRequest<T> withCreateTimeLessThan(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public RefundRequest<T> withCreateTimeLessThanOrEqualTo(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN_OR_EQUAL, createTime);
    }

    public RefundRequest<T> withCreateTimeBetween(LocalDateTime startOfCreateTime, LocalDateTime endOfCreateTime){
       return withCreateTime(Operator.BETWEEN, startOfCreateTime, endOfCreateTime);
    }
    public RefundRequest<T> withCreateTimeBefore(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public RefundRequest<T> withCreateTimeBefore(Date createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public RefundRequest<T> withCreateTimeAfter(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public RefundRequest<T> withCreateTimeAfter(Date createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public RefundRequest<T> withCreateTimeBetween(Date startOfCreateTime, Date endOfCreateTime){
       return withCreateTime(Operator.BETWEEN, startOfCreateTime, endOfCreateTime);
    }




    public RefundRequest<T> filterByUpdateTime(LocalDateTime... updateTime){
      if (updateTime == null || updateTime.length == 0) {
        throw new IllegalArgumentException("filterByUpdateTime parameter updateTime cannot be empty");
      }
      return appendSearchCriteria(createUpdateTimeCriteria(Operator.EQUAL, (Object[])updateTime));
    }

    public RefundRequest<T> withUpdateTime(Operator operator, Object... values){
       return appendSearchCriteria(createUpdateTimeCriteria(operator, values));
    }

    public RefundRequest<T> withUpdateTimeIsUnknown(){
       return withUpdateTime(Operator.IS_NULL);
    }

    public RefundRequest<T> withUpdateTimeIsKnown(){
       return withUpdateTime(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createUpdateTimeCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Refund.UPDATE_TIME_PROPERTY, operator, values);
    }

    public RefundRequest<T> withUpdateTimeGreaterThan(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public RefundRequest<T> withUpdateTimeGreaterThanOrEqualTo(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN_OR_EQUAL, updateTime);
    }

    public RefundRequest<T> withUpdateTimeLessThan(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public RefundRequest<T> withUpdateTimeLessThanOrEqualTo(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN_OR_EQUAL, updateTime);
    }

    public RefundRequest<T> withUpdateTimeBetween(LocalDateTime startOfUpdateTime, LocalDateTime endOfUpdateTime){
       return withUpdateTime(Operator.BETWEEN, startOfUpdateTime, endOfUpdateTime);
    }
    public RefundRequest<T> withUpdateTimeBefore(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public RefundRequest<T> withUpdateTimeBefore(Date updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public RefundRequest<T> withUpdateTimeAfter(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public RefundRequest<T> withUpdateTimeAfter(Date updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public RefundRequest<T> withUpdateTimeBetween(Date startOfUpdateTime, Date endOfUpdateTime){
       return withUpdateTime(Operator.BETWEEN, startOfUpdateTime, endOfUpdateTime);
    }




    public RefundRequest<T> filterByVersion(Long... version){
      if (version == null || version.length == 0) {
        throw new IllegalArgumentException("filterByVersion parameter version cannot be empty");
      }
      return appendSearchCriteria(createVersionCriteria(Operator.EQUAL, (Object[])version));
    }

    public RefundRequest<T> withVersion(Operator operator, Object... values){
       return appendSearchCriteria(createVersionCriteria(operator, values));
    }

    public RefundRequest<T> withVersionIsUnknown(){
       return withVersion(Operator.IS_NULL);
    }

    public RefundRequest<T> withVersionIsKnown(){
       return withVersion(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createVersionCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Refund.VERSION_PROPERTY, operator, values);
    }

    public RefundRequest<T> withVersionGreaterThan(Long version){
       return withVersion(Operator.GREATER_THAN, version);
    }

    public RefundRequest<T> withVersionGreaterThanOrEqualTo(Long version){
       return withVersion(Operator.GREATER_THAN_OR_EQUAL, version);
    }

    public RefundRequest<T> withVersionLessThan(Long version){
       return withVersion(Operator.LESS_THAN, version);
    }

    public RefundRequest<T> withVersionLessThanOrEqualTo(Long version){
       return withVersion(Operator.LESS_THAN_OR_EQUAL, version);
    }

    public RefundRequest<T> withVersionBetween(Long startOfVersion, Long endOfVersion){
       return withVersion(Operator.BETWEEN, startOfVersion, endOfVersion);
    }


    public RefundRequest<T> count(){
        super.count();
        return this;
    }
    public RefundRequest<T> countAs(String retName){
        super.count(retName);
        return this;
    }
    public RefundRequest minAmount(){
        return minAmountAs(prefix("minOf",Refund.AMOUNT_PROPERTY));
    }

    public RefundRequest minAmountAs(String retName){
        super.min(retName, Refund.AMOUNT_PROPERTY);
        return this;
    }
    public RefundRequest maxAmount(){
        return maxAmountAs(prefix("maxOf",Refund.AMOUNT_PROPERTY));
    }

    public RefundRequest maxAmountAs(String retName){
        super.max(retName, Refund.AMOUNT_PROPERTY);
        return this;
    }
    public RefundRequest sumAmount(){
        return sumAmountAs(prefix("sumOf",Refund.AMOUNT_PROPERTY));
    }

    public RefundRequest sumAmountAs(String retName){
        super.sum(retName, Refund.AMOUNT_PROPERTY);
        return this;
    }
    public RefundRequest avgAmount(){
        return avgAmountAs(prefix("avgOf",Refund.AMOUNT_PROPERTY));
    }

    public RefundRequest avgAmountAs(String retName){
        super.avg(retName, Refund.AMOUNT_PROPERTY);
        return this;
    }
    public RefundRequest standardDeviationAmount(){
        return standardDeviationAmountAs(prefix("standardDeviationOf",Refund.AMOUNT_PROPERTY));
    }

    public RefundRequest standardDeviationAmountAs(String retName){
        super.standardDeviation(retName, Refund.AMOUNT_PROPERTY);
        return this;
    }
    public RefundRequest squareRootOfPopulationStandardDeviationAmount(){
        return squareRootOfPopulationStandardDeviationAmountAs(prefix("squareRootOfPopulationStandardDeviationOf",Refund.AMOUNT_PROPERTY));
    }

    public RefundRequest squareRootOfPopulationStandardDeviationAmountAs(String retName){
        super.squareRootOfPopulationStandardDeviation(retName, Refund.AMOUNT_PROPERTY);
        return this;
    }
    public RefundRequest sampleVarianceAmount(){
        return sampleVarianceAmountAs(prefix("sampleVarianceOf",Refund.AMOUNT_PROPERTY));
    }

    public RefundRequest sampleVarianceAmountAs(String retName){
        super.sampleVariance(retName, Refund.AMOUNT_PROPERTY);
        return this;
    }
    public RefundRequest samplePopulationVarianceAmount(){
        return samplePopulationVarianceAmountAs(prefix("samplePopulationVarianceOf",Refund.AMOUNT_PROPERTY));
    }

    public RefundRequest samplePopulationVarianceAmountAs(String retName){
        super.samplePopulationVariance(retName, Refund.AMOUNT_PROPERTY);
        return this;
    }
    public RefundRequest<T> groupByPaymentWithDetails(){
       return groupByPaymentWithDetails(Q.payments().unlimited());
    }

    public RefundRequest<T> groupByPaymentWithDetails(PaymentRequest subRequest){
       aggregate(Refund.PAYMENT_PROPERTY, subRequest);
       return this;
    }







    public RefundRequest<T> groupById(){
       groupBy(Refund.ID_PROPERTY);
       return this;
    }

    public RefundRequest<T> groupByIdAs(String retName){
       groupBy(retName, Refund.ID_PROPERTY);
       return this;
    }

    public RefundRequest<T> groupByIdWithFunction(String retName, AggrFunction function){
       groupBy(retName, Refund.ID_PROPERTY, function);
       return this;
    }

    public RefundRequest<T> groupByAmount(){
       groupBy(Refund.AMOUNT_PROPERTY);
       return this;
    }

    public RefundRequest<T> groupByAmountAs(String retName){
       groupBy(retName, Refund.AMOUNT_PROPERTY);
       return this;
    }

    public RefundRequest<T> groupByAmountWithFunction(String retName, AggrFunction function){
       groupBy(retName, Refund.AMOUNT_PROPERTY, function);
       return this;
    }
    public RefundRequest<T> groupByPaymentWith(PaymentRequest subRequest){
       groupBy(Refund.PAYMENT_PROPERTY, subRequest);
       return this;
    }
    public RefundRequest<T> groupByPayment(){
       groupBy(Refund.PAYMENT_PROPERTY);
       return this;
    }

    public RefundRequest<T> groupByPaymentAs(String retName){
       groupBy(retName, Refund.PAYMENT_PROPERTY);
       return this;
    }

    public RefundRequest<T> groupByPaymentWithFunction(String retName, AggrFunction function){
       groupBy(retName, Refund.PAYMENT_PROPERTY, function);
       return this;
    }

    public RefundRequest<T> groupByProcessedDate(){
       groupBy(Refund.PROCESSED_DATE_PROPERTY);
       return this;
    }

    public RefundRequest<T> groupByProcessedDateAs(String retName){
       groupBy(retName, Refund.PROCESSED_DATE_PROPERTY);
       return this;
    }

    public RefundRequest<T> groupByProcessedDateWithFunction(String retName, AggrFunction function){
       groupBy(retName, Refund.PROCESSED_DATE_PROPERTY, function);
       return this;
    }

    public RefundRequest<T> groupByReason(){
       groupBy(Refund.REASON_PROPERTY);
       return this;
    }

    public RefundRequest<T> groupByReasonAs(String retName){
       groupBy(retName, Refund.REASON_PROPERTY);
       return this;
    }

    public RefundRequest<T> groupByReasonWithFunction(String retName, AggrFunction function){
       groupBy(retName, Refund.REASON_PROPERTY, function);
       return this;
    }

    public RefundRequest<T> groupByCreateTime(){
       groupBy(Refund.CREATE_TIME_PROPERTY);
       return this;
    }

    public RefundRequest<T> groupByCreateTimeAs(String retName){
       groupBy(retName, Refund.CREATE_TIME_PROPERTY);
       return this;
    }

    public RefundRequest<T> groupByCreateTimeWithFunction(String retName, AggrFunction function){
       groupBy(retName, Refund.CREATE_TIME_PROPERTY, function);
       return this;
    }

    public RefundRequest<T> groupByUpdateTime(){
       groupBy(Refund.UPDATE_TIME_PROPERTY);
       return this;
    }

    public RefundRequest<T> groupByUpdateTimeAs(String retName){
       groupBy(retName, Refund.UPDATE_TIME_PROPERTY);
       return this;
    }

    public RefundRequest<T> groupByUpdateTimeWithFunction(String retName, AggrFunction function){
       groupBy(retName, Refund.UPDATE_TIME_PROPERTY, function);
       return this;
    }

    public RefundRequest<T> groupByVersion(){
       groupBy(Refund.VERSION_PROPERTY);
       return this;
    }

    public RefundRequest<T> groupByVersionAs(String retName){
       groupBy(retName, Refund.VERSION_PROPERTY);
       return this;
    }

    public RefundRequest<T> groupByVersionWithFunction(String retName, AggrFunction function){
       groupBy(retName, Refund.VERSION_PROPERTY, function);
       return this;
    }



    public RefundRequest<T> orderByIdAscending(){
       addOrderByAscending(Refund.ID_PROPERTY);
       return this;
    }

    public RefundRequest<T> orderByIdDescending(){
       addOrderByDescending(Refund.ID_PROPERTY);
       return this;
    }

    public RefundRequest<T> orderByAmountAscending(){
       addOrderByAscending(Refund.AMOUNT_PROPERTY);
       return this;
    }

    public RefundRequest<T> orderByAmountDescending(){
       addOrderByDescending(Refund.AMOUNT_PROPERTY);
       return this;
    }

    public RefundRequest<T> orderByPaymentAscending(){
       addOrderByAscending(Refund.PAYMENT_PROPERTY);
       return this;
    }

    public RefundRequest<T> orderByPaymentDescending(){
       addOrderByDescending(Refund.PAYMENT_PROPERTY);
       return this;
    }

    public RefundRequest<T> orderByProcessedDateAscending(){
       addOrderByAscending(Refund.PROCESSED_DATE_PROPERTY);
       return this;
    }

    public RefundRequest<T> orderByProcessedDateDescending(){
       addOrderByDescending(Refund.PROCESSED_DATE_PROPERTY);
       return this;
    }

    public RefundRequest<T> orderByReasonAscending(){
       addOrderByAscending(Refund.REASON_PROPERTY);
       return this;
    }

    public RefundRequest<T> orderByReasonDescending(){
       addOrderByDescending(Refund.REASON_PROPERTY);
       return this;
    }
    public RefundRequest<T> orderByReasonAscendingUsingGBK(){
       addOrderByAscendingUsingGBK(Refund.REASON_PROPERTY);
       return this;
    }

    public RefundRequest<T> orderByReasonDescendingUsingGBK(){
       addOrderByDescendingUsingGBK(Refund.REASON_PROPERTY);
       return this;
    }
    public RefundRequest<T> orderByCreateTimeAscending(){
       addOrderByAscending(Refund.CREATE_TIME_PROPERTY);
       return this;
    }

    public RefundRequest<T> orderByCreateTimeDescending(){
       addOrderByDescending(Refund.CREATE_TIME_PROPERTY);
       return this;
    }

    public RefundRequest<T> orderByUpdateTimeAscending(){
       addOrderByAscending(Refund.UPDATE_TIME_PROPERTY);
       return this;
    }

    public RefundRequest<T> orderByUpdateTimeDescending(){
       addOrderByDescending(Refund.UPDATE_TIME_PROPERTY);
       return this;
    }

    public RefundRequest<T> orderByVersionAscending(){
       addOrderByAscending(Refund.VERSION_PROPERTY);
       return this;
    }

    public RefundRequest<T> orderByVersionDescending(){
       addOrderByDescending(Refund.VERSION_PROPERTY);
       return this;
    }


    public PaymentRequest rollUpToPayment(){
       PaymentRequest payment = Q.payments().unlimited();
       this.withPaymentMatching(payment)
           .groupByPaymentWith(payment);
       return payment;
    }







   public RefundRequest<T> facetByPaymentAs(String facetName, PaymentRequest payment){
       return facetByPaymentAs(facetName, payment, true);
   }

   public RefundRequest<T> facetByPaymentAs(String facetName, PaymentRequest payment, boolean includeAllFacets){
       addFacet(facetName, Refund.PAYMENT_PROPERTY, payment, includeAllFacets);
       return this;
   }


    /**
     * get topN records
     * @param topN  records number
     */
    public RefundRequest<T> top(int topN) {
        super.top(topN);
        return this;
    }

    /**
     * get records from offset(inclusive) to offset+size(exclusive)
     * @param offset record offset
     * @param size records number
     */
    public RefundRequest<T> offset(int offset, int size) {
        super.offset(offset, size);
        return this;
    }

    /**
     * retrieve all records
     */
    public RefundRequest<T> unlimited() {
        super.unlimited();
        return this;
    }

    /**
     * get records of one page
     * @param pageNumber page number(1-based)
     * @param pageSize page size
     */
    public RefundRequest<T> page(int pageNumber, int pageSize) {
        int offset = (pageNumber - 1) * pageSize;
        return offset(offset, pageSize);
   }

    /**
     * get records of one page, default page size is 10
     * @param pageNumber page number(1-based)
     */
    public RefundRequest<T> page(int pageNumber) {
        return page(pageNumber, 10);
   }
}