package DesignPatterns.Behavioural.Observer;

public class DisplayBoard implements Observer{
    @Override
    public void update(float temperature) {
        System.out.println("DisplayBoard : The current temperature is " + temperature + "°C");
    }
}
