
package com.example.enterpriseerpsystem.category;

import com.example.enterpriseerpsystem.product.Product;
import io.teaql.core.Audited;
import io.teaql.core.BaseEntity;
import io.teaql.core.EntityStatus;
import io.teaql.core.FrameworkInternal;
import io.teaql.core.RemoteInput;
import io.teaql.core.SmartList;
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
public class Category extends BaseEntity implements RemoteInput {
    public static String INTERNAL_TYPE = "Category";

    public static final String DESCRIPTION_PROPERTY = "description";
    public static final String NAME_PROPERTY = "name";
    public static final String PARENT_ID_PROPERTY = "parentId";
    public static final String CREATE_TIME_PROPERTY = "createTime";
    public static final String UPDATE_TIME_PROPERTY = "updateTime";
    public static final String PRODUCT_LIST_PROPERTY = "productList";
    private String description;
    private String name;
    private String parentId;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private SmartList<Product> productList;

    public String getDescription(){
        return this.description;
    }
    public String getName(){
        return this.name;
    }
    public String getParentId(){
        return this.parentId;
    }
    public LocalDateTime getCreateTime(){
        return this.createTime;
    }
    public LocalDateTime getUpdateTime(){
        return this.updateTime;
    }
    public SmartList<Product> getProductList(){
        return this.productList;
    }
    public Category updateDescription(String description){
        description = (description == null ? null : description.trim());
        if(Objects.equals(this.description, description)){
            return this;
        }
        handleUpdate(DESCRIPTION_PROPERTY, getDescription(), description);
        this.description = description;
        return this;
    }
    public Category updateName(String name){
        name = (name == null ? null : name.trim());
        if(Objects.equals(this.name, name)){
            return this;
        }
        handleUpdate(NAME_PROPERTY, getName(), name);
        this.name = name;
        return this;
    }
    public Category updateParentId(String parentId){
        parentId = (parentId == null ? null : parentId.trim());
        if(Objects.equals(this.parentId, parentId)){
            return this;
        }
        handleUpdate(PARENT_ID_PROPERTY, getParentId(), parentId);
        this.parentId = parentId;
        return this;
    }
    public Category updateCreateTime(LocalDateTime createTime){
        if(Objects.equals(this.createTime, createTime)){
            return this;
        }
        handleUpdate(CREATE_TIME_PROPERTY, getCreateTime(), createTime);
        this.createTime = createTime;
        return this;
    }
    public Category updateUpdateTime(LocalDateTime updateTime){
        if(Objects.equals(this.updateTime, updateTime)){
            return this;
        }
        handleUpdate(UPDATE_TIME_PROPERTY, getUpdateTime(), updateTime);
        this.updateTime = updateTime;
        return this;
    }
    public Category addProduct(Product product){
        if (product == null){
            return this;
        }

        if(null == this.productList){
            this.productList = new SmartList<>();
        }

        this.productList.add(product);
        product.cacheRelation(Product.CATEGORY_PROPERTY, this);
        return this;
    }

    public static Category refer(Long id){
        Category refer = new Category();
        refer.__internalSet("id", id);
        refer.set$status(EntityStatus.REFER);
        return refer;
    }
    @Override
    public String typeName(){
        return INTERNAL_TYPE;
    }

    public Category comment(String comment){
        this.setComment(comment);
        return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Audited<Category> auditAs(String action) {
        return super.auditAs(action);
    }

    // ===== Framework Internal: generated switch dispatch =====
    @Override
    @FrameworkInternal
    public void __internalSet(String property, Object value) {
        switch (property) {
            case "description": this.description = (value == null ? null : ((String)value).trim()); break;

            case "name": this.name = (value == null ? null : ((String)value).trim()); break;

            case "parentId": this.parentId = (value == null ? null : ((String)value).trim()); break;

            case "createTime": this.createTime = (LocalDateTime) value; break;

            case "updateTime": this.updateTime = (LocalDateTime) value; break;

            case "productList": this.productList = (SmartList<Product>) value; break;
            default: super.__internalSet(property, value);
        }
    }

    @Override
    @FrameworkInternal
    public Object __internalGet(String property) {
        switch (property) {
            case "description": return this.description;
            case "name": return this.name;
            case "parentId": return this.parentId;
            case "createTime": return this.createTime;
            case "updateTime": return this.updateTime;
            case "productList": return this.productList;
            default: return super.__internalGet(property);
        }
    }

}