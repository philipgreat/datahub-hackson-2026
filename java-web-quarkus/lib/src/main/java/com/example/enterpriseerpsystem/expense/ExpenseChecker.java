
package com.example.enterpriseerpsystem.expense;

import com.example.enterpriseerpsystem.employee.Employee;
import com.example.enterpriseerpsystem.employee.EmployeeChecker;
import io.teaql.core.UserContext;
import io.teaql.core.checker.Checker;
import io.teaql.core.checker.ObjectLocation;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ExpenseChecker implements Checker<Expense>{

    public String type(){
        return Expense.INTERNAL_TYPE;
    }

    public void checkAndFix(UserContext _ctx, Expense expense, ObjectLocation _parentLocation){
        if(needCheck(_ctx, expense)){
            markAsChecked(_ctx, expense);
            doCheck(_ctx, expense, _parentLocation);
        }
    }

    public void doCheck(UserContext _ctx, Expense expense, ObjectLocation _parentLocation){
      if((expense == null)){
         return;
      }
      if(expense.newItem()){
        if(expense.getDateIncurred() == null){
           expense.updateDateIncurred(java.time.LocalDateTime.now());
        }if(expense.getCreateTime() == null){
           expense.updateCreateTime(java.time.LocalDateTime.now());
        }if(expense.getUpdateTime() == null){
           expense.updateUpdateTime(java.time.LocalDateTime.now());
        }
      }else if(expense.updateItem()){
        expense.updateUpdateTime(java.time.LocalDateTime.now());
      }
      checkAmount(_ctx, expense.getProperty(Expense.AMOUNT_PROPERTY), newLocation(_parentLocation, Expense.AMOUNT_PROPERTY));
      checkCategory(_ctx, expense.getProperty(Expense.CATEGORY_PROPERTY), newLocation(_parentLocation, Expense.CATEGORY_PROPERTY));
      checkDateIncurred(_ctx, expense.getProperty(Expense.DATE_INCURRED_PROPERTY), newLocation(_parentLocation, Expense.DATE_INCURRED_PROPERTY));
      checkEmployee(_ctx, expense.getProperty(Expense.EMPLOYEE_PROPERTY), newLocation(_parentLocation, Expense.EMPLOYEE_PROPERTY));
      checkStatus(_ctx, expense.getProperty(Expense.STATUS_PROPERTY), newLocation(_parentLocation, Expense.STATUS_PROPERTY));
      checkCreateTime(_ctx, expense.getProperty(Expense.CREATE_TIME_PROPERTY), newLocation(_parentLocation, Expense.CREATE_TIME_PROPERTY));
      checkUpdateTime(_ctx, expense.getProperty(Expense.UPDATE_TIME_PROPERTY), newLocation(_parentLocation, Expense.UPDATE_TIME_PROPERTY));
    }

    public void checkAmount(UserContext _ctx, BigDecimal amount, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, amount);
    if((amount == null)){
        return;
    }
    }
    public void checkCategory(UserContext _ctx, String category, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, category);
    if((category == null)){
        return;
    }
    maxStringCheck(_ctx, _parentLocation, 100, category);

    }
    public void checkDateIncurred(UserContext _ctx, LocalDateTime dateIncurred, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, dateIncurred);
    if((dateIncurred == null)){
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