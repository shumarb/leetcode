// Question: https://leetcode.com/problems/surrounded-regions/description/

class SurroundedRegions {
    private char[][] board;
    private int m;
    private int n;

    public void solve(char[][] board) {
        boolean isTest = false;
        m = board.length;
        n = board[0].length;
        this.board = board;

        if (isTest) {
            print("initial, board: ");
        }

        // 1. Mark cells reachable from border as safe.
        for (int i = 0; i < m; i++) {
            dfs(i, 0);
            dfs(i, n - 1);
        }
        for (int j = 0; j < n; j++) {
            dfs(0, j);
            dfs(m - 1, j);
        }
        if (isTest) {
            print("board after marking safe: ");
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '#') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
        if (isTest) {
            print("final board: ");
        }
    }

    private void dfs(int row, int column) {
        if (row < 0 || row >= m || column < 0 || column >= n || board[row][column] == '#' || board[row][column] == 'X') {
            return;
        }

        board[row][column] = '#';
        dfs(row - 1, column);
        dfs(row + 1, column);
        dfs(row, column - 1);
        dfs(row, column + 1);
    }

    private void print(String s) {
        System.out.println(s);
        for (char[] row: board) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println("-----------------------------");
    }
}
