
package com.example.paymentservice;

import io.teaql.core.criteria.Operator;

public class Q  {
  public static com.example.paymentservice.useraccount.UserAccountRequest<com.example.paymentservice.useraccount.UserAccount> userAccounts(){
      return new com.example.paymentservice.useraccount.UserAccountRequest(com.example.paymentservice.useraccount.UserAccount.class).selectSelf().withVersion(Operator.GREATER_THAN, 0l);
  }
  public static com.example.paymentservice.useraccount.UserAccountRequest<com.example.paymentservice.useraccount.UserAccount> userAccountsWithMinimalFields(){
      return new com.example.paymentservice.useraccount.UserAccountRequest(com.example.paymentservice.useraccount.UserAccount.class).withVersion(Operator.GREATER_THAN, 0l);
  }


  public static com.example.paymentservice.paymentaccount.PaymentAccountRequest<com.example.paymentservice.paymentaccount.PaymentAccount> paymentAccounts(){
      return new com.example.paymentservice.paymentaccount.PaymentAccountRequest(com.example.paymentservice.paymentaccount.PaymentAccount.class).selectSelf().withVersion(Operator.GREATER_THAN, 0l);
  }
  public static com.example.paymentservice.paymentaccount.PaymentAccountRequest<com.example.paymentservice.paymentaccount.PaymentAccount> paymentAccountsWithMinimalFields(){
      return new com.example.paymentservice.paymentaccount.PaymentAccountRequest(com.example.paymentservice.paymentaccount.PaymentAccount.class).withVersion(Operator.GREATER_THAN, 0l);
  }


  public static com.example.paymentservice.paymentmethod.PaymentMethodRequest<com.example.paymentservice.paymentmethod.PaymentMethod> paymentMethods(){
      return new com.example.paymentservice.paymentmethod.PaymentMethodRequest(com.example.paymentservice.paymentmethod.PaymentMethod.class).selectSelf().withVersion(Operator.GREATER_THAN, 0l);
  }
  public static com.example.paymentservice.paymentmethod.PaymentMethodRequest<com.example.paymentservice.paymentmethod.PaymentMethod> paymentMethodsWithMinimalFields(){
      return new com.example.paymentservice.paymentmethod.PaymentMethodRequest(com.example.paymentservice.paymentmethod.PaymentMethod.class).withVersion(Operator.GREATER_THAN, 0l);
  }


  public static com.example.paymentservice.paymenttransaction.PaymentTransactionRequest<com.example.paymentservice.paymenttransaction.PaymentTransaction> paymentTransactions(){
      return new com.example.paymentservice.paymenttransaction.PaymentTransactionRequest(com.example.paymentservice.paymenttransaction.PaymentTransaction.class).selectSelf().withVersion(Operator.GREATER_THAN, 0l);
  }
  public static com.example.paymentservice.paymenttransaction.PaymentTransactionRequest<com.example.paymentservice.paymenttransaction.PaymentTransaction> paymentTransactionsWithMinimalFields(){
      return new com.example.paymentservice.paymenttransaction.PaymentTransactionRequest(com.example.paymentservice.paymenttransaction.PaymentTransaction.class).withVersion(Operator.GREATER_THAN, 0l);
  }


}