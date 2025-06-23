package DesignPatterns.Behavioural.Observer;

public class Test {
    public static void main(String[] args) {
        // Create the weather station (subject)
        WeatherStation weatherStation = new WeatherStation();
        // Create observers
        MobileApp mobileApp = new MobileApp();
        DisplayBoard displayBoard = new DisplayBoard();
        SmartThermostat smartThermostat = new SmartThermostat();
        // Subscribe observers to the weather station
        weatherStation.addObserver(mobileApp);
        weatherStation.addObserver(displayBoard);
        weatherStation.addObserver(smartThermostat);
        // Change the temperature and notify all observers
        System.out.println("Setting temperature to 30°C...");
        weatherStation.setTemperature(30.0f);
        System.out.println("\nSetting temperature to 18°C...");
        weatherStation.setTemperature(18.0f);

    }
}
