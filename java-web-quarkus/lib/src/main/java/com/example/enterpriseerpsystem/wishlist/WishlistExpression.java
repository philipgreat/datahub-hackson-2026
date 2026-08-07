
package com.example.enterpriseerpsystem.wishlist;

import com.example.enterpriseerpsystem.customer.Customer;
import com.example.enterpriseerpsystem.customer.CustomerExpression;
import io.teaql.core.UserContext;
import io.teaql.core.value.BaseEntityExpression;
import io.teaql.core.value.Expression;
import io.teaql.core.value.ExpressionAdaptor;
import java.time.LocalDateTime;
import java.util.function.Function;

public class WishlistExpression<T, E, U extends Wishlist> extends ExpressionAdaptor<T, E, U> implements BaseEntityExpression<T, U> {
    public WishlistExpression(Expression<T, U> expression){
        super(expression);
    }

    public WishlistExpression(Expression<T, E> expression, Function<E, U> function){
        super(expression, function);
    }

     public WishlistExpression<T, U, U> updateId(Long id){
        return new WishlistExpression(this, $it -> {((Wishlist)$it).__internalSet("id", id); return this;});
     }

     public WishlistExpression<T, U, U> save(UserContext userContext){
        return new WishlistExpression(this, $it -> ((Wishlist)$it).auditAs("Saved by Expression").save(userContext));
     }

     public WishlistExpression<T, U, U> save(String intent, UserContext userContext){
        return new WishlistExpression(this, $it -> ((Wishlist)$it).auditAs(intent).save(userContext));
     }

     public boolean isNull() {
        return resolve() == null;
     }


    public Expression<T, String> getName(){
       return apply(Wishlist::getName);
    }
    public WishlistExpression<T, U, U> updateName(String name){
       return new WishlistExpression(this, $it ->  ((Wishlist)$it).updateName(name));
    }

    public Expression<T, LocalDateTime> getCreatedAt(){
       return apply(Wishlist::getCreatedAt);
    }
    public WishlistExpression<T, U, U> updateCreatedAt(LocalDateTime createdAt){
       return new WishlistExpression(this, $it ->  ((Wishlist)$it).updateCreatedAt(createdAt));
    }

    public CustomerExpression<T, U, Customer> getCustomer(){
       return new CustomerExpression(this, $it ->  ((Wishlist)$it).getCustomer());
    }

    public WishlistExpression<T, U, U> updateCustomer(Customer customer){
       return new WishlistExpression(this, $it ->  ((Wishlist)$it).updateCustomer(customer));
    }

    public Expression<T, LocalDateTime> getCreateTime(){
       return apply(Wishlist::getCreateTime);
    }
    public WishlistExpression<T, U, U> updateCreateTime(LocalDateTime createTime){
       return new WishlistExpression(this, $it ->  ((Wishlist)$it).updateCreateTime(createTime));
    }

    public Expression<T, LocalDateTime> getUpdateTime(){
       return apply(Wishlist::getUpdateTime);
    }
    public WishlistExpression<T, U, U> updateUpdateTime(LocalDateTime updateTime){
       return new WishlistExpression(this, $it ->  ((Wishlist)$it).updateUpdateTime(updateTime));
    }

}