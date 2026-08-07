
package com.example.enterpriseerpsystem.expense;

import io.teaql.core.SmartList;
import io.teaql.core.value.Expression;
import io.teaql.core.value.SmartListExpression;
import java.util.function.Function;

public class ExpenseListExpression<T, E, U extends Expense> extends SmartListExpression<T, E, U> {
    public ExpenseListExpression(Expression<T, SmartList<U>> expression){
        super(expression);
    }

    public ExpenseListExpression(Expression<T, E> expression, Function<E, SmartList<U>> function){
        super(expression, function);
    }

    public ExpenseExpression<T, U, U> first() {
       return new ExpenseExpression(super.first());
    }

    public ExpenseExpression<T, U, U> get(int index) {
      return new ExpenseExpression(super.get(index));
    }
}