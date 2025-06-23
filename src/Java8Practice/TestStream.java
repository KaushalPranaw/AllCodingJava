package Java8Practice;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestStream {
    public static void main(String[] args) {
        /*List<Integer> list = List.of(1, 3, 5, 32, 10, 1, 5);
        list.stream().collect(Collectors.toMap(Function.identity(), num->1L, Long::sum, HashMap::new))
                .entrySet()
                .forEach(System.out::println);*/
        /*Stream<Integer> infiniteStream = Stream.iterate(0, i -> i + 1);
        infiniteStream.forEach(System.out::println);*/


        List<Integer> arr = List.of(1, 2, 3, 4, 5, 6, 7);
        arr.stream().sorted(Collections.reverseOrder()).skip(1).findFirst().ifPresent(System.out::println);

    }
}
