
package com.example.enterpriseerpsystem.salesterritory;

import io.teaql.core.AggrFunction;
import io.teaql.core.BaseRequest;
import io.teaql.core.PropertyReference;
import io.teaql.core.SearchCriteria;
import io.teaql.core.criteria.Operator;
import io.teaql.core.criteria.TwoOperatorCriteria;
import java.time.LocalDateTime;
import java.util.Date;

public class SalesTerritoryRequest<T extends SalesTerritory> extends BaseRequest<T> {

    /**
     * @deprecated AI agents and business code must use the generated Q facade
     *             instead of constructing request builders directly.
     */
    @Deprecated
    public SalesTerritoryRequest(Class<T> returnType){
        super(returnType);
        selectId();
        selectVersion();
    }

    public SalesTerritoryRequest<T> comment(String comment){
         super.internalComment(comment);
         return this;
    }

    // purpose() 继承自 BaseRequest，返回 ExecutableRequest（终结方法）

    public SalesTerritoryRequest<T> returnType(Class<? extends T> returnType){
        super.setReturnType(returnType);
        return this;
    }

    public SalesTerritoryRequest<T> enableAggregationCache(long cacheExpiredMillis){
        super.enableAggregationCache();
        super.aggregateCacheTime(cacheExpiredMillis);
        return this;
    }

    public SalesTerritoryRequest<T> enableAggregationCache(){
        return enableAggregationCache(0l);
    }


    public SalesTerritoryRequest<T> propagateAggregationCache(long cacheExpiredMillis){
        super.propagateAggregationCache(cacheExpiredMillis);
        return this;
    }

    public SalesTerritoryRequest<T> appendSearchCriteria(SearchCriteria searchCriteria){
        return (SalesTerritoryRequest<T>)super.appendSearchCriteria(searchCriteria);
    }

    public SalesTerritoryRequest<T> filter(String property1, Operator operator, String property2){
        return appendSearchCriteria(new TwoOperatorCriteria(operator, new PropertyReference(property1), new PropertyReference(property2)));
    }


    public SalesTerritoryRequest<T> matchingAnyOf(SalesTerritoryRequest salesTerritory){
        super.internalMatchAny(salesTerritory);
        return this;
    }

    public SalesTerritoryRequest<T> enhanceChildrenIfNeeded(){
        return this;
    }

    public SalesTerritoryRequest<T> withDeletedRows(){
        super.withDeletedRows();
        return this;
    }

    public SalesTerritoryRequest<T> deletedRowsOnly(){
        super.deletedRowsOnly();
        return this;
    }

    public SalesTerritoryRequest<T> selectSelf(){
        super.selectSelf();
        return selectId().selectName().selectManagerId().selectRegion().selectCreateTime().selectUpdateTime().selectVersion();
    }

    public SalesTerritoryRequest<T> selectSelfFields(){
        return selectSelf();
    }

    public SalesTerritoryRequest<T> selectAll(){
        super.selectAll();
        return selectId().selectName().selectManagerId().selectRegion().selectCreateTime().selectUpdateTime().selectVersion();
    }

    public SalesTerritoryRequest<T> selectChildren(){
        super.selectAny();
        return selectId().selectName().selectManagerId().selectRegion().selectCreateTime().selectUpdateTime().selectVersion();
    }


    public SalesTerritoryRequest<T> selectId(){
       selectProperty(SalesTerritory.ID_PROPERTY);
       return this;
    }

