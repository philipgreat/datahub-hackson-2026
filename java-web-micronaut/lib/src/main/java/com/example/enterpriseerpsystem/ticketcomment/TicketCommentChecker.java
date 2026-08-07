
package com.example.enterpriseerpsystem.ticketcomment;

import com.example.enterpriseerpsystem.ticket.Ticket;
import com.example.enterpriseerpsystem.ticket.TicketChecker;
import io.teaql.core.UserContext;
import io.teaql.core.checker.Checker;
import io.teaql.core.checker.ObjectLocation;
import java.time.LocalDateTime;

public class TicketCommentChecker implements Checker<TicketComment>{

    public String type(){
        return TicketComment.INTERNAL_TYPE;
    }

    public void checkAndFix(UserContext _ctx, TicketComment ticketComment, ObjectLocation _parentLocation){
        if(needCheck(_ctx, ticketComment)){
            markAsChecked(_ctx, ticketComment);
            doCheck(_ctx, ticketComment, _parentLocation);
        }
    }

    public void doCheck(UserContext _ctx, TicketComment ticketComment, ObjectLocation _parentLocation){
      if((ticketComment == null)){
         return;
      }
      if(ticketComment.newItem()){
        if(ticketComment.getCreatedAt() == null){
           ticketComment.updateCreatedAt(java.time.LocalDateTime.now());
        }if(ticketComment.getCreateTime() == null){
           ticketComment.updateCreateTime(java.time.LocalDateTime.now());
        }if(ticketComment.getUpdateTime() == null){
           ticketComment.updateUpdateTime(java.time.LocalDateTime.now());
        }
      }else if(ticketComment.updateItem()){
        ticketComment.updateUpdateTime(java.time.LocalDateTime.now());
      }
      checkAuthorId(_ctx, ticketComment.getProperty(TicketComment.AUTHOR_ID_PROPERTY), newLocation(_parentLocation, TicketComment.AUTHOR_ID_PROPERTY));
      checkCommentText(_ctx, ticketComment.getProperty(TicketComment.COMMENT_TEXT_PROPERTY), newLocation(_parentLocation, TicketComment.COMMENT_TEXT_PROPERTY));
      checkCreatedAt(_ctx, ticketComment.getProperty(TicketComment.CREATED_AT_PROPERTY), newLocation(_parentLocation, TicketComment.CREATED_AT_PROPERTY));
      checkTicket(_ctx, ticketComment.getProperty(TicketComment.TICKET_PROPERTY), newLocation(_parentLocation, TicketComment.TICKET_PROPERTY));
      checkCreateTime(_ctx, ticketComment.getProperty(TicketComment.CREATE_TIME_PROPERTY), newLocation(_parentLocation, TicketComment.CREATE_TIME_PROPERTY));
      checkUpdateTime(_ctx, ticketComment.getProperty(TicketComment.UPDATE_TIME_PROPERTY), newLocation(_parentLocation, TicketComment.UPDATE_TIME_PROPERTY));
    }

    public void checkAuthorId(UserContext _ctx, String authorId, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, authorId);
    if((authorId == null)){
        return;
    }
    maxStringCheck(_ctx, _parentLocation, 100, authorId);

    }
    public void checkCommentText(UserContext _ctx, String commentText, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, commentText);
    if((commentText == null)){
        return;
    }
    maxStringCheck(_ctx, _parentLocation, 100, commentText);

    }
    public void checkCreatedAt(UserContext _ctx, LocalDateTime createdAt, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, createdAt);
    if((createdAt == null)){
        return;
    }
    }
    public void checkTicket(UserContext _ctx, Ticket ticket, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, ticket);
    if((ticket == null)){
        return;
    }
    new TicketChecker().checkAndFix(_ctx, ticket, _parentLocation);
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