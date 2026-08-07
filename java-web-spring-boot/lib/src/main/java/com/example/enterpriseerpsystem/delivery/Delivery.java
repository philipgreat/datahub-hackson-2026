
package com.example.enterpriseerpsystem.delivery;

import com.example.enterpriseerpsystem.shipment.Shipment;
import io.teaql.core.Audited;
import io.teaql.core.BaseEntity;
import io.teaql.core.EntityStatus;
import io.teaql.core.FrameworkInternal;
import io.teaql.core.RemoteInput;
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
public class Delivery extends BaseEntity implements RemoteInput {
    public static String INTERNAL_TYPE = "Delivery";

    public static final String RECIPIENT_SIGNATURE_PROPERTY = "recipientSignature";
    public static final String SHIPMENT_PROPERTY = "shipment";
    public static final String DELIVERY_DATE_PROPERTY = "deliveryDate";
    public static final String STATUS_PROPERTY = "status";
    public static final String CREATE_TIME_PROPERTY = "createTime";
    public static final String UPDATE_TIME_PROPERTY = "updateTime";
    private String recipientSignature;
    private Shipment shipment;
    private LocalDateTime deliveryDate;
    private String status;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

    public String getRecipientSignature(){
        return this.recipientSignature;
    }
    public Shipment getShipment(){
        return this.shipment;
    }
    public LocalDateTime getDeliveryDate(){
        return this.deliveryDate;
    }
    public String getStatus(){
        return this.status;
    }
    public LocalDateTime getCreateTime(){
        return this.createTime;
    }
    public LocalDateTime getUpdateTime(){
        return this.updateTime;
    }
    public Delivery updateRecipientSignature(String recipientSignature){
        recipientSignature = (recipientSignature == null ? null : recipientSignature.trim());
        if(Objects.equals(this.recipientSignature, recipientSignature)){
            return this;
        }
        handleUpdate(RECIPIENT_SIGNATURE_PROPERTY, getRecipientSignature(), recipientSignature);
        this.recipientSignature = recipientSignature;
        return this;
    }
    public Delivery updateShipment(Shipment shipment){
        if(Objects.equals(this.shipment, shipment)){
            return this;
        }
        handleUpdate(SHIPMENT_PROPERTY, getShipment(), shipment);
        this.shipment = shipment;
        return this;
    }
    public Delivery updateDeliveryDate(LocalDateTime deliveryDate){
        if(Objects.equals(this.deliveryDate, deliveryDate)){
            return this;
        }
        handleUpdate(DELIVERY_DATE_PROPERTY, getDeliveryDate(), deliveryDate);
        this.deliveryDate = deliveryDate;
        return this;
    }
    public Delivery updateStatus(String status){
        status = (status == null ? null : status.trim());
        if(Objects.equals(this.status, status)){
            return this;
        }
        handleUpdate(STATUS_PROPERTY, getStatus(), status);
        this.status = status;
        return this;
    }
    public Delivery updateCreateTime(LocalDateTime createTime){
        if(Objects.equals(this.createTime, createTime)){
            return this;
        }
        handleUpdate(CREATE_TIME_PROPERTY, getCreateTime(), createTime);
        this.createTime = createTime;
        return this;
    }
    public Delivery updateUpdateTime(LocalDateTime updateTime){
        if(Objects.equals(this.updateTime, updateTime)){
            return this;
        }
        handleUpdate(UPDATE_TIME_PROPERTY, getUpdateTime(), updateTime);
        this.updateTime = updateTime;
        return this;
    }

    public static Delivery refer(Long id){
        Delivery refer = new Delivery();
        refer.__internalSet("id", id);
        refer.set$status(EntityStatus.REFER);
        return refer;
    }
    @Override
    public String typeName(){
        return INTERNAL_TYPE;
    }

    public Delivery comment(String comment){
        this.setComment(comment);
        return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Audited<Delivery> auditAs(String action) {
        return super.auditAs(action);
    }

    // ===== Framework Internal: generated switch dispatch =====
    @Override
    @FrameworkInternal
    public void __internalSet(String property, Object value) {
        switch (property) {
            case "recipientSignature": this.recipientSignature = (value == null ? null : ((String)value).trim()); break;

            case "shipment": this.shipment = (Shipment) value; break;

            case "deliveryDate": this.deliveryDate = (LocalDateTime) value; break;

            case "status": this.status = (value == null ? null : ((String)value).trim()); break;

            case "createTime": this.createTime = (LocalDateTime) value; break;

            case "updateTime": this.updateTime = (LocalDateTime) value; break;

            default: super.__internalSet(property, value);
        }
    }

    @Override
    @FrameworkInternal
    public Object __internalGet(String property) {
        switch (property) {
            case "recipientSignature": return this.recipientSignature;
            case "shipment": return this.shipment;
            case "deliveryDate": return this.deliveryDate;
            case "status": return this.status;
            case "createTime": return this.createTime;
            case "updateTime": return this.updateTime;
            default: return super.__internalGet(property);
        }
    }

}