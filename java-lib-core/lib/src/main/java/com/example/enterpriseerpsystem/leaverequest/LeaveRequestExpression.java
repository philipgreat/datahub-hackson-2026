
package com.example.enterpriseerpsystem.leaverequest;

import com.example.enterpriseerpsystem.employee.Employee;
import com.example.enterpriseerpsystem.employee.EmployeeExpression;
import io.teaql.core.UserContext;
import io.teaql.core.value.BaseEntityExpression;
import io.teaql.core.value.Expression;
import io.teaql.core.value.ExpressionAdaptor;
import java.time.LocalDateTime;
import java.util.function.Function;

public class LeaveRequestExpression<T, E, U extends LeaveRequest> extends ExpressionAdaptor<T, E, U> implements BaseEntityExpression<T, U> {
    public LeaveRequestExpression(Expression<T, U> expression){
        super(expression);
    }

    public LeaveRequestExpression(Expression<T, E> expression, Function<E, U> function){
        super(expression, function);
    }

     public LeaveRequestExpression<T, U, U> updateId(Long id){
        return new LeaveRequestExpression(this, $it -> {((LeaveRequest)$it).__internalSet("id", id); return this;});
     }

     public LeaveRequestExpression<T, U, U> save(UserContext userContext){
        return new LeaveRequestExpression(this, $it -> ((LeaveRequest)$it).auditAs("Saved by Expression").save(userContext));
     }

     public LeaveRequestExpression<T, U, U> save(String intent, UserContext userContext){
        return new LeaveRequestExpression(this, $it -> ((LeaveRequest)$it).auditAs(intent).save(userContext));
     }

     public boolean isNull() {
        return resolve() == null;
     }


    public EmployeeExpression<T, U, Employee> getEmployee(){
       return new EmployeeExpression(this, $it ->  ((LeaveRequest)$it).getEmployee());
    }

    public LeaveRequestExpression<T, U, U> updateEmployee(Employee employee){
       return new LeaveRequestExpression(this, $it ->  ((LeaveRequest)$it).updateEmployee(employee));
    }

    public Expression<T, LocalDateTime> getEndDate(){
       return apply(LeaveRequest::getEndDate);
    }
    public LeaveRequestExpression<T, U, U> updateEndDate(LocalDateTime endDate){
       return new LeaveRequestExpression(this, $it ->  ((LeaveRequest)$it).updateEndDate(endDate));
    }

    public Expression<T, String> getReason(){
       return apply(LeaveRequest::getReason);
    }
    public LeaveRequestExpression<T, U, U> updateReason(String reason){
       return new LeaveRequestExpression(this, $it ->  ((LeaveRequest)$it).updateReason(reason));
    }

    public Expression<T, LocalDateTime> getStartDate(){
       return apply(LeaveRequest::getStartDate);
    }
    public LeaveRequestExpression<T, U, U> updateStartDate(LocalDateTime startDate){
       return new LeaveRequestExpression(this, $it ->  ((LeaveRequest)$it).updateStartDate(startDate));
    }

    public Expression<T, String> getStatus(){
       return apply(LeaveRequest::getStatus);
    }
    public LeaveRequestExpression<T, U, U> updateStatus(String status){
       return new LeaveRequestExpression(this, $it ->  ((LeaveRequest)$it).updateStatus(status));
    }

    public Expression<T, LocalDateTime> getCreateTime(){
       return apply(LeaveRequest::getCreateTime);
    }
    public LeaveRequestExpression<T, U, U> updateCreateTime(LocalDateTime createTime){
       return new LeaveRequestExpression(this, $it ->  ((LeaveRequest)$it).updateCreateTime(createTime));
    }

    public Expression<T, LocalDateTime> getUpdateTime(){
       return apply(LeaveRequest::getUpdateTime);
    }
    public LeaveRequestExpression<T, U, U> updateUpdateTime(LocalDateTime updateTime){
       return new LeaveRequestExpression(this, $it ->  ((LeaveRequest)$it).updateUpdateTime(updateTime));
    }

}