package Java8Practice.StreamsExercise.DebuggingStreams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TestDebuggingStreams {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>(Arrays.asList(
                new Product(1, "Tv", 1000.0),
                new Product(2, "mobile", 5000),
                new Product(3, "shirt", 100),
                new Product(5, "pant", 150)
        ));
        //Use `Stream.peek()` to print out the product name at various stages of a stream pipeline (e.g., after filtering, after mapping)
        List<String> result = products.stream()
                .filter(p -> p.getPrice() > 200) // Filter products with price > 200
                .peek(p -> System.out.println("After filtering: " + p)) // Log products after filtering
                .map(Product::getName) // Map to product names
                .peek(name -> System.out.println("After mapping: " + name)) // Log product names after mapping
                .collect(Collectors.toList()); // Collect the final results

        System.out.println("Final Result: " + result);
    }
}
