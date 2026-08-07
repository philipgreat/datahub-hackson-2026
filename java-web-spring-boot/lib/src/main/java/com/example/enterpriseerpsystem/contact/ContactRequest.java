
package com.example.enterpriseerpsystem.contact;

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
import java.time.LocalDateTime;
import java.util.Date;

public class ContactRequest<T extends Contact> extends BaseRequest<T> {

    /**
     * @deprecated AI agents and business code must use the generated Q facade
     *             instead of constructing request builders directly.
     */
    @Deprecated
    public ContactRequest(Class<T> returnType){
        super(returnType);
        selectId();
        selectVersion();
    }

    public ContactRequest<T> comment(String comment){
         super.internalComment(comment);
         return this;
    }

    // purpose() 继承自 BaseRequest，返回 ExecutableRequest（终结方法）

    public ContactRequest<T> returnType(Class<? extends T> returnType){
        super.setReturnType(returnType);
        return this;
    }

    public ContactRequest<T> enableAggregationCache(long cacheExpiredMillis){
        super.enableAggregationCache();
        super.aggregateCacheTime(cacheExpiredMillis);
        return this;
    }

    public ContactRequest<T> enableAggregationCache(){
        return enableAggregationCache(0l);
    }


    public ContactRequest<T> propagateAggregationCache(long cacheExpiredMillis){
        super.propagateAggregationCache(cacheExpiredMillis);
        return this;
    }

    public ContactRequest<T> appendSearchCriteria(SearchCriteria searchCriteria){
        return (ContactRequest<T>)super.appendSearchCriteria(searchCriteria);
    }

    public ContactRequest<T> filter(String property1, Operator operator, String property2){
        return appendSearchCriteria(new TwoOperatorCriteria(operator, new PropertyReference(property1), new PropertyReference(property2)));
    }


    public ContactRequest<T> matchingAnyOf(ContactRequest contact){
        super.internalMatchAny(contact);
        return this;
    }

    public ContactRequest<T> enhanceChildrenIfNeeded(){
        return this;
    }

    public ContactRequest<T> withDeletedRows(){
        super.withDeletedRows();
        return this;
    }

    public ContactRequest<T> deletedRowsOnly(){
        super.deletedRowsOnly();
        return this;
    }

    public ContactRequest<T> selectSelf(){
        super.selectSelf();
        return selectId().selectEmail().selectName().selectPhone().selectCustomerIdOnly().selectRole().selectCreateTime().selectUpdateTime().selectVersion();
    }

    public ContactRequest<T> selectSelfFields(){
        return selectSelf();
    }

    public ContactRequest<T> selectAll(){
        super.selectAll();
        return selectId().selectEmail().selectName().selectPhone().selectCustomer().selectRole().selectCreateTime().selectUpdateTime().selectVersion();
    }

    public ContactRequest<T> selectChildren(){
        super.selectAny();
        return selectId().selectEmail().selectName().selectPhone().selectCustomer().selectRole().selectCreateTime().selectUpdateTime().selectVersion();
    }


    public ContactRequest<T> selectId(){
       selectProperty(Contact.ID_PROPERTY);
       return this;
    }

