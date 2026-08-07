
package com.example.enterpriseerpsystem.salesterritory;

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
public class SalesTerritory extends BaseEntity implements RemoteInput {
    public static String INTERNAL_TYPE = "SalesTerritory";

    public static final String NAME_PROPERTY = "name";
    public static final String MANAGER_ID_PROPERTY = "managerId";
    public static final String REGION_PROPERTY = "region";
    public static final String CREATE_TIME_PROPERTY = "createTime";
    public static final String UPDATE_TIME_PROPERTY = "updateTime";
    private String name;
    private String managerId;
    private String region;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

    public String getName(){
        return this.name;
    }
    public String getManagerId(){
        return this.managerId;
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
    public SalesTerritory updateName(String name){
        name = (name == null ? null : name.trim());
        if(Objects.equals(this.name, name)){
            return this;
        }
        handleUpdate(NAME_PROPERTY, getName(), name);
        this.name = name;
        return this;
    }
    public SalesTerritory updateManagerId(String managerId){
        managerId = (managerId == null ? null : managerId.trim());
        if(Objects.equals(this.managerId, managerId)){
            return this;
        }
        handleUpdate(MANAGER_ID_PROPERTY, getManagerId(), managerId);
        this.managerId = managerId;
        return this;
    }
    public SalesTerritory updateRegion(String region){
        region = (region == null ? null : region.trim());
        if(Objects.equals(this.region, region)){
            return this;
        }
        handleUpdate(REGION_PROPERTY, getRegion(), region);
        this.region = region;
        return this;
    }
    public SalesTerritory updateCreateTime(LocalDateTime createTime){
        if(Objects.equals(this.createTime, createTime)){
            return this;
        }
        handleUpdate(CREATE_TIME_PROPERTY, getCreateTime(), createTime);
        this.createTime = createTime;
        return this;
    }
    public SalesTerritory updateUpdateTime(LocalDateTime updateTime){
        if(Objects.equals(this.updateTime, updateTime)){
            return this;
        }
        handleUpdate(UPDATE_TIME_PROPERTY, getUpdateTime(), updateTime);
        this.updateTime = updateTime;
        return this;
    }

    public static SalesTerritory refer(Long id){
        SalesTerritory refer = new SalesTerritory();
        refer.__internalSet("id", id);
        refer.set$status(EntityStatus.REFER);
        return refer;
    }
    @Override
    public String typeName(){
        return INTERNAL_TYPE;
    }

    public SalesTerritory comment(String comment){
        this.setComment(comment);
        return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Audited<SalesTerritory> auditAs(String action) {
        return super.auditAs(action);
    }

    // ===== Framework Internal: generated switch dispatch =====
    @Override
    @FrameworkInternal
    public void __internalSet(String property, Object value) {
        switch (property) {
            case "name": this.name = (value == null ? null : ((String)value).trim()); break;

            case "managerId": this.managerId = (value == null ? null : ((String)value).trim()); break;

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
            case "name": return this.name;
            case "managerId": return this.managerId;
            case "region": return this.region;
            case "createTime": return this.createTime;
            case "updateTime": return this.updateTime;
            default: return super.__internalGet(property);
        }
    }

}