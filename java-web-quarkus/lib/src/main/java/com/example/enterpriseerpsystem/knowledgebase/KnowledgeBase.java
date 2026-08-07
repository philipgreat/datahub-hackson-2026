
package com.example.enterpriseerpsystem.knowledgebase;

import io.teaql.core.Audited;
import io.teaql.core.BaseEntity;
import io.teaql.core.EntityStatus;
import io.teaql.core.FrameworkInternal;
import io.teaql.core.RemoteInput;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * [TEAQL AI WARNING]
 * TeaQL was explicitly designed to PREVENT AI hallucinations and random guessing.
 * DO NOT GUESS METHOD NAMES!
 * The methods listed below are the ONLY valid ways to interact with this entity.
 * If you encounter compilation errors (e.g., method not found), DO NOT guess another method name.
 * Read the method signatures in this file before proceeding.
 */
public class KnowledgeBase extends BaseEntity implements RemoteInput {
    public static String INTERNAL_TYPE = "KnowledgeBase";

    public static final String CATEGORY_PROPERTY = "category";
    public static final String CONTENT_PROPERTY = "content";
    public static final String TITLE_PROPERTY = "title";
    public static final String VIEWS_PROPERTY = "views";
    public static final String CREATE_TIME_PROPERTY = "createTime";
    public static final String UPDATE_TIME_PROPERTY = "updateTime";
    private String category;
    private String content;
    private String title;
    private BigDecimal views;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

    public String getCategory(){
        return this.category;
    }
    public String getContent(){
        return this.content;
    }
    public String getTitle(){
        return this.title;
    }
    public BigDecimal getViews(){
        return this.views;
    }
    public LocalDateTime getCreateTime(){
        return this.createTime;
    }
    public LocalDateTime getUpdateTime(){
        return this.updateTime;
    }
    public KnowledgeBase updateCategory(String category){
        category = (category == null ? null : category.trim());
        if(Objects.equals(this.category, category)){
            return this;
        }
        handleUpdate(CATEGORY_PROPERTY, getCategory(), category);
        this.category = category;
        return this;
    }
    public KnowledgeBase updateContent(String content){
        content = (content == null ? null : content.trim());
        if(Objects.equals(this.content, content)){
            return this;
        }
        handleUpdate(CONTENT_PROPERTY, getContent(), content);
        this.content = content;
        return this;
    }
    public KnowledgeBase updateTitle(String title){
        title = (title == null ? null : title.trim());
        if(Objects.equals(this.title, title)){
            return this;
        }
        handleUpdate(TITLE_PROPERTY, getTitle(), title);
        this.title = title;
        return this;
    }
    public KnowledgeBase updateViews(BigDecimal views){
        if(Objects.equals(this.views, views)){
            return this;
        }
        handleUpdate(VIEWS_PROPERTY, getViews(), views);
        this.views = views;
        return this;
    }
    public KnowledgeBase updateCreateTime(LocalDateTime createTime){
        if(Objects.equals(this.createTime, createTime)){
            return this;
        }
        handleUpdate(CREATE_TIME_PROPERTY, getCreateTime(), createTime);
        this.createTime = createTime;
        return this;
    }
    public KnowledgeBase updateUpdateTime(LocalDateTime updateTime){
        if(Objects.equals(this.updateTime, updateTime)){
            return this;
        }
        handleUpdate(UPDATE_TIME_PROPERTY, getUpdateTime(), updateTime);
        this.updateTime = updateTime;
        return this;
    }

    public static KnowledgeBase refer(Long id){
        KnowledgeBase refer = new KnowledgeBase();
        refer.__internalSet("id", id);
        refer.set$status(EntityStatus.REFER);
        return refer;
    }
    @Override
    public String typeName(){
        return INTERNAL_TYPE;
    }

    public KnowledgeBase comment(String comment){
        this.setComment(comment);
        return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Audited<KnowledgeBase> auditAs(String action) {
        return super.auditAs(action);
    }

    // ===== Framework Internal: generated switch dispatch =====
    @Override
    @FrameworkInternal
    public void __internalSet(String property, Object value) {
        switch (property) {
            case "category": this.category = (value == null ? null : ((String)value).trim()); break;

            case "content": this.content = (value == null ? null : ((String)value).trim()); break;

            case "title": this.title = (value == null ? null : ((String)value).trim()); break;

            case "views": this.views = (BigDecimal) value; break;

            case "createTime": this.createTime = (LocalDateTime) value; break;

            case "updateTime": this.updateTime = (LocalDateTime) value; break;

            default: super.__internalSet(property, value);
        }
    }

    @Override
    @FrameworkInternal
    public Object __internalGet(String property) {
        switch (property) {
            case "category": return this.category;
            case "content": return this.content;
            case "title": return this.title;
            case "views": return this.views;
            case "createTime": return this.createTime;
            case "updateTime": return this.updateTime;
            default: return super.__internalGet(property);
        }
    }

}