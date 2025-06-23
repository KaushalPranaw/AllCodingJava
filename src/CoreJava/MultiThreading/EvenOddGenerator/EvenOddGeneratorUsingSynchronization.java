package CoreJava.MultiThreading.EvenOddGenerator;

public class EvenOddGeneratorUsingSynchronization {
    private int number = 1;
    private int max = 10;

    public synchronized void printEven() {
        while (number <= max) {
            // Wait until it's an even number's turn
            while (number % 2 != 0) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            if (number <= max) {
                System.out.println("Even: " + number);
                number++;
                notify();
            }
        }
    }

    public synchronized void printOdd() {
        while (number <= max) {
            while (number % 2 == 0) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            if (number <= max) {
                System.out.println("Odd: " + number);
                number++;
                notify();
            }
        }
    }

    public static void main(String[] args) {
        EvenOddGeneratorUsingSynchronization obj = new EvenOddGeneratorUsingSynchronization();
        Thread evenThread = new Thread(obj::printEven, "EvenThread");
        Thread oddThread = new Thread(obj::printOdd, "OddThread");
        oddThread.start();
        evenThread.start();
    }
}
