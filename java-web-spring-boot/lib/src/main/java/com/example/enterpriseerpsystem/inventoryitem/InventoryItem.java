
package com.example.enterpriseerpsystem.inventoryitem;

import com.example.enterpriseerpsystem.product.Product;
import com.example.enterpriseerpsystem.warehouse.Warehouse;
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
public class InventoryItem extends BaseEntity implements RemoteInput {
    public static String INTERNAL_TYPE = "InventoryItem";

    public static final String PRODUCT_PROPERTY = "product";
    public static final String QUANTITY_ON_HAND_PROPERTY = "quantityOnHand";
    public static final String REORDER_LEVEL_PROPERTY = "reorderLevel";
    public static final String WAREHOUSE_PROPERTY = "warehouse";
    public static final String CREATE_TIME_PROPERTY = "createTime";
    public static final String UPDATE_TIME_PROPERTY = "updateTime";
    private Product product;
    private BigDecimal quantityOnHand;
    private BigDecimal reorderLevel;
    private Warehouse warehouse;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

    public Product getProduct(){
        return this.product;
    }
    public BigDecimal getQuantityOnHand(){
        return this.quantityOnHand;
    }
    public BigDecimal getReorderLevel(){
        return this.reorderLevel;
    }
    public Warehouse getWarehouse(){
        return this.warehouse;
    }
    public LocalDateTime getCreateTime(){
        return this.createTime;
    }
    public LocalDateTime getUpdateTime(){
        return this.updateTime;
    }
    public InventoryItem updateProduct(Product product){
        if(Objects.equals(this.product, product)){
            return this;
        }
        handleUpdate(PRODUCT_PROPERTY, getProduct(), product);
        this.product = product;
        return this;
    }
    public InventoryItem updateQuantityOnHand(BigDecimal quantityOnHand){
        if(Objects.equals(this.quantityOnHand, quantityOnHand)){
            return this;
        }
        handleUpdate(QUANTITY_ON_HAND_PROPERTY, getQuantityOnHand(), quantityOnHand);
        this.quantityOnHand = quantityOnHand;
        return this;
    }
    public InventoryItem updateReorderLevel(BigDecimal reorderLevel){
        if(Objects.equals(this.reorderLevel, reorderLevel)){
            return this;
        }
        handleUpdate(REORDER_LEVEL_PROPERTY, getReorderLevel(), reorderLevel);
        this.reorderLevel = reorderLevel;
        return this;
    }
    public InventoryItem updateWarehouse(Warehouse warehouse){
        if(Objects.equals(this.warehouse, warehouse)){
            return this;
        }
        handleUpdate(WAREHOUSE_PROPERTY, getWarehouse(), warehouse);
        this.warehouse = warehouse;
        return this;
    }
    public InventoryItem updateCreateTime(LocalDateTime createTime){
        if(Objects.equals(this.createTime, createTime)){
            return this;
        }
        handleUpdate(CREATE_TIME_PROPERTY, getCreateTime(), createTime);
        this.createTime = createTime;
        return this;
    }
    public InventoryItem updateUpdateTime(LocalDateTime updateTime){
        if(Objects.equals(this.updateTime, updateTime)){
            return this;
        }
        handleUpdate(UPDATE_TIME_PROPERTY, getUpdateTime(), updateTime);
        this.updateTime = updateTime;
        return this;
    }

    public static InventoryItem refer(Long id){
        InventoryItem refer = new InventoryItem();
        refer.__internalSet("id", id);
        refer.set$status(EntityStatus.REFER);
        return refer;
    }
    @Override
    public String typeName(){
        return INTERNAL_TYPE;
    }

    public InventoryItem comment(String comment){
        this.setComment(comment);
        return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Audited<InventoryItem> auditAs(String action) {
        return super.auditAs(action);
    }

    // ===== Framework Internal: generated switch dispatch =====
    @Override
    @FrameworkInternal
    public void __internalSet(String property, Object value) {
        switch (property) {
            case "product": this.product = (Product) value; break;

            case "quantityOnHand": this.quantityOnHand = (BigDecimal) value; break;

            case "reorderLevel": this.reorderLevel = (BigDecimal) value; break;

            case "warehouse": this.warehouse = (Warehouse) value; break;

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
            case "quantityOnHand": return this.quantityOnHand;
            case "reorderLevel": return this.reorderLevel;
            case "warehouse": return this.warehouse;
            case "createTime": return this.createTime;
            case "updateTime": return this.updateTime;
            default: return super.__internalGet(property);
        }
    }

}