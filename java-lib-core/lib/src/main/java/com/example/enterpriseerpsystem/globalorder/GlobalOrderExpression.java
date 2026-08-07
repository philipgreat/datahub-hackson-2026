
package com.example.enterpriseerpsystem.globalorder;

import com.example.enterpriseerpsystem.customer.Customer;
import com.example.enterpriseerpsystem.customer.CustomerExpression;
import com.example.enterpriseerpsystem.invoice.Invoice;
import com.example.enterpriseerpsystem.invoice.InvoiceListExpression;
import com.example.enterpriseerpsystem.orderitem.OrderItem;
import com.example.enterpriseerpsystem.orderitem.OrderItemListExpression;
import com.example.enterpriseerpsystem.returnrequest.ReturnRequest;
import com.example.enterpriseerpsystem.returnrequest.ReturnRequestListExpression;
import com.example.enterpriseerpsystem.shipment.Shipment;
import com.example.enterpriseerpsystem.shipment.ShipmentListExpression;
import io.teaql.core.UserContext;
import io.teaql.core.value.BaseEntityExpression;
import io.teaql.core.value.Expression;
import io.teaql.core.value.ExpressionAdaptor;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.function.Function;

public class GlobalOrderExpression<T, E, U extends GlobalOrder> extends ExpressionAdaptor<T, E, U> implements BaseEntityExpression<T, U> {
    public GlobalOrderExpression(Expression<T, U> expression){
        super(expression);
    }

    public GlobalOrderExpression(Expression<T, E> expression, Function<E, U> function){
        super(expression, function);
    }

     public GlobalOrderExpression<T, U, U> updateId(Long id){
        return new GlobalOrderExpression(this, $it -> {((GlobalOrder)$it).__internalSet("id", id); return this;});
     }

     public GlobalOrderExpression<T, U, U> save(UserContext userContext){
        return new GlobalOrderExpression(this, $it -> ((GlobalOrder)$it).auditAs("Saved by Expression").save(userContext));
     }

     public GlobalOrderExpression<T, U, U> save(String intent, UserContext userContext){
        return new GlobalOrderExpression(this, $it -> ((GlobalOrder)$it).auditAs(intent).save(userContext));
     }

     public boolean isNull() {
        return resolve() == null;
     }


    public Expression<T, String> getShippingAddress(){
       return apply(GlobalOrder::getShippingAddress);
    }
    public GlobalOrderExpression<T, U, U> updateShippingAddress(String shippingAddress){
       return new GlobalOrderExpression(this, $it ->  ((GlobalOrder)$it).updateShippingAddress(shippingAddress));
    }

    public Expression<T, BigDecimal> getTotalAmount(){
       return apply(GlobalOrder::getTotalAmount);
    }
    public GlobalOrderExpression<T, U, U> updateTotalAmount(BigDecimal totalAmount){
       return new GlobalOrderExpression(this, $it ->  ((GlobalOrder)$it).updateTotalAmount(totalAmount));
    }

    public CustomerExpression<T, U, Customer> getCustomer(){
       return new CustomerExpression(this, $it ->  ((GlobalOrder)$it).getCustomer());
    }

    public GlobalOrderExpression<T, U, U> updateCustomer(Customer customer){
       return new GlobalOrderExpression(this, $it ->  ((GlobalOrder)$it).updateCustomer(customer));
    }

    public Expression<T, LocalDateTime> getOrderDate(){
       return apply(GlobalOrder::getOrderDate);
    }
    public GlobalOrderExpression<T, U, U> updateOrderDate(LocalDateTime orderDate){
       return new GlobalOrderExpression(this, $it ->  ((GlobalOrder)$it).updateOrderDate(orderDate));
    }

    public Expression<T, String> getStatus(){
       return apply(GlobalOrder::getStatus);
    }
    public GlobalOrderExpression<T, U, U> updateStatus(String status){
       return new GlobalOrderExpression(this, $it ->  ((GlobalOrder)$it).updateStatus(status));
    }

    public Expression<T, LocalDateTime> getCreateTime(){
       return apply(GlobalOrder::getCreateTime);
    }
    public GlobalOrderExpression<T, U, U> updateCreateTime(LocalDateTime createTime){
       return new GlobalOrderExpression(this, $it ->  ((GlobalOrder)$it).updateCreateTime(createTime));
    }

    public Expression<T, LocalDateTime> getUpdateTime(){
       return apply(GlobalOrder::getUpdateTime);
    }
    public GlobalOrderExpression<T, U, U> updateUpdateTime(LocalDateTime updateTime){
       return new GlobalOrderExpression(this, $it ->  ((GlobalOrder)$it).updateUpdateTime(updateTime));
    }

    public OrderItemListExpression<T, U, OrderItem> getOrderItemList(){
        return new OrderItemListExpression(this, $it ->  ((GlobalOrder)$it).getOrderItemList());
    }
    public InvoiceListExpression<T, U, Invoice> getInvoiceList(){
        return new InvoiceListExpression(this, $it ->  ((GlobalOrder)$it).getInvoiceList());
    }
    public ShipmentListExpression<T, U, Shipment> getShipmentList(){
        return new ShipmentListExpression(this, $it ->  ((GlobalOrder)$it).getShipmentList());
    }
    public ReturnRequestListExpression<T, U, ReturnRequest> getReturnRequestList(){
        return new ReturnRequestListExpression(this, $it ->  ((GlobalOrder)$it).getReturnRequestList());
    }
    public GlobalOrderExpression<T, U, U> addOrderItem(OrderItem orderItem){
       return new GlobalOrderExpression(this, $it ->  ((GlobalOrder)$it).addOrderItem(orderItem));
    }
    public GlobalOrderExpression<T, U, U> addInvoice(Invoice invoice){
       return new GlobalOrderExpression(this, $it ->  ((GlobalOrder)$it).addInvoice(invoice));
    }
    public GlobalOrderExpression<T, U, U> addShipment(Shipment shipment){
       return new GlobalOrderExpression(this, $it ->  ((GlobalOrder)$it).addShipment(shipment));
    }
    public GlobalOrderExpression<T, U, U> addReturnRequest(ReturnRequest returnRequest){
       return new GlobalOrderExpression(this, $it ->  ((GlobalOrder)$it).addReturnRequest(returnRequest));
    }
}