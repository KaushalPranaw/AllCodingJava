package CoreJava.OOPS.pillars.abstraction;

public class TestInterface {
    public static void main(String[] args) {
        Flyable obj=new Aeroplane();
        obj.fly();

        Flyable obj2=new Bird();
        obj2.fly();
    }
}
