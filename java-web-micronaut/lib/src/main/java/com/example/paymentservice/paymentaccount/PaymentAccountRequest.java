
package com.example.paymentservice.paymentaccount;

import com.example.paymentservice.Q;
import com.example.paymentservice.paymentmethod.PaymentMethod;
import com.example.paymentservice.paymentmethod.PaymentMethodRequest;
import com.example.paymentservice.paymenttransaction.PaymentTransaction;
import com.example.paymentservice.paymenttransaction.PaymentTransactionRequest;
import com.example.paymentservice.useraccount.UserAccount;
import com.example.paymentservice.useraccount.UserAccountRequest;
import io.teaql.core.AggrFunction;
import io.teaql.core.BaseRequest;
import io.teaql.core.PropertyReference;
import io.teaql.core.SearchCriteria;
import io.teaql.core.SubQuerySearchCriteria;
import io.teaql.core.criteria.Operator;
import io.teaql.core.criteria.TwoOperatorCriteria;
import java.time.LocalDateTime;
import java.util.Date;

public class PaymentAccountRequest<T extends PaymentAccount> extends BaseRequest<T> {

    /**
     * @deprecated AI agents and business code must use the generated Q facade
     *             instead of constructing request builders directly.
     */
    @Deprecated
    public PaymentAccountRequest(Class<T> returnType){
        super(returnType);
        selectId();
        selectVersion();
    }

    public PaymentAccountRequest<T> comment(String comment){
         super.internalComment(comment);
         return this;
    }

    // purpose() 继承自 BaseRequest，返回 ExecutableRequest（终结方法）

    public PaymentAccountRequest<T> returnType(Class<? extends T> returnType){
        super.setReturnType(returnType);
        return this;
    }

    public PaymentAccountRequest<T> enableAggregationCache(long cacheExpiredMillis){
        super.enableAggregationCache();
        super.aggregateCacheTime(cacheExpiredMillis);
        return this;
    }

    public PaymentAccountRequest<T> enableAggregationCache(){
        return enableAggregationCache(0l);
    }


    public PaymentAccountRequest<T> propagateAggregationCache(long cacheExpiredMillis){
        super.propagateAggregationCache(cacheExpiredMillis);
        return this;
    }

    public PaymentAccountRequest<T> appendSearchCriteria(SearchCriteria searchCriteria){
        return (PaymentAccountRequest<T>)super.appendSearchCriteria(searchCriteria);
    }

    public PaymentAccountRequest<T> filter(String property1, Operator operator, String property2){
        return appendSearchCriteria(new TwoOperatorCriteria(operator, new PropertyReference(property1), new PropertyReference(property2)));
    }


    public PaymentAccountRequest<T> matchingAnyOf(PaymentAccountRequest paymentAccount){
        super.internalMatchAny(paymentAccount);
        return this;
    }

    public PaymentAccountRequest<T> enhanceChildrenIfNeeded(){
        return this;
    }

    public PaymentAccountRequest<T> withDeletedRows(){
        super.withDeletedRows();
        return this;
    }

    public PaymentAccountRequest<T> deletedRowsOnly(){
        super.deletedRowsOnly();
        return this;
    }

    public PaymentAccountRequest<T> selectSelf(){
        super.selectSelf();
        return selectId().selectUserAccountIdOnly().selectAccountName().selectAccountNumber().selectCurrencyCode().selectCreateTime().selectUpdateTime().selectVersion();
    }

    public PaymentAccountRequest<T> selectSelfFields(){
        return selectSelf();
    }

    public PaymentAccountRequest<T> selectAll(){
        super.selectAll();
        return selectId().selectUserAccount().selectAccountName().selectAccountNumber().selectCurrencyCode().selectCreateTime().selectUpdateTime().selectVersion();
    }

    public PaymentAccountRequest<T> selectChildren(){
        super.selectAny();
        selectPaymentMethodList().selectPaymentTransactionList();
        return selectId().selectUserAccount().selectAccountName().selectAccountNumber().selectCurrencyCode().selectCreateTime().selectUpdateTime().selectVersion();
    }


    public PaymentAccountRequest<T> selectId(){
       selectProperty(PaymentAccount.ID_PROPERTY);
       return this;
    }

    /**
     * fill the id with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  id) to fetch id property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public PaymentAccountRequest<T> unselectId(){
       unselectProperty(PaymentAccount.ID_PROPERTY);
       return this;
    }
    public PaymentAccountRequest<T> selectUserAccountIdOnly(){
       selectProperty(PaymentAccount.USER_ACCOUNT_PROPERTY);
       return this;
    }

    public PaymentAccountRequest<T> selectUserAccount(){
        return selectUserAccountWith(Q.userAccounts().unlimited().selectSelf());
    }

    public PaymentAccountRequest<T> selectUserAccountWith(UserAccountRequest userAccount){
       selectProperty(PaymentAccount.USER_ACCOUNT_PROPERTY);
       enhanceRelation(PaymentAccount.USER_ACCOUNT_PROPERTY, userAccount);
       return this;
    }

    public PaymentAccountRequest<T> unselectUserAccount(){
       unselectProperty(PaymentAccount.USER_ACCOUNT_PROPERTY);
       return this;
    }
    public PaymentAccountRequest<T> selectAccountName(){
       selectProperty(PaymentAccount.ACCOUNT_NAME_PROPERTY);
       return this;
    }

    /**
     * fill the accountName with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  accountName) to fetch accountName property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public PaymentAccountRequest<T> unselectAccountName(){
       unselectProperty(PaymentAccount.ACCOUNT_NAME_PROPERTY);
       return this;
    }
    public PaymentAccountRequest<T> selectAccountNumber(){
       selectProperty(PaymentAccount.ACCOUNT_NUMBER_PROPERTY);
       return this;
    }

    /**
     * fill the accountNumber with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  accountNumber) to fetch accountNumber property.
     * @param rawSqlSegment  customized rawSqlSegment
     */


    /**
     * fill the accountNumber with customized aggrFunction, TEAQL uses ({aggrFunction}(accountNumber) AS accountNumber to fetch accountNumber property.
     * @param aggrFunction  aggrFunction
     */
    public PaymentAccountRequest<T> selectAccountNumber(AggrFunction aggrFunction){
       selectProperty(PaymentAccount.ACCOUNT_NUMBER_PROPERTY, aggrFunction);
       return this;
    }


    public PaymentAccountRequest<T> unselectAccountNumber(){
       unselectProperty(PaymentAccount.ACCOUNT_NUMBER_PROPERTY);
       return this;
    }
    public PaymentAccountRequest<T> selectCurrencyCode(){
       selectProperty(PaymentAccount.CURRENCY_CODE_PROPERTY);
       return this;
    }

