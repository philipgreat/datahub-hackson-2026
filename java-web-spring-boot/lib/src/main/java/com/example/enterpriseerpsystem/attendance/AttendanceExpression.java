
package com.example.enterpriseerpsystem.attendance;

import com.example.enterpriseerpsystem.employee.Employee;
import com.example.enterpriseerpsystem.employee.EmployeeExpression;
import io.teaql.core.UserContext;
import io.teaql.core.value.BaseEntityExpression;
import io.teaql.core.value.Expression;
import io.teaql.core.value.ExpressionAdaptor;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.function.Function;

public class AttendanceExpression<T, E, U extends Attendance> extends ExpressionAdaptor<T, E, U> implements BaseEntityExpression<T, U> {
    public AttendanceExpression(Expression<T, U> expression){
        super(expression);
    }

    public AttendanceExpression(Expression<T, E> expression, Function<E, U> function){
        super(expression, function);
    }

     public AttendanceExpression<T, U, U> updateId(Long id){
        return new AttendanceExpression(this, $it -> {((Attendance)$it).__internalSet("id", id); return this;});
     }

     public AttendanceExpression<T, U, U> save(UserContext userContext){
        return new AttendanceExpression(this, $it -> ((Attendance)$it).auditAs("Saved by Expression").save(userContext));
     }

     public AttendanceExpression<T, U, U> save(String intent, UserContext userContext){
        return new AttendanceExpression(this, $it -> ((Attendance)$it).auditAs(intent).save(userContext));
     }

     public boolean isNull() {
        return resolve() == null;
     }


    public Expression<T, LocalDateTime> getCheckIn(){
       return apply(Attendance::getCheckIn);
    }
    public AttendanceExpression<T, U, U> updateCheckIn(LocalDateTime checkIn){
       return new AttendanceExpression(this, $it ->  ((Attendance)$it).updateCheckIn(checkIn));
    }

    public Expression<T, LocalDateTime> getCheckOut(){
       return apply(Attendance::getCheckOut);
    }
    public AttendanceExpression<T, U, U> updateCheckOut(LocalDateTime checkOut){
       return new AttendanceExpression(this, $it ->  ((Attendance)$it).updateCheckOut(checkOut));
    }

    public EmployeeExpression<T, U, Employee> getEmployee(){
       return new EmployeeExpression(this, $it ->  ((Attendance)$it).getEmployee());
    }

    public AttendanceExpression<T, U, U> updateEmployee(Employee employee){
       return new AttendanceExpression(this, $it ->  ((Attendance)$it).updateEmployee(employee));
    }

    public Expression<T, BigDecimal> getHoursWorked(){
       return apply(Attendance::getHoursWorked);
    }
    public AttendanceExpression<T, U, U> updateHoursWorked(BigDecimal hoursWorked){
       return new AttendanceExpression(this, $it ->  ((Attendance)$it).updateHoursWorked(hoursWorked));
    }

    public Expression<T, LocalDateTime> getCreateTime(){
       return apply(Attendance::getCreateTime);
    }
    public AttendanceExpression<T, U, U> updateCreateTime(LocalDateTime createTime){
       return new AttendanceExpression(this, $it ->  ((Attendance)$it).updateCreateTime(createTime));
    }

    public Expression<T, LocalDateTime> getUpdateTime(){
       return apply(Attendance::getUpdateTime);
    }
    public AttendanceExpression<T, U, U> updateUpdateTime(LocalDateTime updateTime){
       return new AttendanceExpression(this, $it ->  ((Attendance)$it).updateUpdateTime(updateTime));
    }

}