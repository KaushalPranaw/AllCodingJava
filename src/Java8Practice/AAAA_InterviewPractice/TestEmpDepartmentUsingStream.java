package Java8Practice.AAAA_InterviewPractice;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TestEmpDepartmentUsingStream {
    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
        employeeList.add(new Employee(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
        employeeList.add(new Employee(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
        employeeList.add(new Employee(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
        employeeList.add(new Employee(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));
        employeeList.add(new Employee(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500.0));
        employeeList.add(new Employee(177, "Manu Sharma", 35, "Male", "Infrastructure", 2010, 27000.0));
        employeeList.add(new Employee(245, "Seema Kale", 25, "Male", "Product Development", 2017, 21000.0));

        //Java 8 Lambda for Selecting Top Salary Employee for Each Department
        /*employeeList.stream().collect(Collectors.groupingBy(
                Employee::getDepartment, Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))
        )).forEach((k, v) -> System.out.println(k + " " + v.get().getSalary()));*/

        //Average Salary of Each Department
        /*employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary)))
                .forEach((k, v) -> System.out.println(k + " " + v));*/

        // Count the Number of Employees in Each Department
        /*employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()))
                .forEach((k, v) -> System.out.println(k + " : " + v));*/

        //. List Employees in Each Department
        /*employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.toList()))
                .forEach((k, v) -> System.out.println(k + " : " + v));*/

        //. List Employees Names in Each Department
        /*employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.mapping(Employee::getName, Collectors.toList())))
                .forEach((k, v) -> System.out.println(k + " : " + v));*/

        //Sort Employees by Age and Then by Name
        /*employeeList.stream()
                .sorted(Comparator.comparingInt(Employee::getAge).thenComparing(Employee::getName))
                .forEach(System.out::println);*/

        //Find the Highest Paid Employee in the Organization
        /*employeeList.stream().max(Comparator.comparingDouble(Employee::getSalary))
                .ifPresent(System.out::println);*/

        // Find the Average Age of Male and Female Employees
        /*employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getGender,
                        Collectors.averagingInt(Employee::getAge)))
                .forEach((k, v) -> System.out.println(k + " : " + v));*/

        //Find the Department with the Most Employees
        /*employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .ifPresent(System.out::println);*/

        //Find Employees Whose Salary is Above the Average Salary of Their Department
        Map<String, Double> avgSalaryByDept = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));

        employeeList.stream().filter(emp->emp.getSalary()>avgSalaryByDept.get(emp.getDepartment()))
                .forEach(System.out::println);
    }


}
