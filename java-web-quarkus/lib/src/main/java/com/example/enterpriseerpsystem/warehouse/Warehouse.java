
package com.example.enterpriseerpsystem.warehouse;

import com.example.enterpriseerpsystem.inventoryitem.InventoryItem;
import com.example.enterpriseerpsystem.shipment.Shipment;
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
public class Warehouse extends BaseEntity implements RemoteInput {
    public static String INTERNAL_TYPE = "Warehouse";

    public static final String NAME_PROPERTY = "name";
    public static final String CAPACITY_PROPERTY = "capacity";
    public static final String LOCATION_PROPERTY = "location";
    public static final String MANAGER_ID_PROPERTY = "managerId";
    public static final String CREATE_TIME_PROPERTY = "createTime";
    public static final String UPDATE_TIME_PROPERTY = "updateTime";
    public static final String INVENTORY_ITEM_LIST_PROPERTY = "inventoryItemList";
    public static final String SHIPMENT_LIST_PROPERTY = "shipmentList";
    private String name;
    private BigDecimal capacity;
    private String location;
    private String managerId;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private SmartList<InventoryItem> inventoryItemList;
    private SmartList<Shipment> shipmentList;

    public String getName(){
        return this.name;
    }
    public BigDecimal getCapacity(){
        return this.capacity;
    }
    public String getLocation(){
        return this.location;
    }
    public String getManagerId(){
        return this.managerId;
    }
    public LocalDateTime getCreateTime(){
        return this.createTime;
    }
    public LocalDateTime getUpdateTime(){
        return this.updateTime;
    }
    public SmartList<InventoryItem> getInventoryItemList(){
        return this.inventoryItemList;
    }
    public SmartList<Shipment> getShipmentList(){
        return this.shipmentList;
    }
    public Warehouse updateName(String name){
        name = (name == null ? null : name.trim());
        if(Objects.equals(this.name, name)){
            return this;
        }
        handleUpdate(NAME_PROPERTY, getName(), name);
        this.name = name;
        return this;
    }
    public Warehouse updateCapacity(BigDecimal capacity){
        if(Objects.equals(this.capacity, capacity)){
            return this;
        }
        handleUpdate(CAPACITY_PROPERTY, getCapacity(), capacity);
        this.capacity = capacity;
        return this;
    }
    public Warehouse updateLocation(String location){
        location = (location == null ? null : location.trim());
        if(Objects.equals(this.location, location)){
            return this;
        }
        handleUpdate(LOCATION_PROPERTY, getLocation(), location);
        this.location = location;
        return this;
    }
    public Warehouse updateManagerId(String managerId){
        managerId = (managerId == null ? null : managerId.trim());
        if(Objects.equals(this.managerId, managerId)){
            return this;
        }
        handleUpdate(MANAGER_ID_PROPERTY, getManagerId(), managerId);
        this.managerId = managerId;
        return this;
    }
    public Warehouse updateCreateTime(LocalDateTime createTime){
        if(Objects.equals(this.createTime, createTime)){
            return this;
        }
        handleUpdate(CREATE_TIME_PROPERTY, getCreateTime(), createTime);
        this.createTime = createTime;
        return this;
    }
    public Warehouse updateUpdateTime(LocalDateTime updateTime){
        if(Objects.equals(this.updateTime, updateTime)){
            return this;
        }
        handleUpdate(UPDATE_TIME_PROPERTY, getUpdateTime(), updateTime);
        this.updateTime = updateTime;
        return this;
    }
    public Warehouse addInventoryItem(InventoryItem inventoryItem){
        if (inventoryItem == null){
            return this;
        }

        if(null == this.inventoryItemList){
            this.inventoryItemList = new SmartList<>();
        }

        this.inventoryItemList.add(inventoryItem);
        inventoryItem.cacheRelation(InventoryItem.WAREHOUSE_PROPERTY, this);
        return this;
    }
    public Warehouse addShipment(Shipment shipment){
        if (shipment == null){
            return this;
        }

        if(null == this.shipmentList){
            this.shipmentList = new SmartList<>();
        }

        this.shipmentList.add(shipment);
        shipment.cacheRelation(Shipment.WAREHOUSE_PROPERTY, this);
        return this;
    }

    public static Warehouse refer(Long id){
        Warehouse refer = new Warehouse();
        refer.__internalSet("id", id);
        refer.set$status(EntityStatus.REFER);
        return refer;
    }
    @Override
    public String typeName(){
        return INTERNAL_TYPE;
    }

    public Warehouse comment(String comment){
        this.setComment(comment);
        return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Audited<Warehouse> auditAs(String action) {
        return super.auditAs(action);
    }

    // ===== Framework Internal: generated switch dispatch =====
    @Override
    @FrameworkInternal
    public void __internalSet(String property, Object value) {
        switch (property) {
            case "name": this.name = (value == null ? null : ((String)value).trim()); break;

            case "capacity": this.capacity = (BigDecimal) value; break;

            case "location": this.location = (value == null ? null : ((String)value).trim()); break;

            case "managerId": this.managerId = (value == null ? null : ((String)value).trim()); break;

            case "createTime": this.createTime = (LocalDateTime) value; break;

            case "updateTime": this.updateTime = (LocalDateTime) value; break;

            case "inventoryItemList": this.inventoryItemList = (SmartList<InventoryItem>) value; break;
            case "shipmentList": this.shipmentList = (SmartList<Shipment>) value; break;
            default: super.__internalSet(property, value);
        }
    }

    @Override
    @FrameworkInternal
    public Object __internalGet(String property) {
        switch (property) {
            case "name": return this.name;
            case "capacity": return this.capacity;
            case "location": return this.location;
            case "managerId": return this.managerId;
            case "createTime": return this.createTime;
            case "updateTime": return this.updateTime;
            case "inventoryItemList": return this.inventoryItemList;
            case "shipmentList": return this.shipmentList;
            default: return super.__internalGet(property);
        }
    }

}