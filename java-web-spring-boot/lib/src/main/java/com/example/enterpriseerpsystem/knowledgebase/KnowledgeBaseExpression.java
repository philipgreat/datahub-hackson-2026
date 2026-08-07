
package com.example.enterpriseerpsystem.knowledgebase;

import io.teaql.core.UserContext;
import io.teaql.core.value.BaseEntityExpression;
import io.teaql.core.value.Expression;
import io.teaql.core.value.ExpressionAdaptor;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.function.Function;

public class KnowledgeBaseExpression<T, E, U extends KnowledgeBase> extends ExpressionAdaptor<T, E, U> implements BaseEntityExpression<T, U> {
    public KnowledgeBaseExpression(Expression<T, U> expression){
        super(expression);
    }

    public KnowledgeBaseExpression(Expression<T, E> expression, Function<E, U> function){
        super(expression, function);
    }

     public KnowledgeBaseExpression<T, U, U> updateId(Long id){
        return new KnowledgeBaseExpression(this, $it -> {((KnowledgeBase)$it).__internalSet("id", id); return this;});
     }

     public KnowledgeBaseExpression<T, U, U> save(UserContext userContext){
        return new KnowledgeBaseExpression(this, $it -> ((KnowledgeBase)$it).auditAs("Saved by Expression").save(userContext));
     }

     public KnowledgeBaseExpression<T, U, U> save(String intent, UserContext userContext){
        return new KnowledgeBaseExpression(this, $it -> ((KnowledgeBase)$it).auditAs(intent).save(userContext));
     }

     public boolean isNull() {
        return resolve() == null;
     }


    public Expression<T, String> getCategory(){
       return apply(KnowledgeBase::getCategory);
    }
    public KnowledgeBaseExpression<T, U, U> updateCategory(String category){
       return new KnowledgeBaseExpression(this, $it ->  ((KnowledgeBase)$it).updateCategory(category));
    }

    public Expression<T, String> getContent(){
       return apply(KnowledgeBase::getContent);
    }
    public KnowledgeBaseExpression<T, U, U> updateContent(String content){
       return new KnowledgeBaseExpression(this, $it ->  ((KnowledgeBase)$it).updateContent(content));
    }

    public Expression<T, String> getTitle(){
       return apply(KnowledgeBase::getTitle);
    }
    public KnowledgeBaseExpression<T, U, U> updateTitle(String title){
       return new KnowledgeBaseExpression(this, $it ->  ((KnowledgeBase)$it).updateTitle(title));
    }

    public Expression<T, BigDecimal> getViews(){
       return apply(KnowledgeBase::getViews);
    }
    public KnowledgeBaseExpression<T, U, U> updateViews(BigDecimal views){
       return new KnowledgeBaseExpression(this, $it ->  ((KnowledgeBase)$it).updateViews(views));
    }

    public Expression<T, LocalDateTime> getCreateTime(){
       return apply(KnowledgeBase::getCreateTime);
    }
    public KnowledgeBaseExpression<T, U, U> updateCreateTime(LocalDateTime createTime){
       return new KnowledgeBaseExpression(this, $it ->  ((KnowledgeBase)$it).updateCreateTime(createTime));
    }

    public Expression<T, LocalDateTime> getUpdateTime(){
       return apply(KnowledgeBase::getUpdateTime);
    }
    public KnowledgeBaseExpression<T, U, U> updateUpdateTime(LocalDateTime updateTime){
       return new KnowledgeBaseExpression(this, $it ->  ((KnowledgeBase)$it).updateUpdateTime(updateTime));
    }

}