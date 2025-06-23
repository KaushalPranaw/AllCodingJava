package CoreJava.Collections;

import java.util.ArrayList;

public class C01_ArrayListExample {
    /*public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();//Creating arraylist
        list.add("Mango");//Adding object in arraylist
        list.add("Apple");
        list.add("Banana");
        list.add("Grapes");
        //Printing the arraylist object
        //System.out.println(list);
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }*/

    public static void main(String[] args) {
        ArrayList<String> al = new ArrayList<String>();
        al.add("Mango");
        al.add("Apple");
        al.add("Banana");
        al.add("Grapes");
        //accessing the element
        System.out.println();
        System.out.println("Returning element: " + al.get(1));//it will return the 2nd element, because index starts from 0
        //changing the element
        al.set(1, "Dates");
        System.out.println();
        //Traversing list
        for (String fruit : al)
            System.out.println(fruit);
    }
}
