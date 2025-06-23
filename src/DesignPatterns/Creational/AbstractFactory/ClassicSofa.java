package DesignPatterns.Creational.AbstractFactory;

public class ClassicSofa implements Sofa {
    @Override
    public void lieOn() {
        System.out.println("lying on classic sofa");
    }
}
