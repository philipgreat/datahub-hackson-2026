
package com.example.enterpriseerpsystem.ledger;

import io.teaql.core.SmartList;
import io.teaql.core.value.Expression;
import io.teaql.core.value.SmartListExpression;
import java.util.function.Function;

public class LedgerListExpression<T, E, U extends Ledger> extends SmartListExpression<T, E, U> {
    public LedgerListExpression(Expression<T, SmartList<U>> expression){
        super(expression);
    }

    public LedgerListExpression(Expression<T, E> expression, Function<E, SmartList<U>> function){
        super(expression, function);
    }

    public LedgerExpression<T, U, U> first() {
       return new LedgerExpression(super.first());
    }

    public LedgerExpression<T, U, U> get(int index) {
      return new LedgerExpression(super.get(index));
    }
}