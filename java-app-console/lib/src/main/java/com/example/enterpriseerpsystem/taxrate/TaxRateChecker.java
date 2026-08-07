
package com.example.enterpriseerpsystem.taxrate;

import io.teaql.core.UserContext;
import io.teaql.core.checker.Checker;
import io.teaql.core.checker.ObjectLocation;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TaxRateChecker implements Checker<TaxRate>{

    public String type(){
        return TaxRate.INTERNAL_TYPE;
    }

    public void checkAndFix(UserContext _ctx, TaxRate taxRate, ObjectLocation _parentLocation){
        if(needCheck(_ctx, taxRate)){
            markAsChecked(_ctx, taxRate);
            doCheck(_ctx, taxRate, _parentLocation);
        }
    }

    public void doCheck(UserContext _ctx, TaxRate taxRate, ObjectLocation _parentLocation){
      if((taxRate == null)){
         return;
      }
      if(taxRate.newItem()){
        if(taxRate.getCreateTime() == null){
           taxRate.updateCreateTime(java.time.LocalDateTime.now());
        }if(taxRate.getUpdateTime() == null){
           taxRate.updateUpdateTime(java.time.LocalDateTime.now());
        }
      }else if(taxRate.updateItem()){
        taxRate.updateUpdateTime(java.time.LocalDateTime.now());
      }
      checkIsActive(_ctx, taxRate.getProperty(TaxRate.IS_ACTIVE_PROPERTY), newLocation(_parentLocation, TaxRate.IS_ACTIVE_PROPERTY));
      checkRate(_ctx, taxRate.getProperty(TaxRate.RATE_PROPERTY), newLocation(_parentLocation, TaxRate.RATE_PROPERTY));
      checkRegion(_ctx, taxRate.getProperty(TaxRate.REGION_PROPERTY), newLocation(_parentLocation, TaxRate.REGION_PROPERTY));
      checkCreateTime(_ctx, taxRate.getProperty(TaxRate.CREATE_TIME_PROPERTY), newLocation(_parentLocation, TaxRate.CREATE_TIME_PROPERTY));
      checkUpdateTime(_ctx, taxRate.getProperty(TaxRate.UPDATE_TIME_PROPERTY), newLocation(_parentLocation, TaxRate.UPDATE_TIME_PROPERTY));
    }

    public void checkIsActive(UserContext _ctx, Boolean isActive, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, isActive);
    if((isActive == null)){
        return;
    }
    }
    public void checkRate(UserContext _ctx, BigDecimal rate, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, rate);
    if((rate == null)){
        return;
    }
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