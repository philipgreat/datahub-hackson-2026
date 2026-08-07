
package com.example.enterpriseerpsystem.refund;

import io.teaql.core.SmartList;
import io.teaql.core.value.Expression;
import io.teaql.core.value.SmartListExpression;
import java.util.function.Function;

public class RefundListExpression<T, E, U extends Refund> extends SmartListExpression<T, E, U> {
    public RefundListExpression(Expression<T, SmartList<U>> expression){
        super(expression);
    }

    public RefundListExpression(Expression<T, E> expression, Function<E, SmartList<U>> function){
        super(expression, function);
    }

    public RefundExpression<T, U, U> first() {
       return new RefundExpression(super.first());
    }

    public RefundExpression<T, U, U> get(int index) {
      return new RefundExpression(super.get(index));
    }
}