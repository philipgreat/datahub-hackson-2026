
package com.example.enterpriseerpsystem.transaction;

import com.example.enterpriseerpsystem.Q;
import com.example.enterpriseerpsystem.account.Account;
import com.example.enterpriseerpsystem.account.AccountRequest;
import com.example.enterpriseerpsystem.ledger.Ledger;
import com.example.enterpriseerpsystem.ledger.LedgerRequest;
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

public class TransactionRequest<T extends Transaction> extends BaseRequest<T> {

    /**
     * @deprecated AI agents and business code must use the generated Q facade
     *             instead of constructing request builders directly.
     */
    @Deprecated
    public TransactionRequest(Class<T> returnType){
        super(returnType);
        selectId();
        selectVersion();
    }

    public TransactionRequest<T> comment(String comment){
         super.internalComment(comment);
         return this;
    }

    // purpose() 继承自 BaseRequest，返回 ExecutableRequest（终结方法）

    public TransactionRequest<T> returnType(Class<? extends T> returnType){
        super.setReturnType(returnType);
        return this;
    }

    public TransactionRequest<T> enableAggregationCache(long cacheExpiredMillis){
        super.enableAggregationCache();
        super.aggregateCacheTime(cacheExpiredMillis);
        return this;
    }

    public TransactionRequest<T> enableAggregationCache(){
        return enableAggregationCache(0l);
    }


    public TransactionRequest<T> propagateAggregationCache(long cacheExpiredMillis){
        super.propagateAggregationCache(cacheExpiredMillis);
        return this;
    }

    public TransactionRequest<T> appendSearchCriteria(SearchCriteria searchCriteria){
        return (TransactionRequest<T>)super.appendSearchCriteria(searchCriteria);
    }

    public TransactionRequest<T> filter(String property1, Operator operator, String property2){
        return appendSearchCriteria(new TwoOperatorCriteria(operator, new PropertyReference(property1), new PropertyReference(property2)));
    }


    public TransactionRequest<T> matchingAnyOf(TransactionRequest transaction){
        super.internalMatchAny(transaction);
        return this;
    }

    public TransactionRequest<T> enhanceChildrenIfNeeded(){
        return this;
    }

    public TransactionRequest<T> withDeletedRows(){
        super.withDeletedRows();
        return this;
    }

    public TransactionRequest<T> deletedRowsOnly(){
        super.deletedRowsOnly();
        return this;
    }

    public TransactionRequest<T> selectSelf(){
        super.selectSelf();
        return selectId().selectAmount().selectAccountIdOnly().selectTimestamp().selectType().selectCreateTime().selectUpdateTime().selectVersion();
    }

    public TransactionRequest<T> selectSelfFields(){
        return selectSelf();
    }

    public TransactionRequest<T> selectAll(){
        super.selectAll();
        return selectId().selectAmount().selectAccount().selectTimestamp().selectType().selectCreateTime().selectUpdateTime().selectVersion();
    }

    public TransactionRequest<T> selectChildren(){
        super.selectAny();
        selectLedgerList();
        return selectId().selectAmount().selectAccount().selectTimestamp().selectType().selectCreateTime().selectUpdateTime().selectVersion();
    }


    public TransactionRequest<T> selectId(){
       selectProperty(Transaction.ID_PROPERTY);
       return this;
    }

