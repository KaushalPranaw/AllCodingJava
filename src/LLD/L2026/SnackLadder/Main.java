package LLD.L2026.SnackLadder;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Player p1 = new Player("1", "Aman");
        Player p2 = new Player("2", "Rahul");

        List<Player> players = Arrays.asList(p1, p2);

        Game game = new Game(players);
        game.start();
    }
}
