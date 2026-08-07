
package com.example.paymentservice;

import com.example.paymentservice.useraccount.UserAccount;

public interface Constants  {
  public static final long USER_ACCOUNT_ID = 1l;
  public static final UserAccount USER_ACCOUNT = UserAccount.refer(USER_ACCOUNT_ID);
}