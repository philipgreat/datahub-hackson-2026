
package com.example.enterpriseerpsystem.catalog;

import io.teaql.core.AggrFunction;
import io.teaql.core.BaseRequest;
import io.teaql.core.PropertyReference;
import io.teaql.core.SearchCriteria;
import io.teaql.core.criteria.Operator;
import io.teaql.core.criteria.TwoOperatorCriteria;
import java.time.LocalDateTime;
import java.util.Date;

public class CatalogRequest<T extends Catalog> extends BaseRequest<T> {

    /**
     * @deprecated AI agents and business code must use the generated Q facade
     *             instead of constructing request builders directly.
     */
    @Deprecated
    public CatalogRequest(Class<T> returnType){
        super(returnType);
        selectId();
        selectVersion();
    }

    public CatalogRequest<T> comment(String comment){
         super.internalComment(comment);
         return this;
    }

    // purpose() 继承自 BaseRequest，返回 ExecutableRequest（终结方法）

    public CatalogRequest<T> returnType(Class<? extends T> returnType){
        super.setReturnType(returnType);
        return this;
    }

    public CatalogRequest<T> enableAggregationCache(long cacheExpiredMillis){
        super.enableAggregationCache();
        super.aggregateCacheTime(cacheExpiredMillis);
        return this;
    }

    public CatalogRequest<T> enableAggregationCache(){
        return enableAggregationCache(0l);
    }


    public CatalogRequest<T> propagateAggregationCache(long cacheExpiredMillis){
        super.propagateAggregationCache(cacheExpiredMillis);
        return this;
    }

    public CatalogRequest<T> appendSearchCriteria(SearchCriteria searchCriteria){
        return (CatalogRequest<T>)super.appendSearchCriteria(searchCriteria);
    }

    public CatalogRequest<T> filter(String property1, Operator operator, String property2){
        return appendSearchCriteria(new TwoOperatorCriteria(operator, new PropertyReference(property1), new PropertyReference(property2)));
    }


    public CatalogRequest<T> matchingAnyOf(CatalogRequest catalog){
        super.internalMatchAny(catalog);
        return this;
    }

    public CatalogRequest<T> enhanceChildrenIfNeeded(){
        return this;
    }

    public CatalogRequest<T> withDeletedRows(){
        super.withDeletedRows();
        return this;
    }

    public CatalogRequest<T> deletedRowsOnly(){
        super.deletedRowsOnly();
        return this;
    }

    public CatalogRequest<T> selectSelf(){
        super.selectSelf();
        return selectId().selectName().selectSeason().selectValidFrom().selectValidTo().selectCreateTime().selectUpdateTime().selectVersion();
    }

    public CatalogRequest<T> selectSelfFields(){
        return selectSelf();
    }

    public CatalogRequest<T> selectAll(){
        super.selectAll();
        return selectId().selectName().selectSeason().selectValidFrom().selectValidTo().selectCreateTime().selectUpdateTime().selectVersion();
    }

    public CatalogRequest<T> selectChildren(){
        super.selectAny();
        return selectId().selectName().selectSeason().selectValidFrom().selectValidTo().selectCreateTime().selectUpdateTime().selectVersion();
    }


    public CatalogRequest<T> selectId(){
       selectProperty(Catalog.ID_PROPERTY);
       return this;
    }

