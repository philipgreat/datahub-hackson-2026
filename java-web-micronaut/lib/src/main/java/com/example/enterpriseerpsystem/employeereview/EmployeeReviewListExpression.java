
package com.example.enterpriseerpsystem.employeereview;

import io.teaql.core.SmartList;
import io.teaql.core.value.Expression;
import io.teaql.core.value.SmartListExpression;
import java.util.function.Function;

public class EmployeeReviewListExpression<T, E, U extends EmployeeReview> extends SmartListExpression<T, E, U> {
    public EmployeeReviewListExpression(Expression<T, SmartList<U>> expression){
        super(expression);
    }

    public EmployeeReviewListExpression(Expression<T, E> expression, Function<E, SmartList<U>> function){
        super(expression, function);
    }

    public EmployeeReviewExpression<T, U, U> first() {
       return new EmployeeReviewExpression(super.first());
    }

    public EmployeeReviewExpression<T, U, U> get(int index) {
      return new EmployeeReviewExpression(super.get(index));
    }
}