package Comp.GSGR_PMW3;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

public class TestStream {
    public static void main(String[] args) {
        /*var a=List.of("khushi", "pranaw", "kaushal")
                .stream();
        var b=a.filter(s->s.length()<=6);
        var c=b.toList();
        System.out.println(c);*/
        //System.out.println(b.toList());
        //System.out.println(a.toList());// stream has already been operated upon or closed


        List<Integer> input = Arrays.asList(1, 1, 1, 1, 2, 2, 3, 3, 3, 3);
        int k = 3;

        input.stream()
                .collect(Collectors.groupingBy(n -> n, LinkedHashMap::new, Collectors.toList()))
                .values()
                .stream()
                .flatMap(list -> list.stream().limit(3))
                .forEach(System.out::println);
    }
}
