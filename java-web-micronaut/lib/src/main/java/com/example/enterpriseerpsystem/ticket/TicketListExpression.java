
package com.example.enterpriseerpsystem.ticket;

import io.teaql.core.SmartList;
import io.teaql.core.value.Expression;
import io.teaql.core.value.SmartListExpression;
import java.util.function.Function;

public class TicketListExpression<T, E, U extends Ticket> extends SmartListExpression<T, E, U> {
    public TicketListExpression(Expression<T, SmartList<U>> expression){
        super(expression);
    }

    public TicketListExpression(Expression<T, E> expression, Function<E, SmartList<U>> function){
        super(expression, function);
    }

    public TicketExpression<T, U, U> first() {
       return new TicketExpression(super.first());
    }

    public TicketExpression<T, U, U> get(int index) {
      return new TicketExpression(super.get(index));
    }
}