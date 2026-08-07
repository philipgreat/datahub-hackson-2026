
package com.example.enterpriseerpsystem.delivery;

import com.example.enterpriseerpsystem.Q;
import com.example.enterpriseerpsystem.shipment.Shipment;
import com.example.enterpriseerpsystem.shipment.ShipmentRequest;
import io.teaql.core.AggrFunction;
import io.teaql.core.BaseRequest;
import io.teaql.core.PropertyReference;
import io.teaql.core.SearchCriteria;
import io.teaql.core.SubQuerySearchCriteria;
import io.teaql.core.criteria.Operator;
import io.teaql.core.criteria.TwoOperatorCriteria;
import java.time.LocalDateTime;
import java.util.Date;

public class DeliveryRequest<T extends Delivery> extends BaseRequest<T> {

    /**
     * @deprecated AI agents and business code must use the generated Q facade
     *             instead of constructing request builders directly.
     */
    @Deprecated
    public DeliveryRequest(Class<T> returnType){
        super(returnType);
        selectId();
        selectVersion();
    }

    public DeliveryRequest<T> comment(String comment){
         super.internalComment(comment);
         return this;
    }

    // purpose() 继承自 BaseRequest，返回 ExecutableRequest（终结方法）

    public DeliveryRequest<T> returnType(Class<? extends T> returnType){
        super.setReturnType(returnType);
        return this;
    }

    public DeliveryRequest<T> enableAggregationCache(long cacheExpiredMillis){
        super.enableAggregationCache();
        super.aggregateCacheTime(cacheExpiredMillis);
        return this;
    }

    public DeliveryRequest<T> enableAggregationCache(){
        return enableAggregationCache(0l);
    }


    public DeliveryRequest<T> propagateAggregationCache(long cacheExpiredMillis){
        super.propagateAggregationCache(cacheExpiredMillis);
        return this;
    }

    public DeliveryRequest<T> appendSearchCriteria(SearchCriteria searchCriteria){
        return (DeliveryRequest<T>)super.appendSearchCriteria(searchCriteria);
    }

    public DeliveryRequest<T> filter(String property1, Operator operator, String property2){
        return appendSearchCriteria(new TwoOperatorCriteria(operator, new PropertyReference(property1), new PropertyReference(property2)));
    }


    public DeliveryRequest<T> matchingAnyOf(DeliveryRequest delivery){
        super.internalMatchAny(delivery);
        return this;
    }

    public DeliveryRequest<T> enhanceChildrenIfNeeded(){
        return this;
    }

    public DeliveryRequest<T> withDeletedRows(){
        super.withDeletedRows();
        return this;
    }

    public DeliveryRequest<T> deletedRowsOnly(){
        super.deletedRowsOnly();
        return this;
    }

    public DeliveryRequest<T> selectSelf(){
        super.selectSelf();
        return selectId().selectRecipientSignature().selectShipmentIdOnly().selectDeliveryDate().selectStatus().selectCreateTime().selectUpdateTime().selectVersion();
    }

    public DeliveryRequest<T> selectSelfFields(){
        return selectSelf();
    }

    public DeliveryRequest<T> selectAll(){
        super.selectAll();
        return selectId().selectRecipientSignature().selectShipment().selectDeliveryDate().selectStatus().selectCreateTime().selectUpdateTime().selectVersion();
    }

    public DeliveryRequest<T> selectChildren(){
        super.selectAny();
        return selectId().selectRecipientSignature().selectShipment().selectDeliveryDate().selectStatus().selectCreateTime().selectUpdateTime().selectVersion();
    }


    public DeliveryRequest<T> selectId(){
       selectProperty(Delivery.ID_PROPERTY);
       return this;
    }

