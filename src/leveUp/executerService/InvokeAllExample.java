package leveUp.executerService;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class InvokeAllExample {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        List<Callable<String>> tasks = Arrays.asList(
                () -> {
                    Thread.sleep(1000);
                    return "Task 1 done";
                },
                () -> {
                    Thread.sleep(2000);
                    return "Task 2 done";
                },
                () -> {
                    Thread.sleep(1500);
                    return "Task 3 done";
                }
        );
        try {
            List<Future<String>> results = executor.invokeAll(tasks);
            // Blocks until all tasks are complete
            for (Future<String> future : results) {
                System.out.println(future.get()); // blocking per result
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }

    }
}
