
package com.example.enterpriseerpsystem.productreview;

import com.example.enterpriseerpsystem.customer.Customer;
import com.example.enterpriseerpsystem.customer.CustomerChecker;
import com.example.enterpriseerpsystem.product.Product;
import com.example.enterpriseerpsystem.product.ProductChecker;
import io.teaql.core.UserContext;
import io.teaql.core.checker.Checker;
import io.teaql.core.checker.ObjectLocation;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ProductReviewChecker implements Checker<ProductReview>{

    public String type(){
        return ProductReview.INTERNAL_TYPE;
    }

    public void checkAndFix(UserContext _ctx, ProductReview productReview, ObjectLocation _parentLocation){
        if(needCheck(_ctx, productReview)){
            markAsChecked(_ctx, productReview);
            doCheck(_ctx, productReview, _parentLocation);
        }
    }

    public void doCheck(UserContext _ctx, ProductReview productReview, ObjectLocation _parentLocation){
      if((productReview == null)){
         return;
      }
      if(productReview.newItem()){
        if(productReview.getCreatedAt() == null){
           productReview.updateCreatedAt(java.time.LocalDateTime.now());
        }if(productReview.getCreateTime() == null){
           productReview.updateCreateTime(java.time.LocalDateTime.now());
        }if(productReview.getUpdateTime() == null){
           productReview.updateUpdateTime(java.time.LocalDateTime.now());
        }
      }else if(productReview.updateItem()){
        productReview.updateUpdateTime(java.time.LocalDateTime.now());
      }
      checkCreatedAt(_ctx, productReview.getProperty(ProductReview.CREATED_AT_PROPERTY), newLocation(_parentLocation, ProductReview.CREATED_AT_PROPERTY));
      checkCustomer(_ctx, productReview.getProperty(ProductReview.CUSTOMER_PROPERTY), newLocation(_parentLocation, ProductReview.CUSTOMER_PROPERTY));
      checkProduct(_ctx, productReview.getProperty(ProductReview.PRODUCT_PROPERTY), newLocation(_parentLocation, ProductReview.PRODUCT_PROPERTY));
      checkRating(_ctx, productReview.getProperty(ProductReview.RATING_PROPERTY), newLocation(_parentLocation, ProductReview.RATING_PROPERTY));
      checkReviewText(_ctx, productReview.getProperty(ProductReview.REVIEW_TEXT_PROPERTY), newLocation(_parentLocation, ProductReview.REVIEW_TEXT_PROPERTY));
      checkCreateTime(_ctx, productReview.getProperty(ProductReview.CREATE_TIME_PROPERTY), newLocation(_parentLocation, ProductReview.CREATE_TIME_PROPERTY));
      checkUpdateTime(_ctx, productReview.getProperty(ProductReview.UPDATE_TIME_PROPERTY), newLocation(_parentLocation, ProductReview.UPDATE_TIME_PROPERTY));
    }

    public void checkCreatedAt(UserContext _ctx, LocalDateTime createdAt, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, createdAt);
    if((createdAt == null)){
        return;
    }
    }
    public void checkCustomer(UserContext _ctx, Customer customer, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, customer);
    if((customer == null)){
        return;
    }
    new CustomerChecker().checkAndFix(_ctx, customer, _parentLocation);
    }
    public void checkProduct(UserContext _ctx, Product product, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, product);
    if((product == null)){
        return;
    }
    new ProductChecker().checkAndFix(_ctx, product, _parentLocation);
    }
    public void checkRating(UserContext _ctx, BigDecimal rating, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, rating);
    if((rating == null)){
        return;
    }
    }
    public void checkReviewText(UserContext _ctx, String reviewText, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, reviewText);
    if((reviewText == null)){
        return;
    }
    maxStringCheck(_ctx, _parentLocation, 100, reviewText);

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