
package com.example.enterpriseerpsystem.ticket;

import com.example.enterpriseerpsystem.Q;
import com.example.enterpriseerpsystem.customer.Customer;
import com.example.enterpriseerpsystem.customer.CustomerRequest;
import com.example.enterpriseerpsystem.ticketcomment.TicketComment;
import com.example.enterpriseerpsystem.ticketcomment.TicketCommentRequest;
import io.teaql.core.AggrFunction;
import io.teaql.core.BaseRequest;
import io.teaql.core.PropertyReference;
import io.teaql.core.SearchCriteria;
import io.teaql.core.SubQuerySearchCriteria;
import io.teaql.core.criteria.Operator;
import io.teaql.core.criteria.TwoOperatorCriteria;
import java.time.LocalDateTime;
import java.util.Date;

public class TicketRequest<T extends Ticket> extends BaseRequest<T> {

    /**
     * @deprecated AI agents and business code must use the generated Q facade
     *             instead of constructing request builders directly.
     */
    @Deprecated
    public TicketRequest(Class<T> returnType){
        super(returnType);
        selectId();
        selectVersion();
    }

    public TicketRequest<T> comment(String comment){
         super.internalComment(comment);
         return this;
    }

    // purpose() 继承自 BaseRequest，返回 ExecutableRequest（终结方法）

    public TicketRequest<T> returnType(Class<? extends T> returnType){
        super.setReturnType(returnType);
        return this;
    }

    public TicketRequest<T> enableAggregationCache(long cacheExpiredMillis){
        super.enableAggregationCache();
        super.aggregateCacheTime(cacheExpiredMillis);
        return this;
    }

    public TicketRequest<T> enableAggregationCache(){
        return enableAggregationCache(0l);
    }


    public TicketRequest<T> propagateAggregationCache(long cacheExpiredMillis){
        super.propagateAggregationCache(cacheExpiredMillis);
        return this;
    }

    public TicketRequest<T> appendSearchCriteria(SearchCriteria searchCriteria){
        return (TicketRequest<T>)super.appendSearchCriteria(searchCriteria);
    }

    public TicketRequest<T> filter(String property1, Operator operator, String property2){
        return appendSearchCriteria(new TwoOperatorCriteria(operator, new PropertyReference(property1), new PropertyReference(property2)));
    }


    public TicketRequest<T> matchingAnyOf(TicketRequest ticket){
        super.internalMatchAny(ticket);
        return this;
    }

    public TicketRequest<T> enhanceChildrenIfNeeded(){
        return this;
    }

    public TicketRequest<T> withDeletedRows(){
        super.withDeletedRows();
        return this;
    }

    public TicketRequest<T> deletedRowsOnly(){
        super.deletedRowsOnly();
        return this;
    }

    public TicketRequest<T> selectSelf(){
        super.selectSelf();
        return selectId().selectDescription().selectCreatedAt().selectCustomerIdOnly().selectPriority().selectStatus().selectSubject().selectCreateTime().selectUpdateTime().selectVersion();
    }

    public TicketRequest<T> selectSelfFields(){
        return selectSelf();
    }

    public TicketRequest<T> selectAll(){
        super.selectAll();
        return selectId().selectDescription().selectCreatedAt().selectCustomer().selectPriority().selectStatus().selectSubject().selectCreateTime().selectUpdateTime().selectVersion();
    }

    public TicketRequest<T> selectChildren(){
        super.selectAny();
        selectTicketCommentList();
        return selectId().selectDescription().selectCreatedAt().selectCustomer().selectPriority().selectStatus().selectSubject().selectCreateTime().selectUpdateTime().selectVersion();
    }


    public TicketRequest<T> selectId(){
       selectProperty(Ticket.ID_PROPERTY);
       return this;
    }

