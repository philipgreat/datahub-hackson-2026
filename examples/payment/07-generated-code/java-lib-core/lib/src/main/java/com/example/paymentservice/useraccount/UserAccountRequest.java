
package com.example.paymentservice.useraccount;

import com.example.paymentservice.Q;
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

public class UserAccountRequest<T extends UserAccount> extends BaseRequest<T> {

    /**
     * @deprecated AI agents and business code must use the generated Q facade
     *             instead of constructing request builders directly.
     */
    @Deprecated
    public UserAccountRequest(Class<T> returnType){
        super(returnType);
        selectId();
        selectVersion();
    }

    public UserAccountRequest<T> comment(String comment){
         super.internalComment(comment);
         return this;
    }

    // purpose() 继承自 BaseRequest，返回 ExecutableRequest（终结方法）

    public UserAccountRequest<T> returnType(Class<? extends T> returnType){
        super.setReturnType(returnType);
        return this;
    }

    public UserAccountRequest<T> enableAggregationCache(long cacheExpiredMillis){
        super.enableAggregationCache();
        super.aggregateCacheTime(cacheExpiredMillis);
        return this;
    }

    public UserAccountRequest<T> enableAggregationCache(){
        return enableAggregationCache(0l);
    }


    public UserAccountRequest<T> propagateAggregationCache(long cacheExpiredMillis){
        super.propagateAggregationCache(cacheExpiredMillis);
        return this;
    }

    public UserAccountRequest<T> appendSearchCriteria(SearchCriteria searchCriteria){
        return (UserAccountRequest<T>)super.appendSearchCriteria(searchCriteria);
    }

    public UserAccountRequest<T> filter(String property1, Operator operator, String property2){
        return appendSearchCriteria(new TwoOperatorCriteria(operator, new PropertyReference(property1), new PropertyReference(property2)));
    }


    public UserAccountRequest<T> matchingAnyOf(UserAccountRequest userAccount){
        super.internalMatchAny(userAccount);
        return this;
    }

    public UserAccountRequest<T> enhanceChildrenIfNeeded(){
        return this;
    }

    public UserAccountRequest<T> withDeletedRows(){
        super.withDeletedRows();
        return this;
    }

    public UserAccountRequest<T> deletedRowsOnly(){
        super.deletedRowsOnly();
        return this;
    }

    public UserAccountRequest<T> selectSelf(){
        super.selectSelf();
        return selectId().selectUserName().selectCreateTime().selectUpdateTime().selectVersion();
    }

    public UserAccountRequest<T> selectSelfFields(){
        return selectSelf();
    }

    public UserAccountRequest<T> selectAll(){
        super.selectAll();
        return selectId().selectUserName().selectCreateTime().selectUpdateTime().selectVersion();
    }

    public UserAccountRequest<T> selectChildren(){
        super.selectAny();
        selectPaymentTransactionList();
        return selectId().selectUserName().selectCreateTime().selectUpdateTime().selectVersion();
    }


    public UserAccountRequest<T> selectId(){
       selectProperty(UserAccount.ID_PROPERTY);
       return this;
    }

