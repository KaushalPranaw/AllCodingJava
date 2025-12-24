package Leetcode.Leetcode150.GraphGeneral;

public class SurroundedRegions {
    public static void main(String[] args) {
        SurroundedRegions sr = new SurroundedRegions();

        char[][] board = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}
        };

        System.out.println("Before:");
        printBoard(board);

        sr.solve(board);

        System.out.println("\nAfter:");
        printBoard(board);
    }
    private static void printBoard(char[][] board) {
        for (char[] row : board) {
            for (char c : row) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }

    public void solve(char[][] board) {
        if (board == null || board.length == 0) return;

        int m = board.length;
        int n = board[0].length;

        int[][] vis = new int[m][n];

        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};


        //first & last row
        for (int j = 0; j < n; j++) {
            // first row
            if (board[0][j] == 'O' && vis[0][j] == 0) {
                dfs(0, j, board, vis, delRow, delCol, m, n);
            }
            //last row
            if (board[m - 1][j] == 'O' && vis[m - 1][j] == 0) {
                dfs(m - 1, j, board, vis, delRow, delCol, m, n);
            }
        }

        //first & last col
        for (int i = 0; i < m; i++) {
            // first col
            if (board[i][0] == 'O' && vis[i][0] == 0) {
                dfs(i, 0, board, vis, delRow, delCol, m, n);
            }
            //last col
            if (board[i][n - 1] == 'O' && vis[i][n - 1] == 0) {
                dfs(i, n - 1, board, vis, delRow, delCol, m, n);
            }
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                //humne boundary se start and kia aur dekha kon kon sa use ni hua hai
                //mtlb ulta so usko 1 mark kr skte h
                if(vis[i][j]==0 && board[i][j]=='O'){
                    board[i][j]='X';
                }
            }
        }
    }

    private void dfs(int row, int col, char[][] board, int[][] vis, int[] delRow, int[] delCol, int m, int n) {
        vis[row][col] = 1;
        for (int i = 0; i < 4; i++) {
            int nr = row + delRow[i];
            int nc = col + delCol[i];

            if (nr >= 0 && nr < m && nc >= 0 && nc < n && board[nr][nc] == 'O' && vis[nr][nc] == 0) {
                dfs(nr, nc, board, vis, delRow, delCol, m, n);
            }
        }
    }
}