    /**
     * fill the id with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  id) to fetch id property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public TicketRequest<T> unselectId(){
       unselectProperty(Ticket.ID_PROPERTY);
       return this;
    }
    public TicketRequest<T> selectDescription(){
       selectProperty(Ticket.DESCRIPTION_PROPERTY);
       return this;
    }

    /**
     * fill the description with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  description) to fetch description property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public TicketRequest<T> unselectDescription(){
       unselectProperty(Ticket.DESCRIPTION_PROPERTY);
       return this;
    }
    public TicketRequest<T> selectCreatedAt(){
       selectProperty(Ticket.CREATED_AT_PROPERTY);
       return this;
    }

    /**
     * fill the createdAt with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  createdAt) to fetch createdAt property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public TicketRequest<T> unselectCreatedAt(){
       unselectProperty(Ticket.CREATED_AT_PROPERTY);
       return this;
    }
    public TicketRequest<T> selectCustomerIdOnly(){
       selectProperty(Ticket.CUSTOMER_PROPERTY);
       return this;
    }

    public TicketRequest<T> selectCustomer(){
        return selectCustomerWith(Q.customers().unlimited().selectSelf());
    }

    public TicketRequest<T> selectCustomerWith(CustomerRequest customer){
       selectProperty(Ticket.CUSTOMER_PROPERTY);
       enhanceRelation(Ticket.CUSTOMER_PROPERTY, customer);
       return this;
    }

    public TicketRequest<T> unselectCustomer(){
       unselectProperty(Ticket.CUSTOMER_PROPERTY);
       return this;
    }
    public TicketRequest<T> selectPriority(){
       selectProperty(Ticket.PRIORITY_PROPERTY);
       return this;
    }

    /**
     * fill the priority with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  priority) to fetch priority property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public TicketRequest<T> unselectPriority(){
       unselectProperty(Ticket.PRIORITY_PROPERTY);
       return this;
    }
    public TicketRequest<T> selectStatus(){
       selectProperty(Ticket.STATUS_PROPERTY);
       return this;
    }

    /**
     * fill the status with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  status) to fetch status property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public TicketRequest<T> unselectStatus(){
       unselectProperty(Ticket.STATUS_PROPERTY);
       return this;
    }
    public TicketRequest<T> selectSubject(){
       selectProperty(Ticket.SUBJECT_PROPERTY);
       return this;
    }

    /**
     * fill the subject with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  subject) to fetch subject property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public TicketRequest<T> unselectSubject(){
       unselectProperty(Ticket.SUBJECT_PROPERTY);
       return this;
    }
    public TicketRequest<T> selectCreateTime(){
       selectProperty(Ticket.CREATE_TIME_PROPERTY);
       return this;
    }

    /**
     * fill the createTime with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  createTime) to fetch createTime property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public TicketRequest<T> unselectCreateTime(){
       unselectProperty(Ticket.CREATE_TIME_PROPERTY);
       return this;
    }
    public TicketRequest<T> selectUpdateTime(){
       selectProperty(Ticket.UPDATE_TIME_PROPERTY);
       return this;
    }

    /**
     * fill the updateTime with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  updateTime) to fetch updateTime property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public TicketRequest<T> unselectUpdateTime(){
       unselectProperty(Ticket.UPDATE_TIME_PROPERTY);
       return this;
    }
    public TicketRequest<T> selectVersion(){
       selectProperty(Ticket.VERSION_PROPERTY);
       return this;
    }

    /**
     * fill the version with customized rawSqlSegment, TEAQL uses ({rawSqlSegment} AS  version) to fetch version property.
     * @param rawSqlSegment  customized rawSqlSegment
     */




    public TicketRequest<T> unselectVersion(){
       unselectProperty(Ticket.VERSION_PROPERTY);
       return this;
    }
    public TicketRequest<T> selectTicketCommentList(){
       return selectTicketCommentListWith(Q.ticketComments().selectSelf());
    }

    public TicketRequest<T> selectTicketCommentListWith(TicketCommentRequest ticketCommentList){
       enhanceRelation(Ticket.TICKET_COMMENT_LIST_PROPERTY, ticketCommentList);
       return this;
    }

    public TicketRequest<T> withId(Operator operator, Object... values){
       return appendSearchCriteria(createIdCriteria(operator, values));
    }

