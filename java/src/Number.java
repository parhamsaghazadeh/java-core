import java.util.Random;
import java.util.Scanner;

public class Number {

    int secretNumber=0;

    public Number() {
        Random rand = new Random();
         secretNumber = rand.nextInt(100) + 1;
    }

    public boolean getSecretNumber(int number) {
        if (secretNumber == number) {
            System.out.println("you guessed the secret number");
            return true;
        } else if (secretNumber > number) {
            System.out.println("You said less.\n");
        } else{
            System.out.println(" you said higher");
        }
        return false;
    }
}

