package Java8Practice.SortingObjects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
/*Implement a system that sorts a list of objects (e.g., students) based on various attributes using `Function` and `Comparator`.

Requirements:
     - Define a `Student` class with fields such as `name`, `age`, `grade`.
     - Create a list of `Student` objects.
     - Use `Comparator.comparing()` along with `Function<Student, Integer>` to sort the students by:
          - Age.
          - Grade.
     - Use `Comparator.thenComparing()` to sort by multiple criteria (e.g., sort by age, then by grade).

Implement sorting in both ascending and descending order, and allow dynamic selection of sorting criteria.*/
public class SortingObjects {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>(Arrays.asList(
                new Student("pranaw", 22, "B"),
                new Student("rohit", 22, "A"),
                new Student("sita", 32, "C"),
                new Student("laxman", 42, "D"),
                new Student("ram", 29, "A")
        ));

        /*Comparator<Student> ageComparator=(s1, s2)->s1.getAge()-s2.getAge();
        Comparator<Student> gradeComparator=(s1, s2)->s1.getGrade().compareTo(s2.getGrade());
        students.stream().sorted(ageComparator.thenComparing(gradeComparator))
                .forEach(System.out::println);
        */

        Function<Student, Integer> ageFunction = (s) -> s.getAge();

        Function<Student, String> gradeFunction = s -> s.getGrade();

        Comparator<Student> ageComparator = (s1, s2) -> s1.getAge() - s2.getAge();
        Comparator<Student> gradeComparator = (s1, s2) -> s1.getGrade().compareTo(s2.getGrade());
        students.stream().sorted(Comparator.comparing(ageFunction).thenComparing(gradeFunction).reversed())
                .forEach(System.out::println);
    }
}
