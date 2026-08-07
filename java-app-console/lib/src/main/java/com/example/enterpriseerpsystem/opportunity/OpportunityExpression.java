
package com.example.enterpriseerpsystem.opportunity;

import com.example.enterpriseerpsystem.lead.Lead;
import com.example.enterpriseerpsystem.lead.LeadExpression;
import com.example.enterpriseerpsystem.quote.Quote;
import com.example.enterpriseerpsystem.quote.QuoteListExpression;
import io.teaql.core.UserContext;
import io.teaql.core.value.BaseEntityExpression;
import io.teaql.core.value.Expression;
import io.teaql.core.value.ExpressionAdaptor;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.function.Function;

public class OpportunityExpression<T, E, U extends Opportunity> extends ExpressionAdaptor<T, E, U> implements BaseEntityExpression<T, U> {
    public OpportunityExpression(Expression<T, U> expression){
        super(expression);
    }

    public OpportunityExpression(Expression<T, E> expression, Function<E, U> function){
        super(expression, function);
    }

     public OpportunityExpression<T, U, U> updateId(Long id){
        return new OpportunityExpression(this, $it -> {((Opportunity)$it).__internalSet("id", id); return this;});
     }

     public OpportunityExpression<T, U, U> save(UserContext userContext){
        return new OpportunityExpression(this, $it -> ((Opportunity)$it).auditAs("Saved by Expression").save(userContext));
     }

     public OpportunityExpression<T, U, U> save(String intent, UserContext userContext){
        return new OpportunityExpression(this, $it -> ((Opportunity)$it).auditAs(intent).save(userContext));
     }

     public boolean isNull() {
        return resolve() == null;
     }


    public Expression<T, LocalDateTime> getCloseDate(){
       return apply(Opportunity::getCloseDate);
    }
    public OpportunityExpression<T, U, U> updateCloseDate(LocalDateTime closeDate){
       return new OpportunityExpression(this, $it ->  ((Opportunity)$it).updateCloseDate(closeDate));
    }

    public Expression<T, BigDecimal> getExpectedRevenue(){
       return apply(Opportunity::getExpectedRevenue);
    }
    public OpportunityExpression<T, U, U> updateExpectedRevenue(BigDecimal expectedRevenue){
       return new OpportunityExpression(this, $it ->  ((Opportunity)$it).updateExpectedRevenue(expectedRevenue));
    }

    public LeadExpression<T, U, Lead> getLead(){
       return new LeadExpression(this, $it ->  ((Opportunity)$it).getLead());
    }

    public OpportunityExpression<T, U, U> updateLead(Lead lead){
       return new OpportunityExpression(this, $it ->  ((Opportunity)$it).updateLead(lead));
    }

    public Expression<T, BigDecimal> getProbability(){
       return apply(Opportunity::getProbability);
    }
    public OpportunityExpression<T, U, U> updateProbability(BigDecimal probability){
       return new OpportunityExpression(this, $it ->  ((Opportunity)$it).updateProbability(probability));
    }

    public Expression<T, String> getStatus(){
       return apply(Opportunity::getStatus);
    }
    public OpportunityExpression<T, U, U> updateStatus(String status){
       return new OpportunityExpression(this, $it ->  ((Opportunity)$it).updateStatus(status));
    }

    public Expression<T, LocalDateTime> getCreateTime(){
       return apply(Opportunity::getCreateTime);
    }
    public OpportunityExpression<T, U, U> updateCreateTime(LocalDateTime createTime){
       return new OpportunityExpression(this, $it ->  ((Opportunity)$it).updateCreateTime(createTime));
    }

    public Expression<T, LocalDateTime> getUpdateTime(){
       return apply(Opportunity::getUpdateTime);
    }
    public OpportunityExpression<T, U, U> updateUpdateTime(LocalDateTime updateTime){
       return new OpportunityExpression(this, $it ->  ((Opportunity)$it).updateUpdateTime(updateTime));
    }

    public QuoteListExpression<T, U, Quote> getQuoteList(){
        return new QuoteListExpression(this, $it ->  ((Opportunity)$it).getQuoteList());
    }
    public OpportunityExpression<T, U, U> addQuote(Quote quote){
       return new OpportunityExpression(this, $it ->  ((Opportunity)$it).addQuote(quote));
    }
}