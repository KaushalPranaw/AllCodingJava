package leveUp.executerService;

import java.util.concurrent.CompletableFuture;

public class AllOfExample {
    public static void main(String[] args) {
        CompletableFuture<String> task1 = CompletableFuture.supplyAsync(() -> {
            try { Thread.sleep(1000); } catch (Exception ignored) {}
            return "Task 1 done";
        });

        CompletableFuture<String> task2 = CompletableFuture.supplyAsync(() -> {
            try { Thread.sleep(2000); } catch (Exception ignored) {}
            return "Task 2 done";
        });

        CompletableFuture<String> task3 = CompletableFuture.supplyAsync(() -> {
            try { Thread.sleep(1500); } catch (Exception ignored) {}
            return "Task 3 done";
        });

        CompletableFuture<Void> allTasks = CompletableFuture.allOf(task1, task2, task3);

        // Continue after all tasks are complete
        allTasks.thenRun(() -> {
            try {
                System.out.println(task1.get());
                System.out.println(task2.get());
                System.out.println(task3.get());
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        System.out.println("Main thread continues...");
        // Wait for all tasks to complete before exiting
        allTasks.join();
    }
}
