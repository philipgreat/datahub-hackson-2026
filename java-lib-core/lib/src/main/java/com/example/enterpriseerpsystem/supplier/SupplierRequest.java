
package com.example.enterpriseerpsystem.supplier;

import com.example.enterpriseerpsystem.Q;
import com.example.enterpriseerpsystem.purchaseorder.PurchaseOrder;
import com.example.enterpriseerpsystem.purchaseorder.PurchaseOrderRequest;
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

public class SupplierRequest<T extends Supplier> extends BaseRequest<T> {

    /**
     * @deprecated AI agents and business code must use the generated Q facade
     *             instead of constructing request builders directly.
     */
    @Deprecated
    public SupplierRequest(Class<T> returnType){
        super(returnType);
        selectId();
        selectVersion();
    }

    public SupplierRequest<T> comment(String comment){
         super.internalComment(comment);
         return this;
    }

    // purpose() 继承自 BaseRequest，返回 ExecutableRequest（终结方法）

    public SupplierRequest<T> returnType(Class<? extends T> returnType){
        super.setReturnType(returnType);
        return this;
    }

    public SupplierRequest<T> enableAggregationCache(long cacheExpiredMillis){
        super.enableAggregationCache();
        super.aggregateCacheTime(cacheExpiredMillis);
        return this;
    }

    public SupplierRequest<T> enableAggregationCache(){
        return enableAggregationCache(0l);
    }


    public SupplierRequest<T> propagateAggregationCache(long cacheExpiredMillis){
        super.propagateAggregationCache(cacheExpiredMillis);
        return this;
    }

    public SupplierRequest<T> appendSearchCriteria(SearchCriteria searchCriteria){
        return (SupplierRequest<T>)super.appendSearchCriteria(searchCriteria);
    }

    public SupplierRequest<T> filter(String property1, Operator operator, String property2){
        return appendSearchCriteria(new TwoOperatorCriteria(operator, new PropertyReference(property1), new PropertyReference(property2)));
    }


    public SupplierRequest<T> matchingAnyOf(SupplierRequest supplier){
        super.internalMatchAny(supplier);
        return this;
    }

    public SupplierRequest<T> enhanceChildrenIfNeeded(){
        return this;
    }

    public SupplierRequest<T> withDeletedRows(){
        super.withDeletedRows();
        return this;
    }

    public SupplierRequest<T> deletedRowsOnly(){
        super.deletedRowsOnly();
        return this;
    }

    public SupplierRequest<T> selectSelf(){
        super.selectSelf();
        return selectId().selectAddress().selectContactEmail().selectName().selectPhone().selectRating().selectCreateTime().selectUpdateTime().selectVersion();
    }

    public SupplierRequest<T> selectSelfFields(){
        return selectSelf();
    }

    public SupplierRequest<T> selectAll(){
        super.selectAll();
        return selectId().selectAddress().selectContactEmail().selectName().selectPhone().selectRating().selectCreateTime().selectUpdateTime().selectVersion();
    }

    public SupplierRequest<T> selectChildren(){
        super.selectAny();
        selectPurchaseOrderList();
        return selectId().selectAddress().selectContactEmail().selectName().selectPhone().selectRating().selectCreateTime().selectUpdateTime().selectVersion();
    }


    public SupplierRequest<T> selectId(){
       selectProperty(Supplier.ID_PROPERTY);
       return this;
    }

    /**
     * fill the id with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  id) to fetch id property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public SupplierRequest<T> unselectId(){
       unselectProperty(Supplier.ID_PROPERTY);
       return this;
    }
    public SupplierRequest<T> selectAddress(){
       selectProperty(Supplier.ADDRESS_PROPERTY);
       return this;
    }

    /**
     * fill the address with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  address) to fetch address property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public SupplierRequest<T> unselectAddress(){
       unselectProperty(Supplier.ADDRESS_PROPERTY);
       return this;
    }
    public SupplierRequest<T> selectContactEmail(){
       selectProperty(Supplier.CONTACT_EMAIL_PROPERTY);
       return this;
    }

    /**
     * fill the contactEmail with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  contactEmail) to fetch contactEmail property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public SupplierRequest<T> unselectContactEmail(){
       unselectProperty(Supplier.CONTACT_EMAIL_PROPERTY);
       return this;
    }
    public SupplierRequest<T> selectName(){
       selectProperty(Supplier.NAME_PROPERTY);
       return this;
    }

    /**
     * fill the name with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  name) to fetch name property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public SupplierRequest<T> unselectName(){
       unselectProperty(Supplier.NAME_PROPERTY);
       return this;
    }
    public SupplierRequest<T> selectPhone(){
       selectProperty(Supplier.PHONE_PROPERTY);
       return this;
    }

    /**
     * fill the phone with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  phone) to fetch phone property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public SupplierRequest<T> unselectPhone(){
       unselectProperty(Supplier.PHONE_PROPERTY);
       return this;
    }
    public SupplierRequest<T> selectRating(){
       selectProperty(Supplier.RATING_PROPERTY);
       return this;
    }

    /**
     * fill the rating with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  rating) to fetch rating property.
     * @param rawSqlSegment  customized rawSqlSegment
     */


    /**
     * fill the rating with customized aggrFunction, TEAQL uses ({aggrFunction}(rating) AS rating to fetch rating property.
     * @param aggrFunction  aggrFunction
     */
    public SupplierRequest<T> selectRating(AggrFunction aggrFunction){
       selectProperty(Supplier.RATING_PROPERTY, aggrFunction);
       return this;
    }


