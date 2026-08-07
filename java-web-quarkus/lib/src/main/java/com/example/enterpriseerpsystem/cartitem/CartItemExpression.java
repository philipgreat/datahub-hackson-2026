
package com.example.enterpriseerpsystem.cartitem;

import com.example.enterpriseerpsystem.product.Product;
import com.example.enterpriseerpsystem.product.ProductExpression;
import com.example.enterpriseerpsystem.shoppingcart.ShoppingCart;
import com.example.enterpriseerpsystem.shoppingcart.ShoppingCartExpression;
import io.teaql.core.UserContext;
import io.teaql.core.value.BaseEntityExpression;
import io.teaql.core.value.Expression;
import io.teaql.core.value.ExpressionAdaptor;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.function.Function;

public class CartItemExpression<T, E, U extends CartItem> extends ExpressionAdaptor<T, E, U> implements BaseEntityExpression<T, U> {
    public CartItemExpression(Expression<T, U> expression){
        super(expression);
    }

    public CartItemExpression(Expression<T, E> expression, Function<E, U> function){
        super(expression, function);
    }

     public CartItemExpression<T, U, U> updateId(Long id){
        return new CartItemExpression(this, $it -> {((CartItem)$it).__internalSet("id", id); return this;});
     }

     public CartItemExpression<T, U, U> save(UserContext userContext){
        return new CartItemExpression(this, $it -> ((CartItem)$it).auditAs("Saved by Expression").save(userContext));
     }

     public CartItemExpression<T, U, U> save(String intent, UserContext userContext){
        return new CartItemExpression(this, $it -> ((CartItem)$it).auditAs(intent).save(userContext));
     }

     public boolean isNull() {
        return resolve() == null;
     }


    public ProductExpression<T, U, Product> getProduct(){
       return new ProductExpression(this, $it ->  ((CartItem)$it).getProduct());
    }

    public CartItemExpression<T, U, U> updateProduct(Product product){
       return new CartItemExpression(this, $it ->  ((CartItem)$it).updateProduct(product));
    }

    public Expression<T, BigDecimal> getQuantity(){
       return apply(CartItem::getQuantity);
    }
    public CartItemExpression<T, U, U> updateQuantity(BigDecimal quantity){
       return new CartItemExpression(this, $it ->  ((CartItem)$it).updateQuantity(quantity));
    }

    public ShoppingCartExpression<T, U, ShoppingCart> getShoppingCart(){
       return new ShoppingCartExpression(this, $it ->  ((CartItem)$it).getShoppingCart());
    }

    public CartItemExpression<T, U, U> updateShoppingCart(ShoppingCart shoppingCart){
       return new CartItemExpression(this, $it ->  ((CartItem)$it).updateShoppingCart(shoppingCart));
    }

    public Expression<T, LocalDateTime> getCreateTime(){
       return apply(CartItem::getCreateTime);
    }
    public CartItemExpression<T, U, U> updateCreateTime(LocalDateTime createTime){
       return new CartItemExpression(this, $it ->  ((CartItem)$it).updateCreateTime(createTime));
    }

    public Expression<T, LocalDateTime> getUpdateTime(){
       return apply(CartItem::getUpdateTime);
    }
    public CartItemExpression<T, U, U> updateUpdateTime(LocalDateTime updateTime){
       return new CartItemExpression(this, $it ->  ((CartItem)$it).updateUpdateTime(updateTime));
    }

}