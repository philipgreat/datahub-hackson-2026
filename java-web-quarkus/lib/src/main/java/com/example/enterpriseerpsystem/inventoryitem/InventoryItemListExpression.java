
package com.example.enterpriseerpsystem.inventoryitem;

import io.teaql.core.SmartList;
import io.teaql.core.value.Expression;
import io.teaql.core.value.SmartListExpression;
import java.util.function.Function;

public class InventoryItemListExpression<T, E, U extends InventoryItem> extends SmartListExpression<T, E, U> {
    public InventoryItemListExpression(Expression<T, SmartList<U>> expression){
        super(expression);
    }

    public InventoryItemListExpression(Expression<T, E> expression, Function<E, SmartList<U>> function){
        super(expression, function);
    }

    public InventoryItemExpression<T, U, U> first() {
       return new InventoryItemExpression(super.first());
    }

    public InventoryItemExpression<T, U, U> get(int index) {
      return new InventoryItemExpression(super.get(index));
    }
}