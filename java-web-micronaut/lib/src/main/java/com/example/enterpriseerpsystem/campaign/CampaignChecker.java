
package com.example.enterpriseerpsystem.campaign;

import io.teaql.core.UserContext;
import io.teaql.core.checker.Checker;
import io.teaql.core.checker.ObjectLocation;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class CampaignChecker implements Checker<Campaign>{

    public String type(){
        return Campaign.INTERNAL_TYPE;
    }

    public void checkAndFix(UserContext _ctx, Campaign campaign, ObjectLocation _parentLocation){
        if(needCheck(_ctx, campaign)){
            markAsChecked(_ctx, campaign);
            doCheck(_ctx, campaign, _parentLocation);
        }
    }

    public void doCheck(UserContext _ctx, Campaign campaign, ObjectLocation _parentLocation){
      if((campaign == null)){
         return;
      }
      if(campaign.newItem()){
        if(campaign.getEndDate() == null){
           campaign.updateEndDate(java.time.LocalDateTime.now());
        }if(campaign.getStartDate() == null){
           campaign.updateStartDate(java.time.LocalDateTime.now());
        }if(campaign.getCreateTime() == null){
           campaign.updateCreateTime(java.time.LocalDateTime.now());
        }if(campaign.getUpdateTime() == null){
           campaign.updateUpdateTime(java.time.LocalDateTime.now());
        }
      }else if(campaign.updateItem()){
        campaign.updateUpdateTime(java.time.LocalDateTime.now());
      }
      checkName(_ctx, campaign.getProperty(Campaign.NAME_PROPERTY), newLocation(_parentLocation, Campaign.NAME_PROPERTY));
      checkBudget(_ctx, campaign.getProperty(Campaign.BUDGET_PROPERTY), newLocation(_parentLocation, Campaign.BUDGET_PROPERTY));
      checkEndDate(_ctx, campaign.getProperty(Campaign.END_DATE_PROPERTY), newLocation(_parentLocation, Campaign.END_DATE_PROPERTY));
      checkStartDate(_ctx, campaign.getProperty(Campaign.START_DATE_PROPERTY), newLocation(_parentLocation, Campaign.START_DATE_PROPERTY));
      checkStatus(_ctx, campaign.getProperty(Campaign.STATUS_PROPERTY), newLocation(_parentLocation, Campaign.STATUS_PROPERTY));
      checkCreateTime(_ctx, campaign.getProperty(Campaign.CREATE_TIME_PROPERTY), newLocation(_parentLocation, Campaign.CREATE_TIME_PROPERTY));
      checkUpdateTime(_ctx, campaign.getProperty(Campaign.UPDATE_TIME_PROPERTY), newLocation(_parentLocation, Campaign.UPDATE_TIME_PROPERTY));
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
    public void checkEndDate(UserContext _ctx, LocalDateTime endDate, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, endDate);
    if((endDate == null)){
        return;
    }
    }
    public void checkStartDate(UserContext _ctx, LocalDateTime startDate, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, startDate);
    if((startDate == null)){
        return;
    }
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