
package com.example.enterpriseerpsystem.campaign;

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
public class Campaign extends BaseEntity implements RemoteInput {
    public static String INTERNAL_TYPE = "Campaign";

    public static final String NAME_PROPERTY = "name";
    public static final String BUDGET_PROPERTY = "budget";
    public static final String END_DATE_PROPERTY = "endDate";
    public static final String START_DATE_PROPERTY = "startDate";
    public static final String STATUS_PROPERTY = "status";
    public static final String CREATE_TIME_PROPERTY = "createTime";
    public static final String UPDATE_TIME_PROPERTY = "updateTime";
    private String name;
    private BigDecimal budget;
    private LocalDateTime endDate;
    private LocalDateTime startDate;
    private String status;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

    public String getName(){
        return this.name;
    }
    public BigDecimal getBudget(){
        return this.budget;
    }
    public LocalDateTime getEndDate(){
        return this.endDate;
    }
    public LocalDateTime getStartDate(){
        return this.startDate;
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
    public Campaign updateName(String name){
        name = (name == null ? null : name.trim());
        if(Objects.equals(this.name, name)){
            return this;
        }
        handleUpdate(NAME_PROPERTY, getName(), name);
        this.name = name;
        return this;
    }
    public Campaign updateBudget(BigDecimal budget){
        if(Objects.equals(this.budget, budget)){
            return this;
        }
        handleUpdate(BUDGET_PROPERTY, getBudget(), budget);
        this.budget = budget;
        return this;
    }
    public Campaign updateEndDate(LocalDateTime endDate){
        if(Objects.equals(this.endDate, endDate)){
            return this;
        }
        handleUpdate(END_DATE_PROPERTY, getEndDate(), endDate);
        this.endDate = endDate;
        return this;
    }
    public Campaign updateStartDate(LocalDateTime startDate){
        if(Objects.equals(this.startDate, startDate)){
            return this;
        }
        handleUpdate(START_DATE_PROPERTY, getStartDate(), startDate);
        this.startDate = startDate;
        return this;
    }
    public Campaign updateStatus(String status){
        status = (status == null ? null : status.trim());
        if(Objects.equals(this.status, status)){
            return this;
        }
        handleUpdate(STATUS_PROPERTY, getStatus(), status);
        this.status = status;
        return this;
    }
    public Campaign updateCreateTime(LocalDateTime createTime){
        if(Objects.equals(this.createTime, createTime)){
            return this;
        }
        handleUpdate(CREATE_TIME_PROPERTY, getCreateTime(), createTime);
        this.createTime = createTime;
        return this;
    }
    public Campaign updateUpdateTime(LocalDateTime updateTime){
        if(Objects.equals(this.updateTime, updateTime)){
            return this;
        }
        handleUpdate(UPDATE_TIME_PROPERTY, getUpdateTime(), updateTime);
        this.updateTime = updateTime;
        return this;
    }

    public static Campaign refer(Long id){
        Campaign refer = new Campaign();
        refer.__internalSet("id", id);
        refer.set$status(EntityStatus.REFER);
        return refer;
    }
    @Override
    public String typeName(){
        return INTERNAL_TYPE;
    }

    public Campaign comment(String comment){
        this.setComment(comment);
        return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Audited<Campaign> auditAs(String action) {
        return super.auditAs(action);
    }

    // ===== Framework Internal: generated switch dispatch =====
    @Override
    @FrameworkInternal
    public void __internalSet(String property, Object value) {
        switch (property) {
            case "name": this.name = (value == null ? null : ((String)value).trim()); break;

            case "budget": this.budget = (BigDecimal) value; break;

            case "endDate": this.endDate = (LocalDateTime) value; break;

            case "startDate": this.startDate = (LocalDateTime) value; break;

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
            case "name": return this.name;
            case "budget": return this.budget;
            case "endDate": return this.endDate;
            case "startDate": return this.startDate;
            case "status": return this.status;
            case "createTime": return this.createTime;
            case "updateTime": return this.updateTime;
            default: return super.__internalGet(property);
        }
    }

}