
package com.example.enterpriseerpsystem.ticket;

import com.example.enterpriseerpsystem.customer.Customer;
import com.example.enterpriseerpsystem.customer.CustomerChecker;
import com.example.enterpriseerpsystem.ticketcomment.TicketComment;
import com.example.enterpriseerpsystem.ticketcomment.TicketCommentChecker;
import io.teaql.core.UserContext;
import io.teaql.core.checker.Checker;
import io.teaql.core.checker.ObjectLocation;
import java.time.LocalDateTime;

public class TicketChecker implements Checker<Ticket>{

    public String type(){
        return Ticket.INTERNAL_TYPE;
    }

    public void checkAndFix(UserContext _ctx, Ticket ticket, ObjectLocation _parentLocation){
        if(needCheck(_ctx, ticket)){
            markAsChecked(_ctx, ticket);
            doCheck(_ctx, ticket, _parentLocation);
        }
    }

    public void doCheck(UserContext _ctx, Ticket ticket, ObjectLocation _parentLocation){
      if((ticket == null)){
         return;
      }
      if(ticket.newItem()){
        if(ticket.getCreatedAt() == null){
           ticket.updateCreatedAt(java.time.LocalDateTime.now());
        }if(ticket.getCreateTime() == null){
           ticket.updateCreateTime(java.time.LocalDateTime.now());
        }if(ticket.getUpdateTime() == null){
           ticket.updateUpdateTime(java.time.LocalDateTime.now());
        }
      }else if(ticket.updateItem()){
        ticket.updateUpdateTime(java.time.LocalDateTime.now());
      }
      checkDescription(_ctx, ticket.getProperty(Ticket.DESCRIPTION_PROPERTY), newLocation(_parentLocation, Ticket.DESCRIPTION_PROPERTY));
      checkCreatedAt(_ctx, ticket.getProperty(Ticket.CREATED_AT_PROPERTY), newLocation(_parentLocation, Ticket.CREATED_AT_PROPERTY));
      checkCustomer(_ctx, ticket.getProperty(Ticket.CUSTOMER_PROPERTY), newLocation(_parentLocation, Ticket.CUSTOMER_PROPERTY));
      checkPriority(_ctx, ticket.getProperty(Ticket.PRIORITY_PROPERTY), newLocation(_parentLocation, Ticket.PRIORITY_PROPERTY));
      checkStatus(_ctx, ticket.getProperty(Ticket.STATUS_PROPERTY), newLocation(_parentLocation, Ticket.STATUS_PROPERTY));
      checkSubject(_ctx, ticket.getProperty(Ticket.SUBJECT_PROPERTY), newLocation(_parentLocation, Ticket.SUBJECT_PROPERTY));
      checkCreateTime(_ctx, ticket.getProperty(Ticket.CREATE_TIME_PROPERTY), newLocation(_parentLocation, Ticket.CREATE_TIME_PROPERTY));
      checkUpdateTime(_ctx, ticket.getProperty(Ticket.UPDATE_TIME_PROPERTY), newLocation(_parentLocation, Ticket.UPDATE_TIME_PROPERTY));
      for(int i = 0; ticket.getTicketCommentList() != null && i < ticket.getTicketCommentList().size(); i++){
         TicketComment ticketComment = ticket.getTicketCommentList().get(i);
         new TicketCommentChecker().checkAndFix(_ctx, ticketComment, newLocation(_parentLocation, Ticket.TICKET_COMMENT_LIST_PROPERTY, i));
      }
    }

    public void checkDescription(UserContext _ctx, String description, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, description);
    if((description == null)){
        return;
    }
    maxStringCheck(_ctx, _parentLocation, 100, description);

    }
    public void checkCreatedAt(UserContext _ctx, LocalDateTime createdAt, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, createdAt);
    if((createdAt == null)){
        return;
    }
    }
    public void checkCustomer(UserContext _ctx, Customer customer, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, customer);
    if((customer == null)){
        return;
    }
    new CustomerChecker().checkAndFix(_ctx, customer, _parentLocation);
    }
    public void checkPriority(UserContext _ctx, String priority, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, priority);
    if((priority == null)){
        return;
    }
    maxStringCheck(_ctx, _parentLocation, 100, priority);

    }
    public void checkStatus(UserContext _ctx, String status, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, status);
    if((status == null)){
        return;
    }
    maxStringCheck(_ctx, _parentLocation, 100, status);

    }
    public void checkSubject(UserContext _ctx, String subject, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, subject);
    if((subject == null)){
        return;
    }
    maxStringCheck(_ctx, _parentLocation, 100, subject);

    }
    public void checkCreateTime(UserContext _ctx, LocalDateTime createTime, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, createTime);
    if((createTime == null)){
        return;
    }
    }
    public void checkUpdateTime(UserContext _ctx, LocalDateTime updateTime, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, updateTime);
    if((updateTime == null)){
        return;
    }
    }
}