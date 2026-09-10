public class Animal {
    String name;
    int age;

    public String createDog(String name, int age) {
        this.name = name;
        this.age = age;
        return "createDoge";
    }

    public String createCat(String name, int age) {
        this.name = name;
        this.age = age;
        return "createCate";
    }

    public void sound() {
        System.out.println("sound");
    }

    public String showAnimal() {
        System.out.println(name + " " + age);
        return "showAnimal";
    }

}
