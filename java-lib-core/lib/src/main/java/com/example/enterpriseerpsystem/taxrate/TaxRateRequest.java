
package com.example.enterpriseerpsystem.taxrate;

import io.teaql.core.AggrFunction;
import io.teaql.core.BaseRequest;
import io.teaql.core.PropertyReference;
import io.teaql.core.SearchCriteria;
import io.teaql.core.criteria.Operator;
import io.teaql.core.criteria.TwoOperatorCriteria;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

public class TaxRateRequest<T extends TaxRate> extends BaseRequest<T> {

    /**
     * @deprecated AI agents and business code must use the generated Q facade
     *             instead of constructing request builders directly.
     */
    @Deprecated
    public TaxRateRequest(Class<T> returnType){
        super(returnType);
        selectId();
        selectVersion();
    }

    public TaxRateRequest<T> comment(String comment){
         super.internalComment(comment);
         return this;
    }

    // purpose() 继承自 BaseRequest，返回 ExecutableRequest（终结方法）

    public TaxRateRequest<T> returnType(Class<? extends T> returnType){
        super.setReturnType(returnType);
        return this;
    }

    public TaxRateRequest<T> enableAggregationCache(long cacheExpiredMillis){
        super.enableAggregationCache();
        super.aggregateCacheTime(cacheExpiredMillis);
        return this;
    }

    public TaxRateRequest<T> enableAggregationCache(){
        return enableAggregationCache(0l);
    }


    public TaxRateRequest<T> propagateAggregationCache(long cacheExpiredMillis){
        super.propagateAggregationCache(cacheExpiredMillis);
        return this;
    }

    public TaxRateRequest<T> appendSearchCriteria(SearchCriteria searchCriteria){
        return (TaxRateRequest<T>)super.appendSearchCriteria(searchCriteria);
    }

    public TaxRateRequest<T> filter(String property1, Operator operator, String property2){
        return appendSearchCriteria(new TwoOperatorCriteria(operator, new PropertyReference(property1), new PropertyReference(property2)));
    }


    public TaxRateRequest<T> matchingAnyOf(TaxRateRequest taxRate){
        super.internalMatchAny(taxRate);
        return this;
    }

    public TaxRateRequest<T> enhanceChildrenIfNeeded(){
        return this;
    }

    public TaxRateRequest<T> withDeletedRows(){
        super.withDeletedRows();
        return this;
    }

    public TaxRateRequest<T> deletedRowsOnly(){
        super.deletedRowsOnly();
        return this;
    }

    public TaxRateRequest<T> selectSelf(){
        super.selectSelf();
        return selectId().selectIsActive().selectRate().selectRegion().selectCreateTime().selectUpdateTime().selectVersion();
    }

    public TaxRateRequest<T> selectSelfFields(){
        return selectSelf();
    }

    public TaxRateRequest<T> selectAll(){
        super.selectAll();
        return selectId().selectIsActive().selectRate().selectRegion().selectCreateTime().selectUpdateTime().selectVersion();
    }

    public TaxRateRequest<T> selectChildren(){
        super.selectAny();
        return selectId().selectIsActive().selectRate().selectRegion().selectCreateTime().selectUpdateTime().selectVersion();
    }


    public TaxRateRequest<T> selectId(){
       selectProperty(TaxRate.ID_PROPERTY);
       return this;
    }

    /**
     * fill the id with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  id) to fetch id property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public TaxRateRequest<T> unselectId(){
       unselectProperty(TaxRate.ID_PROPERTY);
       return this;
    }
    public TaxRateRequest<T> selectIsActive(){
       selectProperty(TaxRate.IS_ACTIVE_PROPERTY);
       return this;
    }

    /**
     * fill the isActive with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  isActive) to fetch isActive property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public TaxRateRequest<T> unselectIsActive(){
       unselectProperty(TaxRate.IS_ACTIVE_PROPERTY);
       return this;
    }
    public TaxRateRequest<T> selectRate(){
       selectProperty(TaxRate.RATE_PROPERTY);
       return this;
    }

    /**
     * fill the rate with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  rate) to fetch rate property.
     * @param rawSqlSegment  customized rawSqlSegment
     */


