
package com.example.enterpriseerpsystem.wishlist;

import com.example.enterpriseerpsystem.Q;
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

public class WishlistRequest<T extends Wishlist> extends BaseRequest<T> {

    /**
     * @deprecated AI agents and business code must use the generated Q facade
     *             instead of constructing request builders directly.
     */
    @Deprecated
    public WishlistRequest(Class<T> returnType){
        super(returnType);
        selectId();
        selectVersion();
    }

    public WishlistRequest<T> comment(String comment){
         super.internalComment(comment);
         return this;
    }

    // purpose() 继承自 BaseRequest，返回 ExecutableRequest（终结方法）

    public WishlistRequest<T> returnType(Class<? extends T> returnType){
        super.setReturnType(returnType);
        return this;
    }

    public WishlistRequest<T> enableAggregationCache(long cacheExpiredMillis){
        super.enableAggregationCache();
        super.aggregateCacheTime(cacheExpiredMillis);
        return this;
    }

    public WishlistRequest<T> enableAggregationCache(){
        return enableAggregationCache(0l);
    }


    public WishlistRequest<T> propagateAggregationCache(long cacheExpiredMillis){
        super.propagateAggregationCache(cacheExpiredMillis);
        return this;
    }

    public WishlistRequest<T> appendSearchCriteria(SearchCriteria searchCriteria){
        return (WishlistRequest<T>)super.appendSearchCriteria(searchCriteria);
    }

    public WishlistRequest<T> filter(String property1, Operator operator, String property2){
        return appendSearchCriteria(new TwoOperatorCriteria(operator, new PropertyReference(property1), new PropertyReference(property2)));
    }


    public WishlistRequest<T> matchingAnyOf(WishlistRequest wishlist){
        super.internalMatchAny(wishlist);
        return this;
    }

    public WishlistRequest<T> enhanceChildrenIfNeeded(){
        return this;
    }

    public WishlistRequest<T> withDeletedRows(){
        super.withDeletedRows();
        return this;
    }

    public WishlistRequest<T> deletedRowsOnly(){
        super.deletedRowsOnly();
        return this;
    }

    public WishlistRequest<T> selectSelf(){
        super.selectSelf();
        return selectId().selectName().selectCreatedAt().selectCustomerIdOnly().selectCreateTime().selectUpdateTime().selectVersion();
    }

    public WishlistRequest<T> selectSelfFields(){
        return selectSelf();
    }

    public WishlistRequest<T> selectAll(){
        super.selectAll();
        return selectId().selectName().selectCreatedAt().selectCustomer().selectCreateTime().selectUpdateTime().selectVersion();
    }

    public WishlistRequest<T> selectChildren(){
        super.selectAny();
        return selectId().selectName().selectCreatedAt().selectCustomer().selectCreateTime().selectUpdateTime().selectVersion();
    }


    public WishlistRequest<T> selectId(){
       selectProperty(Wishlist.ID_PROPERTY);
       return this;
    }

