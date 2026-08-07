
package com.example.enterpriseerpsystem.warehouse;

import com.example.enterpriseerpsystem.Q;
import com.example.enterpriseerpsystem.inventoryitem.InventoryItem;
import com.example.enterpriseerpsystem.inventoryitem.InventoryItemRequest;
import com.example.enterpriseerpsystem.shipment.Shipment;
import com.example.enterpriseerpsystem.shipment.ShipmentRequest;
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

public class WarehouseRequest<T extends Warehouse> extends BaseRequest<T> {

    /**
     * @deprecated AI agents and business code must use the generated Q facade
     *             instead of constructing request builders directly.
     */
    @Deprecated
    public WarehouseRequest(Class<T> returnType){
        super(returnType);
        selectId();
        selectVersion();
    }

    public WarehouseRequest<T> comment(String comment){
         super.internalComment(comment);
         return this;
    }

    // purpose() 继承自 BaseRequest，返回 ExecutableRequest（终结方法）

    public WarehouseRequest<T> returnType(Class<? extends T> returnType){
        super.setReturnType(returnType);
        return this;
    }

    public WarehouseRequest<T> enableAggregationCache(long cacheExpiredMillis){
        super.enableAggregationCache();
        super.aggregateCacheTime(cacheExpiredMillis);
        return this;
    }

    public WarehouseRequest<T> enableAggregationCache(){
        return enableAggregationCache(0l);
    }


    public WarehouseRequest<T> propagateAggregationCache(long cacheExpiredMillis){
        super.propagateAggregationCache(cacheExpiredMillis);
        return this;
    }

    public WarehouseRequest<T> appendSearchCriteria(SearchCriteria searchCriteria){
        return (WarehouseRequest<T>)super.appendSearchCriteria(searchCriteria);
    }

    public WarehouseRequest<T> filter(String property1, Operator operator, String property2){
        return appendSearchCriteria(new TwoOperatorCriteria(operator, new PropertyReference(property1), new PropertyReference(property2)));
    }


    public WarehouseRequest<T> matchingAnyOf(WarehouseRequest warehouse){
        super.internalMatchAny(warehouse);
        return this;
    }

    public WarehouseRequest<T> enhanceChildrenIfNeeded(){
        return this;
    }

    public WarehouseRequest<T> withDeletedRows(){
        super.withDeletedRows();
        return this;
    }

    public WarehouseRequest<T> deletedRowsOnly(){
        super.deletedRowsOnly();
        return this;
    }

    public WarehouseRequest<T> selectSelf(){
        super.selectSelf();
        return selectId().selectName().selectCapacity().selectLocation().selectManagerId().selectCreateTime().selectUpdateTime().selectVersion();
    }

    public WarehouseRequest<T> selectSelfFields(){
        return selectSelf();
    }

    public WarehouseRequest<T> selectAll(){
        super.selectAll();
        return selectId().selectName().selectCapacity().selectLocation().selectManagerId().selectCreateTime().selectUpdateTime().selectVersion();
    }

    public WarehouseRequest<T> selectChildren(){
        super.selectAny();
        selectInventoryItemList().selectShipmentList();
        return selectId().selectName().selectCapacity().selectLocation().selectManagerId().selectCreateTime().selectUpdateTime().selectVersion();
    }


    public WarehouseRequest<T> selectId(){
       selectProperty(Warehouse.ID_PROPERTY);
       return this;
    }

    /**
     * fill the id with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  id) to fetch id property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public WarehouseRequest<T> unselectId(){
       unselectProperty(Warehouse.ID_PROPERTY);
       return this;
    }
    public WarehouseRequest<T> selectName(){
       selectProperty(Warehouse.NAME_PROPERTY);
       return this;
    }

    /**
     * fill the name with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  name) to fetch name property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public WarehouseRequest<T> unselectName(){
       unselectProperty(Warehouse.NAME_PROPERTY);
       return this;
    }
    public WarehouseRequest<T> selectCapacity(){
       selectProperty(Warehouse.CAPACITY_PROPERTY);
       return this;
    }

    /**
     * fill the capacity with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  capacity) to fetch capacity property.
     * @param rawSqlSegment  customized rawSqlSegment
     */


    /**
     * fill the capacity with customized aggrFunction, TEAQL uses ({aggrFunction}(capacity) AS capacity to fetch capacity property.
     * @param aggrFunction  aggrFunction
     */
    public WarehouseRequest<T> selectCapacity(AggrFunction aggrFunction){
       selectProperty(Warehouse.CAPACITY_PROPERTY, aggrFunction);
       return this;
    }


    public WarehouseRequest<T> unselectCapacity(){
       unselectProperty(Warehouse.CAPACITY_PROPERTY);
       return this;
    }
    public WarehouseRequest<T> selectLocation(){
       selectProperty(Warehouse.LOCATION_PROPERTY);
       return this;
    }

