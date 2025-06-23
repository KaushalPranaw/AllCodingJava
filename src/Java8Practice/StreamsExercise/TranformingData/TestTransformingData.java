package Java8Practice.StreamsExercise.TranformingData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TestTransformingData {
    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>(Arrays.asList(
                new Person("pranaw", 28),
                new Person("rahul", 49),
                new Person("rohit", 21),
                new Person("mahima", 38),
                new Person("archana", 18)
        ));

        List<String> list = personList.stream()
                .filter(person -> person.getAge() > 30)
                .map(person -> person.getName())
                .map(name -> name.toUpperCase())
                .collect(Collectors.toList());

        System.out.println(list);

    }
}
