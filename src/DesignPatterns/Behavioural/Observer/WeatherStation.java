package DesignPatterns.Behavioural.Observer;

import java.util.ArrayList;
import java.util.List;

public class WeatherStation implements Subject{

    private float temperature;
    private List<Observer> observers = new ArrayList<>();

    public void setTemperature(float temperature) {
        this.temperature = temperature;
        notifyObservers();  // Notify all observers whenever the temperature changes
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);  // Add an observer to the list
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(temperature);  // Notify each observer with the updated temperature
        }
    }
}
