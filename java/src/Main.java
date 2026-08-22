import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        while (choice != 5) {
            System.out.println("1. Addition");
            System.out.println("2. Subtraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Division");
            System.out.println("5. Exit");

            choice = sc.nextInt();

            Operations op = new Operations();
            switch (choice) {
                case 1:
                    System.out.println("input a 2 number");
                    double a = sc.nextDouble();
                    double b = sc.nextDouble();
                    int num1 = op.Sum(a, b);
                    System.out.println("sum of numbers is " + num1);
                    break;
                case 2:
                    System.out.println("input a 2 number");
                    double c = sc.nextDouble();
                    double d = sc.nextDouble();
                    int num2 = op.Subtract(c, d);
                    System.out.println("subtraction of numbers is " + num2);
                    break;
                case 3:
                    System.out.println("input a 2 number");
                    double f = sc.nextDouble();
                    double g = sc.nextDouble();
                    int num3 = op.Multiply(f, g);
                    System.out.println("multiplication of numbers is " + num3);
                    break;
                case 4:
                    System.out.println("input a 2 number");
                    double e = sc.nextDouble();
                    double k = sc.nextDouble();
                    double result = op.Divide(e, k);
                    System.out.println("divide of numbers is " + result);
                    break;
                default:
                    System.out.println("invalid choice");
            }
        }
    }
}
