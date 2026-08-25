import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Transaction transaction = new Transaction();
        int choice = 0;
        Scanner sc = new Scanner(System.in);
        while (choice != 4) {
            System.out.println("1.Show balance: ");
            System.out.println("2.Deposit:");
            System.out.println("3.Withdrawal: ");
            System.out.println("4.Exite:");

            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("your balance: " + transaction.showBalance());
                    break;
                case 2:
                    int amount = sc.nextInt();
                    transaction.getDeposit(amount);
                    System.out.println("Deposited " + amount + " into your balance.");
                    break;
                case 3:
                    int amount1 = sc.nextInt();
                    transaction.withdraw(amount1);
                    System.out.println("Withdrawn " + amount1 + " into your balance.");
                    break;
                case 4:
                    System.out.println("Thank you for using this program.");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
        sc.close();
    }
}