
package com.example.enterpriseerpsystem.payroll;

import com.example.enterpriseerpsystem.employee.Employee;
import com.example.enterpriseerpsystem.employee.EmployeeChecker;
import io.teaql.core.UserContext;
import io.teaql.core.checker.Checker;
import io.teaql.core.checker.ObjectLocation;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class PayrollChecker implements Checker<Payroll>{

    public String type(){
        return Payroll.INTERNAL_TYPE;
    }

    public void checkAndFix(UserContext _ctx, Payroll payroll, ObjectLocation _parentLocation){
        if(needCheck(_ctx, payroll)){
            markAsChecked(_ctx, payroll);
            doCheck(_ctx, payroll, _parentLocation);
        }
    }

    public void doCheck(UserContext _ctx, Payroll payroll, ObjectLocation _parentLocation){
      if((payroll == null)){
         return;
      }
      if(payroll.newItem()){
        if(payroll.getPeriodEnd() == null){
           payroll.updatePeriodEnd(java.time.LocalDateTime.now());
        }if(payroll.getPeriodStart() == null){
           payroll.updatePeriodStart(java.time.LocalDateTime.now());
        }if(payroll.getCreateTime() == null){
           payroll.updateCreateTime(java.time.LocalDateTime.now());
        }if(payroll.getUpdateTime() == null){
           payroll.updateUpdateTime(java.time.LocalDateTime.now());
        }
      }else if(payroll.updateItem()){
        payroll.updateUpdateTime(java.time.LocalDateTime.now());
      }
      checkTax(_ctx, payroll.getProperty(Payroll.TAX_PROPERTY), newLocation(_parentLocation, Payroll.TAX_PROPERTY));
      checkEmployee(_ctx, payroll.getProperty(Payroll.EMPLOYEE_PROPERTY), newLocation(_parentLocation, Payroll.EMPLOYEE_PROPERTY));
      checkGrossPay(_ctx, payroll.getProperty(Payroll.GROSS_PAY_PROPERTY), newLocation(_parentLocation, Payroll.GROSS_PAY_PROPERTY));
      checkNetPay(_ctx, payroll.getProperty(Payroll.NET_PAY_PROPERTY), newLocation(_parentLocation, Payroll.NET_PAY_PROPERTY));
      checkPeriodEnd(_ctx, payroll.getProperty(Payroll.PERIOD_END_PROPERTY), newLocation(_parentLocation, Payroll.PERIOD_END_PROPERTY));
      checkPeriodStart(_ctx, payroll.getProperty(Payroll.PERIOD_START_PROPERTY), newLocation(_parentLocation, Payroll.PERIOD_START_PROPERTY));
      checkCreateTime(_ctx, payroll.getProperty(Payroll.CREATE_TIME_PROPERTY), newLocation(_parentLocation, Payroll.CREATE_TIME_PROPERTY));
      checkUpdateTime(_ctx, payroll.getProperty(Payroll.UPDATE_TIME_PROPERTY), newLocation(_parentLocation, Payroll.UPDATE_TIME_PROPERTY));
    }

    public void checkTax(UserContext _ctx, BigDecimal tax, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, tax);
    if((tax == null)){
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
    public void checkGrossPay(UserContext _ctx, BigDecimal grossPay, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, grossPay);
    if((grossPay == null)){
        return;
    }
    }
    public void checkNetPay(UserContext _ctx, BigDecimal netPay, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, netPay);
    if((netPay == null)){
        return;
    }
    }
    public void checkPeriodEnd(UserContext _ctx, LocalDateTime periodEnd, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, periodEnd);
    if((periodEnd == null)){
        return;
    }
    }
    public void checkPeriodStart(UserContext _ctx, LocalDateTime periodStart, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, periodStart);
    if((periodStart == null)){
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