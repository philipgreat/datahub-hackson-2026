
package com.example.enterpriseerpsystem.payroll;

import com.example.enterpriseerpsystem.employee.Employee;
import io.teaql.core.Audited;
import io.teaql.core.BaseEntity;
import io.teaql.core.EntityStatus;
import io.teaql.core.FrameworkInternal;
import io.teaql.core.RemoteInput;
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
public class Payroll extends BaseEntity implements RemoteInput {
    public static String INTERNAL_TYPE = "Payroll";

    public static final String TAX_PROPERTY = "tax";
    public static final String EMPLOYEE_PROPERTY = "employee";
    public static final String GROSS_PAY_PROPERTY = "grossPay";
    public static final String NET_PAY_PROPERTY = "netPay";
    public static final String PERIOD_END_PROPERTY = "periodEnd";
    public static final String PERIOD_START_PROPERTY = "periodStart";
    public static final String CREATE_TIME_PROPERTY = "createTime";
    public static final String UPDATE_TIME_PROPERTY = "updateTime";
    private BigDecimal tax;
    private Employee employee;
    private BigDecimal grossPay;
    private BigDecimal netPay;
    private LocalDateTime periodEnd;
    private LocalDateTime periodStart;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

    public BigDecimal getTax(){
        return this.tax;
    }
    public Employee getEmployee(){
        return this.employee;
    }
    public BigDecimal getGrossPay(){
        return this.grossPay;
    }
    public BigDecimal getNetPay(){
        return this.netPay;
    }
    public LocalDateTime getPeriodEnd(){
        return this.periodEnd;
    }
    public LocalDateTime getPeriodStart(){
        return this.periodStart;
    }
    public LocalDateTime getCreateTime(){
        return this.createTime;
    }
    public LocalDateTime getUpdateTime(){
        return this.updateTime;
    }
    public Payroll updateTax(BigDecimal tax){
        if(Objects.equals(this.tax, tax)){
            return this;
        }
        handleUpdate(TAX_PROPERTY, getTax(), tax);
        this.tax = tax;
        return this;
    }
    public Payroll updateEmployee(Employee employee){
        if(Objects.equals(this.employee, employee)){
            return this;
        }
        handleUpdate(EMPLOYEE_PROPERTY, getEmployee(), employee);
        this.employee = employee;
        return this;
    }
    public Payroll updateGrossPay(BigDecimal grossPay){
        if(Objects.equals(this.grossPay, grossPay)){
            return this;
        }
        handleUpdate(GROSS_PAY_PROPERTY, getGrossPay(), grossPay);
        this.grossPay = grossPay;
        return this;
    }
    public Payroll updateNetPay(BigDecimal netPay){
        if(Objects.equals(this.netPay, netPay)){
            return this;
        }
        handleUpdate(NET_PAY_PROPERTY, getNetPay(), netPay);
        this.netPay = netPay;
        return this;
    }
    public Payroll updatePeriodEnd(LocalDateTime periodEnd){
        if(Objects.equals(this.periodEnd, periodEnd)){
            return this;
        }
        handleUpdate(PERIOD_END_PROPERTY, getPeriodEnd(), periodEnd);
        this.periodEnd = periodEnd;
        return this;
    }
    public Payroll updatePeriodStart(LocalDateTime periodStart){
        if(Objects.equals(this.periodStart, periodStart)){
            return this;
        }
        handleUpdate(PERIOD_START_PROPERTY, getPeriodStart(), periodStart);
        this.periodStart = periodStart;
        return this;
    }
    public Payroll updateCreateTime(LocalDateTime createTime){
        if(Objects.equals(this.createTime, createTime)){
            return this;
        }
        handleUpdate(CREATE_TIME_PROPERTY, getCreateTime(), createTime);
        this.createTime = createTime;
        return this;
    }
    public Payroll updateUpdateTime(LocalDateTime updateTime){
        if(Objects.equals(this.updateTime, updateTime)){
            return this;
        }
        handleUpdate(UPDATE_TIME_PROPERTY, getUpdateTime(), updateTime);
        this.updateTime = updateTime;
        return this;
    }

    public static Payroll refer(Long id){
        Payroll refer = new Payroll();
        refer.__internalSet("id", id);
        refer.set$status(EntityStatus.REFER);
        return refer;
    }
    @Override
    public String typeName(){
        return INTERNAL_TYPE;
    }

    public Payroll comment(String comment){
        this.setComment(comment);
        return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Audited<Payroll> auditAs(String action) {
        return super.auditAs(action);
    }

    // ===== Framework Internal: generated switch dispatch =====
    @Override
    @FrameworkInternal
    public void __internalSet(String property, Object value) {
        switch (property) {
            case "tax": this.tax = (BigDecimal) value; break;

            case "employee": this.employee = (Employee) value; break;

            case "grossPay": this.grossPay = (BigDecimal) value; break;

            case "netPay": this.netPay = (BigDecimal) value; break;

            case "periodEnd": this.periodEnd = (LocalDateTime) value; break;

            case "periodStart": this.periodStart = (LocalDateTime) value; break;

            case "createTime": this.createTime = (LocalDateTime) value; break;

            case "updateTime": this.updateTime = (LocalDateTime) value; break;

            default: super.__internalSet(property, value);
        }
    }

    @Override
    @FrameworkInternal
    public Object __internalGet(String property) {
        switch (property) {
            case "tax": return this.tax;
            case "employee": return this.employee;
            case "grossPay": return this.grossPay;
            case "netPay": return this.netPay;
            case "periodEnd": return this.periodEnd;
            case "periodStart": return this.periodStart;
            case "createTime": return this.createTime;
            case "updateTime": return this.updateTime;
            default: return super.__internalGet(property);
        }
    }

}