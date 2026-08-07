
package com.example.enterpriseerpsystem.shipment;

import com.example.enterpriseerpsystem.delivery.Delivery;
import com.example.enterpriseerpsystem.delivery.DeliveryChecker;
import com.example.enterpriseerpsystem.globalorder.GlobalOrder;
import com.example.enterpriseerpsystem.globalorder.GlobalOrderChecker;
import com.example.enterpriseerpsystem.warehouse.Warehouse;
import com.example.enterpriseerpsystem.warehouse.WarehouseChecker;
import io.teaql.core.UserContext;
import io.teaql.core.checker.Checker;
import io.teaql.core.checker.ObjectLocation;
import java.time.LocalDateTime;

public class ShipmentChecker implements Checker<Shipment>{

    public String type(){
        return Shipment.INTERNAL_TYPE;
    }

    public void checkAndFix(UserContext _ctx, Shipment shipment, ObjectLocation _parentLocation){
        if(needCheck(_ctx, shipment)){
            markAsChecked(_ctx, shipment);
            doCheck(_ctx, shipment, _parentLocation);
        }
    }

    public void doCheck(UserContext _ctx, Shipment shipment, ObjectLocation _parentLocation){
      if((shipment == null)){
         return;
      }
      if(shipment.newItem()){
        if(shipment.getShippedDate() == null){
           shipment.updateShippedDate(java.time.LocalDateTime.now());
        }if(shipment.getCreateTime() == null){
           shipment.updateCreateTime(java.time.LocalDateTime.now());
        }if(shipment.getUpdateTime() == null){
           shipment.updateUpdateTime(java.time.LocalDateTime.now());
        }
      }else if(shipment.updateItem()){
        shipment.updateUpdateTime(java.time.LocalDateTime.now());
      }
      checkShippedDate(_ctx, shipment.getProperty(Shipment.SHIPPED_DATE_PROPERTY), newLocation(_parentLocation, Shipment.SHIPPED_DATE_PROPERTY));
      checkCarrier(_ctx, shipment.getProperty(Shipment.CARRIER_PROPERTY), newLocation(_parentLocation, Shipment.CARRIER_PROPERTY));
      checkGlobalOrder(_ctx, shipment.getProperty(Shipment.GLOBAL_ORDER_PROPERTY), newLocation(_parentLocation, Shipment.GLOBAL_ORDER_PROPERTY));
      checkStatus(_ctx, shipment.getProperty(Shipment.STATUS_PROPERTY), newLocation(_parentLocation, Shipment.STATUS_PROPERTY));
      checkTrackingNumber(_ctx, shipment.getProperty(Shipment.TRACKING_NUMBER_PROPERTY), newLocation(_parentLocation, Shipment.TRACKING_NUMBER_PROPERTY));
      checkWarehouse(_ctx, shipment.getProperty(Shipment.WAREHOUSE_PROPERTY), newLocation(_parentLocation, Shipment.WAREHOUSE_PROPERTY));
      checkCreateTime(_ctx, shipment.getProperty(Shipment.CREATE_TIME_PROPERTY), newLocation(_parentLocation, Shipment.CREATE_TIME_PROPERTY));
      checkUpdateTime(_ctx, shipment.getProperty(Shipment.UPDATE_TIME_PROPERTY), newLocation(_parentLocation, Shipment.UPDATE_TIME_PROPERTY));
      for(int i = 0; shipment.getDeliveryList() != null && i < shipment.getDeliveryList().size(); i++){
         Delivery delivery = shipment.getDeliveryList().get(i);
         new DeliveryChecker().checkAndFix(_ctx, delivery, newLocation(_parentLocation, Shipment.DELIVERY_LIST_PROPERTY, i));
      }
    }

    public void checkShippedDate(UserContext _ctx, LocalDateTime shippedDate, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, shippedDate);
    if((shippedDate == null)){
        return;
    }
    }
    public void checkCarrier(UserContext _ctx, String carrier, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, carrier);
    if((carrier == null)){
        return;
    }
    maxStringCheck(_ctx, _parentLocation, 100, carrier);

    }
    public void checkGlobalOrder(UserContext _ctx, GlobalOrder globalOrder, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, globalOrder);
    if((globalOrder == null)){
        return;
    }
    new GlobalOrderChecker().checkAndFix(_ctx, globalOrder, _parentLocation);
    }
    public void checkStatus(UserContext _ctx, String status, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, status);
    if((status == null)){
        return;
    }
    maxStringCheck(_ctx, _parentLocation, 100, status);

    }
    public void checkTrackingNumber(UserContext _ctx, String trackingNumber, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, trackingNumber);
    if((trackingNumber == null)){
        return;
    }
    maxStringCheck(_ctx, _parentLocation, 100, trackingNumber);

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