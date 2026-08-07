
package com.example.enterpriseerpsystem.benefit;

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
public class Benefit extends BaseEntity implements RemoteInput {
    public static String INTERNAL_TYPE = "Benefit";

    public static final String COST_PROPERTY = "cost";
    public static final String EMPLOYEE_PROPERTY = "employee";
    public static final String PLAN_TYPE_PROPERTY = "planType";
    public static final String PROVIDER_PROPERTY = "provider";
    public static final String CREATE_TIME_PROPERTY = "createTime";
    public static final String UPDATE_TIME_PROPERTY = "updateTime";
    private BigDecimal cost;
    private Employee employee;
    private String planType;
    private String provider;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

    public BigDecimal getCost(){
        return this.cost;
    }
    public Employee getEmployee(){
        return this.employee;
    }
    public String getPlanType(){
        return this.planType;
    }
    public String getProvider(){
        return this.provider;
    }
    public LocalDateTime getCreateTime(){
        return this.createTime;
    }
    public LocalDateTime getUpdateTime(){
        return this.updateTime;
    }
    public Benefit updateCost(BigDecimal cost){
        if(Objects.equals(this.cost, cost)){
            return this;
        }
        handleUpdate(COST_PROPERTY, getCost(), cost);
        this.cost = cost;
        return this;
    }
    public Benefit updateEmployee(Employee employee){
        if(Objects.equals(this.employee, employee)){
            return this;
        }
        handleUpdate(EMPLOYEE_PROPERTY, getEmployee(), employee);
        this.employee = employee;
        return this;
    }
    public Benefit updatePlanType(String planType){
        planType = (planType == null ? null : planType.trim());
        if(Objects.equals(this.planType, planType)){
            return this;
        }
        handleUpdate(PLAN_TYPE_PROPERTY, getPlanType(), planType);
        this.planType = planType;
        return this;
    }
    public Benefit updateProvider(String provider){
        provider = (provider == null ? null : provider.trim());
        if(Objects.equals(this.provider, provider)){
            return this;
        }
        handleUpdate(PROVIDER_PROPERTY, getProvider(), provider);
        this.provider = provider;
        return this;
    }
    public Benefit updateCreateTime(LocalDateTime createTime){
        if(Objects.equals(this.createTime, createTime)){
            return this;
        }
        handleUpdate(CREATE_TIME_PROPERTY, getCreateTime(), createTime);
        this.createTime = createTime;
        return this;
    }
    public Benefit updateUpdateTime(LocalDateTime updateTime){
        if(Objects.equals(this.updateTime, updateTime)){
            return this;
        }
        handleUpdate(UPDATE_TIME_PROPERTY, getUpdateTime(), updateTime);
        this.updateTime = updateTime;
        return this;
    }

    public static Benefit refer(Long id){
        Benefit refer = new Benefit();
        refer.__internalSet("id", id);
        refer.set$status(EntityStatus.REFER);
        return refer;
    }
    @Override
    public String typeName(){
        return INTERNAL_TYPE;
    }

    public Benefit comment(String comment){
        this.setComment(comment);
        return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Audited<Benefit> auditAs(String action) {
        return super.auditAs(action);
    }

    // ===== Framework Internal: generated switch dispatch =====
    @Override
    @FrameworkInternal
    public void __internalSet(String property, Object value) {
        switch (property) {
            case "cost": this.cost = (BigDecimal) value; break;

            case "employee": this.employee = (Employee) value; break;

            case "planType": this.planType = (value == null ? null : ((String)value).trim()); break;

            case "provider": this.provider = (value == null ? null : ((String)value).trim()); break;

            case "createTime": this.createTime = (LocalDateTime) value; break;

            case "updateTime": this.updateTime = (LocalDateTime) value; break;

            default: super.__internalSet(property, value);
        }
    }

    @Override
    @FrameworkInternal
    public Object __internalGet(String property) {
        switch (property) {
            case "cost": return this.cost;
            case "employee": return this.employee;
            case "planType": return this.planType;
            case "provider": return this.provider;
            case "createTime": return this.createTime;
            case "updateTime": return this.updateTime;
            default: return super.__internalGet(property);
        }
    }

}