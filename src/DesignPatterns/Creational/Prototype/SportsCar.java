package DesignPatterns.Creational.Prototype;

public class SportsCar implements Car {
    private String engine;
    private String color;

    public SportsCar(String engine, String color) {
        this.engine = engine;
        this.color = color;
    }

    @Override
    public Car clone() {
        return new SportsCar(this.engine, this.color);
    }

    @Override
    public void showDetails() {
        System.out.println("SportsCar with Engine: " + engine + " and Color: " + color);
    }

    // Setter method for modifying the color of a cloned car
    public void setColor(String color) {
        this.color = color;
    }
}
