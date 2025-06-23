package CoreJava.MultiThreading;

public class TestCallRun extends Thread {
    public void run() {
        for (int i = 1; i < 5; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        TestCallRun t1 = new TestCallRun();
        TestCallRun t2 = new TestCallRun();
        t1.run();
        t2.run();
        /*t1.start();
        t2.start();*/
    }
}
