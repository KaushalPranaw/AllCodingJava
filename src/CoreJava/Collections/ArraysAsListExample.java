package CoreJava.Collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ArraysAsListExample {
    public static void main(String[] args) {
        /*List<String> list = Arrays.asList("A", "B", "C");
        System.out.println("Original list: " + list);
        try {
            list.set(0, "Z");
            System.out.println("Modified list: " + list);
        } catch (UnsupportedOperationException e) {
            System.out.println("Cannot modify the list: " + e);
        }

        try {
            list.add("D");
        } catch (UnsupportedOperationException e) {
            System.out.println("Cannot modify the list: " + e);
        }
*/

        List<String> list = new ArrayList<>(Arrays.asList("A", "B", "C"));
        /*for (String s : list) {
            System.out.println(s);
            list.add("D");
        }*/
        Iterator<String> itr = list.listIterator();

        while (itr.hasNext()){
            System.out.println(itr.next());
            list.remove(0);
        }
    }
}
