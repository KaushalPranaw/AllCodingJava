package Comp.WDTS;

public class TestEvenOdd1 {
    private int number = 1;

    public static void main(String[] args) {
        TestEvenOdd1 o = new TestEvenOdd1();
        Thread oddThread = new Thread(new Runnable() {
            @Override
            public void run() {
                o.printOdd();
            }
        });
        Thread evenThread = new Thread(new Runnable() {
            @Override
            public void run() {
                o.printEven();
            }
        });
        oddThread.start();
        evenThread.start();


    }

    public synchronized void printOdd() {
        while (number <= 10) {
            if (number % 2 != 0) {
                System.out.println("Odd thread: " + number);
                number++;
                notify();
                if (number <= 10) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }

    public synchronized void printEven() {
        while (number <= 10) {
            if (number % 2 == 0) {
                System.out.println("Even num: " + number);
                number++;
                notify();
                if (number <= 10) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }
}
