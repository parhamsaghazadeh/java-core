import exceptions.AccountNotFoundException;
import exceptions.InsufficientBalanceException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bank {

    //List<Account> accounts = new ArrayList<>();
    private Map<Long, Account> accounts = new HashMap<>();

    public void addAccount(Account account) {
        accounts.put(account.getId(), account);
    }

    public Account findAccountById(long id) {
        if (accounts.containsKey(id)) {
            return accounts.get(id);
        }
        throw new AccountNotFoundException("Account not found");
    }

    public String getAccounts() {
        return accounts.values().toString();
    }
}
