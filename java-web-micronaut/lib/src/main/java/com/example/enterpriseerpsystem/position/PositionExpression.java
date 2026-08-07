
package com.example.enterpriseerpsystem.position;

import io.teaql.core.UserContext;
import io.teaql.core.value.BaseEntityExpression;
import io.teaql.core.value.Expression;
import io.teaql.core.value.ExpressionAdaptor;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.function.Function;

public class PositionExpression<T, E, U extends Position> extends ExpressionAdaptor<T, E, U> implements BaseEntityExpression<T, U> {
    public PositionExpression(Expression<T, U> expression){
        super(expression);
    }

    public PositionExpression(Expression<T, E> expression, Function<E, U> function){
        super(expression, function);
    }

     public PositionExpression<T, U, U> updateId(Long id){
        return new PositionExpression(this, $it -> {((Position)$it).__internalSet("id", id); return this;});
     }

     public PositionExpression<T, U, U> save(UserContext userContext){
        return new PositionExpression(this, $it -> ((Position)$it).auditAs("Saved by Expression").save(userContext));
     }

     public PositionExpression<T, U, U> save(String intent, UserContext userContext){
        return new PositionExpression(this, $it -> ((Position)$it).auditAs(intent).save(userContext));
     }

     public boolean isNull() {
        return resolve() == null;
     }


    public Expression<T, BigDecimal> getMaxSalary(){
       return apply(Position::getMaxSalary);
    }
    public PositionExpression<T, U, U> updateMaxSalary(BigDecimal maxSalary){
       return new PositionExpression(this, $it ->  ((Position)$it).updateMaxSalary(maxSalary));
    }

    public Expression<T, BigDecimal> getMinSalary(){
       return apply(Position::getMinSalary);
    }
    public PositionExpression<T, U, U> updateMinSalary(BigDecimal minSalary){
       return new PositionExpression(this, $it ->  ((Position)$it).updateMinSalary(minSalary));
    }

    public Expression<T, String> getTitle(){
       return apply(Position::getTitle);
    }
    public PositionExpression<T, U, U> updateTitle(String title){
       return new PositionExpression(this, $it ->  ((Position)$it).updateTitle(title));
    }

    public Expression<T, LocalDateTime> getCreateTime(){
       return apply(Position::getCreateTime);
    }
    public PositionExpression<T, U, U> updateCreateTime(LocalDateTime createTime){
       return new PositionExpression(this, $it ->  ((Position)$it).updateCreateTime(createTime));
    }

    public Expression<T, LocalDateTime> getUpdateTime(){
       return apply(Position::getUpdateTime);
    }
    public PositionExpression<T, U, U> updateUpdateTime(LocalDateTime updateTime){
       return new PositionExpression(this, $it ->  ((Position)$it).updateUpdateTime(updateTime));
    }

}