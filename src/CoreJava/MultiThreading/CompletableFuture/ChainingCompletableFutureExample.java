package CoreJava.MultiThreading.CompletableFuture;

import java.util.concurrent.CompletableFuture;

public class ChainingCompletableFutureExample {
    public static void main(String[] args) {
        // Making coffee
        CompletableFuture<String> coffeeFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println("Making coffee...");
            try {
                Thread.sleep(2000); // Simulate coffee-making time
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Coffee is ready!";
        });

        // Once coffee is ready, start making tea
        CompletableFuture<String> teaFuture = coffeeFuture.thenApplyAsync(coffee -> {
            System.out.println(coffee);
            System.out.println("Making tea...");
            try {
                Thread.sleep(3000); // Simulate tea-making time
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Tea is ready!";
        });

        // Once tea is ready, print a message
        teaFuture.thenAccept(tea -> {
            System.out.println(tea);
        });

        // Wait for all tasks to finish before the program ends
        try {
            Thread.sleep(6000); // Ensure the main thread waits long enough for tasks to finish
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}