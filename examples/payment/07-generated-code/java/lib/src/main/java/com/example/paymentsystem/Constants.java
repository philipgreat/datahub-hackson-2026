
package com.example.paymentsystem;

import com.example.paymentsystem.paymenttransaction.PaymentTransaction;

public interface Constants  {
  public static final long PAYMENT_TRANSACTION_ID = 1l;
  public static final PaymentTransaction PAYMENT_TRANSACTION = PaymentTransaction.refer(PAYMENT_TRANSACTION_ID);
}