    public SupplierRequest<T> unselectRating(){
       unselectProperty(Supplier.RATING_PROPERTY);
       return this;
    }
    public SupplierRequest<T> selectCreateTime(){
       selectProperty(Supplier.CREATE_TIME_PROPERTY);
       return this;
    }

    /**
     * fill the createTime with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  createTime) to fetch createTime property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public SupplierRequest<T> unselectCreateTime(){
       unselectProperty(Supplier.CREATE_TIME_PROPERTY);
       return this;
    }
    public SupplierRequest<T> selectUpdateTime(){
       selectProperty(Supplier.UPDATE_TIME_PROPERTY);
       return this;
    }

    /**
     * fill the updateTime with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  updateTime) to fetch updateTime property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public SupplierRequest<T> unselectUpdateTime(){
       unselectProperty(Supplier.UPDATE_TIME_PROPERTY);
       return this;
    }
    public SupplierRequest<T> selectVersion(){
       selectProperty(Supplier.VERSION_PROPERTY);
       return this;
    }

    /**
     * fill the version with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  version) to fetch version property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public SupplierRequest<T> unselectVersion(){
       unselectProperty(Supplier.VERSION_PROPERTY);
       return this;
    }
    public SupplierRequest<T> selectPurchaseOrderList(){
       return selectPurchaseOrderListWith(Q.purchaseOrders().selectSelf());
    }

    public SupplierRequest<T> selectPurchaseOrderListWith(PurchaseOrderRequest purchaseOrderList){
       enhanceRelation(Supplier.PURCHASE_ORDER_LIST_PROPERTY, purchaseOrderList);
       return this;
    }

    public SupplierRequest<T> withId(Operator operator, Object... values){
       return appendSearchCriteria(createIdCriteria(operator, values));
    }

    public SearchCriteria createIdCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Supplier.ID_PROPERTY, operator, values);
    }

    public SupplierRequest<T> withIdIs(Long id){
       return withId(Operator.EQUAL, id);
    }
    public SupplierRequest<T> withIdIn(Long... id){
       return withId(Operator.EQUAL, (Object[])id);
    }



    public SupplierRequest<T> filterByAddress(String... address){
      if (address == null || address.length == 0) {
        throw new IllegalArgumentException("filterByAddress parameter address cannot be empty");
      }
      return appendSearchCriteria(createAddressCriteria(Operator.EQUAL, (Object[])address));
    }

    public SupplierRequest<T> withAddress(Operator operator, Object... values){
       return appendSearchCriteria(createAddressCriteria(operator, values));
    }

    public SupplierRequest<T> withAddressIsUnknown(){
       return withAddress(Operator.IS_NULL);
    }

    public SupplierRequest<T> withAddressIsKnown(){
       return withAddress(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createAddressCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Supplier.ADDRESS_PROPERTY, operator, values);
    }

    public SupplierRequest<T> withAddressGreaterThan(String address){
       return withAddress(Operator.GREATER_THAN, address);
    }

    public SupplierRequest<T> withAddressGreaterThanOrEqualTo(String address){
       return withAddress(Operator.GREATER_THAN_OR_EQUAL, address);
    }

    public SupplierRequest<T> withAddressLessThan(String address){
       return withAddress(Operator.LESS_THAN, address);
    }

    public SupplierRequest<T> withAddressLessThanOrEqualTo(String address){
       return withAddress(Operator.LESS_THAN_OR_EQUAL, address);
    }

    public SupplierRequest<T> withAddressBetween(String startOfAddress, String endOfAddress){
       return withAddress(Operator.BETWEEN, startOfAddress, endOfAddress);
    }
    public SupplierRequest<T> withAddressStartingWith(String address){
       return withAddress(Operator.BEGIN_WITH, address);
    }
    public SupplierRequest<T> withAddressContaining(String address){
       return withAddress(Operator.CONTAIN, address);
    }

    public SupplierRequest<T> withAddressEndingWith(String address){
       return withAddress(Operator.END_WITH, address);
    }

    public SupplierRequest<T> withAddressIs(String address){
       return withAddress(Operator.EQUAL, address);
    }

    public SupplierRequest<T> withAddressSoundingLike(String address){
       return withAddress(Operator.SOUNDS_LIKE, address);
    }



    public SupplierRequest<T> filterByContactEmail(String... contactEmail){
      if (contactEmail == null || contactEmail.length == 0) {
        throw new IllegalArgumentException("filterByContactEmail parameter contactEmail cannot be empty");
      }
      return appendSearchCriteria(createContactEmailCriteria(Operator.EQUAL, (Object[])contactEmail));
    }

    public SupplierRequest<T> withContactEmail(Operator operator, Object... values){
       return appendSearchCriteria(createContactEmailCriteria(operator, values));
    }

    public SupplierRequest<T> withContactEmailIsUnknown(){
       return withContactEmail(Operator.IS_NULL);
    }

    public SupplierRequest<T> withContactEmailIsKnown(){
       return withContactEmail(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createContactEmailCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Supplier.CONTACT_EMAIL_PROPERTY, operator, values);
    }

    public SupplierRequest<T> withContactEmailGreaterThan(String contactEmail){
       return withContactEmail(Operator.GREATER_THAN, contactEmail);
    }

    public SupplierRequest<T> withContactEmailGreaterThanOrEqualTo(String contactEmail){
       return withContactEmail(Operator.GREATER_THAN_OR_EQUAL, contactEmail);
    }

    public SupplierRequest<T> withContactEmailLessThan(String contactEmail){
       return withContactEmail(Operator.LESS_THAN, contactEmail);
    }

    public SupplierRequest<T> withContactEmailLessThanOrEqualTo(String contactEmail){
       return withContactEmail(Operator.LESS_THAN_OR_EQUAL, contactEmail);
    }

    public SupplierRequest<T> withContactEmailBetween(String startOfContactEmail, String endOfContactEmail){
       return withContactEmail(Operator.BETWEEN, startOfContactEmail, endOfContactEmail);
    }
    public SupplierRequest<T> withContactEmailStartingWith(String contactEmail){
       return withContactEmail(Operator.BEGIN_WITH, contactEmail);
    }
    public SupplierRequest<T> withContactEmailContaining(String contactEmail){
       return withContactEmail(Operator.CONTAIN, contactEmail);
    }

    public SupplierRequest<T> withContactEmailEndingWith(String contactEmail){
       return withContactEmail(Operator.END_WITH, contactEmail);
    }

    public SupplierRequest<T> withContactEmailIs(String contactEmail){
       return withContactEmail(Operator.EQUAL, contactEmail);
    }

    public SupplierRequest<T> withContactEmailSoundingLike(String contactEmail){
       return withContactEmail(Operator.SOUNDS_LIKE, contactEmail);
    }



    public SupplierRequest<T> filterByName(String... name){
      if (name == null || name.length == 0) {
        throw new IllegalArgumentException("filterByName parameter name cannot be empty");
      }
      return appendSearchCriteria(createNameCriteria(Operator.EQUAL, (Object[])name));
    }

    public SupplierRequest<T> withName(Operator operator, Object... values){
       return appendSearchCriteria(createNameCriteria(operator, values));
    }

    public SupplierRequest<T> withNameIsUnknown(){
       return withName(Operator.IS_NULL);
    }

    public SupplierRequest<T> withNameIsKnown(){
       return withName(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createNameCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Supplier.NAME_PROPERTY, operator, values);
    }

    public SupplierRequest<T> withNameGreaterThan(String name){
       return withName(Operator.GREATER_THAN, name);
    }

    public SupplierRequest<T> withNameGreaterThanOrEqualTo(String name){
       return withName(Operator.GREATER_THAN_OR_EQUAL, name);
    }

    public SupplierRequest<T> withNameLessThan(String name){
       return withName(Operator.LESS_THAN, name);
    }

    public SupplierRequest<T> withNameLessThanOrEqualTo(String name){
       return withName(Operator.LESS_THAN_OR_EQUAL, name);
    }

    public SupplierRequest<T> withNameBetween(String startOfName, String endOfName){
       return withName(Operator.BETWEEN, startOfName, endOfName);
    }
    public SupplierRequest<T> withNameStartingWith(String name){
       return withName(Operator.BEGIN_WITH, name);
    }
    public SupplierRequest<T> withNameContaining(String name){
       return withName(Operator.CONTAIN, name);
    }

    public SupplierRequest<T> withNameEndingWith(String name){
       return withName(Operator.END_WITH, name);
    }

    public SupplierRequest<T> withNameIs(String name){
       return withName(Operator.EQUAL, name);
    }

    public SupplierRequest<T> withNameSoundingLike(String name){
       return withName(Operator.SOUNDS_LIKE, name);
    }



    public SupplierRequest<T> filterByPhone(String... phone){
      if (phone == null || phone.length == 0) {
        throw new IllegalArgumentException("filterByPhone parameter phone cannot be empty");
      }
      return appendSearchCriteria(createPhoneCriteria(Operator.EQUAL, (Object[])phone));
    }

    public SupplierRequest<T> withPhone(Operator operator, Object... values){
       return appendSearchCriteria(createPhoneCriteria(operator, values));
    }

    public SupplierRequest<T> withPhoneIsUnknown(){
       return withPhone(Operator.IS_NULL);
    }

    public SupplierRequest<T> withPhoneIsKnown(){
       return withPhone(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createPhoneCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Supplier.PHONE_PROPERTY, operator, values);
    }

    public SupplierRequest<T> withPhoneGreaterThan(String phone){
       return withPhone(Operator.GREATER_THAN, phone);
    }

    public SupplierRequest<T> withPhoneGreaterThanOrEqualTo(String phone){
       return withPhone(Operator.GREATER_THAN_OR_EQUAL, phone);
    }

    public SupplierRequest<T> withPhoneLessThan(String phone){
       return withPhone(Operator.LESS_THAN, phone);
    }

    public SupplierRequest<T> withPhoneLessThanOrEqualTo(String phone){
       return withPhone(Operator.LESS_THAN_OR_EQUAL, phone);
    }

    public SupplierRequest<T> withPhoneBetween(String startOfPhone, String endOfPhone){
       return withPhone(Operator.BETWEEN, startOfPhone, endOfPhone);
    }
    public SupplierRequest<T> withPhoneStartingWith(String phone){
       return withPhone(Operator.BEGIN_WITH, phone);
    }
    public SupplierRequest<T> withPhoneContaining(String phone){
       return withPhone(Operator.CONTAIN, phone);
    }

    public SupplierRequest<T> withPhoneEndingWith(String phone){
       return withPhone(Operator.END_WITH, phone);
    }

    public SupplierRequest<T> withPhoneIs(String phone){
       return withPhone(Operator.EQUAL, phone);
    }

    public SupplierRequest<T> withPhoneSoundingLike(String phone){
       return withPhone(Operator.SOUNDS_LIKE, phone);
    }



    public SupplierRequest<T> filterByRating(BigDecimal... rating){
      if (rating == null || rating.length == 0) {
        throw new IllegalArgumentException("filterByRating parameter rating cannot be empty");
      }
      return appendSearchCriteria(createRatingCriteria(Operator.EQUAL, (Object[])rating));
    }

    public SupplierRequest<T> withRating(Operator operator, Object... values){
       return appendSearchCriteria(createRatingCriteria(operator, values));
    }

    public SupplierRequest<T> withRatingIsUnknown(){
       return withRating(Operator.IS_NULL);
    }

    public SupplierRequest<T> withRatingIsKnown(){
       return withRating(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createRatingCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Supplier.RATING_PROPERTY, operator, values);
    }

    public SupplierRequest<T> withRatingGreaterThan(BigDecimal rating){
       return withRating(Operator.GREATER_THAN, rating);
    }

    public SupplierRequest<T> withRatingGreaterThanOrEqualTo(BigDecimal rating){
       return withRating(Operator.GREATER_THAN_OR_EQUAL, rating);
    }

    public SupplierRequest<T> withRatingLessThan(BigDecimal rating){
       return withRating(Operator.LESS_THAN, rating);
    }

    public SupplierRequest<T> withRatingLessThanOrEqualTo(BigDecimal rating){
       return withRating(Operator.LESS_THAN_OR_EQUAL, rating);
    }

    public SupplierRequest<T> withRatingBetween(BigDecimal startOfRating, BigDecimal endOfRating){
       return withRating(Operator.BETWEEN, startOfRating, endOfRating);
    }



    public SupplierRequest<T> filterByCreateTime(LocalDateTime... createTime){
      if (createTime == null || createTime.length == 0) {
        throw new IllegalArgumentException("filterByCreateTime parameter createTime cannot be empty");
      }
      return appendSearchCriteria(createCreateTimeCriteria(Operator.EQUAL, (Object[])createTime));
    }

    public SupplierRequest<T> withCreateTime(Operator operator, Object... values){
       return appendSearchCriteria(createCreateTimeCriteria(operator, values));
    }

    public SupplierRequest<T> withCreateTimeIsUnknown(){
       return withCreateTime(Operator.IS_NULL);
    }

    public SupplierRequest<T> withCreateTimeIsKnown(){
       return withCreateTime(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createCreateTimeCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Supplier.CREATE_TIME_PROPERTY, operator, values);
    }

    public SupplierRequest<T> withCreateTimeGreaterThan(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public SupplierRequest<T> withCreateTimeGreaterThanOrEqualTo(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN_OR_EQUAL, createTime);
    }

    public SupplierRequest<T> withCreateTimeLessThan(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public SupplierRequest<T> withCreateTimeLessThanOrEqualTo(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN_OR_EQUAL, createTime);
    }

    public SupplierRequest<T> withCreateTimeBetween(LocalDateTime startOfCreateTime, LocalDateTime endOfCreateTime){
       return withCreateTime(Operator.BETWEEN, startOfCreateTime, endOfCreateTime);
    }
    public SupplierRequest<T> withCreateTimeBefore(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public SupplierRequest<T> withCreateTimeBefore(Date createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public SupplierRequest<T> withCreateTimeAfter(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public SupplierRequest<T> withCreateTimeAfter(Date createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public SupplierRequest<T> withCreateTimeBetween(Date startOfCreateTime, Date endOfCreateTime){
       return withCreateTime(Operator.BETWEEN, startOfCreateTime, endOfCreateTime);
    }




    public SupplierRequest<T> filterByUpdateTime(LocalDateTime... updateTime){
      if (updateTime == null || updateTime.length == 0) {
        throw new IllegalArgumentException("filterByUpdateTime parameter updateTime cannot be empty");
      }
      return appendSearchCriteria(createUpdateTimeCriteria(Operator.EQUAL, (Object[])updateTime));
    }

    public SupplierRequest<T> withUpdateTime(Operator operator, Object... values){
       return appendSearchCriteria(createUpdateTimeCriteria(operator, values));
    }

    public SupplierRequest<T> withUpdateTimeIsUnknown(){
       return withUpdateTime(Operator.IS_NULL);
    }

    public SupplierRequest<T> withUpdateTimeIsKnown(){
       return withUpdateTime(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createUpdateTimeCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Supplier.UPDATE_TIME_PROPERTY, operator, values);
    }

    public SupplierRequest<T> withUpdateTimeGreaterThan(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public SupplierRequest<T> withUpdateTimeGreaterThanOrEqualTo(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN_OR_EQUAL, updateTime);
    }

    public SupplierRequest<T> withUpdateTimeLessThan(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public SupplierRequest<T> withUpdateTimeLessThanOrEqualTo(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN_OR_EQUAL, updateTime);
    }

    public SupplierRequest<T> withUpdateTimeBetween(LocalDateTime startOfUpdateTime, LocalDateTime endOfUpdateTime){
       return withUpdateTime(Operator.BETWEEN, startOfUpdateTime, endOfUpdateTime);
    }
    public SupplierRequest<T> withUpdateTimeBefore(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public SupplierRequest<T> withUpdateTimeBefore(Date updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public SupplierRequest<T> withUpdateTimeAfter(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public SupplierRequest<T> withUpdateTimeAfter(Date updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public SupplierRequest<T> withUpdateTimeBetween(Date startOfUpdateTime, Date endOfUpdateTime){
       return withUpdateTime(Operator.BETWEEN, startOfUpdateTime, endOfUpdateTime);
    }




    public SupplierRequest<T> filterByVersion(Long... version){
      if (version == null || version.length == 0) {
        throw new IllegalArgumentException("filterByVersion parameter version cannot be empty");
      }
      return appendSearchCriteria(createVersionCriteria(Operator.EQUAL, (Object[])version));
    }

    public SupplierRequest<T> withVersion(Operator operator, Object... values){
       return appendSearchCriteria(createVersionCriteria(operator, values));
    }

    public SupplierRequest<T> withVersionIsUnknown(){
       return withVersion(Operator.IS_NULL);
    }

    public SupplierRequest<T> withVersionIsKnown(){
       return withVersion(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createVersionCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Supplier.VERSION_PROPERTY, operator, values);
    }

    public SupplierRequest<T> withVersionGreaterThan(Long version){
       return withVersion(Operator.GREATER_THAN, version);
    }

    public SupplierRequest<T> withVersionGreaterThanOrEqualTo(Long version){
       return withVersion(Operator.GREATER_THAN_OR_EQUAL, version);
    }

    public SupplierRequest<T> withVersionLessThan(Long version){
       return withVersion(Operator.LESS_THAN, version);
    }

    public SupplierRequest<T> withVersionLessThanOrEqualTo(Long version){
       return withVersion(Operator.LESS_THAN_OR_EQUAL, version);
    }

    public SupplierRequest<T> withVersionBetween(Long startOfVersion, Long endOfVersion){
       return withVersion(Operator.BETWEEN, startOfVersion, endOfVersion);
    }

    public SupplierRequest<T> withPurchaseOrderListMatching(PurchaseOrderRequest purchaseOrderRequest){
        return appendSearchCriteria(new SubQuerySearchCriteria(Supplier.ID_PROPERTY, purchaseOrderRequest, PurchaseOrder.SUPPLIER_PROPERTY));
    }

    public SupplierRequest<T> withoutPurchaseOrderListMatching(PurchaseOrderRequest purchaseOrderRequest){
        return appendSearchCriteria(SearchCriteria.not(new SubQuerySearchCriteria(Supplier.ID_PROPERTY, purchaseOrderRequest, PurchaseOrder.SUPPLIER_PROPERTY)));
    }

    public SupplierRequest<T> havePurchaseOrders(){
        return withPurchaseOrderListMatching(Q.purchaseOrders().unlimited());
    }

    public SupplierRequest<T> haveNoPurchaseOrders(){
        return withoutPurchaseOrderListMatching(Q.purchaseOrders().unlimited());
    }

    public SupplierRequest<T> count(){
        super.count();
        return this;
    }
    public SupplierRequest<T> countAs(String retName){
        super.count(retName);
        return this;
    }
    public SupplierRequest minRating(){
        return minRatingAs(prefix("minOf",Supplier.RATING_PROPERTY));
    }

    public SupplierRequest minRatingAs(String retName){
        super.min(retName, Supplier.RATING_PROPERTY);
        return this;
    }
    public SupplierRequest maxRating(){
        return maxRatingAs(prefix("maxOf",Supplier.RATING_PROPERTY));
    }

    public SupplierRequest maxRatingAs(String retName){
        super.max(retName, Supplier.RATING_PROPERTY);
        return this;
    }
    public SupplierRequest sumRating(){
        return sumRatingAs(prefix("sumOf",Supplier.RATING_PROPERTY));
    }

    public SupplierRequest sumRatingAs(String retName){
        super.sum(retName, Supplier.RATING_PROPERTY);
        return this;
    }
    public SupplierRequest avgRating(){
        return avgRatingAs(prefix("avgOf",Supplier.RATING_PROPERTY));
    }

    public SupplierRequest avgRatingAs(String retName){
        super.avg(retName, Supplier.RATING_PROPERTY);
        return this;
    }
    public SupplierRequest standardDeviationRating(){
        return standardDeviationRatingAs(prefix("standardDeviationOf",Supplier.RATING_PROPERTY));
    }

    public SupplierRequest standardDeviationRatingAs(String retName){
        super.standardDeviation(retName, Supplier.RATING_PROPERTY);
        return this;
    }
    public SupplierRequest squareRootOfPopulationStandardDeviationRating(){
        return squareRootOfPopulationStandardDeviationRatingAs(prefix("squareRootOfPopulationStandardDeviationOf",Supplier.RATING_PROPERTY));
    }

    public SupplierRequest squareRootOfPopulationStandardDeviationRatingAs(String retName){
        super.squareRootOfPopulationStandardDeviation(retName, Supplier.RATING_PROPERTY);
        return this;
    }
    public SupplierRequest sampleVarianceRating(){
        return sampleVarianceRatingAs(prefix("sampleVarianceOf",Supplier.RATING_PROPERTY));
    }

    public SupplierRequest sampleVarianceRatingAs(String retName){
        super.sampleVariance(retName, Supplier.RATING_PROPERTY);
        return this;
    }
    public SupplierRequest samplePopulationVarianceRating(){
        return samplePopulationVarianceRatingAs(prefix("samplePopulationVarianceOf",Supplier.RATING_PROPERTY));
    }

    public SupplierRequest samplePopulationVarianceRatingAs(String retName){
        super.samplePopulationVariance(retName, Supplier.RATING_PROPERTY);
        return this;
    }
    public SupplierRequest<T> groupByPurchaseOrdersWithDetails(PurchaseOrderRequest subRequest){
       aggregate(Supplier.PURCHASE_ORDER_LIST_PROPERTY, subRequest);
       return this;
    }

    public SupplierRequest<T> groupById(){
       groupBy(Supplier.ID_PROPERTY);
       return this;
    }

    public SupplierRequest<T> groupByIdAs(String retName){
       groupBy(retName, Supplier.ID_PROPERTY);
       return this;
    }

    public SupplierRequest<T> groupByIdWithFunction(String retName, AggrFunction function){
       groupBy(retName, Supplier.ID_PROPERTY, function);
       return this;
    }

    public SupplierRequest<T> groupByAddress(){
       groupBy(Supplier.ADDRESS_PROPERTY);
       return this;
    }

    public SupplierRequest<T> groupByAddressAs(String retName){
       groupBy(retName, Supplier.ADDRESS_PROPERTY);
       return this;
    }

    public SupplierRequest<T> groupByAddressWithFunction(String retName, AggrFunction function){
       groupBy(retName, Supplier.ADDRESS_PROPERTY, function);
       return this;
    }

    public SupplierRequest<T> groupByContactEmail(){
       groupBy(Supplier.CONTACT_EMAIL_PROPERTY);
       return this;
    }

    public SupplierRequest<T> groupByContactEmailAs(String retName){
       groupBy(retName, Supplier.CONTACT_EMAIL_PROPERTY);
       return this;
    }

    public SupplierRequest<T> groupByContactEmailWithFunction(String retName, AggrFunction function){
       groupBy(retName, Supplier.CONTACT_EMAIL_PROPERTY, function);
       return this;
    }

    public SupplierRequest<T> groupByName(){
       groupBy(Supplier.NAME_PROPERTY);
       return this;
    }

    public SupplierRequest<T> groupByNameAs(String retName){
       groupBy(retName, Supplier.NAME_PROPERTY);
       return this;
    }

    public SupplierRequest<T> groupByNameWithFunction(String retName, AggrFunction function){
       groupBy(retName, Supplier.NAME_PROPERTY, function);
       return this;
    }

    public SupplierRequest<T> groupByPhone(){
       groupBy(Supplier.PHONE_PROPERTY);
       return this;
    }

    public SupplierRequest<T> groupByPhoneAs(String retName){
       groupBy(retName, Supplier.PHONE_PROPERTY);
       return this;
    }

    public SupplierRequest<T> groupByPhoneWithFunction(String retName, AggrFunction function){
       groupBy(retName, Supplier.PHONE_PROPERTY, function);
       return this;
    }

    public SupplierRequest<T> groupByRating(){
       groupBy(Supplier.RATING_PROPERTY);
       return this;
    }

    public SupplierRequest<T> groupByRatingAs(String retName){
       groupBy(retName, Supplier.RATING_PROPERTY);
       return this;
    }

    public SupplierRequest<T> groupByRatingWithFunction(String retName, AggrFunction function){
       groupBy(retName, Supplier.RATING_PROPERTY, function);
       return this;
    }

    public SupplierRequest<T> groupByCreateTime(){
       groupBy(Supplier.CREATE_TIME_PROPERTY);
       return this;
    }

    public SupplierRequest<T> groupByCreateTimeAs(String retName){
       groupBy(retName, Supplier.CREATE_TIME_PROPERTY);
       return this;
    }

    public SupplierRequest<T> groupByCreateTimeWithFunction(String retName, AggrFunction function){
       groupBy(retName, Supplier.CREATE_TIME_PROPERTY, function);
       return this;
    }

    public SupplierRequest<T> groupByUpdateTime(){
       groupBy(Supplier.UPDATE_TIME_PROPERTY);
       return this;
    }

    public SupplierRequest<T> groupByUpdateTimeAs(String retName){
       groupBy(retName, Supplier.UPDATE_TIME_PROPERTY);
       return this;
    }

    public SupplierRequest<T> groupByUpdateTimeWithFunction(String retName, AggrFunction function){
       groupBy(retName, Supplier.UPDATE_TIME_PROPERTY, function);
       return this;
    }

    public SupplierRequest<T> groupByVersion(){
       groupBy(Supplier.VERSION_PROPERTY);
       return this;
    }

    public SupplierRequest<T> groupByVersionAs(String retName){
       groupBy(retName, Supplier.VERSION_PROPERTY);
       return this;
    }

    public SupplierRequest<T> groupByVersionWithFunction(String retName, AggrFunction function){
       groupBy(retName, Supplier.VERSION_PROPERTY, function);
       return this;
    }



    public SupplierRequest<T> orderByIdAscending(){
       addOrderByAscending(Supplier.ID_PROPERTY);
       return this;
    }

    public SupplierRequest<T> orderByIdDescending(){
       addOrderByDescending(Supplier.ID_PROPERTY);
       return this;
    }

    public SupplierRequest<T> orderByAddressAscending(){
       addOrderByAscending(Supplier.ADDRESS_PROPERTY);
       return this;
    }

    public SupplierRequest<T> orderByAddressDescending(){
       addOrderByDescending(Supplier.ADDRESS_PROPERTY);
       return this;
    }
    public SupplierRequest<T> orderByAddressAscendingUsingGBK(){
       addOrderByAscendingUsingGBK(Supplier.ADDRESS_PROPERTY);
       return this;
    }

    public SupplierRequest<T> orderByAddressDescendingUsingGBK(){
       addOrderByDescendingUsingGBK(Supplier.ADDRESS_PROPERTY);
       return this;
    }
    public SupplierRequest<T> orderByContactEmailAscending(){
       addOrderByAscending(Supplier.CONTACT_EMAIL_PROPERTY);
       return this;
    }

    public SupplierRequest<T> orderByContactEmailDescending(){
       addOrderByDescending(Supplier.CONTACT_EMAIL_PROPERTY);
       return this;
    }
    public SupplierRequest<T> orderByContactEmailAscendingUsingGBK(){
       addOrderByAscendingUsingGBK(Supplier.CONTACT_EMAIL_PROPERTY);
       return this;
    }

    public SupplierRequest<T> orderByContactEmailDescendingUsingGBK(){
       addOrderByDescendingUsingGBK(Supplier.CONTACT_EMAIL_PROPERTY);
       return this;
    }
    public SupplierRequest<T> orderByNameAscending(){
       addOrderByAscending(Supplier.NAME_PROPERTY);
       return this;
    }

    public SupplierRequest<T> orderByNameDescending(){
       addOrderByDescending(Supplier.NAME_PROPERTY);
       return this;
    }
    public SupplierRequest<T> orderByNameAscendingUsingGBK(){
       addOrderByAscendingUsingGBK(Supplier.NAME_PROPERTY);
       return this;
    }

    public SupplierRequest<T> orderByNameDescendingUsingGBK(){
       addOrderByDescendingUsingGBK(Supplier.NAME_PROPERTY);
       return this;
    }
    public SupplierRequest<T> orderByPhoneAscending(){
       addOrderByAscending(Supplier.PHONE_PROPERTY);
       return this;
    }

    public SupplierRequest<T> orderByPhoneDescending(){
       addOrderByDescending(Supplier.PHONE_PROPERTY);
       return this;
    }
    public SupplierRequest<T> orderByPhoneAscendingUsingGBK(){
       addOrderByAscendingUsingGBK(Supplier.PHONE_PROPERTY);
       return this;
    }

    public SupplierRequest<T> orderByPhoneDescendingUsingGBK(){
       addOrderByDescendingUsingGBK(Supplier.PHONE_PROPERTY);
       return this;
    }
    public SupplierRequest<T> orderByRatingAscending(){
       addOrderByAscending(Supplier.RATING_PROPERTY);
       return this;
    }

    public SupplierRequest<T> orderByRatingDescending(){
       addOrderByDescending(Supplier.RATING_PROPERTY);
       return this;
    }

    public SupplierRequest<T> orderByCreateTimeAscending(){
       addOrderByAscending(Supplier.CREATE_TIME_PROPERTY);
       return this;
    }

    public SupplierRequest<T> orderByCreateTimeDescending(){
       addOrderByDescending(Supplier.CREATE_TIME_PROPERTY);
       return this;
    }

    public SupplierRequest<T> orderByUpdateTimeAscending(){
       addOrderByAscending(Supplier.UPDATE_TIME_PROPERTY);
       return this;
    }

    public SupplierRequest<T> orderByUpdateTimeDescending(){
       addOrderByDescending(Supplier.UPDATE_TIME_PROPERTY);
       return this;
    }

    public SupplierRequest<T> orderByVersionAscending(){
       addOrderByAscending(Supplier.VERSION_PROPERTY);
       return this;
    }

    public SupplierRequest<T> orderByVersionDescending(){
       addOrderByDescending(Supplier.VERSION_PROPERTY);
       return this;
    }


    public SupplierRequest<T> statsFromPurchaseOrdersAs(String name, PurchaseOrderRequest subRequest){
       return statsFromPurchaseOrdersAs(name, subRequest, false);
    }

    public SupplierRequest<T> statsFromPurchaseOrdersAs(String name, PurchaseOrderRequest subRequest, boolean singleResult){
       subRequest.setPartitionProperty(PurchaseOrder.SUPPLIER_PROPERTY);
       addAggregateDynamicProperty(name, subRequest, singleResult);
       return this;
    }

    public SupplierRequest<T> statsFromPurchaseOrders(PurchaseOrderRequest subRequest){
       return statsFromPurchaseOrdersAs(REFINEMENTS, subRequest);
    }
    public SupplierRequest<T> countPurchaseOrders(){
        return countPurchaseOrdersAs("Count");
    }

    public SupplierRequest<T> countPurchaseOrdersAs(String name){
        return countPurchaseOrdersWith(name, Q.purchaseOrders().unlimited());
    }

    public SupplierRequest<T> countPurchaseOrdersWith(String name, PurchaseOrderRequest subRequest){
        return statsFromPurchaseOrdersAs(name, subRequest.count(), true);
    }
    public SupplierRequest<T> minTotalCostOfPurchaseOrders(){
        return minTotalCostOfPurchaseOrdersAs("minTotalCostOfPurchaseOrders");
    }

    public SupplierRequest<T> minTotalCostOfPurchaseOrdersAs(String name){
        return minTotalCostOfPurchaseOrdersAs(name, Q.purchaseOrders().unlimited());
    }

    public SupplierRequest<T> minTotalCostOfPurchaseOrdersAs(String name, PurchaseOrderRequest subRequest){
        return statsFromPurchaseOrdersAs(name, subRequest.minTotalCost(), true);
    }
    public SupplierRequest<T> maxTotalCostOfPurchaseOrders(){
        return maxTotalCostOfPurchaseOrdersAs("maxTotalCostOfPurchaseOrders");
    }

    public SupplierRequest<T> maxTotalCostOfPurchaseOrdersAs(String name){
        return maxTotalCostOfPurchaseOrdersAs(name, Q.purchaseOrders().unlimited());
    }

    public SupplierRequest<T> maxTotalCostOfPurchaseOrdersAs(String name, PurchaseOrderRequest subRequest){
        return statsFromPurchaseOrdersAs(name, subRequest.maxTotalCost(), true);
    }
    public SupplierRequest<T> sumTotalCostOfPurchaseOrders(){
        return sumTotalCostOfPurchaseOrdersAs("sumTotalCostOfPurchaseOrders");
    }

    public SupplierRequest<T> sumTotalCostOfPurchaseOrdersAs(String name){
        return sumTotalCostOfPurchaseOrdersAs(name, Q.purchaseOrders().unlimited());
    }

    public SupplierRequest<T> sumTotalCostOfPurchaseOrdersAs(String name, PurchaseOrderRequest subRequest){
        return statsFromPurchaseOrdersAs(name, subRequest.sumTotalCost(), true);
    }
    public SupplierRequest<T> avgTotalCostOfPurchaseOrders(){
        return avgTotalCostOfPurchaseOrdersAs("avgTotalCostOfPurchaseOrders");
    }

    public SupplierRequest<T> avgTotalCostOfPurchaseOrdersAs(String name){
        return avgTotalCostOfPurchaseOrdersAs(name, Q.purchaseOrders().unlimited());
    }

    public SupplierRequest<T> avgTotalCostOfPurchaseOrdersAs(String name, PurchaseOrderRequest subRequest){
        return statsFromPurchaseOrdersAs(name, subRequest.avgTotalCost(), true);
    }
    public SupplierRequest<T> standardDeviationTotalCostOfPurchaseOrders(){
        return standardDeviationTotalCostOfPurchaseOrdersAs("stdDevTotalCostOfPurchaseOrders");
    }

    public SupplierRequest<T> standardDeviationTotalCostOfPurchaseOrdersAs(String name){
        return standardDeviationTotalCostOfPurchaseOrdersAs(name, Q.purchaseOrders().unlimited());
    }

    public SupplierRequest<T> standardDeviationTotalCostOfPurchaseOrdersAs(String name, PurchaseOrderRequest subRequest){
        return statsFromPurchaseOrdersAs(name, subRequest.standardDeviationTotalCost(), true);
    }
    public SupplierRequest<T> squareRootOfPopulationStandardDeviationTotalCostOfPurchaseOrders(){
        return squareRootOfPopulationStandardDeviationTotalCostOfPurchaseOrdersAs("stdDevPopTotalCostOfPurchaseOrders");
    }

    public SupplierRequest<T> squareRootOfPopulationStandardDeviationTotalCostOfPurchaseOrdersAs(String name){
        return squareRootOfPopulationStandardDeviationTotalCostOfPurchaseOrdersAs(name, Q.purchaseOrders().unlimited());
    }

    public SupplierRequest<T> squareRootOfPopulationStandardDeviationTotalCostOfPurchaseOrdersAs(String name, PurchaseOrderRequest subRequest){
        return statsFromPurchaseOrdersAs(name, subRequest.squareRootOfPopulationStandardDeviationTotalCost(), true);
    }
    public SupplierRequest<T> sampleVarianceTotalCostOfPurchaseOrders(){
        return sampleVarianceTotalCostOfPurchaseOrdersAs("varSampTotalCostOfPurchaseOrders");
    }

    public SupplierRequest<T> sampleVarianceTotalCostOfPurchaseOrdersAs(String name){
        return sampleVarianceTotalCostOfPurchaseOrdersAs(name, Q.purchaseOrders().unlimited());
    }

    public SupplierRequest<T> sampleVarianceTotalCostOfPurchaseOrdersAs(String name, PurchaseOrderRequest subRequest){
        return statsFromPurchaseOrdersAs(name, subRequest.sampleVarianceTotalCost(), true);
    }
    public SupplierRequest<T> samplePopulationVarianceTotalCostOfPurchaseOrders(){
        return samplePopulationVarianceTotalCostOfPurchaseOrdersAs("varPopTotalCostOfPurchaseOrders");
    }

    public SupplierRequest<T> samplePopulationVarianceTotalCostOfPurchaseOrdersAs(String name){
        return samplePopulationVarianceTotalCostOfPurchaseOrdersAs(name, Q.purchaseOrders().unlimited());
    }

    public SupplierRequest<T> samplePopulationVarianceTotalCostOfPurchaseOrdersAs(String name, PurchaseOrderRequest subRequest){
        return statsFromPurchaseOrdersAs(name, subRequest.samplePopulationVarianceTotalCost(), true);
    }



    /**
     * get topN records
     * @param topN  records number
     */
    public SupplierRequest<T> top(int topN) {
        super.top(topN);
        return this;
    }

    /**
     * get records from offset(inclusive) to offset+size(exclusive)
     * @param offset record offset
     * @param size records number
     */
    public SupplierRequest<T> offset(int offset, int size) {
        super.offset(offset, size);
        return this;
    }

    /**
     * retrieve all records
     */
    public SupplierRequest<T> unlimited() {
        super.unlimited();
        return this;
    }

    /**
     * get records of one page
     * @param pageNumber page number(1-based)
     * @param pageSize page size
     */
    public SupplierRequest<T> page(int pageNumber, int pageSize) {
        int offset = (pageNumber - 1) * pageSize;
        return offset(offset, pageSize);
   }

    /**
     * get records of one page, default page size is 10
     * @param pageNumber page number(1-based)
     */
    public SupplierRequest<T> page(int pageNumber) {
        return page(pageNumber, 10);
   }
}