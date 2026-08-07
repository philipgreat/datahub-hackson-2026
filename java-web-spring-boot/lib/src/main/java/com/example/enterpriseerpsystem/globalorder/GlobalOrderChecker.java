
package com.example.enterpriseerpsystem.globalorder;

import com.example.enterpriseerpsystem.customer.Customer;
import com.example.enterpriseerpsystem.customer.CustomerChecker;
import com.example.enterpriseerpsystem.invoice.Invoice;
import com.example.enterpriseerpsystem.invoice.InvoiceChecker;
import com.example.enterpriseerpsystem.orderitem.OrderItem;
import com.example.enterpriseerpsystem.orderitem.OrderItemChecker;
import com.example.enterpriseerpsystem.returnrequest.ReturnRequest;
import com.example.enterpriseerpsystem.returnrequest.ReturnRequestChecker;
import com.example.enterpriseerpsystem.shipment.Shipment;
import com.example.enterpriseerpsystem.shipment.ShipmentChecker;
import io.teaql.core.UserContext;
import io.teaql.core.checker.Checker;
import io.teaql.core.checker.ObjectLocation;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class GlobalOrderChecker implements Checker<GlobalOrder>{

    public String type(){
        return GlobalOrder.INTERNAL_TYPE;
    }

    public void checkAndFix(UserContext _ctx, GlobalOrder globalOrder, ObjectLocation _parentLocation){
        if(needCheck(_ctx, globalOrder)){
            markAsChecked(_ctx, globalOrder);
            doCheck(_ctx, globalOrder, _parentLocation);
        }
    }

    public void doCheck(UserContext _ctx, GlobalOrder globalOrder, ObjectLocation _parentLocation){
      if((globalOrder == null)){
         return;
      }
      if(globalOrder.newItem()){
        if(globalOrder.getOrderDate() == null){
           globalOrder.updateOrderDate(java.time.LocalDateTime.now());
        }if(globalOrder.getCreateTime() == null){
           globalOrder.updateCreateTime(java.time.LocalDateTime.now());
        }if(globalOrder.getUpdateTime() == null){
           globalOrder.updateUpdateTime(java.time.LocalDateTime.now());
        }
      }else if(globalOrder.updateItem()){
        globalOrder.updateUpdateTime(java.time.LocalDateTime.now());
      }
      checkShippingAddress(_ctx, globalOrder.getProperty(GlobalOrder.SHIPPING_ADDRESS_PROPERTY), newLocation(_parentLocation, GlobalOrder.SHIPPING_ADDRESS_PROPERTY));
      checkTotalAmount(_ctx, globalOrder.getProperty(GlobalOrder.TOTAL_AMOUNT_PROPERTY), newLocation(_parentLocation, GlobalOrder.TOTAL_AMOUNT_PROPERTY));
      checkCustomer(_ctx, globalOrder.getProperty(GlobalOrder.CUSTOMER_PROPERTY), newLocation(_parentLocation, GlobalOrder.CUSTOMER_PROPERTY));
      checkOrderDate(_ctx, globalOrder.getProperty(GlobalOrder.ORDER_DATE_PROPERTY), newLocation(_parentLocation, GlobalOrder.ORDER_DATE_PROPERTY));
      checkStatus(_ctx, globalOrder.getProperty(GlobalOrder.STATUS_PROPERTY), newLocation(_parentLocation, GlobalOrder.STATUS_PROPERTY));
      checkCreateTime(_ctx, globalOrder.getProperty(GlobalOrder.CREATE_TIME_PROPERTY), newLocation(_parentLocation, GlobalOrder.CREATE_TIME_PROPERTY));
      checkUpdateTime(_ctx, globalOrder.getProperty(GlobalOrder.UPDATE_TIME_PROPERTY), newLocation(_parentLocation, GlobalOrder.UPDATE_TIME_PROPERTY));
      for(int i = 0; globalOrder.getOrderItemList() != null && i < globalOrder.getOrderItemList().size(); i++){
         OrderItem orderItem = globalOrder.getOrderItemList().get(i);
         new OrderItemChecker().checkAndFix(_ctx, orderItem, newLocation(_parentLocation, GlobalOrder.ORDER_ITEM_LIST_PROPERTY, i));
      }
      for(int i = 0; globalOrder.getInvoiceList() != null && i < globalOrder.getInvoiceList().size(); i++){
         Invoice invoice = globalOrder.getInvoiceList().get(i);
         new InvoiceChecker().checkAndFix(_ctx, invoice, newLocation(_parentLocation, GlobalOrder.INVOICE_LIST_PROPERTY, i));
      }
      for(int i = 0; globalOrder.getShipmentList() != null && i < globalOrder.getShipmentList().size(); i++){
         Shipment shipment = globalOrder.getShipmentList().get(i);
         new ShipmentChecker().checkAndFix(_ctx, shipment, newLocation(_parentLocation, GlobalOrder.SHIPMENT_LIST_PROPERTY, i));
      }
      for(int i = 0; globalOrder.getReturnRequestList() != null && i < globalOrder.getReturnRequestList().size(); i++){
         ReturnRequest returnRequest = globalOrder.getReturnRequestList().get(i);
         new ReturnRequestChecker().checkAndFix(_ctx, returnRequest, newLocation(_parentLocation, GlobalOrder.RETURN_REQUEST_LIST_PROPERTY, i));
      }
    }

    public void checkShippingAddress(UserContext _ctx, String shippingAddress, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, shippingAddress);
    if((shippingAddress == null)){
        return;
    }
    maxStringCheck(_ctx, _parentLocation, 100, shippingAddress);

    }
    public void checkTotalAmount(UserContext _ctx, BigDecimal totalAmount, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, totalAmount);
    if((totalAmount == null)){
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