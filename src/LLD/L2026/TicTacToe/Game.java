package LLD.L2026.TicTacToe;

public class Game {
    private String id;
    private Player player1;
    private Player player2;
    private Player currentTurn;
    private Board board;
    private String status;
    private Player winner;

    public Game(Player player1, Player player2, int size) {
        this.player1 = player1;
        this.player2 = player2;
        this.currentTurn = player1;

        this.board = new Board(size);
        this.status = "ONGOING";
    }

    public Board getBoard() {
        return board;
    }

    public String getStatus() {
        return status;
    }

    public Player getWinner() {
        return winner;
    }

    public boolean makeMove(int row, int col) {
        boolean movePlaced = board.placeMove(row, col, currentTurn.getSymbol());
        if(!movePlaced) {
            System.out.println("Invalid move! Try again.");
            return false;
        }

        if(checkWinner(row, col)) {
            status = "WIN";
            winner = currentTurn;
        }
        else if(isBoardFull()) {
            status = "DRAW";
        }
        else {
            switchTurn();
        }
        return true;
    }

    private void switchTurn() {
        currentTurn = (currentTurn == player1) ? player2 : player1;
    }

    private boolean checkWinner(int row, int col){
        char symbol= currentTurn.getSymbol();
        char[][] grid= board.getGrid();

        int size=grid.length;

        boolean winRow=true, winCol=true, winDiagonal=true, winAntiDiagonal=true;

        for(int i=0; i<size;i++){
            if(grid[row][i] != symbol) winRow=false;
            if(grid[i][col] != symbol) winCol=false;
            if(grid[i][i] != symbol) winDiagonal=false;
            if(grid[i][size-1-i] != symbol) winAntiDiagonal=false;
        }
        return false;
    }

    private boolean isBoardFull() {
        char[][] grid = board.getGrid();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (grid[i][j] == '\0') return false;
            }
        }
        return true;
    }

}
