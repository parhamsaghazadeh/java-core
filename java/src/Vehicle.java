import java.util.ArrayList;
import java.util.List;

public class Vehicle {
    String model;
    String brand;

    List<String> vehicles = new ArrayList<String>();
    public String createCar(String model, String brand) {
        this.model = model;
        this.brand = brand;
        vehicles.add(model);
        vehicles.add(brand);
        return model + " " + brand;
    }

    public String createMotorcycle(String model, String brand) {
        this.model = model;
        this.brand = brand;
        vehicles.add(model);
        vehicles.add(brand);
        return model + " " + brand;
    }

    public String createTruck(String model, String brand) {
        this.model = model;
        vehicles.add(model);
        vehicles.add(brand);
        this.brand = brand;
        return model + " " + brand;
    }

    public String showVehicles(){
        vehicles.forEach(System.out::println);
        return "";
    }



    public String drive(){
        return "drive";
    }


}
