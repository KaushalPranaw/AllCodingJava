package Java8Practice;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

class Employee {
    private String name;
    private String departmentName;
    private double salary;

    // Constructor, getters, and setters
    public Employee(String name, String departmentName) {
        this.name = name;
        this.departmentName = departmentName;
    }

    public Employee(String name, String departmentName, double salary) {
        this.name = name;
        this.departmentName = departmentName;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public String getDepartmentName() {
        return departmentName;
    }
}

public class Practice {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3,3, 4, 5, 6, 7, 9, 8, 10);

        //print even numbers
        /*numbers.stream().filter(num->num%2==0)
                .forEach(System.out::println);*/

        //sum of all nums
        System.out.println(numbers.stream().mapToInt(num-> num)
                .sum());
        System.out.println(numbers.stream().reduce(0, Integer::sum));

        //sort in desc order
        /*numbers.stream().sorted((a,b)->Integer.compare(b, a))
                .forEach(System.out::println);*/

        //find first non repeating char
        /*String s = "pranawp";
        System.out.println(s.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(' '));*/

        //find duplicate elements
        numbers.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry->entry.getValue()>1)
                .map(Map.Entry::getKey)
                .forEach(System.out::println);




        //String text = "hello world hello everyone in the world";
//        System.out.println(Arrays.stream(text.split(" "))
//                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting())));

        //Reverse a String Using Streams
        String input = "streams";
        /*System.out.println(input.chars()
                .mapToObj(c->(char)c)
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                .reverse());*/
        /*String reverse=input.chars()
                .mapToObj(c -> String.valueOf((char) c))
                .collect(Collectors.toCollection(ArrayList::new)) // Collect to ArrayList
                .stream() // Stream again for reversing
                .reduce((first, second) -> (second + first)) // Concatenate in reverse order
                .orElse(""); // Han
        System.out.println(reverse);*/

        // Flatten a List of Lists
        /*List<List<String>> nestedList = Arrays.asList(
                Arrays.asList("A", "B"),
                Arrays.asList("C", "D"),
                Arrays.asList("E", "F")
        );
        nestedList.stream().flatMap(l->l.stream())
                .forEach(System.out::println);*/

        //Find All Palindromes in a List
        /*List<String> words = Arrays.asList("level", "world", "radar", "java", "civic", "stream");
        words.stream().filter(s -> new StringBuilder(s).reverse().toString().equals(s))
                .forEach(System.out::println);*/

        //Group Numbers by Even and Odd
        /*List<Integer> numbers = Arrays.asList(2, 7, 10, 15, 21, 30, 42);
        System.out.println(numbers.stream()
                .collect(Collectors.partitioningBy(num -> num % 2 == 0, Collectors.toList())));
*/
        //Find the Longest String in a List
        /*List<String> strings = Arrays.asList("apple", "banana", "cherry", "date", "elderberry");
        System.out.println(strings.stream()
                .max(Comparator.comparingInt(String::length))
                .orElse("No string found"));*/

        //You can achieve this using Java 8 Streams to group employees by their department name and then return a list of employees' names for each department.
        /*List<Employee> employees = Arrays.asList(
                new Employee("John", "HR"),
                new Employee("Sarah", "IT"),
                new Employee("Mike", "HR"),
                new Employee("Anna", "Finance"),
                new Employee("James", "IT")
        );
        System.out.println(employees.stream()
                .collect(
                        Collectors.groupingBy
                                (
                                        Employee::getDepartmentName,
                                        Collectors.mapping(
                                                Employee::getName,
                                                Collectors.toList()
                                        )
                                )
                )
        );*/

        //group employee by salary range
        /*List<Employee> employees = Arrays.asList(
                new Employee("John", "HR", 1000),
                new Employee("Sarah", "IT", 900),
                new Employee("Mike", "HR", 2000),
                new Employee("Anna", "Finance", 3000),
                new Employee("James", "IT", 2500)
        );

        employees.stream()
                .collect(Collectors.groupingBy(emp->{
                    if(emp)
                }))*/

    }
}
