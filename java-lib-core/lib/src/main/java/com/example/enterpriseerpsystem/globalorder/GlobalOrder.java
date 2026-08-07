
package com.example.enterpriseerpsystem.globalorder;

import com.example.enterpriseerpsystem.customer.Customer;
import com.example.enterpriseerpsystem.invoice.Invoice;
import com.example.enterpriseerpsystem.orderitem.OrderItem;
import com.example.enterpriseerpsystem.returnrequest.ReturnRequest;
import com.example.enterpriseerpsystem.shipment.Shipment;
import io.teaql.core.Audited;
import io.teaql.core.BaseEntity;
import io.teaql.core.EntityStatus;
import io.teaql.core.FrameworkInternal;
import io.teaql.core.RemoteInput;
import io.teaql.core.SmartList;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * [TEAQL AI WARNING]
 * TeaQL was explicitly designed to PREVENT AI hallucinations and random guessing.
 * DO NOT GUESS METHOD NAMES!
 * The methods listed below are the ONLY valid ways to interact with this entity.
 * If you encounter compilation errors (e.g., method not found), DO NOT guess another method name.
 * Read the method signatures in this file before proceeding.
 */
public class GlobalOrder extends BaseEntity implements RemoteInput {
    public static String INTERNAL_TYPE = "GlobalOrder";

    public static final String SHIPPING_ADDRESS_PROPERTY = "shippingAddress";
    public static final String TOTAL_AMOUNT_PROPERTY = "totalAmount";
    public static final String CUSTOMER_PROPERTY = "customer";
    public static final String ORDER_DATE_PROPERTY = "orderDate";
    public static final String STATUS_PROPERTY = "status";
    public static final String CREATE_TIME_PROPERTY = "createTime";
    public static final String UPDATE_TIME_PROPERTY = "updateTime";
    public static final String ORDER_ITEM_LIST_PROPERTY = "orderItemList";
    public static final String INVOICE_LIST_PROPERTY = "invoiceList";
    public static final String SHIPMENT_LIST_PROPERTY = "shipmentList";
    public static final String RETURN_REQUEST_LIST_PROPERTY = "returnRequestList";
    private String shippingAddress;
    private BigDecimal totalAmount;
    private Customer customer;
    private LocalDateTime orderDate;
    private String status;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private SmartList<OrderItem> orderItemList;
    private SmartList<Invoice> invoiceList;
    private SmartList<Shipment> shipmentList;
    private SmartList<ReturnRequest> returnRequestList;

