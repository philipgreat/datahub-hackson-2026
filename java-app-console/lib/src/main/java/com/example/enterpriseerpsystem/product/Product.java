
package com.example.enterpriseerpsystem.product;

import com.example.enterpriseerpsystem.cartitem.CartItem;
import com.example.enterpriseerpsystem.category.Category;
import com.example.enterpriseerpsystem.inventoryitem.InventoryItem;
import com.example.enterpriseerpsystem.orderitem.OrderItem;
import com.example.enterpriseerpsystem.productreview.ProductReview;
import com.example.enterpriseerpsystem.purchaseorderitem.PurchaseOrderItem;
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
public class Product extends BaseEntity implements RemoteInput {
    public static String INTERNAL_TYPE = "Product";

    public static final String NAME_PROPERTY = "name";
    public static final String PRICE_PROPERTY = "price";
    public static final String CATEGORY_PROPERTY = "category";
    public static final String COST_PROPERTY = "cost";
    public static final String IS_ACTIVE_PROPERTY = "isActive";
    public static final String SKU_PROPERTY = "sku";
    public static final String STOCK_PROPERTY = "stock";
    public static final String CREATE_TIME_PROPERTY = "createTime";
    public static final String UPDATE_TIME_PROPERTY = "updateTime";
    public static final String PRODUCT_REVIEW_LIST_PROPERTY = "productReviewList";
    public static final String CART_ITEM_LIST_PROPERTY = "cartItemList";
    public static final String ORDER_ITEM_LIST_PROPERTY = "orderItemList";
    public static final String INVENTORY_ITEM_LIST_PROPERTY = "inventoryItemList";
    public static final String PURCHASE_ORDER_ITEM_LIST_PROPERTY = "purchaseOrderItemList";
    private String name;
    private BigDecimal price;
    private Category category;
    private BigDecimal cost;
    private Boolean isActive;
    private String sku;
    private BigDecimal stock;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private SmartList<ProductReview> productReviewList;
    private SmartList<CartItem> cartItemList;
    private SmartList<OrderItem> orderItemList;
    private SmartList<InventoryItem> inventoryItemList;
    private SmartList<PurchaseOrderItem> purchaseOrderItemList;

    public String getName(){
        return this.name;
    }
    public BigDecimal getPrice(){
        return this.price;
    }
    public Category getCategory(){
        return this.category;
    }
    public BigDecimal getCost(){
        return this.cost;
    }
    public Boolean isIsActive(){
        return this.isActive;
    }
    public String getSku(){
        return this.sku;
    }
    public BigDecimal getStock(){
        return this.stock;
    }
    public LocalDateTime getCreateTime(){
        return this.createTime;
    }
    public LocalDateTime getUpdateTime(){
        return this.updateTime;
    }
    public SmartList<ProductReview> getProductReviewList(){
        return this.productReviewList;
    }
    public SmartList<CartItem> getCartItemList(){
        return this.cartItemList;
    }
    public SmartList<OrderItem> getOrderItemList(){
        return this.orderItemList;
    }
    public SmartList<InventoryItem> getInventoryItemList(){
        return this.inventoryItemList;
    }
    public SmartList<PurchaseOrderItem> getPurchaseOrderItemList(){
        return this.purchaseOrderItemList;
    }
    public Product updateName(String name){
        name = (name == null ? null : name.trim());
        if(Objects.equals(this.name, name)){
            return this;
        }
        handleUpdate(NAME_PROPERTY, getName(), name);
        this.name = name;
        return this;
    }
    public Product updatePrice(BigDecimal price){
        if(Objects.equals(this.price, price)){
            return this;
        }
        handleUpdate(PRICE_PROPERTY, getPrice(), price);
        this.price = price;
        return this;
    }
    public Product updateCategory(Category category){
        if(Objects.equals(this.category, category)){
            return this;
        }
        handleUpdate(CATEGORY_PROPERTY, getCategory(), category);
        this.category = category;
        return this;
    }
    public Product updateCost(BigDecimal cost){
        if(Objects.equals(this.cost, cost)){
            return this;
        }
        handleUpdate(COST_PROPERTY, getCost(), cost);
        this.cost = cost;
        return this;
    }
    public Product updateIsActive(Boolean isActive){
        if(Objects.equals(this.isActive, isActive)){
            return this;
        }
        handleUpdate(IS_ACTIVE_PROPERTY, isIsActive(), isActive);
        this.isActive = isActive;
        return this;
    }
    public Product updateSku(String sku){
        sku = (sku == null ? null : sku.trim());
        if(Objects.equals(this.sku, sku)){
            return this;
        }
        handleUpdate(SKU_PROPERTY, getSku(), sku);
        this.sku = sku;
        return this;
    }
    public Product updateStock(BigDecimal stock){
        if(Objects.equals(this.stock, stock)){
            return this;
        }
        handleUpdate(STOCK_PROPERTY, getStock(), stock);
        this.stock = stock;
        return this;
    }
    public Product updateCreateTime(LocalDateTime createTime){
        if(Objects.equals(this.createTime, createTime)){
            return this;
        }
        handleUpdate(CREATE_TIME_PROPERTY, getCreateTime(), createTime);
        this.createTime = createTime;
        return this;
    }
    public Product updateUpdateTime(LocalDateTime updateTime){
        if(Objects.equals(this.updateTime, updateTime)){
            return this;
        }
        handleUpdate(UPDATE_TIME_PROPERTY, getUpdateTime(), updateTime);
        this.updateTime = updateTime;
        return this;
    }
    public Product addProductReview(ProductReview productReview){
        if (productReview == null){
            return this;
        }

        if(null == this.productReviewList){
            this.productReviewList = new SmartList<>();
        }

        this.productReviewList.add(productReview);
        productReview.cacheRelation(ProductReview.PRODUCT_PROPERTY, this);
        return this;
    }
    public Product addCartItem(CartItem cartItem){
        if (cartItem == null){
            return this;
        }

        if(null == this.cartItemList){
            this.cartItemList = new SmartList<>();
        }

        this.cartItemList.add(cartItem);
        cartItem.cacheRelation(CartItem.PRODUCT_PROPERTY, this);
        return this;
    }
    public Product addOrderItem(OrderItem orderItem){
        if (orderItem == null){
            return this;
        }

        if(null == this.orderItemList){
            this.orderItemList = new SmartList<>();
        }

        this.orderItemList.add(orderItem);
        orderItem.cacheRelation(OrderItem.PRODUCT_PROPERTY, this);
        return this;
    }
    public Product addInventoryItem(InventoryItem inventoryItem){
        if (inventoryItem == null){
            return this;
        }

        if(null == this.inventoryItemList){
            this.inventoryItemList = new SmartList<>();
        }

        this.inventoryItemList.add(inventoryItem);
        inventoryItem.cacheRelation(InventoryItem.PRODUCT_PROPERTY, this);
        return this;
    }
    public Product addPurchaseOrderItem(PurchaseOrderItem purchaseOrderItem){
        if (purchaseOrderItem == null){
            return this;
        }

        if(null == this.purchaseOrderItemList){
            this.purchaseOrderItemList = new SmartList<>();
        }

        this.purchaseOrderItemList.add(purchaseOrderItem);
        purchaseOrderItem.cacheRelation(PurchaseOrderItem.PRODUCT_PROPERTY, this);
        return this;
    }

