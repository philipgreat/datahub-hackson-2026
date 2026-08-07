
package com.example.enterpriseerpsystem.leaverequest;

import com.example.enterpriseerpsystem.employee.Employee;
import com.example.enterpriseerpsystem.employee.EmployeeChecker;
import io.teaql.core.UserContext;
import io.teaql.core.checker.Checker;
import io.teaql.core.checker.ObjectLocation;
import java.time.LocalDateTime;

public class LeaveRequestChecker implements Checker<LeaveRequest>{

    public String type(){
        return LeaveRequest.INTERNAL_TYPE;
    }

    public void checkAndFix(UserContext _ctx, LeaveRequest leaveRequest, ObjectLocation _parentLocation){
        if(needCheck(_ctx, leaveRequest)){
            markAsChecked(_ctx, leaveRequest);
            doCheck(_ctx, leaveRequest, _parentLocation);
        }
    }

    public void doCheck(UserContext _ctx, LeaveRequest leaveRequest, ObjectLocation _parentLocation){
      if((leaveRequest == null)){
         return;
      }
      if(leaveRequest.newItem()){
        if(leaveRequest.getEndDate() == null){
           leaveRequest.updateEndDate(java.time.LocalDateTime.now());
        }if(leaveRequest.getStartDate() == null){
           leaveRequest.updateStartDate(java.time.LocalDateTime.now());
        }if(leaveRequest.getCreateTime() == null){
           leaveRequest.updateCreateTime(java.time.LocalDateTime.now());
        }if(leaveRequest.getUpdateTime() == null){
           leaveRequest.updateUpdateTime(java.time.LocalDateTime.now());
        }
      }else if(leaveRequest.updateItem()){
        leaveRequest.updateUpdateTime(java.time.LocalDateTime.now());
      }
      checkEmployee(_ctx, leaveRequest.getProperty(LeaveRequest.EMPLOYEE_PROPERTY), newLocation(_parentLocation, LeaveRequest.EMPLOYEE_PROPERTY));
      checkEndDate(_ctx, leaveRequest.getProperty(LeaveRequest.END_DATE_PROPERTY), newLocation(_parentLocation, LeaveRequest.END_DATE_PROPERTY));
      checkReason(_ctx, leaveRequest.getProperty(LeaveRequest.REASON_PROPERTY), newLocation(_parentLocation, LeaveRequest.REASON_PROPERTY));
      checkStartDate(_ctx, leaveRequest.getProperty(LeaveRequest.START_DATE_PROPERTY), newLocation(_parentLocation, LeaveRequest.START_DATE_PROPERTY));
      checkStatus(_ctx, leaveRequest.getProperty(LeaveRequest.STATUS_PROPERTY), newLocation(_parentLocation, LeaveRequest.STATUS_PROPERTY));
      checkCreateTime(_ctx, leaveRequest.getProperty(LeaveRequest.CREATE_TIME_PROPERTY), newLocation(_parentLocation, LeaveRequest.CREATE_TIME_PROPERTY));
      checkUpdateTime(_ctx, leaveRequest.getProperty(LeaveRequest.UPDATE_TIME_PROPERTY), newLocation(_parentLocation, LeaveRequest.UPDATE_TIME_PROPERTY));
    }

    public void checkEmployee(UserContext _ctx, Employee employee, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, employee);
    if((employee == null)){
        return;
    }
    new EmployeeChecker().checkAndFix(_ctx, employee, _parentLocation);
    }
    public void checkEndDate(UserContext _ctx, LocalDateTime endDate, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, endDate);
    if((endDate == null)){
        return;
    }
    }
    public void checkReason(UserContext _ctx, String reason, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, reason);
    if((reason == null)){
        return;
    }
    maxStringCheck(_ctx, _parentLocation, 100, reason);

    }
    public void checkStartDate(UserContext _ctx, LocalDateTime startDate, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, startDate);
    if((startDate == null)){
        return;
    }
    }
    public void checkStatus(UserContext _ctx, String status, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, status);
    if((status == null)){
        return;
    }
    maxStringCheck(_ctx, _parentLocation, 100, status);

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