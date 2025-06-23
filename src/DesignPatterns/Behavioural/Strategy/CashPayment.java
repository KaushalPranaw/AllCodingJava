package DesignPatterns.Behavioural.Strategy;

public class CashPayment implements PaymentStrategy {
    @Override
    public void pay(int amount) {
        System.out.println("Paying $" + amount + " using cash.");
    }
}
