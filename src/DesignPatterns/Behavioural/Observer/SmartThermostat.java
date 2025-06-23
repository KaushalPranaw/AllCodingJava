package DesignPatterns.Behavioural.Observer;

public class SmartThermostat implements Observer{
    @Override
    public void update(float temperature) {
        if(temperature>25){
            System.out.println("Smart Thermostat: It's too hot! Turning on the air conditioning...");
        } else {
            System.out.println("Smart Thermostat: The temperature is fine.");
        }
    }
}
