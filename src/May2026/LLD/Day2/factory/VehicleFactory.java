package May2026.LLD.Day2.factory;

public class VehicleFactory {
    public static Vehicle getVehicle(String type){
        if(type.equalsIgnoreCase("car")){
            return new Car();
        }else if(type.equalsIgnoreCase("bike")){
            return new Bike();
        }

        throw new UnsupportedOperationException("invalid type");
    }
}
