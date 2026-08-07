
package com.example.enterpriseerpsystem.ledger;

import com.example.enterpriseerpsystem.transaction.Transaction;
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
public class Ledger extends BaseEntity implements RemoteInput {
    public static String INTERNAL_TYPE = "Ledger";

    public static final String CREDIT_PROPERTY = "credit";
    public static final String DEBIT_PROPERTY = "debit";
    public static final String ENTRY_DATE_PROPERTY = "entryDate";
    public static final String TRANSACTION_PROPERTY = "transaction";
    public static final String CREATE_TIME_PROPERTY = "createTime";
    public static final String UPDATE_TIME_PROPERTY = "updateTime";
    private BigDecimal credit;
    private BigDecimal debit;
    private LocalDateTime entryDate;
    private Transaction transaction;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

    public BigDecimal getCredit(){
        return this.credit;
    }
    public BigDecimal getDebit(){
        return this.debit;
    }
    public LocalDateTime getEntryDate(){
        return this.entryDate;
    }
    public Transaction getTransaction(){
        return this.transaction;
    }
    public LocalDateTime getCreateTime(){
        return this.createTime;
    }
    public LocalDateTime getUpdateTime(){
        return this.updateTime;
    }
    public Ledger updateCredit(BigDecimal credit){
        if(Objects.equals(this.credit, credit)){
            return this;
        }
        handleUpdate(CREDIT_PROPERTY, getCredit(), credit);
        this.credit = credit;
        return this;
    }
    public Ledger updateDebit(BigDecimal debit){
        if(Objects.equals(this.debit, debit)){
            return this;
        }
        handleUpdate(DEBIT_PROPERTY, getDebit(), debit);
        this.debit = debit;
        return this;
    }
    public Ledger updateEntryDate(LocalDateTime entryDate){
        if(Objects.equals(this.entryDate, entryDate)){
            return this;
        }
        handleUpdate(ENTRY_DATE_PROPERTY, getEntryDate(), entryDate);
        this.entryDate = entryDate;
        return this;
    }
    public Ledger updateTransaction(Transaction transaction){
        if(Objects.equals(this.transaction, transaction)){
            return this;
        }
        handleUpdate(TRANSACTION_PROPERTY, getTransaction(), transaction);
        this.transaction = transaction;
        return this;
    }
    public Ledger updateCreateTime(LocalDateTime createTime){
        if(Objects.equals(this.createTime, createTime)){
            return this;
        }
        handleUpdate(CREATE_TIME_PROPERTY, getCreateTime(), createTime);
        this.createTime = createTime;
        return this;
    }
    public Ledger updateUpdateTime(LocalDateTime updateTime){
        if(Objects.equals(this.updateTime, updateTime)){
            return this;
        }
        handleUpdate(UPDATE_TIME_PROPERTY, getUpdateTime(), updateTime);
        this.updateTime = updateTime;
        return this;
    }

    public static Ledger refer(Long id){
        Ledger refer = new Ledger();
        refer.__internalSet("id", id);
        refer.set$status(EntityStatus.REFER);
        return refer;
    }
    @Override
    public String typeName(){
        return INTERNAL_TYPE;
    }

    public Ledger comment(String comment){
        this.setComment(comment);
        return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Audited<Ledger> auditAs(String action) {
        return super.auditAs(action);
    }

    // ===== Framework Internal: generated switch dispatch =====
    @Override
    @FrameworkInternal
    public void __internalSet(String property, Object value) {
        switch (property) {
            case "credit": this.credit = (BigDecimal) value; break;

            case "debit": this.debit = (BigDecimal) value; break;

            case "entryDate": this.entryDate = (LocalDateTime) value; break;

            case "transaction": this.transaction = (Transaction) value; break;

            case "createTime": this.createTime = (LocalDateTime) value; break;

            case "updateTime": this.updateTime = (LocalDateTime) value; break;

            default: super.__internalSet(property, value);
        }
    }

    @Override
    @FrameworkInternal
    public Object __internalGet(String property) {
        switch (property) {
            case "credit": return this.credit;
            case "debit": return this.debit;
            case "entryDate": return this.entryDate;
            case "transaction": return this.transaction;
            case "createTime": return this.createTime;
            case "updateTime": return this.updateTime;
            default: return super.__internalGet(property);
        }
    }

}