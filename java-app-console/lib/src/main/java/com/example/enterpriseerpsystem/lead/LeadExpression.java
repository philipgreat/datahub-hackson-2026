
package com.example.enterpriseerpsystem.lead;

import com.example.enterpriseerpsystem.opportunity.Opportunity;
import com.example.enterpriseerpsystem.opportunity.OpportunityListExpression;
import io.teaql.core.UserContext;
import io.teaql.core.value.BaseEntityExpression;
import io.teaql.core.value.Expression;
import io.teaql.core.value.ExpressionAdaptor;
import java.time.LocalDateTime;
import java.util.function.Function;

public class LeadExpression<T, E, U extends Lead> extends ExpressionAdaptor<T, E, U> implements BaseEntityExpression<T, U> {
    public LeadExpression(Expression<T, U> expression){
        super(expression);
    }

    public LeadExpression(Expression<T, E> expression, Function<E, U> function){
        super(expression, function);
    }

     public LeadExpression<T, U, U> updateId(Long id){
        return new LeadExpression(this, $it -> {((Lead)$it).__internalSet("id", id); return this;});
     }

     public LeadExpression<T, U, U> save(UserContext userContext){
        return new LeadExpression(this, $it -> ((Lead)$it).auditAs("Saved by Expression").save(userContext));
     }

     public LeadExpression<T, U, U> save(String intent, UserContext userContext){
        return new LeadExpression(this, $it -> ((Lead)$it).auditAs(intent).save(userContext));
     }

     public boolean isNull() {
        return resolve() == null;
     }


    public Expression<T, String> getEmail(){
       return apply(Lead::getEmail);
    }
    public LeadExpression<T, U, U> updateEmail(String email){
       return new LeadExpression(this, $it ->  ((Lead)$it).updateEmail(email));
    }

    public Expression<T, String> getName(){
       return apply(Lead::getName);
    }
    public LeadExpression<T, U, U> updateName(String name){
       return new LeadExpression(this, $it ->  ((Lead)$it).updateName(name));
    }

    public Expression<T, String> getPhone(){
       return apply(Lead::getPhone);
    }
    public LeadExpression<T, U, U> updatePhone(String phone){
       return new LeadExpression(this, $it ->  ((Lead)$it).updatePhone(phone));
    }

    public Expression<T, String> getConvertedCustomerId(){
       return apply(Lead::getConvertedCustomerId);
    }
    public LeadExpression<T, U, U> updateConvertedCustomerId(String convertedCustomerId){
       return new LeadExpression(this, $it ->  ((Lead)$it).updateConvertedCustomerId(convertedCustomerId));
    }

    public Expression<T, String> getSource(){
       return apply(Lead::getSource);
    }
    public LeadExpression<T, U, U> updateSource(String source){
       return new LeadExpression(this, $it ->  ((Lead)$it).updateSource(source));
    }

    public Expression<T, String> getStatus(){
       return apply(Lead::getStatus);
    }
    public LeadExpression<T, U, U> updateStatus(String status){
       return new LeadExpression(this, $it ->  ((Lead)$it).updateStatus(status));
    }

    public Expression<T, LocalDateTime> getCreateTime(){
       return apply(Lead::getCreateTime);
    }
    public LeadExpression<T, U, U> updateCreateTime(LocalDateTime createTime){
       return new LeadExpression(this, $it ->  ((Lead)$it).updateCreateTime(createTime));
    }

    public Expression<T, LocalDateTime> getUpdateTime(){
       return apply(Lead::getUpdateTime);
    }
    public LeadExpression<T, U, U> updateUpdateTime(LocalDateTime updateTime){
       return new LeadExpression(this, $it ->  ((Lead)$it).updateUpdateTime(updateTime));
    }

    public OpportunityListExpression<T, U, Opportunity> getOpportunityList(){
        return new OpportunityListExpression(this, $it ->  ((Lead)$it).getOpportunityList());
    }
    public LeadExpression<T, U, U> addOpportunity(Opportunity opportunity){
       return new LeadExpression(this, $it ->  ((Lead)$it).addOpportunity(opportunity));
    }
}