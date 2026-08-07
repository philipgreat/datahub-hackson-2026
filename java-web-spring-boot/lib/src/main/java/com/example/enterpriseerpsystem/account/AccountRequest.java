
package com.example.enterpriseerpsystem.account;

import com.example.enterpriseerpsystem.Q;
import com.example.enterpriseerpsystem.transaction.Transaction;
import com.example.enterpriseerpsystem.transaction.TransactionRequest;
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

public class AccountRequest<T extends Account> extends BaseRequest<T> {

    /**
     * @deprecated AI agents and business code must use the generated Q facade
     *             instead of constructing request builders directly.
     */
    @Deprecated
    public AccountRequest(Class<T> returnType){
        super(returnType);
        selectId();
        selectVersion();
    }

    public AccountRequest<T> comment(String comment){
         super.internalComment(comment);
         return this;
    }

    // purpose() 继承自 BaseRequest，返回 ExecutableRequest（终结方法）

    public AccountRequest<T> returnType(Class<? extends T> returnType){
        super.setReturnType(returnType);
        return this;
    }

    public AccountRequest<T> enableAggregationCache(long cacheExpiredMillis){
        super.enableAggregationCache();
        super.aggregateCacheTime(cacheExpiredMillis);
        return this;
    }

    public AccountRequest<T> enableAggregationCache(){
        return enableAggregationCache(0l);
    }


    public AccountRequest<T> propagateAggregationCache(long cacheExpiredMillis){
        super.propagateAggregationCache(cacheExpiredMillis);
        return this;
    }

    public AccountRequest<T> appendSearchCriteria(SearchCriteria searchCriteria){
        return (AccountRequest<T>)super.appendSearchCriteria(searchCriteria);
    }

    public AccountRequest<T> filter(String property1, Operator operator, String property2){
        return appendSearchCriteria(new TwoOperatorCriteria(operator, new PropertyReference(property1), new PropertyReference(property2)));
    }


    public AccountRequest<T> matchingAnyOf(AccountRequest account){
        super.internalMatchAny(account);
        return this;
    }

    public AccountRequest<T> enhanceChildrenIfNeeded(){
        return this;
    }

    public AccountRequest<T> withDeletedRows(){
        super.withDeletedRows();
        return this;
    }

    public AccountRequest<T> deletedRowsOnly(){
        super.deletedRowsOnly();
        return this;
    }

    public AccountRequest<T> selectSelf(){
        super.selectSelf();
        return selectId().selectName().selectAccountType().selectBalance().selectCurrency().selectCreateTime().selectUpdateTime().selectVersion();
    }

    public AccountRequest<T> selectSelfFields(){
        return selectSelf();
    }

    public AccountRequest<T> selectAll(){
        super.selectAll();
        return selectId().selectName().selectAccountType().selectBalance().selectCurrency().selectCreateTime().selectUpdateTime().selectVersion();
    }

    public AccountRequest<T> selectChildren(){
        super.selectAny();
        selectTransactionList();
        return selectId().selectName().selectAccountType().selectBalance().selectCurrency().selectCreateTime().selectUpdateTime().selectVersion();
    }


    public AccountRequest<T> selectId(){
       selectProperty(Account.ID_PROPERTY);
       return this;
    }

    /**
     * fill the id with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  id) to fetch id property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public AccountRequest<T> unselectId(){
       unselectProperty(Account.ID_PROPERTY);
       return this;
    }
    public AccountRequest<T> selectName(){
       selectProperty(Account.NAME_PROPERTY);
       return this;
    }

    /**
     * fill the name with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  name) to fetch name property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public AccountRequest<T> unselectName(){
       unselectProperty(Account.NAME_PROPERTY);
       return this;
    }
    public AccountRequest<T> selectAccountType(){
       selectProperty(Account.ACCOUNT_TYPE_PROPERTY);
       return this;
    }

    /**
     * fill the accountType with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  accountType) to fetch accountType property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public AccountRequest<T> unselectAccountType(){
       unselectProperty(Account.ACCOUNT_TYPE_PROPERTY);
       return this;
    }
    public AccountRequest<T> selectBalance(){
       selectProperty(Account.BALANCE_PROPERTY);
       return this;
    }

    /**
     * fill the balance with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  balance) to fetch balance property.
     * @param rawSqlSegment  customized rawSqlSegment
     */


    /**
     * fill the balance with customized aggrFunction, TEAQL uses ({aggrFunction}(balance) AS balance to fetch balance property.
     * @param aggrFunction  aggrFunction
     */
    public AccountRequest<T> selectBalance(AggrFunction aggrFunction){
       selectProperty(Account.BALANCE_PROPERTY, aggrFunction);
       return this;
    }


