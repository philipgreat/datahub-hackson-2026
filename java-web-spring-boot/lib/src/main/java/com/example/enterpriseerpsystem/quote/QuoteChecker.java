
package com.example.enterpriseerpsystem.quote;

import com.example.enterpriseerpsystem.opportunity.Opportunity;
import com.example.enterpriseerpsystem.opportunity.OpportunityChecker;
import io.teaql.core.UserContext;
import io.teaql.core.checker.Checker;
import io.teaql.core.checker.ObjectLocation;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class QuoteChecker implements Checker<Quote>{

    public String type(){
        return Quote.INTERNAL_TYPE;
    }

    public void checkAndFix(UserContext _ctx, Quote quote, ObjectLocation _parentLocation){
        if(needCheck(_ctx, quote)){
            markAsChecked(_ctx, quote);
            doCheck(_ctx, quote, _parentLocation);
        }
    }

    public void doCheck(UserContext _ctx, Quote quote, ObjectLocation _parentLocation){
      if((quote == null)){
         return;
      }
      if(quote.newItem()){
        if(quote.getValidUntil() == null){
           quote.updateValidUntil(java.time.LocalDateTime.now());
        }if(quote.getCreateTime() == null){
           quote.updateCreateTime(java.time.LocalDateTime.now());
        }if(quote.getUpdateTime() == null){
           quote.updateUpdateTime(java.time.LocalDateTime.now());
        }
      }else if(quote.updateItem()){
        quote.updateUpdateTime(java.time.LocalDateTime.now());
      }
      checkTotalAmount(_ctx, quote.getProperty(Quote.TOTAL_AMOUNT_PROPERTY), newLocation(_parentLocation, Quote.TOTAL_AMOUNT_PROPERTY));
      checkOpportunity(_ctx, quote.getProperty(Quote.OPPORTUNITY_PROPERTY), newLocation(_parentLocation, Quote.OPPORTUNITY_PROPERTY));
      checkStatus(_ctx, quote.getProperty(Quote.STATUS_PROPERTY), newLocation(_parentLocation, Quote.STATUS_PROPERTY));
      checkValidUntil(_ctx, quote.getProperty(Quote.VALID_UNTIL_PROPERTY), newLocation(_parentLocation, Quote.VALID_UNTIL_PROPERTY));
      checkCreateTime(_ctx, quote.getProperty(Quote.CREATE_TIME_PROPERTY), newLocation(_parentLocation, Quote.CREATE_TIME_PROPERTY));
      checkUpdateTime(_ctx, quote.getProperty(Quote.UPDATE_TIME_PROPERTY), newLocation(_parentLocation, Quote.UPDATE_TIME_PROPERTY));
    }

    public void checkTotalAmount(UserContext _ctx, BigDecimal totalAmount, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, totalAmount);
    if((totalAmount == null)){
        return;
    }
    }
    public void checkOpportunity(UserContext _ctx, Opportunity opportunity, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, opportunity);
    if((opportunity == null)){
        return;
    }
    new OpportunityChecker().checkAndFix(_ctx, opportunity, _parentLocation);
    }
    public void checkStatus(UserContext _ctx, String status, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, status);
    if((status == null)){
        return;
    }
    maxStringCheck(_ctx, _parentLocation, 100, status);

    }
    public void checkValidUntil(UserContext _ctx, LocalDateTime validUntil, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, validUntil);
    if((validUntil == null)){
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