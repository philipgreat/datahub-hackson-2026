
package com.example.enterpriseerpsystem.promotion;

import io.teaql.core.SmartList;
import io.teaql.core.value.Expression;
import io.teaql.core.value.SmartListExpression;
import java.util.function.Function;

public class PromotionListExpression<T, E, U extends Promotion> extends SmartListExpression<T, E, U> {
    public PromotionListExpression(Expression<T, SmartList<U>> expression){
        super(expression);
    }

    public PromotionListExpression(Expression<T, E> expression, Function<E, SmartList<U>> function){
        super(expression, function);
    }

    public PromotionExpression<T, U, U> first() {
       return new PromotionExpression(super.first());
    }

    public PromotionExpression<T, U, U> get(int index) {
      return new PromotionExpression(super.get(index));
    }
}