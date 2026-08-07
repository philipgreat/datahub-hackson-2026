
package com.example.paymentservice;

import com.example.paymentservice.paymenttransaction.PaymentTransaction;
import com.example.paymentservice.paymenttransaction.PaymentTransactionExpression;
import com.example.paymentservice.useraccount.UserAccount;
import com.example.paymentservice.useraccount.UserAccountExpression;
import io.teaql.core.value.ValueExpression;

public class E  {
  public static UserAccountExpression<UserAccount, UserAccount, UserAccount> userAccount(UserAccount userAccount){
      return new UserAccountExpression(new ValueExpression(userAccount));
  }
  public static PaymentTransactionExpression<PaymentTransaction, PaymentTransaction, PaymentTransaction> paymentTransaction(PaymentTransaction paymentTransaction){
      return new PaymentTransactionExpression(new ValueExpression(paymentTransaction));
  }
}