
package com.example.enterpriseerpsystem.account;

import com.example.enterpriseerpsystem.transaction.Transaction;
import com.example.enterpriseerpsystem.transaction.TransactionChecker;
import io.teaql.core.UserContext;
import io.teaql.core.checker.Checker;
import io.teaql.core.checker.ObjectLocation;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class AccountChecker implements Checker<Account>{

    public String type(){
        return Account.INTERNAL_TYPE;
    }

    public void checkAndFix(UserContext _ctx, Account account, ObjectLocation _parentLocation){
        if(needCheck(_ctx, account)){
            markAsChecked(_ctx, account);
            doCheck(_ctx, account, _parentLocation);
        }
    }

    public void doCheck(UserContext _ctx, Account account, ObjectLocation _parentLocation){
      if((account == null)){
         return;
      }
      if(account.newItem()){
        if(account.getCreateTime() == null){
           account.updateCreateTime(java.time.LocalDateTime.now());
        }if(account.getUpdateTime() == null){
           account.updateUpdateTime(java.time.LocalDateTime.now());
        }
      }else if(account.updateItem()){
        account.updateUpdateTime(java.time.LocalDateTime.now());
      }
      checkName(_ctx, account.getProperty(Account.NAME_PROPERTY), newLocation(_parentLocation, Account.NAME_PROPERTY));
      checkAccountType(_ctx, account.getProperty(Account.ACCOUNT_TYPE_PROPERTY), newLocation(_parentLocation, Account.ACCOUNT_TYPE_PROPERTY));
      checkBalance(_ctx, account.getProperty(Account.BALANCE_PROPERTY), newLocation(_parentLocation, Account.BALANCE_PROPERTY));
      checkCurrency(_ctx, account.getProperty(Account.CURRENCY_PROPERTY), newLocation(_parentLocation, Account.CURRENCY_PROPERTY));
      checkCreateTime(_ctx, account.getProperty(Account.CREATE_TIME_PROPERTY), newLocation(_parentLocation, Account.CREATE_TIME_PROPERTY));
      checkUpdateTime(_ctx, account.getProperty(Account.UPDATE_TIME_PROPERTY), newLocation(_parentLocation, Account.UPDATE_TIME_PROPERTY));
      for(int i = 0; account.getTransactionList() != null && i < account.getTransactionList().size(); i++){
         Transaction transaction = account.getTransactionList().get(i);
         new TransactionChecker().checkAndFix(_ctx, transaction, newLocation(_parentLocation, Account.TRANSACTION_LIST_PROPERTY, i));
      }
    }

    public void checkName(UserContext _ctx, String name, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, name);
    if((name == null)){
        return;
    }
    maxStringCheck(_ctx, _parentLocation, 100, name);

    }
    public void checkAccountType(UserContext _ctx, String accountType, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, accountType);
    if((accountType == null)){
        return;
    }
    maxStringCheck(_ctx, _parentLocation, 100, accountType);

    }
    public void checkBalance(UserContext _ctx, BigDecimal balance, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, balance);
    if((balance == null)){
        return;
    }
    }
    public void checkCurrency(UserContext _ctx, String currency, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, currency);
    if((currency == null)){
        return;
    }
    maxStringCheck(_ctx, _parentLocation, 100, currency);

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