
package com.example.enterpriseerpsystem.refund;

import com.example.enterpriseerpsystem.payment.Payment;
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
public class Refund extends BaseEntity implements RemoteInput {
    public static String INTERNAL_TYPE = "Refund";

    public static final String AMOUNT_PROPERTY = "amount";
    public static final String PAYMENT_PROPERTY = "payment";
    public static final String PROCESSED_DATE_PROPERTY = "processedDate";
    public static final String REASON_PROPERTY = "reason";
    public static final String CREATE_TIME_PROPERTY = "createTime";
    public static final String UPDATE_TIME_PROPERTY = "updateTime";
    private BigDecimal amount;
    private Payment payment;
    private LocalDateTime processedDate;
    private String reason;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

    public BigDecimal getAmount(){
        return this.amount;
    }
    public Payment getPayment(){
        return this.payment;
    }
    public LocalDateTime getProcessedDate(){
        return this.processedDate;
    }
    public String getReason(){
        return this.reason;
    }
    public LocalDateTime getCreateTime(){
        return this.createTime;
    }
    public LocalDateTime getUpdateTime(){
        return this.updateTime;
    }
    public Refund updateAmount(BigDecimal amount){
        if(Objects.equals(this.amount, amount)){
            return this;
        }
        handleUpdate(AMOUNT_PROPERTY, getAmount(), amount);
        this.amount = amount;
        return this;
    }
    public Refund updatePayment(Payment payment){
        if(Objects.equals(this.payment, payment)){
            return this;
        }
        handleUpdate(PAYMENT_PROPERTY, getPayment(), payment);
        this.payment = payment;
        return this;
    }
    public Refund updateProcessedDate(LocalDateTime processedDate){
        if(Objects.equals(this.processedDate, processedDate)){
            return this;
        }
        handleUpdate(PROCESSED_DATE_PROPERTY, getProcessedDate(), processedDate);
        this.processedDate = processedDate;
        return this;
    }
    public Refund updateReason(String reason){
        reason = (reason == null ? null : reason.trim());
        if(Objects.equals(this.reason, reason)){
            return this;
        }
        handleUpdate(REASON_PROPERTY, getReason(), reason);
        this.reason = reason;
        return this;
    }
    public Refund updateCreateTime(LocalDateTime createTime){
        if(Objects.equals(this.createTime, createTime)){
            return this;
        }
        handleUpdate(CREATE_TIME_PROPERTY, getCreateTime(), createTime);
        this.createTime = createTime;
        return this;
    }
    public Refund updateUpdateTime(LocalDateTime updateTime){
        if(Objects.equals(this.updateTime, updateTime)){
            return this;
        }
        handleUpdate(UPDATE_TIME_PROPERTY, getUpdateTime(), updateTime);
        this.updateTime = updateTime;
        return this;
    }

    public static Refund refer(Long id){
        Refund refer = new Refund();
        refer.__internalSet("id", id);
        refer.set$status(EntityStatus.REFER);
        return refer;
    }
    @Override
    public String typeName(){
        return INTERNAL_TYPE;
    }

    public Refund comment(String comment){
        this.setComment(comment);
        return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Audited<Refund> auditAs(String action) {
        return super.auditAs(action);
    }

    // ===== Framework Internal: generated switch dispatch =====
    @Override
    @FrameworkInternal
    public void __internalSet(String property, Object value) {
        switch (property) {
            case "amount": this.amount = (BigDecimal) value; break;

            case "payment": this.payment = (Payment) value; break;

            case "processedDate": this.processedDate = (LocalDateTime) value; break;

            case "reason": this.reason = (value == null ? null : ((String)value).trim()); break;

            case "createTime": this.createTime = (LocalDateTime) value; break;

            case "updateTime": this.updateTime = (LocalDateTime) value; break;

            default: super.__internalSet(property, value);
        }
    }

    @Override
    @FrameworkInternal
    public Object __internalGet(String property) {
        switch (property) {
            case "amount": return this.amount;
            case "payment": return this.payment;
            case "processedDate": return this.processedDate;
            case "reason": return this.reason;
            case "createTime": return this.createTime;
            case "updateTime": return this.updateTime;
            default: return super.__internalGet(property);
        }
    }

}