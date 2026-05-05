package May2026.LLD.ParkingLot;

public abstract class Vehicle {
    String number;
    VehicleType type;

    public Vehicle(String number, VehicleType type) {
        this.number = number;
        this.type = type;
    }
}