    /**
     * fill the id with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  id) to fetch id property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public SalesTerritoryRequest<T> unselectId(){
       unselectProperty(SalesTerritory.ID_PROPERTY);
       return this;
    }
    public SalesTerritoryRequest<T> selectName(){
       selectProperty(SalesTerritory.NAME_PROPERTY);
       return this;
    }

    /**
     * fill the name with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  name) to fetch name property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public SalesTerritoryRequest<T> unselectName(){
       unselectProperty(SalesTerritory.NAME_PROPERTY);
       return this;
    }
    public SalesTerritoryRequest<T> selectManagerId(){
       selectProperty(SalesTerritory.MANAGER_ID_PROPERTY);
       return this;
    }

    /**
     * fill the managerId with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  managerId) to fetch managerId property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public SalesTerritoryRequest<T> unselectManagerId(){
       unselectProperty(SalesTerritory.MANAGER_ID_PROPERTY);
       return this;
    }
    public SalesTerritoryRequest<T> selectRegion(){
       selectProperty(SalesTerritory.REGION_PROPERTY);
       return this;
    }

    /**
     * fill the region with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  region) to fetch region property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public SalesTerritoryRequest<T> unselectRegion(){
       unselectProperty(SalesTerritory.REGION_PROPERTY);
       return this;
    }
    public SalesTerritoryRequest<T> selectCreateTime(){
       selectProperty(SalesTerritory.CREATE_TIME_PROPERTY);
       return this;
    }

    /**
     * fill the createTime with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  createTime) to fetch createTime property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public SalesTerritoryRequest<T> unselectCreateTime(){
       unselectProperty(SalesTerritory.CREATE_TIME_PROPERTY);
       return this;
    }
    public SalesTerritoryRequest<T> selectUpdateTime(){
       selectProperty(SalesTerritory.UPDATE_TIME_PROPERTY);
       return this;
    }

    /**
     * fill the updateTime with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  updateTime) to fetch updateTime property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public SalesTerritoryRequest<T> unselectUpdateTime(){
       unselectProperty(SalesTerritory.UPDATE_TIME_PROPERTY);
       return this;
    }
    public SalesTerritoryRequest<T> selectVersion(){
       selectProperty(SalesTerritory.VERSION_PROPERTY);
       return this;
    }

    /**
     * fill the version with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  version) to fetch version property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public SalesTerritoryRequest<T> unselectVersion(){
       unselectProperty(SalesTerritory.VERSION_PROPERTY);
       return this;
    }

    public SalesTerritoryRequest<T> withId(Operator operator, Object... values){
       return appendSearchCriteria(createIdCriteria(operator, values));
    }

    public SearchCriteria createIdCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(SalesTerritory.ID_PROPERTY, operator, values);
    }

    public SalesTerritoryRequest<T> withIdIs(Long id){
       return withId(Operator.EQUAL, id);
    }
    public SalesTerritoryRequest<T> withIdIn(Long... id){
       return withId(Operator.EQUAL, (Object[])id);
    }



    public SalesTerritoryRequest<T> filterByName(String... name){
      if (name == null || name.length == 0) {
        throw new IllegalArgumentException("filterByName parameter name cannot be empty");
      }
      return appendSearchCriteria(createNameCriteria(Operator.EQUAL, (Object[])name));
    }

    public SalesTerritoryRequest<T> withName(Operator operator, Object... values){
       return appendSearchCriteria(createNameCriteria(operator, values));
    }

    public SalesTerritoryRequest<T> withNameIsUnknown(){
       return withName(Operator.IS_NULL);
    }

    public SalesTerritoryRequest<T> withNameIsKnown(){
       return withName(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createNameCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(SalesTerritory.NAME_PROPERTY, operator, values);
    }

    public SalesTerritoryRequest<T> withNameGreaterThan(String name){
       return withName(Operator.GREATER_THAN, name);
    }

    public SalesTerritoryRequest<T> withNameGreaterThanOrEqualTo(String name){
       return withName(Operator.GREATER_THAN_OR_EQUAL, name);
    }

    public SalesTerritoryRequest<T> withNameLessThan(String name){
       return withName(Operator.LESS_THAN, name);
    }

    public SalesTerritoryRequest<T> withNameLessThanOrEqualTo(String name){
       return withName(Operator.LESS_THAN_OR_EQUAL, name);
    }

    public SalesTerritoryRequest<T> withNameBetween(String startOfName, String endOfName){
       return withName(Operator.BETWEEN, startOfName, endOfName);
    }
    public SalesTerritoryRequest<T> withNameStartingWith(String name){
       return withName(Operator.BEGIN_WITH, name);
    }
    public SalesTerritoryRequest<T> withNameContaining(String name){
       return withName(Operator.CONTAIN, name);
    }

    public SalesTerritoryRequest<T> withNameEndingWith(String name){
       return withName(Operator.END_WITH, name);
    }

    public SalesTerritoryRequest<T> withNameIs(String name){
       return withName(Operator.EQUAL, name);
    }

    public SalesTerritoryRequest<T> withNameSoundingLike(String name){
       return withName(Operator.SOUNDS_LIKE, name);
    }



    public SalesTerritoryRequest<T> filterByManagerId(String... managerId){
      if (managerId == null || managerId.length == 0) {
        throw new IllegalArgumentException("filterByManagerId parameter managerId cannot be empty");
      }
      return appendSearchCriteria(createManagerIdCriteria(Operator.EQUAL, (Object[])managerId));
    }

    public SalesTerritoryRequest<T> withManagerId(Operator operator, Object... values){
       return appendSearchCriteria(createManagerIdCriteria(operator, values));
    }

    public SalesTerritoryRequest<T> withManagerIdIsUnknown(){
       return withManagerId(Operator.IS_NULL);
    }

    public SalesTerritoryRequest<T> withManagerIdIsKnown(){
       return withManagerId(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createManagerIdCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(SalesTerritory.MANAGER_ID_PROPERTY, operator, values);
    }

    public SalesTerritoryRequest<T> withManagerIdGreaterThan(String managerId){
       return withManagerId(Operator.GREATER_THAN, managerId);
    }

    public SalesTerritoryRequest<T> withManagerIdGreaterThanOrEqualTo(String managerId){
       return withManagerId(Operator.GREATER_THAN_OR_EQUAL, managerId);
    }

    public SalesTerritoryRequest<T> withManagerIdLessThan(String managerId){
       return withManagerId(Operator.LESS_THAN, managerId);
    }

    public SalesTerritoryRequest<T> withManagerIdLessThanOrEqualTo(String managerId){
       return withManagerId(Operator.LESS_THAN_OR_EQUAL, managerId);
    }

    public SalesTerritoryRequest<T> withManagerIdBetween(String startOfManagerId, String endOfManagerId){
       return withManagerId(Operator.BETWEEN, startOfManagerId, endOfManagerId);
    }
    public SalesTerritoryRequest<T> withManagerIdStartingWith(String managerId){
       return withManagerId(Operator.BEGIN_WITH, managerId);
    }
    public SalesTerritoryRequest<T> withManagerIdContaining(String managerId){
       return withManagerId(Operator.CONTAIN, managerId);
    }

    public SalesTerritoryRequest<T> withManagerIdEndingWith(String managerId){
       return withManagerId(Operator.END_WITH, managerId);
    }

    public SalesTerritoryRequest<T> withManagerIdIs(String managerId){
       return withManagerId(Operator.EQUAL, managerId);
    }

    public SalesTerritoryRequest<T> withManagerIdSoundingLike(String managerId){
       return withManagerId(Operator.SOUNDS_LIKE, managerId);
    }



    public SalesTerritoryRequest<T> filterByRegion(String... region){
      if (region == null || region.length == 0) {
        throw new IllegalArgumentException("filterByRegion parameter region cannot be empty");
      }
      return appendSearchCriteria(createRegionCriteria(Operator.EQUAL, (Object[])region));
    }

    public SalesTerritoryRequest<T> withRegion(Operator operator, Object... values){
       return appendSearchCriteria(createRegionCriteria(operator, values));
    }

    public SalesTerritoryRequest<T> withRegionIsUnknown(){
       return withRegion(Operator.IS_NULL);
    }

    public SalesTerritoryRequest<T> withRegionIsKnown(){
       return withRegion(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createRegionCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(SalesTerritory.REGION_PROPERTY, operator, values);
    }

    public SalesTerritoryRequest<T> withRegionGreaterThan(String region){
       return withRegion(Operator.GREATER_THAN, region);
    }

    public SalesTerritoryRequest<T> withRegionGreaterThanOrEqualTo(String region){
       return withRegion(Operator.GREATER_THAN_OR_EQUAL, region);
    }

    public SalesTerritoryRequest<T> withRegionLessThan(String region){
       return withRegion(Operator.LESS_THAN, region);
    }

    public SalesTerritoryRequest<T> withRegionLessThanOrEqualTo(String region){
       return withRegion(Operator.LESS_THAN_OR_EQUAL, region);
    }

    public SalesTerritoryRequest<T> withRegionBetween(String startOfRegion, String endOfRegion){
       return withRegion(Operator.BETWEEN, startOfRegion, endOfRegion);
    }
    public SalesTerritoryRequest<T> withRegionStartingWith(String region){
       return withRegion(Operator.BEGIN_WITH, region);
    }
    public SalesTerritoryRequest<T> withRegionContaining(String region){
       return withRegion(Operator.CONTAIN, region);
    }

    public SalesTerritoryRequest<T> withRegionEndingWith(String region){
       return withRegion(Operator.END_WITH, region);
    }

    public SalesTerritoryRequest<T> withRegionIs(String region){
       return withRegion(Operator.EQUAL, region);
    }

    public SalesTerritoryRequest<T> withRegionSoundingLike(String region){
       return withRegion(Operator.SOUNDS_LIKE, region);
    }



    public SalesTerritoryRequest<T> filterByCreateTime(LocalDateTime... createTime){
      if (createTime == null || createTime.length == 0) {
        throw new IllegalArgumentException("filterByCreateTime parameter createTime cannot be empty");
      }
      return appendSearchCriteria(createCreateTimeCriteria(Operator.EQUAL, (Object[])createTime));
    }

    public SalesTerritoryRequest<T> withCreateTime(Operator operator, Object... values){
       return appendSearchCriteria(createCreateTimeCriteria(operator, values));
    }

    public SalesTerritoryRequest<T> withCreateTimeIsUnknown(){
       return withCreateTime(Operator.IS_NULL);
    }

    public SalesTerritoryRequest<T> withCreateTimeIsKnown(){
       return withCreateTime(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createCreateTimeCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(SalesTerritory.CREATE_TIME_PROPERTY, operator, values);
    }

    public SalesTerritoryRequest<T> withCreateTimeGreaterThan(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public SalesTerritoryRequest<T> withCreateTimeGreaterThanOrEqualTo(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN_OR_EQUAL, createTime);
    }

    public SalesTerritoryRequest<T> withCreateTimeLessThan(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public SalesTerritoryRequest<T> withCreateTimeLessThanOrEqualTo(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN_OR_EQUAL, createTime);
    }

    public SalesTerritoryRequest<T> withCreateTimeBetween(LocalDateTime startOfCreateTime, LocalDateTime endOfCreateTime){
       return withCreateTime(Operator.BETWEEN, startOfCreateTime, endOfCreateTime);
    }
    public SalesTerritoryRequest<T> withCreateTimeBefore(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public SalesTerritoryRequest<T> withCreateTimeBefore(Date createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public SalesTerritoryRequest<T> withCreateTimeAfter(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public SalesTerritoryRequest<T> withCreateTimeAfter(Date createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public SalesTerritoryRequest<T> withCreateTimeBetween(Date startOfCreateTime, Date endOfCreateTime){
       return withCreateTime(Operator.BETWEEN, startOfCreateTime, endOfCreateTime);
    }




    public SalesTerritoryRequest<T> filterByUpdateTime(LocalDateTime... updateTime){
      if (updateTime == null || updateTime.length == 0) {
        throw new IllegalArgumentException("filterByUpdateTime parameter updateTime cannot be empty");
      }
      return appendSearchCriteria(createUpdateTimeCriteria(Operator.EQUAL, (Object[])updateTime));
    }

    public SalesTerritoryRequest<T> withUpdateTime(Operator operator, Object... values){
       return appendSearchCriteria(createUpdateTimeCriteria(operator, values));
    }

    public SalesTerritoryRequest<T> withUpdateTimeIsUnknown(){
       return withUpdateTime(Operator.IS_NULL);
    }

    public SalesTerritoryRequest<T> withUpdateTimeIsKnown(){
       return withUpdateTime(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createUpdateTimeCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(SalesTerritory.UPDATE_TIME_PROPERTY, operator, values);
    }

    public SalesTerritoryRequest<T> withUpdateTimeGreaterThan(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public SalesTerritoryRequest<T> withUpdateTimeGreaterThanOrEqualTo(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN_OR_EQUAL, updateTime);
    }

    public SalesTerritoryRequest<T> withUpdateTimeLessThan(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public SalesTerritoryRequest<T> withUpdateTimeLessThanOrEqualTo(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN_OR_EQUAL, updateTime);
    }

    public SalesTerritoryRequest<T> withUpdateTimeBetween(LocalDateTime startOfUpdateTime, LocalDateTime endOfUpdateTime){
       return withUpdateTime(Operator.BETWEEN, startOfUpdateTime, endOfUpdateTime);
    }
    public SalesTerritoryRequest<T> withUpdateTimeBefore(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public SalesTerritoryRequest<T> withUpdateTimeBefore(Date updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public SalesTerritoryRequest<T> withUpdateTimeAfter(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public SalesTerritoryRequest<T> withUpdateTimeAfter(Date updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public SalesTerritoryRequest<T> withUpdateTimeBetween(Date startOfUpdateTime, Date endOfUpdateTime){
       return withUpdateTime(Operator.BETWEEN, startOfUpdateTime, endOfUpdateTime);
    }




    public SalesTerritoryRequest<T> filterByVersion(Long... version){
      if (version == null || version.length == 0) {
        throw new IllegalArgumentException("filterByVersion parameter version cannot be empty");
      }
      return appendSearchCriteria(createVersionCriteria(Operator.EQUAL, (Object[])version));
    }

    public SalesTerritoryRequest<T> withVersion(Operator operator, Object... values){
       return appendSearchCriteria(createVersionCriteria(operator, values));
    }

    public SalesTerritoryRequest<T> withVersionIsUnknown(){
       return withVersion(Operator.IS_NULL);
    }

    public SalesTerritoryRequest<T> withVersionIsKnown(){
       return withVersion(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createVersionCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(SalesTerritory.VERSION_PROPERTY, operator, values);
    }

    public SalesTerritoryRequest<T> withVersionGreaterThan(Long version){
       return withVersion(Operator.GREATER_THAN, version);
    }

    public SalesTerritoryRequest<T> withVersionGreaterThanOrEqualTo(Long version){
       return withVersion(Operator.GREATER_THAN_OR_EQUAL, version);
    }

    public SalesTerritoryRequest<T> withVersionLessThan(Long version){
       return withVersion(Operator.LESS_THAN, version);
    }

    public SalesTerritoryRequest<T> withVersionLessThanOrEqualTo(Long version){
       return withVersion(Operator.LESS_THAN_OR_EQUAL, version);
    }

    public SalesTerritoryRequest<T> withVersionBetween(Long startOfVersion, Long endOfVersion){
       return withVersion(Operator.BETWEEN, startOfVersion, endOfVersion);
    }


    public SalesTerritoryRequest<T> count(){
        super.count();
        return this;
    }
    public SalesTerritoryRequest<T> countAs(String retName){
        super.count(retName);
        return this;
    }

    public SalesTerritoryRequest<T> groupById(){
       groupBy(SalesTerritory.ID_PROPERTY);
       return this;
    }

    public SalesTerritoryRequest<T> groupByIdAs(String retName){
       groupBy(retName, SalesTerritory.ID_PROPERTY);
       return this;
    }

    public SalesTerritoryRequest<T> groupByIdWithFunction(String retName, AggrFunction function){
       groupBy(retName, SalesTerritory.ID_PROPERTY, function);
       return this;
    }

    public SalesTerritoryRequest<T> groupByName(){
       groupBy(SalesTerritory.NAME_PROPERTY);
       return this;
    }

    public SalesTerritoryRequest<T> groupByNameAs(String retName){
       groupBy(retName, SalesTerritory.NAME_PROPERTY);
       return this;
    }

    public SalesTerritoryRequest<T> groupByNameWithFunction(String retName, AggrFunction function){
       groupBy(retName, SalesTerritory.NAME_PROPERTY, function);
       return this;
    }

    public SalesTerritoryRequest<T> groupByManagerId(){
       groupBy(SalesTerritory.MANAGER_ID_PROPERTY);
       return this;
    }

    public SalesTerritoryRequest<T> groupByManagerIdAs(String retName){
       groupBy(retName, SalesTerritory.MANAGER_ID_PROPERTY);
       return this;
    }

    public SalesTerritoryRequest<T> groupByManagerIdWithFunction(String retName, AggrFunction function){
       groupBy(retName, SalesTerritory.MANAGER_ID_PROPERTY, function);
       return this;
    }

    public SalesTerritoryRequest<T> groupByRegion(){
       groupBy(SalesTerritory.REGION_PROPERTY);
       return this;
    }

    public SalesTerritoryRequest<T> groupByRegionAs(String retName){
       groupBy(retName, SalesTerritory.REGION_PROPERTY);
       return this;
    }

    public SalesTerritoryRequest<T> groupByRegionWithFunction(String retName, AggrFunction function){
       groupBy(retName, SalesTerritory.REGION_PROPERTY, function);
       return this;
    }

    public SalesTerritoryRequest<T> groupByCreateTime(){
       groupBy(SalesTerritory.CREATE_TIME_PROPERTY);
       return this;
    }

    public SalesTerritoryRequest<T> groupByCreateTimeAs(String retName){
       groupBy(retName, SalesTerritory.CREATE_TIME_PROPERTY);
       return this;
    }

    public SalesTerritoryRequest<T> groupByCreateTimeWithFunction(String retName, AggrFunction function){
       groupBy(retName, SalesTerritory.CREATE_TIME_PROPERTY, function);
       return this;
    }

    public SalesTerritoryRequest<T> groupByUpdateTime(){
       groupBy(SalesTerritory.UPDATE_TIME_PROPERTY);
       return this;
    }

    public SalesTerritoryRequest<T> groupByUpdateTimeAs(String retName){
       groupBy(retName, SalesTerritory.UPDATE_TIME_PROPERTY);
       return this;
    }

    public SalesTerritoryRequest<T> groupByUpdateTimeWithFunction(String retName, AggrFunction function){
       groupBy(retName, SalesTerritory.UPDATE_TIME_PROPERTY, function);
       return this;
    }

    public SalesTerritoryRequest<T> groupByVersion(){
       groupBy(SalesTerritory.VERSION_PROPERTY);
       return this;
    }

    public SalesTerritoryRequest<T> groupByVersionAs(String retName){
       groupBy(retName, SalesTerritory.VERSION_PROPERTY);
       return this;
    }

    public SalesTerritoryRequest<T> groupByVersionWithFunction(String retName, AggrFunction function){
       groupBy(retName, SalesTerritory.VERSION_PROPERTY, function);
       return this;
    }



    public SalesTerritoryRequest<T> orderByIdAscending(){
       addOrderByAscending(SalesTerritory.ID_PROPERTY);
       return this;
    }

    public SalesTerritoryRequest<T> orderByIdDescending(){
       addOrderByDescending(SalesTerritory.ID_PROPERTY);
       return this;
    }

    public SalesTerritoryRequest<T> orderByNameAscending(){
       addOrderByAscending(SalesTerritory.NAME_PROPERTY);
       return this;
    }

    public SalesTerritoryRequest<T> orderByNameDescending(){
       addOrderByDescending(SalesTerritory.NAME_PROPERTY);
       return this;
    }
    public SalesTerritoryRequest<T> orderByNameAscendingUsingGBK(){
       addOrderByAscendingUsingGBK(SalesTerritory.NAME_PROPERTY);
       return this;
    }

    public SalesTerritoryRequest<T> orderByNameDescendingUsingGBK(){
       addOrderByDescendingUsingGBK(SalesTerritory.NAME_PROPERTY);
       return this;
    }
    public SalesTerritoryRequest<T> orderByManagerIdAscending(){
       addOrderByAscending(SalesTerritory.MANAGER_ID_PROPERTY);
       return this;
    }

    public SalesTerritoryRequest<T> orderByManagerIdDescending(){
       addOrderByDescending(SalesTerritory.MANAGER_ID_PROPERTY);
       return this;
    }
    public SalesTerritoryRequest<T> orderByManagerIdAscendingUsingGBK(){
       addOrderByAscendingUsingGBK(SalesTerritory.MANAGER_ID_PROPERTY);
       return this;
    }

    public SalesTerritoryRequest<T> orderByManagerIdDescendingUsingGBK(){
       addOrderByDescendingUsingGBK(SalesTerritory.MANAGER_ID_PROPERTY);
       return this;
    }
    public SalesTerritoryRequest<T> orderByRegionAscending(){
       addOrderByAscending(SalesTerritory.REGION_PROPERTY);
       return this;
    }

    public SalesTerritoryRequest<T> orderByRegionDescending(){
       addOrderByDescending(SalesTerritory.REGION_PROPERTY);
       return this;
    }
    public SalesTerritoryRequest<T> orderByRegionAscendingUsingGBK(){
       addOrderByAscendingUsingGBK(SalesTerritory.REGION_PROPERTY);
       return this;
    }

    public SalesTerritoryRequest<T> orderByRegionDescendingUsingGBK(){
       addOrderByDescendingUsingGBK(SalesTerritory.REGION_PROPERTY);
       return this;
    }
    public SalesTerritoryRequest<T> orderByCreateTimeAscending(){
       addOrderByAscending(SalesTerritory.CREATE_TIME_PROPERTY);
       return this;
    }

    public SalesTerritoryRequest<T> orderByCreateTimeDescending(){
       addOrderByDescending(SalesTerritory.CREATE_TIME_PROPERTY);
       return this;
    }

    public SalesTerritoryRequest<T> orderByUpdateTimeAscending(){
       addOrderByAscending(SalesTerritory.UPDATE_TIME_PROPERTY);
       return this;
    }

    public SalesTerritoryRequest<T> orderByUpdateTimeDescending(){
       addOrderByDescending(SalesTerritory.UPDATE_TIME_PROPERTY);
       return this;
    }

    public SalesTerritoryRequest<T> orderByVersionAscending(){
       addOrderByAscending(SalesTerritory.VERSION_PROPERTY);
       return this;
    }

    public SalesTerritoryRequest<T> orderByVersionDescending(){
       addOrderByDescending(SalesTerritory.VERSION_PROPERTY);
       return this;
    }





    /**
     * get topN records
     * @param topN  records number
     */
    public SalesTerritoryRequest<T> top(int topN) {
        super.top(topN);
        return this;
    }

    /**
     * get records from offset(inclusive) to offset+size(exclusive)
     * @param offset record offset
     * @param size records number
     */
    public SalesTerritoryRequest<T> offset(int offset, int size) {
        super.offset(offset, size);
        return this;
    }

    /**
     * retrieve all records
     */
    public SalesTerritoryRequest<T> unlimited() {
        super.unlimited();
        return this;
    }

    /**
     * get records of one page
     * @param pageNumber page number(1-based)
     * @param pageSize page size
     */
    public SalesTerritoryRequest<T> page(int pageNumber, int pageSize) {
        int offset = (pageNumber - 1) * pageSize;
        return offset(offset, pageSize);
   }

    /**
     * get records of one page, default page size is 10
     * @param pageNumber page number(1-based)
     */
    public SalesTerritoryRequest<T> page(int pageNumber) {
        return page(pageNumber, 10);
   }
}