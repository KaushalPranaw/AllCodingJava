package DesignPatterns.Behavioural.Observer;

public interface Subject {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();  // Notify all observers about a state change
}
