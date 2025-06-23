package DesignPatterns.Creational.AbstractFactory;

public class ClassicTable implements Table {
    @Override
    public void eatAt() {
        System.out.println("Eating at classic table");
    }
}
