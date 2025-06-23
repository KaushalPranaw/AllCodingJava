package CoreJava.MultiThreading.ConcurrencyProblems;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ProducerConsumer {
    private static final int CAPACITY = 10;
    private static final int NUM_PRODUCER = 3;
    private static final int NUM_CONSUMER = 3;

    public static void main(String[] args) {
        BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<>(CAPACITY);

        ExecutorService executorService = Executors.newFixedThreadPool(NUM_PRODUCER + NUM_CONSUMER);

        for (int i = 1; i <= NUM_PRODUCER; i++) {
            final int producerId = i;
            executorService.submit(() -> {
                try {
                    produce(blockingQueue, producerId);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.err.println("Producer " + producerId + " is interrupted");
                }
            });
        }
        for (int i = 1; i <= NUM_CONSUMER; i++) {
            final int consumerId = i;
            executorService.submit(() -> {
                try {
                    consume(blockingQueue, consumerId);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.err.println("Consumer " + consumerId + " is interrupted");
                }
            });
        }

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            executorService.shutdownNow();
        }
    }

    private static void consume(BlockingQueue<Integer> blockingQueue, int consumerId) throws InterruptedException {
        while (true) {
            Thread.sleep((int) (Math.random() * 1000));
            int item = blockingQueue.take();
            System.out.println("Consumer " + consumerId + " is consuming item : " + item);
        }
    }

    private static void produce(BlockingQueue<Integer> blockingQueue, int producerId) throws InterruptedException {
        int item = 0;
        while (true) {
            Thread.sleep((int) (Math.random() * 1000));
            blockingQueue.put(item);// Blocks if the queue is full
            System.out.println("Producer " + producerId + " is producing item : " + item);
            item++;
        }
    }
}
