package CoreJava.Collections;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class ArrayList6 {
    public static void main(String[] args) {
        // Create an ArrayList and add elements to it
        ArrayList<String> al = new ArrayList<String>();
        al.add("Ravi");
        al.add("Vijay");
        al.add("Ajay");
        try {
            // Serialization
            FileOutputStream fos = new FileOutputStream("file");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(al); // Write the ArrayList object to the file
            fos.close();
            oos.close();

            // Deserialization
            FileInputStream fis = new FileInputStream("file");
            ObjectInputStream ois = new ObjectInputStream(fis);
            // Read the ArrayList object from the file and cast it to ArrayList<String>
            ArrayList list = (ArrayList) ois.readObject();
            System.out.println(list); // Print the deserialized ArrayList
            ois.close();
            fis.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
