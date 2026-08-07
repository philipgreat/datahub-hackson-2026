
package com.example.enterpriseerpsystem.employeereview;

import com.example.enterpriseerpsystem.Q;
import com.example.enterpriseerpsystem.employee.Employee;
import com.example.enterpriseerpsystem.employee.EmployeeRequest;
import io.teaql.core.AggrFunction;
import io.teaql.core.BaseRequest;
import io.teaql.core.PropertyReference;
import io.teaql.core.SearchCriteria;
import io.teaql.core.SubQuerySearchCriteria;
import io.teaql.core.criteria.Operator;
import io.teaql.core.criteria.TwoOperatorCriteria;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

public class EmployeeReviewRequest<T extends EmployeeReview> extends BaseRequest<T> {

    /**
     * @deprecated AI agents and business code must use the generated Q facade
     *             instead of constructing request builders directly.
     */
    @Deprecated
    public EmployeeReviewRequest(Class<T> returnType){
        super(returnType);
        selectId();
        selectVersion();
    }

    public EmployeeReviewRequest<T> comment(String comment){
         super.internalComment(comment);
         return this;
    }

    // purpose() 继承自 BaseRequest，返回 ExecutableRequest（终结方法）

    public EmployeeReviewRequest<T> returnType(Class<? extends T> returnType){
        super.setReturnType(returnType);
        return this;
    }

    public EmployeeReviewRequest<T> enableAggregationCache(long cacheExpiredMillis){
        super.enableAggregationCache();
        super.aggregateCacheTime(cacheExpiredMillis);
        return this;
    }

    public EmployeeReviewRequest<T> enableAggregationCache(){
        return enableAggregationCache(0l);
    }


    public EmployeeReviewRequest<T> propagateAggregationCache(long cacheExpiredMillis){
        super.propagateAggregationCache(cacheExpiredMillis);
        return this;
    }

    public EmployeeReviewRequest<T> appendSearchCriteria(SearchCriteria searchCriteria){
        return (EmployeeReviewRequest<T>)super.appendSearchCriteria(searchCriteria);
    }

    public EmployeeReviewRequest<T> filter(String property1, Operator operator, String property2){
        return appendSearchCriteria(new TwoOperatorCriteria(operator, new PropertyReference(property1), new PropertyReference(property2)));
    }


    public EmployeeReviewRequest<T> matchingAnyOf(EmployeeReviewRequest employeeReview){
        super.internalMatchAny(employeeReview);
        return this;
    }

    public EmployeeReviewRequest<T> enhanceChildrenIfNeeded(){
        return this;
    }

    public EmployeeReviewRequest<T> withDeletedRows(){
        super.withDeletedRows();
        return this;
    }

    public EmployeeReviewRequest<T> deletedRowsOnly(){
        super.deletedRowsOnly();
        return this;
    }

    public EmployeeReviewRequest<T> selectSelf(){
        super.selectSelf();
        return selectId().selectComments().selectEmployeeIdOnly().selectReviewDate().selectReviewerId().selectScore().selectCreateTime().selectUpdateTime().selectVersion();
    }

    public EmployeeReviewRequest<T> selectSelfFields(){
        return selectSelf();
    }

    public EmployeeReviewRequest<T> selectAll(){
        super.selectAll();
        return selectId().selectComments().selectEmployee().selectReviewDate().selectReviewerId().selectScore().selectCreateTime().selectUpdateTime().selectVersion();
    }

    public EmployeeReviewRequest<T> selectChildren(){
        super.selectAny();
        return selectId().selectComments().selectEmployee().selectReviewDate().selectReviewerId().selectScore().selectCreateTime().selectUpdateTime().selectVersion();
    }


    public EmployeeReviewRequest<T> selectId(){
       selectProperty(EmployeeReview.ID_PROPERTY);
       return this;
    }

