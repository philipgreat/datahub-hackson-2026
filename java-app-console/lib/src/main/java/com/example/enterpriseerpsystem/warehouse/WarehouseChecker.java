
package com.example.enterpriseerpsystem.warehouse;

import com.example.enterpriseerpsystem.inventoryitem.InventoryItem;
import com.example.enterpriseerpsystem.inventoryitem.InventoryItemChecker;
import com.example.enterpriseerpsystem.shipment.Shipment;
import com.example.enterpriseerpsystem.shipment.ShipmentChecker;
import io.teaql.core.UserContext;
import io.teaql.core.checker.Checker;
import io.teaql.core.checker.ObjectLocation;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class WarehouseChecker implements Checker<Warehouse>{

    public String type(){
        return Warehouse.INTERNAL_TYPE;
    }

    public void checkAndFix(UserContext _ctx, Warehouse warehouse, ObjectLocation _parentLocation){
        if(needCheck(_ctx, warehouse)){
            markAsChecked(_ctx, warehouse);
            doCheck(_ctx, warehouse, _parentLocation);
        }
    }

    public void doCheck(UserContext _ctx, Warehouse warehouse, ObjectLocation _parentLocation){
      if((warehouse == null)){
         return;
      }
      if(warehouse.newItem()){
        if(warehouse.getCreateTime() == null){
           warehouse.updateCreateTime(java.time.LocalDateTime.now());
        }if(warehouse.getUpdateTime() == null){
           warehouse.updateUpdateTime(java.time.LocalDateTime.now());
        }
      }else if(warehouse.updateItem()){
        warehouse.updateUpdateTime(java.time.LocalDateTime.now());
      }
      checkName(_ctx, warehouse.getProperty(Warehouse.NAME_PROPERTY), newLocation(_parentLocation, Warehouse.NAME_PROPERTY));
      checkCapacity(_ctx, warehouse.getProperty(Warehouse.CAPACITY_PROPERTY), newLocation(_parentLocation, Warehouse.CAPACITY_PROPERTY));
      checkLocation(_ctx, warehouse.getProperty(Warehouse.LOCATION_PROPERTY), newLocation(_parentLocation, Warehouse.LOCATION_PROPERTY));
      checkManagerId(_ctx, warehouse.getProperty(Warehouse.MANAGER_ID_PROPERTY), newLocation(_parentLocation, Warehouse.MANAGER_ID_PROPERTY));
      checkCreateTime(_ctx, warehouse.getProperty(Warehouse.CREATE_TIME_PROPERTY), newLocation(_parentLocation, Warehouse.CREATE_TIME_PROPERTY));
      checkUpdateTime(_ctx, warehouse.getProperty(Warehouse.UPDATE_TIME_PROPERTY), newLocation(_parentLocation, Warehouse.UPDATE_TIME_PROPERTY));
      for(int i = 0; warehouse.getInventoryItemList() != null && i < warehouse.getInventoryItemList().size(); i++){
         InventoryItem inventoryItem = warehouse.getInventoryItemList().get(i);
         new InventoryItemChecker().checkAndFix(_ctx, inventoryItem, newLocation(_parentLocation, Warehouse.INVENTORY_ITEM_LIST_PROPERTY, i));
      }
      for(int i = 0; warehouse.getShipmentList() != null && i < warehouse.getShipmentList().size(); i++){
         Shipment shipment = warehouse.getShipmentList().get(i);
         new ShipmentChecker().checkAndFix(_ctx, shipment, newLocation(_parentLocation, Warehouse.SHIPMENT_LIST_PROPERTY, i));
      }
    }

    public void checkName(UserContext _ctx, String name, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, name);
    if((name == null)){
        return;
    }
    maxStringCheck(_ctx, _parentLocation, 100, name);

    }
    public void checkCapacity(UserContext _ctx, BigDecimal capacity, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, capacity);
    if((capacity == null)){
        return;
    }
    }
    public void checkLocation(UserContext _ctx, String location, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, location);
    if((location == null)){
        return;
    }
    maxStringCheck(_ctx, _parentLocation, 100, location);

    }
    public void checkManagerId(UserContext _ctx, String managerId, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, managerId);
    if((managerId == null)){
        return;
    }
    maxStringCheck(_ctx, _parentLocation, 100, managerId);

    }
    public void checkCreateTime(UserContext _ctx, LocalDateTime createTime, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, createTime);
    if((createTime == null)){
        return;
    }
    }
    public void checkUpdateTime(UserContext _ctx, LocalDateTime updateTime, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, updateTime);
    if((updateTime == null)){
        return;
    }
    }
}