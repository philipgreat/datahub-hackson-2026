
package com.example.enterpriseerpsystem.customer;

import com.example.enterpriseerpsystem.contact.Contact;
import com.example.enterpriseerpsystem.contract.Contract;
import com.example.enterpriseerpsystem.globalorder.GlobalOrder;
import com.example.enterpriseerpsystem.invoice.Invoice;
import com.example.enterpriseerpsystem.productreview.ProductReview;
import com.example.enterpriseerpsystem.returnrequest.ReturnRequest;
import com.example.enterpriseerpsystem.shoppingcart.ShoppingCart;
import com.example.enterpriseerpsystem.ticket.Ticket;
import com.example.enterpriseerpsystem.wishlist.Wishlist;
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
public class Customer extends BaseEntity implements RemoteInput {
    public static String INTERNAL_TYPE = "Customer";

    public static final String ADDRESS_PROPERTY = "address";
    public static final String EMAIL_PROPERTY = "email";
    public static final String NAME_PROPERTY = "name";
    public static final String PHONE_PROPERTY = "phone";
    public static final String CREATED_AT_PROPERTY = "createdAt";
    public static final String LOYALTY_POINTS_PROPERTY = "loyaltyPoints";
    public static final String CREATE_TIME_PROPERTY = "createTime";
    public static final String UPDATE_TIME_PROPERTY = "updateTime";
    public static final String CONTACT_LIST_PROPERTY = "contactList";
    public static final String CONTRACT_LIST_PROPERTY = "contractList";
    public static final String PRODUCT_REVIEW_LIST_PROPERTY = "productReviewList";
    public static final String SHOPPING_CART_LIST_PROPERTY = "shoppingCartList";
    public static final String GLOBAL_ORDER_LIST_PROPERTY = "globalOrderList";
    public static final String WISHLIST_LIST_PROPERTY = "wishlistList";
    public static final String INVOICE_LIST_PROPERTY = "invoiceList";
    public static final String RETURN_REQUEST_LIST_PROPERTY = "returnRequestList";
    public static final String TICKET_LIST_PROPERTY = "ticketList";
    private String address;
    private String email;
    private String name;
    private String phone;
    private LocalDateTime createdAt;
    private BigDecimal loyaltyPoints;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private SmartList<Contact> contactList;
    private SmartList<Contract> contractList;
    private SmartList<ProductReview> productReviewList;
    private SmartList<ShoppingCart> shoppingCartList;
    private SmartList<GlobalOrder> globalOrderList;
    private SmartList<Wishlist> wishlistList;
    private SmartList<Invoice> invoiceList;
    private SmartList<ReturnRequest> returnRequestList;
    private SmartList<Ticket> ticketList;

