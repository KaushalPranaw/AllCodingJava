package Java8Practice.StreamsExercise.ProductReviewRating;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class TestProductReviewRating {
    public static void main(String[] args) {
        // Creating a list of ProductReview objects
        List<ProductReview> reviews = Arrays.asList(
                new ProductReview("Laptop", 5, LocalDate.of(2023, 6, 15)),
                new ProductReview("Smartphone", 4, LocalDate.of(2023, 7, 20)),
                new ProductReview("Laptop", 3, LocalDate.of(2023, 8, 5)),
                new ProductReview("Smartphone", 5, LocalDate.of(2023, 6, 30)),
                new ProductReview("Headphones", 4, LocalDate.of(2023, 9, 10))
        );

        //Get all reviews with a score above 4.
        reviews.stream().filter(review -> review.getReviewScore() > 4)
                .forEach(System.out::println);

        //Calculate the average review score for a specific product.
        String product = "Laptop";
        double avgReviewScore = reviews.stream().filter(productReview -> productReview.getProductName().equals(product))
                .collect(Collectors.averagingInt(r -> r.getReviewScore()));
        System.out.println(avgReviewScore);

        //Find the latest review for each product. (Use Collectors.maxBy())
        Map<String, Optional<ProductReview>> latestReviewByProductName = reviews.stream().collect(Collectors.groupingBy(ProductReview::getProductName,
                Collectors.maxBy(Comparator.comparing(ProductReview::getReviewDate))));

        System.out.println("\nLatest review for each product:");
        latestReviewByProductName.forEach((p, review) -> {
            System.out.println(p + ": " + review.orElse(null));
        });


    }
}
