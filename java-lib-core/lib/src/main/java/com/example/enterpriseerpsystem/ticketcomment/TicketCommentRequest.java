
package com.example.enterpriseerpsystem.ticketcomment;

import com.example.enterpriseerpsystem.Q;
import com.example.enterpriseerpsystem.ticket.Ticket;
import com.example.enterpriseerpsystem.ticket.TicketRequest;
import io.teaql.core.AggrFunction;
import io.teaql.core.BaseRequest;
import io.teaql.core.PropertyReference;
import io.teaql.core.SearchCriteria;
import io.teaql.core.SubQuerySearchCriteria;
import io.teaql.core.criteria.Operator;
import io.teaql.core.criteria.TwoOperatorCriteria;
import java.time.LocalDateTime;
import java.util.Date;

public class TicketCommentRequest<T extends TicketComment> extends BaseRequest<T> {

    /**
     * @deprecated AI agents and business code must use the generated Q facade
     *             instead of constructing request builders directly.
     */
    @Deprecated
    public TicketCommentRequest(Class<T> returnType){
        super(returnType);
        selectId();
        selectVersion();
    }

    public TicketCommentRequest<T> comment(String comment){
         super.internalComment(comment);
         return this;
    }

    // purpose() 继承自 BaseRequest，返回 ExecutableRequest（终结方法）

    public TicketCommentRequest<T> returnType(Class<? extends T> returnType){
        super.setReturnType(returnType);
        return this;
    }

    public TicketCommentRequest<T> enableAggregationCache(long cacheExpiredMillis){
        super.enableAggregationCache();
        super.aggregateCacheTime(cacheExpiredMillis);
        return this;
    }

    public TicketCommentRequest<T> enableAggregationCache(){
        return enableAggregationCache(0l);
    }


    public TicketCommentRequest<T> propagateAggregationCache(long cacheExpiredMillis){
        super.propagateAggregationCache(cacheExpiredMillis);
        return this;
    }

    public TicketCommentRequest<T> appendSearchCriteria(SearchCriteria searchCriteria){
        return (TicketCommentRequest<T>)super.appendSearchCriteria(searchCriteria);
    }

    public TicketCommentRequest<T> filter(String property1, Operator operator, String property2){
        return appendSearchCriteria(new TwoOperatorCriteria(operator, new PropertyReference(property1), new PropertyReference(property2)));
    }


    public TicketCommentRequest<T> matchingAnyOf(TicketCommentRequest ticketComment){
        super.internalMatchAny(ticketComment);
        return this;
    }

    public TicketCommentRequest<T> enhanceChildrenIfNeeded(){
        return this;
    }

    public TicketCommentRequest<T> withDeletedRows(){
        super.withDeletedRows();
        return this;
    }

    public TicketCommentRequest<T> deletedRowsOnly(){
        super.deletedRowsOnly();
        return this;
    }

    public TicketCommentRequest<T> selectSelf(){
        super.selectSelf();
        return selectId().selectAuthorId().selectCommentText().selectCreatedAt().selectTicketIdOnly().selectCreateTime().selectUpdateTime().selectVersion();
    }

    public TicketCommentRequest<T> selectSelfFields(){
        return selectSelf();
    }

    public TicketCommentRequest<T> selectAll(){
        super.selectAll();
        return selectId().selectAuthorId().selectCommentText().selectCreatedAt().selectTicket().selectCreateTime().selectUpdateTime().selectVersion();
    }

    public TicketCommentRequest<T> selectChildren(){
        super.selectAny();
        return selectId().selectAuthorId().selectCommentText().selectCreatedAt().selectTicket().selectCreateTime().selectUpdateTime().selectVersion();
    }


    public TicketCommentRequest<T> selectId(){
       selectProperty(TicketComment.ID_PROPERTY);
       return this;
    }

