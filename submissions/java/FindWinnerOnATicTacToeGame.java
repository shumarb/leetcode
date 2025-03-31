// Question: https://leetcode.com/problems/find-winner-on-a-tic-tac-toe-game/description/

class FindWinnerOnATicTacToeGame {
    public String tictactoe(int[][] moves) {
        boolean isTest = false;
        int countFilledCells = 0;
        int[][] grid = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                grid[i][j] = -1;
            }
        }

        for (int i = 0; i < moves.length; i++) {
            int[] move = moves[i];
            if (i % 2 == 0) {
                grid[move[0]][move[1]] = 1;
                if (isTest) {
                    System.out.println("checking for player A: 1");
                    display(grid);
                }
                if (isWinner(grid, 1)) {
                    return "A";
                }
            } else {
                grid[move[0]][move[1]] = 0;
                if (isTest) {
                    System.out.println("checking for player B: 0");
                    display(grid);
                }
                if (isWinner(grid, 0)) {
                    return "B";
                }
            }
            countFilledCells++;
        }

        return countFilledCells == 9 ? "Draw" : "Pending";
    }

    private void display(int[][] grid) {
        System.out.println("grid:");
        for (int[] row: grid) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println("--------------------------------------------------------------");
    }

    private boolean isWinner(int[][] grid, int playerCode) {
        if (grid[0][0] == playerCode && grid[1][1] == playerCode && grid[2][2] == playerCode) {
            return true;
        }

        if (grid[2][0] == playerCode && grid[1][1] == playerCode && grid[0][2] == playerCode) {
            return true;
        }

        for (int[] row: grid) {
            if (row[0] == playerCode && row[1] == playerCode && row[2] == playerCode) {
                return true;
            }
        }

        for (int i = 0; i < 3; i++) {
            if (grid[0][i] == playerCode && grid[1][i] == playerCode && grid[2][i] == playerCode) {
                return true;
            }
        }

        return false;
    }
}