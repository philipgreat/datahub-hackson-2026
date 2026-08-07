
package com.example.enterpriseerpsystem.ticketcomment;

import io.teaql.core.SmartList;
import io.teaql.core.value.Expression;
import io.teaql.core.value.SmartListExpression;
import java.util.function.Function;

public class TicketCommentListExpression<T, E, U extends TicketComment> extends SmartListExpression<T, E, U> {
    public TicketCommentListExpression(Expression<T, SmartList<U>> expression){
        super(expression);
    }

    public TicketCommentListExpression(Expression<T, E> expression, Function<E, SmartList<U>> function){
        super(expression, function);
    }

    public TicketCommentExpression<T, U, U> first() {
       return new TicketCommentExpression(super.first());
    }

    public TicketCommentExpression<T, U, U> get(int index) {
      return new TicketCommentExpression(super.get(index));
    }
}