    /**
     * fill the id with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  id) to fetch id property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public EmployeeReviewRequest<T> unselectId(){
       unselectProperty(EmployeeReview.ID_PROPERTY);
       return this;
    }
    public EmployeeReviewRequest<T> selectComments(){
       selectProperty(EmployeeReview.COMMENTS_PROPERTY);
       return this;
    }

    /**
     * fill the comments with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  comments) to fetch comments property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public EmployeeReviewRequest<T> unselectComments(){
       unselectProperty(EmployeeReview.COMMENTS_PROPERTY);
       return this;
    }
    public EmployeeReviewRequest<T> selectEmployeeIdOnly(){
       selectProperty(EmployeeReview.EMPLOYEE_PROPERTY);
       return this;
    }

    public EmployeeReviewRequest<T> selectEmployee(){
        return selectEmployeeWith(Q.employees().unlimited().selectSelf());
    }

    public EmployeeReviewRequest<T> selectEmployeeWith(EmployeeRequest employee){
       selectProperty(EmployeeReview.EMPLOYEE_PROPERTY);
       enhanceRelation(EmployeeReview.EMPLOYEE_PROPERTY, employee);
       return this;
    }

    public EmployeeReviewRequest<T> unselectEmployee(){
       unselectProperty(EmployeeReview.EMPLOYEE_PROPERTY);
       return this;
    }
    public EmployeeReviewRequest<T> selectReviewDate(){
       selectProperty(EmployeeReview.REVIEW_DATE_PROPERTY);
       return this;
    }

    /**
     * fill the reviewDate with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  reviewDate) to fetch reviewDate property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public EmployeeReviewRequest<T> unselectReviewDate(){
       unselectProperty(EmployeeReview.REVIEW_DATE_PROPERTY);
       return this;
    }
    public EmployeeReviewRequest<T> selectReviewerId(){
       selectProperty(EmployeeReview.REVIEWER_ID_PROPERTY);
       return this;
    }

    /**
     * fill the reviewerId with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  reviewerId) to fetch reviewerId property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public EmployeeReviewRequest<T> unselectReviewerId(){
       unselectProperty(EmployeeReview.REVIEWER_ID_PROPERTY);
       return this;
    }
    public EmployeeReviewRequest<T> selectScore(){
       selectProperty(EmployeeReview.SCORE_PROPERTY);
       return this;
    }

    /**
     * fill the score with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  score) to fetch score property.
     * @param rawSqlSegment  customized rawSqlSegment
     */


    /**
     * fill the score with customized aggrFunction, TEAQL uses ({aggrFunction}(score) AS score to fetch score property.
     * @param aggrFunction  aggrFunction
     */
    public EmployeeReviewRequest<T> selectScore(AggrFunction aggrFunction){
       selectProperty(EmployeeReview.SCORE_PROPERTY, aggrFunction);
       return this;
    }


    public EmployeeReviewRequest<T> unselectScore(){
       unselectProperty(EmployeeReview.SCORE_PROPERTY);
       return this;
    }
    public EmployeeReviewRequest<T> selectCreateTime(){
       selectProperty(EmployeeReview.CREATE_TIME_PROPERTY);
       return this;
    }