    /**
     * fill the id with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  id) to fetch id property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public UserAccountRequest<T> unselectId(){
       unselectProperty(UserAccount.ID_PROPERTY);
       return this;
    }
    public UserAccountRequest<T> selectUserName(){
       selectProperty(UserAccount.USER_NAME_PROPERTY);
       return this;
    }

    /**
     * fill the userName with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  userName) to fetch userName property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public UserAccountRequest<T> unselectUserName(){
       unselectProperty(UserAccount.USER_NAME_PROPERTY);
       return this;
    }
    public UserAccountRequest<T> selectCreateTime(){
       selectProperty(UserAccount.CREATE_TIME_PROPERTY);
       return this;
    }

    /**
     * fill the createTime with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  createTime) to fetch createTime property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public UserAccountRequest<T> unselectCreateTime(){
       unselectProperty(UserAccount.CREATE_TIME_PROPERTY);
       return this;
    }
    public UserAccountRequest<T> selectUpdateTime(){
       selectProperty(UserAccount.UPDATE_TIME_PROPERTY);
       return this;
    }

    /**
     * fill the updateTime with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  updateTime) to fetch updateTime property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public UserAccountRequest<T> unselectUpdateTime(){
       unselectProperty(UserAccount.UPDATE_TIME_PROPERTY);
       return this;
    }
    public UserAccountRequest<T> selectVersion(){
       selectProperty(UserAccount.VERSION_PROPERTY);
       return this;
    }

    /**
     * fill the version with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  version) to fetch version property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public UserAccountRequest<T> unselectVersion(){
       unselectProperty(UserAccount.VERSION_PROPERTY);
       return this;
    }
    public UserAccountRequest<T> selectPaymentTransactionList(){
       return selectPaymentTransactionListWith(Q.paymentTransactions().selectSelf());
    }

    public UserAccountRequest<T> selectPaymentTransactionListWith(PaymentTransactionRequest paymentTransactionList){
       enhanceRelation(UserAccount.PAYMENT_TRANSACTION_LIST_PROPERTY, paymentTransactionList);
       return this;
    }

    public UserAccountRequest<T> withId(Operator operator, Object... values){
       return appendSearchCriteria(createIdCriteria(operator, values));
    }

    public SearchCriteria createIdCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(UserAccount.ID_PROPERTY, operator, values);
    }

    public UserAccountRequest<T> withIdIs(Long id){
       return withId(Operator.EQUAL, id);
    }
    public UserAccountRequest<T> withIdIn(Long... id){
       return withId(Operator.EQUAL, (Object[])id);
    }



    public UserAccountRequest<T> filterByUserName(String... userName){
      if (userName == null || userName.length == 0) {
        throw new IllegalArgumentException("filterByUserName parameter userName cannot be empty");
      }
      return appendSearchCriteria(createUserNameCriteria(Operator.EQUAL, (Object[])userName));
    }

    public UserAccountRequest<T> withUserName(Operator operator, Object... values){
       return appendSearchCriteria(createUserNameCriteria(operator, values));
    }

    public UserAccountRequest<T> withUserNameIsUnknown(){
       return withUserName(Operator.IS_NULL);
    }

    public UserAccountRequest<T> withUserNameIsKnown(){
       return withUserName(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createUserNameCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(UserAccount.USER_NAME_PROPERTY, operator, values);
    }

    public UserAccountRequest<T> withUserNameGreaterThan(String userName){
       return withUserName(Operator.GREATER_THAN, userName);
    }

    public UserAccountRequest<T> withUserNameGreaterThanOrEqualTo(String userName){
       return withUserName(Operator.GREATER_THAN_OR_EQUAL, userName);
    }

    public UserAccountRequest<T> withUserNameLessThan(String userName){
       return withUserName(Operator.LESS_THAN, userName);
    }

    public UserAccountRequest<T> withUserNameLessThanOrEqualTo(String userName){
       return withUserName(Operator.LESS_THAN_OR_EQUAL, userName);
    }

    public UserAccountRequest<T> withUserNameBetween(String startOfUserName, String endOfUserName){
       return withUserName(Operator.BETWEEN, startOfUserName, endOfUserName);
    }
    public UserAccountRequest<T> withUserNameStartingWith(String userName){
       return withUserName(Operator.BEGIN_WITH, userName);
    }
    public UserAccountRequest<T> withUserNameContaining(String userName){
       return withUserName(Operator.CONTAIN, userName);
    }

    public UserAccountRequest<T> withUserNameEndingWith(String userName){
       return withUserName(Operator.END_WITH, userName);
    }

    public UserAccountRequest<T> withUserNameIs(String userName){
       return withUserName(Operator.EQUAL, userName);
    }

    public UserAccountRequest<T> withUserNameSoundingLike(String userName){
       return withUserName(Operator.SOUNDS_LIKE, userName);
    }



    public UserAccountRequest<T> filterByCreateTime(LocalDateTime... createTime){
      if (createTime == null || createTime.length == 0) {
        throw new IllegalArgumentException("filterByCreateTime parameter createTime cannot be empty");
      }
      return appendSearchCriteria(createCreateTimeCriteria(Operator.EQUAL, (Object[])createTime));
    }

    public UserAccountRequest<T> withCreateTime(Operator operator, Object... values){
       return appendSearchCriteria(createCreateTimeCriteria(operator, values));
    }

    public UserAccountRequest<T> withCreateTimeIsUnknown(){
       return withCreateTime(Operator.IS_NULL);
    }

    public UserAccountRequest<T> withCreateTimeIsKnown(){
       return withCreateTime(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createCreateTimeCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(UserAccount.CREATE_TIME_PROPERTY, operator, values);
    }

    public UserAccountRequest<T> withCreateTimeGreaterThan(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public UserAccountRequest<T> withCreateTimeGreaterThanOrEqualTo(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN_OR_EQUAL, createTime);
    }

    public UserAccountRequest<T> withCreateTimeLessThan(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public UserAccountRequest<T> withCreateTimeLessThanOrEqualTo(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN_OR_EQUAL, createTime);
    }

    public UserAccountRequest<T> withCreateTimeBetween(LocalDateTime startOfCreateTime, LocalDateTime endOfCreateTime){
       return withCreateTime(Operator.BETWEEN, startOfCreateTime, endOfCreateTime);
    }
    public UserAccountRequest<T> withCreateTimeBefore(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public UserAccountRequest<T> withCreateTimeBefore(Date createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public UserAccountRequest<T> withCreateTimeAfter(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public UserAccountRequest<T> withCreateTimeAfter(Date createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public UserAccountRequest<T> withCreateTimeBetween(Date startOfCreateTime, Date endOfCreateTime){
       return withCreateTime(Operator.BETWEEN, startOfCreateTime, endOfCreateTime);
    }




    public UserAccountRequest<T> filterByUpdateTime(LocalDateTime... updateTime){
      if (updateTime == null || updateTime.length == 0) {
        throw new IllegalArgumentException("filterByUpdateTime parameter updateTime cannot be empty");
      }
      return appendSearchCriteria(createUpdateTimeCriteria(Operator.EQUAL, (Object[])updateTime));
    }

    public UserAccountRequest<T> withUpdateTime(Operator operator, Object... values){
       return appendSearchCriteria(createUpdateTimeCriteria(operator, values));
    }

    public UserAccountRequest<T> withUpdateTimeIsUnknown(){
       return withUpdateTime(Operator.IS_NULL);
    }

    public UserAccountRequest<T> withUpdateTimeIsKnown(){
       return withUpdateTime(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createUpdateTimeCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(UserAccount.UPDATE_TIME_PROPERTY, operator, values);
    }

    public UserAccountRequest<T> withUpdateTimeGreaterThan(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public UserAccountRequest<T> withUpdateTimeGreaterThanOrEqualTo(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN_OR_EQUAL, updateTime);
    }

    public UserAccountRequest<T> withUpdateTimeLessThan(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public UserAccountRequest<T> withUpdateTimeLessThanOrEqualTo(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN_OR_EQUAL, updateTime);
    }

    public UserAccountRequest<T> withUpdateTimeBetween(LocalDateTime startOfUpdateTime, LocalDateTime endOfUpdateTime){
       return withUpdateTime(Operator.BETWEEN, startOfUpdateTime, endOfUpdateTime);
    }
    public UserAccountRequest<T> withUpdateTimeBefore(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public UserAccountRequest<T> withUpdateTimeBefore(Date updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public UserAccountRequest<T> withUpdateTimeAfter(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public UserAccountRequest<T> withUpdateTimeAfter(Date updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public UserAccountRequest<T> withUpdateTimeBetween(Date startOfUpdateTime, Date endOfUpdateTime){
       return withUpdateTime(Operator.BETWEEN, startOfUpdateTime, endOfUpdateTime);
    }




    public UserAccountRequest<T> filterByVersion(Long... version){
      if (version == null || version.length == 0) {
        throw new IllegalArgumentException("filterByVersion parameter version cannot be empty");
      }
      return appendSearchCriteria(createVersionCriteria(Operator.EQUAL, (Object[])version));
    }

    public UserAccountRequest<T> withVersion(Operator operator, Object... values){
       return appendSearchCriteria(createVersionCriteria(operator, values));
    }

    public UserAccountRequest<T> withVersionIsUnknown(){
       return withVersion(Operator.IS_NULL);
    }

    public UserAccountRequest<T> withVersionIsKnown(){
       return withVersion(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createVersionCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(UserAccount.VERSION_PROPERTY, operator, values);
    }

    public UserAccountRequest<T> withVersionGreaterThan(Long version){
       return withVersion(Operator.GREATER_THAN, version);
    }

    public UserAccountRequest<T> withVersionGreaterThanOrEqualTo(Long version){
       return withVersion(Operator.GREATER_THAN_OR_EQUAL, version);
    }

    public UserAccountRequest<T> withVersionLessThan(Long version){
       return withVersion(Operator.LESS_THAN, version);
    }

    public UserAccountRequest<T> withVersionLessThanOrEqualTo(Long version){
       return withVersion(Operator.LESS_THAN_OR_EQUAL, version);
    }

    public UserAccountRequest<T> withVersionBetween(Long startOfVersion, Long endOfVersion){
       return withVersion(Operator.BETWEEN, startOfVersion, endOfVersion);
    }

    public UserAccountRequest<T> withPaymentTransactionListMatching(PaymentTransactionRequest paymentTransactionRequest){
        return appendSearchCriteria(new SubQuerySearchCriteria(UserAccount.ID_PROPERTY, paymentTransactionRequest, PaymentTransaction.PAYMENT_ACCOUNT_PROPERTY));
    }

    public UserAccountRequest<T> withoutPaymentTransactionListMatching(PaymentTransactionRequest paymentTransactionRequest){
        return appendSearchCriteria(SearchCriteria.not(new SubQuerySearchCriteria(UserAccount.ID_PROPERTY, paymentTransactionRequest, PaymentTransaction.PAYMENT_ACCOUNT_PROPERTY)));
    }

    public UserAccountRequest<T> havePaymentTransactions(){
        return withPaymentTransactionListMatching(Q.paymentTransactions().unlimited());
    }

    public UserAccountRequest<T> haveNoPaymentTransactions(){
        return withoutPaymentTransactionListMatching(Q.paymentTransactions().unlimited());
    }

    public UserAccountRequest<T> count(){
        super.count();
        return this;
    }
    public UserAccountRequest<T> countAs(String retName){
        super.count(retName);
        return this;
    }
    public UserAccountRequest<T> groupByPaymentTransactionsWithDetails(PaymentTransactionRequest subRequest){
       aggregate(UserAccount.PAYMENT_TRANSACTION_LIST_PROPERTY, subRequest);
       return this;
    }

    public UserAccountRequest<T> groupById(){
       groupBy(UserAccount.ID_PROPERTY);
       return this;
    }

    public UserAccountRequest<T> groupByIdAs(String retName){
       groupBy(retName, UserAccount.ID_PROPERTY);
       return this;
    }

    public UserAccountRequest<T> groupByIdWithFunction(String retName, AggrFunction function){
       groupBy(retName, UserAccount.ID_PROPERTY, function);
       return this;
    }

    public UserAccountRequest<T> groupByUserName(){
       groupBy(UserAccount.USER_NAME_PROPERTY);
       return this;
    }

    public UserAccountRequest<T> groupByUserNameAs(String retName){
       groupBy(retName, UserAccount.USER_NAME_PROPERTY);
       return this;
    }

    public UserAccountRequest<T> groupByUserNameWithFunction(String retName, AggrFunction function){
       groupBy(retName, UserAccount.USER_NAME_PROPERTY, function);
       return this;
    }

    public UserAccountRequest<T> groupByCreateTime(){
       groupBy(UserAccount.CREATE_TIME_PROPERTY);
       return this;
    }

    public UserAccountRequest<T> groupByCreateTimeAs(String retName){
       groupBy(retName, UserAccount.CREATE_TIME_PROPERTY);
       return this;
    }

    public UserAccountRequest<T> groupByCreateTimeWithFunction(String retName, AggrFunction function){
       groupBy(retName, UserAccount.CREATE_TIME_PROPERTY, function);
       return this;
    }

    public UserAccountRequest<T> groupByUpdateTime(){
       groupBy(UserAccount.UPDATE_TIME_PROPERTY);
       return this;
    }

    public UserAccountRequest<T> groupByUpdateTimeAs(String retName){
       groupBy(retName, UserAccount.UPDATE_TIME_PROPERTY);
       return this;
    }

    public UserAccountRequest<T> groupByUpdateTimeWithFunction(String retName, AggrFunction function){
       groupBy(retName, UserAccount.UPDATE_TIME_PROPERTY, function);
       return this;
    }

    public UserAccountRequest<T> groupByVersion(){
       groupBy(UserAccount.VERSION_PROPERTY);
       return this;
    }

    public UserAccountRequest<T> groupByVersionAs(String retName){
       groupBy(retName, UserAccount.VERSION_PROPERTY);
       return this;
    }

    public UserAccountRequest<T> groupByVersionWithFunction(String retName, AggrFunction function){
       groupBy(retName, UserAccount.VERSION_PROPERTY, function);
       return this;
    }



    public UserAccountRequest<T> orderByIdAscending(){
       addOrderByAscending(UserAccount.ID_PROPERTY);
       return this;
    }

    public UserAccountRequest<T> orderByIdDescending(){
       addOrderByDescending(UserAccount.ID_PROPERTY);
       return this;
    }

    public UserAccountRequest<T> orderByUserNameAscending(){
       addOrderByAscending(UserAccount.USER_NAME_PROPERTY);
       return this;
    }

    public UserAccountRequest<T> orderByUserNameDescending(){
       addOrderByDescending(UserAccount.USER_NAME_PROPERTY);
       return this;
    }
    public UserAccountRequest<T> orderByUserNameAscendingUsingGBK(){
       addOrderByAscendingUsingGBK(UserAccount.USER_NAME_PROPERTY);
       return this;
    }

    public UserAccountRequest<T> orderByUserNameDescendingUsingGBK(){
       addOrderByDescendingUsingGBK(UserAccount.USER_NAME_PROPERTY);
       return this;
    }
    public UserAccountRequest<T> orderByCreateTimeAscending(){
       addOrderByAscending(UserAccount.CREATE_TIME_PROPERTY);
       return this;
    }

    public UserAccountRequest<T> orderByCreateTimeDescending(){
       addOrderByDescending(UserAccount.CREATE_TIME_PROPERTY);
       return this;
    }

    public UserAccountRequest<T> orderByUpdateTimeAscending(){
       addOrderByAscending(UserAccount.UPDATE_TIME_PROPERTY);
       return this;
    }

    public UserAccountRequest<T> orderByUpdateTimeDescending(){
       addOrderByDescending(UserAccount.UPDATE_TIME_PROPERTY);
       return this;
    }

    public UserAccountRequest<T> orderByVersionAscending(){
       addOrderByAscending(UserAccount.VERSION_PROPERTY);
       return this;
    }

    public UserAccountRequest<T> orderByVersionDescending(){
       addOrderByDescending(UserAccount.VERSION_PROPERTY);
       return this;
    }


    public UserAccountRequest<T> statsFromPaymentTransactionsAs(String name, PaymentTransactionRequest subRequest){
       return statsFromPaymentTransactionsAs(name, subRequest, false);
    }

    public UserAccountRequest<T> statsFromPaymentTransactionsAs(String name, PaymentTransactionRequest subRequest, boolean singleResult){
       subRequest.setPartitionProperty(PaymentTransaction.PAYMENT_ACCOUNT_PROPERTY);
       addAggregateDynamicProperty(name, subRequest, singleResult);
       return this;
    }

    public UserAccountRequest<T> statsFromPaymentTransactions(PaymentTransactionRequest subRequest){
       return statsFromPaymentTransactionsAs(REFINEMENTS, subRequest);
    }
    public UserAccountRequest<T> countPaymentTransactions(){
        return countPaymentTransactionsAs("Count");
    }

    public UserAccountRequest<T> countPaymentTransactionsAs(String name){
        return countPaymentTransactionsWith(name, Q.paymentTransactions().unlimited());
    }

    public UserAccountRequest<T> countPaymentTransactionsWith(String name, PaymentTransactionRequest subRequest){
        return statsFromPaymentTransactionsAs(name, subRequest.count(), true);
    }
    public UserAccountRequest<T> minTransactionAmountOfPaymentTransactions(){
        return minTransactionAmountOfPaymentTransactionsAs("minTransactionAmountOfPaymentTransactions");
    }

    public UserAccountRequest<T> minTransactionAmountOfPaymentTransactionsAs(String name){
        return minTransactionAmountOfPaymentTransactionsAs(name, Q.paymentTransactions().unlimited());
    }

    public UserAccountRequest<T> minTransactionAmountOfPaymentTransactionsAs(String name, PaymentTransactionRequest subRequest){
        return statsFromPaymentTransactionsAs(name, subRequest.minTransactionAmount(), true);
    }
    public UserAccountRequest<T> maxTransactionAmountOfPaymentTransactions(){
        return maxTransactionAmountOfPaymentTransactionsAs("maxTransactionAmountOfPaymentTransactions");
    }

    public UserAccountRequest<T> maxTransactionAmountOfPaymentTransactionsAs(String name){
        return maxTransactionAmountOfPaymentTransactionsAs(name, Q.paymentTransactions().unlimited());
    }

    public UserAccountRequest<T> maxTransactionAmountOfPaymentTransactionsAs(String name, PaymentTransactionRequest subRequest){
        return statsFromPaymentTransactionsAs(name, subRequest.maxTransactionAmount(), true);
    }
    public UserAccountRequest<T> sumTransactionAmountOfPaymentTransactions(){
        return sumTransactionAmountOfPaymentTransactionsAs("sumTransactionAmountOfPaymentTransactions");
    }

    public UserAccountRequest<T> sumTransactionAmountOfPaymentTransactionsAs(String name){
        return sumTransactionAmountOfPaymentTransactionsAs(name, Q.paymentTransactions().unlimited());
    }

    public UserAccountRequest<T> sumTransactionAmountOfPaymentTransactionsAs(String name, PaymentTransactionRequest subRequest){
        return statsFromPaymentTransactionsAs(name, subRequest.sumTransactionAmount(), true);
    }
    public UserAccountRequest<T> avgTransactionAmountOfPaymentTransactions(){
        return avgTransactionAmountOfPaymentTransactionsAs("avgTransactionAmountOfPaymentTransactions");
    }

    public UserAccountRequest<T> avgTransactionAmountOfPaymentTransactionsAs(String name){
        return avgTransactionAmountOfPaymentTransactionsAs(name, Q.paymentTransactions().unlimited());
    }

    public UserAccountRequest<T> avgTransactionAmountOfPaymentTransactionsAs(String name, PaymentTransactionRequest subRequest){
        return statsFromPaymentTransactionsAs(name, subRequest.avgTransactionAmount(), true);
    }
    public UserAccountRequest<T> standardDeviationTransactionAmountOfPaymentTransactions(){
        return standardDeviationTransactionAmountOfPaymentTransactionsAs("stdDevTransactionAmountOfPaymentTransactions");
    }

    public UserAccountRequest<T> standardDeviationTransactionAmountOfPaymentTransactionsAs(String name){
        return standardDeviationTransactionAmountOfPaymentTransactionsAs(name, Q.paymentTransactions().unlimited());
    }

    public UserAccountRequest<T> standardDeviationTransactionAmountOfPaymentTransactionsAs(String name, PaymentTransactionRequest subRequest){
        return statsFromPaymentTransactionsAs(name, subRequest.standardDeviationTransactionAmount(), true);
    }
    public UserAccountRequest<T> squareRootOfPopulationStandardDeviationTransactionAmountOfPaymentTransactions(){
        return squareRootOfPopulationStandardDeviationTransactionAmountOfPaymentTransactionsAs("stdDevPopTransactionAmountOfPaymentTransactions");
    }

    public UserAccountRequest<T> squareRootOfPopulationStandardDeviationTransactionAmountOfPaymentTransactionsAs(String name){
        return squareRootOfPopulationStandardDeviationTransactionAmountOfPaymentTransactionsAs(name, Q.paymentTransactions().unlimited());
    }

    public UserAccountRequest<T> squareRootOfPopulationStandardDeviationTransactionAmountOfPaymentTransactionsAs(String name, PaymentTransactionRequest subRequest){
        return statsFromPaymentTransactionsAs(name, subRequest.squareRootOfPopulationStandardDeviationTransactionAmount(), true);
    }
    public UserAccountRequest<T> sampleVarianceTransactionAmountOfPaymentTransactions(){
        return sampleVarianceTransactionAmountOfPaymentTransactionsAs("varSampTransactionAmountOfPaymentTransactions");
    }

    public UserAccountRequest<T> sampleVarianceTransactionAmountOfPaymentTransactionsAs(String name){
        return sampleVarianceTransactionAmountOfPaymentTransactionsAs(name, Q.paymentTransactions().unlimited());
    }

    public UserAccountRequest<T> sampleVarianceTransactionAmountOfPaymentTransactionsAs(String name, PaymentTransactionRequest subRequest){
        return statsFromPaymentTransactionsAs(name, subRequest.sampleVarianceTransactionAmount(), true);
    }
    public UserAccountRequest<T> samplePopulationVarianceTransactionAmountOfPaymentTransactions(){
        return samplePopulationVarianceTransactionAmountOfPaymentTransactionsAs("varPopTransactionAmountOfPaymentTransactions");
    }

    public UserAccountRequest<T> samplePopulationVarianceTransactionAmountOfPaymentTransactionsAs(String name){
        return samplePopulationVarianceTransactionAmountOfPaymentTransactionsAs(name, Q.paymentTransactions().unlimited());
    }

    public UserAccountRequest<T> samplePopulationVarianceTransactionAmountOfPaymentTransactionsAs(String name, PaymentTransactionRequest subRequest){
        return statsFromPaymentTransactionsAs(name, subRequest.samplePopulationVarianceTransactionAmount(), true);
    }



    /**
     * get topN records
     * @param topN  records number
     */
    public UserAccountRequest<T> top(int topN) {
        super.top(topN);
        return this;
    }

    /**
     * get records from offset(inclusive) to offset+size(exclusive)
     * @param offset record offset
     * @param size records number
     */
    public UserAccountRequest<T> offset(int offset, int size) {
        super.offset(offset, size);
        return this;
    }

    /**
     * retrieve all records
     */
    public UserAccountRequest<T> unlimited() {
        super.unlimited();
        return this;
    }

    /**
     * get records of one page
     * @param pageNumber page number(1-based)
     * @param pageSize page size
     */
    public UserAccountRequest<T> page(int pageNumber, int pageSize) {
        int offset = (pageNumber - 1) * pageSize;
        return offset(offset, pageSize);
   }

    /**
     * get records of one page, default page size is 10
     * @param pageNumber page number(1-based)
     */
    public UserAccountRequest<T> page(int pageNumber) {
        return page(pageNumber, 10);
   }
}