    /**
     * fill the id with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  id) to fetch id property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public ContactRequest<T> unselectId(){
       unselectProperty(Contact.ID_PROPERTY);
       return this;
    }
    public ContactRequest<T> selectEmail(){
       selectProperty(Contact.EMAIL_PROPERTY);
       return this;
    }

    /**
     * fill the email with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  email) to fetch email property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public ContactRequest<T> unselectEmail(){
       unselectProperty(Contact.EMAIL_PROPERTY);
       return this;
    }
    public ContactRequest<T> selectName(){
       selectProperty(Contact.NAME_PROPERTY);
       return this;
    }

    /**
     * fill the name with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  name) to fetch name property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public ContactRequest<T> unselectName(){
       unselectProperty(Contact.NAME_PROPERTY);
       return this;
    }
    public ContactRequest<T> selectPhone(){
       selectProperty(Contact.PHONE_PROPERTY);
       return this;
    }

    /**
     * fill the phone with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  phone) to fetch phone property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public ContactRequest<T> unselectPhone(){
       unselectProperty(Contact.PHONE_PROPERTY);
       return this;
    }
    public ContactRequest<T> selectCustomerIdOnly(){
       selectProperty(Contact.CUSTOMER_PROPERTY);
       return this;
    }

    public ContactRequest<T> selectCustomer(){
        return selectCustomerWith(Q.customers().unlimited().selectSelf());
    }

    public ContactRequest<T> selectCustomerWith(CustomerRequest customer){
       selectProperty(Contact.CUSTOMER_PROPERTY);
       enhanceRelation(Contact.CUSTOMER_PROPERTY, customer);
       return this;
    }

    public ContactRequest<T> unselectCustomer(){
       unselectProperty(Contact.CUSTOMER_PROPERTY);
       return this;
    }
    public ContactRequest<T> selectRole(){
       selectProperty(Contact.ROLE_PROPERTY);
       return this;
    }

    /**
     * fill the role with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  role) to fetch role property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public ContactRequest<T> unselectRole(){
       unselectProperty(Contact.ROLE_PROPERTY);
       return this;
    }
    public ContactRequest<T> selectCreateTime(){
       selectProperty(Contact.CREATE_TIME_PROPERTY);
       return this;
    }

    /**
     * fill the createTime with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  createTime) to fetch createTime property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public ContactRequest<T> unselectCreateTime(){
       unselectProperty(Contact.CREATE_TIME_PROPERTY);
       return this;
    }
    public ContactRequest<T> selectUpdateTime(){
       selectProperty(Contact.UPDATE_TIME_PROPERTY);
       return this;
    }

    /**
     * fill the updateTime with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  updateTime) to fetch updateTime property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public ContactRequest<T> unselectUpdateTime(){
       unselectProperty(Contact.UPDATE_TIME_PROPERTY);
       return this;
    }
    public ContactRequest<T> selectVersion(){
       selectProperty(Contact.VERSION_PROPERTY);
       return this;
    }

    /**
     * fill the version with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  version) to fetch version property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public ContactRequest<T> unselectVersion(){
       unselectProperty(Contact.VERSION_PROPERTY);
       return this;
    }

    public ContactRequest<T> withId(Operator operator, Object... values){
       return appendSearchCriteria(createIdCriteria(operator, values));
    }

    public SearchCriteria createIdCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Contact.ID_PROPERTY, operator, values);
    }

    public ContactRequest<T> withIdIs(Long id){
       return withId(Operator.EQUAL, id);
    }
    public ContactRequest<T> withIdIn(Long... id){
       return withId(Operator.EQUAL, (Object[])id);
    }



    public ContactRequest<T> filterByEmail(String... email){
      if (email == null || email.length == 0) {
        throw new IllegalArgumentException("filterByEmail parameter email cannot be empty");
      }
      return appendSearchCriteria(createEmailCriteria(Operator.EQUAL, (Object[])email));
    }

    public ContactRequest<T> withEmail(Operator operator, Object... values){
       return appendSearchCriteria(createEmailCriteria(operator, values));
    }

    public ContactRequest<T> withEmailIsUnknown(){
       return withEmail(Operator.IS_NULL);
    }

    public ContactRequest<T> withEmailIsKnown(){
       return withEmail(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createEmailCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Contact.EMAIL_PROPERTY, operator, values);
    }

    public ContactRequest<T> withEmailGreaterThan(String email){
       return withEmail(Operator.GREATER_THAN, email);
    }

    public ContactRequest<T> withEmailGreaterThanOrEqualTo(String email){
       return withEmail(Operator.GREATER_THAN_OR_EQUAL, email);
    }

    public ContactRequest<T> withEmailLessThan(String email){
       return withEmail(Operator.LESS_THAN, email);
    }

    public ContactRequest<T> withEmailLessThanOrEqualTo(String email){
       return withEmail(Operator.LESS_THAN_OR_EQUAL, email);
    }

    public ContactRequest<T> withEmailBetween(String startOfEmail, String endOfEmail){
       return withEmail(Operator.BETWEEN, startOfEmail, endOfEmail);
    }
    public ContactRequest<T> withEmailStartingWith(String email){
       return withEmail(Operator.BEGIN_WITH, email);
    }
    public ContactRequest<T> withEmailContaining(String email){
       return withEmail(Operator.CONTAIN, email);
    }

    public ContactRequest<T> withEmailEndingWith(String email){
       return withEmail(Operator.END_WITH, email);
    }

    public ContactRequest<T> withEmailIs(String email){
       return withEmail(Operator.EQUAL, email);
    }

    public ContactRequest<T> withEmailSoundingLike(String email){
       return withEmail(Operator.SOUNDS_LIKE, email);
    }



    public ContactRequest<T> filterByName(String... name){
      if (name == null || name.length == 0) {
        throw new IllegalArgumentException("filterByName parameter name cannot be empty");
      }
      return appendSearchCriteria(createNameCriteria(Operator.EQUAL, (Object[])name));
    }

    public ContactRequest<T> withName(Operator operator, Object... values){
       return appendSearchCriteria(createNameCriteria(operator, values));
    }

    public ContactRequest<T> withNameIsUnknown(){
       return withName(Operator.IS_NULL);
    }

    public ContactRequest<T> withNameIsKnown(){
       return withName(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createNameCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Contact.NAME_PROPERTY, operator, values);
    }

    public ContactRequest<T> withNameGreaterThan(String name){
       return withName(Operator.GREATER_THAN, name);
    }

    public ContactRequest<T> withNameGreaterThanOrEqualTo(String name){
       return withName(Operator.GREATER_THAN_OR_EQUAL, name);
    }

    public ContactRequest<T> withNameLessThan(String name){
       return withName(Operator.LESS_THAN, name);
    }

    public ContactRequest<T> withNameLessThanOrEqualTo(String name){
       return withName(Operator.LESS_THAN_OR_EQUAL, name);
    }

    public ContactRequest<T> withNameBetween(String startOfName, String endOfName){
       return withName(Operator.BETWEEN, startOfName, endOfName);
    }
    public ContactRequest<T> withNameStartingWith(String name){
       return withName(Operator.BEGIN_WITH, name);
    }
    public ContactRequest<T> withNameContaining(String name){
       return withName(Operator.CONTAIN, name);
    }

    public ContactRequest<T> withNameEndingWith(String name){
       return withName(Operator.END_WITH, name);
    }

    public ContactRequest<T> withNameIs(String name){
       return withName(Operator.EQUAL, name);
    }

    public ContactRequest<T> withNameSoundingLike(String name){
       return withName(Operator.SOUNDS_LIKE, name);
    }



    public ContactRequest<T> filterByPhone(String... phone){
      if (phone == null || phone.length == 0) {
        throw new IllegalArgumentException("filterByPhone parameter phone cannot be empty");
      }
      return appendSearchCriteria(createPhoneCriteria(Operator.EQUAL, (Object[])phone));
    }

    public ContactRequest<T> withPhone(Operator operator, Object... values){
       return appendSearchCriteria(createPhoneCriteria(operator, values));
    }

    public ContactRequest<T> withPhoneIsUnknown(){
       return withPhone(Operator.IS_NULL);
    }

    public ContactRequest<T> withPhoneIsKnown(){
       return withPhone(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createPhoneCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Contact.PHONE_PROPERTY, operator, values);
    }

    public ContactRequest<T> withPhoneGreaterThan(String phone){
       return withPhone(Operator.GREATER_THAN, phone);
    }

    public ContactRequest<T> withPhoneGreaterThanOrEqualTo(String phone){
       return withPhone(Operator.GREATER_THAN_OR_EQUAL, phone);
    }

    public ContactRequest<T> withPhoneLessThan(String phone){
       return withPhone(Operator.LESS_THAN, phone);
    }

    public ContactRequest<T> withPhoneLessThanOrEqualTo(String phone){
       return withPhone(Operator.LESS_THAN_OR_EQUAL, phone);
    }

    public ContactRequest<T> withPhoneBetween(String startOfPhone, String endOfPhone){
       return withPhone(Operator.BETWEEN, startOfPhone, endOfPhone);
    }
    public ContactRequest<T> withPhoneStartingWith(String phone){
       return withPhone(Operator.BEGIN_WITH, phone);
    }
    public ContactRequest<T> withPhoneContaining(String phone){
       return withPhone(Operator.CONTAIN, phone);
    }

    public ContactRequest<T> withPhoneEndingWith(String phone){
       return withPhone(Operator.END_WITH, phone);
    }

    public ContactRequest<T> withPhoneIs(String phone){
       return withPhone(Operator.EQUAL, phone);
    }

    public ContactRequest<T> withPhoneSoundingLike(String phone){
       return withPhone(Operator.SOUNDS_LIKE, phone);
    }



    public ContactRequest<T> filterByCustomer(Customer... customer){
      if (customer == null || customer.length == 0) {
        throw new IllegalArgumentException("filterByCustomer parameter customer cannot be empty");
      }
      return appendSearchCriteria(createCustomerCriteria(Operator.EQUAL, (Object[])customer));
    }

    public ContactRequest<T> withCustomer(Operator operator, Object... values){
       return appendSearchCriteria(createCustomerCriteria(operator, values));
    }

    public ContactRequest<T> withCustomerIsUnknown(){
       return withCustomer(Operator.IS_NULL);
    }

    public ContactRequest<T> withCustomerIsKnown(){
       return withCustomer(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createCustomerCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Contact.CUSTOMER_PROPERTY, operator, values);
    }

    public ContactRequest<T> filterByCustomer(Long customer){
      if(customer == null){
         return this;
      }
      return withCustomer(Operator.EQUAL, customer);
    }
    public ContactRequest<T> withCustomerMatching(CustomerRequest customer){
       return appendSearchCriteria(new SubQuerySearchCriteria(Contact.CUSTOMER_PROPERTY, customer, Customer.ID_PROPERTY));
    }

    public ContactRequest<T> filterByRole(String... role){
      if (role == null || role.length == 0) {
        throw new IllegalArgumentException("filterByRole parameter role cannot be empty");
      }
      return appendSearchCriteria(createRoleCriteria(Operator.EQUAL, (Object[])role));
    }

    public ContactRequest<T> withRole(Operator operator, Object... values){
       return appendSearchCriteria(createRoleCriteria(operator, values));
    }

    public ContactRequest<T> withRoleIsUnknown(){
       return withRole(Operator.IS_NULL);
    }

    public ContactRequest<T> withRoleIsKnown(){
       return withRole(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createRoleCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Contact.ROLE_PROPERTY, operator, values);
    }

    public ContactRequest<T> withRoleGreaterThan(String role){
       return withRole(Operator.GREATER_THAN, role);
    }

    public ContactRequest<T> withRoleGreaterThanOrEqualTo(String role){
       return withRole(Operator.GREATER_THAN_OR_EQUAL, role);
    }

    public ContactRequest<T> withRoleLessThan(String role){
       return withRole(Operator.LESS_THAN, role);
    }

    public ContactRequest<T> withRoleLessThanOrEqualTo(String role){
       return withRole(Operator.LESS_THAN_OR_EQUAL, role);
    }

    public ContactRequest<T> withRoleBetween(String startOfRole, String endOfRole){
       return withRole(Operator.BETWEEN, startOfRole, endOfRole);
    }
    public ContactRequest<T> withRoleStartingWith(String role){
       return withRole(Operator.BEGIN_WITH, role);
    }
    public ContactRequest<T> withRoleContaining(String role){
       return withRole(Operator.CONTAIN, role);
    }

    public ContactRequest<T> withRoleEndingWith(String role){
       return withRole(Operator.END_WITH, role);
    }

    public ContactRequest<T> withRoleIs(String role){
       return withRole(Operator.EQUAL, role);
    }

    public ContactRequest<T> withRoleSoundingLike(String role){
       return withRole(Operator.SOUNDS_LIKE, role);
    }



    public ContactRequest<T> filterByCreateTime(LocalDateTime... createTime){
      if (createTime == null || createTime.length == 0) {
        throw new IllegalArgumentException("filterByCreateTime parameter createTime cannot be empty");
      }
      return appendSearchCriteria(createCreateTimeCriteria(Operator.EQUAL, (Object[])createTime));
    }

    public ContactRequest<T> withCreateTime(Operator operator, Object... values){
       return appendSearchCriteria(createCreateTimeCriteria(operator, values));
    }

    public ContactRequest<T> withCreateTimeIsUnknown(){
       return withCreateTime(Operator.IS_NULL);
    }

    public ContactRequest<T> withCreateTimeIsKnown(){
       return withCreateTime(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createCreateTimeCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Contact.CREATE_TIME_PROPERTY, operator, values);
    }

    public ContactRequest<T> withCreateTimeGreaterThan(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public ContactRequest<T> withCreateTimeGreaterThanOrEqualTo(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN_OR_EQUAL, createTime);
    }

    public ContactRequest<T> withCreateTimeLessThan(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public ContactRequest<T> withCreateTimeLessThanOrEqualTo(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN_OR_EQUAL, createTime);
    }

    public ContactRequest<T> withCreateTimeBetween(LocalDateTime startOfCreateTime, LocalDateTime endOfCreateTime){
       return withCreateTime(Operator.BETWEEN, startOfCreateTime, endOfCreateTime);
    }
    public ContactRequest<T> withCreateTimeBefore(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public ContactRequest<T> withCreateTimeBefore(Date createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public ContactRequest<T> withCreateTimeAfter(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public ContactRequest<T> withCreateTimeAfter(Date createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public ContactRequest<T> withCreateTimeBetween(Date startOfCreateTime, Date endOfCreateTime){
       return withCreateTime(Operator.BETWEEN, startOfCreateTime, endOfCreateTime);
    }




    public ContactRequest<T> filterByUpdateTime(LocalDateTime... updateTime){
      if (updateTime == null || updateTime.length == 0) {
        throw new IllegalArgumentException("filterByUpdateTime parameter updateTime cannot be empty");
      }
      return appendSearchCriteria(createUpdateTimeCriteria(Operator.EQUAL, (Object[])updateTime));
    }

    public ContactRequest<T> withUpdateTime(Operator operator, Object... values){
       return appendSearchCriteria(createUpdateTimeCriteria(operator, values));
    }

    public ContactRequest<T> withUpdateTimeIsUnknown(){
       return withUpdateTime(Operator.IS_NULL);
    }

    public ContactRequest<T> withUpdateTimeIsKnown(){
       return withUpdateTime(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createUpdateTimeCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Contact.UPDATE_TIME_PROPERTY, operator, values);
    }

    public ContactRequest<T> withUpdateTimeGreaterThan(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public ContactRequest<T> withUpdateTimeGreaterThanOrEqualTo(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN_OR_EQUAL, updateTime);
    }

    public ContactRequest<T> withUpdateTimeLessThan(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public ContactRequest<T> withUpdateTimeLessThanOrEqualTo(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN_OR_EQUAL, updateTime);
    }

    public ContactRequest<T> withUpdateTimeBetween(LocalDateTime startOfUpdateTime, LocalDateTime endOfUpdateTime){
       return withUpdateTime(Operator.BETWEEN, startOfUpdateTime, endOfUpdateTime);
    }
    public ContactRequest<T> withUpdateTimeBefore(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public ContactRequest<T> withUpdateTimeBefore(Date updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public ContactRequest<T> withUpdateTimeAfter(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public ContactRequest<T> withUpdateTimeAfter(Date updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public ContactRequest<T> withUpdateTimeBetween(Date startOfUpdateTime, Date endOfUpdateTime){
       return withUpdateTime(Operator.BETWEEN, startOfUpdateTime, endOfUpdateTime);
    }




    public ContactRequest<T> filterByVersion(Long... version){
      if (version == null || version.length == 0) {
        throw new IllegalArgumentException("filterByVersion parameter version cannot be empty");
      }
      return appendSearchCriteria(createVersionCriteria(Operator.EQUAL, (Object[])version));
    }

    public ContactRequest<T> withVersion(Operator operator, Object... values){
       return appendSearchCriteria(createVersionCriteria(operator, values));
    }

    public ContactRequest<T> withVersionIsUnknown(){
       return withVersion(Operator.IS_NULL);
    }

    public ContactRequest<T> withVersionIsKnown(){
       return withVersion(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createVersionCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Contact.VERSION_PROPERTY, operator, values);
    }

    public ContactRequest<T> withVersionGreaterThan(Long version){
       return withVersion(Operator.GREATER_THAN, version);
    }

    public ContactRequest<T> withVersionGreaterThanOrEqualTo(Long version){
       return withVersion(Operator.GREATER_THAN_OR_EQUAL, version);
    }

    public ContactRequest<T> withVersionLessThan(Long version){
       return withVersion(Operator.LESS_THAN, version);
    }

    public ContactRequest<T> withVersionLessThanOrEqualTo(Long version){
       return withVersion(Operator.LESS_THAN_OR_EQUAL, version);
    }

    public ContactRequest<T> withVersionBetween(Long startOfVersion, Long endOfVersion){
       return withVersion(Operator.BETWEEN, startOfVersion, endOfVersion);
    }


    public ContactRequest<T> count(){
        super.count();
        return this;
    }
    public ContactRequest<T> countAs(String retName){
        super.count(retName);
        return this;
    }
    public ContactRequest<T> groupByCustomerWithDetails(){
       return groupByCustomerWithDetails(Q.customers().unlimited());
    }

    public ContactRequest<T> groupByCustomerWithDetails(CustomerRequest subRequest){
       aggregate(Contact.CUSTOMER_PROPERTY, subRequest);
       return this;
    }






    public ContactRequest<T> groupById(){
       groupBy(Contact.ID_PROPERTY);
       return this;
    }

    public ContactRequest<T> groupByIdAs(String retName){
       groupBy(retName, Contact.ID_PROPERTY);
       return this;
    }

    public ContactRequest<T> groupByIdWithFunction(String retName, AggrFunction function){
       groupBy(retName, Contact.ID_PROPERTY, function);
       return this;
    }

    public ContactRequest<T> groupByEmail(){
       groupBy(Contact.EMAIL_PROPERTY);
       return this;
    }

    public ContactRequest<T> groupByEmailAs(String retName){
       groupBy(retName, Contact.EMAIL_PROPERTY);
       return this;
    }

    public ContactRequest<T> groupByEmailWithFunction(String retName, AggrFunction function){
       groupBy(retName, Contact.EMAIL_PROPERTY, function);
       return this;
    }

    public ContactRequest<T> groupByName(){
       groupBy(Contact.NAME_PROPERTY);
       return this;
    }

    public ContactRequest<T> groupByNameAs(String retName){
       groupBy(retName, Contact.NAME_PROPERTY);
       return this;
    }

    public ContactRequest<T> groupByNameWithFunction(String retName, AggrFunction function){
       groupBy(retName, Contact.NAME_PROPERTY, function);
       return this;
    }

    public ContactRequest<T> groupByPhone(){
       groupBy(Contact.PHONE_PROPERTY);
       return this;
    }

    public ContactRequest<T> groupByPhoneAs(String retName){
       groupBy(retName, Contact.PHONE_PROPERTY);
       return this;
    }

    public ContactRequest<T> groupByPhoneWithFunction(String retName, AggrFunction function){
       groupBy(retName, Contact.PHONE_PROPERTY, function);
       return this;
    }
    public ContactRequest<T> groupByCustomerWith(CustomerRequest subRequest){
       groupBy(Contact.CUSTOMER_PROPERTY, subRequest);
       return this;
    }
    public ContactRequest<T> groupByCustomer(){
       groupBy(Contact.CUSTOMER_PROPERTY);
       return this;
    }

    public ContactRequest<T> groupByCustomerAs(String retName){
       groupBy(retName, Contact.CUSTOMER_PROPERTY);
       return this;
    }

    public ContactRequest<T> groupByCustomerWithFunction(String retName, AggrFunction function){
       groupBy(retName, Contact.CUSTOMER_PROPERTY, function);
       return this;
    }

    public ContactRequest<T> groupByRole(){
       groupBy(Contact.ROLE_PROPERTY);
       return this;
    }

    public ContactRequest<T> groupByRoleAs(String retName){
       groupBy(retName, Contact.ROLE_PROPERTY);
       return this;
    }

    public ContactRequest<T> groupByRoleWithFunction(String retName, AggrFunction function){
       groupBy(retName, Contact.ROLE_PROPERTY, function);
       return this;
    }

    public ContactRequest<T> groupByCreateTime(){
       groupBy(Contact.CREATE_TIME_PROPERTY);
       return this;
    }

    public ContactRequest<T> groupByCreateTimeAs(String retName){
       groupBy(retName, Contact.CREATE_TIME_PROPERTY);
       return this;
    }

    public ContactRequest<T> groupByCreateTimeWithFunction(String retName, AggrFunction function){
       groupBy(retName, Contact.CREATE_TIME_PROPERTY, function);
       return this;
    }

    public ContactRequest<T> groupByUpdateTime(){
       groupBy(Contact.UPDATE_TIME_PROPERTY);
       return this;
    }

    public ContactRequest<T> groupByUpdateTimeAs(String retName){
       groupBy(retName, Contact.UPDATE_TIME_PROPERTY);
       return this;
    }

    public ContactRequest<T> groupByUpdateTimeWithFunction(String retName, AggrFunction function){
       groupBy(retName, Contact.UPDATE_TIME_PROPERTY, function);
       return this;
    }

    public ContactRequest<T> groupByVersion(){
       groupBy(Contact.VERSION_PROPERTY);
       return this;
    }

    public ContactRequest<T> groupByVersionAs(String retName){
       groupBy(retName, Contact.VERSION_PROPERTY);
       return this;
    }

    public ContactRequest<T> groupByVersionWithFunction(String retName, AggrFunction function){
       groupBy(retName, Contact.VERSION_PROPERTY, function);
       return this;
    }



    public ContactRequest<T> orderByIdAscending(){
       addOrderByAscending(Contact.ID_PROPERTY);
       return this;
    }

    public ContactRequest<T> orderByIdDescending(){
       addOrderByDescending(Contact.ID_PROPERTY);
       return this;
    }

    public ContactRequest<T> orderByEmailAscending(){
       addOrderByAscending(Contact.EMAIL_PROPERTY);
       return this;
    }

    public ContactRequest<T> orderByEmailDescending(){
       addOrderByDescending(Contact.EMAIL_PROPERTY);
       return this;
    }
    public ContactRequest<T> orderByEmailAscendingUsingGBK(){
       addOrderByAscendingUsingGBK(Contact.EMAIL_PROPERTY);
       return this;
    }

    public ContactRequest<T> orderByEmailDescendingUsingGBK(){
       addOrderByDescendingUsingGBK(Contact.EMAIL_PROPERTY);
       return this;
    }
    public ContactRequest<T> orderByNameAscending(){
       addOrderByAscending(Contact.NAME_PROPERTY);
       return this;
    }

    public ContactRequest<T> orderByNameDescending(){
       addOrderByDescending(Contact.NAME_PROPERTY);
       return this;
    }
    public ContactRequest<T> orderByNameAscendingUsingGBK(){
       addOrderByAscendingUsingGBK(Contact.NAME_PROPERTY);
       return this;
    }

    public ContactRequest<T> orderByNameDescendingUsingGBK(){
       addOrderByDescendingUsingGBK(Contact.NAME_PROPERTY);
       return this;
    }
    public ContactRequest<T> orderByPhoneAscending(){
       addOrderByAscending(Contact.PHONE_PROPERTY);
       return this;
    }

    public ContactRequest<T> orderByPhoneDescending(){
       addOrderByDescending(Contact.PHONE_PROPERTY);
       return this;
    }
    public ContactRequest<T> orderByPhoneAscendingUsingGBK(){
       addOrderByAscendingUsingGBK(Contact.PHONE_PROPERTY);
       return this;
    }

    public ContactRequest<T> orderByPhoneDescendingUsingGBK(){
       addOrderByDescendingUsingGBK(Contact.PHONE_PROPERTY);
       return this;
    }
    public ContactRequest<T> orderByCustomerAscending(){
       addOrderByAscending(Contact.CUSTOMER_PROPERTY);
       return this;
    }

    public ContactRequest<T> orderByCustomerDescending(){
       addOrderByDescending(Contact.CUSTOMER_PROPERTY);
       return this;
    }

    public ContactRequest<T> orderByRoleAscending(){
       addOrderByAscending(Contact.ROLE_PROPERTY);
       return this;
    }

    public ContactRequest<T> orderByRoleDescending(){
       addOrderByDescending(Contact.ROLE_PROPERTY);
       return this;
    }
    public ContactRequest<T> orderByRoleAscendingUsingGBK(){
       addOrderByAscendingUsingGBK(Contact.ROLE_PROPERTY);
       return this;
    }

    public ContactRequest<T> orderByRoleDescendingUsingGBK(){
       addOrderByDescendingUsingGBK(Contact.ROLE_PROPERTY);
       return this;
    }
    public ContactRequest<T> orderByCreateTimeAscending(){
       addOrderByAscending(Contact.CREATE_TIME_PROPERTY);
       return this;
    }

    public ContactRequest<T> orderByCreateTimeDescending(){
       addOrderByDescending(Contact.CREATE_TIME_PROPERTY);
       return this;
    }

    public ContactRequest<T> orderByUpdateTimeAscending(){
       addOrderByAscending(Contact.UPDATE_TIME_PROPERTY);
       return this;
    }

    public ContactRequest<T> orderByUpdateTimeDescending(){
       addOrderByDescending(Contact.UPDATE_TIME_PROPERTY);
       return this;
    }

    public ContactRequest<T> orderByVersionAscending(){
       addOrderByAscending(Contact.VERSION_PROPERTY);
       return this;
    }

    public ContactRequest<T> orderByVersionDescending(){
       addOrderByDescending(Contact.VERSION_PROPERTY);
       return this;
    }


    public CustomerRequest rollUpToCustomer(){
       CustomerRequest customer = Q.customers().unlimited();
       this.withCustomerMatching(customer)
           .groupByCustomerWith(customer);
       return customer;
    }






   public ContactRequest<T> facetByCustomerAs(String facetName, CustomerRequest customer){
       return facetByCustomerAs(facetName, customer, true);
   }

   public ContactRequest<T> facetByCustomerAs(String facetName, CustomerRequest customer, boolean includeAllFacets){
       addFacet(facetName, Contact.CUSTOMER_PROPERTY, customer, includeAllFacets);
       return this;
   }


    /**
     * get topN records
     * @param topN  records number
     */
    public ContactRequest<T> top(int topN) {
        super.top(topN);
        return this;
    }

    /**
     * get records from offset(inclusive) to offset+size(exclusive)
     * @param offset record offset
     * @param size records number
     */
    public ContactRequest<T> offset(int offset, int size) {
        super.offset(offset, size);
        return this;
    }

    /**
     * retrieve all records
     */
    public ContactRequest<T> unlimited() {
        super.unlimited();
        return this;
    }

    /**
     * get records of one page
     * @param pageNumber page number(1-based)
     * @param pageSize page size
     */
    public ContactRequest<T> page(int pageNumber, int pageSize) {
        int offset = (pageNumber - 1) * pageSize;
        return offset(offset, pageSize);
   }

    /**
     * get records of one page, default page size is 10
     * @param pageNumber page number(1-based)
     */
    public ContactRequest<T> page(int pageNumber) {
        return page(pageNumber, 10);
   }
}