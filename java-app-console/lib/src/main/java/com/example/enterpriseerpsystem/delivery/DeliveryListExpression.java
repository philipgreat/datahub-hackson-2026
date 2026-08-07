
package com.example.enterpriseerpsystem.delivery;

import io.teaql.core.SmartList;
import io.teaql.core.value.Expression;
import io.teaql.core.value.SmartListExpression;
import java.util.function.Function;

public class DeliveryListExpression<T, E, U extends Delivery> extends SmartListExpression<T, E, U> {
    public DeliveryListExpression(Expression<T, SmartList<U>> expression){
        super(expression);
    }

    public DeliveryListExpression(Expression<T, E> expression, Function<E, SmartList<U>> function){
        super(expression, function);
    }

    public DeliveryExpression<T, U, U> first() {
       return new DeliveryExpression(super.first());
    }

    public DeliveryExpression<T, U, U> get(int index) {
      return new DeliveryExpression(super.get(index));
    }
}