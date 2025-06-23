package Comp.WDTS;

public class TestEvenOdd {
    private static int number = 1;
    private static final int MAX_NUM = 10;
    private static final Object lock = new Object();

    public static void main(String[] args) {
        Thread oddThread = new Thread(new Runnable() {
            @Override
            public void run() {
                printOdd();
            }
        });
        Thread evenThread = new Thread(new Runnable() {
            @Override
            public void run() {
                printEven();
            }
        });
        oddThread.start();
        evenThread.start();


    }

    public static void printOdd() {
        while (number <= MAX_NUM) {
            synchronized (lock) {
                if (number % 2 != 0) {
                    System.out.println("Odd thread: " + number);
                    number++;
                    lock.notify();
                }
                try {
                    if (number <= MAX_NUM) {
                        lock.wait();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void printEven() {
        while (number <= MAX_NUM) {
            synchronized (lock) {
                if (number % 2 == 0) {
                    System.out.println("Even thread: " + number);
                    number++;
                    lock.notify();
                }
                try {
                    if (number <= MAX_NUM) {
                        lock.wait();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
