
package com.example.enterpriseerpsystem.purchaseorder;

import com.example.enterpriseerpsystem.purchaseorderitem.PurchaseOrderItem;
import com.example.enterpriseerpsystem.purchaseorderitem.PurchaseOrderItemListExpression;
import com.example.enterpriseerpsystem.supplier.Supplier;
import com.example.enterpriseerpsystem.supplier.SupplierExpression;
import io.teaql.core.UserContext;
import io.teaql.core.value.BaseEntityExpression;
import io.teaql.core.value.Expression;
import io.teaql.core.value.ExpressionAdaptor;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.function.Function;

public class PurchaseOrderExpression<T, E, U extends PurchaseOrder> extends ExpressionAdaptor<T, E, U> implements BaseEntityExpression<T, U> {
    public PurchaseOrderExpression(Expression<T, U> expression){
        super(expression);
    }

    public PurchaseOrderExpression(Expression<T, E> expression, Function<E, U> function){
        super(expression, function);
    }

     public PurchaseOrderExpression<T, U, U> updateId(Long id){
        return new PurchaseOrderExpression(this, $it -> {((PurchaseOrder)$it).__internalSet("id", id); return this;});
     }

     public PurchaseOrderExpression<T, U, U> save(UserContext userContext){
        return new PurchaseOrderExpression(this, $it -> ((PurchaseOrder)$it).auditAs("Saved by Expression").save(userContext));
     }

     public PurchaseOrderExpression<T, U, U> save(String intent, UserContext userContext){
        return new PurchaseOrderExpression(this, $it -> ((PurchaseOrder)$it).auditAs(intent).save(userContext));
     }

     public boolean isNull() {
        return resolve() == null;
     }


    public Expression<T, LocalDateTime> getOrderDate(){
       return apply(PurchaseOrder::getOrderDate);
    }
    public PurchaseOrderExpression<T, U, U> updateOrderDate(LocalDateTime orderDate){
       return new PurchaseOrderExpression(this, $it ->  ((PurchaseOrder)$it).updateOrderDate(orderDate));
    }

    public Expression<T, String> getStatus(){
       return apply(PurchaseOrder::getStatus);
    }
    public PurchaseOrderExpression<T, U, U> updateStatus(String status){
       return new PurchaseOrderExpression(this, $it ->  ((PurchaseOrder)$it).updateStatus(status));
    }

    public SupplierExpression<T, U, Supplier> getSupplier(){
       return new SupplierExpression(this, $it ->  ((PurchaseOrder)$it).getSupplier());
    }

    public PurchaseOrderExpression<T, U, U> updateSupplier(Supplier supplier){
       return new PurchaseOrderExpression(this, $it ->  ((PurchaseOrder)$it).updateSupplier(supplier));
    }

    public Expression<T, BigDecimal> getTotalCost(){
       return apply(PurchaseOrder::getTotalCost);
    }
    public PurchaseOrderExpression<T, U, U> updateTotalCost(BigDecimal totalCost){
       return new PurchaseOrderExpression(this, $it ->  ((PurchaseOrder)$it).updateTotalCost(totalCost));
    }

    public Expression<T, LocalDateTime> getCreateTime(){
       return apply(PurchaseOrder::getCreateTime);
    }
    public PurchaseOrderExpression<T, U, U> updateCreateTime(LocalDateTime createTime){
       return new PurchaseOrderExpression(this, $it ->  ((PurchaseOrder)$it).updateCreateTime(createTime));
    }

    public Expression<T, LocalDateTime> getUpdateTime(){
       return apply(PurchaseOrder::getUpdateTime);
    }
    public PurchaseOrderExpression<T, U, U> updateUpdateTime(LocalDateTime updateTime){
       return new PurchaseOrderExpression(this, $it ->  ((PurchaseOrder)$it).updateUpdateTime(updateTime));
    }

    public PurchaseOrderItemListExpression<T, U, PurchaseOrderItem> getPurchaseOrderItemList(){
        return new PurchaseOrderItemListExpression(this, $it ->  ((PurchaseOrder)$it).getPurchaseOrderItemList());
    }
    public PurchaseOrderExpression<T, U, U> addPurchaseOrderItem(PurchaseOrderItem purchaseOrderItem){
       return new PurchaseOrderExpression(this, $it ->  ((PurchaseOrder)$it).addPurchaseOrderItem(purchaseOrderItem));
    }
}