package Java8Practice.FilteringCollection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
/*Create a program that filters a list of employees based on various conditions using the `Predicate` functional interface.

Requirements:
     - Define an `Employee` class with fields such as `name`, `age`, `salary`, etc.
     - Create a list of `Employee` objects.
     - Use `Predicate<Employee>` to filter employees based on different conditions:
          - Age greater than 30.
          - Salary greater than a certain threshold.
          - Employees with a name that starts with a particular letter.
     - Use `Predicate.and()`, `Predicate.or()`, and `Predicate.negate()` to combine multiple conditions.

Allow users to enter the filter condition dynamically (e.g., through input) and apply it.*/
public class TestFilteringCollection {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>(Arrays.asList(
                new Employee("pranaw", 25, 1000.0),
                new Employee("rohit", 26, 5000.0),
                new Employee("prem", 50, 10000.0)
        ));

        Predicate<Employee> predicate1 = e -> e.getAge() > 30;
        Predicate<Employee> predicate2 = e -> e.getSalary() > 3000;
        Predicate<Employee> predicate3 = e -> e.getName().startsWith("p");
        employees.stream().filter(predicate1.and(predicate2).and(predicate3)).forEach(System.out::println);
    }
}