    public SearchCriteria createIdCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Ticket.ID_PROPERTY, operator, values);
    }

    public TicketRequest<T> withIdIs(Long id){
       return withId(Operator.EQUAL, id);
    }
    public TicketRequest<T> withIdIn(Long... id){
       return withId(Operator.EQUAL, (Object[])id);
    }



    public TicketRequest<T> filterByDescription(String... description){
      if (description == null || description.length == 0) {
        throw new IllegalArgumentException("filterByDescription parameter description cannot be empty");
      }
      return appendSearchCriteria(createDescriptionCriteria(Operator.EQUAL, (Object[])description));
    }

    public TicketRequest<T> withDescription(Operator operator, Object... values){
       return appendSearchCriteria(createDescriptionCriteria(operator, values));
    }

    public TicketRequest<T> withDescriptionIsUnknown(){
       return withDescription(Operator.IS_NULL);
    }

    public TicketRequest<T> withDescriptionIsKnown(){
       return withDescription(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createDescriptionCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Ticket.DESCRIPTION_PROPERTY, operator, values);
    }

    public TicketRequest<T> withDescriptionGreaterThan(String description){
       return withDescription(Operator.GREATER_THAN, description);
    }

    public TicketRequest<T> withDescriptionGreaterThanOrEqualTo(String description){
       return withDescription(Operator.GREATER_THAN_OR_EQUAL, description);
    }

    public TicketRequest<T> withDescriptionLessThan(String description){
       return withDescription(Operator.LESS_THAN, description);
    }

    public TicketRequest<T> withDescriptionLessThanOrEqualTo(String description){
       return withDescription(Operator.LESS_THAN_OR_EQUAL, description);
    }

    public TicketRequest<T> withDescriptionBetween(String startOfDescription, String endOfDescription){
       return withDescription(Operator.BETWEEN, startOfDescription, endOfDescription);
    }
    public TicketRequest<T> withDescriptionStartingWith(String description){
       return withDescription(Operator.BEGIN_WITH, description);
    }
    public TicketRequest<T> withDescriptionContaining(String description){
       return withDescription(Operator.CONTAIN, description);
    }

    public TicketRequest<T> withDescriptionEndingWith(String description){
       return withDescription(Operator.END_WITH, description);
    }

    public TicketRequest<T> withDescriptionIs(String description){
       return withDescription(Operator.EQUAL, description);
    }

    public TicketRequest<T> withDescriptionSoundingLike(String description){
       return withDescription(Operator.SOUNDS_LIKE, description);
    }



    public TicketRequest<T> filterByCreatedAt(LocalDateTime... createdAt){
      if (createdAt == null || createdAt.length == 0) {
        throw new IllegalArgumentException("filterByCreatedAt parameter createdAt cannot be empty");
      }
      return appendSearchCriteria(createCreatedAtCriteria(Operator.EQUAL, (Object[])createdAt));
    }

    public TicketRequest<T> withCreatedAt(Operator operator, Object... values){
       return appendSearchCriteria(createCreatedAtCriteria(operator, values));
    }

    public TicketRequest<T> withCreatedAtIsUnknown(){
       return withCreatedAt(Operator.IS_NULL);
    }

    public TicketRequest<T> withCreatedAtIsKnown(){
       return withCreatedAt(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createCreatedAtCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Ticket.CREATED_AT_PROPERTY, operator, values);
    }

    public TicketRequest<T> withCreatedAtGreaterThan(LocalDateTime createdAt){
       return withCreatedAt(Operator.GREATER_THAN, createdAt);
    }

    public TicketRequest<T> withCreatedAtGreaterThanOrEqualTo(LocalDateTime createdAt){
       return withCreatedAt(Operator.GREATER_THAN_OR_EQUAL, createdAt);
    }

    public TicketRequest<T> withCreatedAtLessThan(LocalDateTime createdAt){
       return withCreatedAt(Operator.LESS_THAN, createdAt);
    }

    public TicketRequest<T> withCreatedAtLessThanOrEqualTo(LocalDateTime createdAt){
       return withCreatedAt(Operator.LESS_THAN_OR_EQUAL, createdAt);
    }

    public TicketRequest<T> withCreatedAtBetween(LocalDateTime startOfCreatedAt, LocalDateTime endOfCreatedAt){
       return withCreatedAt(Operator.BETWEEN, startOfCreatedAt, endOfCreatedAt);
    }
    public TicketRequest<T> withCreatedAtBefore(LocalDateTime createdAt){
       return withCreatedAt(Operator.LESS_THAN, createdAt);
    }

    public TicketRequest<T> withCreatedAtBefore(Date createdAt){
       return withCreatedAt(Operator.LESS_THAN, createdAt);
    }

    public TicketRequest<T> withCreatedAtAfter(LocalDateTime createdAt){
       return withCreatedAt(Operator.GREATER_THAN, createdAt);
    }

    public TicketRequest<T> withCreatedAtAfter(Date createdAt){
       return withCreatedAt(Operator.GREATER_THAN, createdAt);
    }

    public TicketRequest<T> withCreatedAtBetween(Date startOfCreatedAt, Date endOfCreatedAt){
       return withCreatedAt(Operator.BETWEEN, startOfCreatedAt, endOfCreatedAt);
    }




    public TicketRequest<T> filterByCustomer(Customer... customer){
      if (customer == null || customer.length == 0) {
        throw new IllegalArgumentException("filterByCustomer parameter customer cannot be empty");
      }
      return appendSearchCriteria(createCustomerCriteria(Operator.EQUAL, (Object[])customer));
    }

    public TicketRequest<T> withCustomer(Operator operator, Object... values){
       return appendSearchCriteria(createCustomerCriteria(operator, values));
    }

    public TicketRequest<T> withCustomerIsUnknown(){
       return withCustomer(Operator.IS_NULL);
    }

    public TicketRequest<T> withCustomerIsKnown(){
       return withCustomer(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createCustomerCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Ticket.CUSTOMER_PROPERTY, operator, values);
    }

    public TicketRequest<T> filterByCustomer(Long customer){
      if(customer == null){
         return this;
      }
      return withCustomer(Operator.EQUAL, customer);
    }
    public TicketRequest<T> withCustomerMatching(CustomerRequest customer){
       return appendSearchCriteria(new SubQuerySearchCriteria(Ticket.CUSTOMER_PROPERTY, customer, Customer.ID_PROPERTY));
    }

    public TicketRequest<T> filterByPriority(String... priority){
      if (priority == null || priority.length == 0) {
        throw new IllegalArgumentException("filterByPriority parameter priority cannot be empty");
      }
      return appendSearchCriteria(createPriorityCriteria(Operator.EQUAL, (Object[])priority));
    }

    public TicketRequest<T> withPriority(Operator operator, Object... values){
       return appendSearchCriteria(createPriorityCriteria(operator, values));
    }

    public TicketRequest<T> withPriorityIsUnknown(){
       return withPriority(Operator.IS_NULL);
    }

    public TicketRequest<T> withPriorityIsKnown(){
       return withPriority(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createPriorityCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Ticket.PRIORITY_PROPERTY, operator, values);
    }

    public TicketRequest<T> withPriorityGreaterThan(String priority){
       return withPriority(Operator.GREATER_THAN, priority);
    }

    public TicketRequest<T> withPriorityGreaterThanOrEqualTo(String priority){
       return withPriority(Operator.GREATER_THAN_OR_EQUAL, priority);
    }

    public TicketRequest<T> withPriorityLessThan(String priority){
       return withPriority(Operator.LESS_THAN, priority);
    }

    public TicketRequest<T> withPriorityLessThanOrEqualTo(String priority){
       return withPriority(Operator.LESS_THAN_OR_EQUAL, priority);
    }

    public TicketRequest<T> withPriorityBetween(String startOfPriority, String endOfPriority){
       return withPriority(Operator.BETWEEN, startOfPriority, endOfPriority);
    }
    public TicketRequest<T> withPriorityStartingWith(String priority){
       return withPriority(Operator.BEGIN_WITH, priority);
    }
    public TicketRequest<T> withPriorityContaining(String priority){
       return withPriority(Operator.CONTAIN, priority);
    }

    public TicketRequest<T> withPriorityEndingWith(String priority){
       return withPriority(Operator.END_WITH, priority);
    }

    public TicketRequest<T> withPriorityIs(String priority){
       return withPriority(Operator.EQUAL, priority);
    }

    public TicketRequest<T> withPrioritySoundingLike(String priority){
       return withPriority(Operator.SOUNDS_LIKE, priority);
    }



    public TicketRequest<T> filterByStatus(String... status){
      if (status == null || status.length == 0) {
        throw new IllegalArgumentException("filterByStatus parameter status cannot be empty");
      }
      return appendSearchCriteria(createStatusCriteria(Operator.EQUAL, (Object[])status));
    }

    public TicketRequest<T> withStatus(Operator operator, Object... values){
       return appendSearchCriteria(createStatusCriteria(operator, values));
    }

    public TicketRequest<T> withStatusIsUnknown(){
       return withStatus(Operator.IS_NULL);
    }

    public TicketRequest<T> withStatusIsKnown(){
       return withStatus(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createStatusCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Ticket.STATUS_PROPERTY, operator, values);
    }

    public TicketRequest<T> withStatusGreaterThan(String status){
       return withStatus(Operator.GREATER_THAN, status);
    }

    public TicketRequest<T> withStatusGreaterThanOrEqualTo(String status){
       return withStatus(Operator.GREATER_THAN_OR_EQUAL, status);
    }

    public TicketRequest<T> withStatusLessThan(String status){
       return withStatus(Operator.LESS_THAN, status);
    }

    public TicketRequest<T> withStatusLessThanOrEqualTo(String status){
       return withStatus(Operator.LESS_THAN_OR_EQUAL, status);
    }

    public TicketRequest<T> withStatusBetween(String startOfStatus, String endOfStatus){
       return withStatus(Operator.BETWEEN, startOfStatus, endOfStatus);
    }
    public TicketRequest<T> withStatusStartingWith(String status){
       return withStatus(Operator.BEGIN_WITH, status);
    }
    public TicketRequest<T> withStatusContaining(String status){
       return withStatus(Operator.CONTAIN, status);
    }

    public TicketRequest<T> withStatusEndingWith(String status){
       return withStatus(Operator.END_WITH, status);
    }

    public TicketRequest<T> withStatusIs(String status){
       return withStatus(Operator.EQUAL, status);
    }

    public TicketRequest<T> withStatusSoundingLike(String status){
       return withStatus(Operator.SOUNDS_LIKE, status);
    }



    public TicketRequest<T> filterBySubject(String... subject){
      if (subject == null || subject.length == 0) {
        throw new IllegalArgumentException("filterBySubject parameter subject cannot be empty");
      }
      return appendSearchCriteria(createSubjectCriteria(Operator.EQUAL, (Object[])subject));
    }

    public TicketRequest<T> withSubject(Operator operator, Object... values){
       return appendSearchCriteria(createSubjectCriteria(operator, values));
    }

    public TicketRequest<T> withSubjectIsUnknown(){
       return withSubject(Operator.IS_NULL);
    }

    public TicketRequest<T> withSubjectIsKnown(){
       return withSubject(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createSubjectCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Ticket.SUBJECT_PROPERTY, operator, values);
    }

    public TicketRequest<T> withSubjectGreaterThan(String subject){
       return withSubject(Operator.GREATER_THAN, subject);
    }

    public TicketRequest<T> withSubjectGreaterThanOrEqualTo(String subject){
       return withSubject(Operator.GREATER_THAN_OR_EQUAL, subject);
    }

    public TicketRequest<T> withSubjectLessThan(String subject){
       return withSubject(Operator.LESS_THAN, subject);
    }

    public TicketRequest<T> withSubjectLessThanOrEqualTo(String subject){
       return withSubject(Operator.LESS_THAN_OR_EQUAL, subject);
    }

    public TicketRequest<T> withSubjectBetween(String startOfSubject, String endOfSubject){
       return withSubject(Operator.BETWEEN, startOfSubject, endOfSubject);
    }
    public TicketRequest<T> withSubjectStartingWith(String subject){
       return withSubject(Operator.BEGIN_WITH, subject);
    }
    public TicketRequest<T> withSubjectContaining(String subject){
       return withSubject(Operator.CONTAIN, subject);
    }

    public TicketRequest<T> withSubjectEndingWith(String subject){
       return withSubject(Operator.END_WITH, subject);
    }

    public TicketRequest<T> withSubjectIs(String subject){
       return withSubject(Operator.EQUAL, subject);
    }

    public TicketRequest<T> withSubjectSoundingLike(String subject){
       return withSubject(Operator.SOUNDS_LIKE, subject);
    }



    public TicketRequest<T> filterByCreateTime(LocalDateTime... createTime){
      if (createTime == null || createTime.length == 0) {
        throw new IllegalArgumentException("filterByCreateTime parameter createTime cannot be empty");
      }
      return appendSearchCriteria(createCreateTimeCriteria(Operator.EQUAL, (Object[])createTime));
    }

    public TicketRequest<T> withCreateTime(Operator operator, Object... values){
       return appendSearchCriteria(createCreateTimeCriteria(operator, values));
    }

    public TicketRequest<T> withCreateTimeIsUnknown(){
       return withCreateTime(Operator.IS_NULL);
    }

    public TicketRequest<T> withCreateTimeIsKnown(){
       return withCreateTime(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createCreateTimeCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Ticket.CREATE_TIME_PROPERTY, operator, values);
    }

    public TicketRequest<T> withCreateTimeGreaterThan(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public TicketRequest<T> withCreateTimeGreaterThanOrEqualTo(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN_OR_EQUAL, createTime);
    }

    public TicketRequest<T> withCreateTimeLessThan(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public TicketRequest<T> withCreateTimeLessThanOrEqualTo(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN_OR_EQUAL, createTime);
    }

    public TicketRequest<T> withCreateTimeBetween(LocalDateTime startOfCreateTime, LocalDateTime endOfCreateTime){
       return withCreateTime(Operator.BETWEEN, startOfCreateTime, endOfCreateTime);
    }
    public TicketRequest<T> withCreateTimeBefore(LocalDateTime createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public TicketRequest<T> withCreateTimeBefore(Date createTime){
       return withCreateTime(Operator.LESS_THAN, createTime);
    }

    public TicketRequest<T> withCreateTimeAfter(LocalDateTime createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public TicketRequest<T> withCreateTimeAfter(Date createTime){
       return withCreateTime(Operator.GREATER_THAN, createTime);
    }

    public TicketRequest<T> withCreateTimeBetween(Date startOfCreateTime, Date endOfCreateTime){
       return withCreateTime(Operator.BETWEEN, startOfCreateTime, endOfCreateTime);
    }




    public TicketRequest<T> filterByUpdateTime(LocalDateTime... updateTime){
      if (updateTime == null || updateTime.length == 0) {
        throw new IllegalArgumentException("filterByUpdateTime parameter updateTime cannot be empty");
      }
      return appendSearchCriteria(createUpdateTimeCriteria(Operator.EQUAL, (Object[])updateTime));
    }

    public TicketRequest<T> withUpdateTime(Operator operator, Object... values){
       return appendSearchCriteria(createUpdateTimeCriteria(operator, values));
    }

    public TicketRequest<T> withUpdateTimeIsUnknown(){
       return withUpdateTime(Operator.IS_NULL);
    }

    public TicketRequest<T> withUpdateTimeIsKnown(){
       return withUpdateTime(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createUpdateTimeCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Ticket.UPDATE_TIME_PROPERTY, operator, values);
    }

    public TicketRequest<T> withUpdateTimeGreaterThan(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public TicketRequest<T> withUpdateTimeGreaterThanOrEqualTo(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN_OR_EQUAL, updateTime);
    }

    public TicketRequest<T> withUpdateTimeLessThan(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public TicketRequest<T> withUpdateTimeLessThanOrEqualTo(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN_OR_EQUAL, updateTime);
    }

    public TicketRequest<T> withUpdateTimeBetween(LocalDateTime startOfUpdateTime, LocalDateTime endOfUpdateTime){
       return withUpdateTime(Operator.BETWEEN, startOfUpdateTime, endOfUpdateTime);
    }
    public TicketRequest<T> withUpdateTimeBefore(LocalDateTime updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public TicketRequest<T> withUpdateTimeBefore(Date updateTime){
       return withUpdateTime(Operator.LESS_THAN, updateTime);
    }

    public TicketRequest<T> withUpdateTimeAfter(LocalDateTime updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public TicketRequest<T> withUpdateTimeAfter(Date updateTime){
       return withUpdateTime(Operator.GREATER_THAN, updateTime);
    }

    public TicketRequest<T> withUpdateTimeBetween(Date startOfUpdateTime, Date endOfUpdateTime){
       return withUpdateTime(Operator.BETWEEN, startOfUpdateTime, endOfUpdateTime);
    }




    public TicketRequest<T> filterByVersion(Long... version){
      if (version == null || version.length == 0) {
        throw new IllegalArgumentException("filterByVersion parameter version cannot be empty");
      }
      return appendSearchCriteria(createVersionCriteria(Operator.EQUAL, (Object[])version));
    }

    public TicketRequest<T> withVersion(Operator operator, Object... values){
       return appendSearchCriteria(createVersionCriteria(operator, values));
    }

    public TicketRequest<T> withVersionIsUnknown(){
       return withVersion(Operator.IS_NULL);
    }

    public TicketRequest<T> withVersionIsKnown(){
       return withVersion(Operator.IS_NOT_NULL);
    }

    public SearchCriteria createVersionCriteria(Operator operator, Object... values) {
        return createBasicSearchCriteria(Ticket.VERSION_PROPERTY, operator, values);
    }

    public TicketRequest<T> withVersionGreaterThan(Long version){
       return withVersion(Operator.GREATER_THAN, version);
    }

    public TicketRequest<T> withVersionGreaterThanOrEqualTo(Long version){
       return withVersion(Operator.GREATER_THAN_OR_EQUAL, version);
    }

    public TicketRequest<T> withVersionLessThan(Long version){
       return withVersion(Operator.LESS_THAN, version);
    }

    public TicketRequest<T> withVersionLessThanOrEqualTo(Long version){
       return withVersion(Operator.LESS_THAN_OR_EQUAL, version);
    }

    public TicketRequest<T> withVersionBetween(Long startOfVersion, Long endOfVersion){
       return withVersion(Operator.BETWEEN, startOfVersion, endOfVersion);
    }

    public TicketRequest<T> withTicketCommentListMatching(TicketCommentRequest ticketCommentRequest){
        return appendSearchCriteria(new SubQuerySearchCriteria(Ticket.ID_PROPERTY, ticketCommentRequest, TicketComment.TICKET_PROPERTY));
    }

    public TicketRequest<T> withoutTicketCommentListMatching(TicketCommentRequest ticketCommentRequest){
        return appendSearchCriteria(SearchCriteria.not(new SubQuerySearchCriteria(Ticket.ID_PROPERTY, ticketCommentRequest, TicketComment.TICKET_PROPERTY)));
    }

    public TicketRequest<T> haveTicketComments(){
        return withTicketCommentListMatching(Q.ticketComments().unlimited());
    }

    public TicketRequest<T> haveNoTicketComments(){
        return withoutTicketCommentListMatching(Q.ticketComments().unlimited());
    }

    public TicketRequest<T> count(){
        super.count();
        return this;
    }
    public TicketRequest<T> countAs(String retName){
        super.count(retName);
        return this;
    }
    public TicketRequest<T> groupByCustomerWithDetails(){
       return groupByCustomerWithDetails(Q.customers().unlimited());
    }

    public TicketRequest<T> groupByCustomerWithDetails(CustomerRequest subRequest){
       aggregate(Ticket.CUSTOMER_PROPERTY, subRequest);
       return this;
    }







    public TicketRequest<T> groupByTicketCommentsWithDetails(TicketCommentRequest subRequest){
       aggregate(Ticket.TICKET_COMMENT_LIST_PROPERTY, subRequest);
       return this;
    }

    public TicketRequest<T> groupById(){
       groupBy(Ticket.ID_PROPERTY);
       return this;
    }

    public TicketRequest<T> groupByIdAs(String retName){
       groupBy(retName, Ticket.ID_PROPERTY);
       return this;
    }

    public TicketRequest<T> groupByIdWithFunction(String retName, AggrFunction function){
       groupBy(retName, Ticket.ID_PROPERTY, function);
       return this;
    }

    public TicketRequest<T> groupByDescription(){
       groupBy(Ticket.DESCRIPTION_PROPERTY);
       return this;
    }

    public TicketRequest<T> groupByDescriptionAs(String retName){
       groupBy(retName, Ticket.DESCRIPTION_PROPERTY);
       return this;
    }

    public TicketRequest<T> groupByDescriptionWithFunction(String retName, AggrFunction function){
       groupBy(retName, Ticket.DESCRIPTION_PROPERTY, function);
       return this;
    }

    public TicketRequest<T> groupByCreatedAt(){
       groupBy(Ticket.CREATED_AT_PROPERTY);
       return this;
    }

    public TicketRequest<T> groupByCreatedAtAs(String retName){
       groupBy(retName, Ticket.CREATED_AT_PROPERTY);
       return this;
    }

    public TicketRequest<T> groupByCreatedAtWithFunction(String retName, AggrFunction function){
       groupBy(retName, Ticket.CREATED_AT_PROPERTY, function);
       return this;
    }
    public TicketRequest<T> groupByCustomerWith(CustomerRequest subRequest){
       groupBy(Ticket.CUSTOMER_PROPERTY, subRequest);
       return this;
    }
    public TicketRequest<T> groupByCustomer(){
       groupBy(Ticket.CUSTOMER_PROPERTY);
       return this;
    }

    public TicketRequest<T> groupByCustomerAs(String retName){
       groupBy(retName, Ticket.CUSTOMER_PROPERTY);
       return this;
    }

    public TicketRequest<T> groupByCustomerWithFunction(String retName, AggrFunction function){
       groupBy(retName, Ticket.CUSTOMER_PROPERTY, function);
       return this;
    }

    public TicketRequest<T> groupByPriority(){
       groupBy(Ticket.PRIORITY_PROPERTY);
       return this;
    }

    public TicketRequest<T> groupByPriorityAs(String retName){
       groupBy(retName, Ticket.PRIORITY_PROPERTY);
       return this;
    }

    public TicketRequest<T> groupByPriorityWithFunction(String retName, AggrFunction function){
       groupBy(retName, Ticket.PRIORITY_PROPERTY, function);
       return this;
    }

    public TicketRequest<T> groupByStatus(){
       groupBy(Ticket.STATUS_PROPERTY);
       return this;
    }

    public TicketRequest<T> groupByStatusAs(String retName){
       groupBy(retName, Ticket.STATUS_PROPERTY);
       return this;
    }

    public TicketRequest<T> groupByStatusWithFunction(String retName, AggrFunction function){
       groupBy(retName, Ticket.STATUS_PROPERTY, function);
       return this;
    }

    public TicketRequest<T> groupBySubject(){
       groupBy(Ticket.SUBJECT_PROPERTY);
       return this;
    }

    public TicketRequest<T> groupBySubjectAs(String retName){
       groupBy(retName, Ticket.SUBJECT_PROPERTY);
       return this;
    }

    public TicketRequest<T> groupBySubjectWithFunction(String retName, AggrFunction function){
       groupBy(retName, Ticket.SUBJECT_PROPERTY, function);
       return this;
    }

    public TicketRequest<T> groupByCreateTime(){
       groupBy(Ticket.CREATE_TIME_PROPERTY);
       return this;
    }

    public TicketRequest<T> groupByCreateTimeAs(String retName){
       groupBy(retName, Ticket.CREATE_TIME_PROPERTY);
       return this;
    }

    public TicketRequest<T> groupByCreateTimeWithFunction(String retName, AggrFunction function){
       groupBy(retName, Ticket.CREATE_TIME_PROPERTY, function);
       return this;
    }

    public TicketRequest<T> groupByUpdateTime(){
       groupBy(Ticket.UPDATE_TIME_PROPERTY);
       return this;
    }

    public TicketRequest<T> groupByUpdateTimeAs(String retName){
       groupBy(retName, Ticket.UPDATE_TIME_PROPERTY);
       return this;
    }

    public TicketRequest<T> groupByUpdateTimeWithFunction(String retName, AggrFunction function){
       groupBy(retName, Ticket.UPDATE_TIME_PROPERTY, function);
       return this;
    }

    public TicketRequest<T> groupByVersion(){
       groupBy(Ticket.VERSION_PROPERTY);
       return this;
    }

    public TicketRequest<T> groupByVersionAs(String retName){
       groupBy(retName, Ticket.VERSION_PROPERTY);
       return this;
    }

    public TicketRequest<T> groupByVersionWithFunction(String retName, AggrFunction function){
       groupBy(retName, Ticket.VERSION_PROPERTY, function);
       return this;
    }



    public TicketRequest<T> orderByIdAscending(){
       addOrderByAscending(Ticket.ID_PROPERTY);
       return this;
    }

    public TicketRequest<T> orderByIdDescending(){
       addOrderByDescending(Ticket.ID_PROPERTY);
       return this;
    }

    public TicketRequest<T> orderByDescriptionAscending(){
       addOrderByAscending(Ticket.DESCRIPTION_PROPERTY);
       return this;
    }

    public TicketRequest<T> orderByDescriptionDescending(){
       addOrderByDescending(Ticket.DESCRIPTION_PROPERTY);
       return this;
    }
    public TicketRequest<T> orderByDescriptionAscendingUsingGBK(){
       addOrderByAscendingUsingGBK(Ticket.DESCRIPTION_PROPERTY);
       return this;
    }

    public TicketRequest<T> orderByDescriptionDescendingUsingGBK(){
       addOrderByDescendingUsingGBK(Ticket.DESCRIPTION_PROPERTY);
       return this;
    }
    public TicketRequest<T> orderByCreatedAtAscending(){
       addOrderByAscending(Ticket.CREATED_AT_PROPERTY);
       return this;
    }

    public TicketRequest<T> orderByCreatedAtDescending(){
       addOrderByDescending(Ticket.CREATED_AT_PROPERTY);
       return this;
    }

    public TicketRequest<T> orderByCustomerAscending(){
       addOrderByAscending(Ticket.CUSTOMER_PROPERTY);
       return this;
    }

    public TicketRequest<T> orderByCustomerDescending(){
       addOrderByDescending(Ticket.CUSTOMER_PROPERTY);
       return this;
    }

    public TicketRequest<T> orderByPriorityAscending(){
       addOrderByAscending(Ticket.PRIORITY_PROPERTY);
       return this;
    }

    public TicketRequest<T> orderByPriorityDescending(){
       addOrderByDescending(Ticket.PRIORITY_PROPERTY);
       return this;
    }
    public TicketRequest<T> orderByPriorityAscendingUsingGBK(){
       addOrderByAscendingUsingGBK(Ticket.PRIORITY_PROPERTY);
       return this;
    }

    public TicketRequest<T> orderByPriorityDescendingUsingGBK(){
       addOrderByDescendingUsingGBK(Ticket.PRIORITY_PROPERTY);
       return this;
    }
    public TicketRequest<T> orderByStatusAscending(){
       addOrderByAscending(Ticket.STATUS_PROPERTY);
       return this;
    }

    public TicketRequest<T> orderByStatusDescending(){
       addOrderByDescending(Ticket.STATUS_PROPERTY);
       return this;
    }
    public TicketRequest<T> orderByStatusAscendingUsingGBK(){
       addOrderByAscendingUsingGBK(Ticket.STATUS_PROPERTY);
       return this;
    }

    public TicketRequest<T> orderByStatusDescendingUsingGBK(){
       addOrderByDescendingUsingGBK(Ticket.STATUS_PROPERTY);
       return this;
    }
    public TicketRequest<T> orderBySubjectAscending(){
       addOrderByAscending(Ticket.SUBJECT_PROPERTY);
       return this;
    }

    public TicketRequest<T> orderBySubjectDescending(){
       addOrderByDescending(Ticket.SUBJECT_PROPERTY);
       return this;
    }
    public TicketRequest<T> orderBySubjectAscendingUsingGBK(){
       addOrderByAscendingUsingGBK(Ticket.SUBJECT_PROPERTY);
       return this;
    }

    public TicketRequest<T> orderBySubjectDescendingUsingGBK(){
       addOrderByDescendingUsingGBK(Ticket.SUBJECT_PROPERTY);
       return this;
    }
    public TicketRequest<T> orderByCreateTimeAscending(){
       addOrderByAscending(Ticket.CREATE_TIME_PROPERTY);
       return this;
    }

    public TicketRequest<T> orderByCreateTimeDescending(){
       addOrderByDescending(Ticket.CREATE_TIME_PROPERTY);
       return this;
    }

    public TicketRequest<T> orderByUpdateTimeAscending(){
       addOrderByAscending(Ticket.UPDATE_TIME_PROPERTY);
       return this;
    }

    public TicketRequest<T> orderByUpdateTimeDescending(){
       addOrderByDescending(Ticket.UPDATE_TIME_PROPERTY);
       return this;
    }

    public TicketRequest<T> orderByVersionAscending(){
       addOrderByAscending(Ticket.VERSION_PROPERTY);
       return this;
    }

    public TicketRequest<T> orderByVersionDescending(){
       addOrderByDescending(Ticket.VERSION_PROPERTY);
       return this;
    }


    public TicketRequest<T> statsFromTicketCommentsAs(String name, TicketCommentRequest subRequest){
       return statsFromTicketCommentsAs(name, subRequest, false);
    }

    public TicketRequest<T> statsFromTicketCommentsAs(String name, TicketCommentRequest subRequest, boolean singleResult){
       subRequest.setPartitionProperty(TicketComment.TICKET_PROPERTY);
       addAggregateDynamicProperty(name, subRequest, singleResult);
       return this;
    }

    public TicketRequest<T> statsFromTicketComments(TicketCommentRequest subRequest){
       return statsFromTicketCommentsAs(REFINEMENTS, subRequest);
    }
    public CustomerRequest rollUpToCustomer(){
       CustomerRequest customer = Q.customers().unlimited();
       this.withCustomerMatching(customer)
           .groupByCustomerWith(customer);
       return customer;
    }







    public TicketRequest<T> countTicketComments(){
        return countTicketCommentsAs("Count");
    }

    public TicketRequest<T> countTicketCommentsAs(String name){
        return countTicketCommentsWith(name, Q.ticketComments().unlimited());
    }

    public TicketRequest<T> countTicketCommentsWith(String name, TicketCommentRequest subRequest){
        return statsFromTicketCommentsAs(name, subRequest.count(), true);
    }

   public TicketRequest<T> facetByCustomerAs(String facetName, CustomerRequest customer){
       return facetByCustomerAs(facetName, customer, true);
   }

   public TicketRequest<T> facetByCustomerAs(String facetName, CustomerRequest customer, boolean includeAllFacets){
       addFacet(facetName, Ticket.CUSTOMER_PROPERTY, customer, includeAllFacets);
       return this;
   }


    /**
     * get topN records
     * @param topN  records number
     */
    public TicketRequest<T> top(int topN) {
        super.top(topN);
        return this;
    }

    /**
     * get records from offset(inclusive) to offset+size(exclusive)
     * @param offset record offset
     * @param size records number
     */
    public TicketRequest<T> offset(int offset, int size) {
        super.offset(offset, size);
        return this;
    }

    /**
     * retrieve all records
     */
    public TicketRequest<T> unlimited() {
        super.unlimited();
        return this;
    }

    /**
     * get records of one page
     * @param pageNumber page number(1-based)
     * @param pageSize page size
     */
    public TicketRequest<T> page(int pageNumber, int pageSize) {
        int offset = (pageNumber - 1) * pageSize;
        return offset(offset, pageSize);
   }

    /**
     * get records of one page, default page size is 10
     * @param pageNumber page number(1-based)
     */
    public TicketRequest<T> page(int pageNumber) {
        return page(pageNumber, 10);
   }
}