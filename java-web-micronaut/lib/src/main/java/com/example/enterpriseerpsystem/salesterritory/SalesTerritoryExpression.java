
package com.example.enterpriseerpsystem.salesterritory;

import io.teaql.core.UserContext;
import io.teaql.core.value.BaseEntityExpression;
import io.teaql.core.value.Expression;
import io.teaql.core.value.ExpressionAdaptor;
import java.time.LocalDateTime;
import java.util.function.Function;

public class SalesTerritoryExpression<T, E, U extends SalesTerritory> extends ExpressionAdaptor<T, E, U> implements BaseEntityExpression<T, U> {
    public SalesTerritoryExpression(Expression<T, U> expression){
        super(expression);
    }

    public SalesTerritoryExpression(Expression<T, E> expression, Function<E, U> function){
        super(expression, function);
    }

     public SalesTerritoryExpression<T, U, U> updateId(Long id){
        return new SalesTerritoryExpression(this, $it -> {((SalesTerritory)$it).__internalSet("id", id); return this;});
     }

     public SalesTerritoryExpression<T, U, U> save(UserContext userContext){
        return new SalesTerritoryExpression(this, $it -> ((SalesTerritory)$it).auditAs("Saved by Expression").save(userContext));
     }

     public SalesTerritoryExpression<T, U, U> save(String intent, UserContext userContext){
        return new SalesTerritoryExpression(this, $it -> ((SalesTerritory)$it).auditAs(intent).save(userContext));
     }

     public boolean isNull() {
        return resolve() == null;
     }


    public Expression<T, String> getName(){
       return apply(SalesTerritory::getName);
    }
    public SalesTerritoryExpression<T, U, U> updateName(String name){
       return new SalesTerritoryExpression(this, $it ->  ((SalesTerritory)$it).updateName(name));
    }

    public Expression<T, String> getManagerId(){
       return apply(SalesTerritory::getManagerId);
    }
    public SalesTerritoryExpression<T, U, U> updateManagerId(String managerId){
       return new SalesTerritoryExpression(this, $it ->  ((SalesTerritory)$it).updateManagerId(managerId));
    }

    public Expression<T, String> getRegion(){
       return apply(SalesTerritory::getRegion);
    }
    public SalesTerritoryExpression<T, U, U> updateRegion(String region){
       return new SalesTerritoryExpression(this, $it ->  ((SalesTerritory)$it).updateRegion(region));
    }

    public Expression<T, LocalDateTime> getCreateTime(){
       return apply(SalesTerritory::getCreateTime);
    }
    public SalesTerritoryExpression<T, U, U> updateCreateTime(LocalDateTime createTime){
       return new SalesTerritoryExpression(this, $it ->  ((SalesTerritory)$it).updateCreateTime(createTime));
    }

    public Expression<T, LocalDateTime> getUpdateTime(){
       return apply(SalesTerritory::getUpdateTime);
    }
    public SalesTerritoryExpression<T, U, U> updateUpdateTime(LocalDateTime updateTime){
       return new SalesTerritoryExpression(this, $it ->  ((SalesTerritory)$it).updateUpdateTime(updateTime));
    }

}