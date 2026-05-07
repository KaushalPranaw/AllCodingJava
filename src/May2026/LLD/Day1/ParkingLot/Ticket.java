package May2026.LLD.Day1.ParkingLot;

public class Ticket {
    static int counter=1;
    int id;
    Vehicle vehicle;
    long entryTime;
    long exitTime;
    ParkingSpot spot;

    public Ticket(Vehicle vehicle, ParkingSpot spot) {
        this.vehicle = vehicle;
        this.spot = spot;
        this.id=counter++;
        this.entryTime=System.currentTimeMillis();
    }
}
