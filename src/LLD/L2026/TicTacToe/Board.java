package LLD.L2026.TicTacToe;

public class Board {
    private char[][] grid;
    private int size;

    public Board(int size) {
        this.size=size;
        grid=new char[size][size];
    }

    public char[][] getGrid() {
        return grid;
    }

    public boolean placeMove(int row, int col, char symbol){
        if(grid[row][col]=='\0'){
            grid[row][col]=symbol;
            return true;
        }
        return false;
    }

    public void printBoard() {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                System.out.print((grid[i][j] == '\0' ? "-" : grid[i][j]) + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
