package CoreJava.MultiThreading.ConcurrencyProblems;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DiningPhilosophers {
    private static final int NUM_PHILOSOPHERS = 5;

    public static void main(String[] args) {
        Philosopher[] philosophers = new Philosopher[NUM_PHILOSOPHERS];
        Fork[] forks = new Fork[NUM_PHILOSOPHERS];

        //initialize fork
        for (int i = 0; i < NUM_PHILOSOPHERS; i++) {
            forks[i] = new Fork();
        }

        // Initialize philosophers
        for (int i = 0; i < NUM_PHILOSOPHERS; i++) {
            Fork leftFork = forks[i];
            Fork rightFork = forks[(i + 1) % NUM_PHILOSOPHERS];

            // Avoid deadlock by reversing the order for the last philosopher
            if (i == NUM_PHILOSOPHERS - 1) {
                philosophers[i] = new Philosopher(i, rightFork, leftFork);
            } else {
                philosophers[i] = new Philosopher(i, leftFork, rightFork);
            }
            new Thread(philosophers[i], "Philosopher " + (i + 1)).start();
        }

    }

    static class Fork {
        private final Lock lock = new ReentrantLock();

        public void pickUp() {
            lock.lock();
        }

        public void putDown() {
            lock.unlock();
        }

    }

    static class Philosopher implements Runnable {
        private final int id;
        private final Fork leftFork;
        private final Fork rightFork;

        public Philosopher(int id, Fork leftFork, Fork rightFork) {
            this.id = id;
            this.leftFork = leftFork;
            this.rightFork = rightFork;
        }

        @Override
        public void run() {
            try {
                while (true) {
                    think();
                    eat();
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Philosopher " + id + " was interrupted.");
            }

        }

        private void think() throws InterruptedException {
            System.out.println("Philosopher " + id + " is thinking.");
            Thread.sleep((int) (Math.random() * 1000));
        }

        private void eat() throws InterruptedException {
            // Pick up forks
            leftFork.pickUp();
            System.out.println("Philosopher " + id + " picked up left fork.");

            rightFork.pickUp();
            System.out.println("Philosopher " + id + " picked up right fork.");

            // Eat
            System.out.println("Philosopher " + id + " is eating.");
            Thread.sleep((int) (Math.random() * 1000));

            rightFork.putDown();
            System.out.println("Philosopher " + id + " put down right fork.");

            leftFork.putDown();
            System.out.println("Philosopher " + id + " put down left fork.");
        }


    }
}
