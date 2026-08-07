
package com.example.enterpriseerpsystem.customer;

import com.example.enterpriseerpsystem.contact.Contact;
import com.example.enterpriseerpsystem.contact.ContactChecker;
import com.example.enterpriseerpsystem.contract.Contract;
import com.example.enterpriseerpsystem.contract.ContractChecker;
import com.example.enterpriseerpsystem.globalorder.GlobalOrder;
import com.example.enterpriseerpsystem.globalorder.GlobalOrderChecker;
import com.example.enterpriseerpsystem.invoice.Invoice;
import com.example.enterpriseerpsystem.invoice.InvoiceChecker;
import com.example.enterpriseerpsystem.productreview.ProductReview;
import com.example.enterpriseerpsystem.productreview.ProductReviewChecker;
import com.example.enterpriseerpsystem.returnrequest.ReturnRequest;
import com.example.enterpriseerpsystem.returnrequest.ReturnRequestChecker;
import com.example.enterpriseerpsystem.shoppingcart.ShoppingCart;
import com.example.enterpriseerpsystem.shoppingcart.ShoppingCartChecker;
import com.example.enterpriseerpsystem.ticket.Ticket;
import com.example.enterpriseerpsystem.ticket.TicketChecker;
import com.example.enterpriseerpsystem.wishlist.Wishlist;
import com.example.enterpriseerpsystem.wishlist.WishlistChecker;
import io.teaql.core.UserContext;
import io.teaql.core.checker.Checker;
import io.teaql.core.checker.ObjectLocation;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class CustomerChecker implements Checker<Customer>{

    public String type(){
        return Customer.INTERNAL_TYPE;
    }

    public void checkAndFix(UserContext _ctx, Customer customer, ObjectLocation _parentLocation){
        if(needCheck(_ctx, customer)){
            markAsChecked(_ctx, customer);
            doCheck(_ctx, customer, _parentLocation);
        }
    }

    public void doCheck(UserContext _ctx, Customer customer, ObjectLocation _parentLocation){
      if((customer == null)){
         return;
      }
      if(customer.newItem()){
        if(customer.getCreatedAt() == null){
           customer.updateCreatedAt(java.time.LocalDateTime.now());
        }if(customer.getCreateTime() == null){
           customer.updateCreateTime(java.time.LocalDateTime.now());
        }if(customer.getUpdateTime() == null){
           customer.updateUpdateTime(java.time.LocalDateTime.now());
        }
      }else if(customer.updateItem()){
        customer.updateUpdateTime(java.time.LocalDateTime.now());
      }
      checkAddress(_ctx, customer.getProperty(Customer.ADDRESS_PROPERTY), newLocation(_parentLocation, Customer.ADDRESS_PROPERTY));
      checkEmail(_ctx, customer.getProperty(Customer.EMAIL_PROPERTY), newLocation(_parentLocation, Customer.EMAIL_PROPERTY));
      checkName(_ctx, customer.getProperty(Customer.NAME_PROPERTY), newLocation(_parentLocation, Customer.NAME_PROPERTY));
      checkPhone(_ctx, customer.getProperty(Customer.PHONE_PROPERTY), newLocation(_parentLocation, Customer.PHONE_PROPERTY));
      checkCreatedAt(_ctx, customer.getProperty(Customer.CREATED_AT_PROPERTY), newLocation(_parentLocation, Customer.CREATED_AT_PROPERTY));
      checkLoyaltyPoints(_ctx, customer.getProperty(Customer.LOYALTY_POINTS_PROPERTY), newLocation(_parentLocation, Customer.LOYALTY_POINTS_PROPERTY));
      checkCreateTime(_ctx, customer.getProperty(Customer.CREATE_TIME_PROPERTY), newLocation(_parentLocation, Customer.CREATE_TIME_PROPERTY));
      checkUpdateTime(_ctx, customer.getProperty(Customer.UPDATE_TIME_PROPERTY), newLocation(_parentLocation, Customer.UPDATE_TIME_PROPERTY));
      for(int i = 0; customer.getContactList() != null && i < customer.getContactList().size(); i++){
         Contact contact = customer.getContactList().get(i);
         new ContactChecker().checkAndFix(_ctx, contact, newLocation(_parentLocation, Customer.CONTACT_LIST_PROPERTY, i));
      }
      for(int i = 0; customer.getContractList() != null && i < customer.getContractList().size(); i++){
         Contract contract = customer.getContractList().get(i);
         new ContractChecker().checkAndFix(_ctx, contract, newLocation(_parentLocation, Customer.CONTRACT_LIST_PROPERTY, i));
      }
      for(int i = 0; customer.getProductReviewList() != null && i < customer.getProductReviewList().size(); i++){
         ProductReview productReview = customer.getProductReviewList().get(i);
         new ProductReviewChecker().checkAndFix(_ctx, productReview, newLocation(_parentLocation, Customer.PRODUCT_REVIEW_LIST_PROPERTY, i));
      }
      for(int i = 0; customer.getShoppingCartList() != null && i < customer.getShoppingCartList().size(); i++){
         ShoppingCart shoppingCart = customer.getShoppingCartList().get(i);
         new ShoppingCartChecker().checkAndFix(_ctx, shoppingCart, newLocation(_parentLocation, Customer.SHOPPING_CART_LIST_PROPERTY, i));
      }
      for(int i = 0; customer.getGlobalOrderList() != null && i < customer.getGlobalOrderList().size(); i++){
         GlobalOrder globalOrder = customer.getGlobalOrderList().get(i);
         new GlobalOrderChecker().checkAndFix(_ctx, globalOrder, newLocation(_parentLocation, Customer.GLOBAL_ORDER_LIST_PROPERTY, i));
      }
      for(int i = 0; customer.getWishlistList() != null && i < customer.getWishlistList().size(); i++){
         Wishlist wishlist = customer.getWishlistList().get(i);
         new WishlistChecker().checkAndFix(_ctx, wishlist, newLocation(_parentLocation, Customer.WISHLIST_LIST_PROPERTY, i));
      }
      for(int i = 0; customer.getInvoiceList() != null && i < customer.getInvoiceList().size(); i++){
         Invoice invoice = customer.getInvoiceList().get(i);
         new InvoiceChecker().checkAndFix(_ctx, invoice, newLocation(_parentLocation, Customer.INVOICE_LIST_PROPERTY, i));
      }
      for(int i = 0; customer.getReturnRequestList() != null && i < customer.getReturnRequestList().size(); i++){
         ReturnRequest returnRequest = customer.getReturnRequestList().get(i);
         new ReturnRequestChecker().checkAndFix(_ctx, returnRequest, newLocation(_parentLocation, Customer.RETURN_REQUEST_LIST_PROPERTY, i));
      }
      for(int i = 0; customer.getTicketList() != null && i < customer.getTicketList().size(); i++){
         Ticket ticket = customer.getTicketList().get(i);
         new TicketChecker().checkAndFix(_ctx, ticket, newLocation(_parentLocation, Customer.TICKET_LIST_PROPERTY, i));
      }
    }

    public void checkAddress(UserContext _ctx, String address, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, address);
    if((address == null)){
        return;
    }
    maxStringCheck(_ctx, _parentLocation, 100, address);

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
    public void checkCreatedAt(UserContext _ctx, LocalDateTime createdAt, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, createdAt);
    if((createdAt == null)){
        return;
    }
    }
    public void checkLoyaltyPoints(UserContext _ctx, BigDecimal loyaltyPoints, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, loyaltyPoints);
    if((loyaltyPoints == null)){
        return;
    }
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