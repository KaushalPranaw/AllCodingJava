package May2026.LLD.ParkingLot;

public class ParkingSpot {
    int id;
    VehicleType type;
    boolean isAvailable;
    Vehicle vehicle;

    public ParkingSpot(int id, VehicleType type) {
        this.id = id;
        this.type = type;
        //in starting spot is available
        this.isAvailable = true;
    }

    boolean assignVehicle(Vehicle vehicle) {
        if (isAvailable && this.type == vehicle.type) {
            this.vehicle = vehicle;
            isAvailable = false;
            return true;
        }
        return false;
    }

    void removeVehicle(){
        this.vehicle=null;
        isAvailable=false;
    }
}
