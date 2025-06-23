package Java8Practice.StreamsExercise.ComplexFilteringAndGrouping;

import java.util.*;
import java.util.stream.Collectors;

public class TestComplexFilteringAndGrouping {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product(1, "Laptop", "Electronics", 800.00));
        products.add(new Product(4, "cover", "Electronics", 80.00));
        products.add(new Product(2, "Shirt", "Clothing", 125.50));
        products.add(new Product(3, "Coffee Maker", "Appliances", 150.00));

        Map<String, List<Product>> groupedProductByCategory = products.stream()
                .filter(product -> product.getPrice() > 50)
                .filter(product -> product.getCategory().equalsIgnoreCase("Electronics"))
                .sorted(Comparator.comparingDouble(Product::getPrice).reversed())
                .collect(
                        Collectors.groupingBy(
                                product -> product.getCategory(),
                                LinkedHashMap::new,
                                Collectors.toList()
                        )
                );

        Map<String, Double> totalPricePerCategory = groupedProductByCategory.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry ->
                                /*(Double) entry.getValue()
                                        .stream().mapToDouble(Product::getPrice).sum()*/
                                entry.getValue()
                                        .stream()
                                        .collect(Collectors.summingDouble(Product::getPrice))
                ));

        System.out.println("Grouped Products by Category:");
        groupedProductByCategory.forEach((category, productList) -> {
            System.out.println("Category: " + category);
            productList.forEach(System.out::println);
        });

        // Print the total price per category
        System.out.println("\nTotal Price per Category:");
        totalPricePerCategory.forEach((category, totalPrice) ->
                System.out.println(category + ": $" + totalPrice)
        );
    }
}