    /**
     * fill the id with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  id) to fetch id property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public TransactionRequest<T> unselectId(){
       unselectProperty(Transaction.ID_PROPERTY);
       return this;
    }
    public TransactionRequest<T> selectAmount(){
       selectProperty(Transaction.AMOUNT_PROPERTY);
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
    public TransactionRequest<T> selectAmount(AggrFunction aggrFunction){
       selectProperty(Transaction.AMOUNT_PROPERTY, aggrFunction);
       return this;
    }


    public TransactionRequest<T> unselectAmount(){
       unselectProperty(Transaction.AMOUNT_PROPERTY);
       return this;
    }
    public TransactionRequest<T> selectAccountIdOnly(){
       selectProperty(Transaction.ACCOUNT_PROPERTY);
       return this;
    }

    public TransactionRequest<T> selectAccount(){
        return selectAccountWith(Q.accounts().unlimited().selectSelf());
    }

    public TransactionRequest<T> selectAccountWith(AccountRequest account){
       selectProperty(Transaction.ACCOUNT_PROPERTY);
       enhanceRelation(Transaction.ACCOUNT_PROPERTY, account);
       return this;
    }

    public TransactionRequest<T> unselectAccount(){
       unselectProperty(Transaction.ACCOUNT_PROPERTY);
       return this;
    }
    public TransactionRequest<T> selectTimestamp(){
       selectProperty(Transaction.TIMESTAMP_PROPERTY);
       return this;
    }

    /**
     * fill the timestamp with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  timestamp) to fetch timestamp property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public TransactionRequest<T> unselectTimestamp(){
       unselectProperty(Transaction.TIMESTAMP_PROPERTY);
       return this;
    }
    public TransactionRequest<T> selectType(){
       selectProperty(Transaction.TYPE_PROPERTY);
       return this;
    }

    /**
     * fill the type with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  type) to fetch type property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public TransactionRequest<T> unselectType(){
       unselectProperty(Transaction.TYPE_PROPERTY);
       return this;
    }
    public TransactionRequest<T> selectCreateTime(){
       selectProperty(Transaction.CREATE_TIME_PROPERTY);
       return this;
    }

    /**
     * fill the createTime with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  createTime) to fetch createTime property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public TransactionRequest<T> unselectCreateTime(){
       unselectProperty(Transaction.CREATE_TIME_PROPERTY);
       return this;
    }
    public TransactionRequest<T> selectUpdateTime(){
       selectProperty(Transaction.UPDATE_TIME_PROPERTY);
       return this;
    }

    /**
     * fill the updateTime with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  updateTime) to fetch updateTime property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public TransactionRequest<T> unselectUpdateTime(){
       unselectProperty(Transaction.UPDATE_TIME_PROPERTY);
       return this;
    }
    public TransactionRequest<T> selectVersion(){
       selectProperty(Transaction.VERSION_PROPERTY);
       return this;
    }

    /**
     * fill the version with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  version) to fetch version property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public TransactionRequest<T> unselectVersion(){
       unselectProperty(Transaction.VERSION_PROPERTY);
       return this;
    }
    public TransactionRequest<T> selectLedgerList(){
       return selectLedgerListWith(Q.ledgers().selectSelf());
    }

    public TransactionRequest<T> selectLedgerListWith(LedgerRequest ledgerList){
       enhanceRelation(Transaction.LEDGER_LIST_PROPERTY, ledgerList);
       return this;
    }

    public TransactionRequest<T> withId(Operator operator, Object... values){
       return appendSearchCriteria(createIdCriteria(operator, values));
    }

    public SearchCriteria createIdCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Transaction.ID_PROPERTY, operator, values);
    }

    public TransactionRequest<T> withIdIs(Long id){
       return withId(Operator.EQUAL, id);
    }
    public TransactionRequest<T> withIdIn(Long... id){
       return withId(Operator.EQUAL, (Object[])id);
    }



    public TransactionRequest<T> filterByAmount(BigDecimal... amount){
      if (amount == null || amount.length == 0) {
        throw new IllegalArgumentException("filterByAmount parameter amount cannot be empty");
      }
      return appendSearchCriteria(createAmountCriteria(Operator.EQUAL, (Object[])amount));
    }

    public TransactionRequest<T> withAmount(Operator operator, Object... values){
       return appendSearchCriteria(createAmountCriteria(operator, values));
    }

    public TransactionRequest<T> withAmountIsUnknown(){
       return withAmount(Operator.IS_NULL);
    }

    public TransactionRequest<T> withAmountIsKnown(){
       return withAmount(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createAmountCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Transaction.AMOUNT_PROPERTY, operator, values);
    }

    public TransactionRequest<T> withAmountGreaterThan(BigDecimal amount){
       return withAmount(Operator.GREATER_THAN, amount);
    }

    public TransactionRequest<T> withAmountGreaterThanOrEqualTo(BigDecimal amount){
       return withAmount(Operator.GREATER_THAN_OR_EQUAL, amount);
    }

    public TransactionRequest<T> withAmountLessThan(BigDecimal amount){
       return withAmount(Operator.LESS_THAN, amount);
    }

    public TransactionRequest<T> withAmountLessThanOrEqualTo(BigDecimal amount){
       return withAmount(Operator.LESS_THAN_OR_EQUAL, amount);
    }

    public TransactionRequest<T> withAmountBetween(BigDecimal startOfAmount, BigDecimal endOfAmount){
       return withAmount(Operator.BETWEEN, startOfAmount, endOfAmount);
    }



    public TransactionRequest<T> filterByAccount(Account... account){
      if (account == null || account.length == 0) {
        throw new IllegalArgumentException("filterByAccount parameter account cannot be empty");
      }
      return appendSearchCriteria(createAccountCriteria(Operator.EQUAL, (Object[])account));
    }

    public TransactionRequest<T> withAccount(Operator operator, Object... values){
       return appendSearchCriteria(createAccountCriteria(operator, values));
    }

    public TransactionRequest<T> withAccountIsUnknown(){
       return withAccount(Operator.IS_NULL);
    }

    public TransactionRequest<T> withAccountIsKnown(){
       return withAccount(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createAccountCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Transaction.ACCOUNT_PROPERTY, operator, values);
    }

    public TransactionRequest<T> filterByAccount(Long account){
      if(account == null){
         return this;
      }
      return withAccount(Operator.EQUAL, account);
    }
    public TransactionRequest<T> withAccountMatching(AccountRequest account){
       return appendSearchCriteria(new SubQuerySearchCriteria(Transaction.ACCOUNT_PROPERTY, account, Account.ID_PROPERTY));
    }

    public TransactionRequest<T> filterByTimestamp(LocalDateTime... timestamp){
      if (timestamp == null || timestamp.length == 0) {
        throw new IllegalArgumentException("filterByTimestamp parameter timestamp cannot be empty");
      }
      return appendSearchCriteria(createTimestampCriteria(Operator.EQUAL, (Object[])timestamp));
    }

    public TransactionRequest<T> withTimestamp(Operator operator, Object... values){
       return appendSearchCriteria(createTimestampCriteria(operator, values));
    }

    public TransactionRequest<T> withTimestampIsUnknown(){
       return withTimestamp(Operator.IS_NULL);
    }

    public TransactionRequest<T> withTimestampIsKnown(){
       return withTimestamp(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createTimestampCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Transaction.TIMESTAMP_PROPERTY, operator, values);
    }

    public TransactionRequest<T> withTimestampGreaterThan(LocalDateTime timestamp){
       return withTimestamp(Operator.GREATER_THAN, timestamp);
    }

    public TransactionRequest<T> withTimestampGreaterThanOrEqualTo(LocalDateTime timestamp){
       return withTimestamp(Operator.GREATER_THAN_OR_EQUAL, timestamp);
    }

    public TransactionRequest<T> withTimestampLessThan(LocalDateTime timestamp){
       return withTimestamp(Operator.LESS_THAN, timestamp);
    }

    public TransactionRequest<T> withTimestampLessThanOrEqualTo(LocalDateTime timestamp){
       return withTimestamp(Operator.LESS_THAN_OR_EQUAL, timestamp);
    }

    public TransactionRequest<T> withTimestampBetween(LocalDateTime startOfTimestamp, LocalDateTime endOfTimestamp){
       return withTimestamp(Operator.BETWEEN, startOfTimestamp, endOfTimestamp);
    }
    public TransactionRequest<T> withTimestampBefore(LocalDateTime timestamp){
       return withTimestamp(Operator.LESS_THAN, timestamp);
    }

    public TransactionRequest<T> withTimestampBefore(Date timestamp){
       return withTimestamp(Operator.LESS_THAN, timestamp);
    }

    public TransactionRequest<T> withTimestampAfter(LocalDateTime timestamp){
       return withTimestamp(Operator.GREATER_THAN, timestamp);
    }

    public TransactionRequest<T> withTimestampAfter(Date timestamp){
       return withTimestamp(Operator.GREATER_THAN, timestamp);
    }

    public TransactionRequest<T> withTimestampBetween(Date startOfTimestamp, Date endOfTimestamp){
       return withTimestamp(Operator.BETWEEN, startOfTimestamp, endOfTimestamp);
    }




    public TransactionRequest<T> filterByType(String... type){
      if (type == null || type.length == 0) {
        throw new IllegalArgumentException("filterByType parameter type cannot be empty");
      }
      return appendSearchCriteria(createTypeCriteria(Operator.EQUAL, (Object[])type));
    }

    public TransactionRequest<T> withType(Operator operator, Object... values){
       return appendSearchCriteria(createTypeCriteria(operator, values));
    }

    public TransactionRequest<T> withTypeIsUnknown(){
       return withType(Operator.IS_NULL);
    }

    public TransactionRequest<T> withTypeIsKnown(){
       return withType(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createTypeCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Transaction.TYPE_PROPERTY, operator, values);
    }

    public TransactionRequest<T> withTypeGreaterThan(String type){
       return withType(Operator.GREATER_THAN, type);
    }

    public TransactionRequest<T> withTypeGreaterThanOrEqualTo(String type){
       return withType(Operator.GREATER_THAN_OR_EQUAL, type);
    }

    public TransactionRequest<T> withTypeLessThan(String type){
       return withType(Operator.LESS_THAN, type);
    }

    public TransactionRequest<T> withTypeLessThanOrEqualTo(String type){
       return withType(Operator.LESS_THAN_OR_EQUAL, type);
    }

    public TransactionRequest<T> withTypeBetween(String startOfType, String endOfType){
       return withType(Operator.BETWEEN, startOfType, endOfType);
    }
    public TransactionRequest<T> withTypeStartingWith(String type){
       return withType(Operator.BEGIN_WITH, type);
    }
    public TransactionRequest<T> withTypeContaining(String type){
       return withType(Operator.CONTAIN, type);
    }

    public TransactionRequest<T> withTypeEndingWith(String type){
       return withType(Operator.END_WITH, type);
    }

    public TransactionRequest<T> withTypeIs(String type){
       return withType(Operator.EQUAL, type);
    }

    public TransactionRequest<T> withTypeSoundingLike(String type){
       return withType(Operator.SOUNDS_LIKE, type);
    }



    public TransactionRequest<T> filterByCreateTime(LocalDateTime... createTime){
      if (createTime == null || createTime.length == 0) {
        throw new IllegalArgumentException("filterByCreateTime parameter createTime cannot be empty");
      }
      return appendSearchCriteria(createCreateTimeCriteria(Operator.EQUAL, (Object[])createTime));
    }

    public TransactionRequest<T> withCreateTime(Operator operator, Object... values){
       return appendSearchCriteria(createCreateTimeCriteria(operator, values));
    }

    public TransactionRequest<T> withCreateTimeIsUnknown(){
       return withCreateTime(Operator.IS_NULL);
    }

    public TransactionRequest<T> withCreateTimeIsKnown(){
       return withCreateTime(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createCreateTimeCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Transaction.CREATE_TIME_PROPERTY, operator, values);
    }

    public TransactionRequest<T> withCreateTimeGreaterThan(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public TransactionRequest<T> withCreateTimeGreaterThanOrEqualTo(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN_OR_EQUAL, createTime);
    }

    public TransactionRequest<T> withCreateTimeLessThan(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public TransactionRequest<T> withCreateTimeLessThanOrEqualTo(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN_OR_EQUAL, createTime);
    }

    public TransactionRequest<T> withCreateTimeBetween(LocalDateTime startOfCreateTime, LocalDateTime endOfCreateTime){
       return withCreateTime(Operator.BETWEEN, startOfCreateTime, endOfCreateTime);
    }
    public TransactionRequest<T> withCreateTimeBefore(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public TransactionRequest<T> withCreateTimeBefore(Date createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public TransactionRequest<T> withCreateTimeAfter(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public TransactionRequest<T> withCreateTimeAfter(Date createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public TransactionRequest<T> withCreateTimeBetween(Date startOfCreateTime, Date endOfCreateTime){
       return withCreateTime(Operator.BETWEEN, startOfCreateTime, endOfCreateTime);
    }




    public TransactionRequest<T> filterByUpdateTime(LocalDateTime... updateTime){
      if (updateTime == null || updateTime.length == 0) {
        throw new IllegalArgumentException("filterByUpdateTime parameter updateTime cannot be empty");
      }
      return appendSearchCriteria(createUpdateTimeCriteria(Operator.EQUAL, (Object[])updateTime));
    }

    public TransactionRequest<T> withUpdateTime(Operator operator, Object... values){
       return appendSearchCriteria(createUpdateTimeCriteria(operator, values));
    }

    public TransactionRequest<T> withUpdateTimeIsUnknown(){
       return withUpdateTime(Operator.IS_NULL);
    }

    public TransactionRequest<T> withUpdateTimeIsKnown(){
       return withUpdateTime(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createUpdateTimeCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Transaction.UPDATE_TIME_PROPERTY, operator, values);
    }

    public TransactionRequest<T> withUpdateTimeGreaterThan(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public TransactionRequest<T> withUpdateTimeGreaterThanOrEqualTo(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN_OR_EQUAL, updateTime);
    }

    public TransactionRequest<T> withUpdateTimeLessThan(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public TransactionRequest<T> withUpdateTimeLessThanOrEqualTo(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN_OR_EQUAL, updateTime);
    }

    public TransactionRequest<T> withUpdateTimeBetween(LocalDateTime startOfUpdateTime, LocalDateTime endOfUpdateTime){
       return withUpdateTime(Operator.BETWEEN, startOfUpdateTime, endOfUpdateTime);
    }
    public TransactionRequest<T> withUpdateTimeBefore(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public TransactionRequest<T> withUpdateTimeBefore(Date updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public TransactionRequest<T> withUpdateTimeAfter(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public TransactionRequest<T> withUpdateTimeAfter(Date updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public TransactionRequest<T> withUpdateTimeBetween(Date startOfUpdateTime, Date endOfUpdateTime){
       return withUpdateTime(Operator.BETWEEN, startOfUpdateTime, endOfUpdateTime);
    }




    public TransactionRequest<T> filterByVersion(Long... version){
      if (version == null || version.length == 0) {
        throw new IllegalArgumentException("filterByVersion parameter version cannot be empty");
      }
      return appendSearchCriteria(createVersionCriteria(Operator.EQUAL, (Object[])version));
    }

    public TransactionRequest<T> withVersion(Operator operator, Object... values){
       return appendSearchCriteria(createVersionCriteria(operator, values));
    }

    public TransactionRequest<T> withVersionIsUnknown(){
       return withVersion(Operator.IS_NULL);
    }

    public TransactionRequest<T> withVersionIsKnown(){
       return withVersion(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createVersionCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Transaction.VERSION_PROPERTY, operator, values);
    }

    public TransactionRequest<T> withVersionGreaterThan(Long version){
       return withVersion(Operator.GREATER_THAN, version);
    }

    public TransactionRequest<T> withVersionGreaterThanOrEqualTo(Long version){
       return withVersion(Operator.GREATER_THAN_OR_EQUAL, version);
    }

    public TransactionRequest<T> withVersionLessThan(Long version){
       return withVersion(Operator.LESS_THAN, version);
    }

    public TransactionRequest<T> withVersionLessThanOrEqualTo(Long version){
       return withVersion(Operator.LESS_THAN_OR_EQUAL, version);
    }

    public TransactionRequest<T> withVersionBetween(Long startOfVersion, Long endOfVersion){
       return withVersion(Operator.BETWEEN, startOfVersion, endOfVersion);
    }

    public TransactionRequest<T> withLedgerListMatching(LedgerRequest ledgerRequest){
        return appendSearchCriteria(new SubQuerySearchCriteria(Transaction.ID_PROPERTY, ledgerRequest, Ledger.TRANSACTION_PROPERTY));
    }

    public TransactionRequest<T> withoutLedgerListMatching(LedgerRequest ledgerRequest){
        return appendSearchCriteria(SearchCriteria.not(new SubQuerySearchCriteria(Transaction.ID_PROPERTY, ledgerRequest, Ledger.TRANSACTION_PROPERTY)));
    }

    public TransactionRequest<T> haveLedgers(){
        return withLedgerListMatching(Q.ledgers().unlimited());
    }

    public TransactionRequest<T> haveNoLedgers(){
        return withoutLedgerListMatching(Q.ledgers().unlimited());
    }

    public TransactionRequest<T> count(){
        super.count();
        return this;
    }
    public TransactionRequest<T> countAs(String retName){
        super.count(retName);
        return this;
    }
    public TransactionRequest minAmount(){
        return minAmountAs(prefix("minOf",Transaction.AMOUNT_PROPERTY));
    }

    public TransactionRequest minAmountAs(String retName){
        super.min(retName, Transaction.AMOUNT_PROPERTY);
        return this;
    }
    public TransactionRequest maxAmount(){
        return maxAmountAs(prefix("maxOf",Transaction.AMOUNT_PROPERTY));
    }

    public TransactionRequest maxAmountAs(String retName){
        super.max(retName, Transaction.AMOUNT_PROPERTY);
        return this;
    }
    public TransactionRequest sumAmount(){
        return sumAmountAs(prefix("sumOf",Transaction.AMOUNT_PROPERTY));
    }

    public TransactionRequest sumAmountAs(String retName){
        super.sum(retName, Transaction.AMOUNT_PROPERTY);
        return this;
    }
    public TransactionRequest avgAmount(){
        return avgAmountAs(prefix("avgOf",Transaction.AMOUNT_PROPERTY));
    }

    public TransactionRequest avgAmountAs(String retName){
        super.avg(retName, Transaction.AMOUNT_PROPERTY);
        return this;
    }
    public TransactionRequest standardDeviationAmount(){
        return standardDeviationAmountAs(prefix("standardDeviationOf",Transaction.AMOUNT_PROPERTY));
    }

    public TransactionRequest standardDeviationAmountAs(String retName){
        super.standardDeviation(retName, Transaction.AMOUNT_PROPERTY);
        return this;
    }
    public TransactionRequest squareRootOfPopulationStandardDeviationAmount(){
        return squareRootOfPopulationStandardDeviationAmountAs(prefix("squareRootOfPopulationStandardDeviationOf",Transaction.AMOUNT_PROPERTY));
    }

    public TransactionRequest squareRootOfPopulationStandardDeviationAmountAs(String retName){
        super.squareRootOfPopulationStandardDeviation(retName, Transaction.AMOUNT_PROPERTY);
        return this;
    }
    public TransactionRequest sampleVarianceAmount(){
        return sampleVarianceAmountAs(prefix("sampleVarianceOf",Transaction.AMOUNT_PROPERTY));
    }

    public TransactionRequest sampleVarianceAmountAs(String retName){
        super.sampleVariance(retName, Transaction.AMOUNT_PROPERTY);
        return this;
    }
    public TransactionRequest samplePopulationVarianceAmount(){
        return samplePopulationVarianceAmountAs(prefix("samplePopulationVarianceOf",Transaction.AMOUNT_PROPERTY));
    }

    public TransactionRequest samplePopulationVarianceAmountAs(String retName){
        super.samplePopulationVariance(retName, Transaction.AMOUNT_PROPERTY);
        return this;
    }
    public TransactionRequest<T> groupByAccountWithDetails(){
       return groupByAccountWithDetails(Q.accounts().unlimited());
    }

    public TransactionRequest<T> groupByAccountWithDetails(AccountRequest subRequest){
       aggregate(Transaction.ACCOUNT_PROPERTY, subRequest);
       return this;
    }






    public TransactionRequest<T> groupByLedgersWithDetails(LedgerRequest subRequest){
       aggregate(Transaction.LEDGER_LIST_PROPERTY, subRequest);
       return this;
    }

    public TransactionRequest<T> groupById(){
       groupBy(Transaction.ID_PROPERTY);
       return this;
    }

    public TransactionRequest<T> groupByIdAs(String retName){
       groupBy(retName, Transaction.ID_PROPERTY);
       return this;
    }

    public TransactionRequest<T> groupByIdWithFunction(String retName, AggrFunction function){
       groupBy(retName, Transaction.ID_PROPERTY, function);
       return this;
    }

    public TransactionRequest<T> groupByAmount(){
       groupBy(Transaction.AMOUNT_PROPERTY);
       return this;
    }

    public TransactionRequest<T> groupByAmountAs(String retName){
       groupBy(retName, Transaction.AMOUNT_PROPERTY);
       return this;
    }

    public TransactionRequest<T> groupByAmountWithFunction(String retName, AggrFunction function){
       groupBy(retName, Transaction.AMOUNT_PROPERTY, function);
       return this;
    }
    public TransactionRequest<T> groupByAccountWith(AccountRequest subRequest){
       groupBy(Transaction.ACCOUNT_PROPERTY, subRequest);
       return this;
    }
    public TransactionRequest<T> groupByAccount(){
       groupBy(Transaction.ACCOUNT_PROPERTY);
       return this;
    }

    public TransactionRequest<T> groupByAccountAs(String retName){
       groupBy(retName, Transaction.ACCOUNT_PROPERTY);
       return this;
    }

    public TransactionRequest<T> groupByAccountWithFunction(String retName, AggrFunction function){
       groupBy(retName, Transaction.ACCOUNT_PROPERTY, function);
       return this;
    }

    public TransactionRequest<T> groupByTimestamp(){
       groupBy(Transaction.TIMESTAMP_PROPERTY);
       return this;
    }

    public TransactionRequest<T> groupByTimestampAs(String retName){
       groupBy(retName, Transaction.TIMESTAMP_PROPERTY);
       return this;
    }

    public TransactionRequest<T> groupByTimestampWithFunction(String retName, AggrFunction function){
       groupBy(retName, Transaction.TIMESTAMP_PROPERTY, function);
       return this;
    }

    public TransactionRequest<T> groupByType(){
       groupBy(Transaction.TYPE_PROPERTY);
       return this;
    }

    public TransactionRequest<T> groupByTypeAs(String retName){
       groupBy(retName, Transaction.TYPE_PROPERTY);
       return this;
    }

    public TransactionRequest<T> groupByTypeWithFunction(String retName, AggrFunction function){
       groupBy(retName, Transaction.TYPE_PROPERTY, function);
       return this;
    }

    public TransactionRequest<T> groupByCreateTime(){
       groupBy(Transaction.CREATE_TIME_PROPERTY);
       return this;
    }

    public TransactionRequest<T> groupByCreateTimeAs(String retName){
       groupBy(retName, Transaction.CREATE_TIME_PROPERTY);
       return this;
    }

    public TransactionRequest<T> groupByCreateTimeWithFunction(String retName, AggrFunction function){
       groupBy(retName, Transaction.CREATE_TIME_PROPERTY, function);
       return this;
    }

    public TransactionRequest<T> groupByUpdateTime(){
       groupBy(Transaction.UPDATE_TIME_PROPERTY);
       return this;
    }

    public TransactionRequest<T> groupByUpdateTimeAs(String retName){
       groupBy(retName, Transaction.UPDATE_TIME_PROPERTY);
       return this;
    }

    public TransactionRequest<T> groupByUpdateTimeWithFunction(String retName, AggrFunction function){
       groupBy(retName, Transaction.UPDATE_TIME_PROPERTY, function);
       return this;
    }

    public TransactionRequest<T> groupByVersion(){
       groupBy(Transaction.VERSION_PROPERTY);
       return this;
    }

    public TransactionRequest<T> groupByVersionAs(String retName){
       groupBy(retName, Transaction.VERSION_PROPERTY);
       return this;
    }

    public TransactionRequest<T> groupByVersionWithFunction(String retName, AggrFunction function){
       groupBy(retName, Transaction.VERSION_PROPERTY, function);
       return this;
    }



    public TransactionRequest<T> orderByIdAscending(){
       addOrderByAscending(Transaction.ID_PROPERTY);
       return this;
    }

    public TransactionRequest<T> orderByIdDescending(){
       addOrderByDescending(Transaction.ID_PROPERTY);
       return this;
    }

    public TransactionRequest<T> orderByAmountAscending(){
       addOrderByAscending(Transaction.AMOUNT_PROPERTY);
       return this;
    }

    public TransactionRequest<T> orderByAmountDescending(){
       addOrderByDescending(Transaction.AMOUNT_PROPERTY);
       return this;
    }

    public TransactionRequest<T> orderByAccountAscending(){
       addOrderByAscending(Transaction.ACCOUNT_PROPERTY);
       return this;
    }

    public TransactionRequest<T> orderByAccountDescending(){
       addOrderByDescending(Transaction.ACCOUNT_PROPERTY);
       return this;
    }

    public TransactionRequest<T> orderByTimestampAscending(){
       addOrderByAscending(Transaction.TIMESTAMP_PROPERTY);
       return this;
    }

    public TransactionRequest<T> orderByTimestampDescending(){
       addOrderByDescending(Transaction.TIMESTAMP_PROPERTY);
       return this;
    }

    public TransactionRequest<T> orderByTypeAscending(){
       addOrderByAscending(Transaction.TYPE_PROPERTY);
       return this;
    }

    public TransactionRequest<T> orderByTypeDescending(){
       addOrderByDescending(Transaction.TYPE_PROPERTY);
       return this;
    }
    public TransactionRequest<T> orderByTypeAscendingUsingGBK(){
       addOrderByAscendingUsingGBK(Transaction.TYPE_PROPERTY);
       return this;
    }

    public TransactionRequest<T> orderByTypeDescendingUsingGBK(){
       addOrderByDescendingUsingGBK(Transaction.TYPE_PROPERTY);
       return this;
    }
    public TransactionRequest<T> orderByCreateTimeAscending(){
       addOrderByAscending(Transaction.CREATE_TIME_PROPERTY);
       return this;
    }

    public TransactionRequest<T> orderByCreateTimeDescending(){
       addOrderByDescending(Transaction.CREATE_TIME_PROPERTY);
       return this;
    }

    public TransactionRequest<T> orderByUpdateTimeAscending(){
       addOrderByAscending(Transaction.UPDATE_TIME_PROPERTY);
       return this;
    }

    public TransactionRequest<T> orderByUpdateTimeDescending(){
       addOrderByDescending(Transaction.UPDATE_TIME_PROPERTY);
       return this;
    }

    public TransactionRequest<T> orderByVersionAscending(){
       addOrderByAscending(Transaction.VERSION_PROPERTY);
       return this;
    }

    public TransactionRequest<T> orderByVersionDescending(){
       addOrderByDescending(Transaction.VERSION_PROPERTY);
       return this;
    }


    public TransactionRequest<T> statsFromLedgersAs(String name, LedgerRequest subRequest){
       return statsFromLedgersAs(name, subRequest, false);
    }

    public TransactionRequest<T> statsFromLedgersAs(String name, LedgerRequest subRequest, boolean singleResult){
       subRequest.setPartitionProperty(Ledger.TRANSACTION_PROPERTY);
       addAggregateDynamicProperty(name, subRequest, singleResult);
       return this;
    }

    public TransactionRequest<T> statsFromLedgers(LedgerRequest subRequest){
       return statsFromLedgersAs(REFINEMENTS, subRequest);
    }
    public AccountRequest rollUpToAccount(){
       AccountRequest account = Q.accounts().unlimited();
       this.withAccountMatching(account)
           .groupByAccountWith(account);
       return account;
    }






    public TransactionRequest<T> countLedgers(){
        return countLedgersAs("Count");
    }

    public TransactionRequest<T> countLedgersAs(String name){
        return countLedgersWith(name, Q.ledgers().unlimited());
    }

    public TransactionRequest<T> countLedgersWith(String name, LedgerRequest subRequest){
        return statsFromLedgersAs(name, subRequest.count(), true);
    }
    public TransactionRequest<T> minCreditOfLedgers(){
        return minCreditOfLedgersAs("minCreditOfLedgers");
    }

    public TransactionRequest<T> minCreditOfLedgersAs(String name){
        return minCreditOfLedgersAs(name, Q.ledgers().unlimited());
    }

    public TransactionRequest<T> minCreditOfLedgersAs(String name, LedgerRequest subRequest){
        return statsFromLedgersAs(name, subRequest.minCredit(), true);
    }
    public TransactionRequest<T> maxCreditOfLedgers(){
        return maxCreditOfLedgersAs("maxCreditOfLedgers");
    }

    public TransactionRequest<T> maxCreditOfLedgersAs(String name){
        return maxCreditOfLedgersAs(name, Q.ledgers().unlimited());
    }

    public TransactionRequest<T> maxCreditOfLedgersAs(String name, LedgerRequest subRequest){
        return statsFromLedgersAs(name, subRequest.maxCredit(), true);
    }
    public TransactionRequest<T> sumCreditOfLedgers(){
        return sumCreditOfLedgersAs("sumCreditOfLedgers");
    }

    public TransactionRequest<T> sumCreditOfLedgersAs(String name){
        return sumCreditOfLedgersAs(name, Q.ledgers().unlimited());
    }

    public TransactionRequest<T> sumCreditOfLedgersAs(String name, LedgerRequest subRequest){
        return statsFromLedgersAs(name, subRequest.sumCredit(), true);
    }
    public TransactionRequest<T> avgCreditOfLedgers(){
        return avgCreditOfLedgersAs("avgCreditOfLedgers");
    }

    public TransactionRequest<T> avgCreditOfLedgersAs(String name){
        return avgCreditOfLedgersAs(name, Q.ledgers().unlimited());
    }

    public TransactionRequest<T> avgCreditOfLedgersAs(String name, LedgerRequest subRequest){
        return statsFromLedgersAs(name, subRequest.avgCredit(), true);
    }
    public TransactionRequest<T> standardDeviationCreditOfLedgers(){
        return standardDeviationCreditOfLedgersAs("stdDevCreditOfLedgers");
    }

    public TransactionRequest<T> standardDeviationCreditOfLedgersAs(String name){
        return standardDeviationCreditOfLedgersAs(name, Q.ledgers().unlimited());
    }

    public TransactionRequest<T> standardDeviationCreditOfLedgersAs(String name, LedgerRequest subRequest){
        return statsFromLedgersAs(name, subRequest.standardDeviationCredit(), true);
    }
    public TransactionRequest<T> squareRootOfPopulationStandardDeviationCreditOfLedgers(){
        return squareRootOfPopulationStandardDeviationCreditOfLedgersAs("stdDevPopCreditOfLedgers");
    }

    public TransactionRequest<T> squareRootOfPopulationStandardDeviationCreditOfLedgersAs(String name){
        return squareRootOfPopulationStandardDeviationCreditOfLedgersAs(name, Q.ledgers().unlimited());
    }

    public TransactionRequest<T> squareRootOfPopulationStandardDeviationCreditOfLedgersAs(String name, LedgerRequest subRequest){
        return statsFromLedgersAs(name, subRequest.squareRootOfPopulationStandardDeviationCredit(), true);
    }
    public TransactionRequest<T> sampleVarianceCreditOfLedgers(){
        return sampleVarianceCreditOfLedgersAs("varSampCreditOfLedgers");
    }

    public TransactionRequest<T> sampleVarianceCreditOfLedgersAs(String name){
        return sampleVarianceCreditOfLedgersAs(name, Q.ledgers().unlimited());
    }

    public TransactionRequest<T> sampleVarianceCreditOfLedgersAs(String name, LedgerRequest subRequest){
        return statsFromLedgersAs(name, subRequest.sampleVarianceCredit(), true);
    }
    public TransactionRequest<T> samplePopulationVarianceCreditOfLedgers(){
        return samplePopulationVarianceCreditOfLedgersAs("varPopCreditOfLedgers");
    }

    public TransactionRequest<T> samplePopulationVarianceCreditOfLedgersAs(String name){
        return samplePopulationVarianceCreditOfLedgersAs(name, Q.ledgers().unlimited());
    }

    public TransactionRequest<T> samplePopulationVarianceCreditOfLedgersAs(String name, LedgerRequest subRequest){
        return statsFromLedgersAs(name, subRequest.samplePopulationVarianceCredit(), true);
    }
    public TransactionRequest<T> minDebitOfLedgers(){
        return minDebitOfLedgersAs("minDebitOfLedgers");
    }

    public TransactionRequest<T> minDebitOfLedgersAs(String name){
        return minDebitOfLedgersAs(name, Q.ledgers().unlimited());
    }

    public TransactionRequest<T> minDebitOfLedgersAs(String name, LedgerRequest subRequest){
        return statsFromLedgersAs(name, subRequest.minDebit(), true);
    }
    public TransactionRequest<T> maxDebitOfLedgers(){
        return maxDebitOfLedgersAs("maxDebitOfLedgers");
    }

    public TransactionRequest<T> maxDebitOfLedgersAs(String name){
        return maxDebitOfLedgersAs(name, Q.ledgers().unlimited());
    }

    public TransactionRequest<T> maxDebitOfLedgersAs(String name, LedgerRequest subRequest){
        return statsFromLedgersAs(name, subRequest.maxDebit(), true);
    }
    public TransactionRequest<T> sumDebitOfLedgers(){
        return sumDebitOfLedgersAs("sumDebitOfLedgers");
    }

    public TransactionRequest<T> sumDebitOfLedgersAs(String name){
        return sumDebitOfLedgersAs(name, Q.ledgers().unlimited());
    }

    public TransactionRequest<T> sumDebitOfLedgersAs(String name, LedgerRequest subRequest){
        return statsFromLedgersAs(name, subRequest.sumDebit(), true);
    }
    public TransactionRequest<T> avgDebitOfLedgers(){
        return avgDebitOfLedgersAs("avgDebitOfLedgers");
    }

    public TransactionRequest<T> avgDebitOfLedgersAs(String name){
        return avgDebitOfLedgersAs(name, Q.ledgers().unlimited());
    }

    public TransactionRequest<T> avgDebitOfLedgersAs(String name, LedgerRequest subRequest){
        return statsFromLedgersAs(name, subRequest.avgDebit(), true);
    }
    public TransactionRequest<T> standardDeviationDebitOfLedgers(){
        return standardDeviationDebitOfLedgersAs("stdDevDebitOfLedgers");
    }

    public TransactionRequest<T> standardDeviationDebitOfLedgersAs(String name){
        return standardDeviationDebitOfLedgersAs(name, Q.ledgers().unlimited());
    }

    public TransactionRequest<T> standardDeviationDebitOfLedgersAs(String name, LedgerRequest subRequest){
        return statsFromLedgersAs(name, subRequest.standardDeviationDebit(), true);
    }
    public TransactionRequest<T> squareRootOfPopulationStandardDeviationDebitOfLedgers(){
        return squareRootOfPopulationStandardDeviationDebitOfLedgersAs("stdDevPopDebitOfLedgers");
    }

    public TransactionRequest<T> squareRootOfPopulationStandardDeviationDebitOfLedgersAs(String name){
        return squareRootOfPopulationStandardDeviationDebitOfLedgersAs(name, Q.ledgers().unlimited());
    }

    public TransactionRequest<T> squareRootOfPopulationStandardDeviationDebitOfLedgersAs(String name, LedgerRequest subRequest){
        return statsFromLedgersAs(name, subRequest.squareRootOfPopulationStandardDeviationDebit(), true);
    }
    public TransactionRequest<T> sampleVarianceDebitOfLedgers(){
        return sampleVarianceDebitOfLedgersAs("varSampDebitOfLedgers");
    }

    public TransactionRequest<T> sampleVarianceDebitOfLedgersAs(String name){
        return sampleVarianceDebitOfLedgersAs(name, Q.ledgers().unlimited());
    }

    public TransactionRequest<T> sampleVarianceDebitOfLedgersAs(String name, LedgerRequest subRequest){
        return statsFromLedgersAs(name, subRequest.sampleVarianceDebit(), true);
    }
    public TransactionRequest<T> samplePopulationVarianceDebitOfLedgers(){
        return samplePopulationVarianceDebitOfLedgersAs("varPopDebitOfLedgers");
    }

    public TransactionRequest<T> samplePopulationVarianceDebitOfLedgersAs(String name){
        return samplePopulationVarianceDebitOfLedgersAs(name, Q.ledgers().unlimited());
    }

    public TransactionRequest<T> samplePopulationVarianceDebitOfLedgersAs(String name, LedgerRequest subRequest){
        return statsFromLedgersAs(name, subRequest.samplePopulationVarianceDebit(), true);
    }

   public TransactionRequest<T> facetByAccountAs(String facetName, AccountRequest account){
       return facetByAccountAs(facetName, account, true);
   }

   public TransactionRequest<T> facetByAccountAs(String facetName, AccountRequest account, boolean includeAllFacets){
       addFacet(facetName, Transaction.ACCOUNT_PROPERTY, account, includeAllFacets);
       return this;
   }


    /**
     * get topN records
     * @param topN  records number
     */
    public TransactionRequest<T> top(int topN) {
        super.top(topN);
        return this;
    }

    /**
     * get records from offset(inclusive) to offset+size(exclusive)
     * @param offset record offset
     * @param size records number
     */
    public TransactionRequest<T> offset(int offset, int size) {
        super.offset(offset, size);
        return this;
    }

    /**
     * retrieve all records
     */
    public TransactionRequest<T> unlimited() {
        super.unlimited();
        return this;
    }

    /**
     * get records of one page
     * @param pageNumber page number(1-based)
     * @param pageSize page size
     */
    public TransactionRequest<T> page(int pageNumber, int pageSize) {
        int offset = (pageNumber - 1) * pageSize;
        return offset(offset, pageSize);
   }

    /**
     * get records of one page, default page size is 10
     * @param pageNumber page number(1-based)
     */
    public TransactionRequest<T> page(int pageNumber) {
        return page(pageNumber, 10);
   }
}