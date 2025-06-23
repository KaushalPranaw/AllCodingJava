package CoreJava.MultiThreading.CompletableFuture;

/*
CompletableFuture is a way to run tasks asynchronously (i.e., in the background)
and complete them at some point in the future.
The main idea is that a task can be started,
and you don't have to wait for it to finish right away —
the program can continue doing other things while waiting.
When the task is done, the result can be used.

Think of it like ordering food from a restaurant.
You place an order (start an asynchronous task),
and while you're waiting for your food (the task to finish),
you can do other things (like chatting with friends or looking at your phone).
Once the food is ready, the restaurant calls you to pick it up (the task is completed).

In Java, the CompletableFuture class allows you to handle this situation easily. You can start a task and set up things to do when the task is done.

Key Concepts:
Asynchronous Task: A task that is executed in the background,
so the main program doesn't wait for it to finish.

Completing the Task: The task might take time, and when it's finished,
it can provide a result. The CompletableFuture is used to represent the eventual result of that task.

Chaining: You can set up what should happen once the task is complete,
and you can chain multiple actions.

How CompletableFuture Works:
Start a Task Asynchronously: You can initiate a task to run in the background.
Use the Result Once It’s Done: You can define what to do once the task is complete, like processing the result or handling any errors.
Chaining: You can link multiple tasks together, so once one task is done, another one starts.

*/

import java.util.concurrent.CompletableFuture;

//Let’s see a simple example where we simulate making a coffee.
// The task of making coffee will take some time,
// but while the coffee is being made, we can do other things.
// Once the coffee is made, we'll handle the result (the coffee is ready).
public class CompletableFutureExample {
    public static void main(String[] args) {
        // Step 1: Start the coffee-making task asynchronously
        CompletableFuture<String> coffeeMakingFuture =
                CompletableFuture.supplyAsync(() -> {
                    //// Simulate making coffee, takes 2 seconds
                    System.out.println("Making coffee...");
                    try {
                        Thread.sleep(2000); // Simulating time to make coffee
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return "Coffee is ready!";
                });

        // Step 2: Do other work while the coffee is being made
        System.out.println("You can do other tasks while waiting for coffee...");

        // Step 3: Once coffee is ready, handle the result
        coffeeMakingFuture.thenAccept(coffee -> {
            System.out.println(coffee); // Print "Coffee is ready!"
        });

        // To prevent main thread from finishing before the coffee task is done
        try {
            Thread.sleep(3000); // Wait long enough for the coffee-making task to finish
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
