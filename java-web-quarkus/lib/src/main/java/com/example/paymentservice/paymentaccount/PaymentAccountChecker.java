
package com.example.paymentservice.paymentaccount;

import com.example.paymentservice.paymentmethod.PaymentMethod;
import com.example.paymentservice.paymentmethod.PaymentMethodChecker;
import com.example.paymentservice.paymenttransaction.PaymentTransaction;
import com.example.paymentservice.paymenttransaction.PaymentTransactionChecker;
import com.example.paymentservice.useraccount.UserAccount;
import com.example.paymentservice.useraccount.UserAccountChecker;
import io.teaql.core.UserContext;
import io.teaql.core.checker.Checker;
import io.teaql.core.checker.ObjectLocation;
import java.time.LocalDateTime;

public class PaymentAccountChecker implements Checker<PaymentAccount>{

    public String type(){
        return PaymentAccount.INTERNAL_TYPE;
    }

    public void checkAndFix(UserContext _ctx, PaymentAccount paymentAccount, ObjectLocation _parentLocation){
        if(needCheck(_ctx, paymentAccount)){
            markAsChecked(_ctx, paymentAccount);
            doCheck(_ctx, paymentAccount, _parentLocation);
        }
    }

    public void doCheck(UserContext _ctx, PaymentAccount paymentAccount, ObjectLocation _parentLocation){
      if((paymentAccount == null)){
         return;
      }
      if(paymentAccount.newItem()){
        if(paymentAccount.getCreateTime() == null){
           paymentAccount.updateCreateTime(java.time.LocalDateTime.now());
        }if(paymentAccount.getUpdateTime() == null){
           paymentAccount.updateUpdateTime(java.time.LocalDateTime.now());
        }
      }else if(paymentAccount.updateItem()){
        paymentAccount.updateUpdateTime(java.time.LocalDateTime.now());
      }
      checkUserAccount(_ctx, paymentAccount.getProperty(PaymentAccount.USER_ACCOUNT_PROPERTY), newLocation(_parentLocation, PaymentAccount.USER_ACCOUNT_PROPERTY));
      checkAccountName(_ctx, paymentAccount.getProperty(PaymentAccount.ACCOUNT_NAME_PROPERTY), newLocation(_parentLocation, PaymentAccount.ACCOUNT_NAME_PROPERTY));
      checkAccountNumber(_ctx, paymentAccount.getProperty(PaymentAccount.ACCOUNT_NUMBER_PROPERTY), newLocation(_parentLocation, PaymentAccount.ACCOUNT_NUMBER_PROPERTY));
      checkCurrencyCode(_ctx, paymentAccount.getProperty(PaymentAccount.CURRENCY_CODE_PROPERTY), newLocation(_parentLocation, PaymentAccount.CURRENCY_CODE_PROPERTY));
      checkCreateTime(_ctx, paymentAccount.getProperty(PaymentAccount.CREATE_TIME_PROPERTY), newLocation(_parentLocation, PaymentAccount.CREATE_TIME_PROPERTY));
      checkUpdateTime(_ctx, paymentAccount.getProperty(PaymentAccount.UPDATE_TIME_PROPERTY), newLocation(_parentLocation, PaymentAccount.UPDATE_TIME_PROPERTY));
      for(int i = 0; paymentAccount.getPaymentMethodList() != null && i < paymentAccount.getPaymentMethodList().size(); i++){
         PaymentMethod paymentMethod = paymentAccount.getPaymentMethodList().get(i);
         new PaymentMethodChecker().checkAndFix(_ctx, paymentMethod, newLocation(_parentLocation, PaymentAccount.PAYMENT_METHOD_LIST_PROPERTY, i));
      }
      for(int i = 0; paymentAccount.getPaymentTransactionList() != null && i < paymentAccount.getPaymentTransactionList().size(); i++){
         PaymentTransaction paymentTransaction = paymentAccount.getPaymentTransactionList().get(i);
         new PaymentTransactionChecker().checkAndFix(_ctx, paymentTransaction, newLocation(_parentLocation, PaymentAccount.PAYMENT_TRANSACTION_LIST_PROPERTY, i));
      }
    }

    public void checkUserAccount(UserContext _ctx, UserAccount userAccount, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, userAccount);
    if((userAccount == null)){
        return;
    }
    new UserAccountChecker().checkAndFix(_ctx, userAccount, _parentLocation);
    }
    public void checkAccountName(UserContext _ctx, String accountName, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, accountName);
    if((accountName == null)){
        return;
    }
    maxStringCheck(_ctx, _parentLocation, 100, accountName);

    }
    public void checkAccountNumber(UserContext _ctx, Integer accountNumber, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, accountNumber);
    if((accountNumber == null)){
        return;
    }
    }
    public void checkCurrencyCode(UserContext _ctx, String currencyCode, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, currencyCode);
    if((currencyCode == null)){
        return;
    }
    maxStringCheck(_ctx, _parentLocation, 100, currencyCode);

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