    public String getAddress(){
        return this.address;
    }
    public String getEmail(){
        return this.email;
    }
    public String getName(){
        return this.name;
    }
    public String getPhone(){
        return this.phone;
    }
    public LocalDateTime getCreatedAt(){
        return this.createdAt;
    }
    public BigDecimal getLoyaltyPoints(){
        return this.loyaltyPoints;
    }
    public LocalDateTime getCreateTime(){
        return this.createTime;
    }
    public LocalDateTime getUpdateTime(){
        return this.updateTime;
    }
    public SmartList<Contact> getContactList(){
        return this.contactList;
    }
    public SmartList<Contract> getContractList(){
        return this.contractList;
    }
    public SmartList<ProductReview> getProductReviewList(){
        return this.productReviewList;
    }
    public SmartList<ShoppingCart> getShoppingCartList(){
        return this.shoppingCartList;
    }
    public SmartList<GlobalOrder> getGlobalOrderList(){
        return this.globalOrderList;
    }
    public SmartList<Wishlist> getWishlistList(){
        return this.wishlistList;
    }
    public SmartList<Invoice> getInvoiceList(){
        return this.invoiceList;
    }
    public SmartList<ReturnRequest> getReturnRequestList(){
        return this.returnRequestList;
    }
    public SmartList<Ticket> getTicketList(){
        return this.ticketList;
    }
    public Customer updateAddress(String address){
        address = (address == null ? null : address.trim());
        if(Objects.equals(this.address, address)){
            return this;
        }
        handleUpdate(ADDRESS_PROPERTY, getAddress(), address);
        this.address = address;
        return this;
    }
    public Customer updateEmail(String email){
        email = (email == null ? null : email.trim());
        if(Objects.equals(this.email, email)){
            return this;
        }
        handleUpdate(EMAIL_PROPERTY, getEmail(), email);
        this.email = email;
        return this;
    }
    public Customer updateName(String name){
        name = (name == null ? null : name.trim());
        if(Objects.equals(this.name, name)){
            return this;
        }
        handleUpdate(NAME_PROPERTY, getName(), name);
        this.name = name;
        return this;
    }
    public Customer updatePhone(String phone){
        phone = (phone == null ? null : phone.trim());
        if(Objects.equals(this.phone, phone)){
            return this;
        }
        handleUpdate(PHONE_PROPERTY, getPhone(), phone);
        this.phone = phone;
        return this;
    }
    public Customer updateCreatedAt(LocalDateTime createdAt){
        if(Objects.equals(this.createdAt, createdAt)){
            return this;
        }
        handleUpdate(CREATED_AT_PROPERTY, getCreatedAt(), createdAt);
        this.createdAt = createdAt;
        return this;
    }
    public Customer updateLoyaltyPoints(BigDecimal loyaltyPoints){
        if(Objects.equals(this.loyaltyPoints, loyaltyPoints)){
            return this;
        }
        handleUpdate(LOYALTY_POINTS_PROPERTY, getLoyaltyPoints(), loyaltyPoints);
        this.loyaltyPoints = loyaltyPoints;
        return this;
    }
    public Customer updateCreateTime(LocalDateTime createTime){
        if(Objects.equals(this.createTime, createTime)){
            return this;
        }
        handleUpdate(CREATE_TIME_PROPERTY, getCreateTime(), createTime);
        this.createTime = createTime;
        return this;
    }
    public Customer updateUpdateTime(LocalDateTime updateTime){
        if(Objects.equals(this.updateTime, updateTime)){
            return this;
        }
        handleUpdate(UPDATE_TIME_PROPERTY, getUpdateTime(), updateTime);
        this.updateTime = updateTime;
        return this;
    }
    public Customer addContact(Contact contact){
        if (contact == null){
            return this;
        }

        if(null == this.contactList){
            this.contactList = new SmartList<>();
        }

        this.contactList.add(contact);
        contact.cacheRelation(Contact.CUSTOMER_PROPERTY, this);
        return this;
    }
    public Customer addContract(Contract contract){
        if (contract == null){
            return this;
        }

        if(null == this.contractList){
            this.contractList = new SmartList<>();
        }

        this.contractList.add(contract);
        contract.cacheRelation(Contract.CUSTOMER_PROPERTY, this);
        return this;
    }
    public Customer addProductReview(ProductReview productReview){
        if (productReview == null){
            return this;
        }

        if(null == this.productReviewList){
            this.productReviewList = new SmartList<>();
        }

        this.productReviewList.add(productReview);
        productReview.cacheRelation(ProductReview.CUSTOMER_PROPERTY, this);
        return this;
    }
    public Customer addShoppingCart(ShoppingCart shoppingCart){
        if (shoppingCart == null){
            return this;
        }

        if(null == this.shoppingCartList){
            this.shoppingCartList = new SmartList<>();
        }

        this.shoppingCartList.add(shoppingCart);
        shoppingCart.cacheRelation(ShoppingCart.CUSTOMER_PROPERTY, this);
        return this;
    }
    public Customer addGlobalOrder(GlobalOrder globalOrder){
        if (globalOrder == null){
            return this;
        }

        if(null == this.globalOrderList){
            this.globalOrderList = new SmartList<>();
        }

        this.globalOrderList.add(globalOrder);
        globalOrder.cacheRelation(GlobalOrder.CUSTOMER_PROPERTY, this);
        return this;
    }
    public Customer addWishlist(Wishlist wishlist){
        if (wishlist == null){
            return this;
        }

        if(null == this.wishlistList){
            this.wishlistList = new SmartList<>();
        }

        this.wishlistList.add(wishlist);
        wishlist.cacheRelation(Wishlist.CUSTOMER_PROPERTY, this);
        return this;
    }
    public Customer addInvoice(Invoice invoice){
        if (invoice == null){
            return this;
        }

        if(null == this.invoiceList){
            this.invoiceList = new SmartList<>();
        }

        this.invoiceList.add(invoice);
        invoice.cacheRelation(Invoice.CUSTOMER_PROPERTY, this);
        return this;
    }
    public Customer addReturnRequest(ReturnRequest returnRequest){
        if (returnRequest == null){
            return this;
        }

        if(null == this.returnRequestList){
            this.returnRequestList = new SmartList<>();
        }

        this.returnRequestList.add(returnRequest);
        returnRequest.cacheRelation(ReturnRequest.CUSTOMER_PROPERTY, this);
        return this;
    }
    public Customer addTicket(Ticket ticket){
        if (ticket == null){
            return this;
        }

        if(null == this.ticketList){
            this.ticketList = new SmartList<>();
        }

        this.ticketList.add(ticket);
        ticket.cacheRelation(Ticket.CUSTOMER_PROPERTY, this);
        return this;
    }