    /**
     * fill the id with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  id) to fetch id property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public CatalogRequest<T> unselectId(){
       unselectProperty(Catalog.ID_PROPERTY);
       return this;
    }
    public CatalogRequest<T> selectName(){
       selectProperty(Catalog.NAME_PROPERTY);
       return this;
    }

    /**
     * fill the name with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  name) to fetch name property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public CatalogRequest<T> unselectName(){
       unselectProperty(Catalog.NAME_PROPERTY);
       return this;
    }
    public CatalogRequest<T> selectSeason(){
       selectProperty(Catalog.SEASON_PROPERTY);
       return this;
    }

    /**
     * fill the season with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  season) to fetch season property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public CatalogRequest<T> unselectSeason(){
       unselectProperty(Catalog.SEASON_PROPERTY);
       return this;
    }
    public CatalogRequest<T> selectValidFrom(){
       selectProperty(Catalog.VALID_FROM_PROPERTY);
       return this;
    }

    /**
     * fill the validFrom with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  validFrom) to fetch validFrom property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public CatalogRequest<T> unselectValidFrom(){
       unselectProperty(Catalog.VALID_FROM_PROPERTY);
       return this;
    }
    public CatalogRequest<T> selectValidTo(){
       selectProperty(Catalog.VALID_TO_PROPERTY);
       return this;
    }

    /**
     * fill the validTo with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  validTo) to fetch validTo property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public CatalogRequest<T> unselectValidTo(){
       unselectProperty(Catalog.VALID_TO_PROPERTY);
       return this;
    }
    public CatalogRequest<T> selectCreateTime(){
       selectProperty(Catalog.CREATE_TIME_PROPERTY);
       return this;
    }

    /**
     * fill the createTime with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  createTime) to fetch createTime property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public CatalogRequest<T> unselectCreateTime(){
       unselectProperty(Catalog.CREATE_TIME_PROPERTY);
       return this;
    }
    public CatalogRequest<T> selectUpdateTime(){
       selectProperty(Catalog.UPDATE_TIME_PROPERTY);
       return this;
    }

    /**
     * fill the updateTime with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  updateTime) to fetch updateTime property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public CatalogRequest<T> unselectUpdateTime(){
       unselectProperty(Catalog.UPDATE_TIME_PROPERTY);
       return this;
    }
    public CatalogRequest<T> selectVersion(){
       selectProperty(Catalog.VERSION_PROPERTY);
       return this;
    }

    /**
     * fill the version with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  version) to fetch version property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public CatalogRequest<T> unselectVersion(){
       unselectProperty(Catalog.VERSION_PROPERTY);
       return this;
    }

    public CatalogRequest<T> withId(Operator operator, Object... values){
       return appendSearchCriteria(createIdCriteria(operator, values));
    }

    public SearchCriteria createIdCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Catalog.ID_PROPERTY, operator, values);
    }

    public CatalogRequest<T> withIdIs(Long id){
       return withId(Operator.EQUAL, id);
    }
    public CatalogRequest<T> withIdIn(Long... id){
       return withId(Operator.EQUAL, (Object[])id);
    }



    public CatalogRequest<T> filterByName(String... name){
      if (name == null || name.length == 0) {
        throw new IllegalArgumentException("filterByName parameter name cannot be empty");
      }
      return appendSearchCriteria(createNameCriteria(Operator.EQUAL, (Object[])name));
    }

    public CatalogRequest<T> withName(Operator operator, Object... values){
       return appendSearchCriteria(createNameCriteria(operator, values));
    }

    public CatalogRequest<T> withNameIsUnknown(){
       return withName(Operator.IS_NULL);
    }

    public CatalogRequest<T> withNameIsKnown(){
       return withName(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createNameCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Catalog.NAME_PROPERTY, operator, values);
    }

    public CatalogRequest<T> withNameGreaterThan(String name){
       return withName(Operator.GREATER_THAN, name);
    }

    public CatalogRequest<T> withNameGreaterThanOrEqualTo(String name){
       return withName(Operator.GREATER_THAN_OR_EQUAL, name);
    }

    public CatalogRequest<T> withNameLessThan(String name){
       return withName(Operator.LESS_THAN, name);
    }

    public CatalogRequest<T> withNameLessThanOrEqualTo(String name){
       return withName(Operator.LESS_THAN_OR_EQUAL, name);
    }

    public CatalogRequest<T> withNameBetween(String startOfName, String endOfName){
       return withName(Operator.BETWEEN, startOfName, endOfName);
    }
    public CatalogRequest<T> withNameStartingWith(String name){
       return withName(Operator.BEGIN_WITH, name);
    }
    public CatalogRequest<T> withNameContaining(String name){
       return withName(Operator.CONTAIN, name);
    }

    public CatalogRequest<T> withNameEndingWith(String name){
       return withName(Operator.END_WITH, name);
    }

    public CatalogRequest<T> withNameIs(String name){
       return withName(Operator.EQUAL, name);
    }

    public CatalogRequest<T> withNameSoundingLike(String name){
       return withName(Operator.SOUNDS_LIKE, name);
    }



    public CatalogRequest<T> filterBySeason(String... season){
      if (season == null || season.length == 0) {
        throw new IllegalArgumentException("filterBySeason parameter season cannot be empty");
      }
      return appendSearchCriteria(createSeasonCriteria(Operator.EQUAL, (Object[])season));
    }

    public CatalogRequest<T> withSeason(Operator operator, Object... values){
       return appendSearchCriteria(createSeasonCriteria(operator, values));
    }

    public CatalogRequest<T> withSeasonIsUnknown(){
       return withSeason(Operator.IS_NULL);
    }

    public CatalogRequest<T> withSeasonIsKnown(){
       return withSeason(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createSeasonCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Catalog.SEASON_PROPERTY, operator, values);
    }

    public CatalogRequest<T> withSeasonGreaterThan(String season){
       return withSeason(Operator.GREATER_THAN, season);
    }

    public CatalogRequest<T> withSeasonGreaterThanOrEqualTo(String season){
       return withSeason(Operator.GREATER_THAN_OR_EQUAL, season);
    }

    public CatalogRequest<T> withSeasonLessThan(String season){
       return withSeason(Operator.LESS_THAN, season);
    }

    public CatalogRequest<T> withSeasonLessThanOrEqualTo(String season){
       return withSeason(Operator.LESS_THAN_OR_EQUAL, season);
    }

    public CatalogRequest<T> withSeasonBetween(String startOfSeason, String endOfSeason){
       return withSeason(Operator.BETWEEN, startOfSeason, endOfSeason);
    }
    public CatalogRequest<T> withSeasonStartingWith(String season){
       return withSeason(Operator.BEGIN_WITH, season);
    }
    public CatalogRequest<T> withSeasonContaining(String season){
       return withSeason(Operator.CONTAIN, season);
    }

    public CatalogRequest<T> withSeasonEndingWith(String season){
       return withSeason(Operator.END_WITH, season);
    }

    public CatalogRequest<T> withSeasonIs(String season){
       return withSeason(Operator.EQUAL, season);
    }

    public CatalogRequest<T> withSeasonSoundingLike(String season){
       return withSeason(Operator.SOUNDS_LIKE, season);
    }



    public CatalogRequest<T> filterByValidFrom(LocalDateTime... validFrom){
      if (validFrom == null || validFrom.length == 0) {
        throw new IllegalArgumentException("filterByValidFrom parameter validFrom cannot be empty");
      }
      return appendSearchCriteria(createValidFromCriteria(Operator.EQUAL, (Object[])validFrom));
    }

    public CatalogRequest<T> withValidFrom(Operator operator, Object... values){
       return appendSearchCriteria(createValidFromCriteria(operator, values));
    }

    public CatalogRequest<T> withValidFromIsUnknown(){
       return withValidFrom(Operator.IS_NULL);
    }

    public CatalogRequest<T> withValidFromIsKnown(){
       return withValidFrom(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createValidFromCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Catalog.VALID_FROM_PROPERTY, operator, values);
    }

    public CatalogRequest<T> withValidFromGreaterThan(LocalDateTime validFrom){
       return withValidFrom(Operator.GREATER_THAN, validFrom);
    }

    public CatalogRequest<T> withValidFromGreaterThanOrEqualTo(LocalDateTime validFrom){
       return withValidFrom(Operator.GREATER_THAN_OR_EQUAL, validFrom);
    }

    public CatalogRequest<T> withValidFromLessThan(LocalDateTime validFrom){
       return withValidFrom(Operator.LESS_THAN, validFrom);
    }

    public CatalogRequest<T> withValidFromLessThanOrEqualTo(LocalDateTime validFrom){
       return withValidFrom(Operator.LESS_THAN_OR_EQUAL, validFrom);
    }

    public CatalogRequest<T> withValidFromBetween(LocalDateTime startOfValidFrom, LocalDateTime endOfValidFrom){
       return withValidFrom(Operator.BETWEEN, startOfValidFrom, endOfValidFrom);
    }
    public CatalogRequest<T> withValidFromBefore(LocalDateTime validFrom){
       return withValidFrom(Operator.LESS_THAN, validFrom);
    }

    public CatalogRequest<T> withValidFromBefore(Date validFrom){
       return withValidFrom(Operator.LESS_THAN, validFrom);
    }

    public CatalogRequest<T> withValidFromAfter(LocalDateTime validFrom){
       return withValidFrom(Operator.GREATER_THAN, validFrom);
    }

    public CatalogRequest<T> withValidFromAfter(Date validFrom){
       return withValidFrom(Operator.GREATER_THAN, validFrom);
    }

    public CatalogRequest<T> withValidFromBetween(Date startOfValidFrom, Date endOfValidFrom){
       return withValidFrom(Operator.BETWEEN, startOfValidFrom, endOfValidFrom);
    }




    public CatalogRequest<T> filterByValidTo(LocalDateTime... validTo){
      if (validTo == null || validTo.length == 0) {
        throw new IllegalArgumentException("filterByValidTo parameter validTo cannot be empty");
      }
      return appendSearchCriteria(createValidToCriteria(Operator.EQUAL, (Object[])validTo));
    }

    public CatalogRequest<T> withValidTo(Operator operator, Object... values){
       return appendSearchCriteria(createValidToCriteria(operator, values));
    }

    public CatalogRequest<T> withValidToIsUnknown(){
       return withValidTo(Operator.IS_NULL);
    }

    public CatalogRequest<T> withValidToIsKnown(){
       return withValidTo(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createValidToCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Catalog.VALID_TO_PROPERTY, operator, values);
    }

    public CatalogRequest<T> withValidToGreaterThan(LocalDateTime validTo){
       return withValidTo(Operator.GREATER_THAN, validTo);
    }

    public CatalogRequest<T> withValidToGreaterThanOrEqualTo(LocalDateTime validTo){
       return withValidTo(Operator.GREATER_THAN_OR_EQUAL, validTo);
    }

    public CatalogRequest<T> withValidToLessThan(LocalDateTime validTo){
       return withValidTo(Operator.LESS_THAN, validTo);
    }

    public CatalogRequest<T> withValidToLessThanOrEqualTo(LocalDateTime validTo){
       return withValidTo(Operator.LESS_THAN_OR_EQUAL, validTo);
    }

    public CatalogRequest<T> withValidToBetween(LocalDateTime startOfValidTo, LocalDateTime endOfValidTo){
       return withValidTo(Operator.BETWEEN, startOfValidTo, endOfValidTo);
    }
    public CatalogRequest<T> withValidToBefore(LocalDateTime validTo){
       return withValidTo(Operator.LESS_THAN, validTo);
    }

    public CatalogRequest<T> withValidToBefore(Date validTo){
       return withValidTo(Operator.LESS_THAN, validTo);
    }

    public CatalogRequest<T> withValidToAfter(LocalDateTime validTo){
       return withValidTo(Operator.GREATER_THAN, validTo);
    }

    public CatalogRequest<T> withValidToAfter(Date validTo){
       return withValidTo(Operator.GREATER_THAN, validTo);
    }

    public CatalogRequest<T> withValidToBetween(Date startOfValidTo, Date endOfValidTo){
       return withValidTo(Operator.BETWEEN, startOfValidTo, endOfValidTo);
    }




    public CatalogRequest<T> filterByCreateTime(LocalDateTime... createTime){
      if (createTime == null || createTime.length == 0) {
        throw new IllegalArgumentException("filterByCreateTime parameter createTime cannot be empty");
      }
      return appendSearchCriteria(createCreateTimeCriteria(Operator.EQUAL, (Object[])createTime));
    }

    public CatalogRequest<T> withCreateTime(Operator operator, Object... values){
       return appendSearchCriteria(createCreateTimeCriteria(operator, values));
    }

    public CatalogRequest<T> withCreateTimeIsUnknown(){
       return withCreateTime(Operator.IS_NULL);
    }

    public CatalogRequest<T> withCreateTimeIsKnown(){
       return withCreateTime(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createCreateTimeCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Catalog.CREATE_TIME_PROPERTY, operator, values);
    }

    public CatalogRequest<T> withCreateTimeGreaterThan(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public CatalogRequest<T> withCreateTimeGreaterThanOrEqualTo(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN_OR_EQUAL, createTime);
    }

    public CatalogRequest<T> withCreateTimeLessThan(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public CatalogRequest<T> withCreateTimeLessThanOrEqualTo(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN_OR_EQUAL, createTime);
    }

    public CatalogRequest<T> withCreateTimeBetween(LocalDateTime startOfCreateTime, LocalDateTime endOfCreateTime){
       return withCreateTime(Operator.BETWEEN, startOfCreateTime, endOfCreateTime);
    }
    public CatalogRequest<T> withCreateTimeBefore(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public CatalogRequest<T> withCreateTimeBefore(Date createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public CatalogRequest<T> withCreateTimeAfter(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public CatalogRequest<T> withCreateTimeAfter(Date createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public CatalogRequest<T> withCreateTimeBetween(Date startOfCreateTime, Date endOfCreateTime){
       return withCreateTime(Operator.BETWEEN, startOfCreateTime, endOfCreateTime);
    }




    public CatalogRequest<T> filterByUpdateTime(LocalDateTime... updateTime){
      if (updateTime == null || updateTime.length == 0) {
        throw new IllegalArgumentException("filterByUpdateTime parameter updateTime cannot be empty");
      }
      return appendSearchCriteria(createUpdateTimeCriteria(Operator.EQUAL, (Object[])updateTime));
    }

    public CatalogRequest<T> withUpdateTime(Operator operator, Object... values){
       return appendSearchCriteria(createUpdateTimeCriteria(operator, values));
    }

    public CatalogRequest<T> withUpdateTimeIsUnknown(){
       return withUpdateTime(Operator.IS_NULL);
    }

    public CatalogRequest<T> withUpdateTimeIsKnown(){
       return withUpdateTime(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createUpdateTimeCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Catalog.UPDATE_TIME_PROPERTY, operator, values);
    }

    public CatalogRequest<T> withUpdateTimeGreaterThan(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public CatalogRequest<T> withUpdateTimeGreaterThanOrEqualTo(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN_OR_EQUAL, updateTime);
    }

    public CatalogRequest<T> withUpdateTimeLessThan(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public CatalogRequest<T> withUpdateTimeLessThanOrEqualTo(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN_OR_EQUAL, updateTime);
    }

    public CatalogRequest<T> withUpdateTimeBetween(LocalDateTime startOfUpdateTime, LocalDateTime endOfUpdateTime){
       return withUpdateTime(Operator.BETWEEN, startOfUpdateTime, endOfUpdateTime);
    }
    public CatalogRequest<T> withUpdateTimeBefore(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public CatalogRequest<T> withUpdateTimeBefore(Date updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public CatalogRequest<T> withUpdateTimeAfter(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public CatalogRequest<T> withUpdateTimeAfter(Date updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public CatalogRequest<T> withUpdateTimeBetween(Date startOfUpdateTime, Date endOfUpdateTime){
       return withUpdateTime(Operator.BETWEEN, startOfUpdateTime, endOfUpdateTime);
    }




    public CatalogRequest<T> filterByVersion(Long... version){
      if (version == null || version.length == 0) {
        throw new IllegalArgumentException("filterByVersion parameter version cannot be empty");
      }
      return appendSearchCriteria(createVersionCriteria(Operator.EQUAL, (Object[])version));
    }

    public CatalogRequest<T> withVersion(Operator operator, Object... values){
       return appendSearchCriteria(createVersionCriteria(operator, values));
    }

    public CatalogRequest<T> withVersionIsUnknown(){
       return withVersion(Operator.IS_NULL);
    }

    public CatalogRequest<T> withVersionIsKnown(){
       return withVersion(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createVersionCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Catalog.VERSION_PROPERTY, operator, values);
    }

    public CatalogRequest<T> withVersionGreaterThan(Long version){
       return withVersion(Operator.GREATER_THAN, version);
    }

    public CatalogRequest<T> withVersionGreaterThanOrEqualTo(Long version){
       return withVersion(Operator.GREATER_THAN_OR_EQUAL, version);
    }

    public CatalogRequest<T> withVersionLessThan(Long version){
       return withVersion(Operator.LESS_THAN, version);
    }

    public CatalogRequest<T> withVersionLessThanOrEqualTo(Long version){
       return withVersion(Operator.LESS_THAN_OR_EQUAL, version);
    }

    public CatalogRequest<T> withVersionBetween(Long startOfVersion, Long endOfVersion){
       return withVersion(Operator.BETWEEN, startOfVersion, endOfVersion);
    }


    public CatalogRequest<T> count(){
        super.count();
        return this;
    }
    public CatalogRequest<T> countAs(String retName){
        super.count(retName);
        return this;
    }

    public CatalogRequest<T> groupById(){
       groupBy(Catalog.ID_PROPERTY);
       return this;
    }

    public CatalogRequest<T> groupByIdAs(String retName){
       groupBy(retName, Catalog.ID_PROPERTY);
       return this;
    }

    public CatalogRequest<T> groupByIdWithFunction(String retName, AggrFunction function){
       groupBy(retName, Catalog.ID_PROPERTY, function);
       return this;
    }

    public CatalogRequest<T> groupByName(){
       groupBy(Catalog.NAME_PROPERTY);
       return this;
    }

    public CatalogRequest<T> groupByNameAs(String retName){
       groupBy(retName, Catalog.NAME_PROPERTY);
       return this;
    }

    public CatalogRequest<T> groupByNameWithFunction(String retName, AggrFunction function){
       groupBy(retName, Catalog.NAME_PROPERTY, function);
       return this;
    }

    public CatalogRequest<T> groupBySeason(){
       groupBy(Catalog.SEASON_PROPERTY);
       return this;
    }

    public CatalogRequest<T> groupBySeasonAs(String retName){
       groupBy(retName, Catalog.SEASON_PROPERTY);
       return this;
    }

    public CatalogRequest<T> groupBySeasonWithFunction(String retName, AggrFunction function){
       groupBy(retName, Catalog.SEASON_PROPERTY, function);
       return this;
    }

    public CatalogRequest<T> groupByValidFrom(){
       groupBy(Catalog.VALID_FROM_PROPERTY);
       return this;
    }

    public CatalogRequest<T> groupByValidFromAs(String retName){
       groupBy(retName, Catalog.VALID_FROM_PROPERTY);
       return this;
    }

    public CatalogRequest<T> groupByValidFromWithFunction(String retName, AggrFunction function){
       groupBy(retName, Catalog.VALID_FROM_PROPERTY, function);
       return this;
    }

    public CatalogRequest<T> groupByValidTo(){
       groupBy(Catalog.VALID_TO_PROPERTY);
       return this;
    }

    public CatalogRequest<T> groupByValidToAs(String retName){
       groupBy(retName, Catalog.VALID_TO_PROPERTY);
       return this;
    }

    public CatalogRequest<T> groupByValidToWithFunction(String retName, AggrFunction function){
       groupBy(retName, Catalog.VALID_TO_PROPERTY, function);
       return this;
    }

    public CatalogRequest<T> groupByCreateTime(){
       groupBy(Catalog.CREATE_TIME_PROPERTY);
       return this;
    }

    public CatalogRequest<T> groupByCreateTimeAs(String retName){
       groupBy(retName, Catalog.CREATE_TIME_PROPERTY);
       return this;
    }

    public CatalogRequest<T> groupByCreateTimeWithFunction(String retName, AggrFunction function){
       groupBy(retName, Catalog.CREATE_TIME_PROPERTY, function);
       return this;
    }

    public CatalogRequest<T> groupByUpdateTime(){
       groupBy(Catalog.UPDATE_TIME_PROPERTY);
       return this;
    }

    public CatalogRequest<T> groupByUpdateTimeAs(String retName){
       groupBy(retName, Catalog.UPDATE_TIME_PROPERTY);
       return this;
    }

    public CatalogRequest<T> groupByUpdateTimeWithFunction(String retName, AggrFunction function){
       groupBy(retName, Catalog.UPDATE_TIME_PROPERTY, function);
       return this;
    }

    public CatalogRequest<T> groupByVersion(){
       groupBy(Catalog.VERSION_PROPERTY);
       return this;
    }

    public CatalogRequest<T> groupByVersionAs(String retName){
       groupBy(retName, Catalog.VERSION_PROPERTY);
       return this;
    }

    public CatalogRequest<T> groupByVersionWithFunction(String retName, AggrFunction function){
       groupBy(retName, Catalog.VERSION_PROPERTY, function);
       return this;
    }



    public CatalogRequest<T> orderByIdAscending(){
       addOrderByAscending(Catalog.ID_PROPERTY);
       return this;
    }

    public CatalogRequest<T> orderByIdDescending(){
       addOrderByDescending(Catalog.ID_PROPERTY);
       return this;
    }

    public CatalogRequest<T> orderByNameAscending(){
       addOrderByAscending(Catalog.NAME_PROPERTY);
       return this;
    }

    public CatalogRequest<T> orderByNameDescending(){
       addOrderByDescending(Catalog.NAME_PROPERTY);
       return this;
    }
    public CatalogRequest<T> orderByNameAscendingUsingGBK(){
       addOrderByAscendingUsingGBK(Catalog.NAME_PROPERTY);
       return this;
    }

    public CatalogRequest<T> orderByNameDescendingUsingGBK(){
       addOrderByDescendingUsingGBK(Catalog.NAME_PROPERTY);
       return this;
    }
    public CatalogRequest<T> orderBySeasonAscending(){
       addOrderByAscending(Catalog.SEASON_PROPERTY);
       return this;
    }

    public CatalogRequest<T> orderBySeasonDescending(){
       addOrderByDescending(Catalog.SEASON_PROPERTY);
       return this;
    }
    public CatalogRequest<T> orderBySeasonAscendingUsingGBK(){
       addOrderByAscendingUsingGBK(Catalog.SEASON_PROPERTY);
       return this;
    }

    public CatalogRequest<T> orderBySeasonDescendingUsingGBK(){
       addOrderByDescendingUsingGBK(Catalog.SEASON_PROPERTY);
       return this;
    }
    public CatalogRequest<T> orderByValidFromAscending(){
       addOrderByAscending(Catalog.VALID_FROM_PROPERTY);
       return this;
    }

    public CatalogRequest<T> orderByValidFromDescending(){
       addOrderByDescending(Catalog.VALID_FROM_PROPERTY);
       return this;
    }

    public CatalogRequest<T> orderByValidToAscending(){
       addOrderByAscending(Catalog.VALID_TO_PROPERTY);
       return this;
    }

    public CatalogRequest<T> orderByValidToDescending(){
       addOrderByDescending(Catalog.VALID_TO_PROPERTY);
       return this;
    }

    public CatalogRequest<T> orderByCreateTimeAscending(){
       addOrderByAscending(Catalog.CREATE_TIME_PROPERTY);
       return this;
    }

    public CatalogRequest<T> orderByCreateTimeDescending(){
       addOrderByDescending(Catalog.CREATE_TIME_PROPERTY);
       return this;
    }

    public CatalogRequest<T> orderByUpdateTimeAscending(){
       addOrderByAscending(Catalog.UPDATE_TIME_PROPERTY);
       return this;
    }

    public CatalogRequest<T> orderByUpdateTimeDescending(){
       addOrderByDescending(Catalog.UPDATE_TIME_PROPERTY);
       return this;
    }

    public CatalogRequest<T> orderByVersionAscending(){
       addOrderByAscending(Catalog.VERSION_PROPERTY);
       return this;
    }

    public CatalogRequest<T> orderByVersionDescending(){
       addOrderByDescending(Catalog.VERSION_PROPERTY);
       return this;
    }





    /**
     * get topN records
     * @param topN  records number
     */
    public CatalogRequest<T> top(int topN) {
        super.top(topN);
        return this;
    }

    /**
     * get records from offset(inclusive) to offset+size(exclusive)
     * @param offset record offset
     * @param size records number
     */
    public CatalogRequest<T> offset(int offset, int size) {
        super.offset(offset, size);
        return this;
    }

    /**
     * retrieve all records
     */
    public CatalogRequest<T> unlimited() {
        super.unlimited();
        return this;
    }

    /**
     * get records of one page
     * @param pageNumber page number(1-based)
     * @param pageSize page size
     */
    public CatalogRequest<T> page(int pageNumber, int pageSize) {
        int offset = (pageNumber - 1) * pageSize;
        return offset(offset, pageSize);
   }

    /**
     * get records of one page, default page size is 10
     * @param pageNumber page number(1-based)
     */
    public CatalogRequest<T> page(int pageNumber) {
        return page(pageNumber, 10);
   }
}