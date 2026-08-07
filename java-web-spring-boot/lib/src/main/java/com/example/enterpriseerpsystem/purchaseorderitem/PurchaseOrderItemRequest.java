
package com.example.enterpriseerpsystem.purchaseorderitem;

import com.example.enterpriseerpsystem.Q;
import com.example.enterpriseerpsystem.product.Product;
import com.example.enterpriseerpsystem.product.ProductRequest;
import com.example.enterpriseerpsystem.purchaseorder.PurchaseOrder;
import com.example.enterpriseerpsystem.purchaseorder.PurchaseOrderRequest;
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

public class PurchaseOrderItemRequest<T extends PurchaseOrderItem> extends BaseRequest<T> {

    /**
     * @deprecated AI agents and business code must use the generated Q facade
     *             instead of constructing request builders directly.
     */
    @Deprecated
    public PurchaseOrderItemRequest(Class<T> returnType){
        super(returnType);
        selectId();
        selectVersion();
    }

    public PurchaseOrderItemRequest<T> comment(String comment){
         super.internalComment(comment);
         return this;
    }

    // purpose() 继承自 BaseRequest，返回 ExecutableRequest（终结方法）

    public PurchaseOrderItemRequest<T> returnType(Class<? extends T> returnType){
        super.setReturnType(returnType);
        return this;
    }

    public PurchaseOrderItemRequest<T> enableAggregationCache(long cacheExpiredMillis){
        super.enableAggregationCache();
        super.aggregateCacheTime(cacheExpiredMillis);
        return this;
    }

    public PurchaseOrderItemRequest<T> enableAggregationCache(){
        return enableAggregationCache(0l);
    }


    public PurchaseOrderItemRequest<T> propagateAggregationCache(long cacheExpiredMillis){
        super.propagateAggregationCache(cacheExpiredMillis);
        return this;
    }

    public PurchaseOrderItemRequest<T> appendSearchCriteria(SearchCriteria searchCriteria){
        return (PurchaseOrderItemRequest<T>)super.appendSearchCriteria(searchCriteria);
    }

    public PurchaseOrderItemRequest<T> filter(String property1, Operator operator, String property2){
        return appendSearchCriteria(new TwoOperatorCriteria(operator, new PropertyReference(property1), new PropertyReference(property2)));
    }


    public PurchaseOrderItemRequest<T> matchingAnyOf(PurchaseOrderItemRequest purchaseOrderItem){
        super.internalMatchAny(purchaseOrderItem);
        return this;
    }

    public PurchaseOrderItemRequest<T> enhanceChildrenIfNeeded(){
        return this;
    }

    public PurchaseOrderItemRequest<T> withDeletedRows(){
        super.withDeletedRows();
        return this;
    }

    public PurchaseOrderItemRequest<T> deletedRowsOnly(){
        super.deletedRowsOnly();
        return this;
    }

    public PurchaseOrderItemRequest<T> selectSelf(){
        super.selectSelf();
        return selectId().selectProductIdOnly().selectPurchaseOrderIdOnly().selectQuantity().selectUnitCost().selectCreateTime().selectUpdateTime().selectVersion();
    }

    public PurchaseOrderItemRequest<T> selectSelfFields(){
        return selectSelf();
    }

    public PurchaseOrderItemRequest<T> selectAll(){
        super.selectAll();
        return selectId().selectProduct().selectPurchaseOrder().selectQuantity().selectUnitCost().selectCreateTime().selectUpdateTime().selectVersion();
    }

    public PurchaseOrderItemRequest<T> selectChildren(){
        super.selectAny();
        return selectId().selectProduct().selectPurchaseOrder().selectQuantity().selectUnitCost().selectCreateTime().selectUpdateTime().selectVersion();
    }


    public PurchaseOrderItemRequest<T> selectId(){
       selectProperty(PurchaseOrderItem.ID_PROPERTY);
       return this;
    }

