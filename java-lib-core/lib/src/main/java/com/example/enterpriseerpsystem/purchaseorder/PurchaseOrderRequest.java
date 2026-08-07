
package com.example.enterpriseerpsystem.purchaseorder;

import com.example.enterpriseerpsystem.Q;
import com.example.enterpriseerpsystem.purchaseorderitem.PurchaseOrderItem;
import com.example.enterpriseerpsystem.purchaseorderitem.PurchaseOrderItemRequest;
import com.example.enterpriseerpsystem.supplier.Supplier;
import com.example.enterpriseerpsystem.supplier.SupplierRequest;
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

public class PurchaseOrderRequest<T extends PurchaseOrder> extends BaseRequest<T> {

    /**
     * @deprecated AI agents and business code must use the generated Q facade
     *             instead of constructing request builders directly.
     */
    @Deprecated
    public PurchaseOrderRequest(Class<T> returnType){
        super(returnType);
        selectId();
        selectVersion();
    }

    public PurchaseOrderRequest<T> comment(String comment){
         super.internalComment(comment);
         return this;
    }

    // purpose() 继承自 BaseRequest，返回 ExecutableRequest（终结方法）

    public PurchaseOrderRequest<T> returnType(Class<? extends T> returnType){
        super.setReturnType(returnType);
        return this;
    }

    public PurchaseOrderRequest<T> enableAggregationCache(long cacheExpiredMillis){
        super.enableAggregationCache();
        super.aggregateCacheTime(cacheExpiredMillis);
        return this;
    }

    public PurchaseOrderRequest<T> enableAggregationCache(){
        return enableAggregationCache(0l);
    }


    public PurchaseOrderRequest<T> propagateAggregationCache(long cacheExpiredMillis){
        super.propagateAggregationCache(cacheExpiredMillis);
        return this;
    }

    public PurchaseOrderRequest<T> appendSearchCriteria(SearchCriteria searchCriteria){
        return (PurchaseOrderRequest<T>)super.appendSearchCriteria(searchCriteria);
    }

    public PurchaseOrderRequest<T> filter(String property1, Operator operator, String property2){
        return appendSearchCriteria(new TwoOperatorCriteria(operator, new PropertyReference(property1), new PropertyReference(property2)));
    }


    public PurchaseOrderRequest<T> matchingAnyOf(PurchaseOrderRequest purchaseOrder){
        super.internalMatchAny(purchaseOrder);
        return this;
    }

    public PurchaseOrderRequest<T> enhanceChildrenIfNeeded(){
        return this;
    }

    public PurchaseOrderRequest<T> withDeletedRows(){
        super.withDeletedRows();
        return this;
    }

    public PurchaseOrderRequest<T> deletedRowsOnly(){
        super.deletedRowsOnly();
        return this;
    }

    public PurchaseOrderRequest<T> selectSelf(){
        super.selectSelf();
        return selectId().selectOrderDate().selectStatus().selectSupplierIdOnly().selectTotalCost().selectCreateTime().selectUpdateTime().selectVersion();
    }

    public PurchaseOrderRequest<T> selectSelfFields(){
        return selectSelf();
    }

    public PurchaseOrderRequest<T> selectAll(){
        super.selectAll();
        return selectId().selectOrderDate().selectStatus().selectSupplier().selectTotalCost().selectCreateTime().selectUpdateTime().selectVersion();
    }

    public PurchaseOrderRequest<T> selectChildren(){
        super.selectAny();
        selectPurchaseOrderItemList();
        return selectId().selectOrderDate().selectStatus().selectSupplier().selectTotalCost().selectCreateTime().selectUpdateTime().selectVersion();
    }


    public PurchaseOrderRequest<T> selectId(){
       selectProperty(PurchaseOrder.ID_PROPERTY);
       return this;
    }

    /**
     * fill the id with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  id) to fetch id property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public PurchaseOrderRequest<T> unselectId(){
       unselectProperty(PurchaseOrder.ID_PROPERTY);
       return this;
    }
    public PurchaseOrderRequest<T> selectOrderDate(){
       selectProperty(PurchaseOrder.ORDER_DATE_PROPERTY);
       return this;
    }

    /**
     * fill the orderDate with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  orderDate) to fetch orderDate property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public PurchaseOrderRequest<T> unselectOrderDate(){
       unselectProperty(PurchaseOrder.ORDER_DATE_PROPERTY);
       return this;
    }
    public PurchaseOrderRequest<T> selectStatus(){
       selectProperty(PurchaseOrder.STATUS_PROPERTY);
       return this;
    }

    /**
     * fill the status with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  status) to fetch status property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public PurchaseOrderRequest<T> unselectStatus(){
       unselectProperty(PurchaseOrder.STATUS_PROPERTY);
       return this;
    }
    public PurchaseOrderRequest<T> selectSupplierIdOnly(){
       selectProperty(PurchaseOrder.SUPPLIER_PROPERTY);
       return this;
    }

    public PurchaseOrderRequest<T> selectSupplier(){
        return selectSupplierWith(Q.suppliers().unlimited().selectSelf());
    }

    public PurchaseOrderRequest<T> selectSupplierWith(SupplierRequest supplier){
       selectProperty(PurchaseOrder.SUPPLIER_PROPERTY);
       enhanceRelation(PurchaseOrder.SUPPLIER_PROPERTY, supplier);
       return this;
    }

    public PurchaseOrderRequest<T> unselectSupplier(){
       unselectProperty(PurchaseOrder.SUPPLIER_PROPERTY);
       return this;
    }
    public PurchaseOrderRequest<T> selectTotalCost(){
       selectProperty(PurchaseOrder.TOTAL_COST_PROPERTY);
       return this;
    }

    /**
     * fill the totalCost with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  totalCost) to fetch totalCost property.
     * @param rawSqlSegment  customized rawSqlSegment
     */


    /**
     * fill the totalCost with customized aggrFunction, TEAQL uses ({aggrFunction}(totalCost) AS totalCost to fetch totalCost property.
     * @param aggrFunction  aggrFunction
     */
    public PurchaseOrderRequest<T> selectTotalCost(AggrFunction aggrFunction){
       selectProperty(PurchaseOrder.TOTAL_COST_PROPERTY, aggrFunction);
       return this;
    }


