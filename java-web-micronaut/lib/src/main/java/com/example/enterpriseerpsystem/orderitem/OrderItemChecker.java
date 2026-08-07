
package com.example.enterpriseerpsystem.orderitem;

import com.example.enterpriseerpsystem.globalorder.GlobalOrder;
import com.example.enterpriseerpsystem.globalorder.GlobalOrderChecker;
import com.example.enterpriseerpsystem.product.Product;
import com.example.enterpriseerpsystem.product.ProductChecker;
import io.teaql.core.UserContext;
import io.teaql.core.checker.Checker;
import io.teaql.core.checker.ObjectLocation;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class OrderItemChecker implements Checker<OrderItem>{

    public String type(){
        return OrderItem.INTERNAL_TYPE;
    }

    public void checkAndFix(UserContext _ctx, OrderItem orderItem, ObjectLocation _parentLocation){
        if(needCheck(_ctx, orderItem)){
            markAsChecked(_ctx, orderItem);
            doCheck(_ctx, orderItem, _parentLocation);
        }
    }

    public void doCheck(UserContext _ctx, OrderItem orderItem, ObjectLocation _parentLocation){
      if((orderItem == null)){
         return;
      }
      if(orderItem.newItem()){
        if(orderItem.getCreateTime() == null){
           orderItem.updateCreateTime(java.time.LocalDateTime.now());
        }if(orderItem.getUpdateTime() == null){
           orderItem.updateUpdateTime(java.time.LocalDateTime.now());
        }
      }else if(orderItem.updateItem()){
        orderItem.updateUpdateTime(java.time.LocalDateTime.now());
      }
      checkUnitPrice(_ctx, orderItem.getProperty(OrderItem.UNIT_PRICE_PROPERTY), newLocation(_parentLocation, OrderItem.UNIT_PRICE_PROPERTY));
      checkGlobalOrder(_ctx, orderItem.getProperty(OrderItem.GLOBAL_ORDER_PROPERTY), newLocation(_parentLocation, OrderItem.GLOBAL_ORDER_PROPERTY));
      checkProduct(_ctx, orderItem.getProperty(OrderItem.PRODUCT_PROPERTY), newLocation(_parentLocation, OrderItem.PRODUCT_PROPERTY));
      checkQuantity(_ctx, orderItem.getProperty(OrderItem.QUANTITY_PROPERTY), newLocation(_parentLocation, OrderItem.QUANTITY_PROPERTY));
      checkCreateTime(_ctx, orderItem.getProperty(OrderItem.CREATE_TIME_PROPERTY), newLocation(_parentLocation, OrderItem.CREATE_TIME_PROPERTY));
      checkUpdateTime(_ctx, orderItem.getProperty(OrderItem.UPDATE_TIME_PROPERTY), newLocation(_parentLocation, OrderItem.UPDATE_TIME_PROPERTY));
    }

    public void checkUnitPrice(UserContext _ctx, BigDecimal unitPrice, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, unitPrice);
    if((unitPrice == null)){
        return;
    }
    }
    public void checkGlobalOrder(UserContext _ctx, GlobalOrder globalOrder, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, globalOrder);
    if((globalOrder == null)){
        return;
    }
    new GlobalOrderChecker().checkAndFix(_ctx, globalOrder, _parentLocation);
    }
    public void checkProduct(UserContext _ctx, Product product, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, product);
    if((product == null)){
        return;
    }
    new ProductChecker().checkAndFix(_ctx, product, _parentLocation);
    }
    public void checkQuantity(UserContext _ctx, BigDecimal quantity, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, quantity);
    if((quantity == null)){
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