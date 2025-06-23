package DesignPatterns.Creational.factory;

public class VehicleFactory {
    public static Vehicle createVehicle(String type) {
        if (type.equalsIgnoreCase("car"))
            return new Car();
        else if (type.equalsIgnoreCase("bike"))
            return new Bike();
        else if (type.equalsIgnoreCase("bus"))
            return new Bus();
        else throw new IllegalArgumentException("Unknown vehicle type");
    }
}
