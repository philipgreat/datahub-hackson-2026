
package com.example.enterpriseerpsystem.productreview;

import com.example.enterpriseerpsystem.Q;
import com.example.enterpriseerpsystem.customer.Customer;
import com.example.enterpriseerpsystem.customer.CustomerRequest;
import com.example.enterpriseerpsystem.product.Product;
import com.example.enterpriseerpsystem.product.ProductRequest;
import io.teaql.core.AggrFunction;
import io.teaql.core.BaseRequest;
import io.teaql.core.PropertyReference;
import io.teaql.core.SearchCriteria;
import io.teaql.core.SubQuerySearchCriteria;
import io.teaql.core.criteria.Operator;
import io.teaql.core.criteria.TwoOperatorCriteria;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

public class ProductReviewRequest<T extends ProductReview> extends BaseRequest<T> {

    /**
     * @deprecated AI agents and business code must use the generated Q facade
     *             instead of constructing request builders directly.
     */
    @Deprecated
    public ProductReviewRequest(Class<T> returnType){
        super(returnType);
        selectId();
        selectVersion();
    }

    public ProductReviewRequest<T> comment(String comment){
         super.internalComment(comment);
         return this;
    }

    // purpose() 继承自 BaseRequest，返回 ExecutableRequest（终结方法）

    public ProductReviewRequest<T> returnType(Class<? extends T> returnType){
        super.setReturnType(returnType);
        return this;
    }

    public ProductReviewRequest<T> enableAggregationCache(long cacheExpiredMillis){
        super.enableAggregationCache();
        super.aggregateCacheTime(cacheExpiredMillis);
        return this;
    }

    public ProductReviewRequest<T> enableAggregationCache(){
        return enableAggregationCache(0l);
    }


    public ProductReviewRequest<T> propagateAggregationCache(long cacheExpiredMillis){
        super.propagateAggregationCache(cacheExpiredMillis);
        return this;
    }

    public ProductReviewRequest<T> appendSearchCriteria(SearchCriteria searchCriteria){
        return (ProductReviewRequest<T>)super.appendSearchCriteria(searchCriteria);
    }

    public ProductReviewRequest<T> filter(String property1, Operator operator, String property2){
        return appendSearchCriteria(new TwoOperatorCriteria(operator, new PropertyReference(property1), new PropertyReference(property2)));
    }


    public ProductReviewRequest<T> matchingAnyOf(ProductReviewRequest productReview){
        super.internalMatchAny(productReview);
        return this;
    }

    public ProductReviewRequest<T> enhanceChildrenIfNeeded(){
        return this;
    }

    public ProductReviewRequest<T> withDeletedRows(){
        super.withDeletedRows();
        return this;
    }

    public ProductReviewRequest<T> deletedRowsOnly(){
        super.deletedRowsOnly();
        return this;
    }

    public ProductReviewRequest<T> selectSelf(){
        super.selectSelf();
        return selectId().selectCreatedAt().selectCustomerIdOnly().selectProductIdOnly().selectRating().selectReviewText().selectCreateTime().selectUpdateTime().selectVersion();
    }

    public ProductReviewRequest<T> selectSelfFields(){
        return selectSelf();
    }

    public ProductReviewRequest<T> selectAll(){
        super.selectAll();
        return selectId().selectCreatedAt().selectCustomer().selectProduct().selectRating().selectReviewText().selectCreateTime().selectUpdateTime().selectVersion();
    }

    public ProductReviewRequest<T> selectChildren(){
        super.selectAny();
        return selectId().selectCreatedAt().selectCustomer().selectProduct().selectRating().selectReviewText().selectCreateTime().selectUpdateTime().selectVersion();
    }


    public ProductReviewRequest<T> selectId(){
       selectProperty(ProductReview.ID_PROPERTY);
       return this;
    }

