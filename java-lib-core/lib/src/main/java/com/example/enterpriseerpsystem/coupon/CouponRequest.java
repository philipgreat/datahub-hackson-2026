
package com.example.enterpriseerpsystem.coupon;

import com.example.enterpriseerpsystem.Q;
import com.example.enterpriseerpsystem.promotion.Promotion;
import com.example.enterpriseerpsystem.promotion.PromotionRequest;
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

public class CouponRequest<T extends Coupon> extends BaseRequest<T> {

    /**
     * @deprecated AI agents and business code must use the generated Q facade
     *             instead of constructing request builders directly.
     */
    @Deprecated
    public CouponRequest(Class<T> returnType){
        super(returnType);
        selectId();
        selectVersion();
    }

    public CouponRequest<T> comment(String comment){
         super.internalComment(comment);
         return this;
    }

    // purpose() 继承自 BaseRequest，返回 ExecutableRequest（终结方法）

    public CouponRequest<T> returnType(Class<? extends T> returnType){
        super.setReturnType(returnType);
        return this;
    }

    public CouponRequest<T> enableAggregationCache(long cacheExpiredMillis){
        super.enableAggregationCache();
        super.aggregateCacheTime(cacheExpiredMillis);
        return this;
    }

    public CouponRequest<T> enableAggregationCache(){
        return enableAggregationCache(0l);
    }


    public CouponRequest<T> propagateAggregationCache(long cacheExpiredMillis){
        super.propagateAggregationCache(cacheExpiredMillis);
        return this;
    }

    public CouponRequest<T> appendSearchCriteria(SearchCriteria searchCriteria){
        return (CouponRequest<T>)super.appendSearchCriteria(searchCriteria);
    }

    public CouponRequest<T> filter(String property1, Operator operator, String property2){
        return appendSearchCriteria(new TwoOperatorCriteria(operator, new PropertyReference(property1), new PropertyReference(property2)));
    }


    public CouponRequest<T> matchingAnyOf(CouponRequest coupon){
        super.internalMatchAny(coupon);
        return this;
    }

    public CouponRequest<T> enhanceChildrenIfNeeded(){
        return this;
    }

    public CouponRequest<T> withDeletedRows(){
        super.withDeletedRows();
        return this;
    }

    public CouponRequest<T> deletedRowsOnly(){
        super.deletedRowsOnly();
        return this;
    }

    public CouponRequest<T> selectSelf(){
        super.selectSelf();
        return selectId().selectCode().selectPromotionIdOnly().selectTimesUsed().selectUsageLimit().selectCreateTime().selectUpdateTime().selectVersion();
    }

    public CouponRequest<T> selectSelfFields(){
        return selectSelf();
    }

    public CouponRequest<T> selectAll(){
        super.selectAll();
        return selectId().selectCode().selectPromotion().selectTimesUsed().selectUsageLimit().selectCreateTime().selectUpdateTime().selectVersion();
    }

    public CouponRequest<T> selectChildren(){
        super.selectAny();
        return selectId().selectCode().selectPromotion().selectTimesUsed().selectUsageLimit().selectCreateTime().selectUpdateTime().selectVersion();
    }


    public CouponRequest<T> selectId(){
       selectProperty(Coupon.ID_PROPERTY);
       return this;
    }

    /**
     * fill the id with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  id) to fetch id property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public CouponRequest<T> unselectId(){
       unselectProperty(Coupon.ID_PROPERTY);
       return this;
    }
    public CouponRequest<T> selectCode(){
       selectProperty(Coupon.CODE_PROPERTY);
       return this;
    }

    /**
     * fill the code with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  code) to fetch code property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public CouponRequest<T> unselectCode(){
       unselectProperty(Coupon.CODE_PROPERTY);
       return this;
    }
    public CouponRequest<T> selectPromotionIdOnly(){
       selectProperty(Coupon.PROMOTION_PROPERTY);
       return this;
    }

    public CouponRequest<T> selectPromotion(){
        return selectPromotionWith(Q.promotions().unlimited().selectSelf());
    }

    public CouponRequest<T> selectPromotionWith(PromotionRequest promotion){
       selectProperty(Coupon.PROMOTION_PROPERTY);
       enhanceRelation(Coupon.PROMOTION_PROPERTY, promotion);
       return this;
    }

    public CouponRequest<T> unselectPromotion(){
       unselectProperty(Coupon.PROMOTION_PROPERTY);
       return this;
    }
    public CouponRequest<T> selectTimesUsed(){
       selectProperty(Coupon.TIMES_USED_PROPERTY);
       return this;
    }

    /**
     * fill the timesUsed with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  timesUsed) to fetch timesUsed property.
     * @param rawSqlSegment  customized rawSqlSegment
     */


