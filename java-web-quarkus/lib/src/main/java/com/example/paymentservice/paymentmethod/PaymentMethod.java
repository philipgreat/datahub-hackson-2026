
package com.example.paymentservice.paymentmethod;

import com.example.paymentservice.paymentaccount.PaymentAccount;
import com.example.paymentservice.paymenttransaction.PaymentTransaction;
import io.teaql.core.Audited;
import io.teaql.core.BaseEntity;
import io.teaql.core.EntityStatus;
import io.teaql.core.FrameworkInternal;
import io.teaql.core.RemoteInput;
import io.teaql.core.SmartList;
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
public class PaymentMethod extends BaseEntity implements RemoteInput {
    public static String INTERNAL_TYPE = "PaymentMethod";

    public static final String PAYMENT_ACCOUNT_PROPERTY = "paymentAccount";
    public static final String METHOD_TYPE_PROPERTY = "methodType";
    public static final String LAST_FOUR_DIGITS_PROPERTY = "lastFourDigits";
    public static final String CREATE_TIME_PROPERTY = "createTime";
    public static final String UPDATE_TIME_PROPERTY = "updateTime";
    public static final String PAYMENT_TRANSACTION_LIST_PROPERTY = "paymentTransactionList";
    private PaymentAccount paymentAccount;
    private String methodType;
    private Integer lastFourDigits;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private SmartList<PaymentTransaction> paymentTransactionList;

    public PaymentAccount getPaymentAccount(){
        return this.paymentAccount;
    }
    public String getMethodType(){
        return this.methodType;
    }
    public Integer getLastFourDigits(){
        return this.lastFourDigits;
    }
    public LocalDateTime getCreateTime(){
        return this.createTime;
    }
    public LocalDateTime getUpdateTime(){
        return this.updateTime;
    }
    public SmartList<PaymentTransaction> getPaymentTransactionList(){
        return this.paymentTransactionList;
    }
    public PaymentMethod updatePaymentAccount(PaymentAccount paymentAccount){
        if(Objects.equals(this.paymentAccount, paymentAccount)){
            return this;
        }
        handleUpdate(PAYMENT_ACCOUNT_PROPERTY, getPaymentAccount(), paymentAccount);
        this.paymentAccount = paymentAccount;
        return this;
    }
    public PaymentMethod updateMethodType(String methodType){
        methodType = (methodType == null ? null : methodType.trim());
        if(Objects.equals(this.methodType, methodType)){
            return this;
        }
        handleUpdate(METHOD_TYPE_PROPERTY, getMethodType(), methodType);
        this.methodType = methodType;
        return this;
    }
    public PaymentMethod updateLastFourDigits(Integer lastFourDigits){
        if(Objects.equals(this.lastFourDigits, lastFourDigits)){
            return this;
        }
        handleUpdate(LAST_FOUR_DIGITS_PROPERTY, getLastFourDigits(), lastFourDigits);
        this.lastFourDigits = lastFourDigits;
        return this;
    }
    public PaymentMethod updateCreateTime(LocalDateTime createTime){
        if(Objects.equals(this.createTime, createTime)){
            return this;
        }
        handleUpdate(CREATE_TIME_PROPERTY, getCreateTime(), createTime);
        this.createTime = createTime;
        return this;
    }
    public PaymentMethod updateUpdateTime(LocalDateTime updateTime){
        if(Objects.equals(this.updateTime, updateTime)){
            return this;
        }
        handleUpdate(UPDATE_TIME_PROPERTY, getUpdateTime(), updateTime);
        this.updateTime = updateTime;
        return this;
    }
    public PaymentMethod addPaymentTransaction(PaymentTransaction paymentTransaction){
        if (paymentTransaction == null){
            return this;
        }

        if(null == this.paymentTransactionList){
            this.paymentTransactionList = new SmartList<>();
        }

        this.paymentTransactionList.add(paymentTransaction);
        paymentTransaction.cacheRelation(PaymentTransaction.PAYMENT_METHOD_PROPERTY, this);
        return this;
    }

    public static PaymentMethod refer(Long id){
        PaymentMethod refer = new PaymentMethod();
        refer.__internalSet("id", id);
        refer.set$status(EntityStatus.REFER);
        return refer;
    }
    @Override
    public String typeName(){
        return INTERNAL_TYPE;
    }

    public PaymentMethod comment(String comment){
        this.setComment(comment);
        return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Audited<PaymentMethod> auditAs(String action) {
        return super.auditAs(action);
    }

    // ===== Framework Internal: generated switch dispatch =====
    @Override
    @FrameworkInternal
    public void __internalSet(String property, Object value) {
        switch (property) {
            case "paymentAccount": this.paymentAccount = (PaymentAccount) value; break;

            case "methodType": this.methodType = (value == null ? null : ((String)value).trim()); break;

            case "lastFourDigits": this.lastFourDigits = (Integer) value; break;

            case "createTime": this.createTime = (LocalDateTime) value; break;

            case "updateTime": this.updateTime = (LocalDateTime) value; break;

            case "paymentTransactionList": this.paymentTransactionList = (SmartList<PaymentTransaction>) value; break;
            default: super.__internalSet(property, value);
        }
    }

    @Override
    @FrameworkInternal
    public Object __internalGet(String property) {
        switch (property) {
            case "paymentAccount": return this.paymentAccount;
            case "methodType": return this.methodType;
            case "lastFourDigits": return this.lastFourDigits;
            case "createTime": return this.createTime;
            case "updateTime": return this.updateTime;
            case "paymentTransactionList": return this.paymentTransactionList;
            default: return super.__internalGet(property);
        }
    }

}