package DesignPatterns.Creational.Prototype;

public class Test {
    public static void main(String[] args) {
        // Create a prototype sports car
        Car prototypeCar = new SportsCar("V8 Engine", "Red");

        // Clone the prototype to create new cars
        Car car1 = prototypeCar.clone();
        Car car2 = prototypeCar.clone();

        // Show details of the cloned cars
        car1.showDetails();  // Output: SportsCar with Engine: V8 Engine and Color: Red
        car2.showDetails();  // Output: SportsCar with Engine: V8 Engine and Color: Red

        // Modify the color of car2
        ((SportsCar) car2).setColor("Blue");  // Cast to modify the color

        System.out.println();
        car1.showDetails();
        // Show details after modification
        car2.showDetails();  // Output: SportsCar with Engine: V8 Engine and Color: Blue
    }
}
