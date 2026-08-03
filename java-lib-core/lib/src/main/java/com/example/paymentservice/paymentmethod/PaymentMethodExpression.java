
package com.example.paymentservice.paymentmethod;

import com.example.paymentservice.paymentaccount.PaymentAccount;
import com.example.paymentservice.paymentaccount.PaymentAccountExpression;
import com.example.paymentservice.paymenttransaction.PaymentTransaction;
import com.example.paymentservice.paymenttransaction.PaymentTransactionListExpression;
import io.teaql.core.UserContext;
import io.teaql.core.value.BaseEntityExpression;
import io.teaql.core.value.Expression;
import io.teaql.core.value.ExpressionAdaptor;
import java.time.LocalDateTime;
import java.util.function.Function;

public class PaymentMethodExpression<T, E, U extends PaymentMethod> extends ExpressionAdaptor<T, E, U> implements BaseEntityExpression<T, U> {
    public PaymentMethodExpression(Expression<T, U> expression){
        super(expression);
    }

    public PaymentMethodExpression(Expression<T, E> expression, Function<E, U> function){
        super(expression, function);
    }

     public PaymentMethodExpression<T, U, U> updateId(Long id){
        return new PaymentMethodExpression(this, $it -> {((PaymentMethod)$it).__internalSet("id", id); return this;});
     }

     public PaymentMethodExpression<T, U, U> save(UserContext userContext){
        return new PaymentMethodExpression(this, $it -> ((PaymentMethod)$it).auditAs("Saved by Expression").save(userContext));
     }

     public PaymentMethodExpression<T, U, U> save(String intent, UserContext userContext){
        return new PaymentMethodExpression(this, $it -> ((PaymentMethod)$it).auditAs(intent).save(userContext));
     }

     public boolean isNull() {
        return resolve() == null;
     }


    public PaymentAccountExpression<T, U, PaymentAccount> getPaymentAccount(){
       return new PaymentAccountExpression(this, $it ->  ((PaymentMethod)$it).getPaymentAccount());
    }

    public PaymentMethodExpression<T, U, U> updatePaymentAccount(PaymentAccount paymentAccount){
       return new PaymentMethodExpression(this, $it ->  ((PaymentMethod)$it).updatePaymentAccount(paymentAccount));
    }

    public Expression<T, String> getMethodType(){
       return apply(PaymentMethod::getMethodType);
    }
    public PaymentMethodExpression<T, U, U> updateMethodType(String methodType){
       return new PaymentMethodExpression(this, $it ->  ((PaymentMethod)$it).updateMethodType(methodType));
    }

    public Expression<T, Integer> getLastFourDigits(){
       return apply(PaymentMethod::getLastFourDigits);
    }
    public PaymentMethodExpression<T, U, U> updateLastFourDigits(Integer lastFourDigits){
       return new PaymentMethodExpression(this, $it ->  ((PaymentMethod)$it).updateLastFourDigits(lastFourDigits));
    }

    public Expression<T, LocalDateTime> getCreateTime(){
       return apply(PaymentMethod::getCreateTime);
    }
    public PaymentMethodExpression<T, U, U> updateCreateTime(LocalDateTime createTime){
       return new PaymentMethodExpression(this, $it ->  ((PaymentMethod)$it).updateCreateTime(createTime));
    }

    public Expression<T, LocalDateTime> getUpdateTime(){
       return apply(PaymentMethod::getUpdateTime);
    }
    public PaymentMethodExpression<T, U, U> updateUpdateTime(LocalDateTime updateTime){
       return new PaymentMethodExpression(this, $it ->  ((PaymentMethod)$it).updateUpdateTime(updateTime));
    }

    public PaymentTransactionListExpression<T, U, PaymentTransaction> getPaymentTransactionList(){
        return new PaymentTransactionListExpression(this, $it ->  ((PaymentMethod)$it).getPaymentTransactionList());
    }
    public PaymentMethodExpression<T, U, U> addPaymentTransaction(PaymentTransaction paymentTransaction){
       return new PaymentMethodExpression(this, $it ->  ((PaymentMethod)$it).addPaymentTransaction(paymentTransaction));
    }
}