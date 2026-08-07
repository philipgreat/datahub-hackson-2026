
package com.example.enterpriseerpsystem.payment;

import com.example.enterpriseerpsystem.invoice.Invoice;
import com.example.enterpriseerpsystem.invoice.InvoiceExpression;
import com.example.enterpriseerpsystem.refund.Refund;
import com.example.enterpriseerpsystem.refund.RefundListExpression;
import io.teaql.core.UserContext;
import io.teaql.core.value.BaseEntityExpression;
import io.teaql.core.value.Expression;
import io.teaql.core.value.ExpressionAdaptor;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.function.Function;

public class PaymentExpression<T, E, U extends Payment> extends ExpressionAdaptor<T, E, U> implements BaseEntityExpression<T, U> {
    public PaymentExpression(Expression<T, U> expression){
        super(expression);
    }

    public PaymentExpression(Expression<T, E> expression, Function<E, U> function){
        super(expression, function);
    }

     public PaymentExpression<T, U, U> updateId(Long id){
        return new PaymentExpression(this, $it -> {((Payment)$it).__internalSet("id", id); return this;});
     }

     public PaymentExpression<T, U, U> save(UserContext userContext){
        return new PaymentExpression(this, $it -> ((Payment)$it).auditAs("Saved by Expression").save(userContext));
     }

     public PaymentExpression<T, U, U> save(String intent, UserContext userContext){
        return new PaymentExpression(this, $it -> ((Payment)$it).auditAs(intent).save(userContext));
     }

     public boolean isNull() {
        return resolve() == null;
     }


    public Expression<T, BigDecimal> getAmount(){
       return apply(Payment::getAmount);
    }
    public PaymentExpression<T, U, U> updateAmount(BigDecimal amount){
       return new PaymentExpression(this, $it ->  ((Payment)$it).updateAmount(amount));
    }

    public Expression<T, String> getCardLast4(){
       return apply(Payment::getCardLast4);
    }
    public PaymentExpression<T, U, U> updateCardLast4(String cardLast4){
       return new PaymentExpression(this, $it ->  ((Payment)$it).updateCardLast4(cardLast4));
    }

    public Expression<T, LocalDateTime> getPaymentDate(){
       return apply(Payment::getPaymentDate);
    }
    public PaymentExpression<T, U, U> updatePaymentDate(LocalDateTime paymentDate){
       return new PaymentExpression(this, $it ->  ((Payment)$it).updatePaymentDate(paymentDate));
    }

    public InvoiceExpression<T, U, Invoice> getInvoice(){
       return new InvoiceExpression(this, $it ->  ((Payment)$it).getInvoice());
    }

    public PaymentExpression<T, U, U> updateInvoice(Invoice invoice){
       return new PaymentExpression(this, $it ->  ((Payment)$it).updateInvoice(invoice));
    }

    public Expression<T, String> getMethod(){
       return apply(Payment::getMethod);
    }
    public PaymentExpression<T, U, U> updateMethod(String method){
       return new PaymentExpression(this, $it ->  ((Payment)$it).updateMethod(method));
    }

    public Expression<T, String> getStatus(){
       return apply(Payment::getStatus);
    }
    public PaymentExpression<T, U, U> updateStatus(String status){
       return new PaymentExpression(this, $it ->  ((Payment)$it).updateStatus(status));
    }

    public Expression<T, LocalDateTime> getCreateTime(){
       return apply(Payment::getCreateTime);
    }
    public PaymentExpression<T, U, U> updateCreateTime(LocalDateTime createTime){
       return new PaymentExpression(this, $it ->  ((Payment)$it).updateCreateTime(createTime));
    }

    public Expression<T, LocalDateTime> getUpdateTime(){
       return apply(Payment::getUpdateTime);
    }
    public PaymentExpression<T, U, U> updateUpdateTime(LocalDateTime updateTime){
       return new PaymentExpression(this, $it ->  ((Payment)$it).updateUpdateTime(updateTime));
    }

    public RefundListExpression<T, U, Refund> getRefundList(){
        return new RefundListExpression(this, $it ->  ((Payment)$it).getRefundList());
    }
    public PaymentExpression<T, U, U> addRefund(Refund refund){
       return new PaymentExpression(this, $it ->  ((Payment)$it).addRefund(refund));
    }
}