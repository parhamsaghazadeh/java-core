package exceptions;

public class InsufficientBalanceException extends RuntimeException {
    private final double balance;
    private final double requestAmount;

    public InsufficientBalanceException(String message, double balance, double requestAmount) {
        super(message);
        this.balance = balance;
        this.requestAmount = requestAmount;
    }

    public double getBalance() {
        return balance;
    }

    public double getRequestedAmount() {
        return requestAmount;
    }
}