    /**
     * fill the id with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  id) to fetch id property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public PurchaseOrderItemRequest<T> unselectId(){
       unselectProperty(PurchaseOrderItem.ID_PROPERTY);
       return this;
    }
    public PurchaseOrderItemRequest<T> selectProductIdOnly(){
       selectProperty(PurchaseOrderItem.PRODUCT_PROPERTY);
       return this;
    }

    public PurchaseOrderItemRequest<T> selectProduct(){
        return selectProductWith(Q.products().unlimited().selectSelf());
    }

    public PurchaseOrderItemRequest<T> selectProductWith(ProductRequest product){
       selectProperty(PurchaseOrderItem.PRODUCT_PROPERTY);
       enhanceRelation(PurchaseOrderItem.PRODUCT_PROPERTY, product);
       return this;
    }

    public PurchaseOrderItemRequest<T> unselectProduct(){
       unselectProperty(PurchaseOrderItem.PRODUCT_PROPERTY);
       return this;
    }
    public PurchaseOrderItemRequest<T> selectPurchaseOrderIdOnly(){
       selectProperty(PurchaseOrderItem.PURCHASE_ORDER_PROPERTY);
       return this;
    }

    public PurchaseOrderItemRequest<T> selectPurchaseOrder(){
        return selectPurchaseOrderWith(Q.purchaseOrders().unlimited().selectSelf());
    }

    public PurchaseOrderItemRequest<T> selectPurchaseOrderWith(PurchaseOrderRequest purchaseOrder){
       selectProperty(PurchaseOrderItem.PURCHASE_ORDER_PROPERTY);
       enhanceRelation(PurchaseOrderItem.PURCHASE_ORDER_PROPERTY, purchaseOrder);
       return this;
    }

    public PurchaseOrderItemRequest<T> unselectPurchaseOrder(){
       unselectProperty(PurchaseOrderItem.PURCHASE_ORDER_PROPERTY);
       return this;
    }
    public PurchaseOrderItemRequest<T> selectQuantity(){
       selectProperty(PurchaseOrderItem.QUANTITY_PROPERTY);
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
    public PurchaseOrderItemRequest<T> selectQuantity(AggrFunction aggrFunction){
       selectProperty(PurchaseOrderItem.QUANTITY_PROPERTY, aggrFunction);
       return this;
    }


    public PurchaseOrderItemRequest<T> unselectQuantity(){
       unselectProperty(PurchaseOrderItem.QUANTITY_PROPERTY);
       return this;
    }
    public PurchaseOrderItemRequest<T> selectUnitCost(){
       selectProperty(PurchaseOrderItem.UNIT_COST_PROPERTY);
       return this;
    }

    /**
     * fill the unitCost with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  unitCost) to fetch unitCost property.
     * @param rawSqlSegment  customized rawSqlSegment
     */


    /**
     * fill the unitCost with customized aggrFunction, TEAQL uses ({aggrFunction}(unitCost) AS unitCost to fetch unitCost property.
     * @param aggrFunction  aggrFunction
     */
    public PurchaseOrderItemRequest<T> selectUnitCost(AggrFunction aggrFunction){
       selectProperty(PurchaseOrderItem.UNIT_COST_PROPERTY, aggrFunction);
       return this;
    }


    public PurchaseOrderItemRequest<T> unselectUnitCost(){
       unselectProperty(PurchaseOrderItem.UNIT_COST_PROPERTY);
       return this;
    }
    public PurchaseOrderItemRequest<T> selectCreateTime(){
       selectProperty(PurchaseOrderItem.CREATE_TIME_PROPERTY);
       return this;
    }

