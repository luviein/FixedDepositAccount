package com.yenleng.fd;

import java.util.Date;
import java.util.List;

public class FixedDepositAccount {
    private final String name;
    private String accountNumber;
    private final float balance;
    private float interest = 3.0f;
    private int duration = 6;
    private boolean isClosed;
    //private Date accountStartDate;
    //private Date accountEndDate;
    private List<String> transactions;

    public void setInterest(float interest) {
        if (interest != this.interest) {
            throw new IllegalArgumentException("You cannot change the interest anymore.");

        } else {
            this.interest = interest;
        }
    }

    public void setDuration(int duration) {
        if (duration != this.duration) {
            throw new IllegalArgumentException("You cannot change the duration anymore.");

        } else {
            this.duration = duration;
        }
    }

    // Constructors
    public FixedDepositAccount(String name, Float balance) {
        this.name = name;
        this.balance = 0.0f;
    }

    public FixedDepositAccount(String name, Float balance, Float interest) {
        this.name = name;
        this.balance = balance;
        this.interest = interest;
    }

    public FixedDepositAccount(String name, Float balance, Float interest, Integer duration) {
        this.name = name;
        this.balance = balance;
        this.interest = interest;
        this.duration = duration;

    }

    // Methods same as Bank Account

    public void deposit(float amount) {

        if (isClosed) {
            throw new IllegalArgumentException(
                    "Account closed/inactive. You cannot make a deposit to a closed/inactive account.");
        }

        if (amount < 0) {
            throw new IllegalArgumentException("You cannot make a negative amount deposit.");
        } else {

            Date dt = new Date();
            transactions.add("Deposit " + amount + " to account " + accountNumber + " on " + dt.toString());
        }

    }

    public void withdraw(float amount) {

        if (isClosed) {
            throw new IllegalArgumentException(
                    "Account closed/inactive. You cannot make a withdrawal to a closed/inactive account.");
        }

        if (amount > balance) {
            throw new IllegalArgumentException("You cannot withdraw a negative amount.");
        } else {

            Date dt = new Date();
            transactions.add("Withdraw " + amount + " to account " + accountNumber + " on " + dt.toString());
        }

    }

    public void getBalance() {
        float finalBalance = balance;
        System.out.println(name + ", your final balance is: " + (finalBalance += interest));
    }

    public static void main(String[] args) {
        FixedDepositAccount myFixedDeposit = new FixedDepositAccount("Yenleng", 100000.0f, 5.0f, 7);
        // myFixedDeposit.setInterest(9.0f); (THROWS ERROR)
        // myFixedDeposit.setDuration(10); (THROWS ERROR)
        myFixedDeposit.getBalance();

    }
}
