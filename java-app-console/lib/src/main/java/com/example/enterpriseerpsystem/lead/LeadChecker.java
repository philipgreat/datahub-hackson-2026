
package com.example.enterpriseerpsystem.lead;

import com.example.enterpriseerpsystem.opportunity.Opportunity;
import com.example.enterpriseerpsystem.opportunity.OpportunityChecker;
import io.teaql.core.UserContext;
import io.teaql.core.checker.Checker;
import io.teaql.core.checker.ObjectLocation;
import java.time.LocalDateTime;

public class LeadChecker implements Checker<Lead>{

    public String type(){
        return Lead.INTERNAL_TYPE;
    }

    public void checkAndFix(UserContext _ctx, Lead lead, ObjectLocation _parentLocation){
        if(needCheck(_ctx, lead)){
            markAsChecked(_ctx, lead);
            doCheck(_ctx, lead, _parentLocation);
        }
    }

    public void doCheck(UserContext _ctx, Lead lead, ObjectLocation _parentLocation){
      if((lead == null)){
         return;
      }
      if(lead.newItem()){
        if(lead.getCreateTime() == null){
           lead.updateCreateTime(java.time.LocalDateTime.now());
        }if(lead.getUpdateTime() == null){
           lead.updateUpdateTime(java.time.LocalDateTime.now());
        }
      }else if(lead.updateItem()){
        lead.updateUpdateTime(java.time.LocalDateTime.now());
      }
      checkEmail(_ctx, lead.getProperty(Lead.EMAIL_PROPERTY), newLocation(_parentLocation, Lead.EMAIL_PROPERTY));
      checkName(_ctx, lead.getProperty(Lead.NAME_PROPERTY), newLocation(_parentLocation, Lead.NAME_PROPERTY));
      checkPhone(_ctx, lead.getProperty(Lead.PHONE_PROPERTY), newLocation(_parentLocation, Lead.PHONE_PROPERTY));
      checkConvertedCustomerId(_ctx, lead.getProperty(Lead.CONVERTED_CUSTOMER_ID_PROPERTY), newLocation(_parentLocation, Lead.CONVERTED_CUSTOMER_ID_PROPERTY));
      checkSource(_ctx, lead.getProperty(Lead.SOURCE_PROPERTY), newLocation(_parentLocation, Lead.SOURCE_PROPERTY));
      checkStatus(_ctx, lead.getProperty(Lead.STATUS_PROPERTY), newLocation(_parentLocation, Lead.STATUS_PROPERTY));
      checkCreateTime(_ctx, lead.getProperty(Lead.CREATE_TIME_PROPERTY), newLocation(_parentLocation, Lead.CREATE_TIME_PROPERTY));
      checkUpdateTime(_ctx, lead.getProperty(Lead.UPDATE_TIME_PROPERTY), newLocation(_parentLocation, Lead.UPDATE_TIME_PROPERTY));
      for(int i = 0; lead.getOpportunityList() != null && i < lead.getOpportunityList().size(); i++){
         Opportunity opportunity = lead.getOpportunityList().get(i);
         new OpportunityChecker().checkAndFix(_ctx, opportunity, newLocation(_parentLocation, Lead.OPPORTUNITY_LIST_PROPERTY, i));
      }
    }

    public void checkEmail(UserContext _ctx, String email, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, email);
    if((email == null)){
        return;
    }
    maxStringCheck(_ctx, _parentLocation, 100, email);

    }
    public void checkName(UserContext _ctx, String name, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, name);
    if((name == null)){
        return;
    }
    maxStringCheck(_ctx, _parentLocation, 100, name);

    }
    public void checkPhone(UserContext _ctx, String phone, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, phone);
    if((phone == null)){
        return;
    }
    maxStringCheck(_ctx, _parentLocation, 100, phone);

    }
    public void checkConvertedCustomerId(UserContext _ctx, String convertedCustomerId, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, convertedCustomerId);
    if((convertedCustomerId == null)){
        return;
    }
    maxStringCheck(_ctx, _parentLocation, 100, convertedCustomerId);

    }
    public void checkSource(UserContext _ctx, String source, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, source);
    if((source == null)){
        return;
    }
    maxStringCheck(_ctx, _parentLocation, 100, source);

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