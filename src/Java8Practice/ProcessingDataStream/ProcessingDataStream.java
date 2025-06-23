package Java8Practice.ProcessingDataStream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
/*Implement a consumer that processes and modifies a collection of objects (e.g., list of products) and prints the results using `Consumer`.

Requirements:
     - Define a `Product` class with fields such as `name`, `price`, and `category`.
     - Create a list of `Product` objects.
     - Use `Consumer<Product>` to perform the following operations:
          - Increase the price of products based on certain criteria (e.g., category, price threshold).
          - Print the names of products after modifying them.
     - Use the `forEach()` method in a stream to process the products.

Implement a system that calculates the total value of modified products and prints it.*/
public class ProcessingDataStream {
    public static void main(String[] args) {
        List<Product> productList = new ArrayList<>(Arrays.asList(
                new Product("tv", 10000, "electronics"),
                new Product("sofa", 21000, "furniture"),
                new Product("bed", 1000, "furniture"),
                new Product("mobile", 20000, "electronics"),
                new Product("clothes", 10000, "fashion")
        ));

        final double[] total = {0};

        Consumer<Product> consumer = p -> {
            if (p.getCategory().equalsIgnoreCase("electronics")) {
                p.setPrice(p.getPrice() * 1.2);
                total[0] += p.getPrice();
                System.out.println(p);
            }
        };
        productList.forEach(consumer);
        System.out.println("Total Price : " + total[0]);
    }
}
