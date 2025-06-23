package CoreJava.MultiThreading.EvenOddGenerator;

import java.util.concurrent.Exchanger;

public class EvenOddGeneratorUsingExchanger {
    private final int max = 10; // Upper limit for numbers
    private int number = 1;
    private final Exchanger<String> exchanger = new Exchanger<>();// Used to exchange control between threads

    public void printOdd() {
        while (number <= max) {
            if (number % 2 != 0) {
                System.out.println("Odd: " + number++);
                try {
                    exchanger.exchange("EVEN"); // Pass control to the even thread
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public void printEven() {
        while (number <= max) {
            if (number % 2 == 0) {
                System.out.println("Even: " + number++);
                try {
                    exchanger.exchange("ODD"); // Pass control to the odd thread
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public static void main(String[] args) {
        EvenOddGeneratorUsingExchanger obj = new EvenOddGeneratorUsingExchanger();

        // Create threads for printing odd and even numbers
        Thread oddThread = new Thread(obj::printOdd, "OddThread");
        Thread evenThread = new Thread(obj::printEven, "EvenThread");

        // Start the threads
        oddThread.start();
        try {
            obj.exchanger.exchange("START"); // Initial exchange to allow the odd thread to start
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        evenThread.start();
    }

}
