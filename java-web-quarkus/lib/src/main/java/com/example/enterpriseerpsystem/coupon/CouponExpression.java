
package com.example.enterpriseerpsystem.coupon;

import com.example.enterpriseerpsystem.promotion.Promotion;
import com.example.enterpriseerpsystem.promotion.PromotionExpression;
import io.teaql.core.UserContext;
import io.teaql.core.value.BaseEntityExpression;
import io.teaql.core.value.Expression;
import io.teaql.core.value.ExpressionAdaptor;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.function.Function;

public class CouponExpression<T, E, U extends Coupon> extends ExpressionAdaptor<T, E, U> implements BaseEntityExpression<T, U> {
    public CouponExpression(Expression<T, U> expression){
        super(expression);
    }

    public CouponExpression(Expression<T, E> expression, Function<E, U> function){
        super(expression, function);
    }

     public CouponExpression<T, U, U> updateId(Long id){
        return new CouponExpression(this, $it -> {((Coupon)$it).__internalSet("id", id); return this;});
     }

     public CouponExpression<T, U, U> save(UserContext userContext){
        return new CouponExpression(this, $it -> ((Coupon)$it).auditAs("Saved by Expression").save(userContext));
     }

     public CouponExpression<T, U, U> save(String intent, UserContext userContext){
        return new CouponExpression(this, $it -> ((Coupon)$it).auditAs(intent).save(userContext));
     }

     public boolean isNull() {
        return resolve() == null;
     }


    public Expression<T, String> getCode(){
       return apply(Coupon::getCode);
    }
    public CouponExpression<T, U, U> updateCode(String code){
       return new CouponExpression(this, $it ->  ((Coupon)$it).updateCode(code));
    }

    public PromotionExpression<T, U, Promotion> getPromotion(){
       return new PromotionExpression(this, $it ->  ((Coupon)$it).getPromotion());
    }

    public CouponExpression<T, U, U> updatePromotion(Promotion promotion){
       return new CouponExpression(this, $it ->  ((Coupon)$it).updatePromotion(promotion));
    }

    public Expression<T, BigDecimal> getTimesUsed(){
       return apply(Coupon::getTimesUsed);
    }
    public CouponExpression<T, U, U> updateTimesUsed(BigDecimal timesUsed){
       return new CouponExpression(this, $it ->  ((Coupon)$it).updateTimesUsed(timesUsed));
    }

    public Expression<T, BigDecimal> getUsageLimit(){
       return apply(Coupon::getUsageLimit);
    }
    public CouponExpression<T, U, U> updateUsageLimit(BigDecimal usageLimit){
       return new CouponExpression(this, $it ->  ((Coupon)$it).updateUsageLimit(usageLimit));
    }

    public Expression<T, LocalDateTime> getCreateTime(){
       return apply(Coupon::getCreateTime);
    }
    public CouponExpression<T, U, U> updateCreateTime(LocalDateTime createTime){
       return new CouponExpression(this, $it ->  ((Coupon)$it).updateCreateTime(createTime));
    }

    public Expression<T, LocalDateTime> getUpdateTime(){
       return apply(Coupon::getUpdateTime);
    }
    public CouponExpression<T, U, U> updateUpdateTime(LocalDateTime updateTime){
       return new CouponExpression(this, $it ->  ((Coupon)$it).updateUpdateTime(updateTime));
    }

}