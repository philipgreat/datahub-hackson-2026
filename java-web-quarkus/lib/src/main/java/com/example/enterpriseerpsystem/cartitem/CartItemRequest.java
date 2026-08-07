
package com.example.enterpriseerpsystem.cartitem;

import com.example.enterpriseerpsystem.Q;
import com.example.enterpriseerpsystem.product.Product;
import com.example.enterpriseerpsystem.product.ProductRequest;
import com.example.enterpriseerpsystem.shoppingcart.ShoppingCart;
import com.example.enterpriseerpsystem.shoppingcart.ShoppingCartRequest;
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

public class CartItemRequest<T extends CartItem> extends BaseRequest<T> {

    /**
     * @deprecated AI agents and business code must use the generated Q facade
     *             instead of constructing request builders directly.
     */
    @Deprecated
    public CartItemRequest(Class<T> returnType){
        super(returnType);
        selectId();
        selectVersion();
    }

    public CartItemRequest<T> comment(String comment){
         super.internalComment(comment);
         return this;
    }

    // purpose() 继承自 BaseRequest，返回 ExecutableRequest（终结方法）

    public CartItemRequest<T> returnType(Class<? extends T> returnType){
        super.setReturnType(returnType);
        return this;
    }

    public CartItemRequest<T> enableAggregationCache(long cacheExpiredMillis){
        super.enableAggregationCache();
        super.aggregateCacheTime(cacheExpiredMillis);
        return this;
    }

    public CartItemRequest<T> enableAggregationCache(){
        return enableAggregationCache(0l);
    }


    public CartItemRequest<T> propagateAggregationCache(long cacheExpiredMillis){
        super.propagateAggregationCache(cacheExpiredMillis);
        return this;
    }

    public CartItemRequest<T> appendSearchCriteria(SearchCriteria searchCriteria){
        return (CartItemRequest<T>)super.appendSearchCriteria(searchCriteria);
    }

    public CartItemRequest<T> filter(String property1, Operator operator, String property2){
        return appendSearchCriteria(new TwoOperatorCriteria(operator, new PropertyReference(property1), new PropertyReference(property2)));
    }


    public CartItemRequest<T> matchingAnyOf(CartItemRequest cartItem){
        super.internalMatchAny(cartItem);
        return this;
    }

    public CartItemRequest<T> enhanceChildrenIfNeeded(){
        return this;
    }

    public CartItemRequest<T> withDeletedRows(){
        super.withDeletedRows();
        return this;
    }

    public CartItemRequest<T> deletedRowsOnly(){
        super.deletedRowsOnly();
        return this;
    }

    public CartItemRequest<T> selectSelf(){
        super.selectSelf();
        return selectId().selectProductIdOnly().selectQuantity().selectShoppingCartIdOnly().selectCreateTime().selectUpdateTime().selectVersion();
    }

    public CartItemRequest<T> selectSelfFields(){
        return selectSelf();
    }

    public CartItemRequest<T> selectAll(){
        super.selectAll();
        return selectId().selectProduct().selectQuantity().selectShoppingCart().selectCreateTime().selectUpdateTime().selectVersion();
    }

    public CartItemRequest<T> selectChildren(){
        super.selectAny();
        return selectId().selectProduct().selectQuantity().selectShoppingCart().selectCreateTime().selectUpdateTime().selectVersion();
    }


    public CartItemRequest<T> selectId(){
       selectProperty(CartItem.ID_PROPERTY);
       return this;
    }

    /**
     * fill the id with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  id) to fetch id property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public CartItemRequest<T> unselectId(){
       unselectProperty(CartItem.ID_PROPERTY);
       return this;
    }
    public CartItemRequest<T> selectProductIdOnly(){
       selectProperty(CartItem.PRODUCT_PROPERTY);
       return this;
    }

    public CartItemRequest<T> selectProduct(){
        return selectProductWith(Q.products().unlimited().selectSelf());
    }

    public CartItemRequest<T> selectProductWith(ProductRequest product){
       selectProperty(CartItem.PRODUCT_PROPERTY);
       enhanceRelation(CartItem.PRODUCT_PROPERTY, product);
       return this;
    }

    public CartItemRequest<T> unselectProduct(){
       unselectProperty(CartItem.PRODUCT_PROPERTY);
       return this;
    }
    public CartItemRequest<T> selectQuantity(){
       selectProperty(CartItem.QUANTITY_PROPERTY);
       return this;
    }

    /**
     * fill the quantity with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  quantity) to fetch quantity property.
     * @param rawSqlSegment  customized rawSqlSegment
     */


