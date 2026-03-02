package LLD.L2026.LiftElevator;

public class Request {
    int sourceFloor;
    int destinationFloor;
    Direction direction;
    RequestType type;

    public Request(int sourceFloor, int destinationFloor, Direction direction, RequestType type) {
        this.sourceFloor = sourceFloor;
        this.destinationFloor = destinationFloor;
        this.direction = direction;
        this.type = type;
    }
}
