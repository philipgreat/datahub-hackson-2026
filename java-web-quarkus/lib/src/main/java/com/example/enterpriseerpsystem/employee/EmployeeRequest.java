
package com.example.enterpriseerpsystem.employee;

import com.example.enterpriseerpsystem.Q;
import com.example.enterpriseerpsystem.attendance.Attendance;
import com.example.enterpriseerpsystem.attendance.AttendanceRequest;
import com.example.enterpriseerpsystem.benefit.Benefit;
import com.example.enterpriseerpsystem.benefit.BenefitRequest;
import com.example.enterpriseerpsystem.department.Department;
import com.example.enterpriseerpsystem.department.DepartmentRequest;
import com.example.enterpriseerpsystem.employeereview.EmployeeReview;
import com.example.enterpriseerpsystem.employeereview.EmployeeReviewRequest;
import com.example.enterpriseerpsystem.expense.Expense;
import com.example.enterpriseerpsystem.expense.ExpenseRequest;
import com.example.enterpriseerpsystem.leaverequest.LeaveRequest;
import com.example.enterpriseerpsystem.leaverequest.LeaveRequestRequest;
import com.example.enterpriseerpsystem.payroll.Payroll;
import com.example.enterpriseerpsystem.payroll.PayrollRequest;
import com.example.enterpriseerpsystem.supportagent.SupportAgent;
import com.example.enterpriseerpsystem.supportagent.SupportAgentRequest;
import io.teaql.core.AggrFunction;
import io.teaql.core.BaseRequest;
import io.teaql.core.PropertyReference;
import io.teaql.core.SearchCriteria;
import io.teaql.core.SubQuerySearchCriteria;
import io.teaql.core.criteria.Operator;
import io.teaql.core.criteria.TwoOperatorCriteria;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

public class EmployeeRequest<T extends Employee> extends BaseRequest<T> {

    /**
     * @deprecated AI agents and business code must use the generated Q facade
     *             instead of constructing request builders directly.
     */
    @Deprecated
    public EmployeeRequest(Class<T> returnType){
        super(returnType);
        selectId();
        selectVersion();
    }

    public EmployeeRequest<T> comment(String comment){
         super.internalComment(comment);
         return this;
    }

    // purpose() 继承自 BaseRequest，返回 ExecutableRequest（终结方法）

    public EmployeeRequest<T> returnType(Class<? extends T> returnType){
        super.setReturnType(returnType);
        return this;
    }

    public EmployeeRequest<T> enableAggregationCache(long cacheExpiredMillis){
        super.enableAggregationCache();
        super.aggregateCacheTime(cacheExpiredMillis);
        return this;
    }

    public EmployeeRequest<T> enableAggregationCache(){
        return enableAggregationCache(0l);
    }


    public EmployeeRequest<T> propagateAggregationCache(long cacheExpiredMillis){
        super.propagateAggregationCache(cacheExpiredMillis);
        return this;
    }

    public EmployeeRequest<T> appendSearchCriteria(SearchCriteria searchCriteria){
        return (EmployeeRequest<T>)super.appendSearchCriteria(searchCriteria);
    }

    public EmployeeRequest<T> filter(String property1, Operator operator, String property2){
        return appendSearchCriteria(new TwoOperatorCriteria(operator, new PropertyReference(property1), new PropertyReference(property2)));
    }


    public EmployeeRequest<T> matchingAnyOf(EmployeeRequest employee){
        super.internalMatchAny(employee);
        return this;
    }

    public EmployeeRequest<T> enhanceChildrenIfNeeded(){
        return this;
    }

    public EmployeeRequest<T> withDeletedRows(){
        super.withDeletedRows();
        return this;
    }

    public EmployeeRequest<T> deletedRowsOnly(){
        super.deletedRowsOnly();
        return this;
    }

    public EmployeeRequest<T> selectSelf(){
        super.selectSelf();
        return selectId().selectEmail().selectName().selectPhone().selectSalary().selectSsn().selectDepartmentIdOnly().selectHireDate().selectStatus().selectCreateTime().selectUpdateTime().selectVersion();
    }

    public EmployeeRequest<T> selectSelfFields(){
        return selectSelf();
    }

    public EmployeeRequest<T> selectAll(){
        super.selectAll();
        return selectId().selectEmail().selectName().selectPhone().selectSalary().selectSsn().selectDepartment().selectHireDate().selectStatus().selectCreateTime().selectUpdateTime().selectVersion();
    }

    public EmployeeRequest<T> selectChildren(){
        super.selectAny();
        selectLeaveRequestList().selectAttendanceList().selectBenefitList().selectEmployeeReviewList().selectPayrollList().selectExpenseList().selectSupportAgentList();
        return selectId().selectEmail().selectName().selectPhone().selectSalary().selectSsn().selectDepartment().selectHireDate().selectStatus().selectCreateTime().selectUpdateTime().selectVersion();
    }


    public EmployeeRequest<T> selectId(){
       selectProperty(Employee.ID_PROPERTY);
       return this;
    }

    /**
     * fill the id with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  id) to fetch id property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public EmployeeRequest<T> unselectId(){
       unselectProperty(Employee.ID_PROPERTY);
       return this;
    }
    public EmployeeRequest<T> selectEmail(){
       selectProperty(Employee.EMAIL_PROPERTY);
       return this;
    }

    /**
     * fill the email with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  email) to fetch email property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public EmployeeRequest<T> unselectEmail(){
       unselectProperty(Employee.EMAIL_PROPERTY);
       return this;
    }
    public EmployeeRequest<T> selectName(){
       selectProperty(Employee.NAME_PROPERTY);
       return this;
    }

    /**
     * fill the name with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  name) to fetch name property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public EmployeeRequest<T> unselectName(){
       unselectProperty(Employee.NAME_PROPERTY);
       return this;
    }
    public EmployeeRequest<T> selectPhone(){
       selectProperty(Employee.PHONE_PROPERTY);
       return this;
    }

    /**
     * fill the phone with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  phone) to fetch phone property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public EmployeeRequest<T> unselectPhone(){
       unselectProperty(Employee.PHONE_PROPERTY);
       return this;
    }
    public EmployeeRequest<T> selectSalary(){
       selectProperty(Employee.SALARY_PROPERTY);
       return this;
    }

    /**
     * fill the salary with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  salary) to fetch salary property.
     * @param rawSqlSegment  customized rawSqlSegment
     */


    /**
     * fill the salary with customized aggrFunction, TEAQL uses ({aggrFunction}(salary) AS salary to fetch salary property.
     * @param aggrFunction  aggrFunction
     */
    public EmployeeRequest<T> selectSalary(AggrFunction aggrFunction){
       selectProperty(Employee.SALARY_PROPERTY, aggrFunction);
       return this;
    }


    public EmployeeRequest<T> unselectSalary(){
       unselectProperty(Employee.SALARY_PROPERTY);
       return this;
    }
    public EmployeeRequest<T> selectSsn(){
       selectProperty(Employee.SSN_PROPERTY);
       return this;
    }

