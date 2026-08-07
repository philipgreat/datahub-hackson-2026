
package com.example.enterpriseerpsystem.lead;

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
import java.time.LocalDateTime;
import java.util.Date;

public class LeadRequest<T extends Lead> extends BaseRequest<T> {

    /**
     * @deprecated AI agents and business code must use the generated Q facade
     *             instead of constructing request builders directly.
     */
    @Deprecated
    public LeadRequest(Class<T> returnType){
        super(returnType);
        selectId();
        selectVersion();
    }

    public LeadRequest<T> comment(String comment){
         super.internalComment(comment);
         return this;
    }

    // purpose() 继承自 BaseRequest，返回 ExecutableRequest（终结方法）

    public LeadRequest<T> returnType(Class<? extends T> returnType){
        super.setReturnType(returnType);
        return this;
    }

    public LeadRequest<T> enableAggregationCache(long cacheExpiredMillis){
        super.enableAggregationCache();
        super.aggregateCacheTime(cacheExpiredMillis);
        return this;
    }

    public LeadRequest<T> enableAggregationCache(){
        return enableAggregationCache(0l);
    }


    public LeadRequest<T> propagateAggregationCache(long cacheExpiredMillis){
        super.propagateAggregationCache(cacheExpiredMillis);
        return this;
    }

    public LeadRequest<T> appendSearchCriteria(SearchCriteria searchCriteria){
        return (LeadRequest<T>)super.appendSearchCriteria(searchCriteria);
    }

    public LeadRequest<T> filter(String property1, Operator operator, String property2){
        return appendSearchCriteria(new TwoOperatorCriteria(operator, new PropertyReference(property1), new PropertyReference(property2)));
    }


    public LeadRequest<T> matchingAnyOf(LeadRequest lead){
        super.internalMatchAny(lead);
        return this;
    }

    public LeadRequest<T> enhanceChildrenIfNeeded(){
        return this;
    }

    public LeadRequest<T> withDeletedRows(){
        super.withDeletedRows();
        return this;
    }

    public LeadRequest<T> deletedRowsOnly(){
        super.deletedRowsOnly();
        return this;
    }

    public LeadRequest<T> selectSelf(){
        super.selectSelf();
        return selectId().selectEmail().selectName().selectPhone().selectConvertedCustomerId().selectSource().selectStatus().selectCreateTime().selectUpdateTime().selectVersion();
    }

    public LeadRequest<T> selectSelfFields(){
        return selectSelf();
    }

    public LeadRequest<T> selectAll(){
        super.selectAll();
        return selectId().selectEmail().selectName().selectPhone().selectConvertedCustomerId().selectSource().selectStatus().selectCreateTime().selectUpdateTime().selectVersion();
    }

    public LeadRequest<T> selectChildren(){
        super.selectAny();
        selectOpportunityList();
        return selectId().selectEmail().selectName().selectPhone().selectConvertedCustomerId().selectSource().selectStatus().selectCreateTime().selectUpdateTime().selectVersion();
    }


    public LeadRequest<T> selectId(){
       selectProperty(Lead.ID_PROPERTY);
       return this;
    }

