package CoreJava.MultiThreading.EvenOddGenerator;

import java.util.concurrent.CountDownLatch;

public class EvenOddGeneratorUsingCountDownLatch {
    private final int max = 10; // Upper limit for numbers
    private int number = 1;
    private final CountDownLatch oddLatch = new CountDownLatch(1); // Odd thread starts first
    private final CountDownLatch evenLatch = new CountDownLatch(0); // Even thread waits initially

    public void printOdd() {
        while (number <= max) {
            try {
                oddLatch.await();
                if (number <= max && number % 2 != 0) {
                    System.out.println("Odd: " + number++);
                }
                evenLatch.countDown(); // Allow even thread
                oddLatch.countDown(); // Reset latch for the next iteration
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void printEven() {
        try {
            evenLatch.await();
            while (number <= max) {
                if (number <= max && number % 2 == 0) {
                    System.out.println("Even: " + number++);
                }
                oddLatch.countDown();
                evenLatch.countDown();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        EvenOddGeneratorUsingCountDownLatch obj = new EvenOddGeneratorUsingCountDownLatch();

        // Create threads for printing odd and even numbers
        Thread oddThread = new Thread(obj::printOdd, "OddThread");
        Thread evenThread = new Thread(obj::printEven, "EvenThread");

        // Start the threads
        oddThread.start();
        evenThread.start();
    }
}
