
package com.example.enterpriseerpsystem.contact;

import io.teaql.core.SmartList;
import io.teaql.core.value.Expression;
import io.teaql.core.value.SmartListExpression;
import java.util.function.Function;

public class ContactListExpression<T, E, U extends Contact> extends SmartListExpression<T, E, U> {
    public ContactListExpression(Expression<T, SmartList<U>> expression){
        super(expression);
    }

    public ContactListExpression(Expression<T, E> expression, Function<E, SmartList<U>> function){
        super(expression, function);
    }

    public ContactExpression<T, U, U> first() {
       return new ContactExpression(super.first());
    }

    public ContactExpression<T, U, U> get(int index) {
      return new ContactExpression(super.get(index));
    }
}