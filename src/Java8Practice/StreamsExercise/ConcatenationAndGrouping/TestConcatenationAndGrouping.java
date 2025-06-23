package Java8Practice.StreamsExercise.ConcatenationAndGrouping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TestConcatenationAndGrouping {
    public static void main(String[] args) {
        List<Book> books = new ArrayList<>(
                Arrays.asList(
                        new Book("The Great Gatsby", "F. Scott Fitzgerald", "Fiction"),
                        new Book("To Kill a Mockingbird", "Harper Lee", "Classic"),
                        new Book("1984", "George Orwell", "Dystopian"),
                        new Book("The Catcher in the Rye", "J.D. Salinger", "Classic"),
                        new Book("The Hobbit", "J.R.R. Tolkien", "Fantasy")
                )
        );

        Map<String, List<Book>> groupByGenre = books.stream()
                .collect(Collectors.groupingBy(Book::getGenre));
        System.out.println(groupByGenre);
        System.out.println();

        Map<String, String> genreTitleMap = books.stream()
                .collect(Collectors.groupingBy(
                        Book::getGenre,
                        Collectors.mapping(
                                Book::getTitle,
                                Collectors.joining(", ")
                        )
                ));
        System.out.println(genreTitleMap);
        System.out.println();

        genreTitleMap.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(entry ->
                        System.out.println("Genre: " + entry.getKey() + " | Titles: " + entry.getValue())
                );
    }
}
