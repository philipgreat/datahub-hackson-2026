
package com.example.enterpriseerpsystem.knowledgebase;

import io.teaql.core.AggrFunction;
import io.teaql.core.BaseRequest;
import io.teaql.core.PropertyReference;
import io.teaql.core.SearchCriteria;
import io.teaql.core.criteria.Operator;
import io.teaql.core.criteria.TwoOperatorCriteria;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

public class KnowledgeBaseRequest<T extends KnowledgeBase> extends BaseRequest<T> {

    /**
     * @deprecated AI agents and business code must use the generated Q facade
     *             instead of constructing request builders directly.
     */
    @Deprecated
    public KnowledgeBaseRequest(Class<T> returnType){
        super(returnType);
        selectId();
        selectVersion();
    }

    public KnowledgeBaseRequest<T> comment(String comment){
         super.internalComment(comment);
         return this;
    }

    // purpose() 继承自 BaseRequest，返回 ExecutableRequest（终结方法）

    public KnowledgeBaseRequest<T> returnType(Class<? extends T> returnType){
        super.setReturnType(returnType);
        return this;
    }

    public KnowledgeBaseRequest<T> enableAggregationCache(long cacheExpiredMillis){
        super.enableAggregationCache();
        super.aggregateCacheTime(cacheExpiredMillis);
        return this;
    }

    public KnowledgeBaseRequest<T> enableAggregationCache(){
        return enableAggregationCache(0l);
    }


    public KnowledgeBaseRequest<T> propagateAggregationCache(long cacheExpiredMillis){
        super.propagateAggregationCache(cacheExpiredMillis);
        return this;
    }

    public KnowledgeBaseRequest<T> appendSearchCriteria(SearchCriteria searchCriteria){
        return (KnowledgeBaseRequest<T>)super.appendSearchCriteria(searchCriteria);
    }

    public KnowledgeBaseRequest<T> filter(String property1, Operator operator, String property2){
        return appendSearchCriteria(new TwoOperatorCriteria(operator, new PropertyReference(property1), new PropertyReference(property2)));
    }


    public KnowledgeBaseRequest<T> matchingAnyOf(KnowledgeBaseRequest knowledgeBase){
        super.internalMatchAny(knowledgeBase);
        return this;
    }

    public KnowledgeBaseRequest<T> enhanceChildrenIfNeeded(){
        return this;
    }

    public KnowledgeBaseRequest<T> withDeletedRows(){
        super.withDeletedRows();
        return this;
    }

    public KnowledgeBaseRequest<T> deletedRowsOnly(){
        super.deletedRowsOnly();
        return this;
    }

    public KnowledgeBaseRequest<T> selectSelf(){
        super.selectSelf();
        return selectId().selectCategory().selectContent().selectTitle().selectViews().selectCreateTime().selectUpdateTime().selectVersion();
    }

    public KnowledgeBaseRequest<T> selectSelfFields(){
        return selectSelf();
    }

    public KnowledgeBaseRequest<T> selectAll(){
        super.selectAll();
        return selectId().selectCategory().selectContent().selectTitle().selectViews().selectCreateTime().selectUpdateTime().selectVersion();
    }

    public KnowledgeBaseRequest<T> selectChildren(){
        super.selectAny();
        return selectId().selectCategory().selectContent().selectTitle().selectViews().selectCreateTime().selectUpdateTime().selectVersion();
    }


    public KnowledgeBaseRequest<T> selectId(){
       selectProperty(KnowledgeBase.ID_PROPERTY);
       return this;
    }

    /**
     * fill the id with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  id) to fetch id property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public KnowledgeBaseRequest<T> unselectId(){
       unselectProperty(KnowledgeBase.ID_PROPERTY);
       return this;
    }
    public KnowledgeBaseRequest<T> selectCategory(){
       selectProperty(KnowledgeBase.CATEGORY_PROPERTY);
       return this;
    }

    /**
     * fill the category with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  category) to fetch category property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public KnowledgeBaseRequest<T> unselectCategory(){
       unselectProperty(KnowledgeBase.CATEGORY_PROPERTY);
       return this;
    }
    public KnowledgeBaseRequest<T> selectContent(){
       selectProperty(KnowledgeBase.CONTENT_PROPERTY);
       return this;
    }

    /**
     * fill the content with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  content) to fetch content property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public KnowledgeBaseRequest<T> unselectContent(){
       unselectProperty(KnowledgeBase.CONTENT_PROPERTY);
       return this;
    }
    public KnowledgeBaseRequest<T> selectTitle(){
       selectProperty(KnowledgeBase.TITLE_PROPERTY);
       return this;
    }

    /**
     * fill the title with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  title) to fetch title property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public KnowledgeBaseRequest<T> unselectTitle(){
       unselectProperty(KnowledgeBase.TITLE_PROPERTY);
       return this;
    }
    public KnowledgeBaseRequest<T> selectViews(){
       selectProperty(KnowledgeBase.VIEWS_PROPERTY);
       return this;
    }

    /**
     * fill the views with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  views) to fetch views property.
     * @param rawSqlSegment  customized rawSqlSegment
     */


