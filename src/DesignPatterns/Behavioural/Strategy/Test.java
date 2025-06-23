package DesignPatterns.Behavioural.Strategy;

public class Test {
    public static void main(String[] args) {
        PaymentSystem paymentSystem = new PaymentSystem();

        // Pay using Credit Card
        paymentSystem.setPaymentStrategy(new CreditCardPayment());
        paymentSystem.makePayment(100);  // Output: Paying $100 using Credit Card.
        // Pay using PayPal
        paymentSystem.setPaymentStrategy(new PayPalPayment());
        paymentSystem.makePayment(200);  // Output: Paying $200 using PayPal.
        // Pay using Cash
        paymentSystem.setPaymentStrategy(new CashPayment());
        paymentSystem.makePayment(50);   // Output: Paying $50 using Cash.

    }
}
