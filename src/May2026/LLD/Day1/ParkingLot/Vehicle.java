package May2026.LLD.Day1.ParkingLot;

public abstract class Vehicle {
    String number;
    VehicleType type;

    public Vehicle(String number, VehicleType type) {
        this.number = number;
        this.type = type;
    }
}
