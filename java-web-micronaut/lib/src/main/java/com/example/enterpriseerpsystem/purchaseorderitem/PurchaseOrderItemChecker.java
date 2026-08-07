
package com.example.enterpriseerpsystem.purchaseorderitem;

import com.example.enterpriseerpsystem.product.Product;
import com.example.enterpriseerpsystem.product.ProductChecker;
import com.example.enterpriseerpsystem.purchaseorder.PurchaseOrder;
import com.example.enterpriseerpsystem.purchaseorder.PurchaseOrderChecker;
import io.teaql.core.UserContext;
import io.teaql.core.checker.Checker;
import io.teaql.core.checker.ObjectLocation;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class PurchaseOrderItemChecker implements Checker<PurchaseOrderItem>{

    public String type(){
        return PurchaseOrderItem.INTERNAL_TYPE;
    }

    public void checkAndFix(UserContext _ctx, PurchaseOrderItem purchaseOrderItem, ObjectLocation _parentLocation){
        if(needCheck(_ctx, purchaseOrderItem)){
            markAsChecked(_ctx, purchaseOrderItem);
            doCheck(_ctx, purchaseOrderItem, _parentLocation);
        }
    }

    public void doCheck(UserContext _ctx, PurchaseOrderItem purchaseOrderItem, ObjectLocation _parentLocation){
      if((purchaseOrderItem == null)){
         return;
      }
      if(purchaseOrderItem.newItem()){
        if(purchaseOrderItem.getCreateTime() == null){
           purchaseOrderItem.updateCreateTime(java.time.LocalDateTime.now());
        }if(purchaseOrderItem.getUpdateTime() == null){
           purchaseOrderItem.updateUpdateTime(java.time.LocalDateTime.now());
        }
      }else if(purchaseOrderItem.updateItem()){
        purchaseOrderItem.updateUpdateTime(java.time.LocalDateTime.now());
      }
      checkProduct(_ctx, purchaseOrderItem.getProperty(PurchaseOrderItem.PRODUCT_PROPERTY), newLocation(_parentLocation, PurchaseOrderItem.PRODUCT_PROPERTY));
      checkPurchaseOrder(_ctx, purchaseOrderItem.getProperty(PurchaseOrderItem.PURCHASE_ORDER_PROPERTY), newLocation(_parentLocation, PurchaseOrderItem.PURCHASE_ORDER_PROPERTY));
      checkQuantity(_ctx, purchaseOrderItem.getProperty(PurchaseOrderItem.QUANTITY_PROPERTY), newLocation(_parentLocation, PurchaseOrderItem.QUANTITY_PROPERTY));
      checkUnitCost(_ctx, purchaseOrderItem.getProperty(PurchaseOrderItem.UNIT_COST_PROPERTY), newLocation(_parentLocation, PurchaseOrderItem.UNIT_COST_PROPERTY));
      checkCreateTime(_ctx, purchaseOrderItem.getProperty(PurchaseOrderItem.CREATE_TIME_PROPERTY), newLocation(_parentLocation, PurchaseOrderItem.CREATE_TIME_PROPERTY));
      checkUpdateTime(_ctx, purchaseOrderItem.getProperty(PurchaseOrderItem.UPDATE_TIME_PROPERTY), newLocation(_parentLocation, PurchaseOrderItem.UPDATE_TIME_PROPERTY));
    }

    public void checkProduct(UserContext _ctx, Product product, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, product);
    if((product == null)){
        return;
    }
    new ProductChecker().checkAndFix(_ctx, product, _parentLocation);
    }
    public void checkPurchaseOrder(UserContext _ctx, PurchaseOrder purchaseOrder, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, purchaseOrder);
    if((purchaseOrder == null)){
        return;
    }
    new PurchaseOrderChecker().checkAndFix(_ctx, purchaseOrder, _parentLocation);
    }
    public void checkQuantity(UserContext _ctx, BigDecimal quantity, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, quantity);
    if((quantity == null)){
        return;
    }
    }
    public void checkUnitCost(UserContext _ctx, BigDecimal unitCost, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, unitCost);
    if((unitCost == null)){
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