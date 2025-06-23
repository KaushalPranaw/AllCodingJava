package DesignPatterns.Structural.Bridge;

public class Square extends Shape{
    private int side;
    private int x;
    private int y;

    public Square(DrawAPI drawAPI, int side, int x, int y) {
        super(drawAPI);
        this.side = side;
        this.x = x;
        this.y = y;
    }

    @Override
    public void draw() {
        drawAPI.drawSquare(side, x, y);
    }
}
