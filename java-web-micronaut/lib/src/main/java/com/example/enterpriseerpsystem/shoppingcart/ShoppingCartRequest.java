
package com.example.enterpriseerpsystem.shoppingcart;

import com.example.enterpriseerpsystem.Q;
import com.example.enterpriseerpsystem.cartitem.CartItem;
import com.example.enterpriseerpsystem.cartitem.CartItemRequest;
import com.example.enterpriseerpsystem.customer.Customer;
import com.example.enterpriseerpsystem.customer.CustomerRequest;
import io.teaql.core.AggrFunction;
import io.teaql.core.BaseRequest;
import io.teaql.core.PropertyReference;
import io.teaql.core.SearchCriteria;
import io.teaql.core.SubQuerySearchCriteria;
import io.teaql.core.criteria.Operator;
import io.teaql.core.criteria.TwoOperatorCriteria;
import java.time.LocalDateTime;
import java.util.Date;

public class ShoppingCartRequest<T extends ShoppingCart> extends BaseRequest<T> {

    /**
     * @deprecated AI agents and business code must use the generated Q facade
     *             instead of constructing request builders directly.
     */
    @Deprecated
    public ShoppingCartRequest(Class<T> returnType){
        super(returnType);
        selectId();
        selectVersion();
    }

    public ShoppingCartRequest<T> comment(String comment){
         super.internalComment(comment);
         return this;
    }

    // purpose() 继承自 BaseRequest，返回 ExecutableRequest（终结方法）

    public ShoppingCartRequest<T> returnType(Class<? extends T> returnType){
        super.setReturnType(returnType);
        return this;
    }

    public ShoppingCartRequest<T> enableAggregationCache(long cacheExpiredMillis){
        super.enableAggregationCache();
        super.aggregateCacheTime(cacheExpiredMillis);
        return this;
    }

    public ShoppingCartRequest<T> enableAggregationCache(){
        return enableAggregationCache(0l);
    }


    public ShoppingCartRequest<T> propagateAggregationCache(long cacheExpiredMillis){
        super.propagateAggregationCache(cacheExpiredMillis);
        return this;
    }

    public ShoppingCartRequest<T> appendSearchCriteria(SearchCriteria searchCriteria){
        return (ShoppingCartRequest<T>)super.appendSearchCriteria(searchCriteria);
    }

    public ShoppingCartRequest<T> filter(String property1, Operator operator, String property2){
        return appendSearchCriteria(new TwoOperatorCriteria(operator, new PropertyReference(property1), new PropertyReference(property2)));
    }


    public ShoppingCartRequest<T> matchingAnyOf(ShoppingCartRequest shoppingCart){
        super.internalMatchAny(shoppingCart);
        return this;
    }

    public ShoppingCartRequest<T> enhanceChildrenIfNeeded(){
        return this;
    }

    public ShoppingCartRequest<T> withDeletedRows(){
        super.withDeletedRows();
        return this;
    }

    public ShoppingCartRequest<T> deletedRowsOnly(){
        super.deletedRowsOnly();
        return this;
    }

    public ShoppingCartRequest<T> selectSelf(){
        super.selectSelf();
        return selectId().selectCreatedAt().selectCustomerIdOnly().selectIsAbandoned().selectSessionId().selectCreateTime().selectUpdateTime().selectVersion();
    }

    public ShoppingCartRequest<T> selectSelfFields(){
        return selectSelf();
    }

    public ShoppingCartRequest<T> selectAll(){
        super.selectAll();
        return selectId().selectCreatedAt().selectCustomer().selectIsAbandoned().selectSessionId().selectCreateTime().selectUpdateTime().selectVersion();
    }

    public ShoppingCartRequest<T> selectChildren(){
        super.selectAny();
        selectCartItemList();
        return selectId().selectCreatedAt().selectCustomer().selectIsAbandoned().selectSessionId().selectCreateTime().selectUpdateTime().selectVersion();
    }


    public ShoppingCartRequest<T> selectId(){
       selectProperty(ShoppingCart.ID_PROPERTY);
       return this;
    }

