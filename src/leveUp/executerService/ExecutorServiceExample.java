package leveUp.executerService;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceExample {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        Future<Integer> firstTask = executor.submit(() -> {
            return 42;
        });
        Future<String> secondTask = executor.submit(() -> {
            try {
                Integer result = firstTask.get();
                return "Result based on Task 1: " + result;
            } catch (InterruptedException | ExecutionException e) {
                // Handle exception
                return "Error occurred: " + e.getMessage();
            }
        });
        try {
            // Get results from tasks
            System.out.println("First Task Result: " + firstTask.get());
            System.out.println("Second Task Result: " + secondTask.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        executor.shutdown();


    }
}
