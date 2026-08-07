
package com.example.enterpriseerpsystem.orderitem;

import com.example.enterpriseerpsystem.Q;
import com.example.enterpriseerpsystem.globalorder.GlobalOrder;
import com.example.enterpriseerpsystem.globalorder.GlobalOrderRequest;
import com.example.enterpriseerpsystem.product.Product;
import com.example.enterpriseerpsystem.product.ProductRequest;
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

public class OrderItemRequest<T extends OrderItem> extends BaseRequest<T> {

    /**
     * @deprecated AI agents and business code must use the generated Q facade
     *             instead of constructing request builders directly.
     */
    @Deprecated
    public OrderItemRequest(Class<T> returnType){
        super(returnType);
        selectId();
        selectVersion();
    }

    public OrderItemRequest<T> comment(String comment){
         super.internalComment(comment);
         return this;
    }

    // purpose() 继承自 BaseRequest，返回 ExecutableRequest（终结方法）

    public OrderItemRequest<T> returnType(Class<? extends T> returnType){
        super.setReturnType(returnType);
        return this;
    }

    public OrderItemRequest<T> enableAggregationCache(long cacheExpiredMillis){
        super.enableAggregationCache();
        super.aggregateCacheTime(cacheExpiredMillis);
        return this;
    }

    public OrderItemRequest<T> enableAggregationCache(){
        return enableAggregationCache(0l);
    }


    public OrderItemRequest<T> propagateAggregationCache(long cacheExpiredMillis){
        super.propagateAggregationCache(cacheExpiredMillis);
        return this;
    }

    public OrderItemRequest<T> appendSearchCriteria(SearchCriteria searchCriteria){
        return (OrderItemRequest<T>)super.appendSearchCriteria(searchCriteria);
    }

    public OrderItemRequest<T> filter(String property1, Operator operator, String property2){
        return appendSearchCriteria(new TwoOperatorCriteria(operator, new PropertyReference(property1), new PropertyReference(property2)));
    }


    public OrderItemRequest<T> matchingAnyOf(OrderItemRequest orderItem){
        super.internalMatchAny(orderItem);
        return this;
    }

    public OrderItemRequest<T> enhanceChildrenIfNeeded(){
        return this;
    }

    public OrderItemRequest<T> withDeletedRows(){
        super.withDeletedRows();
        return this;
    }

    public OrderItemRequest<T> deletedRowsOnly(){
        super.deletedRowsOnly();
        return this;
    }

    public OrderItemRequest<T> selectSelf(){
        super.selectSelf();
        return selectId().selectUnitPrice().selectGlobalOrderIdOnly().selectProductIdOnly().selectQuantity().selectCreateTime().selectUpdateTime().selectVersion();
    }

    public OrderItemRequest<T> selectSelfFields(){
        return selectSelf();
    }

    public OrderItemRequest<T> selectAll(){
        super.selectAll();
        return selectId().selectUnitPrice().selectGlobalOrder().selectProduct().selectQuantity().selectCreateTime().selectUpdateTime().selectVersion();
    }

    public OrderItemRequest<T> selectChildren(){
        super.selectAny();
        return selectId().selectUnitPrice().selectGlobalOrder().selectProduct().selectQuantity().selectCreateTime().selectUpdateTime().selectVersion();
    }


    public OrderItemRequest<T> selectId(){
       selectProperty(OrderItem.ID_PROPERTY);
       return this;
    }

    /**
     * fill the id with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  id) to fetch id property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public OrderItemRequest<T> unselectId(){
       unselectProperty(OrderItem.ID_PROPERTY);
       return this;
    }
    public OrderItemRequest<T> selectUnitPrice(){
       selectProperty(OrderItem.UNIT_PRICE_PROPERTY);
       return this;
    }

    /**
     * fill the unitPrice with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  unitPrice) to fetch unitPrice property.
     * @param rawSqlSegment  customized rawSqlSegment
     */


    /**
     * fill the unitPrice with customized aggrFunction, TEAQL uses ({aggrFunction}(unitPrice) AS unitPrice to fetch unitPrice property.
     * @param aggrFunction  aggrFunction
     */
    public OrderItemRequest<T> selectUnitPrice(AggrFunction aggrFunction){
       selectProperty(OrderItem.UNIT_PRICE_PROPERTY, aggrFunction);
       return this;
    }


    public OrderItemRequest<T> unselectUnitPrice(){
       unselectProperty(OrderItem.UNIT_PRICE_PROPERTY);
       return this;
    }
    public OrderItemRequest<T> selectGlobalOrderIdOnly(){
       selectProperty(OrderItem.GLOBAL_ORDER_PROPERTY);
       return this;
    }

