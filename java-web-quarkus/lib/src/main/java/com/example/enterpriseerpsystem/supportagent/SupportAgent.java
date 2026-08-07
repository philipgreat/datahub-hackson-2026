
package com.example.enterpriseerpsystem.supportagent;

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
public class SupportAgent extends BaseEntity implements RemoteInput {
    public static String INTERNAL_TYPE = "SupportAgent";

    public static final String ACTIVE_TICKETS_PROPERTY = "activeTickets";
    public static final String EMPLOYEE_PROPERTY = "employee";
    public static final String SPECIALTY_PROPERTY = "specialty";
    public static final String CREATE_TIME_PROPERTY = "createTime";
    public static final String UPDATE_TIME_PROPERTY = "updateTime";
    private BigDecimal activeTickets;
    private Employee employee;
    private String specialty;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

    public BigDecimal getActiveTickets(){
        return this.activeTickets;
    }
    public Employee getEmployee(){
        return this.employee;
    }
    public String getSpecialty(){
        return this.specialty;
    }
    public LocalDateTime getCreateTime(){
        return this.createTime;
    }
    public LocalDateTime getUpdateTime(){
        return this.updateTime;
    }
    public SupportAgent updateActiveTickets(BigDecimal activeTickets){
        if(Objects.equals(this.activeTickets, activeTickets)){
            return this;
        }
        handleUpdate(ACTIVE_TICKETS_PROPERTY, getActiveTickets(), activeTickets);
        this.activeTickets = activeTickets;
        return this;
    }
    public SupportAgent updateEmployee(Employee employee){
        if(Objects.equals(this.employee, employee)){
            return this;
        }
        handleUpdate(EMPLOYEE_PROPERTY, getEmployee(), employee);
        this.employee = employee;
        return this;
    }
    public SupportAgent updateSpecialty(String specialty){
        specialty = (specialty == null ? null : specialty.trim());
        if(Objects.equals(this.specialty, specialty)){
            return this;
        }
        handleUpdate(SPECIALTY_PROPERTY, getSpecialty(), specialty);
        this.specialty = specialty;
        return this;
    }
    public SupportAgent updateCreateTime(LocalDateTime createTime){
        if(Objects.equals(this.createTime, createTime)){
            return this;
        }
        handleUpdate(CREATE_TIME_PROPERTY, getCreateTime(), createTime);
        this.createTime = createTime;
        return this;
    }
    public SupportAgent updateUpdateTime(LocalDateTime updateTime){
        if(Objects.equals(this.updateTime, updateTime)){
            return this;
        }
        handleUpdate(UPDATE_TIME_PROPERTY, getUpdateTime(), updateTime);
        this.updateTime = updateTime;
        return this;
    }

    public static SupportAgent refer(Long id){
        SupportAgent refer = new SupportAgent();
        refer.__internalSet("id", id);
        refer.set$status(EntityStatus.REFER);
        return refer;
    }
    @Override
    public String typeName(){
        return INTERNAL_TYPE;
    }

    public SupportAgent comment(String comment){
        this.setComment(comment);
        return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Audited<SupportAgent> auditAs(String action) {
        return super.auditAs(action);
    }

    // ===== Framework Internal: generated switch dispatch =====
    @Override
    @FrameworkInternal
    public void __internalSet(String property, Object value) {
        switch (property) {
            case "activeTickets": this.activeTickets = (BigDecimal) value; break;

            case "employee": this.employee = (Employee) value; break;

            case "specialty": this.specialty = (value == null ? null : ((String)value).trim()); break;

            case "createTime": this.createTime = (LocalDateTime) value; break;

            case "updateTime": this.updateTime = (LocalDateTime) value; break;

            default: super.__internalSet(property, value);
        }
    }

    @Override
    @FrameworkInternal
    public Object __internalGet(String property) {
        switch (property) {
            case "activeTickets": return this.activeTickets;
            case "employee": return this.employee;
            case "specialty": return this.specialty;
            case "createTime": return this.createTime;
            case "updateTime": return this.updateTime;
            default: return super.__internalGet(property);
        }
    }

}