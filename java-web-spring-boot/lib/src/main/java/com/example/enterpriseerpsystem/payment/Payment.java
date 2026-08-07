
package com.example.enterpriseerpsystem.payment;

import com.example.enterpriseerpsystem.invoice.Invoice;
import com.example.enterpriseerpsystem.refund.Refund;
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
public class Payment extends BaseEntity implements RemoteInput {
    public static String INTERNAL_TYPE = "Payment";

    public static final String AMOUNT_PROPERTY = "amount";
    public static final String CARD_LAST4_PROPERTY = "cardLast4";
    public static final String PAYMENT_DATE_PROPERTY = "paymentDate";
    public static final String INVOICE_PROPERTY = "invoice";
    public static final String METHOD_PROPERTY = "method";
    public static final String STATUS_PROPERTY = "status";
    public static final String CREATE_TIME_PROPERTY = "createTime";
    public static final String UPDATE_TIME_PROPERTY = "updateTime";
    public static final String REFUND_LIST_PROPERTY = "refundList";
    private BigDecimal amount;
    private String cardLast4;
    private LocalDateTime paymentDate;
    private Invoice invoice;
    private String method;
    private String status;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private SmartList<Refund> refundList;

    public BigDecimal getAmount(){
        return this.amount;
    }
    public String getCardLast4(){
        return this.cardLast4;
    }
    public LocalDateTime getPaymentDate(){
        return this.paymentDate;
    }
    public Invoice getInvoice(){
        return this.invoice;
    }
    public String getMethod(){
        return this.method;
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
    public SmartList<Refund> getRefundList(){
        return this.refundList;
    }
    public Payment updateAmount(BigDecimal amount){
        if(Objects.equals(this.amount, amount)){
            return this;
        }
        handleUpdate(AMOUNT_PROPERTY, getAmount(), amount);
        this.amount = amount;
        return this;
    }
    public Payment updateCardLast4(String cardLast4){
        cardLast4 = (cardLast4 == null ? null : cardLast4.trim());
        if(Objects.equals(this.cardLast4, cardLast4)){
            return this;
        }
        handleUpdate(CARD_LAST4_PROPERTY, getCardLast4(), cardLast4);
        this.cardLast4 = cardLast4;
        return this;
    }
    public Payment updatePaymentDate(LocalDateTime paymentDate){
        if(Objects.equals(this.paymentDate, paymentDate)){
            return this;
        }
        handleUpdate(PAYMENT_DATE_PROPERTY, getPaymentDate(), paymentDate);
        this.paymentDate = paymentDate;
        return this;
    }
    public Payment updateInvoice(Invoice invoice){
        if(Objects.equals(this.invoice, invoice)){
            return this;
        }
        handleUpdate(INVOICE_PROPERTY, getInvoice(), invoice);
        this.invoice = invoice;
        return this;
    }
    public Payment updateMethod(String method){
        method = (method == null ? null : method.trim());
        if(Objects.equals(this.method, method)){
            return this;
        }
        handleUpdate(METHOD_PROPERTY, getMethod(), method);
        this.method = method;
        return this;
    }
    public Payment updateStatus(String status){
        status = (status == null ? null : status.trim());
        if(Objects.equals(this.status, status)){
            return this;
        }
        handleUpdate(STATUS_PROPERTY, getStatus(), status);
        this.status = status;
        return this;
    }
    public Payment updateCreateTime(LocalDateTime createTime){
        if(Objects.equals(this.createTime, createTime)){
            return this;
        }
        handleUpdate(CREATE_TIME_PROPERTY, getCreateTime(), createTime);
        this.createTime = createTime;
        return this;
    }
    public Payment updateUpdateTime(LocalDateTime updateTime){
        if(Objects.equals(this.updateTime, updateTime)){
            return this;
        }
        handleUpdate(UPDATE_TIME_PROPERTY, getUpdateTime(), updateTime);
        this.updateTime = updateTime;
        return this;
    }
    public Payment addRefund(Refund refund){
        if (refund == null){
            return this;
        }

        if(null == this.refundList){
            this.refundList = new SmartList<>();
        }

        this.refundList.add(refund);
        refund.cacheRelation(Refund.PAYMENT_PROPERTY, this);
        return this;
    }

    public static Payment refer(Long id){
        Payment refer = new Payment();
        refer.__internalSet("id", id);
        refer.set$status(EntityStatus.REFER);
        return refer;
    }
    @Override
    public String typeName(){
        return INTERNAL_TYPE;
    }

    public Payment comment(String comment){
        this.setComment(comment);
        return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Audited<Payment> auditAs(String action) {
        return super.auditAs(action);
    }

    // ===== Framework Internal: generated switch dispatch =====
    @Override
    @FrameworkInternal
    public void __internalSet(String property, Object value) {
        switch (property) {
            case "amount": this.amount = (BigDecimal) value; break;

            case "cardLast4": this.cardLast4 = (value == null ? null : ((String)value).trim()); break;

            case "paymentDate": this.paymentDate = (LocalDateTime) value; break;

            case "invoice": this.invoice = (Invoice) value; break;

            case "method": this.method = (value == null ? null : ((String)value).trim()); break;

            case "status": this.status = (value == null ? null : ((String)value).trim()); break;

            case "createTime": this.createTime = (LocalDateTime) value; break;

            case "updateTime": this.updateTime = (LocalDateTime) value; break;

            case "refundList": this.refundList = (SmartList<Refund>) value; break;
            default: super.__internalSet(property, value);
        }
    }

    @Override
    @FrameworkInternal
    public Object __internalGet(String property) {
        switch (property) {
            case "amount": return this.amount;
            case "cardLast4": return this.cardLast4;
            case "paymentDate": return this.paymentDate;
            case "invoice": return this.invoice;
            case "method": return this.method;
            case "status": return this.status;
            case "createTime": return this.createTime;
            case "updateTime": return this.updateTime;
            case "refundList": return this.refundList;
            default: return super.__internalGet(property);
        }
    }

}