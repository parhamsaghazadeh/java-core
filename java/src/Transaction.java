public class Transaction {
    public int deposit;

    public int getDeposit(int amount) {
        deposit = amount+deposit;
        return deposit;
    }

    public int withdraw(int amount) {
        deposit = deposit - amount;
        return deposit;
    }

    public int showBalance() {
        return deposit;
    }
}
