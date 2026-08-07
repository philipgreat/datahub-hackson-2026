
package com.example.enterpriseerpsystem.ledger;

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

public class LedgerRequest<T extends Ledger> extends BaseRequest<T> {

    /**
     * @deprecated AI agents and business code must use the generated Q facade
     *             instead of constructing request builders directly.
     */
    @Deprecated
    public LedgerRequest(Class<T> returnType){
        super(returnType);
        selectId();
        selectVersion();
    }

    public LedgerRequest<T> comment(String comment){
         super.internalComment(comment);
         return this;
    }

    // purpose() 继承自 BaseRequest，返回 ExecutableRequest（终结方法）

    public LedgerRequest<T> returnType(Class<? extends T> returnType){
        super.setReturnType(returnType);
        return this;
    }

    public LedgerRequest<T> enableAggregationCache(long cacheExpiredMillis){
        super.enableAggregationCache();
        super.aggregateCacheTime(cacheExpiredMillis);
        return this;
    }

    public LedgerRequest<T> enableAggregationCache(){
        return enableAggregationCache(0l);
    }


    public LedgerRequest<T> propagateAggregationCache(long cacheExpiredMillis){
        super.propagateAggregationCache(cacheExpiredMillis);
        return this;
    }

    public LedgerRequest<T> appendSearchCriteria(SearchCriteria searchCriteria){
        return (LedgerRequest<T>)super.appendSearchCriteria(searchCriteria);
    }

    public LedgerRequest<T> filter(String property1, Operator operator, String property2){
        return appendSearchCriteria(new TwoOperatorCriteria(operator, new PropertyReference(property1), new PropertyReference(property2)));
    }


    public LedgerRequest<T> matchingAnyOf(LedgerRequest ledger){
        super.internalMatchAny(ledger);
        return this;
    }

    public LedgerRequest<T> enhanceChildrenIfNeeded(){
        return this;
    }

    public LedgerRequest<T> withDeletedRows(){
        super.withDeletedRows();
        return this;
    }

    public LedgerRequest<T> deletedRowsOnly(){
        super.deletedRowsOnly();
        return this;
    }

    public LedgerRequest<T> selectSelf(){
        super.selectSelf();
        return selectId().selectCredit().selectDebit().selectEntryDate().selectTransactionIdOnly().selectCreateTime().selectUpdateTime().selectVersion();
    }

    public LedgerRequest<T> selectSelfFields(){
        return selectSelf();
    }

    public LedgerRequest<T> selectAll(){
        super.selectAll();
        return selectId().selectCredit().selectDebit().selectEntryDate().selectTransaction().selectCreateTime().selectUpdateTime().selectVersion();
    }

    public LedgerRequest<T> selectChildren(){
        super.selectAny();
        return selectId().selectCredit().selectDebit().selectEntryDate().selectTransaction().selectCreateTime().selectUpdateTime().selectVersion();
    }


    public LedgerRequest<T> selectId(){
       selectProperty(Ledger.ID_PROPERTY);
       return this;
    }

    /**
     * fill the id with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  id) to fetch id property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public LedgerRequest<T> unselectId(){
       unselectProperty(Ledger.ID_PROPERTY);
       return this;
    }
    public LedgerRequest<T> selectCredit(){
       selectProperty(Ledger.CREDIT_PROPERTY);
       return this;
    }

    /**
     * fill the credit with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  credit) to fetch credit property.
     * @param rawSqlSegment  customized rawSqlSegment
     */


    /**
     * fill the credit with customized aggrFunction, TEAQL uses ({aggrFunction}(credit) AS credit to fetch credit property.
     * @param aggrFunction  aggrFunction
     */
    public LedgerRequest<T> selectCredit(AggrFunction aggrFunction){
       selectProperty(Ledger.CREDIT_PROPERTY, aggrFunction);
       return this;
    }


    public LedgerRequest<T> unselectCredit(){
       unselectProperty(Ledger.CREDIT_PROPERTY);
       return this;
    }
    public LedgerRequest<T> selectDebit(){
       selectProperty(Ledger.DEBIT_PROPERTY);
       return this;
    }

    /**
     * fill the debit with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  debit) to fetch debit property.
     * @param rawSqlSegment  customized rawSqlSegment
     */