    /**
     * fill the id with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  id) to fetch id property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public ProductReviewRequest<T> unselectId(){
       unselectProperty(ProductReview.ID_PROPERTY);
       return this;
    }
    public ProductReviewRequest<T> selectCreatedAt(){
       selectProperty(ProductReview.CREATED_AT_PROPERTY);
       return this;
    }

    /**
     * fill the createdAt with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  createdAt) to fetch createdAt property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public ProductReviewRequest<T> unselectCreatedAt(){
       unselectProperty(ProductReview.CREATED_AT_PROPERTY);
       return this;
    }
    public ProductReviewRequest<T> selectCustomerIdOnly(){
       selectProperty(ProductReview.CUSTOMER_PROPERTY);
       return this;
    }

    public ProductReviewRequest<T> selectCustomer(){
        return selectCustomerWith(Q.customers().unlimited().selectSelf());
    }

    public ProductReviewRequest<T> selectCustomerWith(CustomerRequest customer){
       selectProperty(ProductReview.CUSTOMER_PROPERTY);
       enhanceRelation(ProductReview.CUSTOMER_PROPERTY, customer);
       return this;
    }

    public ProductReviewRequest<T> unselectCustomer(){
       unselectProperty(ProductReview.CUSTOMER_PROPERTY);
       return this;
    }
    public ProductReviewRequest<T> selectProductIdOnly(){
       selectProperty(ProductReview.PRODUCT_PROPERTY);
       return this;
    }

    public ProductReviewRequest<T> selectProduct(){
        return selectProductWith(Q.products().unlimited().selectSelf());
    }

    public ProductReviewRequest<T> selectProductWith(ProductRequest product){
       selectProperty(ProductReview.PRODUCT_PROPERTY);
       enhanceRelation(ProductReview.PRODUCT_PROPERTY, product);
       return this;
    }

    public ProductReviewRequest<T> unselectProduct(){
       unselectProperty(ProductReview.PRODUCT_PROPERTY);
       return this;
    }
    public ProductReviewRequest<T> selectRating(){
       selectProperty(ProductReview.RATING_PROPERTY);
       return this;
    }

    /**
     * fill the rating with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  rating) to fetch rating property.
     * @param rawSqlSegment  customized rawSqlSegment
     */


    /**
     * fill the rating with customized aggrFunction, TEAQL uses ({aggrFunction}(rating) AS rating to fetch rating property.
     * @param aggrFunction  aggrFunction
     */
    public ProductReviewRequest<T> selectRating(AggrFunction aggrFunction){
       selectProperty(ProductReview.RATING_PROPERTY, aggrFunction);
       return this;
    }


    public ProductReviewRequest<T> unselectRating(){
       unselectProperty(ProductReview.RATING_PROPERTY);
       return this;
    }
    public ProductReviewRequest<T> selectReviewText(){
       selectProperty(ProductReview.REVIEW_TEXT_PROPERTY);
       return this;
    }

