import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Number number = new Number();
        boolean flag = false;
        int attempts = 0;

        while (!flag) {
            System.out.println("inter number");
            int guess = sc.nextInt();
            attempts++;

            flag = number.getSecretNumber(guess);
            System.out.println(flag);
        }
        System.out.println("You guessed " + attempts + " times.");
        sc.close();
    }
}