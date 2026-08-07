
package com.example.enterpriseerpsystem.category;

import com.example.enterpriseerpsystem.product.Product;
import com.example.enterpriseerpsystem.product.ProductListExpression;
import io.teaql.core.UserContext;
import io.teaql.core.value.BaseEntityExpression;
import io.teaql.core.value.Expression;
import io.teaql.core.value.ExpressionAdaptor;
import java.time.LocalDateTime;
import java.util.function.Function;

public class CategoryExpression<T, E, U extends Category> extends ExpressionAdaptor<T, E, U> implements BaseEntityExpression<T, U> {
    public CategoryExpression(Expression<T, U> expression){
        super(expression);
    }

    public CategoryExpression(Expression<T, E> expression, Function<E, U> function){
        super(expression, function);
    }

     public CategoryExpression<T, U, U> updateId(Long id){
        return new CategoryExpression(this, $it -> {((Category)$it).__internalSet("id", id); return this;});
     }

     public CategoryExpression<T, U, U> save(UserContext userContext){
        return new CategoryExpression(this, $it -> ((Category)$it).auditAs("Saved by Expression").save(userContext));
     }

     public CategoryExpression<T, U, U> save(String intent, UserContext userContext){
        return new CategoryExpression(this, $it -> ((Category)$it).auditAs(intent).save(userContext));
     }

     public boolean isNull() {
        return resolve() == null;
     }


    public Expression<T, String> getDescription(){
       return apply(Category::getDescription);
    }
    public CategoryExpression<T, U, U> updateDescription(String description){
       return new CategoryExpression(this, $it ->  ((Category)$it).updateDescription(description));
    }

    public Expression<T, String> getName(){
       return apply(Category::getName);
    }
    public CategoryExpression<T, U, U> updateName(String name){
       return new CategoryExpression(this, $it ->  ((Category)$it).updateName(name));
    }

    public Expression<T, String> getParentId(){
       return apply(Category::getParentId);
    }
    public CategoryExpression<T, U, U> updateParentId(String parentId){
       return new CategoryExpression(this, $it ->  ((Category)$it).updateParentId(parentId));
    }

    public Expression<T, LocalDateTime> getCreateTime(){
       return apply(Category::getCreateTime);
    }
    public CategoryExpression<T, U, U> updateCreateTime(LocalDateTime createTime){
       return new CategoryExpression(this, $it ->  ((Category)$it).updateCreateTime(createTime));
    }

    public Expression<T, LocalDateTime> getUpdateTime(){
       return apply(Category::getUpdateTime);
    }
    public CategoryExpression<T, U, U> updateUpdateTime(LocalDateTime updateTime){
       return new CategoryExpression(this, $it ->  ((Category)$it).updateUpdateTime(updateTime));
    }

    public ProductListExpression<T, U, Product> getProductList(){
        return new ProductListExpression(this, $it ->  ((Category)$it).getProductList());
    }
    public CategoryExpression<T, U, U> addProduct(Product product){
       return new CategoryExpression(this, $it ->  ((Category)$it).addProduct(product));
    }
}