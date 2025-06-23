package CoreJava.MultiThreading.Synchronization;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TryLock {
    private final Lock lockA = new ReentrantLock();
    private final Lock lockB = new ReentrantLock();

    public static void main(String[] args) {
        new TryLock().runTest();
    }

    private void runTest() {
        // Thread 1 attempts to acquire locks on ResourceA and ResourceB
        Thread t1 = new Thread(() -> {
            if (acquireLocks(lockA, lockB)) {
                try {
                    System.out.println("Thread t1 successfully acquired both the lock");
                } finally {
                    lockA.unlock();
                    lockB.unlock();
                }
            } else {
                System.out.println("Thread t1 does not acquired both the lock, exiting");
            }
        });

        // Thread 2 attempts to acquire locks on ResourceB and ResourceA
        Thread t2 = new Thread(() -> {
            if (acquireLocks(lockB, lockA)) {
                try {
                    System.out.println("Thread t2 successfully acquired both the lock");
                } finally {
                    lockB.unlock();
                    lockA.unlock();
                }
            } else {
                System.out.println("Thread t2 does not acquired both the lock, exiting");
            }
        });
        t1.start();
        t2.start();
    }

    private final boolean acquireLocks(Lock lock1, Lock lock2) {
        try {
            boolean gotLock1 = lock1.tryLock();
            if (!gotLock1) {
                return false;// Couldn't acquire the first lock, exit early
            }

            //try acquire second lock
            boolean gotLock2 = lock2.tryLock();
            if (!gotLock2) {
                lock1.unlock();// Unlock the first lock if we couldn't get the second lock
                return false;//Couldn't acquire the second lock, exit early
            }

            // Both locks acquired successfully
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
