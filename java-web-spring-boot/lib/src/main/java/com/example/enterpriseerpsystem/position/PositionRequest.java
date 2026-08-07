
package com.example.enterpriseerpsystem.position;

import io.teaql.core.AggrFunction;
import io.teaql.core.BaseRequest;
import io.teaql.core.PropertyReference;
import io.teaql.core.SearchCriteria;
import io.teaql.core.criteria.Operator;
import io.teaql.core.criteria.TwoOperatorCriteria;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

public class PositionRequest<T extends Position> extends BaseRequest<T> {

    /**
     * @deprecated AI agents and business code must use the generated Q facade
     *             instead of constructing request builders directly.
     */
    @Deprecated
    public PositionRequest(Class<T> returnType){
        super(returnType);
        selectId();
        selectVersion();
    }

    public PositionRequest<T> comment(String comment){
         super.internalComment(comment);
         return this;
    }

    // purpose() 继承自 BaseRequest，返回 ExecutableRequest（终结方法）

    public PositionRequest<T> returnType(Class<? extends T> returnType){
        super.setReturnType(returnType);
        return this;
    }

    public PositionRequest<T> enableAggregationCache(long cacheExpiredMillis){
        super.enableAggregationCache();
        super.aggregateCacheTime(cacheExpiredMillis);
        return this;
    }

    public PositionRequest<T> enableAggregationCache(){
        return enableAggregationCache(0l);
    }


    public PositionRequest<T> propagateAggregationCache(long cacheExpiredMillis){
        super.propagateAggregationCache(cacheExpiredMillis);
        return this;
    }

    public PositionRequest<T> appendSearchCriteria(SearchCriteria searchCriteria){
        return (PositionRequest<T>)super.appendSearchCriteria(searchCriteria);
    }

    public PositionRequest<T> filter(String property1, Operator operator, String property2){
        return appendSearchCriteria(new TwoOperatorCriteria(operator, new PropertyReference(property1), new PropertyReference(property2)));
    }


    public PositionRequest<T> matchingAnyOf(PositionRequest position){
        super.internalMatchAny(position);
        return this;
    }

    public PositionRequest<T> enhanceChildrenIfNeeded(){
        return this;
    }

    public PositionRequest<T> withDeletedRows(){
        super.withDeletedRows();
        return this;
    }

    public PositionRequest<T> deletedRowsOnly(){
        super.deletedRowsOnly();
        return this;
    }

    public PositionRequest<T> selectSelf(){
        super.selectSelf();
        return selectId().selectMaxSalary().selectMinSalary().selectTitle().selectCreateTime().selectUpdateTime().selectVersion();
    }

    public PositionRequest<T> selectSelfFields(){
        return selectSelf();
    }

    public PositionRequest<T> selectAll(){
        super.selectAll();
        return selectId().selectMaxSalary().selectMinSalary().selectTitle().selectCreateTime().selectUpdateTime().selectVersion();
    }

    public PositionRequest<T> selectChildren(){
        super.selectAny();
        return selectId().selectMaxSalary().selectMinSalary().selectTitle().selectCreateTime().selectUpdateTime().selectVersion();
    }


    public PositionRequest<T> selectId(){
       selectProperty(Position.ID_PROPERTY);
       return this;
    }

    /**
     * fill the id with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  id) to fetch id property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public PositionRequest<T> unselectId(){
       unselectProperty(Position.ID_PROPERTY);
       return this;
    }
    public PositionRequest<T> selectMaxSalary(){
       selectProperty(Position.MAX_SALARY_PROPERTY);
       return this;
    }

    /**
     * fill the maxSalary with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  maxSalary) to fetch maxSalary property.
     * @param rawSqlSegment  customized rawSqlSegment
     */


