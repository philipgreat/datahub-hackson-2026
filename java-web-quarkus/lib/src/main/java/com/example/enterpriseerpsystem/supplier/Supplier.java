
package com.example.enterpriseerpsystem.supplier;

import com.example.enterpriseerpsystem.purchaseorder.PurchaseOrder;
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
public class Supplier extends BaseEntity implements RemoteInput {
    public static String INTERNAL_TYPE = "Supplier";

    public static final String ADDRESS_PROPERTY = "address";
    public static final String CONTACT_EMAIL_PROPERTY = "contactEmail";
    public static final String NAME_PROPERTY = "name";
    public static final String PHONE_PROPERTY = "phone";
    public static final String RATING_PROPERTY = "rating";
    public static final String CREATE_TIME_PROPERTY = "createTime";
    public static final String UPDATE_TIME_PROPERTY = "updateTime";
    public static final String PURCHASE_ORDER_LIST_PROPERTY = "purchaseOrderList";
    private String address;
    private String contactEmail;
    private String name;
    private String phone;
    private BigDecimal rating;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private SmartList<PurchaseOrder> purchaseOrderList;

    public String getAddress(){
        return this.address;
    }
    public String getContactEmail(){
        return this.contactEmail;
    }
    public String getName(){
        return this.name;
    }
    public String getPhone(){
        return this.phone;
    }
    public BigDecimal getRating(){
        return this.rating;
    }
    public LocalDateTime getCreateTime(){
        return this.createTime;
    }
    public LocalDateTime getUpdateTime(){
        return this.updateTime;
    }
    public SmartList<PurchaseOrder> getPurchaseOrderList(){
        return this.purchaseOrderList;
    }
    public Supplier updateAddress(String address){
        address = (address == null ? null : address.trim());
        if(Objects.equals(this.address, address)){
            return this;
        }
        handleUpdate(ADDRESS_PROPERTY, getAddress(), address);
        this.address = address;
        return this;
    }
    public Supplier updateContactEmail(String contactEmail){
        contactEmail = (contactEmail == null ? null : contactEmail.trim());
        if(Objects.equals(this.contactEmail, contactEmail)){
            return this;
        }
        handleUpdate(CONTACT_EMAIL_PROPERTY, getContactEmail(), contactEmail);
        this.contactEmail = contactEmail;
        return this;
    }
    public Supplier updateName(String name){
        name = (name == null ? null : name.trim());
        if(Objects.equals(this.name, name)){
            return this;
        }
        handleUpdate(NAME_PROPERTY, getName(), name);
        this.name = name;
        return this;
    }
    public Supplier updatePhone(String phone){
        phone = (phone == null ? null : phone.trim());
        if(Objects.equals(this.phone, phone)){
            return this;
        }
        handleUpdate(PHONE_PROPERTY, getPhone(), phone);
        this.phone = phone;
        return this;
    }
    public Supplier updateRating(BigDecimal rating){
        if(Objects.equals(this.rating, rating)){
            return this;
        }
        handleUpdate(RATING_PROPERTY, getRating(), rating);
        this.rating = rating;
        return this;
    }
    public Supplier updateCreateTime(LocalDateTime createTime){
        if(Objects.equals(this.createTime, createTime)){
            return this;
        }
        handleUpdate(CREATE_TIME_PROPERTY, getCreateTime(), createTime);
        this.createTime = createTime;
        return this;
    }
    public Supplier updateUpdateTime(LocalDateTime updateTime){
        if(Objects.equals(this.updateTime, updateTime)){
            return this;
        }
        handleUpdate(UPDATE_TIME_PROPERTY, getUpdateTime(), updateTime);
        this.updateTime = updateTime;
        return this;
    }
    public Supplier addPurchaseOrder(PurchaseOrder purchaseOrder){
        if (purchaseOrder == null){
            return this;
        }

        if(null == this.purchaseOrderList){
            this.purchaseOrderList = new SmartList<>();
        }

        this.purchaseOrderList.add(purchaseOrder);
        purchaseOrder.cacheRelation(PurchaseOrder.SUPPLIER_PROPERTY, this);
        return this;
    }

    public static Supplier refer(Long id){
        Supplier refer = new Supplier();
        refer.__internalSet("id", id);
        refer.set$status(EntityStatus.REFER);
        return refer;
    }
    @Override
    public String typeName(){
        return INTERNAL_TYPE;
    }

    public Supplier comment(String comment){
        this.setComment(comment);
        return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Audited<Supplier> auditAs(String action) {
        return super.auditAs(action);
    }

    // ===== Framework Internal: generated switch dispatch =====
    @Override
    @FrameworkInternal
    public void __internalSet(String property, Object value) {
        switch (property) {
            case "address": this.address = (value == null ? null : ((String)value).trim()); break;

            case "contactEmail": this.contactEmail = (value == null ? null : ((String)value).trim()); break;

            case "name": this.name = (value == null ? null : ((String)value).trim()); break;

            case "phone": this.phone = (value == null ? null : ((String)value).trim()); break;

            case "rating": this.rating = (BigDecimal) value; break;

            case "createTime": this.createTime = (LocalDateTime) value; break;

            case "updateTime": this.updateTime = (LocalDateTime) value; break;

            case "purchaseOrderList": this.purchaseOrderList = (SmartList<PurchaseOrder>) value; break;
            default: super.__internalSet(property, value);
        }
    }

    @Override
    @FrameworkInternal
    public Object __internalGet(String property) {
        switch (property) {
            case "address": return this.address;
            case "contactEmail": return this.contactEmail;
            case "name": return this.name;
            case "phone": return this.phone;
            case "rating": return this.rating;
            case "createTime": return this.createTime;
            case "updateTime": return this.updateTime;
            case "purchaseOrderList": return this.purchaseOrderList;
            default: return super.__internalGet(property);
        }
    }

}