package CoreJava.MultiThreading.Synchronization;

class Table {
    /*synchronized void printTable(int n) {
        for (int i = 1; i <= 10; i++) {
            System.out.println(n * i);
            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }*/
    //synchronized block
    void printTable(int n) {
        synchronized (this) {
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

public class TestSynchronization {
    public static void main(String[] args) {
        Table table = new Table();
        Thread t1 = new Thread(() -> {
            table.printTable(1);
        });
        t1.start();

        Thread t2 = new Thread(() -> {
            table.printTable(1000);
        });
        t2.start();
    }
}
