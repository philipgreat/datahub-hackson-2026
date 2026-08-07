
package com.example.enterpriseerpsystem.position;

import io.teaql.core.SmartList;
import io.teaql.core.value.Expression;
import io.teaql.core.value.SmartListExpression;
import java.util.function.Function;

public class PositionListExpression<T, E, U extends Position> extends SmartListExpression<T, E, U> {
    public PositionListExpression(Expression<T, SmartList<U>> expression){
        super(expression);
    }

    public PositionListExpression(Expression<T, E> expression, Function<E, SmartList<U>> function){
        super(expression, function);
    }

    public PositionExpression<T, U, U> first() {
       return new PositionExpression(super.first());
    }

    public PositionExpression<T, U, U> get(int index) {
      return new PositionExpression(super.get(index));
    }
}