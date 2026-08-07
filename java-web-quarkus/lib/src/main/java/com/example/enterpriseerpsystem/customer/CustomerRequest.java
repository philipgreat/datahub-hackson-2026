
package com.example.enterpriseerpsystem.customer;

import com.example.enterpriseerpsystem.Q;
import com.example.enterpriseerpsystem.contact.Contact;
import com.example.enterpriseerpsystem.contact.ContactRequest;
import com.example.enterpriseerpsystem.contract.Contract;
import com.example.enterpriseerpsystem.contract.ContractRequest;
import com.example.enterpriseerpsystem.globalorder.GlobalOrder;
import com.example.enterpriseerpsystem.globalorder.GlobalOrderRequest;
import com.example.enterpriseerpsystem.invoice.Invoice;
import com.example.enterpriseerpsystem.invoice.InvoiceRequest;
import com.example.enterpriseerpsystem.productreview.ProductReview;
import com.example.enterpriseerpsystem.productreview.ProductReviewRequest;
import com.example.enterpriseerpsystem.returnrequest.ReturnRequest;
import com.example.enterpriseerpsystem.returnrequest.ReturnRequestRequest;
import com.example.enterpriseerpsystem.shoppingcart.ShoppingCart;
import com.example.enterpriseerpsystem.shoppingcart.ShoppingCartRequest;
import com.example.enterpriseerpsystem.ticket.Ticket;
import com.example.enterpriseerpsystem.ticket.TicketRequest;
import com.example.enterpriseerpsystem.wishlist.Wishlist;
import com.example.enterpriseerpsystem.wishlist.WishlistRequest;
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

public class CustomerRequest<T extends Customer> extends BaseRequest<T> {

    /**
     * @deprecated AI agents and business code must use the generated Q facade
     *             instead of constructing request builders directly.
     */
    @Deprecated
    public CustomerRequest(Class<T> returnType){
        super(returnType);
        selectId();
        selectVersion();
    }

    public CustomerRequest<T> comment(String comment){
         super.internalComment(comment);
         return this;
    }

    // purpose() 继承自 BaseRequest，返回 ExecutableRequest（终结方法）

    public CustomerRequest<T> returnType(Class<? extends T> returnType){
        super.setReturnType(returnType);
        return this;
    }

    public CustomerRequest<T> enableAggregationCache(long cacheExpiredMillis){
        super.enableAggregationCache();
        super.aggregateCacheTime(cacheExpiredMillis);
        return this;
    }

    public CustomerRequest<T> enableAggregationCache(){
        return enableAggregationCache(0l);
    }


    public CustomerRequest<T> propagateAggregationCache(long cacheExpiredMillis){
        super.propagateAggregationCache(cacheExpiredMillis);
        return this;
    }

    public CustomerRequest<T> appendSearchCriteria(SearchCriteria searchCriteria){
        return (CustomerRequest<T>)super.appendSearchCriteria(searchCriteria);
    }

    public CustomerRequest<T> filter(String property1, Operator operator, String property2){
        return appendSearchCriteria(new TwoOperatorCriteria(operator, new PropertyReference(property1), new PropertyReference(property2)));
    }


    public CustomerRequest<T> matchingAnyOf(CustomerRequest customer){
        super.internalMatchAny(customer);
        return this;
    }

    public CustomerRequest<T> enhanceChildrenIfNeeded(){
        return this;
    }

    public CustomerRequest<T> withDeletedRows(){
        super.withDeletedRows();
        return this;
    }

    public CustomerRequest<T> deletedRowsOnly(){
        super.deletedRowsOnly();
        return this;
    }

    public CustomerRequest<T> selectSelf(){
        super.selectSelf();
        return selectId().selectAddress().selectEmail().selectName().selectPhone().selectCreatedAt().selectLoyaltyPoints().selectCreateTime().selectUpdateTime().selectVersion();
    }

    public CustomerRequest<T> selectSelfFields(){
        return selectSelf();
    }

    public CustomerRequest<T> selectAll(){
        super.selectAll();
        return selectId().selectAddress().selectEmail().selectName().selectPhone().selectCreatedAt().selectLoyaltyPoints().selectCreateTime().selectUpdateTime().selectVersion();
    }

    public CustomerRequest<T> selectChildren(){
        super.selectAny();
        selectContactList().selectContractList().selectProductReviewList().selectShoppingCartList().selectGlobalOrderList().selectWishlistList().selectInvoiceList().selectReturnRequestList().selectTicketList();
        return selectId().selectAddress().selectEmail().selectName().selectPhone().selectCreatedAt().selectLoyaltyPoints().selectCreateTime().selectUpdateTime().selectVersion();
    }


    public CustomerRequest<T> selectId(){
       selectProperty(Customer.ID_PROPERTY);
       return this;
    }

    /**
     * fill the id with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  id) to fetch id property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public CustomerRequest<T> unselectId(){
       unselectProperty(Customer.ID_PROPERTY);
       return this;
    }
    public CustomerRequest<T> selectAddress(){
       selectProperty(Customer.ADDRESS_PROPERTY);
       return this;
    }

    /**
     * fill the address with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  address) to fetch address property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public CustomerRequest<T> unselectAddress(){
       unselectProperty(Customer.ADDRESS_PROPERTY);
       return this;
    }
    public CustomerRequest<T> selectEmail(){
       selectProperty(Customer.EMAIL_PROPERTY);
       return this;
    }

    /**
     * fill the email with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  email) to fetch email property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public CustomerRequest<T> unselectEmail(){
       unselectProperty(Customer.EMAIL_PROPERTY);
       return this;
    }
    public CustomerRequest<T> selectName(){
       selectProperty(Customer.NAME_PROPERTY);
       return this;
    }

    /**
     * fill the name with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  name) to fetch name property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public CustomerRequest<T> unselectName(){
       unselectProperty(Customer.NAME_PROPERTY);
       return this;
    }
    public CustomerRequest<T> selectPhone(){
       selectProperty(Customer.PHONE_PROPERTY);
       return this;
    }

    /**
     * fill the phone with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  phone) to fetch phone property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public CustomerRequest<T> unselectPhone(){
       unselectProperty(Customer.PHONE_PROPERTY);
       return this;
    }
    public CustomerRequest<T> selectCreatedAt(){
       selectProperty(Customer.CREATED_AT_PROPERTY);
       return this;
    }

    /**
     * fill the createdAt with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  createdAt) to fetch createdAt property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public CustomerRequest<T> unselectCreatedAt(){
       unselectProperty(Customer.CREATED_AT_PROPERTY);
       return this;
    }
    public CustomerRequest<T> selectLoyaltyPoints(){
       selectProperty(Customer.LOYALTY_POINTS_PROPERTY);
       return this;
    }

    /**
     * fill the loyaltyPoints with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  loyaltyPoints) to fetch loyaltyPoints property.
     * @param rawSqlSegment  customized rawSqlSegment
     */


    /**
     * fill the loyaltyPoints with customized aggrFunction, TEAQL uses ({aggrFunction}(loyaltyPoints) AS loyaltyPoints to fetch loyaltyPoints property.
     * @param aggrFunction  aggrFunction
     */
    public CustomerRequest<T> selectLoyaltyPoints(AggrFunction aggrFunction){
       selectProperty(Customer.LOYALTY_POINTS_PROPERTY, aggrFunction);
       return this;
    }


    public CustomerRequest<T> unselectLoyaltyPoints(){
       unselectProperty(Customer.LOYALTY_POINTS_PROPERTY);
       return this;
    }
    public CustomerRequest<T> selectCreateTime(){
       selectProperty(Customer.CREATE_TIME_PROPERTY);
       return this;
    }

