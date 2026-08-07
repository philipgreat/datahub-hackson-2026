
package com.example.enterpriseerpsystem.quote;

import com.example.enterpriseerpsystem.opportunity.Opportunity;
import com.example.enterpriseerpsystem.opportunity.OpportunityExpression;
import io.teaql.core.UserContext;
import io.teaql.core.value.BaseEntityExpression;
import io.teaql.core.value.Expression;
import io.teaql.core.value.ExpressionAdaptor;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.function.Function;

public class QuoteExpression<T, E, U extends Quote> extends ExpressionAdaptor<T, E, U> implements BaseEntityExpression<T, U> {
    public QuoteExpression(Expression<T, U> expression){
        super(expression);
    }

    public QuoteExpression(Expression<T, E> expression, Function<E, U> function){
        super(expression, function);
    }

     public QuoteExpression<T, U, U> updateId(Long id){
        return new QuoteExpression(this, $it -> {((Quote)$it).__internalSet("id", id); return this;});
     }

     public QuoteExpression<T, U, U> save(UserContext userContext){
        return new QuoteExpression(this, $it -> ((Quote)$it).auditAs("Saved by Expression").save(userContext));
     }

     public QuoteExpression<T, U, U> save(String intent, UserContext userContext){
        return new QuoteExpression(this, $it -> ((Quote)$it).auditAs(intent).save(userContext));
     }

     public boolean isNull() {
        return resolve() == null;
     }


    public Expression<T, BigDecimal> getTotalAmount(){
       return apply(Quote::getTotalAmount);
    }
    public QuoteExpression<T, U, U> updateTotalAmount(BigDecimal totalAmount){
       return new QuoteExpression(this, $it ->  ((Quote)$it).updateTotalAmount(totalAmount));
    }

    public OpportunityExpression<T, U, Opportunity> getOpportunity(){
       return new OpportunityExpression(this, $it ->  ((Quote)$it).getOpportunity());
    }

    public QuoteExpression<T, U, U> updateOpportunity(Opportunity opportunity){
       return new QuoteExpression(this, $it ->  ((Quote)$it).updateOpportunity(opportunity));
    }

    public Expression<T, String> getStatus(){
       return apply(Quote::getStatus);
    }
    public QuoteExpression<T, U, U> updateStatus(String status){
       return new QuoteExpression(this, $it ->  ((Quote)$it).updateStatus(status));
    }

    public Expression<T, LocalDateTime> getValidUntil(){
       return apply(Quote::getValidUntil);
    }
    public QuoteExpression<T, U, U> updateValidUntil(LocalDateTime validUntil){
       return new QuoteExpression(this, $it ->  ((Quote)$it).updateValidUntil(validUntil));
    }

    public Expression<T, LocalDateTime> getCreateTime(){
       return apply(Quote::getCreateTime);
    }
    public QuoteExpression<T, U, U> updateCreateTime(LocalDateTime createTime){
       return new QuoteExpression(this, $it ->  ((Quote)$it).updateCreateTime(createTime));
    }

    public Expression<T, LocalDateTime> getUpdateTime(){
       return apply(Quote::getUpdateTime);
    }
    public QuoteExpression<T, U, U> updateUpdateTime(LocalDateTime updateTime){
       return new QuoteExpression(this, $it ->  ((Quote)$it).updateUpdateTime(updateTime));
    }

}