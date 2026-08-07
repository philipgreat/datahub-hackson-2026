
package com.example.enterpriseerpsystem.productreview;

import com.example.enterpriseerpsystem.customer.Customer;
import com.example.enterpriseerpsystem.product.Product;
import io.teaql.core.Audited;
import io.teaql.core.BaseEntity;
import io.teaql.core.EntityStatus;
import io.teaql.core.FrameworkInternal;
import io.teaql.core.RemoteInput;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * [TEAQL AI WARNING]
 * TeaQL was explicitly designed to PREVENT AI hallucinations and random guessing.
 * DO NOT GUESS METHOD NAMES!
 * The methods listed below are the ONLY valid ways to interact with this entity.
 * If you encounter compilation errors (e.g., method not found), DO NOT guess another method name.
 * Read the method signatures in this file before proceeding.
 */
public class ProductReview extends BaseEntity implements RemoteInput {
    public static String INTERNAL_TYPE = "ProductReview";

    public static final String CREATED_AT_PROPERTY = "createdAt";
    public static final String CUSTOMER_PROPERTY = "customer";
    public static final String PRODUCT_PROPERTY = "product";
    public static final String RATING_PROPERTY = "rating";
    public static final String REVIEW_TEXT_PROPERTY = "reviewText";
    public static final String CREATE_TIME_PROPERTY = "createTime";
    public static final String UPDATE_TIME_PROPERTY = "updateTime";
    private LocalDateTime createdAt;
    private Customer customer;
    private Product product;
    private BigDecimal rating;
    private String reviewText;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

    public LocalDateTime getCreatedAt(){
        return this.createdAt;
    }
    public Customer getCustomer(){
        return this.customer;
    }
    public Product getProduct(){
        return this.product;
    }
    public BigDecimal getRating(){
        return this.rating;
    }
    public String getReviewText(){
        return this.reviewText;
    }
    public LocalDateTime getCreateTime(){
        return this.createTime;
    }
    public LocalDateTime getUpdateTime(){
        return this.updateTime;
    }
    public ProductReview updateCreatedAt(LocalDateTime createdAt){
        if(Objects.equals(this.createdAt, createdAt)){
            return this;
        }
        handleUpdate(CREATED_AT_PROPERTY, getCreatedAt(), createdAt);
        this.createdAt = createdAt;
        return this;
    }
    public ProductReview updateCustomer(Customer customer){
        if(Objects.equals(this.customer, customer)){
            return this;
        }
        handleUpdate(CUSTOMER_PROPERTY, getCustomer(), customer);
        this.customer = customer;
        return this;
    }
    public ProductReview updateProduct(Product product){
        if(Objects.equals(this.product, product)){
            return this;
        }
        handleUpdate(PRODUCT_PROPERTY, getProduct(), product);
        this.product = product;
        return this;
    }
    public ProductReview updateRating(BigDecimal rating){
        if(Objects.equals(this.rating, rating)){
            return this;
        }
        handleUpdate(RATING_PROPERTY, getRating(), rating);
        this.rating = rating;
        return this;
    }
    public ProductReview updateReviewText(String reviewText){
        reviewText = (reviewText == null ? null : reviewText.trim());
        if(Objects.equals(this.reviewText, reviewText)){
            return this;
        }
        handleUpdate(REVIEW_TEXT_PROPERTY, getReviewText(), reviewText);
        this.reviewText = reviewText;
        return this;
    }
    public ProductReview updateCreateTime(LocalDateTime createTime){
        if(Objects.equals(this.createTime, createTime)){
            return this;
        }
        handleUpdate(CREATE_TIME_PROPERTY, getCreateTime(), createTime);
        this.createTime = createTime;
        return this;
    }
    public ProductReview updateUpdateTime(LocalDateTime updateTime){
        if(Objects.equals(this.updateTime, updateTime)){
            return this;
        }
        handleUpdate(UPDATE_TIME_PROPERTY, getUpdateTime(), updateTime);
        this.updateTime = updateTime;
        return this;
    }

    public static ProductReview refer(Long id){
        ProductReview refer = new ProductReview();
        refer.__internalSet("id", id);
        refer.set$status(EntityStatus.REFER);
        return refer;
    }
    @Override
    public String typeName(){
        return INTERNAL_TYPE;
    }

    public ProductReview comment(String comment){
        this.setComment(comment);
        return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Audited<ProductReview> auditAs(String action) {
        return super.auditAs(action);
    }

    // ===== Framework Internal: generated switch dispatch =====
    @Override
    @FrameworkInternal
    public void __internalSet(String property, Object value) {
        switch (property) {
            case "createdAt": this.createdAt = (LocalDateTime) value; break;

            case "customer": this.customer = (Customer) value; break;

            case "product": this.product = (Product) value; break;

            case "rating": this.rating = (BigDecimal) value; break;

            case "reviewText": this.reviewText = (value == null ? null : ((String)value).trim()); break;

            case "createTime": this.createTime = (LocalDateTime) value; break;

            case "updateTime": this.updateTime = (LocalDateTime) value; break;

            default: super.__internalSet(property, value);
        }
    }

    @Override
    @FrameworkInternal
    public Object __internalGet(String property) {
        switch (property) {
            case "createdAt": return this.createdAt;
            case "customer": return this.customer;
            case "product": return this.product;
            case "rating": return this.rating;
            case "reviewText": return this.reviewText;
            case "createTime": return this.createTime;
            case "updateTime": return this.updateTime;
            default: return super.__internalGet(property);
        }
    }

}