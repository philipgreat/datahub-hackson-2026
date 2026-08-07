
package com.example.enterpriseerpsystem.sla;

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
public class Sla extends BaseEntity implements RemoteInput {
    public static String INTERNAL_TYPE = "Sla";

    public static final String IS_ACTIVE_PROPERTY = "isActive";
    public static final String PRIORITY_LEVEL_PROPERTY = "priorityLevel";
    public static final String RESOLUTION_HOURS_PROPERTY = "resolutionHours";
    public static final String CREATE_TIME_PROPERTY = "createTime";
    public static final String UPDATE_TIME_PROPERTY = "updateTime";
    private Boolean isActive;
    private String priorityLevel;
    private BigDecimal resolutionHours;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

    public Boolean isIsActive(){
        return this.isActive;
    }
    public String getPriorityLevel(){
        return this.priorityLevel;
    }
    public BigDecimal getResolutionHours(){
        return this.resolutionHours;
    }
    public LocalDateTime getCreateTime(){
        return this.createTime;
    }
    public LocalDateTime getUpdateTime(){
        return this.updateTime;
    }
    public Sla updateIsActive(Boolean isActive){
        if(Objects.equals(this.isActive, isActive)){
            return this;
        }
        handleUpdate(IS_ACTIVE_PROPERTY, isIsActive(), isActive);
        this.isActive = isActive;
        return this;
    }
    public Sla updatePriorityLevel(String priorityLevel){
        priorityLevel = (priorityLevel == null ? null : priorityLevel.trim());
        if(Objects.equals(this.priorityLevel, priorityLevel)){
            return this;
        }
        handleUpdate(PRIORITY_LEVEL_PROPERTY, getPriorityLevel(), priorityLevel);
        this.priorityLevel = priorityLevel;
        return this;
    }
    public Sla updateResolutionHours(BigDecimal resolutionHours){
        if(Objects.equals(this.resolutionHours, resolutionHours)){
            return this;
        }
        handleUpdate(RESOLUTION_HOURS_PROPERTY, getResolutionHours(), resolutionHours);
        this.resolutionHours = resolutionHours;
        return this;
    }
    public Sla updateCreateTime(LocalDateTime createTime){
        if(Objects.equals(this.createTime, createTime)){
            return this;
        }
        handleUpdate(CREATE_TIME_PROPERTY, getCreateTime(), createTime);
        this.createTime = createTime;
        return this;
    }
    public Sla updateUpdateTime(LocalDateTime updateTime){
        if(Objects.equals(this.updateTime, updateTime)){
            return this;
        }
        handleUpdate(UPDATE_TIME_PROPERTY, getUpdateTime(), updateTime);
        this.updateTime = updateTime;
        return this;
    }

    public static Sla refer(Long id){
        Sla refer = new Sla();
        refer.__internalSet("id", id);
        refer.set$status(EntityStatus.REFER);
        return refer;
    }
    @Override
    public String typeName(){
        return INTERNAL_TYPE;
    }

    public Sla comment(String comment){
        this.setComment(comment);
        return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Audited<Sla> auditAs(String action) {
        return super.auditAs(action);
    }

    // ===== Framework Internal: generated switch dispatch =====
    @Override
    @FrameworkInternal
    public void __internalSet(String property, Object value) {
        switch (property) {
            case "isActive": this.isActive = (Boolean) value; break;

            case "priorityLevel": this.priorityLevel = (value == null ? null : ((String)value).trim()); break;

            case "resolutionHours": this.resolutionHours = (BigDecimal) value; break;

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
            case "priorityLevel": return this.priorityLevel;
            case "resolutionHours": return this.resolutionHours;
            case "createTime": return this.createTime;
            case "updateTime": return this.updateTime;
            default: return super.__internalGet(property);
        }
    }

}