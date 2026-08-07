
package com.example.enterpriseerpsystem.returnrequest;

import com.example.enterpriseerpsystem.customer.Customer;
import com.example.enterpriseerpsystem.customer.CustomerChecker;
import com.example.enterpriseerpsystem.globalorder.GlobalOrder;
import com.example.enterpriseerpsystem.globalorder.GlobalOrderChecker;
import io.teaql.core.UserContext;
import io.teaql.core.checker.Checker;
import io.teaql.core.checker.ObjectLocation;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ReturnRequestChecker implements Checker<ReturnRequest>{

    public String type(){
        return ReturnRequest.INTERNAL_TYPE;
    }

    public void checkAndFix(UserContext _ctx, ReturnRequest returnRequest, ObjectLocation _parentLocation){
        if(needCheck(_ctx, returnRequest)){
            markAsChecked(_ctx, returnRequest);
            doCheck(_ctx, returnRequest, _parentLocation);
        }
    }

    public void doCheck(UserContext _ctx, ReturnRequest returnRequest, ObjectLocation _parentLocation){
      if((returnRequest == null)){
         return;
      }
      if(returnRequest.newItem()){
        if(returnRequest.getCreateTime() == null){
           returnRequest.updateCreateTime(java.time.LocalDateTime.now());
        }if(returnRequest.getUpdateTime() == null){
           returnRequest.updateUpdateTime(java.time.LocalDateTime.now());
        }
      }else if(returnRequest.updateItem()){
        returnRequest.updateUpdateTime(java.time.LocalDateTime.now());
      }
      checkRefundAmount(_ctx, returnRequest.getProperty(ReturnRequest.REFUND_AMOUNT_PROPERTY), newLocation(_parentLocation, ReturnRequest.REFUND_AMOUNT_PROPERTY));
      checkCustomer(_ctx, returnRequest.getProperty(ReturnRequest.CUSTOMER_PROPERTY), newLocation(_parentLocation, ReturnRequest.CUSTOMER_PROPERTY));
      checkGlobalOrder(_ctx, returnRequest.getProperty(ReturnRequest.GLOBAL_ORDER_PROPERTY), newLocation(_parentLocation, ReturnRequest.GLOBAL_ORDER_PROPERTY));
      checkReason(_ctx, returnRequest.getProperty(ReturnRequest.REASON_PROPERTY), newLocation(_parentLocation, ReturnRequest.REASON_PROPERTY));
      checkStatus(_ctx, returnRequest.getProperty(ReturnRequest.STATUS_PROPERTY), newLocation(_parentLocation, ReturnRequest.STATUS_PROPERTY));
      checkCreateTime(_ctx, returnRequest.getProperty(ReturnRequest.CREATE_TIME_PROPERTY), newLocation(_parentLocation, ReturnRequest.CREATE_TIME_PROPERTY));
      checkUpdateTime(_ctx, returnRequest.getProperty(ReturnRequest.UPDATE_TIME_PROPERTY), newLocation(_parentLocation, ReturnRequest.UPDATE_TIME_PROPERTY));
    }

    public void checkRefundAmount(UserContext _ctx, BigDecimal refundAmount, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, refundAmount);
    if((refundAmount == null)){
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
    public void checkGlobalOrder(UserContext _ctx, GlobalOrder globalOrder, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, globalOrder);
    if((globalOrder == null)){
        return;
    }
    new GlobalOrderChecker().checkAndFix(_ctx, globalOrder, _parentLocation);
    }
    public void checkReason(UserContext _ctx, String reason, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, reason);
    if((reason == null)){
        return;
    }
    maxStringCheck(_ctx, _parentLocation, 100, reason);

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