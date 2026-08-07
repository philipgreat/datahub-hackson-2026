
package com.example.enterpriseerpsystem.department;

import com.example.enterpriseerpsystem.employee.Employee;
import com.example.enterpriseerpsystem.employee.EmployeeListExpression;
import io.teaql.core.UserContext;
import io.teaql.core.value.BaseEntityExpression;
import io.teaql.core.value.Expression;
import io.teaql.core.value.ExpressionAdaptor;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.function.Function;

public class DepartmentExpression<T, E, U extends Department> extends ExpressionAdaptor<T, E, U> implements BaseEntityExpression<T, U> {
    public DepartmentExpression(Expression<T, U> expression){
        super(expression);
    }

    public DepartmentExpression(Expression<T, E> expression, Function<E, U> function){
        super(expression, function);
    }

     public DepartmentExpression<T, U, U> updateId(Long id){
        return new DepartmentExpression(this, $it -> {((Department)$it).__internalSet("id", id); return this;});
     }

     public DepartmentExpression<T, U, U> save(UserContext userContext){
        return new DepartmentExpression(this, $it -> ((Department)$it).auditAs("Saved by Expression").save(userContext));
     }

     public DepartmentExpression<T, U, U> save(String intent, UserContext userContext){
        return new DepartmentExpression(this, $it -> ((Department)$it).auditAs(intent).save(userContext));
     }

     public boolean isNull() {
        return resolve() == null;
     }


    public Expression<T, String> getName(){
       return apply(Department::getName);
    }
    public DepartmentExpression<T, U, U> updateName(String name){
       return new DepartmentExpression(this, $it ->  ((Department)$it).updateName(name));
    }

    public Expression<T, BigDecimal> getBudget(){
       return apply(Department::getBudget);
    }
    public DepartmentExpression<T, U, U> updateBudget(BigDecimal budget){
       return new DepartmentExpression(this, $it ->  ((Department)$it).updateBudget(budget));
    }

    public Expression<T, String> getLocation(){
       return apply(Department::getLocation);
    }
    public DepartmentExpression<T, U, U> updateLocation(String location){
       return new DepartmentExpression(this, $it ->  ((Department)$it).updateLocation(location));
    }

    public Expression<T, String> getManagerId(){
       return apply(Department::getManagerId);
    }
    public DepartmentExpression<T, U, U> updateManagerId(String managerId){
       return new DepartmentExpression(this, $it ->  ((Department)$it).updateManagerId(managerId));
    }

    public Expression<T, LocalDateTime> getCreateTime(){
       return apply(Department::getCreateTime);
    }
    public DepartmentExpression<T, U, U> updateCreateTime(LocalDateTime createTime){
       return new DepartmentExpression(this, $it ->  ((Department)$it).updateCreateTime(createTime));
    }

    public Expression<T, LocalDateTime> getUpdateTime(){
       return apply(Department::getUpdateTime);
    }
    public DepartmentExpression<T, U, U> updateUpdateTime(LocalDateTime updateTime){
       return new DepartmentExpression(this, $it ->  ((Department)$it).updateUpdateTime(updateTime));
    }

    public EmployeeListExpression<T, U, Employee> getEmployeeList(){
        return new EmployeeListExpression(this, $it ->  ((Department)$it).getEmployeeList());
    }
    public DepartmentExpression<T, U, U> addEmployee(Employee employee){
       return new DepartmentExpression(this, $it ->  ((Department)$it).addEmployee(employee));
    }
}