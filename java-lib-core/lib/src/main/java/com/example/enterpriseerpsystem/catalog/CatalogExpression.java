
package com.example.enterpriseerpsystem.catalog;

import io.teaql.core.UserContext;
import io.teaql.core.value.BaseEntityExpression;
import io.teaql.core.value.Expression;
import io.teaql.core.value.ExpressionAdaptor;
import java.time.LocalDateTime;
import java.util.function.Function;

public class CatalogExpression<T, E, U extends Catalog> extends ExpressionAdaptor<T, E, U> implements BaseEntityExpression<T, U> {
    public CatalogExpression(Expression<T, U> expression){
        super(expression);
    }

    public CatalogExpression(Expression<T, E> expression, Function<E, U> function){
        super(expression, function);
    }

     public CatalogExpression<T, U, U> updateId(Long id){
        return new CatalogExpression(this, $it -> {((Catalog)$it).__internalSet("id", id); return this;});
     }

     public CatalogExpression<T, U, U> save(UserContext userContext){
        return new CatalogExpression(this, $it -> ((Catalog)$it).auditAs("Saved by Expression").save(userContext));
     }

     public CatalogExpression<T, U, U> save(String intent, UserContext userContext){
        return new CatalogExpression(this, $it -> ((Catalog)$it).auditAs(intent).save(userContext));
     }

     public boolean isNull() {
        return resolve() == null;
     }


    public Expression<T, String> getName(){
       return apply(Catalog::getName);
    }
    public CatalogExpression<T, U, U> updateName(String name){
       return new CatalogExpression(this, $it ->  ((Catalog)$it).updateName(name));
    }

    public Expression<T, String> getSeason(){
       return apply(Catalog::getSeason);
    }
    public CatalogExpression<T, U, U> updateSeason(String season){
       return new CatalogExpression(this, $it ->  ((Catalog)$it).updateSeason(season));
    }

    public Expression<T, LocalDateTime> getValidFrom(){
       return apply(Catalog::getValidFrom);
    }
    public CatalogExpression<T, U, U> updateValidFrom(LocalDateTime validFrom){
       return new CatalogExpression(this, $it ->  ((Catalog)$it).updateValidFrom(validFrom));
    }

    public Expression<T, LocalDateTime> getValidTo(){
       return apply(Catalog::getValidTo);
    }
    public CatalogExpression<T, U, U> updateValidTo(LocalDateTime validTo){
       return new CatalogExpression(this, $it ->  ((Catalog)$it).updateValidTo(validTo));
    }

    public Expression<T, LocalDateTime> getCreateTime(){
       return apply(Catalog::getCreateTime);
    }
    public CatalogExpression<T, U, U> updateCreateTime(LocalDateTime createTime){
       return new CatalogExpression(this, $it ->  ((Catalog)$it).updateCreateTime(createTime));
    }

    public Expression<T, LocalDateTime> getUpdateTime(){
       return apply(Catalog::getUpdateTime);
    }
    public CatalogExpression<T, U, U> updateUpdateTime(LocalDateTime updateTime){
       return new CatalogExpression(this, $it ->  ((Catalog)$it).updateUpdateTime(updateTime));
    }

}