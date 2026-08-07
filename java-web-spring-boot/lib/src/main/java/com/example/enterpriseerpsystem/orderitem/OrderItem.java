
package com.example.enterpriseerpsystem.orderitem;

import com.example.enterpriseerpsystem.globalorder.GlobalOrder;
import com.example.enterpriseerpsystem.product.Product;
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
public class OrderItem extends BaseEntity implements RemoteInput {
    public static String INTERNAL_TYPE = "OrderItem";

    public static final String UNIT_PRICE_PROPERTY = "unitPrice";
    public static final String GLOBAL_ORDER_PROPERTY = "globalOrder";
    public static final String PRODUCT_PROPERTY = "product";
    public static final String QUANTITY_PROPERTY = "quantity";
    public static final String CREATE_TIME_PROPERTY = "createTime";
    public static final String UPDATE_TIME_PROPERTY = "updateTime";
    private BigDecimal unitPrice;
    private GlobalOrder globalOrder;
    private Product product;
    private BigDecimal quantity;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

    public BigDecimal getUnitPrice(){
        return this.unitPrice;
    }
    public GlobalOrder getGlobalOrder(){
        return this.globalOrder;
    }
    public Product getProduct(){
        return this.product;
    }
    public BigDecimal getQuantity(){
        return this.quantity;
    }
    public LocalDateTime getCreateTime(){
        return this.createTime;
    }
    public LocalDateTime getUpdateTime(){
        return this.updateTime;
    }
    public OrderItem updateUnitPrice(BigDecimal unitPrice){
        if(Objects.equals(this.unitPrice, unitPrice)){
            return this;
        }
        handleUpdate(UNIT_PRICE_PROPERTY, getUnitPrice(), unitPrice);
        this.unitPrice = unitPrice;
        return this;
    }
    public OrderItem updateGlobalOrder(GlobalOrder globalOrder){
        if(Objects.equals(this.globalOrder, globalOrder)){
            return this;
        }
        handleUpdate(GLOBAL_ORDER_PROPERTY, getGlobalOrder(), globalOrder);
        this.globalOrder = globalOrder;
        return this;
    }
    public OrderItem updateProduct(Product product){
        if(Objects.equals(this.product, product)){
            return this;
        }
        handleUpdate(PRODUCT_PROPERTY, getProduct(), product);
        this.product = product;
        return this;
    }
    public OrderItem updateQuantity(BigDecimal quantity){
        if(Objects.equals(this.quantity, quantity)){
            return this;
        }
        handleUpdate(QUANTITY_PROPERTY, getQuantity(), quantity);
        this.quantity = quantity;
        return this;
    }
    public OrderItem updateCreateTime(LocalDateTime createTime){
        if(Objects.equals(this.createTime, createTime)){
            return this;
        }
        handleUpdate(CREATE_TIME_PROPERTY, getCreateTime(), createTime);
        this.createTime = createTime;
        return this;
    }
    public OrderItem updateUpdateTime(LocalDateTime updateTime){
        if(Objects.equals(this.updateTime, updateTime)){
            return this;
        }
        handleUpdate(UPDATE_TIME_PROPERTY, getUpdateTime(), updateTime);
        this.updateTime = updateTime;
        return this;
    }

    public static OrderItem refer(Long id){
        OrderItem refer = new OrderItem();
        refer.__internalSet("id", id);
        refer.set$status(EntityStatus.REFER);
        return refer;
    }
    @Override
    public String typeName(){
        return INTERNAL_TYPE;
    }

    public OrderItem comment(String comment){
        this.setComment(comment);
        return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Audited<OrderItem> auditAs(String action) {
        return super.auditAs(action);
    }

    // ===== Framework Internal: generated switch dispatch =====
    @Override
    @FrameworkInternal
    public void __internalSet(String property, Object value) {
        switch (property) {
            case "unitPrice": this.unitPrice = (BigDecimal) value; break;

            case "globalOrder": this.globalOrder = (GlobalOrder) value; break;

            case "product": this.product = (Product) value; break;

            case "quantity": this.quantity = (BigDecimal) value; break;

            case "createTime": this.createTime = (LocalDateTime) value; break;

            case "updateTime": this.updateTime = (LocalDateTime) value; break;

            default: super.__internalSet(property, value);
        }
    }

    @Override
    @FrameworkInternal
    public Object __internalGet(String property) {
        switch (property) {
            case "unitPrice": return this.unitPrice;
            case "globalOrder": return this.globalOrder;
            case "product": return this.product;
            case "quantity": return this.quantity;
            case "createTime": return this.createTime;
            case "updateTime": return this.updateTime;
            default: return super.__internalGet(property);
        }
    }

}