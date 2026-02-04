package Java8Programs;

public class Employee {
    private int id;
    private String name;
    private double salary;
    private String city;
    private String department;
    private int age;

    public Employee() {
    }

    public Employee(int id, String name, double salary, String city, String department, int age) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.city = city;
        this.department = department;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", city='" + city + '\'' +
                ", department='" + department + '\'' +
                ", age=" + age +
                '}';
    }
}
