
package com.example.enterpriseerpsystem.payment;

import com.example.enterpriseerpsystem.invoice.Invoice;
import com.example.enterpriseerpsystem.invoice.InvoiceChecker;
import com.example.enterpriseerpsystem.refund.Refund;
import com.example.enterpriseerpsystem.refund.RefundChecker;
import io.teaql.core.UserContext;
import io.teaql.core.checker.Checker;
import io.teaql.core.checker.ObjectLocation;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class PaymentChecker implements Checker<Payment>{

    public String type(){
        return Payment.INTERNAL_TYPE;
    }

    public void checkAndFix(UserContext _ctx, Payment payment, ObjectLocation _parentLocation){
        if(needCheck(_ctx, payment)){
            markAsChecked(_ctx, payment);
            doCheck(_ctx, payment, _parentLocation);
        }
    }

    public void doCheck(UserContext _ctx, Payment payment, ObjectLocation _parentLocation){
      if((payment == null)){
         return;
      }
      if(payment.newItem()){
        if(payment.getPaymentDate() == null){
           payment.updatePaymentDate(java.time.LocalDateTime.now());
        }if(payment.getCreateTime() == null){
           payment.updateCreateTime(java.time.LocalDateTime.now());
        }if(payment.getUpdateTime() == null){
           payment.updateUpdateTime(java.time.LocalDateTime.now());
        }
      }else if(payment.updateItem()){
        payment.updateUpdateTime(java.time.LocalDateTime.now());
      }
      checkAmount(_ctx, payment.getProperty(Payment.AMOUNT_PROPERTY), newLocation(_parentLocation, Payment.AMOUNT_PROPERTY));
      checkCardLast4(_ctx, payment.getProperty(Payment.CARD_LAST4_PROPERTY), newLocation(_parentLocation, Payment.CARD_LAST4_PROPERTY));
      checkPaymentDate(_ctx, payment.getProperty(Payment.PAYMENT_DATE_PROPERTY), newLocation(_parentLocation, Payment.PAYMENT_DATE_PROPERTY));
      checkInvoice(_ctx, payment.getProperty(Payment.INVOICE_PROPERTY), newLocation(_parentLocation, Payment.INVOICE_PROPERTY));
      checkMethod(_ctx, payment.getProperty(Payment.METHOD_PROPERTY), newLocation(_parentLocation, Payment.METHOD_PROPERTY));
      checkStatus(_ctx, payment.getProperty(Payment.STATUS_PROPERTY), newLocation(_parentLocation, Payment.STATUS_PROPERTY));
      checkCreateTime(_ctx, payment.getProperty(Payment.CREATE_TIME_PROPERTY), newLocation(_parentLocation, Payment.CREATE_TIME_PROPERTY));
      checkUpdateTime(_ctx, payment.getProperty(Payment.UPDATE_TIME_PROPERTY), newLocation(_parentLocation, Payment.UPDATE_TIME_PROPERTY));
      for(int i = 0; payment.getRefundList() != null && i < payment.getRefundList().size(); i++){
         Refund refund = payment.getRefundList().get(i);
         new RefundChecker().checkAndFix(_ctx, refund, newLocation(_parentLocation, Payment.REFUND_LIST_PROPERTY, i));
      }
    }

    public void checkAmount(UserContext _ctx, BigDecimal amount, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, amount);
    if((amount == null)){
        return;
    }
    }
    public void checkCardLast4(UserContext _ctx, String cardLast4, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, cardLast4);
    if((cardLast4 == null)){
        return;
    }
    maxStringCheck(_ctx, _parentLocation, 100, cardLast4);

    }
    public void checkPaymentDate(UserContext _ctx, LocalDateTime paymentDate, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, paymentDate);
    if((paymentDate == null)){
        return;
    }
    }
    public void checkInvoice(UserContext _ctx, Invoice invoice, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, invoice);
    if((invoice == null)){
        return;
    }
    new InvoiceChecker().checkAndFix(_ctx, invoice, _parentLocation);
    }
    public void checkMethod(UserContext _ctx, String method, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, method);
    if((method == null)){
        return;
    }
    maxStringCheck(_ctx, _parentLocation, 100, method);

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