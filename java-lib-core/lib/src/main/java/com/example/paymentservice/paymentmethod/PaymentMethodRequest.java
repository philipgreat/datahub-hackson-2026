
package com.example.paymentservice.paymentmethod;

import com.example.paymentservice.Q;
import com.example.paymentservice.paymentaccount.PaymentAccount;
import com.example.paymentservice.paymentaccount.PaymentAccountRequest;
import com.example.paymentservice.paymenttransaction.PaymentTransaction;
import com.example.paymentservice.paymenttransaction.PaymentTransactionRequest;
import io.teaql.core.AggrFunction;
import io.teaql.core.BaseRequest;
import io.teaql.core.PropertyReference;
import io.teaql.core.SearchCriteria;
import io.teaql.core.SubQuerySearchCriteria;
import io.teaql.core.criteria.Operator;
import io.teaql.core.criteria.TwoOperatorCriteria;
import java.time.LocalDateTime;
import java.util.Date;

public class PaymentMethodRequest<T extends PaymentMethod> extends BaseRequest<T> {

    /**
     * @deprecated AI agents and business code must use the generated Q facade
     *             instead of constructing request builders directly.
     */
    @Deprecated
    public PaymentMethodRequest(Class<T> returnType){
        super(returnType);
        selectId();
        selectVersion();
    }

    public PaymentMethodRequest<T> comment(String comment){
         super.internalComment(comment);
         return this;
    }

    // purpose() 继承自 BaseRequest，返回 ExecutableRequest（终结方法）

    public PaymentMethodRequest<T> returnType(Class<? extends T> returnType){
        super.setReturnType(returnType);
        return this;
    }

    public PaymentMethodRequest<T> enableAggregationCache(long cacheExpiredMillis){
        super.enableAggregationCache();
        super.aggregateCacheTime(cacheExpiredMillis);
        return this;
    }

    public PaymentMethodRequest<T> enableAggregationCache(){
        return enableAggregationCache(0l);
    }


    public PaymentMethodRequest<T> propagateAggregationCache(long cacheExpiredMillis){
        super.propagateAggregationCache(cacheExpiredMillis);
        return this;
    }

    public PaymentMethodRequest<T> appendSearchCriteria(SearchCriteria searchCriteria){
        return (PaymentMethodRequest<T>)super.appendSearchCriteria(searchCriteria);
    }

    public PaymentMethodRequest<T> filter(String property1, Operator operator, String property2){
        return appendSearchCriteria(new TwoOperatorCriteria(operator, new PropertyReference(property1), new PropertyReference(property2)));
    }


    public PaymentMethodRequest<T> matchingAnyOf(PaymentMethodRequest paymentMethod){
        super.internalMatchAny(paymentMethod);
        return this;
    }

    public PaymentMethodRequest<T> enhanceChildrenIfNeeded(){
        return this;
    }

    public PaymentMethodRequest<T> withDeletedRows(){
        super.withDeletedRows();
        return this;
    }

    public PaymentMethodRequest<T> deletedRowsOnly(){
        super.deletedRowsOnly();
        return this;
    }

    public PaymentMethodRequest<T> selectSelf(){
        super.selectSelf();
        return selectId().selectPaymentAccountIdOnly().selectMethodType().selectLastFourDigits().selectCreateTime().selectUpdateTime().selectVersion();
    }

    public PaymentMethodRequest<T> selectSelfFields(){
        return selectSelf();
    }

    public PaymentMethodRequest<T> selectAll(){
        super.selectAll();
        return selectId().selectPaymentAccount().selectMethodType().selectLastFourDigits().selectCreateTime().selectUpdateTime().selectVersion();
    }

    public PaymentMethodRequest<T> selectChildren(){
        super.selectAny();
        selectPaymentTransactionList();
        return selectId().selectPaymentAccount().selectMethodType().selectLastFourDigits().selectCreateTime().selectUpdateTime().selectVersion();
    }


    public PaymentMethodRequest<T> selectId(){
       selectProperty(PaymentMethod.ID_PROPERTY);
       return this;
    }

    /**
     * fill the id with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  id) to fetch id property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public PaymentMethodRequest<T> unselectId(){
       unselectProperty(PaymentMethod.ID_PROPERTY);
       return this;
    }
    public PaymentMethodRequest<T> selectPaymentAccountIdOnly(){
       selectProperty(PaymentMethod.PAYMENT_ACCOUNT_PROPERTY);
       return this;
    }

    public PaymentMethodRequest<T> selectPaymentAccount(){
        return selectPaymentAccountWith(Q.paymentAccounts().unlimited().selectSelf());
    }

    public PaymentMethodRequest<T> selectPaymentAccountWith(PaymentAccountRequest paymentAccount){
       selectProperty(PaymentMethod.PAYMENT_ACCOUNT_PROPERTY);
       enhanceRelation(PaymentMethod.PAYMENT_ACCOUNT_PROPERTY, paymentAccount);
       return this;
    }

    public PaymentMethodRequest<T> unselectPaymentAccount(){
       unselectProperty(PaymentMethod.PAYMENT_ACCOUNT_PROPERTY);
       return this;
    }
    public PaymentMethodRequest<T> selectMethodType(){
       selectProperty(PaymentMethod.METHOD_TYPE_PROPERTY);
       return this;
    }

    /**
     * fill the methodType with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  methodType) to fetch methodType property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public PaymentMethodRequest<T> unselectMethodType(){
       unselectProperty(PaymentMethod.METHOD_TYPE_PROPERTY);
       return this;
    }
    public PaymentMethodRequest<T> selectLastFourDigits(){
       selectProperty(PaymentMethod.LAST_FOUR_DIGITS_PROPERTY);
       return this;
    }

    /**
     * fill the lastFourDigits with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  lastFourDigits) to fetch lastFourDigits property.
     * @param rawSqlSegment  customized rawSqlSegment
     */


