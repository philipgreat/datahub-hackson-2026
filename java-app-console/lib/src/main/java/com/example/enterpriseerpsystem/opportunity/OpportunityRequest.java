
package com.example.enterpriseerpsystem.opportunity;

import com.example.enterpriseerpsystem.Q;
import com.example.enterpriseerpsystem.lead.Lead;
import com.example.enterpriseerpsystem.lead.LeadRequest;
import com.example.enterpriseerpsystem.quote.Quote;
import com.example.enterpriseerpsystem.quote.QuoteRequest;
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

public class OpportunityRequest<T extends Opportunity> extends BaseRequest<T> {

    /**
     * @deprecated AI agents and business code must use the generated Q facade
     *             instead of constructing request builders directly.
     */
    @Deprecated
    public OpportunityRequest(Class<T> returnType){
        super(returnType);
        selectId();
        selectVersion();
    }

    public OpportunityRequest<T> comment(String comment){
         super.internalComment(comment);
         return this;
    }

    // purpose() 继承自 BaseRequest，返回 ExecutableRequest（终结方法）

    public OpportunityRequest<T> returnType(Class<? extends T> returnType){
        super.setReturnType(returnType);
        return this;
    }

    public OpportunityRequest<T> enableAggregationCache(long cacheExpiredMillis){
        super.enableAggregationCache();
        super.aggregateCacheTime(cacheExpiredMillis);
        return this;
    }

    public OpportunityRequest<T> enableAggregationCache(){
        return enableAggregationCache(0l);
    }


    public OpportunityRequest<T> propagateAggregationCache(long cacheExpiredMillis){
        super.propagateAggregationCache(cacheExpiredMillis);
        return this;
    }

    public OpportunityRequest<T> appendSearchCriteria(SearchCriteria searchCriteria){
        return (OpportunityRequest<T>)super.appendSearchCriteria(searchCriteria);
    }

    public OpportunityRequest<T> filter(String property1, Operator operator, String property2){
        return appendSearchCriteria(new TwoOperatorCriteria(operator, new PropertyReference(property1), new PropertyReference(property2)));
    }


    public OpportunityRequest<T> matchingAnyOf(OpportunityRequest opportunity){
        super.internalMatchAny(opportunity);
        return this;
    }

    public OpportunityRequest<T> enhanceChildrenIfNeeded(){
        return this;
    }

    public OpportunityRequest<T> withDeletedRows(){
        super.withDeletedRows();
        return this;
    }

    public OpportunityRequest<T> deletedRowsOnly(){
        super.deletedRowsOnly();
        return this;
    }

    public OpportunityRequest<T> selectSelf(){
        super.selectSelf();
        return selectId().selectCloseDate().selectExpectedRevenue().selectLeadIdOnly().selectProbability().selectStatus().selectCreateTime().selectUpdateTime().selectVersion();
    }

    public OpportunityRequest<T> selectSelfFields(){
        return selectSelf();
    }

    public OpportunityRequest<T> selectAll(){
        super.selectAll();
        return selectId().selectCloseDate().selectExpectedRevenue().selectLead().selectProbability().selectStatus().selectCreateTime().selectUpdateTime().selectVersion();
    }

    public OpportunityRequest<T> selectChildren(){
        super.selectAny();
        selectQuoteList();
        return selectId().selectCloseDate().selectExpectedRevenue().selectLead().selectProbability().selectStatus().selectCreateTime().selectUpdateTime().selectVersion();
    }


    public OpportunityRequest<T> selectId(){
       selectProperty(Opportunity.ID_PROPERTY);
       return this;
    }

    /**
     * fill the id with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  id) to fetch id property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public OpportunityRequest<T> unselectId(){
       unselectProperty(Opportunity.ID_PROPERTY);
       return this;
    }
    public OpportunityRequest<T> selectCloseDate(){
       selectProperty(Opportunity.CLOSE_DATE_PROPERTY);
       return this;
    }

    /**
     * fill the closeDate with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  closeDate) to fetch closeDate property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public OpportunityRequest<T> unselectCloseDate(){
       unselectProperty(Opportunity.CLOSE_DATE_PROPERTY);
       return this;
    }
    public OpportunityRequest<T> selectExpectedRevenue(){
       selectProperty(Opportunity.EXPECTED_REVENUE_PROPERTY);
       return this;
    }

    /**
     * fill the expectedRevenue with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  expectedRevenue) to fetch expectedRevenue property.
     * @param rawSqlSegment  customized rawSqlSegment
     */


    /**
     * fill the expectedRevenue with customized aggrFunction, TEAQL uses ({aggrFunction}(expectedRevenue) AS expectedRevenue to fetch expectedRevenue property.
     * @param aggrFunction  aggrFunction
     */
    public OpportunityRequest<T> selectExpectedRevenue(AggrFunction aggrFunction){
       selectProperty(Opportunity.EXPECTED_REVENUE_PROPERTY, aggrFunction);
       return this;
    }


    public OpportunityRequest<T> unselectExpectedRevenue(){
       unselectProperty(Opportunity.EXPECTED_REVENUE_PROPERTY);
       return this;
    }
    public OpportunityRequest<T> selectLeadIdOnly(){
       selectProperty(Opportunity.LEAD_PROPERTY);
       return this;
    }

    public OpportunityRequest<T> selectLead(){
        return selectLeadWith(Q.leads().unlimited().selectSelf());
    }

    public OpportunityRequest<T> selectLeadWith(LeadRequest lead){
       selectProperty(Opportunity.LEAD_PROPERTY);
       enhanceRelation(Opportunity.LEAD_PROPERTY, lead);
       return this;
    }

    public OpportunityRequest<T> unselectLead(){
       unselectProperty(Opportunity.LEAD_PROPERTY);
       return this;
    }
    public OpportunityRequest<T> selectProbability(){
       selectProperty(Opportunity.PROBABILITY_PROPERTY);
       return this;
    }

    /**
     * fill the probability with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  probability) to fetch probability property.
     * @param rawSqlSegment  customized rawSqlSegment
     */


