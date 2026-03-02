package LLD.L2026.LiftElevator;

import java.util.LinkedList;
import java.util.Queue;

public class Lift {
    int id;
    int currentFloor;
    Direction direction;
    LiftStatus status;
    Queue<Request> requests;
    Door door;

    public Lift(int liftId) {
        this.id = liftId;
        this.currentFloor=0;
        this.direction=Direction.IDLE;
        this.status=LiftStatus.STOPPED;
        this.requests=new LinkedList<>();
        this.door=new Door();
    }

    public void addRequest(Request request){
        requests.add(request);
    }

    public void move(){
        if(requests.isEmpty()){
            return;
        }

        Request request=requests.poll();
        moveToFloor(request.sourceFloor);
        door.open();
        door.close();
        moveToFloor(request.destinationFloor);
        door.open();
        door.close();
    }
    private void moveToFloor(int floor) {
        System.out.println("Lift " + id + " moving from "
                + currentFloor + " to " + floor);
        currentFloor = floor;
    }
}
