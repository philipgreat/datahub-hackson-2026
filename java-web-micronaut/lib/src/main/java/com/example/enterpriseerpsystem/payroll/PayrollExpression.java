
package com.example.enterpriseerpsystem.payroll;

import com.example.enterpriseerpsystem.employee.Employee;
import com.example.enterpriseerpsystem.employee.EmployeeExpression;
import io.teaql.core.UserContext;
import io.teaql.core.value.BaseEntityExpression;
import io.teaql.core.value.Expression;
import io.teaql.core.value.ExpressionAdaptor;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.function.Function;

public class PayrollExpression<T, E, U extends Payroll> extends ExpressionAdaptor<T, E, U> implements BaseEntityExpression<T, U> {
    public PayrollExpression(Expression<T, U> expression){
        super(expression);
    }

    public PayrollExpression(Expression<T, E> expression, Function<E, U> function){
        super(expression, function);
    }

     public PayrollExpression<T, U, U> updateId(Long id){
        return new PayrollExpression(this, $it -> {((Payroll)$it).__internalSet("id", id); return this;});
     }

     public PayrollExpression<T, U, U> save(UserContext userContext){
        return new PayrollExpression(this, $it -> ((Payroll)$it).auditAs("Saved by Expression").save(userContext));
     }

     public PayrollExpression<T, U, U> save(String intent, UserContext userContext){
        return new PayrollExpression(this, $it -> ((Payroll)$it).auditAs(intent).save(userContext));
     }

     public boolean isNull() {
        return resolve() == null;
     }


    public Expression<T, BigDecimal> getTax(){
       return apply(Payroll::getTax);
    }
    public PayrollExpression<T, U, U> updateTax(BigDecimal tax){
       return new PayrollExpression(this, $it ->  ((Payroll)$it).updateTax(tax));
    }

    public EmployeeExpression<T, U, Employee> getEmployee(){
       return new EmployeeExpression(this, $it ->  ((Payroll)$it).getEmployee());
    }

    public PayrollExpression<T, U, U> updateEmployee(Employee employee){
       return new PayrollExpression(this, $it ->  ((Payroll)$it).updateEmployee(employee));
    }

    public Expression<T, BigDecimal> getGrossPay(){
       return apply(Payroll::getGrossPay);
    }
    public PayrollExpression<T, U, U> updateGrossPay(BigDecimal grossPay){
       return new PayrollExpression(this, $it ->  ((Payroll)$it).updateGrossPay(grossPay));
    }

    public Expression<T, BigDecimal> getNetPay(){
       return apply(Payroll::getNetPay);
    }
    public PayrollExpression<T, U, U> updateNetPay(BigDecimal netPay){
       return new PayrollExpression(this, $it ->  ((Payroll)$it).updateNetPay(netPay));
    }

    public Expression<T, LocalDateTime> getPeriodEnd(){
       return apply(Payroll::getPeriodEnd);
    }
    public PayrollExpression<T, U, U> updatePeriodEnd(LocalDateTime periodEnd){
       return new PayrollExpression(this, $it ->  ((Payroll)$it).updatePeriodEnd(periodEnd));
    }

    public Expression<T, LocalDateTime> getPeriodStart(){
       return apply(Payroll::getPeriodStart);
    }
    public PayrollExpression<T, U, U> updatePeriodStart(LocalDateTime periodStart){
       return new PayrollExpression(this, $it ->  ((Payroll)$it).updatePeriodStart(periodStart));
    }

    public Expression<T, LocalDateTime> getCreateTime(){
       return apply(Payroll::getCreateTime);
    }
    public PayrollExpression<T, U, U> updateCreateTime(LocalDateTime createTime){
       return new PayrollExpression(this, $it ->  ((Payroll)$it).updateCreateTime(createTime));
    }

    public Expression<T, LocalDateTime> getUpdateTime(){
       return apply(Payroll::getUpdateTime);
    }
    public PayrollExpression<T, U, U> updateUpdateTime(LocalDateTime updateTime){
       return new PayrollExpression(this, $it ->  ((Payroll)$it).updateUpdateTime(updateTime));
    }

}