package DesignPatterns.Creational.AbstractFactory;

//Abstract factory
public interface FurnitureFactory {
    Chair createChair();
    Table createTable();
    Sofa createSofa();
}