    /**
     * fill the lastFourDigits with customized aggrFunction, TEAQL uses ({aggrFunction}(lastFourDigits) AS lastFourDigits to fetch lastFourDigits property.
     * @param aggrFunction  aggrFunction
     */
    public PaymentMethodRequest<T> selectLastFourDigits(AggrFunction aggrFunction){
       selectProperty(PaymentMethod.LAST_FOUR_DIGITS_PROPERTY, aggrFunction);
       return this;
    }


    public PaymentMethodRequest<T> unselectLastFourDigits(){
       unselectProperty(PaymentMethod.LAST_FOUR_DIGITS_PROPERTY);
       return this;
    }
    public PaymentMethodRequest<T> selectCreateTime(){
       selectProperty(PaymentMethod.CREATE_TIME_PROPERTY);
       return this;
    }

    /**
     * fill the createTime with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  createTime) to fetch createTime property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public PaymentMethodRequest<T> unselectCreateTime(){
       unselectProperty(PaymentMethod.CREATE_TIME_PROPERTY);
       return this;
    }
    public PaymentMethodRequest<T> selectUpdateTime(){
       selectProperty(PaymentMethod.UPDATE_TIME_PROPERTY);
       return this;
    }

    /**
     * fill the updateTime with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  updateTime) to fetch updateTime property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public PaymentMethodRequest<T> unselectUpdateTime(){
       unselectProperty(PaymentMethod.UPDATE_TIME_PROPERTY);
       return this;
    }
    public PaymentMethodRequest<T> selectVersion(){
       selectProperty(PaymentMethod.VERSION_PROPERTY);
       return this;
    }

    /**
     * fill the version with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  version) to fetch version property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public PaymentMethodRequest<T> unselectVersion(){
       unselectProperty(PaymentMethod.VERSION_PROPERTY);
       return this;
    }
    public PaymentMethodRequest<T> selectPaymentTransactionList(){
       return selectPaymentTransactionListWith(Q.paymentTransactions().selectSelf());
    }

    public PaymentMethodRequest<T> selectPaymentTransactionListWith(PaymentTransactionRequest paymentTransactionList){
       enhanceRelation(PaymentMethod.PAYMENT_TRANSACTION_LIST_PROPERTY, paymentTransactionList);
       return this;
    }

    public PaymentMethodRequest<T> withId(Operator operator, Object... values){
       return appendSearchCriteria(createIdCriteria(operator, values));
    }

    public SearchCriteria createIdCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(PaymentMethod.ID_PROPERTY, operator, values);
    }

    public PaymentMethodRequest<T> withIdIs(Long id){
       return withId(Operator.EQUAL, id);
    }
    public PaymentMethodRequest<T> withIdIn(Long... id){
       return withId(Operator.EQUAL, (Object[])id);
    }



    public PaymentMethodRequest<T> filterByPaymentAccount(PaymentAccount... paymentAccount){
      if (paymentAccount == null || paymentAccount.length == 0) {
        throw new IllegalArgumentException("filterByPaymentAccount parameter paymentAccount cannot be empty");
      }
      return appendSearchCriteria(createPaymentAccountCriteria(Operator.EQUAL, (Object[])paymentAccount));
    }

    public PaymentMethodRequest<T> withPaymentAccount(Operator operator, Object... values){
       return appendSearchCriteria(createPaymentAccountCriteria(operator, values));
    }

    public PaymentMethodRequest<T> withPaymentAccountIsUnknown(){
       return withPaymentAccount(Operator.IS_NULL);
    }

    public PaymentMethodRequest<T> withPaymentAccountIsKnown(){
       return withPaymentAccount(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createPaymentAccountCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(PaymentMethod.PAYMENT_ACCOUNT_PROPERTY, operator, values);
    }

    public PaymentMethodRequest<T> filterByPaymentAccount(Long paymentAccount){
      if(paymentAccount == null){
         return this;
      }
      return withPaymentAccount(Operator.EQUAL, paymentAccount);
    }
    public PaymentMethodRequest<T> withPaymentAccountMatching(PaymentAccountRequest paymentAccount){
       return appendSearchCriteria(new SubQuerySearchCriteria(PaymentMethod.PAYMENT_ACCOUNT_PROPERTY, paymentAccount, PaymentAccount.ID_PROPERTY));
    }

    public PaymentMethodRequest<T> filterByMethodType(String... methodType){
      if (methodType == null || methodType.length == 0) {
        throw new IllegalArgumentException("filterByMethodType parameter methodType cannot be empty");
      }
      return appendSearchCriteria(createMethodTypeCriteria(Operator.EQUAL, (Object[])methodType));
    }

    public PaymentMethodRequest<T> withMethodType(Operator operator, Object... values){
       return appendSearchCriteria(createMethodTypeCriteria(operator, values));
    }

    public PaymentMethodRequest<T> withMethodTypeIsUnknown(){
       return withMethodType(Operator.IS_NULL);
    }

    public PaymentMethodRequest<T> withMethodTypeIsKnown(){
       return withMethodType(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createMethodTypeCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(PaymentMethod.METHOD_TYPE_PROPERTY, operator, values);
    }

    public PaymentMethodRequest<T> withMethodTypeGreaterThan(String methodType){
       return withMethodType(Operator.GREATER_THAN, methodType);
    }

    public PaymentMethodRequest<T> withMethodTypeGreaterThanOrEqualTo(String methodType){
       return withMethodType(Operator.GREATER_THAN_OR_EQUAL, methodType);
    }

    public PaymentMethodRequest<T> withMethodTypeLessThan(String methodType){
       return withMethodType(Operator.LESS_THAN, methodType);
    }

    public PaymentMethodRequest<T> withMethodTypeLessThanOrEqualTo(String methodType){
       return withMethodType(Operator.LESS_THAN_OR_EQUAL, methodType);
    }

    public PaymentMethodRequest<T> withMethodTypeBetween(String startOfMethodType, String endOfMethodType){
       return withMethodType(Operator.BETWEEN, startOfMethodType, endOfMethodType);
    }
    public PaymentMethodRequest<T> withMethodTypeStartingWith(String methodType){
       return withMethodType(Operator.BEGIN_WITH, methodType);
    }
    public PaymentMethodRequest<T> withMethodTypeContaining(String methodType){
       return withMethodType(Operator.CONTAIN, methodType);
    }

    public PaymentMethodRequest<T> withMethodTypeEndingWith(String methodType){
       return withMethodType(Operator.END_WITH, methodType);
    }

    public PaymentMethodRequest<T> withMethodTypeIs(String methodType){
       return withMethodType(Operator.EQUAL, methodType);
    }

    public PaymentMethodRequest<T> withMethodTypeSoundingLike(String methodType){
       return withMethodType(Operator.SOUNDS_LIKE, methodType);
    }



    public PaymentMethodRequest<T> filterByLastFourDigits(Integer... lastFourDigits){
      if (lastFourDigits == null || lastFourDigits.length == 0) {
        throw new IllegalArgumentException("filterByLastFourDigits parameter lastFourDigits cannot be empty");
      }
      return appendSearchCriteria(createLastFourDigitsCriteria(Operator.EQUAL, (Object[])lastFourDigits));
    }

    public PaymentMethodRequest<T> withLastFourDigits(Operator operator, Object... values){
       return appendSearchCriteria(createLastFourDigitsCriteria(operator, values));
    }

    public PaymentMethodRequest<T> withLastFourDigitsIsUnknown(){
       return withLastFourDigits(Operator.IS_NULL);
    }

    public PaymentMethodRequest<T> withLastFourDigitsIsKnown(){
       return withLastFourDigits(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createLastFourDigitsCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(PaymentMethod.LAST_FOUR_DIGITS_PROPERTY, operator, values);
    }

    public PaymentMethodRequest<T> withLastFourDigitsGreaterThan(Integer lastFourDigits){
       return withLastFourDigits(Operator.GREATER_THAN, lastFourDigits);
    }

    public PaymentMethodRequest<T> withLastFourDigitsGreaterThanOrEqualTo(Integer lastFourDigits){
       return withLastFourDigits(Operator.GREATER_THAN_OR_EQUAL, lastFourDigits);
    }

    public PaymentMethodRequest<T> withLastFourDigitsLessThan(Integer lastFourDigits){
       return withLastFourDigits(Operator.LESS_THAN, lastFourDigits);
    }

    public PaymentMethodRequest<T> withLastFourDigitsLessThanOrEqualTo(Integer lastFourDigits){
       return withLastFourDigits(Operator.LESS_THAN_OR_EQUAL, lastFourDigits);
    }

    public PaymentMethodRequest<T> withLastFourDigitsBetween(Integer startOfLastFourDigits, Integer endOfLastFourDigits){
       return withLastFourDigits(Operator.BETWEEN, startOfLastFourDigits, endOfLastFourDigits);
    }



    public PaymentMethodRequest<T> filterByCreateTime(LocalDateTime... createTime){
      if (createTime == null || createTime.length == 0) {
        throw new IllegalArgumentException("filterByCreateTime parameter createTime cannot be empty");
      }
      return appendSearchCriteria(createCreateTimeCriteria(Operator.EQUAL, (Object[])createTime));
    }

    public PaymentMethodRequest<T> withCreateTime(Operator operator, Object... values){
       return appendSearchCriteria(createCreateTimeCriteria(operator, values));
    }

    public PaymentMethodRequest<T> withCreateTimeIsUnknown(){
       return withCreateTime(Operator.IS_NULL);
    }

    public PaymentMethodRequest<T> withCreateTimeIsKnown(){
       return withCreateTime(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createCreateTimeCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(PaymentMethod.CREATE_TIME_PROPERTY, operator, values);
    }

    public PaymentMethodRequest<T> withCreateTimeGreaterThan(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public PaymentMethodRequest<T> withCreateTimeGreaterThanOrEqualTo(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN_OR_EQUAL, createTime);
    }

    public PaymentMethodRequest<T> withCreateTimeLessThan(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public PaymentMethodRequest<T> withCreateTimeLessThanOrEqualTo(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN_OR_EQUAL, createTime);
    }

    public PaymentMethodRequest<T> withCreateTimeBetween(LocalDateTime startOfCreateTime, LocalDateTime endOfCreateTime){
       return withCreateTime(Operator.BETWEEN, startOfCreateTime, endOfCreateTime);
    }
    public PaymentMethodRequest<T> withCreateTimeBefore(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public PaymentMethodRequest<T> withCreateTimeBefore(Date createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public PaymentMethodRequest<T> withCreateTimeAfter(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public PaymentMethodRequest<T> withCreateTimeAfter(Date createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public PaymentMethodRequest<T> withCreateTimeBetween(Date startOfCreateTime, Date endOfCreateTime){
       return withCreateTime(Operator.BETWEEN, startOfCreateTime, endOfCreateTime);
    }




    public PaymentMethodRequest<T> filterByUpdateTime(LocalDateTime... updateTime){
      if (updateTime == null || updateTime.length == 0) {
        throw new IllegalArgumentException("filterByUpdateTime parameter updateTime cannot be empty");
      }
      return appendSearchCriteria(createUpdateTimeCriteria(Operator.EQUAL, (Object[])updateTime));
    }

    public PaymentMethodRequest<T> withUpdateTime(Operator operator, Object... values){
       return appendSearchCriteria(createUpdateTimeCriteria(operator, values));
    }

    public PaymentMethodRequest<T> withUpdateTimeIsUnknown(){
       return withUpdateTime(Operator.IS_NULL);
    }

    public PaymentMethodRequest<T> withUpdateTimeIsKnown(){
       return withUpdateTime(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createUpdateTimeCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(PaymentMethod.UPDATE_TIME_PROPERTY, operator, values);
    }

    public PaymentMethodRequest<T> withUpdateTimeGreaterThan(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public PaymentMethodRequest<T> withUpdateTimeGreaterThanOrEqualTo(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN_OR_EQUAL, updateTime);
    }

    public PaymentMethodRequest<T> withUpdateTimeLessThan(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public PaymentMethodRequest<T> withUpdateTimeLessThanOrEqualTo(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN_OR_EQUAL, updateTime);
    }

    public PaymentMethodRequest<T> withUpdateTimeBetween(LocalDateTime startOfUpdateTime, LocalDateTime endOfUpdateTime){
       return withUpdateTime(Operator.BETWEEN, startOfUpdateTime, endOfUpdateTime);
    }
    public PaymentMethodRequest<T> withUpdateTimeBefore(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public PaymentMethodRequest<T> withUpdateTimeBefore(Date updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public PaymentMethodRequest<T> withUpdateTimeAfter(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public PaymentMethodRequest<T> withUpdateTimeAfter(Date updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public PaymentMethodRequest<T> withUpdateTimeBetween(Date startOfUpdateTime, Date endOfUpdateTime){
       return withUpdateTime(Operator.BETWEEN, startOfUpdateTime, endOfUpdateTime);
    }




    public PaymentMethodRequest<T> filterByVersion(Long... version){
      if (version == null || version.length == 0) {
        throw new IllegalArgumentException("filterByVersion parameter version cannot be empty");
      }
      return appendSearchCriteria(createVersionCriteria(Operator.EQUAL, (Object[])version));
    }

    public PaymentMethodRequest<T> withVersion(Operator operator, Object... values){
       return appendSearchCriteria(createVersionCriteria(operator, values));
    }

    public PaymentMethodRequest<T> withVersionIsUnknown(){
       return withVersion(Operator.IS_NULL);
    }

    public PaymentMethodRequest<T> withVersionIsKnown(){
       return withVersion(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createVersionCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(PaymentMethod.VERSION_PROPERTY, operator, values);
    }

    public PaymentMethodRequest<T> withVersionGreaterThan(Long version){
       return withVersion(Operator.GREATER_THAN, version);
    }

    public PaymentMethodRequest<T> withVersionGreaterThanOrEqualTo(Long version){
       return withVersion(Operator.GREATER_THAN_OR_EQUAL, version);
    }

    public PaymentMethodRequest<T> withVersionLessThan(Long version){
       return withVersion(Operator.LESS_THAN, version);
    }

    public PaymentMethodRequest<T> withVersionLessThanOrEqualTo(Long version){
       return withVersion(Operator.LESS_THAN_OR_EQUAL, version);
    }

    public PaymentMethodRequest<T> withVersionBetween(Long startOfVersion, Long endOfVersion){
       return withVersion(Operator.BETWEEN, startOfVersion, endOfVersion);
    }

    public PaymentMethodRequest<T> withPaymentTransactionListMatching(PaymentTransactionRequest paymentTransactionRequest){
        return appendSearchCriteria(new SubQuerySearchCriteria(PaymentMethod.ID_PROPERTY, paymentTransactionRequest, PaymentTransaction.PAYMENT_METHOD_PROPERTY));
    }

    public PaymentMethodRequest<T> withoutPaymentTransactionListMatching(PaymentTransactionRequest paymentTransactionRequest){
        return appendSearchCriteria(SearchCriteria.not(new SubQuerySearchCriteria(PaymentMethod.ID_PROPERTY, paymentTransactionRequest, PaymentTransaction.PAYMENT_METHOD_PROPERTY)));
    }

    public PaymentMethodRequest<T> havePaymentTransactions(){
        return withPaymentTransactionListMatching(Q.paymentTransactions().unlimited());
    }

    public PaymentMethodRequest<T> haveNoPaymentTransactions(){
        return withoutPaymentTransactionListMatching(Q.paymentTransactions().unlimited());
    }

    public PaymentMethodRequest<T> count(){
        super.count();
        return this;
    }
    public PaymentMethodRequest<T> countAs(String retName){
        super.count(retName);
        return this;
    }
    public PaymentMethodRequest minLastFourDigits(){
        return minLastFourDigitsAs(prefix("minOf",PaymentMethod.LAST_FOUR_DIGITS_PROPERTY));
    }

    public PaymentMethodRequest minLastFourDigitsAs(String retName){
        super.min(retName, PaymentMethod.LAST_FOUR_DIGITS_PROPERTY);
        return this;
    }
    public PaymentMethodRequest maxLastFourDigits(){
        return maxLastFourDigitsAs(prefix("maxOf",PaymentMethod.LAST_FOUR_DIGITS_PROPERTY));
    }

    public PaymentMethodRequest maxLastFourDigitsAs(String retName){
        super.max(retName, PaymentMethod.LAST_FOUR_DIGITS_PROPERTY);
        return this;
    }
    public PaymentMethodRequest sumLastFourDigits(){
        return sumLastFourDigitsAs(prefix("sumOf",PaymentMethod.LAST_FOUR_DIGITS_PROPERTY));
    }

    public PaymentMethodRequest sumLastFourDigitsAs(String retName){
        super.sum(retName, PaymentMethod.LAST_FOUR_DIGITS_PROPERTY);
        return this;
    }
    public PaymentMethodRequest avgLastFourDigits(){
        return avgLastFourDigitsAs(prefix("avgOf",PaymentMethod.LAST_FOUR_DIGITS_PROPERTY));
    }

    public PaymentMethodRequest avgLastFourDigitsAs(String retName){
        super.avg(retName, PaymentMethod.LAST_FOUR_DIGITS_PROPERTY);
        return this;
    }
    public PaymentMethodRequest standardDeviationLastFourDigits(){
        return standardDeviationLastFourDigitsAs(prefix("standardDeviationOf",PaymentMethod.LAST_FOUR_DIGITS_PROPERTY));
    }

    public PaymentMethodRequest standardDeviationLastFourDigitsAs(String retName){
        super.standardDeviation(retName, PaymentMethod.LAST_FOUR_DIGITS_PROPERTY);
        return this;
    }
    public PaymentMethodRequest squareRootOfPopulationStandardDeviationLastFourDigits(){
        return squareRootOfPopulationStandardDeviationLastFourDigitsAs(prefix("squareRootOfPopulationStandardDeviationOf",PaymentMethod.LAST_FOUR_DIGITS_PROPERTY));
    }

    public PaymentMethodRequest squareRootOfPopulationStandardDeviationLastFourDigitsAs(String retName){
        super.squareRootOfPopulationStandardDeviation(retName, PaymentMethod.LAST_FOUR_DIGITS_PROPERTY);
        return this;
    }
    public PaymentMethodRequest sampleVarianceLastFourDigits(){
        return sampleVarianceLastFourDigitsAs(prefix("sampleVarianceOf",PaymentMethod.LAST_FOUR_DIGITS_PROPERTY));
    }

    public PaymentMethodRequest sampleVarianceLastFourDigitsAs(String retName){
        super.sampleVariance(retName, PaymentMethod.LAST_FOUR_DIGITS_PROPERTY);
        return this;
    }
    public PaymentMethodRequest samplePopulationVarianceLastFourDigits(){
        return samplePopulationVarianceLastFourDigitsAs(prefix("samplePopulationVarianceOf",PaymentMethod.LAST_FOUR_DIGITS_PROPERTY));
    }

    public PaymentMethodRequest samplePopulationVarianceLastFourDigitsAs(String retName){
        super.samplePopulationVariance(retName, PaymentMethod.LAST_FOUR_DIGITS_PROPERTY);
        return this;
    }
    public PaymentMethodRequest<T> groupByPaymentAccountWithDetails(){
       return groupByPaymentAccountWithDetails(Q.paymentAccounts().unlimited());
    }

    public PaymentMethodRequest<T> groupByPaymentAccountWithDetails(PaymentAccountRequest subRequest){
       aggregate(PaymentMethod.PAYMENT_ACCOUNT_PROPERTY, subRequest);
       return this;
    }






    public PaymentMethodRequest<T> groupByPaymentTransactionsWithDetails(PaymentTransactionRequest subRequest){
       aggregate(PaymentMethod.PAYMENT_TRANSACTION_LIST_PROPERTY, subRequest);
       return this;
    }

    public PaymentMethodRequest<T> groupById(){
       groupBy(PaymentMethod.ID_PROPERTY);
       return this;
    }

    public PaymentMethodRequest<T> groupByIdAs(String retName){
       groupBy(retName, PaymentMethod.ID_PROPERTY);
       return this;
    }

    public PaymentMethodRequest<T> groupByIdWithFunction(String retName, AggrFunction function){
       groupBy(retName, PaymentMethod.ID_PROPERTY, function);
       return this;
    }
    public PaymentMethodRequest<T> groupByPaymentAccountWith(PaymentAccountRequest subRequest){
       groupBy(PaymentMethod.PAYMENT_ACCOUNT_PROPERTY, subRequest);
       return this;
    }
    public PaymentMethodRequest<T> groupByPaymentAccount(){
       groupBy(PaymentMethod.PAYMENT_ACCOUNT_PROPERTY);
       return this;
    }

    public PaymentMethodRequest<T> groupByPaymentAccountAs(String retName){
       groupBy(retName, PaymentMethod.PAYMENT_ACCOUNT_PROPERTY);
       return this;
    }

    public PaymentMethodRequest<T> groupByPaymentAccountWithFunction(String retName, AggrFunction function){
       groupBy(retName, PaymentMethod.PAYMENT_ACCOUNT_PROPERTY, function);
       return this;
    }

    public PaymentMethodRequest<T> groupByMethodType(){
       groupBy(PaymentMethod.METHOD_TYPE_PROPERTY);
       return this;
    }

    public PaymentMethodRequest<T> groupByMethodTypeAs(String retName){
       groupBy(retName, PaymentMethod.METHOD_TYPE_PROPERTY);
       return this;
    }

    public PaymentMethodRequest<T> groupByMethodTypeWithFunction(String retName, AggrFunction function){
       groupBy(retName, PaymentMethod.METHOD_TYPE_PROPERTY, function);
       return this;
    }

    public PaymentMethodRequest<T> groupByLastFourDigits(){
       groupBy(PaymentMethod.LAST_FOUR_DIGITS_PROPERTY);
       return this;
    }

    public PaymentMethodRequest<T> groupByLastFourDigitsAs(String retName){
       groupBy(retName, PaymentMethod.LAST_FOUR_DIGITS_PROPERTY);
       return this;
    }

    public PaymentMethodRequest<T> groupByLastFourDigitsWithFunction(String retName, AggrFunction function){
       groupBy(retName, PaymentMethod.LAST_FOUR_DIGITS_PROPERTY, function);
       return this;
    }

    public PaymentMethodRequest<T> groupByCreateTime(){
       groupBy(PaymentMethod.CREATE_TIME_PROPERTY);
       return this;
    }

    public PaymentMethodRequest<T> groupByCreateTimeAs(String retName){
       groupBy(retName, PaymentMethod.CREATE_TIME_PROPERTY);
       return this;
    }

    public PaymentMethodRequest<T> groupByCreateTimeWithFunction(String retName, AggrFunction function){
       groupBy(retName, PaymentMethod.CREATE_TIME_PROPERTY, function);
       return this;
    }

    public PaymentMethodRequest<T> groupByUpdateTime(){
       groupBy(PaymentMethod.UPDATE_TIME_PROPERTY);
       return this;
    }

    public PaymentMethodRequest<T> groupByUpdateTimeAs(String retName){
       groupBy(retName, PaymentMethod.UPDATE_TIME_PROPERTY);
       return this;
    }

    public PaymentMethodRequest<T> groupByUpdateTimeWithFunction(String retName, AggrFunction function){
       groupBy(retName, PaymentMethod.UPDATE_TIME_PROPERTY, function);
       return this;
    }

    public PaymentMethodRequest<T> groupByVersion(){
       groupBy(PaymentMethod.VERSION_PROPERTY);
       return this;
    }

    public PaymentMethodRequest<T> groupByVersionAs(String retName){
       groupBy(retName, PaymentMethod.VERSION_PROPERTY);
       return this;
    }

    public PaymentMethodRequest<T> groupByVersionWithFunction(String retName, AggrFunction function){
       groupBy(retName, PaymentMethod.VERSION_PROPERTY, function);
       return this;
    }



    public PaymentMethodRequest<T> orderByIdAscending(){
       addOrderByAscending(PaymentMethod.ID_PROPERTY);
       return this;
    }

    public PaymentMethodRequest<T> orderByIdDescending(){
       addOrderByDescending(PaymentMethod.ID_PROPERTY);
       return this;
    }

    public PaymentMethodRequest<T> orderByPaymentAccountAscending(){
       addOrderByAscending(PaymentMethod.PAYMENT_ACCOUNT_PROPERTY);
       return this;
    }

    public PaymentMethodRequest<T> orderByPaymentAccountDescending(){
       addOrderByDescending(PaymentMethod.PAYMENT_ACCOUNT_PROPERTY);
       return this;
    }

    public PaymentMethodRequest<T> orderByMethodTypeAscending(){
       addOrderByAscending(PaymentMethod.METHOD_TYPE_PROPERTY);
       return this;
    }

    public PaymentMethodRequest<T> orderByMethodTypeDescending(){
       addOrderByDescending(PaymentMethod.METHOD_TYPE_PROPERTY);
       return this;
    }
    public PaymentMethodRequest<T> orderByMethodTypeAscendingUsingGBK(){
       addOrderByAscendingUsingGBK(PaymentMethod.METHOD_TYPE_PROPERTY);
       return this;
    }

    public PaymentMethodRequest<T> orderByMethodTypeDescendingUsingGBK(){
       addOrderByDescendingUsingGBK(PaymentMethod.METHOD_TYPE_PROPERTY);
       return this;
    }
    public PaymentMethodRequest<T> orderByLastFourDigitsAscending(){
       addOrderByAscending(PaymentMethod.LAST_FOUR_DIGITS_PROPERTY);
       return this;
    }

    public PaymentMethodRequest<T> orderByLastFourDigitsDescending(){
       addOrderByDescending(PaymentMethod.LAST_FOUR_DIGITS_PROPERTY);
       return this;
    }

    public PaymentMethodRequest<T> orderByCreateTimeAscending(){
       addOrderByAscending(PaymentMethod.CREATE_TIME_PROPERTY);
       return this;
    }

    public PaymentMethodRequest<T> orderByCreateTimeDescending(){
       addOrderByDescending(PaymentMethod.CREATE_TIME_PROPERTY);
       return this;
    }

    public PaymentMethodRequest<T> orderByUpdateTimeAscending(){
       addOrderByAscending(PaymentMethod.UPDATE_TIME_PROPERTY);
       return this;
    }

    public PaymentMethodRequest<T> orderByUpdateTimeDescending(){
       addOrderByDescending(PaymentMethod.UPDATE_TIME_PROPERTY);
       return this;
    }

    public PaymentMethodRequest<T> orderByVersionAscending(){
       addOrderByAscending(PaymentMethod.VERSION_PROPERTY);
       return this;
    }

    public PaymentMethodRequest<T> orderByVersionDescending(){
       addOrderByDescending(PaymentMethod.VERSION_PROPERTY);
       return this;
    }


    public PaymentMethodRequest<T> statsFromPaymentTransactionsAs(String name, PaymentTransactionRequest subRequest){
       return statsFromPaymentTransactionsAs(name, subRequest, false);
    }

    public PaymentMethodRequest<T> statsFromPaymentTransactionsAs(String name, PaymentTransactionRequest subRequest, boolean singleResult){
       subRequest.setPartitionProperty(PaymentTransaction.PAYMENT_METHOD_PROPERTY);
       addAggregateDynamicProperty(name, subRequest, singleResult);
       return this;
    }

    public PaymentMethodRequest<T> statsFromPaymentTransactions(PaymentTransactionRequest subRequest){
       return statsFromPaymentTransactionsAs(REFINEMENTS, subRequest);
    }
    public PaymentAccountRequest rollUpToPaymentAccount(){
       PaymentAccountRequest paymentAccount = Q.paymentAccounts().unlimited();
       this.withPaymentAccountMatching(paymentAccount)
           .groupByPaymentAccountWith(paymentAccount);
       return paymentAccount;
    }






    public PaymentMethodRequest<T> countPaymentTransactions(){
        return countPaymentTransactionsAs("Count");
    }

    public PaymentMethodRequest<T> countPaymentTransactionsAs(String name){
        return countPaymentTransactionsWith(name, Q.paymentTransactions().unlimited());
    }

    public PaymentMethodRequest<T> countPaymentTransactionsWith(String name, PaymentTransactionRequest subRequest){
        return statsFromPaymentTransactionsAs(name, subRequest.count(), true);
    }
    public PaymentMethodRequest<T> minTransactionAmountOfPaymentTransactions(){
        return minTransactionAmountOfPaymentTransactionsAs("minTransactionAmountOfPaymentTransactions");
    }

    public PaymentMethodRequest<T> minTransactionAmountOfPaymentTransactionsAs(String name){
        return minTransactionAmountOfPaymentTransactionsAs(name, Q.paymentTransactions().unlimited());
    }

    public PaymentMethodRequest<T> minTransactionAmountOfPaymentTransactionsAs(String name, PaymentTransactionRequest subRequest){
        return statsFromPaymentTransactionsAs(name, subRequest.minTransactionAmount(), true);
    }
    public PaymentMethodRequest<T> maxTransactionAmountOfPaymentTransactions(){
        return maxTransactionAmountOfPaymentTransactionsAs("maxTransactionAmountOfPaymentTransactions");
    }

    public PaymentMethodRequest<T> maxTransactionAmountOfPaymentTransactionsAs(String name){
        return maxTransactionAmountOfPaymentTransactionsAs(name, Q.paymentTransactions().unlimited());
    }

    public PaymentMethodRequest<T> maxTransactionAmountOfPaymentTransactionsAs(String name, PaymentTransactionRequest subRequest){
        return statsFromPaymentTransactionsAs(name, subRequest.maxTransactionAmount(), true);
    }
    public PaymentMethodRequest<T> sumTransactionAmountOfPaymentTransactions(){
        return sumTransactionAmountOfPaymentTransactionsAs("sumTransactionAmountOfPaymentTransactions");
    }

    public PaymentMethodRequest<T> sumTransactionAmountOfPaymentTransactionsAs(String name){
        return sumTransactionAmountOfPaymentTransactionsAs(name, Q.paymentTransactions().unlimited());
    }

    public PaymentMethodRequest<T> sumTransactionAmountOfPaymentTransactionsAs(String name, PaymentTransactionRequest subRequest){
        return statsFromPaymentTransactionsAs(name, subRequest.sumTransactionAmount(), true);
    }
    public PaymentMethodRequest<T> avgTransactionAmountOfPaymentTransactions(){
        return avgTransactionAmountOfPaymentTransactionsAs("avgTransactionAmountOfPaymentTransactions");
    }

    public PaymentMethodRequest<T> avgTransactionAmountOfPaymentTransactionsAs(String name){
        return avgTransactionAmountOfPaymentTransactionsAs(name, Q.paymentTransactions().unlimited());
    }

    public PaymentMethodRequest<T> avgTransactionAmountOfPaymentTransactionsAs(String name, PaymentTransactionRequest subRequest){
        return statsFromPaymentTransactionsAs(name, subRequest.avgTransactionAmount(), true);
    }
    public PaymentMethodRequest<T> standardDeviationTransactionAmountOfPaymentTransactions(){
        return standardDeviationTransactionAmountOfPaymentTransactionsAs("stdDevTransactionAmountOfPaymentTransactions");
    }

    public PaymentMethodRequest<T> standardDeviationTransactionAmountOfPaymentTransactionsAs(String name){
        return standardDeviationTransactionAmountOfPaymentTransactionsAs(name, Q.paymentTransactions().unlimited());
    }

    public PaymentMethodRequest<T> standardDeviationTransactionAmountOfPaymentTransactionsAs(String name, PaymentTransactionRequest subRequest){
        return statsFromPaymentTransactionsAs(name, subRequest.standardDeviationTransactionAmount(), true);
    }
    public PaymentMethodRequest<T> squareRootOfPopulationStandardDeviationTransactionAmountOfPaymentTransactions(){
        return squareRootOfPopulationStandardDeviationTransactionAmountOfPaymentTransactionsAs("stdDevPopTransactionAmountOfPaymentTransactions");
    }

    public PaymentMethodRequest<T> squareRootOfPopulationStandardDeviationTransactionAmountOfPaymentTransactionsAs(String name){
        return squareRootOfPopulationStandardDeviationTransactionAmountOfPaymentTransactionsAs(name, Q.paymentTransactions().unlimited());
    }

    public PaymentMethodRequest<T> squareRootOfPopulationStandardDeviationTransactionAmountOfPaymentTransactionsAs(String name, PaymentTransactionRequest subRequest){
        return statsFromPaymentTransactionsAs(name, subRequest.squareRootOfPopulationStandardDeviationTransactionAmount(), true);
    }
    public PaymentMethodRequest<T> sampleVarianceTransactionAmountOfPaymentTransactions(){
        return sampleVarianceTransactionAmountOfPaymentTransactionsAs("varSampTransactionAmountOfPaymentTransactions");
    }

    public PaymentMethodRequest<T> sampleVarianceTransactionAmountOfPaymentTransactionsAs(String name){
        return sampleVarianceTransactionAmountOfPaymentTransactionsAs(name, Q.paymentTransactions().unlimited());
    }

    public PaymentMethodRequest<T> sampleVarianceTransactionAmountOfPaymentTransactionsAs(String name, PaymentTransactionRequest subRequest){
        return statsFromPaymentTransactionsAs(name, subRequest.sampleVarianceTransactionAmount(), true);
    }
    public PaymentMethodRequest<T> samplePopulationVarianceTransactionAmountOfPaymentTransactions(){
        return samplePopulationVarianceTransactionAmountOfPaymentTransactionsAs("varPopTransactionAmountOfPaymentTransactions");
    }

    public PaymentMethodRequest<T> samplePopulationVarianceTransactionAmountOfPaymentTransactionsAs(String name){
        return samplePopulationVarianceTransactionAmountOfPaymentTransactionsAs(name, Q.paymentTransactions().unlimited());
    }

    public PaymentMethodRequest<T> samplePopulationVarianceTransactionAmountOfPaymentTransactionsAs(String name, PaymentTransactionRequest subRequest){
        return statsFromPaymentTransactionsAs(name, subRequest.samplePopulationVarianceTransactionAmount(), true);
    }

   public PaymentMethodRequest<T> facetByPaymentAccountAs(String facetName, PaymentAccountRequest paymentAccount){
       return facetByPaymentAccountAs(facetName, paymentAccount, true);
   }

   public PaymentMethodRequest<T> facetByPaymentAccountAs(String facetName, PaymentAccountRequest paymentAccount, boolean includeAllFacets){
       addFacet(facetName, PaymentMethod.PAYMENT_ACCOUNT_PROPERTY, paymentAccount, includeAllFacets);
       return this;
   }


    /**
     * get topN records
     * @param topN  records number
     */
    public PaymentMethodRequest<T> top(int topN) {
        super.top(topN);
        return this;
    }

    /**
     * get records from offset(inclusive) to offset+size(exclusive)
     * @param offset record offset
     * @param size records number
     */
    public PaymentMethodRequest<T> offset(int offset, int size) {
        super.offset(offset, size);
        return this;
    }

    /**
     * retrieve all records
     */
    public PaymentMethodRequest<T> unlimited() {
        super.unlimited();
        return this;
    }

    /**
     * get records of one page
     * @param pageNumber page number(1-based)
     * @param pageSize page size
     */
    public PaymentMethodRequest<T> page(int pageNumber, int pageSize) {
        int offset = (pageNumber - 1) * pageSize;
        return offset(offset, pageSize);
   }

    /**
     * get records of one page, default page size is 10
     * @param pageNumber page number(1-based)
     */
    public PaymentMethodRequest<T> page(int pageNumber) {
        return page(pageNumber, 10);
   }
}