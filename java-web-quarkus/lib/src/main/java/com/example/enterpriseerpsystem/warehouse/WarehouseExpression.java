
package com.example.enterpriseerpsystem.warehouse;

import com.example.enterpriseerpsystem.inventoryitem.InventoryItem;
import com.example.enterpriseerpsystem.inventoryitem.InventoryItemListExpression;
import com.example.enterpriseerpsystem.shipment.Shipment;
import com.example.enterpriseerpsystem.shipment.ShipmentListExpression;
import io.teaql.core.UserContext;
import io.teaql.core.value.BaseEntityExpression;
import io.teaql.core.value.Expression;
import io.teaql.core.value.ExpressionAdaptor;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.function.Function;

public class WarehouseExpression<T, E, U extends Warehouse> extends ExpressionAdaptor<T, E, U> implements BaseEntityExpression<T, U> {
    public WarehouseExpression(Expression<T, U> expression){
        super(expression);
    }

    public WarehouseExpression(Expression<T, E> expression, Function<E, U> function){
        super(expression, function);
    }

     public WarehouseExpression<T, U, U> updateId(Long id){
        return new WarehouseExpression(this, $it -> {((Warehouse)$it).__internalSet("id", id); return this;});
     }

     public WarehouseExpression<T, U, U> save(UserContext userContext){
        return new WarehouseExpression(this, $it -> ((Warehouse)$it).auditAs("Saved by Expression").save(userContext));
     }

     public WarehouseExpression<T, U, U> save(String intent, UserContext userContext){
        return new WarehouseExpression(this, $it -> ((Warehouse)$it).auditAs(intent).save(userContext));
     }

     public boolean isNull() {
        return resolve() == null;
     }


    public Expression<T, String> getName(){
       return apply(Warehouse::getName);
    }
    public WarehouseExpression<T, U, U> updateName(String name){
       return new WarehouseExpression(this, $it ->  ((Warehouse)$it).updateName(name));
    }

    public Expression<T, BigDecimal> getCapacity(){
       return apply(Warehouse::getCapacity);
    }
    public WarehouseExpression<T, U, U> updateCapacity(BigDecimal capacity){
       return new WarehouseExpression(this, $it ->  ((Warehouse)$it).updateCapacity(capacity));
    }

    public Expression<T, String> getLocation(){
       return apply(Warehouse::getLocation);
    }
    public WarehouseExpression<T, U, U> updateLocation(String location){
       return new WarehouseExpression(this, $it ->  ((Warehouse)$it).updateLocation(location));
    }

    public Expression<T, String> getManagerId(){
       return apply(Warehouse::getManagerId);
    }
    public WarehouseExpression<T, U, U> updateManagerId(String managerId){
       return new WarehouseExpression(this, $it ->  ((Warehouse)$it).updateManagerId(managerId));
    }

    public Expression<T, LocalDateTime> getCreateTime(){
       return apply(Warehouse::getCreateTime);
    }
    public WarehouseExpression<T, U, U> updateCreateTime(LocalDateTime createTime){
       return new WarehouseExpression(this, $it ->  ((Warehouse)$it).updateCreateTime(createTime));
    }

    public Expression<T, LocalDateTime> getUpdateTime(){
       return apply(Warehouse::getUpdateTime);
    }
    public WarehouseExpression<T, U, U> updateUpdateTime(LocalDateTime updateTime){
       return new WarehouseExpression(this, $it ->  ((Warehouse)$it).updateUpdateTime(updateTime));
    }

    public InventoryItemListExpression<T, U, InventoryItem> getInventoryItemList(){
        return new InventoryItemListExpression(this, $it ->  ((Warehouse)$it).getInventoryItemList());
    }
    public ShipmentListExpression<T, U, Shipment> getShipmentList(){
        return new ShipmentListExpression(this, $it ->  ((Warehouse)$it).getShipmentList());
    }
    public WarehouseExpression<T, U, U> addInventoryItem(InventoryItem inventoryItem){
       return new WarehouseExpression(this, $it ->  ((Warehouse)$it).addInventoryItem(inventoryItem));
    }
    public WarehouseExpression<T, U, U> addShipment(Shipment shipment){
       return new WarehouseExpression(this, $it ->  ((Warehouse)$it).addShipment(shipment));
    }
}