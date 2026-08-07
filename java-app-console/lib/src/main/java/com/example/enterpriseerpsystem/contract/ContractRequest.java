
package com.example.enterpriseerpsystem.contract;

import com.example.enterpriseerpsystem.Q;
import com.example.enterpriseerpsystem.customer.Customer;
import com.example.enterpriseerpsystem.customer.CustomerRequest;
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

public class ContractRequest<T extends Contract> extends BaseRequest<T> {

    /**
     * @deprecated AI agents and business code must use the generated Q facade
     *             instead of constructing request builders directly.
     */
    @Deprecated
    public ContractRequest(Class<T> returnType){
        super(returnType);
        selectId();
        selectVersion();
    }

    public ContractRequest<T> comment(String comment){
         super.internalComment(comment);
         return this;
    }

    // purpose() 继承自 BaseRequest，返回 ExecutableRequest（终结方法）

    public ContractRequest<T> returnType(Class<? extends T> returnType){
        super.setReturnType(returnType);
        return this;
    }

    public ContractRequest<T> enableAggregationCache(long cacheExpiredMillis){
        super.enableAggregationCache();
        super.aggregateCacheTime(cacheExpiredMillis);
        return this;
    }

    public ContractRequest<T> enableAggregationCache(){
        return enableAggregationCache(0l);
    }


    public ContractRequest<T> propagateAggregationCache(long cacheExpiredMillis){
        super.propagateAggregationCache(cacheExpiredMillis);
        return this;
    }

    public ContractRequest<T> appendSearchCriteria(SearchCriteria searchCriteria){
        return (ContractRequest<T>)super.appendSearchCriteria(searchCriteria);
    }

    public ContractRequest<T> filter(String property1, Operator operator, String property2){
        return appendSearchCriteria(new TwoOperatorCriteria(operator, new PropertyReference(property1), new PropertyReference(property2)));
    }


    public ContractRequest<T> matchingAnyOf(ContractRequest contract){
        super.internalMatchAny(contract);
        return this;
    }

    public ContractRequest<T> enhanceChildrenIfNeeded(){
        return this;
    }

    public ContractRequest<T> withDeletedRows(){
        super.withDeletedRows();
        return this;
    }

    public ContractRequest<T> deletedRowsOnly(){
        super.deletedRowsOnly();
        return this;
    }

    public ContractRequest<T> selectSelf(){
        super.selectSelf();
        return selectId().selectCustomerIdOnly().selectEndDate().selectStartDate().selectTerms().selectValue().selectCreateTime().selectUpdateTime().selectVersion();
    }

    public ContractRequest<T> selectSelfFields(){
        return selectSelf();
    }

    public ContractRequest<T> selectAll(){
        super.selectAll();
        return selectId().selectCustomer().selectEndDate().selectStartDate().selectTerms().selectValue().selectCreateTime().selectUpdateTime().selectVersion();
    }

    public ContractRequest<T> selectChildren(){
        super.selectAny();
        return selectId().selectCustomer().selectEndDate().selectStartDate().selectTerms().selectValue().selectCreateTime().selectUpdateTime().selectVersion();
    }


    public ContractRequest<T> selectId(){
       selectProperty(Contract.ID_PROPERTY);
       return this;
    }

    /**
     * fill the id with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  id) to fetch id property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public ContractRequest<T> unselectId(){
       unselectProperty(Contract.ID_PROPERTY);
       return this;
    }
    public ContractRequest<T> selectCustomerIdOnly(){
       selectProperty(Contract.CUSTOMER_PROPERTY);
       return this;
    }

    public ContractRequest<T> selectCustomer(){
        return selectCustomerWith(Q.customers().unlimited().selectSelf());
    }

    public ContractRequest<T> selectCustomerWith(CustomerRequest customer){
       selectProperty(Contract.CUSTOMER_PROPERTY);
       enhanceRelation(Contract.CUSTOMER_PROPERTY, customer);
       return this;
    }

    public ContractRequest<T> unselectCustomer(){
       unselectProperty(Contract.CUSTOMER_PROPERTY);
       return this;
    }
    public ContractRequest<T> selectEndDate(){
       selectProperty(Contract.END_DATE_PROPERTY);
       return this;
    }

    /**
     * fill the endDate with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  endDate) to fetch endDate property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public ContractRequest<T> unselectEndDate(){
       unselectProperty(Contract.END_DATE_PROPERTY);
       return this;
    }
    public ContractRequest<T> selectStartDate(){
       selectProperty(Contract.START_DATE_PROPERTY);
       return this;
    }

    /**
     * fill the startDate with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  startDate) to fetch startDate property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public ContractRequest<T> unselectStartDate(){
       unselectProperty(Contract.START_DATE_PROPERTY);
       return this;
    }
    public ContractRequest<T> selectTerms(){
       selectProperty(Contract.TERMS_PROPERTY);
       return this;
    }

    /**
     * fill the terms with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  terms) to fetch terms property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public ContractRequest<T> unselectTerms(){
       unselectProperty(Contract.TERMS_PROPERTY);
       return this;
    }
    public ContractRequest<T> selectValue(){
       selectProperty(Contract.VALUE_PROPERTY);
       return this;
    }

    /**
     * fill the value with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  value) to fetch value property.
     * @param rawSqlSegment  customized rawSqlSegment
     */


