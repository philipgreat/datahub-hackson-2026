
package com.example.enterpriseerpsystem;

import io.teaql.core.meta.EntityDescriptor;
import io.teaql.core.meta.EntityMetaAssembler;
import io.teaql.core.meta.EntityMetaFactory;
import io.teaql.core.meta.PropertyDescriptor;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class EntityMetaRegistry implements EntityMetaAssembler {
  private EntityMetaFactory $factory;

  @Override
  public void assemble(EntityMetaFactory factory) {
    this.$factory = factory;
    registerDepartment();
    registerEmployee();
    registerPosition();
    registerLeaveRequest();
    registerAttendance();
    registerBenefit();
    registerEmployeeReview();
    registerPayroll();
    registerCustomer();
    registerLead();
    registerOpportunity();
    registerContact();
    registerCampaign();
    registerContract();
    registerQuote();
    registerSalesTerritory();
    registerCategory();
    registerProduct();
    registerCatalog();
    registerProductReview();
    registerShoppingCart();
    registerCartItem();
    registerGlobalOrder();
    registerOrderItem();
    registerWishlist();
    registerPromotion();
    registerCoupon();
    registerInvoice();
    registerPayment();
    registerRefund();
    registerAccount();
    registerTransaction();
    registerTaxRate();
    registerExpense();
    registerLedger();
    registerSupplier();
    registerWarehouse();
    registerInventoryItem();
    registerPurchaseOrder();
    registerPurchaseOrderItem();
    registerShipment();
    registerDelivery();
    registerReturnRequest();
    registerTicket();
    registerTicketComment();
    registerSla();
    registerKnowledgeBase();
    registerSupportAgent();
  }
  private void registerEmployee() {
      EntityDescriptor entityDescriptor = new EntityDescriptor();
      entityDescriptor.setType(com.example.enterpriseerpsystem.employee.Employee.INTERNAL_TYPE);
      entityDescriptor.setTargetType(com.example.enterpriseerpsystem.employee.Employee.class);
      entityDescriptor.setEntitySupplier(com.example.enterpriseerpsystem.employee.Employee::new);
      entityDescriptor.with("name", "Employee")
      .with("module", "HumanResources")
      .with("module_key", "humanresources");

      PropertyDescriptor id = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.employee.Employee.ID_PROPERTY, Long.class)
      ;
      PropertyDescriptor email = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.employee.Employee.EMAIL_PROPERTY, String.class)
      ;
      PropertyDescriptor name = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.employee.Employee.NAME_PROPERTY, String.class)
      ;
      PropertyDescriptor phone = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.employee.Employee.PHONE_PROPERTY, String.class)
      ;
      PropertyDescriptor salary = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.employee.Employee.SALARY_PROPERTY, BigDecimal.class)
      ;
      PropertyDescriptor ssn = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.employee.Employee.SSN_PROPERTY, String.class)
      ;
      PropertyDescriptor department = 
      entityDescriptor.addObjectProperty($factory, com.example.enterpriseerpsystem.employee.Employee.DEPARTMENT_PROPERTY, com.example.enterpriseerpsystem.department.Department.INTERNAL_TYPE, com.example.enterpriseerpsystem.department.Department.EMPLOYEE_LIST_PROPERTY, com.example.enterpriseerpsystem.department.Department.class)
      ;
      PropertyDescriptor hireDate = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.employee.Employee.HIRE_DATE_PROPERTY, LocalDateTime.class)
      ;
      PropertyDescriptor status = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.employee.Employee.STATUS_PROPERTY, String.class)
      ;
      PropertyDescriptor createTime = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.employee.Employee.CREATE_TIME_PROPERTY, LocalDateTime.class)
      ;
      PropertyDescriptor updateTime = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.employee.Employee.UPDATE_TIME_PROPERTY, LocalDateTime.class)
      ;
      PropertyDescriptor version = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.employee.Employee.VERSION_PROPERTY, Long.class)
      ;
      entityDescriptor.findProperty(com.example.enterpriseerpsystem.employee.Employee.ID_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("oracle_sqlType", "number(11)")
      .with("javaType", "java.lang.Long")
      .with("sqlType", "BIGINT")
      .with("isId", "true")
      .with("isBaseEntityField", "true")
      .with("isBool", "false")
      .with("isNumber", "false")
      .with("isString", "false")
      .with("isDate", "false")
      .with("snowflake_sqlType", "number")
      .with("graphqlType", "Long")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.employee.Employee.EMAIL_PROPERTY).with("isPassword", "false")
      .with("max", "100")
      .with("isVersion", "false")
      .with("javaType", "java.lang.String")
      .with("sqlType", "VARCHAR(<max>)")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("isString", "true")
      .with("isDate", "false")
      .with("graphqlType", "String")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.employee.Employee.NAME_PROPERTY).with("isPassword", "false")
      .with("max", "100")
      .with("isVersion", "false")
      .with("javaType", "java.lang.String")
      .with("sqlType", "VARCHAR(<max>)")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("isString", "true")
      .with("isDate", "false")
      .with("graphqlType", "String")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.employee.Employee.PHONE_PROPERTY).with("isPassword", "false")
      .with("max", "100")
      .with("isVersion", "false")
      .with("javaType", "java.lang.String")
      .with("sqlType", "VARCHAR(<max>)")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("isString", "true")
      .with("isDate", "false")
      .with("graphqlType", "String")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.employee.Employee.SALARY_PROPERTY).with("isPassword", "false")
      .with("db2_sqlType", "decimal(19,7)")
      .with("isVersion", "false")
      .with("oracle_sqlType", "number(19,7)")
      .with("javaType", "java.math.BigDecimal")
      .with("sqlType", "NUMERIC(19,7)")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "true")
      .with("isString", "false")
      .with("isDate", "false")
      .with("graphqlType", "BigDecimal")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.employee.Employee.SSN_PROPERTY).with("isPassword", "false")
      .with("max", "100")
      .with("isVersion", "false")
      .with("javaType", "java.lang.String")
      .with("sqlType", "VARCHAR(<max>)")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("isString", "true")
      .with("isDate", "false")
      .with("graphqlType", "String")
      .with("isTime", "false")
      .with("isText", "false");


      entityDescriptor.findProperty(com.example.enterpriseerpsystem.employee.Employee.HIRE_DATE_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("javaType", "java.time.LocalDateTime")
      .with("sqlType", "TIMESTAMP")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("mssql_sqlType", "dateTime")
      .with("isDateTime", "true")
      .with("createFunction", "now")
      .with("isDate", "true")
      .with("isString", "false")
      .with("graphqlType", "LocalTime")
      .with("isTime", "true")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.employee.Employee.STATUS_PROPERTY).with("isPassword", "false")
      .with("max", "100")
      .with("isVersion", "false")
      .with("javaType", "java.lang.String")
      .with("sqlType", "VARCHAR(<max>)")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("isString", "true")
      .with("isDate", "false")
      .with("graphqlType", "String")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.employee.Employee.CREATE_TIME_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("javaType", "java.time.LocalDateTime")
      .with("sqlType", "TIMESTAMP")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("mssql_sqlType", "dateTime")
      .with("isDateTime", "true")
      .with("createFunction", "now")
      .with("isDate", "true")
      .with("isString", "false")
      .with("graphqlType", "LocalTime")
      .with("isTime", "true")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.employee.Employee.UPDATE_TIME_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("updateFunction", "now")
      .with("javaType", "java.time.LocalDateTime")
      .with("sqlType", "TIMESTAMP")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("mssql_sqlType", "dateTime")
      .with("isDateTime", "true")
      .with("createFunction", "now")
      .with("isDate", "true")
      .with("isString", "false")
      .with("graphqlType", "LocalTime")
      .with("isTime", "true")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.employee.Employee.VERSION_PROPERTY).with("isPassword", "false")
      .with("isVersion", "true")
      .with("oracle_sqlType", "number(11)")
      .with("javaType", "java.lang.Long")
      .with("sqlType", "BIGINT")
      .with("isId", "false")
      .with("isBaseEntityField", "true")
      .with("isBool", "false")
      .with("isNumber", "false")
      .with("isString", "false")
      .with("isDate", "false")
      .with("snowflake_sqlType", "number")
      .with("graphqlType", "Long")
      .with("isTime", "false")
      .with("isText", "false");

      $factory.register(entityDescriptor);
  }
  private void registerDepartment() {
      EntityDescriptor entityDescriptor = new EntityDescriptor();
      entityDescriptor.setType(com.example.enterpriseerpsystem.department.Department.INTERNAL_TYPE);
      entityDescriptor.setTargetType(com.example.enterpriseerpsystem.department.Department.class);
      entityDescriptor.setEntitySupplier(com.example.enterpriseerpsystem.department.Department::new);
      entityDescriptor.with("name", "Department")
      .with("module", "HumanResources")
      .with("module_key", "humanresources");

      PropertyDescriptor id = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.department.Department.ID_PROPERTY, Long.class)
      ;
      PropertyDescriptor name = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.department.Department.NAME_PROPERTY, String.class)
      ;
      PropertyDescriptor budget = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.department.Department.BUDGET_PROPERTY, BigDecimal.class)
      ;
      PropertyDescriptor location = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.department.Department.LOCATION_PROPERTY, String.class)
      ;
      PropertyDescriptor managerId = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.department.Department.MANAGER_ID_PROPERTY, String.class)
      ;
      PropertyDescriptor createTime = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.department.Department.CREATE_TIME_PROPERTY, LocalDateTime.class)
      ;
      PropertyDescriptor updateTime = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.department.Department.UPDATE_TIME_PROPERTY, LocalDateTime.class)
      ;
      PropertyDescriptor version = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.department.Department.VERSION_PROPERTY, Long.class)
      ;
      entityDescriptor.findProperty(com.example.enterpriseerpsystem.department.Department.ID_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("oracle_sqlType", "number(11)")
      .with("javaType", "java.lang.Long")
      .with("sqlType", "BIGINT")
      .with("isId", "true")
      .with("isBaseEntityField", "true")
      .with("isBool", "false")
      .with("isNumber", "false")
      .with("isString", "false")
      .with("isDate", "false")
      .with("snowflake_sqlType", "number")
      .with("graphqlType", "Long")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.department.Department.NAME_PROPERTY).with("isPassword", "false")
      .with("max", "100")
      .with("isVersion", "false")
      .with("javaType", "java.lang.String")
      .with("candidates", "name_value")
      .with("sqlType", "VARCHAR(<max>)")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("isString", "true")
      .with("isDate", "false")
      .with("graphqlType", "String")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.department.Department.BUDGET_PROPERTY).with("isPassword", "false")
      .with("db2_sqlType", "decimal(19,7)")
      .with("isVersion", "false")
      .with("oracle_sqlType", "number(19,7)")
      .with("javaType", "java.math.BigDecimal")
      .with("candidates", "100.00")
      .with("sqlType", "NUMERIC(19,7)")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "true")
      .with("isString", "false")
      .with("isDate", "false")
      .with("graphqlType", "BigDecimal")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.department.Department.LOCATION_PROPERTY).with("isPassword", "false")
      .with("max", "100")
      .with("isVersion", "false")
      .with("javaType", "java.lang.String")
      .with("candidates", "location_value")
      .with("sqlType", "VARCHAR(<max>)")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("isString", "true")
      .with("isDate", "false")
      .with("graphqlType", "String")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.department.Department.MANAGER_ID_PROPERTY).with("isPassword", "false")
      .with("max", "100")
      .with("isVersion", "false")
      .with("javaType", "java.lang.String")
      .with("candidates", "manager_id_value")
      .with("sqlType", "VARCHAR(<max>)")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("isString", "true")
      .with("isDate", "false")
      .with("graphqlType", "String")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.department.Department.CREATE_TIME_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("javaType", "java.time.LocalDateTime")
      .with("candidates", "createTime()")
      .with("sqlType", "TIMESTAMP")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("mssql_sqlType", "dateTime")
      .with("isDateTime", "true")
      .with("createFunction", "now")
      .with("isDate", "true")
      .with("isString", "false")
      .with("graphqlType", "LocalTime")
      .with("isTime", "true")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.department.Department.UPDATE_TIME_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("updateFunction", "now")
      .with("javaType", "java.time.LocalDateTime")
      .with("candidates", "updateTime()")
      .with("sqlType", "TIMESTAMP")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("mssql_sqlType", "dateTime")
      .with("isDateTime", "true")
      .with("createFunction", "now")
      .with("isDate", "true")
      .with("isString", "false")
      .with("graphqlType", "LocalTime")
      .with("isTime", "true")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.department.Department.VERSION_PROPERTY).with("isPassword", "false")
      .with("isVersion", "true")
      .with("oracle_sqlType", "number(11)")
      .with("javaType", "java.lang.Long")
      .with("sqlType", "BIGINT")
      .with("isId", "false")
      .with("isBaseEntityField", "true")
      .with("isBool", "false")
      .with("isNumber", "false")
      .with("isString", "false")
      .with("isDate", "false")
      .with("snowflake_sqlType", "number")
      .with("graphqlType", "Long")
      .with("isTime", "false")
      .with("isText", "false");

      $factory.register(entityDescriptor);
  }
  private void registerPosition() {
      EntityDescriptor entityDescriptor = new EntityDescriptor();
      entityDescriptor.setType(com.example.enterpriseerpsystem.position.Position.INTERNAL_TYPE);
      entityDescriptor.setTargetType(com.example.enterpriseerpsystem.position.Position.class);
      entityDescriptor.setEntitySupplier(com.example.enterpriseerpsystem.position.Position::new);
      entityDescriptor.with("name", "Position")
      .with("module", "HumanResources")
      .with("module_key", "humanresources");

      PropertyDescriptor id = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.position.Position.ID_PROPERTY, Long.class)
      ;
      PropertyDescriptor maxSalary = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.position.Position.MAX_SALARY_PROPERTY, BigDecimal.class)
      ;
      PropertyDescriptor minSalary = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.position.Position.MIN_SALARY_PROPERTY, BigDecimal.class)
      ;
      PropertyDescriptor title = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.position.Position.TITLE_PROPERTY, String.class)
      ;
      PropertyDescriptor createTime = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.position.Position.CREATE_TIME_PROPERTY, LocalDateTime.class)
      ;
      PropertyDescriptor updateTime = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.position.Position.UPDATE_TIME_PROPERTY, LocalDateTime.class)
      ;
      PropertyDescriptor version = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.position.Position.VERSION_PROPERTY, Long.class)
      ;
      entityDescriptor.findProperty(com.example.enterpriseerpsystem.position.Position.ID_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("oracle_sqlType", "number(11)")
      .with("javaType", "java.lang.Long")
      .with("sqlType", "BIGINT")
      .with("isId", "true")
      .with("isBaseEntityField", "true")
      .with("isBool", "false")
      .with("isNumber", "false")
      .with("isString", "false")
      .with("isDate", "false")
      .with("snowflake_sqlType", "number")
      .with("graphqlType", "Long")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.position.Position.MAX_SALARY_PROPERTY).with("isPassword", "false")
      .with("db2_sqlType", "decimal(19,7)")
      .with("isVersion", "false")
      .with("oracle_sqlType", "number(19,7)")
      .with("javaType", "java.math.BigDecimal")
      .with("candidates", "100.00")
      .with("sqlType", "NUMERIC(19,7)")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "true")
      .with("isString", "false")
      .with("isDate", "false")
      .with("graphqlType", "BigDecimal")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.position.Position.MIN_SALARY_PROPERTY).with("isPassword", "false")
      .with("db2_sqlType", "decimal(19,7)")
      .with("isVersion", "false")
      .with("oracle_sqlType", "number(19,7)")
      .with("javaType", "java.math.BigDecimal")
      .with("candidates", "100.00")
      .with("sqlType", "NUMERIC(19,7)")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "true")
      .with("isString", "false")
      .with("isDate", "false")
      .with("graphqlType", "BigDecimal")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.position.Position.TITLE_PROPERTY).with("isPassword", "false")
      .with("max", "100")
      .with("isVersion", "false")
      .with("javaType", "java.lang.String")
      .with("candidates", "title_value")
      .with("sqlType", "VARCHAR(<max>)")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("isString", "true")
      .with("isDate", "false")
      .with("graphqlType", "String")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.position.Position.CREATE_TIME_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("javaType", "java.time.LocalDateTime")
      .with("candidates", "createTime()")
      .with("sqlType", "TIMESTAMP")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("mssql_sqlType", "dateTime")
      .with("isDateTime", "true")
      .with("createFunction", "now")
      .with("isDate", "true")
      .with("isString", "false")
      .with("graphqlType", "LocalTime")
      .with("isTime", "true")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.position.Position.UPDATE_TIME_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("updateFunction", "now")
      .with("javaType", "java.time.LocalDateTime")
      .with("candidates", "updateTime()")
      .with("sqlType", "TIMESTAMP")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("mssql_sqlType", "dateTime")
      .with("isDateTime", "true")
      .with("createFunction", "now")
      .with("isDate", "true")
      .with("isString", "false")
      .with("graphqlType", "LocalTime")
      .with("isTime", "true")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.position.Position.VERSION_PROPERTY).with("isPassword", "false")
      .with("isVersion", "true")
      .with("oracle_sqlType", "number(11)")
      .with("javaType", "java.lang.Long")
      .with("sqlType", "BIGINT")
      .with("isId", "false")
      .with("isBaseEntityField", "true")
      .with("isBool", "false")
      .with("isNumber", "false")
      .with("isString", "false")
      .with("isDate", "false")
      .with("snowflake_sqlType", "number")
      .with("graphqlType", "Long")
      .with("isTime", "false")
      .with("isText", "false");

      $factory.register(entityDescriptor);
  }
  private void registerLeaveRequest() {
      EntityDescriptor entityDescriptor = new EntityDescriptor();
      entityDescriptor.setType(com.example.enterpriseerpsystem.leaverequest.LeaveRequest.INTERNAL_TYPE);
      entityDescriptor.setTargetType(com.example.enterpriseerpsystem.leaverequest.LeaveRequest.class);
      entityDescriptor.setEntitySupplier(com.example.enterpriseerpsystem.leaverequest.LeaveRequest::new);
      entityDescriptor.with("name", "Leave Request")
      .with("module", "HumanResources")
      .with("module_key", "humanresources");

      PropertyDescriptor id = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.leaverequest.LeaveRequest.ID_PROPERTY, Long.class)
      ;
      PropertyDescriptor employee = 
      entityDescriptor.addObjectProperty($factory, com.example.enterpriseerpsystem.leaverequest.LeaveRequest.EMPLOYEE_PROPERTY, com.example.enterpriseerpsystem.employee.Employee.INTERNAL_TYPE, com.example.enterpriseerpsystem.employee.Employee.LEAVE_REQUEST_LIST_PROPERTY, com.example.enterpriseerpsystem.employee.Employee.class)
      ;
      PropertyDescriptor endDate = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.leaverequest.LeaveRequest.END_DATE_PROPERTY, LocalDateTime.class)
      ;
      PropertyDescriptor reason = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.leaverequest.LeaveRequest.REASON_PROPERTY, String.class)
      ;
      PropertyDescriptor startDate = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.leaverequest.LeaveRequest.START_DATE_PROPERTY, LocalDateTime.class)
      ;
      PropertyDescriptor status = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.leaverequest.LeaveRequest.STATUS_PROPERTY, String.class)
      ;
      PropertyDescriptor createTime = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.leaverequest.LeaveRequest.CREATE_TIME_PROPERTY, LocalDateTime.class)
      ;
      PropertyDescriptor updateTime = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.leaverequest.LeaveRequest.UPDATE_TIME_PROPERTY, LocalDateTime.class)
      ;
      PropertyDescriptor version = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.leaverequest.LeaveRequest.VERSION_PROPERTY, Long.class)
      ;
      entityDescriptor.findProperty(com.example.enterpriseerpsystem.leaverequest.LeaveRequest.ID_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("oracle_sqlType", "number(11)")
      .with("javaType", "java.lang.Long")
      .with("sqlType", "BIGINT")
      .with("isId", "true")
      .with("isBaseEntityField", "true")
      .with("isBool", "false")
      .with("isNumber", "false")
      .with("isString", "false")
      .with("isDate", "false")
      .with("snowflake_sqlType", "number")
      .with("graphqlType", "Long")
      .with("isTime", "false")
      .with("isText", "false");


      entityDescriptor.findProperty(com.example.enterpriseerpsystem.leaverequest.LeaveRequest.END_DATE_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("javaType", "java.time.LocalDateTime")
      .with("sqlType", "TIMESTAMP")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("mssql_sqlType", "dateTime")
      .with("isDateTime", "true")
      .with("createFunction", "now")
      .with("isDate", "true")
      .with("isString", "false")
      .with("graphqlType", "LocalTime")
      .with("isTime", "true")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.leaverequest.LeaveRequest.REASON_PROPERTY).with("isPassword", "false")
      .with("max", "100")
      .with("isVersion", "false")
      .with("javaType", "java.lang.String")
      .with("sqlType", "VARCHAR(<max>)")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("isString", "true")
      .with("isDate", "false")
      .with("graphqlType", "String")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.leaverequest.LeaveRequest.START_DATE_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("javaType", "java.time.LocalDateTime")
      .with("sqlType", "TIMESTAMP")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("mssql_sqlType", "dateTime")
      .with("isDateTime", "true")
      .with("createFunction", "now")
      .with("isDate", "true")
      .with("isString", "false")
      .with("graphqlType", "LocalTime")
      .with("isTime", "true")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.leaverequest.LeaveRequest.STATUS_PROPERTY).with("isPassword", "false")
      .with("max", "100")
      .with("isVersion", "false")
      .with("javaType", "java.lang.String")
      .with("sqlType", "VARCHAR(<max>)")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("isString", "true")
      .with("isDate", "false")
      .with("graphqlType", "String")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.leaverequest.LeaveRequest.CREATE_TIME_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("javaType", "java.time.LocalDateTime")
      .with("sqlType", "TIMESTAMP")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("mssql_sqlType", "dateTime")
      .with("isDateTime", "true")
      .with("createFunction", "now")
      .with("isDate", "true")
      .with("isString", "false")
      .with("graphqlType", "LocalTime")
      .with("isTime", "true")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.leaverequest.LeaveRequest.UPDATE_TIME_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("updateFunction", "now")
      .with("javaType", "java.time.LocalDateTime")
      .with("sqlType", "TIMESTAMP")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("mssql_sqlType", "dateTime")
      .with("isDateTime", "true")
      .with("createFunction", "now")
      .with("isDate", "true")
      .with("isString", "false")
      .with("graphqlType", "LocalTime")
      .with("isTime", "true")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.leaverequest.LeaveRequest.VERSION_PROPERTY).with("isPassword", "false")
      .with("isVersion", "true")
      .with("oracle_sqlType", "number(11)")
      .with("javaType", "java.lang.Long")
      .with("sqlType", "BIGINT")
      .with("isId", "false")
      .with("isBaseEntityField", "true")
      .with("isBool", "false")
      .with("isNumber", "false")
      .with("isString", "false")
      .with("isDate", "false")
      .with("snowflake_sqlType", "number")
      .with("graphqlType", "Long")
      .with("isTime", "false")
      .with("isText", "false");

      $factory.register(entityDescriptor);
  }
  private void registerAttendance() {
      EntityDescriptor entityDescriptor = new EntityDescriptor();
      entityDescriptor.setType(com.example.enterpriseerpsystem.attendance.Attendance.INTERNAL_TYPE);
      entityDescriptor.setTargetType(com.example.enterpriseerpsystem.attendance.Attendance.class);
      entityDescriptor.setEntitySupplier(com.example.enterpriseerpsystem.attendance.Attendance::new);
      entityDescriptor.with("name", "Attendance")
      .with("module", "HumanResources")
      .with("module_key", "humanresources");

      PropertyDescriptor id = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.attendance.Attendance.ID_PROPERTY, Long.class)
      ;
      PropertyDescriptor checkIn = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.attendance.Attendance.CHECK_IN_PROPERTY, LocalDateTime.class)
      ;
      PropertyDescriptor checkOut = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.attendance.Attendance.CHECK_OUT_PROPERTY, LocalDateTime.class)
      ;
      PropertyDescriptor employee = 
      entityDescriptor.addObjectProperty($factory, com.example.enterpriseerpsystem.attendance.Attendance.EMPLOYEE_PROPERTY, com.example.enterpriseerpsystem.employee.Employee.INTERNAL_TYPE, com.example.enterpriseerpsystem.employee.Employee.ATTENDANCE_LIST_PROPERTY, com.example.enterpriseerpsystem.employee.Employee.class)
      ;
      PropertyDescriptor hoursWorked = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.attendance.Attendance.HOURS_WORKED_PROPERTY, BigDecimal.class)
      ;
      PropertyDescriptor createTime = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.attendance.Attendance.CREATE_TIME_PROPERTY, LocalDateTime.class)
      ;
      PropertyDescriptor updateTime = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.attendance.Attendance.UPDATE_TIME_PROPERTY, LocalDateTime.class)
      ;
      PropertyDescriptor version = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.attendance.Attendance.VERSION_PROPERTY, Long.class)
      ;
      entityDescriptor.findProperty(com.example.enterpriseerpsystem.attendance.Attendance.ID_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("oracle_sqlType", "number(11)")
      .with("javaType", "java.lang.Long")
      .with("sqlType", "BIGINT")
      .with("isId", "true")
      .with("isBaseEntityField", "true")
      .with("isBool", "false")
      .with("isNumber", "false")
      .with("isString", "false")
      .with("isDate", "false")
      .with("snowflake_sqlType", "number")
      .with("graphqlType", "Long")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.attendance.Attendance.CHECK_IN_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("javaType", "java.time.LocalDateTime")
      .with("sqlType", "TIMESTAMP")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("mssql_sqlType", "dateTime")
      .with("isDateTime", "true")
      .with("createFunction", "now")
      .with("isDate", "true")
      .with("isString", "false")
      .with("graphqlType", "LocalTime")
      .with("isTime", "true")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.attendance.Attendance.CHECK_OUT_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("javaType", "java.time.LocalDateTime")
      .with("sqlType", "TIMESTAMP")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("mssql_sqlType", "dateTime")
      .with("isDateTime", "true")
      .with("createFunction", "now")
      .with("isDate", "true")
      .with("isString", "false")
      .with("graphqlType", "LocalTime")
      .with("isTime", "true")
      .with("isText", "false");


      entityDescriptor.findProperty(com.example.enterpriseerpsystem.attendance.Attendance.HOURS_WORKED_PROPERTY).with("isPassword", "false")
      .with("db2_sqlType", "decimal(19,7)")
      .with("isVersion", "false")
      .with("oracle_sqlType", "number(19,7)")
      .with("javaType", "java.math.BigDecimal")
      .with("sqlType", "NUMERIC(19,7)")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "true")
      .with("isString", "false")
      .with("isDate", "false")
      .with("graphqlType", "BigDecimal")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.attendance.Attendance.CREATE_TIME_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("javaType", "java.time.LocalDateTime")
      .with("sqlType", "TIMESTAMP")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("mssql_sqlType", "dateTime")
      .with("isDateTime", "true")
      .with("createFunction", "now")
      .with("isDate", "true")
      .with("isString", "false")
      .with("graphqlType", "LocalTime")
      .with("isTime", "true")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.attendance.Attendance.UPDATE_TIME_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("updateFunction", "now")
      .with("javaType", "java.time.LocalDateTime")
      .with("sqlType", "TIMESTAMP")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("mssql_sqlType", "dateTime")
      .with("isDateTime", "true")
      .with("createFunction", "now")
      .with("isDate", "true")
      .with("isString", "false")
      .with("graphqlType", "LocalTime")
      .with("isTime", "true")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.attendance.Attendance.VERSION_PROPERTY).with("isPassword", "false")
      .with("isVersion", "true")
      .with("oracle_sqlType", "number(11)")
      .with("javaType", "java.lang.Long")
      .with("sqlType", "BIGINT")
      .with("isId", "false")
      .with("isBaseEntityField", "true")
      .with("isBool", "false")
      .with("isNumber", "false")
      .with("isString", "false")
      .with("isDate", "false")
      .with("snowflake_sqlType", "number")
      .with("graphqlType", "Long")
      .with("isTime", "false")
      .with("isText", "false");

      $factory.register(entityDescriptor);
  }
  private void registerBenefit() {
      EntityDescriptor entityDescriptor = new EntityDescriptor();
      entityDescriptor.setType(com.example.enterpriseerpsystem.benefit.Benefit.INTERNAL_TYPE);
      entityDescriptor.setTargetType(com.example.enterpriseerpsystem.benefit.Benefit.class);
      entityDescriptor.setEntitySupplier(com.example.enterpriseerpsystem.benefit.Benefit::new);
      entityDescriptor.with("name", "Benefit")
      .with("module", "HumanResources")
      .with("module_key", "humanresources");

      PropertyDescriptor id = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.benefit.Benefit.ID_PROPERTY, Long.class)
      ;
      PropertyDescriptor cost = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.benefit.Benefit.COST_PROPERTY, BigDecimal.class)
      ;
      PropertyDescriptor employee = 
      entityDescriptor.addObjectProperty($factory, com.example.enterpriseerpsystem.benefit.Benefit.EMPLOYEE_PROPERTY, com.example.enterpriseerpsystem.employee.Employee.INTERNAL_TYPE, com.example.enterpriseerpsystem.employee.Employee.BENEFIT_LIST_PROPERTY, com.example.enterpriseerpsystem.employee.Employee.class)
      ;
      PropertyDescriptor planType = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.benefit.Benefit.PLAN_TYPE_PROPERTY, String.class)
      ;
      PropertyDescriptor provider = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.benefit.Benefit.PROVIDER_PROPERTY, String.class)
      ;
      PropertyDescriptor createTime = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.benefit.Benefit.CREATE_TIME_PROPERTY, LocalDateTime.class)
      ;
      PropertyDescriptor updateTime = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.benefit.Benefit.UPDATE_TIME_PROPERTY, LocalDateTime.class)
      ;
      PropertyDescriptor version = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.benefit.Benefit.VERSION_PROPERTY, Long.class)
      ;
      entityDescriptor.findProperty(com.example.enterpriseerpsystem.benefit.Benefit.ID_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("oracle_sqlType", "number(11)")
      .with("javaType", "java.lang.Long")
      .with("sqlType", "BIGINT")
      .with("isId", "true")
      .with("isBaseEntityField", "true")
      .with("isBool", "false")
      .with("isNumber", "false")
      .with("isString", "false")
      .with("isDate", "false")
      .with("snowflake_sqlType", "number")
      .with("graphqlType", "Long")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.benefit.Benefit.COST_PROPERTY).with("isPassword", "false")
      .with("db2_sqlType", "decimal(19,7)")
      .with("isVersion", "false")
      .with("oracle_sqlType", "number(19,7)")
      .with("javaType", "java.math.BigDecimal")
      .with("sqlType", "NUMERIC(19,7)")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "true")
      .with("isString", "false")
      .with("isDate", "false")
      .with("graphqlType", "BigDecimal")
      .with("isTime", "false")
      .with("isText", "false");


      entityDescriptor.findProperty(com.example.enterpriseerpsystem.benefit.Benefit.PLAN_TYPE_PROPERTY).with("isPassword", "false")
      .with("max", "100")
      .with("isVersion", "false")
      .with("javaType", "java.lang.String")
      .with("sqlType", "VARCHAR(<max>)")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("isString", "true")
      .with("isDate", "false")
      .with("graphqlType", "String")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.benefit.Benefit.PROVIDER_PROPERTY).with("isPassword", "false")
      .with("max", "100")
      .with("isVersion", "false")
      .with("javaType", "java.lang.String")
      .with("sqlType", "VARCHAR(<max>)")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("isString", "true")
      .with("isDate", "false")
      .with("graphqlType", "String")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.benefit.Benefit.CREATE_TIME_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("javaType", "java.time.LocalDateTime")
      .with("sqlType", "TIMESTAMP")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("mssql_sqlType", "dateTime")
      .with("isDateTime", "true")
      .with("createFunction", "now")
      .with("isDate", "true")
      .with("isString", "false")
      .with("graphqlType", "LocalTime")
      .with("isTime", "true")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.benefit.Benefit.UPDATE_TIME_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("updateFunction", "now")
      .with("javaType", "java.time.LocalDateTime")
      .with("sqlType", "TIMESTAMP")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("mssql_sqlType", "dateTime")
      .with("isDateTime", "true")
      .with("createFunction", "now")
      .with("isDate", "true")
      .with("isString", "false")
      .with("graphqlType", "LocalTime")
      .with("isTime", "true")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.benefit.Benefit.VERSION_PROPERTY).with("isPassword", "false")
      .with("isVersion", "true")
      .with("oracle_sqlType", "number(11)")
      .with("javaType", "java.lang.Long")
      .with("sqlType", "BIGINT")
      .with("isId", "false")
      .with("isBaseEntityField", "true")
      .with("isBool", "false")
      .with("isNumber", "false")
      .with("isString", "false")
      .with("isDate", "false")
      .with("snowflake_sqlType", "number")
      .with("graphqlType", "Long")
      .with("isTime", "false")
      .with("isText", "false");

      $factory.register(entityDescriptor);
  }
  private void registerEmployeeReview() {
      EntityDescriptor entityDescriptor = new EntityDescriptor();
      entityDescriptor.setType(com.example.enterpriseerpsystem.employeereview.EmployeeReview.INTERNAL_TYPE);
      entityDescriptor.setTargetType(com.example.enterpriseerpsystem.employeereview.EmployeeReview.class);
      entityDescriptor.setEntitySupplier(com.example.enterpriseerpsystem.employeereview.EmployeeReview::new);
      entityDescriptor.with("name", "Employee Review")
      .with("module", "HumanResources")
      .with("module_key", "humanresources");

      PropertyDescriptor id = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.employeereview.EmployeeReview.ID_PROPERTY, Long.class)
      ;
      PropertyDescriptor comments = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.employeereview.EmployeeReview.COMMENTS_PROPERTY, String.class)
      ;
      PropertyDescriptor employee = 
      entityDescriptor.addObjectProperty($factory, com.example.enterpriseerpsystem.employeereview.EmployeeReview.EMPLOYEE_PROPERTY, com.example.enterpriseerpsystem.employee.Employee.INTERNAL_TYPE, com.example.enterpriseerpsystem.employee.Employee.EMPLOYEE_REVIEW_LIST_PROPERTY, com.example.enterpriseerpsystem.employee.Employee.class)
      ;
      PropertyDescriptor reviewDate = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.employeereview.EmployeeReview.REVIEW_DATE_PROPERTY, LocalDateTime.class)
      ;
      PropertyDescriptor reviewerId = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.employeereview.EmployeeReview.REVIEWER_ID_PROPERTY, String.class)
      ;
      PropertyDescriptor score = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.employeereview.EmployeeReview.SCORE_PROPERTY, BigDecimal.class)
      ;
      PropertyDescriptor createTime = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.employeereview.EmployeeReview.CREATE_TIME_PROPERTY, LocalDateTime.class)
      ;
      PropertyDescriptor updateTime = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.employeereview.EmployeeReview.UPDATE_TIME_PROPERTY, LocalDateTime.class)
      ;
      PropertyDescriptor version = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.employeereview.EmployeeReview.VERSION_PROPERTY, Long.class)
      ;
      entityDescriptor.findProperty(com.example.enterpriseerpsystem.employeereview.EmployeeReview.ID_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("oracle_sqlType", "number(11)")
      .with("javaType", "java.lang.Long")
      .with("sqlType", "BIGINT")
      .with("isId", "true")
      .with("isBaseEntityField", "true")
      .with("isBool", "false")
      .with("isNumber", "false")
      .with("isString", "false")
      .with("isDate", "false")
      .with("snowflake_sqlType", "number")
      .with("graphqlType", "Long")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.employeereview.EmployeeReview.COMMENTS_PROPERTY).with("isPassword", "false")
      .with("max", "100")
      .with("isVersion", "false")
      .with("javaType", "java.lang.String")
      .with("sqlType", "VARCHAR(<max>)")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("isString", "true")
      .with("isDate", "false")
      .with("graphqlType", "String")
      .with("isTime", "false")
      .with("isText", "false");


      entityDescriptor.findProperty(com.example.enterpriseerpsystem.employeereview.EmployeeReview.REVIEW_DATE_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("javaType", "java.time.LocalDateTime")
      .with("sqlType", "TIMESTAMP")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("mssql_sqlType", "dateTime")
      .with("isDateTime", "true")
      .with("createFunction", "now")
      .with("isDate", "true")
      .with("isString", "false")
      .with("graphqlType", "LocalTime")
      .with("isTime", "true")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.employeereview.EmployeeReview.REVIEWER_ID_PROPERTY).with("isPassword", "false")
      .with("max", "100")
      .with("isVersion", "false")
      .with("javaType", "java.lang.String")
      .with("sqlType", "VARCHAR(<max>)")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("isString", "true")
      .with("isDate", "false")
      .with("graphqlType", "String")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.employeereview.EmployeeReview.SCORE_PROPERTY).with("isPassword", "false")
      .with("db2_sqlType", "decimal(19,7)")
      .with("isVersion", "false")
      .with("oracle_sqlType", "number(19,7)")
      .with("javaType", "java.math.BigDecimal")
      .with("sqlType", "NUMERIC(19,7)")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "true")
      .with("isString", "false")
      .with("isDate", "false")
      .with("graphqlType", "BigDecimal")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.employeereview.EmployeeReview.CREATE_TIME_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("javaType", "java.time.LocalDateTime")
      .with("sqlType", "TIMESTAMP")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("mssql_sqlType", "dateTime")
      .with("isDateTime", "true")
      .with("createFunction", "now")
      .with("isDate", "true")
      .with("isString", "false")
      .with("graphqlType", "LocalTime")
      .with("isTime", "true")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.employeereview.EmployeeReview.UPDATE_TIME_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("updateFunction", "now")
      .with("javaType", "java.time.LocalDateTime")
      .with("sqlType", "TIMESTAMP")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("mssql_sqlType", "dateTime")
      .with("isDateTime", "true")
      .with("createFunction", "now")
      .with("isDate", "true")
      .with("isString", "false")
      .with("graphqlType", "LocalTime")
      .with("isTime", "true")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.employeereview.EmployeeReview.VERSION_PROPERTY).with("isPassword", "false")
      .with("isVersion", "true")
      .with("oracle_sqlType", "number(11)")
      .with("javaType", "java.lang.Long")
      .with("sqlType", "BIGINT")
      .with("isId", "false")
      .with("isBaseEntityField", "true")
      .with("isBool", "false")
      .with("isNumber", "false")
      .with("isString", "false")
      .with("isDate", "false")
      .with("snowflake_sqlType", "number")
      .with("graphqlType", "Long")
      .with("isTime", "false")
      .with("isText", "false");

      $factory.register(entityDescriptor);
  }
  private void registerPayroll() {
      EntityDescriptor entityDescriptor = new EntityDescriptor();
      entityDescriptor.setType(com.example.enterpriseerpsystem.payroll.Payroll.INTERNAL_TYPE);
      entityDescriptor.setTargetType(com.example.enterpriseerpsystem.payroll.Payroll.class);
      entityDescriptor.setEntitySupplier(com.example.enterpriseerpsystem.payroll.Payroll::new);
      entityDescriptor.with("name", "Payroll")
      .with("module", "HumanResources")
      .with("module_key", "humanresources");

      PropertyDescriptor id = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.payroll.Payroll.ID_PROPERTY, Long.class)
      ;
      PropertyDescriptor tax = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.payroll.Payroll.TAX_PROPERTY, BigDecimal.class)
      ;
      PropertyDescriptor employee = 
      entityDescriptor.addObjectProperty($factory, com.example.enterpriseerpsystem.payroll.Payroll.EMPLOYEE_PROPERTY, com.example.enterpriseerpsystem.employee.Employee.INTERNAL_TYPE, com.example.enterpriseerpsystem.employee.Employee.PAYROLL_LIST_PROPERTY, com.example.enterpriseerpsystem.employee.Employee.class)
      ;
      PropertyDescriptor grossPay = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.payroll.Payroll.GROSS_PAY_PROPERTY, BigDecimal.class)
      ;
      PropertyDescriptor netPay = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.payroll.Payroll.NET_PAY_PROPERTY, BigDecimal.class)
      ;
      PropertyDescriptor periodEnd = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.payroll.Payroll.PERIOD_END_PROPERTY, LocalDateTime.class)
      ;
      PropertyDescriptor periodStart = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.payroll.Payroll.PERIOD_START_PROPERTY, LocalDateTime.class)
      ;
      PropertyDescriptor createTime = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.payroll.Payroll.CREATE_TIME_PROPERTY, LocalDateTime.class)
      ;
      PropertyDescriptor updateTime = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.payroll.Payroll.UPDATE_TIME_PROPERTY, LocalDateTime.class)
      ;
      PropertyDescriptor version = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.payroll.Payroll.VERSION_PROPERTY, Long.class)
      ;
      entityDescriptor.findProperty(com.example.enterpriseerpsystem.payroll.Payroll.ID_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("oracle_sqlType", "number(11)")
      .with("javaType", "java.lang.Long")
      .with("sqlType", "BIGINT")
      .with("isId", "true")
      .with("isBaseEntityField", "true")
      .with("isBool", "false")
      .with("isNumber", "false")
      .with("isString", "false")
      .with("isDate", "false")
      .with("snowflake_sqlType", "number")
      .with("graphqlType", "Long")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.payroll.Payroll.TAX_PROPERTY).with("isPassword", "false")
      .with("db2_sqlType", "decimal(19,7)")
      .with("isVersion", "false")
      .with("oracle_sqlType", "number(19,7)")
      .with("javaType", "java.math.BigDecimal")
      .with("sqlType", "NUMERIC(19,7)")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "true")
      .with("isString", "false")
      .with("isDate", "false")
      .with("graphqlType", "BigDecimal")
      .with("isTime", "false")
      .with("isText", "false");


      entityDescriptor.findProperty(com.example.enterpriseerpsystem.payroll.Payroll.GROSS_PAY_PROPERTY).with("isPassword", "false")
      .with("db2_sqlType", "decimal(19,7)")
      .with("isVersion", "false")
      .with("oracle_sqlType", "number(19,7)")
      .with("javaType", "java.math.BigDecimal")
      .with("sqlType", "NUMERIC(19,7)")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "true")
      .with("isString", "false")
      .with("isDate", "false")
      .with("graphqlType", "BigDecimal")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.payroll.Payroll.NET_PAY_PROPERTY).with("isPassword", "false")
      .with("db2_sqlType", "decimal(19,7)")
      .with("isVersion", "false")
      .with("oracle_sqlType", "number(19,7)")
      .with("javaType", "java.math.BigDecimal")
      .with("sqlType", "NUMERIC(19,7)")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "true")
      .with("isString", "false")
      .with("isDate", "false")
      .with("graphqlType", "BigDecimal")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.payroll.Payroll.PERIOD_END_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("javaType", "java.time.LocalDateTime")
      .with("sqlType", "TIMESTAMP")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("mssql_sqlType", "dateTime")
      .with("isDateTime", "true")
      .with("createFunction", "now")
      .with("isDate", "true")
      .with("isString", "false")
      .with("graphqlType", "LocalTime")
      .with("isTime", "true")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.payroll.Payroll.PERIOD_START_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("javaType", "java.time.LocalDateTime")
      .with("sqlType", "TIMESTAMP")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("mssql_sqlType", "dateTime")
      .with("isDateTime", "true")
      .with("createFunction", "now")
      .with("isDate", "true")
      .with("isString", "false")
      .with("graphqlType", "LocalTime")
      .with("isTime", "true")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.payroll.Payroll.CREATE_TIME_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("javaType", "java.time.LocalDateTime")
      .with("sqlType", "TIMESTAMP")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("mssql_sqlType", "dateTime")
      .with("isDateTime", "true")
      .with("createFunction", "now")
      .with("isDate", "true")
      .with("isString", "false")
      .with("graphqlType", "LocalTime")
      .with("isTime", "true")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.payroll.Payroll.UPDATE_TIME_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("updateFunction", "now")
      .with("javaType", "java.time.LocalDateTime")
      .with("sqlType", "TIMESTAMP")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("mssql_sqlType", "dateTime")
      .with("isDateTime", "true")
      .with("createFunction", "now")
      .with("isDate", "true")
      .with("isString", "false")
      .with("graphqlType", "LocalTime")
      .with("isTime", "true")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.payroll.Payroll.VERSION_PROPERTY).with("isPassword", "false")
      .with("isVersion", "true")
      .with("oracle_sqlType", "number(11)")
      .with("javaType", "java.lang.Long")
      .with("sqlType", "BIGINT")
      .with("isId", "false")
      .with("isBaseEntityField", "true")
      .with("isBool", "false")
      .with("isNumber", "false")
      .with("isString", "false")
      .with("isDate", "false")
      .with("snowflake_sqlType", "number")
      .with("graphqlType", "Long")
      .with("isTime", "false")
      .with("isText", "false");

      $factory.register(entityDescriptor);
  }
  private void registerCustomer() {
      EntityDescriptor entityDescriptor = new EntityDescriptor();
      entityDescriptor.setType(com.example.enterpriseerpsystem.customer.Customer.INTERNAL_TYPE);
      entityDescriptor.setTargetType(com.example.enterpriseerpsystem.customer.Customer.class);
      entityDescriptor.setEntitySupplier(com.example.enterpriseerpsystem.customer.Customer::new);
      entityDescriptor.with("name", "Customer")
      .with("module", "CRM")
      .with("module_key", "crm");

      PropertyDescriptor id = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.customer.Customer.ID_PROPERTY, Long.class)
      ;
      PropertyDescriptor address = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.customer.Customer.ADDRESS_PROPERTY, String.class)
      ;
      PropertyDescriptor email = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.customer.Customer.EMAIL_PROPERTY, String.class)
      ;
      PropertyDescriptor name = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.customer.Customer.NAME_PROPERTY, String.class)
      ;
      PropertyDescriptor phone = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.customer.Customer.PHONE_PROPERTY, String.class)
      ;
      PropertyDescriptor createdAt = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.customer.Customer.CREATED_AT_PROPERTY, LocalDateTime.class)
      ;
      PropertyDescriptor loyaltyPoints = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.customer.Customer.LOYALTY_POINTS_PROPERTY, BigDecimal.class)
      ;
      PropertyDescriptor createTime = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.customer.Customer.CREATE_TIME_PROPERTY, LocalDateTime.class)
      ;
      PropertyDescriptor updateTime = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.customer.Customer.UPDATE_TIME_PROPERTY, LocalDateTime.class)
      ;
      PropertyDescriptor version = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.customer.Customer.VERSION_PROPERTY, Long.class)
      ;
      entityDescriptor.findProperty(com.example.enterpriseerpsystem.customer.Customer.ID_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("oracle_sqlType", "number(11)")
      .with("javaType", "java.lang.Long")
      .with("sqlType", "BIGINT")
      .with("isId", "true")
      .with("isBaseEntityField", "true")
      .with("isBool", "false")
      .with("isNumber", "false")
      .with("isString", "false")
      .with("isDate", "false")
      .with("snowflake_sqlType", "number")
      .with("graphqlType", "Long")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.customer.Customer.ADDRESS_PROPERTY).with("isPassword", "false")
      .with("max", "100")
      .with("isVersion", "false")
      .with("javaType", "java.lang.String")
      .with("candidates", "address_value")
      .with("sqlType", "VARCHAR(<max>)")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("isString", "true")
      .with("isDate", "false")
      .with("graphqlType", "String")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.customer.Customer.EMAIL_PROPERTY).with("isPassword", "false")
      .with("max", "100")
      .with("isVersion", "false")
      .with("javaType", "java.lang.String")
      .with("candidates", "email_value")
      .with("sqlType", "VARCHAR(<max>)")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("isString", "true")
      .with("isDate", "false")
      .with("graphqlType", "String")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.customer.Customer.NAME_PROPERTY).with("isPassword", "false")
      .with("max", "100")
      .with("isVersion", "false")
      .with("javaType", "java.lang.String")
      .with("candidates", "name_value")
      .with("sqlType", "VARCHAR(<max>)")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("isString", "true")
      .with("isDate", "false")
      .with("graphqlType", "String")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.customer.Customer.PHONE_PROPERTY).with("isPassword", "false")
      .with("max", "100")
      .with("isVersion", "false")
      .with("javaType", "java.lang.String")
      .with("candidates", "phone_value")
      .with("sqlType", "VARCHAR(<max>)")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("isString", "true")
      .with("isDate", "false")
      .with("graphqlType", "String")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.customer.Customer.CREATED_AT_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("javaType", "java.time.LocalDateTime")
      .with("candidates", "createTime()")
      .with("sqlType", "TIMESTAMP")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("mssql_sqlType", "dateTime")
      .with("isDateTime", "true")
      .with("createFunction", "now")
      .with("isDate", "true")
      .with("isString", "false")
      .with("graphqlType", "LocalTime")
      .with("isTime", "true")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.customer.Customer.LOYALTY_POINTS_PROPERTY).with("isPassword", "false")
      .with("db2_sqlType", "decimal(19,7)")
      .with("isVersion", "false")
      .with("oracle_sqlType", "number(19,7)")
      .with("javaType", "java.math.BigDecimal")
      .with("candidates", "100.00")
      .with("sqlType", "NUMERIC(19,7)")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "true")
      .with("isString", "false")
      .with("isDate", "false")
      .with("graphqlType", "BigDecimal")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.customer.Customer.CREATE_TIME_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("javaType", "java.time.LocalDateTime")
      .with("candidates", "createTime()")
      .with("sqlType", "TIMESTAMP")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("mssql_sqlType", "dateTime")
      .with("isDateTime", "true")
      .with("createFunction", "now")
      .with("isDate", "true")
      .with("isString", "false")
      .with("graphqlType", "LocalTime")
      .with("isTime", "true")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.customer.Customer.UPDATE_TIME_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("updateFunction", "now")
      .with("javaType", "java.time.LocalDateTime")
      .with("candidates", "updateTime()")
      .with("sqlType", "TIMESTAMP")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("mssql_sqlType", "dateTime")
      .with("isDateTime", "true")
      .with("createFunction", "now")
      .with("isDate", "true")
      .with("isString", "false")
      .with("graphqlType", "LocalTime")
      .with("isTime", "true")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.customer.Customer.VERSION_PROPERTY).with("isPassword", "false")
      .with("isVersion", "true")
      .with("oracle_sqlType", "number(11)")
      .with("javaType", "java.lang.Long")
      .with("sqlType", "BIGINT")
      .with("isId", "false")
      .with("isBaseEntityField", "true")
      .with("isBool", "false")
      .with("isNumber", "false")
      .with("isString", "false")
      .with("isDate", "false")
      .with("snowflake_sqlType", "number")
      .with("graphqlType", "Long")
      .with("isTime", "false")
      .with("isText", "false");

      $factory.register(entityDescriptor);
  }
  private void registerLead() {
      EntityDescriptor entityDescriptor = new EntityDescriptor();
      entityDescriptor.setType(com.example.enterpriseerpsystem.lead.Lead.INTERNAL_TYPE);
      entityDescriptor.setTargetType(com.example.enterpriseerpsystem.lead.Lead.class);
      entityDescriptor.setEntitySupplier(com.example.enterpriseerpsystem.lead.Lead::new);
      entityDescriptor.with("name", "Lead")
      .with("module", "CRM")
      .with("module_key", "crm");

      PropertyDescriptor id = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.lead.Lead.ID_PROPERTY, Long.class)
      ;
      PropertyDescriptor email = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.lead.Lead.EMAIL_PROPERTY, String.class)
      ;
      PropertyDescriptor name = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.lead.Lead.NAME_PROPERTY, String.class)
      ;
      PropertyDescriptor phone = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.lead.Lead.PHONE_PROPERTY, String.class)
      ;
      PropertyDescriptor convertedCustomerId = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.lead.Lead.CONVERTED_CUSTOMER_ID_PROPERTY, String.class)
      ;
      PropertyDescriptor source = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.lead.Lead.SOURCE_PROPERTY, String.class)
      ;
      PropertyDescriptor status = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.lead.Lead.STATUS_PROPERTY, String.class)
      ;
      PropertyDescriptor createTime = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.lead.Lead.CREATE_TIME_PROPERTY, LocalDateTime.class)
      ;
      PropertyDescriptor updateTime = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.lead.Lead.UPDATE_TIME_PROPERTY, LocalDateTime.class)
      ;
      PropertyDescriptor version = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.lead.Lead.VERSION_PROPERTY, Long.class)
      ;
      entityDescriptor.findProperty(com.example.enterpriseerpsystem.lead.Lead.ID_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("oracle_sqlType", "number(11)")
      .with("javaType", "java.lang.Long")
      .with("sqlType", "BIGINT")
      .with("isId", "true")
      .with("isBaseEntityField", "true")
      .with("isBool", "false")
      .with("isNumber", "false")
      .with("isString", "false")
      .with("isDate", "false")
      .with("snowflake_sqlType", "number")
      .with("graphqlType", "Long")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.lead.Lead.EMAIL_PROPERTY).with("isPassword", "false")
      .with("max", "100")
      .with("isVersion", "false")
      .with("javaType", "java.lang.String")
      .with("candidates", "email_value")
      .with("sqlType", "VARCHAR(<max>)")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("isString", "true")
      .with("isDate", "false")
      .with("graphqlType", "String")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.lead.Lead.NAME_PROPERTY).with("isPassword", "false")
      .with("max", "100")
      .with("isVersion", "false")
      .with("javaType", "java.lang.String")
      .with("candidates", "name_value")
      .with("sqlType", "VARCHAR(<max>)")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("isString", "true")
      .with("isDate", "false")
      .with("graphqlType", "String")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.lead.Lead.PHONE_PROPERTY).with("isPassword", "false")
      .with("max", "100")
      .with("isVersion", "false")
      .with("javaType", "java.lang.String")
      .with("candidates", "phone_value")
      .with("sqlType", "VARCHAR(<max>)")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("isString", "true")
      .with("isDate", "false")
      .with("graphqlType", "String")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.lead.Lead.CONVERTED_CUSTOMER_ID_PROPERTY).with("isPassword", "false")
      .with("max", "100")
      .with("isVersion", "false")
      .with("javaType", "java.lang.String")
      .with("candidates", "converted_customer_id_value")
      .with("sqlType", "VARCHAR(<max>)")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("isString", "true")
      .with("isDate", "false")
      .with("graphqlType", "String")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.lead.Lead.SOURCE_PROPERTY).with("isPassword", "false")
      .with("max", "100")
      .with("isVersion", "false")
      .with("javaType", "java.lang.String")
      .with("candidates", "source_value")
      .with("sqlType", "VARCHAR(<max>)")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("isString", "true")
      .with("isDate", "false")
      .with("graphqlType", "String")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.lead.Lead.STATUS_PROPERTY).with("isPassword", "false")
      .with("max", "100")
      .with("isVersion", "false")
      .with("javaType", "java.lang.String")
      .with("candidates", "status_value")
      .with("sqlType", "VARCHAR(<max>)")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("isString", "true")
      .with("isDate", "false")
      .with("graphqlType", "String")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.lead.Lead.CREATE_TIME_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("javaType", "java.time.LocalDateTime")
      .with("candidates", "createTime()")
      .with("sqlType", "TIMESTAMP")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("mssql_sqlType", "dateTime")
      .with("isDateTime", "true")
      .with("createFunction", "now")
      .with("isDate", "true")
      .with("isString", "false")
      .with("graphqlType", "LocalTime")
      .with("isTime", "true")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.lead.Lead.UPDATE_TIME_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("updateFunction", "now")
      .with("javaType", "java.time.LocalDateTime")
      .with("candidates", "updateTime()")
      .with("sqlType", "TIMESTAMP")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("mssql_sqlType", "dateTime")
      .with("isDateTime", "true")
      .with("createFunction", "now")
      .with("isDate", "true")
      .with("isString", "false")
      .with("graphqlType", "LocalTime")
      .with("isTime", "true")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.lead.Lead.VERSION_PROPERTY).with("isPassword", "false")
      .with("isVersion", "true")
      .with("oracle_sqlType", "number(11)")
      .with("javaType", "java.lang.Long")
      .with("sqlType", "BIGINT")
      .with("isId", "false")
      .with("isBaseEntityField", "true")
      .with("isBool", "false")
      .with("isNumber", "false")
      .with("isString", "false")
      .with("isDate", "false")
      .with("snowflake_sqlType", "number")
      .with("graphqlType", "Long")
      .with("isTime", "false")
      .with("isText", "false");

      $factory.register(entityDescriptor);
  }
  private void registerOpportunity() {
      EntityDescriptor entityDescriptor = new EntityDescriptor();
      entityDescriptor.setType(com.example.enterpriseerpsystem.opportunity.Opportunity.INTERNAL_TYPE);
      entityDescriptor.setTargetType(com.example.enterpriseerpsystem.opportunity.Opportunity.class);
      entityDescriptor.setEntitySupplier(com.example.enterpriseerpsystem.opportunity.Opportunity::new);
      entityDescriptor.with("name", "Opportunity")
      .with("module", "CRM")
      .with("module_key", "crm");

      PropertyDescriptor id = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.opportunity.Opportunity.ID_PROPERTY, Long.class)
      ;
      PropertyDescriptor closeDate = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.opportunity.Opportunity.CLOSE_DATE_PROPERTY, LocalDateTime.class)
      ;
      PropertyDescriptor expectedRevenue = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.opportunity.Opportunity.EXPECTED_REVENUE_PROPERTY, BigDecimal.class)
      ;
      PropertyDescriptor lead = 
      entityDescriptor.addObjectProperty($factory, com.example.enterpriseerpsystem.opportunity.Opportunity.LEAD_PROPERTY, com.example.enterpriseerpsystem.lead.Lead.INTERNAL_TYPE, com.example.enterpriseerpsystem.lead.Lead.OPPORTUNITY_LIST_PROPERTY, com.example.enterpriseerpsystem.lead.Lead.class)
      ;
      PropertyDescriptor probability = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.opportunity.Opportunity.PROBABILITY_PROPERTY, BigDecimal.class)
      ;
      PropertyDescriptor status = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.opportunity.Opportunity.STATUS_PROPERTY, String.class)
      ;
      PropertyDescriptor createTime = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.opportunity.Opportunity.CREATE_TIME_PROPERTY, LocalDateTime.class)
      ;
      PropertyDescriptor updateTime = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.opportunity.Opportunity.UPDATE_TIME_PROPERTY, LocalDateTime.class)
      ;
      PropertyDescriptor version = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.opportunity.Opportunity.VERSION_PROPERTY, Long.class)
      ;
      entityDescriptor.findProperty(com.example.enterpriseerpsystem.opportunity.Opportunity.ID_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("oracle_sqlType", "number(11)")
      .with("javaType", "java.lang.Long")
      .with("sqlType", "BIGINT")
      .with("isId", "true")
      .with("isBaseEntityField", "true")
      .with("isBool", "false")
      .with("isNumber", "false")
      .with("isString", "false")
      .with("isDate", "false")
      .with("snowflake_sqlType", "number")
      .with("graphqlType", "Long")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.opportunity.Opportunity.CLOSE_DATE_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("javaType", "java.time.LocalDateTime")
      .with("sqlType", "TIMESTAMP")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("mssql_sqlType", "dateTime")
      .with("isDateTime", "true")
      .with("createFunction", "now")
      .with("isDate", "true")
      .with("isString", "false")
      .with("graphqlType", "LocalTime")
      .with("isTime", "true")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.opportunity.Opportunity.EXPECTED_REVENUE_PROPERTY).with("isPassword", "false")
      .with("db2_sqlType", "decimal(19,7)")
      .with("isVersion", "false")
      .with("oracle_sqlType", "number(19,7)")
      .with("javaType", "java.math.BigDecimal")
      .with("sqlType", "NUMERIC(19,7)")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "true")
      .with("isString", "false")
      .with("isDate", "false")
      .with("graphqlType", "BigDecimal")
      .with("isTime", "false")
      .with("isText", "false");


      entityDescriptor.findProperty(com.example.enterpriseerpsystem.opportunity.Opportunity.PROBABILITY_PROPERTY).with("isPassword", "false")
      .with("db2_sqlType", "decimal(19,7)")
      .with("isVersion", "false")
      .with("oracle_sqlType", "number(19,7)")
      .with("javaType", "java.math.BigDecimal")
      .with("sqlType", "NUMERIC(19,7)")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "true")
      .with("isString", "false")
      .with("isDate", "false")
      .with("graphqlType", "BigDecimal")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.opportunity.Opportunity.STATUS_PROPERTY).with("isPassword", "false")
      .with("max", "100")
      .with("isVersion", "false")
      .with("javaType", "java.lang.String")
      .with("sqlType", "VARCHAR(<max>)")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("isString", "true")
      .with("isDate", "false")
      .with("graphqlType", "String")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.opportunity.Opportunity.CREATE_TIME_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("javaType", "java.time.LocalDateTime")
      .with("sqlType", "TIMESTAMP")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("mssql_sqlType", "dateTime")
      .with("isDateTime", "true")
      .with("createFunction", "now")
      .with("isDate", "true")
      .with("isString", "false")
      .with("graphqlType", "LocalTime")
      .with("isTime", "true")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.opportunity.Opportunity.UPDATE_TIME_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("updateFunction", "now")
      .with("javaType", "java.time.LocalDateTime")
      .with("sqlType", "TIMESTAMP")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("mssql_sqlType", "dateTime")
      .with("isDateTime", "true")
      .with("createFunction", "now")
      .with("isDate", "true")
      .with("isString", "false")
      .with("graphqlType", "LocalTime")
      .with("isTime", "true")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.opportunity.Opportunity.VERSION_PROPERTY).with("isPassword", "false")
      .with("isVersion", "true")
      .with("oracle_sqlType", "number(11)")
      .with("javaType", "java.lang.Long")
      .with("sqlType", "BIGINT")
      .with("isId", "false")
      .with("isBaseEntityField", "true")
      .with("isBool", "false")
      .with("isNumber", "false")
      .with("isString", "false")
      .with("isDate", "false")
      .with("snowflake_sqlType", "number")
      .with("graphqlType", "Long")
      .with("isTime", "false")
      .with("isText", "false");

      $factory.register(entityDescriptor);
  }
  private void registerContact() {
      EntityDescriptor entityDescriptor = new EntityDescriptor();
      entityDescriptor.setType(com.example.enterpriseerpsystem.contact.Contact.INTERNAL_TYPE);
      entityDescriptor.setTargetType(com.example.enterpriseerpsystem.contact.Contact.class);
      entityDescriptor.setEntitySupplier(com.example.enterpriseerpsystem.contact.Contact::new);
      entityDescriptor.with("name", "Contact")
      .with("module", "CRM")
      .with("module_key", "crm");

      PropertyDescriptor id = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.contact.Contact.ID_PROPERTY, Long.class)
      ;
      PropertyDescriptor email = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.contact.Contact.EMAIL_PROPERTY, String.class)
      ;
      PropertyDescriptor name = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.contact.Contact.NAME_PROPERTY, String.class)
      ;
      PropertyDescriptor phone = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.contact.Contact.PHONE_PROPERTY, String.class)
      ;
      PropertyDescriptor customer = 
      entityDescriptor.addObjectProperty($factory, com.example.enterpriseerpsystem.contact.Contact.CUSTOMER_PROPERTY, com.example.enterpriseerpsystem.customer.Customer.INTERNAL_TYPE, com.example.enterpriseerpsystem.customer.Customer.CONTACT_LIST_PROPERTY, com.example.enterpriseerpsystem.customer.Customer.class)
      ;
      PropertyDescriptor role = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.contact.Contact.ROLE_PROPERTY, String.class)
      ;
      PropertyDescriptor createTime = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.contact.Contact.CREATE_TIME_PROPERTY, LocalDateTime.class)
      ;
      PropertyDescriptor updateTime = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.contact.Contact.UPDATE_TIME_PROPERTY, LocalDateTime.class)
      ;
      PropertyDescriptor version = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.contact.Contact.VERSION_PROPERTY, Long.class)
      ;
      entityDescriptor.findProperty(com.example.enterpriseerpsystem.contact.Contact.ID_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("oracle_sqlType", "number(11)")
      .with("javaType", "java.lang.Long")
      .with("sqlType", "BIGINT")
      .with("isId", "true")
      .with("isBaseEntityField", "true")
      .with("isBool", "false")
      .with("isNumber", "false")
      .with("isString", "false")
      .with("isDate", "false")
      .with("snowflake_sqlType", "number")
      .with("graphqlType", "Long")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.contact.Contact.EMAIL_PROPERTY).with("isPassword", "false")
      .with("max", "100")
      .with("isVersion", "false")
      .with("javaType", "java.lang.String")
      .with("sqlType", "VARCHAR(<max>)")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("isString", "true")
      .with("isDate", "false")
      .with("graphqlType", "String")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.contact.Contact.NAME_PROPERTY).with("isPassword", "false")
      .with("max", "100")
      .with("isVersion", "false")
      .with("javaType", "java.lang.String")
      .with("sqlType", "VARCHAR(<max>)")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("isString", "true")
      .with("isDate", "false")
      .with("graphqlType", "String")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.contact.Contact.PHONE_PROPERTY).with("isPassword", "false")
      .with("max", "100")
      .with("isVersion", "false")
      .with("javaType", "java.lang.String")
      .with("sqlType", "VARCHAR(<max>)")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("isString", "true")
      .with("isDate", "false")
      .with("graphqlType", "String")
      .with("isTime", "false")
      .with("isText", "false");


      entityDescriptor.findProperty(com.example.enterpriseerpsystem.contact.Contact.ROLE_PROPERTY).with("isPassword", "false")
      .with("max", "100")
      .with("isVersion", "false")
      .with("javaType", "java.lang.String")
      .with("sqlType", "VARCHAR(<max>)")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("isString", "true")
      .with("isDate", "false")
      .with("graphqlType", "String")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.contact.Contact.CREATE_TIME_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("javaType", "java.time.LocalDateTime")
      .with("sqlType", "TIMESTAMP")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("mssql_sqlType", "dateTime")
      .with("isDateTime", "true")
      .with("createFunction", "now")
      .with("isDate", "true")
      .with("isString", "false")
      .with("graphqlType", "LocalTime")
      .with("isTime", "true")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.contact.Contact.UPDATE_TIME_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("updateFunction", "now")
      .with("javaType", "java.time.LocalDateTime")
      .with("sqlType", "TIMESTAMP")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("mssql_sqlType", "dateTime")
      .with("isDateTime", "true")
      .with("createFunction", "now")
      .with("isDate", "true")
      .with("isString", "false")
      .with("graphqlType", "LocalTime")
      .with("isTime", "true")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.contact.Contact.VERSION_PROPERTY).with("isPassword", "false")
      .with("isVersion", "true")
      .with("oracle_sqlType", "number(11)")
      .with("javaType", "java.lang.Long")
      .with("sqlType", "BIGINT")
      .with("isId", "false")
      .with("isBaseEntityField", "true")
      .with("isBool", "false")
      .with("isNumber", "false")
      .with("isString", "false")
      .with("isDate", "false")
      .with("snowflake_sqlType", "number")
      .with("graphqlType", "Long")
      .with("isTime", "false")
      .with("isText", "false");

      $factory.register(entityDescriptor);
  }
  private void registerCampaign() {
      EntityDescriptor entityDescriptor = new EntityDescriptor();
      entityDescriptor.setType(com.example.enterpriseerpsystem.campaign.Campaign.INTERNAL_TYPE);
      entityDescriptor.setTargetType(com.example.enterpriseerpsystem.campaign.Campaign.class);
      entityDescriptor.setEntitySupplier(com.example.enterpriseerpsystem.campaign.Campaign::new);
      entityDescriptor.with("name", "Campaign")
      .with("module", "CRM")
      .with("module_key", "crm");

      PropertyDescriptor id = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.campaign.Campaign.ID_PROPERTY, Long.class)
      ;
      PropertyDescriptor name = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.campaign.Campaign.NAME_PROPERTY, String.class)
      ;
      PropertyDescriptor budget = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.campaign.Campaign.BUDGET_PROPERTY, BigDecimal.class)
      ;
      PropertyDescriptor endDate = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.campaign.Campaign.END_DATE_PROPERTY, LocalDateTime.class)
      ;
      PropertyDescriptor startDate = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.campaign.Campaign.START_DATE_PROPERTY, LocalDateTime.class)
      ;
      PropertyDescriptor status = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.campaign.Campaign.STATUS_PROPERTY, String.class)
      ;
      PropertyDescriptor createTime = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.campaign.Campaign.CREATE_TIME_PROPERTY, LocalDateTime.class)
      ;
      PropertyDescriptor updateTime = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.campaign.Campaign.UPDATE_TIME_PROPERTY, LocalDateTime.class)
      ;
      PropertyDescriptor version = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.campaign.Campaign.VERSION_PROPERTY, Long.class)
      ;
      entityDescriptor.findProperty(com.example.enterpriseerpsystem.campaign.Campaign.ID_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("oracle_sqlType", "number(11)")
      .with("javaType", "java.lang.Long")
      .with("sqlType", "BIGINT")
      .with("isId", "true")
      .with("isBaseEntityField", "true")
      .with("isBool", "false")
      .with("isNumber", "false")
      .with("isString", "false")
      .with("isDate", "false")
      .with("snowflake_sqlType", "number")
      .with("graphqlType", "Long")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.campaign.Campaign.NAME_PROPERTY).with("isPassword", "false")
      .with("max", "100")
      .with("isVersion", "false")
      .with("javaType", "java.lang.String")
      .with("candidates", "name_value")
      .with("sqlType", "VARCHAR(<max>)")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("isString", "true")
      .with("isDate", "false")
      .with("graphqlType", "String")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.campaign.Campaign.BUDGET_PROPERTY).with("isPassword", "false")
      .with("db2_sqlType", "decimal(19,7)")
      .with("isVersion", "false")
      .with("oracle_sqlType", "number(19,7)")
      .with("javaType", "java.math.BigDecimal")
      .with("candidates", "100.00")
      .with("sqlType", "NUMERIC(19,7)")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "true")
      .with("isString", "false")
      .with("isDate", "false")
      .with("graphqlType", "BigDecimal")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.campaign.Campaign.END_DATE_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("javaType", "java.time.LocalDateTime")
      .with("candidates", "createTime()")
      .with("sqlType", "TIMESTAMP")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("mssql_sqlType", "dateTime")
      .with("isDateTime", "true")
      .with("createFunction", "now")
      .with("isDate", "true")
      .with("isString", "false")
      .with("graphqlType", "LocalTime")
      .with("isTime", "true")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.campaign.Campaign.START_DATE_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("javaType", "java.time.LocalDateTime")
      .with("candidates", "createTime()")
      .with("sqlType", "TIMESTAMP")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("mssql_sqlType", "dateTime")
      .with("isDateTime", "true")
      .with("createFunction", "now")
      .with("isDate", "true")
      .with("isString", "false")
      .with("graphqlType", "LocalTime")
      .with("isTime", "true")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.campaign.Campaign.STATUS_PROPERTY).with("isPassword", "false")
      .with("max", "100")
      .with("isVersion", "false")
      .with("javaType", "java.lang.String")
      .with("candidates", "status_value")
      .with("sqlType", "VARCHAR(<max>)")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("isString", "true")
      .with("isDate", "false")
      .with("graphqlType", "String")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.campaign.Campaign.CREATE_TIME_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("javaType", "java.time.LocalDateTime")
      .with("candidates", "createTime()")
      .with("sqlType", "TIMESTAMP")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("mssql_sqlType", "dateTime")
      .with("isDateTime", "true")
      .with("createFunction", "now")
      .with("isDate", "true")
      .with("isString", "false")
      .with("graphqlType", "LocalTime")
      .with("isTime", "true")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.campaign.Campaign.UPDATE_TIME_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("updateFunction", "now")
      .with("javaType", "java.time.LocalDateTime")
      .with("candidates", "updateTime()")
      .with("sqlType", "TIMESTAMP")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("mssql_sqlType", "dateTime")
      .with("isDateTime", "true")
      .with("createFunction", "now")
      .with("isDate", "true")
      .with("isString", "false")
      .with("graphqlType", "LocalTime")
      .with("isTime", "true")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.campaign.Campaign.VERSION_PROPERTY).with("isPassword", "false")
      .with("isVersion", "true")
      .with("oracle_sqlType", "number(11)")
      .with("javaType", "java.lang.Long")
      .with("sqlType", "BIGINT")
      .with("isId", "false")
      .with("isBaseEntityField", "true")
      .with("isBool", "false")
      .with("isNumber", "false")
      .with("isString", "false")
      .with("isDate", "false")
      .with("snowflake_sqlType", "number")
      .with("graphqlType", "Long")
      .with("isTime", "false")
      .with("isText", "false");

      $factory.register(entityDescriptor);
  }
  private void registerContract() {
      EntityDescriptor entityDescriptor = new EntityDescriptor();
      entityDescriptor.setType(com.example.enterpriseerpsystem.contract.Contract.INTERNAL_TYPE);
      entityDescriptor.setTargetType(com.example.enterpriseerpsystem.contract.Contract.class);
      entityDescriptor.setEntitySupplier(com.example.enterpriseerpsystem.contract.Contract::new);
      entityDescriptor.with("name", "Contract")
      .with("module", "CRM")
      .with("module_key", "crm");

      PropertyDescriptor id = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.contract.Contract.ID_PROPERTY, Long.class)
      ;
      PropertyDescriptor customer = 
      entityDescriptor.addObjectProperty($factory, com.example.enterpriseerpsystem.contract.Contract.CUSTOMER_PROPERTY, com.example.enterpriseerpsystem.customer.Customer.INTERNAL_TYPE, com.example.enterpriseerpsystem.customer.Customer.CONTRACT_LIST_PROPERTY, com.example.enterpriseerpsystem.customer.Customer.class)
      ;
      PropertyDescriptor endDate = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.contract.Contract.END_DATE_PROPERTY, LocalDateTime.class)
      ;
      PropertyDescriptor startDate = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.contract.Contract.START_DATE_PROPERTY, LocalDateTime.class)
      ;
      PropertyDescriptor terms = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.contract.Contract.TERMS_PROPERTY, String.class)
      ;
      PropertyDescriptor value = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.contract.Contract.VALUE_PROPERTY, BigDecimal.class)
      ;
      PropertyDescriptor createTime = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.contract.Contract.CREATE_TIME_PROPERTY, LocalDateTime.class)
      ;
      PropertyDescriptor updateTime = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.contract.Contract.UPDATE_TIME_PROPERTY, LocalDateTime.class)
      ;
      PropertyDescriptor version = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.contract.Contract.VERSION_PROPERTY, Long.class)
      ;
      entityDescriptor.findProperty(com.example.enterpriseerpsystem.contract.Contract.ID_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("oracle_sqlType", "number(11)")
      .with("javaType", "java.lang.Long")
      .with("sqlType", "BIGINT")
      .with("isId", "true")
      .with("isBaseEntityField", "true")
      .with("isBool", "false")
      .with("isNumber", "false")
      .with("isString", "false")
      .with("isDate", "false")
      .with("snowflake_sqlType", "number")
      .with("graphqlType", "Long")
      .with("isTime", "false")
      .with("isText", "false");


      entityDescriptor.findProperty(com.example.enterpriseerpsystem.contract.Contract.END_DATE_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("javaType", "java.time.LocalDateTime")
      .with("sqlType", "TIMESTAMP")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("mssql_sqlType", "dateTime")
      .with("isDateTime", "true")
      .with("createFunction", "now")
      .with("isDate", "true")
      .with("isString", "false")
      .with("graphqlType", "LocalTime")
      .with("isTime", "true")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.contract.Contract.START_DATE_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("javaType", "java.time.LocalDateTime")
      .with("sqlType", "TIMESTAMP")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("mssql_sqlType", "dateTime")
      .with("isDateTime", "true")
      .with("createFunction", "now")
      .with("isDate", "true")
      .with("isString", "false")
      .with("graphqlType", "LocalTime")
      .with("isTime", "true")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.contract.Contract.TERMS_PROPERTY).with("isPassword", "false")
      .with("max", "100")
      .with("isVersion", "false")
      .with("javaType", "java.lang.String")
      .with("sqlType", "VARCHAR(<max>)")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("isString", "true")
      .with("isDate", "false")
      .with("graphqlType", "String")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.contract.Contract.VALUE_PROPERTY).with("isPassword", "false")
      .with("db2_sqlType", "decimal(19,7)")
      .with("isVersion", "false")
      .with("oracle_sqlType", "number(19,7)")
      .with("javaType", "java.math.BigDecimal")
      .with("sqlType", "NUMERIC(19,7)")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "true")
      .with("isString", "false")
      .with("isDate", "false")
      .with("graphqlType", "BigDecimal")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.contract.Contract.CREATE_TIME_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("javaType", "java.time.LocalDateTime")
      .with("sqlType", "TIMESTAMP")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("mssql_sqlType", "dateTime")
      .with("isDateTime", "true")
      .with("createFunction", "now")
      .with("isDate", "true")
      .with("isString", "false")
      .with("graphqlType", "LocalTime")
      .with("isTime", "true")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.contract.Contract.UPDATE_TIME_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("updateFunction", "now")
      .with("javaType", "java.time.LocalDateTime")
      .with("sqlType", "TIMESTAMP")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("mssql_sqlType", "dateTime")
      .with("isDateTime", "true")
      .with("createFunction", "now")
      .with("isDate", "true")
      .with("isString", "false")
      .with("graphqlType", "LocalTime")
      .with("isTime", "true")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.contract.Contract.VERSION_PROPERTY).with("isPassword", "false")
      .with("isVersion", "true")
      .with("oracle_sqlType", "number(11)")
      .with("javaType", "java.lang.Long")
      .with("sqlType", "BIGINT")
      .with("isId", "false")
      .with("isBaseEntityField", "true")
      .with("isBool", "false")
      .with("isNumber", "false")
      .with("isString", "false")
      .with("isDate", "false")
      .with("snowflake_sqlType", "number")
      .with("graphqlType", "Long")
      .with("isTime", "false")
      .with("isText", "false");

      $factory.register(entityDescriptor);
  }
  private void registerQuote() {
      EntityDescriptor entityDescriptor = new EntityDescriptor();
      entityDescriptor.setType(com.example.enterpriseerpsystem.quote.Quote.INTERNAL_TYPE);
      entityDescriptor.setTargetType(com.example.enterpriseerpsystem.quote.Quote.class);
      entityDescriptor.setEntitySupplier(com.example.enterpriseerpsystem.quote.Quote::new);
      entityDescriptor.with("name", "Quote")
      .with("module", "CRM")
      .with("module_key", "crm");

      PropertyDescriptor id = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.quote.Quote.ID_PROPERTY, Long.class)
      ;
      PropertyDescriptor totalAmount = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.quote.Quote.TOTAL_AMOUNT_PROPERTY, BigDecimal.class)
      ;
      PropertyDescriptor opportunity = 
      entityDescriptor.addObjectProperty($factory, com.example.enterpriseerpsystem.quote.Quote.OPPORTUNITY_PROPERTY, com.example.enterpriseerpsystem.opportunity.Opportunity.INTERNAL_TYPE, com.example.enterpriseerpsystem.opportunity.Opportunity.QUOTE_LIST_PROPERTY, com.example.enterpriseerpsystem.opportunity.Opportunity.class)
      ;
      PropertyDescriptor status = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.quote.Quote.STATUS_PROPERTY, String.class)
      ;
      PropertyDescriptor validUntil = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.quote.Quote.VALID_UNTIL_PROPERTY, LocalDateTime.class)
      ;
      PropertyDescriptor createTime = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.quote.Quote.CREATE_TIME_PROPERTY, LocalDateTime.class)
      ;
      PropertyDescriptor updateTime = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.quote.Quote.UPDATE_TIME_PROPERTY, LocalDateTime.class)
      ;
      PropertyDescriptor version = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.quote.Quote.VERSION_PROPERTY, Long.class)
      ;
      entityDescriptor.findProperty(com.example.enterpriseerpsystem.quote.Quote.ID_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("oracle_sqlType", "number(11)")
      .with("javaType", "java.lang.Long")
      .with("sqlType", "BIGINT")
      .with("isId", "true")
      .with("isBaseEntityField", "true")
      .with("isBool", "false")
      .with("isNumber", "false")
      .with("isString", "false")
      .with("isDate", "false")
      .with("snowflake_sqlType", "number")
      .with("graphqlType", "Long")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.quote.Quote.TOTAL_AMOUNT_PROPERTY).with("isPassword", "false")
      .with("db2_sqlType", "decimal(19,7)")
      .with("isVersion", "false")
      .with("oracle_sqlType", "number(19,7)")
      .with("javaType", "java.math.BigDecimal")
      .with("sqlType", "NUMERIC(19,7)")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "true")
      .with("isString", "false")
      .with("isDate", "false")
      .with("graphqlType", "BigDecimal")
      .with("isTime", "false")
      .with("isText", "false");


      entityDescriptor.findProperty(com.example.enterpriseerpsystem.quote.Quote.STATUS_PROPERTY).with("isPassword", "false")
      .with("max", "100")
      .with("isVersion", "false")
      .with("javaType", "java.lang.String")
      .with("sqlType", "VARCHAR(<max>)")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("isString", "true")
      .with("isDate", "false")
      .with("graphqlType", "String")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.quote.Quote.VALID_UNTIL_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("javaType", "java.time.LocalDateTime")
      .with("sqlType", "TIMESTAMP")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("mssql_sqlType", "dateTime")
      .with("isDateTime", "true")
      .with("createFunction", "now")
      .with("isDate", "true")
      .with("isString", "false")
      .with("graphqlType", "LocalTime")
      .with("isTime", "true")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.quote.Quote.CREATE_TIME_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("javaType", "java.time.LocalDateTime")
      .with("sqlType", "TIMESTAMP")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("mssql_sqlType", "dateTime")
      .with("isDateTime", "true")
      .with("createFunction", "now")
      .with("isDate", "true")
      .with("isString", "false")
      .with("graphqlType", "LocalTime")
      .with("isTime", "true")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.quote.Quote.UPDATE_TIME_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("updateFunction", "now")
      .with("javaType", "java.time.LocalDateTime")
      .with("sqlType", "TIMESTAMP")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("mssql_sqlType", "dateTime")
      .with("isDateTime", "true")
      .with("createFunction", "now")
      .with("isDate", "true")
      .with("isString", "false")
      .with("graphqlType", "LocalTime")
      .with("isTime", "true")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.quote.Quote.VERSION_PROPERTY).with("isPassword", "false")
      .with("isVersion", "true")
      .with("oracle_sqlType", "number(11)")
      .with("javaType", "java.lang.Long")
      .with("sqlType", "BIGINT")
      .with("isId", "false")
      .with("isBaseEntityField", "true")
      .with("isBool", "false")
      .with("isNumber", "false")
      .with("isString", "false")
      .with("isDate", "false")
      .with("snowflake_sqlType", "number")
      .with("graphqlType", "Long")
      .with("isTime", "false")
      .with("isText", "false");

      $factory.register(entityDescriptor);
  }
  private void registerSalesTerritory() {
      EntityDescriptor entityDescriptor = new EntityDescriptor();
      entityDescriptor.setType(com.example.enterpriseerpsystem.salesterritory.SalesTerritory.INTERNAL_TYPE);
      entityDescriptor.setTargetType(com.example.enterpriseerpsystem.salesterritory.SalesTerritory.class);
      entityDescriptor.setEntitySupplier(com.example.enterpriseerpsystem.salesterritory.SalesTerritory::new);
      entityDescriptor.with("name", "Sales Territory")
      .with("module", "CRM")
      .with("module_key", "crm");

      PropertyDescriptor id = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.salesterritory.SalesTerritory.ID_PROPERTY, Long.class)
      ;
      PropertyDescriptor name = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.salesterritory.SalesTerritory.NAME_PROPERTY, String.class)
      ;
      PropertyDescriptor managerId = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.salesterritory.SalesTerritory.MANAGER_ID_PROPERTY, String.class)
      ;
      PropertyDescriptor region = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.salesterritory.SalesTerritory.REGION_PROPERTY, String.class)
      ;
      PropertyDescriptor createTime = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.salesterritory.SalesTerritory.CREATE_TIME_PROPERTY, LocalDateTime.class)
      ;
      PropertyDescriptor updateTime = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.salesterritory.SalesTerritory.UPDATE_TIME_PROPERTY, LocalDateTime.class)
      ;
      PropertyDescriptor version = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.salesterritory.SalesTerritory.VERSION_PROPERTY, Long.class)
      ;
      entityDescriptor.findProperty(com.example.enterpriseerpsystem.salesterritory.SalesTerritory.ID_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("oracle_sqlType", "number(11)")
      .with("javaType", "java.lang.Long")
      .with("sqlType", "BIGINT")
      .with("isId", "true")
      .with("isBaseEntityField", "true")
      .with("isBool", "false")
      .with("isNumber", "false")
      .with("isString", "false")
      .with("isDate", "false")
      .with("snowflake_sqlType", "number")
      .with("graphqlType", "Long")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.salesterritory.SalesTerritory.NAME_PROPERTY).with("isPassword", "false")
      .with("max", "100")
      .with("isVersion", "false")
      .with("javaType", "java.lang.String")
      .with("candidates", "name_value")
      .with("sqlType", "VARCHAR(<max>)")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("isString", "true")
      .with("isDate", "false")
      .with("graphqlType", "String")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.salesterritory.SalesTerritory.MANAGER_ID_PROPERTY).with("isPassword", "false")
      .with("max", "100")
      .with("isVersion", "false")
      .with("javaType", "java.lang.String")
      .with("candidates", "manager_id_value")
      .with("sqlType", "VARCHAR(<max>)")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("isString", "true")
      .with("isDate", "false")
      .with("graphqlType", "String")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.salesterritory.SalesTerritory.REGION_PROPERTY).with("isPassword", "false")
      .with("max", "100")
      .with("isVersion", "false")
      .with("javaType", "java.lang.String")
      .with("candidates", "region_value")
      .with("sqlType", "VARCHAR(<max>)")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("isString", "true")
      .with("isDate", "false")
      .with("graphqlType", "String")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.salesterritory.SalesTerritory.CREATE_TIME_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("javaType", "java.time.LocalDateTime")
      .with("candidates", "createTime()")
      .with("sqlType", "TIMESTAMP")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("mssql_sqlType", "dateTime")
      .with("isDateTime", "true")
      .with("createFunction", "now")
      .with("isDate", "true")
      .with("isString", "false")
      .with("graphqlType", "LocalTime")
      .with("isTime", "true")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.salesterritory.SalesTerritory.UPDATE_TIME_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("updateFunction", "now")
      .with("javaType", "java.time.LocalDateTime")
      .with("candidates", "updateTime()")
      .with("sqlType", "TIMESTAMP")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("mssql_sqlType", "dateTime")
      .with("isDateTime", "true")
      .with("createFunction", "now")
      .with("isDate", "true")
      .with("isString", "false")
      .with("graphqlType", "LocalTime")
      .with("isTime", "true")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.salesterritory.SalesTerritory.VERSION_PROPERTY).with("isPassword", "false")
      .with("isVersion", "true")
      .with("oracle_sqlType", "number(11)")
      .with("javaType", "java.lang.Long")
      .with("sqlType", "BIGINT")
      .with("isId", "false")
      .with("isBaseEntityField", "true")
      .with("isBool", "false")
      .with("isNumber", "false")
      .with("isString", "false")
      .with("isDate", "false")
      .with("snowflake_sqlType", "number")
      .with("graphqlType", "Long")
      .with("isTime", "false")
      .with("isText", "false");

      $factory.register(entityDescriptor);
  }
  private void registerProduct() {
      EntityDescriptor entityDescriptor = new EntityDescriptor();
      entityDescriptor.setType(com.example.enterpriseerpsystem.product.Product.INTERNAL_TYPE);
      entityDescriptor.setTargetType(com.example.enterpriseerpsystem.product.Product.class);
      entityDescriptor.setEntitySupplier(com.example.enterpriseerpsystem.product.Product::new);
      entityDescriptor.with("name", "Product")
      .with("module", "ECommerce")
      .with("module_key", "ecommerce");

      PropertyDescriptor id = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.product.Product.ID_PROPERTY, Long.class)
      ;
      PropertyDescriptor name = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.product.Product.NAME_PROPERTY, String.class)
      ;
      PropertyDescriptor price = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.product.Product.PRICE_PROPERTY, BigDecimal.class)
      ;
      PropertyDescriptor category = 
      entityDescriptor.addObjectProperty($factory, com.example.enterpriseerpsystem.product.Product.CATEGORY_PROPERTY, com.example.enterpriseerpsystem.category.Category.INTERNAL_TYPE, com.example.enterpriseerpsystem.category.Category.PRODUCT_LIST_PROPERTY, com.example.enterpriseerpsystem.category.Category.class)
      ;
      PropertyDescriptor cost = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.product.Product.COST_PROPERTY, BigDecimal.class)
      ;
      PropertyDescriptor isActive = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.product.Product.IS_ACTIVE_PROPERTY, Boolean.class)
      ;
      PropertyDescriptor sku = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.product.Product.SKU_PROPERTY, String.class)
      ;
      PropertyDescriptor stock = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.product.Product.STOCK_PROPERTY, BigDecimal.class)
      ;
      PropertyDescriptor createTime = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.product.Product.CREATE_TIME_PROPERTY, LocalDateTime.class)
      ;
      PropertyDescriptor updateTime = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.product.Product.UPDATE_TIME_PROPERTY, LocalDateTime.class)
      ;
      PropertyDescriptor version = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.product.Product.VERSION_PROPERTY, Long.class)
      ;
      entityDescriptor.findProperty(com.example.enterpriseerpsystem.product.Product.ID_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("oracle_sqlType", "number(11)")
      .with("javaType", "java.lang.Long")
      .with("sqlType", "BIGINT")
      .with("isId", "true")
      .with("isBaseEntityField", "true")
      .with("isBool", "false")
      .with("isNumber", "false")
      .with("isString", "false")
      .with("isDate", "false")
      .with("snowflake_sqlType", "number")
      .with("graphqlType", "Long")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.product.Product.NAME_PROPERTY).with("isPassword", "false")
      .with("max", "100")
      .with("isVersion", "false")
      .with("javaType", "java.lang.String")
      .with("sqlType", "VARCHAR(<max>)")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("isString", "true")
      .with("isDate", "false")
      .with("graphqlType", "String")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.product.Product.PRICE_PROPERTY).with("isPassword", "false")
      .with("db2_sqlType", "decimal(19,7)")
      .with("isVersion", "false")
      .with("oracle_sqlType", "number(19,7)")
      .with("javaType", "java.math.BigDecimal")
      .with("sqlType", "NUMERIC(19,7)")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "true")
      .with("isString", "false")
      .with("isDate", "false")
      .with("graphqlType", "BigDecimal")
      .with("isTime", "false")
      .with("isText", "false");


      entityDescriptor.findProperty(com.example.enterpriseerpsystem.product.Product.COST_PROPERTY).with("isPassword", "false")
      .with("db2_sqlType", "decimal(19,7)")
      .with("isVersion", "false")
      .with("oracle_sqlType", "number(19,7)")
      .with("javaType", "java.math.BigDecimal")
      .with("sqlType", "NUMERIC(19,7)")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "true")
      .with("isString", "false")
      .with("isDate", "false")
      .with("graphqlType", "BigDecimal")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.product.Product.IS_ACTIVE_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("oracle_sqlType", "number(1)")
      .with("javaType", "java.lang.Boolean")
      .with("sqlType", "BOOLEAN")
      .with("isId", "false")
      .with("isBool", "true")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("mssql_sqlType", "bit")
      .with("isString", "false")
      .with("isDate", "false")
      .with("graphqlType", "Boolean")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.product.Product.SKU_PROPERTY).with("isPassword", "false")
      .with("max", "100")
      .with("isVersion", "false")
      .with("javaType", "java.lang.String")
      .with("sqlType", "VARCHAR(<max>)")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("isString", "true")
      .with("isDate", "false")
      .with("graphqlType", "String")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.product.Product.STOCK_PROPERTY).with("isPassword", "false")
      .with("db2_sqlType", "decimal(19,7)")
      .with("isVersion", "false")
      .with("oracle_sqlType", "number(19,7)")
      .with("javaType", "java.math.BigDecimal")
      .with("sqlType", "NUMERIC(19,7)")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "true")
      .with("isString", "false")
      .with("isDate", "false")
      .with("graphqlType", "BigDecimal")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.product.Product.CREATE_TIME_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("javaType", "java.time.LocalDateTime")
      .with("sqlType", "TIMESTAMP")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("mssql_sqlType", "dateTime")
      .with("isDateTime", "true")
      .with("createFunction", "now")
      .with("isDate", "true")
      .with("isString", "false")
      .with("graphqlType", "LocalTime")
      .with("isTime", "true")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.product.Product.UPDATE_TIME_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("updateFunction", "now")
      .with("javaType", "java.time.LocalDateTime")
      .with("sqlType", "TIMESTAMP")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("mssql_sqlType", "dateTime")
      .with("isDateTime", "true")
      .with("createFunction", "now")
      .with("isDate", "true")
      .with("isString", "false")
      .with("graphqlType", "LocalTime")
      .with("isTime", "true")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.product.Product.VERSION_PROPERTY).with("isPassword", "false")
      .with("isVersion", "true")
      .with("oracle_sqlType", "number(11)")
      .with("javaType", "java.lang.Long")
      .with("sqlType", "BIGINT")
      .with("isId", "false")
      .with("isBaseEntityField", "true")
      .with("isBool", "false")
      .with("isNumber", "false")
      .with("isString", "false")
      .with("isDate", "false")
      .with("snowflake_sqlType", "number")
      .with("graphqlType", "Long")
      .with("isTime", "false")
      .with("isText", "false");

      $factory.register(entityDescriptor);
  }
  private void registerCategory() {
      EntityDescriptor entityDescriptor = new EntityDescriptor();
      entityDescriptor.setType(com.example.enterpriseerpsystem.category.Category.INTERNAL_TYPE);
      entityDescriptor.setTargetType(com.example.enterpriseerpsystem.category.Category.class);
      entityDescriptor.setEntitySupplier(com.example.enterpriseerpsystem.category.Category::new);
      entityDescriptor.with("name", "Category")
      .with("module", "ECommerce")
      .with("module_key", "ecommerce");

      PropertyDescriptor id = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.category.Category.ID_PROPERTY, Long.class)
      ;
      PropertyDescriptor description = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.category.Category.DESCRIPTION_PROPERTY, String.class)
      ;
      PropertyDescriptor name = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.category.Category.NAME_PROPERTY, String.class)
      ;
      PropertyDescriptor parentId = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.category.Category.PARENT_ID_PROPERTY, String.class)
      ;
      PropertyDescriptor createTime = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.category.Category.CREATE_TIME_PROPERTY, LocalDateTime.class)
      ;
      PropertyDescriptor updateTime = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.category.Category.UPDATE_TIME_PROPERTY, LocalDateTime.class)
      ;
      PropertyDescriptor version = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.category.Category.VERSION_PROPERTY, Long.class)
      ;
      entityDescriptor.findProperty(com.example.enterpriseerpsystem.category.Category.ID_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("oracle_sqlType", "number(11)")
      .with("javaType", "java.lang.Long")
      .with("sqlType", "BIGINT")
      .with("isId", "true")
      .with("isBaseEntityField", "true")
      .with("isBool", "false")
      .with("isNumber", "false")
      .with("isString", "false")
      .with("isDate", "false")
      .with("snowflake_sqlType", "number")
      .with("graphqlType", "Long")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.category.Category.DESCRIPTION_PROPERTY).with("isPassword", "false")
      .with("max", "100")
      .with("isVersion", "false")
      .with("javaType", "java.lang.String")
      .with("candidates", "description_value")
      .with("sqlType", "VARCHAR(<max>)")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("isString", "true")
      .with("isDate", "false")
      .with("graphqlType", "String")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.category.Category.NAME_PROPERTY).with("isPassword", "false")
      .with("max", "100")
      .with("isVersion", "false")
      .with("javaType", "java.lang.String")
      .with("candidates", "name_value")
      .with("sqlType", "VARCHAR(<max>)")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("isString", "true")
      .with("isDate", "false")
      .with("graphqlType", "String")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.category.Category.PARENT_ID_PROPERTY).with("isPassword", "false")
      .with("max", "100")
      .with("isVersion", "false")
      .with("javaType", "java.lang.String")
      .with("candidates", "parent_id_value")
      .with("sqlType", "VARCHAR(<max>)")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("isString", "true")
      .with("isDate", "false")
      .with("graphqlType", "String")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.category.Category.CREATE_TIME_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("javaType", "java.time.LocalDateTime")
      .with("candidates", "createTime()")
      .with("sqlType", "TIMESTAMP")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("mssql_sqlType", "dateTime")
      .with("isDateTime", "true")
      .with("createFunction", "now")
      .with("isDate", "true")
      .with("isString", "false")
      .with("graphqlType", "LocalTime")
      .with("isTime", "true")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.category.Category.UPDATE_TIME_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("updateFunction", "now")
      .with("javaType", "java.time.LocalDateTime")
      .with("candidates", "updateTime()")
      .with("sqlType", "TIMESTAMP")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("mssql_sqlType", "dateTime")
      .with("isDateTime", "true")
      .with("createFunction", "now")
      .with("isDate", "true")
      .with("isString", "false")
      .with("graphqlType", "LocalTime")
      .with("isTime", "true")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.category.Category.VERSION_PROPERTY).with("isPassword", "false")
      .with("isVersion", "true")
      .with("oracle_sqlType", "number(11)")
      .with("javaType", "java.lang.Long")
      .with("sqlType", "BIGINT")
      .with("isId", "false")
      .with("isBaseEntityField", "true")
      .with("isBool", "false")
      .with("isNumber", "false")
      .with("isString", "false")
      .with("isDate", "false")
      .with("snowflake_sqlType", "number")
      .with("graphqlType", "Long")
      .with("isTime", "false")
      .with("isText", "false");

      $factory.register(entityDescriptor);
  }
  private void registerCatalog() {
      EntityDescriptor entityDescriptor = new EntityDescriptor();
      entityDescriptor.setType(com.example.enterpriseerpsystem.catalog.Catalog.INTERNAL_TYPE);
      entityDescriptor.setTargetType(com.example.enterpriseerpsystem.catalog.Catalog.class);
      entityDescriptor.setEntitySupplier(com.example.enterpriseerpsystem.catalog.Catalog::new);
      entityDescriptor.with("name", "Catalog")
      .with("module", "ECommerce")
      .with("module_key", "ecommerce");

      PropertyDescriptor id = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.catalog.Catalog.ID_PROPERTY, Long.class)
      ;
      PropertyDescriptor name = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.catalog.Catalog.NAME_PROPERTY, String.class)
      ;
      PropertyDescriptor season = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.catalog.Catalog.SEASON_PROPERTY, String.class)
      ;
      PropertyDescriptor validFrom = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.catalog.Catalog.VALID_FROM_PROPERTY, LocalDateTime.class)
      ;
      PropertyDescriptor validTo = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.catalog.Catalog.VALID_TO_PROPERTY, LocalDateTime.class)
      ;
      PropertyDescriptor createTime = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.catalog.Catalog.CREATE_TIME_PROPERTY, LocalDateTime.class)
      ;
      PropertyDescriptor updateTime = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.catalog.Catalog.UPDATE_TIME_PROPERTY, LocalDateTime.class)
      ;
      PropertyDescriptor version = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.catalog.Catalog.VERSION_PROPERTY, Long.class)
      ;
      entityDescriptor.findProperty(com.example.enterpriseerpsystem.catalog.Catalog.ID_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("oracle_sqlType", "number(11)")
      .with("javaType", "java.lang.Long")
      .with("sqlType", "BIGINT")
      .with("isId", "true")
      .with("isBaseEntityField", "true")
      .with("isBool", "false")
      .with("isNumber", "false")
      .with("isString", "false")
      .with("isDate", "false")
      .with("snowflake_sqlType", "number")
      .with("graphqlType", "Long")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.catalog.Catalog.NAME_PROPERTY).with("isPassword", "false")
      .with("max", "100")
      .with("isVersion", "false")
      .with("javaType", "java.lang.String")
      .with("candidates", "name_value")
      .with("sqlType", "VARCHAR(<max>)")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("isString", "true")
      .with("isDate", "false")
      .with("graphqlType", "String")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.catalog.Catalog.SEASON_PROPERTY).with("isPassword", "false")
      .with("max", "100")
      .with("isVersion", "false")
      .with("javaType", "java.lang.String")
      .with("candidates", "season_value")
      .with("sqlType", "VARCHAR(<max>)")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("isString", "true")
      .with("isDate", "false")
      .with("graphqlType", "String")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.catalog.Catalog.VALID_FROM_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("javaType", "java.time.LocalDateTime")
      .with("candidates", "createTime()")
      .with("sqlType", "TIMESTAMP")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("mssql_sqlType", "dateTime")
      .with("isDateTime", "true")
      .with("createFunction", "now")
      .with("isDate", "true")
      .with("isString", "false")
      .with("graphqlType", "LocalTime")
      .with("isTime", "true")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.catalog.Catalog.VALID_TO_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("javaType", "java.time.LocalDateTime")
      .with("candidates", "createTime()")
      .with("sqlType", "TIMESTAMP")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("mssql_sqlType", "dateTime")
      .with("isDateTime", "true")
      .with("createFunction", "now")
      .with("isDate", "true")
      .with("isString", "false")
      .with("graphqlType", "LocalTime")
      .with("isTime", "true")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.catalog.Catalog.CREATE_TIME_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("javaType", "java.time.LocalDateTime")
      .with("candidates", "createTime()")
      .with("sqlType", "TIMESTAMP")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("mssql_sqlType", "dateTime")
      .with("isDateTime", "true")
      .with("createFunction", "now")
      .with("isDate", "true")
      .with("isString", "false")
      .with("graphqlType", "LocalTime")
      .with("isTime", "true")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.catalog.Catalog.UPDATE_TIME_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("updateFunction", "now")
      .with("javaType", "java.time.LocalDateTime")
      .with("candidates", "updateTime()")
      .with("sqlType", "TIMESTAMP")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("mssql_sqlType", "dateTime")
      .with("isDateTime", "true")
      .with("createFunction", "now")
      .with("isDate", "true")
      .with("isString", "false")
      .with("graphqlType", "LocalTime")
      .with("isTime", "true")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.catalog.Catalog.VERSION_PROPERTY).with("isPassword", "false")
      .with("isVersion", "true")
      .with("oracle_sqlType", "number(11)")
      .with("javaType", "java.lang.Long")
      .with("sqlType", "BIGINT")
      .with("isId", "false")
      .with("isBaseEntityField", "true")
      .with("isBool", "false")
      .with("isNumber", "false")
      .with("isString", "false")
      .with("isDate", "false")
      .with("snowflake_sqlType", "number")
      .with("graphqlType", "Long")
      .with("isTime", "false")
      .with("isText", "false");

      $factory.register(entityDescriptor);
  }
  private void registerProductReview() {
      EntityDescriptor entityDescriptor = new EntityDescriptor();
      entityDescriptor.setType(com.example.enterpriseerpsystem.productreview.ProductReview.INTERNAL_TYPE);
      entityDescriptor.setTargetType(com.example.enterpriseerpsystem.productreview.ProductReview.class);
      entityDescriptor.setEntitySupplier(com.example.enterpriseerpsystem.productreview.ProductReview::new);
      entityDescriptor.with("name", "Product Review")
      .with("module", "ECommerce")
      .with("module_key", "ecommerce");

      PropertyDescriptor id = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.productreview.ProductReview.ID_PROPERTY, Long.class)
      ;
      PropertyDescriptor createdAt = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.productreview.ProductReview.CREATED_AT_PROPERTY, LocalDateTime.class)
      ;
      PropertyDescriptor customer = 
      entityDescriptor.addObjectProperty($factory, com.example.enterpriseerpsystem.productreview.ProductReview.CUSTOMER_PROPERTY, com.example.enterpriseerpsystem.customer.Customer.INTERNAL_TYPE, com.example.enterpriseerpsystem.customer.Customer.PRODUCT_REVIEW_LIST_PROPERTY, com.example.enterpriseerpsystem.customer.Customer.class)
      ;
      PropertyDescriptor product = 
      entityDescriptor.addObjectProperty($factory, com.example.enterpriseerpsystem.productreview.ProductReview.PRODUCT_PROPERTY, com.example.enterpriseerpsystem.product.Product.INTERNAL_TYPE, com.example.enterpriseerpsystem.product.Product.PRODUCT_REVIEW_LIST_PROPERTY, com.example.enterpriseerpsystem.product.Product.class)
      ;
      PropertyDescriptor rating = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.productreview.ProductReview.RATING_PROPERTY, BigDecimal.class)
      ;
      PropertyDescriptor reviewText = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.productreview.ProductReview.REVIEW_TEXT_PROPERTY, String.class)
      ;
      PropertyDescriptor createTime = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.productreview.ProductReview.CREATE_TIME_PROPERTY, LocalDateTime.class)
      ;
      PropertyDescriptor updateTime = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.productreview.ProductReview.UPDATE_TIME_PROPERTY, LocalDateTime.class)
      ;
      PropertyDescriptor version = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.productreview.ProductReview.VERSION_PROPERTY, Long.class)
      ;
      entityDescriptor.findProperty(com.example.enterpriseerpsystem.productreview.ProductReview.ID_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("oracle_sqlType", "number(11)")
      .with("javaType", "java.lang.Long")
      .with("sqlType", "BIGINT")
      .with("isId", "true")
      .with("isBaseEntityField", "true")
      .with("isBool", "false")
      .with("isNumber", "false")
      .with("isString", "false")
      .with("isDate", "false")
      .with("snowflake_sqlType", "number")
      .with("graphqlType", "Long")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.productreview.ProductReview.CREATED_AT_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("javaType", "java.time.LocalDateTime")
      .with("sqlType", "TIMESTAMP")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("mssql_sqlType", "dateTime")
      .with("isDateTime", "true")
      .with("createFunction", "now")
      .with("isDate", "true")
      .with("isString", "false")
      .with("graphqlType", "LocalTime")
      .with("isTime", "true")
      .with("isText", "false");



      entityDescriptor.findProperty(com.example.enterpriseerpsystem.productreview.ProductReview.RATING_PROPERTY).with("isPassword", "false")
      .with("db2_sqlType", "decimal(19,7)")
      .with("isVersion", "false")
      .with("oracle_sqlType", "number(19,7)")
      .with("javaType", "java.math.BigDecimal")
      .with("sqlType", "NUMERIC(19,7)")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "true")
      .with("isString", "false")
      .with("isDate", "false")
      .with("graphqlType", "BigDecimal")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.productreview.ProductReview.REVIEW_TEXT_PROPERTY).with("isPassword", "false")
      .with("max", "100")
      .with("isVersion", "false")
      .with("javaType", "java.lang.String")
      .with("sqlType", "VARCHAR(<max>)")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("isString", "true")
      .with("isDate", "false")
      .with("graphqlType", "String")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.productreview.ProductReview.CREATE_TIME_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("javaType", "java.time.LocalDateTime")
      .with("sqlType", "TIMESTAMP")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("mssql_sqlType", "dateTime")
      .with("isDateTime", "true")
      .with("createFunction", "now")
      .with("isDate", "true")
      .with("isString", "false")
      .with("graphqlType", "LocalTime")
      .with("isTime", "true")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.productreview.ProductReview.UPDATE_TIME_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("updateFunction", "now")
      .with("javaType", "java.time.LocalDateTime")
      .with("sqlType", "TIMESTAMP")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("mssql_sqlType", "dateTime")
      .with("isDateTime", "true")
      .with("createFunction", "now")
      .with("isDate", "true")
      .with("isString", "false")
      .with("graphqlType", "LocalTime")
      .with("isTime", "true")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.productreview.ProductReview.VERSION_PROPERTY).with("isPassword", "false")
      .with("isVersion", "true")
      .with("oracle_sqlType", "number(11)")
      .with("javaType", "java.lang.Long")
      .with("sqlType", "BIGINT")
      .with("isId", "false")
      .with("isBaseEntityField", "true")
      .with("isBool", "false")
      .with("isNumber", "false")
      .with("isString", "false")
      .with("isDate", "false")
      .with("snowflake_sqlType", "number")
      .with("graphqlType", "Long")
      .with("isTime", "false")
      .with("isText", "false");

      $factory.register(entityDescriptor);
  }
  private void registerShoppingCart() {
      EntityDescriptor entityDescriptor = new EntityDescriptor();
      entityDescriptor.setType(com.example.enterpriseerpsystem.shoppingcart.ShoppingCart.INTERNAL_TYPE);
      entityDescriptor.setTargetType(com.example.enterpriseerpsystem.shoppingcart.ShoppingCart.class);
      entityDescriptor.setEntitySupplier(com.example.enterpriseerpsystem.shoppingcart.ShoppingCart::new);
      entityDescriptor.with("name", "Shopping Cart")
      .with("module", "ECommerce")
      .with("module_key", "ecommerce");

      PropertyDescriptor id = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.shoppingcart.ShoppingCart.ID_PROPERTY, Long.class)
      ;
      PropertyDescriptor createdAt = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.shoppingcart.ShoppingCart.CREATED_AT_PROPERTY, LocalDateTime.class)
      ;
      PropertyDescriptor customer = 
      entityDescriptor.addObjectProperty($factory, com.example.enterpriseerpsystem.shoppingcart.ShoppingCart.CUSTOMER_PROPERTY, com.example.enterpriseerpsystem.customer.Customer.INTERNAL_TYPE, com.example.enterpriseerpsystem.customer.Customer.SHOPPING_CART_LIST_PROPERTY, com.example.enterpriseerpsystem.customer.Customer.class)
      ;
      PropertyDescriptor isAbandoned = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.shoppingcart.ShoppingCart.IS_ABANDONED_PROPERTY, Boolean.class)
      ;
      PropertyDescriptor sessionId = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.shoppingcart.ShoppingCart.SESSION_ID_PROPERTY, String.class)
      ;
      PropertyDescriptor createTime = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.shoppingcart.ShoppingCart.CREATE_TIME_PROPERTY, LocalDateTime.class)
      ;
      PropertyDescriptor updateTime = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.shoppingcart.ShoppingCart.UPDATE_TIME_PROPERTY, LocalDateTime.class)
      ;
      PropertyDescriptor version = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.shoppingcart.ShoppingCart.VERSION_PROPERTY, Long.class)
      ;
      entityDescriptor.findProperty(com.example.enterpriseerpsystem.shoppingcart.ShoppingCart.ID_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("oracle_sqlType", "number(11)")
      .with("javaType", "java.lang.Long")
      .with("sqlType", "BIGINT")
      .with("isId", "true")
      .with("isBaseEntityField", "true")
      .with("isBool", "false")
      .with("isNumber", "false")
      .with("isString", "false")
      .with("isDate", "false")
      .with("snowflake_sqlType", "number")
      .with("graphqlType", "Long")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.shoppingcart.ShoppingCart.CREATED_AT_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("javaType", "java.time.LocalDateTime")
      .with("sqlType", "TIMESTAMP")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("mssql_sqlType", "dateTime")
      .with("isDateTime", "true")
      .with("createFunction", "now")
      .with("isDate", "true")
      .with("isString", "false")
      .with("graphqlType", "LocalTime")
      .with("isTime", "true")
      .with("isText", "false");


      entityDescriptor.findProperty(com.example.enterpriseerpsystem.shoppingcart.ShoppingCart.IS_ABANDONED_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("oracle_sqlType", "number(1)")
      .with("javaType", "java.lang.Boolean")
      .with("sqlType", "BOOLEAN")
      .with("isId", "false")
      .with("isBool", "true")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("mssql_sqlType", "bit")
      .with("isString", "false")
      .with("isDate", "false")
      .with("graphqlType", "Boolean")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.shoppingcart.ShoppingCart.SESSION_ID_PROPERTY).with("isPassword", "false")
      .with("max", "100")
      .with("isVersion", "false")
      .with("javaType", "java.lang.String")
      .with("sqlType", "VARCHAR(<max>)")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("isString", "true")
      .with("isDate", "false")
      .with("graphqlType", "String")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.shoppingcart.ShoppingCart.CREATE_TIME_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("javaType", "java.time.LocalDateTime")
      .with("sqlType", "TIMESTAMP")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("mssql_sqlType", "dateTime")
      .with("isDateTime", "true")
      .with("createFunction", "now")
      .with("isDate", "true")
      .with("isString", "false")
      .with("graphqlType", "LocalTime")
      .with("isTime", "true")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.shoppingcart.ShoppingCart.UPDATE_TIME_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("updateFunction", "now")
      .with("javaType", "java.time.LocalDateTime")
      .with("sqlType", "TIMESTAMP")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("mssql_sqlType", "dateTime")
      .with("isDateTime", "true")
      .with("createFunction", "now")
      .with("isDate", "true")
      .with("isString", "false")
      .with("graphqlType", "LocalTime")
      .with("isTime", "true")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.shoppingcart.ShoppingCart.VERSION_PROPERTY).with("isPassword", "false")
      .with("isVersion", "true")
      .with("oracle_sqlType", "number(11)")
      .with("javaType", "java.lang.Long")
      .with("sqlType", "BIGINT")
      .with("isId", "false")
      .with("isBaseEntityField", "true")
      .with("isBool", "false")
      .with("isNumber", "false")
      .with("isString", "false")
      .with("isDate", "false")
      .with("snowflake_sqlType", "number")
      .with("graphqlType", "Long")
      .with("isTime", "false")
      .with("isText", "false");

      $factory.register(entityDescriptor);
  }
  private void registerCartItem() {
      EntityDescriptor entityDescriptor = new EntityDescriptor();
      entityDescriptor.setType(com.example.enterpriseerpsystem.cartitem.CartItem.INTERNAL_TYPE);
      entityDescriptor.setTargetType(com.example.enterpriseerpsystem.cartitem.CartItem.class);
      entityDescriptor.setEntitySupplier(com.example.enterpriseerpsystem.cartitem.CartItem::new);
      entityDescriptor.with("name", "Cart Item")
      .with("module", "ECommerce")
      .with("module_key", "ecommerce");

      PropertyDescriptor id = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.cartitem.CartItem.ID_PROPERTY, Long.class)
      ;
      PropertyDescriptor product = 
      entityDescriptor.addObjectProperty($factory, com.example.enterpriseerpsystem.cartitem.CartItem.PRODUCT_PROPERTY, com.example.enterpriseerpsystem.product.Product.INTERNAL_TYPE, com.example.enterpriseerpsystem.product.Product.CART_ITEM_LIST_PROPERTY, com.example.enterpriseerpsystem.product.Product.class)
      ;
      PropertyDescriptor quantity = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.cartitem.CartItem.QUANTITY_PROPERTY, BigDecimal.class)
      ;
      PropertyDescriptor shoppingCart = 
      entityDescriptor.addObjectProperty($factory, com.example.enterpriseerpsystem.cartitem.CartItem.SHOPPING_CART_PROPERTY, com.example.enterpriseerpsystem.shoppingcart.ShoppingCart.INTERNAL_TYPE, com.example.enterpriseerpsystem.shoppingcart.ShoppingCart.CART_ITEM_LIST_PROPERTY, com.example.enterpriseerpsystem.shoppingcart.ShoppingCart.class)
      ;
      PropertyDescriptor createTime = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.cartitem.CartItem.CREATE_TIME_PROPERTY, LocalDateTime.class)
      ;
      PropertyDescriptor updateTime = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.cartitem.CartItem.UPDATE_TIME_PROPERTY, LocalDateTime.class)
      ;
      PropertyDescriptor version = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.cartitem.CartItem.VERSION_PROPERTY, Long.class)
      ;
      entityDescriptor.findProperty(com.example.enterpriseerpsystem.cartitem.CartItem.ID_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("oracle_sqlType", "number(11)")
      .with("javaType", "java.lang.Long")
      .with("sqlType", "BIGINT")
      .with("isId", "true")
      .with("isBaseEntityField", "true")
      .with("isBool", "false")
      .with("isNumber", "false")
      .with("isString", "false")
      .with("isDate", "false")
      .with("snowflake_sqlType", "number")
      .with("graphqlType", "Long")
      .with("isTime", "false")
      .with("isText", "false");


      entityDescriptor.findProperty(com.example.enterpriseerpsystem.cartitem.CartItem.QUANTITY_PROPERTY).with("isPassword", "false")
      .with("db2_sqlType", "decimal(19,7)")
      .with("isVersion", "false")
      .with("oracle_sqlType", "number(19,7)")
      .with("javaType", "java.math.BigDecimal")
      .with("sqlType", "NUMERIC(19,7)")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "true")
      .with("isString", "false")
      .with("isDate", "false")
      .with("graphqlType", "BigDecimal")
      .with("isTime", "false")
      .with("isText", "false");


      entityDescriptor.findProperty(com.example.enterpriseerpsystem.cartitem.CartItem.CREATE_TIME_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("javaType", "java.time.LocalDateTime")
      .with("sqlType", "TIMESTAMP")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("mssql_sqlType", "dateTime")
      .with("isDateTime", "true")
      .with("createFunction", "now")
      .with("isDate", "true")
      .with("isString", "false")
      .with("graphqlType", "LocalTime")
      .with("isTime", "true")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.cartitem.CartItem.UPDATE_TIME_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("updateFunction", "now")
      .with("javaType", "java.time.LocalDateTime")
      .with("sqlType", "TIMESTAMP")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("mssql_sqlType", "dateTime")
      .with("isDateTime", "true")
      .with("createFunction", "now")
      .with("isDate", "true")
      .with("isString", "false")
      .with("graphqlType", "LocalTime")
      .with("isTime", "true")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.cartitem.CartItem.VERSION_PROPERTY).with("isPassword", "false")
      .with("isVersion", "true")
      .with("oracle_sqlType", "number(11)")
      .with("javaType", "java.lang.Long")
      .with("sqlType", "BIGINT")
      .with("isId", "false")
      .with("isBaseEntityField", "true")
      .with("isBool", "false")
      .with("isNumber", "false")
      .with("isString", "false")
      .with("isDate", "false")
      .with("snowflake_sqlType", "number")
      .with("graphqlType", "Long")
      .with("isTime", "false")
      .with("isText", "false");

      $factory.register(entityDescriptor);
  }
  private void registerGlobalOrder() {
      EntityDescriptor entityDescriptor = new EntityDescriptor();
      entityDescriptor.setType(com.example.enterpriseerpsystem.globalorder.GlobalOrder.INTERNAL_TYPE);
      entityDescriptor.setTargetType(com.example.enterpriseerpsystem.globalorder.GlobalOrder.class);
      entityDescriptor.setEntitySupplier(com.example.enterpriseerpsystem.globalorder.GlobalOrder::new);
      entityDescriptor.with("name", "Global Order")
      .with("module", "ECommerce")
      .with("module_key", "ecommerce");

      PropertyDescriptor id = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.globalorder.GlobalOrder.ID_PROPERTY, Long.class)
      ;
      PropertyDescriptor shippingAddress = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.globalorder.GlobalOrder.SHIPPING_ADDRESS_PROPERTY, String.class)
      ;
      PropertyDescriptor totalAmount = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.globalorder.GlobalOrder.TOTAL_AMOUNT_PROPERTY, BigDecimal.class)
      ;
      PropertyDescriptor customer = 
      entityDescriptor.addObjectProperty($factory, com.example.enterpriseerpsystem.globalorder.GlobalOrder.CUSTOMER_PROPERTY, com.example.enterpriseerpsystem.customer.Customer.INTERNAL_TYPE, com.example.enterpriseerpsystem.customer.Customer.GLOBAL_ORDER_LIST_PROPERTY, com.example.enterpriseerpsystem.customer.Customer.class)
      ;
      PropertyDescriptor orderDate = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.globalorder.GlobalOrder.ORDER_DATE_PROPERTY, LocalDateTime.class)
      ;
      PropertyDescriptor status = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.globalorder.GlobalOrder.STATUS_PROPERTY, String.class)
      ;
      PropertyDescriptor createTime = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.globalorder.GlobalOrder.CREATE_TIME_PROPERTY, LocalDateTime.class)
      ;
      PropertyDescriptor updateTime = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.globalorder.GlobalOrder.UPDATE_TIME_PROPERTY, LocalDateTime.class)
      ;
      PropertyDescriptor version = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.globalorder.GlobalOrder.VERSION_PROPERTY, Long.class)
      ;
      entityDescriptor.findProperty(com.example.enterpriseerpsystem.globalorder.GlobalOrder.ID_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("oracle_sqlType", "number(11)")
      .with("javaType", "java.lang.Long")
      .with("sqlType", "BIGINT")
      .with("isId", "true")
      .with("isBaseEntityField", "true")
      .with("isBool", "false")
      .with("isNumber", "false")
      .with("isString", "false")
      .with("isDate", "false")
      .with("snowflake_sqlType", "number")
      .with("graphqlType", "Long")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.globalorder.GlobalOrder.SHIPPING_ADDRESS_PROPERTY).with("isPassword", "false")
      .with("max", "100")
      .with("isVersion", "false")
      .with("javaType", "java.lang.String")
      .with("sqlType", "VARCHAR(<max>)")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("isString", "true")
      .with("isDate", "false")
      .with("graphqlType", "String")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.globalorder.GlobalOrder.TOTAL_AMOUNT_PROPERTY).with("isPassword", "false")
      .with("db2_sqlType", "decimal(19,7)")
      .with("isVersion", "false")
      .with("oracle_sqlType", "number(19,7)")
      .with("javaType", "java.math.BigDecimal")
      .with("sqlType", "NUMERIC(19,7)")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "true")
      .with("isString", "false")
      .with("isDate", "false")
      .with("graphqlType", "BigDecimal")
      .with("isTime", "false")
      .with("isText", "false");


      entityDescriptor.findProperty(com.example.enterpriseerpsystem.globalorder.GlobalOrder.ORDER_DATE_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("javaType", "java.time.LocalDateTime")
      .with("sqlType", "TIMESTAMP")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("mssql_sqlType", "dateTime")
      .with("isDateTime", "true")
      .with("createFunction", "now")
      .with("isDate", "true")
      .with("isString", "false")
      .with("graphqlType", "LocalTime")
      .with("isTime", "true")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.globalorder.GlobalOrder.STATUS_PROPERTY).with("isPassword", "false")
      .with("max", "100")
      .with("isVersion", "false")
      .with("javaType", "java.lang.String")
      .with("sqlType", "VARCHAR(<max>)")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("isString", "true")
      .with("isDate", "false")
      .with("graphqlType", "String")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.globalorder.GlobalOrder.CREATE_TIME_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("javaType", "java.time.LocalDateTime")
      .with("sqlType", "TIMESTAMP")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("mssql_sqlType", "dateTime")
      .with("isDateTime", "true")
      .with("createFunction", "now")
      .with("isDate", "true")
      .with("isString", "false")
      .with("graphqlType", "LocalTime")
      .with("isTime", "true")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.globalorder.GlobalOrder.UPDATE_TIME_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("updateFunction", "now")
      .with("javaType", "java.time.LocalDateTime")
      .with("sqlType", "TIMESTAMP")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("mssql_sqlType", "dateTime")
      .with("isDateTime", "true")
      .with("createFunction", "now")
      .with("isDate", "true")
      .with("isString", "false")
      .with("graphqlType", "LocalTime")
      .with("isTime", "true")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.globalorder.GlobalOrder.VERSION_PROPERTY).with("isPassword", "false")
      .with("isVersion", "true")
      .with("oracle_sqlType", "number(11)")
      .with("javaType", "java.lang.Long")
      .with("sqlType", "BIGINT")
      .with("isId", "false")
      .with("isBaseEntityField", "true")
      .with("isBool", "false")
      .with("isNumber", "false")
      .with("isString", "false")
      .with("isDate", "false")
      .with("snowflake_sqlType", "number")
      .with("graphqlType", "Long")
      .with("isTime", "false")
      .with("isText", "false");

      $factory.register(entityDescriptor);
  }
  private void registerOrderItem() {
      EntityDescriptor entityDescriptor = new EntityDescriptor();
      entityDescriptor.setType(com.example.enterpriseerpsystem.orderitem.OrderItem.INTERNAL_TYPE);
      entityDescriptor.setTargetType(com.example.enterpriseerpsystem.orderitem.OrderItem.class);
      entityDescriptor.setEntitySupplier(com.example.enterpriseerpsystem.orderitem.OrderItem::new);
      entityDescriptor.with("name", "Order Item")
      .with("module", "ECommerce")
      .with("module_key", "ecommerce");

      PropertyDescriptor id = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.orderitem.OrderItem.ID_PROPERTY, Long.class)
      ;
      PropertyDescriptor unitPrice = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.orderitem.OrderItem.UNIT_PRICE_PROPERTY, BigDecimal.class)
      ;
      PropertyDescriptor globalOrder = 
      entityDescriptor.addObjectProperty($factory, com.example.enterpriseerpsystem.orderitem.OrderItem.GLOBAL_ORDER_PROPERTY, com.example.enterpriseerpsystem.globalorder.GlobalOrder.INTERNAL_TYPE, com.example.enterpriseerpsystem.globalorder.GlobalOrder.ORDER_ITEM_LIST_PROPERTY, com.example.enterpriseerpsystem.globalorder.GlobalOrder.class)
      ;
      PropertyDescriptor product = 
      entityDescriptor.addObjectProperty($factory, com.example.enterpriseerpsystem.orderitem.OrderItem.PRODUCT_PROPERTY, com.example.enterpriseerpsystem.product.Product.INTERNAL_TYPE, com.example.enterpriseerpsystem.product.Product.ORDER_ITEM_LIST_PROPERTY, com.example.enterpriseerpsystem.product.Product.class)
      ;
      PropertyDescriptor quantity = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.orderitem.OrderItem.QUANTITY_PROPERTY, BigDecimal.class)
      ;
      PropertyDescriptor createTime = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.orderitem.OrderItem.CREATE_TIME_PROPERTY, LocalDateTime.class)
      ;
      PropertyDescriptor updateTime = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.orderitem.OrderItem.UPDATE_TIME_PROPERTY, LocalDateTime.class)
      ;
      PropertyDescriptor version = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.orderitem.OrderItem.VERSION_PROPERTY, Long.class)
      ;
      entityDescriptor.findProperty(com.example.enterpriseerpsystem.orderitem.OrderItem.ID_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("oracle_sqlType", "number(11)")
      .with("javaType", "java.lang.Long")
      .with("sqlType", "BIGINT")
      .with("isId", "true")
      .with("isBaseEntityField", "true")
      .with("isBool", "false")
      .with("isNumber", "false")
      .with("isString", "false")
      .with("isDate", "false")
      .with("snowflake_sqlType", "number")
      .with("graphqlType", "Long")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.orderitem.OrderItem.UNIT_PRICE_PROPERTY).with("isPassword", "false")
      .with("db2_sqlType", "decimal(19,7)")
      .with("isVersion", "false")
      .with("oracle_sqlType", "number(19,7)")
      .with("javaType", "java.math.BigDecimal")
      .with("sqlType", "NUMERIC(19,7)")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "true")
      .with("isString", "false")
      .with("isDate", "false")
      .with("graphqlType", "BigDecimal")
      .with("isTime", "false")
      .with("isText", "false");



      entityDescriptor.findProperty(com.example.enterpriseerpsystem.orderitem.OrderItem.QUANTITY_PROPERTY).with("isPassword", "false")
      .with("db2_sqlType", "decimal(19,7)")
      .with("isVersion", "false")
      .with("oracle_sqlType", "number(19,7)")
      .with("javaType", "java.math.BigDecimal")
      .with("sqlType", "NUMERIC(19,7)")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "true")
      .with("isString", "false")
      .with("isDate", "false")
      .with("graphqlType", "BigDecimal")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.orderitem.OrderItem.CREATE_TIME_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("javaType", "java.time.LocalDateTime")
      .with("sqlType", "TIMESTAMP")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("mssql_sqlType", "dateTime")
      .with("isDateTime", "true")
      .with("createFunction", "now")
      .with("isDate", "true")
      .with("isString", "false")
      .with("graphqlType", "LocalTime")
      .with("isTime", "true")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.orderitem.OrderItem.UPDATE_TIME_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("updateFunction", "now")
      .with("javaType", "java.time.LocalDateTime")
      .with("sqlType", "TIMESTAMP")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("mssql_sqlType", "dateTime")
      .with("isDateTime", "true")
      .with("createFunction", "now")
      .with("isDate", "true")
      .with("isString", "false")
      .with("graphqlType", "LocalTime")
      .with("isTime", "true")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.orderitem.OrderItem.VERSION_PROPERTY).with("isPassword", "false")
      .with("isVersion", "true")
      .with("oracle_sqlType", "number(11)")
      .with("javaType", "java.lang.Long")
      .with("sqlType", "BIGINT")
      .with("isId", "false")
      .with("isBaseEntityField", "true")
      .with("isBool", "false")
      .with("isNumber", "false")
      .with("isString", "false")
      .with("isDate", "false")
      .with("snowflake_sqlType", "number")
      .with("graphqlType", "Long")
      .with("isTime", "false")
      .with("isText", "false");

      $factory.register(entityDescriptor);
  }
  private void registerWishlist() {
      EntityDescriptor entityDescriptor = new EntityDescriptor();
      entityDescriptor.setType(com.example.enterpriseerpsystem.wishlist.Wishlist.INTERNAL_TYPE);
      entityDescriptor.setTargetType(com.example.enterpriseerpsystem.wishlist.Wishlist.class);
      entityDescriptor.setEntitySupplier(com.example.enterpriseerpsystem.wishlist.Wishlist::new);
      entityDescriptor.with("name", "Wishlist")
      .with("module", "ECommerce")
      .with("module_key", "ecommerce");

      PropertyDescriptor id = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.wishlist.Wishlist.ID_PROPERTY, Long.class)
      ;
      PropertyDescriptor name = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.wishlist.Wishlist.NAME_PROPERTY, String.class)
      ;
      PropertyDescriptor createdAt = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.wishlist.Wishlist.CREATED_AT_PROPERTY, LocalDateTime.class)
      ;
      PropertyDescriptor customer = 
      entityDescriptor.addObjectProperty($factory, com.example.enterpriseerpsystem.wishlist.Wishlist.CUSTOMER_PROPERTY, com.example.enterpriseerpsystem.customer.Customer.INTERNAL_TYPE, com.example.enterpriseerpsystem.customer.Customer.WISHLIST_LIST_PROPERTY, com.example.enterpriseerpsystem.customer.Customer.class)
      ;
      PropertyDescriptor createTime = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.wishlist.Wishlist.CREATE_TIME_PROPERTY, LocalDateTime.class)
      ;
      PropertyDescriptor updateTime = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.wishlist.Wishlist.UPDATE_TIME_PROPERTY, LocalDateTime.class)
      ;
      PropertyDescriptor version = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.wishlist.Wishlist.VERSION_PROPERTY, Long.class)
      ;
      entityDescriptor.findProperty(com.example.enterpriseerpsystem.wishlist.Wishlist.ID_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("oracle_sqlType", "number(11)")
      .with("javaType", "java.lang.Long")
      .with("sqlType", "BIGINT")
      .with("isId", "true")
      .with("isBaseEntityField", "true")
      .with("isBool", "false")
      .with("isNumber", "false")
      .with("isString", "false")
      .with("isDate", "false")
      .with("snowflake_sqlType", "number")
      .with("graphqlType", "Long")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.wishlist.Wishlist.NAME_PROPERTY).with("isPassword", "false")
      .with("max", "100")
      .with("isVersion", "false")
      .with("javaType", "java.lang.String")
      .with("sqlType", "VARCHAR(<max>)")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("isString", "true")
      .with("isDate", "false")
      .with("graphqlType", "String")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.wishlist.Wishlist.CREATED_AT_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("javaType", "java.time.LocalDateTime")
      .with("sqlType", "TIMESTAMP")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("mssql_sqlType", "dateTime")
      .with("isDateTime", "true")
      .with("createFunction", "now")
      .with("isDate", "true")
      .with("isString", "false")
      .with("graphqlType", "LocalTime")
      .with("isTime", "true")
      .with("isText", "false");


      entityDescriptor.findProperty(com.example.enterpriseerpsystem.wishlist.Wishlist.CREATE_TIME_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("javaType", "java.time.LocalDateTime")
      .with("sqlType", "TIMESTAMP")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("mssql_sqlType", "dateTime")
      .with("isDateTime", "true")
      .with("createFunction", "now")
      .with("isDate", "true")
      .with("isString", "false")
      .with("graphqlType", "LocalTime")
      .with("isTime", "true")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.wishlist.Wishlist.UPDATE_TIME_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("updateFunction", "now")
      .with("javaType", "java.time.LocalDateTime")
      .with("sqlType", "TIMESTAMP")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("mssql_sqlType", "dateTime")
      .with("isDateTime", "true")
      .with("createFunction", "now")
      .with("isDate", "true")
      .with("isString", "false")
      .with("graphqlType", "LocalTime")
      .with("isTime", "true")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.wishlist.Wishlist.VERSION_PROPERTY).with("isPassword", "false")
      .with("isVersion", "true")
      .with("oracle_sqlType", "number(11)")
      .with("javaType", "java.lang.Long")
      .with("sqlType", "BIGINT")
      .with("isId", "false")
      .with("isBaseEntityField", "true")
      .with("isBool", "false")
      .with("isNumber", "false")
      .with("isString", "false")
      .with("isDate", "false")
      .with("snowflake_sqlType", "number")
      .with("graphqlType", "Long")
      .with("isTime", "false")
      .with("isText", "false");

      $factory.register(entityDescriptor);
  }
  private void registerPromotion() {
      EntityDescriptor entityDescriptor = new EntityDescriptor();
      entityDescriptor.setType(com.example.enterpriseerpsystem.promotion.Promotion.INTERNAL_TYPE);
      entityDescriptor.setTargetType(com.example.enterpriseerpsystem.promotion.Promotion.class);
      entityDescriptor.setEntitySupplier(com.example.enterpriseerpsystem.promotion.Promotion::new);
      entityDescriptor.with("name", "Promotion")
      .with("module", "ECommerce")
      .with("module_key", "ecommerce");

      PropertyDescriptor id = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.promotion.Promotion.ID_PROPERTY, Long.class)
      ;
      PropertyDescriptor name = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.promotion.Promotion.NAME_PROPERTY, String.class)
      ;
      PropertyDescriptor discountPercentage = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.promotion.Promotion.DISCOUNT_PERCENTAGE_PROPERTY, BigDecimal.class)
      ;
      PropertyDescriptor endDate = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.promotion.Promotion.END_DATE_PROPERTY, LocalDateTime.class)
      ;
      PropertyDescriptor startDate = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.promotion.Promotion.START_DATE_PROPERTY, LocalDateTime.class)
      ;
      PropertyDescriptor createTime = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.promotion.Promotion.CREATE_TIME_PROPERTY, LocalDateTime.class)
      ;
      PropertyDescriptor updateTime = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.promotion.Promotion.UPDATE_TIME_PROPERTY, LocalDateTime.class)
      ;
      PropertyDescriptor version = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.promotion.Promotion.VERSION_PROPERTY, Long.class)
      ;
      entityDescriptor.findProperty(com.example.enterpriseerpsystem.promotion.Promotion.ID_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("oracle_sqlType", "number(11)")
      .with("javaType", "java.lang.Long")
      .with("sqlType", "BIGINT")
      .with("isId", "true")
      .with("isBaseEntityField", "true")
      .with("isBool", "false")
      .with("isNumber", "false")
      .with("isString", "false")
      .with("isDate", "false")
      .with("snowflake_sqlType", "number")
      .with("graphqlType", "Long")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.promotion.Promotion.NAME_PROPERTY).with("isPassword", "false")
      .with("max", "100")
      .with("isVersion", "false")
      .with("javaType", "java.lang.String")
      .with("candidates", "name_value")
      .with("sqlType", "VARCHAR(<max>)")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("isString", "true")
      .with("isDate", "false")
      .with("graphqlType", "String")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.promotion.Promotion.DISCOUNT_PERCENTAGE_PROPERTY).with("isPassword", "false")
      .with("db2_sqlType", "decimal(19,7)")
      .with("isVersion", "false")
      .with("oracle_sqlType", "number(19,7)")
      .with("javaType", "java.math.BigDecimal")
      .with("candidates", "100.00")
      .with("sqlType", "NUMERIC(19,7)")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "true")
      .with("isString", "false")
      .with("isDate", "false")
      .with("graphqlType", "BigDecimal")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.promotion.Promotion.END_DATE_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("javaType", "java.time.LocalDateTime")
      .with("candidates", "createTime()")
      .with("sqlType", "TIMESTAMP")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("mssql_sqlType", "dateTime")
      .with("isDateTime", "true")
      .with("createFunction", "now")
      .with("isDate", "true")
      .with("isString", "false")
      .with("graphqlType", "LocalTime")
      .with("isTime", "true")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.promotion.Promotion.START_DATE_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("javaType", "java.time.LocalDateTime")
      .with("candidates", "createTime()")
      .with("sqlType", "TIMESTAMP")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("mssql_sqlType", "dateTime")
      .with("isDateTime", "true")
      .with("createFunction", "now")
      .with("isDate", "true")
      .with("isString", "false")
      .with("graphqlType", "LocalTime")
      .with("isTime", "true")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.promotion.Promotion.CREATE_TIME_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("javaType", "java.time.LocalDateTime")
      .with("candidates", "createTime()")
      .with("sqlType", "TIMESTAMP")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("mssql_sqlType", "dateTime")
      .with("isDateTime", "true")
      .with("createFunction", "now")
      .with("isDate", "true")
      .with("isString", "false")
      .with("graphqlType", "LocalTime")
      .with("isTime", "true")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.promotion.Promotion.UPDATE_TIME_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("updateFunction", "now")
      .with("javaType", "java.time.LocalDateTime")
      .with("candidates", "updateTime()")
      .with("sqlType", "TIMESTAMP")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("mssql_sqlType", "dateTime")
      .with("isDateTime", "true")
      .with("createFunction", "now")
      .with("isDate", "true")
      .with("isString", "false")
      .with("graphqlType", "LocalTime")
      .with("isTime", "true")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.promotion.Promotion.VERSION_PROPERTY).with("isPassword", "false")
      .with("isVersion", "true")
      .with("oracle_sqlType", "number(11)")
      .with("javaType", "java.lang.Long")
      .with("sqlType", "BIGINT")
      .with("isId", "false")
      .with("isBaseEntityField", "true")
      .with("isBool", "false")
      .with("isNumber", "false")
      .with("isString", "false")
      .with("isDate", "false")
      .with("snowflake_sqlType", "number")
      .with("graphqlType", "Long")
      .with("isTime", "false")
      .with("isText", "false");

      $factory.register(entityDescriptor);
  }
  private void registerCoupon() {
      EntityDescriptor entityDescriptor = new EntityDescriptor();
      entityDescriptor.setType(com.example.enterpriseerpsystem.coupon.Coupon.INTERNAL_TYPE);
      entityDescriptor.setTargetType(com.example.enterpriseerpsystem.coupon.Coupon.class);
      entityDescriptor.setEntitySupplier(com.example.enterpriseerpsystem.coupon.Coupon::new);
      entityDescriptor.with("name", "Coupon")
      .with("module", "ECommerce")
      .with("module_key", "ecommerce");

      PropertyDescriptor id = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.coupon.Coupon.ID_PROPERTY, Long.class)
      ;
      PropertyDescriptor code = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.coupon.Coupon.CODE_PROPERTY, String.class)
      ;
      PropertyDescriptor promotion = 
      entityDescriptor.addObjectProperty($factory, com.example.enterpriseerpsystem.coupon.Coupon.PROMOTION_PROPERTY, com.example.enterpriseerpsystem.promotion.Promotion.INTERNAL_TYPE, com.example.enterpriseerpsystem.promotion.Promotion.COUPON_LIST_PROPERTY, com.example.enterpriseerpsystem.promotion.Promotion.class)
      ;
      PropertyDescriptor timesUsed = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.coupon.Coupon.TIMES_USED_PROPERTY, BigDecimal.class)
      ;
      PropertyDescriptor usageLimit = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.coupon.Coupon.USAGE_LIMIT_PROPERTY, BigDecimal.class)
      ;
      PropertyDescriptor createTime = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.coupon.Coupon.CREATE_TIME_PROPERTY, LocalDateTime.class)
      ;
      PropertyDescriptor updateTime = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.coupon.Coupon.UPDATE_TIME_PROPERTY, LocalDateTime.class)
      ;
      PropertyDescriptor version = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.coupon.Coupon.VERSION_PROPERTY, Long.class)
      ;
      entityDescriptor.findProperty(com.example.enterpriseerpsystem.coupon.Coupon.ID_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("oracle_sqlType", "number(11)")
      .with("javaType", "java.lang.Long")
      .with("sqlType", "BIGINT")
      .with("isId", "true")
      .with("isBaseEntityField", "true")
      .with("isBool", "false")
      .with("isNumber", "false")
      .with("isString", "false")
      .with("isDate", "false")
      .with("snowflake_sqlType", "number")
      .with("graphqlType", "Long")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.coupon.Coupon.CODE_PROPERTY).with("isPassword", "false")
      .with("max", "100")
      .with("isVersion", "false")
      .with("javaType", "java.lang.String")
      .with("sqlType", "VARCHAR(<max>)")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("isString", "true")
      .with("isDate", "false")
      .with("graphqlType", "String")
      .with("isTime", "false")
      .with("isText", "false");


      entityDescriptor.findProperty(com.example.enterpriseerpsystem.coupon.Coupon.TIMES_USED_PROPERTY).with("isPassword", "false")
      .with("db2_sqlType", "decimal(19,7)")
      .with("isVersion", "false")
      .with("oracle_sqlType", "number(19,7)")
      .with("javaType", "java.math.BigDecimal")
      .with("sqlType", "NUMERIC(19,7)")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "true")
      .with("isString", "false")
      .with("isDate", "false")
      .with("graphqlType", "BigDecimal")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.coupon.Coupon.USAGE_LIMIT_PROPERTY).with("isPassword", "false")
      .with("db2_sqlType", "decimal(19,7)")
      .with("isVersion", "false")
      .with("oracle_sqlType", "number(19,7)")
      .with("javaType", "java.math.BigDecimal")
      .with("sqlType", "NUMERIC(19,7)")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "true")
      .with("isString", "false")
      .with("isDate", "false")
      .with("graphqlType", "BigDecimal")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.coupon.Coupon.CREATE_TIME_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("javaType", "java.time.LocalDateTime")
      .with("sqlType", "TIMESTAMP")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("mssql_sqlType", "dateTime")
      .with("isDateTime", "true")
      .with("createFunction", "now")
      .with("isDate", "true")
      .with("isString", "false")
      .with("graphqlType", "LocalTime")
      .with("isTime", "true")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.coupon.Coupon.UPDATE_TIME_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("updateFunction", "now")
      .with("javaType", "java.time.LocalDateTime")
      .with("sqlType", "TIMESTAMP")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("mssql_sqlType", "dateTime")
      .with("isDateTime", "true")
      .with("createFunction", "now")
      .with("isDate", "true")
      .with("isString", "false")
      .with("graphqlType", "LocalTime")
      .with("isTime", "true")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.coupon.Coupon.VERSION_PROPERTY).with("isPassword", "false")
      .with("isVersion", "true")
      .with("oracle_sqlType", "number(11)")
      .with("javaType", "java.lang.Long")
      .with("sqlType", "BIGINT")
      .with("isId", "false")
      .with("isBaseEntityField", "true")
      .with("isBool", "false")
      .with("isNumber", "false")
      .with("isString", "false")
      .with("isDate", "false")
      .with("snowflake_sqlType", "number")
      .with("graphqlType", "Long")
      .with("isTime", "false")
      .with("isText", "false");

      $factory.register(entityDescriptor);
  }
  private void registerInvoice() {
      EntityDescriptor entityDescriptor = new EntityDescriptor();
      entityDescriptor.setType(com.example.enterpriseerpsystem.invoice.Invoice.INTERNAL_TYPE);
      entityDescriptor.setTargetType(com.example.enterpriseerpsystem.invoice.Invoice.class);
      entityDescriptor.setEntitySupplier(com.example.enterpriseerpsystem.invoice.Invoice::new);
      entityDescriptor.with("name", "Invoice")
      .with("module", "Finance")
      .with("module_key", "finance");

      PropertyDescriptor id = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.invoice.Invoice.ID_PROPERTY, Long.class)
      ;
      PropertyDescriptor amount = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.invoice.Invoice.AMOUNT_PROPERTY, BigDecimal.class)
      ;
      PropertyDescriptor customer = 
      entityDescriptor.addObjectProperty($factory, com.example.enterpriseerpsystem.invoice.Invoice.CUSTOMER_PROPERTY, com.example.enterpriseerpsystem.customer.Customer.INTERNAL_TYPE, com.example.enterpriseerpsystem.customer.Customer.INVOICE_LIST_PROPERTY, com.example.enterpriseerpsystem.customer.Customer.class)
      ;
      PropertyDescriptor dueDate = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.invoice.Invoice.DUE_DATE_PROPERTY, LocalDateTime.class)
      ;
      PropertyDescriptor globalOrder = 
      entityDescriptor.addObjectProperty($factory, com.example.enterpriseerpsystem.invoice.Invoice.GLOBAL_ORDER_PROPERTY, com.example.enterpriseerpsystem.globalorder.GlobalOrder.INTERNAL_TYPE, com.example.enterpriseerpsystem.globalorder.GlobalOrder.INVOICE_LIST_PROPERTY, com.example.enterpriseerpsystem.globalorder.GlobalOrder.class)
      ;
      PropertyDescriptor issueDate = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.invoice.Invoice.ISSUE_DATE_PROPERTY, LocalDateTime.class)
      ;
      PropertyDescriptor status = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.invoice.Invoice.STATUS_PROPERTY, String.class)
      ;
      PropertyDescriptor createTime = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.invoice.Invoice.CREATE_TIME_PROPERTY, LocalDateTime.class)
      ;
      PropertyDescriptor updateTime = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.invoice.Invoice.UPDATE_TIME_PROPERTY, LocalDateTime.class)
      ;
      PropertyDescriptor version = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.invoice.Invoice.VERSION_PROPERTY, Long.class)
      ;
      entityDescriptor.findProperty(com.example.enterpriseerpsystem.invoice.Invoice.ID_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("oracle_sqlType", "number(11)")
      .with("javaType", "java.lang.Long")
      .with("sqlType", "BIGINT")
      .with("isId", "true")
      .with("isBaseEntityField", "true")
      .with("isBool", "false")
      .with("isNumber", "false")
      .with("isString", "false")
      .with("isDate", "false")
      .with("snowflake_sqlType", "number")
      .with("graphqlType", "Long")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.invoice.Invoice.AMOUNT_PROPERTY).with("isPassword", "false")
      .with("db2_sqlType", "decimal(19,7)")
      .with("isVersion", "false")
      .with("oracle_sqlType", "number(19,7)")
      .with("javaType", "java.math.BigDecimal")
      .with("sqlType", "NUMERIC(19,7)")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "true")
      .with("isString", "false")
      .with("isDate", "false")
      .with("graphqlType", "BigDecimal")
      .with("isTime", "false")
      .with("isText", "false");


      entityDescriptor.findProperty(com.example.enterpriseerpsystem.invoice.Invoice.DUE_DATE_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("javaType", "java.time.LocalDateTime")
      .with("sqlType", "TIMESTAMP")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("mssql_sqlType", "dateTime")
      .with("isDateTime", "true")
      .with("createFunction", "now")
      .with("isDate", "true")
      .with("isString", "false")
      .with("graphqlType", "LocalTime")
      .with("isTime", "true")
      .with("isText", "false");


      entityDescriptor.findProperty(com.example.enterpriseerpsystem.invoice.Invoice.ISSUE_DATE_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("javaType", "java.time.LocalDateTime")
      .with("sqlType", "TIMESTAMP")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("mssql_sqlType", "dateTime")
      .with("isDateTime", "true")
      .with("createFunction", "now")
      .with("isDate", "true")
      .with("isString", "false")
      .with("graphqlType", "LocalTime")
      .with("isTime", "true")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.invoice.Invoice.STATUS_PROPERTY).with("isPassword", "false")
      .with("max", "100")
      .with("isVersion", "false")
      .with("javaType", "java.lang.String")
      .with("sqlType", "VARCHAR(<max>)")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("isString", "true")
      .with("isDate", "false")
      .with("graphqlType", "String")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.invoice.Invoice.CREATE_TIME_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("javaType", "java.time.LocalDateTime")
      .with("sqlType", "TIMESTAMP")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("mssql_sqlType", "dateTime")
      .with("isDateTime", "true")
      .with("createFunction", "now")
      .with("isDate", "true")
      .with("isString", "false")
      .with("graphqlType", "LocalTime")
      .with("isTime", "true")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.invoice.Invoice.UPDATE_TIME_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("updateFunction", "now")
      .with("javaType", "java.time.LocalDateTime")
      .with("sqlType", "TIMESTAMP")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("mssql_sqlType", "dateTime")
      .with("isDateTime", "true")
      .with("createFunction", "now")
      .with("isDate", "true")
      .with("isString", "false")
      .with("graphqlType", "LocalTime")
      .with("isTime", "true")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.invoice.Invoice.VERSION_PROPERTY).with("isPassword", "false")
      .with("isVersion", "true")
      .with("oracle_sqlType", "number(11)")
      .with("javaType", "java.lang.Long")
      .with("sqlType", "BIGINT")
      .with("isId", "false")
      .with("isBaseEntityField", "true")
      .with("isBool", "false")
      .with("isNumber", "false")
      .with("isString", "false")
      .with("isDate", "false")
      .with("snowflake_sqlType", "number")
      .with("graphqlType", "Long")
      .with("isTime", "false")
      .with("isText", "false");

      $factory.register(entityDescriptor);
  }
  private void registerPayment() {
      EntityDescriptor entityDescriptor = new EntityDescriptor();
      entityDescriptor.setType(com.example.enterpriseerpsystem.payment.Payment.INTERNAL_TYPE);
      entityDescriptor.setTargetType(com.example.enterpriseerpsystem.payment.Payment.class);
      entityDescriptor.setEntitySupplier(com.example.enterpriseerpsystem.payment.Payment::new);
      entityDescriptor.with("name", "Payment")
      .with("module", "Finance")
      .with("module_key", "finance");

      PropertyDescriptor id = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.payment.Payment.ID_PROPERTY, Long.class)
      ;
      PropertyDescriptor amount = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.payment.Payment.AMOUNT_PROPERTY, BigDecimal.class)
      ;
      PropertyDescriptor cardLast4 = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.payment.Payment.CARD_LAST4_PROPERTY, String.class)
      ;
      PropertyDescriptor paymentDate = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.payment.Payment.PAYMENT_DATE_PROPERTY, LocalDateTime.class)
      ;
      PropertyDescriptor invoice = 
      entityDescriptor.addObjectProperty($factory, com.example.enterpriseerpsystem.payment.Payment.INVOICE_PROPERTY, com.example.enterpriseerpsystem.invoice.Invoice.INTERNAL_TYPE, com.example.enterpriseerpsystem.invoice.Invoice.PAYMENT_LIST_PROPERTY, com.example.enterpriseerpsystem.invoice.Invoice.class)
      ;
      PropertyDescriptor method = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.payment.Payment.METHOD_PROPERTY, String.class)
      ;
      PropertyDescriptor status = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.payment.Payment.STATUS_PROPERTY, String.class)
      ;
      PropertyDescriptor createTime = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.payment.Payment.CREATE_TIME_PROPERTY, LocalDateTime.class)
      ;
      PropertyDescriptor updateTime = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.payment.Payment.UPDATE_TIME_PROPERTY, LocalDateTime.class)
      ;
      PropertyDescriptor version = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.payment.Payment.VERSION_PROPERTY, Long.class)
      ;
      entityDescriptor.findProperty(com.example.enterpriseerpsystem.payment.Payment.ID_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("oracle_sqlType", "number(11)")
      .with("javaType", "java.lang.Long")
      .with("sqlType", "BIGINT")
      .with("isId", "true")
      .with("isBaseEntityField", "true")
      .with("isBool", "false")
      .with("isNumber", "false")
      .with("isString", "false")
      .with("isDate", "false")
      .with("snowflake_sqlType", "number")
      .with("graphqlType", "Long")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.payment.Payment.AMOUNT_PROPERTY).with("isPassword", "false")
      .with("db2_sqlType", "decimal(19,7)")
      .with("isVersion", "false")
      .with("oracle_sqlType", "number(19,7)")
      .with("javaType", "java.math.BigDecimal")
      .with("sqlType", "NUMERIC(19,7)")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "true")
      .with("isString", "false")
      .with("isDate", "false")
      .with("graphqlType", "BigDecimal")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.payment.Payment.CARD_LAST4_PROPERTY).with("isPassword", "false")
      .with("max", "100")
      .with("isVersion", "false")
      .with("javaType", "java.lang.String")
      .with("sqlType", "VARCHAR(<max>)")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("isString", "true")
      .with("isDate", "false")
      .with("graphqlType", "String")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.payment.Payment.PAYMENT_DATE_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("javaType", "java.time.LocalDateTime")
      .with("sqlType", "TIMESTAMP")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("mssql_sqlType", "dateTime")
      .with("isDateTime", "true")
      .with("createFunction", "now")
      .with("isDate", "true")
      .with("isString", "false")
      .with("graphqlType", "LocalTime")
      .with("isTime", "true")
      .with("isText", "false");


      entityDescriptor.findProperty(com.example.enterpriseerpsystem.payment.Payment.METHOD_PROPERTY).with("isPassword", "false")
      .with("max", "100")
      .with("isVersion", "false")
      .with("javaType", "java.lang.String")
      .with("sqlType", "VARCHAR(<max>)")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("isString", "true")
      .with("isDate", "false")
      .with("graphqlType", "String")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.payment.Payment.STATUS_PROPERTY).with("isPassword", "false")
      .with("max", "100")
      .with("isVersion", "false")
      .with("javaType", "java.lang.String")
      .with("sqlType", "VARCHAR(<max>)")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("isString", "true")
      .with("isDate", "false")
      .with("graphqlType", "String")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.payment.Payment.CREATE_TIME_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("javaType", "java.time.LocalDateTime")
      .with("sqlType", "TIMESTAMP")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("mssql_sqlType", "dateTime")
      .with("isDateTime", "true")
      .with("createFunction", "now")
      .with("isDate", "true")
      .with("isString", "false")
      .with("graphqlType", "LocalTime")
      .with("isTime", "true")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.payment.Payment.UPDATE_TIME_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("updateFunction", "now")
      .with("javaType", "java.time.LocalDateTime")
      .with("sqlType", "TIMESTAMP")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("mssql_sqlType", "dateTime")
      .with("isDateTime", "true")
      .with("createFunction", "now")
      .with("isDate", "true")
      .with("isString", "false")
      .with("graphqlType", "LocalTime")
      .with("isTime", "true")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.payment.Payment.VERSION_PROPERTY).with("isPassword", "false")
      .with("isVersion", "true")
      .with("oracle_sqlType", "number(11)")
      .with("javaType", "java.lang.Long")
      .with("sqlType", "BIGINT")
      .with("isId", "false")
      .with("isBaseEntityField", "true")
      .with("isBool", "false")
      .with("isNumber", "false")
      .with("isString", "false")
      .with("isDate", "false")
      .with("snowflake_sqlType", "number")
      .with("graphqlType", "Long")
      .with("isTime", "false")
      .with("isText", "false");

      $factory.register(entityDescriptor);
  }
  private void registerRefund() {
      EntityDescriptor entityDescriptor = new EntityDescriptor();
      entityDescriptor.setType(com.example.enterpriseerpsystem.refund.Refund.INTERNAL_TYPE);
      entityDescriptor.setTargetType(com.example.enterpriseerpsystem.refund.Refund.class);
      entityDescriptor.setEntitySupplier(com.example.enterpriseerpsystem.refund.Refund::new);
      entityDescriptor.with("name", "Refund")
      .with("module", "Finance")
      .with("module_key", "finance");

      PropertyDescriptor id = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.refund.Refund.ID_PROPERTY, Long.class)
      ;
      PropertyDescriptor amount = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.refund.Refund.AMOUNT_PROPERTY, BigDecimal.class)
      ;
      PropertyDescriptor payment = 
      entityDescriptor.addObjectProperty($factory, com.example.enterpriseerpsystem.refund.Refund.PAYMENT_PROPERTY, com.example.enterpriseerpsystem.payment.Payment.INTERNAL_TYPE, com.example.enterpriseerpsystem.payment.Payment.REFUND_LIST_PROPERTY, com.example.enterpriseerpsystem.payment.Payment.class)
      ;
      PropertyDescriptor processedDate = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.refund.Refund.PROCESSED_DATE_PROPERTY, LocalDateTime.class)
      ;
      PropertyDescriptor reason = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.refund.Refund.REASON_PROPERTY, String.class)
      ;
      PropertyDescriptor createTime = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.refund.Refund.CREATE_TIME_PROPERTY, LocalDateTime.class)
      ;
      PropertyDescriptor updateTime = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.refund.Refund.UPDATE_TIME_PROPERTY, LocalDateTime.class)
      ;
      PropertyDescriptor version = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.refund.Refund.VERSION_PROPERTY, Long.class)
      ;
      entityDescriptor.findProperty(com.example.enterpriseerpsystem.refund.Refund.ID_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("oracle_sqlType", "number(11)")
      .with("javaType", "java.lang.Long")
      .with("sqlType", "BIGINT")
      .with("isId", "true")
      .with("isBaseEntityField", "true")
      .with("isBool", "false")
      .with("isNumber", "false")
      .with("isString", "false")
      .with("isDate", "false")
      .with("snowflake_sqlType", "number")
      .with("graphqlType", "Long")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.refund.Refund.AMOUNT_PROPERTY).with("isPassword", "false")
      .with("db2_sqlType", "decimal(19,7)")
      .with("isVersion", "false")
      .with("oracle_sqlType", "number(19,7)")
      .with("javaType", "java.math.BigDecimal")
      .with("sqlType", "NUMERIC(19,7)")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "true")
      .with("isString", "false")
      .with("isDate", "false")
      .with("graphqlType", "BigDecimal")
      .with("isTime", "false")
      .with("isText", "false");


      entityDescriptor.findProperty(com.example.enterpriseerpsystem.refund.Refund.PROCESSED_DATE_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("javaType", "java.time.LocalDateTime")
      .with("sqlType", "TIMESTAMP")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("mssql_sqlType", "dateTime")
      .with("isDateTime", "true")
      .with("createFunction", "now")
      .with("isDate", "true")
      .with("isString", "false")
      .with("graphqlType", "LocalTime")
      .with("isTime", "true")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.refund.Refund.REASON_PROPERTY).with("isPassword", "false")
      .with("max", "100")
      .with("isVersion", "false")
      .with("javaType", "java.lang.String")
      .with("sqlType", "VARCHAR(<max>)")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("isString", "true")
      .with("isDate", "false")
      .with("graphqlType", "String")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.refund.Refund.CREATE_TIME_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("javaType", "java.time.LocalDateTime")
      .with("sqlType", "TIMESTAMP")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("mssql_sqlType", "dateTime")
      .with("isDateTime", "true")
      .with("createFunction", "now")
      .with("isDate", "true")
      .with("isString", "false")
      .with("graphqlType", "LocalTime")
      .with("isTime", "true")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.refund.Refund.UPDATE_TIME_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("updateFunction", "now")
      .with("javaType", "java.time.LocalDateTime")
      .with("sqlType", "TIMESTAMP")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("mssql_sqlType", "dateTime")
      .with("isDateTime", "true")
      .with("createFunction", "now")
      .with("isDate", "true")
      .with("isString", "false")
      .with("graphqlType", "LocalTime")
      .with("isTime", "true")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.refund.Refund.VERSION_PROPERTY).with("isPassword", "false")
      .with("isVersion", "true")
      .with("oracle_sqlType", "number(11)")
      .with("javaType", "java.lang.Long")
      .with("sqlType", "BIGINT")
      .with("isId", "false")
      .with("isBaseEntityField", "true")
      .with("isBool", "false")
      .with("isNumber", "false")
      .with("isString", "false")
      .with("isDate", "false")
      .with("snowflake_sqlType", "number")
      .with("graphqlType", "Long")
      .with("isTime", "false")
      .with("isText", "false");

      $factory.register(entityDescriptor);
  }
  private void registerAccount() {
      EntityDescriptor entityDescriptor = new EntityDescriptor();
      entityDescriptor.setType(com.example.enterpriseerpsystem.account.Account.INTERNAL_TYPE);
      entityDescriptor.setTargetType(com.example.enterpriseerpsystem.account.Account.class);
      entityDescriptor.setEntitySupplier(com.example.enterpriseerpsystem.account.Account::new);
      entityDescriptor.with("name", "Account")
      .with("module", "Finance")
      .with("module_key", "finance");

      PropertyDescriptor id = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.account.Account.ID_PROPERTY, Long.class)
      ;
      PropertyDescriptor name = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.account.Account.NAME_PROPERTY, String.class)
      ;
      PropertyDescriptor accountType = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.account.Account.ACCOUNT_TYPE_PROPERTY, String.class)
      ;
      PropertyDescriptor balance = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.account.Account.BALANCE_PROPERTY, BigDecimal.class)
      ;
      PropertyDescriptor currency = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.account.Account.CURRENCY_PROPERTY, String.class)
      ;
      PropertyDescriptor createTime = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.account.Account.CREATE_TIME_PROPERTY, LocalDateTime.class)
      ;
      PropertyDescriptor updateTime = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.account.Account.UPDATE_TIME_PROPERTY, LocalDateTime.class)
      ;
      PropertyDescriptor version = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.account.Account.VERSION_PROPERTY, Long.class)
      ;
      entityDescriptor.findProperty(com.example.enterpriseerpsystem.account.Account.ID_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("oracle_sqlType", "number(11)")
      .with("javaType", "java.lang.Long")
      .with("sqlType", "BIGINT")
      .with("isId", "true")
      .with("isBaseEntityField", "true")
      .with("isBool", "false")
      .with("isNumber", "false")
      .with("isString", "false")
      .with("isDate", "false")
      .with("snowflake_sqlType", "number")
      .with("graphqlType", "Long")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.account.Account.NAME_PROPERTY).with("isPassword", "false")
      .with("max", "100")
      .with("isVersion", "false")
      .with("javaType", "java.lang.String")
      .with("candidates", "name_value")
      .with("sqlType", "VARCHAR(<max>)")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("isString", "true")
      .with("isDate", "false")
      .with("graphqlType", "String")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.account.Account.ACCOUNT_TYPE_PROPERTY).with("isPassword", "false")
      .with("max", "100")
      .with("isVersion", "false")
      .with("javaType", "java.lang.String")
      .with("candidates", "account_type_value")
      .with("sqlType", "VARCHAR(<max>)")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("isString", "true")
      .with("isDate", "false")
      .with("graphqlType", "String")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.account.Account.BALANCE_PROPERTY).with("isPassword", "false")
      .with("db2_sqlType", "decimal(19,7)")
      .with("isVersion", "false")
      .with("oracle_sqlType", "number(19,7)")
      .with("javaType", "java.math.BigDecimal")
      .with("candidates", "100.00")
      .with("sqlType", "NUMERIC(19,7)")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "true")
      .with("isString", "false")
      .with("isDate", "false")
      .with("graphqlType", "BigDecimal")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.account.Account.CURRENCY_PROPERTY).with("isPassword", "false")
      .with("max", "100")
      .with("isVersion", "false")
      .with("javaType", "java.lang.String")
      .with("candidates", "currency_value")
      .with("sqlType", "VARCHAR(<max>)")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("isString", "true")
      .with("isDate", "false")
      .with("graphqlType", "String")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.account.Account.CREATE_TIME_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("javaType", "java.time.LocalDateTime")
      .with("candidates", "createTime()")
      .with("sqlType", "TIMESTAMP")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("mssql_sqlType", "dateTime")
      .with("isDateTime", "true")
      .with("createFunction", "now")
      .with("isDate", "true")
      .with("isString", "false")
      .with("graphqlType", "LocalTime")
      .with("isTime", "true")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.account.Account.UPDATE_TIME_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("updateFunction", "now")
      .with("javaType", "java.time.LocalDateTime")
      .with("candidates", "updateTime()")
      .with("sqlType", "TIMESTAMP")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("mssql_sqlType", "dateTime")
      .with("isDateTime", "true")
      .with("createFunction", "now")
      .with("isDate", "true")
      .with("isString", "false")
      .with("graphqlType", "LocalTime")
      .with("isTime", "true")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.account.Account.VERSION_PROPERTY).with("isPassword", "false")
      .with("isVersion", "true")
      .with("oracle_sqlType", "number(11)")
      .with("javaType", "java.lang.Long")
      .with("sqlType", "BIGINT")
      .with("isId", "false")
      .with("isBaseEntityField", "true")
      .with("isBool", "false")
      .with("isNumber", "false")
      .with("isString", "false")
      .with("isDate", "false")
      .with("snowflake_sqlType", "number")
      .with("graphqlType", "Long")
      .with("isTime", "false")
      .with("isText", "false");

      $factory.register(entityDescriptor);
  }
  private void registerTransaction() {
      EntityDescriptor entityDescriptor = new EntityDescriptor();
      entityDescriptor.setType(com.example.enterpriseerpsystem.transaction.Transaction.INTERNAL_TYPE);
      entityDescriptor.setTargetType(com.example.enterpriseerpsystem.transaction.Transaction.class);
      entityDescriptor.setEntitySupplier(com.example.enterpriseerpsystem.transaction.Transaction::new);
      entityDescriptor.with("name", "Transaction")
      .with("module", "Finance")
      .with("module_key", "finance");

      PropertyDescriptor id = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.transaction.Transaction.ID_PROPERTY, Long.class)
      ;
      PropertyDescriptor amount = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.transaction.Transaction.AMOUNT_PROPERTY, BigDecimal.class)
      ;
      PropertyDescriptor account = 
      entityDescriptor.addObjectProperty($factory, com.example.enterpriseerpsystem.transaction.Transaction.ACCOUNT_PROPERTY, com.example.enterpriseerpsystem.account.Account.INTERNAL_TYPE, com.example.enterpriseerpsystem.account.Account.TRANSACTION_LIST_PROPERTY, com.example.enterpriseerpsystem.account.Account.class)
      ;
      PropertyDescriptor timestamp = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.transaction.Transaction.TIMESTAMP_PROPERTY, LocalDateTime.class)
      ;
      PropertyDescriptor type = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.transaction.Transaction.TYPE_PROPERTY, String.class)
      ;
      PropertyDescriptor createTime = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.transaction.Transaction.CREATE_TIME_PROPERTY, LocalDateTime.class)
      ;
      PropertyDescriptor updateTime = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.transaction.Transaction.UPDATE_TIME_PROPERTY, LocalDateTime.class)
      ;
      PropertyDescriptor version = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.transaction.Transaction.VERSION_PROPERTY, Long.class)
      ;
      entityDescriptor.findProperty(com.example.enterpriseerpsystem.transaction.Transaction.ID_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("oracle_sqlType", "number(11)")
      .with("javaType", "java.lang.Long")
      .with("sqlType", "BIGINT")
      .with("isId", "true")
      .with("isBaseEntityField", "true")
      .with("isBool", "false")
      .with("isNumber", "false")
      .with("isString", "false")
      .with("isDate", "false")
      .with("snowflake_sqlType", "number")
      .with("graphqlType", "Long")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.transaction.Transaction.AMOUNT_PROPERTY).with("isPassword", "false")
      .with("db2_sqlType", "decimal(19,7)")
      .with("isVersion", "false")
      .with("oracle_sqlType", "number(19,7)")
      .with("javaType", "java.math.BigDecimal")
      .with("sqlType", "NUMERIC(19,7)")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "true")
      .with("isString", "false")
      .with("isDate", "false")
      .with("graphqlType", "BigDecimal")
      .with("isTime", "false")
      .with("isText", "false");


      entityDescriptor.findProperty(com.example.enterpriseerpsystem.transaction.Transaction.TIMESTAMP_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("javaType", "java.time.LocalDateTime")
      .with("sqlType", "TIMESTAMP")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("mssql_sqlType", "dateTime")
      .with("isDateTime", "true")
      .with("createFunction", "now")
      .with("isDate", "true")
      .with("isString", "false")
      .with("graphqlType", "LocalTime")
      .with("isTime", "true")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.transaction.Transaction.TYPE_PROPERTY).with("isPassword", "false")
      .with("max", "100")
      .with("isVersion", "false")
      .with("javaType", "java.lang.String")
      .with("sqlType", "VARCHAR(<max>)")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("isString", "true")
      .with("isDate", "false")
      .with("graphqlType", "String")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.transaction.Transaction.CREATE_TIME_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("javaType", "java.time.LocalDateTime")
      .with("sqlType", "TIMESTAMP")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("mssql_sqlType", "dateTime")
      .with("isDateTime", "true")
      .with("createFunction", "now")
      .with("isDate", "true")
      .with("isString", "false")
      .with("graphqlType", "LocalTime")
      .with("isTime", "true")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.transaction.Transaction.UPDATE_TIME_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("updateFunction", "now")
      .with("javaType", "java.time.LocalDateTime")
      .with("sqlType", "TIMESTAMP")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("mssql_sqlType", "dateTime")
      .with("isDateTime", "true")
      .with("createFunction", "now")
      .with("isDate", "true")
      .with("isString", "false")
      .with("graphqlType", "LocalTime")
      .with("isTime", "true")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.transaction.Transaction.VERSION_PROPERTY).with("isPassword", "false")
      .with("isVersion", "true")
      .with("oracle_sqlType", "number(11)")
      .with("javaType", "java.lang.Long")
      .with("sqlType", "BIGINT")
      .with("isId", "false")
      .with("isBaseEntityField", "true")
      .with("isBool", "false")
      .with("isNumber", "false")
      .with("isString", "false")
      .with("isDate", "false")
      .with("snowflake_sqlType", "number")
      .with("graphqlType", "Long")
      .with("isTime", "false")
      .with("isText", "false");

      $factory.register(entityDescriptor);
  }
  private void registerTaxRate() {
      EntityDescriptor entityDescriptor = new EntityDescriptor();
      entityDescriptor.setType(com.example.enterpriseerpsystem.taxrate.TaxRate.INTERNAL_TYPE);
      entityDescriptor.setTargetType(com.example.enterpriseerpsystem.taxrate.TaxRate.class);
      entityDescriptor.setEntitySupplier(com.example.enterpriseerpsystem.taxrate.TaxRate::new);
      entityDescriptor.with("name", "Tax Rate")
      .with("module", "Finance")
      .with("module_key", "finance");

      PropertyDescriptor id = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.taxrate.TaxRate.ID_PROPERTY, Long.class)
      ;
      PropertyDescriptor isActive = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.taxrate.TaxRate.IS_ACTIVE_PROPERTY, Boolean.class)
      ;
      PropertyDescriptor rate = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.taxrate.TaxRate.RATE_PROPERTY, BigDecimal.class)
      ;
      PropertyDescriptor region = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.taxrate.TaxRate.REGION_PROPERTY, String.class)
      ;
      PropertyDescriptor createTime = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.taxrate.TaxRate.CREATE_TIME_PROPERTY, LocalDateTime.class)
      ;
      PropertyDescriptor updateTime = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.taxrate.TaxRate.UPDATE_TIME_PROPERTY, LocalDateTime.class)
      ;
      PropertyDescriptor version = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.taxrate.TaxRate.VERSION_PROPERTY, Long.class)
      ;
      entityDescriptor.findProperty(com.example.enterpriseerpsystem.taxrate.TaxRate.ID_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("oracle_sqlType", "number(11)")
      .with("javaType", "java.lang.Long")
      .with("sqlType", "BIGINT")
      .with("isId", "true")
      .with("isBaseEntityField", "true")
      .with("isBool", "false")
      .with("isNumber", "false")
      .with("isString", "false")
      .with("isDate", "false")
      .with("snowflake_sqlType", "number")
      .with("graphqlType", "Long")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.taxrate.TaxRate.IS_ACTIVE_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("oracle_sqlType", "number(1)")
      .with("javaType", "java.lang.Boolean")
      .with("candidates", "true")
      .with("sqlType", "BOOLEAN")
      .with("isId", "false")
      .with("isBool", "true")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("mssql_sqlType", "bit")
      .with("isString", "false")
      .with("isDate", "false")
      .with("graphqlType", "Boolean")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.taxrate.TaxRate.RATE_PROPERTY).with("isPassword", "false")
      .with("db2_sqlType", "decimal(19,7)")
      .with("isVersion", "false")
      .with("oracle_sqlType", "number(19,7)")
      .with("javaType", "java.math.BigDecimal")
      .with("candidates", "100.00")
      .with("sqlType", "NUMERIC(19,7)")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "true")
      .with("isString", "false")
      .with("isDate", "false")
      .with("graphqlType", "BigDecimal")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.taxrate.TaxRate.REGION_PROPERTY).with("isPassword", "false")
      .with("max", "100")
      .with("isVersion", "false")
      .with("javaType", "java.lang.String")
      .with("candidates", "region_value")
      .with("sqlType", "VARCHAR(<max>)")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("isString", "true")
      .with("isDate", "false")
      .with("graphqlType", "String")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.taxrate.TaxRate.CREATE_TIME_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("javaType", "java.time.LocalDateTime")
      .with("candidates", "createTime()")
      .with("sqlType", "TIMESTAMP")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("mssql_sqlType", "dateTime")
      .with("isDateTime", "true")
      .with("createFunction", "now")
      .with("isDate", "true")
      .with("isString", "false")
      .with("graphqlType", "LocalTime")
      .with("isTime", "true")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.taxrate.TaxRate.UPDATE_TIME_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("updateFunction", "now")
      .with("javaType", "java.time.LocalDateTime")
      .with("candidates", "updateTime()")
      .with("sqlType", "TIMESTAMP")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("mssql_sqlType", "dateTime")
      .with("isDateTime", "true")
      .with("createFunction", "now")
      .with("isDate", "true")
      .with("isString", "false")
      .with("graphqlType", "LocalTime")
      .with("isTime", "true")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.taxrate.TaxRate.VERSION_PROPERTY).with("isPassword", "false")
      .with("isVersion", "true")
      .with("oracle_sqlType", "number(11)")
      .with("javaType", "java.lang.Long")
      .with("sqlType", "BIGINT")
      .with("isId", "false")
      .with("isBaseEntityField", "true")
      .with("isBool", "false")
      .with("isNumber", "false")
      .with("isString", "false")
      .with("isDate", "false")
      .with("snowflake_sqlType", "number")
      .with("graphqlType", "Long")
      .with("isTime", "false")
      .with("isText", "false");

      $factory.register(entityDescriptor);
  }
  private void registerExpense() {
      EntityDescriptor entityDescriptor = new EntityDescriptor();
      entityDescriptor.setType(com.example.enterpriseerpsystem.expense.Expense.INTERNAL_TYPE);
      entityDescriptor.setTargetType(com.example.enterpriseerpsystem.expense.Expense.class);
      entityDescriptor.setEntitySupplier(com.example.enterpriseerpsystem.expense.Expense::new);
      entityDescriptor.with("name", "Expense")
      .with("module", "Finance")
      .with("module_key", "finance");

      PropertyDescriptor id = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.expense.Expense.ID_PROPERTY, Long.class)
      ;
      PropertyDescriptor amount = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.expense.Expense.AMOUNT_PROPERTY, BigDecimal.class)
      ;
      PropertyDescriptor category = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.expense.Expense.CATEGORY_PROPERTY, String.class)
      ;
      PropertyDescriptor dateIncurred = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.expense.Expense.DATE_INCURRED_PROPERTY, LocalDateTime.class)
      ;
      PropertyDescriptor employee = 
      entityDescriptor.addObjectProperty($factory, com.example.enterpriseerpsystem.expense.Expense.EMPLOYEE_PROPERTY, com.example.enterpriseerpsystem.employee.Employee.INTERNAL_TYPE, com.example.enterpriseerpsystem.employee.Employee.EXPENSE_LIST_PROPERTY, com.example.enterpriseerpsystem.employee.Employee.class)
      ;
      PropertyDescriptor status = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.expense.Expense.STATUS_PROPERTY, String.class)
      ;
      PropertyDescriptor createTime = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.expense.Expense.CREATE_TIME_PROPERTY, LocalDateTime.class)
      ;
      PropertyDescriptor updateTime = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.expense.Expense.UPDATE_TIME_PROPERTY, LocalDateTime.class)
      ;
      PropertyDescriptor version = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.expense.Expense.VERSION_PROPERTY, Long.class)
      ;
      entityDescriptor.findProperty(com.example.enterpriseerpsystem.expense.Expense.ID_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("oracle_sqlType", "number(11)")
      .with("javaType", "java.lang.Long")
      .with("sqlType", "BIGINT")
      .with("isId", "true")
      .with("isBaseEntityField", "true")
      .with("isBool", "false")
      .with("isNumber", "false")
      .with("isString", "false")
      .with("isDate", "false")
      .with("snowflake_sqlType", "number")
      .with("graphqlType", "Long")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.expense.Expense.AMOUNT_PROPERTY).with("isPassword", "false")
      .with("db2_sqlType", "decimal(19,7)")
      .with("isVersion", "false")
      .with("oracle_sqlType", "number(19,7)")
      .with("javaType", "java.math.BigDecimal")
      .with("sqlType", "NUMERIC(19,7)")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "true")
      .with("isString", "false")
      .with("isDate", "false")
      .with("graphqlType", "BigDecimal")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.expense.Expense.CATEGORY_PROPERTY).with("isPassword", "false")
      .with("max", "100")
      .with("isVersion", "false")
      .with("javaType", "java.lang.String")
      .with("sqlType", "VARCHAR(<max>)")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("isString", "true")
      .with("isDate", "false")
      .with("graphqlType", "String")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.expense.Expense.DATE_INCURRED_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("javaType", "java.time.LocalDateTime")
      .with("sqlType", "TIMESTAMP")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("mssql_sqlType", "dateTime")
      .with("isDateTime", "true")
      .with("createFunction", "now")
      .with("isDate", "true")
      .with("isString", "false")
      .with("graphqlType", "LocalTime")
      .with("isTime", "true")
      .with("isText", "false");


      entityDescriptor.findProperty(com.example.enterpriseerpsystem.expense.Expense.STATUS_PROPERTY).with("isPassword", "false")
      .with("max", "100")
      .with("isVersion", "false")
      .with("javaType", "java.lang.String")
      .with("sqlType", "VARCHAR(<max>)")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("isString", "true")
      .with("isDate", "false")
      .with("graphqlType", "String")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.expense.Expense.CREATE_TIME_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("javaType", "java.time.LocalDateTime")
      .with("sqlType", "TIMESTAMP")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("mssql_sqlType", "dateTime")
      .with("isDateTime", "true")
      .with("createFunction", "now")
      .with("isDate", "true")
      .with("isString", "false")
      .with("graphqlType", "LocalTime")
      .with("isTime", "true")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.expense.Expense.UPDATE_TIME_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("updateFunction", "now")
      .with("javaType", "java.time.LocalDateTime")
      .with("sqlType", "TIMESTAMP")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("mssql_sqlType", "dateTime")
      .with("isDateTime", "true")
      .with("createFunction", "now")
      .with("isDate", "true")
      .with("isString", "false")
      .with("graphqlType", "LocalTime")
      .with("isTime", "true")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.expense.Expense.VERSION_PROPERTY).with("isPassword", "false")
      .with("isVersion", "true")
      .with("oracle_sqlType", "number(11)")
      .with("javaType", "java.lang.Long")
      .with("sqlType", "BIGINT")
      .with("isId", "false")
      .with("isBaseEntityField", "true")
      .with("isBool", "false")
      .with("isNumber", "false")
      .with("isString", "false")
      .with("isDate", "false")
      .with("snowflake_sqlType", "number")
      .with("graphqlType", "Long")
      .with("isTime", "false")
      .with("isText", "false");

      $factory.register(entityDescriptor);
  }
  private void registerLedger() {
      EntityDescriptor entityDescriptor = new EntityDescriptor();
      entityDescriptor.setType(com.example.enterpriseerpsystem.ledger.Ledger.INTERNAL_TYPE);
      entityDescriptor.setTargetType(com.example.enterpriseerpsystem.ledger.Ledger.class);
      entityDescriptor.setEntitySupplier(com.example.enterpriseerpsystem.ledger.Ledger::new);
      entityDescriptor.with("name", "Ledger")
      .with("module", "Finance")
      .with("module_key", "finance");

      PropertyDescriptor id = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.ledger.Ledger.ID_PROPERTY, Long.class)
      ;
      PropertyDescriptor credit = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.ledger.Ledger.CREDIT_PROPERTY, BigDecimal.class)
      ;
      PropertyDescriptor debit = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.ledger.Ledger.DEBIT_PROPERTY, BigDecimal.class)
      ;
      PropertyDescriptor entryDate = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.ledger.Ledger.ENTRY_DATE_PROPERTY, LocalDateTime.class)
      ;
      PropertyDescriptor transaction = 
      entityDescriptor.addObjectProperty($factory, com.example.enterpriseerpsystem.ledger.Ledger.TRANSACTION_PROPERTY, com.example.enterpriseerpsystem.transaction.Transaction.INTERNAL_TYPE, com.example.enterpriseerpsystem.transaction.Transaction.LEDGER_LIST_PROPERTY, com.example.enterpriseerpsystem.transaction.Transaction.class)
      ;
      PropertyDescriptor createTime = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.ledger.Ledger.CREATE_TIME_PROPERTY, LocalDateTime.class)
      ;
      PropertyDescriptor updateTime = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.ledger.Ledger.UPDATE_TIME_PROPERTY, LocalDateTime.class)
      ;
      PropertyDescriptor version = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.ledger.Ledger.VERSION_PROPERTY, Long.class)
      ;
      entityDescriptor.findProperty(com.example.enterpriseerpsystem.ledger.Ledger.ID_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("oracle_sqlType", "number(11)")
      .with("javaType", "java.lang.Long")
      .with("sqlType", "BIGINT")
      .with("isId", "true")
      .with("isBaseEntityField", "true")
      .with("isBool", "false")
      .with("isNumber", "false")
      .with("isString", "false")
      .with("isDate", "false")
      .with("snowflake_sqlType", "number")
      .with("graphqlType", "Long")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.ledger.Ledger.CREDIT_PROPERTY).with("isPassword", "false")
      .with("db2_sqlType", "decimal(19,7)")
      .with("isVersion", "false")
      .with("oracle_sqlType", "number(19,7)")
      .with("javaType", "java.math.BigDecimal")
      .with("sqlType", "NUMERIC(19,7)")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "true")
      .with("isString", "false")
      .with("isDate", "false")
      .with("graphqlType", "BigDecimal")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.ledger.Ledger.DEBIT_PROPERTY).with("isPassword", "false")
      .with("db2_sqlType", "decimal(19,7)")
      .with("isVersion", "false")
      .with("oracle_sqlType", "number(19,7)")
      .with("javaType", "java.math.BigDecimal")
      .with("sqlType", "NUMERIC(19,7)")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "true")
      .with("isString", "false")
      .with("isDate", "false")
      .with("graphqlType", "BigDecimal")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.ledger.Ledger.ENTRY_DATE_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("javaType", "java.time.LocalDateTime")
      .with("sqlType", "TIMESTAMP")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("mssql_sqlType", "dateTime")
      .with("isDateTime", "true")
      .with("createFunction", "now")
      .with("isDate", "true")
      .with("isString", "false")
      .with("graphqlType", "LocalTime")
      .with("isTime", "true")
      .with("isText", "false");


      entityDescriptor.findProperty(com.example.enterpriseerpsystem.ledger.Ledger.CREATE_TIME_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("javaType", "java.time.LocalDateTime")
      .with("sqlType", "TIMESTAMP")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("mssql_sqlType", "dateTime")
      .with("isDateTime", "true")
      .with("createFunction", "now")
      .with("isDate", "true")
      .with("isString", "false")
      .with("graphqlType", "LocalTime")
      .with("isTime", "true")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.ledger.Ledger.UPDATE_TIME_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("updateFunction", "now")
      .with("javaType", "java.time.LocalDateTime")
      .with("sqlType", "TIMESTAMP")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("mssql_sqlType", "dateTime")
      .with("isDateTime", "true")
      .with("createFunction", "now")
      .with("isDate", "true")
      .with("isString", "false")
      .with("graphqlType", "LocalTime")
      .with("isTime", "true")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.ledger.Ledger.VERSION_PROPERTY).with("isPassword", "false")
      .with("isVersion", "true")
      .with("oracle_sqlType", "number(11)")
      .with("javaType", "java.lang.Long")
      .with("sqlType", "BIGINT")
      .with("isId", "false")
      .with("isBaseEntityField", "true")
      .with("isBool", "false")
      .with("isNumber", "false")
      .with("isString", "false")
      .with("isDate", "false")
      .with("snowflake_sqlType", "number")
      .with("graphqlType", "Long")
      .with("isTime", "false")
      .with("isText", "false");

      $factory.register(entityDescriptor);
  }
  private void registerSupplier() {
      EntityDescriptor entityDescriptor = new EntityDescriptor();
      entityDescriptor.setType(com.example.enterpriseerpsystem.supplier.Supplier.INTERNAL_TYPE);
      entityDescriptor.setTargetType(com.example.enterpriseerpsystem.supplier.Supplier.class);
      entityDescriptor.setEntitySupplier(com.example.enterpriseerpsystem.supplier.Supplier::new);
      entityDescriptor.with("name", "Supplier")
      .with("module", "SupplyChain")
      .with("module_key", "supplychain");

      PropertyDescriptor id = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.supplier.Supplier.ID_PROPERTY, Long.class)
      ;
      PropertyDescriptor address = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.supplier.Supplier.ADDRESS_PROPERTY, String.class)
      ;
      PropertyDescriptor contactEmail = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.supplier.Supplier.CONTACT_EMAIL_PROPERTY, String.class)
      ;
      PropertyDescriptor name = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.supplier.Supplier.NAME_PROPERTY, String.class)
      ;
      PropertyDescriptor phone = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.supplier.Supplier.PHONE_PROPERTY, String.class)
      ;
      PropertyDescriptor rating = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.supplier.Supplier.RATING_PROPERTY, BigDecimal.class)
      ;
      PropertyDescriptor createTime = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.supplier.Supplier.CREATE_TIME_PROPERTY, LocalDateTime.class)
      ;
      PropertyDescriptor updateTime = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.supplier.Supplier.UPDATE_TIME_PROPERTY, LocalDateTime.class)
      ;
      PropertyDescriptor version = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.supplier.Supplier.VERSION_PROPERTY, Long.class)
      ;
      entityDescriptor.findProperty(com.example.enterpriseerpsystem.supplier.Supplier.ID_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("oracle_sqlType", "number(11)")
      .with("javaType", "java.lang.Long")
      .with("sqlType", "BIGINT")
      .with("isId", "true")
      .with("isBaseEntityField", "true")
      .with("isBool", "false")
      .with("isNumber", "false")
      .with("isString", "false")
      .with("isDate", "false")
      .with("snowflake_sqlType", "number")
      .with("graphqlType", "Long")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.supplier.Supplier.ADDRESS_PROPERTY).with("isPassword", "false")
      .with("max", "100")
      .with("isVersion", "false")
      .with("javaType", "java.lang.String")
      .with("candidates", "address_value")
      .with("sqlType", "VARCHAR(<max>)")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("isString", "true")
      .with("isDate", "false")
      .with("graphqlType", "String")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.supplier.Supplier.CONTACT_EMAIL_PROPERTY).with("isPassword", "false")
      .with("max", "100")
      .with("isVersion", "false")
      .with("javaType", "java.lang.String")
      .with("candidates", "contact_email_value")
      .with("sqlType", "VARCHAR(<max>)")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("isString", "true")
      .with("isDate", "false")
      .with("graphqlType", "String")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.supplier.Supplier.NAME_PROPERTY).with("isPassword", "false")
      .with("max", "100")
      .with("isVersion", "false")
      .with("javaType", "java.lang.String")
      .with("candidates", "name_value")
      .with("sqlType", "VARCHAR(<max>)")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("isString", "true")
      .with("isDate", "false")
      .with("graphqlType", "String")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.supplier.Supplier.PHONE_PROPERTY).with("isPassword", "false")
      .with("max", "100")
      .with("isVersion", "false")
      .with("javaType", "java.lang.String")
      .with("candidates", "phone_value")
      .with("sqlType", "VARCHAR(<max>)")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("isString", "true")
      .with("isDate", "false")
      .with("graphqlType", "String")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.supplier.Supplier.RATING_PROPERTY).with("isPassword", "false")
      .with("db2_sqlType", "decimal(19,7)")
      .with("isVersion", "false")
      .with("oracle_sqlType", "number(19,7)")
      .with("javaType", "java.math.BigDecimal")
      .with("candidates", "100.00")
      .with("sqlType", "NUMERIC(19,7)")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "true")
      .with("isString", "false")
      .with("isDate", "false")
      .with("graphqlType", "BigDecimal")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.supplier.Supplier.CREATE_TIME_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("javaType", "java.time.LocalDateTime")
      .with("candidates", "createTime()")
      .with("sqlType", "TIMESTAMP")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("mssql_sqlType", "dateTime")
      .with("isDateTime", "true")
      .with("createFunction", "now")
      .with("isDate", "true")
      .with("isString", "false")
      .with("graphqlType", "LocalTime")
      .with("isTime", "true")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.supplier.Supplier.UPDATE_TIME_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("updateFunction", "now")
      .with("javaType", "java.time.LocalDateTime")
      .with("candidates", "updateTime()")
      .with("sqlType", "TIMESTAMP")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("mssql_sqlType", "dateTime")
      .with("isDateTime", "true")
      .with("createFunction", "now")
      .with("isDate", "true")
      .with("isString", "false")
      .with("graphqlType", "LocalTime")
      .with("isTime", "true")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.supplier.Supplier.VERSION_PROPERTY).with("isPassword", "false")
      .with("isVersion", "true")
      .with("oracle_sqlType", "number(11)")
      .with("javaType", "java.lang.Long")
      .with("sqlType", "BIGINT")
      .with("isId", "false")
      .with("isBaseEntityField", "true")
      .with("isBool", "false")
      .with("isNumber", "false")
      .with("isString", "false")
      .with("isDate", "false")
      .with("snowflake_sqlType", "number")
      .with("graphqlType", "Long")
      .with("isTime", "false")
      .with("isText", "false");

      $factory.register(entityDescriptor);
  }
  private void registerWarehouse() {
      EntityDescriptor entityDescriptor = new EntityDescriptor();
      entityDescriptor.setType(com.example.enterpriseerpsystem.warehouse.Warehouse.INTERNAL_TYPE);
      entityDescriptor.setTargetType(com.example.enterpriseerpsystem.warehouse.Warehouse.class);
      entityDescriptor.setEntitySupplier(com.example.enterpriseerpsystem.warehouse.Warehouse::new);
      entityDescriptor.with("name", "Warehouse")
      .with("module", "SupplyChain")
      .with("module_key", "supplychain");

      PropertyDescriptor id = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.warehouse.Warehouse.ID_PROPERTY, Long.class)
      ;
      PropertyDescriptor name = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.warehouse.Warehouse.NAME_PROPERTY, String.class)
      ;
      PropertyDescriptor capacity = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.warehouse.Warehouse.CAPACITY_PROPERTY, BigDecimal.class)
      ;
      PropertyDescriptor location = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.warehouse.Warehouse.LOCATION_PROPERTY, String.class)
      ;
      PropertyDescriptor managerId = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.warehouse.Warehouse.MANAGER_ID_PROPERTY, String.class)
      ;
      PropertyDescriptor createTime = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.warehouse.Warehouse.CREATE_TIME_PROPERTY, LocalDateTime.class)
      ;
      PropertyDescriptor updateTime = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.warehouse.Warehouse.UPDATE_TIME_PROPERTY, LocalDateTime.class)
      ;
      PropertyDescriptor version = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.warehouse.Warehouse.VERSION_PROPERTY, Long.class)
      ;
      entityDescriptor.findProperty(com.example.enterpriseerpsystem.warehouse.Warehouse.ID_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("oracle_sqlType", "number(11)")
      .with("javaType", "java.lang.Long")
      .with("sqlType", "BIGINT")
      .with("isId", "true")
      .with("isBaseEntityField", "true")
      .with("isBool", "false")
      .with("isNumber", "false")
      .with("isString", "false")
      .with("isDate", "false")
      .with("snowflake_sqlType", "number")
      .with("graphqlType", "Long")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.warehouse.Warehouse.NAME_PROPERTY).with("isPassword", "false")
      .with("max", "100")
      .with("isVersion", "false")
      .with("javaType", "java.lang.String")
      .with("candidates", "name_value")
      .with("sqlType", "VARCHAR(<max>)")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("isString", "true")
      .with("isDate", "false")
      .with("graphqlType", "String")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.warehouse.Warehouse.CAPACITY_PROPERTY).with("isPassword", "false")
      .with("db2_sqlType", "decimal(19,7)")
      .with("isVersion", "false")
      .with("oracle_sqlType", "number(19,7)")
      .with("javaType", "java.math.BigDecimal")
      .with("candidates", "100.00")
      .with("sqlType", "NUMERIC(19,7)")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "true")
      .with("isString", "false")
      .with("isDate", "false")
      .with("graphqlType", "BigDecimal")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.warehouse.Warehouse.LOCATION_PROPERTY).with("isPassword", "false")
      .with("max", "100")
      .with("isVersion", "false")
      .with("javaType", "java.lang.String")
      .with("candidates", "location_value")
      .with("sqlType", "VARCHAR(<max>)")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("isString", "true")
      .with("isDate", "false")
      .with("graphqlType", "String")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.warehouse.Warehouse.MANAGER_ID_PROPERTY).with("isPassword", "false")
      .with("max", "100")
      .with("isVersion", "false")
      .with("javaType", "java.lang.String")
      .with("candidates", "manager_id_value")
      .with("sqlType", "VARCHAR(<max>)")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("isString", "true")
      .with("isDate", "false")
      .with("graphqlType", "String")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.warehouse.Warehouse.CREATE_TIME_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("javaType", "java.time.LocalDateTime")
      .with("candidates", "createTime()")
      .with("sqlType", "TIMESTAMP")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("mssql_sqlType", "dateTime")
      .with("isDateTime", "true")
      .with("createFunction", "now")
      .with("isDate", "true")
      .with("isString", "false")
      .with("graphqlType", "LocalTime")
      .with("isTime", "true")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.warehouse.Warehouse.UPDATE_TIME_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("updateFunction", "now")
      .with("javaType", "java.time.LocalDateTime")
      .with("candidates", "updateTime()")
      .with("sqlType", "TIMESTAMP")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("mssql_sqlType", "dateTime")
      .with("isDateTime", "true")
      .with("createFunction", "now")
      .with("isDate", "true")
      .with("isString", "false")
      .with("graphqlType", "LocalTime")
      .with("isTime", "true")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.warehouse.Warehouse.VERSION_PROPERTY).with("isPassword", "false")
      .with("isVersion", "true")
      .with("oracle_sqlType", "number(11)")
      .with("javaType", "java.lang.Long")
      .with("sqlType", "BIGINT")
      .with("isId", "false")
      .with("isBaseEntityField", "true")
      .with("isBool", "false")
      .with("isNumber", "false")
      .with("isString", "false")
      .with("isDate", "false")
      .with("snowflake_sqlType", "number")
      .with("graphqlType", "Long")
      .with("isTime", "false")
      .with("isText", "false");

      $factory.register(entityDescriptor);
  }
  private void registerInventoryItem() {
      EntityDescriptor entityDescriptor = new EntityDescriptor();
      entityDescriptor.setType(com.example.enterpriseerpsystem.inventoryitem.InventoryItem.INTERNAL_TYPE);
      entityDescriptor.setTargetType(com.example.enterpriseerpsystem.inventoryitem.InventoryItem.class);
      entityDescriptor.setEntitySupplier(com.example.enterpriseerpsystem.inventoryitem.InventoryItem::new);
      entityDescriptor.with("name", "Inventory Item")
      .with("module", "SupplyChain")
      .with("module_key", "supplychain");

      PropertyDescriptor id = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.inventoryitem.InventoryItem.ID_PROPERTY, Long.class)
      ;
      PropertyDescriptor product = 
      entityDescriptor.addObjectProperty($factory, com.example.enterpriseerpsystem.inventoryitem.InventoryItem.PRODUCT_PROPERTY, com.example.enterpriseerpsystem.product.Product.INTERNAL_TYPE, com.example.enterpriseerpsystem.product.Product.INVENTORY_ITEM_LIST_PROPERTY, com.example.enterpriseerpsystem.product.Product.class)
      ;
      PropertyDescriptor quantityOnHand = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.inventoryitem.InventoryItem.QUANTITY_ON_HAND_PROPERTY, BigDecimal.class)
      ;
      PropertyDescriptor reorderLevel = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.inventoryitem.InventoryItem.REORDER_LEVEL_PROPERTY, BigDecimal.class)
      ;
      PropertyDescriptor warehouse = 
      entityDescriptor.addObjectProperty($factory, com.example.enterpriseerpsystem.inventoryitem.InventoryItem.WAREHOUSE_PROPERTY, com.example.enterpriseerpsystem.warehouse.Warehouse.INTERNAL_TYPE, com.example.enterpriseerpsystem.warehouse.Warehouse.INVENTORY_ITEM_LIST_PROPERTY, com.example.enterpriseerpsystem.warehouse.Warehouse.class)
      ;
      PropertyDescriptor createTime = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.inventoryitem.InventoryItem.CREATE_TIME_PROPERTY, LocalDateTime.class)
      ;
      PropertyDescriptor updateTime = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.inventoryitem.InventoryItem.UPDATE_TIME_PROPERTY, LocalDateTime.class)
      ;
      PropertyDescriptor version = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.inventoryitem.InventoryItem.VERSION_PROPERTY, Long.class)
      ;
      entityDescriptor.findProperty(com.example.enterpriseerpsystem.inventoryitem.InventoryItem.ID_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("oracle_sqlType", "number(11)")
      .with("javaType", "java.lang.Long")
      .with("sqlType", "BIGINT")
      .with("isId", "true")
      .with("isBaseEntityField", "true")
      .with("isBool", "false")
      .with("isNumber", "false")
      .with("isString", "false")
      .with("isDate", "false")
      .with("snowflake_sqlType", "number")
      .with("graphqlType", "Long")
      .with("isTime", "false")
      .with("isText", "false");


      entityDescriptor.findProperty(com.example.enterpriseerpsystem.inventoryitem.InventoryItem.QUANTITY_ON_HAND_PROPERTY).with("isPassword", "false")
      .with("db2_sqlType", "decimal(19,7)")
      .with("isVersion", "false")
      .with("oracle_sqlType", "number(19,7)")
      .with("javaType", "java.math.BigDecimal")
      .with("sqlType", "NUMERIC(19,7)")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "true")
      .with("isString", "false")
      .with("isDate", "false")
      .with("graphqlType", "BigDecimal")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.inventoryitem.InventoryItem.REORDER_LEVEL_PROPERTY).with("isPassword", "false")
      .with("db2_sqlType", "decimal(19,7)")
      .with("isVersion", "false")
      .with("oracle_sqlType", "number(19,7)")
      .with("javaType", "java.math.BigDecimal")
      .with("sqlType", "NUMERIC(19,7)")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "true")
      .with("isString", "false")
      .with("isDate", "false")
      .with("graphqlType", "BigDecimal")
      .with("isTime", "false")
      .with("isText", "false");


      entityDescriptor.findProperty(com.example.enterpriseerpsystem.inventoryitem.InventoryItem.CREATE_TIME_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("javaType", "java.time.LocalDateTime")
      .with("sqlType", "TIMESTAMP")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("mssql_sqlType", "dateTime")
      .with("isDateTime", "true")
      .with("createFunction", "now")
      .with("isDate", "true")
      .with("isString", "false")
      .with("graphqlType", "LocalTime")
      .with("isTime", "true")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.inventoryitem.InventoryItem.UPDATE_TIME_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("updateFunction", "now")
      .with("javaType", "java.time.LocalDateTime")
      .with("sqlType", "TIMESTAMP")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("mssql_sqlType", "dateTime")
      .with("isDateTime", "true")
      .with("createFunction", "now")
      .with("isDate", "true")
      .with("isString", "false")
      .with("graphqlType", "LocalTime")
      .with("isTime", "true")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.inventoryitem.InventoryItem.VERSION_PROPERTY).with("isPassword", "false")
      .with("isVersion", "true")
      .with("oracle_sqlType", "number(11)")
      .with("javaType", "java.lang.Long")
      .with("sqlType", "BIGINT")
      .with("isId", "false")
      .with("isBaseEntityField", "true")
      .with("isBool", "false")
      .with("isNumber", "false")
      .with("isString", "false")
      .with("isDate", "false")
      .with("snowflake_sqlType", "number")
      .with("graphqlType", "Long")
      .with("isTime", "false")
      .with("isText", "false");

      $factory.register(entityDescriptor);
  }
  private void registerPurchaseOrder() {
      EntityDescriptor entityDescriptor = new EntityDescriptor();
      entityDescriptor.setType(com.example.enterpriseerpsystem.purchaseorder.PurchaseOrder.INTERNAL_TYPE);
      entityDescriptor.setTargetType(com.example.enterpriseerpsystem.purchaseorder.PurchaseOrder.class);
      entityDescriptor.setEntitySupplier(com.example.enterpriseerpsystem.purchaseorder.PurchaseOrder::new);
      entityDescriptor.with("name", "Purchase Order")
      .with("module", "SupplyChain")
      .with("module_key", "supplychain");

      PropertyDescriptor id = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.purchaseorder.PurchaseOrder.ID_PROPERTY, Long.class)
      ;
      PropertyDescriptor orderDate = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.purchaseorder.PurchaseOrder.ORDER_DATE_PROPERTY, LocalDateTime.class)
      ;
      PropertyDescriptor status = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.purchaseorder.PurchaseOrder.STATUS_PROPERTY, String.class)
      ;
      PropertyDescriptor supplier = 
      entityDescriptor.addObjectProperty($factory, com.example.enterpriseerpsystem.purchaseorder.PurchaseOrder.SUPPLIER_PROPERTY, com.example.enterpriseerpsystem.supplier.Supplier.INTERNAL_TYPE, com.example.enterpriseerpsystem.supplier.Supplier.PURCHASE_ORDER_LIST_PROPERTY, com.example.enterpriseerpsystem.supplier.Supplier.class)
      ;
      PropertyDescriptor totalCost = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.purchaseorder.PurchaseOrder.TOTAL_COST_PROPERTY, BigDecimal.class)
      ;
      PropertyDescriptor createTime = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.purchaseorder.PurchaseOrder.CREATE_TIME_PROPERTY, LocalDateTime.class)
      ;
      PropertyDescriptor updateTime = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.purchaseorder.PurchaseOrder.UPDATE_TIME_PROPERTY, LocalDateTime.class)
      ;
      PropertyDescriptor version = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.purchaseorder.PurchaseOrder.VERSION_PROPERTY, Long.class)
      ;
      entityDescriptor.findProperty(com.example.enterpriseerpsystem.purchaseorder.PurchaseOrder.ID_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("oracle_sqlType", "number(11)")
      .with("javaType", "java.lang.Long")
      .with("sqlType", "BIGINT")
      .with("isId", "true")
      .with("isBaseEntityField", "true")
      .with("isBool", "false")
      .with("isNumber", "false")
      .with("isString", "false")
      .with("isDate", "false")
      .with("snowflake_sqlType", "number")
      .with("graphqlType", "Long")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.purchaseorder.PurchaseOrder.ORDER_DATE_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("javaType", "java.time.LocalDateTime")
      .with("sqlType", "TIMESTAMP")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("mssql_sqlType", "dateTime")
      .with("isDateTime", "true")
      .with("createFunction", "now")
      .with("isDate", "true")
      .with("isString", "false")
      .with("graphqlType", "LocalTime")
      .with("isTime", "true")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.purchaseorder.PurchaseOrder.STATUS_PROPERTY).with("isPassword", "false")
      .with("max", "100")
      .with("isVersion", "false")
      .with("javaType", "java.lang.String")
      .with("sqlType", "VARCHAR(<max>)")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("isString", "true")
      .with("isDate", "false")
      .with("graphqlType", "String")
      .with("isTime", "false")
      .with("isText", "false");


      entityDescriptor.findProperty(com.example.enterpriseerpsystem.purchaseorder.PurchaseOrder.TOTAL_COST_PROPERTY).with("isPassword", "false")
      .with("db2_sqlType", "decimal(19,7)")
      .with("isVersion", "false")
      .with("oracle_sqlType", "number(19,7)")
      .with("javaType", "java.math.BigDecimal")
      .with("sqlType", "NUMERIC(19,7)")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "true")
      .with("isString", "false")
      .with("isDate", "false")
      .with("graphqlType", "BigDecimal")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.purchaseorder.PurchaseOrder.CREATE_TIME_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("javaType", "java.time.LocalDateTime")
      .with("sqlType", "TIMESTAMP")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("mssql_sqlType", "dateTime")
      .with("isDateTime", "true")
      .with("createFunction", "now")
      .with("isDate", "true")
      .with("isString", "false")
      .with("graphqlType", "LocalTime")
      .with("isTime", "true")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.purchaseorder.PurchaseOrder.UPDATE_TIME_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("updateFunction", "now")
      .with("javaType", "java.time.LocalDateTime")
      .with("sqlType", "TIMESTAMP")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("mssql_sqlType", "dateTime")
      .with("isDateTime", "true")
      .with("createFunction", "now")
      .with("isDate", "true")
      .with("isString", "false")
      .with("graphqlType", "LocalTime")
      .with("isTime", "true")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.purchaseorder.PurchaseOrder.VERSION_PROPERTY).with("isPassword", "false")
      .with("isVersion", "true")
      .with("oracle_sqlType", "number(11)")
      .with("javaType", "java.lang.Long")
      .with("sqlType", "BIGINT")
      .with("isId", "false")
      .with("isBaseEntityField", "true")
      .with("isBool", "false")
      .with("isNumber", "false")
      .with("isString", "false")
      .with("isDate", "false")
      .with("snowflake_sqlType", "number")
      .with("graphqlType", "Long")
      .with("isTime", "false")
      .with("isText", "false");

      $factory.register(entityDescriptor);
  }
  private void registerPurchaseOrderItem() {
      EntityDescriptor entityDescriptor = new EntityDescriptor();
      entityDescriptor.setType(com.example.enterpriseerpsystem.purchaseorderitem.PurchaseOrderItem.INTERNAL_TYPE);
      entityDescriptor.setTargetType(com.example.enterpriseerpsystem.purchaseorderitem.PurchaseOrderItem.class);
      entityDescriptor.setEntitySupplier(com.example.enterpriseerpsystem.purchaseorderitem.PurchaseOrderItem::new);
      entityDescriptor.with("name", "Purchase Order Item")
      .with("module", "SupplyChain")
      .with("module_key", "supplychain");

      PropertyDescriptor id = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.purchaseorderitem.PurchaseOrderItem.ID_PROPERTY, Long.class)
      ;
      PropertyDescriptor product = 
      entityDescriptor.addObjectProperty($factory, com.example.enterpriseerpsystem.purchaseorderitem.PurchaseOrderItem.PRODUCT_PROPERTY, com.example.enterpriseerpsystem.product.Product.INTERNAL_TYPE, com.example.enterpriseerpsystem.product.Product.PURCHASE_ORDER_ITEM_LIST_PROPERTY, com.example.enterpriseerpsystem.product.Product.class)
      ;
      PropertyDescriptor purchaseOrder = 
      entityDescriptor.addObjectProperty($factory, com.example.enterpriseerpsystem.purchaseorderitem.PurchaseOrderItem.PURCHASE_ORDER_PROPERTY, com.example.enterpriseerpsystem.purchaseorder.PurchaseOrder.INTERNAL_TYPE, com.example.enterpriseerpsystem.purchaseorder.PurchaseOrder.PURCHASE_ORDER_ITEM_LIST_PROPERTY, com.example.enterpriseerpsystem.purchaseorder.PurchaseOrder.class)
      ;
      PropertyDescriptor quantity = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.purchaseorderitem.PurchaseOrderItem.QUANTITY_PROPERTY, BigDecimal.class)
      ;
      PropertyDescriptor unitCost = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.purchaseorderitem.PurchaseOrderItem.UNIT_COST_PROPERTY, BigDecimal.class)
      ;
      PropertyDescriptor createTime = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.purchaseorderitem.PurchaseOrderItem.CREATE_TIME_PROPERTY, LocalDateTime.class)
      ;
      PropertyDescriptor updateTime = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.purchaseorderitem.PurchaseOrderItem.UPDATE_TIME_PROPERTY, LocalDateTime.class)
      ;
      PropertyDescriptor version = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.purchaseorderitem.PurchaseOrderItem.VERSION_PROPERTY, Long.class)
      ;
      entityDescriptor.findProperty(com.example.enterpriseerpsystem.purchaseorderitem.PurchaseOrderItem.ID_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("oracle_sqlType", "number(11)")
      .with("javaType", "java.lang.Long")
      .with("sqlType", "BIGINT")
      .with("isId", "true")
      .with("isBaseEntityField", "true")
      .with("isBool", "false")
      .with("isNumber", "false")
      .with("isString", "false")
      .with("isDate", "false")
      .with("snowflake_sqlType", "number")
      .with("graphqlType", "Long")
      .with("isTime", "false")
      .with("isText", "false");



      entityDescriptor.findProperty(com.example.enterpriseerpsystem.purchaseorderitem.PurchaseOrderItem.QUANTITY_PROPERTY).with("isPassword", "false")
      .with("db2_sqlType", "decimal(19,7)")
      .with("isVersion", "false")
      .with("oracle_sqlType", "number(19,7)")
      .with("javaType", "java.math.BigDecimal")
      .with("sqlType", "NUMERIC(19,7)")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "true")
      .with("isString", "false")
      .with("isDate", "false")
      .with("graphqlType", "BigDecimal")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.purchaseorderitem.PurchaseOrderItem.UNIT_COST_PROPERTY).with("isPassword", "false")
      .with("db2_sqlType", "decimal(19,7)")
      .with("isVersion", "false")
      .with("oracle_sqlType", "number(19,7)")
      .with("javaType", "java.math.BigDecimal")
      .with("sqlType", "NUMERIC(19,7)")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "true")
      .with("isString", "false")
      .with("isDate", "false")
      .with("graphqlType", "BigDecimal")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.purchaseorderitem.PurchaseOrderItem.CREATE_TIME_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("javaType", "java.time.LocalDateTime")
      .with("sqlType", "TIMESTAMP")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("mssql_sqlType", "dateTime")
      .with("isDateTime", "true")
      .with("createFunction", "now")
      .with("isDate", "true")
      .with("isString", "false")
      .with("graphqlType", "LocalTime")
      .with("isTime", "true")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.purchaseorderitem.PurchaseOrderItem.UPDATE_TIME_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("updateFunction", "now")
      .with("javaType", "java.time.LocalDateTime")
      .with("sqlType", "TIMESTAMP")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("mssql_sqlType", "dateTime")
      .with("isDateTime", "true")
      .with("createFunction", "now")
      .with("isDate", "true")
      .with("isString", "false")
      .with("graphqlType", "LocalTime")
      .with("isTime", "true")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.purchaseorderitem.PurchaseOrderItem.VERSION_PROPERTY).with("isPassword", "false")
      .with("isVersion", "true")
      .with("oracle_sqlType", "number(11)")
      .with("javaType", "java.lang.Long")
      .with("sqlType", "BIGINT")
      .with("isId", "false")
      .with("isBaseEntityField", "true")
      .with("isBool", "false")
      .with("isNumber", "false")
      .with("isString", "false")
      .with("isDate", "false")
      .with("snowflake_sqlType", "number")
      .with("graphqlType", "Long")
      .with("isTime", "false")
      .with("isText", "false");

      $factory.register(entityDescriptor);
  }
  private void registerShipment() {
      EntityDescriptor entityDescriptor = new EntityDescriptor();
      entityDescriptor.setType(com.example.enterpriseerpsystem.shipment.Shipment.INTERNAL_TYPE);
      entityDescriptor.setTargetType(com.example.enterpriseerpsystem.shipment.Shipment.class);
      entityDescriptor.setEntitySupplier(com.example.enterpriseerpsystem.shipment.Shipment::new);
      entityDescriptor.with("name", "Shipment")
      .with("module", "SupplyChain")
      .with("module_key", "supplychain");

      PropertyDescriptor id = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.shipment.Shipment.ID_PROPERTY, Long.class)
      ;
      PropertyDescriptor shippedDate = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.shipment.Shipment.SHIPPED_DATE_PROPERTY, LocalDateTime.class)
      ;
      PropertyDescriptor carrier = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.shipment.Shipment.CARRIER_PROPERTY, String.class)
      ;
      PropertyDescriptor globalOrder = 
      entityDescriptor.addObjectProperty($factory, com.example.enterpriseerpsystem.shipment.Shipment.GLOBAL_ORDER_PROPERTY, com.example.enterpriseerpsystem.globalorder.GlobalOrder.INTERNAL_TYPE, com.example.enterpriseerpsystem.globalorder.GlobalOrder.SHIPMENT_LIST_PROPERTY, com.example.enterpriseerpsystem.globalorder.GlobalOrder.class)
      ;
      PropertyDescriptor status = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.shipment.Shipment.STATUS_PROPERTY, String.class)
      ;
      PropertyDescriptor trackingNumber = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.shipment.Shipment.TRACKING_NUMBER_PROPERTY, String.class)
      ;
      PropertyDescriptor warehouse = 
      entityDescriptor.addObjectProperty($factory, com.example.enterpriseerpsystem.shipment.Shipment.WAREHOUSE_PROPERTY, com.example.enterpriseerpsystem.warehouse.Warehouse.INTERNAL_TYPE, com.example.enterpriseerpsystem.warehouse.Warehouse.SHIPMENT_LIST_PROPERTY, com.example.enterpriseerpsystem.warehouse.Warehouse.class)
      ;
      PropertyDescriptor createTime = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.shipment.Shipment.CREATE_TIME_PROPERTY, LocalDateTime.class)
      ;
      PropertyDescriptor updateTime = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.shipment.Shipment.UPDATE_TIME_PROPERTY, LocalDateTime.class)
      ;
      PropertyDescriptor version = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.shipment.Shipment.VERSION_PROPERTY, Long.class)
      ;
      entityDescriptor.findProperty(com.example.enterpriseerpsystem.shipment.Shipment.ID_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("oracle_sqlType", "number(11)")
      .with("javaType", "java.lang.Long")
      .with("sqlType", "BIGINT")
      .with("isId", "true")
      .with("isBaseEntityField", "true")
      .with("isBool", "false")
      .with("isNumber", "false")
      .with("isString", "false")
      .with("isDate", "false")
      .with("snowflake_sqlType", "number")
      .with("graphqlType", "Long")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.shipment.Shipment.SHIPPED_DATE_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("javaType", "java.time.LocalDateTime")
      .with("sqlType", "TIMESTAMP")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("mssql_sqlType", "dateTime")
      .with("isDateTime", "true")
      .with("createFunction", "now")
      .with("isDate", "true")
      .with("isString", "false")
      .with("graphqlType", "LocalTime")
      .with("isTime", "true")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.shipment.Shipment.CARRIER_PROPERTY).with("isPassword", "false")
      .with("max", "100")
      .with("isVersion", "false")
      .with("javaType", "java.lang.String")
      .with("sqlType", "VARCHAR(<max>)")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("isString", "true")
      .with("isDate", "false")
      .with("graphqlType", "String")
      .with("isTime", "false")
      .with("isText", "false");


      entityDescriptor.findProperty(com.example.enterpriseerpsystem.shipment.Shipment.STATUS_PROPERTY).with("isPassword", "false")
      .with("max", "100")
      .with("isVersion", "false")
      .with("javaType", "java.lang.String")
      .with("sqlType", "VARCHAR(<max>)")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("isString", "true")
      .with("isDate", "false")
      .with("graphqlType", "String")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.shipment.Shipment.TRACKING_NUMBER_PROPERTY).with("isPassword", "false")
      .with("max", "100")
      .with("isVersion", "false")
      .with("javaType", "java.lang.String")
      .with("sqlType", "VARCHAR(<max>)")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("isString", "true")
      .with("isDate", "false")
      .with("graphqlType", "String")
      .with("isTime", "false")
      .with("isText", "false");


      entityDescriptor.findProperty(com.example.enterpriseerpsystem.shipment.Shipment.CREATE_TIME_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("javaType", "java.time.LocalDateTime")
      .with("sqlType", "TIMESTAMP")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("mssql_sqlType", "dateTime")
      .with("isDateTime", "true")
      .with("createFunction", "now")
      .with("isDate", "true")
      .with("isString", "false")
      .with("graphqlType", "LocalTime")
      .with("isTime", "true")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.shipment.Shipment.UPDATE_TIME_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("updateFunction", "now")
      .with("javaType", "java.time.LocalDateTime")
      .with("sqlType", "TIMESTAMP")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("mssql_sqlType", "dateTime")
      .with("isDateTime", "true")
      .with("createFunction", "now")
      .with("isDate", "true")
      .with("isString", "false")
      .with("graphqlType", "LocalTime")
      .with("isTime", "true")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.shipment.Shipment.VERSION_PROPERTY).with("isPassword", "false")
      .with("isVersion", "true")
      .with("oracle_sqlType", "number(11)")
      .with("javaType", "java.lang.Long")
      .with("sqlType", "BIGINT")
      .with("isId", "false")
      .with("isBaseEntityField", "true")
      .with("isBool", "false")
      .with("isNumber", "false")
      .with("isString", "false")
      .with("isDate", "false")
      .with("snowflake_sqlType", "number")
      .with("graphqlType", "Long")
      .with("isTime", "false")
      .with("isText", "false");

      $factory.register(entityDescriptor);
  }
  private void registerDelivery() {
      EntityDescriptor entityDescriptor = new EntityDescriptor();
      entityDescriptor.setType(com.example.enterpriseerpsystem.delivery.Delivery.INTERNAL_TYPE);
      entityDescriptor.setTargetType(com.example.enterpriseerpsystem.delivery.Delivery.class);
      entityDescriptor.setEntitySupplier(com.example.enterpriseerpsystem.delivery.Delivery::new);
      entityDescriptor.with("name", "Delivery")
      .with("module", "SupplyChain")
      .with("module_key", "supplychain");

      PropertyDescriptor id = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.delivery.Delivery.ID_PROPERTY, Long.class)
      ;
      PropertyDescriptor recipientSignature = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.delivery.Delivery.RECIPIENT_SIGNATURE_PROPERTY, String.class)
      ;
      PropertyDescriptor shipment = 
      entityDescriptor.addObjectProperty($factory, com.example.enterpriseerpsystem.delivery.Delivery.SHIPMENT_PROPERTY, com.example.enterpriseerpsystem.shipment.Shipment.INTERNAL_TYPE, com.example.enterpriseerpsystem.shipment.Shipment.DELIVERY_LIST_PROPERTY, com.example.enterpriseerpsystem.shipment.Shipment.class)
      ;
      PropertyDescriptor deliveryDate = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.delivery.Delivery.DELIVERY_DATE_PROPERTY, LocalDateTime.class)
      ;
      PropertyDescriptor status = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.delivery.Delivery.STATUS_PROPERTY, String.class)
      ;
      PropertyDescriptor createTime = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.delivery.Delivery.CREATE_TIME_PROPERTY, LocalDateTime.class)
      ;
      PropertyDescriptor updateTime = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.delivery.Delivery.UPDATE_TIME_PROPERTY, LocalDateTime.class)
      ;
      PropertyDescriptor version = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.delivery.Delivery.VERSION_PROPERTY, Long.class)
      ;
      entityDescriptor.findProperty(com.example.enterpriseerpsystem.delivery.Delivery.ID_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("oracle_sqlType", "number(11)")
      .with("javaType", "java.lang.Long")
      .with("sqlType", "BIGINT")
      .with("isId", "true")
      .with("isBaseEntityField", "true")
      .with("isBool", "false")
      .with("isNumber", "false")
      .with("isString", "false")
      .with("isDate", "false")
      .with("snowflake_sqlType", "number")
      .with("graphqlType", "Long")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.delivery.Delivery.RECIPIENT_SIGNATURE_PROPERTY).with("isPassword", "false")
      .with("max", "100")
      .with("isVersion", "false")
      .with("javaType", "java.lang.String")
      .with("sqlType", "VARCHAR(<max>)")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("isString", "true")
      .with("isDate", "false")
      .with("graphqlType", "String")
      .with("isTime", "false")
      .with("isText", "false");


      entityDescriptor.findProperty(com.example.enterpriseerpsystem.delivery.Delivery.DELIVERY_DATE_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("javaType", "java.time.LocalDateTime")
      .with("sqlType", "TIMESTAMP")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("mssql_sqlType", "dateTime")
      .with("isDateTime", "true")
      .with("createFunction", "now")
      .with("isDate", "true")
      .with("isString", "false")
      .with("graphqlType", "LocalTime")
      .with("isTime", "true")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.delivery.Delivery.STATUS_PROPERTY).with("isPassword", "false")
      .with("max", "100")
      .with("isVersion", "false")
      .with("javaType", "java.lang.String")
      .with("sqlType", "VARCHAR(<max>)")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("isString", "true")
      .with("isDate", "false")
      .with("graphqlType", "String")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.delivery.Delivery.CREATE_TIME_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("javaType", "java.time.LocalDateTime")
      .with("sqlType", "TIMESTAMP")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("mssql_sqlType", "dateTime")
      .with("isDateTime", "true")
      .with("createFunction", "now")
      .with("isDate", "true")
      .with("isString", "false")
      .with("graphqlType", "LocalTime")
      .with("isTime", "true")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.delivery.Delivery.UPDATE_TIME_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("updateFunction", "now")
      .with("javaType", "java.time.LocalDateTime")
      .with("sqlType", "TIMESTAMP")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("mssql_sqlType", "dateTime")
      .with("isDateTime", "true")
      .with("createFunction", "now")
      .with("isDate", "true")
      .with("isString", "false")
      .with("graphqlType", "LocalTime")
      .with("isTime", "true")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.delivery.Delivery.VERSION_PROPERTY).with("isPassword", "false")
      .with("isVersion", "true")
      .with("oracle_sqlType", "number(11)")
      .with("javaType", "java.lang.Long")
      .with("sqlType", "BIGINT")
      .with("isId", "false")
      .with("isBaseEntityField", "true")
      .with("isBool", "false")
      .with("isNumber", "false")
      .with("isString", "false")
      .with("isDate", "false")
      .with("snowflake_sqlType", "number")
      .with("graphqlType", "Long")
      .with("isTime", "false")
      .with("isText", "false");

      $factory.register(entityDescriptor);
  }
  private void registerReturnRequest() {
      EntityDescriptor entityDescriptor = new EntityDescriptor();
      entityDescriptor.setType(com.example.enterpriseerpsystem.returnrequest.ReturnRequest.INTERNAL_TYPE);
      entityDescriptor.setTargetType(com.example.enterpriseerpsystem.returnrequest.ReturnRequest.class);
      entityDescriptor.setEntitySupplier(com.example.enterpriseerpsystem.returnrequest.ReturnRequest::new);
      entityDescriptor.with("name", "Return Request")
      .with("module", "SupplyChain")
      .with("module_key", "supplychain");

      PropertyDescriptor id = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.returnrequest.ReturnRequest.ID_PROPERTY, Long.class)
      ;
      PropertyDescriptor refundAmount = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.returnrequest.ReturnRequest.REFUND_AMOUNT_PROPERTY, BigDecimal.class)
      ;
      PropertyDescriptor customer = 
      entityDescriptor.addObjectProperty($factory, com.example.enterpriseerpsystem.returnrequest.ReturnRequest.CUSTOMER_PROPERTY, com.example.enterpriseerpsystem.customer.Customer.INTERNAL_TYPE, com.example.enterpriseerpsystem.customer.Customer.RETURN_REQUEST_LIST_PROPERTY, com.example.enterpriseerpsystem.customer.Customer.class)
      ;
      PropertyDescriptor globalOrder = 
      entityDescriptor.addObjectProperty($factory, com.example.enterpriseerpsystem.returnrequest.ReturnRequest.GLOBAL_ORDER_PROPERTY, com.example.enterpriseerpsystem.globalorder.GlobalOrder.INTERNAL_TYPE, com.example.enterpriseerpsystem.globalorder.GlobalOrder.RETURN_REQUEST_LIST_PROPERTY, com.example.enterpriseerpsystem.globalorder.GlobalOrder.class)
      ;
      PropertyDescriptor reason = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.returnrequest.ReturnRequest.REASON_PROPERTY, String.class)
      ;
      PropertyDescriptor status = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.returnrequest.ReturnRequest.STATUS_PROPERTY, String.class)
      ;
      PropertyDescriptor createTime = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.returnrequest.ReturnRequest.CREATE_TIME_PROPERTY, LocalDateTime.class)
      ;
      PropertyDescriptor updateTime = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.returnrequest.ReturnRequest.UPDATE_TIME_PROPERTY, LocalDateTime.class)
      ;
      PropertyDescriptor version = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.returnrequest.ReturnRequest.VERSION_PROPERTY, Long.class)
      ;
      entityDescriptor.findProperty(com.example.enterpriseerpsystem.returnrequest.ReturnRequest.ID_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("oracle_sqlType", "number(11)")
      .with("javaType", "java.lang.Long")
      .with("sqlType", "BIGINT")
      .with("isId", "true")
      .with("isBaseEntityField", "true")
      .with("isBool", "false")
      .with("isNumber", "false")
      .with("isString", "false")
      .with("isDate", "false")
      .with("snowflake_sqlType", "number")
      .with("graphqlType", "Long")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.returnrequest.ReturnRequest.REFUND_AMOUNT_PROPERTY).with("isPassword", "false")
      .with("db2_sqlType", "decimal(19,7)")
      .with("isVersion", "false")
      .with("oracle_sqlType", "number(19,7)")
      .with("javaType", "java.math.BigDecimal")
      .with("sqlType", "NUMERIC(19,7)")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "true")
      .with("isString", "false")
      .with("isDate", "false")
      .with("graphqlType", "BigDecimal")
      .with("isTime", "false")
      .with("isText", "false");



      entityDescriptor.findProperty(com.example.enterpriseerpsystem.returnrequest.ReturnRequest.REASON_PROPERTY).with("isPassword", "false")
      .with("max", "100")
      .with("isVersion", "false")
      .with("javaType", "java.lang.String")
      .with("sqlType", "VARCHAR(<max>)")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("isString", "true")
      .with("isDate", "false")
      .with("graphqlType", "String")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.returnrequest.ReturnRequest.STATUS_PROPERTY).with("isPassword", "false")
      .with("max", "100")
      .with("isVersion", "false")
      .with("javaType", "java.lang.String")
      .with("sqlType", "VARCHAR(<max>)")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("isString", "true")
      .with("isDate", "false")
      .with("graphqlType", "String")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.returnrequest.ReturnRequest.CREATE_TIME_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("javaType", "java.time.LocalDateTime")
      .with("sqlType", "TIMESTAMP")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("mssql_sqlType", "dateTime")
      .with("isDateTime", "true")
      .with("createFunction", "now")
      .with("isDate", "true")
      .with("isString", "false")
      .with("graphqlType", "LocalTime")
      .with("isTime", "true")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.returnrequest.ReturnRequest.UPDATE_TIME_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("updateFunction", "now")
      .with("javaType", "java.time.LocalDateTime")
      .with("sqlType", "TIMESTAMP")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("mssql_sqlType", "dateTime")
      .with("isDateTime", "true")
      .with("createFunction", "now")
      .with("isDate", "true")
      .with("isString", "false")
      .with("graphqlType", "LocalTime")
      .with("isTime", "true")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.returnrequest.ReturnRequest.VERSION_PROPERTY).with("isPassword", "false")
      .with("isVersion", "true")
      .with("oracle_sqlType", "number(11)")
      .with("javaType", "java.lang.Long")
      .with("sqlType", "BIGINT")
      .with("isId", "false")
      .with("isBaseEntityField", "true")
      .with("isBool", "false")
      .with("isNumber", "false")
      .with("isString", "false")
      .with("isDate", "false")
      .with("snowflake_sqlType", "number")
      .with("graphqlType", "Long")
      .with("isTime", "false")
      .with("isText", "false");

      $factory.register(entityDescriptor);
  }
  private void registerTicket() {
      EntityDescriptor entityDescriptor = new EntityDescriptor();
      entityDescriptor.setType(com.example.enterpriseerpsystem.ticket.Ticket.INTERNAL_TYPE);
      entityDescriptor.setTargetType(com.example.enterpriseerpsystem.ticket.Ticket.class);
      entityDescriptor.setEntitySupplier(com.example.enterpriseerpsystem.ticket.Ticket::new);
      entityDescriptor.with("name", "Ticket")
      .with("module", "CustomerSupport")
      .with("module_key", "customersupport");

      PropertyDescriptor id = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.ticket.Ticket.ID_PROPERTY, Long.class)
      ;
      PropertyDescriptor description = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.ticket.Ticket.DESCRIPTION_PROPERTY, String.class)
      ;
      PropertyDescriptor createdAt = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.ticket.Ticket.CREATED_AT_PROPERTY, LocalDateTime.class)
      ;
      PropertyDescriptor customer = 
      entityDescriptor.addObjectProperty($factory, com.example.enterpriseerpsystem.ticket.Ticket.CUSTOMER_PROPERTY, com.example.enterpriseerpsystem.customer.Customer.INTERNAL_TYPE, com.example.enterpriseerpsystem.customer.Customer.TICKET_LIST_PROPERTY, com.example.enterpriseerpsystem.customer.Customer.class)
      ;
      PropertyDescriptor priority = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.ticket.Ticket.PRIORITY_PROPERTY, String.class)
      ;
      PropertyDescriptor status = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.ticket.Ticket.STATUS_PROPERTY, String.class)
      ;
      PropertyDescriptor subject = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.ticket.Ticket.SUBJECT_PROPERTY, String.class)
      ;
      PropertyDescriptor createTime = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.ticket.Ticket.CREATE_TIME_PROPERTY, LocalDateTime.class)
      ;
      PropertyDescriptor updateTime = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.ticket.Ticket.UPDATE_TIME_PROPERTY, LocalDateTime.class)
      ;
      PropertyDescriptor version = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.ticket.Ticket.VERSION_PROPERTY, Long.class)
      ;
      entityDescriptor.findProperty(com.example.enterpriseerpsystem.ticket.Ticket.ID_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("oracle_sqlType", "number(11)")
      .with("javaType", "java.lang.Long")
      .with("sqlType", "BIGINT")
      .with("isId", "true")
      .with("isBaseEntityField", "true")
      .with("isBool", "false")
      .with("isNumber", "false")
      .with("isString", "false")
      .with("isDate", "false")
      .with("snowflake_sqlType", "number")
      .with("graphqlType", "Long")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.ticket.Ticket.DESCRIPTION_PROPERTY).with("isPassword", "false")
      .with("max", "100")
      .with("isVersion", "false")
      .with("javaType", "java.lang.String")
      .with("sqlType", "VARCHAR(<max>)")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("isString", "true")
      .with("isDate", "false")
      .with("graphqlType", "String")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.ticket.Ticket.CREATED_AT_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("javaType", "java.time.LocalDateTime")
      .with("sqlType", "TIMESTAMP")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("mssql_sqlType", "dateTime")
      .with("isDateTime", "true")
      .with("createFunction", "now")
      .with("isDate", "true")
      .with("isString", "false")
      .with("graphqlType", "LocalTime")
      .with("isTime", "true")
      .with("isText", "false");


      entityDescriptor.findProperty(com.example.enterpriseerpsystem.ticket.Ticket.PRIORITY_PROPERTY).with("isPassword", "false")
      .with("max", "100")
      .with("isVersion", "false")
      .with("javaType", "java.lang.String")
      .with("sqlType", "VARCHAR(<max>)")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("isString", "true")
      .with("isDate", "false")
      .with("graphqlType", "String")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.ticket.Ticket.STATUS_PROPERTY).with("isPassword", "false")
      .with("max", "100")
      .with("isVersion", "false")
      .with("javaType", "java.lang.String")
      .with("sqlType", "VARCHAR(<max>)")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("isString", "true")
      .with("isDate", "false")
      .with("graphqlType", "String")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.ticket.Ticket.SUBJECT_PROPERTY).with("isPassword", "false")
      .with("max", "100")
      .with("isVersion", "false")
      .with("javaType", "java.lang.String")
      .with("sqlType", "VARCHAR(<max>)")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("isString", "true")
      .with("isDate", "false")
      .with("graphqlType", "String")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.ticket.Ticket.CREATE_TIME_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("javaType", "java.time.LocalDateTime")
      .with("sqlType", "TIMESTAMP")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("mssql_sqlType", "dateTime")
      .with("isDateTime", "true")
      .with("createFunction", "now")
      .with("isDate", "true")
      .with("isString", "false")
      .with("graphqlType", "LocalTime")
      .with("isTime", "true")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.ticket.Ticket.UPDATE_TIME_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("updateFunction", "now")
      .with("javaType", "java.time.LocalDateTime")
      .with("sqlType", "TIMESTAMP")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("mssql_sqlType", "dateTime")
      .with("isDateTime", "true")
      .with("createFunction", "now")
      .with("isDate", "true")
      .with("isString", "false")
      .with("graphqlType", "LocalTime")
      .with("isTime", "true")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.ticket.Ticket.VERSION_PROPERTY).with("isPassword", "false")
      .with("isVersion", "true")
      .with("oracle_sqlType", "number(11)")
      .with("javaType", "java.lang.Long")
      .with("sqlType", "BIGINT")
      .with("isId", "false")
      .with("isBaseEntityField", "true")
      .with("isBool", "false")
      .with("isNumber", "false")
      .with("isString", "false")
      .with("isDate", "false")
      .with("snowflake_sqlType", "number")
      .with("graphqlType", "Long")
      .with("isTime", "false")
      .with("isText", "false");

      $factory.register(entityDescriptor);
  }
  private void registerTicketComment() {
      EntityDescriptor entityDescriptor = new EntityDescriptor();
      entityDescriptor.setType(com.example.enterpriseerpsystem.ticketcomment.TicketComment.INTERNAL_TYPE);
      entityDescriptor.setTargetType(com.example.enterpriseerpsystem.ticketcomment.TicketComment.class);
      entityDescriptor.setEntitySupplier(com.example.enterpriseerpsystem.ticketcomment.TicketComment::new);
      entityDescriptor.with("name", "Ticket Comment")
      .with("module", "CustomerSupport")
      .with("module_key", "customersupport");

      PropertyDescriptor id = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.ticketcomment.TicketComment.ID_PROPERTY, Long.class)
      ;
      PropertyDescriptor authorId = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.ticketcomment.TicketComment.AUTHOR_ID_PROPERTY, String.class)
      ;
      PropertyDescriptor commentText = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.ticketcomment.TicketComment.COMMENT_TEXT_PROPERTY, String.class)
      ;
      PropertyDescriptor createdAt = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.ticketcomment.TicketComment.CREATED_AT_PROPERTY, LocalDateTime.class)
      ;
      PropertyDescriptor ticket = 
      entityDescriptor.addObjectProperty($factory, com.example.enterpriseerpsystem.ticketcomment.TicketComment.TICKET_PROPERTY, com.example.enterpriseerpsystem.ticket.Ticket.INTERNAL_TYPE, com.example.enterpriseerpsystem.ticket.Ticket.TICKET_COMMENT_LIST_PROPERTY, com.example.enterpriseerpsystem.ticket.Ticket.class)
      ;
      PropertyDescriptor createTime = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.ticketcomment.TicketComment.CREATE_TIME_PROPERTY, LocalDateTime.class)
      ;
      PropertyDescriptor updateTime = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.ticketcomment.TicketComment.UPDATE_TIME_PROPERTY, LocalDateTime.class)
      ;
      PropertyDescriptor version = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.ticketcomment.TicketComment.VERSION_PROPERTY, Long.class)
      ;
      entityDescriptor.findProperty(com.example.enterpriseerpsystem.ticketcomment.TicketComment.ID_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("oracle_sqlType", "number(11)")
      .with("javaType", "java.lang.Long")
      .with("sqlType", "BIGINT")
      .with("isId", "true")
      .with("isBaseEntityField", "true")
      .with("isBool", "false")
      .with("isNumber", "false")
      .with("isString", "false")
      .with("isDate", "false")
      .with("snowflake_sqlType", "number")
      .with("graphqlType", "Long")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.ticketcomment.TicketComment.AUTHOR_ID_PROPERTY).with("isPassword", "false")
      .with("max", "100")
      .with("isVersion", "false")
      .with("javaType", "java.lang.String")
      .with("sqlType", "VARCHAR(<max>)")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("isString", "true")
      .with("isDate", "false")
      .with("graphqlType", "String")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.ticketcomment.TicketComment.COMMENT_TEXT_PROPERTY).with("isPassword", "false")
      .with("max", "100")
      .with("isVersion", "false")
      .with("javaType", "java.lang.String")
      .with("sqlType", "VARCHAR(<max>)")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("isString", "true")
      .with("isDate", "false")
      .with("graphqlType", "String")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.ticketcomment.TicketComment.CREATED_AT_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("javaType", "java.time.LocalDateTime")
      .with("sqlType", "TIMESTAMP")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("mssql_sqlType", "dateTime")
      .with("isDateTime", "true")
      .with("createFunction", "now")
      .with("isDate", "true")
      .with("isString", "false")
      .with("graphqlType", "LocalTime")
      .with("isTime", "true")
      .with("isText", "false");


      entityDescriptor.findProperty(com.example.enterpriseerpsystem.ticketcomment.TicketComment.CREATE_TIME_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("javaType", "java.time.LocalDateTime")
      .with("sqlType", "TIMESTAMP")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("mssql_sqlType", "dateTime")
      .with("isDateTime", "true")
      .with("createFunction", "now")
      .with("isDate", "true")
      .with("isString", "false")
      .with("graphqlType", "LocalTime")
      .with("isTime", "true")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.ticketcomment.TicketComment.UPDATE_TIME_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("updateFunction", "now")
      .with("javaType", "java.time.LocalDateTime")
      .with("sqlType", "TIMESTAMP")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("mssql_sqlType", "dateTime")
      .with("isDateTime", "true")
      .with("createFunction", "now")
      .with("isDate", "true")
      .with("isString", "false")
      .with("graphqlType", "LocalTime")
      .with("isTime", "true")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.ticketcomment.TicketComment.VERSION_PROPERTY).with("isPassword", "false")
      .with("isVersion", "true")
      .with("oracle_sqlType", "number(11)")
      .with("javaType", "java.lang.Long")
      .with("sqlType", "BIGINT")
      .with("isId", "false")
      .with("isBaseEntityField", "true")
      .with("isBool", "false")
      .with("isNumber", "false")
      .with("isString", "false")
      .with("isDate", "false")
      .with("snowflake_sqlType", "number")
      .with("graphqlType", "Long")
      .with("isTime", "false")
      .with("isText", "false");

      $factory.register(entityDescriptor);
  }
  private void registerSla() {
      EntityDescriptor entityDescriptor = new EntityDescriptor();
      entityDescriptor.setType(com.example.enterpriseerpsystem.sla.Sla.INTERNAL_TYPE);
      entityDescriptor.setTargetType(com.example.enterpriseerpsystem.sla.Sla.class);
      entityDescriptor.setEntitySupplier(com.example.enterpriseerpsystem.sla.Sla::new);
      entityDescriptor.with("name", "Sla")
      .with("module", "CustomerSupport")
      .with("module_key", "customersupport");

      PropertyDescriptor id = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.sla.Sla.ID_PROPERTY, Long.class)
      ;
      PropertyDescriptor isActive = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.sla.Sla.IS_ACTIVE_PROPERTY, Boolean.class)
      ;
      PropertyDescriptor priorityLevel = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.sla.Sla.PRIORITY_LEVEL_PROPERTY, String.class)
      ;
      PropertyDescriptor resolutionHours = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.sla.Sla.RESOLUTION_HOURS_PROPERTY, BigDecimal.class)
      ;
      PropertyDescriptor createTime = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.sla.Sla.CREATE_TIME_PROPERTY, LocalDateTime.class)
      ;
      PropertyDescriptor updateTime = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.sla.Sla.UPDATE_TIME_PROPERTY, LocalDateTime.class)
      ;
      PropertyDescriptor version = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.sla.Sla.VERSION_PROPERTY, Long.class)
      ;
      entityDescriptor.findProperty(com.example.enterpriseerpsystem.sla.Sla.ID_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("oracle_sqlType", "number(11)")
      .with("javaType", "java.lang.Long")
      .with("sqlType", "BIGINT")
      .with("isId", "true")
      .with("isBaseEntityField", "true")
      .with("isBool", "false")
      .with("isNumber", "false")
      .with("isString", "false")
      .with("isDate", "false")
      .with("snowflake_sqlType", "number")
      .with("graphqlType", "Long")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.sla.Sla.IS_ACTIVE_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("oracle_sqlType", "number(1)")
      .with("javaType", "java.lang.Boolean")
      .with("candidates", "true")
      .with("sqlType", "BOOLEAN")
      .with("isId", "false")
      .with("isBool", "true")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("mssql_sqlType", "bit")
      .with("isString", "false")
      .with("isDate", "false")
      .with("graphqlType", "Boolean")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.sla.Sla.PRIORITY_LEVEL_PROPERTY).with("isPassword", "false")
      .with("max", "100")
      .with("isVersion", "false")
      .with("javaType", "java.lang.String")
      .with("candidates", "priority_level_value")
      .with("sqlType", "VARCHAR(<max>)")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("isString", "true")
      .with("isDate", "false")
      .with("graphqlType", "String")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.sla.Sla.RESOLUTION_HOURS_PROPERTY).with("isPassword", "false")
      .with("db2_sqlType", "decimal(19,7)")
      .with("isVersion", "false")
      .with("oracle_sqlType", "number(19,7)")
      .with("javaType", "java.math.BigDecimal")
      .with("candidates", "100.00")
      .with("sqlType", "NUMERIC(19,7)")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "true")
      .with("isString", "false")
      .with("isDate", "false")
      .with("graphqlType", "BigDecimal")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.sla.Sla.CREATE_TIME_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("javaType", "java.time.LocalDateTime")
      .with("candidates", "createTime()")
      .with("sqlType", "TIMESTAMP")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("mssql_sqlType", "dateTime")
      .with("isDateTime", "true")
      .with("createFunction", "now")
      .with("isDate", "true")
      .with("isString", "false")
      .with("graphqlType", "LocalTime")
      .with("isTime", "true")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.sla.Sla.UPDATE_TIME_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("updateFunction", "now")
      .with("javaType", "java.time.LocalDateTime")
      .with("candidates", "updateTime()")
      .with("sqlType", "TIMESTAMP")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("mssql_sqlType", "dateTime")
      .with("isDateTime", "true")
      .with("createFunction", "now")
      .with("isDate", "true")
      .with("isString", "false")
      .with("graphqlType", "LocalTime")
      .with("isTime", "true")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.sla.Sla.VERSION_PROPERTY).with("isPassword", "false")
      .with("isVersion", "true")
      .with("oracle_sqlType", "number(11)")
      .with("javaType", "java.lang.Long")
      .with("sqlType", "BIGINT")
      .with("isId", "false")
      .with("isBaseEntityField", "true")
      .with("isBool", "false")
      .with("isNumber", "false")
      .with("isString", "false")
      .with("isDate", "false")
      .with("snowflake_sqlType", "number")
      .with("graphqlType", "Long")
      .with("isTime", "false")
      .with("isText", "false");

      $factory.register(entityDescriptor);
  }
  private void registerKnowledgeBase() {
      EntityDescriptor entityDescriptor = new EntityDescriptor();
      entityDescriptor.setType(com.example.enterpriseerpsystem.knowledgebase.KnowledgeBase.INTERNAL_TYPE);
      entityDescriptor.setTargetType(com.example.enterpriseerpsystem.knowledgebase.KnowledgeBase.class);
      entityDescriptor.setEntitySupplier(com.example.enterpriseerpsystem.knowledgebase.KnowledgeBase::new);
      entityDescriptor.with("name", "Knowledge Base")
      .with("module", "CustomerSupport")
      .with("module_key", "customersupport");

      PropertyDescriptor id = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.knowledgebase.KnowledgeBase.ID_PROPERTY, Long.class)
      ;
      PropertyDescriptor category = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.knowledgebase.KnowledgeBase.CATEGORY_PROPERTY, String.class)
      ;
      PropertyDescriptor content = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.knowledgebase.KnowledgeBase.CONTENT_PROPERTY, String.class)
      ;
      PropertyDescriptor title = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.knowledgebase.KnowledgeBase.TITLE_PROPERTY, String.class)
      ;
      PropertyDescriptor views = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.knowledgebase.KnowledgeBase.VIEWS_PROPERTY, BigDecimal.class)
      ;
      PropertyDescriptor createTime = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.knowledgebase.KnowledgeBase.CREATE_TIME_PROPERTY, LocalDateTime.class)
      ;
      PropertyDescriptor updateTime = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.knowledgebase.KnowledgeBase.UPDATE_TIME_PROPERTY, LocalDateTime.class)
      ;
      PropertyDescriptor version = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.knowledgebase.KnowledgeBase.VERSION_PROPERTY, Long.class)
      ;
      entityDescriptor.findProperty(com.example.enterpriseerpsystem.knowledgebase.KnowledgeBase.ID_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("oracle_sqlType", "number(11)")
      .with("javaType", "java.lang.Long")
      .with("sqlType", "BIGINT")
      .with("isId", "true")
      .with("isBaseEntityField", "true")
      .with("isBool", "false")
      .with("isNumber", "false")
      .with("isString", "false")
      .with("isDate", "false")
      .with("snowflake_sqlType", "number")
      .with("graphqlType", "Long")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.knowledgebase.KnowledgeBase.CATEGORY_PROPERTY).with("isPassword", "false")
      .with("max", "100")
      .with("isVersion", "false")
      .with("javaType", "java.lang.String")
      .with("candidates", "category_value")
      .with("sqlType", "VARCHAR(<max>)")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("isString", "true")
      .with("isDate", "false")
      .with("graphqlType", "String")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.knowledgebase.KnowledgeBase.CONTENT_PROPERTY).with("isPassword", "false")
      .with("max", "100")
      .with("isVersion", "false")
      .with("javaType", "java.lang.String")
      .with("candidates", "content_value")
      .with("sqlType", "VARCHAR(<max>)")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("isString", "true")
      .with("isDate", "false")
      .with("graphqlType", "String")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.knowledgebase.KnowledgeBase.TITLE_PROPERTY).with("isPassword", "false")
      .with("max", "100")
      .with("isVersion", "false")
      .with("javaType", "java.lang.String")
      .with("candidates", "title_value")
      .with("sqlType", "VARCHAR(<max>)")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("isString", "true")
      .with("isDate", "false")
      .with("graphqlType", "String")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.knowledgebase.KnowledgeBase.VIEWS_PROPERTY).with("isPassword", "false")
      .with("db2_sqlType", "decimal(19,7)")
      .with("isVersion", "false")
      .with("oracle_sqlType", "number(19,7)")
      .with("javaType", "java.math.BigDecimal")
      .with("candidates", "100.00")
      .with("sqlType", "NUMERIC(19,7)")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "true")
      .with("isString", "false")
      .with("isDate", "false")
      .with("graphqlType", "BigDecimal")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.knowledgebase.KnowledgeBase.CREATE_TIME_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("javaType", "java.time.LocalDateTime")
      .with("candidates", "createTime()")
      .with("sqlType", "TIMESTAMP")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("mssql_sqlType", "dateTime")
      .with("isDateTime", "true")
      .with("createFunction", "now")
      .with("isDate", "true")
      .with("isString", "false")
      .with("graphqlType", "LocalTime")
      .with("isTime", "true")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.knowledgebase.KnowledgeBase.UPDATE_TIME_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("updateFunction", "now")
      .with("javaType", "java.time.LocalDateTime")
      .with("candidates", "updateTime()")
      .with("sqlType", "TIMESTAMP")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("mssql_sqlType", "dateTime")
      .with("isDateTime", "true")
      .with("createFunction", "now")
      .with("isDate", "true")
      .with("isString", "false")
      .with("graphqlType", "LocalTime")
      .with("isTime", "true")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.knowledgebase.KnowledgeBase.VERSION_PROPERTY).with("isPassword", "false")
      .with("isVersion", "true")
      .with("oracle_sqlType", "number(11)")
      .with("javaType", "java.lang.Long")
      .with("sqlType", "BIGINT")
      .with("isId", "false")
      .with("isBaseEntityField", "true")
      .with("isBool", "false")
      .with("isNumber", "false")
      .with("isString", "false")
      .with("isDate", "false")
      .with("snowflake_sqlType", "number")
      .with("graphqlType", "Long")
      .with("isTime", "false")
      .with("isText", "false");

      $factory.register(entityDescriptor);
  }
  private void registerSupportAgent() {
      EntityDescriptor entityDescriptor = new EntityDescriptor();
      entityDescriptor.setType(com.example.enterpriseerpsystem.supportagent.SupportAgent.INTERNAL_TYPE);
      entityDescriptor.setTargetType(com.example.enterpriseerpsystem.supportagent.SupportAgent.class);
      entityDescriptor.setEntitySupplier(com.example.enterpriseerpsystem.supportagent.SupportAgent::new);
      entityDescriptor.with("name", "Support Agent")
      .with("module", "CustomerSupport")
      .with("module_key", "customersupport");

      PropertyDescriptor id = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.supportagent.SupportAgent.ID_PROPERTY, Long.class)
      ;
      PropertyDescriptor activeTickets = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.supportagent.SupportAgent.ACTIVE_TICKETS_PROPERTY, BigDecimal.class)
      ;
      PropertyDescriptor employee = 
      entityDescriptor.addObjectProperty($factory, com.example.enterpriseerpsystem.supportagent.SupportAgent.EMPLOYEE_PROPERTY, com.example.enterpriseerpsystem.employee.Employee.INTERNAL_TYPE, com.example.enterpriseerpsystem.employee.Employee.SUPPORT_AGENT_LIST_PROPERTY, com.example.enterpriseerpsystem.employee.Employee.class)
      ;
      PropertyDescriptor specialty = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.supportagent.SupportAgent.SPECIALTY_PROPERTY, String.class)
      ;
      PropertyDescriptor createTime = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.supportagent.SupportAgent.CREATE_TIME_PROPERTY, LocalDateTime.class)
      ;
      PropertyDescriptor updateTime = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.supportagent.SupportAgent.UPDATE_TIME_PROPERTY, LocalDateTime.class)
      ;
      PropertyDescriptor version = 
      entityDescriptor.addSimpleProperty(com.example.enterpriseerpsystem.supportagent.SupportAgent.VERSION_PROPERTY, Long.class)
      ;
      entityDescriptor.findProperty(com.example.enterpriseerpsystem.supportagent.SupportAgent.ID_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("oracle_sqlType", "number(11)")
      .with("javaType", "java.lang.Long")
      .with("sqlType", "BIGINT")
      .with("isId", "true")
      .with("isBaseEntityField", "true")
      .with("isBool", "false")
      .with("isNumber", "false")
      .with("isString", "false")
      .with("isDate", "false")
      .with("snowflake_sqlType", "number")
      .with("graphqlType", "Long")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.supportagent.SupportAgent.ACTIVE_TICKETS_PROPERTY).with("isPassword", "false")
      .with("db2_sqlType", "decimal(19,7)")
      .with("isVersion", "false")
      .with("oracle_sqlType", "number(19,7)")
      .with("javaType", "java.math.BigDecimal")
      .with("sqlType", "NUMERIC(19,7)")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "true")
      .with("isString", "false")
      .with("isDate", "false")
      .with("graphqlType", "BigDecimal")
      .with("isTime", "false")
      .with("isText", "false");


      entityDescriptor.findProperty(com.example.enterpriseerpsystem.supportagent.SupportAgent.SPECIALTY_PROPERTY).with("isPassword", "false")
      .with("max", "100")
      .with("isVersion", "false")
      .with("javaType", "java.lang.String")
      .with("sqlType", "VARCHAR(<max>)")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("isString", "true")
      .with("isDate", "false")
      .with("graphqlType", "String")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.supportagent.SupportAgent.CREATE_TIME_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("javaType", "java.time.LocalDateTime")
      .with("sqlType", "TIMESTAMP")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("mssql_sqlType", "dateTime")
      .with("isDateTime", "true")
      .with("createFunction", "now")
      .with("isDate", "true")
      .with("isString", "false")
      .with("graphqlType", "LocalTime")
      .with("isTime", "true")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.supportagent.SupportAgent.UPDATE_TIME_PROPERTY).with("isPassword", "false")
      .with("isVersion", "false")
      .with("updateFunction", "now")
      .with("javaType", "java.time.LocalDateTime")
      .with("sqlType", "TIMESTAMP")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "false")
      .with("mssql_sqlType", "dateTime")
      .with("isDateTime", "true")
      .with("createFunction", "now")
      .with("isDate", "true")
      .with("isString", "false")
      .with("graphqlType", "LocalTime")
      .with("isTime", "true")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.enterpriseerpsystem.supportagent.SupportAgent.VERSION_PROPERTY).with("isPassword", "false")
      .with("isVersion", "true")
      .with("oracle_sqlType", "number(11)")
      .with("javaType", "java.lang.Long")
      .with("sqlType", "BIGINT")
      .with("isId", "false")
      .with("isBaseEntityField", "true")
      .with("isBool", "false")
      .with("isNumber", "false")
      .with("isString", "false")
      .with("isDate", "false")
      .with("snowflake_sqlType", "number")
      .with("graphqlType", "Long")
      .with("isTime", "false")
      .with("isText", "false");

      $factory.register(entityDescriptor);
  }
}