
package com.example.paymentservice.paymenttransaction;

import io.teaql.core.AggrFunction;
import io.teaql.core.BaseRequest;
import io.teaql.core.PropertyReference;
import io.teaql.core.SearchCriteria;
import io.teaql.core.criteria.Operator;
import io.teaql.core.criteria.TwoOperatorCriteria;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

public class PaymentTransactionRequest<T extends PaymentTransaction> extends BaseRequest<T> {

    /**
     * @deprecated AI agents and business code must use the generated Q facade
     *             instead of constructing request builders directly.
     */
    @Deprecated
    public PaymentTransactionRequest(Class<T> returnType){
        super(returnType);
        selectId();
        selectVersion();
    }

    public PaymentTransactionRequest<T> comment(String comment){
         super.internalComment(comment);
         return this;
    }

    // purpose() 继承自 BaseRequest，返回 ExecutableRequest（终结方法）

    public PaymentTransactionRequest<T> returnType(Class<? extends T> returnType){
        super.setReturnType(returnType);
        return this;
    }

    public PaymentTransactionRequest<T> enableAggregationCache(long cacheExpiredMillis){
        super.enableAggregationCache();
        super.aggregateCacheTime(cacheExpiredMillis);
        return this;
    }

    public PaymentTransactionRequest<T> enableAggregationCache(){
        return enableAggregationCache(0l);
    }


    public PaymentTransactionRequest<T> propagateAggregationCache(long cacheExpiredMillis){
        super.propagateAggregationCache(cacheExpiredMillis);
        return this;
    }

    public PaymentTransactionRequest<T> appendSearchCriteria(SearchCriteria searchCriteria){
        return (PaymentTransactionRequest<T>)super.appendSearchCriteria(searchCriteria);
    }

    public PaymentTransactionRequest<T> filter(String property1, Operator operator, String property2){
        return appendSearchCriteria(new TwoOperatorCriteria(operator, new PropertyReference(property1), new PropertyReference(property2)));
    }


    public PaymentTransactionRequest<T> matchingAnyOf(PaymentTransactionRequest paymentTransaction){
        super.internalMatchAny(paymentTransaction);
        return this;
    }

    public PaymentTransactionRequest<T> enhanceChildrenIfNeeded(){
        return this;
    }

    public PaymentTransactionRequest<T> withDeletedRows(){
        super.withDeletedRows();
        return this;
    }

    public PaymentTransactionRequest<T> deletedRowsOnly(){
        super.deletedRowsOnly();
        return this;
    }

    public PaymentTransactionRequest<T> selectSelf(){
        super.selectSelf();
        return selectId().selectPaymentAccount().selectCurrencyCode().selectPaymentMethod().selectTransactionAmount().selectCreateTime().selectUpdateTime().selectVersion();
    }

    public PaymentTransactionRequest<T> selectSelfFields(){
        return selectSelf();
    }

    public PaymentTransactionRequest<T> selectAll(){
        super.selectAll();
        return selectId().selectPaymentAccount().selectCurrencyCode().selectPaymentMethod().selectTransactionAmount().selectCreateTime().selectUpdateTime().selectVersion();
    }

    public PaymentTransactionRequest<T> selectChildren(){
        super.selectAny();
        return selectId().selectPaymentAccount().selectCurrencyCode().selectPaymentMethod().selectTransactionAmount().selectCreateTime().selectUpdateTime().selectVersion();
    }


    public PaymentTransactionRequest<T> selectId(){
       selectProperty(PaymentTransaction.ID_PROPERTY);
       return this;
    }

    /**
     * fill the id with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  id) to fetch id property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public PaymentTransactionRequest<T> unselectId(){
       unselectProperty(PaymentTransaction.ID_PROPERTY);
       return this;
    }
    public PaymentTransactionRequest<T> selectPaymentAccount(){
       selectProperty(PaymentTransaction.PAYMENT_ACCOUNT_PROPERTY);
       return this;
    }

    /**
     * fill the paymentAccount with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  paymentAccount) to fetch paymentAccount property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public PaymentTransactionRequest<T> unselectPaymentAccount(){
       unselectProperty(PaymentTransaction.PAYMENT_ACCOUNT_PROPERTY);
       return this;
    }
    public PaymentTransactionRequest<T> selectCurrencyCode(){
       selectProperty(PaymentTransaction.CURRENCY_CODE_PROPERTY);
       return this;
    }

    /**
     * fill the currencyCode with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  currencyCode) to fetch currencyCode property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public PaymentTransactionRequest<T> unselectCurrencyCode(){
       unselectProperty(PaymentTransaction.CURRENCY_CODE_PROPERTY);
       return this;
    }
    public PaymentTransactionRequest<T> selectPaymentMethod(){
       selectProperty(PaymentTransaction.PAYMENT_METHOD_PROPERTY);
       return this;
    }

    /**
     * fill the paymentMethod with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  paymentMethod) to fetch paymentMethod property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public PaymentTransactionRequest<T> unselectPaymentMethod(){
       unselectProperty(PaymentTransaction.PAYMENT_METHOD_PROPERTY);
       return this;
    }
    public PaymentTransactionRequest<T> selectTransactionAmount(){
       selectProperty(PaymentTransaction.TRANSACTION_AMOUNT_PROPERTY);
       return this;
    }

    /**
     * fill the transactionAmount with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  transactionAmount) to fetch transactionAmount property.
     * @param rawSqlSegment  customized rawSqlSegment
     */


