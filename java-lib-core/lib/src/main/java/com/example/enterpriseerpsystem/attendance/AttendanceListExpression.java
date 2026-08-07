
package com.example.enterpriseerpsystem.attendance;

import io.teaql.core.SmartList;
import io.teaql.core.value.Expression;
import io.teaql.core.value.SmartListExpression;
import java.util.function.Function;

public class AttendanceListExpression<T, E, U extends Attendance> extends SmartListExpression<T, E, U> {
    public AttendanceListExpression(Expression<T, SmartList<U>> expression){
        super(expression);
    }

    public AttendanceListExpression(Expression<T, E> expression, Function<E, SmartList<U>> function){
        super(expression, function);
    }

    public AttendanceExpression<T, U, U> first() {
       return new AttendanceExpression(super.first());
    }

    public AttendanceExpression<T, U, U> get(int index) {
      return new AttendanceExpression(super.get(index));
    }
}