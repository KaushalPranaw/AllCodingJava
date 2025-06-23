package CoreJava.MemoryManagement;

public class Person {
    private String name;
    private int yearOfBirth;
    private boolean lovesJava;
    private Address address;

    public Person() {
    }

    public Person(String name, int yearOfBirth, boolean lovesJava, Address address) {
        this.name = name;
        this.yearOfBirth = yearOfBirth;
        this.lovesJava = lovesJava;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public boolean isLovesJava() {
        return lovesJava;
    }

    public void setLovesJava(boolean lovesJava) {
        this.lovesJava = lovesJava;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", yearOfBirth=" + yearOfBirth +
                ", lovesJava=" + lovesJava +
                ", address=" + address +
                '}';
    }
}