    /**
     * fill the probability with customized aggrFunction, TEAQL uses ({aggrFunction}(probability) AS probability to fetch probability property.
     * @param aggrFunction  aggrFunction
     */
    public OpportunityRequest<T> selectProbability(AggrFunction aggrFunction){
       selectProperty(Opportunity.PROBABILITY_PROPERTY, aggrFunction);
       return this;
    }


    public OpportunityRequest<T> unselectProbability(){
       unselectProperty(Opportunity.PROBABILITY_PROPERTY);
       return this;
    }
    public OpportunityRequest<T> selectStatus(){
       selectProperty(Opportunity.STATUS_PROPERTY);
       return this;
    }

    /**
     * fill the status with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  status) to fetch status property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public OpportunityRequest<T> unselectStatus(){
       unselectProperty(Opportunity.STATUS_PROPERTY);
       return this;
    }
    public OpportunityRequest<T> selectCreateTime(){
       selectProperty(Opportunity.CREATE_TIME_PROPERTY);
       return this;
    }

    /**
     * fill the createTime with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  createTime) to fetch createTime property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public OpportunityRequest<T> unselectCreateTime(){
       unselectProperty(Opportunity.CREATE_TIME_PROPERTY);
       return this;
    }
    public OpportunityRequest<T> selectUpdateTime(){
       selectProperty(Opportunity.UPDATE_TIME_PROPERTY);
       return this;
    }

    /**
     * fill the updateTime with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  updateTime) to fetch updateTime property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public OpportunityRequest<T> unselectUpdateTime(){
       unselectProperty(Opportunity.UPDATE_TIME_PROPERTY);
       return this;
    }
    public OpportunityRequest<T> selectVersion(){
       selectProperty(Opportunity.VERSION_PROPERTY);
       return this;
    }

    /**
     * fill the version with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  version) to fetch version property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public OpportunityRequest<T> unselectVersion(){
       unselectProperty(Opportunity.VERSION_PROPERTY);
       return this;
    }
    public OpportunityRequest<T> selectQuoteList(){
       return selectQuoteListWith(Q.quotes().selectSelf());
    }

    public OpportunityRequest<T> selectQuoteListWith(QuoteRequest quoteList){
       enhanceRelation(Opportunity.QUOTE_LIST_PROPERTY, quoteList);
       return this;
    }

    public OpportunityRequest<T> withId(Operator operator, Object... values){
       return appendSearchCriteria(createIdCriteria(operator, values));
    }

    public SearchCriteria createIdCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Opportunity.ID_PROPERTY, operator, values);
    }

    public OpportunityRequest<T> withIdIs(Long id){
       return withId(Operator.EQUAL, id);
    }
    public OpportunityRequest<T> withIdIn(Long... id){
       return withId(Operator.EQUAL, (Object[])id);
    }



    public OpportunityRequest<T> filterByCloseDate(LocalDateTime... closeDate){
      if (closeDate == null || closeDate.length == 0) {
        throw new IllegalArgumentException("filterByCloseDate parameter closeDate cannot be empty");
      }
      return appendSearchCriteria(createCloseDateCriteria(Operator.EQUAL, (Object[])closeDate));
    }

    public OpportunityRequest<T> withCloseDate(Operator operator, Object... values){
       return appendSearchCriteria(createCloseDateCriteria(operator, values));
    }

    public OpportunityRequest<T> withCloseDateIsUnknown(){
       return withCloseDate(Operator.IS_NULL);
    }

    public OpportunityRequest<T> withCloseDateIsKnown(){
       return withCloseDate(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createCloseDateCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Opportunity.CLOSE_DATE_PROPERTY, operator, values);
    }

    public OpportunityRequest<T> withCloseDateGreaterThan(LocalDateTime closeDate){
       return withCloseDate(Operator.GREATER_THAN, closeDate);
    }

    public OpportunityRequest<T> withCloseDateGreaterThanOrEqualTo(LocalDateTime closeDate){
       return withCloseDate(Operator.GREATER_THAN_OR_EQUAL, closeDate);
    }

    public OpportunityRequest<T> withCloseDateLessThan(LocalDateTime closeDate){
       return withCloseDate(Operator.LESS_THAN, closeDate);
    }

    public OpportunityRequest<T> withCloseDateLessThanOrEqualTo(LocalDateTime closeDate){
       return withCloseDate(Operator.LESS_THAN_OR_EQUAL, closeDate);
    }

    public OpportunityRequest<T> withCloseDateBetween(LocalDateTime startOfCloseDate, LocalDateTime endOfCloseDate){
       return withCloseDate(Operator.BETWEEN, startOfCloseDate, endOfCloseDate);
    }
    public OpportunityRequest<T> withCloseDateBefore(LocalDateTime closeDate){
       return withCloseDate(Operator.LESS_THAN, closeDate);
    }

    public OpportunityRequest<T> withCloseDateBefore(Date closeDate){
       return withCloseDate(Operator.LESS_THAN, closeDate);
    }

    public OpportunityRequest<T> withCloseDateAfter(LocalDateTime closeDate){
       return withCloseDate(Operator.GREATER_THAN, closeDate);
    }

    public OpportunityRequest<T> withCloseDateAfter(Date closeDate){
       return withCloseDate(Operator.GREATER_THAN, closeDate);
    }

    public OpportunityRequest<T> withCloseDateBetween(Date startOfCloseDate, Date endOfCloseDate){
       return withCloseDate(Operator.BETWEEN, startOfCloseDate, endOfCloseDate);
    }




    public OpportunityRequest<T> filterByExpectedRevenue(BigDecimal... expectedRevenue){
      if (expectedRevenue == null || expectedRevenue.length == 0) {
        throw new IllegalArgumentException("filterByExpectedRevenue parameter expectedRevenue cannot be empty");
      }
      return appendSearchCriteria(createExpectedRevenueCriteria(Operator.EQUAL, (Object[])expectedRevenue));
    }

    public OpportunityRequest<T> withExpectedRevenue(Operator operator, Object... values){
       return appendSearchCriteria(createExpectedRevenueCriteria(operator, values));
    }

    public OpportunityRequest<T> withExpectedRevenueIsUnknown(){
       return withExpectedRevenue(Operator.IS_NULL);
    }

    public OpportunityRequest<T> withExpectedRevenueIsKnown(){
       return withExpectedRevenue(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createExpectedRevenueCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Opportunity.EXPECTED_REVENUE_PROPERTY, operator, values);
    }

    public OpportunityRequest<T> withExpectedRevenueGreaterThan(BigDecimal expectedRevenue){
       return withExpectedRevenue(Operator.GREATER_THAN, expectedRevenue);
    }

    public OpportunityRequest<T> withExpectedRevenueGreaterThanOrEqualTo(BigDecimal expectedRevenue){
       return withExpectedRevenue(Operator.GREATER_THAN_OR_EQUAL, expectedRevenue);
    }

    public OpportunityRequest<T> withExpectedRevenueLessThan(BigDecimal expectedRevenue){
       return withExpectedRevenue(Operator.LESS_THAN, expectedRevenue);
    }

    public OpportunityRequest<T> withExpectedRevenueLessThanOrEqualTo(BigDecimal expectedRevenue){
       return withExpectedRevenue(Operator.LESS_THAN_OR_EQUAL, expectedRevenue);
    }

    public OpportunityRequest<T> withExpectedRevenueBetween(BigDecimal startOfExpectedRevenue, BigDecimal endOfExpectedRevenue){
       return withExpectedRevenue(Operator.BETWEEN, startOfExpectedRevenue, endOfExpectedRevenue);
    }



    public OpportunityRequest<T> filterByLead(Lead... lead){
      if (lead == null || lead.length == 0) {
        throw new IllegalArgumentException("filterByLead parameter lead cannot be empty");
      }
      return appendSearchCriteria(createLeadCriteria(Operator.EQUAL, (Object[])lead));
    }

    public OpportunityRequest<T> withLead(Operator operator, Object... values){
       return appendSearchCriteria(createLeadCriteria(operator, values));
    }

    public OpportunityRequest<T> withLeadIsUnknown(){
       return withLead(Operator.IS_NULL);
    }

    public OpportunityRequest<T> withLeadIsKnown(){
       return withLead(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createLeadCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Opportunity.LEAD_PROPERTY, operator, values);
    }

    public OpportunityRequest<T> filterByLead(Long lead){
      if(lead == null){
         return this;
      }
      return withLead(Operator.EQUAL, lead);
    }
    public OpportunityRequest<T> withLeadMatching(LeadRequest lead){
       return appendSearchCriteria(new SubQuerySearchCriteria(Opportunity.LEAD_PROPERTY, lead, Lead.ID_PROPERTY));
    }

    public OpportunityRequest<T> filterByProbability(BigDecimal... probability){
      if (probability == null || probability.length == 0) {
        throw new IllegalArgumentException("filterByProbability parameter probability cannot be empty");
      }
      return appendSearchCriteria(createProbabilityCriteria(Operator.EQUAL, (Object[])probability));
    }

    public OpportunityRequest<T> withProbability(Operator operator, Object... values){
       return appendSearchCriteria(createProbabilityCriteria(operator, values));
    }

    public OpportunityRequest<T> withProbabilityIsUnknown(){
       return withProbability(Operator.IS_NULL);
    }

    public OpportunityRequest<T> withProbabilityIsKnown(){
       return withProbability(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createProbabilityCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Opportunity.PROBABILITY_PROPERTY, operator, values);
    }

    public OpportunityRequest<T> withProbabilityGreaterThan(BigDecimal probability){
       return withProbability(Operator.GREATER_THAN, probability);
    }

    public OpportunityRequest<T> withProbabilityGreaterThanOrEqualTo(BigDecimal probability){
       return withProbability(Operator.GREATER_THAN_OR_EQUAL, probability);
    }

    public OpportunityRequest<T> withProbabilityLessThan(BigDecimal probability){
       return withProbability(Operator.LESS_THAN, probability);
    }

    public OpportunityRequest<T> withProbabilityLessThanOrEqualTo(BigDecimal probability){
       return withProbability(Operator.LESS_THAN_OR_EQUAL, probability);
    }

    public OpportunityRequest<T> withProbabilityBetween(BigDecimal startOfProbability, BigDecimal endOfProbability){
       return withProbability(Operator.BETWEEN, startOfProbability, endOfProbability);
    }



    public OpportunityRequest<T> filterByStatus(String... status){
      if (status == null || status.length == 0) {
        throw new IllegalArgumentException("filterByStatus parameter status cannot be empty");
      }
      return appendSearchCriteria(createStatusCriteria(Operator.EQUAL, (Object[])status));
    }

    public OpportunityRequest<T> withStatus(Operator operator, Object... values){
       return appendSearchCriteria(createStatusCriteria(operator, values));
    }

    public OpportunityRequest<T> withStatusIsUnknown(){
       return withStatus(Operator.IS_NULL);
    }

    public OpportunityRequest<T> withStatusIsKnown(){
       return withStatus(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createStatusCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Opportunity.STATUS_PROPERTY, operator, values);
    }

    public OpportunityRequest<T> withStatusGreaterThan(String status){
       return withStatus(Operator.GREATER_THAN, status);
    }

    public OpportunityRequest<T> withStatusGreaterThanOrEqualTo(String status){
       return withStatus(Operator.GREATER_THAN_OR_EQUAL, status);
    }

    public OpportunityRequest<T> withStatusLessThan(String status){
       return withStatus(Operator.LESS_THAN, status);
    }

    public OpportunityRequest<T> withStatusLessThanOrEqualTo(String status){
       return withStatus(Operator.LESS_THAN_OR_EQUAL, status);
    }

    public OpportunityRequest<T> withStatusBetween(String startOfStatus, String endOfStatus){
       return withStatus(Operator.BETWEEN, startOfStatus, endOfStatus);
    }
    public OpportunityRequest<T> withStatusStartingWith(String status){
       return withStatus(Operator.BEGIN_WITH, status);
    }
    public OpportunityRequest<T> withStatusContaining(String status){
       return withStatus(Operator.CONTAIN, status);
    }

    public OpportunityRequest<T> withStatusEndingWith(String status){
       return withStatus(Operator.END_WITH, status);
    }

    public OpportunityRequest<T> withStatusIs(String status){
       return withStatus(Operator.EQUAL, status);
    }

    public OpportunityRequest<T> withStatusSoundingLike(String status){
       return withStatus(Operator.SOUNDS_LIKE, status);
    }



    public OpportunityRequest<T> filterByCreateTime(LocalDateTime... createTime){
      if (createTime == null || createTime.length == 0) {
        throw new IllegalArgumentException("filterByCreateTime parameter createTime cannot be empty");
      }
      return appendSearchCriteria(createCreateTimeCriteria(Operator.EQUAL, (Object[])createTime));
    }

    public OpportunityRequest<T> withCreateTime(Operator operator, Object... values){
       return appendSearchCriteria(createCreateTimeCriteria(operator, values));
    }

    public OpportunityRequest<T> withCreateTimeIsUnknown(){
       return withCreateTime(Operator.IS_NULL);
    }

    public OpportunityRequest<T> withCreateTimeIsKnown(){
       return withCreateTime(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createCreateTimeCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Opportunity.CREATE_TIME_PROPERTY, operator, values);
    }

    public OpportunityRequest<T> withCreateTimeGreaterThan(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public OpportunityRequest<T> withCreateTimeGreaterThanOrEqualTo(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN_OR_EQUAL, createTime);
    }

    public OpportunityRequest<T> withCreateTimeLessThan(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public OpportunityRequest<T> withCreateTimeLessThanOrEqualTo(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN_OR_EQUAL, createTime);
    }

    public OpportunityRequest<T> withCreateTimeBetween(LocalDateTime startOfCreateTime, LocalDateTime endOfCreateTime){
       return withCreateTime(Operator.BETWEEN, startOfCreateTime, endOfCreateTime);
    }
    public OpportunityRequest<T> withCreateTimeBefore(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public OpportunityRequest<T> withCreateTimeBefore(Date createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public OpportunityRequest<T> withCreateTimeAfter(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public OpportunityRequest<T> withCreateTimeAfter(Date createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public OpportunityRequest<T> withCreateTimeBetween(Date startOfCreateTime, Date endOfCreateTime){
       return withCreateTime(Operator.BETWEEN, startOfCreateTime, endOfCreateTime);
    }




    public OpportunityRequest<T> filterByUpdateTime(LocalDateTime... updateTime){
      if (updateTime == null || updateTime.length == 0) {
        throw new IllegalArgumentException("filterByUpdateTime parameter updateTime cannot be empty");
      }
      return appendSearchCriteria(createUpdateTimeCriteria(Operator.EQUAL, (Object[])updateTime));
    }

    public OpportunityRequest<T> withUpdateTime(Operator operator, Object... values){
       return appendSearchCriteria(createUpdateTimeCriteria(operator, values));
    }

    public OpportunityRequest<T> withUpdateTimeIsUnknown(){
       return withUpdateTime(Operator.IS_NULL);
    }

    public OpportunityRequest<T> withUpdateTimeIsKnown(){
       return withUpdateTime(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createUpdateTimeCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Opportunity.UPDATE_TIME_PROPERTY, operator, values);
    }

    public OpportunityRequest<T> withUpdateTimeGreaterThan(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public OpportunityRequest<T> withUpdateTimeGreaterThanOrEqualTo(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN_OR_EQUAL, updateTime);
    }

    public OpportunityRequest<T> withUpdateTimeLessThan(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public OpportunityRequest<T> withUpdateTimeLessThanOrEqualTo(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN_OR_EQUAL, updateTime);
    }

    public OpportunityRequest<T> withUpdateTimeBetween(LocalDateTime startOfUpdateTime, LocalDateTime endOfUpdateTime){
       return withUpdateTime(Operator.BETWEEN, startOfUpdateTime, endOfUpdateTime);
    }
    public OpportunityRequest<T> withUpdateTimeBefore(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public OpportunityRequest<T> withUpdateTimeBefore(Date updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public OpportunityRequest<T> withUpdateTimeAfter(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public OpportunityRequest<T> withUpdateTimeAfter(Date updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public OpportunityRequest<T> withUpdateTimeBetween(Date startOfUpdateTime, Date endOfUpdateTime){
       return withUpdateTime(Operator.BETWEEN, startOfUpdateTime, endOfUpdateTime);
    }




    public OpportunityRequest<T> filterByVersion(Long... version){
      if (version == null || version.length == 0) {
        throw new IllegalArgumentException("filterByVersion parameter version cannot be empty");
      }
      return appendSearchCriteria(createVersionCriteria(Operator.EQUAL, (Object[])version));
    }

    public OpportunityRequest<T> withVersion(Operator operator, Object... values){
       return appendSearchCriteria(createVersionCriteria(operator, values));
    }

    public OpportunityRequest<T> withVersionIsUnknown(){
       return withVersion(Operator.IS_NULL);
    }

    public OpportunityRequest<T> withVersionIsKnown(){
       return withVersion(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createVersionCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Opportunity.VERSION_PROPERTY, operator, values);
    }

    public OpportunityRequest<T> withVersionGreaterThan(Long version){
       return withVersion(Operator.GREATER_THAN, version);
    }

    public OpportunityRequest<T> withVersionGreaterThanOrEqualTo(Long version){
       return withVersion(Operator.GREATER_THAN_OR_EQUAL, version);
    }

    public OpportunityRequest<T> withVersionLessThan(Long version){
       return withVersion(Operator.LESS_THAN, version);
    }

    public OpportunityRequest<T> withVersionLessThanOrEqualTo(Long version){
       return withVersion(Operator.LESS_THAN_OR_EQUAL, version);
    }

    public OpportunityRequest<T> withVersionBetween(Long startOfVersion, Long endOfVersion){
       return withVersion(Operator.BETWEEN, startOfVersion, endOfVersion);
    }

    public OpportunityRequest<T> withQuoteListMatching(QuoteRequest quoteRequest){
        return appendSearchCriteria(new SubQuerySearchCriteria(Opportunity.ID_PROPERTY, quoteRequest, Quote.OPPORTUNITY_PROPERTY));
    }

    public OpportunityRequest<T> withoutQuoteListMatching(QuoteRequest quoteRequest){
        return appendSearchCriteria(SearchCriteria.not(new SubQuerySearchCriteria(Opportunity.ID_PROPERTY, quoteRequest, Quote.OPPORTUNITY_PROPERTY)));
    }

    public OpportunityRequest<T> haveQuotes(){
        return withQuoteListMatching(Q.quotes().unlimited());
    }

    public OpportunityRequest<T> haveNoQuotes(){
        return withoutQuoteListMatching(Q.quotes().unlimited());
    }

    public OpportunityRequest<T> count(){
        super.count();
        return this;
    }
    public OpportunityRequest<T> countAs(String retName){
        super.count(retName);
        return this;
    }
    public OpportunityRequest minExpectedRevenue(){
        return minExpectedRevenueAs(prefix("minOf",Opportunity.EXPECTED_REVENUE_PROPERTY));
    }

    public OpportunityRequest minExpectedRevenueAs(String retName){
        super.min(retName, Opportunity.EXPECTED_REVENUE_PROPERTY);
        return this;
    }
    public OpportunityRequest maxExpectedRevenue(){
        return maxExpectedRevenueAs(prefix("maxOf",Opportunity.EXPECTED_REVENUE_PROPERTY));
    }

    public OpportunityRequest maxExpectedRevenueAs(String retName){
        super.max(retName, Opportunity.EXPECTED_REVENUE_PROPERTY);
        return this;
    }
    public OpportunityRequest sumExpectedRevenue(){
        return sumExpectedRevenueAs(prefix("sumOf",Opportunity.EXPECTED_REVENUE_PROPERTY));
    }

    public OpportunityRequest sumExpectedRevenueAs(String retName){
        super.sum(retName, Opportunity.EXPECTED_REVENUE_PROPERTY);
        return this;
    }
    public OpportunityRequest avgExpectedRevenue(){
        return avgExpectedRevenueAs(prefix("avgOf",Opportunity.EXPECTED_REVENUE_PROPERTY));
    }

    public OpportunityRequest avgExpectedRevenueAs(String retName){
        super.avg(retName, Opportunity.EXPECTED_REVENUE_PROPERTY);
        return this;
    }
    public OpportunityRequest standardDeviationExpectedRevenue(){
        return standardDeviationExpectedRevenueAs(prefix("standardDeviationOf",Opportunity.EXPECTED_REVENUE_PROPERTY));
    }

    public OpportunityRequest standardDeviationExpectedRevenueAs(String retName){
        super.standardDeviation(retName, Opportunity.EXPECTED_REVENUE_PROPERTY);
        return this;
    }
    public OpportunityRequest squareRootOfPopulationStandardDeviationExpectedRevenue(){
        return squareRootOfPopulationStandardDeviationExpectedRevenueAs(prefix("squareRootOfPopulationStandardDeviationOf",Opportunity.EXPECTED_REVENUE_PROPERTY));
    }

    public OpportunityRequest squareRootOfPopulationStandardDeviationExpectedRevenueAs(String retName){
        super.squareRootOfPopulationStandardDeviation(retName, Opportunity.EXPECTED_REVENUE_PROPERTY);
        return this;
    }
    public OpportunityRequest sampleVarianceExpectedRevenue(){
        return sampleVarianceExpectedRevenueAs(prefix("sampleVarianceOf",Opportunity.EXPECTED_REVENUE_PROPERTY));
    }

    public OpportunityRequest sampleVarianceExpectedRevenueAs(String retName){
        super.sampleVariance(retName, Opportunity.EXPECTED_REVENUE_PROPERTY);
        return this;
    }
    public OpportunityRequest samplePopulationVarianceExpectedRevenue(){
        return samplePopulationVarianceExpectedRevenueAs(prefix("samplePopulationVarianceOf",Opportunity.EXPECTED_REVENUE_PROPERTY));
    }

    public OpportunityRequest samplePopulationVarianceExpectedRevenueAs(String retName){
        super.samplePopulationVariance(retName, Opportunity.EXPECTED_REVENUE_PROPERTY);
        return this;
    }
    public OpportunityRequest minProbability(){
        return minProbabilityAs(prefix("minOf",Opportunity.PROBABILITY_PROPERTY));
    }

    public OpportunityRequest minProbabilityAs(String retName){
        super.min(retName, Opportunity.PROBABILITY_PROPERTY);
        return this;
    }
    public OpportunityRequest maxProbability(){
        return maxProbabilityAs(prefix("maxOf",Opportunity.PROBABILITY_PROPERTY));
    }

    public OpportunityRequest maxProbabilityAs(String retName){
        super.max(retName, Opportunity.PROBABILITY_PROPERTY);
        return this;
    }
    public OpportunityRequest sumProbability(){
        return sumProbabilityAs(prefix("sumOf",Opportunity.PROBABILITY_PROPERTY));
    }

    public OpportunityRequest sumProbabilityAs(String retName){
        super.sum(retName, Opportunity.PROBABILITY_PROPERTY);
        return this;
    }
    public OpportunityRequest avgProbability(){
        return avgProbabilityAs(prefix("avgOf",Opportunity.PROBABILITY_PROPERTY));
    }

    public OpportunityRequest avgProbabilityAs(String retName){
        super.avg(retName, Opportunity.PROBABILITY_PROPERTY);
        return this;
    }
    public OpportunityRequest standardDeviationProbability(){
        return standardDeviationProbabilityAs(prefix("standardDeviationOf",Opportunity.PROBABILITY_PROPERTY));
    }

    public OpportunityRequest standardDeviationProbabilityAs(String retName){
        super.standardDeviation(retName, Opportunity.PROBABILITY_PROPERTY);
        return this;
    }
    public OpportunityRequest squareRootOfPopulationStandardDeviationProbability(){
        return squareRootOfPopulationStandardDeviationProbabilityAs(prefix("squareRootOfPopulationStandardDeviationOf",Opportunity.PROBABILITY_PROPERTY));
    }

    public OpportunityRequest squareRootOfPopulationStandardDeviationProbabilityAs(String retName){
        super.squareRootOfPopulationStandardDeviation(retName, Opportunity.PROBABILITY_PROPERTY);
        return this;
    }
    public OpportunityRequest sampleVarianceProbability(){
        return sampleVarianceProbabilityAs(prefix("sampleVarianceOf",Opportunity.PROBABILITY_PROPERTY));
    }

    public OpportunityRequest sampleVarianceProbabilityAs(String retName){
        super.sampleVariance(retName, Opportunity.PROBABILITY_PROPERTY);
        return this;
    }
    public OpportunityRequest samplePopulationVarianceProbability(){
        return samplePopulationVarianceProbabilityAs(prefix("samplePopulationVarianceOf",Opportunity.PROBABILITY_PROPERTY));
    }

    public OpportunityRequest samplePopulationVarianceProbabilityAs(String retName){
        super.samplePopulationVariance(retName, Opportunity.PROBABILITY_PROPERTY);
        return this;
    }
    public OpportunityRequest<T> groupByLeadWithDetails(){
       return groupByLeadWithDetails(Q.leads().unlimited());
    }

    public OpportunityRequest<T> groupByLeadWithDetails(LeadRequest subRequest){
       aggregate(Opportunity.LEAD_PROPERTY, subRequest);
       return this;
    }






    public OpportunityRequest<T> groupByQuotesWithDetails(QuoteRequest subRequest){
       aggregate(Opportunity.QUOTE_LIST_PROPERTY, subRequest);
       return this;
    }

    public OpportunityRequest<T> groupById(){
       groupBy(Opportunity.ID_PROPERTY);
       return this;
    }

    public OpportunityRequest<T> groupByIdAs(String retName){
       groupBy(retName, Opportunity.ID_PROPERTY);
       return this;
    }

    public OpportunityRequest<T> groupByIdWithFunction(String retName, AggrFunction function){
       groupBy(retName, Opportunity.ID_PROPERTY, function);
       return this;
    }

    public OpportunityRequest<T> groupByCloseDate(){
       groupBy(Opportunity.CLOSE_DATE_PROPERTY);
       return this;
    }

    public OpportunityRequest<T> groupByCloseDateAs(String retName){
       groupBy(retName, Opportunity.CLOSE_DATE_PROPERTY);
       return this;
    }

    public OpportunityRequest<T> groupByCloseDateWithFunction(String retName, AggrFunction function){
       groupBy(retName, Opportunity.CLOSE_DATE_PROPERTY, function);
       return this;
    }

    public OpportunityRequest<T> groupByExpectedRevenue(){
       groupBy(Opportunity.EXPECTED_REVENUE_PROPERTY);
       return this;
    }

    public OpportunityRequest<T> groupByExpectedRevenueAs(String retName){
       groupBy(retName, Opportunity.EXPECTED_REVENUE_PROPERTY);
       return this;
    }

    public OpportunityRequest<T> groupByExpectedRevenueWithFunction(String retName, AggrFunction function){
       groupBy(retName, Opportunity.EXPECTED_REVENUE_PROPERTY, function);
       return this;
    }
    public OpportunityRequest<T> groupByLeadWith(LeadRequest subRequest){
       groupBy(Opportunity.LEAD_PROPERTY, subRequest);
       return this;
    }
    public OpportunityRequest<T> groupByLead(){
       groupBy(Opportunity.LEAD_PROPERTY);
       return this;
    }

    public OpportunityRequest<T> groupByLeadAs(String retName){
       groupBy(retName, Opportunity.LEAD_PROPERTY);
       return this;
    }

    public OpportunityRequest<T> groupByLeadWithFunction(String retName, AggrFunction function){
       groupBy(retName, Opportunity.LEAD_PROPERTY, function);
       return this;
    }

    public OpportunityRequest<T> groupByProbability(){
       groupBy(Opportunity.PROBABILITY_PROPERTY);
       return this;
    }

    public OpportunityRequest<T> groupByProbabilityAs(String retName){
       groupBy(retName, Opportunity.PROBABILITY_PROPERTY);
       return this;
    }

    public OpportunityRequest<T> groupByProbabilityWithFunction(String retName, AggrFunction function){
       groupBy(retName, Opportunity.PROBABILITY_PROPERTY, function);
       return this;
    }

    public OpportunityRequest<T> groupByStatus(){
       groupBy(Opportunity.STATUS_PROPERTY);
       return this;
    }

    public OpportunityRequest<T> groupByStatusAs(String retName){
       groupBy(retName, Opportunity.STATUS_PROPERTY);
       return this;
    }

    public OpportunityRequest<T> groupByStatusWithFunction(String retName, AggrFunction function){
       groupBy(retName, Opportunity.STATUS_PROPERTY, function);
       return this;
    }

    public OpportunityRequest<T> groupByCreateTime(){
       groupBy(Opportunity.CREATE_TIME_PROPERTY);
       return this;
    }

    public OpportunityRequest<T> groupByCreateTimeAs(String retName){
       groupBy(retName, Opportunity.CREATE_TIME_PROPERTY);
       return this;
    }

    public OpportunityRequest<T> groupByCreateTimeWithFunction(String retName, AggrFunction function){
       groupBy(retName, Opportunity.CREATE_TIME_PROPERTY, function);
       return this;
    }

    public OpportunityRequest<T> groupByUpdateTime(){
       groupBy(Opportunity.UPDATE_TIME_PROPERTY);
       return this;
    }

    public OpportunityRequest<T> groupByUpdateTimeAs(String retName){
       groupBy(retName, Opportunity.UPDATE_TIME_PROPERTY);
       return this;
    }

    public OpportunityRequest<T> groupByUpdateTimeWithFunction(String retName, AggrFunction function){
       groupBy(retName, Opportunity.UPDATE_TIME_PROPERTY, function);
       return this;
    }

    public OpportunityRequest<T> groupByVersion(){
       groupBy(Opportunity.VERSION_PROPERTY);
       return this;
    }

    public OpportunityRequest<T> groupByVersionAs(String retName){
       groupBy(retName, Opportunity.VERSION_PROPERTY);
       return this;
    }

    public OpportunityRequest<T> groupByVersionWithFunction(String retName, AggrFunction function){
       groupBy(retName, Opportunity.VERSION_PROPERTY, function);
       return this;
    }



    public OpportunityRequest<T> orderByIdAscending(){
       addOrderByAscending(Opportunity.ID_PROPERTY);
       return this;
    }

    public OpportunityRequest<T> orderByIdDescending(){
       addOrderByDescending(Opportunity.ID_PROPERTY);
       return this;
    }

    public OpportunityRequest<T> orderByCloseDateAscending(){
       addOrderByAscending(Opportunity.CLOSE_DATE_PROPERTY);
       return this;
    }

    public OpportunityRequest<T> orderByCloseDateDescending(){
       addOrderByDescending(Opportunity.CLOSE_DATE_PROPERTY);
       return this;
    }

    public OpportunityRequest<T> orderByExpectedRevenueAscending(){
       addOrderByAscending(Opportunity.EXPECTED_REVENUE_PROPERTY);
       return this;
    }

    public OpportunityRequest<T> orderByExpectedRevenueDescending(){
       addOrderByDescending(Opportunity.EXPECTED_REVENUE_PROPERTY);
       return this;
    }

    public OpportunityRequest<T> orderByLeadAscending(){
       addOrderByAscending(Opportunity.LEAD_PROPERTY);
       return this;
    }

    public OpportunityRequest<T> orderByLeadDescending(){
       addOrderByDescending(Opportunity.LEAD_PROPERTY);
       return this;
    }

    public OpportunityRequest<T> orderByProbabilityAscending(){
       addOrderByAscending(Opportunity.PROBABILITY_PROPERTY);
       return this;
    }

    public OpportunityRequest<T> orderByProbabilityDescending(){
       addOrderByDescending(Opportunity.PROBABILITY_PROPERTY);
       return this;
    }

    public OpportunityRequest<T> orderByStatusAscending(){
       addOrderByAscending(Opportunity.STATUS_PROPERTY);
       return this;
    }

    public OpportunityRequest<T> orderByStatusDescending(){
       addOrderByDescending(Opportunity.STATUS_PROPERTY);
       return this;
    }
    public OpportunityRequest<T> orderByStatusAscendingUsingGBK(){
       addOrderByAscendingUsingGBK(Opportunity.STATUS_PROPERTY);
       return this;
    }

    public OpportunityRequest<T> orderByStatusDescendingUsingGBK(){
       addOrderByDescendingUsingGBK(Opportunity.STATUS_PROPERTY);
       return this;
    }
    public OpportunityRequest<T> orderByCreateTimeAscending(){
       addOrderByAscending(Opportunity.CREATE_TIME_PROPERTY);
       return this;
    }

    public OpportunityRequest<T> orderByCreateTimeDescending(){
       addOrderByDescending(Opportunity.CREATE_TIME_PROPERTY);
       return this;
    }

    public OpportunityRequest<T> orderByUpdateTimeAscending(){
       addOrderByAscending(Opportunity.UPDATE_TIME_PROPERTY);
       return this;
    }

    public OpportunityRequest<T> orderByUpdateTimeDescending(){
       addOrderByDescending(Opportunity.UPDATE_TIME_PROPERTY);
       return this;
    }

    public OpportunityRequest<T> orderByVersionAscending(){
       addOrderByAscending(Opportunity.VERSION_PROPERTY);
       return this;
    }

    public OpportunityRequest<T> orderByVersionDescending(){
       addOrderByDescending(Opportunity.VERSION_PROPERTY);
       return this;
    }


    public OpportunityRequest<T> statsFromQuotesAs(String name, QuoteRequest subRequest){
       return statsFromQuotesAs(name, subRequest, false);
    }

    public OpportunityRequest<T> statsFromQuotesAs(String name, QuoteRequest subRequest, boolean singleResult){
       subRequest.setPartitionProperty(Quote.OPPORTUNITY_PROPERTY);
       addAggregateDynamicProperty(name, subRequest, singleResult);
       return this;
    }

    public OpportunityRequest<T> statsFromQuotes(QuoteRequest subRequest){
       return statsFromQuotesAs(REFINEMENTS, subRequest);
    }
    public LeadRequest rollUpToLead(){
       LeadRequest lead = Q.leads().unlimited();
       this.withLeadMatching(lead)
           .groupByLeadWith(lead);
       return lead;
    }






    public OpportunityRequest<T> countQuotes(){
        return countQuotesAs("Count");
    }

    public OpportunityRequest<T> countQuotesAs(String name){
        return countQuotesWith(name, Q.quotes().unlimited());
    }

    public OpportunityRequest<T> countQuotesWith(String name, QuoteRequest subRequest){
        return statsFromQuotesAs(name, subRequest.count(), true);
    }
    public OpportunityRequest<T> minTotalAmountOfQuotes(){
        return minTotalAmountOfQuotesAs("minTotalAmountOfQuotes");
    }

    public OpportunityRequest<T> minTotalAmountOfQuotesAs(String name){
        return minTotalAmountOfQuotesAs(name, Q.quotes().unlimited());
    }

    public OpportunityRequest<T> minTotalAmountOfQuotesAs(String name, QuoteRequest subRequest){
        return statsFromQuotesAs(name, subRequest.minTotalAmount(), true);
    }
    public OpportunityRequest<T> maxTotalAmountOfQuotes(){
        return maxTotalAmountOfQuotesAs("maxTotalAmountOfQuotes");
    }

    public OpportunityRequest<T> maxTotalAmountOfQuotesAs(String name){
        return maxTotalAmountOfQuotesAs(name, Q.quotes().unlimited());
    }

    public OpportunityRequest<T> maxTotalAmountOfQuotesAs(String name, QuoteRequest subRequest){
        return statsFromQuotesAs(name, subRequest.maxTotalAmount(), true);
    }
    public OpportunityRequest<T> sumTotalAmountOfQuotes(){
        return sumTotalAmountOfQuotesAs("sumTotalAmountOfQuotes");
    }

    public OpportunityRequest<T> sumTotalAmountOfQuotesAs(String name){
        return sumTotalAmountOfQuotesAs(name, Q.quotes().unlimited());
    }

    public OpportunityRequest<T> sumTotalAmountOfQuotesAs(String name, QuoteRequest subRequest){
        return statsFromQuotesAs(name, subRequest.sumTotalAmount(), true);
    }
    public OpportunityRequest<T> avgTotalAmountOfQuotes(){
        return avgTotalAmountOfQuotesAs("avgTotalAmountOfQuotes");
    }

    public OpportunityRequest<T> avgTotalAmountOfQuotesAs(String name){
        return avgTotalAmountOfQuotesAs(name, Q.quotes().unlimited());
    }

    public OpportunityRequest<T> avgTotalAmountOfQuotesAs(String name, QuoteRequest subRequest){
        return statsFromQuotesAs(name, subRequest.avgTotalAmount(), true);
    }
    public OpportunityRequest<T> standardDeviationTotalAmountOfQuotes(){
        return standardDeviationTotalAmountOfQuotesAs("stdDevTotalAmountOfQuotes");
    }

    public OpportunityRequest<T> standardDeviationTotalAmountOfQuotesAs(String name){
        return standardDeviationTotalAmountOfQuotesAs(name, Q.quotes().unlimited());
    }

    public OpportunityRequest<T> standardDeviationTotalAmountOfQuotesAs(String name, QuoteRequest subRequest){
        return statsFromQuotesAs(name, subRequest.standardDeviationTotalAmount(), true);
    }
    public OpportunityRequest<T> squareRootOfPopulationStandardDeviationTotalAmountOfQuotes(){
        return squareRootOfPopulationStandardDeviationTotalAmountOfQuotesAs("stdDevPopTotalAmountOfQuotes");
    }

    public OpportunityRequest<T> squareRootOfPopulationStandardDeviationTotalAmountOfQuotesAs(String name){
        return squareRootOfPopulationStandardDeviationTotalAmountOfQuotesAs(name, Q.quotes().unlimited());
    }

    public OpportunityRequest<T> squareRootOfPopulationStandardDeviationTotalAmountOfQuotesAs(String name, QuoteRequest subRequest){
        return statsFromQuotesAs(name, subRequest.squareRootOfPopulationStandardDeviationTotalAmount(), true);
    }
    public OpportunityRequest<T> sampleVarianceTotalAmountOfQuotes(){
        return sampleVarianceTotalAmountOfQuotesAs("varSampTotalAmountOfQuotes");
    }

    public OpportunityRequest<T> sampleVarianceTotalAmountOfQuotesAs(String name){
        return sampleVarianceTotalAmountOfQuotesAs(name, Q.quotes().unlimited());
    }

    public OpportunityRequest<T> sampleVarianceTotalAmountOfQuotesAs(String name, QuoteRequest subRequest){
        return statsFromQuotesAs(name, subRequest.sampleVarianceTotalAmount(), true);
    }
    public OpportunityRequest<T> samplePopulationVarianceTotalAmountOfQuotes(){
        return samplePopulationVarianceTotalAmountOfQuotesAs("varPopTotalAmountOfQuotes");
    }

    public OpportunityRequest<T> samplePopulationVarianceTotalAmountOfQuotesAs(String name){
        return samplePopulationVarianceTotalAmountOfQuotesAs(name, Q.quotes().unlimited());
    }

    public OpportunityRequest<T> samplePopulationVarianceTotalAmountOfQuotesAs(String name, QuoteRequest subRequest){
        return statsFromQuotesAs(name, subRequest.samplePopulationVarianceTotalAmount(), true);
    }

   public OpportunityRequest<T> facetByLeadAs(String facetName, LeadRequest lead){
       return facetByLeadAs(facetName, lead, true);
   }

   public OpportunityRequest<T> facetByLeadAs(String facetName, LeadRequest lead, boolean includeAllFacets){
       addFacet(facetName, Opportunity.LEAD_PROPERTY, lead, includeAllFacets);
       return this;
   }


    /**
     * get topN records
     * @param topN  records number
     */
    public OpportunityRequest<T> top(int topN) {
        super.top(topN);
        return this;
    }

    /**
     * get records from offset(inclusive) to offset+size(exclusive)
     * @param offset record offset
     * @param size records number
     */
    public OpportunityRequest<T> offset(int offset, int size) {
        super.offset(offset, size);
        return this;
    }

    /**
     * retrieve all records
     */
    public OpportunityRequest<T> unlimited() {
        super.unlimited();
        return this;
    }

    /**
     * get records of one page
     * @param pageNumber page number(1-based)
     * @param pageSize page size
     */
    public OpportunityRequest<T> page(int pageNumber, int pageSize) {
        int offset = (pageNumber - 1) * pageSize;
        return offset(offset, pageSize);
   }

    /**
     * get records of one page, default page size is 10
     * @param pageNumber page number(1-based)
     */
    public OpportunityRequest<T> page(int pageNumber) {
        return page(pageNumber, 10);
   }
}