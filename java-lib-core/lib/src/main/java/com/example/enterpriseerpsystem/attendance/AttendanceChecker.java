
package com.example.enterpriseerpsystem.attendance;

import com.example.enterpriseerpsystem.employee.Employee;
import com.example.enterpriseerpsystem.employee.EmployeeChecker;
import io.teaql.core.UserContext;
import io.teaql.core.checker.Checker;
import io.teaql.core.checker.ObjectLocation;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class AttendanceChecker implements Checker<Attendance>{

    public String type(){
        return Attendance.INTERNAL_TYPE;
    }

    public void checkAndFix(UserContext _ctx, Attendance attendance, ObjectLocation _parentLocation){
        if(needCheck(_ctx, attendance)){
            markAsChecked(_ctx, attendance);
            doCheck(_ctx, attendance, _parentLocation);
        }
    }

    public void doCheck(UserContext _ctx, Attendance attendance, ObjectLocation _parentLocation){
      if((attendance == null)){
         return;
      }
      if(attendance.newItem()){
        if(attendance.getCheckIn() == null){
           attendance.updateCheckIn(java.time.LocalDateTime.now());
        }if(attendance.getCheckOut() == null){
           attendance.updateCheckOut(java.time.LocalDateTime.now());
        }if(attendance.getCreateTime() == null){
           attendance.updateCreateTime(java.time.LocalDateTime.now());
        }if(attendance.getUpdateTime() == null){
           attendance.updateUpdateTime(java.time.LocalDateTime.now());
        }
      }else if(attendance.updateItem()){
        attendance.updateUpdateTime(java.time.LocalDateTime.now());
      }
      checkCheckIn(_ctx, attendance.getProperty(Attendance.CHECK_IN_PROPERTY), newLocation(_parentLocation, Attendance.CHECK_IN_PROPERTY));
      checkCheckOut(_ctx, attendance.getProperty(Attendance.CHECK_OUT_PROPERTY), newLocation(_parentLocation, Attendance.CHECK_OUT_PROPERTY));
      checkEmployee(_ctx, attendance.getProperty(Attendance.EMPLOYEE_PROPERTY), newLocation(_parentLocation, Attendance.EMPLOYEE_PROPERTY));
      checkHoursWorked(_ctx, attendance.getProperty(Attendance.HOURS_WORKED_PROPERTY), newLocation(_parentLocation, Attendance.HOURS_WORKED_PROPERTY));
      checkCreateTime(_ctx, attendance.getProperty(Attendance.CREATE_TIME_PROPERTY), newLocation(_parentLocation, Attendance.CREATE_TIME_PROPERTY));
      checkUpdateTime(_ctx, attendance.getProperty(Attendance.UPDATE_TIME_PROPERTY), newLocation(_parentLocation, Attendance.UPDATE_TIME_PROPERTY));
    }

    public void checkCheckIn(UserContext _ctx, LocalDateTime checkIn, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, checkIn);
    if((checkIn == null)){
        return;
    }
    }
    public void checkCheckOut(UserContext _ctx, LocalDateTime checkOut, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, checkOut);
    if((checkOut == null)){
        return;
    }
    }
    public void checkEmployee(UserContext _ctx, Employee employee, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, employee);
    if((employee == null)){
        return;
    }
    new EmployeeChecker().checkAndFix(_ctx, employee, _parentLocation);
    }
    public void checkHoursWorked(UserContext _ctx, BigDecimal hoursWorked, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, hoursWorked);
    if((hoursWorked == null)){
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