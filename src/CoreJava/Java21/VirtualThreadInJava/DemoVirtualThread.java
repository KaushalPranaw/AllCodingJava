package CoreJava.Java21.VirtualThreadInJava;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class DemoVirtualThread {
    public static void main(String[] args) {
        //Using Thread API (Java 21+)
        Thread virtualThread=Thread.ofVirtual().start(()->{
            System.out.println("Running in virtual thread");
        });
        try {
            //virtualThread.join();// wait for virtual thread to finish
            //or
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //using executor service
        try(ExecutorService executorService= Executors.newVirtualThreadPerTaskExecutor()){
            executorService.submit(()->{
                System.out.println("Virtual thread using executor service");
            });
            //Each task gets its own virtual thread
        }

        //Using Thread Factory
        ThreadFactory threadFactory=Thread.ofVirtual().factory();
        Thread thread=threadFactory.newThread(()->{
            System.out.println("virtual thread using factory");
        });
        thread.start();
    }

    //Spring Boot 3.2+ supports virtual threads easily:
    //spring.threads.virtual.enabled=true

}
