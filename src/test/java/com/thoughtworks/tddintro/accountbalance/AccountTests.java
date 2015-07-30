package com.thoughtworks.tddintro.accountbalance;

import org.junit.Ignore;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class AccountTests {
    @Test
    public void shouldIncreaseMyBalanceWhenIDepositMoney(){
        Account account = new Account(0.0);
        account.deposit(100.0);
        assertThat(account.getBalance(), is(100.0));
    }

    @Test
    public void shouldDecreaseMyBalanceWhenIWithdrawMoney(){
        Account account = new Account(100.0);
        account.withdraw(55.0);
        assertThat(account.getBalance(), is(45.0));
    }

    @Test
    public void shouldNotDecreaseMyBalanceWhenIWithdrawMoneyAndDoNotHaveEnoughToCoverTheWithdrawal(){
        Account account = new Account(5.0);
        account.withdraw(7.0);
        assertThat(account.getBalance(), is(5.0));
    }
}
