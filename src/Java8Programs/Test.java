package Java8Programs;

import java.util.*;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
        List<Employee> list = getEmployees();

        //1️⃣ Get employees with salary > 80,000
        /*list.stream().filter(employee -> employee.getSalary() > 80000)
                .forEach(System.out::println);*/

        //2️⃣ Get names of all employees
        /*list.stream().map(e->e.getName())
                .forEach(System.out::println);*/

        //3️⃣ Count employees in IT department
        /*long count=list.stream().filter(e->e.getDepartment().equals("IT")).count();
        System.out.println(count);*/

        //4️⃣ Get list of cities (distinct)
        /*list.stream().map(Employee::getCity).distinct()
                .forEach(System.out::println);*/

        //5️⃣ Get highest salary employee
        /*Employee emp=list.stream().max(Comparator.comparingDouble(Employee::getSalary)).orElse(null);
        System.out.println(emp);*/

        //6️⃣ Average Salary of Employees
        //double salary=list.stream().collect(Collectors.averagingDouble(Employee::getSalary));
        //double salary= list.stream().mapToDouble(Employee::getSalary).average().orElse(0);
        //System.out.println(salary);

        //7️⃣ Sum of Salary of HR Department
        /*double sum = list.stream().filter(e -> e.getDepartment().equalsIgnoreCase("HR"))
                .mapToDouble(Employee::getSalary).sum();
        System.out.println(sum);*/

        //8️⃣ Sort Employees by Salary (Descending)
        /*list.stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .forEach(System.out::println);*/

        //9️⃣ Second Highest Salary Employee
        /*Employee emp=list.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .skip(1).findFirst().orElse(null);
        System.out.println(emp);*/

        //🔟 Group Employees by Department
        /*Map<String, List<Employee>> deptEmpMap=
                list.stream().collect(Collectors.groupingBy(Employee::getDepartment));*/

        // 1️⃣1️⃣ Average Salary per Department
        /*Map<String, Double> map=list.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary)
                ));
        System.out.println(map);*/

        //1️⃣2️⃣ Highest Salary per Department
        /*Map<String, Optional<Employee>> map=list.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))
                        ));
        System.out.println(map);*/

        //1️⃣3️⃣ Count Employees per City
        /*Map<String, Long> map =list.stream()
                .collect(Collectors.groupingBy(
                        Employee::getCity,
                        Collectors.counting()
                ));
        System.out.println(map);*/

        //1️⃣4️⃣ Department → List of Employee Names
        /*Map<String, List<String>> map = list.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.mapping(Employee::getName, Collectors.toList())
                ));
        System.out.println(map);*/

        //1️⃣5️⃣ Department with Highest Total Salary
        /*Map<String, Double> totalByDept =
                list.stream()
                        .collect(Collectors.groupingBy(
                                Employee::getDepartment,
                                Collectors.summingDouble(Employee::getSalary)
                        ));
        Map.Entry<String, Double> highestDept =
                totalByDept.entrySet().stream()
                        .max(Map.Entry.comparingByValue()).orElse(null);
        System.out.println(highestDept);*/

        //1️⃣6️⃣ Partition Employees by Salary > 75k
        /*Map<Boolean, List<Employee>> map=
                list.stream()
                        .collect(Collectors.partitioningBy(e->e.getSalary()>75000));
        System.out.println(map);*/

        //1️⃣7️⃣ Top 3 Highest Paid Employees
        /*list.stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .limit(3).forEach(System.out::println);*/

        //1️⃣8️⃣ Group by City AND Department (Nested)
        /*Map<String, Map<String, List<Employee>>> map=list.stream()
                .collect(Collectors.groupingBy(
                        Employee::getCity,
                        Collectors.groupingBy(Employee::getDepartment)));
        System.out.println(map);*/

        //1️⃣9️⃣ Find Duplicate Cities
        /*Set<String> set = list.stream()
                .collect(Collectors.groupingBy(Employee::getCity, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());
        System.out.println(set);*/

        //2️⃣0️⃣ Check if All Employees Earn > 40k
        boolean allAbove40k =
                list.stream()
                        .allMatch(e -> e.getSalary() > 40000);
        System.out.println(allAbove40k);

    }

    public static List<Employee> getEmployees() {

        List<Employee> employees = Arrays.asList(

                new Employee(1, "Amit", 75000, "Delhi", "IT", 28),
                new Employee(2, "Neha", 92000, "Mumbai", "HR", 35),
                new Employee(3, "Ravi", 68000, "Delhi", "IT", 26),
                new Employee(4, "Priya", 120000, "Bangalore", "Finance", 40),
                new Employee(5, "Karan", 54000, "Mumbai", "HR", 30),
                new Employee(6, "Meena", 110000, "Pune", "IT", 38),
                new Employee(7, "Arjun", 45000, "Chennai", "Support", 24),
                new Employee(8, "Sneha", 98000, "Bangalore", "Finance", 33),
                new Employee(9, "Vikas", 83000, "Pune", "IT", 29),
                new Employee(10, "Pooja", 61000, "Delhi", "Support", 31)

        );

        return employees;
    }
}
