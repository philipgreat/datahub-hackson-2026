
package com.example.enterpriseerpsystem.product;

import com.example.enterpriseerpsystem.cartitem.CartItem;
import com.example.enterpriseerpsystem.cartitem.CartItemChecker;
import com.example.enterpriseerpsystem.category.Category;
import com.example.enterpriseerpsystem.category.CategoryChecker;
import com.example.enterpriseerpsystem.inventoryitem.InventoryItem;
import com.example.enterpriseerpsystem.inventoryitem.InventoryItemChecker;
import com.example.enterpriseerpsystem.orderitem.OrderItem;
import com.example.enterpriseerpsystem.orderitem.OrderItemChecker;
import com.example.enterpriseerpsystem.productreview.ProductReview;
import com.example.enterpriseerpsystem.productreview.ProductReviewChecker;
import com.example.enterpriseerpsystem.purchaseorderitem.PurchaseOrderItem;
import com.example.enterpriseerpsystem.purchaseorderitem.PurchaseOrderItemChecker;
import io.teaql.core.UserContext;
import io.teaql.core.checker.Checker;
import io.teaql.core.checker.ObjectLocation;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ProductChecker implements Checker<Product>{

    public String type(){
        return Product.INTERNAL_TYPE;
    }

    public void checkAndFix(UserContext _ctx, Product product, ObjectLocation _parentLocation){
        if(needCheck(_ctx, product)){
            markAsChecked(_ctx, product);
            doCheck(_ctx, product, _parentLocation);
        }
    }

    public void doCheck(UserContext _ctx, Product product, ObjectLocation _parentLocation){
      if((product == null)){
         return;
      }
      if(product.newItem()){
        if(product.getCreateTime() == null){
           product.updateCreateTime(java.time.LocalDateTime.now());
        }if(product.getUpdateTime() == null){
           product.updateUpdateTime(java.time.LocalDateTime.now());
        }
      }else if(product.updateItem()){
        product.updateUpdateTime(java.time.LocalDateTime.now());
      }
      checkName(_ctx, product.getProperty(Product.NAME_PROPERTY), newLocation(_parentLocation, Product.NAME_PROPERTY));
      checkPrice(_ctx, product.getProperty(Product.PRICE_PROPERTY), newLocation(_parentLocation, Product.PRICE_PROPERTY));
      checkCategory(_ctx, product.getProperty(Product.CATEGORY_PROPERTY), newLocation(_parentLocation, Product.CATEGORY_PROPERTY));
      checkCost(_ctx, product.getProperty(Product.COST_PROPERTY), newLocation(_parentLocation, Product.COST_PROPERTY));
      checkIsActive(_ctx, product.getProperty(Product.IS_ACTIVE_PROPERTY), newLocation(_parentLocation, Product.IS_ACTIVE_PROPERTY));
      checkSku(_ctx, product.getProperty(Product.SKU_PROPERTY), newLocation(_parentLocation, Product.SKU_PROPERTY));
      checkStock(_ctx, product.getProperty(Product.STOCK_PROPERTY), newLocation(_parentLocation, Product.STOCK_PROPERTY));
      checkCreateTime(_ctx, product.getProperty(Product.CREATE_TIME_PROPERTY), newLocation(_parentLocation, Product.CREATE_TIME_PROPERTY));
      checkUpdateTime(_ctx, product.getProperty(Product.UPDATE_TIME_PROPERTY), newLocation(_parentLocation, Product.UPDATE_TIME_PROPERTY));
      for(int i = 0; product.getProductReviewList() != null && i < product.getProductReviewList().size(); i++){
         ProductReview productReview = product.getProductReviewList().get(i);
         new ProductReviewChecker().checkAndFix(_ctx, productReview, newLocation(_parentLocation, Product.PRODUCT_REVIEW_LIST_PROPERTY, i));
      }
      for(int i = 0; product.getCartItemList() != null && i < product.getCartItemList().size(); i++){
         CartItem cartItem = product.getCartItemList().get(i);
         new CartItemChecker().checkAndFix(_ctx, cartItem, newLocation(_parentLocation, Product.CART_ITEM_LIST_PROPERTY, i));
      }
      for(int i = 0; product.getOrderItemList() != null && i < product.getOrderItemList().size(); i++){
         OrderItem orderItem = product.getOrderItemList().get(i);
         new OrderItemChecker().checkAndFix(_ctx, orderItem, newLocation(_parentLocation, Product.ORDER_ITEM_LIST_PROPERTY, i));
      }
      for(int i = 0; product.getInventoryItemList() != null && i < product.getInventoryItemList().size(); i++){
         InventoryItem inventoryItem = product.getInventoryItemList().get(i);
         new InventoryItemChecker().checkAndFix(_ctx, inventoryItem, newLocation(_parentLocation, Product.INVENTORY_ITEM_LIST_PROPERTY, i));
      }
      for(int i = 0; product.getPurchaseOrderItemList() != null && i < product.getPurchaseOrderItemList().size(); i++){
         PurchaseOrderItem purchaseOrderItem = product.getPurchaseOrderItemList().get(i);
         new PurchaseOrderItemChecker().checkAndFix(_ctx, purchaseOrderItem, newLocation(_parentLocation, Product.PURCHASE_ORDER_ITEM_LIST_PROPERTY, i));
      }
    }

    public void checkName(UserContext _ctx, String name, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, name);
    if((name == null)){
        return;
    }
    maxStringCheck(_ctx, _parentLocation, 100, name);

    }
    public void checkPrice(UserContext _ctx, BigDecimal price, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, price);
    if((price == null)){
        return;
    }
    }
    public void checkCategory(UserContext _ctx, Category category, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, category);
    if((category == null)){
        return;
    }
    new CategoryChecker().checkAndFix(_ctx, category, _parentLocation);
    }
    public void checkCost(UserContext _ctx, BigDecimal cost, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, cost);
    if((cost == null)){
        return;
    }
    }
    public void checkIsActive(UserContext _ctx, Boolean isActive, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, isActive);
    if((isActive == null)){
        return;
    }
    }
    public void checkSku(UserContext _ctx, String sku, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, sku);
    if((sku == null)){
        return;
    }
    maxStringCheck(_ctx, _parentLocation, 100, sku);

    }
    public void checkStock(UserContext _ctx, BigDecimal stock, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, stock);
    if((stock == null)){
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