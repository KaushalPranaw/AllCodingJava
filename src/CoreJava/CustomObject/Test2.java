package CoreJava.CustomObject;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Test2 {
    public static void main(String[] args) {

        HashMap<Employee, String> employeeMap = new HashMap<Employee, String>();
        Employee employee1 = new Employee();
        employee1.setId(1);
        employee1.setName("Sachin");
        employee1.setDateOfBirth(new Date(1987, 2, 1));
        employee1.setSalary(new BigDecimal(100000));
        // Step 1
        employeeMap.put(employee1, "India");

        for (Map.Entry<Employee, String> employeeStringEntry : employeeMap.entrySet()) {
            System.out.println(employeeStringEntry.getKey().hashCode());
        }
        System.out.println();

        // Step 2
        // Mutating the Employee Object
        employee1.setName("Rahul");

        for (Map.Entry<Employee, String> employeeStringEntry : employeeMap.entrySet()) {
            System.out.println(employeeStringEntry.getKey().hashCode());//diff hashcode
        }
        System.out.println();
        // The HashMap key is mutated and in the wrong bucket for that hashcode.

        // Step 3
        System.out.println(employeeMap.get(employee1));
        // Returns null
        Employee employee2 = new Employee();
        employee2.setId(1);
        employee2.setName("Sachin");
        employee2.setDateOfBirth(new Date(1987, 2, 1));
        employee2.setSalary(new BigDecimal(100000));

        System.out.println(employeeMap.get(employee2));
        // Returns null
    }
}
