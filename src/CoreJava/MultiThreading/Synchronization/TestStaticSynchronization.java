package CoreJava.MultiThreading.Synchronization;

class Table1 {
    synchronized static void printTable(int n) {
        synchronized (Table.class) {
            for (int i = 1; i <= 10; i++) {
                System.out.println(n * i);
                try {
                    Thread.sleep(400);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}

public class TestStaticSynchronization {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            Table1.printTable(1);
        });
        t1.start();

        Thread t2 = new Thread(() -> {
            Table1.printTable(1000);
        });
        t2.start();
    }
}
