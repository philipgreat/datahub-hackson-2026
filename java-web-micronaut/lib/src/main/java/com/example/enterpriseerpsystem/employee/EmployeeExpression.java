
package com.example.enterpriseerpsystem.employee;

import com.example.enterpriseerpsystem.attendance.Attendance;
import com.example.enterpriseerpsystem.attendance.AttendanceListExpression;
import com.example.enterpriseerpsystem.benefit.Benefit;
import com.example.enterpriseerpsystem.benefit.BenefitListExpression;
import com.example.enterpriseerpsystem.department.Department;
import com.example.enterpriseerpsystem.department.DepartmentExpression;
import com.example.enterpriseerpsystem.employeereview.EmployeeReview;
import com.example.enterpriseerpsystem.employeereview.EmployeeReviewListExpression;
import com.example.enterpriseerpsystem.expense.Expense;
import com.example.enterpriseerpsystem.expense.ExpenseListExpression;
import com.example.enterpriseerpsystem.leaverequest.LeaveRequest;
import com.example.enterpriseerpsystem.leaverequest.LeaveRequestListExpression;
import com.example.enterpriseerpsystem.payroll.Payroll;
import com.example.enterpriseerpsystem.payroll.PayrollListExpression;
import com.example.enterpriseerpsystem.supportagent.SupportAgent;
import com.example.enterpriseerpsystem.supportagent.SupportAgentListExpression;
import io.teaql.core.UserContext;
import io.teaql.core.value.BaseEntityExpression;
import io.teaql.core.value.Expression;
import io.teaql.core.value.ExpressionAdaptor;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.function.Function;

public class EmployeeExpression<T, E, U extends Employee> extends ExpressionAdaptor<T, E, U> implements BaseEntityExpression<T, U> {
    public EmployeeExpression(Expression<T, U> expression){
        super(expression);
    }

    public EmployeeExpression(Expression<T, E> expression, Function<E, U> function){
        super(expression, function);
    }

     public EmployeeExpression<T, U, U> updateId(Long id){
        return new EmployeeExpression(this, $it -> {((Employee)$it).__internalSet("id", id); return this;});
     }

     public EmployeeExpression<T, U, U> save(UserContext userContext){
        return new EmployeeExpression(this, $it -> ((Employee)$it).auditAs("Saved by Expression").save(userContext));
     }

     public EmployeeExpression<T, U, U> save(String intent, UserContext userContext){
        return new EmployeeExpression(this, $it -> ((Employee)$it).auditAs(intent).save(userContext));
     }

     public boolean isNull() {
        return resolve() == null;
     }


    public Expression<T, String> getEmail(){
       return apply(Employee::getEmail);
    }
    public EmployeeExpression<T, U, U> updateEmail(String email){
       return new EmployeeExpression(this, $it ->  ((Employee)$it).updateEmail(email));
    }

    public Expression<T, String> getName(){
       return apply(Employee::getName);
    }
    public EmployeeExpression<T, U, U> updateName(String name){
       return new EmployeeExpression(this, $it ->  ((Employee)$it).updateName(name));
    }

    public Expression<T, String> getPhone(){
       return apply(Employee::getPhone);
    }
    public EmployeeExpression<T, U, U> updatePhone(String phone){
       return new EmployeeExpression(this, $it ->  ((Employee)$it).updatePhone(phone));
    }

    public Expression<T, BigDecimal> getSalary(){
       return apply(Employee::getSalary);
    }
    public EmployeeExpression<T, U, U> updateSalary(BigDecimal salary){
       return new EmployeeExpression(this, $it ->  ((Employee)$it).updateSalary(salary));
    }

    public Expression<T, String> getSsn(){
       return apply(Employee::getSsn);
    }
    public EmployeeExpression<T, U, U> updateSsn(String ssn){
       return new EmployeeExpression(this, $it ->  ((Employee)$it).updateSsn(ssn));
    }

    public DepartmentExpression<T, U, Department> getDepartment(){
       return new DepartmentExpression(this, $it ->  ((Employee)$it).getDepartment());
    }

