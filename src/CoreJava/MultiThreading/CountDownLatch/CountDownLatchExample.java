package CoreJava.MultiThreading.CountDownLatch;

/*
A CountDownLatch is like a timer
that helps coordinate the completion of tasks.
Imagine you are in a race where several runners (threads) need to wait for a signal (a countdown reaching zero)
before they can start running.
The race starter (main thread) keeps track of how many runners (tasks) are participating
and waits for all of them to finish something before giving the signal to start.

In simpler terms:
================
CountDownLatch allows one or more threads to wait for a set of events to complete before proceeding.
Once the latch's count reaches zero, all threads that were waiting are allowed to proceed.
Key points:
You initialize a CountDownLatch with a specific count (number of events or tasks).
Threads call countDown() when they complete their task, reducing the count.
The main thread (or any other thread waiting) calls await() to wait until the count reaches zero.
*/

import java.util.concurrent.CountDownLatch;

//Let’s say we want to simulate a scenario
// where multiple workers (threads) must complete their tasks
// before a manager (main thread) can proceed with a final task.
public class CountDownLatchExample {
    public static void main(String[] args) {
        // Create a CountDownLatch initialized to 3 (3 workers to finish tasks)
        CountDownLatch countDownLatch = new CountDownLatch(3);

        // Create and start 3 worker threads
        for (int i = 1; i <= 3; i++) {
            new Thread(new Worker(i, countDownLatch)).start();
        }

        try {
            // Main thread (Manager) waits for all worker threads to finish their tasks
            countDownLatch.await();
            System.out.println("All workers have finished their tasks. Manager can proceed!");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Worker implements Runnable {
    private final int workerId;
    private final CountDownLatch countDownLatch;

    public Worker(int workerId, CountDownLatch countDownLatch) {
        this.workerId = workerId;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            // Simulate task by sleeping for a random amount of time
            System.out.println("Worker " + workerId + " is starting their task");
            Thread.sleep((long) (Math.random() * 2000));  // Random sleep time
            System.out.println("Worker " + workerId + " has finished their task");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // Worker finished its task, countdown the latch
            countDownLatch.countDown();
        }
    }
}

