package org.university.lab5;

import lombok.Getter;

public class BankAccount {
    @Getter
    private int accountNumber;
    private String accountName;
    @Getter
    private double balance;

    public BankAccount(int accountNumber, String accountName, double initialDeposit){
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.balance = initialDeposit;
    }
    public void deposit(double amount) {
        if (amount < 0) {
            throw new NegativeAmountException("Депозит не може бути від'ємним");
        }
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount < 0) {
            throw new NegativeAmountException("Зняття не може бути від'ємним");
        }
        if (amount > balance) {
            throw new InsufficientFundsException("Недостатньо коштів на рахунку");
        }
        balance -= amount;
    }
    public String getAccountSummary(){
        return "Баланс на рахунку: " + accountNumber + " = " + balance;
    }

}
