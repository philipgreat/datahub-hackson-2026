
package com.example.enterpriseerpsystem.department;

import com.example.enterpriseerpsystem.employee.Employee;
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
public class Department extends BaseEntity implements RemoteInput {
    public static String INTERNAL_TYPE = "Department";

    public static final String NAME_PROPERTY = "name";
    public static final String BUDGET_PROPERTY = "budget";
    public static final String LOCATION_PROPERTY = "location";
    public static final String MANAGER_ID_PROPERTY = "managerId";
    public static final String CREATE_TIME_PROPERTY = "createTime";
    public static final String UPDATE_TIME_PROPERTY = "updateTime";
    public static final String EMPLOYEE_LIST_PROPERTY = "employeeList";
    private String name;
    private BigDecimal budget;
    private String location;
    private String managerId;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private SmartList<Employee> employeeList;

    public String getName(){
        return this.name;
    }
    public BigDecimal getBudget(){
        return this.budget;
    }
    public String getLocation(){
        return this.location;
    }
    public String getManagerId(){
        return this.managerId;
    }
    public LocalDateTime getCreateTime(){
        return this.createTime;
    }
    public LocalDateTime getUpdateTime(){
        return this.updateTime;
    }
    public SmartList<Employee> getEmployeeList(){
        return this.employeeList;
    }
    public Department updateName(String name){
        name = (name == null ? null : name.trim());
        if(Objects.equals(this.name, name)){
            return this;
        }
        handleUpdate(NAME_PROPERTY, getName(), name);
        this.name = name;
        return this;
    }
    public Department updateBudget(BigDecimal budget){
        if(Objects.equals(this.budget, budget)){
            return this;
        }
        handleUpdate(BUDGET_PROPERTY, getBudget(), budget);
        this.budget = budget;
        return this;
    }
    public Department updateLocation(String location){
        location = (location == null ? null : location.trim());
        if(Objects.equals(this.location, location)){
            return this;
        }
        handleUpdate(LOCATION_PROPERTY, getLocation(), location);
        this.location = location;
        return this;
    }
    public Department updateManagerId(String managerId){
        managerId = (managerId == null ? null : managerId.trim());
        if(Objects.equals(this.managerId, managerId)){
            return this;
        }
        handleUpdate(MANAGER_ID_PROPERTY, getManagerId(), managerId);
        this.managerId = managerId;
        return this;
    }
    public Department updateCreateTime(LocalDateTime createTime){
        if(Objects.equals(this.createTime, createTime)){
            return this;
        }
        handleUpdate(CREATE_TIME_PROPERTY, getCreateTime(), createTime);
        this.createTime = createTime;
        return this;
    }
    public Department updateUpdateTime(LocalDateTime updateTime){
        if(Objects.equals(this.updateTime, updateTime)){
            return this;
        }
        handleUpdate(UPDATE_TIME_PROPERTY, getUpdateTime(), updateTime);
        this.updateTime = updateTime;
        return this;
    }
    public Department addEmployee(Employee employee){
        if (employee == null){
            return this;
        }

        if(null == this.employeeList){
            this.employeeList = new SmartList<>();
        }

        this.employeeList.add(employee);
        employee.cacheRelation(Employee.DEPARTMENT_PROPERTY, this);
        return this;
    }

    public static Department refer(Long id){
        Department refer = new Department();
        refer.__internalSet("id", id);
        refer.set$status(EntityStatus.REFER);
        return refer;
    }
    @Override
    public String typeName(){
        return INTERNAL_TYPE;
    }

    public Department comment(String comment){
        this.setComment(comment);
        return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Audited<Department> auditAs(String action) {
        return super.auditAs(action);
    }

    // ===== Framework Internal: generated switch dispatch =====
    @Override
    @FrameworkInternal
    public void __internalSet(String property, Object value) {
        switch (property) {
            case "name": this.name = (value == null ? null : ((String)value).trim()); break;

            case "budget": this.budget = (BigDecimal) value; break;

            case "location": this.location = (value == null ? null : ((String)value).trim()); break;

            case "managerId": this.managerId = (value == null ? null : ((String)value).trim()); break;

            case "createTime": this.createTime = (LocalDateTime) value; break;

            case "updateTime": this.updateTime = (LocalDateTime) value; break;

            case "employeeList": this.employeeList = (SmartList<Employee>) value; break;
            default: super.__internalSet(property, value);
        }
    }

    @Override
    @FrameworkInternal
    public Object __internalGet(String property) {
        switch (property) {
            case "name": return this.name;
            case "budget": return this.budget;
            case "location": return this.location;
            case "managerId": return this.managerId;
            case "createTime": return this.createTime;
            case "updateTime": return this.updateTime;
            case "employeeList": return this.employeeList;
            default: return super.__internalGet(property);
        }
    }

}