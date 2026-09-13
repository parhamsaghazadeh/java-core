public class Car extends Vehicle implements Maintainable {
    @Override
    public String drive(){
       return "driving car";
    }

    @Override
    public void maintain(){
        System.out.println("Car has been maintained.");
    }

}
