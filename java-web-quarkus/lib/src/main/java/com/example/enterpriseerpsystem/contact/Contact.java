
package com.example.enterpriseerpsystem.contact;

import com.example.enterpriseerpsystem.customer.Customer;
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
public class Contact extends BaseEntity implements RemoteInput {
    public static String INTERNAL_TYPE = "Contact";

    public static final String EMAIL_PROPERTY = "email";
    public static final String NAME_PROPERTY = "name";
    public static final String PHONE_PROPERTY = "phone";
    public static final String CUSTOMER_PROPERTY = "customer";
    public static final String ROLE_PROPERTY = "role";
    public static final String CREATE_TIME_PROPERTY = "createTime";
    public static final String UPDATE_TIME_PROPERTY = "updateTime";
    private String email;
    private String name;
    private String phone;
    private Customer customer;
    private String role;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

    public String getEmail(){
        return this.email;
    }
    public String getName(){
        return this.name;
    }
    public String getPhone(){
        return this.phone;
    }
    public Customer getCustomer(){
        return this.customer;
    }
    public String getRole(){
        return this.role;
    }
    public LocalDateTime getCreateTime(){
        return this.createTime;
    }
    public LocalDateTime getUpdateTime(){
        return this.updateTime;
    }
    public Contact updateEmail(String email){
        email = (email == null ? null : email.trim());
        if(Objects.equals(this.email, email)){
            return this;
        }
        handleUpdate(EMAIL_PROPERTY, getEmail(), email);
        this.email = email;
        return this;
    }
    public Contact updateName(String name){
        name = (name == null ? null : name.trim());
        if(Objects.equals(this.name, name)){
            return this;
        }
        handleUpdate(NAME_PROPERTY, getName(), name);
        this.name = name;
        return this;
    }
    public Contact updatePhone(String phone){
        phone = (phone == null ? null : phone.trim());
        if(Objects.equals(this.phone, phone)){
            return this;
        }
        handleUpdate(PHONE_PROPERTY, getPhone(), phone);
        this.phone = phone;
        return this;
    }
    public Contact updateCustomer(Customer customer){
        if(Objects.equals(this.customer, customer)){
            return this;
        }
        handleUpdate(CUSTOMER_PROPERTY, getCustomer(), customer);
        this.customer = customer;
        return this;
    }
    public Contact updateRole(String role){
        role = (role == null ? null : role.trim());
        if(Objects.equals(this.role, role)){
            return this;
        }
        handleUpdate(ROLE_PROPERTY, getRole(), role);
        this.role = role;
        return this;
    }
    public Contact updateCreateTime(LocalDateTime createTime){
        if(Objects.equals(this.createTime, createTime)){
            return this;
        }
        handleUpdate(CREATE_TIME_PROPERTY, getCreateTime(), createTime);
        this.createTime = createTime;
        return this;
    }
    public Contact updateUpdateTime(LocalDateTime updateTime){
        if(Objects.equals(this.updateTime, updateTime)){
            return this;
        }
        handleUpdate(UPDATE_TIME_PROPERTY, getUpdateTime(), updateTime);
        this.updateTime = updateTime;
        return this;
    }

    public static Contact refer(Long id){
        Contact refer = new Contact();
        refer.__internalSet("id", id);
        refer.set$status(EntityStatus.REFER);
        return refer;
    }
    @Override
    public String typeName(){
        return INTERNAL_TYPE;
    }

    public Contact comment(String comment){
        this.setComment(comment);
        return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Audited<Contact> auditAs(String action) {
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

            case "customer": this.customer = (Customer) value; break;

            case "role": this.role = (value == null ? null : ((String)value).trim()); break;

            case "createTime": this.createTime = (LocalDateTime) value; break;

            case "updateTime": this.updateTime = (LocalDateTime) value; break;

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
            case "customer": return this.customer;
            case "role": return this.role;
            case "createTime": return this.createTime;
            case "updateTime": return this.updateTime;
            default: return super.__internalGet(property);
        }
    }

}