    /**
     * fill the timesUsed with customized aggrFunction, TEAQL uses ({aggrFunction}(timesUsed) AS timesUsed to fetch timesUsed property.
     * @param aggrFunction  aggrFunction
     */
    public CouponRequest<T> selectTimesUsed(AggrFunction aggrFunction){
       selectProperty(Coupon.TIMES_USED_PROPERTY, aggrFunction);
       return this;
    }


    public CouponRequest<T> unselectTimesUsed(){
       unselectProperty(Coupon.TIMES_USED_PROPERTY);
       return this;
    }
    public CouponRequest<T> selectUsageLimit(){
       selectProperty(Coupon.USAGE_LIMIT_PROPERTY);
       return this;
    }

    /**
     * fill the usageLimit with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  usageLimit) to fetch usageLimit property.
     * @param rawSqlSegment  customized rawSqlSegment
     */


    /**
     * fill the usageLimit with customized aggrFunction, TEAQL uses ({aggrFunction}(usageLimit) AS usageLimit to fetch usageLimit property.
     * @param aggrFunction  aggrFunction
     */
    public CouponRequest<T> selectUsageLimit(AggrFunction aggrFunction){
       selectProperty(Coupon.USAGE_LIMIT_PROPERTY, aggrFunction);
       return this;
    }


    public CouponRequest<T> unselectUsageLimit(){
       unselectProperty(Coupon.USAGE_LIMIT_PROPERTY);
       return this;
    }
    public CouponRequest<T> selectCreateTime(){
       selectProperty(Coupon.CREATE_TIME_PROPERTY);
       return this;
    }

