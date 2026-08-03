
package com.example.paymentservice.paymenttransaction;

import com.example.paymentservice.paymentaccount.PaymentAccount;
import com.example.paymentservice.paymentmethod.PaymentMethod;
import io.teaql.core.Audited;
import io.teaql.core.BaseEntity;
import io.teaql.core.EntityStatus;
import io.teaql.core.FrameworkInternal;
import io.teaql.core.RemoteInput;
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
public class PaymentTransaction extends BaseEntity implements RemoteInput {
    public static String INTERNAL_TYPE = "PaymentTransaction";

    public static final String PAYMENT_ACCOUNT_PROPERTY = "paymentAccount";
    public static final String CURRENCY_CODE_PROPERTY = "currencyCode";
    public static final String PAYMENT_METHOD_PROPERTY = "paymentMethod";
    public static final String TRANSACTION_AMOUNT_PROPERTY = "transactionAmount";
    public static final String CREATE_TIME_PROPERTY = "createTime";
    public static final String UPDATE_TIME_PROPERTY = "updateTime";
    private PaymentAccount paymentAccount;
    private String currencyCode;
    private PaymentMethod paymentMethod;
    private BigDecimal transactionAmount;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

    public PaymentAccount getPaymentAccount(){
        return this.paymentAccount;
    }
    public String getCurrencyCode(){
        return this.currencyCode;
    }
    public PaymentMethod getPaymentMethod(){
        return this.paymentMethod;
    }
    public BigDecimal getTransactionAmount(){
        return this.transactionAmount;
    }
    public LocalDateTime getCreateTime(){
        return this.createTime;
    }
    public LocalDateTime getUpdateTime(){
        return this.updateTime;
    }
    public PaymentTransaction updatePaymentAccount(PaymentAccount paymentAccount){
        if(Objects.equals(this.paymentAccount, paymentAccount)){
            return this;
        }
        handleUpdate(PAYMENT_ACCOUNT_PROPERTY, getPaymentAccount(), paymentAccount);
        this.paymentAccount = paymentAccount;
        return this;
    }
    public PaymentTransaction updateCurrencyCode(String currencyCode){
        currencyCode = (currencyCode == null ? null : currencyCode.trim());
        if(Objects.equals(this.currencyCode, currencyCode)){
            return this;
        }
        handleUpdate(CURRENCY_CODE_PROPERTY, getCurrencyCode(), currencyCode);
        this.currencyCode = currencyCode;
        return this;
    }
    public PaymentTransaction updatePaymentMethod(PaymentMethod paymentMethod){
        if(Objects.equals(this.paymentMethod, paymentMethod)){
            return this;
        }
        handleUpdate(PAYMENT_METHOD_PROPERTY, getPaymentMethod(), paymentMethod);
        this.paymentMethod = paymentMethod;
        return this;
    }
    public PaymentTransaction updateTransactionAmount(BigDecimal transactionAmount){
        if(Objects.equals(this.transactionAmount, transactionAmount)){
            return this;
        }
        handleUpdate(TRANSACTION_AMOUNT_PROPERTY, getTransactionAmount(), transactionAmount);
        this.transactionAmount = transactionAmount;
        return this;
    }
    public PaymentTransaction updateCreateTime(LocalDateTime createTime){
        if(Objects.equals(this.createTime, createTime)){
            return this;
        }
        handleUpdate(CREATE_TIME_PROPERTY, getCreateTime(), createTime);
        this.createTime = createTime;
        return this;
    }
    public PaymentTransaction updateUpdateTime(LocalDateTime updateTime){
        if(Objects.equals(this.updateTime, updateTime)){
            return this;
        }
        handleUpdate(UPDATE_TIME_PROPERTY, getUpdateTime(), updateTime);
        this.updateTime = updateTime;
        return this;
    }

    public static PaymentTransaction refer(Long id){
        PaymentTransaction refer = new PaymentTransaction();
        refer.__internalSet("id", id);
        refer.set$status(EntityStatus.REFER);
        return refer;
    }
    @Override
    public String typeName(){
        return INTERNAL_TYPE;
    }

    public PaymentTransaction comment(String comment){
        this.setComment(comment);
        return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Audited<PaymentTransaction> auditAs(String action) {
        return super.auditAs(action);
    }

    // ===== Framework Internal: generated switch dispatch =====
    @Override
    @FrameworkInternal
    public void __internalSet(String property, Object value) {
        switch (property) {
            case "paymentAccount": this.paymentAccount = (PaymentAccount) value; break;

            case "currencyCode": this.currencyCode = (value == null ? null : ((String)value).trim()); break;

            case "paymentMethod": this.paymentMethod = (PaymentMethod) value; break;

            case "transactionAmount": this.transactionAmount = (BigDecimal) value; break;

            case "createTime": this.createTime = (LocalDateTime) value; break;

            case "updateTime": this.updateTime = (LocalDateTime) value; break;

            default: super.__internalSet(property, value);
        }
    }

    @Override
    @FrameworkInternal
    public Object __internalGet(String property) {
        switch (property) {
            case "paymentAccount": return this.paymentAccount;
            case "currencyCode": return this.currencyCode;
            case "paymentMethod": return this.paymentMethod;
            case "transactionAmount": return this.transactionAmount;
            case "createTime": return this.createTime;
            case "updateTime": return this.updateTime;
            default: return super.__internalGet(property);
        }
    }

}