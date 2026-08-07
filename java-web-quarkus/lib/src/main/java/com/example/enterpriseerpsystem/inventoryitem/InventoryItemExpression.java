
package com.example.enterpriseerpsystem.inventoryitem;

import com.example.enterpriseerpsystem.product.Product;
import com.example.enterpriseerpsystem.product.ProductExpression;
import com.example.enterpriseerpsystem.warehouse.Warehouse;
import com.example.enterpriseerpsystem.warehouse.WarehouseExpression;
import io.teaql.core.UserContext;
import io.teaql.core.value.BaseEntityExpression;
import io.teaql.core.value.Expression;
import io.teaql.core.value.ExpressionAdaptor;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.function.Function;

public class InventoryItemExpression<T, E, U extends InventoryItem> extends ExpressionAdaptor<T, E, U> implements BaseEntityExpression<T, U> {
    public InventoryItemExpression(Expression<T, U> expression){
        super(expression);
    }

    public InventoryItemExpression(Expression<T, E> expression, Function<E, U> function){
        super(expression, function);
    }

     public InventoryItemExpression<T, U, U> updateId(Long id){
        return new InventoryItemExpression(this, $it -> {((InventoryItem)$it).__internalSet("id", id); return this;});
     }

     public InventoryItemExpression<T, U, U> save(UserContext userContext){
        return new InventoryItemExpression(this, $it -> ((InventoryItem)$it).auditAs("Saved by Expression").save(userContext));
     }

     public InventoryItemExpression<T, U, U> save(String intent, UserContext userContext){
        return new InventoryItemExpression(this, $it -> ((InventoryItem)$it).auditAs(intent).save(userContext));
     }

     public boolean isNull() {
        return resolve() == null;
     }


    public ProductExpression<T, U, Product> getProduct(){
       return new ProductExpression(this, $it ->  ((InventoryItem)$it).getProduct());
    }

    public InventoryItemExpression<T, U, U> updateProduct(Product product){
       return new InventoryItemExpression(this, $it ->  ((InventoryItem)$it).updateProduct(product));
    }

    public Expression<T, BigDecimal> getQuantityOnHand(){
       return apply(InventoryItem::getQuantityOnHand);
    }
    public InventoryItemExpression<T, U, U> updateQuantityOnHand(BigDecimal quantityOnHand){
       return new InventoryItemExpression(this, $it ->  ((InventoryItem)$it).updateQuantityOnHand(quantityOnHand));
    }

    public Expression<T, BigDecimal> getReorderLevel(){
       return apply(InventoryItem::getReorderLevel);
    }
    public InventoryItemExpression<T, U, U> updateReorderLevel(BigDecimal reorderLevel){
       return new InventoryItemExpression(this, $it ->  ((InventoryItem)$it).updateReorderLevel(reorderLevel));
    }

    public WarehouseExpression<T, U, Warehouse> getWarehouse(){
       return new WarehouseExpression(this, $it ->  ((InventoryItem)$it).getWarehouse());
    }

    public InventoryItemExpression<T, U, U> updateWarehouse(Warehouse warehouse){
       return new InventoryItemExpression(this, $it ->  ((InventoryItem)$it).updateWarehouse(warehouse));
    }

    public Expression<T, LocalDateTime> getCreateTime(){
       return apply(InventoryItem::getCreateTime);
    }
    public InventoryItemExpression<T, U, U> updateCreateTime(LocalDateTime createTime){
       return new InventoryItemExpression(this, $it ->  ((InventoryItem)$it).updateCreateTime(createTime));
    }

    public Expression<T, LocalDateTime> getUpdateTime(){
       return apply(InventoryItem::getUpdateTime);
    }
    public InventoryItemExpression<T, U, U> updateUpdateTime(LocalDateTime updateTime){
       return new InventoryItemExpression(this, $it ->  ((InventoryItem)$it).updateUpdateTime(updateTime));
    }

}