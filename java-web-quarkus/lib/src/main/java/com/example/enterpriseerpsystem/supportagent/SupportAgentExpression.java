
package com.example.enterpriseerpsystem.supportagent;

import com.example.enterpriseerpsystem.employee.Employee;
import com.example.enterpriseerpsystem.employee.EmployeeExpression;
import io.teaql.core.UserContext;
import io.teaql.core.value.BaseEntityExpression;
import io.teaql.core.value.Expression;
import io.teaql.core.value.ExpressionAdaptor;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.function.Function;

public class SupportAgentExpression<T, E, U extends SupportAgent> extends ExpressionAdaptor<T, E, U> implements BaseEntityExpression<T, U> {
    public SupportAgentExpression(Expression<T, U> expression){
        super(expression);
    }

    public SupportAgentExpression(Expression<T, E> expression, Function<E, U> function){
        super(expression, function);
    }

     public SupportAgentExpression<T, U, U> updateId(Long id){
        return new SupportAgentExpression(this, $it -> {((SupportAgent)$it).__internalSet("id", id); return this;});
     }

     public SupportAgentExpression<T, U, U> save(UserContext userContext){
        return new SupportAgentExpression(this, $it -> ((SupportAgent)$it).auditAs("Saved by Expression").save(userContext));
     }

     public SupportAgentExpression<T, U, U> save(String intent, UserContext userContext){
        return new SupportAgentExpression(this, $it -> ((SupportAgent)$it).auditAs(intent).save(userContext));
     }

     public boolean isNull() {
        return resolve() == null;
     }


    public Expression<T, BigDecimal> getActiveTickets(){
       return apply(SupportAgent::getActiveTickets);
    }
    public SupportAgentExpression<T, U, U> updateActiveTickets(BigDecimal activeTickets){
       return new SupportAgentExpression(this, $it ->  ((SupportAgent)$it).updateActiveTickets(activeTickets));
    }

    public EmployeeExpression<T, U, Employee> getEmployee(){
       return new EmployeeExpression(this, $it ->  ((SupportAgent)$it).getEmployee());
    }

    public SupportAgentExpression<T, U, U> updateEmployee(Employee employee){
       return new SupportAgentExpression(this, $it ->  ((SupportAgent)$it).updateEmployee(employee));
    }

    public Expression<T, String> getSpecialty(){
       return apply(SupportAgent::getSpecialty);
    }
    public SupportAgentExpression<T, U, U> updateSpecialty(String specialty){
       return new SupportAgentExpression(this, $it ->  ((SupportAgent)$it).updateSpecialty(specialty));
    }

    public Expression<T, LocalDateTime> getCreateTime(){
       return apply(SupportAgent::getCreateTime);
    }
    public SupportAgentExpression<T, U, U> updateCreateTime(LocalDateTime createTime){
       return new SupportAgentExpression(this, $it ->  ((SupportAgent)$it).updateCreateTime(createTime));
    }

    public Expression<T, LocalDateTime> getUpdateTime(){
       return apply(SupportAgent::getUpdateTime);
    }
    public SupportAgentExpression<T, U, U> updateUpdateTime(LocalDateTime updateTime){
       return new SupportAgentExpression(this, $it ->  ((SupportAgent)$it).updateUpdateTime(updateTime));
    }

}