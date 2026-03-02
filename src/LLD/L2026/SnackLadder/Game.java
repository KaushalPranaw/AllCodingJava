package LLD.L2026.SnackLadder;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Game {
    Queue<Player> players;
    Board board;
    Dice dice;

    public Game(List<Player> playerList){
        this.players=new LinkedList<>(playerList);
        this.board=new Board();
        this.dice=new Dice();
    }

    public void start(){
        while (true){
            Player player=players.poll();

            int roll= dice.roll();
            System.out.println(player.name + " rolled " + roll);

            int newPos=player.position+roll;

            if(newPos<=100){
                newPos=board.getNextPosition(newPos);
                player.position=newPos;
            }

            System.out.println(player.name + " moved to " + player.position);

            if(player.position == 100) {
                System.out.println(player.name + " wins!");
                break;
            }

            players.add(player);
        }
    }

}
