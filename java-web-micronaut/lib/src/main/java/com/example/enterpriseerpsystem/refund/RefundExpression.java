
package com.example.enterpriseerpsystem.refund;

import com.example.enterpriseerpsystem.payment.Payment;
import com.example.enterpriseerpsystem.payment.PaymentExpression;
import io.teaql.core.UserContext;
import io.teaql.core.value.BaseEntityExpression;
import io.teaql.core.value.Expression;
import io.teaql.core.value.ExpressionAdaptor;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.function.Function;

public class RefundExpression<T, E, U extends Refund> extends ExpressionAdaptor<T, E, U> implements BaseEntityExpression<T, U> {
    public RefundExpression(Expression<T, U> expression){
        super(expression);
    }

    public RefundExpression(Expression<T, E> expression, Function<E, U> function){
        super(expression, function);
    }

     public RefundExpression<T, U, U> updateId(Long id){
        return new RefundExpression(this, $it -> {((Refund)$it).__internalSet("id", id); return this;});
     }

     public RefundExpression<T, U, U> save(UserContext userContext){
        return new RefundExpression(this, $it -> ((Refund)$it).auditAs("Saved by Expression").save(userContext));
     }

     public RefundExpression<T, U, U> save(String intent, UserContext userContext){
        return new RefundExpression(this, $it -> ((Refund)$it).auditAs(intent).save(userContext));
     }

     public boolean isNull() {
        return resolve() == null;
     }


    public Expression<T, BigDecimal> getAmount(){
       return apply(Refund::getAmount);
    }
    public RefundExpression<T, U, U> updateAmount(BigDecimal amount){
       return new RefundExpression(this, $it ->  ((Refund)$it).updateAmount(amount));
    }

    public PaymentExpression<T, U, Payment> getPayment(){
       return new PaymentExpression(this, $it ->  ((Refund)$it).getPayment());
    }

    public RefundExpression<T, U, U> updatePayment(Payment payment){
       return new RefundExpression(this, $it ->  ((Refund)$it).updatePayment(payment));
    }

    public Expression<T, LocalDateTime> getProcessedDate(){
       return apply(Refund::getProcessedDate);
    }
    public RefundExpression<T, U, U> updateProcessedDate(LocalDateTime processedDate){
       return new RefundExpression(this, $it ->  ((Refund)$it).updateProcessedDate(processedDate));
    }

    public Expression<T, String> getReason(){
       return apply(Refund::getReason);
    }
    public RefundExpression<T, U, U> updateReason(String reason){
       return new RefundExpression(this, $it ->  ((Refund)$it).updateReason(reason));
    }

    public Expression<T, LocalDateTime> getCreateTime(){
       return apply(Refund::getCreateTime);
    }
    public RefundExpression<T, U, U> updateCreateTime(LocalDateTime createTime){
       return new RefundExpression(this, $it ->  ((Refund)$it).updateCreateTime(createTime));
    }

    public Expression<T, LocalDateTime> getUpdateTime(){
       return apply(Refund::getUpdateTime);
    }
    public RefundExpression<T, U, U> updateUpdateTime(LocalDateTime updateTime){
       return new RefundExpression(this, $it ->  ((Refund)$it).updateUpdateTime(updateTime));
    }

}