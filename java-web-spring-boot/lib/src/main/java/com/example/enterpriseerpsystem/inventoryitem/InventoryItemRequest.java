
package com.example.enterpriseerpsystem.inventoryitem;

import com.example.enterpriseerpsystem.Q;
import com.example.enterpriseerpsystem.product.Product;
import com.example.enterpriseerpsystem.product.ProductRequest;
import com.example.enterpriseerpsystem.warehouse.Warehouse;
import com.example.enterpriseerpsystem.warehouse.WarehouseRequest;
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

public class InventoryItemRequest<T extends InventoryItem> extends BaseRequest<T> {

    /**
     * @deprecated AI agents and business code must use the generated Q facade
     *             instead of constructing request builders directly.
     */
    @Deprecated
    public InventoryItemRequest(Class<T> returnType){
        super(returnType);
        selectId();
        selectVersion();
    }

    public InventoryItemRequest<T> comment(String comment){
         super.internalComment(comment);
         return this;
    }

    // purpose() 继承自 BaseRequest，返回 ExecutableRequest（终结方法）

    public InventoryItemRequest<T> returnType(Class<? extends T> returnType){
        super.setReturnType(returnType);
        return this;
    }

    public InventoryItemRequest<T> enableAggregationCache(long cacheExpiredMillis){
        super.enableAggregationCache();
        super.aggregateCacheTime(cacheExpiredMillis);
        return this;
    }

    public InventoryItemRequest<T> enableAggregationCache(){
        return enableAggregationCache(0l);
    }


    public InventoryItemRequest<T> propagateAggregationCache(long cacheExpiredMillis){
        super.propagateAggregationCache(cacheExpiredMillis);
        return this;
    }

    public InventoryItemRequest<T> appendSearchCriteria(SearchCriteria searchCriteria){
        return (InventoryItemRequest<T>)super.appendSearchCriteria(searchCriteria);
    }

    public InventoryItemRequest<T> filter(String property1, Operator operator, String property2){
        return appendSearchCriteria(new TwoOperatorCriteria(operator, new PropertyReference(property1), new PropertyReference(property2)));
    }


    public InventoryItemRequest<T> matchingAnyOf(InventoryItemRequest inventoryItem){
        super.internalMatchAny(inventoryItem);
        return this;
    }

    public InventoryItemRequest<T> enhanceChildrenIfNeeded(){
        return this;
    }

    public InventoryItemRequest<T> withDeletedRows(){
        super.withDeletedRows();
        return this;
    }

    public InventoryItemRequest<T> deletedRowsOnly(){
        super.deletedRowsOnly();
        return this;
    }

    public InventoryItemRequest<T> selectSelf(){
        super.selectSelf();
        return selectId().selectProductIdOnly().selectQuantityOnHand().selectReorderLevel().selectWarehouseIdOnly().selectCreateTime().selectUpdateTime().selectVersion();
    }

    public InventoryItemRequest<T> selectSelfFields(){
        return selectSelf();
    }

    public InventoryItemRequest<T> selectAll(){
        super.selectAll();
        return selectId().selectProduct().selectQuantityOnHand().selectReorderLevel().selectWarehouse().selectCreateTime().selectUpdateTime().selectVersion();
    }

    public InventoryItemRequest<T> selectChildren(){
        super.selectAny();
        return selectId().selectProduct().selectQuantityOnHand().selectReorderLevel().selectWarehouse().selectCreateTime().selectUpdateTime().selectVersion();
    }


    public InventoryItemRequest<T> selectId(){
       selectProperty(InventoryItem.ID_PROPERTY);
       return this;
    }

    /**
     * fill the id with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  id) to fetch id property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public InventoryItemRequest<T> unselectId(){
       unselectProperty(InventoryItem.ID_PROPERTY);
       return this;
    }
    public InventoryItemRequest<T> selectProductIdOnly(){
       selectProperty(InventoryItem.PRODUCT_PROPERTY);
       return this;
    }

    public InventoryItemRequest<T> selectProduct(){
        return selectProductWith(Q.products().unlimited().selectSelf());
    }

    public InventoryItemRequest<T> selectProductWith(ProductRequest product){
       selectProperty(InventoryItem.PRODUCT_PROPERTY);
       enhanceRelation(InventoryItem.PRODUCT_PROPERTY, product);
       return this;
    }

    public InventoryItemRequest<T> unselectProduct(){
       unselectProperty(InventoryItem.PRODUCT_PROPERTY);
       return this;
    }
    public InventoryItemRequest<T> selectQuantityOnHand(){
       selectProperty(InventoryItem.QUANTITY_ON_HAND_PROPERTY);
       return this;
    }

    /**
     * fill the quantityOnHand with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  quantityOnHand) to fetch quantityOnHand property.
     * @param rawSqlSegment  customized rawSqlSegment
     */


