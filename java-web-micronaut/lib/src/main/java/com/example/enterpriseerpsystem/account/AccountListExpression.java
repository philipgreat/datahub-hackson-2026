
package com.example.enterpriseerpsystem.account;

import io.teaql.core.SmartList;
import io.teaql.core.value.Expression;
import io.teaql.core.value.SmartListExpression;
import java.util.function.Function;

public class AccountListExpression<T, E, U extends Account> extends SmartListExpression<T, E, U> {
    public AccountListExpression(Expression<T, SmartList<U>> expression){
        super(expression);
    }

    public AccountListExpression(Expression<T, E> expression, Function<E, SmartList<U>> function){
        super(expression, function);
    }

    public AccountExpression<T, U, U> first() {
       return new AccountExpression(super.first());
    }

    public AccountExpression<T, U, U> get(int index) {
      return new AccountExpression(super.get(index));
    }
}