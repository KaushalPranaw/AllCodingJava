package Java8Practice.RealTimeDataProcessingPipeline;

import java.util.Random;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.function.Consumer;
import java.util.function.Supplier;
/*Implement a pipeline that processes streaming data in real-time using a combination of `Consumer` and `Supplier`.
For example, simulate an order processing system where new orders are received and processed in real-time.

Requirements:
     - Define a `Supplier` that generates random `Order` objects with fields like `orderId`, `quantity`, and `price`.
     - Define a `Consumer` that processes the order by calculating the total price and printing the order details.
     - Simulate real-time processing by calling `get()` on the `Supplier` to generate orders and `accept()` on the `Consumer` to process them in a loop.

Introduce multithreading where one thread generates orders, and another thread processes them.*/
public class RealTimeDataProcessingPipeline {
    public static void main(String[] args) {
        // Shared queue between producer and consumer threads
        BlockingQueue<Order> orderQueue = new LinkedBlockingQueue<>(10);

        // Supplier for generating random orders
        Supplier<Order> orderSupplier = () -> {
            Random random = new Random();
            String orderId = "Order-" + random.nextInt(1000);
            int quantity = random.nextInt(10) + 1; // Quantity between 1 and 10
            double price = random.nextDouble() * 100; // Price between 0 and 100
            return new Order(orderId, quantity, price);
        };

        // Consumer for processing orders
        Consumer<Order> orderConsumer = order -> {
            System.out.println("Processing : " + order);
            // Simulate processing time
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        };

        // Producer thread
        Thread producer = new Thread(() -> {
            while (true) {
                try {
                    Order order = orderSupplier.get();
                    orderQueue.put(order);
                    System.out.println("Generated : " + order);
                    Thread.sleep(200); // Simulate order generation delay
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        });

        // Consumer thread
        Thread consumer = new Thread(() -> {
            while (true) {
                try {
                    Order order = orderQueue.take();
                    orderConsumer.accept(order);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        });

        // Start threads
        producer.start();
        consumer.start();

        // Allow simulation to run for a while, then stop
        try {
            Thread.sleep(10000); // Let it run for 10 seconds
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // Stop threads
        producer.interrupt();
        consumer.interrupt();
    }
}
