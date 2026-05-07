package May2026.LLD.Day1.ParkingLot;

public interface PricingStrategy {
    double calculate(long entry, long exit, VehicleType type);
}
