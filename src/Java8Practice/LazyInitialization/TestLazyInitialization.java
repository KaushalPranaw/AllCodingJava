package Java8Practice.LazyInitialization;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Supplier;
/*Implement a system that lazily initializes an expensive resource using `Supplier`. The resource should only be created when it's actually needed.

Requirements:
     - Create a `Supplier` that returns a new instance of a `DatabaseConnection` class (simulating a resource-heavy object).
     - Implement a method `getConnection()` that only creates the connection when the resource is required. It should be invoked lazily.
     - Simulate resource usage by calling `getConnection()` in a multithreaded environment (e.g., 5 threads).

 Use `Supplier<T>` with memoization to ensure that the resource is created only once, even in the case of multiple calls.*/
public class TestLazyInitialization {

    private static DatabaseConnection connection;
    private static Supplier<DatabaseConnection> dbSupplier;

    public static DatabaseConnection getConnection() {
        if (connection == null) {
            synchronized (TestLazyInitialization.class) {
                if (connection == null) {
                    dbSupplier = () -> new DatabaseConnection();
                    connection = dbSupplier.get();
                }
            }
        }
        System.out.println(connection.hashCode());
        return connection;
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            executorService.submit(() -> {
                getConnection();
                connection.use();  // Simulate using the resource
            });
        }

        executorService.shutdown();

    }
}
