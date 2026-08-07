
package com.example.enterpriseerpsystem.shipment;

import com.example.enterpriseerpsystem.delivery.Delivery;
import com.example.enterpriseerpsystem.globalorder.GlobalOrder;
import com.example.enterpriseerpsystem.warehouse.Warehouse;
import io.teaql.core.Audited;
import io.teaql.core.BaseEntity;
import io.teaql.core.EntityStatus;
import io.teaql.core.FrameworkInternal;
import io.teaql.core.RemoteInput;
import io.teaql.core.SmartList;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * [TEAQL AI WARNING]
 * TeaQL was explicitly designed to PREVENT AI hallucinations and random guessing.
 * DO NOT GUESS METHOD NAMES!
 * The methods listed below are the ONLY valid ways to interact with this entity.
 * If you encounter compilation errors (e.g., method not found), DO NOT guess another method name.
 * Read the method signatures in this file before proceeding.
 */
public class Shipment extends BaseEntity implements RemoteInput {
    public static String INTERNAL_TYPE = "Shipment";

    public static final String SHIPPED_DATE_PROPERTY = "shippedDate";
    public static final String CARRIER_PROPERTY = "carrier";
    public static final String GLOBAL_ORDER_PROPERTY = "globalOrder";
    public static final String STATUS_PROPERTY = "status";
    public static final String TRACKING_NUMBER_PROPERTY = "trackingNumber";
    public static final String WAREHOUSE_PROPERTY = "warehouse";
    public static final String CREATE_TIME_PROPERTY = "createTime";
    public static final String UPDATE_TIME_PROPERTY = "updateTime";
    public static final String DELIVERY_LIST_PROPERTY = "deliveryList";
    private LocalDateTime shippedDate;
    private String carrier;
    private GlobalOrder globalOrder;
    private String status;
    private String trackingNumber;
    private Warehouse warehouse;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private SmartList<Delivery> deliveryList;

    public LocalDateTime getShippedDate(){
        return this.shippedDate;
    }
    public String getCarrier(){
        return this.carrier;
    }
    public GlobalOrder getGlobalOrder(){
        return this.globalOrder;
    }
    public String getStatus(){
        return this.status;
    }
    public String getTrackingNumber(){
        return this.trackingNumber;
    }
    public Warehouse getWarehouse(){
        return this.warehouse;
    }
    public LocalDateTime getCreateTime(){
        return this.createTime;
    }
    public LocalDateTime getUpdateTime(){
        return this.updateTime;
    }
    public SmartList<Delivery> getDeliveryList(){
        return this.deliveryList;
    }
    public Shipment updateShippedDate(LocalDateTime shippedDate){
        if(Objects.equals(this.shippedDate, shippedDate)){
            return this;
        }
        handleUpdate(SHIPPED_DATE_PROPERTY, getShippedDate(), shippedDate);
        this.shippedDate = shippedDate;
        return this;
    }
    public Shipment updateCarrier(String carrier){
        carrier = (carrier == null ? null : carrier.trim());
        if(Objects.equals(this.carrier, carrier)){
            return this;
        }
        handleUpdate(CARRIER_PROPERTY, getCarrier(), carrier);
        this.carrier = carrier;
        return this;
    }
    public Shipment updateGlobalOrder(GlobalOrder globalOrder){
        if(Objects.equals(this.globalOrder, globalOrder)){
            return this;
        }
        handleUpdate(GLOBAL_ORDER_PROPERTY, getGlobalOrder(), globalOrder);
        this.globalOrder = globalOrder;
        return this;
    }
    public Shipment updateStatus(String status){
        status = (status == null ? null : status.trim());
        if(Objects.equals(this.status, status)){
            return this;
        }
        handleUpdate(STATUS_PROPERTY, getStatus(), status);
        this.status = status;
        return this;
    }
    public Shipment updateTrackingNumber(String trackingNumber){
        trackingNumber = (trackingNumber == null ? null : trackingNumber.trim());
        if(Objects.equals(this.trackingNumber, trackingNumber)){
            return this;
        }
        handleUpdate(TRACKING_NUMBER_PROPERTY, getTrackingNumber(), trackingNumber);
        this.trackingNumber = trackingNumber;
        return this;
    }
    public Shipment updateWarehouse(Warehouse warehouse){
        if(Objects.equals(this.warehouse, warehouse)){
            return this;
        }
        handleUpdate(WAREHOUSE_PROPERTY, getWarehouse(), warehouse);
        this.warehouse = warehouse;
        return this;
    }
    public Shipment updateCreateTime(LocalDateTime createTime){
        if(Objects.equals(this.createTime, createTime)){
            return this;
        }
        handleUpdate(CREATE_TIME_PROPERTY, getCreateTime(), createTime);
        this.createTime = createTime;
        return this;
    }
    public Shipment updateUpdateTime(LocalDateTime updateTime){
        if(Objects.equals(this.updateTime, updateTime)){
            return this;
        }
        handleUpdate(UPDATE_TIME_PROPERTY, getUpdateTime(), updateTime);
        this.updateTime = updateTime;
        return this;
    }
    public Shipment addDelivery(Delivery delivery){
        if (delivery == null){
            return this;
        }

        if(null == this.deliveryList){
            this.deliveryList = new SmartList<>();
        }

        this.deliveryList.add(delivery);
        delivery.cacheRelation(Delivery.SHIPMENT_PROPERTY, this);
        return this;
    }

    public static Shipment refer(Long id){
        Shipment refer = new Shipment();
        refer.__internalSet("id", id);
        refer.set$status(EntityStatus.REFER);
        return refer;
    }
    @Override
    public String typeName(){
        return INTERNAL_TYPE;
    }

    public Shipment comment(String comment){
        this.setComment(comment);
        return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Audited<Shipment> auditAs(String action) {
        return super.auditAs(action);
    }

    // ===== Framework Internal: generated switch dispatch =====
    @Override
    @FrameworkInternal
    public void __internalSet(String property, Object value) {
        switch (property) {
            case "shippedDate": this.shippedDate = (LocalDateTime) value; break;

            case "carrier": this.carrier = (value == null ? null : ((String)value).trim()); break;

            case "globalOrder": this.globalOrder = (GlobalOrder) value; break;

            case "status": this.status = (value == null ? null : ((String)value).trim()); break;

            case "trackingNumber": this.trackingNumber = (value == null ? null : ((String)value).trim()); break;

            case "warehouse": this.warehouse = (Warehouse) value; break;

            case "createTime": this.createTime = (LocalDateTime) value; break;

            case "updateTime": this.updateTime = (LocalDateTime) value; break;

            case "deliveryList": this.deliveryList = (SmartList<Delivery>) value; break;
            default: super.__internalSet(property, value);
        }
    }

    @Override
    @FrameworkInternal
    public Object __internalGet(String property) {
        switch (property) {
            case "shippedDate": return this.shippedDate;
            case "carrier": return this.carrier;
            case "globalOrder": return this.globalOrder;
            case "status": return this.status;
            case "trackingNumber": return this.trackingNumber;
            case "warehouse": return this.warehouse;
            case "createTime": return this.createTime;
            case "updateTime": return this.updateTime;
            case "deliveryList": return this.deliveryList;
            default: return super.__internalGet(property);
        }
    }

}