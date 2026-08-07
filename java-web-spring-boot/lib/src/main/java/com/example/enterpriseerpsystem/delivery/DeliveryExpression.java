
package com.example.enterpriseerpsystem.delivery;

import com.example.enterpriseerpsystem.shipment.Shipment;
import com.example.enterpriseerpsystem.shipment.ShipmentExpression;
import io.teaql.core.UserContext;
import io.teaql.core.value.BaseEntityExpression;
import io.teaql.core.value.Expression;
import io.teaql.core.value.ExpressionAdaptor;
import java.time.LocalDateTime;
import java.util.function.Function;

public class DeliveryExpression<T, E, U extends Delivery> extends ExpressionAdaptor<T, E, U> implements BaseEntityExpression<T, U> {
    public DeliveryExpression(Expression<T, U> expression){
        super(expression);
    }

    public DeliveryExpression(Expression<T, E> expression, Function<E, U> function){
        super(expression, function);
    }

     public DeliveryExpression<T, U, U> updateId(Long id){
        return new DeliveryExpression(this, $it -> {((Delivery)$it).__internalSet("id", id); return this;});
     }

     public DeliveryExpression<T, U, U> save(UserContext userContext){
        return new DeliveryExpression(this, $it -> ((Delivery)$it).auditAs("Saved by Expression").save(userContext));
     }

     public DeliveryExpression<T, U, U> save(String intent, UserContext userContext){
        return new DeliveryExpression(this, $it -> ((Delivery)$it).auditAs(intent).save(userContext));
     }

     public boolean isNull() {
        return resolve() == null;
     }


    public Expression<T, String> getRecipientSignature(){
       return apply(Delivery::getRecipientSignature);
    }
    public DeliveryExpression<T, U, U> updateRecipientSignature(String recipientSignature){
       return new DeliveryExpression(this, $it ->  ((Delivery)$it).updateRecipientSignature(recipientSignature));
    }

    public ShipmentExpression<T, U, Shipment> getShipment(){
       return new ShipmentExpression(this, $it ->  ((Delivery)$it).getShipment());
    }

    public DeliveryExpression<T, U, U> updateShipment(Shipment shipment){
       return new DeliveryExpression(this, $it ->  ((Delivery)$it).updateShipment(shipment));
    }

    public Expression<T, LocalDateTime> getDeliveryDate(){
       return apply(Delivery::getDeliveryDate);
    }
    public DeliveryExpression<T, U, U> updateDeliveryDate(LocalDateTime deliveryDate){
       return new DeliveryExpression(this, $it ->  ((Delivery)$it).updateDeliveryDate(deliveryDate));
    }

    public Expression<T, String> getStatus(){
       return apply(Delivery::getStatus);
    }
    public DeliveryExpression<T, U, U> updateStatus(String status){
       return new DeliveryExpression(this, $it ->  ((Delivery)$it).updateStatus(status));
    }

    public Expression<T, LocalDateTime> getCreateTime(){
       return apply(Delivery::getCreateTime);
    }
    public DeliveryExpression<T, U, U> updateCreateTime(LocalDateTime createTime){
       return new DeliveryExpression(this, $it ->  ((Delivery)$it).updateCreateTime(createTime));
    }

    public Expression<T, LocalDateTime> getUpdateTime(){
       return apply(Delivery::getUpdateTime);
    }
    public DeliveryExpression<T, U, U> updateUpdateTime(LocalDateTime updateTime){
       return new DeliveryExpression(this, $it ->  ((Delivery)$it).updateUpdateTime(updateTime));
    }

}