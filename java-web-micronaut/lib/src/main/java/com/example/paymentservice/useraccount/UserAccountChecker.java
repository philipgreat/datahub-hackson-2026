
package com.example.paymentservice.useraccount;

import com.example.paymentservice.paymentaccount.PaymentAccount;
import com.example.paymentservice.paymentaccount.PaymentAccountChecker;
import io.teaql.core.UserContext;
import io.teaql.core.checker.Checker;
import io.teaql.core.checker.ObjectLocation;
import java.time.LocalDateTime;

public class UserAccountChecker implements Checker<UserAccount>{

    public String type(){
        return UserAccount.INTERNAL_TYPE;
    }

    public void checkAndFix(UserContext _ctx, UserAccount userAccount, ObjectLocation _parentLocation){
        if(needCheck(_ctx, userAccount)){
            markAsChecked(_ctx, userAccount);
            doCheck(_ctx, userAccount, _parentLocation);
        }
    }

    public void doCheck(UserContext _ctx, UserAccount userAccount, ObjectLocation _parentLocation){
      if((userAccount == null)){
         return;
      }
      if(userAccount.newItem()){
        if(userAccount.getCreateTime() == null){
           userAccount.updateCreateTime(java.time.LocalDateTime.now());
        }if(userAccount.getUpdateTime() == null){
           userAccount.updateUpdateTime(java.time.LocalDateTime.now());
        }
      }else if(userAccount.updateItem()){
        userAccount.updateUpdateTime(java.time.LocalDateTime.now());
      }
      checkUserId(_ctx, userAccount.getProperty(UserAccount.USER_ID_PROPERTY), newLocation(_parentLocation, UserAccount.USER_ID_PROPERTY));
      checkUserName(_ctx, userAccount.getProperty(UserAccount.USER_NAME_PROPERTY), newLocation(_parentLocation, UserAccount.USER_NAME_PROPERTY));
      checkCreateTime(_ctx, userAccount.getProperty(UserAccount.CREATE_TIME_PROPERTY), newLocation(_parentLocation, UserAccount.CREATE_TIME_PROPERTY));
      checkUpdateTime(_ctx, userAccount.getProperty(UserAccount.UPDATE_TIME_PROPERTY), newLocation(_parentLocation, UserAccount.UPDATE_TIME_PROPERTY));
      for(int i = 0; userAccount.getPaymentAccountList() != null && i < userAccount.getPaymentAccountList().size(); i++){
         PaymentAccount paymentAccount = userAccount.getPaymentAccountList().get(i);
         new PaymentAccountChecker().checkAndFix(_ctx, paymentAccount, newLocation(_parentLocation, UserAccount.PAYMENT_ACCOUNT_LIST_PROPERTY, i));
      }
    }

    public void checkUserId(UserContext _ctx, String userId, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, userId);
    if((userId == null)){
        return;
    }
    maxStringCheck(_ctx, _parentLocation, 100, userId);

    }
    public void checkUserName(UserContext _ctx, String userName, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, userName);
    if((userName == null)){
        return;
    }
    maxStringCheck(_ctx, _parentLocation, 100, userName);

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