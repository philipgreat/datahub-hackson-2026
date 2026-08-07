
package com.example.enterpriseerpsystem.product;

import com.example.enterpriseerpsystem.Q;
import com.example.enterpriseerpsystem.cartitem.CartItem;
import com.example.enterpriseerpsystem.cartitem.CartItemRequest;
import com.example.enterpriseerpsystem.category.Category;
import com.example.enterpriseerpsystem.category.CategoryRequest;
import com.example.enterpriseerpsystem.inventoryitem.InventoryItem;
import com.example.enterpriseerpsystem.inventoryitem.InventoryItemRequest;
import com.example.enterpriseerpsystem.orderitem.OrderItem;
import com.example.enterpriseerpsystem.orderitem.OrderItemRequest;
import com.example.enterpriseerpsystem.productreview.ProductReview;
import com.example.enterpriseerpsystem.productreview.ProductReviewRequest;
import com.example.enterpriseerpsystem.purchaseorderitem.PurchaseOrderItem;
import com.example.enterpriseerpsystem.purchaseorderitem.PurchaseOrderItemRequest;
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

public class ProductRequest<T extends Product> extends BaseRequest<T> {

    /**
     * @deprecated AI agents and business code must use the generated Q facade
     *             instead of constructing request builders directly.
     */
    @Deprecated
    public ProductRequest(Class<T> returnType){
        super(returnType);
        selectId();
        selectVersion();
    }

    public ProductRequest<T> comment(String comment){
         super.internalComment(comment);
         return this;
    }

    // purpose() 继承自 BaseRequest，返回 ExecutableRequest（终结方法）

    public ProductRequest<T> returnType(Class<? extends T> returnType){
        super.setReturnType(returnType);
        return this;
    }

    public ProductRequest<T> enableAggregationCache(long cacheExpiredMillis){
        super.enableAggregationCache();
        super.aggregateCacheTime(cacheExpiredMillis);
        return this;
    }

    public ProductRequest<T> enableAggregationCache(){
        return enableAggregationCache(0l);
    }


    public ProductRequest<T> propagateAggregationCache(long cacheExpiredMillis){
        super.propagateAggregationCache(cacheExpiredMillis);
        return this;
    }

    public ProductRequest<T> appendSearchCriteria(SearchCriteria searchCriteria){
        return (ProductRequest<T>)super.appendSearchCriteria(searchCriteria);
    }

    public ProductRequest<T> filter(String property1, Operator operator, String property2){
        return appendSearchCriteria(new TwoOperatorCriteria(operator, new PropertyReference(property1), new PropertyReference(property2)));
    }


    public ProductRequest<T> matchingAnyOf(ProductRequest product){
        super.internalMatchAny(product);
        return this;
    }

    public ProductRequest<T> enhanceChildrenIfNeeded(){
        return this;
    }

    public ProductRequest<T> withDeletedRows(){
        super.withDeletedRows();
        return this;
    }

    public ProductRequest<T> deletedRowsOnly(){
        super.deletedRowsOnly();
        return this;
    }

    public ProductRequest<T> selectSelf(){
        super.selectSelf();
        return selectId().selectName().selectPrice().selectCategoryIdOnly().selectCost().selectIsActive().selectSku().selectStock().selectCreateTime().selectUpdateTime().selectVersion();
    }

    public ProductRequest<T> selectSelfFields(){
        return selectSelf();
    }

    public ProductRequest<T> selectAll(){
        super.selectAll();
        return selectId().selectName().selectPrice().selectCategory().selectCost().selectIsActive().selectSku().selectStock().selectCreateTime().selectUpdateTime().selectVersion();
    }

    public ProductRequest<T> selectChildren(){
        super.selectAny();
        selectProductReviewList().selectCartItemList().selectOrderItemList().selectInventoryItemList().selectPurchaseOrderItemList();
        return selectId().selectName().selectPrice().selectCategory().selectCost().selectIsActive().selectSku().selectStock().selectCreateTime().selectUpdateTime().selectVersion();
    }


    public ProductRequest<T> selectId(){
       selectProperty(Product.ID_PROPERTY);
       return this;
    }

    /**
     * fill the id with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  id) to fetch id property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public ProductRequest<T> unselectId(){
       unselectProperty(Product.ID_PROPERTY);
       return this;
    }
    public ProductRequest<T> selectName(){
       selectProperty(Product.NAME_PROPERTY);
       return this;
    }

    /**
     * fill the name with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  name) to fetch name property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public ProductRequest<T> unselectName(){
       unselectProperty(Product.NAME_PROPERTY);
       return this;
    }
    public ProductRequest<T> selectPrice(){
       selectProperty(Product.PRICE_PROPERTY);
       return this;
    }

    /**
     * fill the price with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  price) to fetch price property.
     * @param rawSqlSegment  customized rawSqlSegment
     */


    /**
     * fill the price with customized aggrFunction, TEAQL uses ({aggrFunction}(price) AS price to fetch price property.
     * @param aggrFunction  aggrFunction
     */
    public ProductRequest<T> selectPrice(AggrFunction aggrFunction){
       selectProperty(Product.PRICE_PROPERTY, aggrFunction);
       return this;
    }


    public ProductRequest<T> unselectPrice(){
       unselectProperty(Product.PRICE_PROPERTY);
       return this;
    }
    public ProductRequest<T> selectCategoryIdOnly(){
       selectProperty(Product.CATEGORY_PROPERTY);
       return this;
    }

    public ProductRequest<T> selectCategory(){
        return selectCategoryWith(Q.categories().unlimited().selectSelf());
    }

    public ProductRequest<T> selectCategoryWith(CategoryRequest category){
       selectProperty(Product.CATEGORY_PROPERTY);
       enhanceRelation(Product.CATEGORY_PROPERTY, category);
       return this;
    }

    public ProductRequest<T> unselectCategory(){
       unselectProperty(Product.CATEGORY_PROPERTY);
       return this;
    }
    public ProductRequest<T> selectCost(){
       selectProperty(Product.COST_PROPERTY);
       return this;
    }

    /**
     * fill the cost with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  cost) to fetch cost property.
     * @param rawSqlSegment  customized rawSqlSegment
     */


    /**
     * fill the cost with customized aggrFunction, TEAQL uses ({aggrFunction}(cost) AS cost to fetch cost property.
     * @param aggrFunction  aggrFunction
     */
    public ProductRequest<T> selectCost(AggrFunction aggrFunction){
       selectProperty(Product.COST_PROPERTY, aggrFunction);
       return this;
    }


    public ProductRequest<T> unselectCost(){
       unselectProperty(Product.COST_PROPERTY);
       return this;
    }
    public ProductRequest<T> selectIsActive(){
       selectProperty(Product.IS_ACTIVE_PROPERTY);
       return this;
    }

    /**
     * fill the isActive with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  isActive) to fetch isActive property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public ProductRequest<T> unselectIsActive(){
       unselectProperty(Product.IS_ACTIVE_PROPERTY);
       return this;
    }
    public ProductRequest<T> selectSku(){
       selectProperty(Product.SKU_PROPERTY);
       return this;
    }

    /**
     * fill the sku with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  sku) to fetch sku property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public ProductRequest<T> unselectSku(){
       unselectProperty(Product.SKU_PROPERTY);
       return this;
    }
    public ProductRequest<T> selectStock(){
       selectProperty(Product.STOCK_PROPERTY);
       return this;
    }

    /**
     * fill the stock with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  stock) to fetch stock property.
     * @param rawSqlSegment  customized rawSqlSegment
     */


    /**
     * fill the stock with customized aggrFunction, TEAQL uses ({aggrFunction}(stock) AS stock to fetch stock property.
     * @param aggrFunction  aggrFunction
     */
    public ProductRequest<T> selectStock(AggrFunction aggrFunction){
       selectProperty(Product.STOCK_PROPERTY, aggrFunction);
       return this;
    }


    public ProductRequest<T> unselectStock(){
       unselectProperty(Product.STOCK_PROPERTY);
       return this;
    }
    public ProductRequest<T> selectCreateTime(){
       selectProperty(Product.CREATE_TIME_PROPERTY);
       return this;
    }

