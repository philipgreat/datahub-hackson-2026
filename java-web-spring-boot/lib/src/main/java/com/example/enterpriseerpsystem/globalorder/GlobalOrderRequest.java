
package com.example.enterpriseerpsystem.globalorder;

import com.example.enterpriseerpsystem.Q;
import com.example.enterpriseerpsystem.customer.Customer;
import com.example.enterpriseerpsystem.customer.CustomerRequest;
import com.example.enterpriseerpsystem.invoice.Invoice;
import com.example.enterpriseerpsystem.invoice.InvoiceRequest;
import com.example.enterpriseerpsystem.orderitem.OrderItem;
import com.example.enterpriseerpsystem.orderitem.OrderItemRequest;
import com.example.enterpriseerpsystem.returnrequest.ReturnRequest;
import com.example.enterpriseerpsystem.returnrequest.ReturnRequestRequest;
import com.example.enterpriseerpsystem.shipment.Shipment;
import com.example.enterpriseerpsystem.shipment.ShipmentRequest;
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

public class GlobalOrderRequest<T extends GlobalOrder> extends BaseRequest<T> {

    /**
     * @deprecated AI agents and business code must use the generated Q facade
     *             instead of constructing request builders directly.
     */
    @Deprecated
    public GlobalOrderRequest(Class<T> returnType){
        super(returnType);
        selectId();
        selectVersion();
    }

    public GlobalOrderRequest<T> comment(String comment){
         super.internalComment(comment);
         return this;
    }

    // purpose() 继承自 BaseRequest，返回 ExecutableRequest（终结方法）

    public GlobalOrderRequest<T> returnType(Class<? extends T> returnType){
        super.setReturnType(returnType);
        return this;
    }

    public GlobalOrderRequest<T> enableAggregationCache(long cacheExpiredMillis){
        super.enableAggregationCache();
        super.aggregateCacheTime(cacheExpiredMillis);
        return this;
    }

    public GlobalOrderRequest<T> enableAggregationCache(){
        return enableAggregationCache(0l);
    }


    public GlobalOrderRequest<T> propagateAggregationCache(long cacheExpiredMillis){
        super.propagateAggregationCache(cacheExpiredMillis);
        return this;
    }

    public GlobalOrderRequest<T> appendSearchCriteria(SearchCriteria searchCriteria){
        return (GlobalOrderRequest<T>)super.appendSearchCriteria(searchCriteria);
    }

    public GlobalOrderRequest<T> filter(String property1, Operator operator, String property2){
        return appendSearchCriteria(new TwoOperatorCriteria(operator, new PropertyReference(property1), new PropertyReference(property2)));
    }


    public GlobalOrderRequest<T> matchingAnyOf(GlobalOrderRequest globalOrder){
        super.internalMatchAny(globalOrder);
        return this;
    }

    public GlobalOrderRequest<T> enhanceChildrenIfNeeded(){
        return this;
    }

    public GlobalOrderRequest<T> withDeletedRows(){
        super.withDeletedRows();
        return this;
    }

    public GlobalOrderRequest<T> deletedRowsOnly(){
        super.deletedRowsOnly();
        return this;
    }

    public GlobalOrderRequest<T> selectSelf(){
        super.selectSelf();
        return selectId().selectShippingAddress().selectTotalAmount().selectCustomerIdOnly().selectOrderDate().selectStatus().selectCreateTime().selectUpdateTime().selectVersion();
    }

    public GlobalOrderRequest<T> selectSelfFields(){
        return selectSelf();
    }

    public GlobalOrderRequest<T> selectAll(){
        super.selectAll();
        return selectId().selectShippingAddress().selectTotalAmount().selectCustomer().selectOrderDate().selectStatus().selectCreateTime().selectUpdateTime().selectVersion();
    }

    public GlobalOrderRequest<T> selectChildren(){
        super.selectAny();
        selectOrderItemList().selectInvoiceList().selectShipmentList().selectReturnRequestList();
        return selectId().selectShippingAddress().selectTotalAmount().selectCustomer().selectOrderDate().selectStatus().selectCreateTime().selectUpdateTime().selectVersion();
    }


    public GlobalOrderRequest<T> selectId(){
       selectProperty(GlobalOrder.ID_PROPERTY);
       return this;
    }

