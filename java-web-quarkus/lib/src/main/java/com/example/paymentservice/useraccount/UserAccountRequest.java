
package com.example.paymentservice.useraccount;

import com.example.paymentservice.Q;
import com.example.paymentservice.paymentaccount.PaymentAccount;
import com.example.paymentservice.paymentaccount.PaymentAccountRequest;
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
        return selectId().selectUserId().selectUserName().selectCreateTime().selectUpdateTime().selectVersion();
    }

    public UserAccountRequest<T> selectSelfFields(){
        return selectSelf();
    }

    public UserAccountRequest<T> selectAll(){
        super.selectAll();
        return selectId().selectUserId().selectUserName().selectCreateTime().selectUpdateTime().selectVersion();
    }

    public UserAccountRequest<T> selectChildren(){
        super.selectAny();
        selectPaymentAccountList();
        return selectId().selectUserId().selectUserName().selectCreateTime().selectUpdateTime().selectVersion();
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
    public UserAccountRequest<T> selectUserId(){
       selectProperty(UserAccount.USER_ID_PROPERTY);
       return this;
    }

    /**
     * fill the userId with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  userId) to fetch userId property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public UserAccountRequest<T> unselectUserId(){
       unselectProperty(UserAccount.USER_ID_PROPERTY);
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
    public UserAccountRequest<T> selectPaymentAccountList(){
       return selectPaymentAccountListWith(Q.paymentAccounts().selectSelf());
    }

    public UserAccountRequest<T> selectPaymentAccountListWith(PaymentAccountRequest paymentAccountList){
       enhanceRelation(UserAccount.PAYMENT_ACCOUNT_LIST_PROPERTY, paymentAccountList);
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



    public UserAccountRequest<T> filterByUserId(String... userId){
      if (userId == null || userId.length == 0) {
        throw new IllegalArgumentException("filterByUserId parameter userId cannot be empty");
      }
      return appendSearchCriteria(createUserIdCriteria(Operator.EQUAL, (Object[])userId));
    }

    public UserAccountRequest<T> withUserId(Operator operator, Object... values){
       return appendSearchCriteria(createUserIdCriteria(operator, values));
    }

    public UserAccountRequest<T> withUserIdIsUnknown(){
       return withUserId(Operator.IS_NULL);
    }

    public UserAccountRequest<T> withUserIdIsKnown(){
       return withUserId(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createUserIdCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(UserAccount.USER_ID_PROPERTY, operator, values);
    }

    public UserAccountRequest<T> withUserIdGreaterThan(String userId){
       return withUserId(Operator.GREATER_THAN, userId);
    }

    public UserAccountRequest<T> withUserIdGreaterThanOrEqualTo(String userId){
       return withUserId(Operator.GREATER_THAN_OR_EQUAL, userId);
    }

    public UserAccountRequest<T> withUserIdLessThan(String userId){
       return withUserId(Operator.LESS_THAN, userId);
    }

    public UserAccountRequest<T> withUserIdLessThanOrEqualTo(String userId){
       return withUserId(Operator.LESS_THAN_OR_EQUAL, userId);
    }

    public UserAccountRequest<T> withUserIdBetween(String startOfUserId, String endOfUserId){
       return withUserId(Operator.BETWEEN, startOfUserId, endOfUserId);
    }
    public UserAccountRequest<T> withUserIdStartingWith(String userId){
       return withUserId(Operator.BEGIN_WITH, userId);
    }
    public UserAccountRequest<T> withUserIdContaining(String userId){
       return withUserId(Operator.CONTAIN, userId);
    }

    public UserAccountRequest<T> withUserIdEndingWith(String userId){
       return withUserId(Operator.END_WITH, userId);
    }

    public UserAccountRequest<T> withUserIdIs(String userId){
       return withUserId(Operator.EQUAL, userId);
    }

    public UserAccountRequest<T> withUserIdSoundingLike(String userId){
       return withUserId(Operator.SOUNDS_LIKE, userId);
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

    public UserAccountRequest<T> withPaymentAccountListMatching(PaymentAccountRequest paymentAccountRequest){
        return appendSearchCriteria(new SubQuerySearchCriteria(UserAccount.ID_PROPERTY, paymentAccountRequest, PaymentAccount.USER_ACCOUNT_PROPERTY));
    }

    public UserAccountRequest<T> withoutPaymentAccountListMatching(PaymentAccountRequest paymentAccountRequest){
        return appendSearchCriteria(SearchCriteria.not(new SubQuerySearchCriteria(UserAccount.ID_PROPERTY, paymentAccountRequest, PaymentAccount.USER_ACCOUNT_PROPERTY)));
    }

    public UserAccountRequest<T> havePaymentAccounts(){
        return withPaymentAccountListMatching(Q.paymentAccounts().unlimited());
    }

    public UserAccountRequest<T> haveNoPaymentAccounts(){
        return withoutPaymentAccountListMatching(Q.paymentAccounts().unlimited());
    }

    public UserAccountRequest<T> count(){
        super.count();
        return this;
    }
    public UserAccountRequest<T> countAs(String retName){
        super.count(retName);
        return this;
    }
    public UserAccountRequest<T> groupByPaymentAccountsWithDetails(PaymentAccountRequest subRequest){
       aggregate(UserAccount.PAYMENT_ACCOUNT_LIST_PROPERTY, subRequest);
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

    public UserAccountRequest<T> groupByUserId(){
       groupBy(UserAccount.USER_ID_PROPERTY);
       return this;
    }

    public UserAccountRequest<T> groupByUserIdAs(String retName){
       groupBy(retName, UserAccount.USER_ID_PROPERTY);
       return this;
    }

    public UserAccountRequest<T> groupByUserIdWithFunction(String retName, AggrFunction function){
       groupBy(retName, UserAccount.USER_ID_PROPERTY, function);
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

    public UserAccountRequest<T> orderByUserIdAscending(){
       addOrderByAscending(UserAccount.USER_ID_PROPERTY);
       return this;
    }

    public UserAccountRequest<T> orderByUserIdDescending(){
       addOrderByDescending(UserAccount.USER_ID_PROPERTY);
       return this;
    }
    public UserAccountRequest<T> orderByUserIdAscendingUsingGBK(){
       addOrderByAscendingUsingGBK(UserAccount.USER_ID_PROPERTY);
       return this;
    }

    public UserAccountRequest<T> orderByUserIdDescendingUsingGBK(){
       addOrderByDescendingUsingGBK(UserAccount.USER_ID_PROPERTY);
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


    public UserAccountRequest<T> statsFromPaymentAccountsAs(String name, PaymentAccountRequest subRequest){
       return statsFromPaymentAccountsAs(name, subRequest, false);
    }

    public UserAccountRequest<T> statsFromPaymentAccountsAs(String name, PaymentAccountRequest subRequest, boolean singleResult){
       subRequest.setPartitionProperty(PaymentAccount.USER_ACCOUNT_PROPERTY);
       addAggregateDynamicProperty(name, subRequest, singleResult);
       return this;
    }

    public UserAccountRequest<T> statsFromPaymentAccounts(PaymentAccountRequest subRequest){
       return statsFromPaymentAccountsAs(REFINEMENTS, subRequest);
    }
    public UserAccountRequest<T> countPaymentAccounts(){
        return countPaymentAccountsAs("Count");
    }

    public UserAccountRequest<T> countPaymentAccountsAs(String name){
        return countPaymentAccountsWith(name, Q.paymentAccounts().unlimited());
    }

    public UserAccountRequest<T> countPaymentAccountsWith(String name, PaymentAccountRequest subRequest){
        return statsFromPaymentAccountsAs(name, subRequest.count(), true);
    }
    public UserAccountRequest<T> minAccountNumberOfPaymentAccounts(){
        return minAccountNumberOfPaymentAccountsAs("minAccountNumberOfPaymentAccounts");
    }

    public UserAccountRequest<T> minAccountNumberOfPaymentAccountsAs(String name){
        return minAccountNumberOfPaymentAccountsAs(name, Q.paymentAccounts().unlimited());
    }

    public UserAccountRequest<T> minAccountNumberOfPaymentAccountsAs(String name, PaymentAccountRequest subRequest){
        return statsFromPaymentAccountsAs(name, subRequest.minAccountNumber(), true);
    }
    public UserAccountRequest<T> maxAccountNumberOfPaymentAccounts(){
        return maxAccountNumberOfPaymentAccountsAs("maxAccountNumberOfPaymentAccounts");
    }

    public UserAccountRequest<T> maxAccountNumberOfPaymentAccountsAs(String name){
        return maxAccountNumberOfPaymentAccountsAs(name, Q.paymentAccounts().unlimited());
    }

    public UserAccountRequest<T> maxAccountNumberOfPaymentAccountsAs(String name, PaymentAccountRequest subRequest){
        return statsFromPaymentAccountsAs(name, subRequest.maxAccountNumber(), true);
    }
    public UserAccountRequest<T> sumAccountNumberOfPaymentAccounts(){
        return sumAccountNumberOfPaymentAccountsAs("sumAccountNumberOfPaymentAccounts");
    }

    public UserAccountRequest<T> sumAccountNumberOfPaymentAccountsAs(String name){
        return sumAccountNumberOfPaymentAccountsAs(name, Q.paymentAccounts().unlimited());
    }

    public UserAccountRequest<T> sumAccountNumberOfPaymentAccountsAs(String name, PaymentAccountRequest subRequest){
        return statsFromPaymentAccountsAs(name, subRequest.sumAccountNumber(), true);
    }
    public UserAccountRequest<T> avgAccountNumberOfPaymentAccounts(){
        return avgAccountNumberOfPaymentAccountsAs("avgAccountNumberOfPaymentAccounts");
    }

    public UserAccountRequest<T> avgAccountNumberOfPaymentAccountsAs(String name){
        return avgAccountNumberOfPaymentAccountsAs(name, Q.paymentAccounts().unlimited());
    }

    public UserAccountRequest<T> avgAccountNumberOfPaymentAccountsAs(String name, PaymentAccountRequest subRequest){
        return statsFromPaymentAccountsAs(name, subRequest.avgAccountNumber(), true);
    }
    public UserAccountRequest<T> standardDeviationAccountNumberOfPaymentAccounts(){
        return standardDeviationAccountNumberOfPaymentAccountsAs("stdDevAccountNumberOfPaymentAccounts");
    }

    public UserAccountRequest<T> standardDeviationAccountNumberOfPaymentAccountsAs(String name){
        return standardDeviationAccountNumberOfPaymentAccountsAs(name, Q.paymentAccounts().unlimited());
    }

    public UserAccountRequest<T> standardDeviationAccountNumberOfPaymentAccountsAs(String name, PaymentAccountRequest subRequest){
        return statsFromPaymentAccountsAs(name, subRequest.standardDeviationAccountNumber(), true);
    }
    public UserAccountRequest<T> squareRootOfPopulationStandardDeviationAccountNumberOfPaymentAccounts(){
        return squareRootOfPopulationStandardDeviationAccountNumberOfPaymentAccountsAs("stdDevPopAccountNumberOfPaymentAccounts");
    }

    public UserAccountRequest<T> squareRootOfPopulationStandardDeviationAccountNumberOfPaymentAccountsAs(String name){
        return squareRootOfPopulationStandardDeviationAccountNumberOfPaymentAccountsAs(name, Q.paymentAccounts().unlimited());
    }

    public UserAccountRequest<T> squareRootOfPopulationStandardDeviationAccountNumberOfPaymentAccountsAs(String name, PaymentAccountRequest subRequest){
        return statsFromPaymentAccountsAs(name, subRequest.squareRootOfPopulationStandardDeviationAccountNumber(), true);
    }
    public UserAccountRequest<T> sampleVarianceAccountNumberOfPaymentAccounts(){
        return sampleVarianceAccountNumberOfPaymentAccountsAs("varSampAccountNumberOfPaymentAccounts");
    }

    public UserAccountRequest<T> sampleVarianceAccountNumberOfPaymentAccountsAs(String name){
        return sampleVarianceAccountNumberOfPaymentAccountsAs(name, Q.paymentAccounts().unlimited());
    }

    public UserAccountRequest<T> sampleVarianceAccountNumberOfPaymentAccountsAs(String name, PaymentAccountRequest subRequest){
        return statsFromPaymentAccountsAs(name, subRequest.sampleVarianceAccountNumber(), true);
    }
    public UserAccountRequest<T> samplePopulationVarianceAccountNumberOfPaymentAccounts(){
        return samplePopulationVarianceAccountNumberOfPaymentAccountsAs("varPopAccountNumberOfPaymentAccounts");
    }

    public UserAccountRequest<T> samplePopulationVarianceAccountNumberOfPaymentAccountsAs(String name){
        return samplePopulationVarianceAccountNumberOfPaymentAccountsAs(name, Q.paymentAccounts().unlimited());
    }

    public UserAccountRequest<T> samplePopulationVarianceAccountNumberOfPaymentAccountsAs(String name, PaymentAccountRequest subRequest){
        return statsFromPaymentAccountsAs(name, subRequest.samplePopulationVarianceAccountNumber(), true);
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