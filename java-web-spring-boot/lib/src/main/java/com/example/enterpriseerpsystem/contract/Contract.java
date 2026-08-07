
package com.example.enterpriseerpsystem.contract;

import com.example.enterpriseerpsystem.customer.Customer;
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
public class Contract extends BaseEntity implements RemoteInput {
    public static String INTERNAL_TYPE = "Contract";

    public static final String CUSTOMER_PROPERTY = "customer";
    public static final String END_DATE_PROPERTY = "endDate";
    public static final String START_DATE_PROPERTY = "startDate";
    public static final String TERMS_PROPERTY = "terms";
    public static final String VALUE_PROPERTY = "value";
    public static final String CREATE_TIME_PROPERTY = "createTime";
    public static final String UPDATE_TIME_PROPERTY = "updateTime";
    private Customer customer;
    private LocalDateTime endDate;
    private LocalDateTime startDate;
    private String terms;
    private BigDecimal value;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

    public Customer getCustomer(){
        return this.customer;
    }
    public LocalDateTime getEndDate(){
        return this.endDate;
    }
    public LocalDateTime getStartDate(){
        return this.startDate;
    }
    public String getTerms(){
        return this.terms;
    }
    public BigDecimal getValue(){
        return this.value;
    }
    public LocalDateTime getCreateTime(){
        return this.createTime;
    }
    public LocalDateTime getUpdateTime(){
        return this.updateTime;
    }
    public Contract updateCustomer(Customer customer){
        if(Objects.equals(this.customer, customer)){
            return this;
        }
        handleUpdate(CUSTOMER_PROPERTY, getCustomer(), customer);
        this.customer = customer;
        return this;
    }
    public Contract updateEndDate(LocalDateTime endDate){
        if(Objects.equals(this.endDate, endDate)){
            return this;
        }
        handleUpdate(END_DATE_PROPERTY, getEndDate(), endDate);
        this.endDate = endDate;
        return this;
    }
    public Contract updateStartDate(LocalDateTime startDate){
        if(Objects.equals(this.startDate, startDate)){
            return this;
        }
        handleUpdate(START_DATE_PROPERTY, getStartDate(), startDate);
        this.startDate = startDate;
        return this;
    }
    public Contract updateTerms(String terms){
        terms = (terms == null ? null : terms.trim());
        if(Objects.equals(this.terms, terms)){
            return this;
        }
        handleUpdate(TERMS_PROPERTY, getTerms(), terms);
        this.terms = terms;
        return this;
    }
    public Contract updateValue(BigDecimal value){
        if(Objects.equals(this.value, value)){
            return this;
        }
        handleUpdate(VALUE_PROPERTY, getValue(), value);
        this.value = value;
        return this;
    }
    public Contract updateCreateTime(LocalDateTime createTime){
        if(Objects.equals(this.createTime, createTime)){
            return this;
        }
        handleUpdate(CREATE_TIME_PROPERTY, getCreateTime(), createTime);
        this.createTime = createTime;
        return this;
    }
    public Contract updateUpdateTime(LocalDateTime updateTime){
        if(Objects.equals(this.updateTime, updateTime)){
            return this;
        }
        handleUpdate(UPDATE_TIME_PROPERTY, getUpdateTime(), updateTime);
        this.updateTime = updateTime;
        return this;
    }

    public static Contract refer(Long id){
        Contract refer = new Contract();
        refer.__internalSet("id", id);
        refer.set$status(EntityStatus.REFER);
        return refer;
    }
    @Override
    public String typeName(){
        return INTERNAL_TYPE;
    }

    public Contract comment(String comment){
        this.setComment(comment);
        return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Audited<Contract> auditAs(String action) {
        return super.auditAs(action);
    }

    // ===== Framework Internal: generated switch dispatch =====
    @Override
    @FrameworkInternal
    public void __internalSet(String property, Object value) {
        switch (property) {
            case "customer": this.customer = (Customer) value; break;

            case "endDate": this.endDate = (LocalDateTime) value; break;

            case "startDate": this.startDate = (LocalDateTime) value; break;

            case "terms": this.terms = (value == null ? null : ((String)value).trim()); break;

            case "value": this.value = (BigDecimal) value; break;

            case "createTime": this.createTime = (LocalDateTime) value; break;

            case "updateTime": this.updateTime = (LocalDateTime) value; break;

            default: super.__internalSet(property, value);
        }
    }

    @Override
    @FrameworkInternal
    public Object __internalGet(String property) {
        switch (property) {
            case "customer": return this.customer;
            case "endDate": return this.endDate;
            case "startDate": return this.startDate;
            case "terms": return this.terms;
            case "value": return this.value;
            case "createTime": return this.createTime;
            case "updateTime": return this.updateTime;
            default: return super.__internalGet(property);
        }
    }

}