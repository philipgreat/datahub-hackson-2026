
package com.example.enterpriseerpsystem.salesterritory;

import io.teaql.core.UserContext;
import io.teaql.core.checker.Checker;
import io.teaql.core.checker.ObjectLocation;
import java.time.LocalDateTime;

public class SalesTerritoryChecker implements Checker<SalesTerritory>{

    public String type(){
        return SalesTerritory.INTERNAL_TYPE;
    }

    public void checkAndFix(UserContext _ctx, SalesTerritory salesTerritory, ObjectLocation _parentLocation){
        if(needCheck(_ctx, salesTerritory)){
            markAsChecked(_ctx, salesTerritory);
            doCheck(_ctx, salesTerritory, _parentLocation);
        }
    }

    public void doCheck(UserContext _ctx, SalesTerritory salesTerritory, ObjectLocation _parentLocation){
      if((salesTerritory == null)){
         return;
      }
      if(salesTerritory.newItem()){
        if(salesTerritory.getCreateTime() == null){
           salesTerritory.updateCreateTime(java.time.LocalDateTime.now());
        }if(salesTerritory.getUpdateTime() == null){
           salesTerritory.updateUpdateTime(java.time.LocalDateTime.now());
        }
      }else if(salesTerritory.updateItem()){
        salesTerritory.updateUpdateTime(java.time.LocalDateTime.now());
      }
      checkName(_ctx, salesTerritory.getProperty(SalesTerritory.NAME_PROPERTY), newLocation(_parentLocation, SalesTerritory.NAME_PROPERTY));
      checkManagerId(_ctx, salesTerritory.getProperty(SalesTerritory.MANAGER_ID_PROPERTY), newLocation(_parentLocation, SalesTerritory.MANAGER_ID_PROPERTY));
      checkRegion(_ctx, salesTerritory.getProperty(SalesTerritory.REGION_PROPERTY), newLocation(_parentLocation, SalesTerritory.REGION_PROPERTY));
      checkCreateTime(_ctx, salesTerritory.getProperty(SalesTerritory.CREATE_TIME_PROPERTY), newLocation(_parentLocation, SalesTerritory.CREATE_TIME_PROPERTY));
      checkUpdateTime(_ctx, salesTerritory.getProperty(SalesTerritory.UPDATE_TIME_PROPERTY), newLocation(_parentLocation, SalesTerritory.UPDATE_TIME_PROPERTY));
    }

    public void checkName(UserContext _ctx, String name, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, name);
    if((name == null)){
        return;
    }
    maxStringCheck(_ctx, _parentLocation, 100, name);

    }
    public void checkManagerId(UserContext _ctx, String managerId, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, managerId);
    if((managerId == null)){
        return;
    }
    maxStringCheck(_ctx, _parentLocation, 100, managerId);

    }
    public void checkRegion(UserContext _ctx, String region, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, region);
    if((region == null)){
        return;
    }
    maxStringCheck(_ctx, _parentLocation, 100, region);

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