    public static Customer refer(Long id){
        Customer refer = new Customer();
        refer.__internalSet("id", id);
        refer.set$status(EntityStatus.REFER);
        return refer;
    }
    @Override
    public String typeName(){
        return INTERNAL_TYPE;
    }

    public Customer comment(String comment){
        this.setComment(comment);
        return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Audited<Customer> auditAs(String action) {
        return super.auditAs(action);
    }

    // ===== Framework Internal: generated switch dispatch =====
    @Override
    @FrameworkInternal
    public void __internalSet(String property, Object value) {
        switch (property) {
            case "address": this.address = (value == null ? null : ((String)value).trim()); break;

            case "email": this.email = (value == null ? null : ((String)value).trim()); break;

            case "name": this.name = (value == null ? null : ((String)value).trim()); break;

            case "phone": this.phone = (value == null ? null : ((String)value).trim()); break;

            case "createdAt": this.createdAt = (LocalDateTime) value; break;

            case "loyaltyPoints": this.loyaltyPoints = (BigDecimal) value; break;

            case "createTime": this.createTime = (LocalDateTime) value; break;

            case "updateTime": this.updateTime = (LocalDateTime) value; break;

            case "contactList": this.contactList = (SmartList<Contact>) value; break;
            case "contractList": this.contractList = (SmartList<Contract>) value; break;
            case "productReviewList": this.productReviewList = (SmartList<ProductReview>) value; break;
            case "shoppingCartList": this.shoppingCartList = (SmartList<ShoppingCart>) value; break;
            case "globalOrderList": this.globalOrderList = (SmartList<GlobalOrder>) value; break;
            case "wishlistList": this.wishlistList = (SmartList<Wishlist>) value; break;
            case "invoiceList": this.invoiceList = (SmartList<Invoice>) value; break;
            case "returnRequestList": this.returnRequestList = (SmartList<ReturnRequest>) value; break;
            case "ticketList": this.ticketList = (SmartList<Ticket>) value; break;
            default: super.__internalSet(property, value);
        }
    }

    @Override
    @FrameworkInternal
    public Object __internalGet(String property) {
        switch (property) {
            case "address": return this.address;
            case "email": return this.email;
            case "name": return this.name;
            case "phone": return this.phone;
            case "createdAt": return this.createdAt;
            case "loyaltyPoints": return this.loyaltyPoints;
            case "createTime": return this.createTime;
            case "updateTime": return this.updateTime;
            case "contactList": return this.contactList;
            case "contractList": return this.contractList;
            case "productReviewList": return this.productReviewList;
            case "shoppingCartList": return this.shoppingCartList;
            case "globalOrderList": return this.globalOrderList;
            case "wishlistList": return this.wishlistList;
            case "invoiceList": return this.invoiceList;
            case "returnRequestList": return this.returnRequestList;
            case "ticketList": return this.ticketList;
            default: return super.__internalGet(property);
        }
    }

}