    /**
     * fill the reviewText with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  reviewText) to fetch reviewText property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public ProductReviewRequest<T> unselectReviewText(){
       unselectProperty(ProductReview.REVIEW_TEXT_PROPERTY);
       return this;
    }
    public ProductReviewRequest<T> selectCreateTime(){
       selectProperty(ProductReview.CREATE_TIME_PROPERTY);
       return this;
    }

    /**
     * fill the createTime with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  createTime) to fetch createTime property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public ProductReviewRequest<T> unselectCreateTime(){
       unselectProperty(ProductReview.CREATE_TIME_PROPERTY);
       return this;
    }
    public ProductReviewRequest<T> selectUpdateTime(){
       selectProperty(ProductReview.UPDATE_TIME_PROPERTY);
       return this;
    }

    /**
     * fill the updateTime with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  updateTime) to fetch updateTime property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public ProductReviewRequest<T> unselectUpdateTime(){
       unselectProperty(ProductReview.UPDATE_TIME_PROPERTY);
       return this;
    }
    public ProductReviewRequest<T> selectVersion(){
       selectProperty(ProductReview.VERSION_PROPERTY);
       return this;
    }

    /**
     * fill the version with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  version) to fetch version property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public ProductReviewRequest<T> unselectVersion(){
       unselectProperty(ProductReview.VERSION_PROPERTY);
       return this;
    }

    public ProductReviewRequest<T> withId(Operator operator, Object... values){
       return appendSearchCriteria(createIdCriteria(operator, values));
    }

    public SearchCriteria createIdCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(ProductReview.ID_PROPERTY, operator, values);
    }

    public ProductReviewRequest<T> withIdIs(Long id){
       return withId(Operator.EQUAL, id);
    }
    public ProductReviewRequest<T> withIdIn(Long... id){
       return withId(Operator.EQUAL, (Object[])id);
    }



    public ProductReviewRequest<T> filterByCreatedAt(LocalDateTime... createdAt){
      if (createdAt == null || createdAt.length == 0) {
        throw new IllegalArgumentException("filterByCreatedAt parameter createdAt cannot be empty");
      }
      return appendSearchCriteria(createCreatedAtCriteria(Operator.EQUAL, (Object[])createdAt));
    }

    public ProductReviewRequest<T> withCreatedAt(Operator operator, Object... values){
       return appendSearchCriteria(createCreatedAtCriteria(operator, values));
    }

    public ProductReviewRequest<T> withCreatedAtIsUnknown(){
       return withCreatedAt(Operator.IS_NULL);
    }

    public ProductReviewRequest<T> withCreatedAtIsKnown(){
       return withCreatedAt(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createCreatedAtCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(ProductReview.CREATED_AT_PROPERTY, operator, values);
    }

    public ProductReviewRequest<T> withCreatedAtGreaterThan(LocalDateTime createdAt){
       return withCreatedAt(Operator.GREATER_THAN, createdAt);
    }

    public ProductReviewRequest<T> withCreatedAtGreaterThanOrEqualTo(LocalDateTime createdAt){
       return withCreatedAt(Operator.GREATER_THAN_OR_EQUAL, createdAt);
    }

    public ProductReviewRequest<T> withCreatedAtLessThan(LocalDateTime createdAt){
       return withCreatedAt(Operator.LESS_THAN, createdAt);
    }

    public ProductReviewRequest<T> withCreatedAtLessThanOrEqualTo(LocalDateTime createdAt){
       return withCreatedAt(Operator.LESS_THAN_OR_EQUAL, createdAt);
    }

    public ProductReviewRequest<T> withCreatedAtBetween(LocalDateTime startOfCreatedAt, LocalDateTime endOfCreatedAt){
       return withCreatedAt(Operator.BETWEEN, startOfCreatedAt, endOfCreatedAt);
    }
    public ProductReviewRequest<T> withCreatedAtBefore(LocalDateTime createdAt){
       return withCreatedAt(Operator.LESS_THAN, createdAt);
    }

    public ProductReviewRequest<T> withCreatedAtBefore(Date createdAt){
       return withCreatedAt(Operator.LESS_THAN, createdAt);
    }

    public ProductReviewRequest<T> withCreatedAtAfter(LocalDateTime createdAt){
       return withCreatedAt(Operator.GREATER_THAN, createdAt);
    }

    public ProductReviewRequest<T> withCreatedAtAfter(Date createdAt){
       return withCreatedAt(Operator.GREATER_THAN, createdAt);
    }

    public ProductReviewRequest<T> withCreatedAtBetween(Date startOfCreatedAt, Date endOfCreatedAt){
       return withCreatedAt(Operator.BETWEEN, startOfCreatedAt, endOfCreatedAt);
    }




    public ProductReviewRequest<T> filterByCustomer(Customer... customer){
      if (customer == null || customer.length == 0) {
        throw new IllegalArgumentException("filterByCustomer parameter customer cannot be empty");
      }
      return appendSearchCriteria(createCustomerCriteria(Operator.EQUAL, (Object[])customer));
    }

    public ProductReviewRequest<T> withCustomer(Operator operator, Object... values){
       return appendSearchCriteria(createCustomerCriteria(operator, values));
    }

    public ProductReviewRequest<T> withCustomerIsUnknown(){
       return withCustomer(Operator.IS_NULL);
    }

    public ProductReviewRequest<T> withCustomerIsKnown(){
       return withCustomer(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createCustomerCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(ProductReview.CUSTOMER_PROPERTY, operator, values);
    }

    public ProductReviewRequest<T> filterByCustomer(Long customer){
      if(customer == null){
         return this;
      }
      return withCustomer(Operator.EQUAL, customer);
    }
    public ProductReviewRequest<T> withCustomerMatching(CustomerRequest customer){
       return appendSearchCriteria(new SubQuerySearchCriteria(ProductReview.CUSTOMER_PROPERTY, customer, Customer.ID_PROPERTY));
    }

    public ProductReviewRequest<T> filterByProduct(Product... product){
      if (product == null || product.length == 0) {
        throw new IllegalArgumentException("filterByProduct parameter product cannot be empty");
      }
      return appendSearchCriteria(createProductCriteria(Operator.EQUAL, (Object[])product));
    }

    public ProductReviewRequest<T> withProduct(Operator operator, Object... values){
       return appendSearchCriteria(createProductCriteria(operator, values));
    }

    public ProductReviewRequest<T> withProductIsUnknown(){
       return withProduct(Operator.IS_NULL);
    }

    public ProductReviewRequest<T> withProductIsKnown(){
       return withProduct(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createProductCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(ProductReview.PRODUCT_PROPERTY, operator, values);
    }

    public ProductReviewRequest<T> filterByProduct(Long product){
      if(product == null){
         return this;
      }
      return withProduct(Operator.EQUAL, product);
    }
    public ProductReviewRequest<T> withProductMatching(ProductRequest product){
       return appendSearchCriteria(new SubQuerySearchCriteria(ProductReview.PRODUCT_PROPERTY, product, Product.ID_PROPERTY));
    }

    public ProductReviewRequest<T> filterByRating(BigDecimal... rating){
      if (rating == null || rating.length == 0) {
        throw new IllegalArgumentException("filterByRating parameter rating cannot be empty");
      }
      return appendSearchCriteria(createRatingCriteria(Operator.EQUAL, (Object[])rating));
    }

    public ProductReviewRequest<T> withRating(Operator operator, Object... values){
       return appendSearchCriteria(createRatingCriteria(operator, values));
    }

    public ProductReviewRequest<T> withRatingIsUnknown(){
       return withRating(Operator.IS_NULL);
    }

    public ProductReviewRequest<T> withRatingIsKnown(){
       return withRating(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createRatingCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(ProductReview.RATING_PROPERTY, operator, values);
    }

    public ProductReviewRequest<T> withRatingGreaterThan(BigDecimal rating){
       return withRating(Operator.GREATER_THAN, rating);
    }

    public ProductReviewRequest<T> withRatingGreaterThanOrEqualTo(BigDecimal rating){
       return withRating(Operator.GREATER_THAN_OR_EQUAL, rating);
    }

    public ProductReviewRequest<T> withRatingLessThan(BigDecimal rating){
       return withRating(Operator.LESS_THAN, rating);
    }

    public ProductReviewRequest<T> withRatingLessThanOrEqualTo(BigDecimal rating){
       return withRating(Operator.LESS_THAN_OR_EQUAL, rating);
    }

    public ProductReviewRequest<T> withRatingBetween(BigDecimal startOfRating, BigDecimal endOfRating){
       return withRating(Operator.BETWEEN, startOfRating, endOfRating);
    }



    public ProductReviewRequest<T> filterByReviewText(String... reviewText){
      if (reviewText == null || reviewText.length == 0) {
        throw new IllegalArgumentException("filterByReviewText parameter reviewText cannot be empty");
      }
      return appendSearchCriteria(createReviewTextCriteria(Operator.EQUAL, (Object[])reviewText));
    }

    public ProductReviewRequest<T> withReviewText(Operator operator, Object... values){
       return appendSearchCriteria(createReviewTextCriteria(operator, values));
    }

    public ProductReviewRequest<T> withReviewTextIsUnknown(){
       return withReviewText(Operator.IS_NULL);
    }

    public ProductReviewRequest<T> withReviewTextIsKnown(){
       return withReviewText(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createReviewTextCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(ProductReview.REVIEW_TEXT_PROPERTY, operator, values);
    }

    public ProductReviewRequest<T> withReviewTextGreaterThan(String reviewText){
       return withReviewText(Operator.GREATER_THAN, reviewText);
    }

    public ProductReviewRequest<T> withReviewTextGreaterThanOrEqualTo(String reviewText){
       return withReviewText(Operator.GREATER_THAN_OR_EQUAL, reviewText);
    }

    public ProductReviewRequest<T> withReviewTextLessThan(String reviewText){
       return withReviewText(Operator.LESS_THAN, reviewText);
    }

    public ProductReviewRequest<T> withReviewTextLessThanOrEqualTo(String reviewText){
       return withReviewText(Operator.LESS_THAN_OR_EQUAL, reviewText);
    }

    public ProductReviewRequest<T> withReviewTextBetween(String startOfReviewText, String endOfReviewText){
       return withReviewText(Operator.BETWEEN, startOfReviewText, endOfReviewText);
    }
    public ProductReviewRequest<T> withReviewTextStartingWith(String reviewText){
       return withReviewText(Operator.BEGIN_WITH, reviewText);
    }
    public ProductReviewRequest<T> withReviewTextContaining(String reviewText){
       return withReviewText(Operator.CONTAIN, reviewText);
    }

    public ProductReviewRequest<T> withReviewTextEndingWith(String reviewText){
       return withReviewText(Operator.END_WITH, reviewText);
    }

    public ProductReviewRequest<T> withReviewTextIs(String reviewText){
       return withReviewText(Operator.EQUAL, reviewText);
    }

    public ProductReviewRequest<T> withReviewTextSoundingLike(String reviewText){
       return withReviewText(Operator.SOUNDS_LIKE, reviewText);
    }



    public ProductReviewRequest<T> filterByCreateTime(LocalDateTime... createTime){
      if (createTime == null || createTime.length == 0) {
        throw new IllegalArgumentException("filterByCreateTime parameter createTime cannot be empty");
      }
      return appendSearchCriteria(createCreateTimeCriteria(Operator.EQUAL, (Object[])createTime));
    }

    public ProductReviewRequest<T> withCreateTime(Operator operator, Object... values){
       return appendSearchCriteria(createCreateTimeCriteria(operator, values));
    }

    public ProductReviewRequest<T> withCreateTimeIsUnknown(){
       return withCreateTime(Operator.IS_NULL);
    }

    public ProductReviewRequest<T> withCreateTimeIsKnown(){
       return withCreateTime(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createCreateTimeCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(ProductReview.CREATE_TIME_PROPERTY, operator, values);
    }

    public ProductReviewRequest<T> withCreateTimeGreaterThan(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public ProductReviewRequest<T> withCreateTimeGreaterThanOrEqualTo(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN_OR_EQUAL, createTime);
    }

    public ProductReviewRequest<T> withCreateTimeLessThan(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public ProductReviewRequest<T> withCreateTimeLessThanOrEqualTo(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN_OR_EQUAL, createTime);
    }

    public ProductReviewRequest<T> withCreateTimeBetween(LocalDateTime startOfCreateTime, LocalDateTime endOfCreateTime){
       return withCreateTime(Operator.BETWEEN, startOfCreateTime, endOfCreateTime);
    }
    public ProductReviewRequest<T> withCreateTimeBefore(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public ProductReviewRequest<T> withCreateTimeBefore(Date createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public ProductReviewRequest<T> withCreateTimeAfter(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public ProductReviewRequest<T> withCreateTimeAfter(Date createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public ProductReviewRequest<T> withCreateTimeBetween(Date startOfCreateTime, Date endOfCreateTime){
       return withCreateTime(Operator.BETWEEN, startOfCreateTime, endOfCreateTime);
    }




    public ProductReviewRequest<T> filterByUpdateTime(LocalDateTime... updateTime){
      if (updateTime == null || updateTime.length == 0) {
        throw new IllegalArgumentException("filterByUpdateTime parameter updateTime cannot be empty");
      }
      return appendSearchCriteria(createUpdateTimeCriteria(Operator.EQUAL, (Object[])updateTime));
    }

    public ProductReviewRequest<T> withUpdateTime(Operator operator, Object... values){
       return appendSearchCriteria(createUpdateTimeCriteria(operator, values));
    }

    public ProductReviewRequest<T> withUpdateTimeIsUnknown(){
       return withUpdateTime(Operator.IS_NULL);
    }

    public ProductReviewRequest<T> withUpdateTimeIsKnown(){
       return withUpdateTime(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createUpdateTimeCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(ProductReview.UPDATE_TIME_PROPERTY, operator, values);
    }

    public ProductReviewRequest<T> withUpdateTimeGreaterThan(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public ProductReviewRequest<T> withUpdateTimeGreaterThanOrEqualTo(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN_OR_EQUAL, updateTime);
    }

    public ProductReviewRequest<T> withUpdateTimeLessThan(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public ProductReviewRequest<T> withUpdateTimeLessThanOrEqualTo(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN_OR_EQUAL, updateTime);
    }

    public ProductReviewRequest<T> withUpdateTimeBetween(LocalDateTime startOfUpdateTime, LocalDateTime endOfUpdateTime){
       return withUpdateTime(Operator.BETWEEN, startOfUpdateTime, endOfUpdateTime);
    }
    public ProductReviewRequest<T> withUpdateTimeBefore(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public ProductReviewRequest<T> withUpdateTimeBefore(Date updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public ProductReviewRequest<T> withUpdateTimeAfter(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public ProductReviewRequest<T> withUpdateTimeAfter(Date updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public ProductReviewRequest<T> withUpdateTimeBetween(Date startOfUpdateTime, Date endOfUpdateTime){
       return withUpdateTime(Operator.BETWEEN, startOfUpdateTime, endOfUpdateTime);
    }




    public ProductReviewRequest<T> filterByVersion(Long... version){
      if (version == null || version.length == 0) {
        throw new IllegalArgumentException("filterByVersion parameter version cannot be empty");
      }
      return appendSearchCriteria(createVersionCriteria(Operator.EQUAL, (Object[])version));
    }

    public ProductReviewRequest<T> withVersion(Operator operator, Object... values){
       return appendSearchCriteria(createVersionCriteria(operator, values));
    }

    public ProductReviewRequest<T> withVersionIsUnknown(){
       return withVersion(Operator.IS_NULL);
    }

    public ProductReviewRequest<T> withVersionIsKnown(){
       return withVersion(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createVersionCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(ProductReview.VERSION_PROPERTY, operator, values);
    }

    public ProductReviewRequest<T> withVersionGreaterThan(Long version){
       return withVersion(Operator.GREATER_THAN, version);
    }

    public ProductReviewRequest<T> withVersionGreaterThanOrEqualTo(Long version){
       return withVersion(Operator.GREATER_THAN_OR_EQUAL, version);
    }

    public ProductReviewRequest<T> withVersionLessThan(Long version){
       return withVersion(Operator.LESS_THAN, version);
    }

    public ProductReviewRequest<T> withVersionLessThanOrEqualTo(Long version){
       return withVersion(Operator.LESS_THAN_OR_EQUAL, version);
    }

    public ProductReviewRequest<T> withVersionBetween(Long startOfVersion, Long endOfVersion){
       return withVersion(Operator.BETWEEN, startOfVersion, endOfVersion);
    }


    public ProductReviewRequest<T> count(){
        super.count();
        return this;
    }
    public ProductReviewRequest<T> countAs(String retName){
        super.count(retName);
        return this;
    }
    public ProductReviewRequest minRating(){
        return minRatingAs(prefix("minOf",ProductReview.RATING_PROPERTY));
    }

    public ProductReviewRequest minRatingAs(String retName){
        super.min(retName, ProductReview.RATING_PROPERTY);
        return this;
    }
    public ProductReviewRequest maxRating(){
        return maxRatingAs(prefix("maxOf",ProductReview.RATING_PROPERTY));
    }

    public ProductReviewRequest maxRatingAs(String retName){
        super.max(retName, ProductReview.RATING_PROPERTY);
        return this;
    }
    public ProductReviewRequest sumRating(){
        return sumRatingAs(prefix("sumOf",ProductReview.RATING_PROPERTY));
    }

    public ProductReviewRequest sumRatingAs(String retName){
        super.sum(retName, ProductReview.RATING_PROPERTY);
        return this;
    }
    public ProductReviewRequest avgRating(){
        return avgRatingAs(prefix("avgOf",ProductReview.RATING_PROPERTY));
    }

    public ProductReviewRequest avgRatingAs(String retName){
        super.avg(retName, ProductReview.RATING_PROPERTY);
        return this;
    }
    public ProductReviewRequest standardDeviationRating(){
        return standardDeviationRatingAs(prefix("standardDeviationOf",ProductReview.RATING_PROPERTY));
    }

    public ProductReviewRequest standardDeviationRatingAs(String retName){
        super.standardDeviation(retName, ProductReview.RATING_PROPERTY);
        return this;
    }
    public ProductReviewRequest squareRootOfPopulationStandardDeviationRating(){
        return squareRootOfPopulationStandardDeviationRatingAs(prefix("squareRootOfPopulationStandardDeviationOf",ProductReview.RATING_PROPERTY));
    }

    public ProductReviewRequest squareRootOfPopulationStandardDeviationRatingAs(String retName){
        super.squareRootOfPopulationStandardDeviation(retName, ProductReview.RATING_PROPERTY);
        return this;
    }
    public ProductReviewRequest sampleVarianceRating(){
        return sampleVarianceRatingAs(prefix("sampleVarianceOf",ProductReview.RATING_PROPERTY));
    }

    public ProductReviewRequest sampleVarianceRatingAs(String retName){
        super.sampleVariance(retName, ProductReview.RATING_PROPERTY);
        return this;
    }
    public ProductReviewRequest samplePopulationVarianceRating(){
        return samplePopulationVarianceRatingAs(prefix("samplePopulationVarianceOf",ProductReview.RATING_PROPERTY));
    }

    public ProductReviewRequest samplePopulationVarianceRatingAs(String retName){
        super.samplePopulationVariance(retName, ProductReview.RATING_PROPERTY);
        return this;
    }
    public ProductReviewRequest<T> groupByCustomerWithDetails(){
       return groupByCustomerWithDetails(Q.customers().unlimited());
    }

    public ProductReviewRequest<T> groupByCustomerWithDetails(CustomerRequest subRequest){
       aggregate(ProductReview.CUSTOMER_PROPERTY, subRequest);
       return this;
    }

    public ProductReviewRequest<T> groupByProductWithDetails(){
       return groupByProductWithDetails(Q.products().unlimited());
    }

    public ProductReviewRequest<T> groupByProductWithDetails(ProductRequest subRequest){
       aggregate(ProductReview.PRODUCT_PROPERTY, subRequest);
       return this;
    }







    public ProductReviewRequest<T> groupById(){
       groupBy(ProductReview.ID_PROPERTY);
       return this;
    }

    public ProductReviewRequest<T> groupByIdAs(String retName){
       groupBy(retName, ProductReview.ID_PROPERTY);
       return this;
    }

    public ProductReviewRequest<T> groupByIdWithFunction(String retName, AggrFunction function){
       groupBy(retName, ProductReview.ID_PROPERTY, function);
       return this;
    }

    public ProductReviewRequest<T> groupByCreatedAt(){
       groupBy(ProductReview.CREATED_AT_PROPERTY);
       return this;
    }

    public ProductReviewRequest<T> groupByCreatedAtAs(String retName){
       groupBy(retName, ProductReview.CREATED_AT_PROPERTY);
       return this;
    }

    public ProductReviewRequest<T> groupByCreatedAtWithFunction(String retName, AggrFunction function){
       groupBy(retName, ProductReview.CREATED_AT_PROPERTY, function);
       return this;
    }
    public ProductReviewRequest<T> groupByCustomerWith(CustomerRequest subRequest){
       groupBy(ProductReview.CUSTOMER_PROPERTY, subRequest);
       return this;
    }
    public ProductReviewRequest<T> groupByCustomer(){
       groupBy(ProductReview.CUSTOMER_PROPERTY);
       return this;
    }

    public ProductReviewRequest<T> groupByCustomerAs(String retName){
       groupBy(retName, ProductReview.CUSTOMER_PROPERTY);
       return this;
    }

    public ProductReviewRequest<T> groupByCustomerWithFunction(String retName, AggrFunction function){
       groupBy(retName, ProductReview.CUSTOMER_PROPERTY, function);
       return this;
    }
    public ProductReviewRequest<T> groupByProductWith(ProductRequest subRequest){
       groupBy(ProductReview.PRODUCT_PROPERTY, subRequest);
       return this;
    }
    public ProductReviewRequest<T> groupByProduct(){
       groupBy(ProductReview.PRODUCT_PROPERTY);
       return this;
    }

    public ProductReviewRequest<T> groupByProductAs(String retName){
       groupBy(retName, ProductReview.PRODUCT_PROPERTY);
       return this;
    }

    public ProductReviewRequest<T> groupByProductWithFunction(String retName, AggrFunction function){
       groupBy(retName, ProductReview.PRODUCT_PROPERTY, function);
       return this;
    }

    public ProductReviewRequest<T> groupByRating(){
       groupBy(ProductReview.RATING_PROPERTY);
       return this;
    }

    public ProductReviewRequest<T> groupByRatingAs(String retName){
       groupBy(retName, ProductReview.RATING_PROPERTY);
       return this;
    }

    public ProductReviewRequest<T> groupByRatingWithFunction(String retName, AggrFunction function){
       groupBy(retName, ProductReview.RATING_PROPERTY, function);
       return this;
    }

    public ProductReviewRequest<T> groupByReviewText(){
       groupBy(ProductReview.REVIEW_TEXT_PROPERTY);
       return this;
    }

    public ProductReviewRequest<T> groupByReviewTextAs(String retName){
       groupBy(retName, ProductReview.REVIEW_TEXT_PROPERTY);
       return this;
    }

    public ProductReviewRequest<T> groupByReviewTextWithFunction(String retName, AggrFunction function){
       groupBy(retName, ProductReview.REVIEW_TEXT_PROPERTY, function);
       return this;
    }

    public ProductReviewRequest<T> groupByCreateTime(){
       groupBy(ProductReview.CREATE_TIME_PROPERTY);
       return this;
    }

    public ProductReviewRequest<T> groupByCreateTimeAs(String retName){
       groupBy(retName, ProductReview.CREATE_TIME_PROPERTY);
       return this;
    }

    public ProductReviewRequest<T> groupByCreateTimeWithFunction(String retName, AggrFunction function){
       groupBy(retName, ProductReview.CREATE_TIME_PROPERTY, function);
       return this;
    }

    public ProductReviewRequest<T> groupByUpdateTime(){
       groupBy(ProductReview.UPDATE_TIME_PROPERTY);
       return this;
    }

    public ProductReviewRequest<T> groupByUpdateTimeAs(String retName){
       groupBy(retName, ProductReview.UPDATE_TIME_PROPERTY);
       return this;
    }

    public ProductReviewRequest<T> groupByUpdateTimeWithFunction(String retName, AggrFunction function){
       groupBy(retName, ProductReview.UPDATE_TIME_PROPERTY, function);
       return this;
    }

    public ProductReviewRequest<T> groupByVersion(){
       groupBy(ProductReview.VERSION_PROPERTY);
       return this;
    }

    public ProductReviewRequest<T> groupByVersionAs(String retName){
       groupBy(retName, ProductReview.VERSION_PROPERTY);
       return this;
    }

    public ProductReviewRequest<T> groupByVersionWithFunction(String retName, AggrFunction function){
       groupBy(retName, ProductReview.VERSION_PROPERTY, function);
       return this;
    }



    public ProductReviewRequest<T> orderByIdAscending(){
       addOrderByAscending(ProductReview.ID_PROPERTY);
       return this;
    }

    public ProductReviewRequest<T> orderByIdDescending(){
       addOrderByDescending(ProductReview.ID_PROPERTY);
       return this;
    }

    public ProductReviewRequest<T> orderByCreatedAtAscending(){
       addOrderByAscending(ProductReview.CREATED_AT_PROPERTY);
       return this;
    }

    public ProductReviewRequest<T> orderByCreatedAtDescending(){
       addOrderByDescending(ProductReview.CREATED_AT_PROPERTY);
       return this;
    }

    public ProductReviewRequest<T> orderByCustomerAscending(){
       addOrderByAscending(ProductReview.CUSTOMER_PROPERTY);
       return this;
    }

    public ProductReviewRequest<T> orderByCustomerDescending(){
       addOrderByDescending(ProductReview.CUSTOMER_PROPERTY);
       return this;
    }

    public ProductReviewRequest<T> orderByProductAscending(){
       addOrderByAscending(ProductReview.PRODUCT_PROPERTY);
       return this;
    }

    public ProductReviewRequest<T> orderByProductDescending(){
       addOrderByDescending(ProductReview.PRODUCT_PROPERTY);
       return this;
    }

    public ProductReviewRequest<T> orderByRatingAscending(){
       addOrderByAscending(ProductReview.RATING_PROPERTY);
       return this;
    }

    public ProductReviewRequest<T> orderByRatingDescending(){
       addOrderByDescending(ProductReview.RATING_PROPERTY);
       return this;
    }

    public ProductReviewRequest<T> orderByReviewTextAscending(){
       addOrderByAscending(ProductReview.REVIEW_TEXT_PROPERTY);
       return this;
    }

    public ProductReviewRequest<T> orderByReviewTextDescending(){
       addOrderByDescending(ProductReview.REVIEW_TEXT_PROPERTY);
       return this;
    }
    public ProductReviewRequest<T> orderByReviewTextAscendingUsingGBK(){
       addOrderByAscendingUsingGBK(ProductReview.REVIEW_TEXT_PROPERTY);
       return this;
    }

    public ProductReviewRequest<T> orderByReviewTextDescendingUsingGBK(){
       addOrderByDescendingUsingGBK(ProductReview.REVIEW_TEXT_PROPERTY);
       return this;
    }
    public ProductReviewRequest<T> orderByCreateTimeAscending(){
       addOrderByAscending(ProductReview.CREATE_TIME_PROPERTY);
       return this;
    }

    public ProductReviewRequest<T> orderByCreateTimeDescending(){
       addOrderByDescending(ProductReview.CREATE_TIME_PROPERTY);
       return this;
    }

    public ProductReviewRequest<T> orderByUpdateTimeAscending(){
       addOrderByAscending(ProductReview.UPDATE_TIME_PROPERTY);
       return this;
    }

    public ProductReviewRequest<T> orderByUpdateTimeDescending(){
       addOrderByDescending(ProductReview.UPDATE_TIME_PROPERTY);
       return this;
    }

    public ProductReviewRequest<T> orderByVersionAscending(){
       addOrderByAscending(ProductReview.VERSION_PROPERTY);
       return this;
    }

    public ProductReviewRequest<T> orderByVersionDescending(){
       addOrderByDescending(ProductReview.VERSION_PROPERTY);
       return this;
    }


    public CustomerRequest rollUpToCustomer(){
       CustomerRequest customer = Q.customers().unlimited();
       this.withCustomerMatching(customer)
           .groupByCustomerWith(customer);
       return customer;
    }

    public ProductRequest rollUpToProduct(){
       ProductRequest product = Q.products().unlimited();
       this.withProductMatching(product)
           .groupByProductWith(product);
       return product;
    }







   public ProductReviewRequest<T> facetByCustomerAs(String facetName, CustomerRequest customer){
       return facetByCustomerAs(facetName, customer, true);
   }

   public ProductReviewRequest<T> facetByCustomerAs(String facetName, CustomerRequest customer, boolean includeAllFacets){
       addFacet(facetName, ProductReview.CUSTOMER_PROPERTY, customer, includeAllFacets);
       return this;
   }
   public ProductReviewRequest<T> facetByProductAs(String facetName, ProductRequest product){
       return facetByProductAs(facetName, product, true);
   }

   public ProductReviewRequest<T> facetByProductAs(String facetName, ProductRequest product, boolean includeAllFacets){
       addFacet(facetName, ProductReview.PRODUCT_PROPERTY, product, includeAllFacets);
       return this;
   }


    /**
     * get topN records
     * @param topN  records number
     */
    public ProductReviewRequest<T> top(int topN) {
        super.top(topN);
        return this;
    }

    /**
     * get records from offset(inclusive) to offset+size(exclusive)
     * @param offset record offset
     * @param size records number
     */
    public ProductReviewRequest<T> offset(int offset, int size) {
        super.offset(offset, size);
        return this;
    }

    /**
     * retrieve all records
     */
    public ProductReviewRequest<T> unlimited() {
        super.unlimited();
        return this;
    }

    /**
     * get records of one page
     * @param pageNumber page number(1-based)
     * @param pageSize page size
     */
    public ProductReviewRequest<T> page(int pageNumber, int pageSize) {
        int offset = (pageNumber - 1) * pageSize;
        return offset(offset, pageSize);
   }

    /**
     * get records of one page, default page size is 10
     * @param pageNumber page number(1-based)
     */
    public ProductReviewRequest<T> page(int pageNumber) {
        return page(pageNumber, 10);
   }
}