    /**
     * fill the id with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  id) to fetch id property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public ShoppingCartRequest<T> unselectId(){
       unselectProperty(ShoppingCart.ID_PROPERTY);
       return this;
    }
    public ShoppingCartRequest<T> selectCreatedAt(){
       selectProperty(ShoppingCart.CREATED_AT_PROPERTY);
       return this;
    }

    /**
     * fill the createdAt with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  createdAt) to fetch createdAt property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public ShoppingCartRequest<T> unselectCreatedAt(){
       unselectProperty(ShoppingCart.CREATED_AT_PROPERTY);
       return this;
    }
    public ShoppingCartRequest<T> selectCustomerIdOnly(){
       selectProperty(ShoppingCart.CUSTOMER_PROPERTY);
       return this;
    }

    public ShoppingCartRequest<T> selectCustomer(){
        return selectCustomerWith(Q.customers().unlimited().selectSelf());
    }

    public ShoppingCartRequest<T> selectCustomerWith(CustomerRequest customer){
       selectProperty(ShoppingCart.CUSTOMER_PROPERTY);
       enhanceRelation(ShoppingCart.CUSTOMER_PROPERTY, customer);
       return this;
    }

    public ShoppingCartRequest<T> unselectCustomer(){
       unselectProperty(ShoppingCart.CUSTOMER_PROPERTY);
       return this;
    }
    public ShoppingCartRequest<T> selectIsAbandoned(){
       selectProperty(ShoppingCart.IS_ABANDONED_PROPERTY);
       return this;
    }

    /**
     * fill the isAbandoned with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  isAbandoned) to fetch isAbandoned property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public ShoppingCartRequest<T> unselectIsAbandoned(){
       unselectProperty(ShoppingCart.IS_ABANDONED_PROPERTY);
       return this;
    }
    public ShoppingCartRequest<T> selectSessionId(){
       selectProperty(ShoppingCart.SESSION_ID_PROPERTY);
       return this;
    }

    /**
     * fill the sessionId with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  sessionId) to fetch sessionId property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public ShoppingCartRequest<T> unselectSessionId(){
       unselectProperty(ShoppingCart.SESSION_ID_PROPERTY);
       return this;
    }
    public ShoppingCartRequest<T> selectCreateTime(){
       selectProperty(ShoppingCart.CREATE_TIME_PROPERTY);
       return this;
    }

    /**
     * fill the createTime with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  createTime) to fetch createTime property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public ShoppingCartRequest<T> unselectCreateTime(){
       unselectProperty(ShoppingCart.CREATE_TIME_PROPERTY);
       return this;
    }
    public ShoppingCartRequest<T> selectUpdateTime(){
       selectProperty(ShoppingCart.UPDATE_TIME_PROPERTY);
       return this;
    }

    /**
     * fill the updateTime with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  updateTime) to fetch updateTime property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public ShoppingCartRequest<T> unselectUpdateTime(){
       unselectProperty(ShoppingCart.UPDATE_TIME_PROPERTY);
       return this;
    }
    public ShoppingCartRequest<T> selectVersion(){
       selectProperty(ShoppingCart.VERSION_PROPERTY);
       return this;
    }

    /**
     * fill the version with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  version) to fetch version property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public ShoppingCartRequest<T> unselectVersion(){
       unselectProperty(ShoppingCart.VERSION_PROPERTY);
       return this;
    }
    public ShoppingCartRequest<T> selectCartItemList(){
       return selectCartItemListWith(Q.cartItems().selectSelf());
    }

    public ShoppingCartRequest<T> selectCartItemListWith(CartItemRequest cartItemList){
       enhanceRelation(ShoppingCart.CART_ITEM_LIST_PROPERTY, cartItemList);
       return this;
    }

    public ShoppingCartRequest<T> withId(Operator operator, Object... values){
       return appendSearchCriteria(createIdCriteria(operator, values));
    }

    public SearchCriteria createIdCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(ShoppingCart.ID_PROPERTY, operator, values);
    }

    public ShoppingCartRequest<T> withIdIs(Long id){
       return withId(Operator.EQUAL, id);
    }
    public ShoppingCartRequest<T> withIdIn(Long... id){
       return withId(Operator.EQUAL, (Object[])id);
    }



    public ShoppingCartRequest<T> filterByCreatedAt(LocalDateTime... createdAt){
      if (createdAt == null || createdAt.length == 0) {
        throw new IllegalArgumentException("filterByCreatedAt parameter createdAt cannot be empty");
      }
      return appendSearchCriteria(createCreatedAtCriteria(Operator.EQUAL, (Object[])createdAt));
    }

    public ShoppingCartRequest<T> withCreatedAt(Operator operator, Object... values){
       return appendSearchCriteria(createCreatedAtCriteria(operator, values));
    }

    public ShoppingCartRequest<T> withCreatedAtIsUnknown(){
       return withCreatedAt(Operator.IS_NULL);
    }

    public ShoppingCartRequest<T> withCreatedAtIsKnown(){
       return withCreatedAt(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createCreatedAtCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(ShoppingCart.CREATED_AT_PROPERTY, operator, values);
    }

    public ShoppingCartRequest<T> withCreatedAtGreaterThan(LocalDateTime createdAt){
       return withCreatedAt(Operator.GREATER_THAN, createdAt);
    }

    public ShoppingCartRequest<T> withCreatedAtGreaterThanOrEqualTo(LocalDateTime createdAt){
       return withCreatedAt(Operator.GREATER_THAN_OR_EQUAL, createdAt);
    }

    public ShoppingCartRequest<T> withCreatedAtLessThan(LocalDateTime createdAt){
       return withCreatedAt(Operator.LESS_THAN, createdAt);
    }

    public ShoppingCartRequest<T> withCreatedAtLessThanOrEqualTo(LocalDateTime createdAt){
       return withCreatedAt(Operator.LESS_THAN_OR_EQUAL, createdAt);
    }

    public ShoppingCartRequest<T> withCreatedAtBetween(LocalDateTime startOfCreatedAt, LocalDateTime endOfCreatedAt){
       return withCreatedAt(Operator.BETWEEN, startOfCreatedAt, endOfCreatedAt);
    }
    public ShoppingCartRequest<T> withCreatedAtBefore(LocalDateTime createdAt){
       return withCreatedAt(Operator.LESS_THAN, createdAt);
    }

    public ShoppingCartRequest<T> withCreatedAtBefore(Date createdAt){
       return withCreatedAt(Operator.LESS_THAN, createdAt);
    }

    public ShoppingCartRequest<T> withCreatedAtAfter(LocalDateTime createdAt){
       return withCreatedAt(Operator.GREATER_THAN, createdAt);
    }

    public ShoppingCartRequest<T> withCreatedAtAfter(Date createdAt){
       return withCreatedAt(Operator.GREATER_THAN, createdAt);
    }

    public ShoppingCartRequest<T> withCreatedAtBetween(Date startOfCreatedAt, Date endOfCreatedAt){
       return withCreatedAt(Operator.BETWEEN, startOfCreatedAt, endOfCreatedAt);
    }




    public ShoppingCartRequest<T> filterByCustomer(Customer... customer){
      if (customer == null || customer.length == 0) {
        throw new IllegalArgumentException("filterByCustomer parameter customer cannot be empty");
      }
      return appendSearchCriteria(createCustomerCriteria(Operator.EQUAL, (Object[])customer));
    }

    public ShoppingCartRequest<T> withCustomer(Operator operator, Object... values){
       return appendSearchCriteria(createCustomerCriteria(operator, values));
    }

    public ShoppingCartRequest<T> withCustomerIsUnknown(){
       return withCustomer(Operator.IS_NULL);
    }

    public ShoppingCartRequest<T> withCustomerIsKnown(){
       return withCustomer(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createCustomerCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(ShoppingCart.CUSTOMER_PROPERTY, operator, values);
    }

    public ShoppingCartRequest<T> filterByCustomer(Long customer){
      if(customer == null){
         return this;
      }
      return withCustomer(Operator.EQUAL, customer);
    }
    public ShoppingCartRequest<T> withCustomerMatching(CustomerRequest customer){
       return appendSearchCriteria(new SubQuerySearchCriteria(ShoppingCart.CUSTOMER_PROPERTY, customer, Customer.ID_PROPERTY));
    }

    public ShoppingCartRequest<T> filterByIsAbandoned(Boolean... isAbandoned){
      if (isAbandoned == null || isAbandoned.length == 0) {
        throw new IllegalArgumentException("filterByIsAbandoned parameter isAbandoned cannot be empty");
      }
      return appendSearchCriteria(createIsAbandonedCriteria(Operator.EQUAL, (Object[])isAbandoned));
    }

    public ShoppingCartRequest<T> withIsAbandoned(Operator operator, Object... values){
       return appendSearchCriteria(createIsAbandonedCriteria(operator, values));
    }

    public ShoppingCartRequest<T> withIsAbandonedIsUnknown(){
       return withIsAbandoned(Operator.IS_NULL);
    }

    public ShoppingCartRequest<T> withIsAbandonedIsKnown(){
       return withIsAbandoned(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createIsAbandonedCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(ShoppingCart.IS_ABANDONED_PROPERTY, operator, values);
    }

    public ShoppingCartRequest<T> whichIsIsAbandoned(){
       return withIsAbandoned(Operator.EQUAL, true);
    }

    public ShoppingCartRequest<T> whichIsNotIsAbandoned(){
       return withIsAbandoned(Operator.EQUAL, false);
    }


    public ShoppingCartRequest<T> filterBySessionId(String... sessionId){
      if (sessionId == null || sessionId.length == 0) {
        throw new IllegalArgumentException("filterBySessionId parameter sessionId cannot be empty");
      }
      return appendSearchCriteria(createSessionIdCriteria(Operator.EQUAL, (Object[])sessionId));
    }

    public ShoppingCartRequest<T> withSessionId(Operator operator, Object... values){
       return appendSearchCriteria(createSessionIdCriteria(operator, values));
    }

    public ShoppingCartRequest<T> withSessionIdIsUnknown(){
       return withSessionId(Operator.IS_NULL);
    }

    public ShoppingCartRequest<T> withSessionIdIsKnown(){
       return withSessionId(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createSessionIdCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(ShoppingCart.SESSION_ID_PROPERTY, operator, values);
    }

    public ShoppingCartRequest<T> withSessionIdGreaterThan(String sessionId){
       return withSessionId(Operator.GREATER_THAN, sessionId);
    }

    public ShoppingCartRequest<T> withSessionIdGreaterThanOrEqualTo(String sessionId){
       return withSessionId(Operator.GREATER_THAN_OR_EQUAL, sessionId);
    }

    public ShoppingCartRequest<T> withSessionIdLessThan(String sessionId){
       return withSessionId(Operator.LESS_THAN, sessionId);
    }

    public ShoppingCartRequest<T> withSessionIdLessThanOrEqualTo(String sessionId){
       return withSessionId(Operator.LESS_THAN_OR_EQUAL, sessionId);
    }

    public ShoppingCartRequest<T> withSessionIdBetween(String startOfSessionId, String endOfSessionId){
       return withSessionId(Operator.BETWEEN, startOfSessionId, endOfSessionId);
    }
    public ShoppingCartRequest<T> withSessionIdStartingWith(String sessionId){
       return withSessionId(Operator.BEGIN_WITH, sessionId);
    }
    public ShoppingCartRequest<T> withSessionIdContaining(String sessionId){
       return withSessionId(Operator.CONTAIN, sessionId);
    }

    public ShoppingCartRequest<T> withSessionIdEndingWith(String sessionId){
       return withSessionId(Operator.END_WITH, sessionId);
    }

    public ShoppingCartRequest<T> withSessionIdIs(String sessionId){
       return withSessionId(Operator.EQUAL, sessionId);
    }

    public ShoppingCartRequest<T> withSessionIdSoundingLike(String sessionId){
       return withSessionId(Operator.SOUNDS_LIKE, sessionId);
    }



    public ShoppingCartRequest<T> filterByCreateTime(LocalDateTime... createTime){
      if (createTime == null || createTime.length == 0) {
        throw new IllegalArgumentException("filterByCreateTime parameter createTime cannot be empty");
      }
      return appendSearchCriteria(createCreateTimeCriteria(Operator.EQUAL, (Object[])createTime));
    }

    public ShoppingCartRequest<T> withCreateTime(Operator operator, Object... values){
       return appendSearchCriteria(createCreateTimeCriteria(operator, values));
    }

    public ShoppingCartRequest<T> withCreateTimeIsUnknown(){
       return withCreateTime(Operator.IS_NULL);
    }

    public ShoppingCartRequest<T> withCreateTimeIsKnown(){
       return withCreateTime(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createCreateTimeCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(ShoppingCart.CREATE_TIME_PROPERTY, operator, values);
    }

    public ShoppingCartRequest<T> withCreateTimeGreaterThan(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public ShoppingCartRequest<T> withCreateTimeGreaterThanOrEqualTo(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN_OR_EQUAL, createTime);
    }

    public ShoppingCartRequest<T> withCreateTimeLessThan(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public ShoppingCartRequest<T> withCreateTimeLessThanOrEqualTo(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN_OR_EQUAL, createTime);
    }

    public ShoppingCartRequest<T> withCreateTimeBetween(LocalDateTime startOfCreateTime, LocalDateTime endOfCreateTime){
       return withCreateTime(Operator.BETWEEN, startOfCreateTime, endOfCreateTime);
    }
    public ShoppingCartRequest<T> withCreateTimeBefore(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public ShoppingCartRequest<T> withCreateTimeBefore(Date createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public ShoppingCartRequest<T> withCreateTimeAfter(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public ShoppingCartRequest<T> withCreateTimeAfter(Date createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public ShoppingCartRequest<T> withCreateTimeBetween(Date startOfCreateTime, Date endOfCreateTime){
       return withCreateTime(Operator.BETWEEN, startOfCreateTime, endOfCreateTime);
    }




    public ShoppingCartRequest<T> filterByUpdateTime(LocalDateTime... updateTime){
      if (updateTime == null || updateTime.length == 0) {
        throw new IllegalArgumentException("filterByUpdateTime parameter updateTime cannot be empty");
      }
      return appendSearchCriteria(createUpdateTimeCriteria(Operator.EQUAL, (Object[])updateTime));
    }

    public ShoppingCartRequest<T> withUpdateTime(Operator operator, Object... values){
       return appendSearchCriteria(createUpdateTimeCriteria(operator, values));
    }

    public ShoppingCartRequest<T> withUpdateTimeIsUnknown(){
       return withUpdateTime(Operator.IS_NULL);
    }

    public ShoppingCartRequest<T> withUpdateTimeIsKnown(){
       return withUpdateTime(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createUpdateTimeCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(ShoppingCart.UPDATE_TIME_PROPERTY, operator, values);
    }

    public ShoppingCartRequest<T> withUpdateTimeGreaterThan(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public ShoppingCartRequest<T> withUpdateTimeGreaterThanOrEqualTo(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN_OR_EQUAL, updateTime);
    }

    public ShoppingCartRequest<T> withUpdateTimeLessThan(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public ShoppingCartRequest<T> withUpdateTimeLessThanOrEqualTo(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN_OR_EQUAL, updateTime);
    }

    public ShoppingCartRequest<T> withUpdateTimeBetween(LocalDateTime startOfUpdateTime, LocalDateTime endOfUpdateTime){
       return withUpdateTime(Operator.BETWEEN, startOfUpdateTime, endOfUpdateTime);
    }
    public ShoppingCartRequest<T> withUpdateTimeBefore(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public ShoppingCartRequest<T> withUpdateTimeBefore(Date updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public ShoppingCartRequest<T> withUpdateTimeAfter(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public ShoppingCartRequest<T> withUpdateTimeAfter(Date updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public ShoppingCartRequest<T> withUpdateTimeBetween(Date startOfUpdateTime, Date endOfUpdateTime){
       return withUpdateTime(Operator.BETWEEN, startOfUpdateTime, endOfUpdateTime);
    }




    public ShoppingCartRequest<T> filterByVersion(Long... version){
      if (version == null || version.length == 0) {
        throw new IllegalArgumentException("filterByVersion parameter version cannot be empty");
      }
      return appendSearchCriteria(createVersionCriteria(Operator.EQUAL, (Object[])version));
    }

    public ShoppingCartRequest<T> withVersion(Operator operator, Object... values){
       return appendSearchCriteria(createVersionCriteria(operator, values));
    }

    public ShoppingCartRequest<T> withVersionIsUnknown(){
       return withVersion(Operator.IS_NULL);
    }

    public ShoppingCartRequest<T> withVersionIsKnown(){
       return withVersion(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createVersionCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(ShoppingCart.VERSION_PROPERTY, operator, values);
    }

    public ShoppingCartRequest<T> withVersionGreaterThan(Long version){
       return withVersion(Operator.GREATER_THAN, version);
    }

    public ShoppingCartRequest<T> withVersionGreaterThanOrEqualTo(Long version){
       return withVersion(Operator.GREATER_THAN_OR_EQUAL, version);
    }

    public ShoppingCartRequest<T> withVersionLessThan(Long version){
       return withVersion(Operator.LESS_THAN, version);
    }

    public ShoppingCartRequest<T> withVersionLessThanOrEqualTo(Long version){
       return withVersion(Operator.LESS_THAN_OR_EQUAL, version);
    }

    public ShoppingCartRequest<T> withVersionBetween(Long startOfVersion, Long endOfVersion){
       return withVersion(Operator.BETWEEN, startOfVersion, endOfVersion);
    }

    public ShoppingCartRequest<T> withCartItemListMatching(CartItemRequest cartItemRequest){
        return appendSearchCriteria(new SubQuerySearchCriteria(ShoppingCart.ID_PROPERTY, cartItemRequest, CartItem.SHOPPING_CART_PROPERTY));
    }

    public ShoppingCartRequest<T> withoutCartItemListMatching(CartItemRequest cartItemRequest){
        return appendSearchCriteria(SearchCriteria.not(new SubQuerySearchCriteria(ShoppingCart.ID_PROPERTY, cartItemRequest, CartItem.SHOPPING_CART_PROPERTY)));
    }

    public ShoppingCartRequest<T> haveCartItems(){
        return withCartItemListMatching(Q.cartItems().unlimited());
    }

    public ShoppingCartRequest<T> haveNoCartItems(){
        return withoutCartItemListMatching(Q.cartItems().unlimited());
    }

    public ShoppingCartRequest<T> count(){
        super.count();
        return this;
    }
    public ShoppingCartRequest<T> countAs(String retName){
        super.count(retName);
        return this;
    }
    public ShoppingCartRequest<T> groupByCustomerWithDetails(){
       return groupByCustomerWithDetails(Q.customers().unlimited());
    }

    public ShoppingCartRequest<T> groupByCustomerWithDetails(CustomerRequest subRequest){
       aggregate(ShoppingCart.CUSTOMER_PROPERTY, subRequest);
       return this;
    }






    public ShoppingCartRequest<T> groupByCartItemsWithDetails(CartItemRequest subRequest){
       aggregate(ShoppingCart.CART_ITEM_LIST_PROPERTY, subRequest);
       return this;
    }

    public ShoppingCartRequest<T> groupById(){
       groupBy(ShoppingCart.ID_PROPERTY);
       return this;
    }

    public ShoppingCartRequest<T> groupByIdAs(String retName){
       groupBy(retName, ShoppingCart.ID_PROPERTY);
       return this;
    }

    public ShoppingCartRequest<T> groupByIdWithFunction(String retName, AggrFunction function){
       groupBy(retName, ShoppingCart.ID_PROPERTY, function);
       return this;
    }

    public ShoppingCartRequest<T> groupByCreatedAt(){
       groupBy(ShoppingCart.CREATED_AT_PROPERTY);
       return this;
    }

    public ShoppingCartRequest<T> groupByCreatedAtAs(String retName){
       groupBy(retName, ShoppingCart.CREATED_AT_PROPERTY);
       return this;
    }

    public ShoppingCartRequest<T> groupByCreatedAtWithFunction(String retName, AggrFunction function){
       groupBy(retName, ShoppingCart.CREATED_AT_PROPERTY, function);
       return this;
    }
    public ShoppingCartRequest<T> groupByCustomerWith(CustomerRequest subRequest){
       groupBy(ShoppingCart.CUSTOMER_PROPERTY, subRequest);
       return this;
    }
    public ShoppingCartRequest<T> groupByCustomer(){
       groupBy(ShoppingCart.CUSTOMER_PROPERTY);
       return this;
    }

    public ShoppingCartRequest<T> groupByCustomerAs(String retName){
       groupBy(retName, ShoppingCart.CUSTOMER_PROPERTY);
       return this;
    }

    public ShoppingCartRequest<T> groupByCustomerWithFunction(String retName, AggrFunction function){
       groupBy(retName, ShoppingCart.CUSTOMER_PROPERTY, function);
       return this;
    }

    public ShoppingCartRequest<T> groupByIsAbandoned(){
       groupBy(ShoppingCart.IS_ABANDONED_PROPERTY);
       return this;
    }

    public ShoppingCartRequest<T> groupByIsAbandonedAs(String retName){
       groupBy(retName, ShoppingCart.IS_ABANDONED_PROPERTY);
       return this;
    }

    public ShoppingCartRequest<T> groupByIsAbandonedWithFunction(String retName, AggrFunction function){
       groupBy(retName, ShoppingCart.IS_ABANDONED_PROPERTY, function);
       return this;
    }

    public ShoppingCartRequest<T> groupBySessionId(){
       groupBy(ShoppingCart.SESSION_ID_PROPERTY);
       return this;
    }

    public ShoppingCartRequest<T> groupBySessionIdAs(String retName){
       groupBy(retName, ShoppingCart.SESSION_ID_PROPERTY);
       return this;
    }

    public ShoppingCartRequest<T> groupBySessionIdWithFunction(String retName, AggrFunction function){
       groupBy(retName, ShoppingCart.SESSION_ID_PROPERTY, function);
       return this;
    }

    public ShoppingCartRequest<T> groupByCreateTime(){
       groupBy(ShoppingCart.CREATE_TIME_PROPERTY);
       return this;
    }

    public ShoppingCartRequest<T> groupByCreateTimeAs(String retName){
       groupBy(retName, ShoppingCart.CREATE_TIME_PROPERTY);
       return this;
    }

    public ShoppingCartRequest<T> groupByCreateTimeWithFunction(String retName, AggrFunction function){
       groupBy(retName, ShoppingCart.CREATE_TIME_PROPERTY, function);
       return this;
    }

    public ShoppingCartRequest<T> groupByUpdateTime(){
       groupBy(ShoppingCart.UPDATE_TIME_PROPERTY);
       return this;
    }

    public ShoppingCartRequest<T> groupByUpdateTimeAs(String retName){
       groupBy(retName, ShoppingCart.UPDATE_TIME_PROPERTY);
       return this;
    }

    public ShoppingCartRequest<T> groupByUpdateTimeWithFunction(String retName, AggrFunction function){
       groupBy(retName, ShoppingCart.UPDATE_TIME_PROPERTY, function);
       return this;
    }

    public ShoppingCartRequest<T> groupByVersion(){
       groupBy(ShoppingCart.VERSION_PROPERTY);
       return this;
    }

    public ShoppingCartRequest<T> groupByVersionAs(String retName){
       groupBy(retName, ShoppingCart.VERSION_PROPERTY);
       return this;
    }

    public ShoppingCartRequest<T> groupByVersionWithFunction(String retName, AggrFunction function){
       groupBy(retName, ShoppingCart.VERSION_PROPERTY, function);
       return this;
    }



    public ShoppingCartRequest<T> orderByIdAscending(){
       addOrderByAscending(ShoppingCart.ID_PROPERTY);
       return this;
    }

    public ShoppingCartRequest<T> orderByIdDescending(){
       addOrderByDescending(ShoppingCart.ID_PROPERTY);
       return this;
    }

    public ShoppingCartRequest<T> orderByCreatedAtAscending(){
       addOrderByAscending(ShoppingCart.CREATED_AT_PROPERTY);
       return this;
    }

    public ShoppingCartRequest<T> orderByCreatedAtDescending(){
       addOrderByDescending(ShoppingCart.CREATED_AT_PROPERTY);
       return this;
    }

    public ShoppingCartRequest<T> orderByCustomerAscending(){
       addOrderByAscending(ShoppingCart.CUSTOMER_PROPERTY);
       return this;
    }

    public ShoppingCartRequest<T> orderByCustomerDescending(){
       addOrderByDescending(ShoppingCart.CUSTOMER_PROPERTY);
       return this;
    }

    public ShoppingCartRequest<T> orderByIsAbandonedAscending(){
       addOrderByAscending(ShoppingCart.IS_ABANDONED_PROPERTY);
       return this;
    }

    public ShoppingCartRequest<T> orderByIsAbandonedDescending(){
       addOrderByDescending(ShoppingCart.IS_ABANDONED_PROPERTY);
       return this;
    }

    public ShoppingCartRequest<T> orderBySessionIdAscending(){
       addOrderByAscending(ShoppingCart.SESSION_ID_PROPERTY);
       return this;
    }

    public ShoppingCartRequest<T> orderBySessionIdDescending(){
       addOrderByDescending(ShoppingCart.SESSION_ID_PROPERTY);
       return this;
    }
    public ShoppingCartRequest<T> orderBySessionIdAscendingUsingGBK(){
       addOrderByAscendingUsingGBK(ShoppingCart.SESSION_ID_PROPERTY);
       return this;
    }

    public ShoppingCartRequest<T> orderBySessionIdDescendingUsingGBK(){
       addOrderByDescendingUsingGBK(ShoppingCart.SESSION_ID_PROPERTY);
       return this;
    }
    public ShoppingCartRequest<T> orderByCreateTimeAscending(){
       addOrderByAscending(ShoppingCart.CREATE_TIME_PROPERTY);
       return this;
    }

    public ShoppingCartRequest<T> orderByCreateTimeDescending(){
       addOrderByDescending(ShoppingCart.CREATE_TIME_PROPERTY);
       return this;
    }

    public ShoppingCartRequest<T> orderByUpdateTimeAscending(){
       addOrderByAscending(ShoppingCart.UPDATE_TIME_PROPERTY);
       return this;
    }

    public ShoppingCartRequest<T> orderByUpdateTimeDescending(){
       addOrderByDescending(ShoppingCart.UPDATE_TIME_PROPERTY);
       return this;
    }

    public ShoppingCartRequest<T> orderByVersionAscending(){
       addOrderByAscending(ShoppingCart.VERSION_PROPERTY);
       return this;
    }

    public ShoppingCartRequest<T> orderByVersionDescending(){
       addOrderByDescending(ShoppingCart.VERSION_PROPERTY);
       return this;
    }


    public ShoppingCartRequest<T> statsFromCartItemsAs(String name, CartItemRequest subRequest){
       return statsFromCartItemsAs(name, subRequest, false);
    }

    public ShoppingCartRequest<T> statsFromCartItemsAs(String name, CartItemRequest subRequest, boolean singleResult){
       subRequest.setPartitionProperty(CartItem.SHOPPING_CART_PROPERTY);
       addAggregateDynamicProperty(name, subRequest, singleResult);
       return this;
    }

    public ShoppingCartRequest<T> statsFromCartItems(CartItemRequest subRequest){
       return statsFromCartItemsAs(REFINEMENTS, subRequest);
    }
    public CustomerRequest rollUpToCustomer(){
       CustomerRequest customer = Q.customers().unlimited();
       this.withCustomerMatching(customer)
           .groupByCustomerWith(customer);
       return customer;
    }






    public ShoppingCartRequest<T> countCartItems(){
        return countCartItemsAs("Count");
    }

    public ShoppingCartRequest<T> countCartItemsAs(String name){
        return countCartItemsWith(name, Q.cartItems().unlimited());
    }

    public ShoppingCartRequest<T> countCartItemsWith(String name, CartItemRequest subRequest){
        return statsFromCartItemsAs(name, subRequest.count(), true);
    }
    public ShoppingCartRequest<T> minQuantityOfCartItems(){
        return minQuantityOfCartItemsAs("minQuantityOfCartItems");
    }

    public ShoppingCartRequest<T> minQuantityOfCartItemsAs(String name){
        return minQuantityOfCartItemsAs(name, Q.cartItems().unlimited());
    }

    public ShoppingCartRequest<T> minQuantityOfCartItemsAs(String name, CartItemRequest subRequest){
        return statsFromCartItemsAs(name, subRequest.minQuantity(), true);
    }
    public ShoppingCartRequest<T> maxQuantityOfCartItems(){
        return maxQuantityOfCartItemsAs("maxQuantityOfCartItems");
    }

    public ShoppingCartRequest<T> maxQuantityOfCartItemsAs(String name){
        return maxQuantityOfCartItemsAs(name, Q.cartItems().unlimited());
    }

    public ShoppingCartRequest<T> maxQuantityOfCartItemsAs(String name, CartItemRequest subRequest){
        return statsFromCartItemsAs(name, subRequest.maxQuantity(), true);
    }
    public ShoppingCartRequest<T> sumQuantityOfCartItems(){
        return sumQuantityOfCartItemsAs("sumQuantityOfCartItems");
    }

    public ShoppingCartRequest<T> sumQuantityOfCartItemsAs(String name){
        return sumQuantityOfCartItemsAs(name, Q.cartItems().unlimited());
    }

    public ShoppingCartRequest<T> sumQuantityOfCartItemsAs(String name, CartItemRequest subRequest){
        return statsFromCartItemsAs(name, subRequest.sumQuantity(), true);
    }
    public ShoppingCartRequest<T> avgQuantityOfCartItems(){
        return avgQuantityOfCartItemsAs("avgQuantityOfCartItems");
    }

    public ShoppingCartRequest<T> avgQuantityOfCartItemsAs(String name){
        return avgQuantityOfCartItemsAs(name, Q.cartItems().unlimited());
    }

    public ShoppingCartRequest<T> avgQuantityOfCartItemsAs(String name, CartItemRequest subRequest){
        return statsFromCartItemsAs(name, subRequest.avgQuantity(), true);
    }
    public ShoppingCartRequest<T> standardDeviationQuantityOfCartItems(){
        return standardDeviationQuantityOfCartItemsAs("stdDevQuantityOfCartItems");
    }

    public ShoppingCartRequest<T> standardDeviationQuantityOfCartItemsAs(String name){
        return standardDeviationQuantityOfCartItemsAs(name, Q.cartItems().unlimited());
    }

    public ShoppingCartRequest<T> standardDeviationQuantityOfCartItemsAs(String name, CartItemRequest subRequest){
        return statsFromCartItemsAs(name, subRequest.standardDeviationQuantity(), true);
    }
    public ShoppingCartRequest<T> squareRootOfPopulationStandardDeviationQuantityOfCartItems(){
        return squareRootOfPopulationStandardDeviationQuantityOfCartItemsAs("stdDevPopQuantityOfCartItems");
    }

    public ShoppingCartRequest<T> squareRootOfPopulationStandardDeviationQuantityOfCartItemsAs(String name){
        return squareRootOfPopulationStandardDeviationQuantityOfCartItemsAs(name, Q.cartItems().unlimited());
    }

    public ShoppingCartRequest<T> squareRootOfPopulationStandardDeviationQuantityOfCartItemsAs(String name, CartItemRequest subRequest){
        return statsFromCartItemsAs(name, subRequest.squareRootOfPopulationStandardDeviationQuantity(), true);
    }
    public ShoppingCartRequest<T> sampleVarianceQuantityOfCartItems(){
        return sampleVarianceQuantityOfCartItemsAs("varSampQuantityOfCartItems");
    }

    public ShoppingCartRequest<T> sampleVarianceQuantityOfCartItemsAs(String name){
        return sampleVarianceQuantityOfCartItemsAs(name, Q.cartItems().unlimited());
    }

    public ShoppingCartRequest<T> sampleVarianceQuantityOfCartItemsAs(String name, CartItemRequest subRequest){
        return statsFromCartItemsAs(name, subRequest.sampleVarianceQuantity(), true);
    }
    public ShoppingCartRequest<T> samplePopulationVarianceQuantityOfCartItems(){
        return samplePopulationVarianceQuantityOfCartItemsAs("varPopQuantityOfCartItems");
    }

    public ShoppingCartRequest<T> samplePopulationVarianceQuantityOfCartItemsAs(String name){
        return samplePopulationVarianceQuantityOfCartItemsAs(name, Q.cartItems().unlimited());
    }

    public ShoppingCartRequest<T> samplePopulationVarianceQuantityOfCartItemsAs(String name, CartItemRequest subRequest){
        return statsFromCartItemsAs(name, subRequest.samplePopulationVarianceQuantity(), true);
    }

   public ShoppingCartRequest<T> facetByCustomerAs(String facetName, CustomerRequest customer){
       return facetByCustomerAs(facetName, customer, true);
   }

   public ShoppingCartRequest<T> facetByCustomerAs(String facetName, CustomerRequest customer, boolean includeAllFacets){
       addFacet(facetName, ShoppingCart.CUSTOMER_PROPERTY, customer, includeAllFacets);
       return this;
   }


    /**
     * get topN records
     * @param topN  records number
     */
    public ShoppingCartRequest<T> top(int topN) {
        super.top(topN);
        return this;
    }

    /**
     * get records from offset(inclusive) to offset+size(exclusive)
     * @param offset record offset
     * @param size records number
     */
    public ShoppingCartRequest<T> offset(int offset, int size) {
        super.offset(offset, size);
        return this;
    }

    /**
     * retrieve all records
     */
    public ShoppingCartRequest<T> unlimited() {
        super.unlimited();
        return this;
    }

    /**
     * get records of one page
     * @param pageNumber page number(1-based)
     * @param pageSize page size
     */
    public ShoppingCartRequest<T> page(int pageNumber, int pageSize) {
        int offset = (pageNumber - 1) * pageSize;
        return offset(offset, pageSize);
   }

    /**
     * get records of one page, default page size is 10
     * @param pageNumber page number(1-based)
     */
    public ShoppingCartRequest<T> page(int pageNumber) {
        return page(pageNumber, 10);
   }
}