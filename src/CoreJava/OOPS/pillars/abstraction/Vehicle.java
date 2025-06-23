package CoreJava.OOPS.pillars.abstraction;

public abstract class Vehicle {
    protected int speed;

    public Vehicle(int speed) {
        this.speed = speed;
    }

    abstract void start();

    public void stop(){
        System.out.println("Vehicle is stopped");
    }
}
