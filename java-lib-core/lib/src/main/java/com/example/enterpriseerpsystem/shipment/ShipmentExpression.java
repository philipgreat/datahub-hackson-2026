
package com.example.enterpriseerpsystem.shipment;

import com.example.enterpriseerpsystem.delivery.Delivery;
import com.example.enterpriseerpsystem.delivery.DeliveryListExpression;
import com.example.enterpriseerpsystem.globalorder.GlobalOrder;
import com.example.enterpriseerpsystem.globalorder.GlobalOrderExpression;
import com.example.enterpriseerpsystem.warehouse.Warehouse;
import com.example.enterpriseerpsystem.warehouse.WarehouseExpression;
import io.teaql.core.UserContext;
import io.teaql.core.value.BaseEntityExpression;
import io.teaql.core.value.Expression;
import io.teaql.core.value.ExpressionAdaptor;
import java.time.LocalDateTime;
import java.util.function.Function;

public class ShipmentExpression<T, E, U extends Shipment> extends ExpressionAdaptor<T, E, U> implements BaseEntityExpression<T, U> {
    public ShipmentExpression(Expression<T, U> expression){
        super(expression);
    }

    public ShipmentExpression(Expression<T, E> expression, Function<E, U> function){
        super(expression, function);
    }

     public ShipmentExpression<T, U, U> updateId(Long id){
        return new ShipmentExpression(this, $it -> {((Shipment)$it).__internalSet("id", id); return this;});
     }

     public ShipmentExpression<T, U, U> save(UserContext userContext){
        return new ShipmentExpression(this, $it -> ((Shipment)$it).auditAs("Saved by Expression").save(userContext));
     }

     public ShipmentExpression<T, U, U> save(String intent, UserContext userContext){
        return new ShipmentExpression(this, $it -> ((Shipment)$it).auditAs(intent).save(userContext));
     }

     public boolean isNull() {
        return resolve() == null;
     }


    public Expression<T, LocalDateTime> getShippedDate(){
       return apply(Shipment::getShippedDate);
    }
    public ShipmentExpression<T, U, U> updateShippedDate(LocalDateTime shippedDate){
       return new ShipmentExpression(this, $it ->  ((Shipment)$it).updateShippedDate(shippedDate));
    }

    public Expression<T, String> getCarrier(){
       return apply(Shipment::getCarrier);
    }
    public ShipmentExpression<T, U, U> updateCarrier(String carrier){
       return new ShipmentExpression(this, $it ->  ((Shipment)$it).updateCarrier(carrier));
    }

    public GlobalOrderExpression<T, U, GlobalOrder> getGlobalOrder(){
       return new GlobalOrderExpression(this, $it ->  ((Shipment)$it).getGlobalOrder());
    }

    public ShipmentExpression<T, U, U> updateGlobalOrder(GlobalOrder globalOrder){
       return new ShipmentExpression(this, $it ->  ((Shipment)$it).updateGlobalOrder(globalOrder));
    }

    public Expression<T, String> getStatus(){
       return apply(Shipment::getStatus);
    }
    public ShipmentExpression<T, U, U> updateStatus(String status){
       return new ShipmentExpression(this, $it ->  ((Shipment)$it).updateStatus(status));
    }

    public Expression<T, String> getTrackingNumber(){
       return apply(Shipment::getTrackingNumber);
    }
    public ShipmentExpression<T, U, U> updateTrackingNumber(String trackingNumber){
       return new ShipmentExpression(this, $it ->  ((Shipment)$it).updateTrackingNumber(trackingNumber));
    }

    public WarehouseExpression<T, U, Warehouse> getWarehouse(){
       return new WarehouseExpression(this, $it ->  ((Shipment)$it).getWarehouse());
    }

    public ShipmentExpression<T, U, U> updateWarehouse(Warehouse warehouse){
       return new ShipmentExpression(this, $it ->  ((Shipment)$it).updateWarehouse(warehouse));
    }

    public Expression<T, LocalDateTime> getCreateTime(){
       return apply(Shipment::getCreateTime);
    }
    public ShipmentExpression<T, U, U> updateCreateTime(LocalDateTime createTime){
       return new ShipmentExpression(this, $it ->  ((Shipment)$it).updateCreateTime(createTime));
    }

    public Expression<T, LocalDateTime> getUpdateTime(){
       return apply(Shipment::getUpdateTime);
    }
    public ShipmentExpression<T, U, U> updateUpdateTime(LocalDateTime updateTime){
       return new ShipmentExpression(this, $it ->  ((Shipment)$it).updateUpdateTime(updateTime));
    }

    public DeliveryListExpression<T, U, Delivery> getDeliveryList(){
        return new DeliveryListExpression(this, $it ->  ((Shipment)$it).getDeliveryList());
    }
    public ShipmentExpression<T, U, U> addDelivery(Delivery delivery){
       return new ShipmentExpression(this, $it ->  ((Shipment)$it).addDelivery(delivery));
    }
}