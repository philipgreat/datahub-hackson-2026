
package com.example.enterpriseerpsystem.coupon;

import com.example.enterpriseerpsystem.promotion.Promotion;
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
public class Coupon extends BaseEntity implements RemoteInput {
    public static String INTERNAL_TYPE = "Coupon";

    public static final String CODE_PROPERTY = "code";
    public static final String PROMOTION_PROPERTY = "promotion";
    public static final String TIMES_USED_PROPERTY = "timesUsed";
    public static final String USAGE_LIMIT_PROPERTY = "usageLimit";
    public static final String CREATE_TIME_PROPERTY = "createTime";
    public static final String UPDATE_TIME_PROPERTY = "updateTime";
    private String code;
    private Promotion promotion;
    private BigDecimal timesUsed;
    private BigDecimal usageLimit;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

    public String getCode(){
        return this.code;
    }
    public Promotion getPromotion(){
        return this.promotion;
    }
    public BigDecimal getTimesUsed(){
        return this.timesUsed;
    }
    public BigDecimal getUsageLimit(){
        return this.usageLimit;
    }
    public LocalDateTime getCreateTime(){
        return this.createTime;
    }
    public LocalDateTime getUpdateTime(){
        return this.updateTime;
    }
    public Coupon updateCode(String code){
        code = (code == null ? null : code.trim());
        if(Objects.equals(this.code, code)){
            return this;
        }
        handleUpdate(CODE_PROPERTY, getCode(), code);
        this.code = code;
        return this;
    }
    public Coupon updatePromotion(Promotion promotion){
        if(Objects.equals(this.promotion, promotion)){
            return this;
        }
        handleUpdate(PROMOTION_PROPERTY, getPromotion(), promotion);
        this.promotion = promotion;
        return this;
    }
    public Coupon updateTimesUsed(BigDecimal timesUsed){
        if(Objects.equals(this.timesUsed, timesUsed)){
            return this;
        }
        handleUpdate(TIMES_USED_PROPERTY, getTimesUsed(), timesUsed);
        this.timesUsed = timesUsed;
        return this;
    }
    public Coupon updateUsageLimit(BigDecimal usageLimit){
        if(Objects.equals(this.usageLimit, usageLimit)){
            return this;
        }
        handleUpdate(USAGE_LIMIT_PROPERTY, getUsageLimit(), usageLimit);
        this.usageLimit = usageLimit;
        return this;
    }
    public Coupon updateCreateTime(LocalDateTime createTime){
        if(Objects.equals(this.createTime, createTime)){
            return this;
        }
        handleUpdate(CREATE_TIME_PROPERTY, getCreateTime(), createTime);
        this.createTime = createTime;
        return this;
    }
    public Coupon updateUpdateTime(LocalDateTime updateTime){
        if(Objects.equals(this.updateTime, updateTime)){
            return this;
        }
        handleUpdate(UPDATE_TIME_PROPERTY, getUpdateTime(), updateTime);
        this.updateTime = updateTime;
        return this;
    }

    public static Coupon refer(Long id){
        Coupon refer = new Coupon();
        refer.__internalSet("id", id);
        refer.set$status(EntityStatus.REFER);
        return refer;
    }
    @Override
    public String typeName(){
        return INTERNAL_TYPE;
    }

    public Coupon comment(String comment){
        this.setComment(comment);
        return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Audited<Coupon> auditAs(String action) {
        return super.auditAs(action);
    }

    // ===== Framework Internal: generated switch dispatch =====
    @Override
    @FrameworkInternal
    public void __internalSet(String property, Object value) {
        switch (property) {
            case "code": this.code = (value == null ? null : ((String)value).trim()); break;

            case "promotion": this.promotion = (Promotion) value; break;

            case "timesUsed": this.timesUsed = (BigDecimal) value; break;

            case "usageLimit": this.usageLimit = (BigDecimal) value; break;

            case "createTime": this.createTime = (LocalDateTime) value; break;

            case "updateTime": this.updateTime = (LocalDateTime) value; break;

            default: super.__internalSet(property, value);
        }
    }

    @Override
    @FrameworkInternal
    public Object __internalGet(String property) {
        switch (property) {
            case "code": return this.code;
            case "promotion": return this.promotion;
            case "timesUsed": return this.timesUsed;
            case "usageLimit": return this.usageLimit;
            case "createTime": return this.createTime;
            case "updateTime": return this.updateTime;
            default: return super.__internalGet(property);
        }
    }

}