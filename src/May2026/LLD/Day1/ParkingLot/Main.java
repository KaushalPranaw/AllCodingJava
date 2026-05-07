package May2026.LLD.Day1.ParkingLot;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ParkingLot lot=new ParkingLot();
        Vehicle car=new Car("HR28AB1234");
        Vehicle bike=new Bike("HR28AB2344");
        //park vehicle
        Ticket ticket=lot.parkVehicle(car);
        Ticket ticket2=lot.parkVehicle(bike);
        Thread.sleep(2000);
        PricingStrategy pricingStrategy=new HourlyPricing();
        //unpark
        lot.exitVehicle(ticket, pricingStrategy);
        lot.exitVehicle(ticket2, pricingStrategy);
    }
}
