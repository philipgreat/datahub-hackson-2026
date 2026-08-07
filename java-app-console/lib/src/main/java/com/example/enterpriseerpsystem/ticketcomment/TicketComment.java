
package com.example.enterpriseerpsystem.ticketcomment;

import com.example.enterpriseerpsystem.ticket.Ticket;
import io.teaql.core.Audited;
import io.teaql.core.BaseEntity;
import io.teaql.core.EntityStatus;
import io.teaql.core.FrameworkInternal;
import io.teaql.core.RemoteInput;
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
public class TicketComment extends BaseEntity implements RemoteInput {
    public static String INTERNAL_TYPE = "TicketComment";

    public static final String AUTHOR_ID_PROPERTY = "authorId";
    public static final String COMMENT_TEXT_PROPERTY = "commentText";
    public static final String CREATED_AT_PROPERTY = "createdAt";
    public static final String TICKET_PROPERTY = "ticket";
    public static final String CREATE_TIME_PROPERTY = "createTime";
    public static final String UPDATE_TIME_PROPERTY = "updateTime";
    private String authorId;
    private String commentText;
    private LocalDateTime createdAt;
    private Ticket ticket;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

    public String getAuthorId(){
        return this.authorId;
    }
    public String getCommentText(){
        return this.commentText;
    }
    public LocalDateTime getCreatedAt(){
        return this.createdAt;
    }
    public Ticket getTicket(){
        return this.ticket;
    }
    public LocalDateTime getCreateTime(){
        return this.createTime;
    }
    public LocalDateTime getUpdateTime(){
        return this.updateTime;
    }
    public TicketComment updateAuthorId(String authorId){
        authorId = (authorId == null ? null : authorId.trim());
        if(Objects.equals(this.authorId, authorId)){
            return this;
        }
        handleUpdate(AUTHOR_ID_PROPERTY, getAuthorId(), authorId);
        this.authorId = authorId;
        return this;
    }
    public TicketComment updateCommentText(String commentText){
        commentText = (commentText == null ? null : commentText.trim());
        if(Objects.equals(this.commentText, commentText)){
            return this;
        }
        handleUpdate(COMMENT_TEXT_PROPERTY, getCommentText(), commentText);
        this.commentText = commentText;
        return this;
    }
    public TicketComment updateCreatedAt(LocalDateTime createdAt){
        if(Objects.equals(this.createdAt, createdAt)){
            return this;
        }
        handleUpdate(CREATED_AT_PROPERTY, getCreatedAt(), createdAt);
        this.createdAt = createdAt;
        return this;
    }
    public TicketComment updateTicket(Ticket ticket){
        if(Objects.equals(this.ticket, ticket)){
            return this;
        }
        handleUpdate(TICKET_PROPERTY, getTicket(), ticket);
        this.ticket = ticket;
        return this;
    }
    public TicketComment updateCreateTime(LocalDateTime createTime){
        if(Objects.equals(this.createTime, createTime)){
            return this;
        }
        handleUpdate(CREATE_TIME_PROPERTY, getCreateTime(), createTime);
        this.createTime = createTime;
        return this;
    }
    public TicketComment updateUpdateTime(LocalDateTime updateTime){
        if(Objects.equals(this.updateTime, updateTime)){
            return this;
        }
        handleUpdate(UPDATE_TIME_PROPERTY, getUpdateTime(), updateTime);
        this.updateTime = updateTime;
        return this;
    }

    public static TicketComment refer(Long id){
        TicketComment refer = new TicketComment();
        refer.__internalSet("id", id);
        refer.set$status(EntityStatus.REFER);
        return refer;
    }
    @Override
    public String typeName(){
        return INTERNAL_TYPE;
    }

    public TicketComment comment(String comment){
        this.setComment(comment);
        return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Audited<TicketComment> auditAs(String action) {
        return super.auditAs(action);
    }

    // ===== Framework Internal: generated switch dispatch =====
    @Override
    @FrameworkInternal
    public void __internalSet(String property, Object value) {
        switch (property) {
            case "authorId": this.authorId = (value == null ? null : ((String)value).trim()); break;

            case "commentText": this.commentText = (value == null ? null : ((String)value).trim()); break;

            case "createdAt": this.createdAt = (LocalDateTime) value; break;

            case "ticket": this.ticket = (Ticket) value; break;

            case "createTime": this.createTime = (LocalDateTime) value; break;

            case "updateTime": this.updateTime = (LocalDateTime) value; break;

            default: super.__internalSet(property, value);
        }
    }

    @Override
    @FrameworkInternal
    public Object __internalGet(String property) {
        switch (property) {
            case "authorId": return this.authorId;
            case "commentText": return this.commentText;
            case "createdAt": return this.createdAt;
            case "ticket": return this.ticket;
            case "createTime": return this.createTime;
            case "updateTime": return this.updateTime;
            default: return super.__internalGet(property);
        }
    }

}