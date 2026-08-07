
package com.example.enterpriseerpsystem.returnrequest;

import com.example.enterpriseerpsystem.customer.Customer;
import com.example.enterpriseerpsystem.globalorder.GlobalOrder;
import io.teaql.core.Audited;
import io.teaql.core.BaseEntity;
import io.teaql.core.EntityStatus;
import io.teaql.core.FrameworkInternal;
import io.teaql.core.RemoteInput;
import java.math.BigDecimal;
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
public class ReturnRequest extends BaseEntity implements RemoteInput {
    public static String INTERNAL_TYPE = "ReturnRequest";

    public static final String REFUND_AMOUNT_PROPERTY = "refundAmount";
    public static final String CUSTOMER_PROPERTY = "customer";
    public static final String GLOBAL_ORDER_PROPERTY = "globalOrder";
    public static final String REASON_PROPERTY = "reason";
    public static final String STATUS_PROPERTY = "status";
    public static final String CREATE_TIME_PROPERTY = "createTime";
    public static final String UPDATE_TIME_PROPERTY = "updateTime";
    private BigDecimal refundAmount;
    private Customer customer;
    private GlobalOrder globalOrder;
    private String reason;
    private String status;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

    public BigDecimal getRefundAmount(){
        return this.refundAmount;
    }
    public Customer getCustomer(){
        return this.customer;
    }
    public GlobalOrder getGlobalOrder(){
        return this.globalOrder;
    }
    public String getReason(){
        return this.reason;
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
    public ReturnRequest updateRefundAmount(BigDecimal refundAmount){
        if(Objects.equals(this.refundAmount, refundAmount)){
            return this;
        }
        handleUpdate(REFUND_AMOUNT_PROPERTY, getRefundAmount(), refundAmount);
        this.refundAmount = refundAmount;
        return this;
    }
    public ReturnRequest updateCustomer(Customer customer){
        if(Objects.equals(this.customer, customer)){
            return this;
        }
        handleUpdate(CUSTOMER_PROPERTY, getCustomer(), customer);
        this.customer = customer;
        return this;
    }
    public ReturnRequest updateGlobalOrder(GlobalOrder globalOrder){
        if(Objects.equals(this.globalOrder, globalOrder)){
            return this;
        }
        handleUpdate(GLOBAL_ORDER_PROPERTY, getGlobalOrder(), globalOrder);
        this.globalOrder = globalOrder;
        return this;
    }
    public ReturnRequest updateReason(String reason){
        reason = (reason == null ? null : reason.trim());
        if(Objects.equals(this.reason, reason)){
            return this;
        }
        handleUpdate(REASON_PROPERTY, getReason(), reason);
        this.reason = reason;
        return this;
    }
    public ReturnRequest updateStatus(String status){
        status = (status == null ? null : status.trim());
        if(Objects.equals(this.status, status)){
            return this;
        }
        handleUpdate(STATUS_PROPERTY, getStatus(), status);
        this.status = status;
        return this;
    }
    public ReturnRequest updateCreateTime(LocalDateTime createTime){
        if(Objects.equals(this.createTime, createTime)){
            return this;
        }
        handleUpdate(CREATE_TIME_PROPERTY, getCreateTime(), createTime);
        this.createTime = createTime;
        return this;
    }
    public ReturnRequest updateUpdateTime(LocalDateTime updateTime){
        if(Objects.equals(this.updateTime, updateTime)){
            return this;
        }
        handleUpdate(UPDATE_TIME_PROPERTY, getUpdateTime(), updateTime);
        this.updateTime = updateTime;
        return this;
    }

    public static ReturnRequest refer(Long id){
        ReturnRequest refer = new ReturnRequest();
        refer.__internalSet("id", id);
        refer.set$status(EntityStatus.REFER);
        return refer;
    }
    @Override
    public String typeName(){
        return INTERNAL_TYPE;
    }

    public ReturnRequest comment(String comment){
        this.setComment(comment);
        return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Audited<ReturnRequest> auditAs(String action) {
        return super.auditAs(action);
    }

    // ===== Framework Internal: generated switch dispatch =====
    @Override
    @FrameworkInternal
    public void __internalSet(String property, Object value) {
        switch (property) {
            case "refundAmount": this.refundAmount = (BigDecimal) value; break;

            case "customer": this.customer = (Customer) value; break;

            case "globalOrder": this.globalOrder = (GlobalOrder) value; break;

            case "reason": this.reason = (value == null ? null : ((String)value).trim()); break;

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
            case "refundAmount": return this.refundAmount;
            case "customer": return this.customer;
            case "globalOrder": return this.globalOrder;
            case "reason": return this.reason;
            case "status": return this.status;
            case "createTime": return this.createTime;
            case "updateTime": return this.updateTime;
            default: return super.__internalGet(property);
        }
    }

}