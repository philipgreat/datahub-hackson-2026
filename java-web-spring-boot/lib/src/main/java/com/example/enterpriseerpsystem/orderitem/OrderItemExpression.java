
package com.example.enterpriseerpsystem.orderitem;

import com.example.enterpriseerpsystem.globalorder.GlobalOrder;
import com.example.enterpriseerpsystem.globalorder.GlobalOrderExpression;
import com.example.enterpriseerpsystem.product.Product;
import com.example.enterpriseerpsystem.product.ProductExpression;
import io.teaql.core.UserContext;
import io.teaql.core.value.BaseEntityExpression;
import io.teaql.core.value.Expression;
import io.teaql.core.value.ExpressionAdaptor;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.function.Function;

public class OrderItemExpression<T, E, U extends OrderItem> extends ExpressionAdaptor<T, E, U> implements BaseEntityExpression<T, U> {
    public OrderItemExpression(Expression<T, U> expression){
        super(expression);
    }

    public OrderItemExpression(Expression<T, E> expression, Function<E, U> function){
        super(expression, function);
    }

     public OrderItemExpression<T, U, U> updateId(Long id){
        return new OrderItemExpression(this, $it -> {((OrderItem)$it).__internalSet("id", id); return this;});
     }

     public OrderItemExpression<T, U, U> save(UserContext userContext){
        return new OrderItemExpression(this, $it -> ((OrderItem)$it).auditAs("Saved by Expression").save(userContext));
     }

     public OrderItemExpression<T, U, U> save(String intent, UserContext userContext){
        return new OrderItemExpression(this, $it -> ((OrderItem)$it).auditAs(intent).save(userContext));
     }

     public boolean isNull() {
        return resolve() == null;
     }


    public Expression<T, BigDecimal> getUnitPrice(){
       return apply(OrderItem::getUnitPrice);
    }
    public OrderItemExpression<T, U, U> updateUnitPrice(BigDecimal unitPrice){
       return new OrderItemExpression(this, $it ->  ((OrderItem)$it).updateUnitPrice(unitPrice));
    }

    public GlobalOrderExpression<T, U, GlobalOrder> getGlobalOrder(){
       return new GlobalOrderExpression(this, $it ->  ((OrderItem)$it).getGlobalOrder());
    }

    public OrderItemExpression<T, U, U> updateGlobalOrder(GlobalOrder globalOrder){
       return new OrderItemExpression(this, $it ->  ((OrderItem)$it).updateGlobalOrder(globalOrder));
    }

    public ProductExpression<T, U, Product> getProduct(){
       return new ProductExpression(this, $it ->  ((OrderItem)$it).getProduct());
    }

    public OrderItemExpression<T, U, U> updateProduct(Product product){
       return new OrderItemExpression(this, $it ->  ((OrderItem)$it).updateProduct(product));
    }

    public Expression<T, BigDecimal> getQuantity(){
       return apply(OrderItem::getQuantity);
    }
    public OrderItemExpression<T, U, U> updateQuantity(BigDecimal quantity){
       return new OrderItemExpression(this, $it ->  ((OrderItem)$it).updateQuantity(quantity));
    }

    public Expression<T, LocalDateTime> getCreateTime(){
       return apply(OrderItem::getCreateTime);
    }
    public OrderItemExpression<T, U, U> updateCreateTime(LocalDateTime createTime){
       return new OrderItemExpression(this, $it ->  ((OrderItem)$it).updateCreateTime(createTime));
    }

    public Expression<T, LocalDateTime> getUpdateTime(){
       return apply(OrderItem::getUpdateTime);
    }
    public OrderItemExpression<T, U, U> updateUpdateTime(LocalDateTime updateTime){
       return new OrderItemExpression(this, $it ->  ((OrderItem)$it).updateUpdateTime(updateTime));
    }

}