    /**
     * fill the location with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  location) to fetch location property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public WarehouseRequest<T> unselectLocation(){
       unselectProperty(Warehouse.LOCATION_PROPERTY);
       return this;
    }
    public WarehouseRequest<T> selectManagerId(){
       selectProperty(Warehouse.MANAGER_ID_PROPERTY);
       return this;
    }

    /**
     * fill the managerId with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  managerId) to fetch managerId property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public WarehouseRequest<T> unselectManagerId(){
       unselectProperty(Warehouse.MANAGER_ID_PROPERTY);
       return this;
    }
    public WarehouseRequest<T> selectCreateTime(){
       selectProperty(Warehouse.CREATE_TIME_PROPERTY);
       return this;
    }

    /**
     * fill the createTime with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  createTime) to fetch createTime property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public WarehouseRequest<T> unselectCreateTime(){
       unselectProperty(Warehouse.CREATE_TIME_PROPERTY);
       return this;
    }
    public WarehouseRequest<T> selectUpdateTime(){
       selectProperty(Warehouse.UPDATE_TIME_PROPERTY);
       return this;
    }

    /**
     * fill the updateTime with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  updateTime) to fetch updateTime property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public WarehouseRequest<T> unselectUpdateTime(){
       unselectProperty(Warehouse.UPDATE_TIME_PROPERTY);
       return this;
    }
    public WarehouseRequest<T> selectVersion(){
       selectProperty(Warehouse.VERSION_PROPERTY);
       return this;
    }

    /**
     * fill the version with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  version) to fetch version property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public WarehouseRequest<T> unselectVersion(){
       unselectProperty(Warehouse.VERSION_PROPERTY);
       return this;
    }
    public WarehouseRequest<T> selectInventoryItemList(){
       return selectInventoryItemListWith(Q.inventoryItems().selectSelf());
    }

    public WarehouseRequest<T> selectInventoryItemListWith(InventoryItemRequest inventoryItemList){
       enhanceRelation(Warehouse.INVENTORY_ITEM_LIST_PROPERTY, inventoryItemList);
       return this;
    }
    public WarehouseRequest<T> selectShipmentList(){
       return selectShipmentListWith(Q.shipments().selectSelf());
    }

    public WarehouseRequest<T> selectShipmentListWith(ShipmentRequest shipmentList){
       enhanceRelation(Warehouse.SHIPMENT_LIST_PROPERTY, shipmentList);
       return this;
    }

    public WarehouseRequest<T> withId(Operator operator, Object... values){
       return appendSearchCriteria(createIdCriteria(operator, values));
    }

    public SearchCriteria createIdCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Warehouse.ID_PROPERTY, operator, values);
    }

    public WarehouseRequest<T> withIdIs(Long id){
       return withId(Operator.EQUAL, id);
    }
    public WarehouseRequest<T> withIdIn(Long... id){
       return withId(Operator.EQUAL, (Object[])id);
    }



    public WarehouseRequest<T> filterByName(String... name){
      if (name == null || name.length == 0) {
        throw new IllegalArgumentException("filterByName parameter name cannot be empty");
      }
      return appendSearchCriteria(createNameCriteria(Operator.EQUAL, (Object[])name));
    }

    public WarehouseRequest<T> withName(Operator operator, Object... values){
       return appendSearchCriteria(createNameCriteria(operator, values));
    }

    public WarehouseRequest<T> withNameIsUnknown(){
       return withName(Operator.IS_NULL);
    }

    public WarehouseRequest<T> withNameIsKnown(){
       return withName(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createNameCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Warehouse.NAME_PROPERTY, operator, values);
    }

    public WarehouseRequest<T> withNameGreaterThan(String name){
       return withName(Operator.GREATER_THAN, name);
    }

    public WarehouseRequest<T> withNameGreaterThanOrEqualTo(String name){
       return withName(Operator.GREATER_THAN_OR_EQUAL, name);
    }

    public WarehouseRequest<T> withNameLessThan(String name){
       return withName(Operator.LESS_THAN, name);
    }

    public WarehouseRequest<T> withNameLessThanOrEqualTo(String name){
       return withName(Operator.LESS_THAN_OR_EQUAL, name);
    }

    public WarehouseRequest<T> withNameBetween(String startOfName, String endOfName){
       return withName(Operator.BETWEEN, startOfName, endOfName);
    }
    public WarehouseRequest<T> withNameStartingWith(String name){
       return withName(Operator.BEGIN_WITH, name);
    }
    public WarehouseRequest<T> withNameContaining(String name){
       return withName(Operator.CONTAIN, name);
    }

    public WarehouseRequest<T> withNameEndingWith(String name){
       return withName(Operator.END_WITH, name);
    }

    public WarehouseRequest<T> withNameIs(String name){
       return withName(Operator.EQUAL, name);
    }

    public WarehouseRequest<T> withNameSoundingLike(String name){
       return withName(Operator.SOUNDS_LIKE, name);
    }



    public WarehouseRequest<T> filterByCapacity(BigDecimal... capacity){
      if (capacity == null || capacity.length == 0) {
        throw new IllegalArgumentException("filterByCapacity parameter capacity cannot be empty");
      }
      return appendSearchCriteria(createCapacityCriteria(Operator.EQUAL, (Object[])capacity));
    }

    public WarehouseRequest<T> withCapacity(Operator operator, Object... values){
       return appendSearchCriteria(createCapacityCriteria(operator, values));
    }

    public WarehouseRequest<T> withCapacityIsUnknown(){
       return withCapacity(Operator.IS_NULL);
    }

    public WarehouseRequest<T> withCapacityIsKnown(){
       return withCapacity(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createCapacityCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Warehouse.CAPACITY_PROPERTY, operator, values);
    }

    public WarehouseRequest<T> withCapacityGreaterThan(BigDecimal capacity){
       return withCapacity(Operator.GREATER_THAN, capacity);
    }

    public WarehouseRequest<T> withCapacityGreaterThanOrEqualTo(BigDecimal capacity){
       return withCapacity(Operator.GREATER_THAN_OR_EQUAL, capacity);
    }

    public WarehouseRequest<T> withCapacityLessThan(BigDecimal capacity){
       return withCapacity(Operator.LESS_THAN, capacity);
    }

    public WarehouseRequest<T> withCapacityLessThanOrEqualTo(BigDecimal capacity){
       return withCapacity(Operator.LESS_THAN_OR_EQUAL, capacity);
    }

    public WarehouseRequest<T> withCapacityBetween(BigDecimal startOfCapacity, BigDecimal endOfCapacity){
       return withCapacity(Operator.BETWEEN, startOfCapacity, endOfCapacity);
    }



    public WarehouseRequest<T> filterByLocation(String... location){
      if (location == null || location.length == 0) {
        throw new IllegalArgumentException("filterByLocation parameter location cannot be empty");
      }
      return appendSearchCriteria(createLocationCriteria(Operator.EQUAL, (Object[])location));
    }

    public WarehouseRequest<T> withLocation(Operator operator, Object... values){
       return appendSearchCriteria(createLocationCriteria(operator, values));
    }

    public WarehouseRequest<T> withLocationIsUnknown(){
       return withLocation(Operator.IS_NULL);
    }

    public WarehouseRequest<T> withLocationIsKnown(){
       return withLocation(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createLocationCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Warehouse.LOCATION_PROPERTY, operator, values);
    }

    public WarehouseRequest<T> withLocationGreaterThan(String location){
       return withLocation(Operator.GREATER_THAN, location);
    }

    public WarehouseRequest<T> withLocationGreaterThanOrEqualTo(String location){
       return withLocation(Operator.GREATER_THAN_OR_EQUAL, location);
    }

    public WarehouseRequest<T> withLocationLessThan(String location){
       return withLocation(Operator.LESS_THAN, location);
    }

    public WarehouseRequest<T> withLocationLessThanOrEqualTo(String location){
       return withLocation(Operator.LESS_THAN_OR_EQUAL, location);
    }

    public WarehouseRequest<T> withLocationBetween(String startOfLocation, String endOfLocation){
       return withLocation(Operator.BETWEEN, startOfLocation, endOfLocation);
    }
    public WarehouseRequest<T> withLocationStartingWith(String location){
       return withLocation(Operator.BEGIN_WITH, location);
    }
    public WarehouseRequest<T> withLocationContaining(String location){
       return withLocation(Operator.CONTAIN, location);
    }

    public WarehouseRequest<T> withLocationEndingWith(String location){
       return withLocation(Operator.END_WITH, location);
    }

    public WarehouseRequest<T> withLocationIs(String location){
       return withLocation(Operator.EQUAL, location);
    }

    public WarehouseRequest<T> withLocationSoundingLike(String location){
       return withLocation(Operator.SOUNDS_LIKE, location);
    }



    public WarehouseRequest<T> filterByManagerId(String... managerId){
      if (managerId == null || managerId.length == 0) {
        throw new IllegalArgumentException("filterByManagerId parameter managerId cannot be empty");
      }
      return appendSearchCriteria(createManagerIdCriteria(Operator.EQUAL, (Object[])managerId));
    }

    public WarehouseRequest<T> withManagerId(Operator operator, Object... values){
       return appendSearchCriteria(createManagerIdCriteria(operator, values));
    }

    public WarehouseRequest<T> withManagerIdIsUnknown(){
       return withManagerId(Operator.IS_NULL);
    }

    public WarehouseRequest<T> withManagerIdIsKnown(){
       return withManagerId(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createManagerIdCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Warehouse.MANAGER_ID_PROPERTY, operator, values);
    }

    public WarehouseRequest<T> withManagerIdGreaterThan(String managerId){
       return withManagerId(Operator.GREATER_THAN, managerId);
    }

    public WarehouseRequest<T> withManagerIdGreaterThanOrEqualTo(String managerId){
       return withManagerId(Operator.GREATER_THAN_OR_EQUAL, managerId);
    }

    public WarehouseRequest<T> withManagerIdLessThan(String managerId){
       return withManagerId(Operator.LESS_THAN, managerId);
    }

    public WarehouseRequest<T> withManagerIdLessThanOrEqualTo(String managerId){
       return withManagerId(Operator.LESS_THAN_OR_EQUAL, managerId);
    }

    public WarehouseRequest<T> withManagerIdBetween(String startOfManagerId, String endOfManagerId){
       return withManagerId(Operator.BETWEEN, startOfManagerId, endOfManagerId);
    }
    public WarehouseRequest<T> withManagerIdStartingWith(String managerId){
       return withManagerId(Operator.BEGIN_WITH, managerId);
    }
    public WarehouseRequest<T> withManagerIdContaining(String managerId){
       return withManagerId(Operator.CONTAIN, managerId);
    }

    public WarehouseRequest<T> withManagerIdEndingWith(String managerId){
       return withManagerId(Operator.END_WITH, managerId);
    }

    public WarehouseRequest<T> withManagerIdIs(String managerId){
       return withManagerId(Operator.EQUAL, managerId);
    }

    public WarehouseRequest<T> withManagerIdSoundingLike(String managerId){
       return withManagerId(Operator.SOUNDS_LIKE, managerId);
    }



    public WarehouseRequest<T> filterByCreateTime(LocalDateTime... createTime){
      if (createTime == null || createTime.length == 0) {
        throw new IllegalArgumentException("filterByCreateTime parameter createTime cannot be empty");
      }
      return appendSearchCriteria(createCreateTimeCriteria(Operator.EQUAL, (Object[])createTime));
    }

    public WarehouseRequest<T> withCreateTime(Operator operator, Object... values){
       return appendSearchCriteria(createCreateTimeCriteria(operator, values));
    }

    public WarehouseRequest<T> withCreateTimeIsUnknown(){
       return withCreateTime(Operator.IS_NULL);
    }

    public WarehouseRequest<T> withCreateTimeIsKnown(){
       return withCreateTime(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createCreateTimeCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Warehouse.CREATE_TIME_PROPERTY, operator, values);
    }

    public WarehouseRequest<T> withCreateTimeGreaterThan(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public WarehouseRequest<T> withCreateTimeGreaterThanOrEqualTo(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN_OR_EQUAL, createTime);
    }

    public WarehouseRequest<T> withCreateTimeLessThan(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public WarehouseRequest<T> withCreateTimeLessThanOrEqualTo(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN_OR_EQUAL, createTime);
    }

    public WarehouseRequest<T> withCreateTimeBetween(LocalDateTime startOfCreateTime, LocalDateTime endOfCreateTime){
       return withCreateTime(Operator.BETWEEN, startOfCreateTime, endOfCreateTime);
    }
    public WarehouseRequest<T> withCreateTimeBefore(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public WarehouseRequest<T> withCreateTimeBefore(Date createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public WarehouseRequest<T> withCreateTimeAfter(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public WarehouseRequest<T> withCreateTimeAfter(Date createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public WarehouseRequest<T> withCreateTimeBetween(Date startOfCreateTime, Date endOfCreateTime){
       return withCreateTime(Operator.BETWEEN, startOfCreateTime, endOfCreateTime);
    }




    public WarehouseRequest<T> filterByUpdateTime(LocalDateTime... updateTime){
      if (updateTime == null || updateTime.length == 0) {
        throw new IllegalArgumentException("filterByUpdateTime parameter updateTime cannot be empty");
      }
      return appendSearchCriteria(createUpdateTimeCriteria(Operator.EQUAL, (Object[])updateTime));
    }

    public WarehouseRequest<T> withUpdateTime(Operator operator, Object... values){
       return appendSearchCriteria(createUpdateTimeCriteria(operator, values));
    }

    public WarehouseRequest<T> withUpdateTimeIsUnknown(){
       return withUpdateTime(Operator.IS_NULL);
    }

    public WarehouseRequest<T> withUpdateTimeIsKnown(){
       return withUpdateTime(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createUpdateTimeCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Warehouse.UPDATE_TIME_PROPERTY, operator, values);
    }

    public WarehouseRequest<T> withUpdateTimeGreaterThan(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public WarehouseRequest<T> withUpdateTimeGreaterThanOrEqualTo(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN_OR_EQUAL, updateTime);
    }

    public WarehouseRequest<T> withUpdateTimeLessThan(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public WarehouseRequest<T> withUpdateTimeLessThanOrEqualTo(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN_OR_EQUAL, updateTime);
    }

    public WarehouseRequest<T> withUpdateTimeBetween(LocalDateTime startOfUpdateTime, LocalDateTime endOfUpdateTime){
       return withUpdateTime(Operator.BETWEEN, startOfUpdateTime, endOfUpdateTime);
    }
    public WarehouseRequest<T> withUpdateTimeBefore(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public WarehouseRequest<T> withUpdateTimeBefore(Date updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public WarehouseRequest<T> withUpdateTimeAfter(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public WarehouseRequest<T> withUpdateTimeAfter(Date updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public WarehouseRequest<T> withUpdateTimeBetween(Date startOfUpdateTime, Date endOfUpdateTime){
       return withUpdateTime(Operator.BETWEEN, startOfUpdateTime, endOfUpdateTime);
    }




    public WarehouseRequest<T> filterByVersion(Long... version){
      if (version == null || version.length == 0) {
        throw new IllegalArgumentException("filterByVersion parameter version cannot be empty");
      }
      return appendSearchCriteria(createVersionCriteria(Operator.EQUAL, (Object[])version));
    }

    public WarehouseRequest<T> withVersion(Operator operator, Object... values){
       return appendSearchCriteria(createVersionCriteria(operator, values));
    }

    public WarehouseRequest<T> withVersionIsUnknown(){
       return withVersion(Operator.IS_NULL);
    }

    public WarehouseRequest<T> withVersionIsKnown(){
       return withVersion(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createVersionCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Warehouse.VERSION_PROPERTY, operator, values);
    }

    public WarehouseRequest<T> withVersionGreaterThan(Long version){
       return withVersion(Operator.GREATER_THAN, version);
    }

    public WarehouseRequest<T> withVersionGreaterThanOrEqualTo(Long version){
       return withVersion(Operator.GREATER_THAN_OR_EQUAL, version);
    }

    public WarehouseRequest<T> withVersionLessThan(Long version){
       return withVersion(Operator.LESS_THAN, version);
    }

    public WarehouseRequest<T> withVersionLessThanOrEqualTo(Long version){
       return withVersion(Operator.LESS_THAN_OR_EQUAL, version);
    }

    public WarehouseRequest<T> withVersionBetween(Long startOfVersion, Long endOfVersion){
       return withVersion(Operator.BETWEEN, startOfVersion, endOfVersion);
    }

    public WarehouseRequest<T> withInventoryItemListMatching(InventoryItemRequest inventoryItemRequest){
        return appendSearchCriteria(new SubQuerySearchCriteria(Warehouse.ID_PROPERTY, inventoryItemRequest, InventoryItem.WAREHOUSE_PROPERTY));
    }

    public WarehouseRequest<T> withoutInventoryItemListMatching(InventoryItemRequest inventoryItemRequest){
        return appendSearchCriteria(SearchCriteria.not(new SubQuerySearchCriteria(Warehouse.ID_PROPERTY, inventoryItemRequest, InventoryItem.WAREHOUSE_PROPERTY)));
    }

    public WarehouseRequest<T> haveInventoryItems(){
        return withInventoryItemListMatching(Q.inventoryItems().unlimited());
    }

    public WarehouseRequest<T> haveNoInventoryItems(){
        return withoutInventoryItemListMatching(Q.inventoryItems().unlimited());
    }
    public WarehouseRequest<T> withShipmentListMatching(ShipmentRequest shipmentRequest){
        return appendSearchCriteria(new SubQuerySearchCriteria(Warehouse.ID_PROPERTY, shipmentRequest, Shipment.WAREHOUSE_PROPERTY));
    }

    public WarehouseRequest<T> withoutShipmentListMatching(ShipmentRequest shipmentRequest){
        return appendSearchCriteria(SearchCriteria.not(new SubQuerySearchCriteria(Warehouse.ID_PROPERTY, shipmentRequest, Shipment.WAREHOUSE_PROPERTY)));
    }

    public WarehouseRequest<T> haveShipments(){
        return withShipmentListMatching(Q.shipments().unlimited());
    }

    public WarehouseRequest<T> haveNoShipments(){
        return withoutShipmentListMatching(Q.shipments().unlimited());
    }

    public WarehouseRequest<T> count(){
        super.count();
        return this;
    }
    public WarehouseRequest<T> countAs(String retName){
        super.count(retName);
        return this;
    }
    public WarehouseRequest minCapacity(){
        return minCapacityAs(prefix("minOf",Warehouse.CAPACITY_PROPERTY));
    }

    public WarehouseRequest minCapacityAs(String retName){
        super.min(retName, Warehouse.CAPACITY_PROPERTY);
        return this;
    }
    public WarehouseRequest maxCapacity(){
        return maxCapacityAs(prefix("maxOf",Warehouse.CAPACITY_PROPERTY));
    }

    public WarehouseRequest maxCapacityAs(String retName){
        super.max(retName, Warehouse.CAPACITY_PROPERTY);
        return this;
    }
    public WarehouseRequest sumCapacity(){
        return sumCapacityAs(prefix("sumOf",Warehouse.CAPACITY_PROPERTY));
    }

    public WarehouseRequest sumCapacityAs(String retName){
        super.sum(retName, Warehouse.CAPACITY_PROPERTY);
        return this;
    }
    public WarehouseRequest avgCapacity(){
        return avgCapacityAs(prefix("avgOf",Warehouse.CAPACITY_PROPERTY));
    }

    public WarehouseRequest avgCapacityAs(String retName){
        super.avg(retName, Warehouse.CAPACITY_PROPERTY);
        return this;
    }
    public WarehouseRequest standardDeviationCapacity(){
        return standardDeviationCapacityAs(prefix("standardDeviationOf",Warehouse.CAPACITY_PROPERTY));
    }

    public WarehouseRequest standardDeviationCapacityAs(String retName){
        super.standardDeviation(retName, Warehouse.CAPACITY_PROPERTY);
        return this;
    }
    public WarehouseRequest squareRootOfPopulationStandardDeviationCapacity(){
        return squareRootOfPopulationStandardDeviationCapacityAs(prefix("squareRootOfPopulationStandardDeviationOf",Warehouse.CAPACITY_PROPERTY));
    }

    public WarehouseRequest squareRootOfPopulationStandardDeviationCapacityAs(String retName){
        super.squareRootOfPopulationStandardDeviation(retName, Warehouse.CAPACITY_PROPERTY);
        return this;
    }
    public WarehouseRequest sampleVarianceCapacity(){
        return sampleVarianceCapacityAs(prefix("sampleVarianceOf",Warehouse.CAPACITY_PROPERTY));
    }

    public WarehouseRequest sampleVarianceCapacityAs(String retName){
        super.sampleVariance(retName, Warehouse.CAPACITY_PROPERTY);
        return this;
    }
    public WarehouseRequest samplePopulationVarianceCapacity(){
        return samplePopulationVarianceCapacityAs(prefix("samplePopulationVarianceOf",Warehouse.CAPACITY_PROPERTY));
    }

    public WarehouseRequest samplePopulationVarianceCapacityAs(String retName){
        super.samplePopulationVariance(retName, Warehouse.CAPACITY_PROPERTY);
        return this;
    }
    public WarehouseRequest<T> groupByInventoryItemsWithDetails(InventoryItemRequest subRequest){
       aggregate(Warehouse.INVENTORY_ITEM_LIST_PROPERTY, subRequest);
       return this;
    }
    public WarehouseRequest<T> groupByShipmentsWithDetails(ShipmentRequest subRequest){
       aggregate(Warehouse.SHIPMENT_LIST_PROPERTY, subRequest);
       return this;
    }

    public WarehouseRequest<T> groupById(){
       groupBy(Warehouse.ID_PROPERTY);
       return this;
    }

    public WarehouseRequest<T> groupByIdAs(String retName){
       groupBy(retName, Warehouse.ID_PROPERTY);
       return this;
    }

    public WarehouseRequest<T> groupByIdWithFunction(String retName, AggrFunction function){
       groupBy(retName, Warehouse.ID_PROPERTY, function);
       return this;
    }

    public WarehouseRequest<T> groupByName(){
       groupBy(Warehouse.NAME_PROPERTY);
       return this;
    }

    public WarehouseRequest<T> groupByNameAs(String retName){
       groupBy(retName, Warehouse.NAME_PROPERTY);
       return this;
    }

    public WarehouseRequest<T> groupByNameWithFunction(String retName, AggrFunction function){
       groupBy(retName, Warehouse.NAME_PROPERTY, function);
       return this;
    }

    public WarehouseRequest<T> groupByCapacity(){
       groupBy(Warehouse.CAPACITY_PROPERTY);
       return this;
    }

    public WarehouseRequest<T> groupByCapacityAs(String retName){
       groupBy(retName, Warehouse.CAPACITY_PROPERTY);
       return this;
    }

    public WarehouseRequest<T> groupByCapacityWithFunction(String retName, AggrFunction function){
       groupBy(retName, Warehouse.CAPACITY_PROPERTY, function);
       return this;
    }

    public WarehouseRequest<T> groupByLocation(){
       groupBy(Warehouse.LOCATION_PROPERTY);
       return this;
    }

    public WarehouseRequest<T> groupByLocationAs(String retName){
       groupBy(retName, Warehouse.LOCATION_PROPERTY);
       return this;
    }

    public WarehouseRequest<T> groupByLocationWithFunction(String retName, AggrFunction function){
       groupBy(retName, Warehouse.LOCATION_PROPERTY, function);
       return this;
    }

    public WarehouseRequest<T> groupByManagerId(){
       groupBy(Warehouse.MANAGER_ID_PROPERTY);
       return this;
    }

    public WarehouseRequest<T> groupByManagerIdAs(String retName){
       groupBy(retName, Warehouse.MANAGER_ID_PROPERTY);
       return this;
    }

    public WarehouseRequest<T> groupByManagerIdWithFunction(String retName, AggrFunction function){
       groupBy(retName, Warehouse.MANAGER_ID_PROPERTY, function);
       return this;
    }

    public WarehouseRequest<T> groupByCreateTime(){
       groupBy(Warehouse.CREATE_TIME_PROPERTY);
       return this;
    }

    public WarehouseRequest<T> groupByCreateTimeAs(String retName){
       groupBy(retName, Warehouse.CREATE_TIME_PROPERTY);
       return this;
    }

    public WarehouseRequest<T> groupByCreateTimeWithFunction(String retName, AggrFunction function){
       groupBy(retName, Warehouse.CREATE_TIME_PROPERTY, function);
       return this;
    }

    public WarehouseRequest<T> groupByUpdateTime(){
       groupBy(Warehouse.UPDATE_TIME_PROPERTY);
       return this;
    }

    public WarehouseRequest<T> groupByUpdateTimeAs(String retName){
       groupBy(retName, Warehouse.UPDATE_TIME_PROPERTY);
       return this;
    }

    public WarehouseRequest<T> groupByUpdateTimeWithFunction(String retName, AggrFunction function){
       groupBy(retName, Warehouse.UPDATE_TIME_PROPERTY, function);
       return this;
    }

    public WarehouseRequest<T> groupByVersion(){
       groupBy(Warehouse.VERSION_PROPERTY);
       return this;
    }

    public WarehouseRequest<T> groupByVersionAs(String retName){
       groupBy(retName, Warehouse.VERSION_PROPERTY);
       return this;
    }

    public WarehouseRequest<T> groupByVersionWithFunction(String retName, AggrFunction function){
       groupBy(retName, Warehouse.VERSION_PROPERTY, function);
       return this;
    }



    public WarehouseRequest<T> orderByIdAscending(){
       addOrderByAscending(Warehouse.ID_PROPERTY);
       return this;
    }

    public WarehouseRequest<T> orderByIdDescending(){
       addOrderByDescending(Warehouse.ID_PROPERTY);
       return this;
    }

    public WarehouseRequest<T> orderByNameAscending(){
       addOrderByAscending(Warehouse.NAME_PROPERTY);
       return this;
    }

    public WarehouseRequest<T> orderByNameDescending(){
       addOrderByDescending(Warehouse.NAME_PROPERTY);
       return this;
    }
    public WarehouseRequest<T> orderByNameAscendingUsingGBK(){
       addOrderByAscendingUsingGBK(Warehouse.NAME_PROPERTY);
       return this;
    }

    public WarehouseRequest<T> orderByNameDescendingUsingGBK(){
       addOrderByDescendingUsingGBK(Warehouse.NAME_PROPERTY);
       return this;
    }
    public WarehouseRequest<T> orderByCapacityAscending(){
       addOrderByAscending(Warehouse.CAPACITY_PROPERTY);
       return this;
    }

    public WarehouseRequest<T> orderByCapacityDescending(){
       addOrderByDescending(Warehouse.CAPACITY_PROPERTY);
       return this;
    }

    public WarehouseRequest<T> orderByLocationAscending(){
       addOrderByAscending(Warehouse.LOCATION_PROPERTY);
       return this;
    }

    public WarehouseRequest<T> orderByLocationDescending(){
       addOrderByDescending(Warehouse.LOCATION_PROPERTY);
       return this;
    }
    public WarehouseRequest<T> orderByLocationAscendingUsingGBK(){
       addOrderByAscendingUsingGBK(Warehouse.LOCATION_PROPERTY);
       return this;
    }

    public WarehouseRequest<T> orderByLocationDescendingUsingGBK(){
       addOrderByDescendingUsingGBK(Warehouse.LOCATION_PROPERTY);
       return this;
    }
    public WarehouseRequest<T> orderByManagerIdAscending(){
       addOrderByAscending(Warehouse.MANAGER_ID_PROPERTY);
       return this;
    }

    public WarehouseRequest<T> orderByManagerIdDescending(){
       addOrderByDescending(Warehouse.MANAGER_ID_PROPERTY);
       return this;
    }
    public WarehouseRequest<T> orderByManagerIdAscendingUsingGBK(){
       addOrderByAscendingUsingGBK(Warehouse.MANAGER_ID_PROPERTY);
       return this;
    }

    public WarehouseRequest<T> orderByManagerIdDescendingUsingGBK(){
       addOrderByDescendingUsingGBK(Warehouse.MANAGER_ID_PROPERTY);
       return this;
    }
    public WarehouseRequest<T> orderByCreateTimeAscending(){
       addOrderByAscending(Warehouse.CREATE_TIME_PROPERTY);
       return this;
    }

    public WarehouseRequest<T> orderByCreateTimeDescending(){
       addOrderByDescending(Warehouse.CREATE_TIME_PROPERTY);
       return this;
    }

    public WarehouseRequest<T> orderByUpdateTimeAscending(){
       addOrderByAscending(Warehouse.UPDATE_TIME_PROPERTY);
       return this;
    }

    public WarehouseRequest<T> orderByUpdateTimeDescending(){
       addOrderByDescending(Warehouse.UPDATE_TIME_PROPERTY);
       return this;
    }

    public WarehouseRequest<T> orderByVersionAscending(){
       addOrderByAscending(Warehouse.VERSION_PROPERTY);
       return this;
    }

    public WarehouseRequest<T> orderByVersionDescending(){
       addOrderByDescending(Warehouse.VERSION_PROPERTY);
       return this;
    }


    public WarehouseRequest<T> statsFromInventoryItemsAs(String name, InventoryItemRequest subRequest){
       return statsFromInventoryItemsAs(name, subRequest, false);
    }

    public WarehouseRequest<T> statsFromInventoryItemsAs(String name, InventoryItemRequest subRequest, boolean singleResult){
       subRequest.setPartitionProperty(InventoryItem.WAREHOUSE_PROPERTY);
       addAggregateDynamicProperty(name, subRequest, singleResult);
       return this;
    }

    public WarehouseRequest<T> statsFromInventoryItems(InventoryItemRequest subRequest){
       return statsFromInventoryItemsAs(REFINEMENTS, subRequest);
    }
    public WarehouseRequest<T> statsFromShipmentsAs(String name, ShipmentRequest subRequest){
       return statsFromShipmentsAs(name, subRequest, false);
    }

    public WarehouseRequest<T> statsFromShipmentsAs(String name, ShipmentRequest subRequest, boolean singleResult){
       subRequest.setPartitionProperty(Shipment.WAREHOUSE_PROPERTY);
       addAggregateDynamicProperty(name, subRequest, singleResult);
       return this;
    }

    public WarehouseRequest<T> statsFromShipments(ShipmentRequest subRequest){
       return statsFromShipmentsAs(REFINEMENTS, subRequest);
    }
    public WarehouseRequest<T> countInventoryItems(){
        return countInventoryItemsAs("Count");
    }

    public WarehouseRequest<T> countInventoryItemsAs(String name){
        return countInventoryItemsWith(name, Q.inventoryItems().unlimited());
    }

    public WarehouseRequest<T> countInventoryItemsWith(String name, InventoryItemRequest subRequest){
        return statsFromInventoryItemsAs(name, subRequest.count(), true);
    }
    public WarehouseRequest<T> countShipments(){
        return countShipmentsAs("Count");
    }

    public WarehouseRequest<T> countShipmentsAs(String name){
        return countShipmentsWith(name, Q.shipments().unlimited());
    }

    public WarehouseRequest<T> countShipmentsWith(String name, ShipmentRequest subRequest){
        return statsFromShipmentsAs(name, subRequest.count(), true);
    }
    public WarehouseRequest<T> minQuantityOnHandOfInventoryItems(){
        return minQuantityOnHandOfInventoryItemsAs("minQuantityOnHandOfInventoryItems");
    }

    public WarehouseRequest<T> minQuantityOnHandOfInventoryItemsAs(String name){
        return minQuantityOnHandOfInventoryItemsAs(name, Q.inventoryItems().unlimited());
    }

    public WarehouseRequest<T> minQuantityOnHandOfInventoryItemsAs(String name, InventoryItemRequest subRequest){
        return statsFromInventoryItemsAs(name, subRequest.minQuantityOnHand(), true);
    }
    public WarehouseRequest<T> maxQuantityOnHandOfInventoryItems(){
        return maxQuantityOnHandOfInventoryItemsAs("maxQuantityOnHandOfInventoryItems");
    }

    public WarehouseRequest<T> maxQuantityOnHandOfInventoryItemsAs(String name){
        return maxQuantityOnHandOfInventoryItemsAs(name, Q.inventoryItems().unlimited());
    }

    public WarehouseRequest<T> maxQuantityOnHandOfInventoryItemsAs(String name, InventoryItemRequest subRequest){
        return statsFromInventoryItemsAs(name, subRequest.maxQuantityOnHand(), true);
    }
    public WarehouseRequest<T> sumQuantityOnHandOfInventoryItems(){
        return sumQuantityOnHandOfInventoryItemsAs("sumQuantityOnHandOfInventoryItems");
    }

    public WarehouseRequest<T> sumQuantityOnHandOfInventoryItemsAs(String name){
        return sumQuantityOnHandOfInventoryItemsAs(name, Q.inventoryItems().unlimited());
    }

    public WarehouseRequest<T> sumQuantityOnHandOfInventoryItemsAs(String name, InventoryItemRequest subRequest){
        return statsFromInventoryItemsAs(name, subRequest.sumQuantityOnHand(), true);
    }
    public WarehouseRequest<T> avgQuantityOnHandOfInventoryItems(){
        return avgQuantityOnHandOfInventoryItemsAs("avgQuantityOnHandOfInventoryItems");
    }

    public WarehouseRequest<T> avgQuantityOnHandOfInventoryItemsAs(String name){
        return avgQuantityOnHandOfInventoryItemsAs(name, Q.inventoryItems().unlimited());
    }

    public WarehouseRequest<T> avgQuantityOnHandOfInventoryItemsAs(String name, InventoryItemRequest subRequest){
        return statsFromInventoryItemsAs(name, subRequest.avgQuantityOnHand(), true);
    }
    public WarehouseRequest<T> standardDeviationQuantityOnHandOfInventoryItems(){
        return standardDeviationQuantityOnHandOfInventoryItemsAs("stdDevQuantityOnHandOfInventoryItems");
    }

    public WarehouseRequest<T> standardDeviationQuantityOnHandOfInventoryItemsAs(String name){
        return standardDeviationQuantityOnHandOfInventoryItemsAs(name, Q.inventoryItems().unlimited());
    }

    public WarehouseRequest<T> standardDeviationQuantityOnHandOfInventoryItemsAs(String name, InventoryItemRequest subRequest){
        return statsFromInventoryItemsAs(name, subRequest.standardDeviationQuantityOnHand(), true);
    }
    public WarehouseRequest<T> squareRootOfPopulationStandardDeviationQuantityOnHandOfInventoryItems(){
        return squareRootOfPopulationStandardDeviationQuantityOnHandOfInventoryItemsAs("stdDevPopQuantityOnHandOfInventoryItems");
    }

    public WarehouseRequest<T> squareRootOfPopulationStandardDeviationQuantityOnHandOfInventoryItemsAs(String name){
        return squareRootOfPopulationStandardDeviationQuantityOnHandOfInventoryItemsAs(name, Q.inventoryItems().unlimited());
    }

    public WarehouseRequest<T> squareRootOfPopulationStandardDeviationQuantityOnHandOfInventoryItemsAs(String name, InventoryItemRequest subRequest){
        return statsFromInventoryItemsAs(name, subRequest.squareRootOfPopulationStandardDeviationQuantityOnHand(), true);
    }
    public WarehouseRequest<T> sampleVarianceQuantityOnHandOfInventoryItems(){
        return sampleVarianceQuantityOnHandOfInventoryItemsAs("varSampQuantityOnHandOfInventoryItems");
    }

    public WarehouseRequest<T> sampleVarianceQuantityOnHandOfInventoryItemsAs(String name){
        return sampleVarianceQuantityOnHandOfInventoryItemsAs(name, Q.inventoryItems().unlimited());
    }

    public WarehouseRequest<T> sampleVarianceQuantityOnHandOfInventoryItemsAs(String name, InventoryItemRequest subRequest){
        return statsFromInventoryItemsAs(name, subRequest.sampleVarianceQuantityOnHand(), true);
    }
    public WarehouseRequest<T> samplePopulationVarianceQuantityOnHandOfInventoryItems(){
        return samplePopulationVarianceQuantityOnHandOfInventoryItemsAs("varPopQuantityOnHandOfInventoryItems");
    }

    public WarehouseRequest<T> samplePopulationVarianceQuantityOnHandOfInventoryItemsAs(String name){
        return samplePopulationVarianceQuantityOnHandOfInventoryItemsAs(name, Q.inventoryItems().unlimited());
    }

    public WarehouseRequest<T> samplePopulationVarianceQuantityOnHandOfInventoryItemsAs(String name, InventoryItemRequest subRequest){
        return statsFromInventoryItemsAs(name, subRequest.samplePopulationVarianceQuantityOnHand(), true);
    }
    public WarehouseRequest<T> minReorderLevelOfInventoryItems(){
        return minReorderLevelOfInventoryItemsAs("minReorderLevelOfInventoryItems");
    }

    public WarehouseRequest<T> minReorderLevelOfInventoryItemsAs(String name){
        return minReorderLevelOfInventoryItemsAs(name, Q.inventoryItems().unlimited());
    }

    public WarehouseRequest<T> minReorderLevelOfInventoryItemsAs(String name, InventoryItemRequest subRequest){
        return statsFromInventoryItemsAs(name, subRequest.minReorderLevel(), true);
    }
    public WarehouseRequest<T> maxReorderLevelOfInventoryItems(){
        return maxReorderLevelOfInventoryItemsAs("maxReorderLevelOfInventoryItems");
    }

    public WarehouseRequest<T> maxReorderLevelOfInventoryItemsAs(String name){
        return maxReorderLevelOfInventoryItemsAs(name, Q.inventoryItems().unlimited());
    }

    public WarehouseRequest<T> maxReorderLevelOfInventoryItemsAs(String name, InventoryItemRequest subRequest){
        return statsFromInventoryItemsAs(name, subRequest.maxReorderLevel(), true);
    }
    public WarehouseRequest<T> sumReorderLevelOfInventoryItems(){
        return sumReorderLevelOfInventoryItemsAs("sumReorderLevelOfInventoryItems");
    }

    public WarehouseRequest<T> sumReorderLevelOfInventoryItemsAs(String name){
        return sumReorderLevelOfInventoryItemsAs(name, Q.inventoryItems().unlimited());
    }

    public WarehouseRequest<T> sumReorderLevelOfInventoryItemsAs(String name, InventoryItemRequest subRequest){
        return statsFromInventoryItemsAs(name, subRequest.sumReorderLevel(), true);
    }
    public WarehouseRequest<T> avgReorderLevelOfInventoryItems(){
        return avgReorderLevelOfInventoryItemsAs("avgReorderLevelOfInventoryItems");
    }

    public WarehouseRequest<T> avgReorderLevelOfInventoryItemsAs(String name){
        return avgReorderLevelOfInventoryItemsAs(name, Q.inventoryItems().unlimited());
    }

    public WarehouseRequest<T> avgReorderLevelOfInventoryItemsAs(String name, InventoryItemRequest subRequest){
        return statsFromInventoryItemsAs(name, subRequest.avgReorderLevel(), true);
    }
    public WarehouseRequest<T> standardDeviationReorderLevelOfInventoryItems(){
        return standardDeviationReorderLevelOfInventoryItemsAs("stdDevReorderLevelOfInventoryItems");
    }

    public WarehouseRequest<T> standardDeviationReorderLevelOfInventoryItemsAs(String name){
        return standardDeviationReorderLevelOfInventoryItemsAs(name, Q.inventoryItems().unlimited());
    }

    public WarehouseRequest<T> standardDeviationReorderLevelOfInventoryItemsAs(String name, InventoryItemRequest subRequest){
        return statsFromInventoryItemsAs(name, subRequest.standardDeviationReorderLevel(), true);
    }
    public WarehouseRequest<T> squareRootOfPopulationStandardDeviationReorderLevelOfInventoryItems(){
        return squareRootOfPopulationStandardDeviationReorderLevelOfInventoryItemsAs("stdDevPopReorderLevelOfInventoryItems");
    }

    public WarehouseRequest<T> squareRootOfPopulationStandardDeviationReorderLevelOfInventoryItemsAs(String name){
        return squareRootOfPopulationStandardDeviationReorderLevelOfInventoryItemsAs(name, Q.inventoryItems().unlimited());
    }

    public WarehouseRequest<T> squareRootOfPopulationStandardDeviationReorderLevelOfInventoryItemsAs(String name, InventoryItemRequest subRequest){
        return statsFromInventoryItemsAs(name, subRequest.squareRootOfPopulationStandardDeviationReorderLevel(), true);
    }
    public WarehouseRequest<T> sampleVarianceReorderLevelOfInventoryItems(){
        return sampleVarianceReorderLevelOfInventoryItemsAs("varSampReorderLevelOfInventoryItems");
    }

    public WarehouseRequest<T> sampleVarianceReorderLevelOfInventoryItemsAs(String name){
        return sampleVarianceReorderLevelOfInventoryItemsAs(name, Q.inventoryItems().unlimited());
    }

    public WarehouseRequest<T> sampleVarianceReorderLevelOfInventoryItemsAs(String name, InventoryItemRequest subRequest){
        return statsFromInventoryItemsAs(name, subRequest.sampleVarianceReorderLevel(), true);
    }
    public WarehouseRequest<T> samplePopulationVarianceReorderLevelOfInventoryItems(){
        return samplePopulationVarianceReorderLevelOfInventoryItemsAs("varPopReorderLevelOfInventoryItems");
    }

    public WarehouseRequest<T> samplePopulationVarianceReorderLevelOfInventoryItemsAs(String name){
        return samplePopulationVarianceReorderLevelOfInventoryItemsAs(name, Q.inventoryItems().unlimited());
    }

    public WarehouseRequest<T> samplePopulationVarianceReorderLevelOfInventoryItemsAs(String name, InventoryItemRequest subRequest){
        return statsFromInventoryItemsAs(name, subRequest.samplePopulationVarianceReorderLevel(), true);
    }



    /**
     * get topN records
     * @param topN  records number
     */
    public WarehouseRequest<T> top(int topN) {
        super.top(topN);
        return this;
    }

    /**
     * get records from offset(inclusive) to offset+size(exclusive)
     * @param offset record offset
     * @param size records number
     */
    public WarehouseRequest<T> offset(int offset, int size) {
        super.offset(offset, size);
        return this;
    }

    /**
     * retrieve all records
     */
    public WarehouseRequest<T> unlimited() {
        super.unlimited();
        return this;
    }

    /**
     * get records of one page
     * @param pageNumber page number(1-based)
     * @param pageSize page size
     */
    public WarehouseRequest<T> page(int pageNumber, int pageSize) {
        int offset = (pageNumber - 1) * pageSize;
        return offset(offset, pageSize);
   }

    /**
     * get records of one page, default page size is 10
     * @param pageNumber page number(1-based)
     */
    public WarehouseRequest<T> page(int pageNumber) {
        return page(pageNumber, 10);
   }
}