
package com.example.enterpriseerpsystem.purchaseorder;

import com.example.enterpriseerpsystem.purchaseorderitem.PurchaseOrderItem;
import com.example.enterpriseerpsystem.purchaseorderitem.PurchaseOrderItemChecker;
import com.example.enterpriseerpsystem.supplier.Supplier;
import com.example.enterpriseerpsystem.supplier.SupplierChecker;
import io.teaql.core.UserContext;
import io.teaql.core.checker.Checker;
import io.teaql.core.checker.ObjectLocation;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class PurchaseOrderChecker implements Checker<PurchaseOrder>{

    public String type(){
        return PurchaseOrder.INTERNAL_TYPE;
    }

    public void checkAndFix(UserContext _ctx, PurchaseOrder purchaseOrder, ObjectLocation _parentLocation){
        if(needCheck(_ctx, purchaseOrder)){
            markAsChecked(_ctx, purchaseOrder);
            doCheck(_ctx, purchaseOrder, _parentLocation);
        }
    }

    public void doCheck(UserContext _ctx, PurchaseOrder purchaseOrder, ObjectLocation _parentLocation){
      if((purchaseOrder == null)){
         return;
      }
      if(purchaseOrder.newItem()){
        if(purchaseOrder.getOrderDate() == null){
           purchaseOrder.updateOrderDate(java.time.LocalDateTime.now());
        }if(purchaseOrder.getCreateTime() == null){
           purchaseOrder.updateCreateTime(java.time.LocalDateTime.now());
        }if(purchaseOrder.getUpdateTime() == null){
           purchaseOrder.updateUpdateTime(java.time.LocalDateTime.now());
        }
      }else if(purchaseOrder.updateItem()){
        purchaseOrder.updateUpdateTime(java.time.LocalDateTime.now());
      }
      checkOrderDate(_ctx, purchaseOrder.getProperty(PurchaseOrder.ORDER_DATE_PROPERTY), newLocation(_parentLocation, PurchaseOrder.ORDER_DATE_PROPERTY));
      checkStatus(_ctx, purchaseOrder.getProperty(PurchaseOrder.STATUS_PROPERTY), newLocation(_parentLocation, PurchaseOrder.STATUS_PROPERTY));
      checkSupplier(_ctx, purchaseOrder.getProperty(PurchaseOrder.SUPPLIER_PROPERTY), newLocation(_parentLocation, PurchaseOrder.SUPPLIER_PROPERTY));
      checkTotalCost(_ctx, purchaseOrder.getProperty(PurchaseOrder.TOTAL_COST_PROPERTY), newLocation(_parentLocation, PurchaseOrder.TOTAL_COST_PROPERTY));
      checkCreateTime(_ctx, purchaseOrder.getProperty(PurchaseOrder.CREATE_TIME_PROPERTY), newLocation(_parentLocation, PurchaseOrder.CREATE_TIME_PROPERTY));
      checkUpdateTime(_ctx, purchaseOrder.getProperty(PurchaseOrder.UPDATE_TIME_PROPERTY), newLocation(_parentLocation, PurchaseOrder.UPDATE_TIME_PROPERTY));
      for(int i = 0; purchaseOrder.getPurchaseOrderItemList() != null && i < purchaseOrder.getPurchaseOrderItemList().size(); i++){
         PurchaseOrderItem purchaseOrderItem = purchaseOrder.getPurchaseOrderItemList().get(i);
         new PurchaseOrderItemChecker().checkAndFix(_ctx, purchaseOrderItem, newLocation(_parentLocation, PurchaseOrder.PURCHASE_ORDER_ITEM_LIST_PROPERTY, i));
      }
    }

    public void checkOrderDate(UserContext _ctx, LocalDateTime orderDate, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, orderDate);
    if((orderDate == null)){
        return;
    }
    }
    public void checkStatus(UserContext _ctx, String status, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, status);
    if((status == null)){
        return;
    }
    maxStringCheck(_ctx, _parentLocation, 100, status);

    }
    public void checkSupplier(UserContext _ctx, Supplier supplier, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, supplier);
    if((supplier == null)){
        return;
    }
    new SupplierChecker().checkAndFix(_ctx, supplier, _parentLocation);
    }
    public void checkTotalCost(UserContext _ctx, BigDecimal totalCost, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, totalCost);
    if((totalCost == null)){
        return;
    }
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