
package com.example.enterpriseerpsystem.shoppingcart;

import com.example.enterpriseerpsystem.cartitem.CartItem;
import com.example.enterpriseerpsystem.customer.Customer;
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
public class ShoppingCart extends BaseEntity implements RemoteInput {
    public static String INTERNAL_TYPE = "ShoppingCart";

    public static final String CREATED_AT_PROPERTY = "createdAt";
    public static final String CUSTOMER_PROPERTY = "customer";
    public static final String IS_ABANDONED_PROPERTY = "isAbandoned";
    public static final String SESSION_ID_PROPERTY = "sessionId";
    public static final String CREATE_TIME_PROPERTY = "createTime";
    public static final String UPDATE_TIME_PROPERTY = "updateTime";
    public static final String CART_ITEM_LIST_PROPERTY = "cartItemList";
    private LocalDateTime createdAt;
    private Customer customer;
    private Boolean isAbandoned;
    private String sessionId;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private SmartList<CartItem> cartItemList;

    public LocalDateTime getCreatedAt(){
        return this.createdAt;
    }
    public Customer getCustomer(){
        return this.customer;
    }
    public Boolean isIsAbandoned(){
        return this.isAbandoned;
    }
    public String getSessionId(){
        return this.sessionId;
    }
    public LocalDateTime getCreateTime(){
        return this.createTime;
    }
    public LocalDateTime getUpdateTime(){
        return this.updateTime;
    }
    public SmartList<CartItem> getCartItemList(){
        return this.cartItemList;
    }
    public ShoppingCart updateCreatedAt(LocalDateTime createdAt){
        if(Objects.equals(this.createdAt, createdAt)){
            return this;
        }
        handleUpdate(CREATED_AT_PROPERTY, getCreatedAt(), createdAt);
        this.createdAt = createdAt;
        return this;
    }
    public ShoppingCart updateCustomer(Customer customer){
        if(Objects.equals(this.customer, customer)){
            return this;
        }
        handleUpdate(CUSTOMER_PROPERTY, getCustomer(), customer);
        this.customer = customer;
        return this;
    }
    public ShoppingCart updateIsAbandoned(Boolean isAbandoned){
        if(Objects.equals(this.isAbandoned, isAbandoned)){
            return this;
        }
        handleUpdate(IS_ABANDONED_PROPERTY, isIsAbandoned(), isAbandoned);
        this.isAbandoned = isAbandoned;
        return this;
    }
    public ShoppingCart updateSessionId(String sessionId){
        sessionId = (sessionId == null ? null : sessionId.trim());
        if(Objects.equals(this.sessionId, sessionId)){
            return this;
        }
        handleUpdate(SESSION_ID_PROPERTY, getSessionId(), sessionId);
        this.sessionId = sessionId;
        return this;
    }
    public ShoppingCart updateCreateTime(LocalDateTime createTime){
        if(Objects.equals(this.createTime, createTime)){
            return this;
        }
        handleUpdate(CREATE_TIME_PROPERTY, getCreateTime(), createTime);
        this.createTime = createTime;
        return this;
    }
    public ShoppingCart updateUpdateTime(LocalDateTime updateTime){
        if(Objects.equals(this.updateTime, updateTime)){
            return this;
        }
        handleUpdate(UPDATE_TIME_PROPERTY, getUpdateTime(), updateTime);
        this.updateTime = updateTime;
        return this;
    }
    public ShoppingCart addCartItem(CartItem cartItem){
        if (cartItem == null){
            return this;
        }

        if(null == this.cartItemList){
            this.cartItemList = new SmartList<>();
        }

        this.cartItemList.add(cartItem);
        cartItem.cacheRelation(CartItem.SHOPPING_CART_PROPERTY, this);
        return this;
    }

    public static ShoppingCart refer(Long id){
        ShoppingCart refer = new ShoppingCart();
        refer.__internalSet("id", id);
        refer.set$status(EntityStatus.REFER);
        return refer;
    }
    @Override
    public String typeName(){
        return INTERNAL_TYPE;
    }

    public ShoppingCart comment(String comment){
        this.setComment(comment);
        return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Audited<ShoppingCart> auditAs(String action) {
        return super.auditAs(action);
    }

    // ===== Framework Internal: generated switch dispatch =====
    @Override
    @FrameworkInternal
    public void __internalSet(String property, Object value) {
        switch (property) {
            case "createdAt": this.createdAt = (LocalDateTime) value; break;

            case "customer": this.customer = (Customer) value; break;

            case "isAbandoned": this.isAbandoned = (Boolean) value; break;

            case "sessionId": this.sessionId = (value == null ? null : ((String)value).trim()); break;

            case "createTime": this.createTime = (LocalDateTime) value; break;

            case "updateTime": this.updateTime = (LocalDateTime) value; break;

            case "cartItemList": this.cartItemList = (SmartList<CartItem>) value; break;
            default: super.__internalSet(property, value);
        }
    }

    @Override
    @FrameworkInternal
    public Object __internalGet(String property) {
        switch (property) {
            case "createdAt": return this.createdAt;
            case "customer": return this.customer;
            case "isAbandoned": return this.isAbandoned;
            case "sessionId": return this.sessionId;
            case "createTime": return this.createTime;
            case "updateTime": return this.updateTime;
            case "cartItemList": return this.cartItemList;
            default: return super.__internalGet(property);
        }
    }

}