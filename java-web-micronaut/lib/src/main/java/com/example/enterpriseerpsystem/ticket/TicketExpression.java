
package com.example.enterpriseerpsystem.ticket;

import com.example.enterpriseerpsystem.customer.Customer;
import com.example.enterpriseerpsystem.customer.CustomerExpression;
import com.example.enterpriseerpsystem.ticketcomment.TicketComment;
import com.example.enterpriseerpsystem.ticketcomment.TicketCommentListExpression;
import io.teaql.core.UserContext;
import io.teaql.core.value.BaseEntityExpression;
import io.teaql.core.value.Expression;
import io.teaql.core.value.ExpressionAdaptor;
import java.time.LocalDateTime;
import java.util.function.Function;

public class TicketExpression<T, E, U extends Ticket> extends ExpressionAdaptor<T, E, U> implements BaseEntityExpression<T, U> {
    public TicketExpression(Expression<T, U> expression){
        super(expression);
    }

    public TicketExpression(Expression<T, E> expression, Function<E, U> function){
        super(expression, function);
    }

     public TicketExpression<T, U, U> updateId(Long id){
        return new TicketExpression(this, $it -> {((Ticket)$it).__internalSet("id", id); return this;});
     }

     public TicketExpression<T, U, U> save(UserContext userContext){
        return new TicketExpression(this, $it -> ((Ticket)$it).auditAs("Saved by Expression").save(userContext));
     }

     public TicketExpression<T, U, U> save(String intent, UserContext userContext){
        return new TicketExpression(this, $it -> ((Ticket)$it).auditAs(intent).save(userContext));
     }

     public boolean isNull() {
        return resolve() == null;
     }


    public Expression<T, String> getDescription(){
       return apply(Ticket::getDescription);
    }
    public TicketExpression<T, U, U> updateDescription(String description){
       return new TicketExpression(this, $it ->  ((Ticket)$it).updateDescription(description));
    }

    public Expression<T, LocalDateTime> getCreatedAt(){
       return apply(Ticket::getCreatedAt);
    }
    public TicketExpression<T, U, U> updateCreatedAt(LocalDateTime createdAt){
       return new TicketExpression(this, $it ->  ((Ticket)$it).updateCreatedAt(createdAt));
    }

    public CustomerExpression<T, U, Customer> getCustomer(){
       return new CustomerExpression(this, $it ->  ((Ticket)$it).getCustomer());
    }

    public TicketExpression<T, U, U> updateCustomer(Customer customer){
       return new TicketExpression(this, $it ->  ((Ticket)$it).updateCustomer(customer));
    }

    public Expression<T, String> getPriority(){
       return apply(Ticket::getPriority);
    }
    public TicketExpression<T, U, U> updatePriority(String priority){
       return new TicketExpression(this, $it ->  ((Ticket)$it).updatePriority(priority));
    }

    public Expression<T, String> getStatus(){
       return apply(Ticket::getStatus);
    }
    public TicketExpression<T, U, U> updateStatus(String status){
       return new TicketExpression(this, $it ->  ((Ticket)$it).updateStatus(status));
    }

    public Expression<T, String> getSubject(){
       return apply(Ticket::getSubject);
    }
    public TicketExpression<T, U, U> updateSubject(String subject){
       return new TicketExpression(this, $it ->  ((Ticket)$it).updateSubject(subject));
    }

    public Expression<T, LocalDateTime> getCreateTime(){
       return apply(Ticket::getCreateTime);
    }
    public TicketExpression<T, U, U> updateCreateTime(LocalDateTime createTime){
       return new TicketExpression(this, $it ->  ((Ticket)$it).updateCreateTime(createTime));
    }

    public Expression<T, LocalDateTime> getUpdateTime(){
       return apply(Ticket::getUpdateTime);
    }
    public TicketExpression<T, U, U> updateUpdateTime(LocalDateTime updateTime){
       return new TicketExpression(this, $it ->  ((Ticket)$it).updateUpdateTime(updateTime));
    }

    public TicketCommentListExpression<T, U, TicketComment> getTicketCommentList(){
        return new TicketCommentListExpression(this, $it ->  ((Ticket)$it).getTicketCommentList());
    }
    public TicketExpression<T, U, U> addTicketComment(TicketComment ticketComment){
       return new TicketExpression(this, $it ->  ((Ticket)$it).addTicketComment(ticketComment));
    }
}