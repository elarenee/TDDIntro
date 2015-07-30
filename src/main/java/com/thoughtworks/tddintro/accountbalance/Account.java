package com.thoughtworks.tddintro.accountbalance;

import java.io.PrintStream;

/**
 * Created by lauren on 7/29/15.
 */
public class Account {
    private double balance;

    public Account(double initialBalance) {
        balance = initialBalance;
    }
    public void deposit(double amount) {
        balance += amount;
    }
    public void withdraw(double amount) {
        if ((balance-amount) >= 0)
            balance -= amount;
    }
    public double getBalance() {
        return balance;
    }
}
