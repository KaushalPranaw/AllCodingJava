package Java8Practice.ExceptionHandling;

import java.util.Arrays;
import java.util.List;

public class StreamRethrowException {
    public static void main(String[] args) {
        List<String> numbers = Arrays.asList("1", "2", "a", "3");

        try {
            numbers.stream()
                    .map(number -> {
                        try {
                            return Integer.parseInt(number);
                        } catch (NumberFormatException e) {
                            throw new RuntimeException("Invalid number: " + number, e);
                        }
                    })
                    .forEach(System.out::println);
        } catch (RuntimeException e) {
            System.err.println("Exception occurred: " + e.getMessage());
        }
    }
}

