
package com.example.enterpriseerpsystem.employee;

import com.example.enterpriseerpsystem.attendance.Attendance;
import com.example.enterpriseerpsystem.benefit.Benefit;
import com.example.enterpriseerpsystem.department.Department;
import com.example.enterpriseerpsystem.employeereview.EmployeeReview;
import com.example.enterpriseerpsystem.expense.Expense;
import com.example.enterpriseerpsystem.leaverequest.LeaveRequest;
import com.example.enterpriseerpsystem.payroll.Payroll;
import com.example.enterpriseerpsystem.supportagent.SupportAgent;
import io.teaql.core.Audited;
import io.teaql.core.BaseEntity;
import io.teaql.core.EntityStatus;
import io.teaql.core.FrameworkInternal;
import io.teaql.core.RemoteInput;
import io.teaql.core.SmartList;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * [TEAQL AI WARNING]
 * TeaQL was explicitly designed to PREVENT AI hallucinations and random guessing.
 * DO NOT GUESS METHOD NAMES!
 * The methods listed below are the ONLY valid ways to interact with this entity.
 * If you encounter compilation errors (e.g., method not found), DO NOT guess another method name.
 * Read the method signatures in this file before proceeding.
 */
public class Employee extends BaseEntity implements RemoteInput {
    public static String INTERNAL_TYPE = "Employee";

    public static final String EMAIL_PROPERTY = "email";
    public static final String NAME_PROPERTY = "name";
    public static final String PHONE_PROPERTY = "phone";
    public static final String SALARY_PROPERTY = "salary";
    public static final String SSN_PROPERTY = "ssn";
    public static final String DEPARTMENT_PROPERTY = "department";
    public static final String HIRE_DATE_PROPERTY = "hireDate";
    public static final String STATUS_PROPERTY = "status";
    public static final String CREATE_TIME_PROPERTY = "createTime";
    public static final String UPDATE_TIME_PROPERTY = "updateTime";
    public static final String LEAVE_REQUEST_LIST_PROPERTY = "leaveRequestList";
    public static final String ATTENDANCE_LIST_PROPERTY = "attendanceList";
    public static final String BENEFIT_LIST_PROPERTY = "benefitList";
    public static final String EMPLOYEE_REVIEW_LIST_PROPERTY = "employeeReviewList";
    public static final String PAYROLL_LIST_PROPERTY = "payrollList";
    public static final String EXPENSE_LIST_PROPERTY = "expenseList";
    public static final String SUPPORT_AGENT_LIST_PROPERTY = "supportAgentList";
    private String email;
    private String name;
    private String phone;
    private BigDecimal salary;
    private String ssn;
    private Department department;
    private LocalDateTime hireDate;
    private String status;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private SmartList<LeaveRequest> leaveRequestList;
    private SmartList<Attendance> attendanceList;
    private SmartList<Benefit> benefitList;
    private SmartList<EmployeeReview> employeeReviewList;
    private SmartList<Payroll> payrollList;
    private SmartList<Expense> expenseList;
    private SmartList<SupportAgent> supportAgentList;

