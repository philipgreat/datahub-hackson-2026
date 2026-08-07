
package com.example.enterpriseerpsystem.campaign;

import io.teaql.core.AggrFunction;
import io.teaql.core.BaseRequest;
import io.teaql.core.PropertyReference;
import io.teaql.core.SearchCriteria;
import io.teaql.core.criteria.Operator;
import io.teaql.core.criteria.TwoOperatorCriteria;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

public class CampaignRequest<T extends Campaign> extends BaseRequest<T> {

    /**
     * @deprecated AI agents and business code must use the generated Q facade
     *             instead of constructing request builders directly.
     */
    @Deprecated
    public CampaignRequest(Class<T> returnType){
        super(returnType);
        selectId();
        selectVersion();
    }

    public CampaignRequest<T> comment(String comment){
         super.internalComment(comment);
         return this;
    }

    // purpose() 继承自 BaseRequest，返回 ExecutableRequest（终结方法）

    public CampaignRequest<T> returnType(Class<? extends T> returnType){
        super.setReturnType(returnType);
        return this;
    }

    public CampaignRequest<T> enableAggregationCache(long cacheExpiredMillis){
        super.enableAggregationCache();
        super.aggregateCacheTime(cacheExpiredMillis);
        return this;
    }

    public CampaignRequest<T> enableAggregationCache(){
        return enableAggregationCache(0l);
    }


    public CampaignRequest<T> propagateAggregationCache(long cacheExpiredMillis){
        super.propagateAggregationCache(cacheExpiredMillis);
        return this;
    }

    public CampaignRequest<T> appendSearchCriteria(SearchCriteria searchCriteria){
        return (CampaignRequest<T>)super.appendSearchCriteria(searchCriteria);
    }

    public CampaignRequest<T> filter(String property1, Operator operator, String property2){
        return appendSearchCriteria(new TwoOperatorCriteria(operator, new PropertyReference(property1), new PropertyReference(property2)));
    }


    public CampaignRequest<T> matchingAnyOf(CampaignRequest campaign){
        super.internalMatchAny(campaign);
        return this;
    }

    public CampaignRequest<T> enhanceChildrenIfNeeded(){
        return this;
    }

    public CampaignRequest<T> withDeletedRows(){
        super.withDeletedRows();
        return this;
    }

    public CampaignRequest<T> deletedRowsOnly(){
        super.deletedRowsOnly();
        return this;
    }

    public CampaignRequest<T> selectSelf(){
        super.selectSelf();
        return selectId().selectName().selectBudget().selectEndDate().selectStartDate().selectStatus().selectCreateTime().selectUpdateTime().selectVersion();
    }

    public CampaignRequest<T> selectSelfFields(){
        return selectSelf();
    }

    public CampaignRequest<T> selectAll(){
        super.selectAll();
        return selectId().selectName().selectBudget().selectEndDate().selectStartDate().selectStatus().selectCreateTime().selectUpdateTime().selectVersion();
    }

    public CampaignRequest<T> selectChildren(){
        super.selectAny();
        return selectId().selectName().selectBudget().selectEndDate().selectStartDate().selectStatus().selectCreateTime().selectUpdateTime().selectVersion();
    }


    public CampaignRequest<T> selectId(){
       selectProperty(Campaign.ID_PROPERTY);
       return this;
    }

    /**
     * fill the id with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  id) to fetch id property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public CampaignRequest<T> unselectId(){
       unselectProperty(Campaign.ID_PROPERTY);
       return this;
    }
    public CampaignRequest<T> selectName(){
       selectProperty(Campaign.NAME_PROPERTY);
       return this;
    }

    /**
     * fill the name with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  name) to fetch name property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public CampaignRequest<T> unselectName(){
       unselectProperty(Campaign.NAME_PROPERTY);
       return this;
    }
    public CampaignRequest<T> selectBudget(){
       selectProperty(Campaign.BUDGET_PROPERTY);
       return this;
    }

    /**
     * fill the budget with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  budget) to fetch budget property.
     * @param rawSqlSegment  customized rawSqlSegment
     */


    /**
     * fill the budget with customized aggrFunction, TEAQL uses ({aggrFunction}(budget) AS budget to fetch budget property.
     * @param aggrFunction  aggrFunction
     */
    public CampaignRequest<T> selectBudget(AggrFunction aggrFunction){
       selectProperty(Campaign.BUDGET_PROPERTY, aggrFunction);
       return this;
    }


