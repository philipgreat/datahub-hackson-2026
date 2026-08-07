
package com.example.enterpriseerpsystem.taxrate;

import io.teaql.core.SmartList;
import io.teaql.core.value.Expression;
import io.teaql.core.value.SmartListExpression;
import java.util.function.Function;

public class TaxRateListExpression<T, E, U extends TaxRate> extends SmartListExpression<T, E, U> {
    public TaxRateListExpression(Expression<T, SmartList<U>> expression){
        super(expression);
    }

    public TaxRateListExpression(Expression<T, E> expression, Function<E, SmartList<U>> function){
        super(expression, function);
    }

    public TaxRateExpression<T, U, U> first() {
       return new TaxRateExpression(super.first());
    }

    public TaxRateExpression<T, U, U> get(int index) {
      return new TaxRateExpression(super.get(index));
    }
}