    public EmployeeExpression<T, U, U> updateDepartment(Department department){
       return new EmployeeExpression(this, $it ->  ((Employee)$it).updateDepartment(department));
    }

    public Expression<T, LocalDateTime> getHireDate(){
       return apply(Employee::getHireDate);
    }
    public EmployeeExpression<T, U, U> updateHireDate(LocalDateTime hireDate){
       return new EmployeeExpression(this, $it ->  ((Employee)$it).updateHireDate(hireDate));
    }

    public Expression<T, String> getStatus(){
       return apply(Employee::getStatus);
    }
    public EmployeeExpression<T, U, U> updateStatus(String status){
       return new EmployeeExpression(this, $it ->  ((Employee)$it).updateStatus(status));
    }

    public Expression<T, LocalDateTime> getCreateTime(){
       return apply(Employee::getCreateTime);
    }
    public EmployeeExpression<T, U, U> updateCreateTime(LocalDateTime createTime){
       return new EmployeeExpression(this, $it ->  ((Employee)$it).updateCreateTime(createTime));
    }

    public Expression<T, LocalDateTime> getUpdateTime(){
       return apply(Employee::getUpdateTime);
    }
    public EmployeeExpression<T, U, U> updateUpdateTime(LocalDateTime updateTime){
       return new EmployeeExpression(this, $it ->  ((Employee)$it).updateUpdateTime(updateTime));
    }

    public LeaveRequestListExpression<T, U, LeaveRequest> getLeaveRequestList(){
        return new LeaveRequestListExpression(this, $it ->  ((Employee)$it).getLeaveRequestList());
    }
    public AttendanceListExpression<T, U, Attendance> getAttendanceList(){
        return new AttendanceListExpression(this, $it ->  ((Employee)$it).getAttendanceList());
    }
    public BenefitListExpression<T, U, Benefit> getBenefitList(){
        return new BenefitListExpression(this, $it ->  ((Employee)$it).getBenefitList());
    }
    public EmployeeReviewListExpression<T, U, EmployeeReview> getEmployeeReviewList(){
        return new EmployeeReviewListExpression(this, $it ->  ((Employee)$it).getEmployeeReviewList());
    }
    public PayrollListExpression<T, U, Payroll> getPayrollList(){
        return new PayrollListExpression(this, $it ->  ((Employee)$it).getPayrollList());
    }
    public ExpenseListExpression<T, U, Expense> getExpenseList(){
        return new ExpenseListExpression(this, $it ->  ((Employee)$it).getExpenseList());
    }
    public SupportAgentListExpression<T, U, SupportAgent> getSupportAgentList(){
        return new SupportAgentListExpression(this, $it ->  ((Employee)$it).getSupportAgentList());
    }
    public EmployeeExpression<T, U, U> addLeaveRequest(LeaveRequest leaveRequest){
       return new EmployeeExpression(this, $it ->  ((Employee)$it).addLeaveRequest(leaveRequest));
    }
    public EmployeeExpression<T, U, U> addAttendance(Attendance attendance){
       return new EmployeeExpression(this, $it ->  ((Employee)$it).addAttendance(attendance));
    }
    public EmployeeExpression<T, U, U> addBenefit(Benefit benefit){
       return new EmployeeExpression(this, $it ->  ((Employee)$it).addBenefit(benefit));
    }
    public EmployeeExpression<T, U, U> addEmployeeReview(EmployeeReview employeeReview){
       return new EmployeeExpression(this, $it ->  ((Employee)$it).addEmployeeReview(employeeReview));
    }
    public EmployeeExpression<T, U, U> addPayroll(Payroll payroll){
       return new EmployeeExpression(this, $it ->  ((Employee)$it).addPayroll(payroll));
    }
    public EmployeeExpression<T, U, U> addExpense(Expense expense){
       return new EmployeeExpression(this, $it ->  ((Employee)$it).addExpense(expense));
    }
    public EmployeeExpression<T, U, U> addSupportAgent(SupportAgent supportAgent){
       return new EmployeeExpression(this, $it ->  ((Employee)$it).addSupportAgent(supportAgent));
    }
}