
package com.example.enterpriseerpsystem.employee;

import com.example.enterpriseerpsystem.attendance.Attendance;
import com.example.enterpriseerpsystem.attendance.AttendanceChecker;
import com.example.enterpriseerpsystem.benefit.Benefit;
import com.example.enterpriseerpsystem.benefit.BenefitChecker;
import com.example.enterpriseerpsystem.department.Department;
import com.example.enterpriseerpsystem.department.DepartmentChecker;
import com.example.enterpriseerpsystem.employeereview.EmployeeReview;
import com.example.enterpriseerpsystem.employeereview.EmployeeReviewChecker;
import com.example.enterpriseerpsystem.expense.Expense;
import com.example.enterpriseerpsystem.expense.ExpenseChecker;
import com.example.enterpriseerpsystem.leaverequest.LeaveRequest;
import com.example.enterpriseerpsystem.leaverequest.LeaveRequestChecker;
import com.example.enterpriseerpsystem.payroll.Payroll;
import com.example.enterpriseerpsystem.payroll.PayrollChecker;
import com.example.enterpriseerpsystem.supportagent.SupportAgent;
import com.example.enterpriseerpsystem.supportagent.SupportAgentChecker;
import io.teaql.core.UserContext;
import io.teaql.core.checker.Checker;
import io.teaql.core.checker.ObjectLocation;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class EmployeeChecker implements Checker<Employee>{

    public String type(){
        return Employee.INTERNAL_TYPE;
    }

    public void checkAndFix(UserContext _ctx, Employee employee, ObjectLocation _parentLocation){
        if(needCheck(_ctx, employee)){
            markAsChecked(_ctx, employee);
            doCheck(_ctx, employee, _parentLocation);
        }
    }

    public void doCheck(UserContext _ctx, Employee employee, ObjectLocation _parentLocation){
      if((employee == null)){
         return;
      }
      if(employee.newItem()){
        if(employee.getHireDate() == null){
           employee.updateHireDate(java.time.LocalDateTime.now());
        }if(employee.getCreateTime() == null){
           employee.updateCreateTime(java.time.LocalDateTime.now());
        }if(employee.getUpdateTime() == null){
           employee.updateUpdateTime(java.time.LocalDateTime.now());
        }
      }else if(employee.updateItem()){
        employee.updateUpdateTime(java.time.LocalDateTime.now());
      }
      checkEmail(_ctx, employee.getProperty(Employee.EMAIL_PROPERTY), newLocation(_parentLocation, Employee.EMAIL_PROPERTY));
      checkName(_ctx, employee.getProperty(Employee.NAME_PROPERTY), newLocation(_parentLocation, Employee.NAME_PROPERTY));
      checkPhone(_ctx, employee.getProperty(Employee.PHONE_PROPERTY), newLocation(_parentLocation, Employee.PHONE_PROPERTY));
      checkSalary(_ctx, employee.getProperty(Employee.SALARY_PROPERTY), newLocation(_parentLocation, Employee.SALARY_PROPERTY));
      checkSsn(_ctx, employee.getProperty(Employee.SSN_PROPERTY), newLocation(_parentLocation, Employee.SSN_PROPERTY));
      checkDepartment(_ctx, employee.getProperty(Employee.DEPARTMENT_PROPERTY), newLocation(_parentLocation, Employee.DEPARTMENT_PROPERTY));
      checkHireDate(_ctx, employee.getProperty(Employee.HIRE_DATE_PROPERTY), newLocation(_parentLocation, Employee.HIRE_DATE_PROPERTY));
      checkStatus(_ctx, employee.getProperty(Employee.STATUS_PROPERTY), newLocation(_parentLocation, Employee.STATUS_PROPERTY));
      checkCreateTime(_ctx, employee.getProperty(Employee.CREATE_TIME_PROPERTY), newLocation(_parentLocation, Employee.CREATE_TIME_PROPERTY));
      checkUpdateTime(_ctx, employee.getProperty(Employee.UPDATE_TIME_PROPERTY), newLocation(_parentLocation, Employee.UPDATE_TIME_PROPERTY));
      for(int i = 0; employee.getLeaveRequestList() != null && i < employee.getLeaveRequestList().size(); i++){
         LeaveRequest leaveRequest = employee.getLeaveRequestList().get(i);
         new LeaveRequestChecker().checkAndFix(_ctx, leaveRequest, newLocation(_parentLocation, Employee.LEAVE_REQUEST_LIST_PROPERTY, i));
      }
      for(int i = 0; employee.getAttendanceList() != null && i < employee.getAttendanceList().size(); i++){
         Attendance attendance = employee.getAttendanceList().get(i);
         new AttendanceChecker().checkAndFix(_ctx, attendance, newLocation(_parentLocation, Employee.ATTENDANCE_LIST_PROPERTY, i));
      }
      for(int i = 0; employee.getBenefitList() != null && i < employee.getBenefitList().size(); i++){
         Benefit benefit = employee.getBenefitList().get(i);
         new BenefitChecker().checkAndFix(_ctx, benefit, newLocation(_parentLocation, Employee.BENEFIT_LIST_PROPERTY, i));
      }
      for(int i = 0; employee.getEmployeeReviewList() != null && i < employee.getEmployeeReviewList().size(); i++){
         EmployeeReview employeeReview = employee.getEmployeeReviewList().get(i);
         new EmployeeReviewChecker().checkAndFix(_ctx, employeeReview, newLocation(_parentLocation, Employee.EMPLOYEE_REVIEW_LIST_PROPERTY, i));
      }
      for(int i = 0; employee.getPayrollList() != null && i < employee.getPayrollList().size(); i++){
         Payroll payroll = employee.getPayrollList().get(i);
         new PayrollChecker().checkAndFix(_ctx, payroll, newLocation(_parentLocation, Employee.PAYROLL_LIST_PROPERTY, i));
      }
      for(int i = 0; employee.getExpenseList() != null && i < employee.getExpenseList().size(); i++){
         Expense expense = employee.getExpenseList().get(i);
         new ExpenseChecker().checkAndFix(_ctx, expense, newLocation(_parentLocation, Employee.EXPENSE_LIST_PROPERTY, i));
      }
      for(int i = 0; employee.getSupportAgentList() != null && i < employee.getSupportAgentList().size(); i++){
         SupportAgent supportAgent = employee.getSupportAgentList().get(i);
         new SupportAgentChecker().checkAndFix(_ctx, supportAgent, newLocation(_parentLocation, Employee.SUPPORT_AGENT_LIST_PROPERTY, i));
      }
    }

    public void checkEmail(UserContext _ctx, String email, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, email);
    if((email == null)){
        return;
    }
    maxStringCheck(_ctx, _parentLocation, 100, email);

    }
    public void checkName(UserContext _ctx, String name, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, name);
    if((name == null)){
        return;
    }
    maxStringCheck(_ctx, _parentLocation, 100, name);

    }
    public void checkPhone(UserContext _ctx, String phone, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, phone);
    if((phone == null)){
        return;
    }
    maxStringCheck(_ctx, _parentLocation, 100, phone);

    }
    public void checkSalary(UserContext _ctx, BigDecimal salary, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, salary);
    if((salary == null)){
        return;
    }
    }
    public void checkSsn(UserContext _ctx, String ssn, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, ssn);
    if((ssn == null)){
        return;
    }
    maxStringCheck(_ctx, _parentLocation, 100, ssn);

    }
    public void checkDepartment(UserContext _ctx, Department department, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, department);
    if((department == null)){
        return;
    }
    new DepartmentChecker().checkAndFix(_ctx, department, _parentLocation);
    }
    public void checkHireDate(UserContext _ctx, LocalDateTime hireDate, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, hireDate);
    if((hireDate == null)){
        return;
    }
    }
    public void checkStatus(UserContext _ctx, String status, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, status);
    if((status == null)){
        return;
    }
    maxStringCheck(_ctx, _parentLocation, 100, status);

    }
    public void checkCreateTime(UserContext _ctx, LocalDateTime createTime, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, createTime);
    if((createTime == null)){
        return;
    }
    }
    public void checkUpdateTime(UserContext _ctx, LocalDateTime updateTime, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, updateTime);
    if((updateTime == null)){
        return;
    }
    }
}