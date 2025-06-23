package DesignPatterns.Structural.Bridge;

public interface DrawAPI {
    void drawCircle(int radius, int x, int y);
    void drawSquare(int side, int x, int y);
}
