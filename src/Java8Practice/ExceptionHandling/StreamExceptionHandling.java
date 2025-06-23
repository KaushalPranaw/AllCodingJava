package Java8Practice.ExceptionHandling;

import java.util.Arrays;
import java.util.List;

public class StreamExceptionHandling {
    /*
            Output:
            1
            2
            0
            3
            Invalid number: a
        */
    /*public static void main(String[] args) {
        List<String> numbers = Arrays.asList("1", "2", "a", "3");

        numbers.stream()
                .map(number -> {
                    try {
                        return Integer.parseInt(number);
                    } catch (NumberFormatException e) {
                        System.err.println("Invalid number: " + number);
                        return 0;
                    }
                }).forEach(System.out::println);
    }*/

    public static void main(String[] args) {
        List<String> numbers = Arrays.asList("1", "2", "a", "3");

        numbers.stream()
                .map(StreamExceptionHandling::safeParse)
                .forEach(System.out::println);
    }

    private static Integer safeParse(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            System.err.println("Invalid number: " + number);
            return 0; // Default value
        }
    }
}
