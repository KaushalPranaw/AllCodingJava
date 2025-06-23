package Java8Practice.StreamsExercise.FlatteningData;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class TestFlatteningData {
    public static void main(String[] args) {
        Subject math = new Subject("Mathematics");
        Subject science = new Subject("Science");
        Subject english = new Subject("English");

        List<Subject> student1Subjects = Arrays.asList(math, science);
        List<Subject> student2Subjects = Arrays.asList(science, english, math);

        Student student1 = new Student("Alice", student1Subjects);
        Student student2 = new Student("Bob", student2Subjects);

        List<Student> students = Arrays.asList(student1, student2);

        //flatten subject
        Set<Subject> flattenSubjects = students.stream().flatMap(s -> s.getSubjects().stream())
                .collect(Collectors.toSet());
        System.out.println(flattenSubjects);

        Map<String, Integer> studentSubjectCountMap = students.stream().collect(Collectors.toMap(Student::getName, s -> s.getSubjects().size()));
        System.out.println(studentSubjectCountMap);
    }
}
