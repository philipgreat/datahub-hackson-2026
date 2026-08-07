
package com.example.enterpriseerpsystem.invoice;

import com.example.enterpriseerpsystem.customer.Customer;
import com.example.enterpriseerpsystem.customer.CustomerExpression;
import com.example.enterpriseerpsystem.globalorder.GlobalOrder;
import com.example.enterpriseerpsystem.globalorder.GlobalOrderExpression;
import com.example.enterpriseerpsystem.payment.Payment;
import com.example.enterpriseerpsystem.payment.PaymentListExpression;
import io.teaql.core.UserContext;
import io.teaql.core.value.BaseEntityExpression;
import io.teaql.core.value.Expression;
import io.teaql.core.value.ExpressionAdaptor;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.function.Function;

public class InvoiceExpression<T, E, U extends Invoice> extends ExpressionAdaptor<T, E, U> implements BaseEntityExpression<T, U> {
    public InvoiceExpression(Expression<T, U> expression){
        super(expression);
    }

    public InvoiceExpression(Expression<T, E> expression, Function<E, U> function){
        super(expression, function);
    }

     public InvoiceExpression<T, U, U> updateId(Long id){
        return new InvoiceExpression(this, $it -> {((Invoice)$it).__internalSet("id", id); return this;});
     }

     public InvoiceExpression<T, U, U> save(UserContext userContext){
        return new InvoiceExpression(this, $it -> ((Invoice)$it).auditAs("Saved by Expression").save(userContext));
     }

     public InvoiceExpression<T, U, U> save(String intent, UserContext userContext){
        return new InvoiceExpression(this, $it -> ((Invoice)$it).auditAs(intent).save(userContext));
     }

     public boolean isNull() {
        return resolve() == null;
     }


    public Expression<T, BigDecimal> getAmount(){
       return apply(Invoice::getAmount);
    }
    public InvoiceExpression<T, U, U> updateAmount(BigDecimal amount){
       return new InvoiceExpression(this, $it ->  ((Invoice)$it).updateAmount(amount));
    }

    public CustomerExpression<T, U, Customer> getCustomer(){
       return new CustomerExpression(this, $it ->  ((Invoice)$it).getCustomer());
    }

    public InvoiceExpression<T, U, U> updateCustomer(Customer customer){
       return new InvoiceExpression(this, $it ->  ((Invoice)$it).updateCustomer(customer));
    }

    public Expression<T, LocalDateTime> getDueDate(){
       return apply(Invoice::getDueDate);
    }
    public InvoiceExpression<T, U, U> updateDueDate(LocalDateTime dueDate){
       return new InvoiceExpression(this, $it ->  ((Invoice)$it).updateDueDate(dueDate));
    }

    public GlobalOrderExpression<T, U, GlobalOrder> getGlobalOrder(){
       return new GlobalOrderExpression(this, $it ->  ((Invoice)$it).getGlobalOrder());
    }

    public InvoiceExpression<T, U, U> updateGlobalOrder(GlobalOrder globalOrder){
       return new InvoiceExpression(this, $it ->  ((Invoice)$it).updateGlobalOrder(globalOrder));
    }

    public Expression<T, LocalDateTime> getIssueDate(){
       return apply(Invoice::getIssueDate);
    }
    public InvoiceExpression<T, U, U> updateIssueDate(LocalDateTime issueDate){
       return new InvoiceExpression(this, $it ->  ((Invoice)$it).updateIssueDate(issueDate));
    }

    public Expression<T, String> getStatus(){
       return apply(Invoice::getStatus);
    }
    public InvoiceExpression<T, U, U> updateStatus(String status){
       return new InvoiceExpression(this, $it ->  ((Invoice)$it).updateStatus(status));
    }

    public Expression<T, LocalDateTime> getCreateTime(){
       return apply(Invoice::getCreateTime);
    }
    public InvoiceExpression<T, U, U> updateCreateTime(LocalDateTime createTime){
       return new InvoiceExpression(this, $it ->  ((Invoice)$it).updateCreateTime(createTime));
    }

    public Expression<T, LocalDateTime> getUpdateTime(){
       return apply(Invoice::getUpdateTime);
    }
    public InvoiceExpression<T, U, U> updateUpdateTime(LocalDateTime updateTime){
       return new InvoiceExpression(this, $it ->  ((Invoice)$it).updateUpdateTime(updateTime));
    }

    public PaymentListExpression<T, U, Payment> getPaymentList(){
        return new PaymentListExpression(this, $it ->  ((Invoice)$it).getPaymentList());
    }
    public InvoiceExpression<T, U, U> addPayment(Payment payment){
       return new InvoiceExpression(this, $it ->  ((Invoice)$it).addPayment(payment));
    }
}