
package com.example.enterpriseerpsystem.invoice;

import com.example.enterpriseerpsystem.customer.Customer;
import com.example.enterpriseerpsystem.globalorder.GlobalOrder;
import com.example.enterpriseerpsystem.payment.Payment;
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
public class Invoice extends BaseEntity implements RemoteInput {
    public static String INTERNAL_TYPE = "Invoice";

    public static final String AMOUNT_PROPERTY = "amount";
    public static final String CUSTOMER_PROPERTY = "customer";
    public static final String DUE_DATE_PROPERTY = "dueDate";
    public static final String GLOBAL_ORDER_PROPERTY = "globalOrder";
    public static final String ISSUE_DATE_PROPERTY = "issueDate";
    public static final String STATUS_PROPERTY = "status";
    public static final String CREATE_TIME_PROPERTY = "createTime";
    public static final String UPDATE_TIME_PROPERTY = "updateTime";
    public static final String PAYMENT_LIST_PROPERTY = "paymentList";
    private BigDecimal amount;
    private Customer customer;
    private LocalDateTime dueDate;
    private GlobalOrder globalOrder;
    private LocalDateTime issueDate;
    private String status;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private SmartList<Payment> paymentList;

    public BigDecimal getAmount(){
        return this.amount;
    }
    public Customer getCustomer(){
        return this.customer;
    }
    public LocalDateTime getDueDate(){
        return this.dueDate;
    }
    public GlobalOrder getGlobalOrder(){
        return this.globalOrder;
    }
    public LocalDateTime getIssueDate(){
        return this.issueDate;
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
    public SmartList<Payment> getPaymentList(){
        return this.paymentList;
    }
    public Invoice updateAmount(BigDecimal amount){
        if(Objects.equals(this.amount, amount)){
            return this;
        }
        handleUpdate(AMOUNT_PROPERTY, getAmount(), amount);
        this.amount = amount;
        return this;
    }
    public Invoice updateCustomer(Customer customer){
        if(Objects.equals(this.customer, customer)){
            return this;
        }
        handleUpdate(CUSTOMER_PROPERTY, getCustomer(), customer);
        this.customer = customer;
        return this;
    }
    public Invoice updateDueDate(LocalDateTime dueDate){
        if(Objects.equals(this.dueDate, dueDate)){
            return this;
        }
        handleUpdate(DUE_DATE_PROPERTY, getDueDate(), dueDate);
        this.dueDate = dueDate;
        return this;
    }
    public Invoice updateGlobalOrder(GlobalOrder globalOrder){
        if(Objects.equals(this.globalOrder, globalOrder)){
            return this;
        }
        handleUpdate(GLOBAL_ORDER_PROPERTY, getGlobalOrder(), globalOrder);
        this.globalOrder = globalOrder;
        return this;
    }
    public Invoice updateIssueDate(LocalDateTime issueDate){
        if(Objects.equals(this.issueDate, issueDate)){
            return this;
        }
        handleUpdate(ISSUE_DATE_PROPERTY, getIssueDate(), issueDate);
        this.issueDate = issueDate;
        return this;
    }
    public Invoice updateStatus(String status){
        status = (status == null ? null : status.trim());
        if(Objects.equals(this.status, status)){
            return this;
        }
        handleUpdate(STATUS_PROPERTY, getStatus(), status);
        this.status = status;
        return this;
    }
    public Invoice updateCreateTime(LocalDateTime createTime){
        if(Objects.equals(this.createTime, createTime)){
            return this;
        }
        handleUpdate(CREATE_TIME_PROPERTY, getCreateTime(), createTime);
        this.createTime = createTime;
        return this;
    }
    public Invoice updateUpdateTime(LocalDateTime updateTime){
        if(Objects.equals(this.updateTime, updateTime)){
            return this;
        }
        handleUpdate(UPDATE_TIME_PROPERTY, getUpdateTime(), updateTime);
        this.updateTime = updateTime;
        return this;
    }
    public Invoice addPayment(Payment payment){
        if (payment == null){
            return this;
        }

        if(null == this.paymentList){
            this.paymentList = new SmartList<>();
        }

        this.paymentList.add(payment);
        payment.cacheRelation(Payment.INVOICE_PROPERTY, this);
        return this;
    }

    public static Invoice refer(Long id){
        Invoice refer = new Invoice();
        refer.__internalSet("id", id);
        refer.set$status(EntityStatus.REFER);
        return refer;
    }
    @Override
    public String typeName(){
        return INTERNAL_TYPE;
    }

    public Invoice comment(String comment){
        this.setComment(comment);
        return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Audited<Invoice> auditAs(String action) {
        return super.auditAs(action);
    }

    // ===== Framework Internal: generated switch dispatch =====
    @Override
    @FrameworkInternal
    public void __internalSet(String property, Object value) {
        switch (property) {
            case "amount": this.amount = (BigDecimal) value; break;

            case "customer": this.customer = (Customer) value; break;

            case "dueDate": this.dueDate = (LocalDateTime) value; break;

            case "globalOrder": this.globalOrder = (GlobalOrder) value; break;

            case "issueDate": this.issueDate = (LocalDateTime) value; break;

            case "status": this.status = (value == null ? null : ((String)value).trim()); break;

            case "createTime": this.createTime = (LocalDateTime) value; break;

            case "updateTime": this.updateTime = (LocalDateTime) value; break;

            case "paymentList": this.paymentList = (SmartList<Payment>) value; break;
            default: super.__internalSet(property, value);
        }
    }

    @Override
    @FrameworkInternal
    public Object __internalGet(String property) {
        switch (property) {
            case "amount": return this.amount;
            case "customer": return this.customer;
            case "dueDate": return this.dueDate;
            case "globalOrder": return this.globalOrder;
            case "issueDate": return this.issueDate;
            case "status": return this.status;
            case "createTime": return this.createTime;
            case "updateTime": return this.updateTime;
            case "paymentList": return this.paymentList;
            default: return super.__internalGet(property);
        }
    }

}