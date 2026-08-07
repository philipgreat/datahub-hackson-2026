
package com.example.enterpriseerpsystem.quote;

import io.teaql.core.SmartList;
import io.teaql.core.value.Expression;
import io.teaql.core.value.SmartListExpression;
import java.util.function.Function;

public class QuoteListExpression<T, E, U extends Quote> extends SmartListExpression<T, E, U> {
    public QuoteListExpression(Expression<T, SmartList<U>> expression){
        super(expression);
    }

    public QuoteListExpression(Expression<T, E> expression, Function<E, SmartList<U>> function){
        super(expression, function);
    }

    public QuoteExpression<T, U, U> first() {
       return new QuoteExpression(super.first());
    }

    public QuoteExpression<T, U, U> get(int index) {
      return new QuoteExpression(super.get(index));
    }
}