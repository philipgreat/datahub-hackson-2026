
package com.example.enterpriseerpsystem.opportunity;

import io.teaql.core.SmartList;
import io.teaql.core.value.Expression;
import io.teaql.core.value.SmartListExpression;
import java.util.function.Function;

public class OpportunityListExpression<T, E, U extends Opportunity> extends SmartListExpression<T, E, U> {
    public OpportunityListExpression(Expression<T, SmartList<U>> expression){
        super(expression);
    }

    public OpportunityListExpression(Expression<T, E> expression, Function<E, SmartList<U>> function){
        super(expression, function);
    }

    public OpportunityExpression<T, U, U> first() {
       return new OpportunityExpression(super.first());
    }

    public OpportunityExpression<T, U, U> get(int index) {
      return new OpportunityExpression(super.get(index));
    }
}