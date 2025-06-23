package CoreJava.MultiThreading.Synchronization;

class ReentrantLock {
    public synchronized void m() {
        n();
        System.out.println("this is m() method");
    }

    public synchronized void n() {
        System.out.println("this is n() method");
    }

    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock();
        new Thread(reentrantLock::m).start();
    }
}