    /**
     * fill the maxSalary with customized aggrFunction, TEAQL uses ({aggrFunction}(maxSalary) AS maxSalary to fetch maxSalary property.
     * @param aggrFunction  aggrFunction
     */
    public PositionRequest<T> selectMaxSalary(AggrFunction aggrFunction){
       selectProperty(Position.MAX_SALARY_PROPERTY, aggrFunction);
       return this;
    }


    public PositionRequest<T> unselectMaxSalary(){
       unselectProperty(Position.MAX_SALARY_PROPERTY);
       return this;
    }
    public PositionRequest<T> selectMinSalary(){
       selectProperty(Position.MIN_SALARY_PROPERTY);
       return this;
    }

    /**
     * fill the minSalary with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  minSalary) to fetch minSalary property.
     * @param rawSqlSegment  customized rawSqlSegment
     */


    /**
     * fill the minSalary with customized aggrFunction, TEAQL uses ({aggrFunction}(minSalary) AS minSalary to fetch minSalary property.
     * @param aggrFunction  aggrFunction
     */
    public PositionRequest<T> selectMinSalary(AggrFunction aggrFunction){
       selectProperty(Position.MIN_SALARY_PROPERTY, aggrFunction);
       return this;
    }


    public PositionRequest<T> unselectMinSalary(){
       unselectProperty(Position.MIN_SALARY_PROPERTY);
       return this;
    }
    public PositionRequest<T> selectTitle(){
       selectProperty(Position.TITLE_PROPERTY);
       return this;
    }

