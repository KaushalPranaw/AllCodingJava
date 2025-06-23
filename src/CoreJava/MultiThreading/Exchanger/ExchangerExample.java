package CoreJava.MultiThreading.Exchanger;

import java.util.concurrent.Exchanger;

/*Exchanger in Java (in Layman's Terms)
Exchanger is like a tool that helps two threads swap information with each other.
Imagine two people standing at different ends of a room,
each holding something they want to exchange with the other person.
When both of them are ready and present,
they meet in the middle and swap their items.
The Exchanger works in a similar way —
two threads meet at a point and exchange their data at the same time.

In Java, the Exchanger class is a part of the java.util.concurrent package
and provides a simple way for two threads to exchange objects.
Both threads wait until the other is ready to exchange the data.
Once both threads are ready,
they swap their objects and continue with their tasks.

Key Concepts:
Two threads exchange information at the same time.
Each thread provides an object that it wants to exchange.
Both threads wait until the other thread is ready to exchange.
Once both threads are ready, the exchange happens and both threads continue with their work.
How the Exchanger Works:
Thread A prepares data and calls exchange() method.
Thread B does the same — it calls exchange().
Both threads wait for each other to be ready.
When both threads call exchange(), they swap their data.
Java Example Using Exchanger:
Let's say we have two threads:

Producer: Prepares some data.
Consumer: Wants to consume the data, but needs the data from the Producer.*/
public class ExchangerExample {
    public static void main(String[] args) {
        // Create an Exchanger instance
        Exchanger<String> exchanger = new Exchanger<>();

        // Create two threads: Producer and Consumer
        Thread producerThread = new Thread(new Producer(exchanger));
        Thread consumerThread = new Thread(new Consumer(exchanger));
        producerThread.start();
        consumerThread.start();
    }
}

class Producer implements Runnable {
    private final Exchanger<String> exchanger;

    public Producer(Exchanger<String> exchanger) {
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        try {
            // Producer prepares the data
            String dataToSend = "Data from Producer";

            // Exchange data with Consumer
            System.out.println("Producer is ready to exchange data");
            String receivedData = exchanger.exchange(dataToSend);
            System.out.println("Producer received data: " + receivedData);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Consumer implements Runnable {

    private final Exchanger<String> exchanger;

    public Consumer(Exchanger<String> exchanger) {
        this.exchanger = exchanger;
    }

    @Override
    public void run() {

        try {
            // Consumer prepares some data to send
            String dataToSend = "Data from Consumer";

            // Exchange data with Producer
            System.out.println("Consumer is ready to exchange data");
            String receivedData = exchanger.exchange(dataToSend);
            System.out.println("Consumer received data: " + receivedData);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
