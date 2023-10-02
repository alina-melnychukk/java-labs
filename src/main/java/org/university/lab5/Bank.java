package org.university.lab5;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private List<BankAccount> accounts;

    public Bank(){
        accounts = new ArrayList<>();
    }
    public void createAccount(String accountName, double initialDeposit){
        int accountNumber = accounts.size() + 1;
        BankAccount account = new BankAccount(accountNumber, accountName, initialDeposit);
        accounts.add(account);
    }
    public BankAccount findAccount(int accountNumber){
        for (BankAccount account : accounts){
            if (account.getAccountNumber() == accountNumber){
                return account;
            }
        }
        throw new AccountNotFoundException("Рахунок #" + accountNumber + " не знайдено");
    }
    public void transferMoney(int fromAccountNumber, int toAccountNumber, double amount){
        BankAccount fromAccount = findAccount(fromAccountNumber);
        BankAccount toAccount = findAccount(toAccountNumber);

        fromAccount.withdraw(amount);
        toAccount.deposit(amount);
    }
}
