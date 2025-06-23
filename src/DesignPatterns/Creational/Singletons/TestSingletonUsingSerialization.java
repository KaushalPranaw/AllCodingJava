package DesignPatterns.Creational.Singletons;

import java.io.*;

public class TestSingletonUsingSerialization {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Singleton instance1 = Singleton.getInstance();
        ObjectOutput out = new ObjectOutputStream(
                new FileOutputStream("file.text"));
        out.writeObject(instance1);
        out.close();

        // deserialize from file to object
        ObjectInput in = new ObjectInputStream(
                new FileInputStream("file.text"));

        Singleton instance2
                = (Singleton) in.readObject();
        in.close();

        System.out.println("instance1 hashCode:- "
                + instance1.hashCode());
        System.out.println("instance2 hashCode:- "
                + instance2.hashCode());
    }
}
