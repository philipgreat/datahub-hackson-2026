
package com.example.enterpriseerpsystem.employeereview;

import com.example.enterpriseerpsystem.employee.Employee;
import com.example.enterpriseerpsystem.employee.EmployeeChecker;
import io.teaql.core.UserContext;
import io.teaql.core.checker.Checker;
import io.teaql.core.checker.ObjectLocation;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class EmployeeReviewChecker implements Checker<EmployeeReview>{

    public String type(){
        return EmployeeReview.INTERNAL_TYPE;
    }

    public void checkAndFix(UserContext _ctx, EmployeeReview employeeReview, ObjectLocation _parentLocation){
        if(needCheck(_ctx, employeeReview)){
            markAsChecked(_ctx, employeeReview);
            doCheck(_ctx, employeeReview, _parentLocation);
        }
    }

    public void doCheck(UserContext _ctx, EmployeeReview employeeReview, ObjectLocation _parentLocation){
      if((employeeReview == null)){
         return;
      }
      if(employeeReview.newItem()){
        if(employeeReview.getReviewDate() == null){
           employeeReview.updateReviewDate(java.time.LocalDateTime.now());
        }if(employeeReview.getCreateTime() == null){
           employeeReview.updateCreateTime(java.time.LocalDateTime.now());
        }if(employeeReview.getUpdateTime() == null){
           employeeReview.updateUpdateTime(java.time.LocalDateTime.now());
        }
      }else if(employeeReview.updateItem()){
        employeeReview.updateUpdateTime(java.time.LocalDateTime.now());
      }
      checkComments(_ctx, employeeReview.getProperty(EmployeeReview.COMMENTS_PROPERTY), newLocation(_parentLocation, EmployeeReview.COMMENTS_PROPERTY));
      checkEmployee(_ctx, employeeReview.getProperty(EmployeeReview.EMPLOYEE_PROPERTY), newLocation(_parentLocation, EmployeeReview.EMPLOYEE_PROPERTY));
      checkReviewDate(_ctx, employeeReview.getProperty(EmployeeReview.REVIEW_DATE_PROPERTY), newLocation(_parentLocation, EmployeeReview.REVIEW_DATE_PROPERTY));
      checkReviewerId(_ctx, employeeReview.getProperty(EmployeeReview.REVIEWER_ID_PROPERTY), newLocation(_parentLocation, EmployeeReview.REVIEWER_ID_PROPERTY));
      checkScore(_ctx, employeeReview.getProperty(EmployeeReview.SCORE_PROPERTY), newLocation(_parentLocation, EmployeeReview.SCORE_PROPERTY));
      checkCreateTime(_ctx, employeeReview.getProperty(EmployeeReview.CREATE_TIME_PROPERTY), newLocation(_parentLocation, EmployeeReview.CREATE_TIME_PROPERTY));
      checkUpdateTime(_ctx, employeeReview.getProperty(EmployeeReview.UPDATE_TIME_PROPERTY), newLocation(_parentLocation, EmployeeReview.UPDATE_TIME_PROPERTY));
    }

    public void checkComments(UserContext _ctx, String comments, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, comments);
    if((comments == null)){
        return;
    }
    maxStringCheck(_ctx, _parentLocation, 100, comments);

    }
    public void checkEmployee(UserContext _ctx, Employee employee, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, employee);
    if((employee == null)){
        return;
    }
    new EmployeeChecker().checkAndFix(_ctx, employee, _parentLocation);
    }
    public void checkReviewDate(UserContext _ctx, LocalDateTime reviewDate, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, reviewDate);
    if((reviewDate == null)){
        return;
    }
    }
    public void checkReviewerId(UserContext _ctx, String reviewerId, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, reviewerId);
    if((reviewerId == null)){
        return;
    }
    maxStringCheck(_ctx, _parentLocation, 100, reviewerId);

    }
    public void checkScore(UserContext _ctx, BigDecimal score, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, score);
    if((score == null)){
        return;
    }
    }
    public void checkCreateTime(UserContext _ctx, LocalDateTime createTime, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, createTime);
    if((createTime == null)){
        return;
    }
    }
    public void checkUpdateTime(UserContext _ctx, LocalDateTime updateTime, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, updateTime);
    if((updateTime == null)){
        return;
    }
    }
}