    /**
     * fill the createTime with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  createTime) to fetch createTime property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public CustomerRequest<T> unselectCreateTime(){
       unselectProperty(Customer.CREATE_TIME_PROPERTY);
       return this;
    }
    public CustomerRequest<T> selectUpdateTime(){
       selectProperty(Customer.UPDATE_TIME_PROPERTY);
       return this;
    }

    /**
     * fill the updateTime with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  updateTime) to fetch updateTime property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public CustomerRequest<T> unselectUpdateTime(){
       unselectProperty(Customer.UPDATE_TIME_PROPERTY);
       return this;
    }
    public CustomerRequest<T> selectVersion(){
       selectProperty(Customer.VERSION_PROPERTY);
       return this;
    }

    /**
     * fill the version with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  version) to fetch version property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public CustomerRequest<T> unselectVersion(){
       unselectProperty(Customer.VERSION_PROPERTY);
       return this;
    }
    public CustomerRequest<T> selectContactList(){
       return selectContactListWith(Q.contacts().selectSelf());
    }

    public CustomerRequest<T> selectContactListWith(ContactRequest contactList){
       enhanceRelation(Customer.CONTACT_LIST_PROPERTY, contactList);
       return this;
    }
    public CustomerRequest<T> selectContractList(){
       return selectContractListWith(Q.contracts().selectSelf());
    }

    public CustomerRequest<T> selectContractListWith(ContractRequest contractList){
       enhanceRelation(Customer.CONTRACT_LIST_PROPERTY, contractList);
       return this;
    }
    public CustomerRequest<T> selectProductReviewList(){
       return selectProductReviewListWith(Q.productReviews().selectSelf());
    }

    public CustomerRequest<T> selectProductReviewListWith(ProductReviewRequest productReviewList){
       enhanceRelation(Customer.PRODUCT_REVIEW_LIST_PROPERTY, productReviewList);
       return this;
    }
    public CustomerRequest<T> selectShoppingCartList(){
       return selectShoppingCartListWith(Q.shoppingCarts().selectSelf());
    }

    public CustomerRequest<T> selectShoppingCartListWith(ShoppingCartRequest shoppingCartList){
       enhanceRelation(Customer.SHOPPING_CART_LIST_PROPERTY, shoppingCartList);
       return this;
    }
    public CustomerRequest<T> selectGlobalOrderList(){
       return selectGlobalOrderListWith(Q.globalOrders().selectSelf());
    }

    public CustomerRequest<T> selectGlobalOrderListWith(GlobalOrderRequest globalOrderList){
       enhanceRelation(Customer.GLOBAL_ORDER_LIST_PROPERTY, globalOrderList);
       return this;
    }
    public CustomerRequest<T> selectWishlistList(){
       return selectWishlistListWith(Q.wishlists().selectSelf());
    }

    public CustomerRequest<T> selectWishlistListWith(WishlistRequest wishlistList){
       enhanceRelation(Customer.WISHLIST_LIST_PROPERTY, wishlistList);
       return this;
    }
    public CustomerRequest<T> selectInvoiceList(){
       return selectInvoiceListWith(Q.invoices().selectSelf());
    }

    public CustomerRequest<T> selectInvoiceListWith(InvoiceRequest invoiceList){
       enhanceRelation(Customer.INVOICE_LIST_PROPERTY, invoiceList);
       return this;
    }
    public CustomerRequest<T> selectReturnRequestList(){
       return selectReturnRequestListWith(Q.returnRequests().selectSelf());
    }

    public CustomerRequest<T> selectReturnRequestListWith(ReturnRequestRequest returnRequestList){
       enhanceRelation(Customer.RETURN_REQUEST_LIST_PROPERTY, returnRequestList);
       return this;
    }
    public CustomerRequest<T> selectTicketList(){
       return selectTicketListWith(Q.tickets().selectSelf());
    }

    public CustomerRequest<T> selectTicketListWith(TicketRequest ticketList){
       enhanceRelation(Customer.TICKET_LIST_PROPERTY, ticketList);
       return this;
    }

    public CustomerRequest<T> withId(Operator operator, Object... values){
       return appendSearchCriteria(createIdCriteria(operator, values));
    }

    public SearchCriteria createIdCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Customer.ID_PROPERTY, operator, values);
    }

    public CustomerRequest<T> withIdIs(Long id){
       return withId(Operator.EQUAL, id);
    }
    public CustomerRequest<T> withIdIn(Long... id){
       return withId(Operator.EQUAL, (Object[])id);
    }



    public CustomerRequest<T> filterByAddress(String... address){
      if (address == null || address.length == 0) {
        throw new IllegalArgumentException("filterByAddress parameter address cannot be empty");
      }
      return appendSearchCriteria(createAddressCriteria(Operator.EQUAL, (Object[])address));
    }

    public CustomerRequest<T> withAddress(Operator operator, Object... values){
       return appendSearchCriteria(createAddressCriteria(operator, values));
    }

    public CustomerRequest<T> withAddressIsUnknown(){
       return withAddress(Operator.IS_NULL);
    }

    public CustomerRequest<T> withAddressIsKnown(){
       return withAddress(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createAddressCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Customer.ADDRESS_PROPERTY, operator, values);
    }

    public CustomerRequest<T> withAddressGreaterThan(String address){
       return withAddress(Operator.GREATER_THAN, address);
    }

    public CustomerRequest<T> withAddressGreaterThanOrEqualTo(String address){
       return withAddress(Operator.GREATER_THAN_OR_EQUAL, address);
    }

    public CustomerRequest<T> withAddressLessThan(String address){
       return withAddress(Operator.LESS_THAN, address);
    }

    public CustomerRequest<T> withAddressLessThanOrEqualTo(String address){
       return withAddress(Operator.LESS_THAN_OR_EQUAL, address);
    }

    public CustomerRequest<T> withAddressBetween(String startOfAddress, String endOfAddress){
       return withAddress(Operator.BETWEEN, startOfAddress, endOfAddress);
    }
    public CustomerRequest<T> withAddressStartingWith(String address){
       return withAddress(Operator.BEGIN_WITH, address);
    }
    public CustomerRequest<T> withAddressContaining(String address){
       return withAddress(Operator.CONTAIN, address);
    }

    public CustomerRequest<T> withAddressEndingWith(String address){
       return withAddress(Operator.END_WITH, address);
    }

    public CustomerRequest<T> withAddressIs(String address){
       return withAddress(Operator.EQUAL, address);
    }

    public CustomerRequest<T> withAddressSoundingLike(String address){
       return withAddress(Operator.SOUNDS_LIKE, address);
    }



    public CustomerRequest<T> filterByEmail(String... email){
      if (email == null || email.length == 0) {
        throw new IllegalArgumentException("filterByEmail parameter email cannot be empty");
      }
      return appendSearchCriteria(createEmailCriteria(Operator.EQUAL, (Object[])email));
    }

    public CustomerRequest<T> withEmail(Operator operator, Object... values){
       return appendSearchCriteria(createEmailCriteria(operator, values));
    }

    public CustomerRequest<T> withEmailIsUnknown(){
       return withEmail(Operator.IS_NULL);
    }

    public CustomerRequest<T> withEmailIsKnown(){
       return withEmail(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createEmailCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Customer.EMAIL_PROPERTY, operator, values);
    }

    public CustomerRequest<T> withEmailGreaterThan(String email){
       return withEmail(Operator.GREATER_THAN, email);
    }

    public CustomerRequest<T> withEmailGreaterThanOrEqualTo(String email){
       return withEmail(Operator.GREATER_THAN_OR_EQUAL, email);
    }

    public CustomerRequest<T> withEmailLessThan(String email){
       return withEmail(Operator.LESS_THAN, email);
    }

    public CustomerRequest<T> withEmailLessThanOrEqualTo(String email){
       return withEmail(Operator.LESS_THAN_OR_EQUAL, email);
    }

    public CustomerRequest<T> withEmailBetween(String startOfEmail, String endOfEmail){
       return withEmail(Operator.BETWEEN, startOfEmail, endOfEmail);
    }
    public CustomerRequest<T> withEmailStartingWith(String email){
       return withEmail(Operator.BEGIN_WITH, email);
    }
    public CustomerRequest<T> withEmailContaining(String email){
       return withEmail(Operator.CONTAIN, email);
    }

    public CustomerRequest<T> withEmailEndingWith(String email){
       return withEmail(Operator.END_WITH, email);
    }

    public CustomerRequest<T> withEmailIs(String email){
       return withEmail(Operator.EQUAL, email);
    }

    public CustomerRequest<T> withEmailSoundingLike(String email){
       return withEmail(Operator.SOUNDS_LIKE, email);
    }



    public CustomerRequest<T> filterByName(String... name){
      if (name == null || name.length == 0) {
        throw new IllegalArgumentException("filterByName parameter name cannot be empty");
      }
      return appendSearchCriteria(createNameCriteria(Operator.EQUAL, (Object[])name));
    }

    public CustomerRequest<T> withName(Operator operator, Object... values){
       return appendSearchCriteria(createNameCriteria(operator, values));
    }

    public CustomerRequest<T> withNameIsUnknown(){
       return withName(Operator.IS_NULL);
    }

    public CustomerRequest<T> withNameIsKnown(){
       return withName(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createNameCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Customer.NAME_PROPERTY, operator, values);
    }

    public CustomerRequest<T> withNameGreaterThan(String name){
       return withName(Operator.GREATER_THAN, name);
    }

    public CustomerRequest<T> withNameGreaterThanOrEqualTo(String name){
       return withName(Operator.GREATER_THAN_OR_EQUAL, name);
    }

    public CustomerRequest<T> withNameLessThan(String name){
       return withName(Operator.LESS_THAN, name);
    }

    public CustomerRequest<T> withNameLessThanOrEqualTo(String name){
       return withName(Operator.LESS_THAN_OR_EQUAL, name);
    }

    public CustomerRequest<T> withNameBetween(String startOfName, String endOfName){
       return withName(Operator.BETWEEN, startOfName, endOfName);
    }
    public CustomerRequest<T> withNameStartingWith(String name){
       return withName(Operator.BEGIN_WITH, name);
    }
    public CustomerRequest<T> withNameContaining(String name){
       return withName(Operator.CONTAIN, name);
    }

    public CustomerRequest<T> withNameEndingWith(String name){
       return withName(Operator.END_WITH, name);
    }

    public CustomerRequest<T> withNameIs(String name){
       return withName(Operator.EQUAL, name);
    }

    public CustomerRequest<T> withNameSoundingLike(String name){
       return withName(Operator.SOUNDS_LIKE, name);
    }



    public CustomerRequest<T> filterByPhone(String... phone){
      if (phone == null || phone.length == 0) {
        throw new IllegalArgumentException("filterByPhone parameter phone cannot be empty");
      }
      return appendSearchCriteria(createPhoneCriteria(Operator.EQUAL, (Object[])phone));
    }

    public CustomerRequest<T> withPhone(Operator operator, Object... values){
       return appendSearchCriteria(createPhoneCriteria(operator, values));
    }

    public CustomerRequest<T> withPhoneIsUnknown(){
       return withPhone(Operator.IS_NULL);
    }

    public CustomerRequest<T> withPhoneIsKnown(){
       return withPhone(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createPhoneCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Customer.PHONE_PROPERTY, operator, values);
    }

    public CustomerRequest<T> withPhoneGreaterThan(String phone){
       return withPhone(Operator.GREATER_THAN, phone);
    }

    public CustomerRequest<T> withPhoneGreaterThanOrEqualTo(String phone){
       return withPhone(Operator.GREATER_THAN_OR_EQUAL, phone);
    }

    public CustomerRequest<T> withPhoneLessThan(String phone){
       return withPhone(Operator.LESS_THAN, phone);
    }

    public CustomerRequest<T> withPhoneLessThanOrEqualTo(String phone){
       return withPhone(Operator.LESS_THAN_OR_EQUAL, phone);
    }

    public CustomerRequest<T> withPhoneBetween(String startOfPhone, String endOfPhone){
       return withPhone(Operator.BETWEEN, startOfPhone, endOfPhone);
    }
    public CustomerRequest<T> withPhoneStartingWith(String phone){
       return withPhone(Operator.BEGIN_WITH, phone);
    }
    public CustomerRequest<T> withPhoneContaining(String phone){
       return withPhone(Operator.CONTAIN, phone);
    }

    public CustomerRequest<T> withPhoneEndingWith(String phone){
       return withPhone(Operator.END_WITH, phone);
    }

    public CustomerRequest<T> withPhoneIs(String phone){
       return withPhone(Operator.EQUAL, phone);
    }

    public CustomerRequest<T> withPhoneSoundingLike(String phone){
       return withPhone(Operator.SOUNDS_LIKE, phone);
    }



    public CustomerRequest<T> filterByCreatedAt(LocalDateTime... createdAt){
      if (createdAt == null || createdAt.length == 0) {
        throw new IllegalArgumentException("filterByCreatedAt parameter createdAt cannot be empty");
      }
      return appendSearchCriteria(createCreatedAtCriteria(Operator.EQUAL, (Object[])createdAt));
    }

    public CustomerRequest<T> withCreatedAt(Operator operator, Object... values){
       return appendSearchCriteria(createCreatedAtCriteria(operator, values));
    }

    public CustomerRequest<T> withCreatedAtIsUnknown(){
       return withCreatedAt(Operator.IS_NULL);
    }

    public CustomerRequest<T> withCreatedAtIsKnown(){
       return withCreatedAt(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createCreatedAtCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Customer.CREATED_AT_PROPERTY, operator, values);
    }

    public CustomerRequest<T> withCreatedAtGreaterThan(LocalDateTime createdAt){
       return withCreatedAt(Operator.GREATER_THAN, createdAt);
    }

    public CustomerRequest<T> withCreatedAtGreaterThanOrEqualTo(LocalDateTime createdAt){
       return withCreatedAt(Operator.GREATER_THAN_OR_EQUAL, createdAt);
    }

    public CustomerRequest<T> withCreatedAtLessThan(LocalDateTime createdAt){
       return withCreatedAt(Operator.LESS_THAN, createdAt);
    }

    public CustomerRequest<T> withCreatedAtLessThanOrEqualTo(LocalDateTime createdAt){
       return withCreatedAt(Operator.LESS_THAN_OR_EQUAL, createdAt);
    }

    public CustomerRequest<T> withCreatedAtBetween(LocalDateTime startOfCreatedAt, LocalDateTime endOfCreatedAt){
       return withCreatedAt(Operator.BETWEEN, startOfCreatedAt, endOfCreatedAt);
    }
    public CustomerRequest<T> withCreatedAtBefore(LocalDateTime createdAt){
       return withCreatedAt(Operator.LESS_THAN, createdAt);
    }

    public CustomerRequest<T> withCreatedAtBefore(Date createdAt){
       return withCreatedAt(Operator.LESS_THAN, createdAt);
    }

    public CustomerRequest<T> withCreatedAtAfter(LocalDateTime createdAt){
       return withCreatedAt(Operator.GREATER_THAN, createdAt);
    }

    public CustomerRequest<T> withCreatedAtAfter(Date createdAt){
       return withCreatedAt(Operator.GREATER_THAN, createdAt);
    }

    public CustomerRequest<T> withCreatedAtBetween(Date startOfCreatedAt, Date endOfCreatedAt){
       return withCreatedAt(Operator.BETWEEN, startOfCreatedAt, endOfCreatedAt);
    }




    public CustomerRequest<T> filterByLoyaltyPoints(BigDecimal... loyaltyPoints){
      if (loyaltyPoints == null || loyaltyPoints.length == 0) {
        throw new IllegalArgumentException("filterByLoyaltyPoints parameter loyaltyPoints cannot be empty");
      }
      return appendSearchCriteria(createLoyaltyPointsCriteria(Operator.EQUAL, (Object[])loyaltyPoints));
    }

    public CustomerRequest<T> withLoyaltyPoints(Operator operator, Object... values){
       return appendSearchCriteria(createLoyaltyPointsCriteria(operator, values));
    }

    public CustomerRequest<T> withLoyaltyPointsIsUnknown(){
       return withLoyaltyPoints(Operator.IS_NULL);
    }

    public CustomerRequest<T> withLoyaltyPointsIsKnown(){
       return withLoyaltyPoints(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createLoyaltyPointsCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Customer.LOYALTY_POINTS_PROPERTY, operator, values);
    }

    public CustomerRequest<T> withLoyaltyPointsGreaterThan(BigDecimal loyaltyPoints){
       return withLoyaltyPoints(Operator.GREATER_THAN, loyaltyPoints);
    }

    public CustomerRequest<T> withLoyaltyPointsGreaterThanOrEqualTo(BigDecimal loyaltyPoints){
       return withLoyaltyPoints(Operator.GREATER_THAN_OR_EQUAL, loyaltyPoints);
    }

    public CustomerRequest<T> withLoyaltyPointsLessThan(BigDecimal loyaltyPoints){
       return withLoyaltyPoints(Operator.LESS_THAN, loyaltyPoints);
    }

    public CustomerRequest<T> withLoyaltyPointsLessThanOrEqualTo(BigDecimal loyaltyPoints){
       return withLoyaltyPoints(Operator.LESS_THAN_OR_EQUAL, loyaltyPoints);
    }

    public CustomerRequest<T> withLoyaltyPointsBetween(BigDecimal startOfLoyaltyPoints, BigDecimal endOfLoyaltyPoints){
       return withLoyaltyPoints(Operator.BETWEEN, startOfLoyaltyPoints, endOfLoyaltyPoints);
    }



    public CustomerRequest<T> filterByCreateTime(LocalDateTime... createTime){
      if (createTime == null || createTime.length == 0) {
        throw new IllegalArgumentException("filterByCreateTime parameter createTime cannot be empty");
      }
      return appendSearchCriteria(createCreateTimeCriteria(Operator.EQUAL, (Object[])createTime));
    }

    public CustomerRequest<T> withCreateTime(Operator operator, Object... values){
       return appendSearchCriteria(createCreateTimeCriteria(operator, values));
    }

    public CustomerRequest<T> withCreateTimeIsUnknown(){
       return withCreateTime(Operator.IS_NULL);
    }

    public CustomerRequest<T> withCreateTimeIsKnown(){
       return withCreateTime(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createCreateTimeCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Customer.CREATE_TIME_PROPERTY, operator, values);
    }

    public CustomerRequest<T> withCreateTimeGreaterThan(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public CustomerRequest<T> withCreateTimeGreaterThanOrEqualTo(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN_OR_EQUAL, createTime);
    }

    public CustomerRequest<T> withCreateTimeLessThan(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public CustomerRequest<T> withCreateTimeLessThanOrEqualTo(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN_OR_EQUAL, createTime);
    }

    public CustomerRequest<T> withCreateTimeBetween(LocalDateTime startOfCreateTime, LocalDateTime endOfCreateTime){
       return withCreateTime(Operator.BETWEEN, startOfCreateTime, endOfCreateTime);
    }
    public CustomerRequest<T> withCreateTimeBefore(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public CustomerRequest<T> withCreateTimeBefore(Date createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public CustomerRequest<T> withCreateTimeAfter(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public CustomerRequest<T> withCreateTimeAfter(Date createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public CustomerRequest<T> withCreateTimeBetween(Date startOfCreateTime, Date endOfCreateTime){
       return withCreateTime(Operator.BETWEEN, startOfCreateTime, endOfCreateTime);
    }




    public CustomerRequest<T> filterByUpdateTime(LocalDateTime... updateTime){
      if (updateTime == null || updateTime.length == 0) {
        throw new IllegalArgumentException("filterByUpdateTime parameter updateTime cannot be empty");
      }
      return appendSearchCriteria(createUpdateTimeCriteria(Operator.EQUAL, (Object[])updateTime));
    }

    public CustomerRequest<T> withUpdateTime(Operator operator, Object... values){
       return appendSearchCriteria(createUpdateTimeCriteria(operator, values));
    }

    public CustomerRequest<T> withUpdateTimeIsUnknown(){
       return withUpdateTime(Operator.IS_NULL);
    }

    public CustomerRequest<T> withUpdateTimeIsKnown(){
       return withUpdateTime(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createUpdateTimeCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Customer.UPDATE_TIME_PROPERTY, operator, values);
    }

    public CustomerRequest<T> withUpdateTimeGreaterThan(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public CustomerRequest<T> withUpdateTimeGreaterThanOrEqualTo(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN_OR_EQUAL, updateTime);
    }

    public CustomerRequest<T> withUpdateTimeLessThan(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public CustomerRequest<T> withUpdateTimeLessThanOrEqualTo(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN_OR_EQUAL, updateTime);
    }

    public CustomerRequest<T> withUpdateTimeBetween(LocalDateTime startOfUpdateTime, LocalDateTime endOfUpdateTime){
       return withUpdateTime(Operator.BETWEEN, startOfUpdateTime, endOfUpdateTime);
    }
    public CustomerRequest<T> withUpdateTimeBefore(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public CustomerRequest<T> withUpdateTimeBefore(Date updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public CustomerRequest<T> withUpdateTimeAfter(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public CustomerRequest<T> withUpdateTimeAfter(Date updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public CustomerRequest<T> withUpdateTimeBetween(Date startOfUpdateTime, Date endOfUpdateTime){
       return withUpdateTime(Operator.BETWEEN, startOfUpdateTime, endOfUpdateTime);
    }




    public CustomerRequest<T> filterByVersion(Long... version){
      if (version == null || version.length == 0) {
        throw new IllegalArgumentException("filterByVersion parameter version cannot be empty");
      }
      return appendSearchCriteria(createVersionCriteria(Operator.EQUAL, (Object[])version));
    }

    public CustomerRequest<T> withVersion(Operator operator, Object... values){
       return appendSearchCriteria(createVersionCriteria(operator, values));
    }

    public CustomerRequest<T> withVersionIsUnknown(){
       return withVersion(Operator.IS_NULL);
    }

    public CustomerRequest<T> withVersionIsKnown(){
       return withVersion(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createVersionCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Customer.VERSION_PROPERTY, operator, values);
    }

    public CustomerRequest<T> withVersionGreaterThan(Long version){
       return withVersion(Operator.GREATER_THAN, version);
    }

    public CustomerRequest<T> withVersionGreaterThanOrEqualTo(Long version){
       return withVersion(Operator.GREATER_THAN_OR_EQUAL, version);
    }

    public CustomerRequest<T> withVersionLessThan(Long version){
       return withVersion(Operator.LESS_THAN, version);
    }

    public CustomerRequest<T> withVersionLessThanOrEqualTo(Long version){
       return withVersion(Operator.LESS_THAN_OR_EQUAL, version);
    }

    public CustomerRequest<T> withVersionBetween(Long startOfVersion, Long endOfVersion){
       return withVersion(Operator.BETWEEN, startOfVersion, endOfVersion);
    }

    public CustomerRequest<T> withContactListMatching(ContactRequest contactRequest){
        return appendSearchCriteria(new SubQuerySearchCriteria(Customer.ID_PROPERTY, contactRequest, Contact.CUSTOMER_PROPERTY));
    }

    public CustomerRequest<T> withoutContactListMatching(ContactRequest contactRequest){
        return appendSearchCriteria(SearchCriteria.not(new SubQuerySearchCriteria(Customer.ID_PROPERTY, contactRequest, Contact.CUSTOMER_PROPERTY)));
    }

    public CustomerRequest<T> haveContacts(){
        return withContactListMatching(Q.contacts().unlimited());
    }

    public CustomerRequest<T> haveNoContacts(){
        return withoutContactListMatching(Q.contacts().unlimited());
    }
    public CustomerRequest<T> withContractListMatching(ContractRequest contractRequest){
        return appendSearchCriteria(new SubQuerySearchCriteria(Customer.ID_PROPERTY, contractRequest, Contract.CUSTOMER_PROPERTY));
    }

    public CustomerRequest<T> withoutContractListMatching(ContractRequest contractRequest){
        return appendSearchCriteria(SearchCriteria.not(new SubQuerySearchCriteria(Customer.ID_PROPERTY, contractRequest, Contract.CUSTOMER_PROPERTY)));
    }

    public CustomerRequest<T> haveContracts(){
        return withContractListMatching(Q.contracts().unlimited());
    }

    public CustomerRequest<T> haveNoContracts(){
        return withoutContractListMatching(Q.contracts().unlimited());
    }
    public CustomerRequest<T> withProductReviewListMatching(ProductReviewRequest productReviewRequest){
        return appendSearchCriteria(new SubQuerySearchCriteria(Customer.ID_PROPERTY, productReviewRequest, ProductReview.CUSTOMER_PROPERTY));
    }

    public CustomerRequest<T> withoutProductReviewListMatching(ProductReviewRequest productReviewRequest){
        return appendSearchCriteria(SearchCriteria.not(new SubQuerySearchCriteria(Customer.ID_PROPERTY, productReviewRequest, ProductReview.CUSTOMER_PROPERTY)));
    }

    public CustomerRequest<T> haveProductReviews(){
        return withProductReviewListMatching(Q.productReviews().unlimited());
    }

    public CustomerRequest<T> haveNoProductReviews(){
        return withoutProductReviewListMatching(Q.productReviews().unlimited());
    }
    public CustomerRequest<T> withShoppingCartListMatching(ShoppingCartRequest shoppingCartRequest){
        return appendSearchCriteria(new SubQuerySearchCriteria(Customer.ID_PROPERTY, shoppingCartRequest, ShoppingCart.CUSTOMER_PROPERTY));
    }

    public CustomerRequest<T> withoutShoppingCartListMatching(ShoppingCartRequest shoppingCartRequest){
        return appendSearchCriteria(SearchCriteria.not(new SubQuerySearchCriteria(Customer.ID_PROPERTY, shoppingCartRequest, ShoppingCart.CUSTOMER_PROPERTY)));
    }

    public CustomerRequest<T> haveShoppingCarts(){
        return withShoppingCartListMatching(Q.shoppingCarts().unlimited());
    }

    public CustomerRequest<T> haveNoShoppingCarts(){
        return withoutShoppingCartListMatching(Q.shoppingCarts().unlimited());
    }
    public CustomerRequest<T> withGlobalOrderListMatching(GlobalOrderRequest globalOrderRequest){
        return appendSearchCriteria(new SubQuerySearchCriteria(Customer.ID_PROPERTY, globalOrderRequest, GlobalOrder.CUSTOMER_PROPERTY));
    }

    public CustomerRequest<T> withoutGlobalOrderListMatching(GlobalOrderRequest globalOrderRequest){
        return appendSearchCriteria(SearchCriteria.not(new SubQuerySearchCriteria(Customer.ID_PROPERTY, globalOrderRequest, GlobalOrder.CUSTOMER_PROPERTY)));
    }

    public CustomerRequest<T> haveGlobalOrders(){
        return withGlobalOrderListMatching(Q.globalOrders().unlimited());
    }

    public CustomerRequest<T> haveNoGlobalOrders(){
        return withoutGlobalOrderListMatching(Q.globalOrders().unlimited());
    }
    public CustomerRequest<T> withWishlistListMatching(WishlistRequest wishlistRequest){
        return appendSearchCriteria(new SubQuerySearchCriteria(Customer.ID_PROPERTY, wishlistRequest, Wishlist.CUSTOMER_PROPERTY));
    }

    public CustomerRequest<T> withoutWishlistListMatching(WishlistRequest wishlistRequest){
        return appendSearchCriteria(SearchCriteria.not(new SubQuerySearchCriteria(Customer.ID_PROPERTY, wishlistRequest, Wishlist.CUSTOMER_PROPERTY)));
    }

    public CustomerRequest<T> haveWishlists(){
        return withWishlistListMatching(Q.wishlists().unlimited());
    }

    public CustomerRequest<T> haveNoWishlists(){
        return withoutWishlistListMatching(Q.wishlists().unlimited());
    }
    public CustomerRequest<T> withInvoiceListMatching(InvoiceRequest invoiceRequest){
        return appendSearchCriteria(new SubQuerySearchCriteria(Customer.ID_PROPERTY, invoiceRequest, Invoice.CUSTOMER_PROPERTY));
    }

    public CustomerRequest<T> withoutInvoiceListMatching(InvoiceRequest invoiceRequest){
        return appendSearchCriteria(SearchCriteria.not(new SubQuerySearchCriteria(Customer.ID_PROPERTY, invoiceRequest, Invoice.CUSTOMER_PROPERTY)));
    }

    public CustomerRequest<T> haveInvoices(){
        return withInvoiceListMatching(Q.invoices().unlimited());
    }

    public CustomerRequest<T> haveNoInvoices(){
        return withoutInvoiceListMatching(Q.invoices().unlimited());
    }
    public CustomerRequest<T> withReturnRequestListMatching(ReturnRequestRequest returnRequestRequest){
        return appendSearchCriteria(new SubQuerySearchCriteria(Customer.ID_PROPERTY, returnRequestRequest, ReturnRequest.CUSTOMER_PROPERTY));
    }

    public CustomerRequest<T> withoutReturnRequestListMatching(ReturnRequestRequest returnRequestRequest){
        return appendSearchCriteria(SearchCriteria.not(new SubQuerySearchCriteria(Customer.ID_PROPERTY, returnRequestRequest, ReturnRequest.CUSTOMER_PROPERTY)));
    }

    public CustomerRequest<T> haveReturnRequests(){
        return withReturnRequestListMatching(Q.returnRequests().unlimited());
    }

    public CustomerRequest<T> haveNoReturnRequests(){
        return withoutReturnRequestListMatching(Q.returnRequests().unlimited());
    }
    public CustomerRequest<T> withTicketListMatching(TicketRequest ticketRequest){
        return appendSearchCriteria(new SubQuerySearchCriteria(Customer.ID_PROPERTY, ticketRequest, Ticket.CUSTOMER_PROPERTY));
    }

    public CustomerRequest<T> withoutTicketListMatching(TicketRequest ticketRequest){
        return appendSearchCriteria(SearchCriteria.not(new SubQuerySearchCriteria(Customer.ID_PROPERTY, ticketRequest, Ticket.CUSTOMER_PROPERTY)));
    }

    public CustomerRequest<T> haveTickets(){
        return withTicketListMatching(Q.tickets().unlimited());
    }

    public CustomerRequest<T> haveNoTickets(){
        return withoutTicketListMatching(Q.tickets().unlimited());
    }

    public CustomerRequest<T> count(){
        super.count();
        return this;
    }
    public CustomerRequest<T> countAs(String retName){
        super.count(retName);
        return this;
    }
    public CustomerRequest minLoyaltyPoints(){
        return minLoyaltyPointsAs(prefix("minOf",Customer.LOYALTY_POINTS_PROPERTY));
    }

    public CustomerRequest minLoyaltyPointsAs(String retName){
        super.min(retName, Customer.LOYALTY_POINTS_PROPERTY);
        return this;
    }
    public CustomerRequest maxLoyaltyPoints(){
        return maxLoyaltyPointsAs(prefix("maxOf",Customer.LOYALTY_POINTS_PROPERTY));
    }

    public CustomerRequest maxLoyaltyPointsAs(String retName){
        super.max(retName, Customer.LOYALTY_POINTS_PROPERTY);
        return this;
    }
    public CustomerRequest sumLoyaltyPoints(){
        return sumLoyaltyPointsAs(prefix("sumOf",Customer.LOYALTY_POINTS_PROPERTY));
    }

    public CustomerRequest sumLoyaltyPointsAs(String retName){
        super.sum(retName, Customer.LOYALTY_POINTS_PROPERTY);
        return this;
    }
    public CustomerRequest avgLoyaltyPoints(){
        return avgLoyaltyPointsAs(prefix("avgOf",Customer.LOYALTY_POINTS_PROPERTY));
    }

    public CustomerRequest avgLoyaltyPointsAs(String retName){
        super.avg(retName, Customer.LOYALTY_POINTS_PROPERTY);
        return this;
    }
    public CustomerRequest standardDeviationLoyaltyPoints(){
        return standardDeviationLoyaltyPointsAs(prefix("standardDeviationOf",Customer.LOYALTY_POINTS_PROPERTY));
    }

    public CustomerRequest standardDeviationLoyaltyPointsAs(String retName){
        super.standardDeviation(retName, Customer.LOYALTY_POINTS_PROPERTY);
        return this;
    }
    public CustomerRequest squareRootOfPopulationStandardDeviationLoyaltyPoints(){
        return squareRootOfPopulationStandardDeviationLoyaltyPointsAs(prefix("squareRootOfPopulationStandardDeviationOf",Customer.LOYALTY_POINTS_PROPERTY));
    }

    public CustomerRequest squareRootOfPopulationStandardDeviationLoyaltyPointsAs(String retName){
        super.squareRootOfPopulationStandardDeviation(retName, Customer.LOYALTY_POINTS_PROPERTY);
        return this;
    }
    public CustomerRequest sampleVarianceLoyaltyPoints(){
        return sampleVarianceLoyaltyPointsAs(prefix("sampleVarianceOf",Customer.LOYALTY_POINTS_PROPERTY));
    }

    public CustomerRequest sampleVarianceLoyaltyPointsAs(String retName){
        super.sampleVariance(retName, Customer.LOYALTY_POINTS_PROPERTY);
        return this;
    }
    public CustomerRequest samplePopulationVarianceLoyaltyPoints(){
        return samplePopulationVarianceLoyaltyPointsAs(prefix("samplePopulationVarianceOf",Customer.LOYALTY_POINTS_PROPERTY));
    }

    public CustomerRequest samplePopulationVarianceLoyaltyPointsAs(String retName){
        super.samplePopulationVariance(retName, Customer.LOYALTY_POINTS_PROPERTY);
        return this;
    }
    public CustomerRequest<T> groupByContactsWithDetails(ContactRequest subRequest){
       aggregate(Customer.CONTACT_LIST_PROPERTY, subRequest);
       return this;
    }
    public CustomerRequest<T> groupByContractsWithDetails(ContractRequest subRequest){
       aggregate(Customer.CONTRACT_LIST_PROPERTY, subRequest);
       return this;
    }
    public CustomerRequest<T> groupByProductReviewsWithDetails(ProductReviewRequest subRequest){
       aggregate(Customer.PRODUCT_REVIEW_LIST_PROPERTY, subRequest);
       return this;
    }
    public CustomerRequest<T> groupByShoppingCartsWithDetails(ShoppingCartRequest subRequest){
       aggregate(Customer.SHOPPING_CART_LIST_PROPERTY, subRequest);
       return this;
    }
    public CustomerRequest<T> groupByGlobalOrdersWithDetails(GlobalOrderRequest subRequest){
       aggregate(Customer.GLOBAL_ORDER_LIST_PROPERTY, subRequest);
       return this;
    }
    public CustomerRequest<T> groupByWishlistsWithDetails(WishlistRequest subRequest){
       aggregate(Customer.WISHLIST_LIST_PROPERTY, subRequest);
       return this;
    }
    public CustomerRequest<T> groupByInvoicesWithDetails(InvoiceRequest subRequest){
       aggregate(Customer.INVOICE_LIST_PROPERTY, subRequest);
       return this;
    }
    public CustomerRequest<T> groupByReturnRequestsWithDetails(ReturnRequestRequest subRequest){
       aggregate(Customer.RETURN_REQUEST_LIST_PROPERTY, subRequest);
       return this;
    }
    public CustomerRequest<T> groupByTicketsWithDetails(TicketRequest subRequest){
       aggregate(Customer.TICKET_LIST_PROPERTY, subRequest);
       return this;
    }

    public CustomerRequest<T> groupById(){
       groupBy(Customer.ID_PROPERTY);
       return this;
    }

    public CustomerRequest<T> groupByIdAs(String retName){
       groupBy(retName, Customer.ID_PROPERTY);
       return this;
    }

    public CustomerRequest<T> groupByIdWithFunction(String retName, AggrFunction function){
       groupBy(retName, Customer.ID_PROPERTY, function);
       return this;
    }

    public CustomerRequest<T> groupByAddress(){
       groupBy(Customer.ADDRESS_PROPERTY);
       return this;
    }

    public CustomerRequest<T> groupByAddressAs(String retName){
       groupBy(retName, Customer.ADDRESS_PROPERTY);
       return this;
    }

    public CustomerRequest<T> groupByAddressWithFunction(String retName, AggrFunction function){
       groupBy(retName, Customer.ADDRESS_PROPERTY, function);
       return this;
    }

    public CustomerRequest<T> groupByEmail(){
       groupBy(Customer.EMAIL_PROPERTY);
       return this;
    }

    public CustomerRequest<T> groupByEmailAs(String retName){
       groupBy(retName, Customer.EMAIL_PROPERTY);
       return this;
    }

    public CustomerRequest<T> groupByEmailWithFunction(String retName, AggrFunction function){
       groupBy(retName, Customer.EMAIL_PROPERTY, function);
       return this;
    }

    public CustomerRequest<T> groupByName(){
       groupBy(Customer.NAME_PROPERTY);
       return this;
    }

    public CustomerRequest<T> groupByNameAs(String retName){
       groupBy(retName, Customer.NAME_PROPERTY);
       return this;
    }

    public CustomerRequest<T> groupByNameWithFunction(String retName, AggrFunction function){
       groupBy(retName, Customer.NAME_PROPERTY, function);
       return this;
    }

    public CustomerRequest<T> groupByPhone(){
       groupBy(Customer.PHONE_PROPERTY);
       return this;
    }

    public CustomerRequest<T> groupByPhoneAs(String retName){
       groupBy(retName, Customer.PHONE_PROPERTY);
       return this;
    }

    public CustomerRequest<T> groupByPhoneWithFunction(String retName, AggrFunction function){
       groupBy(retName, Customer.PHONE_PROPERTY, function);
       return this;
    }

    public CustomerRequest<T> groupByCreatedAt(){
       groupBy(Customer.CREATED_AT_PROPERTY);
       return this;
    }

    public CustomerRequest<T> groupByCreatedAtAs(String retName){
       groupBy(retName, Customer.CREATED_AT_PROPERTY);
       return this;
    }

    public CustomerRequest<T> groupByCreatedAtWithFunction(String retName, AggrFunction function){
       groupBy(retName, Customer.CREATED_AT_PROPERTY, function);
       return this;
    }

    public CustomerRequest<T> groupByLoyaltyPoints(){
       groupBy(Customer.LOYALTY_POINTS_PROPERTY);
       return this;
    }

    public CustomerRequest<T> groupByLoyaltyPointsAs(String retName){
       groupBy(retName, Customer.LOYALTY_POINTS_PROPERTY);
       return this;
    }

    public CustomerRequest<T> groupByLoyaltyPointsWithFunction(String retName, AggrFunction function){
       groupBy(retName, Customer.LOYALTY_POINTS_PROPERTY, function);
       return this;
    }

    public CustomerRequest<T> groupByCreateTime(){
       groupBy(Customer.CREATE_TIME_PROPERTY);
       return this;
    }

    public CustomerRequest<T> groupByCreateTimeAs(String retName){
       groupBy(retName, Customer.CREATE_TIME_PROPERTY);
       return this;
    }

    public CustomerRequest<T> groupByCreateTimeWithFunction(String retName, AggrFunction function){
       groupBy(retName, Customer.CREATE_TIME_PROPERTY, function);
       return this;
    }

    public CustomerRequest<T> groupByUpdateTime(){
       groupBy(Customer.UPDATE_TIME_PROPERTY);
       return this;
    }

    public CustomerRequest<T> groupByUpdateTimeAs(String retName){
       groupBy(retName, Customer.UPDATE_TIME_PROPERTY);
       return this;
    }

    public CustomerRequest<T> groupByUpdateTimeWithFunction(String retName, AggrFunction function){
       groupBy(retName, Customer.UPDATE_TIME_PROPERTY, function);
       return this;
    }

    public CustomerRequest<T> groupByVersion(){
       groupBy(Customer.VERSION_PROPERTY);
       return this;
    }

    public CustomerRequest<T> groupByVersionAs(String retName){
       groupBy(retName, Customer.VERSION_PROPERTY);
       return this;
    }

    public CustomerRequest<T> groupByVersionWithFunction(String retName, AggrFunction function){
       groupBy(retName, Customer.VERSION_PROPERTY, function);
       return this;
    }



    public CustomerRequest<T> orderByIdAscending(){
       addOrderByAscending(Customer.ID_PROPERTY);
       return this;
    }

    public CustomerRequest<T> orderByIdDescending(){
       addOrderByDescending(Customer.ID_PROPERTY);
       return this;
    }

    public CustomerRequest<T> orderByAddressAscending(){
       addOrderByAscending(Customer.ADDRESS_PROPERTY);
       return this;
    }

    public CustomerRequest<T> orderByAddressDescending(){
       addOrderByDescending(Customer.ADDRESS_PROPERTY);
       return this;
    }
    public CustomerRequest<T> orderByAddressAscendingUsingGBK(){
       addOrderByAscendingUsingGBK(Customer.ADDRESS_PROPERTY);
       return this;
    }

    public CustomerRequest<T> orderByAddressDescendingUsingGBK(){
       addOrderByDescendingUsingGBK(Customer.ADDRESS_PROPERTY);
       return this;
    }
    public CustomerRequest<T> orderByEmailAscending(){
       addOrderByAscending(Customer.EMAIL_PROPERTY);
       return this;
    }

    public CustomerRequest<T> orderByEmailDescending(){
       addOrderByDescending(Customer.EMAIL_PROPERTY);
       return this;
    }
    public CustomerRequest<T> orderByEmailAscendingUsingGBK(){
       addOrderByAscendingUsingGBK(Customer.EMAIL_PROPERTY);
       return this;
    }

    public CustomerRequest<T> orderByEmailDescendingUsingGBK(){
       addOrderByDescendingUsingGBK(Customer.EMAIL_PROPERTY);
       return this;
    }
    public CustomerRequest<T> orderByNameAscending(){
       addOrderByAscending(Customer.NAME_PROPERTY);
       return this;
    }

    public CustomerRequest<T> orderByNameDescending(){
       addOrderByDescending(Customer.NAME_PROPERTY);
       return this;
    }
    public CustomerRequest<T> orderByNameAscendingUsingGBK(){
       addOrderByAscendingUsingGBK(Customer.NAME_PROPERTY);
       return this;
    }

    public CustomerRequest<T> orderByNameDescendingUsingGBK(){
       addOrderByDescendingUsingGBK(Customer.NAME_PROPERTY);
       return this;
    }
    public CustomerRequest<T> orderByPhoneAscending(){
       addOrderByAscending(Customer.PHONE_PROPERTY);
       return this;
    }

    public CustomerRequest<T> orderByPhoneDescending(){
       addOrderByDescending(Customer.PHONE_PROPERTY);
       return this;
    }
    public CustomerRequest<T> orderByPhoneAscendingUsingGBK(){
       addOrderByAscendingUsingGBK(Customer.PHONE_PROPERTY);
       return this;
    }

    public CustomerRequest<T> orderByPhoneDescendingUsingGBK(){
       addOrderByDescendingUsingGBK(Customer.PHONE_PROPERTY);
       return this;
    }
    public CustomerRequest<T> orderByCreatedAtAscending(){
       addOrderByAscending(Customer.CREATED_AT_PROPERTY);
       return this;
    }

    public CustomerRequest<T> orderByCreatedAtDescending(){
       addOrderByDescending(Customer.CREATED_AT_PROPERTY);
       return this;
    }

    public CustomerRequest<T> orderByLoyaltyPointsAscending(){
       addOrderByAscending(Customer.LOYALTY_POINTS_PROPERTY);
       return this;
    }

    public CustomerRequest<T> orderByLoyaltyPointsDescending(){
       addOrderByDescending(Customer.LOYALTY_POINTS_PROPERTY);
       return this;
    }

    public CustomerRequest<T> orderByCreateTimeAscending(){
       addOrderByAscending(Customer.CREATE_TIME_PROPERTY);
       return this;
    }

    public CustomerRequest<T> orderByCreateTimeDescending(){
       addOrderByDescending(Customer.CREATE_TIME_PROPERTY);
       return this;
    }

    public CustomerRequest<T> orderByUpdateTimeAscending(){
       addOrderByAscending(Customer.UPDATE_TIME_PROPERTY);
       return this;
    }

    public CustomerRequest<T> orderByUpdateTimeDescending(){
       addOrderByDescending(Customer.UPDATE_TIME_PROPERTY);
       return this;
    }

    public CustomerRequest<T> orderByVersionAscending(){
       addOrderByAscending(Customer.VERSION_PROPERTY);
       return this;
    }

    public CustomerRequest<T> orderByVersionDescending(){
       addOrderByDescending(Customer.VERSION_PROPERTY);
       return this;
    }


    public CustomerRequest<T> statsFromContactsAs(String name, ContactRequest subRequest){
       return statsFromContactsAs(name, subRequest, false);
    }

    public CustomerRequest<T> statsFromContactsAs(String name, ContactRequest subRequest, boolean singleResult){
       subRequest.setPartitionProperty(Contact.CUSTOMER_PROPERTY);
       addAggregateDynamicProperty(name, subRequest, singleResult);
       return this;
    }

    public CustomerRequest<T> statsFromContacts(ContactRequest subRequest){
       return statsFromContactsAs(REFINEMENTS, subRequest);
    }
    public CustomerRequest<T> statsFromContractsAs(String name, ContractRequest subRequest){
       return statsFromContractsAs(name, subRequest, false);
    }

    public CustomerRequest<T> statsFromContractsAs(String name, ContractRequest subRequest, boolean singleResult){
       subRequest.setPartitionProperty(Contract.CUSTOMER_PROPERTY);
       addAggregateDynamicProperty(name, subRequest, singleResult);
       return this;
    }

    public CustomerRequest<T> statsFromContracts(ContractRequest subRequest){
       return statsFromContractsAs(REFINEMENTS, subRequest);
    }
    public CustomerRequest<T> statsFromProductReviewsAs(String name, ProductReviewRequest subRequest){
       return statsFromProductReviewsAs(name, subRequest, false);
    }

    public CustomerRequest<T> statsFromProductReviewsAs(String name, ProductReviewRequest subRequest, boolean singleResult){
       subRequest.setPartitionProperty(ProductReview.CUSTOMER_PROPERTY);
       addAggregateDynamicProperty(name, subRequest, singleResult);
       return this;
    }

    public CustomerRequest<T> statsFromProductReviews(ProductReviewRequest subRequest){
       return statsFromProductReviewsAs(REFINEMENTS, subRequest);
    }
    public CustomerRequest<T> statsFromShoppingCartsAs(String name, ShoppingCartRequest subRequest){
       return statsFromShoppingCartsAs(name, subRequest, false);
    }

    public CustomerRequest<T> statsFromShoppingCartsAs(String name, ShoppingCartRequest subRequest, boolean singleResult){
       subRequest.setPartitionProperty(ShoppingCart.CUSTOMER_PROPERTY);
       addAggregateDynamicProperty(name, subRequest, singleResult);
       return this;
    }

    public CustomerRequest<T> statsFromShoppingCarts(ShoppingCartRequest subRequest){
       return statsFromShoppingCartsAs(REFINEMENTS, subRequest);
    }
    public CustomerRequest<T> statsFromGlobalOrdersAs(String name, GlobalOrderRequest subRequest){
       return statsFromGlobalOrdersAs(name, subRequest, false);
    }

    public CustomerRequest<T> statsFromGlobalOrdersAs(String name, GlobalOrderRequest subRequest, boolean singleResult){
       subRequest.setPartitionProperty(GlobalOrder.CUSTOMER_PROPERTY);
       addAggregateDynamicProperty(name, subRequest, singleResult);
       return this;
    }

    public CustomerRequest<T> statsFromGlobalOrders(GlobalOrderRequest subRequest){
       return statsFromGlobalOrdersAs(REFINEMENTS, subRequest);
    }
    public CustomerRequest<T> statsFromWishlistsAs(String name, WishlistRequest subRequest){
       return statsFromWishlistsAs(name, subRequest, false);
    }

    public CustomerRequest<T> statsFromWishlistsAs(String name, WishlistRequest subRequest, boolean singleResult){
       subRequest.setPartitionProperty(Wishlist.CUSTOMER_PROPERTY);
       addAggregateDynamicProperty(name, subRequest, singleResult);
       return this;
    }

    public CustomerRequest<T> statsFromWishlists(WishlistRequest subRequest){
       return statsFromWishlistsAs(REFINEMENTS, subRequest);
    }
    public CustomerRequest<T> statsFromInvoicesAs(String name, InvoiceRequest subRequest){
       return statsFromInvoicesAs(name, subRequest, false);
    }

    public CustomerRequest<T> statsFromInvoicesAs(String name, InvoiceRequest subRequest, boolean singleResult){
       subRequest.setPartitionProperty(Invoice.CUSTOMER_PROPERTY);
       addAggregateDynamicProperty(name, subRequest, singleResult);
       return this;
    }

    public CustomerRequest<T> statsFromInvoices(InvoiceRequest subRequest){
       return statsFromInvoicesAs(REFINEMENTS, subRequest);
    }
    public CustomerRequest<T> statsFromReturnRequestsAs(String name, ReturnRequestRequest subRequest){
       return statsFromReturnRequestsAs(name, subRequest, false);
    }

    public CustomerRequest<T> statsFromReturnRequestsAs(String name, ReturnRequestRequest subRequest, boolean singleResult){
       subRequest.setPartitionProperty(ReturnRequest.CUSTOMER_PROPERTY);
       addAggregateDynamicProperty(name, subRequest, singleResult);
       return this;
    }

    public CustomerRequest<T> statsFromReturnRequests(ReturnRequestRequest subRequest){
       return statsFromReturnRequestsAs(REFINEMENTS, subRequest);
    }
    public CustomerRequest<T> statsFromTicketsAs(String name, TicketRequest subRequest){
       return statsFromTicketsAs(name, subRequest, false);
    }

    public CustomerRequest<T> statsFromTicketsAs(String name, TicketRequest subRequest, boolean singleResult){
       subRequest.setPartitionProperty(Ticket.CUSTOMER_PROPERTY);
       addAggregateDynamicProperty(name, subRequest, singleResult);
       return this;
    }

    public CustomerRequest<T> statsFromTickets(TicketRequest subRequest){
       return statsFromTicketsAs(REFINEMENTS, subRequest);
    }
    public CustomerRequest<T> countContacts(){
        return countContactsAs("Count");
    }

    public CustomerRequest<T> countContactsAs(String name){
        return countContactsWith(name, Q.contacts().unlimited());
    }

    public CustomerRequest<T> countContactsWith(String name, ContactRequest subRequest){
        return statsFromContactsAs(name, subRequest.count(), true);
    }
    public CustomerRequest<T> countContracts(){
        return countContractsAs("Count");
    }

    public CustomerRequest<T> countContractsAs(String name){
        return countContractsWith(name, Q.contracts().unlimited());
    }

    public CustomerRequest<T> countContractsWith(String name, ContractRequest subRequest){
        return statsFromContractsAs(name, subRequest.count(), true);
    }
    public CustomerRequest<T> countProductReviews(){
        return countProductReviewsAs("Count");
    }

    public CustomerRequest<T> countProductReviewsAs(String name){
        return countProductReviewsWith(name, Q.productReviews().unlimited());
    }

    public CustomerRequest<T> countProductReviewsWith(String name, ProductReviewRequest subRequest){
        return statsFromProductReviewsAs(name, subRequest.count(), true);
    }
    public CustomerRequest<T> countShoppingCarts(){
        return countShoppingCartsAs("Count");
    }

    public CustomerRequest<T> countShoppingCartsAs(String name){
        return countShoppingCartsWith(name, Q.shoppingCarts().unlimited());
    }

    public CustomerRequest<T> countShoppingCartsWith(String name, ShoppingCartRequest subRequest){
        return statsFromShoppingCartsAs(name, subRequest.count(), true);
    }
    public CustomerRequest<T> countGlobalOrders(){
        return countGlobalOrdersAs("Count");
    }

    public CustomerRequest<T> countGlobalOrdersAs(String name){
        return countGlobalOrdersWith(name, Q.globalOrders().unlimited());
    }

    public CustomerRequest<T> countGlobalOrdersWith(String name, GlobalOrderRequest subRequest){
        return statsFromGlobalOrdersAs(name, subRequest.count(), true);
    }
    public CustomerRequest<T> countWishlists(){
        return countWishlistsAs("Count");
    }

    public CustomerRequest<T> countWishlistsAs(String name){
        return countWishlistsWith(name, Q.wishlists().unlimited());
    }

    public CustomerRequest<T> countWishlistsWith(String name, WishlistRequest subRequest){
        return statsFromWishlistsAs(name, subRequest.count(), true);
    }
    public CustomerRequest<T> countInvoices(){
        return countInvoicesAs("Count");
    }

    public CustomerRequest<T> countInvoicesAs(String name){
        return countInvoicesWith(name, Q.invoices().unlimited());
    }

    public CustomerRequest<T> countInvoicesWith(String name, InvoiceRequest subRequest){
        return statsFromInvoicesAs(name, subRequest.count(), true);
    }
    public CustomerRequest<T> countReturnRequests(){
        return countReturnRequestsAs("Count");
    }

    public CustomerRequest<T> countReturnRequestsAs(String name){
        return countReturnRequestsWith(name, Q.returnRequests().unlimited());
    }

    public CustomerRequest<T> countReturnRequestsWith(String name, ReturnRequestRequest subRequest){
        return statsFromReturnRequestsAs(name, subRequest.count(), true);
    }
    public CustomerRequest<T> countTickets(){
        return countTicketsAs("Count");
    }

    public CustomerRequest<T> countTicketsAs(String name){
        return countTicketsWith(name, Q.tickets().unlimited());
    }

    public CustomerRequest<T> countTicketsWith(String name, TicketRequest subRequest){
        return statsFromTicketsAs(name, subRequest.count(), true);
    }
    public CustomerRequest<T> minValueOfContracts(){
        return minValueOfContractsAs("minValueOfContracts");
    }

    public CustomerRequest<T> minValueOfContractsAs(String name){
        return minValueOfContractsAs(name, Q.contracts().unlimited());
    }

    public CustomerRequest<T> minValueOfContractsAs(String name, ContractRequest subRequest){
        return statsFromContractsAs(name, subRequest.minValue(), true);
    }
    public CustomerRequest<T> maxValueOfContracts(){
        return maxValueOfContractsAs("maxValueOfContracts");
    }

    public CustomerRequest<T> maxValueOfContractsAs(String name){
        return maxValueOfContractsAs(name, Q.contracts().unlimited());
    }

    public CustomerRequest<T> maxValueOfContractsAs(String name, ContractRequest subRequest){
        return statsFromContractsAs(name, subRequest.maxValue(), true);
    }
    public CustomerRequest<T> sumValueOfContracts(){
        return sumValueOfContractsAs("sumValueOfContracts");
    }

    public CustomerRequest<T> sumValueOfContractsAs(String name){
        return sumValueOfContractsAs(name, Q.contracts().unlimited());
    }

    public CustomerRequest<T> sumValueOfContractsAs(String name, ContractRequest subRequest){
        return statsFromContractsAs(name, subRequest.sumValue(), true);
    }
    public CustomerRequest<T> avgValueOfContracts(){
        return avgValueOfContractsAs("avgValueOfContracts");
    }

    public CustomerRequest<T> avgValueOfContractsAs(String name){
        return avgValueOfContractsAs(name, Q.contracts().unlimited());
    }

    public CustomerRequest<T> avgValueOfContractsAs(String name, ContractRequest subRequest){
        return statsFromContractsAs(name, subRequest.avgValue(), true);
    }
    public CustomerRequest<T> standardDeviationValueOfContracts(){
        return standardDeviationValueOfContractsAs("stdDevValueOfContracts");
    }

    public CustomerRequest<T> standardDeviationValueOfContractsAs(String name){
        return standardDeviationValueOfContractsAs(name, Q.contracts().unlimited());
    }

    public CustomerRequest<T> standardDeviationValueOfContractsAs(String name, ContractRequest subRequest){
        return statsFromContractsAs(name, subRequest.standardDeviationValue(), true);
    }
    public CustomerRequest<T> squareRootOfPopulationStandardDeviationValueOfContracts(){
        return squareRootOfPopulationStandardDeviationValueOfContractsAs("stdDevPopValueOfContracts");
    }

    public CustomerRequest<T> squareRootOfPopulationStandardDeviationValueOfContractsAs(String name){
        return squareRootOfPopulationStandardDeviationValueOfContractsAs(name, Q.contracts().unlimited());
    }

    public CustomerRequest<T> squareRootOfPopulationStandardDeviationValueOfContractsAs(String name, ContractRequest subRequest){
        return statsFromContractsAs(name, subRequest.squareRootOfPopulationStandardDeviationValue(), true);
    }
    public CustomerRequest<T> sampleVarianceValueOfContracts(){
        return sampleVarianceValueOfContractsAs("varSampValueOfContracts");
    }

    public CustomerRequest<T> sampleVarianceValueOfContractsAs(String name){
        return sampleVarianceValueOfContractsAs(name, Q.contracts().unlimited());
    }

    public CustomerRequest<T> sampleVarianceValueOfContractsAs(String name, ContractRequest subRequest){
        return statsFromContractsAs(name, subRequest.sampleVarianceValue(), true);
    }
    public CustomerRequest<T> samplePopulationVarianceValueOfContracts(){
        return samplePopulationVarianceValueOfContractsAs("varPopValueOfContracts");
    }

    public CustomerRequest<T> samplePopulationVarianceValueOfContractsAs(String name){
        return samplePopulationVarianceValueOfContractsAs(name, Q.contracts().unlimited());
    }

    public CustomerRequest<T> samplePopulationVarianceValueOfContractsAs(String name, ContractRequest subRequest){
        return statsFromContractsAs(name, subRequest.samplePopulationVarianceValue(), true);
    }
    public CustomerRequest<T> minRatingOfProductReviews(){
        return minRatingOfProductReviewsAs("minRatingOfProductReviews");
    }

    public CustomerRequest<T> minRatingOfProductReviewsAs(String name){
        return minRatingOfProductReviewsAs(name, Q.productReviews().unlimited());
    }

    public CustomerRequest<T> minRatingOfProductReviewsAs(String name, ProductReviewRequest subRequest){
        return statsFromProductReviewsAs(name, subRequest.minRating(), true);
    }
    public CustomerRequest<T> maxRatingOfProductReviews(){
        return maxRatingOfProductReviewsAs("maxRatingOfProductReviews");
    }

    public CustomerRequest<T> maxRatingOfProductReviewsAs(String name){
        return maxRatingOfProductReviewsAs(name, Q.productReviews().unlimited());
    }

    public CustomerRequest<T> maxRatingOfProductReviewsAs(String name, ProductReviewRequest subRequest){
        return statsFromProductReviewsAs(name, subRequest.maxRating(), true);
    }
    public CustomerRequest<T> sumRatingOfProductReviews(){
        return sumRatingOfProductReviewsAs("sumRatingOfProductReviews");
    }

    public CustomerRequest<T> sumRatingOfProductReviewsAs(String name){
        return sumRatingOfProductReviewsAs(name, Q.productReviews().unlimited());
    }

    public CustomerRequest<T> sumRatingOfProductReviewsAs(String name, ProductReviewRequest subRequest){
        return statsFromProductReviewsAs(name, subRequest.sumRating(), true);
    }
    public CustomerRequest<T> avgRatingOfProductReviews(){
        return avgRatingOfProductReviewsAs("avgRatingOfProductReviews");
    }

    public CustomerRequest<T> avgRatingOfProductReviewsAs(String name){
        return avgRatingOfProductReviewsAs(name, Q.productReviews().unlimited());
    }

    public CustomerRequest<T> avgRatingOfProductReviewsAs(String name, ProductReviewRequest subRequest){
        return statsFromProductReviewsAs(name, subRequest.avgRating(), true);
    }
    public CustomerRequest<T> standardDeviationRatingOfProductReviews(){
        return standardDeviationRatingOfProductReviewsAs("stdDevRatingOfProductReviews");
    }

    public CustomerRequest<T> standardDeviationRatingOfProductReviewsAs(String name){
        return standardDeviationRatingOfProductReviewsAs(name, Q.productReviews().unlimited());
    }

    public CustomerRequest<T> standardDeviationRatingOfProductReviewsAs(String name, ProductReviewRequest subRequest){
        return statsFromProductReviewsAs(name, subRequest.standardDeviationRating(), true);
    }
    public CustomerRequest<T> squareRootOfPopulationStandardDeviationRatingOfProductReviews(){
        return squareRootOfPopulationStandardDeviationRatingOfProductReviewsAs("stdDevPopRatingOfProductReviews");
    }

    public CustomerRequest<T> squareRootOfPopulationStandardDeviationRatingOfProductReviewsAs(String name){
        return squareRootOfPopulationStandardDeviationRatingOfProductReviewsAs(name, Q.productReviews().unlimited());
    }

    public CustomerRequest<T> squareRootOfPopulationStandardDeviationRatingOfProductReviewsAs(String name, ProductReviewRequest subRequest){
        return statsFromProductReviewsAs(name, subRequest.squareRootOfPopulationStandardDeviationRating(), true);
    }
    public CustomerRequest<T> sampleVarianceRatingOfProductReviews(){
        return sampleVarianceRatingOfProductReviewsAs("varSampRatingOfProductReviews");
    }

    public CustomerRequest<T> sampleVarianceRatingOfProductReviewsAs(String name){
        return sampleVarianceRatingOfProductReviewsAs(name, Q.productReviews().unlimited());
    }

    public CustomerRequest<T> sampleVarianceRatingOfProductReviewsAs(String name, ProductReviewRequest subRequest){
        return statsFromProductReviewsAs(name, subRequest.sampleVarianceRating(), true);
    }
    public CustomerRequest<T> samplePopulationVarianceRatingOfProductReviews(){
        return samplePopulationVarianceRatingOfProductReviewsAs("varPopRatingOfProductReviews");
    }

    public CustomerRequest<T> samplePopulationVarianceRatingOfProductReviewsAs(String name){
        return samplePopulationVarianceRatingOfProductReviewsAs(name, Q.productReviews().unlimited());
    }

    public CustomerRequest<T> samplePopulationVarianceRatingOfProductReviewsAs(String name, ProductReviewRequest subRequest){
        return statsFromProductReviewsAs(name, subRequest.samplePopulationVarianceRating(), true);
    }
    public CustomerRequest<T> minTotalAmountOfGlobalOrders(){
        return minTotalAmountOfGlobalOrdersAs("minTotalAmountOfGlobalOrders");
    }

    public CustomerRequest<T> minTotalAmountOfGlobalOrdersAs(String name){
        return minTotalAmountOfGlobalOrdersAs(name, Q.globalOrders().unlimited());
    }

    public CustomerRequest<T> minTotalAmountOfGlobalOrdersAs(String name, GlobalOrderRequest subRequest){
        return statsFromGlobalOrdersAs(name, subRequest.minTotalAmount(), true);
    }
    public CustomerRequest<T> maxTotalAmountOfGlobalOrders(){
        return maxTotalAmountOfGlobalOrdersAs("maxTotalAmountOfGlobalOrders");
    }

    public CustomerRequest<T> maxTotalAmountOfGlobalOrdersAs(String name){
        return maxTotalAmountOfGlobalOrdersAs(name, Q.globalOrders().unlimited());
    }

    public CustomerRequest<T> maxTotalAmountOfGlobalOrdersAs(String name, GlobalOrderRequest subRequest){
        return statsFromGlobalOrdersAs(name, subRequest.maxTotalAmount(), true);
    }
    public CustomerRequest<T> sumTotalAmountOfGlobalOrders(){
        return sumTotalAmountOfGlobalOrdersAs("sumTotalAmountOfGlobalOrders");
    }

    public CustomerRequest<T> sumTotalAmountOfGlobalOrdersAs(String name){
        return sumTotalAmountOfGlobalOrdersAs(name, Q.globalOrders().unlimited());
    }

    public CustomerRequest<T> sumTotalAmountOfGlobalOrdersAs(String name, GlobalOrderRequest subRequest){
        return statsFromGlobalOrdersAs(name, subRequest.sumTotalAmount(), true);
    }
    public CustomerRequest<T> avgTotalAmountOfGlobalOrders(){
        return avgTotalAmountOfGlobalOrdersAs("avgTotalAmountOfGlobalOrders");
    }

    public CustomerRequest<T> avgTotalAmountOfGlobalOrdersAs(String name){
        return avgTotalAmountOfGlobalOrdersAs(name, Q.globalOrders().unlimited());
    }

    public CustomerRequest<T> avgTotalAmountOfGlobalOrdersAs(String name, GlobalOrderRequest subRequest){
        return statsFromGlobalOrdersAs(name, subRequest.avgTotalAmount(), true);
    }
    public CustomerRequest<T> standardDeviationTotalAmountOfGlobalOrders(){
        return standardDeviationTotalAmountOfGlobalOrdersAs("stdDevTotalAmountOfGlobalOrders");
    }

    public CustomerRequest<T> standardDeviationTotalAmountOfGlobalOrdersAs(String name){
        return standardDeviationTotalAmountOfGlobalOrdersAs(name, Q.globalOrders().unlimited());
    }

    public CustomerRequest<T> standardDeviationTotalAmountOfGlobalOrdersAs(String name, GlobalOrderRequest subRequest){
        return statsFromGlobalOrdersAs(name, subRequest.standardDeviationTotalAmount(), true);
    }
    public CustomerRequest<T> squareRootOfPopulationStandardDeviationTotalAmountOfGlobalOrders(){
        return squareRootOfPopulationStandardDeviationTotalAmountOfGlobalOrdersAs("stdDevPopTotalAmountOfGlobalOrders");
    }

    public CustomerRequest<T> squareRootOfPopulationStandardDeviationTotalAmountOfGlobalOrdersAs(String name){
        return squareRootOfPopulationStandardDeviationTotalAmountOfGlobalOrdersAs(name, Q.globalOrders().unlimited());
    }

    public CustomerRequest<T> squareRootOfPopulationStandardDeviationTotalAmountOfGlobalOrdersAs(String name, GlobalOrderRequest subRequest){
        return statsFromGlobalOrdersAs(name, subRequest.squareRootOfPopulationStandardDeviationTotalAmount(), true);
    }
    public CustomerRequest<T> sampleVarianceTotalAmountOfGlobalOrders(){
        return sampleVarianceTotalAmountOfGlobalOrdersAs("varSampTotalAmountOfGlobalOrders");
    }

    public CustomerRequest<T> sampleVarianceTotalAmountOfGlobalOrdersAs(String name){
        return sampleVarianceTotalAmountOfGlobalOrdersAs(name, Q.globalOrders().unlimited());
    }

    public CustomerRequest<T> sampleVarianceTotalAmountOfGlobalOrdersAs(String name, GlobalOrderRequest subRequest){
        return statsFromGlobalOrdersAs(name, subRequest.sampleVarianceTotalAmount(), true);
    }
    public CustomerRequest<T> samplePopulationVarianceTotalAmountOfGlobalOrders(){
        return samplePopulationVarianceTotalAmountOfGlobalOrdersAs("varPopTotalAmountOfGlobalOrders");
    }

    public CustomerRequest<T> samplePopulationVarianceTotalAmountOfGlobalOrdersAs(String name){
        return samplePopulationVarianceTotalAmountOfGlobalOrdersAs(name, Q.globalOrders().unlimited());
    }

    public CustomerRequest<T> samplePopulationVarianceTotalAmountOfGlobalOrdersAs(String name, GlobalOrderRequest subRequest){
        return statsFromGlobalOrdersAs(name, subRequest.samplePopulationVarianceTotalAmount(), true);
    }
    public CustomerRequest<T> minAmountOfInvoices(){
        return minAmountOfInvoicesAs("minAmountOfInvoices");
    }

    public CustomerRequest<T> minAmountOfInvoicesAs(String name){
        return minAmountOfInvoicesAs(name, Q.invoices().unlimited());
    }

    public CustomerRequest<T> minAmountOfInvoicesAs(String name, InvoiceRequest subRequest){
        return statsFromInvoicesAs(name, subRequest.minAmount(), true);
    }
    public CustomerRequest<T> maxAmountOfInvoices(){
        return maxAmountOfInvoicesAs("maxAmountOfInvoices");
    }

    public CustomerRequest<T> maxAmountOfInvoicesAs(String name){
        return maxAmountOfInvoicesAs(name, Q.invoices().unlimited());
    }

    public CustomerRequest<T> maxAmountOfInvoicesAs(String name, InvoiceRequest subRequest){
        return statsFromInvoicesAs(name, subRequest.maxAmount(), true);
    }
    public CustomerRequest<T> sumAmountOfInvoices(){
        return sumAmountOfInvoicesAs("sumAmountOfInvoices");
    }

    public CustomerRequest<T> sumAmountOfInvoicesAs(String name){
        return sumAmountOfInvoicesAs(name, Q.invoices().unlimited());
    }

    public CustomerRequest<T> sumAmountOfInvoicesAs(String name, InvoiceRequest subRequest){
        return statsFromInvoicesAs(name, subRequest.sumAmount(), true);
    }
    public CustomerRequest<T> avgAmountOfInvoices(){
        return avgAmountOfInvoicesAs("avgAmountOfInvoices");
    }

    public CustomerRequest<T> avgAmountOfInvoicesAs(String name){
        return avgAmountOfInvoicesAs(name, Q.invoices().unlimited());
    }

    public CustomerRequest<T> avgAmountOfInvoicesAs(String name, InvoiceRequest subRequest){
        return statsFromInvoicesAs(name, subRequest.avgAmount(), true);
    }
    public CustomerRequest<T> standardDeviationAmountOfInvoices(){
        return standardDeviationAmountOfInvoicesAs("stdDevAmountOfInvoices");
    }

    public CustomerRequest<T> standardDeviationAmountOfInvoicesAs(String name){
        return standardDeviationAmountOfInvoicesAs(name, Q.invoices().unlimited());
    }

    public CustomerRequest<T> standardDeviationAmountOfInvoicesAs(String name, InvoiceRequest subRequest){
        return statsFromInvoicesAs(name, subRequest.standardDeviationAmount(), true);
    }
    public CustomerRequest<T> squareRootOfPopulationStandardDeviationAmountOfInvoices(){
        return squareRootOfPopulationStandardDeviationAmountOfInvoicesAs("stdDevPopAmountOfInvoices");
    }

    public CustomerRequest<T> squareRootOfPopulationStandardDeviationAmountOfInvoicesAs(String name){
        return squareRootOfPopulationStandardDeviationAmountOfInvoicesAs(name, Q.invoices().unlimited());
    }

    public CustomerRequest<T> squareRootOfPopulationStandardDeviationAmountOfInvoicesAs(String name, InvoiceRequest subRequest){
        return statsFromInvoicesAs(name, subRequest.squareRootOfPopulationStandardDeviationAmount(), true);
    }
    public CustomerRequest<T> sampleVarianceAmountOfInvoices(){
        return sampleVarianceAmountOfInvoicesAs("varSampAmountOfInvoices");
    }

    public CustomerRequest<T> sampleVarianceAmountOfInvoicesAs(String name){
        return sampleVarianceAmountOfInvoicesAs(name, Q.invoices().unlimited());
    }

    public CustomerRequest<T> sampleVarianceAmountOfInvoicesAs(String name, InvoiceRequest subRequest){
        return statsFromInvoicesAs(name, subRequest.sampleVarianceAmount(), true);
    }
    public CustomerRequest<T> samplePopulationVarianceAmountOfInvoices(){
        return samplePopulationVarianceAmountOfInvoicesAs("varPopAmountOfInvoices");
    }

    public CustomerRequest<T> samplePopulationVarianceAmountOfInvoicesAs(String name){
        return samplePopulationVarianceAmountOfInvoicesAs(name, Q.invoices().unlimited());
    }

    public CustomerRequest<T> samplePopulationVarianceAmountOfInvoicesAs(String name, InvoiceRequest subRequest){
        return statsFromInvoicesAs(name, subRequest.samplePopulationVarianceAmount(), true);
    }
    public CustomerRequest<T> minRefundAmountOfReturnRequests(){
        return minRefundAmountOfReturnRequestsAs("minRefundAmountOfReturnRequests");
    }

    public CustomerRequest<T> minRefundAmountOfReturnRequestsAs(String name){
        return minRefundAmountOfReturnRequestsAs(name, Q.returnRequests().unlimited());
    }

    public CustomerRequest<T> minRefundAmountOfReturnRequestsAs(String name, ReturnRequestRequest subRequest){
        return statsFromReturnRequestsAs(name, subRequest.minRefundAmount(), true);
    }
    public CustomerRequest<T> maxRefundAmountOfReturnRequests(){
        return maxRefundAmountOfReturnRequestsAs("maxRefundAmountOfReturnRequests");
    }

    public CustomerRequest<T> maxRefundAmountOfReturnRequestsAs(String name){
        return maxRefundAmountOfReturnRequestsAs(name, Q.returnRequests().unlimited());
    }

    public CustomerRequest<T> maxRefundAmountOfReturnRequestsAs(String name, ReturnRequestRequest subRequest){
        return statsFromReturnRequestsAs(name, subRequest.maxRefundAmount(), true);
    }
    public CustomerRequest<T> sumRefundAmountOfReturnRequests(){
        return sumRefundAmountOfReturnRequestsAs("sumRefundAmountOfReturnRequests");
    }

    public CustomerRequest<T> sumRefundAmountOfReturnRequestsAs(String name){
        return sumRefundAmountOfReturnRequestsAs(name, Q.returnRequests().unlimited());
    }

    public CustomerRequest<T> sumRefundAmountOfReturnRequestsAs(String name, ReturnRequestRequest subRequest){
        return statsFromReturnRequestsAs(name, subRequest.sumRefundAmount(), true);
    }
    public CustomerRequest<T> avgRefundAmountOfReturnRequests(){
        return avgRefundAmountOfReturnRequestsAs("avgRefundAmountOfReturnRequests");
    }

    public CustomerRequest<T> avgRefundAmountOfReturnRequestsAs(String name){
        return avgRefundAmountOfReturnRequestsAs(name, Q.returnRequests().unlimited());
    }

    public CustomerRequest<T> avgRefundAmountOfReturnRequestsAs(String name, ReturnRequestRequest subRequest){
        return statsFromReturnRequestsAs(name, subRequest.avgRefundAmount(), true);
    }
    public CustomerRequest<T> standardDeviationRefundAmountOfReturnRequests(){
        return standardDeviationRefundAmountOfReturnRequestsAs("stdDevRefundAmountOfReturnRequests");
    }

    public CustomerRequest<T> standardDeviationRefundAmountOfReturnRequestsAs(String name){
        return standardDeviationRefundAmountOfReturnRequestsAs(name, Q.returnRequests().unlimited());
    }

    public CustomerRequest<T> standardDeviationRefundAmountOfReturnRequestsAs(String name, ReturnRequestRequest subRequest){
        return statsFromReturnRequestsAs(name, subRequest.standardDeviationRefundAmount(), true);
    }
    public CustomerRequest<T> squareRootOfPopulationStandardDeviationRefundAmountOfReturnRequests(){
        return squareRootOfPopulationStandardDeviationRefundAmountOfReturnRequestsAs("stdDevPopRefundAmountOfReturnRequests");
    }

    public CustomerRequest<T> squareRootOfPopulationStandardDeviationRefundAmountOfReturnRequestsAs(String name){
        return squareRootOfPopulationStandardDeviationRefundAmountOfReturnRequestsAs(name, Q.returnRequests().unlimited());
    }

    public CustomerRequest<T> squareRootOfPopulationStandardDeviationRefundAmountOfReturnRequestsAs(String name, ReturnRequestRequest subRequest){
        return statsFromReturnRequestsAs(name, subRequest.squareRootOfPopulationStandardDeviationRefundAmount(), true);
    }
    public CustomerRequest<T> sampleVarianceRefundAmountOfReturnRequests(){
        return sampleVarianceRefundAmountOfReturnRequestsAs("varSampRefundAmountOfReturnRequests");
    }

    public CustomerRequest<T> sampleVarianceRefundAmountOfReturnRequestsAs(String name){
        return sampleVarianceRefundAmountOfReturnRequestsAs(name, Q.returnRequests().unlimited());
    }

    public CustomerRequest<T> sampleVarianceRefundAmountOfReturnRequestsAs(String name, ReturnRequestRequest subRequest){
        return statsFromReturnRequestsAs(name, subRequest.sampleVarianceRefundAmount(), true);
    }
    public CustomerRequest<T> samplePopulationVarianceRefundAmountOfReturnRequests(){
        return samplePopulationVarianceRefundAmountOfReturnRequestsAs("varPopRefundAmountOfReturnRequests");
    }

    public CustomerRequest<T> samplePopulationVarianceRefundAmountOfReturnRequestsAs(String name){
        return samplePopulationVarianceRefundAmountOfReturnRequestsAs(name, Q.returnRequests().unlimited());
    }

    public CustomerRequest<T> samplePopulationVarianceRefundAmountOfReturnRequestsAs(String name, ReturnRequestRequest subRequest){
        return statsFromReturnRequestsAs(name, subRequest.samplePopulationVarianceRefundAmount(), true);
    }



    /**
     * get topN records
     * @param topN  records number
     */
    public CustomerRequest<T> top(int topN) {
        super.top(topN);
        return this;
    }

    /**
     * get records from offset(inclusive) to offset+size(exclusive)
     * @param offset record offset
     * @param size records number
     */
    public CustomerRequest<T> offset(int offset, int size) {
        super.offset(offset, size);
        return this;
    }

    /**
     * retrieve all records
     */
    public CustomerRequest<T> unlimited() {
        super.unlimited();
        return this;
    }

    /**
     * get records of one page
     * @param pageNumber page number(1-based)
     * @param pageSize page size
     */
    public CustomerRequest<T> page(int pageNumber, int pageSize) {
        int offset = (pageNumber - 1) * pageSize;
        return offset(offset, pageSize);
   }

    /**
     * get records of one page, default page size is 10
     * @param pageNumber page number(1-based)
     */
    public CustomerRequest<T> page(int pageNumber) {
        return page(pageNumber, 10);
   }
}