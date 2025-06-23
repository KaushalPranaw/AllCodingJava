package CoreJava.OOPS.pillars.polymorphism;


import java.util.List;

class Person {
    String name;

    public Person(String name) {
        this.name = name;
    }
}

// Subclass
class Employee extends Person {
    public Employee(String name) {
        super(name);
    }
}

// Define a subclass of Employee
class Manager extends Employee {
    public Manager(String name) {
        super(name);
    }
}

public class TypePromotion {
    /*void show(int x) {
        System.out.println("int: " + x);
    }

    void show(double x) {
        System.out.println("double: " + x);
    }
*/
    /*void show(String s) {
        System.out.println("String: " + s);
    }*/

    /*void show(Object o){
        System.out.println("Object: " + 0);
    }*/

    <T extends Employee> void show(List<T> list) {
        for (T item : list) {
            System.out.println("Employee: " + item.name);
        }
    }

    void showDetails(List<? super Employee> list) {
        // Adding Employee or its subclasses to the list
        list.add(new Employee("John"));
        list.add(new Manager("Alice"));
        //list.add(new Person("shjskl"));

        // Iterating over the list (Objects need to be cast for use)
        for (Object obj : list) {
            if (obj instanceof Person) {
                Person person = (Person) obj;
                System.out.println("Person Name: " + person.name);
            }
        }
    }

    public static void main(String[] args) {
        TypePromotion tp = new TypePromotion();

        /*tp.show(5);         // Calls show(int)
        tp.show(5.5);       // Calls show(double)
        tp.show('A');       // 'A' promoted to int, calls show(int)
        tp.show(5L);        // long promoted to double, calls show(double)
*/


        // Create a list of Employee objects
        List<Employee> employees = List.of(
                new Employee("John"),
                new Employee("Jane")
        );

        List<Integer> list=List.of(1,2,3,4);
        List<Manager> managers = List.of(
                new Manager("Alice"),
                new Manager("Bob")
        );
        tp.show(employees);
        //tp.show(list);
        tp.show(managers);

    }
}

