
package com.example.enterpriseerpsystem.sla;

import io.teaql.core.UserContext;
import io.teaql.core.checker.Checker;
import io.teaql.core.checker.ObjectLocation;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class SlaChecker implements Checker<Sla>{

    public String type(){
        return Sla.INTERNAL_TYPE;
    }

    public void checkAndFix(UserContext _ctx, Sla sla, ObjectLocation _parentLocation){
        if(needCheck(_ctx, sla)){
            markAsChecked(_ctx, sla);
            doCheck(_ctx, sla, _parentLocation);
        }
    }

    public void doCheck(UserContext _ctx, Sla sla, ObjectLocation _parentLocation){
      if((sla == null)){
         return;
      }
      if(sla.newItem()){
        if(sla.getCreateTime() == null){
           sla.updateCreateTime(java.time.LocalDateTime.now());
        }if(sla.getUpdateTime() == null){
           sla.updateUpdateTime(java.time.LocalDateTime.now());
        }
      }else if(sla.updateItem()){
        sla.updateUpdateTime(java.time.LocalDateTime.now());
      }
      checkIsActive(_ctx, sla.getProperty(Sla.IS_ACTIVE_PROPERTY), newLocation(_parentLocation, Sla.IS_ACTIVE_PROPERTY));
      checkPriorityLevel(_ctx, sla.getProperty(Sla.PRIORITY_LEVEL_PROPERTY), newLocation(_parentLocation, Sla.PRIORITY_LEVEL_PROPERTY));
      checkResolutionHours(_ctx, sla.getProperty(Sla.RESOLUTION_HOURS_PROPERTY), newLocation(_parentLocation, Sla.RESOLUTION_HOURS_PROPERTY));
      checkCreateTime(_ctx, sla.getProperty(Sla.CREATE_TIME_PROPERTY), newLocation(_parentLocation, Sla.CREATE_TIME_PROPERTY));
      checkUpdateTime(_ctx, sla.getProperty(Sla.UPDATE_TIME_PROPERTY), newLocation(_parentLocation, Sla.UPDATE_TIME_PROPERTY));
    }

    public void checkIsActive(UserContext _ctx, Boolean isActive, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, isActive);
    if((isActive == null)){
        return;
    }
    }
    public void checkPriorityLevel(UserContext _ctx, String priorityLevel, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, priorityLevel);
    if((priorityLevel == null)){
        return;
    }
    maxStringCheck(_ctx, _parentLocation, 100, priorityLevel);

    }
    public void checkResolutionHours(UserContext _ctx, BigDecimal resolutionHours, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, resolutionHours);
    if((resolutionHours == null)){
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