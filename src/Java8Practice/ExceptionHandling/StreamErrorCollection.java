package Java8Practice.ExceptionHandling;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class StreamErrorCollection {
    public static void main(String[] args) {
        List<String> numbers = Arrays.asList("1", "2", "a", "3");
        Map<Boolean, List<Integer>> partitioned=numbers.stream()
                .map(num->{
                    try {
                        return Integer.parseInt(num);
                    } catch (NumberFormatException e){
                        return null;
                    }
                }).collect(Collectors.partitioningBy(Objects::nonNull));

        System.out.println("Valid numbers: " + partitioned.get(true));
        System.out.println("Invalid numbers: " + partitioned.get(false));

    }
}
