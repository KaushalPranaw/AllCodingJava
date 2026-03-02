package LLD.L2026.LiftElevator;

public class Main {
    public static void main(String[] args) {
        ElevatorSystem system = new ElevatorSystem(3);

        system.requestLift(2, 7);
        system.requestLift(5, 1);
    }
}
