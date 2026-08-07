
package com.example.enterpriseerpsystem.shipment;

import com.example.enterpriseerpsystem.Q;
import com.example.enterpriseerpsystem.delivery.Delivery;
import com.example.enterpriseerpsystem.delivery.DeliveryRequest;
import com.example.enterpriseerpsystem.globalorder.GlobalOrder;
import com.example.enterpriseerpsystem.globalorder.GlobalOrderRequest;
import com.example.enterpriseerpsystem.warehouse.Warehouse;
import com.example.enterpriseerpsystem.warehouse.WarehouseRequest;
import io.teaql.core.AggrFunction;
import io.teaql.core.BaseRequest;
import io.teaql.core.PropertyReference;
import io.teaql.core.SearchCriteria;
import io.teaql.core.SubQuerySearchCriteria;
import io.teaql.core.criteria.Operator;
import io.teaql.core.criteria.TwoOperatorCriteria;
import java.time.LocalDateTime;
import java.util.Date;

public class ShipmentRequest<T extends Shipment> extends BaseRequest<T> {

    /**
     * @deprecated AI agents and business code must use the generated Q facade
     *             instead of constructing request builders directly.
     */
    @Deprecated
    public ShipmentRequest(Class<T> returnType){
        super(returnType);
        selectId();
        selectVersion();
    }

    public ShipmentRequest<T> comment(String comment){
         super.internalComment(comment);
         return this;
    }

    // purpose() 继承自 BaseRequest，返回 ExecutableRequest（终结方法）

    public ShipmentRequest<T> returnType(Class<? extends T> returnType){
        super.setReturnType(returnType);
        return this;
    }

    public ShipmentRequest<T> enableAggregationCache(long cacheExpiredMillis){
        super.enableAggregationCache();
        super.aggregateCacheTime(cacheExpiredMillis);
        return this;
    }

    public ShipmentRequest<T> enableAggregationCache(){
        return enableAggregationCache(0l);
    }


    public ShipmentRequest<T> propagateAggregationCache(long cacheExpiredMillis){
        super.propagateAggregationCache(cacheExpiredMillis);
        return this;
    }

    public ShipmentRequest<T> appendSearchCriteria(SearchCriteria searchCriteria){
        return (ShipmentRequest<T>)super.appendSearchCriteria(searchCriteria);
    }

    public ShipmentRequest<T> filter(String property1, Operator operator, String property2){
        return appendSearchCriteria(new TwoOperatorCriteria(operator, new PropertyReference(property1), new PropertyReference(property2)));
    }


    public ShipmentRequest<T> matchingAnyOf(ShipmentRequest shipment){
        super.internalMatchAny(shipment);
        return this;
    }

    public ShipmentRequest<T> enhanceChildrenIfNeeded(){
        return this;
    }

    public ShipmentRequest<T> withDeletedRows(){
        super.withDeletedRows();
        return this;
    }

    public ShipmentRequest<T> deletedRowsOnly(){
        super.deletedRowsOnly();
        return this;
    }

    public ShipmentRequest<T> selectSelf(){
        super.selectSelf();
        return selectId().selectShippedDate().selectCarrier().selectGlobalOrderIdOnly().selectStatus().selectTrackingNumber().selectWarehouseIdOnly().selectCreateTime().selectUpdateTime().selectVersion();
    }

    public ShipmentRequest<T> selectSelfFields(){
        return selectSelf();
    }

    public ShipmentRequest<T> selectAll(){
        super.selectAll();
        return selectId().selectShippedDate().selectCarrier().selectGlobalOrder().selectStatus().selectTrackingNumber().selectWarehouse().selectCreateTime().selectUpdateTime().selectVersion();
    }

    public ShipmentRequest<T> selectChildren(){
        super.selectAny();
        selectDeliveryList();
        return selectId().selectShippedDate().selectCarrier().selectGlobalOrder().selectStatus().selectTrackingNumber().selectWarehouse().selectCreateTime().selectUpdateTime().selectVersion();
    }


    public ShipmentRequest<T> selectId(){
       selectProperty(Shipment.ID_PROPERTY);
       return this;
    }

