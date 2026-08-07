
package com.example.enterpriseerpsystem.taxrate;

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
public class TaxRate extends BaseEntity implements RemoteInput {
    public static String INTERNAL_TYPE = "TaxRate";

    public static final String IS_ACTIVE_PROPERTY = "isActive";
    public static final String RATE_PROPERTY = "rate";
    public static final String REGION_PROPERTY = "region";
    public static final String CREATE_TIME_PROPERTY = "createTime";
    public static final String UPDATE_TIME_PROPERTY = "updateTime";
    private Boolean isActive;
    private BigDecimal rate;
    private String region;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

    public Boolean isIsActive(){
        return this.isActive;
    }
    public BigDecimal getRate(){
        return this.rate;
    }
    public String getRegion(){
        return this.region;
    }
    public LocalDateTime getCreateTime(){
        return this.createTime;
    }
    public LocalDateTime getUpdateTime(){
        return this.updateTime;
    }
    public TaxRate updateIsActive(Boolean isActive){
        if(Objects.equals(this.isActive, isActive)){
            return this;
        }
        handleUpdate(IS_ACTIVE_PROPERTY, isIsActive(), isActive);
        this.isActive = isActive;
        return this;
    }
    public TaxRate updateRate(BigDecimal rate){
        if(Objects.equals(this.rate, rate)){
            return this;
        }
        handleUpdate(RATE_PROPERTY, getRate(), rate);
        this.rate = rate;
        return this;
    }
    public TaxRate updateRegion(String region){
        region = (region == null ? null : region.trim());
        if(Objects.equals(this.region, region)){
            return this;
        }
        handleUpdate(REGION_PROPERTY, getRegion(), region);
        this.region = region;
        return this;
    }
    public TaxRate updateCreateTime(LocalDateTime createTime){
        if(Objects.equals(this.createTime, createTime)){
            return this;
        }
        handleUpdate(CREATE_TIME_PROPERTY, getCreateTime(), createTime);
        this.createTime = createTime;
        return this;
    }
    public TaxRate updateUpdateTime(LocalDateTime updateTime){
        if(Objects.equals(this.updateTime, updateTime)){
            return this;
        }
        handleUpdate(UPDATE_TIME_PROPERTY, getUpdateTime(), updateTime);
        this.updateTime = updateTime;
        return this;
    }

    public static TaxRate refer(Long id){
        TaxRate refer = new TaxRate();
        refer.__internalSet("id", id);
        refer.set$status(EntityStatus.REFER);
        return refer;
    }
    @Override
    public String typeName(){
        return INTERNAL_TYPE;
    }

    public TaxRate comment(String comment){
        this.setComment(comment);
        return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Audited<TaxRate> auditAs(String action) {
        return super.auditAs(action);
    }

    // ===== Framework Internal: generated switch dispatch =====
    @Override
    @FrameworkInternal
    public void __internalSet(String property, Object value) {
        switch (property) {
            case "isActive": this.isActive = (Boolean) value; break;

            case "rate": this.rate = (BigDecimal) value; break;

            case "region": this.region = (value == null ? null : ((String)value).trim()); break;

            case "createTime": this.createTime = (LocalDateTime) value; break;

            case "updateTime": this.updateTime = (LocalDateTime) value; break;

            default: super.__internalSet(property, value);
        }
    }

    @Override
    @FrameworkInternal
    public Object __internalGet(String property) {
        switch (property) {
            case "isActive": return this.isActive;
            case "rate": return this.rate;
            case "region": return this.region;
            case "createTime": return this.createTime;
            case "updateTime": return this.updateTime;
            default: return super.__internalGet(property);
        }
    }

}