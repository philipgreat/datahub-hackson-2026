
package com.example.paymentservice.useraccount;

import com.example.paymentservice.paymentaccount.PaymentAccount;
import com.example.paymentservice.paymentaccount.PaymentAccountListExpression;
import io.teaql.core.UserContext;
import io.teaql.core.value.BaseEntityExpression;
import io.teaql.core.value.Expression;
import io.teaql.core.value.ExpressionAdaptor;
import java.time.LocalDateTime;
import java.util.function.Function;

public class UserAccountExpression<T, E, U extends UserAccount> extends ExpressionAdaptor<T, E, U> implements BaseEntityExpression<T, U> {
    public UserAccountExpression(Expression<T, U> expression){
        super(expression);
    }

    public UserAccountExpression(Expression<T, E> expression, Function<E, U> function){
        super(expression, function);
    }

     public UserAccountExpression<T, U, U> updateId(Long id){
        return new UserAccountExpression(this, $it -> {((UserAccount)$it).__internalSet("id", id); return this;});
     }

     public UserAccountExpression<T, U, U> save(UserContext userContext){
        return new UserAccountExpression(this, $it -> ((UserAccount)$it).auditAs("Saved by Expression").save(userContext));
     }

     public UserAccountExpression<T, U, U> save(String intent, UserContext userContext){
        return new UserAccountExpression(this, $it -> ((UserAccount)$it).auditAs(intent).save(userContext));
     }

     public boolean isNull() {
        return resolve() == null;
     }


    public Expression<T, String> getUserId(){
       return apply(UserAccount::getUserId);
    }
    public UserAccountExpression<T, U, U> updateUserId(String userId){
       return new UserAccountExpression(this, $it ->  ((UserAccount)$it).updateUserId(userId));
    }

    public Expression<T, String> getUserName(){
       return apply(UserAccount::getUserName);
    }
    public UserAccountExpression<T, U, U> updateUserName(String userName){
       return new UserAccountExpression(this, $it ->  ((UserAccount)$it).updateUserName(userName));
    }

    public Expression<T, LocalDateTime> getCreateTime(){
       return apply(UserAccount::getCreateTime);
    }
    public UserAccountExpression<T, U, U> updateCreateTime(LocalDateTime createTime){
       return new UserAccountExpression(this, $it ->  ((UserAccount)$it).updateCreateTime(createTime));
    }

    public Expression<T, LocalDateTime> getUpdateTime(){
       return apply(UserAccount::getUpdateTime);
    }
    public UserAccountExpression<T, U, U> updateUpdateTime(LocalDateTime updateTime){
       return new UserAccountExpression(this, $it ->  ((UserAccount)$it).updateUpdateTime(updateTime));
    }

    public PaymentAccountListExpression<T, U, PaymentAccount> getPaymentAccountList(){
        return new PaymentAccountListExpression(this, $it ->  ((UserAccount)$it).getPaymentAccountList());
    }
    public UserAccountExpression<T, U, U> addPaymentAccount(PaymentAccount paymentAccount){
       return new UserAccountExpression(this, $it ->  ((UserAccount)$it).addPaymentAccount(paymentAccount));
    }
}