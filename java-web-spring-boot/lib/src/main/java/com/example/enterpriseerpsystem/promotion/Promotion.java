
package com.example.enterpriseerpsystem.promotion;

import com.example.enterpriseerpsystem.coupon.Coupon;
import io.teaql.core.Audited;
import io.teaql.core.BaseEntity;
import io.teaql.core.EntityStatus;
import io.teaql.core.FrameworkInternal;
import io.teaql.core.RemoteInput;
import io.teaql.core.SmartList;
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
public class Promotion extends BaseEntity implements RemoteInput {
    public static String INTERNAL_TYPE = "Promotion";

    public static final String NAME_PROPERTY = "name";
    public static final String DISCOUNT_PERCENTAGE_PROPERTY = "discountPercentage";
    public static final String END_DATE_PROPERTY = "endDate";
    public static final String START_DATE_PROPERTY = "startDate";
    public static final String CREATE_TIME_PROPERTY = "createTime";
    public static final String UPDATE_TIME_PROPERTY = "updateTime";
    public static final String COUPON_LIST_PROPERTY = "couponList";
    private String name;
    private BigDecimal discountPercentage;
    private LocalDateTime endDate;
    private LocalDateTime startDate;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private SmartList<Coupon> couponList;

    public String getName(){
        return this.name;
    }
    public BigDecimal getDiscountPercentage(){
        return this.discountPercentage;
    }
    public LocalDateTime getEndDate(){
        return this.endDate;
    }
    public LocalDateTime getStartDate(){
        return this.startDate;
    }
    public LocalDateTime getCreateTime(){
        return this.createTime;
    }
    public LocalDateTime getUpdateTime(){
        return this.updateTime;
    }
    public SmartList<Coupon> getCouponList(){
        return this.couponList;
    }
    public Promotion updateName(String name){
        name = (name == null ? null : name.trim());
        if(Objects.equals(this.name, name)){
            return this;
        }
        handleUpdate(NAME_PROPERTY, getName(), name);
        this.name = name;
        return this;
    }
    public Promotion updateDiscountPercentage(BigDecimal discountPercentage){
        if(Objects.equals(this.discountPercentage, discountPercentage)){
            return this;
        }
        handleUpdate(DISCOUNT_PERCENTAGE_PROPERTY, getDiscountPercentage(), discountPercentage);
        this.discountPercentage = discountPercentage;
        return this;
    }
    public Promotion updateEndDate(LocalDateTime endDate){
        if(Objects.equals(this.endDate, endDate)){
            return this;
        }
        handleUpdate(END_DATE_PROPERTY, getEndDate(), endDate);
        this.endDate = endDate;
        return this;
    }
    public Promotion updateStartDate(LocalDateTime startDate){
        if(Objects.equals(this.startDate, startDate)){
            return this;
        }
        handleUpdate(START_DATE_PROPERTY, getStartDate(), startDate);
        this.startDate = startDate;
        return this;
    }
    public Promotion updateCreateTime(LocalDateTime createTime){
        if(Objects.equals(this.createTime, createTime)){
            return this;
        }
        handleUpdate(CREATE_TIME_PROPERTY, getCreateTime(), createTime);
        this.createTime = createTime;
        return this;
    }
    public Promotion updateUpdateTime(LocalDateTime updateTime){
        if(Objects.equals(this.updateTime, updateTime)){
            return this;
        }
        handleUpdate(UPDATE_TIME_PROPERTY, getUpdateTime(), updateTime);
        this.updateTime = updateTime;
        return this;
    }
    public Promotion addCoupon(Coupon coupon){
        if (coupon == null){
            return this;
        }

        if(null == this.couponList){
            this.couponList = new SmartList<>();
        }

        this.couponList.add(coupon);
        coupon.cacheRelation(Coupon.PROMOTION_PROPERTY, this);
        return this;
    }

    public static Promotion refer(Long id){
        Promotion refer = new Promotion();
        refer.__internalSet("id", id);
        refer.set$status(EntityStatus.REFER);
        return refer;
    }
    @Override
    public String typeName(){
        return INTERNAL_TYPE;
    }

    public Promotion comment(String comment){
        this.setComment(comment);
        return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Audited<Promotion> auditAs(String action) {
        return super.auditAs(action);
    }

    // ===== Framework Internal: generated switch dispatch =====
    @Override
    @FrameworkInternal
    public void __internalSet(String property, Object value) {
        switch (property) {
            case "name": this.name = (value == null ? null : ((String)value).trim()); break;

            case "discountPercentage": this.discountPercentage = (BigDecimal) value; break;

            case "endDate": this.endDate = (LocalDateTime) value; break;

            case "startDate": this.startDate = (LocalDateTime) value; break;

            case "createTime": this.createTime = (LocalDateTime) value; break;

            case "updateTime": this.updateTime = (LocalDateTime) value; break;

            case "couponList": this.couponList = (SmartList<Coupon>) value; break;
            default: super.__internalSet(property, value);
        }
    }

    @Override
    @FrameworkInternal
    public Object __internalGet(String property) {
        switch (property) {
            case "name": return this.name;
            case "discountPercentage": return this.discountPercentage;
            case "endDate": return this.endDate;
            case "startDate": return this.startDate;
            case "createTime": return this.createTime;
            case "updateTime": return this.updateTime;
            case "couponList": return this.couponList;
            default: return super.__internalGet(property);
        }
    }

}