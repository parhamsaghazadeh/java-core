import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Animal animal = new Doge();
        Animal animal2 = new Cat();
        String name;
        int age;
        int choice = 0;

        while (choice != 5) {
            System.out.println("1.Create doge");
            System.out.println("2.Create cat");
            System.out.println("3.Show Animal");
            System.out.println("4.Animal sound");
            System.out.println("5.exide");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Create doge");
                    name = sc.next();
                    age = sc.nextInt();
                    animal.createDog(name, age);
                    break;
                case 2:
                    System.out.println("Create cat");
                    name = sc.next();
                    age = sc.nextInt();
                    animal.createCat(name, age);
                    break;
                case 3:
                    System.out.println("Show Animal");
                    System.out.println(animal.showAnimal());
                    break;
                case 4:
                    System.out.println("Animal sound");
                    System.out.println(animal.sound());
                    System.out.println(animal2.sound());
                    break;
                case 5:
                    System.out.println("thanks for using");
                    break;
                default:
                    System.out.println("Invalid choice");

            }
        }
        sc.close();
    }
}