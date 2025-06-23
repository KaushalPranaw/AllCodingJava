package Java8Practice.StreamsExercise.GroupingAndPartitioning;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TestGroupingAndPartitioning {
    public static void main(String[] args) {
        // Create a list of Employee objects
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Alice", 25, 50000.0));
        employees.add(new Employee("Bob", 30, 60000.0));
        employees.add(new Employee("Charlie", 35, 70000.0));
        employees.add(new Employee("Diana", 40, 80000.0));

        //Use `Collectors.groupingBy()` to group employees by age range (e.g., below 30, 30-40, above 40).
        Map<String, List<Employee>> ageRangeEmployeeMap = employees.stream().collect(Collectors.groupingBy(e -> {
            if (e.getAge() < 30) {
                return "below 30";
            } else if (e.getAge() >= 30 && e.getAge() <= 40) {
                return "30-40";
            } else {
                return "above 40";
            }
        }));
        System.out.println(ageRangeEmployeeMap);

        //Use `Collectors.partitioningBy()` to partition employees into two groups
        // based on whether their salary is greater than a certain threshold.
        double salaryThreshold = 60000.0;
        Map<Boolean, List<Employee>> twoGroups = employees.stream()
                .collect(Collectors.partitioningBy(e -> e.getSalary() > salaryThreshold));
        System.out.println(twoGroups);

        //For each partition or group, calculate the average salary
        // using `Collectors.averagingDouble()

        Map<String, Double> avgSalaryByGroup = employees.stream()
                .collect(Collectors.groupingBy(
                        e -> {
                            if (e.getAge() < 30) {
                                return "below 30";
                            } else if (e.getAge() >= 30 && e.getAge() <= 40) {
                                return "30-40";
                            } else {
                                return "above 40";
                            }
                        },
                        Collectors.averagingDouble(e -> e.getSalary())
                ));
        System.out.println();
        System.out.println(avgSalaryByGroup);

        Map<Boolean, Double> avgSalaryInTwoParts =
                employees.stream().collect(
                        Collectors.partitioningBy(
                                e -> e.getSalary() > salaryThreshold,
                                Collectors.averagingDouble(Employee::getSalary)
                        )
                );
        System.out.println();
        System.out.println(avgSalaryInTwoParts);
    }
}
