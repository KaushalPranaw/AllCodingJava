package Java8Practice.StreamsExercise.SortingComplexObject;

import Java8Practice.StreamsExercise.ComplexFilteringAndGrouping.Product;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TestSortingComplexObject {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product(1, "Laptop", "Electronics", 800.00));
        products.add(new Product(4, "cover", "Electronics", 80.00));
        products.add(new Product(2, "Shirt", "Clothing", 125.50));
        products.add(new Product(3, "Coffee Maker", "Appliances", 150.00));

        List<Product> sortedProducts = products.stream().sorted(Comparator.comparing(Product::getCategory).thenComparingDouble(Product::getPrice).reversed())
                .toList();
        System.out.println("Sorted Products:");
        sortedProducts.forEach(System.out::println);

        // Custom comparator for case-insensitive sorting by product name
        Comparator<Product> caseInsensitiveNameComparator = (p1, p2) ->
                p1.getName().toLowerCase().compareTo(p2.getName().toLowerCase());

        List<Product> nameSortedProducts = products.stream()
                .sorted(caseInsensitiveNameComparator)
                .toList();

        System.out.println("\nProducts Sorted by Name (Case-Insensitive):");
        nameSortedProducts.forEach(System.out::println);
    }
}
