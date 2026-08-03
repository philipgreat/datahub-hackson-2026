
package com.example.paymentservice.paymentmethod;

import io.teaql.core.SmartList;
import io.teaql.core.value.Expression;
import io.teaql.core.value.SmartListExpression;
import java.util.function.Function;

public class PaymentMethodListExpression<T, E, U extends PaymentMethod> extends SmartListExpression<T, E, U> {
    public PaymentMethodListExpression(Expression<T, SmartList<U>> expression){
        super(expression);
    }

    public PaymentMethodListExpression(Expression<T, E> expression, Function<E, SmartList<U>> function){
        super(expression, function);
    }

    public PaymentMethodExpression<T, U, U> first() {
       return new PaymentMethodExpression(super.first());
    }

    public PaymentMethodExpression<T, U, U> get(int index) {
      return new PaymentMethodExpression(super.get(index));
    }
}