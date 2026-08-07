
package com.example.enterpriseerpsystem.returnrequest;

import com.example.enterpriseerpsystem.Q;
import com.example.enterpriseerpsystem.customer.Customer;
import com.example.enterpriseerpsystem.customer.CustomerRequest;
import com.example.enterpriseerpsystem.globalorder.GlobalOrder;
import com.example.enterpriseerpsystem.globalorder.GlobalOrderRequest;
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

public class ReturnRequestRequest<T extends ReturnRequest> extends BaseRequest<T> {

    /**
     * @deprecated AI agents and business code must use the generated Q facade
     *             instead of constructing request builders directly.
     */
    @Deprecated
    public ReturnRequestRequest(Class<T> returnType){
        super(returnType);
        selectId();
        selectVersion();
    }

    public ReturnRequestRequest<T> comment(String comment){
         super.internalComment(comment);
         return this;
    }

    // purpose() 继承自 BaseRequest，返回 ExecutableRequest（终结方法）

    public ReturnRequestRequest<T> returnType(Class<? extends T> returnType){
        super.setReturnType(returnType);
        return this;
    }

    public ReturnRequestRequest<T> enableAggregationCache(long cacheExpiredMillis){
        super.enableAggregationCache();
        super.aggregateCacheTime(cacheExpiredMillis);
        return this;
    }

    public ReturnRequestRequest<T> enableAggregationCache(){
        return enableAggregationCache(0l);
    }


    public ReturnRequestRequest<T> propagateAggregationCache(long cacheExpiredMillis){
        super.propagateAggregationCache(cacheExpiredMillis);
        return this;
    }

    public ReturnRequestRequest<T> appendSearchCriteria(SearchCriteria searchCriteria){
        return (ReturnRequestRequest<T>)super.appendSearchCriteria(searchCriteria);
    }

    public ReturnRequestRequest<T> filter(String property1, Operator operator, String property2){
        return appendSearchCriteria(new TwoOperatorCriteria(operator, new PropertyReference(property1), new PropertyReference(property2)));
    }


    public ReturnRequestRequest<T> matchingAnyOf(ReturnRequestRequest returnRequest){
        super.internalMatchAny(returnRequest);
        return this;
    }

    public ReturnRequestRequest<T> enhanceChildrenIfNeeded(){
        return this;
    }

    public ReturnRequestRequest<T> withDeletedRows(){
        super.withDeletedRows();
        return this;
    }

    public ReturnRequestRequest<T> deletedRowsOnly(){
        super.deletedRowsOnly();
        return this;
    }

    public ReturnRequestRequest<T> selectSelf(){
        super.selectSelf();
        return selectId().selectRefundAmount().selectCustomerIdOnly().selectGlobalOrderIdOnly().selectReason().selectStatus().selectCreateTime().selectUpdateTime().selectVersion();
    }

    public ReturnRequestRequest<T> selectSelfFields(){
        return selectSelf();
    }

    public ReturnRequestRequest<T> selectAll(){
        super.selectAll();
        return selectId().selectRefundAmount().selectCustomer().selectGlobalOrder().selectReason().selectStatus().selectCreateTime().selectUpdateTime().selectVersion();
    }

    public ReturnRequestRequest<T> selectChildren(){
        super.selectAny();
        return selectId().selectRefundAmount().selectCustomer().selectGlobalOrder().selectReason().selectStatus().selectCreateTime().selectUpdateTime().selectVersion();
    }


    public ReturnRequestRequest<T> selectId(){
       selectProperty(ReturnRequest.ID_PROPERTY);
       return this;
    }

    /**
     * fill the id with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  id) to fetch id property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public ReturnRequestRequest<T> unselectId(){
       unselectProperty(ReturnRequest.ID_PROPERTY);
       return this;
    }
    public ReturnRequestRequest<T> selectRefundAmount(){
       selectProperty(ReturnRequest.REFUND_AMOUNT_PROPERTY);
       return this;
    }

    /**
     * fill the refundAmount with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  refundAmount) to fetch refundAmount property.
     * @param rawSqlSegment  customized rawSqlSegment
     */


    /**
     * fill the refundAmount with customized aggrFunction, TEAQL uses ({aggrFunction}(refundAmount) AS refundAmount to fetch refundAmount property.
     * @param aggrFunction  aggrFunction
     */
    public ReturnRequestRequest<T> selectRefundAmount(AggrFunction aggrFunction){
       selectProperty(ReturnRequest.REFUND_AMOUNT_PROPERTY, aggrFunction);
       return this;
    }


    public ReturnRequestRequest<T> unselectRefundAmount(){
       unselectProperty(ReturnRequest.REFUND_AMOUNT_PROPERTY);
       return this;
    }
    public ReturnRequestRequest<T> selectCustomerIdOnly(){
       selectProperty(ReturnRequest.CUSTOMER_PROPERTY);
       return this;
    }

