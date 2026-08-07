
package com.example.enterpriseerpsystem.account;

import com.example.enterpriseerpsystem.transaction.Transaction;
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
public class Account extends BaseEntity implements RemoteInput {
    public static String INTERNAL_TYPE = "Account";

    public static final String NAME_PROPERTY = "name";
    public static final String ACCOUNT_TYPE_PROPERTY = "accountType";
    public static final String BALANCE_PROPERTY = "balance";
    public static final String CURRENCY_PROPERTY = "currency";
    public static final String CREATE_TIME_PROPERTY = "createTime";
    public static final String UPDATE_TIME_PROPERTY = "updateTime";
    public static final String TRANSACTION_LIST_PROPERTY = "transactionList";
    private String name;
    private String accountType;
    private BigDecimal balance;
    private String currency;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private SmartList<Transaction> transactionList;

    public String getName(){
        return this.name;
    }
    public String getAccountType(){
        return this.accountType;
    }
    public BigDecimal getBalance(){
        return this.balance;
    }
    public String getCurrency(){
        return this.currency;
    }
    public LocalDateTime getCreateTime(){
        return this.createTime;
    }
    public LocalDateTime getUpdateTime(){
        return this.updateTime;
    }
    public SmartList<Transaction> getTransactionList(){
        return this.transactionList;
    }
    public Account updateName(String name){
        name = (name == null ? null : name.trim());
        if(Objects.equals(this.name, name)){
            return this;
        }
        handleUpdate(NAME_PROPERTY, getName(), name);
        this.name = name;
        return this;
    }
    public Account updateAccountType(String accountType){
        accountType = (accountType == null ? null : accountType.trim());
        if(Objects.equals(this.accountType, accountType)){
            return this;
        }
        handleUpdate(ACCOUNT_TYPE_PROPERTY, getAccountType(), accountType);
        this.accountType = accountType;
        return this;
    }
    public Account updateBalance(BigDecimal balance){
        if(Objects.equals(this.balance, balance)){
            return this;
        }
        handleUpdate(BALANCE_PROPERTY, getBalance(), balance);
        this.balance = balance;
        return this;
    }
    public Account updateCurrency(String currency){
        currency = (currency == null ? null : currency.trim());
        if(Objects.equals(this.currency, currency)){
            return this;
        }
        handleUpdate(CURRENCY_PROPERTY, getCurrency(), currency);
        this.currency = currency;
        return this;
    }
    public Account updateCreateTime(LocalDateTime createTime){
        if(Objects.equals(this.createTime, createTime)){
            return this;
        }
        handleUpdate(CREATE_TIME_PROPERTY, getCreateTime(), createTime);
        this.createTime = createTime;
        return this;
    }
    public Account updateUpdateTime(LocalDateTime updateTime){
        if(Objects.equals(this.updateTime, updateTime)){
            return this;
        }
        handleUpdate(UPDATE_TIME_PROPERTY, getUpdateTime(), updateTime);
        this.updateTime = updateTime;
        return this;
    }
    public Account addTransaction(Transaction transaction){
        if (transaction == null){
            return this;
        }

        if(null == this.transactionList){
            this.transactionList = new SmartList<>();
        }

        this.transactionList.add(transaction);
        transaction.cacheRelation(Transaction.ACCOUNT_PROPERTY, this);
        return this;
    }

    public static Account refer(Long id){
        Account refer = new Account();
        refer.__internalSet("id", id);
        refer.set$status(EntityStatus.REFER);
        return refer;
    }
    @Override
    public String typeName(){
        return INTERNAL_TYPE;
    }

    public Account comment(String comment){
        this.setComment(comment);
        return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Audited<Account> auditAs(String action) {
        return super.auditAs(action);
    }

    // ===== Framework Internal: generated switch dispatch =====
    @Override
    @FrameworkInternal
    public void __internalSet(String property, Object value) {
        switch (property) {
            case "name": this.name = (value == null ? null : ((String)value).trim()); break;

            case "accountType": this.accountType = (value == null ? null : ((String)value).trim()); break;

            case "balance": this.balance = (BigDecimal) value; break;

            case "currency": this.currency = (value == null ? null : ((String)value).trim()); break;

            case "createTime": this.createTime = (LocalDateTime) value; break;

            case "updateTime": this.updateTime = (LocalDateTime) value; break;

            case "transactionList": this.transactionList = (SmartList<Transaction>) value; break;
            default: super.__internalSet(property, value);
        }
    }

    @Override
    @FrameworkInternal
    public Object __internalGet(String property) {
        switch (property) {
            case "name": return this.name;
            case "accountType": return this.accountType;
            case "balance": return this.balance;
            case "currency": return this.currency;
            case "createTime": return this.createTime;
            case "updateTime": return this.updateTime;
            case "transactionList": return this.transactionList;
            default: return super.__internalGet(property);
        }
    }

}