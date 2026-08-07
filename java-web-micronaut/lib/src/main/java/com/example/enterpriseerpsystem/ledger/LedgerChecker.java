
package com.example.enterpriseerpsystem.ledger;

import com.example.enterpriseerpsystem.transaction.Transaction;
import com.example.enterpriseerpsystem.transaction.TransactionChecker;
import io.teaql.core.UserContext;
import io.teaql.core.checker.Checker;
import io.teaql.core.checker.ObjectLocation;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class LedgerChecker implements Checker<Ledger>{

    public String type(){
        return Ledger.INTERNAL_TYPE;
    }

    public void checkAndFix(UserContext _ctx, Ledger ledger, ObjectLocation _parentLocation){
        if(needCheck(_ctx, ledger)){
            markAsChecked(_ctx, ledger);
            doCheck(_ctx, ledger, _parentLocation);
        }
    }

    public void doCheck(UserContext _ctx, Ledger ledger, ObjectLocation _parentLocation){
      if((ledger == null)){
         return;
      }
      if(ledger.newItem()){
        if(ledger.getEntryDate() == null){
           ledger.updateEntryDate(java.time.LocalDateTime.now());
        }if(ledger.getCreateTime() == null){
           ledger.updateCreateTime(java.time.LocalDateTime.now());
        }if(ledger.getUpdateTime() == null){
           ledger.updateUpdateTime(java.time.LocalDateTime.now());
        }
      }else if(ledger.updateItem()){
        ledger.updateUpdateTime(java.time.LocalDateTime.now());
      }
      checkCredit(_ctx, ledger.getProperty(Ledger.CREDIT_PROPERTY), newLocation(_parentLocation, Ledger.CREDIT_PROPERTY));
      checkDebit(_ctx, ledger.getProperty(Ledger.DEBIT_PROPERTY), newLocation(_parentLocation, Ledger.DEBIT_PROPERTY));
      checkEntryDate(_ctx, ledger.getProperty(Ledger.ENTRY_DATE_PROPERTY), newLocation(_parentLocation, Ledger.ENTRY_DATE_PROPERTY));
      checkTransaction(_ctx, ledger.getProperty(Ledger.TRANSACTION_PROPERTY), newLocation(_parentLocation, Ledger.TRANSACTION_PROPERTY));
      checkCreateTime(_ctx, ledger.getProperty(Ledger.CREATE_TIME_PROPERTY), newLocation(_parentLocation, Ledger.CREATE_TIME_PROPERTY));
      checkUpdateTime(_ctx, ledger.getProperty(Ledger.UPDATE_TIME_PROPERTY), newLocation(_parentLocation, Ledger.UPDATE_TIME_PROPERTY));
    }

    public void checkCredit(UserContext _ctx, BigDecimal credit, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, credit);
    if((credit == null)){
        return;
    }
    }
    public void checkDebit(UserContext _ctx, BigDecimal debit, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, debit);
    if((debit == null)){
        return;
    }
    }
    public void checkEntryDate(UserContext _ctx, LocalDateTime entryDate, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, entryDate);
    if((entryDate == null)){
        return;
    }
    }
    public void checkTransaction(UserContext _ctx, Transaction transaction, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, transaction);
    if((transaction == null)){
        return;
    }
    new TransactionChecker().checkAndFix(_ctx, transaction, _parentLocation);
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