    public String getEmail(){
        return this.email;
    }
    public String getName(){
        return this.name;
    }
    public String getPhone(){
        return this.phone;
    }
    public BigDecimal getSalary(){
        return this.salary;
    }
    public String getSsn(){
        return this.ssn;
    }
    public Department getDepartment(){
        return this.department;
    }
    public LocalDateTime getHireDate(){
        return this.hireDate;
    }
    public String getStatus(){
        return this.status;
    }
    public LocalDateTime getCreateTime(){
        return this.createTime;
    }
    public LocalDateTime getUpdateTime(){
        return this.updateTime;
    }
    public SmartList<LeaveRequest> getLeaveRequestList(){
        return this.leaveRequestList;
    }
    public SmartList<Attendance> getAttendanceList(){
        return this.attendanceList;
    }
    public SmartList<Benefit> getBenefitList(){
        return this.benefitList;
    }
    public SmartList<EmployeeReview> getEmployeeReviewList(){
        return this.employeeReviewList;
    }
    public SmartList<Payroll> getPayrollList(){
        return this.payrollList;
    }
    public SmartList<Expense> getExpenseList(){
        return this.expenseList;
    }
    public SmartList<SupportAgent> getSupportAgentList(){
        return this.supportAgentList;
    }
    public Employee updateEmail(String email){
        email = (email == null ? null : email.trim());
        if(Objects.equals(this.email, email)){
            return this;
        }
        handleUpdate(EMAIL_PROPERTY, getEmail(), email);
        this.email = email;
        return this;
    }
    public Employee updateName(String name){
        name = (name == null ? null : name.trim());
        if(Objects.equals(this.name, name)){
            return this;
        }
        handleUpdate(NAME_PROPERTY, getName(), name);
        this.name = name;
        return this;
    }
    public Employee updatePhone(String phone){
        phone = (phone == null ? null : phone.trim());
        if(Objects.equals(this.phone, phone)){
            return this;
        }
        handleUpdate(PHONE_PROPERTY, getPhone(), phone);
        this.phone = phone;
        return this;
    }
    public Employee updateSalary(BigDecimal salary){
        if(Objects.equals(this.salary, salary)){
            return this;
        }
        handleUpdate(SALARY_PROPERTY, getSalary(), salary);
        this.salary = salary;
        return this;
    }
    public Employee updateSsn(String ssn){
        ssn = (ssn == null ? null : ssn.trim());
        if(Objects.equals(this.ssn, ssn)){
            return this;
        }
        handleUpdate(SSN_PROPERTY, getSsn(), ssn);
        this.ssn = ssn;
        return this;
    }
    public Employee updateDepartment(Department department){
        if(Objects.equals(this.department, department)){
            return this;
        }
        handleUpdate(DEPARTMENT_PROPERTY, getDepartment(), department);
        this.department = department;
        return this;
    }
    public Employee updateHireDate(LocalDateTime hireDate){
        if(Objects.equals(this.hireDate, hireDate)){
            return this;
        }
        handleUpdate(HIRE_DATE_PROPERTY, getHireDate(), hireDate);
        this.hireDate = hireDate;
        return this;
    }
    public Employee updateStatus(String status){
        status = (status == null ? null : status.trim());
        if(Objects.equals(this.status, status)){
            return this;
        }
        handleUpdate(STATUS_PROPERTY, getStatus(), status);
        this.status = status;
        return this;
    }
    public Employee updateCreateTime(LocalDateTime createTime){
        if(Objects.equals(this.createTime, createTime)){
            return this;
        }
        handleUpdate(CREATE_TIME_PROPERTY, getCreateTime(), createTime);
        this.createTime = createTime;
        return this;
    }
    public Employee updateUpdateTime(LocalDateTime updateTime){
        if(Objects.equals(this.updateTime, updateTime)){
            return this;
        }
        handleUpdate(UPDATE_TIME_PROPERTY, getUpdateTime(), updateTime);
        this.updateTime = updateTime;
        return this;
    }
    public Employee addLeaveRequest(LeaveRequest leaveRequest){
        if (leaveRequest == null){
            return this;
        }

        if(null == this.leaveRequestList){
            this.leaveRequestList = new SmartList<>();
        }

        this.leaveRequestList.add(leaveRequest);
        leaveRequest.cacheRelation(LeaveRequest.EMPLOYEE_PROPERTY, this);
        return this;
    }
    public Employee addAttendance(Attendance attendance){
        if (attendance == null){
            return this;
        }

        if(null == this.attendanceList){
            this.attendanceList = new SmartList<>();
        }

        this.attendanceList.add(attendance);
        attendance.cacheRelation(Attendance.EMPLOYEE_PROPERTY, this);
        return this;
    }
    public Employee addBenefit(Benefit benefit){
        if (benefit == null){
            return this;
        }

        if(null == this.benefitList){
            this.benefitList = new SmartList<>();
        }

        this.benefitList.add(benefit);
        benefit.cacheRelation(Benefit.EMPLOYEE_PROPERTY, this);
        return this;
    }
    public Employee addEmployeeReview(EmployeeReview employeeReview){
        if (employeeReview == null){
            return this;
        }

        if(null == this.employeeReviewList){
            this.employeeReviewList = new SmartList<>();
        }

        this.employeeReviewList.add(employeeReview);
        employeeReview.cacheRelation(EmployeeReview.EMPLOYEE_PROPERTY, this);
        return this;
    }
    public Employee addPayroll(Payroll payroll){
        if (payroll == null){
            return this;
        }

        if(null == this.payrollList){
            this.payrollList = new SmartList<>();
        }

        this.payrollList.add(payroll);
        payroll.cacheRelation(Payroll.EMPLOYEE_PROPERTY, this);
        return this;
    }
    public Employee addExpense(Expense expense){
        if (expense == null){
            return this;
        }

        if(null == this.expenseList){
            this.expenseList = new SmartList<>();
        }

        this.expenseList.add(expense);
        expense.cacheRelation(Expense.EMPLOYEE_PROPERTY, this);
        return this;
    }
    public Employee addSupportAgent(SupportAgent supportAgent){
        if (supportAgent == null){
            return this;
        }

        if(null == this.supportAgentList){
            this.supportAgentList = new SmartList<>();
        }

        this.supportAgentList.add(supportAgent);
        supportAgent.cacheRelation(SupportAgent.EMPLOYEE_PROPERTY, this);
        return this;
    }

