
package com.example.enterpriseerpsystem.campaign;

import io.teaql.core.UserContext;
import io.teaql.core.value.BaseEntityExpression;
import io.teaql.core.value.Expression;
import io.teaql.core.value.ExpressionAdaptor;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.function.Function;

public class CampaignExpression<T, E, U extends Campaign> extends ExpressionAdaptor<T, E, U> implements BaseEntityExpression<T, U> {
    public CampaignExpression(Expression<T, U> expression){
        super(expression);
    }

    public CampaignExpression(Expression<T, E> expression, Function<E, U> function){
        super(expression, function);
    }

     public CampaignExpression<T, U, U> updateId(Long id){
        return new CampaignExpression(this, $it -> {((Campaign)$it).__internalSet("id", id); return this;});
     }

     public CampaignExpression<T, U, U> save(UserContext userContext){
        return new CampaignExpression(this, $it -> ((Campaign)$it).auditAs("Saved by Expression").save(userContext));
     }

     public CampaignExpression<T, U, U> save(String intent, UserContext userContext){
        return new CampaignExpression(this, $it -> ((Campaign)$it).auditAs(intent).save(userContext));
     }

     public boolean isNull() {
        return resolve() == null;
     }


    public Expression<T, String> getName(){
       return apply(Campaign::getName);
    }
    public CampaignExpression<T, U, U> updateName(String name){
       return new CampaignExpression(this, $it ->  ((Campaign)$it).updateName(name));
    }

    public Expression<T, BigDecimal> getBudget(){
       return apply(Campaign::getBudget);
    }
    public CampaignExpression<T, U, U> updateBudget(BigDecimal budget){
       return new CampaignExpression(this, $it ->  ((Campaign)$it).updateBudget(budget));
    }

    public Expression<T, LocalDateTime> getEndDate(){
       return apply(Campaign::getEndDate);
    }
    public CampaignExpression<T, U, U> updateEndDate(LocalDateTime endDate){
       return new CampaignExpression(this, $it ->  ((Campaign)$it).updateEndDate(endDate));
    }

    public Expression<T, LocalDateTime> getStartDate(){
       return apply(Campaign::getStartDate);
    }
    public CampaignExpression<T, U, U> updateStartDate(LocalDateTime startDate){
       return new CampaignExpression(this, $it ->  ((Campaign)$it).updateStartDate(startDate));
    }

    public Expression<T, String> getStatus(){
       return apply(Campaign::getStatus);
    }
    public CampaignExpression<T, U, U> updateStatus(String status){
       return new CampaignExpression(this, $it ->  ((Campaign)$it).updateStatus(status));
    }

    public Expression<T, LocalDateTime> getCreateTime(){
       return apply(Campaign::getCreateTime);
    }
    public CampaignExpression<T, U, U> updateCreateTime(LocalDateTime createTime){
       return new CampaignExpression(this, $it ->  ((Campaign)$it).updateCreateTime(createTime));
    }

    public Expression<T, LocalDateTime> getUpdateTime(){
       return apply(Campaign::getUpdateTime);
    }
    public CampaignExpression<T, U, U> updateUpdateTime(LocalDateTime updateTime){
       return new CampaignExpression(this, $it ->  ((Campaign)$it).updateUpdateTime(updateTime));
    }

}