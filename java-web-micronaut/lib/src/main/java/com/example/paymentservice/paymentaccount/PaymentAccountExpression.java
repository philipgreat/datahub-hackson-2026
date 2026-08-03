
package com.example.paymentservice.paymentaccount;

import com.example.paymentservice.paymentmethod.PaymentMethod;
import com.example.paymentservice.paymentmethod.PaymentMethodListExpression;
import com.example.paymentservice.paymenttransaction.PaymentTransaction;
import com.example.paymentservice.paymenttransaction.PaymentTransactionListExpression;
import com.example.paymentservice.useraccount.UserAccount;
import com.example.paymentservice.useraccount.UserAccountExpression;
import io.teaql.core.UserContext;
import io.teaql.core.value.BaseEntityExpression;
import io.teaql.core.value.Expression;
import io.teaql.core.value.ExpressionAdaptor;
import java.time.LocalDateTime;
import java.util.function.Function;

public class PaymentAccountExpression<T, E, U extends PaymentAccount> extends ExpressionAdaptor<T, E, U> implements BaseEntityExpression<T, U> {
    public PaymentAccountExpression(Expression<T, U> expression){
        super(expression);
    }

    public PaymentAccountExpression(Expression<T, E> expression, Function<E, U> function){
        super(expression, function);
    }

     public PaymentAccountExpression<T, U, U> updateId(Long id){
        return new PaymentAccountExpression(this, $it -> {((PaymentAccount)$it).__internalSet("id", id); return this;});
     }

     public PaymentAccountExpression<T, U, U> save(UserContext userContext){
        return new PaymentAccountExpression(this, $it -> ((PaymentAccount)$it).auditAs("Saved by Expression").save(userContext));
     }

     public PaymentAccountExpression<T, U, U> save(String intent, UserContext userContext){
        return new PaymentAccountExpression(this, $it -> ((PaymentAccount)$it).auditAs(intent).save(userContext));
     }

     public boolean isNull() {
        return resolve() == null;
     }


    public UserAccountExpression<T, U, UserAccount> getUserAccount(){
       return new UserAccountExpression(this, $it ->  ((PaymentAccount)$it).getUserAccount());
    }

    public PaymentAccountExpression<T, U, U> updateUserAccount(UserAccount userAccount){
       return new PaymentAccountExpression(this, $it ->  ((PaymentAccount)$it).updateUserAccount(userAccount));
    }

    public Expression<T, String> getAccountName(){
       return apply(PaymentAccount::getAccountName);
    }
    public PaymentAccountExpression<T, U, U> updateAccountName(String accountName){
       return new PaymentAccountExpression(this, $it ->  ((PaymentAccount)$it).updateAccountName(accountName));
    }

    public Expression<T, Integer> getAccountNumber(){
       return apply(PaymentAccount::getAccountNumber);
    }
    public PaymentAccountExpression<T, U, U> updateAccountNumber(Integer accountNumber){
       return new PaymentAccountExpression(this, $it ->  ((PaymentAccount)$it).updateAccountNumber(accountNumber));
    }

    public Expression<T, String> getCurrencyCode(){
       return apply(PaymentAccount::getCurrencyCode);
    }
    public PaymentAccountExpression<T, U, U> updateCurrencyCode(String currencyCode){
       return new PaymentAccountExpression(this, $it ->  ((PaymentAccount)$it).updateCurrencyCode(currencyCode));
    }

    public Expression<T, LocalDateTime> getCreateTime(){
       return apply(PaymentAccount::getCreateTime);
    }
    public PaymentAccountExpression<T, U, U> updateCreateTime(LocalDateTime createTime){
       return new PaymentAccountExpression(this, $it ->  ((PaymentAccount)$it).updateCreateTime(createTime));
    }

    public Expression<T, LocalDateTime> getUpdateTime(){
       return apply(PaymentAccount::getUpdateTime);
    }
    public PaymentAccountExpression<T, U, U> updateUpdateTime(LocalDateTime updateTime){
       return new PaymentAccountExpression(this, $it ->  ((PaymentAccount)$it).updateUpdateTime(updateTime));
    }

    public PaymentMethodListExpression<T, U, PaymentMethod> getPaymentMethodList(){
        return new PaymentMethodListExpression(this, $it ->  ((PaymentAccount)$it).getPaymentMethodList());
    }
    public PaymentTransactionListExpression<T, U, PaymentTransaction> getPaymentTransactionList(){
        return new PaymentTransactionListExpression(this, $it ->  ((PaymentAccount)$it).getPaymentTransactionList());
    }
    public PaymentAccountExpression<T, U, U> addPaymentMethod(PaymentMethod paymentMethod){
       return new PaymentAccountExpression(this, $it ->  ((PaymentAccount)$it).addPaymentMethod(paymentMethod));
    }
    public PaymentAccountExpression<T, U, U> addPaymentTransaction(PaymentTransaction paymentTransaction){
       return new PaymentAccountExpression(this, $it ->  ((PaymentAccount)$it).addPaymentTransaction(paymentTransaction));
    }
}