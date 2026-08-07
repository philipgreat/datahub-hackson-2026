
package com.example.enterpriseerpsystem.promotion;

import com.example.enterpriseerpsystem.Q;
import com.example.enterpriseerpsystem.coupon.Coupon;
import com.example.enterpriseerpsystem.coupon.CouponRequest;
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

public class PromotionRequest<T extends Promotion> extends BaseRequest<T> {

    /**
     * @deprecated AI agents and business code must use the generated Q facade
     *             instead of constructing request builders directly.
     */
    @Deprecated
    public PromotionRequest(Class<T> returnType){
        super(returnType);
        selectId();
        selectVersion();
    }

    public PromotionRequest<T> comment(String comment){
         super.internalComment(comment);
         return this;
    }

    // purpose() 继承自 BaseRequest，返回 ExecutableRequest（终结方法）

    public PromotionRequest<T> returnType(Class<? extends T> returnType){
        super.setReturnType(returnType);
        return this;
    }

    public PromotionRequest<T> enableAggregationCache(long cacheExpiredMillis){
        super.enableAggregationCache();
        super.aggregateCacheTime(cacheExpiredMillis);
        return this;
    }

    public PromotionRequest<T> enableAggregationCache(){
        return enableAggregationCache(0l);
    }


    public PromotionRequest<T> propagateAggregationCache(long cacheExpiredMillis){
        super.propagateAggregationCache(cacheExpiredMillis);
        return this;
    }

    public PromotionRequest<T> appendSearchCriteria(SearchCriteria searchCriteria){
        return (PromotionRequest<T>)super.appendSearchCriteria(searchCriteria);
    }

    public PromotionRequest<T> filter(String property1, Operator operator, String property2){
        return appendSearchCriteria(new TwoOperatorCriteria(operator, new PropertyReference(property1), new PropertyReference(property2)));
    }


    public PromotionRequest<T> matchingAnyOf(PromotionRequest promotion){
        super.internalMatchAny(promotion);
        return this;
    }

    public PromotionRequest<T> enhanceChildrenIfNeeded(){
        return this;
    }

    public PromotionRequest<T> withDeletedRows(){
        super.withDeletedRows();
        return this;
    }

    public PromotionRequest<T> deletedRowsOnly(){
        super.deletedRowsOnly();
        return this;
    }

    public PromotionRequest<T> selectSelf(){
        super.selectSelf();
        return selectId().selectName().selectDiscountPercentage().selectEndDate().selectStartDate().selectCreateTime().selectUpdateTime().selectVersion();
    }

    public PromotionRequest<T> selectSelfFields(){
        return selectSelf();
    }

    public PromotionRequest<T> selectAll(){
        super.selectAll();
        return selectId().selectName().selectDiscountPercentage().selectEndDate().selectStartDate().selectCreateTime().selectUpdateTime().selectVersion();
    }

    public PromotionRequest<T> selectChildren(){
        super.selectAny();
        selectCouponList();
        return selectId().selectName().selectDiscountPercentage().selectEndDate().selectStartDate().selectCreateTime().selectUpdateTime().selectVersion();
    }


    public PromotionRequest<T> selectId(){
       selectProperty(Promotion.ID_PROPERTY);
       return this;
    }

    /**
     * fill the id with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  id) to fetch id property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public PromotionRequest<T> unselectId(){
       unselectProperty(Promotion.ID_PROPERTY);
       return this;
    }
    public PromotionRequest<T> selectName(){
       selectProperty(Promotion.NAME_PROPERTY);
       return this;
    }

    /**
     * fill the name with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  name) to fetch name property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public PromotionRequest<T> unselectName(){
       unselectProperty(Promotion.NAME_PROPERTY);
       return this;
    }
    public PromotionRequest<T> selectDiscountPercentage(){
       selectProperty(Promotion.DISCOUNT_PERCENTAGE_PROPERTY);
       return this;
    }

    /**
     * fill the discountPercentage with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  discountPercentage) to fetch discountPercentage property.
     * @param rawSqlSegment  customized rawSqlSegment
     */


    /**
     * fill the discountPercentage with customized aggrFunction, TEAQL uses ({aggrFunction}(discountPercentage) AS discountPercentage to fetch discountPercentage property.
     * @param aggrFunction  aggrFunction
     */
    public PromotionRequest<T> selectDiscountPercentage(AggrFunction aggrFunction){
       selectProperty(Promotion.DISCOUNT_PERCENTAGE_PROPERTY, aggrFunction);
       return this;
    }


    public PromotionRequest<T> unselectDiscountPercentage(){
       unselectProperty(Promotion.DISCOUNT_PERCENTAGE_PROPERTY);
       return this;
    }
    public PromotionRequest<T> selectEndDate(){
       selectProperty(Promotion.END_DATE_PROPERTY);
       return this;
    }

