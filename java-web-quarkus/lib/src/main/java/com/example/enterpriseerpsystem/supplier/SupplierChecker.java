
package com.example.enterpriseerpsystem.supplier;

import com.example.enterpriseerpsystem.purchaseorder.PurchaseOrder;
import com.example.enterpriseerpsystem.purchaseorder.PurchaseOrderChecker;
import io.teaql.core.UserContext;
import io.teaql.core.checker.Checker;
import io.teaql.core.checker.ObjectLocation;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class SupplierChecker implements Checker<Supplier>{

    public String type(){
        return Supplier.INTERNAL_TYPE;
    }

    public void checkAndFix(UserContext _ctx, Supplier supplier, ObjectLocation _parentLocation){
        if(needCheck(_ctx, supplier)){
            markAsChecked(_ctx, supplier);
            doCheck(_ctx, supplier, _parentLocation);
        }
    }

    public void doCheck(UserContext _ctx, Supplier supplier, ObjectLocation _parentLocation){
      if((supplier == null)){
         return;
      }
      if(supplier.newItem()){
        if(supplier.getCreateTime() == null){
           supplier.updateCreateTime(java.time.LocalDateTime.now());
        }if(supplier.getUpdateTime() == null){
           supplier.updateUpdateTime(java.time.LocalDateTime.now());
        }
      }else if(supplier.updateItem()){
        supplier.updateUpdateTime(java.time.LocalDateTime.now());
      }
      checkAddress(_ctx, supplier.getProperty(Supplier.ADDRESS_PROPERTY), newLocation(_parentLocation, Supplier.ADDRESS_PROPERTY));
      checkContactEmail(_ctx, supplier.getProperty(Supplier.CONTACT_EMAIL_PROPERTY), newLocation(_parentLocation, Supplier.CONTACT_EMAIL_PROPERTY));
      checkName(_ctx, supplier.getProperty(Supplier.NAME_PROPERTY), newLocation(_parentLocation, Supplier.NAME_PROPERTY));
      checkPhone(_ctx, supplier.getProperty(Supplier.PHONE_PROPERTY), newLocation(_parentLocation, Supplier.PHONE_PROPERTY));
      checkRating(_ctx, supplier.getProperty(Supplier.RATING_PROPERTY), newLocation(_parentLocation, Supplier.RATING_PROPERTY));
      checkCreateTime(_ctx, supplier.getProperty(Supplier.CREATE_TIME_PROPERTY), newLocation(_parentLocation, Supplier.CREATE_TIME_PROPERTY));
      checkUpdateTime(_ctx, supplier.getProperty(Supplier.UPDATE_TIME_PROPERTY), newLocation(_parentLocation, Supplier.UPDATE_TIME_PROPERTY));
      for(int i = 0; supplier.getPurchaseOrderList() != null && i < supplier.getPurchaseOrderList().size(); i++){
         PurchaseOrder purchaseOrder = supplier.getPurchaseOrderList().get(i);
         new PurchaseOrderChecker().checkAndFix(_ctx, purchaseOrder, newLocation(_parentLocation, Supplier.PURCHASE_ORDER_LIST_PROPERTY, i));
      }
    }

    public void checkAddress(UserContext _ctx, String address, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, address);
    if((address == null)){
        return;
    }
    maxStringCheck(_ctx, _parentLocation, 100, address);

    }
    public void checkContactEmail(UserContext _ctx, String contactEmail, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, contactEmail);
    if((contactEmail == null)){
        return;
    }
    maxStringCheck(_ctx, _parentLocation, 100, contactEmail);

    }
    public void checkName(UserContext _ctx, String name, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, name);
    if((name == null)){
        return;
    }
    maxStringCheck(_ctx, _parentLocation, 100, name);

    }
    public void checkPhone(UserContext _ctx, String phone, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, phone);
    if((phone == null)){
        return;
    }
    maxStringCheck(_ctx, _parentLocation, 100, phone);

    }
    public void checkRating(UserContext _ctx, BigDecimal rating, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, rating);
    if((rating == null)){
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