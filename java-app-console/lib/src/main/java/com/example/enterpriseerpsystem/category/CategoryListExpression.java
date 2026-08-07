
package com.example.enterpriseerpsystem.category;

import io.teaql.core.SmartList;
import io.teaql.core.value.Expression;
import io.teaql.core.value.SmartListExpression;
import java.util.function.Function;

public class CategoryListExpression<T, E, U extends Category> extends SmartListExpression<T, E, U> {
    public CategoryListExpression(Expression<T, SmartList<U>> expression){
        super(expression);
    }

    public CategoryListExpression(Expression<T, E> expression, Function<E, SmartList<U>> function){
        super(expression, function);
    }

    public CategoryExpression<T, U, U> first() {
       return new CategoryExpression(super.first());
    }

    public CategoryExpression<T, U, U> get(int index) {
      return new CategoryExpression(super.get(index));
    }
}