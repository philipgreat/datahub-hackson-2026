
package com.example.enterpriseerpsystem.purchaseorder;

import com.example.enterpriseerpsystem.purchaseorderitem.PurchaseOrderItem;
import com.example.enterpriseerpsystem.supplier.Supplier;
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
public class PurchaseOrder extends BaseEntity implements RemoteInput {
    public static String INTERNAL_TYPE = "PurchaseOrder";

    public static final String ORDER_DATE_PROPERTY = "orderDate";
    public static final String STATUS_PROPERTY = "status";
    public static final String SUPPLIER_PROPERTY = "supplier";
    public static final String TOTAL_COST_PROPERTY = "totalCost";
    public static final String CREATE_TIME_PROPERTY = "createTime";
    public static final String UPDATE_TIME_PROPERTY = "updateTime";
    public static final String PURCHASE_ORDER_ITEM_LIST_PROPERTY = "purchaseOrderItemList";
    private LocalDateTime orderDate;
    private String status;
    private Supplier supplier;
    private BigDecimal totalCost;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private SmartList<PurchaseOrderItem> purchaseOrderItemList;

    public LocalDateTime getOrderDate(){
        return this.orderDate;
    }
    public String getStatus(){
        return this.status;
    }
    public Supplier getSupplier(){
        return this.supplier;
    }
    public BigDecimal getTotalCost(){
        return this.totalCost;
    }
    public LocalDateTime getCreateTime(){
        return this.createTime;
    }
    public LocalDateTime getUpdateTime(){
        return this.updateTime;
    }
    public SmartList<PurchaseOrderItem> getPurchaseOrderItemList(){
        return this.purchaseOrderItemList;
    }
    public PurchaseOrder updateOrderDate(LocalDateTime orderDate){
        if(Objects.equals(this.orderDate, orderDate)){
            return this;
        }
        handleUpdate(ORDER_DATE_PROPERTY, getOrderDate(), orderDate);
        this.orderDate = orderDate;
        return this;
    }
    public PurchaseOrder updateStatus(String status){
        status = (status == null ? null : status.trim());
        if(Objects.equals(this.status, status)){
            return this;
        }
        handleUpdate(STATUS_PROPERTY, getStatus(), status);
        this.status = status;
        return this;
    }
    public PurchaseOrder updateSupplier(Supplier supplier){
        if(Objects.equals(this.supplier, supplier)){
            return this;
        }
        handleUpdate(SUPPLIER_PROPERTY, getSupplier(), supplier);
        this.supplier = supplier;
        return this;
    }
    public PurchaseOrder updateTotalCost(BigDecimal totalCost){
        if(Objects.equals(this.totalCost, totalCost)){
            return this;
        }
        handleUpdate(TOTAL_COST_PROPERTY, getTotalCost(), totalCost);
        this.totalCost = totalCost;
        return this;
    }
    public PurchaseOrder updateCreateTime(LocalDateTime createTime){
        if(Objects.equals(this.createTime, createTime)){
            return this;
        }
        handleUpdate(CREATE_TIME_PROPERTY, getCreateTime(), createTime);
        this.createTime = createTime;
        return this;
    }
    public PurchaseOrder updateUpdateTime(LocalDateTime updateTime){
        if(Objects.equals(this.updateTime, updateTime)){
            return this;
        }
        handleUpdate(UPDATE_TIME_PROPERTY, getUpdateTime(), updateTime);
        this.updateTime = updateTime;
        return this;
    }
    public PurchaseOrder addPurchaseOrderItem(PurchaseOrderItem purchaseOrderItem){
        if (purchaseOrderItem == null){
            return this;
        }

        if(null == this.purchaseOrderItemList){
            this.purchaseOrderItemList = new SmartList<>();
        }

        this.purchaseOrderItemList.add(purchaseOrderItem);
        purchaseOrderItem.cacheRelation(PurchaseOrderItem.PURCHASE_ORDER_PROPERTY, this);
        return this;
    }

    public static PurchaseOrder refer(Long id){
        PurchaseOrder refer = new PurchaseOrder();
        refer.__internalSet("id", id);
        refer.set$status(EntityStatus.REFER);
        return refer;
    }
    @Override
    public String typeName(){
        return INTERNAL_TYPE;
    }

    public PurchaseOrder comment(String comment){
        this.setComment(comment);
        return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Audited<PurchaseOrder> auditAs(String action) {
        return super.auditAs(action);
    }

    // ===== Framework Internal: generated switch dispatch =====
    @Override
    @FrameworkInternal
    public void __internalSet(String property, Object value) {
        switch (property) {
            case "orderDate": this.orderDate = (LocalDateTime) value; break;

            case "status": this.status = (value == null ? null : ((String)value).trim()); break;

            case "supplier": this.supplier = (Supplier) value; break;

            case "totalCost": this.totalCost = (BigDecimal) value; break;

            case "createTime": this.createTime = (LocalDateTime) value; break;

            case "updateTime": this.updateTime = (LocalDateTime) value; break;

            case "purchaseOrderItemList": this.purchaseOrderItemList = (SmartList<PurchaseOrderItem>) value; break;
            default: super.__internalSet(property, value);
        }
    }

    @Override
    @FrameworkInternal
    public Object __internalGet(String property) {
        switch (property) {
            case "orderDate": return this.orderDate;
            case "status": return this.status;
            case "supplier": return this.supplier;
            case "totalCost": return this.totalCost;
            case "createTime": return this.createTime;
            case "updateTime": return this.updateTime;
            case "purchaseOrderItemList": return this.purchaseOrderItemList;
            default: return super.__internalGet(property);
        }
    }

}