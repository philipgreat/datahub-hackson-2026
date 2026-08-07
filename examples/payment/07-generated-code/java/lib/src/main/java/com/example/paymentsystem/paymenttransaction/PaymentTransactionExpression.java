
package com.example.paymentsystem.paymenttransaction;

import io.teaql.core.UserContext;
import io.teaql.core.value.BaseEntityExpression;
import io.teaql.core.value.Expression;
import io.teaql.core.value.ExpressionAdaptor;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.function.Function;

public class PaymentTransactionExpression<T, E, U extends PaymentTransaction> extends ExpressionAdaptor<T, E, U> implements BaseEntityExpression<T, U> {
    public PaymentTransactionExpression(Expression<T, U> expression){
        super(expression);
    }

    public PaymentTransactionExpression(Expression<T, E> expression, Function<E, U> function){
        super(expression, function);
    }

     public PaymentTransactionExpression<T, U, U> updateId(Long id){
        return new PaymentTransactionExpression(this, $it -> {((PaymentTransaction)$it).__internalSet("id", id); return this;});
     }

     public PaymentTransactionExpression<T, U, U> save(UserContext userContext){
        return new PaymentTransactionExpression(this, $it -> ((PaymentTransaction)$it).auditAs("Saved by Expression").save(userContext));
     }

     public PaymentTransactionExpression<T, U, U> save(String intent, UserContext userContext){
        return new PaymentTransactionExpression(this, $it -> ((PaymentTransaction)$it).auditAs(intent).save(userContext));
     }

     public boolean isNull() {
        return resolve() == null;
     }


    public Expression<T, String> getPaymentAccount(){
       return apply(PaymentTransaction::getPaymentAccount);
    }
    public PaymentTransactionExpression<T, U, U> updatePaymentAccount(String paymentAccount){
       return new PaymentTransactionExpression(this, $it ->  ((PaymentTransaction)$it).updatePaymentAccount(paymentAccount));
    }

    public Expression<T, String> getCurrencyCode(){
       return apply(PaymentTransaction::getCurrencyCode);
    }
    public PaymentTransactionExpression<T, U, U> updateCurrencyCode(String currencyCode){
       return new PaymentTransactionExpression(this, $it ->  ((PaymentTransaction)$it).updateCurrencyCode(currencyCode));
    }

    public Expression<T, String> getPaymentMethod(){
       return apply(PaymentTransaction::getPaymentMethod);
    }
    public PaymentTransactionExpression<T, U, U> updatePaymentMethod(String paymentMethod){
       return new PaymentTransactionExpression(this, $it ->  ((PaymentTransaction)$it).updatePaymentMethod(paymentMethod));
    }

    public Expression<T, BigDecimal> getTransactionAmount(){
       return apply(PaymentTransaction::getTransactionAmount);
    }
    public PaymentTransactionExpression<T, U, U> updateTransactionAmount(BigDecimal transactionAmount){
       return new PaymentTransactionExpression(this, $it ->  ((PaymentTransaction)$it).updateTransactionAmount(transactionAmount));
    }

    public Expression<T, LocalDateTime> getCreateTime(){
       return apply(PaymentTransaction::getCreateTime);
    }
    public PaymentTransactionExpression<T, U, U> updateCreateTime(LocalDateTime createTime){
       return new PaymentTransactionExpression(this, $it ->  ((PaymentTransaction)$it).updateCreateTime(createTime));
    }

    public Expression<T, LocalDateTime> getUpdateTime(){
       return apply(PaymentTransaction::getUpdateTime);
    }
    public PaymentTransactionExpression<T, U, U> updateUpdateTime(LocalDateTime updateTime){
       return new PaymentTransactionExpression(this, $it ->  ((PaymentTransaction)$it).updateUpdateTime(updateTime));
    }

}