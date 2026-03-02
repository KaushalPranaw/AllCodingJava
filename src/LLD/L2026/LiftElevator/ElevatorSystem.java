package LLD.L2026.LiftElevator;

import java.util.ArrayList;
import java.util.List;

public class ElevatorSystem {
    List<Lift> lifts;
    Scheduler scheduler;

    public  ElevatorSystem(int liftCount){
        lifts=new ArrayList<>();
        for(int i=0;i<liftCount;i++){
            lifts.add(new Lift(i));
        }
        scheduler=new Scheduler();
    }

    public void requestLift(int source, int dest){
        Direction direction=dest>source?Direction.UP:Direction.DOWN;
        Request request=new Request(source, dest, direction, RequestType.EXTERNAL);
        Lift lift=scheduler.assignLift(lifts, request);
        lift.addRequest(request);
        lift.move();
    }
}
