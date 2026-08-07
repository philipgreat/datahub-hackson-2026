
package com.example.enterpriseerpsystem.shoppingcart;

import io.teaql.core.SmartList;
import io.teaql.core.value.Expression;
import io.teaql.core.value.SmartListExpression;
import java.util.function.Function;

public class ShoppingCartListExpression<T, E, U extends ShoppingCart> extends SmartListExpression<T, E, U> {
    public ShoppingCartListExpression(Expression<T, SmartList<U>> expression){
        super(expression);
    }

    public ShoppingCartListExpression(Expression<T, E> expression, Function<E, SmartList<U>> function){
        super(expression, function);
    }

    public ShoppingCartExpression<T, U, U> first() {
       return new ShoppingCartExpression(super.first());
    }

    public ShoppingCartExpression<T, U, U> get(int index) {
      return new ShoppingCartExpression(super.get(index));
    }
}