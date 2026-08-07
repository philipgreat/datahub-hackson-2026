
package com.example.enterpriseerpsystem.department;

import io.teaql.core.SmartList;
import io.teaql.core.value.Expression;
import io.teaql.core.value.SmartListExpression;
import java.util.function.Function;

public class DepartmentListExpression<T, E, U extends Department> extends SmartListExpression<T, E, U> {
    public DepartmentListExpression(Expression<T, SmartList<U>> expression){
        super(expression);
    }

    public DepartmentListExpression(Expression<T, E> expression, Function<E, SmartList<U>> function){
        super(expression, function);
    }

    public DepartmentExpression<T, U, U> first() {
       return new DepartmentExpression(super.first());
    }

    public DepartmentExpression<T, U, U> get(int index) {
      return new DepartmentExpression(super.get(index));
    }
}