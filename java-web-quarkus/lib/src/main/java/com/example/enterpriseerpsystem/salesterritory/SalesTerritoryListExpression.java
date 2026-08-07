
package com.example.enterpriseerpsystem.salesterritory;

import io.teaql.core.SmartList;
import io.teaql.core.value.Expression;
import io.teaql.core.value.SmartListExpression;
import java.util.function.Function;

public class SalesTerritoryListExpression<T, E, U extends SalesTerritory> extends SmartListExpression<T, E, U> {
    public SalesTerritoryListExpression(Expression<T, SmartList<U>> expression){
        super(expression);
    }

    public SalesTerritoryListExpression(Expression<T, E> expression, Function<E, SmartList<U>> function){
        super(expression, function);
    }

    public SalesTerritoryExpression<T, U, U> first() {
       return new SalesTerritoryExpression(super.first());
    }

    public SalesTerritoryExpression<T, U, U> get(int index) {
      return new SalesTerritoryExpression(super.get(index));
    }
}