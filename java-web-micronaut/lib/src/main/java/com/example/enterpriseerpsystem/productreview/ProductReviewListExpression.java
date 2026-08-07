
package com.example.enterpriseerpsystem.productreview;

import io.teaql.core.SmartList;
import io.teaql.core.value.Expression;
import io.teaql.core.value.SmartListExpression;
import java.util.function.Function;

public class ProductReviewListExpression<T, E, U extends ProductReview> extends SmartListExpression<T, E, U> {
    public ProductReviewListExpression(Expression<T, SmartList<U>> expression){
        super(expression);
    }

    public ProductReviewListExpression(Expression<T, E> expression, Function<E, SmartList<U>> function){
        super(expression, function);
    }

    public ProductReviewExpression<T, U, U> first() {
       return new ProductReviewExpression(super.first());
    }

    public ProductReviewExpression<T, U, U> get(int index) {
      return new ProductReviewExpression(super.get(index));
    }
}