
package com.example.enterpriseerpsystem.supportagent;

import io.teaql.core.SmartList;
import io.teaql.core.value.Expression;
import io.teaql.core.value.SmartListExpression;
import java.util.function.Function;

public class SupportAgentListExpression<T, E, U extends SupportAgent> extends SmartListExpression<T, E, U> {
    public SupportAgentListExpression(Expression<T, SmartList<U>> expression){
        super(expression);
    }

    public SupportAgentListExpression(Expression<T, E> expression, Function<E, SmartList<U>> function){
        super(expression, function);
    }

    public SupportAgentExpression<T, U, U> first() {
       return new SupportAgentExpression(super.first());
    }

    public SupportAgentExpression<T, U, U> get(int index) {
      return new SupportAgentExpression(super.get(index));
    }
}