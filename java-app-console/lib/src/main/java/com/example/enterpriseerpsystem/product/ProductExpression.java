
package com.example.enterpriseerpsystem.product;

import com.example.enterpriseerpsystem.cartitem.CartItem;
import com.example.enterpriseerpsystem.cartitem.CartItemListExpression;
import com.example.enterpriseerpsystem.category.Category;
import com.example.enterpriseerpsystem.category.CategoryExpression;
import com.example.enterpriseerpsystem.inventoryitem.InventoryItem;
import com.example.enterpriseerpsystem.inventoryitem.InventoryItemListExpression;
import com.example.enterpriseerpsystem.orderitem.OrderItem;
import com.example.enterpriseerpsystem.orderitem.OrderItemListExpression;
import com.example.enterpriseerpsystem.productreview.ProductReview;
import com.example.enterpriseerpsystem.productreview.ProductReviewListExpression;
import com.example.enterpriseerpsystem.purchaseorderitem.PurchaseOrderItem;
import com.example.enterpriseerpsystem.purchaseorderitem.PurchaseOrderItemListExpression;
import io.teaql.core.UserContext;
import io.teaql.core.value.BaseEntityExpression;
import io.teaql.core.value.Expression;
import io.teaql.core.value.ExpressionAdaptor;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.function.Function;

public class ProductExpression<T, E, U extends Product> extends ExpressionAdaptor<T, E, U> implements BaseEntityExpression<T, U> {
    public ProductExpression(Expression<T, U> expression){
        super(expression);
    }

    public ProductExpression(Expression<T, E> expression, Function<E, U> function){
        super(expression, function);
    }

     public ProductExpression<T, U, U> updateId(Long id){
        return new ProductExpression(this, $it -> {((Product)$it).__internalSet("id", id); return this;});
     }

     public ProductExpression<T, U, U> save(UserContext userContext){
        return new ProductExpression(this, $it -> ((Product)$it).auditAs("Saved by Expression").save(userContext));
     }

     public ProductExpression<T, U, U> save(String intent, UserContext userContext){
        return new ProductExpression(this, $it -> ((Product)$it).auditAs(intent).save(userContext));
     }

     public boolean isNull() {
        return resolve() == null;
     }


    public Expression<T, String> getName(){
       return apply(Product::getName);
    }
    public ProductExpression<T, U, U> updateName(String name){
       return new ProductExpression(this, $it ->  ((Product)$it).updateName(name));
    }

    public Expression<T, BigDecimal> getPrice(){
       return apply(Product::getPrice);
    }
    public ProductExpression<T, U, U> updatePrice(BigDecimal price){
       return new ProductExpression(this, $it ->  ((Product)$it).updatePrice(price));
    }

    public CategoryExpression<T, U, Category> getCategory(){
       return new CategoryExpression(this, $it ->  ((Product)$it).getCategory());
    }

    public ProductExpression<T, U, U> updateCategory(Category category){
       return new ProductExpression(this, $it ->  ((Product)$it).updateCategory(category));
    }

    public Expression<T, BigDecimal> getCost(){
       return apply(Product::getCost);
    }
    public ProductExpression<T, U, U> updateCost(BigDecimal cost){
       return new ProductExpression(this, $it ->  ((Product)$it).updateCost(cost));
    }

    public Expression<T, Boolean> isIsActive(){
       return apply(Product::isIsActive);
    }
    public ProductExpression<T, U, U> updateIsActive(Boolean isActive){
       return new ProductExpression(this, $it ->  ((Product)$it).updateIsActive(isActive));
    }

    public Expression<T, String> getSku(){
       return apply(Product::getSku);
    }
    public ProductExpression<T, U, U> updateSku(String sku){
       return new ProductExpression(this, $it ->  ((Product)$it).updateSku(sku));
    }

    public Expression<T, BigDecimal> getStock(){
       return apply(Product::getStock);
    }
    public ProductExpression<T, U, U> updateStock(BigDecimal stock){
       return new ProductExpression(this, $it ->  ((Product)$it).updateStock(stock));
    }

    public Expression<T, LocalDateTime> getCreateTime(){
       return apply(Product::getCreateTime);
    }
    public ProductExpression<T, U, U> updateCreateTime(LocalDateTime createTime){
       return new ProductExpression(this, $it ->  ((Product)$it).updateCreateTime(createTime));
    }

    public Expression<T, LocalDateTime> getUpdateTime(){
       return apply(Product::getUpdateTime);
    }
    public ProductExpression<T, U, U> updateUpdateTime(LocalDateTime updateTime){
       return new ProductExpression(this, $it ->  ((Product)$it).updateUpdateTime(updateTime));
    }

    public ProductReviewListExpression<T, U, ProductReview> getProductReviewList(){
        return new ProductReviewListExpression(this, $it ->  ((Product)$it).getProductReviewList());
    }
    public CartItemListExpression<T, U, CartItem> getCartItemList(){
        return new CartItemListExpression(this, $it ->  ((Product)$it).getCartItemList());
    }
    public OrderItemListExpression<T, U, OrderItem> getOrderItemList(){
        return new OrderItemListExpression(this, $it ->  ((Product)$it).getOrderItemList());
    }
    public InventoryItemListExpression<T, U, InventoryItem> getInventoryItemList(){
        return new InventoryItemListExpression(this, $it ->  ((Product)$it).getInventoryItemList());
    }
    public PurchaseOrderItemListExpression<T, U, PurchaseOrderItem> getPurchaseOrderItemList(){
        return new PurchaseOrderItemListExpression(this, $it ->  ((Product)$it).getPurchaseOrderItemList());
    }
    public ProductExpression<T, U, U> addProductReview(ProductReview productReview){
       return new ProductExpression(this, $it ->  ((Product)$it).addProductReview(productReview));
    }
    public ProductExpression<T, U, U> addCartItem(CartItem cartItem){
       return new ProductExpression(this, $it ->  ((Product)$it).addCartItem(cartItem));
    }
    public ProductExpression<T, U, U> addOrderItem(OrderItem orderItem){
       return new ProductExpression(this, $it ->  ((Product)$it).addOrderItem(orderItem));
    }
    public ProductExpression<T, U, U> addInventoryItem(InventoryItem inventoryItem){
       return new ProductExpression(this, $it ->  ((Product)$it).addInventoryItem(inventoryItem));
    }
    public ProductExpression<T, U, U> addPurchaseOrderItem(PurchaseOrderItem purchaseOrderItem){
       return new ProductExpression(this, $it ->  ((Product)$it).addPurchaseOrderItem(purchaseOrderItem));
    }
}