
package com.example.enterpriseerpsystem.transaction;

import com.example.enterpriseerpsystem.account.Account;
import com.example.enterpriseerpsystem.account.AccountExpression;
import com.example.enterpriseerpsystem.ledger.Ledger;
import com.example.enterpriseerpsystem.ledger.LedgerListExpression;
import io.teaql.core.UserContext;
import io.teaql.core.value.BaseEntityExpression;
import io.teaql.core.value.Expression;
import io.teaql.core.value.ExpressionAdaptor;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.function.Function;

public class TransactionExpression<T, E, U extends Transaction> extends ExpressionAdaptor<T, E, U> implements BaseEntityExpression<T, U> {
    public TransactionExpression(Expression<T, U> expression){
        super(expression);
    }

    public TransactionExpression(Expression<T, E> expression, Function<E, U> function){
        super(expression, function);
    }

     public TransactionExpression<T, U, U> updateId(Long id){
        return new TransactionExpression(this, $it -> {((Transaction)$it).__internalSet("id", id); return this;});
     }

     public TransactionExpression<T, U, U> save(UserContext userContext){
        return new TransactionExpression(this, $it -> ((Transaction)$it).auditAs("Saved by Expression").save(userContext));
     }

     public TransactionExpression<T, U, U> save(String intent, UserContext userContext){
        return new TransactionExpression(this, $it -> ((Transaction)$it).auditAs(intent).save(userContext));
     }

     public boolean isNull() {
        return resolve() == null;
     }


    public Expression<T, BigDecimal> getAmount(){
       return apply(Transaction::getAmount);
    }
    public TransactionExpression<T, U, U> updateAmount(BigDecimal amount){
       return new TransactionExpression(this, $it ->  ((Transaction)$it).updateAmount(amount));
    }

    public AccountExpression<T, U, Account> getAccount(){
       return new AccountExpression(this, $it ->  ((Transaction)$it).getAccount());
    }

    public TransactionExpression<T, U, U> updateAccount(Account account){
       return new TransactionExpression(this, $it ->  ((Transaction)$it).updateAccount(account));
    }

    public Expression<T, LocalDateTime> getTimestamp(){
       return apply(Transaction::getTimestamp);
    }
    public TransactionExpression<T, U, U> updateTimestamp(LocalDateTime timestamp){
       return new TransactionExpression(this, $it ->  ((Transaction)$it).updateTimestamp(timestamp));
    }

    public Expression<T, String> getType(){
       return apply(Transaction::getType);
    }
    public TransactionExpression<T, U, U> updateType(String type){
       return new TransactionExpression(this, $it ->  ((Transaction)$it).updateType(type));
    }

    public Expression<T, LocalDateTime> getCreateTime(){
       return apply(Transaction::getCreateTime);
    }
    public TransactionExpression<T, U, U> updateCreateTime(LocalDateTime createTime){
       return new TransactionExpression(this, $it ->  ((Transaction)$it).updateCreateTime(createTime));
    }

    public Expression<T, LocalDateTime> getUpdateTime(){
       return apply(Transaction::getUpdateTime);
    }
    public TransactionExpression<T, U, U> updateUpdateTime(LocalDateTime updateTime){
       return new TransactionExpression(this, $it ->  ((Transaction)$it).updateUpdateTime(updateTime));
    }

    public LedgerListExpression<T, U, Ledger> getLedgerList(){
        return new LedgerListExpression(this, $it ->  ((Transaction)$it).getLedgerList());
    }
    public TransactionExpression<T, U, U> addLedger(Ledger ledger){
       return new TransactionExpression(this, $it ->  ((Transaction)$it).addLedger(ledger));
    }
}