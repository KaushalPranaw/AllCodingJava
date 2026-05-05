package May2026.LLD.ParkingLot;

public interface PricingStrategy {
    double calculate(long entry, long exit, VehicleType type);
}
