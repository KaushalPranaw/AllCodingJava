package DesignPatterns.Creational.Singletons;

import java.lang.reflect.Constructor;

public class TestSingletonUsingReflection {
    public static void main(String[] args) {
        Singleton instance1 = Singleton.getInstance();
        Singleton instance2 = null;

        try {
            Constructor[] constructors = Singleton.class.getDeclaredConstructors();
            for (Constructor constructor : constructors) {
                constructor.setAccessible(true);
                instance2 = (Singleton) constructor.newInstance();
                break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("instance1.hashCode(): " + instance1.hashCode());
        if (instance2 != null) {
            System.out.println("instance2.hashCode(): " + instance2.hashCode());
        } else {
            System.out.println("instance2 could not be created.");
        }
    }
}
