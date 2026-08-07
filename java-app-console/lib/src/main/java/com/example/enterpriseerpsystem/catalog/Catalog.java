
package com.example.enterpriseerpsystem.catalog;

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
public class Catalog extends BaseEntity implements RemoteInput {
    public static String INTERNAL_TYPE = "Catalog";

    public static final String NAME_PROPERTY = "name";
    public static final String SEASON_PROPERTY = "season";
    public static final String VALID_FROM_PROPERTY = "validFrom";
    public static final String VALID_TO_PROPERTY = "validTo";
    public static final String CREATE_TIME_PROPERTY = "createTime";
    public static final String UPDATE_TIME_PROPERTY = "updateTime";
    private String name;
    private String season;
    private LocalDateTime validFrom;
    private LocalDateTime validTo;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

    public String getName(){
        return this.name;
    }
    public String getSeason(){
        return this.season;
    }
    public LocalDateTime getValidFrom(){
        return this.validFrom;
    }
    public LocalDateTime getValidTo(){
        return this.validTo;
    }
    public LocalDateTime getCreateTime(){
        return this.createTime;
    }
    public LocalDateTime getUpdateTime(){
        return this.updateTime;
    }
    public Catalog updateName(String name){
        name = (name == null ? null : name.trim());
        if(Objects.equals(this.name, name)){
            return this;
        }
        handleUpdate(NAME_PROPERTY, getName(), name);
        this.name = name;
        return this;
    }
    public Catalog updateSeason(String season){
        season = (season == null ? null : season.trim());
        if(Objects.equals(this.season, season)){
            return this;
        }
        handleUpdate(SEASON_PROPERTY, getSeason(), season);
        this.season = season;
        return this;
    }
    public Catalog updateValidFrom(LocalDateTime validFrom){
        if(Objects.equals(this.validFrom, validFrom)){
            return this;
        }
        handleUpdate(VALID_FROM_PROPERTY, getValidFrom(), validFrom);
        this.validFrom = validFrom;
        return this;
    }
    public Catalog updateValidTo(LocalDateTime validTo){
        if(Objects.equals(this.validTo, validTo)){
            return this;
        }
        handleUpdate(VALID_TO_PROPERTY, getValidTo(), validTo);
        this.validTo = validTo;
        return this;
    }
    public Catalog updateCreateTime(LocalDateTime createTime){
        if(Objects.equals(this.createTime, createTime)){
            return this;
        }
        handleUpdate(CREATE_TIME_PROPERTY, getCreateTime(), createTime);
        this.createTime = createTime;
        return this;
    }
    public Catalog updateUpdateTime(LocalDateTime updateTime){
        if(Objects.equals(this.updateTime, updateTime)){
            return this;
        }
        handleUpdate(UPDATE_TIME_PROPERTY, getUpdateTime(), updateTime);
        this.updateTime = updateTime;
        return this;
    }

    public static Catalog refer(Long id){
        Catalog refer = new Catalog();
        refer.__internalSet("id", id);
        refer.set$status(EntityStatus.REFER);
        return refer;
    }
    @Override
    public String typeName(){
        return INTERNAL_TYPE;
    }

    public Catalog comment(String comment){
        this.setComment(comment);
        return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Audited<Catalog> auditAs(String action) {
        return super.auditAs(action);
    }

    // ===== Framework Internal: generated switch dispatch =====
    @Override
    @FrameworkInternal
    public void __internalSet(String property, Object value) {
        switch (property) {
            case "name": this.name = (value == null ? null : ((String)value).trim()); break;

            case "season": this.season = (value == null ? null : ((String)value).trim()); break;

            case "validFrom": this.validFrom = (LocalDateTime) value; break;

            case "validTo": this.validTo = (LocalDateTime) value; break;

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
            case "season": return this.season;
            case "validFrom": return this.validFrom;
            case "validTo": return this.validTo;
            case "createTime": return this.createTime;
            case "updateTime": return this.updateTime;
            default: return super.__internalGet(property);
        }
    }

}