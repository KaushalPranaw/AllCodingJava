package CoreJava.MultiThreading;

class ThreadJoin1 extends Thread {
    public void run() {
        for (int j = 0; j < 2; j++) {
            try {
                Thread.sleep(300);
                System.out.println("The current thread name is: " + Thread.currentThread().getName());
            } catch (Exception e) {
                System.out.println("The exception has been caught: " + e);
            }
            System.out.println(j);
        }
    }
}

public class ThreadJoin {
    // main method
    public static void main(String argvs[]) {

        ThreadJoin1 th1 = new ThreadJoin1();
        ThreadJoin1 th2 = new ThreadJoin1();
        ThreadJoin1 th3 = new ThreadJoin1();
        th1.start();
        try {
            System.out.println("The current thread name is: " + Thread.currentThread().getName());
            th1.join();
        } catch (Exception e) {
            System.out.println("The exception has been caught " + e);
        }
        th2.start();
        try {
            System.out.println("The current thread name is: " + Thread.currentThread().getName());
            th2.join();
        } catch (Exception e) {
            System.out.println("The exception has been caught " + e);
        }
        th3.start();
    }
}
