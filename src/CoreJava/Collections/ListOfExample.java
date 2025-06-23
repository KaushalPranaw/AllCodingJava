package CoreJava.Collections;

import java.util.List;

public class ListOfExample {
    public static void main(String[] args) {
        List<String> list = List.of("A", "B", "C");
        System.out.println("Original list: " + list);
        try {
            list.add("D");
        } catch (UnsupportedOperationException e) {
            System.out.println("Cannot modify the list: " + e);
        }

        try {
            list.set(0, "Z");
        } catch (UnsupportedOperationException e) {
            System.out.println("Cannot modify the list: " + e);
        }
    }
}
