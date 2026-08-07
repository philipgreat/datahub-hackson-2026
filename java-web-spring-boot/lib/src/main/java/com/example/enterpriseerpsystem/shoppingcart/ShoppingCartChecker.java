
package com.example.enterpriseerpsystem.shoppingcart;

import com.example.enterpriseerpsystem.cartitem.CartItem;
import com.example.enterpriseerpsystem.cartitem.CartItemChecker;
import com.example.enterpriseerpsystem.customer.Customer;
import com.example.enterpriseerpsystem.customer.CustomerChecker;
import io.teaql.core.UserContext;
import io.teaql.core.checker.Checker;
import io.teaql.core.checker.ObjectLocation;
import java.time.LocalDateTime;

public class ShoppingCartChecker implements Checker<ShoppingCart>{

    public String type(){
        return ShoppingCart.INTERNAL_TYPE;
    }

    public void checkAndFix(UserContext _ctx, ShoppingCart shoppingCart, ObjectLocation _parentLocation){
        if(needCheck(_ctx, shoppingCart)){
            markAsChecked(_ctx, shoppingCart);
            doCheck(_ctx, shoppingCart, _parentLocation);
        }
    }

    public void doCheck(UserContext _ctx, ShoppingCart shoppingCart, ObjectLocation _parentLocation){
      if((shoppingCart == null)){
         return;
      }
      if(shoppingCart.newItem()){
        if(shoppingCart.getCreatedAt() == null){
           shoppingCart.updateCreatedAt(java.time.LocalDateTime.now());
        }if(shoppingCart.getCreateTime() == null){
           shoppingCart.updateCreateTime(java.time.LocalDateTime.now());
        }if(shoppingCart.getUpdateTime() == null){
           shoppingCart.updateUpdateTime(java.time.LocalDateTime.now());
        }
      }else if(shoppingCart.updateItem()){
        shoppingCart.updateUpdateTime(java.time.LocalDateTime.now());
      }
      checkCreatedAt(_ctx, shoppingCart.getProperty(ShoppingCart.CREATED_AT_PROPERTY), newLocation(_parentLocation, ShoppingCart.CREATED_AT_PROPERTY));
      checkCustomer(_ctx, shoppingCart.getProperty(ShoppingCart.CUSTOMER_PROPERTY), newLocation(_parentLocation, ShoppingCart.CUSTOMER_PROPERTY));
      checkIsAbandoned(_ctx, shoppingCart.getProperty(ShoppingCart.IS_ABANDONED_PROPERTY), newLocation(_parentLocation, ShoppingCart.IS_ABANDONED_PROPERTY));
      checkSessionId(_ctx, shoppingCart.getProperty(ShoppingCart.SESSION_ID_PROPERTY), newLocation(_parentLocation, ShoppingCart.SESSION_ID_PROPERTY));
      checkCreateTime(_ctx, shoppingCart.getProperty(ShoppingCart.CREATE_TIME_PROPERTY), newLocation(_parentLocation, ShoppingCart.CREATE_TIME_PROPERTY));
      checkUpdateTime(_ctx, shoppingCart.getProperty(ShoppingCart.UPDATE_TIME_PROPERTY), newLocation(_parentLocation, ShoppingCart.UPDATE_TIME_PROPERTY));
      for(int i = 0; shoppingCart.getCartItemList() != null && i < shoppingCart.getCartItemList().size(); i++){
         CartItem cartItem = shoppingCart.getCartItemList().get(i);
         new CartItemChecker().checkAndFix(_ctx, cartItem, newLocation(_parentLocation, ShoppingCart.CART_ITEM_LIST_PROPERTY, i));
      }
    }

    public void checkCreatedAt(UserContext _ctx, LocalDateTime createdAt, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, createdAt);
    if((createdAt == null)){
        return;
    }
    }
    public void checkCustomer(UserContext _ctx, Customer customer, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, customer);
    if((customer == null)){
        return;
    }
    new CustomerChecker().checkAndFix(_ctx, customer, _parentLocation);
    }
    public void checkIsAbandoned(UserContext _ctx, Boolean isAbandoned, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, isAbandoned);
    if((isAbandoned == null)){
        return;
    }
    }
    public void checkSessionId(UserContext _ctx, String sessionId, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, sessionId);
    if((sessionId == null)){
        return;
    }
    maxStringCheck(_ctx, _parentLocation, 100, sessionId);

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