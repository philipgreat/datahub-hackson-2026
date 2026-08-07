
package com.example.enterpriseerpsystem.promotion;

import com.example.enterpriseerpsystem.coupon.Coupon;
import com.example.enterpriseerpsystem.coupon.CouponListExpression;
import io.teaql.core.UserContext;
import io.teaql.core.value.BaseEntityExpression;
import io.teaql.core.value.Expression;
import io.teaql.core.value.ExpressionAdaptor;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.function.Function;

public class PromotionExpression<T, E, U extends Promotion> extends ExpressionAdaptor<T, E, U> implements BaseEntityExpression<T, U> {
    public PromotionExpression(Expression<T, U> expression){
        super(expression);
    }

    public PromotionExpression(Expression<T, E> expression, Function<E, U> function){
        super(expression, function);
    }

     public PromotionExpression<T, U, U> updateId(Long id){
        return new PromotionExpression(this, $it -> {((Promotion)$it).__internalSet("id", id); return this;});
     }

     public PromotionExpression<T, U, U> save(UserContext userContext){
        return new PromotionExpression(this, $it -> ((Promotion)$it).auditAs("Saved by Expression").save(userContext));
     }

     public PromotionExpression<T, U, U> save(String intent, UserContext userContext){
        return new PromotionExpression(this, $it -> ((Promotion)$it).auditAs(intent).save(userContext));
     }

     public boolean isNull() {
        return resolve() == null;
     }


    public Expression<T, String> getName(){
       return apply(Promotion::getName);
    }
    public PromotionExpression<T, U, U> updateName(String name){
       return new PromotionExpression(this, $it ->  ((Promotion)$it).updateName(name));
    }

    public Expression<T, BigDecimal> getDiscountPercentage(){
       return apply(Promotion::getDiscountPercentage);
    }
    public PromotionExpression<T, U, U> updateDiscountPercentage(BigDecimal discountPercentage){
       return new PromotionExpression(this, $it ->  ((Promotion)$it).updateDiscountPercentage(discountPercentage));
    }

    public Expression<T, LocalDateTime> getEndDate(){
       return apply(Promotion::getEndDate);
    }
    public PromotionExpression<T, U, U> updateEndDate(LocalDateTime endDate){
       return new PromotionExpression(this, $it ->  ((Promotion)$it).updateEndDate(endDate));
    }

    public Expression<T, LocalDateTime> getStartDate(){
       return apply(Promotion::getStartDate);
    }
    public PromotionExpression<T, U, U> updateStartDate(LocalDateTime startDate){
       return new PromotionExpression(this, $it ->  ((Promotion)$it).updateStartDate(startDate));
    }

    public Expression<T, LocalDateTime> getCreateTime(){
       return apply(Promotion::getCreateTime);
    }
    public PromotionExpression<T, U, U> updateCreateTime(LocalDateTime createTime){
       return new PromotionExpression(this, $it ->  ((Promotion)$it).updateCreateTime(createTime));
    }

    public Expression<T, LocalDateTime> getUpdateTime(){
       return apply(Promotion::getUpdateTime);
    }
    public PromotionExpression<T, U, U> updateUpdateTime(LocalDateTime updateTime){
       return new PromotionExpression(this, $it ->  ((Promotion)$it).updateUpdateTime(updateTime));
    }

    public CouponListExpression<T, U, Coupon> getCouponList(){
        return new CouponListExpression(this, $it ->  ((Promotion)$it).getCouponList());
    }
    public PromotionExpression<T, U, U> addCoupon(Coupon coupon){
       return new PromotionExpression(this, $it ->  ((Promotion)$it).addCoupon(coupon));
    }
}