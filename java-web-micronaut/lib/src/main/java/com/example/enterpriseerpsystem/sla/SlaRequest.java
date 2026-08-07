
package com.example.enterpriseerpsystem.sla;

import io.teaql.core.AggrFunction;
import io.teaql.core.BaseRequest;
import io.teaql.core.PropertyReference;
import io.teaql.core.SearchCriteria;
import io.teaql.core.criteria.Operator;
import io.teaql.core.criteria.TwoOperatorCriteria;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

public class SlaRequest<T extends Sla> extends BaseRequest<T> {

    /**
     * @deprecated AI agents and business code must use the generated Q facade
     *             instead of constructing request builders directly.
     */
    @Deprecated
    public SlaRequest(Class<T> returnType){
        super(returnType);
        selectId();
        selectVersion();
    }

    public SlaRequest<T> comment(String comment){
         super.internalComment(comment);
         return this;
    }

    // purpose() 继承自 BaseRequest，返回 ExecutableRequest（终结方法）

    public SlaRequest<T> returnType(Class<? extends T> returnType){
        super.setReturnType(returnType);
        return this;
    }

    public SlaRequest<T> enableAggregationCache(long cacheExpiredMillis){
        super.enableAggregationCache();
        super.aggregateCacheTime(cacheExpiredMillis);
        return this;
    }

    public SlaRequest<T> enableAggregationCache(){
        return enableAggregationCache(0l);
    }


    public SlaRequest<T> propagateAggregationCache(long cacheExpiredMillis){
        super.propagateAggregationCache(cacheExpiredMillis);
        return this;
    }

    public SlaRequest<T> appendSearchCriteria(SearchCriteria searchCriteria){
        return (SlaRequest<T>)super.appendSearchCriteria(searchCriteria);
    }

    public SlaRequest<T> filter(String property1, Operator operator, String property2){
        return appendSearchCriteria(new TwoOperatorCriteria(operator, new PropertyReference(property1), new PropertyReference(property2)));
    }


    public SlaRequest<T> matchingAnyOf(SlaRequest sla){
        super.internalMatchAny(sla);
        return this;
    }

    public SlaRequest<T> enhanceChildrenIfNeeded(){
        return this;
    }

    public SlaRequest<T> withDeletedRows(){
        super.withDeletedRows();
        return this;
    }

    public SlaRequest<T> deletedRowsOnly(){
        super.deletedRowsOnly();
        return this;
    }

    public SlaRequest<T> selectSelf(){
        super.selectSelf();
        return selectId().selectIsActive().selectPriorityLevel().selectResolutionHours().selectCreateTime().selectUpdateTime().selectVersion();
    }

    public SlaRequest<T> selectSelfFields(){
        return selectSelf();
    }

    public SlaRequest<T> selectAll(){
        super.selectAll();
        return selectId().selectIsActive().selectPriorityLevel().selectResolutionHours().selectCreateTime().selectUpdateTime().selectVersion();
    }

    public SlaRequest<T> selectChildren(){
        super.selectAny();
        return selectId().selectIsActive().selectPriorityLevel().selectResolutionHours().selectCreateTime().selectUpdateTime().selectVersion();
    }


    public SlaRequest<T> selectId(){
       selectProperty(Sla.ID_PROPERTY);
       return this;
    }

    /**
     * fill the id with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  id) to fetch id property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public SlaRequest<T> unselectId(){
       unselectProperty(Sla.ID_PROPERTY);
       return this;
    }
    public SlaRequest<T> selectIsActive(){
       selectProperty(Sla.IS_ACTIVE_PROPERTY);
       return this;
    }

    /**
     * fill the isActive with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  isActive) to fetch isActive property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public SlaRequest<T> unselectIsActive(){
       unselectProperty(Sla.IS_ACTIVE_PROPERTY);
       return this;
    }
    public SlaRequest<T> selectPriorityLevel(){
       selectProperty(Sla.PRIORITY_LEVEL_PROPERTY);
       return this;
    }

    /**
     * fill the priorityLevel with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  priorityLevel) to fetch priorityLevel property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public SlaRequest<T> unselectPriorityLevel(){
       unselectProperty(Sla.PRIORITY_LEVEL_PROPERTY);
       return this;
    }
    public SlaRequest<T> selectResolutionHours(){
       selectProperty(Sla.RESOLUTION_HOURS_PROPERTY);
       return this;
    }

    /**
     * fill the resolutionHours with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  resolutionHours) to fetch resolutionHours property.
     * @param rawSqlSegment  customized rawSqlSegment
     */


