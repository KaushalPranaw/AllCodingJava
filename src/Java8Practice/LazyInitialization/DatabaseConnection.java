package Java8Practice.LazyInitialization;

public class DatabaseConnection {

    public DatabaseConnection() {
        try {
            Thread.sleep(2000);
            System.out.println("Database connection created!");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void use() {
        System.out.println("Using Database Connection...");
    }

}
