
package com.example.enterpriseerpsystem.returnrequest;

import io.teaql.core.SmartList;
import io.teaql.core.value.Expression;
import io.teaql.core.value.SmartListExpression;
import java.util.function.Function;

public class ReturnRequestListExpression<T, E, U extends ReturnRequest> extends SmartListExpression<T, E, U> {
    public ReturnRequestListExpression(Expression<T, SmartList<U>> expression){
        super(expression);
    }

    public ReturnRequestListExpression(Expression<T, E> expression, Function<E, SmartList<U>> function){
        super(expression, function);
    }

    public ReturnRequestExpression<T, U, U> first() {
       return new ReturnRequestExpression(super.first());
    }

    public ReturnRequestExpression<T, U, U> get(int index) {
      return new ReturnRequestExpression(super.get(index));
    }
}