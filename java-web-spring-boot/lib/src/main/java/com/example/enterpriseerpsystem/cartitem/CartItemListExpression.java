
package com.example.enterpriseerpsystem.cartitem;

import io.teaql.core.SmartList;
import io.teaql.core.value.Expression;
import io.teaql.core.value.SmartListExpression;
import java.util.function.Function;

public class CartItemListExpression<T, E, U extends CartItem> extends SmartListExpression<T, E, U> {
    public CartItemListExpression(Expression<T, SmartList<U>> expression){
        super(expression);
    }

    public CartItemListExpression(Expression<T, E> expression, Function<E, SmartList<U>> function){
        super(expression, function);
    }

    public CartItemExpression<T, U, U> first() {
       return new CartItemExpression(super.first());
    }

    public CartItemExpression<T, U, U> get(int index) {
      return new CartItemExpression(super.get(index));
    }
}