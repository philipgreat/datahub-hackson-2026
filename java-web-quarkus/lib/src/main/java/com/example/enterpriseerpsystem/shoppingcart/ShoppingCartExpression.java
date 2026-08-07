
package com.example.enterpriseerpsystem.shoppingcart;

import com.example.enterpriseerpsystem.cartitem.CartItem;
import com.example.enterpriseerpsystem.cartitem.CartItemListExpression;
import com.example.enterpriseerpsystem.customer.Customer;
import com.example.enterpriseerpsystem.customer.CustomerExpression;
import io.teaql.core.UserContext;
import io.teaql.core.value.BaseEntityExpression;
import io.teaql.core.value.Expression;
import io.teaql.core.value.ExpressionAdaptor;
import java.time.LocalDateTime;
import java.util.function.Function;

public class ShoppingCartExpression<T, E, U extends ShoppingCart> extends ExpressionAdaptor<T, E, U> implements BaseEntityExpression<T, U> {
    public ShoppingCartExpression(Expression<T, U> expression){
        super(expression);
    }

    public ShoppingCartExpression(Expression<T, E> expression, Function<E, U> function){
        super(expression, function);
    }

     public ShoppingCartExpression<T, U, U> updateId(Long id){
        return new ShoppingCartExpression(this, $it -> {((ShoppingCart)$it).__internalSet("id", id); return this;});
     }

     public ShoppingCartExpression<T, U, U> save(UserContext userContext){
        return new ShoppingCartExpression(this, $it -> ((ShoppingCart)$it).auditAs("Saved by Expression").save(userContext));
     }

     public ShoppingCartExpression<T, U, U> save(String intent, UserContext userContext){
        return new ShoppingCartExpression(this, $it -> ((ShoppingCart)$it).auditAs(intent).save(userContext));
     }

     public boolean isNull() {
        return resolve() == null;
     }


    public Expression<T, LocalDateTime> getCreatedAt(){
       return apply(ShoppingCart::getCreatedAt);
    }
    public ShoppingCartExpression<T, U, U> updateCreatedAt(LocalDateTime createdAt){
       return new ShoppingCartExpression(this, $it ->  ((ShoppingCart)$it).updateCreatedAt(createdAt));
    }

    public CustomerExpression<T, U, Customer> getCustomer(){
       return new CustomerExpression(this, $it ->  ((ShoppingCart)$it).getCustomer());
    }

    public ShoppingCartExpression<T, U, U> updateCustomer(Customer customer){
       return new ShoppingCartExpression(this, $it ->  ((ShoppingCart)$it).updateCustomer(customer));
    }

    public Expression<T, Boolean> isIsAbandoned(){
       return apply(ShoppingCart::isIsAbandoned);
    }
    public ShoppingCartExpression<T, U, U> updateIsAbandoned(Boolean isAbandoned){
       return new ShoppingCartExpression(this, $it ->  ((ShoppingCart)$it).updateIsAbandoned(isAbandoned));
    }

    public Expression<T, String> getSessionId(){
       return apply(ShoppingCart::getSessionId);
    }
    public ShoppingCartExpression<T, U, U> updateSessionId(String sessionId){
       return new ShoppingCartExpression(this, $it ->  ((ShoppingCart)$it).updateSessionId(sessionId));
    }

    public Expression<T, LocalDateTime> getCreateTime(){
       return apply(ShoppingCart::getCreateTime);
    }
    public ShoppingCartExpression<T, U, U> updateCreateTime(LocalDateTime createTime){
       return new ShoppingCartExpression(this, $it ->  ((ShoppingCart)$it).updateCreateTime(createTime));
    }

    public Expression<T, LocalDateTime> getUpdateTime(){
       return apply(ShoppingCart::getUpdateTime);
    }
    public ShoppingCartExpression<T, U, U> updateUpdateTime(LocalDateTime updateTime){
       return new ShoppingCartExpression(this, $it ->  ((ShoppingCart)$it).updateUpdateTime(updateTime));
    }

    public CartItemListExpression<T, U, CartItem> getCartItemList(){
        return new CartItemListExpression(this, $it ->  ((ShoppingCart)$it).getCartItemList());
    }
    public ShoppingCartExpression<T, U, U> addCartItem(CartItem cartItem){
       return new ShoppingCartExpression(this, $it ->  ((ShoppingCart)$it).addCartItem(cartItem));
    }
}