    public String getShippingAddress(){
        return this.shippingAddress;
    }
    public BigDecimal getTotalAmount(){
        return this.totalAmount;
    }
    public Customer getCustomer(){
        return this.customer;
    }
    public LocalDateTime getOrderDate(){
        return this.orderDate;
    }
    public String getStatus(){
        return this.status;
    }
    public LocalDateTime getCreateTime(){
        return this.createTime;
    }
    public LocalDateTime getUpdateTime(){
        return this.updateTime;
    }
    public SmartList<OrderItem> getOrderItemList(){
        return this.orderItemList;
    }
    public SmartList<Invoice> getInvoiceList(){
        return this.invoiceList;
    }
    public SmartList<Shipment> getShipmentList(){
        return this.shipmentList;
    }
    public SmartList<ReturnRequest> getReturnRequestList(){
        return this.returnRequestList;
    }
    public GlobalOrder updateShippingAddress(String shippingAddress){
        shippingAddress = (shippingAddress == null ? null : shippingAddress.trim());
        if(Objects.equals(this.shippingAddress, shippingAddress)){
            return this;
        }
        handleUpdate(SHIPPING_ADDRESS_PROPERTY, getShippingAddress(), shippingAddress);
        this.shippingAddress = shippingAddress;
        return this;
    }
    public GlobalOrder updateTotalAmount(BigDecimal totalAmount){
        if(Objects.equals(this.totalAmount, totalAmount)){
            return this;
        }
        handleUpdate(TOTAL_AMOUNT_PROPERTY, getTotalAmount(), totalAmount);
        this.totalAmount = totalAmount;
        return this;
    }
    public GlobalOrder updateCustomer(Customer customer){
        if(Objects.equals(this.customer, customer)){
            return this;
        }
        handleUpdate(CUSTOMER_PROPERTY, getCustomer(), customer);
        this.customer = customer;
        return this;
    }
    public GlobalOrder updateOrderDate(LocalDateTime orderDate){
        if(Objects.equals(this.orderDate, orderDate)){
            return this;
        }
        handleUpdate(ORDER_DATE_PROPERTY, getOrderDate(), orderDate);
        this.orderDate = orderDate;
        return this;
    }
    public GlobalOrder updateStatus(String status){
        status = (status == null ? null : status.trim());
        if(Objects.equals(this.status, status)){
            return this;
        }
        handleUpdate(STATUS_PROPERTY, getStatus(), status);
        this.status = status;
        return this;
    }
    public GlobalOrder updateCreateTime(LocalDateTime createTime){
        if(Objects.equals(this.createTime, createTime)){
            return this;
        }
        handleUpdate(CREATE_TIME_PROPERTY, getCreateTime(), createTime);
        this.createTime = createTime;
        return this;
    }
    public GlobalOrder updateUpdateTime(LocalDateTime updateTime){
        if(Objects.equals(this.updateTime, updateTime)){
            return this;
        }
        handleUpdate(UPDATE_TIME_PROPERTY, getUpdateTime(), updateTime);
        this.updateTime = updateTime;
        return this;
    }
    public GlobalOrder addOrderItem(OrderItem orderItem){
        if (orderItem == null){
            return this;
        }

        if(null == this.orderItemList){
            this.orderItemList = new SmartList<>();
        }

        this.orderItemList.add(orderItem);
        orderItem.cacheRelation(OrderItem.GLOBAL_ORDER_PROPERTY, this);
        return this;
    }
    public GlobalOrder addInvoice(Invoice invoice){
        if (invoice == null){
            return this;
        }

        if(null == this.invoiceList){
            this.invoiceList = new SmartList<>();
        }

        this.invoiceList.add(invoice);
        invoice.cacheRelation(Invoice.GLOBAL_ORDER_PROPERTY, this);
        return this;
    }
    public GlobalOrder addShipment(Shipment shipment){
        if (shipment == null){
            return this;
        }

        if(null == this.shipmentList){
            this.shipmentList = new SmartList<>();
        }

        this.shipmentList.add(shipment);
        shipment.cacheRelation(Shipment.GLOBAL_ORDER_PROPERTY, this);
        return this;
    }
    public GlobalOrder addReturnRequest(ReturnRequest returnRequest){
        if (returnRequest == null){
            return this;
        }

        if(null == this.returnRequestList){
            this.returnRequestList = new SmartList<>();
        }

        this.returnRequestList.add(returnRequest);
        returnRequest.cacheRelation(ReturnRequest.GLOBAL_ORDER_PROPERTY, this);
        return this;
    }

    public static GlobalOrder refer(Long id){
        GlobalOrder refer = new GlobalOrder();
        refer.__internalSet("id", id);
        refer.set$status(EntityStatus.REFER);
        return refer;
    }
    @Override
    public String typeName(){
        return INTERNAL_TYPE;
    }

    public GlobalOrder comment(String comment){
        this.setComment(comment);
        return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Audited<GlobalOrder> auditAs(String action) {
        return super.auditAs(action);
    }

    // ===== Framework Internal: generated switch dispatch =====
    @Override
    @FrameworkInternal
    public void __internalSet(String property, Object value) {
        switch (property) {
            case "shippingAddress": this.shippingAddress = (value == null ? null : ((String)value).trim()); break;

            case "totalAmount": this.totalAmount = (BigDecimal) value; break;

            case "customer": this.customer = (Customer) value; break;

            case "orderDate": this.orderDate = (LocalDateTime) value; break;

            case "status": this.status = (value == null ? null : ((String)value).trim()); break;

            case "createTime": this.createTime = (LocalDateTime) value; break;

            case "updateTime": this.updateTime = (LocalDateTime) value; break;

            case "orderItemList": this.orderItemList = (SmartList<OrderItem>) value; break;
            case "invoiceList": this.invoiceList = (SmartList<Invoice>) value; break;
            case "shipmentList": this.shipmentList = (SmartList<Shipment>) value; break;
            case "returnRequestList": this.returnRequestList = (SmartList<ReturnRequest>) value; break;
            default: super.__internalSet(property, value);
        }
    }

    @Override
    @FrameworkInternal
    public Object __internalGet(String property) {
        switch (property) {
            case "shippingAddress": return this.shippingAddress;
            case "totalAmount": return this.totalAmount;
            case "customer": return this.customer;
            case "orderDate": return this.orderDate;
            case "status": return this.status;
            case "createTime": return this.createTime;
            case "updateTime": return this.updateTime;
            case "orderItemList": return this.orderItemList;
            case "invoiceList": return this.invoiceList;
            case "shipmentList": return this.shipmentList;
            case "returnRequestList": return this.returnRequestList;
            default: return super.__internalGet(property);
        }
    }

}