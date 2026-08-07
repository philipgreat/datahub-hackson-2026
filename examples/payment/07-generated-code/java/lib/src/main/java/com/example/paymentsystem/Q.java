
package com.example.paymentsystem;

import io.teaql.core.criteria.Operator;

public class Q  {
  public static com.example.paymentsystem.paymenttransaction.PaymentTransactionRequest<com.example.paymentsystem.paymenttransaction.PaymentTransaction> paymentTransactions(){
      return new com.example.paymentsystem.paymenttransaction.PaymentTransactionRequest(com.example.paymentsystem.paymenttransaction.PaymentTransaction.class).selectSelf().withVersion(Operator.GREATER_THAN, 0l);
  }
  public static com.example.paymentsystem.paymenttransaction.PaymentTransactionRequest<com.example.paymentsystem.paymenttransaction.PaymentTransaction> paymentTransactionsWithMinimalFields(){
      return new com.example.paymentsystem.paymenttransaction.PaymentTransactionRequest(com.example.paymentsystem.paymenttransaction.PaymentTransaction.class).withVersion(Operator.GREATER_THAN, 0l);
  }


}