
package com.example.enterpriseerpsystem.lead;

import io.teaql.core.SmartList;
import io.teaql.core.value.Expression;
import io.teaql.core.value.SmartListExpression;
import java.util.function.Function;

public class LeadListExpression<T, E, U extends Lead> extends SmartListExpression<T, E, U> {
    public LeadListExpression(Expression<T, SmartList<U>> expression){
        super(expression);
    }

    public LeadListExpression(Expression<T, E> expression, Function<E, SmartList<U>> function){
        super(expression, function);
    }

    public LeadExpression<T, U, U> first() {
       return new LeadExpression(super.first());
    }

    public LeadExpression<T, U, U> get(int index) {
      return new LeadExpression(super.get(index));
    }
}