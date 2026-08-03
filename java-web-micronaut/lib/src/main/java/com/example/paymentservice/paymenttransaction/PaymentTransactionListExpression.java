
package com.example.paymentservice.paymenttransaction;

import io.teaql.core.SmartList;
import io.teaql.core.value.Expression;
import io.teaql.core.value.SmartListExpression;
import java.util.function.Function;

public class PaymentTransactionListExpression<T, E, U extends PaymentTransaction> extends SmartListExpression<T, E, U> {
    public PaymentTransactionListExpression(Expression<T, SmartList<U>> expression){
        super(expression);
    }

    public PaymentTransactionListExpression(Expression<T, E> expression, Function<E, SmartList<U>> function){
        super(expression, function);
    }

    public PaymentTransactionExpression<T, U, U> first() {
       return new PaymentTransactionExpression(super.first());
    }

    public PaymentTransactionExpression<T, U, U> get(int index) {
      return new PaymentTransactionExpression(super.get(index));
    }
}