    /**
     * fill the createTime with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  createTime) to fetch createTime property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public EmployeeReviewRequest<T> unselectCreateTime(){
       unselectProperty(EmployeeReview.CREATE_TIME_PROPERTY);
       return this;
    }
    public EmployeeReviewRequest<T> selectUpdateTime(){
       selectProperty(EmployeeReview.UPDATE_TIME_PROPERTY);
       return this;
    }

    /**
     * fill the updateTime with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  updateTime) to fetch updateTime property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public EmployeeReviewRequest<T> unselectUpdateTime(){
       unselectProperty(EmployeeReview.UPDATE_TIME_PROPERTY);
       return this;
    }
    public EmployeeReviewRequest<T> selectVersion(){
       selectProperty(EmployeeReview.VERSION_PROPERTY);
       return this;
    }

    /**
     * fill the version with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  version) to fetch version property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public EmployeeReviewRequest<T> unselectVersion(){
       unselectProperty(EmployeeReview.VERSION_PROPERTY);
       return this;
    }

    public EmployeeReviewRequest<T> withId(Operator operator, Object... values){
       return appendSearchCriteria(createIdCriteria(operator, values));
    }

    public SearchCriteria createIdCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(EmployeeReview.ID_PROPERTY, operator, values);
    }

    public EmployeeReviewRequest<T> withIdIs(Long id){
       return withId(Operator.EQUAL, id);
    }
    public EmployeeReviewRequest<T> withIdIn(Long... id){
       return withId(Operator.EQUAL, (Object[])id);
    }



    public EmployeeReviewRequest<T> filterByComments(String... comments){
      if (comments == null || comments.length == 0) {
        throw new IllegalArgumentException("filterByComments parameter comments cannot be empty");
      }
      return appendSearchCriteria(createCommentsCriteria(Operator.EQUAL, (Object[])comments));
    }

    public EmployeeReviewRequest<T> withComments(Operator operator, Object... values){
       return appendSearchCriteria(createCommentsCriteria(operator, values));
    }

    public EmployeeReviewRequest<T> withCommentsIsUnknown(){
       return withComments(Operator.IS_NULL);
    }

    public EmployeeReviewRequest<T> withCommentsIsKnown(){
       return withComments(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createCommentsCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(EmployeeReview.COMMENTS_PROPERTY, operator, values);
    }

    public EmployeeReviewRequest<T> withCommentsGreaterThan(String comments){
       return withComments(Operator.GREATER_THAN, comments);
    }

    public EmployeeReviewRequest<T> withCommentsGreaterThanOrEqualTo(String comments){
       return withComments(Operator.GREATER_THAN_OR_EQUAL, comments);
    }

    public EmployeeReviewRequest<T> withCommentsLessThan(String comments){
       return withComments(Operator.LESS_THAN, comments);
    }

    public EmployeeReviewRequest<T> withCommentsLessThanOrEqualTo(String comments){
       return withComments(Operator.LESS_THAN_OR_EQUAL, comments);
    }

    public EmployeeReviewRequest<T> withCommentsBetween(String startOfComments, String endOfComments){
       return withComments(Operator.BETWEEN, startOfComments, endOfComments);
    }
    public EmployeeReviewRequest<T> withCommentsStartingWith(String comments){
       return withComments(Operator.BEGIN_WITH, comments);
    }
    public EmployeeReviewRequest<T> withCommentsContaining(String comments){
       return withComments(Operator.CONTAIN, comments);
    }

    public EmployeeReviewRequest<T> withCommentsEndingWith(String comments){
       return withComments(Operator.END_WITH, comments);
    }

    public EmployeeReviewRequest<T> withCommentsIs(String comments){
       return withComments(Operator.EQUAL, comments);
    }

    public EmployeeReviewRequest<T> withCommentsSoundingLike(String comments){
       return withComments(Operator.SOUNDS_LIKE, comments);
    }



    public EmployeeReviewRequest<T> filterByEmployee(Employee... employee){
      if (employee == null || employee.length == 0) {
        throw new IllegalArgumentException("filterByEmployee parameter employee cannot be empty");
      }
      return appendSearchCriteria(createEmployeeCriteria(Operator.EQUAL, (Object[])employee));
    }

    public EmployeeReviewRequest<T> withEmployee(Operator operator, Object... values){
       return appendSearchCriteria(createEmployeeCriteria(operator, values));
    }

    public EmployeeReviewRequest<T> withEmployeeIsUnknown(){
       return withEmployee(Operator.IS_NULL);
    }

    public EmployeeReviewRequest<T> withEmployeeIsKnown(){
       return withEmployee(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createEmployeeCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(EmployeeReview.EMPLOYEE_PROPERTY, operator, values);
    }

    public EmployeeReviewRequest<T> filterByEmployee(Long employee){
      if(employee == null){
         return this;
      }
      return withEmployee(Operator.EQUAL, employee);
    }
    public EmployeeReviewRequest<T> withEmployeeMatching(EmployeeRequest employee){
       return appendSearchCriteria(new SubQuerySearchCriteria(EmployeeReview.EMPLOYEE_PROPERTY, employee, Employee.ID_PROPERTY));
    }

    public EmployeeReviewRequest<T> filterByReviewDate(LocalDateTime... reviewDate){
      if (reviewDate == null || reviewDate.length == 0) {
        throw new IllegalArgumentException("filterByReviewDate parameter reviewDate cannot be empty");
      }
      return appendSearchCriteria(createReviewDateCriteria(Operator.EQUAL, (Object[])reviewDate));
    }

    public EmployeeReviewRequest<T> withReviewDate(Operator operator, Object... values){
       return appendSearchCriteria(createReviewDateCriteria(operator, values));
    }

    public EmployeeReviewRequest<T> withReviewDateIsUnknown(){
       return withReviewDate(Operator.IS_NULL);
    }

    public EmployeeReviewRequest<T> withReviewDateIsKnown(){
       return withReviewDate(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createReviewDateCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(EmployeeReview.REVIEW_DATE_PROPERTY, operator, values);
    }

    public EmployeeReviewRequest<T> withReviewDateGreaterThan(LocalDateTime reviewDate){
       return withReviewDate(Operator.GREATER_THAN, reviewDate);
    }

    public EmployeeReviewRequest<T> withReviewDateGreaterThanOrEqualTo(LocalDateTime reviewDate){
       return withReviewDate(Operator.GREATER_THAN_OR_EQUAL, reviewDate);
    }

    public EmployeeReviewRequest<T> withReviewDateLessThan(LocalDateTime reviewDate){
       return withReviewDate(Operator.LESS_THAN, reviewDate);
    }

    public EmployeeReviewRequest<T> withReviewDateLessThanOrEqualTo(LocalDateTime reviewDate){
       return withReviewDate(Operator.LESS_THAN_OR_EQUAL, reviewDate);
    }

    public EmployeeReviewRequest<T> withReviewDateBetween(LocalDateTime startOfReviewDate, LocalDateTime endOfReviewDate){
       return withReviewDate(Operator.BETWEEN, startOfReviewDate, endOfReviewDate);
    }
    public EmployeeReviewRequest<T> withReviewDateBefore(LocalDateTime reviewDate){
       return withReviewDate(Operator.LESS_THAN, reviewDate);
    }

    public EmployeeReviewRequest<T> withReviewDateBefore(Date reviewDate){
       return withReviewDate(Operator.LESS_THAN, reviewDate);
    }

    public EmployeeReviewRequest<T> withReviewDateAfter(LocalDateTime reviewDate){
       return withReviewDate(Operator.GREATER_THAN, reviewDate);
    }

    public EmployeeReviewRequest<T> withReviewDateAfter(Date reviewDate){
       return withReviewDate(Operator.GREATER_THAN, reviewDate);
    }

    public EmployeeReviewRequest<T> withReviewDateBetween(Date startOfReviewDate, Date endOfReviewDate){
       return withReviewDate(Operator.BETWEEN, startOfReviewDate, endOfReviewDate);
    }




    public EmployeeReviewRequest<T> filterByReviewerId(String... reviewerId){
      if (reviewerId == null || reviewerId.length == 0) {
        throw new IllegalArgumentException("filterByReviewerId parameter reviewerId cannot be empty");
      }
      return appendSearchCriteria(createReviewerIdCriteria(Operator.EQUAL, (Object[])reviewerId));
    }

    public EmployeeReviewRequest<T> withReviewerId(Operator operator, Object... values){
       return appendSearchCriteria(createReviewerIdCriteria(operator, values));
    }

    public EmployeeReviewRequest<T> withReviewerIdIsUnknown(){
       return withReviewerId(Operator.IS_NULL);
    }

    public EmployeeReviewRequest<T> withReviewerIdIsKnown(){
       return withReviewerId(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createReviewerIdCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(EmployeeReview.REVIEWER_ID_PROPERTY, operator, values);
    }

    public EmployeeReviewRequest<T> withReviewerIdGreaterThan(String reviewerId){
       return withReviewerId(Operator.GREATER_THAN, reviewerId);
    }

    public EmployeeReviewRequest<T> withReviewerIdGreaterThanOrEqualTo(String reviewerId){
       return withReviewerId(Operator.GREATER_THAN_OR_EQUAL, reviewerId);
    }

    public EmployeeReviewRequest<T> withReviewerIdLessThan(String reviewerId){
       return withReviewerId(Operator.LESS_THAN, reviewerId);
    }

    public EmployeeReviewRequest<T> withReviewerIdLessThanOrEqualTo(String reviewerId){
       return withReviewerId(Operator.LESS_THAN_OR_EQUAL, reviewerId);
    }

    public EmployeeReviewRequest<T> withReviewerIdBetween(String startOfReviewerId, String endOfReviewerId){
       return withReviewerId(Operator.BETWEEN, startOfReviewerId, endOfReviewerId);
    }
    public EmployeeReviewRequest<T> withReviewerIdStartingWith(String reviewerId){
       return withReviewerId(Operator.BEGIN_WITH, reviewerId);
    }
    public EmployeeReviewRequest<T> withReviewerIdContaining(String reviewerId){
       return withReviewerId(Operator.CONTAIN, reviewerId);
    }

    public EmployeeReviewRequest<T> withReviewerIdEndingWith(String reviewerId){
       return withReviewerId(Operator.END_WITH, reviewerId);
    }

    public EmployeeReviewRequest<T> withReviewerIdIs(String reviewerId){
       return withReviewerId(Operator.EQUAL, reviewerId);
    }

    public EmployeeReviewRequest<T> withReviewerIdSoundingLike(String reviewerId){
       return withReviewerId(Operator.SOUNDS_LIKE, reviewerId);
    }



    public EmployeeReviewRequest<T> filterByScore(BigDecimal... score){
      if (score == null || score.length == 0) {
        throw new IllegalArgumentException("filterByScore parameter score cannot be empty");
      }
      return appendSearchCriteria(createScoreCriteria(Operator.EQUAL, (Object[])score));
    }

    public EmployeeReviewRequest<T> withScore(Operator operator, Object... values){
       return appendSearchCriteria(createScoreCriteria(operator, values));
    }

    public EmployeeReviewRequest<T> withScoreIsUnknown(){
       return withScore(Operator.IS_NULL);
    }

    public EmployeeReviewRequest<T> withScoreIsKnown(){
       return withScore(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createScoreCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(EmployeeReview.SCORE_PROPERTY, operator, values);
    }

    public EmployeeReviewRequest<T> withScoreGreaterThan(BigDecimal score){
       return withScore(Operator.GREATER_THAN, score);
    }

    public EmployeeReviewRequest<T> withScoreGreaterThanOrEqualTo(BigDecimal score){
       return withScore(Operator.GREATER_THAN_OR_EQUAL, score);
    }

    public EmployeeReviewRequest<T> withScoreLessThan(BigDecimal score){
       return withScore(Operator.LESS_THAN, score);
    }

    public EmployeeReviewRequest<T> withScoreLessThanOrEqualTo(BigDecimal score){
       return withScore(Operator.LESS_THAN_OR_EQUAL, score);
    }

    public EmployeeReviewRequest<T> withScoreBetween(BigDecimal startOfScore, BigDecimal endOfScore){
       return withScore(Operator.BETWEEN, startOfScore, endOfScore);
    }



    public EmployeeReviewRequest<T> filterByCreateTime(LocalDateTime... createTime){
      if (createTime == null || createTime.length == 0) {
        throw new IllegalArgumentException("filterByCreateTime parameter createTime cannot be empty");
      }
      return appendSearchCriteria(createCreateTimeCriteria(Operator.EQUAL, (Object[])createTime));
    }

    public EmployeeReviewRequest<T> withCreateTime(Operator operator, Object... values){
       return appendSearchCriteria(createCreateTimeCriteria(operator, values));
    }

    public EmployeeReviewRequest<T> withCreateTimeIsUnknown(){
       return withCreateTime(Operator.IS_NULL);
    }

    public EmployeeReviewRequest<T> withCreateTimeIsKnown(){
       return withCreateTime(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createCreateTimeCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(EmployeeReview.CREATE_TIME_PROPERTY, operator, values);
    }

    public EmployeeReviewRequest<T> withCreateTimeGreaterThan(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public EmployeeReviewRequest<T> withCreateTimeGreaterThanOrEqualTo(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN_OR_EQUAL, createTime);
    }

    public EmployeeReviewRequest<T> withCreateTimeLessThan(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public EmployeeReviewRequest<T> withCreateTimeLessThanOrEqualTo(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN_OR_EQUAL, createTime);
    }

    public EmployeeReviewRequest<T> withCreateTimeBetween(LocalDateTime startOfCreateTime, LocalDateTime endOfCreateTime){
       return withCreateTime(Operator.BETWEEN, startOfCreateTime, endOfCreateTime);
    }
    public EmployeeReviewRequest<T> withCreateTimeBefore(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public EmployeeReviewRequest<T> withCreateTimeBefore(Date createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public EmployeeReviewRequest<T> withCreateTimeAfter(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public EmployeeReviewRequest<T> withCreateTimeAfter(Date createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public EmployeeReviewRequest<T> withCreateTimeBetween(Date startOfCreateTime, Date endOfCreateTime){
       return withCreateTime(Operator.BETWEEN, startOfCreateTime, endOfCreateTime);
    }




    public EmployeeReviewRequest<T> filterByUpdateTime(LocalDateTime... updateTime){
      if (updateTime == null || updateTime.length == 0) {
        throw new IllegalArgumentException("filterByUpdateTime parameter updateTime cannot be empty");
      }
      return appendSearchCriteria(createUpdateTimeCriteria(Operator.EQUAL, (Object[])updateTime));
    }

    public EmployeeReviewRequest<T> withUpdateTime(Operator operator, Object... values){
       return appendSearchCriteria(createUpdateTimeCriteria(operator, values));
    }

    public EmployeeReviewRequest<T> withUpdateTimeIsUnknown(){
       return withUpdateTime(Operator.IS_NULL);
    }

    public EmployeeReviewRequest<T> withUpdateTimeIsKnown(){
       return withUpdateTime(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createUpdateTimeCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(EmployeeReview.UPDATE_TIME_PROPERTY, operator, values);
    }

    public EmployeeReviewRequest<T> withUpdateTimeGreaterThan(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public EmployeeReviewRequest<T> withUpdateTimeGreaterThanOrEqualTo(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN_OR_EQUAL, updateTime);
    }

    public EmployeeReviewRequest<T> withUpdateTimeLessThan(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public EmployeeReviewRequest<T> withUpdateTimeLessThanOrEqualTo(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN_OR_EQUAL, updateTime);
    }

    public EmployeeReviewRequest<T> withUpdateTimeBetween(LocalDateTime startOfUpdateTime, LocalDateTime endOfUpdateTime){
       return withUpdateTime(Operator.BETWEEN, startOfUpdateTime, endOfUpdateTime);
    }
    public EmployeeReviewRequest<T> withUpdateTimeBefore(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public EmployeeReviewRequest<T> withUpdateTimeBefore(Date updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public EmployeeReviewRequest<T> withUpdateTimeAfter(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public EmployeeReviewRequest<T> withUpdateTimeAfter(Date updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public EmployeeReviewRequest<T> withUpdateTimeBetween(Date startOfUpdateTime, Date endOfUpdateTime){
       return withUpdateTime(Operator.BETWEEN, startOfUpdateTime, endOfUpdateTime);
    }




    public EmployeeReviewRequest<T> filterByVersion(Long... version){
      if (version == null || version.length == 0) {
        throw new IllegalArgumentException("filterByVersion parameter version cannot be empty");
      }
      return appendSearchCriteria(createVersionCriteria(Operator.EQUAL, (Object[])version));
    }

    public EmployeeReviewRequest<T> withVersion(Operator operator, Object... values){
       return appendSearchCriteria(createVersionCriteria(operator, values));
    }

    public EmployeeReviewRequest<T> withVersionIsUnknown(){
       return withVersion(Operator.IS_NULL);
    }

    public EmployeeReviewRequest<T> withVersionIsKnown(){
       return withVersion(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createVersionCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(EmployeeReview.VERSION_PROPERTY, operator, values);
    }

    public EmployeeReviewRequest<T> withVersionGreaterThan(Long version){
       return withVersion(Operator.GREATER_THAN, version);
    }

    public EmployeeReviewRequest<T> withVersionGreaterThanOrEqualTo(Long version){
       return withVersion(Operator.GREATER_THAN_OR_EQUAL, version);
    }

    public EmployeeReviewRequest<T> withVersionLessThan(Long version){
       return withVersion(Operator.LESS_THAN, version);
    }

    public EmployeeReviewRequest<T> withVersionLessThanOrEqualTo(Long version){
       return withVersion(Operator.LESS_THAN_OR_EQUAL, version);
    }

    public EmployeeReviewRequest<T> withVersionBetween(Long startOfVersion, Long endOfVersion){
       return withVersion(Operator.BETWEEN, startOfVersion, endOfVersion);
    }


    public EmployeeReviewRequest<T> count(){
        super.count();
        return this;
    }
    public EmployeeReviewRequest<T> countAs(String retName){
        super.count(retName);
        return this;
    }
    public EmployeeReviewRequest minScore(){
        return minScoreAs(prefix("minOf",EmployeeReview.SCORE_PROPERTY));
    }

    public EmployeeReviewRequest minScoreAs(String retName){
        super.min(retName, EmployeeReview.SCORE_PROPERTY);
        return this;
    }
    public EmployeeReviewRequest maxScore(){
        return maxScoreAs(prefix("maxOf",EmployeeReview.SCORE_PROPERTY));
    }

    public EmployeeReviewRequest maxScoreAs(String retName){
        super.max(retName, EmployeeReview.SCORE_PROPERTY);
        return this;
    }
    public EmployeeReviewRequest sumScore(){
        return sumScoreAs(prefix("sumOf",EmployeeReview.SCORE_PROPERTY));
    }

    public EmployeeReviewRequest sumScoreAs(String retName){
        super.sum(retName, EmployeeReview.SCORE_PROPERTY);
        return this;
    }
    public EmployeeReviewRequest avgScore(){
        return avgScoreAs(prefix("avgOf",EmployeeReview.SCORE_PROPERTY));
    }

    public EmployeeReviewRequest avgScoreAs(String retName){
        super.avg(retName, EmployeeReview.SCORE_PROPERTY);
        return this;
    }
    public EmployeeReviewRequest standardDeviationScore(){
        return standardDeviationScoreAs(prefix("standardDeviationOf",EmployeeReview.SCORE_PROPERTY));
    }

    public EmployeeReviewRequest standardDeviationScoreAs(String retName){
        super.standardDeviation(retName, EmployeeReview.SCORE_PROPERTY);
        return this;
    }
    public EmployeeReviewRequest squareRootOfPopulationStandardDeviationScore(){
        return squareRootOfPopulationStandardDeviationScoreAs(prefix("squareRootOfPopulationStandardDeviationOf",EmployeeReview.SCORE_PROPERTY));
    }

    public EmployeeReviewRequest squareRootOfPopulationStandardDeviationScoreAs(String retName){
        super.squareRootOfPopulationStandardDeviation(retName, EmployeeReview.SCORE_PROPERTY);
        return this;
    }
    public EmployeeReviewRequest sampleVarianceScore(){
        return sampleVarianceScoreAs(prefix("sampleVarianceOf",EmployeeReview.SCORE_PROPERTY));
    }

    public EmployeeReviewRequest sampleVarianceScoreAs(String retName){
        super.sampleVariance(retName, EmployeeReview.SCORE_PROPERTY);
        return this;
    }
    public EmployeeReviewRequest samplePopulationVarianceScore(){
        return samplePopulationVarianceScoreAs(prefix("samplePopulationVarianceOf",EmployeeReview.SCORE_PROPERTY));
    }

    public EmployeeReviewRequest samplePopulationVarianceScoreAs(String retName){
        super.samplePopulationVariance(retName, EmployeeReview.SCORE_PROPERTY);
        return this;
    }
    public EmployeeReviewRequest<T> groupByEmployeeWithDetails(){
       return groupByEmployeeWithDetails(Q.employees().unlimited());
    }

    public EmployeeReviewRequest<T> groupByEmployeeWithDetails(EmployeeRequest subRequest){
       aggregate(EmployeeReview.EMPLOYEE_PROPERTY, subRequest);
       return this;
    }








    public EmployeeReviewRequest<T> groupById(){
       groupBy(EmployeeReview.ID_PROPERTY);
       return this;
    }

    public EmployeeReviewRequest<T> groupByIdAs(String retName){
       groupBy(retName, EmployeeReview.ID_PROPERTY);
       return this;
    }

    public EmployeeReviewRequest<T> groupByIdWithFunction(String retName, AggrFunction function){
       groupBy(retName, EmployeeReview.ID_PROPERTY, function);
       return this;
    }

    public EmployeeReviewRequest<T> groupByComments(){
       groupBy(EmployeeReview.COMMENTS_PROPERTY);
       return this;
    }

    public EmployeeReviewRequest<T> groupByCommentsAs(String retName){
       groupBy(retName, EmployeeReview.COMMENTS_PROPERTY);
       return this;
    }

    public EmployeeReviewRequest<T> groupByCommentsWithFunction(String retName, AggrFunction function){
       groupBy(retName, EmployeeReview.COMMENTS_PROPERTY, function);
       return this;
    }
    public EmployeeReviewRequest<T> groupByEmployeeWith(EmployeeRequest subRequest){
       groupBy(EmployeeReview.EMPLOYEE_PROPERTY, subRequest);
       return this;
    }
    public EmployeeReviewRequest<T> groupByEmployee(){
       groupBy(EmployeeReview.EMPLOYEE_PROPERTY);
       return this;
    }

    public EmployeeReviewRequest<T> groupByEmployeeAs(String retName){
       groupBy(retName, EmployeeReview.EMPLOYEE_PROPERTY);
       return this;
    }

    public EmployeeReviewRequest<T> groupByEmployeeWithFunction(String retName, AggrFunction function){
       groupBy(retName, EmployeeReview.EMPLOYEE_PROPERTY, function);
       return this;
    }

    public EmployeeReviewRequest<T> groupByReviewDate(){
       groupBy(EmployeeReview.REVIEW_DATE_PROPERTY);
       return this;
    }

    public EmployeeReviewRequest<T> groupByReviewDateAs(String retName){
       groupBy(retName, EmployeeReview.REVIEW_DATE_PROPERTY);
       return this;
    }

    public EmployeeReviewRequest<T> groupByReviewDateWithFunction(String retName, AggrFunction function){
       groupBy(retName, EmployeeReview.REVIEW_DATE_PROPERTY, function);
       return this;
    }

    public EmployeeReviewRequest<T> groupByReviewerId(){
       groupBy(EmployeeReview.REVIEWER_ID_PROPERTY);
       return this;
    }

    public EmployeeReviewRequest<T> groupByReviewerIdAs(String retName){
       groupBy(retName, EmployeeReview.REVIEWER_ID_PROPERTY);
       return this;
    }

    public EmployeeReviewRequest<T> groupByReviewerIdWithFunction(String retName, AggrFunction function){
       groupBy(retName, EmployeeReview.REVIEWER_ID_PROPERTY, function);
       return this;
    }

    public EmployeeReviewRequest<T> groupByScore(){
       groupBy(EmployeeReview.SCORE_PROPERTY);
       return this;
    }

    public EmployeeReviewRequest<T> groupByScoreAs(String retName){
       groupBy(retName, EmployeeReview.SCORE_PROPERTY);
       return this;
    }

    public EmployeeReviewRequest<T> groupByScoreWithFunction(String retName, AggrFunction function){
       groupBy(retName, EmployeeReview.SCORE_PROPERTY, function);
       return this;
    }

    public EmployeeReviewRequest<T> groupByCreateTime(){
       groupBy(EmployeeReview.CREATE_TIME_PROPERTY);
       return this;
    }

    public EmployeeReviewRequest<T> groupByCreateTimeAs(String retName){
       groupBy(retName, EmployeeReview.CREATE_TIME_PROPERTY);
       return this;
    }

    public EmployeeReviewRequest<T> groupByCreateTimeWithFunction(String retName, AggrFunction function){
       groupBy(retName, EmployeeReview.CREATE_TIME_PROPERTY, function);
       return this;
    }

    public EmployeeReviewRequest<T> groupByUpdateTime(){
       groupBy(EmployeeReview.UPDATE_TIME_PROPERTY);
       return this;
    }

    public EmployeeReviewRequest<T> groupByUpdateTimeAs(String retName){
       groupBy(retName, EmployeeReview.UPDATE_TIME_PROPERTY);
       return this;
    }

    public EmployeeReviewRequest<T> groupByUpdateTimeWithFunction(String retName, AggrFunction function){
       groupBy(retName, EmployeeReview.UPDATE_TIME_PROPERTY, function);
       return this;
    }

    public EmployeeReviewRequest<T> groupByVersion(){
       groupBy(EmployeeReview.VERSION_PROPERTY);
       return this;
    }

    public EmployeeReviewRequest<T> groupByVersionAs(String retName){
       groupBy(retName, EmployeeReview.VERSION_PROPERTY);
       return this;
    }

    public EmployeeReviewRequest<T> groupByVersionWithFunction(String retName, AggrFunction function){
       groupBy(retName, EmployeeReview.VERSION_PROPERTY, function);
       return this;
    }



    public EmployeeReviewRequest<T> orderByIdAscending(){
       addOrderByAscending(EmployeeReview.ID_PROPERTY);
       return this;
    }

    public EmployeeReviewRequest<T> orderByIdDescending(){
       addOrderByDescending(EmployeeReview.ID_PROPERTY);
       return this;
    }

    public EmployeeReviewRequest<T> orderByCommentsAscending(){
       addOrderByAscending(EmployeeReview.COMMENTS_PROPERTY);
       return this;
    }

    public EmployeeReviewRequest<T> orderByCommentsDescending(){
       addOrderByDescending(EmployeeReview.COMMENTS_PROPERTY);
       return this;
    }
    public EmployeeReviewRequest<T> orderByCommentsAscendingUsingGBK(){
       addOrderByAscendingUsingGBK(EmployeeReview.COMMENTS_PROPERTY);
       return this;
    }

    public EmployeeReviewRequest<T> orderByCommentsDescendingUsingGBK(){
       addOrderByDescendingUsingGBK(EmployeeReview.COMMENTS_PROPERTY);
       return this;
    }
    public EmployeeReviewRequest<T> orderByEmployeeAscending(){
       addOrderByAscending(EmployeeReview.EMPLOYEE_PROPERTY);
       return this;
    }

    public EmployeeReviewRequest<T> orderByEmployeeDescending(){
       addOrderByDescending(EmployeeReview.EMPLOYEE_PROPERTY);
       return this;
    }

    public EmployeeReviewRequest<T> orderByReviewDateAscending(){
       addOrderByAscending(EmployeeReview.REVIEW_DATE_PROPERTY);
       return this;
    }

    public EmployeeReviewRequest<T> orderByReviewDateDescending(){
       addOrderByDescending(EmployeeReview.REVIEW_DATE_PROPERTY);
       return this;
    }

    public EmployeeReviewRequest<T> orderByReviewerIdAscending(){
       addOrderByAscending(EmployeeReview.REVIEWER_ID_PROPERTY);
       return this;
    }

    public EmployeeReviewRequest<T> orderByReviewerIdDescending(){
       addOrderByDescending(EmployeeReview.REVIEWER_ID_PROPERTY);
       return this;
    }
    public EmployeeReviewRequest<T> orderByReviewerIdAscendingUsingGBK(){
       addOrderByAscendingUsingGBK(EmployeeReview.REVIEWER_ID_PROPERTY);
       return this;
    }

    public EmployeeReviewRequest<T> orderByReviewerIdDescendingUsingGBK(){
       addOrderByDescendingUsingGBK(EmployeeReview.REVIEWER_ID_PROPERTY);
       return this;
    }
    public EmployeeReviewRequest<T> orderByScoreAscending(){
       addOrderByAscending(EmployeeReview.SCORE_PROPERTY);
       return this;
    }

    public EmployeeReviewRequest<T> orderByScoreDescending(){
       addOrderByDescending(EmployeeReview.SCORE_PROPERTY);
       return this;
    }

    public EmployeeReviewRequest<T> orderByCreateTimeAscending(){
       addOrderByAscending(EmployeeReview.CREATE_TIME_PROPERTY);
       return this;
    }

    public EmployeeReviewRequest<T> orderByCreateTimeDescending(){
       addOrderByDescending(EmployeeReview.CREATE_TIME_PROPERTY);
       return this;
    }

    public EmployeeReviewRequest<T> orderByUpdateTimeAscending(){
       addOrderByAscending(EmployeeReview.UPDATE_TIME_PROPERTY);
       return this;
    }

    public EmployeeReviewRequest<T> orderByUpdateTimeDescending(){
       addOrderByDescending(EmployeeReview.UPDATE_TIME_PROPERTY);
       return this;
    }

    public EmployeeReviewRequest<T> orderByVersionAscending(){
       addOrderByAscending(EmployeeReview.VERSION_PROPERTY);
       return this;
    }

    public EmployeeReviewRequest<T> orderByVersionDescending(){
       addOrderByDescending(EmployeeReview.VERSION_PROPERTY);
       return this;
    }


    public EmployeeRequest rollUpToEmployee(){
       EmployeeRequest employee = Q.employees().unlimited();
       this.withEmployeeMatching(employee)
           .groupByEmployeeWith(employee);
       return employee;
    }








   public EmployeeReviewRequest<T> facetByEmployeeAs(String facetName, EmployeeRequest employee){
       return facetByEmployeeAs(facetName, employee, true);
   }

   public EmployeeReviewRequest<T> facetByEmployeeAs(String facetName, EmployeeRequest employee, boolean includeAllFacets){
       addFacet(facetName, EmployeeReview.EMPLOYEE_PROPERTY, employee, includeAllFacets);
       return this;
   }


    /**
     * get topN records
     * @param topN  records number
     */
    public EmployeeReviewRequest<T> top(int topN) {
        super.top(topN);
        return this;
    }

    /**
     * get records from offset(inclusive) to offset+size(exclusive)
     * @param offset record offset
     * @param size records number
     */
    public EmployeeReviewRequest<T> offset(int offset, int size) {
        super.offset(offset, size);
        return this;
    }

    /**
     * retrieve all records
     */
    public EmployeeReviewRequest<T> unlimited() {
        super.unlimited();
        return this;
    }

    /**
     * get records of one page
     * @param pageNumber page number(1-based)
     * @param pageSize page size
     */
    public EmployeeReviewRequest<T> page(int pageNumber, int pageSize) {
        int offset = (pageNumber - 1) * pageSize;
        return offset(offset, pageSize);
   }

    /**
     * get records of one page, default page size is 10
     * @param pageNumber page number(1-based)
     */
    public EmployeeReviewRequest<T> page(int pageNumber) {
        return page(pageNumber, 10);
   }
}