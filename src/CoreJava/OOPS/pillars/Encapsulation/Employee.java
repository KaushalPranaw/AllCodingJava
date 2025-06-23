package CoreJava.OOPS.pillars.Encapsulation;

public class Employee {
    private int id;
    private String name;
    private double salary;

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

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }

    public static void main(String[] args) {
        Employee e1=new Employee();
        Employee e2=new Employee();
        e1.setId(1);
        e1.setName("pranaw");
        e1.setSalary(1000.0);

        e2.setSalary(200);
        System.out.println(e1);
        System.out.println(e2);



    }
}