    public AccountRequest<T> unselectBalance(){
       unselectProperty(Account.BALANCE_PROPERTY);
       return this;
    }
    public AccountRequest<T> selectCurrency(){
       selectProperty(Account.CURRENCY_PROPERTY);
       return this;
    }

    /**
     * fill the currency with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  currency) to fetch currency property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public AccountRequest<T> unselectCurrency(){
       unselectProperty(Account.CURRENCY_PROPERTY);
       return this;
    }
    public AccountRequest<T> selectCreateTime(){
       selectProperty(Account.CREATE_TIME_PROPERTY);
       return this;
    }

    /**
     * fill the createTime with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  createTime) to fetch createTime property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public AccountRequest<T> unselectCreateTime(){
       unselectProperty(Account.CREATE_TIME_PROPERTY);
       return this;
    }
    public AccountRequest<T> selectUpdateTime(){
       selectProperty(Account.UPDATE_TIME_PROPERTY);
       return this;
    }

    /**
     * fill the updateTime with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  updateTime) to fetch updateTime property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public AccountRequest<T> unselectUpdateTime(){
       unselectProperty(Account.UPDATE_TIME_PROPERTY);
       return this;
    }
    public AccountRequest<T> selectVersion(){
       selectProperty(Account.VERSION_PROPERTY);
       return this;
    }

    /**
     * fill the version with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  version) to fetch version property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public AccountRequest<T> unselectVersion(){
       unselectProperty(Account.VERSION_PROPERTY);
       return this;
    }
    public AccountRequest<T> selectTransactionList(){
       return selectTransactionListWith(Q.transactions().selectSelf());
    }

    public AccountRequest<T> selectTransactionListWith(TransactionRequest transactionList){
       enhanceRelation(Account.TRANSACTION_LIST_PROPERTY, transactionList);
       return this;
    }

    public AccountRequest<T> withId(Operator operator, Object... values){
       return appendSearchCriteria(createIdCriteria(operator, values));
    }

    public SearchCriteria createIdCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Account.ID_PROPERTY, operator, values);
    }

    public AccountRequest<T> withIdIs(Long id){
       return withId(Operator.EQUAL, id);
    }
    public AccountRequest<T> withIdIn(Long... id){
       return withId(Operator.EQUAL, (Object[])id);
    }



    public AccountRequest<T> filterByName(String... name){
      if (name == null || name.length == 0) {
        throw new IllegalArgumentException("filterByName parameter name cannot be empty");
      }
      return appendSearchCriteria(createNameCriteria(Operator.EQUAL, (Object[])name));
    }

    public AccountRequest<T> withName(Operator operator, Object... values){
       return appendSearchCriteria(createNameCriteria(operator, values));
    }

    public AccountRequest<T> withNameIsUnknown(){
       return withName(Operator.IS_NULL);
    }

    public AccountRequest<T> withNameIsKnown(){
       return withName(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createNameCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Account.NAME_PROPERTY, operator, values);
    }

    public AccountRequest<T> withNameGreaterThan(String name){
       return withName(Operator.GREATER_THAN, name);
    }

    public AccountRequest<T> withNameGreaterThanOrEqualTo(String name){
       return withName(Operator.GREATER_THAN_OR_EQUAL, name);
    }

    public AccountRequest<T> withNameLessThan(String name){
       return withName(Operator.LESS_THAN, name);
    }

    public AccountRequest<T> withNameLessThanOrEqualTo(String name){
       return withName(Operator.LESS_THAN_OR_EQUAL, name);
    }

    public AccountRequest<T> withNameBetween(String startOfName, String endOfName){
       return withName(Operator.BETWEEN, startOfName, endOfName);
    }
    public AccountRequest<T> withNameStartingWith(String name){
       return withName(Operator.BEGIN_WITH, name);
    }
    public AccountRequest<T> withNameContaining(String name){
       return withName(Operator.CONTAIN, name);
    }

    public AccountRequest<T> withNameEndingWith(String name){
       return withName(Operator.END_WITH, name);
    }

    public AccountRequest<T> withNameIs(String name){
       return withName(Operator.EQUAL, name);
    }

    public AccountRequest<T> withNameSoundingLike(String name){
       return withName(Operator.SOUNDS_LIKE, name);
    }



    public AccountRequest<T> filterByAccountType(String... accountType){
      if (accountType == null || accountType.length == 0) {
        throw new IllegalArgumentException("filterByAccountType parameter accountType cannot be empty");
      }
      return appendSearchCriteria(createAccountTypeCriteria(Operator.EQUAL, (Object[])accountType));
    }

    public AccountRequest<T> withAccountType(Operator operator, Object... values){
       return appendSearchCriteria(createAccountTypeCriteria(operator, values));
    }

    public AccountRequest<T> withAccountTypeIsUnknown(){
       return withAccountType(Operator.IS_NULL);
    }

    public AccountRequest<T> withAccountTypeIsKnown(){
       return withAccountType(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createAccountTypeCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Account.ACCOUNT_TYPE_PROPERTY, operator, values);
    }

    public AccountRequest<T> withAccountTypeGreaterThan(String accountType){
       return withAccountType(Operator.GREATER_THAN, accountType);
    }

    public AccountRequest<T> withAccountTypeGreaterThanOrEqualTo(String accountType){
       return withAccountType(Operator.GREATER_THAN_OR_EQUAL, accountType);
    }

    public AccountRequest<T> withAccountTypeLessThan(String accountType){
       return withAccountType(Operator.LESS_THAN, accountType);
    }

    public AccountRequest<T> withAccountTypeLessThanOrEqualTo(String accountType){
       return withAccountType(Operator.LESS_THAN_OR_EQUAL, accountType);
    }

    public AccountRequest<T> withAccountTypeBetween(String startOfAccountType, String endOfAccountType){
       return withAccountType(Operator.BETWEEN, startOfAccountType, endOfAccountType);
    }
    public AccountRequest<T> withAccountTypeStartingWith(String accountType){
       return withAccountType(Operator.BEGIN_WITH, accountType);
    }
    public AccountRequest<T> withAccountTypeContaining(String accountType){
       return withAccountType(Operator.CONTAIN, accountType);
    }

    public AccountRequest<T> withAccountTypeEndingWith(String accountType){
       return withAccountType(Operator.END_WITH, accountType);
    }

    public AccountRequest<T> withAccountTypeIs(String accountType){
       return withAccountType(Operator.EQUAL, accountType);
    }

    public AccountRequest<T> withAccountTypeSoundingLike(String accountType){
       return withAccountType(Operator.SOUNDS_LIKE, accountType);
    }



    public AccountRequest<T> filterByBalance(BigDecimal... balance){
      if (balance == null || balance.length == 0) {
        throw new IllegalArgumentException("filterByBalance parameter balance cannot be empty");
      }
      return appendSearchCriteria(createBalanceCriteria(Operator.EQUAL, (Object[])balance));
    }

    public AccountRequest<T> withBalance(Operator operator, Object... values){
       return appendSearchCriteria(createBalanceCriteria(operator, values));
    }

    public AccountRequest<T> withBalanceIsUnknown(){
       return withBalance(Operator.IS_NULL);
    }

    public AccountRequest<T> withBalanceIsKnown(){
       return withBalance(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createBalanceCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Account.BALANCE_PROPERTY, operator, values);
    }

    public AccountRequest<T> withBalanceGreaterThan(BigDecimal balance){
       return withBalance(Operator.GREATER_THAN, balance);
    }

    public AccountRequest<T> withBalanceGreaterThanOrEqualTo(BigDecimal balance){
       return withBalance(Operator.GREATER_THAN_OR_EQUAL, balance);
    }

    public AccountRequest<T> withBalanceLessThan(BigDecimal balance){
       return withBalance(Operator.LESS_THAN, balance);
    }

    public AccountRequest<T> withBalanceLessThanOrEqualTo(BigDecimal balance){
       return withBalance(Operator.LESS_THAN_OR_EQUAL, balance);
    }

    public AccountRequest<T> withBalanceBetween(BigDecimal startOfBalance, BigDecimal endOfBalance){
       return withBalance(Operator.BETWEEN, startOfBalance, endOfBalance);
    }



    public AccountRequest<T> filterByCurrency(String... currency){
      if (currency == null || currency.length == 0) {
        throw new IllegalArgumentException("filterByCurrency parameter currency cannot be empty");
      }
      return appendSearchCriteria(createCurrencyCriteria(Operator.EQUAL, (Object[])currency));
    }

    public AccountRequest<T> withCurrency(Operator operator, Object... values){
       return appendSearchCriteria(createCurrencyCriteria(operator, values));
    }

    public AccountRequest<T> withCurrencyIsUnknown(){
       return withCurrency(Operator.IS_NULL);
    }

    public AccountRequest<T> withCurrencyIsKnown(){
       return withCurrency(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createCurrencyCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Account.CURRENCY_PROPERTY, operator, values);
    }

    public AccountRequest<T> withCurrencyGreaterThan(String currency){
       return withCurrency(Operator.GREATER_THAN, currency);
    }

    public AccountRequest<T> withCurrencyGreaterThanOrEqualTo(String currency){
       return withCurrency(Operator.GREATER_THAN_OR_EQUAL, currency);
    }

    public AccountRequest<T> withCurrencyLessThan(String currency){
       return withCurrency(Operator.LESS_THAN, currency);
    }

    public AccountRequest<T> withCurrencyLessThanOrEqualTo(String currency){
       return withCurrency(Operator.LESS_THAN_OR_EQUAL, currency);
    }

    public AccountRequest<T> withCurrencyBetween(String startOfCurrency, String endOfCurrency){
       return withCurrency(Operator.BETWEEN, startOfCurrency, endOfCurrency);
    }
    public AccountRequest<T> withCurrencyStartingWith(String currency){
       return withCurrency(Operator.BEGIN_WITH, currency);
    }
    public AccountRequest<T> withCurrencyContaining(String currency){
       return withCurrency(Operator.CONTAIN, currency);
    }

    public AccountRequest<T> withCurrencyEndingWith(String currency){
       return withCurrency(Operator.END_WITH, currency);
    }

    public AccountRequest<T> withCurrencyIs(String currency){
       return withCurrency(Operator.EQUAL, currency);
    }

    public AccountRequest<T> withCurrencySoundingLike(String currency){
       return withCurrency(Operator.SOUNDS_LIKE, currency);
    }



    public AccountRequest<T> filterByCreateTime(LocalDateTime... createTime){
      if (createTime == null || createTime.length == 0) {
        throw new IllegalArgumentException("filterByCreateTime parameter createTime cannot be empty");
      }
      return appendSearchCriteria(createCreateTimeCriteria(Operator.EQUAL, (Object[])createTime));
    }

    public AccountRequest<T> withCreateTime(Operator operator, Object... values){
       return appendSearchCriteria(createCreateTimeCriteria(operator, values));
    }

    public AccountRequest<T> withCreateTimeIsUnknown(){
       return withCreateTime(Operator.IS_NULL);
    }

    public AccountRequest<T> withCreateTimeIsKnown(){
       return withCreateTime(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createCreateTimeCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Account.CREATE_TIME_PROPERTY, operator, values);
    }

    public AccountRequest<T> withCreateTimeGreaterThan(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public AccountRequest<T> withCreateTimeGreaterThanOrEqualTo(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN_OR_EQUAL, createTime);
    }

    public AccountRequest<T> withCreateTimeLessThan(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public AccountRequest<T> withCreateTimeLessThanOrEqualTo(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN_OR_EQUAL, createTime);
    }

    public AccountRequest<T> withCreateTimeBetween(LocalDateTime startOfCreateTime, LocalDateTime endOfCreateTime){
       return withCreateTime(Operator.BETWEEN, startOfCreateTime, endOfCreateTime);
    }
    public AccountRequest<T> withCreateTimeBefore(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public AccountRequest<T> withCreateTimeBefore(Date createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public AccountRequest<T> withCreateTimeAfter(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public AccountRequest<T> withCreateTimeAfter(Date createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public AccountRequest<T> withCreateTimeBetween(Date startOfCreateTime, Date endOfCreateTime){
       return withCreateTime(Operator.BETWEEN, startOfCreateTime, endOfCreateTime);
    }




    public AccountRequest<T> filterByUpdateTime(LocalDateTime... updateTime){
      if (updateTime == null || updateTime.length == 0) {
        throw new IllegalArgumentException("filterByUpdateTime parameter updateTime cannot be empty");
      }
      return appendSearchCriteria(createUpdateTimeCriteria(Operator.EQUAL, (Object[])updateTime));
    }

    public AccountRequest<T> withUpdateTime(Operator operator, Object... values){
       return appendSearchCriteria(createUpdateTimeCriteria(operator, values));
    }

    public AccountRequest<T> withUpdateTimeIsUnknown(){
       return withUpdateTime(Operator.IS_NULL);
    }

    public AccountRequest<T> withUpdateTimeIsKnown(){
       return withUpdateTime(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createUpdateTimeCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Account.UPDATE_TIME_PROPERTY, operator, values);
    }

    public AccountRequest<T> withUpdateTimeGreaterThan(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public AccountRequest<T> withUpdateTimeGreaterThanOrEqualTo(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN_OR_EQUAL, updateTime);
    }

    public AccountRequest<T> withUpdateTimeLessThan(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public AccountRequest<T> withUpdateTimeLessThanOrEqualTo(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN_OR_EQUAL, updateTime);
    }

    public AccountRequest<T> withUpdateTimeBetween(LocalDateTime startOfUpdateTime, LocalDateTime endOfUpdateTime){
       return withUpdateTime(Operator.BETWEEN, startOfUpdateTime, endOfUpdateTime);
    }
    public AccountRequest<T> withUpdateTimeBefore(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public AccountRequest<T> withUpdateTimeBefore(Date updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public AccountRequest<T> withUpdateTimeAfter(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public AccountRequest<T> withUpdateTimeAfter(Date updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public AccountRequest<T> withUpdateTimeBetween(Date startOfUpdateTime, Date endOfUpdateTime){
       return withUpdateTime(Operator.BETWEEN, startOfUpdateTime, endOfUpdateTime);
    }




    public AccountRequest<T> filterByVersion(Long... version){
      if (version == null || version.length == 0) {
        throw new IllegalArgumentException("filterByVersion parameter version cannot be empty");
      }
      return appendSearchCriteria(createVersionCriteria(Operator.EQUAL, (Object[])version));
    }

    public AccountRequest<T> withVersion(Operator operator, Object... values){
       return appendSearchCriteria(createVersionCriteria(operator, values));
    }

    public AccountRequest<T> withVersionIsUnknown(){
       return withVersion(Operator.IS_NULL);
    }

    public AccountRequest<T> withVersionIsKnown(){
       return withVersion(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createVersionCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Account.VERSION_PROPERTY, operator, values);
    }

    public AccountRequest<T> withVersionGreaterThan(Long version){
       return withVersion(Operator.GREATER_THAN, version);
    }

    public AccountRequest<T> withVersionGreaterThanOrEqualTo(Long version){
       return withVersion(Operator.GREATER_THAN_OR_EQUAL, version);
    }

    public AccountRequest<T> withVersionLessThan(Long version){
       return withVersion(Operator.LESS_THAN, version);
    }

    public AccountRequest<T> withVersionLessThanOrEqualTo(Long version){
       return withVersion(Operator.LESS_THAN_OR_EQUAL, version);
    }

    public AccountRequest<T> withVersionBetween(Long startOfVersion, Long endOfVersion){
       return withVersion(Operator.BETWEEN, startOfVersion, endOfVersion);
    }

    public AccountRequest<T> withTransactionListMatching(TransactionRequest transactionRequest){
        return appendSearchCriteria(new SubQuerySearchCriteria(Account.ID_PROPERTY, transactionRequest, Transaction.ACCOUNT_PROPERTY));
    }

    public AccountRequest<T> withoutTransactionListMatching(TransactionRequest transactionRequest){
        return appendSearchCriteria(SearchCriteria.not(new SubQuerySearchCriteria(Account.ID_PROPERTY, transactionRequest, Transaction.ACCOUNT_PROPERTY)));
    }

    public AccountRequest<T> haveTransactions(){
        return withTransactionListMatching(Q.transactions().unlimited());
    }

    public AccountRequest<T> haveNoTransactions(){
        return withoutTransactionListMatching(Q.transactions().unlimited());
    }

    public AccountRequest<T> count(){
        super.count();
        return this;
    }
    public AccountRequest<T> countAs(String retName){
        super.count(retName);
        return this;
    }
    public AccountRequest minBalance(){
        return minBalanceAs(prefix("minOf",Account.BALANCE_PROPERTY));
    }

    public AccountRequest minBalanceAs(String retName){
        super.min(retName, Account.BALANCE_PROPERTY);
        return this;
    }
    public AccountRequest maxBalance(){
        return maxBalanceAs(prefix("maxOf",Account.BALANCE_PROPERTY));
    }

    public AccountRequest maxBalanceAs(String retName){
        super.max(retName, Account.BALANCE_PROPERTY);
        return this;
    }
    public AccountRequest sumBalance(){
        return sumBalanceAs(prefix("sumOf",Account.BALANCE_PROPERTY));
    }

    public AccountRequest sumBalanceAs(String retName){
        super.sum(retName, Account.BALANCE_PROPERTY);
        return this;
    }
    public AccountRequest avgBalance(){
        return avgBalanceAs(prefix("avgOf",Account.BALANCE_PROPERTY));
    }

    public AccountRequest avgBalanceAs(String retName){
        super.avg(retName, Account.BALANCE_PROPERTY);
        return this;
    }
    public AccountRequest standardDeviationBalance(){
        return standardDeviationBalanceAs(prefix("standardDeviationOf",Account.BALANCE_PROPERTY));
    }

    public AccountRequest standardDeviationBalanceAs(String retName){
        super.standardDeviation(retName, Account.BALANCE_PROPERTY);
        return this;
    }
    public AccountRequest squareRootOfPopulationStandardDeviationBalance(){
        return squareRootOfPopulationStandardDeviationBalanceAs(prefix("squareRootOfPopulationStandardDeviationOf",Account.BALANCE_PROPERTY));
    }

    public AccountRequest squareRootOfPopulationStandardDeviationBalanceAs(String retName){
        super.squareRootOfPopulationStandardDeviation(retName, Account.BALANCE_PROPERTY);
        return this;
    }
    public AccountRequest sampleVarianceBalance(){
        return sampleVarianceBalanceAs(prefix("sampleVarianceOf",Account.BALANCE_PROPERTY));
    }

    public AccountRequest sampleVarianceBalanceAs(String retName){
        super.sampleVariance(retName, Account.BALANCE_PROPERTY);
        return this;
    }
    public AccountRequest samplePopulationVarianceBalance(){
        return samplePopulationVarianceBalanceAs(prefix("samplePopulationVarianceOf",Account.BALANCE_PROPERTY));
    }

    public AccountRequest samplePopulationVarianceBalanceAs(String retName){
        super.samplePopulationVariance(retName, Account.BALANCE_PROPERTY);
        return this;
    }
    public AccountRequest<T> groupByTransactionsWithDetails(TransactionRequest subRequest){
       aggregate(Account.TRANSACTION_LIST_PROPERTY, subRequest);
       return this;
    }

    public AccountRequest<T> groupById(){
       groupBy(Account.ID_PROPERTY);
       return this;
    }

    public AccountRequest<T> groupByIdAs(String retName){
       groupBy(retName, Account.ID_PROPERTY);
       return this;
    }

    public AccountRequest<T> groupByIdWithFunction(String retName, AggrFunction function){
       groupBy(retName, Account.ID_PROPERTY, function);
       return this;
    }

    public AccountRequest<T> groupByName(){
       groupBy(Account.NAME_PROPERTY);
       return this;
    }

    public AccountRequest<T> groupByNameAs(String retName){
       groupBy(retName, Account.NAME_PROPERTY);
       return this;
    }

    public AccountRequest<T> groupByNameWithFunction(String retName, AggrFunction function){
       groupBy(retName, Account.NAME_PROPERTY, function);
       return this;
    }

    public AccountRequest<T> groupByAccountType(){
       groupBy(Account.ACCOUNT_TYPE_PROPERTY);
       return this;
    }

    public AccountRequest<T> groupByAccountTypeAs(String retName){
       groupBy(retName, Account.ACCOUNT_TYPE_PROPERTY);
       return this;
    }

    public AccountRequest<T> groupByAccountTypeWithFunction(String retName, AggrFunction function){
       groupBy(retName, Account.ACCOUNT_TYPE_PROPERTY, function);
       return this;
    }

    public AccountRequest<T> groupByBalance(){
       groupBy(Account.BALANCE_PROPERTY);
       return this;
    }

    public AccountRequest<T> groupByBalanceAs(String retName){
       groupBy(retName, Account.BALANCE_PROPERTY);
       return this;
    }

    public AccountRequest<T> groupByBalanceWithFunction(String retName, AggrFunction function){
       groupBy(retName, Account.BALANCE_PROPERTY, function);
       return this;
    }

    public AccountRequest<T> groupByCurrency(){
       groupBy(Account.CURRENCY_PROPERTY);
       return this;
    }

    public AccountRequest<T> groupByCurrencyAs(String retName){
       groupBy(retName, Account.CURRENCY_PROPERTY);
       return this;
    }

    public AccountRequest<T> groupByCurrencyWithFunction(String retName, AggrFunction function){
       groupBy(retName, Account.CURRENCY_PROPERTY, function);
       return this;
    }

    public AccountRequest<T> groupByCreateTime(){
       groupBy(Account.CREATE_TIME_PROPERTY);
       return this;
    }

    public AccountRequest<T> groupByCreateTimeAs(String retName){
       groupBy(retName, Account.CREATE_TIME_PROPERTY);
       return this;
    }

    public AccountRequest<T> groupByCreateTimeWithFunction(String retName, AggrFunction function){
       groupBy(retName, Account.CREATE_TIME_PROPERTY, function);
       return this;
    }

    public AccountRequest<T> groupByUpdateTime(){
       groupBy(Account.UPDATE_TIME_PROPERTY);
       return this;
    }

    public AccountRequest<T> groupByUpdateTimeAs(String retName){
       groupBy(retName, Account.UPDATE_TIME_PROPERTY);
       return this;
    }

    public AccountRequest<T> groupByUpdateTimeWithFunction(String retName, AggrFunction function){
       groupBy(retName, Account.UPDATE_TIME_PROPERTY, function);
       return this;
    }

    public AccountRequest<T> groupByVersion(){
       groupBy(Account.VERSION_PROPERTY);
       return this;
    }

    public AccountRequest<T> groupByVersionAs(String retName){
       groupBy(retName, Account.VERSION_PROPERTY);
       return this;
    }

    public AccountRequest<T> groupByVersionWithFunction(String retName, AggrFunction function){
       groupBy(retName, Account.VERSION_PROPERTY, function);
       return this;
    }



    public AccountRequest<T> orderByIdAscending(){
       addOrderByAscending(Account.ID_PROPERTY);
       return this;
    }

    public AccountRequest<T> orderByIdDescending(){
       addOrderByDescending(Account.ID_PROPERTY);
       return this;
    }

    public AccountRequest<T> orderByNameAscending(){
       addOrderByAscending(Account.NAME_PROPERTY);
       return this;
    }

    public AccountRequest<T> orderByNameDescending(){
       addOrderByDescending(Account.NAME_PROPERTY);
       return this;
    }
    public AccountRequest<T> orderByNameAscendingUsingGBK(){
       addOrderByAscendingUsingGBK(Account.NAME_PROPERTY);
       return this;
    }

    public AccountRequest<T> orderByNameDescendingUsingGBK(){
       addOrderByDescendingUsingGBK(Account.NAME_PROPERTY);
       return this;
    }
    public AccountRequest<T> orderByAccountTypeAscending(){
       addOrderByAscending(Account.ACCOUNT_TYPE_PROPERTY);
       return this;
    }

    public AccountRequest<T> orderByAccountTypeDescending(){
       addOrderByDescending(Account.ACCOUNT_TYPE_PROPERTY);
       return this;
    }
    public AccountRequest<T> orderByAccountTypeAscendingUsingGBK(){
       addOrderByAscendingUsingGBK(Account.ACCOUNT_TYPE_PROPERTY);
       return this;
    }

    public AccountRequest<T> orderByAccountTypeDescendingUsingGBK(){
       addOrderByDescendingUsingGBK(Account.ACCOUNT_TYPE_PROPERTY);
       return this;
    }
    public AccountRequest<T> orderByBalanceAscending(){
       addOrderByAscending(Account.BALANCE_PROPERTY);
       return this;
    }

    public AccountRequest<T> orderByBalanceDescending(){
       addOrderByDescending(Account.BALANCE_PROPERTY);
       return this;
    }

    public AccountRequest<T> orderByCurrencyAscending(){
       addOrderByAscending(Account.CURRENCY_PROPERTY);
       return this;
    }

    public AccountRequest<T> orderByCurrencyDescending(){
       addOrderByDescending(Account.CURRENCY_PROPERTY);
       return this;
    }
    public AccountRequest<T> orderByCurrencyAscendingUsingGBK(){
       addOrderByAscendingUsingGBK(Account.CURRENCY_PROPERTY);
       return this;
    }

    public AccountRequest<T> orderByCurrencyDescendingUsingGBK(){
       addOrderByDescendingUsingGBK(Account.CURRENCY_PROPERTY);
       return this;
    }
    public AccountRequest<T> orderByCreateTimeAscending(){
       addOrderByAscending(Account.CREATE_TIME_PROPERTY);
       return this;
    }

    public AccountRequest<T> orderByCreateTimeDescending(){
       addOrderByDescending(Account.CREATE_TIME_PROPERTY);
       return this;
    }

    public AccountRequest<T> orderByUpdateTimeAscending(){
       addOrderByAscending(Account.UPDATE_TIME_PROPERTY);
       return this;
    }

    public AccountRequest<T> orderByUpdateTimeDescending(){
       addOrderByDescending(Account.UPDATE_TIME_PROPERTY);
       return this;
    }

    public AccountRequest<T> orderByVersionAscending(){
       addOrderByAscending(Account.VERSION_PROPERTY);
       return this;
    }

    public AccountRequest<T> orderByVersionDescending(){
       addOrderByDescending(Account.VERSION_PROPERTY);
       return this;
    }


    public AccountRequest<T> statsFromTransactionsAs(String name, TransactionRequest subRequest){
       return statsFromTransactionsAs(name, subRequest, false);
    }

    public AccountRequest<T> statsFromTransactionsAs(String name, TransactionRequest subRequest, boolean singleResult){
       subRequest.setPartitionProperty(Transaction.ACCOUNT_PROPERTY);
       addAggregateDynamicProperty(name, subRequest, singleResult);
       return this;
    }

    public AccountRequest<T> statsFromTransactions(TransactionRequest subRequest){
       return statsFromTransactionsAs(REFINEMENTS, subRequest);
    }
    public AccountRequest<T> countTransactions(){
        return countTransactionsAs("Count");
    }

    public AccountRequest<T> countTransactionsAs(String name){
        return countTransactionsWith(name, Q.transactions().unlimited());
    }

    public AccountRequest<T> countTransactionsWith(String name, TransactionRequest subRequest){
        return statsFromTransactionsAs(name, subRequest.count(), true);
    }
    public AccountRequest<T> minAmountOfTransactions(){
        return minAmountOfTransactionsAs("minAmountOfTransactions");
    }

    public AccountRequest<T> minAmountOfTransactionsAs(String name){
        return minAmountOfTransactionsAs(name, Q.transactions().unlimited());
    }

    public AccountRequest<T> minAmountOfTransactionsAs(String name, TransactionRequest subRequest){
        return statsFromTransactionsAs(name, subRequest.minAmount(), true);
    }
    public AccountRequest<T> maxAmountOfTransactions(){
        return maxAmountOfTransactionsAs("maxAmountOfTransactions");
    }

    public AccountRequest<T> maxAmountOfTransactionsAs(String name){
        return maxAmountOfTransactionsAs(name, Q.transactions().unlimited());
    }

    public AccountRequest<T> maxAmountOfTransactionsAs(String name, TransactionRequest subRequest){
        return statsFromTransactionsAs(name, subRequest.maxAmount(), true);
    }
    public AccountRequest<T> sumAmountOfTransactions(){
        return sumAmountOfTransactionsAs("sumAmountOfTransactions");
    }

    public AccountRequest<T> sumAmountOfTransactionsAs(String name){
        return sumAmountOfTransactionsAs(name, Q.transactions().unlimited());
    }

    public AccountRequest<T> sumAmountOfTransactionsAs(String name, TransactionRequest subRequest){
        return statsFromTransactionsAs(name, subRequest.sumAmount(), true);
    }
    public AccountRequest<T> avgAmountOfTransactions(){
        return avgAmountOfTransactionsAs("avgAmountOfTransactions");
    }

    public AccountRequest<T> avgAmountOfTransactionsAs(String name){
        return avgAmountOfTransactionsAs(name, Q.transactions().unlimited());
    }

    public AccountRequest<T> avgAmountOfTransactionsAs(String name, TransactionRequest subRequest){
        return statsFromTransactionsAs(name, subRequest.avgAmount(), true);
    }
    public AccountRequest<T> standardDeviationAmountOfTransactions(){
        return standardDeviationAmountOfTransactionsAs("stdDevAmountOfTransactions");
    }

    public AccountRequest<T> standardDeviationAmountOfTransactionsAs(String name){
        return standardDeviationAmountOfTransactionsAs(name, Q.transactions().unlimited());
    }

    public AccountRequest<T> standardDeviationAmountOfTransactionsAs(String name, TransactionRequest subRequest){
        return statsFromTransactionsAs(name, subRequest.standardDeviationAmount(), true);
    }
    public AccountRequest<T> squareRootOfPopulationStandardDeviationAmountOfTransactions(){
        return squareRootOfPopulationStandardDeviationAmountOfTransactionsAs("stdDevPopAmountOfTransactions");
    }

    public AccountRequest<T> squareRootOfPopulationStandardDeviationAmountOfTransactionsAs(String name){
        return squareRootOfPopulationStandardDeviationAmountOfTransactionsAs(name, Q.transactions().unlimited());
    }

    public AccountRequest<T> squareRootOfPopulationStandardDeviationAmountOfTransactionsAs(String name, TransactionRequest subRequest){
        return statsFromTransactionsAs(name, subRequest.squareRootOfPopulationStandardDeviationAmount(), true);
    }
    public AccountRequest<T> sampleVarianceAmountOfTransactions(){
        return sampleVarianceAmountOfTransactionsAs("varSampAmountOfTransactions");
    }

    public AccountRequest<T> sampleVarianceAmountOfTransactionsAs(String name){
        return sampleVarianceAmountOfTransactionsAs(name, Q.transactions().unlimited());
    }

    public AccountRequest<T> sampleVarianceAmountOfTransactionsAs(String name, TransactionRequest subRequest){
        return statsFromTransactionsAs(name, subRequest.sampleVarianceAmount(), true);
    }
    public AccountRequest<T> samplePopulationVarianceAmountOfTransactions(){
        return samplePopulationVarianceAmountOfTransactionsAs("varPopAmountOfTransactions");
    }

    public AccountRequest<T> samplePopulationVarianceAmountOfTransactionsAs(String name){
        return samplePopulationVarianceAmountOfTransactionsAs(name, Q.transactions().unlimited());
    }

    public AccountRequest<T> samplePopulationVarianceAmountOfTransactionsAs(String name, TransactionRequest subRequest){
        return statsFromTransactionsAs(name, subRequest.samplePopulationVarianceAmount(), true);
    }



    /**
     * get topN records
     * @param topN  records number
     */
    public AccountRequest<T> top(int topN) {
        super.top(topN);
        return this;
    }

    /**
     * get records from offset(inclusive) to offset+size(exclusive)
     * @param offset record offset
     * @param size records number
     */
    public AccountRequest<T> offset(int offset, int size) {
        super.offset(offset, size);
        return this;
    }

    /**
     * retrieve all records
     */
    public AccountRequest<T> unlimited() {
        super.unlimited();
        return this;
    }

    /**
     * get records of one page
     * @param pageNumber page number(1-based)
     * @param pageSize page size
     */
    public AccountRequest<T> page(int pageNumber, int pageSize) {
        int offset = (pageNumber - 1) * pageSize;
        return offset(offset, pageSize);
   }

    /**
     * get records of one page, default page size is 10
     * @param pageNumber page number(1-based)
     */
    public AccountRequest<T> page(int pageNumber) {
        return page(pageNumber, 10);
   }
}