    /**
     * fill the views with customized aggrFunction, TEAQL uses ({aggrFunction}(views) AS views to fetch views property.
     * @param aggrFunction  aggrFunction
     */
    public KnowledgeBaseRequest<T> selectViews(AggrFunction aggrFunction){
       selectProperty(KnowledgeBase.VIEWS_PROPERTY, aggrFunction);
       return this;
    }


    public KnowledgeBaseRequest<T> unselectViews(){
       unselectProperty(KnowledgeBase.VIEWS_PROPERTY);
       return this;
    }
    public KnowledgeBaseRequest<T> selectCreateTime(){
       selectProperty(KnowledgeBase.CREATE_TIME_PROPERTY);
       return this;
    }

    /**
     * fill the createTime with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  createTime) to fetch createTime property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public KnowledgeBaseRequest<T> unselectCreateTime(){
       unselectProperty(KnowledgeBase.CREATE_TIME_PROPERTY);
       return this;
    }
    public KnowledgeBaseRequest<T> selectUpdateTime(){
       selectProperty(KnowledgeBase.UPDATE_TIME_PROPERTY);
       return this;
    }

    /**
     * fill the updateTime with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  updateTime) to fetch updateTime property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public KnowledgeBaseRequest<T> unselectUpdateTime(){
       unselectProperty(KnowledgeBase.UPDATE_TIME_PROPERTY);
       return this;
    }
    public KnowledgeBaseRequest<T> selectVersion(){
       selectProperty(KnowledgeBase.VERSION_PROPERTY);
       return this;
    }

    /**
     * fill the version with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  version) to fetch version property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public KnowledgeBaseRequest<T> unselectVersion(){
       unselectProperty(KnowledgeBase.VERSION_PROPERTY);
       return this;
    }

    public KnowledgeBaseRequest<T> withId(Operator operator, Object... values){
       return appendSearchCriteria(createIdCriteria(operator, values));
    }

    public SearchCriteria createIdCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(KnowledgeBase.ID_PROPERTY, operator, values);
    }

    public KnowledgeBaseRequest<T> withIdIs(Long id){
       return withId(Operator.EQUAL, id);
    }
    public KnowledgeBaseRequest<T> withIdIn(Long... id){
       return withId(Operator.EQUAL, (Object[])id);
    }



    public KnowledgeBaseRequest<T> filterByCategory(String... category){
      if (category == null || category.length == 0) {
        throw new IllegalArgumentException("filterByCategory parameter category cannot be empty");
      }
      return appendSearchCriteria(createCategoryCriteria(Operator.EQUAL, (Object[])category));
    }

    public KnowledgeBaseRequest<T> withCategory(Operator operator, Object... values){
       return appendSearchCriteria(createCategoryCriteria(operator, values));
    }

    public KnowledgeBaseRequest<T> withCategoryIsUnknown(){
       return withCategory(Operator.IS_NULL);
    }

    public KnowledgeBaseRequest<T> withCategoryIsKnown(){
       return withCategory(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createCategoryCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(KnowledgeBase.CATEGORY_PROPERTY, operator, values);
    }

    public KnowledgeBaseRequest<T> withCategoryGreaterThan(String category){
       return withCategory(Operator.GREATER_THAN, category);
    }

    public KnowledgeBaseRequest<T> withCategoryGreaterThanOrEqualTo(String category){
       return withCategory(Operator.GREATER_THAN_OR_EQUAL, category);
    }

    public KnowledgeBaseRequest<T> withCategoryLessThan(String category){
       return withCategory(Operator.LESS_THAN, category);
    }

    public KnowledgeBaseRequest<T> withCategoryLessThanOrEqualTo(String category){
       return withCategory(Operator.LESS_THAN_OR_EQUAL, category);
    }

    public KnowledgeBaseRequest<T> withCategoryBetween(String startOfCategory, String endOfCategory){
       return withCategory(Operator.BETWEEN, startOfCategory, endOfCategory);
    }
    public KnowledgeBaseRequest<T> withCategoryStartingWith(String category){
       return withCategory(Operator.BEGIN_WITH, category);
    }
    public KnowledgeBaseRequest<T> withCategoryContaining(String category){
       return withCategory(Operator.CONTAIN, category);
    }

    public KnowledgeBaseRequest<T> withCategoryEndingWith(String category){
       return withCategory(Operator.END_WITH, category);
    }

    public KnowledgeBaseRequest<T> withCategoryIs(String category){
       return withCategory(Operator.EQUAL, category);
    }

    public KnowledgeBaseRequest<T> withCategorySoundingLike(String category){
       return withCategory(Operator.SOUNDS_LIKE, category);
    }



    public KnowledgeBaseRequest<T> filterByContent(String... content){
      if (content == null || content.length == 0) {
        throw new IllegalArgumentException("filterByContent parameter content cannot be empty");
      }
      return appendSearchCriteria(createContentCriteria(Operator.EQUAL, (Object[])content));
    }

    public KnowledgeBaseRequest<T> withContent(Operator operator, Object... values){
       return appendSearchCriteria(createContentCriteria(operator, values));
    }

    public KnowledgeBaseRequest<T> withContentIsUnknown(){
       return withContent(Operator.IS_NULL);
    }

    public KnowledgeBaseRequest<T> withContentIsKnown(){
       return withContent(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createContentCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(KnowledgeBase.CONTENT_PROPERTY, operator, values);
    }

    public KnowledgeBaseRequest<T> withContentGreaterThan(String content){
       return withContent(Operator.GREATER_THAN, content);
    }

    public KnowledgeBaseRequest<T> withContentGreaterThanOrEqualTo(String content){
       return withContent(Operator.GREATER_THAN_OR_EQUAL, content);
    }

    public KnowledgeBaseRequest<T> withContentLessThan(String content){
       return withContent(Operator.LESS_THAN, content);
    }

    public KnowledgeBaseRequest<T> withContentLessThanOrEqualTo(String content){
       return withContent(Operator.LESS_THAN_OR_EQUAL, content);
    }

    public KnowledgeBaseRequest<T> withContentBetween(String startOfContent, String endOfContent){
       return withContent(Operator.BETWEEN, startOfContent, endOfContent);
    }
    public KnowledgeBaseRequest<T> withContentStartingWith(String content){
       return withContent(Operator.BEGIN_WITH, content);
    }
    public KnowledgeBaseRequest<T> withContentContaining(String content){
       return withContent(Operator.CONTAIN, content);
    }

    public KnowledgeBaseRequest<T> withContentEndingWith(String content){
       return withContent(Operator.END_WITH, content);
    }

    public KnowledgeBaseRequest<T> withContentIs(String content){
       return withContent(Operator.EQUAL, content);
    }

    public KnowledgeBaseRequest<T> withContentSoundingLike(String content){
       return withContent(Operator.SOUNDS_LIKE, content);
    }



    public KnowledgeBaseRequest<T> filterByTitle(String... title){
      if (title == null || title.length == 0) {
        throw new IllegalArgumentException("filterByTitle parameter title cannot be empty");
      }
      return appendSearchCriteria(createTitleCriteria(Operator.EQUAL, (Object[])title));
    }

    public KnowledgeBaseRequest<T> withTitle(Operator operator, Object... values){
       return appendSearchCriteria(createTitleCriteria(operator, values));
    }

    public KnowledgeBaseRequest<T> withTitleIsUnknown(){
       return withTitle(Operator.IS_NULL);
    }

    public KnowledgeBaseRequest<T> withTitleIsKnown(){
       return withTitle(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createTitleCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(KnowledgeBase.TITLE_PROPERTY, operator, values);
    }

    public KnowledgeBaseRequest<T> withTitleGreaterThan(String title){
       return withTitle(Operator.GREATER_THAN, title);
    }

    public KnowledgeBaseRequest<T> withTitleGreaterThanOrEqualTo(String title){
       return withTitle(Operator.GREATER_THAN_OR_EQUAL, title);
    }

    public KnowledgeBaseRequest<T> withTitleLessThan(String title){
       return withTitle(Operator.LESS_THAN, title);
    }

    public KnowledgeBaseRequest<T> withTitleLessThanOrEqualTo(String title){
       return withTitle(Operator.LESS_THAN_OR_EQUAL, title);
    }

    public KnowledgeBaseRequest<T> withTitleBetween(String startOfTitle, String endOfTitle){
       return withTitle(Operator.BETWEEN, startOfTitle, endOfTitle);
    }
    public KnowledgeBaseRequest<T> withTitleStartingWith(String title){
       return withTitle(Operator.BEGIN_WITH, title);
    }
    public KnowledgeBaseRequest<T> withTitleContaining(String title){
       return withTitle(Operator.CONTAIN, title);
    }

    public KnowledgeBaseRequest<T> withTitleEndingWith(String title){
       return withTitle(Operator.END_WITH, title);
    }

    public KnowledgeBaseRequest<T> withTitleIs(String title){
       return withTitle(Operator.EQUAL, title);
    }

    public KnowledgeBaseRequest<T> withTitleSoundingLike(String title){
       return withTitle(Operator.SOUNDS_LIKE, title);
    }



    public KnowledgeBaseRequest<T> filterByViews(BigDecimal... views){
      if (views == null || views.length == 0) {
        throw new IllegalArgumentException("filterByViews parameter views cannot be empty");
      }
      return appendSearchCriteria(createViewsCriteria(Operator.EQUAL, (Object[])views));
    }

    public KnowledgeBaseRequest<T> withViews(Operator operator, Object... values){
       return appendSearchCriteria(createViewsCriteria(operator, values));
    }

    public KnowledgeBaseRequest<T> withViewsIsUnknown(){
       return withViews(Operator.IS_NULL);
    }

    public KnowledgeBaseRequest<T> withViewsIsKnown(){
       return withViews(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createViewsCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(KnowledgeBase.VIEWS_PROPERTY, operator, values);
    }

    public KnowledgeBaseRequest<T> withViewsGreaterThan(BigDecimal views){
       return withViews(Operator.GREATER_THAN, views);
    }

    public KnowledgeBaseRequest<T> withViewsGreaterThanOrEqualTo(BigDecimal views){
       return withViews(Operator.GREATER_THAN_OR_EQUAL, views);
    }

    public KnowledgeBaseRequest<T> withViewsLessThan(BigDecimal views){
       return withViews(Operator.LESS_THAN, views);
    }

    public KnowledgeBaseRequest<T> withViewsLessThanOrEqualTo(BigDecimal views){
       return withViews(Operator.LESS_THAN_OR_EQUAL, views);
    }

    public KnowledgeBaseRequest<T> withViewsBetween(BigDecimal startOfViews, BigDecimal endOfViews){
       return withViews(Operator.BETWEEN, startOfViews, endOfViews);
    }



    public KnowledgeBaseRequest<T> filterByCreateTime(LocalDateTime... createTime){
      if (createTime == null || createTime.length == 0) {
        throw new IllegalArgumentException("filterByCreateTime parameter createTime cannot be empty");
      }
      return appendSearchCriteria(createCreateTimeCriteria(Operator.EQUAL, (Object[])createTime));
    }

    public KnowledgeBaseRequest<T> withCreateTime(Operator operator, Object... values){
       return appendSearchCriteria(createCreateTimeCriteria(operator, values));
    }

    public KnowledgeBaseRequest<T> withCreateTimeIsUnknown(){
       return withCreateTime(Operator.IS_NULL);
    }

    public KnowledgeBaseRequest<T> withCreateTimeIsKnown(){
       return withCreateTime(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createCreateTimeCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(KnowledgeBase.CREATE_TIME_PROPERTY, operator, values);
    }

    public KnowledgeBaseRequest<T> withCreateTimeGreaterThan(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public KnowledgeBaseRequest<T> withCreateTimeGreaterThanOrEqualTo(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN_OR_EQUAL, createTime);
    }

    public KnowledgeBaseRequest<T> withCreateTimeLessThan(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public KnowledgeBaseRequest<T> withCreateTimeLessThanOrEqualTo(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN_OR_EQUAL, createTime);
    }

    public KnowledgeBaseRequest<T> withCreateTimeBetween(LocalDateTime startOfCreateTime, LocalDateTime endOfCreateTime){
       return withCreateTime(Operator.BETWEEN, startOfCreateTime, endOfCreateTime);
    }
    public KnowledgeBaseRequest<T> withCreateTimeBefore(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public KnowledgeBaseRequest<T> withCreateTimeBefore(Date createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public KnowledgeBaseRequest<T> withCreateTimeAfter(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public KnowledgeBaseRequest<T> withCreateTimeAfter(Date createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public KnowledgeBaseRequest<T> withCreateTimeBetween(Date startOfCreateTime, Date endOfCreateTime){
       return withCreateTime(Operator.BETWEEN, startOfCreateTime, endOfCreateTime);
    }




    public KnowledgeBaseRequest<T> filterByUpdateTime(LocalDateTime... updateTime){
      if (updateTime == null || updateTime.length == 0) {
        throw new IllegalArgumentException("filterByUpdateTime parameter updateTime cannot be empty");
      }
      return appendSearchCriteria(createUpdateTimeCriteria(Operator.EQUAL, (Object[])updateTime));
    }

    public KnowledgeBaseRequest<T> withUpdateTime(Operator operator, Object... values){
       return appendSearchCriteria(createUpdateTimeCriteria(operator, values));
    }

    public KnowledgeBaseRequest<T> withUpdateTimeIsUnknown(){
       return withUpdateTime(Operator.IS_NULL);
    }

    public KnowledgeBaseRequest<T> withUpdateTimeIsKnown(){
       return withUpdateTime(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createUpdateTimeCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(KnowledgeBase.UPDATE_TIME_PROPERTY, operator, values);
    }

    public KnowledgeBaseRequest<T> withUpdateTimeGreaterThan(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public KnowledgeBaseRequest<T> withUpdateTimeGreaterThanOrEqualTo(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN_OR_EQUAL, updateTime);
    }

    public KnowledgeBaseRequest<T> withUpdateTimeLessThan(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public KnowledgeBaseRequest<T> withUpdateTimeLessThanOrEqualTo(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN_OR_EQUAL, updateTime);
    }

    public KnowledgeBaseRequest<T> withUpdateTimeBetween(LocalDateTime startOfUpdateTime, LocalDateTime endOfUpdateTime){
       return withUpdateTime(Operator.BETWEEN, startOfUpdateTime, endOfUpdateTime);
    }
    public KnowledgeBaseRequest<T> withUpdateTimeBefore(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public KnowledgeBaseRequest<T> withUpdateTimeBefore(Date updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public KnowledgeBaseRequest<T> withUpdateTimeAfter(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public KnowledgeBaseRequest<T> withUpdateTimeAfter(Date updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public KnowledgeBaseRequest<T> withUpdateTimeBetween(Date startOfUpdateTime, Date endOfUpdateTime){
       return withUpdateTime(Operator.BETWEEN, startOfUpdateTime, endOfUpdateTime);
    }




    public KnowledgeBaseRequest<T> filterByVersion(Long... version){
      if (version == null || version.length == 0) {
        throw new IllegalArgumentException("filterByVersion parameter version cannot be empty");
      }
      return appendSearchCriteria(createVersionCriteria(Operator.EQUAL, (Object[])version));
    }

    public KnowledgeBaseRequest<T> withVersion(Operator operator, Object... values){
       return appendSearchCriteria(createVersionCriteria(operator, values));
    }

    public KnowledgeBaseRequest<T> withVersionIsUnknown(){
       return withVersion(Operator.IS_NULL);
    }

    public KnowledgeBaseRequest<T> withVersionIsKnown(){
       return withVersion(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createVersionCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(KnowledgeBase.VERSION_PROPERTY, operator, values);
    }

    public KnowledgeBaseRequest<T> withVersionGreaterThan(Long version){
       return withVersion(Operator.GREATER_THAN, version);
    }

    public KnowledgeBaseRequest<T> withVersionGreaterThanOrEqualTo(Long version){
       return withVersion(Operator.GREATER_THAN_OR_EQUAL, version);
    }

    public KnowledgeBaseRequest<T> withVersionLessThan(Long version){
       return withVersion(Operator.LESS_THAN, version);
    }

    public KnowledgeBaseRequest<T> withVersionLessThanOrEqualTo(Long version){
       return withVersion(Operator.LESS_THAN_OR_EQUAL, version);
    }

    public KnowledgeBaseRequest<T> withVersionBetween(Long startOfVersion, Long endOfVersion){
       return withVersion(Operator.BETWEEN, startOfVersion, endOfVersion);
    }


    public KnowledgeBaseRequest<T> count(){
        super.count();
        return this;
    }
    public KnowledgeBaseRequest<T> countAs(String retName){
        super.count(retName);
        return this;
    }
    public KnowledgeBaseRequest minViews(){
        return minViewsAs(prefix("minOf",KnowledgeBase.VIEWS_PROPERTY));
    }

    public KnowledgeBaseRequest minViewsAs(String retName){
        super.min(retName, KnowledgeBase.VIEWS_PROPERTY);
        return this;
    }
    public KnowledgeBaseRequest maxViews(){
        return maxViewsAs(prefix("maxOf",KnowledgeBase.VIEWS_PROPERTY));
    }

    public KnowledgeBaseRequest maxViewsAs(String retName){
        super.max(retName, KnowledgeBase.VIEWS_PROPERTY);
        return this;
    }
    public KnowledgeBaseRequest sumViews(){
        return sumViewsAs(prefix("sumOf",KnowledgeBase.VIEWS_PROPERTY));
    }

    public KnowledgeBaseRequest sumViewsAs(String retName){
        super.sum(retName, KnowledgeBase.VIEWS_PROPERTY);
        return this;
    }
    public KnowledgeBaseRequest avgViews(){
        return avgViewsAs(prefix("avgOf",KnowledgeBase.VIEWS_PROPERTY));
    }

    public KnowledgeBaseRequest avgViewsAs(String retName){
        super.avg(retName, KnowledgeBase.VIEWS_PROPERTY);
        return this;
    }
    public KnowledgeBaseRequest standardDeviationViews(){
        return standardDeviationViewsAs(prefix("standardDeviationOf",KnowledgeBase.VIEWS_PROPERTY));
    }

    public KnowledgeBaseRequest standardDeviationViewsAs(String retName){
        super.standardDeviation(retName, KnowledgeBase.VIEWS_PROPERTY);
        return this;
    }
    public KnowledgeBaseRequest squareRootOfPopulationStandardDeviationViews(){
        return squareRootOfPopulationStandardDeviationViewsAs(prefix("squareRootOfPopulationStandardDeviationOf",KnowledgeBase.VIEWS_PROPERTY));
    }

    public KnowledgeBaseRequest squareRootOfPopulationStandardDeviationViewsAs(String retName){
        super.squareRootOfPopulationStandardDeviation(retName, KnowledgeBase.VIEWS_PROPERTY);
        return this;
    }
    public KnowledgeBaseRequest sampleVarianceViews(){
        return sampleVarianceViewsAs(prefix("sampleVarianceOf",KnowledgeBase.VIEWS_PROPERTY));
    }

    public KnowledgeBaseRequest sampleVarianceViewsAs(String retName){
        super.sampleVariance(retName, KnowledgeBase.VIEWS_PROPERTY);
        return this;
    }
    public KnowledgeBaseRequest samplePopulationVarianceViews(){
        return samplePopulationVarianceViewsAs(prefix("samplePopulationVarianceOf",KnowledgeBase.VIEWS_PROPERTY));
    }

    public KnowledgeBaseRequest samplePopulationVarianceViewsAs(String retName){
        super.samplePopulationVariance(retName, KnowledgeBase.VIEWS_PROPERTY);
        return this;
    }

    public KnowledgeBaseRequest<T> groupById(){
       groupBy(KnowledgeBase.ID_PROPERTY);
       return this;
    }

    public KnowledgeBaseRequest<T> groupByIdAs(String retName){
       groupBy(retName, KnowledgeBase.ID_PROPERTY);
       return this;
    }

    public KnowledgeBaseRequest<T> groupByIdWithFunction(String retName, AggrFunction function){
       groupBy(retName, KnowledgeBase.ID_PROPERTY, function);
       return this;
    }

    public KnowledgeBaseRequest<T> groupByCategory(){
       groupBy(KnowledgeBase.CATEGORY_PROPERTY);
       return this;
    }

    public KnowledgeBaseRequest<T> groupByCategoryAs(String retName){
       groupBy(retName, KnowledgeBase.CATEGORY_PROPERTY);
       return this;
    }

    public KnowledgeBaseRequest<T> groupByCategoryWithFunction(String retName, AggrFunction function){
       groupBy(retName, KnowledgeBase.CATEGORY_PROPERTY, function);
       return this;
    }

    public KnowledgeBaseRequest<T> groupByContent(){
       groupBy(KnowledgeBase.CONTENT_PROPERTY);
       return this;
    }

    public KnowledgeBaseRequest<T> groupByContentAs(String retName){
       groupBy(retName, KnowledgeBase.CONTENT_PROPERTY);
       return this;
    }

    public KnowledgeBaseRequest<T> groupByContentWithFunction(String retName, AggrFunction function){
       groupBy(retName, KnowledgeBase.CONTENT_PROPERTY, function);
       return this;
    }

    public KnowledgeBaseRequest<T> groupByTitle(){
       groupBy(KnowledgeBase.TITLE_PROPERTY);
       return this;
    }

    public KnowledgeBaseRequest<T> groupByTitleAs(String retName){
       groupBy(retName, KnowledgeBase.TITLE_PROPERTY);
       return this;
    }

    public KnowledgeBaseRequest<T> groupByTitleWithFunction(String retName, AggrFunction function){
       groupBy(retName, KnowledgeBase.TITLE_PROPERTY, function);
       return this;
    }

    public KnowledgeBaseRequest<T> groupByViews(){
       groupBy(KnowledgeBase.VIEWS_PROPERTY);
       return this;
    }

    public KnowledgeBaseRequest<T> groupByViewsAs(String retName){
       groupBy(retName, KnowledgeBase.VIEWS_PROPERTY);
       return this;
    }

    public KnowledgeBaseRequest<T> groupByViewsWithFunction(String retName, AggrFunction function){
       groupBy(retName, KnowledgeBase.VIEWS_PROPERTY, function);
       return this;
    }

    public KnowledgeBaseRequest<T> groupByCreateTime(){
       groupBy(KnowledgeBase.CREATE_TIME_PROPERTY);
       return this;
    }

    public KnowledgeBaseRequest<T> groupByCreateTimeAs(String retName){
       groupBy(retName, KnowledgeBase.CREATE_TIME_PROPERTY);
       return this;
    }

    public KnowledgeBaseRequest<T> groupByCreateTimeWithFunction(String retName, AggrFunction function){
       groupBy(retName, KnowledgeBase.CREATE_TIME_PROPERTY, function);
       return this;
    }

    public KnowledgeBaseRequest<T> groupByUpdateTime(){
       groupBy(KnowledgeBase.UPDATE_TIME_PROPERTY);
       return this;
    }

    public KnowledgeBaseRequest<T> groupByUpdateTimeAs(String retName){
       groupBy(retName, KnowledgeBase.UPDATE_TIME_PROPERTY);
       return this;
    }

    public KnowledgeBaseRequest<T> groupByUpdateTimeWithFunction(String retName, AggrFunction function){
       groupBy(retName, KnowledgeBase.UPDATE_TIME_PROPERTY, function);
       return this;
    }

    public KnowledgeBaseRequest<T> groupByVersion(){
       groupBy(KnowledgeBase.VERSION_PROPERTY);
       return this;
    }

    public KnowledgeBaseRequest<T> groupByVersionAs(String retName){
       groupBy(retName, KnowledgeBase.VERSION_PROPERTY);
       return this;
    }

    public KnowledgeBaseRequest<T> groupByVersionWithFunction(String retName, AggrFunction function){
       groupBy(retName, KnowledgeBase.VERSION_PROPERTY, function);
       return this;
    }



    public KnowledgeBaseRequest<T> orderByIdAscending(){
       addOrderByAscending(KnowledgeBase.ID_PROPERTY);
       return this;
    }

    public KnowledgeBaseRequest<T> orderByIdDescending(){
       addOrderByDescending(KnowledgeBase.ID_PROPERTY);
       return this;
    }

    public KnowledgeBaseRequest<T> orderByCategoryAscending(){
       addOrderByAscending(KnowledgeBase.CATEGORY_PROPERTY);
       return this;
    }

    public KnowledgeBaseRequest<T> orderByCategoryDescending(){
       addOrderByDescending(KnowledgeBase.CATEGORY_PROPERTY);
       return this;
    }
    public KnowledgeBaseRequest<T> orderByCategoryAscendingUsingGBK(){
       addOrderByAscendingUsingGBK(KnowledgeBase.CATEGORY_PROPERTY);
       return this;
    }

    public KnowledgeBaseRequest<T> orderByCategoryDescendingUsingGBK(){
       addOrderByDescendingUsingGBK(KnowledgeBase.CATEGORY_PROPERTY);
       return this;
    }
    public KnowledgeBaseRequest<T> orderByContentAscending(){
       addOrderByAscending(KnowledgeBase.CONTENT_PROPERTY);
       return this;
    }

    public KnowledgeBaseRequest<T> orderByContentDescending(){
       addOrderByDescending(KnowledgeBase.CONTENT_PROPERTY);
       return this;
    }
    public KnowledgeBaseRequest<T> orderByContentAscendingUsingGBK(){
       addOrderByAscendingUsingGBK(KnowledgeBase.CONTENT_PROPERTY);
       return this;
    }

    public KnowledgeBaseRequest<T> orderByContentDescendingUsingGBK(){
       addOrderByDescendingUsingGBK(KnowledgeBase.CONTENT_PROPERTY);
       return this;
    }
    public KnowledgeBaseRequest<T> orderByTitleAscending(){
       addOrderByAscending(KnowledgeBase.TITLE_PROPERTY);
       return this;
    }

    public KnowledgeBaseRequest<T> orderByTitleDescending(){
       addOrderByDescending(KnowledgeBase.TITLE_PROPERTY);
       return this;
    }
    public KnowledgeBaseRequest<T> orderByTitleAscendingUsingGBK(){
       addOrderByAscendingUsingGBK(KnowledgeBase.TITLE_PROPERTY);
       return this;
    }

    public KnowledgeBaseRequest<T> orderByTitleDescendingUsingGBK(){
       addOrderByDescendingUsingGBK(KnowledgeBase.TITLE_PROPERTY);
       return this;
    }
    public KnowledgeBaseRequest<T> orderByViewsAscending(){
       addOrderByAscending(KnowledgeBase.VIEWS_PROPERTY);
       return this;
    }

    public KnowledgeBaseRequest<T> orderByViewsDescending(){
       addOrderByDescending(KnowledgeBase.VIEWS_PROPERTY);
       return this;
    }

    public KnowledgeBaseRequest<T> orderByCreateTimeAscending(){
       addOrderByAscending(KnowledgeBase.CREATE_TIME_PROPERTY);
       return this;
    }

    public KnowledgeBaseRequest<T> orderByCreateTimeDescending(){
       addOrderByDescending(KnowledgeBase.CREATE_TIME_PROPERTY);
       return this;
    }

    public KnowledgeBaseRequest<T> orderByUpdateTimeAscending(){
       addOrderByAscending(KnowledgeBase.UPDATE_TIME_PROPERTY);
       return this;
    }

    public KnowledgeBaseRequest<T> orderByUpdateTimeDescending(){
       addOrderByDescending(KnowledgeBase.UPDATE_TIME_PROPERTY);
       return this;
    }

    public KnowledgeBaseRequest<T> orderByVersionAscending(){
       addOrderByAscending(KnowledgeBase.VERSION_PROPERTY);
       return this;
    }

    public KnowledgeBaseRequest<T> orderByVersionDescending(){
       addOrderByDescending(KnowledgeBase.VERSION_PROPERTY);
       return this;
    }





    /**
     * get topN records
     * @param topN  records number
     */
    public KnowledgeBaseRequest<T> top(int topN) {
        super.top(topN);
        return this;
    }

    /**
     * get records from offset(inclusive) to offset+size(exclusive)
     * @param offset record offset
     * @param size records number
     */
    public KnowledgeBaseRequest<T> offset(int offset, int size) {
        super.offset(offset, size);
        return this;
    }

    /**
     * retrieve all records
     */
    public KnowledgeBaseRequest<T> unlimited() {
        super.unlimited();
        return this;
    }

    /**
     * get records of one page
     * @param pageNumber page number(1-based)
     * @param pageSize page size
     */
    public KnowledgeBaseRequest<T> page(int pageNumber, int pageSize) {
        int offset = (pageNumber - 1) * pageSize;
        return offset(offset, pageSize);
   }

    /**
     * get records of one page, default page size is 10
     * @param pageNumber page number(1-based)
     */
    public KnowledgeBaseRequest<T> page(int pageNumber) {
        return page(pageNumber, 10);
   }
}