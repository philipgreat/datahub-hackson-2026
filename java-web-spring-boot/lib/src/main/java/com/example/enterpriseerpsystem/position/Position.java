
package com.example.enterpriseerpsystem.position;

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
public class Position extends BaseEntity implements RemoteInput {
    public static String INTERNAL_TYPE = "Position";

    public static final String MAX_SALARY_PROPERTY = "maxSalary";
    public static final String MIN_SALARY_PROPERTY = "minSalary";
    public static final String TITLE_PROPERTY = "title";
    public static final String CREATE_TIME_PROPERTY = "createTime";
    public static final String UPDATE_TIME_PROPERTY = "updateTime";
    private BigDecimal maxSalary;
    private BigDecimal minSalary;
    private String title;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

    public BigDecimal getMaxSalary(){
        return this.maxSalary;
    }
    public BigDecimal getMinSalary(){
        return this.minSalary;
    }
    public String getTitle(){
        return this.title;
    }
    public LocalDateTime getCreateTime(){
        return this.createTime;
    }
    public LocalDateTime getUpdateTime(){
        return this.updateTime;
    }
    public Position updateMaxSalary(BigDecimal maxSalary){
        if(Objects.equals(this.maxSalary, maxSalary)){
            return this;
        }
        handleUpdate(MAX_SALARY_PROPERTY, getMaxSalary(), maxSalary);
        this.maxSalary = maxSalary;
        return this;
    }
    public Position updateMinSalary(BigDecimal minSalary){
        if(Objects.equals(this.minSalary, minSalary)){
            return this;
        }
        handleUpdate(MIN_SALARY_PROPERTY, getMinSalary(), minSalary);
        this.minSalary = minSalary;
        return this;
    }
    public Position updateTitle(String title){
        title = (title == null ? null : title.trim());
        if(Objects.equals(this.title, title)){
            return this;
        }
        handleUpdate(TITLE_PROPERTY, getTitle(), title);
        this.title = title;
        return this;
    }
    public Position updateCreateTime(LocalDateTime createTime){
        if(Objects.equals(this.createTime, createTime)){
            return this;
        }
        handleUpdate(CREATE_TIME_PROPERTY, getCreateTime(), createTime);
        this.createTime = createTime;
        return this;
    }
    public Position updateUpdateTime(LocalDateTime updateTime){
        if(Objects.equals(this.updateTime, updateTime)){
            return this;
        }
        handleUpdate(UPDATE_TIME_PROPERTY, getUpdateTime(), updateTime);
        this.updateTime = updateTime;
        return this;
    }

    public static Position refer(Long id){
        Position refer = new Position();
        refer.__internalSet("id", id);
        refer.set$status(EntityStatus.REFER);
        return refer;
    }
    @Override
    public String typeName(){
        return INTERNAL_TYPE;
    }

    public Position comment(String comment){
        this.setComment(comment);
        return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Audited<Position> auditAs(String action) {
        return super.auditAs(action);
    }

    // ===== Framework Internal: generated switch dispatch =====
    @Override
    @FrameworkInternal
    public void __internalSet(String property, Object value) {
        switch (property) {
            case "maxSalary": this.maxSalary = (BigDecimal) value; break;

            case "minSalary": this.minSalary = (BigDecimal) value; break;

            case "title": this.title = (value == null ? null : ((String)value).trim()); break;

            case "createTime": this.createTime = (LocalDateTime) value; break;

            case "updateTime": this.updateTime = (LocalDateTime) value; break;

            default: super.__internalSet(property, value);
        }
    }

    @Override
    @FrameworkInternal
    public Object __internalGet(String property) {
        switch (property) {
            case "maxSalary": return this.maxSalary;
            case "minSalary": return this.minSalary;
            case "title": return this.title;
            case "createTime": return this.createTime;
            case "updateTime": return this.updateTime;
            default: return super.__internalGet(property);
        }
    }

}