    /**
     * fill the quantity with customized aggrFunction, TEAQL uses ({aggrFunction}(quantity) AS quantity to fetch quantity property.
     * @param aggrFunction  aggrFunction
     */
    public CartItemRequest<T> selectQuantity(AggrFunction aggrFunction){
       selectProperty(CartItem.QUANTITY_PROPERTY, aggrFunction);
       return this;
    }


    public CartItemRequest<T> unselectQuantity(){
       unselectProperty(CartItem.QUANTITY_PROPERTY);
       return this;
    }
    public CartItemRequest<T> selectShoppingCartIdOnly(){
       selectProperty(CartItem.SHOPPING_CART_PROPERTY);
       return this;
    }

    public CartItemRequest<T> selectShoppingCart(){
        return selectShoppingCartWith(Q.shoppingCarts().unlimited().selectSelf());
    }

    public CartItemRequest<T> selectShoppingCartWith(ShoppingCartRequest shoppingCart){
       selectProperty(CartItem.SHOPPING_CART_PROPERTY);
       enhanceRelation(CartItem.SHOPPING_CART_PROPERTY, shoppingCart);
       return this;
    }

    public CartItemRequest<T> unselectShoppingCart(){
       unselectProperty(CartItem.SHOPPING_CART_PROPERTY);
       return this;
    }
    public CartItemRequest<T> selectCreateTime(){
       selectProperty(CartItem.CREATE_TIME_PROPERTY);
       return this;
    }