    /**
     * fill the createTime with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  createTime) to fetch createTime property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public CouponRequest<T> unselectCreateTime(){
       unselectProperty(Coupon.CREATE_TIME_PROPERTY);
       return this;
    }
    public CouponRequest<T> selectUpdateTime(){
       selectProperty(Coupon.UPDATE_TIME_PROPERTY);
       return this;
    }

    /**
     * fill the updateTime with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  updateTime) to fetch updateTime property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public CouponRequest<T> unselectUpdateTime(){
       unselectProperty(Coupon.UPDATE_TIME_PROPERTY);
       return this;
    }
    public CouponRequest<T> selectVersion(){
       selectProperty(Coupon.VERSION_PROPERTY);
       return this;
    }

    /**
     * fill the version with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  version) to fetch version property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public CouponRequest<T> unselectVersion(){
       unselectProperty(Coupon.VERSION_PROPERTY);
       return this;
    }

    public CouponRequest<T> withId(Operator operator, Object... values){
       return appendSearchCriteria(createIdCriteria(operator, values));
    }

    public SearchCriteria createIdCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Coupon.ID_PROPERTY, operator, values);
    }

    public CouponRequest<T> withIdIs(Long id){
       return withId(Operator.EQUAL, id);
    }
    public CouponRequest<T> withIdIn(Long... id){
       return withId(Operator.EQUAL, (Object[])id);
    }



    public CouponRequest<T> filterByCode(String... code){
      if (code == null || code.length == 0) {
        throw new IllegalArgumentException("filterByCode parameter code cannot be empty");
      }
      return appendSearchCriteria(createCodeCriteria(Operator.EQUAL, (Object[])code));
    }

    public CouponRequest<T> withCode(Operator operator, Object... values){
       return appendSearchCriteria(createCodeCriteria(operator, values));
    }

    public CouponRequest<T> withCodeIsUnknown(){
       return withCode(Operator.IS_NULL);
    }

    public CouponRequest<T> withCodeIsKnown(){
       return withCode(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createCodeCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Coupon.CODE_PROPERTY, operator, values);
    }

    public CouponRequest<T> withCodeGreaterThan(String code){
       return withCode(Operator.GREATER_THAN, code);
    }

    public CouponRequest<T> withCodeGreaterThanOrEqualTo(String code){
       return withCode(Operator.GREATER_THAN_OR_EQUAL, code);
    }

    public CouponRequest<T> withCodeLessThan(String code){
       return withCode(Operator.LESS_THAN, code);
    }

    public CouponRequest<T> withCodeLessThanOrEqualTo(String code){
       return withCode(Operator.LESS_THAN_OR_EQUAL, code);
    }

    public CouponRequest<T> withCodeBetween(String startOfCode, String endOfCode){
       return withCode(Operator.BETWEEN, startOfCode, endOfCode);
    }
    public CouponRequest<T> withCodeStartingWith(String code){
       return withCode(Operator.BEGIN_WITH, code);
    }
    public CouponRequest<T> withCodeContaining(String code){
       return withCode(Operator.CONTAIN, code);
    }

    public CouponRequest<T> withCodeEndingWith(String code){
       return withCode(Operator.END_WITH, code);
    }

    public CouponRequest<T> withCodeIs(String code){
       return withCode(Operator.EQUAL, code);
    }

    public CouponRequest<T> withCodeSoundingLike(String code){
       return withCode(Operator.SOUNDS_LIKE, code);
    }



    public CouponRequest<T> filterByPromotion(Promotion... promotion){
      if (promotion == null || promotion.length == 0) {
        throw new IllegalArgumentException("filterByPromotion parameter promotion cannot be empty");
      }
      return appendSearchCriteria(createPromotionCriteria(Operator.EQUAL, (Object[])promotion));
    }

    public CouponRequest<T> withPromotion(Operator operator, Object... values){
       return appendSearchCriteria(createPromotionCriteria(operator, values));
    }

    public CouponRequest<T> withPromotionIsUnknown(){
       return withPromotion(Operator.IS_NULL);
    }

    public CouponRequest<T> withPromotionIsKnown(){
       return withPromotion(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createPromotionCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Coupon.PROMOTION_PROPERTY, operator, values);
    }

    public CouponRequest<T> filterByPromotion(Long promotion){
      if(promotion == null){
         return this;
      }
      return withPromotion(Operator.EQUAL, promotion);
    }
    public CouponRequest<T> withPromotionMatching(PromotionRequest promotion){
       return appendSearchCriteria(new SubQuerySearchCriteria(Coupon.PROMOTION_PROPERTY, promotion, Promotion.ID_PROPERTY));
    }

    public CouponRequest<T> filterByTimesUsed(BigDecimal... timesUsed){
      if (timesUsed == null || timesUsed.length == 0) {
        throw new IllegalArgumentException("filterByTimesUsed parameter timesUsed cannot be empty");
      }
      return appendSearchCriteria(createTimesUsedCriteria(Operator.EQUAL, (Object[])timesUsed));
    }

    public CouponRequest<T> withTimesUsed(Operator operator, Object... values){
       return appendSearchCriteria(createTimesUsedCriteria(operator, values));
    }

    public CouponRequest<T> withTimesUsedIsUnknown(){
       return withTimesUsed(Operator.IS_NULL);
    }

    public CouponRequest<T> withTimesUsedIsKnown(){
       return withTimesUsed(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createTimesUsedCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Coupon.TIMES_USED_PROPERTY, operator, values);
    }

    public CouponRequest<T> withTimesUsedGreaterThan(BigDecimal timesUsed){
       return withTimesUsed(Operator.GREATER_THAN, timesUsed);
    }

    public CouponRequest<T> withTimesUsedGreaterThanOrEqualTo(BigDecimal timesUsed){
       return withTimesUsed(Operator.GREATER_THAN_OR_EQUAL, timesUsed);
    }

    public CouponRequest<T> withTimesUsedLessThan(BigDecimal timesUsed){
       return withTimesUsed(Operator.LESS_THAN, timesUsed);
    }

    public CouponRequest<T> withTimesUsedLessThanOrEqualTo(BigDecimal timesUsed){
       return withTimesUsed(Operator.LESS_THAN_OR_EQUAL, timesUsed);
    }

    public CouponRequest<T> withTimesUsedBetween(BigDecimal startOfTimesUsed, BigDecimal endOfTimesUsed){
       return withTimesUsed(Operator.BETWEEN, startOfTimesUsed, endOfTimesUsed);
    }



    public CouponRequest<T> filterByUsageLimit(BigDecimal... usageLimit){
      if (usageLimit == null || usageLimit.length == 0) {
        throw new IllegalArgumentException("filterByUsageLimit parameter usageLimit cannot be empty");
      }
      return appendSearchCriteria(createUsageLimitCriteria(Operator.EQUAL, (Object[])usageLimit));
    }

    public CouponRequest<T> withUsageLimit(Operator operator, Object... values){
       return appendSearchCriteria(createUsageLimitCriteria(operator, values));
    }

    public CouponRequest<T> withUsageLimitIsUnknown(){
       return withUsageLimit(Operator.IS_NULL);
    }

    public CouponRequest<T> withUsageLimitIsKnown(){
       return withUsageLimit(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createUsageLimitCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Coupon.USAGE_LIMIT_PROPERTY, operator, values);
    }

    public CouponRequest<T> withUsageLimitGreaterThan(BigDecimal usageLimit){
       return withUsageLimit(Operator.GREATER_THAN, usageLimit);
    }

    public CouponRequest<T> withUsageLimitGreaterThanOrEqualTo(BigDecimal usageLimit){
       return withUsageLimit(Operator.GREATER_THAN_OR_EQUAL, usageLimit);
    }

    public CouponRequest<T> withUsageLimitLessThan(BigDecimal usageLimit){
       return withUsageLimit(Operator.LESS_THAN, usageLimit);
    }

    public CouponRequest<T> withUsageLimitLessThanOrEqualTo(BigDecimal usageLimit){
       return withUsageLimit(Operator.LESS_THAN_OR_EQUAL, usageLimit);
    }

    public CouponRequest<T> withUsageLimitBetween(BigDecimal startOfUsageLimit, BigDecimal endOfUsageLimit){
       return withUsageLimit(Operator.BETWEEN, startOfUsageLimit, endOfUsageLimit);
    }



    public CouponRequest<T> filterByCreateTime(LocalDateTime... createTime){
      if (createTime == null || createTime.length == 0) {
        throw new IllegalArgumentException("filterByCreateTime parameter createTime cannot be empty");
      }
      return appendSearchCriteria(createCreateTimeCriteria(Operator.EQUAL, (Object[])createTime));
    }

    public CouponRequest<T> withCreateTime(Operator operator, Object... values){
       return appendSearchCriteria(createCreateTimeCriteria(operator, values));
    }

    public CouponRequest<T> withCreateTimeIsUnknown(){
       return withCreateTime(Operator.IS_NULL);
    }

    public CouponRequest<T> withCreateTimeIsKnown(){
       return withCreateTime(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createCreateTimeCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Coupon.CREATE_TIME_PROPERTY, operator, values);
    }

    public CouponRequest<T> withCreateTimeGreaterThan(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public CouponRequest<T> withCreateTimeGreaterThanOrEqualTo(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN_OR_EQUAL, createTime);
    }

    public CouponRequest<T> withCreateTimeLessThan(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public CouponRequest<T> withCreateTimeLessThanOrEqualTo(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN_OR_EQUAL, createTime);
    }

    public CouponRequest<T> withCreateTimeBetween(LocalDateTime startOfCreateTime, LocalDateTime endOfCreateTime){
       return withCreateTime(Operator.BETWEEN, startOfCreateTime, endOfCreateTime);
    }
    public CouponRequest<T> withCreateTimeBefore(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public CouponRequest<T> withCreateTimeBefore(Date createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public CouponRequest<T> withCreateTimeAfter(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public CouponRequest<T> withCreateTimeAfter(Date createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public CouponRequest<T> withCreateTimeBetween(Date startOfCreateTime, Date endOfCreateTime){
       return withCreateTime(Operator.BETWEEN, startOfCreateTime, endOfCreateTime);
    }




    public CouponRequest<T> filterByUpdateTime(LocalDateTime... updateTime){
      if (updateTime == null || updateTime.length == 0) {
        throw new IllegalArgumentException("filterByUpdateTime parameter updateTime cannot be empty");
      }
      return appendSearchCriteria(createUpdateTimeCriteria(Operator.EQUAL, (Object[])updateTime));
    }

    public CouponRequest<T> withUpdateTime(Operator operator, Object... values){
       return appendSearchCriteria(createUpdateTimeCriteria(operator, values));
    }

    public CouponRequest<T> withUpdateTimeIsUnknown(){
       return withUpdateTime(Operator.IS_NULL);
    }

    public CouponRequest<T> withUpdateTimeIsKnown(){
       return withUpdateTime(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createUpdateTimeCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Coupon.UPDATE_TIME_PROPERTY, operator, values);
    }

    public CouponRequest<T> withUpdateTimeGreaterThan(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public CouponRequest<T> withUpdateTimeGreaterThanOrEqualTo(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN_OR_EQUAL, updateTime);
    }

    public CouponRequest<T> withUpdateTimeLessThan(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public CouponRequest<T> withUpdateTimeLessThanOrEqualTo(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN_OR_EQUAL, updateTime);
    }

    public CouponRequest<T> withUpdateTimeBetween(LocalDateTime startOfUpdateTime, LocalDateTime endOfUpdateTime){
       return withUpdateTime(Operator.BETWEEN, startOfUpdateTime, endOfUpdateTime);
    }
    public CouponRequest<T> withUpdateTimeBefore(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public CouponRequest<T> withUpdateTimeBefore(Date updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public CouponRequest<T> withUpdateTimeAfter(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public CouponRequest<T> withUpdateTimeAfter(Date updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public CouponRequest<T> withUpdateTimeBetween(Date startOfUpdateTime, Date endOfUpdateTime){
       return withUpdateTime(Operator.BETWEEN, startOfUpdateTime, endOfUpdateTime);
    }




    public CouponRequest<T> filterByVersion(Long... version){
      if (version == null || version.length == 0) {
        throw new IllegalArgumentException("filterByVersion parameter version cannot be empty");
      }
      return appendSearchCriteria(createVersionCriteria(Operator.EQUAL, (Object[])version));
    }

    public CouponRequest<T> withVersion(Operator operator, Object... values){
       return appendSearchCriteria(createVersionCriteria(operator, values));
    }

    public CouponRequest<T> withVersionIsUnknown(){
       return withVersion(Operator.IS_NULL);
    }

    public CouponRequest<T> withVersionIsKnown(){
       return withVersion(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createVersionCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Coupon.VERSION_PROPERTY, operator, values);
    }

    public CouponRequest<T> withVersionGreaterThan(Long version){
       return withVersion(Operator.GREATER_THAN, version);
    }

    public CouponRequest<T> withVersionGreaterThanOrEqualTo(Long version){
       return withVersion(Operator.GREATER_THAN_OR_EQUAL, version);
    }

    public CouponRequest<T> withVersionLessThan(Long version){
       return withVersion(Operator.LESS_THAN, version);
    }

    public CouponRequest<T> withVersionLessThanOrEqualTo(Long version){
       return withVersion(Operator.LESS_THAN_OR_EQUAL, version);
    }

    public CouponRequest<T> withVersionBetween(Long startOfVersion, Long endOfVersion){
       return withVersion(Operator.BETWEEN, startOfVersion, endOfVersion);
    }


    public CouponRequest<T> count(){
        super.count();
        return this;
    }
    public CouponRequest<T> countAs(String retName){
        super.count(retName);
        return this;
    }
    public CouponRequest minTimesUsed(){
        return minTimesUsedAs(prefix("minOf",Coupon.TIMES_USED_PROPERTY));
    }

    public CouponRequest minTimesUsedAs(String retName){
        super.min(retName, Coupon.TIMES_USED_PROPERTY);
        return this;
    }
    public CouponRequest maxTimesUsed(){
        return maxTimesUsedAs(prefix("maxOf",Coupon.TIMES_USED_PROPERTY));
    }

    public CouponRequest maxTimesUsedAs(String retName){
        super.max(retName, Coupon.TIMES_USED_PROPERTY);
        return this;
    }
    public CouponRequest sumTimesUsed(){
        return sumTimesUsedAs(prefix("sumOf",Coupon.TIMES_USED_PROPERTY));
    }

    public CouponRequest sumTimesUsedAs(String retName){
        super.sum(retName, Coupon.TIMES_USED_PROPERTY);
        return this;
    }
    public CouponRequest avgTimesUsed(){
        return avgTimesUsedAs(prefix("avgOf",Coupon.TIMES_USED_PROPERTY));
    }

    public CouponRequest avgTimesUsedAs(String retName){
        super.avg(retName, Coupon.TIMES_USED_PROPERTY);
        return this;
    }
    public CouponRequest standardDeviationTimesUsed(){
        return standardDeviationTimesUsedAs(prefix("standardDeviationOf",Coupon.TIMES_USED_PROPERTY));
    }

    public CouponRequest standardDeviationTimesUsedAs(String retName){
        super.standardDeviation(retName, Coupon.TIMES_USED_PROPERTY);
        return this;
    }
    public CouponRequest squareRootOfPopulationStandardDeviationTimesUsed(){
        return squareRootOfPopulationStandardDeviationTimesUsedAs(prefix("squareRootOfPopulationStandardDeviationOf",Coupon.TIMES_USED_PROPERTY));
    }

    public CouponRequest squareRootOfPopulationStandardDeviationTimesUsedAs(String retName){
        super.squareRootOfPopulationStandardDeviation(retName, Coupon.TIMES_USED_PROPERTY);
        return this;
    }
    public CouponRequest sampleVarianceTimesUsed(){
        return sampleVarianceTimesUsedAs(prefix("sampleVarianceOf",Coupon.TIMES_USED_PROPERTY));
    }

    public CouponRequest sampleVarianceTimesUsedAs(String retName){
        super.sampleVariance(retName, Coupon.TIMES_USED_PROPERTY);
        return this;
    }
    public CouponRequest samplePopulationVarianceTimesUsed(){
        return samplePopulationVarianceTimesUsedAs(prefix("samplePopulationVarianceOf",Coupon.TIMES_USED_PROPERTY));
    }

    public CouponRequest samplePopulationVarianceTimesUsedAs(String retName){
        super.samplePopulationVariance(retName, Coupon.TIMES_USED_PROPERTY);
        return this;
    }
    public CouponRequest minUsageLimit(){
        return minUsageLimitAs(prefix("minOf",Coupon.USAGE_LIMIT_PROPERTY));
    }

    public CouponRequest minUsageLimitAs(String retName){
        super.min(retName, Coupon.USAGE_LIMIT_PROPERTY);
        return this;
    }
    public CouponRequest maxUsageLimit(){
        return maxUsageLimitAs(prefix("maxOf",Coupon.USAGE_LIMIT_PROPERTY));
    }

    public CouponRequest maxUsageLimitAs(String retName){
        super.max(retName, Coupon.USAGE_LIMIT_PROPERTY);
        return this;
    }
    public CouponRequest sumUsageLimit(){
        return sumUsageLimitAs(prefix("sumOf",Coupon.USAGE_LIMIT_PROPERTY));
    }

    public CouponRequest sumUsageLimitAs(String retName){
        super.sum(retName, Coupon.USAGE_LIMIT_PROPERTY);
        return this;
    }
    public CouponRequest avgUsageLimit(){
        return avgUsageLimitAs(prefix("avgOf",Coupon.USAGE_LIMIT_PROPERTY));
    }

    public CouponRequest avgUsageLimitAs(String retName){
        super.avg(retName, Coupon.USAGE_LIMIT_PROPERTY);
        return this;
    }
    public CouponRequest standardDeviationUsageLimit(){
        return standardDeviationUsageLimitAs(prefix("standardDeviationOf",Coupon.USAGE_LIMIT_PROPERTY));
    }

    public CouponRequest standardDeviationUsageLimitAs(String retName){
        super.standardDeviation(retName, Coupon.USAGE_LIMIT_PROPERTY);
        return this;
    }
    public CouponRequest squareRootOfPopulationStandardDeviationUsageLimit(){
        return squareRootOfPopulationStandardDeviationUsageLimitAs(prefix("squareRootOfPopulationStandardDeviationOf",Coupon.USAGE_LIMIT_PROPERTY));
    }

    public CouponRequest squareRootOfPopulationStandardDeviationUsageLimitAs(String retName){
        super.squareRootOfPopulationStandardDeviation(retName, Coupon.USAGE_LIMIT_PROPERTY);
        return this;
    }
    public CouponRequest sampleVarianceUsageLimit(){
        return sampleVarianceUsageLimitAs(prefix("sampleVarianceOf",Coupon.USAGE_LIMIT_PROPERTY));
    }

    public CouponRequest sampleVarianceUsageLimitAs(String retName){
        super.sampleVariance(retName, Coupon.USAGE_LIMIT_PROPERTY);
        return this;
    }
    public CouponRequest samplePopulationVarianceUsageLimit(){
        return samplePopulationVarianceUsageLimitAs(prefix("samplePopulationVarianceOf",Coupon.USAGE_LIMIT_PROPERTY));
    }

    public CouponRequest samplePopulationVarianceUsageLimitAs(String retName){
        super.samplePopulationVariance(retName, Coupon.USAGE_LIMIT_PROPERTY);
        return this;
    }
    public CouponRequest<T> groupByPromotionWithDetails(){
       return groupByPromotionWithDetails(Q.promotions().unlimited());
    }

    public CouponRequest<T> groupByPromotionWithDetails(PromotionRequest subRequest){
       aggregate(Coupon.PROMOTION_PROPERTY, subRequest);
       return this;
    }







    public CouponRequest<T> groupById(){
       groupBy(Coupon.ID_PROPERTY);
       return this;
    }

    public CouponRequest<T> groupByIdAs(String retName){
       groupBy(retName, Coupon.ID_PROPERTY);
       return this;
    }

    public CouponRequest<T> groupByIdWithFunction(String retName, AggrFunction function){
       groupBy(retName, Coupon.ID_PROPERTY, function);
       return this;
    }

    public CouponRequest<T> groupByCode(){
       groupBy(Coupon.CODE_PROPERTY);
       return this;
    }

    public CouponRequest<T> groupByCodeAs(String retName){
       groupBy(retName, Coupon.CODE_PROPERTY);
       return this;
    }

    public CouponRequest<T> groupByCodeWithFunction(String retName, AggrFunction function){
       groupBy(retName, Coupon.CODE_PROPERTY, function);
       return this;
    }
    public CouponRequest<T> groupByPromotionWith(PromotionRequest subRequest){
       groupBy(Coupon.PROMOTION_PROPERTY, subRequest);
       return this;
    }
    public CouponRequest<T> groupByPromotion(){
       groupBy(Coupon.PROMOTION_PROPERTY);
       return this;
    }

    public CouponRequest<T> groupByPromotionAs(String retName){
       groupBy(retName, Coupon.PROMOTION_PROPERTY);
       return this;
    }

    public CouponRequest<T> groupByPromotionWithFunction(String retName, AggrFunction function){
       groupBy(retName, Coupon.PROMOTION_PROPERTY, function);
       return this;
    }

    public CouponRequest<T> groupByTimesUsed(){
       groupBy(Coupon.TIMES_USED_PROPERTY);
       return this;
    }

    public CouponRequest<T> groupByTimesUsedAs(String retName){
       groupBy(retName, Coupon.TIMES_USED_PROPERTY);
       return this;
    }

    public CouponRequest<T> groupByTimesUsedWithFunction(String retName, AggrFunction function){
       groupBy(retName, Coupon.TIMES_USED_PROPERTY, function);
       return this;
    }

    public CouponRequest<T> groupByUsageLimit(){
       groupBy(Coupon.USAGE_LIMIT_PROPERTY);
       return this;
    }

    public CouponRequest<T> groupByUsageLimitAs(String retName){
       groupBy(retName, Coupon.USAGE_LIMIT_PROPERTY);
       return this;
    }

    public CouponRequest<T> groupByUsageLimitWithFunction(String retName, AggrFunction function){
       groupBy(retName, Coupon.USAGE_LIMIT_PROPERTY, function);
       return this;
    }

    public CouponRequest<T> groupByCreateTime(){
       groupBy(Coupon.CREATE_TIME_PROPERTY);
       return this;
    }

    public CouponRequest<T> groupByCreateTimeAs(String retName){
       groupBy(retName, Coupon.CREATE_TIME_PROPERTY);
       return this;
    }

    public CouponRequest<T> groupByCreateTimeWithFunction(String retName, AggrFunction function){
       groupBy(retName, Coupon.CREATE_TIME_PROPERTY, function);
       return this;
    }

    public CouponRequest<T> groupByUpdateTime(){
       groupBy(Coupon.UPDATE_TIME_PROPERTY);
       return this;
    }

    public CouponRequest<T> groupByUpdateTimeAs(String retName){
       groupBy(retName, Coupon.UPDATE_TIME_PROPERTY);
       return this;
    }

    public CouponRequest<T> groupByUpdateTimeWithFunction(String retName, AggrFunction function){
       groupBy(retName, Coupon.UPDATE_TIME_PROPERTY, function);
       return this;
    }

    public CouponRequest<T> groupByVersion(){
       groupBy(Coupon.VERSION_PROPERTY);
       return this;
    }

    public CouponRequest<T> groupByVersionAs(String retName){
       groupBy(retName, Coupon.VERSION_PROPERTY);
       return this;
    }

    public CouponRequest<T> groupByVersionWithFunction(String retName, AggrFunction function){
       groupBy(retName, Coupon.VERSION_PROPERTY, function);
       return this;
    }



    public CouponRequest<T> orderByIdAscending(){
       addOrderByAscending(Coupon.ID_PROPERTY);
       return this;
    }

    public CouponRequest<T> orderByIdDescending(){
       addOrderByDescending(Coupon.ID_PROPERTY);
       return this;
    }

    public CouponRequest<T> orderByCodeAscending(){
       addOrderByAscending(Coupon.CODE_PROPERTY);
       return this;
    }

    public CouponRequest<T> orderByCodeDescending(){
       addOrderByDescending(Coupon.CODE_PROPERTY);
       return this;
    }
    public CouponRequest<T> orderByCodeAscendingUsingGBK(){
       addOrderByAscendingUsingGBK(Coupon.CODE_PROPERTY);
       return this;
    }

    public CouponRequest<T> orderByCodeDescendingUsingGBK(){
       addOrderByDescendingUsingGBK(Coupon.CODE_PROPERTY);
       return this;
    }
    public CouponRequest<T> orderByPromotionAscending(){
       addOrderByAscending(Coupon.PROMOTION_PROPERTY);
       return this;
    }

    public CouponRequest<T> orderByPromotionDescending(){
       addOrderByDescending(Coupon.PROMOTION_PROPERTY);
       return this;
    }

    public CouponRequest<T> orderByTimesUsedAscending(){
       addOrderByAscending(Coupon.TIMES_USED_PROPERTY);
       return this;
    }

    public CouponRequest<T> orderByTimesUsedDescending(){
       addOrderByDescending(Coupon.TIMES_USED_PROPERTY);
       return this;
    }

    public CouponRequest<T> orderByUsageLimitAscending(){
       addOrderByAscending(Coupon.USAGE_LIMIT_PROPERTY);
       return this;
    }

    public CouponRequest<T> orderByUsageLimitDescending(){
       addOrderByDescending(Coupon.USAGE_LIMIT_PROPERTY);
       return this;
    }

    public CouponRequest<T> orderByCreateTimeAscending(){
       addOrderByAscending(Coupon.CREATE_TIME_PROPERTY);
       return this;
    }

    public CouponRequest<T> orderByCreateTimeDescending(){
       addOrderByDescending(Coupon.CREATE_TIME_PROPERTY);
       return this;
    }

    public CouponRequest<T> orderByUpdateTimeAscending(){
       addOrderByAscending(Coupon.UPDATE_TIME_PROPERTY);
       return this;
    }

    public CouponRequest<T> orderByUpdateTimeDescending(){
       addOrderByDescending(Coupon.UPDATE_TIME_PROPERTY);
       return this;
    }

    public CouponRequest<T> orderByVersionAscending(){
       addOrderByAscending(Coupon.VERSION_PROPERTY);
       return this;
    }

    public CouponRequest<T> orderByVersionDescending(){
       addOrderByDescending(Coupon.VERSION_PROPERTY);
       return this;
    }


    public PromotionRequest rollUpToPromotion(){
       PromotionRequest promotion = Q.promotions().unlimited();
       this.withPromotionMatching(promotion)
           .groupByPromotionWith(promotion);
       return promotion;
    }







   public CouponRequest<T> facetByPromotionAs(String facetName, PromotionRequest promotion){
       return facetByPromotionAs(facetName, promotion, true);
   }

   public CouponRequest<T> facetByPromotionAs(String facetName, PromotionRequest promotion, boolean includeAllFacets){
       addFacet(facetName, Coupon.PROMOTION_PROPERTY, promotion, includeAllFacets);
       return this;
   }


    /**
     * get topN records
     * @param topN  records number
     */
    public CouponRequest<T> top(int topN) {
        super.top(topN);
        return this;
    }

    /**
     * get records from offset(inclusive) to offset+size(exclusive)
     * @param offset record offset
     * @param size records number
     */
    public CouponRequest<T> offset(int offset, int size) {
        super.offset(offset, size);
        return this;
    }

    /**
     * retrieve all records
     */
    public CouponRequest<T> unlimited() {
        super.unlimited();
        return this;
    }

    /**
     * get records of one page
     * @param pageNumber page number(1-based)
     * @param pageSize page size
     */
    public CouponRequest<T> page(int pageNumber, int pageSize) {
        int offset = (pageNumber - 1) * pageSize;
        return offset(offset, pageSize);
   }

    /**
     * get records of one page, default page size is 10
     * @param pageNumber page number(1-based)
     */
    public CouponRequest<T> page(int pageNumber) {
        return page(pageNumber, 10);
   }
}