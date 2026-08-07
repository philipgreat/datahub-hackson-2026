
package com.example.enterpriseerpsystem.sla;

import io.teaql.core.UserContext;
import io.teaql.core.value.BaseEntityExpression;
import io.teaql.core.value.Expression;
import io.teaql.core.value.ExpressionAdaptor;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.function.Function;

public class SlaExpression<T, E, U extends Sla> extends ExpressionAdaptor<T, E, U> implements BaseEntityExpression<T, U> {
    public SlaExpression(Expression<T, U> expression){
        super(expression);
    }

    public SlaExpression(Expression<T, E> expression, Function<E, U> function){
        super(expression, function);
    }

     public SlaExpression<T, U, U> updateId(Long id){
        return new SlaExpression(this, $it -> {((Sla)$it).__internalSet("id", id); return this;});
     }

     public SlaExpression<T, U, U> save(UserContext userContext){
        return new SlaExpression(this, $it -> ((Sla)$it).auditAs("Saved by Expression").save(userContext));
     }

     public SlaExpression<T, U, U> save(String intent, UserContext userContext){
        return new SlaExpression(this, $it -> ((Sla)$it).auditAs(intent).save(userContext));
     }

     public boolean isNull() {
        return resolve() == null;
     }


    public Expression<T, Boolean> isIsActive(){
       return apply(Sla::isIsActive);
    }
    public SlaExpression<T, U, U> updateIsActive(Boolean isActive){
       return new SlaExpression(this, $it ->  ((Sla)$it).updateIsActive(isActive));
    }

    public Expression<T, String> getPriorityLevel(){
       return apply(Sla::getPriorityLevel);
    }
    public SlaExpression<T, U, U> updatePriorityLevel(String priorityLevel){
       return new SlaExpression(this, $it ->  ((Sla)$it).updatePriorityLevel(priorityLevel));
    }

    public Expression<T, BigDecimal> getResolutionHours(){
       return apply(Sla::getResolutionHours);
    }
    public SlaExpression<T, U, U> updateResolutionHours(BigDecimal resolutionHours){
       return new SlaExpression(this, $it ->  ((Sla)$it).updateResolutionHours(resolutionHours));
    }

    public Expression<T, LocalDateTime> getCreateTime(){
       return apply(Sla::getCreateTime);
    }
    public SlaExpression<T, U, U> updateCreateTime(LocalDateTime createTime){
       return new SlaExpression(this, $it ->  ((Sla)$it).updateCreateTime(createTime));
    }

    public Expression<T, LocalDateTime> getUpdateTime(){
       return apply(Sla::getUpdateTime);
    }
    public SlaExpression<T, U, U> updateUpdateTime(LocalDateTime updateTime){
       return new SlaExpression(this, $it ->  ((Sla)$it).updateUpdateTime(updateTime));
    }

}