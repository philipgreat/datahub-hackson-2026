
package com.example.enterpriseerpsystem.purchaseorderitem;

import com.example.enterpriseerpsystem.product.Product;
import com.example.enterpriseerpsystem.product.ProductExpression;
import com.example.enterpriseerpsystem.purchaseorder.PurchaseOrder;
import com.example.enterpriseerpsystem.purchaseorder.PurchaseOrderExpression;
import io.teaql.core.UserContext;
import io.teaql.core.value.BaseEntityExpression;
import io.teaql.core.value.Expression;
import io.teaql.core.value.ExpressionAdaptor;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.function.Function;

public class PurchaseOrderItemExpression<T, E, U extends PurchaseOrderItem> extends ExpressionAdaptor<T, E, U> implements BaseEntityExpression<T, U> {
    public PurchaseOrderItemExpression(Expression<T, U> expression){
        super(expression);
    }

    public PurchaseOrderItemExpression(Expression<T, E> expression, Function<E, U> function){
        super(expression, function);
    }

     public PurchaseOrderItemExpression<T, U, U> updateId(Long id){
        return new PurchaseOrderItemExpression(this, $it -> {((PurchaseOrderItem)$it).__internalSet("id", id); return this;});
     }

     public PurchaseOrderItemExpression<T, U, U> save(UserContext userContext){
        return new PurchaseOrderItemExpression(this, $it -> ((PurchaseOrderItem)$it).auditAs("Saved by Expression").save(userContext));
     }

     public PurchaseOrderItemExpression<T, U, U> save(String intent, UserContext userContext){
        return new PurchaseOrderItemExpression(this, $it -> ((PurchaseOrderItem)$it).auditAs(intent).save(userContext));
     }

     public boolean isNull() {
        return resolve() == null;
     }


    public ProductExpression<T, U, Product> getProduct(){
       return new ProductExpression(this, $it ->  ((PurchaseOrderItem)$it).getProduct());
    }

    public PurchaseOrderItemExpression<T, U, U> updateProduct(Product product){
       return new PurchaseOrderItemExpression(this, $it ->  ((PurchaseOrderItem)$it).updateProduct(product));
    }

    public PurchaseOrderExpression<T, U, PurchaseOrder> getPurchaseOrder(){
       return new PurchaseOrderExpression(this, $it ->  ((PurchaseOrderItem)$it).getPurchaseOrder());
    }

    public PurchaseOrderItemExpression<T, U, U> updatePurchaseOrder(PurchaseOrder purchaseOrder){
       return new PurchaseOrderItemExpression(this, $it ->  ((PurchaseOrderItem)$it).updatePurchaseOrder(purchaseOrder));
    }

    public Expression<T, BigDecimal> getQuantity(){
       return apply(PurchaseOrderItem::getQuantity);
    }
    public PurchaseOrderItemExpression<T, U, U> updateQuantity(BigDecimal quantity){
       return new PurchaseOrderItemExpression(this, $it ->  ((PurchaseOrderItem)$it).updateQuantity(quantity));
    }

    public Expression<T, BigDecimal> getUnitCost(){
       return apply(PurchaseOrderItem::getUnitCost);
    }
    public PurchaseOrderItemExpression<T, U, U> updateUnitCost(BigDecimal unitCost){
       return new PurchaseOrderItemExpression(this, $it ->  ((PurchaseOrderItem)$it).updateUnitCost(unitCost));
    }

    public Expression<T, LocalDateTime> getCreateTime(){
       return apply(PurchaseOrderItem::getCreateTime);
    }
    public PurchaseOrderItemExpression<T, U, U> updateCreateTime(LocalDateTime createTime){
       return new PurchaseOrderItemExpression(this, $it ->  ((PurchaseOrderItem)$it).updateCreateTime(createTime));
    }

    public Expression<T, LocalDateTime> getUpdateTime(){
       return apply(PurchaseOrderItem::getUpdateTime);
    }
    public PurchaseOrderItemExpression<T, U, U> updateUpdateTime(LocalDateTime updateTime){
       return new PurchaseOrderItemExpression(this, $it ->  ((PurchaseOrderItem)$it).updateUpdateTime(updateTime));
    }

}