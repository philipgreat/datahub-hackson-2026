
package com.example.enterpriseerpsystem.lead;

import com.example.enterpriseerpsystem.opportunity.Opportunity;
import io.teaql.core.Audited;
import io.teaql.core.BaseEntity;
import io.teaql.core.EntityStatus;
import io.teaql.core.FrameworkInternal;
import io.teaql.core.RemoteInput;
import io.teaql.core.SmartList;
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
public class Lead extends BaseEntity implements RemoteInput {
    public static String INTERNAL_TYPE = "Lead";

    public static final String EMAIL_PROPERTY = "email";
    public static final String NAME_PROPERTY = "name";
    public static final String PHONE_PROPERTY = "phone";
    public static final String CONVERTED_CUSTOMER_ID_PROPERTY = "convertedCustomerId";
    public static final String SOURCE_PROPERTY = "source";
    public static final String STATUS_PROPERTY = "status";
    public static final String CREATE_TIME_PROPERTY = "createTime";
    public static final String UPDATE_TIME_PROPERTY = "updateTime";
    public static final String OPPORTUNITY_LIST_PROPERTY = "opportunityList";
    private String email;
    private String name;
    private String phone;
    private String convertedCustomerId;
    private String source;
    private String status;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private SmartList<Opportunity> opportunityList;

    public String getEmail(){
        return this.email;
    }
    public String getName(){
        return this.name;
    }
    public String getPhone(){
        return this.phone;
    }
    public String getConvertedCustomerId(){
        return this.convertedCustomerId;
    }
    public String getSource(){
        return this.source;
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
    public SmartList<Opportunity> getOpportunityList(){
        return this.opportunityList;
    }
    public Lead updateEmail(String email){
        email = (email == null ? null : email.trim());
        if(Objects.equals(this.email, email)){
            return this;
        }
        handleUpdate(EMAIL_PROPERTY, getEmail(), email);
        this.email = email;
        return this;
    }
    public Lead updateName(String name){
        name = (name == null ? null : name.trim());
        if(Objects.equals(this.name, name)){
            return this;
        }
        handleUpdate(NAME_PROPERTY, getName(), name);
        this.name = name;
        return this;
    }
    public Lead updatePhone(String phone){
        phone = (phone == null ? null : phone.trim());
        if(Objects.equals(this.phone, phone)){
            return this;
        }
        handleUpdate(PHONE_PROPERTY, getPhone(), phone);
        this.phone = phone;
        return this;
    }
    public Lead updateConvertedCustomerId(String convertedCustomerId){
        convertedCustomerId = (convertedCustomerId == null ? null : convertedCustomerId.trim());
        if(Objects.equals(this.convertedCustomerId, convertedCustomerId)){
            return this;
        }
        handleUpdate(CONVERTED_CUSTOMER_ID_PROPERTY, getConvertedCustomerId(), convertedCustomerId);
        this.convertedCustomerId = convertedCustomerId;
        return this;
    }
    public Lead updateSource(String source){
        source = (source == null ? null : source.trim());
        if(Objects.equals(this.source, source)){
            return this;
        }
        handleUpdate(SOURCE_PROPERTY, getSource(), source);
        this.source = source;
        return this;
    }
    public Lead updateStatus(String status){
        status = (status == null ? null : status.trim());
        if(Objects.equals(this.status, status)){
            return this;
        }
        handleUpdate(STATUS_PROPERTY, getStatus(), status);
        this.status = status;
        return this;
    }
    public Lead updateCreateTime(LocalDateTime createTime){
        if(Objects.equals(this.createTime, createTime)){
            return this;
        }
        handleUpdate(CREATE_TIME_PROPERTY, getCreateTime(), createTime);
        this.createTime = createTime;
        return this;
    }
    public Lead updateUpdateTime(LocalDateTime updateTime){
        if(Objects.equals(this.updateTime, updateTime)){
            return this;
        }
        handleUpdate(UPDATE_TIME_PROPERTY, getUpdateTime(), updateTime);
        this.updateTime = updateTime;
        return this;
    }
    public Lead addOpportunity(Opportunity opportunity){
        if (opportunity == null){
            return this;
        }

        if(null == this.opportunityList){
            this.opportunityList = new SmartList<>();
        }

        this.opportunityList.add(opportunity);
        opportunity.cacheRelation(Opportunity.LEAD_PROPERTY, this);
        return this;
    }

    public static Lead refer(Long id){
        Lead refer = new Lead();
        refer.__internalSet("id", id);
        refer.set$status(EntityStatus.REFER);
        return refer;
    }
    @Override
    public String typeName(){
        return INTERNAL_TYPE;
    }

    public Lead comment(String comment){
        this.setComment(comment);
        return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Audited<Lead> auditAs(String action) {
        return super.auditAs(action);
    }

    // ===== Framework Internal: generated switch dispatch =====
    @Override
    @FrameworkInternal
    public void __internalSet(String property, Object value) {
        switch (property) {
            case "email": this.email = (value == null ? null : ((String)value).trim()); break;

            case "name": this.name = (value == null ? null : ((String)value).trim()); break;

            case "phone": this.phone = (value == null ? null : ((String)value).trim()); break;

            case "convertedCustomerId": this.convertedCustomerId = (value == null ? null : ((String)value).trim()); break;

            case "source": this.source = (value == null ? null : ((String)value).trim()); break;

            case "status": this.status = (value == null ? null : ((String)value).trim()); break;

            case "createTime": this.createTime = (LocalDateTime) value; break;

            case "updateTime": this.updateTime = (LocalDateTime) value; break;

            case "opportunityList": this.opportunityList = (SmartList<Opportunity>) value; break;
            default: super.__internalSet(property, value);
        }
    }

    @Override
    @FrameworkInternal
    public Object __internalGet(String property) {
        switch (property) {
            case "email": return this.email;
            case "name": return this.name;
            case "phone": return this.phone;
            case "convertedCustomerId": return this.convertedCustomerId;
            case "source": return this.source;
            case "status": return this.status;
            case "createTime": return this.createTime;
            case "updateTime": return this.updateTime;
            case "opportunityList": return this.opportunityList;
            default: return super.__internalGet(property);
        }
    }

}