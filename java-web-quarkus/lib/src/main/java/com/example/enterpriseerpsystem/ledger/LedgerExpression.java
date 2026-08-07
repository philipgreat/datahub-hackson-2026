
package com.example.enterpriseerpsystem.ledger;

import com.example.enterpriseerpsystem.transaction.Transaction;
import com.example.enterpriseerpsystem.transaction.TransactionExpression;
import io.teaql.core.UserContext;
import io.teaql.core.value.BaseEntityExpression;
import io.teaql.core.value.Expression;
import io.teaql.core.value.ExpressionAdaptor;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.function.Function;

public class LedgerExpression<T, E, U extends Ledger> extends ExpressionAdaptor<T, E, U> implements BaseEntityExpression<T, U> {
    public LedgerExpression(Expression<T, U> expression){
        super(expression);
    }

    public LedgerExpression(Expression<T, E> expression, Function<E, U> function){
        super(expression, function);
    }

     public LedgerExpression<T, U, U> updateId(Long id){
        return new LedgerExpression(this, $it -> {((Ledger)$it).__internalSet("id", id); return this;});
     }

     public LedgerExpression<T, U, U> save(UserContext userContext){
        return new LedgerExpression(this, $it -> ((Ledger)$it).auditAs("Saved by Expression").save(userContext));
     }

     public LedgerExpression<T, U, U> save(String intent, UserContext userContext){
        return new LedgerExpression(this, $it -> ((Ledger)$it).auditAs(intent).save(userContext));
     }

     public boolean isNull() {
        return resolve() == null;
     }


    public Expression<T, BigDecimal> getCredit(){
       return apply(Ledger::getCredit);
    }
    public LedgerExpression<T, U, U> updateCredit(BigDecimal credit){
       return new LedgerExpression(this, $it ->  ((Ledger)$it).updateCredit(credit));
    }

    public Expression<T, BigDecimal> getDebit(){
       return apply(Ledger::getDebit);
    }
    public LedgerExpression<T, U, U> updateDebit(BigDecimal debit){
       return new LedgerExpression(this, $it ->  ((Ledger)$it).updateDebit(debit));
    }

    public Expression<T, LocalDateTime> getEntryDate(){
       return apply(Ledger::getEntryDate);
    }
    public LedgerExpression<T, U, U> updateEntryDate(LocalDateTime entryDate){
       return new LedgerExpression(this, $it ->  ((Ledger)$it).updateEntryDate(entryDate));
    }

    public TransactionExpression<T, U, Transaction> getTransaction(){
       return new TransactionExpression(this, $it ->  ((Ledger)$it).getTransaction());
    }

    public LedgerExpression<T, U, U> updateTransaction(Transaction transaction){
       return new LedgerExpression(this, $it ->  ((Ledger)$it).updateTransaction(transaction));
    }

    public Expression<T, LocalDateTime> getCreateTime(){
       return apply(Ledger::getCreateTime);
    }
    public LedgerExpression<T, U, U> updateCreateTime(LocalDateTime createTime){
       return new LedgerExpression(this, $it ->  ((Ledger)$it).updateCreateTime(createTime));
    }

    public Expression<T, LocalDateTime> getUpdateTime(){
       return apply(Ledger::getUpdateTime);
    }
    public LedgerExpression<T, U, U> updateUpdateTime(LocalDateTime updateTime){
       return new LedgerExpression(this, $it ->  ((Ledger)$it).updateUpdateTime(updateTime));
    }

}