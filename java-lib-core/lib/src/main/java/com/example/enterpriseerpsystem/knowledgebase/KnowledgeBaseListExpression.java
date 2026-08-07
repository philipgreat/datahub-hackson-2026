
package com.example.enterpriseerpsystem.knowledgebase;

import io.teaql.core.SmartList;
import io.teaql.core.value.Expression;
import io.teaql.core.value.SmartListExpression;
import java.util.function.Function;

public class KnowledgeBaseListExpression<T, E, U extends KnowledgeBase> extends SmartListExpression<T, E, U> {
    public KnowledgeBaseListExpression(Expression<T, SmartList<U>> expression){
        super(expression);
    }

    public KnowledgeBaseListExpression(Expression<T, E> expression, Function<E, SmartList<U>> function){
        super(expression, function);
    }

    public KnowledgeBaseExpression<T, U, U> first() {
       return new KnowledgeBaseExpression(super.first());
    }

    public KnowledgeBaseExpression<T, U, U> get(int index) {
      return new KnowledgeBaseExpression(super.get(index));
    }
}