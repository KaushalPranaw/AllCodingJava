package May2026.LLD.Day2.abstractfactory;

public class ModernFurnitureFactory implements FurnitureFactory {
    public Sofa createSofa(){
        return new ModernSofa();
    }
    public Chair createChair(){
        return new ModernChair();
    }
}
