
package com.example.enterpriseerpsystem.opportunity;

import com.example.enterpriseerpsystem.lead.Lead;
import com.example.enterpriseerpsystem.lead.LeadChecker;
import com.example.enterpriseerpsystem.quote.Quote;
import com.example.enterpriseerpsystem.quote.QuoteChecker;
import io.teaql.core.UserContext;
import io.teaql.core.checker.Checker;
import io.teaql.core.checker.ObjectLocation;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class OpportunityChecker implements Checker<Opportunity>{

    public String type(){
        return Opportunity.INTERNAL_TYPE;
    }

    public void checkAndFix(UserContext _ctx, Opportunity opportunity, ObjectLocation _parentLocation){
        if(needCheck(_ctx, opportunity)){
            markAsChecked(_ctx, opportunity);
            doCheck(_ctx, opportunity, _parentLocation);
        }
    }

    public void doCheck(UserContext _ctx, Opportunity opportunity, ObjectLocation _parentLocation){
      if((opportunity == null)){
         return;
      }
      if(opportunity.newItem()){
        if(opportunity.getCloseDate() == null){
           opportunity.updateCloseDate(java.time.LocalDateTime.now());
        }if(opportunity.getCreateTime() == null){
           opportunity.updateCreateTime(java.time.LocalDateTime.now());
        }if(opportunity.getUpdateTime() == null){
           opportunity.updateUpdateTime(java.time.LocalDateTime.now());
        }
      }else if(opportunity.updateItem()){
        opportunity.updateUpdateTime(java.time.LocalDateTime.now());
      }
      checkCloseDate(_ctx, opportunity.getProperty(Opportunity.CLOSE_DATE_PROPERTY), newLocation(_parentLocation, Opportunity.CLOSE_DATE_PROPERTY));
      checkExpectedRevenue(_ctx, opportunity.getProperty(Opportunity.EXPECTED_REVENUE_PROPERTY), newLocation(_parentLocation, Opportunity.EXPECTED_REVENUE_PROPERTY));
      checkLead(_ctx, opportunity.getProperty(Opportunity.LEAD_PROPERTY), newLocation(_parentLocation, Opportunity.LEAD_PROPERTY));
      checkProbability(_ctx, opportunity.getProperty(Opportunity.PROBABILITY_PROPERTY), newLocation(_parentLocation, Opportunity.PROBABILITY_PROPERTY));
      checkStatus(_ctx, opportunity.getProperty(Opportunity.STATUS_PROPERTY), newLocation(_parentLocation, Opportunity.STATUS_PROPERTY));
      checkCreateTime(_ctx, opportunity.getProperty(Opportunity.CREATE_TIME_PROPERTY), newLocation(_parentLocation, Opportunity.CREATE_TIME_PROPERTY));
      checkUpdateTime(_ctx, opportunity.getProperty(Opportunity.UPDATE_TIME_PROPERTY), newLocation(_parentLocation, Opportunity.UPDATE_TIME_PROPERTY));
      for(int i = 0; opportunity.getQuoteList() != null && i < opportunity.getQuoteList().size(); i++){
         Quote quote = opportunity.getQuoteList().get(i);
         new QuoteChecker().checkAndFix(_ctx, quote, newLocation(_parentLocation, Opportunity.QUOTE_LIST_PROPERTY, i));
      }
    }

    public void checkCloseDate(UserContext _ctx, LocalDateTime closeDate, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, closeDate);
    if((closeDate == null)){
        return;
    }
    }
    public void checkExpectedRevenue(UserContext _ctx, BigDecimal expectedRevenue, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, expectedRevenue);
    if((expectedRevenue == null)){
        return;
    }
    }
    public void checkLead(UserContext _ctx, Lead lead, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, lead);
    if((lead == null)){
        return;
    }
    new LeadChecker().checkAndFix(_ctx, lead, _parentLocation);
    }
    public void checkProbability(UserContext _ctx, BigDecimal probability, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, probability);
    if((probability == null)){
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