    /**
     * fill the ssn with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  ssn) to fetch ssn property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public EmployeeRequest<T> unselectSsn(){
       unselectProperty(Employee.SSN_PROPERTY);
       return this;
    }
    public EmployeeRequest<T> selectDepartmentIdOnly(){
       selectProperty(Employee.DEPARTMENT_PROPERTY);
       return this;
    }

    public EmployeeRequest<T> selectDepartment(){
        return selectDepartmentWith(Q.departments().unlimited().selectSelf());
    }

    public EmployeeRequest<T> selectDepartmentWith(DepartmentRequest department){
       selectProperty(Employee.DEPARTMENT_PROPERTY);
       enhanceRelation(Employee.DEPARTMENT_PROPERTY, department);
       return this;
    }

    public EmployeeRequest<T> unselectDepartment(){
       unselectProperty(Employee.DEPARTMENT_PROPERTY);
       return this;
    }
    public EmployeeRequest<T> selectHireDate(){
       selectProperty(Employee.HIRE_DATE_PROPERTY);
       return this;
    }

    /**
     * fill the hireDate with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  hireDate) to fetch hireDate property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public EmployeeRequest<T> unselectHireDate(){
       unselectProperty(Employee.HIRE_DATE_PROPERTY);
       return this;
    }
    public EmployeeRequest<T> selectStatus(){
       selectProperty(Employee.STATUS_PROPERTY);
       return this;
    }

    /**
     * fill the status with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  status) to fetch status property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public EmployeeRequest<T> unselectStatus(){
       unselectProperty(Employee.STATUS_PROPERTY);
       return this;
    }
    public EmployeeRequest<T> selectCreateTime(){
       selectProperty(Employee.CREATE_TIME_PROPERTY);
       return this;
    }

    /**
     * fill the createTime with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  createTime) to fetch createTime property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public EmployeeRequest<T> unselectCreateTime(){
       unselectProperty(Employee.CREATE_TIME_PROPERTY);
       return this;
    }
    public EmployeeRequest<T> selectUpdateTime(){
       selectProperty(Employee.UPDATE_TIME_PROPERTY);
       return this;
    }

    /**
     * fill the updateTime with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  updateTime) to fetch updateTime property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public EmployeeRequest<T> unselectUpdateTime(){
       unselectProperty(Employee.UPDATE_TIME_PROPERTY);
       return this;
    }
    public EmployeeRequest<T> selectVersion(){
       selectProperty(Employee.VERSION_PROPERTY);
       return this;
    }

    /**
     * fill the version with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  version) to fetch version property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public EmployeeRequest<T> unselectVersion(){
       unselectProperty(Employee.VERSION_PROPERTY);
       return this;
    }
    public EmployeeRequest<T> selectLeaveRequestList(){
       return selectLeaveRequestListWith(Q.leaveRequests().selectSelf());
    }

    public EmployeeRequest<T> selectLeaveRequestListWith(LeaveRequestRequest leaveRequestList){
       enhanceRelation(Employee.LEAVE_REQUEST_LIST_PROPERTY, leaveRequestList);
       return this;
    }
    public EmployeeRequest<T> selectAttendanceList(){
       return selectAttendanceListWith(Q.attendances().selectSelf());
    }

    public EmployeeRequest<T> selectAttendanceListWith(AttendanceRequest attendanceList){
       enhanceRelation(Employee.ATTENDANCE_LIST_PROPERTY, attendanceList);
       return this;
    }
    public EmployeeRequest<T> selectBenefitList(){
       return selectBenefitListWith(Q.benefits().selectSelf());
    }

    public EmployeeRequest<T> selectBenefitListWith(BenefitRequest benefitList){
       enhanceRelation(Employee.BENEFIT_LIST_PROPERTY, benefitList);
       return this;
    }
    public EmployeeRequest<T> selectEmployeeReviewList(){
       return selectEmployeeReviewListWith(Q.employeeReviews().selectSelf());
    }

    public EmployeeRequest<T> selectEmployeeReviewListWith(EmployeeReviewRequest employeeReviewList){
       enhanceRelation(Employee.EMPLOYEE_REVIEW_LIST_PROPERTY, employeeReviewList);
       return this;
    }
    public EmployeeRequest<T> selectPayrollList(){
       return selectPayrollListWith(Q.payrolls().selectSelf());
    }

    public EmployeeRequest<T> selectPayrollListWith(PayrollRequest payrollList){
       enhanceRelation(Employee.PAYROLL_LIST_PROPERTY, payrollList);
       return this;
    }
    public EmployeeRequest<T> selectExpenseList(){
       return selectExpenseListWith(Q.expenses().selectSelf());
    }

    public EmployeeRequest<T> selectExpenseListWith(ExpenseRequest expenseList){
       enhanceRelation(Employee.EXPENSE_LIST_PROPERTY, expenseList);
       return this;
    }
    public EmployeeRequest<T> selectSupportAgentList(){
       return selectSupportAgentListWith(Q.supportAgents().selectSelf());
    }

    public EmployeeRequest<T> selectSupportAgentListWith(SupportAgentRequest supportAgentList){
       enhanceRelation(Employee.SUPPORT_AGENT_LIST_PROPERTY, supportAgentList);
       return this;
    }

    public EmployeeRequest<T> withId(Operator operator, Object... values){
       return appendSearchCriteria(createIdCriteria(operator, values));
    }

    public SearchCriteria createIdCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Employee.ID_PROPERTY, operator, values);
    }

    public EmployeeRequest<T> withIdIs(Long id){
       return withId(Operator.EQUAL, id);
    }
    public EmployeeRequest<T> withIdIn(Long... id){
       return withId(Operator.EQUAL, (Object[])id);
    }



    public EmployeeRequest<T> filterByEmail(String... email){
      if (email == null || email.length == 0) {
        throw new IllegalArgumentException("filterByEmail parameter email cannot be empty");
      }
      return appendSearchCriteria(createEmailCriteria(Operator.EQUAL, (Object[])email));
    }

    public EmployeeRequest<T> withEmail(Operator operator, Object... values){
       return appendSearchCriteria(createEmailCriteria(operator, values));
    }

    public EmployeeRequest<T> withEmailIsUnknown(){
       return withEmail(Operator.IS_NULL);
    }

    public EmployeeRequest<T> withEmailIsKnown(){
       return withEmail(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createEmailCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Employee.EMAIL_PROPERTY, operator, values);
    }

    public EmployeeRequest<T> withEmailGreaterThan(String email){
       return withEmail(Operator.GREATER_THAN, email);
    }

    public EmployeeRequest<T> withEmailGreaterThanOrEqualTo(String email){
       return withEmail(Operator.GREATER_THAN_OR_EQUAL, email);
    }

    public EmployeeRequest<T> withEmailLessThan(String email){
       return withEmail(Operator.LESS_THAN, email);
    }

    public EmployeeRequest<T> withEmailLessThanOrEqualTo(String email){
       return withEmail(Operator.LESS_THAN_OR_EQUAL, email);
    }

    public EmployeeRequest<T> withEmailBetween(String startOfEmail, String endOfEmail){
       return withEmail(Operator.BETWEEN, startOfEmail, endOfEmail);
    }
    public EmployeeRequest<T> withEmailStartingWith(String email){
       return withEmail(Operator.BEGIN_WITH, email);
    }
    public EmployeeRequest<T> withEmailContaining(String email){
       return withEmail(Operator.CONTAIN, email);
    }

    public EmployeeRequest<T> withEmailEndingWith(String email){
       return withEmail(Operator.END_WITH, email);
    }

    public EmployeeRequest<T> withEmailIs(String email){
       return withEmail(Operator.EQUAL, email);
    }

    public EmployeeRequest<T> withEmailSoundingLike(String email){
       return withEmail(Operator.SOUNDS_LIKE, email);
    }



    public EmployeeRequest<T> filterByName(String... name){
      if (name == null || name.length == 0) {
        throw new IllegalArgumentException("filterByName parameter name cannot be empty");
      }
      return appendSearchCriteria(createNameCriteria(Operator.EQUAL, (Object[])name));
    }

    public EmployeeRequest<T> withName(Operator operator, Object... values){
       return appendSearchCriteria(createNameCriteria(operator, values));
    }

    public EmployeeRequest<T> withNameIsUnknown(){
       return withName(Operator.IS_NULL);
    }

    public EmployeeRequest<T> withNameIsKnown(){
       return withName(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createNameCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Employee.NAME_PROPERTY, operator, values);
    }

    public EmployeeRequest<T> withNameGreaterThan(String name){
       return withName(Operator.GREATER_THAN, name);
    }

    public EmployeeRequest<T> withNameGreaterThanOrEqualTo(String name){
       return withName(Operator.GREATER_THAN_OR_EQUAL, name);
    }

    public EmployeeRequest<T> withNameLessThan(String name){
       return withName(Operator.LESS_THAN, name);
    }

    public EmployeeRequest<T> withNameLessThanOrEqualTo(String name){
       return withName(Operator.LESS_THAN_OR_EQUAL, name);
    }

    public EmployeeRequest<T> withNameBetween(String startOfName, String endOfName){
       return withName(Operator.BETWEEN, startOfName, endOfName);
    }
    public EmployeeRequest<T> withNameStartingWith(String name){
       return withName(Operator.BEGIN_WITH, name);
    }
    public EmployeeRequest<T> withNameContaining(String name){
       return withName(Operator.CONTAIN, name);
    }

    public EmployeeRequest<T> withNameEndingWith(String name){
       return withName(Operator.END_WITH, name);
    }

    public EmployeeRequest<T> withNameIs(String name){
       return withName(Operator.EQUAL, name);
    }

    public EmployeeRequest<T> withNameSoundingLike(String name){
       return withName(Operator.SOUNDS_LIKE, name);
    }



    public EmployeeRequest<T> filterByPhone(String... phone){
      if (phone == null || phone.length == 0) {
        throw new IllegalArgumentException("filterByPhone parameter phone cannot be empty");
      }
      return appendSearchCriteria(createPhoneCriteria(Operator.EQUAL, (Object[])phone));
    }

    public EmployeeRequest<T> withPhone(Operator operator, Object... values){
       return appendSearchCriteria(createPhoneCriteria(operator, values));
    }

    public EmployeeRequest<T> withPhoneIsUnknown(){
       return withPhone(Operator.IS_NULL);
    }

    public EmployeeRequest<T> withPhoneIsKnown(){
       return withPhone(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createPhoneCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Employee.PHONE_PROPERTY, operator, values);
    }

    public EmployeeRequest<T> withPhoneGreaterThan(String phone){
       return withPhone(Operator.GREATER_THAN, phone);
    }

    public EmployeeRequest<T> withPhoneGreaterThanOrEqualTo(String phone){
       return withPhone(Operator.GREATER_THAN_OR_EQUAL, phone);
    }

    public EmployeeRequest<T> withPhoneLessThan(String phone){
       return withPhone(Operator.LESS_THAN, phone);
    }

    public EmployeeRequest<T> withPhoneLessThanOrEqualTo(String phone){
       return withPhone(Operator.LESS_THAN_OR_EQUAL, phone);
    }

    public EmployeeRequest<T> withPhoneBetween(String startOfPhone, String endOfPhone){
       return withPhone(Operator.BETWEEN, startOfPhone, endOfPhone);
    }
    public EmployeeRequest<T> withPhoneStartingWith(String phone){
       return withPhone(Operator.BEGIN_WITH, phone);
    }
    public EmployeeRequest<T> withPhoneContaining(String phone){
       return withPhone(Operator.CONTAIN, phone);
    }

    public EmployeeRequest<T> withPhoneEndingWith(String phone){
       return withPhone(Operator.END_WITH, phone);
    }

    public EmployeeRequest<T> withPhoneIs(String phone){
       return withPhone(Operator.EQUAL, phone);
    }

    public EmployeeRequest<T> withPhoneSoundingLike(String phone){
       return withPhone(Operator.SOUNDS_LIKE, phone);
    }



    public EmployeeRequest<T> filterBySalary(BigDecimal... salary){
      if (salary == null || salary.length == 0) {
        throw new IllegalArgumentException("filterBySalary parameter salary cannot be empty");
      }
      return appendSearchCriteria(createSalaryCriteria(Operator.EQUAL, (Object[])salary));
    }

    public EmployeeRequest<T> withSalary(Operator operator, Object... values){
       return appendSearchCriteria(createSalaryCriteria(operator, values));
    }

    public EmployeeRequest<T> withSalaryIsUnknown(){
       return withSalary(Operator.IS_NULL);
    }

    public EmployeeRequest<T> withSalaryIsKnown(){
       return withSalary(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createSalaryCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Employee.SALARY_PROPERTY, operator, values);
    }

    public EmployeeRequest<T> withSalaryGreaterThan(BigDecimal salary){
       return withSalary(Operator.GREATER_THAN, salary);
    }

    public EmployeeRequest<T> withSalaryGreaterThanOrEqualTo(BigDecimal salary){
       return withSalary(Operator.GREATER_THAN_OR_EQUAL, salary);
    }

    public EmployeeRequest<T> withSalaryLessThan(BigDecimal salary){
       return withSalary(Operator.LESS_THAN, salary);
    }

    public EmployeeRequest<T> withSalaryLessThanOrEqualTo(BigDecimal salary){
       return withSalary(Operator.LESS_THAN_OR_EQUAL, salary);
    }

    public EmployeeRequest<T> withSalaryBetween(BigDecimal startOfSalary, BigDecimal endOfSalary){
       return withSalary(Operator.BETWEEN, startOfSalary, endOfSalary);
    }



    public EmployeeRequest<T> filterBySsn(String... ssn){
      if (ssn == null || ssn.length == 0) {
        throw new IllegalArgumentException("filterBySsn parameter ssn cannot be empty");
      }
      return appendSearchCriteria(createSsnCriteria(Operator.EQUAL, (Object[])ssn));
    }

    public EmployeeRequest<T> withSsn(Operator operator, Object... values){
       return appendSearchCriteria(createSsnCriteria(operator, values));
    }

    public EmployeeRequest<T> withSsnIsUnknown(){
       return withSsn(Operator.IS_NULL);
    }

    public EmployeeRequest<T> withSsnIsKnown(){
       return withSsn(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createSsnCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Employee.SSN_PROPERTY, operator, values);
    }

    public EmployeeRequest<T> withSsnGreaterThan(String ssn){
       return withSsn(Operator.GREATER_THAN, ssn);
    }

    public EmployeeRequest<T> withSsnGreaterThanOrEqualTo(String ssn){
       return withSsn(Operator.GREATER_THAN_OR_EQUAL, ssn);
    }

    public EmployeeRequest<T> withSsnLessThan(String ssn){
       return withSsn(Operator.LESS_THAN, ssn);
    }

    public EmployeeRequest<T> withSsnLessThanOrEqualTo(String ssn){
       return withSsn(Operator.LESS_THAN_OR_EQUAL, ssn);
    }

    public EmployeeRequest<T> withSsnBetween(String startOfSsn, String endOfSsn){
       return withSsn(Operator.BETWEEN, startOfSsn, endOfSsn);
    }
    public EmployeeRequest<T> withSsnStartingWith(String ssn){
       return withSsn(Operator.BEGIN_WITH, ssn);
    }
    public EmployeeRequest<T> withSsnContaining(String ssn){
       return withSsn(Operator.CONTAIN, ssn);
    }

    public EmployeeRequest<T> withSsnEndingWith(String ssn){
       return withSsn(Operator.END_WITH, ssn);
    }

    public EmployeeRequest<T> withSsnIs(String ssn){
       return withSsn(Operator.EQUAL, ssn);
    }

    public EmployeeRequest<T> withSsnSoundingLike(String ssn){
       return withSsn(Operator.SOUNDS_LIKE, ssn);
    }



    public EmployeeRequest<T> filterByDepartment(Department... department){
      if (department == null || department.length == 0) {
        throw new IllegalArgumentException("filterByDepartment parameter department cannot be empty");
      }
      return appendSearchCriteria(createDepartmentCriteria(Operator.EQUAL, (Object[])department));
    }

    public EmployeeRequest<T> withDepartment(Operator operator, Object... values){
       return appendSearchCriteria(createDepartmentCriteria(operator, values));
    }

    public EmployeeRequest<T> withDepartmentIsUnknown(){
       return withDepartment(Operator.IS_NULL);
    }

    public EmployeeRequest<T> withDepartmentIsKnown(){
       return withDepartment(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createDepartmentCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Employee.DEPARTMENT_PROPERTY, operator, values);
    }

    public EmployeeRequest<T> filterByDepartment(Long department){
      if(department == null){
         return this;
      }
      return withDepartment(Operator.EQUAL, department);
    }
    public EmployeeRequest<T> withDepartmentMatching(DepartmentRequest department){
       return appendSearchCriteria(new SubQuerySearchCriteria(Employee.DEPARTMENT_PROPERTY, department, Department.ID_PROPERTY));
    }

    public EmployeeRequest<T> filterByHireDate(LocalDateTime... hireDate){
      if (hireDate == null || hireDate.length == 0) {
        throw new IllegalArgumentException("filterByHireDate parameter hireDate cannot be empty");
      }
      return appendSearchCriteria(createHireDateCriteria(Operator.EQUAL, (Object[])hireDate));
    }

    public EmployeeRequest<T> withHireDate(Operator operator, Object... values){
       return appendSearchCriteria(createHireDateCriteria(operator, values));
    }

    public EmployeeRequest<T> withHireDateIsUnknown(){
       return withHireDate(Operator.IS_NULL);
    }

    public EmployeeRequest<T> withHireDateIsKnown(){
       return withHireDate(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createHireDateCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Employee.HIRE_DATE_PROPERTY, operator, values);
    }

    public EmployeeRequest<T> withHireDateGreaterThan(LocalDateTime hireDate){
       return withHireDate(Operator.GREATER_THAN, hireDate);
    }

    public EmployeeRequest<T> withHireDateGreaterThanOrEqualTo(LocalDateTime hireDate){
       return withHireDate(Operator.GREATER_THAN_OR_EQUAL, hireDate);
    }

    public EmployeeRequest<T> withHireDateLessThan(LocalDateTime hireDate){
       return withHireDate(Operator.LESS_THAN, hireDate);
    }

    public EmployeeRequest<T> withHireDateLessThanOrEqualTo(LocalDateTime hireDate){
       return withHireDate(Operator.LESS_THAN_OR_EQUAL, hireDate);
    }

    public EmployeeRequest<T> withHireDateBetween(LocalDateTime startOfHireDate, LocalDateTime endOfHireDate){
       return withHireDate(Operator.BETWEEN, startOfHireDate, endOfHireDate);
    }
    public EmployeeRequest<T> withHireDateBefore(LocalDateTime hireDate){
       return withHireDate(Operator.LESS_THAN, hireDate);
    }

    public EmployeeRequest<T> withHireDateBefore(Date hireDate){
       return withHireDate(Operator.LESS_THAN, hireDate);
    }

    public EmployeeRequest<T> withHireDateAfter(LocalDateTime hireDate){
       return withHireDate(Operator.GREATER_THAN, hireDate);
    }

    public EmployeeRequest<T> withHireDateAfter(Date hireDate){
       return withHireDate(Operator.GREATER_THAN, hireDate);
    }

    public EmployeeRequest<T> withHireDateBetween(Date startOfHireDate, Date endOfHireDate){
       return withHireDate(Operator.BETWEEN, startOfHireDate, endOfHireDate);
    }




    public EmployeeRequest<T> filterByStatus(String... status){
      if (status == null || status.length == 0) {
        throw new IllegalArgumentException("filterByStatus parameter status cannot be empty");
      }
      return appendSearchCriteria(createStatusCriteria(Operator.EQUAL, (Object[])status));
    }

    public EmployeeRequest<T> withStatus(Operator operator, Object... values){
       return appendSearchCriteria(createStatusCriteria(operator, values));
    }

    public EmployeeRequest<T> withStatusIsUnknown(){
       return withStatus(Operator.IS_NULL);
    }

    public EmployeeRequest<T> withStatusIsKnown(){
       return withStatus(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createStatusCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Employee.STATUS_PROPERTY, operator, values);
    }

    public EmployeeRequest<T> withStatusGreaterThan(String status){
       return withStatus(Operator.GREATER_THAN, status);
    }

    public EmployeeRequest<T> withStatusGreaterThanOrEqualTo(String status){
       return withStatus(Operator.GREATER_THAN_OR_EQUAL, status);
    }

    public EmployeeRequest<T> withStatusLessThan(String status){
       return withStatus(Operator.LESS_THAN, status);
    }

    public EmployeeRequest<T> withStatusLessThanOrEqualTo(String status){
       return withStatus(Operator.LESS_THAN_OR_EQUAL, status);
    }

    public EmployeeRequest<T> withStatusBetween(String startOfStatus, String endOfStatus){
       return withStatus(Operator.BETWEEN, startOfStatus, endOfStatus);
    }
    public EmployeeRequest<T> withStatusStartingWith(String status){
       return withStatus(Operator.BEGIN_WITH, status);
    }
    public EmployeeRequest<T> withStatusContaining(String status){
       return withStatus(Operator.CONTAIN, status);
    }

    public EmployeeRequest<T> withStatusEndingWith(String status){
       return withStatus(Operator.END_WITH, status);
    }

    public EmployeeRequest<T> withStatusIs(String status){
       return withStatus(Operator.EQUAL, status);
    }

    public EmployeeRequest<T> withStatusSoundingLike(String status){
       return withStatus(Operator.SOUNDS_LIKE, status);
    }



    public EmployeeRequest<T> filterByCreateTime(LocalDateTime... createTime){
      if (createTime == null || createTime.length == 0) {
        throw new IllegalArgumentException("filterByCreateTime parameter createTime cannot be empty");
      }
      return appendSearchCriteria(createCreateTimeCriteria(Operator.EQUAL, (Object[])createTime));
    }

    public EmployeeRequest<T> withCreateTime(Operator operator, Object... values){
       return appendSearchCriteria(createCreateTimeCriteria(operator, values));
    }

    public EmployeeRequest<T> withCreateTimeIsUnknown(){
       return withCreateTime(Operator.IS_NULL);
    }

    public EmployeeRequest<T> withCreateTimeIsKnown(){
       return withCreateTime(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createCreateTimeCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Employee.CREATE_TIME_PROPERTY, operator, values);
    }

    public EmployeeRequest<T> withCreateTimeGreaterThan(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public EmployeeRequest<T> withCreateTimeGreaterThanOrEqualTo(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN_OR_EQUAL, createTime);
    }

    public EmployeeRequest<T> withCreateTimeLessThan(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public EmployeeRequest<T> withCreateTimeLessThanOrEqualTo(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN_OR_EQUAL, createTime);
    }

    public EmployeeRequest<T> withCreateTimeBetween(LocalDateTime startOfCreateTime, LocalDateTime endOfCreateTime){
       return withCreateTime(Operator.BETWEEN, startOfCreateTime, endOfCreateTime);
    }
    public EmployeeRequest<T> withCreateTimeBefore(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public EmployeeRequest<T> withCreateTimeBefore(Date createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public EmployeeRequest<T> withCreateTimeAfter(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public EmployeeRequest<T> withCreateTimeAfter(Date createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public EmployeeRequest<T> withCreateTimeBetween(Date startOfCreateTime, Date endOfCreateTime){
       return withCreateTime(Operator.BETWEEN, startOfCreateTime, endOfCreateTime);
    }




    public EmployeeRequest<T> filterByUpdateTime(LocalDateTime... updateTime){
      if (updateTime == null || updateTime.length == 0) {
        throw new IllegalArgumentException("filterByUpdateTime parameter updateTime cannot be empty");
      }
      return appendSearchCriteria(createUpdateTimeCriteria(Operator.EQUAL, (Object[])updateTime));
    }

    public EmployeeRequest<T> withUpdateTime(Operator operator, Object... values){
       return appendSearchCriteria(createUpdateTimeCriteria(operator, values));
    }

    public EmployeeRequest<T> withUpdateTimeIsUnknown(){
       return withUpdateTime(Operator.IS_NULL);
    }

    public EmployeeRequest<T> withUpdateTimeIsKnown(){
       return withUpdateTime(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createUpdateTimeCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Employee.UPDATE_TIME_PROPERTY, operator, values);
    }

    public EmployeeRequest<T> withUpdateTimeGreaterThan(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public EmployeeRequest<T> withUpdateTimeGreaterThanOrEqualTo(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN_OR_EQUAL, updateTime);
    }

    public EmployeeRequest<T> withUpdateTimeLessThan(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public EmployeeRequest<T> withUpdateTimeLessThanOrEqualTo(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN_OR_EQUAL, updateTime);
    }

    public EmployeeRequest<T> withUpdateTimeBetween(LocalDateTime startOfUpdateTime, LocalDateTime endOfUpdateTime){
       return withUpdateTime(Operator.BETWEEN, startOfUpdateTime, endOfUpdateTime);
    }
    public EmployeeRequest<T> withUpdateTimeBefore(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public EmployeeRequest<T> withUpdateTimeBefore(Date updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public EmployeeRequest<T> withUpdateTimeAfter(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public EmployeeRequest<T> withUpdateTimeAfter(Date updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public EmployeeRequest<T> withUpdateTimeBetween(Date startOfUpdateTime, Date endOfUpdateTime){
       return withUpdateTime(Operator.BETWEEN, startOfUpdateTime, endOfUpdateTime);
    }




    public EmployeeRequest<T> filterByVersion(Long... version){
      if (version == null || version.length == 0) {
        throw new IllegalArgumentException("filterByVersion parameter version cannot be empty");
      }
      return appendSearchCriteria(createVersionCriteria(Operator.EQUAL, (Object[])version));
    }

    public EmployeeRequest<T> withVersion(Operator operator, Object... values){
       return appendSearchCriteria(createVersionCriteria(operator, values));
    }

    public EmployeeRequest<T> withVersionIsUnknown(){
       return withVersion(Operator.IS_NULL);
    }

    public EmployeeRequest<T> withVersionIsKnown(){
       return withVersion(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createVersionCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Employee.VERSION_PROPERTY, operator, values);
    }

    public EmployeeRequest<T> withVersionGreaterThan(Long version){
       return withVersion(Operator.GREATER_THAN, version);
    }

    public EmployeeRequest<T> withVersionGreaterThanOrEqualTo(Long version){
       return withVersion(Operator.GREATER_THAN_OR_EQUAL, version);
    }

    public EmployeeRequest<T> withVersionLessThan(Long version){
       return withVersion(Operator.LESS_THAN, version);
    }

    public EmployeeRequest<T> withVersionLessThanOrEqualTo(Long version){
       return withVersion(Operator.LESS_THAN_OR_EQUAL, version);
    }

    public EmployeeRequest<T> withVersionBetween(Long startOfVersion, Long endOfVersion){
       return withVersion(Operator.BETWEEN, startOfVersion, endOfVersion);
    }

    public EmployeeRequest<T> withLeaveRequestListMatching(LeaveRequestRequest leaveRequestRequest){
        return appendSearchCriteria(new SubQuerySearchCriteria(Employee.ID_PROPERTY, leaveRequestRequest, LeaveRequest.EMPLOYEE_PROPERTY));
    }

    public EmployeeRequest<T> withoutLeaveRequestListMatching(LeaveRequestRequest leaveRequestRequest){
        return appendSearchCriteria(SearchCriteria.not(new SubQuerySearchCriteria(Employee.ID_PROPERTY, leaveRequestRequest, LeaveRequest.EMPLOYEE_PROPERTY)));
    }

    public EmployeeRequest<T> haveLeaveRequests(){
        return withLeaveRequestListMatching(Q.leaveRequests().unlimited());
    }

    public EmployeeRequest<T> haveNoLeaveRequests(){
        return withoutLeaveRequestListMatching(Q.leaveRequests().unlimited());
    }
    public EmployeeRequest<T> withAttendanceListMatching(AttendanceRequest attendanceRequest){
        return appendSearchCriteria(new SubQuerySearchCriteria(Employee.ID_PROPERTY, attendanceRequest, Attendance.EMPLOYEE_PROPERTY));
    }

    public EmployeeRequest<T> withoutAttendanceListMatching(AttendanceRequest attendanceRequest){
        return appendSearchCriteria(SearchCriteria.not(new SubQuerySearchCriteria(Employee.ID_PROPERTY, attendanceRequest, Attendance.EMPLOYEE_PROPERTY)));
    }

    public EmployeeRequest<T> haveAttendances(){
        return withAttendanceListMatching(Q.attendances().unlimited());
    }

    public EmployeeRequest<T> haveNoAttendances(){
        return withoutAttendanceListMatching(Q.attendances().unlimited());
    }
    public EmployeeRequest<T> withBenefitListMatching(BenefitRequest benefitRequest){
        return appendSearchCriteria(new SubQuerySearchCriteria(Employee.ID_PROPERTY, benefitRequest, Benefit.EMPLOYEE_PROPERTY));
    }

    public EmployeeRequest<T> withoutBenefitListMatching(BenefitRequest benefitRequest){
        return appendSearchCriteria(SearchCriteria.not(new SubQuerySearchCriteria(Employee.ID_PROPERTY, benefitRequest, Benefit.EMPLOYEE_PROPERTY)));
    }

    public EmployeeRequest<T> haveBenefits(){
        return withBenefitListMatching(Q.benefits().unlimited());
    }

    public EmployeeRequest<T> haveNoBenefits(){
        return withoutBenefitListMatching(Q.benefits().unlimited());
    }
    public EmployeeRequest<T> withEmployeeReviewListMatching(EmployeeReviewRequest employeeReviewRequest){
        return appendSearchCriteria(new SubQuerySearchCriteria(Employee.ID_PROPERTY, employeeReviewRequest, EmployeeReview.EMPLOYEE_PROPERTY));
    }

    public EmployeeRequest<T> withoutEmployeeReviewListMatching(EmployeeReviewRequest employeeReviewRequest){
        return appendSearchCriteria(SearchCriteria.not(new SubQuerySearchCriteria(Employee.ID_PROPERTY, employeeReviewRequest, EmployeeReview.EMPLOYEE_PROPERTY)));
    }

    public EmployeeRequest<T> haveEmployeeReviews(){
        return withEmployeeReviewListMatching(Q.employeeReviews().unlimited());
    }

    public EmployeeRequest<T> haveNoEmployeeReviews(){
        return withoutEmployeeReviewListMatching(Q.employeeReviews().unlimited());
    }
    public EmployeeRequest<T> withPayrollListMatching(PayrollRequest payrollRequest){
        return appendSearchCriteria(new SubQuerySearchCriteria(Employee.ID_PROPERTY, payrollRequest, Payroll.EMPLOYEE_PROPERTY));
    }

    public EmployeeRequest<T> withoutPayrollListMatching(PayrollRequest payrollRequest){
        return appendSearchCriteria(SearchCriteria.not(new SubQuerySearchCriteria(Employee.ID_PROPERTY, payrollRequest, Payroll.EMPLOYEE_PROPERTY)));
    }

    public EmployeeRequest<T> havePayrolls(){
        return withPayrollListMatching(Q.payrolls().unlimited());
    }

    public EmployeeRequest<T> haveNoPayrolls(){
        return withoutPayrollListMatching(Q.payrolls().unlimited());
    }
    public EmployeeRequest<T> withExpenseListMatching(ExpenseRequest expenseRequest){
        return appendSearchCriteria(new SubQuerySearchCriteria(Employee.ID_PROPERTY, expenseRequest, Expense.EMPLOYEE_PROPERTY));
    }

    public EmployeeRequest<T> withoutExpenseListMatching(ExpenseRequest expenseRequest){
        return appendSearchCriteria(SearchCriteria.not(new SubQuerySearchCriteria(Employee.ID_PROPERTY, expenseRequest, Expense.EMPLOYEE_PROPERTY)));
    }

    public EmployeeRequest<T> haveExpenses(){
        return withExpenseListMatching(Q.expenses().unlimited());
    }

    public EmployeeRequest<T> haveNoExpenses(){
        return withoutExpenseListMatching(Q.expenses().unlimited());
    }
    public EmployeeRequest<T> withSupportAgentListMatching(SupportAgentRequest supportAgentRequest){
        return appendSearchCriteria(new SubQuerySearchCriteria(Employee.ID_PROPERTY, supportAgentRequest, SupportAgent.EMPLOYEE_PROPERTY));
    }

    public EmployeeRequest<T> withoutSupportAgentListMatching(SupportAgentRequest supportAgentRequest){
        return appendSearchCriteria(SearchCriteria.not(new SubQuerySearchCriteria(Employee.ID_PROPERTY, supportAgentRequest, SupportAgent.EMPLOYEE_PROPERTY)));
    }

    public EmployeeRequest<T> haveSupportAgents(){
        return withSupportAgentListMatching(Q.supportAgents().unlimited());
    }

    public EmployeeRequest<T> haveNoSupportAgents(){
        return withoutSupportAgentListMatching(Q.supportAgents().unlimited());
    }

    public EmployeeRequest<T> count(){
        super.count();
        return this;
    }
    public EmployeeRequest<T> countAs(String retName){
        super.count(retName);
        return this;
    }
    public EmployeeRequest minSalary(){
        return minSalaryAs(prefix("minOf",Employee.SALARY_PROPERTY));
    }

    public EmployeeRequest minSalaryAs(String retName){
        super.min(retName, Employee.SALARY_PROPERTY);
        return this;
    }
    public EmployeeRequest maxSalary(){
        return maxSalaryAs(prefix("maxOf",Employee.SALARY_PROPERTY));
    }

    public EmployeeRequest maxSalaryAs(String retName){
        super.max(retName, Employee.SALARY_PROPERTY);
        return this;
    }
    public EmployeeRequest sumSalary(){
        return sumSalaryAs(prefix("sumOf",Employee.SALARY_PROPERTY));
    }

    public EmployeeRequest sumSalaryAs(String retName){
        super.sum(retName, Employee.SALARY_PROPERTY);
        return this;
    }
    public EmployeeRequest avgSalary(){
        return avgSalaryAs(prefix("avgOf",Employee.SALARY_PROPERTY));
    }

    public EmployeeRequest avgSalaryAs(String retName){
        super.avg(retName, Employee.SALARY_PROPERTY);
        return this;
    }
    public EmployeeRequest standardDeviationSalary(){
        return standardDeviationSalaryAs(prefix("standardDeviationOf",Employee.SALARY_PROPERTY));
    }

    public EmployeeRequest standardDeviationSalaryAs(String retName){
        super.standardDeviation(retName, Employee.SALARY_PROPERTY);
        return this;
    }
    public EmployeeRequest squareRootOfPopulationStandardDeviationSalary(){
        return squareRootOfPopulationStandardDeviationSalaryAs(prefix("squareRootOfPopulationStandardDeviationOf",Employee.SALARY_PROPERTY));
    }

    public EmployeeRequest squareRootOfPopulationStandardDeviationSalaryAs(String retName){
        super.squareRootOfPopulationStandardDeviation(retName, Employee.SALARY_PROPERTY);
        return this;
    }
    public EmployeeRequest sampleVarianceSalary(){
        return sampleVarianceSalaryAs(prefix("sampleVarianceOf",Employee.SALARY_PROPERTY));
    }

    public EmployeeRequest sampleVarianceSalaryAs(String retName){
        super.sampleVariance(retName, Employee.SALARY_PROPERTY);
        return this;
    }
    public EmployeeRequest samplePopulationVarianceSalary(){
        return samplePopulationVarianceSalaryAs(prefix("samplePopulationVarianceOf",Employee.SALARY_PROPERTY));
    }

    public EmployeeRequest samplePopulationVarianceSalaryAs(String retName){
        super.samplePopulationVariance(retName, Employee.SALARY_PROPERTY);
        return this;
    }
    public EmployeeRequest<T> groupByDepartmentWithDetails(){
       return groupByDepartmentWithDetails(Q.departments().unlimited());
    }

    public EmployeeRequest<T> groupByDepartmentWithDetails(DepartmentRequest subRequest){
       aggregate(Employee.DEPARTMENT_PROPERTY, subRequest);
       return this;
    }






    public EmployeeRequest<T> groupByLeaveRequestsWithDetails(LeaveRequestRequest subRequest){
       aggregate(Employee.LEAVE_REQUEST_LIST_PROPERTY, subRequest);
       return this;
    }
    public EmployeeRequest<T> groupByAttendancesWithDetails(AttendanceRequest subRequest){
       aggregate(Employee.ATTENDANCE_LIST_PROPERTY, subRequest);
       return this;
    }
    public EmployeeRequest<T> groupByBenefitsWithDetails(BenefitRequest subRequest){
       aggregate(Employee.BENEFIT_LIST_PROPERTY, subRequest);
       return this;
    }
    public EmployeeRequest<T> groupByEmployeeReviewsWithDetails(EmployeeReviewRequest subRequest){
       aggregate(Employee.EMPLOYEE_REVIEW_LIST_PROPERTY, subRequest);
       return this;
    }
    public EmployeeRequest<T> groupByPayrollsWithDetails(PayrollRequest subRequest){
       aggregate(Employee.PAYROLL_LIST_PROPERTY, subRequest);
       return this;
    }
    public EmployeeRequest<T> groupByExpensesWithDetails(ExpenseRequest subRequest){
       aggregate(Employee.EXPENSE_LIST_PROPERTY, subRequest);
       return this;
    }
    public EmployeeRequest<T> groupBySupportAgentsWithDetails(SupportAgentRequest subRequest){
       aggregate(Employee.SUPPORT_AGENT_LIST_PROPERTY, subRequest);
       return this;
    }

    public EmployeeRequest<T> groupById(){
       groupBy(Employee.ID_PROPERTY);
       return this;
    }

    public EmployeeRequest<T> groupByIdAs(String retName){
       groupBy(retName, Employee.ID_PROPERTY);
       return this;
    }

    public EmployeeRequest<T> groupByIdWithFunction(String retName, AggrFunction function){
       groupBy(retName, Employee.ID_PROPERTY, function);
       return this;
    }

    public EmployeeRequest<T> groupByEmail(){
       groupBy(Employee.EMAIL_PROPERTY);
       return this;
    }

    public EmployeeRequest<T> groupByEmailAs(String retName){
       groupBy(retName, Employee.EMAIL_PROPERTY);
       return this;
    }

    public EmployeeRequest<T> groupByEmailWithFunction(String retName, AggrFunction function){
       groupBy(retName, Employee.EMAIL_PROPERTY, function);
       return this;
    }

    public EmployeeRequest<T> groupByName(){
       groupBy(Employee.NAME_PROPERTY);
       return this;
    }

    public EmployeeRequest<T> groupByNameAs(String retName){
       groupBy(retName, Employee.NAME_PROPERTY);
       return this;
    }

    public EmployeeRequest<T> groupByNameWithFunction(String retName, AggrFunction function){
       groupBy(retName, Employee.NAME_PROPERTY, function);
       return this;
    }

    public EmployeeRequest<T> groupByPhone(){
       groupBy(Employee.PHONE_PROPERTY);
       return this;
    }

    public EmployeeRequest<T> groupByPhoneAs(String retName){
       groupBy(retName, Employee.PHONE_PROPERTY);
       return this;
    }

    public EmployeeRequest<T> groupByPhoneWithFunction(String retName, AggrFunction function){
       groupBy(retName, Employee.PHONE_PROPERTY, function);
       return this;
    }

    public EmployeeRequest<T> groupBySalary(){
       groupBy(Employee.SALARY_PROPERTY);
       return this;
    }

    public EmployeeRequest<T> groupBySalaryAs(String retName){
       groupBy(retName, Employee.SALARY_PROPERTY);
       return this;
    }

    public EmployeeRequest<T> groupBySalaryWithFunction(String retName, AggrFunction function){
       groupBy(retName, Employee.SALARY_PROPERTY, function);
       return this;
    }

    public EmployeeRequest<T> groupBySsn(){
       groupBy(Employee.SSN_PROPERTY);
       return this;
    }

    public EmployeeRequest<T> groupBySsnAs(String retName){
       groupBy(retName, Employee.SSN_PROPERTY);
       return this;
    }

    public EmployeeRequest<T> groupBySsnWithFunction(String retName, AggrFunction function){
       groupBy(retName, Employee.SSN_PROPERTY, function);
       return this;
    }
    public EmployeeRequest<T> groupByDepartmentWith(DepartmentRequest subRequest){
       groupBy(Employee.DEPARTMENT_PROPERTY, subRequest);
       return this;
    }
    public EmployeeRequest<T> groupByDepartment(){
       groupBy(Employee.DEPARTMENT_PROPERTY);
       return this;
    }

    public EmployeeRequest<T> groupByDepartmentAs(String retName){
       groupBy(retName, Employee.DEPARTMENT_PROPERTY);
       return this;
    }

    public EmployeeRequest<T> groupByDepartmentWithFunction(String retName, AggrFunction function){
       groupBy(retName, Employee.DEPARTMENT_PROPERTY, function);
       return this;
    }

    public EmployeeRequest<T> groupByHireDate(){
       groupBy(Employee.HIRE_DATE_PROPERTY);
       return this;
    }

    public EmployeeRequest<T> groupByHireDateAs(String retName){
       groupBy(retName, Employee.HIRE_DATE_PROPERTY);
       return this;
    }

    public EmployeeRequest<T> groupByHireDateWithFunction(String retName, AggrFunction function){
       groupBy(retName, Employee.HIRE_DATE_PROPERTY, function);
       return this;
    }

    public EmployeeRequest<T> groupByStatus(){
       groupBy(Employee.STATUS_PROPERTY);
       return this;
    }

    public EmployeeRequest<T> groupByStatusAs(String retName){
       groupBy(retName, Employee.STATUS_PROPERTY);
       return this;
    }

    public EmployeeRequest<T> groupByStatusWithFunction(String retName, AggrFunction function){
       groupBy(retName, Employee.STATUS_PROPERTY, function);
       return this;
    }

    public EmployeeRequest<T> groupByCreateTime(){
       groupBy(Employee.CREATE_TIME_PROPERTY);
       return this;
    }

    public EmployeeRequest<T> groupByCreateTimeAs(String retName){
       groupBy(retName, Employee.CREATE_TIME_PROPERTY);
       return this;
    }

    public EmployeeRequest<T> groupByCreateTimeWithFunction(String retName, AggrFunction function){
       groupBy(retName, Employee.CREATE_TIME_PROPERTY, function);
       return this;
    }

    public EmployeeRequest<T> groupByUpdateTime(){
       groupBy(Employee.UPDATE_TIME_PROPERTY);
       return this;
    }

    public EmployeeRequest<T> groupByUpdateTimeAs(String retName){
       groupBy(retName, Employee.UPDATE_TIME_PROPERTY);
       return this;
    }

    public EmployeeRequest<T> groupByUpdateTimeWithFunction(String retName, AggrFunction function){
       groupBy(retName, Employee.UPDATE_TIME_PROPERTY, function);
       return this;
    }

    public EmployeeRequest<T> groupByVersion(){
       groupBy(Employee.VERSION_PROPERTY);
       return this;
    }

    public EmployeeRequest<T> groupByVersionAs(String retName){
       groupBy(retName, Employee.VERSION_PROPERTY);
       return this;
    }

    public EmployeeRequest<T> groupByVersionWithFunction(String retName, AggrFunction function){
       groupBy(retName, Employee.VERSION_PROPERTY, function);
       return this;
    }



    public EmployeeRequest<T> orderByIdAscending(){
       addOrderByAscending(Employee.ID_PROPERTY);
       return this;
    }

    public EmployeeRequest<T> orderByIdDescending(){
       addOrderByDescending(Employee.ID_PROPERTY);
       return this;
    }

    public EmployeeRequest<T> orderByEmailAscending(){
       addOrderByAscending(Employee.EMAIL_PROPERTY);
       return this;
    }

    public EmployeeRequest<T> orderByEmailDescending(){
       addOrderByDescending(Employee.EMAIL_PROPERTY);
       return this;
    }
    public EmployeeRequest<T> orderByEmailAscendingUsingGBK(){
       addOrderByAscendingUsingGBK(Employee.EMAIL_PROPERTY);
       return this;
    }

    public EmployeeRequest<T> orderByEmailDescendingUsingGBK(){
       addOrderByDescendingUsingGBK(Employee.EMAIL_PROPERTY);
       return this;
    }
    public EmployeeRequest<T> orderByNameAscending(){
       addOrderByAscending(Employee.NAME_PROPERTY);
       return this;
    }

    public EmployeeRequest<T> orderByNameDescending(){
       addOrderByDescending(Employee.NAME_PROPERTY);
       return this;
    }
    public EmployeeRequest<T> orderByNameAscendingUsingGBK(){
       addOrderByAscendingUsingGBK(Employee.NAME_PROPERTY);
       return this;
    }

    public EmployeeRequest<T> orderByNameDescendingUsingGBK(){
       addOrderByDescendingUsingGBK(Employee.NAME_PROPERTY);
       return this;
    }
    public EmployeeRequest<T> orderByPhoneAscending(){
       addOrderByAscending(Employee.PHONE_PROPERTY);
       return this;
    }

    public EmployeeRequest<T> orderByPhoneDescending(){
       addOrderByDescending(Employee.PHONE_PROPERTY);
       return this;
    }
    public EmployeeRequest<T> orderByPhoneAscendingUsingGBK(){
       addOrderByAscendingUsingGBK(Employee.PHONE_PROPERTY);
       return this;
    }

    public EmployeeRequest<T> orderByPhoneDescendingUsingGBK(){
       addOrderByDescendingUsingGBK(Employee.PHONE_PROPERTY);
       return this;
    }
    public EmployeeRequest<T> orderBySalaryAscending(){
       addOrderByAscending(Employee.SALARY_PROPERTY);
       return this;
    }

    public EmployeeRequest<T> orderBySalaryDescending(){
       addOrderByDescending(Employee.SALARY_PROPERTY);
       return this;
    }

    public EmployeeRequest<T> orderBySsnAscending(){
       addOrderByAscending(Employee.SSN_PROPERTY);
       return this;
    }

    public EmployeeRequest<T> orderBySsnDescending(){
       addOrderByDescending(Employee.SSN_PROPERTY);
       return this;
    }
    public EmployeeRequest<T> orderBySsnAscendingUsingGBK(){
       addOrderByAscendingUsingGBK(Employee.SSN_PROPERTY);
       return this;
    }

    public EmployeeRequest<T> orderBySsnDescendingUsingGBK(){
       addOrderByDescendingUsingGBK(Employee.SSN_PROPERTY);
       return this;
    }
    public EmployeeRequest<T> orderByDepartmentAscending(){
       addOrderByAscending(Employee.DEPARTMENT_PROPERTY);
       return this;
    }

    public EmployeeRequest<T> orderByDepartmentDescending(){
       addOrderByDescending(Employee.DEPARTMENT_PROPERTY);
       return this;
    }

    public EmployeeRequest<T> orderByHireDateAscending(){
       addOrderByAscending(Employee.HIRE_DATE_PROPERTY);
       return this;
    }

    public EmployeeRequest<T> orderByHireDateDescending(){
       addOrderByDescending(Employee.HIRE_DATE_PROPERTY);
       return this;
    }

    public EmployeeRequest<T> orderByStatusAscending(){
       addOrderByAscending(Employee.STATUS_PROPERTY);
       return this;
    }

    public EmployeeRequest<T> orderByStatusDescending(){
       addOrderByDescending(Employee.STATUS_PROPERTY);
       return this;
    }
    public EmployeeRequest<T> orderByStatusAscendingUsingGBK(){
       addOrderByAscendingUsingGBK(Employee.STATUS_PROPERTY);
       return this;
    }

    public EmployeeRequest<T> orderByStatusDescendingUsingGBK(){
       addOrderByDescendingUsingGBK(Employee.STATUS_PROPERTY);
       return this;
    }
    public EmployeeRequest<T> orderByCreateTimeAscending(){
       addOrderByAscending(Employee.CREATE_TIME_PROPERTY);
       return this;
    }

    public EmployeeRequest<T> orderByCreateTimeDescending(){
       addOrderByDescending(Employee.CREATE_TIME_PROPERTY);
       return this;
    }

    public EmployeeRequest<T> orderByUpdateTimeAscending(){
       addOrderByAscending(Employee.UPDATE_TIME_PROPERTY);
       return this;
    }

    public EmployeeRequest<T> orderByUpdateTimeDescending(){
       addOrderByDescending(Employee.UPDATE_TIME_PROPERTY);
       return this;
    }

    public EmployeeRequest<T> orderByVersionAscending(){
       addOrderByAscending(Employee.VERSION_PROPERTY);
       return this;
    }

    public EmployeeRequest<T> orderByVersionDescending(){
       addOrderByDescending(Employee.VERSION_PROPERTY);
       return this;
    }


    public EmployeeRequest<T> statsFromLeaveRequestsAs(String name, LeaveRequestRequest subRequest){
       return statsFromLeaveRequestsAs(name, subRequest, false);
    }

    public EmployeeRequest<T> statsFromLeaveRequestsAs(String name, LeaveRequestRequest subRequest, boolean singleResult){
       subRequest.setPartitionProperty(LeaveRequest.EMPLOYEE_PROPERTY);
       addAggregateDynamicProperty(name, subRequest, singleResult);
       return this;
    }

    public EmployeeRequest<T> statsFromLeaveRequests(LeaveRequestRequest subRequest){
       return statsFromLeaveRequestsAs(REFINEMENTS, subRequest);
    }
    public EmployeeRequest<T> statsFromAttendancesAs(String name, AttendanceRequest subRequest){
       return statsFromAttendancesAs(name, subRequest, false);
    }

    public EmployeeRequest<T> statsFromAttendancesAs(String name, AttendanceRequest subRequest, boolean singleResult){
       subRequest.setPartitionProperty(Attendance.EMPLOYEE_PROPERTY);
       addAggregateDynamicProperty(name, subRequest, singleResult);
       return this;
    }

    public EmployeeRequest<T> statsFromAttendances(AttendanceRequest subRequest){
       return statsFromAttendancesAs(REFINEMENTS, subRequest);
    }
    public EmployeeRequest<T> statsFromBenefitsAs(String name, BenefitRequest subRequest){
       return statsFromBenefitsAs(name, subRequest, false);
    }

    public EmployeeRequest<T> statsFromBenefitsAs(String name, BenefitRequest subRequest, boolean singleResult){
       subRequest.setPartitionProperty(Benefit.EMPLOYEE_PROPERTY);
       addAggregateDynamicProperty(name, subRequest, singleResult);
       return this;
    }

    public EmployeeRequest<T> statsFromBenefits(BenefitRequest subRequest){
       return statsFromBenefitsAs(REFINEMENTS, subRequest);
    }
    public EmployeeRequest<T> statsFromEmployeeReviewsAs(String name, EmployeeReviewRequest subRequest){
       return statsFromEmployeeReviewsAs(name, subRequest, false);
    }

    public EmployeeRequest<T> statsFromEmployeeReviewsAs(String name, EmployeeReviewRequest subRequest, boolean singleResult){
       subRequest.setPartitionProperty(EmployeeReview.EMPLOYEE_PROPERTY);
       addAggregateDynamicProperty(name, subRequest, singleResult);
       return this;
    }

    public EmployeeRequest<T> statsFromEmployeeReviews(EmployeeReviewRequest subRequest){
       return statsFromEmployeeReviewsAs(REFINEMENTS, subRequest);
    }
    public EmployeeRequest<T> statsFromPayrollsAs(String name, PayrollRequest subRequest){
       return statsFromPayrollsAs(name, subRequest, false);
    }

    public EmployeeRequest<T> statsFromPayrollsAs(String name, PayrollRequest subRequest, boolean singleResult){
       subRequest.setPartitionProperty(Payroll.EMPLOYEE_PROPERTY);
       addAggregateDynamicProperty(name, subRequest, singleResult);
       return this;
    }

    public EmployeeRequest<T> statsFromPayrolls(PayrollRequest subRequest){
       return statsFromPayrollsAs(REFINEMENTS, subRequest);
    }
    public EmployeeRequest<T> statsFromExpensesAs(String name, ExpenseRequest subRequest){
       return statsFromExpensesAs(name, subRequest, false);
    }

    public EmployeeRequest<T> statsFromExpensesAs(String name, ExpenseRequest subRequest, boolean singleResult){
       subRequest.setPartitionProperty(Expense.EMPLOYEE_PROPERTY);
       addAggregateDynamicProperty(name, subRequest, singleResult);
       return this;
    }

    public EmployeeRequest<T> statsFromExpenses(ExpenseRequest subRequest){
       return statsFromExpensesAs(REFINEMENTS, subRequest);
    }
    public EmployeeRequest<T> statsFromSupportAgentsAs(String name, SupportAgentRequest subRequest){
       return statsFromSupportAgentsAs(name, subRequest, false);
    }

    public EmployeeRequest<T> statsFromSupportAgentsAs(String name, SupportAgentRequest subRequest, boolean singleResult){
       subRequest.setPartitionProperty(SupportAgent.EMPLOYEE_PROPERTY);
       addAggregateDynamicProperty(name, subRequest, singleResult);
       return this;
    }

    public EmployeeRequest<T> statsFromSupportAgents(SupportAgentRequest subRequest){
       return statsFromSupportAgentsAs(REFINEMENTS, subRequest);
    }
    public DepartmentRequest rollUpToDepartment(){
       DepartmentRequest department = Q.departments().unlimited();
       this.withDepartmentMatching(department)
           .groupByDepartmentWith(department);
       return department;
    }






    public EmployeeRequest<T> countLeaveRequests(){
        return countLeaveRequestsAs("Count");
    }

    public EmployeeRequest<T> countLeaveRequestsAs(String name){
        return countLeaveRequestsWith(name, Q.leaveRequests().unlimited());
    }

    public EmployeeRequest<T> countLeaveRequestsWith(String name, LeaveRequestRequest subRequest){
        return statsFromLeaveRequestsAs(name, subRequest.count(), true);
    }
    public EmployeeRequest<T> countAttendances(){
        return countAttendancesAs("Count");
    }

    public EmployeeRequest<T> countAttendancesAs(String name){
        return countAttendancesWith(name, Q.attendances().unlimited());
    }

    public EmployeeRequest<T> countAttendancesWith(String name, AttendanceRequest subRequest){
        return statsFromAttendancesAs(name, subRequest.count(), true);
    }
    public EmployeeRequest<T> countBenefits(){
        return countBenefitsAs("Count");
    }

    public EmployeeRequest<T> countBenefitsAs(String name){
        return countBenefitsWith(name, Q.benefits().unlimited());
    }

    public EmployeeRequest<T> countBenefitsWith(String name, BenefitRequest subRequest){
        return statsFromBenefitsAs(name, subRequest.count(), true);
    }
    public EmployeeRequest<T> countEmployeeReviews(){
        return countEmployeeReviewsAs("Count");
    }

    public EmployeeRequest<T> countEmployeeReviewsAs(String name){
        return countEmployeeReviewsWith(name, Q.employeeReviews().unlimited());
    }

    public EmployeeRequest<T> countEmployeeReviewsWith(String name, EmployeeReviewRequest subRequest){
        return statsFromEmployeeReviewsAs(name, subRequest.count(), true);
    }
    public EmployeeRequest<T> countPayrolls(){
        return countPayrollsAs("Count");
    }

    public EmployeeRequest<T> countPayrollsAs(String name){
        return countPayrollsWith(name, Q.payrolls().unlimited());
    }

    public EmployeeRequest<T> countPayrollsWith(String name, PayrollRequest subRequest){
        return statsFromPayrollsAs(name, subRequest.count(), true);
    }
    public EmployeeRequest<T> countExpenses(){
        return countExpensesAs("Count");
    }

    public EmployeeRequest<T> countExpensesAs(String name){
        return countExpensesWith(name, Q.expenses().unlimited());
    }

    public EmployeeRequest<T> countExpensesWith(String name, ExpenseRequest subRequest){
        return statsFromExpensesAs(name, subRequest.count(), true);
    }
    public EmployeeRequest<T> countSupportAgents(){
        return countSupportAgentsAs("Count");
    }

    public EmployeeRequest<T> countSupportAgentsAs(String name){
        return countSupportAgentsWith(name, Q.supportAgents().unlimited());
    }

    public EmployeeRequest<T> countSupportAgentsWith(String name, SupportAgentRequest subRequest){
        return statsFromSupportAgentsAs(name, subRequest.count(), true);
    }
    public EmployeeRequest<T> minHoursWorkedOfAttendances(){
        return minHoursWorkedOfAttendancesAs("minHoursWorkedOfAttendances");
    }

    public EmployeeRequest<T> minHoursWorkedOfAttendancesAs(String name){
        return minHoursWorkedOfAttendancesAs(name, Q.attendances().unlimited());
    }

    public EmployeeRequest<T> minHoursWorkedOfAttendancesAs(String name, AttendanceRequest subRequest){
        return statsFromAttendancesAs(name, subRequest.minHoursWorked(), true);
    }
    public EmployeeRequest<T> maxHoursWorkedOfAttendances(){
        return maxHoursWorkedOfAttendancesAs("maxHoursWorkedOfAttendances");
    }

    public EmployeeRequest<T> maxHoursWorkedOfAttendancesAs(String name){
        return maxHoursWorkedOfAttendancesAs(name, Q.attendances().unlimited());
    }

    public EmployeeRequest<T> maxHoursWorkedOfAttendancesAs(String name, AttendanceRequest subRequest){
        return statsFromAttendancesAs(name, subRequest.maxHoursWorked(), true);
    }
    public EmployeeRequest<T> sumHoursWorkedOfAttendances(){
        return sumHoursWorkedOfAttendancesAs("sumHoursWorkedOfAttendances");
    }

    public EmployeeRequest<T> sumHoursWorkedOfAttendancesAs(String name){
        return sumHoursWorkedOfAttendancesAs(name, Q.attendances().unlimited());
    }

    public EmployeeRequest<T> sumHoursWorkedOfAttendancesAs(String name, AttendanceRequest subRequest){
        return statsFromAttendancesAs(name, subRequest.sumHoursWorked(), true);
    }
    public EmployeeRequest<T> avgHoursWorkedOfAttendances(){
        return avgHoursWorkedOfAttendancesAs("avgHoursWorkedOfAttendances");
    }

    public EmployeeRequest<T> avgHoursWorkedOfAttendancesAs(String name){
        return avgHoursWorkedOfAttendancesAs(name, Q.attendances().unlimited());
    }

    public EmployeeRequest<T> avgHoursWorkedOfAttendancesAs(String name, AttendanceRequest subRequest){
        return statsFromAttendancesAs(name, subRequest.avgHoursWorked(), true);
    }
    public EmployeeRequest<T> standardDeviationHoursWorkedOfAttendances(){
        return standardDeviationHoursWorkedOfAttendancesAs("stdDevHoursWorkedOfAttendances");
    }

    public EmployeeRequest<T> standardDeviationHoursWorkedOfAttendancesAs(String name){
        return standardDeviationHoursWorkedOfAttendancesAs(name, Q.attendances().unlimited());
    }

    public EmployeeRequest<T> standardDeviationHoursWorkedOfAttendancesAs(String name, AttendanceRequest subRequest){
        return statsFromAttendancesAs(name, subRequest.standardDeviationHoursWorked(), true);
    }
    public EmployeeRequest<T> squareRootOfPopulationStandardDeviationHoursWorkedOfAttendances(){
        return squareRootOfPopulationStandardDeviationHoursWorkedOfAttendancesAs("stdDevPopHoursWorkedOfAttendances");
    }

    public EmployeeRequest<T> squareRootOfPopulationStandardDeviationHoursWorkedOfAttendancesAs(String name){
        return squareRootOfPopulationStandardDeviationHoursWorkedOfAttendancesAs(name, Q.attendances().unlimited());
    }

    public EmployeeRequest<T> squareRootOfPopulationStandardDeviationHoursWorkedOfAttendancesAs(String name, AttendanceRequest subRequest){
        return statsFromAttendancesAs(name, subRequest.squareRootOfPopulationStandardDeviationHoursWorked(), true);
    }
    public EmployeeRequest<T> sampleVarianceHoursWorkedOfAttendances(){
        return sampleVarianceHoursWorkedOfAttendancesAs("varSampHoursWorkedOfAttendances");
    }

    public EmployeeRequest<T> sampleVarianceHoursWorkedOfAttendancesAs(String name){
        return sampleVarianceHoursWorkedOfAttendancesAs(name, Q.attendances().unlimited());
    }

    public EmployeeRequest<T> sampleVarianceHoursWorkedOfAttendancesAs(String name, AttendanceRequest subRequest){
        return statsFromAttendancesAs(name, subRequest.sampleVarianceHoursWorked(), true);
    }
    public EmployeeRequest<T> samplePopulationVarianceHoursWorkedOfAttendances(){
        return samplePopulationVarianceHoursWorkedOfAttendancesAs("varPopHoursWorkedOfAttendances");
    }

    public EmployeeRequest<T> samplePopulationVarianceHoursWorkedOfAttendancesAs(String name){
        return samplePopulationVarianceHoursWorkedOfAttendancesAs(name, Q.attendances().unlimited());
    }

    public EmployeeRequest<T> samplePopulationVarianceHoursWorkedOfAttendancesAs(String name, AttendanceRequest subRequest){
        return statsFromAttendancesAs(name, subRequest.samplePopulationVarianceHoursWorked(), true);
    }
    public EmployeeRequest<T> minCostOfBenefits(){
        return minCostOfBenefitsAs("minCostOfBenefits");
    }

    public EmployeeRequest<T> minCostOfBenefitsAs(String name){
        return minCostOfBenefitsAs(name, Q.benefits().unlimited());
    }

    public EmployeeRequest<T> minCostOfBenefitsAs(String name, BenefitRequest subRequest){
        return statsFromBenefitsAs(name, subRequest.minCost(), true);
    }
    public EmployeeRequest<T> maxCostOfBenefits(){
        return maxCostOfBenefitsAs("maxCostOfBenefits");
    }

    public EmployeeRequest<T> maxCostOfBenefitsAs(String name){
        return maxCostOfBenefitsAs(name, Q.benefits().unlimited());
    }

    public EmployeeRequest<T> maxCostOfBenefitsAs(String name, BenefitRequest subRequest){
        return statsFromBenefitsAs(name, subRequest.maxCost(), true);
    }
    public EmployeeRequest<T> sumCostOfBenefits(){
        return sumCostOfBenefitsAs("sumCostOfBenefits");
    }

    public EmployeeRequest<T> sumCostOfBenefitsAs(String name){
        return sumCostOfBenefitsAs(name, Q.benefits().unlimited());
    }

    public EmployeeRequest<T> sumCostOfBenefitsAs(String name, BenefitRequest subRequest){
        return statsFromBenefitsAs(name, subRequest.sumCost(), true);
    }
    public EmployeeRequest<T> avgCostOfBenefits(){
        return avgCostOfBenefitsAs("avgCostOfBenefits");
    }

    public EmployeeRequest<T> avgCostOfBenefitsAs(String name){
        return avgCostOfBenefitsAs(name, Q.benefits().unlimited());
    }

    public EmployeeRequest<T> avgCostOfBenefitsAs(String name, BenefitRequest subRequest){
        return statsFromBenefitsAs(name, subRequest.avgCost(), true);
    }
    public EmployeeRequest<T> standardDeviationCostOfBenefits(){
        return standardDeviationCostOfBenefitsAs("stdDevCostOfBenefits");
    }

    public EmployeeRequest<T> standardDeviationCostOfBenefitsAs(String name){
        return standardDeviationCostOfBenefitsAs(name, Q.benefits().unlimited());
    }

    public EmployeeRequest<T> standardDeviationCostOfBenefitsAs(String name, BenefitRequest subRequest){
        return statsFromBenefitsAs(name, subRequest.standardDeviationCost(), true);
    }
    public EmployeeRequest<T> squareRootOfPopulationStandardDeviationCostOfBenefits(){
        return squareRootOfPopulationStandardDeviationCostOfBenefitsAs("stdDevPopCostOfBenefits");
    }

    public EmployeeRequest<T> squareRootOfPopulationStandardDeviationCostOfBenefitsAs(String name){
        return squareRootOfPopulationStandardDeviationCostOfBenefitsAs(name, Q.benefits().unlimited());
    }

    public EmployeeRequest<T> squareRootOfPopulationStandardDeviationCostOfBenefitsAs(String name, BenefitRequest subRequest){
        return statsFromBenefitsAs(name, subRequest.squareRootOfPopulationStandardDeviationCost(), true);
    }
    public EmployeeRequest<T> sampleVarianceCostOfBenefits(){
        return sampleVarianceCostOfBenefitsAs("varSampCostOfBenefits");
    }

    public EmployeeRequest<T> sampleVarianceCostOfBenefitsAs(String name){
        return sampleVarianceCostOfBenefitsAs(name, Q.benefits().unlimited());
    }

    public EmployeeRequest<T> sampleVarianceCostOfBenefitsAs(String name, BenefitRequest subRequest){
        return statsFromBenefitsAs(name, subRequest.sampleVarianceCost(), true);
    }
    public EmployeeRequest<T> samplePopulationVarianceCostOfBenefits(){
        return samplePopulationVarianceCostOfBenefitsAs("varPopCostOfBenefits");
    }

    public EmployeeRequest<T> samplePopulationVarianceCostOfBenefitsAs(String name){
        return samplePopulationVarianceCostOfBenefitsAs(name, Q.benefits().unlimited());
    }

    public EmployeeRequest<T> samplePopulationVarianceCostOfBenefitsAs(String name, BenefitRequest subRequest){
        return statsFromBenefitsAs(name, subRequest.samplePopulationVarianceCost(), true);
    }
    public EmployeeRequest<T> minScoreOfEmployeeReviews(){
        return minScoreOfEmployeeReviewsAs("minScoreOfEmployeeReviews");
    }

    public EmployeeRequest<T> minScoreOfEmployeeReviewsAs(String name){
        return minScoreOfEmployeeReviewsAs(name, Q.employeeReviews().unlimited());
    }

    public EmployeeRequest<T> minScoreOfEmployeeReviewsAs(String name, EmployeeReviewRequest subRequest){
        return statsFromEmployeeReviewsAs(name, subRequest.minScore(), true);
    }
    public EmployeeRequest<T> maxScoreOfEmployeeReviews(){
        return maxScoreOfEmployeeReviewsAs("maxScoreOfEmployeeReviews");
    }

    public EmployeeRequest<T> maxScoreOfEmployeeReviewsAs(String name){
        return maxScoreOfEmployeeReviewsAs(name, Q.employeeReviews().unlimited());
    }

    public EmployeeRequest<T> maxScoreOfEmployeeReviewsAs(String name, EmployeeReviewRequest subRequest){
        return statsFromEmployeeReviewsAs(name, subRequest.maxScore(), true);
    }
    public EmployeeRequest<T> sumScoreOfEmployeeReviews(){
        return sumScoreOfEmployeeReviewsAs("sumScoreOfEmployeeReviews");
    }

    public EmployeeRequest<T> sumScoreOfEmployeeReviewsAs(String name){
        return sumScoreOfEmployeeReviewsAs(name, Q.employeeReviews().unlimited());
    }

    public EmployeeRequest<T> sumScoreOfEmployeeReviewsAs(String name, EmployeeReviewRequest subRequest){
        return statsFromEmployeeReviewsAs(name, subRequest.sumScore(), true);
    }
    public EmployeeRequest<T> avgScoreOfEmployeeReviews(){
        return avgScoreOfEmployeeReviewsAs("avgScoreOfEmployeeReviews");
    }

    public EmployeeRequest<T> avgScoreOfEmployeeReviewsAs(String name){
        return avgScoreOfEmployeeReviewsAs(name, Q.employeeReviews().unlimited());
    }

    public EmployeeRequest<T> avgScoreOfEmployeeReviewsAs(String name, EmployeeReviewRequest subRequest){
        return statsFromEmployeeReviewsAs(name, subRequest.avgScore(), true);
    }
    public EmployeeRequest<T> standardDeviationScoreOfEmployeeReviews(){
        return standardDeviationScoreOfEmployeeReviewsAs("stdDevScoreOfEmployeeReviews");
    }

    public EmployeeRequest<T> standardDeviationScoreOfEmployeeReviewsAs(String name){
        return standardDeviationScoreOfEmployeeReviewsAs(name, Q.employeeReviews().unlimited());
    }

    public EmployeeRequest<T> standardDeviationScoreOfEmployeeReviewsAs(String name, EmployeeReviewRequest subRequest){
        return statsFromEmployeeReviewsAs(name, subRequest.standardDeviationScore(), true);
    }
    public EmployeeRequest<T> squareRootOfPopulationStandardDeviationScoreOfEmployeeReviews(){
        return squareRootOfPopulationStandardDeviationScoreOfEmployeeReviewsAs("stdDevPopScoreOfEmployeeReviews");
    }

    public EmployeeRequest<T> squareRootOfPopulationStandardDeviationScoreOfEmployeeReviewsAs(String name){
        return squareRootOfPopulationStandardDeviationScoreOfEmployeeReviewsAs(name, Q.employeeReviews().unlimited());
    }

    public EmployeeRequest<T> squareRootOfPopulationStandardDeviationScoreOfEmployeeReviewsAs(String name, EmployeeReviewRequest subRequest){
        return statsFromEmployeeReviewsAs(name, subRequest.squareRootOfPopulationStandardDeviationScore(), true);
    }
    public EmployeeRequest<T> sampleVarianceScoreOfEmployeeReviews(){
        return sampleVarianceScoreOfEmployeeReviewsAs("varSampScoreOfEmployeeReviews");
    }

    public EmployeeRequest<T> sampleVarianceScoreOfEmployeeReviewsAs(String name){
        return sampleVarianceScoreOfEmployeeReviewsAs(name, Q.employeeReviews().unlimited());
    }

    public EmployeeRequest<T> sampleVarianceScoreOfEmployeeReviewsAs(String name, EmployeeReviewRequest subRequest){
        return statsFromEmployeeReviewsAs(name, subRequest.sampleVarianceScore(), true);
    }
    public EmployeeRequest<T> samplePopulationVarianceScoreOfEmployeeReviews(){
        return samplePopulationVarianceScoreOfEmployeeReviewsAs("varPopScoreOfEmployeeReviews");
    }

    public EmployeeRequest<T> samplePopulationVarianceScoreOfEmployeeReviewsAs(String name){
        return samplePopulationVarianceScoreOfEmployeeReviewsAs(name, Q.employeeReviews().unlimited());
    }

    public EmployeeRequest<T> samplePopulationVarianceScoreOfEmployeeReviewsAs(String name, EmployeeReviewRequest subRequest){
        return statsFromEmployeeReviewsAs(name, subRequest.samplePopulationVarianceScore(), true);
    }
    public EmployeeRequest<T> minTaxOfPayrolls(){
        return minTaxOfPayrollsAs("minTaxOfPayrolls");
    }

    public EmployeeRequest<T> minTaxOfPayrollsAs(String name){
        return minTaxOfPayrollsAs(name, Q.payrolls().unlimited());
    }

    public EmployeeRequest<T> minTaxOfPayrollsAs(String name, PayrollRequest subRequest){
        return statsFromPayrollsAs(name, subRequest.minTax(), true);
    }
    public EmployeeRequest<T> maxTaxOfPayrolls(){
        return maxTaxOfPayrollsAs("maxTaxOfPayrolls");
    }

    public EmployeeRequest<T> maxTaxOfPayrollsAs(String name){
        return maxTaxOfPayrollsAs(name, Q.payrolls().unlimited());
    }

    public EmployeeRequest<T> maxTaxOfPayrollsAs(String name, PayrollRequest subRequest){
        return statsFromPayrollsAs(name, subRequest.maxTax(), true);
    }
    public EmployeeRequest<T> sumTaxOfPayrolls(){
        return sumTaxOfPayrollsAs("sumTaxOfPayrolls");
    }

    public EmployeeRequest<T> sumTaxOfPayrollsAs(String name){
        return sumTaxOfPayrollsAs(name, Q.payrolls().unlimited());
    }

    public EmployeeRequest<T> sumTaxOfPayrollsAs(String name, PayrollRequest subRequest){
        return statsFromPayrollsAs(name, subRequest.sumTax(), true);
    }
    public EmployeeRequest<T> avgTaxOfPayrolls(){
        return avgTaxOfPayrollsAs("avgTaxOfPayrolls");
    }

    public EmployeeRequest<T> avgTaxOfPayrollsAs(String name){
        return avgTaxOfPayrollsAs(name, Q.payrolls().unlimited());
    }

    public EmployeeRequest<T> avgTaxOfPayrollsAs(String name, PayrollRequest subRequest){
        return statsFromPayrollsAs(name, subRequest.avgTax(), true);
    }
    public EmployeeRequest<T> standardDeviationTaxOfPayrolls(){
        return standardDeviationTaxOfPayrollsAs("stdDevTaxOfPayrolls");
    }

    public EmployeeRequest<T> standardDeviationTaxOfPayrollsAs(String name){
        return standardDeviationTaxOfPayrollsAs(name, Q.payrolls().unlimited());
    }

    public EmployeeRequest<T> standardDeviationTaxOfPayrollsAs(String name, PayrollRequest subRequest){
        return statsFromPayrollsAs(name, subRequest.standardDeviationTax(), true);
    }
    public EmployeeRequest<T> squareRootOfPopulationStandardDeviationTaxOfPayrolls(){
        return squareRootOfPopulationStandardDeviationTaxOfPayrollsAs("stdDevPopTaxOfPayrolls");
    }

    public EmployeeRequest<T> squareRootOfPopulationStandardDeviationTaxOfPayrollsAs(String name){
        return squareRootOfPopulationStandardDeviationTaxOfPayrollsAs(name, Q.payrolls().unlimited());
    }

    public EmployeeRequest<T> squareRootOfPopulationStandardDeviationTaxOfPayrollsAs(String name, PayrollRequest subRequest){
        return statsFromPayrollsAs(name, subRequest.squareRootOfPopulationStandardDeviationTax(), true);
    }
    public EmployeeRequest<T> sampleVarianceTaxOfPayrolls(){
        return sampleVarianceTaxOfPayrollsAs("varSampTaxOfPayrolls");
    }

    public EmployeeRequest<T> sampleVarianceTaxOfPayrollsAs(String name){
        return sampleVarianceTaxOfPayrollsAs(name, Q.payrolls().unlimited());
    }

    public EmployeeRequest<T> sampleVarianceTaxOfPayrollsAs(String name, PayrollRequest subRequest){
        return statsFromPayrollsAs(name, subRequest.sampleVarianceTax(), true);
    }
    public EmployeeRequest<T> samplePopulationVarianceTaxOfPayrolls(){
        return samplePopulationVarianceTaxOfPayrollsAs("varPopTaxOfPayrolls");
    }

    public EmployeeRequest<T> samplePopulationVarianceTaxOfPayrollsAs(String name){
        return samplePopulationVarianceTaxOfPayrollsAs(name, Q.payrolls().unlimited());
    }

    public EmployeeRequest<T> samplePopulationVarianceTaxOfPayrollsAs(String name, PayrollRequest subRequest){
        return statsFromPayrollsAs(name, subRequest.samplePopulationVarianceTax(), true);
    }
    public EmployeeRequest<T> minGrossPayOfPayrolls(){
        return minGrossPayOfPayrollsAs("minGrossPayOfPayrolls");
    }

    public EmployeeRequest<T> minGrossPayOfPayrollsAs(String name){
        return minGrossPayOfPayrollsAs(name, Q.payrolls().unlimited());
    }

    public EmployeeRequest<T> minGrossPayOfPayrollsAs(String name, PayrollRequest subRequest){
        return statsFromPayrollsAs(name, subRequest.minGrossPay(), true);
    }
    public EmployeeRequest<T> maxGrossPayOfPayrolls(){
        return maxGrossPayOfPayrollsAs("maxGrossPayOfPayrolls");
    }

    public EmployeeRequest<T> maxGrossPayOfPayrollsAs(String name){
        return maxGrossPayOfPayrollsAs(name, Q.payrolls().unlimited());
    }

    public EmployeeRequest<T> maxGrossPayOfPayrollsAs(String name, PayrollRequest subRequest){
        return statsFromPayrollsAs(name, subRequest.maxGrossPay(), true);
    }
    public EmployeeRequest<T> sumGrossPayOfPayrolls(){
        return sumGrossPayOfPayrollsAs("sumGrossPayOfPayrolls");
    }

    public EmployeeRequest<T> sumGrossPayOfPayrollsAs(String name){
        return sumGrossPayOfPayrollsAs(name, Q.payrolls().unlimited());
    }

    public EmployeeRequest<T> sumGrossPayOfPayrollsAs(String name, PayrollRequest subRequest){
        return statsFromPayrollsAs(name, subRequest.sumGrossPay(), true);
    }
    public EmployeeRequest<T> avgGrossPayOfPayrolls(){
        return avgGrossPayOfPayrollsAs("avgGrossPayOfPayrolls");
    }

    public EmployeeRequest<T> avgGrossPayOfPayrollsAs(String name){
        return avgGrossPayOfPayrollsAs(name, Q.payrolls().unlimited());
    }

    public EmployeeRequest<T> avgGrossPayOfPayrollsAs(String name, PayrollRequest subRequest){
        return statsFromPayrollsAs(name, subRequest.avgGrossPay(), true);
    }
    public EmployeeRequest<T> standardDeviationGrossPayOfPayrolls(){
        return standardDeviationGrossPayOfPayrollsAs("stdDevGrossPayOfPayrolls");
    }

    public EmployeeRequest<T> standardDeviationGrossPayOfPayrollsAs(String name){
        return standardDeviationGrossPayOfPayrollsAs(name, Q.payrolls().unlimited());
    }

    public EmployeeRequest<T> standardDeviationGrossPayOfPayrollsAs(String name, PayrollRequest subRequest){
        return statsFromPayrollsAs(name, subRequest.standardDeviationGrossPay(), true);
    }
    public EmployeeRequest<T> squareRootOfPopulationStandardDeviationGrossPayOfPayrolls(){
        return squareRootOfPopulationStandardDeviationGrossPayOfPayrollsAs("stdDevPopGrossPayOfPayrolls");
    }

    public EmployeeRequest<T> squareRootOfPopulationStandardDeviationGrossPayOfPayrollsAs(String name){
        return squareRootOfPopulationStandardDeviationGrossPayOfPayrollsAs(name, Q.payrolls().unlimited());
    }

    public EmployeeRequest<T> squareRootOfPopulationStandardDeviationGrossPayOfPayrollsAs(String name, PayrollRequest subRequest){
        return statsFromPayrollsAs(name, subRequest.squareRootOfPopulationStandardDeviationGrossPay(), true);
    }
    public EmployeeRequest<T> sampleVarianceGrossPayOfPayrolls(){
        return sampleVarianceGrossPayOfPayrollsAs("varSampGrossPayOfPayrolls");
    }

    public EmployeeRequest<T> sampleVarianceGrossPayOfPayrollsAs(String name){
        return sampleVarianceGrossPayOfPayrollsAs(name, Q.payrolls().unlimited());
    }

    public EmployeeRequest<T> sampleVarianceGrossPayOfPayrollsAs(String name, PayrollRequest subRequest){
        return statsFromPayrollsAs(name, subRequest.sampleVarianceGrossPay(), true);
    }
    public EmployeeRequest<T> samplePopulationVarianceGrossPayOfPayrolls(){
        return samplePopulationVarianceGrossPayOfPayrollsAs("varPopGrossPayOfPayrolls");
    }

    public EmployeeRequest<T> samplePopulationVarianceGrossPayOfPayrollsAs(String name){
        return samplePopulationVarianceGrossPayOfPayrollsAs(name, Q.payrolls().unlimited());
    }

    public EmployeeRequest<T> samplePopulationVarianceGrossPayOfPayrollsAs(String name, PayrollRequest subRequest){
        return statsFromPayrollsAs(name, subRequest.samplePopulationVarianceGrossPay(), true);
    }
    public EmployeeRequest<T> minNetPayOfPayrolls(){
        return minNetPayOfPayrollsAs("minNetPayOfPayrolls");
    }

    public EmployeeRequest<T> minNetPayOfPayrollsAs(String name){
        return minNetPayOfPayrollsAs(name, Q.payrolls().unlimited());
    }

    public EmployeeRequest<T> minNetPayOfPayrollsAs(String name, PayrollRequest subRequest){
        return statsFromPayrollsAs(name, subRequest.minNetPay(), true);
    }
    public EmployeeRequest<T> maxNetPayOfPayrolls(){
        return maxNetPayOfPayrollsAs("maxNetPayOfPayrolls");
    }

    public EmployeeRequest<T> maxNetPayOfPayrollsAs(String name){
        return maxNetPayOfPayrollsAs(name, Q.payrolls().unlimited());
    }

    public EmployeeRequest<T> maxNetPayOfPayrollsAs(String name, PayrollRequest subRequest){
        return statsFromPayrollsAs(name, subRequest.maxNetPay(), true);
    }
    public EmployeeRequest<T> sumNetPayOfPayrolls(){
        return sumNetPayOfPayrollsAs("sumNetPayOfPayrolls");
    }

    public EmployeeRequest<T> sumNetPayOfPayrollsAs(String name){
        return sumNetPayOfPayrollsAs(name, Q.payrolls().unlimited());
    }

    public EmployeeRequest<T> sumNetPayOfPayrollsAs(String name, PayrollRequest subRequest){
        return statsFromPayrollsAs(name, subRequest.sumNetPay(), true);
    }
    public EmployeeRequest<T> avgNetPayOfPayrolls(){
        return avgNetPayOfPayrollsAs("avgNetPayOfPayrolls");
    }

    public EmployeeRequest<T> avgNetPayOfPayrollsAs(String name){
        return avgNetPayOfPayrollsAs(name, Q.payrolls().unlimited());
    }

    public EmployeeRequest<T> avgNetPayOfPayrollsAs(String name, PayrollRequest subRequest){
        return statsFromPayrollsAs(name, subRequest.avgNetPay(), true);
    }
    public EmployeeRequest<T> standardDeviationNetPayOfPayrolls(){
        return standardDeviationNetPayOfPayrollsAs("stdDevNetPayOfPayrolls");
    }

    public EmployeeRequest<T> standardDeviationNetPayOfPayrollsAs(String name){
        return standardDeviationNetPayOfPayrollsAs(name, Q.payrolls().unlimited());
    }

    public EmployeeRequest<T> standardDeviationNetPayOfPayrollsAs(String name, PayrollRequest subRequest){
        return statsFromPayrollsAs(name, subRequest.standardDeviationNetPay(), true);
    }
    public EmployeeRequest<T> squareRootOfPopulationStandardDeviationNetPayOfPayrolls(){
        return squareRootOfPopulationStandardDeviationNetPayOfPayrollsAs("stdDevPopNetPayOfPayrolls");
    }

    public EmployeeRequest<T> squareRootOfPopulationStandardDeviationNetPayOfPayrollsAs(String name){
        return squareRootOfPopulationStandardDeviationNetPayOfPayrollsAs(name, Q.payrolls().unlimited());
    }

    public EmployeeRequest<T> squareRootOfPopulationStandardDeviationNetPayOfPayrollsAs(String name, PayrollRequest subRequest){
        return statsFromPayrollsAs(name, subRequest.squareRootOfPopulationStandardDeviationNetPay(), true);
    }
    public EmployeeRequest<T> sampleVarianceNetPayOfPayrolls(){
        return sampleVarianceNetPayOfPayrollsAs("varSampNetPayOfPayrolls");
    }

    public EmployeeRequest<T> sampleVarianceNetPayOfPayrollsAs(String name){
        return sampleVarianceNetPayOfPayrollsAs(name, Q.payrolls().unlimited());
    }

    public EmployeeRequest<T> sampleVarianceNetPayOfPayrollsAs(String name, PayrollRequest subRequest){
        return statsFromPayrollsAs(name, subRequest.sampleVarianceNetPay(), true);
    }
    public EmployeeRequest<T> samplePopulationVarianceNetPayOfPayrolls(){
        return samplePopulationVarianceNetPayOfPayrollsAs("varPopNetPayOfPayrolls");
    }

    public EmployeeRequest<T> samplePopulationVarianceNetPayOfPayrollsAs(String name){
        return samplePopulationVarianceNetPayOfPayrollsAs(name, Q.payrolls().unlimited());
    }

    public EmployeeRequest<T> samplePopulationVarianceNetPayOfPayrollsAs(String name, PayrollRequest subRequest){
        return statsFromPayrollsAs(name, subRequest.samplePopulationVarianceNetPay(), true);
    }
    public EmployeeRequest<T> minAmountOfExpenses(){
        return minAmountOfExpensesAs("minAmountOfExpenses");
    }

    public EmployeeRequest<T> minAmountOfExpensesAs(String name){
        return minAmountOfExpensesAs(name, Q.expenses().unlimited());
    }

    public EmployeeRequest<T> minAmountOfExpensesAs(String name, ExpenseRequest subRequest){
        return statsFromExpensesAs(name, subRequest.minAmount(), true);
    }
    public EmployeeRequest<T> maxAmountOfExpenses(){
        return maxAmountOfExpensesAs("maxAmountOfExpenses");
    }

    public EmployeeRequest<T> maxAmountOfExpensesAs(String name){
        return maxAmountOfExpensesAs(name, Q.expenses().unlimited());
    }

    public EmployeeRequest<T> maxAmountOfExpensesAs(String name, ExpenseRequest subRequest){
        return statsFromExpensesAs(name, subRequest.maxAmount(), true);
    }
    public EmployeeRequest<T> sumAmountOfExpenses(){
        return sumAmountOfExpensesAs("sumAmountOfExpenses");
    }

    public EmployeeRequest<T> sumAmountOfExpensesAs(String name){
        return sumAmountOfExpensesAs(name, Q.expenses().unlimited());
    }

    public EmployeeRequest<T> sumAmountOfExpensesAs(String name, ExpenseRequest subRequest){
        return statsFromExpensesAs(name, subRequest.sumAmount(), true);
    }
    public EmployeeRequest<T> avgAmountOfExpenses(){
        return avgAmountOfExpensesAs("avgAmountOfExpenses");
    }

    public EmployeeRequest<T> avgAmountOfExpensesAs(String name){
        return avgAmountOfExpensesAs(name, Q.expenses().unlimited());
    }

    public EmployeeRequest<T> avgAmountOfExpensesAs(String name, ExpenseRequest subRequest){
        return statsFromExpensesAs(name, subRequest.avgAmount(), true);
    }
    public EmployeeRequest<T> standardDeviationAmountOfExpenses(){
        return standardDeviationAmountOfExpensesAs("stdDevAmountOfExpenses");
    }

    public EmployeeRequest<T> standardDeviationAmountOfExpensesAs(String name){
        return standardDeviationAmountOfExpensesAs(name, Q.expenses().unlimited());
    }

    public EmployeeRequest<T> standardDeviationAmountOfExpensesAs(String name, ExpenseRequest subRequest){
        return statsFromExpensesAs(name, subRequest.standardDeviationAmount(), true);
    }
    public EmployeeRequest<T> squareRootOfPopulationStandardDeviationAmountOfExpenses(){
        return squareRootOfPopulationStandardDeviationAmountOfExpensesAs("stdDevPopAmountOfExpenses");
    }

    public EmployeeRequest<T> squareRootOfPopulationStandardDeviationAmountOfExpensesAs(String name){
        return squareRootOfPopulationStandardDeviationAmountOfExpensesAs(name, Q.expenses().unlimited());
    }

    public EmployeeRequest<T> squareRootOfPopulationStandardDeviationAmountOfExpensesAs(String name, ExpenseRequest subRequest){
        return statsFromExpensesAs(name, subRequest.squareRootOfPopulationStandardDeviationAmount(), true);
    }
    public EmployeeRequest<T> sampleVarianceAmountOfExpenses(){
        return sampleVarianceAmountOfExpensesAs("varSampAmountOfExpenses");
    }

    public EmployeeRequest<T> sampleVarianceAmountOfExpensesAs(String name){
        return sampleVarianceAmountOfExpensesAs(name, Q.expenses().unlimited());
    }

    public EmployeeRequest<T> sampleVarianceAmountOfExpensesAs(String name, ExpenseRequest subRequest){
        return statsFromExpensesAs(name, subRequest.sampleVarianceAmount(), true);
    }
    public EmployeeRequest<T> samplePopulationVarianceAmountOfExpenses(){
        return samplePopulationVarianceAmountOfExpensesAs("varPopAmountOfExpenses");
    }

    public EmployeeRequest<T> samplePopulationVarianceAmountOfExpensesAs(String name){
        return samplePopulationVarianceAmountOfExpensesAs(name, Q.expenses().unlimited());
    }

    public EmployeeRequest<T> samplePopulationVarianceAmountOfExpensesAs(String name, ExpenseRequest subRequest){
        return statsFromExpensesAs(name, subRequest.samplePopulationVarianceAmount(), true);
    }
    public EmployeeRequest<T> minActiveTicketsOfSupportAgents(){
        return minActiveTicketsOfSupportAgentsAs("minActiveTicketsOfSupportAgents");
    }

    public EmployeeRequest<T> minActiveTicketsOfSupportAgentsAs(String name){
        return minActiveTicketsOfSupportAgentsAs(name, Q.supportAgents().unlimited());
    }

    public EmployeeRequest<T> minActiveTicketsOfSupportAgentsAs(String name, SupportAgentRequest subRequest){
        return statsFromSupportAgentsAs(name, subRequest.minActiveTickets(), true);
    }
    public EmployeeRequest<T> maxActiveTicketsOfSupportAgents(){
        return maxActiveTicketsOfSupportAgentsAs("maxActiveTicketsOfSupportAgents");
    }

    public EmployeeRequest<T> maxActiveTicketsOfSupportAgentsAs(String name){
        return maxActiveTicketsOfSupportAgentsAs(name, Q.supportAgents().unlimited());
    }

    public EmployeeRequest<T> maxActiveTicketsOfSupportAgentsAs(String name, SupportAgentRequest subRequest){
        return statsFromSupportAgentsAs(name, subRequest.maxActiveTickets(), true);
    }
    public EmployeeRequest<T> sumActiveTicketsOfSupportAgents(){
        return sumActiveTicketsOfSupportAgentsAs("sumActiveTicketsOfSupportAgents");
    }

    public EmployeeRequest<T> sumActiveTicketsOfSupportAgentsAs(String name){
        return sumActiveTicketsOfSupportAgentsAs(name, Q.supportAgents().unlimited());
    }

    public EmployeeRequest<T> sumActiveTicketsOfSupportAgentsAs(String name, SupportAgentRequest subRequest){
        return statsFromSupportAgentsAs(name, subRequest.sumActiveTickets(), true);
    }
    public EmployeeRequest<T> avgActiveTicketsOfSupportAgents(){
        return avgActiveTicketsOfSupportAgentsAs("avgActiveTicketsOfSupportAgents");
    }

    public EmployeeRequest<T> avgActiveTicketsOfSupportAgentsAs(String name){
        return avgActiveTicketsOfSupportAgentsAs(name, Q.supportAgents().unlimited());
    }

    public EmployeeRequest<T> avgActiveTicketsOfSupportAgentsAs(String name, SupportAgentRequest subRequest){
        return statsFromSupportAgentsAs(name, subRequest.avgActiveTickets(), true);
    }
    public EmployeeRequest<T> standardDeviationActiveTicketsOfSupportAgents(){
        return standardDeviationActiveTicketsOfSupportAgentsAs("stdDevActiveTicketsOfSupportAgents");
    }

    public EmployeeRequest<T> standardDeviationActiveTicketsOfSupportAgentsAs(String name){
        return standardDeviationActiveTicketsOfSupportAgentsAs(name, Q.supportAgents().unlimited());
    }

    public EmployeeRequest<T> standardDeviationActiveTicketsOfSupportAgentsAs(String name, SupportAgentRequest subRequest){
        return statsFromSupportAgentsAs(name, subRequest.standardDeviationActiveTickets(), true);
    }
    public EmployeeRequest<T> squareRootOfPopulationStandardDeviationActiveTicketsOfSupportAgents(){
        return squareRootOfPopulationStandardDeviationActiveTicketsOfSupportAgentsAs("stdDevPopActiveTicketsOfSupportAgents");
    }

    public EmployeeRequest<T> squareRootOfPopulationStandardDeviationActiveTicketsOfSupportAgentsAs(String name){
        return squareRootOfPopulationStandardDeviationActiveTicketsOfSupportAgentsAs(name, Q.supportAgents().unlimited());
    }

    public EmployeeRequest<T> squareRootOfPopulationStandardDeviationActiveTicketsOfSupportAgentsAs(String name, SupportAgentRequest subRequest){
        return statsFromSupportAgentsAs(name, subRequest.squareRootOfPopulationStandardDeviationActiveTickets(), true);
    }
    public EmployeeRequest<T> sampleVarianceActiveTicketsOfSupportAgents(){
        return sampleVarianceActiveTicketsOfSupportAgentsAs("varSampActiveTicketsOfSupportAgents");
    }

    public EmployeeRequest<T> sampleVarianceActiveTicketsOfSupportAgentsAs(String name){
        return sampleVarianceActiveTicketsOfSupportAgentsAs(name, Q.supportAgents().unlimited());
    }

    public EmployeeRequest<T> sampleVarianceActiveTicketsOfSupportAgentsAs(String name, SupportAgentRequest subRequest){
        return statsFromSupportAgentsAs(name, subRequest.sampleVarianceActiveTickets(), true);
    }
    public EmployeeRequest<T> samplePopulationVarianceActiveTicketsOfSupportAgents(){
        return samplePopulationVarianceActiveTicketsOfSupportAgentsAs("varPopActiveTicketsOfSupportAgents");
    }

    public EmployeeRequest<T> samplePopulationVarianceActiveTicketsOfSupportAgentsAs(String name){
        return samplePopulationVarianceActiveTicketsOfSupportAgentsAs(name, Q.supportAgents().unlimited());
    }

    public EmployeeRequest<T> samplePopulationVarianceActiveTicketsOfSupportAgentsAs(String name, SupportAgentRequest subRequest){
        return statsFromSupportAgentsAs(name, subRequest.samplePopulationVarianceActiveTickets(), true);
    }

   public EmployeeRequest<T> facetByDepartmentAs(String facetName, DepartmentRequest department){
       return facetByDepartmentAs(facetName, department, true);
   }

   public EmployeeRequest<T> facetByDepartmentAs(String facetName, DepartmentRequest department, boolean includeAllFacets){
       addFacet(facetName, Employee.DEPARTMENT_PROPERTY, department, includeAllFacets);
       return this;
   }


    /**
     * get topN records
     * @param topN  records number
     */
    public EmployeeRequest<T> top(int topN) {
        super.top(topN);
        return this;
    }

    /**
     * get records from offset(inclusive) to offset+size(exclusive)
     * @param offset record offset
     * @param size records number
     */
    public EmployeeRequest<T> offset(int offset, int size) {
        super.offset(offset, size);
        return this;
    }

    /**
     * retrieve all records
     */
    public EmployeeRequest<T> unlimited() {
        super.unlimited();
        return this;
    }

    /**
     * get records of one page
     * @param pageNumber page number(1-based)
     * @param pageSize page size
     */
    public EmployeeRequest<T> page(int pageNumber, int pageSize) {
        int offset = (pageNumber - 1) * pageSize;
        return offset(offset, pageSize);
   }

    /**
     * get records of one page, default page size is 10
     * @param pageNumber page number(1-based)
     */
    public EmployeeRequest<T> page(int pageNumber) {
        return page(pageNumber, 10);
   }
}