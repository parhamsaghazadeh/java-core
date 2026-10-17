import exceptions.AccountNotFoundException;
import exceptions.InsufficientBalanceException;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        AccountFileRepository accountFileRepository = new AccountFileRepository();
        Scanner sc = new Scanner(System.in);
        Bank bank = new Bank();

        int choice;
        long id;
        String name;
        double balance;
        double amount;

        boolean running = true;

        while (running) {

            System.out.println("\n===== BANK MENU =====");
            System.out.println("1. Create account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check balance");
            System.out.println("5. transaction");
            System.out.println("6. Show accounts");
            System.out.println("7. Show balance generate 1000");
            System.out.println("8. Show accounts by name");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter account ID: ");
                    id = sc.nextLong();

                    System.out.print("Enter account name: ");
                    name = sc.next();

                    System.out.print("Enter initial balance: ");
                    balance = sc.nextDouble();

                    try {
                        bank.findAccountById(id);
                        System.out.println("Account already exists");

                    } catch (AccountNotFoundException e) {

                        if (name.isBlank()) {
                            System.out.println("Name cannot be blank");

                        } else if (balance < 0) {
                            System.out.println("Balance cannot be negative");

                        } else {
                            Account account = new Account();

                            account.createAccount(id, name, balance);
                            bank.addAccount(account);

                            System.out.println("Account created successfully");
                        }
                    }
                    break;

                case 2:
                    System.out.print("Enter account ID: ");
                    id = sc.nextLong();

                    try {

                        System.out.print("Enter deposit amount: ");
                        amount = sc.nextDouble();

                        if (amount <= 0) {
                            System.out.println("Amount must be greater than zero");
                        } else {
                            bank.depositAsync(id, amount);
                            System.out.println("Account deposited successfully");
                        }

                    } catch (AccountNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 3:
                    System.out.print("Enter account ID: ");
                    id = sc.nextLong();

                    try {
                        System.out.print("Enter withdrawal amount: ");
                        amount = sc.nextDouble();

                        bank.withdrawAsync(id, amount);
                    } catch (AccountNotFoundException e) {
                        System.out.println(e.getMessage());

                    } catch (InsufficientBalanceException e) {
                        System.out.println(e.getMessage());
                        System.out.println("Current balance:" + e.getBalance());
                        System.out.println("request amount:" + e.getRequestedAmount());

                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 4:
                    System.out.print("Enter account ID: ");
                    id = sc.nextLong();

                    try {
                        Account account = bank.findAccountById(id);

                        System.out.println("Balance: " + account.getBalance());

                    } catch (AccountNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 5:
                    System.out.println("Enter account ID:");
                    id = sc.nextLong();
                    try {
                        Account account = bank.findAccountById(id);

                        List<Transaction> transactions = account.getTransactions();

                        for (Transaction transaction : transactions) {
                            System.out.println(transaction.getType() + " " + transaction.getAmount() + " " + transaction.getDate());
                        }

                    } catch (AccountNotFoundException e) {
                        System.out.println(e.getMessage());
                    }

                    break;
                case 6:
                    System.out.print("Account excite in bank:");
                    try {
                        List<Account> accounts = accountFileRepository.loadAccount();
                        System.out.println("file content: ");
                        System.out.println(accounts.isEmpty() ? "file empty" : accounts.toString());
                    }
                    catch (IOException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 7:
                    System.out.print("balance account:");

                    bank.findAccount();
                    break;
                case 8:
                    System.out.println("Show accounts by name:");
                    bank.showAccountName();
                    break;
                case 9:
                    bank.shutdown();
                    running = false;
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }

        sc.close();
    }
}
