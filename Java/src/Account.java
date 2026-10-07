import exceptions.InsufficientBalanceException;

import java.util.ArrayList;
import java.util.List;

import Enum.TransactionType;


public class Account {
    private long id;
    private String name;
    private double balance;

    Bank bank = new Bank();

    private List<Transaction> transactions = new ArrayList<>();

    public String createAccount(long id, String name, double balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
        return "Account created successfully";
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }


    public String deposit(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount must be greater than 0");}

        balance = balance + amount;

        Transaction transaction = new Transaction(TransactionType.DEPOSIT , amount, balance);

        transactions.add(transaction);

        return "Deposited " + amount + " to account " + id;
    }

    public String withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException(
                    "Amount must be greater than zero"
            );
        }

        if (amount > balance) {
            throw new InsufficientBalanceException(
                    "Insufficient balance"
                    , balance, amount
            );
        }

        balance = balance - amount;

        Transaction transaction = new Transaction(TransactionType.WITHDRAW , amount , balance);

        transactions.add(transaction);

        return "Withdrawn " + amount + " from account " + id;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    @Override
    public String toString() {
        return  "Account [id=" + id + ", name=" + name + ", balance=" + balance + "]";
    }
}
