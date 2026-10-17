import exceptions.AccountNotFoundException;
import exceptions.InsufficientBalanceException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Predicate;

public class Bank {

    ExecutorService pool = Executors.newFixedThreadPool(2);

    List<Account> accounts = new ArrayList<>();

    private AccountFileRepository accountRepository = new AccountFileRepository();

    public void addAccount(Account account) {
        accounts.add(account);
        try {
            accountRepository.saveAccount(accounts);
            System.out.println("Saved account");
        }
        catch (IOException e) {
            System.out.println("Error saving account");
        }
    }

    public Account findAccountById(long id) {
        for (Account account : accounts) {
            if (account.getId() == id) {
                return account;
            }
        }
        throw new AccountNotFoundException("Account not found");
    }

    public String getAccounts() {
        return accounts.toString();
    }

    public void findAccount(){
        accounts.stream()
                .filter(account -> account.getBalance() > 1000)
                .forEach(System.out::println);
    }

    public void showAccountName(){
        accounts.stream()
                .sorted((a1, a2) ->
                        Double.compare(a1.getBalance(), a2.getBalance()))
                .forEach(System.out::println);
    }

    public void loadAccounts(){
        try {
            accounts.clear();

            accounts.addAll(accountRepository.loadAccount());

            System.out.println("Loaded accounts" + accounts.size());
        }
        catch (IOException e) {
            System.out.println("Error loading accounts" + e.getMessage() );
        }
    }


    public void depositAsync(long accountId, double amount) {
        pool.submit(() -> {
            try {
                Account account = findAccountById(accountId);
                String result = account.deposit(amount);
                System.out.println(result);
            } catch (RuntimeException e) {
                System.out.println(
                        "Deposit failed: " + e.getMessage()
                );
            }
        });
    }

    public void withdrawAsync(long accountId, double amount) {
        pool.submit(() -> {
            try {
                Account account = findAccountById(accountId);
                String result = account.withdraw(amount);
                System.out.println(result);
            } catch (RuntimeException e) {
                System.out.println(
                        "Withdrawal failed: " + e.getMessage()
                );
            }
        });
    }

    public void shutdown() {
        pool.shutdown();
    }

}
