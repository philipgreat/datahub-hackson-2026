
package com.example.enterpriseerpsystem.contract;

import io.teaql.core.SmartList;
import io.teaql.core.value.Expression;
import io.teaql.core.value.SmartListExpression;
import java.util.function.Function;

public class ContractListExpression<T, E, U extends Contract> extends SmartListExpression<T, E, U> {
    public ContractListExpression(Expression<T, SmartList<U>> expression){
        super(expression);
    }

    public ContractListExpression(Expression<T, E> expression, Function<E, SmartList<U>> function){
        super(expression, function);
    }

    public ContractExpression<T, U, U> first() {
       return new ContractExpression(super.first());
    }

    public ContractExpression<T, U, U> get(int index) {
      return new ContractExpression(super.get(index));
    }
}