    /**
     * fill the id with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  id) to fetch id property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public WishlistRequest<T> unselectId(){
       unselectProperty(Wishlist.ID_PROPERTY);
       return this;
    }
    public WishlistRequest<T> selectName(){
       selectProperty(Wishlist.NAME_PROPERTY);
       return this;
    }

    /**
     * fill the name with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  name) to fetch name property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public WishlistRequest<T> unselectName(){
       unselectProperty(Wishlist.NAME_PROPERTY);
       return this;
    }
    public WishlistRequest<T> selectCreatedAt(){
       selectProperty(Wishlist.CREATED_AT_PROPERTY);
       return this;
    }

    /**
     * fill the createdAt with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  createdAt) to fetch createdAt property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public WishlistRequest<T> unselectCreatedAt(){
       unselectProperty(Wishlist.CREATED_AT_PROPERTY);
       return this;
    }
    public WishlistRequest<T> selectCustomerIdOnly(){
       selectProperty(Wishlist.CUSTOMER_PROPERTY);
       return this;
    }

    public WishlistRequest<T> selectCustomer(){
        return selectCustomerWith(Q.customers().unlimited().selectSelf());
    }

    public WishlistRequest<T> selectCustomerWith(CustomerRequest customer){
       selectProperty(Wishlist.CUSTOMER_PROPERTY);
       enhanceRelation(Wishlist.CUSTOMER_PROPERTY, customer);
       return this;
    }

    public WishlistRequest<T> unselectCustomer(){
       unselectProperty(Wishlist.CUSTOMER_PROPERTY);
       return this;
    }
    public WishlistRequest<T> selectCreateTime(){
       selectProperty(Wishlist.CREATE_TIME_PROPERTY);
       return this;
    }

    /**
     * fill the createTime with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  createTime) to fetch createTime property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public WishlistRequest<T> unselectCreateTime(){
       unselectProperty(Wishlist.CREATE_TIME_PROPERTY);
       return this;
    }
    public WishlistRequest<T> selectUpdateTime(){
       selectProperty(Wishlist.UPDATE_TIME_PROPERTY);
       return this;
    }

    /**
     * fill the updateTime with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  updateTime) to fetch updateTime property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public WishlistRequest<T> unselectUpdateTime(){
       unselectProperty(Wishlist.UPDATE_TIME_PROPERTY);
       return this;
    }
    public WishlistRequest<T> selectVersion(){
       selectProperty(Wishlist.VERSION_PROPERTY);
       return this;
    }

    /**
     * fill the version with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  version) to fetch version property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public WishlistRequest<T> unselectVersion(){
       unselectProperty(Wishlist.VERSION_PROPERTY);
       return this;
    }

    public WishlistRequest<T> withId(Operator operator, Object... values){
       return appendSearchCriteria(createIdCriteria(operator, values));
    }

    public SearchCriteria createIdCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Wishlist.ID_PROPERTY, operator, values);
    }

    public WishlistRequest<T> withIdIs(Long id){
       return withId(Operator.EQUAL, id);
    }
    public WishlistRequest<T> withIdIn(Long... id){
       return withId(Operator.EQUAL, (Object[])id);
    }



    public WishlistRequest<T> filterByName(String... name){
      if (name == null || name.length == 0) {
        throw new IllegalArgumentException("filterByName parameter name cannot be empty");
      }
      return appendSearchCriteria(createNameCriteria(Operator.EQUAL, (Object[])name));
    }

    public WishlistRequest<T> withName(Operator operator, Object... values){
       return appendSearchCriteria(createNameCriteria(operator, values));
    }

    public WishlistRequest<T> withNameIsUnknown(){
       return withName(Operator.IS_NULL);
    }

    public WishlistRequest<T> withNameIsKnown(){
       return withName(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createNameCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Wishlist.NAME_PROPERTY, operator, values);
    }

    public WishlistRequest<T> withNameGreaterThan(String name){
       return withName(Operator.GREATER_THAN, name);
    }

    public WishlistRequest<T> withNameGreaterThanOrEqualTo(String name){
       return withName(Operator.GREATER_THAN_OR_EQUAL, name);
    }

    public WishlistRequest<T> withNameLessThan(String name){
       return withName(Operator.LESS_THAN, name);
    }

    public WishlistRequest<T> withNameLessThanOrEqualTo(String name){
       return withName(Operator.LESS_THAN_OR_EQUAL, name);
    }

    public WishlistRequest<T> withNameBetween(String startOfName, String endOfName){
       return withName(Operator.BETWEEN, startOfName, endOfName);
    }
    public WishlistRequest<T> withNameStartingWith(String name){
       return withName(Operator.BEGIN_WITH, name);
    }
    public WishlistRequest<T> withNameContaining(String name){
       return withName(Operator.CONTAIN, name);
    }

    public WishlistRequest<T> withNameEndingWith(String name){
       return withName(Operator.END_WITH, name);
    }

    public WishlistRequest<T> withNameIs(String name){
       return withName(Operator.EQUAL, name);
    }

    public WishlistRequest<T> withNameSoundingLike(String name){
       return withName(Operator.SOUNDS_LIKE, name);
    }



    public WishlistRequest<T> filterByCreatedAt(LocalDateTime... createdAt){
      if (createdAt == null || createdAt.length == 0) {
        throw new IllegalArgumentException("filterByCreatedAt parameter createdAt cannot be empty");
      }
      return appendSearchCriteria(createCreatedAtCriteria(Operator.EQUAL, (Object[])createdAt));
    }

    public WishlistRequest<T> withCreatedAt(Operator operator, Object... values){
       return appendSearchCriteria(createCreatedAtCriteria(operator, values));
    }

    public WishlistRequest<T> withCreatedAtIsUnknown(){
       return withCreatedAt(Operator.IS_NULL);
    }

    public WishlistRequest<T> withCreatedAtIsKnown(){
       return withCreatedAt(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createCreatedAtCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Wishlist.CREATED_AT_PROPERTY, operator, values);
    }

    public WishlistRequest<T> withCreatedAtGreaterThan(LocalDateTime createdAt){
       return withCreatedAt(Operator.GREATER_THAN, createdAt);
    }

    public WishlistRequest<T> withCreatedAtGreaterThanOrEqualTo(LocalDateTime createdAt){
       return withCreatedAt(Operator.GREATER_THAN_OR_EQUAL, createdAt);
    }

    public WishlistRequest<T> withCreatedAtLessThan(LocalDateTime createdAt){
       return withCreatedAt(Operator.LESS_THAN, createdAt);
    }

    public WishlistRequest<T> withCreatedAtLessThanOrEqualTo(LocalDateTime createdAt){
       return withCreatedAt(Operator.LESS_THAN_OR_EQUAL, createdAt);
    }

    public WishlistRequest<T> withCreatedAtBetween(LocalDateTime startOfCreatedAt, LocalDateTime endOfCreatedAt){
       return withCreatedAt(Operator.BETWEEN, startOfCreatedAt, endOfCreatedAt);
    }
    public WishlistRequest<T> withCreatedAtBefore(LocalDateTime createdAt){
       return withCreatedAt(Operator.LESS_THAN, createdAt);
    }

    public WishlistRequest<T> withCreatedAtBefore(Date createdAt){
       return withCreatedAt(Operator.LESS_THAN, createdAt);
    }

    public WishlistRequest<T> withCreatedAtAfter(LocalDateTime createdAt){
       return withCreatedAt(Operator.GREATER_THAN, createdAt);
    }

    public WishlistRequest<T> withCreatedAtAfter(Date createdAt){
       return withCreatedAt(Operator.GREATER_THAN, createdAt);
    }

    public WishlistRequest<T> withCreatedAtBetween(Date startOfCreatedAt, Date endOfCreatedAt){
       return withCreatedAt(Operator.BETWEEN, startOfCreatedAt, endOfCreatedAt);
    }




    public WishlistRequest<T> filterByCustomer(Customer... customer){
      if (customer == null || customer.length == 0) {
        throw new IllegalArgumentException("filterByCustomer parameter customer cannot be empty");
      }
      return appendSearchCriteria(createCustomerCriteria(Operator.EQUAL, (Object[])customer));
    }

    public WishlistRequest<T> withCustomer(Operator operator, Object... values){
       return appendSearchCriteria(createCustomerCriteria(operator, values));
    }

    public WishlistRequest<T> withCustomerIsUnknown(){
       return withCustomer(Operator.IS_NULL);
    }

    public WishlistRequest<T> withCustomerIsKnown(){
       return withCustomer(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createCustomerCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Wishlist.CUSTOMER_PROPERTY, operator, values);
    }

    public WishlistRequest<T> filterByCustomer(Long customer){
      if(customer == null){
         return this;
      }
      return withCustomer(Operator.EQUAL, customer);
    }
    public WishlistRequest<T> withCustomerMatching(CustomerRequest customer){
       return appendSearchCriteria(new SubQuerySearchCriteria(Wishlist.CUSTOMER_PROPERTY, customer, Customer.ID_PROPERTY));
    }

    public WishlistRequest<T> filterByCreateTime(LocalDateTime... createTime){
      if (createTime == null || createTime.length == 0) {
        throw new IllegalArgumentException("filterByCreateTime parameter createTime cannot be empty");
      }
      return appendSearchCriteria(createCreateTimeCriteria(Operator.EQUAL, (Object[])createTime));
    }

    public WishlistRequest<T> withCreateTime(Operator operator, Object... values){
       return appendSearchCriteria(createCreateTimeCriteria(operator, values));
    }

    public WishlistRequest<T> withCreateTimeIsUnknown(){
       return withCreateTime(Operator.IS_NULL);
    }

    public WishlistRequest<T> withCreateTimeIsKnown(){
       return withCreateTime(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createCreateTimeCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Wishlist.CREATE_TIME_PROPERTY, operator, values);
    }

    public WishlistRequest<T> withCreateTimeGreaterThan(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public WishlistRequest<T> withCreateTimeGreaterThanOrEqualTo(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN_OR_EQUAL, createTime);
    }

    public WishlistRequest<T> withCreateTimeLessThan(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public WishlistRequest<T> withCreateTimeLessThanOrEqualTo(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN_OR_EQUAL, createTime);
    }

    public WishlistRequest<T> withCreateTimeBetween(LocalDateTime startOfCreateTime, LocalDateTime endOfCreateTime){
       return withCreateTime(Operator.BETWEEN, startOfCreateTime, endOfCreateTime);
    }
    public WishlistRequest<T> withCreateTimeBefore(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public WishlistRequest<T> withCreateTimeBefore(Date createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public WishlistRequest<T> withCreateTimeAfter(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public WishlistRequest<T> withCreateTimeAfter(Date createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public WishlistRequest<T> withCreateTimeBetween(Date startOfCreateTime, Date endOfCreateTime){
       return withCreateTime(Operator.BETWEEN, startOfCreateTime, endOfCreateTime);
    }




    public WishlistRequest<T> filterByUpdateTime(LocalDateTime... updateTime){
      if (updateTime == null || updateTime.length == 0) {
        throw new IllegalArgumentException("filterByUpdateTime parameter updateTime cannot be empty");
      }
      return appendSearchCriteria(createUpdateTimeCriteria(Operator.EQUAL, (Object[])updateTime));
    }

    public WishlistRequest<T> withUpdateTime(Operator operator, Object... values){
       return appendSearchCriteria(createUpdateTimeCriteria(operator, values));
    }

    public WishlistRequest<T> withUpdateTimeIsUnknown(){
       return withUpdateTime(Operator.IS_NULL);
    }

    public WishlistRequest<T> withUpdateTimeIsKnown(){
       return withUpdateTime(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createUpdateTimeCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Wishlist.UPDATE_TIME_PROPERTY, operator, values);
    }

    public WishlistRequest<T> withUpdateTimeGreaterThan(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public WishlistRequest<T> withUpdateTimeGreaterThanOrEqualTo(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN_OR_EQUAL, updateTime);
    }

    public WishlistRequest<T> withUpdateTimeLessThan(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public WishlistRequest<T> withUpdateTimeLessThanOrEqualTo(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN_OR_EQUAL, updateTime);
    }

    public WishlistRequest<T> withUpdateTimeBetween(LocalDateTime startOfUpdateTime, LocalDateTime endOfUpdateTime){
       return withUpdateTime(Operator.BETWEEN, startOfUpdateTime, endOfUpdateTime);
    }
    public WishlistRequest<T> withUpdateTimeBefore(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public WishlistRequest<T> withUpdateTimeBefore(Date updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public WishlistRequest<T> withUpdateTimeAfter(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public WishlistRequest<T> withUpdateTimeAfter(Date updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public WishlistRequest<T> withUpdateTimeBetween(Date startOfUpdateTime, Date endOfUpdateTime){
       return withUpdateTime(Operator.BETWEEN, startOfUpdateTime, endOfUpdateTime);
    }




    public WishlistRequest<T> filterByVersion(Long... version){
      if (version == null || version.length == 0) {
        throw new IllegalArgumentException("filterByVersion parameter version cannot be empty");
      }
      return appendSearchCriteria(createVersionCriteria(Operator.EQUAL, (Object[])version));
    }

    public WishlistRequest<T> withVersion(Operator operator, Object... values){
       return appendSearchCriteria(createVersionCriteria(operator, values));
    }

    public WishlistRequest<T> withVersionIsUnknown(){
       return withVersion(Operator.IS_NULL);
    }

    public WishlistRequest<T> withVersionIsKnown(){
       return withVersion(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createVersionCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Wishlist.VERSION_PROPERTY, operator, values);
    }

    public WishlistRequest<T> withVersionGreaterThan(Long version){
       return withVersion(Operator.GREATER_THAN, version);
    }

    public WishlistRequest<T> withVersionGreaterThanOrEqualTo(Long version){
       return withVersion(Operator.GREATER_THAN_OR_EQUAL, version);
    }

    public WishlistRequest<T> withVersionLessThan(Long version){
       return withVersion(Operator.LESS_THAN, version);
    }

    public WishlistRequest<T> withVersionLessThanOrEqualTo(Long version){
       return withVersion(Operator.LESS_THAN_OR_EQUAL, version);
    }

    public WishlistRequest<T> withVersionBetween(Long startOfVersion, Long endOfVersion){
       return withVersion(Operator.BETWEEN, startOfVersion, endOfVersion);
    }


    public WishlistRequest<T> count(){
        super.count();
        return this;
    }
    public WishlistRequest<T> countAs(String retName){
        super.count(retName);
        return this;
    }
    public WishlistRequest<T> groupByCustomerWithDetails(){
       return groupByCustomerWithDetails(Q.customers().unlimited());
    }

    public WishlistRequest<T> groupByCustomerWithDetails(CustomerRequest subRequest){
       aggregate(Wishlist.CUSTOMER_PROPERTY, subRequest);
       return this;
    }





    public WishlistRequest<T> groupById(){
       groupBy(Wishlist.ID_PROPERTY);
       return this;
    }

    public WishlistRequest<T> groupByIdAs(String retName){
       groupBy(retName, Wishlist.ID_PROPERTY);
       return this;
    }

    public WishlistRequest<T> groupByIdWithFunction(String retName, AggrFunction function){
       groupBy(retName, Wishlist.ID_PROPERTY, function);
       return this;
    }

    public WishlistRequest<T> groupByName(){
       groupBy(Wishlist.NAME_PROPERTY);
       return this;
    }

    public WishlistRequest<T> groupByNameAs(String retName){
       groupBy(retName, Wishlist.NAME_PROPERTY);
       return this;
    }

    public WishlistRequest<T> groupByNameWithFunction(String retName, AggrFunction function){
       groupBy(retName, Wishlist.NAME_PROPERTY, function);
       return this;
    }

    public WishlistRequest<T> groupByCreatedAt(){
       groupBy(Wishlist.CREATED_AT_PROPERTY);
       return this;
    }

    public WishlistRequest<T> groupByCreatedAtAs(String retName){
       groupBy(retName, Wishlist.CREATED_AT_PROPERTY);
       return this;
    }

    public WishlistRequest<T> groupByCreatedAtWithFunction(String retName, AggrFunction function){
       groupBy(retName, Wishlist.CREATED_AT_PROPERTY, function);
       return this;
    }
    public WishlistRequest<T> groupByCustomerWith(CustomerRequest subRequest){
       groupBy(Wishlist.CUSTOMER_PROPERTY, subRequest);
       return this;
    }
    public WishlistRequest<T> groupByCustomer(){
       groupBy(Wishlist.CUSTOMER_PROPERTY);
       return this;
    }

    public WishlistRequest<T> groupByCustomerAs(String retName){
       groupBy(retName, Wishlist.CUSTOMER_PROPERTY);
       return this;
    }

    public WishlistRequest<T> groupByCustomerWithFunction(String retName, AggrFunction function){
       groupBy(retName, Wishlist.CUSTOMER_PROPERTY, function);
       return this;
    }

    public WishlistRequest<T> groupByCreateTime(){
       groupBy(Wishlist.CREATE_TIME_PROPERTY);
       return this;
    }

    public WishlistRequest<T> groupByCreateTimeAs(String retName){
       groupBy(retName, Wishlist.CREATE_TIME_PROPERTY);
       return this;
    }

    public WishlistRequest<T> groupByCreateTimeWithFunction(String retName, AggrFunction function){
       groupBy(retName, Wishlist.CREATE_TIME_PROPERTY, function);
       return this;
    }

    public WishlistRequest<T> groupByUpdateTime(){
       groupBy(Wishlist.UPDATE_TIME_PROPERTY);
       return this;
    }

    public WishlistRequest<T> groupByUpdateTimeAs(String retName){
       groupBy(retName, Wishlist.UPDATE_TIME_PROPERTY);
       return this;
    }

    public WishlistRequest<T> groupByUpdateTimeWithFunction(String retName, AggrFunction function){
       groupBy(retName, Wishlist.UPDATE_TIME_PROPERTY, function);
       return this;
    }

    public WishlistRequest<T> groupByVersion(){
       groupBy(Wishlist.VERSION_PROPERTY);
       return this;
    }

    public WishlistRequest<T> groupByVersionAs(String retName){
       groupBy(retName, Wishlist.VERSION_PROPERTY);
       return this;
    }

    public WishlistRequest<T> groupByVersionWithFunction(String retName, AggrFunction function){
       groupBy(retName, Wishlist.VERSION_PROPERTY, function);
       return this;
    }



    public WishlistRequest<T> orderByIdAscending(){
       addOrderByAscending(Wishlist.ID_PROPERTY);
       return this;
    }

    public WishlistRequest<T> orderByIdDescending(){
       addOrderByDescending(Wishlist.ID_PROPERTY);
       return this;
    }

    public WishlistRequest<T> orderByNameAscending(){
       addOrderByAscending(Wishlist.NAME_PROPERTY);
       return this;
    }

    public WishlistRequest<T> orderByNameDescending(){
       addOrderByDescending(Wishlist.NAME_PROPERTY);
       return this;
    }
    public WishlistRequest<T> orderByNameAscendingUsingGBK(){
       addOrderByAscendingUsingGBK(Wishlist.NAME_PROPERTY);
       return this;
    }

    public WishlistRequest<T> orderByNameDescendingUsingGBK(){
       addOrderByDescendingUsingGBK(Wishlist.NAME_PROPERTY);
       return this;
    }
    public WishlistRequest<T> orderByCreatedAtAscending(){
       addOrderByAscending(Wishlist.CREATED_AT_PROPERTY);
       return this;
    }

    public WishlistRequest<T> orderByCreatedAtDescending(){
       addOrderByDescending(Wishlist.CREATED_AT_PROPERTY);
       return this;
    }

    public WishlistRequest<T> orderByCustomerAscending(){
       addOrderByAscending(Wishlist.CUSTOMER_PROPERTY);
       return this;
    }

    public WishlistRequest<T> orderByCustomerDescending(){
       addOrderByDescending(Wishlist.CUSTOMER_PROPERTY);
       return this;
    }

    public WishlistRequest<T> orderByCreateTimeAscending(){
       addOrderByAscending(Wishlist.CREATE_TIME_PROPERTY);
       return this;
    }

    public WishlistRequest<T> orderByCreateTimeDescending(){
       addOrderByDescending(Wishlist.CREATE_TIME_PROPERTY);
       return this;
    }

    public WishlistRequest<T> orderByUpdateTimeAscending(){
       addOrderByAscending(Wishlist.UPDATE_TIME_PROPERTY);
       return this;
    }

    public WishlistRequest<T> orderByUpdateTimeDescending(){
       addOrderByDescending(Wishlist.UPDATE_TIME_PROPERTY);
       return this;
    }

    public WishlistRequest<T> orderByVersionAscending(){
       addOrderByAscending(Wishlist.VERSION_PROPERTY);
       return this;
    }

    public WishlistRequest<T> orderByVersionDescending(){
       addOrderByDescending(Wishlist.VERSION_PROPERTY);
       return this;
    }


    public CustomerRequest rollUpToCustomer(){
       CustomerRequest customer = Q.customers().unlimited();
       this.withCustomerMatching(customer)
           .groupByCustomerWith(customer);
       return customer;
    }





   public WishlistRequest<T> facetByCustomerAs(String facetName, CustomerRequest customer){
       return facetByCustomerAs(facetName, customer, true);
   }

   public WishlistRequest<T> facetByCustomerAs(String facetName, CustomerRequest customer, boolean includeAllFacets){
       addFacet(facetName, Wishlist.CUSTOMER_PROPERTY, customer, includeAllFacets);
       return this;
   }


    /**
     * get topN records
     * @param topN  records number
     */
    public WishlistRequest<T> top(int topN) {
        super.top(topN);
        return this;
    }

    /**
     * get records from offset(inclusive) to offset+size(exclusive)
     * @param offset record offset
     * @param size records number
     */
    public WishlistRequest<T> offset(int offset, int size) {
        super.offset(offset, size);
        return this;
    }

    /**
     * retrieve all records
     */
    public WishlistRequest<T> unlimited() {
        super.unlimited();
        return this;
    }

    /**
     * get records of one page
     * @param pageNumber page number(1-based)
     * @param pageSize page size
     */
    public WishlistRequest<T> page(int pageNumber, int pageSize) {
        int offset = (pageNumber - 1) * pageSize;
        return offset(offset, pageSize);
   }

    /**
     * get records of one page, default page size is 10
     * @param pageNumber page number(1-based)
     */
    public WishlistRequest<T> page(int pageNumber) {
        return page(pageNumber, 10);
   }
}