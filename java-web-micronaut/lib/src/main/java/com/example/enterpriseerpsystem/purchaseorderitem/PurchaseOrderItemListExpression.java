
package com.example.enterpriseerpsystem.purchaseorderitem;

import io.teaql.core.SmartList;
import io.teaql.core.value.Expression;
import io.teaql.core.value.SmartListExpression;
import java.util.function.Function;

public class PurchaseOrderItemListExpression<T, E, U extends PurchaseOrderItem> extends SmartListExpression<T, E, U> {
    public PurchaseOrderItemListExpression(Expression<T, SmartList<U>> expression){
        super(expression);
    }

    public PurchaseOrderItemListExpression(Expression<T, E> expression, Function<E, SmartList<U>> function){
        super(expression, function);
    }

    public PurchaseOrderItemExpression<T, U, U> first() {
       return new PurchaseOrderItemExpression(super.first());
    }

    public PurchaseOrderItemExpression<T, U, U> get(int index) {
      return new PurchaseOrderItemExpression(super.get(index));
    }
}