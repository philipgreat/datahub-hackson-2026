
package com.example.enterpriseerpsystem.transaction;

import com.example.enterpriseerpsystem.account.Account;
import com.example.enterpriseerpsystem.account.AccountChecker;
import com.example.enterpriseerpsystem.ledger.Ledger;
import com.example.enterpriseerpsystem.ledger.LedgerChecker;
import io.teaql.core.UserContext;
import io.teaql.core.checker.Checker;
import io.teaql.core.checker.ObjectLocation;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransactionChecker implements Checker<Transaction>{

    public String type(){
        return Transaction.INTERNAL_TYPE;
    }

    public void checkAndFix(UserContext _ctx, Transaction transaction, ObjectLocation _parentLocation){
        if(needCheck(_ctx, transaction)){
            markAsChecked(_ctx, transaction);
            doCheck(_ctx, transaction, _parentLocation);
        }
    }

    public void doCheck(UserContext _ctx, Transaction transaction, ObjectLocation _parentLocation){
      if((transaction == null)){
         return;
      }
      if(transaction.newItem()){
        if(transaction.getTimestamp() == null){
           transaction.updateTimestamp(java.time.LocalDateTime.now());
        }if(transaction.getCreateTime() == null){
           transaction.updateCreateTime(java.time.LocalDateTime.now());
        }if(transaction.getUpdateTime() == null){
           transaction.updateUpdateTime(java.time.LocalDateTime.now());
        }
      }else if(transaction.updateItem()){
        transaction.updateUpdateTime(java.time.LocalDateTime.now());
      }
      checkAmount(_ctx, transaction.getProperty(Transaction.AMOUNT_PROPERTY), newLocation(_parentLocation, Transaction.AMOUNT_PROPERTY));
      checkAccount(_ctx, transaction.getProperty(Transaction.ACCOUNT_PROPERTY), newLocation(_parentLocation, Transaction.ACCOUNT_PROPERTY));
      checkTimestamp(_ctx, transaction.getProperty(Transaction.TIMESTAMP_PROPERTY), newLocation(_parentLocation, Transaction.TIMESTAMP_PROPERTY));
      checkType(_ctx, transaction.getProperty(Transaction.TYPE_PROPERTY), newLocation(_parentLocation, Transaction.TYPE_PROPERTY));
      checkCreateTime(_ctx, transaction.getProperty(Transaction.CREATE_TIME_PROPERTY), newLocation(_parentLocation, Transaction.CREATE_TIME_PROPERTY));
      checkUpdateTime(_ctx, transaction.getProperty(Transaction.UPDATE_TIME_PROPERTY), newLocation(_parentLocation, Transaction.UPDATE_TIME_PROPERTY));
      for(int i = 0; transaction.getLedgerList() != null && i < transaction.getLedgerList().size(); i++){
         Ledger ledger = transaction.getLedgerList().get(i);
         new LedgerChecker().checkAndFix(_ctx, ledger, newLocation(_parentLocation, Transaction.LEDGER_LIST_PROPERTY, i));
      }
    }

    public void checkAmount(UserContext _ctx, BigDecimal amount, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, amount);
    if((amount == null)){
        return;
    }
    }
    public void checkAccount(UserContext _ctx, Account account, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, account);
    if((account == null)){
        return;
    }
    new AccountChecker().checkAndFix(_ctx, account, _parentLocation);
    }
    public void checkTimestamp(UserContext _ctx, LocalDateTime timestamp, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, timestamp);
    if((timestamp == null)){
        return;
    }
    }
    public void checkType(UserContext _ctx, String type, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, type);
    if((type == null)){
        return;
    }
    maxStringCheck(_ctx, _parentLocation, 100, type);

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