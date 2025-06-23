package Java8Practice.MappingAndChaining;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
/*Implement a system that processes a list of strings and transforms them into uppercase, trims them, and calculates the length of each string using `Function`.

Requirements:
     - Create a list of strings (e.g., names or sentences).
     - Use `Function<String, String>` to:
          - Convert each string to uppercase.
          - Trim any extra spaces.
     - Use `Function<String, Integer>` to calculate the length of each string after applying the transformations.
     - Chain the functions using `andThen()` and `compose()` methods.

Implement error handling for empty strings and null values in the list.*/
public class TestMappingAndChaining {
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>(Arrays.asList("Pranaw", "Rohit", "Vijay", "Priya", "Venky", "", null));
        Function<String, String> upperTrimFunction = s -> {
            if (s == null) {
                return "";
            }
            return s.toUpperCase().trim();
        };
        Function<String, Integer> lengthFunction = s -> {
            if (s == null || s.equals("")) {
                return 0;
            }
            return s.length();
        };

        Function<String, Integer> processFunction = upperTrimFunction.andThen(lengthFunction);

        stringList.stream().map(processFunction).forEach(System.out::println);
    }
}

