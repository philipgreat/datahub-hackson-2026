
package com.example.enterpriseerpsystem.benefit;

import com.example.enterpriseerpsystem.employee.Employee;
import com.example.enterpriseerpsystem.employee.EmployeeExpression;
import io.teaql.core.UserContext;
import io.teaql.core.value.BaseEntityExpression;
import io.teaql.core.value.Expression;
import io.teaql.core.value.ExpressionAdaptor;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.function.Function;

public class BenefitExpression<T, E, U extends Benefit> extends ExpressionAdaptor<T, E, U> implements BaseEntityExpression<T, U> {
    public BenefitExpression(Expression<T, U> expression){
        super(expression);
    }

    public BenefitExpression(Expression<T, E> expression, Function<E, U> function){
        super(expression, function);
    }

     public BenefitExpression<T, U, U> updateId(Long id){
        return new BenefitExpression(this, $it -> {((Benefit)$it).__internalSet("id", id); return this;});
     }

     public BenefitExpression<T, U, U> save(UserContext userContext){
        return new BenefitExpression(this, $it -> ((Benefit)$it).auditAs("Saved by Expression").save(userContext));
     }

     public BenefitExpression<T, U, U> save(String intent, UserContext userContext){
        return new BenefitExpression(this, $it -> ((Benefit)$it).auditAs(intent).save(userContext));
     }

     public boolean isNull() {
        return resolve() == null;
     }


    public Expression<T, BigDecimal> getCost(){
       return apply(Benefit::getCost);
    }
    public BenefitExpression<T, U, U> updateCost(BigDecimal cost){
       return new BenefitExpression(this, $it ->  ((Benefit)$it).updateCost(cost));
    }

    public EmployeeExpression<T, U, Employee> getEmployee(){
       return new EmployeeExpression(this, $it ->  ((Benefit)$it).getEmployee());
    }

    public BenefitExpression<T, U, U> updateEmployee(Employee employee){
       return new BenefitExpression(this, $it ->  ((Benefit)$it).updateEmployee(employee));
    }

    public Expression<T, String> getPlanType(){
       return apply(Benefit::getPlanType);
    }
    public BenefitExpression<T, U, U> updatePlanType(String planType){
       return new BenefitExpression(this, $it ->  ((Benefit)$it).updatePlanType(planType));
    }

    public Expression<T, String> getProvider(){
       return apply(Benefit::getProvider);
    }
    public BenefitExpression<T, U, U> updateProvider(String provider){
       return new BenefitExpression(this, $it ->  ((Benefit)$it).updateProvider(provider));
    }

    public Expression<T, LocalDateTime> getCreateTime(){
       return apply(Benefit::getCreateTime);
    }
    public BenefitExpression<T, U, U> updateCreateTime(LocalDateTime createTime){
       return new BenefitExpression(this, $it ->  ((Benefit)$it).updateCreateTime(createTime));
    }

    public Expression<T, LocalDateTime> getUpdateTime(){
       return apply(Benefit::getUpdateTime);
    }
    public BenefitExpression<T, U, U> updateUpdateTime(LocalDateTime updateTime){
       return new BenefitExpression(this, $it ->  ((Benefit)$it).updateUpdateTime(updateTime));
    }

}