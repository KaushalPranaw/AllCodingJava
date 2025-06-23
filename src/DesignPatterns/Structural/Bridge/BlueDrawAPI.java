package DesignPatterns.Structural.Bridge;

public class BlueDrawAPI implements DrawAPI{
    @Override
    public void drawCircle(int radius, int x, int y) {
        System.out.println("Drawing Circle with Blue color at (" + x + "," + y + ") with radius " + radius);
    }

    @Override
    public void drawSquare(int side, int x, int y) {
        System.out.println("Drawing Square with Blue color at (" + x + "," + y + ") with side " + side);
    }
}
