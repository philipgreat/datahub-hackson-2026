
package com.example.enterpriseerpsystem.category;

import com.example.enterpriseerpsystem.Q;
import com.example.enterpriseerpsystem.product.Product;
import com.example.enterpriseerpsystem.product.ProductRequest;
import io.teaql.core.AggrFunction;
import io.teaql.core.BaseRequest;
import io.teaql.core.PropertyReference;
import io.teaql.core.SearchCriteria;
import io.teaql.core.SubQuerySearchCriteria;
import io.teaql.core.criteria.Operator;
import io.teaql.core.criteria.TwoOperatorCriteria;
import java.time.LocalDateTime;
import java.util.Date;

public class CategoryRequest<T extends Category> extends BaseRequest<T> {

    /**
     * @deprecated AI agents and business code must use the generated Q facade
     *             instead of constructing request builders directly.
     */
    @Deprecated
    public CategoryRequest(Class<T> returnType){
        super(returnType);
        selectId();
        selectVersion();
    }

    public CategoryRequest<T> comment(String comment){
         super.internalComment(comment);
         return this;
    }

    // purpose() 继承自 BaseRequest，返回 ExecutableRequest（终结方法）

    public CategoryRequest<T> returnType(Class<? extends T> returnType){
        super.setReturnType(returnType);
        return this;
    }

    public CategoryRequest<T> enableAggregationCache(long cacheExpiredMillis){
        super.enableAggregationCache();
        super.aggregateCacheTime(cacheExpiredMillis);
        return this;
    }

    public CategoryRequest<T> enableAggregationCache(){
        return enableAggregationCache(0l);
    }


    public CategoryRequest<T> propagateAggregationCache(long cacheExpiredMillis){
        super.propagateAggregationCache(cacheExpiredMillis);
        return this;
    }

    public CategoryRequest<T> appendSearchCriteria(SearchCriteria searchCriteria){
        return (CategoryRequest<T>)super.appendSearchCriteria(searchCriteria);
    }

    public CategoryRequest<T> filter(String property1, Operator operator, String property2){
        return appendSearchCriteria(new TwoOperatorCriteria(operator, new PropertyReference(property1), new PropertyReference(property2)));
    }


    public CategoryRequest<T> matchingAnyOf(CategoryRequest category){
        super.internalMatchAny(category);
        return this;
    }

    public CategoryRequest<T> enhanceChildrenIfNeeded(){
        return this;
    }

    public CategoryRequest<T> withDeletedRows(){
        super.withDeletedRows();
        return this;
    }

    public CategoryRequest<T> deletedRowsOnly(){
        super.deletedRowsOnly();
        return this;
    }

    public CategoryRequest<T> selectSelf(){
        super.selectSelf();
        return selectId().selectDescription().selectName().selectParentId().selectCreateTime().selectUpdateTime().selectVersion();
    }

    public CategoryRequest<T> selectSelfFields(){
        return selectSelf();
    }

    public CategoryRequest<T> selectAll(){
        super.selectAll();
        return selectId().selectDescription().selectName().selectParentId().selectCreateTime().selectUpdateTime().selectVersion();
    }

    public CategoryRequest<T> selectChildren(){
        super.selectAny();
        selectProductList();
        return selectId().selectDescription().selectName().selectParentId().selectCreateTime().selectUpdateTime().selectVersion();
    }


    public CategoryRequest<T> selectId(){
       selectProperty(Category.ID_PROPERTY);
       return this;
    }

