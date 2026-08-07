
package com.example.enterpriseerpsystem.purchaseorderitem;

import com.example.enterpriseerpsystem.product.Product;
import com.example.enterpriseerpsystem.purchaseorder.PurchaseOrder;
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
public class PurchaseOrderItem extends BaseEntity implements RemoteInput {
    public static String INTERNAL_TYPE = "PurchaseOrderItem";

    public static final String PRODUCT_PROPERTY = "product";
    public static final String PURCHASE_ORDER_PROPERTY = "purchaseOrder";
    public static final String QUANTITY_PROPERTY = "quantity";
    public static final String UNIT_COST_PROPERTY = "unitCost";
    public static final String CREATE_TIME_PROPERTY = "createTime";
    public static final String UPDATE_TIME_PROPERTY = "updateTime";
    private Product product;
    private PurchaseOrder purchaseOrder;
    private BigDecimal quantity;
    private BigDecimal unitCost;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

    public Product getProduct(){
        return this.product;
    }
    public PurchaseOrder getPurchaseOrder(){
        return this.purchaseOrder;
    }
    public BigDecimal getQuantity(){
        return this.quantity;
    }
    public BigDecimal getUnitCost(){
        return this.unitCost;
    }
    public LocalDateTime getCreateTime(){
        return this.createTime;
    }
    public LocalDateTime getUpdateTime(){
        return this.updateTime;
    }
    public PurchaseOrderItem updateProduct(Product product){
        if(Objects.equals(this.product, product)){
            return this;
        }
        handleUpdate(PRODUCT_PROPERTY, getProduct(), product);
        this.product = product;
        return this;
    }
    public PurchaseOrderItem updatePurchaseOrder(PurchaseOrder purchaseOrder){
        if(Objects.equals(this.purchaseOrder, purchaseOrder)){
            return this;
        }
        handleUpdate(PURCHASE_ORDER_PROPERTY, getPurchaseOrder(), purchaseOrder);
        this.purchaseOrder = purchaseOrder;
        return this;
    }
    public PurchaseOrderItem updateQuantity(BigDecimal quantity){
        if(Objects.equals(this.quantity, quantity)){
            return this;
        }
        handleUpdate(QUANTITY_PROPERTY, getQuantity(), quantity);
        this.quantity = quantity;
        return this;
    }
    public PurchaseOrderItem updateUnitCost(BigDecimal unitCost){
        if(Objects.equals(this.unitCost, unitCost)){
            return this;
        }
        handleUpdate(UNIT_COST_PROPERTY, getUnitCost(), unitCost);
        this.unitCost = unitCost;
        return this;
    }
    public PurchaseOrderItem updateCreateTime(LocalDateTime createTime){
        if(Objects.equals(this.createTime, createTime)){
            return this;
        }
        handleUpdate(CREATE_TIME_PROPERTY, getCreateTime(), createTime);
        this.createTime = createTime;
        return this;
    }
    public PurchaseOrderItem updateUpdateTime(LocalDateTime updateTime){
        if(Objects.equals(this.updateTime, updateTime)){
            return this;
        }
        handleUpdate(UPDATE_TIME_PROPERTY, getUpdateTime(), updateTime);
        this.updateTime = updateTime;
        return this;
    }

    public static PurchaseOrderItem refer(Long id){
        PurchaseOrderItem refer = new PurchaseOrderItem();
        refer.__internalSet("id", id);
        refer.set$status(EntityStatus.REFER);
        return refer;
    }
    @Override
    public String typeName(){
        return INTERNAL_TYPE;
    }

    public PurchaseOrderItem comment(String comment){
        this.setComment(comment);
        return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Audited<PurchaseOrderItem> auditAs(String action) {
        return super.auditAs(action);
    }

    // ===== Framework Internal: generated switch dispatch =====
    @Override
    @FrameworkInternal
    public void __internalSet(String property, Object value) {
        switch (property) {
            case "product": this.product = (Product) value; break;

            case "purchaseOrder": this.purchaseOrder = (PurchaseOrder) value; break;

            case "quantity": this.quantity = (BigDecimal) value; break;

            case "unitCost": this.unitCost = (BigDecimal) value; break;

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
            case "purchaseOrder": return this.purchaseOrder;
            case "quantity": return this.quantity;
            case "unitCost": return this.unitCost;
            case "createTime": return this.createTime;
            case "updateTime": return this.updateTime;
            default: return super.__internalGet(property);
        }
    }

}