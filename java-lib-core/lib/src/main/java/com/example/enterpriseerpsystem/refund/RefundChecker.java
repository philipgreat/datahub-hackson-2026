
package com.example.enterpriseerpsystem.refund;

import com.example.enterpriseerpsystem.payment.Payment;
import com.example.enterpriseerpsystem.payment.PaymentChecker;
import io.teaql.core.UserContext;
import io.teaql.core.checker.Checker;
import io.teaql.core.checker.ObjectLocation;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class RefundChecker implements Checker<Refund>{

    public String type(){
        return Refund.INTERNAL_TYPE;
    }

    public void checkAndFix(UserContext _ctx, Refund refund, ObjectLocation _parentLocation){
        if(needCheck(_ctx, refund)){
            markAsChecked(_ctx, refund);
            doCheck(_ctx, refund, _parentLocation);
        }
    }

    public void doCheck(UserContext _ctx, Refund refund, ObjectLocation _parentLocation){
      if((refund == null)){
         return;
      }
      if(refund.newItem()){
        if(refund.getProcessedDate() == null){
           refund.updateProcessedDate(java.time.LocalDateTime.now());
        }if(refund.getCreateTime() == null){
           refund.updateCreateTime(java.time.LocalDateTime.now());
        }if(refund.getUpdateTime() == null){
           refund.updateUpdateTime(java.time.LocalDateTime.now());
        }
      }else if(refund.updateItem()){
        refund.updateUpdateTime(java.time.LocalDateTime.now());
      }
      checkAmount(_ctx, refund.getProperty(Refund.AMOUNT_PROPERTY), newLocation(_parentLocation, Refund.AMOUNT_PROPERTY));
      checkPayment(_ctx, refund.getProperty(Refund.PAYMENT_PROPERTY), newLocation(_parentLocation, Refund.PAYMENT_PROPERTY));
      checkProcessedDate(_ctx, refund.getProperty(Refund.PROCESSED_DATE_PROPERTY), newLocation(_parentLocation, Refund.PROCESSED_DATE_PROPERTY));
      checkReason(_ctx, refund.getProperty(Refund.REASON_PROPERTY), newLocation(_parentLocation, Refund.REASON_PROPERTY));
      checkCreateTime(_ctx, refund.getProperty(Refund.CREATE_TIME_PROPERTY), newLocation(_parentLocation, Refund.CREATE_TIME_PROPERTY));
      checkUpdateTime(_ctx, refund.getProperty(Refund.UPDATE_TIME_PROPERTY), newLocation(_parentLocation, Refund.UPDATE_TIME_PROPERTY));
    }

    public void checkAmount(UserContext _ctx, BigDecimal amount, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, amount);
    if((amount == null)){
        return;
    }
    }
    public void checkPayment(UserContext _ctx, Payment payment, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, payment);
    if((payment == null)){
        return;
    }
    new PaymentChecker().checkAndFix(_ctx, payment, _parentLocation);
    }
    public void checkProcessedDate(UserContext _ctx, LocalDateTime processedDate, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, processedDate);
    if((processedDate == null)){
        return;
    }
    }
    public void checkReason(UserContext _ctx, String reason, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, reason);
    if((reason == null)){
        return;
    }
    maxStringCheck(_ctx, _parentLocation, 100, reason);

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