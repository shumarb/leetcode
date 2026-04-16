// Question: https://leetcode.com/problems/battleships-in-a-board/description/

class BattleshipsInABoard {
    private boolean isTest;
    private char[][] board;
    private int m;
    private int n;

    public int countBattleships(char[][] board) {
        int result = 0;
        isTest = false;
        m = board.length;
        n = board[0].length;
        this.board = board;

        if (isTest) {
            print("before:");
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'X') {
                    if (isTest) {
                        System.out.println("battleship @ [" + i + ", " + j + "]");
                    }
                    dfs(i, j);
                    result++;
                    if (isTest) {
                        System.out.println("----------------------");
                    }
                }
            }
        }
        if (isTest) {
            print("----------------------\nafter:");
            System.out.println("result: " + result);
        }

        return result;
    }

    private void dfs(int row, int column) {
        if (row < 0 || row >= m || column < 0 || column >= n || board[row][column] == '.') {
            return;
        }

        if (isTest) {
            System.out.println(" * current: [" + row + ", " + column + "]");
        }

        // 1. Mark cell as visited so it won't be checked again and to avoid stack overflow.
        board[row][column] = '.';

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
        System.out.println("----------------------");
    }
}
