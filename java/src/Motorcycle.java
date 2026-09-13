public class Motorcycle extends Vehicle implements Maintainable {
    @Override
    public String drive(){
        return "driving motorcycle";
    }

    @Override
    public void maintain(){
        System.out.println("motorcycle has been maintained.");
    }

}
