
package com.example.enterpriseerpsystem.contact;

import com.example.enterpriseerpsystem.customer.Customer;
import com.example.enterpriseerpsystem.customer.CustomerChecker;
import io.teaql.core.UserContext;
import io.teaql.core.checker.Checker;
import io.teaql.core.checker.ObjectLocation;
import java.time.LocalDateTime;

public class ContactChecker implements Checker<Contact>{

    public String type(){
        return Contact.INTERNAL_TYPE;
    }

    public void checkAndFix(UserContext _ctx, Contact contact, ObjectLocation _parentLocation){
        if(needCheck(_ctx, contact)){
            markAsChecked(_ctx, contact);
            doCheck(_ctx, contact, _parentLocation);
        }
    }

    public void doCheck(UserContext _ctx, Contact contact, ObjectLocation _parentLocation){
      if((contact == null)){
         return;
      }
      if(contact.newItem()){
        if(contact.getCreateTime() == null){
           contact.updateCreateTime(java.time.LocalDateTime.now());
        }if(contact.getUpdateTime() == null){
           contact.updateUpdateTime(java.time.LocalDateTime.now());
        }
      }else if(contact.updateItem()){
        contact.updateUpdateTime(java.time.LocalDateTime.now());
      }
      checkEmail(_ctx, contact.getProperty(Contact.EMAIL_PROPERTY), newLocation(_parentLocation, Contact.EMAIL_PROPERTY));
      checkName(_ctx, contact.getProperty(Contact.NAME_PROPERTY), newLocation(_parentLocation, Contact.NAME_PROPERTY));
      checkPhone(_ctx, contact.getProperty(Contact.PHONE_PROPERTY), newLocation(_parentLocation, Contact.PHONE_PROPERTY));
      checkCustomer(_ctx, contact.getProperty(Contact.CUSTOMER_PROPERTY), newLocation(_parentLocation, Contact.CUSTOMER_PROPERTY));
      checkRole(_ctx, contact.getProperty(Contact.ROLE_PROPERTY), newLocation(_parentLocation, Contact.ROLE_PROPERTY));
      checkCreateTime(_ctx, contact.getProperty(Contact.CREATE_TIME_PROPERTY), newLocation(_parentLocation, Contact.CREATE_TIME_PROPERTY));
      checkUpdateTime(_ctx, contact.getProperty(Contact.UPDATE_TIME_PROPERTY), newLocation(_parentLocation, Contact.UPDATE_TIME_PROPERTY));
    }

    public void checkEmail(UserContext _ctx, String email, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, email);
    if((email == null)){
        return;
    }
    maxStringCheck(_ctx, _parentLocation, 100, email);

    }
    public void checkName(UserContext _ctx, String name, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, name);
    if((name == null)){
        return;
    }
    maxStringCheck(_ctx, _parentLocation, 100, name);

    }
    public void checkPhone(UserContext _ctx, String phone, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, phone);
    if((phone == null)){
        return;
    }
    maxStringCheck(_ctx, _parentLocation, 100, phone);

    }
    public void checkCustomer(UserContext _ctx, Customer customer, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, customer);
    if((customer == null)){
        return;
    }
    new CustomerChecker().checkAndFix(_ctx, customer, _parentLocation);
    }
    public void checkRole(UserContext _ctx, String role, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, role);
    if((role == null)){
        return;
    }
    maxStringCheck(_ctx, _parentLocation, 100, role);

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