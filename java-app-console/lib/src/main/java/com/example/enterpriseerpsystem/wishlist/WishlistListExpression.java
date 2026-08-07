
package com.example.enterpriseerpsystem.wishlist;

import io.teaql.core.SmartList;
import io.teaql.core.value.Expression;
import io.teaql.core.value.SmartListExpression;
import java.util.function.Function;

public class WishlistListExpression<T, E, U extends Wishlist> extends SmartListExpression<T, E, U> {
    public WishlistListExpression(Expression<T, SmartList<U>> expression){
        super(expression);
    }

    public WishlistListExpression(Expression<T, E> expression, Function<E, SmartList<U>> function){
        super(expression, function);
    }

    public WishlistExpression<T, U, U> first() {
       return new WishlistExpression(super.first());
    }

    public WishlistExpression<T, U, U> get(int index) {
      return new WishlistExpression(super.get(index));
    }
}