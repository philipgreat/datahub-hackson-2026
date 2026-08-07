
package com.example.enterpriseerpsystem.benefit;

import io.teaql.core.SmartList;
import io.teaql.core.value.Expression;
import io.teaql.core.value.SmartListExpression;
import java.util.function.Function;

public class BenefitListExpression<T, E, U extends Benefit> extends SmartListExpression<T, E, U> {
    public BenefitListExpression(Expression<T, SmartList<U>> expression){
        super(expression);
    }

    public BenefitListExpression(Expression<T, E> expression, Function<E, SmartList<U>> function){
        super(expression, function);
    }

    public BenefitExpression<T, U, U> first() {
       return new BenefitExpression(super.first());
    }

    public BenefitExpression<T, U, U> get(int index) {
      return new BenefitExpression(super.get(index));
    }
}