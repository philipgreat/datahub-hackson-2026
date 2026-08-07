
package com.example.enterpriseerpsystem.campaign;

import io.teaql.core.SmartList;
import io.teaql.core.value.Expression;
import io.teaql.core.value.SmartListExpression;
import java.util.function.Function;

public class CampaignListExpression<T, E, U extends Campaign> extends SmartListExpression<T, E, U> {
    public CampaignListExpression(Expression<T, SmartList<U>> expression){
        super(expression);
    }

    public CampaignListExpression(Expression<T, E> expression, Function<E, SmartList<U>> function){
        super(expression, function);
    }

    public CampaignExpression<T, U, U> first() {
       return new CampaignExpression(super.first());
    }

    public CampaignExpression<T, U, U> get(int index) {
      return new CampaignExpression(super.get(index));
    }
}