    /**
     * fill the title with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  title) to fetch title property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public PositionRequest<T> unselectTitle(){
       unselectProperty(Position.TITLE_PROPERTY);
       return this;
    }
    public PositionRequest<T> selectCreateTime(){
       selectProperty(Position.CREATE_TIME_PROPERTY);
       return this;
    }

    /**
     * fill the createTime with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  createTime) to fetch createTime property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public PositionRequest<T> unselectCreateTime(){
       unselectProperty(Position.CREATE_TIME_PROPERTY);
       return this;
    }
    public PositionRequest<T> selectUpdateTime(){
       selectProperty(Position.UPDATE_TIME_PROPERTY);
       return this;
    }

    /**
     * fill the updateTime with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  updateTime) to fetch updateTime property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public PositionRequest<T> unselectUpdateTime(){
       unselectProperty(Position.UPDATE_TIME_PROPERTY);
       return this;
    }
    public PositionRequest<T> selectVersion(){
       selectProperty(Position.VERSION_PROPERTY);
       return this;
    }

    /**
     * fill the version with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  version) to fetch version property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public PositionRequest<T> unselectVersion(){
       unselectProperty(Position.VERSION_PROPERTY);
       return this;
    }

    public PositionRequest<T> withId(Operator operator, Object... values){
       return appendSearchCriteria(createIdCriteria(operator, values));
    }

    public SearchCriteria createIdCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Position.ID_PROPERTY, operator, values);
    }

    public PositionRequest<T> withIdIs(Long id){
       return withId(Operator.EQUAL, id);
    }
    public PositionRequest<T> withIdIn(Long... id){
       return withId(Operator.EQUAL, (Object[])id);
    }



    public PositionRequest<T> filterByMaxSalary(BigDecimal... maxSalary){
      if (maxSalary == null || maxSalary.length == 0) {
        throw new IllegalArgumentException("filterByMaxSalary parameter maxSalary cannot be empty");
      }
      return appendSearchCriteria(createMaxSalaryCriteria(Operator.EQUAL, (Object[])maxSalary));
    }

    public PositionRequest<T> withMaxSalary(Operator operator, Object... values){
       return appendSearchCriteria(createMaxSalaryCriteria(operator, values));
    }

    public PositionRequest<T> withMaxSalaryIsUnknown(){
       return withMaxSalary(Operator.IS_NULL);
    }

    public PositionRequest<T> withMaxSalaryIsKnown(){
       return withMaxSalary(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createMaxSalaryCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Position.MAX_SALARY_PROPERTY, operator, values);
    }

    public PositionRequest<T> withMaxSalaryGreaterThan(BigDecimal maxSalary){
       return withMaxSalary(Operator.GREATER_THAN, maxSalary);
    }

    public PositionRequest<T> withMaxSalaryGreaterThanOrEqualTo(BigDecimal maxSalary){
       return withMaxSalary(Operator.GREATER_THAN_OR_EQUAL, maxSalary);
    }

    public PositionRequest<T> withMaxSalaryLessThan(BigDecimal maxSalary){
       return withMaxSalary(Operator.LESS_THAN, maxSalary);
    }

    public PositionRequest<T> withMaxSalaryLessThanOrEqualTo(BigDecimal maxSalary){
       return withMaxSalary(Operator.LESS_THAN_OR_EQUAL, maxSalary);
    }

    public PositionRequest<T> withMaxSalaryBetween(BigDecimal startOfMaxSalary, BigDecimal endOfMaxSalary){
       return withMaxSalary(Operator.BETWEEN, startOfMaxSalary, endOfMaxSalary);
    }



    public PositionRequest<T> filterByMinSalary(BigDecimal... minSalary){
      if (minSalary == null || minSalary.length == 0) {
        throw new IllegalArgumentException("filterByMinSalary parameter minSalary cannot be empty");
      }
      return appendSearchCriteria(createMinSalaryCriteria(Operator.EQUAL, (Object[])minSalary));
    }

    public PositionRequest<T> withMinSalary(Operator operator, Object... values){
       return appendSearchCriteria(createMinSalaryCriteria(operator, values));
    }

    public PositionRequest<T> withMinSalaryIsUnknown(){
       return withMinSalary(Operator.IS_NULL);
    }

    public PositionRequest<T> withMinSalaryIsKnown(){
       return withMinSalary(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createMinSalaryCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Position.MIN_SALARY_PROPERTY, operator, values);
    }

    public PositionRequest<T> withMinSalaryGreaterThan(BigDecimal minSalary){
       return withMinSalary(Operator.GREATER_THAN, minSalary);
    }

    public PositionRequest<T> withMinSalaryGreaterThanOrEqualTo(BigDecimal minSalary){
       return withMinSalary(Operator.GREATER_THAN_OR_EQUAL, minSalary);
    }

    public PositionRequest<T> withMinSalaryLessThan(BigDecimal minSalary){
       return withMinSalary(Operator.LESS_THAN, minSalary);
    }

    public PositionRequest<T> withMinSalaryLessThanOrEqualTo(BigDecimal minSalary){
       return withMinSalary(Operator.LESS_THAN_OR_EQUAL, minSalary);
    }

    public PositionRequest<T> withMinSalaryBetween(BigDecimal startOfMinSalary, BigDecimal endOfMinSalary){
       return withMinSalary(Operator.BETWEEN, startOfMinSalary, endOfMinSalary);
    }



    public PositionRequest<T> filterByTitle(String... title){
      if (title == null || title.length == 0) {
        throw new IllegalArgumentException("filterByTitle parameter title cannot be empty");
      }
      return appendSearchCriteria(createTitleCriteria(Operator.EQUAL, (Object[])title));
    }

    public PositionRequest<T> withTitle(Operator operator, Object... values){
       return appendSearchCriteria(createTitleCriteria(operator, values));
    }

    public PositionRequest<T> withTitleIsUnknown(){
       return withTitle(Operator.IS_NULL);
    }

    public PositionRequest<T> withTitleIsKnown(){
       return withTitle(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createTitleCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Position.TITLE_PROPERTY, operator, values);
    }

    public PositionRequest<T> withTitleGreaterThan(String title){
       return withTitle(Operator.GREATER_THAN, title);
    }

    public PositionRequest<T> withTitleGreaterThanOrEqualTo(String title){
       return withTitle(Operator.GREATER_THAN_OR_EQUAL, title);
    }

    public PositionRequest<T> withTitleLessThan(String title){
       return withTitle(Operator.LESS_THAN, title);
    }

    public PositionRequest<T> withTitleLessThanOrEqualTo(String title){
       return withTitle(Operator.LESS_THAN_OR_EQUAL, title);
    }

    public PositionRequest<T> withTitleBetween(String startOfTitle, String endOfTitle){
       return withTitle(Operator.BETWEEN, startOfTitle, endOfTitle);
    }
    public PositionRequest<T> withTitleStartingWith(String title){
       return withTitle(Operator.BEGIN_WITH, title);
    }
    public PositionRequest<T> withTitleContaining(String title){
       return withTitle(Operator.CONTAIN, title);
    }

    public PositionRequest<T> withTitleEndingWith(String title){
       return withTitle(Operator.END_WITH, title);
    }

    public PositionRequest<T> withTitleIs(String title){
       return withTitle(Operator.EQUAL, title);
    }

    public PositionRequest<T> withTitleSoundingLike(String title){
       return withTitle(Operator.SOUNDS_LIKE, title);
    }



    public PositionRequest<T> filterByCreateTime(LocalDateTime... createTime){
      if (createTime == null || createTime.length == 0) {
        throw new IllegalArgumentException("filterByCreateTime parameter createTime cannot be empty");
      }
      return appendSearchCriteria(createCreateTimeCriteria(Operator.EQUAL, (Object[])createTime));
    }

    public PositionRequest<T> withCreateTime(Operator operator, Object... values){
       return appendSearchCriteria(createCreateTimeCriteria(operator, values));
    }

    public PositionRequest<T> withCreateTimeIsUnknown(){
       return withCreateTime(Operator.IS_NULL);
    }

    public PositionRequest<T> withCreateTimeIsKnown(){
       return withCreateTime(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createCreateTimeCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Position.CREATE_TIME_PROPERTY, operator, values);
    }

    public PositionRequest<T> withCreateTimeGreaterThan(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public PositionRequest<T> withCreateTimeGreaterThanOrEqualTo(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN_OR_EQUAL, createTime);
    }

    public PositionRequest<T> withCreateTimeLessThan(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public PositionRequest<T> withCreateTimeLessThanOrEqualTo(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN_OR_EQUAL, createTime);
    }

    public PositionRequest<T> withCreateTimeBetween(LocalDateTime startOfCreateTime, LocalDateTime endOfCreateTime){
       return withCreateTime(Operator.BETWEEN, startOfCreateTime, endOfCreateTime);
    }
    public PositionRequest<T> withCreateTimeBefore(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public PositionRequest<T> withCreateTimeBefore(Date createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public PositionRequest<T> withCreateTimeAfter(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public PositionRequest<T> withCreateTimeAfter(Date createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public PositionRequest<T> withCreateTimeBetween(Date startOfCreateTime, Date endOfCreateTime){
       return withCreateTime(Operator.BETWEEN, startOfCreateTime, endOfCreateTime);
    }




    public PositionRequest<T> filterByUpdateTime(LocalDateTime... updateTime){
      if (updateTime == null || updateTime.length == 0) {
        throw new IllegalArgumentException("filterByUpdateTime parameter updateTime cannot be empty");
      }
      return appendSearchCriteria(createUpdateTimeCriteria(Operator.EQUAL, (Object[])updateTime));
    }

    public PositionRequest<T> withUpdateTime(Operator operator, Object... values){
       return appendSearchCriteria(createUpdateTimeCriteria(operator, values));
    }

    public PositionRequest<T> withUpdateTimeIsUnknown(){
       return withUpdateTime(Operator.IS_NULL);
    }

    public PositionRequest<T> withUpdateTimeIsKnown(){
       return withUpdateTime(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createUpdateTimeCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Position.UPDATE_TIME_PROPERTY, operator, values);
    }

    public PositionRequest<T> withUpdateTimeGreaterThan(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public PositionRequest<T> withUpdateTimeGreaterThanOrEqualTo(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN_OR_EQUAL, updateTime);
    }

    public PositionRequest<T> withUpdateTimeLessThan(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public PositionRequest<T> withUpdateTimeLessThanOrEqualTo(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN_OR_EQUAL, updateTime);
    }

    public PositionRequest<T> withUpdateTimeBetween(LocalDateTime startOfUpdateTime, LocalDateTime endOfUpdateTime){
       return withUpdateTime(Operator.BETWEEN, startOfUpdateTime, endOfUpdateTime);
    }
    public PositionRequest<T> withUpdateTimeBefore(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public PositionRequest<T> withUpdateTimeBefore(Date updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public PositionRequest<T> withUpdateTimeAfter(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public PositionRequest<T> withUpdateTimeAfter(Date updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public PositionRequest<T> withUpdateTimeBetween(Date startOfUpdateTime, Date endOfUpdateTime){
       return withUpdateTime(Operator.BETWEEN, startOfUpdateTime, endOfUpdateTime);
    }




    public PositionRequest<T> filterByVersion(Long... version){
      if (version == null || version.length == 0) {
        throw new IllegalArgumentException("filterByVersion parameter version cannot be empty");
      }
      return appendSearchCriteria(createVersionCriteria(Operator.EQUAL, (Object[])version));
    }

    public PositionRequest<T> withVersion(Operator operator, Object... values){
       return appendSearchCriteria(createVersionCriteria(operator, values));
    }

    public PositionRequest<T> withVersionIsUnknown(){
       return withVersion(Operator.IS_NULL);
    }

    public PositionRequest<T> withVersionIsKnown(){
       return withVersion(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createVersionCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Position.VERSION_PROPERTY, operator, values);
    }

    public PositionRequest<T> withVersionGreaterThan(Long version){
       return withVersion(Operator.GREATER_THAN, version);
    }

    public PositionRequest<T> withVersionGreaterThanOrEqualTo(Long version){
       return withVersion(Operator.GREATER_THAN_OR_EQUAL, version);
    }

    public PositionRequest<T> withVersionLessThan(Long version){
       return withVersion(Operator.LESS_THAN, version);
    }

    public PositionRequest<T> withVersionLessThanOrEqualTo(Long version){
       return withVersion(Operator.LESS_THAN_OR_EQUAL, version);
    }

    public PositionRequest<T> withVersionBetween(Long startOfVersion, Long endOfVersion){
       return withVersion(Operator.BETWEEN, startOfVersion, endOfVersion);
    }


    public PositionRequest<T> count(){
        super.count();
        return this;
    }
    public PositionRequest<T> countAs(String retName){
        super.count(retName);
        return this;
    }
    public PositionRequest minMaxSalary(){
        return minMaxSalaryAs(prefix("minOf",Position.MAX_SALARY_PROPERTY));
    }

    public PositionRequest minMaxSalaryAs(String retName){
        super.min(retName, Position.MAX_SALARY_PROPERTY);
        return this;
    }
    public PositionRequest maxMaxSalary(){
        return maxMaxSalaryAs(prefix("maxOf",Position.MAX_SALARY_PROPERTY));
    }

    public PositionRequest maxMaxSalaryAs(String retName){
        super.max(retName, Position.MAX_SALARY_PROPERTY);
        return this;
    }
    public PositionRequest sumMaxSalary(){
        return sumMaxSalaryAs(prefix("sumOf",Position.MAX_SALARY_PROPERTY));
    }

    public PositionRequest sumMaxSalaryAs(String retName){
        super.sum(retName, Position.MAX_SALARY_PROPERTY);
        return this;
    }
    public PositionRequest avgMaxSalary(){
        return avgMaxSalaryAs(prefix("avgOf",Position.MAX_SALARY_PROPERTY));
    }

    public PositionRequest avgMaxSalaryAs(String retName){
        super.avg(retName, Position.MAX_SALARY_PROPERTY);
        return this;
    }
    public PositionRequest standardDeviationMaxSalary(){
        return standardDeviationMaxSalaryAs(prefix("standardDeviationOf",Position.MAX_SALARY_PROPERTY));
    }

    public PositionRequest standardDeviationMaxSalaryAs(String retName){
        super.standardDeviation(retName, Position.MAX_SALARY_PROPERTY);
        return this;
    }
    public PositionRequest squareRootOfPopulationStandardDeviationMaxSalary(){
        return squareRootOfPopulationStandardDeviationMaxSalaryAs(prefix("squareRootOfPopulationStandardDeviationOf",Position.MAX_SALARY_PROPERTY));
    }

    public PositionRequest squareRootOfPopulationStandardDeviationMaxSalaryAs(String retName){
        super.squareRootOfPopulationStandardDeviation(retName, Position.MAX_SALARY_PROPERTY);
        return this;
    }
    public PositionRequest sampleVarianceMaxSalary(){
        return sampleVarianceMaxSalaryAs(prefix("sampleVarianceOf",Position.MAX_SALARY_PROPERTY));
    }

    public PositionRequest sampleVarianceMaxSalaryAs(String retName){
        super.sampleVariance(retName, Position.MAX_SALARY_PROPERTY);
        return this;
    }
    public PositionRequest samplePopulationVarianceMaxSalary(){
        return samplePopulationVarianceMaxSalaryAs(prefix("samplePopulationVarianceOf",Position.MAX_SALARY_PROPERTY));
    }

    public PositionRequest samplePopulationVarianceMaxSalaryAs(String retName){
        super.samplePopulationVariance(retName, Position.MAX_SALARY_PROPERTY);
        return this;
    }
    public PositionRequest minMinSalary(){
        return minMinSalaryAs(prefix("minOf",Position.MIN_SALARY_PROPERTY));
    }

    public PositionRequest minMinSalaryAs(String retName){
        super.min(retName, Position.MIN_SALARY_PROPERTY);
        return this;
    }
    public PositionRequest maxMinSalary(){
        return maxMinSalaryAs(prefix("maxOf",Position.MIN_SALARY_PROPERTY));
    }

    public PositionRequest maxMinSalaryAs(String retName){
        super.max(retName, Position.MIN_SALARY_PROPERTY);
        return this;
    }
    public PositionRequest sumMinSalary(){
        return sumMinSalaryAs(prefix("sumOf",Position.MIN_SALARY_PROPERTY));
    }

    public PositionRequest sumMinSalaryAs(String retName){
        super.sum(retName, Position.MIN_SALARY_PROPERTY);
        return this;
    }
    public PositionRequest avgMinSalary(){
        return avgMinSalaryAs(prefix("avgOf",Position.MIN_SALARY_PROPERTY));
    }

    public PositionRequest avgMinSalaryAs(String retName){
        super.avg(retName, Position.MIN_SALARY_PROPERTY);
        return this;
    }
    public PositionRequest standardDeviationMinSalary(){
        return standardDeviationMinSalaryAs(prefix("standardDeviationOf",Position.MIN_SALARY_PROPERTY));
    }

    public PositionRequest standardDeviationMinSalaryAs(String retName){
        super.standardDeviation(retName, Position.MIN_SALARY_PROPERTY);
        return this;
    }
    public PositionRequest squareRootOfPopulationStandardDeviationMinSalary(){
        return squareRootOfPopulationStandardDeviationMinSalaryAs(prefix("squareRootOfPopulationStandardDeviationOf",Position.MIN_SALARY_PROPERTY));
    }

    public PositionRequest squareRootOfPopulationStandardDeviationMinSalaryAs(String retName){
        super.squareRootOfPopulationStandardDeviation(retName, Position.MIN_SALARY_PROPERTY);
        return this;
    }
    public PositionRequest sampleVarianceMinSalary(){
        return sampleVarianceMinSalaryAs(prefix("sampleVarianceOf",Position.MIN_SALARY_PROPERTY));
    }

    public PositionRequest sampleVarianceMinSalaryAs(String retName){
        super.sampleVariance(retName, Position.MIN_SALARY_PROPERTY);
        return this;
    }
    public PositionRequest samplePopulationVarianceMinSalary(){
        return samplePopulationVarianceMinSalaryAs(prefix("samplePopulationVarianceOf",Position.MIN_SALARY_PROPERTY));
    }

    public PositionRequest samplePopulationVarianceMinSalaryAs(String retName){
        super.samplePopulationVariance(retName, Position.MIN_SALARY_PROPERTY);
        return this;
    }

    public PositionRequest<T> groupById(){
       groupBy(Position.ID_PROPERTY);
       return this;
    }

    public PositionRequest<T> groupByIdAs(String retName){
       groupBy(retName, Position.ID_PROPERTY);
       return this;
    }

    public PositionRequest<T> groupByIdWithFunction(String retName, AggrFunction function){
       groupBy(retName, Position.ID_PROPERTY, function);
       return this;
    }

    public PositionRequest<T> groupByMaxSalary(){
       groupBy(Position.MAX_SALARY_PROPERTY);
       return this;
    }

    public PositionRequest<T> groupByMaxSalaryAs(String retName){
       groupBy(retName, Position.MAX_SALARY_PROPERTY);
       return this;
    }

    public PositionRequest<T> groupByMaxSalaryWithFunction(String retName, AggrFunction function){
       groupBy(retName, Position.MAX_SALARY_PROPERTY, function);
       return this;
    }

    public PositionRequest<T> groupByMinSalary(){
       groupBy(Position.MIN_SALARY_PROPERTY);
       return this;
    }

    public PositionRequest<T> groupByMinSalaryAs(String retName){
       groupBy(retName, Position.MIN_SALARY_PROPERTY);
       return this;
    }

    public PositionRequest<T> groupByMinSalaryWithFunction(String retName, AggrFunction function){
       groupBy(retName, Position.MIN_SALARY_PROPERTY, function);
       return this;
    }

    public PositionRequest<T> groupByTitle(){
       groupBy(Position.TITLE_PROPERTY);
       return this;
    }

    public PositionRequest<T> groupByTitleAs(String retName){
       groupBy(retName, Position.TITLE_PROPERTY);
       return this;
    }

    public PositionRequest<T> groupByTitleWithFunction(String retName, AggrFunction function){
       groupBy(retName, Position.TITLE_PROPERTY, function);
       return this;
    }

    public PositionRequest<T> groupByCreateTime(){
       groupBy(Position.CREATE_TIME_PROPERTY);
       return this;
    }

    public PositionRequest<T> groupByCreateTimeAs(String retName){
       groupBy(retName, Position.CREATE_TIME_PROPERTY);
       return this;
    }

    public PositionRequest<T> groupByCreateTimeWithFunction(String retName, AggrFunction function){
       groupBy(retName, Position.CREATE_TIME_PROPERTY, function);
       return this;
    }

    public PositionRequest<T> groupByUpdateTime(){
       groupBy(Position.UPDATE_TIME_PROPERTY);
       return this;
    }

    public PositionRequest<T> groupByUpdateTimeAs(String retName){
       groupBy(retName, Position.UPDATE_TIME_PROPERTY);
       return this;
    }

    public PositionRequest<T> groupByUpdateTimeWithFunction(String retName, AggrFunction function){
       groupBy(retName, Position.UPDATE_TIME_PROPERTY, function);
       return this;
    }

    public PositionRequest<T> groupByVersion(){
       groupBy(Position.VERSION_PROPERTY);
       return this;
    }

    public PositionRequest<T> groupByVersionAs(String retName){
       groupBy(retName, Position.VERSION_PROPERTY);
       return this;
    }

    public PositionRequest<T> groupByVersionWithFunction(String retName, AggrFunction function){
       groupBy(retName, Position.VERSION_PROPERTY, function);
       return this;
    }



    public PositionRequest<T> orderByIdAscending(){
       addOrderByAscending(Position.ID_PROPERTY);
       return this;
    }

    public PositionRequest<T> orderByIdDescending(){
       addOrderByDescending(Position.ID_PROPERTY);
       return this;
    }

    public PositionRequest<T> orderByMaxSalaryAscending(){
       addOrderByAscending(Position.MAX_SALARY_PROPERTY);
       return this;
    }

    public PositionRequest<T> orderByMaxSalaryDescending(){
       addOrderByDescending(Position.MAX_SALARY_PROPERTY);
       return this;
    }

    public PositionRequest<T> orderByMinSalaryAscending(){
       addOrderByAscending(Position.MIN_SALARY_PROPERTY);
       return this;
    }

    public PositionRequest<T> orderByMinSalaryDescending(){
       addOrderByDescending(Position.MIN_SALARY_PROPERTY);
       return this;
    }

    public PositionRequest<T> orderByTitleAscending(){
       addOrderByAscending(Position.TITLE_PROPERTY);
       return this;
    }

    public PositionRequest<T> orderByTitleDescending(){
       addOrderByDescending(Position.TITLE_PROPERTY);
       return this;
    }
    public PositionRequest<T> orderByTitleAscendingUsingGBK(){
       addOrderByAscendingUsingGBK(Position.TITLE_PROPERTY);
       return this;
    }

    public PositionRequest<T> orderByTitleDescendingUsingGBK(){
       addOrderByDescendingUsingGBK(Position.TITLE_PROPERTY);
       return this;
    }
    public PositionRequest<T> orderByCreateTimeAscending(){
       addOrderByAscending(Position.CREATE_TIME_PROPERTY);
       return this;
    }

    public PositionRequest<T> orderByCreateTimeDescending(){
       addOrderByDescending(Position.CREATE_TIME_PROPERTY);
       return this;
    }

    public PositionRequest<T> orderByUpdateTimeAscending(){
       addOrderByAscending(Position.UPDATE_TIME_PROPERTY);
       return this;
    }

    public PositionRequest<T> orderByUpdateTimeDescending(){
       addOrderByDescending(Position.UPDATE_TIME_PROPERTY);
       return this;
    }

    public PositionRequest<T> orderByVersionAscending(){
       addOrderByAscending(Position.VERSION_PROPERTY);
       return this;
    }

    public PositionRequest<T> orderByVersionDescending(){
       addOrderByDescending(Position.VERSION_PROPERTY);
       return this;
    }





    /**
     * get topN records
     * @param topN  records number
     */
    public PositionRequest<T> top(int topN) {
        super.top(topN);
        return this;
    }

    /**
     * get records from offset(inclusive) to offset+size(exclusive)
     * @param offset record offset
     * @param size records number
     */
    public PositionRequest<T> offset(int offset, int size) {
        super.offset(offset, size);
        return this;
    }

    /**
     * retrieve all records
     */
    public PositionRequest<T> unlimited() {
        super.unlimited();
        return this;
    }

    /**
     * get records of one page
     * @param pageNumber page number(1-based)
     * @param pageSize page size
     */
    public PositionRequest<T> page(int pageNumber, int pageSize) {
        int offset = (pageNumber - 1) * pageSize;
        return offset(offset, pageSize);
   }

    /**
     * get records of one page, default page size is 10
     * @param pageNumber page number(1-based)
     */
    public PositionRequest<T> page(int pageNumber) {
        return page(pageNumber, 10);
   }
}