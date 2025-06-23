package Comp.FirstDerivatives;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TestStream {
    public static void main(String[] args) {
        List<String> input = Arrays.asList("Uttam", "Abhimanyu", "Abhishek");
        String prefix = "Ut";
        System.out.println(filterAndCountDistinct(input, prefix));

        System.out.println(IntStream.range(0, 100).parallel().findAny());

    }

    //Given a list of strings.Filter out names starting with given prefix.Count total distinct elements in filtered names and return a Map<String,Integer>
    //Sample Input: ["Uttam","Abhimanyu","Abhishek"] prefix:"Ut"
    //output: [ ["uttam",4]]
    public static Map<String, Long> filterAndCountDistinct(List<String> names, String prefix) {
        return names.stream()
                .filter(name -> name.startsWith(prefix))
                .collect(Collectors.toMap(String::toLowerCase, name -> name.toLowerCase().chars().distinct().count()));
    }
}