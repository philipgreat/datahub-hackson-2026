
package com.example.enterpriseerpsystem.account;

import com.example.enterpriseerpsystem.transaction.Transaction;
import com.example.enterpriseerpsystem.transaction.TransactionListExpression;
import io.teaql.core.UserContext;
import io.teaql.core.value.BaseEntityExpression;
import io.teaql.core.value.Expression;
import io.teaql.core.value.ExpressionAdaptor;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.function.Function;

public class AccountExpression<T, E, U extends Account> extends ExpressionAdaptor<T, E, U> implements BaseEntityExpression<T, U> {
    public AccountExpression(Expression<T, U> expression){
        super(expression);
    }

    public AccountExpression(Expression<T, E> expression, Function<E, U> function){
        super(expression, function);
    }

     public AccountExpression<T, U, U> updateId(Long id){
        return new AccountExpression(this, $it -> {((Account)$it).__internalSet("id", id); return this;});
     }

     public AccountExpression<T, U, U> save(UserContext userContext){
        return new AccountExpression(this, $it -> ((Account)$it).auditAs("Saved by Expression").save(userContext));
     }

     public AccountExpression<T, U, U> save(String intent, UserContext userContext){
        return new AccountExpression(this, $it -> ((Account)$it).auditAs(intent).save(userContext));
     }

     public boolean isNull() {
        return resolve() == null;
     }


    public Expression<T, String> getName(){
       return apply(Account::getName);
    }
    public AccountExpression<T, U, U> updateName(String name){
       return new AccountExpression(this, $it ->  ((Account)$it).updateName(name));
    }

    public Expression<T, String> getAccountType(){
       return apply(Account::getAccountType);
    }
    public AccountExpression<T, U, U> updateAccountType(String accountType){
       return new AccountExpression(this, $it ->  ((Account)$it).updateAccountType(accountType));
    }

    public Expression<T, BigDecimal> getBalance(){
       return apply(Account::getBalance);
    }
    public AccountExpression<T, U, U> updateBalance(BigDecimal balance){
       return new AccountExpression(this, $it ->  ((Account)$it).updateBalance(balance));
    }

    public Expression<T, String> getCurrency(){
       return apply(Account::getCurrency);
    }
    public AccountExpression<T, U, U> updateCurrency(String currency){
       return new AccountExpression(this, $it ->  ((Account)$it).updateCurrency(currency));
    }

    public Expression<T, LocalDateTime> getCreateTime(){
       return apply(Account::getCreateTime);
    }
    public AccountExpression<T, U, U> updateCreateTime(LocalDateTime createTime){
       return new AccountExpression(this, $it ->  ((Account)$it).updateCreateTime(createTime));
    }

    public Expression<T, LocalDateTime> getUpdateTime(){
       return apply(Account::getUpdateTime);
    }
    public AccountExpression<T, U, U> updateUpdateTime(LocalDateTime updateTime){
       return new AccountExpression(this, $it ->  ((Account)$it).updateUpdateTime(updateTime));
    }

    public TransactionListExpression<T, U, Transaction> getTransactionList(){
        return new TransactionListExpression(this, $it ->  ((Account)$it).getTransactionList());
    }
    public AccountExpression<T, U, U> addTransaction(Transaction transaction){
       return new AccountExpression(this, $it ->  ((Account)$it).addTransaction(transaction));
    }
}