package CoreJava.OOPS.Serialization;

import java.io.*;

class Demo implements Serializable {
    private int a;
    private String b;

    public Demo(int a, String b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public String toString() {
        return "Demo{" +
                "a=" + a +
                ", b='" + b + '\'' +
                '}';
    }
}

public class TestDemo {
    public static void main(String[] args) {
        Demo demo = new Demo(1, "pranaw");
        String fileName = "file.ser";

        try {
            FileOutputStream fos = new FileOutputStream(fileName);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(demo);
            oos.close();
            fos.close();
            System.out.println("Object has been serialized");
        } catch (IOException e) {
            System.out.println("IOException is caught" + e);
        }

        Demo demo1 = null;
        try {
            FileInputStream fis = new FileInputStream(fileName);
            ObjectInputStream ois = new ObjectInputStream(fis);
            demo1 = (Demo) ois.readObject();
            ois.close();
            fis.close();
            System.out.println("Object has been deserialized");
            System.out.println(demo1);
        } catch (IOException e) {
            System.out.println("IOException is caught" + e);
        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFoundException is caught" + e);
        }
    }
}
