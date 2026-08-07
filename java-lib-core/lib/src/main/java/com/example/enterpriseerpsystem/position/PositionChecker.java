
package com.example.enterpriseerpsystem.position;

import io.teaql.core.UserContext;
import io.teaql.core.checker.Checker;
import io.teaql.core.checker.ObjectLocation;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class PositionChecker implements Checker<Position>{

    public String type(){
        return Position.INTERNAL_TYPE;
    }

    public void checkAndFix(UserContext _ctx, Position position, ObjectLocation _parentLocation){
        if(needCheck(_ctx, position)){
            markAsChecked(_ctx, position);
            doCheck(_ctx, position, _parentLocation);
        }
    }

    public void doCheck(UserContext _ctx, Position position, ObjectLocation _parentLocation){
      if((position == null)){
         return;
      }
      if(position.newItem()){
        if(position.getCreateTime() == null){
           position.updateCreateTime(java.time.LocalDateTime.now());
        }if(position.getUpdateTime() == null){
           position.updateUpdateTime(java.time.LocalDateTime.now());
        }
      }else if(position.updateItem()){
        position.updateUpdateTime(java.time.LocalDateTime.now());
      }
      checkMaxSalary(_ctx, position.getProperty(Position.MAX_SALARY_PROPERTY), newLocation(_parentLocation, Position.MAX_SALARY_PROPERTY));
      checkMinSalary(_ctx, position.getProperty(Position.MIN_SALARY_PROPERTY), newLocation(_parentLocation, Position.MIN_SALARY_PROPERTY));
      checkTitle(_ctx, position.getProperty(Position.TITLE_PROPERTY), newLocation(_parentLocation, Position.TITLE_PROPERTY));
      checkCreateTime(_ctx, position.getProperty(Position.CREATE_TIME_PROPERTY), newLocation(_parentLocation, Position.CREATE_TIME_PROPERTY));
      checkUpdateTime(_ctx, position.getProperty(Position.UPDATE_TIME_PROPERTY), newLocation(_parentLocation, Position.UPDATE_TIME_PROPERTY));
    }

    public void checkMaxSalary(UserContext _ctx, BigDecimal maxSalary, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, maxSalary);
    if((maxSalary == null)){
        return;
    }
    }
    public void checkMinSalary(UserContext _ctx, BigDecimal minSalary, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, minSalary);
    if((minSalary == null)){
        return;
    }
    }
    public void checkTitle(UserContext _ctx, String title, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, title);
    if((title == null)){
        return;
    }
    maxStringCheck(_ctx, _parentLocation, 100, title);

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