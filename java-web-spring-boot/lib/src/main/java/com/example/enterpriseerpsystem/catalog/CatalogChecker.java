
package com.example.enterpriseerpsystem.catalog;

import io.teaql.core.UserContext;
import io.teaql.core.checker.Checker;
import io.teaql.core.checker.ObjectLocation;
import java.time.LocalDateTime;

public class CatalogChecker implements Checker<Catalog>{

    public String type(){
        return Catalog.INTERNAL_TYPE;
    }

    public void checkAndFix(UserContext _ctx, Catalog catalog, ObjectLocation _parentLocation){
        if(needCheck(_ctx, catalog)){
            markAsChecked(_ctx, catalog);
            doCheck(_ctx, catalog, _parentLocation);
        }
    }

    public void doCheck(UserContext _ctx, Catalog catalog, ObjectLocation _parentLocation){
      if((catalog == null)){
         return;
      }
      if(catalog.newItem()){
        if(catalog.getValidFrom() == null){
           catalog.updateValidFrom(java.time.LocalDateTime.now());
        }if(catalog.getValidTo() == null){
           catalog.updateValidTo(java.time.LocalDateTime.now());
        }if(catalog.getCreateTime() == null){
           catalog.updateCreateTime(java.time.LocalDateTime.now());
        }if(catalog.getUpdateTime() == null){
           catalog.updateUpdateTime(java.time.LocalDateTime.now());
        }
      }else if(catalog.updateItem()){
        catalog.updateUpdateTime(java.time.LocalDateTime.now());
      }
      checkName(_ctx, catalog.getProperty(Catalog.NAME_PROPERTY), newLocation(_parentLocation, Catalog.NAME_PROPERTY));
      checkSeason(_ctx, catalog.getProperty(Catalog.SEASON_PROPERTY), newLocation(_parentLocation, Catalog.SEASON_PROPERTY));
      checkValidFrom(_ctx, catalog.getProperty(Catalog.VALID_FROM_PROPERTY), newLocation(_parentLocation, Catalog.VALID_FROM_PROPERTY));
      checkValidTo(_ctx, catalog.getProperty(Catalog.VALID_TO_PROPERTY), newLocation(_parentLocation, Catalog.VALID_TO_PROPERTY));
      checkCreateTime(_ctx, catalog.getProperty(Catalog.CREATE_TIME_PROPERTY), newLocation(_parentLocation, Catalog.CREATE_TIME_PROPERTY));
      checkUpdateTime(_ctx, catalog.getProperty(Catalog.UPDATE_TIME_PROPERTY), newLocation(_parentLocation, Catalog.UPDATE_TIME_PROPERTY));
    }

    public void checkName(UserContext _ctx, String name, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, name);
    if((name == null)){
        return;
    }
    maxStringCheck(_ctx, _parentLocation, 100, name);

    }
    public void checkSeason(UserContext _ctx, String season, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, season);
    if((season == null)){
        return;
    }
    maxStringCheck(_ctx, _parentLocation, 100, season);

    }
    public void checkValidFrom(UserContext _ctx, LocalDateTime validFrom, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, validFrom);
    if((validFrom == null)){
        return;
    }
    }
    public void checkValidTo(UserContext _ctx, LocalDateTime validTo, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, validTo);
    if((validTo == null)){
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