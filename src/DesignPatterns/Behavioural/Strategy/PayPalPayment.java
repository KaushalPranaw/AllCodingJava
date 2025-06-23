package DesignPatterns.Behavioural.Strategy;

public class PayPalPayment implements PaymentStrategy {
    @Override
    public void pay(int amount) {
        System.out.println("Paying $" + amount + " using Paypal.");
    }
}
