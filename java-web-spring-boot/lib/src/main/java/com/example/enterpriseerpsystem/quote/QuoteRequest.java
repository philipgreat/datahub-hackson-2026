
package com.example.enterpriseerpsystem.quote;

import com.example.enterpriseerpsystem.Q;
import com.example.enterpriseerpsystem.opportunity.Opportunity;
import com.example.enterpriseerpsystem.opportunity.OpportunityRequest;
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

public class QuoteRequest<T extends Quote> extends BaseRequest<T> {

    /**
     * @deprecated AI agents and business code must use the generated Q facade
     *             instead of constructing request builders directly.
     */
    @Deprecated
    public QuoteRequest(Class<T> returnType){
        super(returnType);
        selectId();
        selectVersion();
    }

    public QuoteRequest<T> comment(String comment){
         super.internalComment(comment);
         return this;
    }

    // purpose() 继承自 BaseRequest，返回 ExecutableRequest（终结方法）

    public QuoteRequest<T> returnType(Class<? extends T> returnType){
        super.setReturnType(returnType);
        return this;
    }

    public QuoteRequest<T> enableAggregationCache(long cacheExpiredMillis){
        super.enableAggregationCache();
        super.aggregateCacheTime(cacheExpiredMillis);
        return this;
    }

    public QuoteRequest<T> enableAggregationCache(){
        return enableAggregationCache(0l);
    }


    public QuoteRequest<T> propagateAggregationCache(long cacheExpiredMillis){
        super.propagateAggregationCache(cacheExpiredMillis);
        return this;
    }

    public QuoteRequest<T> appendSearchCriteria(SearchCriteria searchCriteria){
        return (QuoteRequest<T>)super.appendSearchCriteria(searchCriteria);
    }

    public QuoteRequest<T> filter(String property1, Operator operator, String property2){
        return appendSearchCriteria(new TwoOperatorCriteria(operator, new PropertyReference(property1), new PropertyReference(property2)));
    }


    public QuoteRequest<T> matchingAnyOf(QuoteRequest quote){
        super.internalMatchAny(quote);
        return this;
    }

    public QuoteRequest<T> enhanceChildrenIfNeeded(){
        return this;
    }

    public QuoteRequest<T> withDeletedRows(){
        super.withDeletedRows();
        return this;
    }

    public QuoteRequest<T> deletedRowsOnly(){
        super.deletedRowsOnly();
        return this;
    }

    public QuoteRequest<T> selectSelf(){
        super.selectSelf();
        return selectId().selectTotalAmount().selectOpportunityIdOnly().selectStatus().selectValidUntil().selectCreateTime().selectUpdateTime().selectVersion();
    }

    public QuoteRequest<T> selectSelfFields(){
        return selectSelf();
    }

    public QuoteRequest<T> selectAll(){
        super.selectAll();
        return selectId().selectTotalAmount().selectOpportunity().selectStatus().selectValidUntil().selectCreateTime().selectUpdateTime().selectVersion();
    }

    public QuoteRequest<T> selectChildren(){
        super.selectAny();
        return selectId().selectTotalAmount().selectOpportunity().selectStatus().selectValidUntil().selectCreateTime().selectUpdateTime().selectVersion();
    }


    public QuoteRequest<T> selectId(){
       selectProperty(Quote.ID_PROPERTY);
       return this;
    }

    /**
     * fill the id with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  id) to fetch id property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public QuoteRequest<T> unselectId(){
       unselectProperty(Quote.ID_PROPERTY);
       return this;
    }
    public QuoteRequest<T> selectTotalAmount(){
       selectProperty(Quote.TOTAL_AMOUNT_PROPERTY);
       return this;
    }

    /**
     * fill the totalAmount with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  totalAmount) to fetch totalAmount property.
     * @param rawSqlSegment  customized rawSqlSegment
     */


    /**
     * fill the totalAmount with customized aggrFunction, TEAQL uses ({aggrFunction}(totalAmount) AS totalAmount to fetch totalAmount property.
     * @param aggrFunction  aggrFunction
     */
    public QuoteRequest<T> selectTotalAmount(AggrFunction aggrFunction){
       selectProperty(Quote.TOTAL_AMOUNT_PROPERTY, aggrFunction);
       return this;
    }