    /**
     * fill the id with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  id) to fetch id property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public CategoryRequest<T> unselectId(){
       unselectProperty(Category.ID_PROPERTY);
       return this;
    }
    public CategoryRequest<T> selectDescription(){
       selectProperty(Category.DESCRIPTION_PROPERTY);
       return this;
    }

    /**
     * fill the description with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  description) to fetch description property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public CategoryRequest<T> unselectDescription(){
       unselectProperty(Category.DESCRIPTION_PROPERTY);
       return this;
    }
    public CategoryRequest<T> selectName(){
       selectProperty(Category.NAME_PROPERTY);
       return this;
    }

    /**
     * fill the name with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  name) to fetch name property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public CategoryRequest<T> unselectName(){
       unselectProperty(Category.NAME_PROPERTY);
       return this;
    }
    public CategoryRequest<T> selectParentId(){
       selectProperty(Category.PARENT_ID_PROPERTY);
       return this;
    }

    /**
     * fill the parentId with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  parentId) to fetch parentId property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public CategoryRequest<T> unselectParentId(){
       unselectProperty(Category.PARENT_ID_PROPERTY);
       return this;
    }
    public CategoryRequest<T> selectCreateTime(){
       selectProperty(Category.CREATE_TIME_PROPERTY);
       return this;
    }

    /**
     * fill the createTime with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  createTime) to fetch createTime property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public CategoryRequest<T> unselectCreateTime(){
       unselectProperty(Category.CREATE_TIME_PROPERTY);
       return this;
    }
    public CategoryRequest<T> selectUpdateTime(){
       selectProperty(Category.UPDATE_TIME_PROPERTY);
       return this;
    }

    /**
     * fill the updateTime with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  updateTime) to fetch updateTime property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public CategoryRequest<T> unselectUpdateTime(){
       unselectProperty(Category.UPDATE_TIME_PROPERTY);
       return this;
    }
    public CategoryRequest<T> selectVersion(){
       selectProperty(Category.VERSION_PROPERTY);
       return this;
    }

    /**
     * fill the version with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  version) to fetch version property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public CategoryRequest<T> unselectVersion(){
       unselectProperty(Category.VERSION_PROPERTY);
       return this;
    }
    public CategoryRequest<T> selectProductList(){
       return selectProductListWith(Q.products().selectSelf());
    }

    public CategoryRequest<T> selectProductListWith(ProductRequest productList){
       enhanceRelation(Category.PRODUCT_LIST_PROPERTY, productList);
       return this;
    }

    public CategoryRequest<T> withId(Operator operator, Object... values){
       return appendSearchCriteria(createIdCriteria(operator, values));
    }

    public SearchCriteria createIdCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Category.ID_PROPERTY, operator, values);
    }

    public CategoryRequest<T> withIdIs(Long id){
       return withId(Operator.EQUAL, id);
    }
    public CategoryRequest<T> withIdIn(Long... id){
       return withId(Operator.EQUAL, (Object[])id);
    }



    public CategoryRequest<T> filterByDescription(String... description){
      if (description == null || description.length == 0) {
        throw new IllegalArgumentException("filterByDescription parameter description cannot be empty");
      }
      return appendSearchCriteria(createDescriptionCriteria(Operator.EQUAL, (Object[])description));
    }

    public CategoryRequest<T> withDescription(Operator operator, Object... values){
       return appendSearchCriteria(createDescriptionCriteria(operator, values));
    }

    public CategoryRequest<T> withDescriptionIsUnknown(){
       return withDescription(Operator.IS_NULL);
    }

    public CategoryRequest<T> withDescriptionIsKnown(){
       return withDescription(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createDescriptionCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Category.DESCRIPTION_PROPERTY, operator, values);
    }

    public CategoryRequest<T> withDescriptionGreaterThan(String description){
       return withDescription(Operator.GREATER_THAN, description);
    }

    public CategoryRequest<T> withDescriptionGreaterThanOrEqualTo(String description){
       return withDescription(Operator.GREATER_THAN_OR_EQUAL, description);
    }

    public CategoryRequest<T> withDescriptionLessThan(String description){
       return withDescription(Operator.LESS_THAN, description);
    }

    public CategoryRequest<T> withDescriptionLessThanOrEqualTo(String description){
       return withDescription(Operator.LESS_THAN_OR_EQUAL, description);
    }

    public CategoryRequest<T> withDescriptionBetween(String startOfDescription, String endOfDescription){
       return withDescription(Operator.BETWEEN, startOfDescription, endOfDescription);
    }
    public CategoryRequest<T> withDescriptionStartingWith(String description){
       return withDescription(Operator.BEGIN_WITH, description);
    }
    public CategoryRequest<T> withDescriptionContaining(String description){
       return withDescription(Operator.CONTAIN, description);
    }

    public CategoryRequest<T> withDescriptionEndingWith(String description){
       return withDescription(Operator.END_WITH, description);
    }

    public CategoryRequest<T> withDescriptionIs(String description){
       return withDescription(Operator.EQUAL, description);
    }

    public CategoryRequest<T> withDescriptionSoundingLike(String description){
       return withDescription(Operator.SOUNDS_LIKE, description);
    }



    public CategoryRequest<T> filterByName(String... name){
      if (name == null || name.length == 0) {
        throw new IllegalArgumentException("filterByName parameter name cannot be empty");
      }
      return appendSearchCriteria(createNameCriteria(Operator.EQUAL, (Object[])name));
    }

    public CategoryRequest<T> withName(Operator operator, Object... values){
       return appendSearchCriteria(createNameCriteria(operator, values));
    }

    public CategoryRequest<T> withNameIsUnknown(){
       return withName(Operator.IS_NULL);
    }

    public CategoryRequest<T> withNameIsKnown(){
       return withName(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createNameCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Category.NAME_PROPERTY, operator, values);
    }

    public CategoryRequest<T> withNameGreaterThan(String name){
       return withName(Operator.GREATER_THAN, name);
    }

    public CategoryRequest<T> withNameGreaterThanOrEqualTo(String name){
       return withName(Operator.GREATER_THAN_OR_EQUAL, name);
    }

    public CategoryRequest<T> withNameLessThan(String name){
       return withName(Operator.LESS_THAN, name);
    }

    public CategoryRequest<T> withNameLessThanOrEqualTo(String name){
       return withName(Operator.LESS_THAN_OR_EQUAL, name);
    }

    public CategoryRequest<T> withNameBetween(String startOfName, String endOfName){
       return withName(Operator.BETWEEN, startOfName, endOfName);
    }
    public CategoryRequest<T> withNameStartingWith(String name){
       return withName(Operator.BEGIN_WITH, name);
    }
    public CategoryRequest<T> withNameContaining(String name){
       return withName(Operator.CONTAIN, name);
    }

    public CategoryRequest<T> withNameEndingWith(String name){
       return withName(Operator.END_WITH, name);
    }

    public CategoryRequest<T> withNameIs(String name){
       return withName(Operator.EQUAL, name);
    }

    public CategoryRequest<T> withNameSoundingLike(String name){
       return withName(Operator.SOUNDS_LIKE, name);
    }



    public CategoryRequest<T> filterByParentId(String... parentId){
      if (parentId == null || parentId.length == 0) {
        throw new IllegalArgumentException("filterByParentId parameter parentId cannot be empty");
      }
      return appendSearchCriteria(createParentIdCriteria(Operator.EQUAL, (Object[])parentId));
    }

    public CategoryRequest<T> withParentId(Operator operator, Object... values){
       return appendSearchCriteria(createParentIdCriteria(operator, values));
    }

    public CategoryRequest<T> withParentIdIsUnknown(){
       return withParentId(Operator.IS_NULL);
    }

    public CategoryRequest<T> withParentIdIsKnown(){
       return withParentId(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createParentIdCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Category.PARENT_ID_PROPERTY, operator, values);
    }

    public CategoryRequest<T> withParentIdGreaterThan(String parentId){
       return withParentId(Operator.GREATER_THAN, parentId);
    }

    public CategoryRequest<T> withParentIdGreaterThanOrEqualTo(String parentId){
       return withParentId(Operator.GREATER_THAN_OR_EQUAL, parentId);
    }

    public CategoryRequest<T> withParentIdLessThan(String parentId){
       return withParentId(Operator.LESS_THAN, parentId);
    }

    public CategoryRequest<T> withParentIdLessThanOrEqualTo(String parentId){
       return withParentId(Operator.LESS_THAN_OR_EQUAL, parentId);
    }

    public CategoryRequest<T> withParentIdBetween(String startOfParentId, String endOfParentId){
       return withParentId(Operator.BETWEEN, startOfParentId, endOfParentId);
    }
    public CategoryRequest<T> withParentIdStartingWith(String parentId){
       return withParentId(Operator.BEGIN_WITH, parentId);
    }
    public CategoryRequest<T> withParentIdContaining(String parentId){
       return withParentId(Operator.CONTAIN, parentId);
    }

    public CategoryRequest<T> withParentIdEndingWith(String parentId){
       return withParentId(Operator.END_WITH, parentId);
    }

    public CategoryRequest<T> withParentIdIs(String parentId){
       return withParentId(Operator.EQUAL, parentId);
    }

    public CategoryRequest<T> withParentIdSoundingLike(String parentId){
       return withParentId(Operator.SOUNDS_LIKE, parentId);
    }



    public CategoryRequest<T> filterByCreateTime(LocalDateTime... createTime){
      if (createTime == null || createTime.length == 0) {
        throw new IllegalArgumentException("filterByCreateTime parameter createTime cannot be empty");
      }
      return appendSearchCriteria(createCreateTimeCriteria(Operator.EQUAL, (Object[])createTime));
    }

    public CategoryRequest<T> withCreateTime(Operator operator, Object... values){
       return appendSearchCriteria(createCreateTimeCriteria(operator, values));
    }

    public CategoryRequest<T> withCreateTimeIsUnknown(){
       return withCreateTime(Operator.IS_NULL);
    }

    public CategoryRequest<T> withCreateTimeIsKnown(){
       return withCreateTime(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createCreateTimeCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Category.CREATE_TIME_PROPERTY, operator, values);
    }

    public CategoryRequest<T> withCreateTimeGreaterThan(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public CategoryRequest<T> withCreateTimeGreaterThanOrEqualTo(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN_OR_EQUAL, createTime);
    }

    public CategoryRequest<T> withCreateTimeLessThan(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public CategoryRequest<T> withCreateTimeLessThanOrEqualTo(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN_OR_EQUAL, createTime);
    }

    public CategoryRequest<T> withCreateTimeBetween(LocalDateTime startOfCreateTime, LocalDateTime endOfCreateTime){
       return withCreateTime(Operator.BETWEEN, startOfCreateTime, endOfCreateTime);
    }
    public CategoryRequest<T> withCreateTimeBefore(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public CategoryRequest<T> withCreateTimeBefore(Date createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public CategoryRequest<T> withCreateTimeAfter(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public CategoryRequest<T> withCreateTimeAfter(Date createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public CategoryRequest<T> withCreateTimeBetween(Date startOfCreateTime, Date endOfCreateTime){
       return withCreateTime(Operator.BETWEEN, startOfCreateTime, endOfCreateTime);
    }




    public CategoryRequest<T> filterByUpdateTime(LocalDateTime... updateTime){
      if (updateTime == null || updateTime.length == 0) {
        throw new IllegalArgumentException("filterByUpdateTime parameter updateTime cannot be empty");
      }
      return appendSearchCriteria(createUpdateTimeCriteria(Operator.EQUAL, (Object[])updateTime));
    }

    public CategoryRequest<T> withUpdateTime(Operator operator, Object... values){
       return appendSearchCriteria(createUpdateTimeCriteria(operator, values));
    }

    public CategoryRequest<T> withUpdateTimeIsUnknown(){
       return withUpdateTime(Operator.IS_NULL);
    }

    public CategoryRequest<T> withUpdateTimeIsKnown(){
       return withUpdateTime(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createUpdateTimeCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Category.UPDATE_TIME_PROPERTY, operator, values);
    }

    public CategoryRequest<T> withUpdateTimeGreaterThan(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public CategoryRequest<T> withUpdateTimeGreaterThanOrEqualTo(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN_OR_EQUAL, updateTime);
    }

    public CategoryRequest<T> withUpdateTimeLessThan(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public CategoryRequest<T> withUpdateTimeLessThanOrEqualTo(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN_OR_EQUAL, updateTime);
    }

    public CategoryRequest<T> withUpdateTimeBetween(LocalDateTime startOfUpdateTime, LocalDateTime endOfUpdateTime){
       return withUpdateTime(Operator.BETWEEN, startOfUpdateTime, endOfUpdateTime);
    }
    public CategoryRequest<T> withUpdateTimeBefore(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public CategoryRequest<T> withUpdateTimeBefore(Date updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public CategoryRequest<T> withUpdateTimeAfter(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public CategoryRequest<T> withUpdateTimeAfter(Date updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public CategoryRequest<T> withUpdateTimeBetween(Date startOfUpdateTime, Date endOfUpdateTime){
       return withUpdateTime(Operator.BETWEEN, startOfUpdateTime, endOfUpdateTime);
    }




    public CategoryRequest<T> filterByVersion(Long... version){
      if (version == null || version.length == 0) {
        throw new IllegalArgumentException("filterByVersion parameter version cannot be empty");
      }
      return appendSearchCriteria(createVersionCriteria(Operator.EQUAL, (Object[])version));
    }

    public CategoryRequest<T> withVersion(Operator operator, Object... values){
       return appendSearchCriteria(createVersionCriteria(operator, values));
    }

    public CategoryRequest<T> withVersionIsUnknown(){
       return withVersion(Operator.IS_NULL);
    }

    public CategoryRequest<T> withVersionIsKnown(){
       return withVersion(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createVersionCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Category.VERSION_PROPERTY, operator, values);
    }

    public CategoryRequest<T> withVersionGreaterThan(Long version){
       return withVersion(Operator.GREATER_THAN, version);
    }

    public CategoryRequest<T> withVersionGreaterThanOrEqualTo(Long version){
       return withVersion(Operator.GREATER_THAN_OR_EQUAL, version);
    }

    public CategoryRequest<T> withVersionLessThan(Long version){
       return withVersion(Operator.LESS_THAN, version);
    }

    public CategoryRequest<T> withVersionLessThanOrEqualTo(Long version){
       return withVersion(Operator.LESS_THAN_OR_EQUAL, version);
    }

    public CategoryRequest<T> withVersionBetween(Long startOfVersion, Long endOfVersion){
       return withVersion(Operator.BETWEEN, startOfVersion, endOfVersion);
    }

    public CategoryRequest<T> withProductListMatching(ProductRequest productRequest){
        return appendSearchCriteria(new SubQuerySearchCriteria(Category.ID_PROPERTY, productRequest, Product.CATEGORY_PROPERTY));
    }

    public CategoryRequest<T> withoutProductListMatching(ProductRequest productRequest){
        return appendSearchCriteria(SearchCriteria.not(new SubQuerySearchCriteria(Category.ID_PROPERTY, productRequest, Product.CATEGORY_PROPERTY)));
    }

    public CategoryRequest<T> haveProducts(){
        return withProductListMatching(Q.products().unlimited());
    }

    public CategoryRequest<T> haveNoProducts(){
        return withoutProductListMatching(Q.products().unlimited());
    }

    public CategoryRequest<T> count(){
        super.count();
        return this;
    }
    public CategoryRequest<T> countAs(String retName){
        super.count(retName);
        return this;
    }
    public CategoryRequest<T> groupByProductsWithDetails(ProductRequest subRequest){
       aggregate(Category.PRODUCT_LIST_PROPERTY, subRequest);
       return this;
    }

    public CategoryRequest<T> groupById(){
       groupBy(Category.ID_PROPERTY);
       return this;
    }

    public CategoryRequest<T> groupByIdAs(String retName){
       groupBy(retName, Category.ID_PROPERTY);
       return this;
    }

    public CategoryRequest<T> groupByIdWithFunction(String retName, AggrFunction function){
       groupBy(retName, Category.ID_PROPERTY, function);
       return this;
    }

    public CategoryRequest<T> groupByDescription(){
       groupBy(Category.DESCRIPTION_PROPERTY);
       return this;
    }

    public CategoryRequest<T> groupByDescriptionAs(String retName){
       groupBy(retName, Category.DESCRIPTION_PROPERTY);
       return this;
    }

    public CategoryRequest<T> groupByDescriptionWithFunction(String retName, AggrFunction function){
       groupBy(retName, Category.DESCRIPTION_PROPERTY, function);
       return this;
    }

    public CategoryRequest<T> groupByName(){
       groupBy(Category.NAME_PROPERTY);
       return this;
    }

    public CategoryRequest<T> groupByNameAs(String retName){
       groupBy(retName, Category.NAME_PROPERTY);
       return this;
    }

    public CategoryRequest<T> groupByNameWithFunction(String retName, AggrFunction function){
       groupBy(retName, Category.NAME_PROPERTY, function);
       return this;
    }

    public CategoryRequest<T> groupByParentId(){
       groupBy(Category.PARENT_ID_PROPERTY);
       return this;
    }

    public CategoryRequest<T> groupByParentIdAs(String retName){
       groupBy(retName, Category.PARENT_ID_PROPERTY);
       return this;
    }

    public CategoryRequest<T> groupByParentIdWithFunction(String retName, AggrFunction function){
       groupBy(retName, Category.PARENT_ID_PROPERTY, function);
       return this;
    }

    public CategoryRequest<T> groupByCreateTime(){
       groupBy(Category.CREATE_TIME_PROPERTY);
       return this;
    }

    public CategoryRequest<T> groupByCreateTimeAs(String retName){
       groupBy(retName, Category.CREATE_TIME_PROPERTY);
       return this;
    }

    public CategoryRequest<T> groupByCreateTimeWithFunction(String retName, AggrFunction function){
       groupBy(retName, Category.CREATE_TIME_PROPERTY, function);
       return this;
    }

    public CategoryRequest<T> groupByUpdateTime(){
       groupBy(Category.UPDATE_TIME_PROPERTY);
       return this;
    }

    public CategoryRequest<T> groupByUpdateTimeAs(String retName){
       groupBy(retName, Category.UPDATE_TIME_PROPERTY);
       return this;
    }

    public CategoryRequest<T> groupByUpdateTimeWithFunction(String retName, AggrFunction function){
       groupBy(retName, Category.UPDATE_TIME_PROPERTY, function);
       return this;
    }

    public CategoryRequest<T> groupByVersion(){
       groupBy(Category.VERSION_PROPERTY);
       return this;
    }

    public CategoryRequest<T> groupByVersionAs(String retName){
       groupBy(retName, Category.VERSION_PROPERTY);
       return this;
    }

    public CategoryRequest<T> groupByVersionWithFunction(String retName, AggrFunction function){
       groupBy(retName, Category.VERSION_PROPERTY, function);
       return this;
    }



    public CategoryRequest<T> orderByIdAscending(){
       addOrderByAscending(Category.ID_PROPERTY);
       return this;
    }

    public CategoryRequest<T> orderByIdDescending(){
       addOrderByDescending(Category.ID_PROPERTY);
       return this;
    }

    public CategoryRequest<T> orderByDescriptionAscending(){
       addOrderByAscending(Category.DESCRIPTION_PROPERTY);
       return this;
    }

    public CategoryRequest<T> orderByDescriptionDescending(){
       addOrderByDescending(Category.DESCRIPTION_PROPERTY);
       return this;
    }
    public CategoryRequest<T> orderByDescriptionAscendingUsingGBK(){
       addOrderByAscendingUsingGBK(Category.DESCRIPTION_PROPERTY);
       return this;
    }

    public CategoryRequest<T> orderByDescriptionDescendingUsingGBK(){
       addOrderByDescendingUsingGBK(Category.DESCRIPTION_PROPERTY);
       return this;
    }
    public CategoryRequest<T> orderByNameAscending(){
       addOrderByAscending(Category.NAME_PROPERTY);
       return this;
    }

    public CategoryRequest<T> orderByNameDescending(){
       addOrderByDescending(Category.NAME_PROPERTY);
       return this;
    }
    public CategoryRequest<T> orderByNameAscendingUsingGBK(){
       addOrderByAscendingUsingGBK(Category.NAME_PROPERTY);
       return this;
    }

    public CategoryRequest<T> orderByNameDescendingUsingGBK(){
       addOrderByDescendingUsingGBK(Category.NAME_PROPERTY);
       return this;
    }
    public CategoryRequest<T> orderByParentIdAscending(){
       addOrderByAscending(Category.PARENT_ID_PROPERTY);
       return this;
    }

    public CategoryRequest<T> orderByParentIdDescending(){
       addOrderByDescending(Category.PARENT_ID_PROPERTY);
       return this;
    }
    public CategoryRequest<T> orderByParentIdAscendingUsingGBK(){
       addOrderByAscendingUsingGBK(Category.PARENT_ID_PROPERTY);
       return this;
    }

    public CategoryRequest<T> orderByParentIdDescendingUsingGBK(){
       addOrderByDescendingUsingGBK(Category.PARENT_ID_PROPERTY);
       return this;
    }
    public CategoryRequest<T> orderByCreateTimeAscending(){
       addOrderByAscending(Category.CREATE_TIME_PROPERTY);
       return this;
    }

    public CategoryRequest<T> orderByCreateTimeDescending(){
       addOrderByDescending(Category.CREATE_TIME_PROPERTY);
       return this;
    }

    public CategoryRequest<T> orderByUpdateTimeAscending(){
       addOrderByAscending(Category.UPDATE_TIME_PROPERTY);
       return this;
    }

    public CategoryRequest<T> orderByUpdateTimeDescending(){
       addOrderByDescending(Category.UPDATE_TIME_PROPERTY);
       return this;
    }

    public CategoryRequest<T> orderByVersionAscending(){
       addOrderByAscending(Category.VERSION_PROPERTY);
       return this;
    }

    public CategoryRequest<T> orderByVersionDescending(){
       addOrderByDescending(Category.VERSION_PROPERTY);
       return this;
    }


    public CategoryRequest<T> statsFromProductsAs(String name, ProductRequest subRequest){
       return statsFromProductsAs(name, subRequest, false);
    }

    public CategoryRequest<T> statsFromProductsAs(String name, ProductRequest subRequest, boolean singleResult){
       subRequest.setPartitionProperty(Product.CATEGORY_PROPERTY);
       addAggregateDynamicProperty(name, subRequest, singleResult);
       return this;
    }

    public CategoryRequest<T> statsFromProducts(ProductRequest subRequest){
       return statsFromProductsAs(REFINEMENTS, subRequest);
    }
    public CategoryRequest<T> countProducts(){
        return countProductsAs("Count");
    }

    public CategoryRequest<T> countProductsAs(String name){
        return countProductsWith(name, Q.products().unlimited());
    }

    public CategoryRequest<T> countProductsWith(String name, ProductRequest subRequest){
        return statsFromProductsAs(name, subRequest.count(), true);
    }
    public CategoryRequest<T> minPriceOfProducts(){
        return minPriceOfProductsAs("minPriceOfProducts");
    }

    public CategoryRequest<T> minPriceOfProductsAs(String name){
        return minPriceOfProductsAs(name, Q.products().unlimited());
    }

    public CategoryRequest<T> minPriceOfProductsAs(String name, ProductRequest subRequest){
        return statsFromProductsAs(name, subRequest.minPrice(), true);
    }
    public CategoryRequest<T> maxPriceOfProducts(){
        return maxPriceOfProductsAs("maxPriceOfProducts");
    }

    public CategoryRequest<T> maxPriceOfProductsAs(String name){
        return maxPriceOfProductsAs(name, Q.products().unlimited());
    }

    public CategoryRequest<T> maxPriceOfProductsAs(String name, ProductRequest subRequest){
        return statsFromProductsAs(name, subRequest.maxPrice(), true);
    }
    public CategoryRequest<T> sumPriceOfProducts(){
        return sumPriceOfProductsAs("sumPriceOfProducts");
    }

    public CategoryRequest<T> sumPriceOfProductsAs(String name){
        return sumPriceOfProductsAs(name, Q.products().unlimited());
    }

    public CategoryRequest<T> sumPriceOfProductsAs(String name, ProductRequest subRequest){
        return statsFromProductsAs(name, subRequest.sumPrice(), true);
    }
    public CategoryRequest<T> avgPriceOfProducts(){
        return avgPriceOfProductsAs("avgPriceOfProducts");
    }

    public CategoryRequest<T> avgPriceOfProductsAs(String name){
        return avgPriceOfProductsAs(name, Q.products().unlimited());
    }

    public CategoryRequest<T> avgPriceOfProductsAs(String name, ProductRequest subRequest){
        return statsFromProductsAs(name, subRequest.avgPrice(), true);
    }
    public CategoryRequest<T> standardDeviationPriceOfProducts(){
        return standardDeviationPriceOfProductsAs("stdDevPriceOfProducts");
    }

    public CategoryRequest<T> standardDeviationPriceOfProductsAs(String name){
        return standardDeviationPriceOfProductsAs(name, Q.products().unlimited());
    }

    public CategoryRequest<T> standardDeviationPriceOfProductsAs(String name, ProductRequest subRequest){
        return statsFromProductsAs(name, subRequest.standardDeviationPrice(), true);
    }
    public CategoryRequest<T> squareRootOfPopulationStandardDeviationPriceOfProducts(){
        return squareRootOfPopulationStandardDeviationPriceOfProductsAs("stdDevPopPriceOfProducts");
    }

    public CategoryRequest<T> squareRootOfPopulationStandardDeviationPriceOfProductsAs(String name){
        return squareRootOfPopulationStandardDeviationPriceOfProductsAs(name, Q.products().unlimited());
    }

    public CategoryRequest<T> squareRootOfPopulationStandardDeviationPriceOfProductsAs(String name, ProductRequest subRequest){
        return statsFromProductsAs(name, subRequest.squareRootOfPopulationStandardDeviationPrice(), true);
    }
    public CategoryRequest<T> sampleVariancePriceOfProducts(){
        return sampleVariancePriceOfProductsAs("varSampPriceOfProducts");
    }

    public CategoryRequest<T> sampleVariancePriceOfProductsAs(String name){
        return sampleVariancePriceOfProductsAs(name, Q.products().unlimited());
    }

    public CategoryRequest<T> sampleVariancePriceOfProductsAs(String name, ProductRequest subRequest){
        return statsFromProductsAs(name, subRequest.sampleVariancePrice(), true);
    }
    public CategoryRequest<T> samplePopulationVariancePriceOfProducts(){
        return samplePopulationVariancePriceOfProductsAs("varPopPriceOfProducts");
    }

    public CategoryRequest<T> samplePopulationVariancePriceOfProductsAs(String name){
        return samplePopulationVariancePriceOfProductsAs(name, Q.products().unlimited());
    }

    public CategoryRequest<T> samplePopulationVariancePriceOfProductsAs(String name, ProductRequest subRequest){
        return statsFromProductsAs(name, subRequest.samplePopulationVariancePrice(), true);
    }
    public CategoryRequest<T> minCostOfProducts(){
        return minCostOfProductsAs("minCostOfProducts");
    }

    public CategoryRequest<T> minCostOfProductsAs(String name){
        return minCostOfProductsAs(name, Q.products().unlimited());
    }

    public CategoryRequest<T> minCostOfProductsAs(String name, ProductRequest subRequest){
        return statsFromProductsAs(name, subRequest.minCost(), true);
    }
    public CategoryRequest<T> maxCostOfProducts(){
        return maxCostOfProductsAs("maxCostOfProducts");
    }

    public CategoryRequest<T> maxCostOfProductsAs(String name){
        return maxCostOfProductsAs(name, Q.products().unlimited());
    }

    public CategoryRequest<T> maxCostOfProductsAs(String name, ProductRequest subRequest){
        return statsFromProductsAs(name, subRequest.maxCost(), true);
    }
    public CategoryRequest<T> sumCostOfProducts(){
        return sumCostOfProductsAs("sumCostOfProducts");
    }

    public CategoryRequest<T> sumCostOfProductsAs(String name){
        return sumCostOfProductsAs(name, Q.products().unlimited());
    }

    public CategoryRequest<T> sumCostOfProductsAs(String name, ProductRequest subRequest){
        return statsFromProductsAs(name, subRequest.sumCost(), true);
    }
    public CategoryRequest<T> avgCostOfProducts(){
        return avgCostOfProductsAs("avgCostOfProducts");
    }

    public CategoryRequest<T> avgCostOfProductsAs(String name){
        return avgCostOfProductsAs(name, Q.products().unlimited());
    }

    public CategoryRequest<T> avgCostOfProductsAs(String name, ProductRequest subRequest){
        return statsFromProductsAs(name, subRequest.avgCost(), true);
    }
    public CategoryRequest<T> standardDeviationCostOfProducts(){
        return standardDeviationCostOfProductsAs("stdDevCostOfProducts");
    }

    public CategoryRequest<T> standardDeviationCostOfProductsAs(String name){
        return standardDeviationCostOfProductsAs(name, Q.products().unlimited());
    }

    public CategoryRequest<T> standardDeviationCostOfProductsAs(String name, ProductRequest subRequest){
        return statsFromProductsAs(name, subRequest.standardDeviationCost(), true);
    }
    public CategoryRequest<T> squareRootOfPopulationStandardDeviationCostOfProducts(){
        return squareRootOfPopulationStandardDeviationCostOfProductsAs("stdDevPopCostOfProducts");
    }

    public CategoryRequest<T> squareRootOfPopulationStandardDeviationCostOfProductsAs(String name){
        return squareRootOfPopulationStandardDeviationCostOfProductsAs(name, Q.products().unlimited());
    }

    public CategoryRequest<T> squareRootOfPopulationStandardDeviationCostOfProductsAs(String name, ProductRequest subRequest){
        return statsFromProductsAs(name, subRequest.squareRootOfPopulationStandardDeviationCost(), true);
    }
    public CategoryRequest<T> sampleVarianceCostOfProducts(){
        return sampleVarianceCostOfProductsAs("varSampCostOfProducts");
    }

    public CategoryRequest<T> sampleVarianceCostOfProductsAs(String name){
        return sampleVarianceCostOfProductsAs(name, Q.products().unlimited());
    }

    public CategoryRequest<T> sampleVarianceCostOfProductsAs(String name, ProductRequest subRequest){
        return statsFromProductsAs(name, subRequest.sampleVarianceCost(), true);
    }
    public CategoryRequest<T> samplePopulationVarianceCostOfProducts(){
        return samplePopulationVarianceCostOfProductsAs("varPopCostOfProducts");
    }

    public CategoryRequest<T> samplePopulationVarianceCostOfProductsAs(String name){
        return samplePopulationVarianceCostOfProductsAs(name, Q.products().unlimited());
    }

    public CategoryRequest<T> samplePopulationVarianceCostOfProductsAs(String name, ProductRequest subRequest){
        return statsFromProductsAs(name, subRequest.samplePopulationVarianceCost(), true);
    }
    public CategoryRequest<T> minStockOfProducts(){
        return minStockOfProductsAs("minStockOfProducts");
    }

    public CategoryRequest<T> minStockOfProductsAs(String name){
        return minStockOfProductsAs(name, Q.products().unlimited());
    }

    public CategoryRequest<T> minStockOfProductsAs(String name, ProductRequest subRequest){
        return statsFromProductsAs(name, subRequest.minStock(), true);
    }
    public CategoryRequest<T> maxStockOfProducts(){
        return maxStockOfProductsAs("maxStockOfProducts");
    }

    public CategoryRequest<T> maxStockOfProductsAs(String name){
        return maxStockOfProductsAs(name, Q.products().unlimited());
    }

    public CategoryRequest<T> maxStockOfProductsAs(String name, ProductRequest subRequest){
        return statsFromProductsAs(name, subRequest.maxStock(), true);
    }
    public CategoryRequest<T> sumStockOfProducts(){
        return sumStockOfProductsAs("sumStockOfProducts");
    }

    public CategoryRequest<T> sumStockOfProductsAs(String name){
        return sumStockOfProductsAs(name, Q.products().unlimited());
    }

    public CategoryRequest<T> sumStockOfProductsAs(String name, ProductRequest subRequest){
        return statsFromProductsAs(name, subRequest.sumStock(), true);
    }
    public CategoryRequest<T> avgStockOfProducts(){
        return avgStockOfProductsAs("avgStockOfProducts");
    }

    public CategoryRequest<T> avgStockOfProductsAs(String name){
        return avgStockOfProductsAs(name, Q.products().unlimited());
    }

    public CategoryRequest<T> avgStockOfProductsAs(String name, ProductRequest subRequest){
        return statsFromProductsAs(name, subRequest.avgStock(), true);
    }
    public CategoryRequest<T> standardDeviationStockOfProducts(){
        return standardDeviationStockOfProductsAs("stdDevStockOfProducts");
    }

    public CategoryRequest<T> standardDeviationStockOfProductsAs(String name){
        return standardDeviationStockOfProductsAs(name, Q.products().unlimited());
    }

    public CategoryRequest<T> standardDeviationStockOfProductsAs(String name, ProductRequest subRequest){
        return statsFromProductsAs(name, subRequest.standardDeviationStock(), true);
    }
    public CategoryRequest<T> squareRootOfPopulationStandardDeviationStockOfProducts(){
        return squareRootOfPopulationStandardDeviationStockOfProductsAs("stdDevPopStockOfProducts");
    }

    public CategoryRequest<T> squareRootOfPopulationStandardDeviationStockOfProductsAs(String name){
        return squareRootOfPopulationStandardDeviationStockOfProductsAs(name, Q.products().unlimited());
    }

    public CategoryRequest<T> squareRootOfPopulationStandardDeviationStockOfProductsAs(String name, ProductRequest subRequest){
        return statsFromProductsAs(name, subRequest.squareRootOfPopulationStandardDeviationStock(), true);
    }
    public CategoryRequest<T> sampleVarianceStockOfProducts(){
        return sampleVarianceStockOfProductsAs("varSampStockOfProducts");
    }

    public CategoryRequest<T> sampleVarianceStockOfProductsAs(String name){
        return sampleVarianceStockOfProductsAs(name, Q.products().unlimited());
    }

    public CategoryRequest<T> sampleVarianceStockOfProductsAs(String name, ProductRequest subRequest){
        return statsFromProductsAs(name, subRequest.sampleVarianceStock(), true);
    }
    public CategoryRequest<T> samplePopulationVarianceStockOfProducts(){
        return samplePopulationVarianceStockOfProductsAs("varPopStockOfProducts");
    }

    public CategoryRequest<T> samplePopulationVarianceStockOfProductsAs(String name){
        return samplePopulationVarianceStockOfProductsAs(name, Q.products().unlimited());
    }

    public CategoryRequest<T> samplePopulationVarianceStockOfProductsAs(String name, ProductRequest subRequest){
        return statsFromProductsAs(name, subRequest.samplePopulationVarianceStock(), true);
    }



    /**
     * get topN records
     * @param topN  records number
     */
    public CategoryRequest<T> top(int topN) {
        super.top(topN);
        return this;
    }

    /**
     * get records from offset(inclusive) to offset+size(exclusive)
     * @param offset record offset
     * @param size records number
     */
    public CategoryRequest<T> offset(int offset, int size) {
        super.offset(offset, size);
        return this;
    }

    /**
     * retrieve all records
     */
    public CategoryRequest<T> unlimited() {
        super.unlimited();
        return this;
    }

    /**
     * get records of one page
     * @param pageNumber page number(1-based)
     * @param pageSize page size
     */
    public CategoryRequest<T> page(int pageNumber, int pageSize) {
        int offset = (pageNumber - 1) * pageSize;
        return offset(offset, pageSize);
   }

    /**
     * get records of one page, default page size is 10
     * @param pageNumber page number(1-based)
     */
    public CategoryRequest<T> page(int pageNumber) {
        return page(pageNumber, 10);
   }
}