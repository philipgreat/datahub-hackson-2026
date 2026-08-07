
package com.example.enterpriseerpsystem.contract;

import com.example.enterpriseerpsystem.customer.Customer;
import com.example.enterpriseerpsystem.customer.CustomerChecker;
import io.teaql.core.UserContext;
import io.teaql.core.checker.Checker;
import io.teaql.core.checker.ObjectLocation;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ContractChecker implements Checker<Contract>{

    public String type(){
        return Contract.INTERNAL_TYPE;
    }

    public void checkAndFix(UserContext _ctx, Contract contract, ObjectLocation _parentLocation){
        if(needCheck(_ctx, contract)){
            markAsChecked(_ctx, contract);
            doCheck(_ctx, contract, _parentLocation);
        }
    }

    public void doCheck(UserContext _ctx, Contract contract, ObjectLocation _parentLocation){
      if((contract == null)){
         return;
      }
      if(contract.newItem()){
        if(contract.getEndDate() == null){
           contract.updateEndDate(java.time.LocalDateTime.now());
        }if(contract.getStartDate() == null){
           contract.updateStartDate(java.time.LocalDateTime.now());
        }if(contract.getCreateTime() == null){
           contract.updateCreateTime(java.time.LocalDateTime.now());
        }if(contract.getUpdateTime() == null){
           contract.updateUpdateTime(java.time.LocalDateTime.now());
        }
      }else if(contract.updateItem()){
        contract.updateUpdateTime(java.time.LocalDateTime.now());
      }
      checkCustomer(_ctx, contract.getProperty(Contract.CUSTOMER_PROPERTY), newLocation(_parentLocation, Contract.CUSTOMER_PROPERTY));
      checkEndDate(_ctx, contract.getProperty(Contract.END_DATE_PROPERTY), newLocation(_parentLocation, Contract.END_DATE_PROPERTY));
      checkStartDate(_ctx, contract.getProperty(Contract.START_DATE_PROPERTY), newLocation(_parentLocation, Contract.START_DATE_PROPERTY));
      checkTerms(_ctx, contract.getProperty(Contract.TERMS_PROPERTY), newLocation(_parentLocation, Contract.TERMS_PROPERTY));
      checkValue(_ctx, contract.getProperty(Contract.VALUE_PROPERTY), newLocation(_parentLocation, Contract.VALUE_PROPERTY));
      checkCreateTime(_ctx, contract.getProperty(Contract.CREATE_TIME_PROPERTY), newLocation(_parentLocation, Contract.CREATE_TIME_PROPERTY));
      checkUpdateTime(_ctx, contract.getProperty(Contract.UPDATE_TIME_PROPERTY), newLocation(_parentLocation, Contract.UPDATE_TIME_PROPERTY));
    }

    public void checkCustomer(UserContext _ctx, Customer customer, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, customer);
    if((customer == null)){
        return;
    }
    new CustomerChecker().checkAndFix(_ctx, customer, _parentLocation);
    }
    public void checkEndDate(UserContext _ctx, LocalDateTime endDate, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, endDate);
    if((endDate == null)){
        return;
    }
    }
    public void checkStartDate(UserContext _ctx, LocalDateTime startDate, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, startDate);
    if((startDate == null)){
        return;
    }
    }
    public void checkTerms(UserContext _ctx, String terms, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, terms);
    if((terms == null)){
        return;
    }
    maxStringCheck(_ctx, _parentLocation, 100, terms);

    }
    public void checkValue(UserContext _ctx, BigDecimal value, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, value);
    if((value == null)){
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