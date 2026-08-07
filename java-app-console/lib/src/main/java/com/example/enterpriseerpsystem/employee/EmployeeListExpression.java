
package com.example.enterpriseerpsystem.employee;

import io.teaql.core.SmartList;
import io.teaql.core.value.Expression;
import io.teaql.core.value.SmartListExpression;
import java.util.function.Function;

public class EmployeeListExpression<T, E, U extends Employee> extends SmartListExpression<T, E, U> {
    public EmployeeListExpression(Expression<T, SmartList<U>> expression){
        super(expression);
    }

    public EmployeeListExpression(Expression<T, E> expression, Function<E, SmartList<U>> function){
        super(expression, function);
    }

    public EmployeeExpression<T, U, U> first() {
       return new EmployeeExpression(super.first());
    }

    public EmployeeExpression<T, U, U> get(int index) {
      return new EmployeeExpression(super.get(index));
    }
}