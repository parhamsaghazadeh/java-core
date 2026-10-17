import exceptions.AccountNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class AccountRepository implements Repository<Account> {

    private List<Account> accounts = new ArrayList<>();

    @Override
    public void save(Account object){
        accounts.add(object);
    }

    @Override
    public Account findById(long id) {
        for (Account account : accounts) {
            if (account.getId() == id) {
                return account;
            }
        }
        throw new AccountNotFoundException("Account not found");
    }

    @Override
    public void delete(Account object){
        accounts.remove(object);
    }
}
