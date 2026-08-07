
package com.example.enterpriseerpsystem.ticket;

import com.example.enterpriseerpsystem.customer.Customer;
import com.example.enterpriseerpsystem.ticketcomment.TicketComment;
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
public class Ticket extends BaseEntity implements RemoteInput {
    public static String INTERNAL_TYPE = "Ticket";

    public static final String DESCRIPTION_PROPERTY = "description";
    public static final String CREATED_AT_PROPERTY = "createdAt";
    public static final String CUSTOMER_PROPERTY = "customer";
    public static final String PRIORITY_PROPERTY = "priority";
    public static final String STATUS_PROPERTY = "status";
    public static final String SUBJECT_PROPERTY = "subject";
    public static final String CREATE_TIME_PROPERTY = "createTime";
    public static final String UPDATE_TIME_PROPERTY = "updateTime";
    public static final String TICKET_COMMENT_LIST_PROPERTY = "ticketCommentList";
    private String description;
    private LocalDateTime createdAt;
    private Customer customer;
    private String priority;
    private String status;
    private String subject;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private SmartList<TicketComment> ticketCommentList;

    public String getDescription(){
        return this.description;
    }
    public LocalDateTime getCreatedAt(){
        return this.createdAt;
    }
    public Customer getCustomer(){
        return this.customer;
    }
    public String getPriority(){
        return this.priority;
    }
    public String getStatus(){
        return this.status;
    }
    public String getSubject(){
        return this.subject;
    }
    public LocalDateTime getCreateTime(){
        return this.createTime;
    }
    public LocalDateTime getUpdateTime(){
        return this.updateTime;
    }
    public SmartList<TicketComment> getTicketCommentList(){
        return this.ticketCommentList;
    }
    public Ticket updateDescription(String description){
        description = (description == null ? null : description.trim());
        if(Objects.equals(this.description, description)){
            return this;
        }
        handleUpdate(DESCRIPTION_PROPERTY, getDescription(), description);
        this.description = description;
        return this;
    }
    public Ticket updateCreatedAt(LocalDateTime createdAt){
        if(Objects.equals(this.createdAt, createdAt)){
            return this;
        }
        handleUpdate(CREATED_AT_PROPERTY, getCreatedAt(), createdAt);
        this.createdAt = createdAt;
        return this;
    }
    public Ticket updateCustomer(Customer customer){
        if(Objects.equals(this.customer, customer)){
            return this;
        }
        handleUpdate(CUSTOMER_PROPERTY, getCustomer(), customer);
        this.customer = customer;
        return this;
    }
    public Ticket updatePriority(String priority){
        priority = (priority == null ? null : priority.trim());
        if(Objects.equals(this.priority, priority)){
            return this;
        }
        handleUpdate(PRIORITY_PROPERTY, getPriority(), priority);
        this.priority = priority;
        return this;
    }
    public Ticket updateStatus(String status){
        status = (status == null ? null : status.trim());
        if(Objects.equals(this.status, status)){
            return this;
        }
        handleUpdate(STATUS_PROPERTY, getStatus(), status);
        this.status = status;
        return this;
    }
    public Ticket updateSubject(String subject){
        subject = (subject == null ? null : subject.trim());
        if(Objects.equals(this.subject, subject)){
            return this;
        }
        handleUpdate(SUBJECT_PROPERTY, getSubject(), subject);
        this.subject = subject;
        return this;
    }
    public Ticket updateCreateTime(LocalDateTime createTime){
        if(Objects.equals(this.createTime, createTime)){
            return this;
        }
        handleUpdate(CREATE_TIME_PROPERTY, getCreateTime(), createTime);
        this.createTime = createTime;
        return this;
    }
    public Ticket updateUpdateTime(LocalDateTime updateTime){
        if(Objects.equals(this.updateTime, updateTime)){
            return this;
        }
        handleUpdate(UPDATE_TIME_PROPERTY, getUpdateTime(), updateTime);
        this.updateTime = updateTime;
        return this;
    }
    public Ticket addTicketComment(TicketComment ticketComment){
        if (ticketComment == null){
            return this;
        }

        if(null == this.ticketCommentList){
            this.ticketCommentList = new SmartList<>();
        }

        this.ticketCommentList.add(ticketComment);
        ticketComment.cacheRelation(TicketComment.TICKET_PROPERTY, this);
        return this;
    }

    public static Ticket refer(Long id){
        Ticket refer = new Ticket();
        refer.__internalSet("id", id);
        refer.set$status(EntityStatus.REFER);
        return refer;
    }
    @Override
    public String typeName(){
        return INTERNAL_TYPE;
    }

    public Ticket comment(String comment){
        this.setComment(comment);
        return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Audited<Ticket> auditAs(String action) {
        return super.auditAs(action);
    }

    // ===== Framework Internal: generated switch dispatch =====
    @Override
    @FrameworkInternal
    public void __internalSet(String property, Object value) {
        switch (property) {
            case "description": this.description = (value == null ? null : ((String)value).trim()); break;

            case "createdAt": this.createdAt = (LocalDateTime) value; break;

            case "customer": this.customer = (Customer) value; break;

            case "priority": this.priority = (value == null ? null : ((String)value).trim()); break;

            case "status": this.status = (value == null ? null : ((String)value).trim()); break;

            case "subject": this.subject = (value == null ? null : ((String)value).trim()); break;

            case "createTime": this.createTime = (LocalDateTime) value; break;

            case "updateTime": this.updateTime = (LocalDateTime) value; break;

            case "ticketCommentList": this.ticketCommentList = (SmartList<TicketComment>) value; break;
            default: super.__internalSet(property, value);
        }
    }

    @Override
    @FrameworkInternal
    public Object __internalGet(String property) {
        switch (property) {
            case "description": return this.description;
            case "createdAt": return this.createdAt;
            case "customer": return this.customer;
            case "priority": return this.priority;
            case "status": return this.status;
            case "subject": return this.subject;
            case "createTime": return this.createTime;
            case "updateTime": return this.updateTime;
            case "ticketCommentList": return this.ticketCommentList;
            default: return super.__internalGet(property);
        }
    }

}