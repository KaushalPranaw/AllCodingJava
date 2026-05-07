package May2026.LLD.Day1.ParkingLot;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private List<ParkingSpot> spots=new ArrayList<>();
    ParkingLot() {
        // create spots
        spots.add(new ParkingSpot(1, VehicleType.CAR));
        spots.add(new ParkingSpot(2, VehicleType.CAR));
        spots.add(new ParkingSpot(3, VehicleType.BIKE));
    }

    ParkingSpot findSpot(Vehicle v){
        for(ParkingSpot spot: spots){
            if(spot.isAvailable && spot.type==v.type){
                return spot;
            }
        }
        return null;
    }

    Ticket parkVehicle(Vehicle vehicle){
        ParkingSpot spot=findSpot(vehicle);
        if(spot==null){
            System.out.println("No Spot available");
            return null;
        }
        spot.assignVehicle(vehicle);
        Ticket ticket=new Ticket(vehicle, spot);
        System.out.println("Vehicle parked. Ticket ID: " + ticket.id);
        return ticket;

    }

    double exitVehicle(Ticket ticket, PricingStrategy strategy){
        ticket.exitTime=System.currentTimeMillis();
        ticket.spot.removeVehicle();

        double amount=strategy.calculate(ticket.entryTime, ticket.exitTime, ticket.vehicle.type);
        System.out.println("Vehicle exited. Amount: ₹" + amount);
        return amount;
    }
}