    /**
     * fill the id with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  id) to fetch id property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public GlobalOrderRequest<T> unselectId(){
       unselectProperty(GlobalOrder.ID_PROPERTY);
       return this;
    }
    public GlobalOrderRequest<T> selectShippingAddress(){
       selectProperty(GlobalOrder.SHIPPING_ADDRESS_PROPERTY);
       return this;
    }

    /**
     * fill the shippingAddress with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  shippingAddress) to fetch shippingAddress property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public GlobalOrderRequest<T> unselectShippingAddress(){
       unselectProperty(GlobalOrder.SHIPPING_ADDRESS_PROPERTY);
       return this;
    }
    public GlobalOrderRequest<T> selectTotalAmount(){
       selectProperty(GlobalOrder.TOTAL_AMOUNT_PROPERTY);
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
    public GlobalOrderRequest<T> selectTotalAmount(AggrFunction aggrFunction){
       selectProperty(GlobalOrder.TOTAL_AMOUNT_PROPERTY, aggrFunction);
       return this;
    }


    public GlobalOrderRequest<T> unselectTotalAmount(){
       unselectProperty(GlobalOrder.TOTAL_AMOUNT_PROPERTY);
       return this;
    }
    public GlobalOrderRequest<T> selectCustomerIdOnly(){
       selectProperty(GlobalOrder.CUSTOMER_PROPERTY);
       return this;
    }

    public GlobalOrderRequest<T> selectCustomer(){
        return selectCustomerWith(Q.customers().unlimited().selectSelf());
    }

    public GlobalOrderRequest<T> selectCustomerWith(CustomerRequest customer){
       selectProperty(GlobalOrder.CUSTOMER_PROPERTY);
       enhanceRelation(GlobalOrder.CUSTOMER_PROPERTY, customer);
       return this;
    }

    public GlobalOrderRequest<T> unselectCustomer(){
       unselectProperty(GlobalOrder.CUSTOMER_PROPERTY);
       return this;
    }
    public GlobalOrderRequest<T> selectOrderDate(){
       selectProperty(GlobalOrder.ORDER_DATE_PROPERTY);
       return this;
    }

    /**
     * fill the orderDate with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  orderDate) to fetch orderDate property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public GlobalOrderRequest<T> unselectOrderDate(){
       unselectProperty(GlobalOrder.ORDER_DATE_PROPERTY);
       return this;
    }
    public GlobalOrderRequest<T> selectStatus(){
       selectProperty(GlobalOrder.STATUS_PROPERTY);
       return this;
    }

    /**
     * fill the status with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  status) to fetch status property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public GlobalOrderRequest<T> unselectStatus(){
       unselectProperty(GlobalOrder.STATUS_PROPERTY);
       return this;
    }
    public GlobalOrderRequest<T> selectCreateTime(){
       selectProperty(GlobalOrder.CREATE_TIME_PROPERTY);
       return this;
    }

    /**
     * fill the createTime with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  createTime) to fetch createTime property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public GlobalOrderRequest<T> unselectCreateTime(){
       unselectProperty(GlobalOrder.CREATE_TIME_PROPERTY);
       return this;
    }
    public GlobalOrderRequest<T> selectUpdateTime(){
       selectProperty(GlobalOrder.UPDATE_TIME_PROPERTY);
       return this;
    }

    /**
     * fill the updateTime with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  updateTime) to fetch updateTime property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public GlobalOrderRequest<T> unselectUpdateTime(){
       unselectProperty(GlobalOrder.UPDATE_TIME_PROPERTY);
       return this;
    }
    public GlobalOrderRequest<T> selectVersion(){
       selectProperty(GlobalOrder.VERSION_PROPERTY);
       return this;
    }

    /**
     * fill the version with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  version) to fetch version property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public GlobalOrderRequest<T> unselectVersion(){
       unselectProperty(GlobalOrder.VERSION_PROPERTY);
       return this;
    }
    public GlobalOrderRequest<T> selectOrderItemList(){
       return selectOrderItemListWith(Q.orderItems().selectSelf());
    }

    public GlobalOrderRequest<T> selectOrderItemListWith(OrderItemRequest orderItemList){
       enhanceRelation(GlobalOrder.ORDER_ITEM_LIST_PROPERTY, orderItemList);
       return this;
    }
    public GlobalOrderRequest<T> selectInvoiceList(){
       return selectInvoiceListWith(Q.invoices().selectSelf());
    }

    public GlobalOrderRequest<T> selectInvoiceListWith(InvoiceRequest invoiceList){
       enhanceRelation(GlobalOrder.INVOICE_LIST_PROPERTY, invoiceList);
       return this;
    }
    public GlobalOrderRequest<T> selectShipmentList(){
       return selectShipmentListWith(Q.shipments().selectSelf());
    }

    public GlobalOrderRequest<T> selectShipmentListWith(ShipmentRequest shipmentList){
       enhanceRelation(GlobalOrder.SHIPMENT_LIST_PROPERTY, shipmentList);
       return this;
    }
    public GlobalOrderRequest<T> selectReturnRequestList(){
       return selectReturnRequestListWith(Q.returnRequests().selectSelf());
    }

    public GlobalOrderRequest<T> selectReturnRequestListWith(ReturnRequestRequest returnRequestList){
       enhanceRelation(GlobalOrder.RETURN_REQUEST_LIST_PROPERTY, returnRequestList);
       return this;
    }

    public GlobalOrderRequest<T> withId(Operator operator, Object... values){
       return appendSearchCriteria(createIdCriteria(operator, values));
    }

    public SearchCriteria createIdCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(GlobalOrder.ID_PROPERTY, operator, values);
    }

    public GlobalOrderRequest<T> withIdIs(Long id){
       return withId(Operator.EQUAL, id);
    }
    public GlobalOrderRequest<T> withIdIn(Long... id){
       return withId(Operator.EQUAL, (Object[])id);
    }



    public GlobalOrderRequest<T> filterByShippingAddress(String... shippingAddress){
      if (shippingAddress == null || shippingAddress.length == 0) {
        throw new IllegalArgumentException("filterByShippingAddress parameter shippingAddress cannot be empty");
      }
      return appendSearchCriteria(createShippingAddressCriteria(Operator.EQUAL, (Object[])shippingAddress));
    }

    public GlobalOrderRequest<T> withShippingAddress(Operator operator, Object... values){
       return appendSearchCriteria(createShippingAddressCriteria(operator, values));
    }

    public GlobalOrderRequest<T> withShippingAddressIsUnknown(){
       return withShippingAddress(Operator.IS_NULL);
    }

    public GlobalOrderRequest<T> withShippingAddressIsKnown(){
       return withShippingAddress(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createShippingAddressCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(GlobalOrder.SHIPPING_ADDRESS_PROPERTY, operator, values);
    }

    public GlobalOrderRequest<T> withShippingAddressGreaterThan(String shippingAddress){
       return withShippingAddress(Operator.GREATER_THAN, shippingAddress);
    }

    public GlobalOrderRequest<T> withShippingAddressGreaterThanOrEqualTo(String shippingAddress){
       return withShippingAddress(Operator.GREATER_THAN_OR_EQUAL, shippingAddress);
    }

    public GlobalOrderRequest<T> withShippingAddressLessThan(String shippingAddress){
       return withShippingAddress(Operator.LESS_THAN, shippingAddress);
    }

    public GlobalOrderRequest<T> withShippingAddressLessThanOrEqualTo(String shippingAddress){
       return withShippingAddress(Operator.LESS_THAN_OR_EQUAL, shippingAddress);
    }

    public GlobalOrderRequest<T> withShippingAddressBetween(String startOfShippingAddress, String endOfShippingAddress){
       return withShippingAddress(Operator.BETWEEN, startOfShippingAddress, endOfShippingAddress);
    }
    public GlobalOrderRequest<T> withShippingAddressStartingWith(String shippingAddress){
       return withShippingAddress(Operator.BEGIN_WITH, shippingAddress);
    }
    public GlobalOrderRequest<T> withShippingAddressContaining(String shippingAddress){
       return withShippingAddress(Operator.CONTAIN, shippingAddress);
    }

    public GlobalOrderRequest<T> withShippingAddressEndingWith(String shippingAddress){
       return withShippingAddress(Operator.END_WITH, shippingAddress);
    }

    public GlobalOrderRequest<T> withShippingAddressIs(String shippingAddress){
       return withShippingAddress(Operator.EQUAL, shippingAddress);
    }

    public GlobalOrderRequest<T> withShippingAddressSoundingLike(String shippingAddress){
       return withShippingAddress(Operator.SOUNDS_LIKE, shippingAddress);
    }



    public GlobalOrderRequest<T> filterByTotalAmount(BigDecimal... totalAmount){
      if (totalAmount == null || totalAmount.length == 0) {
        throw new IllegalArgumentException("filterByTotalAmount parameter totalAmount cannot be empty");
      }
      return appendSearchCriteria(createTotalAmountCriteria(Operator.EQUAL, (Object[])totalAmount));
    }

    public GlobalOrderRequest<T> withTotalAmount(Operator operator, Object... values){
       return appendSearchCriteria(createTotalAmountCriteria(operator, values));
    }

    public GlobalOrderRequest<T> withTotalAmountIsUnknown(){
       return withTotalAmount(Operator.IS_NULL);
    }

    public GlobalOrderRequest<T> withTotalAmountIsKnown(){
       return withTotalAmount(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createTotalAmountCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(GlobalOrder.TOTAL_AMOUNT_PROPERTY, operator, values);
    }

    public GlobalOrderRequest<T> withTotalAmountGreaterThan(BigDecimal totalAmount){
       return withTotalAmount(Operator.GREATER_THAN, totalAmount);
    }

    public GlobalOrderRequest<T> withTotalAmountGreaterThanOrEqualTo(BigDecimal totalAmount){
       return withTotalAmount(Operator.GREATER_THAN_OR_EQUAL, totalAmount);
    }

    public GlobalOrderRequest<T> withTotalAmountLessThan(BigDecimal totalAmount){
       return withTotalAmount(Operator.LESS_THAN, totalAmount);
    }

    public GlobalOrderRequest<T> withTotalAmountLessThanOrEqualTo(BigDecimal totalAmount){
       return withTotalAmount(Operator.LESS_THAN_OR_EQUAL, totalAmount);
    }

    public GlobalOrderRequest<T> withTotalAmountBetween(BigDecimal startOfTotalAmount, BigDecimal endOfTotalAmount){
       return withTotalAmount(Operator.BETWEEN, startOfTotalAmount, endOfTotalAmount);
    }



    public GlobalOrderRequest<T> filterByCustomer(Customer... customer){
      if (customer == null || customer.length == 0) {
        throw new IllegalArgumentException("filterByCustomer parameter customer cannot be empty");
      }
      return appendSearchCriteria(createCustomerCriteria(Operator.EQUAL, (Object[])customer));
    }

    public GlobalOrderRequest<T> withCustomer(Operator operator, Object... values){
       return appendSearchCriteria(createCustomerCriteria(operator, values));
    }

    public GlobalOrderRequest<T> withCustomerIsUnknown(){
       return withCustomer(Operator.IS_NULL);
    }

    public GlobalOrderRequest<T> withCustomerIsKnown(){
       return withCustomer(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createCustomerCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(GlobalOrder.CUSTOMER_PROPERTY, operator, values);
    }

    public GlobalOrderRequest<T> filterByCustomer(Long customer){
      if(customer == null){
         return this;
      }
      return withCustomer(Operator.EQUAL, customer);
    }
    public GlobalOrderRequest<T> withCustomerMatching(CustomerRequest customer){
       return appendSearchCriteria(new SubQuerySearchCriteria(GlobalOrder.CUSTOMER_PROPERTY, customer, Customer.ID_PROPERTY));
    }

    public GlobalOrderRequest<T> filterByOrderDate(LocalDateTime... orderDate){
      if (orderDate == null || orderDate.length == 0) {
        throw new IllegalArgumentException("filterByOrderDate parameter orderDate cannot be empty");
      }
      return appendSearchCriteria(createOrderDateCriteria(Operator.EQUAL, (Object[])orderDate));
    }

    public GlobalOrderRequest<T> withOrderDate(Operator operator, Object... values){
       return appendSearchCriteria(createOrderDateCriteria(operator, values));
    }

    public GlobalOrderRequest<T> withOrderDateIsUnknown(){
       return withOrderDate(Operator.IS_NULL);
    }

    public GlobalOrderRequest<T> withOrderDateIsKnown(){
       return withOrderDate(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createOrderDateCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(GlobalOrder.ORDER_DATE_PROPERTY, operator, values);
    }

    public GlobalOrderRequest<T> withOrderDateGreaterThan(LocalDateTime orderDate){
       return withOrderDate(Operator.GREATER_THAN, orderDate);
    }

    public GlobalOrderRequest<T> withOrderDateGreaterThanOrEqualTo(LocalDateTime orderDate){
       return withOrderDate(Operator.GREATER_THAN_OR_EQUAL, orderDate);
    }

    public GlobalOrderRequest<T> withOrderDateLessThan(LocalDateTime orderDate){
       return withOrderDate(Operator.LESS_THAN, orderDate);
    }

    public GlobalOrderRequest<T> withOrderDateLessThanOrEqualTo(LocalDateTime orderDate){
       return withOrderDate(Operator.LESS_THAN_OR_EQUAL, orderDate);
    }

    public GlobalOrderRequest<T> withOrderDateBetween(LocalDateTime startOfOrderDate, LocalDateTime endOfOrderDate){
       return withOrderDate(Operator.BETWEEN, startOfOrderDate, endOfOrderDate);
    }
    public GlobalOrderRequest<T> withOrderDateBefore(LocalDateTime orderDate){
       return withOrderDate(Operator.LESS_THAN, orderDate);
    }

    public GlobalOrderRequest<T> withOrderDateBefore(Date orderDate){
       return withOrderDate(Operator.LESS_THAN, orderDate);
    }

    public GlobalOrderRequest<T> withOrderDateAfter(LocalDateTime orderDate){
       return withOrderDate(Operator.GREATER_THAN, orderDate);
    }

    public GlobalOrderRequest<T> withOrderDateAfter(Date orderDate){
       return withOrderDate(Operator.GREATER_THAN, orderDate);
    }

    public GlobalOrderRequest<T> withOrderDateBetween(Date startOfOrderDate, Date endOfOrderDate){
       return withOrderDate(Operator.BETWEEN, startOfOrderDate, endOfOrderDate);
    }




    public GlobalOrderRequest<T> filterByStatus(String... status){
      if (status == null || status.length == 0) {
        throw new IllegalArgumentException("filterByStatus parameter status cannot be empty");
      }
      return appendSearchCriteria(createStatusCriteria(Operator.EQUAL, (Object[])status));
    }

    public GlobalOrderRequest<T> withStatus(Operator operator, Object... values){
       return appendSearchCriteria(createStatusCriteria(operator, values));
    }

    public GlobalOrderRequest<T> withStatusIsUnknown(){
       return withStatus(Operator.IS_NULL);
    }

    public GlobalOrderRequest<T> withStatusIsKnown(){
       return withStatus(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createStatusCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(GlobalOrder.STATUS_PROPERTY, operator, values);
    }

    public GlobalOrderRequest<T> withStatusGreaterThan(String status){
       return withStatus(Operator.GREATER_THAN, status);
    }

    public GlobalOrderRequest<T> withStatusGreaterThanOrEqualTo(String status){
       return withStatus(Operator.GREATER_THAN_OR_EQUAL, status);
    }

    public GlobalOrderRequest<T> withStatusLessThan(String status){
       return withStatus(Operator.LESS_THAN, status);
    }

    public GlobalOrderRequest<T> withStatusLessThanOrEqualTo(String status){
       return withStatus(Operator.LESS_THAN_OR_EQUAL, status);
    }

    public GlobalOrderRequest<T> withStatusBetween(String startOfStatus, String endOfStatus){
       return withStatus(Operator.BETWEEN, startOfStatus, endOfStatus);
    }
    public GlobalOrderRequest<T> withStatusStartingWith(String status){
       return withStatus(Operator.BEGIN_WITH, status);
    }
    public GlobalOrderRequest<T> withStatusContaining(String status){
       return withStatus(Operator.CONTAIN, status);
    }

    public GlobalOrderRequest<T> withStatusEndingWith(String status){
       return withStatus(Operator.END_WITH, status);
    }

    public GlobalOrderRequest<T> withStatusIs(String status){
       return withStatus(Operator.EQUAL, status);
    }

    public GlobalOrderRequest<T> withStatusSoundingLike(String status){
       return withStatus(Operator.SOUNDS_LIKE, status);
    }



    public GlobalOrderRequest<T> filterByCreateTime(LocalDateTime... createTime){
      if (createTime == null || createTime.length == 0) {
        throw new IllegalArgumentException("filterByCreateTime parameter createTime cannot be empty");
      }
      return appendSearchCriteria(createCreateTimeCriteria(Operator.EQUAL, (Object[])createTime));
    }

    public GlobalOrderRequest<T> withCreateTime(Operator operator, Object... values){
       return appendSearchCriteria(createCreateTimeCriteria(operator, values));
    }

    public GlobalOrderRequest<T> withCreateTimeIsUnknown(){
       return withCreateTime(Operator.IS_NULL);
    }

    public GlobalOrderRequest<T> withCreateTimeIsKnown(){
       return withCreateTime(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createCreateTimeCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(GlobalOrder.CREATE_TIME_PROPERTY, operator, values);
    }

    public GlobalOrderRequest<T> withCreateTimeGreaterThan(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public GlobalOrderRequest<T> withCreateTimeGreaterThanOrEqualTo(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN_OR_EQUAL, createTime);
    }

    public GlobalOrderRequest<T> withCreateTimeLessThan(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public GlobalOrderRequest<T> withCreateTimeLessThanOrEqualTo(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN_OR_EQUAL, createTime);
    }

    public GlobalOrderRequest<T> withCreateTimeBetween(LocalDateTime startOfCreateTime, LocalDateTime endOfCreateTime){
       return withCreateTime(Operator.BETWEEN, startOfCreateTime, endOfCreateTime);
    }
    public GlobalOrderRequest<T> withCreateTimeBefore(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public GlobalOrderRequest<T> withCreateTimeBefore(Date createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public GlobalOrderRequest<T> withCreateTimeAfter(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public GlobalOrderRequest<T> withCreateTimeAfter(Date createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public GlobalOrderRequest<T> withCreateTimeBetween(Date startOfCreateTime, Date endOfCreateTime){
       return withCreateTime(Operator.BETWEEN, startOfCreateTime, endOfCreateTime);
    }




    public GlobalOrderRequest<T> filterByUpdateTime(LocalDateTime... updateTime){
      if (updateTime == null || updateTime.length == 0) {
        throw new IllegalArgumentException("filterByUpdateTime parameter updateTime cannot be empty");
      }
      return appendSearchCriteria(createUpdateTimeCriteria(Operator.EQUAL, (Object[])updateTime));
    }

    public GlobalOrderRequest<T> withUpdateTime(Operator operator, Object... values){
       return appendSearchCriteria(createUpdateTimeCriteria(operator, values));
    }

    public GlobalOrderRequest<T> withUpdateTimeIsUnknown(){
       return withUpdateTime(Operator.IS_NULL);
    }

    public GlobalOrderRequest<T> withUpdateTimeIsKnown(){
       return withUpdateTime(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createUpdateTimeCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(GlobalOrder.UPDATE_TIME_PROPERTY, operator, values);
    }

    public GlobalOrderRequest<T> withUpdateTimeGreaterThan(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public GlobalOrderRequest<T> withUpdateTimeGreaterThanOrEqualTo(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN_OR_EQUAL, updateTime);
    }

    public GlobalOrderRequest<T> withUpdateTimeLessThan(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public GlobalOrderRequest<T> withUpdateTimeLessThanOrEqualTo(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN_OR_EQUAL, updateTime);
    }

    public GlobalOrderRequest<T> withUpdateTimeBetween(LocalDateTime startOfUpdateTime, LocalDateTime endOfUpdateTime){
       return withUpdateTime(Operator.BETWEEN, startOfUpdateTime, endOfUpdateTime);
    }
    public GlobalOrderRequest<T> withUpdateTimeBefore(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public GlobalOrderRequest<T> withUpdateTimeBefore(Date updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public GlobalOrderRequest<T> withUpdateTimeAfter(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public GlobalOrderRequest<T> withUpdateTimeAfter(Date updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public GlobalOrderRequest<T> withUpdateTimeBetween(Date startOfUpdateTime, Date endOfUpdateTime){
       return withUpdateTime(Operator.BETWEEN, startOfUpdateTime, endOfUpdateTime);
    }




    public GlobalOrderRequest<T> filterByVersion(Long... version){
      if (version == null || version.length == 0) {
        throw new IllegalArgumentException("filterByVersion parameter version cannot be empty");
      }
      return appendSearchCriteria(createVersionCriteria(Operator.EQUAL, (Object[])version));
    }

    public GlobalOrderRequest<T> withVersion(Operator operator, Object... values){
       return appendSearchCriteria(createVersionCriteria(operator, values));
    }

    public GlobalOrderRequest<T> withVersionIsUnknown(){
       return withVersion(Operator.IS_NULL);
    }

    public GlobalOrderRequest<T> withVersionIsKnown(){
       return withVersion(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createVersionCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(GlobalOrder.VERSION_PROPERTY, operator, values);
    }

    public GlobalOrderRequest<T> withVersionGreaterThan(Long version){
       return withVersion(Operator.GREATER_THAN, version);
    }

    public GlobalOrderRequest<T> withVersionGreaterThanOrEqualTo(Long version){
       return withVersion(Operator.GREATER_THAN_OR_EQUAL, version);
    }

    public GlobalOrderRequest<T> withVersionLessThan(Long version){
       return withVersion(Operator.LESS_THAN, version);
    }

    public GlobalOrderRequest<T> withVersionLessThanOrEqualTo(Long version){
       return withVersion(Operator.LESS_THAN_OR_EQUAL, version);
    }

    public GlobalOrderRequest<T> withVersionBetween(Long startOfVersion, Long endOfVersion){
       return withVersion(Operator.BETWEEN, startOfVersion, endOfVersion);
    }

    public GlobalOrderRequest<T> withOrderItemListMatching(OrderItemRequest orderItemRequest){
        return appendSearchCriteria(new SubQuerySearchCriteria(GlobalOrder.ID_PROPERTY, orderItemRequest, OrderItem.GLOBAL_ORDER_PROPERTY));
    }

    public GlobalOrderRequest<T> withoutOrderItemListMatching(OrderItemRequest orderItemRequest){
        return appendSearchCriteria(SearchCriteria.not(new SubQuerySearchCriteria(GlobalOrder.ID_PROPERTY, orderItemRequest, OrderItem.GLOBAL_ORDER_PROPERTY)));
    }

    public GlobalOrderRequest<T> haveOrderItems(){
        return withOrderItemListMatching(Q.orderItems().unlimited());
    }

    public GlobalOrderRequest<T> haveNoOrderItems(){
        return withoutOrderItemListMatching(Q.orderItems().unlimited());
    }
    public GlobalOrderRequest<T> withInvoiceListMatching(InvoiceRequest invoiceRequest){
        return appendSearchCriteria(new SubQuerySearchCriteria(GlobalOrder.ID_PROPERTY, invoiceRequest, Invoice.GLOBAL_ORDER_PROPERTY));
    }

    public GlobalOrderRequest<T> withoutInvoiceListMatching(InvoiceRequest invoiceRequest){
        return appendSearchCriteria(SearchCriteria.not(new SubQuerySearchCriteria(GlobalOrder.ID_PROPERTY, invoiceRequest, Invoice.GLOBAL_ORDER_PROPERTY)));
    }

    public GlobalOrderRequest<T> haveInvoices(){
        return withInvoiceListMatching(Q.invoices().unlimited());
    }

    public GlobalOrderRequest<T> haveNoInvoices(){
        return withoutInvoiceListMatching(Q.invoices().unlimited());
    }
    public GlobalOrderRequest<T> withShipmentListMatching(ShipmentRequest shipmentRequest){
        return appendSearchCriteria(new SubQuerySearchCriteria(GlobalOrder.ID_PROPERTY, shipmentRequest, Shipment.GLOBAL_ORDER_PROPERTY));
    }

    public GlobalOrderRequest<T> withoutShipmentListMatching(ShipmentRequest shipmentRequest){
        return appendSearchCriteria(SearchCriteria.not(new SubQuerySearchCriteria(GlobalOrder.ID_PROPERTY, shipmentRequest, Shipment.GLOBAL_ORDER_PROPERTY)));
    }

    public GlobalOrderRequest<T> haveShipments(){
        return withShipmentListMatching(Q.shipments().unlimited());
    }

    public GlobalOrderRequest<T> haveNoShipments(){
        return withoutShipmentListMatching(Q.shipments().unlimited());
    }
    public GlobalOrderRequest<T> withReturnRequestListMatching(ReturnRequestRequest returnRequestRequest){
        return appendSearchCriteria(new SubQuerySearchCriteria(GlobalOrder.ID_PROPERTY, returnRequestRequest, ReturnRequest.GLOBAL_ORDER_PROPERTY));
    }

    public GlobalOrderRequest<T> withoutReturnRequestListMatching(ReturnRequestRequest returnRequestRequest){
        return appendSearchCriteria(SearchCriteria.not(new SubQuerySearchCriteria(GlobalOrder.ID_PROPERTY, returnRequestRequest, ReturnRequest.GLOBAL_ORDER_PROPERTY)));
    }

    public GlobalOrderRequest<T> haveReturnRequests(){
        return withReturnRequestListMatching(Q.returnRequests().unlimited());
    }

    public GlobalOrderRequest<T> haveNoReturnRequests(){
        return withoutReturnRequestListMatching(Q.returnRequests().unlimited());
    }

    public GlobalOrderRequest<T> count(){
        super.count();
        return this;
    }
    public GlobalOrderRequest<T> countAs(String retName){
        super.count(retName);
        return this;
    }
    public GlobalOrderRequest minTotalAmount(){
        return minTotalAmountAs(prefix("minOf",GlobalOrder.TOTAL_AMOUNT_PROPERTY));
    }

    public GlobalOrderRequest minTotalAmountAs(String retName){
        super.min(retName, GlobalOrder.TOTAL_AMOUNT_PROPERTY);
        return this;
    }
    public GlobalOrderRequest maxTotalAmount(){
        return maxTotalAmountAs(prefix("maxOf",GlobalOrder.TOTAL_AMOUNT_PROPERTY));
    }

    public GlobalOrderRequest maxTotalAmountAs(String retName){
        super.max(retName, GlobalOrder.TOTAL_AMOUNT_PROPERTY);
        return this;
    }
    public GlobalOrderRequest sumTotalAmount(){
        return sumTotalAmountAs(prefix("sumOf",GlobalOrder.TOTAL_AMOUNT_PROPERTY));
    }

    public GlobalOrderRequest sumTotalAmountAs(String retName){
        super.sum(retName, GlobalOrder.TOTAL_AMOUNT_PROPERTY);
        return this;
    }
    public GlobalOrderRequest avgTotalAmount(){
        return avgTotalAmountAs(prefix("avgOf",GlobalOrder.TOTAL_AMOUNT_PROPERTY));
    }

    public GlobalOrderRequest avgTotalAmountAs(String retName){
        super.avg(retName, GlobalOrder.TOTAL_AMOUNT_PROPERTY);
        return this;
    }
    public GlobalOrderRequest standardDeviationTotalAmount(){
        return standardDeviationTotalAmountAs(prefix("standardDeviationOf",GlobalOrder.TOTAL_AMOUNT_PROPERTY));
    }

    public GlobalOrderRequest standardDeviationTotalAmountAs(String retName){
        super.standardDeviation(retName, GlobalOrder.TOTAL_AMOUNT_PROPERTY);
        return this;
    }
    public GlobalOrderRequest squareRootOfPopulationStandardDeviationTotalAmount(){
        return squareRootOfPopulationStandardDeviationTotalAmountAs(prefix("squareRootOfPopulationStandardDeviationOf",GlobalOrder.TOTAL_AMOUNT_PROPERTY));
    }

    public GlobalOrderRequest squareRootOfPopulationStandardDeviationTotalAmountAs(String retName){
        super.squareRootOfPopulationStandardDeviation(retName, GlobalOrder.TOTAL_AMOUNT_PROPERTY);
        return this;
    }
    public GlobalOrderRequest sampleVarianceTotalAmount(){
        return sampleVarianceTotalAmountAs(prefix("sampleVarianceOf",GlobalOrder.TOTAL_AMOUNT_PROPERTY));
    }

    public GlobalOrderRequest sampleVarianceTotalAmountAs(String retName){
        super.sampleVariance(retName, GlobalOrder.TOTAL_AMOUNT_PROPERTY);
        return this;
    }
    public GlobalOrderRequest samplePopulationVarianceTotalAmount(){
        return samplePopulationVarianceTotalAmountAs(prefix("samplePopulationVarianceOf",GlobalOrder.TOTAL_AMOUNT_PROPERTY));
    }

    public GlobalOrderRequest samplePopulationVarianceTotalAmountAs(String retName){
        super.samplePopulationVariance(retName, GlobalOrder.TOTAL_AMOUNT_PROPERTY);
        return this;
    }
    public GlobalOrderRequest<T> groupByCustomerWithDetails(){
       return groupByCustomerWithDetails(Q.customers().unlimited());
    }

    public GlobalOrderRequest<T> groupByCustomerWithDetails(CustomerRequest subRequest){
       aggregate(GlobalOrder.CUSTOMER_PROPERTY, subRequest);
       return this;
    }






    public GlobalOrderRequest<T> groupByOrderItemsWithDetails(OrderItemRequest subRequest){
       aggregate(GlobalOrder.ORDER_ITEM_LIST_PROPERTY, subRequest);
       return this;
    }
    public GlobalOrderRequest<T> groupByInvoicesWithDetails(InvoiceRequest subRequest){
       aggregate(GlobalOrder.INVOICE_LIST_PROPERTY, subRequest);
       return this;
    }
    public GlobalOrderRequest<T> groupByShipmentsWithDetails(ShipmentRequest subRequest){
       aggregate(GlobalOrder.SHIPMENT_LIST_PROPERTY, subRequest);
       return this;
    }
    public GlobalOrderRequest<T> groupByReturnRequestsWithDetails(ReturnRequestRequest subRequest){
       aggregate(GlobalOrder.RETURN_REQUEST_LIST_PROPERTY, subRequest);
       return this;
    }

    public GlobalOrderRequest<T> groupById(){
       groupBy(GlobalOrder.ID_PROPERTY);
       return this;
    }

    public GlobalOrderRequest<T> groupByIdAs(String retName){
       groupBy(retName, GlobalOrder.ID_PROPERTY);
       return this;
    }

    public GlobalOrderRequest<T> groupByIdWithFunction(String retName, AggrFunction function){
       groupBy(retName, GlobalOrder.ID_PROPERTY, function);
       return this;
    }

    public GlobalOrderRequest<T> groupByShippingAddress(){
       groupBy(GlobalOrder.SHIPPING_ADDRESS_PROPERTY);
       return this;
    }

    public GlobalOrderRequest<T> groupByShippingAddressAs(String retName){
       groupBy(retName, GlobalOrder.SHIPPING_ADDRESS_PROPERTY);
       return this;
    }

    public GlobalOrderRequest<T> groupByShippingAddressWithFunction(String retName, AggrFunction function){
       groupBy(retName, GlobalOrder.SHIPPING_ADDRESS_PROPERTY, function);
       return this;
    }

    public GlobalOrderRequest<T> groupByTotalAmount(){
       groupBy(GlobalOrder.TOTAL_AMOUNT_PROPERTY);
       return this;
    }

    public GlobalOrderRequest<T> groupByTotalAmountAs(String retName){
       groupBy(retName, GlobalOrder.TOTAL_AMOUNT_PROPERTY);
       return this;
    }

    public GlobalOrderRequest<T> groupByTotalAmountWithFunction(String retName, AggrFunction function){
       groupBy(retName, GlobalOrder.TOTAL_AMOUNT_PROPERTY, function);
       return this;
    }
    public GlobalOrderRequest<T> groupByCustomerWith(CustomerRequest subRequest){
       groupBy(GlobalOrder.CUSTOMER_PROPERTY, subRequest);
       return this;
    }
    public GlobalOrderRequest<T> groupByCustomer(){
       groupBy(GlobalOrder.CUSTOMER_PROPERTY);
       return this;
    }

    public GlobalOrderRequest<T> groupByCustomerAs(String retName){
       groupBy(retName, GlobalOrder.CUSTOMER_PROPERTY);
       return this;
    }

    public GlobalOrderRequest<T> groupByCustomerWithFunction(String retName, AggrFunction function){
       groupBy(retName, GlobalOrder.CUSTOMER_PROPERTY, function);
       return this;
    }

    public GlobalOrderRequest<T> groupByOrderDate(){
       groupBy(GlobalOrder.ORDER_DATE_PROPERTY);
       return this;
    }

    public GlobalOrderRequest<T> groupByOrderDateAs(String retName){
       groupBy(retName, GlobalOrder.ORDER_DATE_PROPERTY);
       return this;
    }

    public GlobalOrderRequest<T> groupByOrderDateWithFunction(String retName, AggrFunction function){
       groupBy(retName, GlobalOrder.ORDER_DATE_PROPERTY, function);
       return this;
    }

    public GlobalOrderRequest<T> groupByStatus(){
       groupBy(GlobalOrder.STATUS_PROPERTY);
       return this;
    }

    public GlobalOrderRequest<T> groupByStatusAs(String retName){
       groupBy(retName, GlobalOrder.STATUS_PROPERTY);
       return this;
    }

    public GlobalOrderRequest<T> groupByStatusWithFunction(String retName, AggrFunction function){
       groupBy(retName, GlobalOrder.STATUS_PROPERTY, function);
       return this;
    }

    public GlobalOrderRequest<T> groupByCreateTime(){
       groupBy(GlobalOrder.CREATE_TIME_PROPERTY);
       return this;
    }

    public GlobalOrderRequest<T> groupByCreateTimeAs(String retName){
       groupBy(retName, GlobalOrder.CREATE_TIME_PROPERTY);
       return this;
    }

    public GlobalOrderRequest<T> groupByCreateTimeWithFunction(String retName, AggrFunction function){
       groupBy(retName, GlobalOrder.CREATE_TIME_PROPERTY, function);
       return this;
    }

    public GlobalOrderRequest<T> groupByUpdateTime(){
       groupBy(GlobalOrder.UPDATE_TIME_PROPERTY);
       return this;
    }

    public GlobalOrderRequest<T> groupByUpdateTimeAs(String retName){
       groupBy(retName, GlobalOrder.UPDATE_TIME_PROPERTY);
       return this;
    }

    public GlobalOrderRequest<T> groupByUpdateTimeWithFunction(String retName, AggrFunction function){
       groupBy(retName, GlobalOrder.UPDATE_TIME_PROPERTY, function);
       return this;
    }

    public GlobalOrderRequest<T> groupByVersion(){
       groupBy(GlobalOrder.VERSION_PROPERTY);
       return this;
    }

    public GlobalOrderRequest<T> groupByVersionAs(String retName){
       groupBy(retName, GlobalOrder.VERSION_PROPERTY);
       return this;
    }

    public GlobalOrderRequest<T> groupByVersionWithFunction(String retName, AggrFunction function){
       groupBy(retName, GlobalOrder.VERSION_PROPERTY, function);
       return this;
    }



    public GlobalOrderRequest<T> orderByIdAscending(){
       addOrderByAscending(GlobalOrder.ID_PROPERTY);
       return this;
    }

    public GlobalOrderRequest<T> orderByIdDescending(){
       addOrderByDescending(GlobalOrder.ID_PROPERTY);
       return this;
    }

    public GlobalOrderRequest<T> orderByShippingAddressAscending(){
       addOrderByAscending(GlobalOrder.SHIPPING_ADDRESS_PROPERTY);
       return this;
    }

    public GlobalOrderRequest<T> orderByShippingAddressDescending(){
       addOrderByDescending(GlobalOrder.SHIPPING_ADDRESS_PROPERTY);
       return this;
    }
    public GlobalOrderRequest<T> orderByShippingAddressAscendingUsingGBK(){
       addOrderByAscendingUsingGBK(GlobalOrder.SHIPPING_ADDRESS_PROPERTY);
       return this;
    }

    public GlobalOrderRequest<T> orderByShippingAddressDescendingUsingGBK(){
       addOrderByDescendingUsingGBK(GlobalOrder.SHIPPING_ADDRESS_PROPERTY);
       return this;
    }
    public GlobalOrderRequest<T> orderByTotalAmountAscending(){
       addOrderByAscending(GlobalOrder.TOTAL_AMOUNT_PROPERTY);
       return this;
    }

    public GlobalOrderRequest<T> orderByTotalAmountDescending(){
       addOrderByDescending(GlobalOrder.TOTAL_AMOUNT_PROPERTY);
       return this;
    }

    public GlobalOrderRequest<T> orderByCustomerAscending(){
       addOrderByAscending(GlobalOrder.CUSTOMER_PROPERTY);
       return this;
    }

    public GlobalOrderRequest<T> orderByCustomerDescending(){
       addOrderByDescending(GlobalOrder.CUSTOMER_PROPERTY);
       return this;
    }

    public GlobalOrderRequest<T> orderByOrderDateAscending(){
       addOrderByAscending(GlobalOrder.ORDER_DATE_PROPERTY);
       return this;
    }

    public GlobalOrderRequest<T> orderByOrderDateDescending(){
       addOrderByDescending(GlobalOrder.ORDER_DATE_PROPERTY);
       return this;
    }

    public GlobalOrderRequest<T> orderByStatusAscending(){
       addOrderByAscending(GlobalOrder.STATUS_PROPERTY);
       return this;
    }

    public GlobalOrderRequest<T> orderByStatusDescending(){
       addOrderByDescending(GlobalOrder.STATUS_PROPERTY);
       return this;
    }
    public GlobalOrderRequest<T> orderByStatusAscendingUsingGBK(){
       addOrderByAscendingUsingGBK(GlobalOrder.STATUS_PROPERTY);
       return this;
    }

    public GlobalOrderRequest<T> orderByStatusDescendingUsingGBK(){
       addOrderByDescendingUsingGBK(GlobalOrder.STATUS_PROPERTY);
       return this;
    }
    public GlobalOrderRequest<T> orderByCreateTimeAscending(){
       addOrderByAscending(GlobalOrder.CREATE_TIME_PROPERTY);
       return this;
    }

    public GlobalOrderRequest<T> orderByCreateTimeDescending(){
       addOrderByDescending(GlobalOrder.CREATE_TIME_PROPERTY);
       return this;
    }

    public GlobalOrderRequest<T> orderByUpdateTimeAscending(){
       addOrderByAscending(GlobalOrder.UPDATE_TIME_PROPERTY);
       return this;
    }

    public GlobalOrderRequest<T> orderByUpdateTimeDescending(){
       addOrderByDescending(GlobalOrder.UPDATE_TIME_PROPERTY);
       return this;
    }

    public GlobalOrderRequest<T> orderByVersionAscending(){
       addOrderByAscending(GlobalOrder.VERSION_PROPERTY);
       return this;
    }

    public GlobalOrderRequest<T> orderByVersionDescending(){
       addOrderByDescending(GlobalOrder.VERSION_PROPERTY);
       return this;
    }


    public GlobalOrderRequest<T> statsFromOrderItemsAs(String name, OrderItemRequest subRequest){
       return statsFromOrderItemsAs(name, subRequest, false);
    }

    public GlobalOrderRequest<T> statsFromOrderItemsAs(String name, OrderItemRequest subRequest, boolean singleResult){
       subRequest.setPartitionProperty(OrderItem.GLOBAL_ORDER_PROPERTY);
       addAggregateDynamicProperty(name, subRequest, singleResult);
       return this;
    }

    public GlobalOrderRequest<T> statsFromOrderItems(OrderItemRequest subRequest){
       return statsFromOrderItemsAs(REFINEMENTS, subRequest);
    }
    public GlobalOrderRequest<T> statsFromInvoicesAs(String name, InvoiceRequest subRequest){
       return statsFromInvoicesAs(name, subRequest, false);
    }

    public GlobalOrderRequest<T> statsFromInvoicesAs(String name, InvoiceRequest subRequest, boolean singleResult){
       subRequest.setPartitionProperty(Invoice.GLOBAL_ORDER_PROPERTY);
       addAggregateDynamicProperty(name, subRequest, singleResult);
       return this;
    }

    public GlobalOrderRequest<T> statsFromInvoices(InvoiceRequest subRequest){
       return statsFromInvoicesAs(REFINEMENTS, subRequest);
    }
    public GlobalOrderRequest<T> statsFromShipmentsAs(String name, ShipmentRequest subRequest){
       return statsFromShipmentsAs(name, subRequest, false);
    }

    public GlobalOrderRequest<T> statsFromShipmentsAs(String name, ShipmentRequest subRequest, boolean singleResult){
       subRequest.setPartitionProperty(Shipment.GLOBAL_ORDER_PROPERTY);
       addAggregateDynamicProperty(name, subRequest, singleResult);
       return this;
    }

    public GlobalOrderRequest<T> statsFromShipments(ShipmentRequest subRequest){
       return statsFromShipmentsAs(REFINEMENTS, subRequest);
    }
    public GlobalOrderRequest<T> statsFromReturnRequestsAs(String name, ReturnRequestRequest subRequest){
       return statsFromReturnRequestsAs(name, subRequest, false);
    }

    public GlobalOrderRequest<T> statsFromReturnRequestsAs(String name, ReturnRequestRequest subRequest, boolean singleResult){
       subRequest.setPartitionProperty(ReturnRequest.GLOBAL_ORDER_PROPERTY);
       addAggregateDynamicProperty(name, subRequest, singleResult);
       return this;
    }

    public GlobalOrderRequest<T> statsFromReturnRequests(ReturnRequestRequest subRequest){
       return statsFromReturnRequestsAs(REFINEMENTS, subRequest);
    }
    public CustomerRequest rollUpToCustomer(){
       CustomerRequest customer = Q.customers().unlimited();
       this.withCustomerMatching(customer)
           .groupByCustomerWith(customer);
       return customer;
    }






    public GlobalOrderRequest<T> countOrderItems(){
        return countOrderItemsAs("Count");
    }

    public GlobalOrderRequest<T> countOrderItemsAs(String name){
        return countOrderItemsWith(name, Q.orderItems().unlimited());
    }

    public GlobalOrderRequest<T> countOrderItemsWith(String name, OrderItemRequest subRequest){
        return statsFromOrderItemsAs(name, subRequest.count(), true);
    }
    public GlobalOrderRequest<T> countInvoices(){
        return countInvoicesAs("Count");
    }

    public GlobalOrderRequest<T> countInvoicesAs(String name){
        return countInvoicesWith(name, Q.invoices().unlimited());
    }

    public GlobalOrderRequest<T> countInvoicesWith(String name, InvoiceRequest subRequest){
        return statsFromInvoicesAs(name, subRequest.count(), true);
    }
    public GlobalOrderRequest<T> countShipments(){
        return countShipmentsAs("Count");
    }

    public GlobalOrderRequest<T> countShipmentsAs(String name){
        return countShipmentsWith(name, Q.shipments().unlimited());
    }

    public GlobalOrderRequest<T> countShipmentsWith(String name, ShipmentRequest subRequest){
        return statsFromShipmentsAs(name, subRequest.count(), true);
    }
    public GlobalOrderRequest<T> countReturnRequests(){
        return countReturnRequestsAs("Count");
    }

    public GlobalOrderRequest<T> countReturnRequestsAs(String name){
        return countReturnRequestsWith(name, Q.returnRequests().unlimited());
    }

    public GlobalOrderRequest<T> countReturnRequestsWith(String name, ReturnRequestRequest subRequest){
        return statsFromReturnRequestsAs(name, subRequest.count(), true);
    }
    public GlobalOrderRequest<T> minUnitPriceOfOrderItems(){
        return minUnitPriceOfOrderItemsAs("minUnitPriceOfOrderItems");
    }

    public GlobalOrderRequest<T> minUnitPriceOfOrderItemsAs(String name){
        return minUnitPriceOfOrderItemsAs(name, Q.orderItems().unlimited());
    }

    public GlobalOrderRequest<T> minUnitPriceOfOrderItemsAs(String name, OrderItemRequest subRequest){
        return statsFromOrderItemsAs(name, subRequest.minUnitPrice(), true);
    }
    public GlobalOrderRequest<T> maxUnitPriceOfOrderItems(){
        return maxUnitPriceOfOrderItemsAs("maxUnitPriceOfOrderItems");
    }

    public GlobalOrderRequest<T> maxUnitPriceOfOrderItemsAs(String name){
        return maxUnitPriceOfOrderItemsAs(name, Q.orderItems().unlimited());
    }

    public GlobalOrderRequest<T> maxUnitPriceOfOrderItemsAs(String name, OrderItemRequest subRequest){
        return statsFromOrderItemsAs(name, subRequest.maxUnitPrice(), true);
    }
    public GlobalOrderRequest<T> sumUnitPriceOfOrderItems(){
        return sumUnitPriceOfOrderItemsAs("sumUnitPriceOfOrderItems");
    }

    public GlobalOrderRequest<T> sumUnitPriceOfOrderItemsAs(String name){
        return sumUnitPriceOfOrderItemsAs(name, Q.orderItems().unlimited());
    }

    public GlobalOrderRequest<T> sumUnitPriceOfOrderItemsAs(String name, OrderItemRequest subRequest){
        return statsFromOrderItemsAs(name, subRequest.sumUnitPrice(), true);
    }
    public GlobalOrderRequest<T> avgUnitPriceOfOrderItems(){
        return avgUnitPriceOfOrderItemsAs("avgUnitPriceOfOrderItems");
    }

    public GlobalOrderRequest<T> avgUnitPriceOfOrderItemsAs(String name){
        return avgUnitPriceOfOrderItemsAs(name, Q.orderItems().unlimited());
    }

    public GlobalOrderRequest<T> avgUnitPriceOfOrderItemsAs(String name, OrderItemRequest subRequest){
        return statsFromOrderItemsAs(name, subRequest.avgUnitPrice(), true);
    }
    public GlobalOrderRequest<T> standardDeviationUnitPriceOfOrderItems(){
        return standardDeviationUnitPriceOfOrderItemsAs("stdDevUnitPriceOfOrderItems");
    }

    public GlobalOrderRequest<T> standardDeviationUnitPriceOfOrderItemsAs(String name){
        return standardDeviationUnitPriceOfOrderItemsAs(name, Q.orderItems().unlimited());
    }

    public GlobalOrderRequest<T> standardDeviationUnitPriceOfOrderItemsAs(String name, OrderItemRequest subRequest){
        return statsFromOrderItemsAs(name, subRequest.standardDeviationUnitPrice(), true);
    }
    public GlobalOrderRequest<T> squareRootOfPopulationStandardDeviationUnitPriceOfOrderItems(){
        return squareRootOfPopulationStandardDeviationUnitPriceOfOrderItemsAs("stdDevPopUnitPriceOfOrderItems");
    }

    public GlobalOrderRequest<T> squareRootOfPopulationStandardDeviationUnitPriceOfOrderItemsAs(String name){
        return squareRootOfPopulationStandardDeviationUnitPriceOfOrderItemsAs(name, Q.orderItems().unlimited());
    }

    public GlobalOrderRequest<T> squareRootOfPopulationStandardDeviationUnitPriceOfOrderItemsAs(String name, OrderItemRequest subRequest){
        return statsFromOrderItemsAs(name, subRequest.squareRootOfPopulationStandardDeviationUnitPrice(), true);
    }
    public GlobalOrderRequest<T> sampleVarianceUnitPriceOfOrderItems(){
        return sampleVarianceUnitPriceOfOrderItemsAs("varSampUnitPriceOfOrderItems");
    }

    public GlobalOrderRequest<T> sampleVarianceUnitPriceOfOrderItemsAs(String name){
        return sampleVarianceUnitPriceOfOrderItemsAs(name, Q.orderItems().unlimited());
    }

    public GlobalOrderRequest<T> sampleVarianceUnitPriceOfOrderItemsAs(String name, OrderItemRequest subRequest){
        return statsFromOrderItemsAs(name, subRequest.sampleVarianceUnitPrice(), true);
    }
    public GlobalOrderRequest<T> samplePopulationVarianceUnitPriceOfOrderItems(){
        return samplePopulationVarianceUnitPriceOfOrderItemsAs("varPopUnitPriceOfOrderItems");
    }

    public GlobalOrderRequest<T> samplePopulationVarianceUnitPriceOfOrderItemsAs(String name){
        return samplePopulationVarianceUnitPriceOfOrderItemsAs(name, Q.orderItems().unlimited());
    }

    public GlobalOrderRequest<T> samplePopulationVarianceUnitPriceOfOrderItemsAs(String name, OrderItemRequest subRequest){
        return statsFromOrderItemsAs(name, subRequest.samplePopulationVarianceUnitPrice(), true);
    }
    public GlobalOrderRequest<T> minQuantityOfOrderItems(){
        return minQuantityOfOrderItemsAs("minQuantityOfOrderItems");
    }

    public GlobalOrderRequest<T> minQuantityOfOrderItemsAs(String name){
        return minQuantityOfOrderItemsAs(name, Q.orderItems().unlimited());
    }

    public GlobalOrderRequest<T> minQuantityOfOrderItemsAs(String name, OrderItemRequest subRequest){
        return statsFromOrderItemsAs(name, subRequest.minQuantity(), true);
    }
    public GlobalOrderRequest<T> maxQuantityOfOrderItems(){
        return maxQuantityOfOrderItemsAs("maxQuantityOfOrderItems");
    }

    public GlobalOrderRequest<T> maxQuantityOfOrderItemsAs(String name){
        return maxQuantityOfOrderItemsAs(name, Q.orderItems().unlimited());
    }

    public GlobalOrderRequest<T> maxQuantityOfOrderItemsAs(String name, OrderItemRequest subRequest){
        return statsFromOrderItemsAs(name, subRequest.maxQuantity(), true);
    }
    public GlobalOrderRequest<T> sumQuantityOfOrderItems(){
        return sumQuantityOfOrderItemsAs("sumQuantityOfOrderItems");
    }

    public GlobalOrderRequest<T> sumQuantityOfOrderItemsAs(String name){
        return sumQuantityOfOrderItemsAs(name, Q.orderItems().unlimited());
    }

    public GlobalOrderRequest<T> sumQuantityOfOrderItemsAs(String name, OrderItemRequest subRequest){
        return statsFromOrderItemsAs(name, subRequest.sumQuantity(), true);
    }
    public GlobalOrderRequest<T> avgQuantityOfOrderItems(){
        return avgQuantityOfOrderItemsAs("avgQuantityOfOrderItems");
    }

    public GlobalOrderRequest<T> avgQuantityOfOrderItemsAs(String name){
        return avgQuantityOfOrderItemsAs(name, Q.orderItems().unlimited());
    }

    public GlobalOrderRequest<T> avgQuantityOfOrderItemsAs(String name, OrderItemRequest subRequest){
        return statsFromOrderItemsAs(name, subRequest.avgQuantity(), true);
    }
    public GlobalOrderRequest<T> standardDeviationQuantityOfOrderItems(){
        return standardDeviationQuantityOfOrderItemsAs("stdDevQuantityOfOrderItems");
    }

    public GlobalOrderRequest<T> standardDeviationQuantityOfOrderItemsAs(String name){
        return standardDeviationQuantityOfOrderItemsAs(name, Q.orderItems().unlimited());
    }

    public GlobalOrderRequest<T> standardDeviationQuantityOfOrderItemsAs(String name, OrderItemRequest subRequest){
        return statsFromOrderItemsAs(name, subRequest.standardDeviationQuantity(), true);
    }
    public GlobalOrderRequest<T> squareRootOfPopulationStandardDeviationQuantityOfOrderItems(){
        return squareRootOfPopulationStandardDeviationQuantityOfOrderItemsAs("stdDevPopQuantityOfOrderItems");
    }

    public GlobalOrderRequest<T> squareRootOfPopulationStandardDeviationQuantityOfOrderItemsAs(String name){
        return squareRootOfPopulationStandardDeviationQuantityOfOrderItemsAs(name, Q.orderItems().unlimited());
    }

    public GlobalOrderRequest<T> squareRootOfPopulationStandardDeviationQuantityOfOrderItemsAs(String name, OrderItemRequest subRequest){
        return statsFromOrderItemsAs(name, subRequest.squareRootOfPopulationStandardDeviationQuantity(), true);
    }
    public GlobalOrderRequest<T> sampleVarianceQuantityOfOrderItems(){
        return sampleVarianceQuantityOfOrderItemsAs("varSampQuantityOfOrderItems");
    }

    public GlobalOrderRequest<T> sampleVarianceQuantityOfOrderItemsAs(String name){
        return sampleVarianceQuantityOfOrderItemsAs(name, Q.orderItems().unlimited());
    }

    public GlobalOrderRequest<T> sampleVarianceQuantityOfOrderItemsAs(String name, OrderItemRequest subRequest){
        return statsFromOrderItemsAs(name, subRequest.sampleVarianceQuantity(), true);
    }
    public GlobalOrderRequest<T> samplePopulationVarianceQuantityOfOrderItems(){
        return samplePopulationVarianceQuantityOfOrderItemsAs("varPopQuantityOfOrderItems");
    }

    public GlobalOrderRequest<T> samplePopulationVarianceQuantityOfOrderItemsAs(String name){
        return samplePopulationVarianceQuantityOfOrderItemsAs(name, Q.orderItems().unlimited());
    }

    public GlobalOrderRequest<T> samplePopulationVarianceQuantityOfOrderItemsAs(String name, OrderItemRequest subRequest){
        return statsFromOrderItemsAs(name, subRequest.samplePopulationVarianceQuantity(), true);
    }
    public GlobalOrderRequest<T> minAmountOfInvoices(){
        return minAmountOfInvoicesAs("minAmountOfInvoices");
    }

    public GlobalOrderRequest<T> minAmountOfInvoicesAs(String name){
        return minAmountOfInvoicesAs(name, Q.invoices().unlimited());
    }

    public GlobalOrderRequest<T> minAmountOfInvoicesAs(String name, InvoiceRequest subRequest){
        return statsFromInvoicesAs(name, subRequest.minAmount(), true);
    }
    public GlobalOrderRequest<T> maxAmountOfInvoices(){
        return maxAmountOfInvoicesAs("maxAmountOfInvoices");
    }

    public GlobalOrderRequest<T> maxAmountOfInvoicesAs(String name){
        return maxAmountOfInvoicesAs(name, Q.invoices().unlimited());
    }

    public GlobalOrderRequest<T> maxAmountOfInvoicesAs(String name, InvoiceRequest subRequest){
        return statsFromInvoicesAs(name, subRequest.maxAmount(), true);
    }
    public GlobalOrderRequest<T> sumAmountOfInvoices(){
        return sumAmountOfInvoicesAs("sumAmountOfInvoices");
    }

    public GlobalOrderRequest<T> sumAmountOfInvoicesAs(String name){
        return sumAmountOfInvoicesAs(name, Q.invoices().unlimited());
    }

    public GlobalOrderRequest<T> sumAmountOfInvoicesAs(String name, InvoiceRequest subRequest){
        return statsFromInvoicesAs(name, subRequest.sumAmount(), true);
    }
    public GlobalOrderRequest<T> avgAmountOfInvoices(){
        return avgAmountOfInvoicesAs("avgAmountOfInvoices");
    }

    public GlobalOrderRequest<T> avgAmountOfInvoicesAs(String name){
        return avgAmountOfInvoicesAs(name, Q.invoices().unlimited());
    }

    public GlobalOrderRequest<T> avgAmountOfInvoicesAs(String name, InvoiceRequest subRequest){
        return statsFromInvoicesAs(name, subRequest.avgAmount(), true);
    }
    public GlobalOrderRequest<T> standardDeviationAmountOfInvoices(){
        return standardDeviationAmountOfInvoicesAs("stdDevAmountOfInvoices");
    }

    public GlobalOrderRequest<T> standardDeviationAmountOfInvoicesAs(String name){
        return standardDeviationAmountOfInvoicesAs(name, Q.invoices().unlimited());
    }

    public GlobalOrderRequest<T> standardDeviationAmountOfInvoicesAs(String name, InvoiceRequest subRequest){
        return statsFromInvoicesAs(name, subRequest.standardDeviationAmount(), true);
    }
    public GlobalOrderRequest<T> squareRootOfPopulationStandardDeviationAmountOfInvoices(){
        return squareRootOfPopulationStandardDeviationAmountOfInvoicesAs("stdDevPopAmountOfInvoices");
    }

    public GlobalOrderRequest<T> squareRootOfPopulationStandardDeviationAmountOfInvoicesAs(String name){
        return squareRootOfPopulationStandardDeviationAmountOfInvoicesAs(name, Q.invoices().unlimited());
    }

    public GlobalOrderRequest<T> squareRootOfPopulationStandardDeviationAmountOfInvoicesAs(String name, InvoiceRequest subRequest){
        return statsFromInvoicesAs(name, subRequest.squareRootOfPopulationStandardDeviationAmount(), true);
    }
    public GlobalOrderRequest<T> sampleVarianceAmountOfInvoices(){
        return sampleVarianceAmountOfInvoicesAs("varSampAmountOfInvoices");
    }

    public GlobalOrderRequest<T> sampleVarianceAmountOfInvoicesAs(String name){
        return sampleVarianceAmountOfInvoicesAs(name, Q.invoices().unlimited());
    }

    public GlobalOrderRequest<T> sampleVarianceAmountOfInvoicesAs(String name, InvoiceRequest subRequest){
        return statsFromInvoicesAs(name, subRequest.sampleVarianceAmount(), true);
    }
    public GlobalOrderRequest<T> samplePopulationVarianceAmountOfInvoices(){
        return samplePopulationVarianceAmountOfInvoicesAs("varPopAmountOfInvoices");
    }

    public GlobalOrderRequest<T> samplePopulationVarianceAmountOfInvoicesAs(String name){
        return samplePopulationVarianceAmountOfInvoicesAs(name, Q.invoices().unlimited());
    }

    public GlobalOrderRequest<T> samplePopulationVarianceAmountOfInvoicesAs(String name, InvoiceRequest subRequest){
        return statsFromInvoicesAs(name, subRequest.samplePopulationVarianceAmount(), true);
    }
    public GlobalOrderRequest<T> minRefundAmountOfReturnRequests(){
        return minRefundAmountOfReturnRequestsAs("minRefundAmountOfReturnRequests");
    }

    public GlobalOrderRequest<T> minRefundAmountOfReturnRequestsAs(String name){
        return minRefundAmountOfReturnRequestsAs(name, Q.returnRequests().unlimited());
    }

    public GlobalOrderRequest<T> minRefundAmountOfReturnRequestsAs(String name, ReturnRequestRequest subRequest){
        return statsFromReturnRequestsAs(name, subRequest.minRefundAmount(), true);
    }
    public GlobalOrderRequest<T> maxRefundAmountOfReturnRequests(){
        return maxRefundAmountOfReturnRequestsAs("maxRefundAmountOfReturnRequests");
    }

    public GlobalOrderRequest<T> maxRefundAmountOfReturnRequestsAs(String name){
        return maxRefundAmountOfReturnRequestsAs(name, Q.returnRequests().unlimited());
    }

    public GlobalOrderRequest<T> maxRefundAmountOfReturnRequestsAs(String name, ReturnRequestRequest subRequest){
        return statsFromReturnRequestsAs(name, subRequest.maxRefundAmount(), true);
    }
    public GlobalOrderRequest<T> sumRefundAmountOfReturnRequests(){
        return sumRefundAmountOfReturnRequestsAs("sumRefundAmountOfReturnRequests");
    }

    public GlobalOrderRequest<T> sumRefundAmountOfReturnRequestsAs(String name){
        return sumRefundAmountOfReturnRequestsAs(name, Q.returnRequests().unlimited());
    }

    public GlobalOrderRequest<T> sumRefundAmountOfReturnRequestsAs(String name, ReturnRequestRequest subRequest){
        return statsFromReturnRequestsAs(name, subRequest.sumRefundAmount(), true);
    }
    public GlobalOrderRequest<T> avgRefundAmountOfReturnRequests(){
        return avgRefundAmountOfReturnRequestsAs("avgRefundAmountOfReturnRequests");
    }

    public GlobalOrderRequest<T> avgRefundAmountOfReturnRequestsAs(String name){
        return avgRefundAmountOfReturnRequestsAs(name, Q.returnRequests().unlimited());
    }

    public GlobalOrderRequest<T> avgRefundAmountOfReturnRequestsAs(String name, ReturnRequestRequest subRequest){
        return statsFromReturnRequestsAs(name, subRequest.avgRefundAmount(), true);
    }
    public GlobalOrderRequest<T> standardDeviationRefundAmountOfReturnRequests(){
        return standardDeviationRefundAmountOfReturnRequestsAs("stdDevRefundAmountOfReturnRequests");
    }

    public GlobalOrderRequest<T> standardDeviationRefundAmountOfReturnRequestsAs(String name){
        return standardDeviationRefundAmountOfReturnRequestsAs(name, Q.returnRequests().unlimited());
    }

    public GlobalOrderRequest<T> standardDeviationRefundAmountOfReturnRequestsAs(String name, ReturnRequestRequest subRequest){
        return statsFromReturnRequestsAs(name, subRequest.standardDeviationRefundAmount(), true);
    }
    public GlobalOrderRequest<T> squareRootOfPopulationStandardDeviationRefundAmountOfReturnRequests(){
        return squareRootOfPopulationStandardDeviationRefundAmountOfReturnRequestsAs("stdDevPopRefundAmountOfReturnRequests");
    }

    public GlobalOrderRequest<T> squareRootOfPopulationStandardDeviationRefundAmountOfReturnRequestsAs(String name){
        return squareRootOfPopulationStandardDeviationRefundAmountOfReturnRequestsAs(name, Q.returnRequests().unlimited());
    }

    public GlobalOrderRequest<T> squareRootOfPopulationStandardDeviationRefundAmountOfReturnRequestsAs(String name, ReturnRequestRequest subRequest){
        return statsFromReturnRequestsAs(name, subRequest.squareRootOfPopulationStandardDeviationRefundAmount(), true);
    }
    public GlobalOrderRequest<T> sampleVarianceRefundAmountOfReturnRequests(){
        return sampleVarianceRefundAmountOfReturnRequestsAs("varSampRefundAmountOfReturnRequests");
    }

    public GlobalOrderRequest<T> sampleVarianceRefundAmountOfReturnRequestsAs(String name){
        return sampleVarianceRefundAmountOfReturnRequestsAs(name, Q.returnRequests().unlimited());
    }

    public GlobalOrderRequest<T> sampleVarianceRefundAmountOfReturnRequestsAs(String name, ReturnRequestRequest subRequest){
        return statsFromReturnRequestsAs(name, subRequest.sampleVarianceRefundAmount(), true);
    }
    public GlobalOrderRequest<T> samplePopulationVarianceRefundAmountOfReturnRequests(){
        return samplePopulationVarianceRefundAmountOfReturnRequestsAs("varPopRefundAmountOfReturnRequests");
    }

    public GlobalOrderRequest<T> samplePopulationVarianceRefundAmountOfReturnRequestsAs(String name){
        return samplePopulationVarianceRefundAmountOfReturnRequestsAs(name, Q.returnRequests().unlimited());
    }

    public GlobalOrderRequest<T> samplePopulationVarianceRefundAmountOfReturnRequestsAs(String name, ReturnRequestRequest subRequest){
        return statsFromReturnRequestsAs(name, subRequest.samplePopulationVarianceRefundAmount(), true);
    }

   public GlobalOrderRequest<T> facetByCustomerAs(String facetName, CustomerRequest customer){
       return facetByCustomerAs(facetName, customer, true);
   }

   public GlobalOrderRequest<T> facetByCustomerAs(String facetName, CustomerRequest customer, boolean includeAllFacets){
       addFacet(facetName, GlobalOrder.CUSTOMER_PROPERTY, customer, includeAllFacets);
       return this;
   }


    /**
     * get topN records
     * @param topN  records number
     */
    public GlobalOrderRequest<T> top(int topN) {
        super.top(topN);
        return this;
    }

    /**
     * get records from offset(inclusive) to offset+size(exclusive)
     * @param offset record offset
     * @param size records number
     */
    public GlobalOrderRequest<T> offset(int offset, int size) {
        super.offset(offset, size);
        return this;
    }

    /**
     * retrieve all records
     */
    public GlobalOrderRequest<T> unlimited() {
        super.unlimited();
        return this;
    }

    /**
     * get records of one page
     * @param pageNumber page number(1-based)
     * @param pageSize page size
     */
    public GlobalOrderRequest<T> page(int pageNumber, int pageSize) {
        int offset = (pageNumber - 1) * pageSize;
        return offset(offset, pageSize);
   }

    /**
     * get records of one page, default page size is 10
     * @param pageNumber page number(1-based)
     */
    public GlobalOrderRequest<T> page(int pageNumber) {
        return page(pageNumber, 10);
   }
}