    public OrderItemRequest<T> selectGlobalOrder(){
        return selectGlobalOrderWith(Q.globalOrders().unlimited().selectSelf());
    }

    public OrderItemRequest<T> selectGlobalOrderWith(GlobalOrderRequest globalOrder){
       selectProperty(OrderItem.GLOBAL_ORDER_PROPERTY);
       enhanceRelation(OrderItem.GLOBAL_ORDER_PROPERTY, globalOrder);
       return this;
    }

    public OrderItemRequest<T> unselectGlobalOrder(){
       unselectProperty(OrderItem.GLOBAL_ORDER_PROPERTY);
       return this;
    }
    public OrderItemRequest<T> selectProductIdOnly(){
       selectProperty(OrderItem.PRODUCT_PROPERTY);
       return this;
    }

    public OrderItemRequest<T> selectProduct(){
        return selectProductWith(Q.products().unlimited().selectSelf());
    }

    public OrderItemRequest<T> selectProductWith(ProductRequest product){
       selectProperty(OrderItem.PRODUCT_PROPERTY);
       enhanceRelation(OrderItem.PRODUCT_PROPERTY, product);
       return this;
    }

    public OrderItemRequest<T> unselectProduct(){
       unselectProperty(OrderItem.PRODUCT_PROPERTY);
       return this;
    }
    public OrderItemRequest<T> selectQuantity(){
       selectProperty(OrderItem.QUANTITY_PROPERTY);
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
    public OrderItemRequest<T> selectQuantity(AggrFunction aggrFunction){
       selectProperty(OrderItem.QUANTITY_PROPERTY, aggrFunction);
       return this;
    }


    public OrderItemRequest<T> unselectQuantity(){
       unselectProperty(OrderItem.QUANTITY_PROPERTY);
       return this;
    }
    public OrderItemRequest<T> selectCreateTime(){
       selectProperty(OrderItem.CREATE_TIME_PROPERTY);
       return this;
    }

    /**
     * fill the createTime with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  createTime) to fetch createTime property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public OrderItemRequest<T> unselectCreateTime(){
       unselectProperty(OrderItem.CREATE_TIME_PROPERTY);
       return this;
    }
    public OrderItemRequest<T> selectUpdateTime(){
       selectProperty(OrderItem.UPDATE_TIME_PROPERTY);
       return this;
    }

    /**
     * fill the updateTime with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  updateTime) to fetch updateTime property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public OrderItemRequest<T> unselectUpdateTime(){
       unselectProperty(OrderItem.UPDATE_TIME_PROPERTY);
       return this;
    }
    public OrderItemRequest<T> selectVersion(){
       selectProperty(OrderItem.VERSION_PROPERTY);
       return this;
    }

    /**
     * fill the version with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  version) to fetch version property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public OrderItemRequest<T> unselectVersion(){
       unselectProperty(OrderItem.VERSION_PROPERTY);
       return this;
    }

    public OrderItemRequest<T> withId(Operator operator, Object... values){
       return appendSearchCriteria(createIdCriteria(operator, values));
    }

    public SearchCriteria createIdCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(OrderItem.ID_PROPERTY, operator, values);
    }

    public OrderItemRequest<T> withIdIs(Long id){
       return withId(Operator.EQUAL, id);
    }
    public OrderItemRequest<T> withIdIn(Long... id){
       return withId(Operator.EQUAL, (Object[])id);
    }



    public OrderItemRequest<T> filterByUnitPrice(BigDecimal... unitPrice){
      if (unitPrice == null || unitPrice.length == 0) {
        throw new IllegalArgumentException("filterByUnitPrice parameter unitPrice cannot be empty");
      }
      return appendSearchCriteria(createUnitPriceCriteria(Operator.EQUAL, (Object[])unitPrice));
    }

    public OrderItemRequest<T> withUnitPrice(Operator operator, Object... values){
       return appendSearchCriteria(createUnitPriceCriteria(operator, values));
    }

    public OrderItemRequest<T> withUnitPriceIsUnknown(){
       return withUnitPrice(Operator.IS_NULL);
    }

    public OrderItemRequest<T> withUnitPriceIsKnown(){
       return withUnitPrice(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createUnitPriceCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(OrderItem.UNIT_PRICE_PROPERTY, operator, values);
    }

    public OrderItemRequest<T> withUnitPriceGreaterThan(BigDecimal unitPrice){
       return withUnitPrice(Operator.GREATER_THAN, unitPrice);
    }

    public OrderItemRequest<T> withUnitPriceGreaterThanOrEqualTo(BigDecimal unitPrice){
       return withUnitPrice(Operator.GREATER_THAN_OR_EQUAL, unitPrice);
    }

    public OrderItemRequest<T> withUnitPriceLessThan(BigDecimal unitPrice){
       return withUnitPrice(Operator.LESS_THAN, unitPrice);
    }

    public OrderItemRequest<T> withUnitPriceLessThanOrEqualTo(BigDecimal unitPrice){
       return withUnitPrice(Operator.LESS_THAN_OR_EQUAL, unitPrice);
    }

    public OrderItemRequest<T> withUnitPriceBetween(BigDecimal startOfUnitPrice, BigDecimal endOfUnitPrice){
       return withUnitPrice(Operator.BETWEEN, startOfUnitPrice, endOfUnitPrice);
    }



    public OrderItemRequest<T> filterByGlobalOrder(GlobalOrder... globalOrder){
      if (globalOrder == null || globalOrder.length == 0) {
        throw new IllegalArgumentException("filterByGlobalOrder parameter globalOrder cannot be empty");
      }
      return appendSearchCriteria(createGlobalOrderCriteria(Operator.EQUAL, (Object[])globalOrder));
    }

    public OrderItemRequest<T> withGlobalOrder(Operator operator, Object... values){
       return appendSearchCriteria(createGlobalOrderCriteria(operator, values));
    }

    public OrderItemRequest<T> withGlobalOrderIsUnknown(){
       return withGlobalOrder(Operator.IS_NULL);
    }

    public OrderItemRequest<T> withGlobalOrderIsKnown(){
       return withGlobalOrder(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createGlobalOrderCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(OrderItem.GLOBAL_ORDER_PROPERTY, operator, values);
    }

    public OrderItemRequest<T> filterByGlobalOrder(Long globalOrder){
      if(globalOrder == null){
         return this;
      }
      return withGlobalOrder(Operator.EQUAL, globalOrder);
    }
    public OrderItemRequest<T> withGlobalOrderMatching(GlobalOrderRequest globalOrder){
       return appendSearchCriteria(new SubQuerySearchCriteria(OrderItem.GLOBAL_ORDER_PROPERTY, globalOrder, GlobalOrder.ID_PROPERTY));
    }

    public OrderItemRequest<T> filterByProduct(Product... product){
      if (product == null || product.length == 0) {
        throw new IllegalArgumentException("filterByProduct parameter product cannot be empty");
      }
      return appendSearchCriteria(createProductCriteria(Operator.EQUAL, (Object[])product));
    }

    public OrderItemRequest<T> withProduct(Operator operator, Object... values){
       return appendSearchCriteria(createProductCriteria(operator, values));
    }

    public OrderItemRequest<T> withProductIsUnknown(){
       return withProduct(Operator.IS_NULL);
    }

    public OrderItemRequest<T> withProductIsKnown(){
       return withProduct(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createProductCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(OrderItem.PRODUCT_PROPERTY, operator, values);
    }

    public OrderItemRequest<T> filterByProduct(Long product){
      if(product == null){
         return this;
      }
      return withProduct(Operator.EQUAL, product);
    }
    public OrderItemRequest<T> withProductMatching(ProductRequest product){
       return appendSearchCriteria(new SubQuerySearchCriteria(OrderItem.PRODUCT_PROPERTY, product, Product.ID_PROPERTY));
    }

    public OrderItemRequest<T> filterByQuantity(BigDecimal... quantity){
      if (quantity == null || quantity.length == 0) {
        throw new IllegalArgumentException("filterByQuantity parameter quantity cannot be empty");
      }
      return appendSearchCriteria(createQuantityCriteria(Operator.EQUAL, (Object[])quantity));
    }

    public OrderItemRequest<T> withQuantity(Operator operator, Object... values){
       return appendSearchCriteria(createQuantityCriteria(operator, values));
    }

    public OrderItemRequest<T> withQuantityIsUnknown(){
       return withQuantity(Operator.IS_NULL);
    }

    public OrderItemRequest<T> withQuantityIsKnown(){
       return withQuantity(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createQuantityCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(OrderItem.QUANTITY_PROPERTY, operator, values);
    }

    public OrderItemRequest<T> withQuantityGreaterThan(BigDecimal quantity){
       return withQuantity(Operator.GREATER_THAN, quantity);
    }

    public OrderItemRequest<T> withQuantityGreaterThanOrEqualTo(BigDecimal quantity){
       return withQuantity(Operator.GREATER_THAN_OR_EQUAL, quantity);
    }

    public OrderItemRequest<T> withQuantityLessThan(BigDecimal quantity){
       return withQuantity(Operator.LESS_THAN, quantity);
    }

    public OrderItemRequest<T> withQuantityLessThanOrEqualTo(BigDecimal quantity){
       return withQuantity(Operator.LESS_THAN_OR_EQUAL, quantity);
    }

    public OrderItemRequest<T> withQuantityBetween(BigDecimal startOfQuantity, BigDecimal endOfQuantity){
       return withQuantity(Operator.BETWEEN, startOfQuantity, endOfQuantity);
    }



    public OrderItemRequest<T> filterByCreateTime(LocalDateTime... createTime){
      if (createTime == null || createTime.length == 0) {
        throw new IllegalArgumentException("filterByCreateTime parameter createTime cannot be empty");
      }
      return appendSearchCriteria(createCreateTimeCriteria(Operator.EQUAL, (Object[])createTime));
    }

    public OrderItemRequest<T> withCreateTime(Operator operator, Object... values){
       return appendSearchCriteria(createCreateTimeCriteria(operator, values));
    }

    public OrderItemRequest<T> withCreateTimeIsUnknown(){
       return withCreateTime(Operator.IS_NULL);
    }

    public OrderItemRequest<T> withCreateTimeIsKnown(){
       return withCreateTime(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createCreateTimeCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(OrderItem.CREATE_TIME_PROPERTY, operator, values);
    }

    public OrderItemRequest<T> withCreateTimeGreaterThan(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public OrderItemRequest<T> withCreateTimeGreaterThanOrEqualTo(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN_OR_EQUAL, createTime);
    }

    public OrderItemRequest<T> withCreateTimeLessThan(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public OrderItemRequest<T> withCreateTimeLessThanOrEqualTo(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN_OR_EQUAL, createTime);
    }

    public OrderItemRequest<T> withCreateTimeBetween(LocalDateTime startOfCreateTime, LocalDateTime endOfCreateTime){
       return withCreateTime(Operator.BETWEEN, startOfCreateTime, endOfCreateTime);
    }
    public OrderItemRequest<T> withCreateTimeBefore(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public OrderItemRequest<T> withCreateTimeBefore(Date createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public OrderItemRequest<T> withCreateTimeAfter(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public OrderItemRequest<T> withCreateTimeAfter(Date createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public OrderItemRequest<T> withCreateTimeBetween(Date startOfCreateTime, Date endOfCreateTime){
       return withCreateTime(Operator.BETWEEN, startOfCreateTime, endOfCreateTime);
    }




    public OrderItemRequest<T> filterByUpdateTime(LocalDateTime... updateTime){
      if (updateTime == null || updateTime.length == 0) {
        throw new IllegalArgumentException("filterByUpdateTime parameter updateTime cannot be empty");
      }
      return appendSearchCriteria(createUpdateTimeCriteria(Operator.EQUAL, (Object[])updateTime));
    }

    public OrderItemRequest<T> withUpdateTime(Operator operator, Object... values){
       return appendSearchCriteria(createUpdateTimeCriteria(operator, values));
    }

    public OrderItemRequest<T> withUpdateTimeIsUnknown(){
       return withUpdateTime(Operator.IS_NULL);
    }

    public OrderItemRequest<T> withUpdateTimeIsKnown(){
       return withUpdateTime(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createUpdateTimeCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(OrderItem.UPDATE_TIME_PROPERTY, operator, values);
    }

    public OrderItemRequest<T> withUpdateTimeGreaterThan(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public OrderItemRequest<T> withUpdateTimeGreaterThanOrEqualTo(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN_OR_EQUAL, updateTime);
    }

    public OrderItemRequest<T> withUpdateTimeLessThan(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public OrderItemRequest<T> withUpdateTimeLessThanOrEqualTo(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN_OR_EQUAL, updateTime);
    }

    public OrderItemRequest<T> withUpdateTimeBetween(LocalDateTime startOfUpdateTime, LocalDateTime endOfUpdateTime){
       return withUpdateTime(Operator.BETWEEN, startOfUpdateTime, endOfUpdateTime);
    }
    public OrderItemRequest<T> withUpdateTimeBefore(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public OrderItemRequest<T> withUpdateTimeBefore(Date updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public OrderItemRequest<T> withUpdateTimeAfter(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public OrderItemRequest<T> withUpdateTimeAfter(Date updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public OrderItemRequest<T> withUpdateTimeBetween(Date startOfUpdateTime, Date endOfUpdateTime){
       return withUpdateTime(Operator.BETWEEN, startOfUpdateTime, endOfUpdateTime);
    }




    public OrderItemRequest<T> filterByVersion(Long... version){
      if (version == null || version.length == 0) {
        throw new IllegalArgumentException("filterByVersion parameter version cannot be empty");
      }
      return appendSearchCriteria(createVersionCriteria(Operator.EQUAL, (Object[])version));
    }

    public OrderItemRequest<T> withVersion(Operator operator, Object... values){
       return appendSearchCriteria(createVersionCriteria(operator, values));
    }

    public OrderItemRequest<T> withVersionIsUnknown(){
       return withVersion(Operator.IS_NULL);
    }

    public OrderItemRequest<T> withVersionIsKnown(){
       return withVersion(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createVersionCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(OrderItem.VERSION_PROPERTY, operator, values);
    }

    public OrderItemRequest<T> withVersionGreaterThan(Long version){
       return withVersion(Operator.GREATER_THAN, version);
    }

    public OrderItemRequest<T> withVersionGreaterThanOrEqualTo(Long version){
       return withVersion(Operator.GREATER_THAN_OR_EQUAL, version);
    }

    public OrderItemRequest<T> withVersionLessThan(Long version){
       return withVersion(Operator.LESS_THAN, version);
    }

    public OrderItemRequest<T> withVersionLessThanOrEqualTo(Long version){
       return withVersion(Operator.LESS_THAN_OR_EQUAL, version);
    }

    public OrderItemRequest<T> withVersionBetween(Long startOfVersion, Long endOfVersion){
       return withVersion(Operator.BETWEEN, startOfVersion, endOfVersion);
    }


    public OrderItemRequest<T> count(){
        super.count();
        return this;
    }
    public OrderItemRequest<T> countAs(String retName){
        super.count(retName);
        return this;
    }
    public OrderItemRequest minUnitPrice(){
        return minUnitPriceAs(prefix("minOf",OrderItem.UNIT_PRICE_PROPERTY));
    }

    public OrderItemRequest minUnitPriceAs(String retName){
        super.min(retName, OrderItem.UNIT_PRICE_PROPERTY);
        return this;
    }
    public OrderItemRequest maxUnitPrice(){
        return maxUnitPriceAs(prefix("maxOf",OrderItem.UNIT_PRICE_PROPERTY));
    }

    public OrderItemRequest maxUnitPriceAs(String retName){
        super.max(retName, OrderItem.UNIT_PRICE_PROPERTY);
        return this;
    }
    public OrderItemRequest sumUnitPrice(){
        return sumUnitPriceAs(prefix("sumOf",OrderItem.UNIT_PRICE_PROPERTY));
    }

    public OrderItemRequest sumUnitPriceAs(String retName){
        super.sum(retName, OrderItem.UNIT_PRICE_PROPERTY);
        return this;
    }
    public OrderItemRequest avgUnitPrice(){
        return avgUnitPriceAs(prefix("avgOf",OrderItem.UNIT_PRICE_PROPERTY));
    }

    public OrderItemRequest avgUnitPriceAs(String retName){
        super.avg(retName, OrderItem.UNIT_PRICE_PROPERTY);
        return this;
    }
    public OrderItemRequest standardDeviationUnitPrice(){
        return standardDeviationUnitPriceAs(prefix("standardDeviationOf",OrderItem.UNIT_PRICE_PROPERTY));
    }

    public OrderItemRequest standardDeviationUnitPriceAs(String retName){
        super.standardDeviation(retName, OrderItem.UNIT_PRICE_PROPERTY);
        return this;
    }
    public OrderItemRequest squareRootOfPopulationStandardDeviationUnitPrice(){
        return squareRootOfPopulationStandardDeviationUnitPriceAs(prefix("squareRootOfPopulationStandardDeviationOf",OrderItem.UNIT_PRICE_PROPERTY));
    }

    public OrderItemRequest squareRootOfPopulationStandardDeviationUnitPriceAs(String retName){
        super.squareRootOfPopulationStandardDeviation(retName, OrderItem.UNIT_PRICE_PROPERTY);
        return this;
    }
    public OrderItemRequest sampleVarianceUnitPrice(){
        return sampleVarianceUnitPriceAs(prefix("sampleVarianceOf",OrderItem.UNIT_PRICE_PROPERTY));
    }

    public OrderItemRequest sampleVarianceUnitPriceAs(String retName){
        super.sampleVariance(retName, OrderItem.UNIT_PRICE_PROPERTY);
        return this;
    }
    public OrderItemRequest samplePopulationVarianceUnitPrice(){
        return samplePopulationVarianceUnitPriceAs(prefix("samplePopulationVarianceOf",OrderItem.UNIT_PRICE_PROPERTY));
    }

    public OrderItemRequest samplePopulationVarianceUnitPriceAs(String retName){
        super.samplePopulationVariance(retName, OrderItem.UNIT_PRICE_PROPERTY);
        return this;
    }
    public OrderItemRequest minQuantity(){
        return minQuantityAs(prefix("minOf",OrderItem.QUANTITY_PROPERTY));
    }

    public OrderItemRequest minQuantityAs(String retName){
        super.min(retName, OrderItem.QUANTITY_PROPERTY);
        return this;
    }
    public OrderItemRequest maxQuantity(){
        return maxQuantityAs(prefix("maxOf",OrderItem.QUANTITY_PROPERTY));
    }

    public OrderItemRequest maxQuantityAs(String retName){
        super.max(retName, OrderItem.QUANTITY_PROPERTY);
        return this;
    }
    public OrderItemRequest sumQuantity(){
        return sumQuantityAs(prefix("sumOf",OrderItem.QUANTITY_PROPERTY));
    }

    public OrderItemRequest sumQuantityAs(String retName){
        super.sum(retName, OrderItem.QUANTITY_PROPERTY);
        return this;
    }
    public OrderItemRequest avgQuantity(){
        return avgQuantityAs(prefix("avgOf",OrderItem.QUANTITY_PROPERTY));
    }

    public OrderItemRequest avgQuantityAs(String retName){
        super.avg(retName, OrderItem.QUANTITY_PROPERTY);
        return this;
    }
    public OrderItemRequest standardDeviationQuantity(){
        return standardDeviationQuantityAs(prefix("standardDeviationOf",OrderItem.QUANTITY_PROPERTY));
    }

    public OrderItemRequest standardDeviationQuantityAs(String retName){
        super.standardDeviation(retName, OrderItem.QUANTITY_PROPERTY);
        return this;
    }
    public OrderItemRequest squareRootOfPopulationStandardDeviationQuantity(){
        return squareRootOfPopulationStandardDeviationQuantityAs(prefix("squareRootOfPopulationStandardDeviationOf",OrderItem.QUANTITY_PROPERTY));
    }

    public OrderItemRequest squareRootOfPopulationStandardDeviationQuantityAs(String retName){
        super.squareRootOfPopulationStandardDeviation(retName, OrderItem.QUANTITY_PROPERTY);
        return this;
    }
    public OrderItemRequest sampleVarianceQuantity(){
        return sampleVarianceQuantityAs(prefix("sampleVarianceOf",OrderItem.QUANTITY_PROPERTY));
    }

    public OrderItemRequest sampleVarianceQuantityAs(String retName){
        super.sampleVariance(retName, OrderItem.QUANTITY_PROPERTY);
        return this;
    }
    public OrderItemRequest samplePopulationVarianceQuantity(){
        return samplePopulationVarianceQuantityAs(prefix("samplePopulationVarianceOf",OrderItem.QUANTITY_PROPERTY));
    }

    public OrderItemRequest samplePopulationVarianceQuantityAs(String retName){
        super.samplePopulationVariance(retName, OrderItem.QUANTITY_PROPERTY);
        return this;
    }
    public OrderItemRequest<T> groupByGlobalOrderWithDetails(){
       return groupByGlobalOrderWithDetails(Q.globalOrders().unlimited());
    }

    public OrderItemRequest<T> groupByGlobalOrderWithDetails(GlobalOrderRequest subRequest){
       aggregate(OrderItem.GLOBAL_ORDER_PROPERTY, subRequest);
       return this;
    }

    public OrderItemRequest<T> groupByProductWithDetails(){
       return groupByProductWithDetails(Q.products().unlimited());
    }

    public OrderItemRequest<T> groupByProductWithDetails(ProductRequest subRequest){
       aggregate(OrderItem.PRODUCT_PROPERTY, subRequest);
       return this;
    }






    public OrderItemRequest<T> groupById(){
       groupBy(OrderItem.ID_PROPERTY);
       return this;
    }

    public OrderItemRequest<T> groupByIdAs(String retName){
       groupBy(retName, OrderItem.ID_PROPERTY);
       return this;
    }

    public OrderItemRequest<T> groupByIdWithFunction(String retName, AggrFunction function){
       groupBy(retName, OrderItem.ID_PROPERTY, function);
       return this;
    }

    public OrderItemRequest<T> groupByUnitPrice(){
       groupBy(OrderItem.UNIT_PRICE_PROPERTY);
       return this;
    }

    public OrderItemRequest<T> groupByUnitPriceAs(String retName){
       groupBy(retName, OrderItem.UNIT_PRICE_PROPERTY);
       return this;
    }

    public OrderItemRequest<T> groupByUnitPriceWithFunction(String retName, AggrFunction function){
       groupBy(retName, OrderItem.UNIT_PRICE_PROPERTY, function);
       return this;
    }
    public OrderItemRequest<T> groupByGlobalOrderWith(GlobalOrderRequest subRequest){
       groupBy(OrderItem.GLOBAL_ORDER_PROPERTY, subRequest);
       return this;
    }
    public OrderItemRequest<T> groupByGlobalOrder(){
       groupBy(OrderItem.GLOBAL_ORDER_PROPERTY);
       return this;
    }

    public OrderItemRequest<T> groupByGlobalOrderAs(String retName){
       groupBy(retName, OrderItem.GLOBAL_ORDER_PROPERTY);
       return this;
    }

    public OrderItemRequest<T> groupByGlobalOrderWithFunction(String retName, AggrFunction function){
       groupBy(retName, OrderItem.GLOBAL_ORDER_PROPERTY, function);
       return this;
    }
    public OrderItemRequest<T> groupByProductWith(ProductRequest subRequest){
       groupBy(OrderItem.PRODUCT_PROPERTY, subRequest);
       return this;
    }
    public OrderItemRequest<T> groupByProduct(){
       groupBy(OrderItem.PRODUCT_PROPERTY);
       return this;
    }

    public OrderItemRequest<T> groupByProductAs(String retName){
       groupBy(retName, OrderItem.PRODUCT_PROPERTY);
       return this;
    }

    public OrderItemRequest<T> groupByProductWithFunction(String retName, AggrFunction function){
       groupBy(retName, OrderItem.PRODUCT_PROPERTY, function);
       return this;
    }

    public OrderItemRequest<T> groupByQuantity(){
       groupBy(OrderItem.QUANTITY_PROPERTY);
       return this;
    }

    public OrderItemRequest<T> groupByQuantityAs(String retName){
       groupBy(retName, OrderItem.QUANTITY_PROPERTY);
       return this;
    }

    public OrderItemRequest<T> groupByQuantityWithFunction(String retName, AggrFunction function){
       groupBy(retName, OrderItem.QUANTITY_PROPERTY, function);
       return this;
    }

    public OrderItemRequest<T> groupByCreateTime(){
       groupBy(OrderItem.CREATE_TIME_PROPERTY);
       return this;
    }

    public OrderItemRequest<T> groupByCreateTimeAs(String retName){
       groupBy(retName, OrderItem.CREATE_TIME_PROPERTY);
       return this;
    }

    public OrderItemRequest<T> groupByCreateTimeWithFunction(String retName, AggrFunction function){
       groupBy(retName, OrderItem.CREATE_TIME_PROPERTY, function);
       return this;
    }

    public OrderItemRequest<T> groupByUpdateTime(){
       groupBy(OrderItem.UPDATE_TIME_PROPERTY);
       return this;
    }

    public OrderItemRequest<T> groupByUpdateTimeAs(String retName){
       groupBy(retName, OrderItem.UPDATE_TIME_PROPERTY);
       return this;
    }

    public OrderItemRequest<T> groupByUpdateTimeWithFunction(String retName, AggrFunction function){
       groupBy(retName, OrderItem.UPDATE_TIME_PROPERTY, function);
       return this;
    }

    public OrderItemRequest<T> groupByVersion(){
       groupBy(OrderItem.VERSION_PROPERTY);
       return this;
    }

    public OrderItemRequest<T> groupByVersionAs(String retName){
       groupBy(retName, OrderItem.VERSION_PROPERTY);
       return this;
    }

    public OrderItemRequest<T> groupByVersionWithFunction(String retName, AggrFunction function){
       groupBy(retName, OrderItem.VERSION_PROPERTY, function);
       return this;
    }



    public OrderItemRequest<T> orderByIdAscending(){
       addOrderByAscending(OrderItem.ID_PROPERTY);
       return this;
    }

    public OrderItemRequest<T> orderByIdDescending(){
       addOrderByDescending(OrderItem.ID_PROPERTY);
       return this;
    }

    public OrderItemRequest<T> orderByUnitPriceAscending(){
       addOrderByAscending(OrderItem.UNIT_PRICE_PROPERTY);
       return this;
    }

    public OrderItemRequest<T> orderByUnitPriceDescending(){
       addOrderByDescending(OrderItem.UNIT_PRICE_PROPERTY);
       return this;
    }

    public OrderItemRequest<T> orderByGlobalOrderAscending(){
       addOrderByAscending(OrderItem.GLOBAL_ORDER_PROPERTY);
       return this;
    }

    public OrderItemRequest<T> orderByGlobalOrderDescending(){
       addOrderByDescending(OrderItem.GLOBAL_ORDER_PROPERTY);
       return this;
    }

    public OrderItemRequest<T> orderByProductAscending(){
       addOrderByAscending(OrderItem.PRODUCT_PROPERTY);
       return this;
    }

    public OrderItemRequest<T> orderByProductDescending(){
       addOrderByDescending(OrderItem.PRODUCT_PROPERTY);
       return this;
    }

    public OrderItemRequest<T> orderByQuantityAscending(){
       addOrderByAscending(OrderItem.QUANTITY_PROPERTY);
       return this;
    }

    public OrderItemRequest<T> orderByQuantityDescending(){
       addOrderByDescending(OrderItem.QUANTITY_PROPERTY);
       return this;
    }

    public OrderItemRequest<T> orderByCreateTimeAscending(){
       addOrderByAscending(OrderItem.CREATE_TIME_PROPERTY);
       return this;
    }

    public OrderItemRequest<T> orderByCreateTimeDescending(){
       addOrderByDescending(OrderItem.CREATE_TIME_PROPERTY);
       return this;
    }

    public OrderItemRequest<T> orderByUpdateTimeAscending(){
       addOrderByAscending(OrderItem.UPDATE_TIME_PROPERTY);
       return this;
    }

    public OrderItemRequest<T> orderByUpdateTimeDescending(){
       addOrderByDescending(OrderItem.UPDATE_TIME_PROPERTY);
       return this;
    }

    public OrderItemRequest<T> orderByVersionAscending(){
       addOrderByAscending(OrderItem.VERSION_PROPERTY);
       return this;
    }

    public OrderItemRequest<T> orderByVersionDescending(){
       addOrderByDescending(OrderItem.VERSION_PROPERTY);
       return this;
    }


    public GlobalOrderRequest rollUpToGlobalOrder(){
       GlobalOrderRequest globalOrder = Q.globalOrders().unlimited();
       this.withGlobalOrderMatching(globalOrder)
           .groupByGlobalOrderWith(globalOrder);
       return globalOrder;
    }

    public ProductRequest rollUpToProduct(){
       ProductRequest product = Q.products().unlimited();
       this.withProductMatching(product)
           .groupByProductWith(product);
       return product;
    }






   public OrderItemRequest<T> facetByGlobalOrderAs(String facetName, GlobalOrderRequest globalOrder){
       return facetByGlobalOrderAs(facetName, globalOrder, true);
   }

   public OrderItemRequest<T> facetByGlobalOrderAs(String facetName, GlobalOrderRequest globalOrder, boolean includeAllFacets){
       addFacet(facetName, OrderItem.GLOBAL_ORDER_PROPERTY, globalOrder, includeAllFacets);
       return this;
   }
   public OrderItemRequest<T> facetByProductAs(String facetName, ProductRequest product){
       return facetByProductAs(facetName, product, true);
   }

   public OrderItemRequest<T> facetByProductAs(String facetName, ProductRequest product, boolean includeAllFacets){
       addFacet(facetName, OrderItem.PRODUCT_PROPERTY, product, includeAllFacets);
       return this;
   }


    /**
     * get topN records
     * @param topN  records number
     */
    public OrderItemRequest<T> top(int topN) {
        super.top(topN);
        return this;
    }

    /**
     * get records from offset(inclusive) to offset+size(exclusive)
     * @param offset record offset
     * @param size records number
     */
    public OrderItemRequest<T> offset(int offset, int size) {
        super.offset(offset, size);
        return this;
    }

    /**
     * retrieve all records
     */
    public OrderItemRequest<T> unlimited() {
        super.unlimited();
        return this;
    }

    /**
     * get records of one page
     * @param pageNumber page number(1-based)
     * @param pageSize page size
     */
    public OrderItemRequest<T> page(int pageNumber, int pageSize) {
        int offset = (pageNumber - 1) * pageSize;
        return offset(offset, pageSize);
   }

    /**
     * get records of one page, default page size is 10
     * @param pageNumber page number(1-based)
     */
    public OrderItemRequest<T> page(int pageNumber) {
        return page(pageNumber, 10);
   }
}