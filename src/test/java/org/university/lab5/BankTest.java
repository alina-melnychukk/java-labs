package org.university.lab5;

public class BankTest {
    public static void main(String[] args){
        Bank bank = new Bank();

        bank.createAccount("Client1", 1000);
        bank.createAccount("Client2", 500);

        try {
            bank.transferMoney(1,2,600);
        } catch (InsufficientFundsException e){
            System.out.println("Помилка: " + e.getMessage());
        }

        try {
            bank.createAccount("Client1", 100);
        } catch (AccountNotFoundException e){
            System.out.println("Помилка: " + e.getMessage());
        }

        try {
            bank.transferMoney(1,3,-2000);
        } catch (NegativeAmountException e){
            System.out.println("Помилка: " + e.getMessage());
        }

        BankAccount account1 = bank.findAccount(1);
        BankAccount account2 = bank.findAccount(2);

        System.out.println(account1.getAccountSummary());
        System.out.println(account2.getAccountSummary());
    }
}
