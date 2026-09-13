public class Truck extends Vehicle implements Maintainable {
    @Override
    public String drive() {
        return "driving Truck";
    }

    @Override
    public void maintain(){
        System.out.println("truck has been maintained.");
    }
}