    /**
     * fill the id with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  id) to fetch id property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public LeadRequest<T> unselectId(){
       unselectProperty(Lead.ID_PROPERTY);
       return this;
    }
    public LeadRequest<T> selectEmail(){
       selectProperty(Lead.EMAIL_PROPERTY);
       return this;
    }

    /**
     * fill the email with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  email) to fetch email property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public LeadRequest<T> unselectEmail(){
       unselectProperty(Lead.EMAIL_PROPERTY);
       return this;
    }
    public LeadRequest<T> selectName(){
       selectProperty(Lead.NAME_PROPERTY);
       return this;
    }

    /**
     * fill the name with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  name) to fetch name property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public LeadRequest<T> unselectName(){
       unselectProperty(Lead.NAME_PROPERTY);
       return this;
    }
    public LeadRequest<T> selectPhone(){
       selectProperty(Lead.PHONE_PROPERTY);
       return this;
    }

    /**
     * fill the phone with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  phone) to fetch phone property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public LeadRequest<T> unselectPhone(){
       unselectProperty(Lead.PHONE_PROPERTY);
       return this;
    }
    public LeadRequest<T> selectConvertedCustomerId(){
       selectProperty(Lead.CONVERTED_CUSTOMER_ID_PROPERTY);
       return this;
    }

    /**
     * fill the convertedCustomerId with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  convertedCustomerId) to fetch convertedCustomerId property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public LeadRequest<T> unselectConvertedCustomerId(){
       unselectProperty(Lead.CONVERTED_CUSTOMER_ID_PROPERTY);
       return this;
    }
    public LeadRequest<T> selectSource(){
       selectProperty(Lead.SOURCE_PROPERTY);
       return this;
    }

    /**
     * fill the source with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  source) to fetch source property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public LeadRequest<T> unselectSource(){
       unselectProperty(Lead.SOURCE_PROPERTY);
       return this;
    }
    public LeadRequest<T> selectStatus(){
       selectProperty(Lead.STATUS_PROPERTY);
       return this;
    }

    /**
     * fill the status with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  status) to fetch status property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public LeadRequest<T> unselectStatus(){
       unselectProperty(Lead.STATUS_PROPERTY);
       return this;
    }
    public LeadRequest<T> selectCreateTime(){
       selectProperty(Lead.CREATE_TIME_PROPERTY);
       return this;
    }

    /**
     * fill the createTime with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  createTime) to fetch createTime property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public LeadRequest<T> unselectCreateTime(){
       unselectProperty(Lead.CREATE_TIME_PROPERTY);
       return this;
    }
    public LeadRequest<T> selectUpdateTime(){
       selectProperty(Lead.UPDATE_TIME_PROPERTY);
       return this;
    }

    /**
     * fill the updateTime with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  updateTime) to fetch updateTime property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public LeadRequest<T> unselectUpdateTime(){
       unselectProperty(Lead.UPDATE_TIME_PROPERTY);
       return this;
    }
    public LeadRequest<T> selectVersion(){
       selectProperty(Lead.VERSION_PROPERTY);
       return this;
    }

    /**
     * fill the version with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  version) to fetch version property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public LeadRequest<T> unselectVersion(){
       unselectProperty(Lead.VERSION_PROPERTY);
       return this;
    }
    public LeadRequest<T> selectOpportunityList(){
       return selectOpportunityListWith(Q.opportunities().selectSelf());
    }

    public LeadRequest<T> selectOpportunityListWith(OpportunityRequest opportunityList){
       enhanceRelation(Lead.OPPORTUNITY_LIST_PROPERTY, opportunityList);
       return this;
    }

    public LeadRequest<T> withId(Operator operator, Object... values){
       return appendSearchCriteria(createIdCriteria(operator, values));
    }

    public SearchCriteria createIdCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Lead.ID_PROPERTY, operator, values);
    }

    public LeadRequest<T> withIdIs(Long id){
       return withId(Operator.EQUAL, id);
    }
    public LeadRequest<T> withIdIn(Long... id){
       return withId(Operator.EQUAL, (Object[])id);
    }



    public LeadRequest<T> filterByEmail(String... email){
      if (email == null || email.length == 0) {
        throw new IllegalArgumentException("filterByEmail parameter email cannot be empty");
      }
      return appendSearchCriteria(createEmailCriteria(Operator.EQUAL, (Object[])email));
    }

    public LeadRequest<T> withEmail(Operator operator, Object... values){
       return appendSearchCriteria(createEmailCriteria(operator, values));
    }

    public LeadRequest<T> withEmailIsUnknown(){
       return withEmail(Operator.IS_NULL);
    }

    public LeadRequest<T> withEmailIsKnown(){
       return withEmail(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createEmailCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Lead.EMAIL_PROPERTY, operator, values);
    }

    public LeadRequest<T> withEmailGreaterThan(String email){
       return withEmail(Operator.GREATER_THAN, email);
    }

    public LeadRequest<T> withEmailGreaterThanOrEqualTo(String email){
       return withEmail(Operator.GREATER_THAN_OR_EQUAL, email);
    }

    public LeadRequest<T> withEmailLessThan(String email){
       return withEmail(Operator.LESS_THAN, email);
    }

    public LeadRequest<T> withEmailLessThanOrEqualTo(String email){
       return withEmail(Operator.LESS_THAN_OR_EQUAL, email);
    }

    public LeadRequest<T> withEmailBetween(String startOfEmail, String endOfEmail){
       return withEmail(Operator.BETWEEN, startOfEmail, endOfEmail);
    }
    public LeadRequest<T> withEmailStartingWith(String email){
       return withEmail(Operator.BEGIN_WITH, email);
    }
    public LeadRequest<T> withEmailContaining(String email){
       return withEmail(Operator.CONTAIN, email);
    }

    public LeadRequest<T> withEmailEndingWith(String email){
       return withEmail(Operator.END_WITH, email);
    }

    public LeadRequest<T> withEmailIs(String email){
       return withEmail(Operator.EQUAL, email);
    }

    public LeadRequest<T> withEmailSoundingLike(String email){
       return withEmail(Operator.SOUNDS_LIKE, email);
    }



    public LeadRequest<T> filterByName(String... name){
      if (name == null || name.length == 0) {
        throw new IllegalArgumentException("filterByName parameter name cannot be empty");
      }
      return appendSearchCriteria(createNameCriteria(Operator.EQUAL, (Object[])name));
    }

    public LeadRequest<T> withName(Operator operator, Object... values){
       return appendSearchCriteria(createNameCriteria(operator, values));
    }

    public LeadRequest<T> withNameIsUnknown(){
       return withName(Operator.IS_NULL);
    }

    public LeadRequest<T> withNameIsKnown(){
       return withName(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createNameCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Lead.NAME_PROPERTY, operator, values);
    }

    public LeadRequest<T> withNameGreaterThan(String name){
       return withName(Operator.GREATER_THAN, name);
    }

    public LeadRequest<T> withNameGreaterThanOrEqualTo(String name){
       return withName(Operator.GREATER_THAN_OR_EQUAL, name);
    }

    public LeadRequest<T> withNameLessThan(String name){
       return withName(Operator.LESS_THAN, name);
    }

    public LeadRequest<T> withNameLessThanOrEqualTo(String name){
       return withName(Operator.LESS_THAN_OR_EQUAL, name);
    }

    public LeadRequest<T> withNameBetween(String startOfName, String endOfName){
       return withName(Operator.BETWEEN, startOfName, endOfName);
    }
    public LeadRequest<T> withNameStartingWith(String name){
       return withName(Operator.BEGIN_WITH, name);
    }
    public LeadRequest<T> withNameContaining(String name){
       return withName(Operator.CONTAIN, name);
    }

    public LeadRequest<T> withNameEndingWith(String name){
       return withName(Operator.END_WITH, name);
    }

    public LeadRequest<T> withNameIs(String name){
       return withName(Operator.EQUAL, name);
    }

    public LeadRequest<T> withNameSoundingLike(String name){
       return withName(Operator.SOUNDS_LIKE, name);
    }



    public LeadRequest<T> filterByPhone(String... phone){
      if (phone == null || phone.length == 0) {
        throw new IllegalArgumentException("filterByPhone parameter phone cannot be empty");
      }
      return appendSearchCriteria(createPhoneCriteria(Operator.EQUAL, (Object[])phone));
    }

    public LeadRequest<T> withPhone(Operator operator, Object... values){
       return appendSearchCriteria(createPhoneCriteria(operator, values));
    }

    public LeadRequest<T> withPhoneIsUnknown(){
       return withPhone(Operator.IS_NULL);
    }

    public LeadRequest<T> withPhoneIsKnown(){
       return withPhone(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createPhoneCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Lead.PHONE_PROPERTY, operator, values);
    }

    public LeadRequest<T> withPhoneGreaterThan(String phone){
       return withPhone(Operator.GREATER_THAN, phone);
    }

    public LeadRequest<T> withPhoneGreaterThanOrEqualTo(String phone){
       return withPhone(Operator.GREATER_THAN_OR_EQUAL, phone);
    }

    public LeadRequest<T> withPhoneLessThan(String phone){
       return withPhone(Operator.LESS_THAN, phone);
    }

    public LeadRequest<T> withPhoneLessThanOrEqualTo(String phone){
       return withPhone(Operator.LESS_THAN_OR_EQUAL, phone);
    }

    public LeadRequest<T> withPhoneBetween(String startOfPhone, String endOfPhone){
       return withPhone(Operator.BETWEEN, startOfPhone, endOfPhone);
    }
    public LeadRequest<T> withPhoneStartingWith(String phone){
       return withPhone(Operator.BEGIN_WITH, phone);
    }
    public LeadRequest<T> withPhoneContaining(String phone){
       return withPhone(Operator.CONTAIN, phone);
    }

    public LeadRequest<T> withPhoneEndingWith(String phone){
       return withPhone(Operator.END_WITH, phone);
    }

    public LeadRequest<T> withPhoneIs(String phone){
       return withPhone(Operator.EQUAL, phone);
    }

    public LeadRequest<T> withPhoneSoundingLike(String phone){
       return withPhone(Operator.SOUNDS_LIKE, phone);
    }



    public LeadRequest<T> filterByConvertedCustomerId(String... convertedCustomerId){
      if (convertedCustomerId == null || convertedCustomerId.length == 0) {
        throw new IllegalArgumentException("filterByConvertedCustomerId parameter convertedCustomerId cannot be empty");
      }
      return appendSearchCriteria(createConvertedCustomerIdCriteria(Operator.EQUAL, (Object[])convertedCustomerId));
    }

    public LeadRequest<T> withConvertedCustomerId(Operator operator, Object... values){
       return appendSearchCriteria(createConvertedCustomerIdCriteria(operator, values));
    }

    public LeadRequest<T> withConvertedCustomerIdIsUnknown(){
       return withConvertedCustomerId(Operator.IS_NULL);
    }

    public LeadRequest<T> withConvertedCustomerIdIsKnown(){
       return withConvertedCustomerId(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createConvertedCustomerIdCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Lead.CONVERTED_CUSTOMER_ID_PROPERTY, operator, values);
    }

    public LeadRequest<T> withConvertedCustomerIdGreaterThan(String convertedCustomerId){
       return withConvertedCustomerId(Operator.GREATER_THAN, convertedCustomerId);
    }

    public LeadRequest<T> withConvertedCustomerIdGreaterThanOrEqualTo(String convertedCustomerId){
       return withConvertedCustomerId(Operator.GREATER_THAN_OR_EQUAL, convertedCustomerId);
    }

    public LeadRequest<T> withConvertedCustomerIdLessThan(String convertedCustomerId){
       return withConvertedCustomerId(Operator.LESS_THAN, convertedCustomerId);
    }

    public LeadRequest<T> withConvertedCustomerIdLessThanOrEqualTo(String convertedCustomerId){
       return withConvertedCustomerId(Operator.LESS_THAN_OR_EQUAL, convertedCustomerId);
    }

    public LeadRequest<T> withConvertedCustomerIdBetween(String startOfConvertedCustomerId, String endOfConvertedCustomerId){
       return withConvertedCustomerId(Operator.BETWEEN, startOfConvertedCustomerId, endOfConvertedCustomerId);
    }
    public LeadRequest<T> withConvertedCustomerIdStartingWith(String convertedCustomerId){
       return withConvertedCustomerId(Operator.BEGIN_WITH, convertedCustomerId);
    }
    public LeadRequest<T> withConvertedCustomerIdContaining(String convertedCustomerId){
       return withConvertedCustomerId(Operator.CONTAIN, convertedCustomerId);
    }

    public LeadRequest<T> withConvertedCustomerIdEndingWith(String convertedCustomerId){
       return withConvertedCustomerId(Operator.END_WITH, convertedCustomerId);
    }

    public LeadRequest<T> withConvertedCustomerIdIs(String convertedCustomerId){
       return withConvertedCustomerId(Operator.EQUAL, convertedCustomerId);
    }

    public LeadRequest<T> withConvertedCustomerIdSoundingLike(String convertedCustomerId){
       return withConvertedCustomerId(Operator.SOUNDS_LIKE, convertedCustomerId);
    }



    public LeadRequest<T> filterBySource(String... source){
      if (source == null || source.length == 0) {
        throw new IllegalArgumentException("filterBySource parameter source cannot be empty");
      }
      return appendSearchCriteria(createSourceCriteria(Operator.EQUAL, (Object[])source));
    }

    public LeadRequest<T> withSource(Operator operator, Object... values){
       return appendSearchCriteria(createSourceCriteria(operator, values));
    }

    public LeadRequest<T> withSourceIsUnknown(){
       return withSource(Operator.IS_NULL);
    }

    public LeadRequest<T> withSourceIsKnown(){
       return withSource(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createSourceCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Lead.SOURCE_PROPERTY, operator, values);
    }

    public LeadRequest<T> withSourceGreaterThan(String source){
       return withSource(Operator.GREATER_THAN, source);
    }

    public LeadRequest<T> withSourceGreaterThanOrEqualTo(String source){
       return withSource(Operator.GREATER_THAN_OR_EQUAL, source);
    }

    public LeadRequest<T> withSourceLessThan(String source){
       return withSource(Operator.LESS_THAN, source);
    }

    public LeadRequest<T> withSourceLessThanOrEqualTo(String source){
       return withSource(Operator.LESS_THAN_OR_EQUAL, source);
    }

    public LeadRequest<T> withSourceBetween(String startOfSource, String endOfSource){
       return withSource(Operator.BETWEEN, startOfSource, endOfSource);
    }
    public LeadRequest<T> withSourceStartingWith(String source){
       return withSource(Operator.BEGIN_WITH, source);
    }
    public LeadRequest<T> withSourceContaining(String source){
       return withSource(Operator.CONTAIN, source);
    }

    public LeadRequest<T> withSourceEndingWith(String source){
       return withSource(Operator.END_WITH, source);
    }

    public LeadRequest<T> withSourceIs(String source){
       return withSource(Operator.EQUAL, source);
    }

    public LeadRequest<T> withSourceSoundingLike(String source){
       return withSource(Operator.SOUNDS_LIKE, source);
    }



    public LeadRequest<T> filterByStatus(String... status){
      if (status == null || status.length == 0) {
        throw new IllegalArgumentException("filterByStatus parameter status cannot be empty");
      }
      return appendSearchCriteria(createStatusCriteria(Operator.EQUAL, (Object[])status));
    }

    public LeadRequest<T> withStatus(Operator operator, Object... values){
       return appendSearchCriteria(createStatusCriteria(operator, values));
    }

    public LeadRequest<T> withStatusIsUnknown(){
       return withStatus(Operator.IS_NULL);
    }

    public LeadRequest<T> withStatusIsKnown(){
       return withStatus(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createStatusCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Lead.STATUS_PROPERTY, operator, values);
    }

    public LeadRequest<T> withStatusGreaterThan(String status){
       return withStatus(Operator.GREATER_THAN, status);
    }

    public LeadRequest<T> withStatusGreaterThanOrEqualTo(String status){
       return withStatus(Operator.GREATER_THAN_OR_EQUAL, status);
    }

    public LeadRequest<T> withStatusLessThan(String status){
       return withStatus(Operator.LESS_THAN, status);
    }

    public LeadRequest<T> withStatusLessThanOrEqualTo(String status){
       return withStatus(Operator.LESS_THAN_OR_EQUAL, status);
    }

    public LeadRequest<T> withStatusBetween(String startOfStatus, String endOfStatus){
       return withStatus(Operator.BETWEEN, startOfStatus, endOfStatus);
    }
    public LeadRequest<T> withStatusStartingWith(String status){
       return withStatus(Operator.BEGIN_WITH, status);
    }
    public LeadRequest<T> withStatusContaining(String status){
       return withStatus(Operator.CONTAIN, status);
    }

    public LeadRequest<T> withStatusEndingWith(String status){
       return withStatus(Operator.END_WITH, status);
    }

    public LeadRequest<T> withStatusIs(String status){
       return withStatus(Operator.EQUAL, status);
    }

    public LeadRequest<T> withStatusSoundingLike(String status){
       return withStatus(Operator.SOUNDS_LIKE, status);
    }



    public LeadRequest<T> filterByCreateTime(LocalDateTime... createTime){
      if (createTime == null || createTime.length == 0) {
        throw new IllegalArgumentException("filterByCreateTime parameter createTime cannot be empty");
      }
      return appendSearchCriteria(createCreateTimeCriteria(Operator.EQUAL, (Object[])createTime));
    }

    public LeadRequest<T> withCreateTime(Operator operator, Object... values){
       return appendSearchCriteria(createCreateTimeCriteria(operator, values));
    }

    public LeadRequest<T> withCreateTimeIsUnknown(){
       return withCreateTime(Operator.IS_NULL);
    }

    public LeadRequest<T> withCreateTimeIsKnown(){
       return withCreateTime(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createCreateTimeCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Lead.CREATE_TIME_PROPERTY, operator, values);
    }

    public LeadRequest<T> withCreateTimeGreaterThan(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public LeadRequest<T> withCreateTimeGreaterThanOrEqualTo(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN_OR_EQUAL, createTime);
    }

    public LeadRequest<T> withCreateTimeLessThan(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public LeadRequest<T> withCreateTimeLessThanOrEqualTo(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN_OR_EQUAL, createTime);
    }

    public LeadRequest<T> withCreateTimeBetween(LocalDateTime startOfCreateTime, LocalDateTime endOfCreateTime){
       return withCreateTime(Operator.BETWEEN, startOfCreateTime, endOfCreateTime);
    }
    public LeadRequest<T> withCreateTimeBefore(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public LeadRequest<T> withCreateTimeBefore(Date createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public LeadRequest<T> withCreateTimeAfter(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public LeadRequest<T> withCreateTimeAfter(Date createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public LeadRequest<T> withCreateTimeBetween(Date startOfCreateTime, Date endOfCreateTime){
       return withCreateTime(Operator.BETWEEN, startOfCreateTime, endOfCreateTime);
    }




    public LeadRequest<T> filterByUpdateTime(LocalDateTime... updateTime){
      if (updateTime == null || updateTime.length == 0) {
        throw new IllegalArgumentException("filterByUpdateTime parameter updateTime cannot be empty");
      }
      return appendSearchCriteria(createUpdateTimeCriteria(Operator.EQUAL, (Object[])updateTime));
    }

    public LeadRequest<T> withUpdateTime(Operator operator, Object... values){
       return appendSearchCriteria(createUpdateTimeCriteria(operator, values));
    }

    public LeadRequest<T> withUpdateTimeIsUnknown(){
       return withUpdateTime(Operator.IS_NULL);
    }

    public LeadRequest<T> withUpdateTimeIsKnown(){
       return withUpdateTime(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createUpdateTimeCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Lead.UPDATE_TIME_PROPERTY, operator, values);
    }

    public LeadRequest<T> withUpdateTimeGreaterThan(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public LeadRequest<T> withUpdateTimeGreaterThanOrEqualTo(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN_OR_EQUAL, updateTime);
    }

    public LeadRequest<T> withUpdateTimeLessThan(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public LeadRequest<T> withUpdateTimeLessThanOrEqualTo(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN_OR_EQUAL, updateTime);
    }

    public LeadRequest<T> withUpdateTimeBetween(LocalDateTime startOfUpdateTime, LocalDateTime endOfUpdateTime){
       return withUpdateTime(Operator.BETWEEN, startOfUpdateTime, endOfUpdateTime);
    }
    public LeadRequest<T> withUpdateTimeBefore(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public LeadRequest<T> withUpdateTimeBefore(Date updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public LeadRequest<T> withUpdateTimeAfter(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public LeadRequest<T> withUpdateTimeAfter(Date updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public LeadRequest<T> withUpdateTimeBetween(Date startOfUpdateTime, Date endOfUpdateTime){
       return withUpdateTime(Operator.BETWEEN, startOfUpdateTime, endOfUpdateTime);
    }




    public LeadRequest<T> filterByVersion(Long... version){
      if (version == null || version.length == 0) {
        throw new IllegalArgumentException("filterByVersion parameter version cannot be empty");
      }
      return appendSearchCriteria(createVersionCriteria(Operator.EQUAL, (Object[])version));
    }

    public LeadRequest<T> withVersion(Operator operator, Object... values){
       return appendSearchCriteria(createVersionCriteria(operator, values));
    }

    public LeadRequest<T> withVersionIsUnknown(){
       return withVersion(Operator.IS_NULL);
    }

    public LeadRequest<T> withVersionIsKnown(){
       return withVersion(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createVersionCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Lead.VERSION_PROPERTY, operator, values);
    }

    public LeadRequest<T> withVersionGreaterThan(Long version){
       return withVersion(Operator.GREATER_THAN, version);
    }

    public LeadRequest<T> withVersionGreaterThanOrEqualTo(Long version){
       return withVersion(Operator.GREATER_THAN_OR_EQUAL, version);
    }

    public LeadRequest<T> withVersionLessThan(Long version){
       return withVersion(Operator.LESS_THAN, version);
    }

    public LeadRequest<T> withVersionLessThanOrEqualTo(Long version){
       return withVersion(Operator.LESS_THAN_OR_EQUAL, version);
    }

    public LeadRequest<T> withVersionBetween(Long startOfVersion, Long endOfVersion){
       return withVersion(Operator.BETWEEN, startOfVersion, endOfVersion);
    }

    public LeadRequest<T> withOpportunityListMatching(OpportunityRequest opportunityRequest){
        return appendSearchCriteria(new SubQuerySearchCriteria(Lead.ID_PROPERTY, opportunityRequest, Opportunity.LEAD_PROPERTY));
    }

    public LeadRequest<T> withoutOpportunityListMatching(OpportunityRequest opportunityRequest){
        return appendSearchCriteria(SearchCriteria.not(new SubQuerySearchCriteria(Lead.ID_PROPERTY, opportunityRequest, Opportunity.LEAD_PROPERTY)));
    }

    public LeadRequest<T> haveOpportunities(){
        return withOpportunityListMatching(Q.opportunities().unlimited());
    }

    public LeadRequest<T> haveNoOpportunities(){
        return withoutOpportunityListMatching(Q.opportunities().unlimited());
    }

    public LeadRequest<T> count(){
        super.count();
        return this;
    }
    public LeadRequest<T> countAs(String retName){
        super.count(retName);
        return this;
    }
    public LeadRequest<T> groupByOpportunitiesWithDetails(OpportunityRequest subRequest){
       aggregate(Lead.OPPORTUNITY_LIST_PROPERTY, subRequest);
       return this;
    }

    public LeadRequest<T> groupById(){
       groupBy(Lead.ID_PROPERTY);
       return this;
    }

    public LeadRequest<T> groupByIdAs(String retName){
       groupBy(retName, Lead.ID_PROPERTY);
       return this;
    }

    public LeadRequest<T> groupByIdWithFunction(String retName, AggrFunction function){
       groupBy(retName, Lead.ID_PROPERTY, function);
       return this;
    }

    public LeadRequest<T> groupByEmail(){
       groupBy(Lead.EMAIL_PROPERTY);
       return this;
    }

    public LeadRequest<T> groupByEmailAs(String retName){
       groupBy(retName, Lead.EMAIL_PROPERTY);
       return this;
    }

    public LeadRequest<T> groupByEmailWithFunction(String retName, AggrFunction function){
       groupBy(retName, Lead.EMAIL_PROPERTY, function);
       return this;
    }

    public LeadRequest<T> groupByName(){
       groupBy(Lead.NAME_PROPERTY);
       return this;
    }

    public LeadRequest<T> groupByNameAs(String retName){
       groupBy(retName, Lead.NAME_PROPERTY);
       return this;
    }

    public LeadRequest<T> groupByNameWithFunction(String retName, AggrFunction function){
       groupBy(retName, Lead.NAME_PROPERTY, function);
       return this;
    }

    public LeadRequest<T> groupByPhone(){
       groupBy(Lead.PHONE_PROPERTY);
       return this;
    }

    public LeadRequest<T> groupByPhoneAs(String retName){
       groupBy(retName, Lead.PHONE_PROPERTY);
       return this;
    }

    public LeadRequest<T> groupByPhoneWithFunction(String retName, AggrFunction function){
       groupBy(retName, Lead.PHONE_PROPERTY, function);
       return this;
    }

    public LeadRequest<T> groupByConvertedCustomerId(){
       groupBy(Lead.CONVERTED_CUSTOMER_ID_PROPERTY);
       return this;
    }

    public LeadRequest<T> groupByConvertedCustomerIdAs(String retName){
       groupBy(retName, Lead.CONVERTED_CUSTOMER_ID_PROPERTY);
       return this;
    }

    public LeadRequest<T> groupByConvertedCustomerIdWithFunction(String retName, AggrFunction function){
       groupBy(retName, Lead.CONVERTED_CUSTOMER_ID_PROPERTY, function);
       return this;
    }

    public LeadRequest<T> groupBySource(){
       groupBy(Lead.SOURCE_PROPERTY);
       return this;
    }

    public LeadRequest<T> groupBySourceAs(String retName){
       groupBy(retName, Lead.SOURCE_PROPERTY);
       return this;
    }

    public LeadRequest<T> groupBySourceWithFunction(String retName, AggrFunction function){
       groupBy(retName, Lead.SOURCE_PROPERTY, function);
       return this;
    }

    public LeadRequest<T> groupByStatus(){
       groupBy(Lead.STATUS_PROPERTY);
       return this;
    }

    public LeadRequest<T> groupByStatusAs(String retName){
       groupBy(retName, Lead.STATUS_PROPERTY);
       return this;
    }

    public LeadRequest<T> groupByStatusWithFunction(String retName, AggrFunction function){
       groupBy(retName, Lead.STATUS_PROPERTY, function);
       return this;
    }

    public LeadRequest<T> groupByCreateTime(){
       groupBy(Lead.CREATE_TIME_PROPERTY);
       return this;
    }

    public LeadRequest<T> groupByCreateTimeAs(String retName){
       groupBy(retName, Lead.CREATE_TIME_PROPERTY);
       return this;
    }

    public LeadRequest<T> groupByCreateTimeWithFunction(String retName, AggrFunction function){
       groupBy(retName, Lead.CREATE_TIME_PROPERTY, function);
       return this;
    }

    public LeadRequest<T> groupByUpdateTime(){
       groupBy(Lead.UPDATE_TIME_PROPERTY);
       return this;
    }

    public LeadRequest<T> groupByUpdateTimeAs(String retName){
       groupBy(retName, Lead.UPDATE_TIME_PROPERTY);
       return this;
    }

    public LeadRequest<T> groupByUpdateTimeWithFunction(String retName, AggrFunction function){
       groupBy(retName, Lead.UPDATE_TIME_PROPERTY, function);
       return this;
    }

    public LeadRequest<T> groupByVersion(){
       groupBy(Lead.VERSION_PROPERTY);
       return this;
    }

    public LeadRequest<T> groupByVersionAs(String retName){
       groupBy(retName, Lead.VERSION_PROPERTY);
       return this;
    }

    public LeadRequest<T> groupByVersionWithFunction(String retName, AggrFunction function){
       groupBy(retName, Lead.VERSION_PROPERTY, function);
       return this;
    }



    public LeadRequest<T> orderByIdAscending(){
       addOrderByAscending(Lead.ID_PROPERTY);
       return this;
    }

    public LeadRequest<T> orderByIdDescending(){
       addOrderByDescending(Lead.ID_PROPERTY);
       return this;
    }

    public LeadRequest<T> orderByEmailAscending(){
       addOrderByAscending(Lead.EMAIL_PROPERTY);
       return this;
    }

    public LeadRequest<T> orderByEmailDescending(){
       addOrderByDescending(Lead.EMAIL_PROPERTY);
       return this;
    }
    public LeadRequest<T> orderByEmailAscendingUsingGBK(){
       addOrderByAscendingUsingGBK(Lead.EMAIL_PROPERTY);
       return this;
    }

    public LeadRequest<T> orderByEmailDescendingUsingGBK(){
       addOrderByDescendingUsingGBK(Lead.EMAIL_PROPERTY);
       return this;
    }
    public LeadRequest<T> orderByNameAscending(){
       addOrderByAscending(Lead.NAME_PROPERTY);
       return this;
    }

    public LeadRequest<T> orderByNameDescending(){
       addOrderByDescending(Lead.NAME_PROPERTY);
       return this;
    }
    public LeadRequest<T> orderByNameAscendingUsingGBK(){
       addOrderByAscendingUsingGBK(Lead.NAME_PROPERTY);
       return this;
    }

    public LeadRequest<T> orderByNameDescendingUsingGBK(){
       addOrderByDescendingUsingGBK(Lead.NAME_PROPERTY);
       return this;
    }
    public LeadRequest<T> orderByPhoneAscending(){
       addOrderByAscending(Lead.PHONE_PROPERTY);
       return this;
    }

    public LeadRequest<T> orderByPhoneDescending(){
       addOrderByDescending(Lead.PHONE_PROPERTY);
       return this;
    }
    public LeadRequest<T> orderByPhoneAscendingUsingGBK(){
       addOrderByAscendingUsingGBK(Lead.PHONE_PROPERTY);
       return this;
    }

    public LeadRequest<T> orderByPhoneDescendingUsingGBK(){
       addOrderByDescendingUsingGBK(Lead.PHONE_PROPERTY);
       return this;
    }
    public LeadRequest<T> orderByConvertedCustomerIdAscending(){
       addOrderByAscending(Lead.CONVERTED_CUSTOMER_ID_PROPERTY);
       return this;
    }

    public LeadRequest<T> orderByConvertedCustomerIdDescending(){
       addOrderByDescending(Lead.CONVERTED_CUSTOMER_ID_PROPERTY);
       return this;
    }
    public LeadRequest<T> orderByConvertedCustomerIdAscendingUsingGBK(){
       addOrderByAscendingUsingGBK(Lead.CONVERTED_CUSTOMER_ID_PROPERTY);
       return this;
    }

    public LeadRequest<T> orderByConvertedCustomerIdDescendingUsingGBK(){
       addOrderByDescendingUsingGBK(Lead.CONVERTED_CUSTOMER_ID_PROPERTY);
       return this;
    }
    public LeadRequest<T> orderBySourceAscending(){
       addOrderByAscending(Lead.SOURCE_PROPERTY);
       return this;
    }

    public LeadRequest<T> orderBySourceDescending(){
       addOrderByDescending(Lead.SOURCE_PROPERTY);
       return this;
    }
    public LeadRequest<T> orderBySourceAscendingUsingGBK(){
       addOrderByAscendingUsingGBK(Lead.SOURCE_PROPERTY);
       return this;
    }

    public LeadRequest<T> orderBySourceDescendingUsingGBK(){
       addOrderByDescendingUsingGBK(Lead.SOURCE_PROPERTY);
       return this;
    }
    public LeadRequest<T> orderByStatusAscending(){
       addOrderByAscending(Lead.STATUS_PROPERTY);
       return this;
    }

    public LeadRequest<T> orderByStatusDescending(){
       addOrderByDescending(Lead.STATUS_PROPERTY);
       return this;
    }
    public LeadRequest<T> orderByStatusAscendingUsingGBK(){
       addOrderByAscendingUsingGBK(Lead.STATUS_PROPERTY);
       return this;
    }

    public LeadRequest<T> orderByStatusDescendingUsingGBK(){
       addOrderByDescendingUsingGBK(Lead.STATUS_PROPERTY);
       return this;
    }
    public LeadRequest<T> orderByCreateTimeAscending(){
       addOrderByAscending(Lead.CREATE_TIME_PROPERTY);
       return this;
    }

    public LeadRequest<T> orderByCreateTimeDescending(){
       addOrderByDescending(Lead.CREATE_TIME_PROPERTY);
       return this;
    }

    public LeadRequest<T> orderByUpdateTimeAscending(){
       addOrderByAscending(Lead.UPDATE_TIME_PROPERTY);
       return this;
    }

    public LeadRequest<T> orderByUpdateTimeDescending(){
       addOrderByDescending(Lead.UPDATE_TIME_PROPERTY);
       return this;
    }

    public LeadRequest<T> orderByVersionAscending(){
       addOrderByAscending(Lead.VERSION_PROPERTY);
       return this;
    }

    public LeadRequest<T> orderByVersionDescending(){
       addOrderByDescending(Lead.VERSION_PROPERTY);
       return this;
    }


    public LeadRequest<T> statsFromOpportunitiesAs(String name, OpportunityRequest subRequest){
       return statsFromOpportunitiesAs(name, subRequest, false);
    }

    public LeadRequest<T> statsFromOpportunitiesAs(String name, OpportunityRequest subRequest, boolean singleResult){
       subRequest.setPartitionProperty(Opportunity.LEAD_PROPERTY);
       addAggregateDynamicProperty(name, subRequest, singleResult);
       return this;
    }

    public LeadRequest<T> statsFromOpportunities(OpportunityRequest subRequest){
       return statsFromOpportunitiesAs(REFINEMENTS, subRequest);
    }
    public LeadRequest<T> countOpportunities(){
        return countOpportunitiesAs("Count");
    }

    public LeadRequest<T> countOpportunitiesAs(String name){
        return countOpportunitiesWith(name, Q.opportunities().unlimited());
    }

    public LeadRequest<T> countOpportunitiesWith(String name, OpportunityRequest subRequest){
        return statsFromOpportunitiesAs(name, subRequest.count(), true);
    }
    public LeadRequest<T> minExpectedRevenueOfOpportunities(){
        return minExpectedRevenueOfOpportunitiesAs("minExpectedRevenueOfOpportunities");
    }

    public LeadRequest<T> minExpectedRevenueOfOpportunitiesAs(String name){
        return minExpectedRevenueOfOpportunitiesAs(name, Q.opportunities().unlimited());
    }

    public LeadRequest<T> minExpectedRevenueOfOpportunitiesAs(String name, OpportunityRequest subRequest){
        return statsFromOpportunitiesAs(name, subRequest.minExpectedRevenue(), true);
    }
    public LeadRequest<T> maxExpectedRevenueOfOpportunities(){
        return maxExpectedRevenueOfOpportunitiesAs("maxExpectedRevenueOfOpportunities");
    }

    public LeadRequest<T> maxExpectedRevenueOfOpportunitiesAs(String name){
        return maxExpectedRevenueOfOpportunitiesAs(name, Q.opportunities().unlimited());
    }

    public LeadRequest<T> maxExpectedRevenueOfOpportunitiesAs(String name, OpportunityRequest subRequest){
        return statsFromOpportunitiesAs(name, subRequest.maxExpectedRevenue(), true);
    }
    public LeadRequest<T> sumExpectedRevenueOfOpportunities(){
        return sumExpectedRevenueOfOpportunitiesAs("sumExpectedRevenueOfOpportunities");
    }

    public LeadRequest<T> sumExpectedRevenueOfOpportunitiesAs(String name){
        return sumExpectedRevenueOfOpportunitiesAs(name, Q.opportunities().unlimited());
    }

    public LeadRequest<T> sumExpectedRevenueOfOpportunitiesAs(String name, OpportunityRequest subRequest){
        return statsFromOpportunitiesAs(name, subRequest.sumExpectedRevenue(), true);
    }
    public LeadRequest<T> avgExpectedRevenueOfOpportunities(){
        return avgExpectedRevenueOfOpportunitiesAs("avgExpectedRevenueOfOpportunities");
    }

    public LeadRequest<T> avgExpectedRevenueOfOpportunitiesAs(String name){
        return avgExpectedRevenueOfOpportunitiesAs(name, Q.opportunities().unlimited());
    }

    public LeadRequest<T> avgExpectedRevenueOfOpportunitiesAs(String name, OpportunityRequest subRequest){
        return statsFromOpportunitiesAs(name, subRequest.avgExpectedRevenue(), true);
    }
    public LeadRequest<T> standardDeviationExpectedRevenueOfOpportunities(){
        return standardDeviationExpectedRevenueOfOpportunitiesAs("stdDevExpectedRevenueOfOpportunities");
    }

    public LeadRequest<T> standardDeviationExpectedRevenueOfOpportunitiesAs(String name){
        return standardDeviationExpectedRevenueOfOpportunitiesAs(name, Q.opportunities().unlimited());
    }

    public LeadRequest<T> standardDeviationExpectedRevenueOfOpportunitiesAs(String name, OpportunityRequest subRequest){
        return statsFromOpportunitiesAs(name, subRequest.standardDeviationExpectedRevenue(), true);
    }
    public LeadRequest<T> squareRootOfPopulationStandardDeviationExpectedRevenueOfOpportunities(){
        return squareRootOfPopulationStandardDeviationExpectedRevenueOfOpportunitiesAs("stdDevPopExpectedRevenueOfOpportunities");
    }

    public LeadRequest<T> squareRootOfPopulationStandardDeviationExpectedRevenueOfOpportunitiesAs(String name){
        return squareRootOfPopulationStandardDeviationExpectedRevenueOfOpportunitiesAs(name, Q.opportunities().unlimited());
    }

    public LeadRequest<T> squareRootOfPopulationStandardDeviationExpectedRevenueOfOpportunitiesAs(String name, OpportunityRequest subRequest){
        return statsFromOpportunitiesAs(name, subRequest.squareRootOfPopulationStandardDeviationExpectedRevenue(), true);
    }
    public LeadRequest<T> sampleVarianceExpectedRevenueOfOpportunities(){
        return sampleVarianceExpectedRevenueOfOpportunitiesAs("varSampExpectedRevenueOfOpportunities");
    }

    public LeadRequest<T> sampleVarianceExpectedRevenueOfOpportunitiesAs(String name){
        return sampleVarianceExpectedRevenueOfOpportunitiesAs(name, Q.opportunities().unlimited());
    }

    public LeadRequest<T> sampleVarianceExpectedRevenueOfOpportunitiesAs(String name, OpportunityRequest subRequest){
        return statsFromOpportunitiesAs(name, subRequest.sampleVarianceExpectedRevenue(), true);
    }
    public LeadRequest<T> samplePopulationVarianceExpectedRevenueOfOpportunities(){
        return samplePopulationVarianceExpectedRevenueOfOpportunitiesAs("varPopExpectedRevenueOfOpportunities");
    }

    public LeadRequest<T> samplePopulationVarianceExpectedRevenueOfOpportunitiesAs(String name){
        return samplePopulationVarianceExpectedRevenueOfOpportunitiesAs(name, Q.opportunities().unlimited());
    }

    public LeadRequest<T> samplePopulationVarianceExpectedRevenueOfOpportunitiesAs(String name, OpportunityRequest subRequest){
        return statsFromOpportunitiesAs(name, subRequest.samplePopulationVarianceExpectedRevenue(), true);
    }
    public LeadRequest<T> minProbabilityOfOpportunities(){
        return minProbabilityOfOpportunitiesAs("minProbabilityOfOpportunities");
    }

    public LeadRequest<T> minProbabilityOfOpportunitiesAs(String name){
        return minProbabilityOfOpportunitiesAs(name, Q.opportunities().unlimited());
    }

    public LeadRequest<T> minProbabilityOfOpportunitiesAs(String name, OpportunityRequest subRequest){
        return statsFromOpportunitiesAs(name, subRequest.minProbability(), true);
    }
    public LeadRequest<T> maxProbabilityOfOpportunities(){
        return maxProbabilityOfOpportunitiesAs("maxProbabilityOfOpportunities");
    }

    public LeadRequest<T> maxProbabilityOfOpportunitiesAs(String name){
        return maxProbabilityOfOpportunitiesAs(name, Q.opportunities().unlimited());
    }

    public LeadRequest<T> maxProbabilityOfOpportunitiesAs(String name, OpportunityRequest subRequest){
        return statsFromOpportunitiesAs(name, subRequest.maxProbability(), true);
    }
    public LeadRequest<T> sumProbabilityOfOpportunities(){
        return sumProbabilityOfOpportunitiesAs("sumProbabilityOfOpportunities");
    }

    public LeadRequest<T> sumProbabilityOfOpportunitiesAs(String name){
        return sumProbabilityOfOpportunitiesAs(name, Q.opportunities().unlimited());
    }

    public LeadRequest<T> sumProbabilityOfOpportunitiesAs(String name, OpportunityRequest subRequest){
        return statsFromOpportunitiesAs(name, subRequest.sumProbability(), true);
    }
    public LeadRequest<T> avgProbabilityOfOpportunities(){
        return avgProbabilityOfOpportunitiesAs("avgProbabilityOfOpportunities");
    }

    public LeadRequest<T> avgProbabilityOfOpportunitiesAs(String name){
        return avgProbabilityOfOpportunitiesAs(name, Q.opportunities().unlimited());
    }

    public LeadRequest<T> avgProbabilityOfOpportunitiesAs(String name, OpportunityRequest subRequest){
        return statsFromOpportunitiesAs(name, subRequest.avgProbability(), true);
    }
    public LeadRequest<T> standardDeviationProbabilityOfOpportunities(){
        return standardDeviationProbabilityOfOpportunitiesAs("stdDevProbabilityOfOpportunities");
    }

    public LeadRequest<T> standardDeviationProbabilityOfOpportunitiesAs(String name){
        return standardDeviationProbabilityOfOpportunitiesAs(name, Q.opportunities().unlimited());
    }

    public LeadRequest<T> standardDeviationProbabilityOfOpportunitiesAs(String name, OpportunityRequest subRequest){
        return statsFromOpportunitiesAs(name, subRequest.standardDeviationProbability(), true);
    }
    public LeadRequest<T> squareRootOfPopulationStandardDeviationProbabilityOfOpportunities(){
        return squareRootOfPopulationStandardDeviationProbabilityOfOpportunitiesAs("stdDevPopProbabilityOfOpportunities");
    }

    public LeadRequest<T> squareRootOfPopulationStandardDeviationProbabilityOfOpportunitiesAs(String name){
        return squareRootOfPopulationStandardDeviationProbabilityOfOpportunitiesAs(name, Q.opportunities().unlimited());
    }

    public LeadRequest<T> squareRootOfPopulationStandardDeviationProbabilityOfOpportunitiesAs(String name, OpportunityRequest subRequest){
        return statsFromOpportunitiesAs(name, subRequest.squareRootOfPopulationStandardDeviationProbability(), true);
    }
    public LeadRequest<T> sampleVarianceProbabilityOfOpportunities(){
        return sampleVarianceProbabilityOfOpportunitiesAs("varSampProbabilityOfOpportunities");
    }

    public LeadRequest<T> sampleVarianceProbabilityOfOpportunitiesAs(String name){
        return sampleVarianceProbabilityOfOpportunitiesAs(name, Q.opportunities().unlimited());
    }

    public LeadRequest<T> sampleVarianceProbabilityOfOpportunitiesAs(String name, OpportunityRequest subRequest){
        return statsFromOpportunitiesAs(name, subRequest.sampleVarianceProbability(), true);
    }
    public LeadRequest<T> samplePopulationVarianceProbabilityOfOpportunities(){
        return samplePopulationVarianceProbabilityOfOpportunitiesAs("varPopProbabilityOfOpportunities");
    }

    public LeadRequest<T> samplePopulationVarianceProbabilityOfOpportunitiesAs(String name){
        return samplePopulationVarianceProbabilityOfOpportunitiesAs(name, Q.opportunities().unlimited());
    }

    public LeadRequest<T> samplePopulationVarianceProbabilityOfOpportunitiesAs(String name, OpportunityRequest subRequest){
        return statsFromOpportunitiesAs(name, subRequest.samplePopulationVarianceProbability(), true);
    }



    /**
     * get topN records
     * @param topN  records number
     */
    public LeadRequest<T> top(int topN) {
        super.top(topN);
        return this;
    }

    /**
     * get records from offset(inclusive) to offset+size(exclusive)
     * @param offset record offset
     * @param size records number
     */
    public LeadRequest<T> offset(int offset, int size) {
        super.offset(offset, size);
        return this;
    }

    /**
     * retrieve all records
     */
    public LeadRequest<T> unlimited() {
        super.unlimited();
        return this;
    }

    /**
     * get records of one page
     * @param pageNumber page number(1-based)
     * @param pageSize page size
     */
    public LeadRequest<T> page(int pageNumber, int pageSize) {
        int offset = (pageNumber - 1) * pageSize;
        return offset(offset, pageSize);
   }

    /**
     * get records of one page, default page size is 10
     * @param pageNumber page number(1-based)
     */
    public LeadRequest<T> page(int pageNumber) {
        return page(pageNumber, 10);
   }
}