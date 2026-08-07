
package com.example.enterpriseerpsystem.globalorder;

import io.teaql.core.SmartList;
import io.teaql.core.value.Expression;
import io.teaql.core.value.SmartListExpression;
import java.util.function.Function;

public class GlobalOrderListExpression<T, E, U extends GlobalOrder> extends SmartListExpression<T, E, U> {
    public GlobalOrderListExpression(Expression<T, SmartList<U>> expression){
        super(expression);
    }

    public GlobalOrderListExpression(Expression<T, E> expression, Function<E, SmartList<U>> function){
        super(expression, function);
    }

    public GlobalOrderExpression<T, U, U> first() {
       return new GlobalOrderExpression(super.first());
    }

    public GlobalOrderExpression<T, U, U> get(int index) {
      return new GlobalOrderExpression(super.get(index));
    }
}