    /**
     * fill the transactionAmount with customized aggrFunction, TEAQL uses ({aggrFunction}(transactionAmount) AS transactionAmount to fetch transactionAmount property.
     * @param aggrFunction  aggrFunction
     */
    public PaymentTransactionRequest<T> selectTransactionAmount(AggrFunction aggrFunction){
       selectProperty(PaymentTransaction.TRANSACTION_AMOUNT_PROPERTY, aggrFunction);
       return this;
    }


    public PaymentTransactionRequest<T> unselectTransactionAmount(){
       unselectProperty(PaymentTransaction.TRANSACTION_AMOUNT_PROPERTY);
       return this;
    }
    public PaymentTransactionRequest<T> selectCreateTime(){
       selectProperty(PaymentTransaction.CREATE_TIME_PROPERTY);
       return this;
    }

    /**
     * fill the createTime with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  createTime) to fetch createTime property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public PaymentTransactionRequest<T> unselectCreateTime(){
       unselectProperty(PaymentTransaction.CREATE_TIME_PROPERTY);
       return this;
    }
    public PaymentTransactionRequest<T> selectUpdateTime(){
       selectProperty(PaymentTransaction.UPDATE_TIME_PROPERTY);
       return this;
    }

    /**
     * fill the updateTime with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  updateTime) to fetch updateTime property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public PaymentTransactionRequest<T> unselectUpdateTime(){
       unselectProperty(PaymentTransaction.UPDATE_TIME_PROPERTY);
       return this;
    }
    public PaymentTransactionRequest<T> selectVersion(){
       selectProperty(PaymentTransaction.VERSION_PROPERTY);
       return this;
    }

    /**
     * fill the version with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  version) to fetch version property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public PaymentTransactionRequest<T> unselectVersion(){
       unselectProperty(PaymentTransaction.VERSION_PROPERTY);
       return this;
    }

    public PaymentTransactionRequest<T> withId(Operator operator, Object... values){
       return appendSearchCriteria(createIdCriteria(operator, values));
    }

    public SearchCriteria createIdCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(PaymentTransaction.ID_PROPERTY, operator, values);
    }

    public PaymentTransactionRequest<T> withIdIs(Long id){
       return withId(Operator.EQUAL, id);
    }
    public PaymentTransactionRequest<T> withIdIn(Long... id){
       return withId(Operator.EQUAL, (Object[])id);
    }



    public PaymentTransactionRequest<T> filterByPaymentAccount(String... paymentAccount){
      if (paymentAccount == null || paymentAccount.length == 0) {
        throw new IllegalArgumentException("filterByPaymentAccount parameter paymentAccount cannot be empty");
      }
      return appendSearchCriteria(createPaymentAccountCriteria(Operator.EQUAL, (Object[])paymentAccount));
    }

    public PaymentTransactionRequest<T> withPaymentAccount(Operator operator, Object... values){
       return appendSearchCriteria(createPaymentAccountCriteria(operator, values));
    }

    public PaymentTransactionRequest<T> withPaymentAccountIsUnknown(){
       return withPaymentAccount(Operator.IS_NULL);
    }

    public PaymentTransactionRequest<T> withPaymentAccountIsKnown(){
       return withPaymentAccount(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createPaymentAccountCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(PaymentTransaction.PAYMENT_ACCOUNT_PROPERTY, operator, values);
    }

    public PaymentTransactionRequest<T> withPaymentAccountGreaterThan(String paymentAccount){
       return withPaymentAccount(Operator.GREATER_THAN, paymentAccount);
    }

    public PaymentTransactionRequest<T> withPaymentAccountGreaterThanOrEqualTo(String paymentAccount){
       return withPaymentAccount(Operator.GREATER_THAN_OR_EQUAL, paymentAccount);
    }

    public PaymentTransactionRequest<T> withPaymentAccountLessThan(String paymentAccount){
       return withPaymentAccount(Operator.LESS_THAN, paymentAccount);
    }

    public PaymentTransactionRequest<T> withPaymentAccountLessThanOrEqualTo(String paymentAccount){
       return withPaymentAccount(Operator.LESS_THAN_OR_EQUAL, paymentAccount);
    }

    public PaymentTransactionRequest<T> withPaymentAccountBetween(String startOfPaymentAccount, String endOfPaymentAccount){
       return withPaymentAccount(Operator.BETWEEN, startOfPaymentAccount, endOfPaymentAccount);
    }
    public PaymentTransactionRequest<T> withPaymentAccountStartingWith(String paymentAccount){
       return withPaymentAccount(Operator.BEGIN_WITH, paymentAccount);
    }
    public PaymentTransactionRequest<T> withPaymentAccountContaining(String paymentAccount){
       return withPaymentAccount(Operator.CONTAIN, paymentAccount);
    }

    public PaymentTransactionRequest<T> withPaymentAccountEndingWith(String paymentAccount){
       return withPaymentAccount(Operator.END_WITH, paymentAccount);
    }

    public PaymentTransactionRequest<T> withPaymentAccountIs(String paymentAccount){
       return withPaymentAccount(Operator.EQUAL, paymentAccount);
    }

    public PaymentTransactionRequest<T> withPaymentAccountSoundingLike(String paymentAccount){
       return withPaymentAccount(Operator.SOUNDS_LIKE, paymentAccount);
    }



    public PaymentTransactionRequest<T> filterByCurrencyCode(String... currencyCode){
      if (currencyCode == null || currencyCode.length == 0) {
        throw new IllegalArgumentException("filterByCurrencyCode parameter currencyCode cannot be empty");
      }
      return appendSearchCriteria(createCurrencyCodeCriteria(Operator.EQUAL, (Object[])currencyCode));
    }

    public PaymentTransactionRequest<T> withCurrencyCode(Operator operator, Object... values){
       return appendSearchCriteria(createCurrencyCodeCriteria(operator, values));
    }

    public PaymentTransactionRequest<T> withCurrencyCodeIsUnknown(){
       return withCurrencyCode(Operator.IS_NULL);
    }

    public PaymentTransactionRequest<T> withCurrencyCodeIsKnown(){
       return withCurrencyCode(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createCurrencyCodeCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(PaymentTransaction.CURRENCY_CODE_PROPERTY, operator, values);
    }

    public PaymentTransactionRequest<T> withCurrencyCodeGreaterThan(String currencyCode){
       return withCurrencyCode(Operator.GREATER_THAN, currencyCode);
    }

    public PaymentTransactionRequest<T> withCurrencyCodeGreaterThanOrEqualTo(String currencyCode){
       return withCurrencyCode(Operator.GREATER_THAN_OR_EQUAL, currencyCode);
    }

    public PaymentTransactionRequest<T> withCurrencyCodeLessThan(String currencyCode){
       return withCurrencyCode(Operator.LESS_THAN, currencyCode);
    }

    public PaymentTransactionRequest<T> withCurrencyCodeLessThanOrEqualTo(String currencyCode){
       return withCurrencyCode(Operator.LESS_THAN_OR_EQUAL, currencyCode);
    }

    public PaymentTransactionRequest<T> withCurrencyCodeBetween(String startOfCurrencyCode, String endOfCurrencyCode){
       return withCurrencyCode(Operator.BETWEEN, startOfCurrencyCode, endOfCurrencyCode);
    }
    public PaymentTransactionRequest<T> withCurrencyCodeStartingWith(String currencyCode){
       return withCurrencyCode(Operator.BEGIN_WITH, currencyCode);
    }
    public PaymentTransactionRequest<T> withCurrencyCodeContaining(String currencyCode){
       return withCurrencyCode(Operator.CONTAIN, currencyCode);
    }

    public PaymentTransactionRequest<T> withCurrencyCodeEndingWith(String currencyCode){
       return withCurrencyCode(Operator.END_WITH, currencyCode);
    }

    public PaymentTransactionRequest<T> withCurrencyCodeIs(String currencyCode){
       return withCurrencyCode(Operator.EQUAL, currencyCode);
    }

    public PaymentTransactionRequest<T> withCurrencyCodeSoundingLike(String currencyCode){
       return withCurrencyCode(Operator.SOUNDS_LIKE, currencyCode);
    }



    public PaymentTransactionRequest<T> filterByPaymentMethod(String... paymentMethod){
      if (paymentMethod == null || paymentMethod.length == 0) {
        throw new IllegalArgumentException("filterByPaymentMethod parameter paymentMethod cannot be empty");
      }
      return appendSearchCriteria(createPaymentMethodCriteria(Operator.EQUAL, (Object[])paymentMethod));
    }

    public PaymentTransactionRequest<T> withPaymentMethod(Operator operator, Object... values){
       return appendSearchCriteria(createPaymentMethodCriteria(operator, values));
    }

    public PaymentTransactionRequest<T> withPaymentMethodIsUnknown(){
       return withPaymentMethod(Operator.IS_NULL);
    }

    public PaymentTransactionRequest<T> withPaymentMethodIsKnown(){
       return withPaymentMethod(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createPaymentMethodCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(PaymentTransaction.PAYMENT_METHOD_PROPERTY, operator, values);
    }

    public PaymentTransactionRequest<T> withPaymentMethodGreaterThan(String paymentMethod){
       return withPaymentMethod(Operator.GREATER_THAN, paymentMethod);
    }

    public PaymentTransactionRequest<T> withPaymentMethodGreaterThanOrEqualTo(String paymentMethod){
       return withPaymentMethod(Operator.GREATER_THAN_OR_EQUAL, paymentMethod);
    }

    public PaymentTransactionRequest<T> withPaymentMethodLessThan(String paymentMethod){
       return withPaymentMethod(Operator.LESS_THAN, paymentMethod);
    }

    public PaymentTransactionRequest<T> withPaymentMethodLessThanOrEqualTo(String paymentMethod){
       return withPaymentMethod(Operator.LESS_THAN_OR_EQUAL, paymentMethod);
    }

    public PaymentTransactionRequest<T> withPaymentMethodBetween(String startOfPaymentMethod, String endOfPaymentMethod){
       return withPaymentMethod(Operator.BETWEEN, startOfPaymentMethod, endOfPaymentMethod);
    }
    public PaymentTransactionRequest<T> withPaymentMethodStartingWith(String paymentMethod){
       return withPaymentMethod(Operator.BEGIN_WITH, paymentMethod);
    }
    public PaymentTransactionRequest<T> withPaymentMethodContaining(String paymentMethod){
       return withPaymentMethod(Operator.CONTAIN, paymentMethod);
    }

    public PaymentTransactionRequest<T> withPaymentMethodEndingWith(String paymentMethod){
       return withPaymentMethod(Operator.END_WITH, paymentMethod);
    }

    public PaymentTransactionRequest<T> withPaymentMethodIs(String paymentMethod){
       return withPaymentMethod(Operator.EQUAL, paymentMethod);
    }

    public PaymentTransactionRequest<T> withPaymentMethodSoundingLike(String paymentMethod){
       return withPaymentMethod(Operator.SOUNDS_LIKE, paymentMethod);
    }



    public PaymentTransactionRequest<T> filterByTransactionAmount(BigDecimal... transactionAmount){
      if (transactionAmount == null || transactionAmount.length == 0) {
        throw new IllegalArgumentException("filterByTransactionAmount parameter transactionAmount cannot be empty");
      }
      return appendSearchCriteria(createTransactionAmountCriteria(Operator.EQUAL, (Object[])transactionAmount));
    }

    public PaymentTransactionRequest<T> withTransactionAmount(Operator operator, Object... values){
       return appendSearchCriteria(createTransactionAmountCriteria(operator, values));
    }

    public PaymentTransactionRequest<T> withTransactionAmountIsUnknown(){
       return withTransactionAmount(Operator.IS_NULL);
    }

    public PaymentTransactionRequest<T> withTransactionAmountIsKnown(){
       return withTransactionAmount(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createTransactionAmountCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(PaymentTransaction.TRANSACTION_AMOUNT_PROPERTY, operator, values);
    }

    public PaymentTransactionRequest<T> withTransactionAmountGreaterThan(BigDecimal transactionAmount){
       return withTransactionAmount(Operator.GREATER_THAN, transactionAmount);
    }

    public PaymentTransactionRequest<T> withTransactionAmountGreaterThanOrEqualTo(BigDecimal transactionAmount){
       return withTransactionAmount(Operator.GREATER_THAN_OR_EQUAL, transactionAmount);
    }

    public PaymentTransactionRequest<T> withTransactionAmountLessThan(BigDecimal transactionAmount){
       return withTransactionAmount(Operator.LESS_THAN, transactionAmount);
    }

    public PaymentTransactionRequest<T> withTransactionAmountLessThanOrEqualTo(BigDecimal transactionAmount){
       return withTransactionAmount(Operator.LESS_THAN_OR_EQUAL, transactionAmount);
    }

    public PaymentTransactionRequest<T> withTransactionAmountBetween(BigDecimal startOfTransactionAmount, BigDecimal endOfTransactionAmount){
       return withTransactionAmount(Operator.BETWEEN, startOfTransactionAmount, endOfTransactionAmount);
    }



    public PaymentTransactionRequest<T> filterByCreateTime(LocalDateTime... createTime){
      if (createTime == null || createTime.length == 0) {
        throw new IllegalArgumentException("filterByCreateTime parameter createTime cannot be empty");
      }
      return appendSearchCriteria(createCreateTimeCriteria(Operator.EQUAL, (Object[])createTime));
    }

    public PaymentTransactionRequest<T> withCreateTime(Operator operator, Object... values){
       return appendSearchCriteria(createCreateTimeCriteria(operator, values));
    }

    public PaymentTransactionRequest<T> withCreateTimeIsUnknown(){
       return withCreateTime(Operator.IS_NULL);
    }

    public PaymentTransactionRequest<T> withCreateTimeIsKnown(){
       return withCreateTime(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createCreateTimeCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(PaymentTransaction.CREATE_TIME_PROPERTY, operator, values);
    }

    public PaymentTransactionRequest<T> withCreateTimeGreaterThan(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public PaymentTransactionRequest<T> withCreateTimeGreaterThanOrEqualTo(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN_OR_EQUAL, createTime);
    }

    public PaymentTransactionRequest<T> withCreateTimeLessThan(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public PaymentTransactionRequest<T> withCreateTimeLessThanOrEqualTo(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN_OR_EQUAL, createTime);
    }

    public PaymentTransactionRequest<T> withCreateTimeBetween(LocalDateTime startOfCreateTime, LocalDateTime endOfCreateTime){
       return withCreateTime(Operator.BETWEEN, startOfCreateTime, endOfCreateTime);
    }
    public PaymentTransactionRequest<T> withCreateTimeBefore(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public PaymentTransactionRequest<T> withCreateTimeBefore(Date createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public PaymentTransactionRequest<T> withCreateTimeAfter(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public PaymentTransactionRequest<T> withCreateTimeAfter(Date createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public PaymentTransactionRequest<T> withCreateTimeBetween(Date startOfCreateTime, Date endOfCreateTime){
       return withCreateTime(Operator.BETWEEN, startOfCreateTime, endOfCreateTime);
    }




    public PaymentTransactionRequest<T> filterByUpdateTime(LocalDateTime... updateTime){
      if (updateTime == null || updateTime.length == 0) {
        throw new IllegalArgumentException("filterByUpdateTime parameter updateTime cannot be empty");
      }
      return appendSearchCriteria(createUpdateTimeCriteria(Operator.EQUAL, (Object[])updateTime));
    }

    public PaymentTransactionRequest<T> withUpdateTime(Operator operator, Object... values){
       return appendSearchCriteria(createUpdateTimeCriteria(operator, values));
    }

    public PaymentTransactionRequest<T> withUpdateTimeIsUnknown(){
       return withUpdateTime(Operator.IS_NULL);
    }

    public PaymentTransactionRequest<T> withUpdateTimeIsKnown(){
       return withUpdateTime(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createUpdateTimeCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(PaymentTransaction.UPDATE_TIME_PROPERTY, operator, values);
    }

    public PaymentTransactionRequest<T> withUpdateTimeGreaterThan(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public PaymentTransactionRequest<T> withUpdateTimeGreaterThanOrEqualTo(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN_OR_EQUAL, updateTime);
    }

    public PaymentTransactionRequest<T> withUpdateTimeLessThan(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public PaymentTransactionRequest<T> withUpdateTimeLessThanOrEqualTo(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN_OR_EQUAL, updateTime);
    }

    public PaymentTransactionRequest<T> withUpdateTimeBetween(LocalDateTime startOfUpdateTime, LocalDateTime endOfUpdateTime){
       return withUpdateTime(Operator.BETWEEN, startOfUpdateTime, endOfUpdateTime);
    }
    public PaymentTransactionRequest<T> withUpdateTimeBefore(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public PaymentTransactionRequest<T> withUpdateTimeBefore(Date updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public PaymentTransactionRequest<T> withUpdateTimeAfter(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public PaymentTransactionRequest<T> withUpdateTimeAfter(Date updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public PaymentTransactionRequest<T> withUpdateTimeBetween(Date startOfUpdateTime, Date endOfUpdateTime){
       return withUpdateTime(Operator.BETWEEN, startOfUpdateTime, endOfUpdateTime);
    }




    public PaymentTransactionRequest<T> filterByVersion(Long... version){
      if (version == null || version.length == 0) {
        throw new IllegalArgumentException("filterByVersion parameter version cannot be empty");
      }
      return appendSearchCriteria(createVersionCriteria(Operator.EQUAL, (Object[])version));
    }

    public PaymentTransactionRequest<T> withVersion(Operator operator, Object... values){
       return appendSearchCriteria(createVersionCriteria(operator, values));
    }

    public PaymentTransactionRequest<T> withVersionIsUnknown(){
       return withVersion(Operator.IS_NULL);
    }

    public PaymentTransactionRequest<T> withVersionIsKnown(){
       return withVersion(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createVersionCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(PaymentTransaction.VERSION_PROPERTY, operator, values);
    }

    public PaymentTransactionRequest<T> withVersionGreaterThan(Long version){
       return withVersion(Operator.GREATER_THAN, version);
    }

    public PaymentTransactionRequest<T> withVersionGreaterThanOrEqualTo(Long version){
       return withVersion(Operator.GREATER_THAN_OR_EQUAL, version);
    }

    public PaymentTransactionRequest<T> withVersionLessThan(Long version){
       return withVersion(Operator.LESS_THAN, version);
    }

    public PaymentTransactionRequest<T> withVersionLessThanOrEqualTo(Long version){
       return withVersion(Operator.LESS_THAN_OR_EQUAL, version);
    }

    public PaymentTransactionRequest<T> withVersionBetween(Long startOfVersion, Long endOfVersion){
       return withVersion(Operator.BETWEEN, startOfVersion, endOfVersion);
    }


    public PaymentTransactionRequest<T> count(){
        super.count();
        return this;
    }
    public PaymentTransactionRequest<T> countAs(String retName){
        super.count(retName);
        return this;
    }
    public PaymentTransactionRequest minTransactionAmount(){
        return minTransactionAmountAs(prefix("minOf",PaymentTransaction.TRANSACTION_AMOUNT_PROPERTY));
    }

    public PaymentTransactionRequest minTransactionAmountAs(String retName){
        super.min(retName, PaymentTransaction.TRANSACTION_AMOUNT_PROPERTY);
        return this;
    }
    public PaymentTransactionRequest maxTransactionAmount(){
        return maxTransactionAmountAs(prefix("maxOf",PaymentTransaction.TRANSACTION_AMOUNT_PROPERTY));
    }

    public PaymentTransactionRequest maxTransactionAmountAs(String retName){
        super.max(retName, PaymentTransaction.TRANSACTION_AMOUNT_PROPERTY);
        return this;
    }
    public PaymentTransactionRequest sumTransactionAmount(){
        return sumTransactionAmountAs(prefix("sumOf",PaymentTransaction.TRANSACTION_AMOUNT_PROPERTY));
    }

    public PaymentTransactionRequest sumTransactionAmountAs(String retName){
        super.sum(retName, PaymentTransaction.TRANSACTION_AMOUNT_PROPERTY);
        return this;
    }
    public PaymentTransactionRequest avgTransactionAmount(){
        return avgTransactionAmountAs(prefix("avgOf",PaymentTransaction.TRANSACTION_AMOUNT_PROPERTY));
    }

    public PaymentTransactionRequest avgTransactionAmountAs(String retName){
        super.avg(retName, PaymentTransaction.TRANSACTION_AMOUNT_PROPERTY);
        return this;
    }
    public PaymentTransactionRequest standardDeviationTransactionAmount(){
        return standardDeviationTransactionAmountAs(prefix("standardDeviationOf",PaymentTransaction.TRANSACTION_AMOUNT_PROPERTY));
    }

    public PaymentTransactionRequest standardDeviationTransactionAmountAs(String retName){
        super.standardDeviation(retName, PaymentTransaction.TRANSACTION_AMOUNT_PROPERTY);
        return this;
    }
    public PaymentTransactionRequest squareRootOfPopulationStandardDeviationTransactionAmount(){
        return squareRootOfPopulationStandardDeviationTransactionAmountAs(prefix("squareRootOfPopulationStandardDeviationOf",PaymentTransaction.TRANSACTION_AMOUNT_PROPERTY));
    }

    public PaymentTransactionRequest squareRootOfPopulationStandardDeviationTransactionAmountAs(String retName){
        super.squareRootOfPopulationStandardDeviation(retName, PaymentTransaction.TRANSACTION_AMOUNT_PROPERTY);
        return this;
    }
    public PaymentTransactionRequest sampleVarianceTransactionAmount(){
        return sampleVarianceTransactionAmountAs(prefix("sampleVarianceOf",PaymentTransaction.TRANSACTION_AMOUNT_PROPERTY));
    }

    public PaymentTransactionRequest sampleVarianceTransactionAmountAs(String retName){
        super.sampleVariance(retName, PaymentTransaction.TRANSACTION_AMOUNT_PROPERTY);
        return this;
    }
    public PaymentTransactionRequest samplePopulationVarianceTransactionAmount(){
        return samplePopulationVarianceTransactionAmountAs(prefix("samplePopulationVarianceOf",PaymentTransaction.TRANSACTION_AMOUNT_PROPERTY));
    }

    public PaymentTransactionRequest samplePopulationVarianceTransactionAmountAs(String retName){
        super.samplePopulationVariance(retName, PaymentTransaction.TRANSACTION_AMOUNT_PROPERTY);
        return this;
    }

    public PaymentTransactionRequest<T> groupById(){
       groupBy(PaymentTransaction.ID_PROPERTY);
       return this;
    }

    public PaymentTransactionRequest<T> groupByIdAs(String retName){
       groupBy(retName, PaymentTransaction.ID_PROPERTY);
       return this;
    }

    public PaymentTransactionRequest<T> groupByIdWithFunction(String retName, AggrFunction function){
       groupBy(retName, PaymentTransaction.ID_PROPERTY, function);
       return this;
    }

    public PaymentTransactionRequest<T> groupByPaymentAccount(){
       groupBy(PaymentTransaction.PAYMENT_ACCOUNT_PROPERTY);
       return this;
    }

    public PaymentTransactionRequest<T> groupByPaymentAccountAs(String retName){
       groupBy(retName, PaymentTransaction.PAYMENT_ACCOUNT_PROPERTY);
       return this;
    }

    public PaymentTransactionRequest<T> groupByPaymentAccountWithFunction(String retName, AggrFunction function){
       groupBy(retName, PaymentTransaction.PAYMENT_ACCOUNT_PROPERTY, function);
       return this;
    }

    public PaymentTransactionRequest<T> groupByCurrencyCode(){
       groupBy(PaymentTransaction.CURRENCY_CODE_PROPERTY);
       return this;
    }

    public PaymentTransactionRequest<T> groupByCurrencyCodeAs(String retName){
       groupBy(retName, PaymentTransaction.CURRENCY_CODE_PROPERTY);
       return this;
    }

    public PaymentTransactionRequest<T> groupByCurrencyCodeWithFunction(String retName, AggrFunction function){
       groupBy(retName, PaymentTransaction.CURRENCY_CODE_PROPERTY, function);
       return this;
    }

    public PaymentTransactionRequest<T> groupByPaymentMethod(){
       groupBy(PaymentTransaction.PAYMENT_METHOD_PROPERTY);
       return this;
    }

    public PaymentTransactionRequest<T> groupByPaymentMethodAs(String retName){
       groupBy(retName, PaymentTransaction.PAYMENT_METHOD_PROPERTY);
       return this;
    }

    public PaymentTransactionRequest<T> groupByPaymentMethodWithFunction(String retName, AggrFunction function){
       groupBy(retName, PaymentTransaction.PAYMENT_METHOD_PROPERTY, function);
       return this;
    }

    public PaymentTransactionRequest<T> groupByTransactionAmount(){
       groupBy(PaymentTransaction.TRANSACTION_AMOUNT_PROPERTY);
       return this;
    }

    public PaymentTransactionRequest<T> groupByTransactionAmountAs(String retName){
       groupBy(retName, PaymentTransaction.TRANSACTION_AMOUNT_PROPERTY);
       return this;
    }

    public PaymentTransactionRequest<T> groupByTransactionAmountWithFunction(String retName, AggrFunction function){
       groupBy(retName, PaymentTransaction.TRANSACTION_AMOUNT_PROPERTY, function);
       return this;
    }

    public PaymentTransactionRequest<T> groupByCreateTime(){
       groupBy(PaymentTransaction.CREATE_TIME_PROPERTY);
       return this;
    }

    public PaymentTransactionRequest<T> groupByCreateTimeAs(String retName){
       groupBy(retName, PaymentTransaction.CREATE_TIME_PROPERTY);
       return this;
    }

    public PaymentTransactionRequest<T> groupByCreateTimeWithFunction(String retName, AggrFunction function){
       groupBy(retName, PaymentTransaction.CREATE_TIME_PROPERTY, function);
       return this;
    }

    public PaymentTransactionRequest<T> groupByUpdateTime(){
       groupBy(PaymentTransaction.UPDATE_TIME_PROPERTY);
       return this;
    }

    public PaymentTransactionRequest<T> groupByUpdateTimeAs(String retName){
       groupBy(retName, PaymentTransaction.UPDATE_TIME_PROPERTY);
       return this;
    }

    public PaymentTransactionRequest<T> groupByUpdateTimeWithFunction(String retName, AggrFunction function){
       groupBy(retName, PaymentTransaction.UPDATE_TIME_PROPERTY, function);
       return this;
    }

    public PaymentTransactionRequest<T> groupByVersion(){
       groupBy(PaymentTransaction.VERSION_PROPERTY);
       return this;
    }

    public PaymentTransactionRequest<T> groupByVersionAs(String retName){
       groupBy(retName, PaymentTransaction.VERSION_PROPERTY);
       return this;
    }

    public PaymentTransactionRequest<T> groupByVersionWithFunction(String retName, AggrFunction function){
       groupBy(retName, PaymentTransaction.VERSION_PROPERTY, function);
       return this;
    }



    public PaymentTransactionRequest<T> orderByIdAscending(){
       addOrderByAscending(PaymentTransaction.ID_PROPERTY);
       return this;
    }

    public PaymentTransactionRequest<T> orderByIdDescending(){
       addOrderByDescending(PaymentTransaction.ID_PROPERTY);
       return this;
    }

    public PaymentTransactionRequest<T> orderByPaymentAccountAscending(){
       addOrderByAscending(PaymentTransaction.PAYMENT_ACCOUNT_PROPERTY);
       return this;
    }

    public PaymentTransactionRequest<T> orderByPaymentAccountDescending(){
       addOrderByDescending(PaymentTransaction.PAYMENT_ACCOUNT_PROPERTY);
       return this;
    }
    public PaymentTransactionRequest<T> orderByPaymentAccountAscendingUsingGBK(){
       addOrderByAscendingUsingGBK(PaymentTransaction.PAYMENT_ACCOUNT_PROPERTY);
       return this;
    }

    public PaymentTransactionRequest<T> orderByPaymentAccountDescendingUsingGBK(){
       addOrderByDescendingUsingGBK(PaymentTransaction.PAYMENT_ACCOUNT_PROPERTY);
       return this;
    }
    public PaymentTransactionRequest<T> orderByCurrencyCodeAscending(){
       addOrderByAscending(PaymentTransaction.CURRENCY_CODE_PROPERTY);
       return this;
    }

    public PaymentTransactionRequest<T> orderByCurrencyCodeDescending(){
       addOrderByDescending(PaymentTransaction.CURRENCY_CODE_PROPERTY);
       return this;
    }
    public PaymentTransactionRequest<T> orderByCurrencyCodeAscendingUsingGBK(){
       addOrderByAscendingUsingGBK(PaymentTransaction.CURRENCY_CODE_PROPERTY);
       return this;
    }

    public PaymentTransactionRequest<T> orderByCurrencyCodeDescendingUsingGBK(){
       addOrderByDescendingUsingGBK(PaymentTransaction.CURRENCY_CODE_PROPERTY);
       return this;
    }
    public PaymentTransactionRequest<T> orderByPaymentMethodAscending(){
       addOrderByAscending(PaymentTransaction.PAYMENT_METHOD_PROPERTY);
       return this;
    }

    public PaymentTransactionRequest<T> orderByPaymentMethodDescending(){
       addOrderByDescending(PaymentTransaction.PAYMENT_METHOD_PROPERTY);
       return this;
    }
    public PaymentTransactionRequest<T> orderByPaymentMethodAscendingUsingGBK(){
       addOrderByAscendingUsingGBK(PaymentTransaction.PAYMENT_METHOD_PROPERTY);
       return this;
    }

    public PaymentTransactionRequest<T> orderByPaymentMethodDescendingUsingGBK(){
       addOrderByDescendingUsingGBK(PaymentTransaction.PAYMENT_METHOD_PROPERTY);
       return this;
    }
    public PaymentTransactionRequest<T> orderByTransactionAmountAscending(){
       addOrderByAscending(PaymentTransaction.TRANSACTION_AMOUNT_PROPERTY);
       return this;
    }

    public PaymentTransactionRequest<T> orderByTransactionAmountDescending(){
       addOrderByDescending(PaymentTransaction.TRANSACTION_AMOUNT_PROPERTY);
       return this;
    }

    public PaymentTransactionRequest<T> orderByCreateTimeAscending(){
       addOrderByAscending(PaymentTransaction.CREATE_TIME_PROPERTY);
       return this;
    }

    public PaymentTransactionRequest<T> orderByCreateTimeDescending(){
       addOrderByDescending(PaymentTransaction.CREATE_TIME_PROPERTY);
       return this;
    }

    public PaymentTransactionRequest<T> orderByUpdateTimeAscending(){
       addOrderByAscending(PaymentTransaction.UPDATE_TIME_PROPERTY);
       return this;
    }

    public PaymentTransactionRequest<T> orderByUpdateTimeDescending(){
       addOrderByDescending(PaymentTransaction.UPDATE_TIME_PROPERTY);
       return this;
    }

    public PaymentTransactionRequest<T> orderByVersionAscending(){
       addOrderByAscending(PaymentTransaction.VERSION_PROPERTY);
       return this;
    }

    public PaymentTransactionRequest<T> orderByVersionDescending(){
       addOrderByDescending(PaymentTransaction.VERSION_PROPERTY);
       return this;
    }





    /**
     * get topN records
     * @param topN  records number
     */
    public PaymentTransactionRequest<T> top(int topN) {
        super.top(topN);
        return this;
    }

    /**
     * get records from offset(inclusive) to offset+size(exclusive)
     * @param offset record offset
     * @param size records number
     */
    public PaymentTransactionRequest<T> offset(int offset, int size) {
        super.offset(offset, size);
        return this;
    }

    /**
     * retrieve all records
     */
    public PaymentTransactionRequest<T> unlimited() {
        super.unlimited();
        return this;
    }

    /**
     * get records of one page
     * @param pageNumber page number(1-based)
     * @param pageSize page size
     */
    public PaymentTransactionRequest<T> page(int pageNumber, int pageSize) {
        int offset = (pageNumber - 1) * pageSize;
        return offset(offset, pageSize);
   }

    /**
     * get records of one page, default page size is 10
     * @param pageNumber page number(1-based)
     */
    public PaymentTransactionRequest<T> page(int pageNumber) {
        return page(pageNumber, 10);
   }
}