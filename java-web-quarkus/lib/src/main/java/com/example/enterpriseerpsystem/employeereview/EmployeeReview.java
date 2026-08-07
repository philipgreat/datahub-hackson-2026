
package com.example.enterpriseerpsystem.employeereview;

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
public class EmployeeReview extends BaseEntity implements RemoteInput {
    public static String INTERNAL_TYPE = "EmployeeReview";

    public static final String COMMENTS_PROPERTY = "comments";
    public static final String EMPLOYEE_PROPERTY = "employee";
    public static final String REVIEW_DATE_PROPERTY = "reviewDate";
    public static final String REVIEWER_ID_PROPERTY = "reviewerId";
    public static final String SCORE_PROPERTY = "score";
    public static final String CREATE_TIME_PROPERTY = "createTime";
    public static final String UPDATE_TIME_PROPERTY = "updateTime";
    private String comments;
    private Employee employee;
    private LocalDateTime reviewDate;
    private String reviewerId;
    private BigDecimal score;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

    public String getComments(){
        return this.comments;
    }
    public Employee getEmployee(){
        return this.employee;
    }
    public LocalDateTime getReviewDate(){
        return this.reviewDate;
    }
    public String getReviewerId(){
        return this.reviewerId;
    }
    public BigDecimal getScore(){
        return this.score;
    }
    public LocalDateTime getCreateTime(){
        return this.createTime;
    }
    public LocalDateTime getUpdateTime(){
        return this.updateTime;
    }
    public EmployeeReview updateComments(String comments){
        comments = (comments == null ? null : comments.trim());
        if(Objects.equals(this.comments, comments)){
            return this;
        }
        handleUpdate(COMMENTS_PROPERTY, getComments(), comments);
        this.comments = comments;
        return this;
    }
    public EmployeeReview updateEmployee(Employee employee){
        if(Objects.equals(this.employee, employee)){
            return this;
        }
        handleUpdate(EMPLOYEE_PROPERTY, getEmployee(), employee);
        this.employee = employee;
        return this;
    }
    public EmployeeReview updateReviewDate(LocalDateTime reviewDate){
        if(Objects.equals(this.reviewDate, reviewDate)){
            return this;
        }
        handleUpdate(REVIEW_DATE_PROPERTY, getReviewDate(), reviewDate);
        this.reviewDate = reviewDate;
        return this;
    }
    public EmployeeReview updateReviewerId(String reviewerId){
        reviewerId = (reviewerId == null ? null : reviewerId.trim());
        if(Objects.equals(this.reviewerId, reviewerId)){
            return this;
        }
        handleUpdate(REVIEWER_ID_PROPERTY, getReviewerId(), reviewerId);
        this.reviewerId = reviewerId;
        return this;
    }
    public EmployeeReview updateScore(BigDecimal score){
        if(Objects.equals(this.score, score)){
            return this;
        }
        handleUpdate(SCORE_PROPERTY, getScore(), score);
        this.score = score;
        return this;
    }
    public EmployeeReview updateCreateTime(LocalDateTime createTime){
        if(Objects.equals(this.createTime, createTime)){
            return this;
        }
        handleUpdate(CREATE_TIME_PROPERTY, getCreateTime(), createTime);
        this.createTime = createTime;
        return this;
    }
    public EmployeeReview updateUpdateTime(LocalDateTime updateTime){
        if(Objects.equals(this.updateTime, updateTime)){
            return this;
        }
        handleUpdate(UPDATE_TIME_PROPERTY, getUpdateTime(), updateTime);
        this.updateTime = updateTime;
        return this;
    }

    public static EmployeeReview refer(Long id){
        EmployeeReview refer = new EmployeeReview();
        refer.__internalSet("id", id);
        refer.set$status(EntityStatus.REFER);
        return refer;
    }
    @Override
    public String typeName(){
        return INTERNAL_TYPE;
    }

    public EmployeeReview comment(String comment){
        this.setComment(comment);
        return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Audited<EmployeeReview> auditAs(String action) {
        return super.auditAs(action);
    }

    // ===== Framework Internal: generated switch dispatch =====
    @Override
    @FrameworkInternal
    public void __internalSet(String property, Object value) {
        switch (property) {
            case "comments": this.comments = (value == null ? null : ((String)value).trim()); break;

            case "employee": this.employee = (Employee) value; break;

            case "reviewDate": this.reviewDate = (LocalDateTime) value; break;

            case "reviewerId": this.reviewerId = (value == null ? null : ((String)value).trim()); break;

            case "score": this.score = (BigDecimal) value; break;

            case "createTime": this.createTime = (LocalDateTime) value; break;

            case "updateTime": this.updateTime = (LocalDateTime) value; break;

            default: super.__internalSet(property, value);
        }
    }

    @Override
    @FrameworkInternal
    public Object __internalGet(String property) {
        switch (property) {
            case "comments": return this.comments;
            case "employee": return this.employee;
            case "reviewDate": return this.reviewDate;
            case "reviewerId": return this.reviewerId;
            case "score": return this.score;
            case "createTime": return this.createTime;
            case "updateTime": return this.updateTime;
            default: return super.__internalGet(property);
        }
    }

}