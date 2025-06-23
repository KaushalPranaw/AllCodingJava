package CoreJava.OOPS.pillars.abstraction;

public class Bike extends Vehicle{

    private String name;
    public Bike(int speed, String name) {
        super(speed);
        this.name=name;
    }

    @Override
    void start() {
        System.out.println("Bike : "+this.name+ " started");
    }

    public static void main(String[] args) {
        Vehicle vehicle=new Bike(100, "honda");
        vehicle.start();
        vehicle.stop();
    }
}