    /**
     * fill the createTime with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  createTime) to fetch createTime property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public PurchaseOrderItemRequest<T> unselectCreateTime(){
       unselectProperty(PurchaseOrderItem.CREATE_TIME_PROPERTY);
       return this;
    }
    public PurchaseOrderItemRequest<T> selectUpdateTime(){
       selectProperty(PurchaseOrderItem.UPDATE_TIME_PROPERTY);
       return this;
    }

    /**
     * fill the updateTime with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  updateTime) to fetch updateTime property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public PurchaseOrderItemRequest<T> unselectUpdateTime(){
       unselectProperty(PurchaseOrderItem.UPDATE_TIME_PROPERTY);
       return this;
    }
    public PurchaseOrderItemRequest<T> selectVersion(){
       selectProperty(PurchaseOrderItem.VERSION_PROPERTY);
       return this;
    }

    /**
     * fill the version with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  version) to fetch version property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public PurchaseOrderItemRequest<T> unselectVersion(){
       unselectProperty(PurchaseOrderItem.VERSION_PROPERTY);
       return this;
    }

    public PurchaseOrderItemRequest<T> withId(Operator operator, Object... values){
       return appendSearchCriteria(createIdCriteria(operator, values));
    }

    public SearchCriteria createIdCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(PurchaseOrderItem.ID_PROPERTY, operator, values);
    }

    public PurchaseOrderItemRequest<T> withIdIs(Long id){
       return withId(Operator.EQUAL, id);
    }
    public PurchaseOrderItemRequest<T> withIdIn(Long... id){
       return withId(Operator.EQUAL, (Object[])id);
    }



    public PurchaseOrderItemRequest<T> filterByProduct(Product... product){
      if (product == null || product.length == 0) {
        throw new IllegalArgumentException("filterByProduct parameter product cannot be empty");
      }
      return appendSearchCriteria(createProductCriteria(Operator.EQUAL, (Object[])product));
    }

    public PurchaseOrderItemRequest<T> withProduct(Operator operator, Object... values){
       return appendSearchCriteria(createProductCriteria(operator, values));
    }

    public PurchaseOrderItemRequest<T> withProductIsUnknown(){
       return withProduct(Operator.IS_NULL);
    }

    public PurchaseOrderItemRequest<T> withProductIsKnown(){
       return withProduct(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createProductCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(PurchaseOrderItem.PRODUCT_PROPERTY, operator, values);
    }

    public PurchaseOrderItemRequest<T> filterByProduct(Long product){
      if(product == null){
         return this;
      }
      return withProduct(Operator.EQUAL, product);
    }
    public PurchaseOrderItemRequest<T> withProductMatching(ProductRequest product){
       return appendSearchCriteria(new SubQuerySearchCriteria(PurchaseOrderItem.PRODUCT_PROPERTY, product, Product.ID_PROPERTY));
    }

    public PurchaseOrderItemRequest<T> filterByPurchaseOrder(PurchaseOrder... purchaseOrder){
      if (purchaseOrder == null || purchaseOrder.length == 0) {
        throw new IllegalArgumentException("filterByPurchaseOrder parameter purchaseOrder cannot be empty");
      }
      return appendSearchCriteria(createPurchaseOrderCriteria(Operator.EQUAL, (Object[])purchaseOrder));
    }

    public PurchaseOrderItemRequest<T> withPurchaseOrder(Operator operator, Object... values){
       return appendSearchCriteria(createPurchaseOrderCriteria(operator, values));
    }

    public PurchaseOrderItemRequest<T> withPurchaseOrderIsUnknown(){
       return withPurchaseOrder(Operator.IS_NULL);
    }

    public PurchaseOrderItemRequest<T> withPurchaseOrderIsKnown(){
       return withPurchaseOrder(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createPurchaseOrderCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(PurchaseOrderItem.PURCHASE_ORDER_PROPERTY, operator, values);
    }

    public PurchaseOrderItemRequest<T> filterByPurchaseOrder(Long purchaseOrder){
      if(purchaseOrder == null){
         return this;
      }
      return withPurchaseOrder(Operator.EQUAL, purchaseOrder);
    }
    public PurchaseOrderItemRequest<T> withPurchaseOrderMatching(PurchaseOrderRequest purchaseOrder){
       return appendSearchCriteria(new SubQuerySearchCriteria(PurchaseOrderItem.PURCHASE_ORDER_PROPERTY, purchaseOrder, PurchaseOrder.ID_PROPERTY));
    }

    public PurchaseOrderItemRequest<T> filterByQuantity(BigDecimal... quantity){
      if (quantity == null || quantity.length == 0) {
        throw new IllegalArgumentException("filterByQuantity parameter quantity cannot be empty");
      }
      return appendSearchCriteria(createQuantityCriteria(Operator.EQUAL, (Object[])quantity));
    }

    public PurchaseOrderItemRequest<T> withQuantity(Operator operator, Object... values){
       return appendSearchCriteria(createQuantityCriteria(operator, values));
    }

    public PurchaseOrderItemRequest<T> withQuantityIsUnknown(){
       return withQuantity(Operator.IS_NULL);
    }

    public PurchaseOrderItemRequest<T> withQuantityIsKnown(){
       return withQuantity(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createQuantityCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(PurchaseOrderItem.QUANTITY_PROPERTY, operator, values);
    }

    public PurchaseOrderItemRequest<T> withQuantityGreaterThan(BigDecimal quantity){
       return withQuantity(Operator.GREATER_THAN, quantity);
    }

    public PurchaseOrderItemRequest<T> withQuantityGreaterThanOrEqualTo(BigDecimal quantity){
       return withQuantity(Operator.GREATER_THAN_OR_EQUAL, quantity);
    }

    public PurchaseOrderItemRequest<T> withQuantityLessThan(BigDecimal quantity){
       return withQuantity(Operator.LESS_THAN, quantity);
    }

    public PurchaseOrderItemRequest<T> withQuantityLessThanOrEqualTo(BigDecimal quantity){
       return withQuantity(Operator.LESS_THAN_OR_EQUAL, quantity);
    }

    public PurchaseOrderItemRequest<T> withQuantityBetween(BigDecimal startOfQuantity, BigDecimal endOfQuantity){
       return withQuantity(Operator.BETWEEN, startOfQuantity, endOfQuantity);
    }



    public PurchaseOrderItemRequest<T> filterByUnitCost(BigDecimal... unitCost){
      if (unitCost == null || unitCost.length == 0) {
        throw new IllegalArgumentException("filterByUnitCost parameter unitCost cannot be empty");
      }
      return appendSearchCriteria(createUnitCostCriteria(Operator.EQUAL, (Object[])unitCost));
    }

    public PurchaseOrderItemRequest<T> withUnitCost(Operator operator, Object... values){
       return appendSearchCriteria(createUnitCostCriteria(operator, values));
    }

    public PurchaseOrderItemRequest<T> withUnitCostIsUnknown(){
       return withUnitCost(Operator.IS_NULL);
    }

    public PurchaseOrderItemRequest<T> withUnitCostIsKnown(){
       return withUnitCost(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createUnitCostCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(PurchaseOrderItem.UNIT_COST_PROPERTY, operator, values);
    }

    public PurchaseOrderItemRequest<T> withUnitCostGreaterThan(BigDecimal unitCost){
       return withUnitCost(Operator.GREATER_THAN, unitCost);
    }

    public PurchaseOrderItemRequest<T> withUnitCostGreaterThanOrEqualTo(BigDecimal unitCost){
       return withUnitCost(Operator.GREATER_THAN_OR_EQUAL, unitCost);
    }

    public PurchaseOrderItemRequest<T> withUnitCostLessThan(BigDecimal unitCost){
       return withUnitCost(Operator.LESS_THAN, unitCost);
    }

    public PurchaseOrderItemRequest<T> withUnitCostLessThanOrEqualTo(BigDecimal unitCost){
       return withUnitCost(Operator.LESS_THAN_OR_EQUAL, unitCost);
    }

    public PurchaseOrderItemRequest<T> withUnitCostBetween(BigDecimal startOfUnitCost, BigDecimal endOfUnitCost){
       return withUnitCost(Operator.BETWEEN, startOfUnitCost, endOfUnitCost);
    }



    public PurchaseOrderItemRequest<T> filterByCreateTime(LocalDateTime... createTime){
      if (createTime == null || createTime.length == 0) {
        throw new IllegalArgumentException("filterByCreateTime parameter createTime cannot be empty");
      }
      return appendSearchCriteria(createCreateTimeCriteria(Operator.EQUAL, (Object[])createTime));
    }

    public PurchaseOrderItemRequest<T> withCreateTime(Operator operator, Object... values){
       return appendSearchCriteria(createCreateTimeCriteria(operator, values));
    }

    public PurchaseOrderItemRequest<T> withCreateTimeIsUnknown(){
       return withCreateTime(Operator.IS_NULL);
    }

    public PurchaseOrderItemRequest<T> withCreateTimeIsKnown(){
       return withCreateTime(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createCreateTimeCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(PurchaseOrderItem.CREATE_TIME_PROPERTY, operator, values);
    }

    public PurchaseOrderItemRequest<T> withCreateTimeGreaterThan(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public PurchaseOrderItemRequest<T> withCreateTimeGreaterThanOrEqualTo(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN_OR_EQUAL, createTime);
    }

    public PurchaseOrderItemRequest<T> withCreateTimeLessThan(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public PurchaseOrderItemRequest<T> withCreateTimeLessThanOrEqualTo(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN_OR_EQUAL, createTime);
    }

    public PurchaseOrderItemRequest<T> withCreateTimeBetween(LocalDateTime startOfCreateTime, LocalDateTime endOfCreateTime){
       return withCreateTime(Operator.BETWEEN, startOfCreateTime, endOfCreateTime);
    }
    public PurchaseOrderItemRequest<T> withCreateTimeBefore(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public PurchaseOrderItemRequest<T> withCreateTimeBefore(Date createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public PurchaseOrderItemRequest<T> withCreateTimeAfter(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public PurchaseOrderItemRequest<T> withCreateTimeAfter(Date createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public PurchaseOrderItemRequest<T> withCreateTimeBetween(Date startOfCreateTime, Date endOfCreateTime){
       return withCreateTime(Operator.BETWEEN, startOfCreateTime, endOfCreateTime);
    }




    public PurchaseOrderItemRequest<T> filterByUpdateTime(LocalDateTime... updateTime){
      if (updateTime == null || updateTime.length == 0) {
        throw new IllegalArgumentException("filterByUpdateTime parameter updateTime cannot be empty");
      }
      return appendSearchCriteria(createUpdateTimeCriteria(Operator.EQUAL, (Object[])updateTime));
    }

    public PurchaseOrderItemRequest<T> withUpdateTime(Operator operator, Object... values){
       return appendSearchCriteria(createUpdateTimeCriteria(operator, values));
    }

    public PurchaseOrderItemRequest<T> withUpdateTimeIsUnknown(){
       return withUpdateTime(Operator.IS_NULL);
    }

    public PurchaseOrderItemRequest<T> withUpdateTimeIsKnown(){
       return withUpdateTime(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createUpdateTimeCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(PurchaseOrderItem.UPDATE_TIME_PROPERTY, operator, values);
    }

    public PurchaseOrderItemRequest<T> withUpdateTimeGreaterThan(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public PurchaseOrderItemRequest<T> withUpdateTimeGreaterThanOrEqualTo(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN_OR_EQUAL, updateTime);
    }

    public PurchaseOrderItemRequest<T> withUpdateTimeLessThan(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public PurchaseOrderItemRequest<T> withUpdateTimeLessThanOrEqualTo(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN_OR_EQUAL, updateTime);
    }

    public PurchaseOrderItemRequest<T> withUpdateTimeBetween(LocalDateTime startOfUpdateTime, LocalDateTime endOfUpdateTime){
       return withUpdateTime(Operator.BETWEEN, startOfUpdateTime, endOfUpdateTime);
    }
    public PurchaseOrderItemRequest<T> withUpdateTimeBefore(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public PurchaseOrderItemRequest<T> withUpdateTimeBefore(Date updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public PurchaseOrderItemRequest<T> withUpdateTimeAfter(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public PurchaseOrderItemRequest<T> withUpdateTimeAfter(Date updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public PurchaseOrderItemRequest<T> withUpdateTimeBetween(Date startOfUpdateTime, Date endOfUpdateTime){
       return withUpdateTime(Operator.BETWEEN, startOfUpdateTime, endOfUpdateTime);
    }




    public PurchaseOrderItemRequest<T> filterByVersion(Long... version){
      if (version == null || version.length == 0) {
        throw new IllegalArgumentException("filterByVersion parameter version cannot be empty");
      }
      return appendSearchCriteria(createVersionCriteria(Operator.EQUAL, (Object[])version));
    }

    public PurchaseOrderItemRequest<T> withVersion(Operator operator, Object... values){
       return appendSearchCriteria(createVersionCriteria(operator, values));
    }

    public PurchaseOrderItemRequest<T> withVersionIsUnknown(){
       return withVersion(Operator.IS_NULL);
    }

    public PurchaseOrderItemRequest<T> withVersionIsKnown(){
       return withVersion(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createVersionCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(PurchaseOrderItem.VERSION_PROPERTY, operator, values);
    }

    public PurchaseOrderItemRequest<T> withVersionGreaterThan(Long version){
       return withVersion(Operator.GREATER_THAN, version);
    }

    public PurchaseOrderItemRequest<T> withVersionGreaterThanOrEqualTo(Long version){
       return withVersion(Operator.GREATER_THAN_OR_EQUAL, version);
    }

    public PurchaseOrderItemRequest<T> withVersionLessThan(Long version){
       return withVersion(Operator.LESS_THAN, version);
    }

    public PurchaseOrderItemRequest<T> withVersionLessThanOrEqualTo(Long version){
       return withVersion(Operator.LESS_THAN_OR_EQUAL, version);
    }

    public PurchaseOrderItemRequest<T> withVersionBetween(Long startOfVersion, Long endOfVersion){
       return withVersion(Operator.BETWEEN, startOfVersion, endOfVersion);
    }


    public PurchaseOrderItemRequest<T> count(){
        super.count();
        return this;
    }
    public PurchaseOrderItemRequest<T> countAs(String retName){
        super.count(retName);
        return this;
    }
    public PurchaseOrderItemRequest minQuantity(){
        return minQuantityAs(prefix("minOf",PurchaseOrderItem.QUANTITY_PROPERTY));
    }

    public PurchaseOrderItemRequest minQuantityAs(String retName){
        super.min(retName, PurchaseOrderItem.QUANTITY_PROPERTY);
        return this;
    }
    public PurchaseOrderItemRequest maxQuantity(){
        return maxQuantityAs(prefix("maxOf",PurchaseOrderItem.QUANTITY_PROPERTY));
    }

    public PurchaseOrderItemRequest maxQuantityAs(String retName){
        super.max(retName, PurchaseOrderItem.QUANTITY_PROPERTY);
        return this;
    }
    public PurchaseOrderItemRequest sumQuantity(){
        return sumQuantityAs(prefix("sumOf",PurchaseOrderItem.QUANTITY_PROPERTY));
    }

    public PurchaseOrderItemRequest sumQuantityAs(String retName){
        super.sum(retName, PurchaseOrderItem.QUANTITY_PROPERTY);
        return this;
    }
    public PurchaseOrderItemRequest avgQuantity(){
        return avgQuantityAs(prefix("avgOf",PurchaseOrderItem.QUANTITY_PROPERTY));
    }

    public PurchaseOrderItemRequest avgQuantityAs(String retName){
        super.avg(retName, PurchaseOrderItem.QUANTITY_PROPERTY);
        return this;
    }
    public PurchaseOrderItemRequest standardDeviationQuantity(){
        return standardDeviationQuantityAs(prefix("standardDeviationOf",PurchaseOrderItem.QUANTITY_PROPERTY));
    }

    public PurchaseOrderItemRequest standardDeviationQuantityAs(String retName){
        super.standardDeviation(retName, PurchaseOrderItem.QUANTITY_PROPERTY);
        return this;
    }
    public PurchaseOrderItemRequest squareRootOfPopulationStandardDeviationQuantity(){
        return squareRootOfPopulationStandardDeviationQuantityAs(prefix("squareRootOfPopulationStandardDeviationOf",PurchaseOrderItem.QUANTITY_PROPERTY));
    }

    public PurchaseOrderItemRequest squareRootOfPopulationStandardDeviationQuantityAs(String retName){
        super.squareRootOfPopulationStandardDeviation(retName, PurchaseOrderItem.QUANTITY_PROPERTY);
        return this;
    }
    public PurchaseOrderItemRequest sampleVarianceQuantity(){
        return sampleVarianceQuantityAs(prefix("sampleVarianceOf",PurchaseOrderItem.QUANTITY_PROPERTY));
    }

    public PurchaseOrderItemRequest sampleVarianceQuantityAs(String retName){
        super.sampleVariance(retName, PurchaseOrderItem.QUANTITY_PROPERTY);
        return this;
    }
    public PurchaseOrderItemRequest samplePopulationVarianceQuantity(){
        return samplePopulationVarianceQuantityAs(prefix("samplePopulationVarianceOf",PurchaseOrderItem.QUANTITY_PROPERTY));
    }

    public PurchaseOrderItemRequest samplePopulationVarianceQuantityAs(String retName){
        super.samplePopulationVariance(retName, PurchaseOrderItem.QUANTITY_PROPERTY);
        return this;
    }
    public PurchaseOrderItemRequest minUnitCost(){
        return minUnitCostAs(prefix("minOf",PurchaseOrderItem.UNIT_COST_PROPERTY));
    }

    public PurchaseOrderItemRequest minUnitCostAs(String retName){
        super.min(retName, PurchaseOrderItem.UNIT_COST_PROPERTY);
        return this;
    }
    public PurchaseOrderItemRequest maxUnitCost(){
        return maxUnitCostAs(prefix("maxOf",PurchaseOrderItem.UNIT_COST_PROPERTY));
    }

    public PurchaseOrderItemRequest maxUnitCostAs(String retName){
        super.max(retName, PurchaseOrderItem.UNIT_COST_PROPERTY);
        return this;
    }
    public PurchaseOrderItemRequest sumUnitCost(){
        return sumUnitCostAs(prefix("sumOf",PurchaseOrderItem.UNIT_COST_PROPERTY));
    }

    public PurchaseOrderItemRequest sumUnitCostAs(String retName){
        super.sum(retName, PurchaseOrderItem.UNIT_COST_PROPERTY);
        return this;
    }
    public PurchaseOrderItemRequest avgUnitCost(){
        return avgUnitCostAs(prefix("avgOf",PurchaseOrderItem.UNIT_COST_PROPERTY));
    }

    public PurchaseOrderItemRequest avgUnitCostAs(String retName){
        super.avg(retName, PurchaseOrderItem.UNIT_COST_PROPERTY);
        return this;
    }
    public PurchaseOrderItemRequest standardDeviationUnitCost(){
        return standardDeviationUnitCostAs(prefix("standardDeviationOf",PurchaseOrderItem.UNIT_COST_PROPERTY));
    }

    public PurchaseOrderItemRequest standardDeviationUnitCostAs(String retName){
        super.standardDeviation(retName, PurchaseOrderItem.UNIT_COST_PROPERTY);
        return this;
    }
    public PurchaseOrderItemRequest squareRootOfPopulationStandardDeviationUnitCost(){
        return squareRootOfPopulationStandardDeviationUnitCostAs(prefix("squareRootOfPopulationStandardDeviationOf",PurchaseOrderItem.UNIT_COST_PROPERTY));
    }

    public PurchaseOrderItemRequest squareRootOfPopulationStandardDeviationUnitCostAs(String retName){
        super.squareRootOfPopulationStandardDeviation(retName, PurchaseOrderItem.UNIT_COST_PROPERTY);
        return this;
    }
    public PurchaseOrderItemRequest sampleVarianceUnitCost(){
        return sampleVarianceUnitCostAs(prefix("sampleVarianceOf",PurchaseOrderItem.UNIT_COST_PROPERTY));
    }

    public PurchaseOrderItemRequest sampleVarianceUnitCostAs(String retName){
        super.sampleVariance(retName, PurchaseOrderItem.UNIT_COST_PROPERTY);
        return this;
    }
    public PurchaseOrderItemRequest samplePopulationVarianceUnitCost(){
        return samplePopulationVarianceUnitCostAs(prefix("samplePopulationVarianceOf",PurchaseOrderItem.UNIT_COST_PROPERTY));
    }

    public PurchaseOrderItemRequest samplePopulationVarianceUnitCostAs(String retName){
        super.samplePopulationVariance(retName, PurchaseOrderItem.UNIT_COST_PROPERTY);
        return this;
    }
    public PurchaseOrderItemRequest<T> groupByProductWithDetails(){
       return groupByProductWithDetails(Q.products().unlimited());
    }

    public PurchaseOrderItemRequest<T> groupByProductWithDetails(ProductRequest subRequest){
       aggregate(PurchaseOrderItem.PRODUCT_PROPERTY, subRequest);
       return this;
    }

    public PurchaseOrderItemRequest<T> groupByPurchaseOrderWithDetails(){
       return groupByPurchaseOrderWithDetails(Q.purchaseOrders().unlimited());
    }

    public PurchaseOrderItemRequest<T> groupByPurchaseOrderWithDetails(PurchaseOrderRequest subRequest){
       aggregate(PurchaseOrderItem.PURCHASE_ORDER_PROPERTY, subRequest);
       return this;
    }







    public PurchaseOrderItemRequest<T> groupById(){
       groupBy(PurchaseOrderItem.ID_PROPERTY);
       return this;
    }

    public PurchaseOrderItemRequest<T> groupByIdAs(String retName){
       groupBy(retName, PurchaseOrderItem.ID_PROPERTY);
       return this;
    }

    public PurchaseOrderItemRequest<T> groupByIdWithFunction(String retName, AggrFunction function){
       groupBy(retName, PurchaseOrderItem.ID_PROPERTY, function);
       return this;
    }
    public PurchaseOrderItemRequest<T> groupByProductWith(ProductRequest subRequest){
       groupBy(PurchaseOrderItem.PRODUCT_PROPERTY, subRequest);
       return this;
    }
    public PurchaseOrderItemRequest<T> groupByProduct(){
       groupBy(PurchaseOrderItem.PRODUCT_PROPERTY);
       return this;
    }

    public PurchaseOrderItemRequest<T> groupByProductAs(String retName){
       groupBy(retName, PurchaseOrderItem.PRODUCT_PROPERTY);
       return this;
    }

    public PurchaseOrderItemRequest<T> groupByProductWithFunction(String retName, AggrFunction function){
       groupBy(retName, PurchaseOrderItem.PRODUCT_PROPERTY, function);
       return this;
    }
    public PurchaseOrderItemRequest<T> groupByPurchaseOrderWith(PurchaseOrderRequest subRequest){
       groupBy(PurchaseOrderItem.PURCHASE_ORDER_PROPERTY, subRequest);
       return this;
    }
    public PurchaseOrderItemRequest<T> groupByPurchaseOrder(){
       groupBy(PurchaseOrderItem.PURCHASE_ORDER_PROPERTY);
       return this;
    }

    public PurchaseOrderItemRequest<T> groupByPurchaseOrderAs(String retName){
       groupBy(retName, PurchaseOrderItem.PURCHASE_ORDER_PROPERTY);
       return this;
    }

    public PurchaseOrderItemRequest<T> groupByPurchaseOrderWithFunction(String retName, AggrFunction function){
       groupBy(retName, PurchaseOrderItem.PURCHASE_ORDER_PROPERTY, function);
       return this;
    }

    public PurchaseOrderItemRequest<T> groupByQuantity(){
       groupBy(PurchaseOrderItem.QUANTITY_PROPERTY);
       return this;
    }

    public PurchaseOrderItemRequest<T> groupByQuantityAs(String retName){
       groupBy(retName, PurchaseOrderItem.QUANTITY_PROPERTY);
       return this;
    }

    public PurchaseOrderItemRequest<T> groupByQuantityWithFunction(String retName, AggrFunction function){
       groupBy(retName, PurchaseOrderItem.QUANTITY_PROPERTY, function);
       return this;
    }

    public PurchaseOrderItemRequest<T> groupByUnitCost(){
       groupBy(PurchaseOrderItem.UNIT_COST_PROPERTY);
       return this;
    }

    public PurchaseOrderItemRequest<T> groupByUnitCostAs(String retName){
       groupBy(retName, PurchaseOrderItem.UNIT_COST_PROPERTY);
       return this;
    }

    public PurchaseOrderItemRequest<T> groupByUnitCostWithFunction(String retName, AggrFunction function){
       groupBy(retName, PurchaseOrderItem.UNIT_COST_PROPERTY, function);
       return this;
    }

    public PurchaseOrderItemRequest<T> groupByCreateTime(){
       groupBy(PurchaseOrderItem.CREATE_TIME_PROPERTY);
       return this;
    }

    public PurchaseOrderItemRequest<T> groupByCreateTimeAs(String retName){
       groupBy(retName, PurchaseOrderItem.CREATE_TIME_PROPERTY);
       return this;
    }

    public PurchaseOrderItemRequest<T> groupByCreateTimeWithFunction(String retName, AggrFunction function){
       groupBy(retName, PurchaseOrderItem.CREATE_TIME_PROPERTY, function);
       return this;
    }

    public PurchaseOrderItemRequest<T> groupByUpdateTime(){
       groupBy(PurchaseOrderItem.UPDATE_TIME_PROPERTY);
       return this;
    }

    public PurchaseOrderItemRequest<T> groupByUpdateTimeAs(String retName){
       groupBy(retName, PurchaseOrderItem.UPDATE_TIME_PROPERTY);
       return this;
    }

    public PurchaseOrderItemRequest<T> groupByUpdateTimeWithFunction(String retName, AggrFunction function){
       groupBy(retName, PurchaseOrderItem.UPDATE_TIME_PROPERTY, function);
       return this;
    }

    public PurchaseOrderItemRequest<T> groupByVersion(){
       groupBy(PurchaseOrderItem.VERSION_PROPERTY);
       return this;
    }

    public PurchaseOrderItemRequest<T> groupByVersionAs(String retName){
       groupBy(retName, PurchaseOrderItem.VERSION_PROPERTY);
       return this;
    }

    public PurchaseOrderItemRequest<T> groupByVersionWithFunction(String retName, AggrFunction function){
       groupBy(retName, PurchaseOrderItem.VERSION_PROPERTY, function);
       return this;
    }



    public PurchaseOrderItemRequest<T> orderByIdAscending(){
       addOrderByAscending(PurchaseOrderItem.ID_PROPERTY);
       return this;
    }

    public PurchaseOrderItemRequest<T> orderByIdDescending(){
       addOrderByDescending(PurchaseOrderItem.ID_PROPERTY);
       return this;
    }

    public PurchaseOrderItemRequest<T> orderByProductAscending(){
       addOrderByAscending(PurchaseOrderItem.PRODUCT_PROPERTY);
       return this;
    }

    public PurchaseOrderItemRequest<T> orderByProductDescending(){
       addOrderByDescending(PurchaseOrderItem.PRODUCT_PROPERTY);
       return this;
    }

    public PurchaseOrderItemRequest<T> orderByPurchaseOrderAscending(){
       addOrderByAscending(PurchaseOrderItem.PURCHASE_ORDER_PROPERTY);
       return this;
    }

    public PurchaseOrderItemRequest<T> orderByPurchaseOrderDescending(){
       addOrderByDescending(PurchaseOrderItem.PURCHASE_ORDER_PROPERTY);
       return this;
    }

    public PurchaseOrderItemRequest<T> orderByQuantityAscending(){
       addOrderByAscending(PurchaseOrderItem.QUANTITY_PROPERTY);
       return this;
    }

    public PurchaseOrderItemRequest<T> orderByQuantityDescending(){
       addOrderByDescending(PurchaseOrderItem.QUANTITY_PROPERTY);
       return this;
    }

    public PurchaseOrderItemRequest<T> orderByUnitCostAscending(){
       addOrderByAscending(PurchaseOrderItem.UNIT_COST_PROPERTY);
       return this;
    }

    public PurchaseOrderItemRequest<T> orderByUnitCostDescending(){
       addOrderByDescending(PurchaseOrderItem.UNIT_COST_PROPERTY);
       return this;
    }

    public PurchaseOrderItemRequest<T> orderByCreateTimeAscending(){
       addOrderByAscending(PurchaseOrderItem.CREATE_TIME_PROPERTY);
       return this;
    }

    public PurchaseOrderItemRequest<T> orderByCreateTimeDescending(){
       addOrderByDescending(PurchaseOrderItem.CREATE_TIME_PROPERTY);
       return this;
    }

    public PurchaseOrderItemRequest<T> orderByUpdateTimeAscending(){
       addOrderByAscending(PurchaseOrderItem.UPDATE_TIME_PROPERTY);
       return this;
    }

    public PurchaseOrderItemRequest<T> orderByUpdateTimeDescending(){
       addOrderByDescending(PurchaseOrderItem.UPDATE_TIME_PROPERTY);
       return this;
    }

    public PurchaseOrderItemRequest<T> orderByVersionAscending(){
       addOrderByAscending(PurchaseOrderItem.VERSION_PROPERTY);
       return this;
    }

    public PurchaseOrderItemRequest<T> orderByVersionDescending(){
       addOrderByDescending(PurchaseOrderItem.VERSION_PROPERTY);
       return this;
    }


    public ProductRequest rollUpToProduct(){
       ProductRequest product = Q.products().unlimited();
       this.withProductMatching(product)
           .groupByProductWith(product);
       return product;
    }

    public PurchaseOrderRequest rollUpToPurchaseOrder(){
       PurchaseOrderRequest purchaseOrder = Q.purchaseOrders().unlimited();
       this.withPurchaseOrderMatching(purchaseOrder)
           .groupByPurchaseOrderWith(purchaseOrder);
       return purchaseOrder;
    }







   public PurchaseOrderItemRequest<T> facetByProductAs(String facetName, ProductRequest product){
       return facetByProductAs(facetName, product, true);
   }

   public PurchaseOrderItemRequest<T> facetByProductAs(String facetName, ProductRequest product, boolean includeAllFacets){
       addFacet(facetName, PurchaseOrderItem.PRODUCT_PROPERTY, product, includeAllFacets);
       return this;
   }
   public PurchaseOrderItemRequest<T> facetByPurchaseOrderAs(String facetName, PurchaseOrderRequest purchaseOrder){
       return facetByPurchaseOrderAs(facetName, purchaseOrder, true);
   }

   public PurchaseOrderItemRequest<T> facetByPurchaseOrderAs(String facetName, PurchaseOrderRequest purchaseOrder, boolean includeAllFacets){
       addFacet(facetName, PurchaseOrderItem.PURCHASE_ORDER_PROPERTY, purchaseOrder, includeAllFacets);
       return this;
   }


    /**
     * get topN records
     * @param topN  records number
     */
    public PurchaseOrderItemRequest<T> top(int topN) {
        super.top(topN);
        return this;
    }

    /**
     * get records from offset(inclusive) to offset+size(exclusive)
     * @param offset record offset
     * @param size records number
     */
    public PurchaseOrderItemRequest<T> offset(int offset, int size) {
        super.offset(offset, size);
        return this;
    }

    /**
     * retrieve all records
     */
    public PurchaseOrderItemRequest<T> unlimited() {
        super.unlimited();
        return this;
    }

    /**
     * get records of one page
     * @param pageNumber page number(1-based)
     * @param pageSize page size
     */
    public PurchaseOrderItemRequest<T> page(int pageNumber, int pageSize) {
        int offset = (pageNumber - 1) * pageSize;
        return offset(offset, pageSize);
   }

    /**
     * get records of one page, default page size is 10
     * @param pageNumber page number(1-based)
     */
    public PurchaseOrderItemRequest<T> page(int pageNumber) {
        return page(pageNumber, 10);
   }
}