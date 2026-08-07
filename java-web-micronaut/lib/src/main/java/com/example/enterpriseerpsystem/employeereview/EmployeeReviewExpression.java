
package com.example.enterpriseerpsystem.employeereview;

import com.example.enterpriseerpsystem.employee.Employee;
import com.example.enterpriseerpsystem.employee.EmployeeExpression;
import io.teaql.core.UserContext;
import io.teaql.core.value.BaseEntityExpression;
import io.teaql.core.value.Expression;
import io.teaql.core.value.ExpressionAdaptor;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.function.Function;

public class EmployeeReviewExpression<T, E, U extends EmployeeReview> extends ExpressionAdaptor<T, E, U> implements BaseEntityExpression<T, U> {
    public EmployeeReviewExpression(Expression<T, U> expression){
        super(expression);
    }

    public EmployeeReviewExpression(Expression<T, E> expression, Function<E, U> function){
        super(expression, function);
    }

     public EmployeeReviewExpression<T, U, U> updateId(Long id){
        return new EmployeeReviewExpression(this, $it -> {((EmployeeReview)$it).__internalSet("id", id); return this;});
     }

     public EmployeeReviewExpression<T, U, U> save(UserContext userContext){
        return new EmployeeReviewExpression(this, $it -> ((EmployeeReview)$it).auditAs("Saved by Expression").save(userContext));
     }

     public EmployeeReviewExpression<T, U, U> save(String intent, UserContext userContext){
        return new EmployeeReviewExpression(this, $it -> ((EmployeeReview)$it).auditAs(intent).save(userContext));
     }

     public boolean isNull() {
        return resolve() == null;
     }


    public Expression<T, String> getComments(){
       return apply(EmployeeReview::getComments);
    }
    public EmployeeReviewExpression<T, U, U> updateComments(String comments){
       return new EmployeeReviewExpression(this, $it ->  ((EmployeeReview)$it).updateComments(comments));
    }

    public EmployeeExpression<T, U, Employee> getEmployee(){
       return new EmployeeExpression(this, $it ->  ((EmployeeReview)$it).getEmployee());
    }

    public EmployeeReviewExpression<T, U, U> updateEmployee(Employee employee){
       return new EmployeeReviewExpression(this, $it ->  ((EmployeeReview)$it).updateEmployee(employee));
    }

    public Expression<T, LocalDateTime> getReviewDate(){
       return apply(EmployeeReview::getReviewDate);
    }
    public EmployeeReviewExpression<T, U, U> updateReviewDate(LocalDateTime reviewDate){
       return new EmployeeReviewExpression(this, $it ->  ((EmployeeReview)$it).updateReviewDate(reviewDate));
    }

    public Expression<T, String> getReviewerId(){
       return apply(EmployeeReview::getReviewerId);
    }
    public EmployeeReviewExpression<T, U, U> updateReviewerId(String reviewerId){
       return new EmployeeReviewExpression(this, $it ->  ((EmployeeReview)$it).updateReviewerId(reviewerId));
    }

    public Expression<T, BigDecimal> getScore(){
       return apply(EmployeeReview::getScore);
    }
    public EmployeeReviewExpression<T, U, U> updateScore(BigDecimal score){
       return new EmployeeReviewExpression(this, $it ->  ((EmployeeReview)$it).updateScore(score));
    }

    public Expression<T, LocalDateTime> getCreateTime(){
       return apply(EmployeeReview::getCreateTime);
    }
    public EmployeeReviewExpression<T, U, U> updateCreateTime(LocalDateTime createTime){
       return new EmployeeReviewExpression(this, $it ->  ((EmployeeReview)$it).updateCreateTime(createTime));
    }

    public Expression<T, LocalDateTime> getUpdateTime(){
       return apply(EmployeeReview::getUpdateTime);
    }
    public EmployeeReviewExpression<T, U, U> updateUpdateTime(LocalDateTime updateTime){
       return new EmployeeReviewExpression(this, $it ->  ((EmployeeReview)$it).updateUpdateTime(updateTime));
    }

}