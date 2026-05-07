package May2026.LLD.Day2.abstractfactory;

public class Main {
    public static void main(String[] args) {
        FurnitureFactory factory;
        //factory = new ModernFurnitureFactory();
        //just using one line - we changed entire UI
        factory = new VictorianFurnitureFactory();
        Chair chair = factory.createChair();
        chair.sitOn();
        Sofa sofa = factory.createSofa();
        sofa.lieOn();
    }
}
