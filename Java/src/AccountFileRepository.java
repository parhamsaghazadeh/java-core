import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class AccountFileRepository {

    private Path path = Path.of("accounts.txt");

    public void saveAccount(List<Account> accounts) throws IOException {
        StringBuilder content = new StringBuilder();

        for (Account account : accounts) {
            content.append(account.getId()).append(",")
                    .append(account.getName()).append(",")
                    .append(account.getBalance()).append("\n");
        }
        Files.writeString(path, content.toString());
        System.out.println("Accounts count: " + accounts.size());


    }

    public List<Account> loadAccount() throws IOException {
        List<Account> accounts = new ArrayList<>();
        for (String line : Files.readAllLines(path)) {
            String[] accountData = line.split(",");
            long id = Long.parseLong(accountData[0]);
            String name = accountData[1];
            double balance = Double.parseDouble(accountData[2]);
            Account account = new Account();
            account.createAccount(id, name, balance);
            accounts.add(account);
        }
        return accounts;
    }

}
