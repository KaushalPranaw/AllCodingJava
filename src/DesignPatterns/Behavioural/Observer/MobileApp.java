package DesignPatterns.Behavioural.Observer;

public class MobileApp implements Observer{
    @Override
    public void update(float temperature) {
        System.out.println("Mobile App: The current temperature is " + temperature + "°C");
    }
}
