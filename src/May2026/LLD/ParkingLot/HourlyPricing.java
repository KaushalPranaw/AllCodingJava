package May2026.LLD.ParkingLot;

public class HourlyPricing implements PricingStrategy {

    @Override
    public double calculate(long entry, long exit, VehicleType type) {
        long diffHours = exit - entry;
        long hours = diffHours / (1000 * 60 * 60);
        if (hours == 0) {
            hours = 1;//min 1hour calculating
        }
        if (type.equals(VehicleType.CAR)) {
            return hours * 30;
        }
        return hours * 20;
    }
}
