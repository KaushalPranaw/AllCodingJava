package CoreJava.MultiThreading.Semaphore;
/*A semaphore is a tool that controls access to a particular resource
 in a multi-threaded environment. It works like a "counter"
 that manages how many threads can access a shared resource at the same time.
 Semaphores can be used for tasks like limiting the number of threads
 that can access a particular resource,
 or to synchronize actions across multiple threads.

In Java, the Semaphore class is part of the java.util.concurrent package.
It allows you to control access by multiple threads, using a counter
to determine how many threads can access a particular resource concurrently.*/

import java.util.concurrent.Semaphore;

//Let’s say we have a limited number of parking spots,
// and we want to limit how many cars (threads) can park at the same time.
// We use a semaphore to control access.
public class ParkingLotExample {

    // Create a Semaphore with 3 permits (3 parking spots)
    private static final Semaphore semaphore = new Semaphore(3);

    public static void main(String[] args) {
        // Simulate 5 cars trying to park
        for (int i = 1; i <= 5; i++) {
            new Thread(new Car(i)).start();
        }
    }

    static class Car implements Runnable {
        private int carNumber;

        public Car(int carNumber) {
            this.carNumber = carNumber;
        }

        @Override
        public void run() {
            try {
                System.out.println("Car " + carNumber + " is trying to park.");

                // Try to acquire a parking spot (permit)
                semaphore.acquire();
                System.out.println("Car " + carNumber + " is parked");

                // Simulate the time the car spends parked
                Thread.sleep(2000);

                // Car is leaving the parking lot, so release the permit
                System.out.println("Car " + carNumber + " is leaving.");
                semaphore.release(); // Release the parking spot (permit)
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
