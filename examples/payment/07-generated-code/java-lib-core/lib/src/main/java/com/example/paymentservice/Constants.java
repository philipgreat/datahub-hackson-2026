
package com.example.paymentservice;

import com.example.paymentservice.paymenttransaction.PaymentTransaction;
import com.example.paymentservice.useraccount.UserAccount;

public interface Constants  {
  public static final long USER_ACCOUNT_ID = 1l;
  public static final UserAccount USER_ACCOUNT = UserAccount.refer(USER_ACCOUNT_ID);
  public static final long PAYMENT_TRANSACTION_ID = 1l;
  public static final PaymentTransaction PAYMENT_TRANSACTION = PaymentTransaction.refer(PAYMENT_TRANSACTION_ID);
}