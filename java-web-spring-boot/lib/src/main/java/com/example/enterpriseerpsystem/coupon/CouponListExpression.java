
package com.example.enterpriseerpsystem.coupon;

import io.teaql.core.SmartList;
import io.teaql.core.value.Expression;
import io.teaql.core.value.SmartListExpression;
import java.util.function.Function;

public class CouponListExpression<T, E, U extends Coupon> extends SmartListExpression<T, E, U> {
    public CouponListExpression(Expression<T, SmartList<U>> expression){
        super(expression);
    }

    public CouponListExpression(Expression<T, E> expression, Function<E, SmartList<U>> function){
        super(expression, function);
    }

    public CouponExpression<T, U, U> first() {
       return new CouponExpression(super.first());
    }

    public CouponExpression<T, U, U> get(int index) {
      return new CouponExpression(super.get(index));
    }
}