    /**
     * fill the createTime with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  createTime) to fetch createTime property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public ProductRequest<T> unselectCreateTime(){
       unselectProperty(Product.CREATE_TIME_PROPERTY);
       return this;
    }
    public ProductRequest<T> selectUpdateTime(){
       selectProperty(Product.UPDATE_TIME_PROPERTY);
       return this;
    }

    /**
     * fill the updateTime with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  updateTime) to fetch updateTime property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public ProductRequest<T> unselectUpdateTime(){
       unselectProperty(Product.UPDATE_TIME_PROPERTY);
       return this;
    }
    public ProductRequest<T> selectVersion(){
       selectProperty(Product.VERSION_PROPERTY);
       return this;
    }

    /**
     * fill the version with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  version) to fetch version property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public ProductRequest<T> unselectVersion(){
       unselectProperty(Product.VERSION_PROPERTY);
       return this;
    }
    public ProductRequest<T> selectProductReviewList(){
       return selectProductReviewListWith(Q.productReviews().selectSelf());
    }

    public ProductRequest<T> selectProductReviewListWith(ProductReviewRequest productReviewList){
       enhanceRelation(Product.PRODUCT_REVIEW_LIST_PROPERTY, productReviewList);
       return this;
    }
    public ProductRequest<T> selectCartItemList(){
       return selectCartItemListWith(Q.cartItems().selectSelf());
    }

    public ProductRequest<T> selectCartItemListWith(CartItemRequest cartItemList){
       enhanceRelation(Product.CART_ITEM_LIST_PROPERTY, cartItemList);
       return this;
    }
    public ProductRequest<T> selectOrderItemList(){
       return selectOrderItemListWith(Q.orderItems().selectSelf());
    }

    public ProductRequest<T> selectOrderItemListWith(OrderItemRequest orderItemList){
       enhanceRelation(Product.ORDER_ITEM_LIST_PROPERTY, orderItemList);
       return this;
    }
    public ProductRequest<T> selectInventoryItemList(){
       return selectInventoryItemListWith(Q.inventoryItems().selectSelf());
    }

    public ProductRequest<T> selectInventoryItemListWith(InventoryItemRequest inventoryItemList){
       enhanceRelation(Product.INVENTORY_ITEM_LIST_PROPERTY, inventoryItemList);
       return this;
    }
    public ProductRequest<T> selectPurchaseOrderItemList(){
       return selectPurchaseOrderItemListWith(Q.purchaseOrderItems().selectSelf());
    }

    public ProductRequest<T> selectPurchaseOrderItemListWith(PurchaseOrderItemRequest purchaseOrderItemList){
       enhanceRelation(Product.PURCHASE_ORDER_ITEM_LIST_PROPERTY, purchaseOrderItemList);
       return this;
    }

    public ProductRequest<T> withId(Operator operator, Object... values){
       return appendSearchCriteria(createIdCriteria(operator, values));
    }

    public SearchCriteria createIdCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Product.ID_PROPERTY, operator, values);
    }

    public ProductRequest<T> withIdIs(Long id){
       return withId(Operator.EQUAL, id);
    }
    public ProductRequest<T> withIdIn(Long... id){
       return withId(Operator.EQUAL, (Object[])id);
    }



    public ProductRequest<T> filterByName(String... name){
      if (name == null || name.length == 0) {
        throw new IllegalArgumentException("filterByName parameter name cannot be empty");
      }
      return appendSearchCriteria(createNameCriteria(Operator.EQUAL, (Object[])name));
    }

    public ProductRequest<T> withName(Operator operator, Object... values){
       return appendSearchCriteria(createNameCriteria(operator, values));
    }

    public ProductRequest<T> withNameIsUnknown(){
       return withName(Operator.IS_NULL);
    }

    public ProductRequest<T> withNameIsKnown(){
       return withName(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createNameCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Product.NAME_PROPERTY, operator, values);
    }

    public ProductRequest<T> withNameGreaterThan(String name){
       return withName(Operator.GREATER_THAN, name);
    }

    public ProductRequest<T> withNameGreaterThanOrEqualTo(String name){
       return withName(Operator.GREATER_THAN_OR_EQUAL, name);
    }

    public ProductRequest<T> withNameLessThan(String name){
       return withName(Operator.LESS_THAN, name);
    }

    public ProductRequest<T> withNameLessThanOrEqualTo(String name){
       return withName(Operator.LESS_THAN_OR_EQUAL, name);
    }

    public ProductRequest<T> withNameBetween(String startOfName, String endOfName){
       return withName(Operator.BETWEEN, startOfName, endOfName);
    }
    public ProductRequest<T> withNameStartingWith(String name){
       return withName(Operator.BEGIN_WITH, name);
    }
    public ProductRequest<T> withNameContaining(String name){
       return withName(Operator.CONTAIN, name);
    }

    public ProductRequest<T> withNameEndingWith(String name){
       return withName(Operator.END_WITH, name);
    }

    public ProductRequest<T> withNameIs(String name){
       return withName(Operator.EQUAL, name);
    }

    public ProductRequest<T> withNameSoundingLike(String name){
       return withName(Operator.SOUNDS_LIKE, name);
    }



    public ProductRequest<T> filterByPrice(BigDecimal... price){
      if (price == null || price.length == 0) {
        throw new IllegalArgumentException("filterByPrice parameter price cannot be empty");
      }
      return appendSearchCriteria(createPriceCriteria(Operator.EQUAL, (Object[])price));
    }

    public ProductRequest<T> withPrice(Operator operator, Object... values){
       return appendSearchCriteria(createPriceCriteria(operator, values));
    }

    public ProductRequest<T> withPriceIsUnknown(){
       return withPrice(Operator.IS_NULL);
    }

    public ProductRequest<T> withPriceIsKnown(){
       return withPrice(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createPriceCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Product.PRICE_PROPERTY, operator, values);
    }

    public ProductRequest<T> withPriceGreaterThan(BigDecimal price){
       return withPrice(Operator.GREATER_THAN, price);
    }

    public ProductRequest<T> withPriceGreaterThanOrEqualTo(BigDecimal price){
       return withPrice(Operator.GREATER_THAN_OR_EQUAL, price);
    }

    public ProductRequest<T> withPriceLessThan(BigDecimal price){
       return withPrice(Operator.LESS_THAN, price);
    }

    public ProductRequest<T> withPriceLessThanOrEqualTo(BigDecimal price){
       return withPrice(Operator.LESS_THAN_OR_EQUAL, price);
    }

    public ProductRequest<T> withPriceBetween(BigDecimal startOfPrice, BigDecimal endOfPrice){
       return withPrice(Operator.BETWEEN, startOfPrice, endOfPrice);
    }



    public ProductRequest<T> filterByCategory(Category... category){
      if (category == null || category.length == 0) {
        throw new IllegalArgumentException("filterByCategory parameter category cannot be empty");
      }
      return appendSearchCriteria(createCategoryCriteria(Operator.EQUAL, (Object[])category));
    }

    public ProductRequest<T> withCategory(Operator operator, Object... values){
       return appendSearchCriteria(createCategoryCriteria(operator, values));
    }

    public ProductRequest<T> withCategoryIsUnknown(){
       return withCategory(Operator.IS_NULL);
    }

    public ProductRequest<T> withCategoryIsKnown(){
       return withCategory(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createCategoryCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Product.CATEGORY_PROPERTY, operator, values);
    }

    public ProductRequest<T> filterByCategory(Long category){
      if(category == null){
         return this;
      }
      return withCategory(Operator.EQUAL, category);
    }
    public ProductRequest<T> withCategoryMatching(CategoryRequest category){
       return appendSearchCriteria(new SubQuerySearchCriteria(Product.CATEGORY_PROPERTY, category, Category.ID_PROPERTY));
    }

    public ProductRequest<T> filterByCost(BigDecimal... cost){
      if (cost == null || cost.length == 0) {
        throw new IllegalArgumentException("filterByCost parameter cost cannot be empty");
      }
      return appendSearchCriteria(createCostCriteria(Operator.EQUAL, (Object[])cost));
    }

    public ProductRequest<T> withCost(Operator operator, Object... values){
       return appendSearchCriteria(createCostCriteria(operator, values));
    }

    public ProductRequest<T> withCostIsUnknown(){
       return withCost(Operator.IS_NULL);
    }

    public ProductRequest<T> withCostIsKnown(){
       return withCost(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createCostCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Product.COST_PROPERTY, operator, values);
    }

    public ProductRequest<T> withCostGreaterThan(BigDecimal cost){
       return withCost(Operator.GREATER_THAN, cost);
    }

    public ProductRequest<T> withCostGreaterThanOrEqualTo(BigDecimal cost){
       return withCost(Operator.GREATER_THAN_OR_EQUAL, cost);
    }

    public ProductRequest<T> withCostLessThan(BigDecimal cost){
       return withCost(Operator.LESS_THAN, cost);
    }

    public ProductRequest<T> withCostLessThanOrEqualTo(BigDecimal cost){
       return withCost(Operator.LESS_THAN_OR_EQUAL, cost);
    }

    public ProductRequest<T> withCostBetween(BigDecimal startOfCost, BigDecimal endOfCost){
       return withCost(Operator.BETWEEN, startOfCost, endOfCost);
    }



    public ProductRequest<T> filterByIsActive(Boolean... isActive){
      if (isActive == null || isActive.length == 0) {
        throw new IllegalArgumentException("filterByIsActive parameter isActive cannot be empty");
      }
      return appendSearchCriteria(createIsActiveCriteria(Operator.EQUAL, (Object[])isActive));
    }

    public ProductRequest<T> withIsActive(Operator operator, Object... values){
       return appendSearchCriteria(createIsActiveCriteria(operator, values));
    }

    public ProductRequest<T> withIsActiveIsUnknown(){
       return withIsActive(Operator.IS_NULL);
    }

    public ProductRequest<T> withIsActiveIsKnown(){
       return withIsActive(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createIsActiveCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Product.IS_ACTIVE_PROPERTY, operator, values);
    }

    public ProductRequest<T> whichIsIsActive(){
       return withIsActive(Operator.EQUAL, true);
    }

    public ProductRequest<T> whichIsNotIsActive(){
       return withIsActive(Operator.EQUAL, false);
    }


    public ProductRequest<T> filterBySku(String... sku){
      if (sku == null || sku.length == 0) {
        throw new IllegalArgumentException("filterBySku parameter sku cannot be empty");
      }
      return appendSearchCriteria(createSkuCriteria(Operator.EQUAL, (Object[])sku));
    }

    public ProductRequest<T> withSku(Operator operator, Object... values){
       return appendSearchCriteria(createSkuCriteria(operator, values));
    }

    public ProductRequest<T> withSkuIsUnknown(){
       return withSku(Operator.IS_NULL);
    }

    public ProductRequest<T> withSkuIsKnown(){
       return withSku(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createSkuCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Product.SKU_PROPERTY, operator, values);
    }

    public ProductRequest<T> withSkuGreaterThan(String sku){
       return withSku(Operator.GREATER_THAN, sku);
    }

    public ProductRequest<T> withSkuGreaterThanOrEqualTo(String sku){
       return withSku(Operator.GREATER_THAN_OR_EQUAL, sku);
    }

    public ProductRequest<T> withSkuLessThan(String sku){
       return withSku(Operator.LESS_THAN, sku);
    }

    public ProductRequest<T> withSkuLessThanOrEqualTo(String sku){
       return withSku(Operator.LESS_THAN_OR_EQUAL, sku);
    }

    public ProductRequest<T> withSkuBetween(String startOfSku, String endOfSku){
       return withSku(Operator.BETWEEN, startOfSku, endOfSku);
    }
    public ProductRequest<T> withSkuStartingWith(String sku){
       return withSku(Operator.BEGIN_WITH, sku);
    }
    public ProductRequest<T> withSkuContaining(String sku){
       return withSku(Operator.CONTAIN, sku);
    }

    public ProductRequest<T> withSkuEndingWith(String sku){
       return withSku(Operator.END_WITH, sku);
    }

    public ProductRequest<T> withSkuIs(String sku){
       return withSku(Operator.EQUAL, sku);
    }

    public ProductRequest<T> withSkuSoundingLike(String sku){
       return withSku(Operator.SOUNDS_LIKE, sku);
    }



    public ProductRequest<T> filterByStock(BigDecimal... stock){
      if (stock == null || stock.length == 0) {
        throw new IllegalArgumentException("filterByStock parameter stock cannot be empty");
      }
      return appendSearchCriteria(createStockCriteria(Operator.EQUAL, (Object[])stock));
    }

    public ProductRequest<T> withStock(Operator operator, Object... values){
       return appendSearchCriteria(createStockCriteria(operator, values));
    }

    public ProductRequest<T> withStockIsUnknown(){
       return withStock(Operator.IS_NULL);
    }

    public ProductRequest<T> withStockIsKnown(){
       return withStock(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createStockCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Product.STOCK_PROPERTY, operator, values);
    }

    public ProductRequest<T> withStockGreaterThan(BigDecimal stock){
       return withStock(Operator.GREATER_THAN, stock);
    }

    public ProductRequest<T> withStockGreaterThanOrEqualTo(BigDecimal stock){
       return withStock(Operator.GREATER_THAN_OR_EQUAL, stock);
    }

    public ProductRequest<T> withStockLessThan(BigDecimal stock){
       return withStock(Operator.LESS_THAN, stock);
    }

    public ProductRequest<T> withStockLessThanOrEqualTo(BigDecimal stock){
       return withStock(Operator.LESS_THAN_OR_EQUAL, stock);
    }

    public ProductRequest<T> withStockBetween(BigDecimal startOfStock, BigDecimal endOfStock){
       return withStock(Operator.BETWEEN, startOfStock, endOfStock);
    }



    public ProductRequest<T> filterByCreateTime(LocalDateTime... createTime){
      if (createTime == null || createTime.length == 0) {
        throw new IllegalArgumentException("filterByCreateTime parameter createTime cannot be empty");
      }
      return appendSearchCriteria(createCreateTimeCriteria(Operator.EQUAL, (Object[])createTime));
    }

    public ProductRequest<T> withCreateTime(Operator operator, Object... values){
       return appendSearchCriteria(createCreateTimeCriteria(operator, values));
    }

    public ProductRequest<T> withCreateTimeIsUnknown(){
       return withCreateTime(Operator.IS_NULL);
    }

    public ProductRequest<T> withCreateTimeIsKnown(){
       return withCreateTime(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createCreateTimeCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Product.CREATE_TIME_PROPERTY, operator, values);
    }

    public ProductRequest<T> withCreateTimeGreaterThan(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public ProductRequest<T> withCreateTimeGreaterThanOrEqualTo(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN_OR_EQUAL, createTime);
    }

    public ProductRequest<T> withCreateTimeLessThan(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public ProductRequest<T> withCreateTimeLessThanOrEqualTo(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN_OR_EQUAL, createTime);
    }

    public ProductRequest<T> withCreateTimeBetween(LocalDateTime startOfCreateTime, LocalDateTime endOfCreateTime){
       return withCreateTime(Operator.BETWEEN, startOfCreateTime, endOfCreateTime);
    }
    public ProductRequest<T> withCreateTimeBefore(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public ProductRequest<T> withCreateTimeBefore(Date createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public ProductRequest<T> withCreateTimeAfter(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public ProductRequest<T> withCreateTimeAfter(Date createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public ProductRequest<T> withCreateTimeBetween(Date startOfCreateTime, Date endOfCreateTime){
       return withCreateTime(Operator.BETWEEN, startOfCreateTime, endOfCreateTime);
    }




    public ProductRequest<T> filterByUpdateTime(LocalDateTime... updateTime){
      if (updateTime == null || updateTime.length == 0) {
        throw new IllegalArgumentException("filterByUpdateTime parameter updateTime cannot be empty");
      }
      return appendSearchCriteria(createUpdateTimeCriteria(Operator.EQUAL, (Object[])updateTime));
    }

    public ProductRequest<T> withUpdateTime(Operator operator, Object... values){
       return appendSearchCriteria(createUpdateTimeCriteria(operator, values));
    }

    public ProductRequest<T> withUpdateTimeIsUnknown(){
       return withUpdateTime(Operator.IS_NULL);
    }

    public ProductRequest<T> withUpdateTimeIsKnown(){
       return withUpdateTime(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createUpdateTimeCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Product.UPDATE_TIME_PROPERTY, operator, values);
    }

    public ProductRequest<T> withUpdateTimeGreaterThan(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public ProductRequest<T> withUpdateTimeGreaterThanOrEqualTo(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN_OR_EQUAL, updateTime);
    }

    public ProductRequest<T> withUpdateTimeLessThan(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public ProductRequest<T> withUpdateTimeLessThanOrEqualTo(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN_OR_EQUAL, updateTime);
    }

    public ProductRequest<T> withUpdateTimeBetween(LocalDateTime startOfUpdateTime, LocalDateTime endOfUpdateTime){
       return withUpdateTime(Operator.BETWEEN, startOfUpdateTime, endOfUpdateTime);
    }
    public ProductRequest<T> withUpdateTimeBefore(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public ProductRequest<T> withUpdateTimeBefore(Date updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public ProductRequest<T> withUpdateTimeAfter(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public ProductRequest<T> withUpdateTimeAfter(Date updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public ProductRequest<T> withUpdateTimeBetween(Date startOfUpdateTime, Date endOfUpdateTime){
       return withUpdateTime(Operator.BETWEEN, startOfUpdateTime, endOfUpdateTime);
    }




    public ProductRequest<T> filterByVersion(Long... version){
      if (version == null || version.length == 0) {
        throw new IllegalArgumentException("filterByVersion parameter version cannot be empty");
      }
      return appendSearchCriteria(createVersionCriteria(Operator.EQUAL, (Object[])version));
    }

    public ProductRequest<T> withVersion(Operator operator, Object... values){
       return appendSearchCriteria(createVersionCriteria(operator, values));
    }

    public ProductRequest<T> withVersionIsUnknown(){
       return withVersion(Operator.IS_NULL);
    }

    public ProductRequest<T> withVersionIsKnown(){
       return withVersion(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createVersionCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Product.VERSION_PROPERTY, operator, values);
    }

    public ProductRequest<T> withVersionGreaterThan(Long version){
       return withVersion(Operator.GREATER_THAN, version);
    }

    public ProductRequest<T> withVersionGreaterThanOrEqualTo(Long version){
       return withVersion(Operator.GREATER_THAN_OR_EQUAL, version);
    }

    public ProductRequest<T> withVersionLessThan(Long version){
       return withVersion(Operator.LESS_THAN, version);
    }

    public ProductRequest<T> withVersionLessThanOrEqualTo(Long version){
       return withVersion(Operator.LESS_THAN_OR_EQUAL, version);
    }

    public ProductRequest<T> withVersionBetween(Long startOfVersion, Long endOfVersion){
       return withVersion(Operator.BETWEEN, startOfVersion, endOfVersion);
    }

    public ProductRequest<T> withProductReviewListMatching(ProductReviewRequest productReviewRequest){
        return appendSearchCriteria(new SubQuerySearchCriteria(Product.ID_PROPERTY, productReviewRequest, ProductReview.PRODUCT_PROPERTY));
    }

    public ProductRequest<T> withoutProductReviewListMatching(ProductReviewRequest productReviewRequest){
        return appendSearchCriteria(SearchCriteria.not(new SubQuerySearchCriteria(Product.ID_PROPERTY, productReviewRequest, ProductReview.PRODUCT_PROPERTY)));
    }

    public ProductRequest<T> haveProductReviews(){
        return withProductReviewListMatching(Q.productReviews().unlimited());
    }

    public ProductRequest<T> haveNoProductReviews(){
        return withoutProductReviewListMatching(Q.productReviews().unlimited());
    }
    public ProductRequest<T> withCartItemListMatching(CartItemRequest cartItemRequest){
        return appendSearchCriteria(new SubQuerySearchCriteria(Product.ID_PROPERTY, cartItemRequest, CartItem.PRODUCT_PROPERTY));
    }

    public ProductRequest<T> withoutCartItemListMatching(CartItemRequest cartItemRequest){
        return appendSearchCriteria(SearchCriteria.not(new SubQuerySearchCriteria(Product.ID_PROPERTY, cartItemRequest, CartItem.PRODUCT_PROPERTY)));
    }

    public ProductRequest<T> haveCartItems(){
        return withCartItemListMatching(Q.cartItems().unlimited());
    }

    public ProductRequest<T> haveNoCartItems(){
        return withoutCartItemListMatching(Q.cartItems().unlimited());
    }
    public ProductRequest<T> withOrderItemListMatching(OrderItemRequest orderItemRequest){
        return appendSearchCriteria(new SubQuerySearchCriteria(Product.ID_PROPERTY, orderItemRequest, OrderItem.PRODUCT_PROPERTY));
    }

    public ProductRequest<T> withoutOrderItemListMatching(OrderItemRequest orderItemRequest){
        return appendSearchCriteria(SearchCriteria.not(new SubQuerySearchCriteria(Product.ID_PROPERTY, orderItemRequest, OrderItem.PRODUCT_PROPERTY)));
    }

    public ProductRequest<T> haveOrderItems(){
        return withOrderItemListMatching(Q.orderItems().unlimited());
    }

    public ProductRequest<T> haveNoOrderItems(){
        return withoutOrderItemListMatching(Q.orderItems().unlimited());
    }
    public ProductRequest<T> withInventoryItemListMatching(InventoryItemRequest inventoryItemRequest){
        return appendSearchCriteria(new SubQuerySearchCriteria(Product.ID_PROPERTY, inventoryItemRequest, InventoryItem.PRODUCT_PROPERTY));
    }

    public ProductRequest<T> withoutInventoryItemListMatching(InventoryItemRequest inventoryItemRequest){
        return appendSearchCriteria(SearchCriteria.not(new SubQuerySearchCriteria(Product.ID_PROPERTY, inventoryItemRequest, InventoryItem.PRODUCT_PROPERTY)));
    }

    public ProductRequest<T> haveInventoryItems(){
        return withInventoryItemListMatching(Q.inventoryItems().unlimited());
    }

    public ProductRequest<T> haveNoInventoryItems(){
        return withoutInventoryItemListMatching(Q.inventoryItems().unlimited());
    }
    public ProductRequest<T> withPurchaseOrderItemListMatching(PurchaseOrderItemRequest purchaseOrderItemRequest){
        return appendSearchCriteria(new SubQuerySearchCriteria(Product.ID_PROPERTY, purchaseOrderItemRequest, PurchaseOrderItem.PRODUCT_PROPERTY));
    }

    public ProductRequest<T> withoutPurchaseOrderItemListMatching(PurchaseOrderItemRequest purchaseOrderItemRequest){
        return appendSearchCriteria(SearchCriteria.not(new SubQuerySearchCriteria(Product.ID_PROPERTY, purchaseOrderItemRequest, PurchaseOrderItem.PRODUCT_PROPERTY)));
    }

    public ProductRequest<T> havePurchaseOrderItems(){
        return withPurchaseOrderItemListMatching(Q.purchaseOrderItems().unlimited());
    }

    public ProductRequest<T> haveNoPurchaseOrderItems(){
        return withoutPurchaseOrderItemListMatching(Q.purchaseOrderItems().unlimited());
    }

    public ProductRequest<T> count(){
        super.count();
        return this;
    }
    public ProductRequest<T> countAs(String retName){
        super.count(retName);
        return this;
    }
    public ProductRequest minPrice(){
        return minPriceAs(prefix("minOf",Product.PRICE_PROPERTY));
    }

    public ProductRequest minPriceAs(String retName){
        super.min(retName, Product.PRICE_PROPERTY);
        return this;
    }
    public ProductRequest maxPrice(){
        return maxPriceAs(prefix("maxOf",Product.PRICE_PROPERTY));
    }

    public ProductRequest maxPriceAs(String retName){
        super.max(retName, Product.PRICE_PROPERTY);
        return this;
    }
    public ProductRequest sumPrice(){
        return sumPriceAs(prefix("sumOf",Product.PRICE_PROPERTY));
    }

    public ProductRequest sumPriceAs(String retName){
        super.sum(retName, Product.PRICE_PROPERTY);
        return this;
    }
    public ProductRequest avgPrice(){
        return avgPriceAs(prefix("avgOf",Product.PRICE_PROPERTY));
    }

    public ProductRequest avgPriceAs(String retName){
        super.avg(retName, Product.PRICE_PROPERTY);
        return this;
    }
    public ProductRequest standardDeviationPrice(){
        return standardDeviationPriceAs(prefix("standardDeviationOf",Product.PRICE_PROPERTY));
    }

    public ProductRequest standardDeviationPriceAs(String retName){
        super.standardDeviation(retName, Product.PRICE_PROPERTY);
        return this;
    }
    public ProductRequest squareRootOfPopulationStandardDeviationPrice(){
        return squareRootOfPopulationStandardDeviationPriceAs(prefix("squareRootOfPopulationStandardDeviationOf",Product.PRICE_PROPERTY));
    }

    public ProductRequest squareRootOfPopulationStandardDeviationPriceAs(String retName){
        super.squareRootOfPopulationStandardDeviation(retName, Product.PRICE_PROPERTY);
        return this;
    }
    public ProductRequest sampleVariancePrice(){
        return sampleVariancePriceAs(prefix("sampleVarianceOf",Product.PRICE_PROPERTY));
    }

    public ProductRequest sampleVariancePriceAs(String retName){
        super.sampleVariance(retName, Product.PRICE_PROPERTY);
        return this;
    }
    public ProductRequest samplePopulationVariancePrice(){
        return samplePopulationVariancePriceAs(prefix("samplePopulationVarianceOf",Product.PRICE_PROPERTY));
    }

    public ProductRequest samplePopulationVariancePriceAs(String retName){
        super.samplePopulationVariance(retName, Product.PRICE_PROPERTY);
        return this;
    }
    public ProductRequest minCost(){
        return minCostAs(prefix("minOf",Product.COST_PROPERTY));
    }

    public ProductRequest minCostAs(String retName){
        super.min(retName, Product.COST_PROPERTY);
        return this;
    }
    public ProductRequest maxCost(){
        return maxCostAs(prefix("maxOf",Product.COST_PROPERTY));
    }

    public ProductRequest maxCostAs(String retName){
        super.max(retName, Product.COST_PROPERTY);
        return this;
    }
    public ProductRequest sumCost(){
        return sumCostAs(prefix("sumOf",Product.COST_PROPERTY));
    }

    public ProductRequest sumCostAs(String retName){
        super.sum(retName, Product.COST_PROPERTY);
        return this;
    }
    public ProductRequest avgCost(){
        return avgCostAs(prefix("avgOf",Product.COST_PROPERTY));
    }

    public ProductRequest avgCostAs(String retName){
        super.avg(retName, Product.COST_PROPERTY);
        return this;
    }
    public ProductRequest standardDeviationCost(){
        return standardDeviationCostAs(prefix("standardDeviationOf",Product.COST_PROPERTY));
    }

    public ProductRequest standardDeviationCostAs(String retName){
        super.standardDeviation(retName, Product.COST_PROPERTY);
        return this;
    }
    public ProductRequest squareRootOfPopulationStandardDeviationCost(){
        return squareRootOfPopulationStandardDeviationCostAs(prefix("squareRootOfPopulationStandardDeviationOf",Product.COST_PROPERTY));
    }

    public ProductRequest squareRootOfPopulationStandardDeviationCostAs(String retName){
        super.squareRootOfPopulationStandardDeviation(retName, Product.COST_PROPERTY);
        return this;
    }
    public ProductRequest sampleVarianceCost(){
        return sampleVarianceCostAs(prefix("sampleVarianceOf",Product.COST_PROPERTY));
    }

    public ProductRequest sampleVarianceCostAs(String retName){
        super.sampleVariance(retName, Product.COST_PROPERTY);
        return this;
    }
    public ProductRequest samplePopulationVarianceCost(){
        return samplePopulationVarianceCostAs(prefix("samplePopulationVarianceOf",Product.COST_PROPERTY));
    }

    public ProductRequest samplePopulationVarianceCostAs(String retName){
        super.samplePopulationVariance(retName, Product.COST_PROPERTY);
        return this;
    }
    public ProductRequest minStock(){
        return minStockAs(prefix("minOf",Product.STOCK_PROPERTY));
    }

    public ProductRequest minStockAs(String retName){
        super.min(retName, Product.STOCK_PROPERTY);
        return this;
    }
    public ProductRequest maxStock(){
        return maxStockAs(prefix("maxOf",Product.STOCK_PROPERTY));
    }

    public ProductRequest maxStockAs(String retName){
        super.max(retName, Product.STOCK_PROPERTY);
        return this;
    }
    public ProductRequest sumStock(){
        return sumStockAs(prefix("sumOf",Product.STOCK_PROPERTY));
    }

    public ProductRequest sumStockAs(String retName){
        super.sum(retName, Product.STOCK_PROPERTY);
        return this;
    }
    public ProductRequest avgStock(){
        return avgStockAs(prefix("avgOf",Product.STOCK_PROPERTY));
    }

    public ProductRequest avgStockAs(String retName){
        super.avg(retName, Product.STOCK_PROPERTY);
        return this;
    }
    public ProductRequest standardDeviationStock(){
        return standardDeviationStockAs(prefix("standardDeviationOf",Product.STOCK_PROPERTY));
    }

    public ProductRequest standardDeviationStockAs(String retName){
        super.standardDeviation(retName, Product.STOCK_PROPERTY);
        return this;
    }
    public ProductRequest squareRootOfPopulationStandardDeviationStock(){
        return squareRootOfPopulationStandardDeviationStockAs(prefix("squareRootOfPopulationStandardDeviationOf",Product.STOCK_PROPERTY));
    }

    public ProductRequest squareRootOfPopulationStandardDeviationStockAs(String retName){
        super.squareRootOfPopulationStandardDeviation(retName, Product.STOCK_PROPERTY);
        return this;
    }
    public ProductRequest sampleVarianceStock(){
        return sampleVarianceStockAs(prefix("sampleVarianceOf",Product.STOCK_PROPERTY));
    }

    public ProductRequest sampleVarianceStockAs(String retName){
        super.sampleVariance(retName, Product.STOCK_PROPERTY);
        return this;
    }
    public ProductRequest samplePopulationVarianceStock(){
        return samplePopulationVarianceStockAs(prefix("samplePopulationVarianceOf",Product.STOCK_PROPERTY));
    }

    public ProductRequest samplePopulationVarianceStockAs(String retName){
        super.samplePopulationVariance(retName, Product.STOCK_PROPERTY);
        return this;
    }
    public ProductRequest<T> groupByCategoryWithDetails(){
       return groupByCategoryWithDetails(Q.categories().unlimited());
    }

    public ProductRequest<T> groupByCategoryWithDetails(CategoryRequest subRequest){
       aggregate(Product.CATEGORY_PROPERTY, subRequest);
       return this;
    }








    public ProductRequest<T> groupByProductReviewsWithDetails(ProductReviewRequest subRequest){
       aggregate(Product.PRODUCT_REVIEW_LIST_PROPERTY, subRequest);
       return this;
    }
    public ProductRequest<T> groupByCartItemsWithDetails(CartItemRequest subRequest){
       aggregate(Product.CART_ITEM_LIST_PROPERTY, subRequest);
       return this;
    }
    public ProductRequest<T> groupByOrderItemsWithDetails(OrderItemRequest subRequest){
       aggregate(Product.ORDER_ITEM_LIST_PROPERTY, subRequest);
       return this;
    }
    public ProductRequest<T> groupByInventoryItemsWithDetails(InventoryItemRequest subRequest){
       aggregate(Product.INVENTORY_ITEM_LIST_PROPERTY, subRequest);
       return this;
    }
    public ProductRequest<T> groupByPurchaseOrderItemsWithDetails(PurchaseOrderItemRequest subRequest){
       aggregate(Product.PURCHASE_ORDER_ITEM_LIST_PROPERTY, subRequest);
       return this;
    }

    public ProductRequest<T> groupById(){
       groupBy(Product.ID_PROPERTY);
       return this;
    }

    public ProductRequest<T> groupByIdAs(String retName){
       groupBy(retName, Product.ID_PROPERTY);
       return this;
    }

    public ProductRequest<T> groupByIdWithFunction(String retName, AggrFunction function){
       groupBy(retName, Product.ID_PROPERTY, function);
       return this;
    }

    public ProductRequest<T> groupByName(){
       groupBy(Product.NAME_PROPERTY);
       return this;
    }

    public ProductRequest<T> groupByNameAs(String retName){
       groupBy(retName, Product.NAME_PROPERTY);
       return this;
    }

    public ProductRequest<T> groupByNameWithFunction(String retName, AggrFunction function){
       groupBy(retName, Product.NAME_PROPERTY, function);
       return this;
    }

    public ProductRequest<T> groupByPrice(){
       groupBy(Product.PRICE_PROPERTY);
       return this;
    }

    public ProductRequest<T> groupByPriceAs(String retName){
       groupBy(retName, Product.PRICE_PROPERTY);
       return this;
    }

    public ProductRequest<T> groupByPriceWithFunction(String retName, AggrFunction function){
       groupBy(retName, Product.PRICE_PROPERTY, function);
       return this;
    }
    public ProductRequest<T> groupByCategoryWith(CategoryRequest subRequest){
       groupBy(Product.CATEGORY_PROPERTY, subRequest);
       return this;
    }
    public ProductRequest<T> groupByCategory(){
       groupBy(Product.CATEGORY_PROPERTY);
       return this;
    }

    public ProductRequest<T> groupByCategoryAs(String retName){
       groupBy(retName, Product.CATEGORY_PROPERTY);
       return this;
    }

    public ProductRequest<T> groupByCategoryWithFunction(String retName, AggrFunction function){
       groupBy(retName, Product.CATEGORY_PROPERTY, function);
       return this;
    }

    public ProductRequest<T> groupByCost(){
       groupBy(Product.COST_PROPERTY);
       return this;
    }

    public ProductRequest<T> groupByCostAs(String retName){
       groupBy(retName, Product.COST_PROPERTY);
       return this;
    }

    public ProductRequest<T> groupByCostWithFunction(String retName, AggrFunction function){
       groupBy(retName, Product.COST_PROPERTY, function);
       return this;
    }

    public ProductRequest<T> groupByIsActive(){
       groupBy(Product.IS_ACTIVE_PROPERTY);
       return this;
    }

    public ProductRequest<T> groupByIsActiveAs(String retName){
       groupBy(retName, Product.IS_ACTIVE_PROPERTY);
       return this;
    }

    public ProductRequest<T> groupByIsActiveWithFunction(String retName, AggrFunction function){
       groupBy(retName, Product.IS_ACTIVE_PROPERTY, function);
       return this;
    }

    public ProductRequest<T> groupBySku(){
       groupBy(Product.SKU_PROPERTY);
       return this;
    }

    public ProductRequest<T> groupBySkuAs(String retName){
       groupBy(retName, Product.SKU_PROPERTY);
       return this;
    }

    public ProductRequest<T> groupBySkuWithFunction(String retName, AggrFunction function){
       groupBy(retName, Product.SKU_PROPERTY, function);
       return this;
    }

    public ProductRequest<T> groupByStock(){
       groupBy(Product.STOCK_PROPERTY);
       return this;
    }

    public ProductRequest<T> groupByStockAs(String retName){
       groupBy(retName, Product.STOCK_PROPERTY);
       return this;
    }

    public ProductRequest<T> groupByStockWithFunction(String retName, AggrFunction function){
       groupBy(retName, Product.STOCK_PROPERTY, function);
       return this;
    }

    public ProductRequest<T> groupByCreateTime(){
       groupBy(Product.CREATE_TIME_PROPERTY);
       return this;
    }

    public ProductRequest<T> groupByCreateTimeAs(String retName){
       groupBy(retName, Product.CREATE_TIME_PROPERTY);
       return this;
    }

    public ProductRequest<T> groupByCreateTimeWithFunction(String retName, AggrFunction function){
       groupBy(retName, Product.CREATE_TIME_PROPERTY, function);
       return this;
    }

    public ProductRequest<T> groupByUpdateTime(){
       groupBy(Product.UPDATE_TIME_PROPERTY);
       return this;
    }

    public ProductRequest<T> groupByUpdateTimeAs(String retName){
       groupBy(retName, Product.UPDATE_TIME_PROPERTY);
       return this;
    }

    public ProductRequest<T> groupByUpdateTimeWithFunction(String retName, AggrFunction function){
       groupBy(retName, Product.UPDATE_TIME_PROPERTY, function);
       return this;
    }

    public ProductRequest<T> groupByVersion(){
       groupBy(Product.VERSION_PROPERTY);
       return this;
    }

    public ProductRequest<T> groupByVersionAs(String retName){
       groupBy(retName, Product.VERSION_PROPERTY);
       return this;
    }

    public ProductRequest<T> groupByVersionWithFunction(String retName, AggrFunction function){
       groupBy(retName, Product.VERSION_PROPERTY, function);
       return this;
    }



    public ProductRequest<T> orderByIdAscending(){
       addOrderByAscending(Product.ID_PROPERTY);
       return this;
    }

    public ProductRequest<T> orderByIdDescending(){
       addOrderByDescending(Product.ID_PROPERTY);
       return this;
    }

    public ProductRequest<T> orderByNameAscending(){
       addOrderByAscending(Product.NAME_PROPERTY);
       return this;
    }

    public ProductRequest<T> orderByNameDescending(){
       addOrderByDescending(Product.NAME_PROPERTY);
       return this;
    }
    public ProductRequest<T> orderByNameAscendingUsingGBK(){
       addOrderByAscendingUsingGBK(Product.NAME_PROPERTY);
       return this;
    }

    public ProductRequest<T> orderByNameDescendingUsingGBK(){
       addOrderByDescendingUsingGBK(Product.NAME_PROPERTY);
       return this;
    }
    public ProductRequest<T> orderByPriceAscending(){
       addOrderByAscending(Product.PRICE_PROPERTY);
       return this;
    }

    public ProductRequest<T> orderByPriceDescending(){
       addOrderByDescending(Product.PRICE_PROPERTY);
       return this;
    }

    public ProductRequest<T> orderByCategoryAscending(){
       addOrderByAscending(Product.CATEGORY_PROPERTY);
       return this;
    }

    public ProductRequest<T> orderByCategoryDescending(){
       addOrderByDescending(Product.CATEGORY_PROPERTY);
       return this;
    }

    public ProductRequest<T> orderByCostAscending(){
       addOrderByAscending(Product.COST_PROPERTY);
       return this;
    }

    public ProductRequest<T> orderByCostDescending(){
       addOrderByDescending(Product.COST_PROPERTY);
       return this;
    }

    public ProductRequest<T> orderByIsActiveAscending(){
       addOrderByAscending(Product.IS_ACTIVE_PROPERTY);
       return this;
    }

    public ProductRequest<T> orderByIsActiveDescending(){
       addOrderByDescending(Product.IS_ACTIVE_PROPERTY);
       return this;
    }

    public ProductRequest<T> orderBySkuAscending(){
       addOrderByAscending(Product.SKU_PROPERTY);
       return this;
    }

    public ProductRequest<T> orderBySkuDescending(){
       addOrderByDescending(Product.SKU_PROPERTY);
       return this;
    }
    public ProductRequest<T> orderBySkuAscendingUsingGBK(){
       addOrderByAscendingUsingGBK(Product.SKU_PROPERTY);
       return this;
    }

    public ProductRequest<T> orderBySkuDescendingUsingGBK(){
       addOrderByDescendingUsingGBK(Product.SKU_PROPERTY);
       return this;
    }
    public ProductRequest<T> orderByStockAscending(){
       addOrderByAscending(Product.STOCK_PROPERTY);
       return this;
    }

    public ProductRequest<T> orderByStockDescending(){
       addOrderByDescending(Product.STOCK_PROPERTY);
       return this;
    }

    public ProductRequest<T> orderByCreateTimeAscending(){
       addOrderByAscending(Product.CREATE_TIME_PROPERTY);
       return this;
    }

    public ProductRequest<T> orderByCreateTimeDescending(){
       addOrderByDescending(Product.CREATE_TIME_PROPERTY);
       return this;
    }

    public ProductRequest<T> orderByUpdateTimeAscending(){
       addOrderByAscending(Product.UPDATE_TIME_PROPERTY);
       return this;
    }

    public ProductRequest<T> orderByUpdateTimeDescending(){
       addOrderByDescending(Product.UPDATE_TIME_PROPERTY);
       return this;
    }

    public ProductRequest<T> orderByVersionAscending(){
       addOrderByAscending(Product.VERSION_PROPERTY);
       return this;
    }

    public ProductRequest<T> orderByVersionDescending(){
       addOrderByDescending(Product.VERSION_PROPERTY);
       return this;
    }


    public ProductRequest<T> statsFromProductReviewsAs(String name, ProductReviewRequest subRequest){
       return statsFromProductReviewsAs(name, subRequest, false);
    }

    public ProductRequest<T> statsFromProductReviewsAs(String name, ProductReviewRequest subRequest, boolean singleResult){
       subRequest.setPartitionProperty(ProductReview.PRODUCT_PROPERTY);
       addAggregateDynamicProperty(name, subRequest, singleResult);
       return this;
    }

    public ProductRequest<T> statsFromProductReviews(ProductReviewRequest subRequest){
       return statsFromProductReviewsAs(REFINEMENTS, subRequest);
    }
    public ProductRequest<T> statsFromCartItemsAs(String name, CartItemRequest subRequest){
       return statsFromCartItemsAs(name, subRequest, false);
    }

    public ProductRequest<T> statsFromCartItemsAs(String name, CartItemRequest subRequest, boolean singleResult){
       subRequest.setPartitionProperty(CartItem.PRODUCT_PROPERTY);
       addAggregateDynamicProperty(name, subRequest, singleResult);
       return this;
    }

    public ProductRequest<T> statsFromCartItems(CartItemRequest subRequest){
       return statsFromCartItemsAs(REFINEMENTS, subRequest);
    }
    public ProductRequest<T> statsFromOrderItemsAs(String name, OrderItemRequest subRequest){
       return statsFromOrderItemsAs(name, subRequest, false);
    }

    public ProductRequest<T> statsFromOrderItemsAs(String name, OrderItemRequest subRequest, boolean singleResult){
       subRequest.setPartitionProperty(OrderItem.PRODUCT_PROPERTY);
       addAggregateDynamicProperty(name, subRequest, singleResult);
       return this;
    }

    public ProductRequest<T> statsFromOrderItems(OrderItemRequest subRequest){
       return statsFromOrderItemsAs(REFINEMENTS, subRequest);
    }
    public ProductRequest<T> statsFromInventoryItemsAs(String name, InventoryItemRequest subRequest){
       return statsFromInventoryItemsAs(name, subRequest, false);
    }

    public ProductRequest<T> statsFromInventoryItemsAs(String name, InventoryItemRequest subRequest, boolean singleResult){
       subRequest.setPartitionProperty(InventoryItem.PRODUCT_PROPERTY);
       addAggregateDynamicProperty(name, subRequest, singleResult);
       return this;
    }

    public ProductRequest<T> statsFromInventoryItems(InventoryItemRequest subRequest){
       return statsFromInventoryItemsAs(REFINEMENTS, subRequest);
    }
    public ProductRequest<T> statsFromPurchaseOrderItemsAs(String name, PurchaseOrderItemRequest subRequest){
       return statsFromPurchaseOrderItemsAs(name, subRequest, false);
    }

    public ProductRequest<T> statsFromPurchaseOrderItemsAs(String name, PurchaseOrderItemRequest subRequest, boolean singleResult){
       subRequest.setPartitionProperty(PurchaseOrderItem.PRODUCT_PROPERTY);
       addAggregateDynamicProperty(name, subRequest, singleResult);
       return this;
    }

    public ProductRequest<T> statsFromPurchaseOrderItems(PurchaseOrderItemRequest subRequest){
       return statsFromPurchaseOrderItemsAs(REFINEMENTS, subRequest);
    }
    public CategoryRequest rollUpToCategory(){
       CategoryRequest category = Q.categories().unlimited();
       this.withCategoryMatching(category)
           .groupByCategoryWith(category);
       return category;
    }








    public ProductRequest<T> countProductReviews(){
        return countProductReviewsAs("Count");
    }

    public ProductRequest<T> countProductReviewsAs(String name){
        return countProductReviewsWith(name, Q.productReviews().unlimited());
    }

    public ProductRequest<T> countProductReviewsWith(String name, ProductReviewRequest subRequest){
        return statsFromProductReviewsAs(name, subRequest.count(), true);
    }
    public ProductRequest<T> countCartItems(){
        return countCartItemsAs("Count");
    }

    public ProductRequest<T> countCartItemsAs(String name){
        return countCartItemsWith(name, Q.cartItems().unlimited());
    }

    public ProductRequest<T> countCartItemsWith(String name, CartItemRequest subRequest){
        return statsFromCartItemsAs(name, subRequest.count(), true);
    }
    public ProductRequest<T> countOrderItems(){
        return countOrderItemsAs("Count");
    }

    public ProductRequest<T> countOrderItemsAs(String name){
        return countOrderItemsWith(name, Q.orderItems().unlimited());
    }

    public ProductRequest<T> countOrderItemsWith(String name, OrderItemRequest subRequest){
        return statsFromOrderItemsAs(name, subRequest.count(), true);
    }
    public ProductRequest<T> countInventoryItems(){
        return countInventoryItemsAs("Count");
    }

    public ProductRequest<T> countInventoryItemsAs(String name){
        return countInventoryItemsWith(name, Q.inventoryItems().unlimited());
    }

    public ProductRequest<T> countInventoryItemsWith(String name, InventoryItemRequest subRequest){
        return statsFromInventoryItemsAs(name, subRequest.count(), true);
    }
    public ProductRequest<T> countPurchaseOrderItems(){
        return countPurchaseOrderItemsAs("Count");
    }

    public ProductRequest<T> countPurchaseOrderItemsAs(String name){
        return countPurchaseOrderItemsWith(name, Q.purchaseOrderItems().unlimited());
    }

    public ProductRequest<T> countPurchaseOrderItemsWith(String name, PurchaseOrderItemRequest subRequest){
        return statsFromPurchaseOrderItemsAs(name, subRequest.count(), true);
    }
    public ProductRequest<T> minRatingOfProductReviews(){
        return minRatingOfProductReviewsAs("minRatingOfProductReviews");
    }

    public ProductRequest<T> minRatingOfProductReviewsAs(String name){
        return minRatingOfProductReviewsAs(name, Q.productReviews().unlimited());
    }

    public ProductRequest<T> minRatingOfProductReviewsAs(String name, ProductReviewRequest subRequest){
        return statsFromProductReviewsAs(name, subRequest.minRating(), true);
    }
    public ProductRequest<T> maxRatingOfProductReviews(){
        return maxRatingOfProductReviewsAs("maxRatingOfProductReviews");
    }

    public ProductRequest<T> maxRatingOfProductReviewsAs(String name){
        return maxRatingOfProductReviewsAs(name, Q.productReviews().unlimited());
    }

    public ProductRequest<T> maxRatingOfProductReviewsAs(String name, ProductReviewRequest subRequest){
        return statsFromProductReviewsAs(name, subRequest.maxRating(), true);
    }
    public ProductRequest<T> sumRatingOfProductReviews(){
        return sumRatingOfProductReviewsAs("sumRatingOfProductReviews");
    }

    public ProductRequest<T> sumRatingOfProductReviewsAs(String name){
        return sumRatingOfProductReviewsAs(name, Q.productReviews().unlimited());
    }

    public ProductRequest<T> sumRatingOfProductReviewsAs(String name, ProductReviewRequest subRequest){
        return statsFromProductReviewsAs(name, subRequest.sumRating(), true);
    }
    public ProductRequest<T> avgRatingOfProductReviews(){
        return avgRatingOfProductReviewsAs("avgRatingOfProductReviews");
    }

    public ProductRequest<T> avgRatingOfProductReviewsAs(String name){
        return avgRatingOfProductReviewsAs(name, Q.productReviews().unlimited());
    }

    public ProductRequest<T> avgRatingOfProductReviewsAs(String name, ProductReviewRequest subRequest){
        return statsFromProductReviewsAs(name, subRequest.avgRating(), true);
    }
    public ProductRequest<T> standardDeviationRatingOfProductReviews(){
        return standardDeviationRatingOfProductReviewsAs("stdDevRatingOfProductReviews");
    }

    public ProductRequest<T> standardDeviationRatingOfProductReviewsAs(String name){
        return standardDeviationRatingOfProductReviewsAs(name, Q.productReviews().unlimited());
    }

    public ProductRequest<T> standardDeviationRatingOfProductReviewsAs(String name, ProductReviewRequest subRequest){
        return statsFromProductReviewsAs(name, subRequest.standardDeviationRating(), true);
    }
    public ProductRequest<T> squareRootOfPopulationStandardDeviationRatingOfProductReviews(){
        return squareRootOfPopulationStandardDeviationRatingOfProductReviewsAs("stdDevPopRatingOfProductReviews");
    }

    public ProductRequest<T> squareRootOfPopulationStandardDeviationRatingOfProductReviewsAs(String name){
        return squareRootOfPopulationStandardDeviationRatingOfProductReviewsAs(name, Q.productReviews().unlimited());
    }

    public ProductRequest<T> squareRootOfPopulationStandardDeviationRatingOfProductReviewsAs(String name, ProductReviewRequest subRequest){
        return statsFromProductReviewsAs(name, subRequest.squareRootOfPopulationStandardDeviationRating(), true);
    }
    public ProductRequest<T> sampleVarianceRatingOfProductReviews(){
        return sampleVarianceRatingOfProductReviewsAs("varSampRatingOfProductReviews");
    }

    public ProductRequest<T> sampleVarianceRatingOfProductReviewsAs(String name){
        return sampleVarianceRatingOfProductReviewsAs(name, Q.productReviews().unlimited());
    }

    public ProductRequest<T> sampleVarianceRatingOfProductReviewsAs(String name, ProductReviewRequest subRequest){
        return statsFromProductReviewsAs(name, subRequest.sampleVarianceRating(), true);
    }
    public ProductRequest<T> samplePopulationVarianceRatingOfProductReviews(){
        return samplePopulationVarianceRatingOfProductReviewsAs("varPopRatingOfProductReviews");
    }

    public ProductRequest<T> samplePopulationVarianceRatingOfProductReviewsAs(String name){
        return samplePopulationVarianceRatingOfProductReviewsAs(name, Q.productReviews().unlimited());
    }

    public ProductRequest<T> samplePopulationVarianceRatingOfProductReviewsAs(String name, ProductReviewRequest subRequest){
        return statsFromProductReviewsAs(name, subRequest.samplePopulationVarianceRating(), true);
    }
    public ProductRequest<T> minQuantityOfCartItems(){
        return minQuantityOfCartItemsAs("minQuantityOfCartItems");
    }

    public ProductRequest<T> minQuantityOfCartItemsAs(String name){
        return minQuantityOfCartItemsAs(name, Q.cartItems().unlimited());
    }

    public ProductRequest<T> minQuantityOfCartItemsAs(String name, CartItemRequest subRequest){
        return statsFromCartItemsAs(name, subRequest.minQuantity(), true);
    }
    public ProductRequest<T> maxQuantityOfCartItems(){
        return maxQuantityOfCartItemsAs("maxQuantityOfCartItems");
    }

    public ProductRequest<T> maxQuantityOfCartItemsAs(String name){
        return maxQuantityOfCartItemsAs(name, Q.cartItems().unlimited());
    }

    public ProductRequest<T> maxQuantityOfCartItemsAs(String name, CartItemRequest subRequest){
        return statsFromCartItemsAs(name, subRequest.maxQuantity(), true);
    }
    public ProductRequest<T> sumQuantityOfCartItems(){
        return sumQuantityOfCartItemsAs("sumQuantityOfCartItems");
    }

    public ProductRequest<T> sumQuantityOfCartItemsAs(String name){
        return sumQuantityOfCartItemsAs(name, Q.cartItems().unlimited());
    }

    public ProductRequest<T> sumQuantityOfCartItemsAs(String name, CartItemRequest subRequest){
        return statsFromCartItemsAs(name, subRequest.sumQuantity(), true);
    }
    public ProductRequest<T> avgQuantityOfCartItems(){
        return avgQuantityOfCartItemsAs("avgQuantityOfCartItems");
    }

    public ProductRequest<T> avgQuantityOfCartItemsAs(String name){
        return avgQuantityOfCartItemsAs(name, Q.cartItems().unlimited());
    }

    public ProductRequest<T> avgQuantityOfCartItemsAs(String name, CartItemRequest subRequest){
        return statsFromCartItemsAs(name, subRequest.avgQuantity(), true);
    }
    public ProductRequest<T> standardDeviationQuantityOfCartItems(){
        return standardDeviationQuantityOfCartItemsAs("stdDevQuantityOfCartItems");
    }

    public ProductRequest<T> standardDeviationQuantityOfCartItemsAs(String name){
        return standardDeviationQuantityOfCartItemsAs(name, Q.cartItems().unlimited());
    }

    public ProductRequest<T> standardDeviationQuantityOfCartItemsAs(String name, CartItemRequest subRequest){
        return statsFromCartItemsAs(name, subRequest.standardDeviationQuantity(), true);
    }
    public ProductRequest<T> squareRootOfPopulationStandardDeviationQuantityOfCartItems(){
        return squareRootOfPopulationStandardDeviationQuantityOfCartItemsAs("stdDevPopQuantityOfCartItems");
    }

    public ProductRequest<T> squareRootOfPopulationStandardDeviationQuantityOfCartItemsAs(String name){
        return squareRootOfPopulationStandardDeviationQuantityOfCartItemsAs(name, Q.cartItems().unlimited());
    }

    public ProductRequest<T> squareRootOfPopulationStandardDeviationQuantityOfCartItemsAs(String name, CartItemRequest subRequest){
        return statsFromCartItemsAs(name, subRequest.squareRootOfPopulationStandardDeviationQuantity(), true);
    }
    public ProductRequest<T> sampleVarianceQuantityOfCartItems(){
        return sampleVarianceQuantityOfCartItemsAs("varSampQuantityOfCartItems");
    }

    public ProductRequest<T> sampleVarianceQuantityOfCartItemsAs(String name){
        return sampleVarianceQuantityOfCartItemsAs(name, Q.cartItems().unlimited());
    }

    public ProductRequest<T> sampleVarianceQuantityOfCartItemsAs(String name, CartItemRequest subRequest){
        return statsFromCartItemsAs(name, subRequest.sampleVarianceQuantity(), true);
    }
    public ProductRequest<T> samplePopulationVarianceQuantityOfCartItems(){
        return samplePopulationVarianceQuantityOfCartItemsAs("varPopQuantityOfCartItems");
    }

    public ProductRequest<T> samplePopulationVarianceQuantityOfCartItemsAs(String name){
        return samplePopulationVarianceQuantityOfCartItemsAs(name, Q.cartItems().unlimited());
    }

    public ProductRequest<T> samplePopulationVarianceQuantityOfCartItemsAs(String name, CartItemRequest subRequest){
        return statsFromCartItemsAs(name, subRequest.samplePopulationVarianceQuantity(), true);
    }
    public ProductRequest<T> minUnitPriceOfOrderItems(){
        return minUnitPriceOfOrderItemsAs("minUnitPriceOfOrderItems");
    }

    public ProductRequest<T> minUnitPriceOfOrderItemsAs(String name){
        return minUnitPriceOfOrderItemsAs(name, Q.orderItems().unlimited());
    }

    public ProductRequest<T> minUnitPriceOfOrderItemsAs(String name, OrderItemRequest subRequest){
        return statsFromOrderItemsAs(name, subRequest.minUnitPrice(), true);
    }
    public ProductRequest<T> maxUnitPriceOfOrderItems(){
        return maxUnitPriceOfOrderItemsAs("maxUnitPriceOfOrderItems");
    }

    public ProductRequest<T> maxUnitPriceOfOrderItemsAs(String name){
        return maxUnitPriceOfOrderItemsAs(name, Q.orderItems().unlimited());
    }

    public ProductRequest<T> maxUnitPriceOfOrderItemsAs(String name, OrderItemRequest subRequest){
        return statsFromOrderItemsAs(name, subRequest.maxUnitPrice(), true);
    }
    public ProductRequest<T> sumUnitPriceOfOrderItems(){
        return sumUnitPriceOfOrderItemsAs("sumUnitPriceOfOrderItems");
    }

    public ProductRequest<T> sumUnitPriceOfOrderItemsAs(String name){
        return sumUnitPriceOfOrderItemsAs(name, Q.orderItems().unlimited());
    }

    public ProductRequest<T> sumUnitPriceOfOrderItemsAs(String name, OrderItemRequest subRequest){
        return statsFromOrderItemsAs(name, subRequest.sumUnitPrice(), true);
    }
    public ProductRequest<T> avgUnitPriceOfOrderItems(){
        return avgUnitPriceOfOrderItemsAs("avgUnitPriceOfOrderItems");
    }

    public ProductRequest<T> avgUnitPriceOfOrderItemsAs(String name){
        return avgUnitPriceOfOrderItemsAs(name, Q.orderItems().unlimited());
    }

    public ProductRequest<T> avgUnitPriceOfOrderItemsAs(String name, OrderItemRequest subRequest){
        return statsFromOrderItemsAs(name, subRequest.avgUnitPrice(), true);
    }
    public ProductRequest<T> standardDeviationUnitPriceOfOrderItems(){
        return standardDeviationUnitPriceOfOrderItemsAs("stdDevUnitPriceOfOrderItems");
    }

    public ProductRequest<T> standardDeviationUnitPriceOfOrderItemsAs(String name){
        return standardDeviationUnitPriceOfOrderItemsAs(name, Q.orderItems().unlimited());
    }

    public ProductRequest<T> standardDeviationUnitPriceOfOrderItemsAs(String name, OrderItemRequest subRequest){
        return statsFromOrderItemsAs(name, subRequest.standardDeviationUnitPrice(), true);
    }
    public ProductRequest<T> squareRootOfPopulationStandardDeviationUnitPriceOfOrderItems(){
        return squareRootOfPopulationStandardDeviationUnitPriceOfOrderItemsAs("stdDevPopUnitPriceOfOrderItems");
    }

    public ProductRequest<T> squareRootOfPopulationStandardDeviationUnitPriceOfOrderItemsAs(String name){
        return squareRootOfPopulationStandardDeviationUnitPriceOfOrderItemsAs(name, Q.orderItems().unlimited());
    }

    public ProductRequest<T> squareRootOfPopulationStandardDeviationUnitPriceOfOrderItemsAs(String name, OrderItemRequest subRequest){
        return statsFromOrderItemsAs(name, subRequest.squareRootOfPopulationStandardDeviationUnitPrice(), true);
    }
    public ProductRequest<T> sampleVarianceUnitPriceOfOrderItems(){
        return sampleVarianceUnitPriceOfOrderItemsAs("varSampUnitPriceOfOrderItems");
    }

    public ProductRequest<T> sampleVarianceUnitPriceOfOrderItemsAs(String name){
        return sampleVarianceUnitPriceOfOrderItemsAs(name, Q.orderItems().unlimited());
    }

    public ProductRequest<T> sampleVarianceUnitPriceOfOrderItemsAs(String name, OrderItemRequest subRequest){
        return statsFromOrderItemsAs(name, subRequest.sampleVarianceUnitPrice(), true);
    }
    public ProductRequest<T> samplePopulationVarianceUnitPriceOfOrderItems(){
        return samplePopulationVarianceUnitPriceOfOrderItemsAs("varPopUnitPriceOfOrderItems");
    }

    public ProductRequest<T> samplePopulationVarianceUnitPriceOfOrderItemsAs(String name){
        return samplePopulationVarianceUnitPriceOfOrderItemsAs(name, Q.orderItems().unlimited());
    }

    public ProductRequest<T> samplePopulationVarianceUnitPriceOfOrderItemsAs(String name, OrderItemRequest subRequest){
        return statsFromOrderItemsAs(name, subRequest.samplePopulationVarianceUnitPrice(), true);
    }
    public ProductRequest<T> minQuantityOfOrderItems(){
        return minQuantityOfOrderItemsAs("minQuantityOfOrderItems");
    }

    public ProductRequest<T> minQuantityOfOrderItemsAs(String name){
        return minQuantityOfOrderItemsAs(name, Q.orderItems().unlimited());
    }

    public ProductRequest<T> minQuantityOfOrderItemsAs(String name, OrderItemRequest subRequest){
        return statsFromOrderItemsAs(name, subRequest.minQuantity(), true);
    }
    public ProductRequest<T> maxQuantityOfOrderItems(){
        return maxQuantityOfOrderItemsAs("maxQuantityOfOrderItems");
    }

    public ProductRequest<T> maxQuantityOfOrderItemsAs(String name){
        return maxQuantityOfOrderItemsAs(name, Q.orderItems().unlimited());
    }

    public ProductRequest<T> maxQuantityOfOrderItemsAs(String name, OrderItemRequest subRequest){
        return statsFromOrderItemsAs(name, subRequest.maxQuantity(), true);
    }
    public ProductRequest<T> sumQuantityOfOrderItems(){
        return sumQuantityOfOrderItemsAs("sumQuantityOfOrderItems");
    }

    public ProductRequest<T> sumQuantityOfOrderItemsAs(String name){
        return sumQuantityOfOrderItemsAs(name, Q.orderItems().unlimited());
    }

    public ProductRequest<T> sumQuantityOfOrderItemsAs(String name, OrderItemRequest subRequest){
        return statsFromOrderItemsAs(name, subRequest.sumQuantity(), true);
    }
    public ProductRequest<T> avgQuantityOfOrderItems(){
        return avgQuantityOfOrderItemsAs("avgQuantityOfOrderItems");
    }

    public ProductRequest<T> avgQuantityOfOrderItemsAs(String name){
        return avgQuantityOfOrderItemsAs(name, Q.orderItems().unlimited());
    }

    public ProductRequest<T> avgQuantityOfOrderItemsAs(String name, OrderItemRequest subRequest){
        return statsFromOrderItemsAs(name, subRequest.avgQuantity(), true);
    }
    public ProductRequest<T> standardDeviationQuantityOfOrderItems(){
        return standardDeviationQuantityOfOrderItemsAs("stdDevQuantityOfOrderItems");
    }

    public ProductRequest<T> standardDeviationQuantityOfOrderItemsAs(String name){
        return standardDeviationQuantityOfOrderItemsAs(name, Q.orderItems().unlimited());
    }

    public ProductRequest<T> standardDeviationQuantityOfOrderItemsAs(String name, OrderItemRequest subRequest){
        return statsFromOrderItemsAs(name, subRequest.standardDeviationQuantity(), true);
    }
    public ProductRequest<T> squareRootOfPopulationStandardDeviationQuantityOfOrderItems(){
        return squareRootOfPopulationStandardDeviationQuantityOfOrderItemsAs("stdDevPopQuantityOfOrderItems");
    }

    public ProductRequest<T> squareRootOfPopulationStandardDeviationQuantityOfOrderItemsAs(String name){
        return squareRootOfPopulationStandardDeviationQuantityOfOrderItemsAs(name, Q.orderItems().unlimited());
    }

    public ProductRequest<T> squareRootOfPopulationStandardDeviationQuantityOfOrderItemsAs(String name, OrderItemRequest subRequest){
        return statsFromOrderItemsAs(name, subRequest.squareRootOfPopulationStandardDeviationQuantity(), true);
    }
    public ProductRequest<T> sampleVarianceQuantityOfOrderItems(){
        return sampleVarianceQuantityOfOrderItemsAs("varSampQuantityOfOrderItems");
    }

    public ProductRequest<T> sampleVarianceQuantityOfOrderItemsAs(String name){
        return sampleVarianceQuantityOfOrderItemsAs(name, Q.orderItems().unlimited());
    }

    public ProductRequest<T> sampleVarianceQuantityOfOrderItemsAs(String name, OrderItemRequest subRequest){
        return statsFromOrderItemsAs(name, subRequest.sampleVarianceQuantity(), true);
    }
    public ProductRequest<T> samplePopulationVarianceQuantityOfOrderItems(){
        return samplePopulationVarianceQuantityOfOrderItemsAs("varPopQuantityOfOrderItems");
    }

    public ProductRequest<T> samplePopulationVarianceQuantityOfOrderItemsAs(String name){
        return samplePopulationVarianceQuantityOfOrderItemsAs(name, Q.orderItems().unlimited());
    }

    public ProductRequest<T> samplePopulationVarianceQuantityOfOrderItemsAs(String name, OrderItemRequest subRequest){
        return statsFromOrderItemsAs(name, subRequest.samplePopulationVarianceQuantity(), true);
    }
    public ProductRequest<T> minQuantityOnHandOfInventoryItems(){
        return minQuantityOnHandOfInventoryItemsAs("minQuantityOnHandOfInventoryItems");
    }

    public ProductRequest<T> minQuantityOnHandOfInventoryItemsAs(String name){
        return minQuantityOnHandOfInventoryItemsAs(name, Q.inventoryItems().unlimited());
    }

    public ProductRequest<T> minQuantityOnHandOfInventoryItemsAs(String name, InventoryItemRequest subRequest){
        return statsFromInventoryItemsAs(name, subRequest.minQuantityOnHand(), true);
    }
    public ProductRequest<T> maxQuantityOnHandOfInventoryItems(){
        return maxQuantityOnHandOfInventoryItemsAs("maxQuantityOnHandOfInventoryItems");
    }

    public ProductRequest<T> maxQuantityOnHandOfInventoryItemsAs(String name){
        return maxQuantityOnHandOfInventoryItemsAs(name, Q.inventoryItems().unlimited());
    }

    public ProductRequest<T> maxQuantityOnHandOfInventoryItemsAs(String name, InventoryItemRequest subRequest){
        return statsFromInventoryItemsAs(name, subRequest.maxQuantityOnHand(), true);
    }
    public ProductRequest<T> sumQuantityOnHandOfInventoryItems(){
        return sumQuantityOnHandOfInventoryItemsAs("sumQuantityOnHandOfInventoryItems");
    }

    public ProductRequest<T> sumQuantityOnHandOfInventoryItemsAs(String name){
        return sumQuantityOnHandOfInventoryItemsAs(name, Q.inventoryItems().unlimited());
    }

    public ProductRequest<T> sumQuantityOnHandOfInventoryItemsAs(String name, InventoryItemRequest subRequest){
        return statsFromInventoryItemsAs(name, subRequest.sumQuantityOnHand(), true);
    }
    public ProductRequest<T> avgQuantityOnHandOfInventoryItems(){
        return avgQuantityOnHandOfInventoryItemsAs("avgQuantityOnHandOfInventoryItems");
    }

    public ProductRequest<T> avgQuantityOnHandOfInventoryItemsAs(String name){
        return avgQuantityOnHandOfInventoryItemsAs(name, Q.inventoryItems().unlimited());
    }

    public ProductRequest<T> avgQuantityOnHandOfInventoryItemsAs(String name, InventoryItemRequest subRequest){
        return statsFromInventoryItemsAs(name, subRequest.avgQuantityOnHand(), true);
    }
    public ProductRequest<T> standardDeviationQuantityOnHandOfInventoryItems(){
        return standardDeviationQuantityOnHandOfInventoryItemsAs("stdDevQuantityOnHandOfInventoryItems");
    }

    public ProductRequest<T> standardDeviationQuantityOnHandOfInventoryItemsAs(String name){
        return standardDeviationQuantityOnHandOfInventoryItemsAs(name, Q.inventoryItems().unlimited());
    }

    public ProductRequest<T> standardDeviationQuantityOnHandOfInventoryItemsAs(String name, InventoryItemRequest subRequest){
        return statsFromInventoryItemsAs(name, subRequest.standardDeviationQuantityOnHand(), true);
    }
    public ProductRequest<T> squareRootOfPopulationStandardDeviationQuantityOnHandOfInventoryItems(){
        return squareRootOfPopulationStandardDeviationQuantityOnHandOfInventoryItemsAs("stdDevPopQuantityOnHandOfInventoryItems");
    }

    public ProductRequest<T> squareRootOfPopulationStandardDeviationQuantityOnHandOfInventoryItemsAs(String name){
        return squareRootOfPopulationStandardDeviationQuantityOnHandOfInventoryItemsAs(name, Q.inventoryItems().unlimited());
    }

    public ProductRequest<T> squareRootOfPopulationStandardDeviationQuantityOnHandOfInventoryItemsAs(String name, InventoryItemRequest subRequest){
        return statsFromInventoryItemsAs(name, subRequest.squareRootOfPopulationStandardDeviationQuantityOnHand(), true);
    }
    public ProductRequest<T> sampleVarianceQuantityOnHandOfInventoryItems(){
        return sampleVarianceQuantityOnHandOfInventoryItemsAs("varSampQuantityOnHandOfInventoryItems");
    }

    public ProductRequest<T> sampleVarianceQuantityOnHandOfInventoryItemsAs(String name){
        return sampleVarianceQuantityOnHandOfInventoryItemsAs(name, Q.inventoryItems().unlimited());
    }

    public ProductRequest<T> sampleVarianceQuantityOnHandOfInventoryItemsAs(String name, InventoryItemRequest subRequest){
        return statsFromInventoryItemsAs(name, subRequest.sampleVarianceQuantityOnHand(), true);
    }
    public ProductRequest<T> samplePopulationVarianceQuantityOnHandOfInventoryItems(){
        return samplePopulationVarianceQuantityOnHandOfInventoryItemsAs("varPopQuantityOnHandOfInventoryItems");
    }

    public ProductRequest<T> samplePopulationVarianceQuantityOnHandOfInventoryItemsAs(String name){
        return samplePopulationVarianceQuantityOnHandOfInventoryItemsAs(name, Q.inventoryItems().unlimited());
    }

    public ProductRequest<T> samplePopulationVarianceQuantityOnHandOfInventoryItemsAs(String name, InventoryItemRequest subRequest){
        return statsFromInventoryItemsAs(name, subRequest.samplePopulationVarianceQuantityOnHand(), true);
    }
    public ProductRequest<T> minReorderLevelOfInventoryItems(){
        return minReorderLevelOfInventoryItemsAs("minReorderLevelOfInventoryItems");
    }

    public ProductRequest<T> minReorderLevelOfInventoryItemsAs(String name){
        return minReorderLevelOfInventoryItemsAs(name, Q.inventoryItems().unlimited());
    }

    public ProductRequest<T> minReorderLevelOfInventoryItemsAs(String name, InventoryItemRequest subRequest){
        return statsFromInventoryItemsAs(name, subRequest.minReorderLevel(), true);
    }
    public ProductRequest<T> maxReorderLevelOfInventoryItems(){
        return maxReorderLevelOfInventoryItemsAs("maxReorderLevelOfInventoryItems");
    }

    public ProductRequest<T> maxReorderLevelOfInventoryItemsAs(String name){
        return maxReorderLevelOfInventoryItemsAs(name, Q.inventoryItems().unlimited());
    }

    public ProductRequest<T> maxReorderLevelOfInventoryItemsAs(String name, InventoryItemRequest subRequest){
        return statsFromInventoryItemsAs(name, subRequest.maxReorderLevel(), true);
    }
    public ProductRequest<T> sumReorderLevelOfInventoryItems(){
        return sumReorderLevelOfInventoryItemsAs("sumReorderLevelOfInventoryItems");
    }

    public ProductRequest<T> sumReorderLevelOfInventoryItemsAs(String name){
        return sumReorderLevelOfInventoryItemsAs(name, Q.inventoryItems().unlimited());
    }

    public ProductRequest<T> sumReorderLevelOfInventoryItemsAs(String name, InventoryItemRequest subRequest){
        return statsFromInventoryItemsAs(name, subRequest.sumReorderLevel(), true);
    }
    public ProductRequest<T> avgReorderLevelOfInventoryItems(){
        return avgReorderLevelOfInventoryItemsAs("avgReorderLevelOfInventoryItems");
    }

    public ProductRequest<T> avgReorderLevelOfInventoryItemsAs(String name){
        return avgReorderLevelOfInventoryItemsAs(name, Q.inventoryItems().unlimited());
    }

    public ProductRequest<T> avgReorderLevelOfInventoryItemsAs(String name, InventoryItemRequest subRequest){
        return statsFromInventoryItemsAs(name, subRequest.avgReorderLevel(), true);
    }
    public ProductRequest<T> standardDeviationReorderLevelOfInventoryItems(){
        return standardDeviationReorderLevelOfInventoryItemsAs("stdDevReorderLevelOfInventoryItems");
    }

    public ProductRequest<T> standardDeviationReorderLevelOfInventoryItemsAs(String name){
        return standardDeviationReorderLevelOfInventoryItemsAs(name, Q.inventoryItems().unlimited());
    }

    public ProductRequest<T> standardDeviationReorderLevelOfInventoryItemsAs(String name, InventoryItemRequest subRequest){
        return statsFromInventoryItemsAs(name, subRequest.standardDeviationReorderLevel(), true);
    }
    public ProductRequest<T> squareRootOfPopulationStandardDeviationReorderLevelOfInventoryItems(){
        return squareRootOfPopulationStandardDeviationReorderLevelOfInventoryItemsAs("stdDevPopReorderLevelOfInventoryItems");
    }

    public ProductRequest<T> squareRootOfPopulationStandardDeviationReorderLevelOfInventoryItemsAs(String name){
        return squareRootOfPopulationStandardDeviationReorderLevelOfInventoryItemsAs(name, Q.inventoryItems().unlimited());
    }

    public ProductRequest<T> squareRootOfPopulationStandardDeviationReorderLevelOfInventoryItemsAs(String name, InventoryItemRequest subRequest){
        return statsFromInventoryItemsAs(name, subRequest.squareRootOfPopulationStandardDeviationReorderLevel(), true);
    }
    public ProductRequest<T> sampleVarianceReorderLevelOfInventoryItems(){
        return sampleVarianceReorderLevelOfInventoryItemsAs("varSampReorderLevelOfInventoryItems");
    }

    public ProductRequest<T> sampleVarianceReorderLevelOfInventoryItemsAs(String name){
        return sampleVarianceReorderLevelOfInventoryItemsAs(name, Q.inventoryItems().unlimited());
    }

    public ProductRequest<T> sampleVarianceReorderLevelOfInventoryItemsAs(String name, InventoryItemRequest subRequest){
        return statsFromInventoryItemsAs(name, subRequest.sampleVarianceReorderLevel(), true);
    }
    public ProductRequest<T> samplePopulationVarianceReorderLevelOfInventoryItems(){
        return samplePopulationVarianceReorderLevelOfInventoryItemsAs("varPopReorderLevelOfInventoryItems");
    }

    public ProductRequest<T> samplePopulationVarianceReorderLevelOfInventoryItemsAs(String name){
        return samplePopulationVarianceReorderLevelOfInventoryItemsAs(name, Q.inventoryItems().unlimited());
    }

    public ProductRequest<T> samplePopulationVarianceReorderLevelOfInventoryItemsAs(String name, InventoryItemRequest subRequest){
        return statsFromInventoryItemsAs(name, subRequest.samplePopulationVarianceReorderLevel(), true);
    }
    public ProductRequest<T> minQuantityOfPurchaseOrderItems(){
        return minQuantityOfPurchaseOrderItemsAs("minQuantityOfPurchaseOrderItems");
    }

    public ProductRequest<T> minQuantityOfPurchaseOrderItemsAs(String name){
        return minQuantityOfPurchaseOrderItemsAs(name, Q.purchaseOrderItems().unlimited());
    }

    public ProductRequest<T> minQuantityOfPurchaseOrderItemsAs(String name, PurchaseOrderItemRequest subRequest){
        return statsFromPurchaseOrderItemsAs(name, subRequest.minQuantity(), true);
    }
    public ProductRequest<T> maxQuantityOfPurchaseOrderItems(){
        return maxQuantityOfPurchaseOrderItemsAs("maxQuantityOfPurchaseOrderItems");
    }

    public ProductRequest<T> maxQuantityOfPurchaseOrderItemsAs(String name){
        return maxQuantityOfPurchaseOrderItemsAs(name, Q.purchaseOrderItems().unlimited());
    }

    public ProductRequest<T> maxQuantityOfPurchaseOrderItemsAs(String name, PurchaseOrderItemRequest subRequest){
        return statsFromPurchaseOrderItemsAs(name, subRequest.maxQuantity(), true);
    }
    public ProductRequest<T> sumQuantityOfPurchaseOrderItems(){
        return sumQuantityOfPurchaseOrderItemsAs("sumQuantityOfPurchaseOrderItems");
    }

    public ProductRequest<T> sumQuantityOfPurchaseOrderItemsAs(String name){
        return sumQuantityOfPurchaseOrderItemsAs(name, Q.purchaseOrderItems().unlimited());
    }

    public ProductRequest<T> sumQuantityOfPurchaseOrderItemsAs(String name, PurchaseOrderItemRequest subRequest){
        return statsFromPurchaseOrderItemsAs(name, subRequest.sumQuantity(), true);
    }
    public ProductRequest<T> avgQuantityOfPurchaseOrderItems(){
        return avgQuantityOfPurchaseOrderItemsAs("avgQuantityOfPurchaseOrderItems");
    }

    public ProductRequest<T> avgQuantityOfPurchaseOrderItemsAs(String name){
        return avgQuantityOfPurchaseOrderItemsAs(name, Q.purchaseOrderItems().unlimited());
    }

    public ProductRequest<T> avgQuantityOfPurchaseOrderItemsAs(String name, PurchaseOrderItemRequest subRequest){
        return statsFromPurchaseOrderItemsAs(name, subRequest.avgQuantity(), true);
    }
    public ProductRequest<T> standardDeviationQuantityOfPurchaseOrderItems(){
        return standardDeviationQuantityOfPurchaseOrderItemsAs("stdDevQuantityOfPurchaseOrderItems");
    }

    public ProductRequest<T> standardDeviationQuantityOfPurchaseOrderItemsAs(String name){
        return standardDeviationQuantityOfPurchaseOrderItemsAs(name, Q.purchaseOrderItems().unlimited());
    }

    public ProductRequest<T> standardDeviationQuantityOfPurchaseOrderItemsAs(String name, PurchaseOrderItemRequest subRequest){
        return statsFromPurchaseOrderItemsAs(name, subRequest.standardDeviationQuantity(), true);
    }
    public ProductRequest<T> squareRootOfPopulationStandardDeviationQuantityOfPurchaseOrderItems(){
        return squareRootOfPopulationStandardDeviationQuantityOfPurchaseOrderItemsAs("stdDevPopQuantityOfPurchaseOrderItems");
    }

    public ProductRequest<T> squareRootOfPopulationStandardDeviationQuantityOfPurchaseOrderItemsAs(String name){
        return squareRootOfPopulationStandardDeviationQuantityOfPurchaseOrderItemsAs(name, Q.purchaseOrderItems().unlimited());
    }

    public ProductRequest<T> squareRootOfPopulationStandardDeviationQuantityOfPurchaseOrderItemsAs(String name, PurchaseOrderItemRequest subRequest){
        return statsFromPurchaseOrderItemsAs(name, subRequest.squareRootOfPopulationStandardDeviationQuantity(), true);
    }
    public ProductRequest<T> sampleVarianceQuantityOfPurchaseOrderItems(){
        return sampleVarianceQuantityOfPurchaseOrderItemsAs("varSampQuantityOfPurchaseOrderItems");
    }

    public ProductRequest<T> sampleVarianceQuantityOfPurchaseOrderItemsAs(String name){
        return sampleVarianceQuantityOfPurchaseOrderItemsAs(name, Q.purchaseOrderItems().unlimited());
    }

    public ProductRequest<T> sampleVarianceQuantityOfPurchaseOrderItemsAs(String name, PurchaseOrderItemRequest subRequest){
        return statsFromPurchaseOrderItemsAs(name, subRequest.sampleVarianceQuantity(), true);
    }
    public ProductRequest<T> samplePopulationVarianceQuantityOfPurchaseOrderItems(){
        return samplePopulationVarianceQuantityOfPurchaseOrderItemsAs("varPopQuantityOfPurchaseOrderItems");
    }

    public ProductRequest<T> samplePopulationVarianceQuantityOfPurchaseOrderItemsAs(String name){
        return samplePopulationVarianceQuantityOfPurchaseOrderItemsAs(name, Q.purchaseOrderItems().unlimited());
    }

    public ProductRequest<T> samplePopulationVarianceQuantityOfPurchaseOrderItemsAs(String name, PurchaseOrderItemRequest subRequest){
        return statsFromPurchaseOrderItemsAs(name, subRequest.samplePopulationVarianceQuantity(), true);
    }
    public ProductRequest<T> minUnitCostOfPurchaseOrderItems(){
        return minUnitCostOfPurchaseOrderItemsAs("minUnitCostOfPurchaseOrderItems");
    }

    public ProductRequest<T> minUnitCostOfPurchaseOrderItemsAs(String name){
        return minUnitCostOfPurchaseOrderItemsAs(name, Q.purchaseOrderItems().unlimited());
    }

    public ProductRequest<T> minUnitCostOfPurchaseOrderItemsAs(String name, PurchaseOrderItemRequest subRequest){
        return statsFromPurchaseOrderItemsAs(name, subRequest.minUnitCost(), true);
    }
    public ProductRequest<T> maxUnitCostOfPurchaseOrderItems(){
        return maxUnitCostOfPurchaseOrderItemsAs("maxUnitCostOfPurchaseOrderItems");
    }

    public ProductRequest<T> maxUnitCostOfPurchaseOrderItemsAs(String name){
        return maxUnitCostOfPurchaseOrderItemsAs(name, Q.purchaseOrderItems().unlimited());
    }

    public ProductRequest<T> maxUnitCostOfPurchaseOrderItemsAs(String name, PurchaseOrderItemRequest subRequest){
        return statsFromPurchaseOrderItemsAs(name, subRequest.maxUnitCost(), true);
    }
    public ProductRequest<T> sumUnitCostOfPurchaseOrderItems(){
        return sumUnitCostOfPurchaseOrderItemsAs("sumUnitCostOfPurchaseOrderItems");
    }

    public ProductRequest<T> sumUnitCostOfPurchaseOrderItemsAs(String name){
        return sumUnitCostOfPurchaseOrderItemsAs(name, Q.purchaseOrderItems().unlimited());
    }

    public ProductRequest<T> sumUnitCostOfPurchaseOrderItemsAs(String name, PurchaseOrderItemRequest subRequest){
        return statsFromPurchaseOrderItemsAs(name, subRequest.sumUnitCost(), true);
    }
    public ProductRequest<T> avgUnitCostOfPurchaseOrderItems(){
        return avgUnitCostOfPurchaseOrderItemsAs("avgUnitCostOfPurchaseOrderItems");
    }

    public ProductRequest<T> avgUnitCostOfPurchaseOrderItemsAs(String name){
        return avgUnitCostOfPurchaseOrderItemsAs(name, Q.purchaseOrderItems().unlimited());
    }

    public ProductRequest<T> avgUnitCostOfPurchaseOrderItemsAs(String name, PurchaseOrderItemRequest subRequest){
        return statsFromPurchaseOrderItemsAs(name, subRequest.avgUnitCost(), true);
    }
    public ProductRequest<T> standardDeviationUnitCostOfPurchaseOrderItems(){
        return standardDeviationUnitCostOfPurchaseOrderItemsAs("stdDevUnitCostOfPurchaseOrderItems");
    }

    public ProductRequest<T> standardDeviationUnitCostOfPurchaseOrderItemsAs(String name){
        return standardDeviationUnitCostOfPurchaseOrderItemsAs(name, Q.purchaseOrderItems().unlimited());
    }

    public ProductRequest<T> standardDeviationUnitCostOfPurchaseOrderItemsAs(String name, PurchaseOrderItemRequest subRequest){
        return statsFromPurchaseOrderItemsAs(name, subRequest.standardDeviationUnitCost(), true);
    }
    public ProductRequest<T> squareRootOfPopulationStandardDeviationUnitCostOfPurchaseOrderItems(){
        return squareRootOfPopulationStandardDeviationUnitCostOfPurchaseOrderItemsAs("stdDevPopUnitCostOfPurchaseOrderItems");
    }

    public ProductRequest<T> squareRootOfPopulationStandardDeviationUnitCostOfPurchaseOrderItemsAs(String name){
        return squareRootOfPopulationStandardDeviationUnitCostOfPurchaseOrderItemsAs(name, Q.purchaseOrderItems().unlimited());
    }

    public ProductRequest<T> squareRootOfPopulationStandardDeviationUnitCostOfPurchaseOrderItemsAs(String name, PurchaseOrderItemRequest subRequest){
        return statsFromPurchaseOrderItemsAs(name, subRequest.squareRootOfPopulationStandardDeviationUnitCost(), true);
    }
    public ProductRequest<T> sampleVarianceUnitCostOfPurchaseOrderItems(){
        return sampleVarianceUnitCostOfPurchaseOrderItemsAs("varSampUnitCostOfPurchaseOrderItems");
    }

    public ProductRequest<T> sampleVarianceUnitCostOfPurchaseOrderItemsAs(String name){
        return sampleVarianceUnitCostOfPurchaseOrderItemsAs(name, Q.purchaseOrderItems().unlimited());
    }

    public ProductRequest<T> sampleVarianceUnitCostOfPurchaseOrderItemsAs(String name, PurchaseOrderItemRequest subRequest){
        return statsFromPurchaseOrderItemsAs(name, subRequest.sampleVarianceUnitCost(), true);
    }
    public ProductRequest<T> samplePopulationVarianceUnitCostOfPurchaseOrderItems(){
        return samplePopulationVarianceUnitCostOfPurchaseOrderItemsAs("varPopUnitCostOfPurchaseOrderItems");
    }

    public ProductRequest<T> samplePopulationVarianceUnitCostOfPurchaseOrderItemsAs(String name){
        return samplePopulationVarianceUnitCostOfPurchaseOrderItemsAs(name, Q.purchaseOrderItems().unlimited());
    }

    public ProductRequest<T> samplePopulationVarianceUnitCostOfPurchaseOrderItemsAs(String name, PurchaseOrderItemRequest subRequest){
        return statsFromPurchaseOrderItemsAs(name, subRequest.samplePopulationVarianceUnitCost(), true);
    }

   public ProductRequest<T> facetByCategoryAs(String facetName, CategoryRequest category){
       return facetByCategoryAs(facetName, category, true);
   }

   public ProductRequest<T> facetByCategoryAs(String facetName, CategoryRequest category, boolean includeAllFacets){
       addFacet(facetName, Product.CATEGORY_PROPERTY, category, includeAllFacets);
       return this;
   }


    /**
     * get topN records
     * @param topN  records number
     */
    public ProductRequest<T> top(int topN) {
        super.top(topN);
        return this;
    }

    /**
     * get records from offset(inclusive) to offset+size(exclusive)
     * @param offset record offset
     * @param size records number
     */
    public ProductRequest<T> offset(int offset, int size) {
        super.offset(offset, size);
        return this;
    }

    /**
     * retrieve all records
     */
    public ProductRequest<T> unlimited() {
        super.unlimited();
        return this;
    }

    /**
     * get records of one page
     * @param pageNumber page number(1-based)
     * @param pageSize page size
     */
    public ProductRequest<T> page(int pageNumber, int pageSize) {
        int offset = (pageNumber - 1) * pageSize;
        return offset(offset, pageSize);
   }

    /**
     * get records of one page, default page size is 10
     * @param pageNumber page number(1-based)
     */
    public ProductRequest<T> page(int pageNumber) {
        return page(pageNumber, 10);
   }
}