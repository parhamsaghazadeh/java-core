import java.sql.Driver;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Vehicle vehicle = new Vehicle();
        String model;
        String brand;
        int choice = 0;

        while (choice != 7) {
            System.out.println("1.Create Car");
            System.out.println("2.Create Motorcycle");
            System.out.println("3.Create Truck");
            System.out.println("4.Show Vehicle");
            System.out.println("5.Driver");
            System.out.println("6.maimtenance");
            System.out.println("7.exite");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter Model");
                    model = sc.next();
                    System.out.println("Enter Brand");
                    brand = sc.next();
                    vehicle.createCar(model, brand);
                    break;
                case 2:
                    System.out.println("Enter Model");
                    model = sc.next();
                    System.out.println("Enter Brand");
                    brand = sc.next();
                    vehicle.createMotorcycle(model, brand);
                    break;
                case 3:
                    System.out.println("Enter Model");
                    model = sc.next();
                    System.out.println("Enter Brand");
                    brand = sc.next();
                    vehicle.createTruck(model, brand);
                    break;
                case 4:
                    System.out.println("Show Vehicle");
                    vehicle.showVehicles();
                    break;
                case 5:
                    System.out.println("Driver");
                    Vehicle driver = new Car();
                    Vehicle driver1 = new Motorcycle();
                    Vehicle driver2 = new Truck();
                    System.out.println(driver.drive() + " " + driver1.drive() + " " + driver2.drive());
                    break;
                case 6:
                    System.out.println("maintain");
                    Maintainable maintainable = new Car();
                    Maintainable maintainable1 = new Motorcycle();
                    Maintainable maintainable2 = new Truck();

                    maintainable.maintain();
                    maintainable1.maintain();
                    maintainable2.maintain();
                    break;
                case 7:
                    System.out.println("exit");
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
        sc.close();
    }
}