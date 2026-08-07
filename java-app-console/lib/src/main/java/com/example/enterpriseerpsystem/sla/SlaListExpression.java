
package com.example.enterpriseerpsystem.sla;

import io.teaql.core.SmartList;
import io.teaql.core.value.Expression;
import io.teaql.core.value.SmartListExpression;
import java.util.function.Function;

public class SlaListExpression<T, E, U extends Sla> extends SmartListExpression<T, E, U> {
    public SlaListExpression(Expression<T, SmartList<U>> expression){
        super(expression);
    }

    public SlaListExpression(Expression<T, E> expression, Function<E, SmartList<U>> function){
        super(expression, function);
    }

    public SlaExpression<T, U, U> first() {
       return new SlaExpression(super.first());
    }

    public SlaExpression<T, U, U> get(int index) {
      return new SlaExpression(super.get(index));
    }
}