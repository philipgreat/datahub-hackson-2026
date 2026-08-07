
package com.example.enterpriseerpsystem.expense;

import com.example.enterpriseerpsystem.employee.Employee;
import com.example.enterpriseerpsystem.employee.EmployeeExpression;
import io.teaql.core.UserContext;
import io.teaql.core.value.BaseEntityExpression;
import io.teaql.core.value.Expression;
import io.teaql.core.value.ExpressionAdaptor;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.function.Function;

public class ExpenseExpression<T, E, U extends Expense> extends ExpressionAdaptor<T, E, U> implements BaseEntityExpression<T, U> {
    public ExpenseExpression(Expression<T, U> expression){
        super(expression);
    }

    public ExpenseExpression(Expression<T, E> expression, Function<E, U> function){
        super(expression, function);
    }

     public ExpenseExpression<T, U, U> updateId(Long id){
        return new ExpenseExpression(this, $it -> {((Expense)$it).__internalSet("id", id); return this;});
     }

     public ExpenseExpression<T, U, U> save(UserContext userContext){
        return new ExpenseExpression(this, $it -> ((Expense)$it).auditAs("Saved by Expression").save(userContext));
     }

     public ExpenseExpression<T, U, U> save(String intent, UserContext userContext){
        return new ExpenseExpression(this, $it -> ((Expense)$it).auditAs(intent).save(userContext));
     }

     public boolean isNull() {
        return resolve() == null;
     }


    public Expression<T, BigDecimal> getAmount(){
       return apply(Expense::getAmount);
    }
    public ExpenseExpression<T, U, U> updateAmount(BigDecimal amount){
       return new ExpenseExpression(this, $it ->  ((Expense)$it).updateAmount(amount));
    }

    public Expression<T, String> getCategory(){
       return apply(Expense::getCategory);
    }
    public ExpenseExpression<T, U, U> updateCategory(String category){
       return new ExpenseExpression(this, $it ->  ((Expense)$it).updateCategory(category));
    }

    public Expression<T, LocalDateTime> getDateIncurred(){
       return apply(Expense::getDateIncurred);
    }
    public ExpenseExpression<T, U, U> updateDateIncurred(LocalDateTime dateIncurred){
       return new ExpenseExpression(this, $it ->  ((Expense)$it).updateDateIncurred(dateIncurred));
    }

    public EmployeeExpression<T, U, Employee> getEmployee(){
       return new EmployeeExpression(this, $it ->  ((Expense)$it).getEmployee());
    }

    public ExpenseExpression<T, U, U> updateEmployee(Employee employee){
       return new ExpenseExpression(this, $it ->  ((Expense)$it).updateEmployee(employee));
    }

    public Expression<T, String> getStatus(){
       return apply(Expense::getStatus);
    }
    public ExpenseExpression<T, U, U> updateStatus(String status){
       return new ExpenseExpression(this, $it ->  ((Expense)$it).updateStatus(status));
    }

    public Expression<T, LocalDateTime> getCreateTime(){
       return apply(Expense::getCreateTime);
    }
    public ExpenseExpression<T, U, U> updateCreateTime(LocalDateTime createTime){
       return new ExpenseExpression(this, $it ->  ((Expense)$it).updateCreateTime(createTime));
    }

    public Expression<T, LocalDateTime> getUpdateTime(){
       return apply(Expense::getUpdateTime);
    }
    public ExpenseExpression<T, U, U> updateUpdateTime(LocalDateTime updateTime){
       return new ExpenseExpression(this, $it ->  ((Expense)$it).updateUpdateTime(updateTime));
    }

}