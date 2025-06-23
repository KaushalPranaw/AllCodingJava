package CoreJava.MultiThreading.EvenOddGenerator;

import java.util.concurrent.Semaphore;

public class EvenOddGeneratorUsingSemaphore {
    private final int max = 10; // Upper limit for numbers
    private int number = 1; // Shared counter

    // Semaphores to control access: start with oddThread's turn
    private final Semaphore oddSemaphore = new Semaphore(1);
    private final Semaphore evenSemaphore = new Semaphore(0);

    public void printOdd() {
        while (number <= max) {
            try {
                oddSemaphore.acquire(); // Acquire permit for odd thread
                if (number <= max) {
                    System.out.println("Odd: " + number++);
                }
                evenSemaphore.release();// Release permit for even thread
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void printEven() {
        while (number <= max) {
            try {
                evenSemaphore.acquire();
                if (number <= max) {
                    System.out.println("Even: " + number++);
                }
                oddSemaphore.release();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) {
        EvenOddGeneratorUsingSemaphore obj = new EvenOddGeneratorUsingSemaphore();

        // Create threads for printing odd and even numbers
        Thread oddThread = new Thread(obj::printOdd, "OddThread");
        Thread evenThread = new Thread(obj::printEven, "EvenThread");

        // Start the threads
        oddThread.start();
        evenThread.start();
    }


}
