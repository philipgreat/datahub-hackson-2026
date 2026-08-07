
package com.example.enterpriseerpsystem.invoice;

import com.example.enterpriseerpsystem.customer.Customer;
import com.example.enterpriseerpsystem.customer.CustomerChecker;
import com.example.enterpriseerpsystem.globalorder.GlobalOrder;
import com.example.enterpriseerpsystem.globalorder.GlobalOrderChecker;
import com.example.enterpriseerpsystem.payment.Payment;
import com.example.enterpriseerpsystem.payment.PaymentChecker;
import io.teaql.core.UserContext;
import io.teaql.core.checker.Checker;
import io.teaql.core.checker.ObjectLocation;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class InvoiceChecker implements Checker<Invoice>{

    public String type(){
        return Invoice.INTERNAL_TYPE;
    }

    public void checkAndFix(UserContext _ctx, Invoice invoice, ObjectLocation _parentLocation){
        if(needCheck(_ctx, invoice)){
            markAsChecked(_ctx, invoice);
            doCheck(_ctx, invoice, _parentLocation);
        }
    }

    public void doCheck(UserContext _ctx, Invoice invoice, ObjectLocation _parentLocation){
      if((invoice == null)){
         return;
      }
      if(invoice.newItem()){
        if(invoice.getDueDate() == null){
           invoice.updateDueDate(java.time.LocalDateTime.now());
        }if(invoice.getIssueDate() == null){
           invoice.updateIssueDate(java.time.LocalDateTime.now());
        }if(invoice.getCreateTime() == null){
           invoice.updateCreateTime(java.time.LocalDateTime.now());
        }if(invoice.getUpdateTime() == null){
           invoice.updateUpdateTime(java.time.LocalDateTime.now());
        }
      }else if(invoice.updateItem()){
        invoice.updateUpdateTime(java.time.LocalDateTime.now());
      }
      checkAmount(_ctx, invoice.getProperty(Invoice.AMOUNT_PROPERTY), newLocation(_parentLocation, Invoice.AMOUNT_PROPERTY));
      checkCustomer(_ctx, invoice.getProperty(Invoice.CUSTOMER_PROPERTY), newLocation(_parentLocation, Invoice.CUSTOMER_PROPERTY));
      checkDueDate(_ctx, invoice.getProperty(Invoice.DUE_DATE_PROPERTY), newLocation(_parentLocation, Invoice.DUE_DATE_PROPERTY));
      checkGlobalOrder(_ctx, invoice.getProperty(Invoice.GLOBAL_ORDER_PROPERTY), newLocation(_parentLocation, Invoice.GLOBAL_ORDER_PROPERTY));
      checkIssueDate(_ctx, invoice.getProperty(Invoice.ISSUE_DATE_PROPERTY), newLocation(_parentLocation, Invoice.ISSUE_DATE_PROPERTY));
      checkStatus(_ctx, invoice.getProperty(Invoice.STATUS_PROPERTY), newLocation(_parentLocation, Invoice.STATUS_PROPERTY));
      checkCreateTime(_ctx, invoice.getProperty(Invoice.CREATE_TIME_PROPERTY), newLocation(_parentLocation, Invoice.CREATE_TIME_PROPERTY));
      checkUpdateTime(_ctx, invoice.getProperty(Invoice.UPDATE_TIME_PROPERTY), newLocation(_parentLocation, Invoice.UPDATE_TIME_PROPERTY));
      for(int i = 0; invoice.getPaymentList() != null && i < invoice.getPaymentList().size(); i++){
         Payment payment = invoice.getPaymentList().get(i);
         new PaymentChecker().checkAndFix(_ctx, payment, newLocation(_parentLocation, Invoice.PAYMENT_LIST_PROPERTY, i));
      }
    }

    public void checkAmount(UserContext _ctx, BigDecimal amount, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, amount);
    if((amount == null)){
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
    public void checkDueDate(UserContext _ctx, LocalDateTime dueDate, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, dueDate);
    if((dueDate == null)){
        return;
    }
    }
    public void checkGlobalOrder(UserContext _ctx, GlobalOrder globalOrder, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, globalOrder);
    if((globalOrder == null)){
        return;
    }
    new GlobalOrderChecker().checkAndFix(_ctx, globalOrder, _parentLocation);
    }
    public void checkIssueDate(UserContext _ctx, LocalDateTime issueDate, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, issueDate);
    if((issueDate == null)){
        return;
    }
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