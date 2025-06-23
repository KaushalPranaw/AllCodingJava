package CoreJava.MemoryManagement.immutable;

import java.util.*;

class Course {
    private String name;

    public Course(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                '}';
    }
}


final class Student {
    private String name;
    private int regNo;
    private Map<String, String> metadata;
    private List<Course> courses;

    public Student(String name, int regNo, Map<String, String> metadata, List<Course> courses) {
        this.name = name;
        this.regNo = regNo;

        Map<String, String> tempMap = new HashMap<>();
        for (Map.Entry<String, String> entry : metadata.entrySet()) {
            tempMap.put(entry.getKey(), entry.getValue());
        }
        this.metadata = tempMap;

        // Deep copy of courses list
        List<Course> tempCourses = new ArrayList<>();
        for (Course course : courses) {
            tempCourses.add(new Course(course.getName())); // Copy by creating a new Course object
        }
        this.courses = Collections.unmodifiableList(tempCourses);
    }

    public String getName() {
        return name;
    }

    public int getRegNo() {
        return regNo;
    }

    public Map<String, String> getMetadata() {
        Map<String, String> tempMap = new HashMap<>();
        for (Map.Entry<String, String> entry : metadata.entrySet()) {
            tempMap.put(entry.getKey(), entry.getValue());
        }
        return tempMap;
    }

    public List<Course> getCourses() {
        // Deep copy of courses list
        List<Course> tempCourses = new ArrayList<>();
        for (Course course : courses) {
            tempCourses.add(new Course(course.getName())); // Copy by creating a new Course object
        }
        return Collections.unmodifiableList(tempCourses);
    }
}

public class TestStudent {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        // Adding elements to Map object
        // using put() method
        map.put("1", "first");
        map.put("2", "second");

        List<Course> courses = new ArrayList<>(Arrays.asList(new Course("pranaw")));

        Student s = new Student("ABC", 101, map, courses);

        // Calling the above methods 1,2,3 of class1
        // inside main() method in class2 and
        // executing the print statement over them
        System.out.println(s.getName());
        System.out.println(s.getRegNo());
        System.out.println(s.getMetadata());
        System.out.println(s.getCourses());

        /*// Uncommenting below line causes error
        //s.regNo = 102; // compile time error

        map.put("3", "third");
        // Remains unchanged due to deep copy in constructor
        System.out.println(s.getMetadata());
        s.getMetadata().put("4", "fourth");
        // Remains unchanged due to deep copy in getter
        System.out.println(s.getMetadata());*/

        //s.getCourses().add(new Course("Java"));
        s.getCourses().get(0).setName("Java");
        System.out.println(s.getCourses());

    }

}
