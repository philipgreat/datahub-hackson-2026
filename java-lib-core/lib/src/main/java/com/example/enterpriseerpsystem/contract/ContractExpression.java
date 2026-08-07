
package com.example.enterpriseerpsystem.contract;

import com.example.enterpriseerpsystem.customer.Customer;
import com.example.enterpriseerpsystem.customer.CustomerExpression;
import io.teaql.core.UserContext;
import io.teaql.core.value.BaseEntityExpression;
import io.teaql.core.value.Expression;
import io.teaql.core.value.ExpressionAdaptor;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.function.Function;

public class ContractExpression<T, E, U extends Contract> extends ExpressionAdaptor<T, E, U> implements BaseEntityExpression<T, U> {
    public ContractExpression(Expression<T, U> expression){
        super(expression);
    }

    public ContractExpression(Expression<T, E> expression, Function<E, U> function){
        super(expression, function);
    }

     public ContractExpression<T, U, U> updateId(Long id){
        return new ContractExpression(this, $it -> {((Contract)$it).__internalSet("id", id); return this;});
     }

     public ContractExpression<T, U, U> save(UserContext userContext){
        return new ContractExpression(this, $it -> ((Contract)$it).auditAs("Saved by Expression").save(userContext));
     }

     public ContractExpression<T, U, U> save(String intent, UserContext userContext){
        return new ContractExpression(this, $it -> ((Contract)$it).auditAs(intent).save(userContext));
     }

     public boolean isNull() {
        return resolve() == null;
     }


    public CustomerExpression<T, U, Customer> getCustomer(){
       return new CustomerExpression(this, $it ->  ((Contract)$it).getCustomer());
    }

    public ContractExpression<T, U, U> updateCustomer(Customer customer){
       return new ContractExpression(this, $it ->  ((Contract)$it).updateCustomer(customer));
    }

    public Expression<T, LocalDateTime> getEndDate(){
       return apply(Contract::getEndDate);
    }
    public ContractExpression<T, U, U> updateEndDate(LocalDateTime endDate){
       return new ContractExpression(this, $it ->  ((Contract)$it).updateEndDate(endDate));
    }

    public Expression<T, LocalDateTime> getStartDate(){
       return apply(Contract::getStartDate);
    }
    public ContractExpression<T, U, U> updateStartDate(LocalDateTime startDate){
       return new ContractExpression(this, $it ->  ((Contract)$it).updateStartDate(startDate));
    }

    public Expression<T, String> getTerms(){
       return apply(Contract::getTerms);
    }
    public ContractExpression<T, U, U> updateTerms(String terms){
       return new ContractExpression(this, $it ->  ((Contract)$it).updateTerms(terms));
    }

    public Expression<T, BigDecimal> getValue(){
       return apply(Contract::getValue);
    }
    public ContractExpression<T, U, U> updateValue(BigDecimal value){
       return new ContractExpression(this, $it ->  ((Contract)$it).updateValue(value));
    }

    public Expression<T, LocalDateTime> getCreateTime(){
       return apply(Contract::getCreateTime);
    }
    public ContractExpression<T, U, U> updateCreateTime(LocalDateTime createTime){
       return new ContractExpression(this, $it ->  ((Contract)$it).updateCreateTime(createTime));
    }

    public Expression<T, LocalDateTime> getUpdateTime(){
       return apply(Contract::getUpdateTime);
    }
    public ContractExpression<T, U, U> updateUpdateTime(LocalDateTime updateTime){
       return new ContractExpression(this, $it ->  ((Contract)$it).updateUpdateTime(updateTime));
    }

}