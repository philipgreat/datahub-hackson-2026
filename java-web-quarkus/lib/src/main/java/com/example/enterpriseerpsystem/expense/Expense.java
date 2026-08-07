
package com.example.enterpriseerpsystem.expense;

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
public class Expense extends BaseEntity implements RemoteInput {
    public static String INTERNAL_TYPE = "Expense";

    public static final String AMOUNT_PROPERTY = "amount";
    public static final String CATEGORY_PROPERTY = "category";
    public static final String DATE_INCURRED_PROPERTY = "dateIncurred";
    public static final String EMPLOYEE_PROPERTY = "employee";
    public static final String STATUS_PROPERTY = "status";
    public static final String CREATE_TIME_PROPERTY = "createTime";
    public static final String UPDATE_TIME_PROPERTY = "updateTime";
    private BigDecimal amount;
    private String category;
    private LocalDateTime dateIncurred;
    private Employee employee;
    private String status;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

    public BigDecimal getAmount(){
        return this.amount;
    }
    public String getCategory(){
        return this.category;
    }
    public LocalDateTime getDateIncurred(){
        return this.dateIncurred;
    }
    public Employee getEmployee(){
        return this.employee;
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
    public Expense updateAmount(BigDecimal amount){
        if(Objects.equals(this.amount, amount)){
            return this;
        }
        handleUpdate(AMOUNT_PROPERTY, getAmount(), amount);
        this.amount = amount;
        return this;
    }
    public Expense updateCategory(String category){
        category = (category == null ? null : category.trim());
        if(Objects.equals(this.category, category)){
            return this;
        }
        handleUpdate(CATEGORY_PROPERTY, getCategory(), category);
        this.category = category;
        return this;
    }
    public Expense updateDateIncurred(LocalDateTime dateIncurred){
        if(Objects.equals(this.dateIncurred, dateIncurred)){
            return this;
        }
        handleUpdate(DATE_INCURRED_PROPERTY, getDateIncurred(), dateIncurred);
        this.dateIncurred = dateIncurred;
        return this;
    }
    public Expense updateEmployee(Employee employee){
        if(Objects.equals(this.employee, employee)){
            return this;
        }
        handleUpdate(EMPLOYEE_PROPERTY, getEmployee(), employee);
        this.employee = employee;
        return this;
    }
    public Expense updateStatus(String status){
        status = (status == null ? null : status.trim());
        if(Objects.equals(this.status, status)){
            return this;
        }
        handleUpdate(STATUS_PROPERTY, getStatus(), status);
        this.status = status;
        return this;
    }
    public Expense updateCreateTime(LocalDateTime createTime){
        if(Objects.equals(this.createTime, createTime)){
            return this;
        }
        handleUpdate(CREATE_TIME_PROPERTY, getCreateTime(), createTime);
        this.createTime = createTime;
        return this;
    }
    public Expense updateUpdateTime(LocalDateTime updateTime){
        if(Objects.equals(this.updateTime, updateTime)){
            return this;
        }
        handleUpdate(UPDATE_TIME_PROPERTY, getUpdateTime(), updateTime);
        this.updateTime = updateTime;
        return this;
    }

    public static Expense refer(Long id){
        Expense refer = new Expense();
        refer.__internalSet("id", id);
        refer.set$status(EntityStatus.REFER);
        return refer;
    }
    @Override
    public String typeName(){
        return INTERNAL_TYPE;
    }

    public Expense comment(String comment){
        this.setComment(comment);
        return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Audited<Expense> auditAs(String action) {
        return super.auditAs(action);
    }

    // ===== Framework Internal: generated switch dispatch =====
    @Override
    @FrameworkInternal
    public void __internalSet(String property, Object value) {
        switch (property) {
            case "amount": this.amount = (BigDecimal) value; break;

            case "category": this.category = (value == null ? null : ((String)value).trim()); break;

            case "dateIncurred": this.dateIncurred = (LocalDateTime) value; break;

            case "employee": this.employee = (Employee) value; break;

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
            case "amount": return this.amount;
            case "category": return this.category;
            case "dateIncurred": return this.dateIncurred;
            case "employee": return this.employee;
            case "status": return this.status;
            case "createTime": return this.createTime;
            case "updateTime": return this.updateTime;
            default: return super.__internalGet(property);
        }
    }

}