    public static Employee refer(Long id){
        Employee refer = new Employee();
        refer.__internalSet("id", id);
        refer.set$status(EntityStatus.REFER);
        return refer;
    }
    @Override
    public String typeName(){
        return INTERNAL_TYPE;
    }

    public Employee comment(String comment){
        this.setComment(comment);
        return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Audited<Employee> auditAs(String action) {
        return super.auditAs(action);
    }

    // ===== Framework Internal: generated switch dispatch =====
    @Override
    @FrameworkInternal
    public void __internalSet(String property, Object value) {
        switch (property) {
            case "email": this.email = (value == null ? null : ((String)value).trim()); break;

            case "name": this.name = (value == null ? null : ((String)value).trim()); break;

            case "phone": this.phone = (value == null ? null : ((String)value).trim()); break;

            case "salary": this.salary = (BigDecimal) value; break;

            case "ssn": this.ssn = (value == null ? null : ((String)value).trim()); break;

            case "department": this.department = (Department) value; break;

            case "hireDate": this.hireDate = (LocalDateTime) value; break;

            case "status": this.status = (value == null ? null : ((String)value).trim()); break;

            case "createTime": this.createTime = (LocalDateTime) value; break;

            case "updateTime": this.updateTime = (LocalDateTime) value; break;

            case "leaveRequestList": this.leaveRequestList = (SmartList<LeaveRequest>) value; break;
            case "attendanceList": this.attendanceList = (SmartList<Attendance>) value; break;
            case "benefitList": this.benefitList = (SmartList<Benefit>) value; break;
            case "employeeReviewList": this.employeeReviewList = (SmartList<EmployeeReview>) value; break;
            case "payrollList": this.payrollList = (SmartList<Payroll>) value; break;
            case "expenseList": this.expenseList = (SmartList<Expense>) value; break;
            case "supportAgentList": this.supportAgentList = (SmartList<SupportAgent>) value; break;
            default: super.__internalSet(property, value);
        }
    }

    @Override
    @FrameworkInternal
    public Object __internalGet(String property) {
        switch (property) {
            case "email": return this.email;
            case "name": return this.name;
            case "phone": return this.phone;
            case "salary": return this.salary;
            case "ssn": return this.ssn;
            case "department": return this.department;
            case "hireDate": return this.hireDate;
            case "status": return this.status;
            case "createTime": return this.createTime;
            case "updateTime": return this.updateTime;
            case "leaveRequestList": return this.leaveRequestList;
            case "attendanceList": return this.attendanceList;
            case "benefitList": return this.benefitList;
            case "employeeReviewList": return this.employeeReviewList;
            case "payrollList": return this.payrollList;
            case "expenseList": return this.expenseList;
            case "supportAgentList": return this.supportAgentList;
            default: return super.__internalGet(property);
        }
    }

}