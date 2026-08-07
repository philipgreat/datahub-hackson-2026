
package com.example.enterpriseerpsystem.attendance;

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
public class Attendance extends BaseEntity implements RemoteInput {
    public static String INTERNAL_TYPE = "Attendance";

    public static final String CHECK_IN_PROPERTY = "checkIn";
    public static final String CHECK_OUT_PROPERTY = "checkOut";
    public static final String EMPLOYEE_PROPERTY = "employee";
    public static final String HOURS_WORKED_PROPERTY = "hoursWorked";
    public static final String CREATE_TIME_PROPERTY = "createTime";
    public static final String UPDATE_TIME_PROPERTY = "updateTime";
    private LocalDateTime checkIn;
    private LocalDateTime checkOut;
    private Employee employee;
    private BigDecimal hoursWorked;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

    public LocalDateTime getCheckIn(){
        return this.checkIn;
    }
    public LocalDateTime getCheckOut(){
        return this.checkOut;
    }
    public Employee getEmployee(){
        return this.employee;
    }
    public BigDecimal getHoursWorked(){
        return this.hoursWorked;
    }
    public LocalDateTime getCreateTime(){
        return this.createTime;
    }
    public LocalDateTime getUpdateTime(){
        return this.updateTime;
    }
    public Attendance updateCheckIn(LocalDateTime checkIn){
        if(Objects.equals(this.checkIn, checkIn)){
            return this;
        }
        handleUpdate(CHECK_IN_PROPERTY, getCheckIn(), checkIn);
        this.checkIn = checkIn;
        return this;
    }
    public Attendance updateCheckOut(LocalDateTime checkOut){
        if(Objects.equals(this.checkOut, checkOut)){
            return this;
        }
        handleUpdate(CHECK_OUT_PROPERTY, getCheckOut(), checkOut);
        this.checkOut = checkOut;
        return this;
    }
    public Attendance updateEmployee(Employee employee){
        if(Objects.equals(this.employee, employee)){
            return this;
        }
        handleUpdate(EMPLOYEE_PROPERTY, getEmployee(), employee);
        this.employee = employee;
        return this;
    }
    public Attendance updateHoursWorked(BigDecimal hoursWorked){
        if(Objects.equals(this.hoursWorked, hoursWorked)){
            return this;
        }
        handleUpdate(HOURS_WORKED_PROPERTY, getHoursWorked(), hoursWorked);
        this.hoursWorked = hoursWorked;
        return this;
    }
    public Attendance updateCreateTime(LocalDateTime createTime){
        if(Objects.equals(this.createTime, createTime)){
            return this;
        }
        handleUpdate(CREATE_TIME_PROPERTY, getCreateTime(), createTime);
        this.createTime = createTime;
        return this;
    }
    public Attendance updateUpdateTime(LocalDateTime updateTime){
        if(Objects.equals(this.updateTime, updateTime)){
            return this;
        }
        handleUpdate(UPDATE_TIME_PROPERTY, getUpdateTime(), updateTime);
        this.updateTime = updateTime;
        return this;
    }

    public static Attendance refer(Long id){
        Attendance refer = new Attendance();
        refer.__internalSet("id", id);
        refer.set$status(EntityStatus.REFER);
        return refer;
    }
    @Override
    public String typeName(){
        return INTERNAL_TYPE;
    }

    public Attendance comment(String comment){
        this.setComment(comment);
        return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Audited<Attendance> auditAs(String action) {
        return super.auditAs(action);
    }

    // ===== Framework Internal: generated switch dispatch =====
    @Override
    @FrameworkInternal
    public void __internalSet(String property, Object value) {
        switch (property) {
            case "checkIn": this.checkIn = (LocalDateTime) value; break;

            case "checkOut": this.checkOut = (LocalDateTime) value; break;

            case "employee": this.employee = (Employee) value; break;

            case "hoursWorked": this.hoursWorked = (BigDecimal) value; break;

            case "createTime": this.createTime = (LocalDateTime) value; break;

            case "updateTime": this.updateTime = (LocalDateTime) value; break;

            default: super.__internalSet(property, value);
        }
    }

    @Override
    @FrameworkInternal
    public Object __internalGet(String property) {
        switch (property) {
            case "checkIn": return this.checkIn;
            case "checkOut": return this.checkOut;
            case "employee": return this.employee;
            case "hoursWorked": return this.hoursWorked;
            case "createTime": return this.createTime;
            case "updateTime": return this.updateTime;
            default: return super.__internalGet(property);
        }
    }

}