    public ReturnRequestRequest<T> selectCustomer(){
        return selectCustomerWith(Q.customers().unlimited().selectSelf());
    }

    public ReturnRequestRequest<T> selectCustomerWith(CustomerRequest customer){
       selectProperty(ReturnRequest.CUSTOMER_PROPERTY);
       enhanceRelation(ReturnRequest.CUSTOMER_PROPERTY, customer);
       return this;
    }

    public ReturnRequestRequest<T> unselectCustomer(){
       unselectProperty(ReturnRequest.CUSTOMER_PROPERTY);
       return this;
    }
    public ReturnRequestRequest<T> selectGlobalOrderIdOnly(){
       selectProperty(ReturnRequest.GLOBAL_ORDER_PROPERTY);
       return this;
    }

    public ReturnRequestRequest<T> selectGlobalOrder(){
        return selectGlobalOrderWith(Q.globalOrders().unlimited().selectSelf());
    }

    public ReturnRequestRequest<T> selectGlobalOrderWith(GlobalOrderRequest globalOrder){
       selectProperty(ReturnRequest.GLOBAL_ORDER_PROPERTY);
       enhanceRelation(ReturnRequest.GLOBAL_ORDER_PROPERTY, globalOrder);
       return this;
    }

    public ReturnRequestRequest<T> unselectGlobalOrder(){
       unselectProperty(ReturnRequest.GLOBAL_ORDER_PROPERTY);
       return this;
    }
    public ReturnRequestRequest<T> selectReason(){
       selectProperty(ReturnRequest.REASON_PROPERTY);
       return this;
    }

