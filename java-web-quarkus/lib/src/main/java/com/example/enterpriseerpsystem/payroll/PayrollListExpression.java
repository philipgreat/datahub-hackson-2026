
package com.example.enterpriseerpsystem.payroll;

import io.teaql.core.SmartList;
import io.teaql.core.value.Expression;
import io.teaql.core.value.SmartListExpression;
import java.util.function.Function;

public class PayrollListExpression<T, E, U extends Payroll> extends SmartListExpression<T, E, U> {
    public PayrollListExpression(Expression<T, SmartList<U>> expression){
        super(expression);
    }

    public PayrollListExpression(Expression<T, E> expression, Function<E, SmartList<U>> function){
        super(expression, function);
    }

    public PayrollExpression<T, U, U> first() {
       return new PayrollExpression(super.first());
    }

    public PayrollExpression<T, U, U> get(int index) {
      return new PayrollExpression(super.get(index));
    }
}