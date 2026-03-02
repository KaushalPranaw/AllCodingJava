package LLD.L2026.TicTacToe;

public class Player {
    private String id;
    private String name;
    private char symbol;

    public Player(String id, String name, char symbol) {
        this.id = id;
        this.name = name;
        this.symbol = symbol;
    }

    public String getId() {
        return id;
    }

    public char getSymbol() {
        return symbol;
    }
}
