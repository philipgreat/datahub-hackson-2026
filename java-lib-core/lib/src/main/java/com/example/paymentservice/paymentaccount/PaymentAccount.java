
package com.example.paymentservice.paymentaccount;

import com.example.paymentservice.paymentmethod.PaymentMethod;
import com.example.paymentservice.paymenttransaction.PaymentTransaction;
import com.example.paymentservice.useraccount.UserAccount;
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
public class PaymentAccount extends BaseEntity implements RemoteInput {
    public static String INTERNAL_TYPE = "PaymentAccount";

    public static final String USER_ACCOUNT_PROPERTY = "userAccount";
    public static final String ACCOUNT_NAME_PROPERTY = "accountName";
    public static final String ACCOUNT_NUMBER_PROPERTY = "accountNumber";
    public static final String CURRENCY_CODE_PROPERTY = "currencyCode";
    public static final String CREATE_TIME_PROPERTY = "createTime";
    public static final String UPDATE_TIME_PROPERTY = "updateTime";
    public static final String PAYMENT_METHOD_LIST_PROPERTY = "paymentMethodList";
    public static final String PAYMENT_TRANSACTION_LIST_PROPERTY = "paymentTransactionList";
    private UserAccount userAccount;
    private String accountName;
    private Integer accountNumber;
    private String currencyCode;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private SmartList<PaymentMethod> paymentMethodList;
    private SmartList<PaymentTransaction> paymentTransactionList;

    public UserAccount getUserAccount(){
        return this.userAccount;
    }
    public String getAccountName(){
        return this.accountName;
    }
    public Integer getAccountNumber(){
        return this.accountNumber;
    }
    public String getCurrencyCode(){
        return this.currencyCode;
    }
    public LocalDateTime getCreateTime(){
        return this.createTime;
    }
    public LocalDateTime getUpdateTime(){
        return this.updateTime;
    }
    public SmartList<PaymentMethod> getPaymentMethodList(){
        return this.paymentMethodList;
    }
    public SmartList<PaymentTransaction> getPaymentTransactionList(){
        return this.paymentTransactionList;
    }
    public PaymentAccount updateUserAccount(UserAccount userAccount){
        if(Objects.equals(this.userAccount, userAccount)){
            return this;
        }
        handleUpdate(USER_ACCOUNT_PROPERTY, getUserAccount(), userAccount);
        this.userAccount = userAccount;
        return this;
    }
    public PaymentAccount updateAccountName(String accountName){
        accountName = (accountName == null ? null : accountName.trim());
        if(Objects.equals(this.accountName, accountName)){
            return this;
        }
        handleUpdate(ACCOUNT_NAME_PROPERTY, getAccountName(), accountName);
        this.accountName = accountName;
        return this;
    }
    public PaymentAccount updateAccountNumber(Integer accountNumber){
        if(Objects.equals(this.accountNumber, accountNumber)){
            return this;
        }
        handleUpdate(ACCOUNT_NUMBER_PROPERTY, getAccountNumber(), accountNumber);
        this.accountNumber = accountNumber;
        return this;
    }
    public PaymentAccount updateCurrencyCode(String currencyCode){
        currencyCode = (currencyCode == null ? null : currencyCode.trim());
        if(Objects.equals(this.currencyCode, currencyCode)){
            return this;
        }
        handleUpdate(CURRENCY_CODE_PROPERTY, getCurrencyCode(), currencyCode);
        this.currencyCode = currencyCode;
        return this;
    }
    public PaymentAccount updateCreateTime(LocalDateTime createTime){
        if(Objects.equals(this.createTime, createTime)){
            return this;
        }
        handleUpdate(CREATE_TIME_PROPERTY, getCreateTime(), createTime);
        this.createTime = createTime;
        return this;
    }
    public PaymentAccount updateUpdateTime(LocalDateTime updateTime){
        if(Objects.equals(this.updateTime, updateTime)){
            return this;
        }
        handleUpdate(UPDATE_TIME_PROPERTY, getUpdateTime(), updateTime);
        this.updateTime = updateTime;
        return this;
    }
    public PaymentAccount addPaymentMethod(PaymentMethod paymentMethod){
        if (paymentMethod == null){
            return this;
        }

        if(null == this.paymentMethodList){
            this.paymentMethodList = new SmartList<>();
        }

        this.paymentMethodList.add(paymentMethod);
        paymentMethod.cacheRelation(PaymentMethod.PAYMENT_ACCOUNT_PROPERTY, this);
        return this;
    }
    public PaymentAccount addPaymentTransaction(PaymentTransaction paymentTransaction){
        if (paymentTransaction == null){
            return this;
        }

        if(null == this.paymentTransactionList){
            this.paymentTransactionList = new SmartList<>();
        }

        this.paymentTransactionList.add(paymentTransaction);
        paymentTransaction.cacheRelation(PaymentTransaction.PAYMENT_ACCOUNT_PROPERTY, this);
        return this;
    }

    public static PaymentAccount refer(Long id){
        PaymentAccount refer = new PaymentAccount();
        refer.__internalSet("id", id);
        refer.set$status(EntityStatus.REFER);
        return refer;
    }
    @Override
    public String typeName(){
        return INTERNAL_TYPE;
    }

    public PaymentAccount comment(String comment){
        this.setComment(comment);
        return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Audited<PaymentAccount> auditAs(String action) {
        return super.auditAs(action);
    }

    // ===== Framework Internal: generated switch dispatch =====
    @Override
    @FrameworkInternal
    public void __internalSet(String property, Object value) {
        switch (property) {
            case "userAccount": this.userAccount = (UserAccount) value; break;

            case "accountName": this.accountName = (value == null ? null : ((String)value).trim()); break;

            case "accountNumber": this.accountNumber = (Integer) value; break;

            case "currencyCode": this.currencyCode = (value == null ? null : ((String)value).trim()); break;

            case "createTime": this.createTime = (LocalDateTime) value; break;

            case "updateTime": this.updateTime = (LocalDateTime) value; break;

            case "paymentMethodList": this.paymentMethodList = (SmartList<PaymentMethod>) value; break;
            case "paymentTransactionList": this.paymentTransactionList = (SmartList<PaymentTransaction>) value; break;
            default: super.__internalSet(property, value);
        }
    }

    @Override
    @FrameworkInternal
    public Object __internalGet(String property) {
        switch (property) {
            case "userAccount": return this.userAccount;
            case "accountName": return this.accountName;
            case "accountNumber": return this.accountNumber;
            case "currencyCode": return this.currencyCode;
            case "createTime": return this.createTime;
            case "updateTime": return this.updateTime;
            case "paymentMethodList": return this.paymentMethodList;
            case "paymentTransactionList": return this.paymentTransactionList;
            default: return super.__internalGet(property);
        }
    }

}