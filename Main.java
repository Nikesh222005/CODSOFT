package CODSOFT;


// ATM Class:

import java.util.Scanner;

public class ATM {
    private BankAccount account;
    private Scanner input;

    public ATM(BankAccount account) {
        this.account = account;
        this.input = new Scanner(System.in);
    }

    public void run() {
        while (true) {
            System.out.println("Select an option:");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");

            int option = input.nextInt();

            switch (option) {
                case 1:
                    withdraw();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    checkBalance();
                    break;
                case 4:
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option");
            }
        }
    }

    private void withdraw() {
        System.out.println("Enter amount to withdraw:");
        double amount = input.nextDouble();

        if (account.withdraw(amount)) {
            System.out.println("Withdrawal successful");
        } else {
            System.out.println("Insufficient balance");
        }
    }

    private void deposit() {
        System.out.println("Enter amount to deposit:");
        double amount = input.nextDouble();

        account.deposit(amount);
        System.out.println("Deposit successful");
    }

    private void checkBalance() {
        System.out.println("Current balance: " + account.getBalance());
    }
}

// BankAccount Class:

public class BankAccount {
    private double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public boolean withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public void deposit(double amount) {
        balance += amount;
    }
}

// Main Method:

public class Main{
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000.0); // Initial balance
        ATM atm = new ATM(account);
        atm.run();
    }
}


