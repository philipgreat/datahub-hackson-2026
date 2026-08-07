
package com.example.enterpriseerpsystem.opportunity;

import com.example.enterpriseerpsystem.lead.Lead;
import com.example.enterpriseerpsystem.quote.Quote;
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
public class Opportunity extends BaseEntity implements RemoteInput {
    public static String INTERNAL_TYPE = "Opportunity";

    public static final String CLOSE_DATE_PROPERTY = "closeDate";
    public static final String EXPECTED_REVENUE_PROPERTY = "expectedRevenue";
    public static final String LEAD_PROPERTY = "lead";
    public static final String PROBABILITY_PROPERTY = "probability";
    public static final String STATUS_PROPERTY = "status";
    public static final String CREATE_TIME_PROPERTY = "createTime";
    public static final String UPDATE_TIME_PROPERTY = "updateTime";
    public static final String QUOTE_LIST_PROPERTY = "quoteList";
    private LocalDateTime closeDate;
    private BigDecimal expectedRevenue;
    private Lead lead;
    private BigDecimal probability;
    private String status;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private SmartList<Quote> quoteList;

    public LocalDateTime getCloseDate(){
        return this.closeDate;
    }
    public BigDecimal getExpectedRevenue(){
        return this.expectedRevenue;
    }
    public Lead getLead(){
        return this.lead;
    }
    public BigDecimal getProbability(){
        return this.probability;
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
    public SmartList<Quote> getQuoteList(){
        return this.quoteList;
    }
    public Opportunity updateCloseDate(LocalDateTime closeDate){
        if(Objects.equals(this.closeDate, closeDate)){
            return this;
        }
        handleUpdate(CLOSE_DATE_PROPERTY, getCloseDate(), closeDate);
        this.closeDate = closeDate;
        return this;
    }
    public Opportunity updateExpectedRevenue(BigDecimal expectedRevenue){
        if(Objects.equals(this.expectedRevenue, expectedRevenue)){
            return this;
        }
        handleUpdate(EXPECTED_REVENUE_PROPERTY, getExpectedRevenue(), expectedRevenue);
        this.expectedRevenue = expectedRevenue;
        return this;
    }
    public Opportunity updateLead(Lead lead){
        if(Objects.equals(this.lead, lead)){
            return this;
        }
        handleUpdate(LEAD_PROPERTY, getLead(), lead);
        this.lead = lead;
        return this;
    }
    public Opportunity updateProbability(BigDecimal probability){
        if(Objects.equals(this.probability, probability)){
            return this;
        }
        handleUpdate(PROBABILITY_PROPERTY, getProbability(), probability);
        this.probability = probability;
        return this;
    }
    public Opportunity updateStatus(String status){
        status = (status == null ? null : status.trim());
        if(Objects.equals(this.status, status)){
            return this;
        }
        handleUpdate(STATUS_PROPERTY, getStatus(), status);
        this.status = status;
        return this;
    }
    public Opportunity updateCreateTime(LocalDateTime createTime){
        if(Objects.equals(this.createTime, createTime)){
            return this;
        }
        handleUpdate(CREATE_TIME_PROPERTY, getCreateTime(), createTime);
        this.createTime = createTime;
        return this;
    }
    public Opportunity updateUpdateTime(LocalDateTime updateTime){
        if(Objects.equals(this.updateTime, updateTime)){
            return this;
        }
        handleUpdate(UPDATE_TIME_PROPERTY, getUpdateTime(), updateTime);
        this.updateTime = updateTime;
        return this;
    }
    public Opportunity addQuote(Quote quote){
        if (quote == null){
            return this;
        }

        if(null == this.quoteList){
            this.quoteList = new SmartList<>();
        }

        this.quoteList.add(quote);
        quote.cacheRelation(Quote.OPPORTUNITY_PROPERTY, this);
        return this;
    }

    public static Opportunity refer(Long id){
        Opportunity refer = new Opportunity();
        refer.__internalSet("id", id);
        refer.set$status(EntityStatus.REFER);
        return refer;
    }
    @Override
    public String typeName(){
        return INTERNAL_TYPE;
    }

    public Opportunity comment(String comment){
        this.setComment(comment);
        return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Audited<Opportunity> auditAs(String action) {
        return super.auditAs(action);
    }

    // ===== Framework Internal: generated switch dispatch =====
    @Override
    @FrameworkInternal
    public void __internalSet(String property, Object value) {
        switch (property) {
            case "closeDate": this.closeDate = (LocalDateTime) value; break;

            case "expectedRevenue": this.expectedRevenue = (BigDecimal) value; break;

            case "lead": this.lead = (Lead) value; break;

            case "probability": this.probability = (BigDecimal) value; break;

            case "status": this.status = (value == null ? null : ((String)value).trim()); break;

            case "createTime": this.createTime = (LocalDateTime) value; break;

            case "updateTime": this.updateTime = (LocalDateTime) value; break;

            case "quoteList": this.quoteList = (SmartList<Quote>) value; break;
            default: super.__internalSet(property, value);
        }
    }

    @Override
    @FrameworkInternal
    public Object __internalGet(String property) {
        switch (property) {
            case "closeDate": return this.closeDate;
            case "expectedRevenue": return this.expectedRevenue;
            case "lead": return this.lead;
            case "probability": return this.probability;
            case "status": return this.status;
            case "createTime": return this.createTime;
            case "updateTime": return this.updateTime;
            case "quoteList": return this.quoteList;
            default: return super.__internalGet(property);
        }
    }

}