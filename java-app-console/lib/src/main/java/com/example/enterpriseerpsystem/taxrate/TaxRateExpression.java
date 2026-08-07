
package com.example.enterpriseerpsystem.taxrate;

import io.teaql.core.UserContext;
import io.teaql.core.value.BaseEntityExpression;
import io.teaql.core.value.Expression;
import io.teaql.core.value.ExpressionAdaptor;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.function.Function;

public class TaxRateExpression<T, E, U extends TaxRate> extends ExpressionAdaptor<T, E, U> implements BaseEntityExpression<T, U> {
    public TaxRateExpression(Expression<T, U> expression){
        super(expression);
    }

    public TaxRateExpression(Expression<T, E> expression, Function<E, U> function){
        super(expression, function);
    }

     public TaxRateExpression<T, U, U> updateId(Long id){
        return new TaxRateExpression(this, $it -> {((TaxRate)$it).__internalSet("id", id); return this;});
     }

     public TaxRateExpression<T, U, U> save(UserContext userContext){
        return new TaxRateExpression(this, $it -> ((TaxRate)$it).auditAs("Saved by Expression").save(userContext));
     }

     public TaxRateExpression<T, U, U> save(String intent, UserContext userContext){
        return new TaxRateExpression(this, $it -> ((TaxRate)$it).auditAs(intent).save(userContext));
     }

     public boolean isNull() {
        return resolve() == null;
     }


    public Expression<T, Boolean> isIsActive(){
       return apply(TaxRate::isIsActive);
    }
    public TaxRateExpression<T, U, U> updateIsActive(Boolean isActive){
       return new TaxRateExpression(this, $it ->  ((TaxRate)$it).updateIsActive(isActive));
    }

    public Expression<T, BigDecimal> getRate(){
       return apply(TaxRate::getRate);
    }
    public TaxRateExpression<T, U, U> updateRate(BigDecimal rate){
       return new TaxRateExpression(this, $it ->  ((TaxRate)$it).updateRate(rate));
    }

    public Expression<T, String> getRegion(){
       return apply(TaxRate::getRegion);
    }
    public TaxRateExpression<T, U, U> updateRegion(String region){
       return new TaxRateExpression(this, $it ->  ((TaxRate)$it).updateRegion(region));
    }

    public Expression<T, LocalDateTime> getCreateTime(){
       return apply(TaxRate::getCreateTime);
    }
    public TaxRateExpression<T, U, U> updateCreateTime(LocalDateTime createTime){
       return new TaxRateExpression(this, $it ->  ((TaxRate)$it).updateCreateTime(createTime));
    }

    public Expression<T, LocalDateTime> getUpdateTime(){
       return apply(TaxRate::getUpdateTime);
    }
    public TaxRateExpression<T, U, U> updateUpdateTime(LocalDateTime updateTime){
       return new TaxRateExpression(this, $it ->  ((TaxRate)$it).updateUpdateTime(updateTime));
    }

}