    /**
     * fill the value with customized aggrFunction, TEAQL uses ({aggrFunction}(value) AS value to fetch value property.
     * @param aggrFunction  aggrFunction
     */
    public ContractRequest<T> selectValue(AggrFunction aggrFunction){
       selectProperty(Contract.VALUE_PROPERTY, aggrFunction);
       return this;
    }


    public ContractRequest<T> unselectValue(){
       unselectProperty(Contract.VALUE_PROPERTY);
       return this;
    }
    public ContractRequest<T> selectCreateTime(){
       selectProperty(Contract.CREATE_TIME_PROPERTY);
       return this;
    }

    /**
     * fill the createTime with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  createTime) to fetch createTime property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public ContractRequest<T> unselectCreateTime(){
       unselectProperty(Contract.CREATE_TIME_PROPERTY);
       return this;
    }
    public ContractRequest<T> selectUpdateTime(){
       selectProperty(Contract.UPDATE_TIME_PROPERTY);
       return this;
    }

    /**
     * fill the updateTime with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  updateTime) to fetch updateTime property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public ContractRequest<T> unselectUpdateTime(){
       unselectProperty(Contract.UPDATE_TIME_PROPERTY);
       return this;
    }
    public ContractRequest<T> selectVersion(){
       selectProperty(Contract.VERSION_PROPERTY);
       return this;
    }

    /**
     * fill the version with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  version) to fetch version property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public ContractRequest<T> unselectVersion(){
       unselectProperty(Contract.VERSION_PROPERTY);
       return this;
    }

    public ContractRequest<T> withId(Operator operator, Object... values){
       return appendSearchCriteria(createIdCriteria(operator, values));
    }

    public SearchCriteria createIdCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Contract.ID_PROPERTY, operator, values);
    }

    public ContractRequest<T> withIdIs(Long id){
       return withId(Operator.EQUAL, id);
    }
    public ContractRequest<T> withIdIn(Long... id){
       return withId(Operator.EQUAL, (Object[])id);
    }



    public ContractRequest<T> filterByCustomer(Customer... customer){
      if (customer == null || customer.length == 0) {
        throw new IllegalArgumentException("filterByCustomer parameter customer cannot be empty");
      }
      return appendSearchCriteria(createCustomerCriteria(Operator.EQUAL, (Object[])customer));
    }

    public ContractRequest<T> withCustomer(Operator operator, Object... values){
       return appendSearchCriteria(createCustomerCriteria(operator, values));
    }

    public ContractRequest<T> withCustomerIsUnknown(){
       return withCustomer(Operator.IS_NULL);
    }

    public ContractRequest<T> withCustomerIsKnown(){
       return withCustomer(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createCustomerCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Contract.CUSTOMER_PROPERTY, operator, values);
    }

    public ContractRequest<T> filterByCustomer(Long customer){
      if(customer == null){
         return this;
      }
      return withCustomer(Operator.EQUAL, customer);
    }
    public ContractRequest<T> withCustomerMatching(CustomerRequest customer){
       return appendSearchCriteria(new SubQuerySearchCriteria(Contract.CUSTOMER_PROPERTY, customer, Customer.ID_PROPERTY));
    }

    public ContractRequest<T> filterByEndDate(LocalDateTime... endDate){
      if (endDate == null || endDate.length == 0) {
        throw new IllegalArgumentException("filterByEndDate parameter endDate cannot be empty");
      }
      return appendSearchCriteria(createEndDateCriteria(Operator.EQUAL, (Object[])endDate));
    }

    public ContractRequest<T> withEndDate(Operator operator, Object... values){
       return appendSearchCriteria(createEndDateCriteria(operator, values));
    }

    public ContractRequest<T> withEndDateIsUnknown(){
       return withEndDate(Operator.IS_NULL);
    }

    public ContractRequest<T> withEndDateIsKnown(){
       return withEndDate(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createEndDateCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Contract.END_DATE_PROPERTY, operator, values);
    }

    public ContractRequest<T> withEndDateGreaterThan(LocalDateTime endDate){
       return withEndDate(Operator.GREATER_THAN, endDate);
    }

    public ContractRequest<T> withEndDateGreaterThanOrEqualTo(LocalDateTime endDate){
       return withEndDate(Operator.GREATER_THAN_OR_EQUAL, endDate);
    }

    public ContractRequest<T> withEndDateLessThan(LocalDateTime endDate){
       return withEndDate(Operator.LESS_THAN, endDate);
    }

    public ContractRequest<T> withEndDateLessThanOrEqualTo(LocalDateTime endDate){
       return withEndDate(Operator.LESS_THAN_OR_EQUAL, endDate);
    }

    public ContractRequest<T> withEndDateBetween(LocalDateTime startOfEndDate, LocalDateTime endOfEndDate){
       return withEndDate(Operator.BETWEEN, startOfEndDate, endOfEndDate);
    }
    public ContractRequest<T> withEndDateBefore(LocalDateTime endDate){
       return withEndDate(Operator.LESS_THAN, endDate);
    }

    public ContractRequest<T> withEndDateBefore(Date endDate){
       return withEndDate(Operator.LESS_THAN, endDate);
    }

    public ContractRequest<T> withEndDateAfter(LocalDateTime endDate){
       return withEndDate(Operator.GREATER_THAN, endDate);
    }

    public ContractRequest<T> withEndDateAfter(Date endDate){
       return withEndDate(Operator.GREATER_THAN, endDate);
    }

    public ContractRequest<T> withEndDateBetween(Date startOfEndDate, Date endOfEndDate){
       return withEndDate(Operator.BETWEEN, startOfEndDate, endOfEndDate);
    }




    public ContractRequest<T> filterByStartDate(LocalDateTime... startDate){
      if (startDate == null || startDate.length == 0) {
        throw new IllegalArgumentException("filterByStartDate parameter startDate cannot be empty");
      }
      return appendSearchCriteria(createStartDateCriteria(Operator.EQUAL, (Object[])startDate));
    }

    public ContractRequest<T> withStartDate(Operator operator, Object... values){
       return appendSearchCriteria(createStartDateCriteria(operator, values));
    }

    public ContractRequest<T> withStartDateIsUnknown(){
       return withStartDate(Operator.IS_NULL);
    }

    public ContractRequest<T> withStartDateIsKnown(){
       return withStartDate(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createStartDateCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Contract.START_DATE_PROPERTY, operator, values);
    }

    public ContractRequest<T> withStartDateGreaterThan(LocalDateTime startDate){
       return withStartDate(Operator.GREATER_THAN, startDate);
    }

    public ContractRequest<T> withStartDateGreaterThanOrEqualTo(LocalDateTime startDate){
       return withStartDate(Operator.GREATER_THAN_OR_EQUAL, startDate);
    }

    public ContractRequest<T> withStartDateLessThan(LocalDateTime startDate){
       return withStartDate(Operator.LESS_THAN, startDate);
    }

    public ContractRequest<T> withStartDateLessThanOrEqualTo(LocalDateTime startDate){
       return withStartDate(Operator.LESS_THAN_OR_EQUAL, startDate);
    }

    public ContractRequest<T> withStartDateBetween(LocalDateTime startOfStartDate, LocalDateTime endOfStartDate){
       return withStartDate(Operator.BETWEEN, startOfStartDate, endOfStartDate);
    }
    public ContractRequest<T> withStartDateBefore(LocalDateTime startDate){
       return withStartDate(Operator.LESS_THAN, startDate);
    }

    public ContractRequest<T> withStartDateBefore(Date startDate){
       return withStartDate(Operator.LESS_THAN, startDate);
    }

    public ContractRequest<T> withStartDateAfter(LocalDateTime startDate){
       return withStartDate(Operator.GREATER_THAN, startDate);
    }

    public ContractRequest<T> withStartDateAfter(Date startDate){
       return withStartDate(Operator.GREATER_THAN, startDate);
    }

    public ContractRequest<T> withStartDateBetween(Date startOfStartDate, Date endOfStartDate){
       return withStartDate(Operator.BETWEEN, startOfStartDate, endOfStartDate);
    }




    public ContractRequest<T> filterByTerms(String... terms){
      if (terms == null || terms.length == 0) {
        throw new IllegalArgumentException("filterByTerms parameter terms cannot be empty");
      }
      return appendSearchCriteria(createTermsCriteria(Operator.EQUAL, (Object[])terms));
    }

    public ContractRequest<T> withTerms(Operator operator, Object... values){
       return appendSearchCriteria(createTermsCriteria(operator, values));
    }

    public ContractRequest<T> withTermsIsUnknown(){
       return withTerms(Operator.IS_NULL);
    }

    public ContractRequest<T> withTermsIsKnown(){
       return withTerms(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createTermsCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Contract.TERMS_PROPERTY, operator, values);
    }

    public ContractRequest<T> withTermsGreaterThan(String terms){
       return withTerms(Operator.GREATER_THAN, terms);
    }

    public ContractRequest<T> withTermsGreaterThanOrEqualTo(String terms){
       return withTerms(Operator.GREATER_THAN_OR_EQUAL, terms);
    }

    public ContractRequest<T> withTermsLessThan(String terms){
       return withTerms(Operator.LESS_THAN, terms);
    }

    public ContractRequest<T> withTermsLessThanOrEqualTo(String terms){
       return withTerms(Operator.LESS_THAN_OR_EQUAL, terms);
    }

    public ContractRequest<T> withTermsBetween(String startOfTerms, String endOfTerms){
       return withTerms(Operator.BETWEEN, startOfTerms, endOfTerms);
    }
    public ContractRequest<T> withTermsStartingWith(String terms){
       return withTerms(Operator.BEGIN_WITH, terms);
    }
    public ContractRequest<T> withTermsContaining(String terms){
       return withTerms(Operator.CONTAIN, terms);
    }

    public ContractRequest<T> withTermsEndingWith(String terms){
       return withTerms(Operator.END_WITH, terms);
    }

    public ContractRequest<T> withTermsIs(String terms){
       return withTerms(Operator.EQUAL, terms);
    }

    public ContractRequest<T> withTermsSoundingLike(String terms){
       return withTerms(Operator.SOUNDS_LIKE, terms);
    }



    public ContractRequest<T> filterByValue(BigDecimal... value){
      if (value == null || value.length == 0) {
        throw new IllegalArgumentException("filterByValue parameter value cannot be empty");
      }
      return appendSearchCriteria(createValueCriteria(Operator.EQUAL, (Object[])value));
    }

    public ContractRequest<T> withValue(Operator operator, Object... values){
       return appendSearchCriteria(createValueCriteria(operator, values));
    }

    public ContractRequest<T> withValueIsUnknown(){
       return withValue(Operator.IS_NULL);
    }

    public ContractRequest<T> withValueIsKnown(){
       return withValue(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createValueCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Contract.VALUE_PROPERTY, operator, values);
    }

    public ContractRequest<T> withValueGreaterThan(BigDecimal value){
       return withValue(Operator.GREATER_THAN, value);
    }

    public ContractRequest<T> withValueGreaterThanOrEqualTo(BigDecimal value){
       return withValue(Operator.GREATER_THAN_OR_EQUAL, value);
    }

    public ContractRequest<T> withValueLessThan(BigDecimal value){
       return withValue(Operator.LESS_THAN, value);
    }

    public ContractRequest<T> withValueLessThanOrEqualTo(BigDecimal value){
       return withValue(Operator.LESS_THAN_OR_EQUAL, value);
    }

    public ContractRequest<T> withValueBetween(BigDecimal startOfValue, BigDecimal endOfValue){
       return withValue(Operator.BETWEEN, startOfValue, endOfValue);
    }



    public ContractRequest<T> filterByCreateTime(LocalDateTime... createTime){
      if (createTime == null || createTime.length == 0) {
        throw new IllegalArgumentException("filterByCreateTime parameter createTime cannot be empty");
      }
      return appendSearchCriteria(createCreateTimeCriteria(Operator.EQUAL, (Object[])createTime));
    }

    public ContractRequest<T> withCreateTime(Operator operator, Object... values){
       return appendSearchCriteria(createCreateTimeCriteria(operator, values));
    }

    public ContractRequest<T> withCreateTimeIsUnknown(){
       return withCreateTime(Operator.IS_NULL);
    }

    public ContractRequest<T> withCreateTimeIsKnown(){
       return withCreateTime(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createCreateTimeCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Contract.CREATE_TIME_PROPERTY, operator, values);
    }

    public ContractRequest<T> withCreateTimeGreaterThan(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public ContractRequest<T> withCreateTimeGreaterThanOrEqualTo(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN_OR_EQUAL, createTime);
    }

    public ContractRequest<T> withCreateTimeLessThan(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public ContractRequest<T> withCreateTimeLessThanOrEqualTo(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN_OR_EQUAL, createTime);
    }

    public ContractRequest<T> withCreateTimeBetween(LocalDateTime startOfCreateTime, LocalDateTime endOfCreateTime){
       return withCreateTime(Operator.BETWEEN, startOfCreateTime, endOfCreateTime);
    }
    public ContractRequest<T> withCreateTimeBefore(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public ContractRequest<T> withCreateTimeBefore(Date createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public ContractRequest<T> withCreateTimeAfter(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public ContractRequest<T> withCreateTimeAfter(Date createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public ContractRequest<T> withCreateTimeBetween(Date startOfCreateTime, Date endOfCreateTime){
       return withCreateTime(Operator.BETWEEN, startOfCreateTime, endOfCreateTime);
    }




    public ContractRequest<T> filterByUpdateTime(LocalDateTime... updateTime){
      if (updateTime == null || updateTime.length == 0) {
        throw new IllegalArgumentException("filterByUpdateTime parameter updateTime cannot be empty");
      }
      return appendSearchCriteria(createUpdateTimeCriteria(Operator.EQUAL, (Object[])updateTime));
    }

    public ContractRequest<T> withUpdateTime(Operator operator, Object... values){
       return appendSearchCriteria(createUpdateTimeCriteria(operator, values));
    }

    public ContractRequest<T> withUpdateTimeIsUnknown(){
       return withUpdateTime(Operator.IS_NULL);
    }

    public ContractRequest<T> withUpdateTimeIsKnown(){
       return withUpdateTime(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createUpdateTimeCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Contract.UPDATE_TIME_PROPERTY, operator, values);
    }

    public ContractRequest<T> withUpdateTimeGreaterThan(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public ContractRequest<T> withUpdateTimeGreaterThanOrEqualTo(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN_OR_EQUAL, updateTime);
    }

    public ContractRequest<T> withUpdateTimeLessThan(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public ContractRequest<T> withUpdateTimeLessThanOrEqualTo(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN_OR_EQUAL, updateTime);
    }

    public ContractRequest<T> withUpdateTimeBetween(LocalDateTime startOfUpdateTime, LocalDateTime endOfUpdateTime){
       return withUpdateTime(Operator.BETWEEN, startOfUpdateTime, endOfUpdateTime);
    }
    public ContractRequest<T> withUpdateTimeBefore(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public ContractRequest<T> withUpdateTimeBefore(Date updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public ContractRequest<T> withUpdateTimeAfter(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public ContractRequest<T> withUpdateTimeAfter(Date updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public ContractRequest<T> withUpdateTimeBetween(Date startOfUpdateTime, Date endOfUpdateTime){
       return withUpdateTime(Operator.BETWEEN, startOfUpdateTime, endOfUpdateTime);
    }




    public ContractRequest<T> filterByVersion(Long... version){
      if (version == null || version.length == 0) {
        throw new IllegalArgumentException("filterByVersion parameter version cannot be empty");
      }
      return appendSearchCriteria(createVersionCriteria(Operator.EQUAL, (Object[])version));
    }

    public ContractRequest<T> withVersion(Operator operator, Object... values){
       return appendSearchCriteria(createVersionCriteria(operator, values));
    }

    public ContractRequest<T> withVersionIsUnknown(){
       return withVersion(Operator.IS_NULL);
    }

    public ContractRequest<T> withVersionIsKnown(){
       return withVersion(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createVersionCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Contract.VERSION_PROPERTY, operator, values);
    }

    public ContractRequest<T> withVersionGreaterThan(Long version){
       return withVersion(Operator.GREATER_THAN, version);
    }

    public ContractRequest<T> withVersionGreaterThanOrEqualTo(Long version){
       return withVersion(Operator.GREATER_THAN_OR_EQUAL, version);
    }

    public ContractRequest<T> withVersionLessThan(Long version){
       return withVersion(Operator.LESS_THAN, version);
    }

    public ContractRequest<T> withVersionLessThanOrEqualTo(Long version){
       return withVersion(Operator.LESS_THAN_OR_EQUAL, version);
    }

    public ContractRequest<T> withVersionBetween(Long startOfVersion, Long endOfVersion){
       return withVersion(Operator.BETWEEN, startOfVersion, endOfVersion);
    }


    public ContractRequest<T> count(){
        super.count();
        return this;
    }
    public ContractRequest<T> countAs(String retName){
        super.count(retName);
        return this;
    }
    public ContractRequest minValue(){
        return minValueAs(prefix("minOf",Contract.VALUE_PROPERTY));
    }

    public ContractRequest minValueAs(String retName){
        super.min(retName, Contract.VALUE_PROPERTY);
        return this;
    }
    public ContractRequest maxValue(){
        return maxValueAs(prefix("maxOf",Contract.VALUE_PROPERTY));
    }

    public ContractRequest maxValueAs(String retName){
        super.max(retName, Contract.VALUE_PROPERTY);
        return this;
    }
    public ContractRequest sumValue(){
        return sumValueAs(prefix("sumOf",Contract.VALUE_PROPERTY));
    }

    public ContractRequest sumValueAs(String retName){
        super.sum(retName, Contract.VALUE_PROPERTY);
        return this;
    }
    public ContractRequest avgValue(){
        return avgValueAs(prefix("avgOf",Contract.VALUE_PROPERTY));
    }

    public ContractRequest avgValueAs(String retName){
        super.avg(retName, Contract.VALUE_PROPERTY);
        return this;
    }
    public ContractRequest standardDeviationValue(){
        return standardDeviationValueAs(prefix("standardDeviationOf",Contract.VALUE_PROPERTY));
    }

    public ContractRequest standardDeviationValueAs(String retName){
        super.standardDeviation(retName, Contract.VALUE_PROPERTY);
        return this;
    }
    public ContractRequest squareRootOfPopulationStandardDeviationValue(){
        return squareRootOfPopulationStandardDeviationValueAs(prefix("squareRootOfPopulationStandardDeviationOf",Contract.VALUE_PROPERTY));
    }

    public ContractRequest squareRootOfPopulationStandardDeviationValueAs(String retName){
        super.squareRootOfPopulationStandardDeviation(retName, Contract.VALUE_PROPERTY);
        return this;
    }
    public ContractRequest sampleVarianceValue(){
        return sampleVarianceValueAs(prefix("sampleVarianceOf",Contract.VALUE_PROPERTY));
    }

    public ContractRequest sampleVarianceValueAs(String retName){
        super.sampleVariance(retName, Contract.VALUE_PROPERTY);
        return this;
    }
    public ContractRequest samplePopulationVarianceValue(){
        return samplePopulationVarianceValueAs(prefix("samplePopulationVarianceOf",Contract.VALUE_PROPERTY));
    }

    public ContractRequest samplePopulationVarianceValueAs(String retName){
        super.samplePopulationVariance(retName, Contract.VALUE_PROPERTY);
        return this;
    }
    public ContractRequest<T> groupByCustomerWithDetails(){
       return groupByCustomerWithDetails(Q.customers().unlimited());
    }

    public ContractRequest<T> groupByCustomerWithDetails(CustomerRequest subRequest){
       aggregate(Contract.CUSTOMER_PROPERTY, subRequest);
       return this;
    }









    public ContractRequest<T> groupById(){
       groupBy(Contract.ID_PROPERTY);
       return this;
    }

    public ContractRequest<T> groupByIdAs(String retName){
       groupBy(retName, Contract.ID_PROPERTY);
       return this;
    }

    public ContractRequest<T> groupByIdWithFunction(String retName, AggrFunction function){
       groupBy(retName, Contract.ID_PROPERTY, function);
       return this;
    }
    public ContractRequest<T> groupByCustomerWith(CustomerRequest subRequest){
       groupBy(Contract.CUSTOMER_PROPERTY, subRequest);
       return this;
    }
    public ContractRequest<T> groupByCustomer(){
       groupBy(Contract.CUSTOMER_PROPERTY);
       return this;
    }

    public ContractRequest<T> groupByCustomerAs(String retName){
       groupBy(retName, Contract.CUSTOMER_PROPERTY);
       return this;
    }

    public ContractRequest<T> groupByCustomerWithFunction(String retName, AggrFunction function){
       groupBy(retName, Contract.CUSTOMER_PROPERTY, function);
       return this;
    }

    public ContractRequest<T> groupByEndDate(){
       groupBy(Contract.END_DATE_PROPERTY);
       return this;
    }

    public ContractRequest<T> groupByEndDateAs(String retName){
       groupBy(retName, Contract.END_DATE_PROPERTY);
       return this;
    }

    public ContractRequest<T> groupByEndDateWithFunction(String retName, AggrFunction function){
       groupBy(retName, Contract.END_DATE_PROPERTY, function);
       return this;
    }

    public ContractRequest<T> groupByStartDate(){
       groupBy(Contract.START_DATE_PROPERTY);
       return this;
    }

    public ContractRequest<T> groupByStartDateAs(String retName){
       groupBy(retName, Contract.START_DATE_PROPERTY);
       return this;
    }

    public ContractRequest<T> groupByStartDateWithFunction(String retName, AggrFunction function){
       groupBy(retName, Contract.START_DATE_PROPERTY, function);
       return this;
    }

    public ContractRequest<T> groupByTerms(){
       groupBy(Contract.TERMS_PROPERTY);
       return this;
    }

    public ContractRequest<T> groupByTermsAs(String retName){
       groupBy(retName, Contract.TERMS_PROPERTY);
       return this;
    }

    public ContractRequest<T> groupByTermsWithFunction(String retName, AggrFunction function){
       groupBy(retName, Contract.TERMS_PROPERTY, function);
       return this;
    }

    public ContractRequest<T> groupByValue(){
       groupBy(Contract.VALUE_PROPERTY);
       return this;
    }

    public ContractRequest<T> groupByValueAs(String retName){
       groupBy(retName, Contract.VALUE_PROPERTY);
       return this;
    }

    public ContractRequest<T> groupByValueWithFunction(String retName, AggrFunction function){
       groupBy(retName, Contract.VALUE_PROPERTY, function);
       return this;
    }

    public ContractRequest<T> groupByCreateTime(){
       groupBy(Contract.CREATE_TIME_PROPERTY);
       return this;
    }

    public ContractRequest<T> groupByCreateTimeAs(String retName){
       groupBy(retName, Contract.CREATE_TIME_PROPERTY);
       return this;
    }

    public ContractRequest<T> groupByCreateTimeWithFunction(String retName, AggrFunction function){
       groupBy(retName, Contract.CREATE_TIME_PROPERTY, function);
       return this;
    }

    public ContractRequest<T> groupByUpdateTime(){
       groupBy(Contract.UPDATE_TIME_PROPERTY);
       return this;
    }

    public ContractRequest<T> groupByUpdateTimeAs(String retName){
       groupBy(retName, Contract.UPDATE_TIME_PROPERTY);
       return this;
    }

    public ContractRequest<T> groupByUpdateTimeWithFunction(String retName, AggrFunction function){
       groupBy(retName, Contract.UPDATE_TIME_PROPERTY, function);
       return this;
    }

    public ContractRequest<T> groupByVersion(){
       groupBy(Contract.VERSION_PROPERTY);
       return this;
    }

    public ContractRequest<T> groupByVersionAs(String retName){
       groupBy(retName, Contract.VERSION_PROPERTY);
       return this;
    }

    public ContractRequest<T> groupByVersionWithFunction(String retName, AggrFunction function){
       groupBy(retName, Contract.VERSION_PROPERTY, function);
       return this;
    }



    public ContractRequest<T> orderByIdAscending(){
       addOrderByAscending(Contract.ID_PROPERTY);
       return this;
    }

    public ContractRequest<T> orderByIdDescending(){
       addOrderByDescending(Contract.ID_PROPERTY);
       return this;
    }

    public ContractRequest<T> orderByCustomerAscending(){
       addOrderByAscending(Contract.CUSTOMER_PROPERTY);
       return this;
    }

    public ContractRequest<T> orderByCustomerDescending(){
       addOrderByDescending(Contract.CUSTOMER_PROPERTY);
       return this;
    }

    public ContractRequest<T> orderByEndDateAscending(){
       addOrderByAscending(Contract.END_DATE_PROPERTY);
       return this;
    }

    public ContractRequest<T> orderByEndDateDescending(){
       addOrderByDescending(Contract.END_DATE_PROPERTY);
       return this;
    }

    public ContractRequest<T> orderByStartDateAscending(){
       addOrderByAscending(Contract.START_DATE_PROPERTY);
       return this;
    }

    public ContractRequest<T> orderByStartDateDescending(){
       addOrderByDescending(Contract.START_DATE_PROPERTY);
       return this;
    }

    public ContractRequest<T> orderByTermsAscending(){
       addOrderByAscending(Contract.TERMS_PROPERTY);
       return this;
    }

    public ContractRequest<T> orderByTermsDescending(){
       addOrderByDescending(Contract.TERMS_PROPERTY);
       return this;
    }
    public ContractRequest<T> orderByTermsAscendingUsingGBK(){
       addOrderByAscendingUsingGBK(Contract.TERMS_PROPERTY);
       return this;
    }

    public ContractRequest<T> orderByTermsDescendingUsingGBK(){
       addOrderByDescendingUsingGBK(Contract.TERMS_PROPERTY);
       return this;
    }
    public ContractRequest<T> orderByValueAscending(){
       addOrderByAscending(Contract.VALUE_PROPERTY);
       return this;
    }

    public ContractRequest<T> orderByValueDescending(){
       addOrderByDescending(Contract.VALUE_PROPERTY);
       return this;
    }

    public ContractRequest<T> orderByCreateTimeAscending(){
       addOrderByAscending(Contract.CREATE_TIME_PROPERTY);
       return this;
    }

    public ContractRequest<T> orderByCreateTimeDescending(){
       addOrderByDescending(Contract.CREATE_TIME_PROPERTY);
       return this;
    }

    public ContractRequest<T> orderByUpdateTimeAscending(){
       addOrderByAscending(Contract.UPDATE_TIME_PROPERTY);
       return this;
    }

    public ContractRequest<T> orderByUpdateTimeDescending(){
       addOrderByDescending(Contract.UPDATE_TIME_PROPERTY);
       return this;
    }

    public ContractRequest<T> orderByVersionAscending(){
       addOrderByAscending(Contract.VERSION_PROPERTY);
       return this;
    }

    public ContractRequest<T> orderByVersionDescending(){
       addOrderByDescending(Contract.VERSION_PROPERTY);
       return this;
    }


    public CustomerRequest rollUpToCustomer(){
       CustomerRequest customer = Q.customers().unlimited();
       this.withCustomerMatching(customer)
           .groupByCustomerWith(customer);
       return customer;
    }









   public ContractRequest<T> facetByCustomerAs(String facetName, CustomerRequest customer){
       return facetByCustomerAs(facetName, customer, true);
   }

   public ContractRequest<T> facetByCustomerAs(String facetName, CustomerRequest customer, boolean includeAllFacets){
       addFacet(facetName, Contract.CUSTOMER_PROPERTY, customer, includeAllFacets);
       return this;
   }


    /**
     * get topN records
     * @param topN  records number
     */
    public ContractRequest<T> top(int topN) {
        super.top(topN);
        return this;
    }

    /**
     * get records from offset(inclusive) to offset+size(exclusive)
     * @param offset record offset
     * @param size records number
     */
    public ContractRequest<T> offset(int offset, int size) {
        super.offset(offset, size);
        return this;
    }

    /**
     * retrieve all records
     */
    public ContractRequest<T> unlimited() {
        super.unlimited();
        return this;
    }

    /**
     * get records of one page
     * @param pageNumber page number(1-based)
     * @param pageSize page size
     */
    public ContractRequest<T> page(int pageNumber, int pageSize) {
        int offset = (pageNumber - 1) * pageSize;
        return offset(offset, pageSize);
   }

    /**
     * get records of one page, default page size is 10
     * @param pageNumber page number(1-based)
     */
    public ContractRequest<T> page(int pageNumber) {
        return page(pageNumber, 10);
   }
}