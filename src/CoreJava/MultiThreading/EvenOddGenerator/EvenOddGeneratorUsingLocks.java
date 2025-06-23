package CoreJava.MultiThreading.EvenOddGenerator;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class EvenOddGeneratorUsingLocks {
    private int number = 1;
    private final int max = 10;
    private final ReentrantLock lock = new ReentrantLock();
    private final Condition oddCondition = lock.newCondition();
    private final Condition evenCondition = lock.newCondition();

    public void printEven() {
        lock.lock();
        try {
            while (number <= max) {
                while (number % 2 != 0) {
                    evenCondition.await();//Wait until it's the even thread's turn
                }
                if (number <= max) {
                    System.out.println("Even: " + number);
                    number++;
                    oddCondition.signal();// Signal the odd thread
                }
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }

    public void printOdd() {
        lock.lock();
        try {
            while (number <= max) {
                while (number % 2 == 0) {
                    oddCondition.await();//Wait until its odd Thread's turn
                }
                if (number <= max) {
                    System.out.println("Odd: " + number);
                    number++;
                    evenCondition.signal();//Signal the even thread
                }
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        EvenOddGeneratorUsingLocks obj = new EvenOddGeneratorUsingLocks();
        // Thread to print odd numbers
        Thread oddThread = new Thread(obj::printOdd, "OddThread");

        // Thread to print even numbers
        Thread evenThread = new Thread(obj::printEven, "EvenThread");

        // Start threads
        oddThread.start();
        evenThread.start();
    }


}