    /**
     * fill the rate with customized aggrFunction, TEAQL uses ({aggrFunction}(rate) AS rate to fetch rate property.
     * @param aggrFunction  aggrFunction
     */
    public TaxRateRequest<T> selectRate(AggrFunction aggrFunction){
       selectProperty(TaxRate.RATE_PROPERTY, aggrFunction);
       return this;
    }


    public TaxRateRequest<T> unselectRate(){
       unselectProperty(TaxRate.RATE_PROPERTY);
       return this;
    }
    public TaxRateRequest<T> selectRegion(){
       selectProperty(TaxRate.REGION_PROPERTY);
       return this;
    }

    /**
     * fill the region with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  region) to fetch region property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public TaxRateRequest<T> unselectRegion(){
       unselectProperty(TaxRate.REGION_PROPERTY);
       return this;
    }
    public TaxRateRequest<T> selectCreateTime(){
       selectProperty(TaxRate.CREATE_TIME_PROPERTY);
       return this;
    }

    /**
     * fill the createTime with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  createTime) to fetch createTime property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public TaxRateRequest<T> unselectCreateTime(){
       unselectProperty(TaxRate.CREATE_TIME_PROPERTY);
       return this;
    }
    public TaxRateRequest<T> selectUpdateTime(){
       selectProperty(TaxRate.UPDATE_TIME_PROPERTY);
       return this;
    }

    /**
     * fill the updateTime with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  updateTime) to fetch updateTime property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public TaxRateRequest<T> unselectUpdateTime(){
       unselectProperty(TaxRate.UPDATE_TIME_PROPERTY);
       return this;
    }
    public TaxRateRequest<T> selectVersion(){
       selectProperty(TaxRate.VERSION_PROPERTY);
       return this;
    }

    /**
     * fill the version with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  version) to fetch version property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public TaxRateRequest<T> unselectVersion(){
       unselectProperty(TaxRate.VERSION_PROPERTY);
       return this;
    }

    public TaxRateRequest<T> withId(Operator operator, Object... values){
       return appendSearchCriteria(createIdCriteria(operator, values));
    }

    public SearchCriteria createIdCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(TaxRate.ID_PROPERTY, operator, values);
    }

    public TaxRateRequest<T> withIdIs(Long id){
       return withId(Operator.EQUAL, id);
    }
    public TaxRateRequest<T> withIdIn(Long... id){
       return withId(Operator.EQUAL, (Object[])id);
    }



    public TaxRateRequest<T> filterByIsActive(Boolean... isActive){
      if (isActive == null || isActive.length == 0) {
        throw new IllegalArgumentException("filterByIsActive parameter isActive cannot be empty");
      }
      return appendSearchCriteria(createIsActiveCriteria(Operator.EQUAL, (Object[])isActive));
    }

    public TaxRateRequest<T> withIsActive(Operator operator, Object... values){
       return appendSearchCriteria(createIsActiveCriteria(operator, values));
    }

    public TaxRateRequest<T> withIsActiveIsUnknown(){
       return withIsActive(Operator.IS_NULL);
    }

    public TaxRateRequest<T> withIsActiveIsKnown(){
       return withIsActive(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createIsActiveCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(TaxRate.IS_ACTIVE_PROPERTY, operator, values);
    }

    public TaxRateRequest<T> whichIsIsActive(){
       return withIsActive(Operator.EQUAL, true);
    }

    public TaxRateRequest<T> whichIsNotIsActive(){
       return withIsActive(Operator.EQUAL, false);
    }


    public TaxRateRequest<T> filterByRate(BigDecimal... rate){
      if (rate == null || rate.length == 0) {
        throw new IllegalArgumentException("filterByRate parameter rate cannot be empty");
      }
      return appendSearchCriteria(createRateCriteria(Operator.EQUAL, (Object[])rate));
    }

    public TaxRateRequest<T> withRate(Operator operator, Object... values){
       return appendSearchCriteria(createRateCriteria(operator, values));
    }

    public TaxRateRequest<T> withRateIsUnknown(){
       return withRate(Operator.IS_NULL);
    }

    public TaxRateRequest<T> withRateIsKnown(){
       return withRate(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createRateCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(TaxRate.RATE_PROPERTY, operator, values);
    }

    public TaxRateRequest<T> withRateGreaterThan(BigDecimal rate){
       return withRate(Operator.GREATER_THAN, rate);
    }

    public TaxRateRequest<T> withRateGreaterThanOrEqualTo(BigDecimal rate){
       return withRate(Operator.GREATER_THAN_OR_EQUAL, rate);
    }

    public TaxRateRequest<T> withRateLessThan(BigDecimal rate){
       return withRate(Operator.LESS_THAN, rate);
    }

    public TaxRateRequest<T> withRateLessThanOrEqualTo(BigDecimal rate){
       return withRate(Operator.LESS_THAN_OR_EQUAL, rate);
    }

    public TaxRateRequest<T> withRateBetween(BigDecimal startOfRate, BigDecimal endOfRate){
       return withRate(Operator.BETWEEN, startOfRate, endOfRate);
    }



    public TaxRateRequest<T> filterByRegion(String... region){
      if (region == null || region.length == 0) {
        throw new IllegalArgumentException("filterByRegion parameter region cannot be empty");
      }
      return appendSearchCriteria(createRegionCriteria(Operator.EQUAL, (Object[])region));
    }

    public TaxRateRequest<T> withRegion(Operator operator, Object... values){
       return appendSearchCriteria(createRegionCriteria(operator, values));
    }

    public TaxRateRequest<T> withRegionIsUnknown(){
       return withRegion(Operator.IS_NULL);
    }

    public TaxRateRequest<T> withRegionIsKnown(){
       return withRegion(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createRegionCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(TaxRate.REGION_PROPERTY, operator, values);
    }

    public TaxRateRequest<T> withRegionGreaterThan(String region){
       return withRegion(Operator.GREATER_THAN, region);
    }

    public TaxRateRequest<T> withRegionGreaterThanOrEqualTo(String region){
       return withRegion(Operator.GREATER_THAN_OR_EQUAL, region);
    }

    public TaxRateRequest<T> withRegionLessThan(String region){
       return withRegion(Operator.LESS_THAN, region);
    }

    public TaxRateRequest<T> withRegionLessThanOrEqualTo(String region){
       return withRegion(Operator.LESS_THAN_OR_EQUAL, region);
    }

    public TaxRateRequest<T> withRegionBetween(String startOfRegion, String endOfRegion){
       return withRegion(Operator.BETWEEN, startOfRegion, endOfRegion);
    }
    public TaxRateRequest<T> withRegionStartingWith(String region){
       return withRegion(Operator.BEGIN_WITH, region);
    }
    public TaxRateRequest<T> withRegionContaining(String region){
       return withRegion(Operator.CONTAIN, region);
    }

    public TaxRateRequest<T> withRegionEndingWith(String region){
       return withRegion(Operator.END_WITH, region);
    }

    public TaxRateRequest<T> withRegionIs(String region){
       return withRegion(Operator.EQUAL, region);
    }

    public TaxRateRequest<T> withRegionSoundingLike(String region){
       return withRegion(Operator.SOUNDS_LIKE, region);
    }



    public TaxRateRequest<T> filterByCreateTime(LocalDateTime... createTime){
      if (createTime == null || createTime.length == 0) {
        throw new IllegalArgumentException("filterByCreateTime parameter createTime cannot be empty");
      }
      return appendSearchCriteria(createCreateTimeCriteria(Operator.EQUAL, (Object[])createTime));
    }

    public TaxRateRequest<T> withCreateTime(Operator operator, Object... values){
       return appendSearchCriteria(createCreateTimeCriteria(operator, values));
    }

    public TaxRateRequest<T> withCreateTimeIsUnknown(){
       return withCreateTime(Operator.IS_NULL);
    }

    public TaxRateRequest<T> withCreateTimeIsKnown(){
       return withCreateTime(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createCreateTimeCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(TaxRate.CREATE_TIME_PROPERTY, operator, values);
    }

    public TaxRateRequest<T> withCreateTimeGreaterThan(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public TaxRateRequest<T> withCreateTimeGreaterThanOrEqualTo(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN_OR_EQUAL, createTime);
    }

    public TaxRateRequest<T> withCreateTimeLessThan(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public TaxRateRequest<T> withCreateTimeLessThanOrEqualTo(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN_OR_EQUAL, createTime);
    }

    public TaxRateRequest<T> withCreateTimeBetween(LocalDateTime startOfCreateTime, LocalDateTime endOfCreateTime){
       return withCreateTime(Operator.BETWEEN, startOfCreateTime, endOfCreateTime);
    }
    public TaxRateRequest<T> withCreateTimeBefore(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public TaxRateRequest<T> withCreateTimeBefore(Date createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public TaxRateRequest<T> withCreateTimeAfter(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public TaxRateRequest<T> withCreateTimeAfter(Date createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public TaxRateRequest<T> withCreateTimeBetween(Date startOfCreateTime, Date endOfCreateTime){
       return withCreateTime(Operator.BETWEEN, startOfCreateTime, endOfCreateTime);
    }




    public TaxRateRequest<T> filterByUpdateTime(LocalDateTime... updateTime){
      if (updateTime == null || updateTime.length == 0) {
        throw new IllegalArgumentException("filterByUpdateTime parameter updateTime cannot be empty");
      }
      return appendSearchCriteria(createUpdateTimeCriteria(Operator.EQUAL, (Object[])updateTime));
    }

    public TaxRateRequest<T> withUpdateTime(Operator operator, Object... values){
       return appendSearchCriteria(createUpdateTimeCriteria(operator, values));
    }

    public TaxRateRequest<T> withUpdateTimeIsUnknown(){
       return withUpdateTime(Operator.IS_NULL);
    }

    public TaxRateRequest<T> withUpdateTimeIsKnown(){
       return withUpdateTime(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createUpdateTimeCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(TaxRate.UPDATE_TIME_PROPERTY, operator, values);
    }

    public TaxRateRequest<T> withUpdateTimeGreaterThan(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public TaxRateRequest<T> withUpdateTimeGreaterThanOrEqualTo(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN_OR_EQUAL, updateTime);
    }

    public TaxRateRequest<T> withUpdateTimeLessThan(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public TaxRateRequest<T> withUpdateTimeLessThanOrEqualTo(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN_OR_EQUAL, updateTime);
    }

    public TaxRateRequest<T> withUpdateTimeBetween(LocalDateTime startOfUpdateTime, LocalDateTime endOfUpdateTime){
       return withUpdateTime(Operator.BETWEEN, startOfUpdateTime, endOfUpdateTime);
    }
    public TaxRateRequest<T> withUpdateTimeBefore(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public TaxRateRequest<T> withUpdateTimeBefore(Date updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public TaxRateRequest<T> withUpdateTimeAfter(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public TaxRateRequest<T> withUpdateTimeAfter(Date updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public TaxRateRequest<T> withUpdateTimeBetween(Date startOfUpdateTime, Date endOfUpdateTime){
       return withUpdateTime(Operator.BETWEEN, startOfUpdateTime, endOfUpdateTime);
    }




    public TaxRateRequest<T> filterByVersion(Long... version){
      if (version == null || version.length == 0) {
        throw new IllegalArgumentException("filterByVersion parameter version cannot be empty");
      }
      return appendSearchCriteria(createVersionCriteria(Operator.EQUAL, (Object[])version));
    }

    public TaxRateRequest<T> withVersion(Operator operator, Object... values){
       return appendSearchCriteria(createVersionCriteria(operator, values));
    }

    public TaxRateRequest<T> withVersionIsUnknown(){
       return withVersion(Operator.IS_NULL);
    }

    public TaxRateRequest<T> withVersionIsKnown(){
       return withVersion(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createVersionCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(TaxRate.VERSION_PROPERTY, operator, values);
    }

    public TaxRateRequest<T> withVersionGreaterThan(Long version){
       return withVersion(Operator.GREATER_THAN, version);
    }

    public TaxRateRequest<T> withVersionGreaterThanOrEqualTo(Long version){
       return withVersion(Operator.GREATER_THAN_OR_EQUAL, version);
    }

    public TaxRateRequest<T> withVersionLessThan(Long version){
       return withVersion(Operator.LESS_THAN, version);
    }

    public TaxRateRequest<T> withVersionLessThanOrEqualTo(Long version){
       return withVersion(Operator.LESS_THAN_OR_EQUAL, version);
    }

    public TaxRateRequest<T> withVersionBetween(Long startOfVersion, Long endOfVersion){
       return withVersion(Operator.BETWEEN, startOfVersion, endOfVersion);
    }


    public TaxRateRequest<T> count(){
        super.count();
        return this;
    }
    public TaxRateRequest<T> countAs(String retName){
        super.count(retName);
        return this;
    }
    public TaxRateRequest minRate(){
        return minRateAs(prefix("minOf",TaxRate.RATE_PROPERTY));
    }

    public TaxRateRequest minRateAs(String retName){
        super.min(retName, TaxRate.RATE_PROPERTY);
        return this;
    }
    public TaxRateRequest maxRate(){
        return maxRateAs(prefix("maxOf",TaxRate.RATE_PROPERTY));
    }

    public TaxRateRequest maxRateAs(String retName){
        super.max(retName, TaxRate.RATE_PROPERTY);
        return this;
    }
    public TaxRateRequest sumRate(){
        return sumRateAs(prefix("sumOf",TaxRate.RATE_PROPERTY));
    }

    public TaxRateRequest sumRateAs(String retName){
        super.sum(retName, TaxRate.RATE_PROPERTY);
        return this;
    }
    public TaxRateRequest avgRate(){
        return avgRateAs(prefix("avgOf",TaxRate.RATE_PROPERTY));
    }

    public TaxRateRequest avgRateAs(String retName){
        super.avg(retName, TaxRate.RATE_PROPERTY);
        return this;
    }
    public TaxRateRequest standardDeviationRate(){
        return standardDeviationRateAs(prefix("standardDeviationOf",TaxRate.RATE_PROPERTY));
    }

    public TaxRateRequest standardDeviationRateAs(String retName){
        super.standardDeviation(retName, TaxRate.RATE_PROPERTY);
        return this;
    }
    public TaxRateRequest squareRootOfPopulationStandardDeviationRate(){
        return squareRootOfPopulationStandardDeviationRateAs(prefix("squareRootOfPopulationStandardDeviationOf",TaxRate.RATE_PROPERTY));
    }

    public TaxRateRequest squareRootOfPopulationStandardDeviationRateAs(String retName){
        super.squareRootOfPopulationStandardDeviation(retName, TaxRate.RATE_PROPERTY);
        return this;
    }
    public TaxRateRequest sampleVarianceRate(){
        return sampleVarianceRateAs(prefix("sampleVarianceOf",TaxRate.RATE_PROPERTY));
    }

    public TaxRateRequest sampleVarianceRateAs(String retName){
        super.sampleVariance(retName, TaxRate.RATE_PROPERTY);
        return this;
    }
    public TaxRateRequest samplePopulationVarianceRate(){
        return samplePopulationVarianceRateAs(prefix("samplePopulationVarianceOf",TaxRate.RATE_PROPERTY));
    }

    public TaxRateRequest samplePopulationVarianceRateAs(String retName){
        super.samplePopulationVariance(retName, TaxRate.RATE_PROPERTY);
        return this;
    }

    public TaxRateRequest<T> groupById(){
       groupBy(TaxRate.ID_PROPERTY);
       return this;
    }

    public TaxRateRequest<T> groupByIdAs(String retName){
       groupBy(retName, TaxRate.ID_PROPERTY);
       return this;
    }

    public TaxRateRequest<T> groupByIdWithFunction(String retName, AggrFunction function){
       groupBy(retName, TaxRate.ID_PROPERTY, function);
       return this;
    }

    public TaxRateRequest<T> groupByIsActive(){
       groupBy(TaxRate.IS_ACTIVE_PROPERTY);
       return this;
    }

    public TaxRateRequest<T> groupByIsActiveAs(String retName){
       groupBy(retName, TaxRate.IS_ACTIVE_PROPERTY);
       return this;
    }

    public TaxRateRequest<T> groupByIsActiveWithFunction(String retName, AggrFunction function){
       groupBy(retName, TaxRate.IS_ACTIVE_PROPERTY, function);
       return this;
    }

    public TaxRateRequest<T> groupByRate(){
       groupBy(TaxRate.RATE_PROPERTY);
       return this;
    }

    public TaxRateRequest<T> groupByRateAs(String retName){
       groupBy(retName, TaxRate.RATE_PROPERTY);
       return this;
    }

    public TaxRateRequest<T> groupByRateWithFunction(String retName, AggrFunction function){
       groupBy(retName, TaxRate.RATE_PROPERTY, function);
       return this;
    }

    public TaxRateRequest<T> groupByRegion(){
       groupBy(TaxRate.REGION_PROPERTY);
       return this;
    }

    public TaxRateRequest<T> groupByRegionAs(String retName){
       groupBy(retName, TaxRate.REGION_PROPERTY);
       return this;
    }

    public TaxRateRequest<T> groupByRegionWithFunction(String retName, AggrFunction function){
       groupBy(retName, TaxRate.REGION_PROPERTY, function);
       return this;
    }

    public TaxRateRequest<T> groupByCreateTime(){
       groupBy(TaxRate.CREATE_TIME_PROPERTY);
       return this;
    }

    public TaxRateRequest<T> groupByCreateTimeAs(String retName){
       groupBy(retName, TaxRate.CREATE_TIME_PROPERTY);
       return this;
    }

    public TaxRateRequest<T> groupByCreateTimeWithFunction(String retName, AggrFunction function){
       groupBy(retName, TaxRate.CREATE_TIME_PROPERTY, function);
       return this;
    }

    public TaxRateRequest<T> groupByUpdateTime(){
       groupBy(TaxRate.UPDATE_TIME_PROPERTY);
       return this;
    }

    public TaxRateRequest<T> groupByUpdateTimeAs(String retName){
       groupBy(retName, TaxRate.UPDATE_TIME_PROPERTY);
       return this;
    }

    public TaxRateRequest<T> groupByUpdateTimeWithFunction(String retName, AggrFunction function){
       groupBy(retName, TaxRate.UPDATE_TIME_PROPERTY, function);
       return this;
    }

    public TaxRateRequest<T> groupByVersion(){
       groupBy(TaxRate.VERSION_PROPERTY);
       return this;
    }

    public TaxRateRequest<T> groupByVersionAs(String retName){
       groupBy(retName, TaxRate.VERSION_PROPERTY);
       return this;
    }

    public TaxRateRequest<T> groupByVersionWithFunction(String retName, AggrFunction function){
       groupBy(retName, TaxRate.VERSION_PROPERTY, function);
       return this;
    }



    public TaxRateRequest<T> orderByIdAscending(){
       addOrderByAscending(TaxRate.ID_PROPERTY);
       return this;
    }

    public TaxRateRequest<T> orderByIdDescending(){
       addOrderByDescending(TaxRate.ID_PROPERTY);
       return this;
    }

    public TaxRateRequest<T> orderByIsActiveAscending(){
       addOrderByAscending(TaxRate.IS_ACTIVE_PROPERTY);
       return this;
    }

    public TaxRateRequest<T> orderByIsActiveDescending(){
       addOrderByDescending(TaxRate.IS_ACTIVE_PROPERTY);
       return this;
    }

    public TaxRateRequest<T> orderByRateAscending(){
       addOrderByAscending(TaxRate.RATE_PROPERTY);
       return this;
    }

    public TaxRateRequest<T> orderByRateDescending(){
       addOrderByDescending(TaxRate.RATE_PROPERTY);
       return this;
    }

    public TaxRateRequest<T> orderByRegionAscending(){
       addOrderByAscending(TaxRate.REGION_PROPERTY);
       return this;
    }

    public TaxRateRequest<T> orderByRegionDescending(){
       addOrderByDescending(TaxRate.REGION_PROPERTY);
       return this;
    }
    public TaxRateRequest<T> orderByRegionAscendingUsingGBK(){
       addOrderByAscendingUsingGBK(TaxRate.REGION_PROPERTY);
       return this;
    }

    public TaxRateRequest<T> orderByRegionDescendingUsingGBK(){
       addOrderByDescendingUsingGBK(TaxRate.REGION_PROPERTY);
       return this;
    }
    public TaxRateRequest<T> orderByCreateTimeAscending(){
       addOrderByAscending(TaxRate.CREATE_TIME_PROPERTY);
       return this;
    }

    public TaxRateRequest<T> orderByCreateTimeDescending(){
       addOrderByDescending(TaxRate.CREATE_TIME_PROPERTY);
       return this;
    }

    public TaxRateRequest<T> orderByUpdateTimeAscending(){
       addOrderByAscending(TaxRate.UPDATE_TIME_PROPERTY);
       return this;
    }

    public TaxRateRequest<T> orderByUpdateTimeDescending(){
       addOrderByDescending(TaxRate.UPDATE_TIME_PROPERTY);
       return this;
    }

    public TaxRateRequest<T> orderByVersionAscending(){
       addOrderByAscending(TaxRate.VERSION_PROPERTY);
       return this;
    }

    public TaxRateRequest<T> orderByVersionDescending(){
       addOrderByDescending(TaxRate.VERSION_PROPERTY);
       return this;
    }





    /**
     * get topN records
     * @param topN  records number
     */
    public TaxRateRequest<T> top(int topN) {
        super.top(topN);
        return this;
    }

    /**
     * get records from offset(inclusive) to offset+size(exclusive)
     * @param offset record offset
     * @param size records number
     */
    public TaxRateRequest<T> offset(int offset, int size) {
        super.offset(offset, size);
        return this;
    }

    /**
     * retrieve all records
     */
    public TaxRateRequest<T> unlimited() {
        super.unlimited();
        return this;
    }

    /**
     * get records of one page
     * @param pageNumber page number(1-based)
     * @param pageSize page size
     */
    public TaxRateRequest<T> page(int pageNumber, int pageSize) {
        int offset = (pageNumber - 1) * pageSize;
        return offset(offset, pageSize);
   }

    /**
     * get records of one page, default page size is 10
     * @param pageNumber page number(1-based)
     */
    public TaxRateRequest<T> page(int pageNumber) {
        return page(pageNumber, 10);
   }
}