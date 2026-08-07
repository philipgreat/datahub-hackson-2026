
package com.example.enterpriseerpsystem.coupon;

import com.example.enterpriseerpsystem.promotion.Promotion;
import com.example.enterpriseerpsystem.promotion.PromotionChecker;
import io.teaql.core.UserContext;
import io.teaql.core.checker.Checker;
import io.teaql.core.checker.ObjectLocation;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class CouponChecker implements Checker<Coupon>{

    public String type(){
        return Coupon.INTERNAL_TYPE;
    }

    public void checkAndFix(UserContext _ctx, Coupon coupon, ObjectLocation _parentLocation){
        if(needCheck(_ctx, coupon)){
            markAsChecked(_ctx, coupon);
            doCheck(_ctx, coupon, _parentLocation);
        }
    }

    public void doCheck(UserContext _ctx, Coupon coupon, ObjectLocation _parentLocation){
      if((coupon == null)){
         return;
      }
      if(coupon.newItem()){
        if(coupon.getCreateTime() == null){
           coupon.updateCreateTime(java.time.LocalDateTime.now());
        }if(coupon.getUpdateTime() == null){
           coupon.updateUpdateTime(java.time.LocalDateTime.now());
        }
      }else if(coupon.updateItem()){
        coupon.updateUpdateTime(java.time.LocalDateTime.now());
      }
      checkCode(_ctx, coupon.getProperty(Coupon.CODE_PROPERTY), newLocation(_parentLocation, Coupon.CODE_PROPERTY));
      checkPromotion(_ctx, coupon.getProperty(Coupon.PROMOTION_PROPERTY), newLocation(_parentLocation, Coupon.PROMOTION_PROPERTY));
      checkTimesUsed(_ctx, coupon.getProperty(Coupon.TIMES_USED_PROPERTY), newLocation(_parentLocation, Coupon.TIMES_USED_PROPERTY));
      checkUsageLimit(_ctx, coupon.getProperty(Coupon.USAGE_LIMIT_PROPERTY), newLocation(_parentLocation, Coupon.USAGE_LIMIT_PROPERTY));
      checkCreateTime(_ctx, coupon.getProperty(Coupon.CREATE_TIME_PROPERTY), newLocation(_parentLocation, Coupon.CREATE_TIME_PROPERTY));
      checkUpdateTime(_ctx, coupon.getProperty(Coupon.UPDATE_TIME_PROPERTY), newLocation(_parentLocation, Coupon.UPDATE_TIME_PROPERTY));
    }

    public void checkCode(UserContext _ctx, String code, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, code);
    if((code == null)){
        return;
    }
    maxStringCheck(_ctx, _parentLocation, 100, code);

    }
    public void checkPromotion(UserContext _ctx, Promotion promotion, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, promotion);
    if((promotion == null)){
        return;
    }
    new PromotionChecker().checkAndFix(_ctx, promotion, _parentLocation);
    }
    public void checkTimesUsed(UserContext _ctx, BigDecimal timesUsed, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, timesUsed);
    if((timesUsed == null)){
        return;
    }
    }
    public void checkUsageLimit(UserContext _ctx, BigDecimal usageLimit, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, usageLimit);
    if((usageLimit == null)){
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