    /**
     * fill the quantityOnHand with customized aggrFunction, TEAQL uses ({aggrFunction}(quantityOnHand) AS quantityOnHand to fetch quantityOnHand property.
     * @param aggrFunction  aggrFunction
     */
    public InventoryItemRequest<T> selectQuantityOnHand(AggrFunction aggrFunction){
       selectProperty(InventoryItem.QUANTITY_ON_HAND_PROPERTY, aggrFunction);
       return this;
    }


    public InventoryItemRequest<T> unselectQuantityOnHand(){
       unselectProperty(InventoryItem.QUANTITY_ON_HAND_PROPERTY);
       return this;
    }
    public InventoryItemRequest<T> selectReorderLevel(){
       selectProperty(InventoryItem.REORDER_LEVEL_PROPERTY);
       return this;
    }

    /**
     * fill the reorderLevel with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  reorderLevel) to fetch reorderLevel property.
     * @param rawSqlSegment  customized rawSqlSegment
     */


    /**
     * fill the reorderLevel with customized aggrFunction, TEAQL uses ({aggrFunction}(reorderLevel) AS reorderLevel to fetch reorderLevel property.
     * @param aggrFunction  aggrFunction
     */
    public InventoryItemRequest<T> selectReorderLevel(AggrFunction aggrFunction){
       selectProperty(InventoryItem.REORDER_LEVEL_PROPERTY, aggrFunction);
       return this;
    }


    public InventoryItemRequest<T> unselectReorderLevel(){
       unselectProperty(InventoryItem.REORDER_LEVEL_PROPERTY);
       return this;
    }
    public InventoryItemRequest<T> selectWarehouseIdOnly(){
       selectProperty(InventoryItem.WAREHOUSE_PROPERTY);
       return this;
    }

    public InventoryItemRequest<T> selectWarehouse(){
        return selectWarehouseWith(Q.warehouses().unlimited().selectSelf());
    }

    public InventoryItemRequest<T> selectWarehouseWith(WarehouseRequest warehouse){
       selectProperty(InventoryItem.WAREHOUSE_PROPERTY);
       enhanceRelation(InventoryItem.WAREHOUSE_PROPERTY, warehouse);
       return this;
    }

    public InventoryItemRequest<T> unselectWarehouse(){
       unselectProperty(InventoryItem.WAREHOUSE_PROPERTY);
       return this;
    }
    public InventoryItemRequest<T> selectCreateTime(){
       selectProperty(InventoryItem.CREATE_TIME_PROPERTY);
       return this;
    }

