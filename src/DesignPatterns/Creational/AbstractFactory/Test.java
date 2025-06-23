package DesignPatterns.Creational.AbstractFactory;

public class Test {
    public static void main(String[] args) {
        FurnitureFactory modernFactory = new ModernFurnitureFactory();
        Chair modernChair = modernFactory.createChair();
        Sofa modernSofa = modernFactory.createSofa();
        Table modernTable = modernFactory.createTable();
        modernChair.sitOn();  // Output: Sitting on a modern chair
        modernSofa.lieOn();   // Output: Lying on a modern sofa
        modernTable.eatAt();  // Output: Eating at a modern table

        FurnitureFactory classicFactory = new ClassicFurnitureFactory();
        Chair victorianChair = classicFactory.createChair();
        Sofa victorianSofa = classicFactory.createSofa();
        Table victorianTable = classicFactory.createTable();
        victorianChair.sitOn();  // Output: Sitting on a Victorian chair
        victorianSofa.lieOn();   // Output: Lying on a Victorian sofa
        victorianTable.eatAt();  // Output: Eating at a Victorian table


    }
}