    /**
     * fill the reason with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  reason) to fetch reason property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public ReturnRequestRequest<T> unselectReason(){
       unselectProperty(ReturnRequest.REASON_PROPERTY);
       return this;
    }
    public ReturnRequestRequest<T> selectStatus(){
       selectProperty(ReturnRequest.STATUS_PROPERTY);
       return this;
    }

    /**
     * fill the status with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  status) to fetch status property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public ReturnRequestRequest<T> unselectStatus(){
       unselectProperty(ReturnRequest.STATUS_PROPERTY);
       return this;
    }
    public ReturnRequestRequest<T> selectCreateTime(){
       selectProperty(ReturnRequest.CREATE_TIME_PROPERTY);
       return this;
    }

    /**
     * fill the createTime with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  createTime) to fetch createTime property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public ReturnRequestRequest<T> unselectCreateTime(){
       unselectProperty(ReturnRequest.CREATE_TIME_PROPERTY);
       return this;
    }
    public ReturnRequestRequest<T> selectUpdateTime(){
       selectProperty(ReturnRequest.UPDATE_TIME_PROPERTY);
       return this;
    }

    /**
     * fill the updateTime with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  updateTime) to fetch updateTime property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public ReturnRequestRequest<T> unselectUpdateTime(){
       unselectProperty(ReturnRequest.UPDATE_TIME_PROPERTY);
       return this;
    }
    public ReturnRequestRequest<T> selectVersion(){
       selectProperty(ReturnRequest.VERSION_PROPERTY);
       return this;
    }

    /**
     * fill the version with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  version) to fetch version property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public ReturnRequestRequest<T> unselectVersion(){
       unselectProperty(ReturnRequest.VERSION_PROPERTY);
       return this;
    }

    public ReturnRequestRequest<T> withId(Operator operator, Object... values){
       return appendSearchCriteria(createIdCriteria(operator, values));
    }

    public SearchCriteria createIdCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(ReturnRequest.ID_PROPERTY, operator, values);
    }

    public ReturnRequestRequest<T> withIdIs(Long id){
       return withId(Operator.EQUAL, id);
    }
    public ReturnRequestRequest<T> withIdIn(Long... id){
       return withId(Operator.EQUAL, (Object[])id);
    }



    public ReturnRequestRequest<T> filterByRefundAmount(BigDecimal... refundAmount){
      if (refundAmount == null || refundAmount.length == 0) {
        throw new IllegalArgumentException("filterByRefundAmount parameter refundAmount cannot be empty");
      }
      return appendSearchCriteria(createRefundAmountCriteria(Operator.EQUAL, (Object[])refundAmount));
    }

    public ReturnRequestRequest<T> withRefundAmount(Operator operator, Object... values){
       return appendSearchCriteria(createRefundAmountCriteria(operator, values));
    }

    public ReturnRequestRequest<T> withRefundAmountIsUnknown(){
       return withRefundAmount(Operator.IS_NULL);
    }

    public ReturnRequestRequest<T> withRefundAmountIsKnown(){
       return withRefundAmount(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createRefundAmountCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(ReturnRequest.REFUND_AMOUNT_PROPERTY, operator, values);
    }

    public ReturnRequestRequest<T> withRefundAmountGreaterThan(BigDecimal refundAmount){
       return withRefundAmount(Operator.GREATER_THAN, refundAmount);
    }

    public ReturnRequestRequest<T> withRefundAmountGreaterThanOrEqualTo(BigDecimal refundAmount){
       return withRefundAmount(Operator.GREATER_THAN_OR_EQUAL, refundAmount);
    }

    public ReturnRequestRequest<T> withRefundAmountLessThan(BigDecimal refundAmount){
       return withRefundAmount(Operator.LESS_THAN, refundAmount);
    }

    public ReturnRequestRequest<T> withRefundAmountLessThanOrEqualTo(BigDecimal refundAmount){
       return withRefundAmount(Operator.LESS_THAN_OR_EQUAL, refundAmount);
    }

    public ReturnRequestRequest<T> withRefundAmountBetween(BigDecimal startOfRefundAmount, BigDecimal endOfRefundAmount){
       return withRefundAmount(Operator.BETWEEN, startOfRefundAmount, endOfRefundAmount);
    }



    public ReturnRequestRequest<T> filterByCustomer(Customer... customer){
      if (customer == null || customer.length == 0) {
        throw new IllegalArgumentException("filterByCustomer parameter customer cannot be empty");
      }
      return appendSearchCriteria(createCustomerCriteria(Operator.EQUAL, (Object[])customer));
    }

    public ReturnRequestRequest<T> withCustomer(Operator operator, Object... values){
       return appendSearchCriteria(createCustomerCriteria(operator, values));
    }

    public ReturnRequestRequest<T> withCustomerIsUnknown(){
       return withCustomer(Operator.IS_NULL);
    }

    public ReturnRequestRequest<T> withCustomerIsKnown(){
       return withCustomer(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createCustomerCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(ReturnRequest.CUSTOMER_PROPERTY, operator, values);
    }

    public ReturnRequestRequest<T> filterByCustomer(Long customer){
      if(customer == null){
         return this;
      }
      return withCustomer(Operator.EQUAL, customer);
    }
    public ReturnRequestRequest<T> withCustomerMatching(CustomerRequest customer){
       return appendSearchCriteria(new SubQuerySearchCriteria(ReturnRequest.CUSTOMER_PROPERTY, customer, Customer.ID_PROPERTY));
    }

    public ReturnRequestRequest<T> filterByGlobalOrder(GlobalOrder... globalOrder){
      if (globalOrder == null || globalOrder.length == 0) {
        throw new IllegalArgumentException("filterByGlobalOrder parameter globalOrder cannot be empty");
      }
      return appendSearchCriteria(createGlobalOrderCriteria(Operator.EQUAL, (Object[])globalOrder));
    }

    public ReturnRequestRequest<T> withGlobalOrder(Operator operator, Object... values){
       return appendSearchCriteria(createGlobalOrderCriteria(operator, values));
    }

    public ReturnRequestRequest<T> withGlobalOrderIsUnknown(){
       return withGlobalOrder(Operator.IS_NULL);
    }

    public ReturnRequestRequest<T> withGlobalOrderIsKnown(){
       return withGlobalOrder(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createGlobalOrderCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(ReturnRequest.GLOBAL_ORDER_PROPERTY, operator, values);
    }

    public ReturnRequestRequest<T> filterByGlobalOrder(Long globalOrder){
      if(globalOrder == null){
         return this;
      }
      return withGlobalOrder(Operator.EQUAL, globalOrder);
    }
    public ReturnRequestRequest<T> withGlobalOrderMatching(GlobalOrderRequest globalOrder){
       return appendSearchCriteria(new SubQuerySearchCriteria(ReturnRequest.GLOBAL_ORDER_PROPERTY, globalOrder, GlobalOrder.ID_PROPERTY));
    }

    public ReturnRequestRequest<T> filterByReason(String... reason){
      if (reason == null || reason.length == 0) {
        throw new IllegalArgumentException("filterByReason parameter reason cannot be empty");
      }
      return appendSearchCriteria(createReasonCriteria(Operator.EQUAL, (Object[])reason));
    }

    public ReturnRequestRequest<T> withReason(Operator operator, Object... values){
       return appendSearchCriteria(createReasonCriteria(operator, values));
    }

    public ReturnRequestRequest<T> withReasonIsUnknown(){
       return withReason(Operator.IS_NULL);
    }

    public ReturnRequestRequest<T> withReasonIsKnown(){
       return withReason(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createReasonCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(ReturnRequest.REASON_PROPERTY, operator, values);
    }

    public ReturnRequestRequest<T> withReasonGreaterThan(String reason){
       return withReason(Operator.GREATER_THAN, reason);
    }

    public ReturnRequestRequest<T> withReasonGreaterThanOrEqualTo(String reason){
       return withReason(Operator.GREATER_THAN_OR_EQUAL, reason);
    }

    public ReturnRequestRequest<T> withReasonLessThan(String reason){
       return withReason(Operator.LESS_THAN, reason);
    }

    public ReturnRequestRequest<T> withReasonLessThanOrEqualTo(String reason){
       return withReason(Operator.LESS_THAN_OR_EQUAL, reason);
    }

    public ReturnRequestRequest<T> withReasonBetween(String startOfReason, String endOfReason){
       return withReason(Operator.BETWEEN, startOfReason, endOfReason);
    }
    public ReturnRequestRequest<T> withReasonStartingWith(String reason){
       return withReason(Operator.BEGIN_WITH, reason);
    }
    public ReturnRequestRequest<T> withReasonContaining(String reason){
       return withReason(Operator.CONTAIN, reason);
    }

    public ReturnRequestRequest<T> withReasonEndingWith(String reason){
       return withReason(Operator.END_WITH, reason);
    }

    public ReturnRequestRequest<T> withReasonIs(String reason){
       return withReason(Operator.EQUAL, reason);
    }

    public ReturnRequestRequest<T> withReasonSoundingLike(String reason){
       return withReason(Operator.SOUNDS_LIKE, reason);
    }



    public ReturnRequestRequest<T> filterByStatus(String... status){
      if (status == null || status.length == 0) {
        throw new IllegalArgumentException("filterByStatus parameter status cannot be empty");
      }
      return appendSearchCriteria(createStatusCriteria(Operator.EQUAL, (Object[])status));
    }

    public ReturnRequestRequest<T> withStatus(Operator operator, Object... values){
       return appendSearchCriteria(createStatusCriteria(operator, values));
    }

    public ReturnRequestRequest<T> withStatusIsUnknown(){
       return withStatus(Operator.IS_NULL);
    }

    public ReturnRequestRequest<T> withStatusIsKnown(){
       return withStatus(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createStatusCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(ReturnRequest.STATUS_PROPERTY, operator, values);
    }

    public ReturnRequestRequest<T> withStatusGreaterThan(String status){
       return withStatus(Operator.GREATER_THAN, status);
    }

    public ReturnRequestRequest<T> withStatusGreaterThanOrEqualTo(String status){
       return withStatus(Operator.GREATER_THAN_OR_EQUAL, status);
    }

    public ReturnRequestRequest<T> withStatusLessThan(String status){
       return withStatus(Operator.LESS_THAN, status);
    }

    public ReturnRequestRequest<T> withStatusLessThanOrEqualTo(String status){
       return withStatus(Operator.LESS_THAN_OR_EQUAL, status);
    }

    public ReturnRequestRequest<T> withStatusBetween(String startOfStatus, String endOfStatus){
       return withStatus(Operator.BETWEEN, startOfStatus, endOfStatus);
    }
    public ReturnRequestRequest<T> withStatusStartingWith(String status){
       return withStatus(Operator.BEGIN_WITH, status);
    }
    public ReturnRequestRequest<T> withStatusContaining(String status){
       return withStatus(Operator.CONTAIN, status);
    }

    public ReturnRequestRequest<T> withStatusEndingWith(String status){
       return withStatus(Operator.END_WITH, status);
    }

    public ReturnRequestRequest<T> withStatusIs(String status){
       return withStatus(Operator.EQUAL, status);
    }

    public ReturnRequestRequest<T> withStatusSoundingLike(String status){
       return withStatus(Operator.SOUNDS_LIKE, status);
    }



    public ReturnRequestRequest<T> filterByCreateTime(LocalDateTime... createTime){
      if (createTime == null || createTime.length == 0) {
        throw new IllegalArgumentException("filterByCreateTime parameter createTime cannot be empty");
      }
      return appendSearchCriteria(createCreateTimeCriteria(Operator.EQUAL, (Object[])createTime));
    }

    public ReturnRequestRequest<T> withCreateTime(Operator operator, Object... values){
       return appendSearchCriteria(createCreateTimeCriteria(operator, values));
    }

    public ReturnRequestRequest<T> withCreateTimeIsUnknown(){
       return withCreateTime(Operator.IS_NULL);
    }

    public ReturnRequestRequest<T> withCreateTimeIsKnown(){
       return withCreateTime(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createCreateTimeCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(ReturnRequest.CREATE_TIME_PROPERTY, operator, values);
    }

    public ReturnRequestRequest<T> withCreateTimeGreaterThan(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public ReturnRequestRequest<T> withCreateTimeGreaterThanOrEqualTo(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN_OR_EQUAL, createTime);
    }

    public ReturnRequestRequest<T> withCreateTimeLessThan(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public ReturnRequestRequest<T> withCreateTimeLessThanOrEqualTo(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN_OR_EQUAL, createTime);
    }

    public ReturnRequestRequest<T> withCreateTimeBetween(LocalDateTime startOfCreateTime, LocalDateTime endOfCreateTime){
       return withCreateTime(Operator.BETWEEN, startOfCreateTime, endOfCreateTime);
    }
    public ReturnRequestRequest<T> withCreateTimeBefore(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public ReturnRequestRequest<T> withCreateTimeBefore(Date createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public ReturnRequestRequest<T> withCreateTimeAfter(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public ReturnRequestRequest<T> withCreateTimeAfter(Date createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public ReturnRequestRequest<T> withCreateTimeBetween(Date startOfCreateTime, Date endOfCreateTime){
       return withCreateTime(Operator.BETWEEN, startOfCreateTime, endOfCreateTime);
    }




    public ReturnRequestRequest<T> filterByUpdateTime(LocalDateTime... updateTime){
      if (updateTime == null || updateTime.length == 0) {
        throw new IllegalArgumentException("filterByUpdateTime parameter updateTime cannot be empty");
      }
      return appendSearchCriteria(createUpdateTimeCriteria(Operator.EQUAL, (Object[])updateTime));
    }

    public ReturnRequestRequest<T> withUpdateTime(Operator operator, Object... values){
       return appendSearchCriteria(createUpdateTimeCriteria(operator, values));
    }

    public ReturnRequestRequest<T> withUpdateTimeIsUnknown(){
       return withUpdateTime(Operator.IS_NULL);
    }

    public ReturnRequestRequest<T> withUpdateTimeIsKnown(){
       return withUpdateTime(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createUpdateTimeCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(ReturnRequest.UPDATE_TIME_PROPERTY, operator, values);
    }

    public ReturnRequestRequest<T> withUpdateTimeGreaterThan(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public ReturnRequestRequest<T> withUpdateTimeGreaterThanOrEqualTo(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN_OR_EQUAL, updateTime);
    }

    public ReturnRequestRequest<T> withUpdateTimeLessThan(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public ReturnRequestRequest<T> withUpdateTimeLessThanOrEqualTo(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN_OR_EQUAL, updateTime);
    }

    public ReturnRequestRequest<T> withUpdateTimeBetween(LocalDateTime startOfUpdateTime, LocalDateTime endOfUpdateTime){
       return withUpdateTime(Operator.BETWEEN, startOfUpdateTime, endOfUpdateTime);
    }
    public ReturnRequestRequest<T> withUpdateTimeBefore(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public ReturnRequestRequest<T> withUpdateTimeBefore(Date updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public ReturnRequestRequest<T> withUpdateTimeAfter(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public ReturnRequestRequest<T> withUpdateTimeAfter(Date updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public ReturnRequestRequest<T> withUpdateTimeBetween(Date startOfUpdateTime, Date endOfUpdateTime){
       return withUpdateTime(Operator.BETWEEN, startOfUpdateTime, endOfUpdateTime);
    }




    public ReturnRequestRequest<T> filterByVersion(Long... version){
      if (version == null || version.length == 0) {
        throw new IllegalArgumentException("filterByVersion parameter version cannot be empty");
      }
      return appendSearchCriteria(createVersionCriteria(Operator.EQUAL, (Object[])version));
    }

    public ReturnRequestRequest<T> withVersion(Operator operator, Object... values){
       return appendSearchCriteria(createVersionCriteria(operator, values));
    }

    public ReturnRequestRequest<T> withVersionIsUnknown(){
       return withVersion(Operator.IS_NULL);
    }

    public ReturnRequestRequest<T> withVersionIsKnown(){
       return withVersion(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createVersionCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(ReturnRequest.VERSION_PROPERTY, operator, values);
    }

    public ReturnRequestRequest<T> withVersionGreaterThan(Long version){
       return withVersion(Operator.GREATER_THAN, version);
    }

    public ReturnRequestRequest<T> withVersionGreaterThanOrEqualTo(Long version){
       return withVersion(Operator.GREATER_THAN_OR_EQUAL, version);
    }

    public ReturnRequestRequest<T> withVersionLessThan(Long version){
       return withVersion(Operator.LESS_THAN, version);
    }

    public ReturnRequestRequest<T> withVersionLessThanOrEqualTo(Long version){
       return withVersion(Operator.LESS_THAN_OR_EQUAL, version);
    }

    public ReturnRequestRequest<T> withVersionBetween(Long startOfVersion, Long endOfVersion){
       return withVersion(Operator.BETWEEN, startOfVersion, endOfVersion);
    }


    public ReturnRequestRequest<T> count(){
        super.count();
        return this;
    }
    public ReturnRequestRequest<T> countAs(String retName){
        super.count(retName);
        return this;
    }
    public ReturnRequestRequest minRefundAmount(){
        return minRefundAmountAs(prefix("minOf",ReturnRequest.REFUND_AMOUNT_PROPERTY));
    }

    public ReturnRequestRequest minRefundAmountAs(String retName){
        super.min(retName, ReturnRequest.REFUND_AMOUNT_PROPERTY);
        return this;
    }
    public ReturnRequestRequest maxRefundAmount(){
        return maxRefundAmountAs(prefix("maxOf",ReturnRequest.REFUND_AMOUNT_PROPERTY));
    }

    public ReturnRequestRequest maxRefundAmountAs(String retName){
        super.max(retName, ReturnRequest.REFUND_AMOUNT_PROPERTY);
        return this;
    }
    public ReturnRequestRequest sumRefundAmount(){
        return sumRefundAmountAs(prefix("sumOf",ReturnRequest.REFUND_AMOUNT_PROPERTY));
    }

    public ReturnRequestRequest sumRefundAmountAs(String retName){
        super.sum(retName, ReturnRequest.REFUND_AMOUNT_PROPERTY);
        return this;
    }
    public ReturnRequestRequest avgRefundAmount(){
        return avgRefundAmountAs(prefix("avgOf",ReturnRequest.REFUND_AMOUNT_PROPERTY));
    }

    public ReturnRequestRequest avgRefundAmountAs(String retName){
        super.avg(retName, ReturnRequest.REFUND_AMOUNT_PROPERTY);
        return this;
    }
    public ReturnRequestRequest standardDeviationRefundAmount(){
        return standardDeviationRefundAmountAs(prefix("standardDeviationOf",ReturnRequest.REFUND_AMOUNT_PROPERTY));
    }

    public ReturnRequestRequest standardDeviationRefundAmountAs(String retName){
        super.standardDeviation(retName, ReturnRequest.REFUND_AMOUNT_PROPERTY);
        return this;
    }
    public ReturnRequestRequest squareRootOfPopulationStandardDeviationRefundAmount(){
        return squareRootOfPopulationStandardDeviationRefundAmountAs(prefix("squareRootOfPopulationStandardDeviationOf",ReturnRequest.REFUND_AMOUNT_PROPERTY));
    }

    public ReturnRequestRequest squareRootOfPopulationStandardDeviationRefundAmountAs(String retName){
        super.squareRootOfPopulationStandardDeviation(retName, ReturnRequest.REFUND_AMOUNT_PROPERTY);
        return this;
    }
    public ReturnRequestRequest sampleVarianceRefundAmount(){
        return sampleVarianceRefundAmountAs(prefix("sampleVarianceOf",ReturnRequest.REFUND_AMOUNT_PROPERTY));
    }

    public ReturnRequestRequest sampleVarianceRefundAmountAs(String retName){
        super.sampleVariance(retName, ReturnRequest.REFUND_AMOUNT_PROPERTY);
        return this;
    }
    public ReturnRequestRequest samplePopulationVarianceRefundAmount(){
        return samplePopulationVarianceRefundAmountAs(prefix("samplePopulationVarianceOf",ReturnRequest.REFUND_AMOUNT_PROPERTY));
    }

    public ReturnRequestRequest samplePopulationVarianceRefundAmountAs(String retName){
        super.samplePopulationVariance(retName, ReturnRequest.REFUND_AMOUNT_PROPERTY);
        return this;
    }
    public ReturnRequestRequest<T> groupByCustomerWithDetails(){
       return groupByCustomerWithDetails(Q.customers().unlimited());
    }

    public ReturnRequestRequest<T> groupByCustomerWithDetails(CustomerRequest subRequest){
       aggregate(ReturnRequest.CUSTOMER_PROPERTY, subRequest);
       return this;
    }

    public ReturnRequestRequest<T> groupByGlobalOrderWithDetails(){
       return groupByGlobalOrderWithDetails(Q.globalOrders().unlimited());
    }

    public ReturnRequestRequest<T> groupByGlobalOrderWithDetails(GlobalOrderRequest subRequest){
       aggregate(ReturnRequest.GLOBAL_ORDER_PROPERTY, subRequest);
       return this;
    }







    public ReturnRequestRequest<T> groupById(){
       groupBy(ReturnRequest.ID_PROPERTY);
       return this;
    }

    public ReturnRequestRequest<T> groupByIdAs(String retName){
       groupBy(retName, ReturnRequest.ID_PROPERTY);
       return this;
    }

    public ReturnRequestRequest<T> groupByIdWithFunction(String retName, AggrFunction function){
       groupBy(retName, ReturnRequest.ID_PROPERTY, function);
       return this;
    }

    public ReturnRequestRequest<T> groupByRefundAmount(){
       groupBy(ReturnRequest.REFUND_AMOUNT_PROPERTY);
       return this;
    }

    public ReturnRequestRequest<T> groupByRefundAmountAs(String retName){
       groupBy(retName, ReturnRequest.REFUND_AMOUNT_PROPERTY);
       return this;
    }

    public ReturnRequestRequest<T> groupByRefundAmountWithFunction(String retName, AggrFunction function){
       groupBy(retName, ReturnRequest.REFUND_AMOUNT_PROPERTY, function);
       return this;
    }
    public ReturnRequestRequest<T> groupByCustomerWith(CustomerRequest subRequest){
       groupBy(ReturnRequest.CUSTOMER_PROPERTY, subRequest);
       return this;
    }
    public ReturnRequestRequest<T> groupByCustomer(){
       groupBy(ReturnRequest.CUSTOMER_PROPERTY);
       return this;
    }

    public ReturnRequestRequest<T> groupByCustomerAs(String retName){
       groupBy(retName, ReturnRequest.CUSTOMER_PROPERTY);
       return this;
    }

    public ReturnRequestRequest<T> groupByCustomerWithFunction(String retName, AggrFunction function){
       groupBy(retName, ReturnRequest.CUSTOMER_PROPERTY, function);
       return this;
    }
    public ReturnRequestRequest<T> groupByGlobalOrderWith(GlobalOrderRequest subRequest){
       groupBy(ReturnRequest.GLOBAL_ORDER_PROPERTY, subRequest);
       return this;
    }
    public ReturnRequestRequest<T> groupByGlobalOrder(){
       groupBy(ReturnRequest.GLOBAL_ORDER_PROPERTY);
       return this;
    }

    public ReturnRequestRequest<T> groupByGlobalOrderAs(String retName){
       groupBy(retName, ReturnRequest.GLOBAL_ORDER_PROPERTY);
       return this;
    }

    public ReturnRequestRequest<T> groupByGlobalOrderWithFunction(String retName, AggrFunction function){
       groupBy(retName, ReturnRequest.GLOBAL_ORDER_PROPERTY, function);
       return this;
    }

    public ReturnRequestRequest<T> groupByReason(){
       groupBy(ReturnRequest.REASON_PROPERTY);
       return this;
    }

    public ReturnRequestRequest<T> groupByReasonAs(String retName){
       groupBy(retName, ReturnRequest.REASON_PROPERTY);
       return this;
    }

    public ReturnRequestRequest<T> groupByReasonWithFunction(String retName, AggrFunction function){
       groupBy(retName, ReturnRequest.REASON_PROPERTY, function);
       return this;
    }

    public ReturnRequestRequest<T> groupByStatus(){
       groupBy(ReturnRequest.STATUS_PROPERTY);
       return this;
    }

    public ReturnRequestRequest<T> groupByStatusAs(String retName){
       groupBy(retName, ReturnRequest.STATUS_PROPERTY);
       return this;
    }

    public ReturnRequestRequest<T> groupByStatusWithFunction(String retName, AggrFunction function){
       groupBy(retName, ReturnRequest.STATUS_PROPERTY, function);
       return this;
    }

    public ReturnRequestRequest<T> groupByCreateTime(){
       groupBy(ReturnRequest.CREATE_TIME_PROPERTY);
       return this;
    }

    public ReturnRequestRequest<T> groupByCreateTimeAs(String retName){
       groupBy(retName, ReturnRequest.CREATE_TIME_PROPERTY);
       return this;
    }

    public ReturnRequestRequest<T> groupByCreateTimeWithFunction(String retName, AggrFunction function){
       groupBy(retName, ReturnRequest.CREATE_TIME_PROPERTY, function);
       return this;
    }

    public ReturnRequestRequest<T> groupByUpdateTime(){
       groupBy(ReturnRequest.UPDATE_TIME_PROPERTY);
       return this;
    }

    public ReturnRequestRequest<T> groupByUpdateTimeAs(String retName){
       groupBy(retName, ReturnRequest.UPDATE_TIME_PROPERTY);
       return this;
    }

    public ReturnRequestRequest<T> groupByUpdateTimeWithFunction(String retName, AggrFunction function){
       groupBy(retName, ReturnRequest.UPDATE_TIME_PROPERTY, function);
       return this;
    }

    public ReturnRequestRequest<T> groupByVersion(){
       groupBy(ReturnRequest.VERSION_PROPERTY);
       return this;
    }

    public ReturnRequestRequest<T> groupByVersionAs(String retName){
       groupBy(retName, ReturnRequest.VERSION_PROPERTY);
       return this;
    }

    public ReturnRequestRequest<T> groupByVersionWithFunction(String retName, AggrFunction function){
       groupBy(retName, ReturnRequest.VERSION_PROPERTY, function);
       return this;
    }



    public ReturnRequestRequest<T> orderByIdAscending(){
       addOrderByAscending(ReturnRequest.ID_PROPERTY);
       return this;
    }

    public ReturnRequestRequest<T> orderByIdDescending(){
       addOrderByDescending(ReturnRequest.ID_PROPERTY);
       return this;
    }

    public ReturnRequestRequest<T> orderByRefundAmountAscending(){
       addOrderByAscending(ReturnRequest.REFUND_AMOUNT_PROPERTY);
       return this;
    }

    public ReturnRequestRequest<T> orderByRefundAmountDescending(){
       addOrderByDescending(ReturnRequest.REFUND_AMOUNT_PROPERTY);
       return this;
    }

    public ReturnRequestRequest<T> orderByCustomerAscending(){
       addOrderByAscending(ReturnRequest.CUSTOMER_PROPERTY);
       return this;
    }

    public ReturnRequestRequest<T> orderByCustomerDescending(){
       addOrderByDescending(ReturnRequest.CUSTOMER_PROPERTY);
       return this;
    }

    public ReturnRequestRequest<T> orderByGlobalOrderAscending(){
       addOrderByAscending(ReturnRequest.GLOBAL_ORDER_PROPERTY);
       return this;
    }

    public ReturnRequestRequest<T> orderByGlobalOrderDescending(){
       addOrderByDescending(ReturnRequest.GLOBAL_ORDER_PROPERTY);
       return this;
    }

    public ReturnRequestRequest<T> orderByReasonAscending(){
       addOrderByAscending(ReturnRequest.REASON_PROPERTY);
       return this;
    }

    public ReturnRequestRequest<T> orderByReasonDescending(){
       addOrderByDescending(ReturnRequest.REASON_PROPERTY);
       return this;
    }
    public ReturnRequestRequest<T> orderByReasonAscendingUsingGBK(){
       addOrderByAscendingUsingGBK(ReturnRequest.REASON_PROPERTY);
       return this;
    }

    public ReturnRequestRequest<T> orderByReasonDescendingUsingGBK(){
       addOrderByDescendingUsingGBK(ReturnRequest.REASON_PROPERTY);
       return this;
    }
    public ReturnRequestRequest<T> orderByStatusAscending(){
       addOrderByAscending(ReturnRequest.STATUS_PROPERTY);
       return this;
    }

    public ReturnRequestRequest<T> orderByStatusDescending(){
       addOrderByDescending(ReturnRequest.STATUS_PROPERTY);
       return this;
    }
    public ReturnRequestRequest<T> orderByStatusAscendingUsingGBK(){
       addOrderByAscendingUsingGBK(ReturnRequest.STATUS_PROPERTY);
       return this;
    }

    public ReturnRequestRequest<T> orderByStatusDescendingUsingGBK(){
       addOrderByDescendingUsingGBK(ReturnRequest.STATUS_PROPERTY);
       return this;
    }
    public ReturnRequestRequest<T> orderByCreateTimeAscending(){
       addOrderByAscending(ReturnRequest.CREATE_TIME_PROPERTY);
       return this;
    }

    public ReturnRequestRequest<T> orderByCreateTimeDescending(){
       addOrderByDescending(ReturnRequest.CREATE_TIME_PROPERTY);
       return this;
    }

    public ReturnRequestRequest<T> orderByUpdateTimeAscending(){
       addOrderByAscending(ReturnRequest.UPDATE_TIME_PROPERTY);
       return this;
    }

    public ReturnRequestRequest<T> orderByUpdateTimeDescending(){
       addOrderByDescending(ReturnRequest.UPDATE_TIME_PROPERTY);
       return this;
    }

    public ReturnRequestRequest<T> orderByVersionAscending(){
       addOrderByAscending(ReturnRequest.VERSION_PROPERTY);
       return this;
    }

    public ReturnRequestRequest<T> orderByVersionDescending(){
       addOrderByDescending(ReturnRequest.VERSION_PROPERTY);
       return this;
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







   public ReturnRequestRequest<T> facetByCustomerAs(String facetName, CustomerRequest customer){
       return facetByCustomerAs(facetName, customer, true);
   }

   public ReturnRequestRequest<T> facetByCustomerAs(String facetName, CustomerRequest customer, boolean includeAllFacets){
       addFacet(facetName, ReturnRequest.CUSTOMER_PROPERTY, customer, includeAllFacets);
       return this;
   }
   public ReturnRequestRequest<T> facetByGlobalOrderAs(String facetName, GlobalOrderRequest globalOrder){
       return facetByGlobalOrderAs(facetName, globalOrder, true);
   }

   public ReturnRequestRequest<T> facetByGlobalOrderAs(String facetName, GlobalOrderRequest globalOrder, boolean includeAllFacets){
       addFacet(facetName, ReturnRequest.GLOBAL_ORDER_PROPERTY, globalOrder, includeAllFacets);
       return this;
   }


    /**
     * get topN records
     * @param topN  records number
     */
    public ReturnRequestRequest<T> top(int topN) {
        super.top(topN);
        return this;
    }

    /**
     * get records from offset(inclusive) to offset+size(exclusive)
     * @param offset record offset
     * @param size records number
     */
    public ReturnRequestRequest<T> offset(int offset, int size) {
        super.offset(offset, size);
        return this;
    }

    /**
     * retrieve all records
     */
    public ReturnRequestRequest<T> unlimited() {
        super.unlimited();
        return this;
    }

    /**
     * get records of one page
     * @param pageNumber page number(1-based)
     * @param pageSize page size
     */
    public ReturnRequestRequest<T> page(int pageNumber, int pageSize) {
        int offset = (pageNumber - 1) * pageSize;
        return offset(offset, pageSize);
   }

    /**
     * get records of one page, default page size is 10
     * @param pageNumber page number(1-based)
     */
    public ReturnRequestRequest<T> page(int pageNumber) {
        return page(pageNumber, 10);
   }
}