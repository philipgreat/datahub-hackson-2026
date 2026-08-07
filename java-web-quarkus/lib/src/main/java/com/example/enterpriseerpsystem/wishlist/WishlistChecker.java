
package com.example.enterpriseerpsystem.wishlist;

import com.example.enterpriseerpsystem.customer.Customer;
import com.example.enterpriseerpsystem.customer.CustomerChecker;
import io.teaql.core.UserContext;
import io.teaql.core.checker.Checker;
import io.teaql.core.checker.ObjectLocation;
import java.time.LocalDateTime;

public class WishlistChecker implements Checker<Wishlist>{

    public String type(){
        return Wishlist.INTERNAL_TYPE;
    }

    public void checkAndFix(UserContext _ctx, Wishlist wishlist, ObjectLocation _parentLocation){
        if(needCheck(_ctx, wishlist)){
            markAsChecked(_ctx, wishlist);
            doCheck(_ctx, wishlist, _parentLocation);
        }
    }

    public void doCheck(UserContext _ctx, Wishlist wishlist, ObjectLocation _parentLocation){
      if((wishlist == null)){
         return;
      }
      if(wishlist.newItem()){
        if(wishlist.getCreatedAt() == null){
           wishlist.updateCreatedAt(java.time.LocalDateTime.now());
        }if(wishlist.getCreateTime() == null){
           wishlist.updateCreateTime(java.time.LocalDateTime.now());
        }if(wishlist.getUpdateTime() == null){
           wishlist.updateUpdateTime(java.time.LocalDateTime.now());
        }
      }else if(wishlist.updateItem()){
        wishlist.updateUpdateTime(java.time.LocalDateTime.now());
      }
      checkName(_ctx, wishlist.getProperty(Wishlist.NAME_PROPERTY), newLocation(_parentLocation, Wishlist.NAME_PROPERTY));
      checkCreatedAt(_ctx, wishlist.getProperty(Wishlist.CREATED_AT_PROPERTY), newLocation(_parentLocation, Wishlist.CREATED_AT_PROPERTY));
      checkCustomer(_ctx, wishlist.getProperty(Wishlist.CUSTOMER_PROPERTY), newLocation(_parentLocation, Wishlist.CUSTOMER_PROPERTY));
      checkCreateTime(_ctx, wishlist.getProperty(Wishlist.CREATE_TIME_PROPERTY), newLocation(_parentLocation, Wishlist.CREATE_TIME_PROPERTY));
      checkUpdateTime(_ctx, wishlist.getProperty(Wishlist.UPDATE_TIME_PROPERTY), newLocation(_parentLocation, Wishlist.UPDATE_TIME_PROPERTY));
    }

    public void checkName(UserContext _ctx, String name, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, name);
    if((name == null)){
        return;
    }
    maxStringCheck(_ctx, _parentLocation, 100, name);

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