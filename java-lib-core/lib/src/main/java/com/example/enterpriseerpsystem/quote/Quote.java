
package com.example.enterpriseerpsystem.quote;

import com.example.enterpriseerpsystem.opportunity.Opportunity;
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
public class Quote extends BaseEntity implements RemoteInput {
    public static String INTERNAL_TYPE = "Quote";

    public static final String TOTAL_AMOUNT_PROPERTY = "totalAmount";
    public static final String OPPORTUNITY_PROPERTY = "opportunity";
    public static final String STATUS_PROPERTY = "status";
    public static final String VALID_UNTIL_PROPERTY = "validUntil";
    public static final String CREATE_TIME_PROPERTY = "createTime";
    public static final String UPDATE_TIME_PROPERTY = "updateTime";
    private BigDecimal totalAmount;
    private Opportunity opportunity;
    private String status;
    private LocalDateTime validUntil;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

    public BigDecimal getTotalAmount(){
        return this.totalAmount;
    }
    public Opportunity getOpportunity(){
        return this.opportunity;
    }
    public String getStatus(){
        return this.status;
    }
    public LocalDateTime getValidUntil(){
        return this.validUntil;
    }
    public LocalDateTime getCreateTime(){
        return this.createTime;
    }
    public LocalDateTime getUpdateTime(){
        return this.updateTime;
    }
    public Quote updateTotalAmount(BigDecimal totalAmount){
        if(Objects.equals(this.totalAmount, totalAmount)){
            return this;
        }
        handleUpdate(TOTAL_AMOUNT_PROPERTY, getTotalAmount(), totalAmount);
        this.totalAmount = totalAmount;
        return this;
    }
    public Quote updateOpportunity(Opportunity opportunity){
        if(Objects.equals(this.opportunity, opportunity)){
            return this;
        }
        handleUpdate(OPPORTUNITY_PROPERTY, getOpportunity(), opportunity);
        this.opportunity = opportunity;
        return this;
    }
    public Quote updateStatus(String status){
        status = (status == null ? null : status.trim());
        if(Objects.equals(this.status, status)){
            return this;
        }
        handleUpdate(STATUS_PROPERTY, getStatus(), status);
        this.status = status;
        return this;
    }
    public Quote updateValidUntil(LocalDateTime validUntil){
        if(Objects.equals(this.validUntil, validUntil)){
            return this;
        }
        handleUpdate(VALID_UNTIL_PROPERTY, getValidUntil(), validUntil);
        this.validUntil = validUntil;
        return this;
    }
    public Quote updateCreateTime(LocalDateTime createTime){
        if(Objects.equals(this.createTime, createTime)){
            return this;
        }
        handleUpdate(CREATE_TIME_PROPERTY, getCreateTime(), createTime);
        this.createTime = createTime;
        return this;
    }
    public Quote updateUpdateTime(LocalDateTime updateTime){
        if(Objects.equals(this.updateTime, updateTime)){
            return this;
        }
        handleUpdate(UPDATE_TIME_PROPERTY, getUpdateTime(), updateTime);
        this.updateTime = updateTime;
        return this;
    }

    public static Quote refer(Long id){
        Quote refer = new Quote();
        refer.__internalSet("id", id);
        refer.set$status(EntityStatus.REFER);
        return refer;
    }
    @Override
    public String typeName(){
        return INTERNAL_TYPE;
    }

    public Quote comment(String comment){
        this.setComment(comment);
        return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Audited<Quote> auditAs(String action) {
        return super.auditAs(action);
    }

    // ===== Framework Internal: generated switch dispatch =====
    @Override
    @FrameworkInternal
    public void __internalSet(String property, Object value) {
        switch (property) {
            case "totalAmount": this.totalAmount = (BigDecimal) value; break;

            case "opportunity": this.opportunity = (Opportunity) value; break;

            case "status": this.status = (value == null ? null : ((String)value).trim()); break;

            case "validUntil": this.validUntil = (LocalDateTime) value; break;

            case "createTime": this.createTime = (LocalDateTime) value; break;

            case "updateTime": this.updateTime = (LocalDateTime) value; break;

            default: super.__internalSet(property, value);
        }
    }

    @Override
    @FrameworkInternal
    public Object __internalGet(String property) {
        switch (property) {
            case "totalAmount": return this.totalAmount;
            case "opportunity": return this.opportunity;
            case "status": return this.status;
            case "validUntil": return this.validUntil;
            case "createTime": return this.createTime;
            case "updateTime": return this.updateTime;
            default: return super.__internalGet(property);
        }
    }

}