    /**
     * fill the createTime with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  createTime) to fetch createTime property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public CartItemRequest<T> unselectCreateTime(){
       unselectProperty(CartItem.CREATE_TIME_PROPERTY);
       return this;
    }
    public CartItemRequest<T> selectUpdateTime(){
       selectProperty(CartItem.UPDATE_TIME_PROPERTY);
       return this;
    }

    /**
     * fill the updateTime with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  updateTime) to fetch updateTime property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public CartItemRequest<T> unselectUpdateTime(){
       unselectProperty(CartItem.UPDATE_TIME_PROPERTY);
       return this;
    }
    public CartItemRequest<T> selectVersion(){
       selectProperty(CartItem.VERSION_PROPERTY);
       return this;
    }

    /**
     * fill the version with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  version) to fetch version property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public CartItemRequest<T> unselectVersion(){
       unselectProperty(CartItem.VERSION_PROPERTY);
       return this;
    }

    public CartItemRequest<T> withId(Operator operator, Object... values){
       return appendSearchCriteria(createIdCriteria(operator, values));
    }

    public SearchCriteria createIdCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(CartItem.ID_PROPERTY, operator, values);
    }

    public CartItemRequest<T> withIdIs(Long id){
       return withId(Operator.EQUAL, id);
    }
    public CartItemRequest<T> withIdIn(Long... id){
       return withId(Operator.EQUAL, (Object[])id);
    }



    public CartItemRequest<T> filterByProduct(Product... product){
      if (product == null || product.length == 0) {
        throw new IllegalArgumentException("filterByProduct parameter product cannot be empty");
      }
      return appendSearchCriteria(createProductCriteria(Operator.EQUAL, (Object[])product));
    }

    public CartItemRequest<T> withProduct(Operator operator, Object... values){
       return appendSearchCriteria(createProductCriteria(operator, values));
    }

    public CartItemRequest<T> withProductIsUnknown(){
       return withProduct(Operator.IS_NULL);
    }

    public CartItemRequest<T> withProductIsKnown(){
       return withProduct(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createProductCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(CartItem.PRODUCT_PROPERTY, operator, values);
    }

    public CartItemRequest<T> filterByProduct(Long product){
      if(product == null){
         return this;
      }
      return withProduct(Operator.EQUAL, product);
    }
    public CartItemRequest<T> withProductMatching(ProductRequest product){
       return appendSearchCriteria(new SubQuerySearchCriteria(CartItem.PRODUCT_PROPERTY, product, Product.ID_PROPERTY));
    }

    public CartItemRequest<T> filterByQuantity(BigDecimal... quantity){
      if (quantity == null || quantity.length == 0) {
        throw new IllegalArgumentException("filterByQuantity parameter quantity cannot be empty");
      }
      return appendSearchCriteria(createQuantityCriteria(Operator.EQUAL, (Object[])quantity));
    }

    public CartItemRequest<T> withQuantity(Operator operator, Object... values){
       return appendSearchCriteria(createQuantityCriteria(operator, values));
    }

    public CartItemRequest<T> withQuantityIsUnknown(){
       return withQuantity(Operator.IS_NULL);
    }

    public CartItemRequest<T> withQuantityIsKnown(){
       return withQuantity(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createQuantityCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(CartItem.QUANTITY_PROPERTY, operator, values);
    }

    public CartItemRequest<T> withQuantityGreaterThan(BigDecimal quantity){
       return withQuantity(Operator.GREATER_THAN, quantity);
    }

    public CartItemRequest<T> withQuantityGreaterThanOrEqualTo(BigDecimal quantity){
       return withQuantity(Operator.GREATER_THAN_OR_EQUAL, quantity);
    }

    public CartItemRequest<T> withQuantityLessThan(BigDecimal quantity){
       return withQuantity(Operator.LESS_THAN, quantity);
    }

    public CartItemRequest<T> withQuantityLessThanOrEqualTo(BigDecimal quantity){
       return withQuantity(Operator.LESS_THAN_OR_EQUAL, quantity);
    }

    public CartItemRequest<T> withQuantityBetween(BigDecimal startOfQuantity, BigDecimal endOfQuantity){
       return withQuantity(Operator.BETWEEN, startOfQuantity, endOfQuantity);
    }



    public CartItemRequest<T> filterByShoppingCart(ShoppingCart... shoppingCart){
      if (shoppingCart == null || shoppingCart.length == 0) {
        throw new IllegalArgumentException("filterByShoppingCart parameter shoppingCart cannot be empty");
      }
      return appendSearchCriteria(createShoppingCartCriteria(Operator.EQUAL, (Object[])shoppingCart));
    }

    public CartItemRequest<T> withShoppingCart(Operator operator, Object... values){
       return appendSearchCriteria(createShoppingCartCriteria(operator, values));
    }

    public CartItemRequest<T> withShoppingCartIsUnknown(){
       return withShoppingCart(Operator.IS_NULL);
    }

    public CartItemRequest<T> withShoppingCartIsKnown(){
       return withShoppingCart(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createShoppingCartCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(CartItem.SHOPPING_CART_PROPERTY, operator, values);
    }

    public CartItemRequest<T> filterByShoppingCart(Long shoppingCart){
      if(shoppingCart == null){
         return this;
      }
      return withShoppingCart(Operator.EQUAL, shoppingCart);
    }
    public CartItemRequest<T> withShoppingCartMatching(ShoppingCartRequest shoppingCart){
       return appendSearchCriteria(new SubQuerySearchCriteria(CartItem.SHOPPING_CART_PROPERTY, shoppingCart, ShoppingCart.ID_PROPERTY));
    }

    public CartItemRequest<T> filterByCreateTime(LocalDateTime... createTime){
      if (createTime == null || createTime.length == 0) {
        throw new IllegalArgumentException("filterByCreateTime parameter createTime cannot be empty");
      }
      return appendSearchCriteria(createCreateTimeCriteria(Operator.EQUAL, (Object[])createTime));
    }

    public CartItemRequest<T> withCreateTime(Operator operator, Object... values){
       return appendSearchCriteria(createCreateTimeCriteria(operator, values));
    }

    public CartItemRequest<T> withCreateTimeIsUnknown(){
       return withCreateTime(Operator.IS_NULL);
    }

    public CartItemRequest<T> withCreateTimeIsKnown(){
       return withCreateTime(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createCreateTimeCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(CartItem.CREATE_TIME_PROPERTY, operator, values);
    }

    public CartItemRequest<T> withCreateTimeGreaterThan(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public CartItemRequest<T> withCreateTimeGreaterThanOrEqualTo(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN_OR_EQUAL, createTime);
    }

    public CartItemRequest<T> withCreateTimeLessThan(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public CartItemRequest<T> withCreateTimeLessThanOrEqualTo(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN_OR_EQUAL, createTime);
    }

    public CartItemRequest<T> withCreateTimeBetween(LocalDateTime startOfCreateTime, LocalDateTime endOfCreateTime){
       return withCreateTime(Operator.BETWEEN, startOfCreateTime, endOfCreateTime);
    }
    public CartItemRequest<T> withCreateTimeBefore(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public CartItemRequest<T> withCreateTimeBefore(Date createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public CartItemRequest<T> withCreateTimeAfter(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public CartItemRequest<T> withCreateTimeAfter(Date createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public CartItemRequest<T> withCreateTimeBetween(Date startOfCreateTime, Date endOfCreateTime){
       return withCreateTime(Operator.BETWEEN, startOfCreateTime, endOfCreateTime);
    }




    public CartItemRequest<T> filterByUpdateTime(LocalDateTime... updateTime){
      if (updateTime == null || updateTime.length == 0) {
        throw new IllegalArgumentException("filterByUpdateTime parameter updateTime cannot be empty");
      }
      return appendSearchCriteria(createUpdateTimeCriteria(Operator.EQUAL, (Object[])updateTime));
    }

    public CartItemRequest<T> withUpdateTime(Operator operator, Object... values){
       return appendSearchCriteria(createUpdateTimeCriteria(operator, values));
    }

    public CartItemRequest<T> withUpdateTimeIsUnknown(){
       return withUpdateTime(Operator.IS_NULL);
    }

    public CartItemRequest<T> withUpdateTimeIsKnown(){
       return withUpdateTime(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createUpdateTimeCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(CartItem.UPDATE_TIME_PROPERTY, operator, values);
    }

    public CartItemRequest<T> withUpdateTimeGreaterThan(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public CartItemRequest<T> withUpdateTimeGreaterThanOrEqualTo(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN_OR_EQUAL, updateTime);
    }

    public CartItemRequest<T> withUpdateTimeLessThan(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public CartItemRequest<T> withUpdateTimeLessThanOrEqualTo(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN_OR_EQUAL, updateTime);
    }

    public CartItemRequest<T> withUpdateTimeBetween(LocalDateTime startOfUpdateTime, LocalDateTime endOfUpdateTime){
       return withUpdateTime(Operator.BETWEEN, startOfUpdateTime, endOfUpdateTime);
    }
    public CartItemRequest<T> withUpdateTimeBefore(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public CartItemRequest<T> withUpdateTimeBefore(Date updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public CartItemRequest<T> withUpdateTimeAfter(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public CartItemRequest<T> withUpdateTimeAfter(Date updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public CartItemRequest<T> withUpdateTimeBetween(Date startOfUpdateTime, Date endOfUpdateTime){
       return withUpdateTime(Operator.BETWEEN, startOfUpdateTime, endOfUpdateTime);
    }




    public CartItemRequest<T> filterByVersion(Long... version){
      if (version == null || version.length == 0) {
        throw new IllegalArgumentException("filterByVersion parameter version cannot be empty");
      }
      return appendSearchCriteria(createVersionCriteria(Operator.EQUAL, (Object[])version));
    }

    public CartItemRequest<T> withVersion(Operator operator, Object... values){
       return appendSearchCriteria(createVersionCriteria(operator, values));
    }

    public CartItemRequest<T> withVersionIsUnknown(){
       return withVersion(Operator.IS_NULL);
    }

    public CartItemRequest<T> withVersionIsKnown(){
       return withVersion(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createVersionCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(CartItem.VERSION_PROPERTY, operator, values);
    }

    public CartItemRequest<T> withVersionGreaterThan(Long version){
       return withVersion(Operator.GREATER_THAN, version);
    }

    public CartItemRequest<T> withVersionGreaterThanOrEqualTo(Long version){
       return withVersion(Operator.GREATER_THAN_OR_EQUAL, version);
    }

    public CartItemRequest<T> withVersionLessThan(Long version){
       return withVersion(Operator.LESS_THAN, version);
    }

    public CartItemRequest<T> withVersionLessThanOrEqualTo(Long version){
       return withVersion(Operator.LESS_THAN_OR_EQUAL, version);
    }

    public CartItemRequest<T> withVersionBetween(Long startOfVersion, Long endOfVersion){
       return withVersion(Operator.BETWEEN, startOfVersion, endOfVersion);
    }


    public CartItemRequest<T> count(){
        super.count();
        return this;
    }
    public CartItemRequest<T> countAs(String retName){
        super.count(retName);
        return this;
    }
    public CartItemRequest minQuantity(){
        return minQuantityAs(prefix("minOf",CartItem.QUANTITY_PROPERTY));
    }

    public CartItemRequest minQuantityAs(String retName){
        super.min(retName, CartItem.QUANTITY_PROPERTY);
        return this;
    }
    public CartItemRequest maxQuantity(){
        return maxQuantityAs(prefix("maxOf",CartItem.QUANTITY_PROPERTY));
    }

    public CartItemRequest maxQuantityAs(String retName){
        super.max(retName, CartItem.QUANTITY_PROPERTY);
        return this;
    }
    public CartItemRequest sumQuantity(){
        return sumQuantityAs(prefix("sumOf",CartItem.QUANTITY_PROPERTY));
    }

    public CartItemRequest sumQuantityAs(String retName){
        super.sum(retName, CartItem.QUANTITY_PROPERTY);
        return this;
    }
    public CartItemRequest avgQuantity(){
        return avgQuantityAs(prefix("avgOf",CartItem.QUANTITY_PROPERTY));
    }

    public CartItemRequest avgQuantityAs(String retName){
        super.avg(retName, CartItem.QUANTITY_PROPERTY);
        return this;
    }
    public CartItemRequest standardDeviationQuantity(){
        return standardDeviationQuantityAs(prefix("standardDeviationOf",CartItem.QUANTITY_PROPERTY));
    }

    public CartItemRequest standardDeviationQuantityAs(String retName){
        super.standardDeviation(retName, CartItem.QUANTITY_PROPERTY);
        return this;
    }
    public CartItemRequest squareRootOfPopulationStandardDeviationQuantity(){
        return squareRootOfPopulationStandardDeviationQuantityAs(prefix("squareRootOfPopulationStandardDeviationOf",CartItem.QUANTITY_PROPERTY));
    }

    public CartItemRequest squareRootOfPopulationStandardDeviationQuantityAs(String retName){
        super.squareRootOfPopulationStandardDeviation(retName, CartItem.QUANTITY_PROPERTY);
        return this;
    }
    public CartItemRequest sampleVarianceQuantity(){
        return sampleVarianceQuantityAs(prefix("sampleVarianceOf",CartItem.QUANTITY_PROPERTY));
    }

    public CartItemRequest sampleVarianceQuantityAs(String retName){
        super.sampleVariance(retName, CartItem.QUANTITY_PROPERTY);
        return this;
    }
    public CartItemRequest samplePopulationVarianceQuantity(){
        return samplePopulationVarianceQuantityAs(prefix("samplePopulationVarianceOf",CartItem.QUANTITY_PROPERTY));
    }

    public CartItemRequest samplePopulationVarianceQuantityAs(String retName){
        super.samplePopulationVariance(retName, CartItem.QUANTITY_PROPERTY);
        return this;
    }
    public CartItemRequest<T> groupByProductWithDetails(){
       return groupByProductWithDetails(Q.products().unlimited());
    }

    public CartItemRequest<T> groupByProductWithDetails(ProductRequest subRequest){
       aggregate(CartItem.PRODUCT_PROPERTY, subRequest);
       return this;
    }


    public CartItemRequest<T> groupByShoppingCartWithDetails(){
       return groupByShoppingCartWithDetails(Q.shoppingCarts().unlimited());
    }

    public CartItemRequest<T> groupByShoppingCartWithDetails(ShoppingCartRequest subRequest){
       aggregate(CartItem.SHOPPING_CART_PROPERTY, subRequest);
       return this;
    }





    public CartItemRequest<T> groupById(){
       groupBy(CartItem.ID_PROPERTY);
       return this;
    }

    public CartItemRequest<T> groupByIdAs(String retName){
       groupBy(retName, CartItem.ID_PROPERTY);
       return this;
    }

    public CartItemRequest<T> groupByIdWithFunction(String retName, AggrFunction function){
       groupBy(retName, CartItem.ID_PROPERTY, function);
       return this;
    }
    public CartItemRequest<T> groupByProductWith(ProductRequest subRequest){
       groupBy(CartItem.PRODUCT_PROPERTY, subRequest);
       return this;
    }
    public CartItemRequest<T> groupByProduct(){
       groupBy(CartItem.PRODUCT_PROPERTY);
       return this;
    }

    public CartItemRequest<T> groupByProductAs(String retName){
       groupBy(retName, CartItem.PRODUCT_PROPERTY);
       return this;
    }

    public CartItemRequest<T> groupByProductWithFunction(String retName, AggrFunction function){
       groupBy(retName, CartItem.PRODUCT_PROPERTY, function);
       return this;
    }

    public CartItemRequest<T> groupByQuantity(){
       groupBy(CartItem.QUANTITY_PROPERTY);
       return this;
    }

    public CartItemRequest<T> groupByQuantityAs(String retName){
       groupBy(retName, CartItem.QUANTITY_PROPERTY);
       return this;
    }

    public CartItemRequest<T> groupByQuantityWithFunction(String retName, AggrFunction function){
       groupBy(retName, CartItem.QUANTITY_PROPERTY, function);
       return this;
    }
    public CartItemRequest<T> groupByShoppingCartWith(ShoppingCartRequest subRequest){
       groupBy(CartItem.SHOPPING_CART_PROPERTY, subRequest);
       return this;
    }
    public CartItemRequest<T> groupByShoppingCart(){
       groupBy(CartItem.SHOPPING_CART_PROPERTY);
       return this;
    }

    public CartItemRequest<T> groupByShoppingCartAs(String retName){
       groupBy(retName, CartItem.SHOPPING_CART_PROPERTY);
       return this;
    }

    public CartItemRequest<T> groupByShoppingCartWithFunction(String retName, AggrFunction function){
       groupBy(retName, CartItem.SHOPPING_CART_PROPERTY, function);
       return this;
    }

    public CartItemRequest<T> groupByCreateTime(){
       groupBy(CartItem.CREATE_TIME_PROPERTY);
       return this;
    }

    public CartItemRequest<T> groupByCreateTimeAs(String retName){
       groupBy(retName, CartItem.CREATE_TIME_PROPERTY);
       return this;
    }

    public CartItemRequest<T> groupByCreateTimeWithFunction(String retName, AggrFunction function){
       groupBy(retName, CartItem.CREATE_TIME_PROPERTY, function);
       return this;
    }

    public CartItemRequest<T> groupByUpdateTime(){
       groupBy(CartItem.UPDATE_TIME_PROPERTY);
       return this;
    }

    public CartItemRequest<T> groupByUpdateTimeAs(String retName){
       groupBy(retName, CartItem.UPDATE_TIME_PROPERTY);
       return this;
    }

    public CartItemRequest<T> groupByUpdateTimeWithFunction(String retName, AggrFunction function){
       groupBy(retName, CartItem.UPDATE_TIME_PROPERTY, function);
       return this;
    }

    public CartItemRequest<T> groupByVersion(){
       groupBy(CartItem.VERSION_PROPERTY);
       return this;
    }

    public CartItemRequest<T> groupByVersionAs(String retName){
       groupBy(retName, CartItem.VERSION_PROPERTY);
       return this;
    }

    public CartItemRequest<T> groupByVersionWithFunction(String retName, AggrFunction function){
       groupBy(retName, CartItem.VERSION_PROPERTY, function);
       return this;
    }



    public CartItemRequest<T> orderByIdAscending(){
       addOrderByAscending(CartItem.ID_PROPERTY);
       return this;
    }

    public CartItemRequest<T> orderByIdDescending(){
       addOrderByDescending(CartItem.ID_PROPERTY);
       return this;
    }

    public CartItemRequest<T> orderByProductAscending(){
       addOrderByAscending(CartItem.PRODUCT_PROPERTY);
       return this;
    }

    public CartItemRequest<T> orderByProductDescending(){
       addOrderByDescending(CartItem.PRODUCT_PROPERTY);
       return this;
    }

    public CartItemRequest<T> orderByQuantityAscending(){
       addOrderByAscending(CartItem.QUANTITY_PROPERTY);
       return this;
    }

    public CartItemRequest<T> orderByQuantityDescending(){
       addOrderByDescending(CartItem.QUANTITY_PROPERTY);
       return this;
    }

    public CartItemRequest<T> orderByShoppingCartAscending(){
       addOrderByAscending(CartItem.SHOPPING_CART_PROPERTY);
       return this;
    }

    public CartItemRequest<T> orderByShoppingCartDescending(){
       addOrderByDescending(CartItem.SHOPPING_CART_PROPERTY);
       return this;
    }

    public CartItemRequest<T> orderByCreateTimeAscending(){
       addOrderByAscending(CartItem.CREATE_TIME_PROPERTY);
       return this;
    }

    public CartItemRequest<T> orderByCreateTimeDescending(){
       addOrderByDescending(CartItem.CREATE_TIME_PROPERTY);
       return this;
    }

    public CartItemRequest<T> orderByUpdateTimeAscending(){
       addOrderByAscending(CartItem.UPDATE_TIME_PROPERTY);
       return this;
    }

    public CartItemRequest<T> orderByUpdateTimeDescending(){
       addOrderByDescending(CartItem.UPDATE_TIME_PROPERTY);
       return this;
    }

    public CartItemRequest<T> orderByVersionAscending(){
       addOrderByAscending(CartItem.VERSION_PROPERTY);
       return this;
    }

    public CartItemRequest<T> orderByVersionDescending(){
       addOrderByDescending(CartItem.VERSION_PROPERTY);
       return this;
    }


    public ProductRequest rollUpToProduct(){
       ProductRequest product = Q.products().unlimited();
       this.withProductMatching(product)
           .groupByProductWith(product);
       return product;
    }


    public ShoppingCartRequest rollUpToShoppingCart(){
       ShoppingCartRequest shoppingCart = Q.shoppingCarts().unlimited();
       this.withShoppingCartMatching(shoppingCart)
           .groupByShoppingCartWith(shoppingCart);
       return shoppingCart;
    }





   public CartItemRequest<T> facetByProductAs(String facetName, ProductRequest product){
       return facetByProductAs(facetName, product, true);
   }

   public CartItemRequest<T> facetByProductAs(String facetName, ProductRequest product, boolean includeAllFacets){
       addFacet(facetName, CartItem.PRODUCT_PROPERTY, product, includeAllFacets);
       return this;
   }
   public CartItemRequest<T> facetByShoppingCartAs(String facetName, ShoppingCartRequest shoppingCart){
       return facetByShoppingCartAs(facetName, shoppingCart, true);
   }

   public CartItemRequest<T> facetByShoppingCartAs(String facetName, ShoppingCartRequest shoppingCart, boolean includeAllFacets){
       addFacet(facetName, CartItem.SHOPPING_CART_PROPERTY, shoppingCart, includeAllFacets);
       return this;
   }


    /**
     * get topN records
     * @param topN  records number
     */
    public CartItemRequest<T> top(int topN) {
        super.top(topN);
        return this;
    }

    /**
     * get records from offset(inclusive) to offset+size(exclusive)
     * @param offset record offset
     * @param size records number
     */
    public CartItemRequest<T> offset(int offset, int size) {
        super.offset(offset, size);
        return this;
    }

    /**
     * retrieve all records
     */
    public CartItemRequest<T> unlimited() {
        super.unlimited();
        return this;
    }

    /**
     * get records of one page
     * @param pageNumber page number(1-based)
     * @param pageSize page size
     */
    public CartItemRequest<T> page(int pageNumber, int pageSize) {
        int offset = (pageNumber - 1) * pageSize;
        return offset(offset, pageSize);
   }

    /**
     * get records of one page, default page size is 10
     * @param pageNumber page number(1-based)
     */
    public CartItemRequest<T> page(int pageNumber) {
        return page(pageNumber, 10);
   }
}