    public static Product refer(Long id){
        Product refer = new Product();
        refer.__internalSet("id", id);
        refer.set$status(EntityStatus.REFER);
        return refer;
    }
    @Override
    public String typeName(){
        return INTERNAL_TYPE;
    }

    public Product comment(String comment){
        this.setComment(comment);
        return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Audited<Product> auditAs(String action) {
        return super.auditAs(action);
    }

    // ===== Framework Internal: generated switch dispatch =====
    @Override
    @FrameworkInternal
    public void __internalSet(String property, Object value) {
        switch (property) {
            case "name": this.name = (value == null ? null : ((String)value).trim()); break;

            case "price": this.price = (BigDecimal) value; break;

            case "category": this.category = (Category) value; break;

            case "cost": this.cost = (BigDecimal) value; break;

            case "isActive": this.isActive = (Boolean) value; break;

            case "sku": this.sku = (value == null ? null : ((String)value).trim()); break;

            case "stock": this.stock = (BigDecimal) value; break;

            case "createTime": this.createTime = (LocalDateTime) value; break;

            case "updateTime": this.updateTime = (LocalDateTime) value; break;

            case "productReviewList": this.productReviewList = (SmartList<ProductReview>) value; break;
            case "cartItemList": this.cartItemList = (SmartList<CartItem>) value; break;
            case "orderItemList": this.orderItemList = (SmartList<OrderItem>) value; break;
            case "inventoryItemList": this.inventoryItemList = (SmartList<InventoryItem>) value; break;
            case "purchaseOrderItemList": this.purchaseOrderItemList = (SmartList<PurchaseOrderItem>) value; break;
            default: super.__internalSet(property, value);
        }
    }

    @Override
    @FrameworkInternal
    public Object __internalGet(String property) {
        switch (property) {
            case "name": return this.name;
            case "price": return this.price;
            case "category": return this.category;
            case "cost": return this.cost;
            case "isActive": return this.isActive;
            case "sku": return this.sku;
            case "stock": return this.stock;
            case "createTime": return this.createTime;
            case "updateTime": return this.updateTime;
            case "productReviewList": return this.productReviewList;
            case "cartItemList": return this.cartItemList;
            case "orderItemList": return this.orderItemList;
            case "inventoryItemList": return this.inventoryItemList;
            case "purchaseOrderItemList": return this.purchaseOrderItemList;
            default: return super.__internalGet(property);
        }
    }

}