    /**
     * fill the id with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  id) to fetch id property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public TicketCommentRequest<T> unselectId(){
       unselectProperty(TicketComment.ID_PROPERTY);
       return this;
    }
    public TicketCommentRequest<T> selectAuthorId(){
       selectProperty(TicketComment.AUTHOR_ID_PROPERTY);
       return this;
    }

    /**
     * fill the authorId with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  authorId) to fetch authorId property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public TicketCommentRequest<T> unselectAuthorId(){
       unselectProperty(TicketComment.AUTHOR_ID_PROPERTY);
       return this;
    }
    public TicketCommentRequest<T> selectCommentText(){
       selectProperty(TicketComment.COMMENT_TEXT_PROPERTY);
       return this;
    }

    /**
     * fill the commentText with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  commentText) to fetch commentText property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public TicketCommentRequest<T> unselectCommentText(){
       unselectProperty(TicketComment.COMMENT_TEXT_PROPERTY);
       return this;
    }
    public TicketCommentRequest<T> selectCreatedAt(){
       selectProperty(TicketComment.CREATED_AT_PROPERTY);
       return this;
    }

    /**
     * fill the createdAt with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  createdAt) to fetch createdAt property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public TicketCommentRequest<T> unselectCreatedAt(){
       unselectProperty(TicketComment.CREATED_AT_PROPERTY);
       return this;
    }
    public TicketCommentRequest<T> selectTicketIdOnly(){
       selectProperty(TicketComment.TICKET_PROPERTY);
       return this;
    }

    public TicketCommentRequest<T> selectTicket(){
        return selectTicketWith(Q.tickets().unlimited().selectSelf());
    }

    public TicketCommentRequest<T> selectTicketWith(TicketRequest ticket){
       selectProperty(TicketComment.TICKET_PROPERTY);
       enhanceRelation(TicketComment.TICKET_PROPERTY, ticket);
       return this;
    }

    public TicketCommentRequest<T> unselectTicket(){
       unselectProperty(TicketComment.TICKET_PROPERTY);
       return this;
    }
    public TicketCommentRequest<T> selectCreateTime(){
       selectProperty(TicketComment.CREATE_TIME_PROPERTY);
       return this;
    }

    /**
     * fill the createTime with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  createTime) to fetch createTime property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public TicketCommentRequest<T> unselectCreateTime(){
       unselectProperty(TicketComment.CREATE_TIME_PROPERTY);
       return this;
    }
    public TicketCommentRequest<T> selectUpdateTime(){
       selectProperty(TicketComment.UPDATE_TIME_PROPERTY);
       return this;
    }

    /**
     * fill the updateTime with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  updateTime) to fetch updateTime property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public TicketCommentRequest<T> unselectUpdateTime(){
       unselectProperty(TicketComment.UPDATE_TIME_PROPERTY);
       return this;
    }
    public TicketCommentRequest<T> selectVersion(){
       selectProperty(TicketComment.VERSION_PROPERTY);
       return this;
    }

    /**
     * fill the version with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  version) to fetch version property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public TicketCommentRequest<T> unselectVersion(){
       unselectProperty(TicketComment.VERSION_PROPERTY);
       return this;
    }

    public TicketCommentRequest<T> withId(Operator operator, Object... values){
       return appendSearchCriteria(createIdCriteria(operator, values));
    }

    public SearchCriteria createIdCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(TicketComment.ID_PROPERTY, operator, values);
    }

    public TicketCommentRequest<T> withIdIs(Long id){
       return withId(Operator.EQUAL, id);
    }
    public TicketCommentRequest<T> withIdIn(Long... id){
       return withId(Operator.EQUAL, (Object[])id);
    }



    public TicketCommentRequest<T> filterByAuthorId(String... authorId){
      if (authorId == null || authorId.length == 0) {
        throw new IllegalArgumentException("filterByAuthorId parameter authorId cannot be empty");
      }
      return appendSearchCriteria(createAuthorIdCriteria(Operator.EQUAL, (Object[])authorId));
    }

    public TicketCommentRequest<T> withAuthorId(Operator operator, Object... values){
       return appendSearchCriteria(createAuthorIdCriteria(operator, values));
    }

    public TicketCommentRequest<T> withAuthorIdIsUnknown(){
       return withAuthorId(Operator.IS_NULL);
    }

    public TicketCommentRequest<T> withAuthorIdIsKnown(){
       return withAuthorId(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createAuthorIdCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(TicketComment.AUTHOR_ID_PROPERTY, operator, values);
    }

    public TicketCommentRequest<T> withAuthorIdGreaterThan(String authorId){
       return withAuthorId(Operator.GREATER_THAN, authorId);
    }

    public TicketCommentRequest<T> withAuthorIdGreaterThanOrEqualTo(String authorId){
       return withAuthorId(Operator.GREATER_THAN_OR_EQUAL, authorId);
    }

    public TicketCommentRequest<T> withAuthorIdLessThan(String authorId){
       return withAuthorId(Operator.LESS_THAN, authorId);
    }

    public TicketCommentRequest<T> withAuthorIdLessThanOrEqualTo(String authorId){
       return withAuthorId(Operator.LESS_THAN_OR_EQUAL, authorId);
    }

    public TicketCommentRequest<T> withAuthorIdBetween(String startOfAuthorId, String endOfAuthorId){
       return withAuthorId(Operator.BETWEEN, startOfAuthorId, endOfAuthorId);
    }
    public TicketCommentRequest<T> withAuthorIdStartingWith(String authorId){
       return withAuthorId(Operator.BEGIN_WITH, authorId);
    }
    public TicketCommentRequest<T> withAuthorIdContaining(String authorId){
       return withAuthorId(Operator.CONTAIN, authorId);
    }

    public TicketCommentRequest<T> withAuthorIdEndingWith(String authorId){
       return withAuthorId(Operator.END_WITH, authorId);
    }

    public TicketCommentRequest<T> withAuthorIdIs(String authorId){
       return withAuthorId(Operator.EQUAL, authorId);
    }

    public TicketCommentRequest<T> withAuthorIdSoundingLike(String authorId){
       return withAuthorId(Operator.SOUNDS_LIKE, authorId);
    }



    public TicketCommentRequest<T> filterByCommentText(String... commentText){
      if (commentText == null || commentText.length == 0) {
        throw new IllegalArgumentException("filterByCommentText parameter commentText cannot be empty");
      }
      return appendSearchCriteria(createCommentTextCriteria(Operator.EQUAL, (Object[])commentText));
    }

    public TicketCommentRequest<T> withCommentText(Operator operator, Object... values){
       return appendSearchCriteria(createCommentTextCriteria(operator, values));
    }

    public TicketCommentRequest<T> withCommentTextIsUnknown(){
       return withCommentText(Operator.IS_NULL);
    }

    public TicketCommentRequest<T> withCommentTextIsKnown(){
       return withCommentText(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createCommentTextCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(TicketComment.COMMENT_TEXT_PROPERTY, operator, values);
    }

    public TicketCommentRequest<T> withCommentTextGreaterThan(String commentText){
       return withCommentText(Operator.GREATER_THAN, commentText);
    }

    public TicketCommentRequest<T> withCommentTextGreaterThanOrEqualTo(String commentText){
       return withCommentText(Operator.GREATER_THAN_OR_EQUAL, commentText);
    }

    public TicketCommentRequest<T> withCommentTextLessThan(String commentText){
       return withCommentText(Operator.LESS_THAN, commentText);
    }

    public TicketCommentRequest<T> withCommentTextLessThanOrEqualTo(String commentText){
       return withCommentText(Operator.LESS_THAN_OR_EQUAL, commentText);
    }

    public TicketCommentRequest<T> withCommentTextBetween(String startOfCommentText, String endOfCommentText){
       return withCommentText(Operator.BETWEEN, startOfCommentText, endOfCommentText);
    }
    public TicketCommentRequest<T> withCommentTextStartingWith(String commentText){
       return withCommentText(Operator.BEGIN_WITH, commentText);
    }
    public TicketCommentRequest<T> withCommentTextContaining(String commentText){
       return withCommentText(Operator.CONTAIN, commentText);
    }

    public TicketCommentRequest<T> withCommentTextEndingWith(String commentText){
       return withCommentText(Operator.END_WITH, commentText);
    }

    public TicketCommentRequest<T> withCommentTextIs(String commentText){
       return withCommentText(Operator.EQUAL, commentText);
    }

    public TicketCommentRequest<T> withCommentTextSoundingLike(String commentText){
       return withCommentText(Operator.SOUNDS_LIKE, commentText);
    }



    public TicketCommentRequest<T> filterByCreatedAt(LocalDateTime... createdAt){
      if (createdAt == null || createdAt.length == 0) {
        throw new IllegalArgumentException("filterByCreatedAt parameter createdAt cannot be empty");
      }
      return appendSearchCriteria(createCreatedAtCriteria(Operator.EQUAL, (Object[])createdAt));
    }

    public TicketCommentRequest<T> withCreatedAt(Operator operator, Object... values){
       return appendSearchCriteria(createCreatedAtCriteria(operator, values));
    }

    public TicketCommentRequest<T> withCreatedAtIsUnknown(){
       return withCreatedAt(Operator.IS_NULL);
    }

    public TicketCommentRequest<T> withCreatedAtIsKnown(){
       return withCreatedAt(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createCreatedAtCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(TicketComment.CREATED_AT_PROPERTY, operator, values);
    }

    public TicketCommentRequest<T> withCreatedAtGreaterThan(LocalDateTime createdAt){
       return withCreatedAt(Operator.GREATER_THAN, createdAt);
    }

    public TicketCommentRequest<T> withCreatedAtGreaterThanOrEqualTo(LocalDateTime createdAt){
       return withCreatedAt(Operator.GREATER_THAN_OR_EQUAL, createdAt);
    }

    public TicketCommentRequest<T> withCreatedAtLessThan(LocalDateTime createdAt){
       return withCreatedAt(Operator.LESS_THAN, createdAt);
    }

    public TicketCommentRequest<T> withCreatedAtLessThanOrEqualTo(LocalDateTime createdAt){
       return withCreatedAt(Operator.LESS_THAN_OR_EQUAL, createdAt);
    }

    public TicketCommentRequest<T> withCreatedAtBetween(LocalDateTime startOfCreatedAt, LocalDateTime endOfCreatedAt){
       return withCreatedAt(Operator.BETWEEN, startOfCreatedAt, endOfCreatedAt);
    }
    public TicketCommentRequest<T> withCreatedAtBefore(LocalDateTime createdAt){
       return withCreatedAt(Operator.LESS_THAN, createdAt);
    }

    public TicketCommentRequest<T> withCreatedAtBefore(Date createdAt){
       return withCreatedAt(Operator.LESS_THAN, createdAt);
    }

    public TicketCommentRequest<T> withCreatedAtAfter(LocalDateTime createdAt){
       return withCreatedAt(Operator.GREATER_THAN, createdAt);
    }

    public TicketCommentRequest<T> withCreatedAtAfter(Date createdAt){
       return withCreatedAt(Operator.GREATER_THAN, createdAt);
    }

    public TicketCommentRequest<T> withCreatedAtBetween(Date startOfCreatedAt, Date endOfCreatedAt){
       return withCreatedAt(Operator.BETWEEN, startOfCreatedAt, endOfCreatedAt);
    }




    public TicketCommentRequest<T> filterByTicket(Ticket... ticket){
      if (ticket == null || ticket.length == 0) {
        throw new IllegalArgumentException("filterByTicket parameter ticket cannot be empty");
      }
      return appendSearchCriteria(createTicketCriteria(Operator.EQUAL, (Object[])ticket));
    }

    public TicketCommentRequest<T> withTicket(Operator operator, Object... values){
       return appendSearchCriteria(createTicketCriteria(operator, values));
    }

    public TicketCommentRequest<T> withTicketIsUnknown(){
       return withTicket(Operator.IS_NULL);
    }

    public TicketCommentRequest<T> withTicketIsKnown(){
       return withTicket(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createTicketCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(TicketComment.TICKET_PROPERTY, operator, values);
    }

    public TicketCommentRequest<T> filterByTicket(Long ticket){
      if(ticket == null){
         return this;
      }
      return withTicket(Operator.EQUAL, ticket);
    }
    public TicketCommentRequest<T> withTicketMatching(TicketRequest ticket){
       return appendSearchCriteria(new SubQuerySearchCriteria(TicketComment.TICKET_PROPERTY, ticket, Ticket.ID_PROPERTY));
    }

    public TicketCommentRequest<T> filterByCreateTime(LocalDateTime... createTime){
      if (createTime == null || createTime.length == 0) {
        throw new IllegalArgumentException("filterByCreateTime parameter createTime cannot be empty");
      }
      return appendSearchCriteria(createCreateTimeCriteria(Operator.EQUAL, (Object[])createTime));
    }

    public TicketCommentRequest<T> withCreateTime(Operator operator, Object... values){
       return appendSearchCriteria(createCreateTimeCriteria(operator, values));
    }

    public TicketCommentRequest<T> withCreateTimeIsUnknown(){
       return withCreateTime(Operator.IS_NULL);
    }

    public TicketCommentRequest<T> withCreateTimeIsKnown(){
       return withCreateTime(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createCreateTimeCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(TicketComment.CREATE_TIME_PROPERTY, operator, values);
    }

    public TicketCommentRequest<T> withCreateTimeGreaterThan(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public TicketCommentRequest<T> withCreateTimeGreaterThanOrEqualTo(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN_OR_EQUAL, createTime);
    }

    public TicketCommentRequest<T> withCreateTimeLessThan(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public TicketCommentRequest<T> withCreateTimeLessThanOrEqualTo(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN_OR_EQUAL, createTime);
    }

    public TicketCommentRequest<T> withCreateTimeBetween(LocalDateTime startOfCreateTime, LocalDateTime endOfCreateTime){
       return withCreateTime(Operator.BETWEEN, startOfCreateTime, endOfCreateTime);
    }
    public TicketCommentRequest<T> withCreateTimeBefore(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public TicketCommentRequest<T> withCreateTimeBefore(Date createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public TicketCommentRequest<T> withCreateTimeAfter(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public TicketCommentRequest<T> withCreateTimeAfter(Date createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public TicketCommentRequest<T> withCreateTimeBetween(Date startOfCreateTime, Date endOfCreateTime){
       return withCreateTime(Operator.BETWEEN, startOfCreateTime, endOfCreateTime);
    }




    public TicketCommentRequest<T> filterByUpdateTime(LocalDateTime... updateTime){
      if (updateTime == null || updateTime.length == 0) {
        throw new IllegalArgumentException("filterByUpdateTime parameter updateTime cannot be empty");
      }
      return appendSearchCriteria(createUpdateTimeCriteria(Operator.EQUAL, (Object[])updateTime));
    }

    public TicketCommentRequest<T> withUpdateTime(Operator operator, Object... values){
       return appendSearchCriteria(createUpdateTimeCriteria(operator, values));
    }

    public TicketCommentRequest<T> withUpdateTimeIsUnknown(){
       return withUpdateTime(Operator.IS_NULL);
    }

    public TicketCommentRequest<T> withUpdateTimeIsKnown(){
       return withUpdateTime(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createUpdateTimeCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(TicketComment.UPDATE_TIME_PROPERTY, operator, values);
    }

    public TicketCommentRequest<T> withUpdateTimeGreaterThan(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public TicketCommentRequest<T> withUpdateTimeGreaterThanOrEqualTo(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN_OR_EQUAL, updateTime);
    }

    public TicketCommentRequest<T> withUpdateTimeLessThan(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public TicketCommentRequest<T> withUpdateTimeLessThanOrEqualTo(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN_OR_EQUAL, updateTime);
    }

    public TicketCommentRequest<T> withUpdateTimeBetween(LocalDateTime startOfUpdateTime, LocalDateTime endOfUpdateTime){
       return withUpdateTime(Operator.BETWEEN, startOfUpdateTime, endOfUpdateTime);
    }
    public TicketCommentRequest<T> withUpdateTimeBefore(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public TicketCommentRequest<T> withUpdateTimeBefore(Date updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public TicketCommentRequest<T> withUpdateTimeAfter(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public TicketCommentRequest<T> withUpdateTimeAfter(Date updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public TicketCommentRequest<T> withUpdateTimeBetween(Date startOfUpdateTime, Date endOfUpdateTime){
       return withUpdateTime(Operator.BETWEEN, startOfUpdateTime, endOfUpdateTime);
    }




    public TicketCommentRequest<T> filterByVersion(Long... version){
      if (version == null || version.length == 0) {
        throw new IllegalArgumentException("filterByVersion parameter version cannot be empty");
      }
      return appendSearchCriteria(createVersionCriteria(Operator.EQUAL, (Object[])version));
    }

    public TicketCommentRequest<T> withVersion(Operator operator, Object... values){
       return appendSearchCriteria(createVersionCriteria(operator, values));
    }

    public TicketCommentRequest<T> withVersionIsUnknown(){
       return withVersion(Operator.IS_NULL);
    }

    public TicketCommentRequest<T> withVersionIsKnown(){
       return withVersion(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createVersionCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(TicketComment.VERSION_PROPERTY, operator, values);
    }

    public TicketCommentRequest<T> withVersionGreaterThan(Long version){
       return withVersion(Operator.GREATER_THAN, version);
    }

    public TicketCommentRequest<T> withVersionGreaterThanOrEqualTo(Long version){
       return withVersion(Operator.GREATER_THAN_OR_EQUAL, version);
    }

    public TicketCommentRequest<T> withVersionLessThan(Long version){
       return withVersion(Operator.LESS_THAN, version);
    }

    public TicketCommentRequest<T> withVersionLessThanOrEqualTo(Long version){
       return withVersion(Operator.LESS_THAN_OR_EQUAL, version);
    }

    public TicketCommentRequest<T> withVersionBetween(Long startOfVersion, Long endOfVersion){
       return withVersion(Operator.BETWEEN, startOfVersion, endOfVersion);
    }


    public TicketCommentRequest<T> count(){
        super.count();
        return this;
    }
    public TicketCommentRequest<T> countAs(String retName){
        super.count(retName);
        return this;
    }
    public TicketCommentRequest<T> groupByTicketWithDetails(){
       return groupByTicketWithDetails(Q.tickets().unlimited());
    }

    public TicketCommentRequest<T> groupByTicketWithDetails(TicketRequest subRequest){
       aggregate(TicketComment.TICKET_PROPERTY, subRequest);
       return this;
    }





    public TicketCommentRequest<T> groupById(){
       groupBy(TicketComment.ID_PROPERTY);
       return this;
    }

    public TicketCommentRequest<T> groupByIdAs(String retName){
       groupBy(retName, TicketComment.ID_PROPERTY);
       return this;
    }

    public TicketCommentRequest<T> groupByIdWithFunction(String retName, AggrFunction function){
       groupBy(retName, TicketComment.ID_PROPERTY, function);
       return this;
    }

    public TicketCommentRequest<T> groupByAuthorId(){
       groupBy(TicketComment.AUTHOR_ID_PROPERTY);
       return this;
    }

    public TicketCommentRequest<T> groupByAuthorIdAs(String retName){
       groupBy(retName, TicketComment.AUTHOR_ID_PROPERTY);
       return this;
    }

    public TicketCommentRequest<T> groupByAuthorIdWithFunction(String retName, AggrFunction function){
       groupBy(retName, TicketComment.AUTHOR_ID_PROPERTY, function);
       return this;
    }

    public TicketCommentRequest<T> groupByCommentText(){
       groupBy(TicketComment.COMMENT_TEXT_PROPERTY);
       return this;
    }

    public TicketCommentRequest<T> groupByCommentTextAs(String retName){
       groupBy(retName, TicketComment.COMMENT_TEXT_PROPERTY);
       return this;
    }

    public TicketCommentRequest<T> groupByCommentTextWithFunction(String retName, AggrFunction function){
       groupBy(retName, TicketComment.COMMENT_TEXT_PROPERTY, function);
       return this;
    }

    public TicketCommentRequest<T> groupByCreatedAt(){
       groupBy(TicketComment.CREATED_AT_PROPERTY);
       return this;
    }

    public TicketCommentRequest<T> groupByCreatedAtAs(String retName){
       groupBy(retName, TicketComment.CREATED_AT_PROPERTY);
       return this;
    }

    public TicketCommentRequest<T> groupByCreatedAtWithFunction(String retName, AggrFunction function){
       groupBy(retName, TicketComment.CREATED_AT_PROPERTY, function);
       return this;
    }
    public TicketCommentRequest<T> groupByTicketWith(TicketRequest subRequest){
       groupBy(TicketComment.TICKET_PROPERTY, subRequest);
       return this;
    }
    public TicketCommentRequest<T> groupByTicket(){
       groupBy(TicketComment.TICKET_PROPERTY);
       return this;
    }

    public TicketCommentRequest<T> groupByTicketAs(String retName){
       groupBy(retName, TicketComment.TICKET_PROPERTY);
       return this;
    }

    public TicketCommentRequest<T> groupByTicketWithFunction(String retName, AggrFunction function){
       groupBy(retName, TicketComment.TICKET_PROPERTY, function);
       return this;
    }

    public TicketCommentRequest<T> groupByCreateTime(){
       groupBy(TicketComment.CREATE_TIME_PROPERTY);
       return this;
    }

    public TicketCommentRequest<T> groupByCreateTimeAs(String retName){
       groupBy(retName, TicketComment.CREATE_TIME_PROPERTY);
       return this;
    }

    public TicketCommentRequest<T> groupByCreateTimeWithFunction(String retName, AggrFunction function){
       groupBy(retName, TicketComment.CREATE_TIME_PROPERTY, function);
       return this;
    }

    public TicketCommentRequest<T> groupByUpdateTime(){
       groupBy(TicketComment.UPDATE_TIME_PROPERTY);
       return this;
    }

    public TicketCommentRequest<T> groupByUpdateTimeAs(String retName){
       groupBy(retName, TicketComment.UPDATE_TIME_PROPERTY);
       return this;
    }

    public TicketCommentRequest<T> groupByUpdateTimeWithFunction(String retName, AggrFunction function){
       groupBy(retName, TicketComment.UPDATE_TIME_PROPERTY, function);
       return this;
    }

    public TicketCommentRequest<T> groupByVersion(){
       groupBy(TicketComment.VERSION_PROPERTY);
       return this;
    }

    public TicketCommentRequest<T> groupByVersionAs(String retName){
       groupBy(retName, TicketComment.VERSION_PROPERTY);
       return this;
    }

    public TicketCommentRequest<T> groupByVersionWithFunction(String retName, AggrFunction function){
       groupBy(retName, TicketComment.VERSION_PROPERTY, function);
       return this;
    }



    public TicketCommentRequest<T> orderByIdAscending(){
       addOrderByAscending(TicketComment.ID_PROPERTY);
       return this;
    }

    public TicketCommentRequest<T> orderByIdDescending(){
       addOrderByDescending(TicketComment.ID_PROPERTY);
       return this;
    }

    public TicketCommentRequest<T> orderByAuthorIdAscending(){
       addOrderByAscending(TicketComment.AUTHOR_ID_PROPERTY);
       return this;
    }

    public TicketCommentRequest<T> orderByAuthorIdDescending(){
       addOrderByDescending(TicketComment.AUTHOR_ID_PROPERTY);
       return this;
    }
    public TicketCommentRequest<T> orderByAuthorIdAscendingUsingGBK(){
       addOrderByAscendingUsingGBK(TicketComment.AUTHOR_ID_PROPERTY);
       return this;
    }

    public TicketCommentRequest<T> orderByAuthorIdDescendingUsingGBK(){
       addOrderByDescendingUsingGBK(TicketComment.AUTHOR_ID_PROPERTY);
       return this;
    }
    public TicketCommentRequest<T> orderByCommentTextAscending(){
       addOrderByAscending(TicketComment.COMMENT_TEXT_PROPERTY);
       return this;
    }

    public TicketCommentRequest<T> orderByCommentTextDescending(){
       addOrderByDescending(TicketComment.COMMENT_TEXT_PROPERTY);
       return this;
    }
    public TicketCommentRequest<T> orderByCommentTextAscendingUsingGBK(){
       addOrderByAscendingUsingGBK(TicketComment.COMMENT_TEXT_PROPERTY);
       return this;
    }

    public TicketCommentRequest<T> orderByCommentTextDescendingUsingGBK(){
       addOrderByDescendingUsingGBK(TicketComment.COMMENT_TEXT_PROPERTY);
       return this;
    }
    public TicketCommentRequest<T> orderByCreatedAtAscending(){
       addOrderByAscending(TicketComment.CREATED_AT_PROPERTY);
       return this;
    }

    public TicketCommentRequest<T> orderByCreatedAtDescending(){
       addOrderByDescending(TicketComment.CREATED_AT_PROPERTY);
       return this;
    }

    public TicketCommentRequest<T> orderByTicketAscending(){
       addOrderByAscending(TicketComment.TICKET_PROPERTY);
       return this;
    }

    public TicketCommentRequest<T> orderByTicketDescending(){
       addOrderByDescending(TicketComment.TICKET_PROPERTY);
       return this;
    }

    public TicketCommentRequest<T> orderByCreateTimeAscending(){
       addOrderByAscending(TicketComment.CREATE_TIME_PROPERTY);
       return this;
    }

    public TicketCommentRequest<T> orderByCreateTimeDescending(){
       addOrderByDescending(TicketComment.CREATE_TIME_PROPERTY);
       return this;
    }

    public TicketCommentRequest<T> orderByUpdateTimeAscending(){
       addOrderByAscending(TicketComment.UPDATE_TIME_PROPERTY);
       return this;
    }

    public TicketCommentRequest<T> orderByUpdateTimeDescending(){
       addOrderByDescending(TicketComment.UPDATE_TIME_PROPERTY);
       return this;
    }

    public TicketCommentRequest<T> orderByVersionAscending(){
       addOrderByAscending(TicketComment.VERSION_PROPERTY);
       return this;
    }

    public TicketCommentRequest<T> orderByVersionDescending(){
       addOrderByDescending(TicketComment.VERSION_PROPERTY);
       return this;
    }


    public TicketRequest rollUpToTicket(){
       TicketRequest ticket = Q.tickets().unlimited();
       this.withTicketMatching(ticket)
           .groupByTicketWith(ticket);
       return ticket;
    }





   public TicketCommentRequest<T> facetByTicketAs(String facetName, TicketRequest ticket){
       return facetByTicketAs(facetName, ticket, true);
   }

   public TicketCommentRequest<T> facetByTicketAs(String facetName, TicketRequest ticket, boolean includeAllFacets){
       addFacet(facetName, TicketComment.TICKET_PROPERTY, ticket, includeAllFacets);
       return this;
   }


    /**
     * get topN records
     * @param topN  records number
     */
    public TicketCommentRequest<T> top(int topN) {
        super.top(topN);
        return this;
    }

    /**
     * get records from offset(inclusive) to offset+size(exclusive)
     * @param offset record offset
     * @param size records number
     */
    public TicketCommentRequest<T> offset(int offset, int size) {
        super.offset(offset, size);
        return this;
    }

    /**
     * retrieve all records
     */
    public TicketCommentRequest<T> unlimited() {
        super.unlimited();
        return this;
    }

    /**
     * get records of one page
     * @param pageNumber page number(1-based)
     * @param pageSize page size
     */
    public TicketCommentRequest<T> page(int pageNumber, int pageSize) {
        int offset = (pageNumber - 1) * pageSize;
        return offset(offset, pageSize);
   }

    /**
     * get records of one page, default page size is 10
     * @param pageNumber page number(1-based)
     */
    public TicketCommentRequest<T> page(int pageNumber) {
        return page(pageNumber, 10);
   }
}