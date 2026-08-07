
package com.example.enterpriseerpsystem.leaverequest;

import io.teaql.core.SmartList;
import io.teaql.core.value.Expression;
import io.teaql.core.value.SmartListExpression;
import java.util.function.Function;

public class LeaveRequestListExpression<T, E, U extends LeaveRequest> extends SmartListExpression<T, E, U> {
    public LeaveRequestListExpression(Expression<T, SmartList<U>> expression){
        super(expression);
    }

    public LeaveRequestListExpression(Expression<T, E> expression, Function<E, SmartList<U>> function){
        super(expression, function);
    }

    public LeaveRequestExpression<T, U, U> first() {
       return new LeaveRequestExpression(super.first());
    }

    public LeaveRequestExpression<T, U, U> get(int index) {
      return new LeaveRequestExpression(super.get(index));
    }
}