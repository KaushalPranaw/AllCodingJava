package leveUp.executerService;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureExample {
    public static void main(String[] args) {
        CompletableFuture<Integer> firstTask = CompletableFuture.supplyAsync(() -> 42);
        CompletableFuture<String> secondTask = firstTask.thenApply(result -> "Processed: " + result);
        secondTask.thenAccept(System.out::println); // non-blocking print

    }

}
