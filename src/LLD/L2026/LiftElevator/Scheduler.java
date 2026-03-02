package LLD.L2026.LiftElevator;

import java.util.List;

public class Scheduler {
    public Lift assignLift(List<Lift> lifts, Request request){
        Lift bestLift=null;
        int minDistance=Integer.MAX_VALUE;
        for(Lift lift: lifts){
            int distance=Math.abs(lift.currentFloor-request.sourceFloor);
            if(distance<minDistance){
                minDistance=distance;
                bestLift=lift;
            }
        }
        return bestLift;
    }
}
