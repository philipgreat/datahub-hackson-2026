
package com.example.enterpriseerpsystem.cartitem;

import com.example.enterpriseerpsystem.product.Product;
import com.example.enterpriseerpsystem.shoppingcart.ShoppingCart;
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
public class CartItem extends BaseEntity implements RemoteInput {
    public static String INTERNAL_TYPE = "CartItem";

    public static final String PRODUCT_PROPERTY = "product";
    public static final String QUANTITY_PROPERTY = "quantity";
    public static final String SHOPPING_CART_PROPERTY = "shoppingCart";
    public static final String CREATE_TIME_PROPERTY = "createTime";
    public static final String UPDATE_TIME_PROPERTY = "updateTime";
    private Product product;
    private BigDecimal quantity;
    private ShoppingCart shoppingCart;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

    public Product getProduct(){
        return this.product;
    }
    public BigDecimal getQuantity(){
        return this.quantity;
    }
    public ShoppingCart getShoppingCart(){
        return this.shoppingCart;
    }
    public LocalDateTime getCreateTime(){
        return this.createTime;
    }
    public LocalDateTime getUpdateTime(){
        return this.updateTime;
    }
    public CartItem updateProduct(Product product){
        if(Objects.equals(this.product, product)){
            return this;
        }
        handleUpdate(PRODUCT_PROPERTY, getProduct(), product);
        this.product = product;
        return this;
    }
    public CartItem updateQuantity(BigDecimal quantity){
        if(Objects.equals(this.quantity, quantity)){
            return this;
        }
        handleUpdate(QUANTITY_PROPERTY, getQuantity(), quantity);
        this.quantity = quantity;
        return this;
    }
    public CartItem updateShoppingCart(ShoppingCart shoppingCart){
        if(Objects.equals(this.shoppingCart, shoppingCart)){
            return this;
        }
        handleUpdate(SHOPPING_CART_PROPERTY, getShoppingCart(), shoppingCart);
        this.shoppingCart = shoppingCart;
        return this;
    }
    public CartItem updateCreateTime(LocalDateTime createTime){
        if(Objects.equals(this.createTime, createTime)){
            return this;
        }
        handleUpdate(CREATE_TIME_PROPERTY, getCreateTime(), createTime);
        this.createTime = createTime;
        return this;
    }
    public CartItem updateUpdateTime(LocalDateTime updateTime){
        if(Objects.equals(this.updateTime, updateTime)){
            return this;
        }
        handleUpdate(UPDATE_TIME_PROPERTY, getUpdateTime(), updateTime);
        this.updateTime = updateTime;
        return this;
    }

    public static CartItem refer(Long id){
        CartItem refer = new CartItem();
        refer.__internalSet("id", id);
        refer.set$status(EntityStatus.REFER);
        return refer;
    }
    @Override
    public String typeName(){
        return INTERNAL_TYPE;
    }

    public CartItem comment(String comment){
        this.setComment(comment);
        return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Audited<CartItem> auditAs(String action) {
        return super.auditAs(action);
    }

    // ===== Framework Internal: generated switch dispatch =====
    @Override
    @FrameworkInternal
    public void __internalSet(String property, Object value) {
        switch (property) {
            case "product": this.product = (Product) value; break;

            case "quantity": this.quantity = (BigDecimal) value; break;

            case "shoppingCart": this.shoppingCart = (ShoppingCart) value; break;

            case "createTime": this.createTime = (LocalDateTime) value; break;

            case "updateTime": this.updateTime = (LocalDateTime) value; break;

            default: super.__internalSet(property, value);
        }
    }

    @Override
    @FrameworkInternal
    public Object __internalGet(String property) {
        switch (property) {
            case "product": return this.product;
            case "quantity": return this.quantity;
            case "shoppingCart": return this.shoppingCart;
            case "createTime": return this.createTime;
            case "updateTime": return this.updateTime;
            default: return super.__internalGet(property);
        }
    }

}