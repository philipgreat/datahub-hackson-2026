
package com.example.enterpriseerpsystem.returnrequest;

import com.example.enterpriseerpsystem.customer.Customer;
import com.example.enterpriseerpsystem.customer.CustomerExpression;
import com.example.enterpriseerpsystem.globalorder.GlobalOrder;
import com.example.enterpriseerpsystem.globalorder.GlobalOrderExpression;
import io.teaql.core.UserContext;
import io.teaql.core.value.BaseEntityExpression;
import io.teaql.core.value.Expression;
import io.teaql.core.value.ExpressionAdaptor;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.function.Function;

public class ReturnRequestExpression<T, E, U extends ReturnRequest> extends ExpressionAdaptor<T, E, U> implements BaseEntityExpression<T, U> {
    public ReturnRequestExpression(Expression<T, U> expression){
        super(expression);
    }

    public ReturnRequestExpression(Expression<T, E> expression, Function<E, U> function){
        super(expression, function);
    }

     public ReturnRequestExpression<T, U, U> updateId(Long id){
        return new ReturnRequestExpression(this, $it -> {((ReturnRequest)$it).__internalSet("id", id); return this;});
     }

     public ReturnRequestExpression<T, U, U> save(UserContext userContext){
        return new ReturnRequestExpression(this, $it -> ((ReturnRequest)$it).auditAs("Saved by Expression").save(userContext));
     }

     public ReturnRequestExpression<T, U, U> save(String intent, UserContext userContext){
        return new ReturnRequestExpression(this, $it -> ((ReturnRequest)$it).auditAs(intent).save(userContext));
     }

     public boolean isNull() {
        return resolve() == null;
     }


    public Expression<T, BigDecimal> getRefundAmount(){
       return apply(ReturnRequest::getRefundAmount);
    }
    public ReturnRequestExpression<T, U, U> updateRefundAmount(BigDecimal refundAmount){
       return new ReturnRequestExpression(this, $it ->  ((ReturnRequest)$it).updateRefundAmount(refundAmount));
    }

    public CustomerExpression<T, U, Customer> getCustomer(){
       return new CustomerExpression(this, $it ->  ((ReturnRequest)$it).getCustomer());
    }

    public ReturnRequestExpression<T, U, U> updateCustomer(Customer customer){
       return new ReturnRequestExpression(this, $it ->  ((ReturnRequest)$it).updateCustomer(customer));
    }

    public GlobalOrderExpression<T, U, GlobalOrder> getGlobalOrder(){
       return new GlobalOrderExpression(this, $it ->  ((ReturnRequest)$it).getGlobalOrder());
    }

    public ReturnRequestExpression<T, U, U> updateGlobalOrder(GlobalOrder globalOrder){
       return new ReturnRequestExpression(this, $it ->  ((ReturnRequest)$it).updateGlobalOrder(globalOrder));
    }

    public Expression<T, String> getReason(){
       return apply(ReturnRequest::getReason);
    }
    public ReturnRequestExpression<T, U, U> updateReason(String reason){
       return new ReturnRequestExpression(this, $it ->  ((ReturnRequest)$it).updateReason(reason));
    }

    public Expression<T, String> getStatus(){
       return apply(ReturnRequest::getStatus);
    }
    public ReturnRequestExpression<T, U, U> updateStatus(String status){
       return new ReturnRequestExpression(this, $it ->  ((ReturnRequest)$it).updateStatus(status));
    }

    public Expression<T, LocalDateTime> getCreateTime(){
       return apply(ReturnRequest::getCreateTime);
    }
    public ReturnRequestExpression<T, U, U> updateCreateTime(LocalDateTime createTime){
       return new ReturnRequestExpression(this, $it ->  ((ReturnRequest)$it).updateCreateTime(createTime));
    }

    public Expression<T, LocalDateTime> getUpdateTime(){
       return apply(ReturnRequest::getUpdateTime);
    }
    public ReturnRequestExpression<T, U, U> updateUpdateTime(LocalDateTime updateTime){
       return new ReturnRequestExpression(this, $it ->  ((ReturnRequest)$it).updateUpdateTime(updateTime));
    }

}