    /**
     * fill the id with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  id) to fetch id property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public ShipmentRequest<T> unselectId(){
       unselectProperty(Shipment.ID_PROPERTY);
       return this;
    }
    public ShipmentRequest<T> selectShippedDate(){
       selectProperty(Shipment.SHIPPED_DATE_PROPERTY);
       return this;
    }

    /**
     * fill the shippedDate with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  shippedDate) to fetch shippedDate property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public ShipmentRequest<T> unselectShippedDate(){
       unselectProperty(Shipment.SHIPPED_DATE_PROPERTY);
       return this;
    }
    public ShipmentRequest<T> selectCarrier(){
       selectProperty(Shipment.CARRIER_PROPERTY);
       return this;
    }

    /**
     * fill the carrier with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  carrier) to fetch carrier property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public ShipmentRequest<T> unselectCarrier(){
       unselectProperty(Shipment.CARRIER_PROPERTY);
       return this;
    }
    public ShipmentRequest<T> selectGlobalOrderIdOnly(){
       selectProperty(Shipment.GLOBAL_ORDER_PROPERTY);
       return this;
    }

    public ShipmentRequest<T> selectGlobalOrder(){
        return selectGlobalOrderWith(Q.globalOrders().unlimited().selectSelf());
    }

    public ShipmentRequest<T> selectGlobalOrderWith(GlobalOrderRequest globalOrder){
       selectProperty(Shipment.GLOBAL_ORDER_PROPERTY);
       enhanceRelation(Shipment.GLOBAL_ORDER_PROPERTY, globalOrder);
       return this;
    }

    public ShipmentRequest<T> unselectGlobalOrder(){
       unselectProperty(Shipment.GLOBAL_ORDER_PROPERTY);
       return this;
    }
    public ShipmentRequest<T> selectStatus(){
       selectProperty(Shipment.STATUS_PROPERTY);
       return this;
    }

    /**
     * fill the status with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  status) to fetch status property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public ShipmentRequest<T> unselectStatus(){
       unselectProperty(Shipment.STATUS_PROPERTY);
       return this;
    }
    public ShipmentRequest<T> selectTrackingNumber(){
       selectProperty(Shipment.TRACKING_NUMBER_PROPERTY);
       return this;
    }

    /**
     * fill the trackingNumber with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  trackingNumber) to fetch trackingNumber property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public ShipmentRequest<T> unselectTrackingNumber(){
       unselectProperty(Shipment.TRACKING_NUMBER_PROPERTY);
       return this;
    }
    public ShipmentRequest<T> selectWarehouseIdOnly(){
       selectProperty(Shipment.WAREHOUSE_PROPERTY);
       return this;
    }

    public ShipmentRequest<T> selectWarehouse(){
        return selectWarehouseWith(Q.warehouses().unlimited().selectSelf());
    }

    public ShipmentRequest<T> selectWarehouseWith(WarehouseRequest warehouse){
       selectProperty(Shipment.WAREHOUSE_PROPERTY);
       enhanceRelation(Shipment.WAREHOUSE_PROPERTY, warehouse);
       return this;
    }

    public ShipmentRequest<T> unselectWarehouse(){
       unselectProperty(Shipment.WAREHOUSE_PROPERTY);
       return this;
    }
    public ShipmentRequest<T> selectCreateTime(){
       selectProperty(Shipment.CREATE_TIME_PROPERTY);
       return this;
    }

    /**
     * fill the createTime with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  createTime) to fetch createTime property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public ShipmentRequest<T> unselectCreateTime(){
       unselectProperty(Shipment.CREATE_TIME_PROPERTY);
       return this;
    }
    public ShipmentRequest<T> selectUpdateTime(){
       selectProperty(Shipment.UPDATE_TIME_PROPERTY);
       return this;
    }

    /**
     * fill the updateTime with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  updateTime) to fetch updateTime property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public ShipmentRequest<T> unselectUpdateTime(){
       unselectProperty(Shipment.UPDATE_TIME_PROPERTY);
       return this;
    }
    public ShipmentRequest<T> selectVersion(){
       selectProperty(Shipment.VERSION_PROPERTY);
       return this;
    }

    /**
     * fill the version with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  version) to fetch version property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public ShipmentRequest<T> unselectVersion(){
       unselectProperty(Shipment.VERSION_PROPERTY);
       return this;
    }
    public ShipmentRequest<T> selectDeliveryList(){
       return selectDeliveryListWith(Q.deliveries().selectSelf());
    }

    public ShipmentRequest<T> selectDeliveryListWith(DeliveryRequest deliveryList){
       enhanceRelation(Shipment.DELIVERY_LIST_PROPERTY, deliveryList);
       return this;
    }

    public ShipmentRequest<T> withId(Operator operator, Object... values){
       return appendSearchCriteria(createIdCriteria(operator, values));
    }

    public SearchCriteria createIdCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Shipment.ID_PROPERTY, operator, values);
    }

    public ShipmentRequest<T> withIdIs(Long id){
       return withId(Operator.EQUAL, id);
    }
    public ShipmentRequest<T> withIdIn(Long... id){
       return withId(Operator.EQUAL, (Object[])id);
    }



    public ShipmentRequest<T> filterByShippedDate(LocalDateTime... shippedDate){
      if (shippedDate == null || shippedDate.length == 0) {
        throw new IllegalArgumentException("filterByShippedDate parameter shippedDate cannot be empty");
      }
      return appendSearchCriteria(createShippedDateCriteria(Operator.EQUAL, (Object[])shippedDate));
    }

    public ShipmentRequest<T> withShippedDate(Operator operator, Object... values){
       return appendSearchCriteria(createShippedDateCriteria(operator, values));
    }

    public ShipmentRequest<T> withShippedDateIsUnknown(){
       return withShippedDate(Operator.IS_NULL);
    }

    public ShipmentRequest<T> withShippedDateIsKnown(){
       return withShippedDate(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createShippedDateCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Shipment.SHIPPED_DATE_PROPERTY, operator, values);
    }

    public ShipmentRequest<T> withShippedDateGreaterThan(LocalDateTime shippedDate){
       return withShippedDate(Operator.GREATER_THAN, shippedDate);
    }

    public ShipmentRequest<T> withShippedDateGreaterThanOrEqualTo(LocalDateTime shippedDate){
       return withShippedDate(Operator.GREATER_THAN_OR_EQUAL, shippedDate);
    }

    public ShipmentRequest<T> withShippedDateLessThan(LocalDateTime shippedDate){
       return withShippedDate(Operator.LESS_THAN, shippedDate);
    }

    public ShipmentRequest<T> withShippedDateLessThanOrEqualTo(LocalDateTime shippedDate){
       return withShippedDate(Operator.LESS_THAN_OR_EQUAL, shippedDate);
    }

    public ShipmentRequest<T> withShippedDateBetween(LocalDateTime startOfShippedDate, LocalDateTime endOfShippedDate){
       return withShippedDate(Operator.BETWEEN, startOfShippedDate, endOfShippedDate);
    }
    public ShipmentRequest<T> withShippedDateBefore(LocalDateTime shippedDate){
       return withShippedDate(Operator.LESS_THAN, shippedDate);
    }

    public ShipmentRequest<T> withShippedDateBefore(Date shippedDate){
       return withShippedDate(Operator.LESS_THAN, shippedDate);
    }

    public ShipmentRequest<T> withShippedDateAfter(LocalDateTime shippedDate){
       return withShippedDate(Operator.GREATER_THAN, shippedDate);
    }

    public ShipmentRequest<T> withShippedDateAfter(Date shippedDate){
       return withShippedDate(Operator.GREATER_THAN, shippedDate);
    }

    public ShipmentRequest<T> withShippedDateBetween(Date startOfShippedDate, Date endOfShippedDate){
       return withShippedDate(Operator.BETWEEN, startOfShippedDate, endOfShippedDate);
    }




    public ShipmentRequest<T> filterByCarrier(String... carrier){
      if (carrier == null || carrier.length == 0) {
        throw new IllegalArgumentException("filterByCarrier parameter carrier cannot be empty");
      }
      return appendSearchCriteria(createCarrierCriteria(Operator.EQUAL, (Object[])carrier));
    }

    public ShipmentRequest<T> withCarrier(Operator operator, Object... values){
       return appendSearchCriteria(createCarrierCriteria(operator, values));
    }

    public ShipmentRequest<T> withCarrierIsUnknown(){
       return withCarrier(Operator.IS_NULL);
    }

    public ShipmentRequest<T> withCarrierIsKnown(){
       return withCarrier(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createCarrierCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Shipment.CARRIER_PROPERTY, operator, values);
    }

    public ShipmentRequest<T> withCarrierGreaterThan(String carrier){
       return withCarrier(Operator.GREATER_THAN, carrier);
    }

    public ShipmentRequest<T> withCarrierGreaterThanOrEqualTo(String carrier){
       return withCarrier(Operator.GREATER_THAN_OR_EQUAL, carrier);
    }

    public ShipmentRequest<T> withCarrierLessThan(String carrier){
       return withCarrier(Operator.LESS_THAN, carrier);
    }

    public ShipmentRequest<T> withCarrierLessThanOrEqualTo(String carrier){
       return withCarrier(Operator.LESS_THAN_OR_EQUAL, carrier);
    }

    public ShipmentRequest<T> withCarrierBetween(String startOfCarrier, String endOfCarrier){
       return withCarrier(Operator.BETWEEN, startOfCarrier, endOfCarrier);
    }
    public ShipmentRequest<T> withCarrierStartingWith(String carrier){
       return withCarrier(Operator.BEGIN_WITH, carrier);
    }
    public ShipmentRequest<T> withCarrierContaining(String carrier){
       return withCarrier(Operator.CONTAIN, carrier);
    }

    public ShipmentRequest<T> withCarrierEndingWith(String carrier){
       return withCarrier(Operator.END_WITH, carrier);
    }

    public ShipmentRequest<T> withCarrierIs(String carrier){
       return withCarrier(Operator.EQUAL, carrier);
    }

    public ShipmentRequest<T> withCarrierSoundingLike(String carrier){
       return withCarrier(Operator.SOUNDS_LIKE, carrier);
    }



    public ShipmentRequest<T> filterByGlobalOrder(GlobalOrder... globalOrder){
      if (globalOrder == null || globalOrder.length == 0) {
        throw new IllegalArgumentException("filterByGlobalOrder parameter globalOrder cannot be empty");
      }
      return appendSearchCriteria(createGlobalOrderCriteria(Operator.EQUAL, (Object[])globalOrder));
    }

    public ShipmentRequest<T> withGlobalOrder(Operator operator, Object... values){
       return appendSearchCriteria(createGlobalOrderCriteria(operator, values));
    }

    public ShipmentRequest<T> withGlobalOrderIsUnknown(){
       return withGlobalOrder(Operator.IS_NULL);
    }

    public ShipmentRequest<T> withGlobalOrderIsKnown(){
       return withGlobalOrder(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createGlobalOrderCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Shipment.GLOBAL_ORDER_PROPERTY, operator, values);
    }

    public ShipmentRequest<T> filterByGlobalOrder(Long globalOrder){
      if(globalOrder == null){
         return this;
      }
      return withGlobalOrder(Operator.EQUAL, globalOrder);
    }
    public ShipmentRequest<T> withGlobalOrderMatching(GlobalOrderRequest globalOrder){
       return appendSearchCriteria(new SubQuerySearchCriteria(Shipment.GLOBAL_ORDER_PROPERTY, globalOrder, GlobalOrder.ID_PROPERTY));
    }

    public ShipmentRequest<T> filterByStatus(String... status){
      if (status == null || status.length == 0) {
        throw new IllegalArgumentException("filterByStatus parameter status cannot be empty");
      }
      return appendSearchCriteria(createStatusCriteria(Operator.EQUAL, (Object[])status));
    }

    public ShipmentRequest<T> withStatus(Operator operator, Object... values){
       return appendSearchCriteria(createStatusCriteria(operator, values));
    }

    public ShipmentRequest<T> withStatusIsUnknown(){
       return withStatus(Operator.IS_NULL);
    }

    public ShipmentRequest<T> withStatusIsKnown(){
       return withStatus(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createStatusCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Shipment.STATUS_PROPERTY, operator, values);
    }

    public ShipmentRequest<T> withStatusGreaterThan(String status){
       return withStatus(Operator.GREATER_THAN, status);
    }

    public ShipmentRequest<T> withStatusGreaterThanOrEqualTo(String status){
       return withStatus(Operator.GREATER_THAN_OR_EQUAL, status);
    }

    public ShipmentRequest<T> withStatusLessThan(String status){
       return withStatus(Operator.LESS_THAN, status);
    }

    public ShipmentRequest<T> withStatusLessThanOrEqualTo(String status){
       return withStatus(Operator.LESS_THAN_OR_EQUAL, status);
    }

    public ShipmentRequest<T> withStatusBetween(String startOfStatus, String endOfStatus){
       return withStatus(Operator.BETWEEN, startOfStatus, endOfStatus);
    }
    public ShipmentRequest<T> withStatusStartingWith(String status){
       return withStatus(Operator.BEGIN_WITH, status);
    }
    public ShipmentRequest<T> withStatusContaining(String status){
       return withStatus(Operator.CONTAIN, status);
    }

    public ShipmentRequest<T> withStatusEndingWith(String status){
       return withStatus(Operator.END_WITH, status);
    }

    public ShipmentRequest<T> withStatusIs(String status){
       return withStatus(Operator.EQUAL, status);
    }

    public ShipmentRequest<T> withStatusSoundingLike(String status){
       return withStatus(Operator.SOUNDS_LIKE, status);
    }



    public ShipmentRequest<T> filterByTrackingNumber(String... trackingNumber){
      if (trackingNumber == null || trackingNumber.length == 0) {
        throw new IllegalArgumentException("filterByTrackingNumber parameter trackingNumber cannot be empty");
      }
      return appendSearchCriteria(createTrackingNumberCriteria(Operator.EQUAL, (Object[])trackingNumber));
    }

    public ShipmentRequest<T> withTrackingNumber(Operator operator, Object... values){
       return appendSearchCriteria(createTrackingNumberCriteria(operator, values));
    }

    public ShipmentRequest<T> withTrackingNumberIsUnknown(){
       return withTrackingNumber(Operator.IS_NULL);
    }

    public ShipmentRequest<T> withTrackingNumberIsKnown(){
       return withTrackingNumber(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createTrackingNumberCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Shipment.TRACKING_NUMBER_PROPERTY, operator, values);
    }

    public ShipmentRequest<T> withTrackingNumberGreaterThan(String trackingNumber){
       return withTrackingNumber(Operator.GREATER_THAN, trackingNumber);
    }

    public ShipmentRequest<T> withTrackingNumberGreaterThanOrEqualTo(String trackingNumber){
       return withTrackingNumber(Operator.GREATER_THAN_OR_EQUAL, trackingNumber);
    }

    public ShipmentRequest<T> withTrackingNumberLessThan(String trackingNumber){
       return withTrackingNumber(Operator.LESS_THAN, trackingNumber);
    }

    public ShipmentRequest<T> withTrackingNumberLessThanOrEqualTo(String trackingNumber){
       return withTrackingNumber(Operator.LESS_THAN_OR_EQUAL, trackingNumber);
    }

    public ShipmentRequest<T> withTrackingNumberBetween(String startOfTrackingNumber, String endOfTrackingNumber){
       return withTrackingNumber(Operator.BETWEEN, startOfTrackingNumber, endOfTrackingNumber);
    }
    public ShipmentRequest<T> withTrackingNumberStartingWith(String trackingNumber){
       return withTrackingNumber(Operator.BEGIN_WITH, trackingNumber);
    }
    public ShipmentRequest<T> withTrackingNumberContaining(String trackingNumber){
       return withTrackingNumber(Operator.CONTAIN, trackingNumber);
    }

    public ShipmentRequest<T> withTrackingNumberEndingWith(String trackingNumber){
       return withTrackingNumber(Operator.END_WITH, trackingNumber);
    }

    public ShipmentRequest<T> withTrackingNumberIs(String trackingNumber){
       return withTrackingNumber(Operator.EQUAL, trackingNumber);
    }

    public ShipmentRequest<T> withTrackingNumberSoundingLike(String trackingNumber){
       return withTrackingNumber(Operator.SOUNDS_LIKE, trackingNumber);
    }



    public ShipmentRequest<T> filterByWarehouse(Warehouse... warehouse){
      if (warehouse == null || warehouse.length == 0) {
        throw new IllegalArgumentException("filterByWarehouse parameter warehouse cannot be empty");
      }
      return appendSearchCriteria(createWarehouseCriteria(Operator.EQUAL, (Object[])warehouse));
    }

    public ShipmentRequest<T> withWarehouse(Operator operator, Object... values){
       return appendSearchCriteria(createWarehouseCriteria(operator, values));
    }

    public ShipmentRequest<T> withWarehouseIsUnknown(){
       return withWarehouse(Operator.IS_NULL);
    }

    public ShipmentRequest<T> withWarehouseIsKnown(){
       return withWarehouse(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createWarehouseCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Shipment.WAREHOUSE_PROPERTY, operator, values);
    }

    public ShipmentRequest<T> filterByWarehouse(Long warehouse){
      if(warehouse == null){
         return this;
      }
      return withWarehouse(Operator.EQUAL, warehouse);
    }
    public ShipmentRequest<T> withWarehouseMatching(WarehouseRequest warehouse){
       return appendSearchCriteria(new SubQuerySearchCriteria(Shipment.WAREHOUSE_PROPERTY, warehouse, Warehouse.ID_PROPERTY));
    }

    public ShipmentRequest<T> filterByCreateTime(LocalDateTime... createTime){
      if (createTime == null || createTime.length == 0) {
        throw new IllegalArgumentException("filterByCreateTime parameter createTime cannot be empty");
      }
      return appendSearchCriteria(createCreateTimeCriteria(Operator.EQUAL, (Object[])createTime));
    }

    public ShipmentRequest<T> withCreateTime(Operator operator, Object... values){
       return appendSearchCriteria(createCreateTimeCriteria(operator, values));
    }

    public ShipmentRequest<T> withCreateTimeIsUnknown(){
       return withCreateTime(Operator.IS_NULL);
    }

    public ShipmentRequest<T> withCreateTimeIsKnown(){
       return withCreateTime(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createCreateTimeCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Shipment.CREATE_TIME_PROPERTY, operator, values);
    }

    public ShipmentRequest<T> withCreateTimeGreaterThan(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public ShipmentRequest<T> withCreateTimeGreaterThanOrEqualTo(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN_OR_EQUAL, createTime);
    }

    public ShipmentRequest<T> withCreateTimeLessThan(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public ShipmentRequest<T> withCreateTimeLessThanOrEqualTo(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN_OR_EQUAL, createTime);
    }

    public ShipmentRequest<T> withCreateTimeBetween(LocalDateTime startOfCreateTime, LocalDateTime endOfCreateTime){
       return withCreateTime(Operator.BETWEEN, startOfCreateTime, endOfCreateTime);
    }
    public ShipmentRequest<T> withCreateTimeBefore(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public ShipmentRequest<T> withCreateTimeBefore(Date createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public ShipmentRequest<T> withCreateTimeAfter(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public ShipmentRequest<T> withCreateTimeAfter(Date createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public ShipmentRequest<T> withCreateTimeBetween(Date startOfCreateTime, Date endOfCreateTime){
       return withCreateTime(Operator.BETWEEN, startOfCreateTime, endOfCreateTime);
    }




    public ShipmentRequest<T> filterByUpdateTime(LocalDateTime... updateTime){
      if (updateTime == null || updateTime.length == 0) {
        throw new IllegalArgumentException("filterByUpdateTime parameter updateTime cannot be empty");
      }
      return appendSearchCriteria(createUpdateTimeCriteria(Operator.EQUAL, (Object[])updateTime));
    }

    public ShipmentRequest<T> withUpdateTime(Operator operator, Object... values){
       return appendSearchCriteria(createUpdateTimeCriteria(operator, values));
    }

    public ShipmentRequest<T> withUpdateTimeIsUnknown(){
       return withUpdateTime(Operator.IS_NULL);
    }

    public ShipmentRequest<T> withUpdateTimeIsKnown(){
       return withUpdateTime(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createUpdateTimeCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Shipment.UPDATE_TIME_PROPERTY, operator, values);
    }

    public ShipmentRequest<T> withUpdateTimeGreaterThan(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public ShipmentRequest<T> withUpdateTimeGreaterThanOrEqualTo(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN_OR_EQUAL, updateTime);
    }

    public ShipmentRequest<T> withUpdateTimeLessThan(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public ShipmentRequest<T> withUpdateTimeLessThanOrEqualTo(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN_OR_EQUAL, updateTime);
    }

    public ShipmentRequest<T> withUpdateTimeBetween(LocalDateTime startOfUpdateTime, LocalDateTime endOfUpdateTime){
       return withUpdateTime(Operator.BETWEEN, startOfUpdateTime, endOfUpdateTime);
    }
    public ShipmentRequest<T> withUpdateTimeBefore(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public ShipmentRequest<T> withUpdateTimeBefore(Date updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public ShipmentRequest<T> withUpdateTimeAfter(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public ShipmentRequest<T> withUpdateTimeAfter(Date updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public ShipmentRequest<T> withUpdateTimeBetween(Date startOfUpdateTime, Date endOfUpdateTime){
       return withUpdateTime(Operator.BETWEEN, startOfUpdateTime, endOfUpdateTime);
    }




    public ShipmentRequest<T> filterByVersion(Long... version){
      if (version == null || version.length == 0) {
        throw new IllegalArgumentException("filterByVersion parameter version cannot be empty");
      }
      return appendSearchCriteria(createVersionCriteria(Operator.EQUAL, (Object[])version));
    }

    public ShipmentRequest<T> withVersion(Operator operator, Object... values){
       return appendSearchCriteria(createVersionCriteria(operator, values));
    }

    public ShipmentRequest<T> withVersionIsUnknown(){
       return withVersion(Operator.IS_NULL);
    }

    public ShipmentRequest<T> withVersionIsKnown(){
       return withVersion(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createVersionCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Shipment.VERSION_PROPERTY, operator, values);
    }

    public ShipmentRequest<T> withVersionGreaterThan(Long version){
       return withVersion(Operator.GREATER_THAN, version);
    }

    public ShipmentRequest<T> withVersionGreaterThanOrEqualTo(Long version){
       return withVersion(Operator.GREATER_THAN_OR_EQUAL, version);
    }

    public ShipmentRequest<T> withVersionLessThan(Long version){
       return withVersion(Operator.LESS_THAN, version);
    }

    public ShipmentRequest<T> withVersionLessThanOrEqualTo(Long version){
       return withVersion(Operator.LESS_THAN_OR_EQUAL, version);
    }

    public ShipmentRequest<T> withVersionBetween(Long startOfVersion, Long endOfVersion){
       return withVersion(Operator.BETWEEN, startOfVersion, endOfVersion);
    }

    public ShipmentRequest<T> withDeliveryListMatching(DeliveryRequest deliveryRequest){
        return appendSearchCriteria(new SubQuerySearchCriteria(Shipment.ID_PROPERTY, deliveryRequest, Delivery.SHIPMENT_PROPERTY));
    }

    public ShipmentRequest<T> withoutDeliveryListMatching(DeliveryRequest deliveryRequest){
        return appendSearchCriteria(SearchCriteria.not(new SubQuerySearchCriteria(Shipment.ID_PROPERTY, deliveryRequest, Delivery.SHIPMENT_PROPERTY)));
    }

    public ShipmentRequest<T> haveDeliveries(){
        return withDeliveryListMatching(Q.deliveries().unlimited());
    }

    public ShipmentRequest<T> haveNoDeliveries(){
        return withoutDeliveryListMatching(Q.deliveries().unlimited());
    }

    public ShipmentRequest<T> count(){
        super.count();
        return this;
    }
    public ShipmentRequest<T> countAs(String retName){
        super.count(retName);
        return this;
    }
    public ShipmentRequest<T> groupByGlobalOrderWithDetails(){
       return groupByGlobalOrderWithDetails(Q.globalOrders().unlimited());
    }

    public ShipmentRequest<T> groupByGlobalOrderWithDetails(GlobalOrderRequest subRequest){
       aggregate(Shipment.GLOBAL_ORDER_PROPERTY, subRequest);
       return this;
    }



    public ShipmentRequest<T> groupByWarehouseWithDetails(){
       return groupByWarehouseWithDetails(Q.warehouses().unlimited());
    }

    public ShipmentRequest<T> groupByWarehouseWithDetails(WarehouseRequest subRequest){
       aggregate(Shipment.WAREHOUSE_PROPERTY, subRequest);
       return this;
    }




    public ShipmentRequest<T> groupByDeliveriesWithDetails(DeliveryRequest subRequest){
       aggregate(Shipment.DELIVERY_LIST_PROPERTY, subRequest);
       return this;
    }

    public ShipmentRequest<T> groupById(){
       groupBy(Shipment.ID_PROPERTY);
       return this;
    }

    public ShipmentRequest<T> groupByIdAs(String retName){
       groupBy(retName, Shipment.ID_PROPERTY);
       return this;
    }

    public ShipmentRequest<T> groupByIdWithFunction(String retName, AggrFunction function){
       groupBy(retName, Shipment.ID_PROPERTY, function);
       return this;
    }

    public ShipmentRequest<T> groupByShippedDate(){
       groupBy(Shipment.SHIPPED_DATE_PROPERTY);
       return this;
    }

    public ShipmentRequest<T> groupByShippedDateAs(String retName){
       groupBy(retName, Shipment.SHIPPED_DATE_PROPERTY);
       return this;
    }

    public ShipmentRequest<T> groupByShippedDateWithFunction(String retName, AggrFunction function){
       groupBy(retName, Shipment.SHIPPED_DATE_PROPERTY, function);
       return this;
    }

    public ShipmentRequest<T> groupByCarrier(){
       groupBy(Shipment.CARRIER_PROPERTY);
       return this;
    }

    public ShipmentRequest<T> groupByCarrierAs(String retName){
       groupBy(retName, Shipment.CARRIER_PROPERTY);
       return this;
    }

    public ShipmentRequest<T> groupByCarrierWithFunction(String retName, AggrFunction function){
       groupBy(retName, Shipment.CARRIER_PROPERTY, function);
       return this;
    }
    public ShipmentRequest<T> groupByGlobalOrderWith(GlobalOrderRequest subRequest){
       groupBy(Shipment.GLOBAL_ORDER_PROPERTY, subRequest);
       return this;
    }
    public ShipmentRequest<T> groupByGlobalOrder(){
       groupBy(Shipment.GLOBAL_ORDER_PROPERTY);
       return this;
    }

    public ShipmentRequest<T> groupByGlobalOrderAs(String retName){
       groupBy(retName, Shipment.GLOBAL_ORDER_PROPERTY);
       return this;
    }

    public ShipmentRequest<T> groupByGlobalOrderWithFunction(String retName, AggrFunction function){
       groupBy(retName, Shipment.GLOBAL_ORDER_PROPERTY, function);
       return this;
    }

    public ShipmentRequest<T> groupByStatus(){
       groupBy(Shipment.STATUS_PROPERTY);
       return this;
    }

    public ShipmentRequest<T> groupByStatusAs(String retName){
       groupBy(retName, Shipment.STATUS_PROPERTY);
       return this;
    }

    public ShipmentRequest<T> groupByStatusWithFunction(String retName, AggrFunction function){
       groupBy(retName, Shipment.STATUS_PROPERTY, function);
       return this;
    }

    public ShipmentRequest<T> groupByTrackingNumber(){
       groupBy(Shipment.TRACKING_NUMBER_PROPERTY);
       return this;
    }

    public ShipmentRequest<T> groupByTrackingNumberAs(String retName){
       groupBy(retName, Shipment.TRACKING_NUMBER_PROPERTY);
       return this;
    }

    public ShipmentRequest<T> groupByTrackingNumberWithFunction(String retName, AggrFunction function){
       groupBy(retName, Shipment.TRACKING_NUMBER_PROPERTY, function);
       return this;
    }
    public ShipmentRequest<T> groupByWarehouseWith(WarehouseRequest subRequest){
       groupBy(Shipment.WAREHOUSE_PROPERTY, subRequest);
       return this;
    }
    public ShipmentRequest<T> groupByWarehouse(){
       groupBy(Shipment.WAREHOUSE_PROPERTY);
       return this;
    }

    public ShipmentRequest<T> groupByWarehouseAs(String retName){
       groupBy(retName, Shipment.WAREHOUSE_PROPERTY);
       return this;
    }

    public ShipmentRequest<T> groupByWarehouseWithFunction(String retName, AggrFunction function){
       groupBy(retName, Shipment.WAREHOUSE_PROPERTY, function);
       return this;
    }

    public ShipmentRequest<T> groupByCreateTime(){
       groupBy(Shipment.CREATE_TIME_PROPERTY);
       return this;
    }

    public ShipmentRequest<T> groupByCreateTimeAs(String retName){
       groupBy(retName, Shipment.CREATE_TIME_PROPERTY);
       return this;
    }

    public ShipmentRequest<T> groupByCreateTimeWithFunction(String retName, AggrFunction function){
       groupBy(retName, Shipment.CREATE_TIME_PROPERTY, function);
       return this;
    }

    public ShipmentRequest<T> groupByUpdateTime(){
       groupBy(Shipment.UPDATE_TIME_PROPERTY);
       return this;
    }

    public ShipmentRequest<T> groupByUpdateTimeAs(String retName){
       groupBy(retName, Shipment.UPDATE_TIME_PROPERTY);
       return this;
    }

    public ShipmentRequest<T> groupByUpdateTimeWithFunction(String retName, AggrFunction function){
       groupBy(retName, Shipment.UPDATE_TIME_PROPERTY, function);
       return this;
    }

    public ShipmentRequest<T> groupByVersion(){
       groupBy(Shipment.VERSION_PROPERTY);
       return this;
    }

    public ShipmentRequest<T> groupByVersionAs(String retName){
       groupBy(retName, Shipment.VERSION_PROPERTY);
       return this;
    }

    public ShipmentRequest<T> groupByVersionWithFunction(String retName, AggrFunction function){
       groupBy(retName, Shipment.VERSION_PROPERTY, function);
       return this;
    }



    public ShipmentRequest<T> orderByIdAscending(){
       addOrderByAscending(Shipment.ID_PROPERTY);
       return this;
    }

    public ShipmentRequest<T> orderByIdDescending(){
       addOrderByDescending(Shipment.ID_PROPERTY);
       return this;
    }

    public ShipmentRequest<T> orderByShippedDateAscending(){
       addOrderByAscending(Shipment.SHIPPED_DATE_PROPERTY);
       return this;
    }

    public ShipmentRequest<T> orderByShippedDateDescending(){
       addOrderByDescending(Shipment.SHIPPED_DATE_PROPERTY);
       return this;
    }

    public ShipmentRequest<T> orderByCarrierAscending(){
       addOrderByAscending(Shipment.CARRIER_PROPERTY);
       return this;
    }

    public ShipmentRequest<T> orderByCarrierDescending(){
       addOrderByDescending(Shipment.CARRIER_PROPERTY);
       return this;
    }
    public ShipmentRequest<T> orderByCarrierAscendingUsingGBK(){
       addOrderByAscendingUsingGBK(Shipment.CARRIER_PROPERTY);
       return this;
    }

    public ShipmentRequest<T> orderByCarrierDescendingUsingGBK(){
       addOrderByDescendingUsingGBK(Shipment.CARRIER_PROPERTY);
       return this;
    }
    public ShipmentRequest<T> orderByGlobalOrderAscending(){
       addOrderByAscending(Shipment.GLOBAL_ORDER_PROPERTY);
       return this;
    }

    public ShipmentRequest<T> orderByGlobalOrderDescending(){
       addOrderByDescending(Shipment.GLOBAL_ORDER_PROPERTY);
       return this;
    }

    public ShipmentRequest<T> orderByStatusAscending(){
       addOrderByAscending(Shipment.STATUS_PROPERTY);
       return this;
    }

    public ShipmentRequest<T> orderByStatusDescending(){
       addOrderByDescending(Shipment.STATUS_PROPERTY);
       return this;
    }
    public ShipmentRequest<T> orderByStatusAscendingUsingGBK(){
       addOrderByAscendingUsingGBK(Shipment.STATUS_PROPERTY);
       return this;
    }

    public ShipmentRequest<T> orderByStatusDescendingUsingGBK(){
       addOrderByDescendingUsingGBK(Shipment.STATUS_PROPERTY);
       return this;
    }
    public ShipmentRequest<T> orderByTrackingNumberAscending(){
       addOrderByAscending(Shipment.TRACKING_NUMBER_PROPERTY);
       return this;
    }

    public ShipmentRequest<T> orderByTrackingNumberDescending(){
       addOrderByDescending(Shipment.TRACKING_NUMBER_PROPERTY);
       return this;
    }
    public ShipmentRequest<T> orderByTrackingNumberAscendingUsingGBK(){
       addOrderByAscendingUsingGBK(Shipment.TRACKING_NUMBER_PROPERTY);
       return this;
    }

    public ShipmentRequest<T> orderByTrackingNumberDescendingUsingGBK(){
       addOrderByDescendingUsingGBK(Shipment.TRACKING_NUMBER_PROPERTY);
       return this;
    }
    public ShipmentRequest<T> orderByWarehouseAscending(){
       addOrderByAscending(Shipment.WAREHOUSE_PROPERTY);
       return this;
    }

    public ShipmentRequest<T> orderByWarehouseDescending(){
       addOrderByDescending(Shipment.WAREHOUSE_PROPERTY);
       return this;
    }

    public ShipmentRequest<T> orderByCreateTimeAscending(){
       addOrderByAscending(Shipment.CREATE_TIME_PROPERTY);
       return this;
    }

    public ShipmentRequest<T> orderByCreateTimeDescending(){
       addOrderByDescending(Shipment.CREATE_TIME_PROPERTY);
       return this;
    }

    public ShipmentRequest<T> orderByUpdateTimeAscending(){
       addOrderByAscending(Shipment.UPDATE_TIME_PROPERTY);
       return this;
    }

    public ShipmentRequest<T> orderByUpdateTimeDescending(){
       addOrderByDescending(Shipment.UPDATE_TIME_PROPERTY);
       return this;
    }

    public ShipmentRequest<T> orderByVersionAscending(){
       addOrderByAscending(Shipment.VERSION_PROPERTY);
       return this;
    }

    public ShipmentRequest<T> orderByVersionDescending(){
       addOrderByDescending(Shipment.VERSION_PROPERTY);
       return this;
    }


    public ShipmentRequest<T> statsFromDeliveriesAs(String name, DeliveryRequest subRequest){
       return statsFromDeliveriesAs(name, subRequest, false);
    }

    public ShipmentRequest<T> statsFromDeliveriesAs(String name, DeliveryRequest subRequest, boolean singleResult){
       subRequest.setPartitionProperty(Delivery.SHIPMENT_PROPERTY);
       addAggregateDynamicProperty(name, subRequest, singleResult);
       return this;
    }

    public ShipmentRequest<T> statsFromDeliveries(DeliveryRequest subRequest){
       return statsFromDeliveriesAs(REFINEMENTS, subRequest);
    }
    public GlobalOrderRequest rollUpToGlobalOrder(){
       GlobalOrderRequest globalOrder = Q.globalOrders().unlimited();
       this.withGlobalOrderMatching(globalOrder)
           .groupByGlobalOrderWith(globalOrder);
       return globalOrder;
    }



    public WarehouseRequest rollUpToWarehouse(){
       WarehouseRequest warehouse = Q.warehouses().unlimited();
       this.withWarehouseMatching(warehouse)
           .groupByWarehouseWith(warehouse);
       return warehouse;
    }




    public ShipmentRequest<T> countDeliveries(){
        return countDeliveriesAs("Count");
    }

    public ShipmentRequest<T> countDeliveriesAs(String name){
        return countDeliveriesWith(name, Q.deliveries().unlimited());
    }

    public ShipmentRequest<T> countDeliveriesWith(String name, DeliveryRequest subRequest){
        return statsFromDeliveriesAs(name, subRequest.count(), true);
    }

   public ShipmentRequest<T> facetByGlobalOrderAs(String facetName, GlobalOrderRequest globalOrder){
       return facetByGlobalOrderAs(facetName, globalOrder, true);
   }

   public ShipmentRequest<T> facetByGlobalOrderAs(String facetName, GlobalOrderRequest globalOrder, boolean includeAllFacets){
       addFacet(facetName, Shipment.GLOBAL_ORDER_PROPERTY, globalOrder, includeAllFacets);
       return this;
   }
   public ShipmentRequest<T> facetByWarehouseAs(String facetName, WarehouseRequest warehouse){
       return facetByWarehouseAs(facetName, warehouse, true);
   }

   public ShipmentRequest<T> facetByWarehouseAs(String facetName, WarehouseRequest warehouse, boolean includeAllFacets){
       addFacet(facetName, Shipment.WAREHOUSE_PROPERTY, warehouse, includeAllFacets);
       return this;
   }


    /**
     * get topN records
     * @param topN  records number
     */
    public ShipmentRequest<T> top(int topN) {
        super.top(topN);
        return this;
    }

    /**
     * get records from offset(inclusive) to offset+size(exclusive)
     * @param offset record offset
     * @param size records number
     */
    public ShipmentRequest<T> offset(int offset, int size) {
        super.offset(offset, size);
        return this;
    }

    /**
     * retrieve all records
     */
    public ShipmentRequest<T> unlimited() {
        super.unlimited();
        return this;
    }

    /**
     * get records of one page
     * @param pageNumber page number(1-based)
     * @param pageSize page size
     */
    public ShipmentRequest<T> page(int pageNumber, int pageSize) {
        int offset = (pageNumber - 1) * pageSize;
        return offset(offset, pageSize);
   }

    /**
     * get records of one page, default page size is 10
     * @param pageNumber page number(1-based)
     */
    public ShipmentRequest<T> page(int pageNumber) {
        return page(pageNumber, 10);
   }
}