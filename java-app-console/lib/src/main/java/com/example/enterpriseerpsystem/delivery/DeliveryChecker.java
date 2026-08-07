
package com.example.enterpriseerpsystem.delivery;

import com.example.enterpriseerpsystem.shipment.Shipment;
import com.example.enterpriseerpsystem.shipment.ShipmentChecker;
import io.teaql.core.UserContext;
import io.teaql.core.checker.Checker;
import io.teaql.core.checker.ObjectLocation;
import java.time.LocalDateTime;

public class DeliveryChecker implements Checker<Delivery>{

    public String type(){
        return Delivery.INTERNAL_TYPE;
    }

    public void checkAndFix(UserContext _ctx, Delivery delivery, ObjectLocation _parentLocation){
        if(needCheck(_ctx, delivery)){
            markAsChecked(_ctx, delivery);
            doCheck(_ctx, delivery, _parentLocation);
        }
    }

    public void doCheck(UserContext _ctx, Delivery delivery, ObjectLocation _parentLocation){
      if((delivery == null)){
         return;
      }
      if(delivery.newItem()){
        if(delivery.getDeliveryDate() == null){
           delivery.updateDeliveryDate(java.time.LocalDateTime.now());
        }if(delivery.getCreateTime() == null){
           delivery.updateCreateTime(java.time.LocalDateTime.now());
        }if(delivery.getUpdateTime() == null){
           delivery.updateUpdateTime(java.time.LocalDateTime.now());
        }
      }else if(delivery.updateItem()){
        delivery.updateUpdateTime(java.time.LocalDateTime.now());
      }
      checkRecipientSignature(_ctx, delivery.getProperty(Delivery.RECIPIENT_SIGNATURE_PROPERTY), newLocation(_parentLocation, Delivery.RECIPIENT_SIGNATURE_PROPERTY));
      checkShipment(_ctx, delivery.getProperty(Delivery.SHIPMENT_PROPERTY), newLocation(_parentLocation, Delivery.SHIPMENT_PROPERTY));
      checkDeliveryDate(_ctx, delivery.getProperty(Delivery.DELIVERY_DATE_PROPERTY), newLocation(_parentLocation, Delivery.DELIVERY_DATE_PROPERTY));
      checkStatus(_ctx, delivery.getProperty(Delivery.STATUS_PROPERTY), newLocation(_parentLocation, Delivery.STATUS_PROPERTY));
      checkCreateTime(_ctx, delivery.getProperty(Delivery.CREATE_TIME_PROPERTY), newLocation(_parentLocation, Delivery.CREATE_TIME_PROPERTY));
      checkUpdateTime(_ctx, delivery.getProperty(Delivery.UPDATE_TIME_PROPERTY), newLocation(_parentLocation, Delivery.UPDATE_TIME_PROPERTY));
    }

    public void checkRecipientSignature(UserContext _ctx, String recipientSignature, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, recipientSignature);
    if((recipientSignature == null)){
        return;
    }
    maxStringCheck(_ctx, _parentLocation, 100, recipientSignature);

    }
    public void checkShipment(UserContext _ctx, Shipment shipment, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, shipment);
    if((shipment == null)){
        return;
    }
    new ShipmentChecker().checkAndFix(_ctx, shipment, _parentLocation);
    }
    public void checkDeliveryDate(UserContext _ctx, LocalDateTime deliveryDate, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, deliveryDate);
    if((deliveryDate == null)){
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