package Leetcode.Backtracking;

public class WordSearch {
    public static void main(String[] args) {
        char[][] board1 = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word1 = "ABCCED";
        System.out.println(new WordSearch().exist(board1, word1)); // Output: true

    }

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        //iterating and checking first char of word
        //if found then call find function

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(board, word, i, j, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int row, int col, int count) {
        int m = board.length;
        int n = board[0].length;

        //base case
        if (count == word.length()) {
            return true;
        }


        // Check if out of bounds OR the current cell doesn't match the character we want
        if (row < 0 || row >= m || col < 0 || col >= n || word.charAt(count) != board[row][col]) {
            return false;
        }


        //hum charo directions me jake check krege
        int[] delrow = {-1, 0, 1, 0};
        int[] delcol = {0, 1, 0, -1};
        char temp = board[row][col];
        board[row][col] = '#';

        for (int i = 0; i < 4; i++) {
            int nr = row + delrow[i];
            int nc = col + delcol[i];
            if (dfs(board, word, nr, nc, count + 1)) {
                return true;
            }
        }

        board[row][col] = temp;
        return false;

    }

}
