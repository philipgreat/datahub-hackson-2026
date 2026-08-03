
package com.example.paymentservice.paymentaccount;

import io.teaql.core.SmartList;
import io.teaql.core.value.Expression;
import io.teaql.core.value.SmartListExpression;
import java.util.function.Function;

public class PaymentAccountListExpression<T, E, U extends PaymentAccount> extends SmartListExpression<T, E, U> {
    public PaymentAccountListExpression(Expression<T, SmartList<U>> expression){
        super(expression);
    }

    public PaymentAccountListExpression(Expression<T, E> expression, Function<E, SmartList<U>> function){
        super(expression, function);
    }

    public PaymentAccountExpression<T, U, U> first() {
       return new PaymentAccountExpression(super.first());
    }

    public PaymentAccountExpression<T, U, U> get(int index) {
      return new PaymentAccountExpression(super.get(index));
    }
}