package DesignPatterns.Creational.Singletons;

import java.io.Serializable;

class SuperClass implements Cloneable {

    int i = 10;

    @Override
    protected Object clone()
            throws CloneNotSupportedException
    {
        return super.clone();
    }
}

public class Singleton extends SuperClass implements Serializable {
    private static Singleton instance;

    private Singleton() {
        // Prevent reflection from breaking the singleton pattern
        if (instance != null) {
            throw new IllegalStateException("Cannot instantiate singleton using reflection.");
        }

    }

    public static Singleton getInstance() {
        if (instance == null)
            instance = new Singleton();
        return instance;
    }

    // Implement readResolve to ensure that deserialization returns the same instance
    private Object readResolve() {

        return instance;
    }

    // Override clone to prevent cloning
    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("Cloning not allowed for Singleton class.");
    }

}
