package LLD.L2026.SnackLadder;

import java.util.HashMap;
import java.util.Map;

public class Board {
    int size=100;
    Map<Integer, Integer> snakes=new HashMap<>();
    Map<Integer, Integer> ladders=new HashMap<>();

    public Board(){
        snakes.put(99, 10);
        snakes.put(70, 55);

        ladders.put(5, 25);
        ladders.put(40, 80);
    }

    public int getNextPosition(int pos){
        if(snakes.containsKey(pos)){
            return snakes.get(pos);
        }
        if(ladders.containsKey(pos)){
            return ladders.get(pos);
        }
        return pos;
    }



}
