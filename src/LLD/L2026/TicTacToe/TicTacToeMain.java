package LLD.L2026.TicTacToe;

public class TicTacToeMain {
    public static void main(String[] args) {
        Player p1 = new Player("1", "Pranaw", 'X');
        Player p2 = new Player("2", "Rahul", 'O');

        Game game = new Game(p1, p2, 3);

        System.out.println("Game Started!");
        game.getBoard().printBoard();

        game.makeMove(0,0); // P1
        game.getBoard().printBoard();

        game.makeMove(1,1); // P2
        game.getBoard().printBoard();

        game.makeMove(0,1); // P1
        game.getBoard().printBoard();

        game.makeMove(2,2); // P2
        game.getBoard().printBoard();

        game.makeMove(0,2); // P1 -> WIN
        game.getBoard().printBoard();

        if(game.getStatus().equals("WIN")) {
            System.out.println("Winner is: " + game.getWinner().getId());
        }
        else if(game.getStatus().equals("DRAW")) {
            System.out.println("Game Draw!");
        }
    }
}
