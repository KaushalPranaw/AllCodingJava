package DesignPatterns.Behavioural.Strategy;

public class PaymentSystem {
    private PaymentStrategy paymentStrategy;
    // Set the current strategy at runtime
    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }
    public void makePayment(int amount) {
        paymentStrategy.pay(amount);
    }

}
