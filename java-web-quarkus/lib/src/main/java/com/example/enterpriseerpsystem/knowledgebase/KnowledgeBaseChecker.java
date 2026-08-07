
package com.example.enterpriseerpsystem.knowledgebase;

import io.teaql.core.UserContext;
import io.teaql.core.checker.Checker;
import io.teaql.core.checker.ObjectLocation;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class KnowledgeBaseChecker implements Checker<KnowledgeBase>{

    public String type(){
        return KnowledgeBase.INTERNAL_TYPE;
    }

    public void checkAndFix(UserContext _ctx, KnowledgeBase knowledgeBase, ObjectLocation _parentLocation){
        if(needCheck(_ctx, knowledgeBase)){
            markAsChecked(_ctx, knowledgeBase);
            doCheck(_ctx, knowledgeBase, _parentLocation);
        }
    }

    public void doCheck(UserContext _ctx, KnowledgeBase knowledgeBase, ObjectLocation _parentLocation){
      if((knowledgeBase == null)){
         return;
      }
      if(knowledgeBase.newItem()){
        if(knowledgeBase.getCreateTime() == null){
           knowledgeBase.updateCreateTime(java.time.LocalDateTime.now());
        }if(knowledgeBase.getUpdateTime() == null){
           knowledgeBase.updateUpdateTime(java.time.LocalDateTime.now());
        }
      }else if(knowledgeBase.updateItem()){
        knowledgeBase.updateUpdateTime(java.time.LocalDateTime.now());
      }
      checkCategory(_ctx, knowledgeBase.getProperty(KnowledgeBase.CATEGORY_PROPERTY), newLocation(_parentLocation, KnowledgeBase.CATEGORY_PROPERTY));
      checkContent(_ctx, knowledgeBase.getProperty(KnowledgeBase.CONTENT_PROPERTY), newLocation(_parentLocation, KnowledgeBase.CONTENT_PROPERTY));
      checkTitle(_ctx, knowledgeBase.getProperty(KnowledgeBase.TITLE_PROPERTY), newLocation(_parentLocation, KnowledgeBase.TITLE_PROPERTY));
      checkViews(_ctx, knowledgeBase.getProperty(KnowledgeBase.VIEWS_PROPERTY), newLocation(_parentLocation, KnowledgeBase.VIEWS_PROPERTY));
      checkCreateTime(_ctx, knowledgeBase.getProperty(KnowledgeBase.CREATE_TIME_PROPERTY), newLocation(_parentLocation, KnowledgeBase.CREATE_TIME_PROPERTY));
      checkUpdateTime(_ctx, knowledgeBase.getProperty(KnowledgeBase.UPDATE_TIME_PROPERTY), newLocation(_parentLocation, KnowledgeBase.UPDATE_TIME_PROPERTY));
    }

    public void checkCategory(UserContext _ctx, String category, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, category);
    if((category == null)){
        return;
    }
    maxStringCheck(_ctx, _parentLocation, 100, category);

    }
    public void checkContent(UserContext _ctx, String content, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, content);
    if((content == null)){
        return;
    }
    maxStringCheck(_ctx, _parentLocation, 100, content);

    }
    public void checkTitle(UserContext _ctx, String title, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, title);
    if((title == null)){
        return;
    }
    maxStringCheck(_ctx, _parentLocation, 100, title);

    }
    public void checkViews(UserContext _ctx, BigDecimal views, ObjectLocation _parentLocation){
    requiredCheck(_ctx, _parentLocation, views);
    if((views == null)){
        return;
    }
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