    public QuoteRequest<T> unselectTotalAmount(){
       unselectProperty(Quote.TOTAL_AMOUNT_PROPERTY);
       return this;
    }
    public QuoteRequest<T> selectOpportunityIdOnly(){
       selectProperty(Quote.OPPORTUNITY_PROPERTY);
       return this;
    }

    public QuoteRequest<T> selectOpportunity(){
        return selectOpportunityWith(Q.opportunities().unlimited().selectSelf());
    }

    public QuoteRequest<T> selectOpportunityWith(OpportunityRequest opportunity){
       selectProperty(Quote.OPPORTUNITY_PROPERTY);
       enhanceRelation(Quote.OPPORTUNITY_PROPERTY, opportunity);
       return this;
    }

    public QuoteRequest<T> unselectOpportunity(){
       unselectProperty(Quote.OPPORTUNITY_PROPERTY);
       return this;
    }
    public QuoteRequest<T> selectStatus(){
       selectProperty(Quote.STATUS_PROPERTY);
       return this;
    }

    /**
     * fill the status with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  status) to fetch status property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public QuoteRequest<T> unselectStatus(){
       unselectProperty(Quote.STATUS_PROPERTY);
       return this;
    }
    public QuoteRequest<T> selectValidUntil(){
       selectProperty(Quote.VALID_UNTIL_PROPERTY);
       return this;
    }

    /**
     * fill the validUntil with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  validUntil) to fetch validUntil property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public QuoteRequest<T> unselectValidUntil(){
       unselectProperty(Quote.VALID_UNTIL_PROPERTY);
       return this;
    }
    public QuoteRequest<T> selectCreateTime(){
       selectProperty(Quote.CREATE_TIME_PROPERTY);
       return this;
    }

    /**
     * fill the createTime with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  createTime) to fetch createTime property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public QuoteRequest<T> unselectCreateTime(){
       unselectProperty(Quote.CREATE_TIME_PROPERTY);
       return this;
    }
    public QuoteRequest<T> selectUpdateTime(){
       selectProperty(Quote.UPDATE_TIME_PROPERTY);
       return this;
    }

    /**
     * fill the updateTime with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  updateTime) to fetch updateTime property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public QuoteRequest<T> unselectUpdateTime(){
       unselectProperty(Quote.UPDATE_TIME_PROPERTY);
       return this;
    }
    public QuoteRequest<T> selectVersion(){
       selectProperty(Quote.VERSION_PROPERTY);
       return this;
    }

    /**
     * fill the version with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  version) to fetch version property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public QuoteRequest<T> unselectVersion(){
       unselectProperty(Quote.VERSION_PROPERTY);
       return this;
    }

    public QuoteRequest<T> withId(Operator operator, Object... values){
       return appendSearchCriteria(createIdCriteria(operator, values));
    }

    public SearchCriteria createIdCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Quote.ID_PROPERTY, operator, values);
    }

    public QuoteRequest<T> withIdIs(Long id){
       return withId(Operator.EQUAL, id);
    }
    public QuoteRequest<T> withIdIn(Long... id){
       return withId(Operator.EQUAL, (Object[])id);
    }



    public QuoteRequest<T> filterByTotalAmount(BigDecimal... totalAmount){
      if (totalAmount == null || totalAmount.length == 0) {
        throw new IllegalArgumentException("filterByTotalAmount parameter totalAmount cannot be empty");
      }
      return appendSearchCriteria(createTotalAmountCriteria(Operator.EQUAL, (Object[])totalAmount));
    }

    public QuoteRequest<T> withTotalAmount(Operator operator, Object... values){
       return appendSearchCriteria(createTotalAmountCriteria(operator, values));
    }

    public QuoteRequest<T> withTotalAmountIsUnknown(){
       return withTotalAmount(Operator.IS_NULL);
    }

    public QuoteRequest<T> withTotalAmountIsKnown(){
       return withTotalAmount(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createTotalAmountCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Quote.TOTAL_AMOUNT_PROPERTY, operator, values);
    }

    public QuoteRequest<T> withTotalAmountGreaterThan(BigDecimal totalAmount){
       return withTotalAmount(Operator.GREATER_THAN, totalAmount);
    }

    public QuoteRequest<T> withTotalAmountGreaterThanOrEqualTo(BigDecimal totalAmount){
       return withTotalAmount(Operator.GREATER_THAN_OR_EQUAL, totalAmount);
    }

    public QuoteRequest<T> withTotalAmountLessThan(BigDecimal totalAmount){
       return withTotalAmount(Operator.LESS_THAN, totalAmount);
    }

    public QuoteRequest<T> withTotalAmountLessThanOrEqualTo(BigDecimal totalAmount){
       return withTotalAmount(Operator.LESS_THAN_OR_EQUAL, totalAmount);
    }

    public QuoteRequest<T> withTotalAmountBetween(BigDecimal startOfTotalAmount, BigDecimal endOfTotalAmount){
       return withTotalAmount(Operator.BETWEEN, startOfTotalAmount, endOfTotalAmount);
    }



    public QuoteRequest<T> filterByOpportunity(Opportunity... opportunity){
      if (opportunity == null || opportunity.length == 0) {
        throw new IllegalArgumentException("filterByOpportunity parameter opportunity cannot be empty");
      }
      return appendSearchCriteria(createOpportunityCriteria(Operator.EQUAL, (Object[])opportunity));
    }

    public QuoteRequest<T> withOpportunity(Operator operator, Object... values){
       return appendSearchCriteria(createOpportunityCriteria(operator, values));
    }

    public QuoteRequest<T> withOpportunityIsUnknown(){
       return withOpportunity(Operator.IS_NULL);
    }

    public QuoteRequest<T> withOpportunityIsKnown(){
       return withOpportunity(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createOpportunityCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Quote.OPPORTUNITY_PROPERTY, operator, values);
    }

    public QuoteRequest<T> filterByOpportunity(Long opportunity){
      if(opportunity == null){
         return this;
      }
      return withOpportunity(Operator.EQUAL, opportunity);
    }
    public QuoteRequest<T> withOpportunityMatching(OpportunityRequest opportunity){
       return appendSearchCriteria(new SubQuerySearchCriteria(Quote.OPPORTUNITY_PROPERTY, opportunity, Opportunity.ID_PROPERTY));
    }

    public QuoteRequest<T> filterByStatus(String... status){
      if (status == null || status.length == 0) {
        throw new IllegalArgumentException("filterByStatus parameter status cannot be empty");
      }
      return appendSearchCriteria(createStatusCriteria(Operator.EQUAL, (Object[])status));
    }

    public QuoteRequest<T> withStatus(Operator operator, Object... values){
       return appendSearchCriteria(createStatusCriteria(operator, values));
    }

    public QuoteRequest<T> withStatusIsUnknown(){
       return withStatus(Operator.IS_NULL);
    }

    public QuoteRequest<T> withStatusIsKnown(){
       return withStatus(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createStatusCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Quote.STATUS_PROPERTY, operator, values);
    }

    public QuoteRequest<T> withStatusGreaterThan(String status){
       return withStatus(Operator.GREATER_THAN, status);
    }

    public QuoteRequest<T> withStatusGreaterThanOrEqualTo(String status){
       return withStatus(Operator.GREATER_THAN_OR_EQUAL, status);
    }

    public QuoteRequest<T> withStatusLessThan(String status){
       return withStatus(Operator.LESS_THAN, status);
    }

    public QuoteRequest<T> withStatusLessThanOrEqualTo(String status){
       return withStatus(Operator.LESS_THAN_OR_EQUAL, status);
    }

    public QuoteRequest<T> withStatusBetween(String startOfStatus, String endOfStatus){
       return withStatus(Operator.BETWEEN, startOfStatus, endOfStatus);
    }
    public QuoteRequest<T> withStatusStartingWith(String status){
       return withStatus(Operator.BEGIN_WITH, status);
    }
    public QuoteRequest<T> withStatusContaining(String status){
       return withStatus(Operator.CONTAIN, status);
    }

    public QuoteRequest<T> withStatusEndingWith(String status){
       return withStatus(Operator.END_WITH, status);
    }

    public QuoteRequest<T> withStatusIs(String status){
       return withStatus(Operator.EQUAL, status);
    }

    public QuoteRequest<T> withStatusSoundingLike(String status){
       return withStatus(Operator.SOUNDS_LIKE, status);
    }



    public QuoteRequest<T> filterByValidUntil(LocalDateTime... validUntil){
      if (validUntil == null || validUntil.length == 0) {
        throw new IllegalArgumentException("filterByValidUntil parameter validUntil cannot be empty");
      }
      return appendSearchCriteria(createValidUntilCriteria(Operator.EQUAL, (Object[])validUntil));
    }

    public QuoteRequest<T> withValidUntil(Operator operator, Object... values){
       return appendSearchCriteria(createValidUntilCriteria(operator, values));
    }

    public QuoteRequest<T> withValidUntilIsUnknown(){
       return withValidUntil(Operator.IS_NULL);
    }

    public QuoteRequest<T> withValidUntilIsKnown(){
       return withValidUntil(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createValidUntilCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Quote.VALID_UNTIL_PROPERTY, operator, values);
    }

    public QuoteRequest<T> withValidUntilGreaterThan(LocalDateTime validUntil){
       return withValidUntil(Operator.GREATER_THAN, validUntil);
    }

    public QuoteRequest<T> withValidUntilGreaterThanOrEqualTo(LocalDateTime validUntil){
       return withValidUntil(Operator.GREATER_THAN_OR_EQUAL, validUntil);
    }

    public QuoteRequest<T> withValidUntilLessThan(LocalDateTime validUntil){
       return withValidUntil(Operator.LESS_THAN, validUntil);
    }

    public QuoteRequest<T> withValidUntilLessThanOrEqualTo(LocalDateTime validUntil){
       return withValidUntil(Operator.LESS_THAN_OR_EQUAL, validUntil);
    }

    public QuoteRequest<T> withValidUntilBetween(LocalDateTime startOfValidUntil, LocalDateTime endOfValidUntil){
       return withValidUntil(Operator.BETWEEN, startOfValidUntil, endOfValidUntil);
    }
    public QuoteRequest<T> withValidUntilBefore(LocalDateTime validUntil){
       return withValidUntil(Operator.LESS_THAN, validUntil);
    }

    public QuoteRequest<T> withValidUntilBefore(Date validUntil){
       return withValidUntil(Operator.LESS_THAN, validUntil);
    }

    public QuoteRequest<T> withValidUntilAfter(LocalDateTime validUntil){
       return withValidUntil(Operator.GREATER_THAN, validUntil);
    }

    public QuoteRequest<T> withValidUntilAfter(Date validUntil){
       return withValidUntil(Operator.GREATER_THAN, validUntil);
    }

    public QuoteRequest<T> withValidUntilBetween(Date startOfValidUntil, Date endOfValidUntil){
       return withValidUntil(Operator.BETWEEN, startOfValidUntil, endOfValidUntil);
    }




    public QuoteRequest<T> filterByCreateTime(LocalDateTime... createTime){
      if (createTime == null || createTime.length == 0) {
        throw new IllegalArgumentException("filterByCreateTime parameter createTime cannot be empty");
      }
      return appendSearchCriteria(createCreateTimeCriteria(Operator.EQUAL, (Object[])createTime));
    }

    public QuoteRequest<T> withCreateTime(Operator operator, Object... values){
       return appendSearchCriteria(createCreateTimeCriteria(operator, values));
    }

    public QuoteRequest<T> withCreateTimeIsUnknown(){
       return withCreateTime(Operator.IS_NULL);
    }

    public QuoteRequest<T> withCreateTimeIsKnown(){
       return withCreateTime(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createCreateTimeCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Quote.CREATE_TIME_PROPERTY, operator, values);
    }

    public QuoteRequest<T> withCreateTimeGreaterThan(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public QuoteRequest<T> withCreateTimeGreaterThanOrEqualTo(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN_OR_EQUAL, createTime);
    }

    public QuoteRequest<T> withCreateTimeLessThan(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public QuoteRequest<T> withCreateTimeLessThanOrEqualTo(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN_OR_EQUAL, createTime);
    }

    public QuoteRequest<T> withCreateTimeBetween(LocalDateTime startOfCreateTime, LocalDateTime endOfCreateTime){
       return withCreateTime(Operator.BETWEEN, startOfCreateTime, endOfCreateTime);
    }
    public QuoteRequest<T> withCreateTimeBefore(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public QuoteRequest<T> withCreateTimeBefore(Date createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public QuoteRequest<T> withCreateTimeAfter(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public QuoteRequest<T> withCreateTimeAfter(Date createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public QuoteRequest<T> withCreateTimeBetween(Date startOfCreateTime, Date endOfCreateTime){
       return withCreateTime(Operator.BETWEEN, startOfCreateTime, endOfCreateTime);
    }




    public QuoteRequest<T> filterByUpdateTime(LocalDateTime... updateTime){
      if (updateTime == null || updateTime.length == 0) {
        throw new IllegalArgumentException("filterByUpdateTime parameter updateTime cannot be empty");
      }
      return appendSearchCriteria(createUpdateTimeCriteria(Operator.EQUAL, (Object[])updateTime));
    }

    public QuoteRequest<T> withUpdateTime(Operator operator, Object... values){
       return appendSearchCriteria(createUpdateTimeCriteria(operator, values));
    }

    public QuoteRequest<T> withUpdateTimeIsUnknown(){
       return withUpdateTime(Operator.IS_NULL);
    }

    public QuoteRequest<T> withUpdateTimeIsKnown(){
       return withUpdateTime(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createUpdateTimeCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Quote.UPDATE_TIME_PROPERTY, operator, values);
    }

    public QuoteRequest<T> withUpdateTimeGreaterThan(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public QuoteRequest<T> withUpdateTimeGreaterThanOrEqualTo(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN_OR_EQUAL, updateTime);
    }

    public QuoteRequest<T> withUpdateTimeLessThan(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public QuoteRequest<T> withUpdateTimeLessThanOrEqualTo(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN_OR_EQUAL, updateTime);
    }

    public QuoteRequest<T> withUpdateTimeBetween(LocalDateTime startOfUpdateTime, LocalDateTime endOfUpdateTime){
       return withUpdateTime(Operator.BETWEEN, startOfUpdateTime, endOfUpdateTime);
    }
    public QuoteRequest<T> withUpdateTimeBefore(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public QuoteRequest<T> withUpdateTimeBefore(Date updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public QuoteRequest<T> withUpdateTimeAfter(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public QuoteRequest<T> withUpdateTimeAfter(Date updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public QuoteRequest<T> withUpdateTimeBetween(Date startOfUpdateTime, Date endOfUpdateTime){
       return withUpdateTime(Operator.BETWEEN, startOfUpdateTime, endOfUpdateTime);
    }




    public QuoteRequest<T> filterByVersion(Long... version){
      if (version == null || version.length == 0) {
        throw new IllegalArgumentException("filterByVersion parameter version cannot be empty");
      }
      return appendSearchCriteria(createVersionCriteria(Operator.EQUAL, (Object[])version));
    }

    public QuoteRequest<T> withVersion(Operator operator, Object... values){
       return appendSearchCriteria(createVersionCriteria(operator, values));
    }

    public QuoteRequest<T> withVersionIsUnknown(){
       return withVersion(Operator.IS_NULL);
    }

    public QuoteRequest<T> withVersionIsKnown(){
       return withVersion(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createVersionCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Quote.VERSION_PROPERTY, operator, values);
    }

    public QuoteRequest<T> withVersionGreaterThan(Long version){
       return withVersion(Operator.GREATER_THAN, version);
    }

    public QuoteRequest<T> withVersionGreaterThanOrEqualTo(Long version){
       return withVersion(Operator.GREATER_THAN_OR_EQUAL, version);
    }

    public QuoteRequest<T> withVersionLessThan(Long version){
       return withVersion(Operator.LESS_THAN, version);
    }

    public QuoteRequest<T> withVersionLessThanOrEqualTo(Long version){
       return withVersion(Operator.LESS_THAN_OR_EQUAL, version);
    }

    public QuoteRequest<T> withVersionBetween(Long startOfVersion, Long endOfVersion){
       return withVersion(Operator.BETWEEN, startOfVersion, endOfVersion);
    }


    public QuoteRequest<T> count(){
        super.count();
        return this;
    }
    public QuoteRequest<T> countAs(String retName){
        super.count(retName);
        return this;
    }
    public QuoteRequest minTotalAmount(){
        return minTotalAmountAs(prefix("minOf",Quote.TOTAL_AMOUNT_PROPERTY));
    }

    public QuoteRequest minTotalAmountAs(String retName){
        super.min(retName, Quote.TOTAL_AMOUNT_PROPERTY);
        return this;
    }
    public QuoteRequest maxTotalAmount(){
        return maxTotalAmountAs(prefix("maxOf",Quote.TOTAL_AMOUNT_PROPERTY));
    }

    public QuoteRequest maxTotalAmountAs(String retName){
        super.max(retName, Quote.TOTAL_AMOUNT_PROPERTY);
        return this;
    }
    public QuoteRequest sumTotalAmount(){
        return sumTotalAmountAs(prefix("sumOf",Quote.TOTAL_AMOUNT_PROPERTY));
    }

    public QuoteRequest sumTotalAmountAs(String retName){
        super.sum(retName, Quote.TOTAL_AMOUNT_PROPERTY);
        return this;
    }
    public QuoteRequest avgTotalAmount(){
        return avgTotalAmountAs(prefix("avgOf",Quote.TOTAL_AMOUNT_PROPERTY));
    }

    public QuoteRequest avgTotalAmountAs(String retName){
        super.avg(retName, Quote.TOTAL_AMOUNT_PROPERTY);
        return this;
    }
    public QuoteRequest standardDeviationTotalAmount(){
        return standardDeviationTotalAmountAs(prefix("standardDeviationOf",Quote.TOTAL_AMOUNT_PROPERTY));
    }

    public QuoteRequest standardDeviationTotalAmountAs(String retName){
        super.standardDeviation(retName, Quote.TOTAL_AMOUNT_PROPERTY);
        return this;
    }
    public QuoteRequest squareRootOfPopulationStandardDeviationTotalAmount(){
        return squareRootOfPopulationStandardDeviationTotalAmountAs(prefix("squareRootOfPopulationStandardDeviationOf",Quote.TOTAL_AMOUNT_PROPERTY));
    }

    public QuoteRequest squareRootOfPopulationStandardDeviationTotalAmountAs(String retName){
        super.squareRootOfPopulationStandardDeviation(retName, Quote.TOTAL_AMOUNT_PROPERTY);
        return this;
    }
    public QuoteRequest sampleVarianceTotalAmount(){
        return sampleVarianceTotalAmountAs(prefix("sampleVarianceOf",Quote.TOTAL_AMOUNT_PROPERTY));
    }

    public QuoteRequest sampleVarianceTotalAmountAs(String retName){
        super.sampleVariance(retName, Quote.TOTAL_AMOUNT_PROPERTY);
        return this;
    }
    public QuoteRequest samplePopulationVarianceTotalAmount(){
        return samplePopulationVarianceTotalAmountAs(prefix("samplePopulationVarianceOf",Quote.TOTAL_AMOUNT_PROPERTY));
    }

    public QuoteRequest samplePopulationVarianceTotalAmountAs(String retName){
        super.samplePopulationVariance(retName, Quote.TOTAL_AMOUNT_PROPERTY);
        return this;
    }
    public QuoteRequest<T> groupByOpportunityWithDetails(){
       return groupByOpportunityWithDetails(Q.opportunities().unlimited());
    }

    public QuoteRequest<T> groupByOpportunityWithDetails(OpportunityRequest subRequest){
       aggregate(Quote.OPPORTUNITY_PROPERTY, subRequest);
       return this;
    }







    public QuoteRequest<T> groupById(){
       groupBy(Quote.ID_PROPERTY);
       return this;
    }

    public QuoteRequest<T> groupByIdAs(String retName){
       groupBy(retName, Quote.ID_PROPERTY);
       return this;
    }

    public QuoteRequest<T> groupByIdWithFunction(String retName, AggrFunction function){
       groupBy(retName, Quote.ID_PROPERTY, function);
       return this;
    }

    public QuoteRequest<T> groupByTotalAmount(){
       groupBy(Quote.TOTAL_AMOUNT_PROPERTY);
       return this;
    }

    public QuoteRequest<T> groupByTotalAmountAs(String retName){
       groupBy(retName, Quote.TOTAL_AMOUNT_PROPERTY);
       return this;
    }

    public QuoteRequest<T> groupByTotalAmountWithFunction(String retName, AggrFunction function){
       groupBy(retName, Quote.TOTAL_AMOUNT_PROPERTY, function);
       return this;
    }
    public QuoteRequest<T> groupByOpportunityWith(OpportunityRequest subRequest){
       groupBy(Quote.OPPORTUNITY_PROPERTY, subRequest);
       return this;
    }
    public QuoteRequest<T> groupByOpportunity(){
       groupBy(Quote.OPPORTUNITY_PROPERTY);
       return this;
    }

    public QuoteRequest<T> groupByOpportunityAs(String retName){
       groupBy(retName, Quote.OPPORTUNITY_PROPERTY);
       return this;
    }

    public QuoteRequest<T> groupByOpportunityWithFunction(String retName, AggrFunction function){
       groupBy(retName, Quote.OPPORTUNITY_PROPERTY, function);
       return this;
    }

    public QuoteRequest<T> groupByStatus(){
       groupBy(Quote.STATUS_PROPERTY);
       return this;
    }

    public QuoteRequest<T> groupByStatusAs(String retName){
       groupBy(retName, Quote.STATUS_PROPERTY);
       return this;
    }

    public QuoteRequest<T> groupByStatusWithFunction(String retName, AggrFunction function){
       groupBy(retName, Quote.STATUS_PROPERTY, function);
       return this;
    }

    public QuoteRequest<T> groupByValidUntil(){
       groupBy(Quote.VALID_UNTIL_PROPERTY);
       return this;
    }

    public QuoteRequest<T> groupByValidUntilAs(String retName){
       groupBy(retName, Quote.VALID_UNTIL_PROPERTY);
       return this;
    }

    public QuoteRequest<T> groupByValidUntilWithFunction(String retName, AggrFunction function){
       groupBy(retName, Quote.VALID_UNTIL_PROPERTY, function);
       return this;
    }

    public QuoteRequest<T> groupByCreateTime(){
       groupBy(Quote.CREATE_TIME_PROPERTY);
       return this;
    }

    public QuoteRequest<T> groupByCreateTimeAs(String retName){
       groupBy(retName, Quote.CREATE_TIME_PROPERTY);
       return this;
    }

    public QuoteRequest<T> groupByCreateTimeWithFunction(String retName, AggrFunction function){
       groupBy(retName, Quote.CREATE_TIME_PROPERTY, function);
       return this;
    }

    public QuoteRequest<T> groupByUpdateTime(){
       groupBy(Quote.UPDATE_TIME_PROPERTY);
       return this;
    }

    public QuoteRequest<T> groupByUpdateTimeAs(String retName){
       groupBy(retName, Quote.UPDATE_TIME_PROPERTY);
       return this;
    }

    public QuoteRequest<T> groupByUpdateTimeWithFunction(String retName, AggrFunction function){
       groupBy(retName, Quote.UPDATE_TIME_PROPERTY, function);
       return this;
    }

    public QuoteRequest<T> groupByVersion(){
       groupBy(Quote.VERSION_PROPERTY);
       return this;
    }

    public QuoteRequest<T> groupByVersionAs(String retName){
       groupBy(retName, Quote.VERSION_PROPERTY);
       return this;
    }

    public QuoteRequest<T> groupByVersionWithFunction(String retName, AggrFunction function){
       groupBy(retName, Quote.VERSION_PROPERTY, function);
       return this;
    }



    public QuoteRequest<T> orderByIdAscending(){
       addOrderByAscending(Quote.ID_PROPERTY);
       return this;
    }

    public QuoteRequest<T> orderByIdDescending(){
       addOrderByDescending(Quote.ID_PROPERTY);
       return this;
    }

    public QuoteRequest<T> orderByTotalAmountAscending(){
       addOrderByAscending(Quote.TOTAL_AMOUNT_PROPERTY);
       return this;
    }

    public QuoteRequest<T> orderByTotalAmountDescending(){
       addOrderByDescending(Quote.TOTAL_AMOUNT_PROPERTY);
       return this;
    }

    public QuoteRequest<T> orderByOpportunityAscending(){
       addOrderByAscending(Quote.OPPORTUNITY_PROPERTY);
       return this;
    }

    public QuoteRequest<T> orderByOpportunityDescending(){
       addOrderByDescending(Quote.OPPORTUNITY_PROPERTY);
       return this;
    }

    public QuoteRequest<T> orderByStatusAscending(){
       addOrderByAscending(Quote.STATUS_PROPERTY);
       return this;
    }

    public QuoteRequest<T> orderByStatusDescending(){
       addOrderByDescending(Quote.STATUS_PROPERTY);
       return this;
    }
    public QuoteRequest<T> orderByStatusAscendingUsingGBK(){
       addOrderByAscendingUsingGBK(Quote.STATUS_PROPERTY);
       return this;
    }

    public QuoteRequest<T> orderByStatusDescendingUsingGBK(){
       addOrderByDescendingUsingGBK(Quote.STATUS_PROPERTY);
       return this;
    }
    public QuoteRequest<T> orderByValidUntilAscending(){
       addOrderByAscending(Quote.VALID_UNTIL_PROPERTY);
       return this;
    }

    public QuoteRequest<T> orderByValidUntilDescending(){
       addOrderByDescending(Quote.VALID_UNTIL_PROPERTY);
       return this;
    }

    public QuoteRequest<T> orderByCreateTimeAscending(){
       addOrderByAscending(Quote.CREATE_TIME_PROPERTY);
       return this;
    }

    public QuoteRequest<T> orderByCreateTimeDescending(){
       addOrderByDescending(Quote.CREATE_TIME_PROPERTY);
       return this;
    }

    public QuoteRequest<T> orderByUpdateTimeAscending(){
       addOrderByAscending(Quote.UPDATE_TIME_PROPERTY);
       return this;
    }

    public QuoteRequest<T> orderByUpdateTimeDescending(){
       addOrderByDescending(Quote.UPDATE_TIME_PROPERTY);
       return this;
    }

    public QuoteRequest<T> orderByVersionAscending(){
       addOrderByAscending(Quote.VERSION_PROPERTY);
       return this;
    }

    public QuoteRequest<T> orderByVersionDescending(){
       addOrderByDescending(Quote.VERSION_PROPERTY);
       return this;
    }


    public OpportunityRequest rollUpToOpportunity(){
       OpportunityRequest opportunity = Q.opportunities().unlimited();
       this.withOpportunityMatching(opportunity)
           .groupByOpportunityWith(opportunity);
       return opportunity;
    }







   public QuoteRequest<T> facetByOpportunityAs(String facetName, OpportunityRequest opportunity){
       return facetByOpportunityAs(facetName, opportunity, true);
   }

   public QuoteRequest<T> facetByOpportunityAs(String facetName, OpportunityRequest opportunity, boolean includeAllFacets){
       addFacet(facetName, Quote.OPPORTUNITY_PROPERTY, opportunity, includeAllFacets);
       return this;
   }


    /**
     * get topN records
     * @param topN  records number
     */
    public QuoteRequest<T> top(int topN) {
        super.top(topN);
        return this;
    }

    /**
     * get records from offset(inclusive) to offset+size(exclusive)
     * @param offset record offset
     * @param size records number
     */
    public QuoteRequest<T> offset(int offset, int size) {
        super.offset(offset, size);
        return this;
    }

    /**
     * retrieve all records
     */
    public QuoteRequest<T> unlimited() {
        super.unlimited();
        return this;
    }

    /**
     * get records of one page
     * @param pageNumber page number(1-based)
     * @param pageSize page size
     */
    public QuoteRequest<T> page(int pageNumber, int pageSize) {
        int offset = (pageNumber - 1) * pageSize;
        return offset(offset, pageSize);
   }

    /**
     * get records of one page, default page size is 10
     * @param pageNumber page number(1-based)
     */
    public QuoteRequest<T> page(int pageNumber) {
        return page(pageNumber, 10);
   }
}