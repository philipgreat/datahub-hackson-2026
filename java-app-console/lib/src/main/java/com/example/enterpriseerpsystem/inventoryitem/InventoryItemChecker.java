
package com.example.enterpriseerpsystem.inventoryitem;

import com.example.enterpriseerpsystem.product.Product;
import com.example.enterpriseerpsystem.product.ProductChecker;
import com.example.enterpriseerpsystem.warehouse.Warehouse;
import com.example.enterpriseerpsystem.warehouse.WarehouseChecker;
import io.teaql.core.UserContext;
import io.teaql.core.checker.Checker;
import io.teaql.core.checker.ObjectLocation;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class InventoryItemChecker implements Checker<InventoryItem>{

    public String type(){
        return InventoryItem.INTERNAL_TYPE;
    }

    public void checkAndFix(UserContext _ctx, InventoryItem inventoryItem, ObjectLocation _parentLocation){
        if(needCheck(_ctx, inventoryItem)){
            markAsChecked(_ctx, inventoryItem);
            doCheck(_ctx, inventoryItem, _parentLocation);
        }
    }

    public void doCheck(UserContext _ctx, InventoryItem inventoryItem, ObjectLocation _parentLocation){
      if((inventoryItem == null)){
         return;
      }
      if(inventoryItem.newItem()){
        if(inventoryItem.getCreateTime() == null){
           inventoryItem.updateCreateTime(java.time.LocalDateTime.now());
        }if(inventoryItem.getUpdateTime() == null){
           inventoryItem.updateUpdateTime(java.time.LocalDateTime.now());
        }
      }else if(inventoryItem.updateItem()){
        inventoryItem.updateUpdateTime(java.time.LocalDateTime.now());
      }
      checkProduct(_ctx, inventoryItem.getProperty(InventoryItem.PRODUCT_PROPERTY), newLocation(_parentLocation, InventoryItem.PRODUCT_PROPERTY));
      checkQuantityOnHand(_ctx, inventoryItem.getProperty(InventoryItem.QUANTITY_ON_HAND_PROPERTY), newLocation(_parentLocation, InventoryItem.QUANTITY_ON_HAND_PROPERTY));
      checkReorderLevel(_ctx, inventoryItem.getProperty(InventoryItem.REORDER_LEVEL_PROPERTY), newLocation(_parentLocation, InventoryItem.REORDER_LEVEL_PROPERTY));
      checkWarehouse(_ctx, inventoryItem.getProperty(InventoryItem.WAREHOUSE_PROPERTY), newLocation(_parentLocation, InventoryItem.WAREHOUSE_PROPERTY));
      checkCreateTime(_ctx, inventoryItem.getProperty(InventoryItem.CREATE_TIME_PROPERTY), newLocation(_parentLocation, InventoryItem.CREATE_TIME_PROPERTY));
      checkUpdateTime(_ctx, inventoryItem.getProperty(InventoryItem.UPDATE_TIME_PROPERTY), newLocation(_parentLocation, InventoryItem.UPDATE_TIME_PROPERTY));
    }

    public void checkProduct(UserContext _ctx, Product product, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, product);
    if((product == null)){
        return;
    }
    new ProductChecker().checkAndFix(_ctx, product, _parentLocation);
    }
    public void checkQuantityOnHand(UserContext _ctx, BigDecimal quantityOnHand, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, quantityOnHand);
    if((quantityOnHand == null)){
        return;
    }
    }
    public void checkReorderLevel(UserContext _ctx, BigDecimal reorderLevel, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, reorderLevel);
    if((reorderLevel == null)){
        return;
    }
    }
    public void checkWarehouse(UserContext _ctx, Warehouse warehouse, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, warehouse);
    if((warehouse == null)){
        return;
    }
    new WarehouseChecker().checkAndFix(_ctx, warehouse, _parentLocation);
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