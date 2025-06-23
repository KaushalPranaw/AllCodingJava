package Java8Practice.ExceptionHandling;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class StreamCustomExceptionHandling {
    public static void main(String[] args) {
        List<String> numbers = Arrays.asList("1", "2", "a", "3");
        numbers.stream()
                .map(handleException(number -> {
                    if (!number.matches("\\d+")) {
                        throw new CustomException("Not a valid number: " + number);
                    }
                    return Integer.parseInt(number);
                })).forEach(System.out::println);
    }

    private static <T, R> Function<T, R> handleException(ThrowingFunction<T, R> function) {
        return input -> {
            try {
                return function.apply(input);
            } catch (Exception e) {
                System.err.println("Exception: " + e.getMessage());
                return null; // Return null or any default value
            }
        };
    }

    @FunctionalInterface
    public interface ThrowingFunction<T, R> {
        R apply(T t) throws Exception;
    }

}