    /**
     * fill the createTime with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  createTime) to fetch createTime property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public InventoryItemRequest<T> unselectCreateTime(){
       unselectProperty(InventoryItem.CREATE_TIME_PROPERTY);
       return this;
    }
    public InventoryItemRequest<T> selectUpdateTime(){
       selectProperty(InventoryItem.UPDATE_TIME_PROPERTY);
       return this;
    }

    /**
     * fill the updateTime with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  updateTime) to fetch updateTime property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public InventoryItemRequest<T> unselectUpdateTime(){
       unselectProperty(InventoryItem.UPDATE_TIME_PROPERTY);
       return this;
    }
    public InventoryItemRequest<T> selectVersion(){
       selectProperty(InventoryItem.VERSION_PROPERTY);
       return this;
    }

    /**
     * fill the version with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  version) to fetch version property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public InventoryItemRequest<T> unselectVersion(){
       unselectProperty(InventoryItem.VERSION_PROPERTY);
       return this;
    }

    public InventoryItemRequest<T> withId(Operator operator, Object... values){
       return appendSearchCriteria(createIdCriteria(operator, values));
    }

    public SearchCriteria createIdCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(InventoryItem.ID_PROPERTY, operator, values);
    }

    public InventoryItemRequest<T> withIdIs(Long id){
       return withId(Operator.EQUAL, id);
    }
    public InventoryItemRequest<T> withIdIn(Long... id){
       return withId(Operator.EQUAL, (Object[])id);
    }



    public InventoryItemRequest<T> filterByProduct(Product... product){
      if (product == null || product.length == 0) {
        throw new IllegalArgumentException("filterByProduct parameter product cannot be empty");
      }
      return appendSearchCriteria(createProductCriteria(Operator.EQUAL, (Object[])product));
    }

    public InventoryItemRequest<T> withProduct(Operator operator, Object... values){
       return appendSearchCriteria(createProductCriteria(operator, values));
    }

    public InventoryItemRequest<T> withProductIsUnknown(){
       return withProduct(Operator.IS_NULL);
    }

    public InventoryItemRequest<T> withProductIsKnown(){
       return withProduct(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createProductCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(InventoryItem.PRODUCT_PROPERTY, operator, values);
    }

    public InventoryItemRequest<T> filterByProduct(Long product){
      if(product == null){
         return this;
      }
      return withProduct(Operator.EQUAL, product);
    }
    public InventoryItemRequest<T> withProductMatching(ProductRequest product){
       return appendSearchCriteria(new SubQuerySearchCriteria(InventoryItem.PRODUCT_PROPERTY, product, Product.ID_PROPERTY));
    }

    public InventoryItemRequest<T> filterByQuantityOnHand(BigDecimal... quantityOnHand){
      if (quantityOnHand == null || quantityOnHand.length == 0) {
        throw new IllegalArgumentException("filterByQuantityOnHand parameter quantityOnHand cannot be empty");
      }
      return appendSearchCriteria(createQuantityOnHandCriteria(Operator.EQUAL, (Object[])quantityOnHand));
    }

    public InventoryItemRequest<T> withQuantityOnHand(Operator operator, Object... values){
       return appendSearchCriteria(createQuantityOnHandCriteria(operator, values));
    }

    public InventoryItemRequest<T> withQuantityOnHandIsUnknown(){
       return withQuantityOnHand(Operator.IS_NULL);
    }

    public InventoryItemRequest<T> withQuantityOnHandIsKnown(){
       return withQuantityOnHand(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createQuantityOnHandCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(InventoryItem.QUANTITY_ON_HAND_PROPERTY, operator, values);
    }

    public InventoryItemRequest<T> withQuantityOnHandGreaterThan(BigDecimal quantityOnHand){
       return withQuantityOnHand(Operator.GREATER_THAN, quantityOnHand);
    }

    public InventoryItemRequest<T> withQuantityOnHandGreaterThanOrEqualTo(BigDecimal quantityOnHand){
       return withQuantityOnHand(Operator.GREATER_THAN_OR_EQUAL, quantityOnHand);
    }

    public InventoryItemRequest<T> withQuantityOnHandLessThan(BigDecimal quantityOnHand){
       return withQuantityOnHand(Operator.LESS_THAN, quantityOnHand);
    }

    public InventoryItemRequest<T> withQuantityOnHandLessThanOrEqualTo(BigDecimal quantityOnHand){
       return withQuantityOnHand(Operator.LESS_THAN_OR_EQUAL, quantityOnHand);
    }

    public InventoryItemRequest<T> withQuantityOnHandBetween(BigDecimal startOfQuantityOnHand, BigDecimal endOfQuantityOnHand){
       return withQuantityOnHand(Operator.BETWEEN, startOfQuantityOnHand, endOfQuantityOnHand);
    }



    public InventoryItemRequest<T> filterByReorderLevel(BigDecimal... reorderLevel){
      if (reorderLevel == null || reorderLevel.length == 0) {
        throw new IllegalArgumentException("filterByReorderLevel parameter reorderLevel cannot be empty");
      }
      return appendSearchCriteria(createReorderLevelCriteria(Operator.EQUAL, (Object[])reorderLevel));
    }

    public InventoryItemRequest<T> withReorderLevel(Operator operator, Object... values){
       return appendSearchCriteria(createReorderLevelCriteria(operator, values));
    }

    public InventoryItemRequest<T> withReorderLevelIsUnknown(){
       return withReorderLevel(Operator.IS_NULL);
    }

    public InventoryItemRequest<T> withReorderLevelIsKnown(){
       return withReorderLevel(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createReorderLevelCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(InventoryItem.REORDER_LEVEL_PROPERTY, operator, values);
    }

    public InventoryItemRequest<T> withReorderLevelGreaterThan(BigDecimal reorderLevel){
       return withReorderLevel(Operator.GREATER_THAN, reorderLevel);
    }

    public InventoryItemRequest<T> withReorderLevelGreaterThanOrEqualTo(BigDecimal reorderLevel){
       return withReorderLevel(Operator.GREATER_THAN_OR_EQUAL, reorderLevel);
    }

    public InventoryItemRequest<T> withReorderLevelLessThan(BigDecimal reorderLevel){
       return withReorderLevel(Operator.LESS_THAN, reorderLevel);
    }

    public InventoryItemRequest<T> withReorderLevelLessThanOrEqualTo(BigDecimal reorderLevel){
       return withReorderLevel(Operator.LESS_THAN_OR_EQUAL, reorderLevel);
    }

    public InventoryItemRequest<T> withReorderLevelBetween(BigDecimal startOfReorderLevel, BigDecimal endOfReorderLevel){
       return withReorderLevel(Operator.BETWEEN, startOfReorderLevel, endOfReorderLevel);
    }



    public InventoryItemRequest<T> filterByWarehouse(Warehouse... warehouse){
      if (warehouse == null || warehouse.length == 0) {
        throw new IllegalArgumentException("filterByWarehouse parameter warehouse cannot be empty");
      }
      return appendSearchCriteria(createWarehouseCriteria(Operator.EQUAL, (Object[])warehouse));
    }

    public InventoryItemRequest<T> withWarehouse(Operator operator, Object... values){
       return appendSearchCriteria(createWarehouseCriteria(operator, values));
    }

    public InventoryItemRequest<T> withWarehouseIsUnknown(){
       return withWarehouse(Operator.IS_NULL);
    }

    public InventoryItemRequest<T> withWarehouseIsKnown(){
       return withWarehouse(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createWarehouseCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(InventoryItem.WAREHOUSE_PROPERTY, operator, values);
    }

    public InventoryItemRequest<T> filterByWarehouse(Long warehouse){
      if(warehouse == null){
         return this;
      }
      return withWarehouse(Operator.EQUAL, warehouse);
    }
    public InventoryItemRequest<T> withWarehouseMatching(WarehouseRequest warehouse){
       return appendSearchCriteria(new SubQuerySearchCriteria(InventoryItem.WAREHOUSE_PROPERTY, warehouse, Warehouse.ID_PROPERTY));
    }

    public InventoryItemRequest<T> filterByCreateTime(LocalDateTime... createTime){
      if (createTime == null || createTime.length == 0) {
        throw new IllegalArgumentException("filterByCreateTime parameter createTime cannot be empty");
      }
      return appendSearchCriteria(createCreateTimeCriteria(Operator.EQUAL, (Object[])createTime));
    }

    public InventoryItemRequest<T> withCreateTime(Operator operator, Object... values){
       return appendSearchCriteria(createCreateTimeCriteria(operator, values));
    }

    public InventoryItemRequest<T> withCreateTimeIsUnknown(){
       return withCreateTime(Operator.IS_NULL);
    }

    public InventoryItemRequest<T> withCreateTimeIsKnown(){
       return withCreateTime(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createCreateTimeCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(InventoryItem.CREATE_TIME_PROPERTY, operator, values);
    }

    public InventoryItemRequest<T> withCreateTimeGreaterThan(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public InventoryItemRequest<T> withCreateTimeGreaterThanOrEqualTo(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN_OR_EQUAL, createTime);
    }

    public InventoryItemRequest<T> withCreateTimeLessThan(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public InventoryItemRequest<T> withCreateTimeLessThanOrEqualTo(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN_OR_EQUAL, createTime);
    }

    public InventoryItemRequest<T> withCreateTimeBetween(LocalDateTime startOfCreateTime, LocalDateTime endOfCreateTime){
       return withCreateTime(Operator.BETWEEN, startOfCreateTime, endOfCreateTime);
    }
    public InventoryItemRequest<T> withCreateTimeBefore(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public InventoryItemRequest<T> withCreateTimeBefore(Date createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public InventoryItemRequest<T> withCreateTimeAfter(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public InventoryItemRequest<T> withCreateTimeAfter(Date createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public InventoryItemRequest<T> withCreateTimeBetween(Date startOfCreateTime, Date endOfCreateTime){
       return withCreateTime(Operator.BETWEEN, startOfCreateTime, endOfCreateTime);
    }




    public InventoryItemRequest<T> filterByUpdateTime(LocalDateTime... updateTime){
      if (updateTime == null || updateTime.length == 0) {
        throw new IllegalArgumentException("filterByUpdateTime parameter updateTime cannot be empty");
      }
      return appendSearchCriteria(createUpdateTimeCriteria(Operator.EQUAL, (Object[])updateTime));
    }

    public InventoryItemRequest<T> withUpdateTime(Operator operator, Object... values){
       return appendSearchCriteria(createUpdateTimeCriteria(operator, values));
    }

    public InventoryItemRequest<T> withUpdateTimeIsUnknown(){
       return withUpdateTime(Operator.IS_NULL);
    }

    public InventoryItemRequest<T> withUpdateTimeIsKnown(){
       return withUpdateTime(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createUpdateTimeCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(InventoryItem.UPDATE_TIME_PROPERTY, operator, values);
    }

    public InventoryItemRequest<T> withUpdateTimeGreaterThan(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public InventoryItemRequest<T> withUpdateTimeGreaterThanOrEqualTo(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN_OR_EQUAL, updateTime);
    }

    public InventoryItemRequest<T> withUpdateTimeLessThan(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public InventoryItemRequest<T> withUpdateTimeLessThanOrEqualTo(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN_OR_EQUAL, updateTime);
    }

    public InventoryItemRequest<T> withUpdateTimeBetween(LocalDateTime startOfUpdateTime, LocalDateTime endOfUpdateTime){
       return withUpdateTime(Operator.BETWEEN, startOfUpdateTime, endOfUpdateTime);
    }
    public InventoryItemRequest<T> withUpdateTimeBefore(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public InventoryItemRequest<T> withUpdateTimeBefore(Date updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public InventoryItemRequest<T> withUpdateTimeAfter(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public InventoryItemRequest<T> withUpdateTimeAfter(Date updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public InventoryItemRequest<T> withUpdateTimeBetween(Date startOfUpdateTime, Date endOfUpdateTime){
       return withUpdateTime(Operator.BETWEEN, startOfUpdateTime, endOfUpdateTime);
    }




    public InventoryItemRequest<T> filterByVersion(Long... version){
      if (version == null || version.length == 0) {
        throw new IllegalArgumentException("filterByVersion parameter version cannot be empty");
      }
      return appendSearchCriteria(createVersionCriteria(Operator.EQUAL, (Object[])version));
    }

    public InventoryItemRequest<T> withVersion(Operator operator, Object... values){
       return appendSearchCriteria(createVersionCriteria(operator, values));
    }

    public InventoryItemRequest<T> withVersionIsUnknown(){
       return withVersion(Operator.IS_NULL);
    }

    public InventoryItemRequest<T> withVersionIsKnown(){
       return withVersion(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createVersionCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(InventoryItem.VERSION_PROPERTY, operator, values);
    }

    public InventoryItemRequest<T> withVersionGreaterThan(Long version){
       return withVersion(Operator.GREATER_THAN, version);
    }

    public InventoryItemRequest<T> withVersionGreaterThanOrEqualTo(Long version){
       return withVersion(Operator.GREATER_THAN_OR_EQUAL, version);
    }

    public InventoryItemRequest<T> withVersionLessThan(Long version){
       return withVersion(Operator.LESS_THAN, version);
    }

    public InventoryItemRequest<T> withVersionLessThanOrEqualTo(Long version){
       return withVersion(Operator.LESS_THAN_OR_EQUAL, version);
    }

    public InventoryItemRequest<T> withVersionBetween(Long startOfVersion, Long endOfVersion){
       return withVersion(Operator.BETWEEN, startOfVersion, endOfVersion);
    }


    public InventoryItemRequest<T> count(){
        super.count();
        return this;
    }
    public InventoryItemRequest<T> countAs(String retName){
        super.count(retName);
        return this;
    }
    public InventoryItemRequest minQuantityOnHand(){
        return minQuantityOnHandAs(prefix("minOf",InventoryItem.QUANTITY_ON_HAND_PROPERTY));
    }

    public InventoryItemRequest minQuantityOnHandAs(String retName){
        super.min(retName, InventoryItem.QUANTITY_ON_HAND_PROPERTY);
        return this;
    }
    public InventoryItemRequest maxQuantityOnHand(){
        return maxQuantityOnHandAs(prefix("maxOf",InventoryItem.QUANTITY_ON_HAND_PROPERTY));
    }

    public InventoryItemRequest maxQuantityOnHandAs(String retName){
        super.max(retName, InventoryItem.QUANTITY_ON_HAND_PROPERTY);
        return this;
    }
    public InventoryItemRequest sumQuantityOnHand(){
        return sumQuantityOnHandAs(prefix("sumOf",InventoryItem.QUANTITY_ON_HAND_PROPERTY));
    }

    public InventoryItemRequest sumQuantityOnHandAs(String retName){
        super.sum(retName, InventoryItem.QUANTITY_ON_HAND_PROPERTY);
        return this;
    }
    public InventoryItemRequest avgQuantityOnHand(){
        return avgQuantityOnHandAs(prefix("avgOf",InventoryItem.QUANTITY_ON_HAND_PROPERTY));
    }

    public InventoryItemRequest avgQuantityOnHandAs(String retName){
        super.avg(retName, InventoryItem.QUANTITY_ON_HAND_PROPERTY);
        return this;
    }
    public InventoryItemRequest standardDeviationQuantityOnHand(){
        return standardDeviationQuantityOnHandAs(prefix("standardDeviationOf",InventoryItem.QUANTITY_ON_HAND_PROPERTY));
    }

    public InventoryItemRequest standardDeviationQuantityOnHandAs(String retName){
        super.standardDeviation(retName, InventoryItem.QUANTITY_ON_HAND_PROPERTY);
        return this;
    }
    public InventoryItemRequest squareRootOfPopulationStandardDeviationQuantityOnHand(){
        return squareRootOfPopulationStandardDeviationQuantityOnHandAs(prefix("squareRootOfPopulationStandardDeviationOf",InventoryItem.QUANTITY_ON_HAND_PROPERTY));
    }

    public InventoryItemRequest squareRootOfPopulationStandardDeviationQuantityOnHandAs(String retName){
        super.squareRootOfPopulationStandardDeviation(retName, InventoryItem.QUANTITY_ON_HAND_PROPERTY);
        return this;
    }
    public InventoryItemRequest sampleVarianceQuantityOnHand(){
        return sampleVarianceQuantityOnHandAs(prefix("sampleVarianceOf",InventoryItem.QUANTITY_ON_HAND_PROPERTY));
    }

    public InventoryItemRequest sampleVarianceQuantityOnHandAs(String retName){
        super.sampleVariance(retName, InventoryItem.QUANTITY_ON_HAND_PROPERTY);
        return this;
    }
    public InventoryItemRequest samplePopulationVarianceQuantityOnHand(){
        return samplePopulationVarianceQuantityOnHandAs(prefix("samplePopulationVarianceOf",InventoryItem.QUANTITY_ON_HAND_PROPERTY));
    }

    public InventoryItemRequest samplePopulationVarianceQuantityOnHandAs(String retName){
        super.samplePopulationVariance(retName, InventoryItem.QUANTITY_ON_HAND_PROPERTY);
        return this;
    }
    public InventoryItemRequest minReorderLevel(){
        return minReorderLevelAs(prefix("minOf",InventoryItem.REORDER_LEVEL_PROPERTY));
    }

    public InventoryItemRequest minReorderLevelAs(String retName){
        super.min(retName, InventoryItem.REORDER_LEVEL_PROPERTY);
        return this;
    }
    public InventoryItemRequest maxReorderLevel(){
        return maxReorderLevelAs(prefix("maxOf",InventoryItem.REORDER_LEVEL_PROPERTY));
    }

    public InventoryItemRequest maxReorderLevelAs(String retName){
        super.max(retName, InventoryItem.REORDER_LEVEL_PROPERTY);
        return this;
    }
    public InventoryItemRequest sumReorderLevel(){
        return sumReorderLevelAs(prefix("sumOf",InventoryItem.REORDER_LEVEL_PROPERTY));
    }

    public InventoryItemRequest sumReorderLevelAs(String retName){
        super.sum(retName, InventoryItem.REORDER_LEVEL_PROPERTY);
        return this;
    }
    public InventoryItemRequest avgReorderLevel(){
        return avgReorderLevelAs(prefix("avgOf",InventoryItem.REORDER_LEVEL_PROPERTY));
    }

    public InventoryItemRequest avgReorderLevelAs(String retName){
        super.avg(retName, InventoryItem.REORDER_LEVEL_PROPERTY);
        return this;
    }
    public InventoryItemRequest standardDeviationReorderLevel(){
        return standardDeviationReorderLevelAs(prefix("standardDeviationOf",InventoryItem.REORDER_LEVEL_PROPERTY));
    }

    public InventoryItemRequest standardDeviationReorderLevelAs(String retName){
        super.standardDeviation(retName, InventoryItem.REORDER_LEVEL_PROPERTY);
        return this;
    }
    public InventoryItemRequest squareRootOfPopulationStandardDeviationReorderLevel(){
        return squareRootOfPopulationStandardDeviationReorderLevelAs(prefix("squareRootOfPopulationStandardDeviationOf",InventoryItem.REORDER_LEVEL_PROPERTY));
    }

    public InventoryItemRequest squareRootOfPopulationStandardDeviationReorderLevelAs(String retName){
        super.squareRootOfPopulationStandardDeviation(retName, InventoryItem.REORDER_LEVEL_PROPERTY);
        return this;
    }
    public InventoryItemRequest sampleVarianceReorderLevel(){
        return sampleVarianceReorderLevelAs(prefix("sampleVarianceOf",InventoryItem.REORDER_LEVEL_PROPERTY));
    }

    public InventoryItemRequest sampleVarianceReorderLevelAs(String retName){
        super.sampleVariance(retName, InventoryItem.REORDER_LEVEL_PROPERTY);
        return this;
    }
    public InventoryItemRequest samplePopulationVarianceReorderLevel(){
        return samplePopulationVarianceReorderLevelAs(prefix("samplePopulationVarianceOf",InventoryItem.REORDER_LEVEL_PROPERTY));
    }

    public InventoryItemRequest samplePopulationVarianceReorderLevelAs(String retName){
        super.samplePopulationVariance(retName, InventoryItem.REORDER_LEVEL_PROPERTY);
        return this;
    }
    public InventoryItemRequest<T> groupByProductWithDetails(){
       return groupByProductWithDetails(Q.products().unlimited());
    }

    public InventoryItemRequest<T> groupByProductWithDetails(ProductRequest subRequest){
       aggregate(InventoryItem.PRODUCT_PROPERTY, subRequest);
       return this;
    }



    public InventoryItemRequest<T> groupByWarehouseWithDetails(){
       return groupByWarehouseWithDetails(Q.warehouses().unlimited());
    }

    public InventoryItemRequest<T> groupByWarehouseWithDetails(WarehouseRequest subRequest){
       aggregate(InventoryItem.WAREHOUSE_PROPERTY, subRequest);
       return this;
    }





    public InventoryItemRequest<T> groupById(){
       groupBy(InventoryItem.ID_PROPERTY);
       return this;
    }

    public InventoryItemRequest<T> groupByIdAs(String retName){
       groupBy(retName, InventoryItem.ID_PROPERTY);
       return this;
    }

    public InventoryItemRequest<T> groupByIdWithFunction(String retName, AggrFunction function){
       groupBy(retName, InventoryItem.ID_PROPERTY, function);
       return this;
    }
    public InventoryItemRequest<T> groupByProductWith(ProductRequest subRequest){
       groupBy(InventoryItem.PRODUCT_PROPERTY, subRequest);
       return this;
    }
    public InventoryItemRequest<T> groupByProduct(){
       groupBy(InventoryItem.PRODUCT_PROPERTY);
       return this;
    }

    public InventoryItemRequest<T> groupByProductAs(String retName){
       groupBy(retName, InventoryItem.PRODUCT_PROPERTY);
       return this;
    }

    public InventoryItemRequest<T> groupByProductWithFunction(String retName, AggrFunction function){
       groupBy(retName, InventoryItem.PRODUCT_PROPERTY, function);
       return this;
    }

    public InventoryItemRequest<T> groupByQuantityOnHand(){
       groupBy(InventoryItem.QUANTITY_ON_HAND_PROPERTY);
       return this;
    }

    public InventoryItemRequest<T> groupByQuantityOnHandAs(String retName){
       groupBy(retName, InventoryItem.QUANTITY_ON_HAND_PROPERTY);
       return this;
    }

    public InventoryItemRequest<T> groupByQuantityOnHandWithFunction(String retName, AggrFunction function){
       groupBy(retName, InventoryItem.QUANTITY_ON_HAND_PROPERTY, function);
       return this;
    }

    public InventoryItemRequest<T> groupByReorderLevel(){
       groupBy(InventoryItem.REORDER_LEVEL_PROPERTY);
       return this;
    }

    public InventoryItemRequest<T> groupByReorderLevelAs(String retName){
       groupBy(retName, InventoryItem.REORDER_LEVEL_PROPERTY);
       return this;
    }

    public InventoryItemRequest<T> groupByReorderLevelWithFunction(String retName, AggrFunction function){
       groupBy(retName, InventoryItem.REORDER_LEVEL_PROPERTY, function);
       return this;
    }
    public InventoryItemRequest<T> groupByWarehouseWith(WarehouseRequest subRequest){
       groupBy(InventoryItem.WAREHOUSE_PROPERTY, subRequest);
       return this;
    }
    public InventoryItemRequest<T> groupByWarehouse(){
       groupBy(InventoryItem.WAREHOUSE_PROPERTY);
       return this;
    }

    public InventoryItemRequest<T> groupByWarehouseAs(String retName){
       groupBy(retName, InventoryItem.WAREHOUSE_PROPERTY);
       return this;
    }

    public InventoryItemRequest<T> groupByWarehouseWithFunction(String retName, AggrFunction function){
       groupBy(retName, InventoryItem.WAREHOUSE_PROPERTY, function);
       return this;
    }

    public InventoryItemRequest<T> groupByCreateTime(){
       groupBy(InventoryItem.CREATE_TIME_PROPERTY);
       return this;
    }

    public InventoryItemRequest<T> groupByCreateTimeAs(String retName){
       groupBy(retName, InventoryItem.CREATE_TIME_PROPERTY);
       return this;
    }

    public InventoryItemRequest<T> groupByCreateTimeWithFunction(String retName, AggrFunction function){
       groupBy(retName, InventoryItem.CREATE_TIME_PROPERTY, function);
       return this;
    }

    public InventoryItemRequest<T> groupByUpdateTime(){
       groupBy(InventoryItem.UPDATE_TIME_PROPERTY);
       return this;
    }

    public InventoryItemRequest<T> groupByUpdateTimeAs(String retName){
       groupBy(retName, InventoryItem.UPDATE_TIME_PROPERTY);
       return this;
    }

    public InventoryItemRequest<T> groupByUpdateTimeWithFunction(String retName, AggrFunction function){
       groupBy(retName, InventoryItem.UPDATE_TIME_PROPERTY, function);
       return this;
    }

    public InventoryItemRequest<T> groupByVersion(){
       groupBy(InventoryItem.VERSION_PROPERTY);
       return this;
    }

    public InventoryItemRequest<T> groupByVersionAs(String retName){
       groupBy(retName, InventoryItem.VERSION_PROPERTY);
       return this;
    }

    public InventoryItemRequest<T> groupByVersionWithFunction(String retName, AggrFunction function){
       groupBy(retName, InventoryItem.VERSION_PROPERTY, function);
       return this;
    }



    public InventoryItemRequest<T> orderByIdAscending(){
       addOrderByAscending(InventoryItem.ID_PROPERTY);
       return this;
    }

    public InventoryItemRequest<T> orderByIdDescending(){
       addOrderByDescending(InventoryItem.ID_PROPERTY);
       return this;
    }

    public InventoryItemRequest<T> orderByProductAscending(){
       addOrderByAscending(InventoryItem.PRODUCT_PROPERTY);
       return this;
    }

    public InventoryItemRequest<T> orderByProductDescending(){
       addOrderByDescending(InventoryItem.PRODUCT_PROPERTY);
       return this;
    }

    public InventoryItemRequest<T> orderByQuantityOnHandAscending(){
       addOrderByAscending(InventoryItem.QUANTITY_ON_HAND_PROPERTY);
       return this;
    }

    public InventoryItemRequest<T> orderByQuantityOnHandDescending(){
       addOrderByDescending(InventoryItem.QUANTITY_ON_HAND_PROPERTY);
       return this;
    }

    public InventoryItemRequest<T> orderByReorderLevelAscending(){
       addOrderByAscending(InventoryItem.REORDER_LEVEL_PROPERTY);
       return this;
    }

    public InventoryItemRequest<T> orderByReorderLevelDescending(){
       addOrderByDescending(InventoryItem.REORDER_LEVEL_PROPERTY);
       return this;
    }

    public InventoryItemRequest<T> orderByWarehouseAscending(){
       addOrderByAscending(InventoryItem.WAREHOUSE_PROPERTY);
       return this;
    }

    public InventoryItemRequest<T> orderByWarehouseDescending(){
       addOrderByDescending(InventoryItem.WAREHOUSE_PROPERTY);
       return this;
    }

    public InventoryItemRequest<T> orderByCreateTimeAscending(){
       addOrderByAscending(InventoryItem.CREATE_TIME_PROPERTY);
       return this;
    }

    public InventoryItemRequest<T> orderByCreateTimeDescending(){
       addOrderByDescending(InventoryItem.CREATE_TIME_PROPERTY);
       return this;
    }

    public InventoryItemRequest<T> orderByUpdateTimeAscending(){
       addOrderByAscending(InventoryItem.UPDATE_TIME_PROPERTY);
       return this;
    }

    public InventoryItemRequest<T> orderByUpdateTimeDescending(){
       addOrderByDescending(InventoryItem.UPDATE_TIME_PROPERTY);
       return this;
    }

    public InventoryItemRequest<T> orderByVersionAscending(){
       addOrderByAscending(InventoryItem.VERSION_PROPERTY);
       return this;
    }

    public InventoryItemRequest<T> orderByVersionDescending(){
       addOrderByDescending(InventoryItem.VERSION_PROPERTY);
       return this;
    }


    public ProductRequest rollUpToProduct(){
       ProductRequest product = Q.products().unlimited();
       this.withProductMatching(product)
           .groupByProductWith(product);
       return product;
    }



    public WarehouseRequest rollUpToWarehouse(){
       WarehouseRequest warehouse = Q.warehouses().unlimited();
       this.withWarehouseMatching(warehouse)
           .groupByWarehouseWith(warehouse);
       return warehouse;
    }





   public InventoryItemRequest<T> facetByProductAs(String facetName, ProductRequest product){
       return facetByProductAs(facetName, product, true);
   }

   public InventoryItemRequest<T> facetByProductAs(String facetName, ProductRequest product, boolean includeAllFacets){
       addFacet(facetName, InventoryItem.PRODUCT_PROPERTY, product, includeAllFacets);
       return this;
   }
   public InventoryItemRequest<T> facetByWarehouseAs(String facetName, WarehouseRequest warehouse){
       return facetByWarehouseAs(facetName, warehouse, true);
   }

   public InventoryItemRequest<T> facetByWarehouseAs(String facetName, WarehouseRequest warehouse, boolean includeAllFacets){
       addFacet(facetName, InventoryItem.WAREHOUSE_PROPERTY, warehouse, includeAllFacets);
       return this;
   }


    /**
     * get topN records
     * @param topN  records number
     */
    public InventoryItemRequest<T> top(int topN) {
        super.top(topN);
        return this;
    }

    /**
     * get records from offset(inclusive) to offset+size(exclusive)
     * @param offset record offset
     * @param size records number
     */
    public InventoryItemRequest<T> offset(int offset, int size) {
        super.offset(offset, size);
        return this;
    }

    /**
     * retrieve all records
     */
    public InventoryItemRequest<T> unlimited() {
        super.unlimited();
        return this;
    }

    /**
     * get records of one page
     * @param pageNumber page number(1-based)
     * @param pageSize page size
     */
    public InventoryItemRequest<T> page(int pageNumber, int pageSize) {
        int offset = (pageNumber - 1) * pageSize;
        return offset(offset, pageSize);
   }

    /**
     * get records of one page, default page size is 10
     * @param pageNumber page number(1-based)
     */
    public InventoryItemRequest<T> page(int pageNumber) {
        return page(pageNumber, 10);
   }
}