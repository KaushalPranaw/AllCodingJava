package Comp.GSGR_PMW3;

public class OddEvenThreads {
    private static final int MAX_NUM = 50;
    private static int counter = 1;
    private static final Object lock = new Object();

    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            while (counter <= MAX_NUM) {
                synchronized (lock) {
                    while (counter % 2 == 0 && counter <= MAX_NUM) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    if (counter <= MAX_NUM) {
                        System.out.println("T1 (Odd) : " + counter);
                        counter++;
                        lock.notify();
                    }
                }
            }
        });
        Thread t2 = new Thread(() -> {
            while (counter <= MAX_NUM) {
                synchronized (lock) {
                    while (counter % 2 == 1 && counter <= MAX_NUM) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    if (counter <= MAX_NUM) {
                        System.out.println("T2 (Even) : " + counter);
                        counter++;
                        lock.notify();
                    }
                }
            }
        });
        t1.start();
        t2.start();
    }
}
