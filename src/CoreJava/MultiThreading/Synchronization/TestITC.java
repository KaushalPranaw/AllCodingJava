package CoreJava.MultiThreading.Synchronization;

class Customer {
    private int amount = 10000;

    synchronized void withdraw(int amount) {
        System.out.println("Going to withdraw : ");
        if (this.amount < amount) {
            System.out.println("Less balance; waiting for deposit.");
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            this.amount -= amount;
            System.out.println("Withdraw completed.");
        }
    }

    synchronized void deposit(int amount) {
        System.out.println("Going to deposit");
        this.amount += amount;
        System.out.println("Deposit completed");
        notify();
    }

}

public class TestITC {
    public static void main(String[] args) {
        Customer customer = new Customer();
        new Thread(() -> {
            customer.withdraw(15000);
        }).start();
        new Thread(() -> {
            customer.deposit(10000);
        }).start();
    }
}
