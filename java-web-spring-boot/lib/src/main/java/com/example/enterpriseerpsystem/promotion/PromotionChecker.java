
package com.example.enterpriseerpsystem.promotion;

import com.example.enterpriseerpsystem.coupon.Coupon;
import com.example.enterpriseerpsystem.coupon.CouponChecker;
import io.teaql.core.UserContext;
import io.teaql.core.checker.Checker;
import io.teaql.core.checker.ObjectLocation;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class PromotionChecker implements Checker<Promotion>{

    public String type(){
        return Promotion.INTERNAL_TYPE;
    }

    public void checkAndFix(UserContext _ctx, Promotion promotion, ObjectLocation _parentLocation){
        if(needCheck(_ctx, promotion)){
            markAsChecked(_ctx, promotion);
            doCheck(_ctx, promotion, _parentLocation);
        }
    }

    public void doCheck(UserContext _ctx, Promotion promotion, ObjectLocation _parentLocation){
      if((promotion == null)){
         return;
      }
      if(promotion.newItem()){
        if(promotion.getEndDate() == null){
           promotion.updateEndDate(java.time.LocalDateTime.now());
        }if(promotion.getStartDate() == null){
           promotion.updateStartDate(java.time.LocalDateTime.now());
        }if(promotion.getCreateTime() == null){
           promotion.updateCreateTime(java.time.LocalDateTime.now());
        }if(promotion.getUpdateTime() == null){
           promotion.updateUpdateTime(java.time.LocalDateTime.now());
        }
      }else if(promotion.updateItem()){
        promotion.updateUpdateTime(java.time.LocalDateTime.now());
      }
      checkName(_ctx, promotion.getProperty(Promotion.NAME_PROPERTY), newLocation(_parentLocation, Promotion.NAME_PROPERTY));
      checkDiscountPercentage(_ctx, promotion.getProperty(Promotion.DISCOUNT_PERCENTAGE_PROPERTY), newLocation(_parentLocation, Promotion.DISCOUNT_PERCENTAGE_PROPERTY));
      checkEndDate(_ctx, promotion.getProperty(Promotion.END_DATE_PROPERTY), newLocation(_parentLocation, Promotion.END_DATE_PROPERTY));
      checkStartDate(_ctx, promotion.getProperty(Promotion.START_DATE_PROPERTY), newLocation(_parentLocation, Promotion.START_DATE_PROPERTY));
      checkCreateTime(_ctx, promotion.getProperty(Promotion.CREATE_TIME_PROPERTY), newLocation(_parentLocation, Promotion.CREATE_TIME_PROPERTY));
      checkUpdateTime(_ctx, promotion.getProperty(Promotion.UPDATE_TIME_PROPERTY), newLocation(_parentLocation, Promotion.UPDATE_TIME_PROPERTY));
      for(int i = 0; promotion.getCouponList() != null && i < promotion.getCouponList().size(); i++){
         Coupon coupon = promotion.getCouponList().get(i);
         new CouponChecker().checkAndFix(_ctx, coupon, newLocation(_parentLocation, Promotion.COUPON_LIST_PROPERTY, i));
      }
    }

    public void checkName(UserContext _ctx, String name, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, name);
    if((name == null)){
        return;
    }
    maxStringCheck(_ctx, _parentLocation, 100, name);

    }
    public void checkDiscountPercentage(UserContext _ctx, BigDecimal discountPercentage, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, discountPercentage);
    if((discountPercentage == null)){
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