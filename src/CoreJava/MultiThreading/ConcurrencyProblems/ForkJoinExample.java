package CoreJava.MultiThreading.ConcurrencyProblems;

import java.util.concurrent.RecursiveTask;
import java.util.concurrent.ForkJoinPool;

class SumTask extends RecursiveTask<Integer> {
    private static final int THRESHOLD = 5; // The minimum size to split further
    private int[] array;
    private int start, end;

    public SumTask(int[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        if (end - start <= THRESHOLD) {
            // Small enough task, compute directly
            int sum = 0;
            for (int i = start; i < end; i++) {
                sum += array[i];
            }
            return sum;
        } else {
            // Split the task
            int mid = (start + end) / 2;
            SumTask leftTask = new SumTask(array, start, mid);
            SumTask rightTask = new SumTask(array, mid, end);

            // Fork subtasks
            leftTask.fork();
            rightTask.fork();

            // Join results
            int leftResult = leftTask.join();
            int rightResult = rightTask.join();

            // Combine results
            return leftResult + rightResult;
        }
    }
}

public class ForkJoinExample {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        ForkJoinPool pool = new ForkJoinPool();

        SumTask task = new SumTask(numbers, 0, numbers.length);
        int result = pool.invoke(task); // Start the task

        System.out.println("Total sum: " + result); // Output: Total sum: 55

        System.out.println(Runtime.getRuntime().availableProcessors());
    }
}

