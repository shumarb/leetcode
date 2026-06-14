// Question: https://leetcode.com/problems/game-of-life/description/

class GameOfLife {
    private boolean isTest;
    private int[][] board;
    private int[][] result;
    private int m;
    private int n;

    public void gameOfLife(int[][] board) {
        isTest = false;
        m = board.length;
        n = board[0].length;
        result = new int[m][n];
        this.board = board;

        if (isTest) {
            print("before:");
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                update(i, j);
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = result[i][j];
            }
        }
        if (isTest) {
            print("-----------------------------\nafter");
        }
    }

    private void print(String s) {
        System.out.println(s + "\nboard:");
        for (int[] row: board) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println("\nresult");
        for (int[] row: result) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println("-----------------------------");
    }

    private void update(int i, int j) {
        int[][] directions = {
                {-1, -1},
                {-1, 0},
                {-1, 1},
                {1, -1},
                {1, 0},
                {1, 1},
                {0, 1},
                {0, -1}
        };
        int countDead = 0;
        int countLives = 0;
        int element = board[i][j];

        for (int[] d: directions) {
            int nextColumn = d[1] + j;
            int nextRow = d[0] + i;

            if (nextColumn < 0 || nextColumn >= n || nextRow < 0 || nextRow >= m) {
                continue;
            }

            if (board[nextRow][nextColumn] == 0) {
                countDead++;
            } else {
                countLives++;
            }
        }
        if (isTest) {
            System.out.println("[" + i + ", " + j + "]: " + element + " | countDead: " + countDead + " | countLives: " + countLives);
        }
        if (element == 1) {
            if (countLives < 2 || countLives > 3) {
                result[i][j] = 0;
            } else {
                result[i][j] = 1;
            }

        } else {
            if (countLives == 3) {
                result[i][j] = 1;
            }
        }
    }
}