    /**
     * fill the currencyCode with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  currencyCode) to fetch currencyCode property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public PaymentAccountRequest<T> unselectCurrencyCode(){
       unselectProperty(PaymentAccount.CURRENCY_CODE_PROPERTY);
       return this;
    }
    public PaymentAccountRequest<T> selectCreateTime(){
       selectProperty(PaymentAccount.CREATE_TIME_PROPERTY);
       return this;
    }

    /**
     * fill the createTime with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  createTime) to fetch createTime property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public PaymentAccountRequest<T> unselectCreateTime(){
       unselectProperty(PaymentAccount.CREATE_TIME_PROPERTY);
       return this;
    }
    public PaymentAccountRequest<T> selectUpdateTime(){
       selectProperty(PaymentAccount.UPDATE_TIME_PROPERTY);
       return this;
    }

    /**
     * fill the updateTime with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  updateTime) to fetch updateTime property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public PaymentAccountRequest<T> unselectUpdateTime(){
       unselectProperty(PaymentAccount.UPDATE_TIME_PROPERTY);
       return this;
    }
    public PaymentAccountRequest<T> selectVersion(){
       selectProperty(PaymentAccount.VERSION_PROPERTY);
       return this;
    }

    /**
     * fill the version with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  version) to fetch version property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public PaymentAccountRequest<T> unselectVersion(){
       unselectProperty(PaymentAccount.VERSION_PROPERTY);
       return this;
    }
    public PaymentAccountRequest<T> selectPaymentMethodList(){
       return selectPaymentMethodListWith(Q.paymentMethods().selectSelf());
    }

    public PaymentAccountRequest<T> selectPaymentMethodListWith(PaymentMethodRequest paymentMethodList){
       enhanceRelation(PaymentAccount.PAYMENT_METHOD_LIST_PROPERTY, paymentMethodList);
       return this;
    }
    public PaymentAccountRequest<T> selectPaymentTransactionList(){
       return selectPaymentTransactionListWith(Q.paymentTransactions().selectSelf());
    }

    public PaymentAccountRequest<T> selectPaymentTransactionListWith(PaymentTransactionRequest paymentTransactionList){
       enhanceRelation(PaymentAccount.PAYMENT_TRANSACTION_LIST_PROPERTY, paymentTransactionList);
       return this;
    }

    public PaymentAccountRequest<T> withId(Operator operator, Object... values){
       return appendSearchCriteria(createIdCriteria(operator, values));
    }

    public SearchCriteria createIdCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(PaymentAccount.ID_PROPERTY, operator, values);
    }

    public PaymentAccountRequest<T> withIdIs(Long id){
       return withId(Operator.EQUAL, id);
    }
    public PaymentAccountRequest<T> withIdIn(Long... id){
       return withId(Operator.EQUAL, (Object[])id);
    }



    public PaymentAccountRequest<T> filterByUserAccount(UserAccount... userAccount){
      if (userAccount == null || userAccount.length == 0) {
        throw new IllegalArgumentException("filterByUserAccount parameter userAccount cannot be empty");
      }
      return appendSearchCriteria(createUserAccountCriteria(Operator.EQUAL, (Object[])userAccount));
    }

    public PaymentAccountRequest<T> withUserAccount(Operator operator, Object... values){
       return appendSearchCriteria(createUserAccountCriteria(operator, values));
    }

    public PaymentAccountRequest<T> withUserAccountIsUnknown(){
       return withUserAccount(Operator.IS_NULL);
    }

    public PaymentAccountRequest<T> withUserAccountIsKnown(){
       return withUserAccount(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createUserAccountCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(PaymentAccount.USER_ACCOUNT_PROPERTY, operator, values);
    }

    public PaymentAccountRequest<T> filterByUserAccount(Long userAccount){
      if(userAccount == null){
         return this;
      }
      return withUserAccount(Operator.EQUAL, userAccount);
    }
    public PaymentAccountRequest<T> withUserAccountMatching(UserAccountRequest userAccount){
       return appendSearchCriteria(new SubQuerySearchCriteria(PaymentAccount.USER_ACCOUNT_PROPERTY, userAccount, UserAccount.ID_PROPERTY));
    }

    public PaymentAccountRequest<T> filterByAccountName(String... accountName){
      if (accountName == null || accountName.length == 0) {
        throw new IllegalArgumentException("filterByAccountName parameter accountName cannot be empty");
      }
      return appendSearchCriteria(createAccountNameCriteria(Operator.EQUAL, (Object[])accountName));
    }

    public PaymentAccountRequest<T> withAccountName(Operator operator, Object... values){
       return appendSearchCriteria(createAccountNameCriteria(operator, values));
    }

    public PaymentAccountRequest<T> withAccountNameIsUnknown(){
       return withAccountName(Operator.IS_NULL);
    }

    public PaymentAccountRequest<T> withAccountNameIsKnown(){
       return withAccountName(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createAccountNameCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(PaymentAccount.ACCOUNT_NAME_PROPERTY, operator, values);
    }

    public PaymentAccountRequest<T> withAccountNameGreaterThan(String accountName){
       return withAccountName(Operator.GREATER_THAN, accountName);
    }

    public PaymentAccountRequest<T> withAccountNameGreaterThanOrEqualTo(String accountName){
       return withAccountName(Operator.GREATER_THAN_OR_EQUAL, accountName);
    }

    public PaymentAccountRequest<T> withAccountNameLessThan(String accountName){
       return withAccountName(Operator.LESS_THAN, accountName);
    }

    public PaymentAccountRequest<T> withAccountNameLessThanOrEqualTo(String accountName){
       return withAccountName(Operator.LESS_THAN_OR_EQUAL, accountName);
    }

    public PaymentAccountRequest<T> withAccountNameBetween(String startOfAccountName, String endOfAccountName){
       return withAccountName(Operator.BETWEEN, startOfAccountName, endOfAccountName);
    }
    public PaymentAccountRequest<T> withAccountNameStartingWith(String accountName){
       return withAccountName(Operator.BEGIN_WITH, accountName);
    }
    public PaymentAccountRequest<T> withAccountNameContaining(String accountName){
       return withAccountName(Operator.CONTAIN, accountName);
    }

    public PaymentAccountRequest<T> withAccountNameEndingWith(String accountName){
       return withAccountName(Operator.END_WITH, accountName);
    }

    public PaymentAccountRequest<T> withAccountNameIs(String accountName){
       return withAccountName(Operator.EQUAL, accountName);
    }

    public PaymentAccountRequest<T> withAccountNameSoundingLike(String accountName){
       return withAccountName(Operator.SOUNDS_LIKE, accountName);
    }



    public PaymentAccountRequest<T> filterByAccountNumber(Integer... accountNumber){
      if (accountNumber == null || accountNumber.length == 0) {
        throw new IllegalArgumentException("filterByAccountNumber parameter accountNumber cannot be empty");
      }
      return appendSearchCriteria(createAccountNumberCriteria(Operator.EQUAL, (Object[])accountNumber));
    }

    public PaymentAccountRequest<T> withAccountNumber(Operator operator, Object... values){
       return appendSearchCriteria(createAccountNumberCriteria(operator, values));
    }

    public PaymentAccountRequest<T> withAccountNumberIsUnknown(){
       return withAccountNumber(Operator.IS_NULL);
    }

    public PaymentAccountRequest<T> withAccountNumberIsKnown(){
       return withAccountNumber(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createAccountNumberCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(PaymentAccount.ACCOUNT_NUMBER_PROPERTY, operator, values);
    }

    public PaymentAccountRequest<T> withAccountNumberGreaterThan(Integer accountNumber){
       return withAccountNumber(Operator.GREATER_THAN, accountNumber);
    }

    public PaymentAccountRequest<T> withAccountNumberGreaterThanOrEqualTo(Integer accountNumber){
       return withAccountNumber(Operator.GREATER_THAN_OR_EQUAL, accountNumber);
    }

    public PaymentAccountRequest<T> withAccountNumberLessThan(Integer accountNumber){
       return withAccountNumber(Operator.LESS_THAN, accountNumber);
    }

    public PaymentAccountRequest<T> withAccountNumberLessThanOrEqualTo(Integer accountNumber){
       return withAccountNumber(Operator.LESS_THAN_OR_EQUAL, accountNumber);
    }

    public PaymentAccountRequest<T> withAccountNumberBetween(Integer startOfAccountNumber, Integer endOfAccountNumber){
       return withAccountNumber(Operator.BETWEEN, startOfAccountNumber, endOfAccountNumber);
    }



    public PaymentAccountRequest<T> filterByCurrencyCode(String... currencyCode){
      if (currencyCode == null || currencyCode.length == 0) {
        throw new IllegalArgumentException("filterByCurrencyCode parameter currencyCode cannot be empty");
      }
      return appendSearchCriteria(createCurrencyCodeCriteria(Operator.EQUAL, (Object[])currencyCode));
    }

    public PaymentAccountRequest<T> withCurrencyCode(Operator operator, Object... values){
       return appendSearchCriteria(createCurrencyCodeCriteria(operator, values));
    }

    public PaymentAccountRequest<T> withCurrencyCodeIsUnknown(){
       return withCurrencyCode(Operator.IS_NULL);
    }

    public PaymentAccountRequest<T> withCurrencyCodeIsKnown(){
       return withCurrencyCode(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createCurrencyCodeCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(PaymentAccount.CURRENCY_CODE_PROPERTY, operator, values);
    }

    public PaymentAccountRequest<T> withCurrencyCodeGreaterThan(String currencyCode){
       return withCurrencyCode(Operator.GREATER_THAN, currencyCode);
    }

    public PaymentAccountRequest<T> withCurrencyCodeGreaterThanOrEqualTo(String currencyCode){
       return withCurrencyCode(Operator.GREATER_THAN_OR_EQUAL, currencyCode);
    }

    public PaymentAccountRequest<T> withCurrencyCodeLessThan(String currencyCode){
       return withCurrencyCode(Operator.LESS_THAN, currencyCode);
    }

    public PaymentAccountRequest<T> withCurrencyCodeLessThanOrEqualTo(String currencyCode){
       return withCurrencyCode(Operator.LESS_THAN_OR_EQUAL, currencyCode);
    }

    public PaymentAccountRequest<T> withCurrencyCodeBetween(String startOfCurrencyCode, String endOfCurrencyCode){
       return withCurrencyCode(Operator.BETWEEN, startOfCurrencyCode, endOfCurrencyCode);
    }
    public PaymentAccountRequest<T> withCurrencyCodeStartingWith(String currencyCode){
       return withCurrencyCode(Operator.BEGIN_WITH, currencyCode);
    }
    public PaymentAccountRequest<T> withCurrencyCodeContaining(String currencyCode){
       return withCurrencyCode(Operator.CONTAIN, currencyCode);
    }

    public PaymentAccountRequest<T> withCurrencyCodeEndingWith(String currencyCode){
       return withCurrencyCode(Operator.END_WITH, currencyCode);
    }

    public PaymentAccountRequest<T> withCurrencyCodeIs(String currencyCode){
       return withCurrencyCode(Operator.EQUAL, currencyCode);
    }

    public PaymentAccountRequest<T> withCurrencyCodeSoundingLike(String currencyCode){
       return withCurrencyCode(Operator.SOUNDS_LIKE, currencyCode);
    }



    public PaymentAccountRequest<T> filterByCreateTime(LocalDateTime... createTime){
      if (createTime == null || createTime.length == 0) {
        throw new IllegalArgumentException("filterByCreateTime parameter createTime cannot be empty");
      }
      return appendSearchCriteria(createCreateTimeCriteria(Operator.EQUAL, (Object[])createTime));
    }

    public PaymentAccountRequest<T> withCreateTime(Operator operator, Object... values){
       return appendSearchCriteria(createCreateTimeCriteria(operator, values));
    }

    public PaymentAccountRequest<T> withCreateTimeIsUnknown(){
       return withCreateTime(Operator.IS_NULL);
    }

    public PaymentAccountRequest<T> withCreateTimeIsKnown(){
       return withCreateTime(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createCreateTimeCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(PaymentAccount.CREATE_TIME_PROPERTY, operator, values);
    }

    public PaymentAccountRequest<T> withCreateTimeGreaterThan(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public PaymentAccountRequest<T> withCreateTimeGreaterThanOrEqualTo(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN_OR_EQUAL, createTime);
    }

    public PaymentAccountRequest<T> withCreateTimeLessThan(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public PaymentAccountRequest<T> withCreateTimeLessThanOrEqualTo(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN_OR_EQUAL, createTime);
    }

    public PaymentAccountRequest<T> withCreateTimeBetween(LocalDateTime startOfCreateTime, LocalDateTime endOfCreateTime){
       return withCreateTime(Operator.BETWEEN, startOfCreateTime, endOfCreateTime);
    }
    public PaymentAccountRequest<T> withCreateTimeBefore(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public PaymentAccountRequest<T> withCreateTimeBefore(Date createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public PaymentAccountRequest<T> withCreateTimeAfter(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public PaymentAccountRequest<T> withCreateTimeAfter(Date createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public PaymentAccountRequest<T> withCreateTimeBetween(Date startOfCreateTime, Date endOfCreateTime){
       return withCreateTime(Operator.BETWEEN, startOfCreateTime, endOfCreateTime);
    }




    public PaymentAccountRequest<T> filterByUpdateTime(LocalDateTime... updateTime){
      if (updateTime == null || updateTime.length == 0) {
        throw new IllegalArgumentException("filterByUpdateTime parameter updateTime cannot be empty");
      }
      return appendSearchCriteria(createUpdateTimeCriteria(Operator.EQUAL, (Object[])updateTime));
    }

    public PaymentAccountRequest<T> withUpdateTime(Operator operator, Object... values){
       return appendSearchCriteria(createUpdateTimeCriteria(operator, values));
    }

    public PaymentAccountRequest<T> withUpdateTimeIsUnknown(){
       return withUpdateTime(Operator.IS_NULL);
    }

    public PaymentAccountRequest<T> withUpdateTimeIsKnown(){
       return withUpdateTime(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createUpdateTimeCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(PaymentAccount.UPDATE_TIME_PROPERTY, operator, values);
    }

    public PaymentAccountRequest<T> withUpdateTimeGreaterThan(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public PaymentAccountRequest<T> withUpdateTimeGreaterThanOrEqualTo(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN_OR_EQUAL, updateTime);
    }

    public PaymentAccountRequest<T> withUpdateTimeLessThan(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public PaymentAccountRequest<T> withUpdateTimeLessThanOrEqualTo(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN_OR_EQUAL, updateTime);
    }

    public PaymentAccountRequest<T> withUpdateTimeBetween(LocalDateTime startOfUpdateTime, LocalDateTime endOfUpdateTime){
       return withUpdateTime(Operator.BETWEEN, startOfUpdateTime, endOfUpdateTime);
    }
    public PaymentAccountRequest<T> withUpdateTimeBefore(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public PaymentAccountRequest<T> withUpdateTimeBefore(Date updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public PaymentAccountRequest<T> withUpdateTimeAfter(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public PaymentAccountRequest<T> withUpdateTimeAfter(Date updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public PaymentAccountRequest<T> withUpdateTimeBetween(Date startOfUpdateTime, Date endOfUpdateTime){
       return withUpdateTime(Operator.BETWEEN, startOfUpdateTime, endOfUpdateTime);
    }




    public PaymentAccountRequest<T> filterByVersion(Long... version){
      if (version == null || version.length == 0) {
        throw new IllegalArgumentException("filterByVersion parameter version cannot be empty");
      }
      return appendSearchCriteria(createVersionCriteria(Operator.EQUAL, (Object[])version));
    }

    public PaymentAccountRequest<T> withVersion(Operator operator, Object... values){
       return appendSearchCriteria(createVersionCriteria(operator, values));
    }

    public PaymentAccountRequest<T> withVersionIsUnknown(){
       return withVersion(Operator.IS_NULL);
    }

    public PaymentAccountRequest<T> withVersionIsKnown(){
       return withVersion(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createVersionCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(PaymentAccount.VERSION_PROPERTY, operator, values);
    }

    public PaymentAccountRequest<T> withVersionGreaterThan(Long version){
       return withVersion(Operator.GREATER_THAN, version);
    }

    public PaymentAccountRequest<T> withVersionGreaterThanOrEqualTo(Long version){
       return withVersion(Operator.GREATER_THAN_OR_EQUAL, version);
    }

    public PaymentAccountRequest<T> withVersionLessThan(Long version){
       return withVersion(Operator.LESS_THAN, version);
    }

    public PaymentAccountRequest<T> withVersionLessThanOrEqualTo(Long version){
       return withVersion(Operator.LESS_THAN_OR_EQUAL, version);
    }

    public PaymentAccountRequest<T> withVersionBetween(Long startOfVersion, Long endOfVersion){
       return withVersion(Operator.BETWEEN, startOfVersion, endOfVersion);
    }

    public PaymentAccountRequest<T> withPaymentMethodListMatching(PaymentMethodRequest paymentMethodRequest){
        return appendSearchCriteria(new SubQuerySearchCriteria(PaymentAccount.ID_PROPERTY, paymentMethodRequest, PaymentMethod.PAYMENT_ACCOUNT_PROPERTY));
    }

    public PaymentAccountRequest<T> withoutPaymentMethodListMatching(PaymentMethodRequest paymentMethodRequest){
        return appendSearchCriteria(SearchCriteria.not(new SubQuerySearchCriteria(PaymentAccount.ID_PROPERTY, paymentMethodRequest, PaymentMethod.PAYMENT_ACCOUNT_PROPERTY)));
    }

    public PaymentAccountRequest<T> havePaymentMethods(){
        return withPaymentMethodListMatching(Q.paymentMethods().unlimited());
    }

    public PaymentAccountRequest<T> haveNoPaymentMethods(){
        return withoutPaymentMethodListMatching(Q.paymentMethods().unlimited());
    }
    public PaymentAccountRequest<T> withPaymentTransactionListMatching(PaymentTransactionRequest paymentTransactionRequest){
        return appendSearchCriteria(new SubQuerySearchCriteria(PaymentAccount.ID_PROPERTY, paymentTransactionRequest, PaymentTransaction.PAYMENT_ACCOUNT_PROPERTY));
    }

    public PaymentAccountRequest<T> withoutPaymentTransactionListMatching(PaymentTransactionRequest paymentTransactionRequest){
        return appendSearchCriteria(SearchCriteria.not(new SubQuerySearchCriteria(PaymentAccount.ID_PROPERTY, paymentTransactionRequest, PaymentTransaction.PAYMENT_ACCOUNT_PROPERTY)));
    }

    public PaymentAccountRequest<T> havePaymentTransactions(){
        return withPaymentTransactionListMatching(Q.paymentTransactions().unlimited());
    }

    public PaymentAccountRequest<T> haveNoPaymentTransactions(){
        return withoutPaymentTransactionListMatching(Q.paymentTransactions().unlimited());
    }

    public PaymentAccountRequest<T> count(){
        super.count();
        return this;
    }
    public PaymentAccountRequest<T> countAs(String retName){
        super.count(retName);
        return this;
    }
    public PaymentAccountRequest minAccountNumber(){
        return minAccountNumberAs(prefix("minOf",PaymentAccount.ACCOUNT_NUMBER_PROPERTY));
    }

    public PaymentAccountRequest minAccountNumberAs(String retName){
        super.min(retName, PaymentAccount.ACCOUNT_NUMBER_PROPERTY);
        return this;
    }
    public PaymentAccountRequest maxAccountNumber(){
        return maxAccountNumberAs(prefix("maxOf",PaymentAccount.ACCOUNT_NUMBER_PROPERTY));
    }

    public PaymentAccountRequest maxAccountNumberAs(String retName){
        super.max(retName, PaymentAccount.ACCOUNT_NUMBER_PROPERTY);
        return this;
    }
    public PaymentAccountRequest sumAccountNumber(){
        return sumAccountNumberAs(prefix("sumOf",PaymentAccount.ACCOUNT_NUMBER_PROPERTY));
    }

    public PaymentAccountRequest sumAccountNumberAs(String retName){
        super.sum(retName, PaymentAccount.ACCOUNT_NUMBER_PROPERTY);
        return this;
    }
    public PaymentAccountRequest avgAccountNumber(){
        return avgAccountNumberAs(prefix("avgOf",PaymentAccount.ACCOUNT_NUMBER_PROPERTY));
    }

    public PaymentAccountRequest avgAccountNumberAs(String retName){
        super.avg(retName, PaymentAccount.ACCOUNT_NUMBER_PROPERTY);
        return this;
    }
    public PaymentAccountRequest standardDeviationAccountNumber(){
        return standardDeviationAccountNumberAs(prefix("standardDeviationOf",PaymentAccount.ACCOUNT_NUMBER_PROPERTY));
    }

    public PaymentAccountRequest standardDeviationAccountNumberAs(String retName){
        super.standardDeviation(retName, PaymentAccount.ACCOUNT_NUMBER_PROPERTY);
        return this;
    }
    public PaymentAccountRequest squareRootOfPopulationStandardDeviationAccountNumber(){
        return squareRootOfPopulationStandardDeviationAccountNumberAs(prefix("squareRootOfPopulationStandardDeviationOf",PaymentAccount.ACCOUNT_NUMBER_PROPERTY));
    }

    public PaymentAccountRequest squareRootOfPopulationStandardDeviationAccountNumberAs(String retName){
        super.squareRootOfPopulationStandardDeviation(retName, PaymentAccount.ACCOUNT_NUMBER_PROPERTY);
        return this;
    }
    public PaymentAccountRequest sampleVarianceAccountNumber(){
        return sampleVarianceAccountNumberAs(prefix("sampleVarianceOf",PaymentAccount.ACCOUNT_NUMBER_PROPERTY));
    }

    public PaymentAccountRequest sampleVarianceAccountNumberAs(String retName){
        super.sampleVariance(retName, PaymentAccount.ACCOUNT_NUMBER_PROPERTY);
        return this;
    }
    public PaymentAccountRequest samplePopulationVarianceAccountNumber(){
        return samplePopulationVarianceAccountNumberAs(prefix("samplePopulationVarianceOf",PaymentAccount.ACCOUNT_NUMBER_PROPERTY));
    }

    public PaymentAccountRequest samplePopulationVarianceAccountNumberAs(String retName){
        super.samplePopulationVariance(retName, PaymentAccount.ACCOUNT_NUMBER_PROPERTY);
        return this;
    }
    public PaymentAccountRequest<T> groupByUserAccountWithDetails(){
       return groupByUserAccountWithDetails(Q.userAccounts().unlimited());
    }

    public PaymentAccountRequest<T> groupByUserAccountWithDetails(UserAccountRequest subRequest){
       aggregate(PaymentAccount.USER_ACCOUNT_PROPERTY, subRequest);
       return this;
    }







    public PaymentAccountRequest<T> groupByPaymentMethodsWithDetails(PaymentMethodRequest subRequest){
       aggregate(PaymentAccount.PAYMENT_METHOD_LIST_PROPERTY, subRequest);
       return this;
    }
    public PaymentAccountRequest<T> groupByPaymentTransactionsWithDetails(PaymentTransactionRequest subRequest){
       aggregate(PaymentAccount.PAYMENT_TRANSACTION_LIST_PROPERTY, subRequest);
       return this;
    }

    public PaymentAccountRequest<T> groupById(){
       groupBy(PaymentAccount.ID_PROPERTY);
       return this;
    }

    public PaymentAccountRequest<T> groupByIdAs(String retName){
       groupBy(retName, PaymentAccount.ID_PROPERTY);
       return this;
    }

    public PaymentAccountRequest<T> groupByIdWithFunction(String retName, AggrFunction function){
       groupBy(retName, PaymentAccount.ID_PROPERTY, function);
       return this;
    }
    public PaymentAccountRequest<T> groupByUserAccountWith(UserAccountRequest subRequest){
       groupBy(PaymentAccount.USER_ACCOUNT_PROPERTY, subRequest);
       return this;
    }
    public PaymentAccountRequest<T> groupByUserAccount(){
       groupBy(PaymentAccount.USER_ACCOUNT_PROPERTY);
       return this;
    }

    public PaymentAccountRequest<T> groupByUserAccountAs(String retName){
       groupBy(retName, PaymentAccount.USER_ACCOUNT_PROPERTY);
       return this;
    }

    public PaymentAccountRequest<T> groupByUserAccountWithFunction(String retName, AggrFunction function){
       groupBy(retName, PaymentAccount.USER_ACCOUNT_PROPERTY, function);
       return this;
    }

    public PaymentAccountRequest<T> groupByAccountName(){
       groupBy(PaymentAccount.ACCOUNT_NAME_PROPERTY);
       return this;
    }

    public PaymentAccountRequest<T> groupByAccountNameAs(String retName){
       groupBy(retName, PaymentAccount.ACCOUNT_NAME_PROPERTY);
       return this;
    }

    public PaymentAccountRequest<T> groupByAccountNameWithFunction(String retName, AggrFunction function){
       groupBy(retName, PaymentAccount.ACCOUNT_NAME_PROPERTY, function);
       return this;
    }

    public PaymentAccountRequest<T> groupByAccountNumber(){
       groupBy(PaymentAccount.ACCOUNT_NUMBER_PROPERTY);
       return this;
    }

    public PaymentAccountRequest<T> groupByAccountNumberAs(String retName){
       groupBy(retName, PaymentAccount.ACCOUNT_NUMBER_PROPERTY);
       return this;
    }

    public PaymentAccountRequest<T> groupByAccountNumberWithFunction(String retName, AggrFunction function){
       groupBy(retName, PaymentAccount.ACCOUNT_NUMBER_PROPERTY, function);
       return this;
    }

    public PaymentAccountRequest<T> groupByCurrencyCode(){
       groupBy(PaymentAccount.CURRENCY_CODE_PROPERTY);
       return this;
    }

    public PaymentAccountRequest<T> groupByCurrencyCodeAs(String retName){
       groupBy(retName, PaymentAccount.CURRENCY_CODE_PROPERTY);
       return this;
    }

    public PaymentAccountRequest<T> groupByCurrencyCodeWithFunction(String retName, AggrFunction function){
       groupBy(retName, PaymentAccount.CURRENCY_CODE_PROPERTY, function);
       return this;
    }

    public PaymentAccountRequest<T> groupByCreateTime(){
       groupBy(PaymentAccount.CREATE_TIME_PROPERTY);
       return this;
    }

    public PaymentAccountRequest<T> groupByCreateTimeAs(String retName){
       groupBy(retName, PaymentAccount.CREATE_TIME_PROPERTY);
       return this;
    }

    public PaymentAccountRequest<T> groupByCreateTimeWithFunction(String retName, AggrFunction function){
       groupBy(retName, PaymentAccount.CREATE_TIME_PROPERTY, function);
       return this;
    }

    public PaymentAccountRequest<T> groupByUpdateTime(){
       groupBy(PaymentAccount.UPDATE_TIME_PROPERTY);
       return this;
    }

    public PaymentAccountRequest<T> groupByUpdateTimeAs(String retName){
       groupBy(retName, PaymentAccount.UPDATE_TIME_PROPERTY);
       return this;
    }

    public PaymentAccountRequest<T> groupByUpdateTimeWithFunction(String retName, AggrFunction function){
       groupBy(retName, PaymentAccount.UPDATE_TIME_PROPERTY, function);
       return this;
    }

    public PaymentAccountRequest<T> groupByVersion(){
       groupBy(PaymentAccount.VERSION_PROPERTY);
       return this;
    }

    public PaymentAccountRequest<T> groupByVersionAs(String retName){
       groupBy(retName, PaymentAccount.VERSION_PROPERTY);
       return this;
    }

    public PaymentAccountRequest<T> groupByVersionWithFunction(String retName, AggrFunction function){
       groupBy(retName, PaymentAccount.VERSION_PROPERTY, function);
       return this;
    }



    public PaymentAccountRequest<T> orderByIdAscending(){
       addOrderByAscending(PaymentAccount.ID_PROPERTY);
       return this;
    }

    public PaymentAccountRequest<T> orderByIdDescending(){
       addOrderByDescending(PaymentAccount.ID_PROPERTY);
       return this;
    }

    public PaymentAccountRequest<T> orderByUserAccountAscending(){
       addOrderByAscending(PaymentAccount.USER_ACCOUNT_PROPERTY);
       return this;
    }

    public PaymentAccountRequest<T> orderByUserAccountDescending(){
       addOrderByDescending(PaymentAccount.USER_ACCOUNT_PROPERTY);
       return this;
    }

    public PaymentAccountRequest<T> orderByAccountNameAscending(){
       addOrderByAscending(PaymentAccount.ACCOUNT_NAME_PROPERTY);
       return this;
    }

    public PaymentAccountRequest<T> orderByAccountNameDescending(){
       addOrderByDescending(PaymentAccount.ACCOUNT_NAME_PROPERTY);
       return this;
    }
    public PaymentAccountRequest<T> orderByAccountNameAscendingUsingGBK(){
       addOrderByAscendingUsingGBK(PaymentAccount.ACCOUNT_NAME_PROPERTY);
       return this;
    }

    public PaymentAccountRequest<T> orderByAccountNameDescendingUsingGBK(){
       addOrderByDescendingUsingGBK(PaymentAccount.ACCOUNT_NAME_PROPERTY);
       return this;
    }
    public PaymentAccountRequest<T> orderByAccountNumberAscending(){
       addOrderByAscending(PaymentAccount.ACCOUNT_NUMBER_PROPERTY);
       return this;
    }

    public PaymentAccountRequest<T> orderByAccountNumberDescending(){
       addOrderByDescending(PaymentAccount.ACCOUNT_NUMBER_PROPERTY);
       return this;
    }

    public PaymentAccountRequest<T> orderByCurrencyCodeAscending(){
       addOrderByAscending(PaymentAccount.CURRENCY_CODE_PROPERTY);
       return this;
    }

    public PaymentAccountRequest<T> orderByCurrencyCodeDescending(){
       addOrderByDescending(PaymentAccount.CURRENCY_CODE_PROPERTY);
       return this;
    }
    public PaymentAccountRequest<T> orderByCurrencyCodeAscendingUsingGBK(){
       addOrderByAscendingUsingGBK(PaymentAccount.CURRENCY_CODE_PROPERTY);
       return this;
    }

    public PaymentAccountRequest<T> orderByCurrencyCodeDescendingUsingGBK(){
       addOrderByDescendingUsingGBK(PaymentAccount.CURRENCY_CODE_PROPERTY);
       return this;
    }
    public PaymentAccountRequest<T> orderByCreateTimeAscending(){
       addOrderByAscending(PaymentAccount.CREATE_TIME_PROPERTY);
       return this;
    }

    public PaymentAccountRequest<T> orderByCreateTimeDescending(){
       addOrderByDescending(PaymentAccount.CREATE_TIME_PROPERTY);
       return this;
    }

    public PaymentAccountRequest<T> orderByUpdateTimeAscending(){
       addOrderByAscending(PaymentAccount.UPDATE_TIME_PROPERTY);
       return this;
    }

    public PaymentAccountRequest<T> orderByUpdateTimeDescending(){
       addOrderByDescending(PaymentAccount.UPDATE_TIME_PROPERTY);
       return this;
    }

    public PaymentAccountRequest<T> orderByVersionAscending(){
       addOrderByAscending(PaymentAccount.VERSION_PROPERTY);
       return this;
    }

    public PaymentAccountRequest<T> orderByVersionDescending(){
       addOrderByDescending(PaymentAccount.VERSION_PROPERTY);
       return this;
    }


    public PaymentAccountRequest<T> statsFromPaymentMethodsAs(String name, PaymentMethodRequest subRequest){
       return statsFromPaymentMethodsAs(name, subRequest, false);
    }

    public PaymentAccountRequest<T> statsFromPaymentMethodsAs(String name, PaymentMethodRequest subRequest, boolean singleResult){
       subRequest.setPartitionProperty(PaymentMethod.PAYMENT_ACCOUNT_PROPERTY);
       addAggregateDynamicProperty(name, subRequest, singleResult);
       return this;
    }

    public PaymentAccountRequest<T> statsFromPaymentMethods(PaymentMethodRequest subRequest){
       return statsFromPaymentMethodsAs(REFINEMENTS, subRequest);
    }
    public PaymentAccountRequest<T> statsFromPaymentTransactionsAs(String name, PaymentTransactionRequest subRequest){
       return statsFromPaymentTransactionsAs(name, subRequest, false);
    }

    public PaymentAccountRequest<T> statsFromPaymentTransactionsAs(String name, PaymentTransactionRequest subRequest, boolean singleResult){
       subRequest.setPartitionProperty(PaymentTransaction.PAYMENT_ACCOUNT_PROPERTY);
       addAggregateDynamicProperty(name, subRequest, singleResult);
       return this;
    }

    public PaymentAccountRequest<T> statsFromPaymentTransactions(PaymentTransactionRequest subRequest){
       return statsFromPaymentTransactionsAs(REFINEMENTS, subRequest);
    }
    public UserAccountRequest rollUpToUserAccount(){
       UserAccountRequest userAccount = Q.userAccounts().unlimited();
       this.withUserAccountMatching(userAccount)
           .groupByUserAccountWith(userAccount);
       return userAccount;
    }







    public PaymentAccountRequest<T> countPaymentMethods(){
        return countPaymentMethodsAs("Count");
    }

    public PaymentAccountRequest<T> countPaymentMethodsAs(String name){
        return countPaymentMethodsWith(name, Q.paymentMethods().unlimited());
    }

    public PaymentAccountRequest<T> countPaymentMethodsWith(String name, PaymentMethodRequest subRequest){
        return statsFromPaymentMethodsAs(name, subRequest.count(), true);
    }
    public PaymentAccountRequest<T> countPaymentTransactions(){
        return countPaymentTransactionsAs("Count");
    }

    public PaymentAccountRequest<T> countPaymentTransactionsAs(String name){
        return countPaymentTransactionsWith(name, Q.paymentTransactions().unlimited());
    }

    public PaymentAccountRequest<T> countPaymentTransactionsWith(String name, PaymentTransactionRequest subRequest){
        return statsFromPaymentTransactionsAs(name, subRequest.count(), true);
    }
    public PaymentAccountRequest<T> minLastFourDigitsOfPaymentMethods(){
        return minLastFourDigitsOfPaymentMethodsAs("minLastFourDigitsOfPaymentMethods");
    }

    public PaymentAccountRequest<T> minLastFourDigitsOfPaymentMethodsAs(String name){
        return minLastFourDigitsOfPaymentMethodsAs(name, Q.paymentMethods().unlimited());
    }

    public PaymentAccountRequest<T> minLastFourDigitsOfPaymentMethodsAs(String name, PaymentMethodRequest subRequest){
        return statsFromPaymentMethodsAs(name, subRequest.minLastFourDigits(), true);
    }
    public PaymentAccountRequest<T> maxLastFourDigitsOfPaymentMethods(){
        return maxLastFourDigitsOfPaymentMethodsAs("maxLastFourDigitsOfPaymentMethods");
    }

    public PaymentAccountRequest<T> maxLastFourDigitsOfPaymentMethodsAs(String name){
        return maxLastFourDigitsOfPaymentMethodsAs(name, Q.paymentMethods().unlimited());
    }

    public PaymentAccountRequest<T> maxLastFourDigitsOfPaymentMethodsAs(String name, PaymentMethodRequest subRequest){
        return statsFromPaymentMethodsAs(name, subRequest.maxLastFourDigits(), true);
    }
    public PaymentAccountRequest<T> sumLastFourDigitsOfPaymentMethods(){
        return sumLastFourDigitsOfPaymentMethodsAs("sumLastFourDigitsOfPaymentMethods");
    }

    public PaymentAccountRequest<T> sumLastFourDigitsOfPaymentMethodsAs(String name){
        return sumLastFourDigitsOfPaymentMethodsAs(name, Q.paymentMethods().unlimited());
    }

    public PaymentAccountRequest<T> sumLastFourDigitsOfPaymentMethodsAs(String name, PaymentMethodRequest subRequest){
        return statsFromPaymentMethodsAs(name, subRequest.sumLastFourDigits(), true);
    }
    public PaymentAccountRequest<T> avgLastFourDigitsOfPaymentMethods(){
        return avgLastFourDigitsOfPaymentMethodsAs("avgLastFourDigitsOfPaymentMethods");
    }

    public PaymentAccountRequest<T> avgLastFourDigitsOfPaymentMethodsAs(String name){
        return avgLastFourDigitsOfPaymentMethodsAs(name, Q.paymentMethods().unlimited());
    }

    public PaymentAccountRequest<T> avgLastFourDigitsOfPaymentMethodsAs(String name, PaymentMethodRequest subRequest){
        return statsFromPaymentMethodsAs(name, subRequest.avgLastFourDigits(), true);
    }
    public PaymentAccountRequest<T> standardDeviationLastFourDigitsOfPaymentMethods(){
        return standardDeviationLastFourDigitsOfPaymentMethodsAs("stdDevLastFourDigitsOfPaymentMethods");
    }

    public PaymentAccountRequest<T> standardDeviationLastFourDigitsOfPaymentMethodsAs(String name){
        return standardDeviationLastFourDigitsOfPaymentMethodsAs(name, Q.paymentMethods().unlimited());
    }

    public PaymentAccountRequest<T> standardDeviationLastFourDigitsOfPaymentMethodsAs(String name, PaymentMethodRequest subRequest){
        return statsFromPaymentMethodsAs(name, subRequest.standardDeviationLastFourDigits(), true);
    }
    public PaymentAccountRequest<T> squareRootOfPopulationStandardDeviationLastFourDigitsOfPaymentMethods(){
        return squareRootOfPopulationStandardDeviationLastFourDigitsOfPaymentMethodsAs("stdDevPopLastFourDigitsOfPaymentMethods");
    }

    public PaymentAccountRequest<T> squareRootOfPopulationStandardDeviationLastFourDigitsOfPaymentMethodsAs(String name){
        return squareRootOfPopulationStandardDeviationLastFourDigitsOfPaymentMethodsAs(name, Q.paymentMethods().unlimited());
    }

    public PaymentAccountRequest<T> squareRootOfPopulationStandardDeviationLastFourDigitsOfPaymentMethodsAs(String name, PaymentMethodRequest subRequest){
        return statsFromPaymentMethodsAs(name, subRequest.squareRootOfPopulationStandardDeviationLastFourDigits(), true);
    }
    public PaymentAccountRequest<T> sampleVarianceLastFourDigitsOfPaymentMethods(){
        return sampleVarianceLastFourDigitsOfPaymentMethodsAs("varSampLastFourDigitsOfPaymentMethods");
    }

    public PaymentAccountRequest<T> sampleVarianceLastFourDigitsOfPaymentMethodsAs(String name){
        return sampleVarianceLastFourDigitsOfPaymentMethodsAs(name, Q.paymentMethods().unlimited());
    }

    public PaymentAccountRequest<T> sampleVarianceLastFourDigitsOfPaymentMethodsAs(String name, PaymentMethodRequest subRequest){
        return statsFromPaymentMethodsAs(name, subRequest.sampleVarianceLastFourDigits(), true);
    }
    public PaymentAccountRequest<T> samplePopulationVarianceLastFourDigitsOfPaymentMethods(){
        return samplePopulationVarianceLastFourDigitsOfPaymentMethodsAs("varPopLastFourDigitsOfPaymentMethods");
    }

    public PaymentAccountRequest<T> samplePopulationVarianceLastFourDigitsOfPaymentMethodsAs(String name){
        return samplePopulationVarianceLastFourDigitsOfPaymentMethodsAs(name, Q.paymentMethods().unlimited());
    }

    public PaymentAccountRequest<T> samplePopulationVarianceLastFourDigitsOfPaymentMethodsAs(String name, PaymentMethodRequest subRequest){
        return statsFromPaymentMethodsAs(name, subRequest.samplePopulationVarianceLastFourDigits(), true);
    }
    public PaymentAccountRequest<T> minTransactionAmountOfPaymentTransactions(){
        return minTransactionAmountOfPaymentTransactionsAs("minTransactionAmountOfPaymentTransactions");
    }

    public PaymentAccountRequest<T> minTransactionAmountOfPaymentTransactionsAs(String name){
        return minTransactionAmountOfPaymentTransactionsAs(name, Q.paymentTransactions().unlimited());
    }

    public PaymentAccountRequest<T> minTransactionAmountOfPaymentTransactionsAs(String name, PaymentTransactionRequest subRequest){
        return statsFromPaymentTransactionsAs(name, subRequest.minTransactionAmount(), true);
    }
    public PaymentAccountRequest<T> maxTransactionAmountOfPaymentTransactions(){
        return maxTransactionAmountOfPaymentTransactionsAs("maxTransactionAmountOfPaymentTransactions");
    }

    public PaymentAccountRequest<T> maxTransactionAmountOfPaymentTransactionsAs(String name){
        return maxTransactionAmountOfPaymentTransactionsAs(name, Q.paymentTransactions().unlimited());
    }

    public PaymentAccountRequest<T> maxTransactionAmountOfPaymentTransactionsAs(String name, PaymentTransactionRequest subRequest){
        return statsFromPaymentTransactionsAs(name, subRequest.maxTransactionAmount(), true);
    }
    public PaymentAccountRequest<T> sumTransactionAmountOfPaymentTransactions(){
        return sumTransactionAmountOfPaymentTransactionsAs("sumTransactionAmountOfPaymentTransactions");
    }

    public PaymentAccountRequest<T> sumTransactionAmountOfPaymentTransactionsAs(String name){
        return sumTransactionAmountOfPaymentTransactionsAs(name, Q.paymentTransactions().unlimited());
    }

    public PaymentAccountRequest<T> sumTransactionAmountOfPaymentTransactionsAs(String name, PaymentTransactionRequest subRequest){
        return statsFromPaymentTransactionsAs(name, subRequest.sumTransactionAmount(), true);
    }
    public PaymentAccountRequest<T> avgTransactionAmountOfPaymentTransactions(){
        return avgTransactionAmountOfPaymentTransactionsAs("avgTransactionAmountOfPaymentTransactions");
    }

    public PaymentAccountRequest<T> avgTransactionAmountOfPaymentTransactionsAs(String name){
        return avgTransactionAmountOfPaymentTransactionsAs(name, Q.paymentTransactions().unlimited());
    }

    public PaymentAccountRequest<T> avgTransactionAmountOfPaymentTransactionsAs(String name, PaymentTransactionRequest subRequest){
        return statsFromPaymentTransactionsAs(name, subRequest.avgTransactionAmount(), true);
    }
    public PaymentAccountRequest<T> standardDeviationTransactionAmountOfPaymentTransactions(){
        return standardDeviationTransactionAmountOfPaymentTransactionsAs("stdDevTransactionAmountOfPaymentTransactions");
    }

    public PaymentAccountRequest<T> standardDeviationTransactionAmountOfPaymentTransactionsAs(String name){
        return standardDeviationTransactionAmountOfPaymentTransactionsAs(name, Q.paymentTransactions().unlimited());
    }

    public PaymentAccountRequest<T> standardDeviationTransactionAmountOfPaymentTransactionsAs(String name, PaymentTransactionRequest subRequest){
        return statsFromPaymentTransactionsAs(name, subRequest.standardDeviationTransactionAmount(), true);
    }
    public PaymentAccountRequest<T> squareRootOfPopulationStandardDeviationTransactionAmountOfPaymentTransactions(){
        return squareRootOfPopulationStandardDeviationTransactionAmountOfPaymentTransactionsAs("stdDevPopTransactionAmountOfPaymentTransactions");
    }

    public PaymentAccountRequest<T> squareRootOfPopulationStandardDeviationTransactionAmountOfPaymentTransactionsAs(String name){
        return squareRootOfPopulationStandardDeviationTransactionAmountOfPaymentTransactionsAs(name, Q.paymentTransactions().unlimited());
    }

    public PaymentAccountRequest<T> squareRootOfPopulationStandardDeviationTransactionAmountOfPaymentTransactionsAs(String name, PaymentTransactionRequest subRequest){
        return statsFromPaymentTransactionsAs(name, subRequest.squareRootOfPopulationStandardDeviationTransactionAmount(), true);
    }
    public PaymentAccountRequest<T> sampleVarianceTransactionAmountOfPaymentTransactions(){
        return sampleVarianceTransactionAmountOfPaymentTransactionsAs("varSampTransactionAmountOfPaymentTransactions");
    }

    public PaymentAccountRequest<T> sampleVarianceTransactionAmountOfPaymentTransactionsAs(String name){
        return sampleVarianceTransactionAmountOfPaymentTransactionsAs(name, Q.paymentTransactions().unlimited());
    }

    public PaymentAccountRequest<T> sampleVarianceTransactionAmountOfPaymentTransactionsAs(String name, PaymentTransactionRequest subRequest){
        return statsFromPaymentTransactionsAs(name, subRequest.sampleVarianceTransactionAmount(), true);
    }
    public PaymentAccountRequest<T> samplePopulationVarianceTransactionAmountOfPaymentTransactions(){
        return samplePopulationVarianceTransactionAmountOfPaymentTransactionsAs("varPopTransactionAmountOfPaymentTransactions");
    }

    public PaymentAccountRequest<T> samplePopulationVarianceTransactionAmountOfPaymentTransactionsAs(String name){
        return samplePopulationVarianceTransactionAmountOfPaymentTransactionsAs(name, Q.paymentTransactions().unlimited());
    }

    public PaymentAccountRequest<T> samplePopulationVarianceTransactionAmountOfPaymentTransactionsAs(String name, PaymentTransactionRequest subRequest){
        return statsFromPaymentTransactionsAs(name, subRequest.samplePopulationVarianceTransactionAmount(), true);
    }

   public PaymentAccountRequest<T> facetByUserAccountAs(String facetName, UserAccountRequest userAccount){
       return facetByUserAccountAs(facetName, userAccount, true);
   }

   public PaymentAccountRequest<T> facetByUserAccountAs(String facetName, UserAccountRequest userAccount, boolean includeAllFacets){
       addFacet(facetName, PaymentAccount.USER_ACCOUNT_PROPERTY, userAccount, includeAllFacets);
       return this;
   }


    /**
     * get topN records
     * @param topN  records number
     */
    public PaymentAccountRequest<T> top(int topN) {
        super.top(topN);
        return this;
    }

    /**
     * get records from offset(inclusive) to offset+size(exclusive)
     * @param offset record offset
     * @param size records number
     */
    public PaymentAccountRequest<T> offset(int offset, int size) {
        super.offset(offset, size);
        return this;
    }

    /**
     * retrieve all records
     */
    public PaymentAccountRequest<T> unlimited() {
        super.unlimited();
        return this;
    }

    /**
     * get records of one page
     * @param pageNumber page number(1-based)
     * @param pageSize page size
     */
    public PaymentAccountRequest<T> page(int pageNumber, int pageSize) {
        int offset = (pageNumber - 1) * pageSize;
        return offset(offset, pageSize);
   }

    /**
     * get records of one page, default page size is 10
     * @param pageNumber page number(1-based)
     */
    public PaymentAccountRequest<T> page(int pageNumber) {
        return page(pageNumber, 10);
   }
}