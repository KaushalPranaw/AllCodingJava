package Comp.Amway;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TestStream {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee(1, "John", "IT", 50000),
                new Employee(2, "Jane", "HR", 60000),
                new Employee(3, "Jack", "IT", 70000),
                new Employee(4, "Jill", "Finance", 80000)
        );

        // Filter employees belonging to IT department
        /*employees.stream().filter(emp->emp.getDepartment().equals("IT"))
                .forEach(System.out::println);*/

        //How to find the employee with the highest salary?
        /*employees.stream().max(Comparator.comparingDouble(Employee::getSalary))
                .ifPresent(System.out::println);*/

        //How to calculate the total salary of all employees?
        //double sum=employees.stream().collect(Collectors.summingDouble(Employee::getSalary));
        /*double sum= employees.stream().mapToDouble(Employee::getSalary).sum();
        System.out.println(sum);*/

        //How to group employees by department?
        /*employees.stream().collect(Collectors.groupingBy(Employee::getDepartment))
                .forEach((k,v)-> System.out.println(k+" "+v));*/

        //How to sort employees by salary in descending order?
        /*employees.stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .forEach(System.out::println);*/

        // How to count the number of employees in each department?
        /*employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()))
                .forEach((k,v)-> System.out.println(k+" : "+v));*/

        //How to convert a List of employees to a Map with employee ID as key?
        /*Map<Integer, Employee> map=employees.stream().collect(Collectors.toMap(Employee::getId, Function.identity()));
        System.out.println(map);*/

        //How to find the average salary of employees in each department?
        //employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary))).forEach((k, v) -> System.out.println(k + " " + v));

        //Finding Highest Salary Employee Name in Each Department
        /*employees.stream().collect(Collectors.groupingBy(Employee::getDepartment,
                Collectors.collectingAndThen(
                        Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)),
                        employee -> employee.map(Employee::getName).orElse("No Emp")
                )))
                .forEach((k, v) -> System.out.println(k + " " + v));*/

        //Grouping Employees by Department with Names
        /*employees.stream().collect(Collectors.groupingBy(Employee::getDepartment,
                Collectors.mapping(Employee::getName, Collectors.toList())))
                .forEach((k, v) -> System.out.println(k + " " + v));*/

        // Using reduce() to calculate total salary
        /*System.out.println(employees.stream().map(Employee::getSalary)
                .reduce(0.0, Double::sum));*/

        //Finding Maximum or Minimum:
        /*employees.stream().reduce((e1, e2) -> e1.getSalary() > e2.getSalary() ? e1 : e2)
                .ifPresent(System.out::println);*/

        //Concatenating Strings:
        /*System.out.println(employees.stream().map(Employee::getName)
                .reduce("", (n1, n2) -> n1 + n2 + ","));*/

        //Example: Separate Odd and Even Numbers
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        numbers.stream().collect(Collectors.partitioningBy(num -> num % 2 == 0)).forEach((k, v) -> System.out.println(k + ":" + v));
    }
}
