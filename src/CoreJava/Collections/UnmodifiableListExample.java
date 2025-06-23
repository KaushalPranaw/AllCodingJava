package CoreJava.Collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;

public class UnmodifiableListExample {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList("A", "B", "C"));
        List<String> unmodifiableList = Collections.unmodifiableList(list);

        System.out.println("Original list: " + unmodifiableList);

        // Modifying the original list is allowed
        list.add("D");
        System.out.println("Modified original list: " + unmodifiableList); // Will reflect changes

        // Attempting to modify the unmodifiable list will throw an exception
        try {
            unmodifiableList.add("E");  // This will throw UnsupportedOperationException
        } catch (UnsupportedOperationException e) {
            System.out.println("Cannot modify the unmodifiable list: " + e);
        }

        // Modifying the underlying list directly works
        list.set(0, "Z");
        System.out.println("Modified original list: " + unmodifiableList); // Will reflect changes

        try {
            unmodifiableList.set(0, "E");  // This will throw UnsupportedOperationException
        } catch (UnsupportedOperationException e) {
            System.out.println("Cannot modify the unmodifiable list: " + e);
        }
    }
}
