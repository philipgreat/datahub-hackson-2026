
package com.example.enterpriseerpsystem.transaction;

import com.example.enterpriseerpsystem.account.Account;
import com.example.enterpriseerpsystem.ledger.Ledger;
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
public class Transaction extends BaseEntity implements RemoteInput {
    public static String INTERNAL_TYPE = "Transaction";

    public static final String AMOUNT_PROPERTY = "amount";
    public static final String ACCOUNT_PROPERTY = "account";
    public static final String TIMESTAMP_PROPERTY = "timestamp";
    public static final String TYPE_PROPERTY = "type";
    public static final String CREATE_TIME_PROPERTY = "createTime";
    public static final String UPDATE_TIME_PROPERTY = "updateTime";
    public static final String LEDGER_LIST_PROPERTY = "ledgerList";
    private BigDecimal amount;
    private Account account;
    private LocalDateTime timestamp;
    private String type;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private SmartList<Ledger> ledgerList;

    public BigDecimal getAmount(){
        return this.amount;
    }
    public Account getAccount(){
        return this.account;
    }
    public LocalDateTime getTimestamp(){
        return this.timestamp;
    }
    public String getType(){
        return this.type;
    }
    public LocalDateTime getCreateTime(){
        return this.createTime;
    }
    public LocalDateTime getUpdateTime(){
        return this.updateTime;
    }
    public SmartList<Ledger> getLedgerList(){
        return this.ledgerList;
    }
    public Transaction updateAmount(BigDecimal amount){
        if(Objects.equals(this.amount, amount)){
            return this;
        }
        handleUpdate(AMOUNT_PROPERTY, getAmount(), amount);
        this.amount = amount;
        return this;
    }
    public Transaction updateAccount(Account account){
        if(Objects.equals(this.account, account)){
            return this;
        }
        handleUpdate(ACCOUNT_PROPERTY, getAccount(), account);
        this.account = account;
        return this;
    }
    public Transaction updateTimestamp(LocalDateTime timestamp){
        if(Objects.equals(this.timestamp, timestamp)){
            return this;
        }
        handleUpdate(TIMESTAMP_PROPERTY, getTimestamp(), timestamp);
        this.timestamp = timestamp;
        return this;
    }
    public Transaction updateType(String type){
        type = (type == null ? null : type.trim());
        if(Objects.equals(this.type, type)){
            return this;
        }
        handleUpdate(TYPE_PROPERTY, getType(), type);
        this.type = type;
        return this;
    }
    public Transaction updateCreateTime(LocalDateTime createTime){
        if(Objects.equals(this.createTime, createTime)){
            return this;
        }
        handleUpdate(CREATE_TIME_PROPERTY, getCreateTime(), createTime);
        this.createTime = createTime;
        return this;
    }
    public Transaction updateUpdateTime(LocalDateTime updateTime){
        if(Objects.equals(this.updateTime, updateTime)){
            return this;
        }
        handleUpdate(UPDATE_TIME_PROPERTY, getUpdateTime(), updateTime);
        this.updateTime = updateTime;
        return this;
    }
    public Transaction addLedger(Ledger ledger){
        if (ledger == null){
            return this;
        }

        if(null == this.ledgerList){
            this.ledgerList = new SmartList<>();
        }

        this.ledgerList.add(ledger);
        ledger.cacheRelation(Ledger.TRANSACTION_PROPERTY, this);
        return this;
    }

    public static Transaction refer(Long id){
        Transaction refer = new Transaction();
        refer.__internalSet("id", id);
        refer.set$status(EntityStatus.REFER);
        return refer;
    }
    @Override
    public String typeName(){
        return INTERNAL_TYPE;
    }

    public Transaction comment(String comment){
        this.setComment(comment);
        return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Audited<Transaction> auditAs(String action) {
        return super.auditAs(action);
    }

    // ===== Framework Internal: generated switch dispatch =====
    @Override
    @FrameworkInternal
    public void __internalSet(String property, Object value) {
        switch (property) {
            case "amount": this.amount = (BigDecimal) value; break;

            case "account": this.account = (Account) value; break;

            case "timestamp": this.timestamp = (LocalDateTime) value; break;

            case "type": this.type = (value == null ? null : ((String)value).trim()); break;

            case "createTime": this.createTime = (LocalDateTime) value; break;

            case "updateTime": this.updateTime = (LocalDateTime) value; break;

            case "ledgerList": this.ledgerList = (SmartList<Ledger>) value; break;
            default: super.__internalSet(property, value);
        }
    }

    @Override
    @FrameworkInternal
    public Object __internalGet(String property) {
        switch (property) {
            case "amount": return this.amount;
            case "account": return this.account;
            case "timestamp": return this.timestamp;
            case "type": return this.type;
            case "createTime": return this.createTime;
            case "updateTime": return this.updateTime;
            case "ledgerList": return this.ledgerList;
            default: return super.__internalGet(property);
        }
    }

}