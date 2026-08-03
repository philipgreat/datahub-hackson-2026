
package com.example.paymentservice;

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
    registerUserAccount();
    registerPaymentAccount();
    registerPaymentMethod();
    registerPaymentTransaction();
  }
  private void registerUserAccount() {
      EntityDescriptor entityDescriptor = new EntityDescriptor();
      entityDescriptor.setType(com.example.paymentservice.useraccount.UserAccount.INTERNAL_TYPE);
      entityDescriptor.setTargetType(com.example.paymentservice.useraccount.UserAccount.class);
      entityDescriptor.setEntitySupplier(com.example.paymentservice.useraccount.UserAccount::new);
      entityDescriptor.with("name", "Customer Account")
      .with("module", "Core")
      .with("module_key", "core")
      .with("audit_mask_fields", "user_name");

      PropertyDescriptor id = 
      entityDescriptor.addSimpleProperty(com.example.paymentservice.useraccount.UserAccount.ID_PROPERTY, Long.class)
      ;
      PropertyDescriptor userId = 
      entityDescriptor.addSimpleProperty(com.example.paymentservice.useraccount.UserAccount.USER_ID_PROPERTY, String.class)
      ;
      PropertyDescriptor userName = 
      entityDescriptor.addSimpleProperty(com.example.paymentservice.useraccount.UserAccount.USER_NAME_PROPERTY, String.class)
      ;
      PropertyDescriptor createTime = 
      entityDescriptor.addSimpleProperty(com.example.paymentservice.useraccount.UserAccount.CREATE_TIME_PROPERTY, LocalDateTime.class)
      ;
      PropertyDescriptor updateTime = 
      entityDescriptor.addSimpleProperty(com.example.paymentservice.useraccount.UserAccount.UPDATE_TIME_PROPERTY, LocalDateTime.class)
      ;
      PropertyDescriptor version = 
      entityDescriptor.addSimpleProperty(com.example.paymentservice.useraccount.UserAccount.VERSION_PROPERTY, Long.class)
      ;
      entityDescriptor.findProperty(com.example.paymentservice.useraccount.UserAccount.ID_PROPERTY).with("isPassword", "false")
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

      entityDescriptor.findProperty(com.example.paymentservice.useraccount.UserAccount.USER_ID_PROPERTY).with("isPassword", "false")
      .with("max", "100")
      .with("isVersion", "false")
      .with("javaType", "java.lang.String")
      .with("candidates", "U-987654321")
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

      entityDescriptor.findProperty(com.example.paymentservice.useraccount.UserAccount.USER_NAME_PROPERTY).with("isPassword", "false")
      .with("max", "100")
      .with("isVersion", "false")
      .with("javaType", "java.lang.String")
      .with("candidates", "boolean()")
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

      entityDescriptor.findProperty(com.example.paymentservice.useraccount.UserAccount.CREATE_TIME_PROPERTY).with("isPassword", "false")
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

      entityDescriptor.findProperty(com.example.paymentservice.useraccount.UserAccount.UPDATE_TIME_PROPERTY).with("isPassword", "false")
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

      entityDescriptor.findProperty(com.example.paymentservice.useraccount.UserAccount.VERSION_PROPERTY).with("isPassword", "false")
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
  private void registerPaymentAccount() {
      EntityDescriptor entityDescriptor = new EntityDescriptor();
      entityDescriptor.setType(com.example.paymentservice.paymentaccount.PaymentAccount.INTERNAL_TYPE);
      entityDescriptor.setTargetType(com.example.paymentservice.paymentaccount.PaymentAccount.class);
      entityDescriptor.setEntitySupplier(com.example.paymentservice.paymentaccount.PaymentAccount::new);
      entityDescriptor.with("name", "Payment Account")
      .with("module", "Core")
      .with("module_key", "core")
      .with("audit_mask_fields", "account_number,account_name");

      PropertyDescriptor id = 
      entityDescriptor.addSimpleProperty(com.example.paymentservice.paymentaccount.PaymentAccount.ID_PROPERTY, Long.class)
      ;
      PropertyDescriptor userAccount = 
      entityDescriptor.addObjectProperty($factory, com.example.paymentservice.paymentaccount.PaymentAccount.USER_ACCOUNT_PROPERTY, com.example.paymentservice.useraccount.UserAccount.INTERNAL_TYPE, com.example.paymentservice.useraccount.UserAccount.PAYMENT_ACCOUNT_LIST_PROPERTY, com.example.paymentservice.useraccount.UserAccount.class)
      ;
      PropertyDescriptor accountName = 
      entityDescriptor.addSimpleProperty(com.example.paymentservice.paymentaccount.PaymentAccount.ACCOUNT_NAME_PROPERTY, String.class)
      ;
      PropertyDescriptor accountNumber = 
      entityDescriptor.addSimpleProperty(com.example.paymentservice.paymentaccount.PaymentAccount.ACCOUNT_NUMBER_PROPERTY, Integer.class)
      ;
      PropertyDescriptor currencyCode = 
      entityDescriptor.addSimpleProperty(com.example.paymentservice.paymentaccount.PaymentAccount.CURRENCY_CODE_PROPERTY, String.class)
      ;
      PropertyDescriptor createTime = 
      entityDescriptor.addSimpleProperty(com.example.paymentservice.paymentaccount.PaymentAccount.CREATE_TIME_PROPERTY, LocalDateTime.class)
      ;
      PropertyDescriptor updateTime = 
      entityDescriptor.addSimpleProperty(com.example.paymentservice.paymentaccount.PaymentAccount.UPDATE_TIME_PROPERTY, LocalDateTime.class)
      ;
      PropertyDescriptor version = 
      entityDescriptor.addSimpleProperty(com.example.paymentservice.paymentaccount.PaymentAccount.VERSION_PROPERTY, Long.class)
      ;
      entityDescriptor.findProperty(com.example.paymentservice.paymentaccount.PaymentAccount.ID_PROPERTY).with("isPassword", "false")
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


      entityDescriptor.findProperty(com.example.paymentservice.paymentaccount.PaymentAccount.ACCOUNT_NAME_PROPERTY).with("isPassword", "false")
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

      entityDescriptor.findProperty(com.example.paymentservice.paymentaccount.PaymentAccount.ACCOUNT_NUMBER_PROPERTY).with("isPassword", "false")
      .with("db2_sqlType", "decimal(19,7)")
      .with("isVersion", "false")
      .with("oracle_sqlType", "number(19,7)")
      .with("javaType", "java.lang.Integer")
      .with("sqlType", "INTEGER")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "true")
      .with("isInt", "true")
      .with("isString", "false")
      .with("isDate", "false")
      .with("graphqlType", "Int")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.paymentservice.paymentaccount.PaymentAccount.CURRENCY_CODE_PROPERTY).with("isPassword", "false")
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

      entityDescriptor.findProperty(com.example.paymentservice.paymentaccount.PaymentAccount.CREATE_TIME_PROPERTY).with("isPassword", "false")
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

      entityDescriptor.findProperty(com.example.paymentservice.paymentaccount.PaymentAccount.UPDATE_TIME_PROPERTY).with("isPassword", "false")
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

      entityDescriptor.findProperty(com.example.paymentservice.paymentaccount.PaymentAccount.VERSION_PROPERTY).with("isPassword", "false")
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
  private void registerPaymentMethod() {
      EntityDescriptor entityDescriptor = new EntityDescriptor();
      entityDescriptor.setType(com.example.paymentservice.paymentmethod.PaymentMethod.INTERNAL_TYPE);
      entityDescriptor.setTargetType(com.example.paymentservice.paymentmethod.PaymentMethod.class);
      entityDescriptor.setEntitySupplier(com.example.paymentservice.paymentmethod.PaymentMethod::new);
      entityDescriptor.with("name", "Payment Method")
      .with("module", "Core")
      .with("module_key", "core")
      .with("audit_mask_fields", "payment_account,last_four_digits");

      PropertyDescriptor id = 
      entityDescriptor.addSimpleProperty(com.example.paymentservice.paymentmethod.PaymentMethod.ID_PROPERTY, Long.class)
      ;
      PropertyDescriptor paymentAccount = 
      entityDescriptor.addObjectProperty($factory, com.example.paymentservice.paymentmethod.PaymentMethod.PAYMENT_ACCOUNT_PROPERTY, com.example.paymentservice.paymentaccount.PaymentAccount.INTERNAL_TYPE, com.example.paymentservice.paymentaccount.PaymentAccount.PAYMENT_METHOD_LIST_PROPERTY, com.example.paymentservice.paymentaccount.PaymentAccount.class)
      ;
      PropertyDescriptor methodType = 
      entityDescriptor.addSimpleProperty(com.example.paymentservice.paymentmethod.PaymentMethod.METHOD_TYPE_PROPERTY, String.class)
      ;
      PropertyDescriptor lastFourDigits = 
      entityDescriptor.addSimpleProperty(com.example.paymentservice.paymentmethod.PaymentMethod.LAST_FOUR_DIGITS_PROPERTY, Integer.class)
      ;
      PropertyDescriptor createTime = 
      entityDescriptor.addSimpleProperty(com.example.paymentservice.paymentmethod.PaymentMethod.CREATE_TIME_PROPERTY, LocalDateTime.class)
      ;
      PropertyDescriptor updateTime = 
      entityDescriptor.addSimpleProperty(com.example.paymentservice.paymentmethod.PaymentMethod.UPDATE_TIME_PROPERTY, LocalDateTime.class)
      ;
      PropertyDescriptor version = 
      entityDescriptor.addSimpleProperty(com.example.paymentservice.paymentmethod.PaymentMethod.VERSION_PROPERTY, Long.class)
      ;
      entityDescriptor.findProperty(com.example.paymentservice.paymentmethod.PaymentMethod.ID_PROPERTY).with("isPassword", "false")
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


      entityDescriptor.findProperty(com.example.paymentservice.paymentmethod.PaymentMethod.METHOD_TYPE_PROPERTY).with("isPassword", "false")
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

      entityDescriptor.findProperty(com.example.paymentservice.paymentmethod.PaymentMethod.LAST_FOUR_DIGITS_PROPERTY).with("isPassword", "false")
      .with("db2_sqlType", "decimal(19,7)")
      .with("isVersion", "false")
      .with("oracle_sqlType", "number(19,7)")
      .with("javaType", "java.lang.Integer")
      .with("sqlType", "INTEGER")
      .with("isId", "false")
      .with("isBool", "false")
      .with("isBaseEntityField", "false")
      .with("isNumber", "true")
      .with("isInt", "true")
      .with("isString", "false")
      .with("isDate", "false")
      .with("graphqlType", "Int")
      .with("isTime", "false")
      .with("isText", "false");

      entityDescriptor.findProperty(com.example.paymentservice.paymentmethod.PaymentMethod.CREATE_TIME_PROPERTY).with("isPassword", "false")
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

      entityDescriptor.findProperty(com.example.paymentservice.paymentmethod.PaymentMethod.UPDATE_TIME_PROPERTY).with("isPassword", "false")
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

      entityDescriptor.findProperty(com.example.paymentservice.paymentmethod.PaymentMethod.VERSION_PROPERTY).with("isPassword", "false")
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
  private void registerPaymentTransaction() {
      EntityDescriptor entityDescriptor = new EntityDescriptor();
      entityDescriptor.setType(com.example.paymentservice.paymenttransaction.PaymentTransaction.INTERNAL_TYPE);
      entityDescriptor.setTargetType(com.example.paymentservice.paymenttransaction.PaymentTransaction.class);
      entityDescriptor.setEntitySupplier(com.example.paymentservice.paymenttransaction.PaymentTransaction::new);
      entityDescriptor.with("name", "Payment Transaction")
      .with("module", "Core")
      .with("module_key", "core")
      .with("audit_mask_fields", "payment_account");

      PropertyDescriptor id = 
      entityDescriptor.addSimpleProperty(com.example.paymentservice.paymenttransaction.PaymentTransaction.ID_PROPERTY, Long.class)
      ;
      PropertyDescriptor paymentAccount = 
      entityDescriptor.addObjectProperty($factory, com.example.paymentservice.paymenttransaction.PaymentTransaction.PAYMENT_ACCOUNT_PROPERTY, com.example.paymentservice.paymentaccount.PaymentAccount.INTERNAL_TYPE, com.example.paymentservice.paymentaccount.PaymentAccount.PAYMENT_TRANSACTION_LIST_PROPERTY, com.example.paymentservice.paymentaccount.PaymentAccount.class)
      ;
      PropertyDescriptor currencyCode = 
      entityDescriptor.addSimpleProperty(com.example.paymentservice.paymenttransaction.PaymentTransaction.CURRENCY_CODE_PROPERTY, String.class)
      ;
      PropertyDescriptor paymentMethod = 
      entityDescriptor.addObjectProperty($factory, com.example.paymentservice.paymenttransaction.PaymentTransaction.PAYMENT_METHOD_PROPERTY, com.example.paymentservice.paymentmethod.PaymentMethod.INTERNAL_TYPE, com.example.paymentservice.paymentmethod.PaymentMethod.PAYMENT_TRANSACTION_LIST_PROPERTY, com.example.paymentservice.paymentmethod.PaymentMethod.class)
      ;
      PropertyDescriptor transactionAmount = 
      entityDescriptor.addSimpleProperty(com.example.paymentservice.paymenttransaction.PaymentTransaction.TRANSACTION_AMOUNT_PROPERTY, BigDecimal.class)
      ;
      PropertyDescriptor createTime = 
      entityDescriptor.addSimpleProperty(com.example.paymentservice.paymenttransaction.PaymentTransaction.CREATE_TIME_PROPERTY, LocalDateTime.class)
      ;
      PropertyDescriptor updateTime = 
      entityDescriptor.addSimpleProperty(com.example.paymentservice.paymenttransaction.PaymentTransaction.UPDATE_TIME_PROPERTY, LocalDateTime.class)
      ;
      PropertyDescriptor version = 
      entityDescriptor.addSimpleProperty(com.example.paymentservice.paymenttransaction.PaymentTransaction.VERSION_PROPERTY, Long.class)
      ;
      entityDescriptor.findProperty(com.example.paymentservice.paymenttransaction.PaymentTransaction.ID_PROPERTY).with("isPassword", "false")
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


      entityDescriptor.findProperty(com.example.paymentservice.paymenttransaction.PaymentTransaction.CURRENCY_CODE_PROPERTY).with("isPassword", "false")
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


      entityDescriptor.findProperty(com.example.paymentservice.paymenttransaction.PaymentTransaction.TRANSACTION_AMOUNT_PROPERTY).with("isPassword", "false")
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

      entityDescriptor.findProperty(com.example.paymentservice.paymenttransaction.PaymentTransaction.CREATE_TIME_PROPERTY).with("isPassword", "false")
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

      entityDescriptor.findProperty(com.example.paymentservice.paymenttransaction.PaymentTransaction.UPDATE_TIME_PROPERTY).with("isPassword", "false")
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

      entityDescriptor.findProperty(com.example.paymentservice.paymenttransaction.PaymentTransaction.VERSION_PROPERTY).with("isPassword", "false")
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