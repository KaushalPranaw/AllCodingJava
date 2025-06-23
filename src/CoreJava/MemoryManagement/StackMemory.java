package CoreJava.MemoryManagement;

public class StackMemory {
    public static void main(String[] args) {
        //stack memory
        int x=3;
        double y=2.9;
        boolean b=false;
        final int xy=55;

        // stack and heap
        Person p=new Person();
        Address a=new Address();

        //heap memory
        a.setCity("Lucknow");
        a.setCountry("India");
        a.setNumber("45678");
        a.setZipcode("23456");
        a.setStreetName("dlf");

        p.setLovesJava(true);

        p.setName("Pranaw");
        p.setYearOfBirth(1997);

        //connect address and person
        p.setAddress(a);


    }
}
