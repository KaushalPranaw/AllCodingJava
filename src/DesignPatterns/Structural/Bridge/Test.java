package DesignPatterns.Structural.Bridge;

public class Test {
    public static void main(String[] args) {
        // Create shapes with different color implementations
        Shape redCircle = new Circle(new RedDrawAPI(), 10, 20, 30);
        Shape blueSquare = new Square(new BlueDrawAPI(), 15, 40, 50);
        // Draw the shapes with their respective colors
        redCircle.draw();  // Output: Drawing Circle with Red color at (20,30) with radius 10
        blueSquare.draw(); // Output: Drawing Square with Blue color at (40,50) with side 15

    }
}