    /**
     * fill the debit with customized aggrFunction, TEAQL uses ({aggrFunction}(debit) AS debit to fetch debit property.
     * @param aggrFunction  aggrFunction
     */
    public LedgerRequest<T> selectDebit(AggrFunction aggrFunction){
       selectProperty(Ledger.DEBIT_PROPERTY, aggrFunction);
       return this;
    }


    public LedgerRequest<T> unselectDebit(){
       unselectProperty(Ledger.DEBIT_PROPERTY);
       return this;
    }
    public LedgerRequest<T> selectEntryDate(){
       selectProperty(Ledger.ENTRY_DATE_PROPERTY);
       return this;
    }

    /**
     * fill the entryDate with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  entryDate) to fetch entryDate property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public LedgerRequest<T> unselectEntryDate(){
       unselectProperty(Ledger.ENTRY_DATE_PROPERTY);
       return this;
    }
    public LedgerRequest<T> selectTransactionIdOnly(){
       selectProperty(Ledger.TRANSACTION_PROPERTY);
       return this;
    }

    public LedgerRequest<T> selectTransaction(){
        return selectTransactionWith(Q.transactions().unlimited().selectSelf());
    }

    public LedgerRequest<T> selectTransactionWith(TransactionRequest transaction){
       selectProperty(Ledger.TRANSACTION_PROPERTY);
       enhanceRelation(Ledger.TRANSACTION_PROPERTY, transaction);
       return this;
    }

    public LedgerRequest<T> unselectTransaction(){
       unselectProperty(Ledger.TRANSACTION_PROPERTY);
       return this;
    }
    public LedgerRequest<T> selectCreateTime(){
       selectProperty(Ledger.CREATE_TIME_PROPERTY);
       return this;
    }

    /**
     * fill the createTime with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  createTime) to fetch createTime property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public LedgerRequest<T> unselectCreateTime(){
       unselectProperty(Ledger.CREATE_TIME_PROPERTY);
       return this;
    }
    public LedgerRequest<T> selectUpdateTime(){
       selectProperty(Ledger.UPDATE_TIME_PROPERTY);
       return this;
    }

    /**
     * fill the updateTime with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  updateTime) to fetch updateTime property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public LedgerRequest<T> unselectUpdateTime(){
       unselectProperty(Ledger.UPDATE_TIME_PROPERTY);
       return this;
    }
    public LedgerRequest<T> selectVersion(){
       selectProperty(Ledger.VERSION_PROPERTY);
       return this;
    }

    /**
     * fill the version with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  version) to fetch version property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public LedgerRequest<T> unselectVersion(){
       unselectProperty(Ledger.VERSION_PROPERTY);
       return this;
    }

    public LedgerRequest<T> withId(Operator operator, Object... values){
       return appendSearchCriteria(createIdCriteria(operator, values));
    }

    public SearchCriteria createIdCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Ledger.ID_PROPERTY, operator, values);
    }

    public LedgerRequest<T> withIdIs(Long id){
       return withId(Operator.EQUAL, id);
    }
    public LedgerRequest<T> withIdIn(Long... id){
       return withId(Operator.EQUAL, (Object[])id);
    }



    public LedgerRequest<T> filterByCredit(BigDecimal... credit){
      if (credit == null || credit.length == 0) {
        throw new IllegalArgumentException("filterByCredit parameter credit cannot be empty");
      }
      return appendSearchCriteria(createCreditCriteria(Operator.EQUAL, (Object[])credit));
    }

    public LedgerRequest<T> withCredit(Operator operator, Object... values){
       return appendSearchCriteria(createCreditCriteria(operator, values));
    }

    public LedgerRequest<T> withCreditIsUnknown(){
       return withCredit(Operator.IS_NULL);
    }

    public LedgerRequest<T> withCreditIsKnown(){
       return withCredit(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createCreditCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Ledger.CREDIT_PROPERTY, operator, values);
    }

    public LedgerRequest<T> withCreditGreaterThan(BigDecimal credit){
       return withCredit(Operator.GREATER_THAN, credit);
    }

    public LedgerRequest<T> withCreditGreaterThanOrEqualTo(BigDecimal credit){
       return withCredit(Operator.GREATER_THAN_OR_EQUAL, credit);
    }

    public LedgerRequest<T> withCreditLessThan(BigDecimal credit){
       return withCredit(Operator.LESS_THAN, credit);
    }

    public LedgerRequest<T> withCreditLessThanOrEqualTo(BigDecimal credit){
       return withCredit(Operator.LESS_THAN_OR_EQUAL, credit);
    }

    public LedgerRequest<T> withCreditBetween(BigDecimal startOfCredit, BigDecimal endOfCredit){
       return withCredit(Operator.BETWEEN, startOfCredit, endOfCredit);
    }



    public LedgerRequest<T> filterByDebit(BigDecimal... debit){
      if (debit == null || debit.length == 0) {
        throw new IllegalArgumentException("filterByDebit parameter debit cannot be empty");
      }
      return appendSearchCriteria(createDebitCriteria(Operator.EQUAL, (Object[])debit));
    }

    public LedgerRequest<T> withDebit(Operator operator, Object... values){
       return appendSearchCriteria(createDebitCriteria(operator, values));
    }

    public LedgerRequest<T> withDebitIsUnknown(){
       return withDebit(Operator.IS_NULL);
    }

    public LedgerRequest<T> withDebitIsKnown(){
       return withDebit(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createDebitCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Ledger.DEBIT_PROPERTY, operator, values);
    }

    public LedgerRequest<T> withDebitGreaterThan(BigDecimal debit){
       return withDebit(Operator.GREATER_THAN, debit);
    }

    public LedgerRequest<T> withDebitGreaterThanOrEqualTo(BigDecimal debit){
       return withDebit(Operator.GREATER_THAN_OR_EQUAL, debit);
    }

    public LedgerRequest<T> withDebitLessThan(BigDecimal debit){
       return withDebit(Operator.LESS_THAN, debit);
    }

    public LedgerRequest<T> withDebitLessThanOrEqualTo(BigDecimal debit){
       return withDebit(Operator.LESS_THAN_OR_EQUAL, debit);
    }

    public LedgerRequest<T> withDebitBetween(BigDecimal startOfDebit, BigDecimal endOfDebit){
       return withDebit(Operator.BETWEEN, startOfDebit, endOfDebit);
    }



    public LedgerRequest<T> filterByEntryDate(LocalDateTime... entryDate){
      if (entryDate == null || entryDate.length == 0) {
        throw new IllegalArgumentException("filterByEntryDate parameter entryDate cannot be empty");
      }
      return appendSearchCriteria(createEntryDateCriteria(Operator.EQUAL, (Object[])entryDate));
    }

    public LedgerRequest<T> withEntryDate(Operator operator, Object... values){
       return appendSearchCriteria(createEntryDateCriteria(operator, values));
    }

    public LedgerRequest<T> withEntryDateIsUnknown(){
       return withEntryDate(Operator.IS_NULL);
    }

    public LedgerRequest<T> withEntryDateIsKnown(){
       return withEntryDate(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createEntryDateCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Ledger.ENTRY_DATE_PROPERTY, operator, values);
    }

    public LedgerRequest<T> withEntryDateGreaterThan(LocalDateTime entryDate){
       return withEntryDate(Operator.GREATER_THAN, entryDate);
    }

    public LedgerRequest<T> withEntryDateGreaterThanOrEqualTo(LocalDateTime entryDate){
       return withEntryDate(Operator.GREATER_THAN_OR_EQUAL, entryDate);
    }

    public LedgerRequest<T> withEntryDateLessThan(LocalDateTime entryDate){
       return withEntryDate(Operator.LESS_THAN, entryDate);
    }

    public LedgerRequest<T> withEntryDateLessThanOrEqualTo(LocalDateTime entryDate){
       return withEntryDate(Operator.LESS_THAN_OR_EQUAL, entryDate);
    }

    public LedgerRequest<T> withEntryDateBetween(LocalDateTime startOfEntryDate, LocalDateTime endOfEntryDate){
       return withEntryDate(Operator.BETWEEN, startOfEntryDate, endOfEntryDate);
    }
    public LedgerRequest<T> withEntryDateBefore(LocalDateTime entryDate){
       return withEntryDate(Operator.LESS_THAN, entryDate);
    }

    public LedgerRequest<T> withEntryDateBefore(Date entryDate){
       return withEntryDate(Operator.LESS_THAN, entryDate);
    }

    public LedgerRequest<T> withEntryDateAfter(LocalDateTime entryDate){
       return withEntryDate(Operator.GREATER_THAN, entryDate);
    }

    public LedgerRequest<T> withEntryDateAfter(Date entryDate){
       return withEntryDate(Operator.GREATER_THAN, entryDate);
    }

    public LedgerRequest<T> withEntryDateBetween(Date startOfEntryDate, Date endOfEntryDate){
       return withEntryDate(Operator.BETWEEN, startOfEntryDate, endOfEntryDate);
    }




    public LedgerRequest<T> filterByTransaction(Transaction... transaction){
      if (transaction == null || transaction.length == 0) {
        throw new IllegalArgumentException("filterByTransaction parameter transaction cannot be empty");
      }
      return appendSearchCriteria(createTransactionCriteria(Operator.EQUAL, (Object[])transaction));
    }

    public LedgerRequest<T> withTransaction(Operator operator, Object... values){
       return appendSearchCriteria(createTransactionCriteria(operator, values));
    }

    public LedgerRequest<T> withTransactionIsUnknown(){
       return withTransaction(Operator.IS_NULL);
    }

    public LedgerRequest<T> withTransactionIsKnown(){
       return withTransaction(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createTransactionCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Ledger.TRANSACTION_PROPERTY, operator, values);
    }

    public LedgerRequest<T> filterByTransaction(Long transaction){
      if(transaction == null){
         return this;
      }
      return withTransaction(Operator.EQUAL, transaction);
    }
    public LedgerRequest<T> withTransactionMatching(TransactionRequest transaction){
       return appendSearchCriteria(new SubQuerySearchCriteria(Ledger.TRANSACTION_PROPERTY, transaction, Transaction.ID_PROPERTY));
    }

    public LedgerRequest<T> filterByCreateTime(LocalDateTime... createTime){
      if (createTime == null || createTime.length == 0) {
        throw new IllegalArgumentException("filterByCreateTime parameter createTime cannot be empty");
      }
      return appendSearchCriteria(createCreateTimeCriteria(Operator.EQUAL, (Object[])createTime));
    }

    public LedgerRequest<T> withCreateTime(Operator operator, Object... values){
       return appendSearchCriteria(createCreateTimeCriteria(operator, values));
    }

    public LedgerRequest<T> withCreateTimeIsUnknown(){
       return withCreateTime(Operator.IS_NULL);
    }

    public LedgerRequest<T> withCreateTimeIsKnown(){
       return withCreateTime(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createCreateTimeCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Ledger.CREATE_TIME_PROPERTY, operator, values);
    }

    public LedgerRequest<T> withCreateTimeGreaterThan(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public LedgerRequest<T> withCreateTimeGreaterThanOrEqualTo(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN_OR_EQUAL, createTime);
    }

    public LedgerRequest<T> withCreateTimeLessThan(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public LedgerRequest<T> withCreateTimeLessThanOrEqualTo(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN_OR_EQUAL, createTime);
    }

    public LedgerRequest<T> withCreateTimeBetween(LocalDateTime startOfCreateTime, LocalDateTime endOfCreateTime){
       return withCreateTime(Operator.BETWEEN, startOfCreateTime, endOfCreateTime);
    }
    public LedgerRequest<T> withCreateTimeBefore(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public LedgerRequest<T> withCreateTimeBefore(Date createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public LedgerRequest<T> withCreateTimeAfter(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public LedgerRequest<T> withCreateTimeAfter(Date createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public LedgerRequest<T> withCreateTimeBetween(Date startOfCreateTime, Date endOfCreateTime){
       return withCreateTime(Operator.BETWEEN, startOfCreateTime, endOfCreateTime);
    }




    public LedgerRequest<T> filterByUpdateTime(LocalDateTime... updateTime){
      if (updateTime == null || updateTime.length == 0) {
        throw new IllegalArgumentException("filterByUpdateTime parameter updateTime cannot be empty");
      }
      return appendSearchCriteria(createUpdateTimeCriteria(Operator.EQUAL, (Object[])updateTime));
    }

    public LedgerRequest<T> withUpdateTime(Operator operator, Object... values){
       return appendSearchCriteria(createUpdateTimeCriteria(operator, values));
    }

    public LedgerRequest<T> withUpdateTimeIsUnknown(){
       return withUpdateTime(Operator.IS_NULL);
    }

    public LedgerRequest<T> withUpdateTimeIsKnown(){
       return withUpdateTime(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createUpdateTimeCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Ledger.UPDATE_TIME_PROPERTY, operator, values);
    }

    public LedgerRequest<T> withUpdateTimeGreaterThan(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public LedgerRequest<T> withUpdateTimeGreaterThanOrEqualTo(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN_OR_EQUAL, updateTime);
    }

    public LedgerRequest<T> withUpdateTimeLessThan(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public LedgerRequest<T> withUpdateTimeLessThanOrEqualTo(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN_OR_EQUAL, updateTime);
    }

    public LedgerRequest<T> withUpdateTimeBetween(LocalDateTime startOfUpdateTime, LocalDateTime endOfUpdateTime){
       return withUpdateTime(Operator.BETWEEN, startOfUpdateTime, endOfUpdateTime);
    }
    public LedgerRequest<T> withUpdateTimeBefore(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public LedgerRequest<T> withUpdateTimeBefore(Date updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public LedgerRequest<T> withUpdateTimeAfter(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public LedgerRequest<T> withUpdateTimeAfter(Date updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public LedgerRequest<T> withUpdateTimeBetween(Date startOfUpdateTime, Date endOfUpdateTime){
       return withUpdateTime(Operator.BETWEEN, startOfUpdateTime, endOfUpdateTime);
    }




    public LedgerRequest<T> filterByVersion(Long... version){
      if (version == null || version.length == 0) {
        throw new IllegalArgumentException("filterByVersion parameter version cannot be empty");
      }
      return appendSearchCriteria(createVersionCriteria(Operator.EQUAL, (Object[])version));
    }

    public LedgerRequest<T> withVersion(Operator operator, Object... values){
       return appendSearchCriteria(createVersionCriteria(operator, values));
    }

    public LedgerRequest<T> withVersionIsUnknown(){
       return withVersion(Operator.IS_NULL);
    }

    public LedgerRequest<T> withVersionIsKnown(){
       return withVersion(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createVersionCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Ledger.VERSION_PROPERTY, operator, values);
    }

    public LedgerRequest<T> withVersionGreaterThan(Long version){
       return withVersion(Operator.GREATER_THAN, version);
    }

    public LedgerRequest<T> withVersionGreaterThanOrEqualTo(Long version){
       return withVersion(Operator.GREATER_THAN_OR_EQUAL, version);
    }

    public LedgerRequest<T> withVersionLessThan(Long version){
       return withVersion(Operator.LESS_THAN, version);
    }

    public LedgerRequest<T> withVersionLessThanOrEqualTo(Long version){
       return withVersion(Operator.LESS_THAN_OR_EQUAL, version);
    }

    public LedgerRequest<T> withVersionBetween(Long startOfVersion, Long endOfVersion){
       return withVersion(Operator.BETWEEN, startOfVersion, endOfVersion);
    }


    public LedgerRequest<T> count(){
        super.count();
        return this;
    }
    public LedgerRequest<T> countAs(String retName){
        super.count(retName);
        return this;
    }
    public LedgerRequest minCredit(){
        return minCreditAs(prefix("minOf",Ledger.CREDIT_PROPERTY));
    }

    public LedgerRequest minCreditAs(String retName){
        super.min(retName, Ledger.CREDIT_PROPERTY);
        return this;
    }
    public LedgerRequest maxCredit(){
        return maxCreditAs(prefix("maxOf",Ledger.CREDIT_PROPERTY));
    }

    public LedgerRequest maxCreditAs(String retName){
        super.max(retName, Ledger.CREDIT_PROPERTY);
        return this;
    }
    public LedgerRequest sumCredit(){
        return sumCreditAs(prefix("sumOf",Ledger.CREDIT_PROPERTY));
    }

    public LedgerRequest sumCreditAs(String retName){
        super.sum(retName, Ledger.CREDIT_PROPERTY);
        return this;
    }
    public LedgerRequest avgCredit(){
        return avgCreditAs(prefix("avgOf",Ledger.CREDIT_PROPERTY));
    }

    public LedgerRequest avgCreditAs(String retName){
        super.avg(retName, Ledger.CREDIT_PROPERTY);
        return this;
    }
    public LedgerRequest standardDeviationCredit(){
        return standardDeviationCreditAs(prefix("standardDeviationOf",Ledger.CREDIT_PROPERTY));
    }

    public LedgerRequest standardDeviationCreditAs(String retName){
        super.standardDeviation(retName, Ledger.CREDIT_PROPERTY);
        return this;
    }
    public LedgerRequest squareRootOfPopulationStandardDeviationCredit(){
        return squareRootOfPopulationStandardDeviationCreditAs(prefix("squareRootOfPopulationStandardDeviationOf",Ledger.CREDIT_PROPERTY));
    }

    public LedgerRequest squareRootOfPopulationStandardDeviationCreditAs(String retName){
        super.squareRootOfPopulationStandardDeviation(retName, Ledger.CREDIT_PROPERTY);
        return this;
    }
    public LedgerRequest sampleVarianceCredit(){
        return sampleVarianceCreditAs(prefix("sampleVarianceOf",Ledger.CREDIT_PROPERTY));
    }

    public LedgerRequest sampleVarianceCreditAs(String retName){
        super.sampleVariance(retName, Ledger.CREDIT_PROPERTY);
        return this;
    }
    public LedgerRequest samplePopulationVarianceCredit(){
        return samplePopulationVarianceCreditAs(prefix("samplePopulationVarianceOf",Ledger.CREDIT_PROPERTY));
    }

    public LedgerRequest samplePopulationVarianceCreditAs(String retName){
        super.samplePopulationVariance(retName, Ledger.CREDIT_PROPERTY);
        return this;
    }
    public LedgerRequest minDebit(){
        return minDebitAs(prefix("minOf",Ledger.DEBIT_PROPERTY));
    }

    public LedgerRequest minDebitAs(String retName){
        super.min(retName, Ledger.DEBIT_PROPERTY);
        return this;
    }
    public LedgerRequest maxDebit(){
        return maxDebitAs(prefix("maxOf",Ledger.DEBIT_PROPERTY));
    }

    public LedgerRequest maxDebitAs(String retName){
        super.max(retName, Ledger.DEBIT_PROPERTY);
        return this;
    }
    public LedgerRequest sumDebit(){
        return sumDebitAs(prefix("sumOf",Ledger.DEBIT_PROPERTY));
    }

    public LedgerRequest sumDebitAs(String retName){
        super.sum(retName, Ledger.DEBIT_PROPERTY);
        return this;
    }
    public LedgerRequest avgDebit(){
        return avgDebitAs(prefix("avgOf",Ledger.DEBIT_PROPERTY));
    }

    public LedgerRequest avgDebitAs(String retName){
        super.avg(retName, Ledger.DEBIT_PROPERTY);
        return this;
    }
    public LedgerRequest standardDeviationDebit(){
        return standardDeviationDebitAs(prefix("standardDeviationOf",Ledger.DEBIT_PROPERTY));
    }

    public LedgerRequest standardDeviationDebitAs(String retName){
        super.standardDeviation(retName, Ledger.DEBIT_PROPERTY);
        return this;
    }
    public LedgerRequest squareRootOfPopulationStandardDeviationDebit(){
        return squareRootOfPopulationStandardDeviationDebitAs(prefix("squareRootOfPopulationStandardDeviationOf",Ledger.DEBIT_PROPERTY));
    }

    public LedgerRequest squareRootOfPopulationStandardDeviationDebitAs(String retName){
        super.squareRootOfPopulationStandardDeviation(retName, Ledger.DEBIT_PROPERTY);
        return this;
    }
    public LedgerRequest sampleVarianceDebit(){
        return sampleVarianceDebitAs(prefix("sampleVarianceOf",Ledger.DEBIT_PROPERTY));
    }

    public LedgerRequest sampleVarianceDebitAs(String retName){
        super.sampleVariance(retName, Ledger.DEBIT_PROPERTY);
        return this;
    }
    public LedgerRequest samplePopulationVarianceDebit(){
        return samplePopulationVarianceDebitAs(prefix("samplePopulationVarianceOf",Ledger.DEBIT_PROPERTY));
    }

    public LedgerRequest samplePopulationVarianceDebitAs(String retName){
        super.samplePopulationVariance(retName, Ledger.DEBIT_PROPERTY);
        return this;
    }
    public LedgerRequest<T> groupByTransactionWithDetails(){
       return groupByTransactionWithDetails(Q.transactions().unlimited());
    }

    public LedgerRequest<T> groupByTransactionWithDetails(TransactionRequest subRequest){
       aggregate(Ledger.TRANSACTION_PROPERTY, subRequest);
       return this;
    }





    public LedgerRequest<T> groupById(){
       groupBy(Ledger.ID_PROPERTY);
       return this;
    }

    public LedgerRequest<T> groupByIdAs(String retName){
       groupBy(retName, Ledger.ID_PROPERTY);
       return this;
    }

    public LedgerRequest<T> groupByIdWithFunction(String retName, AggrFunction function){
       groupBy(retName, Ledger.ID_PROPERTY, function);
       return this;
    }

    public LedgerRequest<T> groupByCredit(){
       groupBy(Ledger.CREDIT_PROPERTY);
       return this;
    }

    public LedgerRequest<T> groupByCreditAs(String retName){
       groupBy(retName, Ledger.CREDIT_PROPERTY);
       return this;
    }

    public LedgerRequest<T> groupByCreditWithFunction(String retName, AggrFunction function){
       groupBy(retName, Ledger.CREDIT_PROPERTY, function);
       return this;
    }

    public LedgerRequest<T> groupByDebit(){
       groupBy(Ledger.DEBIT_PROPERTY);
       return this;
    }

    public LedgerRequest<T> groupByDebitAs(String retName){
       groupBy(retName, Ledger.DEBIT_PROPERTY);
       return this;
    }

    public LedgerRequest<T> groupByDebitWithFunction(String retName, AggrFunction function){
       groupBy(retName, Ledger.DEBIT_PROPERTY, function);
       return this;
    }

    public LedgerRequest<T> groupByEntryDate(){
       groupBy(Ledger.ENTRY_DATE_PROPERTY);
       return this;
    }

    public LedgerRequest<T> groupByEntryDateAs(String retName){
       groupBy(retName, Ledger.ENTRY_DATE_PROPERTY);
       return this;
    }

    public LedgerRequest<T> groupByEntryDateWithFunction(String retName, AggrFunction function){
       groupBy(retName, Ledger.ENTRY_DATE_PROPERTY, function);
       return this;
    }
    public LedgerRequest<T> groupByTransactionWith(TransactionRequest subRequest){
       groupBy(Ledger.TRANSACTION_PROPERTY, subRequest);
       return this;
    }
    public LedgerRequest<T> groupByTransaction(){
       groupBy(Ledger.TRANSACTION_PROPERTY);
       return this;
    }

    public LedgerRequest<T> groupByTransactionAs(String retName){
       groupBy(retName, Ledger.TRANSACTION_PROPERTY);
       return this;
    }

    public LedgerRequest<T> groupByTransactionWithFunction(String retName, AggrFunction function){
       groupBy(retName, Ledger.TRANSACTION_PROPERTY, function);
       return this;
    }

    public LedgerRequest<T> groupByCreateTime(){
       groupBy(Ledger.CREATE_TIME_PROPERTY);
       return this;
    }

    public LedgerRequest<T> groupByCreateTimeAs(String retName){
       groupBy(retName, Ledger.CREATE_TIME_PROPERTY);
       return this;
    }

    public LedgerRequest<T> groupByCreateTimeWithFunction(String retName, AggrFunction function){
       groupBy(retName, Ledger.CREATE_TIME_PROPERTY, function);
       return this;
    }

    public LedgerRequest<T> groupByUpdateTime(){
       groupBy(Ledger.UPDATE_TIME_PROPERTY);
       return this;
    }

    public LedgerRequest<T> groupByUpdateTimeAs(String retName){
       groupBy(retName, Ledger.UPDATE_TIME_PROPERTY);
       return this;
    }

    public LedgerRequest<T> groupByUpdateTimeWithFunction(String retName, AggrFunction function){
       groupBy(retName, Ledger.UPDATE_TIME_PROPERTY, function);
       return this;
    }

    public LedgerRequest<T> groupByVersion(){
       groupBy(Ledger.VERSION_PROPERTY);
       return this;
    }

    public LedgerRequest<T> groupByVersionAs(String retName){
       groupBy(retName, Ledger.VERSION_PROPERTY);
       return this;
    }

    public LedgerRequest<T> groupByVersionWithFunction(String retName, AggrFunction function){
       groupBy(retName, Ledger.VERSION_PROPERTY, function);
       return this;
    }



    public LedgerRequest<T> orderByIdAscending(){
       addOrderByAscending(Ledger.ID_PROPERTY);
       return this;
    }

    public LedgerRequest<T> orderByIdDescending(){
       addOrderByDescending(Ledger.ID_PROPERTY);
       return this;
    }

    public LedgerRequest<T> orderByCreditAscending(){
       addOrderByAscending(Ledger.CREDIT_PROPERTY);
       return this;
    }

    public LedgerRequest<T> orderByCreditDescending(){
       addOrderByDescending(Ledger.CREDIT_PROPERTY);
       return this;
    }

    public LedgerRequest<T> orderByDebitAscending(){
       addOrderByAscending(Ledger.DEBIT_PROPERTY);
       return this;
    }

    public LedgerRequest<T> orderByDebitDescending(){
       addOrderByDescending(Ledger.DEBIT_PROPERTY);
       return this;
    }

    public LedgerRequest<T> orderByEntryDateAscending(){
       addOrderByAscending(Ledger.ENTRY_DATE_PROPERTY);
       return this;
    }

    public LedgerRequest<T> orderByEntryDateDescending(){
       addOrderByDescending(Ledger.ENTRY_DATE_PROPERTY);
       return this;
    }

    public LedgerRequest<T> orderByTransactionAscending(){
       addOrderByAscending(Ledger.TRANSACTION_PROPERTY);
       return this;
    }

    public LedgerRequest<T> orderByTransactionDescending(){
       addOrderByDescending(Ledger.TRANSACTION_PROPERTY);
       return this;
    }

    public LedgerRequest<T> orderByCreateTimeAscending(){
       addOrderByAscending(Ledger.CREATE_TIME_PROPERTY);
       return this;
    }

    public LedgerRequest<T> orderByCreateTimeDescending(){
       addOrderByDescending(Ledger.CREATE_TIME_PROPERTY);
       return this;
    }

    public LedgerRequest<T> orderByUpdateTimeAscending(){
       addOrderByAscending(Ledger.UPDATE_TIME_PROPERTY);
       return this;
    }

    public LedgerRequest<T> orderByUpdateTimeDescending(){
       addOrderByDescending(Ledger.UPDATE_TIME_PROPERTY);
       return this;
    }

    public LedgerRequest<T> orderByVersionAscending(){
       addOrderByAscending(Ledger.VERSION_PROPERTY);
       return this;
    }

    public LedgerRequest<T> orderByVersionDescending(){
       addOrderByDescending(Ledger.VERSION_PROPERTY);
       return this;
    }


    public TransactionRequest rollUpToTransaction(){
       TransactionRequest transaction = Q.transactions().unlimited();
       this.withTransactionMatching(transaction)
           .groupByTransactionWith(transaction);
       return transaction;
    }





   public LedgerRequest<T> facetByTransactionAs(String facetName, TransactionRequest transaction){
       return facetByTransactionAs(facetName, transaction, true);
   }

   public LedgerRequest<T> facetByTransactionAs(String facetName, TransactionRequest transaction, boolean includeAllFacets){
       addFacet(facetName, Ledger.TRANSACTION_PROPERTY, transaction, includeAllFacets);
       return this;
   }


    /**
     * get topN records
     * @param topN  records number
     */
    public LedgerRequest<T> top(int topN) {
        super.top(topN);
        return this;
    }

    /**
     * get records from offset(inclusive) to offset+size(exclusive)
     * @param offset record offset
     * @param size records number
     */
    public LedgerRequest<T> offset(int offset, int size) {
        super.offset(offset, size);
        return this;
    }

    /**
     * retrieve all records
     */
    public LedgerRequest<T> unlimited() {
        super.unlimited();
        return this;
    }

    /**
     * get records of one page
     * @param pageNumber page number(1-based)
     * @param pageSize page size
     */
    public LedgerRequest<T> page(int pageNumber, int pageSize) {
        int offset = (pageNumber - 1) * pageSize;
        return offset(offset, pageSize);
   }

    /**
     * get records of one page, default page size is 10
     * @param pageNumber page number(1-based)
     */
    public LedgerRequest<T> page(int pageNumber) {
        return page(pageNumber, 10);
   }
}