    /**
     * fill the endDate with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  endDate) to fetch endDate property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public PromotionRequest<T> unselectEndDate(){
       unselectProperty(Promotion.END_DATE_PROPERTY);
       return this;
    }
    public PromotionRequest<T> selectStartDate(){
       selectProperty(Promotion.START_DATE_PROPERTY);
       return this;
    }

    /**
     * fill the startDate with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  startDate) to fetch startDate property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public PromotionRequest<T> unselectStartDate(){
       unselectProperty(Promotion.START_DATE_PROPERTY);
       return this;
    }
    public PromotionRequest<T> selectCreateTime(){
       selectProperty(Promotion.CREATE_TIME_PROPERTY);
       return this;
    }

    /**
     * fill the createTime with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  createTime) to fetch createTime property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public PromotionRequest<T> unselectCreateTime(){
       unselectProperty(Promotion.CREATE_TIME_PROPERTY);
       return this;
    }
    public PromotionRequest<T> selectUpdateTime(){
       selectProperty(Promotion.UPDATE_TIME_PROPERTY);
       return this;
    }

    /**
     * fill the updateTime with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  updateTime) to fetch updateTime property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public PromotionRequest<T> unselectUpdateTime(){
       unselectProperty(Promotion.UPDATE_TIME_PROPERTY);
       return this;
    }
    public PromotionRequest<T> selectVersion(){
       selectProperty(Promotion.VERSION_PROPERTY);
       return this;
    }

    /**
     * fill the version with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  version) to fetch version property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public PromotionRequest<T> unselectVersion(){
       unselectProperty(Promotion.VERSION_PROPERTY);
       return this;
    }
    public PromotionRequest<T> selectCouponList(){
       return selectCouponListWith(Q.coupons().selectSelf());
    }

    public PromotionRequest<T> selectCouponListWith(CouponRequest couponList){
       enhanceRelation(Promotion.COUPON_LIST_PROPERTY, couponList);
       return this;
    }

    public PromotionRequest<T> withId(Operator operator, Object... values){
       return appendSearchCriteria(createIdCriteria(operator, values));
    }

    public SearchCriteria createIdCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Promotion.ID_PROPERTY, operator, values);
    }

    public PromotionRequest<T> withIdIs(Long id){
       return withId(Operator.EQUAL, id);
    }
    public PromotionRequest<T> withIdIn(Long... id){
       return withId(Operator.EQUAL, (Object[])id);
    }



    public PromotionRequest<T> filterByName(String... name){
      if (name == null || name.length == 0) {
        throw new IllegalArgumentException("filterByName parameter name cannot be empty");
      }
      return appendSearchCriteria(createNameCriteria(Operator.EQUAL, (Object[])name));
    }

    public PromotionRequest<T> withName(Operator operator, Object... values){
       return appendSearchCriteria(createNameCriteria(operator, values));
    }

    public PromotionRequest<T> withNameIsUnknown(){
       return withName(Operator.IS_NULL);
    }

    public PromotionRequest<T> withNameIsKnown(){
       return withName(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createNameCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Promotion.NAME_PROPERTY, operator, values);
    }

    public PromotionRequest<T> withNameGreaterThan(String name){
       return withName(Operator.GREATER_THAN, name);
    }

    public PromotionRequest<T> withNameGreaterThanOrEqualTo(String name){
       return withName(Operator.GREATER_THAN_OR_EQUAL, name);
    }

    public PromotionRequest<T> withNameLessThan(String name){
       return withName(Operator.LESS_THAN, name);
    }

    public PromotionRequest<T> withNameLessThanOrEqualTo(String name){
       return withName(Operator.LESS_THAN_OR_EQUAL, name);
    }

    public PromotionRequest<T> withNameBetween(String startOfName, String endOfName){
       return withName(Operator.BETWEEN, startOfName, endOfName);
    }
    public PromotionRequest<T> withNameStartingWith(String name){
       return withName(Operator.BEGIN_WITH, name);
    }
    public PromotionRequest<T> withNameContaining(String name){
       return withName(Operator.CONTAIN, name);
    }

    public PromotionRequest<T> withNameEndingWith(String name){
       return withName(Operator.END_WITH, name);
    }

    public PromotionRequest<T> withNameIs(String name){
       return withName(Operator.EQUAL, name);
    }

    public PromotionRequest<T> withNameSoundingLike(String name){
       return withName(Operator.SOUNDS_LIKE, name);
    }



    public PromotionRequest<T> filterByDiscountPercentage(BigDecimal... discountPercentage){
      if (discountPercentage == null || discountPercentage.length == 0) {
        throw new IllegalArgumentException("filterByDiscountPercentage parameter discountPercentage cannot be empty");
      }
      return appendSearchCriteria(createDiscountPercentageCriteria(Operator.EQUAL, (Object[])discountPercentage));
    }

    public PromotionRequest<T> withDiscountPercentage(Operator operator, Object... values){
       return appendSearchCriteria(createDiscountPercentageCriteria(operator, values));
    }

    public PromotionRequest<T> withDiscountPercentageIsUnknown(){
       return withDiscountPercentage(Operator.IS_NULL);
    }

    public PromotionRequest<T> withDiscountPercentageIsKnown(){
       return withDiscountPercentage(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createDiscountPercentageCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Promotion.DISCOUNT_PERCENTAGE_PROPERTY, operator, values);
    }

    public PromotionRequest<T> withDiscountPercentageGreaterThan(BigDecimal discountPercentage){
       return withDiscountPercentage(Operator.GREATER_THAN, discountPercentage);
    }

    public PromotionRequest<T> withDiscountPercentageGreaterThanOrEqualTo(BigDecimal discountPercentage){
       return withDiscountPercentage(Operator.GREATER_THAN_OR_EQUAL, discountPercentage);
    }

    public PromotionRequest<T> withDiscountPercentageLessThan(BigDecimal discountPercentage){
       return withDiscountPercentage(Operator.LESS_THAN, discountPercentage);
    }

    public PromotionRequest<T> withDiscountPercentageLessThanOrEqualTo(BigDecimal discountPercentage){
       return withDiscountPercentage(Operator.LESS_THAN_OR_EQUAL, discountPercentage);
    }

    public PromotionRequest<T> withDiscountPercentageBetween(BigDecimal startOfDiscountPercentage, BigDecimal endOfDiscountPercentage){
       return withDiscountPercentage(Operator.BETWEEN, startOfDiscountPercentage, endOfDiscountPercentage);
    }



    public PromotionRequest<T> filterByEndDate(LocalDateTime... endDate){
      if (endDate == null || endDate.length == 0) {
        throw new IllegalArgumentException("filterByEndDate parameter endDate cannot be empty");
      }
      return appendSearchCriteria(createEndDateCriteria(Operator.EQUAL, (Object[])endDate));
    }

    public PromotionRequest<T> withEndDate(Operator operator, Object... values){
       return appendSearchCriteria(createEndDateCriteria(operator, values));
    }

    public PromotionRequest<T> withEndDateIsUnknown(){
       return withEndDate(Operator.IS_NULL);
    }

    public PromotionRequest<T> withEndDateIsKnown(){
       return withEndDate(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createEndDateCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Promotion.END_DATE_PROPERTY, operator, values);
    }

    public PromotionRequest<T> withEndDateGreaterThan(LocalDateTime endDate){
       return withEndDate(Operator.GREATER_THAN, endDate);
    }

    public PromotionRequest<T> withEndDateGreaterThanOrEqualTo(LocalDateTime endDate){
       return withEndDate(Operator.GREATER_THAN_OR_EQUAL, endDate);
    }

    public PromotionRequest<T> withEndDateLessThan(LocalDateTime endDate){
       return withEndDate(Operator.LESS_THAN, endDate);
    }

    public PromotionRequest<T> withEndDateLessThanOrEqualTo(LocalDateTime endDate){
       return withEndDate(Operator.LESS_THAN_OR_EQUAL, endDate);
    }

    public PromotionRequest<T> withEndDateBetween(LocalDateTime startOfEndDate, LocalDateTime endOfEndDate){
       return withEndDate(Operator.BETWEEN, startOfEndDate, endOfEndDate);
    }
    public PromotionRequest<T> withEndDateBefore(LocalDateTime endDate){
       return withEndDate(Operator.LESS_THAN, endDate);
    }

    public PromotionRequest<T> withEndDateBefore(Date endDate){
       return withEndDate(Operator.LESS_THAN, endDate);
    }

    public PromotionRequest<T> withEndDateAfter(LocalDateTime endDate){
       return withEndDate(Operator.GREATER_THAN, endDate);
    }

    public PromotionRequest<T> withEndDateAfter(Date endDate){
       return withEndDate(Operator.GREATER_THAN, endDate);
    }

    public PromotionRequest<T> withEndDateBetween(Date startOfEndDate, Date endOfEndDate){
       return withEndDate(Operator.BETWEEN, startOfEndDate, endOfEndDate);
    }




    public PromotionRequest<T> filterByStartDate(LocalDateTime... startDate){
      if (startDate == null || startDate.length == 0) {
        throw new IllegalArgumentException("filterByStartDate parameter startDate cannot be empty");
      }
      return appendSearchCriteria(createStartDateCriteria(Operator.EQUAL, (Object[])startDate));
    }

    public PromotionRequest<T> withStartDate(Operator operator, Object... values){
       return appendSearchCriteria(createStartDateCriteria(operator, values));
    }

    public PromotionRequest<T> withStartDateIsUnknown(){
       return withStartDate(Operator.IS_NULL);
    }

    public PromotionRequest<T> withStartDateIsKnown(){
       return withStartDate(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createStartDateCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Promotion.START_DATE_PROPERTY, operator, values);
    }

    public PromotionRequest<T> withStartDateGreaterThan(LocalDateTime startDate){
       return withStartDate(Operator.GREATER_THAN, startDate);
    }

    public PromotionRequest<T> withStartDateGreaterThanOrEqualTo(LocalDateTime startDate){
       return withStartDate(Operator.GREATER_THAN_OR_EQUAL, startDate);
    }

    public PromotionRequest<T> withStartDateLessThan(LocalDateTime startDate){
       return withStartDate(Operator.LESS_THAN, startDate);
    }

    public PromotionRequest<T> withStartDateLessThanOrEqualTo(LocalDateTime startDate){
       return withStartDate(Operator.LESS_THAN_OR_EQUAL, startDate);
    }

    public PromotionRequest<T> withStartDateBetween(LocalDateTime startOfStartDate, LocalDateTime endOfStartDate){
       return withStartDate(Operator.BETWEEN, startOfStartDate, endOfStartDate);
    }
    public PromotionRequest<T> withStartDateBefore(LocalDateTime startDate){
       return withStartDate(Operator.LESS_THAN, startDate);
    }

    public PromotionRequest<T> withStartDateBefore(Date startDate){
       return withStartDate(Operator.LESS_THAN, startDate);
    }

    public PromotionRequest<T> withStartDateAfter(LocalDateTime startDate){
       return withStartDate(Operator.GREATER_THAN, startDate);
    }

    public PromotionRequest<T> withStartDateAfter(Date startDate){
       return withStartDate(Operator.GREATER_THAN, startDate);
    }

    public PromotionRequest<T> withStartDateBetween(Date startOfStartDate, Date endOfStartDate){
       return withStartDate(Operator.BETWEEN, startOfStartDate, endOfStartDate);
    }




    public PromotionRequest<T> filterByCreateTime(LocalDateTime... createTime){
      if (createTime == null || createTime.length == 0) {
        throw new IllegalArgumentException("filterByCreateTime parameter createTime cannot be empty");
      }
      return appendSearchCriteria(createCreateTimeCriteria(Operator.EQUAL, (Object[])createTime));
    }

    public PromotionRequest<T> withCreateTime(Operator operator, Object... values){
       return appendSearchCriteria(createCreateTimeCriteria(operator, values));
    }

    public PromotionRequest<T> withCreateTimeIsUnknown(){
       return withCreateTime(Operator.IS_NULL);
    }

    public PromotionRequest<T> withCreateTimeIsKnown(){
       return withCreateTime(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createCreateTimeCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Promotion.CREATE_TIME_PROPERTY, operator, values);
    }

    public PromotionRequest<T> withCreateTimeGreaterThan(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public PromotionRequest<T> withCreateTimeGreaterThanOrEqualTo(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN_OR_EQUAL, createTime);
    }

    public PromotionRequest<T> withCreateTimeLessThan(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public PromotionRequest<T> withCreateTimeLessThanOrEqualTo(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN_OR_EQUAL, createTime);
    }

    public PromotionRequest<T> withCreateTimeBetween(LocalDateTime startOfCreateTime, LocalDateTime endOfCreateTime){
       return withCreateTime(Operator.BETWEEN, startOfCreateTime, endOfCreateTime);
    }
    public PromotionRequest<T> withCreateTimeBefore(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public PromotionRequest<T> withCreateTimeBefore(Date createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public PromotionRequest<T> withCreateTimeAfter(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public PromotionRequest<T> withCreateTimeAfter(Date createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public PromotionRequest<T> withCreateTimeBetween(Date startOfCreateTime, Date endOfCreateTime){
       return withCreateTime(Operator.BETWEEN, startOfCreateTime, endOfCreateTime);
    }




    public PromotionRequest<T> filterByUpdateTime(LocalDateTime... updateTime){
      if (updateTime == null || updateTime.length == 0) {
        throw new IllegalArgumentException("filterByUpdateTime parameter updateTime cannot be empty");
      }
      return appendSearchCriteria(createUpdateTimeCriteria(Operator.EQUAL, (Object[])updateTime));
    }

    public PromotionRequest<T> withUpdateTime(Operator operator, Object... values){
       return appendSearchCriteria(createUpdateTimeCriteria(operator, values));
    }

    public PromotionRequest<T> withUpdateTimeIsUnknown(){
       return withUpdateTime(Operator.IS_NULL);
    }

    public PromotionRequest<T> withUpdateTimeIsKnown(){
       return withUpdateTime(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createUpdateTimeCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Promotion.UPDATE_TIME_PROPERTY, operator, values);
    }

    public PromotionRequest<T> withUpdateTimeGreaterThan(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public PromotionRequest<T> withUpdateTimeGreaterThanOrEqualTo(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN_OR_EQUAL, updateTime);
    }

    public PromotionRequest<T> withUpdateTimeLessThan(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public PromotionRequest<T> withUpdateTimeLessThanOrEqualTo(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN_OR_EQUAL, updateTime);
    }

    public PromotionRequest<T> withUpdateTimeBetween(LocalDateTime startOfUpdateTime, LocalDateTime endOfUpdateTime){
       return withUpdateTime(Operator.BETWEEN, startOfUpdateTime, endOfUpdateTime);
    }
    public PromotionRequest<T> withUpdateTimeBefore(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public PromotionRequest<T> withUpdateTimeBefore(Date updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public PromotionRequest<T> withUpdateTimeAfter(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public PromotionRequest<T> withUpdateTimeAfter(Date updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public PromotionRequest<T> withUpdateTimeBetween(Date startOfUpdateTime, Date endOfUpdateTime){
       return withUpdateTime(Operator.BETWEEN, startOfUpdateTime, endOfUpdateTime);
    }




    public PromotionRequest<T> filterByVersion(Long... version){
      if (version == null || version.length == 0) {
        throw new IllegalArgumentException("filterByVersion parameter version cannot be empty");
      }
      return appendSearchCriteria(createVersionCriteria(Operator.EQUAL, (Object[])version));
    }

    public PromotionRequest<T> withVersion(Operator operator, Object... values){
       return appendSearchCriteria(createVersionCriteria(operator, values));
    }

    public PromotionRequest<T> withVersionIsUnknown(){
       return withVersion(Operator.IS_NULL);
    }

    public PromotionRequest<T> withVersionIsKnown(){
       return withVersion(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createVersionCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Promotion.VERSION_PROPERTY, operator, values);
    }

    public PromotionRequest<T> withVersionGreaterThan(Long version){
       return withVersion(Operator.GREATER_THAN, version);
    }

    public PromotionRequest<T> withVersionGreaterThanOrEqualTo(Long version){
       return withVersion(Operator.GREATER_THAN_OR_EQUAL, version);
    }

    public PromotionRequest<T> withVersionLessThan(Long version){
       return withVersion(Operator.LESS_THAN, version);
    }

    public PromotionRequest<T> withVersionLessThanOrEqualTo(Long version){
       return withVersion(Operator.LESS_THAN_OR_EQUAL, version);
    }

    public PromotionRequest<T> withVersionBetween(Long startOfVersion, Long endOfVersion){
       return withVersion(Operator.BETWEEN, startOfVersion, endOfVersion);
    }

    public PromotionRequest<T> withCouponListMatching(CouponRequest couponRequest){
        return appendSearchCriteria(new SubQuerySearchCriteria(Promotion.ID_PROPERTY, couponRequest, Coupon.PROMOTION_PROPERTY));
    }

    public PromotionRequest<T> withoutCouponListMatching(CouponRequest couponRequest){
        return appendSearchCriteria(SearchCriteria.not(new SubQuerySearchCriteria(Promotion.ID_PROPERTY, couponRequest, Coupon.PROMOTION_PROPERTY)));
    }

    public PromotionRequest<T> haveCoupons(){
        return withCouponListMatching(Q.coupons().unlimited());
    }

    public PromotionRequest<T> haveNoCoupons(){
        return withoutCouponListMatching(Q.coupons().unlimited());
    }

    public PromotionRequest<T> count(){
        super.count();
        return this;
    }
    public PromotionRequest<T> countAs(String retName){
        super.count(retName);
        return this;
    }
    public PromotionRequest minDiscountPercentage(){
        return minDiscountPercentageAs(prefix("minOf",Promotion.DISCOUNT_PERCENTAGE_PROPERTY));
    }

    public PromotionRequest minDiscountPercentageAs(String retName){
        super.min(retName, Promotion.DISCOUNT_PERCENTAGE_PROPERTY);
        return this;
    }
    public PromotionRequest maxDiscountPercentage(){
        return maxDiscountPercentageAs(prefix("maxOf",Promotion.DISCOUNT_PERCENTAGE_PROPERTY));
    }

    public PromotionRequest maxDiscountPercentageAs(String retName){
        super.max(retName, Promotion.DISCOUNT_PERCENTAGE_PROPERTY);
        return this;
    }
    public PromotionRequest sumDiscountPercentage(){
        return sumDiscountPercentageAs(prefix("sumOf",Promotion.DISCOUNT_PERCENTAGE_PROPERTY));
    }

    public PromotionRequest sumDiscountPercentageAs(String retName){
        super.sum(retName, Promotion.DISCOUNT_PERCENTAGE_PROPERTY);
        return this;
    }
    public PromotionRequest avgDiscountPercentage(){
        return avgDiscountPercentageAs(prefix("avgOf",Promotion.DISCOUNT_PERCENTAGE_PROPERTY));
    }

    public PromotionRequest avgDiscountPercentageAs(String retName){
        super.avg(retName, Promotion.DISCOUNT_PERCENTAGE_PROPERTY);
        return this;
    }
    public PromotionRequest standardDeviationDiscountPercentage(){
        return standardDeviationDiscountPercentageAs(prefix("standardDeviationOf",Promotion.DISCOUNT_PERCENTAGE_PROPERTY));
    }

    public PromotionRequest standardDeviationDiscountPercentageAs(String retName){
        super.standardDeviation(retName, Promotion.DISCOUNT_PERCENTAGE_PROPERTY);
        return this;
    }
    public PromotionRequest squareRootOfPopulationStandardDeviationDiscountPercentage(){
        return squareRootOfPopulationStandardDeviationDiscountPercentageAs(prefix("squareRootOfPopulationStandardDeviationOf",Promotion.DISCOUNT_PERCENTAGE_PROPERTY));
    }

    public PromotionRequest squareRootOfPopulationStandardDeviationDiscountPercentageAs(String retName){
        super.squareRootOfPopulationStandardDeviation(retName, Promotion.DISCOUNT_PERCENTAGE_PROPERTY);
        return this;
    }
    public PromotionRequest sampleVarianceDiscountPercentage(){
        return sampleVarianceDiscountPercentageAs(prefix("sampleVarianceOf",Promotion.DISCOUNT_PERCENTAGE_PROPERTY));
    }

    public PromotionRequest sampleVarianceDiscountPercentageAs(String retName){
        super.sampleVariance(retName, Promotion.DISCOUNT_PERCENTAGE_PROPERTY);
        return this;
    }
    public PromotionRequest samplePopulationVarianceDiscountPercentage(){
        return samplePopulationVarianceDiscountPercentageAs(prefix("samplePopulationVarianceOf",Promotion.DISCOUNT_PERCENTAGE_PROPERTY));
    }

    public PromotionRequest samplePopulationVarianceDiscountPercentageAs(String retName){
        super.samplePopulationVariance(retName, Promotion.DISCOUNT_PERCENTAGE_PROPERTY);
        return this;
    }
    public PromotionRequest<T> groupByCouponsWithDetails(CouponRequest subRequest){
       aggregate(Promotion.COUPON_LIST_PROPERTY, subRequest);
       return this;
    }

    public PromotionRequest<T> groupById(){
       groupBy(Promotion.ID_PROPERTY);
       return this;
    }

    public PromotionRequest<T> groupByIdAs(String retName){
       groupBy(retName, Promotion.ID_PROPERTY);
       return this;
    }

    public PromotionRequest<T> groupByIdWithFunction(String retName, AggrFunction function){
       groupBy(retName, Promotion.ID_PROPERTY, function);
       return this;
    }

    public PromotionRequest<T> groupByName(){
       groupBy(Promotion.NAME_PROPERTY);
       return this;
    }

    public PromotionRequest<T> groupByNameAs(String retName){
       groupBy(retName, Promotion.NAME_PROPERTY);
       return this;
    }

    public PromotionRequest<T> groupByNameWithFunction(String retName, AggrFunction function){
       groupBy(retName, Promotion.NAME_PROPERTY, function);
       return this;
    }

    public PromotionRequest<T> groupByDiscountPercentage(){
       groupBy(Promotion.DISCOUNT_PERCENTAGE_PROPERTY);
       return this;
    }

    public PromotionRequest<T> groupByDiscountPercentageAs(String retName){
       groupBy(retName, Promotion.DISCOUNT_PERCENTAGE_PROPERTY);
       return this;
    }

    public PromotionRequest<T> groupByDiscountPercentageWithFunction(String retName, AggrFunction function){
       groupBy(retName, Promotion.DISCOUNT_PERCENTAGE_PROPERTY, function);
       return this;
    }

    public PromotionRequest<T> groupByEndDate(){
       groupBy(Promotion.END_DATE_PROPERTY);
       return this;
    }

    public PromotionRequest<T> groupByEndDateAs(String retName){
       groupBy(retName, Promotion.END_DATE_PROPERTY);
       return this;
    }

    public PromotionRequest<T> groupByEndDateWithFunction(String retName, AggrFunction function){
       groupBy(retName, Promotion.END_DATE_PROPERTY, function);
       return this;
    }

    public PromotionRequest<T> groupByStartDate(){
       groupBy(Promotion.START_DATE_PROPERTY);
       return this;
    }

    public PromotionRequest<T> groupByStartDateAs(String retName){
       groupBy(retName, Promotion.START_DATE_PROPERTY);
       return this;
    }

    public PromotionRequest<T> groupByStartDateWithFunction(String retName, AggrFunction function){
       groupBy(retName, Promotion.START_DATE_PROPERTY, function);
       return this;
    }

    public PromotionRequest<T> groupByCreateTime(){
       groupBy(Promotion.CREATE_TIME_PROPERTY);
       return this;
    }

    public PromotionRequest<T> groupByCreateTimeAs(String retName){
       groupBy(retName, Promotion.CREATE_TIME_PROPERTY);
       return this;
    }

    public PromotionRequest<T> groupByCreateTimeWithFunction(String retName, AggrFunction function){
       groupBy(retName, Promotion.CREATE_TIME_PROPERTY, function);
       return this;
    }

    public PromotionRequest<T> groupByUpdateTime(){
       groupBy(Promotion.UPDATE_TIME_PROPERTY);
       return this;
    }

    public PromotionRequest<T> groupByUpdateTimeAs(String retName){
       groupBy(retName, Promotion.UPDATE_TIME_PROPERTY);
       return this;
    }

    public PromotionRequest<T> groupByUpdateTimeWithFunction(String retName, AggrFunction function){
       groupBy(retName, Promotion.UPDATE_TIME_PROPERTY, function);
       return this;
    }

    public PromotionRequest<T> groupByVersion(){
       groupBy(Promotion.VERSION_PROPERTY);
       return this;
    }

    public PromotionRequest<T> groupByVersionAs(String retName){
       groupBy(retName, Promotion.VERSION_PROPERTY);
       return this;
    }

    public PromotionRequest<T> groupByVersionWithFunction(String retName, AggrFunction function){
       groupBy(retName, Promotion.VERSION_PROPERTY, function);
       return this;
    }



    public PromotionRequest<T> orderByIdAscending(){
       addOrderByAscending(Promotion.ID_PROPERTY);
       return this;
    }

    public PromotionRequest<T> orderByIdDescending(){
       addOrderByDescending(Promotion.ID_PROPERTY);
       return this;
    }

    public PromotionRequest<T> orderByNameAscending(){
       addOrderByAscending(Promotion.NAME_PROPERTY);
       return this;
    }

    public PromotionRequest<T> orderByNameDescending(){
       addOrderByDescending(Promotion.NAME_PROPERTY);
       return this;
    }
    public PromotionRequest<T> orderByNameAscendingUsingGBK(){
       addOrderByAscendingUsingGBK(Promotion.NAME_PROPERTY);
       return this;
    }

    public PromotionRequest<T> orderByNameDescendingUsingGBK(){
       addOrderByDescendingUsingGBK(Promotion.NAME_PROPERTY);
       return this;
    }
    public PromotionRequest<T> orderByDiscountPercentageAscending(){
       addOrderByAscending(Promotion.DISCOUNT_PERCENTAGE_PROPERTY);
       return this;
    }

    public PromotionRequest<T> orderByDiscountPercentageDescending(){
       addOrderByDescending(Promotion.DISCOUNT_PERCENTAGE_PROPERTY);
       return this;
    }

    public PromotionRequest<T> orderByEndDateAscending(){
       addOrderByAscending(Promotion.END_DATE_PROPERTY);
       return this;
    }

    public PromotionRequest<T> orderByEndDateDescending(){
       addOrderByDescending(Promotion.END_DATE_PROPERTY);
       return this;
    }

    public PromotionRequest<T> orderByStartDateAscending(){
       addOrderByAscending(Promotion.START_DATE_PROPERTY);
       return this;
    }

    public PromotionRequest<T> orderByStartDateDescending(){
       addOrderByDescending(Promotion.START_DATE_PROPERTY);
       return this;
    }

    public PromotionRequest<T> orderByCreateTimeAscending(){
       addOrderByAscending(Promotion.CREATE_TIME_PROPERTY);
       return this;
    }

    public PromotionRequest<T> orderByCreateTimeDescending(){
       addOrderByDescending(Promotion.CREATE_TIME_PROPERTY);
       return this;
    }

    public PromotionRequest<T> orderByUpdateTimeAscending(){
       addOrderByAscending(Promotion.UPDATE_TIME_PROPERTY);
       return this;
    }

    public PromotionRequest<T> orderByUpdateTimeDescending(){
       addOrderByDescending(Promotion.UPDATE_TIME_PROPERTY);
       return this;
    }

    public PromotionRequest<T> orderByVersionAscending(){
       addOrderByAscending(Promotion.VERSION_PROPERTY);
       return this;
    }

    public PromotionRequest<T> orderByVersionDescending(){
       addOrderByDescending(Promotion.VERSION_PROPERTY);
       return this;
    }


    public PromotionRequest<T> statsFromCouponsAs(String name, CouponRequest subRequest){
       return statsFromCouponsAs(name, subRequest, false);
    }

    public PromotionRequest<T> statsFromCouponsAs(String name, CouponRequest subRequest, boolean singleResult){
       subRequest.setPartitionProperty(Coupon.PROMOTION_PROPERTY);
       addAggregateDynamicProperty(name, subRequest, singleResult);
       return this;
    }

    public PromotionRequest<T> statsFromCoupons(CouponRequest subRequest){
       return statsFromCouponsAs(REFINEMENTS, subRequest);
    }
    public PromotionRequest<T> countCoupons(){
        return countCouponsAs("Count");
    }

    public PromotionRequest<T> countCouponsAs(String name){
        return countCouponsWith(name, Q.coupons().unlimited());
    }

    public PromotionRequest<T> countCouponsWith(String name, CouponRequest subRequest){
        return statsFromCouponsAs(name, subRequest.count(), true);
    }
    public PromotionRequest<T> minTimesUsedOfCoupons(){
        return minTimesUsedOfCouponsAs("minTimesUsedOfCoupons");
    }

    public PromotionRequest<T> minTimesUsedOfCouponsAs(String name){
        return minTimesUsedOfCouponsAs(name, Q.coupons().unlimited());
    }

    public PromotionRequest<T> minTimesUsedOfCouponsAs(String name, CouponRequest subRequest){
        return statsFromCouponsAs(name, subRequest.minTimesUsed(), true);
    }
    public PromotionRequest<T> maxTimesUsedOfCoupons(){
        return maxTimesUsedOfCouponsAs("maxTimesUsedOfCoupons");
    }

    public PromotionRequest<T> maxTimesUsedOfCouponsAs(String name){
        return maxTimesUsedOfCouponsAs(name, Q.coupons().unlimited());
    }

    public PromotionRequest<T> maxTimesUsedOfCouponsAs(String name, CouponRequest subRequest){
        return statsFromCouponsAs(name, subRequest.maxTimesUsed(), true);
    }
    public PromotionRequest<T> sumTimesUsedOfCoupons(){
        return sumTimesUsedOfCouponsAs("sumTimesUsedOfCoupons");
    }

    public PromotionRequest<T> sumTimesUsedOfCouponsAs(String name){
        return sumTimesUsedOfCouponsAs(name, Q.coupons().unlimited());
    }

    public PromotionRequest<T> sumTimesUsedOfCouponsAs(String name, CouponRequest subRequest){
        return statsFromCouponsAs(name, subRequest.sumTimesUsed(), true);
    }
    public PromotionRequest<T> avgTimesUsedOfCoupons(){
        return avgTimesUsedOfCouponsAs("avgTimesUsedOfCoupons");
    }

    public PromotionRequest<T> avgTimesUsedOfCouponsAs(String name){
        return avgTimesUsedOfCouponsAs(name, Q.coupons().unlimited());
    }

    public PromotionRequest<T> avgTimesUsedOfCouponsAs(String name, CouponRequest subRequest){
        return statsFromCouponsAs(name, subRequest.avgTimesUsed(), true);
    }
    public PromotionRequest<T> standardDeviationTimesUsedOfCoupons(){
        return standardDeviationTimesUsedOfCouponsAs("stdDevTimesUsedOfCoupons");
    }

    public PromotionRequest<T> standardDeviationTimesUsedOfCouponsAs(String name){
        return standardDeviationTimesUsedOfCouponsAs(name, Q.coupons().unlimited());
    }

    public PromotionRequest<T> standardDeviationTimesUsedOfCouponsAs(String name, CouponRequest subRequest){
        return statsFromCouponsAs(name, subRequest.standardDeviationTimesUsed(), true);
    }
    public PromotionRequest<T> squareRootOfPopulationStandardDeviationTimesUsedOfCoupons(){
        return squareRootOfPopulationStandardDeviationTimesUsedOfCouponsAs("stdDevPopTimesUsedOfCoupons");
    }

    public PromotionRequest<T> squareRootOfPopulationStandardDeviationTimesUsedOfCouponsAs(String name){
        return squareRootOfPopulationStandardDeviationTimesUsedOfCouponsAs(name, Q.coupons().unlimited());
    }

    public PromotionRequest<T> squareRootOfPopulationStandardDeviationTimesUsedOfCouponsAs(String name, CouponRequest subRequest){
        return statsFromCouponsAs(name, subRequest.squareRootOfPopulationStandardDeviationTimesUsed(), true);
    }
    public PromotionRequest<T> sampleVarianceTimesUsedOfCoupons(){
        return sampleVarianceTimesUsedOfCouponsAs("varSampTimesUsedOfCoupons");
    }

    public PromotionRequest<T> sampleVarianceTimesUsedOfCouponsAs(String name){
        return sampleVarianceTimesUsedOfCouponsAs(name, Q.coupons().unlimited());
    }

    public PromotionRequest<T> sampleVarianceTimesUsedOfCouponsAs(String name, CouponRequest subRequest){
        return statsFromCouponsAs(name, subRequest.sampleVarianceTimesUsed(), true);
    }
    public PromotionRequest<T> samplePopulationVarianceTimesUsedOfCoupons(){
        return samplePopulationVarianceTimesUsedOfCouponsAs("varPopTimesUsedOfCoupons");
    }

    public PromotionRequest<T> samplePopulationVarianceTimesUsedOfCouponsAs(String name){
        return samplePopulationVarianceTimesUsedOfCouponsAs(name, Q.coupons().unlimited());
    }

    public PromotionRequest<T> samplePopulationVarianceTimesUsedOfCouponsAs(String name, CouponRequest subRequest){
        return statsFromCouponsAs(name, subRequest.samplePopulationVarianceTimesUsed(), true);
    }
    public PromotionRequest<T> minUsageLimitOfCoupons(){
        return minUsageLimitOfCouponsAs("minUsageLimitOfCoupons");
    }

    public PromotionRequest<T> minUsageLimitOfCouponsAs(String name){
        return minUsageLimitOfCouponsAs(name, Q.coupons().unlimited());
    }

    public PromotionRequest<T> minUsageLimitOfCouponsAs(String name, CouponRequest subRequest){
        return statsFromCouponsAs(name, subRequest.minUsageLimit(), true);
    }
    public PromotionRequest<T> maxUsageLimitOfCoupons(){
        return maxUsageLimitOfCouponsAs("maxUsageLimitOfCoupons");
    }

    public PromotionRequest<T> maxUsageLimitOfCouponsAs(String name){
        return maxUsageLimitOfCouponsAs(name, Q.coupons().unlimited());
    }

    public PromotionRequest<T> maxUsageLimitOfCouponsAs(String name, CouponRequest subRequest){
        return statsFromCouponsAs(name, subRequest.maxUsageLimit(), true);
    }
    public PromotionRequest<T> sumUsageLimitOfCoupons(){
        return sumUsageLimitOfCouponsAs("sumUsageLimitOfCoupons");
    }

    public PromotionRequest<T> sumUsageLimitOfCouponsAs(String name){
        return sumUsageLimitOfCouponsAs(name, Q.coupons().unlimited());
    }

    public PromotionRequest<T> sumUsageLimitOfCouponsAs(String name, CouponRequest subRequest){
        return statsFromCouponsAs(name, subRequest.sumUsageLimit(), true);
    }
    public PromotionRequest<T> avgUsageLimitOfCoupons(){
        return avgUsageLimitOfCouponsAs("avgUsageLimitOfCoupons");
    }

    public PromotionRequest<T> avgUsageLimitOfCouponsAs(String name){
        return avgUsageLimitOfCouponsAs(name, Q.coupons().unlimited());
    }

    public PromotionRequest<T> avgUsageLimitOfCouponsAs(String name, CouponRequest subRequest){
        return statsFromCouponsAs(name, subRequest.avgUsageLimit(), true);
    }
    public PromotionRequest<T> standardDeviationUsageLimitOfCoupons(){
        return standardDeviationUsageLimitOfCouponsAs("stdDevUsageLimitOfCoupons");
    }

    public PromotionRequest<T> standardDeviationUsageLimitOfCouponsAs(String name){
        return standardDeviationUsageLimitOfCouponsAs(name, Q.coupons().unlimited());
    }

    public PromotionRequest<T> standardDeviationUsageLimitOfCouponsAs(String name, CouponRequest subRequest){
        return statsFromCouponsAs(name, subRequest.standardDeviationUsageLimit(), true);
    }
    public PromotionRequest<T> squareRootOfPopulationStandardDeviationUsageLimitOfCoupons(){
        return squareRootOfPopulationStandardDeviationUsageLimitOfCouponsAs("stdDevPopUsageLimitOfCoupons");
    }

    public PromotionRequest<T> squareRootOfPopulationStandardDeviationUsageLimitOfCouponsAs(String name){
        return squareRootOfPopulationStandardDeviationUsageLimitOfCouponsAs(name, Q.coupons().unlimited());
    }

    public PromotionRequest<T> squareRootOfPopulationStandardDeviationUsageLimitOfCouponsAs(String name, CouponRequest subRequest){
        return statsFromCouponsAs(name, subRequest.squareRootOfPopulationStandardDeviationUsageLimit(), true);
    }
    public PromotionRequest<T> sampleVarianceUsageLimitOfCoupons(){
        return sampleVarianceUsageLimitOfCouponsAs("varSampUsageLimitOfCoupons");
    }

    public PromotionRequest<T> sampleVarianceUsageLimitOfCouponsAs(String name){
        return sampleVarianceUsageLimitOfCouponsAs(name, Q.coupons().unlimited());
    }

    public PromotionRequest<T> sampleVarianceUsageLimitOfCouponsAs(String name, CouponRequest subRequest){
        return statsFromCouponsAs(name, subRequest.sampleVarianceUsageLimit(), true);
    }
    public PromotionRequest<T> samplePopulationVarianceUsageLimitOfCoupons(){
        return samplePopulationVarianceUsageLimitOfCouponsAs("varPopUsageLimitOfCoupons");
    }

    public PromotionRequest<T> samplePopulationVarianceUsageLimitOfCouponsAs(String name){
        return samplePopulationVarianceUsageLimitOfCouponsAs(name, Q.coupons().unlimited());
    }

    public PromotionRequest<T> samplePopulationVarianceUsageLimitOfCouponsAs(String name, CouponRequest subRequest){
        return statsFromCouponsAs(name, subRequest.samplePopulationVarianceUsageLimit(), true);
    }



    /**
     * get topN records
     * @param topN  records number
     */
    public PromotionRequest<T> top(int topN) {
        super.top(topN);
        return this;
    }

    /**
     * get records from offset(inclusive) to offset+size(exclusive)
     * @param offset record offset
     * @param size records number
     */
    public PromotionRequest<T> offset(int offset, int size) {
        super.offset(offset, size);
        return this;
    }

    /**
     * retrieve all records
     */
    public PromotionRequest<T> unlimited() {
        super.unlimited();
        return this;
    }

    /**
     * get records of one page
     * @param pageNumber page number(1-based)
     * @param pageSize page size
     */
    public PromotionRequest<T> page(int pageNumber, int pageSize) {
        int offset = (pageNumber - 1) * pageSize;
        return offset(offset, pageSize);
   }

    /**
     * get records of one page, default page size is 10
     * @param pageNumber page number(1-based)
     */
    public PromotionRequest<T> page(int pageNumber) {
        return page(pageNumber, 10);
   }
}