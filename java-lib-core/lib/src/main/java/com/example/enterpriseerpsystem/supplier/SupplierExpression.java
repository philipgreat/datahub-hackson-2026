
package com.example.enterpriseerpsystem.supplier;

import com.example.enterpriseerpsystem.purchaseorder.PurchaseOrder;
import com.example.enterpriseerpsystem.purchaseorder.PurchaseOrderListExpression;
import io.teaql.core.UserContext;
import io.teaql.core.value.BaseEntityExpression;
import io.teaql.core.value.Expression;
import io.teaql.core.value.ExpressionAdaptor;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.function.Function;

public class SupplierExpression<T, E, U extends Supplier> extends ExpressionAdaptor<T, E, U> implements BaseEntityExpression<T, U> {
    public SupplierExpression(Expression<T, U> expression){
        super(expression);
    }

    public SupplierExpression(Expression<T, E> expression, Function<E, U> function){
        super(expression, function);
    }

     public SupplierExpression<T, U, U> updateId(Long id){
        return new SupplierExpression(this, $it -> {((Supplier)$it).__internalSet("id", id); return this;});
     }

     public SupplierExpression<T, U, U> save(UserContext userContext){
        return new SupplierExpression(this, $it -> ((Supplier)$it).auditAs("Saved by Expression").save(userContext));
     }

     public SupplierExpression<T, U, U> save(String intent, UserContext userContext){
        return new SupplierExpression(this, $it -> ((Supplier)$it).auditAs(intent).save(userContext));
     }

     public boolean isNull() {
        return resolve() == null;
     }


    public Expression<T, String> getAddress(){
       return apply(Supplier::getAddress);
    }
    public SupplierExpression<T, U, U> updateAddress(String address){
       return new SupplierExpression(this, $it ->  ((Supplier)$it).updateAddress(address));
    }

    public Expression<T, String> getContactEmail(){
       return apply(Supplier::getContactEmail);
    }
    public SupplierExpression<T, U, U> updateContactEmail(String contactEmail){
       return new SupplierExpression(this, $it ->  ((Supplier)$it).updateContactEmail(contactEmail));
    }

    public Expression<T, String> getName(){
       return apply(Supplier::getName);
    }
    public SupplierExpression<T, U, U> updateName(String name){
       return new SupplierExpression(this, $it ->  ((Supplier)$it).updateName(name));
    }

    public Expression<T, String> getPhone(){
       return apply(Supplier::getPhone);
    }
    public SupplierExpression<T, U, U> updatePhone(String phone){
       return new SupplierExpression(this, $it ->  ((Supplier)$it).updatePhone(phone));
    }

    public Expression<T, BigDecimal> getRating(){
       return apply(Supplier::getRating);
    }
    public SupplierExpression<T, U, U> updateRating(BigDecimal rating){
       return new SupplierExpression(this, $it ->  ((Supplier)$it).updateRating(rating));
    }

    public Expression<T, LocalDateTime> getCreateTime(){
       return apply(Supplier::getCreateTime);
    }
    public SupplierExpression<T, U, U> updateCreateTime(LocalDateTime createTime){
       return new SupplierExpression(this, $it ->  ((Supplier)$it).updateCreateTime(createTime));
    }

    public Expression<T, LocalDateTime> getUpdateTime(){
       return apply(Supplier::getUpdateTime);
    }
    public SupplierExpression<T, U, U> updateUpdateTime(LocalDateTime updateTime){
       return new SupplierExpression(this, $it ->  ((Supplier)$it).updateUpdateTime(updateTime));
    }

    public PurchaseOrderListExpression<T, U, PurchaseOrder> getPurchaseOrderList(){
        return new PurchaseOrderListExpression(this, $it ->  ((Supplier)$it).getPurchaseOrderList());
    }
    public SupplierExpression<T, U, U> addPurchaseOrder(PurchaseOrder purchaseOrder){
       return new SupplierExpression(this, $it ->  ((Supplier)$it).addPurchaseOrder(purchaseOrder));
    }
}