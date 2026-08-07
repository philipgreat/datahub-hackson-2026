
package com.example.enterpriseerpsystem.category;

import com.example.enterpriseerpsystem.product.Product;
import com.example.enterpriseerpsystem.product.ProductChecker;
import io.teaql.core.UserContext;
import io.teaql.core.checker.Checker;
import io.teaql.core.checker.ObjectLocation;
import java.time.LocalDateTime;

public class CategoryChecker implements Checker<Category>{

    public String type(){
        return Category.INTERNAL_TYPE;
    }

    public void checkAndFix(UserContext _ctx, Category category, ObjectLocation _parentLocation){
        if(needCheck(_ctx, category)){
            markAsChecked(_ctx, category);
            doCheck(_ctx, category, _parentLocation);
        }
    }

    public void doCheck(UserContext _ctx, Category category, ObjectLocation _parentLocation){
      if((category == null)){
         return;
      }
      if(category.newItem()){
        if(category.getCreateTime() == null){
           category.updateCreateTime(java.time.LocalDateTime.now());
        }if(category.getUpdateTime() == null){
           category.updateUpdateTime(java.time.LocalDateTime.now());
        }
      }else if(category.updateItem()){
        category.updateUpdateTime(java.time.LocalDateTime.now());
      }
      checkDescription(_ctx, category.getProperty(Category.DESCRIPTION_PROPERTY), newLocation(_parentLocation, Category.DESCRIPTION_PROPERTY));
      checkName(_ctx, category.getProperty(Category.NAME_PROPERTY), newLocation(_parentLocation, Category.NAME_PROPERTY));
      checkParentId(_ctx, category.getProperty(Category.PARENT_ID_PROPERTY), newLocation(_parentLocation, Category.PARENT_ID_PROPERTY));
      checkCreateTime(_ctx, category.getProperty(Category.CREATE_TIME_PROPERTY), newLocation(_parentLocation, Category.CREATE_TIME_PROPERTY));
      checkUpdateTime(_ctx, category.getProperty(Category.UPDATE_TIME_PROPERTY), newLocation(_parentLocation, Category.UPDATE_TIME_PROPERTY));
      for(int i = 0; category.getProductList() != null && i < category.getProductList().size(); i++){
         Product product = category.getProductList().get(i);
         new ProductChecker().checkAndFix(_ctx, product, newLocation(_parentLocation, Category.PRODUCT_LIST_PROPERTY, i));
      }
    }

    public void checkDescription(UserContext _ctx, String description, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, description);
    if((description == null)){
        return;
    }
    maxStringCheck(_ctx, _parentLocation, 100, description);

    }
    public void checkName(UserContext _ctx, String name, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, name);
    if((name == null)){
        return;
    }
    maxStringCheck(_ctx, _parentLocation, 100, name);

    }
    public void checkParentId(UserContext _ctx, String parentId, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, parentId);
    if((parentId == null)){
        return;
    }
    maxStringCheck(_ctx, _parentLocation, 100, parentId);

    }
    public void checkCreateTime(UserContext _ctx, LocalDateTime createTime, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, createTime);
    if((createTime == null)){
        return;
    }
    }
    public void checkUpdateTime(UserContext _ctx, LocalDateTime updateTime, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, updateTime);
    if((updateTime == null)){
        return;
    }
    }
}