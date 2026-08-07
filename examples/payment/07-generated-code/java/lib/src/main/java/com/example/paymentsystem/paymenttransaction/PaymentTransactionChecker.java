
package com.example.paymentsystem.paymenttransaction;

import io.teaql.core.UserContext;
import io.teaql.core.checker.Checker;
import io.teaql.core.checker.ObjectLocation;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class PaymentTransactionChecker implements Checker<PaymentTransaction>{

    public String type(){
        return PaymentTransaction.INTERNAL_TYPE;
    }

    public void checkAndFix(UserContext _ctx, PaymentTransaction paymentTransaction, ObjectLocation _parentLocation){
        if(needCheck(_ctx, paymentTransaction)){
            markAsChecked(_ctx, paymentTransaction);
            doCheck(_ctx, paymentTransaction, _parentLocation);
        }
    }

    public void doCheck(UserContext _ctx, PaymentTransaction paymentTransaction, ObjectLocation _parentLocation){
      if((paymentTransaction == null)){
         return;
      }
      if(paymentTransaction.newItem()){
        if(paymentTransaction.getCreateTime() == null){
           paymentTransaction.updateCreateTime(java.time.LocalDateTime.now());
        }if(paymentTransaction.getUpdateTime() == null){
           paymentTransaction.updateUpdateTime(java.time.LocalDateTime.now());
        }
      }else if(paymentTransaction.updateItem()){
        paymentTransaction.updateUpdateTime(java.time.LocalDateTime.now());
      }
      checkPaymentAccount(_ctx, paymentTransaction.getProperty(PaymentTransaction.PAYMENT_ACCOUNT_PROPERTY), newLocation(_parentLocation, PaymentTransaction.PAYMENT_ACCOUNT_PROPERTY));
      checkCurrencyCode(_ctx, paymentTransaction.getProperty(PaymentTransaction.CURRENCY_CODE_PROPERTY), newLocation(_parentLocation, PaymentTransaction.CURRENCY_CODE_PROPERTY));
      checkPaymentMethod(_ctx, paymentTransaction.getProperty(PaymentTransaction.PAYMENT_METHOD_PROPERTY), newLocation(_parentLocation, PaymentTransaction.PAYMENT_METHOD_PROPERTY));
      checkTransactionAmount(_ctx, paymentTransaction.getProperty(PaymentTransaction.TRANSACTION_AMOUNT_PROPERTY), newLocation(_parentLocation, PaymentTransaction.TRANSACTION_AMOUNT_PROPERTY));
      checkCreateTime(_ctx, paymentTransaction.getProperty(PaymentTransaction.CREATE_TIME_PROPERTY), newLocation(_parentLocation, PaymentTransaction.CREATE_TIME_PROPERTY));
      checkUpdateTime(_ctx, paymentTransaction.getProperty(PaymentTransaction.UPDATE_TIME_PROPERTY), newLocation(_parentLocation, PaymentTransaction.UPDATE_TIME_PROPERTY));
    }

    public void checkPaymentAccount(UserContext _ctx, String paymentAccount, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, paymentAccount);
    if((paymentAccount == null)){
        return;
    }
    maxStringCheck(_ctx, _parentLocation, 100, paymentAccount);

    }
    public void checkCurrencyCode(UserContext _ctx, String currencyCode, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, currencyCode);
    if((currencyCode == null)){
        return;
    }
    maxStringCheck(_ctx, _parentLocation, 100, currencyCode);

    }
    public void checkPaymentMethod(UserContext _ctx, String paymentMethod, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, paymentMethod);
    if((paymentMethod == null)){
        return;
    }
    maxStringCheck(_ctx, _parentLocation, 100, paymentMethod);

    }
    public void checkTransactionAmount(UserContext _ctx, BigDecimal transactionAmount, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, transactionAmount);
    if((transactionAmount == null)){
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