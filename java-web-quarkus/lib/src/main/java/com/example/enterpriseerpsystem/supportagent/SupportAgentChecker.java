
package com.example.enterpriseerpsystem.supportagent;

import com.example.enterpriseerpsystem.employee.Employee;
import com.example.enterpriseerpsystem.employee.EmployeeChecker;
import io.teaql.core.UserContext;
import io.teaql.core.checker.Checker;
import io.teaql.core.checker.ObjectLocation;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class SupportAgentChecker implements Checker<SupportAgent>{

    public String type(){
        return SupportAgent.INTERNAL_TYPE;
    }

    public void checkAndFix(UserContext _ctx, SupportAgent supportAgent, ObjectLocation _parentLocation){
        if(needCheck(_ctx, supportAgent)){
            markAsChecked(_ctx, supportAgent);
            doCheck(_ctx, supportAgent, _parentLocation);
        }
    }

    public void doCheck(UserContext _ctx, SupportAgent supportAgent, ObjectLocation _parentLocation){
      if((supportAgent == null)){
         return;
      }
      if(supportAgent.newItem()){
        if(supportAgent.getCreateTime() == null){
           supportAgent.updateCreateTime(java.time.LocalDateTime.now());
        }if(supportAgent.getUpdateTime() == null){
           supportAgent.updateUpdateTime(java.time.LocalDateTime.now());
        }
      }else if(supportAgent.updateItem()){
        supportAgent.updateUpdateTime(java.time.LocalDateTime.now());
      }
      checkActiveTickets(_ctx, supportAgent.getProperty(SupportAgent.ACTIVE_TICKETS_PROPERTY), newLocation(_parentLocation, SupportAgent.ACTIVE_TICKETS_PROPERTY));
      checkEmployee(_ctx, supportAgent.getProperty(SupportAgent.EMPLOYEE_PROPERTY), newLocation(_parentLocation, SupportAgent.EMPLOYEE_PROPERTY));
      checkSpecialty(_ctx, supportAgent.getProperty(SupportAgent.SPECIALTY_PROPERTY), newLocation(_parentLocation, SupportAgent.SPECIALTY_PROPERTY));
      checkCreateTime(_ctx, supportAgent.getProperty(SupportAgent.CREATE_TIME_PROPERTY), newLocation(_parentLocation, SupportAgent.CREATE_TIME_PROPERTY));
      checkUpdateTime(_ctx, supportAgent.getProperty(SupportAgent.UPDATE_TIME_PROPERTY), newLocation(_parentLocation, SupportAgent.UPDATE_TIME_PROPERTY));
    }

    public void checkActiveTickets(UserContext _ctx, BigDecimal activeTickets, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, activeTickets);
    if((activeTickets == null)){
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
    public void checkSpecialty(UserContext _ctx, String specialty, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, specialty);
    if((specialty == null)){
        return;
    }
    maxStringCheck(_ctx, _parentLocation, 100, specialty);

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