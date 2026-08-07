
package com.example.enterpriseerpsystem.transaction;

import io.teaql.core.SmartList;
import io.teaql.core.value.Expression;
import io.teaql.core.value.SmartListExpression;
import java.util.function.Function;

public class TransactionListExpression<T, E, U extends Transaction> extends SmartListExpression<T, E, U> {
    public TransactionListExpression(Expression<T, SmartList<U>> expression){
        super(expression);
    }

    public TransactionListExpression(Expression<T, E> expression, Function<E, SmartList<U>> function){
        super(expression, function);
    }

    public TransactionExpression<T, U, U> first() {
       return new TransactionExpression(super.first());
    }

    public TransactionExpression<T, U, U> get(int index) {
      return new TransactionExpression(super.get(index));
    }
}