    /**
     * fill the resolutionHours with customized aggrFunction, TEAQL uses ({aggrFunction}(resolutionHours) AS resolutionHours to fetch resolutionHours property.
     * @param aggrFunction  aggrFunction
     */
    public SlaRequest<T> selectResolutionHours(AggrFunction aggrFunction){
       selectProperty(Sla.RESOLUTION_HOURS_PROPERTY, aggrFunction);
       return this;
    }


    public SlaRequest<T> unselectResolutionHours(){
       unselectProperty(Sla.RESOLUTION_HOURS_PROPERTY);
       return this;
    }
    public SlaRequest<T> selectCreateTime(){
       selectProperty(Sla.CREATE_TIME_PROPERTY);
       return this;
    }

    /**
     * fill the createTime with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  createTime) to fetch createTime property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public SlaRequest<T> unselectCreateTime(){
       unselectProperty(Sla.CREATE_TIME_PROPERTY);
       return this;
    }
    public SlaRequest<T> selectUpdateTime(){
       selectProperty(Sla.UPDATE_TIME_PROPERTY);
       return this;
    }

    /**
     * fill the updateTime with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  updateTime) to fetch updateTime property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public SlaRequest<T> unselectUpdateTime(){
       unselectProperty(Sla.UPDATE_TIME_PROPERTY);
       return this;
    }
    public SlaRequest<T> selectVersion(){
       selectProperty(Sla.VERSION_PROPERTY);
       return this;
    }

    /**
     * fill the version with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  version) to fetch version property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public SlaRequest<T> unselectVersion(){
       unselectProperty(Sla.VERSION_PROPERTY);
       return this;
    }

    public SlaRequest<T> withId(Operator operator, Object... values){
       return appendSearchCriteria(createIdCriteria(operator, values));
    }

    public SearchCriteria createIdCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Sla.ID_PROPERTY, operator, values);
    }

    public SlaRequest<T> withIdIs(Long id){
       return withId(Operator.EQUAL, id);
    }
    public SlaRequest<T> withIdIn(Long... id){
       return withId(Operator.EQUAL, (Object[])id);
    }



    public SlaRequest<T> filterByIsActive(Boolean... isActive){
      if (isActive == null || isActive.length == 0) {
        throw new IllegalArgumentException("filterByIsActive parameter isActive cannot be empty");
      }
      return appendSearchCriteria(createIsActiveCriteria(Operator.EQUAL, (Object[])isActive));
    }

    public SlaRequest<T> withIsActive(Operator operator, Object... values){
       return appendSearchCriteria(createIsActiveCriteria(operator, values));
    }

    public SlaRequest<T> withIsActiveIsUnknown(){
       return withIsActive(Operator.IS_NULL);
    }

    public SlaRequest<T> withIsActiveIsKnown(){
       return withIsActive(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createIsActiveCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Sla.IS_ACTIVE_PROPERTY, operator, values);
    }

    public SlaRequest<T> whichIsIsActive(){
       return withIsActive(Operator.EQUAL, true);
    }

    public SlaRequest<T> whichIsNotIsActive(){
       return withIsActive(Operator.EQUAL, false);
    }


    public SlaRequest<T> filterByPriorityLevel(String... priorityLevel){
      if (priorityLevel == null || priorityLevel.length == 0) {
        throw new IllegalArgumentException("filterByPriorityLevel parameter priorityLevel cannot be empty");
      }
      return appendSearchCriteria(createPriorityLevelCriteria(Operator.EQUAL, (Object[])priorityLevel));
    }

    public SlaRequest<T> withPriorityLevel(Operator operator, Object... values){
       return appendSearchCriteria(createPriorityLevelCriteria(operator, values));
    }

    public SlaRequest<T> withPriorityLevelIsUnknown(){
       return withPriorityLevel(Operator.IS_NULL);
    }

    public SlaRequest<T> withPriorityLevelIsKnown(){
       return withPriorityLevel(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createPriorityLevelCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Sla.PRIORITY_LEVEL_PROPERTY, operator, values);
    }

    public SlaRequest<T> withPriorityLevelGreaterThan(String priorityLevel){
       return withPriorityLevel(Operator.GREATER_THAN, priorityLevel);
    }

    public SlaRequest<T> withPriorityLevelGreaterThanOrEqualTo(String priorityLevel){
       return withPriorityLevel(Operator.GREATER_THAN_OR_EQUAL, priorityLevel);
    }

    public SlaRequest<T> withPriorityLevelLessThan(String priorityLevel){
       return withPriorityLevel(Operator.LESS_THAN, priorityLevel);
    }

    public SlaRequest<T> withPriorityLevelLessThanOrEqualTo(String priorityLevel){
       return withPriorityLevel(Operator.LESS_THAN_OR_EQUAL, priorityLevel);
    }

    public SlaRequest<T> withPriorityLevelBetween(String startOfPriorityLevel, String endOfPriorityLevel){
       return withPriorityLevel(Operator.BETWEEN, startOfPriorityLevel, endOfPriorityLevel);
    }
    public SlaRequest<T> withPriorityLevelStartingWith(String priorityLevel){
       return withPriorityLevel(Operator.BEGIN_WITH, priorityLevel);
    }
    public SlaRequest<T> withPriorityLevelContaining(String priorityLevel){
       return withPriorityLevel(Operator.CONTAIN, priorityLevel);
    }

    public SlaRequest<T> withPriorityLevelEndingWith(String priorityLevel){
       return withPriorityLevel(Operator.END_WITH, priorityLevel);
    }

    public SlaRequest<T> withPriorityLevelIs(String priorityLevel){
       return withPriorityLevel(Operator.EQUAL, priorityLevel);
    }

    public SlaRequest<T> withPriorityLevelSoundingLike(String priorityLevel){
       return withPriorityLevel(Operator.SOUNDS_LIKE, priorityLevel);
    }



    public SlaRequest<T> filterByResolutionHours(BigDecimal... resolutionHours){
      if (resolutionHours == null || resolutionHours.length == 0) {
        throw new IllegalArgumentException("filterByResolutionHours parameter resolutionHours cannot be empty");
      }
      return appendSearchCriteria(createResolutionHoursCriteria(Operator.EQUAL, (Object[])resolutionHours));
    }

    public SlaRequest<T> withResolutionHours(Operator operator, Object... values){
       return appendSearchCriteria(createResolutionHoursCriteria(operator, values));
    }

    public SlaRequest<T> withResolutionHoursIsUnknown(){
       return withResolutionHours(Operator.IS_NULL);
    }

    public SlaRequest<T> withResolutionHoursIsKnown(){
       return withResolutionHours(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createResolutionHoursCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Sla.RESOLUTION_HOURS_PROPERTY, operator, values);
    }

    public SlaRequest<T> withResolutionHoursGreaterThan(BigDecimal resolutionHours){
       return withResolutionHours(Operator.GREATER_THAN, resolutionHours);
    }

    public SlaRequest<T> withResolutionHoursGreaterThanOrEqualTo(BigDecimal resolutionHours){
       return withResolutionHours(Operator.GREATER_THAN_OR_EQUAL, resolutionHours);
    }

    public SlaRequest<T> withResolutionHoursLessThan(BigDecimal resolutionHours){
       return withResolutionHours(Operator.LESS_THAN, resolutionHours);
    }

    public SlaRequest<T> withResolutionHoursLessThanOrEqualTo(BigDecimal resolutionHours){
       return withResolutionHours(Operator.LESS_THAN_OR_EQUAL, resolutionHours);
    }

    public SlaRequest<T> withResolutionHoursBetween(BigDecimal startOfResolutionHours, BigDecimal endOfResolutionHours){
       return withResolutionHours(Operator.BETWEEN, startOfResolutionHours, endOfResolutionHours);
    }



    public SlaRequest<T> filterByCreateTime(LocalDateTime... createTime){
      if (createTime == null || createTime.length == 0) {
        throw new IllegalArgumentException("filterByCreateTime parameter createTime cannot be empty");
      }
      return appendSearchCriteria(createCreateTimeCriteria(Operator.EQUAL, (Object[])createTime));
    }

    public SlaRequest<T> withCreateTime(Operator operator, Object... values){
       return appendSearchCriteria(createCreateTimeCriteria(operator, values));
    }

    public SlaRequest<T> withCreateTimeIsUnknown(){
       return withCreateTime(Operator.IS_NULL);
    }

    public SlaRequest<T> withCreateTimeIsKnown(){
       return withCreateTime(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createCreateTimeCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Sla.CREATE_TIME_PROPERTY, operator, values);
    }

    public SlaRequest<T> withCreateTimeGreaterThan(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public SlaRequest<T> withCreateTimeGreaterThanOrEqualTo(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN_OR_EQUAL, createTime);
    }

    public SlaRequest<T> withCreateTimeLessThan(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public SlaRequest<T> withCreateTimeLessThanOrEqualTo(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN_OR_EQUAL, createTime);
    }

    public SlaRequest<T> withCreateTimeBetween(LocalDateTime startOfCreateTime, LocalDateTime endOfCreateTime){
       return withCreateTime(Operator.BETWEEN, startOfCreateTime, endOfCreateTime);
    }
    public SlaRequest<T> withCreateTimeBefore(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public SlaRequest<T> withCreateTimeBefore(Date createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public SlaRequest<T> withCreateTimeAfter(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public SlaRequest<T> withCreateTimeAfter(Date createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public SlaRequest<T> withCreateTimeBetween(Date startOfCreateTime, Date endOfCreateTime){
       return withCreateTime(Operator.BETWEEN, startOfCreateTime, endOfCreateTime);
    }




    public SlaRequest<T> filterByUpdateTime(LocalDateTime... updateTime){
      if (updateTime == null || updateTime.length == 0) {
        throw new IllegalArgumentException("filterByUpdateTime parameter updateTime cannot be empty");
      }
      return appendSearchCriteria(createUpdateTimeCriteria(Operator.EQUAL, (Object[])updateTime));
    }

    public SlaRequest<T> withUpdateTime(Operator operator, Object... values){
       return appendSearchCriteria(createUpdateTimeCriteria(operator, values));
    }

    public SlaRequest<T> withUpdateTimeIsUnknown(){
       return withUpdateTime(Operator.IS_NULL);
    }

    public SlaRequest<T> withUpdateTimeIsKnown(){
       return withUpdateTime(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createUpdateTimeCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Sla.UPDATE_TIME_PROPERTY, operator, values);
    }

    public SlaRequest<T> withUpdateTimeGreaterThan(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public SlaRequest<T> withUpdateTimeGreaterThanOrEqualTo(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN_OR_EQUAL, updateTime);
    }

    public SlaRequest<T> withUpdateTimeLessThan(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public SlaRequest<T> withUpdateTimeLessThanOrEqualTo(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN_OR_EQUAL, updateTime);
    }

    public SlaRequest<T> withUpdateTimeBetween(LocalDateTime startOfUpdateTime, LocalDateTime endOfUpdateTime){
       return withUpdateTime(Operator.BETWEEN, startOfUpdateTime, endOfUpdateTime);
    }
    public SlaRequest<T> withUpdateTimeBefore(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public SlaRequest<T> withUpdateTimeBefore(Date updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public SlaRequest<T> withUpdateTimeAfter(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public SlaRequest<T> withUpdateTimeAfter(Date updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public SlaRequest<T> withUpdateTimeBetween(Date startOfUpdateTime, Date endOfUpdateTime){
       return withUpdateTime(Operator.BETWEEN, startOfUpdateTime, endOfUpdateTime);
    }




    public SlaRequest<T> filterByVersion(Long... version){
      if (version == null || version.length == 0) {
        throw new IllegalArgumentException("filterByVersion parameter version cannot be empty");
      }
      return appendSearchCriteria(createVersionCriteria(Operator.EQUAL, (Object[])version));
    }

    public SlaRequest<T> withVersion(Operator operator, Object... values){
       return appendSearchCriteria(createVersionCriteria(operator, values));
    }

    public SlaRequest<T> withVersionIsUnknown(){
       return withVersion(Operator.IS_NULL);
    }

    public SlaRequest<T> withVersionIsKnown(){
       return withVersion(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createVersionCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Sla.VERSION_PROPERTY, operator, values);
    }

    public SlaRequest<T> withVersionGreaterThan(Long version){
       return withVersion(Operator.GREATER_THAN, version);
    }

    public SlaRequest<T> withVersionGreaterThanOrEqualTo(Long version){
       return withVersion(Operator.GREATER_THAN_OR_EQUAL, version);
    }

    public SlaRequest<T> withVersionLessThan(Long version){
       return withVersion(Operator.LESS_THAN, version);
    }

    public SlaRequest<T> withVersionLessThanOrEqualTo(Long version){
       return withVersion(Operator.LESS_THAN_OR_EQUAL, version);
    }

    public SlaRequest<T> withVersionBetween(Long startOfVersion, Long endOfVersion){
       return withVersion(Operator.BETWEEN, startOfVersion, endOfVersion);
    }


    public SlaRequest<T> count(){
        super.count();
        return this;
    }
    public SlaRequest<T> countAs(String retName){
        super.count(retName);
        return this;
    }
    public SlaRequest minResolutionHours(){
        return minResolutionHoursAs(prefix("minOf",Sla.RESOLUTION_HOURS_PROPERTY));
    }

    public SlaRequest minResolutionHoursAs(String retName){
        super.min(retName, Sla.RESOLUTION_HOURS_PROPERTY);
        return this;
    }
    public SlaRequest maxResolutionHours(){
        return maxResolutionHoursAs(prefix("maxOf",Sla.RESOLUTION_HOURS_PROPERTY));
    }

    public SlaRequest maxResolutionHoursAs(String retName){
        super.max(retName, Sla.RESOLUTION_HOURS_PROPERTY);
        return this;
    }
    public SlaRequest sumResolutionHours(){
        return sumResolutionHoursAs(prefix("sumOf",Sla.RESOLUTION_HOURS_PROPERTY));
    }

    public SlaRequest sumResolutionHoursAs(String retName){
        super.sum(retName, Sla.RESOLUTION_HOURS_PROPERTY);
        return this;
    }
    public SlaRequest avgResolutionHours(){
        return avgResolutionHoursAs(prefix("avgOf",Sla.RESOLUTION_HOURS_PROPERTY));
    }

    public SlaRequest avgResolutionHoursAs(String retName){
        super.avg(retName, Sla.RESOLUTION_HOURS_PROPERTY);
        return this;
    }
    public SlaRequest standardDeviationResolutionHours(){
        return standardDeviationResolutionHoursAs(prefix("standardDeviationOf",Sla.RESOLUTION_HOURS_PROPERTY));
    }

    public SlaRequest standardDeviationResolutionHoursAs(String retName){
        super.standardDeviation(retName, Sla.RESOLUTION_HOURS_PROPERTY);
        return this;
    }
    public SlaRequest squareRootOfPopulationStandardDeviationResolutionHours(){
        return squareRootOfPopulationStandardDeviationResolutionHoursAs(prefix("squareRootOfPopulationStandardDeviationOf",Sla.RESOLUTION_HOURS_PROPERTY));
    }

    public SlaRequest squareRootOfPopulationStandardDeviationResolutionHoursAs(String retName){
        super.squareRootOfPopulationStandardDeviation(retName, Sla.RESOLUTION_HOURS_PROPERTY);
        return this;
    }
    public SlaRequest sampleVarianceResolutionHours(){
        return sampleVarianceResolutionHoursAs(prefix("sampleVarianceOf",Sla.RESOLUTION_HOURS_PROPERTY));
    }

    public SlaRequest sampleVarianceResolutionHoursAs(String retName){
        super.sampleVariance(retName, Sla.RESOLUTION_HOURS_PROPERTY);
        return this;
    }
    public SlaRequest samplePopulationVarianceResolutionHours(){
        return samplePopulationVarianceResolutionHoursAs(prefix("samplePopulationVarianceOf",Sla.RESOLUTION_HOURS_PROPERTY));
    }

    public SlaRequest samplePopulationVarianceResolutionHoursAs(String retName){
        super.samplePopulationVariance(retName, Sla.RESOLUTION_HOURS_PROPERTY);
        return this;
    }

    public SlaRequest<T> groupById(){
       groupBy(Sla.ID_PROPERTY);
       return this;
    }

    public SlaRequest<T> groupByIdAs(String retName){
       groupBy(retName, Sla.ID_PROPERTY);
       return this;
    }

    public SlaRequest<T> groupByIdWithFunction(String retName, AggrFunction function){
       groupBy(retName, Sla.ID_PROPERTY, function);
       return this;
    }

    public SlaRequest<T> groupByIsActive(){
       groupBy(Sla.IS_ACTIVE_PROPERTY);
       return this;
    }

    public SlaRequest<T> groupByIsActiveAs(String retName){
       groupBy(retName, Sla.IS_ACTIVE_PROPERTY);
       return this;
    }

    public SlaRequest<T> groupByIsActiveWithFunction(String retName, AggrFunction function){
       groupBy(retName, Sla.IS_ACTIVE_PROPERTY, function);
       return this;
    }

    public SlaRequest<T> groupByPriorityLevel(){
       groupBy(Sla.PRIORITY_LEVEL_PROPERTY);
       return this;
    }

    public SlaRequest<T> groupByPriorityLevelAs(String retName){
       groupBy(retName, Sla.PRIORITY_LEVEL_PROPERTY);
       return this;
    }

    public SlaRequest<T> groupByPriorityLevelWithFunction(String retName, AggrFunction function){
       groupBy(retName, Sla.PRIORITY_LEVEL_PROPERTY, function);
       return this;
    }

    public SlaRequest<T> groupByResolutionHours(){
       groupBy(Sla.RESOLUTION_HOURS_PROPERTY);
       return this;
    }

    public SlaRequest<T> groupByResolutionHoursAs(String retName){
       groupBy(retName, Sla.RESOLUTION_HOURS_PROPERTY);
       return this;
    }

    public SlaRequest<T> groupByResolutionHoursWithFunction(String retName, AggrFunction function){
       groupBy(retName, Sla.RESOLUTION_HOURS_PROPERTY, function);
       return this;
    }

    public SlaRequest<T> groupByCreateTime(){
       groupBy(Sla.CREATE_TIME_PROPERTY);
       return this;
    }

    public SlaRequest<T> groupByCreateTimeAs(String retName){
       groupBy(retName, Sla.CREATE_TIME_PROPERTY);
       return this;
    }

    public SlaRequest<T> groupByCreateTimeWithFunction(String retName, AggrFunction function){
       groupBy(retName, Sla.CREATE_TIME_PROPERTY, function);
       return this;
    }

    public SlaRequest<T> groupByUpdateTime(){
       groupBy(Sla.UPDATE_TIME_PROPERTY);
       return this;
    }

    public SlaRequest<T> groupByUpdateTimeAs(String retName){
       groupBy(retName, Sla.UPDATE_TIME_PROPERTY);
       return this;
    }

    public SlaRequest<T> groupByUpdateTimeWithFunction(String retName, AggrFunction function){
       groupBy(retName, Sla.UPDATE_TIME_PROPERTY, function);
       return this;
    }

    public SlaRequest<T> groupByVersion(){
       groupBy(Sla.VERSION_PROPERTY);
       return this;
    }

    public SlaRequest<T> groupByVersionAs(String retName){
       groupBy(retName, Sla.VERSION_PROPERTY);
       return this;
    }

    public SlaRequest<T> groupByVersionWithFunction(String retName, AggrFunction function){
       groupBy(retName, Sla.VERSION_PROPERTY, function);
       return this;
    }



    public SlaRequest<T> orderByIdAscending(){
       addOrderByAscending(Sla.ID_PROPERTY);
       return this;
    }

    public SlaRequest<T> orderByIdDescending(){
       addOrderByDescending(Sla.ID_PROPERTY);
       return this;
    }

    public SlaRequest<T> orderByIsActiveAscending(){
       addOrderByAscending(Sla.IS_ACTIVE_PROPERTY);
       return this;
    }

    public SlaRequest<T> orderByIsActiveDescending(){
       addOrderByDescending(Sla.IS_ACTIVE_PROPERTY);
       return this;
    }

    public SlaRequest<T> orderByPriorityLevelAscending(){
       addOrderByAscending(Sla.PRIORITY_LEVEL_PROPERTY);
       return this;
    }

    public SlaRequest<T> orderByPriorityLevelDescending(){
       addOrderByDescending(Sla.PRIORITY_LEVEL_PROPERTY);
       return this;
    }
    public SlaRequest<T> orderByPriorityLevelAscendingUsingGBK(){
       addOrderByAscendingUsingGBK(Sla.PRIORITY_LEVEL_PROPERTY);
       return this;
    }

    public SlaRequest<T> orderByPriorityLevelDescendingUsingGBK(){
       addOrderByDescendingUsingGBK(Sla.PRIORITY_LEVEL_PROPERTY);
       return this;
    }
    public SlaRequest<T> orderByResolutionHoursAscending(){
       addOrderByAscending(Sla.RESOLUTION_HOURS_PROPERTY);
       return this;
    }

    public SlaRequest<T> orderByResolutionHoursDescending(){
       addOrderByDescending(Sla.RESOLUTION_HOURS_PROPERTY);
       return this;
    }

    public SlaRequest<T> orderByCreateTimeAscending(){
       addOrderByAscending(Sla.CREATE_TIME_PROPERTY);
       return this;
    }

    public SlaRequest<T> orderByCreateTimeDescending(){
       addOrderByDescending(Sla.CREATE_TIME_PROPERTY);
       return this;
    }

    public SlaRequest<T> orderByUpdateTimeAscending(){
       addOrderByAscending(Sla.UPDATE_TIME_PROPERTY);
       return this;
    }

    public SlaRequest<T> orderByUpdateTimeDescending(){
       addOrderByDescending(Sla.UPDATE_TIME_PROPERTY);
       return this;
    }

    public SlaRequest<T> orderByVersionAscending(){
       addOrderByAscending(Sla.VERSION_PROPERTY);
       return this;
    }

    public SlaRequest<T> orderByVersionDescending(){
       addOrderByDescending(Sla.VERSION_PROPERTY);
       return this;
    }





    /**
     * get topN records
     * @param topN  records number
     */
    public SlaRequest<T> top(int topN) {
        super.top(topN);
        return this;
    }

    /**
     * get records from offset(inclusive) to offset+size(exclusive)
     * @param offset record offset
     * @param size records number
     */
    public SlaRequest<T> offset(int offset, int size) {
        super.offset(offset, size);
        return this;
    }

    /**
     * retrieve all records
     */
    public SlaRequest<T> unlimited() {
        super.unlimited();
        return this;
    }

    /**
     * get records of one page
     * @param pageNumber page number(1-based)
     * @param pageSize page size
     */
    public SlaRequest<T> page(int pageNumber, int pageSize) {
        int offset = (pageNumber - 1) * pageSize;
        return offset(offset, pageSize);
   }

    /**
     * get records of one page, default page size is 10
     * @param pageNumber page number(1-based)
     */
    public SlaRequest<T> page(int pageNumber) {
        return page(pageNumber, 10);
   }
}