package DesignPatterns.Structural.Bridge;

public class RedDrawAPI implements DrawAPI{
    @Override
    public void drawCircle(int radius, int x, int y) {
        System.out.println("Drawing Circle with Red color at (" + x + "," + y + ") with radius " + radius);
    }

    @Override
    public void drawSquare(int side, int x, int y) {
        System.out.println("Drawing Square with Red color at (" + x + "," + y + ") with side " + side);
    }
}