    /**
     * fill the id with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  id) to fetch id property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public DeliveryRequest<T> unselectId(){
       unselectProperty(Delivery.ID_PROPERTY);
       return this;
    }
    public DeliveryRequest<T> selectRecipientSignature(){
       selectProperty(Delivery.RECIPIENT_SIGNATURE_PROPERTY);
       return this;
    }

    /**
     * fill the recipientSignature with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  recipientSignature) to fetch recipientSignature property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public DeliveryRequest<T> unselectRecipientSignature(){
       unselectProperty(Delivery.RECIPIENT_SIGNATURE_PROPERTY);
       return this;
    }
    public DeliveryRequest<T> selectShipmentIdOnly(){
       selectProperty(Delivery.SHIPMENT_PROPERTY);
       return this;
    }

    public DeliveryRequest<T> selectShipment(){
        return selectShipmentWith(Q.shipments().unlimited().selectSelf());
    }

    public DeliveryRequest<T> selectShipmentWith(ShipmentRequest shipment){
       selectProperty(Delivery.SHIPMENT_PROPERTY);
       enhanceRelation(Delivery.SHIPMENT_PROPERTY, shipment);
       return this;
    }

    public DeliveryRequest<T> unselectShipment(){
       unselectProperty(Delivery.SHIPMENT_PROPERTY);
       return this;
    }
    public DeliveryRequest<T> selectDeliveryDate(){
       selectProperty(Delivery.DELIVERY_DATE_PROPERTY);
       return this;
    }

    /**
     * fill the deliveryDate with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  deliveryDate) to fetch deliveryDate property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public DeliveryRequest<T> unselectDeliveryDate(){
       unselectProperty(Delivery.DELIVERY_DATE_PROPERTY);
       return this;
    }
    public DeliveryRequest<T> selectStatus(){
       selectProperty(Delivery.STATUS_PROPERTY);
       return this;
    }

    /**
     * fill the status with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  status) to fetch status property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public DeliveryRequest<T> unselectStatus(){
       unselectProperty(Delivery.STATUS_PROPERTY);
       return this;
    }
    public DeliveryRequest<T> selectCreateTime(){
       selectProperty(Delivery.CREATE_TIME_PROPERTY);
       return this;
    }

    /**
     * fill the createTime with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  createTime) to fetch createTime property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public DeliveryRequest<T> unselectCreateTime(){
       unselectProperty(Delivery.CREATE_TIME_PROPERTY);
       return this;
    }
    public DeliveryRequest<T> selectUpdateTime(){
       selectProperty(Delivery.UPDATE_TIME_PROPERTY);
       return this;
    }

    /**
     * fill the updateTime with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  updateTime) to fetch updateTime property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public DeliveryRequest<T> unselectUpdateTime(){
       unselectProperty(Delivery.UPDATE_TIME_PROPERTY);
       return this;
    }
    public DeliveryRequest<T> selectVersion(){
       selectProperty(Delivery.VERSION_PROPERTY);
       return this;
    }

    /**
     * fill the version with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  version) to fetch version property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public DeliveryRequest<T> unselectVersion(){
       unselectProperty(Delivery.VERSION_PROPERTY);
       return this;
    }

    public DeliveryRequest<T> withId(Operator operator, Object... values){
       return appendSearchCriteria(createIdCriteria(operator, values));
    }

    public SearchCriteria createIdCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Delivery.ID_PROPERTY, operator, values);
    }

    public DeliveryRequest<T> withIdIs(Long id){
       return withId(Operator.EQUAL, id);
    }
    public DeliveryRequest<T> withIdIn(Long... id){
       return withId(Operator.EQUAL, (Object[])id);
    }



    public DeliveryRequest<T> filterByRecipientSignature(String... recipientSignature){
      if (recipientSignature == null || recipientSignature.length == 0) {
        throw new IllegalArgumentException("filterByRecipientSignature parameter recipientSignature cannot be empty");
      }
      return appendSearchCriteria(createRecipientSignatureCriteria(Operator.EQUAL, (Object[])recipientSignature));
    }

    public DeliveryRequest<T> withRecipientSignature(Operator operator, Object... values){
       return appendSearchCriteria(createRecipientSignatureCriteria(operator, values));
    }

    public DeliveryRequest<T> withRecipientSignatureIsUnknown(){
       return withRecipientSignature(Operator.IS_NULL);
    }

    public DeliveryRequest<T> withRecipientSignatureIsKnown(){
       return withRecipientSignature(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createRecipientSignatureCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Delivery.RECIPIENT_SIGNATURE_PROPERTY, operator, values);
    }

    public DeliveryRequest<T> withRecipientSignatureGreaterThan(String recipientSignature){
       return withRecipientSignature(Operator.GREATER_THAN, recipientSignature);
    }

    public DeliveryRequest<T> withRecipientSignatureGreaterThanOrEqualTo(String recipientSignature){
       return withRecipientSignature(Operator.GREATER_THAN_OR_EQUAL, recipientSignature);
    }

    public DeliveryRequest<T> withRecipientSignatureLessThan(String recipientSignature){
       return withRecipientSignature(Operator.LESS_THAN, recipientSignature);
    }

    public DeliveryRequest<T> withRecipientSignatureLessThanOrEqualTo(String recipientSignature){
       return withRecipientSignature(Operator.LESS_THAN_OR_EQUAL, recipientSignature);
    }

    public DeliveryRequest<T> withRecipientSignatureBetween(String startOfRecipientSignature, String endOfRecipientSignature){
       return withRecipientSignature(Operator.BETWEEN, startOfRecipientSignature, endOfRecipientSignature);
    }
    public DeliveryRequest<T> withRecipientSignatureStartingWith(String recipientSignature){
       return withRecipientSignature(Operator.BEGIN_WITH, recipientSignature);
    }
    public DeliveryRequest<T> withRecipientSignatureContaining(String recipientSignature){
       return withRecipientSignature(Operator.CONTAIN, recipientSignature);
    }

    public DeliveryRequest<T> withRecipientSignatureEndingWith(String recipientSignature){
       return withRecipientSignature(Operator.END_WITH, recipientSignature);
    }

    public DeliveryRequest<T> withRecipientSignatureIs(String recipientSignature){
       return withRecipientSignature(Operator.EQUAL, recipientSignature);
    }

    public DeliveryRequest<T> withRecipientSignatureSoundingLike(String recipientSignature){
       return withRecipientSignature(Operator.SOUNDS_LIKE, recipientSignature);
    }



    public DeliveryRequest<T> filterByShipment(Shipment... shipment){
      if (shipment == null || shipment.length == 0) {
        throw new IllegalArgumentException("filterByShipment parameter shipment cannot be empty");
      }
      return appendSearchCriteria(createShipmentCriteria(Operator.EQUAL, (Object[])shipment));
    }

    public DeliveryRequest<T> withShipment(Operator operator, Object... values){
       return appendSearchCriteria(createShipmentCriteria(operator, values));
    }

    public DeliveryRequest<T> withShipmentIsUnknown(){
       return withShipment(Operator.IS_NULL);
    }

    public DeliveryRequest<T> withShipmentIsKnown(){
       return withShipment(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createShipmentCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Delivery.SHIPMENT_PROPERTY, operator, values);
    }

    public DeliveryRequest<T> filterByShipment(Long shipment){
      if(shipment == null){
         return this;
      }
      return withShipment(Operator.EQUAL, shipment);
    }
    public DeliveryRequest<T> withShipmentMatching(ShipmentRequest shipment){
       return appendSearchCriteria(new SubQuerySearchCriteria(Delivery.SHIPMENT_PROPERTY, shipment, Shipment.ID_PROPERTY));
    }

    public DeliveryRequest<T> filterByDeliveryDate(LocalDateTime... deliveryDate){
      if (deliveryDate == null || deliveryDate.length == 0) {
        throw new IllegalArgumentException("filterByDeliveryDate parameter deliveryDate cannot be empty");
      }
      return appendSearchCriteria(createDeliveryDateCriteria(Operator.EQUAL, (Object[])deliveryDate));
    }

    public DeliveryRequest<T> withDeliveryDate(Operator operator, Object... values){
       return appendSearchCriteria(createDeliveryDateCriteria(operator, values));
    }

    public DeliveryRequest<T> withDeliveryDateIsUnknown(){
       return withDeliveryDate(Operator.IS_NULL);
    }

    public DeliveryRequest<T> withDeliveryDateIsKnown(){
       return withDeliveryDate(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createDeliveryDateCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Delivery.DELIVERY_DATE_PROPERTY, operator, values);
    }

    public DeliveryRequest<T> withDeliveryDateGreaterThan(LocalDateTime deliveryDate){
       return withDeliveryDate(Operator.GREATER_THAN, deliveryDate);
    }

    public DeliveryRequest<T> withDeliveryDateGreaterThanOrEqualTo(LocalDateTime deliveryDate){
       return withDeliveryDate(Operator.GREATER_THAN_OR_EQUAL, deliveryDate);
    }

    public DeliveryRequest<T> withDeliveryDateLessThan(LocalDateTime deliveryDate){
       return withDeliveryDate(Operator.LESS_THAN, deliveryDate);
    }

    public DeliveryRequest<T> withDeliveryDateLessThanOrEqualTo(LocalDateTime deliveryDate){
       return withDeliveryDate(Operator.LESS_THAN_OR_EQUAL, deliveryDate);
    }

    public DeliveryRequest<T> withDeliveryDateBetween(LocalDateTime startOfDeliveryDate, LocalDateTime endOfDeliveryDate){
       return withDeliveryDate(Operator.BETWEEN, startOfDeliveryDate, endOfDeliveryDate);
    }
    public DeliveryRequest<T> withDeliveryDateBefore(LocalDateTime deliveryDate){
       return withDeliveryDate(Operator.LESS_THAN, deliveryDate);
    }

    public DeliveryRequest<T> withDeliveryDateBefore(Date deliveryDate){
       return withDeliveryDate(Operator.LESS_THAN, deliveryDate);
    }

    public DeliveryRequest<T> withDeliveryDateAfter(LocalDateTime deliveryDate){
       return withDeliveryDate(Operator.GREATER_THAN, deliveryDate);
    }

    public DeliveryRequest<T> withDeliveryDateAfter(Date deliveryDate){
       return withDeliveryDate(Operator.GREATER_THAN, deliveryDate);
    }

    public DeliveryRequest<T> withDeliveryDateBetween(Date startOfDeliveryDate, Date endOfDeliveryDate){
       return withDeliveryDate(Operator.BETWEEN, startOfDeliveryDate, endOfDeliveryDate);
    }




    public DeliveryRequest<T> filterByStatus(String... status){
      if (status == null || status.length == 0) {
        throw new IllegalArgumentException("filterByStatus parameter status cannot be empty");
      }
      return appendSearchCriteria(createStatusCriteria(Operator.EQUAL, (Object[])status));
    }

    public DeliveryRequest<T> withStatus(Operator operator, Object... values){
       return appendSearchCriteria(createStatusCriteria(operator, values));
    }

    public DeliveryRequest<T> withStatusIsUnknown(){
       return withStatus(Operator.IS_NULL);
    }

    public DeliveryRequest<T> withStatusIsKnown(){
       return withStatus(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createStatusCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Delivery.STATUS_PROPERTY, operator, values);
    }

    public DeliveryRequest<T> withStatusGreaterThan(String status){
       return withStatus(Operator.GREATER_THAN, status);
    }

    public DeliveryRequest<T> withStatusGreaterThanOrEqualTo(String status){
       return withStatus(Operator.GREATER_THAN_OR_EQUAL, status);
    }

    public DeliveryRequest<T> withStatusLessThan(String status){
       return withStatus(Operator.LESS_THAN, status);
    }

    public DeliveryRequest<T> withStatusLessThanOrEqualTo(String status){
       return withStatus(Operator.LESS_THAN_OR_EQUAL, status);
    }

    public DeliveryRequest<T> withStatusBetween(String startOfStatus, String endOfStatus){
       return withStatus(Operator.BETWEEN, startOfStatus, endOfStatus);
    }
    public DeliveryRequest<T> withStatusStartingWith(String status){
       return withStatus(Operator.BEGIN_WITH, status);
    }
    public DeliveryRequest<T> withStatusContaining(String status){
       return withStatus(Operator.CONTAIN, status);
    }

    public DeliveryRequest<T> withStatusEndingWith(String status){
       return withStatus(Operator.END_WITH, status);
    }

    public DeliveryRequest<T> withStatusIs(String status){
       return withStatus(Operator.EQUAL, status);
    }

    public DeliveryRequest<T> withStatusSoundingLike(String status){
       return withStatus(Operator.SOUNDS_LIKE, status);
    }



    public DeliveryRequest<T> filterByCreateTime(LocalDateTime... createTime){
      if (createTime == null || createTime.length == 0) {
        throw new IllegalArgumentException("filterByCreateTime parameter createTime cannot be empty");
      }
      return appendSearchCriteria(createCreateTimeCriteria(Operator.EQUAL, (Object[])createTime));
    }

    public DeliveryRequest<T> withCreateTime(Operator operator, Object... values){
       return appendSearchCriteria(createCreateTimeCriteria(operator, values));
    }

    public DeliveryRequest<T> withCreateTimeIsUnknown(){
       return withCreateTime(Operator.IS_NULL);
    }

    public DeliveryRequest<T> withCreateTimeIsKnown(){
       return withCreateTime(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createCreateTimeCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Delivery.CREATE_TIME_PROPERTY, operator, values);
    }

    public DeliveryRequest<T> withCreateTimeGreaterThan(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public DeliveryRequest<T> withCreateTimeGreaterThanOrEqualTo(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN_OR_EQUAL, createTime);
    }

    public DeliveryRequest<T> withCreateTimeLessThan(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public DeliveryRequest<T> withCreateTimeLessThanOrEqualTo(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN_OR_EQUAL, createTime);
    }

    public DeliveryRequest<T> withCreateTimeBetween(LocalDateTime startOfCreateTime, LocalDateTime endOfCreateTime){
       return withCreateTime(Operator.BETWEEN, startOfCreateTime, endOfCreateTime);
    }
    public DeliveryRequest<T> withCreateTimeBefore(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public DeliveryRequest<T> withCreateTimeBefore(Date createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public DeliveryRequest<T> withCreateTimeAfter(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public DeliveryRequest<T> withCreateTimeAfter(Date createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public DeliveryRequest<T> withCreateTimeBetween(Date startOfCreateTime, Date endOfCreateTime){
       return withCreateTime(Operator.BETWEEN, startOfCreateTime, endOfCreateTime);
    }




    public DeliveryRequest<T> filterByUpdateTime(LocalDateTime... updateTime){
      if (updateTime == null || updateTime.length == 0) {
        throw new IllegalArgumentException("filterByUpdateTime parameter updateTime cannot be empty");
      }
      return appendSearchCriteria(createUpdateTimeCriteria(Operator.EQUAL, (Object[])updateTime));
    }

    public DeliveryRequest<T> withUpdateTime(Operator operator, Object... values){
       return appendSearchCriteria(createUpdateTimeCriteria(operator, values));
    }

    public DeliveryRequest<T> withUpdateTimeIsUnknown(){
       return withUpdateTime(Operator.IS_NULL);
    }

    public DeliveryRequest<T> withUpdateTimeIsKnown(){
       return withUpdateTime(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createUpdateTimeCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Delivery.UPDATE_TIME_PROPERTY, operator, values);
    }

    public DeliveryRequest<T> withUpdateTimeGreaterThan(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public DeliveryRequest<T> withUpdateTimeGreaterThanOrEqualTo(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN_OR_EQUAL, updateTime);
    }

    public DeliveryRequest<T> withUpdateTimeLessThan(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public DeliveryRequest<T> withUpdateTimeLessThanOrEqualTo(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN_OR_EQUAL, updateTime);
    }

    public DeliveryRequest<T> withUpdateTimeBetween(LocalDateTime startOfUpdateTime, LocalDateTime endOfUpdateTime){
       return withUpdateTime(Operator.BETWEEN, startOfUpdateTime, endOfUpdateTime);
    }
    public DeliveryRequest<T> withUpdateTimeBefore(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public DeliveryRequest<T> withUpdateTimeBefore(Date updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public DeliveryRequest<T> withUpdateTimeAfter(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public DeliveryRequest<T> withUpdateTimeAfter(Date updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public DeliveryRequest<T> withUpdateTimeBetween(Date startOfUpdateTime, Date endOfUpdateTime){
       return withUpdateTime(Operator.BETWEEN, startOfUpdateTime, endOfUpdateTime);
    }




    public DeliveryRequest<T> filterByVersion(Long... version){
      if (version == null || version.length == 0) {
        throw new IllegalArgumentException("filterByVersion parameter version cannot be empty");
      }
      return appendSearchCriteria(createVersionCriteria(Operator.EQUAL, (Object[])version));
    }

    public DeliveryRequest<T> withVersion(Operator operator, Object... values){
       return appendSearchCriteria(createVersionCriteria(operator, values));
    }

    public DeliveryRequest<T> withVersionIsUnknown(){
       return withVersion(Operator.IS_NULL);
    }

    public DeliveryRequest<T> withVersionIsKnown(){
       return withVersion(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createVersionCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Delivery.VERSION_PROPERTY, operator, values);
    }

    public DeliveryRequest<T> withVersionGreaterThan(Long version){
       return withVersion(Operator.GREATER_THAN, version);
    }

    public DeliveryRequest<T> withVersionGreaterThanOrEqualTo(Long version){
       return withVersion(Operator.GREATER_THAN_OR_EQUAL, version);
    }

    public DeliveryRequest<T> withVersionLessThan(Long version){
       return withVersion(Operator.LESS_THAN, version);
    }

    public DeliveryRequest<T> withVersionLessThanOrEqualTo(Long version){
       return withVersion(Operator.LESS_THAN_OR_EQUAL, version);
    }

    public DeliveryRequest<T> withVersionBetween(Long startOfVersion, Long endOfVersion){
       return withVersion(Operator.BETWEEN, startOfVersion, endOfVersion);
    }


    public DeliveryRequest<T> count(){
        super.count();
        return this;
    }
    public DeliveryRequest<T> countAs(String retName){
        super.count(retName);
        return this;
    }
    public DeliveryRequest<T> groupByShipmentWithDetails(){
       return groupByShipmentWithDetails(Q.shipments().unlimited());
    }

    public DeliveryRequest<T> groupByShipmentWithDetails(ShipmentRequest subRequest){
       aggregate(Delivery.SHIPMENT_PROPERTY, subRequest);
       return this;
    }







    public DeliveryRequest<T> groupById(){
       groupBy(Delivery.ID_PROPERTY);
       return this;
    }

    public DeliveryRequest<T> groupByIdAs(String retName){
       groupBy(retName, Delivery.ID_PROPERTY);
       return this;
    }

    public DeliveryRequest<T> groupByIdWithFunction(String retName, AggrFunction function){
       groupBy(retName, Delivery.ID_PROPERTY, function);
       return this;
    }

    public DeliveryRequest<T> groupByRecipientSignature(){
       groupBy(Delivery.RECIPIENT_SIGNATURE_PROPERTY);
       return this;
    }

    public DeliveryRequest<T> groupByRecipientSignatureAs(String retName){
       groupBy(retName, Delivery.RECIPIENT_SIGNATURE_PROPERTY);
       return this;
    }

    public DeliveryRequest<T> groupByRecipientSignatureWithFunction(String retName, AggrFunction function){
       groupBy(retName, Delivery.RECIPIENT_SIGNATURE_PROPERTY, function);
       return this;
    }
    public DeliveryRequest<T> groupByShipmentWith(ShipmentRequest subRequest){
       groupBy(Delivery.SHIPMENT_PROPERTY, subRequest);
       return this;
    }
    public DeliveryRequest<T> groupByShipment(){
       groupBy(Delivery.SHIPMENT_PROPERTY);
       return this;
    }

    public DeliveryRequest<T> groupByShipmentAs(String retName){
       groupBy(retName, Delivery.SHIPMENT_PROPERTY);
       return this;
    }

    public DeliveryRequest<T> groupByShipmentWithFunction(String retName, AggrFunction function){
       groupBy(retName, Delivery.SHIPMENT_PROPERTY, function);
       return this;
    }

    public DeliveryRequest<T> groupByDeliveryDate(){
       groupBy(Delivery.DELIVERY_DATE_PROPERTY);
       return this;
    }

    public DeliveryRequest<T> groupByDeliveryDateAs(String retName){
       groupBy(retName, Delivery.DELIVERY_DATE_PROPERTY);
       return this;
    }

    public DeliveryRequest<T> groupByDeliveryDateWithFunction(String retName, AggrFunction function){
       groupBy(retName, Delivery.DELIVERY_DATE_PROPERTY, function);
       return this;
    }

    public DeliveryRequest<T> groupByStatus(){
       groupBy(Delivery.STATUS_PROPERTY);
       return this;
    }

    public DeliveryRequest<T> groupByStatusAs(String retName){
       groupBy(retName, Delivery.STATUS_PROPERTY);
       return this;
    }

    public DeliveryRequest<T> groupByStatusWithFunction(String retName, AggrFunction function){
       groupBy(retName, Delivery.STATUS_PROPERTY, function);
       return this;
    }

    public DeliveryRequest<T> groupByCreateTime(){
       groupBy(Delivery.CREATE_TIME_PROPERTY);
       return this;
    }

    public DeliveryRequest<T> groupByCreateTimeAs(String retName){
       groupBy(retName, Delivery.CREATE_TIME_PROPERTY);
       return this;
    }

    public DeliveryRequest<T> groupByCreateTimeWithFunction(String retName, AggrFunction function){
       groupBy(retName, Delivery.CREATE_TIME_PROPERTY, function);
       return this;
    }

    public DeliveryRequest<T> groupByUpdateTime(){
       groupBy(Delivery.UPDATE_TIME_PROPERTY);
       return this;
    }

    public DeliveryRequest<T> groupByUpdateTimeAs(String retName){
       groupBy(retName, Delivery.UPDATE_TIME_PROPERTY);
       return this;
    }

    public DeliveryRequest<T> groupByUpdateTimeWithFunction(String retName, AggrFunction function){
       groupBy(retName, Delivery.UPDATE_TIME_PROPERTY, function);
       return this;
    }

    public DeliveryRequest<T> groupByVersion(){
       groupBy(Delivery.VERSION_PROPERTY);
       return this;
    }

    public DeliveryRequest<T> groupByVersionAs(String retName){
       groupBy(retName, Delivery.VERSION_PROPERTY);
       return this;
    }

    public DeliveryRequest<T> groupByVersionWithFunction(String retName, AggrFunction function){
       groupBy(retName, Delivery.VERSION_PROPERTY, function);
       return this;
    }



    public DeliveryRequest<T> orderByIdAscending(){
       addOrderByAscending(Delivery.ID_PROPERTY);
       return this;
    }

    public DeliveryRequest<T> orderByIdDescending(){
       addOrderByDescending(Delivery.ID_PROPERTY);
       return this;
    }

    public DeliveryRequest<T> orderByRecipientSignatureAscending(){
       addOrderByAscending(Delivery.RECIPIENT_SIGNATURE_PROPERTY);
       return this;
    }

    public DeliveryRequest<T> orderByRecipientSignatureDescending(){
       addOrderByDescending(Delivery.RECIPIENT_SIGNATURE_PROPERTY);
       return this;
    }
    public DeliveryRequest<T> orderByRecipientSignatureAscendingUsingGBK(){
       addOrderByAscendingUsingGBK(Delivery.RECIPIENT_SIGNATURE_PROPERTY);
       return this;
    }

    public DeliveryRequest<T> orderByRecipientSignatureDescendingUsingGBK(){
       addOrderByDescendingUsingGBK(Delivery.RECIPIENT_SIGNATURE_PROPERTY);
       return this;
    }
    public DeliveryRequest<T> orderByShipmentAscending(){
       addOrderByAscending(Delivery.SHIPMENT_PROPERTY);
       return this;
    }

    public DeliveryRequest<T> orderByShipmentDescending(){
       addOrderByDescending(Delivery.SHIPMENT_PROPERTY);
       return this;
    }

    public DeliveryRequest<T> orderByDeliveryDateAscending(){
       addOrderByAscending(Delivery.DELIVERY_DATE_PROPERTY);
       return this;
    }

    public DeliveryRequest<T> orderByDeliveryDateDescending(){
       addOrderByDescending(Delivery.DELIVERY_DATE_PROPERTY);
       return this;
    }

    public DeliveryRequest<T> orderByStatusAscending(){
       addOrderByAscending(Delivery.STATUS_PROPERTY);
       return this;
    }

    public DeliveryRequest<T> orderByStatusDescending(){
       addOrderByDescending(Delivery.STATUS_PROPERTY);
       return this;
    }
    public DeliveryRequest<T> orderByStatusAscendingUsingGBK(){
       addOrderByAscendingUsingGBK(Delivery.STATUS_PROPERTY);
       return this;
    }

    public DeliveryRequest<T> orderByStatusDescendingUsingGBK(){
       addOrderByDescendingUsingGBK(Delivery.STATUS_PROPERTY);
       return this;
    }
    public DeliveryRequest<T> orderByCreateTimeAscending(){
       addOrderByAscending(Delivery.CREATE_TIME_PROPERTY);
       return this;
    }

    public DeliveryRequest<T> orderByCreateTimeDescending(){
       addOrderByDescending(Delivery.CREATE_TIME_PROPERTY);
       return this;
    }

    public DeliveryRequest<T> orderByUpdateTimeAscending(){
       addOrderByAscending(Delivery.UPDATE_TIME_PROPERTY);
       return this;
    }

    public DeliveryRequest<T> orderByUpdateTimeDescending(){
       addOrderByDescending(Delivery.UPDATE_TIME_PROPERTY);
       return this;
    }

    public DeliveryRequest<T> orderByVersionAscending(){
       addOrderByAscending(Delivery.VERSION_PROPERTY);
       return this;
    }

    public DeliveryRequest<T> orderByVersionDescending(){
       addOrderByDescending(Delivery.VERSION_PROPERTY);
       return this;
    }


    public ShipmentRequest rollUpToShipment(){
       ShipmentRequest shipment = Q.shipments().unlimited();
       this.withShipmentMatching(shipment)
           .groupByShipmentWith(shipment);
       return shipment;
    }







   public DeliveryRequest<T> facetByShipmentAs(String facetName, ShipmentRequest shipment){
       return facetByShipmentAs(facetName, shipment, true);
   }

   public DeliveryRequest<T> facetByShipmentAs(String facetName, ShipmentRequest shipment, boolean includeAllFacets){
       addFacet(facetName, Delivery.SHIPMENT_PROPERTY, shipment, includeAllFacets);
       return this;
   }


    /**
     * get topN records
     * @param topN  records number
     */
    public DeliveryRequest<T> top(int topN) {
        super.top(topN);
        return this;
    }

    /**
     * get records from offset(inclusive) to offset+size(exclusive)
     * @param offset record offset
     * @param size records number
     */
    public DeliveryRequest<T> offset(int offset, int size) {
        super.offset(offset, size);
        return this;
    }

    /**
     * retrieve all records
     */
    public DeliveryRequest<T> unlimited() {
        super.unlimited();
        return this;
    }

    /**
     * get records of one page
     * @param pageNumber page number(1-based)
     * @param pageSize page size
     */
    public DeliveryRequest<T> page(int pageNumber, int pageSize) {
        int offset = (pageNumber - 1) * pageSize;
        return offset(offset, pageSize);
   }

    /**
     * get records of one page, default page size is 10
     * @param pageNumber page number(1-based)
     */
    public DeliveryRequest<T> page(int pageNumber) {
        return page(pageNumber, 10);
   }
}