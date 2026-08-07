
package com.example.enterpriseerpsystem.productreview;

import com.example.enterpriseerpsystem.customer.Customer;
import com.example.enterpriseerpsystem.customer.CustomerExpression;
import com.example.enterpriseerpsystem.product.Product;
import com.example.enterpriseerpsystem.product.ProductExpression;
import io.teaql.core.UserContext;
import io.teaql.core.value.BaseEntityExpression;
import io.teaql.core.value.Expression;
import io.teaql.core.value.ExpressionAdaptor;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.function.Function;

public class ProductReviewExpression<T, E, U extends ProductReview> extends ExpressionAdaptor<T, E, U> implements BaseEntityExpression<T, U> {
    public ProductReviewExpression(Expression<T, U> expression){
        super(expression);
    }

    public ProductReviewExpression(Expression<T, E> expression, Function<E, U> function){
        super(expression, function);
    }

     public ProductReviewExpression<T, U, U> updateId(Long id){
        return new ProductReviewExpression(this, $it -> {((ProductReview)$it).__internalSet("id", id); return this;});
     }

     public ProductReviewExpression<T, U, U> save(UserContext userContext){
        return new ProductReviewExpression(this, $it -> ((ProductReview)$it).auditAs("Saved by Expression").save(userContext));
     }

     public ProductReviewExpression<T, U, U> save(String intent, UserContext userContext){
        return new ProductReviewExpression(this, $it -> ((ProductReview)$it).auditAs(intent).save(userContext));
     }

     public boolean isNull() {
        return resolve() == null;
     }


    public Expression<T, LocalDateTime> getCreatedAt(){
       return apply(ProductReview::getCreatedAt);
    }
    public ProductReviewExpression<T, U, U> updateCreatedAt(LocalDateTime createdAt){
       return new ProductReviewExpression(this, $it ->  ((ProductReview)$it).updateCreatedAt(createdAt));
    }

    public CustomerExpression<T, U, Customer> getCustomer(){
       return new CustomerExpression(this, $it ->  ((ProductReview)$it).getCustomer());
    }

    public ProductReviewExpression<T, U, U> updateCustomer(Customer customer){
       return new ProductReviewExpression(this, $it ->  ((ProductReview)$it).updateCustomer(customer));
    }

    public ProductExpression<T, U, Product> getProduct(){
       return new ProductExpression(this, $it ->  ((ProductReview)$it).getProduct());
    }

    public ProductReviewExpression<T, U, U> updateProduct(Product product){
       return new ProductReviewExpression(this, $it ->  ((ProductReview)$it).updateProduct(product));
    }

    public Expression<T, BigDecimal> getRating(){
       return apply(ProductReview::getRating);
    }
    public ProductReviewExpression<T, U, U> updateRating(BigDecimal rating){
       return new ProductReviewExpression(this, $it ->  ((ProductReview)$it).updateRating(rating));
    }

    public Expression<T, String> getReviewText(){
       return apply(ProductReview::getReviewText);
    }
    public ProductReviewExpression<T, U, U> updateReviewText(String reviewText){
       return new ProductReviewExpression(this, $it ->  ((ProductReview)$it).updateReviewText(reviewText));
    }

    public Expression<T, LocalDateTime> getCreateTime(){
       return apply(ProductReview::getCreateTime);
    }
    public ProductReviewExpression<T, U, U> updateCreateTime(LocalDateTime createTime){
       return new ProductReviewExpression(this, $it ->  ((ProductReview)$it).updateCreateTime(createTime));
    }

    public Expression<T, LocalDateTime> getUpdateTime(){
       return apply(ProductReview::getUpdateTime);
    }
    public ProductReviewExpression<T, U, U> updateUpdateTime(LocalDateTime updateTime){
       return new ProductReviewExpression(this, $it ->  ((ProductReview)$it).updateUpdateTime(updateTime));
    }

}