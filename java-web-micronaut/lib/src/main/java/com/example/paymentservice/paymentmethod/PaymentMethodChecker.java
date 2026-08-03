
package com.example.paymentservice.paymentmethod;

import com.example.paymentservice.paymentaccount.PaymentAccount;
import com.example.paymentservice.paymentaccount.PaymentAccountChecker;
import com.example.paymentservice.paymenttransaction.PaymentTransaction;
import com.example.paymentservice.paymenttransaction.PaymentTransactionChecker;
import io.teaql.core.UserContext;
import io.teaql.core.checker.Checker;
import io.teaql.core.checker.ObjectLocation;
import java.time.LocalDateTime;

public class PaymentMethodChecker implements Checker<PaymentMethod>{

    public String type(){
        return PaymentMethod.INTERNAL_TYPE;
    }

    public void checkAndFix(UserContext _ctx, PaymentMethod paymentMethod, ObjectLocation _parentLocation){
        if(needCheck(_ctx, paymentMethod)){
            markAsChecked(_ctx, paymentMethod);
            doCheck(_ctx, paymentMethod, _parentLocation);
        }
    }

    public void doCheck(UserContext _ctx, PaymentMethod paymentMethod, ObjectLocation _parentLocation){
      if((paymentMethod == null)){
         return;
      }
      if(paymentMethod.newItem()){
        if(paymentMethod.getCreateTime() == null){
           paymentMethod.updateCreateTime(java.time.LocalDateTime.now());
        }if(paymentMethod.getUpdateTime() == null){
           paymentMethod.updateUpdateTime(java.time.LocalDateTime.now());
        }
      }else if(paymentMethod.updateItem()){
        paymentMethod.updateUpdateTime(java.time.LocalDateTime.now());
      }
      checkPaymentAccount(_ctx, paymentMethod.getProperty(PaymentMethod.PAYMENT_ACCOUNT_PROPERTY), newLocation(_parentLocation, PaymentMethod.PAYMENT_ACCOUNT_PROPERTY));
      checkMethodType(_ctx, paymentMethod.getProperty(PaymentMethod.METHOD_TYPE_PROPERTY), newLocation(_parentLocation, PaymentMethod.METHOD_TYPE_PROPERTY));
      checkLastFourDigits(_ctx, paymentMethod.getProperty(PaymentMethod.LAST_FOUR_DIGITS_PROPERTY), newLocation(_parentLocation, PaymentMethod.LAST_FOUR_DIGITS_PROPERTY));
      checkCreateTime(_ctx, paymentMethod.getProperty(PaymentMethod.CREATE_TIME_PROPERTY), newLocation(_parentLocation, PaymentMethod.CREATE_TIME_PROPERTY));
      checkUpdateTime(_ctx, paymentMethod.getProperty(PaymentMethod.UPDATE_TIME_PROPERTY), newLocation(_parentLocation, PaymentMethod.UPDATE_TIME_PROPERTY));
      for(int i = 0; paymentMethod.getPaymentTransactionList() != null && i < paymentMethod.getPaymentTransactionList().size(); i++){
         PaymentTransaction paymentTransaction = paymentMethod.getPaymentTransactionList().get(i);
         new PaymentTransactionChecker().checkAndFix(_ctx, paymentTransaction, newLocation(_parentLocation, PaymentMethod.PAYMENT_TRANSACTION_LIST_PROPERTY, i));
      }
    }

    public void checkPaymentAccount(UserContext _ctx, PaymentAccount paymentAccount, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, paymentAccount);
    if((paymentAccount == null)){
        return;
    }
    new PaymentAccountChecker().checkAndFix(_ctx, paymentAccount, _parentLocation);
    }
    public void checkMethodType(UserContext _ctx, String methodType, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, methodType);
    if((methodType == null)){
        return;
    }
    maxStringCheck(_ctx, _parentLocation, 100, methodType);

    }
    public void checkLastFourDigits(UserContext _ctx, Integer lastFourDigits, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, lastFourDigits);
    if((lastFourDigits == null)){
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