    public CampaignRequest<T> unselectBudget(){
       unselectProperty(Campaign.BUDGET_PROPERTY);
       return this;
    }
    public CampaignRequest<T> selectEndDate(){
       selectProperty(Campaign.END_DATE_PROPERTY);
       return this;
    }

    /**
     * fill the endDate with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  endDate) to fetch endDate property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public CampaignRequest<T> unselectEndDate(){
       unselectProperty(Campaign.END_DATE_PROPERTY);
       return this;
    }
    public CampaignRequest<T> selectStartDate(){
       selectProperty(Campaign.START_DATE_PROPERTY);
       return this;
    }

    /**
     * fill the startDate with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  startDate) to fetch startDate property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public CampaignRequest<T> unselectStartDate(){
       unselectProperty(Campaign.START_DATE_PROPERTY);
       return this;
    }
    public CampaignRequest<T> selectStatus(){
       selectProperty(Campaign.STATUS_PROPERTY);
       return this;
    }

    /**
     * fill the status with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  status) to fetch status property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public CampaignRequest<T> unselectStatus(){
       unselectProperty(Campaign.STATUS_PROPERTY);
       return this;
    }
    public CampaignRequest<T> selectCreateTime(){
       selectProperty(Campaign.CREATE_TIME_PROPERTY);
       return this;
    }

    /**
     * fill the createTime with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  createTime) to fetch createTime property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public CampaignRequest<T> unselectCreateTime(){
       unselectProperty(Campaign.CREATE_TIME_PROPERTY);
       return this;
    }
    public CampaignRequest<T> selectUpdateTime(){
       selectProperty(Campaign.UPDATE_TIME_PROPERTY);
       return this;
    }

    /**
     * fill the updateTime with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  updateTime) to fetch updateTime property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public CampaignRequest<T> unselectUpdateTime(){
       unselectProperty(Campaign.UPDATE_TIME_PROPERTY);
       return this;
    }
    public CampaignRequest<T> selectVersion(){
       selectProperty(Campaign.VERSION_PROPERTY);
       return this;
    }

    /**
     * fill the version with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  version) to fetch version property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public CampaignRequest<T> unselectVersion(){
       unselectProperty(Campaign.VERSION_PROPERTY);
       return this;
    }

    public CampaignRequest<T> withId(Operator operator, Object... values){
       return appendSearchCriteria(createIdCriteria(operator, values));
    }

    public SearchCriteria createIdCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Campaign.ID_PROPERTY, operator, values);
    }

    public CampaignRequest<T> withIdIs(Long id){
       return withId(Operator.EQUAL, id);
    }
    public CampaignRequest<T> withIdIn(Long... id){
       return withId(Operator.EQUAL, (Object[])id);
    }



    public CampaignRequest<T> filterByName(String... name){
      if (name == null || name.length == 0) {
        throw new IllegalArgumentException("filterByName parameter name cannot be empty");
      }
      return appendSearchCriteria(createNameCriteria(Operator.EQUAL, (Object[])name));
    }

    public CampaignRequest<T> withName(Operator operator, Object... values){
       return appendSearchCriteria(createNameCriteria(operator, values));
    }

    public CampaignRequest<T> withNameIsUnknown(){
       return withName(Operator.IS_NULL);
    }

    public CampaignRequest<T> withNameIsKnown(){
       return withName(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createNameCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Campaign.NAME_PROPERTY, operator, values);
    }

    public CampaignRequest<T> withNameGreaterThan(String name){
       return withName(Operator.GREATER_THAN, name);
    }

    public CampaignRequest<T> withNameGreaterThanOrEqualTo(String name){
       return withName(Operator.GREATER_THAN_OR_EQUAL, name);
    }

    public CampaignRequest<T> withNameLessThan(String name){
       return withName(Operator.LESS_THAN, name);
    }

    public CampaignRequest<T> withNameLessThanOrEqualTo(String name){
       return withName(Operator.LESS_THAN_OR_EQUAL, name);
    }

    public CampaignRequest<T> withNameBetween(String startOfName, String endOfName){
       return withName(Operator.BETWEEN, startOfName, endOfName);
    }
    public CampaignRequest<T> withNameStartingWith(String name){
       return withName(Operator.BEGIN_WITH, name);
    }
    public CampaignRequest<T> withNameContaining(String name){
       return withName(Operator.CONTAIN, name);
    }

    public CampaignRequest<T> withNameEndingWith(String name){
       return withName(Operator.END_WITH, name);
    }

    public CampaignRequest<T> withNameIs(String name){
       return withName(Operator.EQUAL, name);
    }

    public CampaignRequest<T> withNameSoundingLike(String name){
       return withName(Operator.SOUNDS_LIKE, name);
    }



    public CampaignRequest<T> filterByBudget(BigDecimal... budget){
      if (budget == null || budget.length == 0) {
        throw new IllegalArgumentException("filterByBudget parameter budget cannot be empty");
      }
      return appendSearchCriteria(createBudgetCriteria(Operator.EQUAL, (Object[])budget));
    }

    public CampaignRequest<T> withBudget(Operator operator, Object... values){
       return appendSearchCriteria(createBudgetCriteria(operator, values));
    }

    public CampaignRequest<T> withBudgetIsUnknown(){
       return withBudget(Operator.IS_NULL);
    }

    public CampaignRequest<T> withBudgetIsKnown(){
       return withBudget(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createBudgetCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Campaign.BUDGET_PROPERTY, operator, values);
    }

    public CampaignRequest<T> withBudgetGreaterThan(BigDecimal budget){
       return withBudget(Operator.GREATER_THAN, budget);
    }

    public CampaignRequest<T> withBudgetGreaterThanOrEqualTo(BigDecimal budget){
       return withBudget(Operator.GREATER_THAN_OR_EQUAL, budget);
    }

    public CampaignRequest<T> withBudgetLessThan(BigDecimal budget){
       return withBudget(Operator.LESS_THAN, budget);
    }

    public CampaignRequest<T> withBudgetLessThanOrEqualTo(BigDecimal budget){
       return withBudget(Operator.LESS_THAN_OR_EQUAL, budget);
    }

    public CampaignRequest<T> withBudgetBetween(BigDecimal startOfBudget, BigDecimal endOfBudget){
       return withBudget(Operator.BETWEEN, startOfBudget, endOfBudget);
    }



    public CampaignRequest<T> filterByEndDate(LocalDateTime... endDate){
      if (endDate == null || endDate.length == 0) {
        throw new IllegalArgumentException("filterByEndDate parameter endDate cannot be empty");
      }
      return appendSearchCriteria(createEndDateCriteria(Operator.EQUAL, (Object[])endDate));
    }

    public CampaignRequest<T> withEndDate(Operator operator, Object... values){
       return appendSearchCriteria(createEndDateCriteria(operator, values));
    }

    public CampaignRequest<T> withEndDateIsUnknown(){
       return withEndDate(Operator.IS_NULL);
    }

    public CampaignRequest<T> withEndDateIsKnown(){
       return withEndDate(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createEndDateCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Campaign.END_DATE_PROPERTY, operator, values);
    }

    public CampaignRequest<T> withEndDateGreaterThan(LocalDateTime endDate){
       return withEndDate(Operator.GREATER_THAN, endDate);
    }

    public CampaignRequest<T> withEndDateGreaterThanOrEqualTo(LocalDateTime endDate){
       return withEndDate(Operator.GREATER_THAN_OR_EQUAL, endDate);
    }

    public CampaignRequest<T> withEndDateLessThan(LocalDateTime endDate){
       return withEndDate(Operator.LESS_THAN, endDate);
    }

    public CampaignRequest<T> withEndDateLessThanOrEqualTo(LocalDateTime endDate){
       return withEndDate(Operator.LESS_THAN_OR_EQUAL, endDate);
    }

    public CampaignRequest<T> withEndDateBetween(LocalDateTime startOfEndDate, LocalDateTime endOfEndDate){
       return withEndDate(Operator.BETWEEN, startOfEndDate, endOfEndDate);
    }
    public CampaignRequest<T> withEndDateBefore(LocalDateTime endDate){
       return withEndDate(Operator.LESS_THAN, endDate);
    }

    public CampaignRequest<T> withEndDateBefore(Date endDate){
       return withEndDate(Operator.LESS_THAN, endDate);
    }

    public CampaignRequest<T> withEndDateAfter(LocalDateTime endDate){
       return withEndDate(Operator.GREATER_THAN, endDate);
    }

    public CampaignRequest<T> withEndDateAfter(Date endDate){
       return withEndDate(Operator.GREATER_THAN, endDate);
    }

    public CampaignRequest<T> withEndDateBetween(Date startOfEndDate, Date endOfEndDate){
       return withEndDate(Operator.BETWEEN, startOfEndDate, endOfEndDate);
    }




    public CampaignRequest<T> filterByStartDate(LocalDateTime... startDate){
      if (startDate == null || startDate.length == 0) {
        throw new IllegalArgumentException("filterByStartDate parameter startDate cannot be empty");
      }
      return appendSearchCriteria(createStartDateCriteria(Operator.EQUAL, (Object[])startDate));
    }

    public CampaignRequest<T> withStartDate(Operator operator, Object... values){
       return appendSearchCriteria(createStartDateCriteria(operator, values));
    }

    public CampaignRequest<T> withStartDateIsUnknown(){
       return withStartDate(Operator.IS_NULL);
    }

    public CampaignRequest<T> withStartDateIsKnown(){
       return withStartDate(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createStartDateCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Campaign.START_DATE_PROPERTY, operator, values);
    }

    public CampaignRequest<T> withStartDateGreaterThan(LocalDateTime startDate){
       return withStartDate(Operator.GREATER_THAN, startDate);
    }

    public CampaignRequest<T> withStartDateGreaterThanOrEqualTo(LocalDateTime startDate){
       return withStartDate(Operator.GREATER_THAN_OR_EQUAL, startDate);
    }

    public CampaignRequest<T> withStartDateLessThan(LocalDateTime startDate){
       return withStartDate(Operator.LESS_THAN, startDate);
    }

    public CampaignRequest<T> withStartDateLessThanOrEqualTo(LocalDateTime startDate){
       return withStartDate(Operator.LESS_THAN_OR_EQUAL, startDate);
    }

    public CampaignRequest<T> withStartDateBetween(LocalDateTime startOfStartDate, LocalDateTime endOfStartDate){
       return withStartDate(Operator.BETWEEN, startOfStartDate, endOfStartDate);
    }
    public CampaignRequest<T> withStartDateBefore(LocalDateTime startDate){
       return withStartDate(Operator.LESS_THAN, startDate);
    }

    public CampaignRequest<T> withStartDateBefore(Date startDate){
       return withStartDate(Operator.LESS_THAN, startDate);
    }

    public CampaignRequest<T> withStartDateAfter(LocalDateTime startDate){
       return withStartDate(Operator.GREATER_THAN, startDate);
    }

    public CampaignRequest<T> withStartDateAfter(Date startDate){
       return withStartDate(Operator.GREATER_THAN, startDate);
    }

    public CampaignRequest<T> withStartDateBetween(Date startOfStartDate, Date endOfStartDate){
       return withStartDate(Operator.BETWEEN, startOfStartDate, endOfStartDate);
    }




    public CampaignRequest<T> filterByStatus(String... status){
      if (status == null || status.length == 0) {
        throw new IllegalArgumentException("filterByStatus parameter status cannot be empty");
      }
      return appendSearchCriteria(createStatusCriteria(Operator.EQUAL, (Object[])status));
    }

    public CampaignRequest<T> withStatus(Operator operator, Object... values){
       return appendSearchCriteria(createStatusCriteria(operator, values));
    }

    public CampaignRequest<T> withStatusIsUnknown(){
       return withStatus(Operator.IS_NULL);
    }

    public CampaignRequest<T> withStatusIsKnown(){
       return withStatus(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createStatusCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Campaign.STATUS_PROPERTY, operator, values);
    }

    public CampaignRequest<T> withStatusGreaterThan(String status){
       return withStatus(Operator.GREATER_THAN, status);
    }

    public CampaignRequest<T> withStatusGreaterThanOrEqualTo(String status){
       return withStatus(Operator.GREATER_THAN_OR_EQUAL, status);
    }

    public CampaignRequest<T> withStatusLessThan(String status){
       return withStatus(Operator.LESS_THAN, status);
    }

    public CampaignRequest<T> withStatusLessThanOrEqualTo(String status){
       return withStatus(Operator.LESS_THAN_OR_EQUAL, status);
    }

    public CampaignRequest<T> withStatusBetween(String startOfStatus, String endOfStatus){
       return withStatus(Operator.BETWEEN, startOfStatus, endOfStatus);
    }
    public CampaignRequest<T> withStatusStartingWith(String status){
       return withStatus(Operator.BEGIN_WITH, status);
    }
    public CampaignRequest<T> withStatusContaining(String status){
       return withStatus(Operator.CONTAIN, status);
    }

    public CampaignRequest<T> withStatusEndingWith(String status){
       return withStatus(Operator.END_WITH, status);
    }

    public CampaignRequest<T> withStatusIs(String status){
       return withStatus(Operator.EQUAL, status);
    }

    public CampaignRequest<T> withStatusSoundingLike(String status){
       return withStatus(Operator.SOUNDS_LIKE, status);
    }



    public CampaignRequest<T> filterByCreateTime(LocalDateTime... createTime){
      if (createTime == null || createTime.length == 0) {
        throw new IllegalArgumentException("filterByCreateTime parameter createTime cannot be empty");
      }
      return appendSearchCriteria(createCreateTimeCriteria(Operator.EQUAL, (Object[])createTime));
    }

    public CampaignRequest<T> withCreateTime(Operator operator, Object... values){
       return appendSearchCriteria(createCreateTimeCriteria(operator, values));
    }

    public CampaignRequest<T> withCreateTimeIsUnknown(){
       return withCreateTime(Operator.IS_NULL);
    }

    public CampaignRequest<T> withCreateTimeIsKnown(){
       return withCreateTime(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createCreateTimeCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Campaign.CREATE_TIME_PROPERTY, operator, values);
    }

    public CampaignRequest<T> withCreateTimeGreaterThan(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public CampaignRequest<T> withCreateTimeGreaterThanOrEqualTo(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN_OR_EQUAL, createTime);
    }

    public CampaignRequest<T> withCreateTimeLessThan(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public CampaignRequest<T> withCreateTimeLessThanOrEqualTo(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN_OR_EQUAL, createTime);
    }

    public CampaignRequest<T> withCreateTimeBetween(LocalDateTime startOfCreateTime, LocalDateTime endOfCreateTime){
       return withCreateTime(Operator.BETWEEN, startOfCreateTime, endOfCreateTime);
    }
    public CampaignRequest<T> withCreateTimeBefore(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public CampaignRequest<T> withCreateTimeBefore(Date createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public CampaignRequest<T> withCreateTimeAfter(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public CampaignRequest<T> withCreateTimeAfter(Date createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public CampaignRequest<T> withCreateTimeBetween(Date startOfCreateTime, Date endOfCreateTime){
       return withCreateTime(Operator.BETWEEN, startOfCreateTime, endOfCreateTime);
    }




    public CampaignRequest<T> filterByUpdateTime(LocalDateTime... updateTime){
      if (updateTime == null || updateTime.length == 0) {
        throw new IllegalArgumentException("filterByUpdateTime parameter updateTime cannot be empty");
      }
      return appendSearchCriteria(createUpdateTimeCriteria(Operator.EQUAL, (Object[])updateTime));
    }

    public CampaignRequest<T> withUpdateTime(Operator operator, Object... values){
       return appendSearchCriteria(createUpdateTimeCriteria(operator, values));
    }

    public CampaignRequest<T> withUpdateTimeIsUnknown(){
       return withUpdateTime(Operator.IS_NULL);
    }

    public CampaignRequest<T> withUpdateTimeIsKnown(){
       return withUpdateTime(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createUpdateTimeCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Campaign.UPDATE_TIME_PROPERTY, operator, values);
    }

    public CampaignRequest<T> withUpdateTimeGreaterThan(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public CampaignRequest<T> withUpdateTimeGreaterThanOrEqualTo(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN_OR_EQUAL, updateTime);
    }

    public CampaignRequest<T> withUpdateTimeLessThan(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public CampaignRequest<T> withUpdateTimeLessThanOrEqualTo(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN_OR_EQUAL, updateTime);
    }

    public CampaignRequest<T> withUpdateTimeBetween(LocalDateTime startOfUpdateTime, LocalDateTime endOfUpdateTime){
       return withUpdateTime(Operator.BETWEEN, startOfUpdateTime, endOfUpdateTime);
    }
    public CampaignRequest<T> withUpdateTimeBefore(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public CampaignRequest<T> withUpdateTimeBefore(Date updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public CampaignRequest<T> withUpdateTimeAfter(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public CampaignRequest<T> withUpdateTimeAfter(Date updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public CampaignRequest<T> withUpdateTimeBetween(Date startOfUpdateTime, Date endOfUpdateTime){
       return withUpdateTime(Operator.BETWEEN, startOfUpdateTime, endOfUpdateTime);
    }




    public CampaignRequest<T> filterByVersion(Long... version){
      if (version == null || version.length == 0) {
        throw new IllegalArgumentException("filterByVersion parameter version cannot be empty");
      }
      return appendSearchCriteria(createVersionCriteria(Operator.EQUAL, (Object[])version));
    }

    public CampaignRequest<T> withVersion(Operator operator, Object... values){
       return appendSearchCriteria(createVersionCriteria(operator, values));
    }

    public CampaignRequest<T> withVersionIsUnknown(){
       return withVersion(Operator.IS_NULL);
    }

    public CampaignRequest<T> withVersionIsKnown(){
       return withVersion(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createVersionCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Campaign.VERSION_PROPERTY, operator, values);
    }

    public CampaignRequest<T> withVersionGreaterThan(Long version){
       return withVersion(Operator.GREATER_THAN, version);
    }

    public CampaignRequest<T> withVersionGreaterThanOrEqualTo(Long version){
       return withVersion(Operator.GREATER_THAN_OR_EQUAL, version);
    }

    public CampaignRequest<T> withVersionLessThan(Long version){
       return withVersion(Operator.LESS_THAN, version);
    }

    public CampaignRequest<T> withVersionLessThanOrEqualTo(Long version){
       return withVersion(Operator.LESS_THAN_OR_EQUAL, version);
    }

    public CampaignRequest<T> withVersionBetween(Long startOfVersion, Long endOfVersion){
       return withVersion(Operator.BETWEEN, startOfVersion, endOfVersion);
    }


    public CampaignRequest<T> count(){
        super.count();
        return this;
    }
    public CampaignRequest<T> countAs(String retName){
        super.count(retName);
        return this;
    }
    public CampaignRequest minBudget(){
        return minBudgetAs(prefix("minOf",Campaign.BUDGET_PROPERTY));
    }

    public CampaignRequest minBudgetAs(String retName){
        super.min(retName, Campaign.BUDGET_PROPERTY);
        return this;
    }
    public CampaignRequest maxBudget(){
        return maxBudgetAs(prefix("maxOf",Campaign.BUDGET_PROPERTY));
    }

    public CampaignRequest maxBudgetAs(String retName){
        super.max(retName, Campaign.BUDGET_PROPERTY);
        return this;
    }
    public CampaignRequest sumBudget(){
        return sumBudgetAs(prefix("sumOf",Campaign.BUDGET_PROPERTY));
    }

    public CampaignRequest sumBudgetAs(String retName){
        super.sum(retName, Campaign.BUDGET_PROPERTY);
        return this;
    }
    public CampaignRequest avgBudget(){
        return avgBudgetAs(prefix("avgOf",Campaign.BUDGET_PROPERTY));
    }

    public CampaignRequest avgBudgetAs(String retName){
        super.avg(retName, Campaign.BUDGET_PROPERTY);
        return this;
    }
    public CampaignRequest standardDeviationBudget(){
        return standardDeviationBudgetAs(prefix("standardDeviationOf",Campaign.BUDGET_PROPERTY));
    }

    public CampaignRequest standardDeviationBudgetAs(String retName){
        super.standardDeviation(retName, Campaign.BUDGET_PROPERTY);
        return this;
    }
    public CampaignRequest squareRootOfPopulationStandardDeviationBudget(){
        return squareRootOfPopulationStandardDeviationBudgetAs(prefix("squareRootOfPopulationStandardDeviationOf",Campaign.BUDGET_PROPERTY));
    }

    public CampaignRequest squareRootOfPopulationStandardDeviationBudgetAs(String retName){
        super.squareRootOfPopulationStandardDeviation(retName, Campaign.BUDGET_PROPERTY);
        return this;
    }
    public CampaignRequest sampleVarianceBudget(){
        return sampleVarianceBudgetAs(prefix("sampleVarianceOf",Campaign.BUDGET_PROPERTY));
    }

    public CampaignRequest sampleVarianceBudgetAs(String retName){
        super.sampleVariance(retName, Campaign.BUDGET_PROPERTY);
        return this;
    }
    public CampaignRequest samplePopulationVarianceBudget(){
        return samplePopulationVarianceBudgetAs(prefix("samplePopulationVarianceOf",Campaign.BUDGET_PROPERTY));
    }

    public CampaignRequest samplePopulationVarianceBudgetAs(String retName){
        super.samplePopulationVariance(retName, Campaign.BUDGET_PROPERTY);
        return this;
    }

    public CampaignRequest<T> groupById(){
       groupBy(Campaign.ID_PROPERTY);
       return this;
    }

    public CampaignRequest<T> groupByIdAs(String retName){
       groupBy(retName, Campaign.ID_PROPERTY);
       return this;
    }

    public CampaignRequest<T> groupByIdWithFunction(String retName, AggrFunction function){
       groupBy(retName, Campaign.ID_PROPERTY, function);
       return this;
    }

    public CampaignRequest<T> groupByName(){
       groupBy(Campaign.NAME_PROPERTY);
       return this;
    }

    public CampaignRequest<T> groupByNameAs(String retName){
       groupBy(retName, Campaign.NAME_PROPERTY);
       return this;
    }

    public CampaignRequest<T> groupByNameWithFunction(String retName, AggrFunction function){
       groupBy(retName, Campaign.NAME_PROPERTY, function);
       return this;
    }

    public CampaignRequest<T> groupByBudget(){
       groupBy(Campaign.BUDGET_PROPERTY);
       return this;
    }

    public CampaignRequest<T> groupByBudgetAs(String retName){
       groupBy(retName, Campaign.BUDGET_PROPERTY);
       return this;
    }

    public CampaignRequest<T> groupByBudgetWithFunction(String retName, AggrFunction function){
       groupBy(retName, Campaign.BUDGET_PROPERTY, function);
       return this;
    }

    public CampaignRequest<T> groupByEndDate(){
       groupBy(Campaign.END_DATE_PROPERTY);
       return this;
    }

    public CampaignRequest<T> groupByEndDateAs(String retName){
       groupBy(retName, Campaign.END_DATE_PROPERTY);
       return this;
    }

    public CampaignRequest<T> groupByEndDateWithFunction(String retName, AggrFunction function){
       groupBy(retName, Campaign.END_DATE_PROPERTY, function);
       return this;
    }

    public CampaignRequest<T> groupByStartDate(){
       groupBy(Campaign.START_DATE_PROPERTY);
       return this;
    }

    public CampaignRequest<T> groupByStartDateAs(String retName){
       groupBy(retName, Campaign.START_DATE_PROPERTY);
       return this;
    }

    public CampaignRequest<T> groupByStartDateWithFunction(String retName, AggrFunction function){
       groupBy(retName, Campaign.START_DATE_PROPERTY, function);
       return this;
    }

    public CampaignRequest<T> groupByStatus(){
       groupBy(Campaign.STATUS_PROPERTY);
       return this;
    }

    public CampaignRequest<T> groupByStatusAs(String retName){
       groupBy(retName, Campaign.STATUS_PROPERTY);
       return this;
    }

    public CampaignRequest<T> groupByStatusWithFunction(String retName, AggrFunction function){
       groupBy(retName, Campaign.STATUS_PROPERTY, function);
       return this;
    }

    public CampaignRequest<T> groupByCreateTime(){
       groupBy(Campaign.CREATE_TIME_PROPERTY);
       return this;
    }

    public CampaignRequest<T> groupByCreateTimeAs(String retName){
       groupBy(retName, Campaign.CREATE_TIME_PROPERTY);
       return this;
    }

    public CampaignRequest<T> groupByCreateTimeWithFunction(String retName, AggrFunction function){
       groupBy(retName, Campaign.CREATE_TIME_PROPERTY, function);
       return this;
    }

    public CampaignRequest<T> groupByUpdateTime(){
       groupBy(Campaign.UPDATE_TIME_PROPERTY);
       return this;
    }

    public CampaignRequest<T> groupByUpdateTimeAs(String retName){
       groupBy(retName, Campaign.UPDATE_TIME_PROPERTY);
       return this;
    }

    public CampaignRequest<T> groupByUpdateTimeWithFunction(String retName, AggrFunction function){
       groupBy(retName, Campaign.UPDATE_TIME_PROPERTY, function);
       return this;
    }

    public CampaignRequest<T> groupByVersion(){
       groupBy(Campaign.VERSION_PROPERTY);
       return this;
    }

    public CampaignRequest<T> groupByVersionAs(String retName){
       groupBy(retName, Campaign.VERSION_PROPERTY);
       return this;
    }

    public CampaignRequest<T> groupByVersionWithFunction(String retName, AggrFunction function){
       groupBy(retName, Campaign.VERSION_PROPERTY, function);
       return this;
    }



    public CampaignRequest<T> orderByIdAscending(){
       addOrderByAscending(Campaign.ID_PROPERTY);
       return this;
    }

    public CampaignRequest<T> orderByIdDescending(){
       addOrderByDescending(Campaign.ID_PROPERTY);
       return this;
    }

    public CampaignRequest<T> orderByNameAscending(){
       addOrderByAscending(Campaign.NAME_PROPERTY);
       return this;
    }

    public CampaignRequest<T> orderByNameDescending(){
       addOrderByDescending(Campaign.NAME_PROPERTY);
       return this;
    }
    public CampaignRequest<T> orderByNameAscendingUsingGBK(){
       addOrderByAscendingUsingGBK(Campaign.NAME_PROPERTY);
       return this;
    }

    public CampaignRequest<T> orderByNameDescendingUsingGBK(){
       addOrderByDescendingUsingGBK(Campaign.NAME_PROPERTY);
       return this;
    }
    public CampaignRequest<T> orderByBudgetAscending(){
       addOrderByAscending(Campaign.BUDGET_PROPERTY);
       return this;
    }

    public CampaignRequest<T> orderByBudgetDescending(){
       addOrderByDescending(Campaign.BUDGET_PROPERTY);
       return this;
    }

    public CampaignRequest<T> orderByEndDateAscending(){
       addOrderByAscending(Campaign.END_DATE_PROPERTY);
       return this;
    }

    public CampaignRequest<T> orderByEndDateDescending(){
       addOrderByDescending(Campaign.END_DATE_PROPERTY);
       return this;
    }

    public CampaignRequest<T> orderByStartDateAscending(){
       addOrderByAscending(Campaign.START_DATE_PROPERTY);
       return this;
    }

    public CampaignRequest<T> orderByStartDateDescending(){
       addOrderByDescending(Campaign.START_DATE_PROPERTY);
       return this;
    }

    public CampaignRequest<T> orderByStatusAscending(){
       addOrderByAscending(Campaign.STATUS_PROPERTY);
       return this;
    }

    public CampaignRequest<T> orderByStatusDescending(){
       addOrderByDescending(Campaign.STATUS_PROPERTY);
       return this;
    }
    public CampaignRequest<T> orderByStatusAscendingUsingGBK(){
       addOrderByAscendingUsingGBK(Campaign.STATUS_PROPERTY);
       return this;
    }

    public CampaignRequest<T> orderByStatusDescendingUsingGBK(){
       addOrderByDescendingUsingGBK(Campaign.STATUS_PROPERTY);
       return this;
    }
    public CampaignRequest<T> orderByCreateTimeAscending(){
       addOrderByAscending(Campaign.CREATE_TIME_PROPERTY);
       return this;
    }

    public CampaignRequest<T> orderByCreateTimeDescending(){
       addOrderByDescending(Campaign.CREATE_TIME_PROPERTY);
       return this;
    }

    public CampaignRequest<T> orderByUpdateTimeAscending(){
       addOrderByAscending(Campaign.UPDATE_TIME_PROPERTY);
       return this;
    }

    public CampaignRequest<T> orderByUpdateTimeDescending(){
       addOrderByDescending(Campaign.UPDATE_TIME_PROPERTY);
       return this;
    }

    public CampaignRequest<T> orderByVersionAscending(){
       addOrderByAscending(Campaign.VERSION_PROPERTY);
       return this;
    }

    public CampaignRequest<T> orderByVersionDescending(){
       addOrderByDescending(Campaign.VERSION_PROPERTY);
       return this;
    }





    /**
     * get topN records
     * @param topN  records number
     */
    public CampaignRequest<T> top(int topN) {
        super.top(topN);
        return this;
    }

    /**
     * get records from offset(inclusive) to offset+size(exclusive)
     * @param offset record offset
     * @param size records number
     */
    public CampaignRequest<T> offset(int offset, int size) {
        super.offset(offset, size);
        return this;
    }

    /**
     * retrieve all records
     */
    public CampaignRequest<T> unlimited() {
        super.unlimited();
        return this;
    }

    /**
     * get records of one page
     * @param pageNumber page number(1-based)
     * @param pageSize page size
     */
    public CampaignRequest<T> page(int pageNumber, int pageSize) {
        int offset = (pageNumber - 1) * pageSize;
        return offset(offset, pageSize);
   }

    /**
     * get records of one page, default page size is 10
     * @param pageNumber page number(1-based)
     */
    public CampaignRequest<T> page(int pageNumber) {
        return page(pageNumber, 10);
   }
}