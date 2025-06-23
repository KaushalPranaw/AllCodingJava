package Java8Practice.StreamsExercise.NestedDataAggregation;

import java.util.*;
import java.util.stream.Collectors;

public class TestNestedDataAggregation {
    public static void main(String[] args) {

        // IT Department
        List<Employee> itEmployees = Arrays.asList(
                new Employee("John Doe", 40000),
                new Employee("Jane Smith", 70000),
                new Employee("Mark Lee", 175000)
        );
        Department itDept = new Department("IT", itEmployees);

        // HR Department
        List<Employee> hrEmployees = Arrays.asList(
                new Employee("Mary Johnson", 55000),
                new Employee("Susan Lee", 60000)
        );
        Department hrDept = new Department("HR", hrEmployees);

        // Marketing Department
        List<Employee> marketingEmployees = Arrays.asList(
                new Employee("Peter Clark", 65000),
                new Employee("Jessica Brown", 70000)
        );
        Department marketingDept = new Department("Marketing", marketingEmployees);

        // Finance Department
        List<Employee> financeEmployees = Arrays.asList(
                new Employee("Robert White", 80000),
                new Employee("Linda Green", 85000)
        );
        Department financeDept = new Department("Finance", financeEmployees);

        // Add departments to the list
        List<Department> departments = new ArrayList<>(
                Arrays.asList(
                        itDept, hrDept, marketingDept, financeDept
                )
        );

        Set<Employee> totalEmployees = departments.stream()
                .flatMap(department -> department.getEmployees().stream())
                .collect(Collectors.toSet());
        System.out.println(totalEmployees);

        double totalSalary = totalEmployees.stream()
                .reduce(0.0, (total, emp) -> total + emp.getSalary(), Double::sum);

        System.out.println(totalSalary);

        Map<String, List<Employee>> employeeRange = totalEmployees.stream()
                .collect(Collectors.groupingBy(emp -> {
                    if (emp.getSalary() < 50000) {
                        return "Below 50k";
                    } else if (emp.getSalary() >= 50000 && emp.getSalary() < 100000) {
                        return "Between 50k-100k";
                    } else {
                        return ">100k";
                    }
                }));
        employeeRange.forEach((range, employees) ->
                employees.sort(Comparator.comparing(Employee::getName))
        );
        System.out.println(employeeRange);
    }
}
