
package com.example.paymentservice.useraccount;

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
public class UserAccount extends BaseEntity implements RemoteInput {
    public static String INTERNAL_TYPE = "UserAccount";

    public static final String USER_NAME_PROPERTY = "userName";
    public static final String CREATE_TIME_PROPERTY = "createTime";
    public static final String UPDATE_TIME_PROPERTY = "updateTime";
    public static final String PAYMENT_TRANSACTION_LIST_PROPERTY = "paymentTransactionList";
    private String userName;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private SmartList<PaymentTransaction> paymentTransactionList;

    public String getUserName(){
        return this.userName;
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
    public UserAccount updateUserName(String userName){
        userName = (userName == null ? null : userName.trim());
        if(Objects.equals(this.userName, userName)){
            return this;
        }
        handleUpdate(USER_NAME_PROPERTY, getUserName(), userName);
        this.userName = userName;
        return this;
    }
    public UserAccount updateCreateTime(LocalDateTime createTime){
        if(Objects.equals(this.createTime, createTime)){
            return this;
        }
        handleUpdate(CREATE_TIME_PROPERTY, getCreateTime(), createTime);
        this.createTime = createTime;
        return this;
    }
    public UserAccount updateUpdateTime(LocalDateTime updateTime){
        if(Objects.equals(this.updateTime, updateTime)){
            return this;
        }
        handleUpdate(UPDATE_TIME_PROPERTY, getUpdateTime(), updateTime);
        this.updateTime = updateTime;
        return this;
    }
    public UserAccount addPaymentTransaction(PaymentTransaction paymentTransaction){
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

    public static UserAccount refer(Long id){
        UserAccount refer = new UserAccount();
        refer.__internalSet("id", id);
        refer.set$status(EntityStatus.REFER);
        return refer;
    }
    @Override
    public String typeName(){
        return INTERNAL_TYPE;
    }

    public UserAccount comment(String comment){
        this.setComment(comment);
        return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Audited<UserAccount> auditAs(String action) {
        return super.auditAs(action);
    }

    // ===== Framework Internal: generated switch dispatch =====
    @Override
    @FrameworkInternal
    public void __internalSet(String property, Object value) {
        switch (property) {
            case "userName": this.userName = (value == null ? null : ((String)value).trim()); break;

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
            case "userName": return this.userName;
            case "createTime": return this.createTime;
            case "updateTime": return this.updateTime;
            case "paymentTransactionList": return this.paymentTransactionList;
            default: return super.__internalGet(property);
        }
    }

}