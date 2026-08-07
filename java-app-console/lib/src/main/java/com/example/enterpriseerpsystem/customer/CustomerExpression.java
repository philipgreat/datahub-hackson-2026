
package com.example.enterpriseerpsystem.customer;

import com.example.enterpriseerpsystem.contact.Contact;
import com.example.enterpriseerpsystem.contact.ContactListExpression;
import com.example.enterpriseerpsystem.contract.Contract;
import com.example.enterpriseerpsystem.contract.ContractListExpression;
import com.example.enterpriseerpsystem.globalorder.GlobalOrder;
import com.example.enterpriseerpsystem.globalorder.GlobalOrderListExpression;
import com.example.enterpriseerpsystem.invoice.Invoice;
import com.example.enterpriseerpsystem.invoice.InvoiceListExpression;
import com.example.enterpriseerpsystem.productreview.ProductReview;
import com.example.enterpriseerpsystem.productreview.ProductReviewListExpression;
import com.example.enterpriseerpsystem.returnrequest.ReturnRequest;
import com.example.enterpriseerpsystem.returnrequest.ReturnRequestListExpression;
import com.example.enterpriseerpsystem.shoppingcart.ShoppingCart;
import com.example.enterpriseerpsystem.shoppingcart.ShoppingCartListExpression;
import com.example.enterpriseerpsystem.ticket.Ticket;
import com.example.enterpriseerpsystem.ticket.TicketListExpression;
import com.example.enterpriseerpsystem.wishlist.Wishlist;
import com.example.enterpriseerpsystem.wishlist.WishlistListExpression;
import io.teaql.core.UserContext;
import io.teaql.core.value.BaseEntityExpression;
import io.teaql.core.value.Expression;
import io.teaql.core.value.ExpressionAdaptor;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.function.Function;

public class CustomerExpression<T, E, U extends Customer> extends ExpressionAdaptor<T, E, U> implements BaseEntityExpression<T, U> {
    public CustomerExpression(Expression<T, U> expression){
        super(expression);
    }

    public CustomerExpression(Expression<T, E> expression, Function<E, U> function){
        super(expression, function);
    }

     public CustomerExpression<T, U, U> updateId(Long id){
        return new CustomerExpression(this, $it -> {((Customer)$it).__internalSet("id", id); return this;});
     }

     public CustomerExpression<T, U, U> save(UserContext userContext){
        return new CustomerExpression(this, $it -> ((Customer)$it).auditAs("Saved by Expression").save(userContext));
     }

     public CustomerExpression<T, U, U> save(String intent, UserContext userContext){
        return new CustomerExpression(this, $it -> ((Customer)$it).auditAs(intent).save(userContext));
     }

     public boolean isNull() {
        return resolve() == null;
     }


    public Expression<T, String> getAddress(){
       return apply(Customer::getAddress);
    }
    public CustomerExpression<T, U, U> updateAddress(String address){
       return new CustomerExpression(this, $it ->  ((Customer)$it).updateAddress(address));
    }

    public Expression<T, String> getEmail(){
       return apply(Customer::getEmail);
    }
    public CustomerExpression<T, U, U> updateEmail(String email){
       return new CustomerExpression(this, $it ->  ((Customer)$it).updateEmail(email));
    }

    public Expression<T, String> getName(){
       return apply(Customer::getName);
    }
    public CustomerExpression<T, U, U> updateName(String name){
       return new CustomerExpression(this, $it ->  ((Customer)$it).updateName(name));
    }

    public Expression<T, String> getPhone(){
       return apply(Customer::getPhone);
    }
    public CustomerExpression<T, U, U> updatePhone(String phone){
       return new CustomerExpression(this, $it ->  ((Customer)$it).updatePhone(phone));
    }

    public Expression<T, LocalDateTime> getCreatedAt(){
       return apply(Customer::getCreatedAt);
    }
    public CustomerExpression<T, U, U> updateCreatedAt(LocalDateTime createdAt){
       return new CustomerExpression(this, $it ->  ((Customer)$it).updateCreatedAt(createdAt));
    }

