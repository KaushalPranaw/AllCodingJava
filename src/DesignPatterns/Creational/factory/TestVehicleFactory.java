package DesignPatterns.Creational.factory;

public class TestVehicleFactory {
    public static void main(String[] args) {
        Vehicle car = VehicleFactory.createVehicle("car");
        car.drive();

        Vehicle bus = VehicleFactory.createVehicle("bus");
        bus.drive();

        Vehicle bike = VehicleFactory.createVehicle("bike");
        bike.drive();


    }
}
