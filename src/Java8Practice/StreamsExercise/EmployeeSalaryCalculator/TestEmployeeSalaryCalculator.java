package Java8Practice.StreamsExercise.EmployeeSalaryCalculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TestEmployeeSalaryCalculator {
    public static void main(String[] args) {
        // Creating Employee objects
        Employee employee1 = new Employee("Alice", "Engineering", 85000);
        Employee employee2 = new Employee("Bob", "HR", 55000);
        Employee employee3 = new Employee("Charlie", "Marketing", 60000);
        Employee employee4 = new Employee("David", "Engineering", 95000);
        Employee employee5 = new Employee("Eve", "Sales", 70000);

        // Creating a list of employees
        List<Employee> employees = new ArrayList<>();
        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);
        employees.add(employee4);
        employees.add(employee5);

        //Filter employees whose salary is greater than $50,000.
        employees.stream()
                .filter(e -> e.getSalary() > 50000)
                .forEach(System.out::println);
        System.out.println();

        //Group employees by department.
        Map<String, List<Employee>> empGroupedByDepartment =
                employees.stream()
                        .collect(Collectors.groupingBy(Employee::getDepartment));
        empGroupedByDepartment.forEach((k, v) -> {
            System.out.println(k + " : ");
            System.out.println(v);
        });
        System.out.println();

        //Find the average salary in each department. (Use Collectors.averagingDouble())
        Map<String, Double> avgSalaryByDepartment = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment,
                Collectors.averagingDouble(Employee::getSalary)));
        avgSalaryByDepartment.forEach((k, v) -> {
            System.out.println(k + " : "+ v);
        });
    }
}
