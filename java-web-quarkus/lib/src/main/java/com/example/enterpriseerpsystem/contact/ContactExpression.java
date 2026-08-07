
package com.example.enterpriseerpsystem.contact;

import com.example.enterpriseerpsystem.customer.Customer;
import com.example.enterpriseerpsystem.customer.CustomerExpression;
import io.teaql.core.UserContext;
import io.teaql.core.value.BaseEntityExpression;
import io.teaql.core.value.Expression;
import io.teaql.core.value.ExpressionAdaptor;
import java.time.LocalDateTime;
import java.util.function.Function;

public class ContactExpression<T, E, U extends Contact> extends ExpressionAdaptor<T, E, U> implements BaseEntityExpression<T, U> {
    public ContactExpression(Expression<T, U> expression){
        super(expression);
    }

    public ContactExpression(Expression<T, E> expression, Function<E, U> function){
        super(expression, function);
    }

     public ContactExpression<T, U, U> updateId(Long id){
        return new ContactExpression(this, $it -> {((Contact)$it).__internalSet("id", id); return this;});
     }

     public ContactExpression<T, U, U> save(UserContext userContext){
        return new ContactExpression(this, $it -> ((Contact)$it).auditAs("Saved by Expression").save(userContext));
     }

     public ContactExpression<T, U, U> save(String intent, UserContext userContext){
        return new ContactExpression(this, $it -> ((Contact)$it).auditAs(intent).save(userContext));
     }

     public boolean isNull() {
        return resolve() == null;
     }


    public Expression<T, String> getEmail(){
       return apply(Contact::getEmail);
    }
    public ContactExpression<T, U, U> updateEmail(String email){
       return new ContactExpression(this, $it ->  ((Contact)$it).updateEmail(email));
    }

    public Expression<T, String> getName(){
       return apply(Contact::getName);
    }
    public ContactExpression<T, U, U> updateName(String name){
       return new ContactExpression(this, $it ->  ((Contact)$it).updateName(name));
    }

    public Expression<T, String> getPhone(){
       return apply(Contact::getPhone);
    }
    public ContactExpression<T, U, U> updatePhone(String phone){
       return new ContactExpression(this, $it ->  ((Contact)$it).updatePhone(phone));
    }

    public CustomerExpression<T, U, Customer> getCustomer(){
       return new CustomerExpression(this, $it ->  ((Contact)$it).getCustomer());
    }

    public ContactExpression<T, U, U> updateCustomer(Customer customer){
       return new ContactExpression(this, $it ->  ((Contact)$it).updateCustomer(customer));
    }

    public Expression<T, String> getRole(){
       return apply(Contact::getRole);
    }
    public ContactExpression<T, U, U> updateRole(String role){
       return new ContactExpression(this, $it ->  ((Contact)$it).updateRole(role));
    }

    public Expression<T, LocalDateTime> getCreateTime(){
       return apply(Contact::getCreateTime);
    }
    public ContactExpression<T, U, U> updateCreateTime(LocalDateTime createTime){
       return new ContactExpression(this, $it ->  ((Contact)$it).updateCreateTime(createTime));
    }

    public Expression<T, LocalDateTime> getUpdateTime(){
       return apply(Contact::getUpdateTime);
    }
    public ContactExpression<T, U, U> updateUpdateTime(LocalDateTime updateTime){
       return new ContactExpression(this, $it ->  ((Contact)$it).updateUpdateTime(updateTime));
    }

}