    public Expression<T, BigDecimal> getLoyaltyPoints(){
       return apply(Customer::getLoyaltyPoints);
    }
    public CustomerExpression<T, U, U> updateLoyaltyPoints(BigDecimal loyaltyPoints){
       return new CustomerExpression(this, $it ->  ((Customer)$it).updateLoyaltyPoints(loyaltyPoints));
    }

    public Expression<T, LocalDateTime> getCreateTime(){
       return apply(Customer::getCreateTime);
    }
    public CustomerExpression<T, U, U> updateCreateTime(LocalDateTime createTime){
       return new CustomerExpression(this, $it ->  ((Customer)$it).updateCreateTime(createTime));
    }

    public Expression<T, LocalDateTime> getUpdateTime(){
       return apply(Customer::getUpdateTime);
    }
    public CustomerExpression<T, U, U> updateUpdateTime(LocalDateTime updateTime){
       return new CustomerExpression(this, $it ->  ((Customer)$it).updateUpdateTime(updateTime));
    }

    public ContactListExpression<T, U, Contact> getContactList(){
        return new ContactListExpression(this, $it ->  ((Customer)$it).getContactList());
    }
    public ContractListExpression<T, U, Contract> getContractList(){
        return new ContractListExpression(this, $it ->  ((Customer)$it).getContractList());
    }
    public ProductReviewListExpression<T, U, ProductReview> getProductReviewList(){
        return new ProductReviewListExpression(this, $it ->  ((Customer)$it).getProductReviewList());
    }
    public ShoppingCartListExpression<T, U, ShoppingCart> getShoppingCartList(){
        return new ShoppingCartListExpression(this, $it ->  ((Customer)$it).getShoppingCartList());
    }
    public GlobalOrderListExpression<T, U, GlobalOrder> getGlobalOrderList(){
        return new GlobalOrderListExpression(this, $it ->  ((Customer)$it).getGlobalOrderList());
    }
    public WishlistListExpression<T, U, Wishlist> getWishlistList(){
        return new WishlistListExpression(this, $it ->  ((Customer)$it).getWishlistList());
    }
    public InvoiceListExpression<T, U, Invoice> getInvoiceList(){
        return new InvoiceListExpression(this, $it ->  ((Customer)$it).getInvoiceList());
    }
    public ReturnRequestListExpression<T, U, ReturnRequest> getReturnRequestList(){
        return new ReturnRequestListExpression(this, $it ->  ((Customer)$it).getReturnRequestList());
    }
    public TicketListExpression<T, U, Ticket> getTicketList(){
        return new TicketListExpression(this, $it ->  ((Customer)$it).getTicketList());
    }
    public CustomerExpression<T, U, U> addContact(Contact contact){
       return new CustomerExpression(this, $it ->  ((Customer)$it).addContact(contact));
    }
    public CustomerExpression<T, U, U> addContract(Contract contract){
       return new CustomerExpression(this, $it ->  ((Customer)$it).addContract(contract));
    }
    public CustomerExpression<T, U, U> addProductReview(ProductReview productReview){
       return new CustomerExpression(this, $it ->  ((Customer)$it).addProductReview(productReview));
    }
    public CustomerExpression<T, U, U> addShoppingCart(ShoppingCart shoppingCart){
       return new CustomerExpression(this, $it ->  ((Customer)$it).addShoppingCart(shoppingCart));
    }
    public CustomerExpression<T, U, U> addGlobalOrder(GlobalOrder globalOrder){
       return new CustomerExpression(this, $it ->  ((Customer)$it).addGlobalOrder(globalOrder));
    }
    public CustomerExpression<T, U, U> addWishlist(Wishlist wishlist){
       return new CustomerExpression(this, $it ->  ((Customer)$it).addWishlist(wishlist));
    }
    public CustomerExpression<T, U, U> addInvoice(Invoice invoice){
       return new CustomerExpression(this, $it ->  ((Customer)$it).addInvoice(invoice));
    }
    public CustomerExpression<T, U, U> addReturnRequest(ReturnRequest returnRequest){
       return new CustomerExpression(this, $it ->  ((Customer)$it).addReturnRequest(returnRequest));
    }
    public CustomerExpression<T, U, U> addTicket(Ticket ticket){
       return new CustomerExpression(this, $it ->  ((Customer)$it).addTicket(ticket));
    }
}