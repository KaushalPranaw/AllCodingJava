package May2026.LLD.Day2.singleton;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // 1. Normal instance check
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        System.out.println("Same instance (normal): " + (logger1 == logger2));

        // 2. Serialization check
        ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream("logger.ser"));
        out.writeObject(logger1);
        out.close();

        ObjectInputStream in = new ObjectInputStream(
                new FileInputStream("logger.ser"));
        Logger logger3 = (Logger) in.readObject();
        in.close();

        System.out.println("Same after serialization: " + (logger1 == logger3));

        // 3. Reflection attack test
        try {
            var constructor = Logger.class.getDeclaredConstructor();
            constructor.setAccessible(true);
            Logger logger4 = constructor.newInstance(); // should fail
        } catch (Exception e) {
            System.out.println("Reflection blocked: " + e.getMessage());
        }

        // 4. Cloning test
        try {
            Logger logger5 = (Logger) logger1.clone();
        } catch (Exception e) {
            System.out.println("Cloning blocked: " + e.getMessage());
        }
    }
}
