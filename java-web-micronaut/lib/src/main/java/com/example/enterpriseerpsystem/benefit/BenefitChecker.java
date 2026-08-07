
package com.example.enterpriseerpsystem.benefit;

import com.example.enterpriseerpsystem.employee.Employee;
import com.example.enterpriseerpsystem.employee.EmployeeChecker;
import io.teaql.core.UserContext;
import io.teaql.core.checker.Checker;
import io.teaql.core.checker.ObjectLocation;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class BenefitChecker implements Checker<Benefit>{

    public String type(){
        return Benefit.INTERNAL_TYPE;
    }

    public void checkAndFix(UserContext _ctx, Benefit benefit, ObjectLocation _parentLocation){
        if(needCheck(_ctx, benefit)){
            markAsChecked(_ctx, benefit);
            doCheck(_ctx, benefit, _parentLocation);
        }
    }

    public void doCheck(UserContext _ctx, Benefit benefit, ObjectLocation _parentLocation){
      if((benefit == null)){
         return;
      }
      if(benefit.newItem()){
        if(benefit.getCreateTime() == null){
           benefit.updateCreateTime(java.time.LocalDateTime.now());
        }if(benefit.getUpdateTime() == null){
           benefit.updateUpdateTime(java.time.LocalDateTime.now());
        }
      }else if(benefit.updateItem()){
        benefit.updateUpdateTime(java.time.LocalDateTime.now());
      }
      checkCost(_ctx, benefit.getProperty(Benefit.COST_PROPERTY), newLocation(_parentLocation, Benefit.COST_PROPERTY));
      checkEmployee(_ctx, benefit.getProperty(Benefit.EMPLOYEE_PROPERTY), newLocation(_parentLocation, Benefit.EMPLOYEE_PROPERTY));
      checkPlanType(_ctx, benefit.getProperty(Benefit.PLAN_TYPE_PROPERTY), newLocation(_parentLocation, Benefit.PLAN_TYPE_PROPERTY));
      checkProvider(_ctx, benefit.getProperty(Benefit.PROVIDER_PROPERTY), newLocation(_parentLocation, Benefit.PROVIDER_PROPERTY));
      checkCreateTime(_ctx, benefit.getProperty(Benefit.CREATE_TIME_PROPERTY), newLocation(_parentLocation, Benefit.CREATE_TIME_PROPERTY));
      checkUpdateTime(_ctx, benefit.getProperty(Benefit.UPDATE_TIME_PROPERTY), newLocation(_parentLocation, Benefit.UPDATE_TIME_PROPERTY));
    }

    public void checkCost(UserContext _ctx, BigDecimal cost, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, cost);
    if((cost == null)){
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
    public void checkPlanType(UserContext _ctx, String planType, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, planType);
    if((planType == null)){
        return;
    }
    maxStringCheck(_ctx, _parentLocation, 100, planType);

    }
    public void checkProvider(UserContext _ctx, String provider, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, provider);
    if((provider == null)){
        return;
    }
    maxStringCheck(_ctx, _parentLocation, 100, provider);

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