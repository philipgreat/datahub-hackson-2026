
package com.example.paymentsystem;

import com.example.paymentsystem.paymenttransaction.PaymentTransaction;
import com.example.paymentsystem.paymenttransaction.PaymentTransactionExpression;
import io.teaql.core.value.ValueExpression;

public class E  {
  public static PaymentTransactionExpression<PaymentTransaction, PaymentTransaction, PaymentTransaction> paymentTransaction(PaymentTransaction paymentTransaction){
      return new PaymentTransactionExpression(new ValueExpression(paymentTransaction));
  }
}