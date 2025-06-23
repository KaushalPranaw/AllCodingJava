package CoreJava.MultiThreading.EvenOddGenerator;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

public class EvenOddGeneratorUsingCompletableFuture {
    private final AtomicInteger number = new AtomicInteger(1);
    private final int max = 10;

    public void printEven() {
        while (number.get() <= max) {
            if (number.get() % 2 == 0) {
                System.out.println("Even: " + number.getAndIncrement());
            }
        }
    }

    public void printOdd() {
        while (number.get() <= max) {
            if (number.get() % 2 != 0) {
                System.out.println("Odd: " + number.getAndIncrement());
            }
        }
    }

    public static void main(String[] args) {
        EvenOddGeneratorUsingCompletableFuture obj = new EvenOddGeneratorUsingCompletableFuture();
        CompletableFuture<Void> oddFuture = CompletableFuture.runAsync(obj::printOdd);
        CompletableFuture<Void> evenFuture = CompletableFuture.runAsync(obj::printEven);

        CompletableFuture.allOf(oddFuture, evenFuture).join();
    }
}
