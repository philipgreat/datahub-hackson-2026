
package com.example.enterpriseerpsystem.leaverequest;

import com.example.enterpriseerpsystem.employee.Employee;
import io.teaql.core.Audited;
import io.teaql.core.BaseEntity;
import io.teaql.core.EntityStatus;
import io.teaql.core.FrameworkInternal;
import io.teaql.core.RemoteInput;
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
public class LeaveRequest extends BaseEntity implements RemoteInput {
    public static String INTERNAL_TYPE = "LeaveRequest";

    public static final String EMPLOYEE_PROPERTY = "employee";
    public static final String END_DATE_PROPERTY = "endDate";
    public static final String REASON_PROPERTY = "reason";
    public static final String START_DATE_PROPERTY = "startDate";
    public static final String STATUS_PROPERTY = "status";
    public static final String CREATE_TIME_PROPERTY = "createTime";
    public static final String UPDATE_TIME_PROPERTY = "updateTime";
    private Employee employee;
    private LocalDateTime endDate;
    private String reason;
    private LocalDateTime startDate;
    private String status;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

    public Employee getEmployee(){
        return this.employee;
    }
    public LocalDateTime getEndDate(){
        return this.endDate;
    }
    public String getReason(){
        return this.reason;
    }
    public LocalDateTime getStartDate(){
        return this.startDate;
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
    public LeaveRequest updateEmployee(Employee employee){
        if(Objects.equals(this.employee, employee)){
            return this;
        }
        handleUpdate(EMPLOYEE_PROPERTY, getEmployee(), employee);
        this.employee = employee;
        return this;
    }
    public LeaveRequest updateEndDate(LocalDateTime endDate){
        if(Objects.equals(this.endDate, endDate)){
            return this;
        }
        handleUpdate(END_DATE_PROPERTY, getEndDate(), endDate);
        this.endDate = endDate;
        return this;
    }
    public LeaveRequest updateReason(String reason){
        reason = (reason == null ? null : reason.trim());
        if(Objects.equals(this.reason, reason)){
            return this;
        }
        handleUpdate(REASON_PROPERTY, getReason(), reason);
        this.reason = reason;
        return this;
    }
    public LeaveRequest updateStartDate(LocalDateTime startDate){
        if(Objects.equals(this.startDate, startDate)){
            return this;
        }
        handleUpdate(START_DATE_PROPERTY, getStartDate(), startDate);
        this.startDate = startDate;
        return this;
    }
    public LeaveRequest updateStatus(String status){
        status = (status == null ? null : status.trim());
        if(Objects.equals(this.status, status)){
            return this;
        }
        handleUpdate(STATUS_PROPERTY, getStatus(), status);
        this.status = status;
        return this;
    }
    public LeaveRequest updateCreateTime(LocalDateTime createTime){
        if(Objects.equals(this.createTime, createTime)){
            return this;
        }
        handleUpdate(CREATE_TIME_PROPERTY, getCreateTime(), createTime);
        this.createTime = createTime;
        return this;
    }
    public LeaveRequest updateUpdateTime(LocalDateTime updateTime){
        if(Objects.equals(this.updateTime, updateTime)){
            return this;
        }
        handleUpdate(UPDATE_TIME_PROPERTY, getUpdateTime(), updateTime);
        this.updateTime = updateTime;
        return this;
    }

    public static LeaveRequest refer(Long id){
        LeaveRequest refer = new LeaveRequest();
        refer.__internalSet("id", id);
        refer.set$status(EntityStatus.REFER);
        return refer;
    }
    @Override
    public String typeName(){
        return INTERNAL_TYPE;
    }

    public LeaveRequest comment(String comment){
        this.setComment(comment);
        return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Audited<LeaveRequest> auditAs(String action) {
        return super.auditAs(action);
    }

    // ===== Framework Internal: generated switch dispatch =====
    @Override
    @FrameworkInternal
    public void __internalSet(String property, Object value) {
        switch (property) {
            case "employee": this.employee = (Employee) value; break;

            case "endDate": this.endDate = (LocalDateTime) value; break;

            case "reason": this.reason = (value == null ? null : ((String)value).trim()); break;

            case "startDate": this.startDate = (LocalDateTime) value; break;

            case "status": this.status = (value == null ? null : ((String)value).trim()); break;

            case "createTime": this.createTime = (LocalDateTime) value; break;

            case "updateTime": this.updateTime = (LocalDateTime) value; break;

            default: super.__internalSet(property, value);
        }
    }

    @Override
    @FrameworkInternal
    public Object __internalGet(String property) {
        switch (property) {
            case "employee": return this.employee;
            case "endDate": return this.endDate;
            case "reason": return this.reason;
            case "startDate": return this.startDate;
            case "status": return this.status;
            case "createTime": return this.createTime;
            case "updateTime": return this.updateTime;
            default: return super.__internalGet(property);
        }
    }

}