    public PurchaseOrderRequest<T> unselectTotalCost(){
       unselectProperty(PurchaseOrder.TOTAL_COST_PROPERTY);
       return this;
    }
    public PurchaseOrderRequest<T> selectCreateTime(){
       selectProperty(PurchaseOrder.CREATE_TIME_PROPERTY);
       return this;
    }

    /**
     * fill the createTime with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  createTime) to fetch createTime property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public PurchaseOrderRequest<T> unselectCreateTime(){
       unselectProperty(PurchaseOrder.CREATE_TIME_PROPERTY);
       return this;
    }
    public PurchaseOrderRequest<T> selectUpdateTime(){
       selectProperty(PurchaseOrder.UPDATE_TIME_PROPERTY);
       return this;
    }

    /**
     * fill the updateTime with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  updateTime) to fetch updateTime property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public PurchaseOrderRequest<T> unselectUpdateTime(){
       unselectProperty(PurchaseOrder.UPDATE_TIME_PROPERTY);
       return this;
    }
    public PurchaseOrderRequest<T> selectVersion(){
       selectProperty(PurchaseOrder.VERSION_PROPERTY);
       return this;
    }

    /**
     * fill the version with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  version) to fetch version property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public PurchaseOrderRequest<T> unselectVersion(){
       unselectProperty(PurchaseOrder.VERSION_PROPERTY);
       return this;
    }
    public PurchaseOrderRequest<T> selectPurchaseOrderItemList(){
       return selectPurchaseOrderItemListWith(Q.purchaseOrderItems().selectSelf());
    }

    public PurchaseOrderRequest<T> selectPurchaseOrderItemListWith(PurchaseOrderItemRequest purchaseOrderItemList){
       enhanceRelation(PurchaseOrder.PURCHASE_ORDER_ITEM_LIST_PROPERTY, purchaseOrderItemList);
       return this;
    }

    public PurchaseOrderRequest<T> withId(Operator operator, Object... values){
       return appendSearchCriteria(createIdCriteria(operator, values));
    }

    public SearchCriteria createIdCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(PurchaseOrder.ID_PROPERTY, operator, values);
    }

    public PurchaseOrderRequest<T> withIdIs(Long id){
       return withId(Operator.EQUAL, id);
    }
    public PurchaseOrderRequest<T> withIdIn(Long... id){
       return withId(Operator.EQUAL, (Object[])id);
    }



    public PurchaseOrderRequest<T> filterByOrderDate(LocalDateTime... orderDate){
      if (orderDate == null || orderDate.length == 0) {
        throw new IllegalArgumentException("filterByOrderDate parameter orderDate cannot be empty");
      }
      return appendSearchCriteria(createOrderDateCriteria(Operator.EQUAL, (Object[])orderDate));
    }

    public PurchaseOrderRequest<T> withOrderDate(Operator operator, Object... values){
       return appendSearchCriteria(createOrderDateCriteria(operator, values));
    }

    public PurchaseOrderRequest<T> withOrderDateIsUnknown(){
       return withOrderDate(Operator.IS_NULL);
    }

    public PurchaseOrderRequest<T> withOrderDateIsKnown(){
       return withOrderDate(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createOrderDateCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(PurchaseOrder.ORDER_DATE_PROPERTY, operator, values);
    }

    public PurchaseOrderRequest<T> withOrderDateGreaterThan(LocalDateTime orderDate){
       return withOrderDate(Operator.GREATER_THAN, orderDate);
    }

    public PurchaseOrderRequest<T> withOrderDateGreaterThanOrEqualTo(LocalDateTime orderDate){
       return withOrderDate(Operator.GREATER_THAN_OR_EQUAL, orderDate);
    }

    public PurchaseOrderRequest<T> withOrderDateLessThan(LocalDateTime orderDate){
       return withOrderDate(Operator.LESS_THAN, orderDate);
    }

    public PurchaseOrderRequest<T> withOrderDateLessThanOrEqualTo(LocalDateTime orderDate){
       return withOrderDate(Operator.LESS_THAN_OR_EQUAL, orderDate);
    }

    public PurchaseOrderRequest<T> withOrderDateBetween(LocalDateTime startOfOrderDate, LocalDateTime endOfOrderDate){
       return withOrderDate(Operator.BETWEEN, startOfOrderDate, endOfOrderDate);
    }
    public PurchaseOrderRequest<T> withOrderDateBefore(LocalDateTime orderDate){
       return withOrderDate(Operator.LESS_THAN, orderDate);
    }

    public PurchaseOrderRequest<T> withOrderDateBefore(Date orderDate){
       return withOrderDate(Operator.LESS_THAN, orderDate);
    }

    public PurchaseOrderRequest<T> withOrderDateAfter(LocalDateTime orderDate){
       return withOrderDate(Operator.GREATER_THAN, orderDate);
    }

    public PurchaseOrderRequest<T> withOrderDateAfter(Date orderDate){
       return withOrderDate(Operator.GREATER_THAN, orderDate);
    }

    public PurchaseOrderRequest<T> withOrderDateBetween(Date startOfOrderDate, Date endOfOrderDate){
       return withOrderDate(Operator.BETWEEN, startOfOrderDate, endOfOrderDate);
    }




    public PurchaseOrderRequest<T> filterByStatus(String... status){
      if (status == null || status.length == 0) {
        throw new IllegalArgumentException("filterByStatus parameter status cannot be empty");
      }
      return appendSearchCriteria(createStatusCriteria(Operator.EQUAL, (Object[])status));
    }

    public PurchaseOrderRequest<T> withStatus(Operator operator, Object... values){
       return appendSearchCriteria(createStatusCriteria(operator, values));
    }

    public PurchaseOrderRequest<T> withStatusIsUnknown(){
       return withStatus(Operator.IS_NULL);
    }

    public PurchaseOrderRequest<T> withStatusIsKnown(){
       return withStatus(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createStatusCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(PurchaseOrder.STATUS_PROPERTY, operator, values);
    }

    public PurchaseOrderRequest<T> withStatusGreaterThan(String status){
       return withStatus(Operator.GREATER_THAN, status);
    }

    public PurchaseOrderRequest<T> withStatusGreaterThanOrEqualTo(String status){
       return withStatus(Operator.GREATER_THAN_OR_EQUAL, status);
    }

    public PurchaseOrderRequest<T> withStatusLessThan(String status){
       return withStatus(Operator.LESS_THAN, status);
    }

    public PurchaseOrderRequest<T> withStatusLessThanOrEqualTo(String status){
       return withStatus(Operator.LESS_THAN_OR_EQUAL, status);
    }

    public PurchaseOrderRequest<T> withStatusBetween(String startOfStatus, String endOfStatus){
       return withStatus(Operator.BETWEEN, startOfStatus, endOfStatus);
    }
    public PurchaseOrderRequest<T> withStatusStartingWith(String status){
       return withStatus(Operator.BEGIN_WITH, status);
    }
    public PurchaseOrderRequest<T> withStatusContaining(String status){
       return withStatus(Operator.CONTAIN, status);
    }

    public PurchaseOrderRequest<T> withStatusEndingWith(String status){
       return withStatus(Operator.END_WITH, status);
    }

    public PurchaseOrderRequest<T> withStatusIs(String status){
       return withStatus(Operator.EQUAL, status);
    }

    public PurchaseOrderRequest<T> withStatusSoundingLike(String status){
       return withStatus(Operator.SOUNDS_LIKE, status);
    }



    public PurchaseOrderRequest<T> filterBySupplier(Supplier... supplier){
      if (supplier == null || supplier.length == 0) {
        throw new IllegalArgumentException("filterBySupplier parameter supplier cannot be empty");
      }
      return appendSearchCriteria(createSupplierCriteria(Operator.EQUAL, (Object[])supplier));
    }

    public PurchaseOrderRequest<T> withSupplier(Operator operator, Object... values){
       return appendSearchCriteria(createSupplierCriteria(operator, values));
    }

    public PurchaseOrderRequest<T> withSupplierIsUnknown(){
       return withSupplier(Operator.IS_NULL);
    }

    public PurchaseOrderRequest<T> withSupplierIsKnown(){
       return withSupplier(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createSupplierCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(PurchaseOrder.SUPPLIER_PROPERTY, operator, values);
    }

    public PurchaseOrderRequest<T> filterBySupplier(Long supplier){
      if(supplier == null){
         return this;
      }
      return withSupplier(Operator.EQUAL, supplier);
    }
    public PurchaseOrderRequest<T> withSupplierMatching(SupplierRequest supplier){
       return appendSearchCriteria(new SubQuerySearchCriteria(PurchaseOrder.SUPPLIER_PROPERTY, supplier, Supplier.ID_PROPERTY));
    }

    public PurchaseOrderRequest<T> filterByTotalCost(BigDecimal... totalCost){
      if (totalCost == null || totalCost.length == 0) {
        throw new IllegalArgumentException("filterByTotalCost parameter totalCost cannot be empty");
      }
      return appendSearchCriteria(createTotalCostCriteria(Operator.EQUAL, (Object[])totalCost));
    }

    public PurchaseOrderRequest<T> withTotalCost(Operator operator, Object... values){
       return appendSearchCriteria(createTotalCostCriteria(operator, values));
    }

    public PurchaseOrderRequest<T> withTotalCostIsUnknown(){
       return withTotalCost(Operator.IS_NULL);
    }

    public PurchaseOrderRequest<T> withTotalCostIsKnown(){
       return withTotalCost(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createTotalCostCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(PurchaseOrder.TOTAL_COST_PROPERTY, operator, values);
    }

    public PurchaseOrderRequest<T> withTotalCostGreaterThan(BigDecimal totalCost){
       return withTotalCost(Operator.GREATER_THAN, totalCost);
    }

    public PurchaseOrderRequest<T> withTotalCostGreaterThanOrEqualTo(BigDecimal totalCost){
       return withTotalCost(Operator.GREATER_THAN_OR_EQUAL, totalCost);
    }

    public PurchaseOrderRequest<T> withTotalCostLessThan(BigDecimal totalCost){
       return withTotalCost(Operator.LESS_THAN, totalCost);
    }

    public PurchaseOrderRequest<T> withTotalCostLessThanOrEqualTo(BigDecimal totalCost){
       return withTotalCost(Operator.LESS_THAN_OR_EQUAL, totalCost);
    }

    public PurchaseOrderRequest<T> withTotalCostBetween(BigDecimal startOfTotalCost, BigDecimal endOfTotalCost){
       return withTotalCost(Operator.BETWEEN, startOfTotalCost, endOfTotalCost);
    }



    public PurchaseOrderRequest<T> filterByCreateTime(LocalDateTime... createTime){
      if (createTime == null || createTime.length == 0) {
        throw new IllegalArgumentException("filterByCreateTime parameter createTime cannot be empty");
      }
      return appendSearchCriteria(createCreateTimeCriteria(Operator.EQUAL, (Object[])createTime));
    }

    public PurchaseOrderRequest<T> withCreateTime(Operator operator, Object... values){
       return appendSearchCriteria(createCreateTimeCriteria(operator, values));
    }

    public PurchaseOrderRequest<T> withCreateTimeIsUnknown(){
       return withCreateTime(Operator.IS_NULL);
    }

    public PurchaseOrderRequest<T> withCreateTimeIsKnown(){
       return withCreateTime(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createCreateTimeCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(PurchaseOrder.CREATE_TIME_PROPERTY, operator, values);
    }

    public PurchaseOrderRequest<T> withCreateTimeGreaterThan(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public PurchaseOrderRequest<T> withCreateTimeGreaterThanOrEqualTo(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN_OR_EQUAL, createTime);
    }

    public PurchaseOrderRequest<T> withCreateTimeLessThan(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public PurchaseOrderRequest<T> withCreateTimeLessThanOrEqualTo(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN_OR_EQUAL, createTime);
    }

    public PurchaseOrderRequest<T> withCreateTimeBetween(LocalDateTime startOfCreateTime, LocalDateTime endOfCreateTime){
       return withCreateTime(Operator.BETWEEN, startOfCreateTime, endOfCreateTime);
    }
    public PurchaseOrderRequest<T> withCreateTimeBefore(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public PurchaseOrderRequest<T> withCreateTimeBefore(Date createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public PurchaseOrderRequest<T> withCreateTimeAfter(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public PurchaseOrderRequest<T> withCreateTimeAfter(Date createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public PurchaseOrderRequest<T> withCreateTimeBetween(Date startOfCreateTime, Date endOfCreateTime){
       return withCreateTime(Operator.BETWEEN, startOfCreateTime, endOfCreateTime);
    }




    public PurchaseOrderRequest<T> filterByUpdateTime(LocalDateTime... updateTime){
      if (updateTime == null || updateTime.length == 0) {
        throw new IllegalArgumentException("filterByUpdateTime parameter updateTime cannot be empty");
      }
      return appendSearchCriteria(createUpdateTimeCriteria(Operator.EQUAL, (Object[])updateTime));
    }

    public PurchaseOrderRequest<T> withUpdateTime(Operator operator, Object... values){
       return appendSearchCriteria(createUpdateTimeCriteria(operator, values));
    }

    public PurchaseOrderRequest<T> withUpdateTimeIsUnknown(){
       return withUpdateTime(Operator.IS_NULL);
    }

    public PurchaseOrderRequest<T> withUpdateTimeIsKnown(){
       return withUpdateTime(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createUpdateTimeCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(PurchaseOrder.UPDATE_TIME_PROPERTY, operator, values);
    }

    public PurchaseOrderRequest<T> withUpdateTimeGreaterThan(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public PurchaseOrderRequest<T> withUpdateTimeGreaterThanOrEqualTo(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN_OR_EQUAL, updateTime);
    }

    public PurchaseOrderRequest<T> withUpdateTimeLessThan(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public PurchaseOrderRequest<T> withUpdateTimeLessThanOrEqualTo(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN_OR_EQUAL, updateTime);
    }

    public PurchaseOrderRequest<T> withUpdateTimeBetween(LocalDateTime startOfUpdateTime, LocalDateTime endOfUpdateTime){
       return withUpdateTime(Operator.BETWEEN, startOfUpdateTime, endOfUpdateTime);
    }
    public PurchaseOrderRequest<T> withUpdateTimeBefore(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public PurchaseOrderRequest<T> withUpdateTimeBefore(Date updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public PurchaseOrderRequest<T> withUpdateTimeAfter(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public PurchaseOrderRequest<T> withUpdateTimeAfter(Date updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public PurchaseOrderRequest<T> withUpdateTimeBetween(Date startOfUpdateTime, Date endOfUpdateTime){
       return withUpdateTime(Operator.BETWEEN, startOfUpdateTime, endOfUpdateTime);
    }




    public PurchaseOrderRequest<T> filterByVersion(Long... version){
      if (version == null || version.length == 0) {
        throw new IllegalArgumentException("filterByVersion parameter version cannot be empty");
      }
      return appendSearchCriteria(createVersionCriteria(Operator.EQUAL, (Object[])version));
    }

    public PurchaseOrderRequest<T> withVersion(Operator operator, Object... values){
       return appendSearchCriteria(createVersionCriteria(operator, values));
    }

    public PurchaseOrderRequest<T> withVersionIsUnknown(){
       return withVersion(Operator.IS_NULL);
    }

    public PurchaseOrderRequest<T> withVersionIsKnown(){
       return withVersion(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createVersionCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(PurchaseOrder.VERSION_PROPERTY, operator, values);
    }

    public PurchaseOrderRequest<T> withVersionGreaterThan(Long version){
       return withVersion(Operator.GREATER_THAN, version);
    }

    public PurchaseOrderRequest<T> withVersionGreaterThanOrEqualTo(Long version){
       return withVersion(Operator.GREATER_THAN_OR_EQUAL, version);
    }

    public PurchaseOrderRequest<T> withVersionLessThan(Long version){
       return withVersion(Operator.LESS_THAN, version);
    }

    public PurchaseOrderRequest<T> withVersionLessThanOrEqualTo(Long version){
       return withVersion(Operator.LESS_THAN_OR_EQUAL, version);
    }

    public PurchaseOrderRequest<T> withVersionBetween(Long startOfVersion, Long endOfVersion){
       return withVersion(Operator.BETWEEN, startOfVersion, endOfVersion);
    }

    public PurchaseOrderRequest<T> withPurchaseOrderItemListMatching(PurchaseOrderItemRequest purchaseOrderItemRequest){
        return appendSearchCriteria(new SubQuerySearchCriteria(PurchaseOrder.ID_PROPERTY, purchaseOrderItemRequest, PurchaseOrderItem.PURCHASE_ORDER_PROPERTY));
    }

    public PurchaseOrderRequest<T> withoutPurchaseOrderItemListMatching(PurchaseOrderItemRequest purchaseOrderItemRequest){
        return appendSearchCriteria(SearchCriteria.not(new SubQuerySearchCriteria(PurchaseOrder.ID_PROPERTY, purchaseOrderItemRequest, PurchaseOrderItem.PURCHASE_ORDER_PROPERTY)));
    }

    public PurchaseOrderRequest<T> havePurchaseOrderItems(){
        return withPurchaseOrderItemListMatching(Q.purchaseOrderItems().unlimited());
    }

    public PurchaseOrderRequest<T> haveNoPurchaseOrderItems(){
        return withoutPurchaseOrderItemListMatching(Q.purchaseOrderItems().unlimited());
    }

    public PurchaseOrderRequest<T> count(){
        super.count();
        return this;
    }
    public PurchaseOrderRequest<T> countAs(String retName){
        super.count(retName);
        return this;
    }
    public PurchaseOrderRequest minTotalCost(){
        return minTotalCostAs(prefix("minOf",PurchaseOrder.TOTAL_COST_PROPERTY));
    }

    public PurchaseOrderRequest minTotalCostAs(String retName){
        super.min(retName, PurchaseOrder.TOTAL_COST_PROPERTY);
        return this;
    }
    public PurchaseOrderRequest maxTotalCost(){
        return maxTotalCostAs(prefix("maxOf",PurchaseOrder.TOTAL_COST_PROPERTY));
    }

    public PurchaseOrderRequest maxTotalCostAs(String retName){
        super.max(retName, PurchaseOrder.TOTAL_COST_PROPERTY);
        return this;
    }
    public PurchaseOrderRequest sumTotalCost(){
        return sumTotalCostAs(prefix("sumOf",PurchaseOrder.TOTAL_COST_PROPERTY));
    }

    public PurchaseOrderRequest sumTotalCostAs(String retName){
        super.sum(retName, PurchaseOrder.TOTAL_COST_PROPERTY);
        return this;
    }
    public PurchaseOrderRequest avgTotalCost(){
        return avgTotalCostAs(prefix("avgOf",PurchaseOrder.TOTAL_COST_PROPERTY));
    }

    public PurchaseOrderRequest avgTotalCostAs(String retName){
        super.avg(retName, PurchaseOrder.TOTAL_COST_PROPERTY);
        return this;
    }
    public PurchaseOrderRequest standardDeviationTotalCost(){
        return standardDeviationTotalCostAs(prefix("standardDeviationOf",PurchaseOrder.TOTAL_COST_PROPERTY));
    }

    public PurchaseOrderRequest standardDeviationTotalCostAs(String retName){
        super.standardDeviation(retName, PurchaseOrder.TOTAL_COST_PROPERTY);
        return this;
    }
    public PurchaseOrderRequest squareRootOfPopulationStandardDeviationTotalCost(){
        return squareRootOfPopulationStandardDeviationTotalCostAs(prefix("squareRootOfPopulationStandardDeviationOf",PurchaseOrder.TOTAL_COST_PROPERTY));
    }

    public PurchaseOrderRequest squareRootOfPopulationStandardDeviationTotalCostAs(String retName){
        super.squareRootOfPopulationStandardDeviation(retName, PurchaseOrder.TOTAL_COST_PROPERTY);
        return this;
    }
    public PurchaseOrderRequest sampleVarianceTotalCost(){
        return sampleVarianceTotalCostAs(prefix("sampleVarianceOf",PurchaseOrder.TOTAL_COST_PROPERTY));
    }

    public PurchaseOrderRequest sampleVarianceTotalCostAs(String retName){
        super.sampleVariance(retName, PurchaseOrder.TOTAL_COST_PROPERTY);
        return this;
    }
    public PurchaseOrderRequest samplePopulationVarianceTotalCost(){
        return samplePopulationVarianceTotalCostAs(prefix("samplePopulationVarianceOf",PurchaseOrder.TOTAL_COST_PROPERTY));
    }

    public PurchaseOrderRequest samplePopulationVarianceTotalCostAs(String retName){
        super.samplePopulationVariance(retName, PurchaseOrder.TOTAL_COST_PROPERTY);
        return this;
    }
    public PurchaseOrderRequest<T> groupBySupplierWithDetails(){
       return groupBySupplierWithDetails(Q.suppliers().unlimited());
    }

    public PurchaseOrderRequest<T> groupBySupplierWithDetails(SupplierRequest subRequest){
       aggregate(PurchaseOrder.SUPPLIER_PROPERTY, subRequest);
       return this;
    }





    public PurchaseOrderRequest<T> groupByPurchaseOrderItemsWithDetails(PurchaseOrderItemRequest subRequest){
       aggregate(PurchaseOrder.PURCHASE_ORDER_ITEM_LIST_PROPERTY, subRequest);
       return this;
    }

    public PurchaseOrderRequest<T> groupById(){
       groupBy(PurchaseOrder.ID_PROPERTY);
       return this;
    }

    public PurchaseOrderRequest<T> groupByIdAs(String retName){
       groupBy(retName, PurchaseOrder.ID_PROPERTY);
       return this;
    }

    public PurchaseOrderRequest<T> groupByIdWithFunction(String retName, AggrFunction function){
       groupBy(retName, PurchaseOrder.ID_PROPERTY, function);
       return this;
    }

    public PurchaseOrderRequest<T> groupByOrderDate(){
       groupBy(PurchaseOrder.ORDER_DATE_PROPERTY);
       return this;
    }

    public PurchaseOrderRequest<T> groupByOrderDateAs(String retName){
       groupBy(retName, PurchaseOrder.ORDER_DATE_PROPERTY);
       return this;
    }

    public PurchaseOrderRequest<T> groupByOrderDateWithFunction(String retName, AggrFunction function){
       groupBy(retName, PurchaseOrder.ORDER_DATE_PROPERTY, function);
       return this;
    }

    public PurchaseOrderRequest<T> groupByStatus(){
       groupBy(PurchaseOrder.STATUS_PROPERTY);
       return this;
    }

    public PurchaseOrderRequest<T> groupByStatusAs(String retName){
       groupBy(retName, PurchaseOrder.STATUS_PROPERTY);
       return this;
    }

    public PurchaseOrderRequest<T> groupByStatusWithFunction(String retName, AggrFunction function){
       groupBy(retName, PurchaseOrder.STATUS_PROPERTY, function);
       return this;
    }
    public PurchaseOrderRequest<T> groupBySupplierWith(SupplierRequest subRequest){
       groupBy(PurchaseOrder.SUPPLIER_PROPERTY, subRequest);
       return this;
    }
    public PurchaseOrderRequest<T> groupBySupplier(){
       groupBy(PurchaseOrder.SUPPLIER_PROPERTY);
       return this;
    }

    public PurchaseOrderRequest<T> groupBySupplierAs(String retName){
       groupBy(retName, PurchaseOrder.SUPPLIER_PROPERTY);
       return this;
    }

    public PurchaseOrderRequest<T> groupBySupplierWithFunction(String retName, AggrFunction function){
       groupBy(retName, PurchaseOrder.SUPPLIER_PROPERTY, function);
       return this;
    }

    public PurchaseOrderRequest<T> groupByTotalCost(){
       groupBy(PurchaseOrder.TOTAL_COST_PROPERTY);
       return this;
    }

    public PurchaseOrderRequest<T> groupByTotalCostAs(String retName){
       groupBy(retName, PurchaseOrder.TOTAL_COST_PROPERTY);
       return this;
    }

    public PurchaseOrderRequest<T> groupByTotalCostWithFunction(String retName, AggrFunction function){
       groupBy(retName, PurchaseOrder.TOTAL_COST_PROPERTY, function);
       return this;
    }

    public PurchaseOrderRequest<T> groupByCreateTime(){
       groupBy(PurchaseOrder.CREATE_TIME_PROPERTY);
       return this;
    }

    public PurchaseOrderRequest<T> groupByCreateTimeAs(String retName){
       groupBy(retName, PurchaseOrder.CREATE_TIME_PROPERTY);
       return this;
    }

    public PurchaseOrderRequest<T> groupByCreateTimeWithFunction(String retName, AggrFunction function){
       groupBy(retName, PurchaseOrder.CREATE_TIME_PROPERTY, function);
       return this;
    }

    public PurchaseOrderRequest<T> groupByUpdateTime(){
       groupBy(PurchaseOrder.UPDATE_TIME_PROPERTY);
       return this;
    }

    public PurchaseOrderRequest<T> groupByUpdateTimeAs(String retName){
       groupBy(retName, PurchaseOrder.UPDATE_TIME_PROPERTY);
       return this;
    }

    public PurchaseOrderRequest<T> groupByUpdateTimeWithFunction(String retName, AggrFunction function){
       groupBy(retName, PurchaseOrder.UPDATE_TIME_PROPERTY, function);
       return this;
    }

    public PurchaseOrderRequest<T> groupByVersion(){
       groupBy(PurchaseOrder.VERSION_PROPERTY);
       return this;
    }

    public PurchaseOrderRequest<T> groupByVersionAs(String retName){
       groupBy(retName, PurchaseOrder.VERSION_PROPERTY);
       return this;
    }

    public PurchaseOrderRequest<T> groupByVersionWithFunction(String retName, AggrFunction function){
       groupBy(retName, PurchaseOrder.VERSION_PROPERTY, function);
       return this;
    }



    public PurchaseOrderRequest<T> orderByIdAscending(){
       addOrderByAscending(PurchaseOrder.ID_PROPERTY);
       return this;
    }

    public PurchaseOrderRequest<T> orderByIdDescending(){
       addOrderByDescending(PurchaseOrder.ID_PROPERTY);
       return this;
    }

    public PurchaseOrderRequest<T> orderByOrderDateAscending(){
       addOrderByAscending(PurchaseOrder.ORDER_DATE_PROPERTY);
       return this;
    }

    public PurchaseOrderRequest<T> orderByOrderDateDescending(){
       addOrderByDescending(PurchaseOrder.ORDER_DATE_PROPERTY);
       return this;
    }

    public PurchaseOrderRequest<T> orderByStatusAscending(){
       addOrderByAscending(PurchaseOrder.STATUS_PROPERTY);
       return this;
    }

    public PurchaseOrderRequest<T> orderByStatusDescending(){
       addOrderByDescending(PurchaseOrder.STATUS_PROPERTY);
       return this;
    }
    public PurchaseOrderRequest<T> orderByStatusAscendingUsingGBK(){
       addOrderByAscendingUsingGBK(PurchaseOrder.STATUS_PROPERTY);
       return this;
    }

    public PurchaseOrderRequest<T> orderByStatusDescendingUsingGBK(){
       addOrderByDescendingUsingGBK(PurchaseOrder.STATUS_PROPERTY);
       return this;
    }
    public PurchaseOrderRequest<T> orderBySupplierAscending(){
       addOrderByAscending(PurchaseOrder.SUPPLIER_PROPERTY);
       return this;
    }

    public PurchaseOrderRequest<T> orderBySupplierDescending(){
       addOrderByDescending(PurchaseOrder.SUPPLIER_PROPERTY);
       return this;
    }

    public PurchaseOrderRequest<T> orderByTotalCostAscending(){
       addOrderByAscending(PurchaseOrder.TOTAL_COST_PROPERTY);
       return this;
    }

    public PurchaseOrderRequest<T> orderByTotalCostDescending(){
       addOrderByDescending(PurchaseOrder.TOTAL_COST_PROPERTY);
       return this;
    }

    public PurchaseOrderRequest<T> orderByCreateTimeAscending(){
       addOrderByAscending(PurchaseOrder.CREATE_TIME_PROPERTY);
       return this;
    }

    public PurchaseOrderRequest<T> orderByCreateTimeDescending(){
       addOrderByDescending(PurchaseOrder.CREATE_TIME_PROPERTY);
       return this;
    }

    public PurchaseOrderRequest<T> orderByUpdateTimeAscending(){
       addOrderByAscending(PurchaseOrder.UPDATE_TIME_PROPERTY);
       return this;
    }

    public PurchaseOrderRequest<T> orderByUpdateTimeDescending(){
       addOrderByDescending(PurchaseOrder.UPDATE_TIME_PROPERTY);
       return this;
    }

    public PurchaseOrderRequest<T> orderByVersionAscending(){
       addOrderByAscending(PurchaseOrder.VERSION_PROPERTY);
       return this;
    }

    public PurchaseOrderRequest<T> orderByVersionDescending(){
       addOrderByDescending(PurchaseOrder.VERSION_PROPERTY);
       return this;
    }


    public PurchaseOrderRequest<T> statsFromPurchaseOrderItemsAs(String name, PurchaseOrderItemRequest subRequest){
       return statsFromPurchaseOrderItemsAs(name, subRequest, false);
    }

    public PurchaseOrderRequest<T> statsFromPurchaseOrderItemsAs(String name, PurchaseOrderItemRequest subRequest, boolean singleResult){
       subRequest.setPartitionProperty(PurchaseOrderItem.PURCHASE_ORDER_PROPERTY);
       addAggregateDynamicProperty(name, subRequest, singleResult);
       return this;
    }

    public PurchaseOrderRequest<T> statsFromPurchaseOrderItems(PurchaseOrderItemRequest subRequest){
       return statsFromPurchaseOrderItemsAs(REFINEMENTS, subRequest);
    }
    public SupplierRequest rollUpToSupplier(){
       SupplierRequest supplier = Q.suppliers().unlimited();
       this.withSupplierMatching(supplier)
           .groupBySupplierWith(supplier);
       return supplier;
    }





    public PurchaseOrderRequest<T> countPurchaseOrderItems(){
        return countPurchaseOrderItemsAs("Count");
    }

    public PurchaseOrderRequest<T> countPurchaseOrderItemsAs(String name){
        return countPurchaseOrderItemsWith(name, Q.purchaseOrderItems().unlimited());
    }

    public PurchaseOrderRequest<T> countPurchaseOrderItemsWith(String name, PurchaseOrderItemRequest subRequest){
        return statsFromPurchaseOrderItemsAs(name, subRequest.count(), true);
    }
    public PurchaseOrderRequest<T> minQuantityOfPurchaseOrderItems(){
        return minQuantityOfPurchaseOrderItemsAs("minQuantityOfPurchaseOrderItems");
    }

    public PurchaseOrderRequest<T> minQuantityOfPurchaseOrderItemsAs(String name){
        return minQuantityOfPurchaseOrderItemsAs(name, Q.purchaseOrderItems().unlimited());
    }

    public PurchaseOrderRequest<T> minQuantityOfPurchaseOrderItemsAs(String name, PurchaseOrderItemRequest subRequest){
        return statsFromPurchaseOrderItemsAs(name, subRequest.minQuantity(), true);
    }
    public PurchaseOrderRequest<T> maxQuantityOfPurchaseOrderItems(){
        return maxQuantityOfPurchaseOrderItemsAs("maxQuantityOfPurchaseOrderItems");
    }

    public PurchaseOrderRequest<T> maxQuantityOfPurchaseOrderItemsAs(String name){
        return maxQuantityOfPurchaseOrderItemsAs(name, Q.purchaseOrderItems().unlimited());
    }

    public PurchaseOrderRequest<T> maxQuantityOfPurchaseOrderItemsAs(String name, PurchaseOrderItemRequest subRequest){
        return statsFromPurchaseOrderItemsAs(name, subRequest.maxQuantity(), true);
    }
    public PurchaseOrderRequest<T> sumQuantityOfPurchaseOrderItems(){
        return sumQuantityOfPurchaseOrderItemsAs("sumQuantityOfPurchaseOrderItems");
    }

    public PurchaseOrderRequest<T> sumQuantityOfPurchaseOrderItemsAs(String name){
        return sumQuantityOfPurchaseOrderItemsAs(name, Q.purchaseOrderItems().unlimited());
    }

    public PurchaseOrderRequest<T> sumQuantityOfPurchaseOrderItemsAs(String name, PurchaseOrderItemRequest subRequest){
        return statsFromPurchaseOrderItemsAs(name, subRequest.sumQuantity(), true);
    }
    public PurchaseOrderRequest<T> avgQuantityOfPurchaseOrderItems(){
        return avgQuantityOfPurchaseOrderItemsAs("avgQuantityOfPurchaseOrderItems");
    }

    public PurchaseOrderRequest<T> avgQuantityOfPurchaseOrderItemsAs(String name){
        return avgQuantityOfPurchaseOrderItemsAs(name, Q.purchaseOrderItems().unlimited());
    }

    public PurchaseOrderRequest<T> avgQuantityOfPurchaseOrderItemsAs(String name, PurchaseOrderItemRequest subRequest){
        return statsFromPurchaseOrderItemsAs(name, subRequest.avgQuantity(), true);
    }
    public PurchaseOrderRequest<T> standardDeviationQuantityOfPurchaseOrderItems(){
        return standardDeviationQuantityOfPurchaseOrderItemsAs("stdDevQuantityOfPurchaseOrderItems");
    }

    public PurchaseOrderRequest<T> standardDeviationQuantityOfPurchaseOrderItemsAs(String name){
        return standardDeviationQuantityOfPurchaseOrderItemsAs(name, Q.purchaseOrderItems().unlimited());
    }

    public PurchaseOrderRequest<T> standardDeviationQuantityOfPurchaseOrderItemsAs(String name, PurchaseOrderItemRequest subRequest){
        return statsFromPurchaseOrderItemsAs(name, subRequest.standardDeviationQuantity(), true);
    }
    public PurchaseOrderRequest<T> squareRootOfPopulationStandardDeviationQuantityOfPurchaseOrderItems(){
        return squareRootOfPopulationStandardDeviationQuantityOfPurchaseOrderItemsAs("stdDevPopQuantityOfPurchaseOrderItems");
    }

    public PurchaseOrderRequest<T> squareRootOfPopulationStandardDeviationQuantityOfPurchaseOrderItemsAs(String name){
        return squareRootOfPopulationStandardDeviationQuantityOfPurchaseOrderItemsAs(name, Q.purchaseOrderItems().unlimited());
    }

    public PurchaseOrderRequest<T> squareRootOfPopulationStandardDeviationQuantityOfPurchaseOrderItemsAs(String name, PurchaseOrderItemRequest subRequest){
        return statsFromPurchaseOrderItemsAs(name, subRequest.squareRootOfPopulationStandardDeviationQuantity(), true);
    }
    public PurchaseOrderRequest<T> sampleVarianceQuantityOfPurchaseOrderItems(){
        return sampleVarianceQuantityOfPurchaseOrderItemsAs("varSampQuantityOfPurchaseOrderItems");
    }

    public PurchaseOrderRequest<T> sampleVarianceQuantityOfPurchaseOrderItemsAs(String name){
        return sampleVarianceQuantityOfPurchaseOrderItemsAs(name, Q.purchaseOrderItems().unlimited());
    }

    public PurchaseOrderRequest<T> sampleVarianceQuantityOfPurchaseOrderItemsAs(String name, PurchaseOrderItemRequest subRequest){
        return statsFromPurchaseOrderItemsAs(name, subRequest.sampleVarianceQuantity(), true);
    }
    public PurchaseOrderRequest<T> samplePopulationVarianceQuantityOfPurchaseOrderItems(){
        return samplePopulationVarianceQuantityOfPurchaseOrderItemsAs("varPopQuantityOfPurchaseOrderItems");
    }

    public PurchaseOrderRequest<T> samplePopulationVarianceQuantityOfPurchaseOrderItemsAs(String name){
        return samplePopulationVarianceQuantityOfPurchaseOrderItemsAs(name, Q.purchaseOrderItems().unlimited());
    }

    public PurchaseOrderRequest<T> samplePopulationVarianceQuantityOfPurchaseOrderItemsAs(String name, PurchaseOrderItemRequest subRequest){
        return statsFromPurchaseOrderItemsAs(name, subRequest.samplePopulationVarianceQuantity(), true);
    }
    public PurchaseOrderRequest<T> minUnitCostOfPurchaseOrderItems(){
        return minUnitCostOfPurchaseOrderItemsAs("minUnitCostOfPurchaseOrderItems");
    }

    public PurchaseOrderRequest<T> minUnitCostOfPurchaseOrderItemsAs(String name){
        return minUnitCostOfPurchaseOrderItemsAs(name, Q.purchaseOrderItems().unlimited());
    }

    public PurchaseOrderRequest<T> minUnitCostOfPurchaseOrderItemsAs(String name, PurchaseOrderItemRequest subRequest){
        return statsFromPurchaseOrderItemsAs(name, subRequest.minUnitCost(), true);
    }
    public PurchaseOrderRequest<T> maxUnitCostOfPurchaseOrderItems(){
        return maxUnitCostOfPurchaseOrderItemsAs("maxUnitCostOfPurchaseOrderItems");
    }

    public PurchaseOrderRequest<T> maxUnitCostOfPurchaseOrderItemsAs(String name){
        return maxUnitCostOfPurchaseOrderItemsAs(name, Q.purchaseOrderItems().unlimited());
    }

    public PurchaseOrderRequest<T> maxUnitCostOfPurchaseOrderItemsAs(String name, PurchaseOrderItemRequest subRequest){
        return statsFromPurchaseOrderItemsAs(name, subRequest.maxUnitCost(), true);
    }
    public PurchaseOrderRequest<T> sumUnitCostOfPurchaseOrderItems(){
        return sumUnitCostOfPurchaseOrderItemsAs("sumUnitCostOfPurchaseOrderItems");
    }

    public PurchaseOrderRequest<T> sumUnitCostOfPurchaseOrderItemsAs(String name){
        return sumUnitCostOfPurchaseOrderItemsAs(name, Q.purchaseOrderItems().unlimited());
    }

    public PurchaseOrderRequest<T> sumUnitCostOfPurchaseOrderItemsAs(String name, PurchaseOrderItemRequest subRequest){
        return statsFromPurchaseOrderItemsAs(name, subRequest.sumUnitCost(), true);
    }
    public PurchaseOrderRequest<T> avgUnitCostOfPurchaseOrderItems(){
        return avgUnitCostOfPurchaseOrderItemsAs("avgUnitCostOfPurchaseOrderItems");
    }

    public PurchaseOrderRequest<T> avgUnitCostOfPurchaseOrderItemsAs(String name){
        return avgUnitCostOfPurchaseOrderItemsAs(name, Q.purchaseOrderItems().unlimited());
    }

    public PurchaseOrderRequest<T> avgUnitCostOfPurchaseOrderItemsAs(String name, PurchaseOrderItemRequest subRequest){
        return statsFromPurchaseOrderItemsAs(name, subRequest.avgUnitCost(), true);
    }
    public PurchaseOrderRequest<T> standardDeviationUnitCostOfPurchaseOrderItems(){
        return standardDeviationUnitCostOfPurchaseOrderItemsAs("stdDevUnitCostOfPurchaseOrderItems");
    }

    public PurchaseOrderRequest<T> standardDeviationUnitCostOfPurchaseOrderItemsAs(String name){
        return standardDeviationUnitCostOfPurchaseOrderItemsAs(name, Q.purchaseOrderItems().unlimited());
    }

    public PurchaseOrderRequest<T> standardDeviationUnitCostOfPurchaseOrderItemsAs(String name, PurchaseOrderItemRequest subRequest){
        return statsFromPurchaseOrderItemsAs(name, subRequest.standardDeviationUnitCost(), true);
    }
    public PurchaseOrderRequest<T> squareRootOfPopulationStandardDeviationUnitCostOfPurchaseOrderItems(){
        return squareRootOfPopulationStandardDeviationUnitCostOfPurchaseOrderItemsAs("stdDevPopUnitCostOfPurchaseOrderItems");
    }

    public PurchaseOrderRequest<T> squareRootOfPopulationStandardDeviationUnitCostOfPurchaseOrderItemsAs(String name){
        return squareRootOfPopulationStandardDeviationUnitCostOfPurchaseOrderItemsAs(name, Q.purchaseOrderItems().unlimited());
    }

    public PurchaseOrderRequest<T> squareRootOfPopulationStandardDeviationUnitCostOfPurchaseOrderItemsAs(String name, PurchaseOrderItemRequest subRequest){
        return statsFromPurchaseOrderItemsAs(name, subRequest.squareRootOfPopulationStandardDeviationUnitCost(), true);
    }
    public PurchaseOrderRequest<T> sampleVarianceUnitCostOfPurchaseOrderItems(){
        return sampleVarianceUnitCostOfPurchaseOrderItemsAs("varSampUnitCostOfPurchaseOrderItems");
    }

    public PurchaseOrderRequest<T> sampleVarianceUnitCostOfPurchaseOrderItemsAs(String name){
        return sampleVarianceUnitCostOfPurchaseOrderItemsAs(name, Q.purchaseOrderItems().unlimited());
    }

    public PurchaseOrderRequest<T> sampleVarianceUnitCostOfPurchaseOrderItemsAs(String name, PurchaseOrderItemRequest subRequest){
        return statsFromPurchaseOrderItemsAs(name, subRequest.sampleVarianceUnitCost(), true);
    }
    public PurchaseOrderRequest<T> samplePopulationVarianceUnitCostOfPurchaseOrderItems(){
        return samplePopulationVarianceUnitCostOfPurchaseOrderItemsAs("varPopUnitCostOfPurchaseOrderItems");
    }

    public PurchaseOrderRequest<T> samplePopulationVarianceUnitCostOfPurchaseOrderItemsAs(String name){
        return samplePopulationVarianceUnitCostOfPurchaseOrderItemsAs(name, Q.purchaseOrderItems().unlimited());
    }

    public PurchaseOrderRequest<T> samplePopulationVarianceUnitCostOfPurchaseOrderItemsAs(String name, PurchaseOrderItemRequest subRequest){
        return statsFromPurchaseOrderItemsAs(name, subRequest.samplePopulationVarianceUnitCost(), true);
    }

   public PurchaseOrderRequest<T> facetBySupplierAs(String facetName, SupplierRequest supplier){
       return facetBySupplierAs(facetName, supplier, true);
   }

   public PurchaseOrderRequest<T> facetBySupplierAs(String facetName, SupplierRequest supplier, boolean includeAllFacets){
       addFacet(facetName, PurchaseOrder.SUPPLIER_PROPERTY, supplier, includeAllFacets);
       return this;
   }


    /**
     * get topN records
     * @param topN  records number
     */
    public PurchaseOrderRequest<T> top(int topN) {
        super.top(topN);
        return this;
    }

    /**
     * get records from offset(inclusive) to offset+size(exclusive)
     * @param offset record offset
     * @param size records number
     */
    public PurchaseOrderRequest<T> offset(int offset, int size) {
        super.offset(offset, size);
        return this;
    }

    /**
     * retrieve all records
     */
    public PurchaseOrderRequest<T> unlimited() {
        super.unlimited();
        return this;
    }

    /**
     * get records of one page
     * @param pageNumber page number(1-based)
     * @param pageSize page size
     */
    public PurchaseOrderRequest<T> page(int pageNumber, int pageSize) {
        int offset = (pageNumber - 1) * pageSize;
        return offset(offset, pageSize);
   }

    /**
     * get records of one page, default page size is 10
     * @param pageNumber page number(1-based)
     */
    public PurchaseOrderRequest<T> page(int pageNumber) {
        return page(pageNumber, 10);
   }
}