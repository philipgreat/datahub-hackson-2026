
package com.example.enterpriseerpsystem.cartitem;

import com.example.enterpriseerpsystem.product.Product;
import com.example.enterpriseerpsystem.product.ProductChecker;
import com.example.enterpriseerpsystem.shoppingcart.ShoppingCart;
import com.example.enterpriseerpsystem.shoppingcart.ShoppingCartChecker;
import io.teaql.core.UserContext;
import io.teaql.core.checker.Checker;
import io.teaql.core.checker.ObjectLocation;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class CartItemChecker implements Checker<CartItem>{

    public String type(){
        return CartItem.INTERNAL_TYPE;
    }

    public void checkAndFix(UserContext _ctx, CartItem cartItem, ObjectLocation _parentLocation){
        if(needCheck(_ctx, cartItem)){
            markAsChecked(_ctx, cartItem);
            doCheck(_ctx, cartItem, _parentLocation);
        }
    }

    public void doCheck(UserContext _ctx, CartItem cartItem, ObjectLocation _parentLocation){
      if((cartItem == null)){
         return;
      }
      if(cartItem.newItem()){
        if(cartItem.getCreateTime() == null){
           cartItem.updateCreateTime(java.time.LocalDateTime.now());
        }if(cartItem.getUpdateTime() == null){
           cartItem.updateUpdateTime(java.time.LocalDateTime.now());
        }
      }else if(cartItem.updateItem()){
        cartItem.updateUpdateTime(java.time.LocalDateTime.now());
      }
      checkProduct(_ctx, cartItem.getProperty(CartItem.PRODUCT_PROPERTY), newLocation(_parentLocation, CartItem.PRODUCT_PROPERTY));
      checkQuantity(_ctx, cartItem.getProperty(CartItem.QUANTITY_PROPERTY), newLocation(_parentLocation, CartItem.QUANTITY_PROPERTY));
      checkShoppingCart(_ctx, cartItem.getProperty(CartItem.SHOPPING_CART_PROPERTY), newLocation(_parentLocation, CartItem.SHOPPING_CART_PROPERTY));
      checkCreateTime(_ctx, cartItem.getProperty(CartItem.CREATE_TIME_PROPERTY), newLocation(_parentLocation, CartItem.CREATE_TIME_PROPERTY));
      checkUpdateTime(_ctx, cartItem.getProperty(CartItem.UPDATE_TIME_PROPERTY), newLocation(_parentLocation, CartItem.UPDATE_TIME_PROPERTY));
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
    public void checkShoppingCart(UserContext _ctx, ShoppingCart shoppingCart, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, shoppingCart);
    if((shoppingCart == null)){
        return;
    }
    new ShoppingCartChecker().checkAndFix(_ctx, shoppingCart, _parentLocation);
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