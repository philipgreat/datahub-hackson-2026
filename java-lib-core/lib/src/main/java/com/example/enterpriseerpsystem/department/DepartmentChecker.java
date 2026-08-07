
package com.example.enterpriseerpsystem.department;

import com.example.enterpriseerpsystem.employee.Employee;
import com.example.enterpriseerpsystem.employee.EmployeeChecker;
import io.teaql.core.UserContext;
import io.teaql.core.checker.Checker;
import io.teaql.core.checker.ObjectLocation;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class DepartmentChecker implements Checker<Department>{

    public String type(){
        return Department.INTERNAL_TYPE;
    }

    public void checkAndFix(UserContext _ctx, Department department, ObjectLocation _parentLocation){
        if(needCheck(_ctx, department)){
            markAsChecked(_ctx, department);
            doCheck(_ctx, department, _parentLocation);
        }
    }

    public void doCheck(UserContext _ctx, Department department, ObjectLocation _parentLocation){
      if((department == null)){
         return;
      }
      if(department.newItem()){
        if(department.getCreateTime() == null){
           department.updateCreateTime(java.time.LocalDateTime.now());
        }if(department.getUpdateTime() == null){
           department.updateUpdateTime(java.time.LocalDateTime.now());
        }
      }else if(department.updateItem()){
        department.updateUpdateTime(java.time.LocalDateTime.now());
      }
      checkName(_ctx, department.getProperty(Department.NAME_PROPERTY), newLocation(_parentLocation, Department.NAME_PROPERTY));
      checkBudget(_ctx, department.getProperty(Department.BUDGET_PROPERTY), newLocation(_parentLocation, Department.BUDGET_PROPERTY));
      checkLocation(_ctx, department.getProperty(Department.LOCATION_PROPERTY), newLocation(_parentLocation, Department.LOCATION_PROPERTY));
      checkManagerId(_ctx, department.getProperty(Department.MANAGER_ID_PROPERTY), newLocation(_parentLocation, Department.MANAGER_ID_PROPERTY));
      checkCreateTime(_ctx, department.getProperty(Department.CREATE_TIME_PROPERTY), newLocation(_parentLocation, Department.CREATE_TIME_PROPERTY));
      checkUpdateTime(_ctx, department.getProperty(Department.UPDATE_TIME_PROPERTY), newLocation(_parentLocation, Department.UPDATE_TIME_PROPERTY));
      for(int i = 0; department.getEmployeeList() != null && i < department.getEmployeeList().size(); i++){
         Employee employee = department.getEmployeeList().get(i);
         new EmployeeChecker().checkAndFix(_ctx, employee, newLocation(_parentLocation, Department.EMPLOYEE_LIST_PROPERTY, i));
      }
    }

    public void checkName(UserContext _ctx, String name, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, name);
    if((name == null)){
        return;
    }
    maxStringCheck(_ctx, _parentLocation, 100, name);

    }
    public void checkBudget(UserContext _ctx, BigDecimal budget, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, budget);
    if((budget == null)){
        return;
    }
    }
    public void checkLocation(UserContext _ctx, String location, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, location);
    if((location == null)){
        return;
    }
    maxStringCheck(_ctx, _parentLocation, 100, location);

    }
    public void checkManagerId(UserContext _ctx, String managerId, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, managerId);
    if((managerId == null)){
        return;
    }
    maxStringCheck(_ctx, _parentLocation, 100, managerId);

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