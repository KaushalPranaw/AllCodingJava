package CoreJava.MultiThreading;

import java.util.concurrent.*;

public class CustomThreadPoolExample {
    public static void main(String[] args) {
        int corePoolSize = 2;
        int maximumPoolSize = 4;
        long keepAliveTime = 10;
        TimeUnit timeUnit = TimeUnit.SECONDS;

        // Create a blocking queue to hold tasks
        BlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<>(10);

        // Provide a rejected execution handler
        RejectedExecutionHandler handler = new ThreadPoolExecutor.CallerRunsPolicy();

        // Create a custom thread pool
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(
                corePoolSize,
                maximumPoolSize,
                keepAliveTime,
                timeUnit,
                workQueue,
                handler
        );

        // Submit tasks to the custom thread pool
        for (int i = 1; i <= 10; i++) {
            final int taskNumber = i;
            threadPool.execute(() -> {
                System.out.println("Executing Task " + taskNumber + " by " + Thread.currentThread().getName());
                try {
                    Thread.sleep(2000); // Simulate task execution
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.out.println("Task " + taskNumber + " was interrupted");
                }
            });
        }

        // Shutdown the thread pool
        threadPool.shutdown();
    }
}
