package DSA2026.Java8Programs;

import java.util.*;
import java.util.stream.Collectors;

public class TestJava8Programs {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee(1, "Pranaw", "IT", 60000, 30),
                new Employee(2, "Amit", "HR", 40000, 29),
                new Employee(3, "Neha", "IT", 70000,28),
                new Employee(4, "Rohit", "Finance", 50000, 29),
                new Employee(5, "Sneha", "HR", 45000,30),
                new Employee(6, "Karan", "IT", 80000, 32)
        );
        //Group employees by department
        var a=employees.stream()
                .collect(Collectors.groupingBy(e->e.getDepartment()));
        var b=employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
        //System.out.println(a);

        Map<String, Long> count =
                employees.stream()
                        .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
        //System.out.println(count);

        //Find highest paid employee in each department
        Map<String, Optional<Employee>> highest=
                employees.stream().collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))
                ));
        //System.out.println(highest);

        //
        Map<String, Employee> result =
                employees.stream()
                        .collect(Collectors.groupingBy(
                                Employee::getDepartment,
                                Collectors.collectingAndThen(
                                        Collectors.maxBy(Comparator.comparing(Employee::getSalary)),
                                        Optional::get
                                )
                        ));
        //Find department with highest average salary
//        Optional<Map.Entry<String, Double>> result1= employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)))
//                .entrySet()
//                .stream()
//                .max(Map.Entry.comparingByValue());
//        System.out.println(result1.get());

        //Group employees by department and return only employee names
        var d=employees.stream().collect(Collectors.groupingBy(Employee::getDepartment,
                Collectors.mapping(Employee::getName, Collectors.toList())));
        System.out.println(d);






    }
}
