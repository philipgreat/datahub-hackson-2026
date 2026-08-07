
package com.example.enterpriseerpsystem.ticketcomment;

import com.example.enterpriseerpsystem.ticket.Ticket;
import com.example.enterpriseerpsystem.ticket.TicketExpression;
import io.teaql.core.UserContext;
import io.teaql.core.value.BaseEntityExpression;
import io.teaql.core.value.Expression;
import io.teaql.core.value.ExpressionAdaptor;
import java.time.LocalDateTime;
import java.util.function.Function;

public class TicketCommentExpression<T, E, U extends TicketComment> extends ExpressionAdaptor<T, E, U> implements BaseEntityExpression<T, U> {
    public TicketCommentExpression(Expression<T, U> expression){
        super(expression);
    }

    public TicketCommentExpression(Expression<T, E> expression, Function<E, U> function){
        super(expression, function);
    }

     public TicketCommentExpression<T, U, U> updateId(Long id){
        return new TicketCommentExpression(this, $it -> {((TicketComment)$it).__internalSet("id", id); return this;});
     }

     public TicketCommentExpression<T, U, U> save(UserContext userContext){
        return new TicketCommentExpression(this, $it -> ((TicketComment)$it).auditAs("Saved by Expression").save(userContext));
     }

     public TicketCommentExpression<T, U, U> save(String intent, UserContext userContext){
        return new TicketCommentExpression(this, $it -> ((TicketComment)$it).auditAs(intent).save(userContext));
     }

     public boolean isNull() {
        return resolve() == null;
     }


    public Expression<T, String> getAuthorId(){
       return apply(TicketComment::getAuthorId);
    }
    public TicketCommentExpression<T, U, U> updateAuthorId(String authorId){
       return new TicketCommentExpression(this, $it ->  ((TicketComment)$it).updateAuthorId(authorId));
    }

    public Expression<T, String> getCommentText(){
       return apply(TicketComment::getCommentText);
    }
    public TicketCommentExpression<T, U, U> updateCommentText(String commentText){
       return new TicketCommentExpression(this, $it ->  ((TicketComment)$it).updateCommentText(commentText));
    }

    public Expression<T, LocalDateTime> getCreatedAt(){
       return apply(TicketComment::getCreatedAt);
    }
    public TicketCommentExpression<T, U, U> updateCreatedAt(LocalDateTime createdAt){
       return new TicketCommentExpression(this, $it ->  ((TicketComment)$it).updateCreatedAt(createdAt));
    }

    public TicketExpression<T, U, Ticket> getTicket(){
       return new TicketExpression(this, $it ->  ((TicketComment)$it).getTicket());
    }

    public TicketCommentExpression<T, U, U> updateTicket(Ticket ticket){
       return new TicketCommentExpression(this, $it ->  ((TicketComment)$it).updateTicket(ticket));
    }

    public Expression<T, LocalDateTime> getCreateTime(){
       return apply(TicketComment::getCreateTime);
    }
    public TicketCommentExpression<T, U, U> updateCreateTime(LocalDateTime createTime){
       return new TicketCommentExpression(this, $it ->  ((TicketComment)$it).updateCreateTime(createTime));
    }

    public Expression<T, LocalDateTime> getUpdateTime(){
       return apply(TicketComment::getUpdateTime);
    }
    public TicketCommentExpression<T, U, U> updateUpdateTime(LocalDateTime updateTime){
       return new TicketCommentExpression(this, $it ->  ((TicketComment)$it).updateUpdateTime(updateTime));
    }

}