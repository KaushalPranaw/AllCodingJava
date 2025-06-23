package CoreJava.MultiThreading.EvenOddGenerator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;

import java.util.Date;

final class Person {
    private final String name;
    private final Date birthDate;

    /**
     * Creates a Person with the given name and birth date.
     */
    public Person(String name, Date birthDate) {
        if (name == null || birthDate == null) {
            throw new IllegalArgumentException("Name and birth date cannot be null.");
        }
        this.name = name;
        // Defensive copy of the mutable Date object
        this.birthDate = new Date(birthDate.getTime());
    }

    /**
     * Gets the name of the person.
     *
     * @return the name of the person.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the birth date of the person.
     *
     * @return a defensive copy of the birth date.
     */
    public Date getBirthDate() {
        // Return a defensive copy to protect immutability
        return new Date(birthDate.getTime());
    }
}


public class Sample {
    public static void main(String[] args) {
        HashSet s=new HashSet();
        s.add(new Integer(1));
        s.add(new Integer(1));
        s.add(new Integer(2));
    }

    public  void readFile(String fileName){
        try {
            List<String> lines= Files.readAllLines(Paths.get(fileName));
            lines.stream().forEach(System.out::println);
        } catch (IOException e1){

        }catch (Exception e){

        }
    }
}
