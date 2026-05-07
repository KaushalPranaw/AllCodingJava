package May2026.LLD.Day2.abstractfactory;

public class VictorianFurnitureFactory implements FurnitureFactory {
    public Sofa createSofa(){
        return new VictorianSofa();
    }
    public Chair createChair(){
        return new VictorianChair();
    }
}
